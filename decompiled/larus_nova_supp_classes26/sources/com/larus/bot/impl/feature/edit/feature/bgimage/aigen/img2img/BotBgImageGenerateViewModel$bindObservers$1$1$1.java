package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import android.net.Uri;
import com.larus.bot.impl.common.propertyconfig.TextRes;
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
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.BotBgImageGenerateViewModel$bindObservers$1$1$1", f = "Img2BgImageViewModel.kt", i = {0}, l = {175}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
public final class BotBgImageGenerateViewModel$bindObservers$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $it;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BotBgImageGenerateViewModel this$0;

    public BotBgImageGenerateViewModel$bindObservers$1$1$1(BotBgImageGenerateViewModel r1, String r2, Continuation<? super BotBgImageGenerateViewModel$bindObservers$1$1$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        BotBgImageGenerateViewModel$bindObservers$1$1$1 r0 = new BotBgImageGenerateViewModel$bindObservers$1$1$1(this.this$0, this.$it, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r6);
    L11:
        Uri r7 = (Uri) r6;
        if (r7 == null) goto L14;
        BotBgImageGenerateViewModel r3 = this.this$0;
        BotBgImageGenerateViewModel.access$sendUIEvent(r3, new c.e(r7));
        BotBgImageGenerateViewModel.refreshUIState$default(r3, 2, null, 2, null);
    L16:
        return Unit.INSTANCE;
    L14:
        BotBgImageGenerateViewModel r8 = this.this$0;
        BotBgImageGenerateViewModel.access$sendUIEvent(r8, new c.h(new TextRes.StringResId(2131908918)));
        BotBgImageGenerateViewModel.refreshUIState$default(r8, 0, null, 2, null);
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        BotBgImageGenerateViewModel r4 = this.this$0;
        String r5 = this.$it;
        this.L$0 = r9;
        this.label = 1;
        r6 = BotBgImageGenerateViewModel.access$getLocalUriFromUrl(r4, r5, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
