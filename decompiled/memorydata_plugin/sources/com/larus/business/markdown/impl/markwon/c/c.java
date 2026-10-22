package com.larus.business.markdown.impl.markwon.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;
import org.commonmark.node.SoftLineBreak;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/visitor/SoftLineBreakVisitor;", "Lio/noties/markwon/MarkwonVisitor$NodeVisitor;", "Lorg/commonmark/node/SoftLineBreak;", "()V", "visit", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "n", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c implements n.c<SoftLineBreak> {
    public c() {
    }

    @Override // io.noties.markwon.n.c
    public /* synthetic */ void a(n r3, Node r4) {
        a((n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin"), (SoftLineBreak) ZeusTransformUtils.preCheckCast(r4, SoftLineBreak.class, "com.obric.memorydata.plugin"));
    }

    public void a(n r2, SoftLineBreak r3) {
        n r1 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "visitor");
        Intrinsics.checkNotNullParameter(r3, "n");
        if (r3.next == null) goto L6;
        r1.e();
        return;
    }
}
