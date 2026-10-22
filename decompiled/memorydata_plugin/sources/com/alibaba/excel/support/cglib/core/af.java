package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Member;

/* JADX INFO: loaded from: classes.dex */
public class af implements ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f373a;

    public af(int r1) {
        this.f373a = r1;
    }

    @Override // com.alibaba.excel.support.cglib.core.ab
    public boolean a(Object r3) {
        int r4 = ((Member) ZeusTransformUtils.preCheckCast(r3, Member.class, "com.obric.memorydata.plugin")).getModifiers();
        if ((this.f373a & r4) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
