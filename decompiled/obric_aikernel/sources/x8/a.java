package x8;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.download.base.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: x8.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0318a extends Binder implements a {
        public AbstractBinderC0318a() {
            attachInterface(this, "com.obric.download.aidl.IDownloadCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 == 1598968902) goto L58;
            DownloadInfo r14 = null;
            switch(r10) {
                case 1: goto L54;
                case 2: goto L50;
                case 3: goto L46;
                case 4: goto L42;
                case 5: goto L38;
                case 6: goto L34;
                case 7: goto L30;
                case 8: goto L26;
                case 9: goto L22;
                case 10: goto L18;
                case 11: goto L14;
                case 12: goto L8;
                default: goto L7;
            };
        L8:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L11;
            r14 = DownloadInfo.CREATOR.a(r11);
        L11:
            K(r14);
        L12:
            r12.writeNoException();
            return true;
        L14:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L17;
            r14 = DownloadInfo.CREATOR.a(r11);
        L17:
            S0(r14, r11.readInt(), r11.readString());
            goto L12
        L18:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L21;
            r14 = DownloadInfo.CREATOR.a(r11);
        L21:
            V1(r14, r11.readInt(), r11.readString());
            goto L12
        L22:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L25;
            r14 = DownloadInfo.CREATOR.a(r11);
        L25:
            i2(r14);
            goto L12
        L26:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L29;
            r14 = DownloadInfo.CREATOR.a(r11);
        L29:
            e2(r14);
            goto L12
        L30:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L33;
            r14 = DownloadInfo.CREATOR.a(r11);
        L33:
            G0(r14);
            goto L12
        L34:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L37;
            r14 = DownloadInfo.CREATOR.a(r11);
        L37:
            F(r14, r11.readInt(), r11.readString());
            goto L12
        L38:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L41;
            r14 = DownloadInfo.CREATOR.a(r11);
        L41:
            z0(r14);
            goto L12
        L42:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L45;
            r14 = DownloadInfo.CREATOR.a(r11);
        L45:
            a0(r14);
            goto L12
        L46:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L49;
            r14 = DownloadInfo.CREATOR.a(r11);
        L49:
            u0(r14);
            goto L12
        L50:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L53;
            r14 = DownloadInfo.CREATOR.a(r11);
        L53:
            h0(r14);
            goto L12
        L54:
            r11.enforceInterface("com.obric.download.aidl.IDownloadCallback");
            if (r11.readInt() == 0) goto L57;
            r14 = DownloadInfo.CREATOR.a(r11);
        L57:
            X(r14);
            goto L12
        L7:
            return super.onTransact(r10, r11, r12, r13);
        L58:
            r12.writeString("com.obric.download.aidl.IDownloadCallback");
            return true;
        }
    }

    void F(DownloadInfo r10, int r11, String r12);

    void G0(DownloadInfo r10);

    void K(DownloadInfo r10);

    void S0(DownloadInfo r10, int r11, String r12);

    void V1(DownloadInfo r10, int r11, String r12);

    void X(DownloadInfo r10);

    void a0(DownloadInfo r10);

    void e2(DownloadInfo r10);

    void h0(DownloadInfo r10);

    void i2(DownloadInfo r10);

    void u0(DownloadInfo r10);

    void z0(DownloadInfo r10);
}
