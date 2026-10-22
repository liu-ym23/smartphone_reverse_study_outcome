package io.noties.markwon.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;
import org.commonmark.parser.PostProcessor;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\u0006\u001a\u00020\u00072\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002¨\u0006\r"}, d2 = {"Lio/noties/markwon/maybe/CheckMaybeNode;", "Lorg/commonmark/parser/PostProcessor;", "()V", "process", "Lorg/commonmark/node/Node;", "node", "replaceNodeWithChild", "", "Lio/noties/markwon/maybe/MaybeNode;", "visit", "lastChild", "visitChildren", "parent", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
public final class a implements PostProcessor {
    public a() {
    }

    private final void a(g<?> r1) {
        r1.insertAfter(r1.firstChild);
        r1.unlink();
    }

    private final void a(Node r2, Node r3) {
        Node r4 = r2.firstChild;
    L3:
        if (r4 == null) goto L5;
        Node r0 = r4.next;
        b(r4, r3);
        r4 = r0;
        goto L3
    }

    private final void b(Node r2, Node r3) {
        if (ZeusTransformUtils.instanceOf(r2, g.class) == false) goto L6;
        if (r2 == r3) goto L6;
        a((g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        a(r2, r3);
    }

    @Override // org.commonmark.parser.PostProcessor
    public Node process(Node r3) {
        Intrinsics.checkParameterIsNotNull(r3, "node");
        Node r0 = r3;
    L4:
        if (r0.lastChild == null) goto L7;
        r0 = r0.lastChild;
        Intrinsics.checkExpressionValueIsNotNull(r0, "lastMaybe.lastChild");
        goto L4
    L7:
        if (ZeusTransformUtils.instanceOf(r0, g.class) == false) goto L9;
    L11:
        a(r3, r0);
        return r3;
    L9:
        if (r0.parent == null) goto L11;
        r0 = r0.parent;
        Intrinsics.checkExpressionValueIsNotNull(r0, "lastMaybe.parent");
        goto L11
    }
}
