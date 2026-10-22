package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderUrlPreviewInlines;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/movable/ParsedMovableDocument;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.coremdbiz.facade.plugins.markdown.MarkdownPlugin$prepareMarkdownSpan$1", f = "MarkdownPlugin.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
final class MarkdownPlugin$prepareMarkdownSpan$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.ss.android.lark.movable.h>, Object> {
    final /* synthetic */ MovableRenderConfig $movableRenderConfig;
    final /* synthetic */ h $renderKey;
    final /* synthetic */ MovableRenderUrlPreviewInlines $urlPreviewInlines;
    int label;

    public MarkdownPlugin$prepareMarkdownSpan$1(h r1, MovableRenderConfig r2, MovableRenderUrlPreviewInlines r3, Continuation<? super MarkdownPlugin$prepareMarkdownSpan$1> r4) {
        this.$renderKey = r1;
        this.$movableRenderConfig = r2;
        this.$urlPreviewInlines = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MarkdownPlugin$prepareMarkdownSpan$1(this.$renderKey, this.$movableRenderConfig, this.$urlPreviewInlines, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.ss.android.lark.movable.h> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MarkdownPlugin.Companion r6 = MarkdownPlugin.b;
        h r7 = this.$renderKey;
        MovableRenderConfig r2 = this.$movableRenderConfig;
        MovableRenderUrlPreviewInlines r3 = this.$urlPreviewInlines;
        this.label = 1;
        r5 = MarkdownPlugin.Companion.d(r7, r2, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
