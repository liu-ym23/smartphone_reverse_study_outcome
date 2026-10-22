package com.ss.ugc.live.barrage.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ olc.a b;
    public final /* synthetic */ Function3 c;

    public f(View r1, olc.a r2, Function3 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        View r7 = this.a;
        olc.a r5 = this.b;
        Lazy r0 = UtilsKt.b;
        KProperty r1 = UtilsKt.a[0];
        Handler r8 = (Handler) r0.getValue();
        monitor-enter(r7);
        UtilsKt.b(r7);     // Catch: Throwable -> L21
        r7.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));     // Catch: Throwable -> L21
        int r3 = r7.getMeasuredWidth();     // Catch: Throwable -> L21
        int r4 = r7.getMeasuredHeight();     // Catch: Throwable -> L21
        r7.layout(0, 0, r3, r4);     // Catch: Throwable -> L21
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        if (r7.isOpaque() == false) goto L8;
        Bitmap.Config r6 = Bitmap.Config.RGB_565;     // Catch: Throwable -> L11
    L9:
        Bitmap r9 = r5.obtain(r3, r4, r6);     // Catch: Throwable -> L11
        r7.draw(new Canvas(r9));     // Catch: Throwable -> L11
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r10) == false) goto L16;
        r10 = null;
    L16:
        Bitmap r11 = (Bitmap) r10;     // Catch: Throwable -> L21
        if (r11 == null) goto L19;
        r8.post(new e(r11, r3, r4, r7, r5, this.c));     // Catch: Throwable -> L21
    L19:
        monitor-exit(r7);
        return;
    L8:
        r6 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L21
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
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
