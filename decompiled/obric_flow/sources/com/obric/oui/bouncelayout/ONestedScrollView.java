package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.widget.NestedScrollView;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/bouncelayout/ONestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getScrollRangeY", "()I", "", "getBounceTranslation", "()F", "Lcom/obric/oui/bouncelayout/f;", "listener", "", "setOnBounceTranslationListener", "(Lcom/obric/oui/bouncelayout/f;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ONestedScrollView extends NestedScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Field f12068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Field f12069c;
    public final Field d;
    public final b e;
    public final b f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12071i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12072j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final EdgeEffect f12073k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final EdgeEffect f12074l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f12075m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f12076n;

    @JvmOverloads
    public ONestedScrollView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static Field b(String r5) {
        Field r10 = NestedScrollView.class.getDeclaredField(r5);     // Catch: Throwable -> L5
        r10.setAccessible(true);     // Catch: Throwable -> L5
        return r10;
    L5:
        th = move-exception;
        Log.w("ONestedScrollView", "Failed to reflect edge effect fields", th);
        return null;
    }

    private final int getScrollRangeY() {
        View r5 = getChildAt(0);
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r10 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        return Math.max(0, r5.getHeight() - r10);
    }

    public final void a() {
        Field r5 = this.f12068b;     // Catch: Throwable -> L11
        if (r5 == null) goto L6;
        r5.set(this, this.f12073k);     // Catch: Throwable -> L11
    L6:
        Field r10 = this.f12069c;     // Catch: Throwable -> L11
        if (r10 == null) goto L16;
        r10.set(this, this.f12074l);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L11:
        th = move-exception;
        Log.w("ONestedScrollView", "Failed to restore original edge effects", th);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.g == true) goto L5;
        return;
    L5:
        OverScroller r5 = null;
        Field r10 = this.d;     // Catch: Throwable -> L74
        if (r10 != null) goto L9;
        Object r11 = null;
    L11:
        if ((r11 instanceof OverScroller) == false) goto L14;
        r5 = (OverScroller) r11;     // Catch: Throwable -> L74
        goto L14
    L9:
        r11 = r10.get(this);     // Catch: Throwable -> L74
    L14:
        if (r5 != null) goto L16;
        return;
    L16:
        int r12 = getScrollRangeY();
        if (r12 > 0) goto L19;
        return;
    L19:
        int r13 = getScrollY();
        boolean r14 = false;
        if (r5.isFinished() == true) goto L56;
        int r15 = this.f12071i;
        float r16 = r5.getCurrVelocity();
        this.f12070h = r16;
        if (this.f12072j == false) goto L24;
    L52:
        if (r14 == false) goto L54;
        return;
    L54:
        this.f12071i = r13;
        return;
    L24:
        if (r16 <= 0.0f) goto L52;
        if (r13 != 0) goto L39;
        if (r15 <= 0) goto L39;
        b r17 = this.e;
        if (r17 == null) goto L39;
        if (r17.isFinished() != true) goto L39;
        b r18 = this.e;
        if (r18 == null) goto L38;
        r18.onAbsorb((int) r16);
    L38:
        r14 = true;
    L50:
        if (r14 == false) goto L52;
        this.f12072j = true;
        r5.abortAnimation();
        this.f12070h = 0.0f;
        invalidate();
    L39:
        if (r13 != r12) goto L50;
        if (r15 >= r12) goto L50;
        b r19 = this.f;
        if (r19 == null) goto L50;
        if (r19.isFinished() != true) goto L50;
        b r20 = this.f;
        if (r20 == null) goto L38;
        r20.onAbsorb(-((int) r16));
        goto L38
    L56:
        float r21 = this.f12070h;
        if (r21 <= 0.0f) goto L72;
        if (r13 == 0) goto L60;
    L65:
        if (r13 != r12) goto L72;
        if (this.f12071i >= r12) goto L72;
        b r22 = this.f;
        if (r22 == null) goto L72;
        r22.onAbsorb(-((int) r21));
        goto L72
    L60:
        if (this.f12071i <= 0) goto L65;
        b r23 = this.e;
        if (r23 == null) goto L72;
        r23.onAbsorb((int) r21);
    L72:
        this.f12070h = 0.0f;
        this.f12072j = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        if (r5 != null) goto L5;
        super.dispatchDraw(r5);
        return;
    L5:
        b r10 = this.e;
        if (r10 != null) goto L8;
        float r11 = 0.0f;
    L9:
        b r12 = this.f;
        if (r12 != null) goto L12;
        float r13 = 0.0f;
    L13:
        float r14 = r11 + r13;
        if (r14 != 0.0f) goto L16;
        super.dispatchDraw(r5);
        return;
    L16:
        int r15 = r5.save();
        r5.translate(0.0f, r14);
        super.dispatchDraw(r5);
        r5.restoreToCount(r15);
        return;
    L12:
        r13 = r12.f;
        goto L13
    L8:
        r11 = r10.f;
        goto L9
    }

    public float getBounceTranslation() {
        b r5 = this.e;
        float r10 = 0.0f;
        if (r5 != null) goto L5;
        float r11 = 0.0f;
    L6:
        b r12 = this.f;
        if (r12 == null) goto L11;
        r10 = r12.f;
    L11:
        return r11 + r10;
    L5:
        r11 = r5.f;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        b r5 = this.e;
        if (r5 == null) goto L6;
        r5.finish();
    L6:
        b r10 = this.f;
        if (r10 == null) goto L10;
        r10.finish();
    L10:
        a();
        super.onDetachedFromWindow();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        this.f12075m.b();
        b r13 = this.e;
        if (r13 == null) goto L6;
        r13.setSize(r5, r10);
    L6:
        b r14 = this.f;
        if (r14 == null) goto L11;
        r14.setSize(r5, r10);
        return;
    }

    public void setOnBounceTranslationListener(f r5) {
        this.f12076n.a();
    }

    @JvmOverloads
    public ONestedScrollView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ ONestedScrollView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public ONestedScrollView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f12075m = new c(new ONestedScrollView$overscrollDelegate$1(this), new ONestedScrollView$overscrollDelegate$2(this));
        this.f12076n = new d(new ONestedScrollView$translationDelegate$1(this), new ONestedScrollView$translationDelegate$2(this));
        setOverScrollMode(0);
        WeakHashMap r13 = b.s;
        ym.a.f("Landroidx/core/widget/NestedScrollView;");
        if (this.f12067a == true) goto L17;
        this.f12067a = true;
        Field r14 = b("mEdgeGlowTop");     // Catch: Throwable -> L9
        if (r14 != null) goto L11;
        r14 = b("mTopGlow");     // Catch: Throwable -> L9
    L11:
        this.f12068b = r14;     // Catch: Throwable -> L9
        Field r15 = b("mEdgeGlowBottom");     // Catch: Throwable -> L9
        if (r15 != null) goto L14;
        r15 = b("mBottomGlow");     // Catch: Throwable -> L9
    L14:
        this.f12069c = r15;     // Catch: Throwable -> L9
        this.d = b("mScroller");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.w("ONestedScrollView", "Failed to reflect edge effect fields", th);
        this.f12068b = null;
        this.f12069c = null;
        this.d = null;
    L17:
        c r16 = this.f12075m;
        if (this.e == null) goto L20;
        return;
    L20:
        if (this.f != null) goto L52;
        Field r5 = this.f12068b;
        if (r5 == null) goto L53;
        Field r17 = this.f12069c;
        if (r17 == null) goto L54;
        Object r18 = r5.get(this);     // Catch: Throwable -> L31
        if ((r18 instanceof EdgeEffect) == false) goto L33;
        EdgeEffect r19 = (EdgeEffect) r18;     // Catch: Throwable -> L31
    L34:
        Object r20 = r17.get(this);     // Catch: Throwable -> L31
        if ((r20 instanceof EdgeEffect) == false) goto L37;
        EdgeEffect r21 = (EdgeEffect) r20;     // Catch: Throwable -> L31
    L38:
        this.f12073k = r19;     // Catch: Throwable -> L31
        this.f12074l = r21;     // Catch: Throwable -> L31
        b r22 = new b(getContext(), this, 0, r16.f12113c);     // Catch: Throwable -> L31
        b r23 = new b(getContext(), this, 1, r16.f12113c);     // Catch: Throwable -> L31
        if (getWidth() > 0) goto L41;
    L43:
        r5.set(this, r22);     // Catch: Throwable -> L31
        r17.set(this, r23);     // Catch: Throwable -> L31
        this.e = r22;     // Catch: Throwable -> L31
        this.f = r23;     // Catch: Throwable -> L31
        r16.a();     // Catch: Throwable -> L31
        this.f12076n.a();     // Catch: Throwable -> L31
        this.g = true;     // Catch: Throwable -> L31
        return;
    L41:
        if (getHeight() <= 0) goto L43;
        r22.setSize(getWidth(), getHeight());     // Catch: Throwable -> L31
        r23.setSize(getWidth(), getHeight());     // Catch: Throwable -> L31
        goto L43
    L37:
        r21 = null;
        goto L38
    L33:
        r19 = null;
    L31:
        th = move-exception;
        Log.w("ONestedScrollView", "Failed to install BounceEdgeEffects, restoring original.", th);
        a();
        this.e = null;
        this.f = null;
        this.g = false;
        return;
    L54:
        return;
    L53:
        return;
    }
}
