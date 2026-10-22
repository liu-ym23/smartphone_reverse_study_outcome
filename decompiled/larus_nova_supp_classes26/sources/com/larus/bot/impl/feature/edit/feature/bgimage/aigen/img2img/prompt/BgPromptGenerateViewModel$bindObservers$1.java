package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt;

import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/network/http/Async;", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/bot/bean/ImageUploadResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.BgPromptGenerateViewModel$bindObservers$1", f = "BgPromptGenerateViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BgPromptGenerateViewModel$bindObservers$1 extends SuspendLambda implements Function2<com.larus.network.http.a<? extends BizResponse<ImageUploadResult>>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BgPromptGenerateViewModel this$0;

    public BgPromptGenerateViewModel$bindObservers$1(BgPromptGenerateViewModel r1, Continuation<? super BgPromptGenerateViewModel$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BgPromptGenerateViewModel$bindObservers$1 r0 = new BgPromptGenerateViewModel$bindObservers$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.larus.network.http.a<BizResponse<ImageUploadResult>> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larus.network.http.a) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r4);
        y r5 = (com.larus.network.http.a) this.L$0;
        if ((r5 instanceof com.larus.network.http.f) == false) goto L8;
        FLogger.a.e("BgPromptGenerateViewModel", "upload image failed");
        BgPromptGenerateViewModel r6 = this.this$0;
        int r0 = BgPromptGenerateViewModel.q;
        r6.g(null);
    L16:
        return Unit.INSTANCE;
    L8:
        if ((r5 instanceof y) == false) goto L16;
        BizResponse r7 = (BizResponse) ((com.larus.network.http.a) r5).b;
        if (r7 == null) goto L14;
        ImageUploadResult r8 = (ImageUploadResult) r7.getData();
        if (r8 == null) goto L14;
        BgPromptGenerateViewModel r1 = this.this$0;
        r1.m = r8;
        r1.g(r8);
    L14:
        BgPromptGenerateViewModel r9 = this.this$0;
        int r2 = BgPromptGenerateViewModel.q;
        r9.g(null);
        goto L16
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
