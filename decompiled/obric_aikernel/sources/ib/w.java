package ib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface w extends IInterface {

    public static abstract class a extends Binder implements w {

        /* JADX INFO: renamed from: ib.w$a$a, reason: collision with other inner class name */
        private static class C0199a implements w {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static w f9478g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9479c;

            C0199a(IBinder r10) {
                this.f9479c = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9479c;
            }

            @Override // ib.w
            public boolean p1(v r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");     // Catch: Throwable -> L19
                if (r10 == null) goto L6;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L19
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L19
                boolean r14 = false;
                if (this.f9479c.transact(1, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L19
                if (r12.readInt() == 0) goto L17;
                r14 = true;
            L17:
                r12.recycle();
                r11.recycle();
                return r14;
            L10:
                if (a.k1() == null) goto L14;
                boolean r15 = a.k1().p1(r10);     // Catch: Throwable -> L19
                r12.recycle();
                r11.recycle();
                return r15;
            L6:
                r13 = null;
            L19:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        public static w U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            if (r11 == null) goto L12;
            if ((r11 instanceof w) == false) goto L12;
            return (w) r11;
        L12:
            return new C0199a(r10);
        }

        public static w k1() {
            return C0199a.f9478g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            boolean r14 = p1(v.a.U0(r11.readStrongBinder()));
            r12.writeNoException();
            r12.writeInt(r14 ? 1 : 0);
            return true;
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    boolean p1(v r10);
}
