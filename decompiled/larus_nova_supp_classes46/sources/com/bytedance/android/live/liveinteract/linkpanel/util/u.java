package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u {
    public static ih0.c a;
    public static String b;

    static {
        b = "link_setting_click";
    }

    public static void a(Context r11, DataCenter r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        if (a == null) goto L6;
        ALogger.i("MultiLinkSettingPanelReuseManager", "genSettingPanelContainerCard reuse");
        return;
    L6:
        u6 r0 = new u6(vm2.i.b().getSettingPanelSchema());
        r0.b("url", vm2.i.b().getSettingPanelUrl());
        u6 r2 = r0.d("url");
        LinkedHashMap r3 = new LinkedHashMap();
        if (r13 < 0) goto L9;
        r3.put("position", String.valueOf(r13));
    L9:
        Iterator r14 = r3.entrySet().iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        Map.Entry r4 = (Map.Entry) r14.next();
        r2.b((String) r4.getKey(), (String) r4.getValue());
        goto L11
    L13:
        Uri r7 = r0.c();
        long r5 = System.currentTimeMillis();
        IInteractService r15 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r15 == null) goto L18;
        ih0.b r6 = r15.dynamicService(r12);
        if (r6 == null) goto L18;
        ih0.c r16 = ih0.b.a.a(r6, r11, r7, new q(), System.currentTimeMillis());
    L19:
        a = r16;
        ALogger.i("MultiLinkSettingPanelReuseManager", "genSettingPanelContainerCard cost=" + (System.currentTimeMillis() - r5));
        return;
    L18:
        r16 = null;
        goto L19
    }
}
