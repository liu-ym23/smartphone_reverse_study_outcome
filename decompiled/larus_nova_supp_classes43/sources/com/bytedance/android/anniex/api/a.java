package com.bytedance.android.anniex.api;

import android.content.Context;
import com.bytedance.android.anniex.engine.AnnieXLynxEngine;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ AnnieXLynxEngine b;
    public final /* synthetic */ LynxView c;

    public a(Context r1, AnnieXLynxEngine r10, AnnieXLynxView r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final void a() {
        int r0 = this.a.getResources().getConfiguration().orientation;
        int r1 = this.b.l;
        i16.c r10 = i16.c.a;
        int r11 = i16.c.j(this.a);
        int r12 = i16.c.i(this.a);
        HybridLogger r13 = HybridLogger.a;
        HybridLogger.m("AnnieXApi", "postDelayed 100 ===>activity:" + this.a + "  currentContextOrientation: " + r0 + "  engineOrientation:" + r1 + "   currentScreenWidth:" + r11, null, null, 12);
        if (r0 == r1) goto L6;
        this.c.updateScreenMetrics(r11, r12);
        this.c.requestLayout();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
