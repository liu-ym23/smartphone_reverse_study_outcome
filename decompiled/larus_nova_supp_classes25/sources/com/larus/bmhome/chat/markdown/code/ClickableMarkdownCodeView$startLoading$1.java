package com.larus.bmhome.chat.markdown.code;

import android.widget.ProgressBar;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView$startLoading$1", f = "ClickableMarkdownCodeView.kt", i = {0, 0, 1, 2}, l = {1602, 1610, 1618}, m = "invokeSuspend", n = {"$this$launch", "it", "$this$launch", "$this$launch"}, s = {"L$0", "L$1", "L$0", "L$0"})
final class ClickableMarkdownCodeView$startLoading$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ClickableMarkdownCodeView this$0;

    public ClickableMarkdownCodeView$startLoading$1(ClickableMarkdownCodeView r1, Continuation<? super ClickableMarkdownCodeView$startLoading$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ClickableMarkdownCodeView$startLoading$1 r0 = new ClickableMarkdownCodeView$startLoading$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a0 -> B:14:0x0041). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
    L13:
        ClickableMarkdownCodeView$startLoading$1 r12 = this;
    L14:
        ClickableMarkdownCodeView r6 = r12.this$0;
        MarkdownSubRenderCodeViewLayoutBinding r7 = r6.R;
        if (r7 == null) goto L32;
        ProgressBar r8 = r7.h;
        if (r8 == null) goto L32;
        if (r6.q == false) goto L27;
        MainCoroutineDispatcher r9 = Dispatchers.getMain();
        ClickableMarkdownCodeView$startLoading$1$1$1 r10 = new ClickableMarkdownCodeView$startLoading$1$1$1(r6, r8, null);
        r12.L$0 = r2;
        r12.L$1 = r8;
        r12.label = 1;
        if (BuildersKt.withContext(r9, r10, r12) != r0) goto L23;
        return r0;
    L23:
        CoroutineScope r13 = r2;
        ProgressBar r3 = r8;
    L24:
        float r4 = r3.getProgress();
        List<String> r14 = ClickableMarkdownCodeView.H0;
        if (r4 < (100 * 0.9f)) goto L31;
        CoroutineScopeKt.cancel$default(r13, null, 1, null);
    L31:
        r2 = r13;
        goto L32
    L27:
        MainCoroutineDispatcher r15 = Dispatchers.getMain();
        ClickableMarkdownCodeView$startLoading$1$1$2 r16 = new ClickableMarkdownCodeView$startLoading$1$1$2(r6, r8, null);
        r12.L$0 = r2;
        r12.label = 2;
        if (BuildersKt.withContext(r15, r16, r12) != r0) goto L30;
        return r0;
    L30:
        r13 = r2;
    L32:
        r12.L$0 = r2;
        r12.L$1 = null;
        r12.label = 3;
        if (DelayKt.delay(1000, r12) != r0) goto L14;
        return r0;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
        r12 = this;
        goto L30
    L11:
        r3 = (ProgressBar) this.L$1;
        r13 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
        r12 = this;
        goto L24
    L12:
        ResultKt.throwOnFailure(r11);
        r2 = (CoroutineScope) this.L$0;
        goto L13
    }
}
