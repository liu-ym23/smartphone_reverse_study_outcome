package com.larus.bmhome.chat.detail.code;

import android.content.Context;
import android.os.SystemClock;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.mainbot.impl.databinding.LarusFragmentCodeBlockDetailBinding;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.detail.code.CodeBlockDetailFragment$refreshMarkDownTextView$1$1", f = "CodeBlockDetailFragment.kt", i = {}, l = {706}, m = "invokeSuspend", n = {}, s = {})
public final class CodeBlockDetailFragment$refreshMarkDownTextView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isCodeToBeFinished;
    final /* synthetic */ Context $it;
    final /* synthetic */ CustomMarkdownTextView $markDownTextView;
    final /* synthetic */ int $maxContentWidth;
    final /* synthetic */ boolean $scrollToBottomIfNeeded;
    final /* synthetic */ Ref.LongRef $startTime;
    final /* synthetic */ boolean $useAsync;
    final /* synthetic */ boolean $useGradientCover;
    int label;
    final /* synthetic */ CodeBlockDetailFragment this$0;

    public CodeBlockDetailFragment$refreshMarkDownTextView$1$1(boolean r1, CodeBlockDetailFragment r2, Ref.LongRef r3, boolean r4, boolean r5, CustomMarkdownTextView r6, boolean r7, Context r8, int r9, Continuation<? super CodeBlockDetailFragment$refreshMarkDownTextView$1$1> r10) {
        this.$isCodeToBeFinished = r1;
        this.this$0 = r2;
        this.$startTime = r3;
        this.$useAsync = r4;
        this.$scrollToBottomIfNeeded = r5;
        this.$markDownTextView = r6;
        this.$useGradientCover = r7;
        this.$it = r8;
        this.$maxContentWidth = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new CodeBlockDetailFragment$refreshMarkDownTextView$1$1(this.$isCodeToBeFinished, this.this$0, this.$startTime, this.$useAsync, this.$scrollToBottomIfNeeded, this.$markDownTextView, this.$useGradientCover, this.$it, this.$maxContentWidth, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L18:
        lw8.l r14 = (lw8.l) r13;
        if (this.$isCodeToBeFinished == false) goto L21;
    L24:
        FLogger r2 = FLogger.a;
        r2.d("CodeBlockDetailFragment", "getNewMarkdownContent cost[" + (SystemClock.elapsedRealtime() - this.$startTime.element) + "], useAsync[" + this.$useAsync + ']');
        this.$startTime.element = SystemClock.elapsedRealtime();
        if (this.$scrollToBottomIfNeeded == true) goto L27;
    L29:
        r3 = false;
    L30:
        int r4 = this.$markDownTextView.getMeasuredHeight();
        if (this.$useGradientCover == false) goto L33;
        CodeBlockDetailFragment r8 = this.this$0;
        int r9 = CodeBlockDetailFragment.k0;
        r8.ta0(r4);
    L33:
        this.$markDownTextView.C(r14, null, null, null);
        r2.d("CodeBlockDetailFragment", "setMarkdown cost[" + (SystemClock.elapsedRealtime() - this.$startTime.element) + "], useAsync[" + this.$useAsync + ']');
        if (r3 == false) goto L42;
        CodeBlockDetailFragment r15 = this.this$0;
        int r5 = CodeBlockDetailFragment.k0;
        LarusFragmentCodeBlockDetailBinding r16 = r15.C;
        if (r16 == null) goto L42;
        NestedScrollView r17 = r16.i;
        if (r17 == null) goto L42;
        r17.post(new n(r17));
    L42:
        if (this.$useGradientCover == false) goto L47;
        CodeBlockDetailFragment r18 = this.this$0;
        int r6 = CodeBlockDetailFragment.k0;
        CustomMarkdownTextView r7 = r18.f;
        if (r7 == null) goto L47;
        r7.post(new f(r7, r18, r4));
    L47:
        this.this$0.E = false;
        this.this$0.oa0();
        if (this.$isCodeToBeFinished == false) goto L52;
        this.this$0.va0();
        AppCompatImageView r19 = this.this$0.Z;
        if (r19 == null) goto L57;
        r19.setVisibility(8);
    L57:
        return Unit.INSTANCE;
    L52:
        AppCompatImageView r110 = this.this$0.Z;
        if (r110 == null) goto L55;
        r110.setVisibility(0);
    L55:
        this.this$0.ua0();
        goto L57
    L27:
        if (this.this$0.Q == true) goto L29;
    L21:
        if (this.this$0.S != null) goto L24;
        FLogger.a.i("CodeBlockDetailFragment", "getNewMarkdownContent, not the last but executor is null, return");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        if (this.$isCodeToBeFinished == false) goto L14;
        CodeBlockDetailFragment r111 = this.this$0;
        int r10 = CodeBlockDetailFragment.k0;
        ExecutorService r11 = r111.S;
        if (r11 == null) goto L13;
        r11.shutdownNow();
    L13:
        r111.S = null;
        CoroutineDispatcher r112 = Dispatchers.getIO();
    L15:
        CodeBlockDetailFragment$refreshMarkDownTextView$1$1$markdownContent$1 r12 = new CodeBlockDetailFragment$refreshMarkDownTextView$1$1$markdownContent$1(this.this$0, this.$it, this.$markDownTextView, this.$maxContentWidth, null);
        this.label = 1;
        r13 = BuildersKt.withContext(r112, r12, this);
        if (r13 != r0) goto L18;
        return r0;
    L14:
        r112 = (ExecutorCoroutineDispatcher) this.this$0.T.getValue();
        goto L15
    }
}
