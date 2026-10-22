package com.obric.cae.libs.bluetooth.exporter;

import android.bluetooth.BluetoothDevice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.obric.cae.libs.bluetooth.BtDeviceInfoExtEvent;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeBluetoothExporter extends IInterface {

    public static class Default implements ICaeBluetoothExporter {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public boolean disableBle() {
            return false;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public boolean enableBle() {
            return false;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r8) {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public int getProductId(BluetoothDevice r8) {
            return 0;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public boolean isAbsoluteVolumeSupported(BluetoothDevice r8) {
            return false;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public void registerEventCallback(ICaeBluetoothCallbackExporter r8) {
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public void unregisterEventCallback(ICaeBluetoothCallbackExporter r8) {
        }
    }

    public static abstract class Stub extends Binder implements ICaeBluetoothExporter {
        private static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter";
        static final int TRANSACTION_disableBle = 7;
        static final int TRANSACTION_enableBle = 6;
        static final int TRANSACTION_getDeviceType = 4;
        static final int TRANSACTION_getProductId = 3;
        static final int TRANSACTION_isAbsoluteVolumeSupported = 5;
        static final int TRANSACTION_registerEventCallback = 1;
        static final int TRANSACTION_unregisterEventCallback = 2;

        public static class Proxy implements ICaeBluetoothExporter {
            public static ICaeBluetoothExporter sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public boolean disableBle() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r11 = false;
                if (this.mRemote.transact(7, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L15
                if (r10.readInt() == 0) goto L13;
                r11 = true;
            L13:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r12 = Stub.getDefaultImpl().disableBle();     // Catch: Throwable -> L15
                r10.recycle();
                r8.recycle();
                return r12;
            L15:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public boolean enableBle() {
                Parcel r8 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r11 = false;
                if (this.mRemote.transact(6, r8, r10, 0) == false) goto L6;
            L10:
                r10.readException();     // Catch: Throwable -> L15
                if (r10.readInt() == 0) goto L13;
                r11 = true;
            L13:
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r12 = Stub.getDefaultImpl().enableBle();     // Catch: Throwable -> L15
                r10.recycle();
                r8.recycle();
                return r12;
            L15:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L19
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L19
            L8:
                if (this.mRemote.transact(4, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L19
                if (r11.readInt() == 0) goto L18;
                BtDeviceInfoExtEvent r12 = BtDeviceInfoExtEvent.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L19
            L12:
                r11.recycle();
                r10.recycle();
                return r12;
            L18:
                r12 = null;
                goto L12
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r12 = Stub.getDefaultImpl().getDeviceType(r8);     // Catch: Throwable -> L19
                goto L12
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public int getProductId(BluetoothDevice r8) {
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
                int r12 = r11.readInt();     // Catch: Throwable -> L16
            L12:
                r11.recycle();
                r10.recycle();
                return r12;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r12 = Stub.getDefaultImpl().getProductId(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public boolean isAbsoluteVolumeSupported(BluetoothDevice r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r12 = true;
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L20
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L20
            L8:
                if (this.mRemote.transact(5, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L20
                if (r11.readInt() != 0) goto L18;
                r12 = false;
            L18:
                r11.recycle();
                r10.recycle();
                return r12;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r13 = Stub.getDefaultImpl().isAbsoluteVolumeSupported(r8);     // Catch: Throwable -> L20
                r11.recycle();
                r10.recycle();
                return r13;
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public void registerEventCallback(ICaeBluetoothCallbackExporter r8) {
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
                Stub.getDefaultImpl().registerEventCallback(r8);     // Catch: Throwable -> L16
                goto L12
            L6:
                r12 = null;
            L16:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public void unregisterEventCallback(ICaeBluetoothCallbackExporter r8) {
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
                Stub.getDefaultImpl().unregisterEventCallback(r8);     // Catch: Throwable -> L16
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

        public static ICaeBluetoothExporter asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeBluetoothExporter) == false) goto L12;
            return (ICaeBluetoothExporter) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeBluetoothExporter getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeBluetoothExporter r8) {
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
            if (r8 == 1598968902) goto L34;
            BluetoothDevice r13 = null;
            switch(r8) {
                case 1: goto L32;
                case 2: goto L30;
                case 3: goto L25;
                case 4: goto L17;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                default: goto L7;
            };
        L8:
            r10.enforceInterface(DESCRIPTOR);
            boolean r14 = disableBle();
            r11.writeNoException();
            r11.writeInt(r14 ? 1 : 0);
            return true;
        L10:
            r10.enforceInterface(DESCRIPTOR);
            boolean r15 = enableBle();
            r11.writeNoException();
            r11.writeInt(r15 ? 1 : 0);
            return true;
        L12:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L15;
            r13 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r10);
        L15:
            boolean r16 = isAbsoluteVolumeSupported(r13);
            r11.writeNoException();
            r11.writeInt(r16 ? 1 : 0);
            return true;
        L17:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L20;
            r13 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r10);
        L20:
            BtDeviceInfoExtEvent r17 = getDeviceType(r13);
            r11.writeNoException();
            if (r17 == null) goto L23;
            r11.writeInt(1);
            r17.writeToParcel(r11, 1);
        L24:
            return true;
        L23:
            r11.writeInt(0);
            goto L24
        L25:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L28;
            r13 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r10);
        L28:
            int r18 = getProductId(r13);
            r11.writeNoException();
            r11.writeInt(r18);
            return true;
        L30:
            r10.enforceInterface(DESCRIPTOR);
            unregisterEventCallback(ICaeBluetoothCallbackExporter.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L32:
            r10.enforceInterface(DESCRIPTOR);
            registerEventCallback(ICaeBluetoothCallbackExporter.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        L34:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    boolean disableBle();

    boolean enableBle();

    BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r8);

    int getProductId(BluetoothDevice r8);

    boolean isAbsoluteVolumeSupported(BluetoothDevice r8);

    void registerEventCallback(ICaeBluetoothCallbackExporter r8);

    void unregisterEventCallback(ICaeBluetoothCallbackExporter r8);
}
