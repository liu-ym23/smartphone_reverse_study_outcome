package com.bytedance.ai.miniappevent;

import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.miniappevent.AIMiniAppEventCenter$enqueue$1", f = "AIMiniAppEventCenter.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
public final class AIMiniAppEventCenter$enqueue$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $rawValue;
    int label;

    public AIMiniAppEventCenter$enqueue$1(String r1, Continuation<? super AIMiniAppEventCenter$enqueue$1> r10) {
        this.$rawValue = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIMiniAppEventCenter$enqueue$1(this.$rawValue, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
    L38:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        AIMiniAppEventCenter r1 = AIMiniAppEventCenter.a;
        String r11 = this.$rawValue;
        r1.getClass();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L17
        JsonElement r13 = GsonProtectorUtils.parse(new JsonParser(), r11);     // Catch: Throwable -> L17
        if (r13.isJsonObject() == false) goto L24;
        JsonObject r14 = r13.getAsJsonObject();     // Catch: Throwable -> L17
        JsonElement r15 = r14.get("event");     // Catch: Throwable -> L17
        if (r15 == null) goto L22;
        if (r15.isJsonObject() == false) goto L20;
        JsonObject r16 = r15.getAsJsonObject();     // Catch: Throwable -> L17
        Object r17 = Result.constructor-impl(new AIMiniAppEventCenter.c(AIMiniAppEventCenter.f(r14), AIMiniAppEventCenter.h(r14, "event_type"), AIMiniAppEventCenter.h(r14, "event_id"), AIMiniAppEventCenter.h(r14, "msg_id"), AIMiniAppEventCenter.h(r14, "app_key"), AIMiniAppEventCenter.g(r14, "timestamp"), AIMiniAppEventCenter.g(r14, "expire_at"), new AIMiniAppEventCenter.a(AIMiniAppEventCenter.h(r16, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME), AIMiniAppEventCenter.h(r16, "payload_json")), AIMiniAppEventCenter.h(r14, com.bytedance.android.ec.core.event.a.KEY_LOG_ID)));     // Catch: Throwable -> L17
    L27:
        if (Result.exceptionOrNull-impl(r17) == null) goto L30;
        g.a.w("AIMiniAppEventCenter", "reject event, stage=parse, reason=invalid_notify");
        r17 = null;
    L30:
        AIMiniAppEventCenter.c r18 = (AIMiniAppEventCenter.c) r17;
        if (r18 == null) goto L33;
        AIMiniAppEventCenter r20 = AIMiniAppEventCenter.a;
        AIMiniAppEventCenter.b r21 = new AIMiniAppEventCenter.b("server_cmd", null, false);
        this.label = 1;
        if (AIMiniAppEventCenter.a(r20, r18, r21, this) != r10) goto L38;
        return r10;
    L33:
        return Unit.INSTANCE;
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L17
    L22:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L17
    L24:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }
}
