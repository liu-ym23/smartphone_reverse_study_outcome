package io.noties.markwon.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.n;
import org.commonmark.node.Node;
import org.commonmark.node.Visitor;

/* JADX INFO: loaded from: classes6.dex */
public class g<Target> extends Node {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Target f16650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<? super Target> f16651b;

    public g(Target r2) {
        this(r2, r2.getClass());
    }

    public g(Target r1, Class<? super Target> r2) {
        this.f16650a = r1;
        this.f16651b = r2;
    }

    @Override // org.commonmark.node.Node
    public void accept(Visitor r3) {
        Visitor r4 = (Visitor) ZeusTransformUtils.wrapperContextForParams(r3, Visitor.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, n.class) == false) goto L8;
        n r0 = (n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.memorydata.plugin");
        n.c<Node> r1 = r0.a(this);
        if (r1 == null) goto L8;
        r1.a(r0, this);
        return;
    L8:
        Node r2 = getFirstChild();
    L9:
        if (r2 == null) goto L11;
        Node r5 = r2.getNext();
        r2.accept(r4);
        r2 = r5;
        goto L9
    }
}
