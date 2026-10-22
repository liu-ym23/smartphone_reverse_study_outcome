package com.larus.bot.impl.feature.discover;

import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.bean.RecommendBot;
import java.util.Iterator;
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
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListFragment$handleChange$1", f = "BotDiscoverListFragment.kt", i = {0, 0}, l = {228}, m = "invokeSuspend", n = {"conversation", "matched"}, s = {"L$3", "L$4"})
final class BotDiscoverListFragment$handleChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<RecommendBot> $allBot;
    final /* synthetic */ List<wc9.e> $newConversations;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ BotDiscoverListFragment this$0;

    public BotDiscoverListFragment$handleChange$1(List<wc9.e> r1, List<RecommendBot> r2, BotDiscoverListFragment r3, Continuation<? super BotDiscoverListFragment$handleChange$1> r4) {
        this.$newConversations = r1;
        this.$allBot = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotDiscoverListFragment$handleChange$1(this.$newConversations, this.$allBot, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008a -> B:60:0x0146). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00f2 -> B:46:0x00fb). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Ref.ObjectRef r2 = (Ref.ObjectRef) this.L$4;
        wc9.e r5 = (wc9.e) this.L$3;
        Iterator r6 = (Iterator) this.L$2;
        BotDiscoverListFragment r7 = (BotDiscoverListFragment) this.L$1;
        List<RecommendBot> r8 = (List) this.L$0;
        ResultKt.throwOnFailure(r15);
        List<RecommendBot> r9 = r8;
        BotDiscoverListFragment r10 = r7;
        Iterator r11 = r6;
        wc9.e r12 = r5;
        Ref.ObjectRef r13 = r2;
        Object r3 = r0;
        BotDiscoverListFragment$handleChange$1 r4 = this;
    L46:
        String r16 = (String) CollectionsKt.getOrNull((List) r15, 0);
        Iterator<T> r14 = r9.iterator();
    L48:
        if (r14.hasNext() == false) goto L52;
        Object r17 = r14.next();
        if (Intrinsics.areEqual(((RecommendBot) r17).o(), r16) == false) goto L48;
    L53:
        RecommendBot r18 = (RecommendBot) r17;
        if (r18 == null) goto L59;
        String r19 = r18.o();
        if (r19 == null) goto L58;
        BotStatusCacheDelegate r110 = BotStatusCacheDelegate.b;
        r110.a(r19, true);
        r110.d(r19, ic8.n.l(r12));
    L58:
        r18.G0(r12.a);
        r13.element = r18;
    L59:
        BotDiscoverListFragment$handleChange$1 r111 = r4;
        r0 = r3;
        Ref.ObjectRef r20 = r13;
        Iterator r21 = r11;
        BotDiscoverListFragment r22 = r10;
        List<RecommendBot> r23 = r9;
    L60:
        RecommendBot r24 = (RecommendBot) r20.element;
        if (r24 == null) goto L10;
        String r25 = r24.o();
        if (r25 == null) goto L10;
        if ((!StringsKt.isBlank(r25)) == true) goto L68;
        r25 = null;
    L68:
        if (r25 == null) goto L10;
        int r26 = BotDiscoverListFragment.A;
        r22.Z90().H2(r25);
    L10:
        if (r21.hasNext() == false) goto L71;
        wc9.e r27 = (wc9.e) r21.next();
        r20 = new Ref.ObjectRef();
        Integer r28 = r27.t;
        if (r28 != null) goto L15;
    L29:
        Iterator<T> r29 = r23.iterator();
    L31:
        if (r29.hasNext() == false) goto L35;
        Object r112 = r29.next();
        if (Intrinsics.areEqual(((RecommendBot) r112).E(), r27.a) == false) goto L31;
    L36:
        RecommendBot r113 = (RecommendBot) r112;
        if (r113 == null) goto L42;
        String r30 = r113.o();
        if (r30 == null) goto L41;
        BotStatusCacheDelegate r114 = BotStatusCacheDelegate.b;
        r114.a(r30, true);
        r114.d(r30, ic8.n.l(r27));
    L41:
        r20.element = r113;
        goto L60
    L73:
        r20.element = r113;
        goto L60
    L42:
        r111.L$0 = r23;
        r111.L$1 = r22;
        r111.L$2 = r21;
        r111.L$3 = r27;
        r111.L$4 = r20;
        r111.label = 1;
        Object r31 = ic8.n.c(r27, r111);
        if (r31 != r0) goto L45;
        return r0;
    L45:
        Object r115 = r0;
        r4 = r111;
        r15 = r31;
        r9 = r23;
        r10 = r22;
        r11 = r21;
        r12 = r27;
        r13 = r20;
        r3 = r115;
        goto L46
    L35:
        r112 = null;
        goto L36
    L15:
        if (r28.intValue() != 2) goto L29;
        Iterator<T> r32 = r23.iterator();
    L18:
        if (r32.hasNext() == false) goto L22;
        Object r116 = r32.next();
        if (Intrinsics.areEqual(((RecommendBot) r116).E(), r27.a) == false) goto L18;
    L23:
        RecommendBot r117 = (RecommendBot) r116;
        if (r117 == null) goto L60;
        String r33 = r117.o();
        if (r33 == null) goto L28;
        BotStatusCacheDelegate r34 = BotStatusCacheDelegate.b;
        r34.a(r33, false);
        r34.d(r33, false);
    L28:
        r117.G0("");
        r20.element = r117;
        goto L60
    L72:
        r117.G0("");
        r20.element = r117;
        goto L60
    L22:
        r116 = null;
        goto L23
    L71:
        return Unit.INSTANCE;
    L52:
        r17 = null;
        goto L53
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        List<wc9.e> r118 = this.$newConversations;
        List<RecommendBot> r35 = this.$allBot;
        BotDiscoverListFragment r36 = this.this$0;
        r21 = r118.iterator();
        r23 = r35;
        r22 = r36;
        r111 = this;
        goto L10
    }
}
