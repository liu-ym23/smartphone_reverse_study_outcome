package com.ss.android.lark.resource.service;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.lark.resource.service.impl.ResourceManisServiceImpl;
import com.suite.lark.platform.service.resourcerepository.api.Resource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IResourceManisServiceStub extends Binder implements IInterface, IResourceManisService {
    public final ResourceManisServiceImpl base;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public IResourceManisServiceStub(Context r2) {
        this.base = new ResourceManisServiceImpl(r2);
        attachInterface(this, IResourceManisServiceProxy.DESCRIPTOR);
    }

    public static IResourceManisServiceProxy asInterface(Context r2, IBinder r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        IInterface r0 = r3.queryLocalInterface(IResourceManisServiceProxy.DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof IResourceManisServiceProxy) == false) goto L12;
        return (IResourceManisServiceProxy) r0;
    L12:
        return new IResourceManisServiceProxy(r2, r3);
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public String getAvatarPath(String r2, String r3, int r4, float r5) {
        return this.base.getAvatarPath(r2, r3, r4, r5);
    }

    @Override // android.os.Binder
    public boolean onTransact(int r12, Parcel r13, Parcel r14, int r15) throws RemoteException {
        if (r12 != 1) goto L5;
        r13.enforceInterface(IResourceManisServiceProxy.DESCRIPTOR);
        String r4 = r13.readString();
        String r5 = r13.readString();
        String r6 = r13.readString();
        String r7 = r13.readString();
        String r8 = r13.readString();
        if (r13.readInt() != 0) goto L28;
        boolean r9 = false;
    L29:
        Resource r16 = getEncryptImage(r4, r5, r6, r7, r8, r9);
        r14.writeNoException();
        if (r16 == null) goto L32;
        r14.writeInt(1);
        r16.writeToParcel(r14, 1);
    L33:
        return true;
    L32:
        r14.writeInt(0);
        goto L33
    L28:
        r9 = true;
        goto L29
    L5:
        if (r12 != 2) goto L7;
        r13.enforceInterface(IResourceManisServiceProxy.DESCRIPTOR);
        String r10 = r13.readString();
        String r11 = r13.readString();
        String r17 = r13.readString();
        String r18 = r13.readString();
        String r19 = r13.readString();
        if (r13.readInt() != 0) goto L19;
        boolean r20 = false;
    L20:
        Resource r110 = getEncryptImage(r10, r11, r17, r18, r19, r20, r13.readInt());
        r14.writeNoException();
        if (r110 == null) goto L23;
        r14.writeInt(1);
        r110.writeToParcel(r14, 1);
    L24:
        return true;
    L23:
        r14.writeInt(0);
        goto L24
    L19:
        r20 = true;
        goto L20
    L7:
        if (r12 != 3) goto L9;
        r13.enforceInterface(IResourceManisServiceProxy.DESCRIPTOR);
        String r111 = getAvatarPath(r13.readString(), r13.readString(), r13.readInt(), r13.readFloat());
        r14.writeNoException();
        r14.writeString(r111);
        return true;
    L9:
        if (r12 != 1598968902) goto L11;
        r14.writeString(IResourceManisServiceProxy.DESCRIPTOR);
        return true;
    L11:
        return super.onTransact(r12, r13, r14, r15);
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public Resource getEncryptImage(String r8, String r9, String r10, String r11, String r12, boolean r13) {
        return this.base.getEncryptImage(r8, r9, r10, r11, r12, r13);
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public Resource getEncryptImage(String r9, String r10, String r11, String r12, String r13, boolean r14, int r15) {
        return this.base.getEncryptImage(r9, r10, r11, r12, r13, r14, r15);
    }
}
