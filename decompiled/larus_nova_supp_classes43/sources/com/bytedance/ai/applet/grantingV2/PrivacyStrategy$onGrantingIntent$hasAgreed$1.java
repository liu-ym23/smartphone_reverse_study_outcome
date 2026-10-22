package com.bytedance.ai.applet.grantingV2;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.grantingV2.PrivacyStrategy$onGrantingIntent$hasAgreed$1", f = "PrivacyStrategy.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
public final class PrivacyStrategy$onGrantingIntent$hasAgreed$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ u2.c $meta;
    int label;
    final /* synthetic */ PrivacyStrategy this$0;

    public PrivacyStrategy$onGrantingIntent$hasAgreed$1(PrivacyStrategy r1, u2.c r10, Continuation<? super PrivacyStrategy$onGrantingIntent$hasAgreed$1> r11) {
        this.this$0 = r1;
        this.$meta = r10;
        super(1, r11);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new PrivacyStrategy$onGrantingIntent$hasAgreed$1(this.this$0, this.$meta, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Boolean> r10) {
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
        PrivacyStrategy r11 = this.this$0;
        u2.c r12 = this.$meta;
        String r13 = r12.a;
        String r14 = r12.d;
        this.label = 1;
        int r15 = PrivacyStrategy.d;
        r10 = r11.k(r13, r14, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
