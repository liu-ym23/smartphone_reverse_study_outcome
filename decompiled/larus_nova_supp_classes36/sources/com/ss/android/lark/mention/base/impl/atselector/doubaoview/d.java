package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ View c;

    public d(View r1, int r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        Rect r0 = new Rect();
        this.a.getHitRect(r0);
        int r1 = r0.width();
        int r2 = r0.height();
        int r3 = RangesKt.coerceAtLeast(this.b - r1, 0) / 2;
        int r4 = RangesKt.coerceAtLeast(this.b - r2, 0) / 2;
        r0.inset(-r3, -r4);
        this.c.setTouchDelegate(new TouchDelegate(r0, this.a));
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
