package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class IRequestAuthenticationCallbackIDL$Stub$Proxy implements IRequestAuthenticationCallbackIDL {
    public static IRequestAuthenticationCallbackIDL sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL";
    }

    public void onAuthenticationCancelled() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL");     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IRequestAuthenticationCallbackIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IRequestAuthenticationCallbackIDL.Stub.getDefaultImpl() == null) goto L10;
        IRequestAuthenticationCallbackIDL.Stub.getDefaultImpl().onAuthenticationCancelled();     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void onAuthenticationFailed() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL");     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IRequestAuthenticationCallbackIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IRequestAuthenticationCallbackIDL.Stub.getDefaultImpl() == null) goto L10;
        IRequestAuthenticationCallbackIDL.Stub.getDefaultImpl().onAuthenticationFailed();     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void onAuthenticationNotAvailable() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL");     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IRequestAuthenticationCallbackIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IRequestAuthenticationCallbackIDL.Stub.getDefaultImpl() == null) goto L10;
        IRequestAuthenticationCallbackIDL.Stub.getDefaultImpl().onAuthenticationNotAvailable();     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void onAuthenticationPass() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL");     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IRequestAuthenticationCallbackIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IRequestAuthenticationCallbackIDL.Stub.getDefaultImpl() == null) goto L10;
        IRequestAuthenticationCallbackIDL.Stub.getDefaultImpl().onAuthenticationPass();     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void onAuthenticationTimeout() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL");     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IRequestAuthenticationCallbackIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IRequestAuthenticationCallbackIDL.Stub.getDefaultImpl() == null) goto L10;
        IRequestAuthenticationCallbackIDL.Stub.getDefaultImpl().onAuthenticationTimeout();     // Catch: Throwable -> L12
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

    public IRequestAuthenticationCallbackIDL$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IRequestAuthenticationCallbackIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
