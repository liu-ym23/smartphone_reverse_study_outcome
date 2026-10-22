package com.bytedance.apm.impl;

import android.content.Context;
import com.bytedance.services.apm.api.IApmAgent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ApmAgentServiceImpl implements IApmAgent {
    public ApmAgentServiceImpl() {
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorCommonLog(String r1, JSONObject r2) {
        com.bytedance.apm.a.a(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorDuration(String r1, JSONObject r2, JSONObject r3) {
        com.bytedance.apm.a.a(r1, r2, r3);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(com.bytedance.services.apm.api.b r2) {
        com.bytedance.apm.a.a(com.bytedance.apm.config.d.g().a(r2.a()).a(r2.d()).a(r2.b()).b(r2.c()).c(r2.e()).a(r2.f()).a());
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        com.bytedance.apm.a.a(r1, r2, r3, r4);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorExceptionLog(String r1, JSONObject r2) {
        com.bytedance.apm.a.b(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorLog(String r1, JSONObject r2) {
        com.bytedance.apm.a.a(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusAndDuration(String r1, int r2, JSONObject r3, JSONObject r4) {
        com.bytedance.apm.a.a(r1, r2, r3, r4);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusRate(String r1, int r2, JSONObject r3) {
        com.bytedance.apm.a.a(r1, r2, r3);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void reportLegacyMonitorLog(Context r7, long r8, long r10, boolean r12) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        com.bytedance.apm.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8, r10, r12);
    }
}
