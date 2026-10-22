package com.obric.oui.indicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 .2\u00020\u0001:\u0005-./01B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000eJ\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u001e\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\fJ*\u0010#\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$H\u0002J&\u0010&\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010'\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160)H\u0002J \u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator;", "", "trackView", "Landroid/view/View;", "interpolator", "Landroid/animation/TimeInterpolator;", "host", "Lcom/obric/oui/indicator/IndicatorAnimator$Host;", "(Landroid/view/View;Landroid/animation/TimeInterpolator;Lcom/obric/oui/indicator/IndicatorAnimator$Host;)V", "activeViewportTransition", "Lcom/obric/oui/indicator/IndicatorAnimator$ActiveViewportTransition;", "lastScrollAnchorOffset", "", "lastViewportState", "Lcom/obric/oui/indicator/IndicatorViewportState;", LocationMonitorConst.TAG, "", "getTag", "()Ljava/lang/String;", "viewportTransitionToken", "", "cancelTrackAnimation", "", "commitViewportTransition", "transition", "currentViewportState", "render", InfoRequestQPSOptTraceLogger.REASON, "Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "nextViewportState", "resetViewportTransitionVisuals", "resolveScrollViewportAnchorPosition", "selectedPosition", "nextPosition", "positionOffset", "shouldAnimateViewportTransition", "", "viewportRangeChanged", "startTrackTranslationAnimation", "targetTranslationX", "onComplete", "Lkotlin/Function0;", "startViewportTransition", "sourceState", "targetState", "ActiveViewportTransition", "Companion", "Host", "RenderReason", "ScrollDirection", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IndicatorAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13921a = null;
    private static final boolean j = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f13922b;
    private final TimeInterpolator c;
    private final c d;
    private final String e;
    private com.obric.oui.indicator.c f;
    private a g;
    private int h;
    private float i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "", "logValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getLogValue", "()Ljava/lang/String;", "SCROLL", "REFRESH_DOTS", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum RenderReason extends Enum<RenderReason> {
        private static final /* synthetic */ RenderReason[] $VALUES = null;
        public static final RenderReason REFRESH_DOTS = null;
        public static final RenderReason SCROLL = null;
        private final String logValue;

        private static final /* synthetic */ RenderReason[] $values() {
            return new RenderReason[]{SCROLL, REFRESH_DOTS};
        }

        static {
            SCROLL = new RenderReason("SCROLL", 0, "scroll");
            REFRESH_DOTS = new RenderReason("REFRESH_DOTS", 1, "refreshDots");
            $VALUES = $values();
        }

        private RenderReason(String r1, int r2, String r3) {
            super(r1, r2);
            this.logValue = r3;
        }

        public static RenderReason valueOf(String r2) {
            return (RenderReason) ZeusTransformUtils.preCheckCast(Enum.valueOf(RenderReason.class, r2), RenderReason.class, "com.obric.memorydata.plugin");
        }

        public static RenderReason[] values() {
            return (RenderReason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RenderReason[].class, "com.obric.memorydata.plugin");
        }

        public final String getLogValue() {
            return this.logValue;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator$ScrollDirection;", "", "(Ljava/lang/String;I)V", "FORWARD", "BACKWARD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final enum ScrollDirection extends Enum<ScrollDirection> {
        private static final /* synthetic */ ScrollDirection[] $VALUES = null;
        public static final ScrollDirection BACKWARD = null;
        public static final ScrollDirection FORWARD = null;

        private static final /* synthetic */ ScrollDirection[] $values() {
            return new ScrollDirection[]{FORWARD, BACKWARD};
        }

        static {
            FORWARD = new ScrollDirection("FORWARD", 0);
            BACKWARD = new ScrollDirection("BACKWARD", 1);
            $VALUES = $values();
        }

        private ScrollDirection(String r1, int r2) {
            super(r1, r2);
        }

        public static ScrollDirection valueOf(String r2) {
            return (ScrollDirection) ZeusTransformUtils.preCheckCast(Enum.valueOf(ScrollDirection.class, r2), ScrollDirection.class, "com.obric.memorydata.plugin");
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ScrollDirection[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0011\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator$ActiveViewportTransition;", "", "transitionToken", "", "sourceState", "Lcom/obric/oui/indicator/IndicatorViewportState;", "targetState", "direction", "Lcom/obric/oui/indicator/IndicatorViewportShiftDirection;", InfoRequestQPSOptTraceLogger.REASON, "Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "(ILcom/obric/oui/indicator/IndicatorViewportState;Lcom/obric/oui/indicator/IndicatorViewportState;Lcom/obric/oui/indicator/IndicatorViewportShiftDirection;Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;)V", "getDirection", "()Lcom/obric/oui/indicator/IndicatorViewportShiftDirection;", "getReason", "()Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "getSourceState", "()Lcom/obric/oui/indicator/IndicatorViewportState;", "getTargetState", "setTargetState", "(Lcom/obric/oui/indicator/IndicatorViewportState;)V", "getTransitionToken", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f13923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.oui.indicator.c f13924b;
        private com.obric.oui.indicator.c c;
        private final IndicatorViewportShiftDirection d;
        private final RenderReason e;

        public a(int r2, com.obric.oui.indicator.c r3, com.obric.oui.indicator.c r4, IndicatorViewportShiftDirection r5, RenderReason r6) {
            Intrinsics.checkNotNullParameter(r3, "sourceState");
            Intrinsics.checkNotNullParameter(r4, "targetState");
            Intrinsics.checkNotNullParameter(r5, "direction");
            Intrinsics.checkNotNullParameter(r6, InfoRequestQPSOptTraceLogger.REASON);
            this.f13923a = r2;
            this.f13924b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final int a() {
            return this.f13923a;
        }

        public final com.obric.oui.indicator.c b() {
            return this.f13924b;
        }

        public final com.obric.oui.indicator.c c() {
            return this.c;
        }

        public final RenderReason d() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f13923a == r6.f13923a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13924b, r6.f13924b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.f13923a) * 31) + this.f13924b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "ActiveViewportTransition(transitionToken=" + this.f13923a + ", sourceState=" + this.f13924b + ", targetState=" + this.c + ", direction=" + this.d + ", reason=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator$Companion;", "", "()V", "DURATION_MS", "", "IF_DEBUG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\tH&J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0010H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator$Host;", "", "maxVisibleDots", "", "getMaxVisibleDots", "()I", "pagerCount", "getPagerCount", "applyViewportState", "", "state", "Lcom/obric/oui/indicator/IndicatorViewportState;", "applyViewportTransitionProgress", "sourceState", "targetState", "progress", "", "cancelVisibleDotAnimations", "rebindVisibleSlots", InfoRequestQPSOptTraceLogger.REASON, "Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "resolveViewportStepDistance", "shouldRebindVisibleSlots", "", "targetRange", "Lkotlin/ranges/IntRange;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface c {
        int a();

        void a(com.obric.oui.indicator.c r1);

        void a(com.obric.oui.indicator.c r1, RenderReason r2);

        void a(com.obric.oui.indicator.c r1, com.obric.oui.indicator.c r2, float r3);

        boolean a(IntRange r1);

        int b();

        float c();
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13925a = null;

        static {
            int[] r0 = new int[ScrollDirection.values().length];
            r0[ScrollDirection.BACKWARD.ordinal()] = 1;
            r0[ScrollDirection.FORWARD.ordinal()] = 2;
            f13925a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"com/obric/oui/indicator/IndicatorAnimator$startTrackTranslationAnimation$2", "Landroid/animation/AnimatorListenerAdapter;", "wasCancelled", "", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IndicatorAnimator f13926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f13927b;
        final /* synthetic */ Function0<Unit> c;
        private boolean d;

        e(IndicatorAnimator r3, a r4, Function0<Unit> r5) {
            Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            this.f13926a = r3;
            this.f13927b = r4;
            this.c = r6;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.d = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            IndicatorAnimator.a(this.f13926a).animate().setUpdateListener(null).setListener(null);
            if (this.d == false) goto L5;
            return;
        L5:
            a r4 = IndicatorAnimator.b(this.f13926a);
            boolean r0 = false;
            if (r4 != null) goto L9;
        L11:
            if (r0 == true) goto L13;
            return;
        L13:
            this.c.invoke();
            return;
        L9:
            if (r4.a() != this.f13927b.a()) goto L11;
            r0 = true;
            goto L11
        }
    }

    static {
        f13921a = new b(null);
    }

    public IndicatorAnimator(View r3, TimeInterpolator r4, c r5) {
        TimeInterpolator r6 = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r4, TimeInterpolator.class, "com.obric.memorydata.plugin");
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "trackView");
        Intrinsics.checkNotNullParameter(r6, "interpolator");
        Intrinsics.checkNotNullParameter(r7, "host");
        this.f13922b = r3;
        this.c = r6;
        this.d = r7;
        this.e = "OCarouselIndicator";
    }

    public static final /* synthetic */ View a(IndicatorAnimator r0) {
        return r0.f13922b;
    }

    private final void a(a r7) {
        a r0 = this.g;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        com.obric.oui.indicator.c r2 = r0.c();
        this.d.a(r2, r0.d());
        this.f = r2;
        this.d.a(r2);
        boolean r3 = j;
        if (r3 == false) goto L13;
        com.obric.oui.c.a.b.b(this.e, "Commit viewport transition, token=" + r7.a() + " range=" + r2.b());
    L13:
        c();
        this.g = null;
        if (r3 == false) goto L17;
        com.obric.oui.c.a.b.b(this.e, "Finish viewport transition after commit, token=" + r7.a() + " range=" + r2.b());
        return;
    L17:
        return;
    L6:
        if (r0.a() != r7.a()) goto L8;
        r1 = true;
        goto L8
    }

    private final void a(final a r5, float r6, Function0<Unit> r7) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        d();
        final float r0 = Math.abs(r6);
        this.f13922b.animate().translationX(r6).setDuration(300).setInterpolator(this.c).setUpdateListener(new $$Lambda$IndicatorAnimator$BIoUdRmdHh2V5uzgtKAkup8cRA(this, r5, r0)).setListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new e(this, r5, r8), Animator.AnimatorListener.class, "com.obric.memorydata.plugin")).start();
    }

    public static final /* synthetic */ void a(IndicatorAnimator r0, a r1) {
        r0.a(r1);
    }

    private static final void a(IndicatorAnimator r2, a r3, float r4, ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$transition");
        Intrinsics.checkNotNullParameter(r5, "it");
        a r6 = r2.g;
        boolean r0 = false;
        if (r6 != null) goto L6;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        float r7 = Math.abs(r2.f13922b.getTranslationX()) / r4;
        r2.d.a(r3.b(), r3.c(), r7);
        return;
    L6:
        if (r6.a() != r3.a()) goto L8;
        r0 = true;
        goto L8
    }

    private final void a(com.obric.oui.indicator.c r12, com.obric.oui.indicator.c r13, RenderReason r14) {
        IndicatorViewportShiftDirection r0 = com.obric.oui.indicator.d.a(r12.b(), r13.b());
        if (r0 != null) goto L6;
        IndicatorAnimator r11 = (IndicatorAnimator) ZeusTransformUtils.preCheckCast(this, IndicatorAnimator.class, "com.obric.memorydata.plugin");
        com.obric.oui.c.a.b.d(r11.a(), "Abort viewport transition because range shift is not adjacent, source=" + r12.b() + " target=" + r13.b());
        r11.d.a(r13, r14);
        r11.f = r13;
        r11.d.a(r13);
        return;
    L6:
        float r8 = this.d.c();
        if (r8 > 0.0f) goto L10;
        com.obric.oui.c.a.b.d(this.e, Intrinsics.stringPlus("Abort viewport transition because step distance is invalid, distance=", Float.valueOf(r8)));
        this.d.a(r13, r14);
        this.f = r13;
        this.d.a(r13);
        return;
    L10:
        c();
        int r3 = this.h + 1;
        this.h = r3;
        final a r10 = new a(r3, r12, r13, r0, r14);
        this.g = r10;
        if (j == false) goto L13;
        com.obric.oui.c.a.b.b(this.e, "Start viewport transition, reason=" + r14.getLogValue() + " from=" + r12.b() + " to=" + r13.b() + " direction=" + r0 + " distance=" + r8);
    L13:
        this.d.a(r12, r13, 0.0f);
        a(r10, r0.resolveExitTranslation(r8), (Function0) ZeusTransformUtils.preCheckCast(new IndicatorAnimator$startViewportTransition$1(this, r10), Function0.class, "com.obric.memorydata.plugin"));
    }

    private final boolean a(RenderReason r3, com.obric.oui.indicator.c r4, com.obric.oui.indicator.c r5, boolean r6) {
        if (r3 != RenderReason.SCROLL) goto L16;
        if (r6 == false) goto L16;
        if (r4 != null) goto L12;
        if (j == false) goto L10;
        com.obric.oui.c.a.b.b(this.e, "Skip viewport transition, reason=" + r3.getLogValue() + " current=null next=" + r5.b());
    L10:
        return false;
    L12:
        if (this.d.a() > this.d.b()) goto L14;
        return false;
    L14:
        return true;
    L16:
        return false;
    }

    public static final /* synthetic */ a b(IndicatorAnimator r0) {
        return r0.g;
    }

    private final void c() {
        this.f13922b.setTranslationX(0.0f);
        com.obric.oui.indicator.c r0 = this.f;
        if (r0 == null) goto L7;
        this.d.a(r0);
        return;
    }

    private final void d() {
        this.f13922b.animate().setUpdateListener(null).setListener(null).cancel();
    }

    /* JADX INFO: renamed from: lambda$BIoUdRmdHh2V5uzgtKAk-up8cRA, reason: not valid java name */
    public static /* synthetic */ void m1314lambda$BIoUdRmdHh2V5uzgtKAkup8cRA(IndicatorAnimator r0, a r1, float r2, ValueAnimator r3) {
        a(r0, r1, r2, r3);
    }

    public final int a(int r6, int r7, float r8) {
        float r0 = this.i;
        if (r8 <= r0) goto L6;
        ScrollDirection r1 = ScrollDirection.FORWARD;
    L10:
        if (r1 != null) goto L12;
        int r2 = -1;
    L13:
        boolean r3 = false;
        if (r2 == (-1)) goto L25;
        if (r2 == 1) goto L22;
        if (r2 == 2) goto L25;
        throw new NoWhenBranchMatchedException();
    L22:
        if (r8 > 0.5f) goto L26;
    L27:
        boolean r4 = false;
    L28:
        if (r4 == false) goto L31;
        r6 = r7;
    L31:
        if (r8 != 0.0f) goto L33;
        r3 = true;
    L33:
        if (r3 == true) goto L35;
        this.i = r8;
    L35:
        return r6;
    L26:
        r4 = true;
    L25:
        if (r8 < 0.5f) goto L27;
    L12:
        r2 = d.f13925a[r1.ordinal()];
        goto L13
    L6:
        if (r8 >= r0) goto L8;
        r1 = ScrollDirection.BACKWARD;
        goto L10
    L8:
        r1 = null;
        goto L10
    }

    public final String a() {
        return this.e;
    }

    public final void a(RenderReason r6, com.obric.oui.indicator.c r7) {
        Intrinsics.checkNotNullParameter(r6, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r7, "nextViewportState");
        if (this.g == null) goto L5;
        return;
    L5:
        com.obric.oui.indicator.c r0 = this.f;
        if (r0 != null) goto L8;
        IntRange r1 = null;
    L9:
        boolean r2 = true;
        boolean r3 = !Intrinsics.areEqual(r1, r7.b());
        if (r3 == true) goto L16;
        if (this.d.a(r7.b()) == true) goto L16;
        r2 = false;
    L16:
        if (a(r6, r0, r7, r3) == false) goto L21;
        if (r0 != null) goto L19;
        r0 = r7;
    L19:
        a(r0, r7, r6);
        return;
    L21:
        if (r2 == false) goto L23;
        this.d.a(r7, r6);
    L23:
        this.f = r7;
        this.d.a(r7);
        return;
    L8:
        r1 = r0.b();
        goto L9
    }

    public final com.obric.oui.indicator.c b() {
        return this.f;
    }
}
