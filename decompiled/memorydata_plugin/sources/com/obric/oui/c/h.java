package com.obric.oui.c;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.oui.common.style.k;
import com.obric.oui.common.style.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u001fJB\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0004H\u0007J\u0011\u0010+\u001a\u00020\f*\u00020,H\u0000¢\u0006\u0002\b-J\u0011\u0010.\u001a\u00020\f*\u00020,H\u0000¢\u0006\u0002\b/J\u0019\u00100\u001a\u00020)*\u0002012\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\b4J1\u00105\u001a\u00020\f*\u0004\u0018\u0001012!\u00106\u001a\u001d\u0012\u0013\u0012\u001101¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\f07H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/oui/utils/ViewUtil;", "", "()V", "LARGE_FONT_THRESHOLD", "", "TAG", "", "applyColorAlphaStrength", "", TypedValues.Custom.S_COLOR, "strength", "applyShadowStyleFromResource", "", "context", "Landroid/content/Context;", "shadowStyleRes", "baseShadow", "Lcom/obric/oui/common/style/Shadow;", "drawShadowLayer", "canvas", "Landroid/graphics/Canvas;", "shadow", "rect", "Landroid/graphics/RectF;", "radius", "getActivityContentView", "Landroid/view/ViewGroup;", "activity", "Landroid/app/Activity;", "getDialogContentView", "dialog", "Landroid/app/Dialog;", "initShadow", "typedArray", "Landroid/content/res/TypedArray;", "colorId", "radiusId", "offsetXId", "offsetYId", "spreadId", "isInLargeFont", "", "fontScale", "forceStartMarquee", "Landroid/widget/TextView;", "forceStartMarquee$OUI_standardRelease", "forceStopMarquee", "forceStopMarquee$OUI_standardRelease", "isEventOutsideView", "Landroid/view/View;", "ev", "Landroid/view/MotionEvent;", "isEventOutsideView$OUI_standardRelease", "traverseDescendants", "visitor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "child", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f13408a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f13409b = 0.0f;

    static {
        f13408a = new h();
        f13409b = 1.2f;
    }

    private h() {
    }

    @JvmStatic
    public static final int a(int r3, float r4) {
        if (r4 != 1.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return r3;
    L8:
        float r5 = RangesKt.coerceIn(r4, 0.0f, 1.0f);
        return Color.argb((int) (Color.alpha(r3) * r5), Color.red(r3), Color.green(r3), Color.blue(r3));
    L5:
        r1 = false;
        goto L6
    }

    private final void a(TypedArray r1, k r2, int r3, int r4, int r5, int r6, int r7) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.a(r1.getColor(r3, Color.parseColor("#00000000")));
        r2.a(r1.getDimension(r4, 0.0f));
        r2.b(r1.getDimension(r5, 0.0f));
        r2.c(r1.getDimension(r6, 0.0f));
        r2.d(r1.getDimension(r7, 0.0f));
    }

    @JvmStatic
    public static final void a(View r5, Function1<? super View, Unit> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "visitor");
        if (r5 != null) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L14;
        int r0 = 0;
        int r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
    L8:
        if (r0 >= r2) goto L18;
        int r3 = r0 + 1;
        View r1 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(r0);
        if (r1 == null) goto L13;
        r7.invoke(r1);
    L13:
        r0 = r3;
        goto L8
    L18:
        return;
    }

    @JvmStatic
    public static final boolean a(float r1) {
        if (r1 < f13409b) goto L5;
        return true;
    L5:
        return false;
    }

    public final ViewGroup a(Activity r3) {
        Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "activity");
        return (ViewGroup) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getWindow(r2, "com.obric.memorydata.plugin").getDecorView().findViewById(R.id.content), ViewGroup.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        com.obric.oui.c.a.b.a("ViewUtil", "getActivityContentView, error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return (ViewGroup) ZeusTransformUtils.preCheckCast(null, ViewGroup.class, "com.obric.memorydata.plugin");
    }

    public final void a(Context r10, int r11, k r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r12, "baseShadow");
        TypedArray r14 = r13.obtainStyledAttributes(r11, com.obric.memorydata.plugin.R.styleable.OUILayout);
        Intrinsics.checkNotNullExpressionValue(r14, "context.obtainStyledAttr…s, R.styleable.OUILayout)");
        a(r14, r12, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OUILayout_oui_firstShadowColor, "styleable", "OUILayout_oui_firstShadowColor"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OUILayout_oui_firstShadowBlur, "styleable", "OUILayout_oui_firstShadowBlur"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OUILayout_oui_firstOffsetX, "styleable", "OUILayout_oui_firstOffsetX"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OUILayout_oui_firstOffsetY, "styleable", "OUILayout_oui_firstOffsetY"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OUILayout_oui_firstShadowSpread, "styleable", "OUILayout_oui_firstShadowSpread"));
        r14.recycle();
    }

    public final void a(Canvas r5, k r6, RectF r7, float r8) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        Intrinsics.checkNotNullParameter(r6, "shadow");
        Intrinsics.checkNotNullParameter(r7, "rect");
        if (r6.g() <= 0.0f) goto L5;
        r8 = r6.g();
    L5:
        Path r4 = new Path();
        m.f13498a.a(r4, r7, r8);
        int r1 = r5.save();
        RectF r2 = new RectF(r7);
        r2.offset(r6.c(), r6.d());
        r2.inset(-r6.e(), -r6.e());
        r5.clipOutPath(r4);
        r6.f().setColor(r6.a());
        if (r6.b() <= 0.0f) goto L8;
        r6.f().setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(new BlurMaskFilter(r6.b(), BlurMaskFilter.Blur.NORMAL), MaskFilter.class, "com.obric.memorydata.plugin"));
    L8:
        m.a(r5, r2, r8, r6.f());
        r5.restoreToCount(r1);
    }

    public final boolean a(View r6, MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "ev");
        float r5 = r7.getRawX();
        float r8 = r7.getRawY();
        int[] r0 = new int[2];
        r6.getLocationOnScreen(r0);
        if (r5 < r0[0]) goto L11;
        if (r8 < r0[1]) goto L11;
        if (r5 > (r0[0] + r6.getWidth())) goto L11;
        if (r8 > (r0[1] + r6.getHeight())) goto L11;
        return false;
    L11:
        return true;
    }
}
