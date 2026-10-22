package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T extends VersionedParcelable> T fromInputStream(InputStream r5) {
        return (T) new VersionedParcelStream(r5, null).readVersionedParcelable();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T extends VersionedParcelable> T fromParcelable(Parcelable r5) {
        if ((r5 instanceof ParcelImpl) == false) goto L7;
        return (T) ((ParcelImpl) r5).getVersionedParcel();
    L7:
        throw new IllegalArgumentException("Invalid parcel");
    }

    @Nullable
    public static <T extends VersionedParcelable> T getVersionedParcelable(@NonNull Bundle r5, @NonNull String r10) {
        Bundle r11 = (Bundle) r5.getParcelable(r10);     // Catch: RuntimeException -> L8
        if (r11 != null) goto L6;
        return null;
    L6:
        r11.setClassLoader(ParcelUtils.class.getClassLoader());     // Catch: RuntimeException -> L8
        return (T) fromParcelable(r11.getParcelable(INNER_BUNDLE_KEY));
    L8:
        return null;
    }

    @Nullable
    public static <T extends VersionedParcelable> List<T> getVersionedParcelableList(Bundle r5, String r10) {
        ArrayList r11 = new ArrayList();
        Bundle r12 = (Bundle) r5.getParcelable(r10);     // Catch: RuntimeException -> L9
        r12.setClassLoader(ParcelUtils.class.getClassLoader());     // Catch: RuntimeException -> L9
        Iterator r13 = r12.getParcelableArrayList(INNER_BUNDLE_KEY).iterator();     // Catch: RuntimeException -> L9
    L5:
        if (r13.hasNext() == false) goto L8;
        r11.add(fromParcelable((Parcelable) r13.next()));     // Catch: RuntimeException -> L9
        goto L5
    L8:
        return r11;
    L9:
        return null;
    }

    public static void putVersionedParcelable(@NonNull Bundle r5, @NonNull String r10, @Nullable VersionedParcelable r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        Bundle r12 = new Bundle();
        r12.putParcelable(INNER_BUNDLE_KEY, toParcelable(r11));
        r5.putParcelable(r10, r12);
    }

    public static void putVersionedParcelableList(@NonNull Bundle r5, @NonNull String r10, @NonNull List<? extends VersionedParcelable> r11) {
        Bundle r12 = new Bundle();
        ArrayList<? extends Parcelable> r13 = new ArrayList();
        Iterator<? extends VersionedParcelable> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.add(toParcelable(r14.next()));
        goto L4
    L6:
        r12.putParcelableArrayList(INNER_BUNDLE_KEY, r13);
        r5.putParcelable(r10, r12);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void toOutputStream(VersionedParcelable r5, OutputStream r10) {
        VersionedParcelStream r11 = new VersionedParcelStream(null, r10);
        r11.writeVersionedParcelable(r5);
        r11.closeField();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Parcelable toParcelable(VersionedParcelable r5) {
        return new ParcelImpl(r5);
    }
}
