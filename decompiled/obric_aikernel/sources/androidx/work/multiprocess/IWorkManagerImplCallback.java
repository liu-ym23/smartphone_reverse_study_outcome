package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IWorkManagerImplCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.work.multiprocess.IWorkManagerImplCallback";

    public static class Default implements IWorkManagerImplCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.work.multiprocess.IWorkManagerImplCallback
        public void onFailure(String r10) {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImplCallback
        public void onSuccess(byte[] r10) {
        }
    }

    public static abstract class Stub extends Binder implements IWorkManagerImplCallback {
        static final int TRANSACTION_onFailure = 2;
        static final int TRANSACTION_onSuccess = 1;

        private static class Proxy implements IWorkManagerImplCallback {
            private IBinder mRemote;

            Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IWorkManagerImplCallback.DESCRIPTOR;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImplCallback
            public void onFailure(String r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(IWorkManagerImplCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeString(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImplCallback
            public void onSuccess(byte[] r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(IWorkManagerImplCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeByteArray(r10);     // Catch: Throwable -> L6
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
            attachInterface(this, IWorkManagerImplCallback.DESCRIPTOR);
        }

        public static IWorkManagerImplCallback asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(IWorkManagerImplCallback.DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IWorkManagerImplCallback) == false) goto L12;
            return (IWorkManagerImplCallback) r11;
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
            r11.enforceInterface(IWorkManagerImplCallback.DESCRIPTOR);
        L8:
            if (r10 == 1598968902) goto L17;
            if (r10 != 1) goto L11;
            onSuccess(r11.createByteArray());
        L16:
            return true;
        L11:
            if (r10 != 2) goto L13;
            onFailure(r11.readString());
            goto L16
        L13:
            return super.onTransact(r10, r11, r12, r13);
        L17:
            r12.writeString(IWorkManagerImplCallback.DESCRIPTOR);
            return true;
        }
    }

    void onFailure(String r10);

    void onSuccess(byte[] r10);
}
