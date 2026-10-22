package com.bytedance.apm;

import com.bytedance.forest.chain.fetchers.GeckoFetcher;
import com.bytedance.forest.model.w;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3849c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public b(String r5, String r10, int r11, w r12, com.bytedance.forest.utils.e r13) {
        this.f3847a = 1;
        this.f3848b = r5;
        this.d = r10;
        this.f3849c = r11;
        this.e = r12;
        this.f = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r5 = this.f;
        Object r10 = this.e;
        Object r11 = this.d;
        switch(this.f3847a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        JSONObject r12 = new JSONObject();
        r12.put(LynxMonitorService.KEY_CHANNEL, this.f3848b);
        r12.put("bundle", (String) r11);
        r12.put("loader", GeckoFetcher.GECKO_SDK_INVOKE_ASYNC_TAG);
        r12.put("mode", this.f3849c);
        ArrayList r13 = com.bytedance.forest.c.f4233a;
        w r14 = (w) r10;
        com.bytedance.forest.c.a(r14, "res_gecko_loader_secure", r12, new JSONObject(), new JSONObject(), 0, (com.bytedance.forest.utils.e) r5);
        return;
    L6:
        JSONObject r15 = ApmAgent.access$000((JSONObject) r11, true);
        JSONObject r16 = ApmAgent.access$000((JSONObject) r10, true);
        JSONObject r17 = ApmAgent.access$000((JSONObject) r5, false);
        h7.a.b(new j7.a(this.f3848b, this.f3849c, null, r15, r16, r17));
    }

    public b(String r5, int r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        this.f3847a = 0;
        this.f3848b = r5;
        this.f3849c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
    }
}
