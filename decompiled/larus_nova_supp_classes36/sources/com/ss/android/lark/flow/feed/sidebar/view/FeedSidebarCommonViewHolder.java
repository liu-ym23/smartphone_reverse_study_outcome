package com.ss.android.lark.flow.feed.sidebar.view;

import aeb.f;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.feed.export.feedcard.action.ActionScene;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.export.feedcard.h;
import com.ss.android.lark.feed.shared.page.binder2.o;
import com.ss.android.lark.flow.feed.component.loading.FlowLoadingView;
import com.ss.android.lark.flow.feed.component.title.FlowTitleView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 a2\u00020\u0001:\u0001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020:2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010@\u001a\u00020:2\u0006\u0010=\u001a\u00020>H\u0002J&\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010H\u001a\u00020:H\u0002J\u0010\u0010I\u001a\u00020:2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020LH\u0002J&\u0010U\u001a\u00020:2\u0006\u0010B\u001a\u00020C2\u0006\u0010Q\u001a\u00020R2\u0006\u0010F\u001a\u00020G2\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010V\u001a\u00020:2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J(\u0010W\u001a\u00020:2\u0006\u0010B\u001a\u00020C2\u0006\u0010Q\u001a\u00020R2\u0006\u0010F\u001a\u00020G2\u0006\u0010S\u001a\u00020TH\u0002JD\u0010X\u001a\u00020:2\u0006\u0010B\u001a\u00020C2\u0006\u0010F\u001a\u00020G2\"\u0010Y\u001a\u001e\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\\0Zj\u000e\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\\`]2\u0006\u0010S\u001a\u00020TH\u0002JF\u0010^\u001a\u0004\u0018\u00010\u00132\u0006\u0010B\u001a\u00020C2\u0006\u0010F\u001a\u00020G2\"\u0010Y\u001a\u001e\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\\0Zj\u000e\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\\`]2\u0006\u0010S\u001a\u00020TH\u0002J\u0012\u0010_\u001a\u00020:2\b\u0010`\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/ss/android/lark/flow/feed/sidebar/view/FeedSidebarCommonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "feedCardContext", "Lcom/ss/android/lark/feed/export/feedcard/IFeedCardContext;", "sidebarItemConfig", "Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/SidebarItemConfig;", "<init>", "(Landroid/view/View;Lcom/ss/android/lark/feed/export/feedcard/IFeedCardContext;Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/SidebarItemConfig;)V", "contentView", "Landroid/widget/LinearLayout;", "avatarSlot", "Landroid/widget/FrameLayout;", "titleSlot", "rightSlot", "flowTitleView", "Lcom/ss/android/lark/flow/feed/component/title/FlowTitleView;", "currentLongClickDialog", "Lcom/larksuite/component/universe_design/dialog/UDDialog;", "loadingView", "Lcom/ss/android/lark/flow/feed/component/loading/FlowLoadingView;", "mLastClickTime", "", "value", "Lcom/ss/android/lark/feed/export/feedcard/IOpenFeedCell;", "openFeedCell", "getOpenFeedCell", "()Lcom/ss/android/lark/feed/export/feedcard/IOpenFeedCell;", "setOpenFeedCell", "(Lcom/ss/android/lark/feed/export/feedcard/IOpenFeedCell;)V", "openFeedAction", "Lcom/ss/android/lark/feed/export/feedcard/action/IOpenFeedAction;", "getOpenFeedAction", "()Lcom/ss/android/lark/feed/export/feedcard/action/IOpenFeedAction;", "setOpenFeedAction", "(Lcom/ss/android/lark/feed/export/feedcard/action/IOpenFeedAction;)V", "feedType", "Lcom/ss/android/lark/biz/im/api/FeedCard$Type;", "getFeedType", "()Lcom/ss/android/lark/biz/im/api/FeedCard$Type;", "setFeedType", "(Lcom/ss/android/lark/biz/im/api/FeedCard$Type;)V", "bizType", "Lcom/bytedance/lark/pb/feed/v1/AppFeedCardType;", "getBizType", "()Lcom/bytedance/lark/pb/feed/v1/AppFeedCardType;", "setBizType", "(Lcom/bytedance/lark/pb/feed/v1/AppFeedCardType;)V", "clickDelayJob", "Lkotlinx/coroutines/Job;", "disableDialogNoDismiss", "", "getDisableDialogNoDismiss", "()Z", "disableDialogNoDismiss$delegate", "Lkotlin/Lazy;", "fillContainer", "", "cell", "fillAvatarSlot", "componentInfo", "Lcom/ss/android/lark/feed/export/feedcard/ComponentPackInfo;", "fillTitleSlot", "fillRightSlot", "onBindViewHolder", "uiFeedCard", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "paramsFactory", "Lcom/ss/android/lark/feed/export/feedcard/IComponentParamsFactory;", "itemContainer", "Lcom/ss/android/lark/feed/shared/page/adapter/listener/IItemContainer;", "applyLoadingBadgeMutexAndSlotVisibility", "setBackground", "updateTitleFadeMask", "backgroundColorRes", "", "getUiFeedCard", "()Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "setUiFeedCard", "(Lcom/ss/android/lark/feed/app/entity/UIFeedCard;)V", "manager", "Lcom/ss/android/lark/feed/shared/page/action/FeedActionManager;", "actionStatusListener", "Lcom/ss/android/lark/feed/export/feedcard/action/ActionStatusListener;", "bindAction", "delayUpdate", "bindLongClick", "handleItemLongClick", "feedActionMap", "Ljava/util/LinkedHashMap;", "Lcom/ss/android/lark/feed/export/feedcard/action/FeedActionType;", "Lcom/ss/android/lark/feed/export/feedcard/action/IFeedActionFactory;", "Lkotlin/collections/LinkedHashMap;", "createLongClickDialogWithoutTitleFadeMask", "applySidebarLongClickBlur", "dialog", "Companion", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FeedSidebarCommonViewHolder extends RecyclerView.ViewHolder {
    public static final o s = null;
    public static final int t = 0;
    public static final int u = 0;
    public static final int v = 0;
    public static final int w = 0;
    public static final int x = 0;
    public final com.ss.android.lark.feed.export.feedcard.d a;
    public final iza.e b;
    public final LinearLayout c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final FrameLayout f;
    public FlowTitleView g;
    public UDDialog h;
    public FlowLoadingView i;
    public long j;
    public h k;
    public f l;
    public FeedCard.Type m;
    public AppFeedCardType n;
    public Job o;
    public final Lazy p;
    public UIFeedCard q;
    public ueb.a r;

    public static final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ FeedSidebarCommonViewHolder a;
        public final /* synthetic */ View b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            h r3 = this.a.k;
            if (r3 == null) goto L6;
            r3.onViewAttachedToWindow();
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            h r4 = this.a.k;
            if (r4 == null) goto L5;
            r4.onViewDetachedFromWindow();
        L5:
            this.b.removeOnAttachStateChangeListener(this);
            Job r5 = this.a.o;
            if (r5 == null) goto L8;
            Job.DefaultImpls.cancel$default(r5, null, 1, null);
        L8:
            this.a.c.setSelected(false);
        }

        public a(FeedSidebarCommonViewHolder r1, View r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ FeedSidebarCommonViewHolder a;
        public final /* synthetic */ UIFeedCard b;
        public final /* synthetic */ com.ss.android.lark.feed.export.feedcard.d c;

        public c(FeedSidebarCommonViewHolder r1, UIFeedCard r2, com.ss.android.lark.feed.export.feedcard.d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            this.a.c.setHovered(false);
            long r0 = SystemClock.uptimeMillis();
            FeedSidebarCommonViewHolder r2 = this.a;
            if ((r0 - r2.j) >= 500) goto L6;
            com.ss.android.lark.flow.feed.utils.b.d("FeedSidebarCommonViewHolder", "click had been throttle");
            return;
        L6:
            r2.j = r0;
            com.ss.android.lark.flow.feed.utils.b.d("FeedSidebarCommonViewHolder", "onItemClick: " + this.b.getId());
            com.ss.android.lark.feed.shared.hitpoint.a.a(this.b.getId());
            f r1 = this.a.l;
            if (r1 == null) goto L9;
            UIFeedCard r3 = this.b;
            Intrinsics.checkNotNull(r10);
            r1.j(r3, r10, this.a.getBindingAdapterPosition(), ActionScene.FEED);
        L9:
            com.ss.android.lark.feed.shared.hitpoint.b.a(this.b, null);
            this.a.c.setSelected(true);
            FeedSidebarCommonViewHolder r11 = this.a;
            com.ss.android.lark.feed.export.feedcard.d r4 = this.c;
            Job r5 = r11.o;
            if (r5 == null) goto L12;
            Job.DefaultImpls.cancel$default(r5, null, 1, null);
        L12:
            r11.o = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4.getHost()), null, null, new FeedSidebarCommonViewHolder$delayUpdate$1(r11, null), 3, null);
        }
    }

    public static final class d implements aeb.a {
        public final /* synthetic */ FeedSidebarCommonViewHolder a;
        public final /* synthetic */ seb.b b;

        public d(FeedSidebarCommonViewHolder r1, seb.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(UIFeedCard r6, FeedActionType r7, FeedActionStatus r8, FeedActionEvent r9) {
            Intrinsics.checkNotNullParameter(r6, "data");
            Intrinsics.checkNotNullParameter(r7, "actionType");
            Intrinsics.checkNotNullParameter(r8, "actionStatus");
            Intrinsics.checkNotNullParameter(r9, "event");
            f r4 = this.a.l;
            if (r4 == null) goto L5;
            r4.b(r7, r8, r6);
        L5:
            seb.b r5 = this.b;
            r5.getClass();
            Intrinsics.checkNotNullParameter(r6, "data");
            Intrinsics.checkNotNullParameter(r7, "actionType");
            Intrinsics.checkNotNullParameter(r8, "actionStatus");
            Intrinsics.checkNotNullParameter(r9, "event");
            r5.a.a(r6, r7, r8, r9);
        }
    }

    static {
        Map<ImExtensionType, List<Class<?>>> r0 = com.ss.android.lark.im.base.d.a;
        s = (o) CollectionsKt.firstOrNull(com.ss.android.lark.im.base.d.c(ImExtensionType.FEED_ITEM_LONG_CLICK_DIALOG, o.class));
        t = UIHelper.dp2px(28.0f);
        u = UIHelper.dp2px(12.0f);
        v = UIHelper.dp2px(4.0f);
        w = UIHelper.dp2px(18.0f);
        x = UIHelper.dp2px(30.0f);
    }

    public static View T3(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void W3(UIFeedCard r2) {
        if (Intrinsics.areEqual(jeb.b.a().q3(), r2.getId()) == false) goto L5;
        this.c.setBackgroundResource(2131231982);
        Y3(2131101998);
        return;
    L5:
        this.c.setBackgroundResource(2131231983);
        Y3(2131101996);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X3(h r9) {
        this.k = r9;
        FlowLoadingView r1 = null;
        if ((r9 instanceof ihb.a) == false) goto L5;
        ihb.a r0 = (ihb.a) r9;
    L6:
        if (r0 == null) goto L8;
        r0.d(this.b.i);
    L8:
        if (r9 == null) goto L72;
        View r2 = ((RecyclerView.ViewHolder) this).itemView;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.ViewGroup");
        com.ss.android.lark.feed.export.feedcard.a r10 = r9.a((ViewGroup) r2);
        if (r10.a == null) goto L13;
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        this.c.addView(r10.a);
        return;
    L13:
        FeedCardComponent r3 = r10.b;
        if (this.b.a == false) goto L37;
        if (r3 == null) goto L37;
        View r4 = r3.c();
        View r5 = r4.findViewById(2131381508);
        if (r5 == null) goto L20;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
    L22:
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
    L25:
        if (r7 == null) goto L29;
        r4.setTranslationX(0.0f);
        r7.leftMargin = u;
        int r8 = t;
        r7.width = r8;
        r7.height = r8;
        if (r5 == null) goto L31;
        r5.setLayoutParams(r7);
    L31:
        if ((r4 instanceof ViewGroup) == false) goto L33;
        ViewGroup r11 = (ViewGroup) r4;
    L34:
        if (r11 == null) goto L36;
        r11.setClipChildren(true);
    L36:
        FrameLayout r12 = this.d;
        int r13 = u;
        int r14 = t;
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(r13 + r14, r14);
        r15.gravity = 16;
        Unit r16 = Unit.INSTANCE;
        r12.addView(r4, r15);
    L38:
        FeedCardComponent r17 = (FeedCardComponent) ArraysKt.firstOrNull(r10.d);
        if (r17 != null) goto L41;
        this.e.setVisibility(8);
    L56:
        FeedCardComponent r18 = (FeedCardComponent) ArraysKt.firstOrNull(r10.e);
        FeedCardComponent r19 = r10.i;
        if (r18 != null) goto L61;
        if (r19 != null) goto L61;
        this.f.setVisibility(8);
        return;
    L61:
        if (r18 == null) goto L63;
        FrameLayout r20 = this.f;
        View r21 = r18.c();
        int r22 = w;
        FrameLayout.LayoutParams r23 = new FrameLayout.LayoutParams(r22, r22);
        r23.gravity = 17;
        Unit r24 = Unit.INSTANCE;
        r20.addView(r21, r23);
    L63:
        if (r19 == null) goto L68;
        View r25 = r19.c();
        FrameLayout r26 = this.f;
        int r27 = x;
        FrameLayout.LayoutParams r28 = new FrameLayout.LayoutParams(r27, r27);
        r28.gravity = 17;
        Unit r29 = Unit.INSTANCE;
        r26.addView(r25, r28);
        if ((r25 instanceof FlowLoadingView) == false) goto L67;
        r1 = (FlowLoadingView) r25;
    L67:
        this.i = r1;
    L68:
        this.f.setVisibility(8);
        return;
    L41:
        View r30 = r17.c();
        if ((r30 instanceof FlowTitleView) == false) goto L44;
        FlowTitleView r31 = (FlowTitleView) r30;
    L45:
        this.g = r31;
        if (r31 == null) goto L50;
        com.ss.android.lark.flow.feed.component.title.b r32 = r31.getTitleViewComponent();
        if (r32 == null) goto L50;
        TextView r33 = (TextView) r32.c();
    L51:
        if (r33 == null) goto L53;
        r33.setTypeface(null, this.b.b ? 1 : 0);
    L53:
        if (r33 == null) goto L55;
        r33.setEllipsize(null);
    L55:
        FrameLayout r34 = this.e;
        FrameLayout.LayoutParams r35 = new FrameLayout.LayoutParams(-2, -2);
        r35.gravity = 16;
        r35.setMarginStart(this.b.c);
        Unit r36 = Unit.INSTANCE;
        r34.addView(r30, r35);
    L50:
        r33 = null;
        goto L51
    L44:
        r31 = null;
        goto L45
    L33:
        r11 = null;
        goto L34
    L29:
        r4.setTranslationX(-v);
        com.ss.android.lark.flow.feed.utils.b.e("FeedSidebarCommonViewHolder", "fillAvatarSlot fallback: open_feed_avatar missing");
        goto L31
    L24:
        r7 = null;
        goto L25
    L20:
        r6 = null;
    L37:
        this.d.setVisibility(8);
        goto L38
    L72:
        return;
    L5:
        r0 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.FrameLayout, com.ss.android.lark.flow.feed.component.title.FlowTitleView] */
    public final void Y3(int r6) {
        int r7 = ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), r6);
        ?? r0 = this.g;
        if (r0 == 0) goto L6;
        r0.e = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0, r7});
        r0.invalidate();
        return;
    }

    public FeedSidebarCommonViewHolder(View r2, com.ss.android.lark.feed.export.feedcard.d r3, iza.e r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "feedCardContext");
        Intrinsics.checkNotNullParameter(r4, "sidebarItemConfig");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = (LinearLayout) r2.findViewById(2131367862);
        this.d = (FrameLayout) r2.findViewById(2131386413);
        this.e = (FrameLayout) r2.findViewById(2131386422);
        this.f = (FrameLayout) r2.findViewById(2131386419);
        r2.addOnAttachStateChangeListener(new a(this, r2));
        this.m = FeedCard.Type.UNKNOWN;
        this.n = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
        this.p = LazyKt.lazy(LazyThreadSafetyMode.NONE, FeedSidebarCommonViewHolder$disableDialogNoDismiss$2.INSTANCE);
    }

    public final void U3(UIFeedCard r9, seb.b r10, ueb.a r11, com.ss.android.lark.feed.export.feedcard.d r12) {
        Intrinsics.checkNotNullParameter(r9, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r10, "manager");
        Intrinsics.checkNotNullParameter(r11, "itemContainer");
        Intrinsics.checkNotNullParameter(r12, "feedCardContext");
        d r6 = new d(this, r10);
        this.q = r9;
        this.r = r11;
        this.c.setOnLongClickListener(new com.ss.android.lark.flow.feed.sidebar.view.c(r9, this, r10, r11, r6));
        this.c.setOnClickListener(new c(this, r9, r12));
    }

    public final void V3(UIFeedCard r5, com.ss.android.lark.feed.export.feedcard.c r6, ueb.a r7, com.ss.android.lark.feed.export.feedcard.d r8) {
        Intrinsics.checkNotNullParameter(r5, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r6, "paramsFactory");
        Intrinsics.checkNotNullParameter(r7, "itemContainer");
        Intrinsics.checkNotNullParameter(r8, "feedCardContext");
        this.q = r5;
        Job r9 = this.o;
        View r0 = null;
        boolean r1 = true;
        if (r9 == null) goto L5;
        Job.DefaultImpls.cancel$default(r9, null, 1, null);
    L5:
        int r2 = 0;
        this.c.setSelected(false);
        h r10 = this.k;
        if (r10 == null) goto L8;
        r10.b(((RecyclerView.ViewHolder) this).itemView, r5, r6, r8);
    L8:
        FlowLoadingView r11 = this.i;
        int r12 = this.f.getChildCount();
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L15;
        View r3 = this.f.getChildAt(r13);
        if (r3 != r11) goto L12;
        r13 = r13 + 1;
        goto L9
    L12:
        r0 = r3;
    L15:
        if (r11 != null) goto L17;
    L24:
        if (r11 == null) goto L26;
        r11.setVisibility(8);
    L26:
        if (r11 != null) goto L28;
    L30:
        boolean r14 = false;
    L31:
        if (r14 == true) goto L40;
        if (r0 != null) goto L34;
    L36:
        boolean r15 = false;
    L37:
        if (r15 == true) goto L40;
        r1 = false;
        goto L40
    L34:
        if (r0.getVisibility() != 0) goto L36;
        r15 = true;
    L40:
        FrameLayout r16 = this.f;
        if (r1 == true) goto L44;
        r2 = 8;
    L44:
        r16.setVisibility(r2);
        W3(r5);
        return;
    L28:
        if (r11.getVisibility() != 0) goto L30;
        r14 = true;
        goto L31
    L17:
        if (r11.a == null) goto L19;
        boolean r17 = true;
    L20:
        if (r17 == false) goto L24;
        r11.setVisibility(0);
        if (r0 == null) goto L26;
        r0.setVisibility(8);
        goto L26
    L19:
        r17 = false;
        goto L20
    }
}
