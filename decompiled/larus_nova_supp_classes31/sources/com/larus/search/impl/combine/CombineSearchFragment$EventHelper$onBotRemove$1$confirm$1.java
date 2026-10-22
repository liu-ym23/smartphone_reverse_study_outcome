package com.larus.search.impl.combine;

import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.platform.api.z3;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.q3;
import com.larus.search.impl.common.ConversationRepoManager;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
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
@DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchFragment$EventHelper$onBotRemove$1$confirm$1", f = "CombineSearchFragment.kt", i = {}, l = {1056, 1060}, m = "invokeSuspend", n = {}, s = {})
public final class CombineSearchFragment$EventHelper$onBotRemove$1$confirm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendBot $data;
    final /* synthetic */ int $position;
    Object L$0;
    int label;
    final /* synthetic */ CombineSearchFragment this$0;
    final /* synthetic */ CombineSearchFragment.EventHelper this$1;

    /* JADX INFO: renamed from: com.larus.search.impl.combine.CombineSearchFragment$EventHelper$onBotRemove$1$confirm$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchFragment$EventHelper$onBotRemove$1$confirm$1$1", f = "CombineSearchFragment.kt", i = {}, l = {1059}, m = "invokeSuspend", n = {}, s = {})
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

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ConversationRepoManager r6 = ConversationRepoManager.a;
            String r7 = this.$data.E();
            String r2 = "";
            if (r7 != null) goto L11;
            r7 = "";
        L11:
            String r3 = this.$data.o();
            if (r3 == null) goto L15;
            r2 = r3;
        L15:
            this.label = 1;
            if (ConversationRepoManager.e(r7, r2, this) != r0) goto L19;
            return r0;
        }
    }

    public CombineSearchFragment$EventHelper$onBotRemove$1$confirm$1(RecommendBot r1, CombineSearchFragment r2, CombineSearchFragment.EventHelper r3, int r4, Continuation<? super CombineSearchFragment$EventHelper$onBotRemove$1$confirm$1> r5) {
        this.$data = r1;
        this.this$0 = r2;
        this.this$1 = r3;
        this.$position = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CombineSearchFragment$EventHelper$onBotRemove$1$confirm$1(this.$data, this.this$0, this.this$1, this.$position, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r5 = null;
        String r6 = "";
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r17);
    L36:
        this.$data.G0("");
        BotStatusCacheDelegate r3 = BotStatusCacheDelegate.b;
        String r4 = this.$data.o();
        if (r4 == null) goto L40;
        r6 = r4;
    L40:
        r3.a(r6, false);
        CombineSearchFragment r7 = this.this$0;
        boolean r8 = this.this$1.a;
        int r9 = this.$position;
        if (r8 == false) goto L43;
        r7.A.notifyItemChanged(r9);
    L44:
        CombineSearchFragment r14 = this.this$0;
        RecommendBot r10 = this.$data;
        r14.getClass();
        String r11 = r10.o();
        SearchMobParam r12 = r10.b;
        if (r12 == null) goto L47;
        String r13 = r12.c;
    L48:
        if (r12 == null) goto L50;
        String r15 = r12.d;
    L51:
        if (r12 == null) goto L53;
        String r16 = r12.e;
    L54:
        if (r12 == null) goto L56;
        String r18 = r12.f;
    L58:
        if (o0.d(r10.e()) == false) goto L60;
        String r19 = "1";
    L61:
        String r20 = r19;
        RecommendFrom r21 = r10.a;
        if (r21 == null) goto L64;
        String r110 = r21.b;
    L65:
        if (r21 == null) goto L67;
        r5 = r21.a;
    L67:
        tx9.g0.a(r11, r20, r18, r5, r110, r13, r15, r16, r14, 17524);
        final String r22 = this.$data.o();
        Lazy r23 = q3.a;
        z3 r24 = q3.a();
        if (r24 == null) goto L71;
        r24.n(new w(r22));
    L71:
        return Unit.INSTANCE;
    L64:
        r110 = null;
        goto L65
    L60:
        r19 = "0";
        goto L61
    L56:
        r18 = null;
        goto L58
    L53:
        r16 = null;
        goto L54
    L50:
        r15 = null;
        goto L51
    L47:
        r13 = null;
        goto L48
    L43:
        r7.z.notifyItemChanged(r9);
        goto L44
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        RecommendBot r25 = (RecommendBot) this.L$0;
        ResultKt.throwOnFailure(r17);
        Object r26 = r17;
    L32:
        r25.G0((String) r26);
    L33:
        Job r27 = BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this.$data, null), 3, null);
        this.L$0 = null;
        this.label = 2;
        if (r27.join(this) != r1) goto L36;
        return r1;
    L10:
        ResultKt.throwOnFailure(r17);
        if (this.$data.j0() == false) goto L23;
        String r28 = this.$data.E();
        if (r28 != null) goto L15;
    L18:
        boolean r29 = true;
    L19:
        if (r29 == true) goto L26;
        int r30 = wf9.a.a;
        if (wf9.a.a(this.$data.E()) == false) goto L23;
    L26:
        r25 = this.$data;
        ConversationRepoManager r31 = ConversationRepoManager.a;
        String r32 = r25.o();
        if (r32 != null) goto L29;
        r32 = "";
    L29:
        this.L$0 = r25;
        this.label = 1;
        r26 = ConversationRepoManager.d(r32, this);
        if (r26 != r1) goto L32;
        return r1;
    L15:
        if (r28.length() == 0) goto L18;
        r29 = false;
    L23:
        if (this.$data.j0() == true) goto L33;
        int r33 = wf9.a.a;
        if (wf9.a.a(this.$data.E()) == true) goto L33;
        goto L26
    }
}
