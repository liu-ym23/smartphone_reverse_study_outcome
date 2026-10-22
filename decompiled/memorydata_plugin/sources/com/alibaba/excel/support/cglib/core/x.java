package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class x implements ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final x f431a = null;

    static {
        f431a = new x();
    }

    public x() {
    }

    public static x a() {
        return f431a;
    }

    @Override // com.alibaba.excel.support.cglib.core.ah
    public Object a(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Method.class) == false) goto L8;
        Member r2 = (Method) ZeusTransformUtils.preCheckCast(r3, Method.class, "com.obric.memorydata.plugin");
    L6:
        return ae.c(r2);
    L8:
        if (ZeusTransformUtils.instanceOf(r3, Constructor.class) == false) goto L11;
        r2 = (Constructor) ZeusTransformUtils.preCheckCast(r3, Constructor.class, "com.obric.memorydata.plugin");
        goto L6
    L11:
        throw new IllegalArgumentException("cannot get method info for " + r3);
    }
}
