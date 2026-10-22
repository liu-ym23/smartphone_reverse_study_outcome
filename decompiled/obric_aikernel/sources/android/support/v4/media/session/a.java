package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: android.support.v4.media.session.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0010a extends Binder implements a {
        public AbstractBinderC0010a() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 == 1598968902) goto L58;
            boolean r14 = false;
            Bundle r15 = null;
            ParcelableVolumeInfo r16 = null;
            Bundle r17 = null;
            CharSequence r18 = null;
            MediaMetadataCompat r19 = null;
            PlaybackStateCompat r20 = null;
            switch(r10) {
                case 1: goto L53;
                case 2: goto L51;
                case 3: goto L46;
                case 4: goto L41;
                case 5: goto L39;
                case 6: goto L34;
                case 7: goto L29;
                case 8: goto L24;
                case 9: goto L22;
                case 10: goto L17;
                case 11: goto L12;
                case 12: goto L10;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r11.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            i1();
            return true;
        L10:
            r11.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            T1(r11.readInt());
            return true;
        L12:
            r11.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r11.readInt() == 0) goto L15;
            r14 = true;
        L15:
            y1(r14);
            return true;
        L17:
            r11.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r11.readInt() == 0) goto L20;
            r14 = true;
        L20:
            D1(r14);
            return true;
        L22:
            r11.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            L1(r11.readInt());
            return true;
        L24:
            r11.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r11.readInt() == 0) goto L27;
            r16 = ParcelableVolumeInfo.CREATOR.createFromParcel(r11);
        L27:
            o2(r16);
            return true;
        L29:
            r11.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r11.readInt() == 0) goto L32;
            r17 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L32:
            M(r17);
            return true;
        L34:
            r11.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r11.readInt() == 0) goto L37;
            r18 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r11);
        L37:
            j0(r18);
            return true;
        L39:
            r11.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            Q(r11.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
            return true;
        L41:
            r11.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r11.readInt() == 0) goto L44;
            r19 = MediaMetadataCompat.CREATOR.createFromParcel(r11);
        L44:
            G1(r19);
            return true;
        L46:
            r11.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r11.readInt() == 0) goto L49;
            r20 = PlaybackStateCompat.CREATOR.createFromParcel(r11);
        L49:
            m2(r20);
            return true;
        L51:
            r11.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            k0();
            return true;
        L53:
            r11.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            String r21 = r11.readString();
            if (r11.readInt() == 0) goto L56;
            r15 = (Bundle) Bundle.CREATOR.createFromParcel(r11);
        L56:
            L0(r21, r15);
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        L58:
            r12.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }
    }

    void D1(boolean r10);

    void G1(MediaMetadataCompat r10);

    void L0(String r10, Bundle r11);

    void L1(int r10);

    void M(Bundle r10);

    void Q(List<MediaSessionCompat.QueueItem> r10);

    void T1(int r10);

    void i1();

    void j0(CharSequence r10);

    void k0();

    void m2(PlaybackStateCompat r10);

    void o2(ParcelableVolumeInfo r10);

    void y1(boolean r10);
}
