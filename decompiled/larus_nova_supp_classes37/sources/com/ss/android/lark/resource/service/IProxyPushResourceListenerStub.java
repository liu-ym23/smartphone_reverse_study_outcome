package com.ss.android.lark.resource.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IProxyPushResourceListenerStub extends Binder implements IInterface, b {
    public final b base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IProxyPushResourceListenerStub(b r1) {
        this.base = r1;
        attachInterface(this, IProxyPushResourceListenerProxy.DESCRIPTOR);
    }

    public static IProxyPushResourceListenerProxy asInterface(IBinder r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        IInterface r0 = r2.queryLocalInterface(IProxyPushResourceListenerProxy.DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof IProxyPushResourceListenerProxy) == false) goto L12;
        return (IProxyPushResourceListenerProxy) r0;
    L12:
        return new IProxyPushResourceListenerProxy(r2);
    }

    public void onPushDownloadStatus(String r2, boolean r3) {
        this.base.onPushDownloadStatus(r2, r3);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
        if (r4 != 1) goto L5;
        r5.enforceInterface(IProxyPushResourceListenerProxy.DESCRIPTOR);
        String r8 = r5.readString();
        if (r5.readInt() != 0) goto L13;
        boolean r9 = false;
    L14:
        onPushDownloadStatus(r8, r9);
        r6.writeNoException();
        return true;
    L13:
        r9 = true;
        goto L14
    L5:
        if (r4 != 1598968902) goto L7;
        r6.writeString(IProxyPushResourceListenerProxy.DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r4, r5, r6, r7);
    }
}
