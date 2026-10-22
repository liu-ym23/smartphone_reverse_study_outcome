package com.larus.browsertakeover.ui;

import android.content.res.Resources;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.browsertakeover.render.RemoteBrowserSurfaceView;
import com.larus.browsertakeover.session.BrowserTakeoverSession;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x implements Runnable {
    public final /* synthetic */ BrowserTakeoverDialog a;
    public final /* synthetic */ BrowserTakeoverDialog.b b;

    public final void a() {
        BrowserTakeoverDialog r0 = this.a;
        if (r0.j == this) goto L5;
        return;
    L5:
        BrowserTakeoverSession r1 = null;
        r0.j = null;
        BrowserTakeoverDialog.b r2 = this.b;
        RemoteBrowserSurfaceView r3 = r2.e;
        if (r0.e == r2) goto L8;
        return;
    L8:
        if (r0.g == true) goto L10;
        return;
    L10:
        if (r3.getWidth() > 0) goto L12;
        return;
    L12:
        if (r3.getHeight() <= 0) goto L23;
        Resources r4 = this.a.getResources();
        float r5 = RangesKt.coerceAtLeast(WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density, 1.0f);
        BrowserTakeoverSession r6 = this.a.d;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L18:
        r1.connect(MathKt.roundToInt(r3.getWidth() / r5), MathKt.roundToInt(r3.getHeight() / r5));
        return;
    L17:
        r1 = r6;
        goto L18
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

    public x(BrowserTakeoverDialog r1, BrowserTakeoverDialog.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
