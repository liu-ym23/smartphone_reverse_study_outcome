package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f211b = null;

    /* JADX INFO: renamed from: android.support.v4.os.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0013a extends Binder implements a {

        /* JADX INFO: renamed from: android.support.v4.os.a$a$a, reason: collision with other inner class name */
        private static class C0014a implements a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f212c;

            C0014a(IBinder r10) {
                this.f212c = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f212c;
            }

            @Override // android.support.v4.os.a
            public void n2(int r10, Bundle r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(a.f211b);     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                b.b(r12, r11, 0);     // Catch: Throwable -> L6
                this.f212c.transact(1, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }
        }

        public AbstractBinderC0013a() {
            attachInterface(this, a.f211b);
        }

        public static a U0(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(a.f211b);
            if (r11 == null) goto L12;
            if ((r11 instanceof a) == false) goto L12;
            return (a) r11;
        L12:
            return new C0014a(r10);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            String r14 = a.f211b;
            if (r10 < 1) goto L8;
            if (r10 > 16777215) goto L8;
            r11.enforceInterface(r14);
        L8:
            if (r10 == 1598968902) goto L14;
            if (r10 != 1) goto L11;
            n2(r11.readInt(), (Bundle) b.a(r11, Bundle.CREATOR));
            return true;
        L11:
            return super.onTransact(r10, r11, r12, r13);
        L14:
            r12.writeString(r14);
            return true;
        }
    }

    public static class b {
        static /* synthetic */ Object a(Parcel r10, Parcelable.Creator r11) {
            return c(r10, r11);
        }

        static /* synthetic */ void b(Parcel r10, Parcelable r11, int r12) {
            d(r10, r11, r12);
        }

        private static <T> T c(Parcel r10, Parcelable.Creator<T> r11) {
            if (r10.readInt() != 0) goto L5;
            return null;
        L5:
            return r11.createFromParcel(r10);
        }

        private static <T extends Parcelable> void d(Parcel r10, T r11, int r12) {
            if (r11 == null) goto L4;
            r10.writeInt(1);
            r11.writeToParcel(r10, r12);
            return;
        L4:
            r10.writeInt(0);
        }
    }

    static {
        f211b = "android$support$v4$os$IResultReceiver".replace(Typography.dollar, '.');
    }

    void n2(int r10, Bundle r11);
}
