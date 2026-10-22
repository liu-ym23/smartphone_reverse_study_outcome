package com.obric.cae.libs.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeBluetoothEventCallback extends IInterface {

    public static class Default implements ICaeBluetoothEventCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetoothEventCallback
        public void onDeviceInfoEventReported(BtDeviceInfoExtEvent r8) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetoothEventCallback
        public void onDeviceInfoFactorsReported(BdimPredictEvent r8) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetoothEventCallback
        public void onEventReported(CaeBluetoothEvent r8) {
        }
    }

    public static abstract class Stub extends Binder implements ICaeBluetoothEventCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.ICaeBluetoothEventCallback";
        static final int TRANSACTION_onDeviceInfoEventReported = 2;
        static final int TRANSACTION_onDeviceInfoFactorsReported = 3;
        static final int TRANSACTION_onEventReported = 1;

        public static class Proxy implements ICaeBluetoothEventCallback {
            public static ICaeBluetoothEventCallback sDefaultImpl;
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetoothEventCallback
            public void onDeviceInfoEventReported(BtDeviceInfoExtEvent r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(2, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onDeviceInfoEventReported(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetoothEventCallback
            public void onDeviceInfoFactorsReported(BdimPredictEvent r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(3, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onDeviceInfoFactorsReported(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetoothEventCallback
            public void onEventReported(CaeBluetoothEvent r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(1, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onEventReported(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L16
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

        public static ICaeBluetoothEventCallback asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeBluetoothEventCallback) == false) goto L12;
            return (ICaeBluetoothEventCallback) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeBluetoothEventCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeBluetoothEventCallback r8) {
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
            CaeBluetoothEvent r13 = null;
            BdimPredictEvent r14 = null;
            BtDeviceInfoExtEvent r15 = null;
            if (r8 != 1) goto L5;
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L27;
            r13 = CaeBluetoothEvent.CREATOR.createFromParcel(r10);
        L27:
            onEventReported(r13);
        L18:
            r11.writeNoException();
            return true;
        L5:
            if (r8 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L23;
            r15 = BtDeviceInfoExtEvent.CREATOR.createFromParcel(r10);
        L23:
            onDeviceInfoEventReported(r15);
            goto L18
        L7:
            if (r8 != 3) goto L9;
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L17;
            r14 = BdimPredictEvent.CREATOR.createFromParcel(r10);
        L17:
            onDeviceInfoFactorsReported(r14);
            goto L18
        L9:
            if (r8 != 1598968902) goto L11;
            r11.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void onDeviceInfoEventReported(BtDeviceInfoExtEvent r8);

    void onDeviceInfoFactorsReported(BdimPredictEvent r8);

    void onEventReported(CaeBluetoothEvent r8);
}
