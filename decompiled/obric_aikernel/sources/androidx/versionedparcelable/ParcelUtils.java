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
    public static <T extends VersionedParcelable> T fromInputStream(InputStream r10) {
        return (T) new VersionedParcelStream(r10, null).readVersionedParcelable();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T extends VersionedParcelable> T fromParcelable(Parcelable r10) {
        if ((r10 instanceof ParcelImpl) == false) goto L7;
        return (T) ((ParcelImpl) r10).getVersionedParcel();
    L7:
        throw new IllegalArgumentException("Invalid parcel");
    }

    @Nullable
    public static <T extends VersionedParcelable> T getVersionedParcelable(@NonNull Bundle r10, @NonNull String r11) {
        Bundle r12 = (Bundle) r10.getParcelable(r11);     // Catch: RuntimeException -> L8
        if (r12 != null) goto L6;
        return null;
    L6:
        r12.setClassLoader(ParcelUtils.class.getClassLoader());     // Catch: RuntimeException -> L8
        return (T) fromParcelable(r12.getParcelable(INNER_BUNDLE_KEY));
    L8:
        return null;
    }

    @Nullable
    public static <T extends VersionedParcelable> List<T> getVersionedParcelableList(Bundle r10, String r11) {
        ArrayList r12 = new ArrayList();
        Bundle r13 = (Bundle) r10.getParcelable(r11);     // Catch: RuntimeException -> L9
        r13.setClassLoader(ParcelUtils.class.getClassLoader());     // Catch: RuntimeException -> L9
        Iterator r14 = r13.getParcelableArrayList(INNER_BUNDLE_KEY).iterator();     // Catch: RuntimeException -> L9
    L5:
        if (r14.hasNext() == false) goto L8;
        r12.add(fromParcelable((Parcelable) r14.next()));     // Catch: RuntimeException -> L9
        goto L5
    L8:
        return r12;
    L9:
        return null;
    }

    public static void putVersionedParcelable(@NonNull Bundle r10, @NonNull String r11, @Nullable VersionedParcelable r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        Bundle r13 = new Bundle();
        r13.putParcelable(INNER_BUNDLE_KEY, toParcelable(r12));
        r10.putParcelable(r11, r13);
    }

    public static void putVersionedParcelableList(@NonNull Bundle r10, @NonNull String r11, @NonNull List<? extends VersionedParcelable> r12) {
        Bundle r13 = new Bundle();
        ArrayList<? extends Parcelable> r14 = new ArrayList();
        Iterator<? extends VersionedParcelable> r15 = r12.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        r14.add(toParcelable(r15.next()));
        goto L4
    L6:
        r13.putParcelableArrayList(INNER_BUNDLE_KEY, r14);
        r10.putParcelable(r11, r13);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void toOutputStream(VersionedParcelable r10, OutputStream r11) {
        VersionedParcelStream r12 = new VersionedParcelStream(null, r11);
        r12.writeVersionedParcelable(r10);
        r12.closeField();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Parcelable toParcelable(VersionedParcelable r10) {
        return new ParcelImpl(r10);
    }
}
