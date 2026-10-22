package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadAidlListener extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadAidlListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15488a = 0;

        public static class Proxy implements IDownloadAidlListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15489a;

            public Proxy(IBinder r5) {
                this.f15489a = r5;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public final void a(DownloadInfo r5, BaseException r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L9:
                if (r10 == null) goto L11;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r11.writeInt(r10.f15601a);     // Catch: Throwable -> L6
                r11.writeString(r10.f15602b);     // Catch: Throwable -> L6
                r11.writeString(r10.f15603c);     // Catch: Throwable -> L6
            L13:
                if (this.f15489a.transact(7, r11, r12, 0) == true) goto L15;
                int r13 = Stub.f15488a;     // Catch: Throwable -> L6
            L15:
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L11:
                r11.writeInt(0);     // Catch: Throwable -> L6
                goto L13
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15489a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public final void b(DownloadInfo r5, BaseException r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L9:
                if (r10 == null) goto L11;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r11.writeInt(r10.f15601a);     // Catch: Throwable -> L6
                r11.writeString(r10.f15602b);     // Catch: Throwable -> L6
                r11.writeString(r10.f15603c);     // Catch: Throwable -> L6
            L13:
                if (this.f15489a.transact(11, r11, r12, 0) == true) goto L15;
                int r13 = Stub.f15488a;     // Catch: Throwable -> L6
            L15:
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L11:
                r11.writeInt(0);     // Catch: Throwable -> L6
                goto L13
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public final void c(DownloadInfo r5, BaseException r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r11, 0);     // Catch: Throwable -> L6
            L9:
                if (r10 == null) goto L11;
                r11.writeInt(1);     // Catch: Throwable -> L6
                r11.writeInt(r10.f15601a);     // Catch: Throwable -> L6
                r11.writeString(r10.f15602b);     // Catch: Throwable -> L6
                r11.writeString(r10.f15603c);     // Catch: Throwable -> L6
            L13:
                if (this.f15489a.transact(12, r11, r12, 0) == true) goto L15;
                int r13 = Stub.f15488a;     // Catch: Throwable -> L6
            L15:
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L11:
                r11.writeInt(0);     // Catch: Throwable -> L6
                goto L13
            L8:
                r11.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public final void d(DownloadInfo r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r10.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r10, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f15489a.transact(5, r10, r11, 0) == true) goto L12;
                int r12 = Stub.f15488a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L8:
                r10.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public final void f(DownloadInfo r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r10.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r10, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f15489a.transact(9, r10, r11, 0) == true) goto L12;
                int r12 = Stub.f15488a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L8:
                r10.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public final void g(DownloadInfo r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r10.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r10, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f15489a.transact(8, r10, r11, 0) == true) goto L12;
                int r12 = Stub.f15488a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L8:
                r10.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public final void i(DownloadInfo r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r10.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r10, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f15489a.transact(2, r10, r11, 0) == true) goto L12;
                int r12 = Stub.f15488a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L8:
                r10.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public final int j() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L6
                if (this.f15489a.transact(1, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15488a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                int r12 = r10.readInt();     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return r12;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public final void l(DownloadInfo r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r10.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r10, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f15489a.transact(6, r10, r11, 0) == true) goto L12;
                int r12 = Stub.f15488a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L8:
                r10.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public final void m(DownloadInfo r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r10.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r10, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f15489a.transact(3, r10, r11, 0) == true) goto L12;
                int r12 = Stub.f15488a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L8:
                r10.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public final void n(DownloadInfo r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r10.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r10, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f15489a.transact(4, r10, r11, 0) == true) goto L12;
                int r12 = Stub.f15488a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L8:
                r10.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public final void p(DownloadInfo r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r10.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r10, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f15489a.transact(13, r10, r11, 0) == true) goto L12;
                int r12 = Stub.f15488a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L8:
                r10.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public final void j(DownloadInfo r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                r10.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r10, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f15489a.transact(10, r10, r11, 0) == true) goto L12;
                int r12 = Stub.f15488a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L8:
                r10.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        }

        public static IDownloadAidlListener a(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r10 == null) goto L12;
            if ((r10 instanceof IDownloadAidlListener) == false) goto L12;
            return (IDownloadAidlListener) r10;
        L12:
            return new Proxy(r5);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) {
            if (r5 == 1598968902) goto L82;
            DownloadInfo r13 = null;
            DownloadInfo r14 = null;
            BaseException r15 = null;
            BaseException r16 = null;
            DownloadInfo r17 = null;
            DownloadInfo r18 = null;
            DownloadInfo r19 = null;
            BaseException r20 = null;
            DownloadInfo r21 = null;
            DownloadInfo r22 = null;
            DownloadInfo r23 = null;
            DownloadInfo r24 = null;
            switch(r5) {
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
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r10.readInt() == 0) goto L11;
            r14 = DownloadInfo.CREATOR.createFromParcel(r10);
        L11:
            p(r14);
            r11.writeNoException();
            return true;
        L13:
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r10.readInt() == 0) goto L16;
            DownloadInfo r25 = DownloadInfo.CREATOR.createFromParcel(r10);
        L18:
            if (r10.readInt() == 0) goto L20;
            r15 = BaseException.CREATOR.createFromParcel(r10);
        L20:
            c(r25, r15);
            r11.writeNoException();
            return true;
        L16:
            r25 = null;
            goto L18
        L22:
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r10.readInt() == 0) goto L25;
            DownloadInfo r26 = DownloadInfo.CREATOR.createFromParcel(r10);
        L27:
            if (r10.readInt() == 0) goto L29;
            r16 = BaseException.CREATOR.createFromParcel(r10);
        L29:
            b(r26, r16);
            r11.writeNoException();
            return true;
        L25:
            r26 = null;
            goto L27
        L31:
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r10.readInt() == 0) goto L34;
            r17 = DownloadInfo.CREATOR.createFromParcel(r10);
        L34:
            j(r17);
            r11.writeNoException();
            return true;
        L36:
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r10.readInt() == 0) goto L39;
            r18 = DownloadInfo.CREATOR.createFromParcel(r10);
        L39:
            f(r18);
            r11.writeNoException();
            return true;
        L41:
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r10.readInt() == 0) goto L44;
            r19 = DownloadInfo.CREATOR.createFromParcel(r10);
        L44:
            g(r19);
            r11.writeNoException();
            return true;
        L46:
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r10.readInt() == 0) goto L49;
            DownloadInfo r27 = DownloadInfo.CREATOR.createFromParcel(r10);
        L51:
            if (r10.readInt() == 0) goto L53;
            r20 = BaseException.CREATOR.createFromParcel(r10);
        L53:
            a(r27, r20);
            r11.writeNoException();
            return true;
        L49:
            r27 = null;
            goto L51
        L55:
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r10.readInt() == 0) goto L58;
            r21 = DownloadInfo.CREATOR.createFromParcel(r10);
        L58:
            l(r21);
            r11.writeNoException();
            return true;
        L60:
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r10.readInt() == 0) goto L63;
            r22 = DownloadInfo.CREATOR.createFromParcel(r10);
        L63:
            d(r22);
            r11.writeNoException();
            return true;
        L65:
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r10.readInt() == 0) goto L68;
            r23 = DownloadInfo.CREATOR.createFromParcel(r10);
        L68:
            n(r23);
            r11.writeNoException();
            return true;
        L70:
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r10.readInt() == 0) goto L73;
            r24 = DownloadInfo.CREATOR.createFromParcel(r10);
        L73:
            m(r24);
            r11.writeNoException();
            return true;
        L75:
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (r10.readInt() == 0) goto L78;
            r13 = DownloadInfo.CREATOR.createFromParcel(r10);
        L78:
            i(r13);
            r11.writeNoException();
            return true;
        L80:
            r10.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            int r28 = j();
            r11.writeNoException();
            r11.writeInt(r28);
            return true;
        L7:
            return super.onTransact(r5, r10, r11, r12);
        L82:
            r11.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            return true;
        }
    }

    void a(DownloadInfo r5, BaseException r10);

    void b(DownloadInfo r5, BaseException r10);

    void c(DownloadInfo r5, BaseException r10);

    void d(DownloadInfo r5);

    void f(DownloadInfo r5);

    void g(DownloadInfo r5);

    void i(DownloadInfo r5);

    int j();

    void j(DownloadInfo r5);

    void l(DownloadInfo r5);

    void m(DownloadInfo r5);

    void n(DownloadInfo r5);

    void p(DownloadInfo r5);
}
