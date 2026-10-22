package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/bouncelayout/OHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "getCurrentFlingVelocity", "()F", "getBounceTranslation", "Lcom/obric/oui/bouncelayout/f;", "listener", "", "setOnBounceTranslationListener", "(Lcom/obric/oui/bouncelayout/f;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OHorizontalScrollView extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Field f12042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Field f12043c;
    public final b d;
    public final b e;
    public final EdgeEffect f;
    public final EdgeEffect g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f12044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Field f12045i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12046j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f12047k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f12048l;

    @JvmOverloads
    public OHorizontalScrollView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static boolean c(b r5) {
        if (r5 != null) goto L4;
    L10:
        return false;
    L4:
        if (r5.getDistance() == 0.0f) goto L6;
    L9:
        return true;
    L6:
        if (r5.f != 0.0f) goto L9;
        if (r5.isFinished() == true) goto L10;
        goto L9
    }

    public static Field f(String r5) {
        Field r10 = HorizontalScrollView.class.getDeclaredField(r5);     // Catch: Throwable -> L5
        r10.setAccessible(true);     // Catch: Throwable -> L5
        return r10;
    L5:
        return null;
    }

    private final float getCurrentFlingVelocity() {
        Field r5 = this.f12045i;     // Catch: Throwable -> L10
        OverScroller r10 = null;
        if (r5 != null) goto L6;
        Object r11 = null;
    L8:
        if ((r11 instanceof OverScroller) == false) goto L12;
        r10 = (OverScroller) r11;     // Catch: Throwable -> L10
    L12:
        if (r10 != null) goto L14;
        return 1000.0f;
    L14:
        return r10.getCurrVelocity();
    L6:
        r11 = r5.get(this);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Log.w("OHorizontalScrollView", "Failed to get scroller velocity", th);
        return 1000.0f;
    }

    public final void b() {
        Field r5 = this.f12045i;     // Catch: Throwable -> L13
        OverScroller r10 = null;
        if (r5 != null) goto L5;
        Object r11 = null;
    L7:
        if ((r11 instanceof OverScroller) == false) goto L9;
        r10 = (OverScroller) r11;     // Catch: Throwable -> L13
    L9:
        if (r10 == null) goto L16;
        r10.abortAnimation();     // Catch: Throwable -> L13
        return;
    L16:
        return;
    L5:
        r11 = r5.get(this);     // Catch: Throwable -> L13
    }

    public final void d() {
        Field r5 = this.f12042b;     // Catch: Throwable -> L11
        if (r5 == null) goto L6;
        r5.set(this, this.f);     // Catch: Throwable -> L11
    L6:
        Field r10 = this.f12043c;     // Catch: Throwable -> L11
        if (r10 == null) goto L16;
        r10.set(this, this.g);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L11:
        th = move-exception;
        Log.w("OHorizontalScrollView", "Failed to restore original edge effects", th);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r5) {
        if (r5 != null) goto L4;
    L19:
        super.dispatchDraw(r5);
        return;
    L4:
        if (this.f12044h == false) goto L19;
        b r10 = this.d;
        if (r10 != null) goto L9;
        float r11 = 0.0f;
    L10:
        b r12 = this.e;
        if (r12 != null) goto L13;
        float r13 = 0.0f;
    L14:
        float r14 = r11 + r13;
        if (r14 != 0.0f) goto L17;
        super.dispatchDraw(r5);
        return;
    L17:
        int r15 = r5.save();
        r5.translate(r14, 0.0f);
        super.dispatchDraw(r5);
        r5.restoreToCount(r15);
        return;
    L13:
        r13 = r12.f;
        goto L14
    L9:
        r11 = r10.f;
        goto L10
    }

    public final boolean e() {
        if (this.f12044h == true) goto L5;
        return false;
    L5:
        b r5 = this.d;
        if (r5 != null) goto L8;
        float r10 = 0.0f;
    L10:
        if (r10 != 0.0f) goto L18;
        b r11 = this.e;
        if (r11 != null) goto L14;
        float r12 = 0.0f;
    L16:
        if (r12 != 0.0f) goto L18;
        boolean r13 = false;
    L19:
        if (r5 != null) goto L22;
    L24:
        b r14 = this.e;
        if (r14 != null) goto L28;
    L30:
        boolean r15 = false;
    L31:
        if (r13 == true) goto L35;
        if (r15 == true) goto L35;
        return false;
    L35:
        Field r16 = this.f12045i;
        OverScroller r17 = null;
        if (r16 != null) goto L38;
        Object r18 = null;
    L40:
        if ((r18 instanceof OverScroller) == false) goto L42;
        r17 = (OverScroller) r18;
    L42:
        if (r17 == null) goto L45;
        r17.abortAnimation();
    L45:
        b r19 = this.d;
        if (r19 == null) goto L49;
        r19.n();
    L49:
        b r20 = this.e;
        if (r20 == null) goto L53;
        r20.n();
    L53:
        invalidate();
        return true;
    L38:
        r18 = r16.get(this);
        goto L40
    L28:
        if (r14.isFinished() == true) goto L30;
    L29:
        r15 = true;
        goto L31
    L22:
        if (r5.isFinished() == true) goto L24;
    L14:
        r12 = r11.f;
    L18:
        r13 = true;
        goto L19
    L8:
        r10 = r5.f;
        goto L10
    }

    public float getBounceTranslation() {
        b r5 = this.d;
        float r10 = 0.0f;
        if (r5 != null) goto L5;
        float r11 = 0.0f;
    L6:
        b r12 = this.e;
        if (r12 == null) goto L11;
        r10 = r12.f;
    L11:
        return r11 + r10;
    L5:
        r11 = r5.f;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b r5 = this.d;
        if (r5 == null) goto L6;
        r5.finish();
    L6:
        b r10 = this.e;
        if (r10 == null) goto L10;
        r10.finish();
    L10:
        d();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        if (r5.getActionMasked() != 0) goto L6;
        this.f12046j = e();
    L6:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        this.f12047k.b();
        b r13 = this.d;
        if (r13 == null) goto L6;
        r13.setSize(r5, r10);
    L6:
        b r14 = this.e;
        if (r14 == null) goto L11;
        r14.setSize(r5, r10);
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        int r5 = r10.getActionMasked();
        boolean r11 = false;
        if (r5 == 0) goto L54;
        if (r5 == 1) goto L8;
        if (r5 == 3) goto L8;
    L60:
        return super.onTouchEvent(r10);
    L8:
        b r12 = this.d;
        if (r12 == null) goto L12;
        r12.f12102j = 0.0f;
    L12:
        b r13 = this.e;
        if (r13 == null) goto L17;
        r13.f12102j = 0.0f;
    L17:
        if (this.f12046j == false) goto L60;
        boolean r14 = c(r12);
        boolean r15 = c(this.e);
        if (r14 == false) goto L23;
        if (r15 == true) goto L23;
    L22:
        byte r16 = 2;
    L41:
        if (r16 == 2) goto L48;
        if (r16 != 3) goto L52;
        b r17 = this.e;
        if (r17 == null) goto L52;
        r17.onRelease();
    L52:
        this.f12046j = false;
        invalidate();
        goto L60
    L48:
        b r18 = this.d;
        if (r18 == null) goto L52;
        r18.onRelease();
    L23:
        if (r15 == false) goto L26;
        if (r14 == true) goto L26;
    L25:
        r16 = 3;
    L26:
        b r19 = this.d;
        if (r19 != null) goto L29;
        float r20 = 0.0f;
    L31:
        if (r20 > 0.0f) goto L22;
        b r21 = this.e;
        if (r21 != null) goto L36;
        float r22 = 0.0f;
    L38:
        if (r22 < 0.0f) goto L25;
        r16 = -1;
        goto L41
    L36:
        r22 = r21.f;
        goto L38
    L29:
        r20 = r19.f;
        goto L31
    L54:
        if (e() == false) goto L56;
    L57:
        r11 = true;
    L58:
        this.f12046j = r11;
        goto L60
    L56:
        if (this.f12046j == false) goto L58;
        goto L57
    }

    @Override // android.view.View
    public final boolean overScrollBy(int r5, int r10, int r11, int r12, int r13, int r14, int r15, int r16, boolean r17) {
        if (r17 == true) goto L4;
    L13:
        boolean r18 = super.overScrollBy(r5, r10, r11, r12, r13, r14, r15, r16, r17);
        if (r17 == false) goto L16;
    L51:
        return r18;
    L16:
        if (this.f12044h == false) goto L51;
        if (r13 <= 0) goto L51;
        int r19 = r11 + r5;
        if (r19 > 0) goto L35;
        if (r5 >= 0) goto L35;
        b r20 = this.d;
        if (r20 == null) goto L35;
        if (r20.isFinished() != true) goto L35;
        float r21 = getCurrentFlingVelocity();
        int r110 = Math.abs(r19);
        b r111 = this.d;
        if (r111 == null) goto L30;
        r111.onPull(r110 / getWidth(), 0.5f);
    L30:
        b r112 = this.d;
        if (r112 == null) goto L34;
        r112.onAbsorb((int) r21);
    L34:
        b();
    L35:
        if (r19 < r13) goto L51;
        if (r5 <= 0) goto L51;
        b r22 = this.e;
        if (r22 == null) goto L51;
        if (r22.isFinished() != true) goto L51;
        float r23 = getCurrentFlingVelocity();
        int r24 = r19 - r13;
        b r25 = this.e;
        if (r25 == null) goto L46;
        r25.onPull(r24 / getWidth(), 0.5f);
    L46:
        b r26 = this.e;
        if (r26 == null) goto L50;
        r26.onAbsorb(-((int) r23));
    L50:
        b();
        goto L51
    L4:
        if (this.f12044h == false) goto L13;
        float r27 = r5;
        b r28 = this.d;
        if (r28 == null) goto L9;
        r28.f12102j = r27;
    L9:
        b r29 = this.e;
        if (r29 == null) goto L13;
        r29.f12102j = r27;
        goto L13
    }

    public void setOnBounceTranslationListener(f r5) {
        this.f12048l.a();
    }

    @JvmOverloads
    public OHorizontalScrollView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OHorizontalScrollView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OHorizontalScrollView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f12047k = new c(new OHorizontalScrollView$overscrollDelegate$1(this), new OHorizontalScrollView$overscrollDelegate$2(this));
        this.f12048l = new d(new OHorizontalScrollView$translationDelegate$1(this), new OHorizontalScrollView$translationDelegate$2(this));
        setOverScrollMode(0);
        WeakHashMap r13 = b.s;
        ym.a.f("Landroid/widget/HorizontalScrollView;");
        if (this.f12041a == true) goto L22;
        this.f12041a = true;
        Field r14 = f("mEdgeGlowLeft");     // Catch: Throwable -> L11
        if (r14 != null) goto L13;
        r14 = f("mLeftGlow");     // Catch: Throwable -> L11
        if (r14 != null) goto L13;
        r14 = f("mEdgeEffectLeft");     // Catch: Throwable -> L11
    L13:
        this.f12042b = r14;     // Catch: Throwable -> L11
        Field r15 = f("mEdgeGlowRight");     // Catch: Throwable -> L11
        if (r15 != null) goto L18;
        r15 = f("mRightGlow");     // Catch: Throwable -> L11
        if (r15 != null) goto L18;
        r15 = f("mEdgeEffectRight");     // Catch: Throwable -> L11
    L18:
        this.f12043c = r15;     // Catch: Throwable -> L11
        this.f12045i = f("mScroller");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Log.w("OHorizontalScrollView", "Failed to reflect fields", th);
        this.f12042b = null;
        this.f12043c = null;
        this.f12045i = null;
    L22:
        if (this.d == null) goto L24;
        return;
    L24:
        if (this.e != null) goto L56;
        c r16 = this.f12047k;
        r16.b();
        Field r5 = this.f12042b;
        if (r5 == null) goto L57;
        Field r17 = this.f12043c;
        if (r17 == null) goto L58;
        Object r18 = r5.get(this);     // Catch: Throwable -> L35
        if ((r18 instanceof EdgeEffect) == false) goto L37;
        EdgeEffect r19 = (EdgeEffect) r18;     // Catch: Throwable -> L35
    L38:
        this.f = r19;     // Catch: Throwable -> L35
        Object r20 = r17.get(this);     // Catch: Throwable -> L35
        if ((r20 instanceof EdgeEffect) == false) goto L41;
        EdgeEffect r21 = (EdgeEffect) r20;     // Catch: Throwable -> L35
    L42:
        this.g = r21;     // Catch: Throwable -> L35
        b r22 = new b(getContext(), this, 2, r16.f12113c);     // Catch: Throwable -> L35
        r22.e = true;     // Catch: Throwable -> L35
        b r23 = new b(getContext(), this, 3, r16.f12113c);     // Catch: Throwable -> L35
        r23.e = true;     // Catch: Throwable -> L35
        if (getWidth() > 0) goto L45;
    L47:
        r5.set(this, r22);     // Catch: Throwable -> L35
        r17.set(this, r23);     // Catch: Throwable -> L35
        this.d = r22;     // Catch: Throwable -> L35
        this.e = r23;     // Catch: Throwable -> L35
        this.f12044h = true;     // Catch: Throwable -> L35
        r16.a();     // Catch: Throwable -> L35
        this.f12048l.a();     // Catch: Throwable -> L35
        return;
    L45:
        if (getHeight() <= 0) goto L47;
        r22.setSize(getWidth(), getHeight());     // Catch: Throwable -> L35
        r23.setSize(getWidth(), getHeight());     // Catch: Throwable -> L35
        goto L47
    L41:
        r21 = null;
        goto L42
    L37:
        r19 = null;
    L35:
        th = move-exception;
        Log.w("OHorizontalScrollView", "Failed to install BounceEdgeEffects, restoring original.", th);
        d();
        this.d = null;
        this.e = null;
        this.f12044h = false;
        return;
    L58:
        return;
    L57:
        return;
    }
}
