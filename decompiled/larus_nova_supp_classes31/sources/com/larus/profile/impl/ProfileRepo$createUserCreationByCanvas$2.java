package com.larus.profile.impl;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.AddCreationResponse;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/platform/api/creation/AddCreationResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.ProfileRepo$createUserCreationByCanvas$2", f = "ProfileRepo.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {})
final class ProfileRepo$createUserCreationByCanvas$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super zp9.a>, Object> {
    final /* synthetic */ Long $canvasId;
    final /* synthetic */ Long $canvasSubId;
    final /* synthetic */ Integer $privateStatus;
    final /* synthetic */ String $taskId;
    int label;

    public ProfileRepo$createUserCreationByCanvas$2(Long r1, Long r2, String r3, Integer r4, Continuation<? super ProfileRepo$createUserCreationByCanvas$2> r5) {
        this.$canvasId = r1;
        this.$canvasSubId = r2;
        this.$taskId = r3;
        this.$privateStatus = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ProfileRepo$createUserCreationByCanvas$2(this.$canvasId, this.$canvasSubId, this.$taskId, this.$privateStatus, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super zp9.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object r20) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        Object r14 = null;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
        Object r1 = r20;
    L25:
        com.larus.network.http.y r2 = (com.larus.network.http.a) r1;
        if ((r2 instanceof com.larus.network.http.y) == false) goto L31;
        AddCreationResponse r3 = (AddCreationResponse) ((com.larus.network.http.a) r2).b;
        if (r3 == null) goto L30;
        r14 = r3.b;
    L30:
        zp9.a r4 = new zp9.a(true, r14, null, null, 12);
    L51:
        return r4;
    L31:
        boolean r5 = r2 instanceof com.larus.network.http.f;
        if (r5 == false) goto L34;
        com.larus.network.http.f r6 = (com.larus.network.http.f) r2;
    L35:
        if (r6 == null) goto L42;
        AsyncThrowable r7 = r6.d;
        if (r7 == null) goto L42;
        String r8 = Boxing.boxLong(r7.getCode()).toString();
        if (r8 == null) goto L42;
        String r16 = r8;
    L43:
        if (r5 == false) goto L45;
        com.larus.network.http.f r9 = (com.larus.network.http.f) r2;
    L46:
        if (r9 == null) goto L50;
        AsyncThrowable r10 = r9.d;
        if (r10 == null) goto L50;
        r14 = r10.getMessage();
    L50:
        r4 = new zp9.a(false, null, r16, r14, 2);
        goto L51
    L45:
        r9 = null;
    L42:
        r16 = "";
        goto L43
    L34:
        r6 = null;
        goto L35
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        JSONObject r11 = new JSONObject();
        Long r12 = this.$canvasId;
        Long r15 = this.$canvasSubId;
        String r17 = this.$taskId;
        Integer r18 = this.$privateStatus;
        r11.put("source", 5);
        if (r12 == null) goto L12;
        String r19 = r12.toString();
        if (r19 == null) goto L12;
    L13:
        if (r15 == null) goto L16;
        String r21 = r15.toString();
        if (r21 == null) goto L16;
    L17:
        if (r17 != null) goto L19;
        r17 = "";
    L19:
        r11.put("content", new JSONObject(GsonProtectorUtils.toJson(new Gson(), new fs9.f(null, null, new fs9.c(r19, r21, r17), 3))));
        if (r18 == null) goto L22;
        r11.put("private_status", r18.intValue());
    L22:
        Unit r22 = Unit.INSTANCE;
        this.label = 1;
        r1 = HttpExtKt.k("Social", AddCreationResponse.class, "/alice/profile/creation/create", r11, null, null, false, null, null, null, this, 1008);
        if (r1 != r13) goto L25;
        return r13;
    L16:
        r21 = "";
    L12:
        r19 = "";
        goto L13
    }
}
