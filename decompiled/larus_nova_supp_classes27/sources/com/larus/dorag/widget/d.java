package com.larus.dorag.widget;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d implements b98.d {
    public d() {
    }

    public final void a(int r7, int r8) {
        FLogger r0 = FLogger.a;
        r0.i("DoraWidgetCenter", "onStateChange, scene: " + r7 + ", state: " + r8);
        if (r7 != 1) goto L5;
        int r5 = 1;
    L15:
        if (r5 != (-1)) goto L18;
        r0.i("DoraWidgetCenter", "onStateChange, uncare scene: " + r7);
        return;
    L18:
        if (r8 == 1) goto L26;
        if (r8 == 2) goto L22;
        r0.i("DoraWidgetCenter", "onStateChange: scene " + r7 + ", unknown state " + r8);
        return;
    L22:
        if (f.d != r5) goto L24;
        r0.i("DoraWidgetCenter", "onStateChange, preScene exit, preScene: " + f.d);
        f.d = 0;
        String r9 = f.a;
        f.a();
        return;
    L24:
        r0.i("DoraWidgetCenter", "onStateChange, exiting scene not match, preScene: " + f.d + ", exitScene: " + r5);
        return;
    L26:
        if (r5 == f.d) goto L32;
        r0.i("DoraWidgetCenter", "onStateChange, newScene enter, preScene: " + f.d + ", newScene: " + r5);
        f.d = r5;
        String r10 = f.a;
        f.a();
        return;
    L32:
        return;
    L5:
        if (r7 != 6) goto L7;
        r5 = 3;
        goto L15
    L7:
        if (r7 != 7) goto L9;
        r5 = 2;
        goto L15
    L9:
        if (r7 == 8) goto L11;
        r5 = -1;
        goto L15
    L11:
        r5 = 4;
        goto L15
    }
}
