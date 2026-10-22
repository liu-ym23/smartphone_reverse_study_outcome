package com.obric.assistant.dora;

import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IDoraBleProtocolService extends IInterface {

    public static abstract class Stub extends Binder implements IDoraBleProtocolService {
        private static final String DESCRIPTOR = "com.obric.assistant.dora.IDoraBleProtocolService";
        static final int TRANSACTION_getScanFilters = 1;
        static final int TRANSACTION_parseScanResult = 2;
        static final int TRANSACTION_startAutoBindFlow = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDoraBleProtocolService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IDoraBleProtocolService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IDoraBleProtocolService) == false) goto L12;
            return (IDoraBleProtocolService) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IDoraBleProtocolService r1) {
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
            if (r5 == 1) goto L27;
            DoraBleDevice r3 = null;
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L22;
            r3 = (ScanResult) ScanResult.CREATOR.createFromParcel(r6);
        L22:
            DoraBleDevice r9 = parseScanResult(r3);
            r7.writeNoException();
            if (r9 == null) goto L25;
            r7.writeInt(1);
            r9.writeToParcel(r7, 1);
        L26:
            return true;
        L25:
            r7.writeInt(0);
            goto L26
        L7:
            if (r5 != 3) goto L9;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L17;
            r3 = (DoraBleDevice) DoraBleDevice.CREATOR.createFromParcel(r6);
        L17:
            startAutoBindFlow(r3);
            r7.writeNoException();
            return true;
        L9:
            if (r5 != 1598968902) goto L11;
            r7.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r5, r6, r7, r8);
        L27:
            r6.enforceInterface(DESCRIPTOR);
            List<ScanFilter> r10 = getScanFilters();
            r7.writeNoException();
            r7.writeTypedList(r10);
            return true;
        }
    }

    List<ScanFilter> getScanFilters() throws RemoteException;

    DoraBleDevice parseScanResult(ScanResult r1) throws RemoteException;

    void startAutoBindFlow(DoraBleDevice r1) throws RemoteException;
}
