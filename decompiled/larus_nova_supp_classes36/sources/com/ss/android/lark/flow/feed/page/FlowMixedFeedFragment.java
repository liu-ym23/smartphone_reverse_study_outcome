package com.ss.android.lark.flow.feed.page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import com.bytedance.lark.rustclient.api.l;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemWrapperAdapter;
import com.larksuite.arch.jack.JackView;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.arch.jack.i;
import com.larksuite.arch.jack.j;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.g;
import com.ss.android.lark.feed.export.feedcard.h;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.databinding.FragmentRefactorFeedListBinding;
import com.ss.android.lark.feed.shared.page.FeedRecyclerView;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;
import com.ss.android.lark.feed.shared.page.binder2.FeedCommonViewHolder;
import com.ss.android.lark.feed.shared.page.date.FeedDateTickObserver;
import com.ss.android.lark.feed.shared.page.experiment.FeedCallbackExecutor;
import com.ss.android.lark.feed.shared.page.k;
import com.ss.android.lark.feed.shared.page.listener.FeedItemScrollListener;
import com.ss.android.lark.feed.shared.page.p;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.flow.feed.base.MixedFeedDataController;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.integrator.im.feed_shared.dependency.f;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000à\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0010`i\u008c\u0001\u0095\u0001\u009a\u0001\u009f\u0001¤\u0001©\u0001®\u0001\u0018\u0000 Å\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Å\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020\b2\u0006\u0010r\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010s\u001a\u00020p2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J&\u0010v\u001a\u0004\u0018\u00010w2\u0006\u0010x\u001a\u00020y2\b\u0010z\u001a\u0004\u0018\u00010{2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J\u001a\u0010|\u001a\u00020p2\u0006\u0010}\u001a\u00020w2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J\b\u0010~\u001a\u00020pH\u0016J\b\u0010\u007f\u001a\u00020pH\u0016J\t\u0010\u0080\u0001\u001a\u00020pH\u0016J\t\u0010\u0081\u0001\u001a\u00020pH\u0016J\t\u0010\u0082\u0001\u001a\u00020pH\u0002J\t\u0010\u0083\u0001\u001a\u00020pH\u0002J\t\u0010\u0084\u0001\u001a\u00020%H\u0002J\u001d\u0010\u0085\u0001\u001a\f\u0012\u0005\u0012\u00030\u0087\u0001\u0018\u00010\u0086\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002J\f\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0002J\u001d\u0010\u0090\u0001\u001a\u00020p2\b\u0010\u0091\u0001\u001a\u00030\u0087\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0002J\t\u0010·\u0001\u001a\u00020pH\u0002J\u001c\u0010¸\u0001\u001a\u00030¹\u00012\u0007\u0010º\u0001\u001a\u0002022\u0007\u0010»\u0001\u001a\u000202H\u0002J\u001a\u0010¼\u0001\u001a\u00020p2\u000f\u0010½\u0001\u001a\n\u0012\u0005\u0012\u00030\u0087\u00010\u0086\u0001H\u0016J\f\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u0001H\u0016J\t\u0010À\u0001\u001a\u00020pH\u0016J\u001c\u0010Á\u0001\u001a\u00020p2\u0007\u0010Â\u0001\u001a\u0002042\b\u0010Ã\u0001\u001a\u00030Ä\u0001H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR#\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0012\u0010\rR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000f\u001a\u0004\b(\u0010)R'\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u000f\u001a\u0004\b.\u0010/R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u000f\u001a\u0004\b;\u0010<R\u001b\u0010>\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u000f\u001a\u0004\b@\u0010AR!\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u000f\u001a\u0004\bF\u0010GR\u001b\u0010I\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u000f\u001a\u0004\bK\u0010LR\u001b\u0010N\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u000f\u001a\u0004\bP\u0010QR\u001b\u0010S\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\u000f\u001a\u0004\bU\u0010VR!\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00110Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u000f\u001a\u0004\bZ\u0010[R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010_\u001a\u00020`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\u000f\u001a\u0004\ba\u0010bR\u001b\u0010d\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010\u000f\u001a\u0004\be\u0010fR\u0010\u0010h\u001a\u00020iX\u0082\u0004¢\u0006\u0004\n\u0002\u0010jR\u0014\u0010k\u001a\u00020lX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010nR \u0010\u008b\u0001\u001a\u00030\u008c\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008f\u0001\u0010\u000f\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R \u0010\u0094\u0001\u001a\u00030\u0095\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0098\u0001\u0010\u000f\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R \u0010\u0099\u0001\u001a\u00030\u009a\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009d\u0001\u0010\u000f\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R \u0010\u009e\u0001\u001a\u00030\u009f\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¢\u0001\u0010\u000f\u001a\u0006\b \u0001\u0010¡\u0001R \u0010£\u0001\u001a\u00030¤\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b§\u0001\u0010\u000f\u001a\u0006\b¥\u0001\u0010¦\u0001R \u0010¨\u0001\u001a\u00030©\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¬\u0001\u0010\u000f\u001a\u0006\bª\u0001\u0010«\u0001R \u0010\u00ad\u0001\u001a\u00030®\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b±\u0001\u0010\u000f\u001a\u0006\b¯\u0001\u0010°\u0001R \u0010²\u0001\u001a\u00030³\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¶\u0001\u0010\u000f\u001a\u0006\b´\u0001\u0010µ\u0001¨\u0006Æ\u0001"}, d2 = {"Lcom/ss/android/lark/flow/feed/page/FlowMixedFeedFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/lark/feed/export/mixed/IMixedFeedAbility;", "Lcom/larksuite/arch/jack/JackView;", "Lcom/ss/android/lark/feed/shared/page/swipe/ISwipeReseter;", "<init>", "()V", "mixedFeedDataSource", "Lcom/ss/android/lark/flow/feed/base/user/IFeedUserDataSource;", "rustClientHolder", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/bytedance/lark/rustclient/api/IRustClient;", "getRustClientHolder", "()Ljava/util/concurrent/atomic/AtomicReference;", "rustClientHolder$delegate", "Lkotlin/Lazy;", "viewModelHolder", "Lcom/ss/android/lark/feed/shared/page/IFeedItemsViewModel;", "getViewModelHolder", "viewModelHolder$delegate", "currentFilter", "Lcom/ss/android/lark/feed/app/entity/FeedFolder;", "localCache", "Lcom/ss/android/lark/feed/molten/cache/IFeedItemsMoltenLocalCache;", "_binding", "Lcom/ss/android/lark/feed/shared/databinding/FragmentRefactorFeedListBinding;", "wrappedAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "mixedFeedCallback", "Lcom/ss/android/lark/feed/export/mixed/IMixedFeedCallback;", "getMixedFeedCallback$flow_feed_productionChinaRelease", "()Lcom/ss/android/lark/feed/export/mixed/IMixedFeedCallback;", "setMixedFeedCallback$flow_feed_productionChinaRelease", "(Lcom/ss/android/lark/feed/export/mixed/IMixedFeedCallback;)V", "feedPageStatusView", "Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView;", "mDataContainerInit", "Lcom/ss/android/lark/feed/shared/page/FeedItemsViewInit;", "swipeActionStatusHandler", "Lcom/ss/android/lark/feed/shared/page/swipe/SwipeActionStatusHandler;", "getSwipeActionStatusHandler", "()Lcom/ss/android/lark/feed/shared/page/swipe/SwipeActionStatusHandler;", "swipeActionStatusHandler$delegate", "mLastVisibleFirstEndPosition", "Lkotlin/Pair;", "Ljava/util/concurrent/atomic/AtomicInteger;", "getMLastVisibleFirstEndPosition", "()Lkotlin/Pair;", "mLastVisibleFirstEndPosition$delegate", "isListScrollingScene", "", "bufferCount", "", "mLastUpdateRecord", "Lcom/ss/android/lark/feed/shared/data/UpdateRecord;", "wasAtTopBeforeDiff", "mDisableTouch", "unreadScrollHelper", "Lcom/ss/android/lark/feed/shared/page/unread/UnreadScrollHelper;", "getUnreadScrollHelper", "()Lcom/ss/android/lark/feed/shared/page/unread/UnreadScrollHelper;", "unreadScrollHelper$delegate", "swipeManager", "Lcom/h6ah4i/android/widget/advrecyclerview/swipeable/RecyclerViewSwipeManager;", "getSwipeManager", "()Lcom/h6ah4i/android/widget/advrecyclerview/swipeable/RecyclerViewSwipeManager;", "swipeManager$delegate", "wrapper", "Lcom/ss/android/lark/feed/shared/openfeed/card/OpenFeedCardWrapper;", "Lcom/ss/android/lark/feed/export/feedcard/IFeedCardFactory;", "getWrapper", "()Lcom/ss/android/lark/feed/shared/openfeed/card/OpenFeedCardWrapper;", "wrapper$delegate", "feedAdapter", "Lcom/ss/android/lark/feed/shared/page/adapter/LarkFeedInBoxListAdapter;", "getFeedAdapter", "()Lcom/ss/android/lark/feed/shared/page/adapter/LarkFeedInBoxListAdapter;", "feedAdapter$delegate", "resetCurrentSwipeItemRunnable", "Ljava/lang/Runnable;", "getResetCurrentSwipeItemRunnable", "()Ljava/lang/Runnable;", "resetCurrentSwipeItemRunnable$delegate", "dateTickObserver", "Lcom/ss/android/lark/feed/shared/page/date/FeedDateTickObserver;", "getDateTickObserver", "()Lcom/ss/android/lark/feed/shared/page/date/FeedDateTickObserver;", "dateTickObserver$delegate", "dataController", "Lcom/ss/android/lark/flow/feed/base/MixedFeedDataController;", "getDataController", "()Lcom/ss/android/lark/flow/feed/base/MixedFeedDataController;", "dataController$delegate", "currentUserId", "", "dataDelegate", "com/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$dataDelegate$2$1", "getDataDelegate", "()Lcom/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$dataDelegate$2$1;", "dataDelegate$delegate", "disableDialogNoDismiss", "getDisableDialogNoDismiss", "()Z", "disableDialogNoDismiss$delegate", "feedCardContext", "com/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$feedCardContext$1", "Lcom/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$feedCardContext$1;", "lifecycleOwnerHolder", "Lcom/larksuite/arch/jack/LifecycleOwnerHolder;", "getLifecycleOwnerHolder", "()Lcom/larksuite/arch/jack/LifecycleOwnerHolder;", "bind", "", "dataSource", "callback", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "recoverRecentInboxItemPosition", "resetCurrentSwipeItem", "notifyDataSetChanged", "initFeedListView", "initFeedBackgroundStatusView", "getDataContainerInit", "getCurrentPageShowedItems", "", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getNextUnreadFeedItem", "feedActionDependency", "com/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$feedActionDependency$2$1", "getFeedActionDependency", "()Lcom/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$feedActionDependency$2$1;", "feedActionDependency$delegate", "onDoneAction", "data", "actionStatus", "Lcom/ss/android/lark/feed/export/feedcard/action/FeedActionStatus;", "feedItemListener", "com/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$feedItemListener$2$1", "getFeedItemListener", "()Lcom/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$feedItemListener$2$1;", "feedItemListener$delegate", "rvInboxTouchListener", "com/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$rvInboxTouchListener$2$1", "getRvInboxTouchListener", "()Lcom/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$rvInboxTouchListener$2$1;", "rvInboxTouchListener$delegate", "rvInboxPreDrawListener", "com/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$rvInboxPreDrawListener$2$1", "getRvInboxPreDrawListener", "()Lcom/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$rvInboxPreDrawListener$2$1;", "rvInboxPreDrawListener$delegate", "attachStateListener", "com/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$attachStateListener$2$1", "getAttachStateListener", "()Lcom/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$attachStateListener$2$1;", "attachStateListener$delegate", "mUnreadScrollListener", "com/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$mUnreadScrollListener$2$1", "getMUnreadScrollListener", "()Lcom/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$mUnreadScrollListener$2$1;", "mUnreadScrollListener$delegate", "mOnScrollListener", "com/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$mOnScrollListener$2$1", "getMOnScrollListener", "()Lcom/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$mOnScrollListener$2$1;", "mOnScrollListener$delegate", "itemsScrollListenerV2", "Lcom/ss/android/lark/feed/shared/page/listener/FeedItemScrollListener;", "getItemsScrollListenerV2", "()Lcom/ss/android/lark/feed/shared/page/listener/FeedItemScrollListener;", "itemsScrollListenerV2$delegate", "attachUserReadyListeners", "getFeedPageStatus", "Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView$FeedPageStatus;", "isLoading", "isEmpty", "setLocalConversationData", "conversationData", "getFeedRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "scrollToNextUnreadFeed", "reportShowCellHitPoint", "position", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Companion", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowMixedFeedFragment extends Fragment implements deb.a, JackView, dfb.d {
    public static final cfb.a N = null;
    public String A;
    public final Lazy B;
    public final Lazy C;
    public final c D;
    public final e E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public final Lazy M;
    public chb.a d;
    public final Lazy e;
    public final Lazy f;
    public final FeedFolder g;
    public com.ss.android.lark.feed.molten.cache.b h;
    public FragmentRefactorFeedListBinding i;
    public SwipeableItemWrapperAdapter j;
    public deb.b k;
    public k l;
    public final Lazy m;
    public final Lazy n;
    public boolean o;
    public final int p;
    public UpdateRecord q;
    public boolean r;
    public boolean s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FeedActionStatus.values().length];
            r0[FeedActionStatus.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FeedActionStatus.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements com.ss.android.lark.feed.export.feedcard.d {
        public final /* synthetic */ FlowMixedFeedFragment a;

        public final g a() {
            return null;
        }

        public final deb.d b() {
            return null;
        }

        public final s e() {
            return null;
        }

        public final s c() {
            FlowMixedFeedFragment r0 = this.a;
            cfb.a r1 = FlowMixedFeedFragment.N;
            return r0.Y90().get();
        }

        public final bw7.b d() {
            FlowMixedFeedFragment r0 = this.a;
            cfb.a r1 = FlowMixedFeedFragment.N;
            return r0.X90();
        }

        public final FeedFolder f() {
            return this.a.g;
        }

        public final l g() {
            FlowMixedFeedFragment r0 = this.a;
            cfb.a r1 = FlowMixedFeedFragment.N;
            return (l) ((AtomicReference) r0.e.getValue()).get();
        }

        public final Fragment getHost() {
            return this.a;
        }

        public c(FlowMixedFeedFragment r1) {
            this.a = r1;
        }
    }

    public static final class d implements k.b {
        public final /* synthetic */ FlowMixedFeedFragment a;

        public final void a() {
            this.a.So();
        }

        public final void b() {
            this.a.s = false;
        }

        public final void c() {
            this.a.s = true;
        }

        public d(FlowMixedFeedFragment r1) {
            this.a = r1;
        }
    }

    public static final class e implements i {
        public final /* synthetic */ FlowMixedFeedFragment a;

        public final LifecycleOwner getLifecycleOwner() {
            return this.a.getViewLifecycleOwner();
        }

        public e(FlowMixedFeedFragment r1) {
            this.a = r1;
        }
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this;
    }

    static {
        Map<ImExtensionType, List<Class<?>>> r0 = com.ss.android.lark.im.base.d.a;
        N = (cfb.a) CollectionsKt.lastOrNull(com.ss.android.lark.im.base.d.b(ImExtensionType.FEED_BACKGROUND_STATUS_VIEW, cfb.a.class));
    }

    public final k U90() {
        k r0 = this.l;
        FeedRecyclerView r1 = null;
        if (r0 != null) goto L9;
        Context r3 = requireContext();
        FragmentRefactorFeedListBinding r2 = this.i;
        if (r2 == null) goto L7;
        FeedRecyclerView r4 = r2.b;
    L8:
        r0 = new k(r3, r4, W90(), this.j, new d(this));
        this.l = r0;
        goto L9
    L7:
        r4 = null;
    L9:
        FragmentRefactorFeedListBinding r5 = this.i;
        if (r5 == null) goto L12;
        r1 = r5.b;
    L12:
        if (r1 != null) goto L14;
    L16:
        return r0;
    L14:
        if (r0.b != null) goto L16;
        r0.b = r1;
        goto L16
    }

    public final MixedFeedDataController<s> V90() {
        return (MixedFeedDataController) this.z.getValue();
    }

    public final LarkFeedInBoxListAdapter W90() {
        return (LarkFeedInBoxListAdapter) this.w.getValue();
    }

    public final bw7.b X90() {
        return (bw7.b) this.u.getValue();
    }

    public final AtomicReference<s> Y90() {
        return (AtomicReference) this.f.getValue();
    }

    public final void kl() {
        s r1 = Y90().get();
        if (r1 != null) goto L6;
        com.ss.android.lark.flow.feed.utils.b.d("FlowMixedFeedFragment", "scrollToNextUnreadFeed ignored: user init not ready");
        return;
    L6:
        efb.a r2 = (efb.a) this.t.getValue();
        FlowMixedFeedFragment$mUnreadScrollListener$2.a r3 = (FlowMixedFeedFragment$mUnreadScrollListener$2.a) this.K.getValue();
        Boolean r4 = Boolean.FALSE;
        if (r2.a.getItemCount() != 0) goto L9;
        ((f) heb.a.a.getFeedDependency()).getClass();
        FeedFolderCompat.INSTANCE.getMESSAGE();
        r3.getClass();
    L11:
        UIFeedCard r5 = null;
    L52:
        k r6 = this.l;
        if (r6 == null) goto L55;
        StableLinearLayoutManager r7 = r6.h;
    L56:
        if (r7 == null) goto L60;
        List<UIFeedCard> r8 = T90(r7);
        if (CollectionUtils.isEmpty(r8) == true) goto L60;
        r1.onItemsShowed(-1, r8, false);
    L60:
        r1.showNextUnreadFeedItem(r5);
        return;
    L55:
        r7 = null;
        goto L56
    L9:
        LinearLayoutManager r9 = r2.b.getLayoutManager();
        int r10 = r9.findFirstVisibleItemPosition();
        if (r10 == (-1)) goto L11;
        int r11 = r9.findLastCompletelyVisibleItemPosition();
        int r12 = r2.a.getItemCount();
        r3.getClass();
        int r13 = r10;
        int r14 = 0;
    L13:
        if (r13 >= r11) goto L21;
        View r15 = r9.findViewByPosition(r13);
        int r16 = r15.getHeight();
        if (r15.getTop() >= 0) goto L17;
        r16 = r16 + r15.getTop();
    L17:
        r14 = r14 - r16;
        if (r14 < 0) goto L19;
        r13 = r13 + 1;
        goto L13
    L19:
        r10 = r13;
    L21:
        int r17 = r10 + 1;
        int r18 = -1;
        int r19 = -1;
    L22:
        boolean r110 = true;
        if (r17 >= ((r10 + r12) + 1)) goto L39;
        int r111 = r17 % r12;
        ieb.a r112 = (UIFeedCard) r2.a.getItem(r111);
        if ((r112 instanceof ieb.a) == false) goto L38;
        int r20 = r112.getJumpPriority();
        if (r20 == 2) goto L30;
        if (r20 != 1) goto L38;
        if (r18 != (-1)) goto L38;
        r18 = r111;
        goto L38
    L30:
        if (r11 != (r12 - 1)) goto L34;
        if (r111 <= r10) goto L34;
        if (r111 > r11) goto L34;
        r19 = r111;
    L34:
        r19 = r111;
    L38:
        r17 = r17 + 1;
    L39:
        if (r19 != (-1)) goto L43;
        if (r18 != (-1)) goto L44;
        boolean r21 = true;
        r18 = 0;
    L45:
        peb.b r22 = heb.a.a;
        r22.getFeedDependency().getClass();
        r22.getFeedDependency().getClass();
        Log.i("UnreadScrollHelper", "scrollToNextUnReadChat, findNothing=" + r21 + ", findPosition=" + r18 + ", navMuteBadgeState=" + r4 + ", totalCount=0, muteTotalCount=0");
        if (((ArrayList) r2.c).contains(Integer.valueOf(r18)) == true) goto L48;
        ((ArrayList) r2.c).add(Integer.valueOf(r18));
        r110 = false;
    L49:
        if (r110 == false) goto L51;
        ((f) r22.getFeedDependency()).getClass();
        FeedFolderCompat.INSTANCE.getMESSAGE();
    L51:
        r2.a.C2(r18, 0);
        r5 = (UIFeedCard) r2.a.getItem(r18);
        goto L52
    L48:
        ((ArrayList) r2.c).clear();
    L44:
        r21 = false;
        goto L45
    L43:
        r18 = r19;
        goto L44
    }

    public final FeedRecyclerView o80() {
        FragmentRefactorFeedListBinding r0 = this.i;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public FlowMixedFeedFragment() {
        this.e = LazyKt.lazy(FlowMixedFeedFragment$rustClientHolder$2.INSTANCE);
        this.f = LazyKt.lazy(FlowMixedFeedFragment$viewModelHolder$2.INSTANCE);
        this.g = FeedFolderCompat.INSTANCE.getMESSAGE();
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.m = LazyKt.lazy(r0, new FlowMixedFeedFragment$swipeActionStatusHandler$2(this));
        this.n = LazyKt.lazy(FlowMixedFeedFragment$mLastVisibleFirstEndPosition$2.INSTANCE);
        this.p = 20;
        this.t = LazyKt.lazy(new FlowMixedFeedFragment$unreadScrollHelper$2(this));
        this.u = LazyKt.lazy(FlowMixedFeedFragment$swipeManager$2.INSTANCE);
        this.v = LazyKt.lazy(FlowMixedFeedFragment$wrapper$2.INSTANCE);
        this.w = LazyKt.lazy(new FlowMixedFeedFragment$feedAdapter$2(this));
        this.x = LazyKt.lazy(new FlowMixedFeedFragment$resetCurrentSwipeItemRunnable$2(this));
        this.y = LazyKt.lazy(new FlowMixedFeedFragment$dateTickObserver$2(this));
        this.z = LazyKt.lazy(new FlowMixedFeedFragment$dataController$2(this));
        this.B = LazyKt.lazy(new FlowMixedFeedFragment$dataDelegate$2(this));
        this.C = LazyKt.lazy(r0, FlowMixedFeedFragment$disableDialogNoDismiss$2.INSTANCE);
        this.D = new c(this);
        this.E = new e(this);
        this.F = LazyKt.lazy(new FlowMixedFeedFragment$feedActionDependency$2(this));
        this.G = LazyKt.lazy(r0, new FlowMixedFeedFragment$feedItemListener$2(this));
        this.H = LazyKt.lazy(new FlowMixedFeedFragment$rvInboxTouchListener$2(this));
        this.I = LazyKt.lazy(new FlowMixedFeedFragment$rvInboxPreDrawListener$2(this));
        this.J = LazyKt.lazy(new FlowMixedFeedFragment$attachStateListener$2(this));
        this.K = LazyKt.lazy(FlowMixedFeedFragment$mUnreadScrollListener$2.INSTANCE);
        this.L = LazyKt.lazy(new FlowMixedFeedFragment$mOnScrollListener$2(this));
        this.M = LazyKt.lazy(r0, new FlowMixedFeedFragment$itemsScrollListenerV2$2(this));
    }

    public final void So() {
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L12;
        SwipeableItemWrapperAdapter r0 = this.j;
        if ((r0 instanceof SwipeableItemWrapperAdapter) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L14;
        bw7.f r1 = r0.f;
        if (r1 == null) goto L15;
        r1.z0(0.0f);
        return;
    L15:
        return;
    L14:
        return;
    L12:
        com.ss.android.lark.flow.feed.utils.b.b("FlowMixedFeedFragment", "recoverRecentInboxItemPosition currentState is under created");
    }

    public final void cH() {
        W90().I2();
    }

    public final void onDestroyView() {
        V90().T();
        V90().release();
        ((AtomicReference) this.e.getValue()).set(null);
        Y90().set(null);
        W90().I2();
        FragmentRefactorFeedListBinding r0 = this.i;
        if (r0 == null) goto L7;
        FeedRecyclerView r1 = r0.b;
        if (r1 == null) goto L7;
        r1.removeOnScrollListener((FeedItemScrollListener) this.M.getValue());
    L7:
        FragmentRefactorFeedListBinding r2 = this.i;
        if (r2 == null) goto L12;
        FeedRecyclerView r3 = r2.b;
        if (r3 == null) goto L12;
        r3.removeOnScrollListener((FlowMixedFeedFragment$mOnScrollListener$2.AnonymousClass1) this.L.getValue());
    L12:
        FragmentRefactorFeedListBinding r4 = this.i;
        if (r4 == null) goto L17;
        FeedRecyclerView r5 = r4.b;
        if (r5 == null) goto L17;
        r5.removeOnAttachStateChangeListener((FlowMixedFeedFragment$attachStateListener$2.a) this.J.getValue());
    L17:
        FeedCallbackExecutor.a.getClass();
        FeedCallbackExecutor.b();
        k r6 = this.l;
        if (r6 == null) goto L20;
        peb.a r7 = heb.a.a.getFeedDependency();
        p r8 = r6.i;
        ((f) r7).getClass();
        Intrinsics.checkNotNullParameter(r8, "shortcutStatusListener");
    L20:
        this.l = null;
        W90().F2();
        this.j = null;
        X90().l();
        s r9 = Y90().get();
        if (r9 == null) goto L23;
        r9.pauseDataChange();
    L23:
        this.i = null;
        super.onDestroyView();
    }

    public final i getLifecycleOwnerHolder() {
        return this.E;
    }

    public static final dfb.e S90(FlowMixedFeedFragment r0) {
        return (dfb.e) r0.m.getValue();
    }

    public final void Q(List<? extends UIFeedCard> r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationData");
        V90().Q(r2);
    }

    public final List<UIFeedCard> T90(LinearLayoutManager r4) {
        StableLinearLayoutManager r5 = (StableLinearLayoutManager) r4;
        List r6 = xeb.a.b((AtomicInteger) ((Pair) this.n.getValue()).getFirst(), (AtomicInteger) ((Pair) this.n.getValue()).getSecond(), r5, W90());
        if (r6 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.take(r6, 12);
    }

    public final void Y7(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        if ((r2 instanceof FeedCommonViewHolder) == false) goto L5;
        FeedCommonViewHolder r3 = (FeedCommonViewHolder) r2;
    L6:
        if (r3 == null) goto L11;
        h r4 = r3.y;
        if (r4 == null) goto L12;
        r4.c();
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        getLifecycle().addObserver((FeedDateTickObserver) this.y.getValue());
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        SwipeableItemWrapperAdapter r7 = X90().f(W90());
        r7.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY);
        this.j = r7;
        ViewConfiguration r8 = ViewConfiguration.get(requireContext());
        bw7.b r9 = X90();
        r9.k = Math.max(r8.getScaledTouchSlop() * 40, r9.h);
        FragmentRefactorFeedListBinding r10 = this.i;
        if (r10 == null) goto L12;
        FeedRecyclerView r11 = r10.b;
        if (r11 == null) goto L13;
        r11.setWillNotDraw(false);
        r11.setHasFixedSize(true);
        r11.setMotionEventSplittingEnabled(false);
        r11.r(MapsKt.mapOf(new Pair[]{TuplesKt.to("biz", Integer.valueOf(Biz.Messenger.getValue())), TuplesKt.to("scene", Integer.valueOf(Scene.Feed.getValue()))}));
        FeedCallbackExecutor.a.getClass();
        FeedCallbackExecutor.a(r11);
        k r12 = U90();
        r12.b(null);
        r12.a((FlowMixedFeedFragment$feedItemListener$2.a) this.G.getValue());
        X90().c(r11);
        r11.t();
        W90().r = new com.ss.android.lark.flow.feed.page.b(r11);
        ((FeedListAdapter) W90()).l = new com.ss.android.lark.flow.feed.page.c(this, r11);
        W90().getClass();
        r11.setOnTouchListener((FlowMixedFeedFragment$rvInboxTouchListener$2.a) this.H.getValue());
        if (((Boolean) this.C.getValue()).booleanValue() == false) goto L10;
        r11.setOnSizeChangedListener(new FlowMixedFeedFragment$initFeedListView$7(this));
    L10:
        ((FeedListAdapter) W90()).m = new com.ss.android.lark.flow.feed.page.d(this);
        ((FeedListAdapter) W90()).k = new seb.b((FlowMixedFeedFragment$feedActionDependency$2.a) this.F.getValue(), this.D);
        return;
    L13:
        return;
    }

    public final <S extends j> com.larksuite.arch.jack.c nH(JackViewModel<S> r1, com.larksuite.arch.jack.l<S> r2, Function1<? super S, Unit> r3) {
        return JackView.a.d(this, r1, r2, r3);
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        FragmentRefactorFeedListBinding r4 = FragmentRefactorFeedListBinding.a(r1, r2);
        this.i = r4;
        return r4.a;
    }

    public final com.larksuite.arch.jack.c Ik(JackViewModel r1, PropertyReference1Impl r2, com.larksuite.arch.jack.l r3, Function1 r4) {
        return JackView.a.a(this, r1, r2, r3, r4);
    }

    public final com.larksuite.arch.jack.c Ki(JackViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, com.larksuite.arch.jack.l r4, Function1 r5) {
        return JackView.a.b(this, r1, r2, r3, r4, r5);
    }

    public final com.larksuite.arch.jack.c O60(FilePickerViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, PropertyReference1Impl r4, com.larksuite.arch.jack.l r5, Function1 r6) {
        return JackView.a.c(this, r1, r2, r3, r4, r5, r6);
    }
}
