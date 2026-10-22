package com.larus.profile.impl;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.AddCreationResponse;
import com.larus.profile.api.IProfileApi;
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
@DebugMetadata(c = "com.larus.profile.impl.ProfileRepo$createUserCreation$2", f = "ProfileRepo.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
final class ProfileRepo$createUserCreation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super zp9.a>, Object> {
    final /* synthetic */ fs9.f $content;
    final /* synthetic */ Integer $privateStatus;
    final /* synthetic */ int $source;
    int label;

    public ProfileRepo$createUserCreation$2(Integer r1, int r2, fs9.f r3, Continuation<? super ProfileRepo$createUserCreation$2> r4) {
        this.$privateStatus = r1;
        this.$source = r2;
        this.$content = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ProfileRepo$createUserCreation$2(this.$privateStatus, this.$source, this.$content, r5);
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
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
        Object r1 = r20;
    L16:
        com.larus.network.http.y r2 = (com.larus.network.http.a) r1;
        Object r3 = null;
        if ((r2 instanceof com.larus.network.http.y) == false) goto L28;
        Integer r4 = this.$privateStatus;
        if (r4 != null) goto L22;
    L24:
        AddCreationResponse r5 = (AddCreationResponse) ((com.larus.network.http.a) r2).b;
        if (r5 == null) goto L27;
        r3 = r5.b;
    L27:
        zp9.a r6 = new zp9.a(true, r3, null, null, 12);
    L47:
        return r6;
    L22:
        if (r4.intValue() != 1) goto L24;
        IProfileApi.a.h().postValue(Boxing.boxBoolean(true));
        goto L24
    L28:
        boolean r7 = r2 instanceof com.larus.network.http.f;
        if (r7 == false) goto L31;
        com.larus.network.http.f r8 = (com.larus.network.http.f) r2;
    L32:
        if (r8 == null) goto L37;
        AsyncThrowable r9 = r8.d;
        if (r9 == null) goto L37;
        String r10 = Boxing.boxLong(r9.getCode()).toString();
        if (r10 == null) goto L37;
    L38:
        String r16 = r10;
        if (r7 == false) goto L41;
        com.larus.network.http.f r11 = (com.larus.network.http.f) r2;
    L42:
        if (r11 == null) goto L46;
        AsyncThrowable r12 = r11.d;
        if (r12 == null) goto L46;
        r3 = r12.getMessage();
    L46:
        r6 = new zp9.a(false, null, r16, r3, 2);
        goto L47
    L41:
        r11 = null;
    L37:
        r10 = "";
        goto L38
    L31:
        r8 = null;
        goto L32
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        JSONObject r14 = new JSONObject();
        int r15 = this.$source;
        fs9.f r17 = this.$content;
        Integer r18 = this.$privateStatus;
        r14.put("source", r15);
        if (r17 == null) goto L11;
        r14.put("content", new JSONObject(GsonProtectorUtils.toJson(new Gson(), r17)));
    L11:
        if (r18 == null) goto L13;
        r14.put("private_status", r18.intValue());
    L13:
        Unit r19 = Unit.INSTANCE;
        this.label = 1;
        r1 = HttpExtKt.k("Social", AddCreationResponse.class, "/alice/profile/creation/create", r14, null, null, false, null, null, null, this, 1008);
        if (r1 != r13) goto L16;
        return r13;
    }
}
