package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import android.text.style.ClickableSpan;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CustomCitationClickSpan;", "Landroid/text/style/ClickableSpan;", "span", "Lio/noties/markwon/core/spans/CustomCitationSpan;", "listener", "Lcom/larus/business/markdown/api/model/CitationSpanClickListener;", "(Lio/noties/markwon/core/spans/CustomCitationSpan;Lcom/larus/business/markdown/api/model/CitationSpanClickListener;)V", "onClick", "", "widget", "Landroid/view/View;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.markwon.core.spans.g f5210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.larus.business.markdown.api.model.b f5211b;

    public f(io.noties.markwon.core.spans.g r3, com.larus.business.markdown.api.model.b r4) {
        com.larus.business.markdown.api.model.b r5 = (com.larus.business.markdown.api.model.b) ZeusTransformUtils.wrapperContextForParams(r4, com.larus.business.markdown.api.model.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "span");
        this.f5210a = r3;
        this.f5211b = r5;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        this.f5210a.a(r3);
        com.larus.business.markdown.api.model.b r4 = this.f5211b;
        if (r4 == null) goto L6;
        r4.a((com.larus.business.markdown.api.model.d) ZeusTransformUtils.preCheckCast(this.f5210a, com.larus.business.markdown.api.model.d.class, "com.obric.memorydata.plugin"));
        return;
    }
}
