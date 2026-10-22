package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends com.bytedance.ies.argus.api.params.c {
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f5159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f5160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PrefetchType f5161j;

    public e(String r5, String r10, String r11) {
        PrefetchType r12 = PrefetchType.f5150a;
        Intrinsics.checkNotNullParameter(r12, "type");
        this.g = r5;
        this.f5159h = r10;
        this.f5160i = r11;
        this.f5161j = r12;
    }

    public final JSONObject o(ArgusVerifyAction r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        JSONObject r10 = new JSONObject();
        com.bytedance.ies.argus.util.c.a("", "real_url", r10);
        com.bytedance.ies.argus.util.c.a(this.g, "url", r10);
        com.bytedance.ies.argus.util.c.a(this.f5159h, LynxMonitorService.KEY_CHANNEL, r10);
        com.bytedance.ies.argus.util.c.a(this.f5160i, "bundle", r10);
        com.bytedance.ies.argus.util.c.a("", "host", r10);
        com.bytedance.ies.argus.util.c.a(this.f5161j.name(), "type", r10);
        return r10;
    }
}
