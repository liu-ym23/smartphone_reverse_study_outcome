package com.larus.bot.impl.feature.edit.feature.bgimage;

import kotlin.Metadata;
import kotlin.Pair;
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
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.BotBgImageEditViewModel$onClickImageArea$1", f = "BotBgImageEditViewModel.kt", i = {}, l = {361}, m = "invokeSuspend", n = {}, s = {})
final class BotBgImageEditViewModel$onClickImageArea$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ Pair<String, String> $nameAndDesc;
    int label;
    final /* synthetic */ BotBgImageEditViewModel this$0;

    public BotBgImageEditViewModel$onClickImageArea$1(BotBgImageEditViewModel r1, Pair<String, String> r2, String r3, Continuation<? super BotBgImageEditViewModel$onClickImageArea$1> r4) {
        this.this$0 = r1;
        this.$nameAndDesc = r2;
        this.$enterMethod = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotBgImageEditViewModel$onClickImageArea$1(this.this$0, this.$nameAndDesc, this.$enterMethod, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        if (((Boolean) r11).booleanValue() == true) goto L15;
        this.this$0.v(new b.f(true, null, null, (String) this.$nameAndDesc.getFirst(), (String) this.$nameAndDesc.getSecond(), this.this$0.a().getUserBotGenderStarlingKey(), this.this$0.a().getUserBotTypeStarlingKey(), this.$enterMethod));
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        BotBgImageEditViewModel r12 = this.this$0;
        String r2 = (String) this.$nameAndDesc.getFirst();
        String r3 = (String) this.$nameAndDesc.getSecond();
        this.label = 1;
        r11 = BotBgImageEditViewModel.q(r12, r2, r3, this);
        if (r11 != r0) goto L12;
        return r0;
    }
}
