package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ParcelUtils {
    private static final String INNER_BUNDLE_KEY = "a";

    private ParcelUtils() {
    }

    public static <T extends VersionedParcelable> T fromInputStream(InputStream r2) {
        return (T) new VersionedParcelStream(r2, null).readVersionedParcelable();
    }

    public static <T extends VersionedParcelable> T fromParcelable(Parcelable r2) {
        Parcelable r3 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r2, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ParcelImpl.class) == false) goto L7;
        return (T) ((ParcelImpl) ZeusTransformUtils.preCheckCast(r3, ParcelImpl.class, "com.obric.memorydata.plugin")).getVersionedParcel();
    L7:
        throw new IllegalArgumentException("Invalid parcel");
    }

    public static <T extends VersionedParcelable> T getVersionedParcelable(Bundle r2, String r3) {
        Bundle r4 = (Bundle) ZeusTransformUtils.preCheckCast(r2.getParcelable(r3), Bundle.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L8
        if (r4 != null) goto L6;
        return null;
    L6:
        r4.setClassLoader(ParcelUtils.class.getClassLoader());     // Catch: RuntimeException -> L8
        return (T) fromParcelable(r4.getParcelable(INNER_BUNDLE_KEY));
    L8:
        return null;
    }

    public static <T extends VersionedParcelable> List<T> getVersionedParcelableList(Bundle r3, String r4) {
        ArrayList r1 = new ArrayList();
        Bundle r5 = (Bundle) ZeusTransformUtils.preCheckCast(r3.getParcelable(r4), Bundle.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L9
        r5.setClassLoader(ParcelUtils.class.getClassLoader());     // Catch: RuntimeException -> L9
        Iterator r6 = r5.getParcelableArrayList(INNER_BUNDLE_KEY).iterator();     // Catch: RuntimeException -> L9
    L5:
        if (r6.hasNext() == false) goto L8;
        r1.add(fromParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r6.next(), Parcelable.class, "com.obric.memorydata.plugin")));     // Catch: RuntimeException -> L9
        goto L5
    L8:
        return r1;
    L9:
        return null;
    }

    public static void putVersionedParcelable(Bundle r2, String r3, VersionedParcelable r4) {
        VersionedParcelable r5 = (VersionedParcelable) ZeusTransformUtils.wrapperContextForParams(r4, VersionedParcelable.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        Bundle r0 = new Bundle();
        r0.putParcelable(INNER_BUNDLE_KEY, toParcelable(r5));
        r2.putParcelable(r3, r0);
    }

    public static void putVersionedParcelableList(Bundle r5, String r6, List<? extends VersionedParcelable> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Bundle r0 = new Bundle();
        ArrayList<? extends Parcelable> r2 = new ArrayList();
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r2.add(toParcelable((VersionedParcelable) ZeusTransformUtils.preCheckCast(r9.next(), VersionedParcelable.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        r0.putParcelableArrayList(INNER_BUNDLE_KEY, r2);
        r5.putParcelable(r6, r0);
    }

    public static void toOutputStream(VersionedParcelable r2, OutputStream r3) {
        VersionedParcelable r4 = (VersionedParcelable) ZeusTransformUtils.wrapperContextForParams(r2, VersionedParcelable.class, "com.obric.memorydata.plugin");
        VersionedParcelStream r0 = new VersionedParcelStream(null, r3);
        r0.writeVersionedParcelable(r4);
        r0.closeField();
    }

    public static Parcelable toParcelable(VersionedParcelable r2) {
        return new ParcelImpl((VersionedParcelable) ZeusTransformUtils.wrapperContextForParams(r2, VersionedParcelable.class, "com.obric.memorydata.plugin"));
    }
}
