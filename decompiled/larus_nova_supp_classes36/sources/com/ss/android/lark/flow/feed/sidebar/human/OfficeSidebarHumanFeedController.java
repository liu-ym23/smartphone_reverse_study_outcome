package com.ss.android.lark.flow.feed.sidebar.human;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.bytedance.lark.rustclient.api.l;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.arch.jack.f;
import com.larksuite.arch.jack.i;
import com.larksuite.arch.jack.j;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.home.impl.main.side_bar.view.group.datasource.lark.p;
import com.larus.home.impl.main.side_bar.view.group.datasource.lark.r;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.h;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.flow.feed.sidebar.view.FeedSidebarCommonViewHolder;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u008a\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u008a\u0001\u008b\u0001\u008c\u0001B7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010O\u001a\u00020DH\u0002J\u0016\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u000201H\u0096@¢\u0006\u0002\u0010SJ\u0016\u0010T\u001a\u00020Q2\u0006\u0010U\u001a\u000201H\u0096@¢\u0006\u0002\u0010SJ\u0010\u0010V\u001a\u00020D2\u0006\u0010W\u001a\u00020\u0014H\u0016J\u0010\u0010X\u001a\u00020D2\u0006\u0010W\u001a\u00020\u0014H\u0016J\u0010\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0016J\u0018\u0010]\u001a\u00020+2\u0006\u0010^\u001a\u00020Z2\u0006\u0010_\u001a\u00020\u0017H\u0016J\u0010\u0010`\u001a\u00020D2\u0006\u0010^\u001a\u00020ZH\u0016J\u0010\u0010a\u001a\u00020D2\u0006\u0010_\u001a\u00020\u0017H\u0016J\b\u0010b\u001a\u00020DH\u0016J\u0018\u0010c\u001a\u00020D2\u0006\u0010^\u001a\u00020Z2\u0006\u0010_\u001a\u00020\u0017H\u0016J\b\u0010d\u001a\u00020DH\u0016J\b\u0010e\u001a\u00020DH\u0002J\b\u0010f\u001a\u00020DH\u0002J\u0010\u0010g\u001a\u00020D2\u0006\u0010h\u001a\u00020&H\u0002J\u0010\u0010i\u001a\u00020D2\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010l\u001a\u00020+2\u0006\u0010j\u001a\u00020kH\u0002J\u001e\u0010m\u001a\u00020+2\u0006\u0010j\u001a\u00020k2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00180)H\u0002J\u0010\u0010o\u001a\u00020+2\u0006\u0010p\u001a\u00020\u0018H\u0002J\b\u0010q\u001a\u00020DH\u0002J\u0010\u0010r\u001a\u00020+2\u0006\u0010s\u001a\u00020\u001cH\u0002J\u0010\u0010t\u001a\u00020D2\u0006\u0010s\u001a\u00020\u001cH\u0002J\u001e\u0010u\u001a\u00020Q2\u0006\u0010s\u001a\u00020\u001c2\u0006\u0010v\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010wJ\u0010\u0010x\u001a\u00020Q2\u0006\u0010s\u001a\u00020\u001cH\u0002J\u000e\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00180)H\u0002J\u0016\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00180)2\u0006\u0010s\u001a\u00020\u001cH\u0002J\b\u0010{\u001a\u00020+H\u0002J\b\u0010|\u001a\u00020DH\u0002J'\u0010}\u001a\u00020D2\f\u0010~\u001a\b\u0012\u0004\u0012\u00020\u007f0)2\u000f\b\u0002\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170)H\u0002J\u0011\u0010\u0081\u0001\u001a\u00020D2\u0006\u0010p\u001a\u00020\u0018H\u0002J\u001a\u0010\u0082\u0001\u001a\u00020D2\u0006\u0010v\u001a\u00020\u00172\u0007\u0010\u0083\u0001\u001a\u00020QH\u0002J\t\u0010\u0084\u0001\u001a\u00020DH\u0002J\t\u0010\u0085\u0001\u001a\u00020DH\u0002J\t\u0010\u0086\u0001\u001a\u00020DH\u0002J,\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0)2\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180)2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00180)H\u0002J\r\u0010\u0089\u0001\u001a\u00020\u007f*\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00180)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b6\u00107R\u0014\u0010:\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001b\u0010=\u001a\u00020>8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bA\u00109\u001a\u0004\b?\u0010@R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020D0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010I\u001a\u0004\u0018\u00010J8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008d\u0001"}, d2 = {"Lcom/ss/android/lark/flow/feed/sidebar/human/OfficeSidebarHumanFeedController;", "Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/IOfficeSidebarHumanFeedController;", "Lcom/larksuite/arch/jack/ISubscriber;", "Landroidx/lifecycle/ViewModelStoreOwner;", "hostFragment", "Landroidx/fragment/app/Fragment;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "sidebarItemConfig", "Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/SidebarItemConfig;", "dataSource", "Lcom/ss/android/lark/flow/feed/base/user/IFeedUserDataSource;", "localCache", "Lcom/ss/android/lark/feed/molten/cache/IFeedItemsMoltenLocalCache;", "callback", "Lcom/ss/android/lark/feed/export/mixed/IMixedFeedSidebarCallback;", "<init>", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/LifecycleOwner;Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/SidebarItemConfig;Lcom/ss/android/lark/flow/feed/base/user/IFeedUserDataSource;Lcom/ss/android/lark/feed/molten/cache/IFeedItemsMoltenLocalCache;Lcom/ss/android/lark/feed/export/mixed/IMixedFeedSidebarCallback;)V", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/HumanDataChangedListener;", "cardCache", "Ljava/util/LinkedHashMap;", "", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "Lkotlin/collections/LinkedHashMap;", "pendingPageRequests", "", "Lcom/ss/android/lark/flow/feed/sidebar/human/OfficeSidebarHumanFeedController$PendingPageRequest;", "pendingShowLock", "", "pendingShowCards", "wrapperViewModelStore", "Landroidx/lifecycle/ViewModelStore;", "rustClientHolder", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/bytedance/lark/rustclient/api/IRustClient;", "sidebarViewModelHolder", "Lcom/ss/android/lark/feed/shared/page/IFeedItemsViewModel;", "currentUserId", "sourceItems", "", "canLoadMore", "", "latestSourceVersion", "", "hasReceivedLiveSourceRecord", "isAwaitingLiveSourceAfterCacheRestore", "firstPageNormalCount", "", "isReleased", "isUserLoginFailed", "renderDelegate", "Lcom/ss/android/lark/flow/feed/sidebar/human/OfficeSidebarHumanFeedRenderDelegate;", "getRenderDelegate", "()Lcom/ss/android/lark/flow/feed/sidebar/human/OfficeSidebarHumanFeedRenderDelegate;", "renderDelegate$delegate", "Lkotlin/Lazy;", "viewModelStore", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "lifecycleOwnerHolder", "Lcom/larksuite/arch/jack/LifecycleOwnerHolder;", "getLifecycleOwnerHolder", "()Lcom/larksuite/arch/jack/LifecycleOwnerHolder;", "lifecycleOwnerHolder$delegate", "userReadyListener", "Lkotlin/Function0;", "", "retryEnterUserReadyRunnable", "Ljava/lang/Runnable;", "reportHumanListShowRunnable", "userNotReadyListener", "officeSDKFeedApi", "Lcom/ss/android/lark/officesdk/feed/api/IOfficeSDKFeedApi;", "getOfficeSDKFeedApi", "()Lcom/ss/android/lark/officesdk/feed/api/IOfficeSDKFeedApi;", "userLoginFailedListener", "Lcom/ss/android/lark/officesdk/feed/api/OfficeSdkLoginFailedListener;", "removeHumanData", "refreshHumanList", "Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/OfficeSidebarHumanListPage;", "normalCount", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadMoreHumanList", "count", "addHumanDataChanged", "listener", "removeHumanDataChanged", "createHumanListView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "bindHumanListView", "view", "id", "onHumanListViewRecycled", "setHumanListClickHint", "clearHumanListClickHint", "reportHumanListShow", "releaseHumanList", "tryEnterUserReady", "scheduleRetryEnterUserReady", "attachViewModelListeners", "viewModel", "onSourceRecord", "record", "Lcom/ss/android/lark/feed/shared/data/UpdateRecord;", "isCurrentUserRecord", "shouldIgnoreInitialEmptyLiveRecord", "nextItems", "isHumanSidebarCard", "card", "completeOrRequestPendingPages", "isPageReady", "request", "requestMoreHumanListData", "awaitHumanListPage", "scene", "(Lcom/ss/android/lark/flow/feed/sidebar/human/OfficeSidebarHumanFeedController$PendingPageRequest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildPage", "currentNormalItems", "loadMoreItems", "restoreHumanSidebarCache", "syncHumanSidebarCache", "dispatchHumanDataChanged", "snapshot", "Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/OfficeSidebarFeedMeta;", "updatedIds", "dispatchItemChangedForceNotify", "logHumanListPage", "page", "flushHumanListShows", "clearPendingHumanListShows", "completeAllPendingPageRequests", "buildChangedItems", "oldItems", "toFlowMeta", "Companion", "PendingPageRequest", "PageRequestType", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OfficeSidebarHumanFeedController implements iza.b, f, ViewModelStoreOwner {
    public static final /* synthetic */ int E = 0;
    public final com.ss.android.lark.flow.feed.sidebar.human.b A;
    public final com.ss.android.lark.flow.feed.sidebar.human.a B;
    public final Function0<Unit> C;
    public final com.ss.android.lark.flow.feed.sidebar.human.c D;
    public final Fragment a;
    public final LifecycleOwner b;
    public final iza.e c;
    public final chb.a d;
    public final com.ss.android.lark.feed.molten.cache.b e;
    public final deb.d f;
    public final CopyOnWriteArraySet<iza.a> g;
    public final LinkedHashMap<String, UIFeedCard> h;
    public final List<b> i;
    public final Object j;
    public final LinkedHashMap<String, UIFeedCard> k;
    public final ViewModelStore l;
    public final AtomicReference<l> m;
    public final AtomicReference<s> n;
    public String o;
    public List<? extends UIFeedCard> p;
    public boolean q;
    public long r;
    public boolean s;
    public boolean t;
    public int u;
    public boolean v;
    public boolean w;
    public final Lazy x;
    public final Lazy y;
    public final Function0<Unit> z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/flow/feed/sidebar/human/OfficeSidebarHumanFeedController$PageRequestType;", "", "<init>", "(Ljava/lang/String;I)V", "REFRESH", "LOAD_MORE", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum PageRequestType extends Enum<PageRequestType> {
        public static final PageRequestType LOAD_MORE = null;
        public static final PageRequestType REFRESH = null;
        public static final /* synthetic */ PageRequestType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PageRequestType> getEntries() {
            return b;
        }

        static {
            PageRequestType r0 = new PageRequestType("REFRESH", 0);
            REFRESH = r0;
            PageRequestType r1 = new PageRequestType("LOAD_MORE", 1);
            LOAD_MORE = r1;
            PageRequestType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static PageRequestType[] values() {
            return (PageRequestType[]) a.clone();
        }

        public static PageRequestType valueOf(String r1) {
            return (PageRequestType) r27.a.a(PageRequestType.class, r1);
        }

        public PageRequestType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final PageRequestType a;
        public final int b;
        public Set<String> c;
        public final CompletableDeferred<iza.d> d;
        public boolean e;
        public boolean f;
        public int g;

        public b() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            int r2 = 1231;
            if (this.e == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.f == true) goto L11;
            r2 = 1237;
        L11:
            return ((r3 + r2) * 31) + this.g;
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "PendingPageRequest(type=" + this.a + ", requiredNormalCount=" + this.b + ", baselineLoadedIds=" + this.c + ", deferred=" + this.d + ", isBaselineInitialized=" + this.e + ", isWaitingForLoadResult=" + this.f + ", consecutiveNoChangeLoadCount=" + this.g + ')';
        }

        public final PageRequestType getType() {
            return this.a;
        }

        public b(PageRequestType r2, int r3, Set r4, CompletableDeferred r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r4, "baselineLoadedIds");
            Intrinsics.checkNotNullParameter(r5, "deferred");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = false;
            this.g = 0;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PageRequestType.values().length];
            r0[PageRequestType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PageRequestType.LOAD_MORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((iza.c) r4).b), Long.valueOf(((iza.c) r3).b));
        }
    }

    public static final class e<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public e(d r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            int r0 = this.a.compare(r3, r4);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return ComparisonsKt.compareValues(Long.valueOf(((iza.c) r4).c), Long.valueOf(((iza.c) r3).c));
        }
    }

    static {
    }

    public final void A() {
        if (this.v == false) goto L7;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "tryEnterUserReady skipped: controller released");
        return;
    L7:
        if (this.n.get() != null) goto L9;
    L12:
        l r0 = this.d.w();
        s r2 = this.d.t0(this);
        if (r0 == null) goto L18;
        if (r2 == null) goto L18;
        UICallbackExecutor.removeCallbacks(this.A);
        this.m.set(r0);
        this.n.set(r2);
        this.o = this.d.t();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r2.feedItemEntities(this), new OfficeSidebarHumanFeedController$attachViewModelListeners$1$1$1(this, null)), LifecycleOwnerKt.getLifecycleScope(this.b));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r2.canLoadMoreState(this), new OfficeSidebarHumanFeedController$attachViewModelListeners$1$1$2(this, null)), LifecycleOwnerKt.getLifecycleScope(this.b));
        r2.start(FeedFolderCompat.INSTANCE.getMESSAGE_WITHOUT_DOUBAO());
        p();
        return;
    L18:
        StringBuilder r3 = new StringBuilder("tryEnterUserReady waiting: rustClient ready=");
        boolean r4 = false;
        if (r0 == null) goto L21;
        boolean r1 = true;
    L22:
        r3.append(r1);
        r3.append(", viewModel ready=");
        if (r2 == null) goto L25;
        r4 = true;
    L25:
        r3.append(r4);
        com.ss.android.lark.flow.feed.utils.b.e("OfficeSidebarHumanFeedController", r3.toString());
        if (this.v == false) goto L29;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "scheduleRetryEnterUserReady skipped: controller released");
        return;
    L29:
        if (this.w == false) goto L32;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "scheduleRetryEnterUserReady skipped: user login failed");
        return;
    L32:
        if (this.n.get() == null) goto L34;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "scheduleRetryEnterUserReady skipped: viewModel already ready");
        return;
    L34:
        UICallbackExecutor.removeCallbacks(this.A);
        UICallbackExecutor.executeDelayed(this.A, 50);
        return;
    L21:
        r1 = false;
        goto L22
    L9:
        if (this.m.get() == null) goto L12;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "tryEnterUserReady skipped: user scope already ready");
    }

    public final i getLifecycleOwnerHolder() {
        return (i) this.y.getValue();
    }

    public final void k() {
        if (this.v == false) goto L6;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "releaseHumanList skipped: already released");
        return;
    L6:
        this.v = true;
        UICallbackExecutor.removeCallbacks(this.A);
        UICallbackExecutor.removeCallbacks(this.B);
        Object r0 = this.j;
        monitor-enter(r0);
        this.k.clear();     // Catch: Throwable -> L19
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r0);
        this.d.k3(this.z);
        this.d.ce(this.C);
        qtb.b r2 = (qtb.b) LarkContext.spiByDwarf(qtb.b.class);     // Catch: Throwable -> L13
    L15:
        if (r2 == null) goto L17;
        r2.a0(this.D);
    L17:
        this.m.set(null);
        this.n.set(null);
        this.o = null;
        this.p = CollectionsKt.emptyList();
        this.h.clear();
        this.s = false;
        this.t = false;
        u().f.clear();
        this.g.clear();
        o();
        this.l.clear();
        return;
    L13:
        th = move-exception;
        com.ss.android.lark.flow.feed.utils.b.c("OfficeSidebarHumanFeedController", "spiByDwarf(IOfficeSDKFeedApi) failed", th);
        r2 = null;
    L19:
        th = move-exception;
        throw th;
    }

    public final void o() {
        if (((ArrayList) this.i).isEmpty() == false) goto L6;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "completeAllPendingPageRequests skipped: no pending request");
        return;
    L6:
        Iterator r0 = CollectionsKt.toList(this.i).iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        b r1 = (b) r0.next();
        r1.d.complete(n(r1));
        goto L8
    }

    public final void p() {
        Iterator r0 = CollectionsKt.toList(this.i).iterator();
    L4:
        if (r0.hasNext() == false) goto L49;
        b r1 = (b) r0.next();
        if (this.v == false) goto L9;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "isPageReady: controller released, type=" + r1.getType());
    L26:
        boolean r2 = true;
    L28:
        if (r2 == true) goto L29;
        if (r1.getType() != PageRequestType.LOAD_MORE) goto L43;
        if (r1.e == true) goto L43;
        if (this.s == false) goto L41;
        List<? extends UIFeedCard> r3 = this.p;
        LinkedHashSet r6 = new LinkedHashSet();
        Iterator<T> r4 = r3.iterator();
    L38:
        if (r4.hasNext() == false) goto L40;
        r6.add(((UIFeedCard) r4.next()).getId());
        goto L38
    L40:
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r1.c = r6;
        r1.e = true;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "loadMoreHumanList initialized live baseline=" + r1.c.size());
        goto L43
    L41:
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "loadMoreHumanList waiting: live source not received");
    L43:
        if (r1.f == true) goto L44;
        s r5 = this.n.get();
        if (r5 == null) goto L47;
        r1.f = true;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "requestMoreHumanListData type=" + r1.getType() + ", requiredNormalCount=" + r1.b + ", noChangeLoadCount=" + r1.g + ", lastPosition=" + CollectionsKt.getLastIndex(this.p) + " version=" + this.r);
        r5.onItemChanged(RangesKt.coerceAtLeast(CollectionsKt.getLastIndex(this.p), 0), (UIFeedCard) CollectionsKt.lastOrNull(this.p), false);
        goto L4
    L47:
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "requestMoreHumanListData skipped: viewModel not ready, type=" + r1.getType());
        goto L4
    L44:
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "requestMoreHumanListData skipped: waiting result, type=" + r1.getType());
        goto L4
    L29:
        r1.d.complete(n(r1));
        goto L4
    L9:
        if (this.q == true) goto L12;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "isPageReady: no more data, type=" + r1.getType());
        goto L26
    L12:
        if (r1.g < 2) goto L14;
        com.ss.android.lark.flow.feed.utils.b.e("OfficeSidebarHumanFeedController", "isPageReady: stop after no-change loads, type=" + r1.getType() + ", count=" + r1.g);
        goto L26
    L14:
        int r7 = c.a[r1.getType().ordinal()];
        if (r7 == 1) goto L25;
        if (r7 != 2) goto L23;
        if (r1.e == true) goto L20;
    L27:
        r2 = false;
        goto L28
    L20:
        if (v(r1).size() < r1.b) goto L27;
    L23:
        throw new NoWhenBranchMatchedException();
    L25:
        if (((ArrayList) q()).size() < r1.b) goto L27;
    }

    public final List<UIFeedCard> q() {
        List<? extends UIFeedCard> r0 = this.p;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((UIFeedCard) r3).getOnTopRankTime() > 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L11:
        return r1;
    }

    public final OfficeSidebarHumanFeedRenderDelegate u() {
        return (OfficeSidebarHumanFeedRenderDelegate) this.x.getValue();
    }

    public final boolean x() {
        if ((!this.p.isEmpty()) == false) goto L6;
        return false;
    L6:
        if (this.w == false) goto L8;
        return false;
    L8:
        com.ss.android.lark.feed.molten.cache.a r0 = this.e.b();
        if (r0 != null) goto L13;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "restoreHumanSidebarCache skipped: cache empty");
        return false;
    L13:
        if (r0.a.isEmpty() == false) goto L16;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "restoreHumanSidebarCache skipped: cached items empty");
        return false;
    L16:
        this.p = r0.a;
        this.h.clear();
        Iterator r2 = r0.a.iterator();
    L18:
        if (r2.hasNext() == false) goto L20;
        UIFeedCard r4 = (UIFeedCard) r2.next();
        this.h.put(r4.getId(), r4);
        goto L18
    L20:
        this.q = r0.b;
        this.r = r0.c;
        this.t = true;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "restoreHumanSidebarCache size=" + r0.a.size() + ", hasMore=" + r0.b + ", version=" + r0.c);
        return true;
    }

    public final void y() {
        if (this.q == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.e.a(this.p, r0, this.r);
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "syncHumanSidebarCache sourceNormalSize=" + ((ArrayList) q()).size() + ", sourceCanLoadMore=" + this.q + ", cacheHasMore=" + r0);
        return;
    L5:
        if (((ArrayList) q()).size() > 20) goto L8;
        r0 = false;
        goto L9
    }

    public final void c() {
        String r0 = jeb.b.a().q3();
        jeb.b.a().Xa();
        if (r0 == null) goto L8;
        UIFeedCard r1 = this.h.get(r0);
        if (r1 == null) goto L9;
        t(r1);
        return;
    L9:
        return;
    }

    public final ViewModelStore getViewModelStore() {
        return this.l;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        jeb.b.a().k4(r2);
        UIFeedCard r0 = this.h.get(r2);
        if (r0 != null) goto L6;
        com.ss.android.lark.flow.feed.utils.b.e("OfficeSidebarHumanFeedController", "setHumanListClickHint skipped: card missing id=".concat(r2));
        return;
    L6:
        t(r0);
    }

    public final View d(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        u().getClass();
        Intrinsics.checkNotNullParameter(r4, "parent");
        FrameLayout r0 = new FrameLayout(r4.getContext());
        r0.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return r0;
    }

    public final void e(p r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g.add(r2);
    }

    public final void i(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        OfficeSidebarHumanFeedRenderDelegate r1 = u();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "view");
        if ((r3 instanceof ViewGroup) == false) goto L5;
        ViewGroup r0 = (ViewGroup) r3;
    L6:
        if (r0 == null) goto L8;
        r0.removeAllViews();
    L8:
        r1.f.remove(r3);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void j(iza.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g.remove(r2);
    }

    public final iza.d n(b r3) {
        PageRequestType r0 = r3.getType();
        int r1 = c.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        List<UIFeedCard> r4 = this.p;
    L10:
        List<UIFeedCard> r5 = r4;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L15;
        r2.add(z((UIFeedCard) r6.next()));
        goto L12
    L15:
        return new iza.d(r2, this.q);
    L5:
        if (r1 != 2) goto L8;
        r4 = v(r3);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void t(UIFeedCard r4) {
        iza.d r0 = new iza.d(CollectionsKt.listOf(z(r4)), this.q);
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "onHumanListSnapshotChanged updatedIds=[" + r4.getId() + "], hasMore=" + r0.b + ", ");
        Iterator<iza.a> r5 = this.g.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().a(r0);
        goto L4
    }

    public final List<UIFeedCard> v(b r6) {
        if (r6.e == false) goto L5;
        List<UIFeedCard> r0 = q();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        if ((!r6.c.contains(((UIFeedCard) r3).getId())) == false) goto L8;
        r1.add(r3);
        goto L8
    L12:
        return r1;
    L5:
        return CollectionsKt.emptyList();
    }

    public final iza.c z(UIFeedCard r15) {
        long r8 = (r15.getRankTime() & 144115188075855871L) * ((long) AudioViewModel.ASR_SESSION_IDLE);
        String r5 = r15.getId();
        if (r15.getOnTopRankTime() <= 0) goto L5;
        long r6 = r8;
    L7:
        return new iza.c(r5, r6, r8, this.r, false, r15.getBadgeCount());
    L5:
        r6 = 0;
        goto L7
    }

    public static void s(OfficeSidebarHumanFeedController r3, List r4) {
        List r0 = r4;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((iza.c) r2.next()).a);
        goto L4
    L6:
        r3.r(r4, r1);
    }

    public static void w(String r3, iza.d r4) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3);
        r0.append(" feedIds=");
        List r5 = r4.a;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r1.add(((iza.c) r6.next()).a);
        goto L4
    L6:
        r0.append(r1);
        r0.append(", hasMore=");
        r0.append(r4.b);
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", r0.toString());
    }

    public final boolean b(View r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "id");
        UIFeedCard r1 = this.h.get(r12);
        OfficeSidebarHumanFeedRenderDelegate.b r2 = null;
        ViewGroup r3 = null;
        if (r1 != null) goto L11;
        com.ss.android.lark.flow.feed.utils.b.e("OfficeSidebarHumanFeedController", "bindHumanListView skipped: card missing id=".concat(r12));
        OfficeSidebarHumanFeedRenderDelegate r13 = u();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r11, "view");
        if ((r11 instanceof ViewGroup) == false) goto L7;
        r3 = (ViewGroup) r11;
    L7:
        if (r3 == null) goto L9;
        r3.removeAllViews();
    L9:
        r13.f.remove(r11);
        return false;
    L11:
        OfficeSidebarHumanFeedRenderDelegate r14 = u();
        Function1<String, Unit> r4 = new OfficeSidebarHumanFeedController$bindHumanListView$1(this);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r1, "card");
        Intrinsics.checkNotNullParameter(r4, "onCardChanged");
        if ((r11 instanceof FrameLayout) == false) goto L14;
        FrameLayout r15 = (FrameLayout) r11;
    L15:
        if (r15 == null) goto L39;
        FeedCard.Type r0 = r1.getType();
        if (r0 != null) goto L21;
        r0 = FeedCard.Type.UNKNOWN;
    L21:
        if (r0 != FeedCard.Type.APP_FEED) goto L23;
        AppFeedCardType r5 = r1.getBizType();
    L24:
        OfficeSidebarHumanFeedRenderDelegate.b r6 = r14.f.get(r15);
        if (r6 != null) goto L27;
    L31:
        r15.removeAllViews();
        com.ss.android.lark.feed.export.feedcard.e r7 = (com.ss.android.lark.feed.export.feedcard.e) ((reb.a) r14.k.getValue()).a(r0, r5);
        if (r7 != null) goto L34;
        com.ss.android.lark.flow.feed.utils.b.b("OfficeSidebarHumanFeedRenderDelegate", "ensureRenderState failed: factory missing type=" + r0 + " bizType=" + r5);
        r14.f.remove(r15);
    L35:
        if (r2 == null) goto L40;
        r1.setDataObserver(new OfficeSidebarHumanFeedRenderDelegate.c(r4));
        r2.a.V3(r1, (com.ss.android.lark.feed.export.feedcard.c) r14.h.getValue(), (ueb.a) r14.j.getValue(), (OfficeSidebarHumanFeedRenderDelegate$feedCardContext$2.a) r14.g.getValue());
        r2.a.U3(r1, (seb.b) r14.i.getValue(), (ueb.a) r14.j.getValue(), (OfficeSidebarHumanFeedRenderDelegate$feedCardContext$2.a) r14.g.getValue());
        return true;
    L40:
        return false;
    L34:
        View r8 = LayoutInflater.from(r15.getContext()).inflate(2131561594, r15, false);
        Intrinsics.checkNotNull(r8);
        FeedSidebarCommonViewHolder r9 = new FeedSidebarCommonViewHolder(r8, (OfficeSidebarHumanFeedRenderDelegate$feedCardContext$2.a) r14.g.getValue(), r14.b);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r9.m = r0;
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r9.n = r5;
        r9.X3(r7.b(r8));
        r9.l = r7.c((OfficeSidebarHumanFeedRenderDelegate$feedCardContext$2.a) r14.g.getValue());
        r15.addView(r8, new FrameLayout.LayoutParams(-1, -2));
        r2 = new OfficeSidebarHumanFeedRenderDelegate.b(r9, r0, r5);
        r14.f.put(r15, r2);
        goto L35
    L27:
        if (r6.b != r0) goto L31;
        if (r6.c != r5) goto L31;
        r2 = r6;
        goto L35
    L23:
        r5 = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
        goto L24
    L39:
        return false;
    L14:
        r15 = null;
        goto L15
    }

    public final Object f(int r7, Continuation<? super iza.d> r8) {
        x();
        PageRequestType r1 = PageRequestType.LOAD_MORE;
        int r2 = RangesKt.coerceAtLeast(r7, 1);
        if (this.s == false) goto L8;
        List<? extends UIFeedCard> r9 = this.p;
        Set r3 = new LinkedHashSet();
        Iterator<T> r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L9;
        r3.add(((UIFeedCard) r10.next()).getId());
    L9:
        final b r11 = new b(r1, r2, r3, CompletableDeferredKt.CompletableDeferred$default(null, 1, null), this.s);
        ((ArrayList) this.i).add(r11);
        r11.d.invokeOnCompletion(new OfficeSidebarHumanFeedController$loadMoreHumanList$2(this, r11));
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "loadMoreHumanList requiredNormalCount=" + r11.b + ", baselineSize=" + r11.c.size() + ", isBaselineInitialized=" + r11.e);
        p();
        A();
        return l(r11, "loadMoreHumanList", r8);
    L8:
        r3 = SetsKt.emptySet();
        goto L9
    }

    public final Object g(int r9, Continuation<? super iza.d> r10) {
        boolean r0 = x();
        final b r7 = new b(PageRequestType.REFRESH, RangesKt.coerceAtLeast(r9, 1), SetsKt.emptySet(), CompletableDeferredKt.CompletableDeferred$default(null, 1, null), true);
        ((ArrayList) this.i).add(r7);
        r7.d.invokeOnCompletion(new OfficeSidebarHumanFeedController$refreshHumanList$2(this, r7));
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "refreshHumanList requiredNormalCount=" + r7.b);
        if (r0 == false) goto L5;
        this.u = r7.b;
        r7.d.complete(n(r7));
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "refreshHumanList return cached page directly");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), null, null, new OfficeSidebarHumanFeedController$refreshHumanList$3(this, null), 3, null);
    L7:
        return l(r7, "refreshHumanList", r10);
    L5:
        p();
        A();
        goto L7
    }

    public final void h(View r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "id");
        OfficeSidebarHumanFeedRenderDelegate r0 = u();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "view");
        OfficeSidebarHumanFeedRenderDelegate.b r5 = r0.f.get(r3);
        if (r5 == null) goto L9;
        FeedSidebarCommonViewHolder r6 = r5.a;
        if (r6 == null) goto L9;
        h r7 = r6.k;
        if (r7 == null) goto L9;
        r7.c();
    L9:
        UIFeedCard r8 = this.h.get(r4);
        if (r8 != null) goto L13;
        com.ss.android.lark.flow.feed.utils.b.e("OfficeSidebarHumanFeedController", "reportHumanListShow skipped: card missing id=".concat(r4));
        return;
    L13:
        Object r1 = this.j;
        monitor-enter(r1);
        this.k.put(r4, r8);     // Catch: Throwable -> L19
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r1);
        UICallbackExecutor.removeCallbacks(this.B);
        UICallbackExecutor.executeDelayed(this.B, 1000);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final List<iza.c> m(List<? extends UIFeedCard> r7, List<? extends UIFeedCard> r8) {
        List<? extends UIFeedCard> r9 = r7;
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r9, 10)), 16));
        Iterator<T> r1 = r9.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Object r4 = r1.next();
        r3.put(((UIFeedCard) r4).getId(), r4);
        goto L4
    L6:
        List<? extends UIFeedCard> r10 = r8;
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r10, 10)), 16));
        Iterator<T> r0 = r10.iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        Object r5 = r0.next();
        r2.put(((UIFeedCard) r5).getId(), r5);
        goto L8
    L10:
        ArrayList r6 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L18;
        UIFeedCard r12 = (UIFeedCard) r11.next();
        UIFeedCard r13 = (UIFeedCard) r3.get(r12.getId());
        if (r13 == null) goto L17;
        if (r12.exactlyCompare(r13) == true) goto L12;
    L17:
        r6.add(z(r12));
        goto L12
    L18:
        Iterator<T> r14 = r9.iterator();
    L20:
        if (r14.hasNext() == false) goto L25;
        UIFeedCard r15 = (UIFeedCard) r14.next();
        if (r2.containsKey(r15.getId()) == true) goto L20;
        r6.add(iza.c.a(z(r15)));
        goto L20
    L25:
        return CollectionsKt.sortedWith(r6, new e(new d()));
    }

    public final void r(List<iza.c> r3, List<String> r4) {
        iza.d r0 = new iza.d(r3, this.q);
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "onHumanListSnapshotChanged updatedIds=" + r4 + ", hasMore=" + r0.b);
        Iterator<T> r5 = this.g.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((iza.a) r5.next()).a(r0);
        goto L4
    }

    public final Object l(b r10, String r11, Continuation<? super iza.d> r12) {
        if ((r12 instanceof OfficeSidebarHumanFeedController$awaitHumanListPage$1) == false) goto L7;
        OfficeSidebarHumanFeedController$awaitHumanListPage$1 r0 = (OfficeSidebarHumanFeedController$awaitHumanListPage$1) r12;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r11 = (String) r0.L$1;
        r10 = (b) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L28
    L20:
        iza.d r14 = (iza.d) r13;     // Catch: Throwable -> L28
        if (r14 != null) goto L23;
        r14 = n(r10);     // Catch: Throwable -> L28
        r10.d.complete(r14);     // Catch: Throwable -> L28
        com.ss.android.lark.flow.feed.utils.b.e("OfficeSidebarHumanFeedController", r11 + " timeout type=" + r10.getType() + ", requiredNormalCount=" + r10.b + ", sourceSize=" + this.p.size() + ", hasMore=" + this.q);     // Catch: Throwable -> L28
    L23:
        w(r11 + " return", r14);     // Catch: Throwable -> L28
        if (r10.d.isCompleted() == true) goto L27;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", r11 + " cancelled type=" + r10.getType());
        Job.DefaultImpls.cancel$default(r10.d, null, 1, null);
    L27:
        return r14;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r13);
        OfficeSidebarHumanFeedController$awaitHumanListPage$page$1 r15 = new OfficeSidebarHumanFeedController$awaitHumanListPage$page$1(r10, null);     // Catch: Throwable -> L28
        r0.L$0 = r10;     // Catch: Throwable -> L28
        r0.L$1 = r11;     // Catch: Throwable -> L28
        r0.label = 1;     // Catch: Throwable -> L28
        r13 = TimeoutKt.c(10000, r15, r0);     // Catch: Throwable -> L28
        if (r13 != r2) goto L20;
        return r2;
    L28:
        th = move-exception;
        if (r10.d.isCompleted() == true) goto L32;
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", r11 + " cancelled type=" + r10.getType());
        Job.DefaultImpls.cancel$default(r10.d, null, 1, null);
    L32:
        throw th;
    L7:
        r0 = new OfficeSidebarHumanFeedController$awaitHumanListPage$1(this, r12);
        goto L8
    }

    public final <S extends j> com.larksuite.arch.jack.c nH(JackViewModel<S> r1, com.larksuite.arch.jack.l<S> r2, Function1<? super S, Unit> r3) {
        return f.a.g(this, r1, r2, r3);
    }

    public final com.larksuite.arch.jack.c Ik(JackViewModel r1, PropertyReference1Impl r2, com.larksuite.arch.jack.l r3, Function1 r4) {
        return f.a.a(this, r1, r2, r3, r4);
    }

    public OfficeSidebarHumanFeedController(Fragment r3, LifecycleOwner r4, iza.e r5, vmb.c r6, com.ss.android.lark.feed.molten.cache.b r7) {
        r.a r0 = r.a.a;
        Intrinsics.checkNotNullParameter(r3, "hostFragment");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "sidebarItemConfig");
        Intrinsics.checkNotNullParameter(r6, "dataSource");
        Intrinsics.checkNotNullParameter(r7, "localCache");
        Intrinsics.checkNotNullParameter(r0, "callback");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r0;
        this.g = new CopyOnWriteArraySet();
        this.h = new LinkedHashMap();
        this.i = new ArrayList();
        this.j = new Object();
        this.k = new LinkedHashMap();
        this.l = new ViewModelStore();
        qtb.b r8 = null;
        this.m = new AtomicReference(null);
        this.n = new AtomicReference(null);
        this.p = CollectionsKt.emptyList();
        this.q = true;
        this.r = Long.MIN_VALUE;
        this.x = LazyKt.lazy(new OfficeSidebarHumanFeedController$renderDelegate$2(this));
        this.y = LazyKt.lazy(new OfficeSidebarHumanFeedController$lifecycleOwnerHolder$2(this));
        Function0<Unit> r9 = new OfficeSidebarHumanFeedController$userReadyListener$1(this);
        this.z = r9;
        this.A = new com.ss.android.lark.flow.feed.sidebar.human.b(this);
        this.B = new com.ss.android.lark.flow.feed.sidebar.human.a(this);
        Function0<Unit> r10 = new OfficeSidebarHumanFeedController$userNotReadyListener$1(this);
        this.C = r10;
        com.ss.android.lark.flow.feed.sidebar.human.c r1 = new com.ss.android.lark.flow.feed.sidebar.human.c(this);
        this.D = r1;
        r6.i8(r9);
        r6.Nb(r10);
        r8 = (qtb.b) LarkContext.spiByDwarf(qtb.b.class);     // Catch: Throwable -> L5
    L7:
        if (r8 == null) goto L9;
        r8.M(r1);
    L9:
        r4.getLifecycle().addObserver(new AnonymousClass1(this));
        return;
    L5:
        th = move-exception;
        com.ss.android.lark.flow.feed.utils.b.c("OfficeSidebarHumanFeedController", "spiByDwarf(IOfficeSDKFeedApi) failed", th);
        goto L7
    }

    public final com.larksuite.arch.jack.c Ki(JackViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, com.larksuite.arch.jack.l r4, Function1 r5) {
        return f.a.b(this, r1, r2, r3, r4, r5);
    }

    public final com.larksuite.arch.jack.c O60(FilePickerViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, PropertyReference1Impl r4, com.larksuite.arch.jack.l r5, Function1 r6) {
        return f.a.c(this, r1, r2, r3, r4, r5, r6);
    }
}
