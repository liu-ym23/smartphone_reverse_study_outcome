package com.monitor.cloudmessage.b.a;

import android.text.TextUtils;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.monitor.cloudmessage.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.monitor.cloudmessage.a.a f5819a;

    public a() {
    }

    public void a(com.monitor.cloudmessage.a.a r3) {
        this.f5819a = (com.monitor.cloudmessage.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.monitor.cloudmessage.a.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.monitor.cloudmessage.b.a
    public String b() {
        return "abtest";
    }

    @Override // com.monitor.cloudmessage.b.a
    public boolean d(com.monitor.cloudmessage.entity.a r6) {
        JSONObject r0 = new JSONObject(r6.a());
        if (this.f5819a != null) goto L6;
        return false;
    L6:
        if (a(r0, r6) == false) goto L8;
        return true;
    L8:
        String r1 = r0.optString("field");
        if (TextUtils.isEmpty(r1) == false) goto L11;
        return false;
    L11:
        Object r2 = r0.get(EventBody.KEY_VALUE);
        this.f5819a.a(r1, r2);
        if (this.f5819a.a() == false) goto L14;
        String r3 = r0.optString("spKey");
        this.f5819a.b(r3, r2);
    L14:
        com.monitor.cloudmessage.entity.b r4 = this.f5819a.b();
        if (r4.a() == false) goto L17;
        c(r6);
    L18:
        return true;
    L17:
        a(r4.b(), r4.c(), r6);
        goto L18
    }
}
