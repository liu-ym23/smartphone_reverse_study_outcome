package com.monitor.cloudmessage.b.a;

import android.content.Context;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.monitor.cloudmessage.CloudMessageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class q extends com.monitor.cloudmessage.b.a implements com.monitor.cloudmessage.f.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f5840a;

    public q() {
        this.f5840a = null;
    }

    @Override // com.monitor.cloudmessage.b.a
    public String b() {
        return "stat";
    }

    @Override // com.monitor.cloudmessage.f.a.a
    public List<String> c() {
        ArrayList r0 = new ArrayList();
        File r1 = this.f5840a;
        if (r1 == null) goto L5;
        r0.add(r1.getAbsolutePath());
    L5:
        return r0;
    }

    @Override // com.monitor.cloudmessage.b.a
    public boolean d(com.monitor.cloudmessage.entity.a r13) {
        JSONObject r0 = new JSONObject(r13.a());
        String r1 = r0.optString("type", "system_info");
        if (a(r0, r13) == false) goto L5;
        return true;
    L5:
        JSONObject r2 = new JSONObject();
        if (LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL.equals(r1) == false) goto L9;
        r2.put(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL, new com.monitor.cloudmessage.c.a.a.a().a());
    L14:
        File r3 = com.monitor.cloudmessage.c.b.a.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(CloudMessageManager.getInstance().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2);
        if (r3 != null) goto L18;
        a("系统信息文件生成失败", r13);
        return true;
    L18:
        this.f5840a = r3;
        com.monitor.cloudmessage.f.a.a(new com.monitor.cloudmessage.f.b.a("json", 0, false, r13.d(), this, null));
        return true;
    L9:
        if ("stack_info".equals(r1) == true) goto L14;
        if ("system_info".equals(r1) == false) goto L14;
        r2.put("system_info", new com.monitor.cloudmessage.c.a.a.a().a());
        goto L14
    }
}
