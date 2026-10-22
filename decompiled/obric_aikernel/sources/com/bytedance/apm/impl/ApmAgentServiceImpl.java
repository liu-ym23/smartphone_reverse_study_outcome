package com.bytedance.apm.impl;

import android.content.Context;
import androidx.annotation.Keep;
import com.bytedance.services.apm.api.IApmAgent;
import org.json.JSONObject;
import u.d;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ApmAgentServiceImpl implements IApmAgent {
    public ApmAgentServiceImpl() {
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorCommonLog(String r10, JSONObject r11) {
        com.bytedance.apm.c.e(r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorDuration(String r10, JSONObject r11, JSONObject r12) {
        com.bytedance.apm.c.g(r10, r11, r12);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        com.bytedance.apm.c.h(r10, r11, r12, r13);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(t4.b r10) {
        com.bytedance.apm.c.i(d.a().l(r10.e()).m(r10.f()).i(r10.b()).k(r10.d()).j(r10.c()).h(r10.g()).g());
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorExceptionLog(String r10, JSONObject r11) {
        com.bytedance.apm.c.j(r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorLog(String r10, JSONObject r11) {
        com.bytedance.apm.c.e(r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusAndDuration(String r10, int r11, JSONObject r12, JSONObject r13) {
        com.bytedance.apm.c.l(r10, r11, r12, r13);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusRate(String r10, int r11, JSONObject r12) {
        com.bytedance.apm.c.m(r10, r11, r12);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void reportLegacyMonitorLog(Context r10, long r11, long r12, boolean r13) {
        com.bytedance.apm.c.r(com.bytedance.apm.d.g(), r11, r12, r13);
    }
}
