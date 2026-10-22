package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.lsposed.hiddenapibypass.HiddenApiBypass;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b(\u0018\u0000 s2\u00020\u0001:\u0002stB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\tH\u0002J\u0010\u00103\u001a\u00020\f2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\tH\u0002J\b\u00108\u001a\u00020\u001cH\u0016J\r\u00109\u001a\u00020\u001cH\u0000¢\u0006\u0002\b:J\u0010\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020\tH\u0002J\u0010\u0010?\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0002J\b\u0010@\u001a\u00020\tH\u0016J\b\u0010A\u001a\u00020\tH\u0002J\b\u0010B\u001a\u00020\fH\u0016J\u0010\u0010C\u001a\u00020\f2\u0006\u00107\u001a\u00020\tH\u0002J\u0010\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u0007H\u0002J\b\u0010F\u001a\u00020\fH\u0002J\u0010\u0010G\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010H\u001a\u00020\u00072\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010I\u001a\u00020\u00072\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020=H\u0002J!\u0010J\u001a\u00020\u001c2\u0006\u0010K\u001a\u0002002\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u0002000MH\u0082\bJ\u0010\u0010N\u001a\u00020\u001c2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u0010O\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020\u0007H\u0016J\u0010\u0010Q\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\tH\u0016J\u0018\u0010Q\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\t2\u0006\u0010R\u001a\u00020\tH\u0016J\u0018\u0010S\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u0010R\u001a\u00020\tH\u0016J\u0015\u0010T\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0000¢\u0006\u0002\bUJ\u0018\u0010V\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u0010W\u001a\u00020\fH\u0002J\b\u0010X\u001a\u00020\u001cH\u0016J \u0010Y\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020=2\u0006\u0010Z\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\tH\u0002J\u0018\u0010[\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020=2\u0006\u0010Z\u001a\u00020\u000fH\u0002J\u0010\u0010\\\u001a\u00020\u001c2\u0006\u0010/\u001a\u000200H\u0002J\b\u0010]\u001a\u00020\u001cH\u0002J\u0018\u0010^\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020=2\u0006\u0010)\u001a\u00020\u0007H\u0002J\u0018\u0010_\u001a\u00020\u001c2\u0006\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u0007H\u0016J\u0018\u0010,\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\t2\u0006\u0010b\u001a\u00020\fH\u0002J\u000e\u0010c\u001a\u00020\u001c2\u0006\u0010d\u001a\u00020\fJ \u0010e\u001a\u00020\f2\u0006\u00102\u001a\u00020\t2\u0006\u0010f\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\u000fH\u0002J \u0010g\u001a\u00020\f2\u0006\u00102\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\u000f2\u0006\u0010h\u001a\u000200H\u0002J\u0006\u0010i\u001a\u00020\u001cJ\b\u0010j\u001a\u00020\u001cH\u0002J\b\u0010k\u001a\u00020=H\u0002J\u0010\u0010l\u001a\u00020\u001c2\u0006\u0010m\u001a\u00020\tH\u0002J\u000e\u0010n\u001a\u00020\u001c2\u0006\u0010o\u001a\u00020\tJ\u0018\u0010p\u001a\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010Z\u001a\u00020\u000fH\u0002J\f\u0010q\u001a\u00020\t*\u00020\tH\u0002J\f\u0010r\u001a\u00020\t*\u00020\tH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019R\u000e\u0010-\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "Landroid/widget/EdgeEffect;", "context", "Landroid/content/Context;", TypedValues.AttributesType.S_TARGET, "Landroid/view/View;", "orientation", "", "maxOverscrollPx", "", "(Landroid/content/Context;Landroid/view/View;IF)V", "abruptOppositeDeltaGuardArmed", "", "accumulatedDragDistance", "animationStartTime", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "lastPullTime", "lastPullTranslation", "lastTouchDeltaX", "getMaxOverscrollPx", "()F", "setMaxOverscrollPx", "(F)V", "onTranslationChanged", "Lkotlin/Function1;", "", "getOnTranslationChanged", "()Lkotlin/jvm/functions/Function1;", "setOnTranslationChanged", "(Lkotlin/jvm/functions/Function1;)V", "preserveFinishForTouchUntil", "pullMultiplier", "pullMultiplierInitialized", "releaseVelocityPxPerMs", "releaseVelocityTime", "sizePx", "springBack", "Lcom/obric/oui/orecyclerview/base/FluidSpringBack;", EventBody.KEY_VALUE, "translation", "getTranslation", "setTranslation", "useHeightForHorizontalSize", "clearActiveOrientationIfCurrent", InfoRequestQPSOptTraceLogger.REASON, "", "distanceDeltaToPullDistance", "deltaPx", "draw", "canvas", "Landroid/graphics/Canvas;", "ensurePullMultiplier", "deltaDistance", "finish", "forceFinish", "forceFinish$OUI_standardRelease", "getActiveOrientation", "state", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;", "getCurrentFrameIntervalMs", "getDeltaPx", "getDistance", "getReleaseVelocityPxPerMs", "isFinished", "isPulling", "isSameAxis", "otherOrientation", "isUnscrollableOnCurrentAxis", "isVerticalOrientation", "lastPullOrientation", "lastPullSign", "logFrame", "operation", "messageProvider", "Lkotlin/Function0;", "markActiveOrientation", "onAbsorb", "velocity", "onPull", "displacement", "onPullDistance", "onPullDistanceAfterContentScrollExhausted", "onPullDistanceAfterContentScrollExhausted$OUI_standardRelease", "onPullDistanceInternal", "allowStartAfterHostScrollExhausted", "onRelease", "recordPullFrame", "now", "recordReleaseFrame", "resetInactiveReleaseState", "resetReleaseVelocityTracker", "setActiveOrientation", "setSize", "width", "height", "trackReleaseVelocity", "setUseHeightForHorizontalSize", "enable", "shouldIgnoreAbruptOppositeDelta", "targetAccumulated", "shouldSkipPullInCurrentFrame", "reasonPrefix", "stopAnimationForTouch", "syncAccumulatedDistanceFromTranslationIfNeeded", "targetState", "updateReleaseVelocity", "newTranslation", "updateTouchDeltaX", "deltaX", "wasOppositeReleasedInSameFrame", "dp", "px", "Companion", ExifInterface.TAG_ORIENTATION, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e extends EdgeEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13364a = null;
    private static final WeakHashMap<View, a.C0732a> v = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f13365b;
    private final int c;
    private float d;
    private int e;
    private boolean f;
    private float g;
    private Function1<? super Float, Unit> h;
    private float i;
    private float j;
    private boolean k;
    private float l;
    private boolean m;
    private com.obric.oui.orecyclerview.base.d n;
    private long o;
    private final DisplayMetrics p;
    private float q;
    private long r;
    private float s;
    private long t;
    private long u;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion;", "", "()V", "MAX_RELEASE_VELOCITY_PX_PER_MS", "", "ORIENTATION_BOTTOM", "", "ORIENTATION_LEFT", "ORIENTATION_NONE", "ORIENTATION_RIGHT", "ORIENTATION_TOP", "RELEASE_VELOCITY_VALID_MS", "", "TAG", "", "TOUCH_FINISH_PRESERVE_MS", "targetStates", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;", "bypassHiddenApi", "", "signature", "TargetBounceState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.bouncelayout.e$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u001a\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017¨\u0006-"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;", "", "()V", "activeHorizontalOrientation", "", "getActiveHorizontalOrientation", "()I", "setActiveHorizontalOrientation", "(I)V", "activeVerticalOrientation", "getActiveVerticalOrientation", "setActiveVerticalOrientation", "lastHorizontalPullOrientation", "getLastHorizontalPullOrientation", "setLastHorizontalPullOrientation", "lastHorizontalPullSign", "getLastHorizontalPullSign", "setLastHorizontalPullSign", "lastHorizontalPullTime", "", "getLastHorizontalPullTime", "()J", "setLastHorizontalPullTime", "(J)V", "lastHorizontalReleaseOrientation", "getLastHorizontalReleaseOrientation", "setLastHorizontalReleaseOrientation", "lastHorizontalReleaseTime", "getLastHorizontalReleaseTime", "setLastHorizontalReleaseTime", "lastVerticalPullOrientation", "getLastVerticalPullOrientation", "setLastVerticalPullOrientation", "lastVerticalPullSign", "getLastVerticalPullSign", "setLastVerticalPullSign", "lastVerticalPullTime", "getLastVerticalPullTime", "setLastVerticalPullTime", "lastVerticalReleaseOrientation", "getLastVerticalReleaseOrientation", "setLastVerticalReleaseOrientation", "lastVerticalReleaseTime", "getLastVerticalReleaseTime", "setLastVerticalReleaseTime", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        private static final class C0732a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f13366a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f13367b;
            private long c;
            private int d;
            private long e;
            private int f;
            private long g;
            private int h;
            private int i;
            private long j;
            private int k;
            private int l;

            public C0732a() {
                this.f13366a = -1;
                this.f13367b = -1;
                this.c = -1;
                this.d = -1;
                this.e = -1;
                this.f = -1;
                this.g = -1;
                this.h = -1;
                this.j = -1;
                this.k = -1;
            }

            public final int a() {
                return this.f13366a;
            }

            public final void a(int r1) {
                this.f13366a = r1;
            }

            public final void a(long r1) {
                this.c = r1;
            }

            public final int b() {
                return this.f13367b;
            }

            public final void b(int r1) {
                this.f13367b = r1;
            }

            public final void b(long r1) {
                this.e = r1;
            }

            public final long c() {
                return this.c;
            }

            public final void c(int r1) {
                this.d = r1;
            }

            public final void c(long r1) {
                this.g = r1;
            }

            public final int d() {
                return this.d;
            }

            public final void d(int r1) {
                this.f = r1;
            }

            public final void d(long r1) {
                this.j = r1;
            }

            public final long e() {
                return this.e;
            }

            public final void e(int r1) {
                this.h = r1;
            }

            public final int f() {
                return this.f;
            }

            public final void f(int r1) {
                this.i = r1;
            }

            public final long g() {
                return this.g;
            }

            public final void g(int r1) {
                this.k = r1;
            }

            public final int h() {
                return this.h;
            }

            public final void h(int r1) {
                this.l = r1;
            }

            public final int i() {
                return this.i;
            }

            public final long j() {
                return this.j;
            }

            public final int k() {
                return this.k;
            }

            public final int l() {
                return this.l;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "signature");
            HiddenApiBypass.addHiddenApiExemptions(new String[]{r2});     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Log.w("BounceEdgeEffect", Intrinsics.stringPlus("Failed to bypass hidden API restrictions for ", r2), th);
        }
    }

    static {
        f13364a = new a(null);
        v = new WeakHashMap();
    }

    public e(Context r3, View r4, int r5, float r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r4, TypedValues.AttributesType.S_TARGET);
        super(r7);
        this.f13365b = r4;
        this.c = r5;
        this.d = r6;
        this.j = 1.0f;
        this.m = true;
        this.o = -1;
        this.p = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDisplayMetrics();
        this.r = -1;
        this.t = -1;
        this.u = -1;
    }

    private final int a(a.C0732a r2) {
        if (a(this.c) == false) goto L6;
        return r2.a();
    L6:
        return r2.b();
    }

    public static final /* synthetic */ int a(e r0) {
        return r0.c;
    }

    private final void a(float r5, boolean r6) {
        if (r6 == false) goto L4;
        i(r5);
    L4:
        d(r5);
        d r7 = d.f13362a;
        if (d.a() == false) goto L20;
        float r1 = 0.0f;
        if (a(this) != 2) goto L9;
    L12:
        float r8 = a();
    L14:
        if (a(this) != 0) goto L16;
    L17:
        r1 = a();
    L18:
        d.a(b(this), "setTranslation", r8, r1, "trackVelocity=" + r6 + " orientation=" + this.c);
        return;
    L16:
        if (a(this) != 1) goto L18;
    L9:
        if (a(this) == 3) goto L12;
        r8 = 0.0f;
        goto L14
    }

    private final void a(a.C0732a r2, int r3) {
        if (a(this.c) == false) goto L5;
        r2.a(r3);
        return;
    L5:
        r2.b(r3);
    }

    private final void a(a.C0732a r2, long r3) {
        if (a(this.c) == false) goto L5;
        r2.a(r3);
        r2.c(this.c);
        return;
    L5:
        r2.b(r3);
        r2.d(this.c);
    }

    private final void a(a.C0732a r2, long r3, float r5) {
        int r6 = (int) Math.signum(r5);
        if (r6 != 0) goto L6;
        return;
    L6:
        if (a(this.c) == false) goto L8;
        r2.c(r3);
        r2.e(this.c);
        r2.f(r6);
        return;
    L8:
        r2.d(r3);
        r2.g(this.c);
        r2.h(r6);
    }

    private final void a(String r5) {
        a.C0732a r0 = d();
        int r1 = a(r0);
        int r2 = this.c;
        if (r1 == r2) goto L8;
        a(r0, r2);
        d r3 = d.f13362a;
        if (d.a() == false) goto L9;
        d.a(this.f13365b, "activeEdgeChanged", "from=" + r1 + " to=" + this.c + " reason=" + r5);
        return;
    L9:
        return;
    }

    private final boolean a(float r6, float r7, long r8) {
        if (this.i > 0.0f) goto L5;
    L24:
        return false;
    L5:
        if (r6 >= 0.0f) goto L24;
        if (r7 > 0.0f) goto L24;
        if (this.m == false) goto L24;
        if (e() == false) goto L24;
        a.C0732a r0 = d();
        if (b(r0) != r8) goto L24;
        if (d(r0) <= 0) goto L24;
        this.m = false;
        d r9 = d.f13362a;
        if (d.a() == false) goto L25;
        d.a(this.f13365b, "oppositeDeltaSkipped", "orientation=" + this.c + " deltaPx=" + r6 + " accumulated=" + this.i + " target=" + r7);
        return true;
    L25:
        return true;
    }

    private final boolean a(float r11, long r12, String r14) {
        if (r11 != 0.0f) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        return false;
    L8:
        a.C0732a r4 = d();
        int r5 = a(r4);
        if (r5 == (-1)) goto L17;
        if (r5 == this.c) goto L17;
        d r13 = d.f13362a;
        if (d.a() == false) goto L15;
        d.a(this.f13365b, "onPullSkipped", "orientation=" + this.c + " activeOrientation=" + r5 + " reason=" + r14 + "ActiveEdge deltaPx=" + r11 + " translation=" + a());
    L15:
        return true;
    L17:
        if (e() == false) goto L27;
        if (r11 >= 0.0f) goto L27;
        if (b(r4) != r12) goto L27;
        if (d(r4) <= 0) goto L27;
        d r15 = d.f13362a;
        if (d.a() == false) goto L26;
        d.a(this.f13365b, "onPullSkipped", "orientation=" + this.c + " lastOrientation=" + c(r4) + " reason=" + r14 + "OppositeInSameFrame deltaPx=" + r11 + " translation=" + a());
    L26:
        return true;
    L27:
        return false;
    L5:
        r3 = false;
        goto L6
    }

    private final boolean a(int r1) {
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    private final float b(float r10, boolean r11) {
        if (this.e > 0) goto L5;
    L81:
        return 0.0f;
    L5:
        if (this.d <= 0.0f) goto L81;
        boolean r2 = false;
        if (r10 != 0.0f) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        return 0.0f;
    L13:
        this.u = -1;
        d r1 = d.f13362a;
        if (d.a() == false) goto L17;
        d.a(this.f13365b, "onPullDistance", "orientation=" + this.c + " deltaDistance=" + r10);
    L17:
        if (this.o == (-1)) goto L19;
        this.i = com.obric.oui.orecyclerview.base.b.f14034a.b(Math.abs(this.g), this.d);
        this.o = -1;
        this.m = true;
        i();
    L19:
        ViewParent r3 = this.f13365b.getParent();
        if (r3 == null) goto L23;
        r3.requestDisallowInterceptTouchEvent(true);
    L23:
        f();
        float r4 = this.e * r10;
        if (this.i != 0.0f) goto L26;
        boolean r5 = true;
    L27:
        if (r5 == true) goto L29;
    L35:
        long r6 = AnimationUtils.currentAnimationTimeMillis();
        if (a(r4, r6, "onPullDistance") == false) goto L39;
    L37:
        this.f13365b.invalidate();
        return r10;
    L39:
        float r12 = this.i + r4;
        if (a(r4, r12, r6) == false) goto L42;
        a("skipAbruptOppositeOnPullDistance");
        goto L37
    L42:
        float r7 = Math.abs(this.g);
        if (r4 >= 0.0f) goto L51;
        if (r7 <= 0.0f) goto L51;
        float r13 = r7 + r4;
        if (r13 <= 0.0f) goto L49;
        this.i = com.obric.oui.orecyclerview.base.b.f14034a.b(r13, this.d);
    L57:
        a(d(), r6, r4);
        int r14 = this.c;
        float r8 = 1.0f;
        if (r14 == 0) goto L72;
        if (r14 != 1) goto L61;
    L71:
        r8 = -1.0f;
        goto L72
    L61:
        if (r14 == 2) goto L72;
        if (r14 == 3) goto L71;
        float r15 = this.g;
        if (r15 != 0.0f) goto L67;
        boolean r9 = true;
    L68:
        if (r9 == true) goto L72;
        r8 = Math.signum(r15);
        goto L72
    L67:
        r9 = false;
    L72:
        float r16 = r8 * Math.abs(com.obric.oui.orecyclerview.base.b.f14034a.a(this.i, this.d));
        a(r16, true);
        if (this.i <= 0.0f) goto L75;
    L80:
        a("onPullDistance");
        goto L37
    L75:
        if (r16 != 0.0f) goto L77;
        r2 = true;
    L77:
        if (r2 == false) goto L80;
        b("onPullDistanceZero");
        goto L37
    L49:
        r10 = h(-r7);
        this.i = 0.0f;
        String r17 = "onPullDistanceVisibleConsumedToZero";
    L56:
        b(r17);
    L51:
        if (r12 <= 0.0f) goto L55;
        this.i = r12;
        if (r4 <= 0.0f) goto L57;
        this.m = true;
        goto L57
    L55:
        r10 = (-this.i) / this.e;
        this.i = 0.0f;
        r17 = "onPullDistanceConsumedToZero";
        goto L56
    L29:
        if (f(r10) == true) goto L35;
        if (r11 == true) goto L32;
    L33:
        a(0.0f, false);
        i();
        return 0.0f;
    L32:
        if (r4 > 0.0f) goto L35;
    L26:
        r5 = false;
        goto L27
    L10:
        r0 = false;
        goto L11
    }

    private final long b(a.C0732a r2) {
        if (a(this.c) == false) goto L6;
        return r2.g();
    L6:
        return r2.j();
    }

    public static final /* synthetic */ View b(e r0) {
        return r0.f13365b;
    }

    private final void b(String r4) {
        a.C0732a r0 = d();
        if (a(r0) != this.c) goto L8;
        a(r0, -1);
        d r1 = d.f13362a;
        if (d.a() == false) goto L9;
        d.a(this.f13365b, "activeEdgeCleared", "orientation=" + this.c + " reason=" + r4);
        return;
    L9:
        return;
    }

    private final boolean b(a.C0732a r6, long r7) {
        if (a(this.c) == false) goto L10;
        if (r6.c() != r7) goto L15;
        if (r6.d() == this.c) goto L15;
        return true;
    L15:
        return false;
    L10:
        if (r6.e() != r7) goto L15;
        if (r6.f() == this.c) goto L15;
        return true;
    }

    private final int c(a.C0732a r2) {
        if (a(this.c) == false) goto L6;
        return r2.h();
    L6:
        return r2.k();
    }

    private final void c(String r4) {
        d r0 = d.f13362a;
        if (d.a() == false) goto L5;
        d.a(this.f13365b, "onReleaseSkipped", "orientation=" + this.c + " reason=" + r4 + " translation=" + a());
    L5:
        this.o = -1;
        this.i = 0.0f;
        a(0.0f, false);
        this.j = 1.0f;
        this.k = false;
        this.m = true;
        i();
        this.f13365b.invalidate();
    }

    private final int d(a.C0732a r2) {
        if (a(this.c) == false) goto L6;
        return r2.i();
    L6:
        return r2.l();
    }

    private final a.C0732a d() {
        WeakHashMap<View, a.C0732a> r0 = v;
        monitor-enter(r0);
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        View r3 = this.f13365b;     // Catch: Throwable -> L10
        Object r2 = r1.get(r3);     // Catch: Throwable -> L10
        if (r2 != null) goto L7;
        r2 = new a.C0732a();     // Catch: Throwable -> L10
        r1.put(r3, r2);     // Catch: Throwable -> L10
    L7:
        a.C0732a r4 = (a.C0732a) ZeusTransformUtils.preCheckCast(r2, a.C0732a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r4;
    L10:
        th = move-exception;
        throw th;
    }

    private final void d(float r2) {
        if (this.g != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L12;
        this.g = r2;
        Function1<? super Float, Unit> r1 = this.h;
        if (r1 == null) goto L13;
        r1.invoke(Float.valueOf(r2));
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void e(float r6) {
        if (this.k == false) goto L6;
        return;
    L6:
        if (r6 != 0.0f) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        float r2 = -1.0f;
        if (ZeusTransformUtils.instanceOf(this.f13365b, NestedScrollView.class) == false) goto L18;
        if (this.c != 0) goto L18;
        if (r6 < 0.0f) goto L27;
    L26:
        r2 = 1.0f;
    L27:
        this.j = r2;
        this.k = true;
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(this.f13365b, HorizontalScrollView.class) == false) goto L24;
        if (this.c != 2) goto L24;
        if (r6 >= 0.0f) goto L26;
    L24:
        if (ZeusTransformUtils.instanceOf(this.f13365b, HorizontalScrollView.class) == false) goto L26;
        int r7 = this.c;
        goto L26
    L8:
        r1 = false;
        goto L9
    }

    private final boolean e() {
        int r0 = this.c;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L12;
        if (this.f13365b.canScrollHorizontally(-1) == false) goto L9;
        return false;
    L9:
        if (this.f13365b.canScrollHorizontally(1) == false) goto L16;
        return false;
    L16:
        return true;
    L12:
        if (this.f13365b.canScrollVertically(-1) == false) goto L14;
        return false;
    L14:
        if (this.f13365b.canScrollVertically(1) == false) goto L16;
        return false;
    }

    private final void f() {
        if (this.d <= 0.0f) goto L19;
        boolean r2 = true;
        if (this.g != 0.0f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L21;
        float r1 = com.obric.oui.orecyclerview.base.b.f14034a.b(Math.abs(this.g), this.d);
        if (this.o == (-1)) goto L13;
    L17:
        this.i = r1;
        return;
    L13:
        if (this.i == 0.0f) goto L16;
        r2 = false;
    L16:
        if (r2 == true) goto L17;
        return;
    L21:
        return;
    L7:
        r0 = false;
        goto L8
    }

    private final boolean f(float r5) {
        if (r5 != 0.0f) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L9;
        return false;
    L9:
        if (this.i <= 0.0f) goto L11;
        return true;
    L11:
        if (r5 > 0.0f) goto L13;
        return false;
    L13:
        int r6 = this.c;
        if (r6 == 0) goto L31;
        if (r6 == 1) goto L28;
        if (r6 == 2) goto L25;
        if (r6 == 3) goto L22;
        return false;
    L22:
        if (this.f13365b.canScrollHorizontally(1) == false) goto L33;
        return false;
    L33:
        return true;
    L25:
        if (this.f13365b.canScrollHorizontally(-1) == false) goto L33;
        return false;
    L28:
        if (this.f13365b.canScrollVertically(1) == false) goto L33;
        return false;
    L31:
        if (this.f13365b.canScrollVertically(-1) == false) goto L33;
        return false;
    L5:
        r3 = false;
        goto L6
    }

    private final float g() {
        Display r0 = this.f13365b.getDisplay();
        WindowManager r1 = null;
        if (r0 != null) goto L5;
        Float r2 = null;
    L7:
        if (r2 != null) goto L17;
        Object r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13365b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("window");
        if (ZeusTransformUtils.instanceOf(r4, WindowManager.class) == false) goto L11;
        r1 = (WindowManager) ZeusTransformUtils.preCheckCast(r4, WindowManager.class, "com.obric.memorydata.plugin");
    L11:
        if (r1 != null) goto L13;
    L12:
        float r5 = 0.0f;
    L19:
        if (r5 > 0.0f) goto L23;
        return 16.67f;
    L23:
        return 1000.0f / r5;
    L13:
        Display r6 = r1.getDefaultDisplay();
        if (r6 == null) goto L12;
        r5 = r6.getRefreshRate();
        goto L19
    L17:
        r5 = r2.floatValue();
        goto L19
    L5:
        r2 = Float.valueOf(r0.getRefreshRate());
        goto L7
    }

    private final float g(float r7) {
        if (ZeusTransformUtils.instanceOf(this.f13365b, HorizontalScrollView.class) == false) goto L22;
        int r0 = this.c;
        if (r0 == 2) goto L7;
        if (r0 != 3) goto L22;
    L7:
        float r8 = Math.abs(r7) * this.e;
        int r1 = this.c;
        boolean r3 = false;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L12;
    L10:
        r3 = true;
    L17:
        if (r3 == false) goto L20;
        return r8;
    L20:
        return -r8;
    L12:
        if (this.l <= 0.0f) goto L17;
    L15:
        if (this.l >= 0.0f) goto L17;
    L22:
        return (r7 * this.j) * this.e;
    }

    private final float h() {
        long r0 = AnimationUtils.currentAnimationTimeMillis();
        long r2 = this.t;
        if (r2 != (-1)) goto L5;
    L7:
        return 0.0f;
    L5:
        if ((r0 - r2) > 120) goto L7;
        return this.s;
    }

    private final float h(float r1) {
        return r1 / this.e;
    }

    private final void i() {
        this.q = this.g;
        this.r = -1;
        this.s = 0.0f;
        this.t = -1;
    }

    private final void i(float r7) {
        long r0 = AnimationUtils.currentAnimationTimeMillis();
        long r2 = this.r;
        if (r2 != (-1)) goto L5;
    L7:
        this.q = r7;
        this.r = r0;
        d r1 = d.f13362a;
        if (d.a() == false) goto L11;
        d.a(this.f13365b, "velocitySample", "orientation=" + this.c + " velocityPxPerMs=" + this.s + " translation=" + r7);
        return;
    L11:
        return;
    L5:
        if (r0 <= r2) goto L7;
        this.s = RangesKt.coerceIn((r7 - this.q) / (r0 - r2), -20.0f, 20.0f);
        this.t = r0;
        goto L7
    }

    private final float j(float r2) {
        return TypedValue.applyDimension(1, r2, this.p);
    }

    private final float k(float r1) {
        return r1 / this.p.density;
    }

    public final float a() {
        return this.g;
    }

    public final void a(float r1) {
        this.d = r1;
    }

    public final void a(Function1<? super Float, Unit> r3) {
        this.h = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
    }

    public final void a(boolean r1) {
        this.f = r1;
    }

    public final void b() {
        if (this.o == (-1)) goto L5;
    L11:
        this.i = com.obric.oui.orecyclerview.base.b.f14034a.b(Math.abs(this.g), this.d);
        this.o = -1;
        this.m = true;
        i();
        this.u = AnimationUtils.currentAnimationTimeMillis() + 120;
        this.f13365b.invalidate();
        return;
    L5:
        if (this.g != 0.0f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        if (this.i > 0.0f) goto L11;
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void b(float r1) {
        this.l = r1;
    }

    public final float c(float r2) {
        return b(r2, true);
    }

    public final void c() {
        super.finish();
        this.o = -1;
        this.i = 0.0f;
        a(0.0f, false);
        this.j = 1.0f;
        this.k = false;
        this.m = true;
        i();
        this.u = -1;
        b("finish");
        this.f13365b.invalidate();
    }

    @Override // android.widget.EdgeEffect
    public boolean draw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        com.obric.oui.orecyclerview.base.d r14 = this.n;
        if (this.o == (-1)) goto L27;
        if (r14 == null) goto L27;
        long r4 = AnimationUtils.currentAnimationTimeMillis() - this.o;
        com.obric.oui.orecyclerview.base.d.a r15 = r14.a(r4);
        a(j(r15.a()), false);
        d r0 = d.f13362a;
        if (d.a() == false) goto L23;
        if (a(this) != 2) goto L10;
    L13:
        float r1 = a();
    L15:
        if (a(this) != 0) goto L17;
    L20:
        float r8 = a();
    L21:
        d.a(b(this), "draw", r1, r8, "orientation=" + this.c + " elapsed=" + r4 + " finished=" + r15.b());
        goto L23
    L17:
        if (a(this) == 1) goto L20;
        r8 = 0.0f;
        goto L21
    L10:
        if (a(this) == 3) goto L13;
        r1 = 0.0f;
    L23:
        if (r15.b() == true) goto L26;
        this.f13365b.invalidate();
        return true;
    L26:
        a(0.0f, false);
        this.o = -1;
        this.i = 0.0f;
        this.j = 1.0f;
        this.k = false;
        this.m = true;
        i();
        b("drawFinished");
    L27:
        return false;
    }

    @Override // android.widget.EdgeEffect
    public void finish() {
        if (this.u < AnimationUtils.currentAnimationTimeMillis()) goto L23;
        boolean r2 = false;
        if (this.g != 0.0f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
    L11:
        super.finish();
        this.o = -1;
        f();
        this.m = true;
        i();
        this.u = -1;
        if (this.g != 0.0f) goto L15;
        r2 = true;
    L15:
        if (r2 == true) goto L17;
    L18:
        a("finishPreservedForTouch");
    L19:
        this.f13365b.invalidate();
        d r1 = d.f13362a;
        if (d.a() == false) goto L25;
        d.a(this.f13365b, "finishPreservedForTouch", "orientation=" + this.c + " translation=" + a());
        return;
    L25:
        return;
    L17:
        if (this.i <= 0.0f) goto L19;
    L10:
        if (this.i <= 0.0f) goto L23;
    L7:
        r0 = false;
    L23:
        c();
    }

    @Override // android.widget.EdgeEffect
    public float getDistance() {
        if (this.e > 0) goto L6;
        return 0.0f;
    L6:
        f();
        return this.i / this.e;
    }

    @Override // android.widget.EdgeEffect
    public boolean isFinished() {
        if (this.o != (-1)) goto L11;
        if (this.g != 0.0f) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L11;
        return true;
    L7:
        r4 = false;
    L11:
        return false;
    }

    @Override // android.widget.EdgeEffect
    public void onAbsorb(int r14) {
        this.u = -1;
        if (this.d > 0.0f) goto L6;
        return;
    L6:
        if (this.o == (-1)) goto L11;
        d r0 = d.f13362a;
        if (d.a() == false) goto L52;
        d.a(this.f13365b, "onAbsorbSkipped", "orientation=" + this.c + " velocity=" + r14 + " reason=animationRunning");
        return;
    L52:
        return;
    L11:
        d r2 = d.f13362a;
        if (d.a() == false) goto L14;
        d.a(this.f13365b, "onAbsorb", "orientation=" + this.c + " velocity=" + r14);
    L14:
        i();
        a("onAbsorb");
        int r3 = this.c;
        if (r3 == 1) goto L19;
        if (r3 == 3) goto L19;
        int r15 = Math.abs(r14);
    L20:
        float r16 = k(r15 / 1000.0f);
        long r7 = AnimationUtils.currentAnimationTimeMillis();
        this.o = r7;
        if (this.n != null) goto L23;
        this.n = new com.obric.oui.orecyclerview.base.d();
    L23:
        float r9 = k(this.g);
        com.obric.oui.orecyclerview.base.d r10 = this.n;
        if (r10 == null) goto L27;
        r10.a(r16, r9);
    L27:
        if (r10 == null) goto L50;
        float r17 = g();
        if (r17 <= 0.0f) goto L50;
        this.o = r7 - MathKt.roundToLong(r17);
        com.obric.oui.orecyclerview.base.d.a r8 = r10.a(r17);
        a(j(r8.a()), false);
        d r11 = d.f13362a;
        if (d.a() == false) goto L48;
        if (a(this) != 2) goto L35;
    L38:
        float r4 = a();
    L40:
        if (a(this) != 0) goto L42;
    L45:
        float r12 = a();
    L46:
        d.a(b(this), "onAbsorbImmediateFrame", r4, r12, "orientation=" + this.c + " elapsed=" + r17 + " refreshRate=" + (1000.0f / r17) + " finished=" + r8.b());
        goto L48
    L42:
        if (a(this) == 1) goto L45;
        r12 = 0.0f;
        goto L46
    L35:
        if (a(this) == 3) goto L38;
        r4 = 0.0f;
    L48:
        if (r8.b() == false) goto L50;
        a(0.0f, false);
        this.o = -1;
        this.i = 0.0f;
        this.j = 1.0f;
        this.k = false;
        this.m = true;
        b("absorbImmediateFinished");
    L50:
        this.f13365b.invalidate();
        return;
    L19:
        r15 = -Math.abs(r14);
        goto L20
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float r2) {
        onPull(r2, 0.5f);
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float r9, float r10) {
        if (this.e > 0) goto L5;
        return;
    L5:
        if (this.d <= 0.0f) goto L67;
        boolean r1 = false;
        if (r9 != 0.0f) goto L10;
        boolean r11 = true;
    L11:
        if (r11 == false) goto L13;
        return;
    L13:
        this.u = -1;
        d r12 = d.f13362a;
        if (d.a() == false) goto L16;
        d.a(this.f13365b, "onPull", "orientation=" + this.c + " deltaDistance=" + r9);
    L16:
        e(r9);
        if (this.o == (-1)) goto L19;
        this.i = com.obric.oui.orecyclerview.base.b.f14034a.b(Math.abs(this.g), this.d);
        this.o = -1;
        this.m = true;
        i();
    L19:
        ViewParent r13 = this.f13365b.getParent();
        if (r13 == null) goto L23;
        r13.requestDisallowInterceptTouchEvent(true);
    L23:
        f();
        if (this.i != 0.0f) goto L26;
        boolean r14 = true;
    L27:
        if (r14 == true) goto L29;
    L32:
        float r15 = g(r9);
        long r3 = AnimationUtils.currentAnimationTimeMillis();
        if (a(r15, r3, "onPull") == false) goto L36;
        this.f13365b.invalidate();
        return;
    L36:
        float r16 = this.i + r15;
        if (a(r15, r16, r3) == false) goto L40;
        a("skipAbruptOppositeOnPull");
        this.f13365b.invalidate();
        return;
    L40:
        float r17 = RangesKt.coerceAtLeast(r16, 0.0f);
        this.i = r17;
        if (r15 > 0.0f) goto L43;
    L45:
        a(d(), r3, r15);
        float r18 = com.obric.oui.orecyclerview.base.b.f14034a.a(this.i, this.d);
        int r19 = this.c;
        if (r19 == 0) goto L54;
        if (r19 != 1) goto L49;
    L53:
        r18 = -Math.abs(r18);
    L55:
        a(r18, true);
        if (this.i <= 0.0f) goto L58;
    L63:
        a("onPull");
    L64:
        this.f13365b.invalidate();
        return;
    L58:
        if (r18 != 0.0f) goto L60;
        r1 = true;
    L60:
        if (r1 == false) goto L63;
        b("onPullZero");
        goto L64
    L49:
        if (r19 == 2) goto L54;
        if (r19 == 3) goto L53;
    L54:
        r18 = Math.abs(r18);
        goto L55
    L43:
        if (r17 <= 0.0f) goto L45;
        this.m = true;
        goto L45
    L29:
        if (f(g(r9)) == true) goto L32;
        a(0.0f, false);
        i();
        return;
    L26:
        r14 = false;
        goto L27
    L10:
        r11 = false;
        goto L11
    }

    @Override // android.widget.EdgeEffect
    public float onPullDistance(float r1, float r2) {
        return b(r1, false);
    }

    @Override // android.widget.EdgeEffect
    public void onRelease() {
        this.u = -1;
        long r2 = AnimationUtils.currentAnimationTimeMillis();
        a.C0732a r4 = d();
        int r5 = a(r4);
        if (r5 == (-1)) goto L9;
        if (r5 == this.c) goto L9;
        c(Intrinsics.stringPlus("inactiveEdge activeOrientation=", Integer.valueOf(r5)));
        return;
    L9:
        if (b(r4, r2) == false) goto L12;
        c("oppositeReleasedInSameFrame");
        return;
    L12:
        float r6 = this.g;
        if (r6 != 0.0f) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L19;
        this.i = 0.0f;
        this.o = -1;
        this.m = true;
        i();
        b("releaseZeroTranslation");
        return;
    L19:
        float r0 = k(r6);
        float r1 = k(h());
        d r8 = d.f13362a;
        if (d.a() == false) goto L22;
        d.a(this.f13365b, "onRelease", "orientation=" + this.c + " initialValueDp=" + r0 + " initialVelocityDpPerMs=" + r1);
    L22:
        a(r4, r2);
        a("onRelease");
        this.o = r2;
        if (this.n != null) goto L25;
        this.n = new com.obric.oui.orecyclerview.base.d();
    L25:
        com.obric.oui.orecyclerview.base.d r3 = this.n;
        if (r3 == null) goto L29;
        r3.a(r1, r0);
    L29:
        i();
        this.f13365b.invalidate();
        return;
    L15:
        r7 = false;
        goto L16
    }

    @Override // android.widget.EdgeEffect
    public void setSize(int r3, int r4) {
        super.setSize(r3, r4);
        int r0 = this.c;
        if (r0 == 2) goto L7;
        if (r0 == 3) goto L7;
    L8:
        r3 = r4;
    L9:
        this.e = r3;
        return;
    L7:
        if (this.f == false) goto L9;
        goto L8
    }
}
