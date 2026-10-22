package com.bytedance.sdk.account.c;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class c implements com.bytedance.sdk.account.a.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f3107a;

    public c(Context r3) {
        this.f3107a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.sdk.account.a.e
    public void a(String r1, com.bytedance.sdk.account.a.b.a r2) {
        com.bytedance.sdk.account.d.a.a(this.f3107a, r1, r2).c();
    }

    @Override // com.bytedance.sdk.account.a.e
    public void a(String r3, Map r4, com.bytedance.sdk.account.a.a.a<com.bytedance.sdk.account.a.a.c> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        com.bytedance.sdk.account.a.a(this.f3107a, r3, r6, r5).c();
    }
}
