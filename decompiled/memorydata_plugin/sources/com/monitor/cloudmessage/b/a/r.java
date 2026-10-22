package com.monitor.cloudmessage.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.monitor.cloudmessage.CloudMessageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class r extends com.monitor.cloudmessage.b.a implements com.monitor.cloudmessage.f.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.monitor.cloudmessage.a.j f5841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f5842b;

    public r() {
        this.f5842b = null;
    }

    public void a(com.monitor.cloudmessage.a.j r3) {
        this.f5841a = (com.monitor.cloudmessage.a.j) ZeusTransformUtils.wrapperContextForParams(r3, com.monitor.cloudmessage.a.j.class, "com.obric.memorydata.plugin");
    }

    @Override // com.monitor.cloudmessage.b.a
    public String b() {
        return "custom";
    }

    @Override // com.monitor.cloudmessage.f.a.a
    public List<String> c() {
        ArrayList r0 = new ArrayList(1);
        File r2 = this.f5842b;
        if (r2 == null) goto L5;
        r0.add(r2.getAbsolutePath());
    L5:
        return r0;
    }

    @Override // com.monitor.cloudmessage.b.a
    public boolean d(com.monitor.cloudmessage.entity.a r14) {
        String r0 = r14.a();
        if (this.f5841a != null) goto L6;
        return false;
    L6:
        JSONObject r1 = new JSONObject(r0);
        if (a(r1, r14) == false) goto L9;
        return true;
    L9:
        JSONObject r2 = r1.optJSONObject("template");
        if (r2 != null) goto L14;
        String r3 = "template字段异常";
    L12:
        a(r3, r14);
        return true;
    L14:
        r1.put("cloud_command_id", r14.d());
        String r4 = this.f5841a.a(r2);
        com.monitor.cloudmessage.entity.b r5 = this.f5841a.b();
        if (r5.a() == true) goto L17;
        a(r5.b(), r5.c(), r14);
    L24:
        return true;
    L17:
        if (TextUtils.isEmpty(r4) == false) goto L19;
        r4 = "{\"result\" : \"no one handle it.\"}";
    L19:
        File r6 = com.monitor.cloudmessage.c.b.a.i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(CloudMessageManager.getInstance().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        if (r6 != null) goto L22;
        r3 = "template文件生成异常";
        goto L12
    L22:
        this.f5842b = r6;
        com.monitor.cloudmessage.f.a.a(new com.monitor.cloudmessage.f.b.a(r1.optString("fileContentType", "template_file_type"), 0, false, r14.d(), this, r5.c()));
        goto L24
    }
}
