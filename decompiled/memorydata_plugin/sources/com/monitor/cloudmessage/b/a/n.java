package com.monitor.cloudmessage.b.a;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class n extends com.monitor.cloudmessage.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.monitor.cloudmessage.a.h f5838a;

    public n() {
    }

    public void a(com.monitor.cloudmessage.a.h r3) {
        this.f5838a = (com.monitor.cloudmessage.a.h) ZeusTransformUtils.wrapperContextForParams(r3, com.monitor.cloudmessage.a.h.class, "com.obric.memorydata.plugin");
    }

    @Override // com.monitor.cloudmessage.b.a
    public String b() {
        return BuildConfig.BUILD_PRODUCT_TYPE;
    }

    @Override // com.monitor.cloudmessage.b.a
    public boolean d(com.monitor.cloudmessage.entity.a r10) {
        JSONObject r0 = new JSONObject(r10.a());
        if (this.f5838a != null) goto L5;
        return false;
    L5:
        String r4 = r0.optString(ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r5 = r0.optInt("versionCode");
        String r6 = r0.optString("url");
        String r7 = r0.optString("md5");
        boolean r8 = r0.optBoolean("wifiOnly", false);
        this.f5838a.a(r4, r5, r6, r7, r8);
        com.monitor.cloudmessage.entity.b r1 = this.f5838a.b();
        if (r1.a() == false) goto L8;
        c(r10);
        return true;
    L8:
        a(r1.b(), r1.c(), r10);
        return true;
    }
}
