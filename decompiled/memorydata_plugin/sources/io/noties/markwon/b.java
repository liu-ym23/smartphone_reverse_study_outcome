package io.noties.markwon;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
public class b implements n.a {
    public b() {
    }

    @Override // io.noties.markwon.n.a
    public void a(n r2, Node r3) {
        n r1 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
        if (r1.d(r3) == false) goto L6;
        r1.d();
        r1.e();
        return;
    }

    @Override // io.noties.markwon.n.a
    public void b(n r1, Node r2) {
        ((n) ZeusTransformUtils.wrapperContextForParams(r1, n.class, "com.obric.memorydata.plugin")).d();
    }
}
