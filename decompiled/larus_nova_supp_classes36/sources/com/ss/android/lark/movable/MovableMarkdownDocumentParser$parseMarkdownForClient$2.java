package com.ss.android.lark.movable;

import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderUrlPreviewInlines;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.movable.attatchment.m;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/movable/ParsedMovableDocument;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.movable.MovableMarkdownDocumentParser$parseMarkdownForClient$2", f = "MovableDocumentParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MovableMarkdownDocumentParser$parseMarkdownForClient$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
    final /* synthetic */ Function2<String, Float, m> $imageMeasureSizeResolver;
    final /* synthetic */ String $markdown;
    final /* synthetic */ MovableRenderConfig $movableRenderConfig;
    final /* synthetic */ MovableRenderUrlPreviewInlines $urlPreviewInlines;
    final /* synthetic */ float $widthDp;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MovableMarkdownDocumentParser$parseMarkdownForClient$2(String r1, float r2, MovableRenderConfig r3, MovableRenderUrlPreviewInlines r4, Function2<? super String, ? super Float, m> r5, Continuation<? super MovableMarkdownDocumentParser$parseMarkdownForClient$2> r6) {
        this.$markdown = r1;
        this.$widthDp = r2;
        this.$movableRenderConfig = r3;
        this.$urlPreviewInlines = r4;
        this.$imageMeasureSizeResolver = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MovableMarkdownDocumentParser$parseMarkdownForClient$2(this.$markdown, this.$widthDp, this.$movableRenderConfig, this.$urlPreviewInlines, this.$imageMeasureSizeResolver, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super h> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        int r6 = MovableMarkdownDocumentParser.a;
        return MovableMarkdownDocumentParser.a(this.$markdown, this.$widthDp, this.$movableRenderConfig, this.$urlPreviewInlines, this.$imageMeasureSizeResolver);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
