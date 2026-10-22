package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.spi.IAIChatService;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b0 extends bx7.c {
    public final String getName() {
        return "app.sendMsg";
    }

    public b0() {
    }

    public final void a(dx7.b r9, ux7.d.d r10, IvyBridgePlatformType r11) {
        Intrinsics.checkNotNullParameter(r9, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r11, "type");
        dx7.b r12 = r9.getMap("commonProps");
        if (r12 == null) goto L6;
        String r1 = r12.getString("botId");
        if (r1 == null) goto L6;
    L7:
        String r5 = r1;
        if (r12 == null) goto L11;
        String r13 = r12.getString("conversationId");
        if (r13 == null) goto L11;
    L12:
        String r4 = r13;
        String r3 = r9.getString("msg");
        boolean r0 = false;
        if (r5.length() != 0) goto L15;
        boolean r14 = true;
    L16:
        if (r14 == false) goto L18;
    L29:
        bx7.c.c(this, r10, -3, null, 12);
        return;
    L18:
        if (r4.length() != 0) goto L20;
        boolean r15 = true;
    L21:
        if (r15 == true) goto L29;
        if (r3.length() != 0) goto L25;
        r0 = true;
    L25:
        if (r0 == true) goto L29;
        String r7 = r9.getString("ext");
        String r6 = r9.getString("scene");
        IAIChatService.a.l8(r3, r4, r5, r6, r7);
        bx7.c.d(this, r10, new LinkedHashMap());
        return;
    L20:
        r15 = false;
        goto L21
    L15:
        r14 = false;
    L11:
        r13 = r9.getString("conversationId");
    L6:
        r1 = r9.getString("botId");
        goto L7
    }
}
