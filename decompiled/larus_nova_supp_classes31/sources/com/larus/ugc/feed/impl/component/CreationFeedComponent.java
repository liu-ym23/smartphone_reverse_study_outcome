package com.larus.ugc.feed.impl.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.community.api.tracker.CreationFeedBehaviorTracker;
import com.larus.media.focus.OScrollStateHelper;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.DisplayExtra;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.profile.api.ICreationService;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.ugc.feed.api.model.AuthorInfoKmp;
import com.larus.ugc.feed.api.model.CreationFeedInitParamsKmp;
import com.larus.ugc.feed.api.model.CreationFeedTrackParamsKmp;
import com.larus.ugc.feed.api.model.DisplayExtraKmp;
import com.larus.ugc.feed.api.model.TabItemInfoKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.api.model.UserCreationModelKmp;
import com.larus.ugc.feed.api.model.UserCreationTrackParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobFeedStaytimeParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobSessionSlideParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateShowParamsKmp;
import com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl;
import com.larus.ugc.feed.impl.adapter.CreationListAdapter;
import com.larus.ugc.feed.impl.adapter.CreationListAdapter$preload$1;
import com.larus.ugc.feed.impl.adapter.GridSpacingItemDecoration;
import com.larus.ugc.feed.impl.cache.CreationListCacheDataSource;
import com.larus.ugc.feed.impl.component.layoutmanager.CreationFeedStaggeredGridLayoutManager;
import com.larus.ugc.feed.impl.databinding.LarusCommunityCreationFeedComponentLayoutKmpBinding;
import com.larus.ugc.feed.impl.databinding.LarusCommunityCreationFeedComponentLayoutNoRefreshKmpBinding;
import com.larus.ugc.feed.impl.mapper.CreationFeedPlatformRepositoryAdapter;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import v19.c7;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \u0093\u00012\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0004\u0092\u0001\u0093\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u00109\u001a\u00020:2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010;\u001a\u00020:H\u0016J\b\u0010<\u001a\u00020:H\u0002J\b\u0010=\u001a\u00020:H\u0016J\b\u0010>\u001a\u00020:H\u0016J\u0010\u0010?\u001a\u00020:2\u0006\u0010@\u001a\u00020\u0018H\u0016J\b\u0010A\u001a\u00020\u001eH\u0002J\b\u0010B\u001a\u00020 H\u0002J\b\u0010C\u001a\u00020:H\u0002J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001eH\u0002J\u0010\u0010G\u001a\u00020:2\u0006\u0010F\u001a\u00020\u001eH\u0002J\b\u0010H\u001a\u00020:H\u0002J\b\u0010I\u001a\u00020:H\u0002J \u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020 2\u0006\u0010N\u001a\u00020 H\u0002J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u0002070P2\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010Q\u001a\u00020:H\u0002J+\u0010R\u001a\u00020:2\u0006\u0010S\u001a\u00020T2\u0019\u0010U\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010E¢\u0006\u0002\bW\u0012\u0004\u0012\u00020:0VH\u0002J\u001e\u0010X\u001a\u00020:2\b\u0010S\u001a\u0004\u0018\u00010T2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010EH\u0002J\u0018\u0010\\\u001a\u00020:2\u0006\u0010]\u001a\u00020\u001e2\u0006\u0010^\u001a\u00020EH\u0002J\b\u0010_\u001a\u00020:H\u0002J\b\u0010`\u001a\u00020:H\u0002J\b\u0010a\u001a\u00020:H\u0002J\u001a\u0010b\u001a\u00020:2\u0006\u0010c\u001a\u00020E2\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J\u0010\u0010d\u001a\u00020:2\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010e\u001a\u00020 H\u0002J\b\u0010f\u001a\u00020:H\u0016J\b\u0010g\u001a\u00020:H\u0016J\u000f\u0010h\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010iJ\u001a\u0010j\u001a\u00020:2\u0006\u0010]\u001a\u00020\u001e2\b\b\u0002\u0010k\u001a\u00020\u001eH\u0002J7\u0010l\u001a\u00020:2\u0006\u0010m\u001a\u00020 2\u0006\u0010n\u001a\u00020 2\b\u0010o\u001a\u0004\u0018\u00010p2\u0006\u0010q\u001a\u00020 2\u0006\u0010r\u001a\u00020 H\u0016¢\u0006\u0002\u0010sJ\u001f\u0010t\u001a\u00020:2\b\u0010o\u001a\u0004\u0018\u00010p2\u0006\u0010r\u001a\u00020 H\u0002¢\u0006\u0002\u0010uJ\u0018\u0010v\u001a\u00020:2\b\u0010o\u001a\u0004\u0018\u00010pH\u0082@¢\u0006\u0002\u0010wJ\u0017\u0010x\u001a\u00020:2\b\u0010o\u001a\u0004\u0018\u00010pH\u0002¢\u0006\u0002\u0010yJ\u001f\u0010z\u001a\u00020:2\b\u0010o\u001a\u0004\u0018\u00010p2\u0006\u0010n\u001a\u00020 H\u0002¢\u0006\u0002\u0010uJ\u001a\u0010{\u001a\u00020:2\u0006\u0010]\u001a\u00020\u001e2\b\b\u0002\u0010k\u001a\u00020\u001eH\u0002J\u0010\u0010|\u001a\u00020:2\u0006\u0010}\u001a\u00020~H\u0016J\u0010\u0010\u007f\u001a\u00020:2\u0006\u0010}\u001a\u00020~H\u0016J\u0012\u0010\u0080\u0001\u001a\u00020:2\u0007\u0010\u0081\u0001\u001a\u00020\u0015H\u0016J\u001c\u0010\u0082\u0001\u001a\u00020:2\u0011\u0010\u0081\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017H\u0016J\t\u0010\u0083\u0001\u001a\u00020:H\u0016J\t\u0010\u0084\u0001\u001a\u00020:H\u0016J\u000b\u0010\u0085\u0001\u001a\u0004\u0018\u00010LH\u0016J\u0010\u0010\u0086\u0001\u001a\t\u0012\u0004\u0012\u00020 0\u0087\u0001H\u0016J\u001b\u0010\u0088\u0001\u001a\u00020:2\u0007\u0010\u0089\u0001\u001a\u00020E2\u0007\u0010\u008a\u0001\u001a\u00020 H\u0016J,\u0010\u008b\u0001\u001a\u00020:2\u0007\u0010\u008c\u0001\u001a\u00020\u001e2\u0007\u0010\u008d\u0001\u001a\u00020 2\u0006\u0010S\u001a\u00020T2\u0007\u0010\u008a\u0001\u001a\u00020 H\u0016J\u0011\u0010\u008e\u0001\u001a\u00020:2\u0006\u0010S\u001a\u00020TH\u0016J\u0011\u0010\u008f\u0001\u001a\u00020:2\u0006\u0010S\u001a\u00020TH\u0016J\t\u0010\u0090\u0001\u001a\u00020:H\u0016J\t\u0010\u0091\u0001\u001a\u00020\u001eH\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u000e\u0010-\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020706X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0094\u0001"}, d2 = {"Lcom/larus/ugc/feed/impl/component/CreationFeedComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/platform/api/creation/ICreationFeedAbility;", "<init>", "()V", "viewModel", "Lcom/larus/ugc/feed/impl/component/CreationFeedLegacyBridgeViewModel;", "getViewModel", "()Lcom/larus/ugc/feed/impl/component/CreationFeedLegacyBridgeViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "abilityBinding", "Lcom/larus/ugc/feed/impl/ability/CreationFeedAndroidAbilityBinding;", "ability", "Lcom/larus/ugc/feed/impl/ability/CreationFeedAbilityImpl;", "getAbility", "()Lcom/larus/ugc/feed/impl/ability/CreationFeedAbilityImpl;", "creationFeedLayoutViewBinding", "Lcom/larus/ugc/feed/impl/component/CreationFeedLayoutViewBinding;", "headCreator", "Lcom/larus/platform/api/creation/ICreationFeedHeaderCreator;", "emptyViewCreator", "Lkotlin/Function0;", "Landroid/view/View;", "openLongClickMenuDialogHelper", "Lcom/larus/ugc/feed/impl/component/OpenLongClickMenuDialogHelper;", "adapter", "Lcom/larus/ugc/feed/impl/adapter/CreationListAdapter;", "spanCount", "", "canExposeItemShow", "", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "initDependency", "Lcom/larus/platform/api/creation/CreationFeedInitDependency;", "saveMusicFrameLayout", "Landroid/widget/FrameLayout;", "creationDownLoadHelper", "Lcom/larus/ugc/feed/impl/component/CreationDownLoadHelper;", "getCreationDownLoadHelper", "()Lcom/larus/ugc/feed/impl/component/CreationDownLoadHelper;", "creationDownLoadHelper$delegate", "Lkotlin/Lazy;", "firstResume", "doSameAbility", "Lcom/larus/platform/model/creation/ICreationDoSameAbility;", "focusHelper", "Lcom/larus/ugc/feed/impl/component/focus/CreationFeedRVFocusHelper;", "loadMoreDistance", "latestUiState", "Lcom/larus/ugc/feed/api/state/CreationFeedUiState;", "feedBehaviorTracker", "Lcom/larus/community/api/tracker/CreationFeedBehaviorTracker;", "Lcom/larus/ugc/feed/impl/component/CreationFeedComponent$VisibleCreation;", "isUserScrollInProgress", "initialize", "", "onResume", "fetchFirstScreenData", "onPause", "onAttach", "onViewCreated", "view", "getCreationFeedType", "isTemplateListHost", "initView", "checkItemShowGetter", "", "index", "reportShow", "checkItemShow", "postUpdateFeedBehavior", "updateFeedBehavior", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "allowFirstScreenSlide", "settleDisappeared", "collectVisibleCreations", "", "initClickAction", "showQuickMenuBeforeDoSame", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "doSameLogic", "Lkotlin/Function1;", "Lcom/larus/platform/model/creation/DoSameQuickMenuType;", "goToDoSame", "fileLocalPath", "job", "Lkotlinx/coroutines/Job;", "goCreationDetailPage", "position", "clickEnterMethod", "initObservers", "initRefreshLayout", "initLoadMore", "checkCanLoadMoreAndTryLoad", "sceneTag", "updateMoreStateToLoadingSafely", "canLoadMore", "onFragmentViewDestroyed", "onDestroy", "computeVerticalScrollOffset", "()Ljava/lang/Integer;", "scrollToPositionToFirst", "duration", "scrollToTopAndRefresh", "notScrollToTop", "notRefresh", "smoothScrollDuration", "", "checkFirstPageData", "isHotLaunch", "(ZZLjava/lang/Long;ZZ)V", "handleDataCheckAndRefresh", "(Ljava/lang/Long;Z)V", "scrollToTopAndPerformRefresh", "(Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performSmoothScrollToTop", "(Ljava/lang/Long;)V", "performNormalScrollToTopAndRefresh", "smoothScrollToPositionToStart", "addOnScrollListener", "listener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "removeOnScrollListener", "setCustomHeaderViewHolder", "creator", "setCustomEmptyViewCreator", "setViewGone", "setViewVisible", "getRecyclerView", "getHasDataLiveData", "Landroidx/lifecycle/LiveData;", "deleteUserCreation", "creationId", "modelAllDeleted", "updateCreationModelPrivacy", "privacy", "splitMode", "setMockUserCreation", "onSetCreationStatus", "invalidateSpanAssignments", "getCreationPageType", "VisibleCreation", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationFeedComponent extends BaseContentWidget implements zp9.l {
    public static final int H = 0;
    public sq9.t A;
    public q0a.c B;
    public int C;
    public n0a.a D;
    public final CreationFeedBehaviorTracker<b> E;
    public boolean F;
    public Job G;
    public final com.larus.ui.arch.vm.internal.l m;
    public com.larus.ugc.feed.impl.ability.x n;
    public final c0 o;
    public zp9.p p;
    public Function0<? extends View> q;
    public e0 r;
    public CreationListAdapter s;
    public int t;
    public boolean u;
    public zp9.f v;
    public zp9.e w;
    public FrameLayout x;
    public final Lazy y;
    public boolean z;

    public static final class a {
    }

    public static final class b {
        public final UserCreation a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "VisibleCreation(data=" + this.a + ", position=" + this.b + ')';
        }

        public b(UserCreation r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(j r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class d implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public d(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class e implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public e(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class f implements Function0<ViewModelProvider.Factory> {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    /* JADX INFO: renamed from: com.larus.ugc.feed.impl.component.CreationFeedComponent$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ugc.feed.impl.component.CreationFeedComponent$onViewCreated$1", f = "CreationFeedComponent.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CreationFeedComponent this$0;

        public AnonymousClass1(CreationFeedComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L13:
            Boolean r11 = (Boolean) r10;
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            CreationFeedComponent r12 = this.this$0;
            int r2 = CreationFeedComponent.H;
            CreationFeedAbilityImpl r3 = r12.B3();
            if (r3 == null) goto L15;
            boolean r6 = !CreationFeedComponent.m3(this.this$0);
            this.label = 1;
            r10 = g0a.g.a.a(r3, true, false, r6, this, 2);
            if (r10 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.ugc.feed.impl.component.CreationFeedComponent$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ugc.feed.impl.component.CreationFeedComponent$onViewCreated$2", f = "CreationFeedComponent.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CreationFeedComponent this$0;

        public AnonymousClass2(CreationFeedComponent r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L13:
            Boolean r11 = (Boolean) r10;
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            CreationFeedComponent r12 = this.this$0;
            int r2 = CreationFeedComponent.H;
            CreationFeedAbilityImpl r3 = r12.B3();
            if (r3 == null) goto L15;
            boolean r6 = !CreationFeedComponent.m3(this.this$0);
            this.label = 1;
            r10 = g0a.g.a.a(r3, true, false, r6, this, 2);
            if (r10 != r0) goto L13;
            return r0;
        }
    }

    public final void A2() {
    }

    static {
        H = z2.a.getCommunityRecommendRequestConfig().b();
    }

    public final CreationFeedAbilityImpl B3() {
        com.larus.ugc.feed.impl.ability.x r0 = this.n;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public final int C3() {
        zp9.f r0 = this.v;
        if (r0 == null) goto L7;
        Integer r1 = r0.f;
        if (r1 == null) goto L7;
        return r1.intValue();
    L7:
        return 4;
    }

    public final CreationFeedLegacyBridgeViewModel D3() {
        return (CreationFeedLegacyBridgeViewModel) this.m.getValue();
    }

    public final boolean canLoadMore() {
        n0a.a r0 = this.D;
        n0a.b r1 = r0.d;
        if ((r1 instanceof n0a.b.d) == false) goto L5;
    L12:
        boolean r2 = false;
    L13:
        boolean r3 = !(r0.c instanceof n0a.e.b);
        if (r2 == false) goto L18;
        if (r3 == false) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    L5:
        if ((r1 instanceof n0a.b.C0067b) == true) goto L12;
        if ((r1 instanceof n0a.b.e) == true) goto L12;
        if ((r1 instanceof n0a.b.a) == true) goto L12;
        r2 = true;
        goto L13
    }

    @Override // zp9.l
    public final Integer computeVerticalScrollOffset() {
        RecyclerView r0 = this.o.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.computeVerticalScrollOffset());
    }

    @Override // zp9.l
    public final RecyclerView getRecyclerView() {
        return this.o.a();
    }

    public final void onDestroy() {
        CreationListAdapter r0 = this.s;
        if (r0 == null) goto L5;
        r0.A2();
    L5:
        this.s = null;
        this.n = null;
        D3().setLoadMoreCallback(null);
        sq9.t r1 = this.A;
        if (r1 == null) goto L9;
        r1.onDestroy();
        return;
    }

    public final void onPause() {
        this.E.a(CreationFeedBehaviorTracker.ExposurePauseReason.PAGE_HIDDEN);
        q0a.c r0 = this.B;
        if (r0 == null) goto L9;
        OScrollStateHelper r1 = r0.a;
        if (r1 == null) goto L7;
        r1.h();
    L7:
        r0.a = null;
        r0.b.getClass();
        return;
    }

    public final void onResume() {
        CreationFeedBehaviorTracker<b> r0 = this.E;
        CreationFeedBehaviorTracker.ExposurePauseReason r1 = CreationFeedBehaviorTracker.ExposurePauseReason.PAGE_HIDDEN;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        r0.h.remove(r1);
        RecyclerView r2 = this.o.a();
        if (r2 == null) goto L5;
        r2.post(new t(this));
    L5:
        RecyclerView r3 = this.o.a();
        if (r3 == null) goto L9;
        y6.c(r3, new g(this), new r(this), new s(this));
    L9:
        if (this.z == false) goto L35;
        Ref.BooleanRef r4 = new Ref.BooleanRef();
        zp9.f r5 = this.v;
        if (r5 == null) goto L19;
        String r6 = r5.q;
        if (r6 == null) goto L19;
        CreationListCacheDataSource.a.getClass();
        Intrinsics.checkNotNullParameter(r6, "creationRecommendType");
        Boolean r7 = CreationListCacheDataSource.c.get(r6);
        if (r7 == null) goto L17;
        boolean r8 = r7.booleanValue();
    L18:
        r4.element = r8;
        goto L19
    L17:
        r8 = false;
    L19:
        zp9.f r9 = this.v;
        if (r9 == null) goto L24;
        boolean r10 = true;
        if (r9.b != true) goto L24;
    L25:
        boolean r11 = w0a.a.a;
        StringBuilder r12 = new StringBuilder("hasRefresh:");
        r12.append(r4.element);
        r12.append(", forceRefreshIgnoreCache:");
        zp9.f r13 = this.v;
        if (r13 == null) goto L28;
        Boolean r14 = Boolean.valueOf(r13.a);
    L29:
        r12.append(r14);
        r12.append(", disableInitialAutoRefreshOnce:");
        r12.append(r10);
        w0a.a.c("CreationFeedComponent", r12.toString());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationFeedComponent$fetchFirstScreenData$2(this, r10, r4, null), 3, null);
        zp9.f r15 = this.v;
        if (r15 == null) goto L34;
        String r16 = r15.q;
        if (r16 == null) goto L34;
        CreationListCacheDataSource.a.getClass();
        Intrinsics.checkNotNullParameter(r16, "creationRecommendType");
        CreationListCacheDataSource.c.put(r16, Boolean.TRUE);
    L34:
        this.z = false;
        goto L35
    L28:
        r14 = null;
    L24:
        r10 = false;
    L35:
        final q0a.c r17 = this.B;
        if (r17 == null) goto L42;
        final RecyclerView r18 = this.o.a();
        if (r18 == null) goto L43;
        r18.post(new q0a.a(r17, r18));
        return;
    L43:
        return;
    }

    public final void y2() {
        w0a.a.a("CreationFeedComponent", new k(this));
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, zp9.l.class);
        ICreationService.Companion r1 = ICreationService.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.A = r1.d(com.larus.ui.arch.component.internal.attach.a.b(this, this), false);
    }

    public CreationFeedComponent() {
        this.m = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CreationFeedLegacyBridgeViewModel.class), Reflection.getOrCreateKotlinClass(EmptyBridgeState.class), new d(this), new e(this), f.a);
        this.o = new c0();
        this.t = 2;
        this.u = true;
        this.y = LazyKt.lazy(new u());
        this.z = true;
        this.C = H;
        this.D = new n0a.a(0);
        this.E = new CreationFeedBehaviorTracker(new v());
    }

    @Override // zp9.l
    public final LiveData<Boolean> og() {
        return Transformations.map(D3().getFeedDataLiveData(), new m());
    }

    public static final boolean m3(CreationFeedComponent r1) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(com.larus.ui.arch.component.internal.attach.a.b(r1, r1).getClass().getSimpleName(), "TemplateCreationListFragment");
    }

    @Override // zp9.l
    public final void CO(UserCreation r4) {
        Intrinsics.checkNotNullParameter(r4, "userCreation");
        CreationFeedAbilityImpl r1 = B3();
        if (r1 == null) goto L6;
        final UserCreationKmp r5 = com.larus.ugc.feed.impl.mapper.c.b(r4);
        Intrinsics.checkNotNullParameter(r5, "userCreation");
        r1.p("onSetPublicSuccess:" + r5.getCreationId());
        r1.b.update(new com.larus.ugc.feed.impl.ability.o(r5));
        return;
    }

    public final void E3(Long r7) {
        if (r7 != null) goto L5;
    L13:
        H3(0, 100);
        return;
    L5:
        if (r7.longValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r7 = null;
    L11:
        if (r7 == null) goto L13;
        H3(0, (int) r7.longValue());
        r7.longValue();
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // zp9.l
    public final void Eo(zp9.p r2) {
        Intrinsics.checkNotNullParameter(r2, "creator");
        this.p = r2;
    }

    public final void G3(int r35) {
        if (this.p == null) goto L5;
        int r1 = r35 - 1;
    L6:
        CreationListAdapter r2 = this.s;
        String r3 = null;
        if (r2 == null) goto L15;
        List<UserCreationModel> r4 = r2.b;
        if (r4 == null) goto L15;
        UserCreationModel r5 = (UserCreationModel) CollectionsKt.getOrNull(r4, r1);
        if (r5 == null) goto L15;
        List<UserCreation> r6 = r5.b();
        if (r6 == null) goto L15;
        UserCreation r7 = (UserCreation) CollectionsKt.firstOrNull(r6);
    L16:
        if (r7 != null) goto L18;
        w0a.a.b("CreationFeedComponent", "data is null");
    L18:
        if (r7 == null) goto L105;
        CreationFeedAbilityImpl r8 = B3();
        if (r8 == null) goto L106;
        CreationListAdapter r9 = this.s;
        if (r9 == null) goto L24;
        Intrinsics.checkNotNullParameter(r7, "creation");
        UserCreationKmp r10 = r9.B2(r7);
    L25:
        Intrinsics.checkNotNullParameter(r10, "item");
        m0a.h r11 = r8.d;
        if (r11 == null) goto L32;
        m0a.k r12 = r11.a();
        if (r12 == null) goto L32;
        boolean r13 = true;
        if (r12.a(r10) != true) goto L32;
    L33:
        if (r13 == true) goto L109;
        CreationFeedInitParamsKmp r14 = r8.c;
        if (r14 == null) goto L38;
        CreationFeedTrackParamsKmp r15 = r14.getTrackParams();
    L39:
        if (r14 == null) goto L41;
        TabItemInfoKmp r16 = r14.getCurrentTabItemInfo();
    L43:
        if (r15 == null) goto L45;
        String r17 = r15.getBotId();
    L46:
        String r18 = r10.getCreationId();
        String r19 = z0a.a.e(r10);
        String r110 = z0a.a.d(r10);
        AuthorInfoKmp r20 = r10.getAuthorInfo();
        if (r20 == null) goto L49;
        String r111 = r20.getUid();
    L50:
        String r112 = z0a.a.c(r10);
        Long r113 = r10.getUsageCount();
        UserCreationTrackParamsKmp r21 = r10.getClientTrackParams();
        if (r21 == null) goto L53;
        String r114 = r21.getLogId();
    L54:
        if (r15 == null) goto L56;
        String r115 = r15.getAiCreationRecommendFrom();
    L58:
        if (r15 == null) goto L61;
        String r22 = r15.getCurrentPage();
        if (r22 == null) goto L61;
    L62:
        String r116 = r22;
        UserCreationTrackParamsKmp r23 = r10.getClientTrackParams();
        if (r23 == null) goto L67;
        Integer r24 = r23.getPosition();
        if (r24 == null) goto L67;
        String r117 = r24.toString();
    L68:
        UserCreationTrackParamsKmp r25 = r10.getClientTrackParams();
        if (r25 == null) goto L71;
        Integer r26 = r25.getPageIndex();
    L72:
        if (r15 == null) goto L74;
        String r27 = r15.getChatType();
    L75:
        if (r15 == null) goto L77;
        Integer r28 = r15.getActionBarTemplateId();
    L78:
        if (r16 == null) goto L80;
        String r29 = r16.getId();
    L81:
        if (r16 == null) goto L83;
        String r210 = r16.getTrackerTabType();
    L84:
        if (r16 == null) goto L86;
        String r30 = r16.getStarlingKey();
    L87:
        if (r15 == null) goto L89;
        String r211 = r15.getPreviousPage();
    L90:
        if (r15 == null) goto L92;
        String r212 = r15.getEnterMethod();
    L93:
        if (r15 == null) goto L95;
        String r213 = r15.getConversationId();
    L96:
        String r214 = r10.getCreationTraceInfo();
        String r215 = z0a.a.d(r10);
        boolean r31 = z0a.a.g(r10);
        Integer r32 = z0a.a.b(r10);
        if (r15 == null) goto L99;
        r3 = r15.getCurrentPageKey();
    L99:
        MobTemplateShowParamsKmp r118 = new MobTemplateShowParamsKmp(r17, r18, r19, r110, r111, r112, r113, r114, r115, null, r116, r117, r26, r27, r28, r29, r210, r30, r211, r212, r213, r214, r215, r31, r32, r3, z0a.a.f(r10));
        m0a.h r33 = r8.d;
        if (r33 == null) goto L107;
        o0a.a r34 = r33.R0();
        if (r34 == null) goto L108;
        r34.g(r118);
        return;
    L108:
        return;
    L107:
        return;
    L95:
        r213 = null;
        goto L96
    L92:
        r212 = null;
        goto L93
    L89:
        r211 = null;
        goto L90
    L86:
        r30 = null;
        goto L87
    L83:
        r210 = null;
        goto L84
    L80:
        r29 = null;
        goto L81
    L77:
        r28 = null;
        goto L78
    L74:
        r27 = null;
        goto L75
    L71:
        r26 = null;
    L67:
        r117 = null;
    L61:
        r22 = "";
        goto L62
    L56:
        r115 = null;
        goto L58
    L53:
        r114 = null;
        goto L54
    L49:
        r111 = null;
        goto L50
    L45:
        r17 = null;
        goto L46
    L41:
        r16 = null;
        goto L43
    L38:
        r15 = null;
        goto L39
    L109:
        return;
    L32:
        r13 = false;
        goto L33
    L24:
        r10 = com.larus.ugc.feed.impl.mapper.c.b(r7);
        goto L25
    L106:
        return;
    L105:
        return;
    L15:
        r7 = null;
        goto L16
    L5:
        r1 = r35;
        goto L6
    }

    @Override // zp9.l
    public final void X20(Function0<? extends View> r1) {
        this.q = r1;
    }

    @Override // zp9.l
    public final void addOnScrollListener(RecyclerView.OnScrollListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        RecyclerView r0 = this.o.a();
        if (r0 == null) goto L6;
        r0.addOnScrollListener(r2);
        return;
    }

    @Override // zp9.l
    public final void fQ(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
        xc(r2);
    }

    /* JADX WARN: Type inference failed for: r4v10, types: [com.larus.ugc.feed.impl.component.j] */
    public final void onViewCreated(View r24) {
        Intrinsics.checkNotNullParameter(r24, "view");
        zp9.e r1 = this.w;
        if (r1 == null) goto L7;
        zp9.n r2 = r1.a;
        if (r2 == null) goto L7;
        CreationFeedCacheEntity r3 = r2.b();
    L8:
        if (r3 == null) goto L10;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    L19:
        View r4 = F2();
        if ((r4 instanceof FrameLayout) == false) goto L22;
        FrameLayout r5 = (FrameLayout) r4;
    L23:
        c0 r6 = this.o;
        LarusCommunityCreationFeedComponentLayoutKmpBinding r7 = r6.a;
        if (r7 == null) goto L28;
        View r8 = r7.a;
        if (r8 == null) goto L28;
    L33:
        if (r8 == null) goto L56;
        if (r5 == null) goto L36;
        r5.addView(r8, -1, -1);
    L36:
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L39;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
    L40:
        if (r10 == null) goto L54;
        zp9.f r11 = this.v;
        if (r11 == null) goto L46;
        Integer r12 = r11.n;
        if (r12 == null) goto L46;
        int r13 = r12.intValue();
    L47:
        zp9.f r14 = this.v;
        if (r14 == null) goto L52;
        Integer r15 = r14.o;
        if (r15 == null) goto L52;
        int r16 = r15.intValue();
    L53:
        r10.setMargins(r13, 0, r16, 0);
    L55:
        r8.setLayoutParams(r10);
    L52:
        r16 = i5.M();
    L46:
        r13 = i5.M();
        goto L47
    L54:
        r10 = null;
        goto L55
    L39:
        r10 = null;
    L56:
        RecyclerView r17 = getRecyclerView();
        if (r17 == null) goto L66;
        zp9.f r18 = this.v;
        if (r18 == null) goto L63;
        Integer r19 = r18.h;
        if (r19 == null) goto L63;
        int r20 = r19.intValue();
    L64:
        r17.setPadding(0, r20, 0, 0);
    L63:
        r20 = i5.N() + i5.a();
    L66:
        if (AppHost.a.isDebug() == false) goto L70;
        TextView r21 = new TextView(getContext());
        r21.setTextColor(ContextCompat.getColor(getContext(), 2131106521));
        r21.setText("std-feed");
        r21.setBackgroundColor(ColorProtector.parseColor("#FF6C55"));
        r21.setAlpha(0.5f);
        if (r5 == null) goto L70;
        r5.addView(r21, -2, -2);
    L70:
        zp9.f r22 = this.v;
        if (r22 != null) goto L73;
    L75:
        boolean r23 = false;
    L76:
        if (r23 == false) goto L78;
        this.B = new q0a.c();
    L78:
        Context r25 = getContext();
        if (r25 == null) goto L81;
        float r26 = c7.d(Integer.valueOf(com.larus.utils.i.d(r25)));
    L83:
        if (r26 <= 500.0f) goto L85;
        this.t = 3;
    L85:
        zp9.f r27 = this.v;
        if (r27 == null) goto L90;
        Integer r28 = r27.k;
        if (r28 == null) goto L90;
        int r29 = r28.intValue();
    L91:
        this.t = r29;
        zp9.f r30 = this.v;
        if (r30 != null) goto L94;
    L96:
        boolean r31 = false;
    L97:
        if (r31 == false) goto L99;
        final GridLayoutManager r32 = new GridLayoutManager(getContext(), this.t);
    L109:
        RecyclerView r33 = this.o.a();
        if (r33 == null) goto L112;
        r33.setLayoutManager(r32);
    L112:
        RecyclerView r34 = this.o.a();
        if (r34 == null) goto L115;
        r34.setSaveEnabled(false);
    L115:
        RecyclerView r35 = this.o.a();
        if (r35 == null) goto L129;
        zp9.f r36 = this.v;
        if (r36 == null) goto L121;
        RecyclerView.ItemDecoration r37 = r36.s;
        if (r37 == null) goto L121;
    L128:
        r35.addItemDecoration(r37);
    L121:
        int r38 = this.t;
        if (r36 == null) goto L126;
        Integer r39 = r36.m;
        if (r39 == null) goto L126;
        int r40 = r39.intValue();
    L127:
        r37 = new GridSpacingItemDecoration(r38, r40, Boolean.valueOf(r32 instanceof StaggeredGridLayoutManager));
    L126:
        r40 = i5.e0();
    L129:
        RecyclerView r41 = this.o.a();
        if (r41 == null) goto L132;
        r41.setItemAnimator(null);
    L132:
        zp9.f r42 = this.v;
        if (r42 == null) goto L136;
        String r43 = r42.c;
        if (r43 == null) goto L136;
    L137:
        final et3.c r44 = new et3.c(r43, false, null);
        RecyclerView r45 = this.o.a();
        if (r45 == null) goto L140;
        r45.addOnScrollListener(new CreationFeedComponent$initView$1(this, r32, r44));
    L140:
        int r110 = this.t;
        ArrayList r111 = new ArrayList();
        LifecycleCoroutineScope r112 = LifecycleOwnerKt.getLifecycleScope(this);
        zp9.p r113 = this.p;
        Function0<? extends View> r46 = this.q;
        if (r46 != null) goto L143;
        final Context r47 = getContext();
        Intrinsics.checkNotNullParameter(r47, "context");
        Function0<? extends View> r114 = new c1a.a(r47);
    L144:
        int r115 = C3();
        zp9.f r48 = this.v;
        if (r48 == null) goto L147;
        boolean r116 = r48.i;
    L148:
        Intrinsics.checkNotNullParameter(this, "<this>");
        String r117 = com.larus.ui.arch.component.internal.attach.a.b(this, this).toString();
        zp9.f r49 = this.v;
        q0a.c r50 = this.B;
        zp9.e r51 = this.w;
        if (r51 == null) goto L151;
        RecyclerView.RecycledViewPool r210 = r51.d;
    L152:
        CreationListAdapter r52 = new CreationListAdapter(r110, r111, r112, r113, r114, r115, r116, r117, r49, r50, r210);
        this.s = r52;
        p0a.k r53 = new CreationFeedComponent$initClickAction$1(this);
        Intrinsics.checkNotNullParameter(r53, "creationClickCallBack");
        r52.l = r53;
        RecyclerView r54 = this.o.a();
        if (r54 == null) goto L155;
        y6.f(r54, new z(this), new h(this), 0.0f, new i(this), 49);
    L155:
        z2 r55 = z2.a;
        if (r55.creationFeedHolderOpt() == false) goto L165;
        zp9.e r56 = this.w;
        if (r56 == null) goto L161;
        RecyclerView.RecycledViewPool r57 = r56.d;
        if (r57 == null) goto L161;
    L162:
        RecyclerView r58 = this.o.a();
        if (r58 == null) goto L165;
        r58.setRecycledViewPool(r57);
    L161:
        r57 = CreationListAdapter.a.a();
    L165:
        RecyclerView r59 = this.o.a();
        if (r59 == null) goto L169;
        r59.setAdapter(this.s);
    L169:
        if (r55.creationFeedHolderOpt() == false) goto L196;
        RecyclerView r60 = this.o.a();
        if (r60 == null) goto L196;
        final CreationListAdapter r61 = this.s;
        if (r61 == null) goto L196;
        Intrinsics.checkNotNullParameter(this, "<this>");
        LifecycleOwner r62 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner();
        Intrinsics.checkNotNullParameter(r60, "recyclerView");
        Intrinsics.checkNotNullParameter(r62, "lifecycleOwner");
        if (r55.creationFeedHolderOpt() == false) goto L196;
        if (r61.s == true) goto L196;
        RecyclerView.RecycledViewPool r63 = r61.k;
        if (r63 != null) goto L183;
        r63 = r60.getRecycledViewPool();
    L183:
        ArrayDeque<Integer> r64 = new ArrayDeque();
        Integer[] r118 = CreationListAdapter.x;
        int r119 = 0;
    L185:
        if (r119 >= 6) goto L193;
        int r120 = r118[r119].intValue();
        int r121 = 12 - r63.getRecycledViewCount(r120);
        if (r121 <= 0) goto L191;
        int r122 = 0;
    L189:
        if (r122 >= r121) goto L191;
        r64.add(Integer.valueOf(r120));
        r122 = r122 + 1;
    L191:
        r119 = r119 + 1;
        goto L185
    L193:
        if (r64.isEmpty() == true) goto L196;
        r61.t = r64;
        r61.u = r60;
        Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler) r61.v.getValue());
        r61.s = true;
        r62.getLifecycle().addObserver(new CreationListAdapter$preload$1(r61));
    L196:
        SwipeRefreshLayout r65 = this.o.b();
        if (r65 == null) goto L199;
        r65.setOnRefreshListener(new o(this));
        r65.setColorSchemeColors(new int[]{ContextCompat.getColor(r65.getContext(), v19.c.b(2130972123, r65.getContext(), 2131103203))});
        r65.setProgressViewOffset(false, (-i5.b()) + r65.getProgressViewStartOffset(), r65.getProgressViewEndOffset() + r65.getProgressViewStartOffset());
    L199:
        RecyclerView r66 = this.o.a();
        if (r66 == null) goto L202;
        r66.addOnScrollListener(new CreationFeedComponent$initLoadMore$1(this));
    L202:
        LiveData<List<UserCreationModel>> r67 = D3().getFeedDataLiveData();
        Intrinsics.checkNotNullParameter(this, "<this>");
        r67.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new c(new j()));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationFeedComponent$initObservers$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationFeedComponent$initObservers$3(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationFeedComponent$initObservers$4(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationFeedComponent$initObservers$5(this, null), 3, null);
        return;
    L151:
        r210 = null;
        goto L152
    L147:
        r116 = false;
        goto L148
    L143:
        r114 = r46;
    L136:
        Intrinsics.checkNotNullParameter(this, "<this>");
        r43 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getClass().getName();
        goto L137
    L99:
        GridLayoutManager r68 = new CreationFeedStaggeredGridLayoutManager(r29);
        zp9.f r69 = this.v;
        if (r69 != null) goto L102;
    L104:
        boolean r70 = false;
    L105:
        if (r70 == false) goto L107;
        w0a.a.b("CreationFeedComponent", "enableGapHandling");
    L108:
        r32 = r68;
        goto L109
    L107:
        r68.setGapStrategy(0);
        goto L108
    L102:
        if (r69.v != true) goto L104;
        r70 = true;
        goto L105
    L94:
        if (r30.l != true) goto L96;
        r31 = true;
    L90:
        r29 = this.t;
        goto L91
    L81:
        r26 = 200.0f;
        goto L83
    L73:
        if (r22.u != true) goto L75;
        r23 = true;
    L28:
        LarusCommunityCreationFeedComponentLayoutNoRefreshKmpBinding r71 = r6.b;
        if (r71 == null) goto L31;
        r8 = r71.a;
        goto L33
    L31:
        r8 = null;
        goto L33
    L22:
        r5 = null;
        goto L23
    L10:
        Intent r72 = s1a.a.getActivity(this).getIntent();
        if (r72 == null) goto L15;
        Bundle r73 = r72.getExtras();
        if (r73 == null) goto L15;
        String r74 = r73.getString("enter_method", "");
    L17:
        if (Intrinsics.areEqual(r74, "click_replica_manage") == false) goto L19;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(this, null), 3, null);
    L15:
        r74 = null;
    L7:
        r3 = null;
        goto L8
    }

    @Override // zp9.l
    public final void xc(UserCreation r39) {
        Intrinsics.checkNotNullParameter(r39, "userCreation");
        CreationFeedAbilityImpl r2 = B3();
        if (r2 == null) goto L32;
        UserCreationKmp r1 = com.larus.ugc.feed.impl.mapper.c.b(r39);
        Intrinsics.checkNotNullParameter(r1, "userCreation");
        n0a.a r0 = r2.b.a();
        if ((!r0.a.isEmpty()) == false) goto L7;
    L10:
        r2.n = r1;
        r2.p("setMockUserCreation success:" + r1.getCreationId());
        final ArrayList r3 = new ArrayList();
        r3.addAll(r2.t("publish", 1, CollectionsKt.listOf(r1)));
        List<UserCreationModelKmp> r4 = r0.a;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L12:
        if (r6.hasNext() == false) goto L31;
        UserCreationModelKmp r7 = (UserCreationModelKmp) r6.next();
        List<UserCreationKmp> r8 = r7.getCreationList();
        if (r8 == null) goto L29;
        List<UserCreationKmp> r9 = r8;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L17:
        if (r11.hasNext() == false) goto L28;
        UserCreationKmp r12 = (UserCreationKmp) r11.next();
        UserCreationTrackParamsKmp r13 = r12.getClientTrackParams();
        if (r13 != null) goto L21;
        r13 = new UserCreationTrackParamsKmp(null, null, null, null, null, null, null, 127, null);
    L21:
        UserCreationTrackParamsKmp r28 = r13;
        UserCreationTrackParamsKmp r14 = r12.getClientTrackParams();
        if (r14 == null) goto L26;
        Integer r15 = r14.getPosition();
        if (r15 == null) goto L26;
        int r16 = r15.intValue();
    L27:
        r10.add(UserCreationKmp.copy$default(r12, null, 0, null, null, null, null, null, null, null, null, null, null, null, UserCreationTrackParamsKmp.copy$default(r28, null, null, Integer.valueOf(r16 + 1), null, null, null, null, 123, null), null, null, null, 122879, null));
    L26:
        r16 = 0;
        goto L27
    L28:
        List r17 = CollectionsKt.toMutableList(r10);
    L30:
        UserCreationModelKmp r18 = UserCreationModelKmp.copy$default(r7, 0, r17, null, 5, null);
        m0a.o.a(r18);
        r5.add(r18);
        goto L12
    L29:
        r17 = null;
        goto L30
    L31:
        r3.addAll(r5);
        r2.b.update(new com.larus.ugc.feed.impl.ability.j(r3));
        goto L32
    L7:
        if (Intrinsics.areEqual(r0.b, n0a.d.f.a) == true) goto L10;
        r2.p("setMockUserCreation delay:" + r1.getCreationId());
        r2.n = r1;
    L32:
        zp9.l.a.a(this, false, true, null, false, false, 29);
    }

    public final String z3(int r3) {
        if (this.p == null) goto L5;
        r3 = r3 - 1;
    L5:
        CreationListAdapter r0 = this.s;
        if (r0 == null) goto L14;
        List<UserCreationModel> r1 = r0.b;
        if (r1 == null) goto L14;
        UserCreationModel r4 = (UserCreationModel) CollectionsKt.getOrNull(r1, r3);
        if (r4 == null) goto L14;
        List<UserCreation> r5 = r4.b();
        if (r5 == null) goto L14;
        UserCreation r6 = (UserCreation) CollectionsKt.firstOrNull(r5);
    L15:
        StringBuilder r2 = new StringBuilder();
        if (r6 == null) goto L19;
        Object r7 = r6.a;
        if (r7 == null) goto L19;
    L20:
        r2.append(r7);
        r2.append('_');
        if (r6 == null) goto L24;
        Object r8 = r6.f;
        if (r8 == null) goto L24;
    L25:
        r2.append(r8);
        return r2.toString();
    L24:
        r8 = "";
    L19:
        r7 = 0;
    L14:
        r6 = null;
        goto L15
    }

    public final void H3(int r4, final int r5) {
        RecyclerView r0 = this.o.a();
        if (r0 != null) goto L5;
        return;
    L5:
        final Context r1 = getContext();
        LinearSmoothScroller r2 = new CreationFeedComponent$smoothScrollToPositionToStart$linearSmoothScroller$1(r5, r1);
        r2.setTargetPosition(r4);
        RecyclerView.LayoutManager r6 = r0.getLayoutManager();
        if (r6 == null) goto L9;
        r6.startSmoothScroll(r2);
        return;
    }

    @Override // zp9.l
    public final void deleteUserCreation(final String r9, final boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "creationId");
        final CreationFeedAbilityImpl r2 = B3();
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r9, "creationId");
        if (CreationFeedAbilityImpl.d(r2.b.a().a, r9, r10).a == false) goto L10;
        r2.p("deleteUserCreation:" + r9);
        final long r5 = r2.e;
        r2.e = 1 + r5;
        r2.b.update(new com.larus.ugc.feed.impl.ability.i(r2, r9, r10, r5));
        return;
    L10:
        return;
    }

    @Override // zp9.l
    public final void nh(zp9.f r54, zp9.e r55) {
        Intrinsics.checkNotNullParameter(r54, "initParams");
        Intrinsics.checkNotNullParameter(r55, "initDependency");
        c0 r5 = this.o;
        Context r6 = getContext();
        boolean r7 = !r54.d;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        DisplayExtraKmp r8 = null;
        if (r7 == false) goto L9;
        SwipeRefreshLayout r9 = LayoutInflater.from(r6).inflate(2131561937, null, false);
        RecyclerView r10 = ViewBindings.findChildViewById(r9, 2131384076);
        if (r10 == null) goto L8;
        SwipeRefreshLayout r11 = r9;
        r5.a = new LarusCommunityCreationFeedComponentLayoutKmpBinding(r11, r10, r11);
    L12:
        SwipeRefreshLayout r12 = this.o.b();
        if (r12 == null) goto L15;
        r12.setEnabled(false);
    L15:
        this.v = r54;
        Integer r13 = r54.w;
        if (r13 == null) goto L18;
        int r14 = r13.intValue();
    L19:
        this.C = r14;
        boolean r15 = w0a.a.a;
        w0a.a.c("CreationFeedComponent", "loadMoreDistance:" + this.C);
        this.w = r55;
        LifecycleCoroutineScope r16 = LifecycleOwnerKt.getLifecycleScope(this);
        b1a.a r17 = new b1a.a();
        Intrinsics.checkNotNullParameter(r16, "scope");
        Intrinsics.checkNotNullParameter(r54, "initParams");
        Intrinsics.checkNotNullParameter(r55, "initDependency");
        Intrinsics.checkNotNullParameter(r17, "tracker");
        Intrinsics.checkNotNullParameter(r54, "<this>");
        TabItemInfo r18 = r54.j;
        if (r18 == null) goto L25;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        String r19 = r18.getId();
        String r110 = r18.b();
        String r111 = r18.getName();
        Boolean r112 = r18.c();
        DisplayExtra r20 = r18.a();
        if (r20 == null) goto L24;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        r8 = new DisplayExtraKmp(r20.d(), r20.b(), r20.c(), r20.a());
    L24:
        TabItemInfoKmp r29 = new TabItemInfoKmp(r19, r110, r111, r112, r8);
    L26:
        boolean r21 = r54.a;
        boolean r22 = r54.b;
        String r23 = r54.c;
        boolean r24 = r54.d;
        zp9.g r25 = r54.e;
        m0a.i r0 = new m0a.i(new CreationFeedInitParamsKmp(r21, r22, r23, r24, new CreationFeedTrackParamsKmp(r25.a, r25.b, r25.c, r25.d, r25.e, r25.f, r25.g, r25.h, r25.i, r25.j, r25.k, r25.l, r25.m, r25.n, r25.o, r25.p, r25.q, r25.r, r25.s, r25.t, r25.u, r25.v), r54.f, r54.g, r54.h, r54.i, r29, r54.k, r54.l, r54.m, r54.n, r54.o, r54.p, r54.q, r54.r, r54.u, r54.v, r54.w, r54.x, r54.y, r54.z), r54.s, r54.t);
        Intrinsics.checkNotNullParameter(r55, "<this>");
        Intrinsics.checkNotNullParameter(r17, "tracker");
        m0a.g r1 = new m0a.g(new CreationFeedPlatformRepositoryAdapter(r55.a), new com.larus.ugc.feed.impl.mapper.b(r55.b), r17, r55.c, r55.d);
        CreationFeedAbilityImpl r26 = new CreationFeedAbilityImpl(r16, new a1a.b(), r1.c);
        CreationFeedInitParamsKmp r27 = r0.a;
        Intrinsics.checkNotNullParameter(r27, "initParams");
        Intrinsics.checkNotNullParameter(r1, "initDependency");
        r26.c = r27;
        r26.d = r1;
        com.larus.ugc.feed.impl.ability.x r3 = new com.larus.ugc.feed.impl.ability.x(r26, r0, r1);
        this.n = r3;
        CreationFeedAbilityImpl r2 = r3.a;
        if (r2 == null) goto L29;
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), r2, g0a.g.class);
    L29:
        D3().setLoadMoreCallback(new l(this));
        this.r = new e0(r55);
        return;
    L25:
        r29 = null;
        goto L26
    L18:
        r14 = H;
        goto L19
    L8:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(2131384076)));
    L9:
        RecyclerView r28 = LayoutInflater.from(r6).inflate(2131561939, null, false);
        if (r28 == null) goto L32;
        RecyclerView r30 = r28;
        r5.b = new LarusCommunityCreationFeedComponentLayoutNoRefreshKmpBinding(r30, r30);
        goto L12
    L32:
        throw new NullPointerException("rootView");
    }

    public static final void Y2(final CreationFeedComponent r10, final String r11, RecyclerView r12) {
        r10.getClass();
        if (r12 == null) goto L56;
        w0a.a.a("CreationFeedComponent", new w(r11));
        if (r10.canLoadMore() == false) goto L50;
        StaggeredGridLayoutManager r0 = r12.getLayoutManager();
        final int r2 = 0;
        if ((r0 instanceof StaggeredGridLayoutManager) == false) goto L34;
        final int[] r1 = r0.findLastVisibleItemPositions(null);
        CreationListAdapter r3 = r10.s;
        if (r3 == null) goto L12;
        final int r4 = r3.getItemCount();
    L13:
        w0a.a.a("CreationFeedComponent", new x(r1, r4));
        if (r1 == null) goto L51;
        int r13 = r1.length;
        int r5 = 0;
    L16:
        if (r5 >= r13) goto L24;
        int r6 = r1[r5];
        if ((r4 - r6) >= r10.C) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == true) goto L22;
        r5 = r5 + 1;
        goto L16
    L22:
        Integer r14 = Integer.valueOf(r6);
    L25:
        if (r14 == null) goto L52;
        r14.intValue();
        if (r12.isComputingLayout() == false) goto L29;
        r12.post(new n(r10));
    L32:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10), null, null, new CreationFeedComponent$checkCanLoadMoreAndTryLoad$4$1(r10, null), 3, null);
        return;
    L29:
        CreationListAdapter r15 = r10.s;
        if (r15 == null) goto L32;
        r15.C2(n0a.b.d.a);
        goto L32
    L52:
        return;
    L20:
        r7 = false;
        goto L21
    L24:
        r14 = null;
        goto L25
    L51:
        return;
    L12:
        r4 = 0;
        goto L13
    L34:
        if ((r0 instanceof GridLayoutManager) == false) goto L54;
        final int r8 = ((GridLayoutManager) r0).findLastVisibleItemPosition();
        CreationListAdapter r9 = r10.s;
        if (r9 == null) goto L38;
        r2 = r9.getItemCount();
    L38:
        w0a.a.a("CreationFeedComponent", new y(r8, r2));
        if ((r2 - r8) < r10.C) goto L41;
        return;
    L41:
        if (r12.isComputingLayout() == false) goto L43;
        r12.post(new n(r10));
    L46:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10), null, null, new CreationFeedComponent$checkCanLoadMoreAndTryLoad$6(r10, null), 3, null);
        return;
    L43:
        CreationListAdapter r16 = r10.s;
        if (r16 == null) goto L46;
        r16.C2(n0a.b.d.a);
        goto L46
    L54:
        return;
    L50:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h3(final CreationFeedComponent r29, final int r30, String r31) {
        CreationListAdapter r1 = r29.s;
        Serializable r8 = null;
        if (r1 == null) goto L11;
        List<UserCreationModel> r2 = r1.b;
        if (r2 == null) goto L11;
        UserCreationModel r3 = (UserCreationModel) CollectionsKt.getOrNull(r2, r30);
        if (r3 == null) goto L11;
        List<UserCreation> r4 = r3.b();
        if (r4 == null) goto L11;
        UserCreation r5 = (UserCreation) CollectionsKt.firstOrNull(r4);
    L13:
        if (r5 != null) goto L15;
        w0a.a.b("CreationFeedComponent", "data is null");
        return;
    L15:
        zp9.e r6 = r29.w;
        boolean r7 = true;
        if (r6 == null) goto L22;
        zp9.m r9 = r6.b;
        if (r9 == null) goto L22;
        if (r9.b(r5) != true) goto L22;
        boolean r10 = true;
    L23:
        if (r10 == false) goto L25;
        w0a.a.c("CreationFeedComponent", "onClickGoCreationDetail  interceptor");
        return;
    L25:
        SwipeRefreshLayout r11 = r29.o.b();
        if (r11 == null) goto L28;
        r11.setRefreshing(false);
    L28:
        z2 r12 = z2.a;
        if (r12.f1().d() == true) goto L31;
    L76:
        final Ref.IntRef r13 = new Ref.IntRef();
        int r14 = r29.C3();
        if (r14 == 1) goto L81;
        if (r14 == 2) goto L80;
        int r15 = 4;
    L82:
        ICreationService.Companion r16 = ICreationService.a;
        if (r15 != 4) goto L89;
        AuthorInfo r17 = r5.g;
        if (r17 == null) goto L88;
        String r18 = r17.b;
        if (r18 == null) goto L88;
    L90:
        String r19 = r18;
        if (r12.f1().d() == true) goto L93;
    L95:
        boolean r20 = false;
    L96:
        gs9.c r110 = new gs9.c(new p(r29), r30, r19, r15, r20);
        zp9.e r21 = r29.w;
        if (r21 == null) goto L99;
        zp9.m r22 = r21.b;
    L100:
        CreationFeedLegacyBridgeViewModel r111 = r29.D3();
        zp9.f r23 = r29.v;
        if (r23 == null) goto L103;
        boolean r24 = r23.p;
    L104:
        if (r23 == null) goto L106;
        boolean r25 = r23.p;
    L107:
        gs9.a r26 = new gs9.a(r24, r25);
        gs9.f r27 = new CreationFeedComponent$goCreationDetailPage$creationFragment$2(r13, r30, r29);
        if (r23 == null) goto L113;
        zp9.g r28 = r23.e;
        if (r28 == null) goto L113;
        String r32 = r28.b;
        if (r32 == null) goto L113;
    L114:
        String r210 = r32;
        Boolean r211 = Boolean.FALSE;
        if (r23 == null) goto L119;
        zp9.g r33 = r23.e;
        if (r33 == null) goto L119;
        String r212 = r33.g;
    L120:
        if (r23 == null) goto L124;
        zp9.g r34 = r23.e;
        if (r34 == null) goto L124;
        String r213 = r34.d;
    L125:
        if (r23 == null) goto L129;
        zp9.g r35 = r23.e;
        if (r35 == null) goto L129;
        r8 = r35.j;
    L129:
        gs9.g r36 = r16.a(r110, new gs9.d(r111, r26, r27, new gs9.b("template_detail_button", r210, r211, r31, r212, r213, r8), r22, 384));
        Intrinsics.checkNotNullParameter(r29, "<this>");     // Catch: Exception -> L132
        r36.ax(com.larus.ui.arch.component.internal.attach.a.b(r29, r29).getChildFragmentManager(), "CreationFeedComponent");     // Catch: Exception -> L132
        r29.u = false;     // Catch: Exception -> L132
        return;
    L132:
        e = move-exception;
        FLogger.a.e("CreationFeedComponent", "there have something wrong when show e=" + e.getMessage());
        return;
    L124:
        r213 = null;
    L119:
        r212 = null;
    L113:
        r32 = "create_feed";
        goto L114
    L106:
        r25 = false;
        goto L107
    L103:
        r24 = false;
        goto L104
    L99:
        r22 = null;
        goto L100
    L93:
        if (r29.C3() == 2) goto L95;
        r20 = true;
    L88:
        r18 = "default";
        goto L90
    L89:
        r18 = "";
        goto L90
    L80:
        r15 = 2;
        goto L82
    L81:
        r15 = 1;
        goto L82
    L31:
        if (r5.b == 1) goto L76;
        if (r29.C3() == 2) goto L76;
        AuthorInfo r37 = r5.g;
        if (r37 == null) goto L37;
        String r38 = r37.b;
    L38:
        AccountService r39 = AccountService.a;
        boolean r40 = !Intrinsics.areEqual(r38, r39.getUserId());
        com.bytedance.router.i r41 = SmartRouter.buildRoute(r29.getContext(), "//flow/creation_detail");
        r41.c.putExtra("creation", GsonProtectorUtils.toJson(new Gson(), r5));
        Gson r42 = new Gson();
        zp9.f r43 = r29.v;
        if (r43 == null) goto L41;
        zp9.g r44 = r43.e;
    L42:
        r41.c.putExtra("track_params", GsonProtectorUtils.toJson(r42, r44));
        if (r40 == true) goto L45;
    L47:
        boolean r45 = false;
    L48:
        r41.c.putExtra("is_show_profile", r45);
        zp9.f r46 = r29.v;
        if (r46 == null) goto L51;
        Boolean r47 = Boolean.valueOf(r46.p);
    L52:
        r41.c.putExtra("show_usage_count", r47);
        AuthorInfo r48 = r5.g;
        if (r48 == null) goto L55;
        String r49 = r48.b;
    L56:
        r41.c.putExtra("can_show_inspiration_list", !Intrinsics.areEqual(r49, r39.getUserId()));
        zp9.e r50 = r29.w;
        if (r50 == null) goto L63;
        zp9.m r51 = r50.b;
        if (r51 == null) goto L63;
        if (r51.e() == true) goto L63;
    L64:
        r41.c.putExtra("ignore_tpl_info", r7);
        zp9.f r52 = r29.v;
        if (r52 == null) goto L67;
        Boolean r53 = Boolean.valueOf(r52.r);
    L68:
        r41.c.putExtra("open_new_chat_page_on_send", r53);
        zp9.f r54 = r29.v;
        if (r54 == null) goto L71;
        Integer r55 = r54.y;
    L72:
        r41.c.putExtra("creation_dosame_landing_type", r55);
        zp9.f r0 = r29.v;
        if (r0 == null) goto L75;
        r8 = r0.z;
    L75:
        r41.c.putExtra("is_send_from_detail", r8);
        r41.e(123);
        return;
    L71:
        r55 = null;
        goto L72
    L67:
        r53 = null;
    L63:
        r7 = false;
        goto L64
    L55:
        r49 = null;
        goto L56
    L51:
        r47 = null;
        goto L52
    L45:
        if (r29.C3() != 4) goto L47;
        r45 = true;
        goto L48
    L41:
        r44 = null;
        goto L42
    L37:
        r38 = null;
    L22:
        r10 = false;
    L11:
        r5 = null;
        goto L13
    }

    public static final Object p3(CreationFeedComponent r5, Long r6, Continuation r7) {
        r5.getClass();
        if ((r7 instanceof CreationFeedComponent$scrollToTopAndPerformRefresh$1) == false) goto L7;
        CreationFeedComponent$scrollToTopAndPerformRefresh$1 r0 = (CreationFeedComponent$scrollToTopAndPerformRefresh$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r8);
    L32:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r8);
    L26:
        CreationFeedAbilityImpl r9 = r5.B3();
        if (r9 == null) goto L32;
        r0.label = 2;
        if (r9.q("scrollToTopAndRefresh2", true) != r2) goto L32;
        return r2;
    L16:
        ResultKt.throwOnFailure(r8);
        RecyclerView r10 = r5.o.a();
        if (r10 != null) goto L20;
        return Unit.INSTANCE;
    L20:
        if (r10.computeVerticalScrollOffset() <= 0) goto L26;
        r5.E3(r6);
        RecyclerView r11 = r5.o.a();
        if (r11 == null) goto L26;
        r0.label = 1;
        if (ViewExtKt.c(r11, r0) != r2) goto L26;
        return r2;
    L7:
        r0 = new CreationFeedComponent$scrollToTopAndPerformRefresh$1(r5, r7);
        goto L8
    }

    public final void Q3(RecyclerView r26, boolean r27, boolean r28) {
        CreationFeedBehaviorTracker<b> r2 = this.E;
        Rect r3 = new Rect();
        IntRange r4 = RangesKt.until(0, r26.getChildCount());
        ArrayList r5 = new ArrayList();
        IntIterator r6 = r4.iterator();
    L3:
        Pair r7 = null;
        if (r6.hasNext() == false) goto L31;
        View r8 = r26.getChildAt(r6.nextInt());
        int r9 = r26.getChildAdapterPosition(r8);
        if (r9 != (-1)) goto L8;
    L29:
        if (r7 == null) goto L3;
        r5.add(r7);
        goto L3
    L8:
        if (r8.getGlobalVisibleRect(r3) == false) goto L29;
        if (r3.width() <= 0) goto L29;
        if (r3.height() <= 0) goto L29;
        if (this.p == null) goto L17;
        int r10 = r9 - 1;
    L18:
        CreationListAdapter r11 = this.s;
        if (r11 == null) goto L29;
        List<UserCreationModel> r12 = r11.b;
        if (r12 == null) goto L29;
        UserCreationModel r13 = (UserCreationModel) CollectionsKt.getOrNull(r12, r10);
        if (r13 == null) goto L29;
        List<UserCreation> r14 = r13.b();
        if (r14 == null) goto L29;
        UserCreation r15 = (UserCreation) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L29;
        r7 = TuplesKt.to(Integer.valueOf(r9), new b(r15, r10));
        goto L29
    L17:
        r10 = r9;
        goto L18
    L31:
        List r1 = CollectionsKt.sortedWith(r5, new a0());
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r17 = r1.iterator();
    L33:
        if (r17.hasNext() == false) goto L35;
        r16.add((b) ((Pair) r17.next()).getSecond());
        goto L33
    L35:
        CreationFeedBehaviorTracker.d r18 = r2.b(r16, r27, r28);
        Iterator r19 = r18.a.iterator();
    L37:
        if (r19.hasNext() == false) goto L88;
        b r20 = (b) r19.next();
        CreationListAdapter r21 = this.s;
        if (r21 == null) goto L41;
        UserCreation r22 = r20.a;
        Intrinsics.checkNotNullParameter(r22, "creation");
        UserCreationKmp r23 = r21.B2(r22);
    L42:
        CreationFeedAbilityImpl r24 = B3();
        if (r24 == null) goto L37;
        int r25 = r20.b;
        Intrinsics.checkNotNullParameter(r23, "item");
        m0a.h r29 = r24.d;
        if (r29 == null) goto L37;
        o0a.a r30 = r29.R0();
        if (r30 == null) goto L37;
        CreationFeedInitParamsKmp r31 = r24.c;
        if (r31 == null) goto L51;
        CreationFeedTrackParamsKmp r32 = r31.getTrackParams();
    L52:
        UserCreationTrackParamsKmp r33 = r23.getClientTrackParams();
        if (r33 == null) goto L56;
        String r34 = r33.getBotId();
        if (r34 == null) goto L56;
    L58:
        String r35 = r34;
    L60:
        if (r32 == null) goto L62;
        String r110 = r32.getCurrentPage();
    L63:
        if (r32 == null) goto L65;
        String r111 = r32.getEnterMethod();
    L66:
        UserCreationTrackParamsKmp r36 = r23.getClientTrackParams();
        if (r36 == null) goto L69;
        Integer r112 = r36.getPageIndex();
    L70:
        if (r32 == null) goto L72;
        String r113 = r32.getPreviousPage();
    L73:
        if (r32 == null) goto L76;
        String r37 = r32.getAiCreationRecommendFrom();
        if (r37 == null) goto L76;
    L78:
        String r114 = r37;
    L80:
        if (r32 == null) goto L82;
        String r115 = r32.getRecommendFrom();
    L83:
        String r116 = r23.getCreationId();
        String r117 = r23.getCreationTraceInfo();
        UserCreationTrackParamsKmp r38 = r23.getClientTrackParams();
        if (r38 == null) goto L86;
        String r118 = r38.getLogId();
    L87:
        r30.f(new MobSessionSlideParamsKmp(r35, r110, r111, r112, r113, r114, r115, r116, r117, r118, z0a.a.c(r23), z0a.a.d(r23), z0a.a.e(r23)));
        goto L37
    L86:
        r118 = null;
        goto L87
    L82:
        r115 = null;
    L76:
        if (r32 == null) goto L79;
        r37 = r32.getRecommendFrom();
        goto L78
    L79:
        r114 = null;
        goto L80
    L72:
        r113 = null;
        goto L73
    L69:
        r112 = null;
        goto L70
    L65:
        r111 = null;
        goto L66
    L62:
        r110 = null;
    L56:
        if (r32 == null) goto L59;
        r34 = r32.getBotId();
        goto L58
    L59:
        r35 = null;
        goto L60
    L51:
        r32 = null;
        goto L52
    L41:
        r23 = com.larus.ugc.feed.impl.mapper.c.b(r20.a);
        goto L42
    L88:
        Iterator r39 = r18.b.iterator();
    L90:
        if (r39.hasNext() == false) goto L141;
        CreationFeedBehaviorTracker.c r40 = (CreationFeedBehaviorTracker.c) r39.next();
        b r41 = (b) r40.a;
        CreationListAdapter r42 = this.s;
        if (r42 == null) goto L94;
        UserCreation r43 = r41.a;
        Intrinsics.checkNotNullParameter(r43, "creation");
        UserCreationKmp r44 = r42.B2(r43);
    L95:
        CreationFeedAbilityImpl r45 = B3();
        if (r45 == null) goto L90;
        int r46 = r41.b;
        long r47 = r40.b;
        Intrinsics.checkNotNullParameter(r44, "item");
        m0a.h r48 = r45.d;
        if (r48 == null) goto L90;
        o0a.a r49 = r48.R0();
        if (r49 == null) goto L90;
        CreationFeedInitParamsKmp r50 = r45.c;
        if (r50 == null) goto L104;
        CreationFeedTrackParamsKmp r51 = r50.getTrackParams();
    L105:
        UserCreationTrackParamsKmp r119 = r44.getClientTrackParams();
        if (r119 == null) goto L109;
        String r120 = r119.getBotId();
        if (r120 == null) goto L109;
    L111:
        String r121 = r120;
    L113:
        if (r51 == null) goto L115;
        String r122 = r51.getCurrentPage();
    L116:
        if (r51 == null) goto L118;
        String r123 = r51.getEnterMethod();
    L119:
        UserCreationTrackParamsKmp r124 = r44.getClientTrackParams();
        if (r124 == null) goto L122;
        Integer r125 = r124.getPageIndex();
    L123:
        if (r51 == null) goto L125;
        String r126 = r51.getPreviousPage();
    L126:
        if (r51 == null) goto L129;
        String r127 = r51.getAiCreationRecommendFrom();
        if (r127 == null) goto L129;
    L131:
        String r128 = r127;
    L133:
        if (r51 == null) goto L135;
        String r52 = r51.getRecommendFrom();
    L136:
        String r129 = r44.getCreationId();
        String r130 = r44.getCreationTraceInfo();
        UserCreationTrackParamsKmp r131 = r44.getClientTrackParams();
        if (r131 == null) goto L139;
        String r210 = r131.getLogId();
    L140:
        r49.c(new MobFeedStaytimeParamsKmp(r121, r122, r123, r125, r126, r128, r52, r129, r130, r210, z0a.a.c(r44), z0a.a.d(r44), z0a.a.e(r44), Long.valueOf(r47)));
        goto L90
    L139:
        r210 = null;
        goto L140
    L135:
        r52 = null;
    L129:
        if (r51 == null) goto L132;
        r127 = r51.getRecommendFrom();
        goto L131
    L132:
        r128 = null;
        goto L133
    L125:
        r126 = null;
        goto L126
    L122:
        r125 = null;
        goto L123
    L118:
        r123 = null;
        goto L119
    L115:
        r122 = null;
    L109:
        if (r51 == null) goto L112;
        r120 = r51.getBotId();
        goto L111
    L112:
        r121 = null;
        goto L113
    L104:
        r51 = null;
        goto L105
    L94:
        r44 = com.larus.ugc.feed.impl.mapper.c.b(r41.a);
        goto L95
    }

    @Override // zp9.l
    public final void L90(boolean r15, boolean r16, Long r17, boolean r18, boolean r19) {
        if (r18 == false) goto L7;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationFeedComponent$handleDataCheckAndRefresh$1(this, r19, r17, null), 3, null);
        return;
    L7:
        if (r15 == false) goto L10;
        if (r16 == false) goto L10;
        return;
    L10:
        if (r15 == false) goto L13;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationFeedComponent$scrollToTopAndRefresh$1(this, null), 3, null);
        return;
    L13:
        RecyclerView r1 = this.o.a();
        if (r1 == null) goto L27;
        SwipeRefreshLayout r6 = this.o.b();
        if (r6 != null) goto L20;
        return;
    L20:
        if (r6.isRefreshing() == false) goto L22;
        return;
    L22:
        if (r6.isEnabled() == false) goto L29;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationFeedComponent$performNormalScrollToTopAndRefresh$1(r1, this, r17, r16, r6, null), 3, null);
        return;
    L29:
        return;
    }
}
