package io.noties.markwon.html.tag;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.t;
import io.noties.markwon.w;
import java.util.Arrays;
import java.util.Collection;
import org.commonmark.node.Heading;

/* JADX INFO: loaded from: classes6.dex */
public class c extends i {
    public c() {
    }

    @Override // io.noties.markwon.html.tag.i
    public Object a(io.noties.markwon.i r3, t r4, io.noties.markwon.html.j r5) {
        t r2 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        io.noties.markwon.html.j r6 = (io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r5, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin");
        w r7 = r3.f().a(Heading.class);
        if (r7 != null) goto L17;
        return null;
    L17:
        int r8 = Integer.parseInt(r6.a().substring(1));     // Catch: NumberFormatException -> L8
    L10:
        if (r8 >= 1) goto L12;
    L16:
        return null;
    L12:
        if (r8 > 6) goto L16;
        CoreProps.f.b(r2, Integer.valueOf(r8));
        return r7.a(r3, r2);
    L8:
        e = move-exception;
        e.printStackTrace();
        r8 = 0;
        goto L10
    }

    @Override // io.noties.markwon.html.u
    public Collection<String> b() {
        return Arrays.asList(new String[]{"h1", "h2", "h3", "h4", "h5", "h6"});
    }
}
