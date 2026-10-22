package io.noties.markwon.html.tag;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.html.o;
import io.noties.markwon.html.u;
import io.noties.markwon.t;
import io.noties.markwon.x;

/* JADX INFO: loaded from: classes6.dex */
public abstract class i extends u {
    public i() {
    }

    public abstract Object a(io.noties.markwon.i r1, t r2, io.noties.markwon.html.j r3);

    @Override // io.noties.markwon.html.u
    public void a(io.noties.markwon.n r3, o r4, io.noties.markwon.html.j r5) {
        io.noties.markwon.n r6 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        io.noties.markwon.html.j r7 = (io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r5, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin");
        if (r7.g() == false) goto L5;
        a(r6, r4, r7.h());
    L5:
        Object r2 = a(r6.a(), r6.b(), r7);
        if (r2 == null) goto L9;
        x.a(r6.c(), r2, r7.b(), r7.c());
        return;
    }
}
