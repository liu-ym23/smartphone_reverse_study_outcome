package com.ss.android.lark.resource.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IProxyPushResourceDownloadProgressListenerStub extends Binder implements IInterface, a {
    public final a base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IProxyPushResourceDownloadProgressListenerStub(a r1) {
        this.base = r1;
        attachInterface(this, IProxyPushResourceDownloadProgressListenerProxy.DESCRIPTOR);
    }

    public static IProxyPushResourceDownloadProgressListenerProxy asInterface(IBinder r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        IInterface r0 = r2.queryLocalInterface(IProxyPushResourceDownloadProgressListenerProxy.DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof IProxyPushResourceDownloadProgressListenerProxy) == false) goto L12;
        return (IProxyPushResourceDownloadProgressListenerProxy) r0;
    L12:
        return new IProxyPushResourceDownloadProgressListenerProxy(r2);
    }

    public void onPushDownloadProgress(String r8, int r9, long r10, long r12) {
        this.base.onPushDownloadProgress(r8, r9, r10, r12);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) throws RemoteException {
        if (r10 != 1) goto L5;
        r11.enforceInterface(IProxyPushResourceDownloadProgressListenerProxy.DESCRIPTOR);
        onPushDownloadProgress(r11.readString(), r11.readInt(), r11.readLong(), r11.readLong());
        r12.writeNoException();
        return true;
    L5:
        if (r10 != 1598968902) goto L7;
        r12.writeString(IProxyPushResourceDownloadProgressListenerProxy.DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r10, r11, r12, r13);
    }
}
