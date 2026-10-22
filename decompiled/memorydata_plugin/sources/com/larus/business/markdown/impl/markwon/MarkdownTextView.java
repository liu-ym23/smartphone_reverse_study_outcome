package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0000H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/MarkdownTextView;", "Lcom/larus/business/markdown/impl/markwon/UnderlineTextView;", "Lcom/larus/business/markdown/api/view/text/IMarkdownTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "markdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "getMarkdownContent", "()Lcom/larus/business/markdown/api/model/MarkdownContent;", "markdownWidth", "getMarkdownWidth", "()I", "setMarkdownWidth", "(I)V", "markwonContent", "Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "asTextView", "getSelectedColor", "isSelected", "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "setMarkdown", "", Params.CONTENT, "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MarkdownTextView extends UnderlineTextView implements com.larus.business.markdown.api.c.a.a {
    private int markdownWidth;
    private e markwonContent;

    public MarkdownTextView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public MarkdownTextView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public MarkdownTextView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
    }

    public /* synthetic */ MarkdownTextView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    @Override // com.larus.business.markdown.api.c.a.a
    public /* synthetic */ TextView asTextView() {
        return (TextView) ZeusTransformUtils.preCheckCast(asTextView(), TextView.class, "com.obric.memorydata.plugin");
    }

    @Override // com.larus.business.markdown.api.c.a.a
    public MarkdownTextView asTextView() {
        return this;
    }

    public com.larus.business.markdown.api.model.h getMarkdownContent() {
        return (com.larus.business.markdown.api.model.h) ZeusTransformUtils.preCheckCast(this.markwonContent, com.larus.business.markdown.api.model.h.class, "com.obric.memorydata.plugin");
    }

    @Override // com.larus.business.markdown.api.c.a.a
    public int getMarkdownWidth() {
        return this.markdownWidth;
    }

    @Override // com.larus.business.markdown.api.c.a.a
    public int getSelectedColor() {
        return 1719254015;
    }

    @Override // com.larus.business.markdown.api.c.a.a
    public boolean isSelected(int r1, int r2) {
        return false;
    }

    public void setMarkdown(com.larus.business.markdown.api.model.h r6) {
        com.larus.business.markdown.api.model.h r7 = (com.larus.business.markdown.api.model.h) ZeusTransformUtils.wrapperContextForParams(r6, com.larus.business.markdown.api.model.h.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L12;
        if (ZeusTransformUtils.instanceOf(r7, e.class) == true) goto L12;
        com.larus.business.markdown.api.depend.f r2 = com.larus.business.markdown.api.depend.g.a();
        if (r2 == null) goto L10;
        r2.e("mark_down", "unsupport markdown: " + r7);
    L10:
        Object r8 = ZeusTransformUtils.preCheckCast(null, e.class, "com.obric.memorydata.plugin");
    L14:
        e r9 = (e) r8;
    L16:
        this.markwonContent = r9;
        if (r9 == null) goto L27;
        SpannableStringBuilder r3 = r9.a();
        if (r3 == null) goto L30;
        com.larus.business.markdown.api.model.e r10 = r9.d();
        if (r10 == null) goto L28;
        io.noties.markwon.g r11 = r10.a();
        if (r11 == null) goto L29;
        r11.a((TextView) ZeusTransformUtils.preCheckCast(this, TextView.class, "com.obric.memorydata.plugin"), (Spanned) ZeusTransformUtils.preCheckCast(r3, Spanned.class, "com.obric.memorydata.plugin"), null);
        return;
    L29:
        return;
    L28:
        return;
    L30:
        return;
    L27:
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r7, e.class) == false) goto L15;
        r8 = ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.memorydata.plugin");
        goto L14
    L15:
        r9 = null;
        goto L16
    }

    public void setMarkdownWidth(int r1) {
        this.markdownWidth = r1;
    }
}
