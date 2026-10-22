package com.obric.oui.texteffects;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$array;
import com.obric.common.oui.R$styleable;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.o;
import com.obric.oui.material.n;
import com.obric.oui.texteffects.core.EffectProperty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import js.f;
import js.i;
import js.j;
import js.m;
import js.p;
import js.s;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u0019R\u0017\u0010!\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010*\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010&R\u0011\u0010,\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b+\u0010&¨\u0006-"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointGenerateEffectView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", MessageIndication.CONTENT_TYPE_TEXT, "", "setText", "(Ljava/lang/CharSequence;)V", "setTextWithEffect", "", "scale", "setDebugAnimationDurationScale", "(F)V", "getDebugAnimationDurationScale", "()F", "Lcom/obric/oui/material/c;", "config", "setScanIndicatorMaterial", "(Lcom/obric/oui/material/c;)V", "setEnterScanIndicatorMaterial", "setExitScanIndicatorMaterial", "Lcom/obric/oui/texteffects/ODimPointEffectTextView;", "a", "Lcom/obric/oui/texteffects/ODimPointEffectTextView;", "getEffectTextView", "()Lcom/obric/oui/texteffects/ODimPointEffectTextView;", "effectTextView", "Landroid/view/View;", "b", "Landroid/view/View;", "getExitScanIndicator", "()Landroid/view/View;", "exitScanIndicator", "c", "getEnterScanIndicator", "enterScanIndicator", "getScanIndicator", "scanIndicator", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODimPointGenerateEffectView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f14707j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ODimPointEffectTextView f14708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f14709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f14710c;
    public final ArrayList d;
    public ValueAnimator e;
    public a2.b f;
    public a2.b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f14711h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1 f14712i;

    @JvmOverloads
    public ODimPointGenerateEffectView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static Float i(f8.b r5) {
        if ((r5 instanceof j) == false) goto L6;
        return Float.valueOf(((j) r5).f18470a);
    L6:
        if ((r5 instanceof i) == true) goto L11;
        return null;
    L11:
        return i(((i) r5).f18467a);
    }

    public final void a(TypedArray r10) {
        ODimPointEffectTextView r11 = this.f14708a;
        int r5 = r11.getPaddingLeft();
        int r12 = r11.getPaddingTop();
        int r13 = r11.getPaddingRight();
        int r14 = r11.getPaddingBottom();
        if (r10.hasValue(R$styleable.ODimPointGenerateEffectView_android_padding) == false) goto L5;
        Integer r15 = Integer.valueOf(r10.getDimensionPixelSize(R$styleable.ODimPointGenerateEffectView_android_padding, 0));
    L6:
        if (r15 == null) goto L9;
        r5 = r15.intValue();
    L9:
        if (r15 == null) goto L12;
        r12 = r15.intValue();
    L12:
        if (r15 == null) goto L15;
        r13 = r15.intValue();
    L15:
        if (r15 == null) goto L19;
        r14 = r15.intValue();
    L19:
        if (r10.hasValue(R$styleable.ODimPointGenerateEffectView_android_paddingLeft) == false) goto L22;
        r5 = r10.getDimensionPixelSize(R$styleable.ODimPointGenerateEffectView_android_paddingLeft, r5);
    L22:
        if (r10.hasValue(R$styleable.ODimPointGenerateEffectView_android_paddingTop) == false) goto L25;
        r12 = r10.getDimensionPixelSize(R$styleable.ODimPointGenerateEffectView_android_paddingTop, r12);
    L25:
        if (r10.hasValue(R$styleable.ODimPointGenerateEffectView_android_paddingRight) == false) goto L28;
        r13 = r10.getDimensionPixelSize(R$styleable.ODimPointGenerateEffectView_android_paddingRight, r13);
    L28:
        if (r10.hasValue(R$styleable.ODimPointGenerateEffectView_android_paddingBottom) == false) goto L31;
        r14 = r10.getDimensionPixelSize(R$styleable.ODimPointGenerateEffectView_android_paddingBottom, r14);
    L31:
        if (r10.hasValue(R$styleable.ODimPointGenerateEffectView_android_paddingStart) == false) goto L34;
        r5 = r10.getDimensionPixelSize(R$styleable.ODimPointGenerateEffectView_android_paddingStart, r5);
    L34:
        if (r10.hasValue(R$styleable.ODimPointGenerateEffectView_android_paddingEnd) == false) goto L36;
        r13 = r10.getDimensionPixelSize(R$styleable.ODimPointGenerateEffectView_android_paddingEnd, r13);
    L36:
        r11.setPadding(r5, r12, r13, r14);
        return;
    L5:
        r15 = null;
        goto L6
    }

    public final void b(s r19) {
        ArrayList r5 = this.d;
        r5.clear();
        ArrayList r10 = new ArrayList();
        Iterator r11 = r19.e.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        CollectionsKt.a(r10, ((f) r11.next()).f18464c);
        goto L4
    L6:
        ArrayList r12 = new ArrayList();
        Iterator r13 = r10.iterator();
    L8:
        if (r13.hasNext() == false) goto L12;
        Object r14 = r13.next();
        if ((r14 instanceof js.c) == false) goto L8;
        r12.add(r14);
        goto L8
    L12:
        HashSet r15 = new HashSet();
        ArrayList r16 = new ArrayList();
        Iterator r17 = r12.iterator();
    L14:
        if (r17.hasNext() == false) goto L18;
        Object r18 = r17.next();
        if (r15.add(((js.c) r18).f18457b) == false) goto L14;
        r16.add(r18);
        goto L14
    L18:
        Iterator r20 = r16.iterator();
    L20:
        if (r20.hasNext() == false) goto L40;
        final js.c r21 = (js.c) r20.next();
        String r22 = r21.f18457b;
        if (Intrinsics.areEqual(r22, "exitScanIndicator") == false) goto L25;
        View r23 = this.f14709b;
    L28:
        if (r23 == null) goto L20;
        int r24 = b.f14728a[r21.f18458c.f18474a.ordinal()];
        int r25 = 4;
        if (r24 == 1) goto L39;
        if (r24 == 2) goto L38;
        if (r24 == 3) goto L38;
        if (r24 == 4) goto L38;
        throw new NoWhenBranchMatchedException();
    L38:
        r25 = 3;
    L39:
        n.o(r23, new com.obric.oui.material.c(null, null, n.c(getResources(), R$array.oui_no_gradient_blur_colors, R$array.oui_no_gradient_blur_blend_modes), new xq.a(16.0f, r25, 3), null, null, 955), 2);
        r5.add(new com.obric.oui.texteffects.runtime.a(r21.f18457b, r23, new ODimPointGenerateEffectView$bindExternalLayers$3$2(this, r21)));
        goto L20
    L25:
        if (Intrinsics.areEqual(r22, "enterScanIndicator") == false) goto L27;
        r23 = this.f14710c;
        goto L28
    L27:
        r23 = null;
        goto L28
    }

    public final float c(CharSequence r5) {
        ODimPointEffectTextView r10 = this.f14708a;
        float r11 = RangesKt.coerceAtLeast((r10.getWidth() - r10.getCompoundPaddingLeft()) - r10.getCompoundPaddingRight(), 0.0f);
        if (r10.getEllipsize() == null) goto L8;
        if (r11 <= 0.0f) goto L8;
        r5 = TextUtils.ellipsize(r5, r10.getPaint(), r11, r10.getEllipsize());
    L8:
        return r10.getPaint().measureText(r5, 0, r5.length());
    }

    public final int d() {
        Paint.FontMetrics r5 = this.f14708a.getPaint().getFontMetrics();
        return RangesKt.coerceAtLeast(MathKt.roundToInt((float) Math.ceil((((Number) this.f14712i.invoke(Float.valueOf(16.0f))).floatValue() * 2.0f) + (r5.descent - r5.ascent))), 1);
    }

    public final void e() {
        Iterator r5 = this.d.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        com.obric.oui.texteffects.runtime.a r10 = (com.obric.oui.texteffects.runtime.a) r5.next();
        int r11 = r10.d;
        View r12 = r10.f14739b;
        r12.setVisibility(r11);
        r12.setTranslationX(-r12.getMeasuredWidth());
        goto L4
    }

    public final void f(s r10) {
        ValueAnimator r5 = this.e;
        if (r5 == null) goto L6;
        r5.cancel();
    L6:
        this.e = null;
        e();
        b(r10);
        Ref.BooleanRef r11 = new Ref.BooleanRef();
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r12.setDuration(RangesKt.coerceAtLeast(MathKt.roundToInt(r10.f18480c * this.f14711h), 1));
        r12.setInterpolator(new LinearInterpolator());
        r12.addUpdateListener(new com.google.android.material.appbar.b(2, r10, this));
        r12.addListener(new o(r11, r10, this));
        r12.start();
        this.e = r12;
    }

    public final void g(CharSequence r5) {
        a2.b r10 = this.f;
        if (r10 == null) goto L6;
        removeCallbacks(r10);
    L6:
        this.f = null;
        a2.b r11 = this.g;
        if (r11 == null) goto L10;
        removeCallbacks(r11);
    L10:
        this.g = null;
        s r12 = ks.a.f19474a.c(true);
        float r13 = this.f14711h;
        ODimPointEffectTextView r14 = this.f14708a;
        r14.setDebugAnimationDurationScale(r13);
        r14.t(r5);
        View r15 = this.f14710c;
        CharSequence r16 = r14.getText();
        if (r16 != null) goto L13;
        r16 = "";
    L13:
        j(r15, r16, r12, "enterScanIndicator");
        f(r12);
    }

    public final float getDebugAnimationDurationScale() {
        return this.f14711h;
    }

    public final ODimPointEffectTextView getEffectTextView() {
        return this.f14708a;
    }

    public final View getEnterScanIndicator() {
        return this.f14710c;
    }

    public final View getExitScanIndicator() {
        return this.f14709b;
    }

    public final View getScanIndicator() {
        return this.f14710c;
    }

    public final void h(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "newText");
        Runnable r5 = this.f;
        if (r5 == null) goto L6;
        removeCallbacks(r5);
    L6:
        this.f = null;
        Runnable r11 = this.g;
        if (r11 == null) goto L10;
        removeCallbacks(r11);
    L10:
        this.g = null;
        s r12 = ks.a.j();
        ODimPointEffectTextView r13 = this.f14708a;
        r13.w();
        ODimPointEffectTextView.RewritePhase r14 = r13.f14700u;
        ODimPointEffectTextView.RewritePhase r15 = ODimPointEffectTextView.RewritePhase.EXITING_OLD_TEXT;
        View r16 = this.f14710c;
        if (r14 != r15) goto L14;
        r13.v(r10);
        j(r16, r10, r12, "enterScanIndicator");
        return;
    L14:
        r13.w();
        if (r13.f14700u != ODimPointEffectTextView.RewritePhase.ENTERING_NEW_TEXT) goto L18;
        a2.b r17 = new a2.b(16, this, r10);
        this.g = r17;
        s r18 = ks.a.j();
        postDelayed(r17, RangesKt.coerceAtLeast(MathKt.roundToInt(RangesKt.coerceAtLeast(r18.f18480c - r13.getCurrentEffectPlayTimeMs(), 1) * this.f14711h), 1));
        return;
    L18:
        CharSequence r19 = r13.getText();
        if (r19 != null) goto L21;
        r19 = "";
    L21:
        r13.setDebugAnimationDurationScale(this.f14711h);
        r13.v(r10);
        j(this.f14709b, r19, r12, "exitScanIndicator");
        j(r16, r10, r12, "enterScanIndicator");
        f(r12);
    }

    public final void j(View r10, CharSequence r11, s r12, final String r13) {
        r10.setTag(r11);
        Iterator r14 = SequencesKt.flatMap(SequencesKt.filter(SequencesKt.filter(SequencesKt.flatMap(CollectionsKt.asSequence(r12.e), ODimPointGenerateEffectView$scanIndicatorFromRatio$1.INSTANCE), ODimPointGenerateEffectView$scanIndicatorFromRatio$$inlined$filterIsInstance$1.INSTANCE), new ODimPointGenerateEffectView$scanIndicatorFromRatio$2(r13)), ODimPointGenerateEffectView$scanIndicatorFromRatio$3.INSTANCE).iterator();
    L3:
        FrameLayout.LayoutParams r5 = null;
        if (r14.hasNext() == false) goto L8;
        Object r15 = r14.next();
        if (((p) r15).f18475a != EffectProperty.TranslationX) goto L3;
    L9:
        p r16 = (p) r15;
        if (r16 != null) goto L12;
    L11:
        Float r17 = null;
    L31:
        if (r17 != null) goto L33;
        return;
    L33:
        float r18 = r17.floatValue();
        int r19 = RangesKt.coerceAtLeast(MathKt.roundToInt((float) Math.ceil(Math.abs(r18) * c(r11))), 1);
        int r20 = d();
        ViewGroup.LayoutParams r110 = r10.getLayoutParams();
        if ((r110 instanceof FrameLayout.LayoutParams) == false) goto L37;
        r5 = (FrameLayout.LayoutParams) r110;
    L37:
        if (r5 != null) goto L40;
        r10.setLayoutParams(new FrameLayout.LayoutParams(r19, r20, 19));
    L44:
        r10.measure(View.MeasureSpec.makeMeasureSpec(r19, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r20, BasicMeasure.EXACTLY));
        return;
    L40:
        if (r5.width == r19) goto L42;
    L43:
        r5.width = r19;
        r5.height = r20;
        r5.gravity = 19;
        r10.setLayoutParams(r5);
        goto L44
    L42:
        if (r5.height == r20) goto L44;
    L12:
        List r111 = r16.f18476b;
        if (r111 == null) goto L11;
        Iterator r112 = r111.iterator();
        if (r112.hasNext() == true) goto L18;
        Object r113 = null;
    L27:
        m r114 = (m) r113;
        if (r114 == null) goto L11;
        r17 = i(r114.f18473b);
        goto L31
    L18:
        r113 = r112.next();
        if (r112.hasNext() == false) goto L27;
        long r21 = ((m) r113).f18472a;
    L22:
        Object r22 = r112.next();
        long r23 = ((m) r22).f18472a;
        if (r21 <= r23) goto L26;
        r113 = r22;
        r21 = r23;
    L26:
        if (r112.hasNext() == true) goto L22;
    L8:
        r15 = null;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        a2.b r5 = this.f;
        if (r5 == null) goto L6;
        removeCallbacks(r5);
    L6:
        this.f = null;
        a2.b r10 = this.g;
        if (r10 == null) goto L10;
        removeCallbacks(r10);
    L10:
        this.g = null;
        ValueAnimator r11 = this.e;
        if (r11 == null) goto L14;
        r11.cancel();
    L14:
        this.e = null;
        e();
        this.f14708a.r();
        super.onDetachedFromWindow();
    }

    public final void setDebugAnimationDurationScale(float r5) {
        if (Float.isNaN(r5) == false) goto L5;
    L8:
        float r10 = 1.0f;
    L10:
        if (this.f14711h != r10) goto L12;
        return;
    L12:
        this.f14711h = r10;
        this.f14708a.setDebugAnimationDurationScale(r10);
        return;
    L5:
        if (Float.isInfinite(r5) == true) goto L8;
        r10 = RangesKt.coerceIn(r5, 0.1f, 10.0f);
        goto L10
    }

    public final void setEnterScanIndicatorMaterial(com.obric.oui.material.c r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        n.o(this.f14710c, r5, 2);
    }

    public final void setExitScanIndicatorMaterial(com.obric.oui.material.c r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        n.o(this.f14709b, r5, 2);
    }

    public final void setScanIndicatorMaterial(com.obric.oui.material.c r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        setEnterScanIndicatorMaterial(r5);
    }

    public final void setText(CharSequence r5) {
        a2.b r10 = this.f;
        if (r10 == null) goto L6;
        removeCallbacks(r10);
    L6:
        this.f = null;
        a2.b r11 = this.g;
        if (r11 == null) goto L10;
        removeCallbacks(r11);
    L10:
        this.g = null;
        ValueAnimator r12 = this.e;
        if (r12 == null) goto L14;
        r12.cancel();
    L14:
        this.e = null;
        e();
        ODimPointEffectTextView r13 = this.f14708a;
        r13.r();
        r13.setText(r5);
    }

    public final void setTextWithEffect(CharSequence r5) {
        ODimPointEffectTextView r10 = this.f14708a;
        CharSequence r11 = r10.getText();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        if (r10.s() == false) goto L28;
        if (r5.length() <= 0) goto L28;
        Intrinsics.checkNotNullParameter(r5, "actualText");
        Runnable r12 = this.f;
        if (r12 == null) goto L15;
        removeCallbacks(r12);
    L15:
        this.f = null;
        Runnable r13 = this.g;
        if (r13 == null) goto L19;
        removeCallbacks(r13);
    L19:
        this.g = null;
        if (r10.s() == true) goto L22;
        g(r5);
        return;
    L22:
        ValueAnimator r14 = this.e;
        if (r14 == null) goto L26;
        r14.cancel();
    L26:
        this.e = null;
        e();
        r10.setDebugAnimationDurationScale(this.f14711h);
        r10.u(r5);
        s r15 = ks.a.f19474a.c(true);
        j(this.f14710c, r5, r15, "enterScanIndicator");
        a2.b r16 = new a2.b(17, this, r15);
        this.f = r16;
        postDelayed(r16, RangesKt.coerceAtLeast(MathKt.roundToInt(150 * this.f14711h), 1));
        return;
    L28:
        if (TextUtils.equals(r11, r5) == false) goto L45;
        if (r11.length() != 0) goto L51;
        Runnable r17 = this.f;
        if (r17 == null) goto L35;
        removeCallbacks(r17);
    L35:
        this.f = null;
        Runnable r18 = this.g;
        if (r18 == null) goto L39;
        removeCallbacks(r18);
    L39:
        this.g = null;
        ValueAnimator r19 = this.e;
        if (r19 == null) goto L43;
        r19.cancel();
    L43:
        this.e = null;
        e();
        r10.r();
        r10.setText(r5);
        return;
    L51:
        return;
    L45:
        if (r11.length() != 0) goto L47;
        g(r5);
        return;
    L47:
        h(r5);
    }

    @JvmOverloads
    public ODimPointGenerateEffectView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ ODimPointGenerateEffectView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public ODimPointGenerateEffectView(Context r18, AttributeSet r19, int r20) {
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18, r19, r20);
        this.d = new ArrayList();
        this.f14711h = 1.0f;
        Function1<Float, Integer> r5 = new ODimPointGenerateEffectView$dp$1(this);
        this.f14712i = r5;
        setClipChildren(false);
        setClipToPadding(false);
        ODimPointEffectTextView r10 = new ODimPointEffectTextView(r18, null, 6, 0);
        r10.setGravity(16);
        r10.setIncludeFontPadding(false);
        r10.setSingleLine(true);
        r10.setPadding(r5.invoke(Float.valueOf(16.0f)).intValue(), 0, r5.invoke(Float.valueOf(16.0f)).intValue(), 0);
        this.f14708a = r10;
        if (r19 != null) goto L6;
        if (r20 != 0) goto L6;
    L92:
        addView(r10, new FrameLayout.LayoutParams(-1, r5.invoke(Float.valueOf(56.0f)).intValue(), 16));
        View r11 = new View(getContext());
        r11.setAlpha(1.0f);
        r11.setVisibility(4);
        this.f14709b = r11;
        View r12 = new View(getContext());
        r12.setAlpha(1.0f);
        r12.setVisibility(4);
        this.f14710c = r12;
        addView(r11, new FrameLayout.LayoutParams(r5.invoke(Float.valueOf(16.0f)).intValue(), d(), 19));
        addView(r12, new FrameLayout.LayoutParams(r5.invoke(Float.valueOf(16.0f)).intValue(), d(), 19));
        b(ks.a.j());
        e();
        return;
    L6:
        TypedArray r13 = getContext().obtainStyledAttributes(r19, R$styleable.ODimPointGenerateEffectView, r20, 0);
    L12:
        th = move-exception;
        r13.recycle();
        throw th;
    L8:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_textAppearance) == false) goto L15;
        int r14 = r13.getResourceId(R$styleable.ODimPointGenerateEffectView_android_textAppearance, 0);     // Catch: Throwable -> L12
        if (r14 == 0) goto L15;
        r10.setTextAppearance(r14);     // Catch: Throwable -> L12
    L15:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_text) == false) goto L18;
        r10.setText(r13.getText(R$styleable.ODimPointGenerateEffectView_android_text));     // Catch: Throwable -> L12
    L18:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_hint) == false) goto L21;
        r10.setHint(r13.getText(R$styleable.ODimPointGenerateEffectView_android_hint));     // Catch: Throwable -> L12
    L21:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_textColor) == false) goto L27;
        ColorStateList r15 = r13.getColorStateList(R$styleable.ODimPointGenerateEffectView_android_textColor);     // Catch: Throwable -> L12
        if (r15 == null) goto L27;
        getEffectTextView().setTextColor(r15);     // Catch: Throwable -> L12
    L27:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_textColorHint) == false) goto L33;
        ColorStateList r16 = r13.getColorStateList(R$styleable.ODimPointGenerateEffectView_android_textColorHint);     // Catch: Throwable -> L12
        if (r16 == null) goto L33;
        getEffectTextView().setHintTextColor(r16);     // Catch: Throwable -> L12
    L33:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_textSize) == false) goto L35;
        r10.setTextSize(0, r13.getDimension(R$styleable.ODimPointGenerateEffectView_android_textSize, r10.getTextSize()));     // Catch: Throwable -> L12
    L35:
        int r17 = r13.getInt(R$styleable.ODimPointGenerateEffectView_android_typeface, -1);     // Catch: Throwable -> L12
        int r110 = r13.getInt(R$styleable.ODimPointGenerateEffectView_android_textStyle, -1);     // Catch: Throwable -> L12
        if (r110 < 0) goto L38;
        int r111 = r110;
    L40:
        if (r17 == 1) goto L47;
        if (r17 == 2) goto L46;
        if (r17 == 3) goto L45;
        Typeface r112 = r10.getTypeface();     // Catch: Throwable -> L12
    L44:
        Typeface r113 = r112;
        if (r17 >= 0) goto L50;
        if (r110 >= 0) goto L50;
    L52:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_gravity) == false) goto L55;
        r10.setGravity(r13.getInt(R$styleable.ODimPointGenerateEffectView_android_gravity, r10.getGravity()));     // Catch: Throwable -> L12
    L55:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_includeFontPadding) == false) goto L58;
        r10.setIncludeFontPadding(r13.getBoolean(R$styleable.ODimPointGenerateEffectView_android_includeFontPadding, r10.getIncludeFontPadding()));     // Catch: Throwable -> L12
    L58:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_singleLine) == false) goto L61;
        r10.setSingleLine(r13.getBoolean(R$styleable.ODimPointGenerateEffectView_android_singleLine, true));     // Catch: Throwable -> L12
    L61:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_lines) == false) goto L64;
        r10.setLines(r13.getInt(R$styleable.ODimPointGenerateEffectView_android_lines, 1));     // Catch: Throwable -> L12
    L64:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_minLines) == false) goto L67;
        r10.setMinLines(r13.getInt(R$styleable.ODimPointGenerateEffectView_android_minLines, 1));     // Catch: Throwable -> L12
    L67:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_maxLines) == false) goto L70;
        r10.setMaxLines(r13.getInt(R$styleable.ODimPointGenerateEffectView_android_maxLines, Integer.MAX_VALUE));     // Catch: Throwable -> L12
    L70:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_ellipsize) == false) goto L83;
        int r21 = r13.getInt(R$styleable.ODimPointGenerateEffectView_android_ellipsize, 0);     // Catch: Throwable -> L12
        if (r21 == 1) goto L80;
        if (r21 == 2) goto L79;
        if (r21 == 3) goto L78;
        if (r21 == 4) goto L77;
        TextUtils.TruncateAt r22 = null;
    L81:
        r10.setEllipsize(r22);     // Catch: Throwable -> L12
        goto L83
    L77:
        r22 = TextUtils.TruncateAt.MARQUEE;     // Catch: Throwable -> L12
        goto L81
    L78:
        r22 = TextUtils.TruncateAt.END;     // Catch: Throwable -> L12
        goto L81
    L79:
        r22 = TextUtils.TruncateAt.MIDDLE;     // Catch: Throwable -> L12
        goto L81
    L80:
        r22 = TextUtils.TruncateAt.START;     // Catch: Throwable -> L12
    L83:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_lineSpacingExtra) == false) goto L85;
    L86:
        r10.setLineSpacing(r13.getDimension(R$styleable.ODimPointGenerateEffectView_android_lineSpacingExtra, 0.0f), r13.getFloat(R$styleable.ODimPointGenerateEffectView_android_lineSpacingMultiplier, 1.0f));     // Catch: Throwable -> L12
    L88:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_letterSpacing) == false) goto L90;
        r10.setLetterSpacing(r13.getFloat(R$styleable.ODimPointGenerateEffectView_android_letterSpacing, r10.getLetterSpacing()));     // Catch: Throwable -> L12
    L90:
        a(r13);     // Catch: Throwable -> L12
        r13.recycle();
        goto L92
    L85:
        if (r13.hasValue(R$styleable.ODimPointGenerateEffectView_android_lineSpacingMultiplier) == false) goto L88;
    L50:
        r10.setTypeface(r113, r111);     // Catch: Throwable -> L12
        goto L52
    L45:
        r112 = Typeface.MONOSPACE;     // Catch: Throwable -> L12
        goto L44
    L46:
        r112 = Typeface.SERIF;     // Catch: Throwable -> L12
        goto L44
    L47:
        r112 = Typeface.SANS_SERIF;     // Catch: Throwable -> L12
        goto L44
    L38:
        r111 = 0;
        goto L40
    }
}
