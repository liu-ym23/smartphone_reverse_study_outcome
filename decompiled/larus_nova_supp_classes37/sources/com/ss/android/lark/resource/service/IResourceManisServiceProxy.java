package com.ss.android.lark.resource.service;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IResourceManisServiceProxy implements IResourceManisService, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.resource.service.IResourceManisService";
    public static final int TRANSACTION_getAvatarPath_String_String_int_float = 3;
    public static final int TRANSACTION_getEncryptImage_String_String_String_String_String_boolean = 1;
    public static final int TRANSACTION_getEncryptImage_String_String_String_String_String_boolean_int = 2;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public IResourceManisServiceProxy(Context r1, IBinder r2) {
        this.mRemote = r2;
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public String getAvatarPath(String r4, String r5, int r6, float r7) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        r0.writeString(r4);     // Catch: Throwable -> L5 RemoteException -> L7
        r0.writeString(r5);     // Catch: Throwable -> L5 RemoteException -> L7
        r0.writeInt(r6);     // Catch: Throwable -> L5 RemoteException -> L7
        r0.writeFloat(r7);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_resource_service_IResourceManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
        String r8 = r1.readString();     // Catch: Throwable -> L5 RemoteException -> L7
        r1.recycle();
        r0.recycle();
        return r8;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        krc.b.b("IResourceManisServiceProxy", "call method getAvatarPath throw RemoteException", e);     // Catch: Throwable -> L5
        r1.recycle();
        r0.recycle();
        return null;
    L5:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_resource_service_IResourceManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        long r2 = SystemClock.uptimeMillis();
        boolean r0 = r15.transact(r16, r17, r18, r19);     // Catch: Throwable -> L12
        long r8 = SystemClock.uptimeMillis() - r2;
        if (r8 < 100) goto L11;
        BinderPerformanceReporter.report(r8, r15.getClass().getName(), r16, r19, new Throwable("Slow main-thread Binder transaction"));
    L11:
        return r0;
    L12:
        th = move-exception;
        long r9 = SystemClock.uptimeMillis() - r2;
        if (r9 < 100) goto L22;
        if (r15 != null) goto L17;
        String r1 = "";
    L18:
        BinderPerformanceReporter.report(r9, r1, r16, r19, new Throwable("Slow main-thread Binder transaction"));
        throw th;
    L17:
        r1 = r15.getClass().getName();
        goto L18
    L22:
        throw th;
    L5:
        return r15.transact(r16, r17, r18, r19);
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public Resource getEncryptImage(String r4, String r5, String r6, String r7, String r8, boolean r9) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L11 RemoteException -> L13
        r0.writeString(r4);     // Catch: Throwable -> L11 RemoteException -> L13
        r0.writeString(r5);     // Catch: Throwable -> L11 RemoteException -> L13
        r0.writeString(r6);     // Catch: Throwable -> L11 RemoteException -> L13
        r0.writeString(r7);     // Catch: Throwable -> L11 RemoteException -> L13
        r0.writeString(r8);     // Catch: Throwable -> L11 RemoteException -> L13
        if (r9 == false) goto L6;
        int r10 = 1;
    L7:
        r0.writeInt(r10);     // Catch: Throwable -> L11 RemoteException -> L13
        INVOKEINTERFACE_com_ss_android_lark_resource_service_IResourceManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L11 RemoteException -> L13
        r1.readException();     // Catch: Throwable -> L11 RemoteException -> L13
        if (r1.readInt() == 0) goto L15;
        Resource r11 = (Resource) Resource.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L11 RemoteException -> L13
    L16:
        r1.recycle();
        r0.recycle();
        return r11;
    L15:
        r11 = null;
        goto L16
    L6:
        r10 = 0;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        krc.b.b("IResourceManisServiceProxy", "call method getEncryptImage throw RemoteException", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public Resource getEncryptImage(String r4, String r5, String r6, String r7, String r8, boolean r9, int r10) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L11 RemoteException -> L13
        r0.writeString(r4);     // Catch: Throwable -> L11 RemoteException -> L13
        r0.writeString(r5);     // Catch: Throwable -> L11 RemoteException -> L13
        r0.writeString(r6);     // Catch: Throwable -> L11 RemoteException -> L13
        r0.writeString(r7);     // Catch: Throwable -> L11 RemoteException -> L13
        r0.writeString(r8);     // Catch: Throwable -> L11 RemoteException -> L13
        if (r9 == false) goto L6;
        int r11 = 1;
    L7:
        r0.writeInt(r11);     // Catch: Throwable -> L11 RemoteException -> L13
        r0.writeInt(r10);     // Catch: Throwable -> L11 RemoteException -> L13
        INVOKEINTERFACE_com_ss_android_lark_resource_service_IResourceManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0);     // Catch: Throwable -> L11 RemoteException -> L13
        r1.readException();     // Catch: Throwable -> L11 RemoteException -> L13
        if (r1.readInt() == 0) goto L15;
        Resource r12 = (Resource) Resource.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L11 RemoteException -> L13
    L16:
        r1.recycle();
        r0.recycle();
        return r12;
    L15:
        r12 = null;
        goto L16
    L6:
        r11 = 0;
    L11:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        krc.b.b("IResourceManisServiceProxy", "call method getEncryptImage throw RemoteException", e);     // Catch: Throwable -> L11
        goto L15
    }
}
