package ib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface l extends IInterface {

    public static abstract class a extends Binder implements l {

        /* JADX INFO: renamed from: ib.l$a$a, reason: collision with other inner class name */
        private static class C0194a implements l {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static l f9468g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9469c;

            C0194a(IBinder r10) {
                this.f9469c = r10;
            }

            @Override // ib.l
            public boolean S(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");     // Catch: Throwable -> L20
                boolean r13 = true;
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L20
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f9469c.transact(2, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L20
                if (r12.readInt() != 0) goto L18;
                r13 = false;
            L18:
                r12.recycle();
                r11.recycle();
                return r13;
            L10:
                if (a.k1() == null) goto L14;
                boolean r14 = a.k1().S(r10);     // Catch: Throwable -> L20
                r12.recycle();
                r11.recycle();
                return r14;
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9469c;
            }

            @Override // ib.l
            public void m0(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L17
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L17
            L8:
                if (this.f9469c.transact(1, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().m0(r10);     // Catch: Throwable -> L17
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
        }

        public static l U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
            if (r11 == null) goto L12;
            if ((r11 instanceof l) == false) goto L12;
            return (l) r11;
        L12:
            return new C0194a(r10);
        }

        public static l k1() {
            return C0194a.f9468g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            DownloadInfo r14 = null;
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
            if (r11.readInt() == 0) goto L20;
            r14 = DownloadInfo.CREATOR.createFromParcel(r11);
        L20:
            m0(r14);
            r12.writeNoException();
            return true;
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
            if (r11.readInt() == 0) goto L15;
            r14 = DownloadInfo.CREATOR.createFromParcel(r11);
        L15:
            boolean r15 = S(r14);
            r12.writeNoException();
            r12.writeInt(r15 ? 1 : 0);
            return true;
        L7:
            if (r10 != 1598968902) goto L9;
            r12.writeString("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
            return true;
        L9:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    boolean S(DownloadInfo r10);

    void m0(DownloadInfo r10);
}
