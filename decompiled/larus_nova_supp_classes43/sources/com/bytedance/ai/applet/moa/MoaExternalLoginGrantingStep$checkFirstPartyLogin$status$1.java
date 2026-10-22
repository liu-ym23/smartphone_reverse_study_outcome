package com.bytedance.ai.applet.moa;

import com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/applet/douyinAuth/DouyinGeneralAuthStatusResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaExternalLoginGrantingStep$checkFirstPartyLogin$status$1", f = "MoaExternalLoginGrantingStep.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
public final class MoaExternalLoginGrantingStep$checkFirstPartyLogin$status$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.bytedance.ai.applet.douyinAuth.e>, Object> {
    final /* synthetic */ String $clientKey;
    final /* synthetic */ String $scopes;
    int label;

    public MoaExternalLoginGrantingStep$checkFirstPartyLogin$status$1(String r1, String r10, Continuation<? super MoaExternalLoginGrantingStep$checkFirstPartyLogin$status$1> r11) {
        this.$clientKey = r1;
        this.$scopes = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MoaExternalLoginGrantingStep$checkFirstPartyLogin$status$1(this.$clientKey, this.$scopes, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.bytedance.ai.applet.douyinAuth.e> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
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
        DouyinGeneralAuthHelper r11 = DouyinGeneralAuthHelper.a;
        String r12 = this.$clientKey;
        String r13 = this.$scopes;
        this.label = 1;
        r11.getClass();
        r10 = DouyinGeneralAuthHelper.a(r12, r13, "chat", this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
