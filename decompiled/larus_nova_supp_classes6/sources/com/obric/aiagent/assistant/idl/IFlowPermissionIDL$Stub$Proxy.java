package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.Permission;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IFlowPermissionIDL$Stub$Proxy implements IFlowPermissionIDL {
    public static IFlowPermissionIDL sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.aiagent.assistant.idl.IFlowPermissionIDL";
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public IFlowPermissionIDL$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public Map isPermissionGranted(List<String> r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowPermissionIDL");     // Catch: Throwable -> L13
        r0.writeStringList(r6);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowPermissionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        HashMap r7 = r1.readHashMap(getClass().getClassLoader());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r7;
    L6:
        if (IFlowPermissionIDL.Stub.getDefaultImpl() == null) goto L10;
        Map r8 = IFlowPermissionIDL.Stub.getDefaultImpl().isPermissionGranted(r6);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r8;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void updateAppletPermissions(List<Permission> r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowPermissionIDL");     // Catch: Throwable -> L12
        r0.writeTypedList(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowPermissionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowPermissionIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowPermissionIDL.Stub.getDefaultImpl().updateAppletPermissions(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void updatePersonalPermissions(List<Permission> r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowPermissionIDL");     // Catch: Throwable -> L12
        r0.writeTypedList(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowPermissionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowPermissionIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowPermissionIDL.Stub.getDefaultImpl().updatePersonalPermissions(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public Map isAppletPermissionGranted(String r6, List<String> r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowPermissionIDL");     // Catch: Throwable -> L13
        r0.writeString(r6);     // Catch: Throwable -> L13
        r0.writeStringList(r7);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowPermissionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        HashMap r8 = r1.readHashMap(getClass().getClassLoader());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r8;
    L6:
        if (IFlowPermissionIDL.Stub.getDefaultImpl() == null) goto L10;
        Map r9 = IFlowPermissionIDL.Stub.getDefaultImpl().isAppletPermissionGranted(r6, r7);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r9;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public Map isPersonalPermissionGranted(String r6, List<String> r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowPermissionIDL");     // Catch: Throwable -> L13
        r0.writeString(r6);     // Catch: Throwable -> L13
        r0.writeStringList(r7);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowPermissionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        HashMap r8 = r1.readHashMap(getClass().getClassLoader());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r8;
    L6:
        if (IFlowPermissionIDL.Stub.getDefaultImpl() == null) goto L10;
        Map r9 = IFlowPermissionIDL.Stub.getDefaultImpl().isPersonalPermissionGranted(r6, r7);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r9;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean requestPermission(String r6, String r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowPermissionIDL");     // Catch: Throwable -> L15
        r0.writeString(r6);     // Catch: Throwable -> L15
        r0.writeString(r7);     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowPermissionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowPermissionIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r8 = IFlowPermissionIDL.Stub.getDefaultImpl().requestPermission(r6, r7);     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r8;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowPermissionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
