package com.larksuite.component.blockit.sub_process;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class IP0SubProcessStub extends Binder implements IInterface, IP0SubProcess {
    public final P0SubProcessImpl base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IP0SubProcessStub(Context r2) {
        this.base = new P0SubProcessImpl(r2);
        attachInterface(this, IP0SubProcessProxy.DESCRIPTOR);
    }

    @Override // com.larksuite.component.blockit.sub_process.IP0SubProcess
    public void triggerRefresh(String r2) {
        this.base.triggerRefresh(r2);
    }

    public static IP0SubProcessProxy asInterface(Context r2, IBinder r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        IInterface r0 = r3.queryLocalInterface(IP0SubProcessProxy.DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof IP0SubProcessProxy) == false) goto L12;
        return (IP0SubProcessProxy) r0;
    L12:
        return new IP0SubProcessProxy(r2, r3);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
        if (r4 != 1) goto L5;
        r5.enforceInterface(IP0SubProcessProxy.DESCRIPTOR);
        triggerRefresh(r5.readString());
        r6.writeNoException();
        return true;
    L5:
        if (r4 != 1598968902) goto L7;
        r6.writeString(IP0SubProcessProxy.DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r4, r5, r6, r7);
    }
}
