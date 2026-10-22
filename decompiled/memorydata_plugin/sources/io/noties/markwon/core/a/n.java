package io.noties.markwon.core.a;

import android.text.style.ParagraphStyle;
import com.larus.business.markdown.api.model.ThematicBreakConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.spans.u;
import io.noties.markwon.t;
import io.noties.markwon.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/core/factory/ThematicBreakSpanFactory2;", "Lio/noties/markwon/SpanFactory;", "thematicBreakConfig", "Lcom/larus/business/markdown/api/model/ThematicBreakConfig;", "(Lcom/larus/business/markdown/api/model/ThematicBreakConfig;)V", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "props", "Lio/noties/markwon/RenderProps;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class n implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThematicBreakConfig f16424a;

    public n(ThematicBreakConfig r1) {
        this.f16424a = r1;
    }

    @Override // io.noties.markwon.w
    public Object a(io.noties.markwon.i r4, t r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "configuration");
        Intrinsics.checkNotNullParameter(r6, "props");
        ThematicBreakConfig r3 = this.f16424a;
        if (r3 == null) goto L9;
        Integer r7 = r3.getHeight();
        if (r7 == null) goto L9;
        int r8 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r8 <= 0) goto L9;
    L11:
        return new ParagraphStyle[]{(ParagraphStyle) ZeusTransformUtils.preCheckCast(new u(r4.a()), ParagraphStyle.class, "com.obric.memorydata.plugin"), (ParagraphStyle) ZeusTransformUtils.preCheckCast(io.noties.markwon.f.a.f16541a.b(r8), ParagraphStyle.class, "com.obric.memorydata.plugin")};
    L9:
        r8 = com.larus.business.markdown.impl.common.utils.c.a();
        goto L11
    }
}
