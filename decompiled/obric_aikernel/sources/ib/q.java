package ib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface q extends IInterface {

    public static abstract class a extends Binder implements q {

        /* JADX INFO: renamed from: ib.q$a$a, reason: collision with other inner class name */
        private static class C0197a implements q {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static q f9474g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9475c;

            C0197a(IBinder r10) {
                this.f9475c = r10;
            }

            @Override // ib.q
            public boolean P0(long r11, long r13, p r15) {
                Parcel r10 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");     // Catch: Throwable -> L19
                r10.writeLong(r11);     // Catch: Throwable -> L19
                r10.writeLong(r13);     // Catch: Throwable -> L19
                if (r15 == null) goto L6;
                IBinder r14 = r15.asBinder();     // Catch: Throwable -> L19
            L7:
                r10.writeStrongBinder(r14);     // Catch: Throwable -> L19
                boolean r16 = false;
                if (this.f9475c.transact(1, r10, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L19
                if (r12.readInt() == 0) goto L17;
                r16 = true;
            L17:
                r12.recycle();
                r10.recycle();
                return r16;
            L10:
                if (a.k1() == null) goto L14;
                boolean r17 = a.k1().P0(r11, r13, r15);     // Catch: Throwable -> L19
                r12.recycle();
                r10.recycle();
                return r17;
            L6:
                r14 = null;
            L19:
                th = move-exception;
                r12.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9475c;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        public static q U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            if (r11 == null) goto L12;
            if ((r11 instanceof q) == false) goto L12;
            return (q) r11;
        L12:
            return new C0197a(r10);
        }

        public static q k1() {
            return C0197a.f9474g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            boolean r14 = P0(r11.readLong(), r11.readLong(), p.a.U0(r11.readStrongBinder()));
            r12.writeNoException();
            r12.writeInt(r14 ? 1 : 0);
            return true;
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    boolean P0(long r10, long r11, p r12);
}
