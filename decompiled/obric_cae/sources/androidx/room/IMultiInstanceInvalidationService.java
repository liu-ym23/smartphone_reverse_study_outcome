package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IMultiInstanceInvalidationService extends IInterface {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f2578e = null;

    public static class Default implements IMultiInstanceInvalidationService {
        public Default() {
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public final int F1(IMultiInstanceInvalidationCallback r8, String r10) {
            return 0;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public final void G2(IMultiInstanceInvalidationCallback r8, int r10) {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public final void b1(int r8, String[] r10) {
        }
    }

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationService {

        public static class Proxy implements IMultiInstanceInvalidationService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f2579a;

            public Proxy(IBinder r8) {
                this.f2579a = r8;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public final int F1(IMultiInstanceInvalidationCallback r8, String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IMultiInstanceInvalidationService.f2578e);     // Catch: Throwable -> L6
                r11.writeStrongInterface(r8);     // Catch: Throwable -> L6
                r11.writeString(r10);     // Catch: Throwable -> L6
                this.f2579a.transact(1, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                int r13 = r12.readInt();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return r13;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public final void G2(IMultiInstanceInvalidationCallback r8, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(IMultiInstanceInvalidationService.f2578e);     // Catch: Throwable -> L6
                r11.writeStrongInterface(r8);     // Catch: Throwable -> L6
                r11.writeInt(r10);     // Catch: Throwable -> L6
                this.f2579a.transact(2, r11, r12, 0);     // Catch: Throwable -> L6
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f2579a;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public final void b1(int r8, String[] r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(IMultiInstanceInvalidationService.f2578e);     // Catch: Throwable -> L6
                r11.writeInt(r8);     // Catch: Throwable -> L6
                r11.writeStringArray(r10);     // Catch: Throwable -> L6
                this.f2579a.transact(3, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IMultiInstanceInvalidationService.f2578e);
        }

        public static IMultiInstanceInvalidationService H2(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(IMultiInstanceInvalidationService.f2578e);
            if (r10 == null) goto L12;
            if ((r10 instanceof IMultiInstanceInvalidationService) == false) goto L12;
            return (IMultiInstanceInvalidationService) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            String r13 = IMultiInstanceInvalidationService.f2578e;
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r10.enforceInterface(r13);
        L8:
            if (r8 != 1598968902) goto L11;
            r11.writeString(r13);
            return true;
        L11:
            if (r8 != 1) goto L13;
            MultiInstanceInvalidationService$binder$1 r14 = (MultiInstanceInvalidationService$binder$1) this;
            int r15 = r14.F1(IMultiInstanceInvalidationCallback.Stub.H2(r10.readStrongBinder()), r10.readString());
            r11.writeNoException();
            r11.writeInt(r15);
        L21:
            return true;
        L13:
            if (r8 != 2) goto L15;
            MultiInstanceInvalidationService$binder$1 r16 = (MultiInstanceInvalidationService$binder$1) this;
            r16.G2(IMultiInstanceInvalidationCallback.Stub.H2(r10.readStrongBinder()), r10.readInt());
            r11.writeNoException();
            goto L21
        L15:
            if (r8 != 3) goto L17;
            MultiInstanceInvalidationService$binder$1 r17 = (MultiInstanceInvalidationService$binder$1) this;
            r17.b1(r10.readInt(), r10.createStringArray());
            goto L21
        L17:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    static {
        f2578e = "androidx$room$IMultiInstanceInvalidationService".replace('$', '.');
    }

    int F1(IMultiInstanceInvalidationCallback r8, String r10);

    void G2(IMultiInstanceInvalidationCallback r8, int r10);

    void b1(int r8, String[] r10);
}
