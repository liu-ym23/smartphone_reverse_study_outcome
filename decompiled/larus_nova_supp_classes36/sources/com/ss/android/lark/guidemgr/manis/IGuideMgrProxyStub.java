package com.ss.android.lark.guidemgr.manis;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class IGuideMgrProxyStub extends Binder implements IInterface, IGuideMgrProxy {
    public final GuideMgrProxyImpl base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public void fetchFromMainProcess() {
        this.base.fetchFromMainProcess();
    }

    public IGuideMgrProxyStub(Context r2) {
        this.base = new GuideMgrProxyImpl(r2);
        attachInterface(this, IGuideMgrProxyProxy.DESCRIPTOR);
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public void onGuideChanged(String r2) {
        this.base.onGuideChanged(r2);
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public void registerOnGuideChangeListener(IGuideMgrProxy.a r2) {
        this.base.registerOnGuideChangeListener(r2);
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public boolean report(String r2) {
        return this.base.report(r2);
    }

    public static IGuideMgrProxyProxy asInterface(Context r2, IBinder r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        IInterface r0 = r3.queryLocalInterface(IGuideMgrProxyProxy.DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof IGuideMgrProxyProxy) == false) goto L12;
        return (IGuideMgrProxyProxy) r0;
    L12:
        return new IGuideMgrProxyProxy(r2, r3);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
        if (r4 != 1) goto L5;
        r5.enforceInterface(IGuideMgrProxyProxy.DESCRIPTOR);
        boolean r8 = report(r5.readString());
        r6.writeNoException();
        r6.writeInt(r8 ? 1 : 0);
        return true;
    L5:
        if (r4 != 2) goto L7;
        r5.enforceInterface(IGuideMgrProxyProxy.DESCRIPTOR);
        fetchFromMainProcess();
        r6.writeNoException();
        return true;
    L7:
        if (r4 != 3) goto L9;
        r5.enforceInterface(IGuideMgrProxyProxy.DESCRIPTOR);
        registerOnGuideChangeListener(OnGuideChangeListenerStub.asInterface(r5.readStrongBinder()));
        r6.writeNoException();
        return true;
    L9:
        if (r4 != 4) goto L11;
        r5.enforceInterface(IGuideMgrProxyProxy.DESCRIPTOR);
        onGuideChanged(r5.readString());
        r6.writeNoException();
        return true;
    L11:
        if (r4 != 1598968902) goto L13;
        r6.writeString(IGuideMgrProxyProxy.DESCRIPTOR);
        return true;
    L13:
        return super.onTransact(r4, r5, r6, r7);
    }
}
