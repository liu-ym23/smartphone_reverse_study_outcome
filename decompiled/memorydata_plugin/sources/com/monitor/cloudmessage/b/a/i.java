package com.monitor.cloudmessage.b.a;

import android.content.Context;
import com.bytedance.apm.util.w;
import com.monitor.cloudmessage.CloudMessageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class i extends com.monitor.cloudmessage.b.a implements com.monitor.cloudmessage.f.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f5834a;

    public i() {
        this.f5834a = null;
    }

    @Override // com.monitor.cloudmessage.b.a
    public String b() {
        return "net_flow";
    }

    @Override // com.monitor.cloudmessage.f.a.a
    public List<String> c() {
        ArrayList r0 = new ArrayList();
        File r1 = this.f5834a;
        if (r1 == null) goto L5;
        r0.add(r1.getAbsolutePath());
    L5:
        return r0;
    }

    @Override // com.monitor.cloudmessage.b.a
    public boolean d(com.monitor.cloudmessage.entity.a r20) {
        JSONObject r0 = new JSONObject(r20.a());
        if (a(r0, r20) == false) goto L5;
        return true;
    L5:
        long r2 = r0.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000);
        long r10 = r0.optLong("fetch_end_time", System.currentTimeMillis() / 1000);
        long r3 = r2 * 1000;
        long r4 = 1000 * r10;
        long r11 = w.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(CloudMessageManager.getInstance().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r4, 1);
        long r5 = w.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(CloudMessageManager.getInstance().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r4, 0);
        JSONObject r6 = new JSONObject();
        r6.put("netStatsWifi", r11);     // Catch: JSONException -> L8
        r6.put("netStatsMobile", r5);     // Catch: JSONException -> L8
        r6.put("netStatsTotal", r5 + r11);     // Catch: JSONException -> L8
    L10:
        File r1 = com.monitor.cloudmessage.c.b.a.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(CloudMessageManager.getInstance().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r6);
        if (r1 != null) goto L14;
        a("网络流量信息文件生成失败", r20);
        return true;
    L14:
        this.f5834a = r1;
        com.monitor.cloudmessage.f.a.a(new com.monitor.cloudmessage.f.b.a("json", 0, false, r20.d(), this, null));
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
