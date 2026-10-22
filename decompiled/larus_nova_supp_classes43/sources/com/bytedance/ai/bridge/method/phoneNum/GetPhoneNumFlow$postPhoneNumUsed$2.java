package com.bytedance.ai.bridge.method.phoneNum;

import com.bytedance.ai.applet.granting.GrantStatus;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.utils.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumFlow$postPhoneNumUsed$2", f = "GetPhoneNumFlow.kt", i = {}, l = {258}, m = "invokeSuspend", n = {}, s = {})
final class GetPhoneNumFlow$postPhoneNumUsed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    int label;

    public GetPhoneNumFlow$postPhoneNumUsed$2(String r1, Continuation<? super GetPhoneNumFlow$postPhoneNumUsed$2> r10) {
        this.$appletId = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new GetPhoneNumFlow$postPhoneNumUsed$2(this.$appletId, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L12:
        if (Result.isFailure-impl(r11) == false) goto L14;
        Object r12 = null;
    L15:
        Boolean r13 = (Boolean) r12;
        if (r13 == null) goto L19;
        boolean r14 = r13.booleanValue();
        g.a.i("GetPhoneNumMethod", "postPhoneNumUsed: " + r14);
        return Unit.INSTANCE;
    L19:
        Throwable r15 = Result.exceptionOrNull-impl(r11);
        if (r15 == null) goto L22;
        throw r15;
    L22:
        throw new Exception("Permission detail is null");
    L14:
        r12 = r11;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        UserAuthService r16 = UserAuthService.a;
        String r17 = this.$appletId;
        Integer r18 = Boxing.boxInt(u2.g.a(GrantStatus.GRANTED));
        this.label = 1;
        r11 = UserAuthService.r(r17, "scope.user_connected_mobile", r18, this);
        if (r11 != r0) goto L12;
        return r0;
    }
}
