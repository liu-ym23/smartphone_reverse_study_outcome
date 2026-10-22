package com.larus.xbridge.custom;

import android.app.Activity;
import android.content.Context;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w extends bx7.c {
    public final String getName() {
        return "app.openChatPage";
    }

    public w() {
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [com.larus.xbridge.custom.v] */
    public final void a(dx7.b r10, final ux7.d.d r11, IvyBridgePlatformType r12) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r12, "type");
        ex7.d r13 = ((bx7.c) this).a;
        if (r13 == null) goto L48;
        Context r14 = (Context) r13.a(Context.class);
        if (r14 == null) goto L50;
        Activity r2 = com.bytedance.ies.xbridge.utils.f.a.getActivity(r14);
        if (r2 == null) goto L49;
        String r3 = r10.getString("schema");
        String r4 = r10.getString("conversationId");
        int r5 = r10.getInt("pageMode");
        String r6 = r10.getString("enterMethod");
        FLogger.a.d("app.openChatPage", "Chat history-handle schema=" + r3 + " cvsId=" + r4 + " pageMode=" + r5 + " enterMethod=" + r6);
        boolean r0 = false;
        if (r3.length() != 0) goto L12;
        boolean r15 = true;
    L14:
        if (r15 == false) goto L16;
    L43:
        bx7.c.c(this, r11, -3, null, 12);
        return;
    L16:
        if (r4.length() != 0) goto L18;
        boolean r16 = true;
    L19:
        if (r16 == true) goto L43;
        if (r6.length() != 0) goto L23;
        r0 = true;
    L23:
        if (r0 == true) goto L43;
        ArrayList r7 = new ArrayList();
        dx7.e r17 = r10.getArray("ext");
        if (r17 == null) goto L41;
        Iterator r18 = r17.toList().iterator();
    L29:
        if (r18.hasNext() == false) goto L41;
        Object r19 = r18.next();
        if ((r19 instanceof HashMap) == false) goto L33;
        HashMap r110 = (HashMap) r19;
    L34:
        if (r110 == null) goto L39;
        Object r111 = r110.get("messageId");
        if (r111 == null) goto L39;
        String r112 = r111.toString();
        if (r112 == null) goto L39;
    L40:
        r7.add(r112);
    L39:
        r112 = NameKeys.UnloadStrategy_No_Strategy;
        goto L40
    L33:
        r110 = null;
    L41:
        FLogger.a.d("app.openChatPage", "Chat history-handle msgIds=" + r7);
        IAIChatService.a.Z7(r2, r3, r4, r5, r6, r7, new v(this, r11));
        return;
    L18:
        r16 = false;
        goto L19
    L12:
        r15 = false;
        goto L14
    L49:
        return;
    L50:
        return;
    }
}
