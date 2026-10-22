package io.noties.markwon.html.tag;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.html.o;
import io.noties.markwon.html.u;
import io.noties.markwon.w;
import io.noties.markwon.x;
import java.util.Collection;
import java.util.Collections;
import org.commonmark.node.BlockQuote;

/* JADX INFO: loaded from: classes6.dex */
public class a extends u {
    public a() {
    }

    @Override // io.noties.markwon.html.u
    public void a(io.noties.markwon.n r2, o r3, io.noties.markwon.html.j r4) {
        io.noties.markwon.n r1 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r2, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        io.noties.markwon.html.j r5 = (io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r4, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin");
        if (r5.g() == false) goto L5;
        a(r1, r3, r5.h());
    L5:
        io.noties.markwon.i r6 = r1.a();
        w r7 = r6.f().a(BlockQuote.class);
        if (r7 == null) goto L9;
        x.a(r1.c(), r7.a(r6, r1.b()), r5.b(), r5.c());
        return;
    }

    @Override // io.noties.markwon.html.u
    public Collection<String> b() {
        return Collections.singleton("blockquote");
    }
}
