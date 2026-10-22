package com.bytedance.ai.bridge.method.phoneNum;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumFlow$getPhoneNumberFlow$phoneCode$2", f = "GetPhoneNumFlow.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
final class GetPhoneNumFlow$getPhoneNumberFlow$phoneCode$2 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ String $appletId;
    int label;
    final /* synthetic */ GetPhoneNumFlow this$0;

    public GetPhoneNumFlow$getPhoneNumberFlow$phoneCode$2(GetPhoneNumFlow r1, String r10, Continuation<? super GetPhoneNumFlow$getPhoneNumberFlow$phoneCode$2> r11) {
        this.this$0 = r1;
        this.$appletId = r10;
        super(1, r11);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new GetPhoneNumFlow$getPhoneNumberFlow$phoneCode$2(this.this$0, this.$appletId, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super String> r10) {
        return create(r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        GetPhoneNumFlow r11 = this.this$0;
        String r12 = this.$appletId;
        this.label = 1;
        int r13 = GetPhoneNumFlow.b;
        r11.getClass();
        r10 = GetPhoneNumFlow.d(r12, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
