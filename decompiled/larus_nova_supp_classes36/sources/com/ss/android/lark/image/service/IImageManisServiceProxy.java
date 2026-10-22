package com.ss.android.lark.image.service;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import krc.b;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class IImageManisServiceProxy implements IImageManisService, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.image.service.IImageManisService";
    public static final int TRANSACTION_uploadEncryptImage_String_boolean_boolean_UploadEncryptImageCallback = 1;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public IImageManisServiceProxy(Context r1, IBinder r2) {
        this.mRemote = r2;
    }

    @Override // com.ss.android.lark.image.service.IImageManisService
    public void uploadEncryptImage(String r4, boolean r5, boolean r6, IImageManisService.a r7) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L17 RemoteException -> L19
        r0.writeString(r4);     // Catch: Throwable -> L17 RemoteException -> L19
        if (r5 == false) goto L6;
        int r8 = 1;
    L7:
        r0.writeInt(r8);     // Catch: Throwable -> L17 RemoteException -> L19
        if (r6 == false) goto L10;
        int r9 = 1;
    L11:
        r0.writeInt(r9);     // Catch: Throwable -> L17 RemoteException -> L19
        if (r7 == null) goto L14;
        r0.writeStrongBinder(new UploadEncryptImageCallbackStub(r7).asBinder());     // Catch: Throwable -> L17 RemoteException -> L19
    L15:
        INVOKEINTERFACE_com_ss_android_lark_image_service_IImageManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L17 RemoteException -> L19
        r1.readException();     // Catch: Throwable -> L17 RemoteException -> L19
    L21:
        r1.recycle();
        r0.recycle();
        return;
    L14:
        r0.writeStrongBinder(null);     // Catch: Throwable -> L17 RemoteException -> L19
        goto L15
    L10:
        r9 = 0;
        goto L11
    L6:
        r8 = 0;
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
        b.b("IImageManisServiceProxy", "call method uploadEncryptImage throw RemoteException", e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_image_service_IImageManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
}
