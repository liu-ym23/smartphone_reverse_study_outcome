package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import android.net.Uri;
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
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.BotBgImageGenerateViewModel$initData$3$1", f = "Img2BgImageViewModel.kt", i = {}, l = {247}, m = "invokeSuspend", n = {}, s = {})
public final class BotBgImageGenerateViewModel$initData$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $it;
    int label;
    final /* synthetic */ BotBgImageGenerateViewModel this$0;

    public BotBgImageGenerateViewModel$initData$3$1(BotBgImageGenerateViewModel r1, String r2, Continuation<? super BotBgImageGenerateViewModel$initData$3$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BotBgImageGenerateViewModel$initData$3$1(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        Uri r5 = (Uri) r4;
        if (r5 == null) goto L15;
        BotBgImageGenerateViewModel r2 = this.this$0;
        BotBgImageGenerateViewModel.access$sendUIEvent(r2, new c.e(r5));
        BotBgImageGenerateViewModel.refreshUIState$default(r2, 2, null, 2, null);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        BotBgImageGenerateViewModel r6 = this.this$0;
        String r3 = this.$it;
        this.label = 1;
        r4 = BotBgImageGenerateViewModel.access$getLocalUriFromUrl(r6, r3, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
