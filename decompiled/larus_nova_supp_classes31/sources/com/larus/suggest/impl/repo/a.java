package com.larus.suggest.impl.repo;

import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.f;
import com.larus.network.http.y;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import ic8.k0;
import ic8.s;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final a a = null;

    /* JADX INFO: renamed from: com.larus.suggest.impl.repo.a$a, reason: collision with other inner class name */
    public static final class C0035a {
        public final long a;
        public final String b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof C0035a) == true) goto L8;
            return false;
        L8:
            C0035a r9 = (C0035a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.b;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r1 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public final String toString() {
            return "ErrorInfo(code=" + this.a + ", msg=" + this.b + ')';
        }

        public C0035a(long r1, String r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    static {
        a = new a();
    }

    public a() {
    }

    public final Object a(String r23, String r24, int r25, String r26, k0 r27, String r28, boolean r29, Continuation r30) {
        if ((r30 instanceof NexPulseRepo$getNexPulse$1) == false) goto L7;
        NexPulseRepo$getNexPulse$1 r2 = (NexPulseRepo$getNexPulse$1) r30;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        NexPulseRepo$getNexPulse$1 r15 = r2;
        Object r0 = r15.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r15.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
        Object r5 = null;
    L31:
        y r1 = (com.larus.network.http.a) r0;
        if ((r1 instanceof y) == false) goto L47;
        y r6 = r1;
        Long r7 = r6.g;
        if (r7 != null) goto L37;
    L40:
        FLogger.a.e(r12, "failed in get next pulse code=" + r6.g + " msg=" + r6.f);
        Long r8 = r6.g;
        if (r8 == null) goto L43;
        long r9 = r8.longValue();
    L45:
        return TuplesKt.to(r5, new C0035a(r9, r6.f));
    L43:
        r9 = -1;
        goto L45
    L37:
        if (r7.longValue() != 0) goto L40;
        NexPulseResponseData r10 = (NexPulseResponseData) ((com.larus.network.http.a) r6).b;
        FLogger.a.i("WcbNexPulseRepo", "success in get next pulse " + r10);
        return TuplesKt.to(r10, r5);
    L47:
        if ((r1 instanceof f) == false) goto L51;
        FLogger.a.e(r12, "failed get next pulse " + r1);
        f r11 = (f) r1;
        return TuplesKt.to(r5, new C0035a(r11.d.getCode(), r11.d.getMessage()));
    L51:
        return TuplesKt.to(r5, r5);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        FLogger.a.i("WcbNexPulseRepo", "getNexPulse botId=" + r23 + " cvsId=" + r24 + " scene=" + r25 + " params=" + r27 + " token=" + r26 + " isFirst=false reqSrc=" + r28 + " skipCache=" + r29);
        LinkedHashMap r12 = new LinkedHashMap();
        if (z2.a.z3().a() == false) goto L17;
        r12.put("resource-slot", "slot_api");
    L17:
        NexPulseApi.a r13 = NexPulseApi.a;
        s r16 = new s(r23, r24, Boxing.boxInt(r25), r27, r29, r26, false);
        r15.label = 1;
        r13.getClass();
        FlowDowngradeServiceDelegate r17 = FlowDowngradeServiceDelegate.INSTANCE;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L20
        Object r19 = Result.constructor-impl(new JSONObject(HttpExtKt.f.toJson(r16)));     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r19) == false) goto L25;
        r19 = null;
    L25:
        JSONObject r20 = (JSONObject) r19;
        if (r20 != null) goto L28;
        r20 = new JSONObject();
    L28:
        r5 = null;
        r0 = IFlowDowngradeService.a.b(r17, "Message", NexPulseResponseData.class, "/biz/onboarding/get_nexpulse", r20, r12, false, null, MapsKt.mapOf(TuplesKt.to("source", r28)), r15, 976);
        if (r0 != r14) goto L31;
        return r14;
    L20:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new NexPulseRepo$getNexPulse$1(this, r30);
        goto L8
    }
}
