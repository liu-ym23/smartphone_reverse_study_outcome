package com.obric.aikernel.runtime.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.q1;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5415a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g1<Boolean> f5416b = null;

    static {
        f5415a = new b();
        f5416b = q1.a(Boolean.FALSE);
    }

    private b() {
    }

    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        r10.registerReceiver(this, new IntentFilter("android.os.action.DEVICE_IDLE_MODE_CHANGED"));
        Object r11 = r10.getSystemService("power");
        if ((r11 instanceof PowerManager) == false) goto L5;
        PowerManager r12 = (PowerManager) r11;
    L6:
        g1<Boolean> r13 = f5416b;
        if (r12 == null) goto L9;
        boolean r14 = r12.isDeviceIdleMode();
    L10:
        r13.c(Boolean.valueOf(r14));
        return;
    L9:
        r14 = false;
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    public final boolean b() {
        return f5416b.getValue().booleanValue();
    }

    public final Object c(Continuation<? super Boolean> r10) {
        return kotlinx.coroutines.flow.e.p(kotlinx.coroutines.flow.e.l(f5416b, 1), r10);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        PowerManager r12 = null;
        if (r11 == null) goto L5;
        String r13 = r11.getAction();
    L7:
        if (Intrinsics.areEqual("android.os.action.DEVICE_IDLE_MODE_CHANGED", r13) == false) goto L19;
        if (r10 == null) goto L10;
        Object r14 = r10.getSystemService("power");
    L12:
        if ((r14 instanceof PowerManager) == false) goto L14;
        r12 = (PowerManager) r14;
    L14:
        if (r12 == null) goto L16;
        boolean r15 = r12.isDeviceIdleMode();
    L17:
        f5416b.c(Boolean.valueOf(r15));
        return;
    L16:
        r15 = false;
        goto L17
    L10:
        r14 = null;
        goto L12
    L19:
        return;
    L5:
        r13 = null;
        goto L7
    }
}
