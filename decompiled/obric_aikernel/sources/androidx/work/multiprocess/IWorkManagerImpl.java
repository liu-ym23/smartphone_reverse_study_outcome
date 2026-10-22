package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IWorkManagerImpl extends IInterface {
    public static final String DESCRIPTOR = "androidx.work.multiprocess.IWorkManagerImpl";

    public static class Default implements IWorkManagerImpl {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelAllWork(IWorkManagerImplCallback r10) {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelAllWorkByTag(String r10, IWorkManagerImplCallback r11) {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelUniqueWork(String r10, IWorkManagerImplCallback r11) {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelWorkById(String r10, IWorkManagerImplCallback r11) {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void enqueueContinuation(byte[] r10, IWorkManagerImplCallback r11) {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void enqueueWorkRequests(byte[] r10, IWorkManagerImplCallback r11) {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void queryWorkInfo(byte[] r10, IWorkManagerImplCallback r11) {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void setForegroundAsync(byte[] r10, IWorkManagerImplCallback r11) {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void setProgress(byte[] r10, IWorkManagerImplCallback r11) {
        }

        @Override // androidx.work.multiprocess.IWorkManagerImpl
        public void updateUniquePeriodicWorkRequest(String r10, byte[] r11, IWorkManagerImplCallback r12) {
        }
    }

    public static abstract class Stub extends Binder implements IWorkManagerImpl {
        static final int TRANSACTION_cancelAllWork = 7;
        static final int TRANSACTION_cancelAllWorkByTag = 5;
        static final int TRANSACTION_cancelUniqueWork = 6;
        static final int TRANSACTION_cancelWorkById = 4;
        static final int TRANSACTION_enqueueContinuation = 3;
        static final int TRANSACTION_enqueueWorkRequests = 1;
        static final int TRANSACTION_queryWorkInfo = 8;
        static final int TRANSACTION_setForegroundAsync = 10;
        static final int TRANSACTION_setProgress = 9;
        static final int TRANSACTION_updateUniquePeriodicWorkRequest = 2;

        private static class Proxy implements IWorkManagerImpl {
            private IBinder mRemote;

            Proxy(IBinder r10) {
                this.mRemote = r10;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelAllWork(IWorkManagerImplCallback r10) {
                Parcel r11 = Parcel.obtain();
                r11.writeInterfaceToken(IWorkManagerImpl.DESCRIPTOR);     // Catch: Throwable -> L6
                r11.writeStrongInterface(r10);     // Catch: Throwable -> L6
                this.mRemote.transact(7, r11, null, 1);     // Catch: Throwable -> L6
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelAllWorkByTag(String r10, IWorkManagerImplCallback r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IWorkManagerImpl.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                r12.writeStrongInterface(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelUniqueWork(String r10, IWorkManagerImplCallback r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IWorkManagerImpl.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                r12.writeStrongInterface(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(6, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelWorkById(String r10, IWorkManagerImplCallback r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IWorkManagerImpl.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeString(r10);     // Catch: Throwable -> L6
                r12.writeStrongInterface(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(4, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void enqueueContinuation(byte[] r10, IWorkManagerImplCallback r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IWorkManagerImpl.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeByteArray(r10);     // Catch: Throwable -> L6
                r12.writeStrongInterface(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(3, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void enqueueWorkRequests(byte[] r10, IWorkManagerImplCallback r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IWorkManagerImpl.DESCRIPTOR);     // Catch: Throwable -> L6
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

            public String getInterfaceDescriptor() {
                return IWorkManagerImpl.DESCRIPTOR;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void queryWorkInfo(byte[] r10, IWorkManagerImplCallback r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IWorkManagerImpl.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeByteArray(r10);     // Catch: Throwable -> L6
                r12.writeStrongInterface(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(8, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void setForegroundAsync(byte[] r10, IWorkManagerImplCallback r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IWorkManagerImpl.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeByteArray(r10);     // Catch: Throwable -> L6
                r12.writeStrongInterface(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void setProgress(byte[] r10, IWorkManagerImplCallback r11) {
                Parcel r12 = Parcel.obtain();
                r12.writeInterfaceToken(IWorkManagerImpl.DESCRIPTOR);     // Catch: Throwable -> L6
                r12.writeByteArray(r10);     // Catch: Throwable -> L6
                r12.writeStrongInterface(r11);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r12, null, 1);     // Catch: Throwable -> L6
                r12.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                throw th;
            }

            @Override // androidx.work.multiprocess.IWorkManagerImpl
            public void updateUniquePeriodicWorkRequest(String r10, byte[] r11, IWorkManagerImplCallback r12) {
                Parcel r13 = Parcel.obtain();
                r13.writeInterfaceToken(IWorkManagerImpl.DESCRIPTOR);     // Catch: Throwable -> L6
                r13.writeString(r10);     // Catch: Throwable -> L6
                r13.writeByteArray(r11);     // Catch: Throwable -> L6
                r13.writeStrongInterface(r12);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r13, null, 1);     // Catch: Throwable -> L6
                r13.recycle();
                return;
            L6:
                th = move-exception;
                r13.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, IWorkManagerImpl.DESCRIPTOR);
        }

        public static IWorkManagerImpl asInterface(IBinder r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IInterface r11 = r10.queryLocalInterface(IWorkManagerImpl.DESCRIPTOR);
            if (r11 == null) goto L12;
            if ((r11 instanceof IWorkManagerImpl) == false) goto L12;
            return (IWorkManagerImpl) r11;
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
            r11.enforceInterface(IWorkManagerImpl.DESCRIPTOR);
        L8:
            if (r10 == 1598968902) goto L23;
            switch(r10) {
                case 1: goto L21;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                default: goto L11;
            };
        L12:
            setForegroundAsync(r11.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(r11.readStrongBinder()));
        L22:
            return true;
        L13:
            setProgress(r11.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(r11.readStrongBinder()));
            goto L22
        L14:
            queryWorkInfo(r11.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(r11.readStrongBinder()));
            goto L22
        L15:
            cancelAllWork(IWorkManagerImplCallback.Stub.asInterface(r11.readStrongBinder()));
            goto L22
        L16:
            cancelUniqueWork(r11.readString(), IWorkManagerImplCallback.Stub.asInterface(r11.readStrongBinder()));
            goto L22
        L17:
            cancelAllWorkByTag(r11.readString(), IWorkManagerImplCallback.Stub.asInterface(r11.readStrongBinder()));
            goto L22
        L18:
            cancelWorkById(r11.readString(), IWorkManagerImplCallback.Stub.asInterface(r11.readStrongBinder()));
            goto L22
        L19:
            enqueueContinuation(r11.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(r11.readStrongBinder()));
            goto L22
        L20:
            updateUniquePeriodicWorkRequest(r11.readString(), r11.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(r11.readStrongBinder()));
            goto L22
        L21:
            enqueueWorkRequests(r11.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(r11.readStrongBinder()));
            goto L22
        L11:
            return super.onTransact(r10, r11, r12, r13);
        L23:
            r12.writeString(IWorkManagerImpl.DESCRIPTOR);
            return true;
        }
    }

    void cancelAllWork(IWorkManagerImplCallback r10);

    void cancelAllWorkByTag(String r10, IWorkManagerImplCallback r11);

    void cancelUniqueWork(String r10, IWorkManagerImplCallback r11);

    void cancelWorkById(String r10, IWorkManagerImplCallback r11);

    void enqueueContinuation(byte[] r10, IWorkManagerImplCallback r11);

    void enqueueWorkRequests(byte[] r10, IWorkManagerImplCallback r11);

    void queryWorkInfo(byte[] r10, IWorkManagerImplCallback r11);

    void setForegroundAsync(byte[] r10, IWorkManagerImplCallback r11);

    void setProgress(byte[] r10, IWorkManagerImplCallback r11);

    void updateUniquePeriodicWorkRequest(String r10, byte[] r11, IWorkManagerImplCallback r12);
}
