package iwb;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a extends FrameLayout {
    public final FrameLayout a;
    public final View b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final int g;
    public final int h;
    public final d i;
    public final f j;
    public View k;
    public boolean l;
    public iwb.b m;
    public Function0<Unit> n;
    public Function1<? super hwb.d, Unit> o;
    public final b p;

    /* JADX INFO: renamed from: iwb.a$a, reason: collision with other inner class name */
    public static final class C0147a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r0 = this.a.i;     // Catch: Throwable -> L11
            if (r0.a.isLaidOut() == true) goto L5;
            return;
        L5:
            if (r0.c == false) goto L8;
            return;
        L8:
            if (r0.d == true) goto L19;
            r0.e(true);     // Catch: Throwable -> L11
            return;
        L19:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r0 = this.a.i;     // Catch: Throwable -> L14
            FrameLayout r1 = r0.a.getFloatView$officesdk_minutes_base_ui_release();     // Catch: Throwable -> L14
            if (r1.getWidth() > 0) goto L5;
        L19:
            return;
        L5:
            if (r1.getHeight() <= 0) goto L19;
            if (r0.c == true) goto L19;
            if (r0.d == false) goto L12;
            r0.e(false);     // Catch: Throwable -> L14
            goto L19
        L12:
            r0.d(false);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        iwb.b r0 = this.m;
        if (r0 != null) goto L6;
    L9:
        removeCallbacks(this.p);
        this.i.b();
        super.onDetachedFromWindow();
        return;
    L6:
        if (getViewTreeObserver().isAlive() == false) goto L8;
        getViewTreeObserver().removeOnPreDrawListener(r0);
    L8:
        this.m = null;
        goto L9
    }

    public final void a() {
        long r2 = SystemClock.uptimeMillis();
        MotionEvent r0 = MotionEvent.obtain(r2, r2, 3, 0.0f, 0.0f, 0);
        super.dispatchTouchEvent(r0);
        r0.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.m != null) goto L7;
        this.m = new iwb.b(this);
        getViewTreeObserver().addOnPreDrawListener(this.m);
        return;
    }

    public final View getContentView$officesdk_minutes_base_ui_release() {
        return this.k;
    }

    public final FrameLayout getFloatView$officesdk_minutes_base_ui_release() {
        return this.a;
    }

    public final Function0<Unit> getOnFirstPositioned$officesdk_minutes_base_ui_release() {
        return this.n;
    }

    public final Function1<hwb.d, Unit> getOnLayoutStateChanged$officesdk_minutes_base_ui_release() {
        return this.o;
    }

    public final void b(hwb.d r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Function1<? super hwb.d, Unit> r0 = this.o;
        if (r0 == null) goto L6;
        r0.invoke(r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r14) {
        Intrinsics.checkNotNullParameter(r14, "ev");
        f r1 = this.j;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r14, "ev");
        int r0 = r14.getActionMasked();
        boolean r2 = false;
        if (r0 == 0) goto L76;
        if (r0 == 1) goto L62;
        if (r0 == 2) goto L10;
        if (r0 == 3) goto L62;
    L95:
        if (r2 == false) goto L98;
        return true;
    L98:
        return super.dispatchTouchEvent(r14);
    L10:
        if (r1.g == false) goto L95;
        if (r1.b.c == true) goto L95;
        int r3 = (int) r14.getRawX();
        int r5 = (int) r14.getRawY();
        if (r1.h == true) goto L20;
        if ((Math.abs(r3 - r1.c) + Math.abs(r5 - r1.d)) < 5) goto L95;
    L20:
        if (r1.h == true) goto L31;
        r1.h = true;
        a r6 = r1.a;
        r6.removeCallbacks(r6.p);
        d r7 = r1.b;
        r7.b();
        ViewGroup.LayoutParams r8 = r7.a.getFloatView$officesdk_minutes_base_ui_release().getLayoutParams();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) r8;
        if (r9.gravity == 0) goto L30;
        r9.gravity = 0;
        e r10 = r7.b;
        if (r10.a.getWidth() > 0) goto L26;
    L28:
        int r11 = 0;
    L29:
        r9.leftMargin = r11;
        r9.topMargin = r7.b.b();
        r9.rightMargin = 0;
        r9.bottomMargin = 0;
        r7.a.getFloatView$officesdk_minutes_base_ui_release().setLayoutParams(r9);
        goto L30
    L26:
        if (r10.a.getFloatView$officesdk_minutes_base_ui_release().getWidth() <= 0) goto L28;
        r11 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r10.a.getWidth() - r10.a.getFloatView$officesdk_minutes_base_ui_release().getWidth(), 0), r10.e());
    L30:
        r1.a.a();
    L31:
        d r12 = r1.b;
        int r13 = r3 - r1.e;
        int r15 = r5 - r1.f;
        if (r12.c == true) goto L61;
        ViewGroup.LayoutParams r16 = r12.a.getFloatView$officesdk_minutes_base_ui_release().getLayoutParams();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r17 = (FrameLayout.LayoutParams) r16;
        e r18 = r12.b;
        int r19 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r17.leftMargin + r13, r18.d()), r18.e());
        int r20 = r12.b.c(r17.topMargin + r15);
        r17.gravity = 0;
        r17.leftMargin = r19;
        r17.topMargin = r20;
        r12.a.getFloatView$officesdk_minutes_base_ui_release().setLayoutParams(r17);
        boolean r21 = r12.d;
        if (r19 > (-r12.b.a.g)) goto L37;
    L40:
        boolean r22 = true;
    L41:
        r12.d = r22;
        if (r21 != r22) goto L44;
    L48:
        boolean r23 = r12.e;
        if (r19 > r12.b.d()) goto L51;
    L54:
        boolean r24 = true;
    L55:
        r12.e = r24;
        if (r23 == r24) goto L61;
        if (r19 < (r12.a.getWidth() / 2)) goto L60;
        r2 = true;
    L60:
        r12.f = r2;
        r12.a.c(r12.e, r2);
        goto L61
    L51:
        if (r19 >= r12.b.e()) goto L54;
        r24 = false;
        goto L55
    L44:
        if (r19 < (r12.a.getWidth() / 2)) goto L46;
        boolean r25 = true;
    L47:
        r12.f = r25;
        int r26 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "updateSideHideStatus", "hidden=" + r12.d + ", right=" + r12.f, null, 8);
        goto L48
    L46:
        r25 = false;
        goto L47
    L37:
        if (r19 >= ((r12.a.getWidth() - r12.a.getFloatView$officesdk_minutes_base_ui_release().getWidth()) + r12.b.a.g)) goto L40;
        r22 = false;
    L61:
        r1.e = r3;
        r1.f = r5;
        r2 = true;
    L62:
        ViewParent r4 = r1.a.getParent();
        if (r4 == null) goto L65;
        r4.requestDisallowInterceptTouchEvent(false);
    L65:
        boolean r27 = r1.h;
        r1.g = false;
        r1.h = false;
        if (r27 == false) goto L75;
        d r28 = r1.b;
        if (r28.d == false) goto L70;
        r28.e(true);
    L71:
        a r29 = r1.a;
        if (r29.l == false) goto L75;
        r29.removeCallbacks(r29.p);
        r29.postDelayed(r29.p, 3000);
        goto L75
    L70:
        r28.d(true);
    L75:
        r2 = r27;
        goto L95
    L76:
        int r30 = (int) r14.getRawX();
        int r31 = (int) r14.getRawY();
        FrameLayout r32 = r1.a.getFloatView$officesdk_minutes_base_ui_release();
        int[] r33 = new int[2];
        r32.getLocationOnScreen(r33);
        int r34 = r33[0];
        int r35 = r33[1];
        int r36 = r32.getWidth() + r34;
        int r37 = r32.getHeight() + r35;
        if (r34 > r30) goto L80;
        if (r30 > r36) goto L80;
        boolean r38 = true;
    L81:
        if (r38 == false) goto L88;
        if (r35 > r31) goto L85;
        if (r31 > r37) goto L85;
        boolean r39 = true;
    L86:
        if (r39 == false) goto L88;
        boolean r40 = true;
    L89:
        r1.g = false;
        r1.h = false;
        if (r40 == false) goto L95;
        r1.g = true;
        r1.c = r30;
        r1.d = r31;
        r1.e = r30;
        r1.f = r31;
        ViewParent r41 = r1.a.getParent();
        if (r41 == null) goto L95;
        r41.requestDisallowInterceptTouchEvent(true);
    L85:
        r39 = false;
    L88:
        r40 = false;
    L80:
        r38 = false;
        goto L81
    }

    public final void setContent(View r4) {
        Intrinsics.checkNotNullParameter(r4, "content");
        this.k = r4;
        this.c.removeAllViews();
        this.c.addView(r4, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void setOnFirstPositioned$officesdk_minutes_base_ui_release(Function0<Unit> r1) {
        this.n = r1;
    }

    public final void setOnLayoutStateChanged$officesdk_minutes_base_ui_release(Function1<? super hwb.d, Unit> r1) {
        this.o = r1;
    }

    public a(Context r18, hwb.a r19) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "spec");
        super(r18);
        FrameLayout r3 = new FrameLayout(r18);
        this.a = r3;
        View r1 = LayoutInflater.from(r18).inflate(r19.a, r3, false);
        this.b = r1;
        FrameLayout r4 = (FrameLayout) r1.findViewById(r19.b);
        this.c = r4;
        FrameLayout r6 = (FrameLayout) r1.findViewById(r19.c);
        this.d = r6;
        FrameLayout r7 = (FrameLayout) r1.findViewById(r19.d);
        this.e = r7;
        FrameLayout r8 = (FrameLayout) r1.findViewById(r19.e);
        this.f = r8;
        int r9 = UIHelper.dp2px(r19.f);
        int r10 = UIHelper.dp2px(r19.g);
        int r11 = UIHelper.dp2px(r19.h);
        this.g = r11;
        this.h = UIHelper.dp2px(r19.i);
        int r2 = r11 * 2;
        int r12 = r2 + r9;
        int r5 = r2 + r10;
        d r14 = new d(this, new e(this));
        this.i = r14;
        this.j = new f(this, r14);
        this.l = true;
        this.p = new b(this);
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(false);
        r3.setVisibility(4);
        r3.setClipChildren(false);
        r3.setClipToPadding(false);
        r1.setLayoutParams(new FrameLayout.LayoutParams(r12, r5));
        Object r13 = r4.getParent();
        UDShadowLayout.LayoutParams r16 = null;
        if ((r13 instanceof View) == false) goto L5;
        View r15 = (View) r13;
    L6:
        if (r15 == null) goto L14;
        UDShadowLayout.LayoutParams r17 = r15.getLayoutParams();
        if ((r17 instanceof UDShadowLayout.LayoutParams) == false) goto L10;
        r16 = r17;
    L10:
        if (r16 != null) goto L12;
        UDShadowLayout.LayoutParams r110 = new UDShadowLayout.LayoutParams(r9, r10);
    L13:
        ((ViewGroup.MarginLayoutParams) r110).width = r9;
        ((ViewGroup.MarginLayoutParams) r110).height = r10;
        r110.setMargins(r11, r11, r11, r11);
        r15.setLayoutParams(r110);
        goto L14
    L12:
        r110 = r16;
    L14:
        FrameLayout.LayoutParams r20 = new FrameLayout.LayoutParams(r12, r5);
        r20.gravity = 17;
        Unit r21 = Unit.INSTANCE;
        r3.addView(r1, r20);
        FrameLayout.LayoutParams r22 = new FrameLayout.LayoutParams(r12, r5);
        r22.gravity = 53;
        addView(r3, r22);
        r6.setVisibility(4);
        r7.setVisibility(4);
        r8.setVisibility(4);
        Iterator r23 = CollectionsKt.listOf(new FrameLayout[]{r7, r8}).iterator();
    L16:
        if (r23.hasNext() == false) goto L18;
        ((FrameLayout) r23.next()).setOnClickListener(new iwb.c(this));
        goto L16
    L18:
        return;
    L5:
        r15 = null;
        goto L6
    }

    public final void c(boolean r5, boolean r6) {
        int r0 = 0;
        setVisibility(0);
        setAlpha(1.0f);
        this.a.setVisibility(0);
        this.a.setAlpha(1.0f);
        this.b.setVisibility(0);
        this.b.setAlpha(1.0f);
        this.c.setAlpha(1.0f);
        this.d.setAlpha(1.0f);
        this.e.setAlpha(1.0f);
        this.f.setAlpha(1.0f);
        FrameLayout r1 = this.c;
        if (r5 == false) goto L5;
        int r3 = 4;
    L6:
        r1.setVisibility(r3);
        View r2 = this.k;
        if (r2 == null) goto L12;
        if (r5 == false) goto L10;
        int r4 = 4;
    L11:
        r2.setVisibility(r4);
        goto L12
    L10:
        r4 = 0;
    L12:
        FrameLayout r7 = this.d;
        if (r5 == false) goto L15;
        int r8 = 0;
    L16:
        r7.setVisibility(r8);
        FrameLayout r9 = this.e;
        if (r5 == false) goto L20;
        if (r6 == false) goto L20;
        int r10 = 0;
    L21:
        r9.setVisibility(r10);
        FrameLayout r11 = this.f;
        if (r5 == false) goto L25;
        if (r6 == true) goto L25;
    L26:
        r11.setVisibility(r0);
        return;
    L25:
        r0 = 4;
    L20:
        r10 = 4;
        goto L21
    L15:
        r8 = 4;
        goto L16
    L5:
        r3 = 0;
        goto L6
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 <= 0) goto L7;
        if (r2 <= 0) goto L8;
        post(new c(this));
        return;
    L8:
        return;
    }
}
