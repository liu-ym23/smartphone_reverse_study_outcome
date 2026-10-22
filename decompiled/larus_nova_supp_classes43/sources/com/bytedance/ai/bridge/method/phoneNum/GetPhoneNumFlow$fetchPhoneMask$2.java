package com.bytedance.ai.bridge.method.phoneNum;

import com.bytedance.ai.bridge.remote.UserAuthService;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumFlow$fetchPhoneMask$2", f = "GetPhoneNumFlow.kt", i = {}, l = {209}, m = "invokeSuspend", n = {}, s = {})
final class GetPhoneNumFlow$fetchPhoneMask$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $versionTag;
    int label;

    public GetPhoneNumFlow$fetchPhoneMask$2(String r1, Continuation<? super GetPhoneNumFlow$fetchPhoneMask$2> r10) {
        this.$versionTag = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new GetPhoneNumFlow$fetchPhoneMask$2(this.$versionTag, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r10) {
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
        String r13 = (String) r12;
        if (r13 != null) goto L21;
        Throwable r14 = Result.exceptionOrNull-impl(r11);
        if (r14 == null) goto L20;
        throw r14;
    L20:
        throw new GetPhoneNumFlow.GetPhoneNumException("phoneMask is null, but no error message", -2);
    L21:
        return r13;
    L14:
        r12 = r11;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        UserAuthService r15 = UserAuthService.a;
        String r16 = this.$versionTag;
        this.label = 1;
        r11 = r15.n(r16, this);
        if (r11 != r0) goto L12;
        return r0;
    }
}
