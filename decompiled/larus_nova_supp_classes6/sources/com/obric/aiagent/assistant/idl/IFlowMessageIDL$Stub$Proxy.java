package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IFlowMessageIDL$Stub$Proxy implements IFlowMessageIDL {
    public static IFlowMessageIDL sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.aiagent.assistant.idl.IFlowMessageIDL";
    }

    public String generateLocalMessageId() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        String r2 = r1.readString();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L10;
        String r3 = IFlowMessageIDL.Stub.getDefaultImpl().generateLocalMessageId();     // Catch: Throwable -> L13
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

    public IFlowMessageIDL$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public void deleteRemoteResource(List<String> r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L12
        r0.writeStringList(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowMessageIDL.Stub.getDefaultImpl().deleteRemoteResource(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public String getMainTxtContentFromMessage(IMMessage r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L17
        if (r6 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L17
        r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
    L8:
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 27, r0, r1, 0) == false) goto L10;
    L14:
        r1.readException();     // Catch: Throwable -> L17
        String r7 = r1.readString();     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r7;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        String r8 = IFlowMessageIDL.Stub.getDefaultImpl().getMainTxtContentFromMessage(r6);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r8;
    L6:
        r0.writeInt(0);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isConversationTtsEnabled(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L15
        r0.writeString(r6);     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r7 = IFlowMessageIDL.Stub.getDefaultImpl().isConversationTtsEnabled(r6);     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r7;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void registerCallback(IFlowMessageCallbackIDL r5) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        if (r5 == null) goto L6;
        IBinder r2 = r5.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().registerCallback(r5);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void registerSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().registerSendMessageExtCallback(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void registerStreamObserver(IFlowStreamObserverIDL r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().registerStreamObserver(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void retryFetchMessage(IMMessage r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L16
        r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
    L8:
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 23, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().retryFetchMessage(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r0.writeInt(0);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void unregisterCallback(IFlowMessageCallbackIDL r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().unregisterCallback(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void unregisterSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().unregisterSendMessageExtCallback(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void unregisterStreamObserver(IFlowStreamObserverIDL r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().unregisterStreamObserver(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void appendMessageExt(String r6, Map r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        r0.writeMap(r7);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowMessageIDL.Stub.getDefaultImpl().appendMessageExt(r6, r7);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void deleteMessage(String r6, IFlowDeleteMessageCallbackIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        r0.writeString(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().deleteMessage(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void fetchLatestMessages(int r6, IFlowFindMessagesCallbackIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        r0.writeInt(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 25, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().fetchLatestMessages(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void findAnswersbyQueryId(String r6, IFlowFindMessagesCallbackIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        r0.writeString(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 28, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().findAnswersbyQueryId(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void findMessagebyId(String r6, IFlowFindMessageCallbackIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        r0.writeString(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().findMessagebyId(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void getMainTxtContentForMessage(String r6, IFlowMessageMainTextBlockCallbackIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        r0.writeString(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 26, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().getMainTxtContentForMessage(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void imageXUpload(String r6, IImageXUploadCallbackIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        r0.writeString(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().imageXUpload(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void isMessageLocalInterrupted(String r6, IFlowIsMessageInterruptedCallbackIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        r0.writeString(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().isMessageLocalInterrupted(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void refreshLatestMessages(String r6, int r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        r0.writeInt(r7);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 24, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowMessageIDL.Stub.getDefaultImpl().refreshLatestMessages(r6, r7);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void registerCallbackWithEvents(IFlowMessageCallbackIDL r6, int r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        r0.writeInt(r7);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 30, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().registerCallbackWithEvents(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void updateMessageExt(String r6, Map r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        r0.writeMap(r7);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 22, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowMessageIDL.Stub.getDefaultImpl().updateMessageExt(r6, r7);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void updateMutableMessageContent(String r6, String r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        r0.writeString(r7);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 29, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowMessageIDL.Stub.getDefaultImpl().updateMutableMessageContent(r6, r7);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void addMessage(IMMessage r6, String r7, String r8) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L16
        r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
    L7:
        r0.writeString(r7);     // Catch: Throwable -> L16
        r0.writeString(r8);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().addMessage(r6, r7, r8);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r0.writeInt(0);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void updateMutableWidgetRenderData(String r6, String r7, String r8) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        r0.writeString(r7);     // Catch: Throwable -> L12
        r0.writeString(r8);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 31, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowMessageIDL.Stub.getDefaultImpl().updateMutableWidgetRenderData(r6, r7, r8);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void uploadImage(String r6, String r7, IImageXUploadCallbackIDL r8) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        r0.writeString(r6);     // Catch: Throwable -> L16
        r0.writeString(r7);     // Catch: Throwable -> L16
        if (r8 == null) goto L6;
        IBinder r2 = r8.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().uploadImage(r6, r7, r8);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void notifySemanticUserEditEvent(String r6, String r7, Map r8, IFlowSemanticEditCallbackIDL r9) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        r0.writeString(r6);     // Catch: Throwable -> L16
        r0.writeString(r7);     // Catch: Throwable -> L16
        r0.writeMap(r8);     // Catch: Throwable -> L16
        if (r9 == null) goto L6;
        IBinder r2 = r9.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().notifySemanticUserEditEvent(r6, r7, r8, r9);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void sendMessage(String r6, String r7, String r8, String r9) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        r0.writeString(r7);     // Catch: Throwable -> L12
        r0.writeString(r8);     // Catch: Throwable -> L12
        r0.writeString(r9);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowMessageIDL.Stub.getDefaultImpl().sendMessage(r6, r7, r8, r9);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

    public void notifySemanticUserEditEventWithIdentifier(String r9, String r10, String r11, Map r12, IFlowSemanticEditCallbackIDL r13) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        r0.writeString(r9);     // Catch: Throwable -> L16
        r0.writeString(r10);     // Catch: Throwable -> L16
        r0.writeString(r11);     // Catch: Throwable -> L16
        r0.writeMap(r12);     // Catch: Throwable -> L16
        if (r13 == null) goto L6;
        IBinder r2 = r13.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().notifySemanticUserEditEventWithIdentifier(r9, r10, r11, r12, r13);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void notifySemanticUserEditEventWithUri(String r9, String r10, String r11, Map r12, IFlowSemanticEditCallbackIDL r13) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L16
        r0.writeString(r9);     // Catch: Throwable -> L16
        r0.writeString(r10);     // Catch: Throwable -> L16
        r0.writeString(r11);     // Catch: Throwable -> L16
        r0.writeMap(r12);     // Catch: Throwable -> L16
        if (r13 == null) goto L6;
        IBinder r2 = r13.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowMessageIDL.Stub.getDefaultImpl().notifySemanticUserEditEventWithUri(r9, r10, r11, r12, r13);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void sendMessageWithExtra(String r9, String r10, String r11, String r12, Map r13) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowMessageIDL");     // Catch: Throwable -> L12
        r0.writeString(r9);     // Catch: Throwable -> L12
        r0.writeString(r10);     // Catch: Throwable -> L12
        r0.writeString(r11);     // Catch: Throwable -> L12
        r0.writeString(r12);     // Catch: Throwable -> L12
        r0.writeMap(r13);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 21, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowMessageIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowMessageIDL.Stub.getDefaultImpl().sendMessageWithExtra(r9, r10, r11, r12, r13);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }
}
