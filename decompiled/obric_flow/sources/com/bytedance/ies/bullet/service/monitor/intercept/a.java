package com.bytedance.ies.bullet.service.monitor.intercept;

import com.bytedance.ies.bullet.service.base.i;
import com.google.common.reflect.w;
import kotlin.Lazy;
import org.json.JSONObject;
import tc.c;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements t4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6058a = null;

    static {
        f6058a = new a();
    }

    @Override // t4.b
    public final void a(String r5, String r10, JSONObject r11) {
        JSONObject r12 = r11.optJSONObject("extra");
        if (r12 == null) goto L7;
        JSONObject r13 = r12.optJSONObject("client_category");
        if (r13 == null) goto L7;
        String r14 = r13.optString("_bid");
    L8:
        if (r14 != null) goto L10;
        r14 = "default_bid";
    L10:
        c r15 = c.f22119c;
        rc.c r16 = (i) c.f22119c.a(i.class, r14);
        if (r16 != null) goto L13;
        Lazy r17 = com.bytedance.ies.bullet.service.monitor.i.d;
        r16 = m.b();
    L13:
        w r18 = ((com.bytedance.ies.bullet.service.monitor.i) r16).f6054b;
        return;
    L7:
        r14 = null;
        goto L8
    }
}
