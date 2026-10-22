package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IFlowAppStateIDL$Stub$Proxy implements IFlowAppStateIDL {
    public static IFlowAppStateIDL sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.aiagent.assistant.idl.IFlowAppStateIDL";
    }

    public String getCurrentActivity() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppStateIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        String r2 = r1.readString();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowAppStateIDL.Stub.getDefaultImpl() == null) goto L10;
        String r3 = IFlowAppStateIDL.Stub.getDefaultImpl().getCurrentActivity();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isAppBackground() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppStateIDL");     // Catch: Throwable -> L15
        boolean r3 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r3 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r3;
    L6:
        if (IFlowAppStateIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowAppStateIDL.Stub.getDefaultImpl().isAppBackground();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isAppPaused() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppStateIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowAppStateIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowAppStateIDL.Stub.getDefaultImpl().isAppPaused();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public IFlowAppStateIDL$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public void registerAppStateListener(IFlowOnAppStateChangedListenerIDL r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppStateIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowAppStateIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowAppStateIDL.Stub.getDefaultImpl().registerAppStateListener(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void unregisterAppStateListener(IFlowOnAppStateChangedListenerIDL r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowAppStateIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowAppStateIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowAppStateIDL.Stub.getDefaultImpl().unregisterAppStateListener(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
