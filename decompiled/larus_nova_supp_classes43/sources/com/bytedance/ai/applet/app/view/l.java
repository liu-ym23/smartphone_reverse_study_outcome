package com.bytedance.ai.applet.app.view;

import android.content.Context;
import com.bytedance.ai.model.AppletRuntimeManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l {
    public final ConcurrentHashMap<Integer, m> a;
    public final ConcurrentHashMap<Integer, m> b;

    public l() {
        this.a = new ConcurrentHashMap();
        ConcurrentHashMap<Integer, m> r0 = new ConcurrentHashMap();
        this.b = r0;
        h2.a r1 = f2.b.c;
        if (r1 == null) goto L20;
        Context r10 = r1.a;
        if (r10 == null) goto L20;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r11 = AppletRuntimeManager.d;
        Boolean r12 = null;
        if (r11 == null) goto L11;
        Map<String, Object> r13 = r11.getSettings();
        if (r13 == null) goto L11;
        Object r14 = r13.get("appsMultiworkEntranceEnable");
    L13:
        if ((r14 instanceof Boolean) == false) goto L16;
        r12 = (Boolean) r14;
    L16:
        if (Intrinsics.areEqual(r12, Boolean.TRUE) == false) goto L18;
        m r15 = o.d(r10);
        m r16 = r0.put(Integer.valueOf(r15.a), r15);
    L18:
        m r17 = o.f(r10);
        m r18 = r0.put(Integer.valueOf(r17.a), r17);
        m r19 = o.e(r10);
        m r20 = r0.put(Integer.valueOf(r19.a), r19);
        m r21 = o.a(r10);
        m r22 = r0.put(Integer.valueOf(r21.a), r21);
        m r23 = o.f(r10);
        m r24 = r0.put(Integer.valueOf(r23.a), r23);
        m r25 = o.b(r10);
        if (r0.put(Integer.valueOf(r25.a), r25) == null) goto L20;
        return;
    L11:
        r14 = null;
    L20:
        com.bytedance.ai.utils.g.a.e("AppletAppActionBar", "context is NULL. Failed to create system sheet menu items");
        Unit r26 = Unit.INSTANCE;
    }

    public final void a(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "title");
        m r0 = this.b.get(1);
        if (r0 == null) goto L6;
        m r12 = m.a(r0, r10, Integer.valueOf(r11), false, 1017);
        m r13 = this.b.put(Integer.valueOf(r12.a), r12);
        return;
    }
}
