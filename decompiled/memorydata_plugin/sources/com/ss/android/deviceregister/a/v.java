package com.ss.android.deviceregister.a;

import android.content.Context;
import android.content.Intent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class v extends c<com.f.a.a.a> {
    v() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.ss.android.deviceregister.a.c
    public Intent a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intent r3 = new Intent();
        r3.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return r3;
    }

    @Override // com.ss.android.deviceregister.a.c
    public w.b<com.f.a.a.a, String> a() {
        return new AnonymousClass1(this);
    }
}
