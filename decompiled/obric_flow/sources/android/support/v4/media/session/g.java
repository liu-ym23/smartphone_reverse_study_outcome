package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r5) {
        return new PlaybackStateCompat.CustomAction(r5);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r5) {
        return new PlaybackStateCompat.CustomAction[r5];
    }
}
