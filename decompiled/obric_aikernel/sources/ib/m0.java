package ib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface m0 extends IInterface {

    public static abstract class a extends Binder implements m0 {

        /* JADX INFO: renamed from: ib.m0$a$a, reason: collision with other inner class name */
        private static class C0195a implements m0 {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static m0 f9470g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f9471c;

            C0195a(IBinder r10) {
                this.f9471c = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9471c;
            }

            @Override // ib.m0
            public void x0(int r10, int r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");     // Catch: Throwable -> L13
                r12.writeInt(r10);     // Catch: Throwable -> L13
                r12.writeInt(r11);     // Catch: Throwable -> L13
                if (this.f9471c.transact(1, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L13
                r13.recycle();
                r12.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().x0(r10, r11);     // Catch: Throwable -> L13
                r13.recycle();
                r12.recycle();
                return;
            L13:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        public static m0 U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            if (r11 == null) goto L12;
            if ((r11 instanceof m0) == false) goto L12;
            return (m0) r11;
        L12:
            return new C0195a(r10);
        }

        public static m0 k1() {
            return C0195a.f9470g;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 != 1) goto L5;
            r11.enforceInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            x0(r11.readInt(), r11.readInt());
            r12.writeNoException();
            return true;
        L5:
            if (r10 != 1598968902) goto L7;
            r12.writeString("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            return true;
        L7:
            return super.onTransact(r10, r11, r12, r13);
        }
    }

    void x0(int r10, int r11);
}
