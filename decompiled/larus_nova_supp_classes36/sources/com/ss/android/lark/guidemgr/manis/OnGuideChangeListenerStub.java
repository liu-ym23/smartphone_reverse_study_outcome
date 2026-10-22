package com.ss.android.lark.guidemgr.manis;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OnGuideChangeListenerStub extends Binder implements IInterface, IGuideMgrProxy.a {
    public final IGuideMgrProxy.a base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public OnGuideChangeListenerStub(IGuideMgrProxy.a r1) {
        this.base = r1;
        attachInterface(this, OnGuideChangeListenerProxy.DESCRIPTOR);
    }

    public static OnGuideChangeListenerProxy asInterface(IBinder r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        IInterface r0 = r2.queryLocalInterface(OnGuideChangeListenerProxy.DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof OnGuideChangeListenerProxy) == false) goto L12;
        return (OnGuideChangeListenerProxy) r0;
    L12:
        return new OnGuideChangeListenerProxy(r2);
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy.a
    public void onGuideChanged(String r2) {
        this.base.onGuideChanged(r2);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
        if (r4 != 1) goto L5;
        r5.enforceInterface(OnGuideChangeListenerProxy.DESCRIPTOR);
        onGuideChanged(r5.readString());
        r6.writeNoException();
        return true;
    L5:
        if (r4 != 1598968902) goto L7;
        r6.writeString(OnGuideChangeListenerProxy.DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r4, r5, r6, r7);
    }
}
