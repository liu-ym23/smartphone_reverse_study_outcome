package com.bytedance.sdk.account;

import android.content.Context;
import com.bytedance.sdk.account.c.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends f<com.bytedance.sdk.account.a.a.c> {
    private String d;
    private com.bytedance.sdk.account.g.a e;

    private a(Context r3, com.bytedance.sdk.account.b.a r4, String r5, com.bytedance.sdk.account.a.a.a<com.bytedance.sdk.account.a.a.c> r6) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r6);
        this.e = new com.bytedance.sdk.account.g.a();
        this.d = r5;
    }

    public static a a(Context r2, String r3, Map r4, com.bytedance.sdk.account.a.a.a<com.bytedance.sdk.account.a.a.c> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        return new a(r6, new com.bytedance.sdk.account.b.a.C0160a().a(com.bytedance.sdk.account.a.c.a.b()).a("logout_from", r3).a(r7).b(), r3, r5);
    }

    public com.bytedance.sdk.account.a.a.c a(boolean r2, com.bytedance.sdk.account.b.b r3) {
        com.bytedance.sdk.account.a.a.c r4 = new com.bytedance.sdk.account.a.a.c(r2, 10001);
        if (r2 == false) goto L5;
        r4.a(this.e.c);
    L6:
        r4.j = this.d;
        return r4;
    L5:
        r4.d = this.e.f3121a;
        r4.f = this.e.f3122b;
        goto L6
    }

    @Override // com.bytedance.sdk.account.c.f
    public /* synthetic */ void a(com.bytedance.sdk.account.a.a.b r3) {
        a((com.bytedance.sdk.account.a.a.c) ZeusTransformUtils.preCheckCast(r3, com.bytedance.sdk.account.a.a.c.class, "com.obric.memorydata.plugin"));
    }

    public void a(com.bytedance.sdk.account.a.a.c r3) {
        com.bytedance.sdk.account.f.a.a("passport_logout", null, null, r3, this.c);
    }

    @Override // com.bytedance.sdk.account.c.f
    public void a(JSONObject r1, JSONObject r2) {
        com.bytedance.sdk.account.c.b.a(this.e, r1, r2);
    }

    @Override // com.bytedance.sdk.account.c.f
    public /* synthetic */ com.bytedance.sdk.account.a.a.b b(boolean r1, com.bytedance.sdk.account.b.b r2) {
        return a(r1, r2);
    }

    @Override // com.bytedance.sdk.account.c.f
    public void b(JSONObject r1, JSONObject r2) {
        com.bytedance.sdk.account.g.a r0 = this.e;
        r0.c = r1.optString("session_key");
    }
}
