package com.obric.livecard.api;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class IIslandStatusCallback$Stub$Proxy implements IIslandStatusCallback {
    public static IIslandStatusCallback sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.livecard.api.IIslandStatusCallback";
    }

    public long getId() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.livecard.api.IIslandStatusCallback");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_livecard_api_IIslandStatusCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        long r2 = r1.readLong();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IIslandStatusCallback.Stub.getDefaultImpl() == null) goto L10;
        long r3 = IIslandStatusCallback.Stub.getDefaultImpl().getId();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void onIslandExpand() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.livecard.api.IIslandStatusCallback");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_livecard_api_IIslandStatusCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return;
    L6:
        if (IIslandStatusCallback.Stub.getDefaultImpl() == null) goto L10;
        IIslandStatusCallback.Stub.getDefaultImpl().onIslandExpand();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void onIslandStartActivity() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.livecard.api.IIslandStatusCallback");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_livecard_api_IIslandStatusCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return;
    L6:
        if (IIslandStatusCallback.Stub.getDefaultImpl() == null) goto L10;
        IIslandStatusCallback.Stub.getDefaultImpl().onIslandStartActivity();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public IIslandStatusCallback$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public void keepAliveOnAOD(boolean r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.livecard.api.IIslandStatusCallback");     // Catch: Throwable -> L17
        if (r6 == false) goto L6;
        int r3 = 1;
    L7:
        r0.writeInt(r3);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_obric_livecard_api_IIslandStatusCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L10;
    L14:
        r1.readException();     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return;
    L10:
        if (IIslandStatusCallback.Stub.getDefaultImpl() == null) goto L14;
        IIslandStatusCallback.Stub.getDefaultImpl().keepAliveOnAOD(r6);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return;
    L6:
        r3 = 0;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void onIslandDialogueMode(boolean r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.livecard.api.IIslandStatusCallback");     // Catch: Throwable -> L17
        if (r6 == false) goto L6;
        int r3 = 1;
    L7:
        r0.writeInt(r3);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_obric_livecard_api_IIslandStatusCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L10;
    L14:
        r1.readException();     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return;
    L10:
        if (IIslandStatusCallback.Stub.getDefaultImpl() == null) goto L14;
        IIslandStatusCallback.Stub.getDefaultImpl().onIslandDialogueMode(r6);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return;
    L6:
        r3 = 0;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void onIslandWidthChange(int r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.livecard.api.IIslandStatusCallback");     // Catch: Throwable -> L13
        r0.writeInt(r6);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_livecard_api_IIslandStatusCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return;
    L6:
        if (IIslandStatusCallback.Stub.getDefaultImpl() == null) goto L10;
        IIslandStatusCallback.Stub.getDefaultImpl().onIslandWidthChange(r6);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_livecard_api_IIslandStatusCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
