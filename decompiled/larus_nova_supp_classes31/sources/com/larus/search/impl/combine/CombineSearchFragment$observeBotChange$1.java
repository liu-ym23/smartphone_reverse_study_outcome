package com.larus.search.impl.combine;

import com.larus.bmhome.chat.bean.RecommendBot;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchFragment$observeBotChange$1", f = "CombineSearchFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CombineSearchFragment$observeBotChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendBot $bot;
    int label;
    final /* synthetic */ CombineSearchFragment this$0;

    public CombineSearchFragment$observeBotChange$1(CombineSearchFragment r1, RecommendBot r2, Continuation<? super CombineSearchFragment$observeBotChange$1> r3) {
        this.this$0 = r1;
        this.$bot = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CombineSearchFragment$observeBotChange$1(this.this$0, this.$bot, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r5);
        CombineSearchFragment r6 = this.this$0;
        int r0 = CombineSearchFragment.G;
        com.larus.im.service.o r7 = (com.larus.im.service.o) r6.D.getValue();
        String r1 = this.$bot.o();
        String r2 = "";
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        CombineSearchFragment$botUpdateListener$1 r3 = this.this$0.F;
        String r4 = this.$bot.o();
        if (r4 == null) goto L11;
        r2 = r4;
    L11:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r3.a = r2;
        Unit r8 = Unit.INSTANCE;
        r7.registerBotChangeListener(r1, r3);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
