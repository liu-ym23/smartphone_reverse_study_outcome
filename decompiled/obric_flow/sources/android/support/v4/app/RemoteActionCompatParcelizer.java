package android.support.v4.app;

import androidx.annotation.RestrictTo;
import androidx.core.app.RemoteActionCompat;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class RemoteActionCompatParcelizer extends androidx.core.app.RemoteActionCompatParcelizer {
    public RemoteActionCompatParcelizer() {
    }

    public static RemoteActionCompat read(VersionedParcel r5) {
        return androidx.core.app.RemoteActionCompatParcelizer.read(r5);
    }

    public static void write(RemoteActionCompat r5, VersionedParcel r10) {
        androidx.core.app.RemoteActionCompatParcelizer.write(r5, r10);
    }
}
