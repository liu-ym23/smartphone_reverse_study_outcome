package com.obric.oui.texteffects;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.texteffects.core.Direction;
import com.obric.oui.texteffects.core.EffectProperty;
import com.obric.oui.texteffects.core.GradientBlurCurveType;
import com.obric.oui.texteffects.core.j;
import com.obric.oui.texteffects.core.k;
import com.obric.oui.texteffects.core.l;
import com.obric.oui.texteffects.core.m;
import com.obric.oui.texteffects.core.o;
import com.obric.oui.texteffects.core.q;
import com.obric.oui.texteffects.core.t;
import com.obric.oui.texteffects.core.u;
import com.obric.oui.texteffects.runtime.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 u2\u00020\u0001:\u0002uvB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0002J\u001a\u0010*\u001a\u00020\"2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0002J\u0010\u0010.\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010/\u001a\u000200H\u0002J\u0014\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u00020\"H\u0002J\b\u00106\u001a\u00020\"H\u0002J\u0010\u00107\u001a\u00020\n2\u0006\u00108\u001a\u000209H\u0002J\u0014\u0010:\u001a\u00020\u00072\n\b\u0002\u00103\u001a\u0004\u0018\u000104H\u0002J \u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u00108\u001a\u0002092\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010?\u001a\u00020\u0012H\u0002J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\u0006\u0010D\u001a\u00020\nJ\b\u0010E\u001a\u00020\"H\u0014J\u0012\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020\u0007H\u0002J\b\u0010I\u001a\u00020&H\u0002J\b\u0010J\u001a\u00020\"H\u0002J\b\u0010K\u001a\u00020\nH\u0002J\u0010\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020&H\u0002J\u001f\u0010N\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020$2\u0006\u0010B\u001a\u00020CH\u0002¢\u0006\u0002\u0010OJ\u000e\u0010P\u001a\u00020\"2\u0006\u0010Q\u001a\u00020\nJ\u000e\u0010R\u001a\u00020\"2\u0006\u00103\u001a\u000202J\u000e\u0010S\u001a\u00020\"2\u0006\u00103\u001a\u000202J\u000e\u0010T\u001a\u00020\"2\u0006\u00103\u001a\u000202J\u0018\u0010U\u001a\u00020\"2\u0006\u0010B\u001a\u00020C2\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010V\u001a\u00020\"2\b\u00108\u001a\u0004\u0018\u000109J\u0010\u0010W\u001a\u00020\"2\b\u00108\u001a\u0004\u0018\u000109J\u0012\u0010X\u001a\u00020\"2\n\b\u0002\u0010Y\u001a\u0004\u0018\u000109J\u000e\u0010Z\u001a\u00020\"2\u0006\u0010[\u001a\u000209J\u000e\u0010\\\u001a\u00020\"2\u0006\u0010]\u001a\u000209J\u0012\u0010^\u001a\u00020\"2\n\b\u0002\u0010Y\u001a\u0004\u0018\u000109J\u0010\u0010_\u001a\u00020\"2\b\u00108\u001a\u0004\u0018\u000109J\u0010\u0010`\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0012\u0010a\u001a\u00020\"2\n\b\u0002\u00108\u001a\u0004\u0018\u000109J\u000e\u0010b\u001a\u00020\"2\u0006\u0010c\u001a\u000209J\u000e\u0010d\u001a\u00020\"2\u0006\u0010]\u001a\u000209J\u000e\u0010e\u001a\u00020\"2\u0006\u0010f\u001a\u000209J\u000e\u0010g\u001a\u00020\"2\u0006\u0010h\u001a\u000209J\u0006\u0010i\u001a\u00020\"J\b\u0010j\u001a\u00020\"H\u0002J\u0006\u0010k\u001a\u00020\"J\u0010\u0010l\u001a\u00020\"2\b\u00108\u001a\u0004\u0018\u000109J\u0010\u0010m\u001a\u0002092\u0006\u0010B\u001a\u00020CH\u0002J\u0012\u0010n\u001a\u0004\u0018\u00010\u00122\u0006\u0010B\u001a\u00020CH\u0002J\u0013\u0010o\u001a\u0004\u0018\u00010\n*\u00020pH\u0002¢\u0006\u0002\u0010qJ\f\u0010r\u001a\u00020\u0007*\u00020AH\u0002J\f\u0010s\u001a\u00020\u0007*\u00020tH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b \u0010\u0014¨\u0006w"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointGenerateEffectView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "debugAnimationDurationScale", "", "dp", "Lkotlin/Function1;", "effectTextView", "Lcom/obric/oui/texteffects/ODimPointEffectTextView;", "getEffectTextView", "()Lcom/obric/oui/texteffects/ODimPointEffectTextView;", "enterScanIndicator", "Landroid/view/View;", "getEnterScanIndicator", "()Landroid/view/View;", "exitScanIndicator", "getExitScanIndicator", "externalAnimator", "Landroid/animation/ValueAnimator;", "externalLayerBindings", "", "Lcom/obric/oui/texteffects/runtime/ExternalViewLayerBinding;", "pendingContentRewriteRunnable", "Ljava/lang/Runnable;", "promptGenerateIndicatorRunnable", "scanIndicator", "getScanIndicator", "applyExternalFrame", "", "spec", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "playTimeMs", "", "applyTextViewPaddingFromXml", "typedArray", "Landroid/content/res/TypedArray;", "applyTextViewXmlAttributes", "applyTypefaceFromXml", "typefaceValue", "textStyle", "bindExternalLayers", "buildScanIndicatorLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "buildScanIndicatorMaterial", "Lcom/obric/oui/material/MaterialConfig;", "config", "Lcom/obric/oui/texteffects/core/GradientBlurLayerSpec;", "cancelPendingContentRewriteRunnable", "cancelPromptGenerateIndicatorRunnable", "computeDisplayTextWidthPx", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "computeScanIndicatorHeightPx", "configureScanIndicator", "", "layer", "Lcom/obric/oui/texteffects/core/EffectLayer$ExternalView;", "createScanIndicator", "directionForBindingKey", "Lcom/obric/oui/texteffects/core/Direction;", "bindingKey", "", "getDebugAnimationDurationScale", "onDetachedFromWindow", "parseEllipsize", "Landroid/text/TextUtils$TruncateAt;", EventBody.KEY_VALUE, "remainingRewriteDurationMs", "resetExternalLayers", "resolvedExternalParentWidthPx", "scaledDurationMs", "durationMs", "scanIndicatorFromRatio", "(Lcom/obric/oui/texteffects/core/TextEffectSpec;Ljava/lang/String;)Ljava/lang/Float;", "setDebugAnimationDurationScale", "scale", "setEnterScanIndicatorMaterial", "setExitScanIndicatorMaterial", "setScanIndicatorMaterial", "setScanIndicatorText", "setText", "setTextWithEffect", "showContentPending", "contentText", "showPromptFailure", "failurePromptText", "showPromptPending", "promptText", "startContentPending", "startDimPointTextEffect", "startExternalLayerAnimator", "startGenerate", "startGenerateFromPromptPending", "actualText", "startPromptPending", "startPromptTextSwitch", "newPromptText", "startRewrite", "newText", "stopEffect", "stopExternalAnimator", "stopGenerate", "submitContentText", "textForBindingKey", "viewForBindingKey", "textWidthRatioOrNull", "Lcom/obric/oui/texteffects/core/EffectValue;", "(Lcom/obric/oui/texteffects/core/EffectValue;)Ljava/lang/Float;", "toMaterialBlurDirection", "toMaterialCurveType", "Lcom/obric/oui/texteffects/core/GradientBlurCurveType;", "Companion", "ScanIndicatorView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODimPointGenerateEffectView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f14567a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ODimPointEffectTextView f14568b;
    private final View c;
    private final View d;
    private final List<com.obric.oui.texteffects.runtime.c> e;
    private ValueAnimator f;
    private Runnable g;
    private Runnable h;
    private float i;
    private final Function1<Float, Integer> j;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointGenerateEffectView$Companion;", "", "()V", "EnterScanIndicatorBindingKey", "", "ExitScanIndicatorBindingKey", "Tag", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0014J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointGenerateEffectView$ScanIndicatorView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clipRect", "Landroid/graphics/Rect;", "gradientBlurRatio", "", "scanDirection", "Lcom/obric/oui/texteffects/core/Direction;", "onLayout", "", "changed", "", "left", "", "top", "right", "bottom", "setGradientBlurRatio", "ratio", "setScanDirection", "direction", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f14569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Direction f14570b;
        private float c;

        public b(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "context");
            super(r4);
            this.f14569a = new Rect();
            this.f14570b = Direction.LeftToRight;
            this.c = 1.0f;
        }

        public final void a(float r1) {
            this.c = r1;
        }

        public final void a(Direction r2) {
            Intrinsics.checkNotNullParameter(r2, "direction");
            this.f14570b = r2;
        }

        @Override // android.view.View
        public void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
            super.onLayout(r3, r4, r5, r6, r7);
            if (this.f14570b != Direction.LeftToRight) goto L5;
            this.f14569a.set(0, 0, (int) ((r6 - r4) * (this.c + 0.07f)), r7 - r5);
        L6:
            setClipBounds(this.f14569a);
            return;
        L5:
            this.f14569a.set(0, 0, r6, r7 - r5);
            goto L6
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14571a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f14572b = null;

        static {
            int[] r0 = new int[Direction.values().length];
            r0[Direction.RightToLeft.ordinal()] = 1;
            r0[Direction.LeftToRight.ordinal()] = 2;
            r0[Direction.TopToBottom.ordinal()] = 3;
            r0[Direction.BottomToTop.ordinal()] = 4;
            f14571a = r0;
            int[] r1 = new int[GradientBlurCurveType.values().length];
            r1[GradientBlurCurveType.Linear.ordinal()] = 1;
            r1[GradientBlurCurveType.InOutQuad.ordinal()] = 2;
            f14572b = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/oui/texteffects/ODimPointGenerateEffectView$startExternalLayerAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f14573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f14574b;
        final /* synthetic */ ODimPointGenerateEffectView c;

        d(Ref.BooleanRef r1, u r2, ODimPointGenerateEffectView r3) {
            this.f14573a = r1;
            this.f14574b = r2;
            this.c = r3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.f14573a.element = true;
            com.obric.oui.texteffects.a r3 = com.obric.oui.texteffects.a.f14578a;
            u r1 = this.f14574b;
            if (com.obric.oui.texteffects.a.a() == false) goto L6;
            Log.d(Intrinsics.stringPlus("OTextEff/", "DimPointGenerateView"), Intrinsics.stringPlus("external animator cancel spec=", r1.a()));
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            com.obric.oui.texteffects.a r6 = com.obric.oui.texteffects.a.f14578a;
            u r7 = this.f14574b;
            Ref.BooleanRef r0 = this.f14573a;
            if (com.obric.oui.texteffects.a.a() == false) goto L6;
            Log.d(Intrinsics.stringPlus("OTextEff/", "DimPointGenerateView"), "external animator end spec=" + r7.a() + ", canceled=" + r0.element);
        L6:
            if (this.f14573a.element == true) goto L9;
            ODimPointGenerateEffectView.a(this.c);
            return;
        }
    }

    static {
        f14567a = new a(null);
    }

    public ODimPointGenerateEffectView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public ODimPointGenerateEffectView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public ODimPointGenerateEffectView(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r13, r12);
        this.e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.i = 1.0f;
        Function1<Float, Integer> r14 = (Function1) ZeusTransformUtils.preCheckCast(new ODimPointGenerateEffectView$dp$1(this), Function1.class, "com.obric.memorydata.plugin");
        this.j = r14;
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L5;
        Log.d(Intrinsics.stringPlus("OTextEff/", "DimPointGenerateView"), "init DimPointGenerateEffectView");
    L5:
        setClipChildren(false);
        setClipToPadding(false);
        ODimPointEffectTextView r8 = new ODimPointEffectTextView(r3, null, 0, 6, null);
        r8.setGravity(16);
        r8.setIncludeFontPadding(false);
        r8.setSingleLine(true);
        r8.setPadding(((Number) ZeusTransformUtils.preCheckCast(r14.invoke(Float.valueOf(16.0f)), Number.class, "com.obric.memorydata.plugin")).intValue(), 0, ((Number) ZeusTransformUtils.preCheckCast(r14.invoke(Float.valueOf(16.0f)), Number.class, "com.obric.memorydata.plugin")).intValue(), 0);
        this.f14568b = r8;
        a(r13, r12);
        addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, ((Number) ZeusTransformUtils.preCheckCast(r14.invoke(Float.valueOf(56.0f)), Number.class, "com.obric.memorydata.plugin")).intValue(), 16), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        View r15 = h();
        this.c = r15;
        View r16 = h();
        this.d = r16;
        addView(r15, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(i(), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        addView(r16, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(i(), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        b(com.obric.oui.texteffects.preset.a.a(com.obric.oui.texteffects.preset.a.f14644a, true, 0.0f, 2, null));
        g();
    }

    public /* synthetic */ ODimPointGenerateEffectView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    static /* synthetic */ int a(ODimPointGenerateEffectView r0, o r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.a(r1);
    }

    private final int a(Direction r3) {
        int r2 = c.f14571a[r3.ordinal()];
        if (r2 != 1) goto L5;
        return 4;
    L5:
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L12;
        if (r2 == 4) goto L12;
        throw new NoWhenBranchMatchedException();
    L12:
        return 3;
    }

    private final int a(GradientBlurCurveType r1) {
        int r0 = c.f14572b[r1.ordinal()];
        if (r0 != 1) goto L5;
        return 0;
    L5:
        if (r0 != 2) goto L8;
        return 3;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private final int a(o r3) {
        Paint.FontMetrics r0 = this.f14568b.getPaint().getFontMetrics();
        float r1 = r0.descent - r0.ascent;
        if (r3 != null) goto L5;
        Float r4 = null;
    L6:
        if (r4 != null) goto L8;
        float r2 = this.f14568b.getTextSize() * 0.8889f;
    L10:
        return RangesKt.coerceAtLeast(MathKt.roundToInt((float) Math.ceil(r1 + (r2 * 2.0f))), 1);
    L8:
        r2 = r4.floatValue();
        goto L10
    L5:
        r4 = r3.a(this.f14568b.getTextSize());
        goto L6
    }

    private final long a(long r1) {
        return RangesKt.coerceAtLeast(MathKt.roundToInt(r1 * this.i), 1);
    }

    private final TextUtils.TruncateAt a(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return null;
    L17:
        return TextUtils.TruncateAt.MARQUEE;
    L18:
        return TextUtils.TruncateAt.END;
    L19:
        return TextUtils.TruncateAt.MIDDLE;
    L15:
        return TextUtils.TruncateAt.START;
    }

    private final View a(String r2) {
        if (Intrinsics.areEqual(r2, "exitScanIndicator") == false) goto L6;
        return this.c;
    L6:
        if (Intrinsics.areEqual(r2, "enterScanIndicator") == true) goto L11;
        return null;
    L11:
        return this.d;
    }

    private final Float a(m r3) {
        if (ZeusTransformUtils.instanceOf(r3, m.g.class) == false) goto L6;
        return Float.valueOf(((m.g) ZeusTransformUtils.preCheckCast(r3, m.g.class, "com.obric.memorydata.plugin")).a());
    L6:
        if (ZeusTransformUtils.instanceOf(r3, m.c.class) == true) goto L11;
        return null;
    L11:
        return a(((m.c) ZeusTransformUtils.preCheckCast(r3, m.c.class, "com.obric.memorydata.plugin")).a());
    }

    private final Float a(u r10, String r11) {
        Iterator<l> r12 = r10.d().iterator();
    L4:
        if (r12.hasNext() == false) goto L71;
        Iterator<k> r0 = ((l) ZeusTransformUtils.preCheckCast(r12.next(), l.class, "com.obric.memorydata.plugin")).e().iterator();
    L7:
        if (r0.hasNext() == false) goto L4;
        Iterator<j> r2 = ((k) ZeusTransformUtils.preCheckCast(r0.next(), k.class, "com.obric.memorydata.plugin")).b().iterator();
    L10:
        if (r2.hasNext() == false) goto L7;
        j r4 = (j) ZeusTransformUtils.preCheckCast(r2.next(), j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, j.a.class) == false) goto L10;
        if (Intrinsics.areEqual(((j.a) ZeusTransformUtils.preCheckCast(r4, j.a.class, "com.obric.memorydata.plugin")).c(), r11) == false) goto L10;
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r13.hasNext() == false) goto L25;
        Object r14 = r13.next();
        if (((t) ZeusTransformUtils.preCheckCast(r14, t.class, "com.obric.memorydata.plugin")).a() != EffectProperty.TranslationX) goto L22;
        boolean r1 = true;
    L23:
        if (r1 == false) goto L18;
    L26:
        t r15 = (t) ZeusTransformUtils.preCheckCast(r14, t.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L67;
        List<q> r16 = r15.b();
        if (r16 == null) goto L68;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r5.hasNext() == true) goto L35;
        Object r17 = null;
    L44:
        q r18 = (q) ZeusTransformUtils.preCheckCast(r17, q.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L69;
        m r19 = r18.b();
        if (r19 != null) goto L51;
        return null;
    L51:
        return a(r19);
    L69:
        return null;
    L35:
        r17 = r5.next();
        if (r5.hasNext() == false) goto L44;
        long r6 = ((q) ZeusTransformUtils.preCheckCast(r17, q.class, "com.obric.memorydata.plugin")).a();
    L39:
        Object r110 = r5.next();
        long r7 = ((q) ZeusTransformUtils.preCheckCast(r110, q.class, "com.obric.memorydata.plugin")).a();
        if (r6 <= r7) goto L43;
        r17 = r110;
        r6 = r7;
    L43:
        if (r5.hasNext() == true) goto L39;
    L68:
        return null;
    L67:
        return null;
    L22:
        r1 = false;
        goto L23
    L25:
        r14 = null;
        goto L26
    L71:
        return null;
    }

    private final void a(int r3, int r4) {
        if (r4 < 0) goto L4;
        int r0 = r4;
    L6:
        if (r3 != 1) goto L8;
        Typeface r1 = Typeface.SANS_SERIF;
    L15:
        if (r3 >= 0) goto L17;
        if (r4 >= 0) goto L17;
        return;
    L17:
        this.f14568b.setTypeface(r1, r0);
        return;
    L8:
        if (r3 != 2) goto L10;
        r1 = Typeface.SERIF;
        goto L15
    L10:
        if (r3 == 3) goto L12;
        r1 = this.f14568b.getTypeface();
        goto L15
    L12:
        r1 = Typeface.MONOSPACE;
        goto L15
    L4:
        r0 = 0;
        goto L6
    }

    private final void a(TypedArray r9) {
        int r0 = this.f14568b.getPaddingLeft();
        int r1 = this.f14568b.getPaddingTop();
        int r2 = this.f14568b.getPaddingRight();
        int r3 = this.f14568b.getPaddingBottom();
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_padding, "styleable", "ODimPointGenerateEffectView_android_padding")) == false) goto L5;
        Integer r4 = Integer.valueOf(r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_padding, "styleable", "ODimPointGenerateEffectView_android_padding"), 0));
    L6:
        if (r4 == null) goto L9;
        r0 = r4.intValue();
    L9:
        if (r4 == null) goto L12;
        r1 = r4.intValue();
    L12:
        if (r4 == null) goto L15;
        r2 = r4.intValue();
    L15:
        if (r4 == null) goto L19;
        r3 = r4.intValue();
    L19:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingLeft, "styleable", "ODimPointGenerateEffectView_android_paddingLeft")) == false) goto L22;
        r0 = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingLeft, "styleable", "ODimPointGenerateEffectView_android_paddingLeft"), r0);
    L22:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingTop, "styleable", "ODimPointGenerateEffectView_android_paddingTop")) == false) goto L25;
        r1 = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingTop, "styleable", "ODimPointGenerateEffectView_android_paddingTop"), r1);
    L25:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingRight, "styleable", "ODimPointGenerateEffectView_android_paddingRight")) == false) goto L28;
        r2 = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingRight, "styleable", "ODimPointGenerateEffectView_android_paddingRight"), r2);
    L28:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingBottom, "styleable", "ODimPointGenerateEffectView_android_paddingBottom")) == false) goto L31;
        r3 = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingBottom, "styleable", "ODimPointGenerateEffectView_android_paddingBottom"), r3);
    L31:
        if (Build.VERSION.SDK_INT >= 17) goto L33;
    L38:
        this.f14568b.setPadding(r0, r1, r2, r3);
        return;
    L33:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingStart, "styleable", "ODimPointGenerateEffectView_android_paddingStart")) == false) goto L36;
        r0 = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingStart, "styleable", "ODimPointGenerateEffectView_android_paddingStart"), r0);
    L36:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingEnd, "styleable", "ODimPointGenerateEffectView_android_paddingEnd")) == false) goto L38;
        r2 = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_paddingEnd, "styleable", "ODimPointGenerateEffectView_android_paddingEnd"), r2);
        goto L38
    L5:
        r4 = (Integer) ZeusTransformUtils.preCheckCast(null, Integer.class, "com.obric.memorydata.plugin");
        goto L6
    }

    private final void a(AttributeSet r23, int r24) {
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r23, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        if (r24 != 0) goto L6;
        return;
    L6:
        TypedArray r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r4, R.styleable.ODimPointGenerateEffectView, r24, 0);
        Intrinsics.checkNotNullExpressionValue(r1, "context.obtainStyledAttr…ectView, defStyleAttr, 0)");
    L68:
        th = move-exception;
        r1.recycle();
        throw th;
    L8:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textAppearance, "styleable", "ODimPointGenerateEffectView_android_textAppearance")) == false) goto L13;
        int r2 = r1.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textAppearance, "styleable", "ODimPointGenerateEffectView_android_textAppearance"), 0);     // Catch: Throwable -> L68
        if (r2 == 0) goto L13;
        this.f14568b.setTextAppearance(r2);     // Catch: Throwable -> L68
    L13:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_text, "styleable", "ODimPointGenerateEffectView_android_text")) == false) goto L16;
        this.f14568b.setText(r1.getText(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_text, "styleable", "ODimPointGenerateEffectView_android_text")));     // Catch: Throwable -> L68
    L16:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_hint, "styleable", "ODimPointGenerateEffectView_android_hint")) == false) goto L19;
        this.f14568b.setHint(r1.getText(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_hint, "styleable", "ODimPointGenerateEffectView_android_hint")));     // Catch: Throwable -> L68
    L19:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textColor, "styleable", "ODimPointGenerateEffectView_android_textColor")) == false) goto L25;
        ColorStateList r3 = r1.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textColor, "styleable", "ODimPointGenerateEffectView_android_textColor"));     // Catch: Throwable -> L68
        if (r3 == null) goto L25;
        getEffectTextView().setTextColor(r3);     // Catch: Throwable -> L68
    L25:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textColorHint, "styleable", "ODimPointGenerateEffectView_android_textColorHint")) == false) goto L31;
        ColorStateList r5 = r1.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textColorHint, "styleable", "ODimPointGenerateEffectView_android_textColorHint"));     // Catch: Throwable -> L68
        if (r5 == null) goto L31;
        getEffectTextView().setHintTextColor(r5);     // Catch: Throwable -> L68
    L31:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textSize, "styleable", "ODimPointGenerateEffectView_android_textSize")) == false) goto L33;
        this.f14568b.setTextSize(0, r1.getDimension(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textSize, "styleable", "ODimPointGenerateEffectView_android_textSize"), this.f14568b.getTextSize()));     // Catch: Throwable -> L68
    L33:
        a(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_typeface, "styleable", "ODimPointGenerateEffectView_android_typeface"), -1), r1.getInt(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_textStyle, "styleable", "ODimPointGenerateEffectView_android_textStyle"), -1));     // Catch: Throwable -> L68
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_gravity, "styleable", "ODimPointGenerateEffectView_android_gravity")) == false) goto L37;
        this.f14568b.setGravity(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_gravity, "styleable", "ODimPointGenerateEffectView_android_gravity"), this.f14568b.getGravity()));     // Catch: Throwable -> L68
    L37:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_includeFontPadding, "styleable", "ODimPointGenerateEffectView_android_includeFontPadding")) == false) goto L40;
        this.f14568b.setIncludeFontPadding(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_includeFontPadding, "styleable", "ODimPointGenerateEffectView_android_includeFontPadding"), this.f14568b.getIncludeFontPadding()));     // Catch: Throwable -> L68
    L40:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_singleLine, "styleable", "ODimPointGenerateEffectView_android_singleLine")) == false) goto L43;
        this.f14568b.setSingleLine(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_singleLine, "styleable", "ODimPointGenerateEffectView_android_singleLine"), true));     // Catch: Throwable -> L68
    L43:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_lines, "styleable", "ODimPointGenerateEffectView_android_lines")) == false) goto L46;
        this.f14568b.setLines(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_lines, "styleable", "ODimPointGenerateEffectView_android_lines"), 1));     // Catch: Throwable -> L68
    L46:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_minLines, "styleable", "ODimPointGenerateEffectView_android_minLines")) == false) goto L49;
        this.f14568b.setMinLines(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_minLines, "styleable", "ODimPointGenerateEffectView_android_minLines"), 1));     // Catch: Throwable -> L68
    L49:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_maxLines, "styleable", "ODimPointGenerateEffectView_android_maxLines")) == false) goto L52;
        this.f14568b.setMaxLines(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_maxLines, "styleable", "ODimPointGenerateEffectView_android_maxLines"), Integer.MAX_VALUE));     // Catch: Throwable -> L68
    L52:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_ellipsize, "styleable", "ODimPointGenerateEffectView_android_ellipsize")) == false) goto L56;
        this.f14568b.setEllipsize(a(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_ellipsize, "styleable", "ODimPointGenerateEffectView_android_ellipsize"), 0)));     // Catch: Throwable -> L68
    L56:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_lineSpacingExtra, "styleable", "ODimPointGenerateEffectView_android_lineSpacingExtra")) == false) goto L58;
    L59:
        float r6 = r1.getDimension(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_lineSpacingExtra, "styleable", "ODimPointGenerateEffectView_android_lineSpacingExtra"), 0.0f);     // Catch: Throwable -> L68
        float r7 = r1.getFloat(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_lineSpacingMultiplier, "styleable", "ODimPointGenerateEffectView_android_lineSpacingMultiplier"), 1.0f);     // Catch: Throwable -> L68
        this.f14568b.setLineSpacing(r6, r7);     // Catch: Throwable -> L68
    L61:
        if (Build.VERSION.SDK_INT >= 21) goto L63;
    L65:
        a(r1);     // Catch: Throwable -> L68
        r1.recycle();
        return;
    L63:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_letterSpacing, "styleable", "ODimPointGenerateEffectView_android_letterSpacing")) == false) goto L65;
        this.f14568b.setLetterSpacing(r1.getFloat(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_letterSpacing, "styleable", "ODimPointGenerateEffectView_android_letterSpacing"), this.f14568b.getLetterSpacing()));     // Catch: Throwable -> L68
        goto L65
    L58:
        if (r1.hasValue(ZeusTransformUtils.mapRes(R.styleable.ODimPointGenerateEffectView_android_lineSpacingMultiplier, "styleable", "ODimPointGenerateEffectView_android_lineSpacingMultiplier")) == false) goto L61;
        goto L59
    }

    public static final /* synthetic */ void a(ODimPointGenerateEffectView r0) {
        r0.g();
    }

    private static final void a(ODimPointGenerateEffectView r1, u r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$spec");
        r1.g = null;
        r1.a(r2);
    }

    private static final void a(ODimPointGenerateEffectView r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r4, "$newText");
        r2.h = null;
        r2.d(r4);
    }

    private final void a(final u r6) {
        c();
        b(r6);
        Ref.BooleanRef r0 = new Ref.BooleanRef();
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.setDuration(a(r6.b()));
        r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new LinearInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r1.addUpdateListener(new $$Lambda$ODimPointGenerateEffectView$mHO_U8koj23r8lgtpVYkdjqlM4(r6, this));
        r1.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new d(r0, r6, this), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r1.start();
        this.f = r1;
    }

    private final void a(u r3, long r4) {
        h r5 = com.obric.oui.texteffects.runtime.m.f14709a.a(r3, r4);
        com.obric.oui.texteffects.runtime.b.f14688a.a(r5, (Collection) ZeusTransformUtils.preCheckCast(this.e, Collection.class, "com.obric.memorydata.plugin"), b());
    }

    private static final void a(u r4, ODimPointGenerateEffectView r5, ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r4, "$spec");
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r6, "animator");
        long r0 = (long) (r6.getAnimatedFraction() * r4.b());
        com.obric.oui.texteffects.a r7 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == true) goto L5;
    L7:
        r5.a(r4, r0);
        return;
    L5:
        if (com.obric.oui.texteffects.a.b() == false) goto L7;
        Log.d(Intrinsics.stringPlus("OTextEff/frame/", "DimPointGenerateView"), "external animator update spec=" + r4.a() + ", playTime=" + r0);
        goto L7
    }

    private final void a(String r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        View r2 = a(r3);
        if (r2 == null) goto L7;
        r2.setTag(r5);
        return;
    }

    private final boolean a(j.a r19, CharSequence r20, u r21) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r20, CharSequence.class, "com.obric.memorydata.plugin");
        String r11 = r19.c();
        View r5 = a(r11);
        if (r5 != null) goto L5;
        return false;
    L5:
        r5.setTag(r1);
        float r6 = RangesKt.coerceAtLeast(e(r1), 1.0f);
        Float r7 = a(r21, r11);
        if (r7 != null) goto L11;
        ODimPointGenerateEffectView r0 = (ODimPointGenerateEffectView) ZeusTransformUtils.preCheckCast(this, ODimPointGenerateEffectView.class, "com.obric.memorydata.plugin");
        com.obric.oui.texteffects.a r2 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L10;
        Log.d(Intrinsics.stringPlus("OTextEff/", "DimPointGenerateView"), "skip configure indicator, missing fromRatio bindingKey=" + r11 + ", spec=" + r21.a());
    L10:
        return false;
    L11:
        float r14 = r7.floatValue();
        int r10 = RangesKt.coerceAtLeast(MathKt.roundToInt(r6), 1);
        int r9 = a(r19.d());
        ViewGroup.LayoutParams r3 = r5.getLayoutParams();
        Direction r8 = null;
        if (ZeusTransformUtils.instanceOf(r3, FrameLayout.LayoutParams.class) == false) goto L14;
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L16:
        if (r4 != null) goto L20;
        r4 = new FrameLayout.LayoutParams(r10, r9, 19);
    L18:
        r5.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L24:
        r5.measure(View.MeasureSpec.makeMeasureSpec(r10, 1073741824), View.MeasureSpec.makeMeasureSpec(r9, 1073741824));
        o r12 = r19.d();
        if (r12 == null) goto L28;
        r8 = r12.a();
    L28:
        if (r8 != null) goto L31;
        r8 = c(r11);
    L31:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L33;
        ((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin")).a(r8);
    L33:
        com.obric.oui.material.c r13 = b(r19.d());
        if (r13 != null) goto L37;
    L42:
        ((Collection) ZeusTransformUtils.preCheckCast(this.e, Collection.class, "com.obric.memorydata.plugin")).add(new com.obric.oui.texteffects.runtime.c(r11, r5, r6, 0, 0.0f, 24, null));
        com.obric.oui.texteffects.a r15 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L47;
        Log.d(Intrinsics.stringPlus("OTextEff/", "DimPointGenerateView"), "configure indicator bindingKey=" + r11 + ", fromRatio=" + r14 + ", text=\\{" + r1 + "\\}, width=" + r10 + ", height=" + r9 + ", blur=" + r19.d());
        return true;
    L47:
        return true;
    L37:
        if (r13.g() != null) goto L39;
    L41:
        OMaterialHelper.a(r5, r13);
        goto L42
    L39:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L41;
        b r16 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        com.obric.oui.blur.a r17 = r13.g();
        Intrinsics.checkNotNull(r17);
        r16.a(r17.e());
        goto L41
    L20:
        if (r4.width == r10) goto L22;
    L23:
        r4.width = r10;
        r4.height = r9;
        r4.gravity = 19;
        goto L18
    L22:
        if (r4.height == r9) goto L24;
    L14:
        r4 = null;
        goto L16
    }

    private final float b() {
        Integer r0 = Integer.valueOf(getWidth());
        boolean r3 = true;
        int r4 = 0;
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        Integer r5 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 != null) goto L36;
        r0 = Integer.valueOf(getMeasuredWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L18;
        r0 = null;
    L18:
        if (r0 != null) goto L36;
        r0 = Integer.valueOf(this.f14568b.getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == true) goto L26;
        r0 = null;
    L26:
        if (r0 != null) goto L36;
        Integer r7 = Integer.valueOf(this.f14568b.getMeasuredWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L31;
        r3 = false;
    L31:
        if (r3 == false) goto L33;
        r5 = r7;
    L33:
        if (r5 == null) goto L38;
        r4 = r5.intValue();
    L38:
        return r4;
    L22:
        r6 = false;
        goto L23
    L14:
        r2 = false;
    L36:
        r4 = r0.intValue();
        goto L38
    L5:
        r1 = false;
        goto L6
    }

    private final com.obric.oui.material.c b(o r20) {
        if (r20 != null) goto L5;
        return null;
    L5:
        Float r3 = r20.a(this.f14568b.getTextSize());
        if (r3 != null) goto L8;
        return null;
    L8:
        float r5 = r3.floatValue();
        return new com.obric.oui.material.c(null, null, OMaterialHelper.a(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.array.oui_no_gradient_blur_colors, "array", "oui_no_gradient_blur_colors"), ZeusTransformUtils.mapRes(R.array.oui_no_gradient_blur_blend_modes, "array", "oui_no_gradient_blur_blend_modes")), null, null, null, new com.obric.oui.blur.a(r5, a(r20.a()), 0.0f, a(r20.b()), RangesKt.coerceAtLeast(r20.c(), 0.0f), 4, null), null, null, null, 955, null);
    }

    private final CharSequence b(String r4) {
        CharSequence r2 = null;
        if (Intrinsics.areEqual(r4, "exitScanIndicator") == false) goto L8;
        Object r5 = this.c.getTag();
        if (ZeusTransformUtils.instanceOf(r5, CharSequence.class) == false) goto L12;
    L6:
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
    L12:
        if (r2 != null) goto L14;
        r2 = this.f14568b.getText();
    L14:
        if (r2 == null) goto L16;
        return r2;
    L16:
        return (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L8:
        if (Intrinsics.areEqual(r4, "enterScanIndicator") == false) goto L12;
        r5 = this.d.getTag();
        if (ZeusTransformUtils.instanceOf(r5, CharSequence.class) == false) goto L12;
        goto L12
    }

    private final void b(u r11) {
        this.e.clear();
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<l> r1 = r11.d().iterator();
    L4:
        if (r1.hasNext() == false) goto L22;
        l r2 = (l) ZeusTransformUtils.preCheckCast(r1.next(), l.class, "com.obric.memorydata.plugin");
        Iterator<k> r3 = r2.e().iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        Iterator<j> r5 = ((k) ZeusTransformUtils.preCheckCast(r3.next(), k.class, "com.obric.memorydata.plugin")).b().iterator();
    L10:
        if (r5.hasNext() == false) goto L7;
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5.next(), j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, j.a.class) == false) goto L10;
        if (r0.add(((j.a) ZeusTransformUtils.preCheckCast(r6, j.a.class, "com.obric.memorydata.plugin")).c()) == false) goto L10;
        if (a((j.a) ZeusTransformUtils.preCheckCast(r6, j.a.class, "com.obric.memorydata.plugin"), b(((j.a) ZeusTransformUtils.preCheckCast(r6, j.a.class, "com.obric.memorydata.plugin")).c()), r11) == false) goto L10;
        com.obric.oui.texteffects.a r7 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L10;
        Log.d(Intrinsics.stringPlus("OTextEff/", "DimPointGenerateView"), "bind external layer stage=" + r2.a() + ", id=" + r6.a() + ", bindingKey=" + ((j.a) ZeusTransformUtils.preCheckCast(r6, j.a.class, "com.obric.memorydata.plugin")).c());
        goto L10
    }

    private final Direction c(String r1) {
        if (Intrinsics.areEqual(r1, "exitScanIndicator") == true) goto L7;
        Intrinsics.areEqual(r1, "enterScanIndicator");
        return Direction.LeftToRight;
    L7:
        return Direction.RightToLeft;
    }

    private final void c() {
        if (this.f == null) goto L7;
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L7;
        Log.d(Intrinsics.stringPlus("OTextEff/", "DimPointGenerateView"), "stopExternalAnimator");
    L7:
        ValueAnimator r1 = this.f;
        if (r1 == null) goto L11;
        r1.cancel();
    L11:
        this.f = null;
        g();
    }

    private final void d() {
        Runnable r0 = this.g;
        if (r0 == null) goto L6;
        removeCallbacks(r0);
    L6:
        this.g = null;
    }

    private final float e(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        float r0 = RangesKt.coerceAtLeast((this.f14568b.getWidth() - this.f14568b.getCompoundPaddingLeft()) - this.f14568b.getCompoundPaddingRight(), 0.0f);
        if (this.f14568b.getEllipsize() != null) goto L5;
    L7:
        com.obric.oui.texteffects.a r1 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L11;
        Log.d(Intrinsics.stringPlus("OTextEff/", "DimPointGenerateView"), Intrinsics.stringPlus("computeDisplayTextWidthPx ", r5));
    L11:
        return this.f14568b.getPaint().measureText(r5, 0, r5.length());
    L5:
        if (r0 <= 0.0f) goto L7;
        r5 = TextUtils.ellipsize(r5, this.f14568b.getPaint(), r0, this.f14568b.getEllipsize());
        goto L7
    }

    private final void e() {
        Runnable r0 = this.h;
        if (r0 == null) goto L6;
        removeCallbacks(r0);
    L6:
        this.h = null;
    }

    private final long f() {
        return a(RangesKt.coerceAtLeast(com.obric.oui.texteffects.preset.a.a(com.obric.oui.texteffects.preset.a.f14644a, true, 0.0f, 2, null).b() - this.f14568b.e(), 1));
    }

    private final void g() {
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.obric.oui.texteffects.runtime.c) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.oui.texteffects.runtime.c.class, "com.obric.memorydata.plugin")).c();
        goto L4
    }

    private final View h() {
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        b r0 = new b(r3);
        r0.setAlpha(1.0f);
        r0.setVisibility(4);
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    }

    private final FrameLayout.LayoutParams i() {
        return new FrameLayout.LayoutParams(((Number) ZeusTransformUtils.preCheckCast(this.j.invoke(Float.valueOf(16.0f)), Number.class, "com.obric.memorydata.plugin")).intValue(), a(this, null, 1, null), 19);
    }

    /* JADX INFO: renamed from: lambda$4Ji-rF1komCGZNg0OWRcqsZZJ1k, reason: not valid java name */
    public static /* synthetic */ void m1375lambda$4JirF1komCGZNg0OWRcqsZZJ1k(ODimPointGenerateEffectView r0, CharSequence r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$915GCIVTLmSNEOMEgXact_5cK8U(ODimPointGenerateEffectView r0, u r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$mHO_U8k-oj23r8lgtpVYkdjqlM4, reason: not valid java name */
    public static /* synthetic */ void m1376lambda$mHO_U8koj23r8lgtpVYkdjqlM4(u r0, ODimPointGenerateEffectView r1, ValueAnimator r2) {
        a(r0, r1, r2);
    }

    public final void a() {
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L5;
        Log.d(Intrinsics.stringPlus("OTextEff/", "DimPointGenerateView"), "stopEffect");
    L5:
        d();
        e();
        c();
        this.f14568b.f();
    }

    public final void a(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        d();
        e();
        u r0 = com.obric.oui.texteffects.preset.a.f14644a.a(true);
        this.f14568b.setDebugAnimationDurationScale(this.i);
        this.f14568b.c(r6);
        CharSequence r7 = this.f14568b.getText();
        if (r7 != null) goto L5;
        r7 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L5:
        a("enterScanIndicator", r7);
        a(r0);
    }

    public final void b(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r0 = this.f14568b.getText();
        if (r0 != null) goto L5;
        r0 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L5:
        if (r6 != null) goto L7;
        r6 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L7:
        boolean r2 = true;
        if (this.f14568b.b() == true) goto L10;
    L16:
        boolean r1 = TextUtils.equals(r0, r6);
        int r3 = r0.length();
        if (r1 == false) goto L23;
        if (r3 == 0) goto L21;
        r2 = false;
    L21:
        if (r2 == false) goto L30;
        a();
        this.f14568b.setText(r6);
        return;
    L30:
        return;
    L23:
        if (r3 == 0) goto L26;
        r2 = false;
    L26:
        if (r2 == false) goto L28;
        a(r6);
        return;
    L28:
        d(r6);
        return;
    L10:
        if (r6.length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L16;
        c(r6);
        return;
    L12:
        r4 = false;
        goto L13
    }

    public final void c(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "actualText");
        d();
        e();
        if (this.f14568b.b() == true) goto L6;
        a(r4);
        return;
    L6:
        c();
        this.f14568b.setDebugAnimationDurationScale(this.i);
        this.f14568b.b(r4);
        final u r0 = com.obric.oui.texteffects.preset.a.f14644a.a(true);
        a("enterScanIndicator", r4);
        Runnable r5 = new $$Lambda$ODimPointGenerateEffectView$915GCIVTLmSNEOMEgXact_5cK8U(this, r0);
        this.g = r5;
        postDelayed(r5, a(150));
    }

    public final void d(CharSequence r7) {
        final CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "newText");
        d();
        e();
        u r0 = com.obric.oui.texteffects.preset.a.a(com.obric.oui.texteffects.preset.a.f14644a, true, 0.0f, 2, null);
        if (this.f14568b.c() == false) goto L7;
        this.f14568b.d(r8);
        a("enterScanIndicator", r8);
        b(r0);
        return;
    L7:
        if (this.f14568b.d() == false) goto L10;
        Runnable r1 = new $$Lambda$ODimPointGenerateEffectView$4JirF1komCGZNg0OWRcqsZZJ1k(this, r8);
        this.h = r1;
        postDelayed(r1, f());
        return;
    L10:
        CharSequence r2 = this.f14568b.getText();
        if (r2 != null) goto L13;
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L13:
        this.f14568b.setDebugAnimationDurationScale(this.i);
        this.f14568b.d(r8);
        a("exitScanIndicator", r2);
        a("enterScanIndicator", r8);
        a(r0);
    }

    public final float getDebugAnimationDurationScale() {
        return this.i;
    }

    public final ODimPointEffectTextView getEffectTextView() {
        return this.f14568b;
    }

    public final View getEnterScanIndicator() {
        return this.d;
    }

    public final View getExitScanIndicator() {
        return this.c;
    }

    public final View getScanIndicator() {
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L5;
        Log.d(Intrinsics.stringPlus("OTextEff/", "DimPointGenerateView"), "onDetachedFromWindow");
    L5:
        a();
        super.onDetachedFromWindow();
    }

    public final void setDebugAnimationDurationScale(float r4) {
        if (Float.isNaN(r4) == false) goto L5;
    L8:
        float r5 = 1.0f;
    L10:
        if (this.i != r5) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
        return;
    L15:
        this.i = r5;
        com.obric.oui.texteffects.a r1 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L18;
        Log.d(Intrinsics.stringPlus("OTextEff/", "DimPointGenerateView"), Intrinsics.stringPlus("setDebugAnimationDurationScale scale=", Float.valueOf(r5)));
    L18:
        this.f14568b.setDebugAnimationDurationScale(r5);
        return;
    L12:
        r0 = false;
        goto L13
    L5:
        if (Float.isInfinite(r4) == true) goto L8;
        r5 = RangesKt.coerceIn(r4, 0.1f, 10.0f);
        goto L10
    }

    public final void setEnterScanIndicatorMaterial(com.obric.oui.material.c r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        OMaterialHelper.a(this.d, r2);
    }

    public final void setExitScanIndicatorMaterial(com.obric.oui.material.c r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        OMaterialHelper.a(this.c, r2);
    }

    public final void setScanIndicatorMaterial(com.obric.oui.material.c r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        setEnterScanIndicatorMaterial(r2);
    }

    public final void setText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        a();
        this.f14568b.setText(r4);
    }

    public final void setTextWithEffect(CharSequence r3) {
        b((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }
}
