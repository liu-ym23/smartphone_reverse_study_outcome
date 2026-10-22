package com.bytedance.ai.applet.douyinAuth;

import com.bytedance.ai.applet.app.AppletApplication;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/applet/douyinAuth/DouyinGeneralAuthPrepareResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper$requestDouyinGeneralAuth$prepareResult$1", f = "DouyinGeneralAuthHelper.kt", i = {}, l = {285}, m = "invokeSuspend", n = {}, s = {})
public final class DouyinGeneralAuthHelper$requestDouyinGeneralAuth$prepareResult$1 extends SuspendLambda implements Function1<Continuation<? super c>, Object> {
    final /* synthetic */ AppletApplication $app;
    int label;

    public DouyinGeneralAuthHelper$requestDouyinGeneralAuth$prepareResult$1(AppletApplication r1, Continuation<? super DouyinGeneralAuthHelper$requestDouyinGeneralAuth$prepareResult$1> r10) {
        this.$app = r1;
        super(1, r10);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new DouyinGeneralAuthHelper$requestDouyinGeneralAuth$prepareResult$1(this.$app, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super c> r10) {
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
        DouyinGeneralAuthHelper r11 = DouyinGeneralAuthHelper.a;
        String r12 = this.$app.getAppId();
        this.label = 1;
        r10 = r11.b(r12, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
