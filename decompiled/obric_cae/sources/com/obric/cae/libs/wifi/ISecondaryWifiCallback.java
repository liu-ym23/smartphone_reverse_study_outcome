package com.obric.cae.libs.wifi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ISecondaryWifiCallback extends IInterface {

    public static class Default implements ISecondaryWifiCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
        public void onAvailable(String r8, int r10) {
        }

        @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
        public void onLost() {
        }

        @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
        public void onSignalStrength(int r8) {
        }

        @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
        public void onUnavailable() {
        }
    }

    public static abstract class Stub extends Binder implements ISecondaryWifiCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.wifi.ISecondaryWifiCallback";
        static final int TRANSACTION_onAvailable = 1;
        static final int TRANSACTION_onLost = 2;
        static final int TRANSACTION_onSignalStrength = 4;
        static final int TRANSACTION_onUnavailable = 3;

        public static class Proxy implements ISecondaryWifiCallback {
            public static ISecondaryWifiCallback sDefaultImpl;
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

            @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
            public void onAvailable(String r8, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r11.writeString(r8);     // Catch: Throwable -> L12
                r11.writeInt(r10);     // Catch: Throwable -> L12
                if (this.mRemote.transact(1, r11, r12, 0) == false) goto L6;
            L10:
                r12.readException();     // Catch: Throwable -> L12
            L8:
                r12.recycle();
                r11.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAvailable(r8, r10);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
            public void onLost() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onLost();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
            public void onSignalStrength(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSignalStrength(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ISecondaryWifiCallback
            public void onUnavailable() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L12
            L8:
                r10.recycle();
                r8.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onUnavailable();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISecondaryWifiCallback asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ISecondaryWifiCallback) == false) goto L12;
            return (ISecondaryWifiCallback) r10;
        L12:
            return new Proxy(r8);
        }

        public static ISecondaryWifiCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ISecondaryWifiCallback r8) {
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
            if (r8 == 1598968902) goto L19;
            if (r8 != 1) goto L6;
            r10.enforceInterface(DESCRIPTOR);
            onAvailable(r10.readString(), r10.readInt());
        L14:
            r11.writeNoException();
            return true;
        L6:
            if (r8 != 2) goto L8;
            r10.enforceInterface(DESCRIPTOR);
            onLost();
            goto L14
        L8:
            if (r8 != 3) goto L10;
            r10.enforceInterface(DESCRIPTOR);
            onUnavailable();
            goto L14
        L10:
            if (r8 != 4) goto L12;
            r10.enforceInterface(DESCRIPTOR);
            onSignalStrength(r10.readInt());
            goto L14
        L12:
            return super.onTransact(r8, r10, r11, r12);
        L19:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onAvailable(String r8, int r10);

    void onLost();

    void onSignalStrength(int r8);

    void onUnavailable();
}
