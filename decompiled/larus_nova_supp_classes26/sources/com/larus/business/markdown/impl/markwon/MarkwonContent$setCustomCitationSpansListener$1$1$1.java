package com.larus.business.markdown.impl.markwon;

import com.larus.business.markdown.impl.markwon.core.spans.codeblock.f;
import io.noties.markwon.core.spans.CustomCitationSpan;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/noties/markwon/core/spans/CustomCitationSpan;", "it", "Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/f;", "invoke", "(Lio/noties/markwon/core/spans/CustomCitationSpan;)Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/f;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class MarkwonContent$setCustomCitationSpansListener$1$1$1 extends Lambda implements Function1<CustomCitationSpan, f> {
    final /* synthetic */ lw8.b $listener;

    public MarkwonContent$setCustomCitationSpansListener$1$1$1(lw8.b r1) {
        this.$listener = r1;
        super(1);
    }

    public final f invoke(CustomCitationSpan r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        return new f(r3, this.$listener);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((CustomCitationSpan) r1);
    }
}
