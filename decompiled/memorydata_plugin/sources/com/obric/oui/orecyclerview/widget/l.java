package com.obric.oui.orecyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class l extends RecyclerView.g implements RecyclerView.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List<View> f14211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    RecyclerView.v f14212b;
    float c;
    float d;
    int e;
    a f;
    int g;
    List<b> h;
    RecyclerView i;
    VelocityTracker j;
    View k;
    int l;
    private final float[] m;
    private float n;
    private float o;
    private float p;
    private float q;
    private int r;
    private RecyclerView.c s;
    private long t;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Interpolator f14218a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Interpolator f14219b = null;

        static {
            f14218a = new AnonymousClass1();
            f14219b = new AnonymousClass2();
        }

        public static int a(int r3, int r4) {
            int r1 = r3 & 789516;
            if (r1 != 0) goto L5;
            return r3;
        L5:
            int r5 = r3 & (~r1);
            if (r4 != 0) goto L10;
            int r6 = r1 << 2;
        L9:
            return r5 | r6;
        L10:
            int r7 = r1 << 1;
            r5 = r5 | ((-789517) & r7);
            r6 = (r7 & 789516) << 2;
            goto L9
        }

        public static int b(int r2, int r3) {
            int r0 = c(0, r3 | r2);
            int r4 = c(1, r3) | r0;
            return c(2, r2) | r4;
        }

        public static int c(int r0, int r1) {
            return r1 << (r0 * 8);
        }

        public float a(float r1) {
            return r1;
        }

        public float a(RecyclerView.v r1) {
            return 0.5f;
        }

        public abstract int a(RecyclerView r1, RecyclerView.v r2);

        public long a(RecyclerView r1, int r2, float r3, float r4) {
            RecyclerView.e r0 = r1.getItemAnimator();
            if (r0 != null) goto L8;
            if (r2 != 8) goto L6;
            return 200;
        L6:
            return 250;
        L8:
            if (r2 != 8) goto L11;
            return r0.g();
        L11:
            return r0.a();
        }

        public void a(Canvas r9, RecyclerView r10, RecyclerView.v r11, float r12, float r13, int r14, boolean r15) {
            n.f14222a.a(r9, r10, r11.c, r12, r13, r14, r15);
        }

        void a(Canvas r15, RecyclerView r16, RecyclerView.v r17, List<b> r18, int r19, float r20, float r21) {
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
            int r11 = r10.size();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            b r0 = (b) ZeusTransformUtils.preCheckCast(r10.get(r12), b.class, "com.obric.memorydata.plugin");
            r0.update();
            int r13 = r15.save();
            a(r15, r16, r0.h, r0.m, r0.n, r0.i, false);
            r15.restoreToCount(r13);
            r12 = r12 + 1;
            goto L3
        L5:
            if (r17 == null) goto L9;
            int r9 = r15.save();
            a(r15, r16, r17, r20, r21, r19, true);
            r15.restoreToCount(r9);
            return;
        }

        public abstract void a(RecyclerView.v r1, int r2);

        public float b(float r1) {
            return r1;
        }

        final int b(RecyclerView r1, RecyclerView.v r2) {
            return d(a(r1, r2), ViewCompat.getLayoutDirection(r1));
        }

        public void b(Canvas r9, RecyclerView r10, RecyclerView.v r11, float r12, float r13, int r14, boolean r15) {
            n.f14222a.b(r9, r10, r11.c, r12, r13, r14, r15);
        }

        void b(Canvas r16, RecyclerView r17, RecyclerView.v r18, List<b> r19, int r20, float r21, float r22) {
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
            int r11 = r10.size();
            boolean r12 = false;
            int r13 = 0;
        L3:
            if (r13 >= r11) goto L5;
            b r0 = (b) ZeusTransformUtils.preCheckCast(r10.get(r13), b.class, "com.obric.memorydata.plugin");
            int r14 = r16.save();
            b(r16, r17, r0.h, r0.m, r0.n, r0.i, false);
            r16.restoreToCount(r14);
            r13 = r13 + 1;
            goto L3
        L5:
            if (r18 == null) goto L7;
            int r15 = r16.save();
            b(r16, r17, r18, r21, r22, r20, true);
            r16.restoreToCount(r15);
        L7:
            int r110 = r11 - 1;
        L8:
            if (r110 < 0) goto L18;
            b r1 = (b) ZeusTransformUtils.preCheckCast(r10.get(r110), b.class, "com.obric.memorydata.plugin");
            if (r1.p == false) goto L15;
            if (r1.l == true) goto L15;
            r10.remove(r110);
        L17:
            r110 = r110 - 1;
        L15:
            if (r1.p == true) goto L17;
            r12 = true;
            goto L17
        L18:
            if (r12 == false) goto L26;
            r17.invalidate();
            return;
        }

        public void b(RecyclerView.v r1, int r2) {
            if (r1 == null) goto L5;
            n.f14222a.b(r1.c);
            return;
        }

        public void c(RecyclerView r1, RecyclerView.v r2) {
            n.f14222a.a(r2.c);
        }

        public int d(int r3, int r4) {
            int r0 = r3 & 3158064;
            if (r0 != 0) goto L5;
            return r3;
        L5:
            int r5 = r3 & (~r0);
            if (r4 != 0) goto L10;
            int r2 = r0 >> 2;
        L9:
            return r2 | r5;
        L10:
            int r6 = r0 >> 1;
            r5 = r5 | ((-3158065) & r6);
            r2 = (3158064 & r6) >> 2;
            goto L9
        }
    }

    static class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f14220a;
        final float d;
        final float e;
        final float f;
        final float g;
        final RecyclerView.v h;
        final int i;
        final ValueAnimator j;
        final int k;
        boolean l;
        float m;
        float n;
        boolean o;
        boolean p;

        b(RecyclerView.v r2, int r3, int r4, float r5, float r6, float r7, float r8) {
            this.o = false;
            this.p = false;
            this.i = r4;
            this.k = r3;
            this.h = r2;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.j = r9;
            r9.addUpdateListener(new AnonymousClass1(this));
            r9.setTarget(r2.c);
            r9.addListener(this);
            a(0.0f);
        }

        public void a() {
            this.h.b(false);
            this.j.start();
        }

        public void a(float r1) {
            this.f14220a = r1;
        }

        public void a(long r1) {
            this.j.setDuration(r1);
        }

        public void b() {
            this.j.cancel();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            a(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            if (this.p == true) goto L5;
            this.h.b(true);
        L5:
            this.p = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r1) {
        }

        public void update() {
            float r0 = this.d;
            float r1 = this.f;
            if (r0 != r1) goto L5;
            float r2 = this.h.c.getTranslationX();
        L6:
            this.m = r2;
            float r3 = this.e;
            float r4 = this.g;
            if (r3 != r4) goto L9;
            float r5 = this.h.c.getTranslationY();
        L10:
            this.n = r5;
            return;
        L9:
            r5 = r3 + (this.f14220a * (r4 - r3));
            goto L10
        L5:
            r2 = r0 + (this.f14220a * (r1 - r0));
            goto L6
        }
    }

    private int a(RecyclerView.v r6) {
        if (this.r != 2) goto L5;
        return 0;
    L5:
        int r0 = this.f.a(this.i, r6);
        int r2 = (this.f.d(r0, ViewCompat.getLayoutDirection(this.i)) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (r2 != 0) goto L8;
        return 0;
    L8:
        int r1 = (r0 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (Math.abs(this.c) <= Math.abs(this.d)) goto L20;
        int r3 = b(r6, r2);
        if (r3 > 0) goto L13;
        int r5 = c(r6, r2);
        if (r5 <= 0) goto L30;
        return r5;
    L30:
        return 0;
    L13:
        if ((r1 & r3) == 0) goto L15;
        return r3;
    L15:
        return a.a(r3, ViewCompat.getLayoutDirection(this.i));
    L20:
        int r4 = c(r6, r2);
        if (r4 <= 0) goto L23;
        return r4;
    L23:
        int r7 = b(r6, r2);
        if (r7 <= 0) goto L30;
        if ((r1 & r7) == 0) goto L28;
        return r7;
    L28:
        return a.a(r7, ViewCompat.getLayoutDirection(this.i));
    }

    private void a(float[] r4) {
        if ((this.g & 12) == 0) goto L5;
        r4[0] = (this.p + this.c) - this.f14212b.c.getLeft();
    L7:
        if ((this.g & 3) == 0) goto L9;
        r4[1] = (this.q + this.d) - this.f14212b.c.getTop();
        return;
    L9:
        r4[1] = this.f14212b.c.getTranslationY();
        return;
    L5:
        r4[0] = this.f14212b.c.getTranslationX();
        goto L7
    }

    private int b(RecyclerView.v r9, int r10) {
        if ((r10 & 12) == 0) goto L29;
        int r2 = 8;
        if (this.c <= 0.0f) goto L7;
        int r0 = 8;
    L8:
        VelocityTracker r4 = this.j;
        if (r4 != null) goto L11;
    L24:
        float r1 = this.i.getWidth() * this.f.a(r9);
        if ((r10 & r0) != 0) goto L27;
        return 0;
    L27:
        if (Math.abs(this.c) <= r1) goto L32;
        return r0;
    L32:
        return 0;
    L11:
        if (this.e <= (-1)) goto L24;
        r4.computeCurrentVelocity(1000, this.f.b(this.o));
        float r5 = this.j.getXVelocity(this.e);
        float r6 = this.j.getYVelocity(this.e);
        if (r5 > 0.0f) goto L16;
        r2 = 4;
    L16:
        float r3 = Math.abs(r5);
        if ((r2 & r10) == 0) goto L24;
        if (r0 != r2) goto L24;
        if (r3 < this.f.a(this.n)) goto L24;
        if (r3 <= Math.abs(r6)) goto L24;
        return r2;
    L7:
        r0 = 4;
        goto L8
    L29:
        return 0;
    }

    private void b() {
        VelocityTracker r0 = this.j;
        if (r0 == null) goto L6;
        r0.recycle();
        this.j = null;
        return;
    }

    private int c(RecyclerView.v r9, int r10) {
        if ((r10 & 3) == 0) goto L29;
        int r2 = 2;
        if (this.d <= 0.0f) goto L7;
        int r0 = 2;
    L8:
        VelocityTracker r4 = this.j;
        if (r4 != null) goto L11;
    L24:
        float r1 = this.i.getHeight() * this.f.a(r9);
        if ((r10 & r0) != 0) goto L27;
        return 0;
    L27:
        if (Math.abs(this.d) <= r1) goto L32;
        return r0;
    L32:
        return 0;
    L11:
        if (this.e <= (-1)) goto L24;
        r4.computeCurrentVelocity(1000, this.f.b(this.o));
        float r5 = this.j.getXVelocity(this.e);
        float r6 = this.j.getYVelocity(this.e);
        if (r6 > 0.0f) goto L16;
        r2 = 1;
    L16:
        float r3 = Math.abs(r6);
        if ((r2 & r10) == 0) goto L24;
        if (r2 != r0) goto L24;
        if (r3 < this.f.a(this.n)) goto L24;
        if (r3 <= Math.abs(r5)) goto L24;
        return r2;
    L7:
        r0 = 1;
        goto L8
    L29:
        return 0;
    }

    private void c() {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        return;
    L6:
        if (this.s != null) goto L8;
        this.s = new AnonymousClass3(this);
    L8:
        this.i.setChildDrawingOrderCallback(this.s);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
    public void a(Canvas r10, RecyclerView r11, RecyclerView.s r12) {
        if (this.f14212b == null) goto L5;
        a(this.m);
        float[] r13 = this.m;
        float r0 = r13[0];
        float r8 = r13[1];
        float r7 = r0;
    L6:
        this.f.b(r10, r11, this.f14212b, this.h, this.r, r7, r8);
        return;
    L5:
        r7 = 0.0f;
        r8 = 0.0f;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
    public void a(Rect r1, View r2, RecyclerView r3, RecyclerView.s r4) {
        r1.setEmpty();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.j
    public void a(View r1) {
    }

    void a(RecyclerView.v r24, int r25) {
        if (r24 == this.f14212b) goto L5;
    L7:
        this.t = Long.MIN_VALUE;
        final int r4 = this.r;
        a(r24, true);
        this.r = r25;
        if (r25 != 2) goto L13;
        if (r24 == null) goto L12;
        this.k = r24.c;
        c();
        goto L13
    L12:
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
    L13:
        int r16 = (1 << ((r25 * 8) + 8)) - 1;
        final RecyclerView.v r9 = this.f14212b;
        if (r9 != null) goto L16;
        boolean r8 = false;
    L41:
        if (r24 == null) goto L45;
        this.g = (this.f.b(this.i, r24) & r16) >> (this.r * 8);
        this.p = r24.c.getLeft();
        this.q = r24.c.getTop();
        this.f14212b = r24;
        if (r25 != 2) goto L45;
        boolean r1 = false;
        r24.c.performHapticFeedback(0);
    L46:
        ViewParent r0 = this.i.getParent();
        if (r0 != null) goto L49;
    L53:
        if (r8 == true) goto L55;
        this.i.getLayoutManager().L();
    L55:
        this.f.b(this.f14212b, this.r);
        this.i.invalidate();
        return;
    L49:
        if (this.f14212b == null) goto L51;
        boolean r14 = true;
    L52:
        r0.requestDisallowInterceptTouchEvent(r14);
        goto L53
    L51:
        r14 = r1;
    L45:
        r1 = false;
        goto L46
    L16:
        if (r9.c.getParent() == null) goto L38;
        if (r4 != 2) goto L19;
        int r7 = 0;
    L20:
        b();
        if (r7 == 1) goto L31;
        if (r7 == 2) goto L31;
        if (r7 == 4) goto L30;
        if (r7 == 8) goto L30;
        if (r7 == 16) goto L30;
        if (r7 == 32) goto L30;
        float r17 = 0.0f;
        float r18 = 0.0f;
    L32:
        if (r4 != 2) goto L34;
        int r6 = 8;
    L37:
        a(this.m);
        float[] r2 = this.m;
        final float r19 = r2[0];
        final float r20 = r2[1];
        final int r3 = r6;
        final int r21 = r7;
        final float r10 = r17;
        final float r11 = r18;
        b r5 = new AnonymousClass1(this, r9, r3, r4, r19, r20, r10, r11, r21, r9);
        r5.a(this.f.a(this.i, r6, r17 - r19, r18 - r20));
        this.h.add(r5);
        r5.a();
        r8 = true;
    L39:
        this.f14212b = null;
        goto L41
    L34:
        if (r7 <= 0) goto L36;
        r6 = 2;
        goto L37
    L36:
        r6 = 4;
    L30:
        r18 = 0.0f;
        r17 = Math.signum(this.c) * this.i.getWidth();
    L31:
        r17 = 0.0f;
        r18 = Math.signum(this.d) * this.i.getHeight();
        goto L32
    L19:
        r7 = a(r9);
        goto L20
    L38:
        c(r9.c);
        this.f.c(this.i, r9);
        r8 = false;
        goto L39
    L5:
        if (r25 != this.r) goto L7;
    }

    void a(RecyclerView.v r5, boolean r6) {
        int r0 = this.h.size() - 1;
    L3:
        if (r0 < 0) goto L12;
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.h.get(r0), b.class, "com.obric.memorydata.plugin");
        if (r1.h == r5) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        r1.o |= r6;
        if (r1.p == true) goto L9;
        r1.b();
    L9:
        this.h.remove(r0);
        return;
    }

    void a(final b r3, final int r4) {
        this.i.post(new AnonymousClass2(this, r3, r4));
    }

    boolean a() {
        int r0 = this.h.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (((b) ZeusTransformUtils.preCheckCast(this.h.get(r2), b.class, "com.obric.memorydata.plugin")).p == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
    public void b(Canvas r10, RecyclerView r11, RecyclerView.s r12) {
        this.l = -1;
        if (this.f14212b == null) goto L5;
        a(this.m);
        float[] r13 = this.m;
        float r0 = r13[0];
        float r8 = r13[1];
        float r7 = r0;
    L6:
        this.f.a(r10, r11, this.f14212b, this.h, this.r, r7, r8);
        return;
    L5:
        r7 = 0.0f;
        r8 = 0.0f;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.j
    public void b(View r3) {
        c(r3);
        RecyclerView.v r4 = this.i.getChildViewHolder(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        RecyclerView.v r0 = this.f14212b;
        if (r0 == null) goto L9;
        if (r4 != r0) goto L9;
        a(null, 0);
        return;
    L9:
        a(r4, false);
        if (this.f14211a.remove(r4.c) == false) goto L14;
        this.f.c(this.i, r4);
        return;
    }

    void c(View r2) {
        if (r2 != this.k) goto L8;
        this.k = null;
        if (this.s == null) goto L9;
        this.i.setChildDrawingOrderCallback(null);
        return;
    L9:
        return;
    }
}
