package com.larus.bmhome.chat.detail.code.preview;

import android.widget.ProgressBar;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.detail.code.preview.CodeBlockDetailPreviewComponent$startLoading$2", f = "CodeBlockDetailPreviewComponent.kt", i = {0, 0, 1, 2}, l = {207, 215, 223}, m = "invokeSuspend", n = {"$this$launch", "it", "$this$launch", "$this$launch"}, s = {"L$0", "L$1", "L$0", "L$0"})
final class CodeBlockDetailPreviewComponent$startLoading$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CodeBlockDetailPreviewComponent this$0;

    public CodeBlockDetailPreviewComponent$startLoading$2(CodeBlockDetailPreviewComponent r1, Continuation<? super CodeBlockDetailPreviewComponent$startLoading$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CodeBlockDetailPreviewComponent$startLoading$2 r0 = new CodeBlockDetailPreviewComponent$startLoading$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ac -> B:14:0x0042). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
    L13:
        CodeBlockDetailPreviewComponent$startLoading$2 r13 = this;
    L14:
        CodeBlockDetailPreviewComponent r6 = r13.this$0;
        int r7 = CodeBlockDetailPreviewComponent.B;
        LarusFragmentCodeBlockDetailBinding r8 = r6.d0();
        if (r8 == null) goto L36;
        ProgressBar r9 = r8.p;
        if (r9 == null) goto L36;
        CodeBlockDetailPreviewComponent r10 = r13.this$0;
        l0 r11 = r10.h3();
        boolean r14 = false;
        if (r11 != null) goto L21;
    L23:
        if (r14 == false) goto L31;
        MainCoroutineDispatcher r15 = Dispatchers.getMain();
        CodeBlockDetailPreviewComponent$startLoading$2$1$1 r16 = new CodeBlockDetailPreviewComponent$startLoading$2$1$1(r10, r9, null);
        r13.L$0 = r2;
        r13.L$1 = r9;
        r13.label = 1;
        if (BuildersKt.withContext(r15, r16, r13) != r0) goto L27;
        return r0;
    L27:
        CoroutineScope r17 = r2;
        ProgressBar r3 = r9;
    L29:
        if (r3.getProgress() < 90.0f) goto L35;
        CoroutineScopeKt.cancel$default(r17, null, 1, null);
    L35:
        r2 = r17;
        goto L36
    L31:
        MainCoroutineDispatcher r18 = Dispatchers.getMain();
        CodeBlockDetailPreviewComponent$startLoading$2$1$2 r19 = new CodeBlockDetailPreviewComponent$startLoading$2$1$2(r10, r9, null);
        r13.L$0 = r2;
        r13.label = 2;
        if (BuildersKt.withContext(r18, r19, r13) != r0) goto L34;
        return r0;
    L34:
        r17 = r2;
        goto L35
    L21:
        if (r11.jW() != true) goto L23;
        r14 = true;
    L36:
        r13.L$0 = r2;
        r13.L$1 = null;
        r13.label = 3;
        if (DelayKt.delay(1000, r13) != r0) goto L14;
        return r0;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
        r13 = this;
        goto L34
    L11:
        r3 = (ProgressBar) this.L$1;
        r17 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
        r13 = this;
        goto L29
    L12:
        ResultKt.throwOnFailure(r12);
        r2 = (CoroutineScope) this.L$0;
        goto L13
    }
}
