package com.larus.bmhome.block.newheader.foldcontainer;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.block.newheader.keywordreferencelist.QueryKeywordReferencesView;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.ExpendAllThinkView;
import com.larus.bmhome.chat.layout.widget.MaxHeightRelativeLayout;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.chat.common.databinding.LarusLayoutExpendAllThinkBinding;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.ActivityIndicatorView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.mainbot.impl.databinding.LarusWidgetTextSourceHeaderBinding;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import ib8.c;
import ib8.g0;
import ib8.h0;
import ib8.i0;
import ib8.j0;
import ib8.k0;
import ib8.l0;
import ib8.m0;
import ib8.n;
import ib8.n0;
import ib8.o0;
import ib8.p0;
import ib8.q0;
import ib8.r0;
import ib8.s0;
import ib8.t0;
import ib8.u0;
import ib8.v0;
import ib8.w0;
import ic8.q;
import java.util.List;
import jb8.d;
import jb8.k;
import kb8.i;
import kc8.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import lb8.g;
import po8.p;
import po8.z;
import so8.f;
import so8.r;
import tk8.e;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u0000 \u0087\u00012\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u00052\u00020\u00062\u00020\u0007:\u0002\u0087\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010E\u001a\u00020\rH\u0002J\u0018\u0010F\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0004H\u0016J\u0018\u0010H\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0004H\u0002J\u0010\u0010I\u001a\u00020<2\u0006\u0010G\u001a\u00020JH\u0002J\b\u0010K\u001a\u0004\u0018\u00010?J \u0010L\u001a\u00020<2\u0006\u0010M\u001a\u00020C2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0004H\u0002J,\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0O2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010P\u001a\u00020A2\u0006\u0010Q\u001a\u00020AH\u0002J4\u0010R\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010U\u001a\u00020V2\b\b\u0002\u0010W\u001a\u00020XH\u0002J\u0010\u0010Y\u001a\u00020<2\u0006\u0010G\u001a\u00020\u0003H\u0002J\u0010\u0010Z\u001a\u00020<2\u0006\u0010G\u001a\u00020\u0003H\u0002J \u0010[\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020\rH\u0002J$\u0010\\\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\b\b\u0002\u0010S\u001a\u00020\r2\b\b\u0002\u0010T\u001a\u00020\rH\u0002J$\u0010]\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\b\b\u0002\u0010S\u001a\u00020\r2\b\b\u0002\u0010T\u001a\u00020\rH\u0002J\u0010\u0010^\u001a\u00020<2\u0006\u0010G\u001a\u00020\u0003H\u0002J\u0010\u0010_\u001a\u00020<2\u0006\u0010`\u001a\u00020CH\u0002J\b\u0010a\u001a\u00020CH\u0002J\b\u0010b\u001a\u00020<H\u0002J\b\u0010c\u001a\u00020CH\u0002J\u0010\u0010d\u001a\u00020<2\u0006\u0010G\u001a\u00020\u0003H\u0002J\u0010\u0010e\u001a\u00020<2\u0006\u0010G\u001a\u00020\u0003H\u0002J\u0010\u0010f\u001a\u00020<2\u0006\u0010G\u001a\u00020\u0003H\u0002J\u0018\u0010g\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010h\u001a\u00020CH\u0002J\b\u0010i\u001a\u00020<H\u0002J\u001a\u0010j\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00032\b\b\u0002\u0010h\u001a\u00020CH\u0002J\u001e\u0010k\u001a\u00020<2\u0006\u0010l\u001a\u00020\"2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020<0;H\u0016J\b\u0010n\u001a\u00020\"H\u0016J\b\u0010o\u001a\u00020pH\u0016J\b\u0010q\u001a\u00020<H\u0016J\n\u0010r\u001a\u0004\u0018\u00010AH\u0016J\u000f\u0010s\u001a\u0004\u0018\u00010<H\u0002¢\u0006\u0002\u0010tJ\b\u0010u\u001a\u00020vH\u0016J\n\u0010w\u001a\u0004\u0018\u00010xH\u0016R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010*\u001a\u0004\b2\u00103R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010*\u001a\u0004\b7\u00108R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010y\u001a\u00020zX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001c\u0010\u007f\u001a\u00020zX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010|\"\u0005\b\u0081\u0001\u0010~R'\u0010\u0082\u0001\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010;X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001¨\u0006\u0088\u0001"}, d2 = {"Lcom/larus/bmhome/block/newheader/foldcontainer/FolderContainerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/block/newheader/foldcontainer/ContainerViewInput;", "Lcom/larus/bmhome/block/newheader/foldcontainer/FoldContainerViewOutput;", "Lcom/larus/bmhome/view/textview/api/selector/IGestureTextView;", "Lcom/larus/bmhome/chat/view/IFoldContainerInterface;", "Lcom/larus/bmhome/block/newheader/IRecyclableLifecycle;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "outerHalfExpandHeight", "Ljava/lang/Integer;", "llReferenceTitleWrapper", "getLlReferenceTitleWrapper", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "subviewContainer", "Lcom/larus/bmhome/chat/layout/widget/MaxHeightRelativeLayout;", "getSubviewContainer", "()Lcom/larus/bmhome/chat/layout/widget/MaxHeightRelativeLayout;", "expandAllThinkView", "Lcom/larus/bmhome/chat/layout/widget/ExpendAllThinkView;", "getExpandAllThinkView", "()Lcom/larus/bmhome/chat/layout/widget/ExpendAllThinkView;", "llReferenceTitleBg", "Lcom/larus/bmhome/block/newheader/foldcontainer/ReferenceTitleBackgroundView;", "getLlReferenceTitleBg", "()Lcom/larus/bmhome/block/newheader/foldcontainer/ReferenceTitleBackgroundView;", "maskReferenceTitle", "Landroid/view/View;", "getMaskReferenceTitle", "()Landroid/view/View;", "foldExpandAnimationHelper", "LFoldExpandAnimationHelper;", "getFoldExpandAnimationHelper", "()LFoldExpandAnimationHelper;", "foldExpandAnimationHelper$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusWidgetTextSourceHeaderBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusWidgetTextSourceHeaderBinding;", "binding$delegate", "headerViewController", "Lcom/larus/bmhome/block/newheader/foldcontainer/viewcontroller/HeaderViewController;", "getHeaderViewController", "()Lcom/larus/bmhome/block/newheader/foldcontainer/viewcontroller/HeaderViewController;", "headerViewController$delegate", "subViewsController", "Lcom/larus/bmhome/block/newheader/foldcontainer/viewcontroller/SubViewsController;", "getSubViewsController", "()Lcom/larus/bmhome/block/newheader/foldcontainer/viewcontroller/SubViewsController;", "subViewsController$delegate", "scrollToAttachCellTopCallback", "Lkotlin/Function0;", "", "output", "headerClickPosition", "", "currentFoldStatus", "Lcom/larus/bmhome/chat/bean/DeepThinkFoldStatus;", "headerStickyEnabled", "", "hideReferenceTitleBackground", "halfFoldExpandHeight", "bindData", "input", "bindFoldContainer", "bindHeaderSplitLine", "Lcom/larus/bmhome/block/newheader/foldcontainer/FoldContainerViewInput;", "currentHeaderTitle", "setupExpandAllView", "reachHalfFoldMaxHeight", "calculateAnimationStartAndEndHeight", "Lkotlin/Pair;", "originFoldStatus", "targetFoldStatus", "animateLayoutHeight", "startHeight", "endHeight", "animationDuration", "", "animationInterpolator", "Landroid/animation/TimeInterpolator;", "executeFoldOrExpandAnimation", "executeScrollIfRequired", "tryScrollAndExpandOrFoldAnimation", "animateHalfFoldTransition", "animateExpandTransition", "updateCommonHeaderUIForExpandedStates", "updateHeaderMaskVisibility", "visible", "shouldHideReferenceTitleBackground", "updateWindowStickyTitleBackground", "isWindowMessageBubbleEnabled", "tryShowExpandAll", "handleHalfFoldStatusUI", "handleCompleteExpandStatusUI", "handleCompleteFoldStatusUI", "animationEndTriggered", "resetAnimationLayoutParams", "refreshLayout", "adjustTopMargin", "itemView", "foldCallback", "getView", "getThinkingContainer", "Landroid/view/ViewGroup;", "onRecycle", "getDeepThinkFoldStatus", "scrollToAttachCellTop", "()Lkotlin/Unit;", "asTextView", "Landroid/widget/TextView;", "getContainer", "Landroid/widget/FrameLayout;", "clickY", "", "getClickY", "()F", "setClickY", "(F)V", "clickX", "getClickX", "setClickX", "downListener", "getDownListener", "()Lkotlin/jvm/functions/Function0;", "setDownListener", "(Lkotlin/jvm/functions/Function0;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FolderContainerView extends ConstraintLayout implements st8.a, p, hb8.a {
    public static final /* synthetic */ int o = 0;
    public Integer a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public Function0<Unit> f;
    public com.larus.bmhome.block.newheader.foldcontainer.b g;
    public String h;
    public DeepThinkFoldStatus i;
    public boolean j;
    public boolean k;
    public float l;
    public float m;
    public Function0<Boolean> n;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DeepThinkFoldStatus.values().length];
            r0[DeepThinkFoldStatus.CompleteFold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DeepThinkFoldStatus.HalfFold.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DeepThinkFoldStatus.CompleteExpand.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public FolderContainerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FolderContainerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View getView() {
        return this;
    }

    public final View l5() {
        return null;
    }

    private final LarusWidgetTextSourceHeaderBinding getBinding() {
        return (LarusWidgetTextSourceHeaderBinding) this.c.getValue();
    }

    private final e0 getFoldExpandAnimationHelper() {
        return (e0) this.b.getValue();
    }

    private final d getHeaderViewController() {
        return (d) this.d.getValue();
    }

    private final k getSubViewsController() {
        return (k) this.e.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V6() {
        if (this.k == false) goto L6;
        e1.o(getMaskReferenceTitle());
        e1.o(getLlReferenceTitleBg());
        return;
    L6:
        ChatWindowServiceDelegate r0 = ChatWindowServiceDelegate.b;
        if (r0.d(getContext()) == true) goto L10;
        return;
    L10:
        if (this.k == false) goto L12;
    L20:
        boolean r1 = true;
    L21:
        if (r1 == true) goto L24;
        return;
    L24:
        if (getLlReferenceTitleWrapper().getTranslationY() <= 0.0f) goto L26;
        boolean r2 = true;
    L27:
        N6(r2);
        e1.y(getLlReferenceTitleBg(), r2);
        if (r2 == false) goto L31;
        ReferenceTitleBackgroundView r3 = getLlReferenceTitleBg();
        r3.i = true;
        r3.h = false;
        r3.j = null;
        r3.k = null;
        r3.l = null;
        r3.a();
        r3.invalidate();
        return;
    L31:
        return;
    L26:
        r2 = false;
        goto L27
    L12:
        if (r0.d(getContext()) == true) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == true) goto L20;
        r1 = false;
        goto L21
    L14:
        if (z2.a.getObricWindowMessageBubbleConfig().getEnable() == false) goto L16;
        r4 = true;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int s6() {
        Integer r0 = this.a;
        if (r0 != null) goto L7;
        Context r1 = getContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        dh8.b.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        return dh8.b.e(dh8.b.b(r1));
    L7:
        return r0.intValue();
    }

    private final ExpendAllThinkView getExpandAllThinkView() {
        return getBinding().d;
    }

    private final ReferenceTitleBackgroundView getLlReferenceTitleBg() {
        return getBinding().i;
    }

    private final ConstraintLayout getLlReferenceTitleWrapper() {
        return getBinding().j;
    }

    private final View getMaskReferenceTitle() {
        return getBinding().k;
    }

    private final MaxHeightRelativeLayout getSubviewContainer() {
        return getBinding().m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C6() {
        MaxHeightRelativeLayout r0 = getSubviewContainer();
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L10;
        r1.height = -2;
        ViewParent r2 = getParent();
        if (r2 == null) goto L7;
        r2.requestLayout();
    L7:
        r0.setLayoutParams(r1);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.View, com.larus.bmhome.chat.layout.widget.ExpendAllThinkView, java.lang.Object] */
    @Override // hb8.a
    public final void f() {
        C6();
        getLlReferenceTitleWrapper().setTranslationY(0.0f);
        this.k = false;
        getSubviewContainer().setMaxHeight(Integer.MAX_VALUE);
        e1.o(getSubviewContainer());
        ?? r1 = getExpandAllThinkView();
        r1.getClass();
        e1.o(r1);
        r1.setDividerVisible(false);
        getSubViewsController().f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FrameLayout getContainer() {
        ViewParent r0 = getParent();
        if ((r0 instanceof FrameLayout) == true) goto L7;
        return null;
    L7:
        return (FrameLayout) r0;
    }

    public ViewGroup getThinkingContainer() {
        k r0 = getSubViewsController();
        if (r0.e().getParent() == null) goto L6;
        return r0.e();
    L6:
        if (r0.h == false) goto L9;
        return r0.b();
    L9:
        return r0.d();
    }

    public float getClickX() {
        return this.m;
    }

    public float getClickY() {
        return this.l;
    }

    public DeepThinkFoldStatus getDeepThinkFoldStatus() {
        return this.i;
    }

    public Function0<Boolean> getDownListener() {
        return this.n;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [ib8.q0] */
    /* JADX WARN: Type inference failed for: r3v0, types: [ib8.r0] */
    public static d T5(final FolderContainerView r4) {
        return new d(r4.getBinding(), new q0(r4), new r0(r4));
    }

    public static e0 c6(FolderContainerView r1) {
        return new e0(r1.getSubviewContainer());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H6(ib8.a r5) {
        getExpandAllThinkView().setDividerVisible(r5.a.b);
        e1.x(getSubviewContainer());
        if (this.k == false) goto L5;
    L13:
        boolean r0 = true;
    L14:
        if (r0 == false) goto L17;
        N6(false);
        e1.o(getLlReferenceTitleBg());
        ShimmerLinearLayout r6 = getBinding().h;
        r6.setPadding(r6.getPaddingLeft(), r6.getPaddingTop(), r6.getPaddingRight(), 0);
        return;
    L17:
        e1.x(getMaskReferenceTitle());
        e1.x(getLlReferenceTitleBg());
        o r1 = r5.a.c;
        if (r1 == null) goto L20;
        boolean r2 = r1.a;
    L21:
        ReferenceTitleBackgroundView r3 = getLlReferenceTitleBg();
        if (r2 == true) goto L24;
    L26:
        boolean r7 = false;
    L27:
        r3.i = true;
        r3.h = r7;
        r3.j = null;
        r3.k = null;
        r3.l = null;
        r3.a();
        r3.invalidate();
        ShimmerLinearLayout r8 = getBinding().h;
        r8.setPadding(r8.getPaddingLeft(), r8.getPaddingTop(), r8.getPaddingRight(), 0);
        return;
    L24:
        if (r5.a.o == true) goto L26;
        r7 = true;
        goto L27
    L20:
        r2 = true;
        goto L21
    L5:
        if (ChatWindowServiceDelegate.b.d(getContext()) == true) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == true) goto L13;
        r0 = false;
        goto L14
    L7:
        if (z2.a.getObricWindowMessageBubbleConfig().getEnable() == false) goto L9;
        r4 = true;
        goto L10
    }

    public final void N6(boolean r2) {
        View r0 = getMaskReferenceTitle();
        if (r2 == false) goto L6;
        int r3 = 0;
    L9:
        r0.setVisibility(r3);
        return;
    L6:
        if (getBinding().e.getVisibility() != 0) goto L8;
        r3 = 4;
        goto L9
    L8:
        r3 = 8;
        goto L9
    }

    public void setClickX(float r1) {
        this.m = r1;
    }

    public void setClickY(float r1) {
        this.l = r1;
    }

    public void setDownListener(Function0<Boolean> r1) {
        this.n = r1;
    }

    public static void R5(ib8.a r2, FolderContainerView r3) {
        if (r2.a.f == true) goto L5;
    L7:
        e1.o(r3.getExpandAllThinkView());
        return;
    L5:
        if (r3.getSubviewContainer().getMeasuredHeight() < r3.s6()) goto L7;
        r3.getExpandAllThinkView().R5(!r2.a.g);
        r3.getExpandAllThinkView().setAlpha(1.0f);
    }

    public static void S5(FolderContainerView r0, n r1) {
        e1.y(r0.getBinding().c, r1.p);
    }

    public static Unit Y5(DeepThinkFoldStatus r0, FolderContainerView r1) {
        if (q.b(r0) == false) goto L6;
        e1.x(r1.getSubviewContainer());
    L6:
        return Unit.INSTANCE;
    }

    public static k Z5(Context r1, FolderContainerView r2) {
        return new k(r1, r2.getSubviewContainer());
    }

    public static Unit b6(FolderContainerView r1, View r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        if (r1.i == DeepThinkFoldStatus.CompleteFold) goto L10;
        com.larus.bmhome.block.newheader.foldcontainer.b r3 = r1.g;
        if (r3 == null) goto L9;
        r3.h(r1, r1.getSubViewsController().c());
    L9:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o6(final ib8.a r20, final com.larus.bmhome.block.newheader.foldcontainer.b r21) {
        Intrinsics.checkNotNullParameter(r20, "input");
        Intrinsics.checkNotNullParameter(r21, "output");
        FLogger.a.d("FolderContainerView", "bindData=============" + r20.a.j);
        n r5 = r20.a;
        this.a = r5.t;
        this.g = r21;
        this.h = r5.u;
        this.i = r5.j.d;
        this.k = r5.C;
        boolean r6 = r5.w;
        this.j = r6;
        if (r6 == true) goto L5;
        getLlReferenceTitleWrapper().setTranslationY(0.0f);
        this.f = null;
        V6();
    L5:
        final n r7 = r20.a;
        if (r7.z == true) goto L8;
        e1.o(getBinding().e);
        e1.o(getBinding().f);
    L15:
        ShimmerLinearLayout r8 = getBinding().h;
        r8.setPaddingRelative(r7.x, r7.y, r8.getPaddingEnd(), r8.getPaddingBottom());
        MaxHeightRelativeLayout r9 = getSubviewContainer();
        boolean r10 = r7.a;
        r9.getClass();
        if (r10 == false) goto L18;
        int r11 = 80;
    L19:
        r9.setGravity(r11);
        final d r12 = getHeaderViewController();
        w0 r13 = r7.d;
        if (ChatWindowServiceDelegate.b.d(getContext()) == true) goto L22;
    L24:
        boolean r14 = false;
    L25:
        if (r14 == false) goto L27;
        HeadTitleLoadingTarget r15 = HeadTitleLoadingTarget.TEXT;
    L28:
        w0 r16 = w0.a(r13, r15, 255);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r16, "input");
        r12.a.o.setText(r16.c);
        we8.a.b(r12.a.o, i5.t(), false, null, null, 12);
        List<String> r17 = r16.d;
        if (r17 != null) goto L31;
    L34:
        boolean r18 = true;
    L35:
        if (r18 == false) goto L37;
        e1.o(r12.a.p);
        e1.x(r12.a.o);
    L50:
        String r19 = r16.e;
        if (r19 != null) goto L53;
    L56:
        boolean r110 = true;
    L57:
        if (r110 == false) goto L59;
        e1.o(r12.a.l);
    L61:
        if (r16.b == false) goto L69;
        int r111 = d.a.a[r16.i.ordinal()];
        if (r111 == 1) goto L68;
        if (r111 != 2) goto L67;
        r12.a.h.a();
        r12.a.o.z(true);
    L70:
        ActivityIndicatorView r112 = r12.a.b;
        boolean r113 = r16.h;
        r112.d = r113;
        e1.y(r112, r113);
        if (r16.h == false) goto L73;
        r12.a.b.b();
        ActivityIndicatorView r114 = r12.a.b;
        Handler r115 = r114.h;
        Intrinsics.checkNotNull(r115);
        r115.post(r114.i);
    L74:
        r12.a.h.setOnLongClickListener(new jb8.a(r12));
        float r116 = r16.f;
        AppCompatImageView r117 = r12.a.g;
        if (r116 != 90.0f) goto L77;
        boolean r118 = true;
    L78:
        if (r118 == false) goto L80;
        int r119 = 2131242201;
    L81:
        r117.setImageResource(r119);
        AppCompatImageView r120 = r12.a.g;
        if (r16.g == true) goto L84;
    L86:
        boolean r121 = false;
    L87:
        e1.y(r120, r121);
        FrameLayout r22 = r12.a.n;
        ViewGroup.LayoutParams r122 = r22.getLayoutParams();
        if (r122 == null) goto L149;
        ViewGroup.MarginLayoutParams r123 = (ViewGroup.MarginLayoutParams) r122;
        if (r16.g == false) goto L92;
    L95:
        int r124 = 0;
    L96:
        r123.setMarginEnd(r124);
        r22.setLayoutParams(r123);
        final d r23 = getHeaderViewController();
        if (r7.v == false) goto L99;
        e1.d(r23.a.h, new jb8.b(r23));
    L100:
        d r24 = getHeaderViewController();
        e1.y(r24.a.j, r7.e);
        getBinding().c.post(new s0(this, r7));
        post(new t0(r7, this, r20, r21));
        n r25 = r20.a;
        r r26 = r25.q;
        if (r26 == null) goto L103;
        DeepThinkFoldStatus r27 = r25.j.d;
        FrameLayout r125 = getBinding().q;
        so8.a r126 = new so8.a(r20.a.j.d);
        MaxHeightRelativeLayout r127 = getBinding().m;
        Intrinsics.checkNotNullParameter(r27, "foldStatus");
        Intrinsics.checkNotNullParameter(r125, "zoomInContainer");
        Intrinsics.checkNotNullParameter(r127, "thinkContainer");
        r26.j = r27;
        r26.i = r126;
        f r28 = (f) r26.h.getValue();
        r28.getClass();
        Intrinsics.checkNotNullParameter(r125, "zoomInContainer");
        Intrinsics.checkNotNullParameter(r127, "thinkContainer");
        r28.c = r125;
        r28.d = r127;
    L103:
        if (r26 == null) goto L105;
        r26.b(getBinding().q);
    L105:
        c r29 = r7.j;
        if (r29.a == false) goto L108;
    L110:
        final c r30 = r20.a.j;
        if (r30.b == true) goto L113;
        u6(r20, false);
    L114:
        k r31 = getSubViewsController();
        r31.getClass();
        Intrinsics.checkNotNullParameter(r20, "input");
        Intrinsics.checkNotNullParameter(r21, "output");
        if (r20.b == null) goto L117;
        r31.h = true;
    L117:
        com.larus.bmhome.chat.standarduikit.vlm.view.a r3 = r20.e;
        if (r3 != null) goto L120;
        e1.o(r31.g());
    L121:
        i r4 = r20.c;
        if (r4 != null) goto L124;
        e1.o((QueryKeywordReferencesView) r31.e.getValue());
    L125:
        nb8.i r32 = r20.d;
        if (r32 != null) goto L128;
        e1.o(r31.d());
    L129:
        g r33 = r20.b;
        if (r33 != null) goto L132;
        e1.o(r31.b());
    L133:
        e r34 = r20.f;
        if (r34 != null) goto L136;
        e1.o(r31.e());
    L141:
        if (r20.a.e == true) goto L147;
        RelativeLayout r1 = r31.b;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L146;
        ViewGroup.MarginLayoutParams r35 = (ViewGroup.MarginLayoutParams) r2;
        r35.topMargin = 0;
        r1.setLayoutParams(r35);
        return;
    L146:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L147:
        return;
    L136:
        tk8.f r36 = r21.f();
        if (r36 != null) goto L139;
        e1.o(r31.e());
        goto L141
    L139:
        r31.a(r31.e(), new RelativeLayout.LayoutParams(-1, -2), 2131387531, 3);
        e1.x(r31.e());
        r31.e().a(r34, r36);
        goto L141
    L132:
        r31.a(r31.b(), new RelativeLayout.LayoutParams(-1, 0), 2131387528, 3);
        e1.x(r31.b());
        r31.b().a(r33, r21.d());
        goto L133
    L128:
        r31.a(r31.d(), new RelativeLayout.LayoutParams(-1, -2), 2131387529, 4);
        e1.x(r31.d());
        r31.d().a(r32, r21.g());
        goto L129
    L124:
        r31.a((QueryKeywordReferencesView) r31.e.getValue(), new RelativeLayout.LayoutParams(-1, -2), 2131387538, 2);
        e1.x((QueryKeywordReferencesView) r31.e.getValue());
        ((QueryKeywordReferencesView) r31.e.getValue()).a(r4, r21.e());
        goto L125
    L120:
        r31.a(r31.g(), new RelativeLayout.LayoutParams(-1, -2), 2131387567, 1);
        e1.x(r31.g());
        r31.g().v(r3, r21.i());
        r31.g().B(r3, 0);
        goto L121
    L113:
        post(new u0(this, r20, r30));
        goto L114
    L108:
        if (r29.b == true) goto L110;
    L99:
        r23.a.h.setOnClickListener(null);
        r23.a.h.setClickable(false);
        goto L100
    L92:
        if (r16.h == true) goto L95;
        r124 = i5.q();
        goto L96
    L149:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L84:
        if (r16.h == true) goto L86;
        r121 = true;
        goto L87
    L80:
        r119 = 2131242202;
        goto L81
    L77:
        r118 = false;
        goto L78
    L73:
        r12.a.b.b();
        goto L74
    L67:
        throw new NoWhenBranchMatchedException();
    L68:
        r12.a.o.x();
        r12.a.h.b();
        goto L70
    L69:
        r12.a.h.a();
        r12.a.o.x();
        goto L70
    L59:
        e1.x(r12.a.l);
        ImageLoaderKt.u(r12.a.l, r16.e, "deep_think_title_icon");
        goto L61
    L53:
        if (r19.length() == 0) goto L56;
        r110 = false;
        goto L57
    L37:
        e1.x(r12.a.p);
        e1.o(r12.a.o);
        List<String> r128 = r16.d;
        List<String> r129 = r12.e;
        if (r129 == null) goto L40;
        int r130 = r129.hashCode();
    L42:
        if (r130 == r128.hashCode()) goto L50;
        r12.e = r128;
        final Context r131 = r12.a.a.getContext();
        z r132 = r12.d;
        if (r132 == null) goto L47;
        r132.b();
    L47:
        r12.a.p.removeAllViews();
        r12.a.p.setFactory(new jb8.c(r131));
        z r133 = new z(r12.a.p, r128);
        r12.d = r133;
        Intrinsics.checkNotNull(r131);
        r133.a(r131);
        z r134 = r12.d;
        if (r134 == null) goto L50;
        r134.c();
        goto L50
    L40:
        r130 = 0;
        goto L42
    L31:
        if (r17.isEmpty() == true) goto L34;
        r18 = false;
        goto L35
    L27:
        r15 = HeadTitleLoadingTarget.CONTAINER;
        goto L28
    L22:
        if (z2.a.getObricWindowMessageBubbleConfig().getEnable() == false) goto L24;
        r14 = true;
        goto L25
    L18:
        r11 = 48;
        goto L19
    L8:
        View r37 = getBinding().e;
        ViewGroup.LayoutParams r135 = r37.getLayoutParams();
        if (r135 == null) goto L155;
        ConstraintLayout.LayoutParams r136 = (ConstraintLayout.LayoutParams) r135;
        ((ViewGroup.MarginLayoutParams) r136).topMargin = r7.A;
        r37.setLayoutParams(r136);
        e1.x(getBinding().e);
        Space r38 = getBinding().f;
        ViewGroup.LayoutParams r137 = r38.getLayoutParams();
        if (r137 == null) goto L153;
        ConstraintLayout.LayoutParams r138 = (ConstraintLayout.LayoutParams) r137;
        ((ViewGroup.MarginLayoutParams) r138).height = r7.B;
        r38.setLayoutParams(r138);
        e1.x(getBinding().f);
        MaxHeightRelativeLayout r39 = getSubviewContainer();
        ViewGroup.LayoutParams r139 = r39.getLayoutParams();
        if (r139 == null) goto L151;
        ConstraintLayout.LayoutParams r140 = (ConstraintLayout.LayoutParams) r139;
        r140.topToTop = -1;
        r140.topToBottom = 2131374314;
        ((ViewGroup.MarginLayoutParams) r140).topMargin = 0;
        r39.setLayoutParams(r140);
        goto L15
    L151:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L153:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L155:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void u1(View r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r5, "foldCallback");
        if (q.a(this.i) == false) goto L5;
        return;
    L5:
        if (this.j == false) goto L18;
        d r1 = getHeaderViewController();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "itemView");
        int r0 = r4.getTop() + e1.n(r1.a.j, r4).y;
        if (r1.a.e.getVisibility() != 0) goto L10;
        int r6 = r1.a.m.getBottom();
        int r2 = r1.a.j.getBottom();
    L11:
        int r7 = r6 - r2;
        if (r0 < 0) goto L14;
        int r8 = 0;
    L15:
        r1.a.j.setTranslationY(r8);
        r1.a.i.invalidate();
        V6();
        this.f = r5;
        return;
    L14:
        r8 = Math.min(-r0, r7);
        goto L15
    L10:
        r6 = r1.a.m.getHeight();
        r2 = r1.a.k.getHeight();
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.View, com.larus.bmhome.chat.layout.widget.ExpendAllThinkView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v13, types: [android.view.View, com.larus.bmhome.chat.layout.widget.ExpendAllThinkView, java.lang.Object] */
    public final void u6(final ib8.a r5, boolean r6) {
        DeepThinkFoldStatus r0 = r5.a.j.d;
        C6();
        int r1 = b.a[r0.ordinal()];
        int r2 = 0;
        if (r1 != 1) goto L5;
        getSubviewContainer().setMaxHeight(Integer.MAX_VALUE);
        ReferenceTitleBackgroundView r3 = getLlReferenceTitleBg();
        r3.i = false;
        r3.invalidate();
        ?? r4 = getExpandAllThinkView();
        r4.getClass();
        e1.o(r4);
        r4.setDividerVisible(false);
        N6(false);
        e1.o(getSubviewContainer());
        if (getLlReferenceTitleWrapper().getTranslationY() <= 0.0f) goto L19;
        getLlReferenceTitleWrapper().setTranslationY(0.0f);
        if (r6 == false) goto L19;
        Function0<Unit> r7 = this.f;
        if (r7 == null) goto L19;
        r7.invoke();
        Unit r8 = Unit.INSTANCE;
    L19:
        Resources r9 = AppHost.a.getApplication().getResources();
        if (r5.a.m == false) goto L22;
        r2 = r9.getDimensionPixelSize(2131165877);
    L22:
        ShimmerLinearLayout r10 = getBinding().h;
        r10.setPadding(r10.getPaddingLeft(), r10.getPaddingTop(), r10.getPaddingRight(), r2);
    L23:
        com.larus.bmhome.block.newheader.foldcontainer.b r11 = this.g;
        if (r11 == null) goto L27;
        r11.c();
        return;
    L27:
        return;
    L5:
        if (r1 != 2) goto L7;
        e1.x(getMaskReferenceTitle());
        post(new i0(r5, this));
        getSubviewContainer().setMaxHeight(s6());
        H6(r5);
        goto L23
    L7:
        if (r1 != 3) goto L10;
        getSubviewContainer().setMaxHeight(Integer.MAX_VALUE);
        ?? r12 = getExpandAllThinkView();
        r12.getClass();
        e1.o(r12);
        r12.setDividerVisible(false);
        View r13 = getMaskReferenceTitle();
        Intrinsics.checkNotNullParameter(r13, "<this>");
        r13.setVisibility(0);
        r13.setAlpha(1.0f);
        ReferenceTitleBackgroundView r14 = getLlReferenceTitleBg();
        Intrinsics.checkNotNullParameter(r14, "<this>");
        r14.setVisibility(0);
        r14.setAlpha(1.0f);
        H6(r5);
        goto L23
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public FolderContainerView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = LazyKt.lazy(new g0(this));
        this.c = LazyKt.lazy(new n0(r2, this));
        this.d = LazyKt.lazy(new o0(this));
        this.e = LazyKt.lazy(new p0(r2, this));
        this.h = "thinking_title";
        this.j = true;
    }

    public static void U5(com.larus.bmhome.block.newheader.foldcontainer.b r0, ExpendAllThinkView r1, FolderContainerView r2) {
        r0.h(r1, r2.getSubViewsController().c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v9, types: [android.view.View, com.larus.bmhome.chat.layout.widget.ExpendAllThinkView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3, types: [ib8.j0] */
    public static void i6(final FolderContainerView r11, final ib8.a r12, c r13) {
        DeepThinkFoldStatus r0 = r13.c;
        DeepThinkFoldStatus r14 = r13.d;
        k r1 = r11.getSubViewsController();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r12, "input");
        boolean r3 = false;
        if (r12.b == null) goto L5;
        int r2 = r1.b().getMeasuredHeight();
    L7:
        if (r12.c == null) goto L9;
        int r4 = ((QueryKeywordReferencesView) r1.e.getValue()).getAnimationMeasureHeight();
    L11:
        if (r12.d == null) goto L13;
        int r5 = r1.d().getMeasuredHeight();
    L15:
        if (r12.e == null) goto L17;
        int r6 = r1.g().A(r12.e);
    L19:
        if (r12.f == null) goto L21;
        int r7 = r1.e().getMeasuredHeight();
    L22:
        final int r8 = (((r2 + r4) + r5) + r6) + r7;
        final int r9 = Math.min(r11.getSubviewContainer().getMeasuredHeight(), r11.s6());
        final int r10 = RangesKt.coerceAtLeast((int) r11.getLlReferenceTitleWrapper().getTranslationY(), 0);
        ?? r15 = new j0(r10, r9, r8);
        int r16 = ((Number) r15.invoke(r0)).intValue();
        int r17 = ((Number) r15.invoke(r14)).intValue();
        Pair r18 = TuplesKt.to(Integer.valueOf(r16), Integer.valueOf(r17));
        int r19 = ((Number) r18.component1()).intValue();
        int r20 = ((Number) r18.component2()).intValue();
        if (r19 != r20) goto L25;
        r11.post(new k0(r12, r11));
        r11.u6(r12, false);
        return;
    L25:
        ?? r110 = r11.getExpandAllThinkView();
        r110.getClass();
        e1.o(r110);
        r110.setDividerVisible(false);
        DeepThinkFoldStatus r111 = r12.a.j.d;
        int r112 = b.a[r111.ordinal()];
        if (r112 != 1) goto L28;
        n6(r11, r12, r19, r20);
        return;
    L28:
        if (r112 == 2) goto L42;
        if (r112 != 3) goto L40;
        int r113 = ((Number) r12.a.n.invoke()).intValue();
        if (r113 > 0) goto L34;
    L38:
        r11.k6(r12, r19, r20, 240, new DecelerateInterpolator());
        return;
    L34:
        if (r12.a.h == false) goto L38;
        com.larus.bmhome.block.newheader.foldcontainer.b r21 = r11.g;
        if (r21 == null) goto L38;
        com.larus.bmhome.block.newheader.foldcontainer.b.a.a(r21, r113, 240);
        goto L38
    L40:
        throw new NoWhenBranchMatchedException();
    L42:
        if (((int) r11.getLlReferenceTitleWrapper().getTranslationY()) <= 0) goto L44;
        r3 = true;
    L44:
        if (r3 == false) goto L49;
        float r114 = -r11.getLlReferenceTitleWrapper().getTranslationY();
        com.larus.bmhome.block.newheader.foldcontainer.b r22 = r11.g;
        if (r22 == null) goto L48;
        r22.a((int) r114, 160, new DecelerateInterpolator());
    L48:
        r11.k6(r12, r19, r20, 160, new LinearInterpolator());
        return;
    L49:
        n6(r11, r12, r19, r20);
        return;
    L21:
        r7 = 0;
        goto L22
    L17:
        r6 = 0;
        goto L19
    L13:
        r5 = 0;
        goto L15
    L9:
        r4 = 0;
        goto L11
    L5:
        r2 = 0;
        goto L7
    }

    public /* synthetic */ FolderContainerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [android.view.View, android.view.ViewGroup, com.larus.bmhome.chat.layout.widget.ExpendAllThinkView] */
    public static void V5(n r3, final FolderContainerView r4, ib8.a r5, final com.larus.bmhome.block.newheader.foldcontainer.b r6) {
        if (r3.f == true) goto L5;
    L7:
        boolean r7 = false;
    L8:
        r4.getClass();
        Integer r1 = r5.a.s;
        if (r1 == null) goto L11;
        r4.getExpandAllThinkView().setupExpandAllMaskRes(r1.intValue());
    L11:
        Integer r2 = r5.a.r;
        if (r2 == null) goto L14;
        r4.getExpandAllThinkView().setupDividerColor(r2.intValue());
    L14:
        r4.getExpandAllThinkView().setDividerVisible(r5.a.b);
        if (r7 == false) goto L26;
        final ?? r8 = r4.getExpandAllThinkView();
        e1.d(r8, new v0(r6));
        r8.setOnLongClickListener(new h0(r6, r8, r4));
        r8.R5(!r5.a.g);
        FLogger.a.d("FolderContainerView", "hideExpandAllThinkTitle:" + r5.a.g);
        if (r5.a.g == false) goto L24;
        LarusLayoutExpendAllThinkBinding r9 = r8.a;
        if (r9 == null) goto L24;
        TextView r10 = r9.b;
        if (r10 == null) goto L24;
        r10.setText("");
    L24:
        r8.setAlpha(1.0f);
        return;
    L26:
        return;
    L5:
        if (r4.getSubviewContainer().getMeasuredHeight() < r4.getSubviewContainer().getMaxHeight()) goto L7;
        r7 = true;
        goto L8
    }

    public static /* synthetic */ void n6(FolderContainerView r7, ib8.a r8, int r9, int r10) {
        r7.k6(r8, r9, r10, 240, new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [ib8.m0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [ib8.l0, java.lang.Object] */
    public final void k6(final ib8.a r6, int r7, int r8, long r9, TimeInterpolator r11) {
        final DeepThinkFoldStatus r0 = r6.a.j.d;
        e0 r1 = getFoldExpandAnimationHelper();
        ?? r2 = new l0(r0, this);
        ?? r3 = new m0(this, r6);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r11, "interpolator");
        Intrinsics.checkNotNullParameter(r2, "onStart");
        Intrinsics.checkNotNullParameter(r3, "onEnd");
        FLogger.a.d("FoldExpandAnimationHelper", "startHeight==" + r7 + ",endHeight==" + r8);
        r1.a.setMaxHeight(-1);
        MaxHeightRelativeLayout r10 = r1.a;
        ViewGroup.LayoutParams r4 = r10.getLayoutParams();
        if (r4 == null) goto L7;
        r4.height = r7;
        r1.a.requestLayout();
        r10.setLayoutParams(r4);
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{r7, r8});
        r12.setDuration(r9);
        r12.setInterpolator(r11);
        r12.addUpdateListener(new d0(r1));
        r12.addListener(new f0(r2, r3));
        r12.start();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
