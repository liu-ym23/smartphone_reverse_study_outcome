package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.obric.oui.material.l;
import com.obric.oui.popover.FakeAnchorView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b8\b\u0016\u0018\u0000 ½\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002½\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J(\u0010\u0085\u0001\u001a\u000f\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020\"2\u0007\u0010\u0088\u0001\u001a\u00020\"H\u0002J(\u0010\u0089\u0001\u001a\u000f\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020\"2\u0007\u0010\u0088\u0001\u001a\u00020\"H\u0002J\t\u0010\u008a\u0001\u001a\u00020\u0016H\u0002J\u0007\u0010\u008b\u0001\u001a\u00020\u0016J\u0007\u0010\u008c\u0001\u001a\u00020\u0016J\u0012\u0010\u008d\u0001\u001a\u00020\u00162\u0007\u0010\u008e\u0001\u001a\u00020\u0012H\u0002J\u000b\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0012H\u0002J\t\u0010\u0090\u0001\u001a\u00020\u0016H\u0016J\u0007\u0010\u0091\u0001\u001a\u00020\u0010J\u000f\u0010\u0092\u0001\u001a\u00020\"H\u0000¢\u0006\u0003\b\u0093\u0001J\t\u0010\u0094\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u0095\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u0096\u0001\u001a\u00020\u0018H\u0016J\u0019\u0010\u0097\u0001\u001a\u00020\u00162\u0007\u0010\u0098\u0001\u001a\u00020\"2\u0007\u0010\u0099\u0001\u001a\u00020\"J\t\u0010\u009a\u0001\u001a\u00020\u0016H\u0014J\u0007\u0010\u009b\u0001\u001a\u00020\u0016J\t\u0010\u009c\u0001\u001a\u00020\u0016H\u0014J\t\u0010\u009d\u0001\u001a\u00020\u0016H\u0016J\t\u0010\u009e\u0001\u001a\u00020\u0016H\u0016J\t\u0010\u009f\u0001\u001a\u00020\u0016H\u0002J\u001e\u0010 \u0001\u001a\u0004\u0018\u00010\u00122\u000b\b\u0002\u0010¡\u0001\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0003\b¢\u0001J\t\u0010£\u0001\u001a\u00020\"H\u0016J\t\u0010¤\u0001\u001a\u00020\u0016H\u0002J\u0012\u0010¥\u0001\u001a\u00020\u00162\u0007\u0010¦\u0001\u001a\u00020\u0010H\u0002J\u0010\u0010§\u0001\u001a\u00020\u00162\u0007\u0010¨\u0001\u001a\u00020\u0018J\u0018\u0010©\u0001\u001a\u00020\u00162\u0007\u0010ª\u0001\u001a\u00020\"H\u0000¢\u0006\u0003\b«\u0001J\u0010\u0010¬\u0001\u001a\u00020\u00162\u0007\u0010\u00ad\u0001\u001a\u00020\"J\u0012\u0010®\u0001\u001a\u00020\u00162\t\u0010¯\u0001\u001a\u0004\u0018\u00010\tJ\u0012\u0010°\u0001\u001a\u00020\u00162\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010±\u0001\u001a\u00020\u00162\t\u0010¯\u0001\u001a\u0004\u0018\u00010\rJ\u0018\u0010²\u0001\u001a\u00020\u00162\u000f\u0010¯\u0001\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015J\u0018\u0010³\u0001\u001a\u00020\u00162\u000f\u0010¯\u0001\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015J\u0010\u0010´\u0001\u001a\u00020\u00162\u0007\u0010µ\u0001\u001a\u00020\u0018J\u0010\u0010¶\u0001\u001a\u00020\u00162\u0007\u0010·\u0001\u001a\u00020\"J\u0010\u0010¸\u0001\u001a\u00020\u00162\u0007\u0010¹\u0001\u001a\u00020\"J\t\u0010º\u0001\u001a\u00020\u0016H\u0003J8\u0010»\u0001\u001a\u00020\u00162\u0007\u0010¼\u0001\u001a\u00020\u00102\u000b\b\u0002\u0010¡\u0001\u001a\u0004\u0018\u00010\u00122\u0007\u0010ª\u0001\u001a\u00020\"2\u0007\u0010\u0087\u0001\u001a\u00020\"2\u0007\u0010\u0088\u0001\u001a\u00020\"R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u001e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020(X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u0014\u00100\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0019R\u001c\u00105\u001a\u0004\u0018\u000106X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010=R\u0014\u0010@\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010=R\u001a\u0010B\u001a\u00020CX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\u00020J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u0019R\u0014\u0010O\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010=R\u0014\u0010Q\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0019R\u001a\u0010S\u001a\u00020\"X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010=\"\u0004\bU\u0010VR\u0014\u0010W\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010=R&\u0010Y\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\\0[0ZX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u001a\u0010_\u001a\u00020\"X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010=\"\u0004\ba\u0010VR\u001a\u0010b\u001a\u00020\"X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010=\"\u0004\bd\u0010VR\u001a\u0010e\u001a\u00020\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u0019\"\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0019\"\u0004\bk\u0010hR\u0014\u0010l\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u0019R\u0014\u0010n\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010*R\u0016\u0010p\u001a\u00020\"8WX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010=R\u0014\u0010r\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010*R\u0014\u0010t\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\u0019R\u0014\u0010v\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010=R\u001a\u0010x\u001a\u00020\u0012X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u001a\u0010}\u001a\u00020\"X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010=\"\u0004\b\u007f\u0010VR\u001d\u0010\u0080\u0001\u001a\u00020\"X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010=\"\u0005\b\u0082\u0001\u0010VR\u000f\u0010\u0083\u0001\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¾\u0001"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverModal;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/popover/v2/OPopoverBase;", "builder", "Lcom/obric/oui/popover/v2/OPopover$Builder;", "(Lcom/obric/oui/popover/v2/OPopover$Builder;)V", "autoDismissRunnable", "Ljava/lang/Runnable;", "bubbleDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "bubbleShowListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "bubbleStartDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "currentAnchorRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "currentHostParent", "Landroid/view/ViewGroup;", "detachedCleanupRunnable", "dismissListener", "Lkotlin/Function0;", "", "isPopoverBubbleLayoutInitialized", "", "()Z", "<set-?>", "isShowing", "mAutoDismissDelayMillis", "", "mEnableBackPressDismiss", "mOutsideTouchable", "mShadowEnabled", "mShadowStyle", "", "mSpacingForShadow", "mView", "mainHandler", "Landroid/os/Handler;", "popoverAnchorCenterX", "", "getPopoverAnchorCenterX", "()F", "setPopoverAnchorCenterX", "(F)V", "popoverAnchorCenterY", "getPopoverAnchorCenterY", "setPopoverAnchorCenterY", "popoverAnimationDurationMillis", "getPopoverAnimationDurationMillis", "()J", "popoverAnimationIsWindowMode", "getPopoverAnimationIsWindowMode", "popoverAnimator", "Landroid/animation/AnimatorSet;", "getPopoverAnimator", "()Landroid/animation/AnimatorSet;", "setPopoverAnimator", "(Landroid/animation/AnimatorSet;)V", "popoverBgColor", "getPopoverBgColor", "()I", "popoverBorderColor", "getPopoverBorderColor", "popoverBorderWidth", "getPopoverBorderWidth", "popoverBubbleLayout", "Lcom/obric/oui/popover/v2/OPopoverLayout;", "getPopoverBubbleLayout", "()Lcom/obric/oui/popover/v2/OPopoverLayout;", "setPopoverBubbleLayout", "(Lcom/obric/oui/popover/v2/OPopoverLayout;)V", "popoverContentView", "popoverContext", "Landroid/content/Context;", "getPopoverContext", "()Landroid/content/Context;", "popoverCoverPreviousWhenStacked", "getPopoverCoverPreviousWhenStacked", "popoverDisplayOrientation", "getPopoverDisplayOrientation", "popoverEnableBubbleMaterial", "getPopoverEnableBubbleMaterial", "popoverGravity", "getPopoverGravity", "setPopoverGravity", "(I)V", "popoverHeight", "getPopoverHeight", "popoverMaterials", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/MaterialConfig;", "getPopoverMaterials", "()Lkotlin/jvm/functions/Function1;", "popoverPopupOriginX", "getPopoverPopupOriginX", "setPopoverPopupOriginX", "popoverPopupOriginY", "getPopoverPopupOriginY", "setPopoverPopupOriginY", "popoverPushedToStack", "getPopoverPushedToStack", "setPopoverPushedToStack", "(Z)V", "popoverRemovedFromStack", "getPopoverRemovedFromStack", "setPopoverRemovedFromStack", "popoverShowWithAnimation", "getPopoverShowWithAnimation", "popoverStackAlphaPrevious", "getPopoverStackAlphaPrevious", "popoverStackCoverColor", "getPopoverStackCoverColor", "popoverStackScalePrevious", "getPopoverStackScalePrevious", "popoverTransparentBg", "getPopoverTransparentBg", "popoverWidth", "getPopoverWidth", "popoverWindowFrame", "getPopoverWindowFrame", "()Landroid/view/ViewGroup;", "setPopoverWindowFrame", "(Landroid/view/ViewGroup;)V", "popoverXOffset", "getPopoverXOffset", "setPopoverXOffset", "popoverYOffset", "getPopoverYOffset", "setPopoverYOffset", "removeOnDismiss", "showListener", "addShadowFrame", "Lkotlin/Pair;", "x", "y", "addShadowFrameIfNeeded", "cleanupFakeAnchorIfNeeded", "dismiss", "dismissDirectly", "ensureAttachedToParent", "targetParent", "findDecorViewParent", "finishPopoverDismissInternal", "getContentView", "getDisplayRotationDegrees", "getDisplayRotationDegrees$OUI_standardRelease", "initContentView", "interceptBackPressedIfNeeded", "isPopoverShowing", "measurePopup", "widthMeasureSpec", "heightMeasureSpec", "onAttachedToWindow", "onDestroy", "onDetachedFromWindow", "onPopoverShownInternal", "onPopoverStartDismissInternal", "performDetachedCleanup", "resolveHostParent", "parent", "resolveHostParent$OUI_standardRelease", "resolvePopoverAnimationGravityInternal", "restoreWindowCallback", "setBubbleLayout", "view", "setEnableAutoDismiss", "enabled", "setGravity", "gravity", "setGravity$OUI_standardRelease", "setMaxContentHeight", "maxHeight", "setOnBubbleDismissListener", "listener", "setOnBubbleShowListener", "setOnBubbleStartDismissListener", "setOnDismissListener", "setOnShowListener", "setRemoveOnDismiss", "remove", "setXOffset", "xOffset", "setYOffset", "yOffset", "setupOutsideTouchHandler", "showAtLocation", "anchor", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class g extends FrameLayout implements c<g> {
    private static final Map<Activity, a.C0768a> R = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14369a = null;
    private final Handler A;
    private final int B;
    private final int C;
    private final int D;
    private final int E;
    private final boolean F;
    private final int G;
    private final int H;
    private final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final Function1<Boolean, com.obric.oui.material.c[]> f14370J;
    private final boolean K;
    private final int L;
    private final float M;
    private final float N;
    private boolean O;
    private final Runnable P;
    private final Runnable Q;
    public OPopoverLayout c;
    public ViewGroup d;
    private final boolean e;
    private final long f;
    private final boolean g;
    private int h;
    private int i;
    private int j;
    private final long k;
    private com.obric.oui.popover.v2.a.e l;
    private com.obric.oui.popover.v2.a.c m;
    private com.obric.oui.popover.v2.a.d n;
    private Function0<Unit> o;
    private Function0<Unit> p;
    private AnimatorSet q;
    private boolean r;
    private float s;
    private float t;
    private int u;
    private int v;
    private ViewGroup w;
    private WeakReference<View> x;
    private boolean y;
    private boolean z;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverModal$Companion;", "", "()V", "backPressManagerByActivity", "", "Landroid/app/Activity;", "Lcom/obric/oui/popover/v2/OPopoverModal$Companion$BackPressManager;", "cleanupBackPressManagerLocked", "", "activity", "installBackPressCallbackIfNeeded", "registerShowingPopover", "popover", "Lcom/obric/oui/popover/v2/OPopoverModal;", "topShowingPopoverLocked", "unregisterShowingPopover", "BackPressManager", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.popover.v2.g$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverModal$Companion$BackPressManager;", "", "originalCallback", "Landroid/view/Window$Callback;", "proxyCallback", "showingPopovers", "", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/popover/v2/OPopoverModal;", "(Landroid/view/Window$Callback;Landroid/view/Window$Callback;Ljava/util/List;)V", "getOriginalCallback", "()Landroid/view/Window$Callback;", "getProxyCallback", "getShowingPopovers", "()Ljava/util/List;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        private static final class C0768a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Window.Callback f14371a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Window.Callback f14372b;
            private final List<WeakReference<g>> c;

            public final Window.Callback a() {
                return this.f14371a;
            }

            public final Window.Callback b() {
                return this.f14372b;
            }

            public final List<WeakReference<g>> c() {
                return this.c;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final synchronized void a(Activity r6) {
            monitor-enter(this);
            Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
            C0768a r0 = (C0768a) ZeusTransformUtils.preCheckCast(g.g().get(r7), C0768a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
            if (r0 != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            CollectionsKt.removeAll(r0.c(), (Function1) ZeusTransformUtils.preCheckCast(OPopoverModal$Companion$cleanupBackPressManagerLocked$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
            if (r0.c().isEmpty() == true) goto L10;
        L13:
            monitor-exit(this);
            return;
        L10:
            if (ZeusTransformUtils.getWindow(r7, "com.obric.memorydata.plugin").getCallback() != r0.b()) goto L12;
            ZeusTransformUtils.getWindow(r7, "com.obric.memorydata.plugin").setCallback(r0.a());     // Catch: Throwable -> L15
        L12:
            g.g().remove(r7);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        }

        private final synchronized void a(Activity r4, final g r5) {
            monitor-enter(this);
            Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            C0768a r0 = (C0768a) ZeusTransformUtils.preCheckCast(g.g().get(r6), C0768a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r0 != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            CollectionsKt.removeAll(r0.c(), (Function1) ZeusTransformUtils.preCheckCast(new OPopoverModal$Companion$unregisterShowingPopover$1(r5), Function1.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
            a(r6);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public static final /* synthetic */ void a(a r2, Activity r3, g r4) {
            r2.a((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    static {
        f14369a = new a(null);
        R = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Map g() {
        return R;
    }

    private final void h() {
        com.obric.oui.window.a r0 = com.obric.oui.window.a.f14878a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(r1), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        a.a(f14369a, r2, this);
    }

    private final void k() {
        WeakReference<View> r0 = this.x;
        if (r0 != null) goto L5;
        View r1 = null;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, FakeAnchorView.class) == false) goto L15;
        ViewParent r3 = ((FakeAnchorView) ZeusTransformUtils.preCheckCast(r1, FakeAnchorView.class, "com.obric.memorydata.plugin")).getParent();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L11;
        ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin");
    L12:
        if (r2 == null) goto L15;
        r2.removeView(r1);
        goto L15
    L11:
        r2 = null;
    L15:
        this.x = null;
        this.w = null;
        return;
    L5:
        r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.memorydata.plugin");
        goto L7
    }

    private final void setBubbleLayout(View r3) {
        setPopoverBubbleLayout(a(r3, 2));
        l.a((View) ZeusTransformUtils.preCheckCast(getPopoverBubbleLayout(), View.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.popover.v2.c
    public float a(float r3, int r4, float r5) {
        return c.b.a((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"), r3, r4, r5);
    }

    @Override // com.obric.oui.popover.v2.c
    public AnimatorSet a(boolean r10, int r11, boolean r12, Animator r13, Function0<Unit> r14, Function0<Unit> r15) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r15, Function0.class, "com.obric.memorydata.plugin");
        return c.b.a((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"), r10, r11, r12, r13, r7, r8);
    }

    @Override // com.obric.oui.popover.v2.c
    public OPopoverLayout a(View r3, int r4) {
        return c.b.a((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    @Override // com.obric.oui.popover.v2.c
    public void a(int r3, View r4) {
        c.b.a((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    @Override // com.obric.oui.popover.v2.c
    public void a(int r3, View r4, int r5, int r6) {
        c.b.a((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
    }

    @Override // com.obric.oui.popover.v2.c
    public void a(View r3, int r4, int r5) {
        c.b.a((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"), r3, r4, r5);
    }

    @Override // com.obric.oui.popover.v2.c
    public void a(ViewGroup r3, Function0<Unit> r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        c.b.a((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"), r3, r5);
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean a() {
        if (this.c == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.popover.v2.c
    public void b(View r3) {
        c.b.b((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"), r3);
    }

    public final boolean b() {
        return this.O;
    }

    public void c() {
        c.b.n((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.popover.v2.c
    public void d() {
        com.obric.oui.popover.v2.a.d r0 = this.n;
        if (r0 == null) goto L6;
        r0.a();
    L6:
        Function0<Unit> r1 = this.p;
        if (r1 == null) goto L11;
        r1.invoke();
        return;
    }

    @Override // com.obric.oui.popover.v2.c
    public int e() {
        return getPopoverGravity() & 112;
    }

    @Override // com.obric.oui.popover.v2.c
    public void f() {
        com.obric.oui.popover.v2.a.e r0 = this.l;
        if (r0 == null) goto L7;
        r0.a();
        return;
    }

    public final View getContentView() {
        return getContentViewInternal();
    }

    @Override // com.obric.oui.popover.v2.c
    public View getContentViewInternal() {
        return c.b.e((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"));
    }

    public final int getDisplayRotationDegrees$OUI_standardRelease() {
        return getDisplayRotationDegreesInternal();
    }

    public int getDisplayRotationDegreesInternal() {
        return c.b.d((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.popover.v2.c
    public float getPopoverAnchorCenterX() {
        return this.s;
    }

    @Override // com.obric.oui.popover.v2.c
    public float getPopoverAnchorCenterY() {
        return this.t;
    }

    @Override // com.obric.oui.popover.v2.c
    public long getPopoverAnimationDurationMillis() {
        return this.f;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean getPopoverAnimationIsWindowMode() {
        return this.g;
    }

    @Override // com.obric.oui.popover.v2.c
    public AnimatorSet getPopoverAnimator() {
        return this.q;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverBgColor() {
        return this.C;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverBorderColor() {
        return this.E;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverBorderWidth() {
        return this.D;
    }

    @Override // com.obric.oui.popover.v2.c
    public OPopoverLayout getPopoverBubbleLayout() {
        OPopoverLayout r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("popoverBubbleLayout");
        return null;
    }

    @Override // com.obric.oui.popover.v2.c
    public Context getPopoverContext() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        return r2;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean getPopoverCoverPreviousWhenStacked() {
        return this.K;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverDisplayOrientation() {
        return this.B;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean getPopoverEnableBubbleMaterial() {
        return this.I;
    }

    @Override // com.obric.oui.popover.v2.c
    public Animator getPopoverEnterAnimator() {
        return c.b.b((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.popover.v2.c
    public Animator getPopoverExitAnimator() {
        return c.b.c((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverGravity() {
        return this.h;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverHeight() {
        return this.H;
    }

    @Override // com.obric.oui.popover.v2.c
    public Function1<Boolean, com.obric.oui.material.c[]> getPopoverMaterials() {
        return this.f14370J;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverPopupOriginX() {
        return this.u;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverPopupOriginY() {
        return this.v;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean getPopoverPushedToStack() {
        return this.y;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean getPopoverRemovedFromStack() {
        return this.z;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean getPopoverShowWithAnimation() {
        return this.e;
    }

    @Override // com.obric.oui.popover.v2.c
    public float getPopoverStackAlphaPrevious() {
        return this.M;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverStackCoverColor() {
        return this.L;
    }

    @Override // com.obric.oui.popover.v2.c
    public float getPopoverStackScalePrevious() {
        return this.N;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean getPopoverTransparentBg() {
        return this.F;
    }

    @Override // com.obric.oui.popover.v2.c
    public int getPopoverWidth() {
        return this.G;
    }

    @Override // com.obric.oui.popover.v2.c
    public ViewGroup getPopoverWindowFrame() {
        ViewGroup r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("popoverWindowFrame");
        return null;
    }

    public int getPopoverXOffset() {
        return this.i;
    }

    public int getPopoverYOffset() {
        return this.j;
    }

    @Override // com.obric.oui.popover.v2.c
    public void i() {
        ViewGroup r0 = null;
        setPopoverAnimator(null);
        this.O = false;
        h();
        setVisibility(8);
        getPopoverWindowFrame().setVisibility(4);
        c.b.a((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"), null, 1, null);
        k();
        c();
        if (this.r == false) goto L10;
        ViewParent r1 = getParent();
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L7;
        r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.memorydata.plugin");
    L7:
        if (r0 == null) goto L10;
        r0.removeView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    L10:
        com.obric.oui.popover.v2.a.c r2 = this.m;
        if (r2 == null) goto L14;
        r2.a();
    L14:
        Function0<Unit> r4 = this.o;
        if (r4 == null) goto L19;
        r4.invoke();
        return;
    }

    @Override // com.obric.oui.popover.v2.c
    public boolean j() {
        return this.O;
    }

    @Override // com.obric.oui.popover.v2.c
    public void l() {
        c.b.f((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.popover.v2.c
    public void n() {
        c.b.h((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.A.removeCallbacks(this.Q);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        h();
        super.onDetachedFromWindow();
        removeCallbacks(this.P);
        this.A.removeCallbacks(this.Q);
        this.A.post(this.Q);
    }

    public final void setEnableAutoDismiss(boolean r5) {
        removeCallbacks(this.P);
        if (r5 == false) goto L8;
        long r0 = this.k;
        if (r0 <= 0) goto L9;
        postDelayed(this.P, r0);
        return;
    L9:
        return;
    }

    public final void setGravity$OUI_standardRelease(int r1) {
        setGravityInternal(r1);
    }

    public void setGravityInternal(int r3) {
        c.b.a((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void setMaxContentHeight(int r3) {
        c.b.a((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"), r3, null, 2, null);
    }

    public final void setOnBubbleDismissListener(com.obric.oui.popover.v2.a.c r3) {
        this.m = (com.obric.oui.popover.v2.a.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.popover.v2.a.c.class, "com.obric.memorydata.plugin");
    }

    public final void setOnBubbleShowListener(com.obric.oui.popover.v2.a.d r3) {
        this.n = (com.obric.oui.popover.v2.a.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.popover.v2.a.d.class, "com.obric.memorydata.plugin");
    }

    public final void setOnBubbleStartDismissListener(com.obric.oui.popover.v2.a.e r3) {
        this.l = (com.obric.oui.popover.v2.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.popover.v2.a.e.class, "com.obric.memorydata.plugin");
    }

    public final void setOnDismissListener(Function0<Unit> r3) {
        this.o = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    public final void setOnShowListener(Function0<Unit> r3) {
        this.p = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    public void setPopoverAnchorCenterX(float r1) {
        this.s = r1;
    }

    public void setPopoverAnchorCenterY(float r1) {
        this.t = r1;
    }

    @Override // com.obric.oui.popover.v2.c
    public void setPopoverAnimator(AnimatorSet r1) {
        this.q = r1;
    }

    public void setPopoverBubbleLayout(OPopoverLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // com.obric.oui.popover.v2.c
    public void setPopoverGravity(int r1) {
        this.h = r1;
    }

    public void setPopoverPopupOriginX(int r1) {
        this.u = r1;
    }

    public void setPopoverPopupOriginY(int r1) {
        this.v = r1;
    }

    @Override // com.obric.oui.popover.v2.c
    public void setPopoverPushedToStack(boolean r1) {
        this.y = r1;
    }

    @Override // com.obric.oui.popover.v2.c
    public void setPopoverRemovedFromStack(boolean r1) {
        this.z = r1;
    }

    public void setPopoverWindowFrame(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    @Override // com.obric.oui.popover.v2.c
    public void setPopoverXOffset(int r1) {
        this.i = r1;
    }

    @Override // com.obric.oui.popover.v2.c
    public void setPopoverYOffset(int r1) {
        this.j = r1;
    }

    public final void setRemoveOnDismiss(boolean r1) {
        this.r = r1;
    }

    public final void setXOffset(int r1) {
        setXOffsetInternal(r1);
    }

    public void setXOffsetInternal(int r3) {
        c.b.b((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void setYOffset(int r1) {
        setYOffsetInternal(r1);
    }

    public void setYOffsetInternal(int r3) {
        c.b.c((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"), r3);
    }
}
