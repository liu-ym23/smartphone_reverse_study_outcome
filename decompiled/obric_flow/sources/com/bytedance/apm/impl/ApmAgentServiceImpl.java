package com.bytedance.apm.impl;

import android.content.Context;
import androidx.annotation.Keep;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.j;
import com.bytedance.services.apm.api.IApmAgent;
import oj.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class ApmAgentServiceImpl implements IApmAgent {
    public ApmAgentServiceImpl() {
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorCommonLog(String r5, JSONObject r10) {
        ApmAgent.monitorCommonLog(r5, r10);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorDuration(String r5, JSONObject r10, JSONObject r11) {
        ApmAgent.monitorDuration(r5, r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(String r5, JSONObject r10, JSONObject r11, JSONObject r12) {
        ApmAgent.monitorEvent(r5, r10, r11, r12);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorExceptionLog(String r5, JSONObject r10) {
        ApmAgent.monitorExceptionLog(r5, r10);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorLog(String r5, JSONObject r10) {
        ApmAgent.monitorCommonLog(r5, r10);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusAndDuration(String r5, int r10, JSONObject r11, JSONObject r12) {
        ApmAgent.monitorStatusAndDuration(r5, r10, r11, r12);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusRate(String r5, int r10, JSONObject r11) {
        ApmAgent.monitorStatusRate(r5, r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void reportLegacyMonitorLog(Context r10, long r11, long r12, boolean r13) {
        boolean r14 = j.f3887a;
        ApmAgent.reportLegacyMonitorLog(null, r11, r12, r13);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(a r5) {
        throw null;
    }
}
