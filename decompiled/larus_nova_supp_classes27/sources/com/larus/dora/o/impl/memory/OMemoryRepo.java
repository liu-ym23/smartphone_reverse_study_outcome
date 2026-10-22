package com.larus.dora.o.impl.memory;

import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.ranges.LongRange;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class OMemoryRepo {
    public static final OMemoryRepo a = null;
    public static final LongRange b = null;

    public OMemoryRepo() {
    }

    static {
        a = new OMemoryRepo();
        b = new LongRange(1, 3);
    }

    public static JSONObject b() {
        JSONObject r0 = new JSONObject();
        r0.put("dora_sub_biz", FlowDoraSubBizType.G1_G2.getValue());
        return r0;
    }

    public final Object f(Continuation<? super p0> r10) {
        if ((r10 instanceof OMemoryRepo$fetchProfileList$1) == false) goto L7;
        OMemoryRepo$fetchProfileList$1 r0 = (OMemoryRepo$fetchProfileList$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        OMemoryRepo$fetchProfileList$1 r6 = r0;
        Object r11 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L28
    L19:
        com.larus.network.http.y r12 = (com.larus.network.http.a) r11;     // Catch: Throwable -> L28
        if ((r12 instanceof com.larus.network.http.y) == false) goto L22;
        com.larus.network.http.y r13 = r12;     // Catch: Throwable -> L28
    L23:
        if (r13 == null) goto L25;
        p0 r14 = (p0) ((com.larus.network.http.a) r13).b;     // Catch: Throwable -> L28
    L26:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L28
    L30:
        Throwable r4 = Result.exceptionOrNull-impl(r15);
        if (r4 == null) goto L34;
        FLogger.a.e("OMemoryRepo", "fetchProfileList failed", r4);
    L34:
        if (Result.isFailure-impl(r15) == false) goto L37;
        return null;
    L37:
        return r15;
    L25:
        r14 = null;
        goto L26
    L22:
        r13 = null;
        goto L23
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L28
        com.larus.dora.api.network.a r5 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L28
        JSONObject r7 = b();     // Catch: Throwable -> L28
        r6.label = 1;     // Catch: Throwable -> L28
        r11 = com.larus.dora.api.network.a.c(r5, p0.class, "/alice/wearable/diary/get_user_profile_list", r7, null, r6, 248);     // Catch: Throwable -> L28
        if (r11 != r2) goto L19;
        return r2;
    L28:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new OMemoryRepo$fetchProfileList$1(this, r10);
        goto L8
    }

    public final Object c(String r9, Continuation<? super Boolean> r10) {
        if ((r10 instanceof OMemoryRepo$deleteEvent$1) == false) goto L7;
        OMemoryRepo$deleteEvent$1 r0 = (OMemoryRepo$deleteEvent$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        OMemoryRepo$deleteEvent$1 r6 = r0;
        Object r11 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L21
    L19:
        Object r12 = Result.constructor-impl(Boxing.boxBoolean(r11 instanceof com.larus.network.http.y));     // Catch: Throwable -> L21
    L23:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L26;
        FLogger.a.e("OMemoryRepo", "deleteEvent failed", r13);
    L26:
        Boolean r14 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r12) == true) goto L29;
        return r12;
    L29:
        return r14;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        JSONObject r4 = b();
        r4.put("event_ids", new JSONArray().put(r9));
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L21
        com.larus.dora.api.network.a r5 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L21
        r6.label = 1;     // Catch: Throwable -> L21
        r11 = com.larus.dora.api.network.a.c(r5, Object.class, "/alice/wearable/event/delete_user_event", r4, null, r6, 248);     // Catch: Throwable -> L21
        if (r11 != r2) goto L19;
        return r2;
    L21:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new OMemoryRepo$deleteEvent$1(this, r10);
        goto L8
    }

    public final Object d(long r10, Continuation<? super p0> r12) {
        if ((r12 instanceof OMemoryRepo$deleteProfile$1) == false) goto L7;
        OMemoryRepo$deleteProfile$1 r0 = (OMemoryRepo$deleteProfile$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        OMemoryRepo$deleteProfile$1 r6 = r0;
        Object r13 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L28
    L19:
        com.larus.network.http.y r14 = (com.larus.network.http.a) r13;     // Catch: Throwable -> L28
        if ((r14 instanceof com.larus.network.http.y) == false) goto L22;
        com.larus.network.http.y r15 = r14;     // Catch: Throwable -> L28
    L23:
        if (r15 == null) goto L25;
        p0 r11 = (p0) ((com.larus.network.http.a) r15).b;     // Catch: Throwable -> L28
    L26:
        Object r16 = Result.constructor-impl(r11);     // Catch: Throwable -> L28
    L30:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L34;
        FLogger.a.e("OMemoryRepo", "deleteProfile failed", r17);
    L34:
        if (Result.isFailure-impl(r16) == false) goto L37;
        return null;
    L37:
        return r16;
    L25:
        r11 = null;
        goto L26
    L22:
        r15 = null;
        goto L23
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r13);
        JSONObject r4 = b();
        r4.put("entry_id", r10);
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L28
        com.larus.dora.api.network.a r5 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L28
        r6.label = 1;     // Catch: Throwable -> L28
        r13 = com.larus.dora.api.network.a.c(r5, p0.class, "/alice/wearable/diary/delete_user_profile", r4, null, r6, 248);     // Catch: Throwable -> L28
        if (r13 != r2) goto L19;
        return r2;
    L28:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new OMemoryRepo$deleteProfile$1(this, r12);
        goto L8
    }

    public final Object e(String r10, Continuation<? super a0> r11) {
        if ((r11 instanceof OMemoryRepo$fetchEventList$1) == false) goto L7;
        OMemoryRepo$fetchEventList$1 r0 = (OMemoryRepo$fetchEventList$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        OMemoryRepo$fetchEventList$1 r6 = r0;
        Object r12 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L28
    L19:
        com.larus.network.http.y r13 = (com.larus.network.http.a) r12;     // Catch: Throwable -> L28
        if ((r13 instanceof com.larus.network.http.y) == false) goto L22;
        com.larus.network.http.y r14 = r13;     // Catch: Throwable -> L28
    L23:
        if (r14 == null) goto L25;
        a0 r15 = (a0) ((com.larus.network.http.a) r14).b;     // Catch: Throwable -> L28
    L26:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L28
    L30:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L34;
        FLogger.a.e("OMemoryRepo", "fetchEventList failed", r17);
    L34:
        if (Result.isFailure-impl(r16) == false) goto L37;
        return null;
    L37:
        return r16;
    L25:
        r15 = null;
        goto L26
    L22:
        r14 = null;
        goto L23
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r12);
        JSONObject r4 = b();
        r4.put("size", 20);
        r4.put("cursor", r10);
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L28
        com.larus.dora.api.network.a r5 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L28
        r6.label = 1;     // Catch: Throwable -> L28
        r12 = com.larus.dora.api.network.a.c(r5, a0.class, "/alice/wearable/event/list_user_event", r4, null, r6, 248);     // Catch: Throwable -> L28
        if (r12 != r2) goto L19;
        return r2;
    L28:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new OMemoryRepo$fetchEventList$1(this, r11);
        goto L8
    }

    public final Object g(long r11, String r13, Continuation<? super q0> r14) {
        if ((r14 instanceof OMemoryRepo$updateProfile$1) == false) goto L7;
        OMemoryRepo$updateProfile$1 r0 = (OMemoryRepo$updateProfile$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        OMemoryRepo$updateProfile$1 r6 = r0;
        Object r15 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        boolean r8 = true;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L38
    L19:
        com.larus.network.http.y r16 = (com.larus.network.http.a) r15;     // Catch: Throwable -> L38
        if ((r16 instanceof com.larus.network.http.y) == false) goto L23;
        q0 r12 = new q0((p0) ((com.larus.network.http.a) r16).b, Boxing.boxLong(0));     // Catch: Throwable -> L38
    L36:
        Object r17 = Result.constructor-impl(r12);     // Catch: Throwable -> L38
    L40:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L44;
        FLogger.a.e("OMemoryRepo", "updateProfile failed", r18);
    L44:
        if (Result.isFailure-impl(r17) == false) goto L47;
        return null;
    L47:
        return r17;
    L23:
        if ((r16 instanceof com.larus.network.http.f) == false) goto L35;
        Long r110 = Boxing.boxLong(((com.larus.network.http.f) r16).d.getCode());     // Catch: Throwable -> L38
        long r111 = r110.longValue();     // Catch: Throwable -> L38
        LongRange r112 = b;     // Catch: Throwable -> L38
        long r4 = r112.getFirst();     // Catch: Throwable -> L38
        if (r111 <= r112.getLast()) goto L27;
    L29:
        r8 = false;
    L30:
        if (r8 == true) goto L33;
        r110 = null;
    L33:
        if (r110 == null) goto L35;
        r12 = new q0(null, Boxing.boxLong(r110.longValue()));     // Catch: Throwable -> L38
        goto L36
    L27:
        if (r4 > r111) goto L29;
    L35:
        r12 = null;
        goto L36
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r15);
        JSONObject r5 = b();
        r5.put("entry_id", r11);
        r5.put("content", r13);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L38
        com.larus.dora.api.network.a r7 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L38
        r6.label = 1;     // Catch: Throwable -> L38
        r15 = com.larus.dora.api.network.a.c(r7, p0.class, "/alice/wearable/diary/update_user_profile", r5, null, r6, 248);     // Catch: Throwable -> L38
        if (r15 != r2) goto L19;
        return r2;
    L38:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new OMemoryRepo$updateProfile$1(this, r14);
        goto L8
    }

    public final Object a(String r11, long r12, String r14, Continuation<? super q0> r15) {
        if ((r15 instanceof OMemoryRepo$addProfile$1) == false) goto L7;
        OMemoryRepo$addProfile$1 r0 = (OMemoryRepo$addProfile$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        OMemoryRepo$addProfile$1 r6 = r0;
        Object r16 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        boolean r8 = true;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L38
    L19:
        com.larus.network.http.y r17 = (com.larus.network.http.a) r16;     // Catch: Throwable -> L38
        if ((r17 instanceof com.larus.network.http.y) == false) goto L23;
        q0 r13 = new q0((p0) ((com.larus.network.http.a) r17).b, Boxing.boxLong(0));     // Catch: Throwable -> L38
    L36:
        Object r18 = Result.constructor-impl(r13);     // Catch: Throwable -> L38
    L40:
        Throwable r110 = Result.exceptionOrNull-impl(r18);
        if (r110 == null) goto L44;
        FLogger.a.e("OMemoryRepo", "addProfile failed", r110);
    L44:
        if (Result.isFailure-impl(r18) == false) goto L47;
        return null;
    L47:
        return r18;
    L23:
        if ((r17 instanceof com.larus.network.http.f) == false) goto L35;
        Long r111 = Boxing.boxLong(((com.larus.network.http.f) r17).d.getCode());     // Catch: Throwable -> L38
        long r112 = r111.longValue();     // Catch: Throwable -> L38
        LongRange r113 = b;     // Catch: Throwable -> L38
        long r4 = r113.getFirst();     // Catch: Throwable -> L38
        if (r112 <= r113.getLast()) goto L27;
    L29:
        r8 = false;
    L30:
        if (r8 == true) goto L33;
        r111 = null;
    L33:
        if (r111 == null) goto L35;
        r13 = new q0(null, Boxing.boxLong(r111.longValue()));     // Catch: Throwable -> L38
        goto L36
    L27:
        if (r4 > r112) goto L29;
    L35:
        r13 = null;
        goto L36
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
        JSONObject r5 = b();
        r5.put("content", r11);
        r5.put("client_req_id", r14);
        r5.put("max_entries", r12);
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L38
        com.larus.dora.api.network.a r7 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L38
        r6.label = 1;     // Catch: Throwable -> L38
        r16 = com.larus.dora.api.network.a.c(r7, p0.class, "/alice/wearable/diary/add_user_profile", r5, null, r6, 248);     // Catch: Throwable -> L38
        if (r16 != r2) goto L19;
        return r2;
    L38:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new OMemoryRepo$addProfile$1(this, r15);
        goto L8
    }
}
