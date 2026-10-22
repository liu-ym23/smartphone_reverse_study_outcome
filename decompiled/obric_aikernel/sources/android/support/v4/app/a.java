package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f139a = null;

    /* JADX INFO: renamed from: android.support.v4.app.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0004a extends Binder implements a {
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_cancelAll = 3;
        static final int TRANSACTION_notify = 1;

        /* JADX INFO: renamed from: android.support.v4.app.a$a$a, reason: collision with other inner class name */
        private static class C0005a implements a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private IBinder f140c;

            C0005a(IBinder r10) {
                this.f140c = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f140c;
            }

            @Override // android.support.v4.app.a
            public void cancel(String r10, int r11, String r12) {
                Parcel r13 = Parcel.obtain();
                r13.writeInterfaceToken(a.f139a);     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeInt(r11);     // Catch: Throwable -> L6
                r13.writeString(r12);     // Catch: Throwable -> L6
                this.f140c.transact(2, r13, null, 1);     // Catch: Throwable -> L6
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                throw th;
            }

            @Override // android.support.v4.app.a
            public void cancelAll(String r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(a.f139a);     // Catch: Throwable -> L6
                r11.writeString(r10);     // Catch: Throwable -> L6
                this.f140c.transact(3, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // android.support.v4.app.a
            public void notify(String r10, int r11, String r12, Notification r13) {
                Parcel r14 = Parcel.obtain();
                r14.writeInterfaceToken(a.f139a);     // Catch: Throwable -> L6
                r14.writeString(r10);     // Catch: Throwable -> L6
                r14.writeInt(r11);     // Catch: Throwable -> L6
                r14.writeString(r12);     // Catch: Throwable -> L6
                b.b(r14, r13, 0);     // Catch: Throwable -> L6
                this.f140c.transact(1, r14, null, 1);     // Catch: Throwable -> L6
                r14.recycle();
                return;
            L6:
                th = move-exception;
                r14.recycle();
                throw th;
            }
        }

        public AbstractBinderC0004a() {
            attachInterface(this, a.f139a);
        }

        public static a asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(a.f139a);
            if (r11 == null) goto L12;
            if ((r11 instanceof a) == false) goto L12;
            return (a) r11;
        L12:
            return new C0005a(r10);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            String r14 = a.f139a;
            if (r10 < 1) goto L8;
            if (r10 > 16777215) goto L8;
            r11.enforceInterface(r14);
        L8:
            if (r10 == 1598968902) goto L20;
            if (r10 != 1) goto L11;
            notify(r11.readString(), r11.readInt(), r11.readString(), (Notification) b.a(r11, Notification.CREATOR));
        L19:
            return true;
        L11:
            if (r10 != 2) goto L13;
            cancel(r11.readString(), r11.readInt(), r11.readString());
            goto L19
        L13:
            if (r10 != 3) goto L15;
            cancelAll(r11.readString());
            goto L19
        L15:
            return super.onTransact(r10, r11, r12, r13);
        L20:
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
        f139a = "android$support$v4$app$INotificationSideChannel".replace(Typography.dollar, '.');
    }

    void cancel(String r10, int r11, String r12);

    void cancelAll(String r10);

    void notify(String r10, int r11, String r12, Notification r13);
}
