package com.alibaba.excel.support.cglib.core.a;

import com.alibaba.excel.support.cglib.core.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class[] f360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<Class, List<t>> f361b;

    public a(Class[] r2) {
        this.f361b = new HashMap();
        this.f360a = r2;
    }

    public <T> List<T> a(Class<T> r2) {
        List<T> r1 = (List) ZeusTransformUtils.preCheckCast(this.f361b.get(r2), List.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        return Collections.emptyList();
    }

    public void a(t r9) {
        t r10 = (t) ZeusTransformUtils.wrapperContextForParams(r9, t.class, "com.obric.memorydata.plugin");
        Class<?> r0 = r10.getClass();
        Class[] r2 = this.f360a;
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L11;
        Class r5 = r2[r4];
        if (r5.isAssignableFrom(r0) == false) goto L10;
        List<t> r6 = (List) ZeusTransformUtils.preCheckCast(this.f361b.get(r5), List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L9;
        Map<Class, List<t>> r7 = this.f361b;
        ArrayList r8 = new ArrayList();
        r7.put(r5, r8);
        r6 = r8;
    L9:
        r6.add(r10);
    L10:
        r4 = r4 + 1;
        goto L3
    }
}
