package com.larus.canvas.feature.component.logic;

import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImageInitComponent$handleInitialAIBeautify$1$2$1$1$2", f = "GenImageInitComponent.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {})
final class GenImageInitComponent$handleInitialAIBeautify$1$2$1$1$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ OptionItem $optionItem;
    final /* synthetic */ InstructionTab $toolsTab;
    int label;
    final /* synthetic */ GenImageInitComponent this$0;

    public GenImageInitComponent$handleInitialAIBeautify$1$2$1$1$2(GenImageInitComponent r1, InstructionTab r2, OptionItem r3, Continuation<? super GenImageInitComponent$handleInitialAIBeautify$1$2$1$1$2> r4) {
        this.this$0 = r1;
        this.$toolsTab = r2;
        this.$optionItem = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new GenImageInitComponent$handleInitialAIBeautify$1$2$1$1$2(this.this$0, this.$toolsTab, this.$optionItem, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        GenImageInitComponent r5 = this.this$0;
        Lazy<hq9.s0> r2 = GenImageInitComponent.w;
        n2 r6 = r5.m3();
        if (r6 == null) goto L15;
        n2.a.a(r6, this.$toolsTab, this.$optionItem, false);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L11;
        return r0;
    }
}
