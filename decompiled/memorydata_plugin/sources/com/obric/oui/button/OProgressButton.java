package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.loc.o;
import com.obric.common.oea.foundation.animation.d.d;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J(\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0010J\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\fJ\b\u0010\"\u001a\u00020\u0016H\u0002J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0007J\u0016\u0010#\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0010J\b\u0010%\u001a\u00020\u0016H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/oui/button/OProgressButton;", "Lcom/obric/oui/button/OButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "coveredTextColor", "currentProgress", "currentProgressFloat", "", "defaultBackgroundColor", "Ljava/lang/Integer;", "isInProgressMode", "", "progressAnimator", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "progressBgDrawableRes", "uncoveredTextColor", "changeToProgressDrawable", "", "onSizeChanged", "w", o.g, "oldw", "oldh", "setProgress", "progressPercentage", "setProgressMode", "isProgressMode", "updateBackgroundProgress", "progress", "updateButtonMode", "updateProgress", "animate", "updateTextShader", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OProgressButton extends OButton {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13394b;
    private Integer c;
    private final int d;
    private final int e;
    private final int f;
    private int g;
    private float h;
    private d i;

    public OProgressButton(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OProgressButton(Context r11, AttributeSet r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        super(r14, r15, r13, 0, null, 24, null);
        TypedArray r16 = r14.obtainStyledAttributes(r15, R.styleable.OProgressButton);
        Intrinsics.checkNotNullExpressionValue(r16, "context.obtainStyledAttr…tyleable.OProgressButton)");
        this.d = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OProgressButton_android_textColor, "styleable", "OProgressButton_android_textColor"), ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(R.color.oui_on_accent_default, TypedValues.Custom.S_COLOR, "oui_on_accent_default")));
        this.e = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OProgressButton_oui_progress_button_uncovered_text_color, "styleable", "OProgressButton_oui_progress_button_uncovered_text_color"), ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(R.color.oui_accent_6_bg, TypedValues.Custom.S_COLOR, "oui_accent_6_bg")));
        this.f = r16.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OProgressButton_oui_progress_bg_resource, "styleable", "OProgressButton_oui_progress_bg_resource"), ZeusTransformUtils.mapRes(R.drawable.o_button_progress_drawable_primary, "drawable", "o_button_progress_drawable_primary"));
        r16.recycle();
        Drawable r17 = getBackground();
        if (ZeusTransformUtils.instanceOf(r17, ColorDrawable.class) == false) goto L6;
        this.c = Integer.valueOf(((ColorDrawable) ZeusTransformUtils.preCheckCast(r17, ColorDrawable.class, "com.obric.memorydata.plugin")).getColor());
        return;
    }

    public /* synthetic */ OProgressButton(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = 0;
    L5:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ float a(OProgressButton r0) {
        return r0.h;
    }

    private final void a() {
        if (this.f13394b == false) goto L5;
        b();
        return;
    L5:
        getPaint().setShader(null);
        setTextColor(this.d);
        if (this.c == null) goto L8;
        Integer r1 = this.c;
        Intrinsics.checkNotNull(r1);
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(new ColorDrawable(r1.intValue()), Drawable.class, "com.obric.memorydata.plugin"));
    L8:
        invalidate();
    }

    public static final /* synthetic */ void a(OProgressButton r0, float r1) {
        r0.h = r1;
    }

    private final void b() {
        Drawable r0 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.f);
        ClipDrawable r2 = null;
        if (r0 != null) goto L5;
        Drawable r1 = null;
    L6:
        setBackground(r1);
        Drawable r3 = getBackground();
        if (ZeusTransformUtils.instanceOf(r3, LayerDrawable.class) == false) goto L16;
        Drawable r4 = ((LayerDrawable) ZeusTransformUtils.preCheckCast(r3, LayerDrawable.class, "com.obric.memorydata.plugin")).findDrawableByLayerId(android.R.id.progress);
        if (ZeusTransformUtils.instanceOf(r4, ClipDrawable.class) == false) goto L11;
        r2 = (ClipDrawable) ZeusTransformUtils.preCheckCast(r4, ClipDrawable.class, "com.obric.memorydata.plugin");
    L11:
        Integer r5 = this.c;
        if (r5 == null) goto L16;
        if (r2 == null) goto L16;
        Intrinsics.checkNotNull(r5);
        r2.setTint(r5.intValue());
    L16:
        a(this.h);
        c();
        return;
    L5:
        r1 = r0.mutate();
        goto L6
    }

    public static final /* synthetic */ boolean b(OProgressButton r0) {
        return r0.f13394b;
    }

    private final void c() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        float r0 = this.h / 100.0f;
        float r5 = getWidth();
        float r1 = RangesKt.coerceIn(r0, 0.0f, 1.0f);
        if (r1 > 0.0f) goto L10;
        getPaint().setShader(null);
        int r2 = this.e;
    L8:
        setTextColor(r2);
        invalidate();
        return;
    L10:
        if (r1 < 1.0f) goto L12;
        getPaint().setShader(null);
    L13:
        r2 = this.d;
        goto L8
    L12:
        int r9 = this.d;
        int r10 = this.e;
        getPaint().setShader((Shader) ZeusTransformUtils.preCheckCast(new LinearGradient(0.0f, 0.0f, r5, 0.0f, new int[]{r9, r9, r10, r10}, new float[]{0.0f, r1, r1, 1.0f}, Shader.TileMode.CLAMP), Shader.class, "com.obric.memorydata.plugin"));
        goto L13
    }

    public static final /* synthetic */ void c(OProgressButton r0) {
        r0.c();
    }

    public static final /* synthetic */ int d(OProgressButton r0) {
        return r0.g;
    }

    public final void a(float r3) {
        Drawable r2 = getBackground();
        if (ZeusTransformUtils.instanceOf(r2, LayerDrawable.class) == false) goto L12;
        Drawable r4 = ((LayerDrawable) ZeusTransformUtils.preCheckCast(r2, LayerDrawable.class, "com.obric.memorydata.plugin")).findDrawableByLayerId(android.R.id.progress);
        if (ZeusTransformUtils.instanceOf(r4, ClipDrawable.class) == false) goto L7;
        ClipDrawable r5 = (ClipDrawable) ZeusTransformUtils.preCheckCast(r4, ClipDrawable.class, "com.obric.memorydata.plugin");
    L8:
        if (r5 == null) goto L13;
        r5.setLevel((int) (r3 * 100));
        return;
    L13:
        return;
    L7:
        r5 = null;
        goto L8
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.f13394b == false) goto L6;
        c();
        return;
    }

    public final void setProgress(int r5) {
        if (this.g != r5) goto L5;
        return;
    L5:
        d r0 = this.i;
        if (r0 == null) goto L9;
        d.a(r0, false, 1, null);
    L9:
        this.g = r5;
        float r6 = r5;
        this.h = r6;
        a(r6);
        if (this.f13394b == false) goto L13;
        c();
        return;
    }

    public final void setProgressMode(boolean r2) {
        if (this.f13394b == r2) goto L6;
        this.f13394b = r2;
        a();
        return;
    }
}
