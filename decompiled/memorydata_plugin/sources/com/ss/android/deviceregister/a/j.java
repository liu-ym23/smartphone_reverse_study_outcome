package com.ss.android.deviceregister.a;

import android.content.Context;
import android.content.Intent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class j extends c<com.g.a.a> {
    j() {
        super("com.zui.deviceidservice");
    }

    @Override // com.ss.android.deviceregister.a.c
    public Intent a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intent r3 = new Intent();
        r3.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return r3;
    }

    @Override // com.ss.android.deviceregister.a.c
    public w.b<com.g.a.a, String> a() {
        return new AnonymousClass1(this);
    }
}
