package com.ss.android.lark.dynamicconfig.manis;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DynamicHostProxyStub extends Binder implements IInterface, DynamicHostProxy {
    public final DynamicHostProxyImpl base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // com.ss.android.lark.dynamicconfig.manis.DynamicHostProxy
    public String getDocMainDomain() {
        return this.base.getDocMainDomain();
    }

    @Override // com.ss.android.lark.dynamicconfig.manis.DynamicHostProxy
    public String getMainDomain() {
        return this.base.getMainDomain();
    }

    @Override // com.ss.android.lark.dynamicconfig.manis.DynamicHostProxy
    public List<String> getMainDomains() {
        return this.base.getMainDomains();
    }

    public DynamicHostProxyStub(Context r2) {
        this.base = new DynamicHostProxyImpl(r2);
        attachInterface(this, DynamicHostProxyProxy.DESCRIPTOR);
    }

    public static DynamicHostProxyProxy asInterface(Context r2, IBinder r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        IInterface r0 = r3.queryLocalInterface(DynamicHostProxyProxy.DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof DynamicHostProxyProxy) == false) goto L12;
        return (DynamicHostProxyProxy) r0;
    L12:
        return new DynamicHostProxyProxy(r2, r3);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
        if (r4 != 1) goto L5;
        r5.enforceInterface(DynamicHostProxyProxy.DESCRIPTOR);
        String r8 = getMainDomain();
        r6.writeNoException();
        r6.writeString(r8);
        return true;
    L5:
        if (r4 != 2) goto L7;
        r5.enforceInterface(DynamicHostProxyProxy.DESCRIPTOR);
        List<String> r9 = getMainDomains();
        r6.writeNoException();
        r6.writeList(r9);
        return true;
    L7:
        if (r4 != 3) goto L9;
        r5.enforceInterface(DynamicHostProxyProxy.DESCRIPTOR);
        String r10 = getDocMainDomain();
        r6.writeNoException();
        r6.writeString(r10);
        return true;
    L9:
        if (r4 != 1598968902) goto L11;
        r6.writeString(DynamicHostProxyProxy.DESCRIPTOR);
        return true;
    L11:
        return super.onTransact(r4, r5, r6, r7);
    }
}
