package com.bytedance.applog.filter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f1596b;

    public g() {
        this.f1595a = false;
        this.f1596b = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public void a(Set<String> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        this.f1596b.addAll(r4);
    }

    public boolean a() {
        return this.f1595a;
    }
}
