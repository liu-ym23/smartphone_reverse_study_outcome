package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r0 extends bx7.c {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.azerothEncrypt";
    }

    public r0() {
    }

    public final void a(dx7.b r2, final ux7.d.d r3, IvyBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "type");
        final String r5 = r2.getString(LynxAccessibilityModule.MSG_CONTENT);
        if (r5.length() != 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L9;
        bx7.c.c(this, r3, -3, null, 12);
        return;
    L9:
        com.larus.utils.t0.a(new q0(r5, this, r3));
        return;
    L5:
        r6 = false;
        goto L6
    }
}
