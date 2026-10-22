package com.ss.android.token;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f15724a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f15725b = true;
    private static Set<String> c;

    static {
        c = Collections.synchronizedSet(new HashSet());
    }

    public static void a(Collection<String> r2) {
        Collection<String> r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (f15724a == false) goto L5;
        e.a().a(r3);
        return;
    L5:
        Set<String> r0 = c;
        if (r0 == null) goto L10;
        r0.addAll(r3);
        return;
    }
}
