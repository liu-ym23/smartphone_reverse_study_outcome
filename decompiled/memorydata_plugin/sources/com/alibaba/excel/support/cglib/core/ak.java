package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class ak<T> extends WeakReference<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f380a;

    public ak(T r1) {
        super(r1);
        this.f380a = r1.hashCode();
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ak.class) == true) goto L5;
        return false;
    L5:
        Object r3 = get();
        Object r5 = ((ak) ZeusTransformUtils.preCheckCast(r4, ak.class, "com.obric.memorydata.plugin")).get();
        if (r3 == null) goto L12;
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r3.equals(r5) == false) goto L14;
        return true;
    L14:
        return false;
    L12:
        return false;
    }

    public int hashCode() {
        return this.f380a;
    }

    public String toString() {
        Object r0 = get();
        if (r0 != null) goto L6;
        return "Clean WeakIdentityKey, hash: " + this.f380a;
    L6:
        return r0.toString();
    }
}
