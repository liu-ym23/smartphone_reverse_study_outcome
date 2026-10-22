package com.bytedance.apm.impl;

import android.content.Context;
import androidx.annotation.Keep;
import b3.d;
import c2.c;
import c2.e;
import c2.f;
import c2.k;
import com.bytedance.services.apm.api.IApmAgent;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ApmAgentServiceImpl implements IApmAgent {
    public ApmAgentServiceImpl() {
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorCommonLog(String r8, JSONObject r10) {
        e.b(r8, r10);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorDuration(String r8, JSONObject r10, JSONObject r11) {
        AtomicLong r12 = e.f3258a;
        boolean r13 = h3.a.f7903a;
        JSONObject r14 = e.e(r11);
        e.a(r14);
        h3.a.b(new j3.a(r8, 0, r10, null, null, r14));
        if (k.f3298b == false) goto L6;
        JSONObject r15 = l6.a.E(r10);
        JSONObject r16 = l6.a.E(r14);
        d.a().b(new c2.b(r8, r15, r16));
        return;
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(String r8, JSONObject r10, JSONObject r11, JSONObject r12) {
        e.c(r8, r10, r11, r12);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorExceptionLog(String r8, JSONObject r10) {
        JSONObject r11 = e.e(r10);
        b3.b.C0032b.f3038a.c(new c2.d(r8, r11));
        if (k.f3298b == false) goto L6;
        d.a().b(new f(r8, r11));
        return;
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorLog(String r8, JSONObject r10) {
        e.b(r8, r10);
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusAndDuration(String r8, int r10, JSONObject r11, JSONObject r12) {
        AtomicLong r13 = e.f3258a;
        boolean r14 = h3.a.f7903a;
        JSONObject r15 = e.e(r12);
        e.a(r15);
        h3.a.b(new j3.a(r8, r10, l6.a.E(r11), null, null, l6.a.E(r15)));
        if (k.f3298b == false) goto L6;
        JSONObject r16 = l6.a.E(r11);
        JSONObject r17 = l6.a.E(r12);
        d.a().b(new c(r8, r10, r16, r17));
        return;
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusRate(String r8, int r10, JSONObject r11) {
        AtomicLong r12 = e.f3258a;
        boolean r13 = h3.a.f7903a;
        JSONObject r14 = e.e(r11);
        e.a(r14);
        h3.a.b(new j3.a(r8, r10, null, null, null, r14));
        if (k.f3298b == false) goto L6;
        JSONObject r15 = l6.a.E(r14);
        d.a().b(new c2.a(r10, r8, r15));
        return;
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void reportLegacyMonitorLog(Context r8, long r10, long r11, boolean r12) {
        boolean r13 = k.f3297a;
        AtomicLong r14 = e.f3258a;
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(u8.a r8) {
        throw null;
    }
}
