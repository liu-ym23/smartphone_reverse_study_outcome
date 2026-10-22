package io.noties.markwon.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.n;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
public class d implements n.c<Node> {
    public d() {
    }

    @Override // io.noties.markwon.n.c
    public void a(n r2, Node r3) {
        n r1 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
        r1.e(r3);
        int r4 = r1.f();
        r1.c(r3);
        r1.b(r3, r4);
        r1.f(r3);
    }
}
