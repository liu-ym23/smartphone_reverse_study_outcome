package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
public class aj implements ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f379b;
    private boolean c;

    public aj(Class r1, boolean r2) {
        this.f378a = r2;
        if (r1.getClassLoader() == null) goto L5;
        boolean r3 = true;
    L6:
        this.c = r3;
        this.f379b = ai.a(com.alibaba.excel.support.asm.aa.getType(r1));
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.alibaba.excel.support.cglib.core.ab
    public boolean a(Object r5) {
        Member r6 = (Member) ZeusTransformUtils.preCheckCast(r5, Member.class, "com.obric.memorydata.plugin");
        int r0 = r6.getModifiers();
        if (Modifier.isPrivate(r0) == false) goto L6;
        return false;
    L6:
        if (Modifier.isPublic(r0) == false) goto L9;
        return true;
    L9:
        if (Modifier.isProtected(r0) == false) goto L14;
        if (this.f378a == false) goto L14;
        return true;
    L14:
        if (this.c == true) goto L16;
        return false;
    L16:
        if (this.f379b.equals(ai.a(com.alibaba.excel.support.asm.aa.getType(r6.getDeclaringClass()))) == true) goto L18;
        return false;
    L18:
        return true;
    }
}
