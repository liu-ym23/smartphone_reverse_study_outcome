package com.bytedance.sdk.account.d;

import android.content.Context;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.sdk.account.a.c;
import com.bytedance.sdk.account.c.f;
import com.obric.capabilitykit.entity.meta.MetaType;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends f<com.bytedance.sdk.account.a.d.a> {
    private com.bytedance.sdk.account.a.d.a d;

    private a(Context r3, com.bytedance.sdk.account.b.a r4, com.bytedance.sdk.account.a.b.a r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public static a a(Context r2, String r3, com.bytedance.sdk.account.a.b.a r4) {
        return new a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), new com.bytedance.sdk.account.b.a.C0160a().a(MemoryInfoSectionEditActivity.KIND_SCENE, r3).a(c.a.c()).a(), r4);
    }

    public com.bytedance.sdk.account.a.d.a a(boolean r2, com.bytedance.sdk.account.b.b r3) {
        com.bytedance.sdk.account.a.d.a r1 = this.d;
        if (r1 != null) goto L5;
        r1 = new com.bytedance.sdk.account.a.d.a(r2, MetaType.RELATIONSHIP);
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
        a((com.bytedance.sdk.account.a.d.a) ZeusTransformUtils.preCheckCast(r3, com.bytedance.sdk.account.a.d.a.class, "com.obric.memorydata.plugin"));
    }

    public void a(com.bytedance.sdk.account.a.d.a r3) {
        com.bytedance.sdk.account.f.a.a("passport_account_info", null, null, r3, this.c);
    }

    @Override // com.bytedance.sdk.account.c.f
    public void a(JSONObject r4, JSONObject r5) {
        com.bytedance.sdk.account.a.d.a r0 = new com.bytedance.sdk.account.a.d.a(false, MetaType.RELATIONSHIP);
        this.d = r0;
        r0.h = r5;
        String r6 = ActivityLifecycle.NAME;
        if (r4.has(ActivityLifecycle.NAME) == false) goto L5;
    L4:
        com.bytedance.sdk.account.a.d.a r3 = this.d;
        r3.k = r4.optString(r6);
        return;
    L5:
        r6 = "error_name";
        if (r4.has("error_name") == true) goto L4;
    }

    @Override // com.bytedance.sdk.account.c.f
    public /* synthetic */ com.bytedance.sdk.account.a.a.b b(boolean r1, com.bytedance.sdk.account.b.b r2) {
        return a(r1, r2);
    }

    @Override // com.bytedance.sdk.account.c.f
    public void b(JSONObject r4, JSONObject r5) {
        com.bytedance.sdk.account.a.d.a r0 = new com.bytedance.sdk.account.a.d.a(true, MetaType.RELATIONSHIP);
        this.d = r0;
        r0.h = r4;
        com.bytedance.sdk.account.a.d.a r3 = this.d;
        r3.j = com.bytedance.sdk.account.c.b.a.b(r4, r5);
    }
}
