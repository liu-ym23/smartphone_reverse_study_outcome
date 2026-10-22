package com.obric.memorydata.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0014J0\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0002J\f\u0010 \u001a\u00020\u000f*\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/ui/custom/DeviceAdaptiveCardListItem;", "Lcom/obric/oui/lisitem/OCardListItem;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adaptivePaddingPx", "adaptiveFontWeight", "adaptiveRadiusPx", "lastAppliedRadiusPosition", "onAttachedToWindow", "", "onLayout", "changed", "", "left", "top", "right", "bottom", "requestLayout", "ensureAdaptivePadding", "caller", "", "applyRadiusClipIfNeed", "position", "applyFontWeight", "weight", "disableTitleFontPaddingForVerification", "disableFontPaddingForVerification", "Landroid/widget/TextView;", "resolveThemeDimen", "attrRes", "resolveThemeInt", "Companion", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeviceAdaptiveCardListItem extends OCardListItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12991a = null;
    private final int c;
    private final int d;
    private final int e;
    private int f;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/ui/custom/DeviceAdaptiveCardListItem$Companion;", "", "<init>", "()V", "TAG", "", "VALUE_UNSET", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/ui/custom/DeviceAdaptiveCardListItem$applyRadiusClipIfNeed$1$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f12992a;

        b(float[] r1) {
            this.f12992a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r5, Outline r6) {
            Intrinsics.checkNotNullParameter(r5, "view");
            Intrinsics.checkNotNullParameter(r6, "outline");
            int r0 = r5.getWidth();
            int r7 = r5.getHeight();
            if (r0 <= 0) goto L10;
            if (r7 <= 0) goto L10;
            if (Build.VERSION.SDK_INT < 21) goto L12;
            Path r1 = new Path();
            r1.addRoundRect(new RectF(0.0f, 0.0f, r0, r7), this.f12992a, Path.Direction.CW);
            r6.setConvexPath(r1);
            return;
        L12:
            return;
        L10:
            r6.setEmpty();
        }
    }

    static {
        f12991a = new a(null);
    }

    public DeviceAdaptiveCardListItem(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public DeviceAdaptiveCardListItem(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public DeviceAdaptiveCardListItem(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r11);
        this.f = Integer.MIN_VALUE;
        int r14 = f(ZeusTransformUtils.mapRes(R.attr.OCardLisItemPadding, "attr", "OCardLisItemPadding"));
        this.c = r14;
        int r0 = g(ZeusTransformUtils.mapRes(R.attr.OCardLisItemTitleTextFontWeight, "attr", "OCardLisItemTitleTextFontWeight"));
        this.d = r0;
        int r15 = f(ZeusTransformUtils.mapRes(R.attr.OCardLisItemRadius, "attr", "OCardLisItemRadius"));
        this.e = r15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DeviceAdaptiveCard", "init: adaptivePaddingPx=" + r14 + ", adaptiveFontWeight=" + r0 + ", adaptiveRadiusPx=" + r15, false, 4, null);
        if (r0 == Integer.MIN_VALUE) goto L5;
        e(r0);
    L5:
        c();
        if (r15 == Integer.MIN_VALUE) goto L8;
        a(this, 0, 1, null);
    L8:
        if (r14 == Integer.MIN_VALUE) goto L11;
        a(CommonConsts.APM_INNER_EVENT_COST_INIT);
        return;
    }

    public /* synthetic */ DeviceAdaptiveCardListItem(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final void a(TextView r3) {
        r3.setIncludeFontPadding(false);
        if (Build.VERSION.SDK_INT < 28) goto L6;
        r3.setFallbackLineSpacing(false);
        return;
    }

    static /* synthetic */ void a(DeviceAdaptiveCardListItem r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = r0.getCardPosition();
    L5:
        r0.d(r1);
    }

    private final void a(String r15) {
        FrameLayout r0 = getCardContainer();
        int r1 = r0.getPaddingLeft();
        int r2 = r0.getPaddingTop();
        int r3 = r0.getPaddingRight();
        int r4 = r0.getPaddingBottom();
        int r5 = getCardPosition();
        if (this.e == Integer.MIN_VALUE) goto L5;
        d(r5);
    L5:
        int r6 = this.c;
        if (r5 != 0) goto L8;
    L18:
        Integer r7 = Integer.valueOf(r6);
    L19:
        Pair r14 = TuplesKt.to(r7, Integer.valueOf(this.c));
    L20:
        int r8 = ((Number) ZeusTransformUtils.preCheckCast(r14.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r16 = ((Number) ZeusTransformUtils.preCheckCast(r14.component2(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r1 != r6) goto L26;
        if (r2 != r8) goto L26;
        if (r3 != r6) goto L26;
        if (r4 != r16) goto L26;
        return;
    L26:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DeviceAdaptiveCard", "ensureAdaptivePadding[" + r15 + "]: base=(" + r1 + ',' + r2 + ',' + r3 + ',' + r4 + ") -> new=(" + r6 + ',' + r8 + ',' + r6 + ',' + r16 + ')', false, 4, null);
        r0.setPadding(r6, r8, r6, r16);
        return;
    L8:
        if (r5 != 1) goto L10;
        Integer r17 = Integer.valueOf(r6);
    L17:
        r14 = TuplesKt.to(r17, Integer.valueOf(r4));
        goto L20
    L10:
        if (r5 != 2) goto L12;
        r17 = Integer.valueOf(r2);
        goto L17
    L12:
        if (r5 != 3) goto L18;
        r7 = Integer.valueOf(r2);
        goto L19
    }

    private final void c() {
        a((TextView) ZeusTransformUtils.preCheckCast(getTitleView(), TextView.class, "com.obric.memorydata.plugin"));
        a((TextView) ZeusTransformUtils.preCheckCast(getSubTitleView(), TextView.class, "com.obric.memorydata.plugin"));
    }

    private final void d(int r4) {
        if (this.f != r4) goto L5;
        return;
    L5:
        this.f = r4;
        float r5 = this.e;
        OUICardConstraintLayout r3 = getContentContainer();
        r3.setClipToOutline(true);
        r3.setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(new b(new float[]{r5, r5, r5, r5, r5, r5, r5, r5}), ViewOutlineProvider.class, "com.obric.memorydata.plugin"));
        r3.invalidateOutline();
    }

    private final void e(int r3) {
        OTextView r2 = getTitleView();
        if (Build.VERSION.SDK_INT < 28) goto L10;
        Typeface r0 = r2.getTypeface();
        if (r0 != null) goto L7;
        r0 = Typeface.DEFAULT;
    L7:
        Typeface r4 = Typeface.create(r0, r3, r0.isItalic());
    L8:
        r2.setTypeface(r4);
        return;
    L10:
        if (r3 < 500) goto L12;
        int r5 = 1;
    L13:
        Typeface r1 = r2.getTypeface();
        if (r1 != null) goto L16;
        r1 = Typeface.DEFAULT;
    L16:
        r4 = Typeface.create(r1, r5);
        goto L8
    L12:
        r5 = 0;
        goto L13
    }

    private final int f(int r3) {
        TypedArray r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().obtainStyledAttributes(new int[]{r3});
        Intrinsics.checkNotNullExpressionValue(r2, "obtainStyledAttributes(...)");
        int r4 = r2.getDimensionPixelSize(0, Integer.MIN_VALUE);     // Catch: Throwable -> L6
        r2.recycle();
        return r4;
    L6:
        th = move-exception;
        r2.recycle();
        throw th;
    }

    private final int g(int r4) {
        TypedValue r0 = new TypedValue();
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().resolveAttribute(r4, r0, true) == true) goto L7;
        return Integer.MIN_VALUE;
    L7:
        return r0.data;
    }

    @Override // com.obric.oui.lisitem.OCardListItem, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
        if (this.e == Integer.MIN_VALUE) goto L6;
        a(this, 0, 1, null);
    L6:
        if (this.c == Integer.MIN_VALUE) goto L9;
        a("onAttachedToWindow");
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.c == Integer.MIN_VALUE) goto L6;
        a("onLayout");
        return;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        if (this.c == Integer.MIN_VALUE) goto L11;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        ((DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(this, DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin")).a("requestLayout");     // Catch: Throwable -> L6
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return;
    }
}
