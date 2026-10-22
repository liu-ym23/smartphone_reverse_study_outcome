package com.larus.search.impl.global;

import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.audio.realtimecall.IRealtimeCallStrategy;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.platform.model.SearchMobParam;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.global.GlobalSearchFragment$eventHelper$1$directToRealtimeCall$1", f = "GlobalSearchFragment.kt", i = {0}, l = {368}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u241"}, s = {"L$2"})
final class GlobalSearchFragment$eventHelper$1$directToRealtimeCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $argPosition;
    final /* synthetic */ String $clickEnterFrom;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ RecommendBot $data;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ GlobalSearchFragment this$0;

    public GlobalSearchFragment$eventHelper$1$directToRealtimeCall$1(GlobalSearchFragment r1, String r2, String r3, RecommendBot r4, String r5, Continuation<? super GlobalSearchFragment$eventHelper$1$directToRealtimeCall$1> r6) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$clickEnterFrom = r3;
        this.$data = r4;
        this.$argPosition = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new GlobalSearchFragment$eventHelper$1$directToRealtimeCall$1(this.this$0, this.$conversationId, this.$clickEnterFrom, this.$data, this.$argPosition, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        com.bytedance.router.i r2 = (com.bytedance.router.i) this.L$4;
        Bundle r3 = (Bundle) this.L$3;
        Bundle r4 = (Bundle) this.L$2;
        GlobalSearchFragment r5 = (GlobalSearchFragment) this.L$1;
        Bundle r6 = (Bundle) this.L$0;
        ResultKt.throwOnFailure(r7);
    L16:
        r3.putAll((Bundle) r7);
        by7.h.k(r4, r5);
        r2.c.putExtras(r6);
        r2.d = 2130772401;
        r2.e = 2130772399;
        r2.d();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        com.bytedance.router.i r8 = SmartRouter.buildRoute(this.this$0.getContext(), "//flow/realtime_chat_gate");
        Pair[] r9 = new Pair[10];
        r9[0] = TuplesKt.to("argConversationId", this.$conversationId);
        r9[1] = TuplesKt.to("argClickEnterFrom", this.$clickEnterFrom);
        r9[2] = TuplesKt.to("argBotRecommendFrom", this.$data.a);
        r9[3] = TuplesKt.to("argPreviousPage", this.this$0.k());
        r9[4] = TuplesKt.to("enter_method", "click_chat");
        r9[5] = TuplesKt.to("enter_from", this.this$0.k());
        r9[6] = TuplesKt.to("argBotPosition", this.$argPosition);
        SearchMobParam r10 = this.$data.b;
        if (r10 == null) goto L11;
        GlobalSearchFragment r11 = this.this$0;
        r10.a = r11.h;
        r10.b = r11.i;
        Unit r12 = Unit.INSTANCE;
    L12:
        r9[7] = TuplesKt.to("argSearchMobParam", r10);
        r9[8] = TuplesKt.to("recommend_bot_mob_segment", this.$data.I0(""));
        r9[9] = TuplesKt.to("is_call_bot", "1");
        r3 = com.larus.utils.f.c(r9);
        String r13 = this.$conversationId;
        GlobalSearchFragment r14 = this.this$0;
        IRealtimeCallStrategy.RealtimeCallStrategyDelegate r15 = IRealtimeCallStrategy.a;
        this.L$0 = r3;
        this.L$1 = r14;
        this.L$2 = r3;
        this.L$3 = r3;
        this.L$4 = r8;
        this.label = 1;
        Object r16 = r15.b(r13, this);
        if (r16 != r0) goto L15;
        return r0;
    L15:
        r2 = r8;
        r7 = r16;
        r5 = r14;
        r4 = r3;
        r6 = r4;
        goto L16
    L11:
        r10 = null;
        goto L12
    }
}
