package com.obric.aiagent.flow.applog.idl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IFlowAppLogIDL$Stub$Proxy implements IFlowAppLogIDL {
    public static IFlowAppLogIDL sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL";
    }

    public void clearLaunchService() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowAppLogIDL.Stub.getDefaultImpl().clearLaunchService();     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public String getDid() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        String r2 = r1.readString();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L10;
        String r3 = IFlowAppLogIDL.Stub.getDefaultImpl().getDid();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public String getIid() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        String r2 = r1.readString();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L10;
        String r3 = IFlowAppLogIDL.Stub.getDefaultImpl().getIid();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public String getSsid() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        String r2 = r1.readString();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L10;
        String r3 = IFlowAppLogIDL.Stub.getDefaultImpl().getSsid();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public String getUserID() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        String r2 = r1.readString();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L10;
        String r3 = IFlowAppLogIDL.Stub.getDefaultImpl().getUserID();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public String getUserUniqueID() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        String r2 = r1.readString();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L10;
        String r3 = IFlowAppLogIDL.Stub.getDefaultImpl().getUserUniqueID();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void onPause() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowAppLogIDL.Stub.getDefaultImpl().onPause();     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void onStop() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowAppLogIDL.Stub.getDefaultImpl().onStop();     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public IFlowAppLogIDL$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public void addDataObserver(IFlowAppLogDataObserverIDL r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowAppLogIDL.Stub.getDefaultImpl().addDataObserver(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void addEventObserver(IFlowAppLogEventObserverIDL r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowAppLogIDL.Stub.getDefaultImpl().addEventObserver(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void addSessionHook(IFlowAppLogSessionObserverIDL r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowAppLogIDL.Stub.getDefaultImpl().addSessionHook(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void onEventV3(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowAppLogIDL.Stub.getDefaultImpl().onEventV3(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void removeDataObserver(IFlowAppLogDataObserverIDL r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowAppLogIDL.Stub.getDefaultImpl().removeDataObserver(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void removeEventObserver(IFlowAppLogEventObserverIDL r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowAppLogIDL.Stub.getDefaultImpl().removeEventObserver(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void removeSessionHook(IFlowAppLogSessionObserverIDL r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowAppLogIDL.Stub.getDefaultImpl().removeSessionHook(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void setHeaderInfo(Map r5) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
        r0.writeMap(r5);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowAppLogIDL.Stub.getDefaultImpl().setHeaderInfo(r5);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void setLaunchService(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowAppLogIDL.Stub.getDefaultImpl().setLaunchService(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void onEventV3Bundle(String r6, Bundle r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L16
        r0.writeString(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L16
        r7.writeToParcel(r0, 0);     // Catch: Throwable -> L16
    L8:
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowAppLogIDL.Stub.getDefaultImpl().onEventV3Bundle(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r0.writeInt(0);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void onEventV3Json(String r6, String r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        r0.writeString(r7);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowAppLogIDL.Stub.getDefaultImpl().onEventV3Json(r6, r7);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void onResume(String r6, int r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        r0.writeInt(r7);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowAppLogIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowAppLogIDL.Stub.getDefaultImpl().onResume(r6, r7);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
