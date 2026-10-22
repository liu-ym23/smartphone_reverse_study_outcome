package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public RemoteActionCompatParcelizer() {
    }

    public static RemoteActionCompat read(VersionedParcel r4) {
        RemoteActionCompat r0 = new RemoteActionCompat();
        r0.mIcon = (IconCompat) ZeusTransformUtils.preCheckCast(r4.readVersionedParcelable(r0.mIcon, 1), IconCompat.class, "com.obric.memorydata.plugin");
        r0.mTitle = r4.readCharSequence(r0.mTitle, 2);
        r0.mContentDescription = r4.readCharSequence(r0.mContentDescription, 3);
        r0.mActionIntent = (PendingIntent) ZeusTransformUtils.preCheckCast(r4.readParcelable(r0.mActionIntent, 4), PendingIntent.class, "com.obric.memorydata.plugin");
        r0.mEnabled = r4.readBoolean(r0.mEnabled, 5);
        r0.mShouldShowIcon = r4.readBoolean(r0.mShouldShowIcon, 6);
        return r0;
    }

    public static void write(RemoteActionCompat r2, VersionedParcel r3) {
        r3.setSerializationFlags(false, false);
        r3.writeVersionedParcelable(r2.mIcon, 1);
        r3.writeCharSequence(r2.mTitle, 2);
        r3.writeCharSequence(r2.mContentDescription, 3);
        r3.writeParcelable(r2.mActionIntent, 4);
        r3.writeBoolean(r2.mEnabled, 5);
        r3.writeBoolean(r2.mShouldShowIcon, 6);
    }
}
