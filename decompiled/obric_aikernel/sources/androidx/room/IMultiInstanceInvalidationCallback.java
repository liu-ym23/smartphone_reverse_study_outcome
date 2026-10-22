package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

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
        public void onInvalidation(String[] r10) {
        }
    }

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationCallback {
        static final int TRANSACTION_onInvalidation = 1;

        private static class Proxy implements IMultiInstanceInvalidationCallback {
            private IBinder mRemote;

            Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IMultiInstanceInvalidationCallback.DESCRIPTOR;
            }

            @Override // androidx.room.IMultiInstanceInvalidationCallback
            public void onInvalidation(String[] r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(IMultiInstanceInvalidationCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeStringArray(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IMultiInstanceInvalidationCallback.DESCRIPTOR);
        }

        public static IMultiInstanceInvalidationCallback asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(IMultiInstanceInvalidationCallback.DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IMultiInstanceInvalidationCallback) == false) goto L12;
            return (IMultiInstanceInvalidationCallback) r11;
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
            r11.enforceInterface(IMultiInstanceInvalidationCallback.DESCRIPTOR);
        L8:
            if (r10 == 1598968902) goto L14;
            if (r10 != 1) goto L11;
            onInvalidation(r11.createStringArray());
            return true;
        L11:
            return super.onTransact(r10, r11, r12, r13);
        L14:
            r12.writeString(IMultiInstanceInvalidationCallback.DESCRIPTOR);
            return true;
        }
    }

    void onInvalidation(String[] r10);
}
