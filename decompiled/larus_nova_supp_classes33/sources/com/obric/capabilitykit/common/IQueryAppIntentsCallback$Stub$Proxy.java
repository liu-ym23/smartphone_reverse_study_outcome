package com.obric.capabilitykit.common;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class IQueryAppIntentsCallback$Stub$Proxy implements IQueryAppIntentsCallback {
    public static IQueryAppIntentsCallback sDefaultImpl;
    private IBinder mRemote;

    public IQueryAppIntentsCallback$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "com.obric.capabilitykit.common.IQueryAppIntentsCallback";
    }

    public void onResult(List<AppIntentImplInfo> r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.capabilitykit.common.IQueryAppIntentsCallback");     // Catch: Throwable -> L12
        r0.writeTypedList(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_capabilitykit_common_IQueryAppIntentsCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L12
    L8:
        r1.recycle();
        r0.recycle();
        return;
    L6:
        if (IQueryAppIntentsCallback.Stub.getDefaultImpl() == null) goto L10;
        IQueryAppIntentsCallback.Stub.getDefaultImpl().onResult(r6);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_capabilitykit_common_IQueryAppIntentsCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
