package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.Authentication;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IFlowUiIDL$Stub$Proxy implements IFlowUiIDL {
    public static IFlowUiIDL sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.aiagent.assistant.idl.IFlowUiIDL";
    }

    public void dismissKeyguard() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowUiIDL.Stub.getDefaultImpl().dismissKeyguard();     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void finishChatPage() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowUiIDL.Stub.getDefaultImpl().finishChatPage();     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public String getCurrentDisplayModel() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 32, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        String r2 = r1.readString();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        String r3 = IFlowUiIDL.Stub.getDefaultImpl().getCurrentDisplayModel();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public String getTaskSkillModelJson() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 31, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        String r2 = r1.readString();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        String r3 = IFlowUiIDL.Stub.getDefaultImpl().getTaskSkillModelJson();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public int getWindowState() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        int r2 = r1.readInt();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        int r3 = IFlowUiIDL.Stub.getDefaultImpl().getWindowState();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isAssistantRequestFromAIKey() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 23, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowUiIDL.Stub.getDefaultImpl().isAssistantRequestFromAIKey();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isAuthenticationPass() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowUiIDL.Stub.getDefaultImpl().isAuthenticationPass();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isWindowMode() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 28, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowUiIDL.Stub.getDefaultImpl().isWindowMode();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isWindowShowing() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 30, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowUiIDL.Stub.getDefaultImpl().isWindowShowing();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void notifyOAutoDied() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 21, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowUiIDL.Stub.getDefaultImpl().notifyOAutoDied();     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void popWindow() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 29, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowUiIDL.Stub.getDefaultImpl().popWindow();     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void processRequiresAuthentication() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 26, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowUiIDL.Stub.getDefaultImpl().processRequiresAuthentication();     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void showWindow() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 27, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowUiIDL.Stub.getDefaultImpl().showWindow();     // Catch: Throwable -> L12
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

    public IFlowUiIDL$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public void closeAssistantInputPanel(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowUiIDL.Stub.getDefaultImpl().closeAssistantInputPanel(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public boolean isAudioMessage(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L15
        r0.writeString(r6);     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 24, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r7 = IFlowUiIDL.Stub.getDefaultImpl().isAudioMessage(r6);     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r7;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isAuthenticationPassV2(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L15
        r0.writeString(r6);     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r7 = IFlowUiIDL.Stub.getDefaultImpl().isAuthenticationPassV2(r6);     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r7;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public Authentication isAuthenticationPassV3(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L17
        r0.writeString(r6);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 22, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        Authentication r7 = Authentication.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r7;
    L14:
        r7 = null;
        goto L15
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        Authentication r8 = IFlowUiIDL.Stub.getDefaultImpl().isAuthenticationPassV3(r6);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r8;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void notifyMessageInAutoGui(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowUiIDL.Stub.getDefaultImpl().notifyMessageInAutoGui(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void openChatActivity(int r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L12
        r0.writeInt(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowUiIDL.Stub.getDefaultImpl().openChatActivity(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void setAutoIncreaseWindow(boolean r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L16
        if (r6 == false) goto L6;
        int r2 = 1;
    L7:
        r0.writeInt(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowUiIDL.Stub.getDefaultImpl().setAutoIncreaseWindow(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = 0;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void showToast(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowUiIDL.Stub.getDefaultImpl().showToast(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void openRealtimeCall(int r6, IOpenRealTimeCallCallbackIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L16
        r0.writeInt(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowUiIDL.Stub.getDefaultImpl().openRealtimeCall(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void requestDeviceCredentialAuthentication(IRequestAuthenticationCallbackIDL r6, Bundle r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L20
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L20
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L20
        if (r7 == null) goto L10;
        r0.writeInt(1);     // Catch: Throwable -> L20
        r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
    L12:
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r0, null, 1) == false) goto L14;
    L18:
        r0.recycle();
        return;
    L14:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L18;
        IFlowUiIDL.Stub.getDefaultImpl().requestDeviceCredentialAuthentication(r6, r7);     // Catch: Throwable -> L20
        r0.recycle();
        return;
    L10:
        r0.writeInt(0);     // Catch: Throwable -> L20
        goto L12
    L6:
        r2 = null;
    L20:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void requestVoicePrintAuthentication(IRequestAuthenticationCallbackIDL r6, Bundle r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L20
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L20
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L20
        if (r7 == null) goto L10;
        r0.writeInt(1);     // Catch: Throwable -> L20
        r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
    L12:
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r0, null, 1) == false) goto L14;
    L18:
        r0.recycle();
        return;
    L14:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L18;
        IFlowUiIDL.Stub.getDefaultImpl().requestVoicePrintAuthentication(r6, r7);     // Catch: Throwable -> L20
        r0.recycle();
        return;
    L10:
        r0.writeInt(0);     // Catch: Throwable -> L20
        goto L12
    L6:
        r2 = null;
    L20:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void setAssistantInteractionListener(String r6, IAssistantInteractionListenerIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L16
        r0.writeString(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowUiIDL.Stub.getDefaultImpl().setAssistantInteractionListener(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void shouldDowngradeAuthForDora(int r6, IDowngradeAuthForDoraCallbackIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L16
        r0.writeInt(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 25, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowUiIDL.Stub.getDefaultImpl().shouldDowngradeAuthForDora(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void handleObricAction(String r6, String r7, IObricActionResultCallbackIDL r8) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L16
        r0.writeString(r6);     // Catch: Throwable -> L16
        r0.writeString(r7);     // Catch: Throwable -> L16
        if (r8 == null) goto L6;
        IBinder r2 = r8.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowUiIDL.Stub.getDefaultImpl().handleObricAction(r6, r7, r8);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void notifyAssistantState(String r6, boolean r7, StateInfo r8) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L20
        r0.writeString(r6);     // Catch: Throwable -> L20
        if (r7 == false) goto L6;
        int r3 = 1;
    L7:
        r0.writeInt(r3);     // Catch: Throwable -> L20
        if (r8 == null) goto L10;
        r0.writeInt(1);     // Catch: Throwable -> L20
        r8.writeToParcel(r0, 0);     // Catch: Throwable -> L20
    L12:
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r0, null, 1) == false) goto L14;
    L18:
        r0.recycle();
        return;
    L14:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L18;
        IFlowUiIDL.Stub.getDefaultImpl().notifyAssistantState(r6, r7, r8);     // Catch: Throwable -> L20
        r0.recycle();
        return;
    L10:
        r0.writeInt(0);     // Catch: Throwable -> L20
        goto L12
    L6:
        r3 = 0;
    L20:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void openAssistantInputPanel(String r6, StateInfo r7, boolean r8) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L18
        r0.writeString(r6);     // Catch: Throwable -> L18
        int r2 = 0;
        if (r7 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L18
        r7.writeToParcel(r0, 0);     // Catch: Throwable -> L18
    L7:
        if (r8 == false) goto L9;
        r2 = 1;
    L9:
        r0.writeInt(r2);     // Catch: Throwable -> L18
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, null, 1) == false) goto L12;
    L16:
        r0.recycle();
        return;
    L12:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L16;
        IFlowUiIDL.Stub.getDefaultImpl().openAssistantInputPanel(r6, r7, r8);     // Catch: Throwable -> L18
        r0.recycle();
        return;
    L6:
        r0.writeInt(0);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void requestBiometricAuthentication(IRequestAuthenticationCallbackIDL r6, boolean r7, Bundle r8) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L24
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L24
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L24
        if (r7 == false) goto L10;
        int r4 = 1;
    L11:
        r0.writeInt(r4);     // Catch: Throwable -> L24
        if (r8 == null) goto L14;
        r0.writeInt(1);     // Catch: Throwable -> L24
        r8.writeToParcel(r0, 0);     // Catch: Throwable -> L24
    L16:
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r0, null, 1) == false) goto L18;
    L22:
        r0.recycle();
        return;
    L18:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L22;
        IFlowUiIDL.Stub.getDefaultImpl().requestBiometricAuthentication(r6, r7, r8);     // Catch: Throwable -> L24
        r0.recycle();
        return;
    L14:
        r0.writeInt(0);     // Catch: Throwable -> L24
        goto L16
    L10:
        r4 = 0;
        goto L11
    L6:
        r2 = null;
    L24:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void addCustomBarAction(String r9, String r10, String r11, long r12) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L12
        r0.writeString(r9);     // Catch: Throwable -> L12
        r0.writeString(r10);     // Catch: Throwable -> L12
        r0.writeString(r11);     // Catch: Throwable -> L12
        r0.writeLong(r12);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowUiIDL.Stub.getDefaultImpl().addCustomBarAction(r9, r10, r11, r12);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

    public void suspendDismissKeyguard(String r9, String[] r10, IDismissKeyguardCallbackIDL r11, boolean r12, Bundle r13) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowUiIDL");     // Catch: Throwable -> L24
        r0.writeString(r9);     // Catch: Throwable -> L24
        r0.writeStringArray(r10);     // Catch: Throwable -> L24
        if (r11 == null) goto L6;
        IBinder r2 = r11.asBinder();     // Catch: Throwable -> L24
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L24
        if (r12 == false) goto L10;
        int r4 = 1;
    L11:
        r0.writeInt(r4);     // Catch: Throwable -> L24
        if (r13 == null) goto L14;
        r0.writeInt(1);     // Catch: Throwable -> L24
        r13.writeToParcel(r0, 0);     // Catch: Throwable -> L24
    L16:
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, null, 1) == false) goto L18;
    L22:
        r0.recycle();
        return;
    L18:
        if (IFlowUiIDL.Stub.getDefaultImpl() == null) goto L22;
        IFlowUiIDL.Stub.getDefaultImpl().suspendDismissKeyguard(r9, r10, r11, r12, r13);     // Catch: Throwable -> L24
        r0.recycle();
        return;
    L14:
        r0.writeInt(0);     // Catch: Throwable -> L24
        goto L16
    L10:
        r4 = 0;
        goto L11
    L6:
        r2 = null;
    L24:
        th = move-exception;
        r0.recycle();
        throw th;
    }
}
