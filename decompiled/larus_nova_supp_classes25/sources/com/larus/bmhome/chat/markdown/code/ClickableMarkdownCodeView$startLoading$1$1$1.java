package com.larus.bmhome.chat.markdown.code;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.mainbot.impl.databinding.MarkdownSubRenderCodeViewLayoutBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView$startLoading$1$1$1", f = "ClickableMarkdownCodeView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ClickableMarkdownCodeView$startLoading$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProgressBar $it;
    int label;
    final /* synthetic */ ClickableMarkdownCodeView this$0;

    public ClickableMarkdownCodeView$startLoading$1$1$1(ClickableMarkdownCodeView r1, ProgressBar r2, Continuation<? super ClickableMarkdownCodeView$startLoading$1$1$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ClickableMarkdownCodeView$startLoading$1$1$1(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r4);
        ClickableMarkdownCodeView r5 = this.this$0;
        MarkdownSubRenderCodeViewLayoutBinding r0 = r5.R;
        if (r0 == null) goto L9;
        TextView r1 = r0.d;
        if (r1 == null) goto L9;
        r1.setText(r5.getContext().getString(2131900893));
    L9:
        ProgressBar r6 = this.$it;
        int r2 = r6.getProgress();
        List<String> r3 = ClickableMarkdownCodeView.H0;
        r6.setProgress(r2 + ((int) (100 * 0.1f)));
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
