package com.ss.android.lark.movable;

import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderUrlPreviewInlines;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.movable.MarkdownMovableView$renderMarkdown$1", f = "MarkdownMovableView.kt", i = {}, l = {107, 109}, m = "invokeSuspend", n = {}, s = {})
final class MarkdownMovableView$renderMarkdown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $markdown;
    final /* synthetic */ MovableRenderUrlPreviewInlines $urlPreviewInlines;
    final /* synthetic */ float $widthDp;
    int label;
    final /* synthetic */ MarkdownMovableView this$0;

    public MarkdownMovableView$renderMarkdown$1(MarkdownMovableView r1, String r2, float r3, MovableRenderUrlPreviewInlines r4, Continuation<? super MarkdownMovableView$renderMarkdown$1> r5) {
        this.this$0 = r1;
        this.$markdown = r2;
        this.$widthDp = r3;
        this.$urlPreviewInlines = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MarkdownMovableView$renderMarkdown$1(this.this$0, this.$markdown, this.$widthDp, this.$urlPreviewInlines, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L19:
        h r11 = (h) r10;
    L20:
        if (r11 == null) goto L22;
        this.this$0.j(r11);
        return Unit.INSTANCE;
    L22:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L15:
        r11 = (h) r10;
        goto L20
    L10:
        ResultKt.throwOnFailure(r10);
        MarkdownMovableView r12 = this.this$0;
        Function3<? super String, ? super Float, ? super Continuation<? super h>, ? extends Object> r2 = r12.F;
        if (r2 == null) goto L16;
        String r13 = this.$markdown;
        Float r3 = Boxing.boxFloat(this.$widthDp);
        this.label = 1;
        r10 = r2.invoke(r13, r3, this);
        if (r10 != r0) goto L15;
        return r0;
    L16:
        int r4 = MovableMarkdownDocumentParser.a;
        String r5 = this.$markdown;
        float r6 = this.$widthDp;
        MovableRenderConfig r7 = r12.getRenderConfig$movable_release();
        MovableRenderUrlPreviewInlines r8 = this.$urlPreviewInlines;
        this.label = 2;
        r10 = MovableMarkdownDocumentParser.c(r5, r6, r7, r8, this, 16);
        if (r10 != r0) goto L19;
        return r0;
    }
}
