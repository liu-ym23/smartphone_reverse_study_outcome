package com.ss.android.lark.passport.signinsdk_api.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.lark.passport.signinsdk_api.entity.SessionResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ISwitchUserCallbackStub extends Binder implements IInterface, ILoginManisService.a {
    public final ILoginManisService.a base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public ISwitchUserCallbackStub(ILoginManisService.a r1) {
        this.base = r1;
        attachInterface(this, ISwitchUserCallbackProxy.DESCRIPTOR);
    }

    public static ISwitchUserCallbackProxy asInterface(IBinder r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        IInterface r0 = r2.queryLocalInterface(ISwitchUserCallbackProxy.DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof ISwitchUserCallbackProxy) == false) goto L12;
        return (ISwitchUserCallbackProxy) r0;
    L12:
        return new ISwitchUserCallbackProxy(r2);
    }

    @Override // com.ss.android.lark.passport.signinsdk_api.interfaces.ILoginManisService.a
    public void onSuccess(SessionResult r2) {
        this.base.onSuccess(r2);
    }

    @Override // com.ss.android.lark.passport.signinsdk_api.interfaces.ILoginManisService.a
    public void onError(int r2, String r3) {
        this.base.onError(r2, r3);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
        if (r4 != 1) goto L5;
        r5.enforceInterface(ISwitchUserCallbackProxy.DESCRIPTOR);
        if (r5.readInt() == 0) goto L17;
        SessionResult r8 = SessionResult.CREATOR.createFromParcel(r5);
    L18:
        onSuccess(r8);
        r6.writeNoException();
        return true;
    L17:
        r8 = null;
        goto L18
    L5:
        if (r4 != 2) goto L7;
        r5.enforceInterface(ISwitchUserCallbackProxy.DESCRIPTOR);
        onError(r5.readInt(), r5.readString());
        r6.writeNoException();
        return true;
    L7:
        if (r4 != 1598968902) goto L9;
        r6.writeString(ISwitchUserCallbackProxy.DESCRIPTOR);
        return true;
    L9:
        return super.onTransact(r4, r5, r6, r7);
    }
}
