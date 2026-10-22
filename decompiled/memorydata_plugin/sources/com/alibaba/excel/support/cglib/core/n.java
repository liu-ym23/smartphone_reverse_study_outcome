package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class n implements ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f395b;

    public n() {
        this.f394a = new HashSet();
        this.f395b = Collections.emptySet();
    }

    @Override // com.alibaba.excel.support.cglib.core.ab
    public boolean a(Object r3) {
        if (this.f395b.contains(r3) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f394a.add(y.a((Method) ZeusTransformUtils.preCheckCast(r3, Method.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        return true;
    }
}
