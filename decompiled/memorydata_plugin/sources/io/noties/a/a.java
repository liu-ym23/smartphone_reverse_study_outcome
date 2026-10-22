package io.noties.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a {
    public a() {
    }

    public abstract void a(h.d r1);

    public abstract void a(h.e r1);

    public void a(List<? extends h.b> r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        h.b r0 = (h.b) ZeusTransformUtils.preCheckCast(r5.next(), h.b.class, "com.obric.memorydata.plugin");
        if (r0.b() == true) goto L7;
        a((h.e) ZeusTransformUtils.preCheckCast(r0, h.e.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        a((h.d) ZeusTransformUtils.preCheckCast(r0, h.d.class, "com.obric.memorydata.plugin"));
        goto L4
    }
}
