package com.larus.search.impl.global;

import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.global.GlobalSearchFragment$botStatusObserver$1$onChange$1", f = "GlobalSearchFragment.kt", i = {1, 1}, l = {164, 176}, m = "invokeSuspend", n = {"data", "position"}, s = {"L$0", "I$0"})
final class GlobalSearchFragment$botStatusObserver$1$onChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wc9.e $newConversation;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ GlobalSearchFragment this$0;

    public GlobalSearchFragment$botStatusObserver$1$onChange$1(wc9.e r1, GlobalSearchFragment r2, Continuation<? super GlobalSearchFragment$botStatusObserver$1$onChange$1> r3) {
        this.$newConversation = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GlobalSearchFragment$botStatusObserver$1$onChange$1(this.$newConversation, this.this$0, r4);
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
        String r4 = null;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        int r2 = this.I$0;
        ws9.c r3 = (ws9.c) this.L$0;
        ResultKt.throwOnFailure(r11);
    L67:
        List r12 = (List) r11;
        if (r12 == null) goto L70;
        String r13 = (String) CollectionsKt.getOrNull(r12, 0);
    L71:
        RecommendBot r5 = r3.b.a();
        if (r5 == null) goto L75;
        r4 = r5.o();
    L75:
        if (Intrinsics.areEqual(r4, r13) == false) goto L84;
        RecommendBot r14 = r3.b.a();
        if (r14 == null) goto L81;
        String r15 = r14.o();
        if (r15 == null) goto L81;
        BotStatusCacheDelegate.b.a(r15, true);
    L81:
        RecommendBot r16 = r3.b.a();
        if (r16 == null) goto L84;
        r16.G0(this.$newConversation.a);
    L84:
        int r6 = r2;
    L85:
        this.this$0.g.notifyItemChanged(r6);
        return Unit.INSTANCE;
    L70:
        r13 = null;
        goto L71
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L13:
        BotModel r17 = (BotModel) r11;
        if (r17 == null) goto L16;
        String r18 = r17.getBotId();
    L17:
        int r7 = this.this$0.g.getItemCount();
        r6 = 0;
    L18:
        if (r6 >= r7) goto L89;
        ws9.c r8 = this.this$0.g.B2(r6);
        if (r18 != null) goto L22;
    L24:
        boolean r9 = false;
    L25:
        if (r9 == false) goto L87;
        if (r8 == null) goto L32;
        ws9.b r10 = r8.b;
        if (r10 == null) goto L32;
        RecommendBot r19 = r10.a();
        if (r19 == null) goto L32;
        String r20 = r19.o();
    L34:
        if (Intrinsics.areEqual(r18, r20) == false) goto L87;
        Integer r21 = this.$newConversation.t;
        String r22 = "";
        if (r21 == null) goto L50;
        if (r21.intValue() != 2) goto L50;
        RecommendBot r23 = r8.b.a();
        if (r23 == null) goto L43;
        r23.G0("");
    L43:
        BotStatusCacheDelegate r24 = BotStatusCacheDelegate.b;
        RecommendBot r25 = r8.b.a();
        if (r25 == null) goto L49;
        String r26 = r25.o();
        if (r26 == null) goto L49;
        r22 = r26;
    L49:
        r24.a(r22, false);
    L50:
        String r110 = this.$newConversation.a;
        RecommendBot r27 = r8.b.a();
        if (r27 == null) goto L53;
        String r28 = r27.E();
    L55:
        if (Intrinsics.areEqual(r110, r28) == false) goto L63;
        BotStatusCacheDelegate r111 = BotStatusCacheDelegate.b;
        RecommendBot r29 = r8.b.a();
        if (r29 == null) goto L62;
        String r30 = r29.o();
        if (r30 == null) goto L62;
        r22 = r30;
    L62:
        r111.a(r22, true);
        goto L85
    L63:
        IAIChatService.Companion r112 = IAIChatService.a;
        wc9.e r31 = this.$newConversation;
        this.L$0 = r8;
        this.I$0 = r6;
        this.label = 2;
        r11 = r112.s7(r31, this);
        if (r11 != r0) goto L66;
        return r0;
    L66:
        r2 = r6;
        r3 = r8;
        goto L67
    L53:
        r28 = null;
    L32:
        r20 = null;
    L87:
        r6 = r6 + 1;
        goto L18
    L22:
        if (o0.d(r18) != true) goto L24;
        r9 = true;
        goto L25
    L89:
        return Unit.INSTANCE;
    L16:
        r18 = null;
        goto L17
    L10:
        ResultKt.throwOnFailure(r11);
        IBotRepoService r113 = RepoDispatcherDelegate.b.b();
        String r32 = this.$newConversation.a;
        this.label = 1;
        r11 = r113.j1(r32, false, this);
        if (r11 != r0) goto L13;
        return r0;
    }
}
