package ib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface v extends IInterface {

    public static abstract class a extends Binder implements v {

        /* JADX INFO: renamed from: ib.v$a$a, reason: collision with other inner class name */
        private static class C0198a implements v {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static v f9476g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9477c;

            C0198a(IBinder r10) {
                this.f9477c = r10;
            }

            @Override // ib.v
            public void H(List<String> r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");     // Catch: Throwable -> L13
                r11.writeStringList(r10);     // Catch: Throwable -> L13
                if (this.f9477c.transact(1, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L13
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().H(r10);     // Catch: Throwable -> L13
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
                return this.f9477c;
            }

            @Override // ib.v
            public boolean c0() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");     // Catch: Throwable -> L15
                boolean r12 = false;
                if (this.f9477c.transact(2, r10, r11, 0) == false) goto L6;
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
                boolean r13 = a.k1().c0();     // Catch: Throwable -> L15
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
        }

        public static v U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            if (r11 == null) goto L12;
            if ((r11 instanceof v) == false) goto L12;
            return (v) r11;
        L12:
            return new C0198a(r10);
        }

        public static v k1() {
            return C0198a.f9476g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            H(r11.createStringArrayList());
            r12.writeNoException();
            return true;
        L5:
            if (r10 != 2) goto L7;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            boolean r14 = c0();
            r12.writeNoException();
            r12.writeInt(r14 ? 1 : 0);
            return true;
        L7:
            if (r10 != 1598968902) goto L9;
            r12.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            return true;
        L9:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void H(List<String> r10);

    boolean c0();
}
