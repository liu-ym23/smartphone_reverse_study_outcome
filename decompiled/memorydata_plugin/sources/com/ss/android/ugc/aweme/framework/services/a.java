package com.ss.android.ugc.aweme.framework.services;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    f f15735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Class<T> f15736b;
    g<T> c;

    a(f r3, Class<T> r4, g<T> r5) {
        g<T> r6 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
        this.f15735a = r3;
        this.f15736b = r4;
        this.c = r6;
        Set r2 = (Set) ZeusTransformUtils.preCheckCast(r3.f15748a.get(r4), Set.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        Set<g<?>> r7 = Collections.synchronizedSet(new LinkedHashSet());
        r7.add(r6);
        r3.f15748a.put(r4, r7);
        return;
    L5:
        r2.add(r6);
    }
}
