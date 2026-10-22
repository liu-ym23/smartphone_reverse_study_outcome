package com.ss.android.lark.image.service;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.lark.image.impl.ImageManisService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class IImageManisServiceStub extends Binder implements IInterface, IImageManisService {
    public final ImageManisService base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IImageManisServiceStub(Context r2) {
        this.base = new ImageManisService(r2);
        attachInterface(this, IImageManisServiceProxy.DESCRIPTOR);
    }

    public static IImageManisServiceProxy asInterface(Context r2, IBinder r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        IInterface r0 = r3.queryLocalInterface(IImageManisServiceProxy.DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof IImageManisServiceProxy) == false) goto L12;
        return (IImageManisServiceProxy) r0;
    L12:
        return new IImageManisServiceProxy(r2, r3);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
        if (r4 != 1) goto L5;
        r5.enforceInterface(IImageManisServiceProxy.DESCRIPTOR);
        String r8 = r5.readString();
        boolean r0 = false;
        if (r5.readInt() != 0) goto L13;
        boolean r9 = false;
    L15:
        if (r5.readInt() == 0) goto L18;
        r0 = true;
    L18:
        uploadEncryptImage(r8, r9, r0, UploadEncryptImageCallbackStub.asInterface(r5.readStrongBinder()));
        r6.writeNoException();
        return true;
    L13:
        r9 = true;
        goto L15
    L5:
        if (r4 != 1598968902) goto L7;
        r6.writeString(IImageManisServiceProxy.DESCRIPTOR);
        return true;
    L7:
        return super.onTransact(r4, r5, r6, r7);
    }

    @Override // com.ss.android.lark.image.service.IImageManisService
    public void uploadEncryptImage(String r2, boolean r3, boolean r4, IImageManisService.a r5) {
        this.base.uploadEncryptImage(r2, r3, r4, r5);
    }
}
