package rx1;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements View.OnTouchListener {
    public float a;
    public float b;
    public float c;
    public float d;
    public int e;
    public int f;
    public final /* synthetic */ g g;

    public h(g r1) {
        this.g = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r10, MotionEvent r11) {
        int r0 = r11.getAction();
        if (r0 == 0) goto L78;
        boolean r2 = false;
        if (r0 == 1) goto L34;
        if (r0 != 2) goto L85;
        this.c = r11.getRawX() - this.a;
        this.d = r11.getRawY() - this.b;
        if (Math.abs(this.c) <= 0.0f) goto L11;
    L12:
        r2 = true;
    L13:
        if (r2 == false) goto L33;
        g r1 = this.g;
        f r3 = r1.a;
        int r4 = (int) (r3.d + this.c);
        this.e = r4;
        this.f = (int) (r3.e + this.d);
        l.a r5 = r1.b;
        if (r5.t == false) goto L28;
        int r6 = r5.f;
        if (r4 >= r6) goto L19;
        this.e = r6;
    L19:
        int r7 = this.e;
        int r8 = r1.m - r10.getWidth();
        g r9 = this.g;
        int r12 = r9.b.g;
        if (r7 <= (r8 - r12)) goto L22;
        this.e = (r9.m - r12) - r10.getWidth();
    L22:
        int r13 = this.f;
        g r14 = this.g;
        int r15 = r14.b.h;
        if (r13 >= r15) goto L25;
        this.f = r15;
    L25:
        int r16 = this.f;
        int r17 = r14.n - r10.getHeight();
        g r18 = this.g;
        int r19 = r18.b.i;
        if (r16 <= (r17 - r19)) goto L28;
        this.f = (r18.n - r19) - r10.getHeight();
    L28:
        g r110 = this.g;
        if (r110.b.e == 5) goto L33;
        r110.a.a(this.e, this.f);
        e r111 = this.g.b.s;
        if (r111 == null) goto L33;
        r111.d();
    L33:
        this.a = r11.getRawX();
        this.b = r11.getRawY();
        goto L85
    L11:
        if (Math.abs(this.d) <= 0.0f) goto L13;
    L85:
        return this.g.i;
    L34:
        this.g.g = r11.getRawX();
        this.g.h = r11.getRawY();
        g r112 = this.g;
        float r20 = Math.abs(r112.g - r112.e);
        g r21 = this.g;
        if (r20 <= r21.j) goto L37;
    L40:
        boolean r22 = true;
    L41:
        r112.i = r22;
        g r113 = this.g;
        l.a r23 = r113.b;
        int r24 = r23.e;
        if (r24 == 3) goto L48;
        if (r24 != 4) goto L69;
        PropertyValuesHolder r114 = PropertyValuesHolder.ofInt("x", new int[]{r113.a.d, 0});
        r113.b.getClass();
        ValueAnimator r115 = ObjectAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{r114, PropertyValuesHolder.ofInt("y", new int[]{r113.a.e, 0})});
        r113.c = r115;
        r115.addUpdateListener(new i(r113));
        r113.f();
    L69:
        if (r113.i == true) goto L74;
        e r116 = r23.s;
        if (r116 == null) goto L74;
        r116.onClick();
    L74:
        if (r113.i == false) goto L85;
        e r117 = r113.b.s;
        if (r117 == null) goto L85;
        r117.a();
        goto L85
    L48:
        if (r113.i == false) goto L69;
        int r25 = r113.a.d;
        if (((r25 * 2) + r10.getWidth()) <= UIUtils.getScreenWidth(r113.b.a)) goto L52;
        int r26 = (UIUtils.getScreenWidth(r113.b.a) - r10.getWidth()) - r113.p;
    L53:
        int r118 = r113.a.e;
        int r27 = r113.q;
        if (r118 < r27) goto L61;
        if (r118 <= (s1.w() - r113.r)) goto L59;
        r27 = s1.w() - r113.r;
        goto L61
    L59:
        r27 = r118;
    L61:
        if (r113.r == 0) goto L63;
    L64:
        if (r118 == r27) goto L66;
        ValueAnimator r119 = ObjectAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("x", new int[]{r25, r26}), PropertyValuesHolder.ofInt("y", new int[]{r118, r27})});
        r113.c = r119;
        r119.addUpdateListener(new j(r113));
    L67:
        r113.f();
    L66:
        ValueAnimator r120 = ObjectAnimator.ofInt(new int[]{r25, r26});
        r113.c = r120;
        r120.addUpdateListener(new k(r113));
        goto L67
    L63:
        if (r113.q == 0) goto L66;
    L52:
        r26 = r113.o;
        goto L53
    L37:
        if (Math.abs(r21.h - r21.f) > this.g.j) goto L40;
        r22 = false;
        goto L41
    L78:
        this.g.e = r11.getRawX();
        this.g.f = r11.getRawY();
        this.a = r11.getRawX();
        this.b = r11.getRawY();
        g r121 = this.g;
        ValueAnimator r122 = r121.c;
        if (r122 != null) goto L81;
    L83:
        g r123 = this.g;
        r123.n = UIUtils.getScreenHeight(r123.b.a);
        g r124 = this.g;
        r124.m = UIUtils.getScreenWidth(r124.b.a);
        goto L85
    L81:
        if (r122.isRunning() == false) goto L83;
        r121.c.cancel();
        goto L83
    }
}
