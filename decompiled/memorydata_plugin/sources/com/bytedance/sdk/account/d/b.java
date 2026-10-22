package com.bytedance.sdk.account.d;

import android.content.Context;
import com.bytedance.sdk.account.a.d.c;
import com.bytedance.sdk.account.c.f;
import com.obric.capabilitykit.entity.meta.MetaType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b extends f<c> {
    private c d;

    private b(Context r3, com.bytedance.sdk.account.b.a r4, com.bytedance.sdk.account.a.b.b r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public static b a(Context r2, String r3, com.bytedance.sdk.account.a.b.b r4) {
        return new b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), new com.bytedance.sdk.account.b.a.C0160a().a(r3).a(), r4);
    }

    public c a(boolean r2, com.bytedance.sdk.account.b.b r3) {
        c r1 = this.d;
        if (r1 != null) goto L5;
        r1 = new c(r2, MetaType.Cover);
    L6:
        if (r2 == true) goto L8;
        r1.d = r3.f3104b;
        r1.f = r3.c;
    L8:
        return r1;
    L5:
        r1.f3096b = r2;
        goto L6
    }

    @Override // com.bytedance.sdk.account.c.f
    public /* synthetic */ void a(com.bytedance.sdk.account.a.a.b r3) {
        a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"));
    }

    public void a(c r3) {
        com.bytedance.sdk.account.f.a.a("passport_token_beat_v2", null, null, r3, this.c);
    }

    @Override // com.bytedance.sdk.account.c.f
    public void a(JSONObject r4, JSONObject r5) {
        c r0 = new c(false, MetaType.Cover);
        this.d = r0;
        r0.h = r5;
        c r3 = this.d;
        r3.j = r4.optString("error_name");
    }

    @Override // com.bytedance.sdk.account.c.f
    public /* synthetic */ com.bytedance.sdk.account.a.a.b b(boolean r1, com.bytedance.sdk.account.b.b r2) {
        return a(r1, r2);
    }

    @Override // com.bytedance.sdk.account.c.f
    public void b(JSONObject r3, JSONObject r4) {
        c r5 = new c(true, MetaType.Cover);
        this.d = r5;
        r5.h = r3;
    }
}
