package com.bytedance.android.live.liveinteract.revenue.guestlink;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        String r0 = vm2.i.e().getStartPanelSchema();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = vm2.i.e().getStartPanelUrl();
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        a(r3, r0, r1, null);
    }

    public static void a(Context r3, String r4, String r5, Map r6) {
        ALogger.i("GuestLinkLynxHelper", "openPanel.schema:" + r4 + ",url:" + r5 + ",params:" + r6);
        boolean r1 = false;
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (r5.length() != 0) goto L10;
        r1 = true;
    L10:
        if (r1 == true) goto L30;
        u6 r2 = new u6(r4);
        r2.b("url", r5);
        u6 r7 = r2.d("url");
        if (r6 == null) goto L18;
        Iterator r8 = ((HashMap) r6).entrySet().iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        Map.Entry r9 = (Map.Entry) r8.next();
        r7.b((String) r9.getKey(), (String) r9.getValue());
    L18:
        m r10 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r10 == null) goto L21;
        IRoom r11 = (IRoom) r10.getValue();
    L21:
        Iterator r12 = new LinkedHashMap().entrySet().iterator();
    L23:
        if (r12.hasNext() == false) goto L25;
        Map.Entry r13 = (Map.Entry) r12.next();
        r7.b((String) r13.getKey(), (String) r13.getValue());
        goto L23
    L25:
        k.n(IBaseLiveActionHandler.class).handle(r3, r2.c());
        return;
    L30:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
