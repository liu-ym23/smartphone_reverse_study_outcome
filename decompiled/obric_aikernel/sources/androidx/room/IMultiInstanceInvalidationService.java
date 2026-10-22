package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IMultiInstanceInvalidationService extends IInterface {
    public static final String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationService";

    public static class Default implements IMultiInstanceInvalidationService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int r10, String[] r11) {
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(IMultiInstanceInvalidationCallback r10, String r11) {
            return 0;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(IMultiInstanceInvalidationCallback r10, int r11) {
        }
    }

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationService {
        static final int TRANSACTION_broadcastInvalidation = 3;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;

        private static class Proxy implements IMultiInstanceInvalidationService {
            private IBinder mRemote;

            Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void broadcastInvalidation(int r10, String[] r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IMultiInstanceInvalidationService.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeInt(r10);     // Catch: Throwable -> L6
                r12.writeStringArray(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return IMultiInstanceInvalidationService.DESCRIPTOR;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public int registerCallback(IMultiInstanceInvalidationCallback r10, String r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IMultiInstanceInvalidationService.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeStrongInterface(r10);     // Catch: Throwable -> L6
                r12.writeString(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                int r14 = r13.readInt();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return r14;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void unregisterCallback(IMultiInstanceInvalidationCallback r10, int r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(IMultiInstanceInvalidationService.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeStrongInterface(r10);     // Catch: Throwable -> L6
                r12.writeInt(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r12, r13, 0);     // Catch: Throwable -> L6
                r13.readException();     // Catch: Throwable -> L6
                r13.recycle();
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IMultiInstanceInvalidationService.DESCRIPTOR);
        }

        public static IMultiInstanceInvalidationService asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(IMultiInstanceInvalidationService.DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IMultiInstanceInvalidationService) == false) goto L12;
            return (IMultiInstanceInvalidationService) r11;
        L12:
            return new Proxy(r10);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
            if (r10 < 1) goto L8;
            if (r10 > 16777215) goto L8;
            r11.enforceInterface(IMultiInstanceInvalidationService.DESCRIPTOR);
        L8:
            if (r10 == 1598968902) goto L20;
            if (r10 != 1) goto L11;
            int r14 = registerCallback(IMultiInstanceInvalidationCallback.Stub.asInterface(r11.readStrongBinder()), r11.readString());
            r12.writeNoException();
            r12.writeInt(r14);
        L19:
            return true;
        L11:
            if (r10 != 2) goto L13;
            unregisterCallback(IMultiInstanceInvalidationCallback.Stub.asInterface(r11.readStrongBinder()), r11.readInt());
            r12.writeNoException();
            goto L19
        L13:
            if (r10 != 3) goto L15;
            broadcastInvalidation(r11.readInt(), r11.createStringArray());
            goto L19
        L15:
            return super.onTransact(r10, r11, r12, r13);
        L20:
            r12.writeString(IMultiInstanceInvalidationService.DESCRIPTOR);
            return true;
        }
    }

    void broadcastInvalidation(int r10, String[] r11);

    int registerCallback(IMultiInstanceInvalidationCallback r10, String r11);

    void unregisterCallback(IMultiInstanceInvalidationCallback r10, int r11);
}
