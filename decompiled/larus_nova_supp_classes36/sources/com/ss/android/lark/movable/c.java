package com.ss.android.lark.movable;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends View {
    public final Paint a;
    public final float b;
    public ObjectAnimator c;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewParent r0 = this.a.getParent();     // Catch: Throwable -> L10
            if ((r0 instanceof ViewGroup) == false) goto L5;
            ViewGroup r1 = (ViewGroup) r0;     // Catch: Throwable -> L10
        L6:
            if (r1 == null) goto L8;
            r1.removeView(this.a);     // Catch: Throwable -> L10
        L8:
            this.a.setAlpha(1.0f);     // Catch: Throwable -> L10
            return;
        L5:
            r1 = null;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    public final void a() {
        if (getVisibility() == 0) goto L5;
        return;
    L5:
        ObjectAnimator r0 = this.c;
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        animate().alpha(0.0f).setDuration(300).withEndAction(new a(this));
    }

    public final float getRadius() {
        return this.b;
    }

    public c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        Paint r0 = new Paint(1);
        this.a = r0;
        this.b = com.ss.android.lark.movable.utils.b.d(5.0f, r3);
        r0.setColor(UDColorUtils.getColor(r3, 2131102418));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        float r0 = this.b;
        r3.drawCircle(r0, r0, r0, this.a);
    }

    @Override // android.view.View
    public final void onMeasure(int r2, int r3) {
        float r4 = this.b;
        float r5 = 2;
        setMeasuredDimension((int) (r4 * r5), (int) (r4 * r5));
    }
}
