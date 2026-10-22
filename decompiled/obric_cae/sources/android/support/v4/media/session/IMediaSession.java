package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IMediaSession extends IInterface {

    public static abstract class Stub extends Binder implements IMediaSession {

        public static class Proxy implements IMediaSession {
            public Proxy() {
                throw null;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public final void k1(IMediaControllerCallback r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L9
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L9
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L9
                throw null;     // Catch: Throwable -> L9
            L6:
                r12 = null;
            L9:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "android.support.v4.media.session.IMediaSession");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 51) goto L5;
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r10.readInt() == 0) goto L179;
            RatingCompat r13 = RatingCompat.CREATOR.createFromParcel(r10);
        L179:
            if (r10.readInt() == 0) goto L181;
            Bundle r14 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L181:
            C2();
            r11.writeNoException();
            return true;
        L5:
            if (r8 != 1598968902) goto L7;
            r11.writeString("android.support.v4.media.session.IMediaSession");
            return true;
        L7:
            switch(r8) {
                case 1: goto L164;
                case 2: goto L159;
                case 3: goto L157;
                case 4: goto L155;
                case 5: goto L153;
                case 6: goto L151;
                case 7: goto L149;
                case 8: goto L144;
                case 9: goto L142;
                case 10: goto L137;
                case 11: goto L135;
                case 12: goto L133;
                case 13: goto L131;
                case 14: goto L126;
                case 15: goto L121;
                case 16: goto L113;
                case 17: goto L111;
                case 18: goto L109;
                case 19: goto L107;
                case 20: goto L105;
                case 21: goto L103;
                case 22: goto L101;
                case 23: goto L99;
                case 24: goto L97;
                case 25: goto L92;
                case 26: goto L87;
                case 27: goto L82;
                case 28: goto L77;
                case 29: goto L75;
                case 30: goto L70;
                case 31: goto L65;
                case 32: goto L63;
                case 33: goto L61;
                case 34: goto L56;
                case 35: goto L51;
                case 36: goto L43;
                case 37: goto L41;
                case 38: goto L39;
                case 39: goto L37;
                case 40: goto L35;
                case 41: goto L30;
                case 42: goto L25;
                case 43: goto L20;
                case 44: goto L18;
                case 45: goto L16;
                case 46: goto L14;
                case 47: goto L12;
                case 48: goto L10;
                default: goto L9;
            };
        L10:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            r10.readInt();
            P1();
            r11.writeNoException();
            return true;
        L12:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            int r15 = J0();
            r11.writeNoException();
            r11.writeInt(r15);
            return true;
        L14:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            r10.readInt();
            N();
            r11.writeNoException();
            return true;
        L16:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            boolean r16 = K0();
            r11.writeNoException();
            r11.writeInt(r16 ? 1 : 0);
            return true;
        L18:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            r10.readInt();
            P();
            r11.writeNoException();
            return true;
        L20:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r10.readInt() == 0) goto L23;
            MediaDescriptionCompat r17 = MediaDescriptionCompat.CREATOR.createFromParcel(r10);
        L23:
            S1();
            r11.writeNoException();
            return true;
        L25:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r10.readInt() == 0) goto L28;
            MediaDescriptionCompat r18 = MediaDescriptionCompat.CREATOR.createFromParcel(r10);
        L28:
            r10.readInt();
            r();
            r11.writeNoException();
            return true;
        L30:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r10.readInt() == 0) goto L33;
            MediaDescriptionCompat r19 = MediaDescriptionCompat.CREATOR.createFromParcel(r10);
        L33:
            q1();
            r11.writeNoException();
            return true;
        L35:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            r10.readInt();
            E();
            r11.writeNoException();
            return true;
        L37:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            r10.readInt();
            U1();
            r11.writeNoException();
            return true;
        L39:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            y();
            r11.writeNoException();
            r11.writeInt(0);
            return true;
        L41:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            int r20 = u2();
            r11.writeNoException();
            r11.writeInt(r20);
            return true;
        L43:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r10.readInt() == 0) goto L47;
            Uri r21 = (Uri) Uri.CREATOR.createFromParcel(r10);
        L47:
            if (r10.readInt() == 0) goto L49;
            Bundle r22 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L49:
            v0();
            r11.writeNoException();
            return true;
        L51:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            r10.readString();
            if (r10.readInt() == 0) goto L54;
            Bundle r23 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L54:
            N0();
            r11.writeNoException();
            return true;
        L56:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            r10.readString();
            if (r10.readInt() == 0) goto L59;
            Bundle r24 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L59:
            p0();
            r11.writeNoException();
            return true;
        L61:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            z1();
            r11.writeNoException();
            return true;
        L63:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            int r25 = L();
            r11.writeNoException();
            r11.writeInt(r25);
            return true;
        L65:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            Bundle r26 = getExtras();
            r11.writeNoException();
            if (r26 == null) goto L68;
            r11.writeInt(1);
            r26.writeToParcel(r11, 1);
        L69:
            return true;
        L68:
            r11.writeInt(0);
            goto L69
        L70:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            CharSequence r27 = H1();
            r11.writeNoException();
            if (r27 == null) goto L73;
            r11.writeInt(1);
            TextUtils.writeToParcel(r27, r11, 1);
        L74:
            return true;
        L73:
            r11.writeInt(0);
            goto L74
        L75:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            List<MediaSessionCompat.QueueItem> r28 = q2();
            r11.writeNoException();
            r11.writeTypedList(r28);
            return true;
        L77:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            PlaybackStateCompat r29 = k2();
            r11.writeNoException();
            if (r29 == null) goto L80;
            r11.writeInt(1);
            r29.writeToParcel(r11, 1);
        L81:
            return true;
        L80:
            r11.writeInt(0);
            goto L81
        L82:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            MediaMetadataCompat r30 = K1();
            r11.writeNoException();
            if (r30 == null) goto L85;
            r11.writeInt(1);
            r30.writeToParcel(r11, 1);
        L86:
            return true;
        L85:
            r11.writeInt(0);
            goto L86
        L87:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            r10.readString();
            if (r10.readInt() == 0) goto L90;
            Bundle r31 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L90:
            U0();
            r11.writeNoException();
            return true;
        L92:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r10.readInt() == 0) goto L95;
            RatingCompat r32 = RatingCompat.CREATOR.createFromParcel(r10);
        L95:
            c2();
            r11.writeNoException();
            return true;
        L97:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            r10.readLong();
            S0();
            r11.writeNoException();
            return true;
        L99:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            rewind();
            r11.writeNoException();
            return true;
        L101:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            O1();
            r11.writeNoException();
            return true;
        L103:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            previous();
            r11.writeNoException();
            return true;
        L105:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            next();
            r11.writeNoException();
            return true;
        L107:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            stop();
            r11.writeNoException();
            return true;
        L109:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            pause();
            r11.writeNoException();
            return true;
        L111:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            r10.readLong();
            m0();
            r11.writeNoException();
            return true;
        L113:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r10.readInt() == 0) goto L117;
            Uri r33 = (Uri) Uri.CREATOR.createFromParcel(r10);
        L117:
            if (r10.readInt() == 0) goto L119;
            Bundle r34 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L119:
            P0();
            r11.writeNoException();
            return true;
        L121:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            r10.readString();
            if (r10.readInt() == 0) goto L124;
            Bundle r35 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L124:
            o();
            r11.writeNoException();
            return true;
        L126:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            r10.readString();
            if (r10.readInt() == 0) goto L129;
            Bundle r36 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L129:
            S();
            r11.writeNoException();
            return true;
        L131:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            o2();
            r11.writeNoException();
            return true;
        L133:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            r10.readInt();
            r10.readInt();
            r10.readString();
            G0();
            r11.writeNoException();
            return true;
        L135:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            r10.readInt();
            r10.readInt();
            r10.readString();
            u0();
            r11.writeNoException();
            return true;
        L137:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            ParcelableVolumeInfo r37 = v2();
            r11.writeNoException();
            if (r37 == null) goto L140;
            r11.writeInt(1);
            r37.writeToParcel(r11, 1);
        L141:
            return true;
        L140:
            r11.writeInt(0);
            goto L141
        L142:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            long r38 = getFlags();
            r11.writeNoException();
            r11.writeLong(r38);
            return true;
        L144:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            PendingIntent r39 = H();
            r11.writeNoException();
            if (r39 == null) goto L147;
            r11.writeInt(1);
            r39.writeToParcel(r11, 1);
        L148:
            return true;
        L147:
            r11.writeInt(0);
            goto L148
        L149:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            String r40 = getTag();
            r11.writeNoException();
            r11.writeString(r40);
            return true;
        L151:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            String r41 = getPackageName();
            r11.writeNoException();
            r11.writeString(r41);
            return true;
        L153:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            boolean r42 = t1();
            r11.writeNoException();
            r11.writeInt(r42 ? 1 : 0);
            return true;
        L155:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            IMediaControllerCallback.Stub.H2(r10.readStrongBinder());
            b0();
            r11.writeNoException();
            return true;
        L157:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            k1(IMediaControllerCallback.Stub.H2(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L159:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r10.readInt() == 0) goto L162;
            KeyEvent r43 = (KeyEvent) KeyEvent.CREATOR.createFromParcel(r10);
        L162:
            boolean r44 = n2();
            r11.writeNoException();
            r11.writeInt(r44 ? 1 : 0);
            return true;
        L164:
            r10.enforceInterface("android.support.v4.media.session.IMediaSession");
            r10.readString();
            if (r10.readInt() == 0) goto L168;
            Bundle r45 = (Bundle) Bundle.CREATOR.createFromParcel(r10);
        L168:
            if (r10.readInt() == 0) goto L170;
            MediaSessionCompat.ResultReceiverWrapper r46 = MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(r10);
        L171:
            X(r46);
            r11.writeNoException();
            return true;
        L170:
            r46 = null;
            goto L171
        L9:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void C2();

    void E();

    void G0();

    PendingIntent H();

    CharSequence H1();

    int J0();

    boolean K0();

    MediaMetadataCompat K1();

    int L();

    void N();

    void N0();

    void O1();

    void P();

    void P0();

    void P1();

    void S();

    void S0();

    void S1();

    void U0();

    void U1();

    void X(MediaSessionCompat.ResultReceiverWrapper r8);

    void b0();

    void c2();

    Bundle getExtras();

    long getFlags();

    String getPackageName();

    String getTag();

    void k1(IMediaControllerCallback r8);

    PlaybackStateCompat k2();

    void m0();

    boolean n2();

    void next();

    void o();

    void o2();

    void p0();

    void pause();

    void previous();

    void q1();

    List<MediaSessionCompat.QueueItem> q2();

    void r();

    void rewind();

    void stop();

    boolean t1();

    void u0();

    int u2();

    void v0();

    ParcelableVolumeInfo v2();

    void y();

    void z1();
}
