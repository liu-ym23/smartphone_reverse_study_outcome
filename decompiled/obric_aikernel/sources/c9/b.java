package c9;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: c9.b$a$a, reason: collision with other inner class name */
        private static class C0029a implements b {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static b f641g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f642c;

            C0029a(IBinder r10) {
                this.f642c = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f642c;
            }

            @Override // c9.b
            public String getDeviceId() {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L13
                if (this.f642c.transact(1, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L13
                String r12 = r11.readString();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                if (a.k1() == null) goto L10;
                String r13 = a.k1().getDeviceId();     // Catch: Throwable -> L13
                r11.recycle();
                r10.recycle();
                return r13;
            L13:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // c9.b
            public void o1(c r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L17
                if (r10 == null) goto L6;
                IBinder r13 = r10.asBinder();     // Catch: Throwable -> L17
            L7:
                r11.writeStrongBinder(r13);     // Catch: Throwable -> L17
                if (this.f642c.transact(3, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (a.k1() == null) goto L14;
                a.k1().o1(r10);     // Catch: Throwable -> L17
                r12.recycle();
                r11.recycle();
                return;
            L6:
                r13 = null;
            L17:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // c9.b
            public void onEvent(String r10, String r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L13
                r12.writeString(r10);     // Catch: Throwable -> L13
                r12.writeString(r11);     // Catch: Throwable -> L13
                if (this.f642c.transact(5, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L13
                r13.recycle();
                r12.recycle();
                return;
            L6:
                if (a.k1() == null) goto L10;
                a.k1().onEvent(r10, r11);     // Catch: Throwable -> L13
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

        public static b U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");
            if (r11 == null) goto L12;
            if ((r11 instanceof b) == false) goto L12;
            return (b) r11;
        L12:
            return new C0029a(r10);
        }

        public static b k1() {
            return C0029a.f641g;
        }
    }

    String getDeviceId();

    void o1(c r10);

    void onEvent(String r10, String r11);
}
