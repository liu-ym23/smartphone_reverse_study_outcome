package com.obric.oui.oswitch;

import android.R;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import android.widget.CompoundButton;
import androidx.annotation.CallSuper;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.TextViewCompat;
import com.lynx.tasm.utils.a;
import com.lynx.tasm.utils.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import xr.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\r\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0017¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010+\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u0016R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00109\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u0010\u001aR$\u0010=\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u0010\u001d\"\u0004\b<\u0010\u0011R$\u0010@\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010\u001d\"\u0004\b?\u0010\u0011R$\u0010D\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010\u001d\"\u0004\bC\u0010\u0011R$\u0010G\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\u001d\"\u0004\bF\u0010\u0011R$\u0010J\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bH\u0010\u001d\"\u0004\bI\u0010\u0011R(\u0010Q\u001a\u0004\u0018\u00010K2\b\u0010L\u001a\u0004\u0018\u00010K8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR(\u0010X\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010R8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR(\u0010_\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010Y8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R(\u0010c\u001a\u0004\u0018\u00010K2\b\u0010`\u001a\u0004\u0018\u00010K8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010N\"\u0004\bb\u0010PR(\u0010f\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010R8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010U\"\u0004\be\u0010WR(\u0010i\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010Y8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bg\u0010\\\"\u0004\bh\u0010^R$\u0010j\u001a\u00020\u00172\u0006\u0010j\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bk\u00107\"\u0004\bl\u0010\u001aR(\u0010n\u001a\u0004\u0018\u00010m2\b\u0010n\u001a\u0004\u0018\u00010m8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR(\u0010s\u001a\u0004\u0018\u00010m2\b\u0010s\u001a\u0004\u0018\u00010m8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bt\u0010p\"\u0004\bu\u0010rR$\u0010v\u001a\u00020\u00172\u0006\u0010v\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bw\u00107\"\u0004\bx\u0010\u001aR\u0014\u0010z\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\by\u00107R\u0014\u0010|\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b{\u0010\u001dR\u0014\u0010~\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b}\u0010\u001d¨\u0006\u007f"}, d2 = {"Lcom/obric/oui/oswitch/SwitchCompat;", "Landroid/widget/CompoundButton;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/Typeface;", "typeface", "", "setSwitchTypeface", "(Landroid/graphics/Typeface;)V", "resId", "setTrackResource", "(I)V", "setThumbResource", "", "position", "setThumbPosition", "(F)V", "", "checked", "setChecked", "(Z)V", "setCheckedNoAnim", "getCompoundPaddingLeft", "()I", "getCompoundPaddingRight", "Landroid/view/ActionMode$Callback;", "actionModeCallback", "setCustomSelectionActionModeCallback", "(Landroid/view/ActionMode$Callback;)V", "q", "I", "mTouchMode", "w", "F", "getMThumbPosition", "()F", "setMThumbPosition", "mThumbPosition", "Landroid/animation/ObjectAnimator;", "H", "Landroid/animation/ObjectAnimator;", "getMPositionAnimator", "()Landroid/animation/ObjectAnimator;", "setMPositionAnimator", "(Landroid/animation/ObjectAnimator;)V", "mPositionAnimator", "L", "Z", "getAutoCheck", "()Z", "setAutoCheck", "autoCheck", "value", "getThumbConstraintLeft", "setThumbConstraintLeft", "thumbConstraintLeft", "getThumbConstraintRight", "setThumbConstraintRight", "thumbConstraintRight", "pixels", "getSwitchPadding", "setSwitchPadding", "switchPadding", "getSwitchMinWidth", "setSwitchMinWidth", "switchMinWidth", "getThumbTextPadding", "setThumbTextPadding", "thumbTextPadding", "Landroid/graphics/drawable/Drawable;", "track", "getTrackDrawable", "()Landroid/graphics/drawable/Drawable;", "setTrackDrawable", "(Landroid/graphics/drawable/Drawable;)V", "trackDrawable", "Landroid/content/res/ColorStateList;", "tint", "getTrackTintList", "()Landroid/content/res/ColorStateList;", "setTrackTintList", "(Landroid/content/res/ColorStateList;)V", "trackTintList", "Landroid/graphics/PorterDuff$Mode;", "tintMode", "getTrackTintMode", "()Landroid/graphics/PorterDuff$Mode;", "setTrackTintMode", "(Landroid/graphics/PorterDuff$Mode;)V", "trackTintMode", "thumb", "getThumbDrawable", "setThumbDrawable", "thumbDrawable", "getThumbTintList", "setThumbTintList", "thumbTintList", "getThumbTintMode", "setThumbTintMode", "thumbTintMode", "splitTrack", "getSplitTrack", "setSplitTrack", "", "textOn", "getTextOn", "()Ljava/lang/CharSequence;", "setTextOn", "(Ljava/lang/CharSequence;)V", "textOff", "getTextOff", "setTextOff", "showText", "getShowText", "setShowText", "getTargetCheckedState", "targetCheckedState", "getThumbOffset", "thumbOffset", "getThumbScrollRange", "thumbScrollRange", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"RestrictedApi"})
public class SwitchCompat extends CompoundButton {
    public static final c O = null;
    public static final int[] P = null;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public final TextPaint G;
    public ObjectAnimator H;
    public final Rect I;
    public int J;
    public int K;
    public boolean L;
    public final PathInterpolator M;
    public float N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f13932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f13933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f13934c;
    public boolean d;
    public boolean e;
    public Drawable f;
    public ColorStateList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f13935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13936i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13937j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13938k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13939l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13940m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f13941n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f13942o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f13943p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13944q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f13945r;
    public float s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f13946t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final VelocityTracker f13947u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f13948v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f13949w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f13950x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f13951y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13952z;

    static {
        O = new c(Float.TYPE, "thumbPos");
        P = new int[]{R.attr.state_checked};
    }

    @JvmOverloads
    public SwitchCompat(Context r5) {
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final boolean getTargetCheckedState() {
        if (this.N <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getThumbOffset() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        float r5 = 1 - this.f13949w;
    L7:
        return (int) ((r5 * getThumbScrollRange()) + 0.5f);
    L5:
        r5 = this.f13949w;
        goto L7
    }

    private final int getThumbScrollRange() {
        Drawable r5 = this.f;
        if (r5 == null) goto L9;
        Intrinsics.checkNotNull(r5);
        Rect r10 = this.I;
        r5.getPadding(r10);
        Drawable r11 = this.f13932a;
        if (r11 == null) goto L7;
        Rect r12 = DrawableUtils.getOpticalBounds(r11);
    L11:
        return ((((((this.f13950x - this.A) - r10.left) - r10.right) - r12.left) - r12.right) - this.K) - this.J;
    L7:
        r12 = DrawableUtils.INSETS_NONE;
        goto L11
    L9:
        return 0;
    }

    public final void a() {
        Drawable r5 = this.f13932a;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.d == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r5);
        Drawable r10 = r5.mutate();
        this.f13932a = r10;
        if (this.d == false) goto L12;
        Intrinsics.checkNotNull(r10);
        DrawableCompat.setTintList(r10, this.f13933b);
    L12:
        if (this.e == false) goto L14;
        Drawable r11 = this.f13932a;
        Intrinsics.checkNotNull(r11);
        PorterDuff.Mode r12 = this.f13934c;
        Intrinsics.checkNotNull(r12);
        DrawableCompat.setTintMode(r11, r12);
    L14:
        Drawable r13 = this.f13932a;
        Intrinsics.checkNotNull(r13);
        if (r13.isStateful() == false) goto L20;
        Drawable r14 = this.f13932a;
        Intrinsics.checkNotNull(r14);
        r14.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.e == true) goto L8;
    }

    public final void b() {
        Drawable r5 = this.f;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.f13936i == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r5);
        Drawable r10 = r5.mutate();
        this.f = r10;
        if (this.f13936i == false) goto L12;
        Intrinsics.checkNotNull(r10);
        DrawableCompat.setTintList(r10, this.g);
    L12:
        if (this.f13937j == false) goto L14;
        Drawable r11 = this.f;
        Intrinsics.checkNotNull(r11);
        PorterDuff.Mode r12 = this.f13935h;
        Intrinsics.checkNotNull(r12);
        DrawableCompat.setTintMode(r11, r12);
    L14:
        Drawable r13 = this.f;
        Intrinsics.checkNotNull(r13);
        if (r13.isStateful() == false) goto L20;
        Drawable r14 = this.f;
        Intrinsics.checkNotNull(r14);
        r14.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f13937j == true) goto L8;
    }

    @Override // android.view.View
    public final void draw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "c");
        int r5 = this.C;
        int r10 = this.D;
        int r12 = this.E;
        int r13 = this.F;
        int r14 = getThumbOffset() + r5;
        Drawable r15 = this.f13932a;
        if (r15 == null) goto L5;
        Rect r16 = DrawableUtils.getOpticalBounds(r15);
    L6:
        Drawable r17 = this.f;
        Rect r18 = this.I;
        if (r17 == null) goto L26;
        Intrinsics.checkNotNull(r17);
        r17.getPadding(r18);
        int r19 = r18.left;
        r14 = r14 + r19;
        if (r16 == null) goto L24;
        int r20 = r16.left;
        if (r20 <= r19) goto L13;
        r5 = r5 + (r20 - r19);
    L13:
        int r21 = r16.top;
        int r22 = r18.top;
        if (r21 <= r22) goto L16;
        int r23 = (r21 - r22) + r10;
    L17:
        int r24 = r16.right;
        int r25 = r18.right;
        if (r24 <= r25) goto L20;
        r12 = r12 - (r24 - r25);
    L20:
        int r26 = r16.bottom;
        int r27 = r18.bottom;
        if (r26 <= r27) goto L23;
        int r28 = r13 - (r26 - r27);
    L25:
        Drawable r29 = this.f;
        Intrinsics.checkNotNull(r29);
        r29.setBounds(r5, r23, r12, r28);
    L23:
        r28 = r13;
        goto L25
    L16:
        r23 = r10;
        goto L17
    L24:
        r23 = r10;
    L26:
        Drawable r30 = this.f13932a;
        if (r30 == null) goto L31;
        Intrinsics.checkNotNull(r30);
        r30.getPadding(r18);
        int r31 = r14 - r18.left;
        int r32 = this.J;
        int r33 = r31 + r32;
        int r34 = ((r14 + this.A) + r18.right) + r32;
        int r35 = ((r13 - r10) - this.B) / 2;
        Drawable r36 = this.f13932a;
        Intrinsics.checkNotNull(r36);
        r36.setBounds(r33, r35, r34, this.B + r35);
        Drawable r37 = getBackground();
        if (r37 == null) goto L31;
        DrawableCompat.setHotspotBounds(r37, r33, r10, r34, r13);
    L31:
        super.draw(r11);
        return;
    L5:
        r16 = DrawableUtils.INSETS_NONE;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float r5, float r10) {
        super.drawableHotspotChanged(r5, r10);
        Drawable r11 = this.f13932a;
        if (r11 == null) goto L5;
        Intrinsics.checkNotNull(r11);
        DrawableCompat.setHotspot(r11, r5, r10);
    L5:
        Drawable r12 = this.f;
        if (r12 == null) goto L9;
        Intrinsics.checkNotNull(r12);
        DrawableCompat.setHotspot(r12, r5, r10);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r5 = getDrawableState();
        Drawable r10 = this.f13932a;
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        Drawable r12 = this.f;
        if (r12 != null) goto L11;
    L13:
        if (r11 == false) goto L16;
        invalidate();
        return;
    L16:
        return;
    L11:
        if (r12.isStateful() == false) goto L13;
        r11 = r11 | r12.setState(r5);
        goto L13
    L5:
        if (r10.isStateful() == false) goto L7;
        r11 = r10.setState(r5);
        goto L8
    }

    public final boolean getAutoCheck() {
        return this.L;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        int r5 = super.getCompoundPaddingLeft() + this.f13950x;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r5;
    L9:
        return r5 + this.f13940m;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this) == true) goto L5;
        int r5 = super.getCompoundPaddingRight() + this.f13950x;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r5;
    L9:
        return r5 + this.f13940m;
    L5:
        return super.getCompoundPaddingRight();
    }

    public final ObjectAnimator getMPositionAnimator() {
        return this.H;
    }

    public final float getMThumbPosition() {
        return this.f13949w;
    }

    public final boolean getShowText() {
        return false;
    }

    public final boolean getSplitTrack() {
        return this.f13941n;
    }

    public final int getSwitchMinWidth() {
        return this.f13939l;
    }

    public final int getSwitchPadding() {
        return this.f13940m;
    }

    public final CharSequence getTextOff() {
        return this.f13943p;
    }

    public final CharSequence getTextOn() {
        return this.f13942o;
    }

    public final int getThumbConstraintLeft() {
        return this.J;
    }

    public final int getThumbConstraintRight() {
        return this.K;
    }

    public final Drawable getThumbDrawable() {
        return this.f13932a;
    }

    public final int getThumbTextPadding() {
        return this.f13938k;
    }

    public final ColorStateList getThumbTintList() {
        return this.f13933b;
    }

    public final PorterDuff.Mode getThumbTintMode() {
        return this.f13934c;
    }

    public final Drawable getTrackDrawable() {
        return this.f;
    }

    public final ColorStateList getTrackTintList() {
        return this.g;
    }

    public final PorterDuff.Mode getTrackTintMode() {
        return this.f13935h;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r5 = this.f13932a;
        if (r5 == null) goto L5;
        Intrinsics.checkNotNull(r5);
        r5.jumpToCurrentState();
    L5:
        Drawable r10 = this.f;
        if (r10 == null) goto L8;
        Intrinsics.checkNotNull(r10);
        r10.jumpToCurrentState();
    L8:
        ObjectAnimator r11 = this.H;
        if (r11 == null) goto L14;
        Intrinsics.checkNotNull(r11);
        if (r11.isStarted() == false) goto L15;
        ObjectAnimator r12 = this.H;
        Intrinsics.checkNotNull(r12);
        r12.end();
        this.H = null;
        return;
    L15:
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        this.f13951y = a.B(4, this);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int r5) {
        int[] r10 = super.onCreateDrawableState(r5 + 1);
        if (isChecked() == false) goto L5;
        View.mergeDrawableStates(r10, P);
    L5:
        return r10;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        Drawable r5 = this.f;
        Rect r11 = this.I;
        if (r5 != null) goto L5;
        Boolean r12 = null;
    L6:
        if (r12 != null) goto L8;
        r11.setEmpty();
        Unit r13 = Unit.INSTANCE;
    L8:
        int r14 = r11.top;
        Drawable r15 = this.f13932a;
        if (r5 != null) goto L11;
    L15:
        int r16 = r10.save();
        if (r15 == null) goto L19;
        r15.draw(r10);
    L19:
        getTargetCheckedState();
        r10.restoreToCount(r16);
        return;
    L11:
        if (this.f13941n == false) goto L14;
        if (r15 == null) goto L14;
        Rect r17 = DrawableUtils.getOpticalBounds(r15);
        r15.copyBounds(r11);
        r11.left += r17.left;
        r11.right -= r17.right;
        int r18 = r10.save();
        r10.clipRect(r11, Region.Op.DIFFERENCE);
        r5.draw(r10);
        r10.restoreToCount(r18);
    L14:
        r5.draw(r10);
        goto L15
    L5:
        r12 = Boolean.valueOf(r5.getPadding(r11));
        goto L6
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        super.onInitializeAccessibilityEvent(r5);
        r5.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "info");
        super.onInitializeAccessibilityNodeInfo(r5);
        r5.setClassName("android.widget.Switch");
        if (isChecked() == false) goto L5;
        CharSequence r10 = this.f13942o;
    L7:
        if (TextUtils.isEmpty(r10) == true) goto L13;
        CharSequence r11 = r5.getText();
        if (TextUtils.isEmpty(r11) == false) goto L11;
        r5.setText(r10);
        return;
    L11:
        StringBuilder r12 = new StringBuilder();
        r12.append(r11);
        r12.append(' ');
        r12.append(r10);
        r5.setText(r12);
        return;
    L13:
        return;
    L5:
        r10 = this.f13943p;
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        int r14 = 0;
        if (this.f13932a == null) goto L9;
        Drawable r15 = this.f;
        Rect r16 = this.I;
        if (r15 == null) goto L7;
        Intrinsics.checkNotNull(r15);
        r15.getPadding(r16);
    L8:
        Rect r17 = DrawableUtils.getOpticalBounds(this.f13932a);
        int r18 = Math.max(0, r17.left - r16.left);
        r14 = Math.max(0, r17.right - r16.right);
    L11:
        if (ViewUtils.isLayoutRtl(this) == false) goto L13;
        int r19 = getPaddingLeft() + r18;
        int r20 = ((this.f13950x + r19) - r18) - r14;
    L14:
        int r21 = getGravity() & 112;
        if (r21 != 16) goto L17;
        int r22 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
        int r23 = this.f13952z;
        int r24 = r22 - (r23 / 2);
        int r25 = r23 + r24;
        int r26 = r24;
    L25:
        this.C = r19;
        this.D = r26;
        this.F = r25;
        this.E = r20;
        return;
    L17:
        if (r21 != 48) goto L19;
        r26 = getPaddingTop();
        int r27 = this.f13952z;
    L21:
        r25 = r27 + r26;
        goto L25
    L19:
        if (r21 == 80) goto L22;
        r26 = getPaddingTop();
        r27 = this.f13952z;
        goto L21
    L22:
        r25 = getHeight() - getPaddingBottom();
        r26 = r25 - this.f13952z;
        goto L25
    L13:
        r20 = (getWidth() - getPaddingRight()) - r14;
        r19 = ((r20 - this.f13950x) + r18) + r14;
        goto L14
    L7:
        r16.setEmpty();
        goto L8
    L9:
        r18 = 0;
        goto L11
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        Drawable r5 = this.f13932a;
        int r12 = 0;
        Rect r13 = this.I;
        if (r5 == null) goto L5;
        Intrinsics.checkNotNull(r5);
        r5.getPadding(r13);
        Drawable r14 = this.f13932a;
        Intrinsics.checkNotNull(r14);
        int r15 = (r14.getIntrinsicWidth() - r13.left) - r13.right;
        Drawable r16 = this.f13932a;
        Intrinsics.checkNotNull(r16);
        int r17 = r16.getIntrinsicHeight();
    L6:
        this.A = Math.max(0, r15);
        this.B = r17;
        Drawable r18 = this.f;
        if (r18 == null) goto L9;
        Intrinsics.checkNotNull(r18);
        r18.getPadding(r13);
        Drawable r19 = this.f;
        Intrinsics.checkNotNull(r19);
        r12 = r19.getIntrinsicHeight();
    L10:
        int r20 = r13.left;
        int r21 = r13.right;
        Drawable r22 = this.f13932a;
        if (r22 == null) goto L13;
        Rect r23 = DrawableUtils.getOpticalBounds(r22);
        r20 = Math.max(r20, r23.left);
        r21 = Math.max(r21, r23.right);
    L13:
        int r24 = Math.max(this.f13939l, ((this.A * 2) + r20) + r21);
        int r25 = Math.max(r12, r17);
        this.f13950x = r24 - this.f13951y;
        this.f13952z = r25;
        super.onMeasure(r10, r11);
        if (getMeasuredHeight() >= r25) goto L17;
        setMeasuredDimension(getMeasuredWidthAndState(), r25);
        return;
    L17:
        return;
    L9:
        r13.setEmpty();
        goto L10
    L5:
        r15 = 0;
        r17 = 0;
        goto L6
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        super.onPopulateAccessibilityEvent(r5);
        if (isChecked() == false) goto L5;
        CharSequence r10 = this.f13942o;
    L6:
        if (r10 == null) goto L9;
        r5.getText().add(r10);
        return;
    L9:
        return;
    L5:
        r10 = this.f13943p;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        VelocityTracker r5 = this.f13947u;
        r5.addMovement(r10);
        int r11 = r10.getActionMasked();
        int r12 = this.f13945r;
        if (r11 == 0) goto L69;
        float r13 = 0.0f;
        if (r11 == 1) goto L42;
        if (r11 == 2) goto L9;
        if (r11 == 3) goto L42;
    L84:
        return super.onTouchEvent(r10);
    L9:
        int r14 = this.f13944q;
        if (r14 == 1) goto L35;
        if (r14 != 2) goto L84;
        float r15 = r10.getX();
        int r16 = getThumbScrollRange();
        float r17 = r15 - this.s;
        if (r16 == 0) goto L17;
        float r18 = r17 / r16;
    L21:
        if (ViewUtils.isLayoutRtl(this) == false) goto L23;
        r18 = -r18;
    L23:
        float r19 = this.N;
        float r20 = r18 + r19;
        if (r20 < 0.0f) goto L31;
        if (r20 <= 1.0f) goto L29;
        r13 = 1.0f;
        goto L31
    L29:
        r13 = r20;
    L31:
        if (r13 == r19) goto L34;
        this.s = r15;
        this.N = r13;
    L34:
        return true;
    L17:
        if (r17 <= 0.0f) goto L19;
        r18 = 1.0f;
        goto L21
    L19:
        r18 = -1.0f;
        goto L21
    L35:
        float r21 = r10.getX();
        float r22 = r10.getY();
        if (Math.abs(r21 - this.s) <= r12) goto L38;
    L39:
        this.f13944q = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.s = r21;
        this.f13946t = r22;
        return true;
    L38:
        if (Math.abs(r22 - this.f13946t) <= r12) goto L84;
    L42:
        if (this.f13944q != 2) goto L68;
        this.f13944q = 0;
        if (r10.getAction() == 1) goto L46;
    L48:
        boolean r23 = false;
    L49:
        boolean r24 = isChecked();
        if (r23 == false) goto L63;
        r5.computeCurrentVelocity(1000);
        float r25 = r5.getXVelocity();
        if (Math.abs(r25) > this.f13948v) goto L54;
        boolean r26 = getTargetCheckedState();
    L64:
        if (r26 == r24) goto L66;
        playSoundEffect(0);
    L66:
        setChecked(r26);
        MotionEvent r27 = MotionEvent.obtain(r10);
        r27.setAction(3);
        super.onTouchEvent(r27);
        r27.recycle();
        super.onTouchEvent(r10);
        return true;
    L54:
        if (ViewUtils.isLayoutRtl(this) == false) goto L60;
        if (r25 >= 0.0f) goto L58;
    L57:
        r26 = true;
    L58:
        r26 = false;
        goto L64
    L60:
        if (r25 <= 0.0f) goto L58;
    L63:
        r26 = r24;
        goto L64
    L46:
        if (isEnabled() == false) goto L48;
        r23 = true;
        goto L49
    L68:
        this.f13944q = 0;
        r5.clear();
        goto L84
    L69:
        float r28 = r10.getX();
        float r29 = r10.getY();
        if (isEnabled() == false) goto L84;
        if (this.f13932a == null) goto L84;
        int r30 = getThumbOffset();
        Drawable r31 = this.f13932a;
        Intrinsics.checkNotNull(r31);
        Rect r32 = this.I;
        r31.getPadding(r32);
        int r33 = this.D - r12;
        int r34 = (this.C + r30) - r12;
        int r35 = (((this.A + r34) + r32.left) + r32.right) + r12;
        int r36 = this.F + r12;
        if (r28 <= r34) goto L84;
        if (r28 >= r35) goto L84;
        if (r29 <= r33) goto L84;
        if (r29 >= r36) goto L84;
        this.f13944q = 1;
        this.s = r28;
        this.f13946t = r29;
        goto L84
    }

    @Override // android.widget.CompoundButton, android.view.View
    public final boolean performClick() {
        boolean r5 = super.performClick();
        if (isHapticFeedbackEnabled() == true) goto L5;
    L8:
        return r5;
    L5:
        if (isChecked() == false) goto L7;
        g.p(4, getContext());
        goto L8
    L7:
        g.p(5, getContext());
        goto L8
    }

    public final void setAutoCheck(boolean r5) {
        this.L = r5;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r5) {
        super.setChecked(r5);
        boolean r10 = isChecked();
        float r11 = 0.0f;
        if (getWindowToken() != null) goto L5;
    L26:
        ObjectAnimator r12 = this.H;
        if (r12 == null) goto L29;
        Intrinsics.checkNotNull(r12);
        r12.cancel();
    L29:
        if (r10 == false) goto L31;
        r11 = 1.0f;
    L31:
        setThumbPosition(r11);
        return;
    L5:
        if (getWidth() <= 0) goto L26;
        if (getHeight() <= 0) goto L26;
        if (r10 == false) goto L10;
        r11 = 1.0f;
    L10:
        ObjectAnimator r13 = ObjectAnimator.ofFloat(this, O, new float[]{r11});
        this.H = r13;
        if (r13 == null) goto L14;
        r13.setDuration(443);
    L14:
        ObjectAnimator r14 = this.H;
        if (r14 == null) goto L18;
        r14.setAutoCancel(true);
    L18:
        ObjectAnimator r15 = this.H;
        if (r15 == null) goto L22;
        r15.setInterpolator(this.M);
    L22:
        ObjectAnimator r16 = this.H;
        if (r16 == null) goto L34;
        r16.start();
        return;
    }

    @CallSuper
    public void setCheckedNoAnim(boolean r5) {
        super.setChecked(r5);
        ObjectAnimator r10 = this.H;
        if (r10 == null) goto L6;
        Intrinsics.checkNotNull(r10);
        r10.cancel();
    L6:
        if (isChecked() == false) goto L8;
        float r11 = 1.0f;
    L9:
        setThumbPosition(r11);
        return;
    L8:
        r11 = 0.0f;
        goto L9
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r5) {
        Intrinsics.checkNotNullParameter(r5, "actionModeCallback");
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r5));
    }

    public final void setMPositionAnimator(ObjectAnimator r5) {
        this.H = r5;
    }

    public final void setMThumbPosition(float r5) {
        this.f13949w = r5;
    }

    public final void setShowText(boolean r5) {
    }

    public final void setSplitTrack(boolean r5) {
        this.f13941n = r5;
        invalidate();
    }

    public final void setSwitchMinWidth(int r5) {
        this.f13939l = r5;
        requestLayout();
    }

    public final void setSwitchPadding(int r5) {
        this.f13940m = r5;
        requestLayout();
    }

    public final void setSwitchTypeface(Typeface r5) {
        TextPaint r10 = this.G;
        if (r10.getTypeface() == null) goto L7;
        if (Intrinsics.areEqual(r10.getTypeface(), r5) == true) goto L7;
    L9:
        r10.setTypeface(r5);
        requestLayout();
        invalidate();
        return;
    L7:
        if (r10.getTypeface() != null) goto L11;
        if (r5 != null) goto L9;
        return;
    }

    public final void setTextOff(CharSequence r5) {
        this.f13943p = r5;
        requestLayout();
    }

    public final void setTextOn(CharSequence r5) {
        this.f13942o = r5;
        requestLayout();
    }

    public final void setThumbConstraintLeft(int r5) {
        this.J = r5;
    }

    public final void setThumbConstraintRight(int r5) {
        this.K = r5;
    }

    public final void setThumbDrawable(Drawable r5) {
        Drawable r10 = this.f13932a;
        if (r10 == null) goto L5;
        Intrinsics.checkNotNull(r10);
        r10.setCallback(null);
    L5:
        this.f13932a = r5;
        if (r5 == null) goto L8;
        r5.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setThumbPosition(float r5) {
        this.f13949w = r5;
        invalidate();
    }

    public final void setThumbResource(int r5) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r5));
    }

    public final void setThumbTextPadding(int r5) {
        this.f13938k = r5;
        requestLayout();
    }

    public final void setThumbTintList(ColorStateList r5) {
        this.f13933b = r5;
        this.d = true;
        a();
    }

    public final void setThumbTintMode(PorterDuff.Mode r5) {
        this.f13934c = r5;
        this.e = true;
        a();
    }

    public final void setTrackDrawable(Drawable r5) {
        Drawable r10 = this.f;
        if (r10 == null) goto L5;
        Intrinsics.checkNotNull(r10);
        r10.setCallback(null);
    L5:
        this.f = r5;
        if (r5 == null) goto L8;
        r5.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setTrackResource(int r5) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), r5));
    }

    public final void setTrackTintList(ColorStateList r5) {
        this.g = r5;
        this.f13936i = true;
        b();
    }

    public final void setTrackTintMode(PorterDuff.Mode r5) {
        this.f13935h = r5;
        this.f13937j = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        if (this.L == false) goto L6;
        setChecked(!isChecked());
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable r5) {
        Intrinsics.checkNotNullParameter(r5, "who");
        if (super.verifyDrawable(r5) == false) goto L5;
    L10:
        return true;
    L5:
        if (r5 == this.f13932a) goto L10;
        if (r5 == this.f) goto L10;
        return false;
    }

    @JvmOverloads
    public SwitchCompat(Context r5, AttributeSet r10) {
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ SwitchCompat(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, androidx.appcompat.R.attr.switchStyle);
    }

    @JvmOverloads
    public SwitchCompat(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f13947u = VelocityTracker.obtain();
        this.I = new Rect();
        boolean r5 = true;
        this.L = true;
        this.M = new PathInterpolator(0.33f, 1.3f, 0.15f, 1.0f);
        this.f13951y = a.B(4, this);
        TextPaint r13 = new TextPaint(1);
        this.G = r13;
        r13.density = getResources().getDisplayMetrics().density;
        TintTypedArray r14 = TintTypedArray.obtainStyledAttributes(r10, r11, androidx.appcompat.R.styleable.SwitchCompat, r12, 0);
        Drawable r15 = r14.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_android_thumb);
        this.f13932a = r15;
        if (r15 == null) goto L5;
        Intrinsics.checkNotNull(r15);
        r15.setCallback(this);
    L5:
        Drawable r16 = r14.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_track);
        this.f = r16;
        if (r16 == null) goto L8;
        Intrinsics.checkNotNull(r16);
        r16.setCallback(this);
    L8:
        this.f13942o = r14.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOn);
        this.f13943p = r14.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOff);
        this.f13938k = r14.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f13939l = r14.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f13940m = r14.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.f13941n = r14.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList r17 = r14.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (r17 == null) goto L11;
        this.f13933b = r17;
        this.d = true;
    L11:
        Typeface r18 = null;
        PorterDuff.Mode r19 = DrawableUtils.parseTintMode(r14.getInt(androidx.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f13934c == r19) goto L15;
        this.f13934c = r19;
        this.e = true;
    L15:
        if (this.d == false) goto L17;
    L18:
        a();
    L19:
        ColorStateList r110 = r14.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_trackTint);
        if (r110 == null) goto L22;
        this.g = r110;
        this.f13936i = true;
    L22:
        PorterDuff.Mode r111 = DrawableUtils.parseTintMode(r14.getInt(androidx.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f13935h == r111) goto L26;
        this.f13935h = r111;
        this.f13937j = true;
    L26:
        if (this.f13936i == false) goto L28;
    L29:
        b();
    L30:
        int r112 = r14.getResourceId(androidx.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (r112 == 0) goto L72;
        TintTypedArray r113 = TintTypedArray.obtainStyledAttributes(r10, r112, androidx.appcompat.R.styleable.TextAppearance);
        if (r113.getColorStateList(androidx.appcompat.R.styleable.TextAppearance_android_textColor) != null) goto L35;
        getTextColors();
    L35:
        int r20 = r113.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
        if (r20 == 0) goto L41;
        float r21 = r20;
        if (r21 == r13.getTextSize()) goto L41;
        r13.setTextSize(r21);
        requestLayout();
    L41:
        int r22 = r113.getInt(androidx.appcompat.R.styleable.TextAppearance_android_typeface, -1);
        int r23 = r113.getInt(androidx.appcompat.R.styleable.TextAppearance_android_textStyle, -1);
        if (r22 == 1) goto L49;
        if (r22 != 2) goto L45;
        r18 = Typeface.SERIF;
    L50:
        float r24 = 0.0f;
        if (r23 <= 0) goto L67;
        if (r18 != null) goto L54;
        Typeface r25 = Typeface.defaultFromStyle(r23);
    L55:
        setSwitchTypeface(r25);
        if (r25 != null) goto L58;
        int r26 = 0;
    L59:
        int r27 = r23 & (~r26);
        if ((r27 & 1) != 0) goto L63;
        r5 = false;
    L63:
        r13.setFakeBoldText(r5);
        if ((r27 & 2) == 0) goto L66;
        r24 = -0.25f;
    L66:
        r13.setTextSkewX(r24);
    L69:
        if (r113.getBoolean(androidx.appcompat.R.styleable.TextAppearance_textAllCaps, false) == false) goto L71;
        new AllCapsTransformationMethod(getContext());
    L71:
        r113.recycle();
        goto L72
    L58:
        r26 = r25.getStyle();
        goto L59
    L54:
        r25 = Typeface.create(r18, r23);
        goto L55
    L67:
        r13.setFakeBoldText(false);
        r13.setTextSkewX(0.0f);
        setSwitchTypeface(r18);
        goto L69
    L45:
        if (r22 != 3) goto L50;
        r18 = Typeface.MONOSPACE;
        goto L50
    L49:
        r18 = Typeface.SANS_SERIF;
    L72:
        r14.recycle();
        if (r10 == null) goto L75;
        ViewConfiguration r28 = ViewConfiguration.get(r10);
        this.f13945r = r28.getScaledTouchSlop();
        this.f13948v = r28.getScaledMinimumFlingVelocity();
    L76:
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L75:
        this.f13945r = 0;
        this.f13948v = 0;
        goto L76
    L28:
        if (this.f13937j == false) goto L30;
    L17:
        if (this.e == false) goto L19;
        goto L18
    }
}
