package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IListenableWorkerImpl extends IInterface {
    public static final String DESCRIPTOR = "androidx.work.multiprocess.IListenableWorkerImpl";

    public static class Default implements IListenableWorkerImpl {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.work.multiprocess.IListenableWorkerImpl
        public void interrupt(byte[] r10, IWorkManagerImplCallback r11) {
        }

        @Override // androidx.work.multiprocess.IListenableWorkerImpl
        public void startWork(byte[] r10, IWorkManagerImplCallback r11) {
        }
    }

    public static abstract class Stub extends Binder implements IListenableWorkerImpl {
        static final int TRANSACTION_interrupt = 2;
        static final int TRANSACTION_startWork = 1;

        private static class Proxy implements IListenableWorkerImpl {
            private IBinder mRemote;

            Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IListenableWorkerImpl.DESCRIPTOR;
            }

            @Override // androidx.work.multiprocess.IListenableWorkerImpl
            public void interrupt(byte[] r10, IWorkManagerImplCallback r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IListenableWorkerImpl.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeByteArray(r10);     // Catch: Throwable -> L6
                r12.writeStrongInterface(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IListenableWorkerImpl
            public void startWork(byte[] r10, IWorkManagerImplCallback r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IListenableWorkerImpl.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeByteArray(r10);     // Catch: Throwable -> L6
                r12.writeStrongInterface(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(1, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IListenableWorkerImpl.DESCRIPTOR);
        }

        public static IListenableWorkerImpl asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(IListenableWorkerImpl.DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IListenableWorkerImpl) == false) goto L12;
            return (IListenableWorkerImpl) r11;
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
            r11.enforceInterface(IListenableWorkerImpl.DESCRIPTOR);
        L8:
            if (r10 == 1598968902) goto L17;
            if (r10 != 1) goto L11;
            startWork(r11.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(r11.readStrongBinder()));
        L16:
            return true;
        L11:
            if (r10 != 2) goto L13;
            interrupt(r11.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(r11.readStrongBinder()));
            goto L16
        L13:
            return super.onTransact(r10, r11, r12, r13);
        L17:
            r12.writeString(IListenableWorkerImpl.DESCRIPTOR);
            return true;
        }
    }

    void interrupt(byte[] r10, IWorkManagerImplCallback r11);

    void startWork(byte[] r10, IWorkManagerImplCallback r11);
}
