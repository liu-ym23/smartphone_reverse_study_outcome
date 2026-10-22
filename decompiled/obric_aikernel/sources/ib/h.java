package ib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface h extends IInterface {

    public static abstract class a extends Binder implements h {

        /* JADX INFO: renamed from: ib.h$a$a, reason: collision with other inner class name */
        private static class C0191a implements h {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static h f9462g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9463c;

            C0191a(IBinder r10) {
                this.f9463c = r10;
            }

            @Override // ib.h
            public void D0(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L17
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f9463c.transact(3, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().D0(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // ib.h
            public int E1() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L13
                if (this.f9463c.transact(1, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                int r12 = r11.readInt();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (a.k1() == null) goto L10;
                int r13 = a.k1().E1();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // ib.h
            public void G(DownloadInfo r10, BaseException r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L20
                if (r10 == null) goto L6;
                r12.writeInt(1);     // Catch: Throwable -> L20
                r10.writeToParcel(r12, 0);     // Catch: Throwable -> L20
            L7:
                if (r11 == null) goto L9;
                r12.writeInt(1);     // Catch: Throwable -> L20
                r11.writeToParcel(r12, 0);     // Catch: Throwable -> L20
            L11:
                if (this.f9463c.transact(11, r12, r13, 0) == false) goto L13;
            L17:
                r13.readException();     // Catch: Throwable -> L20
                r13.recycle();
                r12.recycle();
                return;
            L13:
                if (a.k1() == null) goto L17;
                a.k1().G(r10, r11);     // Catch: Throwable -> L20
                r13.recycle();
                r12.recycle();
                return;
            L9:
                r12.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r12.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // ib.h
            public void I(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L17
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f9463c.transact(9, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().I(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // ib.h
            public void N(DownloadInfo r10, BaseException r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L20
                if (r10 == null) goto L6;
                r12.writeInt(1);     // Catch: Throwable -> L20
                r10.writeToParcel(r12, 0);     // Catch: Throwable -> L20
            L7:
                if (r11 == null) goto L9;
                r12.writeInt(1);     // Catch: Throwable -> L20
                r11.writeToParcel(r12, 0);     // Catch: Throwable -> L20
            L11:
                if (this.f9463c.transact(12, r12, r13, 0) == false) goto L13;
            L17:
                r13.readException();     // Catch: Throwable -> L20
                r13.recycle();
                r12.recycle();
                return;
            L13:
                if (a.k1() == null) goto L17;
                a.k1().N(r10, r11);     // Catch: Throwable -> L20
                r13.recycle();
                r12.recycle();
                return;
            L9:
                r12.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r12.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // ib.h
            public void R(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L17
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f9463c.transact(10, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().R(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // ib.h
            public void U(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L17
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f9463c.transact(13, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().U(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // ib.h
            public void W(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L17
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f9463c.transact(6, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().W(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // ib.h
            public void Z(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L17
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f9463c.transact(4, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().Z(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9463c;
            }

            @Override // ib.h
            public void l0(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L17
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f9463c.transact(5, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().l0(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // ib.h
            public void p0(DownloadInfo r10, BaseException r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L20
                if (r10 == null) goto L6;
                r12.writeInt(1);     // Catch: Throwable -> L20
                r10.writeToParcel(r12, 0);     // Catch: Throwable -> L20
            L7:
                if (r11 == null) goto L9;
                r12.writeInt(1);     // Catch: Throwable -> L20
                r11.writeToParcel(r12, 0);     // Catch: Throwable -> L20
            L11:
                if (this.f9463c.transact(7, r12, r13, 0) == false) goto L13;
            L17:
                r13.readException();     // Catch: Throwable -> L20
                r13.recycle();
                r12.recycle();
                return;
            L13:
                if (a.k1() == null) goto L17;
                a.k1().p0(r10, r11);     // Catch: Throwable -> L20
                r13.recycle();
                r12.recycle();
                return;
            L9:
                r12.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r12.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // ib.h
            public void q0(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L17
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f9463c.transact(8, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().q0(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // ib.h
            public void r0(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L17
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f9463c.transact(2, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().r0(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        }

        public static h U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r11 == null) goto L12;
            if ((r11 instanceof h) == false) goto L12;
            return (h) r11;
        L12:
            return new C0191a(r10);
        }

        public static h k1() {
            return C0191a.f9462g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 == 1598968902) goto L82;
            DownloadInfo r14 = null;
            DownloadInfo r15 = null;
            BaseException r16 = null;
            BaseException r17 = null;
            DownloadInfo r18 = null;
            DownloadInfo r19 = null;
            DownloadInfo r20 = null;
            BaseException r21 = null;
            DownloadInfo r22 = null;
            DownloadInfo r23 = null;
            DownloadInfo r24 = null;
            DownloadInfo r25 = null;
            switch(r10) {
                case 1: goto L80;
                case 2: goto L75;
                case 3: goto L70;
                case 4: goto L65;
                case 5: goto L60;
                case 6: goto L55;
                case 7: goto L46;
                case 8: goto L41;
                case 9: goto L36;
                case 10: goto L31;
                case 11: goto L22;
                case 12: goto L13;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r11.readInt() == 0) goto L11;
            r15 = DownloadInfo.CREATOR.createFromParcel(r11);
        L11:
            U(r15);
            r12.writeNoException();
            return true;
        L13:
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r11.readInt() == 0) goto L16;
            DownloadInfo r26 = DownloadInfo.CREATOR.createFromParcel(r11);
        L18:
            if (r11.readInt() == 0) goto L20;
            r16 = BaseException.CREATOR.createFromParcel(r11);
        L20:
            N(r26, r16);
            r12.writeNoException();
            return true;
        L16:
            r26 = null;
            goto L18
        L22:
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r11.readInt() == 0) goto L25;
            DownloadInfo r27 = DownloadInfo.CREATOR.createFromParcel(r11);
        L27:
            if (r11.readInt() == 0) goto L29;
            r17 = BaseException.CREATOR.createFromParcel(r11);
        L29:
            G(r27, r17);
            r12.writeNoException();
            return true;
        L25:
            r27 = null;
            goto L27
        L31:
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r11.readInt() == 0) goto L34;
            r18 = DownloadInfo.CREATOR.createFromParcel(r11);
        L34:
            R(r18);
            r12.writeNoException();
            return true;
        L36:
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r11.readInt() == 0) goto L39;
            r19 = DownloadInfo.CREATOR.createFromParcel(r11);
        L39:
            I(r19);
            r12.writeNoException();
            return true;
        L41:
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r11.readInt() == 0) goto L44;
            r20 = DownloadInfo.CREATOR.createFromParcel(r11);
        L44:
            q0(r20);
            r12.writeNoException();
            return true;
        L46:
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r11.readInt() == 0) goto L49;
            DownloadInfo r28 = DownloadInfo.CREATOR.createFromParcel(r11);
        L51:
            if (r11.readInt() == 0) goto L53;
            r21 = BaseException.CREATOR.createFromParcel(r11);
        L53:
            p0(r28, r21);
            r12.writeNoException();
            return true;
        L49:
            r28 = null;
            goto L51
        L55:
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r11.readInt() == 0) goto L58;
            r22 = DownloadInfo.CREATOR.createFromParcel(r11);
        L58:
            W(r22);
            r12.writeNoException();
            return true;
        L60:
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r11.readInt() == 0) goto L63;
            r23 = DownloadInfo.CREATOR.createFromParcel(r11);
        L63:
            l0(r23);
            r12.writeNoException();
            return true;
        L65:
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r11.readInt() == 0) goto L68;
            r24 = DownloadInfo.CREATOR.createFromParcel(r11);
        L68:
            Z(r24);
            r12.writeNoException();
            return true;
        L70:
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r11.readInt() == 0) goto L73;
            r25 = DownloadInfo.CREATOR.createFromParcel(r11);
        L73:
            D0(r25);
            r12.writeNoException();
            return true;
        L75:
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r11.readInt() == 0) goto L78;
            r14 = DownloadInfo.CREATOR.createFromParcel(r11);
        L78:
            r0(r14);
            r12.writeNoException();
            return true;
        L80:
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            int r29 = E1();
            r12.writeNoException();
            r12.writeInt(r29);
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        L82:
            r12.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            return true;
        }
    }

    void D0(DownloadInfo r10);

    int E1();

    void G(DownloadInfo r10, BaseException r11);

    void I(DownloadInfo r10);

    void N(DownloadInfo r10, BaseException r11);

    void R(DownloadInfo r10);

    void U(DownloadInfo r10);

    void W(DownloadInfo r10);

    void Z(DownloadInfo r10);

    void l0(DownloadInfo r10);

    void p0(DownloadInfo r10, BaseException r11);

    void q0(DownloadInfo r10);

    void r0(DownloadInfo r10);
}
