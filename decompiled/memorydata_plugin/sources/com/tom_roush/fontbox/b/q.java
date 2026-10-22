package com.tom_roush.fontbox.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class q {
    public q() {
    }

    public List<Number> a(List<Object> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        Object r2 = r7.next();
        if (ZeusTransformUtils.instanceOf(r2, p.class) == true) goto L7;
        r0.add((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        List<Number> r3 = a(r0, (p) ZeusTransformUtils.preCheckCast(r2, p.class, "com.obric.memorydata.plugin"));
        r0.clear();
        if (r3 == null) goto L4;
        r0.addAll(r3);
        goto L4
    L11:
        return r0;
    }

    public abstract List<Number> a(List<Number> r1, p r2);
}
