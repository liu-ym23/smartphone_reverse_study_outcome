package com.larus.search.impl.combine;

import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.utils.a4;
import com.larus.search.impl.common.ConversationRepoManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchFragment$EventHelper$onBotAdd$1", f = "CombineSearchFragment.kt", i = {}, l = {1026}, m = "invokeSuspend", n = {}, s = {})
public final class CombineSearchFragment$EventHelper$onBotAdd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendBot $data;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ CombineSearchFragment this$0;
    final /* synthetic */ CombineSearchFragment.EventHelper this$1;

    /* JADX INFO: renamed from: com.larus.search.impl.combine.CombineSearchFragment$EventHelper$onBotAdd$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchFragment$EventHelper$onBotAdd$1$1", f = "CombineSearchFragment.kt", i = {}, l = {1025}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RecommendBot $data;
        int label;

        public AnonymousClass1(RecommendBot r1, Continuation<? super AnonymousClass1> r2) {
            this.$data = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$data, r3);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ConversationRepoManager r5 = ConversationRepoManager.a;
            RecommendBot r6 = this.$data;
            this.label = 1;
            if (ConversationRepoManager.a(r6, this) != r0) goto L12;
            return r0;
        }
    }

    public CombineSearchFragment$EventHelper$onBotAdd$1(CombineSearchFragment r1, RecommendBot r2, CombineSearchFragment.EventHelper r3, int r4, Continuation<? super CombineSearchFragment$EventHelper$onBotAdd$1> r5) {
        this.this$0 = r1;
        this.$data = r2;
        this.this$1 = r3;
        this.$position = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CombineSearchFragment$EventHelper$onBotAdd$1(this.this$0, this.$data, this.this$1, this.$position, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CombineSearchFragment r11 = this.this$0;
        int r2 = CombineSearchFragment.G;
        r11.da0().a(this.this$0.j);
        a4.a.getClass();
        a4.a(a4.b);
        BotStatusCacheDelegate r12 = BotStatusCacheDelegate.b;
        String r3 = this.$data.o();
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        r12.a(r3, true);
        CombineSearchFragment r13 = this.this$0;
        boolean r4 = this.this$1.a;
        int r5 = this.$position;
        if (r4 == false) goto L14;
        r13.A.notifyItemChanged(r5);
    L15:
        CombineSearchFragment.X90(this.this$0, this.$data);
        Job r14 = BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this.$data, null), 3, null);
        this.label = 1;
        if (r14.join(this) != r0) goto L19;
        return r0;
    L14:
        r13.z.notifyItemChanged(r5);
        goto L15
    }
}
