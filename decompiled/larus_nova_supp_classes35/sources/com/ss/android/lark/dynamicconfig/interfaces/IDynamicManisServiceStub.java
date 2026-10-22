package com.ss.android.lark.dynamicconfig.interfaces;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.lark.dynamicconfig.service.impl.DynamicManisServiceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IDynamicManisServiceStub extends Binder implements IInterface, IDynamicManisService {
    public final DynamicManisServiceImpl base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IDynamicManisServiceStub(Context r2) {
        this.base = new DynamicManisServiceImpl(r2);
        attachInterface(this, IDynamicManisServiceProxy.DESCRIPTOR);
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDynamicManisService
    public String getDynamicDomain(String r2) {
        return this.base.getDynamicDomain(r2);
    }

    public static IDynamicManisServiceProxy asInterface(Context r2, IBinder r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        IInterface r0 = r3.queryLocalInterface(IDynamicManisServiceProxy.DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof IDynamicManisServiceProxy) == false) goto L12;
        return (IDynamicManisServiceProxy) r0;
    L12:
        return new IDynamicManisServiceProxy(r2, r3);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
        if (r4 != 1) goto L5;
        r5.enforceInterface(IDynamicManisServiceProxy.DESCRIPTOR);
        String r8 = getDynamicDomain(r5.readString());
        r6.writeNoException();
        r6.writeString(r8);
        return true;
    L5:
        if (r4 != 1598968902) goto L7;
        r6.writeString(IDynamicManisServiceProxy.DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r4, r5, r6, r7);
    }
}
