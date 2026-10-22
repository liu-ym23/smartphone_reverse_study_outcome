package com.obric.cae.libs.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeNetworkHandoverManager extends IInterface {

    public static class Default implements ICaeNetworkHandoverManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.network.ICaeNetworkHandoverManager
        public void registerNetworkHandoverListener(ICaeNetworkHandoverListener r8) {
        }

        @Override // com.obric.cae.libs.network.ICaeNetworkHandoverManager
        public void unregisterNetworkHandoverListener(ICaeNetworkHandoverListener r8) {
        }
    }

    public static abstract class Stub extends Binder implements ICaeNetworkHandoverManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.network.ICaeNetworkHandoverManager";
        static final int TRANSACTION_registerNetworkHandoverListener = 1;
        static final int TRANSACTION_unregisterNetworkHandoverListener = 2;

        public static class Proxy implements ICaeNetworkHandoverManager {
            public static ICaeNetworkHandoverManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.network.ICaeNetworkHandoverManager
            public void registerNetworkHandoverListener(ICaeNetworkHandoverListener r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(1, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerNetworkHandoverListener(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.network.ICaeNetworkHandoverManager
            public void unregisterNetworkHandoverListener(ICaeNetworkHandoverListener r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                IBinder r12 = r8.asBinder();     // Catch: Throwable -> L16
            L7:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(2, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterNetworkHandoverListener(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeNetworkHandoverManager asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeNetworkHandoverManager) == false) goto L12;
            return (ICaeNetworkHandoverManager) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeNetworkHandoverManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeNetworkHandoverManager r8) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r8 == null) goto L7;
            Proxy.sDefaultImpl = r8;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 != 1) goto L5;
            r10.enforceInterface(DESCRIPTOR);
            registerNetworkHandoverListener(ICaeNetworkHandoverListener.Stub.asInterface(r10.readStrongBinder()));
        L13:
            r11.writeNoException();
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            unregisterNetworkHandoverListener(ICaeNetworkHandoverListener.Stub.asInterface(r10.readStrongBinder()));
            goto L13
        L7:
            if (r8 != 1598968902) goto L9;
            r11.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void registerNetworkHandoverListener(ICaeNetworkHandoverListener r8);

    void unregisterNetworkHandoverListener(ICaeNetworkHandoverListener r8);
}
