package com.obric.oui.bouncelayout;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.OverScroller;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.loc.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0002NOB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000fH\u0016J\b\u0010)\u001a\u00020'H\u0016J\u0012\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u001bH\u0016J\n\u00101\u001a\u0004\u0018\u000102H\u0002J\b\u00103\u001a\u00020'H\u0002J\b\u00104\u001a\u00020'H\u0002J\u0012\u00105\u001a\u00020\u000f2\b\u00106\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u00107\u001a\u00020\u000fJ\b\u00108\u001a\u00020'H\u0014J\u0010\u00109\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/H\u0016J(\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\bH\u0014J\u0010\u0010?\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/H\u0016J\b\u0010@\u001a\u00020'H\u0002J\u0014\u0010A\u001a\u00020'2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CH\u0002J\b\u0010D\u001a\u00020'H\u0002J\b\u0010E\u001a\u00020\bH\u0002J\b\u0010F\u001a\u00020'H\u0002J\u0012\u0010G\u001a\u00020'2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010J\u001a\u00020\u000fH\u0002J\u0018\u0010K\u001a\u00020\u000f2\u0006\u0010L\u001a\u0002022\u0006\u0010M\u001a\u00020\u001bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/obric/oui/bouncelayout/OListView;", "Landroid/widget/ListView;", "Lcom/obric/oui/bouncelayout/IBounceTranslationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bounceBottom", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceGestureDelegate", "Lcom/obric/oui/bouncelayout/AbsListBounceGestureDelegate;", "bounceStoppedForTouch", "", "bounceTop", "clickDuringOverScrollDelegate", "Lcom/obric/oui/bouncelayout/BounceClickDuringOverScrollDelegate;", "edgeEffectsInstalled", "edgeFieldBottom", "Ljava/lang/reflect/Field;", "edgeFieldTop", "flingRunnableField", "flingRunnableScrollerField", "lastScrollDirection", "lastScrollerVelocity", "", "lastVerticalScrollOffset", "originalBottomEffect", "", "originalTopEffect", "overscrollDelegate", "Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "scrollerField", "touchModeField", "translationDelegate", "Lcom/obric/oui/bouncelayout/BounceTranslationDelegate;", "allowClickDuringOverScroll", "", "allow", "computeScroll", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getBounceTranslation", "getOverScrollerOrNull", "Landroid/widget/OverScroller;", "initEdgeEffectReflection", "installBounceEdgeEffects", "isBounceEffectActive", "effect", "isOverScrolling", "onDetachedFromWindow", "onInterceptTouchEvent", "onSizeChanged", "w", o.g, "oldw", "oldh", "onTouchEvent", "releaseStoppedBounceIfNeeded", "removeCurrentFlingRunnable", "flingRunnable", "Ljava/lang/Runnable;", "resetAbsListViewTouchMode", "resolveStoppedBounceReleaseEdge", "restoreOriginalEdgeEffects", "setOnBounceTranslationListener", "listener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "stopBounceIfNeeded", "tryAbsorbRunningFlingAtEdge", "scroller", "velocity", "Companion", "ReflectionFields", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListView extends ListView implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13350a = null;
    private static volatile b u;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f13351b;
    private e c;
    private boolean d;
    private float e;
    private int f;
    private int g;
    private boolean h;
    private Object i;
    private Object j;
    private Field k;
    private Field l;
    private Field m;
    private Field n;
    private final f o;
    private final g p;
    private final com.obric.oui.bouncelayout.b q;
    private final com.obric.oui.bouncelayout.a r;
    private Field s;
    private Field t;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u001e\u0010\f\u001a\u0004\u0018\u00010\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/bouncelayout/OListView$Companion;", "", "()V", "STOPPED_BOUNCE_NONE", "", "TAG", "", "TOUCH_MODE_REST", "cachedReflectionFields", "Lcom/obric/oui/bouncelayout/OListView$ReflectionFields;", "getCachedReflectionFields", "resolveReflectionFields", "tryGetField", "Ljava/lang/reflect/Field;", "clazz", "Ljava/lang/Class;", ActivityLifecycle.NAME, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final b a() {
            b r0 = OListView.a();
            if (r0 != null) goto L13;
            monitor-enter(this);
            b r1 = OListView.a();     // Catch: Throwable -> L10
            if (r1 != null) goto L8;
            r1 = OListView.f13350a.b();     // Catch: Throwable -> L10
            a r2 = OListView.f13350a;     // Catch: Throwable -> L10
            OListView.a(r1);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
            return r1;
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }

        public static final /* synthetic */ b a(a r0) {
            return r0.a();
        }

        private final Field a(Class<?> r3, String r4) {
            Field r2 = r3.getDeclaredField(r4);     // Catch: Throwable -> L4
            r2.setAccessible(true);     // Catch: Throwable -> L4
            return r2;
        L4:
            th = move-exception;
            Log.w("OListView", "Failed to reflect field " + r4 + " from " + r3.getName(), th);
            return (Field) ZeusTransformUtils.preCheckCast(null, Field.class, "com.obric.memorydata.plugin");
        }

        private final b b() {
            Field r2 = a(AbsListView.class, "mEdgeGlowTop");     // Catch: Throwable -> L18
            if (r2 != null) goto L6;
            r2 = a(AbsListView.class, "mTopGlow");     // Catch: Throwable -> L18
        L6:
            Field r3 = a(AbsListView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L18
            if (r3 != null) goto L9;
            r3 = a(AbsListView.class, "mBottomGlow");     // Catch: Throwable -> L18
        L9:
            Field r4 = a(AbsListView.class, "mScroller");     // Catch: Throwable -> L18
            Field r5 = a(AbsListView.class, "mFlingRunnable");     // Catch: Throwable -> L18
            Field r6 = null;
            if (r5 == null) goto L16;
            Class<?> r7 = r5.getType();     // Catch: Throwable -> L18
            if (r7 == null) goto L16;
            r6 = OListView.f13350a.a(r7, "mScroller");     // Catch: Throwable -> L18
        L16:
            Field r1 = r2;
            Field r8 = r3;
            Field r9 = r6;
            return new b(r1, r8, r4, r5, r9, a(AbsListView.class, "mTouchMode"));
        L18:
            th = move-exception;
            Log.w("OListView", "Failed to reflect edge effect fields", th);
            return new b(null, null, null, null, null, null, 63, null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/bouncelayout/OListView$ReflectionFields;", "", "edgeFieldTop", "Ljava/lang/reflect/Field;", "edgeFieldBottom", "scrollerField", "flingRunnableField", "flingRunnableScrollerField", "touchModeField", "(Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;)V", "getEdgeFieldBottom", "()Ljava/lang/reflect/Field;", "getEdgeFieldTop", "getFlingRunnableField", "getFlingRunnableScrollerField", "getScrollerField", "getTouchModeField", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Field f13352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Field f13353b;
        private final Field c;
        private final Field d;
        private final Field e;
        private final Field f;

        public b() {
            this(null, null, null, null, null, null, 63, null);
        }

        public b(Field r1, Field r2, Field r3, Field r4, Field r5, Field r6) {
            this.f13352a = r1;
            this.f13353b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public /* synthetic */ b(Field r2, Field r3, Field r4, Field r5, Field r6, Field r7, int r8, DefaultConstructorMarker r9) {
            if ((r8 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r8 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r8 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r8 & 8) == 0) goto L15;
            r5 = null;
        L15:
            if ((r8 & 16) == 0) goto L18;
            r6 = null;
        L18:
            if ((r8 & 32) == 0) goto L20;
            r7 = null;
        L20:
            this(r2, r3, r4, r5, r6, r7);
        }

        public final Field a() {
            return this.f13352a;
        }

        public final Field b() {
            return this.f13353b;
        }

        public final Field c() {
            return this.c;
        }

        public final Field d() {
            return this.d;
        }

        public final Field e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13352a, r6.f13352a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13353b, r6.f13353b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final Field f() {
            return this.f;
        }

        public int hashCode() {
            Field r0 = this.f13352a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Field r4 = this.f13353b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Field r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Field r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Field r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            Field r16 = this.f;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ReflectionFields(edgeFieldTop=" + this.f13352a + ", edgeFieldBottom=" + this.f13353b + ", scrollerField=" + this.c + ", flingRunnableField=" + this.d + ", flingRunnableScrollerField=" + this.e + ", touchModeField=" + this.f + ')';
        }
    }

    static {
        f13350a = new a(null);
    }

    public OListView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OListView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OListView(Context r11, AttributeSet r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        super(r14, r15, r13);
        this.o = new f((Function0) ZeusTransformUtils.preCheckCast(new OListView$overscrollDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OListView$overscrollDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.p = new g((Function0) ZeusTransformUtils.preCheckCast(new OListView$translationDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OListView$translationDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.q = new com.obric.oui.bouncelayout.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OListView$clickDuringOverScrollDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OListView$clickDuringOverScrollDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.r = new com.obric.oui.bouncelayout.a((AbsListView) ZeusTransformUtils.preCheckCast(this, AbsListView.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OListView$bounceGestureDelegate$1(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OListView$bounceGestureDelegate$2(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OListView$bounceGestureDelegate$3(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OListView$bounceGestureDelegate$4(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OListView$bounceGestureDelegate$5(this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OListView$bounceGestureDelegate$6(this), Function0.class, "com.obric.memorydata.plugin"));
        setOverScrollMode(0);
        e.f13364a.a("Landroid/widget/AbsListView;");
        f();
        g();
    }

    public /* synthetic */ OListView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = R.attr.listViewStyle;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ b a() {
        return u;
    }

    public static final /* synthetic */ e a(OListView r0) {
        return r0.f13351b;
    }

    public static final /* synthetic */ void a(b r0) {
        u = r0;
    }

    static /* synthetic */ void a(OListView r2, Runnable r3, int r4, Object r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L10;
        if ((r4 & 1) == 0) goto L7;
        r6 = null;
    L7:
        r2.a(r6);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeCurrentFlingRunnable");
    }

    private final void a(Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L14;
        r5 = null;
        Field r0 = this.l;     // Catch: Throwable -> L13
        if (r0 != null) goto L8;
        Object r1 = null;
    L10:
        if (ZeusTransformUtils.instanceOf(r1, Runnable.class) == false) goto L14;
        r5 = (Runnable) ZeusTransformUtils.preCheckCast(r1, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        goto L14
    L8:
        r1 = r0.get(this);     // Catch: Throwable -> L13
    L13:
        r5 = (Runnable) ZeusTransformUtils.preCheckCast(null, Runnable.class, "com.obric.memorydata.plugin");
    L14:
        if (r5 == null) goto L19;
        removeCallbacks(r5);
        return;
    }

    private final boolean a(OverScroller r9, float r10) {
        if (r10 > 0.0f) goto L5;
        return false;
    L5:
        boolean r1 = !canScrollList(-1);
        boolean r4 = !canScrollList(1);
        if (this.f >= 0) goto L25;
        if (r1 == false) goto L25;
        e r2 = this.f13351b;
        if (r2 != null) goto L12;
    L10:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L25;
        d r5 = d.f13362a;
        if (d.a() == false) goto L18;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbTop", Intrinsics.stringPlus("velocity=", Float.valueOf(r10)));
    L18:
        e r6 = this.f13351b;
        if (r6 == null) goto L23;
        int r11 = (int) r10;
    L22:
        r6.onAbsorb(r11);
    L23:
        boolean r12 = true;
    L42:
        if (r12 == false) goto L44;
        r9.abortAnimation();
        a(this, null, 1, null);
        this.e = 0.0f;
        this.f = 0;
        invalidate();
    L44:
        return r12;
    L12:
        if (r2.isFinished() != true) goto L10;
        r3 = true;
    L25:
        if (this.f <= 0) goto L41;
        if (r4 == false) goto L41;
        e r7 = this.c;
        if (r7 != null) goto L31;
    L29:
        boolean r8 = false;
    L33:
        if (r8 == false) goto L41;
        d r13 = d.f13362a;
        if (d.a() == false) goto L37;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingAbsorbBottom", Intrinsics.stringPlus("velocity=", Float.valueOf(r10)));
    L37:
        r6 = this.c;
        if (r6 == null) goto L23;
        r11 = -((int) r10);
        goto L22
    L31:
        if (r7.isFinished() != true) goto L29;
        r8 = true;
    L41:
        r12 = false;
        goto L42
    }

    public static final /* synthetic */ boolean a(OListView r0, MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    private final boolean a(e r4) {
        if (r4 == null) goto L18;
        if (r4.getDistance() != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L10;
        return true;
    L10:
        if (r4.a() != 0.0f) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == true) goto L15;
        return true;
    L15:
        if (r4.isFinished() == true) goto L18;
        return true;
    L12:
        r2 = false;
        goto L13
    L7:
        r1 = false;
    L18:
        return false;
    }

    public static final /* synthetic */ e b(OListView r0) {
        return r0.c;
    }

    private final void b() {
        Field r0 = this.n;     // Catch: Throwable -> L7
        if (r0 == null) goto L10;
        r0.setInt(this, -1);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    }

    private final boolean c() {
        if (this.d == true) goto L5;
        return false;
    L5:
        OverScroller r1 = getOverScrollerOrNull();
        e r3 = this.f13351b;
        if (r3 != null) goto L8;
        float r4 = 0.0f;
    L10:
        if (r4 != 0.0f) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L25;
        e r6 = this.c;
        if (r6 != null) goto L17;
        float r7 = 0.0f;
    L19:
        if (r7 != 0.0f) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L25;
        boolean r9 = false;
    L26:
        e r10 = this.f13351b;
        if (r10 != null) goto L30;
    L28:
        boolean r11 = false;
    L32:
        if (r11 == true) goto L42;
        e r12 = this.c;
        if (r12 != null) goto L37;
    L35:
        boolean r13 = false;
    L39:
        if (r13 == true) goto L42;
        boolean r14 = false;
    L43:
        if (r9 == true) goto L48;
        if (r14 == true) goto L48;
        this.e = 0.0f;
        this.f = 0;
        this.g = computeVerticalScrollOffset();
        return false;
    L48:
        if (r1 != null) goto L51;
    L49:
        boolean r15 = false;
    L53:
        if (r15 == false) goto L57;
        if (r1 == null) goto L57;
        r1.abortAnimation();
    L57:
        Runnable r2 = null;
        Field r16 = this.l;     // Catch: Throwable -> L66
        if (r16 != null) goto L61;
        Object r17 = null;
    L63:
        if (ZeusTransformUtils.instanceOf(r17, Runnable.class) == false) goto L67;
        r2 = (Runnable) ZeusTransformUtils.preCheckCast(r17, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L66
    L67:
        a(r2);
        e r0 = this.f13351b;
        if (r0 == null) goto L71;
        r0.b();
    L71:
        e r18 = this.c;
        if (r18 == null) goto L75;
        r18.b();
    L75:
        invalidate();
        this.e = 0.0f;
        this.f = 0;
        this.g = computeVerticalScrollOffset();
        return true;
    L61:
        r17 = r16.get(this);     // Catch: Throwable -> L66
    L66:
        r2 = (Runnable) ZeusTransformUtils.preCheckCast(null, Runnable.class, "com.obric.memorydata.plugin");
        goto L67
    L51:
        if (r1.isFinished() == true) goto L49;
        r15 = true;
        goto L53
    L37:
        if (r12.isFinished() == true) goto L35;
        r13 = true;
    L42:
        r14 = true;
        goto L43
    L30:
        if (r10.isFinished() == true) goto L28;
        r11 = true;
        goto L32
    L21:
        r8 = false;
        goto L22
    L17:
        r7 = r6.a();
    L25:
        r9 = true;
        goto L26
    L12:
        r5 = false;
        goto L13
    L8:
        r4 = r3.a();
        goto L10
    }

    public static final /* synthetic */ boolean c(OListView r0) {
        return r0.d;
    }

    private final void d() {
        if (this.h == true) goto L5;
        return;
    L5:
        int r0 = e();
        if (r0 != 0) goto L8;
        e r1 = this.f13351b;
        if (r1 == null) goto L17;
    L16:
        r1.onRelease();
    L17:
        this.h = false;
        invalidate();
        return;
    L8:
        if (r0 != 1) goto L17;
        r1 = this.c;
        if (r1 != null) goto L16;
        goto L16
    }

    public static final /* synthetic */ boolean d(OListView r0) {
        return r0.c();
    }

    private final int e() {
        boolean r0 = a(this.f13351b);
        boolean r1 = a(this.c);
        if (r0 == false) goto L6;
        if (r1 == true) goto L6;
    L25:
        return 0;
    L6:
        if (r1 == false) goto L9;
        if (r0 == true) goto L9;
        return 1;
    L9:
        e r2 = this.f13351b;
        if (r2 != null) goto L12;
        float r3 = 0.0f;
    L14:
        if (r3 > 0.0f) goto L25;
        e r4 = this.c;
        if (r4 != null) goto L19;
        float r5 = 0.0f;
    L21:
        if (r5 < 0.0f) goto L27;
        return -1;
    L27:
        return 1;
    L19:
        r5 = r4.a();
        goto L21
    L12:
        r3 = r2.a();
        goto L14
    }

    public static final /* synthetic */ void e(OListView r0) {
        r0.b();
    }

    private final void f() {
        b r0 = a.a(f13350a);
        this.s = r0.a();
        this.t = r0.b();
        this.k = r0.c();
        this.l = r0.d();
        this.m = r0.e();
        this.n = r0.f();
    }

    private final void g() {
        Field r2 = this.s;
        Field r3 = this.t;
        if (r2 == null) goto L24;
        if (r3 == null) goto L25;
    L19:
        th = move-exception;
        Log.w("OListView", "Failed to install BounceEdgeEffects, restoring original.", th);
        h();
        return;
    L7:
        if (this.i != null) goto L10;
        this.i = r2.get(this);     // Catch: Throwable -> L19
    L10:
        if (this.j != null) goto L12;
        this.j = r3.get(this);     // Catch: Throwable -> L19
    L12:
        this.o.b();     // Catch: Throwable -> L19
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r5, "context");     // Catch: Throwable -> L19
        e r4 = new e(r5, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0, this.o.a());     // Catch: Throwable -> L19
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r6, "context");     // Catch: Throwable -> L19
        e r7 = new e(r6, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 1, this.o.a());     // Catch: Throwable -> L19
        if (getWidth() > 0) goto L15;
    L17:
        r2.set(this, r4);     // Catch: Throwable -> L19
        r3.set(this, r7);     // Catch: Throwable -> L19
        this.f13351b = r4;     // Catch: Throwable -> L19
        this.c = r7;     // Catch: Throwable -> L19
        this.o.c();     // Catch: Throwable -> L19
        this.p.a();     // Catch: Throwable -> L19
        this.d = true;     // Catch: Throwable -> L19
        return;
    L15:
        if (getHeight() <= 0) goto L17;
        r4.setSize(getWidth(), getHeight());     // Catch: Throwable -> L19
        r7.setSize(getWidth(), getHeight());     // Catch: Throwable -> L19
        goto L17
    L25:
        return;
    }

    private final OverScroller getOverScrollerOrNull() {
        Field r2 = this.k;     // Catch: Throwable -> L32
        if (r2 != null) goto L6;
        Object r3 = null;
    L8:
        if (ZeusTransformUtils.instanceOf(r3, OverScroller.class) == false) goto L11;
        OverScroller r4 = (OverScroller) ZeusTransformUtils.preCheckCast(r3, OverScroller.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
    L12:
        if (r4 == null) goto L38;
        return r4;
    L11:
        r4 = null;
        goto L12
    L6:
        r3 = r2.get(this);     // Catch: Throwable -> L32
    L38:
        Field r5 = this.l;     // Catch: Throwable -> L33
        if (r5 == null) goto L19;
        Object r6 = r5.get(this);     // Catch: Throwable -> L33
    L20:
        if (r6 != null) goto L36;
        return null;
    L36:
        Field r7 = this.m;     // Catch: Throwable -> L30
        if (r7 != null) goto L25;
        Object r8 = null;
    L27:
        if (ZeusTransformUtils.instanceOf(r8, OverScroller.class) == false) goto L40;
        return (OverScroller) ZeusTransformUtils.preCheckCast(r8, OverScroller.class, "com.obric.memorydata.plugin");
    L40:
        return null;
    L25:
        r8 = r7.get(r6);     // Catch: Throwable -> L30
    L31:
        return (OverScroller) ZeusTransformUtils.preCheckCast(null, OverScroller.class, "com.obric.memorydata.plugin");
    L19:
        r6 = null;
        goto L20
    }

    private final void h() {
        Field r0 = this.s;
        Field r1 = this.t;
        if (r0 != null) goto L29;
    L7:
        if (r1 == null) goto L19;
        Object r2 = this.j;     // Catch: Throwable -> L12
        if (r2 == null) goto L19;
        r1.set(this, r2);     // Catch: Throwable -> L12
    L12:
        e r3 = this.f13351b;
        if (r3 == null) goto L16;
        r3.c();
    L16:
        e r4 = this.c;
        if (r4 == null) goto L27;
    L26:
        r4.c();
    L27:
        this.f13351b = null;
        this.c = null;
        this.d = false;
        return;
    L19:
        e r5 = this.f13351b;
        if (r5 == null) goto L23;
        r5.c();
    L23:
        r4 = this.c;
        if (r4 != null) goto L26;
    L29:
        Object r6 = this.i;     // Catch: Throwable -> L12
        if (r6 == null) goto L7;
        r0.set(this, r6);     // Catch: Throwable -> L12
        goto L7
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.d == true) goto L6;
        return;
    L6:
        if (computeVerticalScrollRange() > computeVerticalScrollExtent()) goto L8;
        return;
    L8:
        int r0 = computeVerticalScrollOffset();
        OverScroller r1 = getOverScrollerOrNull();
        if (r1 != null) goto L11;
    L22:
        float r2 = this.e;
        if (r2 <= 0.0f) goto L38;
        boolean r3 = !canScrollList(-1);
        boolean r4 = true ^ canScrollList(1);
        int r5 = this.f;
        if (r5 >= 0) goto L32;
        if (r3 == false) goto L32;
        e r6 = this.f13351b;
        if (r6 == null) goto L38;
        int r7 = (int) r2;
    L31:
        r6.onAbsorb(r7);
    L32:
        if (r5 <= 0) goto L38;
        if (r4 == false) goto L38;
        r6 = this.c;
        if (r6 == null) goto L38;
        r7 = -((int) r2);
    L38:
        this.e = 0.0f;
        this.f = 0;
        this.g = r0;
        return;
    L11:
        if (r1.isFinished() == true) goto L22;
        this.e = r1.getCurrVelocity();
        int r8 = r0 - this.g;
        if (r8 <= 0) goto L15;
        this.f = 1;
    L17:
        d r9 = d.f13362a;
        if (d.a() == false) goto L20;
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), "flingFrame", "offset=" + r0 + " delta=" + r8 + " velocity=" + this.e + " direction=" + this.f);
    L20:
        this.g = r0;
        a(r1, this.e);
        return;
    L15:
        if (r8 >= 0) goto L17;
        this.f = -1;
        goto L17
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        e r0 = this.f13351b;
        if (r0 != null) goto L7;
        float r1 = 0.0f;
    L8:
        e r2 = this.c;
        if (r2 != null) goto L11;
        float r3 = 0.0f;
    L12:
        float r5 = r1 + r3;
        if (r5 != 0.0f) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == true) goto L18;
        int r7 = r4.save();
        r4.translate(0.0f, r5);
        super.dispatchDraw(r4);
        r4.restoreToCount(r7);
        return;
    L18:
        super.dispatchDraw(r4);
        return;
    L15:
        r6 = false;
        goto L16
    L11:
        r3 = r2.a();
        goto L12
    L7:
        r1 = r0.a();
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(final MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        this.q.a(r6);
        com.obric.oui.bouncelayout.b r0 = this.q;
        Boolean r1 = r0.a(r6, 0.0f, -r0.b(), (Function0) ZeusTransformUtils.preCheckCast(new OListView$dispatchTouchEvent$handled$1(this, r6), Function0.class, "com.obric.memorydata.plugin"));
        if (r1 != null) goto L5;
        boolean r2 = super.dispatchTouchEvent(r6);
    L7:
        if (r6.getActionMasked() != 1) goto L9;
    L10:
        d();
    L11:
        return r2;
    L9:
        if (r6.getActionMasked() != 3) goto L11;
    L5:
        r2 = r1.booleanValue();
        goto L7
    }

    @Override // com.obric.oui.bouncelayout.h
    public float getBounceTranslation() {
        e r0 = this.f13351b;
        float r1 = 0.0f;
        if (r0 != null) goto L5;
        float r2 = 0.0f;
    L6:
        e r3 = this.c;
        if (r3 == null) goto L11;
        r1 = r3.a();
    L11:
        return r2 + r1;
    L5:
        r2 = r0.a();
        goto L6
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e r0 = this.f13351b;
        if (r0 == null) goto L6;
        r0.c();
    L6:
        e r1 = this.c;
        if (r1 == null) goto L11;
        r1.c();
        return;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        int r0 = r5.getActionMasked();
        boolean r2 = true;
        if (r0 == 0) goto L31;
        if (r0 != 1) goto L6;
    L27:
        this.r.a();
        d();
    L29:
        return super.onInterceptTouchEvent(r5);
    L6:
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L27;
        if (r0 == 5) goto L18;
        if (r0 != 6) goto L29;
        if (this.r.d(r5) == false) goto L29;
        return true;
    L18:
        if (this.r.c(r5) == false) goto L29;
        return true;
    L21:
        if (this.q.b(r5) == false) goto L24;
        return false;
    L24:
        if (this.r.b(r5) == false) goto L29;
        this.h = false;
        return true;
    L31:
        if (c() == false) goto L33;
    L36:
        this.h = r2;
        this.r.a(r5);
        boolean r1 = super.onInterceptTouchEvent(r5);
        if (this.q.b(r5) == false) goto L39;
        return false;
    L39:
        return r1;
    L33:
        if (this.h == true) goto L36;
        r2 = false;
        goto L36
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.o.b();
        e r5 = this.f13351b;
        if (r5 == null) goto L6;
        r5.setSize(r1, r2);
    L6:
        e r0 = this.c;
        if (r0 == null) goto L11;
        r0.setSize(r1, r2);
        return;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        int r0 = r5.getActionMasked();
        boolean r1 = false;
        if (r0 == 0) goto L30;
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L25;
        if (r0 == 5) goto L18;
        if (r0 != 6) goto L38;
        if (this.r.d(r5) == false) goto L38;
        return true;
    L38:
        return super.onTouchEvent(r5);
    L18:
        if (this.r.c(r5) == false) goto L38;
        return true;
    L21:
        if (this.r.f(r5) == false) goto L38;
        this.h = false;
        return true;
    L25:
        if (this.r.g(r5) == false) goto L28;
        this.h = false;
        return true;
    L28:
        d();
        goto L38
    L30:
        if (c() == false) goto L32;
    L33:
        r1 = true;
    L34:
        this.h = r1;
        if (this.r.e(r5) == false) goto L38;
        return true;
    L32:
        if (this.h == false) goto L34;
        goto L33
    }

    public void setOnBounceTranslationListener(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        this.p.a(r4);
    }
}
