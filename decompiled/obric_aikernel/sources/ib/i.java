package ib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface i extends IInterface {

    public static abstract class a extends Binder implements i {

        /* JADX INFO: renamed from: ib.i$a$a, reason: collision with other inner class name */
        private static class C0192a implements i {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static i f9464g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9465c;

            C0192a(IBinder r10) {
                this.f9465c = r10;
            }

            @Override // ib.i
            public int[] K1() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");     // Catch: Throwable -> L13
                if (this.f9465c.transact(3, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                int[] r12 = r11.createIntArray();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (a.k1() == null) goto L10;
                int[] r13 = a.k1().K1();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // ib.i
            public String T() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");     // Catch: Throwable -> L13
                if (this.f9465c.transact(2, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                String r12 = r11.readString();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (a.k1() == null) goto L10;
                String r13 = a.k1().T();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // ib.i
            public void Z1(String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");     // Catch: Throwable -> L13
                r11.writeString(r10);     // Catch: Throwable -> L13
                if (this.f9465c.transact(1, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().Z1(r10);     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L13:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9465c;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
        }

        public static i U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            if (r11 == null) goto L12;
            if ((r11 instanceof i) == false) goto L12;
            return (i) r11;
        L12:
            return new C0192a(r10);
        }

        public static i k1() {
            return C0192a.f9464g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            Z1(r11.readString());
            r12.writeNoException();
            return true;
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            String r14 = T();
            r12.writeNoException();
            r12.writeString(r14);
            return true;
        L7:
            if (r10 != 3) goto L9;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            int[] r15 = K1();
            r12.writeNoException();
            r12.writeIntArray(r15);
            return true;
        L9:
            if (r10 != 1598968902) goto L11;
            r12.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            return true;
        L11:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    int[] K1();

    String T();

    void Z1(String r10);
}
