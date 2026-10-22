package com.obric.assistant.dora;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class IDoraMainProcessBridgeService$Stub extends Binder implements IDoraMainProcessBridgeService {
    private static final String DESCRIPTOR = "com.obric.assistant.dora.IDoraMainProcessBridgeService";
    static final int TRANSACTION_checkBindAndConnectIfNecessaryAsync = 2;
    static final int TRANSACTION_getStateSnapshot = 1;

    public IBinder asBinder() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IDoraMainProcessBridgeService$Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static IDoraMainProcessBridgeService getDefaultImpl() {
        return Proxy.sDefaultImpl;
    }

    public static IDoraMainProcessBridgeService asInterface(IBinder r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        IDoraMainProcessBridgeService r0 = r2.queryLocalInterface(DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof IDoraMainProcessBridgeService) == false) goto L12;
        return r0;
    L12:
        return new Proxy(r2);
    }

    public static boolean setDefaultImpl(IDoraMainProcessBridgeService r1) {
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
        if (r4 != 1) goto L5;
        r5.enforceInterface(DESCRIPTOR);
        DoraMainProcessStateSnapshot r8 = getStateSnapshot();
        r6.writeNoException();
        if (r8 == null) goto L21;
        r6.writeInt(1);
        r8.writeToParcel(r6, 1);
    L22:
        return true;
    L21:
        r6.writeInt(0);
        goto L22
    L5:
        if (r4 != 2) goto L7;
        r5.enforceInterface(DESCRIPTOR);
        if (r5.readInt() == 0) goto L15;
        DoraDeviceInfo r9 = (DoraDeviceInfo) DoraDeviceInfo.CREATOR.createFromParcel(r5);
    L16:
        checkBindAndConnectIfNecessaryAsync(r9, r5.readString(), IDoraMainProcessConnectCallback.Stub.asInterface(r5.readStrongBinder()));
        r6.writeNoException();
        return true;
    L15:
        r9 = null;
        goto L16
    L7:
        if (r4 != 1598968902) goto L9;
        r6.writeString(DESCRIPTOR);
        return true;
    L9:
        return super.onTransact(r4, r5, r6, r7);
    }
}
