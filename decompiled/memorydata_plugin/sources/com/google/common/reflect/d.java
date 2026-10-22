package com.google.common.reflect;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<T> extends c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TypeVariable<?> f4790a;

    public d() {
        Type r0 = capture();
        n.a(ZeusTransformUtils.instanceOf(r0, TypeVariable.class), "%s should be a type variable.", r0);
        this.f4790a = (TypeVariable) ZeusTransformUtils.preCheckCast(r0, TypeVariable.class, "com.obric.memorydata.plugin");
    }

    public final boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L6;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin");
        return this.f4790a.equals(r4.f4790a);
    L6:
        return false;
    }

    public final int hashCode() {
        return this.f4790a.hashCode();
    }

    public String toString() {
        return this.f4790a.toString();
    }
}
