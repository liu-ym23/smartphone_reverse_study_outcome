package com.larus.bmhome.chat.detail.code.preview;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.detail.code.l0;
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
@DebugMetadata(c = "com.larus.bmhome.chat.detail.code.preview.CodeBlockDetailPreviewComponent$startLoading$2$1$2", f = "CodeBlockDetailPreviewComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CodeBlockDetailPreviewComponent$startLoading$2$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProgressBar $it;
    int label;
    final /* synthetic */ CodeBlockDetailPreviewComponent this$0;

    public CodeBlockDetailPreviewComponent$startLoading$2$1$2(CodeBlockDetailPreviewComponent r1, ProgressBar r2, Continuation<? super CodeBlockDetailPreviewComponent$startLoading$2$1$2> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CodeBlockDetailPreviewComponent$startLoading$2$1$2(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r3);
        CodeBlockDetailPreviewComponent r4 = this.this$0;
        int r0 = CodeBlockDetailPreviewComponent.B;
        LarusFragmentCodeBlockDetailBinding r5 = r4.d0();
        if (r5 == null) goto L10;
        TextView r6 = r5.q;
        if (r6 == null) goto L10;
        r6.setText(this.this$0.getContext().getString(2131900892));
    L10:
        if (this.$it.getProgress() >= 70.0f) goto L19;
        l0 r7 = this.this$0.h3();
        boolean r1 = false;
        if (r7 != null) goto L14;
    L16:
        if (r1 == false) goto L19;
        ProgressBar r8 = this.$it;
        r8.setProgress(r8.getProgress() + 10);
        goto L19
    L14:
        if (r7.Vo() != true) goto L16;
        r1 = true;
    L19:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
