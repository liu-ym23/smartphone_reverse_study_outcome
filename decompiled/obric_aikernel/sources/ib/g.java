package ib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface g extends IInterface {

    public static abstract class a extends Binder implements g {

        /* JADX INFO: renamed from: ib.g$a$a, reason: collision with other inner class name */
        private static class C0190a implements g {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static g f9460g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9461c;

            C0190a(IBinder r10) {
                this.f9461c = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9461c;
            }

            @Override // ib.g
            public boolean g2() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");     // Catch: Throwable -> L15
                boolean r12 = false;
                if (this.f9461c.transact(1, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L15
                if (r11.readInt() == 0) goto L13;
                r12 = true;
            L13:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (a.k1() == null) goto L10;
                boolean r13 = a.k1().g2();     // Catch: Throwable -> L15
                r11.recycle();
                r10.recycle();
                return r13;
            L15:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
        }

        public static g U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            if (r11 == null) goto L12;
            if ((r11 instanceof g) == false) goto L12;
            return (g) r11;
        L12:
            return new C0190a(r10);
        }

        public static g k1() {
            return C0190a.f9460g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            boolean r14 = g2();
            r12.writeNoException();
            r12.writeInt(r14 ? 1 : 0);
            return true;
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    boolean g2();
}
