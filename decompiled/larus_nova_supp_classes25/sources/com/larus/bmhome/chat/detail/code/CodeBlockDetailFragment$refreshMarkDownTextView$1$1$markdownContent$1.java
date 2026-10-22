package com.larus.bmhome.chat.detail.code;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.detail.code.CodeBlockDetailFragment$refreshMarkDownTextView$1$1$markdownContent$1", f = "CodeBlockDetailFragment.kt", i = {}, l = {707}, m = "invokeSuspend", n = {}, s = {})
public final class CodeBlockDetailFragment$refreshMarkDownTextView$1$1$markdownContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super lw8.l>, Object> {
    final /* synthetic */ Context $it;
    final /* synthetic */ CustomMarkdownTextView $markDownTextView;
    final /* synthetic */ int $maxContentWidth;
    int label;
    final /* synthetic */ CodeBlockDetailFragment this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.detail.code.CodeBlockDetailFragment$refreshMarkDownTextView$1$1$markdownContent$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.detail.code.CodeBlockDetailFragment$refreshMarkDownTextView$1$1$markdownContent$1$1", f = "CodeBlockDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super lw8.l>, Object> {
        final /* synthetic */ Context $it;
        final /* synthetic */ CustomMarkdownTextView $markDownTextView;
        final /* synthetic */ int $maxContentWidth;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CodeBlockDetailFragment this$0;

        public AnonymousClass1(CodeBlockDetailFragment r1, Context r2, CustomMarkdownTextView r3, int r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$it = r2;
            this.$markDownTextView = r3;
            this.$maxContentWidth = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.this$0, this.$it, this.$markDownTextView, this.$maxContentWidth, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super lw8.l> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            CoroutineScopeKt.ensureActive((CoroutineScope) this.L$0);
            CodeBlockDetailFragment r6 = this.this$0;
            Context r0 = this.$it;
            CustomMarkdownTextView r1 = this.$markDownTextView;
            int r2 = this.$maxContentWidth;
            int r3 = CodeBlockDetailFragment.k0;
            return r6.la0(r0, r1, r2);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CodeBlockDetailFragment$refreshMarkDownTextView$1$1$markdownContent$1(CodeBlockDetailFragment r1, Context r2, CustomMarkdownTextView r3, int r4, Continuation<? super CodeBlockDetailFragment$refreshMarkDownTextView$1$1$markdownContent$1> r5) {
        this.this$0 = r1;
        this.$it = r2;
        this.$markDownTextView = r3;
        this.$maxContentWidth = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CodeBlockDetailFragment$refreshMarkDownTextView$1$1$markdownContent$1(this.this$0, this.$it, this.$markDownTextView, this.$maxContentWidth, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super lw8.l> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AnonymousClass1 r11 = new AnonymousClass1(this.this$0, this.$it, this.$markDownTextView, this.$maxContentWidth, null);
        this.label = 1;
        r10 = CoroutineScopeKt.coroutineScope(r11, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
