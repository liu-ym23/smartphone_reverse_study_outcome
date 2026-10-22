package com.obric.cae.libs.bluetooth.exporter;

import android.bluetooth.BluetoothDevice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.cae.libs.bluetooth.BtDeviceInfoExtEvent;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface ICaeBluetoothExporter extends IInterface {

    public static class Default implements ICaeBluetoothExporter {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r1) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public int getProductId(BluetoothDevice r1) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public void registerEventCallback(ICaeBluetoothCallbackExporter r1) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public void unregisterEventCallback(ICaeBluetoothCallbackExporter r1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeBluetoothExporter {
        private static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter";
        static final int TRANSACTION_getDeviceType = 4;
        static final int TRANSACTION_getProductId = 3;
        static final int TRANSACTION_registerEventCallback = 1;
        static final int TRANSACTION_unregisterEventCallback = 2;

        public static class Proxy implements ICaeBluetoothExporter {
            public static ICaeBluetoothExporter sDefaultImpl;
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

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_exporter_ICaeBluetoothExporter$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                BtDeviceInfoExtEvent r7 = BtDeviceInfoExtEvent.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r7;
            L18:
                r7 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                BtDeviceInfoExtEvent r8 = Stub.getDefaultImpl().getDeviceType(r6);     // Catch: Throwable -> L21
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

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public int getProductId(BluetoothDevice r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_exporter_ICaeBluetoothExporter$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L10;
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

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public void registerEventCallback(ICaeBluetoothCallbackExporter r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_exporter_ICaeBluetoothExporter$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
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

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public void unregisterEventCallback(ICaeBluetoothCallbackExporter r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_exporter_ICaeBluetoothExporter$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
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

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_bluetooth_exporter_ICaeBluetoothExporter$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static ICaeBluetoothExporter getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeBluetoothExporter asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof ICaeBluetoothExporter) == false) goto L12;
            return (ICaeBluetoothExporter) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(ICaeBluetoothExporter r1) {
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
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            if (r5 == 1598968902) goto L30;
            if (r5 != 1) goto L6;
            r6.enforceInterface(DESCRIPTOR);
            registerEventCallback(ICaeBluetoothCallbackExporter.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L6:
            if (r5 == 2) goto L26;
            BluetoothDevice r3 = null;
            if (r5 != 3) goto L10;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L24;
            r3 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r6);
        L24:
            int r9 = getProductId(r3);
            r7.writeNoException();
            r7.writeInt(r9);
            return true;
        L10:
            if (r5 != 4) goto L12;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L16;
            r3 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r6);
        L16:
            BtDeviceInfoExtEvent r10 = getDeviceType(r3);
            r7.writeNoException();
            if (r10 == null) goto L19;
            r7.writeInt(1);
            r10.writeToParcel(r7, 1);
        L20:
            return true;
        L19:
            r7.writeInt(0);
            goto L20
        L12:
            return super.onTransact(r5, r6, r7, r8);
        L26:
            r6.enforceInterface(DESCRIPTOR);
            unregisterEventCallback(ICaeBluetoothCallbackExporter.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L30:
            r7.writeString(DESCRIPTOR);
            return true;
        }
    }

    BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r1) throws RemoteException;

    int getProductId(BluetoothDevice r1) throws RemoteException;

    void registerEventCallback(ICaeBluetoothCallbackExporter r1) throws RemoteException;

    void unregisterEventCallback(ICaeBluetoothCallbackExporter r1) throws RemoteException;
}
