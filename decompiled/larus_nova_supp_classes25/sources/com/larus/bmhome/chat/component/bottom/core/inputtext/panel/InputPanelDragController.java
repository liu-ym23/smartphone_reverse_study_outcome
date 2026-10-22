package com.larus.bmhome.chat.component.bottom.core.inputtext.panel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class InputPanelDragController {
    public final n a;
    public final RecyclerView b;
    public final Function0<Integer> c;
    public final Function0<Unit> d;
    public final Function0<Integer> e;
    public final Function0<Unit> f;
    public int g;
    public int h;
    public boolean i;
    public Integer j;
    public boolean k;
    public int l;
    public float m;
    public ValueAnimator n;
    public Integer o;
    public boolean p;
    public final View q;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.panel.InputPanelDragController$8, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public /* synthetic */ class AnonymousClass8 extends FunctionReferenceImpl implements Function2<Float, Boolean, Unit> {
        public AnonymousClass8(Object r8) {
            super(2, r8, InputPanelDragController.class, "finishDrag", "finishDrag(FZ)V", 0);
        }

        public final void invoke(float r8, boolean r9) {
            InputPanelDragController r1 = (InputPanelDragController) ((CallableReference) this).receiver;
            r1.k = false;
            int r2 = r1.e();
            int r3 = r1.f();
            if (r1.i == false) goto L11;
            if (r9 == true) goto L11;
            if (r2 < (r3 - c7.b(48))) goto L10;
            if (r2 >= r3) goto L11;
            if (r8 <= c7.b(1000)) goto L11;
        L10:
            boolean r4 = true;
        L12:
            int r6 = ((r1.d() - r3) / 2) + r3;
            if (r4 == false) goto L15;
            int r5 = 0;
        L32:
            if (r4 == false) goto L34;
            Integer r10 = null;
        L35:
            r1.j = r10;
            r1.a(r5, r4, 180, new DecelerateInterpolator());
            return;
        L34:
            r10 = Integer.valueOf(r5);
            goto L35
        L15:
            if (r9 == false) goto L20;
            if (r1.l < r6) goto L31;
            int r11 = r1.d();
        L30:
            r5 = r11;
        L31:
            r5 = r3;
            goto L32
        L20:
            if (r1.i == false) goto L23;
            r11 = r1.d();
            goto L30
        L23:
            if (r8 >= (-c7.b(1000))) goto L26;
            r11 = r1.d();
            goto L30
        L26:
            if (r8 > c7.b(1000)) goto L31;
            if (r2 < r6) goto L31;
            r11 = r1.d();
        L11:
            r4 = false;
            goto L12
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke(((Number) r1).floatValue(), ((Boolean) r2).booleanValue());
            return Unit.INSTANCE;
        }
    }

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ InputPanelDragController a;
        public final /* synthetic */ boolean b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            InputPanelDragController r3 = this.a;
            r3.n = null;
            r3.o = null;
            r3.p = false;
            if (this.b == false) goto L6;
            r3.d.invoke();
            return;
        }

        public a(InputPanelDragController r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void c() {
        ValueAnimator r0 = this.n;
        if (r0 == null) goto L5;
        r0.removeAllListeners();
    L5:
        ValueAnimator r1 = this.n;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.n = null;
        this.o = null;
        this.p = false;
    }

    public final int d() {
        return Math.min(this.g, RangesKt.coerceAtLeast(((Number) this.c.invoke()).intValue(), 0));
    }

    public final int e() {
        return RangesKt.coerceAtLeast(this.a.getLayoutParams().height, 0);
    }

    public final int f() {
        if (this.i == false) goto L6;
        return d();
    L6:
        return Math.min(this.h, d());
    }

    public final int h() {
        Integer r0 = (Integer) this.e.invoke();
        if (r0 != null) goto L5;
        Integer r1 = this.j;
        if (r1 == null) goto L9;
        int r2 = r1.intValue();
    L11:
        return RangesKt.coerceIn(r2, f(), d());
    L9:
        r2 = f();
        goto L11
    L5:
        return RangesKt.coerceIn(r0.intValue(), 0, d());
    }

    public final void b(int r3) {
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        if (r0.height == r3) goto L6;
        r0.height = r3;
        this.a.setLayoutParams(r0);
        return;
    }

    public final void g(boolean r8) {
        if (this.p == false) goto L5;
        return;
    L5:
        if (this.k == true) goto L33;
        int r2 = h();
        ValueAnimator r0 = this.n;
        boolean r1 = false;
        if (r0 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L20;
        Integer r4 = this.o;
        if (r4 == null) goto L20;
        if (r4.intValue() != r2) goto L20;
        return;
    L20:
        c();
        this.q.setTranslationY(0.0f);
        if (r8 == true) goto L23;
    L29:
        b(r2);
        return;
    L23:
        if (this.a.getVisibility() != 0) goto L25;
        r1 = true;
    L25:
        if (r1 == false) goto L29;
        if (r2 >= e()) goto L29;
        a(r2, false, 250, PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        return;
    L10:
        if (r0.isRunning() != true) goto L12;
        r3 = true;
        goto L13
    }

    public final void i(boolean r4) {
        if (r4 == true) goto L4;
    L6:
        int r0 = 0;
        if (r4 == true) goto L12;
        n r1 = this.a;
        if (r1.k == false) goto L11;
        r1.a(true);
    L11:
        r1.b();
        c();
        this.k = false;
        this.j = null;
        this.q.setTranslationY(0.0f);
    L12:
        n r2 = this.a;
        if (r4 == true) goto L16;
        r0 = 8;
    L16:
        r2.setVisibility(r0);
        return;
    L4:
        if (this.p == false) goto L6;
    }

    public final void j(int r5, int r6, boolean r7) {
        if (this.p == false) goto L5;
        return;
    L5:
        Integer r8 = Integer.valueOf(r5);
        boolean r1 = false;
        if (r8.intValue() <= 0) goto L8;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        r8 = null;
    L13:
        if (r8 == null) goto L38;
        int r9 = r8.intValue();
        Integer r10 = Integer.valueOf(r6);
        if (r10.intValue() <= 0) goto L17;
        r1 = true;
    L17:
        if (r1 == true) goto L20;
        r10 = null;
    L20:
        if (r10 == null) goto L22;
        int r11 = RangesKt.coerceAtMost(r10.intValue(), r9);
    L24:
        if (this.g == r9) goto L26;
    L30:
        n r2 = this.a;
        if (r2.k == false) goto L33;
        r2.a(true);
    L33:
        r2.b();
        c();
        this.g = r9;
        this.h = r11;
        if (this.i == r7) goto L36;
        this.j = null;
    L36:
        this.i = r7;
        this.q.setTranslationY(0.0f);
        b(h());
        return;
    L26:
        if (this.h != r11) goto L30;
        if (this.i != r7) goto L30;
        return;
    L22:
        r11 = r9;
        goto L24
    L38:
        return;
    L8:
        r0 = false;
        goto L10
    }

    public final void a(final int r4, boolean r5, long r6, Interpolator r8) {
        c();
        this.p = r5;
        this.o = Integer.valueOf(r4);
        final float r0 = this.q.getTranslationY();
        final int r1 = e();
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r2.setDuration(r6);
        r2.setInterpolator(r8);
        r2.addUpdateListener(new b(this, r1, r4, r0));
        r2.addListener(new a(this, r5));
        r2.start();
        this.n = r2;
    }

    public InputPanelDragController(n r2, RecyclerView r3, Function0<Integer> r4, Function0<Unit> r5, Function0<Integer> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "list");
        Intrinsics.checkNotNullParameter(r4, "contentHeightPx");
        Intrinsics.checkNotNullParameter(r5, "onClose");
        Intrinsics.checkNotNullParameter(r6, "lockedHeightPx");
        Intrinsics.checkNotNullParameter(r7, "onDragStart");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        Context r8 = r2.getContext();
        int r9 = c7.b(360);
        this.g = r9;
        this.h = r9;
        View r10 = new View(r8);
        r10.setImportantForAccessibility(2);
        GradientDrawable r11 = new GradientDrawable();
        r11.setCornerRadius(c7.b(2));
        r11.setColor(ContextCompat.getColor(r10.getContext(), v19.c.b(2130972087, r10.getContext(), 2131103162)));
        r10.setBackground(r11);
        this.q = r10;
        r2.setClickable(true);
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(c7.b(36), c7.b(4));
        r12.gravity = 49;
        r12.topMargin = c7.b(8);
        Unit r13 = Unit.INSTANCE;
        r2.addView(r10, r12);
        r2.setHandleHit(new d(this));
        r2.setCanDrag(new e(this));
        r2.setOnDragStart(new f(this));
        r2.setOnDragBy(new g(this));
        r2.setOnDragEnd(new AnonymousClass8(this));
    }
}
