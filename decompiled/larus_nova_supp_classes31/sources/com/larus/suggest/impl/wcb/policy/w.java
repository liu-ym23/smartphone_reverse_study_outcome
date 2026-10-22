package com.larus.suggest.impl.wcb.policy;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.chat.bean.NexPulseConf;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w implements y {
    public final Function1<com.larus.suggest.impl.wcb.request.f, String> a;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(Function1<? super com.larus.suggest.impl.wcb.request.f, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "cacheScope");
        this.a = r2;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final String b(com.larus.suggest.impl.wcb.request.f r2) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        return n(r2).d;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long c(com.larus.suggest.impl.wcb.request.f r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        return n(r3).e;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long e(com.larus.suggest.impl.wcb.request.f r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        return n(r3).g;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long f(com.larus.suggest.impl.wcb.request.f r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        return n(r3).a;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long g(com.larus.suggest.impl.wcb.request.f r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        return n(r3).f;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long i(com.larus.suggest.impl.wcb.request.f r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        return System.currentTimeMillis() - n(r5).c;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final String j(com.larus.suggest.impl.wcb.request.f r2) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        return (String) this.a.invoke(r2);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final v k(com.larus.suggest.impl.wcb.request.f r23) {
        Intrinsics.checkNotNullParameter(r23, "snapshot");
        String r3 = (String) this.a.invoke(r23);
        com.larus.suggest.impl.repo.e r0 = com.larus.suggest.impl.repo.e.a;
        int r4 = r23.f.a.getScene();
        String r5 = r23.a;
        r0.getClass();
        com.larus.suggest.impl.repo.d r6 = com.larus.suggest.impl.repo.e.b(r3, r4, r5);
        String r7 = ", conv_id=";
        if (r6 != null) goto L6;
        FLogger.a.i("WcbLog", "[LocalCache] cache miss: no state, executionId=" + r23.e + ", conv_id=" + r23.b + ", cache_scope=" + r3 + ", scene=" + r23.f.a.getScene());
        return v.b.a;
    L6:
        long r9 = AppHost.a.getAppClock().currentTimeMillis() / 1000;
        long r11 = r6.a;
        if (1 <= r11) goto L9;
    L11:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L17;
        com.larus.suggest.impl.repo.e.a(r3, r23.f.a.getScene(), r23.a);
        FLogger.a.i("WcbLog", "[LocalCache] cache miss: expired response cleared, executionId=" + r23.e + ", conv_id=" + r23.b + ", cache_scope=" + r3 + ", scene=" + r23.f.a.getScene() + ", expireTimeSec=" + x.a(Long.valueOf(r6.a), r9) + ", nowSec=" + r9 + ", retainedLastRequestTimeMs=" + r6.c + ", retainedFreqReqIntervalSec=" + r6.e);
        return v.b.a;
    L17:
        if (r11 > 0) goto L20;
        FLogger.a.i("WcbLog", "[LocalCache] cache miss: no valid expiry, executionId=" + r23.e + ", conv_id=" + r23.b + ", cache_scope=" + r3 + ", scene=" + r23.f.a.getScene() + ", expireTimeSec=" + x.a(Long.valueOf(r6.a), r9));
        return v.b.a;
    L20:
        int r12 = r23.f.a.getScene();
        String r2 = r23.a;
        long r13 = r6.b;
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r2, "userId");
        if (r13 > 0) goto L23;
        String r16 = ", cache_scope=";
        NexPulseResponseData r14 = null;
    L25:
        r7 = ", conv_id=";
        NexPulseResponseData r15 = r14;
    L45:
        if (r15 == null) goto L50;
        if (r15.isValid() != true) goto L50;
        boolean r8 = true;
    L52:
        if (r8 == false) goto L55;
        FLogger.a.i("WcbLog", "[LocalCache] cache hit, executionId=" + r23.e + ", expireTimeSec=" + x.a(Long.valueOf(r6.a), r9) + r7 + r23.b + r16 + r3 + ", scene=" + r23.f.a.getScene() + ", responseVersion=" + r6.b + ", nowSec=" + r9);
        return new v.a(r15);
    L55:
        com.larus.suggest.impl.repo.e r10 = com.larus.suggest.impl.repo.e.a;
        int r17 = r23.f.a.getScene();
        String r18 = r23.a;
        r10.getClass();
        com.larus.suggest.impl.repo.e.a(r3, r17, r18);
        FLogger r19 = FLogger.a;
        StringBuilder r20 = new StringBuilder("[LocalCache] cache miss: missing or invalid response cleared, executionId=");
        r20.append(r23.e);
        r20.append(r7);
        r20.append(r23.b);
        r20.append(r16);
        r20.append(r3);
        r20.append(", scene=");
        r20.append(r23.f.a.getScene());
        r20.append(", responsePresent=");
        if (r15 == null) goto L58;
        boolean r110 = true;
    L59:
        r20.append(r110);
        r20.append(", responseVersion=");
        r20.append(r6.b);
        r20.append(", retainedLastRequestTimeMs=");
        r20.append(r6.c);
        r20.append(", retainedFreqReqIntervalSec=");
        r20.append(r6.e);
        r19.i("WcbLog", r20.toString());
        return v.b.a;
    L58:
        r110 = false;
    L50:
        r8 = false;
        goto L52
    L23:
        com.larus.suggest.impl.repo.c r111 = com.larus.suggest.impl.repo.e.b;
        String r112 = com.larus.suggest.impl.repo.e.c(r3, r12);
        r111.getClass();
        r16 = ", cache_scope=";
        Intrinsics.checkNotNullParameter(r112, "key");
        Intrinsics.checkNotNullParameter(r2, "userId");
        r14 = null;
        String r21 = ((Keva) com.larus.suggest.impl.repo.c.b.getValue()).getString(com.larus.suggest.impl.repo.c.b(r112, r2), null);
        if (r21 == null) goto L25;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L28
        Object r24 = Result.constructor-impl((com.larus.suggest.impl.repo.e.a) HttpExtKt.f.fromJson(r21, com.larus.suggest.impl.repo.e.a.class));     // Catch: Throwable -> L28
    L30:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L35;
        FLogger.a.e("WcbLog", "[keva] invalid policy response, conversationId=" + r3 + ", scene=" + r12, r25);
    L35:
        if (Result.isFailure-impl(r24) == false) goto L37;
        r24 = null;
    L37:
        com.larus.suggest.impl.repo.e.a r26 = (com.larus.suggest.impl.repo.e.a) r24;
        if (r26 != null) goto L41;
    L43:
        r15 = null;
        goto L45
    L41:
        if (r26.a == r13) goto L44;
        FLogger.a.w("WcbLog", "[keva] policy response version mismatch, conversationId=" + r3 + ", scene=" + r12 + ", expected=" + r13 + ", actual=" + r26.a);
        goto L43
    L44:
        r15 = r26.b;
    L28:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L9:
        if (r11 > r9) goto L11;
        r1 = true;
        goto L13
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final boolean l(com.larus.suggest.impl.wcb.request.f r2) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        return false;
    }

    public final com.larus.suggest.impl.repo.d n(com.larus.suggest.impl.wcb.request.f r4) {
        com.larus.suggest.impl.repo.e r0 = com.larus.suggest.impl.repo.e.a;
        String r1 = (String) this.a.invoke(r4);
        int r2 = r4.f.a.getScene();
        String r5 = r4.a;
        r0.getClass();
        com.larus.suggest.impl.repo.d r6 = com.larus.suggest.impl.repo.e.b(r1, r2, r5);
        if (r6 == null) goto L5;
        return r6;
    L5:
        return new com.larus.suggest.impl.repo.d(0);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void d(com.larus.suggest.impl.wcb.request.f r30, NexPulseConf r31) {
        Intrinsics.checkNotNullParameter(r30, "snapshot");
        String r3 = (String) this.a.invoke(r30);
        com.larus.suggest.impl.repo.e r4 = com.larus.suggest.impl.repo.e.a;
        int r5 = r30.f.a.getScene();
        String r6 = r30.a;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r6, "userId");
        FLogger r7 = FLogger.a;
        r7.i("WcbLog", "[keva] updateNexPulseConf conversationId=" + r3 + ", scene=" + r5 + ", conf=" + r31);
        com.larus.suggest.impl.repo.d r8 = com.larus.suggest.impl.repo.e.b(r3, r5, r6);
        boolean r10 = false;
        if (r8 != null) goto L5;
        r8 = new com.larus.suggest.impl.repo.d(0);
    L5:
        com.larus.suggest.impl.repo.d r11 = r8;
        if (r31 == null) goto L11;
        String r9 = r31.getThroughToken();
        if (r9 == null) goto L11;
        String r12 = p0.a(r9);
        if (r12 == null) goto L11;
    L12:
        String r18 = r12;
        if (r31 == null) goto L17;
        Long r13 = r31.getFreqReqInterval();
        if (r13 == null) goto L17;
        long r23 = RangesKt.coerceAtLeast(r13.longValue(), 0);
    L18:
        if (r31 == null) goto L22;
        Long r14 = r31.getFreqControlInterval();
        if (r14 == null) goto L22;
        long r25 = RangesKt.coerceAtLeast(r14.longValue(), 0);
    L23:
        com.larus.suggest.impl.repo.e.e(r3, r5, com.larus.suggest.impl.repo.d.a(r11, 0, 0, 0, r18, r23, r25, 0, 71), r6);
        StringBuilder r15 = new StringBuilder("[LocalCache] record network response conf, executionId=");
        r15.append(r30.e);
        r15.append(", conv_id=");
        r15.append(r30.b);
        r15.append(", cache_scope=");
        r15.append(r3);
        r15.append(", scene=");
        r15.append(r30.f.a.getScene());
        r15.append(", confPresent=");
        if (r31 == null) goto L26;
        r10 = true;
    L26:
        r15.append(r10);
        r15.append(", freqReqIntervalSec=");
        if (r31 == null) goto L31;
        Long r0 = r31.getFreqReqInterval();
        if (r0 == null) goto L31;
        long r16 = 0;
        long r17 = RangesKt.coerceAtLeast(r0.longValue(), 0);
    L32:
        r15.append(r17);
        r15.append(", freqControlIntervalSec=");
        if (r31 == null) goto L37;
        Long r1 = r31.getFreqControlInterval();
        if (r1 == null) goto L37;
        long r19 = RangesKt.coerceAtLeast(r1.longValue(), r16);
    L38:
        r15.append(r19);
        r7.i("WcbLog", r15.toString());
        return;
    L37:
        r19 = r16;
    L31:
        r16 = 0;
        r17 = 0;
    L22:
        r25 = 0;
    L17:
        r23 = 0;
    L11:
        r12 = r11.d;
        goto L12
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void m(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "conversationId");
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void a(com.larus.suggest.impl.wcb.request.f r29, NexPulseResponseData r30, long r31) {
        Intrinsics.checkNotNullParameter(r29, "snapshot");
        Intrinsics.checkNotNullParameter(r30, "response");
        String r13 = (String) this.a.invoke(r29);
        com.larus.suggest.impl.repo.e r3 = com.larus.suggest.impl.repo.e.a;
        int r10 = r29.f.a.getScene();
        String r11 = r29.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r13, "conversationId");
        Intrinsics.checkNotNullParameter(r30, "response");
        Intrinsics.checkNotNullParameter(r11, "userId");
        com.larus.suggest.impl.repo.d r4 = com.larus.suggest.impl.repo.e.b(r13, r10, r11);
        if (r4 != null) goto L5;
        r4 = new com.larus.suggest.impl.repo.d(0);
    L5:
        long r5 = Math.max(r4.b + 1, r31);
        com.larus.suggest.impl.repo.c r6 = com.larus.suggest.impl.repo.e.b;
        String r7 = com.larus.suggest.impl.repo.e.c(r13, r10);
        String r8 = GsonProtectorUtils.toJson(HttpExtKt.f, new com.larus.suggest.impl.repo.e.a(r5, r30));
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "key");
        Intrinsics.checkNotNullParameter(r8, "value");
        Intrinsics.checkNotNullParameter(r11, "userId");
        ((Keva) com.larus.suggest.impl.repo.c.b.getValue()).storeString(com.larus.suggest.impl.repo.c.b(r7, r11), r8);
        NexPulseConf r2 = r30.getConf();
        long r17 = 0;
        if (r2 == null) goto L10;
        Long r9 = r2.getExpireTime();
        if (r9 == null) goto L10;
        long r12 = r9.longValue();
    L11:
        com.larus.suggest.impl.repo.e.e(r13, r10, com.larus.suggest.impl.repo.d.a(r4, r12, r5, 0, null, 0, 0, r31, 60), r11);
        long r14 = AppHost.a.getAppClock().currentTimeMillis() / 1000;
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("[LocalCache] persist accepted response, executionId=");
        r16.append(r29.e);
        r16.append(", conv_id=");
        r16.append(r29.b);
        r16.append(", cache_scope=");
        r16.append(r13);
        r16.append(", scene=");
        r16.append(r29.f.a.getScene());
        r16.append(", expireTimeSec=");
        NexPulseConf r0 = r30.getConf();
        if (r0 == null) goto L16;
        Long r1 = r0.getExpireTime();
        if (r1 == null) goto L16;
        r17 = r1.longValue();
    L16:
        r16.append(x.a(Long.valueOf(r17), r14));
        r16.append(", updateTimeMs=");
        r16.append(r31);
        r15.i("WcbLog", r16.toString());
        return;
    L10:
        r12 = 0;
        goto L11
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void h(com.larus.suggest.impl.wcb.request.f r23, long r24, long r26) {
        Intrinsics.checkNotNullParameter(r23, "snapshot");
        String r2 = (String) this.a.invoke(r23);
        com.larus.suggest.impl.repo.e r3 = com.larus.suggest.impl.repo.e.a;
        int r4 = r23.f.a.getScene();
        String r5 = r23.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "userId");
        com.larus.suggest.impl.repo.d r6 = com.larus.suggest.impl.repo.e.b(r2, r4, r5);
        if (r6 != null) goto L5;
        r6 = new com.larus.suggest.impl.repo.d(0);
    L5:
        com.larus.suggest.impl.repo.e.e(r2, r4, com.larus.suggest.impl.repo.d.a(r6, 0, 0, r26, null, 0, 0, 0, 123), r5);
        FLogger.a.i("WcbLog", "[LocalCache] record request start, executionId=" + r23.e + ", conv_id=" + r23.b + ", cache_scope=" + r2 + ", scene=" + r23.f.a.getScene() + ", requestTimeMs=" + r26);
    }
}
