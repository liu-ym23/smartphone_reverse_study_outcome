package com.larus.dora.impl.util;

import android.app.Application;
import android.os.Build;
import android.os.PowerManager;
import com.bytedance.dora.device.DoraDevice;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.common.apphost.AppHost;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e implements g49.e.a {
    public final Lazy a;
    public final Lazy b;

    @Override // g49.e.a
    public final boolean a() {
        IFlowCompanionDeviceManager r0 = (IFlowCompanionDeviceManager) this.a.getValue();
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        DoraDevice r2 = (DoraDevice) this.b.getValue();
        if (r2 != null) goto L8;
        return false;
    L8:
        String r3 = r2.mac;
        String r4 = r2.sn;
        if (r3 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L71;
        if (r4 != null) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r6 == false) goto L71;
        return false;
    L18:
        if (r4.length() == 0) goto L21;
        r6 = false;
    L71:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L64
        if (r3 != null) goto L27;
    L30:
        boolean r8 = true;
    L31:
        if (r8 == false) goto L33;
    L35:
        boolean r9 = false;
    L36:
        if (r4 != null) goto L38;
    L41:
        boolean r10 = true;
    L42:
        if (r10 == false) goto L44;
    L46:
        boolean r11 = false;
    L47:
        if (r3 != null) goto L49;
    L52:
        boolean r12 = true;
    L53:
        if (r12 == false) goto L55;
    L57:
        boolean r13 = false;
    L58:
        if (r9 == true) goto L60;
        if (r11 == true) goto L60;
    L62:
        Object r14 = Result.constructor-impl(Boolean.valueOf(r1));     // Catch: Throwable -> L64
    L66:
        Boolean r15 = Boolean.FALSE;
        if (Result.isFailure-impl(r14) == false) goto L70;
        r14 = r15;
    L70:
        return ((Boolean) r14).booleanValue();
    L60:
        if (r13 == false) goto L62;
        r1 = true;
        goto L62
    L55:
        if (r0.m(r3) == false) goto L57;
        r13 = true;
        goto L58
    L49:
        if (r3.length() == 0) goto L52;
        r12 = false;
        goto L53
    L44:
        if (r0.c(r4) == false) goto L46;
        r11 = true;
        goto L47
    L38:
        if (r4.length() == 0) goto L41;
        r10 = false;
        goto L42
    L33:
        if (r0.b(r3) == false) goto L35;
        r9 = true;
        goto L36
    L27:
        if (r3.length() == 0) goto L30;
        r8 = false;
    L64:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L66
    L11:
        if (r3.length() == 0) goto L14;
        r5 = false;
        goto L15
    }

    @Override // g49.e.a
    public final boolean b() {
        boolean r2 = false;
        if (Build.VERSION.SDK_INT < 23) goto L28;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L18
        Application r1 = AppHost.a.getApplication();     // Catch: Throwable -> L18
        if (r1 == null) goto L27;
        Object r3 = r1.getSystemService("power");     // Catch: Throwable -> L18
        if ((r3 instanceof PowerManager) == false) goto L11;
        PowerManager r4 = (PowerManager) r3;     // Catch: Throwable -> L18
    L12:
        if (r4 != null) goto L14;
    L16:
        Object r5 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L18
    L20:
        Boolean r6 = Boolean.FALSE;
        if (Result.isFailure-impl(r5) == false) goto L24;
        r5 = r6;
    L24:
        return ((Boolean) r5).booleanValue();
    L14:
        if (r4.isIgnoringBatteryOptimizations(r1.getPackageName()) != true) goto L16;
        r2 = true;
        goto L16
    L11:
        r4 = null;
        goto L12
    L27:
        return false;
    L18:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L28:
        return false;
    }

    @Override // g49.e.a
    public final boolean c() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        b0.a.getClass();     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(b0.j().getBoolean("dora_enable_ongoing_notification", true)));     // Catch: Throwable -> L4
    L6:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = r2;
    L10:
        return ((Boolean) r1).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public e() {
        this.a = LazyKt.lazy(new c());
        this.b = LazyKt.lazy(new d());
    }
}
