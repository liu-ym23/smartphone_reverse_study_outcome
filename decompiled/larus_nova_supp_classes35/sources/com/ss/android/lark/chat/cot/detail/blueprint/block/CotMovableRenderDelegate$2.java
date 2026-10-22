package com.ss.android.lark.chat.cot.detail.blueprint.block;

import com.ss.android.lark.movable.MarkdownMovableView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class CotMovableRenderDelegate$2 extends AdaptedFunctionReference implements Function2<String, Float, Unit> {
    public CotMovableRenderDelegate$2(Object r8) {
        super(2, r8, MarkdownMovableView.class, "renderMarkdown", "renderMarkdown(Ljava/lang/String;FLcom/bytedance/lark/lark_markdown_render_android/MovableRenderUrlPreviewInlines;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, ((Number) r2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String r2, float r3) {
        MarkdownMovableView.k((MarkdownMovableView) ((AdaptedFunctionReference) this).receiver, r2, r3);
    }
}
