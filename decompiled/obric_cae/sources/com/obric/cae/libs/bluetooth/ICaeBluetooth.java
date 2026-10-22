package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.AttributionSource;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface ICaeBluetooth extends IInterface {

    public static class Default implements ICaeBluetooth {
        public Default() {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void addDeviceToDatabase(String r8, BluetoothDevice r10) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void addDeviceToStaticExtDatabase(String r8, BluetoothDevice r10) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public BdimPredictEvent getBdimEvent(BluetoothDevice r8) {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public int getProductId(BluetoothDevice r8) {
            return 0;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void registerEventCallback(ICaeBluetoothEventCallback r8) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void removeDeviceFromDatabase(String r8, BluetoothDevice r10) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void removeDeviceFromStaticExtDatabase(String r8, BluetoothDevice r10) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void requestLeConnectionPriority(int r8, AttributionSource r10) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setAac3mPacketEnabled(boolean r8) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setBqrEventState(int r8) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setHARStatusChanged(int r8) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setLocationState(String r8) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setModelPredictType(BluetoothDevice r8, String r10) {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void unregisterEventCallback(ICaeBluetoothEventCallback r8) {
        }
    }

    public static abstract class Stub extends Binder implements ICaeBluetooth {
        private static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.ICaeBluetooth";
        static final int TRANSACTION_addDeviceToDatabase = 3;
        static final int TRANSACTION_addDeviceToStaticExtDatabase = 6;
        static final int TRANSACTION_getBdimEvent = 10;
        static final int TRANSACTION_getProductId = 8;
        static final int TRANSACTION_registerEventCallback = 1;
        static final int TRANSACTION_removeDeviceFromDatabase = 4;
        static final int TRANSACTION_removeDeviceFromStaticExtDatabase = 7;
        static final int TRANSACTION_requestLeConnectionPriority = 5;
        static final int TRANSACTION_setAac3mPacketEnabled = 14;
        static final int TRANSACTION_setBqrEventState = 13;
        static final int TRANSACTION_setHARStatusChanged = 11;
        static final int TRANSACTION_setLocationState = 12;
        static final int TRANSACTION_setModelPredictType = 9;
        static final int TRANSACTION_unregisterEventCallback = 2;

        public static class Proxy implements ICaeBluetooth {
            public static ICaeBluetooth sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r8) {
                this.mRemote = r8;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void addDeviceToDatabase(String r8, BluetoothDevice r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r11.writeString(r8);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L16
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(3, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L16
            L12:
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addDeviceToDatabase(r8, r10);     // Catch: Throwable -> L16
                goto L12
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void addDeviceToStaticExtDatabase(String r8, BluetoothDevice r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r11.writeString(r8);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L16
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(6, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L16
            L12:
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addDeviceToStaticExtDatabase(r8, r10);     // Catch: Throwable -> L16
                goto L12
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public BdimPredictEvent getBdimEvent(BluetoothDevice r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L19
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L19
            L8:
                if (this.mRemote.transact(10, r10, r11, 0) == false) goto L10;
            L14:
                r11.readException();     // Catch: Throwable -> L19
                if (r11.readInt() == 0) goto L18;
                BdimPredictEvent r12 = BdimPredictEvent.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L19
            L12:
                r11.recycle();
                r10.recycle();
                return r12;
            L18:
                r12 = null;
                goto L12
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r12 = Stub.getDefaultImpl().getBdimEvent(r8);     // Catch: Throwable -> L19
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public int getProductId(BluetoothDevice r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r10, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(8, r10, r11, 0) == false) goto L10;
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void registerEventCallback(ICaeBluetoothEventCallback r8) {
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void removeDeviceFromDatabase(String r8, BluetoothDevice r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r11.writeString(r8);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L16
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(4, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L16
            L12:
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeDeviceFromDatabase(r8, r10);     // Catch: Throwable -> L16
                goto L12
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void removeDeviceFromStaticExtDatabase(String r8, BluetoothDevice r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r11.writeString(r8);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L16
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(7, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L16
            L12:
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeDeviceFromStaticExtDatabase(r8, r10);     // Catch: Throwable -> L16
                goto L12
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void requestLeConnectionPriority(int r8, AttributionSource r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r11.writeInt(r8);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L16
                r10.writeToParcel(r11, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(5, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L16
            L12:
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().requestLeConnectionPriority(r8, r10);     // Catch: Throwable -> L16
                goto L12
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setAac3mPacketEnabled(boolean r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8 ? 1 : 0);     // Catch: Throwable -> L12
                if (this.mRemote.transact(14, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setAac3mPacketEnabled(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setBqrEventState(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(13, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setBqrEventState(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setHARStatusChanged(int r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeInt(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(11, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setHARStatusChanged(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setLocationState(String r8) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r10.writeString(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(12, r10, r11, 0) == false) goto L6;
            L10:
                r11.readException();     // Catch: Throwable -> L12
            L8:
                r11.recycle();
                r10.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setLocationState(r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setModelPredictType(BluetoothDevice r8, String r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r8 == null) goto L6;
                r11.writeInt(1);     // Catch: Throwable -> L16
                r8.writeToParcel(r11, 0);     // Catch: Throwable -> L16
            L7:
                r11.writeString(r10);     // Catch: Throwable -> L16
                if (this.mRemote.transact(9, r11, r12, 0) == false) goto L10;
            L14:
                r12.readException();     // Catch: Throwable -> L16
            L12:
                r12.recycle();
                r11.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setModelPredictType(r8, r10);     // Catch: Throwable -> L16
                goto L12
            L6:
                r11.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void unregisterEventCallback(ICaeBluetoothEventCallback r8) {
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

        public static ICaeBluetooth asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface(DESCRIPTOR);
            if (r10 == null) goto L12;
            if ((r10 instanceof ICaeBluetooth) == false) goto L12;
            return (ICaeBluetooth) r10;
        L12:
            return new Proxy(r8);
        }

        public static ICaeBluetooth getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICaeBluetooth r8) {
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
            if (r8 == 1598968902) goto L66;
            boolean r13 = false;
            BluetoothDevice r14 = null;
            BluetoothDevice r15 = null;
            BluetoothDevice r16 = null;
            BluetoothDevice r17 = null;
            BluetoothDevice r18 = null;
            BluetoothDevice r19 = null;
            AttributionSource r20 = null;
            BluetoothDevice r21 = null;
            switch(r8) {
                case 1: goto L64;
                case 2: goto L62;
                case 3: goto L57;
                case 4: goto L52;
                case 5: goto L47;
                case 6: goto L42;
                case 7: goto L37;
                case 8: goto L32;
                case 9: goto L27;
                case 10: goto L19;
                case 11: goto L17;
                case 12: goto L15;
                case 13: goto L13;
                case 14: goto L8;
                default: goto L7;
            };
        L8:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L11;
            r13 = true;
        L11:
            setAac3mPacketEnabled(r13);
            r11.writeNoException();
            return true;
        L13:
            r10.enforceInterface(DESCRIPTOR);
            setBqrEventState(r10.readInt());
            r11.writeNoException();
            return true;
        L15:
            r10.enforceInterface(DESCRIPTOR);
            setLocationState(r10.readString());
            r11.writeNoException();
            return true;
        L17:
            r10.enforceInterface(DESCRIPTOR);
            setHARStatusChanged(r10.readInt());
            r11.writeNoException();
            return true;
        L19:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L22;
            r15 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r10);
        L22:
            BdimPredictEvent r22 = getBdimEvent(r15);
            r11.writeNoException();
            if (r22 == null) goto L25;
            r11.writeInt(1);
            r22.writeToParcel(r11, 1);
        L26:
            return true;
        L25:
            r11.writeInt(0);
            goto L26
        L27:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L30;
            r16 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r10);
        L30:
            setModelPredictType(r16, r10.readString());
            r11.writeNoException();
            return true;
        L32:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L35;
            r17 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r10);
        L35:
            int r23 = getProductId(r17);
            r11.writeNoException();
            r11.writeInt(r23);
            return true;
        L37:
            r10.enforceInterface(DESCRIPTOR);
            String r24 = r10.readString();
            if (r10.readInt() == 0) goto L40;
            r18 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r10);
        L40:
            removeDeviceFromStaticExtDatabase(r24, r18);
            r11.writeNoException();
            return true;
        L42:
            r10.enforceInterface(DESCRIPTOR);
            String r25 = r10.readString();
            if (r10.readInt() == 0) goto L45;
            r19 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r10);
        L45:
            addDeviceToStaticExtDatabase(r25, r19);
            r11.writeNoException();
            return true;
        L47:
            r10.enforceInterface(DESCRIPTOR);
            int r26 = r10.readInt();
            if (r10.readInt() == 0) goto L50;
            r20 = (AttributionSource) AttributionSource.CREATOR.createFromParcel(r10);
        L50:
            requestLeConnectionPriority(r26, r20);
            r11.writeNoException();
            return true;
        L52:
            r10.enforceInterface(DESCRIPTOR);
            String r27 = r10.readString();
            if (r10.readInt() == 0) goto L55;
            r21 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r10);
        L55:
            removeDeviceFromDatabase(r27, r21);
            r11.writeNoException();
            return true;
        L57:
            r10.enforceInterface(DESCRIPTOR);
            String r28 = r10.readString();
            if (r10.readInt() == 0) goto L60;
            r14 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r10);
        L60:
            addDeviceToDatabase(r28, r14);
            r11.writeNoException();
            return true;
        L62:
            r10.enforceInterface(DESCRIPTOR);
            unregisterEventCallback(ICaeBluetoothEventCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L64:
            r10.enforceInterface(DESCRIPTOR);
            registerEventCallback(ICaeBluetoothEventCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L7:
            return super.onTransact(r8, r10, r11, r12);
        L66:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addDeviceToDatabase(String r8, BluetoothDevice r10);

    void addDeviceToStaticExtDatabase(String r8, BluetoothDevice r10);

    BdimPredictEvent getBdimEvent(BluetoothDevice r8);

    int getProductId(BluetoothDevice r8);

    void registerEventCallback(ICaeBluetoothEventCallback r8);

    void removeDeviceFromDatabase(String r8, BluetoothDevice r10);

    void removeDeviceFromStaticExtDatabase(String r8, BluetoothDevice r10);

    void requestLeConnectionPriority(int r8, AttributionSource r10);

    void setAac3mPacketEnabled(boolean r8);

    void setBqrEventState(int r8);

    void setHARStatusChanged(int r8);

    void setLocationState(String r8);

    void setModelPredictType(BluetoothDevice r8, String r10);

    void unregisterEventCallback(ICaeBluetoothEventCallback r8);
}
