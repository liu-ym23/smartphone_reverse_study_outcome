package com.bytedance.pia.core.plugins;

import com.bytedance.pia.core.bridge.methods.l0;
import com.bytedance.pia.core.utils.i;
import com.bytedance.pia.core.utils.j;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import nh.c;
import nh.d;

/* JADX INFO: loaded from: classes2.dex */
public class PreloadPlugin extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dh.c f7048c;

    public PreloadPlugin(d r5) {
        super(r5);
        com.bytedance.ies.bullet.web.pia.c r10 = r5.f20243n;
        if (r10 == null) goto L5;
        dh.c r11 = (dh.c) r10.a(dh.c.class);
    L6:
        if (r11 != null) goto L8;
        r11 = dh.c.f16657a;
    L8:
        this.f7048c = r11;
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // nh.c
    public final String c() {
        return "preload";
    }

    @Override // nh.c
    public final void e(String r5, Object... r10) {
        if ("event-on-manifest-ready".equals(r5) == false) goto L20;
        Object r11 = r10[0];
        if ((r11 instanceof JsonObject) == false) goto L21;
        JsonElement r12 = ((JsonObject) r11).get("resources");
        if ((r12 instanceof JsonObject) == false) goto L22;
        Map r13 = (Map) i.a().fromJson(r12, Map.class);     // Catch: Throwable -> L12
    L14:
        if (r13 == null) goto L23;
        l0 r14 = new l0(this, 3);
        dh.c r15 = this.f7048c;
        r15.b(r14);
        r15.a(this.f20236b.g.toString(), r13);
        return;
    L23:
        return;
    L12:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[Preload] parse preload config error", "message");
        j.x("[Preload] parse preload config error", th);
        r13 = null;
        goto L14
    L22:
        return;
    L21:
        return;
    }

    @Override // nh.c, fh.c
    public final void release() {
        dh.c r5 = this.f7048c;
        if ((r5 instanceof fh.c) == false) goto L6;
        ((fh.c) r5).release();
        return;
    }
}
