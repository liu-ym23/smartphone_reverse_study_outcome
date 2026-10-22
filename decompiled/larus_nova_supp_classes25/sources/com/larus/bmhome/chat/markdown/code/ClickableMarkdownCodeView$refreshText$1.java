package com.larus.bmhome.chat.markdown.code;

import android.text.SpannableStringBuilder;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView$refreshText$1", f = "ClickableMarkdownCodeView.kt", i = {}, l = {1535}, m = "invokeSuspend", n = {}, s = {})
final class ClickableMarkdownCodeView$refreshText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $optimizeCode;
    final /* synthetic */ CustomMarkdownTextView $tv;
    int label;
    final /* synthetic */ ClickableMarkdownCodeView this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView$refreshText$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView$refreshText$1$1", f = "ClickableMarkdownCodeView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SpannableStringBuilder $highlightText;
        final /* synthetic */ CustomMarkdownTextView $tv;
        int label;

        public AnonymousClass1(CustomMarkdownTextView r1, SpannableStringBuilder r2, Continuation<? super AnonymousClass1> r3) {
            this.$tv = r1;
            this.$highlightText = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$tv, this.$highlightText, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$tv.setText(this.$highlightText);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ClickableMarkdownCodeView$refreshText$1(ClickableMarkdownCodeView r1, String r2, CustomMarkdownTextView r3, Continuation<? super ClickableMarkdownCodeView$refreshText$1> r4) {
        this.this$0 = r1;
        this.$optimizeCode = r2;
        this.$tv = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ClickableMarkdownCodeView$refreshText$1(this.this$0, this.$optimizeCode, this.$tv, r5);
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
        lsc.y.b r8 = new lsc.y(ClickableMarkdownCodeView.a(this.this$0).a(this.this$0.j, this.$optimizeCode)).h();
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.$tv, r8, null);
        this.label = 1;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L12;
        return r0;
    }
}
