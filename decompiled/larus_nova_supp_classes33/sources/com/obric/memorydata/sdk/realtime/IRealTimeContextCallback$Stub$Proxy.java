package com.obric.memorydata.sdk.realtime;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class IRealTimeContextCallback$Stub$Proxy implements IRealTimeContextCallback {
    public static IRealTimeContextCallback sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.memorydata.sdk.realtime.IRealTimeContextCallback";
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public IRealTimeContextCallback$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public void updateActionContext(ActionContext r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.memorydata.sdk.realtime.IRealTimeContextCallback");     // Catch: Throwable -> L17
        if (r6 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L17
        r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
    L8:
        if (INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
    L14:
        r1.readException();     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return;
    L10:
        if (IRealTimeContextCallback.Stub.getDefaultImpl() == null) goto L14;
        IRealTimeContextCallback.Stub.getDefaultImpl().updateActionContext(r6);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return;
    L6:
        r0.writeInt(0);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void updateRealTimeContext(RealTimeContext r6, boolean r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.memorydata.sdk.realtime.IRealTimeContextCallback");     // Catch: Throwable -> L20
        if (r6 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L20
        r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
    L7:
        if (r7 == false) goto L9;
        int r4 = 1;
    L10:
        r0.writeInt(r4);     // Catch: Throwable -> L20
        if (INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L13;
    L17:
        r1.readException();     // Catch: Throwable -> L20
        r1.recycle();
        r0.recycle();
        return;
    L13:
        if (IRealTimeContextCallback.Stub.getDefaultImpl() == null) goto L17;
        IRealTimeContextCallback.Stub.getDefaultImpl().updateRealTimeContext(r6, r7);     // Catch: Throwable -> L20
        r1.recycle();
        r0.recycle();
        return;
    L9:
        r4 = 0;
        goto L10
    L6:
        r0.writeInt(0);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
