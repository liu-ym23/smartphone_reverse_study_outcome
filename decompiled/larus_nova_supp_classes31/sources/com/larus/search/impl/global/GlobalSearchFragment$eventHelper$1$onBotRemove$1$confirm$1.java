package com.larus.search.impl.global;

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
import tx9.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.global.GlobalSearchFragment$eventHelper$1$onBotRemove$1$confirm$1", f = "GlobalSearchFragment.kt", i = {}, l = {295, 299}, m = "invokeSuspend", n = {}, s = {})
public final class GlobalSearchFragment$eventHelper$1$onBotRemove$1$confirm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendBot $data;
    final /* synthetic */ int $position;
    Object L$0;
    int label;
    final /* synthetic */ GlobalSearchFragment this$0;

    /* JADX INFO: renamed from: com.larus.search.impl.global.GlobalSearchFragment$eventHelper$1$onBotRemove$1$confirm$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.search.impl.global.GlobalSearchFragment$eventHelper$1$onBotRemove$1$confirm$1$1", f = "GlobalSearchFragment.kt", i = {}, l = {298}, m = "invokeSuspend", n = {}, s = {})
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

    public GlobalSearchFragment$eventHelper$1$onBotRemove$1$confirm$1(RecommendBot r1, GlobalSearchFragment r2, int r3, Continuation<? super GlobalSearchFragment$eventHelper$1$onBotRemove$1$confirm$1> r4) {
        this.$data = r1;
        this.this$0 = r2;
        this.$position = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GlobalSearchFragment$eventHelper$1$onBotRemove$1$confirm$1(this.$data, this.this$0, this.$position, r5);
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
        this.this$0.g.notifyItemChanged(this.$position);
        GlobalSearchFragment r14 = this.this$0;
        RecommendBot r7 = this.$data;
        r14.getClass();
        String r8 = r7.o();
        SearchMobParam r9 = r7.b;
        if (r9 == null) goto L43;
        String r11 = r9.c;
    L44:
        if (r9 == null) goto L46;
        String r12 = r9.d;
    L47:
        if (r9 == null) goto L49;
        String r13 = r9.e;
    L50:
        if (r9 == null) goto L52;
        String r10 = r9.f;
    L54:
        if (o0.d(r7.e()) == false) goto L56;
        String r15 = "1";
    L57:
        String r16 = r15;
        RecommendFrom r18 = r7.a;
        if (r18 == null) goto L60;
        String r19 = r18.b;
    L61:
        if (r18 == null) goto L63;
        r5 = r18.a;
    L63:
        g0.a(r8, r16, r10, r5, r19, r11, r12, r13, r14, 17524);
        final String r20 = this.$data.o();
        Lazy r21 = q3.a;
        z3 r22 = q3.a();
        if (r22 == null) goto L67;
        r22.n(new q(r20));
    L67:
        return Unit.INSTANCE;
    L60:
        r19 = null;
        goto L61
    L56:
        r15 = "0";
        goto L57
    L52:
        r10 = null;
        goto L54
    L49:
        r13 = null;
        goto L50
    L46:
        r12 = null;
        goto L47
    L43:
        r11 = null;
        goto L44
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        RecommendBot r23 = (RecommendBot) this.L$0;
        ResultKt.throwOnFailure(r17);
        Object r24 = r17;
    L32:
        r23.G0((String) r24);
    L33:
        Job r25 = BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this.$data, null), 3, null);
        this.L$0 = null;
        this.label = 2;
        if (r25.join(this) != r1) goto L36;
        return r1;
    L10:
        ResultKt.throwOnFailure(r17);
        if (this.$data.j0() == false) goto L23;
        String r26 = this.$data.E();
        if (r26 != null) goto L15;
    L18:
        boolean r27 = true;
    L19:
        if (r27 == true) goto L26;
        int r28 = wf9.a.a;
        if (wf9.a.a(this.$data.E()) == false) goto L23;
    L26:
        r23 = this.$data;
        ConversationRepoManager r29 = ConversationRepoManager.a;
        String r30 = r23.o();
        if (r30 != null) goto L29;
        r30 = "";
    L29:
        this.L$0 = r23;
        this.label = 1;
        r24 = ConversationRepoManager.d(r30, this);
        if (r24 != r1) goto L32;
        return r1;
    L15:
        if (r26.length() == 0) goto L18;
        r27 = false;
    L23:
        if (this.$data.j0() == true) goto L33;
        int r31 = wf9.a.a;
        if (wf9.a.a(this.$data.E()) == true) goto L33;
        goto L26
    }
}
