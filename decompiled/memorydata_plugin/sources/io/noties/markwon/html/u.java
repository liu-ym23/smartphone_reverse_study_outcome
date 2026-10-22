package io.noties.markwon.html;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class u {
    public u() {
    }

    public static void a(io.noties.markwon.n r3, o r4, j.a r5) {
        io.noties.markwon.n r6 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        Iterator<j.a> r7 = ((j.a) ZeusTransformUtils.wrapperContextForParams(r5, j.a.class, "com.obric.memorydata.plugin")).j().iterator();
    L4:
        if (r7.hasNext() == false) goto L12;
        j.a r0 = (j.a) ZeusTransformUtils.preCheckCast(r7.next(), j.a.class, "com.obric.memorydata.plugin");
        if (r0.d() == false) goto L4;
        u r2 = r4.a(r0.a());
        if (r2 != null) goto L10;
        a(r6, r4, r0);
        goto L4
    L10:
        r2.a(r6, r4, r0);
        goto L4
    }

    public CharSequence a(j r1, g r2) {
        j r0 = (j) ZeusTransformUtils.wrapperContextForParams(r1, j.class, "com.obric.memorydata.plugin");
        return null;
    }

    public abstract void a(io.noties.markwon.n r1, o r2, j r3);

    public abstract Collection<String> b();
}
