package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.obric.oui.common.style.k;
import com.obric.oui.common.util.h;
import com.obric.oui.popover.menu.OPopoverMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u0000 ¢\u0001*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0006¢\u0001£\u0001¤\u0001J\b\u0010j\u001a\u00020kH\u0016J\b\u0010l\u001a\u00020kH\u0016J\b\u0010m\u001a\u00020kH\u0016J\u001a\u0010n\u001a\u00020$2\u0006\u0010o\u001a\u00020p2\b\b\u0002\u0010q\u001a\u00020\u001cH\u0016J\b\u0010r\u001a\u00020kH&J\b\u0010s\u001a\u00020pH\u0016J\b\u0010t\u001a\u00020\u001cH\u0016J\b\u0010u\u001a\u00020\u0004H&J \u0010v\u001a\u00020k2\u0006\u0010w\u001a\u00020p2\u0006\u0010x\u001a\u00020\u001c2\u0006\u0010y\u001a\u00020\u001cH\u0016J\u0018\u0010z\u001a\u00020k2\u0006\u0010x\u001a\u00020\u001c2\u0006\u0010y\u001a\u00020\u001cH\u0016J\b\u0010{\u001a\u00020kH\u0016J\b\u0010|\u001a\u00020kH&J\b\u0010}\u001a\u00020kH&J\b\u0010~\u001a\u00020kH\u0017J\b\u0010\u007f\u001a\u00020kH\u0017J\u0014\u0010\u0080\u0001\u001a\u00020p2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010pH\u0016J\u0014\u0010\u0082\u0001\u001a\u00020k2\t\b\u0002\u0010\u0081\u0001\u001a\u00020pH\u0016J\t\u0010\u0083\u0001\u001a\u00020\u001cH\u0016J$\u0010\u0084\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00020\u001c2\u0007\u0010\u0087\u0001\u001a\u00020\u0007H\u0016J\u0015\u0010\u0088\u0001\u001a\u00030\u0089\u00012\t\b\u0001\u0010\u008a\u0001\u001a\u00020\u001cH\u0016J\u0014\u0010\u008b\u0001\u001a\u00020\u00072\t\b\u0001\u0010\u008a\u0001\u001a\u00020\u001cH\u0016J\u0012\u0010\u008c\u0001\u001a\u00020k2\u0007\u0010\u008d\u0001\u001a\u00020\u001cH\u0016J\u001d\u0010\u008e\u0001\u001a\u00020k2\u0007\u0010\u008f\u0001\u001a\u00020\u001c2\t\b\u0002\u0010\u0090\u0001\u001a\u00020pH\u0016J+\u0010\u0091\u0001\u001a\u00020k2\u0007\u0010\u008f\u0001\u001a\u00020\u001c2\u0007\u0010\u0090\u0001\u001a\u00020p2\u0006\u0010x\u001a\u00020\u001c2\u0006\u0010y\u001a\u00020\u001cH\u0016J\u0012\u0010\u0092\u0001\u001a\u00020k2\u0007\u0010\u0093\u0001\u001a\u00020\u001cH\u0016J\u0012\u0010\u0094\u0001\u001a\u00020k2\u0007\u0010\u0095\u0001\u001a\u00020\u001cH\u0016J\t\u0010\u0096\u0001\u001a\u00020\u0004H\u0016J(\u0010\u0097\u0001\u001a\u00020k2\t\b\u0002\u0010\u0081\u0001\u001a\u00020_2\u0012\b\u0002\u0010\u0098\u0001\u001a\u000b\u0012\u0004\u0012\u00020k\u0018\u00010\u0099\u0001H\u0016J\t\u0010\u009a\u0001\u001a\u00020kH\u0016J]\u0010\u009b\u0001\u001a\u00020\u00162\u0007\u0010\u009c\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u001c2\t\b\u0002\u0010\u009d\u0001\u001a\u00020\u00042\u000b\b\u0002\u0010\u009e\u0001\u001a\u0004\u0018\u0001042\u0012\b\u0002\u0010\u009f\u0001\u001a\u000b\u0012\u0004\u0012\u00020k\u0018\u00010\u0099\u00012\u0012\b\u0002\u0010 \u0001\u001a\u000b\u0012\u0004\u0012\u00020k\u0018\u00010\u0099\u0001H\u0016J\t\u0010¡\u0001\u001a\u00020kH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0005R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u0016X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0012\u0010!\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0018\u0010#\u001a\u00020$X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0012\u0010)\u001a\u00020*X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0012\u0010-\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0005R\u0012\u0010/\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u001eR\u0012\u00101\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0005R\u0016\u00103\u001a\u0004\u0018\u0001048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0016\u00107\u001a\u0004\u0018\u0001048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00106R\u0018\u00109\u001a\u00020\u001cX¦\u000e¢\u0006\f\u001a\u0004\b:\u0010\u001e\"\u0004\b;\u0010<R\u0012\u0010=\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u001eR$\u0010?\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A0@X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0018\u0010E\u001a\u00020\u001cX¦\u000e¢\u0006\f\u001a\u0004\bF\u0010\u001e\"\u0004\bG\u0010<R\u0018\u0010H\u001a\u00020\u001cX¦\u000e¢\u0006\f\u001a\u0004\bI\u0010\u001e\"\u0004\bJ\u0010<R\u0018\u0010K\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\bL\u0010\u0005\"\u0004\bM\u0010NR\u0018\u0010O\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\bP\u0010\u0005\"\u0004\bQ\u0010NR\u0012\u0010R\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u0005R\u0012\u0010T\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\bU\u0010\tR\u0014\u0010V\u001a\u00020\u001c8gX¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u001eR\u0012\u0010X\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\bY\u0010\tR\u0012\u0010Z\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u0005R\u0012\u0010\\\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b]\u0010\u001eR\u0018\u0010^\u001a\u00020_X¦\u000e¢\u0006\f\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0018\u0010d\u001a\u00020\u001cX¦\u000e¢\u0006\f\u001a\u0004\be\u0010\u001e\"\u0004\bf\u0010<R\u0018\u0010g\u001a\u00020\u001cX¦\u000e¢\u0006\f\u001a\u0004\bh\u0010\u001e\"\u0004\bi\u0010<¨\u0006¥\u0001"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverBase;", ExifInterface.GPS_DIRECTION_TRUE, "", "isPopoverBubbleLayoutInitialized", "", "()Z", "popoverAnchorCenterX", "", "getPopoverAnchorCenterX", "()F", "setPopoverAnchorCenterX", "(F)V", "popoverAnchorCenterY", "getPopoverAnchorCenterY", "setPopoverAnchorCenterY", "popoverAnimationDurationMillis", "", "getPopoverAnimationDurationMillis", "()J", "popoverAnimationIsWindowMode", "getPopoverAnimationIsWindowMode", "popoverAnimator", "Landroid/animation/AnimatorSet;", "getPopoverAnimator", "()Landroid/animation/AnimatorSet;", "setPopoverAnimator", "(Landroid/animation/AnimatorSet;)V", "popoverBgColor", "", "getPopoverBgColor", "()I", "popoverBorderColor", "getPopoverBorderColor", "popoverBorderWidth", "getPopoverBorderWidth", "popoverBubbleLayout", "Lcom/obric/oui/popover/v2/OPopoverLayout;", "getPopoverBubbleLayout", "()Lcom/obric/oui/popover/v2/OPopoverLayout;", "setPopoverBubbleLayout", "(Lcom/obric/oui/popover/v2/OPopoverLayout;)V", "popoverContext", "Landroid/content/Context;", "getPopoverContext", "()Landroid/content/Context;", "popoverCoverPreviousWhenStacked", "getPopoverCoverPreviousWhenStacked", "popoverDisplayOrientation", "getPopoverDisplayOrientation", "popoverEnableBubbleMaterial", "getPopoverEnableBubbleMaterial", "popoverEnterAnimator", "Landroid/animation/Animator;", "getPopoverEnterAnimator", "()Landroid/animation/Animator;", "popoverExitAnimator", "getPopoverExitAnimator", "popoverGravity", "getPopoverGravity", "setPopoverGravity", "(I)V", "popoverHeight", "getPopoverHeight", "popoverMaterials", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/MaterialConfig;", "getPopoverMaterials", "()Lkotlin/jvm/functions/Function1;", "popoverPopupOriginX", "getPopoverPopupOriginX", "setPopoverPopupOriginX", "popoverPopupOriginY", "getPopoverPopupOriginY", "setPopoverPopupOriginY", "popoverPushedToStack", "getPopoverPushedToStack", "setPopoverPushedToStack", "(Z)V", "popoverRemovedFromStack", "getPopoverRemovedFromStack", "setPopoverRemovedFromStack", "popoverShowWithAnimation", "getPopoverShowWithAnimation", "popoverStackAlphaPrevious", "getPopoverStackAlphaPrevious", "popoverStackCoverColor", "getPopoverStackCoverColor", "popoverStackScalePrevious", "getPopoverStackScalePrevious", "popoverTransparentBg", "getPopoverTransparentBg", "popoverWidth", "getPopoverWidth", "popoverWindowFrame", "Landroid/view/ViewGroup;", "getPopoverWindowFrame", "()Landroid/view/ViewGroup;", "setPopoverWindowFrame", "(Landroid/view/ViewGroup;)V", "popoverXOffset", "getPopoverXOffset", "setPopoverXOffset", "popoverYOffset", "getPopoverYOffset", "setPopoverYOffset", "afterShowInStackIfNeeded", "", "beforeShowInStackIfNeeded", "cancelPopoverAnimatorInternal", "createPopoverBubbleLayout", "contentView", "Landroid/view/View;", "materialSourceType", "finishPopoverDismissInternal", "getContentViewInternal", "getDisplayRotationDegreesInternal", "isPopoverShowing", "measurePopoverContent", TypedValues.AttributesType.S_TARGET, "widthMeasureSpec", "heightMeasureSpec", "measurePopupInternal", "onDestroyInStackIfNeeded", "onPopoverShownInternal", "onPopoverStartDismissInternal", "playPopoverEnterAnimationInternal", "playPopoverExitAnimationInternal", "requirePopoverContentView", "view", "resetPopoverAnimatedViewState", "resolvePopoverAnimationGravityInternal", "resolvePopoverPivot", "anchorCenter", "popupOrigin", "fallback", "resolvePopoverShadowPadding", "Lcom/obric/oui/popover/v2/OPopoverBase$ShadowPadding;", "shadowStyleRes", "resolvePopoverShadowSpace", "setGravityInternal", "gravity", "setMaxContentHeightInternal", "maxHeight", "measureTarget", "setPopoverMaxContentHeight", "setXOffsetInternal", "xOffset", "setYOffsetInternal", "yOffset", "shouldAnimatePopoverVisibilityInternal", "showPopoverDirectlyInternal", "onShown", "Lkotlin/Function0;", "showPopoverWithoutAnimationInternal", "startPopoverVisibilityAnimationInternal", "isIn", "isWindowMode", "customAnimator", "onAnimationStart", "onAnimationEnd", "updatePopoverPivotInternal", "Companion", "ShadowPadding", "StackController", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface c<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14358b = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006H\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverBase$Companion;", "", "()V", "setMaxContentHeightIfPossible", "", "view", "Landroid/view/View;", "maxHeight", "", "wrapForDisplayOrientation", "context", "Landroid/content/Context;", "displayOrientation", "contentView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f14359a = null;

        static {
            f14359a = new a();
        }

        private a() {
        }

        private final View a(Context r4, int r5, View r6) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            boolean r1 = true;
            if (r5 != 1) goto L5;
            float r7 = 90.0f;
        L10:
            if (r7 == 0.0f) goto L13;
            r1 = false;
        L13:
            if (r1 == false) goto L15;
            return r6;
        L15:
            f r8 = new f(r3);
            r8.setOrientationAngle(r7);
            r8.addView(r6);
            return (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin");
        L5:
            if (r5 == 3) goto L7;
            r7 = 0.0f;
            goto L10
        L7:
            r7 = 270.0f;
            goto L10
        }

        public static final /* synthetic */ View a(a r2, Context r3, int r4, View r5) {
            return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5);
        }

        private final void a(View r3, int r4) {
            if (ZeusTransformUtils.instanceOf(r3, OPopoverMenuView.class) == false) goto L6;
            ((OPopoverMenuView) ZeusTransformUtils.preCheckCast(r3, OPopoverMenuView.class, "com.obric.memorydata.plugin")).setPopoverMaxHeight(r4);
        L6:
            if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L11;
            Iterator<View> r2 = ViewGroupKt.getChildren((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin")).iterator();
        L9:
            if (r2.hasNext() == false) goto L13;
            View r5 = (View) ZeusTransformUtils.preCheckCast(r2.next(), View.class, "com.obric.memorydata.plugin");
            f14359a.a(r5, r4);
            goto L9
        L13:
            return;
        }

        public static final /* synthetic */ void a(a r0, View r1, int r2) {
            r0.a(r1, r2);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        public static <T> float a(c<T> r2, float r3, int r4, float r5) {
            Intrinsics.checkNotNullParameter((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), "this");
            if (Float.isNaN(r3) == false) goto L6;
            return r5;
        L6:
            return r3 - r4;
        }

        public static <T> AnimatorSet a(c<T> r13, boolean r14, int r15, boolean r16, Animator r17, Function0<Unit> r18, Function0<Unit> r19) {
            c r0 = (c) ZeusTransformUtils.wrapperContextForParams(r13, c.class, "com.obric.memorydata.plugin");
            Function0<Unit> r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r18, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r19, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r0, "this");
            r0.l();
            return com.obric.oui.popover.v2.b.f14353a.a(r0.getPopoverWindowFrame(), r16, r15, r0.getPopoverWindowFrame().getPivotX(), r0.getPopoverWindowFrame().getPivotY(), r14, r17, r11, r12);
        }

        public static /* synthetic */ AnimatorSet a(c r4, boolean r5, int r6, boolean r7, Animator r8, Function0 r9, Function0 r10, int r11, Object r12) {
            c r13 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
            Function0<Unit> r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
            if (r12 != null) goto L25;
            if ((r11 & 2) == 0) goto L7;
            r6 = r13.getPopoverGravity();
        L7:
            int r16 = r6;
            if ((r11 & 4) == 0) goto L10;
            r7 = true;
        L10:
            boolean r0 = r7;
            if ((r11 & 8) == 0) goto L13;
            Animator r1 = null;
        L15:
            if ((r11 & 16) == 0) goto L17;
            Function0<Unit> r2 = null;
        L19:
            if ((r11 & 32) == 0) goto L21;
            Function0<Unit> r3 = null;
        L23:
            return r13.a(r5, r16, r0, r1, r2, r3);
        L21:
            r3 = r15;
            goto L23
        L17:
            r2 = r14;
            goto L19
        L13:
            r1 = r8;
            goto L15
        L25:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startPopoverVisibilityAnimationInternal");
        }

        public static <T> View a(c<T> r2, View r3) {
            Intrinsics.checkNotNullParameter((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), "this");
            if (r3 == null) goto L6;
            return r3;
        L6:
            throw new IllegalArgumentException("mView must be not null".toString());
        }

        public static <T> OPopoverLayout a(c<T> r5, View r6, int r7) {
            c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "this");
            Intrinsics.checkNotNullParameter(r6, "contentView");
            OPopoverLayout r0 = new OPopoverLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getPopoverContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8.getPopoverEnableBubbleMaterial(), r8.getPopoverMaterials(), r7);
            r0.setBackgroundColor(0);
            r0.setGravity(17);
            r0.addView(a.a(c.f14358b, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getPopoverContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8.getPopoverDisplayOrientation(), r6));
            r0.setCornerRadius(h.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getPopoverContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), OPopoverLayout.f14348a.a()));
            if (r8.getPopoverBgColor() == 0) goto L6;
            r0.setBgColor(r8.getPopoverBgColor());
        L6:
            if (r0.b() == true) goto L8;
            r0.setBorderColor(r8.getPopoverBorderColor());
            r0.setBorderWidth(r8.getPopoverBorderWidth());
        L8:
            r0.setTransparentBg(r8.getPopoverTransparentBg());
            return r0;
        }

        public static /* synthetic */ OPopoverLayout a(c r2, View r3, int r4, int r5, Object r6) {
            c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L8;
            r4 = 3;
        L8:
            return r7.a(r3, r4);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPopoverBubbleLayout");
        }

        public static <T> void a(c<T> r2, int r3) {
            c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            r4.setPopoverGravity(com.obric.oui.popover.v2.a.f14351a.a(r3));
        }

        public static <T> void a(c<T> r2, int r3, View r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "this");
            Intrinsics.checkNotNullParameter(r4, "measureTarget");
            if (r5.a() == false) goto L8;
            if (r3 <= 0) goto L9;
            r5.a(r3, r4, Integer.MIN_VALUE, Integer.MIN_VALUE);
            return;
        L9:
            return;
        }

        public static <T> void a(c<T> r4, int r5, View r6, int r7, int r8) {
            c r9 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "this");
            Intrinsics.checkNotNullParameter(r6, "measureTarget");
            if (r5 > 0) goto L5;
            return;
        L5:
            int r10 = RangesKt.coerceAtLeast(r5 - (r9.getPopoverBubbleLayout().getArrowHeight() * 2), 0);
            a.a(c.f14358b, (View) ZeusTransformUtils.preCheckCast(r9.getPopoverBubbleLayout(), View.class, "com.obric.memorydata.plugin"), r10);
            r9.getPopoverBubbleLayout().requestLayout();
            r9.a(r6, r7, r8);
        }

        public static /* synthetic */ void a(c r2, int r3, View r4, int r5, Object r6) {
            c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L7;
            r4 = r7.getContentViewInternal();
        L7:
            r7.a(r3, r4);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaxContentHeightInternal");
        }

        public static <T> void a(c<T> r2, View r3, int r4, int r5) {
            c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "this");
            Intrinsics.checkNotNullParameter(r3, TypedValues.AttributesType.S_TARGET);
            if (r6.getPopoverWidth() != 0) goto L5;
        L7:
            r3.measure(r4, r5);
            return;
        L5:
            if (r6.getPopoverHeight() == 0) goto L7;
            r3.measure(View.MeasureSpec.makeMeasureSpec(r6.getPopoverWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r6.getPopoverHeight(), 1073741824));
        }

        public static /* synthetic */ void a(c r2, View r3, int r4, Object r5) {
            c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L10;
            if ((r4 & 1) == 0) goto L7;
            r3 = (View) ZeusTransformUtils.preCheckCast(r6.getPopoverWindowFrame(), View.class, "com.obric.memorydata.plugin");
        L7:
            r6.b(r3);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetPopoverAnimatedViewState");
        }

        public static <T> void a(c<T> r2, ViewGroup r3, Function0<Unit> r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "this");
            Intrinsics.checkNotNullParameter(r3, "view");
            r5.b((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
            r3.setVisibility(0);
            if (r6 == null) goto L7;
            r6.invoke();
            return;
        }

        public static /* synthetic */ void a(c r2, ViewGroup r3, Function0 r4, int r5, Object r6) {
            c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L13;
            if ((r5 & 1) == 0) goto L8;
            r3 = r7.getPopoverWindowFrame();
        L8:
            if ((r5 & 2) == 0) goto L10;
            r8 = null;
        L10:
            r7.a(r3, r8);
            return;
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPopoverDirectlyInternal");
        }

        public static <T> boolean a(c<T> r2) {
            Intrinsics.checkNotNullParameter((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), "this");
            return true;
        }

        public static <T> Animator b(c<T> r2) {
            Intrinsics.checkNotNullParameter((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), "this");
            return null;
        }

        public static <T> void b(c<T> r2, int r3) {
            c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            r4.setPopoverXOffset(r3);
        }

        public static <T> void b(c<T> r2, View r3) {
            Intrinsics.checkNotNullParameter((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), "this");
            Intrinsics.checkNotNullParameter(r3, "view");
            r3.setAlpha(1.0f);
            r3.setScaleX(1.0f);
            r3.setScaleY(1.0f);
            r3.setTranslationY(0.0f);
        }

        public static <T> Animator c(c<T> r2) {
            Intrinsics.checkNotNullParameter((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), "this");
            return null;
        }

        public static <T> void c(c<T> r2, int r3) {
            c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            r4.setPopoverYOffset(r3);
        }

        public static <T> int d(c<T> r2) {
            c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this");
            int r4 = r3.getPopoverDisplayOrientation();
            if (r4 != 1) goto L5;
            return 90;
        L5:
            if (r4 == 3) goto L7;
            return 0;
        L7:
            return SubsamplingScaleImageView.ORIENTATION_270;
        }

        public static <T> C0767c d(c<T> r9, int r10) {
            c r11 = (c) ZeusTransformUtils.wrapperContextForParams(r9, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r11, "this");
            if (r10 == 0) goto L5;
            List<k> r12 = com.obric.oui.common.style.f.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getPopoverContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r10);
            Intrinsics.checkNotNullExpressionValue(r12, "extractShadowInfo(popoverContext, shadowStyleRes)");
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
            C0767c r14 = new C0767c(0, 0, 0, 0, 15, null);
            Iterator<T> r15 = r13.iterator();
        L8:
            if (r15.hasNext() == false) goto L10;
            k r0 = (k) ZeusTransformUtils.preCheckCast(r15.next(), k.class, "com.obric.memorydata.plugin");
            r14.a(Math.max(r14.a(), MathKt.roundToInt(r0.b() - r0.c())));
            r14.b(Math.max(r14.b(), MathKt.roundToInt(r0.b() - r0.d())));
            r14.c(Math.max(r14.c(), MathKt.roundToInt(r0.b() + r0.c())));
            r14.d(Math.max(r14.d(), MathKt.roundToInt(r0.b() + r0.d())));
            goto L8
        L10:
            return r14;
        L5:
            return new C0767c(0, 0, 0, 0, 15, null);
        }

        public static <T> float e(c<T> r3, int r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "this");
            float r0 = 0.0f;
            if (r4 != 0) goto L5;
            return 0.0f;
        L5:
            List<k> r6 = com.obric.oui.common.style.f.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getPopoverContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
            Intrinsics.checkNotNullExpressionValue(r6, "extractShadowInfo(popoverContext, shadowStyleRes)");
            Iterator<T> r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L7:
            if (r7.hasNext() == false) goto L9;
            r0 = r0 + ((k) ZeusTransformUtils.preCheckCast(r7.next(), k.class, "com.obric.memorydata.plugin")).b();
            goto L7
        L9:
            return r0;
        }

        public static <T> View e(c<T> r2) {
            c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this");
            return (View) ZeusTransformUtils.preCheckCast(r3.getPopoverBubbleLayout(), View.class, "com.obric.memorydata.plugin");
        }

        public static <T> void f(c<T> r5) {
            c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "this");
            r6.a(r6.getContentViewInternal(), 0, 0);
            r6.getPopoverWindowFrame().setPivotX(r6.a(r6.getPopoverAnchorCenterX(), r6.getPopoverPopupOriginX(), r6.getPopoverWindowFrame().getMeasuredWidth() / 2.0f));
            r6.getPopoverWindowFrame().setPivotY(r6.a(r6.getPopoverAnchorCenterY(), r6.getPopoverPopupOriginY(), r6.getPopoverWindowFrame().getMeasuredHeight() / 2.0f));
        }

        public static <T> boolean g(c<T> r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "this");
            if (r5.getPopoverShowWithAnimation() == true) goto L5;
        L7:
            return false;
        L5:
            if (r5.getPopoverAnimationDurationMillis() <= 0) goto L7;
            return true;
        }

        public static <T> void h(c<T> r2) {
            c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this");
            AnimatorSet r0 = r3.getPopoverAnimator();
            if (r0 == null) goto L6;
            r0.cancel();
        L6:
            r3.setPopoverAnimator(null);
        }

        public static <T> void i(c<T> r3) {
            final c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            a(r4, null, (Function0) ZeusTransformUtils.preCheckCast(new OPopoverBase$showPopoverWithoutAnimationInternal$1(r4), Function0.class, "com.obric.memorydata.plugin"), 1, null);
        }

        public static <T> void j(c<T> r9) {
            final c r10 = (c) ZeusTransformUtils.wrapperContextForParams(r9, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "this");
            r10.n();
            boolean r5 = r10.getPopoverAnimationIsWindowMode();
            r10.setPopoverAnimator(r10.a(true, r10.e(), r5, r10.getPopoverEnterAnimator(), (Function0) ZeusTransformUtils.preCheckCast(new OPopoverBase$playPopoverEnterAnimationInternal$1(r10), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OPopoverBase$playPopoverEnterAnimationInternal$2(r10), Function0.class, "com.obric.memorydata.plugin")));
        }

        public static <T> void k(c<T> r11) {
            final c r12 = (c) ZeusTransformUtils.wrapperContextForParams(r11, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "this");
            r12.n();
            r12.f();
            boolean r5 = r12.getPopoverAnimationIsWindowMode();
            r12.setPopoverAnimator(a(r12, false, r12.e(), r5, r12.getPopoverExitAnimator(), null, (Function0) ZeusTransformUtils.preCheckCast(new OPopoverBase$playPopoverExitAnimationInternal$1(r12), Function0.class, "com.obric.memorydata.plugin"), 16, null));
        }

        public static <T> void l(c<T> r6) {
            c<?> r1 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "this");
            d.f14362a.a(r1, r1.getPopoverCoverPreviousWhenStacked(), r1.getPopoverStackCoverColor(), r1.getPopoverStackAlphaPrevious(), r1.getPopoverStackScalePrevious());
        }

        public static <T> void m(c<T> r2) {
            c<?> r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this");
            if (r3.getPopoverPushedToStack() == false) goto L5;
            return;
        L5:
            r3.setPopoverPushedToStack(true);
            d.f14362a.a(r3);
        }

        public static <T> void n(c<T> r2) {
            c<?> r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this");
            if (r3.getPopoverRemovedFromStack() == false) goto L5;
            return;
        L5:
            r3.setPopoverRemovedFromStack(true);
            d.f14362a.b(r3);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.popover.v2.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverBase$ShadowPadding;", "", "left", "", "top", "right", "bottom", "(IIII)V", "getBottom", "()I", "setBottom", "(I)V", "getLeft", "setLeft", "getRight", "setRight", "getTop", "setTop", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0767c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f14360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14361b;
        private int c;
        private int d;

        public C0767c() {
            this(0, 0, 0, 0, 15, null);
        }

        public C0767c(int r1, int r2, int r3, int r4) {
            this.f14360a = r1;
            this.f14361b = r2;
            this.c = r3;
            this.d = r4;
        }

        public /* synthetic */ C0767c(int r2, int r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = 0;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = 0;
        L14:
            this(r2, r3, r4, r5);
        }

        public final int a() {
            return this.f14360a;
        }

        public final void a(int r1) {
            this.f14360a = r1;
        }

        public final int b() {
            return this.f14361b;
        }

        public final void b(int r1) {
            this.f14361b = r1;
        }

        public final int c() {
            return this.c;
        }

        public final void c(int r1) {
            this.c = r1;
        }

        public final int d() {
            return this.d;
        }

        public final void d(int r1) {
            this.d = r1;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0767c.class) == true) goto L8;
            return false;
        L8:
            C0767c r6 = (C0767c) ZeusTransformUtils.preCheckCast(r5, C0767c.class, "com.obric.memorydata.plugin");
            if (this.f14360a == r6.f14360a) goto L12;
            return false;
        L12:
            if (this.f14361b == r6.f14361b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f14360a) * 31) + Integer.hashCode(this.f14361b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        }

        public String toString() {
            return "ShadowPadding(left=" + this.f14360a + ", top=" + this.f14361b + ", right=" + this.c + ", bottom=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\bH\u0002J.\u0010\u0012\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00062\b\b\u0001\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\u0012\u0010\u0016\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0006J\u0012\u0010\u0017\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0006J\u001e\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverBase$StackController;", "", "()V", "popoverStack", "", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/popover/v2/OPopoverBase;", "beforeShow", "", "current", "coverPreviousWhenStacked", "", "stackCoverColor", "", "stackAlphaPrevious", "", "stackScalePrevious", "cleanupStackLocked", "coverPreviousPopoverIfAny", TypedValues.Custom.S_COLOR, "alpha", "scale", "onDismiss", "onShow", "topLocked", "exclude", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f14362a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final List<WeakReference<c<?>>> f14363b = null;

        static {
            f14362a = new d();
            f14363b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        }

        private d() {
        }

        static /* synthetic */ c a(d r1, c r2, int r3, Object r4) {
            c<?> r5 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            if ((r3 & 1) == 0) goto L6;
            r5 = null;
        L6:
            return r1.c(r5);
        }

        private final synchronized void a() {
            monitor-enter(this);
            CollectionsKt.removeAll(f14363b, (Function1) ZeusTransformUtils.preCheckCast(OPopoverBase$StackController$cleanupStackLocked$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private final synchronized void a(c<?> r2, int r3, float r4, float r5) {
            monitor-enter(this);
            c<?> r6 = c((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
            if (r6 != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            com.obric.oui.popover.v2.b.f14353a.a(r6, false, r4, r5);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        private final synchronized c<?> c(c<?> r5) {
            monitor-enter(this);
            c<?> r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            a();     // Catch: Throwable -> L19
            int r0 = f14363b.size() - 1;     // Catch: Throwable -> L19
            if (r0 < 0) goto L17;
        L5:
            int r1 = r0 - 1;     // Catch: Throwable -> L19
            c<?> r2 = (c) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(f14363b.get(r0), WeakReference.class, "com.obric.memorydata.plugin")).get(), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            if (r2 == null) goto L11;
            if (r6 == null) goto L14;
            if (r2 == r6) goto L11;
        L14:
            monitor-exit(this);
            return r2;
        L11:
            if (r1 < 0) goto L17;
            r0 = r1;
        L17:
            monitor-exit(this);
            return null;
        L19:
            th = move-exception;
            throw th;
        }

        public final synchronized void a(c<?> r5) {
            monitor-enter(this);
            final c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
            Intrinsics.checkNotNullParameter(r6, "current");     // Catch: Throwable -> L6
            a();     // Catch: Throwable -> L6
            List<WeakReference<c<?>>> r0 = f14363b;     // Catch: Throwable -> L6
            CollectionsKt.removeAll(r0, (Function1) ZeusTransformUtils.preCheckCast(new OPopoverBase$StackController$onShow$1(r6), Function1.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
            r0.add(new WeakReference(r6));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final synchronized void a(c<?> r5, boolean r6, int r7, float r8, float r9) {
            monitor-enter(this);
            c<?> r10 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            Intrinsics.checkNotNullParameter(r10, "current");     // Catch: Throwable -> L10
            OPopoverLayout.a(r10.getPopoverBubbleLayout(), false, 0, 2, null);     // Catch: Throwable -> L10
            if (r6 == true) goto L7;
            monitor-exit(this);
            return;
        L7:
            a(r10, r7, r8, r9);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public final synchronized void b(c<?> r4) {
            monitor-enter(this);
            final c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            Intrinsics.checkNotNullParameter(r5, "current");     // Catch: Throwable -> L9
            a();     // Catch: Throwable -> L9
            CollectionsKt.removeAll(f14363b, (Function1) ZeusTransformUtils.preCheckCast(new OPopoverBase$StackController$onDismiss$1(r5), Function1.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9
            c<?> r0 = a(this, null, 1, null);     // Catch: Throwable -> L9
            if (r0 == null) goto L7;
            com.obric.oui.popover.v2.b.f14353a.a(r0, true, 1.0f, 1.0f);     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    static {
        f14358b = a.f14359a;
    }

    float a(float r1, int r2, float r3);

    AnimatorSet a(boolean r1, int r2, boolean r3, Animator r4, Function0<Unit> r5, Function0<Unit> r6);

    OPopoverLayout a(View r1, int r2);

    void a(int r1, View r2);

    void a(int r1, View r2, int r3, int r4);

    void a(View r1, int r2, int r3);

    void a(ViewGroup r1, Function0<Unit> r2);

    boolean a();

    void b(View r1);

    void d();

    int e();

    void f();

    View getContentViewInternal();

    float getPopoverAnchorCenterX();

    float getPopoverAnchorCenterY();

    long getPopoverAnimationDurationMillis();

    boolean getPopoverAnimationIsWindowMode();

    AnimatorSet getPopoverAnimator();

    int getPopoverBgColor();

    int getPopoverBorderColor();

    int getPopoverBorderWidth();

    OPopoverLayout getPopoverBubbleLayout();

    Context getPopoverContext();

    boolean getPopoverCoverPreviousWhenStacked();

    int getPopoverDisplayOrientation();

    boolean getPopoverEnableBubbleMaterial();

    Animator getPopoverEnterAnimator();

    Animator getPopoverExitAnimator();

    int getPopoverGravity();

    int getPopoverHeight();

    Function1<Boolean, com.obric.oui.material.c[]> getPopoverMaterials();

    int getPopoverPopupOriginX();

    int getPopoverPopupOriginY();

    boolean getPopoverPushedToStack();

    boolean getPopoverRemovedFromStack();

    boolean getPopoverShowWithAnimation();

    float getPopoverStackAlphaPrevious();

    int getPopoverStackCoverColor();

    float getPopoverStackScalePrevious();

    boolean getPopoverTransparentBg();

    int getPopoverWidth();

    ViewGroup getPopoverWindowFrame();

    void i();

    boolean j();

    void l();

    void n();

    void setPopoverAnimator(AnimatorSet r1);

    void setPopoverGravity(int r1);

    void setPopoverPushedToStack(boolean r1);

    void setPopoverRemovedFromStack(boolean r1);

    void setPopoverXOffset(int r1);

    void setPopoverYOffset(int r1);
}
