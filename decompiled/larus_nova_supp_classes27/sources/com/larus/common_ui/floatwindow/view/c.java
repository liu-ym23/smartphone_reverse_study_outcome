package com.larus.common_ui.floatwindow.view;

import android.app.Application;
import android.view.View;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public final m0 a;
    public final FullScreenFloatWindowHandler b;
    public v c;
    public boolean d;

    public static final class a {
    }

    static {
    }

    public c(Application r3) {
        Intrinsics.checkNotNullParameter(r3, "application");
        m0 r1 = new m0(r3, new h());
        this.a = r1;
        this.b = new FullScreenFloatWindowHandler(r3);
        this.c = r1;
    }

    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        FLogger.a.d("FloatController", "removeView. view:" + r4);
        this.c.removeView(r4);
    }

    public final void b(boolean r4) {
        if (r4 == false) goto L4;
        final v r0 = this.b;
    L5:
        v r1 = this.c;
        if (r1 != r0) goto L8;
        return;
    L8:
        r1.c();
        if (this.d == false) goto L11;
        r1.a(new b(r0));
    L11:
        this.c = r0;
        FLogger.a.d("FloatController", "switchHandler. isFullScreenMode:" + r4);
        return;
    L4:
        r0 = this.a;
        goto L5
    }

    public final void c(e19.h r4, SingleFloatWindowState r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "request");
        FLogger.a.d("FloatController", "updateView. view:" + r4.getContentView());
        this.c.h(r4, r5, r6);
    }
}
