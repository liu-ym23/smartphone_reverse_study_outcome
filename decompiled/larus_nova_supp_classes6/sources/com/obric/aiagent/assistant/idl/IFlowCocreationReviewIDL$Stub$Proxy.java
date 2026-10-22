package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IFlowCocreationReviewIDL$Stub$Proxy implements IFlowCocreationReviewIDL {
    public static IFlowCocreationReviewIDL sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL";
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public IFlowCocreationReviewIDL$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowCocreationReviewIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

    public void logOmniUserStop(String r15, long r16, String r18, long r19, String r21, String r22) throws RemoteException {
        Parcel r1 = Parcel.obtain();
        r1.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL");     // Catch: Throwable -> L16
        r1.writeString(r15);     // Catch: Throwable -> L16
        r1.writeLong(r16);     // Catch: Throwable -> L16
        r1.writeString(r18);     // Catch: Throwable -> L16
        r1.writeLong(r19);     // Catch: Throwable -> L16
        r1.writeString(r21);     // Catch: Throwable -> L16
        r1.writeString(r22);     // Catch: Throwable -> L16
    L14:
        th = th;
    L18:
        r1.recycle();
        throw th;
    L6:
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowCocreationReviewIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r1, null, 1) == false) goto L8;
    L12:
        r1.recycle();
        return;
    L8:
        if (IFlowCocreationReviewIDL.Stub.getDefaultImpl() == null) goto L12;
        IFlowCocreationReviewIDL.Stub.getDefaultImpl().logOmniUserStop(r15, r16, r18, r19, r21, r22);     // Catch: Throwable -> L14
        r1.recycle();
        return;
    L16:
        th = th;
        goto L18
    }

    public void logOmniStep(String r17, long r18, String r20, int r21, String r22, String r23, boolean r24, boolean r25, long r26, String r28) throws RemoteException {
        Parcel r1 = Parcel.obtain();
        r1.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL");     // Catch: Throwable -> L23
        r1.writeString(r17);     // Catch: Throwable -> L23
        r1.writeLong(r18);     // Catch: Throwable -> L23
        r1.writeString(r20);     // Catch: Throwable -> L23
        r1.writeInt(r21);     // Catch: Throwable -> L23
        r1.writeString(r22);     // Catch: Throwable -> L23
        r1.writeString(r23);     // Catch: Throwable -> L23
        int r2 = 0;
        if (r24 == false) goto L6;
        int r10 = 1;
    L7:
        r1.writeInt(r10);     // Catch: Throwable -> L23
        if (r25 == false) goto L10;
        r2 = 1;
    L10:
        r1.writeInt(r2);     // Catch: Throwable -> L23
        r1.writeLong(r26);     // Catch: Throwable -> L23
        r1.writeString(r28);     // Catch: Throwable -> L23
    L21:
        th = th;
    L25:
        r1.recycle();
        throw th;
    L13:
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowCocreationReviewIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r1, null, 1) == false) goto L15;
    L19:
        r1.recycle();
        return;
    L15:
        if (IFlowCocreationReviewIDL.Stub.getDefaultImpl() == null) goto L19;
        IFlowCocreationReviewIDL.Stub.getDefaultImpl().logOmniStep(r17, r18, r20, r21, r22, r23, r24, r25, r26, r28);     // Catch: Throwable -> L21
        r1.recycle();
        return;
    L6:
        r10 = 0;
    L23:
        th = th;
        goto L25
    }
}
