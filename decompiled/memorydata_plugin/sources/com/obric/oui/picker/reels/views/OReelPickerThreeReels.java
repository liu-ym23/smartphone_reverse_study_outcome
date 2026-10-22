package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0016\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0002BCB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u000fH\u0016J\b\u0010(\u001a\u00020&H\u0002J\u0018\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010\u001b2\u0006\u0010*\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020&H\u0014J\b\u0010/\u001a\u00020&H\u0014J0\u00100\u001a\u00020&2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\bH\u0014J\u0018\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0014J\b\u0010:\u001a\u00020&H\u0002J'\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\b2\b\u0010=\u001a\u0004\u0018\u00010\f2\u0006\u0010>\u001a\u00020\bH\u0002¢\u0006\u0002\u0010?J$\u0010)\u001a\u00020&*\u00020\u001b2\u0006\u0010+\u001a\u00020,2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0002R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b \u0010\u001dR\u001b\u0010\"\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b#\u0010\u001d¨\u0006D"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerThreeReels;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/picker/reels/OReelPicker;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultHeightPx", "heightPercentOfParent", "", "Ljava/lang/Float;", "observedParent", "Landroid/view/View;", "parentLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "reelsContainer", "Landroid/widget/LinearLayout;", "getReelsContainer", "()Landroid/widget/LinearLayout;", "reelsContainer$delegate", "Lkotlin/Lazy;", "reelsCount", "widthPercentOfParent", "wv1", "Lcom/obric/oui/picker/reels/views/WheelView;", "getWv1", "()Lcom/obric/oui/picker/reels/views/WheelView;", "wv1$delegate", "wv2", "getWv2", "wv2$delegate", "wv3", "getWv3", "wv3$delegate", "applyPercentBasedLayout", "", "asView", "clearParentObserver", "configure", "col", "reel", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "getReelView", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshParentObserver", "resolveDimensionPx", "referenceSize", "percent", "fallback", "(ILjava/lang/Float;I)I", "colIndex", "maxColIndex", "Builder", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OReelPickerThreeReels extends ConstraintLayout implements com.obric.oui.picker.reels.a {
    public static final a Companion = null;
    private static final String TAG = "OReelPickerThreeReels";
    private int defaultHeightPx;
    private Float heightPercentOfParent;
    private View observedParent;
    private final View.OnLayoutChangeListener parentLayoutChangeListener;
    private final Lazy reelsContainer$delegate;
    private int reelsCount;
    private Float widthPercentOfParent;
    private final Lazy wv1$delegate;
    private final Lazy wv2$delegate;
    private final Lazy wv3$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerThreeReels$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/oui/picker/reels/views/OReelPickerThreeReels$configure$2", "Lcom/obric/oui/picker/reels/views/OnWheelChangedListener;", "onChanged", "", "oldIndex", "", "newIndex", "onStopped", "curIndex", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements com.obric.oui.picker.reels.views.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.oui.picker.reels.a.b f14295a;

        b(com.obric.oui.picker.reels.a.b r1) {
            this.f14295a = r1;
        }

        @Override // com.obric.oui.picker.reels.views.a
        public void a(int r3) {
            Log.d(OReelPickerThreeReels.TAG, Intrinsics.stringPlus("onStopped: ", Integer.valueOf(r3)));
            com.obric.oui.picker.reels.a.c r0 = this.f14295a.i();
            if (r0 == null) goto L7;
            r0.onReelChanged(this.f14295a.a(), r3);
            return;
        }

        @Override // com.obric.oui.picker.reels.views.a
        public void a(int r3, int r4) {
            Log.d(OReelPickerThreeReels.TAG, "onChanged: " + r3 + " -> " + r4);
            com.obric.oui.picker.reels.a.c r5 = this.f14295a.i();
            if (r5 == null) goto L7;
            r5.onReelChanged(this.f14295a.a(), r4);
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    public OReelPickerThreeReels(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OReelPickerThreeReels(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OReelPickerThreeReels(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.wv1$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OReelPickerThreeReels$wv1$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.wv2$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OReelPickerThreeReels$wv2$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.wv3$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OReelPickerThreeReels$wv3$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.reelsContainer$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OReelPickerThreeReels$reelsContainer$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.parentLayoutChangeListener = new $$Lambda$OReelPickerThreeReels$2Q5fgTNYV2Cd2VDazgEYfKlDIdA(this);
        ZeusTransformUtils.inflate(LayoutInflater.from(r6), ZeusTransformUtils.mapRes(R.layout.o_reel_picker_3_reels, "layout", "o_reel_picker_3_reels"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public /* synthetic */ OReelPickerThreeReels(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    public static final /* synthetic */ void access$configure(OReelPickerThreeReels r0, WheelView r1, com.obric.oui.picker.reels.a.b r2, int r3, int r4) {
        r0.configure(r1, r2, r3, r4);
    }

    public static final /* synthetic */ WheelView access$getWv1(OReelPickerThreeReels r0) {
        return r0.getWv1();
    }

    public static final /* synthetic */ WheelView access$getWv2(OReelPickerThreeReels r0) {
        return r0.getWv2();
    }

    public static final /* synthetic */ WheelView access$getWv3(OReelPickerThreeReels r0) {
        return r0.getWv3();
    }

    public static final /* synthetic */ void access$setDefaultHeightPx$p(OReelPickerThreeReels r0, int r1) {
        r0.defaultHeightPx = r1;
    }

    public static final /* synthetic */ void access$setHeightPercentOfParent$p(OReelPickerThreeReels r0, Float r1) {
        r0.heightPercentOfParent = r1;
    }

    public static final /* synthetic */ void access$setReelsCount$p(OReelPickerThreeReels r0, int r1) {
        r0.reelsCount = r1;
    }

    public static final /* synthetic */ void access$setWidthPercentOfParent$p(OReelPickerThreeReels r0, Float r1) {
        r0.widthPercentOfParent = r1;
    }

    private final void applyPercentBasedLayout() {
        if (this.widthPercentOfParent == null) goto L5;
    L7:
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L10;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    L11:
        int r2 = 0;
        if (r1 != null) goto L14;
        int r3 = 0;
    L15:
        int r4 = resolveDimensionPx(r3, this.widthPercentOfParent, -1);
        if (r1 == null) goto L19;
        r2 = r1.getHeight();
    L19:
        int r5 = resolveDimensionPx(r2, this.heightPercentOfParent, this.defaultHeightPx);
        View r6 = (View) ZeusTransformUtils.preCheckCast(getReelsContainer(), View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r8 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r9.width = r4;
        r9.height = r5;
        r6.setLayoutParams(r8);
        return;
    L14:
        r3 = r1.getWidth();
        goto L15
    L10:
        r1 = null;
        goto L11
    L5:
        if (this.heightPercentOfParent != null) goto L7;
    }

    private final void clearParentObserver() {
        View r0 = this.observedParent;
        if (r0 == null) goto L6;
        r0.removeOnLayoutChangeListener(this.parentLayoutChangeListener);
    L6:
        this.observedParent = null;
    }

    private final void configure(WheelView r3, com.obric.oui.picker.reels.a.b r4, int r5, int r6) {
        ((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")).setVisibility(0);
        CharSequence r2 = r4.c();
        if (r2 == null) goto L6;
        r3.setTagText(r2);
    L6:
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(0, -1, r4.d()), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r3.setOnWheelChangedListener((com.obric.oui.picker.reels.views.a) ZeusTransformUtils.preCheckCast(new b(r4), com.obric.oui.picker.reels.views.a.class, "com.obric.memorydata.plugin"));
        r3.a(r4.b(), RangesKt.coerceIn(r4.h(), 0, RangesKt.coerceAtLeast(r4.b().size() - 1, 0)));
    }

    private final LinearLayout getReelsContainer() {
        Object r2 = this.reelsContainer$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-reelsContainer>(...)");
        return (LinearLayout) ZeusTransformUtils.preCheckCast(r2, LinearLayout.class, "com.obric.memorydata.plugin");
    }

    private final WheelView getWv1() {
        Object r2 = this.wv1$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-wv1>(...)");
        return (WheelView) ZeusTransformUtils.preCheckCast(r2, WheelView.class, "com.obric.memorydata.plugin");
    }

    private final WheelView getWv2() {
        Object r2 = this.wv2$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-wv2>(...)");
        return (WheelView) ZeusTransformUtils.preCheckCast(r2, WheelView.class, "com.obric.memorydata.plugin");
    }

    private final WheelView getWv3() {
        Object r2 = this.wv3$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-wv3>(...)");
        return (WheelView) ZeusTransformUtils.preCheckCast(r2, WheelView.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void lambda$2Q5fgTNYV2Cd2VDazgEYfKlDIdA(OReelPickerThreeReels r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        m1333parentLayoutChangeListener$lambda0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: parentLayoutChangeListener$lambda-0, reason: not valid java name */
    private static final void m1333parentLayoutChangeListener$lambda0(OReelPickerThreeReels r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.applyPercentBasedLayout();
    }

    private final void refreshParentObserver() {
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L5;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    L7:
        if (this.observedParent != r1) goto L9;
        return;
    L9:
        clearParentObserver();
        if (r1 == null) goto L13;
        r1.addOnLayoutChangeListener(this.parentLayoutChangeListener);
    L13:
        this.observedParent = r1;
        return;
    L5:
        r1 = null;
        goto L7
    }

    private final int resolveDimensionPx(int r1, Float r2, int r3) {
        if (r2 == null) goto L11;
        if (r1 <= 0) goto L11;
        int r0 = RangesKt.coerceAtLeast((int) (r1 * r2.floatValue()), 0);
        if (r0 > 0) goto L8;
        return r0;
    L8:
        if ((r0 % 2) != 0) goto L10;
        return r0;
    L10:
        return r0 + 1;
    L11:
        return r3;
    }

    @Override // com.obric.oui.picker.reels.a
    public View asView() {
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
    }

    public void configure(int r3, com.obric.oui.picker.reels.a.b r4) {
        Intrinsics.checkNotNullParameter(r4, "reel");
        WheelView r0 = getReelView(r3);
        if (r0 == null) goto L7;
        configure(r0, r4, r3, this.reelsCount - 1);
        return;
    }

    @Override // com.obric.oui.picker.reels.a
    public WheelView getReelView(int r2) {
        if (r2 == 0) goto L11;
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L13;
        return null;
    L13:
        return getWv3();
    L14:
        return getWv2();
    L11:
        return getWv1();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        refreshParentObserver();
        applyPercentBasedLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        clearParentObserver();
        super.onDetachedFromWindow();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }
}
