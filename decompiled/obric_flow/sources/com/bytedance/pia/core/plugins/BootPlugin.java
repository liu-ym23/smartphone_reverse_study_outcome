package com.bytedance.pia.core.plugins;

import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.m;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lynx.tasm.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import mh.a;
import nh.c;
import nh.d;

/* JADX INFO: loaded from: classes2.dex */
public class BootPlugin extends c {
    public static final HashMap e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonArray f7042c;
    public final ArrayList d;

    static {
        HashMap r5 = new HashMap();
        e = r5;
        r5.put("prefetch", "pia.internal.worker.create");
    }

    public BootPlugin(d r5) {
        super(r5);
        this.f7042c = new JsonArray();
        this.d = new ArrayList();
    }

    @Override // nh.c
    public final String c() {
        return "boot";
    }

    @Override // nh.c
    public final void e(String r13, Object... r14) {
        Lazy r5 = Settings.B;
        if (p.a().l() == true) goto L6;
        return;
    L6:
        if ("event-on-manifest-ready".equals(r13) == false) goto L22;
        Object r15 = r14[0];
        if ((r15 instanceof JsonObject) == false) goto L29;
        Iterator<Map.Entry<String, JsonElement>> r16 = ((JsonObject) r15).entrySet().iterator();
    L12:
        if (r16.hasNext() == false) goto L30;
        Map.Entry<String, JsonElement> r17 = r16.next();
        String r10 = r17.getKey();
        boolean r11 = "prefetch".equals(r10);
        d r12 = this.f20236b;
        if (r11 == true) goto L16;
    L19:
        String r18 = null;
    L18:
        String r19 = r18;
        if (r19 == null) goto L12;
        r12.s.f7114m = 3;
        JsonObject r20 = r17.getValue().getAsJsonObject();
        JsonObject r110 = new JsonObject();
        r110.addProperty("configKey", r10);
        r110.addProperty("type", r19);
        this.d.add(r10);
        a r111 = new a(this, r110, r10, 0);
        a r21 = new a(this, r110, r10, 1);
        gh.c r22 = r12.f20250v;
        r22.getClass();
        m.b(new com.bytedance.ai.model.widgets.m(r22, r19, r21, r20, r111, 3));
        goto L12
    L16:
        if (((Set) r12.d.e.getValue()).contains("prefetch") == false) goto L19;
        r18 = (String) e.get(r10);
        goto L18
    L30:
        return;
    L29:
        return;
    }
}
