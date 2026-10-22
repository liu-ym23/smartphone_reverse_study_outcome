package com.larus.business.markdown.impl.markwon;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CustomCitationClickSpan;", "it", "Lio/noties/markwon/core/spans/CustomCitationSpan;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class MarkwonContent$setCustomCitationSpansListener$1$1$1 extends Lambda implements Function1<io.noties.markwon.core.spans.g, com.larus.business.markdown.impl.markwon.core.spans.codeblock.f> {
    final /* synthetic */ com.larus.business.markdown.api.model.b $listener;

    MarkwonContent$setCustomCitationSpansListener$1$1$1(com.larus.business.markdown.api.model.b r3) {
        this.$listener = (com.larus.business.markdown.api.model.b) ZeusTransformUtils.wrapperContextForParams(r3, com.larus.business.markdown.api.model.b.class, "com.obric.memorydata.plugin");
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.larus.business.markdown.impl.markwon.core.spans.codeblock.f invoke2(io.noties.markwon.core.spans.g r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return new com.larus.business.markdown.impl.markwon.core.spans.codeblock.f(r2, this.$listener);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ com.larus.business.markdown.impl.markwon.core.spans.codeblock.f invoke(io.noties.markwon.core.spans.g r3) {
        return invoke2((io.noties.markwon.core.spans.g) ZeusTransformUtils.preCheckCast(r3, io.noties.markwon.core.spans.g.class, "com.obric.memorydata.plugin"));
    }
}
