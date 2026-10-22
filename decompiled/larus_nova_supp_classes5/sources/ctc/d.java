package ctc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import ftc.b;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d implements MovementMethod {
    public float a;
    public ctc.a b;
    public VelocityTracker c;
    public final a d;
    public final float e;
    public final int f;
    public boolean g;
    public float h;
    public float i;
    public boolean j;
    public boolean k;
    public final MovementMethod l;
    public final boolean m;

    public static final class a {
        public ValueAnimator a;
        public final OverScroller b;

        /* JADX INFO: renamed from: ctc.d$a$a, reason: collision with other inner class name */
        public static final class InterpolatorC0012a implements Interpolator {
            public static final InterpolatorC0012a a = null;

            static {
                a = new InterpolatorC0012a();
            }

            public InterpolatorC0012a() {
            }

            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float r3) {
                float r4 = r3 - 1.0f;
                return ((((r4 * r4) * r4) * r4) * r4) + 1.0f;
            }
        }

        public a(Context r3) {
            this.b = new OverScroller(r3, InterpolatorC0012a.a);
        }
    }

    @Override // android.text.method.MovementMethod
    public final boolean canSelectArbitrarily() {
        return this.l.canSelectArbitrarily();
    }

    @Override // android.text.method.MovementMethod
    public final void initialize(TextView r2, Spannable r3) {
        this.l.initialize(r2, r3);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onGenericMotionEvent(TextView r2, Spannable r3, MotionEvent r4) {
        return this.l.onGenericMotionEvent(r2, r3, r4);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onKeyDown(TextView r2, Spannable r3, int r4, KeyEvent r5) {
        return this.l.onKeyDown(r2, r3, r4, r5);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onKeyOther(TextView r2, Spannable r3, KeyEvent r4) {
        return this.l.onKeyOther(r2, r3, r4);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onKeyUp(TextView r2, Spannable r3, int r4, KeyEvent r5) {
        return this.l.onKeyUp(r2, r3, r4, r5);
    }

    @Override // android.text.method.MovementMethod
    public final void onTakeFocus(TextView r2, Spannable r3, int r4) {
        this.l.onTakeFocus(r2, r3, r4);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onTrackballEvent(TextView r2, Spannable r3, MotionEvent r4) {
        return this.l.onTrackballEvent(r2, r3, r4);
    }

    public final void a(TextView r19, MotionEvent r20) {
        int r3 = r20.getActionMasked();
        int r6 = 0;
        if (r3 != 0) goto L42;
        this.g = true;
        this.h = r20.getX();
        this.i = r20.getY();
        a r7 = this.d;
        if (r7 == null) goto L10;
        ValueAnimator r8 = r7.a;
        if (r8 == null) goto L9;
        r8.cancel();
    L9:
        r7.a = null;
        r7.b.abortAnimation();
    L10:
        int r9 = b.a;
        ctc.a[] r10 = (ctc.a[]) b.a.a(r20, r19, ctc.a.class);
        if (r10 == null) goto L13;
        ctc.a r11 = (ctc.a) ArraysKt.firstOrNull(r10);
    L14:
        this.b = r11;
        if (r11 != null) goto L17;
    L79:
        if (r3 != 1) goto L81;
    L82:
        ctc.a r4 = this.b;
        if (r4 == null) goto L99;
        VelocityTracker r5 = this.c;
        if (r5 == null) goto L106;
        r5.computeCurrentVelocity(1000, this.e);
    L106:
        VelocityTracker r12 = this.c;     // Catch: Exception -> L92
        if (r12 == null) goto L91;
        r6 = MathKt.roundToInt(r12.getXVelocity());     // Catch: Exception -> L92
    L91:
        int r13 = r6;
    L93:
        a r14 = this.d;
        if (r14 == null) goto L99;
        OverScroller r15 = r14.b;
        int r16 = (int) r4.a;
        float r17 = r4.b;
        r15.fling(r16, 0, r13, 0, -((int) r17), 0, 0, 0, (int) (Math.abs(r17) * r4.c), 0);
        ValueAnimator r18 = r14.a;
        if (r18 == null) goto L98;
        r18.cancel();
    L98:
        ValueAnimator r21 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r21.setDuration(LongCompanionObject.MAX_VALUE);
        r21.addUpdateListener(new c(r14, r4, r19));
        r21.start();
        r14.a = r21;
        ctc.a r1 = null;
    L100:
        this.b = r1;
        VelocityTracker r22 = this.c;
        if (r22 == null) goto L103;
        r22.recycle();
    L103:
        this.c = r1;
    L104:
        this.a = r20.getX();
        return;
    L92:
        r13 = 0;
    L99:
        r1 = null;
        goto L100
    L81:
        if (r3 != 3) goto L104;
    L17:
        if (r11.a() == false) goto L22;
        ViewParent r23 = r19.getParent();
        if (r23 == null) goto L22;
        r23.requestDisallowInterceptTouchEvent(true);
    L22:
        if (Math.abs(r11.a) >= r11.b) goto L24;
    L27:
        boolean r24 = true;
    L28:
        this.j = r24;
        if (r11.a >= 0) goto L31;
    L34:
        boolean r25 = true;
    L35:
        this.k = r25;
        VelocityTracker r26 = this.c;
        if (r26 == null) goto L38;
        r26.clear();
    L39:
        VelocityTracker r27 = this.c;
        if (r27 == null) goto L79;
        r27.addMovement(r20);
        goto L79
    L38:
        this.c = VelocityTracker.obtain();
        goto L39
    L31:
        if (r11.c != 0.0f) goto L34;
        r25 = false;
        goto L35
    L24:
        if (r11.c != 0.0f) goto L27;
        r24 = false;
        goto L28
    L13:
        r11 = null;
        goto L14
    L42:
        ctc.a r28 = this.b;
        if (r28 == null) goto L79;
        if (r28.a() == false) goto L79;
        float r29 = Math.abs(r20.getX() - this.h);
        if (this.g == true) goto L49;
    L51:
        float r30 = Math.abs(r20.getY() - this.i);
        if (r30 <= r29) goto L59;
        if (r30 <= this.f) goto L59;
        ViewParent r110 = r19.getParent();
        if (r110 == null) goto L59;
        r110.requestDisallowInterceptTouchEvent(false);
    L59:
        if (r29 > r30) goto L61;
    L76:
        VelocityTracker r31 = this.c;
        if (r31 == null) goto L79;
        r31.addMovement(r20);
        goto L79
    L61:
        if (r29 <= this.f) goto L76;
        if (this.m == true) goto L65;
    L75:
        r28.b(r28.a + (r20.getX() - this.a));
        ViewCompat.postInvalidateOnAnimation(r19);
        goto L76
    L65:
        if (r20.getX() <= this.h) goto L69;
        if (this.k == true) goto L69;
    L72:
        ViewParent r32 = r19.getParent();
        if (r32 == null) goto L75;
        r32.requestDisallowInterceptTouchEvent(false);
    L69:
        if (r20.getX() >= this.h) goto L75;
        if (this.j == true) goto L75;
    L49:
        if (r29 <= this.f) goto L51;
        r19.cancelLongPress();
        this.g = false;
        goto L51
    }

    public d(Context r4, io.noties.markwon.ext.tables.d r5, boolean r6) {
        this.l = r5;
        this.m = r6;
        int r7 = b.a;
        String r8 = Build.MANUFACTURER;
        String r9 = Build.BRAND;
        String r0 = Build.MODEL;
        boolean r2 = true;
        if (StringsKt.equals(r8, "Xiaomi", true) == false) goto L5;
    L14:
        if (r2 == false) goto L21;
    L17:
        a r10 = null;
    L18:
        this.d = r10;
        this.e = ViewConfiguration.get(r4).getScaledMaximumFlingVelocity();
        this.f = ViewConfiguration.get(r4).getScaledTouchSlop();
        return;
    L21:
        r10 = new a(r4);     // Catch: Exception -> L20
    L5:
        if (StringsKt.equals(r9, "Xiaomi", true) == true) goto L14;
        if (StringsKt.equals(r9, "Redmi", true) == true) goto L14;
        if (StringsKt.startsWith(r0, "Mi", true) == true) goto L14;
        if (StringsKt.startsWith(r0, "Redmi", true) == true) goto L14;
        r2 = false;
        goto L14
    }

    @Override // android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r3, Spannable r4, MotionEvent r5) {
        a(r3, r5);     // Catch: Exception -> L4
    L7:
        return this.l.onTouchEvent(r3, r4, r5);
    L4:
        e = move-exception;
        e.toString();
        goto L7
    }
}
