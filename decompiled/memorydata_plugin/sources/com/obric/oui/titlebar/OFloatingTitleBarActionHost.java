package com.obric.oui.titlebar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\u0018\u0000 `2\u00020\u0001:\u0003`abB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001d\u001a\u00020\u001eH\u0002JI\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00102\b\b\u0002\u0010#\u001a\u00020\u00102\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010'H\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0015H\u0002J\u001a\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020\u0010H\u0007J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0015H\u0002J\r\u0010.\u001a\u00020\u001eH\u0000¢\u0006\u0002\b/J\r\u00100\u001a\u00020!H\u0000¢\u0006\u0002\b1J\b\u00102\u001a\u00020\u001eH\u0002J\b\u00103\u001a\u00020\u001eH\u0002J\u0014\u00104\u001a\u00020\u001e2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\nH\u0002J\r\u00105\u001a\u00020%H\u0000¢\u0006\u0002\b6J\b\u00107\u001a\u00020\u001eH\u0002J\u0010\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020:H\u0002J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0015H\u0002J\u0006\u0010@\u001a\u00020\nJ\b\u0010A\u001a\u0004\u0018\u00010\nJ\b\u0010B\u001a\u00020\u0010H\u0002J\u0015\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\u0010H\u0000¢\u0006\u0002\bEJ\b\u0010F\u001a\u00020\u001eH\u0002J\u0010\u0010G\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0015H\u0002J\u0010\u0010H\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\nH\u0002J*\u0010I\u001a\u00020\u001e2\u0006\u0010J\u001a\u00020>2\u0006\u0010\"\u001a\u00020\u00102\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010'H\u0002J\u001d\u0010K\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\bLJ\u0006\u0010&\u001a\u00020\u001eJ\u0006\u0010M\u001a\u00020\u001eJ\u0010\u0010N\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0015H\u0002J\u0010\u0010O\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0015H\u0002J\u001d\u0010P\u001a\u00020\u001e2\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010'H\u0000¢\u0006\u0002\bRJ\u0010\u0010S\u001a\u00020\u001e2\b\u0010Q\u001a\u0004\u0018\u00010\u0012J\b\u0010T\u001a\u00020\u0010H\u0002J\u0010\u0010U\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\nH\u0002J\u0015\u0010V\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\nH\u0000¢\u0006\u0002\bWJ\u0010\u0010X\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0015H\u0002J\u0010\u0010Y\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0015H\u0002J\u0010\u0010Z\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\nH\u0002J\u0010\u0010[\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\nH\u0002J\u0014\u0010\\\u001a\u00020\u001e2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\nH\u0007J\r\u0010]\u001a\u00020\u001eH\u0000¢\u0006\u0002\b^J\f\u0010_\u001a\u00020:*\u00020!H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "boundTitleBar", "easeInOut", "Landroid/view/animation/PathInterpolator;", "floatingApplyGeneration", "floatingTransitionActionsHidden", "", "floatingTransitionEndListener", "Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost$OnFloatingTransitionEndListener;", "hostTransitionGeneration", "pendingBind", "Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost$PendingBind;", "pendingTakeOverOnPreDrawTitleBar", "pendingTakeOverTitleBar", "pendingUnbindPosted", "pendingUnbindTitleBar", "preHiddenTitleBar", "waitingReadyBind", "waitingReadyTitleBar", "applyFloatingTransitionActionVisibility", "", "applyState", "state", "Lcom/obric/oui/titlebar/OFloatingTitleBarState;", "animate", "animateContentInset", "startContentTopOffset", "", "onTransitionEnd", "Lkotlin/Function0;", "applyState$OUI_standardRelease", "(Lcom/obric/oui/titlebar/OFloatingTitleBarState;ZZLjava/lang/Float;Lkotlin/jvm/functions/Function0;)V", "beginPrepareBind", "bind", "titleBar", "bindWhenReady", "cancelFloatingTransitionState", "cancelFloatingTransitionState$OUI_standardRelease", "captureAnimationState", "captureAnimationState$OUI_standardRelease", "clearBindState", "clearDeferredTakeOver", "completePendingTakeOverActions", "currentFloatingTransitionContentTopOffset", "currentFloatingTransitionContentTopOffset$OUI_standardRelease", "deactivateOwnedTitleBars", "debugLog", "message", "", "debugSummary", "disableClipRecursively", "view", "Landroid/view/View;", "dispatchHostTransitionEndIfReady", "getActionTitleBar", "getBoundTitleBar", "hasTakenOverActions", "hideFloatingTransitionActions", "hide", "hideFloatingTransitionActions$OUI_standardRelease", "interruptFloatingTransitionForActionChange", "isActiveBind", "isTitleBarOwnedByHost", "moveTo", TypedValues.AttributesType.S_TARGET, "onBoundTitleBarActionStateChanged", "onBoundTitleBarActionStateChanged$OUI_standardRelease", "onTransitionStart", "prepareReady", "schedulePrepareOnFrame", "setFloatingTransitionDrawUpdateListener", "listener", "setFloatingTransitionDrawUpdateListener$OUI_standardRelease", "setFloatingTransitionEndListener", "shouldDeferTakeOverActions", "shouldPreHideTarget", "shouldProvideLaunchAnimationState", "shouldProvideLaunchAnimationState$OUI_standardRelease", "shouldSyncTakenOverTitleBar", "startPendingHostTransition", "takeOverActions", "takeOverActionsOnNextPreDraw", "unbind", "useSurfaceBackdropMaterial", "useSurfaceBackdropMaterial$OUI_standardRelease", "summary", "Companion", "OnFloatingTransitionEndListener", "PendingBind", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFloatingTitleBarActionHost extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14746a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PathInterpolator f14747b;
    private OFloatingTitleBar c;
    private OFloatingTitleBar d;
    private OFloatingTitleBar e;
    private c f;
    private OFloatingTitleBar g;
    private OFloatingTitleBar h;
    private c i;
    private OFloatingTitleBar j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private b o;
    private final OFloatingTitleBar p;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost$Companion;", "", "()V", "HOST_MOVE_DURATION", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost$OnFloatingTransitionEndListener;", "", "onFloatingTransitionEnd", "", "targetTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void a(OFloatingTitleBar r1);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010/\u001a\u000200R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\rR\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\rR\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\rR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\rR\u001a\u0010$\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\rR\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost$PendingBind;", "", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "animate", "", "deferTakeOverActions", "(Lcom/obric/oui/titlebar/OFloatingTitleBar;ZZ)V", "getAnimate", "()Z", "contentTransitionFinished", "getContentTransitionFinished", "setContentTransitionFinished", "(Z)V", "contentTransitionStarted", "getContentTransitionStarted", "setContentTransitionStarted", "getDeferTakeOverActions", "hostMoveTransitionFinished", "getHostMoveTransitionFinished", "setHostMoveTransitionFinished", "hostStateTransitionFinished", "getHostStateTransitionFinished", "setHostStateTransitionFinished", "hostTransitionEndDispatched", "getHostTransitionEndDispatched", "setHostTransitionEndDispatched", "hostTransitionGeneration", "", "getHostTransitionGeneration", "()I", "setHostTransitionGeneration", "(I)V", "hostTransitionStarted", "getHostTransitionStarted", "setHostTransitionStarted", "prepared", "getPrepared", "setPrepared", "state", "Lcom/obric/oui/titlebar/OFloatingTitleBarState;", "getState", "()Lcom/obric/oui/titlebar/OFloatingTitleBarState;", "setState", "(Lcom/obric/oui/titlebar/OFloatingTitleBarState;)V", "getTitleBar", "()Lcom/obric/oui/titlebar/OFloatingTitleBar;", "debugSummary", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OFloatingTitleBar f14748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f14749b;
        private final boolean c;
        private com.obric.oui.titlebar.a d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private int i;
        private boolean j;
        private boolean k;
        private boolean l;

        public c(OFloatingTitleBar r2, boolean r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "titleBar");
            this.f14748a = r2;
            this.f14749b = r3;
            this.c = r4;
        }

        public final OFloatingTitleBar a() {
            return this.f14748a;
        }

        public final void a(int r1) {
            this.i = r1;
        }

        public final void a(com.obric.oui.titlebar.a r1) {
            this.d = r1;
        }

        public final void a(boolean r1) {
            this.e = r1;
        }

        public final void b(boolean r1) {
            this.f = r1;
        }

        public final boolean b() {
            return this.f14749b;
        }

        public final void c(boolean r1) {
            this.g = r1;
        }

        public final boolean c() {
            return this.c;
        }

        public final com.obric.oui.titlebar.a d() {
            return this.d;
        }

        public final void d(boolean r1) {
            this.h = r1;
        }

        public final void e(boolean r1) {
            this.j = r1;
        }

        public final boolean e() {
            return this.e;
        }

        public final void f(boolean r1) {
            this.k = r1;
        }

        public final boolean f() {
            return this.f;
        }

        public final void g(boolean r1) {
            this.l = r1;
        }

        public final boolean g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
        }

        public final int i() {
            return this.i;
        }

        public final boolean j() {
            return this.j;
        }

        public final boolean k() {
            return this.k;
        }

        public final boolean l() {
            return this.l;
        }

        public final String m() {
            return "bindTitleBar=" + System.identityHashCode(this.f14748a) + " animate=" + this.f14749b + " defer=" + this.c + " prepared=" + this.e + " contentStart=" + this.f + " contentEnd=" + this.g + " hostStart=" + this.h + " generation=" + this.i + " stateEnd=" + this.j + " moveEnd=" + this.k + " dispatched=" + this.l;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/oui/titlebar/OFloatingTitleBarActionHost$bindWhenReady$2", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f14750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBarActionHost f14751b;
        final /* synthetic */ c c;

        d(OFloatingTitleBar r1, OFloatingTitleBarActionHost r2, c r3) {
            this.f14750a = r1;
            this.f14751b = r2;
            this.c = r3;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver r0 = this.f14750a.getViewTreeObserver();
            if (r0.isAlive() == false) goto L6;
            r0.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnPreDrawListener.class, "com.obric.memorydata.plugin"));
        L6:
            if (OFloatingTitleBarActionHost.a(this.f14751b) == this.f14750a) goto L8;
            return true;
        L8:
            c r1 = OFloatingTitleBarActionHost.b(this.f14751b);
            if (r1 != null) goto L11;
            r1 = this.c;
        L11:
            OFloatingTitleBarActionHost.a(this.f14751b, null);
            OFloatingTitleBarActionHost.b(this.f14751b, null);
            OFloatingTitleBarActionHost.c(this.f14751b, r1);
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/oui/titlebar/OFloatingTitleBarActionHost$takeOverActionsOnNextPreDraw$2", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBarActionHost f14752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f14753b;

        e(OFloatingTitleBarActionHost r1, OFloatingTitleBar r2) {
            this.f14752a = r1;
            this.f14753b = r2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver r0 = this.f14752a.getViewTreeObserver();
            if (r0.isAlive() == false) goto L6;
            r0.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnPreDrawListener.class, "com.obric.memorydata.plugin"));
        L6:
            if (OFloatingTitleBarActionHost.c(this.f14752a) == this.f14753b) goto L8;
        L17:
            OFloatingTitleBarActionHost.a(this.f14752a, "takeOverActionsOnNextPreDraw skip preDraw target=" + System.identityHashCode(this.f14753b) + " host=" + OFloatingTitleBarActionHost.e(this.f14752a));
            return true;
        L8:
            if (OFloatingTitleBarActionHost.d(this.f14752a) != this.f14753b) goto L17;
            OFloatingTitleBarActionHost.b(this.f14752a, null);
            OFloatingTitleBarActionHost.c(this.f14752a, this.f14753b);
            c r1 = OFloatingTitleBarActionHost.f(this.f14752a);
            if (r1 == null) goto L16;
            OFloatingTitleBar r2 = this.f14753b;
            OFloatingTitleBarActionHost r4 = this.f14752a;
            if (r1.a() != r2) goto L16;
            OFloatingTitleBarActionHost.a(r4, r1);
        L16:
            return true;
        }
    }

    static {
        f14746a = new a(null);
    }

    public OFloatingTitleBarActionHost(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OFloatingTitleBarActionHost(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OFloatingTitleBarActionHost(Context r9, AttributeSet r10, int r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r12, r11);
        this.f14747b = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        OFloatingTitleBar r13 = new OFloatingTitleBar(r3, null, 0, 6, null);
        r13.setClipChildren(false);
        r13.setClipToPadding(false);
        r13.setImportantForAccessibility(4);
        r13.setKeepActionInteractiveWhenHidden$OUI_standardRelease(true);
        r13.setActionChangeInterruptCallback$OUI_standardRelease((Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBarActionHost$actionTitleBar$1$1(this), Function0.class, "com.obric.memorydata.plugin"));
        r13.setFloatingTransitionOwnerActive$OUI_standardRelease(false);
        OFloatingTitleBar.a(r13, true, false, 2, null);
        r13.setNonActionContentVisible$OUI_standardRelease(false);
        r13.setTitleBarContainerClickable$OUI_standardRelease(false);
        this.p = r13;
        setClipChildren(false);
        setClipToPadding(false);
        setWillNotDraw(false);
        setVisibility(8);
        addView((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ OFloatingTitleBarActionHost(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    public static final /* synthetic */ OFloatingTitleBar a(OFloatingTitleBarActionHost r0) {
        return r0.e;
    }

    private final String a(com.obric.oui.titlebar.a r3) {
        StringBuilder r2 = new StringBuilder().append("w=").append(r3.a().a()).append(" h=").append(r3.a().b()).append(" y=").append(r3.a().d()).append(" contentTopInset=").append(r3.b().e()).append(" contentY=").append(r3.a().d() + r3.b().e()).append(" start=").append(r3.c().a().size()).append(" center=").append(r3.c().b().size()).append(" sub=").append(r3.c().c().size()).append(" end=").append(r3.c().d().size()).append(" hasAnimation=");
        if (r3.e() == null) goto L5;
        boolean r4 = true;
    L7:
        return r2.append(r4).toString();
    L5:
        r4 = false;
        goto L7
    }

    private static final Function0<Unit> a(final Ref.IntRef r9, final int r10, final OFloatingTitleBarActionHost r11, final Ref.BooleanRef r12, Function0<Unit> r13) {
        final Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        r9.element++;
        final Ref.BooleanRef r3 = new Ref.BooleanRef();
        return (Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBarActionHost$applyState$await$1(r3, r10, r11, r9, r12, r8), Function0.class, "com.obric.memorydata.plugin");
    }

    private final void a(View r5) {
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L5;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 == null) goto L11;
        int r0 = 0;
        r6.setClipChildren(false);
        r6.setClipToPadding(false);
        int r1 = r6.getChildCount();
    L9:
        if (r0 >= r1) goto L13;
        int r2 = r0 + 1;
        View r3 = r6.getChildAt(r0);
        Intrinsics.checkNotNullExpressionValue(r3, "group.getChildAt(i)");
        a(r3);
        r0 = r2;
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r6 = null;
        goto L6
    }

    private final void a(View r10, boolean r11, Function0<Unit> r12) {
        final Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        ViewParent r1 = getParent();
        Integer r4 = null;
        if (ZeusTransformUtils.instanceOf(r1, View.class) == false) goto L5;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
    L6:
        if (r2 != null) goto L12;
        OFloatingTitleBarActionHost r9 = (OFloatingTitleBarActionHost) ZeusTransformUtils.preCheckCast(this, OFloatingTitleBarActionHost.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L48;
        r13.invoke();
        return;
    L48:
        return;
    L12:
        ViewGroup.LayoutParams r3 = getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L15;
        final ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L16:
        if (r5 != null) goto L22;
        OFloatingTitleBarActionHost r14 = (OFloatingTitleBarActionHost) ZeusTransformUtils.preCheckCast(this, OFloatingTitleBarActionHost.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L49;
        r13.invoke();
        return;
    L49:
        return;
    L22:
        int[] r6 = new int[2];
        int[] r0 = new int[2];
        r10.getLocationOnScreen(r6);
        r2.getLocationOnScreen(r0);
        boolean r7 = false;
        int r8 = r6[0] - r0[0];
        final int r15 = r6[1] - r0[1];
        Integer r16 = Integer.valueOf(r10.getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L25;
        boolean r17 = true;
    L26:
        if (r17 == true) goto L29;
        r16 = null;
    L29:
        if (r16 != null) goto L31;
        int r18 = r5.width;
    L32:
        Integer r19 = Integer.valueOf(r10.getHeight());
        if (((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L35;
        r7 = true;
    L35:
        if (r7 == false) goto L37;
        r4 = r19;
    L37:
        if (r4 != null) goto L39;
        int r110 = r5.height;
    L40:
        if (r11 == true) goto L46;
        animate().cancel();
        r5.width = r18;
        r5.height = r110;
        r5.leftMargin = r8;
        r5.topMargin = r15;
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        if (r13 == null) goto L50;
        r13.invoke();
        return;
    L50:
        return;
    L46:
        setTranslationY((r5.topMargin + getTranslationY()) - r5.topMargin);
        r5.width = r18;
        r5.height = r110;
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        animate().translationY(r15 - r5.topMargin).setDuration(500).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(this.f14747b, TimeInterpolator.class, "com.obric.memorydata.plugin")).withEndAction(new $$Lambda$OFloatingTitleBarActionHost$2dn4oImtMaBxE7h6UKB4M8K0PnA(r5, r15, this, r13)).start();
        return;
    L39:
        r110 = r4.intValue();
        goto L40
    L31:
        r18 = r16.intValue();
        goto L32
    L25:
        r17 = false;
        goto L26
    L15:
        r5 = null;
        goto L16
    L5:
        r2 = null;
        goto L6
    }

    private static final void a(ViewGroup.MarginLayoutParams r2, int r3, OFloatingTitleBarActionHost r4, Function0 r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "$params");
        Intrinsics.checkNotNullParameter(r4, "this$0");
        r2.topMargin = r3;
        r4.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r4.setTranslationY(0.0f);
        if (r6 == null) goto L7;
        r6.invoke();
        return;
    }

    private final void a(c r8) {
        OFloatingTitleBar r0 = r8.a();
        a("beginPrepareBind " + r8.m() + " target=" + r0.h() + " host=" + n());
        if (r8.c() == false) goto L5;
        setVisibility(4);
        a(Intrinsics.stringPlus("beginPrepareBind deferTakeOver setInvisible host=", n()));
    L5:
        boolean r3 = true;
        if (e(r0) == false) goto L17;
        StringBuilder r1 = new StringBuilder().append("beginPrepareBind preHideTarget before target=").append(r0.h()).append(" previous=");
        OFloatingTitleBar r5 = this.d;
        if (r5 != null) goto L10;
        String r6 = null;
    L11:
        a(r1.append(r6).append(" host=").append(n()).toString());
        OFloatingTitleBar r2 = this.d;
        if (r2 == null) goto L15;
        OFloatingTitleBar.a(r2, true, false, 2, null);
    L15:
        OFloatingTitleBar.a(r0, false, false, 2, null);
        this.d = r0;
        a(Intrinsics.stringPlus("beginPrepareBind preHideTarget after target=", r0.h()));
        goto L17
    L10:
        r6 = r5.h();
    L17:
        if (r0.isLaidOut() == true) goto L19;
    L25:
        StringBuilder r4 = new StringBuilder().append("beginPrepareBind waitReady laidOut=").append(r0.isLaidOut()).append(" layoutRequested=").append(r0.isLayoutRequested()).append(" hasParent=");
        if (getParent() != null) goto L29;
        r3 = false;
    L29:
        a(r4.append(r3).toString());
        f(r8);
        return;
    L19:
        if (r0.isLayoutRequested() == true) goto L25;
        if (getParent() == null) goto L25;
        b(r8);
    }

    private static final void a(OFloatingTitleBarActionHost r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.p.e();
    }

    public static final /* synthetic */ void a(OFloatingTitleBarActionHost r0, OFloatingTitleBar r1) {
        r0.e = r1;
    }

    private static final void a(OFloatingTitleBarActionHost r1, OFloatingTitleBar r2, c r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$titleBar");
        Intrinsics.checkNotNullParameter(r3, "$bind");
        if (r1.e == r2) goto L5;
        return;
    L5:
        c r4 = r1.f;
        if (r4 == null) goto L9;
        r3 = r4;
    L9:
        r1.e = null;
        r1.f = null;
        r1.a(r3);
    }

    public static final /* synthetic */ void a(OFloatingTitleBarActionHost r0, c r1) {
        r0.g(r1);
    }

    public static /* synthetic */ void a(OFloatingTitleBarActionHost r7, com.obric.oui.titlebar.a r8, boolean r9, boolean r10, Float r11, Function0 r12, int r13, Object r14) {
        Function0<Unit> r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        if ((r13 & 2) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r13 & 4) == 0) goto L9;
        boolean r4 = true;
    L11:
        if ((r13 & 8) == 0) goto L13;
        Float r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L17;
        Function0<Unit> r6 = null;
    L18:
        r7.a(r8, r3, r4, r5, r6);
        return;
    L17:
        r6 = r15;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public static final /* synthetic */ void a(OFloatingTitleBarActionHost r0, String r1) {
        r0.a(r1);
    }

    private static final void a(OFloatingTitleBarActionHost r2, Function0 r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r4, "$insetDone");
        r2.p.animate().setUpdateListener(null);
        r4.invoke();
    }

    private final void a(String r1) {
        if (com.obric.oui.titlebar.floating.b.b() == false) goto L6;
        Log.d("lzr", r1);
        return;
    }

    public static final /* synthetic */ c b(OFloatingTitleBarActionHost r0) {
        return r0.f;
    }

    private final void b(OFloatingTitleBar r4) {
        OFloatingTitleBar r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4 == null) goto L9;
        if (r0 == r4) goto L9;
        a("completePendingTakeOverActions skip mismatch request=" + System.identityHashCode(r4) + " pending=" + System.identityHashCode(r0));
        return;
    L9:
        this.g = null;
        a("completePendingTakeOverActions target=" + r0.h() + " host=" + n());
        c(r0);
        c r5 = this.i;
        if (r5 != null) goto L13;
        return;
    L13:
        if (r5.a() == r0) goto L15;
        return;
    L15:
        if (r5.g() == false) goto L19;
        g(r5);
        return;
    }

    private final void b(final c r2) {
        postOnAnimation(new $$Lambda$OFloatingTitleBarActionHost$ipNSQKAMWe4gwSWyOfSHgPpnsQ(this, r2));
    }

    public static final /* synthetic */ void b(OFloatingTitleBarActionHost r0, OFloatingTitleBar r1) {
        r0.h = r1;
    }

    public static final /* synthetic */ void b(OFloatingTitleBarActionHost r0, c r1) {
        r0.f = r1;
    }

    public static final /* synthetic */ OFloatingTitleBar c(OFloatingTitleBarActionHost r0) {
        return r0.h;
    }

    private final void c(final OFloatingTitleBar r3) {
        this.h = r3;
        ViewTreeObserver r0 = getViewTreeObserver();
        if (r0.isAlive() == true) goto L6;
        postOnAnimation(new $$Lambda$OFloatingTitleBarActionHost$rm9WPydblLs3_NBCpbyZAn__2A0(this, r3));
        return;
    L6:
        r0.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(new e(this, r3), ViewTreeObserver.OnPreDrawListener.class, "com.obric.memorydata.plugin"));
    }

    private final void c(c r3) {
        if (h(r3) == true) goto L5;
        return;
    L5:
        r3.a(r3.a().b());
        r3.a(true);
        StringBuilder r0 = new StringBuilder().append("prepareReady ").append(r3.m()).append(" state=");
        com.obric.oui.titlebar.a r1 = r3.d();
        if (r1 != null) goto L8;
        String r2 = null;
    L9:
        a(r0.append(r2).append(" host=").append(n()).toString());
        if (r3.f() == false) goto L12;
    L15:
        e(r3);
        return;
    L12:
        if (r3.g() == true) goto L15;
        if (d(r3) == true) goto L15;
        return;
    L8:
        r2 = a(r1);
        goto L9
    }

    public static final /* synthetic */ void c(OFloatingTitleBarActionHost r0, OFloatingTitleBar r1) {
        r0.d(r1);
    }

    public static final /* synthetic */ void c(OFloatingTitleBarActionHost r0, c r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ OFloatingTitleBar d(OFloatingTitleBarActionHost r0) {
        return r0.c;
    }

    private final void d(OFloatingTitleBar r5) {
        a("takeOverActions before target=" + r5.h() + " host=" + n());
        m();
        OFloatingTitleBar.a(r5, false, false, 2, null);
        setVisibility(0);
        a("takeOverActions after target=" + r5.h() + " host=" + n());
    }

    private static final void d(OFloatingTitleBarActionHost r2, OFloatingTitleBar r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$titleBar");
        if (r2.h == r3) goto L5;
    L14:
        r2.a("takeOverActionsOnNextPreDraw skip post target=" + System.identityHashCode(r3) + " host=" + r2.n());
        return;
    L5:
        if (r2.c != r3) goto L14;
        r2.h = null;
        r2.d(r3);
        c r0 = r2.i;
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.a() != r3) goto L16;
        r2.g(r0);
        return;
    }

    private static final void d(OFloatingTitleBarActionHost r3, c r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "$bind");
        if (r3.h(r4) == true) goto L6;
        r3.a("schedulePrepareOnFrame skip inactive " + r4.m() + " host=" + r3.n());
        return;
    L6:
        OFloatingTitleBar r0 = r4.a();
        if (r0.isLaidOut() == true) goto L9;
    L15:
        StringBuilder r1 = new StringBuilder().append("schedulePrepareOnFrame waitReadyAgain laidOut=").append(r0.isLaidOut()).append(" layoutRequested=").append(r0.isLayoutRequested()).append(" hasParent=");
        if (r3.getParent() == null) goto L18;
        boolean r2 = true;
    L19:
        r3.a(r1.append(r2).toString());
        r3.f(r4);
        return;
    L18:
        r2 = false;
        goto L19
    L9:
        if (r0.isLayoutRequested() == true) goto L15;
        if (r3.getParent() == null) goto L15;
        r3.c(r4);
    }

    private final boolean d(c r2) {
        if (h() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.c != r2.a()) goto L7;
        return true;
    }

    public static final /* synthetic */ String e(OFloatingTitleBarActionHost r0) {
        return r0.n();
    }

    private final void e(final c r14) {
        if (h(r14) == true) goto L5;
    L35:
        String r15 = "startPendingHostTransition skip active=" + h(r14) + ' ' + r14.m();
    L10:
        a(r15);
        return;
    L5:
        if (r14.h() == true) goto L35;
        if (r14.e() == true) goto L12;
        r14.b(true);
        r15 = Intrinsics.stringPlus("startPendingHostTransition pendingPrepare ", r14.m());
        goto L10
    L12:
        OFloatingTitleBar r0 = r14.a();
        if (r14.b() == true) goto L15;
    L17:
        boolean r3 = false;
    L18:
        com.obric.oui.titlebar.a r4 = r14.d();
        if (r4 != null) goto L21;
        r4 = r0.b();
    L21:
        com.obric.oui.titlebar.a r5 = r4;
        this.c = r0;
        r14.d(true);
        int r6 = this.n + 1;
        this.n = r6;
        r14.a(r6);
        if (r14.c() == false) goto L24;
        this.g = r0;
    L24:
        a("startPendingHostTransition start animate=" + r3 + " state=" + a(r5) + ' ' + r14.m() + " host=" + n());
        a(this, r5, r3, false, null, (Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBarActionHost$startPendingHostTransition$1(r14, this), Function0.class, "com.obric.memorydata.plugin"), 12, null);
        a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"), r3, (Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBarActionHost$startPendingHostTransition$2(r14, this), Function0.class, "com.obric.memorydata.plugin"));
        if (r14.c() == true) goto L27;
        d(r0);
    L31:
        if (this.d != r0) goto L33;
        this.d = null;
    L33:
        g(r14);
        return;
    L27:
        if (r14.g() == false) goto L31;
        b(r0);
        goto L31
    L15:
        if (h() == false) goto L17;
        r3 = true;
        goto L18
    }

    private static final void e(OFloatingTitleBarActionHost r3, OFloatingTitleBar r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        r3.k = false;
        if (r3.j == r4) goto L6;
        return;
    L6:
        if (r3.f(r4) == true) goto L13;
        r3.j = null;
        if (r3.c == null) goto L10;
        return;
    L10:
        if (r3.i != null) goto L24;
        r4.setFloatingTransitionOwnerActive$OUI_standardRelease(false);
        OFloatingTitleBar.a(r4, true, false, 2, null);
        return;
    L24:
        return;
    L13:
        c r1 = r3.i;
        if (r1 == null) goto L21;
        if (r1 != null) goto L17;
        OFloatingTitleBar r2 = null;
    L18:
        if (r2 == r4) goto L21;
        r3.j = null;
        r4.setFloatingTransitionOwnerActive$OUI_standardRelease(false);
        return;
    L17:
        r2 = r1.a();
    L21:
        r3.j = null;
        r3.k();
    }

    private final boolean e(OFloatingTitleBar r2) {
        if (getVisibility() != 0) goto L10;
        OFloatingTitleBar r1 = this.c;
        if (r1 == null) goto L10;
        if (r1 == r2) goto L10;
        if (r2.g() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static final /* synthetic */ c f(OFloatingTitleBarActionHost r0) {
        return r0.i;
    }

    private final void f(final c r4) {
        final OFloatingTitleBar r0 = r4.a();
        if (this.e != r0) goto L6;
        this.f = r4;
        return;
    L6:
        this.e = r0;
        this.f = r4;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1.isAlive() == true) goto L10;
        post(new $$Lambda$OFloatingTitleBarActionHost$Lw96cYeoCaLr8umrp2rel9o1WpM(this, r0, r4));
        return;
    L10:
        r1.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(new d(r0, this, r4), ViewTreeObserver.OnPreDrawListener.class, "com.obric.memorydata.plugin"));
    }

    private final boolean f(OFloatingTitleBar r2) {
        if (this.c != r2) goto L5;
    L19:
        return true;
    L5:
        if (this.d == r2) goto L19;
        if (this.e == r2) goto L19;
        c r0 = this.i;
        if (r0 != null) goto L11;
        OFloatingTitleBar r1 = null;
    L12:
        if (r1 == r2) goto L19;
        if (this.g == r2) goto L19;
        if (this.h == r2) goto L19;
        return false;
    L11:
        r1 = r0.a();
        goto L12
    }

    public static final /* synthetic */ int g(OFloatingTitleBarActionHost r0) {
        return r0.m;
    }

    private final void g(c r4) {
        if (r4.l() == false) goto L5;
    L29:
        a("dispatchHostTransitionEndIfReady wait " + r4.m() + " host=" + n());
        return;
    L5:
        if (r4.i() != this.n) goto L29;
        if (this.c != r4.a()) goto L29;
        if (r4.g() == false) goto L29;
        if (r4.h() == false) goto L29;
        if (r4.j() == false) goto L29;
        if (r4.k() == false) goto L29;
        if (this.g == r4.a()) goto L29;
        if (this.h == r4.a()) goto L29;
        r4.g(true);
        if (this.i != r4) goto L24;
        this.i = null;
    L24:
        a("dispatchHostTransitionEnd " + r4.m() + " host=" + n());
        b r3 = this.o;
        if (r3 == null) goto L31;
        r3.a(r4.a());
        return;
    }

    private final boolean g() {
        return !h();
    }

    public static final /* synthetic */ void h(OFloatingTitleBarActionHost r0) {
        r0.i();
    }

    private final boolean h() {
        if (getVisibility() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.c == null) goto L7;
        return true;
    }

    private final boolean h(c r1) {
        if (this.i != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private final void i() {
        OFloatingTitleBar r0 = this.c;
        if (r0 != null) goto L10;
        c r1 = this.i;
        if (r1 != null) goto L7;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        r0 = this.e;
        goto L10
    L7:
        r0 = r1.a();
    L10:
        if (r0 == null) goto L14;
        r0.l();
        return;
    }

    private final void j() {
        this.g = null;
        this.h = null;
        this.c = null;
    }

    private final void k() {
        a(Intrinsics.stringPlus("clearBindState before host=", n()));
        l();
        this.e = null;
        this.f = null;
        this.i = null;
        this.g = null;
        this.h = null;
        this.j = null;
        this.k = false;
        this.l = false;
        animate().cancel();
        OFloatingTitleBar r2 = this.d;
        if (r2 == null) goto L6;
        OFloatingTitleBar.a(r2, true, false, 2, null);
    L6:
        this.d = null;
        OFloatingTitleBar r3 = this.c;
        if (r3 == null) goto L10;
        OFloatingTitleBar.a(r3, true, false, 2, null);
    L10:
        this.c = null;
        OFloatingTitleBar.a(this.p, false, false, 2, null);
        setVisibility(8);
        this.n++;
        a(Intrinsics.stringPlus("clearBindState after host=", n()));
    }

    private final void l() {
        OFloatingTitleBar[] r0 = new OFloatingTitleBar[6];
        r0[0] = this.d;
        r0[1] = this.c;
        r0[2] = this.e;
        c r1 = this.i;
        if (r1 != null) goto L5;
        OFloatingTitleBar r2 = null;
    L6:
        r0[3] = r2;
        r0[4] = this.g;
        r0[5] = this.h;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.filterNotNull((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r0), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        OFloatingTitleBar r4 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r3.next(), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        r4.setFloatingTransitionOwnerActive$OUI_standardRelease(false);
        r4.b(this);
        goto L8
    L10:
        return;
    L5:
        r2 = r1.a();
        goto L6
    }

    public static /* synthetic */ void lambda$2dn4oImtMaBxE7h6UKB4M8K0PnA(ViewGroup.MarginLayoutParams r0, int r1, OFloatingTitleBarActionHost r2, Function0 r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$Lw96cYeoCaLr8umrp2rel9o1WpM(OFloatingTitleBarActionHost r0, OFloatingTitleBar r1, c r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$bhIUQyJTbAnw7ckEpKoSOeGu0mk(OFloatingTitleBarActionHost r0, ValueAnimator r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ipNSQKAMW-e4gwSWyOfSHgPpnsQ, reason: not valid java name */
    public static /* synthetic */ void m1387lambda$ipNSQKAMWe4gwSWyOfSHgPpnsQ(OFloatingTitleBarActionHost r0, c r1) {
        d(r0, r1);
    }

    public static /* synthetic */ void lambda$rBG3kyLSn1NL5Sj67VZ0XMC6Wvo(OFloatingTitleBarActionHost r0, Function0 r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$rm9WPydblLs3_NBCpbyZAn__2A0(OFloatingTitleBarActionHost r0, OFloatingTitleBar r1) {
        d(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$zJx5MigFL0q-Y-OQ8aCn2opD_HE, reason: not valid java name */
    public static /* synthetic */ void m1388lambda$zJx5MigFL0qYOQ8aCn2opD_HE(OFloatingTitleBarActionHost r0, OFloatingTitleBar r1) {
        e(r0, r1);
    }

    private final void m() {
        a("applyFloatingTransitionActionVisibility hide=" + this.l + " actionTitleBar=" + this.p.h() + " host=" + n());
        OFloatingTitleBar.a(this.p, !this.l, false, 2, null);
    }

    private final String n() {
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = r0.append("host=").append(System.identityHashCode(this)).append(" vis=").append(getVisibility()).append(" shown=").append(isShown()).append(" attached=").append(isAttachedToWindow()).append(" size=").append(getWidth()).append('x').append(getHeight()).append(" alpha=").append(getAlpha()).append(" hidden=").append(this.l).append(" bound=");
        OFloatingTitleBar r2 = this.c;
        Integer r3 = null;
        if (r2 != null) goto L5;
        Integer r4 = null;
    L6:
        StringBuilder r5 = r1.append(r4).append(" preHidden=");
        OFloatingTitleBar r6 = this.d;
        if (r6 != null) goto L9;
        Integer r7 = null;
    L10:
        StringBuilder r8 = r5.append(r7).append(" waiting=");
        OFloatingTitleBar r9 = this.e;
        if (r9 != null) goto L13;
        Integer r10 = null;
    L14:
        r8.append(r10).append(" pending=");
        c r11 = this.i;
        if (r11 != null) goto L17;
    L16:
        Integer r12 = null;
    L21:
        StringBuilder r13 = r0.append(r12).append(" pendingTakeOver=");
        OFloatingTitleBar r14 = this.g;
        if (r14 != null) goto L24;
        Integer r15 = null;
    L25:
        StringBuilder r16 = r13.append(r15).append(" pendingPreDraw=");
        OFloatingTitleBar r17 = this.h;
        if (r17 == null) goto L29;
        r3 = Integer.valueOf(System.identityHashCode(r17));
    L29:
        r16.append(r3).append(" action=").append(this.p.h());
        return r0.toString();
    L24:
        r15 = Integer.valueOf(System.identityHashCode(r14));
        goto L25
    L17:
        OFloatingTitleBar r18 = r11.a();
        if (r18 == null) goto L16;
        r12 = Integer.valueOf(System.identityHashCode(r18));
        goto L21
    L13:
        r10 = Integer.valueOf(System.identityHashCode(r9));
        goto L14
    L9:
        r7 = Integer.valueOf(System.identityHashCode(r6));
        goto L10
    L5:
        r4 = Integer.valueOf(System.identityHashCode(r2));
        goto L6
    }

    public final void a() {
        this.p.b(4);
    }

    public final void a(final OFloatingTitleBar r6) {
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder().append("unbind request titleBar=");
        OFloatingTitleBar r1 = null;
        if (r6 != null) goto L8;
        String r2 = null;
    L9:
        a(r0.append(r2).append(" host=").append(n()).toString());
        if (r6 != null) goto L12;
        OFloatingTitleBar r7 = this.c;
        if (r7 != null) goto L36;
        c r8 = this.i;
        if (r8 == null) goto L37;
        r1 = r8.a();
    L37:
        if (r1 == null) goto L40;
        r1.l();
    L40:
        k();
        return;
    L36:
        r1 = r7;
        goto L37
    L12:
        if (f(r6) == true) goto L15;
        a("unbind nonOwner restore titleBar=" + r6.h() + " host=" + n());
        OFloatingTitleBar.a(r6, true, false, 2, null);
        return;
    L15:
        c r3 = this.i;
        if (r3 != null) goto L18;
        OFloatingTitleBar r4 = null;
    L19:
        if (r4 == null) goto L25;
        c r5 = this.i;
        if (r5 == null) goto L24;
        r1 = r5.a();
    L24:
        if (r1 == r6) goto L25;
    L26:
        this.j = r6;
        if (this.k == true) goto L42;
        this.k = true;
        postOnAnimation(new $$Lambda$OFloatingTitleBarActionHost$zJx5MigFL0qYOQ8aCn2opD_HE(this, r6));
        return;
    L42:
        return;
    L25:
        r6.l();
        goto L26
    L18:
        r4 = r3.a();
        goto L19
    L8:
        r2 = r6.h();
        goto L9
    }

    public final void a(OFloatingTitleBar r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "titleBar");
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L5;
        return;
    L5:
        a("bind start animate=" + r14 + " target=" + r13.h() + " host=" + n());
        OFloatingTitleBar r0 = this.c;
        boolean r2 = false;
        c r3 = null;
        if (r0 == r13) goto L26;
        if (r0 == null) goto L10;
        r0.setFloatingTransitionOwnerActive$OUI_standardRelease(false);
        r0.b(this);
    L10:
        c r1 = this.i;
        if (r1 != null) goto L13;
        OFloatingTitleBar r4 = null;
    L14:
        if (r4 == r13) goto L22;
        c r5 = this.i;
        if (r5 == null) goto L22;
        OFloatingTitleBar r6 = r5.a();
        if (r6 == null) goto L22;
        r6.setFloatingTransitionOwnerActive$OUI_standardRelease(false);
        r6.b(this);
    L22:
        OFloatingTitleBar r7 = this.c;
        if (r7 == null) goto L26;
        r7.l();
        goto L26
    L13:
        r4 = r1.a();
    L26:
        r13.a(this);
        r13.setFloatingTransitionOwnerActive$OUI_standardRelease(true);
        if (this.j == null) goto L30;
        this.j = null;
        this.k = false;
    L30:
        if (h() == true) goto L35;
        if (this.c == r13) goto L35;
        j();
    L35:
        if (h() == true) goto L37;
    L43:
        c r8 = this.i;
        if (r8 != null) goto L47;
    L51:
        c r9 = new c(r13, r14, g());
        if (r3 == null) goto L54;
        r9.b(r3.f());
        r9.c(r3.g());
    L54:
        this.i = r9;
        a("bind pending " + r9.m() + " host=" + n());
        a(r9);
        return;
    L47:
        if (r8.a() != r13) goto L49;
        r2 = true;
    L49:
        if (r2 == false) goto L51;
        r3 = r8;
        goto L51
    L37:
        if (this.c != r13) goto L43;
        this.i = null;
        if (this.e != r13) goto L41;
        this.e = null;
        this.f = null;
    L41:
        com.obric.oui.titlebar.a r10 = r13.c();
        a("bind sameTakenOver state=" + a(r10) + " host=" + n());
        a(this, r10, r14, false, null, null, 28, null);
        d(r13);
    }

    public final void a(com.obric.oui.titlebar.a r17, boolean r18, boolean r19, Float r20, Function0<Unit> r21) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r21, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "state");
        int r6 = this.m + 1;
        this.m = r6;
        a("applyState start generation=" + r6 + " animate=" + r18 + " animateInset=" + r19 + " state=" + a(r17) + " host=" + n());
        this.p.b().b().e();
        if (r20 != null) goto L5;
        float r8 = f();
    L6:
        int r10 = r17.b().e();
        Ref.IntRef r11 = new Ref.IntRef();
        r11.element = 1;
        Ref.BooleanRef r12 = new Ref.BooleanRef();
        this.p.animate().cancel();
        m();
        this.p.setNonActionContentVisible$OUI_standardRelease(false);
        this.p.a(r10);
        if (r18 == false) goto L12;
        if (r19 == false) goto L12;
        float r9 = r8 - r10;
        if (Math.abs(r9) <= 0.5f) goto L12;
        final Function0<Unit> r3 = a(r11, r6, this, r12, r4);
        this.p.setTranslationY(r9);
        this.p.animate().translationY(0.0f).setDuration(500).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(this.f14747b, TimeInterpolator.class, "com.obric.memorydata.plugin")).setUpdateListener(new $$Lambda$OFloatingTitleBarActionHost$bhIUQyJTbAnw7ckEpKoSOeGu0mk(this)).withEndAction(new $$Lambda$OFloatingTitleBarActionHost$rBG3kyLSn1NL5Sj67VZ0XMC6Wvo(this, r3)).start();
    L13:
        final Function0<Unit> r5 = a(r11, r6, this, r12, r4);
        this.p.a(r17, r18, (Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBarActionHost$applyState$3(r5), Function0.class, "com.obric.memorydata.plugin"));
        m();
        this.p.setNonActionContentVisible$OUI_standardRelease(false);
        if (r6 == this.m) goto L17;
        a("applyState stale generation=" + r6 + " current=" + this.m + " host=" + n());
        return;
    L17:
        r11.element--;
        if (r11.element == 0) goto L20;
        return;
    L20:
        if (r12.element == true) goto L27;
        r12.element = true;
        a("applyState end generation=" + r6 + " host=" + n());
        if (r4 == null) goto L28;
        r4.invoke();
        return;
    L28:
        return;
    L27:
        return;
    L12:
        this.p.animate().setUpdateListener(null);
        this.p.setTranslationY(0.0f);
        goto L13
    L5:
        r8 = r20.floatValue();
        goto L6
    }

    public final void a(boolean r5) {
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L5;
        return;
    L5:
        a("hideFloatingTransitionActions request hide=" + r5 + " before=" + n());
        if (this.l != r5) goto L10;
        StringBuilder r6 = new StringBuilder().append("hideFloatingTransitionActions skip sameState hide=").append(r5).append(' ');
    L8:
        a(r6.append(n()).toString());
        return;
    L10:
        this.l = r5;
        m();
        if (r5 == false) goto L13;
    L18:
        r6 = new StringBuilder().append("hideFloatingTransitionActions done hide=").append(r5).append(" after=");
        goto L8
    L13:
        if (getVisibility() != 0) goto L18;
        OFloatingTitleBar r0 = this.c;
        if (r0 == null) goto L18;
        OFloatingTitleBar.a(r0, false, false, 2, null);
        goto L18
    }

    public final void b() {
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L5;
        return;
    L5:
        c r0 = this.i;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.b(true);
        a("onTransitionStart " + r0.m() + " host=" + n());
        e(r0);
    }

    public final void c() {
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L5;
        return;
    L5:
        c r0 = this.i;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.c(true);
        if (r0.f() == true) goto L11;
        r0.b(true);
    L11:
        a("onTransitionEnd " + r0.m() + " host=" + n());
        e(r0);
        if (r0.h() == false) goto L15;
        b(r0.a());
    L15:
        if (r0.h() == false) goto L18;
        g(r0);
        return;
    }

    public final void d() {
        this.m++;
        animate().cancel();
        this.p.animate().cancel();
        this.p.animate().setUpdateListener(null);
        this.p.setFloatingTransitionDrawUpdateListener$OUI_standardRelease(null);
        this.p.i();
    }

    public final com.obric.oui.titlebar.a e() {
        return this.p.d();
    }

    public final float f() {
        return this.p.b().b().e() + this.p.getTranslationY();
    }

    public final OFloatingTitleBar getActionTitleBar() {
        return this.p;
    }

    public final OFloatingTitleBar getBoundTitleBar() {
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L7;
        return null;
    L7:
        return this.c;
    }

    public final void setFloatingTransitionDrawUpdateListener$OUI_standardRelease(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        this.p.setFloatingTransitionDrawUpdateListener$OUI_standardRelease(r4);
    }

    public final void setFloatingTransitionEndListener(b r3) {
        this.o = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }
}
