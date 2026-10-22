package com.larus.bmhome.auth;

import com.bytedance.keva.Keva;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class u0 implements Runnable {
    public final /* synthetic */ LaunchInfo a;
    public final /* synthetic */ e b;
    public final /* synthetic */ Pair c;

    public /* synthetic */ u0(LaunchInfo r1, e r2, Pair r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LaunchInfo r0 = this.a;
        e r1 = this.b;
        Pair r2 = this.c;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L61
        if (r0 != null) goto L6;
        String r4 = "";
    L7:
        if (r0 == null) goto L11;
        if (r1 == null) goto L11;
        String r5 = z0.o(r1, z0.a(r0));     // Catch: Throwable -> L61
    L12:
        Object r6 = z0.f;     // Catch: Throwable -> L61
        monitor-enter(r6);     // Catch: Throwable -> L61
        boolean r9 = false;
        if (z0.h.get() != ((Number) r2.getFirst()).longValue()) goto L17;
        boolean r7 = true;
    L19:
        if (z0.i.get() != ((Number) r2.getSecond()).longValue()) goto L21;
        boolean r8 = true;
    L22:
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L58
        if (r4.length() != 0) goto L25;
        boolean r10 = true;
    L26:
        if (r10 == false) goto L28;
    L50:
        if (r7 == false) goto L52;
        Keva r11 = z0.b;     // Catch: Throwable -> L58
        r11.erase("launch_cache_launch_info");     // Catch: Throwable -> L58
        r11.erase("launch_cache_conversation_info");     // Catch: Throwable -> L58
    L55:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L58
        monitor-exit(r6);     // Catch: Throwable -> L61
    L57:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L61
        return;
    L52:
        if (r8 == false) goto L54;
        z0.b.erase("launch_cache_conversation_info");     // Catch: Throwable -> L58
        goto L55
    L54:
        FLogger.a.i("LaunchCache", "drop stale aggregate launch cache clear before persistence");     // Catch: Throwable -> L58
        goto L55
    L28:
        if (r5.length() != 0) goto L30;
        boolean r13 = true;
    L31:
        if (r13 == true) goto L50;
        if (r0 != null) goto L36;
        monitor-exit(r6);     // Catch: Throwable -> L61
        goto L57
    L36:
        g0 r14 = z0.a(r0);     // Catch: Throwable -> L58
        if (r8 == true) goto L39;
    L41:
        if (r9 == false) goto L43;
        z0.b.storeString("launch_cache_conversation_info", r5);     // Catch: Throwable -> L58
    L45:
        if (r7 == false) goto L47;
        z0.b.storeString("launch_cache_launch_info", r4);     // Catch: Throwable -> L58
        Keva r15 = l0.a;     // Catch: Throwable -> L58
        l0.a(r0, AccountService.a.getSecUserId());     // Catch: Throwable -> L58
    L47:
        if (r7 == true) goto L55;
        if (r8 == true) goto L55;
        FLogger.a.i("LaunchCache", "drop stale aggregate launch cache before persistence");     // Catch: Throwable -> L58
        goto L55
    L43:
        if (r7 == false) goto L45;
        z0.b.erase("launch_cache_conversation_info");     // Catch: Throwable -> L58
        goto L45
    L39:
        if (z0.k(r14) == false) goto L41;
        r9 = true;
        goto L41
    L30:
        r13 = false;
        goto L31
    L25:
        r10 = false;
        goto L26
    L21:
        r8 = false;
        goto L22
    L17:
        r7 = false;
    L58:
        th = move-exception;
        throw th;     // Catch: Throwable -> L61
    L11:
        r5 = "";
        goto L12
    L6:
        r4 = z0.a.toJson(r0);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
