package com.larus.bmhome.chat.list.cell.prompt;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.prompt.PromptCell$goToOtherChatPage$1", f = "PromptCell.kt", i = {}, l = {1329}, m = "invokeSuspend", n = {}, s = {})
final class PromptCell$goToOtherChatPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendBot $bot;
    int label;
    final /* synthetic */ PromptCell this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.list.cell.prompt.PromptCell$goToOtherChatPage$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.list.cell.prompt.PromptCell$goToOtherChatPage$1$1", f = "PromptCell.kt", i = {}, l = {1330}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RecommendBot $bot;
        int label;
        final /* synthetic */ PromptCell this$0;

        public AnonymousClass1(PromptCell r1, RecommendBot r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$bot = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$bot, r4);
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
            ResultKt.throwOnFailure(r7);
        L11:
            com.bytedance.router.i r2 = SmartRouter.buildRoute(lf8.a.getContext(this.this$0), "//flow/chat_page_bridge");
            Bundle r8 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("is_need_fixed_bottom_tab", Boxing.boxBoolean(false)), TuplesKt.to("argPreviousPage", "chat"), TuplesKt.to("argConversationId", (String) r7), TuplesKt.to("argBotId", this.$bot.o()), TuplesKt.to("argCvsBgImgUrl", this.$bot.e()), TuplesKt.to("argCvsBgImgColor", this.$bot.a()), TuplesKt.to("argCvsBgImgOpen", Boxing.boxBoolean(this.$bot.c())), TuplesKt.to("is_create_sub_conversation", Boxing.boxBoolean(false)), TuplesKt.to("enter_method", "chat_suggestedprompt_click"), TuplesKt.to("argBotRecommendFrom", this.$bot.a)});
            PromptSpan r3 = this.this$0.e;
            if (r3 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("span");
            r3 = null;
        L14:
            ViewParent r4 = r3.getParent();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.ViewGroup");
            by7.h.j(r8, (ViewGroup) r4);
            r2.c.putExtras(r8);
            r2.d();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            PromptCell r9 = this.this$0;
            RecommendBot r5 = this.$bot;
            this.label = 1;
            r7 = PromptCell.o(r9, r5, this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    public PromptCell$goToOtherChatPage$1(PromptCell r1, RecommendBot r2, Continuation<? super PromptCell$goToOtherChatPage$1> r3) {
        this.this$0 = r1;
        this.$bot = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PromptCell$goToOtherChatPage$1(this.this$0, this.$bot, r4);
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
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        MainCoroutineDispatcher r8 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$bot, null);
        this.label = 1;
        if (BuildersKt.withContext(r8, r2, this) != r0) goto L12;
        return r0;
    }
}
