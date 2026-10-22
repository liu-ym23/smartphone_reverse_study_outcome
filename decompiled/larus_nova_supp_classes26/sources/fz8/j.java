package fz8;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import android.view.animation.LinearInterpolator;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    public static final class a extends View {
        public final RectF a;
        public final Paint b;
        public final Matrix c;
        public final int d;
        public final int e;
        public LinearGradient f;
        public float g;
        public ValueAnimator h;

        @Override // android.view.View
        public final void onDetachedFromWindow() {
            ValueAnimator r0 = this.h;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            this.h = null;
            super.onDetachedFromWindow();
        }

        public final void a() {
            if (isShown() == true) goto L5;
        L17:
            ValueAnimator r0 = this.h;
            if (r0 == null) goto L20;
            r0.cancel();
        L20:
            this.h = null;
            return;
        L5:
            if (getWindowVisibility() != 0) goto L17;
            if (getWidth() <= 0) goto L17;
            ValueAnimator r1 = this.h;
            if (r1 == null) goto L13;
            boolean r2 = true;
            if (r1.isRunning() != true) goto L13;
        L14:
            if (r2 == true) goto L23;
            ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r3.setDuration(1500);
            r3.setInterpolator(new LinearInterpolator());
            r3.setRepeatCount(-1);
            r3.addUpdateListener(new i(this));
            r3.start();
            this.h = r3;
            return;
        L23:
            return;
        L13:
            r2 = false;
            goto L14
        }

        @Override // android.view.View
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
            a();
        }

        public a(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            super(r4);
            this.a = new RectF();
            this.b = new Paint(1);
            this.c = new Matrix();
            int r5 = gz8.g.d(r4);
            this.d = r5;
            int r0 = j.a;
            this.e = Color.argb(0, Color.red(r5), Color.green(r5), Color.blue(r5));
        }

        @Override // android.view.View
        public final void onDraw(Canvas r13) {
            Intrinsics.checkNotNullParameter(r13, "canvas");
            super.onDraw(r13);
            this.a.set(0.0f, 0.0f, getWidth(), getHeight());
            float r0 = i5.Y();
            if (getWidth() > 0) goto L5;
            LinearGradient r1 = null;
        L9:
            if (r1 != null) goto L11;
            return;
        L11:
            this.c.setTranslate(((this.g * getWidth()) * 3.0f) - (getWidth() * 2.0f), 0.0f);
            r1.setLocalMatrix(this.c);
            r13.drawRoundRect(this.a, r0, r0, this.b);
            return;
        L5:
            r1 = this.f;
            if (r1 != null) goto L9;
            float r7 = getWidth();
            int r4 = this.d;
            r1 = new LinearGradient(0.0f, 0.0f, r7, 0.0f, new int[]{r4, this.e, r4}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
            this.f = r1;
            this.b.setShader(r1);
            goto L9
        }

        @Override // android.view.View
        public final void onWindowVisibilityChanged(int r1) {
            super.onWindowVisibilityChanged(r1);
            a();
        }

        @Override // android.view.View
        public final void onVisibilityChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "changedView");
            super.onVisibilityChanged(r2, r3);
            a();
        }

        @Override // android.view.View
        public final void onSizeChanged(int r1, int r2, int r3, int r4) {
            super.onSizeChanged(r1, r2, r3, r4);
            this.f = null;
            a();
        }
    }

    static {
    }
}
