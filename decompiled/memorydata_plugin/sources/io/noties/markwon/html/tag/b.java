package io.noties.markwon.html.tag;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.t;
import io.noties.markwon.w;
import java.util.Arrays;
import java.util.Collection;
import org.commonmark.node.Emphasis;

/* JADX INFO: loaded from: classes6.dex */
public class b extends i {
    public b() {
    }

    @Override // io.noties.markwon.html.tag.i
    public Object a(io.noties.markwon.i r2, t r3, io.noties.markwon.html.j r4) {
        t r1 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        io.noties.markwon.html.j r5 = (io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r4, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin");
        w r6 = r2.f().a(Emphasis.class);
        if (r6 != null) goto L7;
        return null;
    L7:
        return r6.a(r2, r1);
    }

    @Override // io.noties.markwon.html.u
    public Collection<String> b() {
        return Arrays.asList(new String[]{"i", "em", "cite", "dfn"});
    }
}
