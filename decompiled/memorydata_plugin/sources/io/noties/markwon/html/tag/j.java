package io.noties.markwon.html.tag;

import android.text.style.StrikethroughSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.html.o;
import io.noties.markwon.html.u;
import io.noties.markwon.w;
import io.noties.markwon.x;
import java.util.Arrays;
import java.util.Collection;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;

/* JADX INFO: loaded from: classes6.dex */
public class j extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f16619a = false;

    static {
        ZeusTransformUtils.forName("org.commonmark.ext.gfm.strikethrough.Strikethrough", "com.obric.memorydata.plugin");     // Catch: Throwable -> L4
        boolean r0 = true;
    L5:
        f16619a = r0;
        return;
    L4:
        r0 = false;
        goto L5
    }

    public j() {
    }

    private static Object a(io.noties.markwon.n r3) {
        io.noties.markwon.n r4 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        io.noties.markwon.i r0 = r4.a();
        w r1 = r0.f().a(Strikethrough.class);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.a(r0, r4.b());
    }

    @Override // io.noties.markwon.html.u
    public void a(io.noties.markwon.n r2, o r3, io.noties.markwon.html.j r4) {
        io.noties.markwon.n r1 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r2, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        io.noties.markwon.html.j r5 = (io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r4, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin");
        if (r5.g() == false) goto L5;
        a(r1, r3, r5.h());
    L5:
        x r6 = r1.c();
        if (f16619a == false) goto L8;
        Object r7 = a(r1);
    L9:
        x.a(r6, r7, r5.b(), r5.c());
        return;
    L8:
        r7 = new StrikethroughSpan();
        goto L9
    }

    @Override // io.noties.markwon.html.u
    public Collection<String> b() {
        return Arrays.asList(new String[]{"s", "del"});
    }
}
