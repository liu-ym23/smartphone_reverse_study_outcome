package com.bytedance.android.annie.lynx;

import android.content.Context;
import android.view.View;
import com.bytedance.android.annie.param.k;
import com.lynx.devtoolwrapper.DevToolLifecycle;
import com.lynx.devtoolwrapper.DevToolSettings;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements r9.c {
    public c() {
    }

    @Override // r9.c
    public final boolean R() {
        if (DevToolLifecycle.getInstance().isEnabled() == true) goto L6;
        return false;
    L6:
        if (DevToolSettings.inst().isDevToolEnabled() == false) goto L15;
        if (DevToolSettings.inst().getV8Enabled() == 0) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L17:
        return false;
    }

    @Override // r9.c
    public final String A() {
        return LynxEnv.inst().getLynxVersion();
    }

    @Override // r9.c
    public final String Q(View r10) {
        if ((r10 instanceof LynxView) == false) goto L5;
        LynxView r11 = (LynxView) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.getTemplateUrl();
    L5:
        r11 = null;
        goto L6
    }

    @Override // r9.c
    public final boolean c(View r1) {
        return r1 instanceof LynxView;
    L4:
        return false;
    }

    @Override // r9.c
    public final String q(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        LynxComponent.Companion.getClass();
        return LynxComponent.a.a(r10);
    }

    @Override // r9.c
    public final k S(Context r10, String r11, String r12, Long r13) {
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter("", "containerId");
        LynxComponent.Companion.getClass();
        return LynxComponent.a.c(r10, r11, r12, "", r13, false, "host");
    }

    @Override // r9.c
    public final k s0(Context r10, String r11, String r12, com.bytedance.android.annie.param.a r13) {
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter("", "containerId");
        Intrinsics.checkNotNullParameter(r13, "annieContext");
        LynxComponent.Companion.getClass();
        return LynxComponent.a.b(r10, r11, r12, "", r13, false);
    }
}
