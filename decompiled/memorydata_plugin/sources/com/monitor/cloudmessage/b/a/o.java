package com.monitor.cloudmessage.b.a;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class o extends com.monitor.cloudmessage.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.monitor.cloudmessage.a.i f5839a;

    public o() {
        this.f5839a = null;
    }

    public void a(com.monitor.cloudmessage.a.i r3) {
        this.f5839a = (com.monitor.cloudmessage.a.i) ZeusTransformUtils.wrapperContextForParams(r3, com.monitor.cloudmessage.a.i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.monitor.cloudmessage.b.a
    public String b() {
        return "route";
    }

    @Override // com.monitor.cloudmessage.b.a
    public boolean d(com.monitor.cloudmessage.entity.a r4) {
        String r0 = new JSONObject(r4.a()).optString("schema");
        if (TextUtils.isEmpty(r0) == false) goto L6;
        a("路由scheme为空", r4);
        return true;
    L6:
        com.monitor.cloudmessage.a.i r1 = this.f5839a;
        if (r1 == null) goto L13;
        r1.a(r0);
        com.monitor.cloudmessage.entity.b r2 = this.f5839a.b();
        if (r2.a() == false) goto L11;
        c(r4);
    L12:
        return true;
    L11:
        a(r2.b(), r2.c(), r4);
        goto L12
    L13:
        return false;
    }
}
