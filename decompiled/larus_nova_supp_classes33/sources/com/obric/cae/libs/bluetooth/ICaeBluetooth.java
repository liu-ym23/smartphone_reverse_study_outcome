package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.AttributionSource;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface ICaeBluetooth extends IInterface {

    public static class Default implements ICaeBluetooth {
        public Default() {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void addDeviceToDatabase(String r1, BluetoothDevice r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void addDeviceToStaticExtDatabase(String r1, BluetoothDevice r2) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public BdimPredictEvent getBdimEvent(BluetoothDevice r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public int getProductId(BluetoothDevice r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void registerEventCallback(ICaeBluetoothEventCallback r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void removeDeviceFromDatabase(String r1, BluetoothDevice r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void removeDeviceFromStaticExtDatabase(String r1, BluetoothDevice r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void requestLeConnectionPriority(int r1, AttributionSource r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setHARStatusChanged(int r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setLocationState(String r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setModelPredictType(BluetoothDevice r1, String r2) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void unregisterEventCallback(ICaeBluetoothEventCallback r1) throws RemoteException {
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
        static final int TRANSACTION_setHARStatusChanged = 11;
        static final int TRANSACTION_setLocationState = 12;
        static final int TRANSACTION_setModelPredictType = 9;
        static final int TRANSACTION_unregisterEventCallback = 2;

        public static class Proxy implements ICaeBluetooth {
            public static ICaeBluetooth sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public BdimPredictEvent getBdimEvent(BluetoothDevice r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                BdimPredictEvent r7 = BdimPredictEvent.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r7;
            L18:
                r7 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                BdimPredictEvent r8 = Stub.getDefaultImpl().getBdimEvent(r6);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public int getProductId(BluetoothDevice r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                int r7 = r1.readInt();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r7;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                int r8 = Stub.getDefaultImpl().getProductId(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void registerEventCallback(ICaeBluetoothEventCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerEventCallback(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setHARStatusChanged(int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeInt(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setHARStatusChanged(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setLocationState(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setLocationState(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void unregisterEventCallback(ICaeBluetoothEventCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterEventCallback(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void addDeviceToDatabase(String r6, BluetoothDevice r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addDeviceToDatabase(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void addDeviceToStaticExtDatabase(String r6, BluetoothDevice r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addDeviceToStaticExtDatabase(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void removeDeviceFromDatabase(String r6, BluetoothDevice r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeDeviceFromDatabase(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void removeDeviceFromStaticExtDatabase(String r6, BluetoothDevice r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeDeviceFromStaticExtDatabase(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void requestLeConnectionPriority(int r6, AttributionSource r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeInt(r6);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().requestLeConnectionPriority(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setModelPredictType(BluetoothDevice r6, String r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L7:
                r0.writeString(r7);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setModelPredictType(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r2 = SystemClock.uptimeMillis();
                boolean r0 = r15.transact(r16, r17, r18, r19);     // Catch: Throwable -> L12
                long r8 = SystemClock.uptimeMillis() - r2;
                if (r8 < 100) goto L11;
                BinderPerformanceReporter.report(r8, r15.getClass().getName(), r16, r19, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r0;
            L12:
                th = move-exception;
                long r9 = SystemClock.uptimeMillis() - r2;
                if (r9 < 100) goto L22;
                if (r15 != null) goto L17;
                String r1 = "";
            L18:
                BinderPerformanceReporter.report(r9, r1, r16, r19, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r1 = r15.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r15.transact(r16, r17, r18, r19);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeBluetooth getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeBluetooth asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeBluetooth) == false) goto L12;
            return (ICaeBluetooth) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(ICaeBluetooth r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 == 1598968902) goto L59;
            BluetoothDevice r0 = null;
            BluetoothDevice r1 = null;
            BluetoothDevice r2 = null;
            BluetoothDevice r3 = null;
            BluetoothDevice r8 = null;
            BluetoothDevice r9 = null;
            AttributionSource r10 = null;
            BluetoothDevice r11 = null;
            switch(r4) {
                case 1: goto L57;
                case 2: goto L55;
                case 3: goto L50;
                case 4: goto L45;
                case 5: goto L40;
                case 6: goto L35;
                case 7: goto L30;
                case 8: goto L25;
                case 9: goto L20;
                case 10: goto L12;
                case 11: goto L10;
                case 12: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            setLocationState(r5.readString());
            r6.writeNoException();
            return true;
        L10:
            r5.enforceInterface(DESCRIPTOR);
            setHARStatusChanged(r5.readInt());
            r6.writeNoException();
            return true;
        L12:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L15;
            r1 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r5);
        L15:
            BdimPredictEvent r12 = getBdimEvent(r1);
            r6.writeNoException();
            if (r12 == null) goto L18;
            r6.writeInt(1);
            r12.writeToParcel(r6, 1);
        L19:
            return true;
        L18:
            r6.writeInt(0);
            goto L19
        L20:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L23;
            r2 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r5);
        L23:
            setModelPredictType(r2, r5.readString());
            r6.writeNoException();
            return true;
        L25:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L28;
            r3 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r5);
        L28:
            int r13 = getProductId(r3);
            r6.writeNoException();
            r6.writeInt(r13);
            return true;
        L30:
            r5.enforceInterface(DESCRIPTOR);
            String r14 = r5.readString();
            if (r5.readInt() == 0) goto L33;
            r8 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r5);
        L33:
            removeDeviceFromStaticExtDatabase(r14, r8);
            r6.writeNoException();
            return true;
        L35:
            r5.enforceInterface(DESCRIPTOR);
            String r15 = r5.readString();
            if (r5.readInt() == 0) goto L38;
            r9 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r5);
        L38:
            addDeviceToStaticExtDatabase(r15, r9);
            r6.writeNoException();
            return true;
        L40:
            r5.enforceInterface(DESCRIPTOR);
            int r16 = r5.readInt();
            if (r5.readInt() == 0) goto L43;
            r10 = (AttributionSource) AttributionSource.CREATOR.createFromParcel(r5);
        L43:
            requestLeConnectionPriority(r16, r10);
            r6.writeNoException();
            return true;
        L45:
            r5.enforceInterface(DESCRIPTOR);
            String r17 = r5.readString();
            if (r5.readInt() == 0) goto L48;
            r11 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r5);
        L48:
            removeDeviceFromDatabase(r17, r11);
            r6.writeNoException();
            return true;
        L50:
            r5.enforceInterface(DESCRIPTOR);
            String r18 = r5.readString();
            if (r5.readInt() == 0) goto L53;
            r0 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r5);
        L53:
            addDeviceToDatabase(r18, r0);
            r6.writeNoException();
            return true;
        L55:
            r5.enforceInterface(DESCRIPTOR);
            unregisterEventCallback(ICaeBluetoothEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L57:
            r5.enforceInterface(DESCRIPTOR);
            registerEventCallback(ICaeBluetoothEventCallback.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L59:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addDeviceToDatabase(String r1, BluetoothDevice r2) throws RemoteException;

    void addDeviceToStaticExtDatabase(String r1, BluetoothDevice r2) throws RemoteException;

    BdimPredictEvent getBdimEvent(BluetoothDevice r1) throws RemoteException;

    int getProductId(BluetoothDevice r1) throws RemoteException;

    void registerEventCallback(ICaeBluetoothEventCallback r1) throws RemoteException;

    void removeDeviceFromDatabase(String r1, BluetoothDevice r2) throws RemoteException;

    void removeDeviceFromStaticExtDatabase(String r1, BluetoothDevice r2) throws RemoteException;

    void requestLeConnectionPriority(int r1, AttributionSource r2) throws RemoteException;

    void setHARStatusChanged(int r1) throws RemoteException;

    void setLocationState(String r1) throws RemoteException;

    void setModelPredictType(BluetoothDevice r1, String r2) throws RemoteException;

    void unregisterEventCallback(ICaeBluetoothEventCallback r1) throws RemoteException;
}
