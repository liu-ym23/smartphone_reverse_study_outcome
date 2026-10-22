package com.ss.android.lark.feed.shared.page.binder2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.shared.page.swipe.BaseFeedSwipeActionView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0087\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010!H\u0002J&\u0010S\u001a\u00020Q2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010Z\u001a\u00020Q2\u0006\u0010T\u001a\u00020U2\u0006\u0010X\u001a\u00020YJ\u0010\u0010[\u001a\u00020Q2\u0006\u0010\\\u001a\u00020\u001dH\u0002J(\u0010e\u001a\u00020Q2\u0006\u0010T\u001a\u00020U2\b\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010X\u001a\u00020Y2\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010f\u001a\u00020Q2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010T\u001a\u00020UH\u0002J\u0018\u0010g\u001a\u00020Q2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010T\u001a\u00020UH\u0002J(\u0010h\u001a\u00020Q2\u0006\u0010T\u001a\u00020U2\u0006\u0010a\u001a\u00020b2\u0006\u0010X\u001a\u00020Y2\u0006\u0010c\u001a\u00020dH\u0002J\u0010\u0010i\u001a\u00020Q2\u0006\u0010T\u001a\u00020UH\u0002J(\u0010j\u001a\u00020Q2\u0006\u0010T\u001a\u00020U2\u0006\u0010a\u001a\u00020b2\u0006\u0010X\u001a\u00020Y2\u0006\u0010c\u001a\u00020dH\u0002J\u0010\u0010k\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010l\u001a\u00020Q2\u0006\u0010T\u001a\u00020UH\u0002J*\u0010m\u001a\u00020Q2\u0006\u0010T\u001a\u00020U2\b\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010X\u001a\u00020Y2\u0006\u0010c\u001a\u00020dH\u0002JD\u0010n\u001a\u00020Q2\u0006\u0010T\u001a\u00020U2\u0006\u0010X\u001a\u00020Y2\"\u0010o\u001a\u001e\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020r0pj\u000e\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020r`s2\u0006\u0010c\u001a\u00020dH\u0002J\b\u0010t\u001a\u00020QH\u0016J\u0010\u0010u\u001a\u00020Q2\u0006\u0010v\u001a\u00020UH\u0016J\b\u0010w\u001a\u00020\u001dH\u0016J \u0010z\u001a\u00020Q2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020|2\u0006\u0010~\u001a\u00020\u001aH\u0016J\b\u0010\u007f\u001a\u00020QH\u0002J\u0011\u0010\u0080\u0001\u001a\u00020Q2\u0006\u0010{\u001a\u00020|H\u0002J\u0011\u0010\u0081\u0001\u001a\u00020Q2\u0006\u0010{\u001a\u00020|H\u0003J\t\u0010\u0082\u0001\u001a\u00020QH\u0002J\t\u0010\u0083\u0001\u001a\u00020QH\u0002J\u0014\u0010\u0084\u0001\u001a\u00020Q2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u0086\u0001\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010;\u001a\u00020<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b=\u0010>R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010L\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010@\u001a\u0004\bM\u0010NR\u001c\u0010T\u001a\u0004\u0018\u00010UX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010x\u001a\u0004\u0018\u00010yX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0088\u0001"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/binder2/FeedCommonViewHolder;", "Lcom/ss/android/lark/feed/shared/page/binder2/BaseFeedSwipeableViewHolder;", "itemView", "Landroid/view/View;", "feedCardContext", "Lcom/ss/android/lark/feed/export/feedcard/IFeedCardContext;", "<init>", "(Landroid/view/View;Lcom/ss/android/lark/feed/export/feedcard/IFeedCardContext;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "mLastClickTime", BuildConfig.FLAVOR, "mInterval", "rightActionContainer", "Landroid/widget/LinearLayout;", "leftActionContainer", "contentView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "priorityMessageView", "Landroid/widget/RelativeLayout;", "displayRightActionViews", BuildConfig.FLAVOR, "Lcom/ss/android/lark/feed/shared/page/swipe/BaseFeedSwipeActionView;", "leftView", "bindLeftActionState", BuildConfig.FLAVOR, "forceRightActionFresh", "doneWidth", BuildConfig.FLAVOR, "getDoneWidth", "()I", "value", "Lcom/ss/android/lark/feed/export/feedcard/IOpenFeedCell;", "openFeedCell", "getOpenFeedCell", "()Lcom/ss/android/lark/feed/export/feedcard/IOpenFeedCell;", "setOpenFeedCell", "(Lcom/ss/android/lark/feed/export/feedcard/IOpenFeedCell;)V", "openFeedAction", "Lcom/ss/android/lark/feed/export/feedcard/action/IOpenFeedAction;", "getOpenFeedAction", "()Lcom/ss/android/lark/feed/export/feedcard/action/IOpenFeedAction;", "setOpenFeedAction", "(Lcom/ss/android/lark/feed/export/feedcard/action/IOpenFeedAction;)V", "feedType", "Lcom/ss/android/lark/biz/im/api/FeedCard$Type;", "getFeedType", "()Lcom/ss/android/lark/biz/im/api/FeedCard$Type;", "setFeedType", "(Lcom/ss/android/lark/biz/im/api/FeedCard$Type;)V", "bizType", "Lcom/bytedance/lark/pb/feed/v1/AppFeedCardType;", "getBizType", "()Lcom/bytedance/lark/pb/feed/v1/AppFeedCardType;", "setBizType", "(Lcom/bytedance/lark/pb/feed/v1/AppFeedCardType;)V", "clickDelayJob", "Lkotlinx/coroutines/Job;", "swipeViewBinder", "Lcom/ss/android/lark/feed/shared/page/binder2/SwipeViewBinder;", "getSwipeViewBinder", "()Lcom/ss/android/lark/feed/shared/page/binder2/SwipeViewBinder;", "swipeViewBinder$delegate", "Lkotlin/Lazy;", "currentLongClickDialog", "Lcom/larksuite/component/universe_design/dialog/UDDialog;", "getCurrentLongClickDialog", "()Lcom/larksuite/component/universe_design/dialog/UDDialog;", "setCurrentLongClickDialog", "(Lcom/larksuite/component/universe_design/dialog/UDDialog;)V", "avatarSize", "teamHeight", "observer", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/lark/pb/feed/v1/FeedSlideActionSetting;", "disableDialogNoDismiss", "getDisableDialogNoDismiss", "()Z", "disableDialogNoDismiss$delegate", "fillContainer", BuildConfig.FLAVOR, "cell", "onBindViewHolder", "uiFeedCard", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "paramsFactory", "Lcom/ss/android/lark/feed/export/feedcard/IComponentParamsFactory;", "itemContainer", "Lcom/ss/android/lark/feed/shared/page/adapter/listener/IItemContainer;", "setBackground", "setLeftAndRightViewTopMargins", "topMargin", "getUiFeedCard", "()Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "setUiFeedCard", "(Lcom/ss/android/lark/feed/app/entity/UIFeedCard;)V", "manager", "Lcom/ss/android/lark/feed/shared/page/action/FeedActionManager;", "actionStatusListener", "Lcom/ss/android/lark/feed/export/feedcard/action/ActionStatusListener;", "bindAction", "delayUpdate", "addPriorityInfo", "delayBindLeftActionView", "bindSwipeAction", "delayBindRightActionView", "resetSwipeIfNeeded", "resetSwipeAction", "bindLongClick", "handleItemLongClick", "feedActionMap", "Ljava/util/LinkedHashMap;", "Lcom/ss/android/lark/feed/export/feedcard/action/FeedActionType;", "Lcom/ss/android/lark/feed/export/feedcard/action/IFeedActionFactory;", "Lkotlin/collections/LinkedHashMap;", "onViewRecycled", "onRightRemoveAction", Keys.API_RETURN_KEY_DATA, "getSwipeReactionType", "cachedSwipeListener", "Lcom/h6ah4i/android/widget/advrecyclerview/swipeable/RecyclerViewSwipeManager$OnItemSwipeEventListener;", "onSlideAmountUpdated", "horizontalAmount", BuildConfig.FLAVOR, "verticalAmount", "isSwiping", "setCachedSwipeListener", "onSwipingToLeft", "onSwipingToRight", "updateSwipeLeftAmount", "updateSwipeRightAmount", "updateLeftContainerBackground", "bgColor", "getSwipeableContainerView", "Companion", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedCommonViewHolder extends BaseFeedSwipeableViewHolder {
    public static final n M = null;
    public static final o N = null;
    public static final int O = 0;
    public FeedCard.Type A;
    public AppFeedCardType B;
    public Job C;
    public final Lazy D;
    public UDDialog E;
    public final i F;
    public final Lazy G;
    public UIFeedCard H;
    public seb.b I;
    public ueb.a J;
    public e K;
    public k L;
    public final com.ss.android.lark.feed.export.feedcard.d m;
    public final Context n;
    public long o;
    public final long p;
    public final LinearLayout q;
    public final LinearLayout r;
    public final ConstraintLayout s;
    public final RelativeLayout t;
    public final List<BaseFeedSwipeActionView> u;
    public BaseFeedSwipeActionView v;
    public boolean w;
    public boolean x;
    public com.ss.android.lark.feed.export.feedcard.h y;
    public aeb.f z;

    public static final class a {
    }

    static {
        int r0 = com.ss.android.lark.feed.shared.data.utils.c.a;
        Map r1 = com.ss.android.lark.im.base.d.a;
        M = (n) CollectionsKt.firstOrNull(com.ss.android.lark.im.base.d.c(ImExtensionType.FEED_ITEM_LAYOUT_STRATEGY, n.class));
        N = (o) CollectionsKt.firstOrNull(com.ss.android.lark.im.base.d.c(ImExtensionType.FEED_ITEM_LONG_CLICK_DIALOG, o.class));
        O = UIHelper.dp2px(32.0f);
    }

    @Override // com.ss.android.lark.feed.shared.page.binder2.BaseFeedSwipeableViewHolder
    public final int T3() {
        UIFeedCard r0 = this.H;
        if (r0 == null) goto L26;
        aeb.f r2 = this.z;
        Integer r3 = null;
        if (r2 == null) goto L23;
        ueb.a r4 = this.J;
        if (r4 == null) goto L23;
        seb.b r5 = this.I;
        if (r5 == null) goto L23;
        Intrinsics.checkNotNullParameter(r0, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r2, "feedAction");
        Intrinsics.checkNotNullParameter(r4, "itemContainer");
        List<FeedActionType> r6 = r5.c(r0, r2, r4);
        List<FeedActionType> r1 = r5.d(r0, r2, r4);
        List<FeedActionType> r7 = r6;
        if ((!r7.isEmpty()) == false) goto L16;
        if ((!r1.isEmpty()) == false) goto L16;
        int r8 = 8194;
    L22:
        r3 = Integer.valueOf(r8);
    L16:
        if ((!r7.isEmpty()) == false) goto L19;
        r8 = 2;
        goto L22
    L19:
        if ((!r1.isEmpty()) == false) goto L21;
        r8 = 8192;
        goto L22
    L21:
        r8 = 0;
    L23:
        if (r3 != null) goto L25;
        return 0;
    L25:
        return r3.intValue();
    L26:
        return 0;
    }

    public final void X3() {
        if (((ArrayList) this.u).isEmpty() == false) goto L5;
    L8:
        int r1 = 0;
        this.x = false;
        UIFeedCard r3 = this.H;
        seb.b r4 = this.I;
        ueb.a r5 = this.J;
        e r6 = this.K;
        if (r3 == null) goto L53;
        if (r4 == null) goto L53;
        if (r5 == null) goto L53;
        if (r6 == null) goto L53;
        r r7 = (r) this.D.getValue();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r3, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r4, "manager");
        Intrinsics.checkNotNullParameter(r5, "itemContainer");
        Intrinsics.checkNotNullParameter(r6, "actionStatusListener");
        aeb.f r8 = r7.b;
        if (r8 != null) goto L16;
        List r2 = CollectionsKt.emptyList();
    L50:
        if (r2.isEmpty() == false) goto L52;
        float r9 = 0.0f;
        ((AbstractSwipeableItemViewHolder) this).g = 0.0f;
    L55:
        if (this.l == true) goto L58;
        r9 = -((this.q.getMeasuredWidth() * 1.0f) / ((RecyclerView.ViewHolder) this).itemView.getWidth());
    L58:
        ((AbstractSwipeableItemViewHolder) this).g = r9;
        return;
    L52:
        r9 = 0.0f;
        ((ArrayList) this.u).addAll(r2);
        goto L55
    L16:
        List<FeedActionType> r10 = r4.c(r3, r8, r5);
        if (r10.isEmpty() == false) goto L23;
        Iterator r11 = ViewGroupKt.getChildren(r7.a).iterator();
    L20:
        if (r11.hasNext() == false) goto L22;
        ((View) r11.next()).setVisibility(8);
        goto L20
    L22:
        r2 = CollectionsKt.emptyList();
        goto L50
    L23:
        LinkedHashMap<FeedActionType, aeb.c> r12 = r4.a(r10, r8.c());
        int r13 = r10.size() - r7.a.getChildCount();
        if (r13 <= 0) goto L28;
        int r14 = 0;
    L26:
        if (r14 >= r13) goto L28;
        r7.a.addView(r7.a(), new LinearLayout.LayoutParams(-2, -1));
        r14 = r14 + 1;
    L28:
        ArrayList r15 = new ArrayList();
        int r16 = r10.size();
        int r17 = 0;
    L29:
        if (r17 >= r16) goto L42;
        View r18 = ViewGroupKt.get(r7.a, r17);
        FeedActionType r19 = (FeedActionType) ListProtector.get(r10, r17);
        if ((r18 instanceof BaseFeedSwipeActionView) == false) goto L41;
        BaseFeedSwipeActionView r110 = (BaseFeedSwipeActionView) r18;
        r110.setVisibility(r1);
        r15.add(r18);
        aeb.c r111 = r12.get(r19);
        if (r111 == null) goto L35;
        aeb.e r112 = r111.i();
    L36:
        if (r112 == null) goto L39;
        r110.a(UDIconUtils.getIconDrawable(r7.c, r112.c(r3), ContextCompat.getColor(r7.c, 2131106521)), r112.e(r3), ContextCompat.getColor(r7.c, r112.getBackground()));
    L39:
        r18.setOnClickListener(new q(r12, r19, r3, r6));
        r17 = r17 + 1;
        r15 = r15;
        r1 = 0;
        goto L29
    L35:
        r112 = null;
        goto L36
    L41:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L42:
        ArrayList r113 = r15;
        int r20 = r10.size();
        int r21 = r7.a.getChildCount();
    L43:
        if (r20 >= r21) goto L48;
        View r22 = r7.a.getChildAt(r20);
        if (r22 == null) goto L47;
        r22.setVisibility(8);
    L47:
        r20 = r20 + 1;
        goto L43
    L48:
        r7.a.measure(View.MeasureSpec.makeMeasureSpec(1073741823, PluginList.LEVEL_NOT_SET), View.MeasureSpec.makeMeasureSpec(1073741823, PluginList.LEVEL_NOT_SET));
        r2 = r113;
    L53:
        r9 = 0.0f;
        Log.w("FeedSharedModule_FeedCommonViewHolder", "swipe left feed card, but UIFeedCard is invalid.");
        goto L55
    L5:
        if (this.x == true) goto L8;
        r9 = 0.0f;
        goto L55
    }

    @Override // com.ss.android.lark.feed.shared.page.binder2.BaseFeedSwipeableViewHolder
    public final void onViewRecycled() {
        com.ss.android.lark.feed.export.feedcard.h r0 = this.y;
        if (r0 == null) goto L5;
        r0.onViewRecycled();
    L5:
        this.s.animate().cancel();
        if (this.s.getTranslationX() != 0.0f) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        this.s.setTranslationX(0.0f);
    L11:
        ((AbstractSwipeableItemViewHolder) this).e = 0.0f;
        return;
    L8:
        r1 = false;
        goto L9
    }

    public final ConstraintLayout r1() {
        return this.s;
    }

    @Override // com.ss.android.lark.feed.shared.page.binder2.BaseFeedSwipeableViewHolder
    public final void U3(UIFeedCard r4) {
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        StringBuilder r0 = new StringBuilder("onRightRemoveAction handler:");
        BaseFeedSwipeActionView r1 = this.v;
        if (r1 == null) goto L5;
        aeb.d r2 = r1.getFeedActionHandler();
    L6:
        r0.append(r2);
        r0.append(" listener:");
        r0.append(this.K);
        Log.i("FeedSharedModule_FeedCommonViewHolder", r0.toString());
        BaseFeedSwipeActionView r3 = this.v;
        if (r3 == null) goto L14;
        aeb.d r5 = r3.getFeedActionHandler();
        if (r5 == null) goto L15;
        e r6 = this.K;
        if (r6 == null) goto L16;
        r5.o(r4, FeedActionEvent.RIGHT_SWIPE_LONG, r6);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void W0(float r17) {
        if (this.L != null) goto L5;
        this.L = new k(this);
    L5:
        bw7.b r2 = this.m.d();
        if (r2 == null) goto L8;
        r2.B = this.L;
    L8:
        boolean r3 = true;
        if (this.w == true) goto L46;
        UIFeedCard r4 = this.H;
        seb.b r8 = this.I;
        ueb.a r9 = this.J;
        e r10 = this.K;
        if (r4 == null) goto L44;
        if (r8 == null) goto L44;
        if (r9 == null) goto L44;
        if (r10 == null) goto L44;
        this.w = true;
        if (this.v != null) goto L18;
        BaseFeedSwipeActionView r11 = ((r) this.D.getValue()).a();
        this.v = r11;
        this.r.addView(r11, new LinearLayout.LayoutParams(-2, -1));
    L18:
        BaseFeedSwipeActionView r12 = this.v;
        if (r12 == null) goto L46;
        r r13 = (r) this.D.getValue();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r4, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r8, "manager");
        Intrinsics.checkNotNullParameter(r9, "itemContainer");
        Intrinsics.checkNotNullParameter(r10, "actionStatusListener");
        Intrinsics.checkNotNullParameter(r12, "leftView");
        aeb.f r14 = r13.b;
        if (r14 == null) goto L46;
        List<? extends FeedActionType> r15 = CollectionsKt.toMutableList(r8.d(r4, r14, r9));
        aeb.f r16 = r13.b;
        if (r16 == null) goto L27;
        List<aeb.c> r18 = r16.c();
        if (r18 == null) goto L27;
    L29:
        if ((!r15.isEmpty()) == false) goto L31;
        aeb.c r19 = r8.a(r15, r18).get(ListProtector.get(r15, 0));
    L32:
        if (r19 == null) goto L34;
        aeb.d r20 = r19.m();
    L35:
        if (r19 == null) goto L37;
        aeb.e r21 = r19.i();
    L38:
        if (r21 == null) goto L40;
        r12.a(UDIconUtils.getIconDrawable(r13.c, r21.c(r4), ContextCompat.getColor(r13.c, 2131106521)), r21.e(r4), ContextCompat.getColor(r13.c, r21.getBackground()));
        Log.i("FeedSharedModule_FeedCommonViewHolder", "set background color:" + r21.getBackground());
    L40:
        Log.i("FeedSharedModule_FeedCommonViewHolder", "leftItem:" + r21);
        r12.setFeedActionHandler(r20);
        if (r20 == null) goto L43;
        r12.setVisibility(0);
        r12.setOnClickListener(new p(r20, r4, r10));
        goto L46
    L43:
        r12.setVisibility(8);
        goto L46
    L37:
        r21 = null;
        goto L38
    L34:
        r20 = null;
        goto L35
    L31:
        r19 = null;
    L27:
        r18 = CollectionsKt.emptyList();
    L44:
        Log.w("FeedSharedModule_FeedCommonViewHolder", "swipe right feed card, but UIFeedCard is invalid.");
    L46:
        if (this.k == false) goto L49;
        ((AbstractSwipeableItemViewHolder) this).i = 0.0f;
    L57:
        X3();
        if (r17 >= 0.0f) goto L84;
        LinearLayout r5 = this.q;
        if (r5.getVisibility() != 8) goto L62;
        boolean r6 = true;
    L63:
        if (r6 == true) goto L66;
        r5 = null;
    L66:
        if (r5 == null) goto L68;
        this.q.setVisibility(0);
    L68:
        this.r.setBackgroundColor(((RecyclerView.ViewHolder) this).itemView.getResources().getColor(2131106784));
        float r1 = r17 / ((AbstractSwipeableItemViewHolder) this).g;
        if (r1 <= 1.0f) goto L71;
        return;
    L71:
        if (r1 >= 0.0f) goto L73;
        return;
    L73:
        if (((ArrayList) this.u).size() <= 0) goto L136;
        Iterator r7 = com.larksuite.framework.utils.p.a(this.u).iterator();
        BaseFeedSwipeActionView r22 = null;
    L77:
        if (r7.hasNext() == false) goto L137;
        BaseFeedSwipeActionView r23 = (BaseFeedSwipeActionView) r7.next();
        if (r22 == null) goto L81;
        int r24 = r22.getMeasuredWidth();
    L82:
        r23.setTranslationX((r24 + r23.getMeasuredWidth()) * (1 - r1));
        r22 = r23;
        goto L77
    L81:
        r24 = 0;
        goto L82
    L137:
        return;
    L136:
        return;
    L62:
        r6 = false;
        goto L63
    L84:
        if (r17 > 0.0f) goto L86;
        return;
    L86:
        if (this.k == true) goto L134;
        LinearLayout r25 = this.q;
        if (r25.getVisibility() != 0) goto L90;
        boolean r26 = true;
    L91:
        if (r26 == true) goto L94;
        r25 = null;
    L94:
        if (r25 == null) goto L96;
        this.q.setVisibility(8);
    L96:
        LinearLayout r27 = this.r;
        if (r27.getVisibility() != 8) goto L99;
        boolean r28 = true;
    L100:
        if (r28 == true) goto L103;
        r27 = null;
    L103:
        if (r27 == null) goto L105;
        this.r.setVisibility(0);
    L105:
        BaseFeedSwipeActionView r29 = this.v;
        if (r29 == null) goto L108;
        Integer r30 = Integer.valueOf(r29.getBgColor());
    L109:
        if (r30 == null) goto L111;
        this.r.setBackgroundColor(r30.intValue());
    L112:
        float r31 = ((RecyclerView.ViewHolder) this).itemView.getMeasuredWidth() * r17;
        BaseFeedSwipeActionView r32 = this.v;
        if (r32 == null) goto L115;
        int r33 = r32.getMeasuredWidth();
    L116:
        float r34 = r31 - r33;
        UIFeedCard r35 = this.H;
        if (r35 != null) goto L119;
    L121:
        r3 = false;
    L122:
        if (r3 == false) goto L124;
        ((AbstractSwipeableItemViewHolder) this).e = r17;
    L124:
        BaseFeedSwipeActionView r36 = this.v;
        if (r36 == null) goto L135;
        r36.setTranslationX(r34);
        return;
    L135:
        return;
    L119:
        if (r35.isSwipeRightPinned() != true) goto L121;
    L115:
        r33 = 0;
        goto L116
    L111:
        Log.e("FeedSharedModule_FeedCommonViewHolder", "updateLeftContainerBackground failed, bgColor:" + r30);
        goto L112
    L108:
        r30 = null;
        goto L109
    L99:
        r28 = false;
        goto L100
    L90:
        r26 = false;
        goto L91
    L134:
        return;
    L49:
        if (this.l == false) goto L51;
        float r37 = 2.3148148f;
    L56:
        ((AbstractSwipeableItemViewHolder) this).i = r37;
        goto L57
    L51:
        BaseFeedSwipeActionView r38 = this.v;
        if (r38 == null) goto L54;
        int r39 = r38.getMeasuredWidth();
    L55:
        r37 = (r39 * 1.0f) / ((RecyclerView.ViewHolder) this).itemView.getWidth();
        goto L56
    L54:
        r39 = 0;
        goto L55
    }

    public final void W3(int r5) {
        ViewGroup.LayoutParams r0 = this.r.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        if (r1.topMargin == r5) goto L5;
        r1.setMargins(0, r5, 0, 0);
        this.r.setLayoutParams(r1);
    L5:
        ViewGroup.LayoutParams r2 = this.q.getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
        if (r3.topMargin == r5) goto L9;
        r3.setMargins(0, r5, 0, 0);
        this.q.setLayoutParams(r3);
        return;
    }

    public FeedCommonViewHolder(View r3, yeb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "feedCardContext");
        super(r3);
        this.m = r4;
        r3.addOnAttachStateChangeListener(new c(this, r3));
        Context r5 = r3.getContext();
        this.n = r5;
        this.p = 500;
        this.q = (LinearLayout) r3.findViewById(2131384566);
        this.r = (LinearLayout) r3.findViewById(2131377754);
        this.s = r3.findViewById(2131367862);
        this.t = (RelativeLayout) r3.findViewById(2131384702);
        this.u = new ArrayList();
        this.A = FeedCard.Type.UNKNOWN;
        this.B = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
        this.D = LazyKt.lazy(new FeedCommonViewHolder$swipeViewBinder$2(this));
        zz7.b.g(r5, 48);
        zz7.b.g(r5, 20);
        this.F = new i(this);
        this.G = LazyKt.lazy(LazyThreadSafetyMode.NONE, FeedCommonViewHolder$disableDialogNoDismiss$2.INSTANCE);
    }

    public final void V3(UIFeedCard r6, ueb.a r7) {
        Intrinsics.checkNotNullParameter(r6, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r7, "itemContainer");
        if (neb.e.a(r6) == false) goto L8;
        this.t.setVisibility(0);
        W3(O);
        n r0 = M;
        if (r0 == null) goto L7;
        RelativeLayout r2 = this.t;
        r0.a();
        r2.setBackgroundResource(2131235442);
    L10:
        if (com.ss.android.lark.feed.shared.fg.c.b(this.m.getHost().getActivity()) == false) goto L15;
        if (Intrinsics.areEqual(jeb.b.a().q3(), r6.getId()) == false) goto L15;
        this.s.setBackgroundResource(2131231972);
        return;
    L15:
        if (r7.y() == true) goto L17;
    L22:
        n r8 = M;
        if (r8 == null) goto L25;
        ConstraintLayout r9 = this.s;
        r8.c();
        r9.setBackgroundResource(2131235435);
        return;
    L25:
        Log.e("FeedSharedModule_FeedCommonViewHolder", "set feed background failed, layoutStrategy is null");
        return;
    L17:
        if (com.ss.android.lark.feed.shared.page.utils.d.a(r6) == false) goto L22;
        n r10 = M;
        if (r10 == null) goto L21;
        ConstraintLayout r11 = this.s;
        r10.a();
        r11.setBackgroundResource(2131235442);
        return;
    L21:
        Log.e("FeedSharedModule_FeedCommonViewHolder", "set top feed background failed, layoutStrategy is null");
        return;
    L7:
        Log.e("FeedSharedModule_FeedCommonViewHolder", "set priority item background failed, layoutStrategy is null");
        goto L10
    L8:
        this.t.setVisibility(8);
        W3(0);
        goto L10
    }
}
