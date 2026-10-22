package f9;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: f9.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0167a extends Binder implements a {

        /* JADX INFO: renamed from: f9.a$a$a, reason: collision with other inner class name */
        private static class C0168a implements a {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static a f8878g;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f8879c;

            C0168a(IBinder r10) {
                this.f8879c = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8879c;
            }

            @Override // f9.a
            public void z1(String r10, b r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken("com.obric.matrix.platform.server.IServerBroker");     // Catch: Throwable -> L17
                r12.writeString(r10);     // Catch: Throwable -> L17
                if (r11 == null) goto L6;
                IBinder r14 = r11.asBinder();     // Catch: Throwable -> L17
            L7:
                r12.writeStrongBinder(r14);     // Catch: Throwable -> L17
                if (this.f8879c.transact(3, r12, r13, 0) == false) goto L10;
            L14:
                r13.readException();     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L10:
                if (AbstractBinderC0167a.k1() == null) goto L14;
                AbstractBinderC0167a.k1().z1(r10, r11);     // Catch: Throwable -> L17
                r13.recycle();
                r12.recycle();
                return;
            L6:
                r14 = null;
            L17:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }
        }

        public static a U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface("com.obric.matrix.platform.server.IServerBroker");
            if (r11 == null) goto L12;
            if ((r11 instanceof a) == false) goto L12;
            return (a) r11;
        L12:
            return new C0168a(r10);
        }

        public static a k1() {
            return C0168a.f8878g;
        }
    }

    void z1(String r10, b r11);
}
