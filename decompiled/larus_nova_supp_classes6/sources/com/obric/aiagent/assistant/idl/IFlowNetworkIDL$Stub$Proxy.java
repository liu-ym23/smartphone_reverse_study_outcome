package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskSweepRequest;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IFlowNetworkIDL$Stub$Proxy implements IFlowNetworkIDL {
    public static IFlowNetworkIDL sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.aiagent.assistant.idl.IFlowNetworkIDL";
    }

    public int getCurrentNetworkStatus() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        int r2 = r1.readInt();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L10;
        int r3 = IFlowNetworkIDL.Stub.getDefaultImpl().getCurrentNetworkStatus();     // Catch: Throwable -> L13
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

    public IFlowNetworkIDL$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public void notifyStopComplexTaskByHttp(long r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L12
        r0.writeLong(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowNetworkIDL.Stub.getDefaultImpl().notifyStopComplexTaskByHttp(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void clearOmniTasks(Map r6, IFlowNetworkResultCallbackIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L16
        r0.writeMap(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowNetworkIDL.Stub.getDefaultImpl().clearOmniTasks(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void notifyStopComplexTaskByHttpWithScene(long r6, String r8) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L12
        r0.writeLong(r6);     // Catch: Throwable -> L12
        r0.writeString(r8);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowNetworkIDL.Stub.getDefaultImpl().notifyStopComplexTaskByHttpWithScene(r6, r8);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void notifyUserOperateQueue(String r6, IFlowNetworkResultCallbackIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L16
        r0.writeString(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L6;
        IBinder r2 = r7.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowNetworkIDL.Stub.getDefaultImpl().notifyUserOperateQueue(r6, r7);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void sweepConditionalTask(ObricConditionalTaskSweepRequest r6, IFlowNetworkResultCallbackIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L20
        if (r6 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L20
        r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
    L8:
        if (r7 == null) goto L10;
        IBinder r3 = r7.asBinder();     // Catch: Throwable -> L20
    L11:
        r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r0, null, 1) == false) goto L14;
    L18:
        r0.recycle();
        return;
    L14:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L18;
        IFlowNetworkIDL.Stub.getDefaultImpl().sweepConditionalTask(r6, r7);     // Catch: Throwable -> L20
        r0.recycle();
        return;
    L10:
        r3 = null;
        goto L11
    L6:
        r0.writeInt(0);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void deleteConditionalTask(String r6, Map r7, IFlowNetworkResultCallbackIDL r8) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L16
        r0.writeString(r6);     // Catch: Throwable -> L16
        r0.writeMap(r7);     // Catch: Throwable -> L16
        if (r8 == null) goto L6;
        IBinder r2 = r8.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowNetworkIDL.Stub.getDefaultImpl().deleteConditionalTask(r6, r7, r8);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void notifyStopOmniTaskByHttp(String r6, Map r7, IFlowNetworkResultCallbackIDL r8) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L16
        r0.writeString(r6);     // Catch: Throwable -> L16
        r0.writeMap(r7);     // Catch: Throwable -> L16
        if (r8 == null) goto L6;
        IBinder r2 = r8.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowNetworkIDL.Stub.getDefaultImpl().notifyStopOmniTaskByHttp(r6, r7, r8);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void sendIntentResultForAsyncNotifyByHttp(List<OPushEvent> r6, boolean r7, IFlowNetworkResultCallbackIDL r8) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L20
        r0.writeTypedList(r6);     // Catch: Throwable -> L20
        if (r7 == false) goto L6;
        int r2 = 1;
    L7:
        r0.writeInt(r2);     // Catch: Throwable -> L20
        if (r8 == null) goto L10;
        IBinder r3 = r8.asBinder();     // Catch: Throwable -> L20
    L11:
        r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L14;
    L18:
        r0.recycle();
        return;
    L14:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L18;
        IFlowNetworkIDL.Stub.getDefaultImpl().sendIntentResultForAsyncNotifyByHttp(r6, r7, r8);     // Catch: Throwable -> L20
        r0.recycle();
        return;
    L10:
        r3 = null;
        goto L11
    L6:
        r2 = 0;
    L20:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void sendIntentResultForCompensationByHttp(List<OPushEvent> r5, boolean r6, IFlowNetworkResultCallbackIDL r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L20
        r0.writeTypedList(r5);     // Catch: Throwable -> L20
        if (r6 == false) goto L6;
        int r2 = 1;
    L7:
        r0.writeInt(r2);     // Catch: Throwable -> L20
        if (r7 == null) goto L10;
        IBinder r3 = r7.asBinder();     // Catch: Throwable -> L20
    L11:
        r0.writeStrongBinder(r3);     // Catch: Throwable -> L20
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L14;
    L18:
        r0.recycle();
        return;
    L14:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L18;
        IFlowNetworkIDL.Stub.getDefaultImpl().sendIntentResultForCompensationByHttp(r5, r6, r7);     // Catch: Throwable -> L20
        r0.recycle();
        return;
    L10:
        r3 = null;
        goto L11
    L6:
        r2 = 0;
    L20:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void sendNormalRouterByHttp(String r6, String r7, IFlowNetworkResultCallbackIDL r8) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L16
        r0.writeString(r6);     // Catch: Throwable -> L16
        r0.writeString(r7);     // Catch: Throwable -> L16
        if (r8 == null) goto L6;
        IBinder r2 = r8.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowNetworkIDL.Stub.getDefaultImpl().sendNormalRouterByHttp(r6, r7, r8);     // Catch: Throwable -> L16
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
    public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

    public void sendReplyAskUserByHttp(String r9, String r10, String r11, Map r12, IFlowNetworkResultCallbackIDL r13) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L16
        r0.writeString(r9);     // Catch: Throwable -> L16
        r0.writeString(r10);     // Catch: Throwable -> L16
        r0.writeString(r11);     // Catch: Throwable -> L16
        r0.writeMap(r12);     // Catch: Throwable -> L16
        if (r13 == null) goto L6;
        IBinder r2 = r13.asBinder();     // Catch: Throwable -> L16
    L7:
        r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowNetworkIDL.Stub.getDefaultImpl().sendReplyAskUserByHttp(r9, r10, r11, r12, r13);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void uploadUserTakeOverByHttp(String r13, String r14, String r15, long r16, Map r18, IFlowNetworkResultCallbackIDL r19) throws RemoteException {
        Parcel r1 = Parcel.obtain();
        r1.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L20
        r1.writeString(r13);     // Catch: Throwable -> L20
        r1.writeString(r14);     // Catch: Throwable -> L20
        r1.writeString(r15);     // Catch: Throwable -> L20
        r1.writeLong(r16);     // Catch: Throwable -> L20
        r1.writeMap(r18);     // Catch: Throwable -> L20
        if (r19 == null) goto L6;
        IBinder r3 = r19.asBinder();     // Catch: Throwable -> L20
    L7:
        r1.writeStrongBinder(r3);     // Catch: Throwable -> L20
    L18:
        th = th;
    L22:
        r1.recycle();
        throw th;
    L10:
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r1, null, 1) == false) goto L12;
    L16:
        r1.recycle();
        return;
    L12:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L16;
        IFlowNetworkIDL.Stub.getDefaultImpl().uploadUserTakeOverByHttp(r13, r14, r15, r16, r18, r19);     // Catch: Throwable -> L18
        r1.recycle();
        return;
    L6:
        r3 = null;
    L20:
        th = th;
        goto L22
    }

    public void uploadOmniScreenshotByHttp(String r17, String r18, int r19, String r20, String r21, String r22, String r23, List<String> r24, String r25, String r26, IFlowNetworkResultCallbackIDL r27) throws RemoteException {
        Parcel r1 = Parcel.obtain();
        r1.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L20
        r1.writeString(r17);     // Catch: Throwable -> L20
        r1.writeString(r18);     // Catch: Throwable -> L20
        r1.writeInt(r19);     // Catch: Throwable -> L20
        r1.writeString(r20);     // Catch: Throwable -> L20
        r1.writeString(r21);     // Catch: Throwable -> L20
        r1.writeString(r22);     // Catch: Throwable -> L20
        r1.writeString(r23);     // Catch: Throwable -> L20
        r1.writeStringList(r24);     // Catch: Throwable -> L20
        r1.writeString(r25);     // Catch: Throwable -> L20
        r1.writeString(r26);     // Catch: Throwable -> L20
        if (r27 == null) goto L6;
        IBinder r3 = r27.asBinder();     // Catch: Throwable -> L20
    L7:
        r1.writeStrongBinder(r3);     // Catch: Throwable -> L20
    L18:
        th = th;
    L22:
        r1.recycle();
        throw th;
    L10:
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r1, null, 1) == false) goto L12;
    L16:
        r1.recycle();
        return;
    L12:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L16;
        IFlowNetworkIDL.Stub.getDefaultImpl().uploadOmniScreenshotByHttp(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);     // Catch: Throwable -> L18
        r1.recycle();
        return;
    L6:
        r3 = null;
    L20:
        th = th;
        goto L22
    }

    public void uploadOmniScreenshotByHttpV2(String r17, String r18, int r19, String r20, String r21, String r22, String r23, List<String> r24, String r25, String r26, boolean r27, IFlowNetworkResultCallbackIDL r28) throws RemoteException {
        Parcel r1 = Parcel.obtain();
        r1.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L24
        r1.writeString(r17);     // Catch: Throwable -> L24
        r1.writeString(r18);     // Catch: Throwable -> L24
        r1.writeInt(r19);     // Catch: Throwable -> L24
        r1.writeString(r20);     // Catch: Throwable -> L24
        r1.writeString(r21);     // Catch: Throwable -> L24
        r1.writeString(r22);     // Catch: Throwable -> L24
        r1.writeString(r23);     // Catch: Throwable -> L24
        r1.writeStringList(r24);     // Catch: Throwable -> L24
        r1.writeString(r25);     // Catch: Throwable -> L24
        r1.writeString(r26);     // Catch: Throwable -> L24
        if (r27 == false) goto L6;
        int r3 = 1;
    L7:
        r1.writeInt(r3);     // Catch: Throwable -> L24
        if (r28 == null) goto L10;
        IBinder r13 = r28.asBinder();     // Catch: Throwable -> L24
    L11:
        r1.writeStrongBinder(r13);     // Catch: Throwable -> L24
    L22:
        th = th;
    L26:
        r1.recycle();
        throw th;
    L14:
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r1, null, 1) == false) goto L16;
    L20:
        r1.recycle();
        return;
    L16:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L20;
        IFlowNetworkIDL.Stub.getDefaultImpl().uploadOmniScreenshotByHttpV2(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);     // Catch: Throwable -> L22
        r1.recycle();
        return;
    L10:
        r13 = null;
        goto L11
    L6:
        r3 = 0;
    L24:
        th = th;
        goto L26
    }

    public void uploadOmniDataFeedbackByHttp(String r19, String r20, int r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, List<String> r30, String r31, String r32, IFlowNetworkResultCallbackIDL r33) throws RemoteException {
        Parcel r1 = Parcel.obtain();
        r1.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L16
        r1.writeString(r19);     // Catch: Throwable -> L16
        r1.writeString(r20);     // Catch: Throwable -> L16
        r1.writeInt(r21);     // Catch: Throwable -> L16
        r1.writeString(r22);     // Catch: Throwable -> L16
        r1.writeString(r23);     // Catch: Throwable -> L16
        r1.writeString(r24);     // Catch: Throwable -> L16
        r1.writeString(r25);     // Catch: Throwable -> L16
        r1.writeString(r26);     // Catch: Throwable -> L16
        r1.writeString(r27);     // Catch: Throwable -> L16
        r1.writeString(r28);     // Catch: Throwable -> L16
        r1.writeString(r29);     // Catch: Throwable -> L16
        r1.writeStringList(r30);     // Catch: Throwable -> L16
        r1.writeString(r31);     // Catch: Throwable -> L16
        r1.writeString(r32);     // Catch: Throwable -> L16
        if (r33 == null) goto L6;
        IBinder r2 = r33.asBinder();     // Catch: Throwable -> L16
    L7:
        r1.writeStrongBinder(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r1, null, 1) == false) goto L10;
    L14:
        r1.recycle();
        return;
    L10:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowNetworkIDL.Stub.getDefaultImpl().uploadOmniDataFeedbackByHttp(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33);     // Catch: Throwable -> L16
        r1.recycle();
        return;
    L6:
        r2 = null;
    L16:
        th = move-exception;
        r1.recycle();
        throw th;
    }

    public void createConditionalTask(String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, Map r34, IFlowNetworkResultCallbackIDL r35) throws RemoteException {
        Parcel r1 = Parcel.obtain();
        r1.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L16
        r1.writeString(r20);     // Catch: Throwable -> L16
        r1.writeString(r21);     // Catch: Throwable -> L16
        r1.writeString(r22);     // Catch: Throwable -> L16
        r1.writeString(r23);     // Catch: Throwable -> L16
        r1.writeString(r24);     // Catch: Throwable -> L16
        r1.writeString(r25);     // Catch: Throwable -> L16
        r1.writeString(r26);     // Catch: Throwable -> L16
        r1.writeString(r27);     // Catch: Throwable -> L16
        r1.writeString(r28);     // Catch: Throwable -> L16
        r1.writeString(r29);     // Catch: Throwable -> L16
        r1.writeString(r30);     // Catch: Throwable -> L16
        r1.writeString(r31);     // Catch: Throwable -> L16
        r1.writeString(r32);     // Catch: Throwable -> L16
        r1.writeString(r33);     // Catch: Throwable -> L16
        r1.writeMap(r34);     // Catch: Throwable -> L16
        if (r35 == null) goto L6;
        IBinder r0 = r35.asBinder();     // Catch: Throwable -> L16
    L7:
        r1.writeStrongBinder(r0);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r1, null, 1) == false) goto L10;
    L14:
        r1.recycle();
        return;
    L10:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowNetworkIDL.Stub.getDefaultImpl().createConditionalTask(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35);     // Catch: Throwable -> L16
        r1.recycle();
        return;
    L6:
        r0 = null;
    L16:
        th = move-exception;
        r1.recycle();
        throw th;
    }

    public void uploadOmniDataFeedbackByHttpV2(String r20, String r21, int r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, List<String> r31, String r32, String r33, boolean r34, IFlowNetworkResultCallbackIDL r35) throws RemoteException {
        Parcel r1 = Parcel.obtain();
        r1.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowNetworkIDL");     // Catch: Throwable -> L20
        r1.writeString(r20);     // Catch: Throwable -> L20
        r1.writeString(r21);     // Catch: Throwable -> L20
        r1.writeInt(r22);     // Catch: Throwable -> L20
        r1.writeString(r23);     // Catch: Throwable -> L20
        r1.writeString(r24);     // Catch: Throwable -> L20
        r1.writeString(r25);     // Catch: Throwable -> L20
        r1.writeString(r26);     // Catch: Throwable -> L20
        r1.writeString(r27);     // Catch: Throwable -> L20
        r1.writeString(r28);     // Catch: Throwable -> L20
        r1.writeString(r29);     // Catch: Throwable -> L20
        r1.writeString(r30);     // Catch: Throwable -> L20
        r1.writeStringList(r31);     // Catch: Throwable -> L20
        r1.writeString(r32);     // Catch: Throwable -> L20
        r1.writeString(r33);     // Catch: Throwable -> L20
        if (r34 == false) goto L6;
        int r2 = 1;
    L7:
        r1.writeInt(r2);     // Catch: Throwable -> L20
        if (r35 == null) goto L10;
        IBinder r3 = r35.asBinder();     // Catch: Throwable -> L20
    L11:
        r1.writeStrongBinder(r3);     // Catch: Throwable -> L20
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r1, null, 1) == false) goto L14;
    L18:
        r1.recycle();
        return;
    L14:
        if (IFlowNetworkIDL.Stub.getDefaultImpl() == null) goto L18;
        IFlowNetworkIDL.Stub.getDefaultImpl().uploadOmniDataFeedbackByHttpV2(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35);     // Catch: Throwable -> L20
        r1.recycle();
        return;
    L10:
        r3 = null;
        goto L11
    L6:
        r2 = 0;
    L20:
        th = move-exception;
        r1.recycle();
        throw th;
    }
}
