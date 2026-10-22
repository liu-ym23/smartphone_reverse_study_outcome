package com.ss.android.lark.opmonitor.process;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.lark.opmonitor.api.IOPMonitorHeartBeatListenerStub;
import com.ss.android.lark.opmonitor.model.OPMonitorHeartBeatMonitorData;
import eyb.a;
import krc.b;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IOPMonitorHeartBeatIPCProxy implements a, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.opmonitor.process.IOPMonitorHeartBeatIPC";
    public static final int TRANSACTION_endHeartBeat_String = 2;
    public static final int TRANSACTION_registerHeartBeat_OPMonitorHeartBeatMonitorData_IOPMonitorHeartBeatListener = 1;
    public static final int TRANSACTION_setLarkStatus_boolean = 3;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public void endHeartBeat(String r5) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        r0.writeString(r5);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_opmonitor_process_IOPMonitorHeartBeatIPCProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
    L9:
        r1.recycle();
        r0.recycle();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        b.b("IOPMonitorHeartBeatIPCProxy", "call method endHeartBeat throw RemoteException", e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void setLarkStatus(boolean r5) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
        if (r5 == false) goto L6;
        int r6 = 1;
    L7:
        r0.writeInt(r6);     // Catch: Throwable -> L9 RemoteException -> L11
        INVOKEINTERFACE_com_ss_android_lark_opmonitor_process_IOPMonitorHeartBeatIPCProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0);     // Catch: Throwable -> L9 RemoteException -> L11
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
        b.b("IOPMonitorHeartBeatIPCProxy", "call method setLarkStatus throw RemoteException", e);     // Catch: Throwable -> L9
        goto L13
    }

    public IOPMonitorHeartBeatIPCProxy(Context r1, IBinder r2) {
        this.mRemote = r2;
    }

    public void registerHeartBeat(OPMonitorHeartBeatMonitorData r5, byb.a r6) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L12 RemoteException -> L14
        if (r5 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L12 RemoteException -> L14
        r5.writeToParcel(r0, 0);     // Catch: Throwable -> L12 RemoteException -> L14
    L7:
        if (r6 == null) goto L9;
        r0.writeStrongBinder(new IOPMonitorHeartBeatListenerStub(r6).asBinder());     // Catch: Throwable -> L12 RemoteException -> L14
    L10:
        INVOKEINTERFACE_com_ss_android_lark_opmonitor_process_IOPMonitorHeartBeatIPCProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L12 RemoteException -> L14
        r1.readException();     // Catch: Throwable -> L12 RemoteException -> L14
    L16:
        r1.recycle();
        r0.recycle();
        return;
    L9:
        r0.writeStrongBinder(null);     // Catch: Throwable -> L12 RemoteException -> L14
        goto L10
    L6:
        r0.writeInt(0);     // Catch: Throwable -> L12 RemoteException -> L14
    L12:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        b.b("IOPMonitorHeartBeatIPCProxy", "call method registerHeartBeat throw RemoteException", e);     // Catch: Throwable -> L12
        goto L16
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_opmonitor_process_IOPMonitorHeartBeatIPCProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
