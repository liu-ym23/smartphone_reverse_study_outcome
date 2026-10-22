package p6a;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import com.obric.assistant.AutoEndConversationTime;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends c implements Animatable, ValueAnimator.AnimatorUpdateListener {
    public int b;
    public int c;
    public int d;
    public final ValueAnimator e;
    public final Path f;

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.e.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        if (this.e.isRunning() == true) goto L6;
        this.e.addUpdateListener(this);
        this.e.start();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        if (this.e.isRunning() == false) goto L6;
        this.e.removeAllListeners();
        this.e.removeAllUpdateListeners();
        this.e.cancel();
        return;
    }

    public d() {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.f = new Path();
        ValueAnimator r0 = ValueAnimator.ofInt(new int[]{30, 3600});
        this.e = r0;
        r0.setDuration(AutoEndConversationTime.AFTER_10_SECONDS);
        r0.setInterpolator(null);
        r0.setRepeatCount(-1);
        r0.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r14) {
        Rect r0 = getBounds();
        int r1 = r0.width();
        int r2 = r0.height();
        float r3 = r1;
        float r4 = Math.max(1.0f, r3 / 22.0f);
        if (this.b == r1) goto L5;
    L6:
        this.f.reset();
        float r9 = r3 - r4;
        float r12 = r2 / 2.0f;
        this.f.addCircle(r9, r12, r4, Path.Direction.CW);
        float r5 = r3 - (5.0f * r4);
        this.f.addRect(r5, r12 - r4, r9, r12 + r4, Path.Direction.CW);
        this.f.addCircle(r5, r12, r4, Path.Direction.CW);
        this.b = r1;
        this.c = r2;
    L7:
        r14.save();
        float r6 = r3 / 2.0f;
        float r7 = r2 / 2.0f;
        r14.rotate(this.d, r6, r7);
        int r8 = 0;
    L9:
        if (r8 >= 12) goto L11;
        this.a.setAlpha((r8 + 5) * 17);
        r14.rotate(30.0f, r6, r7);
        r14.drawPath(this.f, this.a);
        r8 = r8 + 1;
        goto L9
    L11:
        r14.restore();
        return;
    L5:
        if (this.c == r2) goto L7;
        goto L6
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r1) {
        this.d = (((Integer) r1.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }
}
