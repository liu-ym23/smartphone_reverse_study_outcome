package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class IDismissKeyguardCallbackIDL$Stub$Proxy implements IDismissKeyguardCallbackIDL {
    public static IDismissKeyguardCallbackIDL sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.aiagent.assistant.idl.IDismissKeyguardCallbackIDL";
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public IDismissKeyguardCallbackIDL$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public void onResult(boolean r5, boolean r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IDismissKeyguardCallbackIDL");     // Catch: Throwable -> L19
        int r1 = 0;
        if (r5 == false) goto L6;
        int r3 = 1;
    L7:
        r0.writeInt(r3);     // Catch: Throwable -> L19
        if (r6 == false) goto L10;
        r1 = 1;
    L10:
        r0.writeInt(r1);     // Catch: Throwable -> L19
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IDismissKeyguardCallbackIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1) == false) goto L13;
    L17:
        r0.recycle();
        return;
    L13:
        if (IDismissKeyguardCallbackIDL.Stub.getDefaultImpl() == null) goto L17;
        IDismissKeyguardCallbackIDL.Stub.getDefaultImpl().onResult(r5, r6);     // Catch: Throwable -> L19
        r0.recycle();
        return;
    L6:
        r3 = 0;
    L19:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IDismissKeyguardCallbackIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
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
