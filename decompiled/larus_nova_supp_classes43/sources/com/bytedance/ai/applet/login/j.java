package com.bytedance.ai.applet.login;

import com.bytedance.ai.bridge.login.AbsLoginWithDoubaoWidgetMethodIDL;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public final u2.c a;
    public final u2.j b;
    public final boolean c;
    public boolean d;
    public h e;
    public final String f;
    public final f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> g;
    public final AppletAuthTaskMonitor.Session h;
    public AppletAuthTaskMonitor.a i;

    public j() {
        throw null;
    }

    public j(u2.c r10, u2.j r11, boolean r12, String r13, f3.h r14, AppletAuthTaskMonitor.Session r15) {
        h.c r0 = h.c.a;
        Intrinsics.checkNotNullParameter(r10, "metaData");
        Intrinsics.checkNotNullParameter(r11, "relatedData");
        Intrinsics.checkNotNullParameter(r0, "state");
        Intrinsics.checkNotNullParameter(r13, "fromPage");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = false;
        this.e = r0;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = null;
    }
}
