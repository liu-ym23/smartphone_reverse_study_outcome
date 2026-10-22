package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL;
import com.obric.aiagent.ipc.idl.IFileIDL;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IFlowIDL$Stub$Proxy implements IFlowIDL {
    public static IFlowIDL sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.aiagent.assistant.idl.IFlowIDL";
    }

    public IFlowAppIntentIDL getAppIntentIDL() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        IFlowAppIntentIDL r2 = IFlowAppIntentIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowAppIntentIDL r3 = IFlowIDL.Stub.getDefaultImpl().getAppIntentIDL();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IFlowAppLogIDL getAppLogIDL() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        IFlowAppLogIDL r2 = IFlowAppLogIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowAppLogIDL r3 = IFlowIDL.Stub.getDefaultImpl().getAppLogIDL();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IFlowAppStateIDL getAppStateIDL() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        IFlowAppStateIDL r2 = IFlowAppStateIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowAppStateIDL r3 = IFlowIDL.Stub.getDefaultImpl().getAppStateIDL();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IFlowAssistantStateIDL getAssistantStateIDL() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        IFlowAssistantStateIDL r2 = IFlowAssistantStateIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowAssistantStateIDL r3 = IFlowIDL.Stub.getDefaultImpl().getAssistantStateIDL();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IFlowCocreationReviewIDL getCocreationReviewIDL() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        IFlowCocreationReviewIDL r2 = IFlowCocreationReviewIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowCocreationReviewIDL r3 = IFlowIDL.Stub.getDefaultImpl().getCocreationReviewIDL();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IFileIDL getFileIDL() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        IFileIDL r2 = IFileIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowIDL.Stub.getDefaultImpl() == null) goto L10;
        IFileIDL r3 = IFlowIDL.Stub.getDefaultImpl().getFileIDL();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IFlowFeedbackIDL getFlowFeedbackIDL() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        IFlowFeedbackIDL r2 = IFlowFeedbackIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowFeedbackIDL r3 = IFlowIDL.Stub.getDefaultImpl().getFlowFeedbackIDL();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IFlowNetworkIDL getFlowNetworkIDL() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        IFlowNetworkIDL r2 = IFlowNetworkIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowNetworkIDL r3 = IFlowIDL.Stub.getDefaultImpl().getFlowNetworkIDL();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IFlowPermissionIDL getFlowPermissionIDL() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        IFlowPermissionIDL r2 = IFlowPermissionIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowPermissionIDL r3 = IFlowIDL.Stub.getDefaultImpl().getFlowPermissionIDL();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IFlowFrontierIDL getFrontierIDL() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        IFlowFrontierIDL r2 = IFlowFrontierIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowFrontierIDL r3 = IFlowIDL.Stub.getDefaultImpl().getFrontierIDL();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IFlowMessageIDL getMessageIDL() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        IFlowMessageIDL r2 = IFlowMessageIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowMessageIDL r3 = IFlowIDL.Stub.getDefaultImpl().getMessageIDL();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IFlowSettingsIDL getSettingsIDL() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        IFlowSettingsIDL r2 = IFlowSettingsIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowSettingsIDL r3 = IFlowIDL.Stub.getDefaultImpl().getSettingsIDL();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IFlowUiIDL getUiIDL() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        IFlowUiIDL r2 = IFlowUiIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowUiIDL r3 = IFlowIDL.Stub.getDefaultImpl().getUiIDL();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IFlowVoiceInteractionIDL getVoiceInteractionIDL() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        IFlowVoiceInteractionIDL r2 = IFlowVoiceInteractionIDL.Stub.asInterface(r1.readStrongBinder());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowVoiceInteractionIDL r3 = IFlowIDL.Stub.getDefaultImpl().getVoiceInteractionIDL();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public IFlowIDL$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
