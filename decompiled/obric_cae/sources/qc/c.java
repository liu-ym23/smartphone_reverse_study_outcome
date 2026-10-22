package qc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import he.i;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f11293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f11294b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueAnimator f11295m;

    public c(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
    }

    public abstract boolean a();

    public abstract void b(String r8, float r10);

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        i.f(r8, "event");
        int r10 = r8.getAction();
        if (r10 == 0) goto L22;
        if (r10 == 1) goto L9;
        if (r10 == 3) goto L9;
    L35:
        return super.dispatchTouchEvent(r8);
    L9:
        if (a() == false) goto L35;
        ValueAnimator r11 = this.f11294b;
        if (r11 == null) goto L14;
        r11.removeAllUpdateListeners();
    L14:
        ValueAnimator r12 = this.f11294b;
        if (r12 == null) goto L17;
        r12.cancel();
    L17:
        ValueAnimator r13 = this.f11295m;
        if (r13 == null) goto L20;
        r13.cancel();
    L20:
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{this.f11293a, 0.0f});
        r14.setDuration(200);
        r14.setInterpolator(new DecelerateInterpolator());
        r14.addUpdateListener(new b(this));
        j r15 = j.f13877a;
        r14.start();
        this.f11295m = r14;
        goto L35
    L22:
        if (a() == false) goto L35;
        ValueAnimator r16 = this.f11295m;
        if (r16 == null) goto L27;
        r16.removeAllUpdateListeners();
    L27:
        ValueAnimator r17 = this.f11295m;
        if (r17 == null) goto L30;
        r17.cancel();
    L30:
        ValueAnimator r18 = this.f11294b;
        if (r18 == null) goto L33;
        r18.cancel();
    L33:
        ValueAnimator r19 = ValueAnimator.ofFloat(new float[]{this.f11293a, 1.0f});
        r19.setDuration(50);
        r19.setInterpolator(new DecelerateInterpolator());
        r19.addUpdateListener(new a(this));
        j r20 = j.f13877a;
        r19.start();
        this.f11294b = r19;
        goto L35
    }

    public c(Context r8, AttributeSet r10, int r11) {
        i.f(r8, "context");
        super(r8, r10, r11);
    }
}
