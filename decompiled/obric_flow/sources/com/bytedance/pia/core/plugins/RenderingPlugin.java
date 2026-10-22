package com.bytedance.pia.core.plugins;

import androidx.annotation.Keep;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.utils.m;
import com.google.gson.JsonObject;
import mh.g;
import mh.h;
import nh.c;
import nh.d;

/* JADX INFO: loaded from: classes2.dex */
public class RenderingPlugin extends c {
    @Keep
    public RenderingPlugin(d r5, h r10) {
        super(r5);
        throw null;
    }

    @Override // nh.c
    public final String c() {
        return "rendering";
    }

    @Override // nh.c
    public final void e(String r11, Object... r12) {
        if ("event-on-manifest-error".equals(r11) == false) goto L5;
    L22:
        new PiaMethod$Error("Request manifest error!");
        throw null;
    L5:
        if ("event-on-html-error".equals(r11) == true) goto L22;
        if ("event-on-manifest-ready".equals(r11) == false) goto L21;
        Object r13 = r12[0];
        if ((r13 instanceof JsonObject) == false) goto L25;
        JsonObject r14 = (JsonObject) r13;     // Catch: Throwable -> L15
        if (r14.has("rendering") == false) goto L17;
        JsonObject r10 = r14.get("rendering").getAsJsonObject();     // Catch: Throwable -> L15
        gh.c r5 = this.f20236b.f20250v;     // Catch: Throwable -> L15
        g r15 = new g(this, 0);     // Catch: Throwable -> L15
        g r16 = new g(this, 1);     // Catch: Throwable -> L15
        r5.getClass();     // Catch: Throwable -> L15
        m.b(new com.bytedance.ai.model.widgets.m(r5, "pia.internal.worker.runTask", r16, r10, r15, 3));     // Catch: Throwable -> L15
        return;
    L17:
        new PiaMethod$Error("'rendering' is required!");     // Catch: Throwable -> L15
        throw null;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        new PiaMethod$Error(th.toString());
        throw null;
    L25:
        return;
    }
}
