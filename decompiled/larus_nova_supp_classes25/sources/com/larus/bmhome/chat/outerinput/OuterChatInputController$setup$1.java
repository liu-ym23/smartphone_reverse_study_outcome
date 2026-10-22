package com.larus.bmhome.chat.outerinput;

import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.outerinput.OuterChatInputController$setup$1", f = "OuterChatInputController.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
public final class OuterChatInputController$setup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FrameLayout $container;
    final /* synthetic */ Function1<Integer, Unit> $getHeight;
    final /* synthetic */ OuterChatInput $inputView;
    final /* synthetic */ String $previousPage;
    final /* synthetic */ boolean $report;
    int label;
    final /* synthetic */ OuterChatInputController this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.outerinput.OuterChatInputController$setup$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.outerinput.OuterChatInputController$setup$1$1", f = "OuterChatInputController.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Unit>, Object> {
        final /* synthetic */ FrameLayout $container;
        final /* synthetic */ OuterChatInput $inputView;
        final /* synthetic */ String $previousPage;
        final /* synthetic */ boolean $report;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ OuterChatInputController this$0;

        public AnonymousClass1(OuterChatInputController r1, FrameLayout r2, OuterChatInput r3, boolean r4, String r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$container = r2;
            this.$inputView = r3;
            this.$report = r4;
            this.$previousPage = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            AnonymousClass1 r7 = new AnonymousClass1(this.this$0, this.$container, this.$inputView, this.$report, this.$previousPage, r10);
            r7.L$0 = r9;
            return r7;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((wc9.e) r1, (Continuation) r2);
        }

        public final Object invoke(wc9.e r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L14:
            if (this.$report == false) goto L17;
            this.this$0.c(this.$previousPage);
        L17:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            wc9.e r7 = (wc9.e) this.L$0;
            if (r7 == null) goto L17;
            FLogger.a.i("OuterChatInputController", "show outerChatInput, tabKey:" + this.this$0.b);
            e1.x(this.$container);
            OuterChatInput r2 = this.$inputView;
            OuterChatInputController r3 = this.this$0;
            Fragment r4 = r3.a;
            String r5 = r3.b;
            this.label = 1;
            if (r2.Z5(r4, r7, r5, this) != r0) goto L14;
            return r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OuterChatInputController$setup$1(OuterChatInputController r1, FrameLayout r2, Function1<? super Integer, Unit> r3, OuterChatInput r4, boolean r5, String r6, Continuation<? super OuterChatInputController$setup$1> r7) {
        this.this$0 = r1;
        this.$container = r2;
        this.$getHeight = r3;
        this.$inputView = r4;
        this.$report = r5;
        this.$previousPage = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new OuterChatInputController$setup$1(this.this$0, this.$container, this.$getHeight, this.$inputView, this.$report, this.$previousPage, r10);
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        OuterChatInputController r12 = this.this$0;
        FrameLayout r3 = this.$container;
        Function1<Integer, Unit> r4 = this.$getHeight;
        int r5 = OuterChatInputController.d;
        r12.getClass();
        if (r3.getVisibility() == 0) goto L15;
        r2 = false;
    L15:
        if (r2 == false) goto L19;
        ViewTreeObserver r13 = r3.getViewTreeObserver();
        if (r13 == null) goto L22;
        r13.addOnGlobalLayoutListener(new q(r3, r4));
    L22:
        return Unit.INSTANCE;
    L19:
        if (r4 == null) goto L22;
        r4.invoke(0);
        goto L22
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        OuterChatInputController r14 = this.this$0;
        AnonymousClass1 r6 = new AnonymousClass1(r14, this.$container, this.$inputView, this.$report, this.$previousPage, null);
        this.label = 1;
        if (OuterChatInputController.d(r14, r6, this) != r0) goto L11;
        return r0;
    }
}
