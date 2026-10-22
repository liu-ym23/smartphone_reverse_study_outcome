package com.obric.livecard.api;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class IIslandCardCallback$Stub$Proxy implements IIslandCardCallback {
    public static IIslandCardCallback sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.livecard.api.IIslandCardCallback";
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public IIslandCardCallback$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public Bundle hasViewClickId(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.livecard.api.IIslandCardCallback");     // Catch: Throwable -> L17
        r0.writeString(r6);     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_obric_livecard_api_IIslandCardCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        Bundle r7 = (Bundle) Bundle.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r7;
    L14:
        r7 = null;
        goto L15
    L6:
        if (IIslandCardCallback.Stub.getDefaultImpl() == null) goto L10;
        Bundle r8 = IIslandCardCallback.Stub.getDefaultImpl().hasViewClickId(r6);     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r8;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public Bundle onCardEvent(String r6, Bundle r7) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.livecard.api.IIslandCardCallback");     // Catch: Throwable -> L21
        r0.writeString(r6);     // Catch: Throwable -> L21
        if (r7 == null) goto L6;
        r0.writeInt(1);     // Catch: Throwable -> L21
        r7.writeToParcel(r0, 0);     // Catch: Throwable -> L21
    L8:
        if (INVOKEINTERFACE_com_obric_livecard_api_IIslandCardCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L10;
    L14:
        r1.readException();     // Catch: Throwable -> L21
        if (r1.readInt() == 0) goto L18;
        Bundle r8 = (Bundle) Bundle.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L21
    L19:
        r1.recycle();
        r0.recycle();
        return r8;
    L18:
        r8 = null;
        goto L19
    L10:
        if (IIslandCardCallback.Stub.getDefaultImpl() == null) goto L14;
        Bundle r9 = IIslandCardCallback.Stub.getDefaultImpl().onCardEvent(r6, r7);     // Catch: Throwable -> L21
        r1.recycle();
        r0.recycle();
        return r9;
    L6:
        r0.writeInt(0);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_livecard_api_IIslandCardCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
