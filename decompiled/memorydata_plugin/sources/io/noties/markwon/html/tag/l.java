package io.noties.markwon.html.tag;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.t;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes6.dex */
public class l extends i {
    public l() {
    }

    @Override // io.noties.markwon.html.tag.i
    public Object a(io.noties.markwon.i r1, t r2, io.noties.markwon.html.j r3) {
        t r0 = (t) ZeusTransformUtils.wrapperContextForParams(r2, t.class, "com.obric.memorydata.plugin");
        io.noties.markwon.html.j r4 = (io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin");
        return new io.noties.markwon.html.b.a();
    }

    @Override // io.noties.markwon.html.u
    public Collection<String> b() {
        return Collections.singleton("sub");
    }
}
