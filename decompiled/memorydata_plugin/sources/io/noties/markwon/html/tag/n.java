package io.noties.markwon.html.tag;

import android.text.style.UnderlineSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.html.o;
import io.noties.markwon.html.u;
import io.noties.markwon.x;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: loaded from: classes6.dex */
public class n extends u {
    public n() {
    }

    @Override // io.noties.markwon.html.u
    public void a(io.noties.markwon.n r2, o r3, io.noties.markwon.html.j r4) {
        io.noties.markwon.n r1 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r2, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        io.noties.markwon.html.j r5 = (io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r4, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin");
        if (r5.g() == false) goto L5;
        a(r1, r3, r5.h());
    L5:
        x.a(r1.c(), new UnderlineSpan(), r5.b(), r5.c());
    }

    @Override // io.noties.markwon.html.u
    public Collection<String> b() {
        return Arrays.asList(new String[]{"u", "ins"});
    }
}
