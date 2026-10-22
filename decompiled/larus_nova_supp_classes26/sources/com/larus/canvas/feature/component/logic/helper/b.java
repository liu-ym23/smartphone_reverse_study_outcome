package com.larus.canvas.feature.component.logic.helper;

import com.bytedance.router.SmartRouter;
import com.larus.canvas.feature.CreationCanvasActivity;
import com.larus.utils.logger.FLogger;
import hq9.q3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements q3 {
    public final /* synthetic */ String a;
    public final /* synthetic */ CreationCanvasActivity b;

    public final void a() {
    }

    public final void b(boolean r1) {
    }

    public final void c() {
        String r0 = this.a;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        FLogger.a.i("CanvasMemberQuotaPush", "click push but actionUrl is empty");
        return;
    L12:
        SmartRouter.buildRoute(this.b, this.a).d();
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public b(String r1, CreationCanvasActivity r2) {
        this.a = r1;
        this.b = r2;
    }
}
