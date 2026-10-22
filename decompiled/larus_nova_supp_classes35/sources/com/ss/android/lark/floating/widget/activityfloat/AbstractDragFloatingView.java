package com.ss.android.lark.floating.widget.activityfloat;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ss.android.lark.floating.enums.SidePattern;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wfb.d;
import wfb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010'\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0004J0\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0015J\b\u0010.\u001a\u00020\rH\u0002J\u0012\u0010/\u001a\u00020&2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020&2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00103\u001a\u00020\r2\u0006\u00100\u001a\u000201H\u0002J\b\u00104\u001a\u00020\rH\u0002J\b\u00105\u001a\u00020\rH\u0002J$\u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u000208H\u0002J\b\u0010;\u001a\u00020\rH\u0002J\b\u0010<\u001a\u00020\rH\u0002J\r\u0010=\u001a\u00020\rH\u0000¢\u0006\u0002\b>J\b\u0010?\u001a\u00020\rH\u0014R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/ss/android/lark/floating/widget/activityfloat/AbstractDragFloatingView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getLayoutId", "()Ljava/lang/Integer;", "renderView", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "config", "Lcom/ss/android/lark/floating/data/FloatConfig;", "getConfig", "()Lcom/ss/android/lark/floating/data/FloatConfig;", "setConfig", "(Lcom/ss/android/lark/floating/data/FloatConfig;)V", "parentHeight", "parentWidth", "lastX", "lastY", "leftDistance", "rightDistance", "topDistance", "bottomDistance", "minX", "minY", "parentRect", "Landroid/graphics/Rect;", "floatRect", "parentView", "Landroid/view/ViewGroup;", "isCreated", BuildConfig.FLAVOR, "initView", "onLayout", "changed", "l", "t", "r", "b", "initParent", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "updateView", "touchOver", "sideAnim", "sideForLatest", "Lkotlin/Pair;", BuildConfig.FLAVOR, "x", "y", "initDistanceValue", "enterAnim", "exitAnim", "exitAnim$float_release", "onDetachedFromWindow", "float_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractDragFloatingView extends FrameLayout {
    public static final /* synthetic */ int p = 0;
    public vfb.a a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public final Rect l;
    public final Rect m;
    public ViewGroup n;
    public boolean o;

    public static final class a implements View.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SidePattern.values().length];
            r0[SidePattern.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L49:
            r0[SidePattern.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L59:
            r0[SidePattern.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L37:
            r0[SidePattern.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L39:
            r0[SidePattern.AUTO_HORIZONTAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L45:
            r0[SidePattern.AUTO_VERTICAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L55:
            r0[SidePattern.AUTO_SIDE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
        L41:
            r0[SidePattern.RESULT_LEFT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L51:
            r0[SidePattern.RESULT_RIGHT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L27
        L53:
            r0[SidePattern.RESULT_TOP.ordinal()] = 10;     // Catch: NoSuchFieldError -> L28
        L35:
            r0[SidePattern.RESULT_BOTTOM.ordinal()] = 11;     // Catch: NoSuchFieldError -> L29
        L47:
            r0[SidePattern.RESULT_HORIZONTAL.ordinal()] = 12;     // Catch: NoSuchFieldError -> L30
        L57:
            r0[SidePattern.RESULT_VERTICAL.ordinal()] = 13;     // Catch: NoSuchFieldError -> L31
        L33:
            r0[SidePattern.RESULT_SIDE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L32
        L17:
            a = r0;
        }
    }

    public abstract void d(View r1);

    public abstract Integer getLayoutId();

    public final void a() {
        getGlobalVisibleRect(this.m);
        Rect r0 = this.m;
        int r1 = r0.left;
        Rect r2 = this.l;
        int r3 = r1 - r2.left;
        this.f = r3;
        int r4 = r2.right - r0.right;
        this.g = r4;
        this.h = r0.top - r2.top;
        this.i = r2.bottom - r0.bottom;
        this.j = Math.min(r3, r4);
        this.k = Math.min(this.h, this.i);
        Log.i(this.f + "   " + this.g + "   " + this.h + "   " + this.i);
    }

    public final void e() {
        vfb.a r0 = this.a;
        r0.j = false;
        r0.i = false;
        r0.getClass();
        wfb.a r1 = this.a.B;
        if (r1 == null) goto L10;
        wfb.a.C0318a r2 = r1.a();
        if (r2 == null) goto L11;
        Function1<? super View, Unit> r3 = r2.e;
        if (r3 == null) goto L12;
        r3.invoke(this);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void b() {
        ViewParent r0 = getParent();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof ViewGroup) == false) goto L9;
        ViewGroup r1 = (ViewGroup) r0;
        this.n = r1;
        this.b = r1.getHeight();
        this.c = r1.getWidth();
        r1.getGlobalVisibleRect(this.l);
        Log.e("parentRect: " + this.l);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.getClass();
        wfb.a r0 = this.a.B;
        if (r0 == null) goto L10;
        wfb.a.C0318a r1 = r0.a();
        if (r1 == null) goto L11;
        Function0<Unit> r2 = r1.b;
        if (r2 == null) goto L12;
        r2.invoke();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final vfb.a getConfig() {
        return this.a;
    }

    public final void c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Integer r0 = getLayoutId();
        if (r0 == null) goto L8;
        d(LayoutInflater.from(r2).inflate(r0.intValue(), this));
        f r3 = this.a.A;
        if (r3 == null) goto L9;
        r3.a(this);
        return;
    L9:
        return;
    }

    public final void f(MotionEvent r10) {
        this.a.getClass();
        wfb.a r0 = this.a.B;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        vfb.a r1 = this.a;
        if (r1.h == true) goto L8;
    L106:
        r1.i = false;
        setPressed(true);
        return;
    L8:
        if (r1.j == true) goto L106;
        int r2 = (int) r10.getRawX();
        int r3 = (int) r10.getRawY();
        int r11 = r10.getAction() & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        if (r11 == 0) goto L104;
        float r5 = 0.0f;
        if (r11 == 1) goto L67;
        if (r11 == 2) goto L17;
        return;
    L17:
        if (this.b > 0) goto L19;
        return;
    L19:
        if (this.c <= 0) goto L108;
        int r12 = r2 - this.d;
        int r4 = r3 - this.e;
        vfb.a r6 = this.a;
        if (r6.i == false) goto L24;
    L26:
        r6.i = true;
        float r7 = getX() + r12;
        float r13 = getY() + r4;
        if (r7 >= 0.0f) goto L30;
        r7 = 0.0f;
    L33:
        if (r13 >= 0.0f) goto L36;
        r13 = 0.0f;
    L39:
        switch(b.a[this.a.m.ordinal()]) {
            case 1: goto L63;
            case 2: goto L62;
            case 3: goto L61;
            case 4: goto L58;
            case 5: goto L55;
            case 6: goto L52;
            case 7: goto L41;
            default: goto L60;
        };
    L41:
        Rect r8 = this.l;
        int r9 = r2 - r8.left;
        this.f = r9;
        int r14 = r8.right - r2;
        this.g = r14;
        this.h = r3 - r8.top;
        this.i = r8.bottom - r3;
        this.j = Math.min(r9, r14);
        int r15 = Math.min(this.h, this.i);
        this.k = r15;
        int r16 = this.j;
        if (r16 >= r15) goto L48;
        if (this.f == r16) goto L51;
        r5 = this.c - getWidth();
    L51:
        Pair r17 = new Pair(Float.valueOf(r5), Float.valueOf(r13));
        r5 = ((Number) r17.getFirst()).floatValue();
        r13 = ((Number) r17.getSecond()).floatValue();
        goto L63
    L48:
        if (this.h != r15) goto L50;
        r5 = r7;
        r13 = 0.0f;
        goto L51
    L50:
        r13 = this.b - getHeight();
        r5 = r7;
        goto L51
    L52:
        Rect r18 = this.l;
        int r19 = r3 - r18.top;
        int r110 = r18.bottom;
        if (r19 <= (r110 - r3)) goto L59;
        r5 = r110 - getHeight();
    L59:
        r13 = r5;
        goto L60
    L55:
        Rect r20 = this.l;
        int r21 = (r2 * 2) - r20.left;
        int r22 = r20.right;
        if (r21 <= r22) goto L63;
        r5 = r22 - getWidth();
        goto L63
    L58:
        r5 = this.l.bottom - getHeight();
        goto L59
    L61:
        r5 = r7;
        r13 = 0.0f;
        goto L63
    L62:
        r5 = this.l.right - getWidth();
    L63:
        setX(r5);
        setY(r13);
        this.d = r2;
        this.e = r3;
        this.a.getClass();
        wfb.a r111 = this.a.B;
        if (r111 == null) goto L109;
        r111.a();
        return;
    L109:
        return;
    L60:
        r5 = r7;
        goto L63
    L36:
        if (r13 <= (this.b - getHeight())) goto L39;
        r13 = this.b - getHeight();
        goto L39
    L30:
        if (r7 <= (this.c - getWidth())) goto L33;
        r7 = this.c - getWidth();
        goto L33
    L24:
        if (((r12 * r12) + (r4 * r4)) >= 81) goto L26;
        return;
    L108:
        return;
    L67:
        setPressed(!this.a.i);
        vfb.a r112 = this.a;
        if (r112.i == false) goto L111;
        SidePattern r113 = r112.m;
        int[] r23 = b.a;
        switch(r23[r113.ordinal()]) {
            case 8: goto L72;
            case 9: goto L72;
            case 10: goto L72;
            case 11: goto L72;
            case 12: goto L72;
            case 13: goto L72;
            case 14: goto L72;
            default: goto L71;
        };
    L71:
        e();
        return;
    L72:
        a();
        int r114 = r23[this.a.m.ordinal()];
        String r24 = "translationX";
        switch(r114) {
            case 8: goto L101;
            case 9: goto L100;
            case 10: goto L98;
            case 11: goto L97;
            case 12: goto L92;
            case 13: goto L87;
            case 14: goto L76;
            default: goto L74;
        };
    L74:
        float r115 = 0.0f;
    L103:
        ObjectAnimator r116 = ObjectAnimator.ofFloat(this, r24, new float[]{r5, r115});
        r116.addListener(new yfb.b(this));
        r116.start();
        return;
    L87:
        float r117 = getTranslationY();
        int r25 = this.h;
        int r26 = this.i;
        if (r25 >= r26) goto L90;
        float r27 = -r25;
    L91:
        float r28 = getTranslationY();
    L99:
        r5 = r117;
        r115 = r27 + r28;
        r24 = "translationY";
        goto L103
    L90:
        r27 = r26;
        goto L91
    L92:
        float r118 = getTranslationX();
        int r29 = this.f;
        int r30 = this.g;
        if (r29 >= r30) goto L95;
        float r31 = -r29;
    L96:
        float r32 = getTranslationX();
    L102:
        float r33 = r32 + r31;
        r5 = r118;
        r115 = r33;
        goto L103
    L95:
        r31 = r30;
        goto L96
    L97:
        r117 = getTranslationY();
        r27 = this.i;
        r28 = getTranslationY();
        goto L99
    L98:
        r117 = getTranslationY();
        r27 = -this.h;
        r28 = getTranslationY();
        goto L99
    L100:
        r118 = getTranslationX();
        r31 = this.g;
        r32 = getTranslationX();
        goto L102
    L101:
        r118 = getTranslationX();
        r31 = -this.f;
        r32 = getTranslationX();
        goto L102
    L76:
        if (this.j >= this.k) goto L82;
        r118 = getTranslationX();
        int r34 = this.f;
        int r35 = this.g;
        if (r34 >= r35) goto L80;
        r31 = -r34;
    L81:
        r32 = getTranslationX();
        goto L102
    L80:
        r31 = r35;
        goto L81
    L82:
        r117 = getTranslationY();
        int r36 = this.h;
        int r37 = this.i;
        if (r36 >= r37) goto L85;
        r27 = -r36;
    L86:
        r28 = getTranslationY();
        goto L99
    L85:
        r27 = r37;
        goto L86
    L111:
        return;
    L104:
        this.a.i = false;
        setPressed(true);
        this.d = r2;
        this.e = r3;
        getParent().requestDisallowInterceptTouchEvent(true);
        b();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (r2 == null) goto L5;
        f(r2);
    L5:
        if (this.a.i == false) goto L7;
    L10:
        return true;
    L7:
        if (super.onInterceptTouchEvent(r2) == true) goto L10;
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        if (r2 == null) goto L5;
        f(r2);
    L5:
        if (this.a.i == false) goto L7;
    L10:
        return true;
    L7:
        if (super.onTouchEvent(r2) == true) goto L10;
        return false;
    }

    public final void setConfig(vfb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public AbstractDragFloatingView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.l = new Rect();
        this.m = new Rect();
        new FrameLayout(r2, r3, r4);
        this.a = new vfb.a(null);
        c(r2);
        setOnClickListener(a.a);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.o == true) goto L20;
        this.o = true;
        if (Intrinsics.areEqual(this.a.y, new Pair(0, 0)) == true) goto L7;
        setX(((Number) this.a.y.getFirst()).intValue());
        setY(((Number) this.a.y.getSecond()).intValue());
    L8:
        b();
        a();
        ViewGroup r6 = this.n;
        if (r6 == null) goto L22;
        vfb.a r7 = this.a;
        d r8 = r7.C;
        SidePattern r9 = r7.m;
        Intrinsics.checkNotNullParameter(this, "view");
        Intrinsics.checkNotNullParameter(r6, "parentView");
        Intrinsics.checkNotNullParameter(r9, "sidePattern");
        if (r8 == null) goto L14;
        Animator r10 = r8.a(this, r6, r9);
    L15:
        if (r10 == null) goto L17;
        r10.addListener(new yfb.a(this));
    L17:
        if (r10 == null) goto L21;
        r10.start();
        return;
    L21:
        return;
    L14:
        r10 = null;
        goto L15
    L22:
        return;
    L7:
        setX(getX() + ((Number) this.a.v.getFirst()).floatValue());
        setY(getY() + ((Number) this.a.v.getSecond()).floatValue());
        goto L8
    }
}
