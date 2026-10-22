package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.frameworks.baselib.network.a.a.b<c> {
    public a() {
    }

    @Override // com.bytedance.frameworks.baselib.network.a.a.b
    public /* synthetic */ com.bytedance.frameworks.baselib.network.a.a.c a(Object r1) {
        return b(r1);
    }

    @Override // com.bytedance.frameworks.baselib.network.a.a.b
    public String a() {
        return "ttnet_redirect_dp";
    }

    public c b(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L5;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin");
    L6:
        if (r2 != null) goto L8;
        return null;
    L8:
        c r4 = new c();
        boolean r0 = true;
        if (r2.intValue() == 1) goto L12;
        r0 = false;
    L12:
        r4.f2513b = r0;
        return r4;
    L5:
        r2 = null;
        goto L6
    }
}
