package com.ss.android.lark.forseti.widget;

import android.animation.Animator;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.api.bean.config.ForsetiPageType;
import com.ss.android.lark.api.ui.ForsetiPlaceHolderFragment;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.chain.ForsetiChainFragment;
import com.ss.android.lark.forseti.chain.ForsetiChainHelper;
import com.ss.android.lark.forseti.chain.g;
import com.ss.android.lark.forseti.global.j;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingHelper;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingScaleHandler;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0016\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0084\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010]\u001a\u00020^H\u0014J\b\u0010_\u001a\u00020^H\u0002J\b\u0010`\u001a\u00020^H\u0002J\b\u0010a\u001a\u00020^H\u0002J\b\u0010b\u001a\u00020^H\u0002J\b\u0010c\u001a\u00020^H\u0002J\b\u0010d\u001a\u00020^H\u0002J\b\u0010e\u001a\u00020^H\u0002J\u0012\u0010f\u001a\u00020#2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\u0012\u0010i\u001a\u00020#2\b\u0010j\u001a\u0004\u0018\u00010hH\u0016J\u0010\u0010k\u001a\u00020#2\u0006\u0010g\u001a\u00020hH\u0002J\u0010\u0010l\u001a\u00020#2\u0006\u0010g\u001a\u00020hH\u0002J\u000e\u0010m\u001a\u00020^2\u0006\u0010n\u001a\u00020\u001bJ(\u0010o\u001a\u00020^2\u0010\u0010p\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u0001042\u0006\u0010I\u001a\u00020#2\u0006\u0010?\u001a\u00020\u001bJ\u0006\u0010q\u001a\u00020^J$\u0010r\u001a\u00020^2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u0010I\u001a\u00020#H\u0002J$\u0010s\u001a\u00020^2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010t\u001a\u0004\u0018\u00010\u00152\u0006\u0010?\u001a\u00020\u001bH\u0002J\u0010\u0010u\u001a\u00020^2\u0006\u0010v\u001a\u00020\u001bH\u0002J\u0010\u0010w\u001a\u00020#2\u0006\u0010g\u001a\u00020hH\u0002J\u0010\u0010x\u001a\u00020#2\u0006\u0010g\u001a\u00020hH\u0002J\u0012\u0010y\u001a\u00020#2\b\u0010g\u001a\u0004\u0018\u00010hH\u0002J\u0010\u0010z\u001a\u00020^2\b\u0010T\u001a\u0004\u0018\u00010UJ\"\u0010{\u001a\u00020^2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010|\u001a\u00020\u00152\b\u0010}\u001a\u0004\u0018\u00010UH\u0002J\u000e\u0010~\u001a\u00020^2\u0006\u0010C\u001a\u00020#J\u000f\u0010\u007f\u001a\u00020^2\u0007\u0010\u0080\u0001\u001a\u00020LJ\u0007\u0010\u0081\u0001\u001a\u00020^J\u0010\u0010\u0082\u0001\u001a\u00020^2\u0007\u0010\u0080\u0001\u001a\u00020NJ\u0007\u0010\u0083\u0001\u001a\u00020^R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010$R\u000e\u0010%\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R!\u00103\u001a\b\u0012\u0004\u0012\u00020\u0015048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R\u001e\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u0001048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u00106R\u0014\u0010;\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u001dR\u0014\u0010A\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010=R\u001a\u0010C\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010$\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010$\"\u0004\bG\u0010ER\u000e\u0010H\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010$\"\u0004\bJ\u0010ER\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010$\"\u0004\bP\u0010ER\u001a\u0010Q\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010$\"\u0004\bS\u0010ER\u001c\u0010T\u001a\u0004\u0018\u00010UX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010$R\u0014\u0010\\\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010$¨\u0006\u0085\u0001"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainDraggingLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "forsetiChainFragment", "Lcom/ss/android/lark/forseti/chain/ForsetiChainFragment;", "draggingHelper", "Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;", "contentViewWrapper", "Landroid/view/ViewGroup;", "getContentViewWrapper", "()Landroid/view/ViewGroup;", "forsetiNormalChainViewGroupCompat", "Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainViewGroupCompat;", "firstChild", "Landroid/view/View;", "getFirstChild", "()Landroid/view/View;", "lastChild", "getLastChild", "lastChildLeft", "", "getLastChildLeft", "()F", "chainHelper", "Lcom/ss/android/lark/forseti/chain/ForsetiChainHelper;", "getChainHelper", "()Lcom/ss/android/lark/forseti/chain/ForsetiChainHelper;", "isLastForsetiNodeFull", "", "()Z", "dividerInitialXWhenAnimation", "divideCurrentXWhenAnimation", "actionDownTimeMills", "", "lastClickTime", "draggingView", "Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainDraggingView;", "startTouchX", "startTouchY", "currentTouchX", "currentTouchY", "isHitHotSpot", "hotSpot", "Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper$Region;", "invisibleViews", "", "getInvisibleViews", "()Ljava/util/List;", "invisibleViews$delegate", "Lkotlin/Lazy;", "allViews", "getAllViews", "viewsCount", "getViewsCount", "()I", "clickTimeOut", "dx", "getDx", "initialTranslationX", "getInitialTranslationX", "isMoving", "setMoving", "(Z)V", "isInAnimation", "setInAnimation", "isSingleClick", "isShowOverlay", "setShowOverlay", "nodeScaleListener", "Lcom/ss/android/lark/api/ui/IForsetiNodeScaleListener;", "nodeShowOverlayListener", "Lcom/ss/android/lark/api/ui/IForsetiNodeShowOverlayListener;", "isDraggingSupport", "setDraggingSupport", "toFullScreenInDragging", "getToFullScreenInDragging", "setToFullScreenInDragging", "rightSideWidth", "Lcom/ss/android/lark/api/bean/ForsetiWidth;", "getRightSideWidth", "()Lcom/ss/android/lark/api/bean/ForsetiWidth;", "setRightSideWidth", "(Lcom/ss/android/lark/api/bean/ForsetiWidth;)V", "addVerticalLine", "getAddVerticalLine", "isPlaceholderFronted", "onDetachedFromWindow", "", "observeLastNodeLeftChange", "updateRelatedData", "updateDraggingView", "clearFlag", "updateDraggingPosIfNeed", "initDraggingView", "initViews", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "ev", "actionDownHandler", "actionMoveHandler", "updateDraggingViewUI", "currentX", "showOverlayAndPerformScale", "views", "makeViewVisible", "showRenderEffect", "performScale", "secondChild", "performDividerTranslationX", "newdx", "actionUpHandler", "actionCancelHandler", "defaultActionHandler", "updateChildrenWidth", "updateWidth", "view", "forsetiWidth", "updatePaintColor", "addUpdateScaleFactorListener", "listener", "removeUpdateScaleFactorListener", "addNodeShowOverlayListener", "removeNodeShowOverlayListener", "Companion", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class ForsetiNormalChainDraggingLayout extends FrameLayout {
    public ForsetiChainFragment a;
    public ForsetiColumnsDraggingHelper b;
    public ForsetiNormalChainViewGroupCompat c;
    public float d;
    public float e;
    public long f;
    public long g;
    public ForsetiNormalChainDraggingView h;
    public float i;
    public float j;
    public float k;
    public boolean l;
    public ForsetiColumnsDraggingHelper.b m;
    public final Lazy n;
    public final int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public ForsetiWidth u;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ ForsetiNormalChainDraggingLayout a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ForsetiNormalChainDraggingLayout.e(this.a);
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        public a(ForsetiNormalChainDraggingLayout r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    public static final class c implements com.ss.android.lark.forseti.util.dragging.a.InterfaceC0068a {
        public final /* synthetic */ ForsetiNormalChainDraggingLayout a;
        public final /* synthetic */ float b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            ForsetiNormalChainDraggingLayout r5 = this.a;
            r5.m(ForsetiNormalChainDraggingLayout.c(r5), ForsetiNormalChainDraggingLayout.d(this.a), false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r6) {
            Intrinsics.checkNotNullParameter(r6, "animation");
            this.a.setInAnimation(false);
            ForsetiWidth r1 = null;
            if (this.a.getToFullScreenInDragging() == false) goto L25;
            View r7 = ForsetiNormalChainDraggingLayout.d(this.a);
            if (r7 == null) goto L7;
            ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        L9:
            if ((r8 instanceof ForsetiNormalChainViewGroup.b) == false) goto L11;
            ForsetiNormalChainViewGroup.b r9 = (ForsetiNormalChainViewGroup.b) r8;
        L12:
            if (r9 == null) goto L14;
            ForsetiWidth r10 = r9.a;
        L16:
            if (r10 == ForsetiWidth.FULL) goto L26;
            ForsetiChainFragment r11 = this.a.a;
            if (r11 == null) goto L20;
            Fragment r12 = r11.ba0();
        L21:
            if (r12 == null) goto L26;
            ForsetiChainFragment r2 = this.a.a;
            if (r2 == null) goto L26;
            r2.ea0(r12).d(false);
            goto L26
        L20:
            r12 = null;
        L26:
            ForsetiNormalChainDraggingLayout r13 = this.a;
            r13.n(r13.getRightSideWidth());
            ForsetiWidth r14 = this.a.getRightSideWidth();
            if (r14 == null) goto L44;
            ForsetiChainFragment r3 = this.a.a;
            if (r3 == null) goto L44;
            g r4 = r3.q;
            if (r4 == null) goto L44;
            Intrinsics.checkNotNullParameter(r14, "forsetiWidth");
            ForsetiChainHelper r5 = r4.a.j;
            if (r5 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
            r5 = null;
        L35:
            r5.getClass();
            Intrinsics.checkNotNullParameter(r14, "forsetiWidth");
            int r15 = fib.a.a;
            if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.full_screen_switch_disabled") == false) goto L38;
        L40:
            com.ss.android.lark.forseti.util.dragging.d.a.getClass();
            com.ss.android.lark.forseti.util.dragging.d.c = r14;
            ForsetiColumnsDraggingHelper r16 = r5.f;
            if (r16 == null) goto L43;
            r1 = r16.a(r14);
        L43:
            com.ss.android.lark.forseti.util.dragging.d.b = r1;
            goto L44
        L38:
            if (r14 != ForsetiWidth.FULL) goto L40;
            Log.i("FST_ChainHelper", "right node width is full, stops to record full width.");
        L44:
            this.a.setShowOverlay(false);
            ForsetiNormalChainDraggingLayout r17 = this.a;
            r17.l(ForsetiNormalChainDraggingLayout.a(r17), false, ForsetiNormalChainDraggingLayout.b(this.a));
            this.a.j();
            this.a.p(false);
            if (this.a.getToFullScreenInDragging() == false) goto L47;
            float r18 = 0.0f;
        L48:
            this.a.o(r18);
            return;
        L47:
            r18 = this.b;
            goto L48
        L14:
            r10 = null;
            goto L16
        L11:
            r9 = null;
            goto L12
        L7:
            r8 = null;
            goto L9
        L25:
            j.a(false);
            goto L26
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setInAnimation(true);
            this.a.setMoving(false);
        }

        public c(ForsetiNormalChainDraggingLayout r1, float r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.ss.android.lark.forseti.util.dragging.a.InterfaceC0068a
        public final void c(float r3, float r4) {
            ForsetiNormalChainDraggingLayout r5 = this.a;
            r5.e = r3;
            r5.l(ForsetiNormalChainDraggingLayout.a(r5), true, ForsetiNormalChainDraggingLayout.b(this.a));
        }
    }

    static {
    }

    public ForsetiNormalChainDraggingLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ForsetiNormalChainDraggingLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setShowOverlay(boolean r1) {
    }

    private final boolean getAddVerticalLine() {
        ForsetiNormalChainViewGroupCompat r0 = this.c;
        boolean r1 = false;
        if (r0 == null) goto L17;
        ForsetiChainHelper r2 = getChainHelper();
        if (r2 == null) goto L14;
        boolean r3 = r0.a;
        Intrinsics.checkNotNullParameter(r0, "viewGroup");
        if (((Boolean) r2.o.getValue()).booleanValue() == true) goto L13;
        if (r3 == true) goto L13;
        if (r0.getChildCount() < 2) goto L13;
        r1 = true;
    L13:
        Boolean r4 = Boolean.valueOf(r1);
    L16:
        return Intrinsics.areEqual(r4, Boolean.TRUE);
    L14:
        r4 = null;
        goto L16
    L17:
        return false;
    }

    private final List<View> getAllViews() {
        ForsetiNormalChainViewGroupCompat r0 = this.c;
        if (r0 == null) goto L7;
        int r1 = cib.b.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        int r2 = r0.getChildCount();
        ArrayList r3 = new ArrayList(r2);
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L10;
        r3.add(r0.getChildAt(r4));
        r4 = r4 + 1;
        goto L5
    L10:
        return r3;
    L7:
        return null;
    }

    private final ForsetiChainHelper getChainHelper() {
        ForsetiChainFragment r0 = this.a;
        if (r0 == null) goto L9;
        ForsetiChainHelper r1 = r0.j;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
        return null;
    L8:
        return r1;
    L9:
        return null;
    }

    private final float getDx() {
        if (this.p == false) goto L8;
        if (this.r == true) goto L8;
        float r0 = this.k;
        float r1 = getLastChildLeft();
    L13:
        return r0 - r1;
    L8:
        if (this.q == false) goto L11;
        r0 = this.e;
        r1 = getLastChildLeft();
        goto L13
    L11:
        return 0.0f;
    }

    private final View getFirstChild() {
        ForsetiNormalChainViewGroupCompat r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChildAt(0);
    }

    private final List<View> getInvisibleViews() {
        return (List) this.n.getValue();
    }

    private final View getLastChild() {
        ForsetiNormalChainViewGroupCompat r0 = this.c;
        if (r0 == null) goto L7;
        Sequence r1 = ViewGroupKt.getChildren(r0);
        if (r1 == null) goto L7;
        return (View) SequencesKt.lastOrNull(r1);
    L7:
        return null;
    }

    public final void i() {
        ForsetiColumnsDraggingHelper r4 = null;
        ForsetiNormalChainDraggingView r0 = new ForsetiNormalChainDraggingView(getContext(), null, 6, 0);
        r0.setTranslationX(getInitialTranslationX());
        this.h = r0;
        ForsetiColumnsDraggingHelper r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
    L6:
        r0.setForsetiColumnsDraggingHelper(r4);
        addView(this.h);
        setTag("FST_DraggingLayout");
        o(getLastChildLeft());
        return;
    L5:
        r4 = r1;
        goto L6
    }

    private final ViewGroup getContentViewWrapper() {
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewGroup) == true) goto L7;
        return null;
    L7:
        return (ViewGroup) r0;
    }

    private final int getInitialTranslationX() {
        float r0 = getLastChildLeft();
        ForsetiColumnsDraggingHelper r1 = this.b;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
        r1 = null;
    L6:
        return (int) (r0 - (r1.s / 2.0f));
    }

    private final float getLastChildLeft() {
        View r0 = getLastChild();
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getLeft();
    }

    private final int getViewsCount() {
        List<View> r0 = getAllViews();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final void j() {
        Iterator<T> r0 = getInvisibleViews().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((View) r0.next()).setVisibility(0);
        goto L4
    L6:
        getInvisibleViews().clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ForsetiChainFragment r0 = this.a;
        if (r0 == null) goto L6;
        r0.X90(r0.k, new com.ss.android.lark.forseti.chain.j(r0));
        return;
    }

    public final ForsetiWidth getRightSideWidth() {
        return this.u;
    }

    public final boolean getToFullScreenInDragging() {
        return this.t;
    }

    public static final /* synthetic */ List a(ForsetiNormalChainDraggingLayout r0) {
        return r0.getAllViews();
    }

    public static final /* synthetic */ float b(ForsetiNormalChainDraggingLayout r0) {
        return r0.getDx();
    }

    public static final /* synthetic */ View c(ForsetiNormalChainDraggingLayout r0) {
        return r0.getFirstChild();
    }

    public static final /* synthetic */ View d(ForsetiNormalChainDraggingLayout r0) {
        return r0.getLastChild();
    }

    public static final void e(ForsetiNormalChainDraggingLayout r3) {
        ViewGroup r0 = r3.getContentViewWrapper();
        ForsetiChainFragment r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.getChildAt(0);
    L7:
        if ((r2 instanceof ForsetiNormalChainViewGroupCompat) == false) goto L9;
        ForsetiNormalChainViewGroupCompat r4 = (ForsetiNormalChainViewGroupCompat) r2;
    L10:
        r3.c = r4;
        ViewGroup r5 = r3.getContentViewWrapper();
        if (r5 == null) goto L13;
        Object r6 = r5.getTag();
    L15:
        if ((r6 instanceof ForsetiChainFragment) == false) goto L17;
        r1 = (ForsetiChainFragment) r6;
    L17:
        r3.a = r1;
        if (r1 == null) goto L21;
        ForsetiColumnsDraggingHelper r7 = r1.da0();
        if (r7 == null) goto L21;
    L22:
        r3.b = r7;
        ForsetiChainFragment r8 = r3.a;
        if (r8 == null) goto L26;
        com.ss.android.lark.forseti.widget.a r9 = new com.ss.android.lark.forseti.widget.a(r3);
        Intrinsics.checkNotNullParameter(r9, "listener");
        r8.X90(r8.k, new com.ss.android.lark.forseti.chain.c(r8, r9));
        return;
    L26:
        return;
    L21:
        r7 = new ForsetiColumnsDraggingHelper(r3.getContext());
        goto L22
    L13:
        r6 = null;
        goto L15
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public static final void f(ForsetiNormalChainDraggingLayout r5) {
        if (r5.getChildCount() != 0) goto L14;
        int r0 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.dragging_view_disabled") == true) goto L11;
        if (r5.getAddVerticalLine() == false) goto L9;
        Log.i("FST_DraggingLayout", "init dragging view.");
        r5.i();
    L9:
        Log.i("FST_DraggingLayout", "addVerticalLine is false, not init dragging view.");
    L62:
        ForsetiNormalChainDraggingView r1 = r5.h;
        if (r1 == null) goto L66;
        r1.setDraggingSupport(r5.s);
        return;
    L66:
        return;
    L11:
        if (r5.s == false) goto L62;
        Log.i("FST_DraggingLayout", "init dragging view.");
        r5.i();
        goto L62
    L14:
        if (r5.getChildCount() <= 0) goto L62;
        ForsetiNormalChainDraggingView r2 = r5.h;
        boolean r3 = true;
        if (r2 != null) goto L18;
    L20:
        boolean r4 = false;
    L21:
        if (r4 == true) goto L59;
        ForsetiNormalChainDraggingView r6 = r5.h;
        if (r6 != null) goto L25;
    L27:
        r3 = false;
    L28:
        if (r3 == true) goto L59;
        Float r7 = null;
        if (r5.s == true) goto L50;
        Log.i("FST_DraggingLayout", "Dragging not supported. Update dragging view to vertical line.");
        int r8 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.dragging_view_disabled") == false) goto L35;
        r5.p = false;
        r5.removeAllViews();
        goto L62
    L35:
        if (r5.getAddVerticalLine() == true) goto L38;
        Log.i("FST_DraggingLayout", "remove vertical line.");
        r5.p = false;
        r5.removeAllViews();
    L47:
        Log.i("FST_DraggingLayout", "remains vertical line.");
        goto L62
    L38:
        if (r5.p == true) goto L47;
        ForsetiNormalChainDraggingView r9 = r5.h;
        if (r9 == null) goto L43;
        r7 = Float.valueOf(r9.getTranslationX());
    L43:
        if (Intrinsics.areEqual(r7, r5.getInitialTranslationX()) == true) goto L47;
        Log.i("FST_DraggingLayout", "updateDraggingPosIfNeed calls.");
        r5.p = false;
        r5.o(r5.getLastChildLeft());
        float r10 = r5.getInitialTranslationX();
        ForsetiNormalChainDraggingView r11 = r5.h;
        if (r11 == null) goto L47;
        r11.setTranslationX(r10);
        goto L47
    L50:
        if (r5.p == true) goto L62;
        ForsetiNormalChainDraggingView r12 = r5.h;
        if (r12 == null) goto L55;
        r7 = Float.valueOf(r12.getTranslationX());
    L55:
        if (Intrinsics.areEqual(r7, r5.getInitialTranslationX()) == true) goto L62;
        Log.d("FST_DraggingLayout", "update dragging view translation.");
        r5.p = false;
        r5.o(r5.getLastChildLeft());
        float r13 = r5.getInitialTranslationX();
        ForsetiNormalChainDraggingView r14 = r5.h;
        if (r14 == null) goto L62;
        r14.setTranslationX(r13);
        goto L62
    L25:
        if (r6.getMeasuredHeight() != 0) goto L27;
    L59:
        Log.d("FST_DraggingLayout", "refresh dragging view.");
        ForsetiNormalChainDraggingView r15 = r5.h;
        if (r15 == null) goto L62;
        int r16 = cib.b.a;
        r15.requestLayout();
        goto L62
    L18:
        if (r2.getMeasuredWidth() != 0) goto L20;
        r4 = true;
        goto L21
    }

    public static final void g(ForsetiNormalChainDraggingLayout r7) {
        ForsetiNormalChainViewGroupCompat r0 = r7.c;
        ForsetiColumnsDraggingHelper r1 = null;
        if (r0 == null) goto L41;
        int r2 = fib.a.a;
        boolean r3 = false;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.dragging_view_disabled") == true) goto L11;
        ForsetiChainHelper r4 = r7.getChainHelper();
        if (r4 != null) goto L9;
    L40:
        r7.s = r3;
        goto L41
    L9:
        if (r4.a(null, true) != true) goto L40;
    L39:
        r3 = true;
        goto L40
    L11:
        ForsetiChainHelper r5 = r7.getChainHelper();
        if (r5 == null) goto L40;
        boolean r6 = r0.a;
        Intrinsics.checkNotNullParameter(r0, "viewGroup");
        com.ss.android.lark.api.bean.config.a r8 = r5.c.f;
        if (r8 == null) goto L20;
        com.ss.android.lark.api.bean.config.b r9 = r8.f;
        if (r9 == null) goto L20;
        if (r9.c == true) goto L20;
        boolean r10 = true;
    L22:
        if ((!r10) == false) goto L37;
        if (r8 == null) goto L26;
        ForsetiPageType r11 = r8.c;
    L28:
        if (r11 != ForsetiPageType.ALL_PAGES_FULLSCREEN) goto L30;
        boolean r12 = true;
    L31:
        if (r12 == true) goto L37;
        if (r6 == true) goto L37;
        if (r0.getChildCount() < 2) goto L37;
        boolean r13 = true;
    L38:
        if (r13 != true) goto L40;
    L30:
        r12 = false;
        goto L31
    L26:
        r11 = null;
    L37:
        r13 = false;
    L20:
        r10 = false;
    L41:
        ForsetiColumnsDraggingHelper r14 = r7.b;
        if (r14 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
    L45:
        r1.z = r7.getMeasuredHeight();
        r1.A = r7.getMeasuredWidth();
        r1.y = r7.getLastChildLeft();
        com.ss.android.lark.forseti.util.dragging.d r15 = com.ss.android.lark.forseti.util.dragging.d.a;
        r7.getInitialTranslationX();
        r15.getClass();
        return;
    L44:
        r1 = r14;
        goto L45
    }

    public final boolean h(MotionEvent r10) {
        if (this.l == false) goto L63;
        long r0 = SystemClock.uptimeMillis();
        long r2 = r0 - this.g;
        this.g = r0;
        boolean r4 = false;
        if (r2 >= 500) goto L8;
        Log.i("FST_DraggingLayout", "elapsedTime is short than min click interval.");
        return false;
    L8:
        Fragment r6 = null;
        if ((r0 - this.f) > this.o) goto L24;
        ForsetiNormalChainDraggingView r1 = this.h;
        if (r1 == null) goto L13;
        ForsetiNormalChainDraggingView.DraggingStatus r3 = r1.getStatus();
    L15:
        if (r3 != ForsetiNormalChainDraggingView.DraggingStatus.UN_DRAGGING_UNDER_FULL) goto L24;
        this.r = true;
        ForsetiChainFragment r11 = this.a;
        if (r11 == null) goto L19;
        r6 = r11.ba0();
    L19:
        if (r6 == null) goto L23;
        ForsetiChainFragment r12 = this.a;
        if (r12 == null) goto L23;
        r12.ea0(r6).c(true);
    L23:
        return true;
    L13:
        r3 = null;
    L24:
        this.r = false;
        this.k = r10.getX();
        r10.getY();
        l(getAllViews(), true, getDx());
        float r13 = getInitialTranslationX() + getDx();
        ForsetiNormalChainDraggingView r5 = this.h;
        if (r5 == null) goto L27;
        r5.setTranslationX(r13);
    L27:
        this.d = this.k;
        ForsetiColumnsDraggingHelper r14 = this.b;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
        r14 = null;
    L30:
        this.u = r14.b(this.d);
        int r15 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.placeholder_dragging_disabled") == false) goto L33;
    L45:
        Fragment r16 = this.b;
        if (r16 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
    L49:
        float r17 = r6.j(this.u);
        if (this.u != ForsetiWidth.FULL) goto L52;
        r4 = true;
    L52:
        this.t = r4;
        if (r4 == false) goto L57;
        ForsetiNormalChainDraggingView r7 = this.h;
        if (r7 == null) goto L57;
        ForsetiNormalChainDraggingView.DraggingStatus r8 = ForsetiNormalChainDraggingView.DraggingStatus.DRAGGING_UNDER_FULL;
        Intrinsics.checkNotNullParameter(r8, "status");
        r7.b = r8;
    L57:
        ForsetiNormalChainDraggingView r9 = this.h;
        if (r9 == null) goto L60;
        float r18 = r9.getTranslationX();
    L61:
        int r19 = com.ss.android.lark.forseti.util.dragging.a.a;
        com.ss.android.lark.forseti.util.dragging.a.a(this.h, this.d, r17, r18, new c(this, r17));
        goto L63
    L60:
        r18 = 0.0f;
        goto L61
    L48:
        r6 = r16;
        goto L49
    L33:
        if (this.u != ForsetiWidth.FULL) goto L45;
        ForsetiChainHelper r110 = getChainHelper();
        if (r110 != null) goto L37;
    L39:
        boolean r111 = false;
    L40:
        if (r111 == false) goto L45;
        Log.i("FST_DraggingLayout", "is not allowed to dragging place holder full.");
        ForsetiColumnsDraggingHelper r112 = this.b;
        if (r112 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
        r112 = null;
    L44:
        this.u = r112.b(this.i);
        goto L45
    L37:
        if ((((Fragment) CollectionsKt.lastOrNull(r110.i.i)) instanceof ForsetiPlaceHolderFragment) != true) goto L39;
        r111 = true;
    L63:
        return this.l;
    }

    public final void n(ForsetiWidth r10) {
        ForsetiNormalChainViewGroupCompat r0 = this.c;
        if (r0 == null) goto L39;
        Sequence r1 = ViewGroupKt.getChildren(r0);
        if (r1 == null) goto L45;
        Iterator r2 = r1.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L46;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        View r6 = (View) r4;
        if (r3 != 0) goto L18;
        ForsetiColumnsDraggingHelper r7 = this.b;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
        r7 = null;
    L17:
        ForsetiWidth r8 = r7.a(r10);
    L19:
        Context r9 = getContext();
        ViewGroup.LayoutParams r11 = r6.getLayoutParams();
        if (r8 != null) goto L23;
        Log.e("FST_DraggingLayout", "updateContentViewWidth failed, forsetiWidth should not be null.");
    L38:
        r3 = r5;
        goto L8
    L23:
        if (r11 == null) goto L35;
        if ((r11 instanceof ForsetiNormalChainViewGroup.b) == false) goto L35;
        ViewGroup.LayoutParams r12 = r6.getLayoutParams();
        if (r12 == null) goto L33;
        ForsetiNormalChainViewGroup.b r13 = (ForsetiNormalChainViewGroup.b) r12;
        if (r13.a == r8) goto L31;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r13.a = r8;
    L31:
        r6.setLayoutParams(r13);
        goto L38
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroup.ForsetiChainLayoutParams");
    L35:
        if (this.b != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
    L37:
        ForsetiNormalChainViewGroup.b r14 = new ForsetiNormalChainViewGroup.b(r9, -1, -1);
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r14.a = r8;
        r6.setLayoutParams(r14);
        goto L38
    L18:
        r8 = r10;
        goto L19
    L46:
        return;
    L45:
        return;
    }

    public final void o(float r3) {
        ForsetiColumnsDraggingHelper r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
        r0 = null;
    L6:
        if (r0.b(r3) != ForsetiWidth.FULL) goto L8;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L12;
        ForsetiNormalChainDraggingView r5 = this.h;
        if (r5 == null) goto L22;
        ForsetiNormalChainDraggingView.DraggingStatus r1 = ForsetiNormalChainDraggingView.DraggingStatus.UN_DRAGGING_OR_DRAGGING_UNDER_HALF_FULL;
        Intrinsics.checkNotNullParameter(r1, "status");
        r5.b = r1;
    L22:
        ForsetiNormalChainDraggingView r6 = this.h;
        if (r6 == null) goto L26;
        r6.invalidate();
        return;
    L26:
        return;
    L12:
        if (this.p == false) goto L16;
        ForsetiNormalChainDraggingView r7 = this.h;
        if (r7 == null) goto L22;
        ForsetiNormalChainDraggingView.DraggingStatus r2 = ForsetiNormalChainDraggingView.DraggingStatus.DRAGGING_UNDER_FULL;
        Intrinsics.checkNotNullParameter(r2, "status");
        r7.b = r2;
        goto L22
    L16:
        ForsetiNormalChainDraggingView r8 = this.h;
        if (r8 == null) goto L22;
        ForsetiNormalChainDraggingView.DraggingStatus r9 = ForsetiNormalChainDraggingView.DraggingStatus.UN_DRAGGING_UNDER_FULL;
        Intrinsics.checkNotNullParameter(r9, "status");
        r8.b = r9;
        goto L22
    L8:
        r4 = false;
        goto L10
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return this.s;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r12) {
        if (this.s == false) goto L5;
        ForsetiColumnsDraggingHelper.b r0 = null;
        if (r12 == null) goto L9;
        Integer r1 = Integer.valueOf(r12.getAction());
    L11:
        if (r1 != null) goto L14;
    L90:
        if (r1 != null) goto L93;
    L104:
        if (r1 != null) goto L107;
    L109:
        if (r1 != null) goto L112;
        return false;
    L112:
        if (r1.intValue() == 3) goto L114;
        return false;
    L114:
        return h(r12);
    L107:
        if (r1.intValue() != 1) goto L109;
        return h(r12);
    L93:
        if (r1.intValue() != 2) goto L104;
        if (this.l == false) goto L116;
        this.p = true;
        this.k = r12.getX();
        r12.getY();
        o(this.k);
        l(getAllViews(), true, getDx());
        float r13 = getInitialTranslationX() + getDx();
        ForsetiNormalChainDraggingView r2 = this.h;
        if (r2 == null) goto L99;
        r2.setTranslationX(r13);
    L99:
        com.ss.android.lark.forseti.util.dragging.d r14 = com.ss.android.lark.forseti.util.dragging.d.a;
        ForsetiNormalChainDraggingView r3 = this.h;
        if (r3 == null) goto L102;
        r3.getTranslationX();
    L102:
        r14.getClass();
    L116:
        return this.l;
    L14:
        if (r1.intValue() != 0) goto L90;
        this.i = r12.getX();
        this.j = r12.getY();
        this.k = this.i;
        ForsetiColumnsDraggingHelper r15 = this.b;
        if (r15 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
        r15 = null;
    L19:
        if (ForsetiColumnsDraggingHelper.h(r15.z) == true) goto L30;
        float r4 = r15.y;
        int r6 = r15.i;
        float r5 = r4 - ((r6 - r15.k) / 2.0f);
        float r7 = r6 + r5;
        float r8 = r15.z;
        float r9 = r15.h;
        float r10 = (r8 - r9) / 2.0f;
        float r11 = r9 + r10;
        if (r15.f() == false) goto L24;
    L31:
        ForsetiColumnsDraggingHelper.b r16 = new ForsetiColumnsDraggingHelper.b(r5, r10, r7, r11);
    L32:
        this.m = r16;
        if (getLastChildLeft() != 0.0f) goto L35;
        boolean r17 = true;
    L36:
        if (r17 == false) goto L62;
        ForsetiColumnsDraggingHelper r18 = this.b;
        if (r18 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
        r18 = null;
    L41:
        if (ForsetiColumnsDraggingHelper.h(r18.z) == false) goto L44;
    L61:
        this.m = r0;
        goto L62
    L44:
        if (r18.e() == true) goto L46;
        int r19 = r18.t;
    L48:
        if (r18.e() == true) goto L50;
        int r20 = r18.u;
    L51:
        float r21 = r19 + 0.0f;
        float r22 = r20;
        float r23 = (r18.z - r22) / 2.0f;
        float r24 = r22 + r23;
        if (r18.f() == false) goto L54;
    L60:
        r0 = new ForsetiColumnsDraggingHelper.b(0.0f, r23, r21, r24);
        goto L61
    L54:
        if (r18.d == false) goto L60;
        if (r18.f() == true) goto L61;
        if (ForsetiColumnsDraggingHelper.h(r18.z) == true) goto L61;
        float r25 = r18.z;
        float r26 = ((r25 - r18.l) / 2.0f) - (r25 - r18.v);
        r0 = new ForsetiColumnsDraggingHelper.b(0.0f, r23 - r26, r21, r24 - r26);
        goto L61
    L50:
        r20 = r18.h;
        goto L51
    L46:
        r19 = r18.j;
    L62:
        ForsetiColumnsDraggingHelper.b r110 = this.m;
        if (r110 == null) goto L82;
        float r27 = this.i;
        float r28 = this.j;
        float r29 = r110.a;
        if (r27 <= r110.c) goto L67;
    L69:
        boolean r30 = false;
    L70:
        if (r30 == false) goto L79;
        float r31 = r110.b;
        if (r28 <= r110.d) goto L74;
    L76:
        boolean r111 = false;
    L77:
        if (r111 == false) goto L79;
        boolean r112 = true;
    L80:
        if (r112 != true) goto L82;
        boolean r113 = true;
    L83:
        this.l = r113;
        this.p = r113;
        if (r113 == false) goto L115;
        p(true);
        ForsetiNormalChainDraggingView r114 = this.h;
        if (r114 == null) goto L88;
        r114.invalidate();
    L88:
        this.f = System.currentTimeMillis();
        this.r = false;
        m(getFirstChild(), getLastChild(), true);
    L115:
        return this.l;
    L74:
        if (r31 > r28) goto L76;
        r111 = true;
    L79:
        r112 = false;
        goto L80
    L67:
        if (r29 > r27) goto L69;
        r30 = true;
    L82:
        r113 = false;
        goto L83
    L35:
        r17 = false;
        goto L36
    L24:
        if (r15.d == false) goto L31;
        if (r15.f() == true) goto L30;
        if (ForsetiColumnsDraggingHelper.h(r15.z) == true) goto L30;
        float r32 = r15.z;
        float r115 = ((r32 - r15.l) / 2.0f) - (r32 - r15.v);
        r16 = new ForsetiColumnsDraggingHelper.b(r5, r10 - r115, r7, r11 - r115);
    L30:
        r16 = null;
        goto L32
    L9:
        r1 = null;
        goto L11
    L5:
        return super.onTouchEvent(r12);
    }

    public final void p(boolean r5) {
        ForsetiColumnsDraggingHelper r0 = null;
        if (r5 == false) goto L8;
        ForsetiColumnsDraggingHelper r6 = this.b;
        if (r6 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
        r6 = null;
    L7:
        int r7 = r6.x;
    L12:
        ForsetiColumnsDraggingHelper r2 = this.b;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
        r2 = null;
    L15:
        r2.B.setColor(ContextCompat.getColor(getContext(), r7));
        ForsetiColumnsDraggingHelper r3 = this.b;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
    L19:
        r0.C.setColor(ContextCompat.getColor(getContext(), r7));
        return;
    L18:
        r0 = r3;
        goto L19
    L8:
        ForsetiColumnsDraggingHelper r8 = this.b;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
        r8 = null;
    L11:
        r7 = r8.w;
        goto L12
    }

    public final void setDraggingSupport(boolean r1) {
        this.s = r1;
    }

    public final void setInAnimation(boolean r1) {
        this.q = r1;
    }

    public final void setMoving(boolean r1) {
        this.p = r1;
    }

    public final void setRightSideWidth(ForsetiWidth r1) {
        this.u = r1;
    }

    public final void setToFullScreenInDragging(boolean r1) {
        this.t = r1;
    }

    public ForsetiNormalChainDraggingLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.n = LazyKt.lazy(ForsetiNormalChainDraggingLayout$invisibleViews$2.INSTANCE);
        this.o = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        setWillNotDraw(false);
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public static void k(View r4, View r5, float r6) {
        int r0 = ForsetiColumnsDraggingScaleHandler.a;
        if (r4 == null) goto L5;
        float r1 = r4.getMeasuredWidth();
    L6:
        if (r5 == null) goto L8;
        float r2 = r5.getMeasuredWidth();
    L10:
        if (r1 > 0.0f) goto L12;
    L15:
        ForsetiColumnsDraggingScaleHandler.ScaleXFactor r7 = null;
    L16:
        if (r4 == null) goto L22;
        if (r5 == null) goto L23;
        if (r7 == null) goto L24;
        r4.setPivotX(0.0f);
        r5.setPivotX(r5.getMeasuredWidth());
        r4.setScaleX(r7.getFirstFactor());
        r5.setScaleX(r7.getSecondFactor());
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L12:
        if (r2 <= 0.0f) goto L15;
        r7 = new ForsetiColumnsDraggingScaleHandler.ScaleXFactor((r6 / r1) + 1.0f, 1.0f - (r6 / r2));
        goto L16
    L8:
        r2 = 0.0f;
        goto L10
    L5:
        r1 = 0.0f;
        goto L6
    }

    public final void l(List<View> r5, boolean r6, float r7) {
        if (getViewsCount() > 2) goto L6;
        m(getFirstChild(), getLastChild(), r6);
        k(getFirstChild(), getLastChild(), r7);
        return;
    L6:
        if (r5 == null) goto L22;
        Iterator<T> r8 = r5.iterator();
        int r0 = 0;
    L9:
        if (r8.hasNext() == false) goto L27;
        Object r1 = r8.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        View r3 = (View) r1;
        if (r3 == null) goto L21;
        if (r0 != 0) goto L18;
    L20:
        m(getFirstChild(), r3, r6);
        k(getFirstChild(), r3, r7);
        goto L21
    L18:
        if (r0 == (getViewsCount() - 1)) goto L20;
        r3.setVisibility(4);
        getInvisibleViews().add(r3);
    L21:
        r0 = r2;
        goto L9
    L27:
        return;
    }

    public final void m(View r4, View r5, boolean r6) {
        ForsetiColumnsDraggingHelper r0 = this.b;
        ForsetiColumnsDraggingHelper r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
        r0 = null;
    L5:
        r0.getClass();
        ForsetiColumnsDraggingHelper.i(r4, r6);
        ForsetiColumnsDraggingHelper r7 = this.b;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("draggingHelper");
    L9:
        r1.getClass();
        ForsetiColumnsDraggingHelper.i(r5, r6);
        return;
    L8:
        r1 = r7;
        goto L9
    }

    public /* synthetic */ ForsetiNormalChainDraggingLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
