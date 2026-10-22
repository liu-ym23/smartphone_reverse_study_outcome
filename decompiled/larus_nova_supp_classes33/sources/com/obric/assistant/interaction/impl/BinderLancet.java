package com.obric.assistant.interaction.impl;

import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class BinderLancet {
    public BinderLancet() {
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public boolean transact(int r17, Parcel r18, Parcel r19, int r20) throws RemoteException {
        String r2 = "";
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        Object r3 = This.get();
        long r4 = SystemClock.uptimeMillis();
        boolean r0 = ((Boolean) Origin.call()).booleanValue();     // Catch: Throwable -> L15
        long r10 = SystemClock.uptimeMillis() - r4;
        if (r10 < 100) goto L14;
        if (r3 == null) goto L13;
        r2 = r3.getClass().getName();
    L13:
        BinderPerformanceReporter.report(r10, r2, r17, r20, new Throwable("Slow main-thread Binder transaction"));
    L14:
        return r0;
    L15:
        th = move-exception;
        long r11 = SystemClock.uptimeMillis() - r4;
        if (r11 < 100) goto L22;
        if (r3 == null) goto L21;
        r2 = r3.getClass().getName();
    L21:
        BinderPerformanceReporter.report(r11, r2, r17, r20, new Throwable("Slow main-thread Binder transaction"));
    L22:
        throw th;
    L5:
        return ((Boolean) Origin.call()).booleanValue();
    }
}
