package com.ss.android.lark.guidemgr.manis;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import krc.b;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class IGuideMgrProxyProxy implements IGuideMgrProxy, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.guidemgr.manis.IGuideMgrProxy";
    public static final int TRANSACTION_fetchFromMainProcess = 2;
    public static final int TRANSACTION_onGuideChanged_String = 4;
    public static final int TRANSACTION_registerOnGuideChangeListener_OnGuideChangeListener = 3;
    public static final int TRANSACTION_report_String = 1;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public void fetchFromMainProcess() {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_guidemgr_manis_IGuideMgrProxyProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
    L9:
        r1.recycle();
        r0.recycle();
        return;
    L5:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        b.b("IGuideMgrProxyProxy", "call method fetchFromMainProcess throw RemoteException", e);     // Catch: Throwable -> L5
        goto L9
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public void onGuideChanged(String r5) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        r0.writeString(r5);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_guidemgr_manis_IGuideMgrProxyProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
    L9:
        r1.recycle();
        r0.recycle();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        b.b("IGuideMgrProxyProxy", "call method onGuideChanged throw RemoteException", e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public void registerOnGuideChangeListener(IGuideMgrProxy.a r5) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
        if (r5 == null) goto L6;
        r0.writeStrongBinder(new OnGuideChangeListenerStub(r5).asBinder());     // Catch: Throwable -> L9 RemoteException -> L11
    L7:
        INVOKEINTERFACE_com_ss_android_lark_guidemgr_manis_IGuideMgrProxyProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0);     // Catch: Throwable -> L9 RemoteException -> L11
        r1.readException();     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        r1.recycle();
        r0.recycle();
        return;
    L6:
        r0.writeStrongBinder(null);     // Catch: Throwable -> L9 RemoteException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        b.b("IGuideMgrProxyProxy", "call method registerOnGuideChangeListener throw RemoteException", e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public boolean report(String r6) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        boolean r2 = false;
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L6 RemoteException -> L8
        r0.writeString(r6);     // Catch: Throwable -> L6 RemoteException -> L8
        INVOKEINTERFACE_com_ss_android_lark_guidemgr_manis_IGuideMgrProxyProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L6 RemoteException -> L8
        r1.readException();     // Catch: Throwable -> L6 RemoteException -> L8
        if (r1.readInt() == 0) goto L10;
        r2 = true;
    L10:
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L6
        b.b("IGuideMgrProxyProxy", "call method report throw RemoteException", e);     // Catch: Throwable -> L6
        goto L10
    }

    public IGuideMgrProxyProxy(Context r1, IBinder r2) {
        this.mRemote = r2;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_guidemgr_manis_IGuideMgrProxyProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
