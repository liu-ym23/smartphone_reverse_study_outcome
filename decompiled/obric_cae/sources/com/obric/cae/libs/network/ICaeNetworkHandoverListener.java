package com.obric.cae.libs.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeNetworkHandoverListener extends IInterface {

    public static class Default implements ICaeNetworkHandoverListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.network.ICaeNetworkHandoverListener
        public void notifyNetworkExitingPolicyUpdate(int r8, boolean r10) {
        }

        @Override // com.obric.cae.libs.network.ICaeNetworkHandoverListener
        public void notifyNetworkTestedResult(int r8, int r10, String r11) {
        }
    }

    public static abstract class Stub extends Binder implements ICaeNetworkHandoverListener {
        private static final String DESCRIPTOR = "com.obric.cae.libs.network.ICaeNetworkHandoverListener";
        static final int TRANSACTION_notifyNetworkExitingPolicyUpdate = 2;
        static final int TRANSACTION_notifyNetworkTestedResult = 1;

        public static class Proxy implements ICaeNetworkHandoverListener {
            public static ICaeNetworkHandoverListener sDefaultImpl;
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

            @Override // com.obric.cae.libs.network.ICaeNetworkHandoverListener
            public void notifyNetworkExitingPolicyUpdate(int r8, boolean r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r11.writeInt(r8);     // Catch: Throwable -> L12
                r11.writeInt(r10 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L12
            L8:
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyNetworkExitingPolicyUpdate(r8, r10);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.network.ICaeNetworkHandoverListener
            public void notifyNetworkTestedResult(int r8, int r10, String r11) {
                Parcel r12 = Parcel.obtain();
                Parcel r13 = Parcel.obtain();
                r12.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r12.writeInt(r8);     // Catch: Throwable -> L12
                r12.writeInt(r10);     // Catch: Throwable -> L12
                r12.writeString(r11);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r12, r13, 0) == false) goto L6;
            L10:
                r13.readException();     // Catch: Throwable -> L12
            L8:
                r13.recycle();
                r12.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyNetworkTestedResult(r8, r10, r11);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r13.recycle();
                r12.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeNetworkHandoverListener asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeNetworkHandoverListener) == false) goto L12;
            return (ICaeNetworkHandoverListener) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeNetworkHandoverListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeNetworkHandoverListener r8) {
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
            notifyNetworkTestedResult(r10.readInt(), r10.readInt(), r10.readString());
        L17:
            r11.writeNoException();
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            int r13 = r10.readInt();
            if (r10.readInt() == 0) goto L15;
            boolean r14 = true;
        L16:
            notifyNetworkExitingPolicyUpdate(r13, r14);
            goto L17
        L15:
            r14 = false;
            goto L16
        L7:
            if (r8 != 1598968902) goto L9;
            r11.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void notifyNetworkExitingPolicyUpdate(int r8, boolean r10);

    void notifyNetworkTestedResult(int r8, int r10, String r11);
}
