package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static Collection a(Collection r2, ab r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        ab r5 = (ab) ZeusTransformUtils.wrapperContextForParams(r3, ab.class, "com.obric.memorydata.plugin");
        Iterator r0 = r4.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r5.a(r0.next()) == true) goto L4;
        r0.remove();
        goto L4
    L8:
        return r4;
    }

    public static Map a(Collection r6, ah r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        ah r9 = (ah) ZeusTransformUtils.wrapperContextForParams(r7, ah.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        Iterator r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Object r2 = r10.next();
        Object r3 = r9.a(r2);
        List r4 = (List) ZeusTransformUtils.preCheckCast(r0.get(r3), List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        r4 = new LinkedList();
        r0.put(r3, r4);
    L8:
        r4.add(r2);
        goto L4
    L9:
        return r0;
    }

    public static Map a(List r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        Iterator r7 = r6.iterator();
        int r1 = 0;
    L4:
        if (r7.hasNext() == false) goto L6;
        r0.put(r7.next(), new Integer(r1));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static void a(Map r3, Map r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Iterator r0 = r5.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Object r1 = r0.next();
        r6.put(r5.get(r1), r1);
        goto L4
    }

    public static List b(Collection r2, ah r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        ah r5 = (ah) ZeusTransformUtils.wrapperContextForParams(r3, ah.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList(r4.size());
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.add(r5.a(r6.next()));
        goto L4
    L6:
        return r0;
    }
}
