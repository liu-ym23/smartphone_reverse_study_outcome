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

    public static RemoteActionCompat read(VersionedParcel r10) {
        RemoteActionCompat r11 = new RemoteActionCompat();
        r11.mIcon = (IconCompat) r10.readVersionedParcelable(r11.mIcon, 1);
        r11.mTitle = r10.readCharSequence(r11.mTitle, 2);
        r11.mContentDescription = r10.readCharSequence(r11.mContentDescription, 3);
        r11.mActionIntent = (PendingIntent) r10.readParcelable(r11.mActionIntent, 4);
        r11.mEnabled = r10.readBoolean(r11.mEnabled, 5);
        r11.mShouldShowIcon = r10.readBoolean(r11.mShouldShowIcon, 6);
        return r11;
    }

    public static void write(RemoteActionCompat r10, VersionedParcel r11) {
        r11.setSerializationFlags(false, false);
        r11.writeVersionedParcelable(r10.mIcon, 1);
        r11.writeCharSequence(r10.mTitle, 2);
        r11.writeCharSequence(r10.mContentDescription, 3);
        r11.writeParcelable(r10.mActionIntent, 4);
        r11.writeBoolean(r10.mEnabled, 5);
        r11.writeBoolean(r10.mShouldShowIcon, 6);
    }
}
