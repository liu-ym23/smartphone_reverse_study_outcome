package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IFlowVoiceInteractionIDL$Stub$Proxy implements IFlowVoiceInteractionIDL {
    public static IFlowVoiceInteractionIDL sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL";
    }

    public boolean closeContinuousTalk() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowVoiceInteractionIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowVoiceInteractionIDL.Stub.getDefaultImpl().closeContinuousTalk();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isInRealtimeCalling() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowVoiceInteractionIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowVoiceInteractionIDL.Stub.getDefaultImpl().isInRealtimeCalling();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isInteractionSessionStateListening() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowVoiceInteractionIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowVoiceInteractionIDL.Stub.getDefaultImpl().isInteractionSessionStateListening();     // Catch: Throwable -> L15
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

    public IFlowVoiceInteractionIDL$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public void readContent(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowVoiceInteractionIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowVoiceInteractionIDL.Stub.getDefaultImpl().readContent(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void readContentByMessage(IMMessage r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L16
        r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
    L8:
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowVoiceInteractionIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowVoiceInteractionIDL.Stub.getDefaultImpl().readContentByMessage(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r0.writeInt(0);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void replayMessageTts(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowVoiceInteractionIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowVoiceInteractionIDL.Stub.getDefaultImpl().replayMessageTts(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void requireSyncData(IFlowSyncDataResultIDL r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL");     // Catch: Throwable -> L16
        if (r6 == null) goto L6;
        IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowVoiceInteractionIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowVoiceInteractionIDL.Stub.getDefaultImpl().requireSyncData(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public boolean tryInterruptAssistant(AppEvent r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL");     // Catch: Throwable -> L20
        boolean r2 = true;
        if (r7 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L20
        r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
    L8:
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0) == false) goto L10;
    L14:
        r1.readException();     // Catch: Throwable -> L20
        if (r1.readInt() != 0) goto L18;
        r2 = false;
    L18:
        r1.recycle();
        r0.recycle();
        return r2;
    L10:
        if (IFlowVoiceInteractionIDL.Stub.getDefaultImpl() == null) goto L14;
        boolean r8 = IFlowVoiceInteractionIDL.Stub.getDefaultImpl().tryInterruptAssistant(r7);     // Catch: Throwable -> L20
        r1.recycle();
        r0.recycle();
        return r8;
    L6:
        r0.writeInt(0);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void tryOpenClickTalk(int r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL");     // Catch: Throwable -> L12
        r0.writeInt(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowVoiceInteractionIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowVoiceInteractionIDL.Stub.getDefaultImpl().tryOpenClickTalk(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public boolean tryOpenMicToRecording(AppEvent r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL");     // Catch: Throwable -> L20
        boolean r2 = true;
        if (r7 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L20
        r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
    L8:
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0) == false) goto L10;
    L14:
        r1.readException();     // Catch: Throwable -> L20
        if (r1.readInt() != 0) goto L18;
        r2 = false;
    L18:
        r1.recycle();
        r0.recycle();
        return r2;
    L10:
        if (IFlowVoiceInteractionIDL.Stub.getDefaultImpl() == null) goto L14;
        boolean r8 = IFlowVoiceInteractionIDL.Stub.getDefaultImpl().tryOpenMicToRecording(r7);     // Catch: Throwable -> L20
        r1.recycle();
        r0.recycle();
        return r8;
    L6:
        r0.writeInt(0);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void updateIntentExt(Map r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL");     // Catch: Throwable -> L12
        r0.writeMap(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowVoiceInteractionIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowVoiceInteractionIDL.Stub.getDefaultImpl().updateIntentExt(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void updateScreenshotForAsr(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL");     // Catch: Throwable -> L12
        r0.writeString(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowVoiceInteractionIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowVoiceInteractionIDL.Stub.getDefaultImpl().updateScreenshotForAsr(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void wakeupAssistant(String r5) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL");     // Catch: Throwable -> L12
        r0.writeString(r5);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowVoiceInteractionIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowVoiceInteractionIDL.Stub.getDefaultImpl().wakeupAssistant(r5);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
