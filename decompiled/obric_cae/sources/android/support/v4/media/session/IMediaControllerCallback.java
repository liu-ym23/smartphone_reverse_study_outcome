package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public interface IMediaControllerCallback extends IInterface {

    public static abstract class Stub extends Binder implements IMediaControllerCallback {

        public static class Proxy implements IMediaControllerCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f406a;

            public Proxy(IBinder r8) {
                this.f406a = r8;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public final void A0() {
                Parcel r8 = Parcel.obtain();
                r8.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");     // Catch: Throwable -> L6
                this.f406a.transact(2, r8, null, 1);     // Catch: Throwable -> L6
                r8.recycle();
                return;
            L6:
                th = move-exception;
                r8.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f406a;
            }
        }

        public Stub() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        public static IMediaControllerCallback H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r10 == null) goto L12;
            if ((r10 instanceof IMediaControllerCallback) == false) goto L12;
            return (IMediaControllerCallback) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 1598968902) goto L5;
            r11.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        L5:
            switch(r8) {
                case 1: goto L47;
                case 2: goto L45;
                case 3: goto L40;
                case 4: goto L35;
                case 5: goto L33;
                case 6: goto L28;
                case 7: goto L23;
                case 8: goto L18;
                case 9: goto L16;
                case 10: goto L14;
                case 11: goto L12;
                case 12: goto L10;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            ((MediaControllerCompat$Callback$StubCompat) this).M2();
            throw null;
        L10:
            r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            r10.readInt();
            ((MediaControllerCompat$Callback$StubCompat) this).N2();
            throw null;
        L12:
            r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            r10.readInt();
            ((MediaControllerCompat$Callback$StubCompat) this).I2();
            throw null;
        L14:
            r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            r10.readInt();
            return true;
        L16:
            r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            r10.readInt();
            ((MediaControllerCompat$Callback$StubCompat) this).L2();
            throw null;
        L18:
            r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r10.readInt() == 0) goto L21;
            ParcelableVolumeInfo r13 = ParcelableVolumeInfo.CREATOR.createFromParcel(r10);
        L21:
            T0();
            return true;
        L23:
            r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r10.readInt() == 0) goto L26;
            Bundle r14 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L26:
            g0();
            return true;
        L28:
            r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r10.readInt() == 0) goto L31;
            CharSequence r15 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r10);
        L31:
            J();
            return true;
        L33:
            r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            r10.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
            s2();
            return true;
        L35:
            r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r10.readInt() == 0) goto L38;
            MediaMetadataCompat r16 = MediaMetadataCompat.CREATOR.createFromParcel(r10);
        L38:
            w2();
            return true;
        L40:
            r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r10.readInt() == 0) goto L43;
            PlaybackStateCompat r17 = PlaybackStateCompat.CREATOR.createFromParcel(r10);
        L43:
            ((MediaControllerCompat$Callback$StubCompat) this).K2();
            throw null;
        L45:
            r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            A0();
            return true;
        L47:
            r10.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            r10.readString();
            if (r10.readInt() == 0) goto L50;
            Bundle r18 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L50:
            ((MediaControllerCompat$Callback$StubCompat) this).J2();
            throw null;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void A0();

    void J();

    void T0();

    void g0();

    void s2();

    void w2();
}
