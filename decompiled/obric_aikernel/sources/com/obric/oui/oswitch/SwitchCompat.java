package com.obric.oui.oswitch;

import android.R;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
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
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.crash.entity.EventBody;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 }2\u00020\u0001:\u0001~B)\b\u0007\u0012\b\u0010w\u001a\u0004\u0018\u00010v\u0012\n\b\u0002\u0010y\u001a\u0004\u0018\u00010x\u0012\b\b\u0002\u0010z\u001a\u00020\u0006¢\u0006\u0004\b{\u0010|J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0017J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0016\u0010\u0018\u001a\u00020\u00068B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u001f\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u00020\r2\u0006\u0010 \u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\"R\"\u0010+\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R(\u0010-\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010,8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00103\u001a\u00020\u00068B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0017R(\u0010:\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010?\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010\u0017\"\u0004\b=\u0010>R$\u0010C\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bA\u0010\u0017\"\u0004\bB\u0010>R\"\u0010J\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR(\u0010P\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010\u001c\"\u0004\bO\u0010\u001eR$\u0010Q\u001a\u00020\r2\u0006\u0010Q\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010\"\"\u0004\bS\u0010$R$\u0010V\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010\u0017\"\u0004\bU\u0010>R(\u0010]\u001a\u0004\u0018\u00010W2\b\u0010X\u001a\u0004\u0018\u00010W8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R(\u0010^\u001a\u0004\u0018\u00010,2\b\u0010^\u001a\u0004\u0018\u00010,8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b_\u0010/\"\u0004\b`\u00101R$\u0010c\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010\u0017\"\u0004\bb\u0010>R$\u0010f\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010\u0017\"\u0004\be\u0010>R$\u0010n\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR(\u0010q\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bo\u00107\"\u0004\bp\u00109R(\u0010u\u001a\u0004\u0018\u00010W2\b\u0010r\u001a\u0004\u0018\u00010W8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bs\u0010Z\"\u0004\bt\u0010\\¨\u0006\u007f"}, d2 = {"Lcom/obric/oui/oswitch/SwitchCompat;", "Landroid/widget/CompoundButton;", "Landroid/graphics/Typeface;", "typeface", "", "setSwitchTypeface", "", "resId", "setTrackResource", "setThumbResource", "", "position", "setThumbPosition", "", "checked", "setChecked", "setCheckedNoAnim", "getCompoundPaddingLeft", "getCompoundPaddingRight", "Landroid/view/ActionMode$Callback;", "actionModeCallback", "setCustomSelectionActionModeCallback", "getThumbOffset", "()I", "thumbOffset", "Landroid/content/res/ColorStateList;", "tint", "getTrackTintList", "()Landroid/content/res/ColorStateList;", "setTrackTintList", "(Landroid/content/res/ColorStateList;)V", "trackTintList", "splitTrack", "getSplitTrack", "()Z", "setSplitTrack", "(Z)V", "getTargetCheckedState", "targetCheckedState", "U", "Z", "getAutoCheck", "setAutoCheck", "autoCheck", "", "textOff", "getTextOff", "()Ljava/lang/CharSequence;", "setTextOff", "(Ljava/lang/CharSequence;)V", "getThumbScrollRange", "thumbScrollRange", "Landroid/graphics/PorterDuff$Mode;", "tintMode", "getTrackTintMode", "()Landroid/graphics/PorterDuff$Mode;", "setTrackTintMode", "(Landroid/graphics/PorterDuff$Mode;)V", "trackTintMode", EventBody.KEY_VALUE, "getThumbConstraintRight", "setThumbConstraintRight", "(I)V", "thumbConstraintRight", "pixels", "getThumbTextPadding", "setThumbTextPadding", "thumbTextPadding", "C", "F", "getMThumbPosition", "()F", "setMThumbPosition", "(F)V", "mThumbPosition", "w", "I", "mTouchMode", "getThumbTintList", "setThumbTintList", "thumbTintList", "showText", "getShowText", "setShowText", "getThumbConstraintLeft", "setThumbConstraintLeft", "thumbConstraintLeft", "Landroid/graphics/drawable/Drawable;", "track", "getTrackDrawable", "()Landroid/graphics/drawable/Drawable;", "setTrackDrawable", "(Landroid/graphics/drawable/Drawable;)V", "trackDrawable", "textOn", "getTextOn", "setTextOn", "getSwitchPadding", "setSwitchPadding", "switchPadding", "getSwitchMinWidth", "setSwitchMinWidth", "switchMinWidth", "Landroid/animation/ObjectAnimator;", "Q", "Landroid/animation/ObjectAnimator;", "getMPositionAnimator", "()Landroid/animation/ObjectAnimator;", "setMPositionAnimator", "(Landroid/animation/ObjectAnimator;)V", "mPositionAnimator", "getThumbTintMode", "setThumbTintMode", "thumbTintMode", "thumb", "getThumbDrawable", "setThumbDrawable", "thumbDrawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c0", "b", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
@SuppressLint({"RestrictedApi"})
public class SwitchCompat extends CompoundButton {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static final Property<SwitchCompat, Float> f6912a0 = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static final int[] f6913b0 = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final b f6914c0 = null;
    private final VelocityTracker A;
    private final int B;
    private float C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f6915J;
    private int K;
    private final TextPaint L;
    private ColorStateList M;
    private Layout N;
    private Layout O;
    private TransformationMethod P;
    private ObjectAnimator Q;
    private final Rect R;
    private int S;
    private int T;
    private boolean U;
    private final PathInterpolator V;
    private float W;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f6916c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ColorStateList f6917g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private PorterDuff.Mode f6918h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6919i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6920j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Drawable f6921k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ColorStateList f6922l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private PorterDuff.Mode f6923m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f6924n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f6925o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f6926p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f6927q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f6928r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f6929s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private CharSequence f6930t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private CharSequence f6931u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f6932v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f6933w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f6934x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f6935y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f6936z;

    public static final class a extends Property<SwitchCompat, Float> {
        a(Class r10, String r11) {
            super(r10, r11);
        }

        public Float a(SwitchCompat r10) {
            Intrinsics.checkNotNullParameter(r10, "object");
            return Float.valueOf(r10.getMThumbPosition());
        }

        public void b(SwitchCompat r10, float r11) {
            Intrinsics.checkNotNullParameter(r10, "object");
            r10.setThumbPosition(r11);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(SwitchCompat r10) {
            return a(r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(SwitchCompat r10, Float r11) {
            b(r10, r11.floatValue());
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ float a(b r10, float r11, float r12, float r13) {
            return r10.b(r11, r12, r13);
        }

        private final float b(float r10, float r11, float r12) {
            if (r10 >= r11) goto L6;
            return r11;
        L6:
            if (r10 > r12) goto L8;
            return r10;
        L8:
            return r12;
        }
    }

    static {
        f6914c0 = new b(null);
        f6912a0 = new a(Float.TYPE, "thumbPos");
        f6913b0 = new int[]{R.attr.state_checked};
    }

    @JvmOverloads
    public SwitchCompat(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public SwitchCompat(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public SwitchCompat(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.A = VelocityTracker.obtain();
        this.R = new Rect();
        this.U = true;
        this.V = new PathInterpolator(0.33f, 1.3f, 0.15f, 1.0f);
        TextPaint r13 = new TextPaint(1);
        this.L = r13;
        Resources r14 = getResources();
        Intrinsics.checkNotNullExpressionValue(r14, "res");
        r13.density = r14.getDisplayMetrics().density;
        TintTypedArray r15 = TintTypedArray.obtainStyledAttributes(r10, r11, androidx.appcompat.R.styleable.SwitchCompat, r12, 0);
        Drawable r16 = r15.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_android_thumb);
        this.f6916c = r16;
        if (r16 == null) goto L5;
        Intrinsics.checkNotNull(r16);
        r16.setCallback(this);
    L5:
        Drawable r17 = r15.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_track);
        this.f6921k = r17;
        if (r17 == null) goto L8;
        Intrinsics.checkNotNull(r17);
        r17.setCallback(this);
    L8:
        this.f6930t = r15.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOn);
        this.f6931u = r15.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOff);
        this.f6932v = false;
        this.f6926p = r15.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f6927q = r15.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f6928r = r15.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.f6929s = r15.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList r18 = r15.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (r18 == null) goto L11;
        this.f6917g = r18;
        this.f6919i = true;
    L11:
        PorterDuff.Mode r19 = DrawableUtils.parseTintMode(r15.getInt(androidx.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f6918h == r19) goto L15;
        this.f6918h = r19;
        this.f6920j = true;
    L15:
        if (this.f6919i == false) goto L17;
    L18:
        c();
    L19:
        ColorStateList r20 = r15.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_trackTint);
        if (r20 == null) goto L22;
        this.f6922l = r20;
        this.f6924n = true;
    L22:
        PorterDuff.Mode r21 = DrawableUtils.parseTintMode(r15.getInt(androidx.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f6923m == r21) goto L26;
        this.f6923m = r21;
        this.f6925o = true;
    L26:
        if (this.f6924n == false) goto L28;
    L29:
        d();
    L30:
        int r22 = r15.getResourceId(androidx.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (r22 == 0) goto L33;
        j(r10, r22);
    L33:
        r15.recycle();
        if (r10 == null) goto L36;
        ViewConfiguration r23 = ViewConfiguration.get(r10);
        Intrinsics.checkNotNullExpressionValue(r23, "config");
        this.f6934x = r23.getScaledTouchSlop();
        this.B = r23.getScaledMinimumFlingVelocity();
    L37:
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L36:
        this.f6934x = 0;
        this.B = 0;
        goto L37
    L28:
        if (this.f6925o == false) goto L30;
    L17:
        if (this.f6920j == false) goto L19;
        goto L18
    }

    public /* synthetic */ SwitchCompat(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = androidx.appcompat.R.attr.switchStyle;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ int[] a(int[] r10, int[] r11) {
        return View.mergeDrawableStates(r10, r11);
    }

    private final void b(boolean r10) {
        if (r10 == false) goto L5;
        float r11 = 1.0f;
    L6:
        ObjectAnimator r12 = ObjectAnimator.ofFloat(this, f6912a0, new float[]{r11});
        this.Q = r12;
        if (r12 == null) goto L10;
        r12.setDuration(443);
    L10:
        if (Build.VERSION.SDK_INT < 18) goto L14;
        ObjectAnimator r13 = this.Q;
        if (r13 == null) goto L14;
        r13.setAutoCancel(true);
    L14:
        ObjectAnimator r14 = this.Q;
        if (r14 == null) goto L17;
        r14.setInterpolator(this.V);
    L17:
        ObjectAnimator r15 = this.Q;
        if (r15 == null) goto L21;
        r15.start();
        return;
    L21:
        return;
    L5:
        r11 = 0;
        goto L6
    }

    private final void c() {
        Drawable r10 = this.f6916c;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f6919i == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r10);
        Drawable r11 = r10.mutate();
        this.f6916c = r11;
        if (this.f6919i == false) goto L12;
        Intrinsics.checkNotNull(r11);
        DrawableCompat.setTintList(r11, this.f6917g);
    L12:
        if (this.f6920j == false) goto L14;
        Drawable r12 = this.f6916c;
        Intrinsics.checkNotNull(r12);
        PorterDuff.Mode r13 = this.f6918h;
        Intrinsics.checkNotNull(r13);
        DrawableCompat.setTintMode(r12, r13);
    L14:
        Drawable r14 = this.f6916c;
        Intrinsics.checkNotNull(r14);
        if (r14.isStateful() == false) goto L20;
        Drawable r15 = this.f6916c;
        Intrinsics.checkNotNull(r15);
        r15.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f6920j == true) goto L8;
    }

    private final void d() {
        Drawable r10 = this.f6921k;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f6924n == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r10);
        Drawable r11 = r10.mutate();
        this.f6921k = r11;
        if (this.f6924n == false) goto L12;
        Intrinsics.checkNotNull(r11);
        DrawableCompat.setTintList(r11, this.f6922l);
    L12:
        if (this.f6925o == false) goto L14;
        Drawable r12 = this.f6921k;
        Intrinsics.checkNotNull(r12);
        PorterDuff.Mode r13 = this.f6923m;
        Intrinsics.checkNotNull(r13);
        DrawableCompat.setTintMode(r12, r13);
    L14:
        Drawable r14 = this.f6921k;
        Intrinsics.checkNotNull(r14);
        if (r14.isStateful() == false) goto L20;
        Drawable r15 = this.f6921k;
        Intrinsics.checkNotNull(r15);
        r15.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f6925o == true) goto L8;
    }

    private final void e() {
        ObjectAnimator r10 = this.Q;
        if (r10 == null) goto L6;
        Intrinsics.checkNotNull(r10);
        r10.cancel();
        return;
    }

    private final void f(MotionEvent r10) {
        MotionEvent r11 = MotionEvent.obtain(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "cancel");
        r11.setAction(3);
        super.onTouchEvent(r11);
        r11.recycle();
    }

    private final boolean g(float r10, float r11) {
        if (this.f6916c != null) goto L5;
        return false;
    L5:
        int r12 = getThumbOffset();
        Drawable r13 = this.f6916c;
        Intrinsics.checkNotNull(r13);
        r13.getPadding(this.R);
        int r14 = this.I;
        int r15 = this.f6934x;
        int r16 = r14 - r15;
        int r17 = (this.H + r12) - r15;
        int r18 = this.F + r17;
        Rect r19 = this.R;
        int r20 = ((r18 + r19.left) + r19.right) + r15;
        int r21 = this.K + r15;
        if (r10 > r17) goto L8;
        return false;
    L8:
        if (r10 < r20) goto L10;
        return false;
    L10:
        if (r11 > r16) goto L12;
        return false;
    L12:
        if (r11 >= r21) goto L18;
        return true;
    L18:
        return false;
    }

    private final boolean getTargetCheckedState() {
        if (this.W <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getThumbOffset() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        float r10 = 1 - this.C;
    L7:
        return (int) ((r10 * getThumbScrollRange()) + 0.5f);
    L5:
        r10 = this.C;
        goto L7
    }

    private final int getThumbScrollRange() {
        Drawable r10 = this.f6921k;
        if (r10 == null) goto L9;
        Rect r11 = this.R;
        Intrinsics.checkNotNull(r10);
        r10.getPadding(r11);
        Drawable r12 = this.f6916c;
        if (r12 == null) goto L7;
        Rect r13 = DrawableUtils.getOpticalBounds(r12);
        String r14 = "DrawableUtils.getOpticalBounds(mThumbDrawable)";
    L8:
        Intrinsics.checkNotNullExpressionValue(r13, r14);
        return ((((((this.D - this.F) - r11.left) - r11.right) - r13.left) - r13.right) - this.T) - this.S;
    L7:
        r13 = DrawableUtils.INSETS_NONE;
        r14 = "DrawableUtils.INSETS_NONE";
        goto L8
    L9:
        return 0;
    }

    private final Layout h(CharSequence r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        TransformationMethod r11 = this.P;
        if (r11 == null) goto L8;
        Intrinsics.checkNotNull(r11);
        r10 = r11.getTransformation(r10, this);
    L8:
        CharSequence r12 = r10;
        TextPaint r13 = this.L;
        if (r12 == null) goto L11;
        int r14 = (int) Math.ceil(Layout.getDesiredWidth(r12, r13));
    L13:
        return new StaticLayout(r12, r13, r14, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    L11:
        r14 = 0;
        goto L13
    }

    private final void l(int r10, int r11) {
        if (r10 != 1) goto L5;
        Typeface r12 = Typeface.SANS_SERIF;
    L12:
        k(r12, r11);
        return;
    L5:
        if (r10 != 2) goto L7;
        r12 = Typeface.SERIF;
        goto L12
    L7:
        if (r10 == 3) goto L9;
        r12 = null;
        goto L12
    L9:
        r12 = Typeface.MONOSPACE;
        goto L12
    }

    private final void m(MotionEvent r10) {
        this.f6933w = 0;
        boolean r11 = true;
        if (r10.getAction() == 1) goto L5;
    L7:
        boolean r12 = false;
    L8:
        boolean r13 = isChecked();
        if (r12 == false) goto L22;
        this.A.computeCurrentVelocity(1000);
        VelocityTracker r14 = this.A;
        Intrinsics.checkNotNullExpressionValue(r14, "mVelocityTracker");
        float r15 = r14.getXVelocity();
        if (Math.abs(r15) > this.B) goto L13;
        r11 = getTargetCheckedState();
    L23:
        if (r11 == r13) goto L25;
        playSoundEffect(0);
    L25:
        setChecked(r11);
        f(r10);
        return;
    L13:
        if (ViewUtils.isLayoutRtl(this) == false) goto L18;
        if (r15 < 0) goto L23;
    L20:
        r11 = false;
        goto L23
    L18:
        if (r15 <= 0) goto L20;
    L22:
        r11 = r13;
        goto L23
    L5:
        if (isEnabled() == false) goto L7;
        r12 = true;
        goto L8
    }

    @Override // android.view.View
    public void draw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "c");
        Rect r10 = this.R;
        int r12 = this.H;
        int r13 = this.I;
        int r14 = this.f6915J;
        int r15 = this.K;
        int r16 = getThumbOffset() + r12;
        Drawable r17 = this.f6916c;
        if (r17 == null) goto L5;
        Rect r18 = DrawableUtils.getOpticalBounds(r17);
    L6:
        Drawable r19 = this.f6921k;
        if (r19 == null) goto L26;
        Intrinsics.checkNotNull(r19);
        r19.getPadding(r10);
        int r20 = r10.left;
        r16 = r16 + r20;
        if (r18 == null) goto L23;
        int r21 = r18.left;
        if (r21 <= r20) goto L13;
        r12 = r12 + (r21 - r20);
    L13:
        int r22 = r18.top;
        int r23 = r10.top;
        if (r22 <= r23) goto L16;
        int r24 = (r22 - r23) + r13;
    L17:
        int r25 = r18.right;
        int r26 = r10.right;
        if (r25 <= r26) goto L20;
        r14 = r14 - (r25 - r26);
    L20:
        int r27 = r18.bottom;
        int r28 = r10.bottom;
        if (r27 <= r28) goto L24;
        int r29 = r15 - (r27 - r28);
    L25:
        Drawable r30 = this.f6921k;
        Intrinsics.checkNotNull(r30);
        r30.setBounds(r12, r24, r14, r29);
    L24:
        r29 = r15;
        goto L25
    L16:
        r24 = r13;
        goto L17
    L23:
        r24 = r13;
    L26:
        Drawable r31 = this.f6916c;
        if (r31 == null) goto L31;
        Intrinsics.checkNotNull(r31);
        r31.getPadding(r10);
        int r32 = r16 - r10.left;
        int r33 = this.S;
        int r34 = r32 + r33;
        int r35 = ((r16 + this.F) + r10.right) + r33;
        int r36 = ((r15 - r13) - this.G) / 2;
        Drawable r37 = this.f6916c;
        Intrinsics.checkNotNull(r37);
        r37.setBounds(r34, r36, r35, this.G + r36);
        Drawable r38 = getBackground();
        if (r38 == null) goto L31;
        DrawableCompat.setHotspotBounds(r38, r34, r13, r35, r15);
    L31:
        super.draw(r11);
        return;
    L5:
        r18 = DrawableUtils.INSETS_NONE;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float r10, float r11) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        super.drawableHotspotChanged(r10, r11);
    L5:
        Drawable r12 = this.f6916c;
        if (r12 == null) goto L8;
        Intrinsics.checkNotNull(r12);
        DrawableCompat.setHotspot(r12, r10, r11);
    L8:
        Drawable r13 = this.f6921k;
        if (r13 == null) goto L12;
        Intrinsics.checkNotNull(r13);
        DrawableCompat.setHotspot(r13, r10, r11);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r10 = getDrawableState();
        Drawable r11 = this.f6916c;
        boolean r12 = false;
        if (r11 != null) goto L5;
    L7:
        Drawable r13 = this.f6921k;
        if (r13 != null) goto L10;
    L12:
        if (r12 == false) goto L15;
        invalidate();
        return;
    L15:
        return;
    L10:
        if (r13.isStateful() == false) goto L12;
        r12 = r12 | r13.setState(r10);
        goto L12
    L5:
        if (r11.isStateful() == false) goto L7;
        r12 = false | r11.setState(r10);
        goto L7
    }

    public final boolean getAutoCheck() {
        return this.U;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        int r10 = super.getCompoundPaddingLeft() + this.D;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r10;
    L9:
        return r10 + this.f6928r;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this) == true) goto L5;
        int r10 = super.getCompoundPaddingRight() + this.D;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r10;
    L9:
        return r10 + this.f6928r;
    L5:
        return super.getCompoundPaddingRight();
    }

    public final ObjectAnimator getMPositionAnimator() {
        return this.Q;
    }

    public final float getMThumbPosition() {
        return this.C;
    }

    public final boolean getShowText() {
        return this.f6932v;
    }

    public final boolean getSplitTrack() {
        return this.f6929s;
    }

    public final int getSwitchMinWidth() {
        return this.f6927q;
    }

    public final int getSwitchPadding() {
        return this.f6928r;
    }

    public final CharSequence getTextOff() {
        return this.f6931u;
    }

    public final CharSequence getTextOn() {
        return this.f6930t;
    }

    public final int getThumbConstraintLeft() {
        return this.S;
    }

    public final int getThumbConstraintRight() {
        return this.T;
    }

    public final Drawable getThumbDrawable() {
        return this.f6916c;
    }

    public final int getThumbTextPadding() {
        return this.f6926p;
    }

    public final ColorStateList getThumbTintList() {
        return this.f6917g;
    }

    public final PorterDuff.Mode getThumbTintMode() {
        return this.f6918h;
    }

    public final Drawable getTrackDrawable() {
        return this.f6921k;
    }

    public final ColorStateList getTrackTintList() {
        return this.f6922l;
    }

    public final PorterDuff.Mode getTrackTintMode() {
        return this.f6923m;
    }

    public void i(boolean r10) {
        Context r11 = getContext();
        if (r10 == false) goto L5;
        int r12 = 4;
    L6:
        q9.a.b(r11, r12);
        return;
    L5:
        r12 = 5;
        goto L6
    }

    public final void j(Context r10, int r11) {
        TintTypedArray r12 = TintTypedArray.obtainStyledAttributes(r10, r11, androidx.appcompat.R.styleable.TextAppearance);
        ColorStateList r13 = r12.getColorStateList(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
        if (r13 != null) goto L6;
        r13 = getTextColors();
    L6:
        this.M = r13;
        int r14 = r12.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
        if (r14 == 0) goto L11;
        float r15 = r14;
        if (r15 == this.L.getTextSize()) goto L11;
        this.L.setTextSize(r15);
        requestLayout();
    L11:
        l(r12.getInt(androidx.appcompat.R.styleable.TextAppearance_android_typeface, -1), r12.getInt(androidx.appcompat.R.styleable.TextAppearance_android_textStyle, -1));
        if (r12.getBoolean(androidx.appcompat.R.styleable.TextAppearance_textAllCaps, false) == false) goto L14;
        AllCapsTransformationMethod r16 = new AllCapsTransformationMethod(getContext());
    L15:
        this.P = r16;
        r12.recycle();
        return;
    L14:
        r16 = null;
        goto L15
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r10 = this.f6916c;
        if (r10 == null) goto L5;
        Intrinsics.checkNotNull(r10);
        r10.jumpToCurrentState();
    L5:
        Drawable r11 = this.f6921k;
        if (r11 == null) goto L8;
        Intrinsics.checkNotNull(r11);
        r11.jumpToCurrentState();
    L8:
        ObjectAnimator r12 = this.Q;
        if (r12 == null) goto L14;
        Intrinsics.checkNotNull(r12);
        if (r12.isStarted() == false) goto L15;
        ObjectAnimator r13 = this.Q;
        Intrinsics.checkNotNull(r13);
        r13.end();
        this.Q = null;
        return;
    L15:
        return;
    }

    public final void k(Typeface r10, int r11) {
        float r12 = 0.0f;
        boolean r13 = false;
        if (r11 <= 0) goto L18;
        if (r10 != null) goto L6;
        Typeface r14 = Typeface.defaultFromStyle(r11);
    L7:
        setSwitchTypeface(r14);
        if (r14 == null) goto L10;
        int r15 = r14.getStyle();
    L11:
        int r16 = (~r15) & r11;
        TextPaint r17 = this.L;
        if ((r16 & 1) == 0) goto L14;
        r13 = true;
    L14:
        r17.setFakeBoldText(r13);
        TextPaint r18 = this.L;
        if ((r16 & 2) == 0) goto L17;
        r12 = -0.25f;
    L17:
        r18.setTextSkewX(r12);
        return;
    L10:
        r15 = 0;
        goto L11
    L6:
        r14 = Typeface.create(r10, r11);
        goto L7
    L18:
        this.L.setFakeBoldText(false);
        this.L.setTextSkewX(0.0f);
        setSwitchTypeface(r10);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 1);
        if (isChecked() == false) goto L5;
        a(r11, f6913b0);
    L5:
        Intrinsics.checkNotNullExpressionValue(r11, "drawableState");
        return r11;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        Rect r11 = this.R;
        Drawable r12 = this.f6921k;
        if (r12 == null) goto L5;
        r12.getPadding(r11);
    L6:
        int r13 = this.I;
        int r14 = this.K;
        int r15 = r13 + r11.top;
        int r16 = r14 - r11.bottom;
        Drawable r17 = this.f6916c;
        if (r12 != null) goto L9;
    L13:
        int r18 = r10.save();
        if (r17 == null) goto L17;
        r17.draw(r10);
    L17:
        if (getTargetCheckedState() == false) goto L19;
        Layout r19 = this.N;
    L20:
        if (r19 == null) goto L29;
        int[] r20 = getDrawableState();
        ColorStateList r21 = this.M;
        if (r21 == null) goto L24;
        TextPaint r22 = this.L;
        Intrinsics.checkNotNull(r21);
        r22.setColor(r21.getColorForState(r20, 0));
    L24:
        this.L.drawableState = r20;
        if (r17 == null) goto L27;
        Rect r23 = r17.getBounds();
        Intrinsics.checkNotNullExpressionValue(r23, "thumbDrawable.bounds");
        int r24 = r23.left + r23.right;
    L28:
        r10.translate((r24 / 2) - (r19.getWidth() / 2), ((r15 + r16) / 2) - (r19.getHeight() / 2));
        r19.draw(r10);
        goto L29
    L27:
        r24 = getWidth();
    L29:
        r10.restoreToCount(r18);
        return;
    L19:
        r19 = this.O;
        goto L20
    L9:
        if (this.f6929s == false) goto L12;
        if (r17 == null) goto L12;
        Rect r25 = DrawableUtils.getOpticalBounds(r17);
        r17.copyBounds(r11);
        r11.left += r25.left;
        r11.right -= r25.right;
        int r26 = r10.save();
        r10.clipRect(r11, Region.Op.DIFFERENCE);
        r12.draw(r10);
        r10.restoreToCount(r26);
    L12:
        r12.draw(r10);
        goto L13
    L5:
        r11.setEmpty();
        goto L6
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
        Intrinsics.checkNotNullParameter(r10, "info");
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName("android.widget.Switch");
        if (isChecked() == false) goto L5;
        CharSequence r11 = this.f6930t;
    L7:
        if (TextUtils.isEmpty(r11) == true) goto L13;
        CharSequence r12 = r10.getText();
        if (TextUtils.isEmpty(r12) == false) goto L11;
        r10.setText(r11);
        return;
    L11:
        StringBuilder r13 = new StringBuilder();
        r13.append(r12);
        r13.append(' ');
        r13.append(r11);
        r10.setText(r13);
        return;
    L13:
        return;
    L5:
        r11 = this.f6931u;
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        int r15 = 0;
        if (this.f6916c == null) goto L9;
        Rect r16 = this.R;
        Drawable r17 = this.f6921k;
        if (r17 == null) goto L7;
        Intrinsics.checkNotNull(r17);
        r17.getPadding(r16);
    L8:
        Rect r18 = DrawableUtils.getOpticalBounds(this.f6916c);
        int r19 = Math.max(0, r18.left - r16.left);
        r15 = Math.max(0, r18.right - r16.right);
    L11:
        if (ViewUtils.isLayoutRtl(this) == false) goto L13;
        int r20 = getPaddingLeft() + r19;
        int r21 = ((this.D + r20) - r19) - r15;
    L14:
        int r22 = getGravity() & 112;
        if (r22 != 16) goto L17;
        int r23 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r24 = this.E;
        int r25 = r23 - (r24 / 2);
    L24:
        int r26 = r24 + r25;
    L25:
        this.H = r20;
        this.I = r25;
        this.K = r26;
        this.f6915J = r21;
        return;
    L17:
        if (r22 != 48) goto L19;
    L22:
        r25 = getPaddingTop();
        r24 = this.E;
        goto L24
    L19:
        if (r22 != 80) goto L22;
        r26 = getHeight() - getPaddingBottom();
        r25 = r26 - this.E;
        goto L25
    L13:
        r21 = (getWidth() - getPaddingRight()) - r15;
        r20 = ((r21 - this.D) + r19) + r15;
        goto L14
    L7:
        r16.setEmpty();
        goto L8
    L9:
        r19 = 0;
        goto L11
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.f6932v == true) goto L5;
    L10:
        Rect r12 = this.R;
        Drawable r13 = this.f6916c;
        int r14 = 0;
        if (r13 == null) goto L13;
        Intrinsics.checkNotNull(r13);
        r13.getPadding(r12);
        Drawable r15 = this.f6916c;
        Intrinsics.checkNotNull(r15);
        int r16 = (r15.getIntrinsicWidth() - r12.left) - r12.right;
        Drawable r17 = this.f6916c;
        Intrinsics.checkNotNull(r17);
        int r18 = r17.getIntrinsicHeight();
    L15:
        if (this.f6932v == false) goto L25;
        Layout r19 = this.N;
        if (r19 == null) goto L19;
        int r20 = r19.getWidth();
    L20:
        Layout r21 = this.O;
        if (r21 == null) goto L23;
        int r22 = r21.getWidth();
    L24:
        int r23 = Math.max(r20, r22) + (this.f6926p * 2);
    L26:
        this.F = Math.max(r23, r16);
        this.G = r18;
        Drawable r24 = this.f6921k;
        if (r24 == null) goto L29;
        Intrinsics.checkNotNull(r24);
        r24.getPadding(r12);
        Drawable r25 = this.f6921k;
        Intrinsics.checkNotNull(r25);
        r14 = r25.getIntrinsicHeight();
    L30:
        int r26 = r12.left;
        int r27 = r12.right;
        Drawable r28 = this.f6916c;
        if (r28 == null) goto L33;
        Rect r29 = DrawableUtils.getOpticalBounds(r28);
        r26 = Math.max(r26, r29.left);
        r27 = Math.max(r27, r29.right);
    L33:
        int r30 = Math.max(this.f6927q, ((this.F * 2) + r26) + r27);
        int r31 = Math.max(r14, r18);
        Resources r32 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r32, "Resources.getSystem()");
        this.D = r30 - MathKt.roundToInt(TypedValue.applyDimension(1, 4, r32.getDisplayMetrics()));
        this.E = r31;
        super.onMeasure(r10, r11);
        if (getMeasuredHeight() >= r31) goto L37;
        setMeasuredDimension(getMeasuredWidthAndState(), r31);
        return;
    L37:
        return;
    L29:
        r12.setEmpty();
        goto L30
    L23:
        r22 = 0;
        goto L24
    L19:
        r20 = 0;
        goto L20
    L25:
        r23 = 0;
        goto L26
    L13:
        r16 = 0;
        r18 = 0;
        goto L15
    L5:
        if (this.N != null) goto L8;
        this.N = h(this.f6930t);
    L8:
        if (this.O != null) goto L10;
        this.O = h(this.f6931u);
        goto L10
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        super.onPopulateAccessibilityEvent(r10);
        if (isChecked() == false) goto L5;
        CharSequence r11 = this.f6930t;
    L6:
        if (r11 == null) goto L9;
        r10.getText().add(r11);
        return;
    L9:
        return;
    L5:
        r11 = this.f6931u;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        this.A.addMovement(r10);
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L5;
        float r12 = r10.getX();
        float r13 = r10.getY();
        if (isEnabled() == true) goto L42;
    L45:
        return super.onTouchEvent(r10);
    L42:
        if (g(r12, r13) == false) goto L45;
        this.f6933w = 1;
        this.f6935y = r12;
        this.f6936z = r13;
        goto L45
    L5:
        if (r11 == 1) goto L35;
        if (r11 != 2) goto L8;
        int r14 = this.f6933w;
        if (r14 == 1) goto L28;
        if (r14 != 2) goto L45;
        float r15 = r10.getX();
        int r16 = getThumbScrollRange();
        float r17 = r15 - this.f6935y;
        if (r16 == 0) goto L18;
        float r18 = r17 / r16;
    L22:
        if (ViewUtils.isLayoutRtl(this) == false) goto L24;
        r18 = -r18;
    L24:
        float r19 = b.a(f6914c0, this.W + r18, 0.0f, 1.0f);
        if (r19 == this.W) goto L27;
        this.f6935y = r15;
        this.W = r19;
    L27:
        return true;
    L18:
        if (r17 <= 0) goto L20;
        r18 = 1.0f;
        goto L22
    L20:
        r18 = -1.0f;
        goto L22
    L28:
        float r20 = r10.getX();
        float r21 = r10.getY();
        if (Math.abs(r20 - this.f6935y) <= this.f6934x) goto L31;
    L32:
        this.f6933w = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f6935y = r20;
        this.f6936z = r21;
        return true;
    L31:
        if (Math.abs(r21 - this.f6936z) <= this.f6934x) goto L45;
    L8:
        if (r11 != 3) goto L45;
    L35:
        if (this.f6933w != 2) goto L38;
        m(r10);
        super.onTouchEvent(r10);
        return true;
    L38:
        this.f6933w = 0;
        this.A.clear();
        goto L45
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        boolean r10 = super.performClick();
        if (isHapticFeedbackEnabled() == false) goto L5;
        i(isChecked());
    L5:
        return r10;
    }

    public final void setAutoCheck(boolean r10) {
        this.U = r10;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r10) {
        super.setChecked(r10);
        boolean r11 = isChecked();
        if (getWindowToken() != null) goto L5;
    L7:
        e();
        if (r11 == false) goto L10;
        float r12 = 1.0f;
    L11:
        setThumbPosition(r12);
        return;
    L10:
        r12 = 0;
        goto L11
    L5:
        if (ViewCompat.isLaidOut(this) == false) goto L7;
        b(r11);
    }

    @CallSuper
    public void setCheckedNoAnim(boolean r10) {
        super.setChecked(r10);
        e();
        if (isChecked() == false) goto L5;
        float r11 = 1.0f;
    L6:
        setThumbPosition(r11);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r10) {
        Intrinsics.checkNotNullParameter(r10, "actionModeCallback");
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r10));
    }

    public final void setMPositionAnimator(ObjectAnimator r10) {
        this.Q = r10;
    }

    public final void setMThumbPosition(float r10) {
        this.C = r10;
    }

    public final void setShowText(boolean r10) {
    }

    public final void setSplitTrack(boolean r10) {
        this.f6929s = r10;
        invalidate();
    }

    public final void setSwitchMinWidth(int r10) {
        this.f6927q = r10;
        requestLayout();
    }

    public final void setSwitchPadding(int r10) {
        this.f6928r = r10;
        requestLayout();
    }

    public final void setSwitchTypeface(Typeface r10) {
        if (this.L.getTypeface() == null) goto L7;
        if ((!Intrinsics.areEqual(this.L.getTypeface(), r10)) == false) goto L7;
    L9:
        this.L.setTypeface(r10);
        requestLayout();
        invalidate();
        return;
    L7:
        if (this.L.getTypeface() != null) goto L11;
        if (r10 != null) goto L9;
        return;
    }

    public final void setTextOff(CharSequence r10) {
        this.f6931u = r10;
        requestLayout();
    }

    public final void setTextOn(CharSequence r10) {
        this.f6930t = r10;
        requestLayout();
    }

    public final void setThumbConstraintLeft(int r10) {
        this.S = r10;
    }

    public final void setThumbConstraintRight(int r10) {
        this.T = r10;
    }

    public final void setThumbDrawable(Drawable r10) {
        Drawable r11 = this.f6916c;
        if (r11 == null) goto L5;
        Intrinsics.checkNotNull(r11);
        r11.setCallback(null);
    L5:
        this.f6916c = r10;
        if (r10 == null) goto L8;
        r10.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setThumbPosition(float r10) {
        this.C = r10;
        invalidate();
    }

    public final void setThumbResource(int r10) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r10));
    }

    public final void setThumbTextPadding(int r10) {
        this.f6926p = r10;
        requestLayout();
    }

    public final void setThumbTintList(ColorStateList r10) {
        this.f6917g = r10;
        this.f6919i = true;
        c();
    }

    public final void setThumbTintMode(PorterDuff.Mode r10) {
        this.f6918h = r10;
        this.f6920j = true;
        c();
    }

    public final void setTrackDrawable(Drawable r10) {
        Drawable r11 = this.f6921k;
        if (r11 == null) goto L5;
        Intrinsics.checkNotNull(r11);
        r11.setCallback(null);
    L5:
        this.f6921k = r10;
        if (r10 == null) goto L8;
        r10.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setTrackResource(int r10) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), r10));
    }

    public final void setTrackTintList(ColorStateList r10) {
        this.f6922l = r10;
        this.f6924n = true;
        d();
    }

    public final void setTrackTintMode(PorterDuff.Mode r10) {
        this.f6923m = r10;
        this.f6925o = true;
        d();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        if (this.U == false) goto L6;
        setChecked(!isChecked());
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable r10) {
        Intrinsics.checkNotNullParameter(r10, "who");
        if (super.verifyDrawable(r10) == false) goto L5;
    L10:
        return true;
    L5:
        if (r10 == this.f6916c) goto L10;
        if (r10 == this.f6921k) goto L10;
        return false;
    }
}
