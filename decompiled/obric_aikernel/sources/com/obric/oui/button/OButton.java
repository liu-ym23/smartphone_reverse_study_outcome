package com.obric.oui.button;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.entity.EventBody;
import da.f;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import o9.b;
import o9.g;
import o9.j;
import o9.k;
import o9.n;
import o9.p;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\\B9\b\u0007\u0012\u0006\u0010S\u001a\u00020R\u0012\b\u0010U\u001a\u0004\u0018\u00010T\u0012\b\b\u0002\u0010V\u001a\u00020\t\u0012\b\b\u0002\u0010W\u001a\u00020\t\u0012\b\b\u0002\u0010Y\u001a\u00020X¢\u0006\u0004\bZ\u0010[J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0011\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\tH\u0096\u0001J\t\u0010\u001f\u001a\u00020\tH\u0096\u0001J\t\u0010 \u001a\u00020\u0011H\u0096\u0001J\t\u0010!\u001a\u00020\tH\u0096\u0001J\t\u0010\"\u001a\u00020\tH\u0096\u0001J\u0013\u0010$\u001a\u00020\u00072\b\b\u0001\u0010#\u001a\u00020\tH\u0096\u0001J\u0011\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\tH\u0096\u0001J\u0011\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\tH\u0096\u0001J\u0011\u0010)\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\tH\u0096\u0001J\u0011\u0010*\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\tH\u0096\u0001J\u0011\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\tH\u0096\u0001J\u0011\u0010/\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\tH\u0096\u0001J\u0011\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0011H\u0096\u0001J\u0011\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u00020\tH\u0096\u0001J\u0011\u00104\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\tH\u0096\u0001J\u0011\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u00020\tH\u0096\u0001J\u0013\u00108\u001a\u00020\u00072\b\b\u0001\u00107\u001a\u00020\tH\u0096\u0001J\u0011\u0010:\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010;\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\tH\u0096\u0001J\u0011\u0010=\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\tH\u0096\u0001J\t\u0010>\u001a\u00020\u0002H\u0096\u0001J\t\u0010@\u001a\u00020?H\u0096\u0001J\t\u0010A\u001a\u00020\u0003H\u0096\u0001R*\u0010I\u001a\u00020\t2\u0006\u0010B\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR.\u0010Q\u001a\u0004\u0018\u00010J2\b\u0010B\u001a\u0004\u0018\u00010J8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006]"}, d2 = {"Lcom/obric/oui/button/OButton;", "Landroid/widget/Button;", "Lo9/a;", "Lo9/b;", "", "", "pressed", "", "setPressState", "", "resId", "setButtonSourceBitmap", "selected", "setSelected", "enabled", "setEnabled", "setPressed", "", "alpha", "setDisabledTextAlpha", TypedValues.Custom.S_COLOR, "setTextColor", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "setOverridePressColor", "getRadius", "getShadowAlpha", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "minWidth", "setWidthMin", "getAlphaHelper", "Lo9/j;", "getEffectHelper", "getLayoutHelper", EventBody.KEY_VALUE, "j", "I", "getMImageTintColorId", "()I", "setMImageTintColorId", "(I)V", "mImageTintColorId", "Landroid/graphics/drawable/Drawable;", "h", "Landroid/graphics/drawable/Drawable;", "getMIcon", "()Landroid/graphics/drawable/Drawable;", "setMIcon", "(Landroid/graphics/drawable/Drawable;)V", "mIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "Lo9/n;", "provider", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILo9/n;)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
@SuppressLint({"AppCompatCustomView"})
public class OButton extends Button implements o9.a, b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f6247c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private j f6248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Drawable f6249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6250i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6251j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f6252k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f6253l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f6254m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f6255n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f6256o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f6257p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f6258q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final /* synthetic */ o9.a f6259r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final /* synthetic */ b f6260s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final /* synthetic */ n f6261t;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    @JvmOverloads
    public OButton(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 0, null, 28, null);
    }

    @JvmOverloads
    public OButton(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 0, null, 24, null);
    }

    @JvmOverloads
    public OButton(Context r10, AttributeSet r11, int r12, int r13, n r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r14, "provider");
        super(r10, r11, r12);
        this.f6259r = r14.a();
        this.f6260s = r14.c();
        this.f6261t = r14;
        this.f6257p = 1.0f;
        b r15 = r14.c();
        Objects.requireNonNull(r15, "null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
        ((k) r15).H(true);
        r14.d(this);
        b r16 = getLayoutHelper();
        Objects.requireNonNull(r16, "null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
        k r17 = (k) r16;
        o9.a r18 = getAlphaHelper();
        Objects.requireNonNull(r18, "null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
        this.f6247c = (g) r18;
        this.f6248g = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        d(r10, r11);
    }

    public /* synthetic */ OButton(Context r10, AttributeSet r11, int r12, int r13, n r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 4) == 0) goto L5;
        int r17 = 0;
    L7:
        if ((r15 & 8) == 0) goto L9;
        int r18 = 0;
    L11:
        if ((r15 & 16) == 0) goto L13;
        r14 = new n(r10, r11, r17, r18);
    L13:
        this(r10, r11, r17, r18, r14);
        return;
    L9:
        r18 = r13;
        goto L11
    L5:
        r17 = r12;
        goto L7
    }

    private final void a(boolean r10) {
        int r11 = getPaddingTop();
        int r12 = getPaddingRight();
        int r13 = getPaddingBottom();
        if (r10 == false) goto L5;
        int r14 = getPaddingRight() - this.f6256o;
    L7:
        if (r14 == getPaddingLeft()) goto L10;
        setPadding(r14, r11, r12, r13);
        return;
    L10:
        return;
    L5:
        r14 = getPaddingRight();
        goto L7
    }

    private final float c(float r10) {
        return 1 - (r10 * 0.7f);
    }

    private final void d(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, l.OButton);
        Intrinsics.checkNotNullExpressionValue(r12, "context.obtainStyledAttr…trs, R.styleable.OButton)");
        this.f6250i = r12.getResourceId(l.OButton_icon, -1);
        setMImageTintColorId(r12.getResourceId(l.OButton_iconTint, -1));
        int r13 = this.f6250i;
        if (r13 < 0) goto L5;
        setButtonSourceBitmap(r13);
    L5:
        setTextAppearance(r12.getResourceId(l.OButton_oui_buttonTextStyle, u8.k.Title_Title_M_Thick));
        this.f6255n = r12.getBoolean(l.OButton_oui_buttonChangeAlphaWhenPressed, false);
        int r14 = getCurrentTextColor();
        this.f6253l = r14;
        ColorStateList r15 = ColorStateList.valueOf(r14);
        Intrinsics.checkNotNullExpressionValue(r15, "ColorStateList.valueOf(textColor)");
        setCompoundDrawableTintList(r15);
        this.f6256o = r12.getDimensionPixelSize(l.OButton_oui_widgetPaddingOffset, 0);
        Drawable[] r16 = getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(r16, "getCompoundDrawables()");
        if (((Drawable) ArraysKt.getOrNull(r16, 0)) == null) goto L8;
        a(true);
    L8:
        this.f6257p = r12.getFloat(l.OButton_oui_widgetDisableAlpha, 1.0f);
        r12.recycle();
        e(isEnabled());
    }

    private final void e(boolean r10) {
        int r11 = this.f6253l;
        if (r11 != 0) goto L5;
        return;
    L5:
        int r12 = 0;
        if (r10 == true) goto L12;
        int r13 = f.a(r11, this.f6257p);
        this.f6258q = true;
        super.setTextColor(r13);
        this.f6258q = false;
        Drawable[] r14 = getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(r14, "compoundDrawables");
        int r15 = r14.length;
    L8:
        if (r12 >= r15) goto L17;
        Drawable r16 = r14[r12];
        r12 = r12 + 1;
        if (r16 == null) goto L8;
        r16.setAlpha((int) (this.f6257p * 255));
    L17:
        invalidate();
        return;
    L12:
        this.f6258q = true;
        super.setTextColor(r11);
        this.f6258q = false;
        Drawable[] r17 = getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(r17, "compoundDrawables");
        int r18 = r17.length;
    L13:
        if (r12 >= r18) goto L17;
        Drawable r19 = r17[r12];
        r12 = r12 + 1;
        if (r19 == null) goto L13;
        r19.setAlpha((int) 255.0f);
        goto L13
    }

    private final void f(float r10) {
        int r11 = this.f6254m;
        if (r11 != 0) goto L5;
        return;
    L5:
        int r12 = RangesKt.coerceIn((int) (r11 * c(r10)), 0, 255);
        Drawable r13 = this.f6249h;
        if (r13 == null) goto L8;
        r13.setAlpha(r12);
    L8:
        ea.b.a("OButton", "updateIconAlphaOnPress, fraction: " + r10 + ", alpha: " + r12 + ", originIconAlpha: " + this.f6254m);
    }

    private final void g(float r10) {
        int r11 = this.f6253l;
        if (r11 != 0) goto L5;
        return;
    L5:
        int r12 = (r11 >> 24) & 255;
        int r13 = RangesKt.coerceIn((int) (r12 * c(r10)), 0, 255);
        int r14 = ((r11 >> 16) & 255) << 16;
        setTextColor((r11 & 255) | ((r14 | (r13 << 24)) | (((r11 >> 8) & 255) << 8)));
        ea.b.a("OButton", "updateTextColorOnPress, fraction: " + r10 + ", newTextAlpha: " + r13 + ", originTextAlpha: " + r12);
    }

    private final void setPressState(boolean r10) {
        if (this.f6252k != r10) goto L6;
        ea.b.j("OButton", "setPressState, already set, skip! pressed: " + r10);
        return;
    L6:
        this.f6252k = r10;
        j r11 = this.f6248g;
        if (r11 == null) goto L9;
        r11.u(r10);
    L9:
        g r12 = this.f6247c;
        if (r12 == null) goto L13;
        r12.onPressedChanged(this, r10);
        return;
    }

    public final void b(Canvas r10) {
        if (r10 == null) goto L10;
        Drawable r11 = this.f6249h;
        if (r11 == null) goto L11;
        int r12 = (getWidth() - r11.getIntrinsicWidth()) / 2;
        int r13 = (getHeight() - r11.getIntrinsicHeight()) / 2;
        r11.setBounds(r12, r13, r11.getIntrinsicWidth() + r12, r11.getIntrinsicHeight() + r13);
        if (this.f6251j <= 0) goto L8;
        r11.setColorFilter(new PorterDuffColorFilter(getResources().getColor(this.f6251j), PorterDuff.Mode.SRC_IN));
    L8:
        r11.draw(r10);
        return;
    L11:
        return;
    }

    @Override // o9.b
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.f6260s.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // o9.a
    public void disablePressReleaseAnim(boolean r10) {
        this.f6259r.disablePressReleaseAnim(r10);
    }

    public o9.a getAlphaHelper() {
        return this.f6261t.a();
    }

    public j getEffectHelper() {
        return this.f6261t.b();
    }

    public b getLayoutHelper() {
        return this.f6261t.c();
    }

    public final Drawable getMIcon() {
        return this.f6249h;
    }

    public final int getMImageTintColorId() {
        return this.f6251j;
    }

    @Override // o9.b
    public int getRadius() {
        return this.f6260s.getRadius();
    }

    @Override // o9.b
    public float getShadowAlpha() {
        return this.f6260s.getShadowAlpha();
    }

    @Override // android.widget.TextView, o9.b
    public int getShadowColor() {
        return this.f6260s.getShadowColor();
    }

    @Override // o9.b
    public int getShadowElevation() {
        return this.f6260s.getShadowElevation();
    }

    @Override // o9.a
    public void handleTouchEvent(MotionEvent r10) {
        this.f6259r.handleTouchEvent(r10);
    }

    @Override // o9.b
    public boolean hasBorder() {
        return this.f6260s.hasBorder();
    }

    @Override // o9.b
    public boolean hasBottomSeparator() {
        return this.f6260s.hasBottomSeparator();
    }

    @Override // o9.b
    public boolean hasLeftSeparator() {
        return this.f6260s.hasLeftSeparator();
    }

    @Override // o9.b
    public boolean hasRightSeparator() {
        return this.f6260s.hasRightSeparator();
    }

    @Override // o9.b
    public boolean hasTopSeparator() {
        return this.f6260s.hasTopSeparator();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        b(r10);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r12 = getMeasuredWidth();
        int r13 = getMeasuredHeight();
        Drawable r14 = this.f6249h;
        if (r14 == null) goto L5;
        r12 = Math.max(r12, (r14.getIntrinsicWidth() + getPaddingLeft()) + getPaddingRight());
        r13 = Math.max(r13, (r14.getIntrinsicHeight() + getPaddingTop()) + getPaddingBottom());
    L5:
        setMeasuredDimension(r12, r13);
    }

    @Override // o9.b
    @RequiresApi(26)
    public void onPressAlphaChange(int r10) {
        if (this.f6255n == true) goto L5;
        return;
    L5:
        float r11 = RangesKt.coerceIn(r10 / 255.0f, 0.0f, 1.0f);
        g(r11);
        f(r11);
    }

    @Override // o9.a
    public void onPressedChanged(View r10, boolean r11) {
        this.f6259r.onPressedChanged(r10, r11);
    }

    @Override // o9.a
    public void onSelectedChanged(View r10, boolean r11) {
        this.f6259r.onSelectedChanged(r10, r11);
    }

    @Override // o9.b
    public void onlyShowBottomDivider(int r10, int r11, int r12, int r13) {
        this.f6260s.onlyShowBottomDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void onlyShowLeftDivider(int r10, int r11, int r12, int r13) {
        this.f6260s.onlyShowLeftDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void onlyShowRightDivider(int r10, int r11, int r12, int r13) {
        this.f6260s.onlyShowRightDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void onlyShowTopDivider(int r10, int r11, int r12, int r13) {
        this.f6260s.onlyShowTopDivider(r10, r11, r12, r13);
    }

    @Override // o9.a
    public void refreshColors(String r10) {
        this.f6259r.refreshColors(r10);
    }

    @Override // o9.a
    public void resetAlphaAnim() {
        this.f6259r.resetAlphaAnim();
    }

    @Override // o9.b
    public void setBorderColor(@ColorInt int r10) {
        this.f6260s.setBorderColor(r10);
    }

    @Override // o9.b
    public void setBorderWidth(int r10) {
        this.f6260s.setBorderWidth(r10);
    }

    @Override // o9.b
    public void setBottomDividerAlpha(int r10) {
        this.f6260s.setBottomDividerAlpha(r10);
    }

    public final void setButtonSourceBitmap(int r10) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        setMIcon(ContextCompat.getDrawable(getContext(), r10));
        Drawable r11 = this.f6249h;
        if (r11 == null) goto L7;
        int r12 = r11.getAlpha();
    L8:
        this.f6254m = r12;
        invalidate();
        return;
    L7:
        r12 = 0;
        goto L8
    }

    @Override // o9.a
    public void setChangeAlphaWhenDisable(boolean r10) {
        this.f6259r.setChangeAlphaWhenDisable(r10);
    }

    @Override // o9.a
    public void setChangeAlphaWhenPress(boolean r10) {
        this.f6259r.setChangeAlphaWhenPress(r10);
    }

    @Override // o9.a
    public void setChangeAlphaWhenSelected(boolean r10) {
        this.f6259r.setChangeAlphaWhenSelected(r10);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
        super.setCompoundDrawables(r10, r11, r12, r13);
        if (r10 == null) goto L5;
        boolean r14 = true;
    L6:
        a(r14);
        return;
    L5:
        r14 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
        super.setCompoundDrawablesRelative(r10, r11, r12, r13);
        if (r10 == null) goto L5;
        boolean r14 = true;
    L6:
        a(r14);
        return;
    L5:
        r14 = false;
        goto L6
    }

    public final void setDisabledTextAlpha(float r10) {
        this.f6257p = r10;
        if (isEnabled() == true) goto L6;
        e(false);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        g r11 = this.f6247c;
        if (r11 == null) goto L5;
        r11.n(this, r10);
    L5:
        e(r10);
    }

    @Override // o9.b
    public boolean setHeightLimit(int r10) {
        return this.f6260s.setHeightLimit(r10);
    }

    @Override // o9.a
    public void setKeepPressAlpha(boolean r10) {
        this.f6259r.setKeepPressAlpha(r10);
    }

    @Override // o9.b
    public void setLeftDividerAlpha(int r10) {
        this.f6260s.setLeftDividerAlpha(r10);
    }

    public final void setMIcon(Drawable r10) {
        this.f6249h = r10;
        requestLayout();
        invalidate();
    }

    public final void setMImageTintColorId(int r10) {
        this.f6251j = r10;
        invalidate();
    }

    @Override // o9.b
    public void setOuterNormalColor(int r10) {
        this.f6260s.setOuterNormalColor(r10);
    }

    @Override // o9.b
    public void setOutlineExcludePadding(boolean r10) {
        this.f6260s.setOutlineExcludePadding(r10);
    }

    @Override // o9.b
    public void setOutlineInset(int r10, int r11, int r12, int r13) {
        this.f6260s.setOutlineInset(r10, r11, r12, r13);
    }

    @Override // o9.a
    public void setOverridePressColor(int r10) {
        this.f6259r.setOverridePressColor(r10);
    }

    @Override // android.view.View
    public void setPressed(boolean r10) {
        super.setPressed(r10);
        j r11 = this.f6248g;
        if (r11 == null) goto L5;
        r11.u(r10);
    L5:
        g r12 = this.f6247c;
        if (r12 == null) goto L9;
        r12.onPressedChanged(this, r10);
        return;
    }

    @Override // o9.b
    public void setRadius(int r10) {
        this.f6260s.setRadius(r10);
    }

    @Override // o9.b
    public void setRadius(int r10, int r11, int r12, int r13) {
        this.f6260s.setRadius(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void setRadiusAndShadow(int r10, int r11, float r12) {
        this.f6260s.setRadiusAndShadow(r10, r11, r12);
    }

    @Override // o9.b
    public void setRadiusAndShadow(int r10, int r11, int r12, float r13) {
        this.f6260s.setRadiusAndShadow(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void setRightDividerAlpha(int r10) {
        this.f6260s.setRightDividerAlpha(r10);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        g r11 = this.f6247c;
        if (r11 == null) goto L6;
        r11.onSelectedChanged(this, r10);
        return;
    }

    @Override // o9.b
    public void setShadow(@Nullable p r10, @Nullable p r11) {
        this.f6260s.setShadow(r10, r11);
    }

    @Override // o9.b
    public void setShadowAlpha(float r10) {
        this.f6260s.setShadowAlpha(r10);
    }

    @Override // o9.b
    public void setShadowColor(int r10) {
        this.f6260s.setShadowColor(r10);
    }

    @Override // o9.b
    public void setShadowCornerRadius(int r10) {
        this.f6260s.setShadowCornerRadius(r10);
    }

    @Override // o9.b
    public void setShadowElevation(int r10) {
        this.f6260s.setShadowElevation(r10);
    }

    @Override // o9.b
    public void setShadowInsets(int r10, int r11) {
        this.f6260s.setShadowInsets(r10, r11);
    }

    @Override // o9.b
    public void setShadowStyle(@StyleRes int r10) {
        this.f6260s.setShadowStyle(r10);
    }

    @Override // o9.b
    public void setShowBorderOnlyBeforeL(boolean r10) {
        this.f6260s.setShowBorderOnlyBeforeL(r10);
    }

    @Override // android.widget.TextView
    public void setTextColor(int r10) {
        if (this.f6258q == true) goto L5;
        this.f6253l = r10;
    L5:
        super.setTextColor(r10);
    }

    @Override // o9.b
    public void setTopDividerAlpha(int r10) {
        this.f6260s.setTopDividerAlpha(r10);
    }

    @Override // o9.b
    public void setUseThemeGeneralShadowElevation() {
        this.f6260s.setUseThemeGeneralShadowElevation();
    }

    @Override // o9.b
    public boolean setWidthLimit(int r10) {
        return this.f6260s.setWidthLimit(r10);
    }

    @Override // o9.b
    public void setWidthMin(int r10) {
        this.f6260s.setWidthMin(r10);
    }

    @Override // o9.b
    public boolean shouldUpdateDividerColorOnPress() {
        return this.f6260s.shouldUpdateDividerColorOnPress();
    }

    @Override // o9.b
    public void updateBottomDivider(int r10, int r11, int r12, int r13) {
        this.f6260s.updateBottomDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateBottomSeparatorColor(int r10) {
        this.f6260s.updateBottomSeparatorColor(r10);
    }

    @Override // o9.b
    public void updateDividerColorStrength(float r10) {
        this.f6260s.updateDividerColorStrength(r10);
    }

    @Override // o9.b
    public void updateLeftDivider(int r10, int r11, int r12, int r13) {
        this.f6260s.updateLeftDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateLeftSeparatorColor(int r10) {
        this.f6260s.updateLeftSeparatorColor(r10);
    }

    @Override // o9.b
    public void updateRightDivider(int r10, int r11, int r12, int r13) {
        this.f6260s.updateRightDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateRightSeparatorColor(int r10) {
        this.f6260s.updateRightSeparatorColor(r10);
    }

    @Override // o9.b
    public void updateTopDivider(int r10, int r11, int r12, int r13) {
        this.f6260s.updateTopDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateTopSeparatorColor(int r10) {
        this.f6260s.updateTopSeparatorColor(r10);
    }
}
