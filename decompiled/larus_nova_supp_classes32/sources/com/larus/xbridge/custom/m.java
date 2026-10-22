package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.bmhome.code.IAiChatCodePreviewService;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m extends bx7.c {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.getCodeForPreview";
    }

    public m() {
    }

    public final void a(dx7.b r7, ux7.d.d r8, IvyBridgePlatformType r9) {
        Intrinsics.checkNotNullParameter(r7, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r8, "callback");
        Intrinsics.checkNotNullParameter(r9, "type");
        String r10 = r7.getString("codeId");
        IAiChatCodePreviewService r11 = (IAiChatCodePreviewService) ServiceManager.get().getService(IAiChatCodePreviewService.class);
        String r0 = null;
        if (r11 == null) goto L5;
        String r12 = r11.b(r10);
    L6:
        IAiChatCodePreviewService r1 = (IAiChatCodePreviewService) ServiceManager.get().getService(IAiChatCodePreviewService.class);
        if (r1 == null) goto L10;
        r0 = r1.c(r10);
    L10:
        if (r12 != null) goto L12;
        int r2 = 0;
    L13:
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("result", Integer.valueOf(r2));
        if (r2 == 1) goto L16;
    L22:
        FLogger.a.i("AppGetCodeForPreviewMethod", "app.getCodeForPreview codeId = " + r10 + " result = " + r2);
        bx7.c.d(this, r8, r3);
        return;
    L16:
        if (r12 != null) goto L18;
        r12 = NameKeys.UnloadStrategy_No_Strategy;
    L18:
        r3.put(LynxResourceModule.CODE_KEY, r12);
        if (r0 != null) goto L21;
        r0 = NameKeys.UnloadStrategy_No_Strategy;
    L21:
        r3.put("language", r0);
        goto L22
    L12:
        r2 = 1;
        goto L13
    L5:
        r12 = null;
        goto L6
    }
}
