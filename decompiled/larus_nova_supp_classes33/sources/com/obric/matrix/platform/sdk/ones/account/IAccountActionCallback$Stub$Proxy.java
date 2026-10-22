package com.obric.matrix.platform.sdk.ones.account;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class IAccountActionCallback$Stub$Proxy implements IAccountActionCallback {
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback";
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public IAccountActionCallback$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public void onResult(boolean r4, Bundle r5) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback");     // Catch: Throwable -> L14
        if (r4 == false) goto L6;
        int r6 = 1;
    L7:
        r0.writeInt(r6);     // Catch: Throwable -> L14
        if (r5 == null) goto L10;
        r0.writeInt(1);     // Catch: Throwable -> L14
        r5.writeToParcel(r0, 0);     // Catch: Throwable -> L14
    L11:
        INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountActionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1);     // Catch: Throwable -> L14
        r0.recycle();
        return;
    L10:
        r0.writeInt(0);     // Catch: Throwable -> L14
        goto L11
    L6:
        r6 = 0;
    L14:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountActionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
