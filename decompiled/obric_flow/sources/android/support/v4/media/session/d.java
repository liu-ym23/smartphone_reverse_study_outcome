package android.support.v4.media.session;

import ai.j0;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class d extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f396a;

    public d() {
        attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        this.f396a = new WeakReference(null);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) {
        if (r5 == 1598968902) goto L51;
        switch(r5) {
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L39;
            case 4: goto L34;
            case 5: goto L32;
            case 6: goto L27;
            case 7: goto L22;
            case 8: goto L17;
            case 9: goto L15;
            case 10: goto L13;
            case 11: goto L11;
            case 12: goto L9;
            case 13: goto L7;
            default: goto L6;
        };
    L7:
        r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        j0.A(this.f396a.get());
        return true;
    L9:
        r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        r10.readInt();
        j0.A(this.f396a.get());
        return true;
    L11:
        r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        r10.readInt();
        j0.A(this.f396a.get());
        return true;
    L13:
        r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        r10.readInt();
        return true;
    L15:
        r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        r10.readInt();
        j0.A(this.f396a.get());
        return true;
    L17:
        r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        if (r10.readInt() == 0) goto L21;
        ParcelableVolumeInfo r13 = ParcelableVolumeInfo.CREATOR.createFromParcel(r10);
    L21:
        throw new AssertionError();
    L22:
        r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        if (r10.readInt() == 0) goto L26;
        Bundle r14 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
    L26:
        throw new AssertionError();
    L27:
        r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        if (r10.readInt() == 0) goto L31;
        CharSequence r15 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r10);
    L31:
        throw new AssertionError();
    L32:
        r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        r10.createTypedArrayList(MediaSessionCompat$QueueItem.CREATOR);
        throw new AssertionError();
    L34:
        r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        if (r10.readInt() == 0) goto L38;
        MediaMetadataCompat r16 = MediaMetadataCompat.CREATOR.createFromParcel(r10);
    L38:
        throw new AssertionError();
    L39:
        r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        if (r10.readInt() == 0) goto L42;
        PlaybackStateCompat r17 = PlaybackStateCompat.CREATOR.createFromParcel(r10);
    L42:
        j0.A(this.f396a.get());
        return true;
    L44:
        r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        throw new AssertionError();
    L46:
        r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
        r10.readString();
        if (r10.readInt() == 0) goto L49;
        Bundle r18 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
    L49:
        j0.A(this.f396a.get());
        return true;
    L6:
        return super.onTransact(r5, r10, r11, r12);
    L51:
        r11.writeString("android.support.v4.media.session.IMediaControllerCallback");
        return true;
    }
}
