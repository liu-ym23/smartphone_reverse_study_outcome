package com.larus.voicecall.impl.continue_talk;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h2 {
    public boolean a;
    public ViewGroup b;
    public Activity c;
    public d19.g d;
    public boolean e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    public h2() {
    }

    public final void a() {
        if (this.a == true) goto L6;
        FLogger.a.i("ScreenEdgeEffectManager", "[removeSpecificOverlayView]: view is not added");
        return;
    L6:
        View r0 = this.d;
        if ((r0 instanceof View) == false) goto L9;
        View r1 = r0;
    L10:
        if (r1 != null) goto L13;
        FLogger.a.i("ScreenEdgeEffectManager", "[removeSpecificOverlayView]: view is null");
        return;
    L13:
        this.a = false;
        ViewGroup r2 = this.b;
        if (r2 == null) goto L16;
        r2.removeView(r1);
    L16:
        this.b = null;
        FLogger.a.i("ScreenEdgeEffectManager", "[removeSpecificOverlayView]: view is removed");
        return;
    L9:
        r1 = null;
        goto L10
    }

    public final void b() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[visibleScreenEdgeEffect]: visible screen edge effect, screenEdgeEffectView is null(");
        if (this.d != null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r1.append(')');
        r0.i("ScreenEdgeEffectManager", r1.toString());
        d19.g r3 = this.d;
        if (r3 == null) goto L9;
        r3.d();
    L9:
        View r4 = this.d;
        if ((r4 instanceof View) == false) goto L12;
        View r5 = r4;
    L13:
        if (r5 == null) goto L16;
        com.larus.utils.e1.x(r5);
        return;
    L16:
        return;
    L12:
        r5 = null;
        goto L13
    L5:
        r2 = false;
        goto L6
    }
}
