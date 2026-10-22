package com.larus.bmhome.miniartifact.product.network;

import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.miniartifact.product.network.PreloadMiniArtifactShareHelper$preloadShareMessage$1", f = "PreloadMiniArtifactShareHelper.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
final class PreloadMiniArtifactShareHelper$preloadShareMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $request;
    int label;
    final /* synthetic */ PreloadMiniArtifactShareHelper this$0;

    public PreloadMiniArtifactShareHelper$preloadShareMessage$1(PreloadMiniArtifactShareHelper r1, b r2, Continuation<? super PreloadMiniArtifactShareHelper$preloadShareMessage$1> r3) {
        this.this$0 = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PreloadMiniArtifactShareHelper$preloadShareMessage$1(this.this$0, this.$request, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        BizResponse<a> r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        dm9.a.b r14 = (dm9.a) r13;
        if ((r14 instanceof dm9.a.b) == false) goto L18;
        PreloadMiniArtifactShareHelper r2 = this.this$0;
        dm9.a.b r15 = r14;
        if (r15.a.isSuccess() == false) goto L16;
        r3 = r15.a;
    L16:
        r2.a = r3;
    L21:
        return Unit.INSTANCE;
    L18:
        if ((r14 instanceof dm9.a.a) == false) goto L21;
        this.this$0.a = null;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        MiniArtifactShareApi.a r16 = MiniArtifactShareApi.a;
        PreloadMiniArtifactShareHelper$preloadShareMessage$1$result$1 r6 = new PreloadMiniArtifactShareHelper$preloadShareMessage$1$result$1(this.$request, null);
        this.label = 1;
        r16.getClass();
        FlowHttpConnection r17 = FlowHttpConnection.a;
        r13 = FlowHttpConnection.i("Social", MiniArtifactShareApi.class, r6, null, null, "https://activity.doubao.com", this, 112);
        if (r13 != r0) goto L11;
        return r0;
    }
}
