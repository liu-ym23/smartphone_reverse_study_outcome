package com.bytedance.b.a;

import com.bytedance.apm.util.JsonUtils;
import com.bytedance.services.slardar.config.IConfigManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.services.slardar.config.a {
    private static volatile c e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1896b;
    private JSONObject c;
    private JSONObject d;

    private c() {
        this.f1896b = true;
    }

    public static c a() {
        if (e != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new c();     // Catch: Throwable -> L11
        ((IConfigManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IConfigManager.class), IConfigManager.class, "com.obric.memorydata.plugin")).registerConfigListener(e);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }

    public int a(boolean r9, String r10) {
        int r1 = 0;
        if (this.f1896b == true) goto L6;
        return 0;
    L6:
        if (r9 == false) goto L12;
        JSONObject r11 = this.d;
        if (r11 != null) goto L10;
    L11:
        r1 = 16;
        goto L12
    L10:
        if (r11.optDouble(r10, -1.0d) > 0.0d) goto L11;
    L12:
        JSONObject r8 = this.c;
        if (r8 != null) goto L15;
        return r1;
    L15:
        if (r8.optDouble(r10, -1.0d) > 0.0d) goto L17;
        return r1;
    L17:
        return r1 | 1;
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onReady() {
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onRefresh(JSONObject r3, boolean r4) {
        this.f1896b = JsonUtils.a(r3, "tracing", "enable_open", true);
        if (this.f1895a == true) goto L6;
        this.c = JsonUtils.a(r3, "tracing", "allow_service_list");
        this.d = JsonUtils.a(r3, "tracing", "allow_error_list");
        this.f1895a = true;
        return;
    }
}
