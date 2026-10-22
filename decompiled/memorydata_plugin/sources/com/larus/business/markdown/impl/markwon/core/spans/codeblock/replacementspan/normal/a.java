package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal;

import android.content.Context;
import android.graphics.Rect;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.larus.business.markdown.api.extplugin.a.b;
import com.larus.business.markdown.api.extplugin.a.c;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016JH\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/normal/DefaultCustomCodeWidget;", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeWidget;", "()V", "markdownCodeView", "Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/normal/DefaultMarkdownCodeView;", "asView", "Landroid/view/View;", "context", "Landroid/content/Context;", "bindData", "Landroid/util/Size;", "textView", "Landroid/widget/TextView;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Landroid/text/Spanned;", "span", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeSpan;", "rect", "Landroid/graphics/Rect;", "payload", "", "", "", "maxContentWidth", "", "onReuse", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DefaultMarkdownCodeView f5223a;

    public a() {
    }

    @Override // com.larus.business.markdown.api.extplugin.a.c
    public Size a(TextView r8, Spanned r9, b r10, Rect r11, Map<String, ? extends Object> r12, int r13) {
        Spanned r14 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r9, Spanned.class, "com.obric.memorydata.plugin");
        b r15 = (b) ZeusTransformUtils.wrapperContextForParams(r10, b.class, "com.obric.memorydata.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "textView");
        Intrinsics.checkNotNullParameter(r14, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r15, "span");
        if (this.f5223a != null) goto L5;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "textView.context");
        this.f5223a = new DefaultMarkdownCodeView(r2, null, 0, 6, null);
    L5:
        DefaultMarkdownCodeView r17 = this.f5223a;
        if (r17 == null) goto L14;
        String r18 = r15.a();
        if (r18 != null) goto L10;
        r18 = "";
    L10:
        String r19 = r15.b();
        if (r19 != null) goto L13;
        r19 = "c";
    L13:
        r17.a(r18, r19, true);
    L14:
        DefaultMarkdownCodeView r20 = this.f5223a;
        int r21 = 0;
        if (r20 == null) goto L17;
        r20.measure(0, 0);
    L17:
        DefaultMarkdownCodeView r7 = this.f5223a;
        if (r7 == null) goto L21;
        r21 = r7.getMeasuredHeight();
    L21:
        return new Size(r13, r21);
    }

    @Override // com.larus.business.markdown.api.extplugin.a.c
    public View a(Context r9) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        DefaultMarkdownCodeView r8 = this.f5223a;
        if (r8 != null) goto L7;
        r8 = new DefaultMarkdownCodeView(r3, null, 0, 6, null);
    L7:
        return (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin");
    }
}
