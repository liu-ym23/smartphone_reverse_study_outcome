package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface INotificationSideChannel extends IInterface {

    public static class Default implements INotificationSideChannel {
        public Default() {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public final void D2(String r8, int r10, String r11, Notification r12) {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public final void E1(String r8) {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public final void Y(int r8, String r10, String r11) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements INotificationSideChannel {

        public static class Proxy implements INotificationSideChannel {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f381a;

            public Proxy(IBinder r8) {
                this.f381a = r8;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public final void D2(String r8, int r10, String r11, Notification r12) {
                Parcel r13 = Parcel.obtain();
                r13.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");     // Catch: Throwable -> L10
                r13.writeString(r8);     // Catch: Throwable -> L10
                r13.writeInt(r10);     // Catch: Throwable -> L10
                r13.writeString(r11);     // Catch: Throwable -> L10
                if (r12 == null) goto L6;
                r13.writeInt(1);     // Catch: Throwable -> L10
                r12.writeToParcel(r13, 0);     // Catch: Throwable -> L10
            L7:
                this.f381a.transact(1, r13, null, 1);     // Catch: Throwable -> L10
                r13.recycle();
                return;
            L6:
                r13.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r13.recycle();
                throw th;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public final void E1(String r8) {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");     // Catch: Throwable -> L6
                r10.writeString(r8);     // Catch: Throwable -> L6
                this.f381a.transact(3, r10, null, 1);     // Catch: Throwable -> L6
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r10.recycle();
                throw th;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public final void Y(int r8, String r10, String r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                r12.writeInt(r8);     // Catch: Throwable -> L6
                r12.writeString(r11);     // Catch: Throwable -> L6
                this.f381a.transact(2, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f381a;
            }
        }

        public Stub() {
            attachInterface(this, "android.support.v4.app.INotificationSideChannel");
        }

        public static INotificationSideChannel H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            if (r10 == null) goto L12;
            if ((r10 instanceof INotificationSideChannel) == false) goto L12;
            return (INotificationSideChannel) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r10.enforceInterface("android.support.v4.app.INotificationSideChannel");
        L8:
            if (r8 != 1598968902) goto L10;
            r11.writeString("android.support.v4.app.INotificationSideChannel");
            return true;
        L10:
            if (r8 != 1) goto L12;
            D2(r10.readString(), r10.readInt(), r10.readString(), (Notification) a.a(r10, Notification.CREATOR));
            throw null;
        L12:
            if (r8 != 2) goto L14;
            String r13 = r10.readString();
            Y(r10.readInt(), r13, r10.readString());
            throw null;
        L14:
            if (r8 != 3) goto L16;
            E1(r10.readString());
            throw null;
        L16:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    public static class a {
        public static Object a(Parcel r8, Parcelable.Creator r10) {
            if (r8.readInt() != 0) goto L7;
            return null;
        L7:
            return r10.createFromParcel(r8);
        }
    }

    void D2(String r8, int r10, String r11, Notification r12);

    void E1(String r8);

    void Y(int r8, String r10, String r11);
}
