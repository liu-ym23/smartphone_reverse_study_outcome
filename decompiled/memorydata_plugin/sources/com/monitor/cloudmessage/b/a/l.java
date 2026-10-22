package com.monitor.cloudmessage.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class l extends com.monitor.cloudmessage.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.monitor.cloudmessage.a.g f5836a;

    public l() {
    }

    public void a(com.monitor.cloudmessage.a.g r3) {
        this.f5836a = (com.monitor.cloudmessage.a.g) ZeusTransformUtils.wrapperContextForParams(r3, com.monitor.cloudmessage.a.g.class, "com.obric.memorydata.plugin");
    }

    @Override // com.monitor.cloudmessage.b.a
    public String b() {
        return "patch";
    }

    @Override // com.monitor.cloudmessage.b.a
    public boolean d(com.monitor.cloudmessage.entity.a r5) {
        JSONObject r0 = new JSONObject(r5.a());
        if (this.f5836a != null) goto L7;
        return false;
    L7:
        if (a(r0, r5) == false) goto L9;
        return true;
    L9:
        String r1 = r0.optString("url");
        String r2 = r0.optString("md5");
        this.f5836a.a(r1, r2);
        com.monitor.cloudmessage.entity.b r3 = this.f5836a.b();
        if (r3.a() == false) goto L12;
        c(r5);
    L13:
        return true;
    L12:
        a(r3.b(), r3.c(), r5);
        goto L13
    }
}
