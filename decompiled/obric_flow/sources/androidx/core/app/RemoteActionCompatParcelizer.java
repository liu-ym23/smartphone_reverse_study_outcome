package androidx.core.app;

import android.app.PendingIntent;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class RemoteActionCompatParcelizer {
    public RemoteActionCompatParcelizer() {
    }

    public static RemoteActionCompat read(VersionedParcel r5) {
        RemoteActionCompat r10 = new RemoteActionCompat();
        r10.mIcon = (IconCompat) r5.readVersionedParcelable(r10.mIcon, 1);
        r10.mTitle = r5.readCharSequence(r10.mTitle, 2);
        r10.mContentDescription = r5.readCharSequence(r10.mContentDescription, 3);
        r10.mActionIntent = (PendingIntent) r5.readParcelable(r10.mActionIntent, 4);
        r10.mEnabled = r5.readBoolean(r10.mEnabled, 5);
        r10.mShouldShowIcon = r5.readBoolean(r10.mShouldShowIcon, 6);
        return r10;
    }

    public static void write(RemoteActionCompat r5, VersionedParcel r10) {
        r10.setSerializationFlags(false, false);
        r10.writeVersionedParcelable(r5.mIcon, 1);
        r10.writeCharSequence(r5.mTitle, 2);
        r10.writeCharSequence(r5.mContentDescription, 3);
        r10.writeParcelable(r5.mActionIntent, 4);
        r10.writeBoolean(r5.mEnabled, 5);
        r10.writeBoolean(r5.mShouldShowIcon, 6);
    }
}
