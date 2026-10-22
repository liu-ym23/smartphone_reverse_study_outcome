package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f432a = null;

    public interface a {
        Object a(String r1, String[] r2, String r3);
    }

    static {
        f432a = (a) ZeusTransformUtils.preCheckCast(s.a(a.class), a.class, "com.obric.memorydata.plugin");
    }

    public static Object a(Method r3) {
        return f432a.a(r3.getName(), ae.a(r3.getParameterTypes()), r3.getReturnType().getName());
    }

    public static Set a(Collection r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        HashSet r0 = new HashSet();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.add(a((Method) ZeusTransformUtils.preCheckCast(r6.next(), Method.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        return r0;
    }
}
