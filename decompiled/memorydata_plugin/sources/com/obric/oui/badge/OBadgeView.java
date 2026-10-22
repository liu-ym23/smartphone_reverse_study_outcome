package com.obric.oui.badge;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.crash.dumper.Scraps;
import com.loc.o;
import com.obric.memorydata.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.chrono.HijrahDate;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 =2\u00020\u0001:\u0001=B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J0\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J(\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0012\u0010&\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0007H\u0016J\u0012\u0010*\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u000e\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\fJ\u000e\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0007J\u0010\u00101\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0007H\u0016J\u0018\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u000205H\u0016J\u0006\u00106\u001a\u00020\u0010J\b\u00107\u001a\u00020\u0010H\u0002J\b\u00108\u001a\u00020\u0010H\u0002J\u0010\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u000205H\u0002J\u0010\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u0014H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006>"}, d2 = {"Lcom/obric/oui/badge/OBadgeView;", "Lcom/obric/oui/text/OTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "badge", "Lcom/obric/oui/badge/OBadgeDrawable;", "enableFontScale", "", "initialBgColor", "Ljava/lang/Integer;", "hide", "", "initFromAttributes", "invalidateDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", o.g, "oldw", "oldh", "setBackground", TraceCons.METRIC_BACKGROUND, "setBackgroundColor", TypedValues.Custom.S_COLOR, "setContentDescription", "contentDescription", "", "setEnableFontScale", "enabled", "setMaxNumberInCount", "maxNumber", "setTextColor", "setTextSize", Scraps.INNER_UNIT, "size", "", "show", "syncTextViewPropertiesToBadge", "updateBadgeCoordinates", "updateBadgeTextSizeFromPx", "sizePx", "verifyDrawable", "who", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBadgeView extends OTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13329a = null;
    private static int e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OBadgeDrawable f13330b;
    private Integer c;
    private boolean d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/badge/OBadgeView$Companion;", "", "()V", "MAX_COUNT", "", "getMAX_COUNT", "()I", "setMAX_COUNT", "(I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13329a = new a(null);
        e = HijrahDate.MAX_VALUE_OF_ERA;
    }

    public OBadgeView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBadgeView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OBadgeView(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r12, null, 8, null);
        this.d = true;
        OBadgeDrawable r15 = OBadgeDrawable.f13325a.a(r13);
        this.f13330b = r15;
        if (r15 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r15 = null;
    L5:
        r15.setCallback((Drawable.Callback) ZeusTransformUtils.preCheckCast(this, Drawable.Callback.class, "com.obric.memorydata.plugin"));
        a(r14, r12);
        a();
        addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), TextWatcher.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ OBadgeView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ OBadgeDrawable a(OBadgeView r0) {
        return r0.f13330b;
    }

    private final void a() {
        OBadgeDrawable r0 = this.f13330b;
        OBadgeDrawable r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L5:
        CharSequence r3 = getText();
        if (r3 != null) goto L8;
        String r4 = null;
    L9:
        r0.a(r4);
        OBadgeDrawable r1 = this.f13330b;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r1 = null;
    L12:
        r1.d(getCurrentTextColor());
        OBadgeDrawable r5 = this.f13330b;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r5 = null;
    L15:
        r5.a(this.d);
        a(getTextSize());
        Drawable r6 = getBackground();
        if (ZeusTransformUtils.instanceOf(r6, ColorDrawable.class) == false) goto L24;
        OBadgeDrawable r7 = this.f13330b;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
    L21:
        int r8 = ((ColorDrawable) ZeusTransformUtils.preCheckCast(r6, ColorDrawable.class, "com.obric.memorydata.plugin")).getColor();
    L22:
        r2.c(r8);
        return;
    L20:
        r2 = r7;
        goto L21
    L24:
        if (this.c == null) goto L31;
        OBadgeDrawable r9 = this.f13330b;
        if (r9 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
    L29:
        Integer r10 = this.c;
        Intrinsics.checkNotNull(r10);
        r8 = r10.intValue();
        goto L22
    L28:
        r2 = r9;
        goto L29
    L31:
        return;
    L8:
        r4 = r3.toString();
        goto L9
    }

    private final void a(float r2) {
        float r3 = r2 / ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().scaledDensity;
        OBadgeDrawable r1 = this.f13330b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r1 = null;
    L5:
        r1.a(r3);
    }

    private final void a(AttributeSet r12, int r13) {
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        OBadgeDrawable r5 = this.f13330b;
        OBadgeDrawable r8 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r5 = null;
    L5:
        r5.a(OBadgeDrawable.BadgeGravity.CENTER);
        if (r14 != null) goto L13;
        OBadgeDrawable r15 = this.f13330b;
        if (r15 != null) goto L10;
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("badge");
    L11:
        r8.a(getContentDescription());
        return;
    L10:
        r8 = r15;
        goto L11
    L13:
        TypedArray r16 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r14, R.styleable.OBadgeView, r13, 0);
        Intrinsics.checkNotNullExpressionValue(r16, "context.obtainStyledAttr…dgeView, defStyleAttr, 0)");
        this.d = r16.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_oui_widgetEnableFontScale, "styleable", "OBadgeView_oui_widgetEnableFontScale"), true);     // Catch: Throwable -> L53
        OBadgeDrawable r17 = this.f13330b;     // Catch: Throwable -> L53
        if (r17 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("badge");     // Catch: Throwable -> L53
        r17 = null;
    L17:
        r17.a(this.d);     // Catch: Throwable -> L53
        int r18 = ZeusTransformUtils.mapRes(R.styleable.OBadgeView_o_maxNumber, "styleable", "OBadgeView_o_maxNumber");     // Catch: Throwable -> L53
        OBadgeDrawable r6 = this.f13330b;     // Catch: Throwable -> L53
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("badge");     // Catch: Throwable -> L53
        r6 = null;
    L20:
        int r19 = r16.getInt(r18, r6.a());     // Catch: Throwable -> L53
        OBadgeDrawable r7 = this.f13330b;     // Catch: Throwable -> L53
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("badge");     // Catch: Throwable -> L53
        r7 = null;
    L23:
        r7.a(r19);     // Catch: Throwable -> L53
        int r110 = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_oui_badgeview_ellipsis_color, "styleable", "OBadgeView_oui_badgeview_ellipsis_color"), 0);     // Catch: Throwable -> L53
        OBadgeDrawable r9 = this.f13330b;     // Catch: Throwable -> L53
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("badge");     // Catch: Throwable -> L53
        r9 = null;
    L26:
        r9.a(Integer.valueOf(r110));     // Catch: Throwable -> L53
        if (r16.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_text, "styleable", "OBadgeView_android_text")) == false) goto L36;
        CharSequence r111 = r16.getText(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_text, "styleable", "OBadgeView_android_text"));     // Catch: Throwable -> L53
        OBadgeDrawable r3 = this.f13330b;     // Catch: Throwable -> L53
        if (r3 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("badge");     // Catch: Throwable -> L53
        r3 = null;
    L31:
        if (r111 != null) goto L33;
        String r112 = null;
    L34:
        r3.a(r112);     // Catch: Throwable -> L53
        goto L36
    L33:
        r112 = r111.toString();     // Catch: Throwable -> L53
    L36:
        if (r16.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_textColor, "styleable", "OBadgeView_android_textColor")) == false) goto L42;
        int r113 = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_textColor, "styleable", "OBadgeView_android_textColor"), getCurrentTextColor());     // Catch: Throwable -> L53
        OBadgeDrawable r2 = this.f13330b;     // Catch: Throwable -> L53
        if (r2 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("badge");     // Catch: Throwable -> L53
        r2 = null;
    L40:
        r2.d(r113);     // Catch: Throwable -> L53
    L42:
        if (r16.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_textSize, "styleable", "OBadgeView_android_textSize")) == false) goto L45;
        a(r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_textSize, "styleable", "OBadgeView_android_textSize"), getTextSize()));     // Catch: Throwable -> L53
    L45:
        if (r16.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_background, "styleable", "OBadgeView_android_background")) == false) goto L50;
        int r114 = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OBadgeView_android_background, "styleable", "OBadgeView_android_background"), ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_red_6, TypedValues.Custom.S_COLOR, "oui_red_6")));     // Catch: Throwable -> L53
        OBadgeDrawable r0 = this.f13330b;     // Catch: Throwable -> L53
        if (r0 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("badge");     // Catch: Throwable -> L53
        r0 = null;
    L49:
        r0.c(r114);     // Catch: Throwable -> L53
    L50:
        r16.recycle();
        r15 = this.f13330b;
        if (r15 != null) goto L10;
    L53:
        th = move-exception;
        r16.recycle();
        throw th;
    }

    private final void b() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L12;
        OBadgeDrawable r0 = this.f13330b;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L9:
        r0.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        OBadgeDrawable r0 = this.f13330b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L6:
        if (Intrinsics.areEqual(r2, r0) == false) goto L8;
        invalidate();
        return;
    L8:
        super.invalidateDrawable(r2);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        OBadgeDrawable r1 = this.f13330b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r1 = null;
    L5:
        r1.draw(r2);
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (r1 == false) goto L6;
        b();
        return;
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r6, int r7) {
        OBadgeDrawable r0 = this.f13330b;
        OBadgeDrawable r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L5:
        r0.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        OBadgeDrawable r2 = this.f13330b;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
    L9:
        Rect r3 = r1.getBounds();
        Intrinsics.checkNotNullExpressionValue(r3, "badge.bounds");
        int r4 = r3.width();
        int r5 = r3.height();
        setMeasuredDimension(TextView.resolveSize(r4 + (getPaddingLeft() + getPaddingRight()), r6), TextView.resolveSize(r5 + (getPaddingTop() + getPaddingBottom()), r7));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        b();
    }

    @Override // android.view.View
    public void setBackground(Drawable r4) {
        if (this.f13330b == null) goto L16;
        OBadgeDrawable r1 = null;
        if (ZeusTransformUtils.instanceOf(r4, ColorDrawable.class) == false) goto L7;
        ColorDrawable r5 = (ColorDrawable) ZeusTransformUtils.preCheckCast(r4, ColorDrawable.class, "com.obric.memorydata.plugin");
    L8:
        if (r5 == null) goto L17;
        OBadgeDrawable r0 = this.f13330b;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
    L14:
        r1.c(r5.getColor());
        invalidate();
        return;
    L13:
        r1 = r0;
        goto L14
    L17:
        return;
    L7:
        r5 = null;
        goto L8
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        OBadgeDrawable r0 = this.f13330b;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L6:
        r0.c(r2);
        invalidate();
        return;
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        super.setContentDescription(r4);
        OBadgeDrawable r2 = this.f13330b;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r2 = null;
    L5:
        r2.a(r4);
    }

    public final void setEnableFontScale(boolean r2) {
        if (this.d != r2) goto L5;
        return;
    L5:
        this.d = r2;
        OBadgeDrawable r0 = this.f13330b;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L8:
        r0.a(r2);
        a();
        requestLayout();
        invalidate();
    }

    public final void setMaxNumberInCount(int r2) {
        OBadgeDrawable r0 = this.f13330b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L5:
        r0.a(r2);
        requestLayout();
        invalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int r2) {
        if (this.f13330b == null) goto L9;
        super.setTextColor(r2);
        OBadgeDrawable r3 = this.f13330b;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r3 = null;
    L7:
        r3.d(getCurrentTextColor());
        invalidate();
        return;
    }

    @Override // android.widget.TextView
    public void setTextSize(int r1, float r2) {
        super.setTextSize(r1, r2);
        if (this.f13330b == null) goto L5;
        a(getTextSize());
    L5:
        requestLayout();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "who");
        if (super.verifyDrawable(r2) == true) goto L11;
        OBadgeDrawable r1 = this.f13330b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r1 = null;
    L8:
        if (Intrinsics.areEqual(r2, r1) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
