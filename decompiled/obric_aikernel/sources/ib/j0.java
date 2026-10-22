package ib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface j0 extends IInterface {

    public static abstract class a extends Binder implements j0 {

        /* JADX INFO: renamed from: ib.j0$a$a, reason: collision with other inner class name */
        private static class C0193a implements j0 {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static j0 f9466g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9467c;

            C0193a(IBinder r10) {
                this.f9467c = r10;
            }

            @Override // ib.j0
            public boolean B(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");     // Catch: Throwable -> L20
                boolean r13 = true;
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L20
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f9467c.transact(1, r11, r12, 0) == false) goto L10;
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
                boolean r14 = a.k1().B(r10);     // Catch: Throwable -> L20
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

            @Override // ib.j0
            public boolean J(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");     // Catch: Throwable -> L20
                boolean r13 = true;
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L20
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f9467c.transact(3, r11, r12, 0) == false) goto L10;
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
                boolean r14 = a.k1().J(r10);     // Catch: Throwable -> L20
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
                return this.f9467c;
            }

            @Override // ib.j0
            public boolean e0(DownloadInfo r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");     // Catch: Throwable -> L20
                boolean r13 = true;
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L20
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f9467c.transact(2, r11, r12, 0) == false) goto L10;
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
                boolean r14 = a.k1().e0(r10);     // Catch: Throwable -> L20
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
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
        }

        public static j0 U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (r11 == null) goto L12;
            if ((r11 instanceof j0) == false) goto L12;
            return (j0) r11;
        L12:
            return new C0193a(r10);
        }

        public static j0 k1() {
            return C0193a.f9466g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            DownloadInfo r14 = null;
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (r11.readInt() == 0) goto L27;
            r14 = DownloadInfo.CREATOR.createFromParcel(r11);
        L27:
            boolean r15 = B(r14);
            r12.writeNoException();
            r12.writeInt(r15 ? 1 : 0);
            return true;
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (r11.readInt() == 0) goto L22;
            r14 = DownloadInfo.CREATOR.createFromParcel(r11);
        L22:
            boolean r16 = e0(r14);
            r12.writeNoException();
            r12.writeInt(r16 ? 1 : 0);
            return true;
        L7:
            if (r10 != 3) goto L9;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (r11.readInt() == 0) goto L17;
            r14 = DownloadInfo.CREATOR.createFromParcel(r11);
        L17:
            boolean r17 = J(r14);
            r12.writeNoException();
            r12.writeInt(r17 ? 1 : 0);
            return true;
        L9:
            if (r10 != 1598968902) goto L11;
            r12.writeString("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            return true;
        L11:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    boolean B(DownloadInfo r10);

    boolean J(DownloadInfo r10);

    boolean e0(DownloadInfo r10);
}
