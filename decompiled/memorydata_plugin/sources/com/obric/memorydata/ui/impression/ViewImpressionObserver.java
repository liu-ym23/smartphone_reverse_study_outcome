package com.obric.memorydata.ui.impression;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\fJ\u0006\u0010.\u001a\u00020\u001eJ\u0006\u0010/\u001a\u00020\u001eJ\u0010\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u0004H\u0016J\u0010\u00102\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u0004H\u0016J\u0018\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u001eH\u0002J\b\u00108\u001a\u00020\u001eH\u0002J\b\u00109\u001a\u00020\u001eH\u0002J\b\u0010:\u001a\u00020\u001eH\u0002J\b\u0010;\u001a\u00020\rH\u0002J\b\u0010<\u001a\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/obric/memorydata/ui/impression/ViewImpressionObserver;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroidx/lifecycle/LifecycleEventObserver;", "view", "Landroid/view/View;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "minVisibleFraction", "", "minDurationMillis", "", "isEnabled", "Lkotlin/Function0;", "", "clipVisibleBounds", "Lkotlin/Function1;", "Landroid/graphics/Rect;", "<init>", "(Landroid/view/View;Landroidx/lifecycle/LifecycleOwner;FJLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "handler", "Landroid/os/Handler;", "visibleRect", "windowRect", "screenLocation", "", "observedTree", "Landroid/view/ViewTreeObserver;", "key", "", "onImpression", "", "isVisible", "hasReported", "refreshPending", "observingLifecycle", "impressionTask", "Ljava/lang/Runnable;", "detachTask", "scrollListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "preDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "focusListener", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "bind", "itemKey", "onDataRefreshed", "unbind", "onViewAttachedToWindow", BaseSwitches.V, "onViewDetachedFromWindow", "onStateChanged", AILabCheckPermissionTask.KEY_SOURCE, "event", "Landroidx/lifecycle/Lifecycle$Event;", "observeTree", "stopObservingTree", "computeVisibility", "reportIfVisible", "isEffectivelyVisible", "markInvisible", "Companion", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewImpressionObserver implements View.OnAttachStateChangeListener, LifecycleEventObserver {
    private static final a Companion = null;

    @Deprecated
    public static final long REFRESH_DETACH_GRACE_MILLIS = 300;
    private final Function1<Rect, Boolean> clipVisibleBounds;
    private final Runnable detachTask;
    private final ViewTreeObserver.OnWindowFocusChangeListener focusListener;
    private final Handler handler;
    private boolean hasReported;
    private final Runnable impressionTask;
    private final Function0<Boolean> isEnabled;
    private boolean isVisible;
    private Object key;
    private final LifecycleOwner lifecycleOwner;
    private final long minDurationMillis;
    private final float minVisibleFraction;
    private ViewTreeObserver observedTree;
    private boolean observingLifecycle;
    private Function0<Unit> onImpression;
    private final ViewTreeObserver.OnPreDrawListener preDrawListener;
    private boolean refreshPending;
    private final int[] screenLocation;
    private final ViewTreeObserver.OnScrollChangedListener scrollListener;
    private final View view;
    private final Rect visibleRect;
    private final Rect windowRect;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ui/impression/ViewImpressionObserver$Companion;", "", "<init>", "()V", "REFRESH_DETACH_GRACE_MILLIS", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13011a = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[Lifecycle.Event.ON_STOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f13011a = r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public ViewImpressionObserver(View r5, LifecycleOwner r6, float r7, long r8, Function0<Boolean> r10, Function1<? super Rect, Boolean> r11) {
        LifecycleOwner r9 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r6, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Function1<Rect, Boolean> r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r12, "isEnabled");
        Intrinsics.checkNotNullParameter(r13, "clipVisibleBounds");
        this.view = r5;
        this.lifecycleOwner = r9;
        this.minVisibleFraction = r7;
        this.minDurationMillis = r8;
        this.isEnabled = r12;
        this.clipVisibleBounds = r13;
        this.handler = new Handler(Looper.getMainLooper());
        this.visibleRect = new Rect();
        this.windowRect = new Rect();
        this.screenLocation = new int[2];
        this.impressionTask = new $$Lambda$ViewImpressionObserver$BE7zk7oGfTdZXb6YffelRYIPvE(this);
        this.detachTask = new $$Lambda$ViewImpressionObserver$nvJ3IdP3TLvMLcCm86_cRU5MTsk(this);
        this.scrollListener = new $$Lambda$ViewImpressionObserver$_Vt1uZKRB7B0cGv6QotryP33iNs(this);
        this.preDrawListener = new $$Lambda$ViewImpressionObserver$AVEnjFRCAIekVEnBMpvPZRlCvNU(this);
        this.focusListener = new $$Lambda$ViewImpressionObserver$gbenhZAupnjqW6K91s3IC_0lr3w(this);
        boolean r14 = true;
        if (r7 >= 0.0f) goto L5;
    L7:
        boolean r15 = false;
    L9:
        if (r15 == false) goto L20;
        if (r8 >= 0) goto L14;
        r14 = false;
    L14:
        if (r14 == false) goto L18;
        r5.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
        return;
    L18:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r7 >= 1.0f) goto L7;
        r15 = true;
        goto L9
    }

    public /* synthetic */ ViewImpressionObserver(View r8, LifecycleOwner r9, float r10, long r11, Function0 r13, Function1 r14, int r15, DefaultConstructorMarker r16) {
        LifecycleOwner r0 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r9, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        if ((r15 & 4) == 0) goto L5;
        float r3 = 0.99f;
    L7:
        if ((r15 & 8) == 0) goto L9;
        long r4 = 0;
    L11:
        if ((r15 & 16) == 0) goto L14;
        r2 = $$Lambda$ViewImpressionObserver$4XWeDZkUQqiHczHG7dc1YYMBR2c.INSTANCE;
    L14:
        if ((r15 & 32) == 0) goto L16;
        r1 = $$Lambda$ViewImpressionObserver$CRu2wLw1I1xS5DKBiq2GaCQY6L8.INSTANCE;
    L16:
        this(r8, r0, r3, r4, r2, r1);
        return;
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    private static final boolean _init_$lambda$0() {
        return true;
    }

    private static final boolean _init_$lambda$1(Rect r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return true;
    }

    private final void computeVisibility() {
        this.refreshPending = false;
        if (isEffectivelyVisible() == true) goto L7;
        markInvisible();
        return;
    L7:
        if (this.isVisible == false) goto L9;
        return;
    L9:
        this.isVisible = true;
        long r0 = this.minDurationMillis;
        if (r0 != 0) goto L12;
        reportIfVisible();
        return;
    L12:
        this.handler.postDelayed(this.impressionTask, r0);
    }

    private static final void detachTask$lambda$3(ViewImpressionObserver r0) {
        r0.markInvisible();
    }

    private static final void focusListener$lambda$6(ViewImpressionObserver r0, boolean r1) {
        if (r1 == false) goto L4;
        r0.view.invalidate();
        return;
    L4:
        r0.markInvisible();
    }

    private static final void impressionTask$lambda$2(ViewImpressionObserver r0) {
        r0.reportIfVisible();
    }

    private final boolean isEffectivelyVisible() {
        if (this.onImpression != null) goto L5;
        return false;
    L5:
        if (this.view.isAttachedToWindow() == true) goto L7;
        return false;
    L7:
        if (this.view.isShown() == true) goto L9;
        return false;
    L9:
        if (this.view.getWindowVisibility() == 0) goto L11;
        return false;
    L11:
        if (this.view.hasWindowFocus() == true) goto L13;
        return false;
    L13:
        if (this.lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L15;
        return false;
    L15:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.isEnabled.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L17;
        return false;
    L17:
        if (this.view.getWidth() > 0) goto L19;
        return false;
    L19:
        if (this.view.getHeight() <= 0) goto L59;
        View r0 = this.view;
    L22:
        if (r0 == null) goto L31;
        if (r0.getAlpha() <= 0.0f) goto L25;
        ViewParent r1 = r0.getParent();
        if (ZeusTransformUtils.instanceOf(r1, View.class) == true) goto L28;
        r0 = null;
        goto L22
    L28:
        r0 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
        goto L22
    L25:
        return false;
    L31:
        if (this.view.getLocalVisibleRect(this.visibleRect) == true) goto L33;
        return false;
    L33:
        this.view.getLocationOnScreen(this.screenLocation);
        Rect r2 = this.visibleRect;
        int[] r3 = this.screenLocation;
        r2.offset(r3[0], r3[1]);
        this.view.getWindowVisibleDisplayFrame(this.windowRect);
        if (this.visibleRect.intersect(this.windowRect) == true) goto L36;
        return false;
    L36:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.clipVisibleBounds.invoke(this.visibleRect), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L39;
        return false;
    L39:
        if (Math.min(this.visibleRect.width() / this.view.getWidth(), this.visibleRect.height() / this.view.getHeight()) > this.minVisibleFraction) goto L41;
        return false;
    L41:
        return true;
    L59:
        return false;
    }

    public static /* synthetic */ boolean lambda$4XWeDZkUQqiHczHG7dc1YYMBR2c() {
        return _init_$lambda$0();
    }

    public static /* synthetic */ boolean lambda$AVEnjFRCAIekVEnBMpvPZRlCvNU(ViewImpressionObserver r0) {
        return preDrawListener$lambda$5(r0);
    }

    /* JADX INFO: renamed from: lambda$BE7zk-7oGfTdZXb6YffelRYIPvE, reason: not valid java name */
    public static /* synthetic */ void m1219lambda$BE7zk7oGfTdZXb6YffelRYIPvE(ViewImpressionObserver r0) {
        impressionTask$lambda$2(r0);
    }

    public static /* synthetic */ boolean lambda$CRu2wLw1I1xS5DKBiq2GaCQY6L8(Rect r0) {
        return _init_$lambda$1(r0);
    }

    public static /* synthetic */ void lambda$_Vt1uZKRB7B0cGv6QotryP33iNs(ViewImpressionObserver r0) {
        scrollListener$lambda$4(r0);
    }

    public static /* synthetic */ void lambda$gbenhZAupnjqW6K91s3IC_0lr3w(ViewImpressionObserver r0, boolean r1) {
        focusListener$lambda$6(r0, r1);
    }

    public static /* synthetic */ void lambda$nvJ3IdP3TLvMLcCm86_cRU5MTsk(ViewImpressionObserver r0) {
        detachTask$lambda$3(r0);
    }

    private final void markInvisible() {
        this.handler.removeCallbacks(this.impressionTask);
        this.handler.removeCallbacks(this.detachTask);
        this.isVisible = false;
        this.hasReported = false;
        this.refreshPending = false;
    }

    private final void observeTree() {
        ViewTreeObserver r0 = this.view.getViewTreeObserver();
        if (this.observedTree != r0) goto L5;
        return;
    L5:
        stopObservingTree();
        if (r0.isAlive() == true) goto L8;
        return;
    L8:
        this.observedTree = r0;
        r0.addOnScrollChangedListener(this.scrollListener);
        r0.addOnPreDrawListener(this.preDrawListener);
        r0.addOnWindowFocusChangeListener(this.focusListener);
    }

    private static final boolean preDrawListener$lambda$5(ViewImpressionObserver r0) {
        r0.computeVisibility();
        return true;
    }

    private final void reportIfVisible() {
        if (isEffectivelyVisible() == true) goto L7;
        markInvisible();
        return;
    L7:
        if (this.hasReported == false) goto L9;
        return;
    L9:
        this.hasReported = true;
        Function0<Unit> r1 = this.onImpression;
        if (r1 == null) goto L13;
        r1.invoke();
        return;
    }

    private static final void scrollListener$lambda$4(ViewImpressionObserver r0) {
        r0.computeVisibility();
    }

    private final void stopObservingTree() {
        ViewTreeObserver r0 = this.observedTree;
        if (r0 != null) goto L5;
    L10:
        this.observedTree = null;
        return;
    L5:
        if (r0.isAlive() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.removeOnScrollChangedListener(this.scrollListener);
        r0.removeOnPreDrawListener(this.preDrawListener);
        r0.removeOnWindowFocusChangeListener(this.focusListener);
        goto L10
    }

    public final void bind(Object r4, Function0<Unit> r5) {
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "itemKey");
        Intrinsics.checkNotNullParameter(r6, "onImpression");
        if (this.lifecycleOwner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(this.key, r4) == true) goto L8;
        markInvisible();
    L8:
        this.key = r4;
        this.onImpression = r6;
        if (this.observingLifecycle == true) goto L12;
        this.observingLifecycle = true;
        this.lifecycleOwner.getLifecycle().addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(this, LifecycleObserver.class, "com.obric.memorydata.plugin"));
    L12:
        if (this.view.isAttachedToWindow() == false) goto L14;
        observeTree();
    L14:
        this.view.invalidate();
    }

    public final void onDataRefreshed() {
        this.refreshPending = true;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
        Intrinsics.checkNotNullParameter((LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin"), AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r4, "event");
        int r5 = b.f13011a[r4.ordinal()];
        if (r5 != 1) goto L5;
        this.view.invalidate();
        return;
    L5:
        if (r5 != 2) goto L7;
    L12:
        markInvisible();
        return;
    L7:
        if (r5 == 3) goto L12;
        if (r5 != 4) goto L17;
        unbind();
        this.view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, BaseSwitches.V);
        this.handler.removeCallbacks(this.detachTask);
        if (this.onImpression == null) goto L5;
        observeTree();
    L5:
        this.view.invalidate();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, BaseSwitches.V);
        stopObservingTree();
        this.handler.removeCallbacks(this.impressionTask);
        if (this.refreshPending == true) goto L5;
    L7:
        markInvisible();
        return;
    L5:
        if (this.hasReported == false) goto L7;
        this.refreshPending = false;
        this.handler.postDelayed(this.detachTask, 300);
    }

    public final void unbind() {
        markInvisible();
        this.key = null;
        this.onImpression = null;
        stopObservingTree();
        if (this.observingLifecycle == false) goto L6;
        this.lifecycleOwner.getLifecycle().removeObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(this, LifecycleObserver.class, "com.obric.memorydata.plugin"));
        this.observingLifecycle = false;
        return;
    }
}
