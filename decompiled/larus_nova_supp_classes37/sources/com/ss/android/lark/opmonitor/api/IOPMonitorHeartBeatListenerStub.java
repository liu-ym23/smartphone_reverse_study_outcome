package com.ss.android.lark.opmonitor.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import byb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IOPMonitorHeartBeatListenerStub extends Binder implements IInterface, a {
    public final a base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IOPMonitorHeartBeatListenerStub(a r1) {
        this.base = r1;
        attachInterface(this, IOPMonitorHeartBeatListenerProxy.DESCRIPTOR);
    }

    public static IOPMonitorHeartBeatListenerProxy asInterface(IBinder r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        IInterface r0 = r2.queryLocalInterface(IOPMonitorHeartBeatListenerProxy.DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof IOPMonitorHeartBeatListenerProxy) == false) goto L12;
        return (IOPMonitorHeartBeatListenerProxy) r0;
    L12:
        return new IOPMonitorHeartBeatListenerProxy(r2);
    }

    @Override // byb.a
    public int getCurrentHeartBeatStatus(String r2) {
        return this.base.getCurrentHeartBeatStatus(r2);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
        if (r4 != 1) goto L5;
        r5.enforceInterface(IOPMonitorHeartBeatListenerProxy.DESCRIPTOR);
        int r8 = getCurrentHeartBeatStatus(r5.readString());
        r6.writeNoException();
        r6.writeInt(r8);
        return true;
    L5:
        if (r4 != 1598968902) goto L7;
        r6.writeString(IOPMonitorHeartBeatListenerProxy.DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r4, r5, r6, r7);
    }
}
