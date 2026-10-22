package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class IFlowAppLogEventObserverIDL$Stub$Proxy implements IFlowAppLogEventObserverIDL {
    public static IFlowAppLogEventObserverIDL sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.aiagent.flow.applog.idl.IFlowAppLogEventObserverIDL";
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public IFlowAppLogEventObserverIDL$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public void onEventV3(String r5, String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogEventObserverIDL");     // Catch: Throwable -> L12
        r0.writeString(r5);     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogEventObserverIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowAppLogEventObserverIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowAppLogEventObserverIDL.Stub.getDefaultImpl().onEventV3(r5, r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogEventObserverIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
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
