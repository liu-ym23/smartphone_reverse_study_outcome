package com.ss.android.lark.conditional.access.nopermission.interception;

import com.google.gson.Gson;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.e0;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final b a = null;
    public static volatile Job b;
    public static volatile String c;

    public b() {
    }

    static {
        a = new b();
        c = BuildConfig.FLAVOR;
    }

    public static void a() {
        String r0 = BuildConfig.FLAVOR;
        Job r1 = b;
        if (r1 != null) goto L5;
    L81:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        String r3 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();     // Catch: Throwable -> L13
        if (r3 != null) goto L11;
        r3 = BuildConfig.FLAVOR;
    L11:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r4) == false) goto L18;
        r4 = BuildConfig.FLAVOR;
    L18:
        String r5 = (String) r4;
        boolean r6 = true;
        if (r5.length() != 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L25;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "start: no foreground user, skip");
        return;
    L25:
        a.a.getClass();
        String r8 = a.b().getString("no_permission_type", null);
        if (r8 != null) goto L28;
        r8 = BuildConfig.FLAVOR;
    L28:
        String r9 = a.b().getString("action_json", null);
        if (r9 == null) goto L33;
        r0 = r9;
    L33:
        if (r8.length() != 0) goto L35;
        boolean r10 = true;
    L37:
        if (r10 == false) goto L39;
    L71:
        c r11 = null;
    L72:
        if (r11 != null) goto L75;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "start: no persisted interception, skip");
        return;
    L75:
        c = r5;
        int r12 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "start: probe begin, userId=" + r5 + ", traceId=" + r11.b.getTraceId());
        b = BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.a, Dispatchers.getIO(), null, new InterceptionRestoreProber$start$1(r11, null), 2, null);
        return;
    L39:
        if (r0.length() == 0) goto L42;
        r6 = false;
    L42:
        if (r6 == true) goto L71;
        Object r13 = Result.constructor-impl(NoPermissionType.valueOf(r8));     // Catch: Throwable -> L46
    L49:
        if (Result.exceptionOrNull-impl(r13) == null) goto L52;
        int r14 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_InterceptionPersistStore", "load: unknown NoPermissionType=" + r8 + ", clear corrupted entry");
        a.a.getClass();
        a.a();
    L52:
        if (Result.isFailure-impl(r13) == false) goto L54;
        r13 = null;
    L54:
        NoPermissionType r15 = (NoPermissionType) r13;
        if (r15 == null) goto L71;
        Gson r16 = e0.a;     // Catch: Throwable -> L59
        Object r17 = Result.constructor-impl((InternalSecurityAction) e0.a(r0, InternalSecurityAction.class));     // Catch: Throwable -> L59
    L61:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L65;
        int r19 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_InterceptionPersistStore", "load: decode failed, clear corrupted entry, " + r18);
        a.a.getClass();
        a.a();
    L65:
        if (Result.isFailure-impl(r17) == false) goto L67;
        r17 = null;
    L67:
        InternalSecurityAction r20 = (InternalSecurityAction) r17;
        if (r20 == null) goto L71;
        int r21 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_InterceptionPersistStore", "load interception, type=" + r15.name() + ", traceId=" + r20.getTraceId());
        r11 = new c(r15, r20);
    L59:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L46:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L35:
        r10 = false;
        goto L37
    L21:
        r7 = false;
    L13:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L5:
        if (r1.isActive() == false) goto L81;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "start: probe already running, skip");
    }
}
