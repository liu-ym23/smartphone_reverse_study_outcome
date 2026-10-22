package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IMultiInstanceInvalidationCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationCallback";

    public static class Default implements IMultiInstanceInvalidationCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void onInvalidation(String[] r5) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationCallback {
        static final int TRANSACTION_onInvalidation = 1;

        public static class Proxy implements IMultiInstanceInvalidationCallback {
            private IBinder mRemote;

            public Proxy(IBinder r5) {
                this.mRemote = r5;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IMultiInstanceInvalidationCallback.DESCRIPTOR;
            }

            @Override // androidx.room.IMultiInstanceInvalidationCallback
            public void onInvalidation(String[] r5) throws RemoteException {
                Parcel r10 = Parcel.obtain();
                r10.writeInterfaceToken(IMultiInstanceInvalidationCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r10.writeStringArray(r5);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r10, null, 1);     // Catch: Throwable -> L6
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IMultiInstanceInvalidationCallback.DESCRIPTOR);
        }

        public static IMultiInstanceInvalidationCallback asInterface(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface(IMultiInstanceInvalidationCallback.DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof IMultiInstanceInvalidationCallback) == false) goto L12;
            return (IMultiInstanceInvalidationCallback) r10;
        L12:
            return new Proxy(r5);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) throws RemoteException {
            if (r5 < 1) goto L8;
            if (r5 > 16777215) goto L8;
            r10.enforceInterface(IMultiInstanceInvalidationCallback.DESCRIPTOR);
        L8:
            if (r5 == 1598968902) goto L14;
            if (r5 != 1) goto L11;
            onInvalidation(r10.createStringArray());
            return true;
        L11:
            return super.onTransact(r5, r10, r11, r12);
        L14:
            r11.writeString(IMultiInstanceInvalidationCallback.DESCRIPTOR);
            return true;
        }
    }

    void onInvalidation(String[] r5) throws RemoteException;
}
