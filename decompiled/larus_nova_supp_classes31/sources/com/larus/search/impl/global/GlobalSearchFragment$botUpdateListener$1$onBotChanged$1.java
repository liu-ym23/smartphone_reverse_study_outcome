package com.larus.search.impl.global;

import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.im.bean.bot.BotModel;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.global.GlobalSearchFragment$botUpdateListener$1$onBotChanged$1", f = "GlobalSearchFragment.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
public final class GlobalSearchFragment$botUpdateListener$1$onBotChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<BotModel> $changedBots;
    int label;
    final /* synthetic */ GlobalSearchFragment this$0;
    final /* synthetic */ GlobalSearchFragment$botUpdateListener$1 this$1;

    /* JADX INFO: renamed from: com.larus.search.impl.global.GlobalSearchFragment$botUpdateListener$1$onBotChanged$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.search.impl.global.GlobalSearchFragment$botUpdateListener$1$onBotChanged$1$1", f = "GlobalSearchFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BotModel $changedBot;
        final /* synthetic */ int $index;
        final /* synthetic */ ws9.c $itemData;
        int label;
        final /* synthetic */ GlobalSearchFragment this$0;

        public AnonymousClass1(ws9.c r1, BotModel r2, GlobalSearchFragment r3, int r4, Continuation<? super AnonymousClass1> r5) {
            this.$itemData = r1;
            this.$changedBot = r2;
            this.this$0 = r3;
            this.$index = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$itemData, this.$changedBot, this.this$0, this.$index, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L19;
            ResultKt.throwOnFailure(r2);
            RecommendBot r3 = this.$itemData.b.a();
            if (r3 == null) goto L7;
            r3.w0(this.$changedBot.getBgImgInfo());
        L7:
            RecommendBot r4 = this.$itemData.b.a();
            if (r4 == null) goto L10;
            r4.C0(this.$changedBot.getBgImgUrl());
        L10:
            RecommendBot r5 = this.$itemData.b.a();
            if (r5 == null) goto L13;
            r5.y0(this.$changedBot.getBgImgUri());
        L13:
            RecommendBot r6 = this.$itemData.b.a();
            if (r6 == null) goto L16;
            r6.v0(this.$changedBot.getBgImgColor());
        L16:
            this.this$0.g.notifyItemChanged(this.$index);
            return Unit.INSTANCE;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public GlobalSearchFragment$botUpdateListener$1$onBotChanged$1(GlobalSearchFragment r1, List<BotModel> r2, GlobalSearchFragment$botUpdateListener$1 r3, Continuation<? super GlobalSearchFragment$botUpdateListener$1$onBotChanged$1> r4) {
        this.this$0 = r1;
        this.$changedBots = r2;
        this.this$1 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GlobalSearchFragment$botUpdateListener$1$onBotChanged$1(this.this$0, this.$changedBots, this.this$1, r5);
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
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        int r11 = this.this$0.g.getItemCount();
        BotModel r5 = (BotModel) CollectionsKt.firstOrNull(this.$changedBots);
        if (r5 == null) goto L31;
        if (Intrinsics.areEqual(r5.getBotId(), this.this$1.a) == false) goto L31;
        int r7 = 0;
    L13:
        if (r7 >= r11) goto L31;
        ws9.c r4 = this.this$0.g.B2(r7);
        String r2 = this.this$1.a;
        if (r4 == null) goto L21;
        ws9.b r3 = r4.b;
        if (r3 == null) goto L21;
        RecommendBot r6 = r3.a();
        if (r6 == null) goto L21;
        String r8 = r6.o();
    L23:
        if (Intrinsics.areEqual(r2, r8) == true) goto L24;
        r7 = r7 + 1;
        goto L13
    L24:
        MainCoroutineDispatcher r12 = Dispatchers.getMain();
        AnonymousClass1 r9 = new AnonymousClass1(r4, r5, this.this$0, r7, null);
        this.label = 1;
        if (BuildersKt.withContext(r12, r9, this) != r0) goto L28;
        return r0;
    L21:
        r8 = null;
    L31:
        return Unit.INSTANCE;
    }
}
