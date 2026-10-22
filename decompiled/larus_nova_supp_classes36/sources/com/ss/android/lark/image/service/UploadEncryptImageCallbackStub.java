package com.ss.android.lark.image.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.lark.image.entity.EncryptImageData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UploadEncryptImageCallbackStub extends Binder implements IInterface, IImageManisService.a {
    public final IImageManisService.a base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public UploadEncryptImageCallbackStub(IImageManisService.a r1) {
        this.base = r1;
        attachInterface(this, UploadEncryptImageCallbackProxy.DESCRIPTOR);
    }

    public static UploadEncryptImageCallbackProxy asInterface(IBinder r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        IInterface r0 = r2.queryLocalInterface(UploadEncryptImageCallbackProxy.DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof UploadEncryptImageCallbackProxy) == false) goto L12;
        return (UploadEncryptImageCallbackProxy) r0;
    L12:
        return new UploadEncryptImageCallbackProxy(r2);
    }

    @Override // com.ss.android.lark.image.service.IImageManisService.a
    public void onError(ErrorResultWrapper r2) {
        this.base.onError(r2);
    }

    @Override // com.ss.android.lark.image.service.IImageManisService.a
    public void onSuccess(EncryptImageData r2) {
        this.base.onSuccess(r2);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
        EncryptImageData r0 = null;
        ErrorResultWrapper r1 = null;
        if (r5 != 1) goto L5;
        r6.enforceInterface(UploadEncryptImageCallbackProxy.DESCRIPTOR);
        if (r6.readInt() == 0) goto L20;
        r0 = EncryptImageData.CREATOR.createFromParcel(r6);
    L20:
        onSuccess(r0);
        r7.writeNoException();
        return true;
    L5:
        if (r5 != 2) goto L7;
        r6.enforceInterface(UploadEncryptImageCallbackProxy.DESCRIPTOR);
        if (r6.readInt() == 0) goto L15;
        r1 = ErrorResultWrapper.CREATOR.createFromParcel(r6);
    L15:
        onError(r1);
        r7.writeNoException();
        return true;
    L7:
        if (r5 != 1598968902) goto L9;
        r7.writeString(UploadEncryptImageCallbackProxy.DESCRIPTOR);
        return true;
    L9:
        return super.onTransact(r5, r6, r7, r8);
    }
}
