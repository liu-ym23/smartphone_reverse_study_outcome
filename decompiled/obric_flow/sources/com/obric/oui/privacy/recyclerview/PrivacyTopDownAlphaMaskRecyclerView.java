package com.obric.oui.privacy.recyclerview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.fragment.app.d;
import as.a;
import as.b;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.k0;
import com.obric.oui.orecyclerview.widget.s;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR*\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R*\u0010\"\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019¨\u0006#"}, d2 = {"Lcom/obric/oui/privacy/recyclerview/PrivacyTopDownAlphaMaskRecyclerView;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "value", "F0", "F", "getFadeEdgeLength", "()F", "setFadeEdgeLength", "(F)V", "fadeEdgeLength", "", "G0", "Z", "getDynamicFade", "()Z", "setDynamicFade", "(Z)V", "dynamicFade", "H0", "getFadeTop", "setFadeTop", "fadeTop", "I0", "getFadeBottom", "setFadeBottom", "fadeBottom", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrivacyTopDownAlphaMaskRecyclerView extends RecyclerView {
    public static final float[] b1 = null;
    public float F0;
    public boolean G0;
    public boolean H0;
    public boolean I0;
    public float J0;
    public float K0;
    public final Paint L0;
    public final PorterDuffXfermode M0;
    public LinearGradient N0;
    public LinearGradient O0;
    public final Matrix P0;
    public final Matrix Q0;
    public int R0;
    public int S0;
    public float T0;
    public float U0;
    public float V0;
    public ValueAnimator W0;
    public float X0;
    public float Y0;
    public boolean Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public boolean f14193a1;

    static {
        b1 = new float[]{0.0f, 1.0f};
    }

    @JvmOverloads
    public PrivacyTopDownAlphaMaskRecyclerView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final void a0() {
        this.R0 = -1;
        this.S0 = -1;
        this.T0 = -1.0f;
        this.U0 = Float.NaN;
        this.V0 = Float.NaN;
        this.N0 = null;
        this.O0 = null;
    }

    public final void b0(boolean r12) {
        boolean r5 = canScrollVertically(-1);
        boolean r10 = canScrollVertically(1);
        if (this.H0 == false) goto L6;
        if (r5 == false) goto L6;
        final float r11 = 1.0f;
    L8:
        if (this.I0 == false) goto L11;
        if (r10 == false) goto L11;
        final float r13 = 1.0f;
    L12:
        if (r12 == true) goto L14;
        this.X0 = r11;
        this.Y0 = r13;
        this.J0 = r11;
        this.K0 = r13;
        a0();
        invalidate();
        return;
    L14:
        if (this.X0 == r11) goto L16;
    L18:
        this.X0 = r11;
        this.Y0 = r13;
        final float r14 = this.J0;
        final float r15 = this.K0;
        if (r14 == r11) goto L21;
    L23:
        ValueAnimator r16 = this.W0;
        if (r16 == null) goto L27;
        r16.cancel();
    L27:
        ValueAnimator r17 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r17.setDuration(100);
        r17.addUpdateListener(new a(this, r14, r11, r15, r13));
        this.W0 = r17;
        r17.start();
        return;
    L21:
        if (r15 != r13) goto L23;
        return;
    L16:
        if (this.Y0 != r13) goto L18;
        return;
    L11:
        r13 = 0.0f;
    L6:
        r11 = 0.0f;
        goto L8
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    public final void draw(Canvas r19) {
        Intrinsics.checkNotNullParameter(r19, "canvas");
        if (getWidth() > 0) goto L5;
    L75:
        super.draw(r19);
        return;
    L5:
        if (getHeight() <= 0) goto L75;
        if (this.F0 <= 0.0f) goto L75;
        if (this.H0 == true) goto L14;
        if (this.I0 == true) goto L14;
    L17:
        super.draw(r19);
        return;
    L14:
        if (this.J0 > 0.0f) goto L20;
        if (this.K0 <= 0.0f) goto L17;
    L20:
        if (this.R0 == getWidth()) goto L22;
    L30:
        this.R0 = getWidth();
        this.S0 = getHeight();
        float r5 = this.F0;
        this.T0 = r5;
        this.U0 = this.J0;
        this.V0 = this.K0;
        float r10 = RangesKt.coerceAtMost(r5, getHeight());
        if (getWidth() <= 0) goto L50;
        if (getHeight() <= 0) goto L50;
        if (r10 <= 0.0f) goto L50;
        float r11 = RangesKt.coerceIn(this.J0, 0.0f, 1.0f);
        float r12 = RangesKt.coerceIn(this.K0, 0.0f, 1.0f);
        int r13 = RangesKt.coerceIn((int) ((1.0f - r11) * 255.0f), 0, 255);
        int r14 = RangesKt.coerceIn((int) ((1.0f - r12) * 255.0f), 0, 255);
        float[] r15 = b1;
        if (r11 > 0.0f) goto L40;
    L42:
        LinearGradient r16 = null;
    L43:
        this.N0 = r16;
        if (r12 > 0.0f) goto L46;
    L48:
        LinearGradient r17 = null;
    L49:
        this.O0 = r17;
    L51:
        int r18 = r19.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super.draw(r19);
        Paint r110 = this.L0;
        r110.setXfermode(this.M0);
        if (this.H0 == false) goto L63;
        if (this.J0 <= 0.0f) goto L63;
        float r20 = RangesKt.coerceAtMost(this.F0, getHeight());
        if (r20 <= 0.0f) goto L63;
        LinearGradient r21 = this.N0;
        if (r21 == null) goto L63;
        Matrix r22 = this.P0;
        r22.reset();
        r21.setLocalMatrix(r22);
        r110.setShader(r21);
        r19.drawRect(0.0f, 0.0f, getWidth(), r20, r110);
    L63:
        if (this.I0 == true) goto L65;
    L73:
        r110.setXfermode(null);
        r110.setShader(null);
        r19.restoreToCount(r18);
        return;
    L65:
        if (this.K0 <= 0.0f) goto L73;
        float r23 = RangesKt.coerceAtMost(this.F0, getHeight());
        if (r23 <= 0.0f) goto L73;
        float r24 = getHeight();
        float r25 = RangesKt.coerceAtLeast(r24 - r23, 0.0f);
        LinearGradient r26 = this.O0;
        if (r26 == null) goto L73;
        Matrix r27 = this.Q0;
        r27.reset();
        r27.setTranslate(0.0f, r25);
        r26.setLocalMatrix(r27);
        r110.setShader(r26);
        r19.drawRect(0.0f, r25, getWidth(), r24, r110);
        goto L73
    L46:
        if (this.O0 != null) goto L48;
        r17 = new LinearGradient(0.0f, r10, 0.0f, 0.0f, new int[]{Color.argb(r14, r15, r15, r15), Color.argb(255, 0, r15, r15)}, r15, Shader.TileMode.CLAMP);
        goto L49
    L40:
        if (this.N0 != null) goto L42;
        r16 = new LinearGradient(0.0f, 0.0f, 0.0f, r10, new int[]{Color.argb(r13, 0, 0, 0), Color.argb(255, 0, 0, 0)}, r15, Shader.TileMode.CLAMP);
    L50:
        this.N0 = null;
        this.O0 = null;
        goto L51
    L22:
        if (this.S0 != getHeight()) goto L30;
        if (this.T0 != this.F0) goto L30;
        if (this.U0 != this.J0) goto L30;
        if (this.V0 != this.K0) goto L30;
        goto L30
    }

    public final boolean getDynamicFade() {
        return this.G0;
    }

    public final boolean getFadeBottom() {
        return this.I0;
    }

    public final float getFadeEdgeLength() {
        return this.F0;
    }

    public final boolean getFadeTop() {
        return this.H0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r5 = this.W0;
        if (r5 == null) goto L6;
        r5.cancel();
    L6:
        removeCallbacks(null);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        if ((getLayoutManager() instanceof s) == true) goto L5;
        return;
    L5:
        if (this.f14193a1 == false) goto L30;
        int r11 = computeVerticalScrollRange();
        if (r11 <= 0) goto L31;
        int r12 = 0;
        this.f14193a1 = false;
        if (r11 > ((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom())) goto L11;
        boolean r13 = true;
    L12:
        k0 r14 = getLayoutManager();
        if (r14 == null) goto L28;
        if (((s) r14).f13902r == r13) goto L24;
        k0 r15 = getLayoutManager();
        if (r15 == null) goto L23;
        s r16 = (s) r15;
        r16.b(null);
        if (r16.f13902r == r13) goto L24;
        r16.f13902r = r13;
        r16.Q();
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.LinearLayoutManager");
    L24:
        if (r13 == false) goto L26;
        r12 = 2;
    L26:
        setOverScrollMode(r12);
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.LinearLayoutManager");
    L11:
        r13 = false;
        goto L12
    L31:
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        a0();
        post(new d(this, 4));
    }

    public final void setDynamicFade(boolean r5) {
        this.G0 = r5;
    }

    public final void setFadeBottom(boolean r5) {
        if (this.I0 != r5) goto L5;
        return;
    L5:
        this.I0 = r5;
        invalidate();
    }

    public final void setFadeEdgeLength(float r5) {
        float r10 = RangesKt.coerceAtLeast(r5, 0.0f);
        if (this.F0 != r10) goto L5;
        return;
    L5:
        this.F0 = r10;
        a0();
        invalidate();
    }

    public final void setFadeTop(boolean r5) {
        if (this.H0 != r5) goto L5;
        return;
    L5:
        this.H0 = r5;
        invalidate();
    }

    @JvmOverloads
    public PrivacyTopDownAlphaMaskRecyclerView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ PrivacyTopDownAlphaMaskRecyclerView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public PrivacyTopDownAlphaMaskRecyclerView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.F0 = TypedValue.applyDimension(1, 75.0f, getResources().getDisplayMetrics());
        this.G0 = true;
        this.H0 = true;
        this.I0 = true;
        this.L0 = new Paint(1);
        this.M0 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.P0 = new Matrix();
        this.Q0 = new Matrix();
        this.R0 = -1;
        this.S0 = -1;
        this.T0 = -1.0f;
        this.U0 = Float.NaN;
        this.V0 = Float.NaN;
        this.f14193a1 = true;
        if (this.G0 == false) goto L6;
        i(new b(this, 0));
        return;
    }
}
