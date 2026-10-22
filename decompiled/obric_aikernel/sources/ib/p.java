package ib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface p extends IInterface {

    public static abstract class a extends Binder implements p {

        /* JADX INFO: renamed from: ib.p$a$a, reason: collision with other inner class name */
        private static class C0196a implements p {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static p f9472g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9473c;

            C0196a(IBinder r10) {
                this.f9473c = r10;
            }

            @Override // ib.p
            public void C0() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");     // Catch: Throwable -> L13
                if (this.f9473c.transact(1, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().C0();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9473c;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
        }

        public static p U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            if (r11 == null) goto L12;
            if ((r11 instanceof p) == false) goto L12;
            return (p) r11;
        L12:
            return new C0196a(r10);
        }

        public static p k1() {
            return C0196a.f9472g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            C0();
            r12.writeNoException();
            return true;
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void C0();
}
