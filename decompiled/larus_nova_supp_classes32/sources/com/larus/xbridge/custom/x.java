package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.bmhome.code.IAiChatCodePreviewService;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x extends bx7.c {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.readyForCodePreview";
    }

    public x() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.StringBuilder] */
    public final void a(dx7.b r6, ux7.d.d r7, IvyBridgePlatformType r8) {
        Intrinsics.checkNotNullParameter(r6, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r7, "callback");
        Intrinsics.checkNotNullParameter(r8, "type");
        String r9 = r6.getString("codeId");
        boolean r10 = cx7.a.b(r6, "isSuccess", true);
        IAiChatCodePreviewService r0 = (IAiChatCodePreviewService) ServiceManager.get().getService(IAiChatCodePreviewService.class);
        if (r0 == null) goto L5;
        ?? r1 = r0.a(r9, r10);
    L6:
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("result", Integer.valueOf(r1));
        FLogger.a.i("AppReadyForCodePreviewMethod", "app.readyForCodePreview codeId = " + r9 + " result = " + r1 + " isSuccess = " + r10);
        bx7.c.d(this, r7, r2);
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
