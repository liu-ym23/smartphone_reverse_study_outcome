package com.ss.android.lark.resource.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IProxyPushResourceListenerProxy implements b, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.resource.service.IProxyPushResourceListener";
    public static final int TRANSACTION_onPushDownloadStatus_String_boolean = 1;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public IProxyPushResourceListenerProxy(IBinder r1) {
        this.mRemote = r1;
    }

    public void onPushDownloadStatus(String r4, boolean r5) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
        r0.writeString(r4);     // Catch: Throwable -> L9 RemoteException -> L11
        if (r5 == false) goto L6;
        int r6 = 1;
    L7:
        r0.writeInt(r6);     // Catch: Throwable -> L9 RemoteException -> L11
        INVOKEINTERFACE_com_ss_android_lark_resource_service_IProxyPushResourceListenerProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L9 RemoteException -> L11
        r1.readException();     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        r1.recycle();
        r0.recycle();
        return;
    L6:
        r6 = 0;
    L9:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        goto L13
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_resource_service_IProxyPushResourceListenerProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
