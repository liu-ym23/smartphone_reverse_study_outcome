package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.apm.ApmAgent;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m0 implements zw4.a {
    public m0() {
    }

    public final void a(String r4, float r5) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put(r4, r5);     // Catch: Exception -> L4
        ApmAgent.monitorPerformance("start", r4, r0, null, null);     // Catch: Exception -> L4
        return;
    }
}
