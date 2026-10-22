package com.larus.bmhome.chat.detail.code.preview;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.mainbot.impl.databinding.LarusFragmentCodeBlockDetailBinding;
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
@DebugMetadata(c = "com.larus.bmhome.chat.detail.code.preview.CodeBlockDetailPreviewComponent$startLoading$2$1$1", f = "CodeBlockDetailPreviewComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CodeBlockDetailPreviewComponent$startLoading$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProgressBar $it;
    int label;
    final /* synthetic */ CodeBlockDetailPreviewComponent this$0;

    public CodeBlockDetailPreviewComponent$startLoading$2$1$1(CodeBlockDetailPreviewComponent r1, ProgressBar r2, Continuation<? super CodeBlockDetailPreviewComponent$startLoading$2$1$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CodeBlockDetailPreviewComponent$startLoading$2$1$1(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        CodeBlockDetailPreviewComponent r4 = this.this$0;
        int r0 = CodeBlockDetailPreviewComponent.B;
        LarusFragmentCodeBlockDetailBinding r5 = r4.d0();
        if (r5 == null) goto L9;
        TextView r6 = r5.q;
        if (r6 == null) goto L9;
        r6.setText(this.this$0.getContext().getString(2131900893));
    L9:
        ProgressBar r7 = this.$it;
        r7.setProgress(r7.getProgress() + 10);
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
