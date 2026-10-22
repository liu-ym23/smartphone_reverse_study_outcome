package com.larus.business.markdown.impl.markwon.c;

import android.text.style.ForegroundColorSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/visitor/BlockQuoteVisitor;", "Lio/noties/markwon/MarkwonVisitor$NodeVisitor;", "Lorg/commonmark/node/BlockQuote;", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "(Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;)V", "visit", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "blockQuote", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a implements n.c<BlockQuote> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.larus.business.markdown.api.model.c f5197a;

    public a(com.larus.business.markdown.api.model.c r2) {
        Intrinsics.checkNotNullParameter(r2, "customMarkDownInfo");
        this.f5197a = r2;
    }

    public void a(n r7, BlockQuote r8) {
        n r9 = (n) ZeusTransformUtils.wrapperContextForParams(r7, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "visitor");
        Intrinsics.checkNotNullParameter(r8, "blockQuote");
        r9.e((Node) ZeusTransformUtils.preCheckCast(r8, Node.class, "com.obric.memorydata.plugin"));
        int r0 = r9.f();
        r9.c((Node) ZeusTransformUtils.preCheckCast(r8, Node.class, "com.obric.memorydata.plugin"));
        com.larus.business.markdown.api.model.a r2 = this.f5197a.o();
        if (r2 == null) goto L7;
        Integer r3 = r2.f();
        if (r3 == null) goto L7;
        r9.c().a(new ForegroundColorSpan(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue()), r0);
    L7:
        io.noties.markwon.core.c r4 = r9.a().a();
        Intrinsics.checkNotNullExpressionValue(r4, "visitor.configuration().theme()");
        com.larus.business.markdown.api.model.a r5 = this.f5197a.o();
        int r6 = 0;
        if (r5 == null) goto L12;
        Integer r10 = r5.d();
        if (r10 == null) goto L12;
        int r11 = r10.intValue();
    L13:
        com.larus.business.markdown.api.model.a r12 = this.f5197a.o();
        if (r12 == null) goto L18;
        Integer r13 = r12.e();
        if (r13 == null) goto L18;
        r6 = r13.intValue();
    L18:
        r9.c().a(new com.larus.business.markdown.impl.markwon.custom.a.a(r4, r11, r6), r0);
        r9.f((Node) ZeusTransformUtils.preCheckCast(r8, Node.class, "com.obric.memorydata.plugin"));
        return;
    L12:
        r11 = 0;
        goto L13
    }

    @Override // io.noties.markwon.n.c
    public /* synthetic */ void a(n r3, Node r4) {
        a((n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin"), (BlockQuote) ZeusTransformUtils.preCheckCast(r4, BlockQuote.class, "com.obric.memorydata.plugin"));
    }
}
