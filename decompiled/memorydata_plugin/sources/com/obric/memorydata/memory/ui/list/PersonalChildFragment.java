package com.obric.memorydata.memory.ui.list;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Process;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.CombinedLoadStates;
import androidx.paging.LoadState;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms;
import androidx.paging.PagingSource;
import androidx.room.InvalidationTracker;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.entity.ig;
import com.obric.memorydata.database.entity.ih;
import com.obric.memorydata.database.entity.iq;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.databinding.FragmentMemoryPersonalChildBinding;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.tracker.PendingPersonalInfoTracker;
import com.obric.memorydata.memory.ui.detail.MemoryDetailActivity;
import com.obric.memorydata.memory.ui.feedback.MemoryFeedbackScene;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.BaseFragment;
import com.obric.oui.orecyclerview.widget.ConcatAdapter;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.segmentedtab.OBottomNavActionBar;
import com.obric.oui.segmentedtab.OBottomNavigationBar;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.bo;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u0091\u00012\u00020\u0001:\u0002\u0091\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u001a\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020H2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010R\u001a\u00020PH\u0016J\b\u0010S\u001a\u00020PH\u0016J\b\u0010T\u001a\u00020PH\u0016J\b\u0010U\u001a\u00020PH\u0002J\u0010\u0010V\u001a\u00020P2\u0006\u0010W\u001a\u000200H\u0002J\u0010\u0010X\u001a\u00020P2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J*\u0010Y\u001a\u00020P2\u0006\u0010Z\u001a\u00020H2\u0006\u0010[\u001a\u00020\\2\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010^H\u0002J\b\u0010i\u001a\u00020PH\u0002J\u0010\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020mH\u0002J\u0019\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020?0oH\u0000¢\u0006\u0002\bpJ\r\u0010q\u001a\u00020PH\u0000¢\u0006\u0002\brJ\u0010\u0010s\u001a\u00020P2\u0006\u0010[\u001a\u00020\\H\u0002J\u0010\u0010t\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020uH\u0002J\u0010\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020?H\u0002J\u0010\u0010y\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020uH\u0002J\b\u0010z\u001a\u00020PH\u0002J\u0010\u0010{\u001a\u00020#2\u0006\u0010|\u001a\u00020}H\u0002J\u0011\u0010~\u001a\u00020P2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\t\u0010\u0081\u0001\u001a\u00020PH\u0002J\u0013\u0010\u0082\u0001\u001a\u00020P2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\u0013\u0010\u0085\u0001\u001a\u00020\u001e2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0002J\t\u0010\u0088\u0001\u001a\u00020\u001eH\u0002J\t\u0010\u0089\u0001\u001a\u00020\u001eH\u0002J\u0012\u0010\u008a\u0001\u001a\u00020P2\u0007\u0010\u008b\u0001\u001a\u00020\u001eH\u0002J\u0012\u0010\u008c\u0001\u001a\u00020P2\u0007\u0010\u008b\u0001\u001a\u00020\u001eH\u0002J\u0012\u0010\u008d\u0001\u001a\u00020\u001e2\u0007\u0010\u008e\u0001\u001a\u00020\u001eH\u0002J\t\u0010\u008f\u0001\u001a\u00020PH\u0016J\t\u0010\u0090\u0001\u001a\u00020PH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b\"\u0010$R\u001b\u0010&\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u000b\u001a\u0004\b'\u0010 R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010<R\u0010\u0010=\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010D\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010_\u001a\u001f\u0012\u0013\u0012\u00110a¢\u0006\f\bb\u0012\b\bc\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020P\u0018\u00010`X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010h¨\u0006\u0092\u0001"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalChildFragment;", "Lcom/obric/memorydata/ui/BaseFragment;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/FragmentMemoryPersonalChildBinding;", "viewModel", "Lcom/obric/memorydata/memory/ui/list/PersonalChildViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/list/PersonalChildViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "shareViewModel", "Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "getShareViewModel", "()Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "shareViewModel$delegate", "pendingPersonalInfoViewModel", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoViewModel;", "getPendingPersonalInfoViewModel", "()Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoViewModel;", "pendingPersonalInfoViewModel$delegate", PersonalChildFragment.ARG_POSITION, "", "getPosition", "()I", "position$delegate", "memoryTab", "Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "tagType", "", "getTagType", "()Ljava/lang/String;", "tagType$delegate", "isAllTag", "", "()Z", "isAllTag$delegate", "selectionTabKey", "getSelectionTabKey", "selectionTabKey$delegate", "groupListAdapter", "Lcom/obric/memorydata/memory/ui/list/PersonalGroupListAdapter;", "pendingPreviewAdapter", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoPreviewAdapter;", "pendingConfirmationSheet", "Lcom/obric/memorydata/memory/ui/list/PendingConfirmationSheet;", "jumpTargetEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "viewPager", "Lcom/obric/oui/viewpager2/widget/ViewPager2;", "needRefreshOnStart", "recyclerViewInterceptor", "Lcom/obric/memorydata/memory/ui/ConflictWithViewPage2Handler;", "isMigrating", "migrationProgress", "isRefreshLoading", "lastEmptyStateLogKey", "lastLoadStateLogKey", "lastDbCountLogValue", "Ljava/lang/Integer;", "lastVisibleWindowLogKey", "loadGenerationId", "", "viewGenerationId", "isViewDestroyed", "pagingJob", "Lkotlinx/coroutines/Job;", "currentPagingSourceRef", "Ljava/lang/ref/WeakReference;", "Lcom/obric/memorydata/memory/ui/list/SemanticMemoryPagingSource;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onResume", "onStop", "setupRecyclerView", "scrollToItemIfNeeded", "entity", "scrollToTargetPosition", "showPopupMenu", "anchor", "item", "Lcom/obric/memorydata/memory/ui/list/PersonalListItem$Content;", "onDismiss", "Lkotlin/Function0;", "onItemDislike", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "memoryItem", "getOnItemDislike", "()Lkotlin/jvm/functions/Function1;", "setOnItemDislike", "(Lkotlin/jvm/functions/Function1;)V", "loadGroupedData", "convertToContentItem", "Lcom/obric/memorydata/memory/ui/list/PersonalListItem;", "dbPojo", "Lcom/obric/memorydata/database/entity/SemanticMemoryWithRelevantPojo;", "displayedSemanticVersions", "", "displayedSemanticVersions$memory_obricRelease", "refreshFormalItems", "refreshFormalItems$memory_obricRelease", "deleteFormalItem", "extractTagPath", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "memoryDay", "Ljava/time/LocalDate;", "timestamp", "resolveDisplayText", "observeData", "clipPendingPreviewVisibleBounds", "rect", "Landroid/graphics/Rect;", "renderPendingPersonalInfo", "state", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoUiState;", "updateEmptyState", "logLoadStateIfNeeded", "loadStates", "Landroidx/paging/CombinedLoadStates;", "loadStateName", "loadState", "Landroidx/paging/LoadState;", "buildAdapterSnapshot", "buildOwnerSnapshot", "scheduleVisibleWindowProbe", InfoRequestQPSOptTraceLogger.REASON, "logVisibleWindow", "generateKey", LocationMonitorConst.TAG, "onDestroy", "onDestroyView", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonalChildFragment extends BaseFragment {
    private static final String ARG_POSITION = "position";
    public static final a Companion = null;
    private static final int INITIAL_LOAD_SIZE = 60;
    private static final int PAGE_SIZE = 30;
    private static final String TAG = "PersonalChildFragment";
    private FragmentMemoryPersonalChildBinding binding;
    private WeakReference<SemanticMemoryPagingSource> currentPagingSourceRef;
    private PersonalGroupListAdapter groupListAdapter;
    private final Lazy isAllTag$delegate;
    private boolean isMigrating;
    private boolean isRefreshLoading;
    private boolean isViewDestroyed;
    private AppEntity jumpTargetEntity;
    private Integer lastDbCountLogValue;
    private String lastEmptyStateLogKey;
    private String lastLoadStateLogKey;
    private String lastVisibleWindowLogKey;
    private long loadGenerationId;
    private final MemoryTab memoryTab;
    private int migrationProgress;
    private boolean needRefreshOnStart;
    private Function1<? super com.obric.memorydata.memory.ui.data.a, Unit> onItemDislike;
    private bx pagingJob;
    private ap pendingConfirmationSheet;
    private final Lazy pendingPersonalInfoViewModel$delegate;
    private av pendingPreviewAdapter;
    private final Lazy position$delegate;
    private com.obric.memorydata.memory.ui.a recyclerViewInterceptor;
    private final Lazy selectionTabKey$delegate;
    private final Lazy shareViewModel$delegate;
    private final Lazy tagType$delegate;
    private long viewGenerationId;
    private final Lazy viewModel$delegate;
    private ViewPager2 viewPager;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalChildFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_POSITION", "PAGE_SIZE", "", "INITIAL_LOAD_SIZE", "newInstance", "Lcom/obric/memorydata/memory/ui/list/PersonalChildFragment;", PersonalChildFragment.ARG_POSITION, "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final PersonalChildFragment a(int r3) {
            PersonalChildFragment r2 = new PersonalChildFragment();
            Bundle r0 = new Bundle();
            r0.putInt(PersonalChildFragment.ARG_POSITION, r3);
            r2.setArguments(r0);
            return r2;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11072a = null;

        static {
            int[] r0 = new int[PersonalEmptyStatePolicy.State.values().length];
            r0[PersonalEmptyStatePolicy.State.MIGRATING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PersonalEmptyStatePolicy.State.UPDATING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PersonalEmptyStatePolicy.State.CONTENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PersonalEmptyStatePolicy.State.EMPTY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f11072a = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$deleteFormalItem$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$deleteFormalItem$1", f = "PersonalChildFragment.kt", i = {}, l = {643}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ bc.a $item;
        int label;
        final /* synthetic */ PersonalChildFragment this$0;

        AnonymousClass1(PersonalChildFragment r3, bc.a r4, Continuation<? super AnonymousClass1> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$item = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$item, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin");
            if (r9 == null) goto L17;
            this.this$0.refreshFormalItems$memory_obricRelease();
            Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L17;
            PersonalChildFragment r7 = this.this$0;
            com.obric.oui.toast.a.C0786a r3 = com.obric.oui.toast.a.f14807a;
            String r4 = r7.getString(r9.intValue());
            Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
            com.obric.oui.toast.a.C0786a.a(r3, r2, r4, 0, 4, null);
        L17:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            CoroutineContext r10 = (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r5 = (Function2) ZeusTransformUtils.preCheckCast(new PersonalChildFragment$deleteFormalItem$1$errorMessage$1(this.$item, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r8 = kotlinx.coroutines.i.a(r10, r5, r6);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$1", f = "PersonalChildFragment.kt", i = {}, l = {549}, m = "invokeSuspend", n = {}, s = {})
    static final class C11701 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ SemanticMemoryDao $dao;
        final /* synthetic */ String $dbSemanticType;
        final /* synthetic */ long $generationId;
        final /* synthetic */ InvalidationTracker $invalidationTracker;
        final /* synthetic */ Executor $ioExecutor;
        int label;
        final /* synthetic */ PersonalChildFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$1$1", f = "PersonalChildFragment.kt", i = {}, l = {555}, m = "invokeSuspend", n = {}, s = {})
        static final class C05771 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
            final /* synthetic */ long $generationId;
            final /* synthetic */ kotlinx.coroutines.flow.i<PagingData<bc>> $pagingFlow;
            int label;
            final /* synthetic */ PersonalChildFragment this$0;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "pagingData", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/memory/ui/list/PersonalListItem;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$1$1$1", f = "PersonalChildFragment.kt", i = {}, l = {562}, m = "invokeSuspend", n = {}, s = {})
            static final class C05781 extends SuspendLambda implements Function2<PagingData<bc>, Continuation<? super Unit>, Object> {
                final /* synthetic */ long $generationId;
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ PersonalChildFragment this$0;

                C05781(PersonalChildFragment r3, long r4, Continuation<? super C05781> r6) {
                    Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
                    this.this$0 = r3;
                    this.$generationId = r4;
                    super(2, r7);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r6, Continuation<?> r7) {
                    Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                    C05781 r0 = new C05781(this.this$0, this.$generationId, r8);
                    r0.L$0 = r6;
                    return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(PagingData<bc> r3, Continuation<? super Unit> r4) {
                    return ((C05781) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05781.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Object invoke(PagingData<bc> r3, Continuation<? super Unit> r4) {
                    return invoke2((PagingData) ZeusTransformUtils.preCheckCast(r3, PagingData.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r18) {
                    Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r2 = this.label;
                    Long r7 = null;
                    if (r2 == 0) goto L11;
                    if (r2 != 1) goto L10;
                    ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L7
                L24:
                    IRunLog r10 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                    StringBuilder r1 = new StringBuilder().append("[MEM] ").append(PersonalChildFragment.access$getTagType(this.this$0)).append(" SUBMIT_RETURN gen=").append(this.$generationId).append(" source=");     // Catch: Throwable -> L7
                    WeakReference r3 = PersonalChildFragment.access$getCurrentPagingSourceRef$p(this.this$0);     // Catch: Throwable -> L7
                    if (r3 == null) goto L29;
                    SemanticMemoryPagingSource r4 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r3.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                    if (r4 == null) goto L29;
                    Long r5 = Boxing.boxLong(r4.debugId());     // Catch: Throwable -> L7
                L30:
                    IRunLog.a.a(r10, PersonalChildFragment.TAG, r1.append(r5).append(' ').append(PersonalChildFragment.access$buildOwnerSnapshot(this.this$0)).append(' ').append(PersonalChildFragment.access$buildAdapterSnapshot(this.this$0)).toString(), false, 4, null);     // Catch: Throwable -> L7
                    IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
                    StringBuilder r6 = new StringBuilder().append("[MEM] ").append(PersonalChildFragment.access$getTagType(this.this$0)).append(" SUBMIT_FINALLY gen=").append(this.$generationId).append(" source=");
                    WeakReference r8 = PersonalChildFragment.access$getCurrentPagingSourceRef$p(this.this$0);
                    if (r8 == null) goto L36;
                    SemanticMemoryPagingSource r9 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r8.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
                    if (r9 == null) goto L36;
                    r7 = Boxing.boxLong(r9.debugId());
                L36:
                    IRunLog.a.a(r11, PersonalChildFragment.TAG, r6.append(r7).append(' ').append(PersonalChildFragment.access$buildOwnerSnapshot(this.this$0)).append(' ').append(PersonalChildFragment.access$buildAdapterSnapshot(this.this$0)).toString(), false, 4, null);
                    AppEntity r12 = PersonalChildFragment.access$getJumpTargetEntity$p(this.this$0);
                    if (r12 == null) goto L40;
                    PersonalChildFragment.access$scrollToItemIfNeeded(this.this$0, r12);
                L40:
                    return Unit.INSTANCE;
                L29:
                    r5 = null;
                    goto L30
                L10:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L11:
                    ResultKt.throwOnFailure(r18);
                    PagingData r13 = (PagingData) ZeusTransformUtils.preCheckCast(this.L$0, PagingData.class, "com.obric.memorydata.plugin");
                    IRunLog r14 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
                    StringBuilder r15 = new StringBuilder().append("[MEM] ").append(PersonalChildFragment.access$getTagType(this.this$0)).append(" SUBMIT_START gen=").append(this.$generationId).append(" source=");
                    WeakReference r16 = PersonalChildFragment.access$getCurrentPagingSourceRef$p(this.this$0);
                    if (r16 == null) goto L16;
                    SemanticMemoryPagingSource r17 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r16.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
                    if (r17 == null) goto L16;
                    Long r19 = Boxing.boxLong(r17.debugId());
                L17:
                    IRunLog.a.a(r14, PersonalChildFragment.TAG, r15.append(r19).append(' ').append(PersonalChildFragment.access$buildOwnerSnapshot(this.this$0)).append(' ').append(PersonalChildFragment.access$buildAdapterSnapshot(this.this$0)).toString(), false, 4, null);
                    PersonalGroupListAdapter r110 = PersonalChildFragment.access$getGroupListAdapter$p(this.this$0);     // Catch: Throwable -> L7
                    if (r110 != null) goto L21;
                    Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");     // Catch: Throwable -> L7
                    r110 = null;
                L21:
                    Continuation<? super Unit> r111 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                    this.label = 1;     // Catch: Throwable -> L7
                    if (r110.a(r13, r111) != r0) goto L24;
                    return r0;
                L16:
                    r19 = null;
                L7:
                    th = move-exception;
                    IRunLog r112 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
                    StringBuilder r20 = new StringBuilder().append("[MEM] ").append(PersonalChildFragment.access$getTagType(this.this$0)).append(" SUBMIT_FINALLY gen=").append(this.$generationId).append(" source=");
                    WeakReference r21 = PersonalChildFragment.access$getCurrentPagingSourceRef$p(this.this$0);
                    if (r21 == null) goto L46;
                    SemanticMemoryPagingSource r22 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r21.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
                    if (r22 == null) goto L46;
                    r7 = Boxing.boxLong(r22.debugId());
                L46:
                    IRunLog.a.a(r112, PersonalChildFragment.TAG, r20.append(r7).append(' ').append(PersonalChildFragment.access$buildOwnerSnapshot(this.this$0)).append(' ').append(PersonalChildFragment.access$buildAdapterSnapshot(this.this$0)).toString(), false, 4, null);
                    throw th;
                }
            }

            C05771(PersonalChildFragment r3, long r4, kotlinx.coroutines.flow.i<PagingData<bc>> r6, Continuation<? super C05771> r7) {
                kotlinx.coroutines.flow.i<PagingData<bc>> r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                this.$generationId = r4;
                this.$pagingFlow = r8;
                super(2, r9);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C05771(this.this$0, this.$generationId, this.$pagingFlow, r6), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
                return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
                return ((C05771) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05771.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.Object, kotlin.Unit] */
            /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r6v5, types: [com.obric.memorydata.middleware.api.log.IRunLog] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r14) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                String r6 = "com.obric.memorydata.plugin";
                if (r1 == 0) goto L11;
                if (r1 != 1) goto L10;
                ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L7
            L15:
                r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
                IRunLog.a.a(r6, PersonalChildFragment.TAG, "[MEM][PagingLifecycle] " + PersonalChildFragment.access$getTagType(this.this$0) + " COLLECTOR_STOP gen=" + this.$generationId + ' ' + PersonalChildFragment.access$buildOwnerSnapshot(this.this$0), false, 4, null);
                C05771 this = Unit.INSTANCE;
                return this;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                ResultKt.throwOnFailure(r14);
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), PersonalChildFragment.TAG, "[MEM][PagingLifecycle] " + PersonalChildFragment.access$getTagType(this.this$0) + " COLLECTOR_START gen=" + this.$generationId + ' ' + PersonalChildFragment.access$buildOwnerSnapshot(this.this$0), false, 4, null);
                kotlinx.coroutines.flow.i<PagingData<bc>> r15 = this.$pagingFlow;     // Catch: Throwable -> L7
                Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C05781(this.this$0, this.$generationId, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
                this.label = 1;     // Catch: Throwable -> L7
                if (kotlinx.coroutines.flow.k.a(r15, r2, r7) != r0) goto L15;
                return r0;
            L7:
                th = move-exception;
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r6), PersonalChildFragment.TAG, "[MEM][PagingLifecycle] " + PersonalChildFragment.access$getTagType(this.this$0) + " COLLECTOR_STOP gen=" + this.$generationId + ' ' + PersonalChildFragment.access$buildOwnerSnapshot(this.this$0), false, 4, null);
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$1$a */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements kotlinx.coroutines.flow.i<PagingData<bc>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i f11073a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PersonalChildFragment f11074b;
            final /* synthetic */ long c;
            final /* synthetic */ Executor d;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$1$a$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
            public static final class C05791<T> implements kotlinx.coroutines.flow.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.j f11075a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ PersonalChildFragment f11076b;
                final /* synthetic */ long c;
                final /* synthetic */ Executor d;

                public C05791(kotlinx.coroutines.flow.j r3, PersonalChildFragment r4, long r5, Executor r7) {
                    kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                    Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r7, Executor.class, "com.obric.memorydata.plugin");
                    this.f11075a = r6;
                    this.f11076b = r4;
                    this.c = r5;
                    this.d = r8;
                }

                @Override // kotlinx.coroutines.flow.j
                public final Object emit(Object r12, Continuation r13) {
                    Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
                    if (ZeusTransformUtils.instanceOf(r14, PersonalChildFragment$loadGroupedData$1$invokeSuspend$$inlined$map$1$2$1.class) == false) goto L7;
                    PersonalChildFragment$loadGroupedData$1$invokeSuspend$$inlined$map$1$2$1 r0 = (PersonalChildFragment$loadGroupedData$1$invokeSuspend$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r14, PersonalChildFragment$loadGroupedData$1$invokeSuspend$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                    if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                    r0.label -= Integer.MIN_VALUE;
                L8:
                    Object r15 = r0.result;
                    Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r3 = r0.label;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    ResultKt.throwOnFailure(r15);
                L24:
                    return Unit.INSTANCE;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    ResultKt.throwOnFailure(r15);
                    kotlinx.coroutines.flow.j r16 = this.f11075a;
                    Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                    PagingData r17 = (PagingData) ZeusTransformUtils.preCheckCast(r12, PagingData.class, "com.obric.memorydata.plugin");
                    IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
                    StringBuilder r6 = new StringBuilder().append("[MEM] ").append(PersonalChildFragment.access$getTagType(this.f11076b)).append(" MAP_CONTENT gen=").append(this.c).append(" source=");
                    WeakReference r7 = PersonalChildFragment.access$getCurrentPagingSourceRef$p(this.f11076b);
                    if (r7 == null) goto L19;
                    SemanticMemoryPagingSource r8 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r7.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
                    if (r8 == null) goto L19;
                    Long r9 = Boxing.boxLong(r8.debugId());
                L20:
                    IRunLog.a.a(r5, PersonalChildFragment.TAG, r6.append(r9).toString(), false, 4, null);
                    PagingData r11 = PagingDataTransforms.map(r17, this.d, (Function1) ZeusTransformUtils.preCheckCast(new c(this.f11076b), Function1.class, "com.obric.memorydata.plugin"));
                    r0.label = 1;
                    if (r16.emit(r11, r0) != r2) goto L24;
                    return r2;
                L19:
                    r9 = null;
                L7:
                    r0 = new PersonalChildFragment$loadGroupedData$1$invokeSuspend$$inlined$map$1$2$1(this, r14);
                    goto L8
                }
            }

            public a(kotlinx.coroutines.flow.i r3, PersonalChildFragment r4, long r5, Executor r7) {
                kotlinx.coroutines.flow.i r6 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
                Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r7, Executor.class, "com.obric.memorydata.plugin");
                this.f11073a = r6;
                this.f11074b = r4;
                this.c = r5;
                this.d = r8;
            }

            @Override // kotlinx.coroutines.flow.i
            public Object collect(kotlinx.coroutines.flow.j<? super PagingData<bc>> r9, Continuation r10) {
                kotlinx.coroutines.flow.j r3 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Continuation<? super Unit> r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
                Object r8 = this.f11073a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05791(r3, this.f11074b, this.c, this.d), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r11);
                if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r8;
            L6:
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$1$b */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b implements kotlinx.coroutines.flow.i<PagingData<bc>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i f11077a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PersonalChildFragment f11078b;
            final /* synthetic */ long c;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$1$b$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
            public static final class C05801<T> implements kotlinx.coroutines.flow.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.j f11079a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ PersonalChildFragment f11080b;
                final /* synthetic */ long c;

                public C05801(kotlinx.coroutines.flow.j r3, PersonalChildFragment r4, long r5) {
                    this.f11079a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                    this.f11080b = r4;
                    this.c = r5;
                }

                @Override // kotlinx.coroutines.flow.j
                public final Object emit(Object r13, Continuation r14) {
                    Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
                    if (ZeusTransformUtils.instanceOf(r15, PersonalChildFragment$loadGroupedData$1$invokeSuspend$$inlined$map$2$2$1.class) == false) goto L7;
                    PersonalChildFragment$loadGroupedData$1$invokeSuspend$$inlined$map$2$2$1 r0 = (PersonalChildFragment$loadGroupedData$1$invokeSuspend$$inlined$map$2$2$1) ZeusTransformUtils.preCheckCast(r15, PersonalChildFragment$loadGroupedData$1$invokeSuspend$$inlined$map$2$2$1.class, "com.obric.memorydata.plugin");
                    if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                    r0.label -= Integer.MIN_VALUE;
                L8:
                    Object r16 = r0.result;
                    Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r3 = r0.label;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    ResultKt.throwOnFailure(r16);
                L28:
                    return Unit.INSTANCE;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    ResultKt.throwOnFailure(r16);
                    kotlinx.coroutines.flow.j r17 = this.f11079a;
                    Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                    PagingData r18 = (PagingData) ZeusTransformUtils.preCheckCast(r13, PagingData.class, "com.obric.memorydata.plugin");
                    IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
                    StringBuilder r6 = new StringBuilder().append("[MEM] ").append(PersonalChildFragment.access$getTagType(this.f11080b)).append(" MAP_SEPARATORS gen=").append(this.c).append(" source=");
                    WeakReference r7 = PersonalChildFragment.access$getCurrentPagingSourceRef$p(this.f11080b);
                    if (r7 == null) goto L19;
                    SemanticMemoryPagingSource r8 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r7.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
                    if (r8 == null) goto L19;
                    Long r9 = Boxing.boxLong(r8.debugId());
                L20:
                    IRunLog.a.a(r5, PersonalChildFragment.TAG, r6.append(r9).toString(), false, 4, null);
                    if (PersonalChildFragment.access$isAllTag(this.f11080b) == false) goto L23;
                    Object r10 = new PersonalChildFragment$loadGroupedData$1$pagingFlow$6$1(this.f11080b, null);
                L24:
                    PagingData r12 = PagingDataTransforms.insertSeparators$default(r18, null, (Function3) ZeusTransformUtils.preCheckCast(r10, Function3.class, "com.obric.memorydata.plugin"), 1, null);
                    r0.label = 1;
                    if (r17.emit(r12, r0) != r2) goto L28;
                    return r2;
                L23:
                    r10 = new PersonalChildFragment$loadGroupedData$1$pagingFlow$6$2(this.f11080b, null);
                L19:
                    r9 = null;
                L7:
                    r0 = new PersonalChildFragment$loadGroupedData$1$invokeSuspend$$inlined$map$2$2$1(this, r15);
                    goto L8
                }
            }

            public b(kotlinx.coroutines.flow.i r3, PersonalChildFragment r4, long r5) {
                this.f11077a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
                this.f11078b = r4;
                this.c = r5;
            }

            @Override // kotlinx.coroutines.flow.i
            public Object collect(kotlinx.coroutines.flow.j<? super PagingData<bc>> r7, Continuation r8) {
                kotlinx.coroutines.flow.j r9 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r7, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Continuation<? super Unit> r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                Object r6 = this.f11077a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05801(r9, this.f11078b, this.c), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r10);
                if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r6;
            L6:
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$1$c */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class c implements Function1<ih, bc> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ PersonalChildFragment f11081a;

            c(PersonalChildFragment r1) {
                this.f11081a = r1;
            }

            public final bc a(ih r2) {
                Intrinsics.checkNotNullParameter(r2, "dbEntity");
                bc r1 = PersonalChildFragment.access$convertToContentItem(this.f11081a, r2);
                Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.memorydata.memory.ui.list.PersonalListItem");
                return r1;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ bc invoke(ih r3) {
                return a((ih) ZeusTransformUtils.preCheckCast(r3, ih.class, "com.obric.memorydata.plugin"));
            }
        }

        C11701(PersonalChildFragment r3, SemanticMemoryDao r4, String r5, InvalidationTracker r6, long r7, Executor r9, Continuation<? super C11701> r10) {
            SemanticMemoryDao r8 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r4, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Executor r11 = (Executor) ZeusTransformUtils.wrapperContextForParams(r9, Executor.class, "com.obric.memorydata.plugin");
            Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$dao = r8;
            this.$dbSemanticType = r5;
            this.$invalidationTracker = r6;
            this.$generationId = r7;
            this.$ioExecutor = r11;
            super(2, r12);
        }

        private static final PagingSource invokeSuspend$lambda$1(SemanticMemoryDao r12, String r13, InvalidationTracker r14, PersonalChildFragment r15, long r16) {
            SemanticMemoryPagingSource r0 = new SemanticMemoryPagingSource((SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r12, SemanticMemoryDao.class, "com.obric.memorydata.plugin"), r13, r14, 30, true, PersonalChildFragment.access$getTagType(r15), null, 64, null);
            PersonalChildFragment.access$setCurrentPagingSourceRef$p(r15, new WeakReference(r0));
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), PersonalChildFragment.TAG, "[MEM] " + PersonalChildFragment.access$getTagType(r15) + " pagingSource attached gen=" + r16 + " sid=" + r0.debugId() + " dbType=" + r13 + ' ' + PersonalChildFragment.access$buildOwnerSnapshot(r15) + ' ' + PersonalChildFragment.access$buildAdapterSnapshot(r15), false, 4, null);
            return (PagingSource) ZeusTransformUtils.preCheckCast(r0, PagingSource.class, "com.obric.memorydata.plugin");
        }

        public static /* synthetic */ PagingSource lambda$xmx3bVlz_eTcY_EG7Q8sWj4FtPk(SemanticMemoryDao r0, String r1, InvalidationTracker r2, PersonalChildFragment r3, long r4) {
            return invokeSuspend$lambda$1(r0, r1, r2, r3, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11701(this.this$0, this.$dao, this.$dbSemanticType, this.$invalidationTracker, this.$generationId, this.$ioExecutor, r9), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11701) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11701.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r15);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r15);
            PagingConfig r2 = new PagingConfig(30, 15, true, 60, Integer.MAX_VALUE, 0, 32, null);
            final SemanticMemoryDao r7 = this.$dao;
            final String r8 = this.$dbSemanticType;
            final InvalidationTracker r9 = this.$invalidationTracker;
            final PersonalChildFragment r10 = this.this$0;
            final long r11 = this.$generationId;
            kotlinx.coroutines.flow.i r16 = kotlinx.coroutines.flow.k.f(kotlinx.coroutines.flow.k.b(new Pager(r2, null, new $$Lambda$PersonalChildFragment$loadGroupedData$1$xmx3bVlz_eTcY_EG7Q8sWj4FtPk(r7, r8, r9, r10, r11), 2, null).getFlow(), (Function2) ZeusTransformUtils.preCheckCast(new PersonalChildFragment$loadGroupedData$1$pagingFlow$2(this.this$0, this.$generationId, null), Function2.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new PersonalChildFragment$loadGroupedData$1$pagingFlow$3(this.this$0, this.$generationId, null), Function2.class, "com.obric.memorydata.plugin"));
            LifecycleOwner r3 = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(r3, "getViewLifecycleOwner(...)");
            kotlinx.coroutines.flow.i r12 = kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new a(kotlinx.coroutines.flow.k.f(CachedPagingDataKt.cachedIn(r16, (kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r3), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new PersonalChildFragment$loadGroupedData$1$pagingFlow$4(this.this$0, this.$generationId, null), Function2.class, "com.obric.memorydata.plugin")), this.this$0, this.$generationId, this.$ioExecutor), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), this.this$0, this.$generationId), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new PersonalChildFragment$loadGroupedData$1$pagingFlow$7(this.this$0, this.$generationId, null), Function3.class, "com.obric.memorydata.plugin")), (Function3) ZeusTransformUtils.preCheckCast(new PersonalChildFragment$loadGroupedData$1$pagingFlow$8(this.this$0, this.$generationId, null), Function3.class, "com.obric.memorydata.plugin"));
            LifecycleOwner r17 = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(r17, "getViewLifecycleOwner(...)");
            Lifecycle.State r4 = z.f11341a.a();
            Function2 r5 = (Function2) ZeusTransformUtils.preCheckCast(new C05771(this.this$0, this.$generationId, r12, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r17, r4, r5, r6) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$3", f = "PersonalChildFragment.kt", i = {}, l = {601}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ SemanticMemoryDao $dao;
        int label;
        final /* synthetic */ PersonalChildFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", CommonConsts.COUNT_TYPE, ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$loadGroupedData$3$1", f = "PersonalChildFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
            /* synthetic */ int I$0;
            int label;
            final /* synthetic */ PersonalChildFragment this$0;

            AnonymousClass1(PersonalChildFragment r3, Continuation<? super AnonymousClass1> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
                r0.I$0 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue();
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            public final Object invoke(int r3, Continuation<? super Unit> r4) {
                Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(Integer.valueOf(r3), r5), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(Integer r3, Continuation<? super Unit> r4) {
                return invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r10) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L19;
                ResultKt.throwOnFailure(r10);
                int r11 = this.I$0;
                Integer r0 = PersonalChildFragment.access$getLastDbCountLogValue$p(this.this$0);
                if (r0 != null) goto L8;
            L9:
                PersonalChildFragment.access$setLastDbCountLogValue$p(this.this$0, Boxing.boxInt(r11));
                IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
                StringBuilder r1 = new StringBuilder().append("[MEM] ").append(PersonalChildFragment.access$getTagType(this.this$0)).append(" DB_COUNT count=").append(r11).append(" source=");
                WeakReference r2 = PersonalChildFragment.access$getCurrentPagingSourceRef$p(this.this$0);
                if (r2 == null) goto L14;
                SemanticMemoryPagingSource r4 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r2.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
                if (r4 == null) goto L14;
                Long r5 = Boxing.boxLong(r4.debugId());
            L15:
                IRunLog.a.a(r3, PersonalChildFragment.TAG, r1.append(r5).append(' ').append(PersonalChildFragment.access$buildAdapterSnapshot(this.this$0)).toString(), false, 4, null);
            L16:
                PersonalChildFragment.access$getShareViewModel(this.this$0).getSelectionManager().a(PersonalChildFragment.access$getSelectionTabKey(this.this$0), r11);
                return Unit.INSTANCE;
            L14:
                r5 = null;
                goto L15
            L8:
                if (r0.intValue() == r11) goto L16;
            L19:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass3(PersonalChildFragment r3, SemanticMemoryDao r4, Continuation<? super AnonymousClass3> r5) {
            SemanticMemoryDao r6 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r4, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$dao = r6;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, this.$dao, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            if (PersonalChildFragment.access$isAllTag(this.this$0) == false) goto L11;
            kotlinx.coroutines.flow.i<Integer> r8 = this.$dao.getInfoAllTypeMemoryCount();
        L12:
            kotlinx.coroutines.flow.i r9 = kotlinx.coroutines.flow.k.a(r8, (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r9, r2, r3) != r0) goto L16;
            return r0;
        L11:
            r8 = this.$dao.getCountBySemanticType(iq.a(PersonalChildFragment.access$getTagType(this.this$0)));
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$1", f = "PersonalChildFragment.kt", i = {}, l = {685}, m = "invokeSuspend", n = {}, s = {})
    static final class C11711 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonalChildFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$1$1", f = "PersonalChildFragment.kt", i = {}, l = {686}, m = "invokeSuspend", n = {}, s = {})
        static final class C05811 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ PersonalChildFragment this$0;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            /* synthetic */ class C05821 implements FunctionAdapter, kotlinx.coroutines.flow.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ PersonalChildFragment f11082a;

                C05821(PersonalChildFragment r1) {
                    this.f11082a = r1;
                }

                public final Object a(az r3, Continuation<? super Unit> r4) {
                    Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    Object r2 = C05811.access$invokeSuspend$renderPendingPersonalInfo(this.f11082a, r3, r5);
                    if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                    return r2;
                L6:
                    return Unit.INSTANCE;
                }

                @Override // kotlinx.coroutines.flow.j
                public /* synthetic */ Object emit(Object r3, Continuation r4) {
                    Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    return a((az) ZeusTransformUtils.preCheckCast(r3, az.class, "com.obric.memorydata.plugin"), r5);
                }

                public final boolean equals(Object r3) {
                    if (ZeusTransformUtils.instanceOf(r3, kotlinx.coroutines.flow.j.class) == true) goto L5;
                    return false;
                L5:
                    if (ZeusTransformUtils.instanceOf(r3, FunctionAdapter.class) == true) goto L7;
                    return false;
                L7:
                    return Intrinsics.areEqual(((FunctionAdapter) ZeusTransformUtils.preCheckCast(this, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate(), ((FunctionAdapter) ZeusTransformUtils.preCheckCast(r3, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate());
                }

                @Override // kotlin.jvm.internal.FunctionAdapter
                public final Function<?> getFunctionDelegate() {
                    return (Function) ZeusTransformUtils.preCheckCast(new AdaptedFunctionReference(2, this.f11082a, PersonalChildFragment.class, "renderPendingPersonalInfo", "renderPendingPersonalInfo(Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoUiState;)V", 4), Function.class, "com.obric.memorydata.plugin");
                }

                public final int hashCode() {
                    return ((FunctionAdapter) ZeusTransformUtils.preCheckCast(this, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate().hashCode();
                }
            }

            C05811(PersonalChildFragment r3, Continuation<? super C05811> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            public static final /* synthetic */ Object access$invokeSuspend$renderPendingPersonalInfo(PersonalChildFragment r2, az r3, Continuation r4) {
                return invokeSuspend$renderPendingPersonalInfo(r2, r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            private static final /* synthetic */ Object invokeSuspend$renderPendingPersonalInfo(PersonalChildFragment r2, az r3, Continuation r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                PersonalChildFragment.access$renderPendingPersonalInfo(r2, r3);
                return Unit.INSTANCE;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C05811(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
                return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
                return ((C05811) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05811.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                ResultKt.throwOnFailure(r6);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                kotlinx.coroutines.flow.ar<az> r7 = PersonalChildFragment.access$getPendingPersonalInfoViewModel(this.this$0).getUiState();
                kotlinx.coroutines.flow.j<? super az> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05821(this.this$0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                if (r7.collect(r2, r3) != r0) goto L12;
                return r0;
            }
        }

        C11711(PersonalChildFragment r3, Continuation<? super C11711> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11711(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11711) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11711.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            LifecycleOwner r8 = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(r8, "getViewLifecycleOwner(...)");
            Lifecycle.State r2 = Lifecycle.State.STARTED;
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new C05811(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$10, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$10", f = "PersonalChildFragment.kt", i = {}, l = {787}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass10 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonalChildFragment this$0;

        AnonymousClass10(PersonalChildFragment r3, Continuation<? super AnonymousClass10> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass10(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass10) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass10.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.ar<SelectionStateManager.SelectAllState> r7 = PersonalChildFragment.access$getShareViewModel(this.this$0).getSelectionManager().c();
            final PersonalChildFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super SelectionStateManager.SelectAllState> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$2", f = "PersonalChildFragment.kt", i = {}, l = {694}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonalChildFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", TypedValues.CycleType.S_WAVE_PHASE, ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$2$1", f = "PersonalChildFragment.kt", i = {}, l = {697}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ PersonalChildFragment this$0;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$2$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$2$1$1", f = "PersonalChildFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            static final class C05831 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Integer>, Object> {
                int label;

                C05831(Continuation<? super C05831> r3) {
                    super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
                    return (Continuation) ZeusTransformUtils.preCheckCast(new C05831((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Integer> r4) {
                    return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Integer> r4) {
                    return ((C05831) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05831.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r1) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L11;
                    ResultKt.throwOnFailure(r1);
                    SemanticMemoryDao r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao();
                    int r2 = r0.countMigrationTotal();
                    if (r2 != 0) goto L7;
                    int r3 = 0;
                L9:
                    return Boxing.boxInt(r3);
                L7:
                    r3 = (r0.countMigrationCompleted() * 100) / r2;
                    goto L9
                L11:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            AnonymousClass1(PersonalChildFragment r3, Continuation<? super AnonymousClass1> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(String r3, Continuation<? super Unit> r4) {
                return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(String r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r8) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                PersonalChildFragment r2 = (PersonalChildFragment) ZeusTransformUtils.preCheckCast(this.L$0, PersonalChildFragment.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r8);
            L14:
                PersonalChildFragment r6 = r2;
                int r3 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue();
                PersonalChildFragment r9 = r6;
            L16:
                PersonalChildFragment.access$setMigrationProgress$p(r9, r3);
                PersonalChildFragment.access$updateEmptyState(this.this$0);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r8);
                String r10 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
                PersonalChildFragment.access$setMigrating$p(this.this$0, com.obric.memorydata.database.manager.q.f9592a.a(r10));
                r9 = this.this$0;
                if (PersonalChildFragment.access$isMigrating$p(r9) == false) goto L15;
                CoroutineContext r4 = (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
                Function2 r5 = (Function2) ZeusTransformUtils.preCheckCast(new C05831(null), Function2.class, "com.obric.memorydata.plugin");
                Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.L$0 = r9;
                this.label = 1;
                Object r11 = kotlinx.coroutines.i.a(r4, r5, r7);
                if (r11 != r0) goto L13;
                return r0;
            L13:
                r2 = r9;
                r8 = r11;
                goto L14
            L15:
                r3 = 100;
                goto L16
            }
        }

        AnonymousClass2(PersonalChildFragment r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            kotlinx.coroutines.flow.i r8 = kotlinx.coroutines.flow.k.a(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticStateDao().observeText("migration_phase"), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$3", f = "PersonalChildFragment.kt", i = {}, l = {709}, m = "invokeSuspend", n = {}, s = {})
    static final class C11723 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonalChildFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "loadStates", "Landroidx/paging/CombinedLoadStates;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$3$1", f = "PersonalChildFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CombinedLoadStates, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ PersonalChildFragment this$0;

            AnonymousClass1(PersonalChildFragment r3, Continuation<? super AnonymousClass1> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CombinedLoadStates r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(CombinedLoadStates r3, Continuation<? super Unit> r4) {
                return invoke2((CombinedLoadStates) ZeusTransformUtils.preCheckCast(r3, CombinedLoadStates.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r5);
                CombinedLoadStates r6 = (CombinedLoadStates) ZeusTransformUtils.preCheckCast(this.L$0, CombinedLoadStates.class, "com.obric.memorydata.plugin");
                PersonalChildFragment.access$setRefreshLoading$p(this.this$0, ZeusTransformUtils.instanceOf(r6.getRefresh(), LoadState.Loading.class));
                PersonalChildFragment.access$logLoadStateIfNeeded(this.this$0, r6);
                if (ZeusTransformUtils.instanceOf(r6.getRefresh(), LoadState.Error.class) == false) goto L7;
                RunLog r0 = RunLog.INSTANCE;
                String r2 = "[MEM] " + PersonalChildFragment.access$getTagType(this.this$0) + " refresh_error";
                LoadState r7 = r6.getRefresh();
                Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type androidx.paging.LoadState.Error");
                r0.error(PersonalChildFragment.TAG, r2, ((LoadState.Error) ZeusTransformUtils.preCheckCast(r7, LoadState.Error.class, "com.obric.memorydata.plugin")).getError());
            L7:
                PersonalChildFragment.access$updateEmptyState(this.this$0);
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C11723(PersonalChildFragment r3, Continuation<? super C11723> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11723(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11723) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11723.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            PersonalGroupListAdapter r7 = PersonalChildFragment.access$getGroupListAdapter$p(this.this$0);
            if (r7 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
            r7 = null;
        L11:
            kotlinx.coroutines.flow.i<CombinedLoadStates> r8 = r7.e();
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$4", f = "PersonalChildFragment.kt", i = {}, l = {723}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonalChildFragment this$0;

        AnonymousClass4(PersonalChildFragment r3, Continuation<? super AnonymousClass4> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.ar<Boolean> r7 = PersonalChildFragment.access$getShareViewModel(this.this$0).getSelectionManager().b();
            final PersonalChildFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$5", f = "PersonalChildFragment.kt", i = {}, l = {735}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonalChildFragment this$0;

        AnonymousClass5(PersonalChildFragment r3, Continuation<? super AnonymousClass5> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass5) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass5.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.ar<SelectionStateManager.SelectAllState> r7 = PersonalChildFragment.access$getShareViewModel(this.this$0).getSelectionManager().c();
            final PersonalChildFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super SelectionStateManager.SelectAllState> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$6", f = "PersonalChildFragment.kt", i = {}, l = {748}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonalChildFragment this$0;

        AnonymousClass6(PersonalChildFragment r3, Continuation<? super AnonymousClass6> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass6) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass6.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.ar<Pair<MemoryTab, Pair<LocalDate, AppEntity>>> r7 = PersonalChildFragment.access$getShareViewModel(this.this$0).getTargetEntityFlow();
            final PersonalChildFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Pair<MemoryTab, Pair<LocalDate, AppEntity>>> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$7", f = "PersonalChildFragment.kt", i = {}, l = {760}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass7 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonalChildFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$7$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$7$1", f = "PersonalChildFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            /* synthetic */ boolean Z$0;
            int label;
            final /* synthetic */ PersonalChildFragment this$0;

            AnonymousClass1(PersonalChildFragment r3, Continuation<? super AnonymousClass1> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
                r0.Z$0 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(Boolean r3, Continuation<? super Unit> r4) {
                return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            public final Object invoke(boolean r3, Continuation<? super Unit> r4) {
                Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(Boolean.valueOf(r3), r5), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r4);
                boolean r5 = this.Z$0;
                RunLog r0 = RunLog.INSTANCE;
                StringBuilder r6 = new StringBuilder().append("[MEM] ").append(PersonalChildFragment.access$getTagType(this.this$0)).append(" correlationChange=").append(r5).append(" source=");
                WeakReference r3 = PersonalChildFragment.access$getCurrentPagingSourceRef$p(this.this$0);
                if (r3 == null) goto L9;
                SemanticMemoryPagingSource r7 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r3.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
                if (r7 == null) goto L9;
                Long r8 = Boxing.boxLong(r7.debugId());
            L10:
                r0.debug(PersonalChildFragment.TAG, r6.append(r8).toString());
                return Unit.INSTANCE;
            L9:
                r8 = null;
                goto L10
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass7(PersonalChildFragment r3, Continuation<? super AnonymousClass7> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass7(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass7) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass7.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(PersonalChildFragment.access$getShareViewModel(this.this$0).getMemoryCorrelationChangeFlow(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$8", f = "PersonalChildFragment.kt", i = {}, l = {768}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass8 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonalChildFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$8$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$8$1", f = "PersonalChildFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ PersonalChildFragment this$0;

            AnonymousClass1(PersonalChildFragment r3, Continuation<? super AnonymousClass1> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(Unit r3, Continuation<? super Unit> r4) {
                return invoke2((Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Unit r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r9) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L16;
                ResultKt.throwOnFailure(r9);
                if (Intrinsics.areEqual(MemoryListShareViewModel.getMixTab$default(PersonalChildFragment.access$getShareViewModel(this.this$0), null, 1, null), MemoryTab.PROFILE.getText()) == false) goto L14;
                if (Intrinsics.areEqual(PersonalChildFragment.access$getShareViewModel(this.this$0).getSelectedTag(), PersonalChildFragment.access$getTagType(this.this$0)) == false) goto L14;
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), PersonalChildFragment.TAG, "[MEM] " + PersonalChildFragment.access$getTagType(this.this$0) + " memoryDeleteFlow refresh", false, 4, null);
                WeakReference r8 = PersonalChildFragment.access$getCurrentPagingSourceRef$p(this.this$0);
                if (r8 == null) goto L14;
                SemanticMemoryPagingSource r10 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r8.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
                if (r10 == null) goto L14;
                r10.externalInvalidate("memoryDeleteFlow");
            L14:
                return Unit.INSTANCE;
            L16:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass8(PersonalChildFragment r3, Continuation<? super AnonymousClass8> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass8(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass8) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass8.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(PersonalChildFragment.access$getShareViewModel(this.this$0).getMemoryDeleteFlow(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$9, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$observeData$9", f = "PersonalChildFragment.kt", i = {}, l = {777}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass9 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonalChildFragment this$0;

        AnonymousClass9(PersonalChildFragment r3, Continuation<? super AnonymousClass9> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass9(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass9) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass9.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.ar<Integer> r7 = PersonalChildFragment.access$getShareViewModel(this.this$0).getSelectionManager().f();
            final PersonalChildFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Integer> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalChildFragment$showPopupMenu$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalChildFragment$showPopupMenu$1", f = "PersonalChildFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C11731 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ View $anchor;
        final /* synthetic */ boolean $isUpper;
        final /* synthetic */ bc.a $item;
        final /* synthetic */ com.obric.memorydata.memory.ui.data.a.h $memoryItem;
        final /* synthetic */ Function0<Unit> $onDismiss;
        int label;
        final /* synthetic */ PersonalChildFragment this$0;

        C11731(View r3, com.obric.memorydata.memory.ui.data.a.h r4, PersonalChildFragment r5, Function0<Unit> r6, boolean r7, bc.a r8, Continuation<? super C11731> r9) {
            Function0<Unit> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
            Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            this.$anchor = r3;
            this.$memoryItem = r4;
            this.this$0 = r5;
            this.$onDismiss = r10;
            this.$isUpper = r7;
            this.$item = r8;
            super(2, r11);
        }

        private static final Unit invokeSuspend$lambda$3(final PersonalChildFragment r6, final bc.a r7, com.obric.memorydata.memory.ui.data.a r8) {
            FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r0, "requireActivity(...)");
            com.obric.oui.dialog.v2.alert.a r9 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(r6.getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_title_single, TypedValues.Custom.S_STRING, "memory_card_delete_notice_title_single")), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a(null).a(true).b((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_cancel, TypedValues.Custom.S_STRING, "memory_card_delete_notice_cancel")), CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$PersonalChildFragment$showPopupMenu$1$aKkzLLBKakmYxD7D3lfVKw1Syi8.INSTANCE).a((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_confirm, TypedValues.Custom.S_STRING, "memory_card_delete_notice_confirm")), CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$PersonalChildFragment$showPopupMenu$1$qveG27kPIZCBLvZSiL5tBNtMPc(r6, r7)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
            r9.setCanceledOnTouchOutside(true);
            r9.setCancelable(true);
            r9.show();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$3$lambda$0(DialogInterface r1, int r2) {
            ((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.memorydata.plugin")).dismiss();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$3$lambda$1(PersonalChildFragment r6, bc.a r7, DialogInterface r8, int r9) {
            DialogInterface r10 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r8, DialogInterface.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), PersonalChildFragment.TAG, "[MEM] " + PersonalChildFragment.access$getTagType(r6) + " delete_confirm id=" + r7.a() + " text=" + com.obric.memorydata.utils.q.f13259a.b(r7.b()), false, 4, null);
            PersonalChildFragment.access$deleteFormalItem(r6, r7);
            r10.dismiss();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$4(PersonalChildFragment r8, bc.a r9, com.obric.memorydata.memory.ui.data.a r10) {
            PersonalChildFragment.access$getShareViewModel(r8).getSelectionManager().a(PersonalChildFragment.access$getSelectionTabKey(r8));
            PersonalChildFragment.access$getShareViewModel(r8).getSelectionManager().i();
            PersonalChildFragment.access$getShareViewModel(r8).getSelectionManager().a(new cu(r9.a(), NetError.ERR_CACHE_READ_FAILURE, "", null, 8, null), PersonalChildFragment.access$getSelectionTabKey(r8));
            PersonalGroupListAdapter r11 = PersonalChildFragment.access$getGroupListAdapter$p(r8);
            if (r11 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
            r11 = null;
        L5:
            r11.a();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$7(PersonalChildFragment r7, final com.obric.memorydata.memory.ui.data.a.h r8, com.obric.memorydata.memory.ui.data.a r9) {
            FragmentActivity r10 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r10, "requireActivity(...)");
            com.obric.memorydata.memory.ui.feedback.f.a(new com.obric.memorydata.memory.ui.feedback.f((Activity) ZeusTransformUtils.preCheckCast(r10, Activity.class, "com.obric.memorydata.plugin")), MemoryFeedbackScene.COLLECTION_OR_PROFILE, null, new $$Lambda$PersonalChildFragment$showPopupMenu$1$xhK28uwJ4x4bP9jGCuggzeyBtq0(r8), new $$Lambda$PersonalChildFragment$showPopupMenu$1$juPeYqA57zHRtgLbpYVfXUqhdUc(r8), 2, null);
            return Unit.INSTANCE;
        }

        private static final List invokeSuspend$lambda$7$lambda$5(com.obric.memorydata.memory.ui.data.a.h r3, String r4) {
            return com.obric.memorydata.memory.ui.feedback.e.f10935a.a((com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"), MemoryFeedbackScene.COLLECTION_OR_PROFILE, r4);
        }

        private static final com.obric.memorydata.memory.ui.feedback.h invokeSuspend$lambda$7$lambda$6(com.obric.memorydata.memory.ui.data.a.h r3) {
            return com.obric.memorydata.memory.ui.feedback.i.f10952a.a((com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: lambda$U3IHP2g5fmHrzrxd-nC2plWvALw, reason: not valid java name */
        public static /* synthetic */ Unit m908lambda$U3IHP2g5fmHrzrxdnC2plWvALw(PersonalChildFragment r0, com.obric.memorydata.memory.ui.data.a.h r1, com.obric.memorydata.memory.ui.data.a r2) {
            return invokeSuspend$lambda$7(r0, r1, r2);
        }

        public static /* synthetic */ Unit lambda$aKkzLLBKakmYxD7D3lfVKw1Syi8(DialogInterface r0, int r1) {
            return invokeSuspend$lambda$3$lambda$0(r0, r1);
        }

        /* JADX INFO: renamed from: lambda$h-tb0HqxIwF6-Veuv1u37z-QZtY, reason: not valid java name */
        public static /* synthetic */ Unit m909lambda$htb0HqxIwF6Veuv1u37zQZtY(PersonalChildFragment r0, bc.a r1, com.obric.memorydata.memory.ui.data.a r2) {
            return invokeSuspend$lambda$4(r0, r1, r2);
        }

        public static /* synthetic */ com.obric.memorydata.memory.ui.feedback.h lambda$juPeYqA57zHRtgLbpYVfXUqhdUc(com.obric.memorydata.memory.ui.data.a.h r0) {
            return invokeSuspend$lambda$7$lambda$6(r0);
        }

        public static /* synthetic */ Unit lambda$q5WzG8RYGA4bQUABxttSs3hIPEM(PersonalChildFragment r0, bc.a r1, com.obric.memorydata.memory.ui.data.a r2) {
            return invokeSuspend$lambda$3(r0, r1, r2);
        }

        /* JADX INFO: renamed from: lambda$qve-G27kPIZCBLvZSiL5tBNtMPc, reason: not valid java name */
        public static /* synthetic */ Unit m910lambda$qveG27kPIZCBLvZSiL5tBNtMPc(PersonalChildFragment r0, bc.a r1, DialogInterface r2, int r3) {
            return invokeSuspend$lambda$3$lambda$1(r0, r1, r2, r3);
        }

        public static /* synthetic */ List lambda$xhK28uwJ4x4bP9jGCuggzeyBtq0(com.obric.memorydata.memory.ui.data.a.h r0, String r1) {
            return invokeSuspend$lambda$7$lambda$5(r0, r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11731(this.$anchor, this.$memoryItem, this.this$0, this.$onDismiss, this.$isUpper, this.$item, r8), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11731) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11731.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r14);
            View r2 = this.$anchor;
            com.obric.memorydata.memory.ui.data.a r3 = (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(this.$memoryItem, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
            final PersonalChildFragment r0 = this.this$0;
            final bc.a r1 = this.$item;
            Function1 r5 = new $$Lambda$PersonalChildFragment$showPopupMenu$1$q5WzG8RYGA4bQUABxttSs3hIPEM(r0, r1);
            Function1<com.obric.memorydata.memory.ui.data.a, Unit> r6 = this.this$0.getOnItemDislike();
            final PersonalChildFragment r4 = this.this$0;
            final bc.a r7 = this.$item;
            Function1 r8 = new $$Lambda$PersonalChildFragment$showPopupMenu$1$htb0HqxIwF6Veuv1u37zQZtY(r4, r7);
            final PersonalChildFragment r9 = this.this$0;
            final com.obric.memorydata.memory.ui.data.a.h r10 = this.$memoryItem;
            com.obric.memorydata.memory.ui.g r15 = new com.obric.memorydata.memory.ui.g(r2, r3, null, r5, r6, r8, null, new $$Lambda$PersonalChildFragment$showPopupMenu$1$U3IHP2g5fmHrzrxdnC2plWvALw(r9, r10), this.$onDismiss, 68, null);
            if (this.$isUpper == false) goto L7;
            int r13 = 80;
        L8:
            r15.a(r13);
            return Unit.INSTANCE;
        L7:
            r13 = 48;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public PersonalChildFragment() {
        this.viewModel$delegate = LazyKt.lazy(new $$Lambda$PersonalChildFragment$KXhbwevUx57yvPffJF0NxTcT_k(this));
        this.shareViewModel$delegate = LazyKt.lazy(new $$Lambda$PersonalChildFragment$Mrtalr770ZkYWLmGjnMoQzvnjgE(this));
        this.pendingPersonalInfoViewModel$delegate = LazyKt.lazy(new $$Lambda$PersonalChildFragment$VZX2cfH17rjknze8jcRFvz5SG8(this));
        this.position$delegate = LazyKt.lazy(new $$Lambda$PersonalChildFragment$MD_E0VYhuU2vTY8j_lbORYmxT4(this));
        this.memoryTab = MemoryTab.PROFILE;
        this.tagType$delegate = LazyKt.lazy(new $$Lambda$PersonalChildFragment$vmhRv5ZoTrMt3osFKstDJXeLGU(this));
        this.isAllTag$delegate = LazyKt.lazy(new $$Lambda$PersonalChildFragment$LWQ34E0QcOniOIkoTmV4hfdmL80(this));
        this.selectionTabKey$delegate = LazyKt.lazy(new $$Lambda$PersonalChildFragment$sM_kNv_9QkQrSo9WCVQLRgq89MI(this));
        this.isMigrating = true;
        this.isRefreshLoading = true;
        this.isViewDestroyed = true;
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
        Function1<? super com.obric.memorydata.memory.ui.data.a, Unit> r0 = new $$Lambda$PersonalChildFragment$o2oL2H9PQ_gCmxb4BYELfgKWQaE(this);
    L6:
        this.onItemDislike = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static final /* synthetic */ String access$buildAdapterSnapshot(PersonalChildFragment r0) {
        return r0.buildAdapterSnapshot();
    }

    public static final /* synthetic */ String access$buildOwnerSnapshot(PersonalChildFragment r0) {
        return r0.buildOwnerSnapshot();
    }

    public static final /* synthetic */ boolean access$clipPendingPreviewVisibleBounds(PersonalChildFragment r0, Rect r1) {
        return r0.clipPendingPreviewVisibleBounds(r1);
    }

    public static final /* synthetic */ bc access$convertToContentItem(PersonalChildFragment r0, ih r1) {
        return r0.convertToContentItem(r1);
    }

    public static final /* synthetic */ void access$deleteFormalItem(PersonalChildFragment r0, bc.a r1) {
        r0.deleteFormalItem(r1);
    }

    public static final /* synthetic */ String access$extractTagPath(PersonalChildFragment r0, MemoryEntity r1) {
        return r0.extractTagPath(r1);
    }

    public static final /* synthetic */ WeakReference access$getCurrentPagingSourceRef$p(PersonalChildFragment r0) {
        return r0.currentPagingSourceRef;
    }

    public static final /* synthetic */ PersonalGroupListAdapter access$getGroupListAdapter$p(PersonalChildFragment r0) {
        return r0.groupListAdapter;
    }

    public static final /* synthetic */ AppEntity access$getJumpTargetEntity$p(PersonalChildFragment r0) {
        return r0.jumpTargetEntity;
    }

    public static final /* synthetic */ Integer access$getLastDbCountLogValue$p(PersonalChildFragment r0) {
        return r0.lastDbCountLogValue;
    }

    public static final /* synthetic */ PendingPersonalInfoViewModel access$getPendingPersonalInfoViewModel(PersonalChildFragment r0) {
        return r0.getPendingPersonalInfoViewModel();
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.a access$getRecyclerViewInterceptor$p(PersonalChildFragment r0) {
        return r0.recyclerViewInterceptor;
    }

    public static final /* synthetic */ String access$getSelectionTabKey(PersonalChildFragment r0) {
        return r0.getSelectionTabKey();
    }

    public static final /* synthetic */ MemoryListShareViewModel access$getShareViewModel(PersonalChildFragment r0) {
        return r0.getShareViewModel();
    }

    public static final /* synthetic */ String access$getTagType(PersonalChildFragment r0) {
        return r0.getTagType();
    }

    public static final /* synthetic */ boolean access$isAllTag(PersonalChildFragment r0) {
        return r0.isAllTag();
    }

    public static final /* synthetic */ boolean access$isMigrating$p(PersonalChildFragment r0) {
        return r0.isMigrating;
    }

    public static final /* synthetic */ void access$logLoadStateIfNeeded(PersonalChildFragment r0, CombinedLoadStates r1) {
        r0.logLoadStateIfNeeded(r1);
    }

    public static final /* synthetic */ LocalDate access$memoryDay(PersonalChildFragment r0, long r1) {
        return r0.memoryDay(r1);
    }

    public static final /* synthetic */ void access$renderPendingPersonalInfo(PersonalChildFragment r0, az r1) {
        r0.renderPendingPersonalInfo(r1);
    }

    public static final /* synthetic */ void access$scrollToItemIfNeeded(PersonalChildFragment r0, AppEntity r1) {
        r0.scrollToItemIfNeeded(r1);
    }

    public static final /* synthetic */ void access$setCurrentPagingSourceRef$p(PersonalChildFragment r0, WeakReference r1) {
        r0.currentPagingSourceRef = r1;
    }

    public static final /* synthetic */ void access$setJumpTargetEntity$p(PersonalChildFragment r0, AppEntity r1) {
        r0.jumpTargetEntity = r1;
    }

    public static final /* synthetic */ void access$setLastDbCountLogValue$p(PersonalChildFragment r0, Integer r1) {
        r0.lastDbCountLogValue = r1;
    }

    public static final /* synthetic */ void access$setMigrating$p(PersonalChildFragment r0, boolean r1) {
        r0.isMigrating = r1;
    }

    public static final /* synthetic */ void access$setMigrationProgress$p(PersonalChildFragment r0, int r1) {
        r0.migrationProgress = r1;
    }

    public static final /* synthetic */ void access$setRefreshLoading$p(PersonalChildFragment r0, boolean r1) {
        r0.isRefreshLoading = r1;
    }

    public static final /* synthetic */ void access$updateEmptyState(PersonalChildFragment r0) {
        r0.updateEmptyState();
    }

    private final String buildAdapterSnapshot() {
        PersonalGroupListAdapter r0 = this.groupListAdapter;
        FragmentMemoryPersonalChildBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
        r0 = null;
    L5:
        int r1 = r0.d();
        if (AppContext.INSTANCE.isDebug() == true) goto L16;
        StringBuilder r3 = new StringBuilder().append("items=").append(r1).append(" rv=");
        FragmentMemoryPersonalChildBinding r4 = this.binding;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L10:
        StringBuilder r5 = r3.append(r4.rvMemoryList.getVisibility()).append(" empty=");
        FragmentMemoryPersonalChildBinding r14 = this.binding;
        if (r14 != null) goto L13;
    L12:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        return r5.append(r2.layoutEmpty.getVisibility()).toString();
    L13:
        r2 = r14;
        goto L15
    L16:
        int r6 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
    L17:
        if (r6 >= r1) goto L32;
        PersonalGroupListAdapter r11 = this.groupListAdapter;
        if (r11 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
        r11 = null;
    L21:
        bc r12 = (bc) ZeusTransformUtils.preCheckCast(r11.d(r6), bc.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, bc.a.class) == false) goto L25;
        r8 = r8 + 1;
    L29:
        r6 = r6 + 1;
        goto L17
    L25:
        if (ZeusTransformUtils.instanceOf(r12, bc.b.class) == false) goto L27;
        r9 = r9 + 1;
        goto L29
    L27:
        if (r12 != null) goto L31;
        r10 = r10 + 1;
        goto L29
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        StringBuilder r7 = new StringBuilder().append("items=").append(r1).append(" content=").append(r8).append(" header=").append(r9).append(" placeholder=").append(r10).append(" rv=");
        FragmentMemoryPersonalChildBinding r13 = this.binding;
        if (r13 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L35:
        r5 = r7.append(r13.rvMemoryList.getVisibility()).append(" empty=");
        r14 = this.binding;
        if (r14 != null) goto L13;
        goto L13
    }

    private final String buildOwnerSnapshot() {
        ViewPager2 r0 = this.viewPager;
        if (r0 == null) goto L5;
        int r1 = r0.getCurrentItem();
    L6:
        String r2 = getShareViewModel().getSelectedTag();
        LifecycleOwner r3 = (LifecycleOwner) ZeusTransformUtils.preCheckCast(getViewLifecycleOwnerLiveData().getValue(), LifecycleOwner.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L12;
        Lifecycle r4 = r3.getLifecycle();
        if (r4 == null) goto L12;
        Lifecycle.State r5 = r4.getCurrentState();
        if (r5 == null) goto L12;
    L14:
        return "viewGen=" + this.viewGenerationId + " viewDestroyed=" + this.isViewDestroyed + " fragmentState=" + getLifecycle().getCurrentState() + " viewState=" + r5 + " viewPagerItem=" + r1 + " selectedTag=" + r2;
    L12:
        r5 = Lifecycle.State.DESTROYED;
        goto L14
    L5:
        r1 = -1;
        goto L6
    }

    private final boolean clipPendingPreviewVisibleBounds(Rect r13) {
        Fragment r12 = getParentFragment();
        if (r12 == null) goto L43;
        View r14 = r12.getView();
        if (r14 == null) goto L43;
        int[] r2 = new int[2];
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOfNotNull(new View[]{r14.findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, OaidModel.KEY_ID, "title_bar_container")), r14.findViewById(ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off"))}), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        Object r8 = r5.next();
        View r10 = (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin");
        if (r10.isShown() == true) goto L13;
    L15:
        boolean r9 = false;
    L16:
        if (r9 == false) goto L9;
        r4.add(r8);
        goto L9
    L13:
        if (r10.getAlpha() <= 0.0f) goto L15;
        r9 = true;
        goto L16
    L18:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r6.hasNext() == false) goto L22;
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6.next(), View.class, "com.obric.memorydata.plugin");
        r7.getLocationOnScreen(r2);
        r13.top = Math.max(r13.top, r2[1] + r7.getHeight());
        goto L20
    L22:
        View[] r11 = new View[3];
        r11[0] = r14.findViewById(ZeusTransformUtils.mapRes(R.id.memory_operation_container, OaidModel.KEY_ID, "memory_operation_container"));
        r11[1] = r14.getRootView().findViewById(ZeusTransformUtils.mapRes(R.id.cut_off_bottom, OaidModel.KEY_ID, "cut_off_bottom"));
        OBottomNavigationBar r15 = (OBottomNavigationBar) ZeusTransformUtils.preCheckCast(r14.getRootView().findViewById(ZeusTransformUtils.mapRes(R.id.memory_container_tab_view, OaidModel.KEY_ID, "memory_container_tab_view")), OBottomNavigationBar.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L25;
        OBottomNavActionBar r16 = r15.getNavigationBar();
    L26:
        r11[2] = r16;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOfNotNull(r11), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r17.iterator();
    L28:
        if (r18.hasNext() == false) goto L37;
        Object r19 = r18.next();
        View r20 = (View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.memorydata.plugin");
        if (r20.isShown() == true) goto L32;
    L34:
        boolean r21 = false;
    L35:
        if (r21 == false) goto L28;
        r1.add(r19);
        goto L28
    L32:
        if (r20.getAlpha() <= 0.0f) goto L34;
        r21 = true;
        goto L35
    L37:
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L39:
        if (r110.hasNext() == false) goto L42;
        ((View) ZeusTransformUtils.preCheckCast(r110.next(), View.class, "com.obric.memorydata.plugin")).getLocationOnScreen(r2);
        r13.bottom = Math.min(r13.bottom, r2[1]);
        goto L39
    L42:
        return !r13.isEmpty();
    L25:
        r16 = null;
    L43:
        return false;
    }

    private final bc convertToContentItem(ih r16) {
        MemoryEntity r6 = new ig(r16.a(), r16.b()).d();
        String r4 = r6.getId();
        String r5 = resolveDisplayText(r6);
        long r7 = r16.a().r();
        String r10 = r16.a().m();
        String r1 = iq.b(r16.a().a());
        if (isAllTag() == false) goto L5;
        String r11 = r1;
    L7:
        return (bc) ZeusTransformUtils.preCheckCast(new bc.a(r4, r5, r6, r7, 2, r10, r11, false, 128, null), bc.class, "com.obric.memorydata.plugin");
    L5:
        r11 = null;
        goto L7
    }

    private final void deleteFormalItem(bc.a r10) {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final String extractTagPath(MemoryEntity r11) {
        if (ZeusTransformUtils.instanceOf(r11, InfoCommonMemoryEntity.class) == true) goto L6;
        String r10 = getString(ZeusTransformUtils.mapRes(R.string.tag_path_other, TypedValues.Custom.S_STRING, "tag_path_other"));
        Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");
        return r10;
    L6:
        String r12 = ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r11, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getTag();
        if (r12 == null) goto L9;
        String r13 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L10:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == false) goto L21;
        String r14 = getString(ZeusTransformUtils.mapRes(R.string.tag_path_other, TypedValues.Custom.S_STRING, "tag_path_other"));
        Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");
        return r14;
    L21:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L23;
        r13 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.substringBefore$default(r13, ",", null, 2, null), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L23:
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r15) == false) goto L27;
        r15 = getString(ZeusTransformUtils.mapRes(R.string.tag_path_other, TypedValues.Custom.S_STRING, "tag_path_other"));
        Intrinsics.checkNotNullExpressionValue(r15, "getString(...)");
    L27:
        return (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin");
    L13:
        if (StringsKt.isBlank(r5) == true) goto L16;
        r6 = false;
        goto L17
    L9:
        r13 = null;
        goto L10
    }

    private final String generateKey(String r2) {
        return this.memoryTab.getText() + '_' + r2;
    }

    private final PendingPersonalInfoViewModel getPendingPersonalInfoViewModel() {
        return (PendingPersonalInfoViewModel) ZeusTransformUtils.preCheckCast(this.pendingPersonalInfoViewModel$delegate.getValue(), PendingPersonalInfoViewModel.class, "com.obric.memorydata.plugin");
    }

    private final int getPosition() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.position$delegate.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final String getSelectionTabKey() {
        return (String) ZeusTransformUtils.preCheckCast(this.selectionTabKey$delegate.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    private final MemoryListShareViewModel getShareViewModel() {
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(this.shareViewModel$delegate.getValue(), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    private final String getTagType() {
        return (String) ZeusTransformUtils.preCheckCast(this.tagType$delegate.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    private final boolean isAllTag() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.isAllTag$delegate.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static final boolean isAllTag_delegate$lambda$5(PersonalChildFragment r1) {
        return Intrinsics.areEqual(r1.getTagType(), PersonalTag.f11118a.a());
    }

    /* JADX INFO: renamed from: lambda$1wNn7-QEDccIEP9qwMsmPZ0Mae4, reason: not valid java name */
    public static /* synthetic */ Unit m897lambda$1wNn7QEDccIEP9qwMsmPZ0Mae4(PersonalChildFragment r0) {
        return setupRecyclerView$lambda$19(r0);
    }

    public static /* synthetic */ void lambda$2ZNh4Vv4hL_kTp1AL8tKHJ0Ynzc(PersonalChildFragment r0, int r1) {
        scrollToTargetPosition$lambda$20(r0, r1);
    }

    public static /* synthetic */ Unit lambda$3P_kojA9hr2rDeTo51CeehI8noo(PersonalChildFragment r0, ar r1) {
        return renderPendingPersonalInfo$lambda$35(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$5f-h9EW0AdSfJWxZ0ohg0wQCzlo, reason: not valid java name */
    public static /* synthetic */ Unit m898lambda$5fh9EW0AdSfJWxZ0ohg0wQCzlo(PersonalChildFragment r0, bc.a r1) {
        return setupRecyclerView$lambda$18$lambda$9(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$5hYwO0CuOEJ-RcMJiBMztj2Tnqo, reason: not valid java name */
    public static /* synthetic */ Unit m899lambda$5hYwO0CuOEJRcMJiBMztj2Tnqo(PersonalChildFragment r0, ar r1) {
        return renderPendingPersonalInfo$lambda$34(r0, r1);
    }

    public static /* synthetic */ boolean lambda$7pTfj7YMfFwkqovVgZaq3NUDpuY(PersonalChildFragment r0, View r1, bc.a r2, Function0 r3) {
        return setupRecyclerView$lambda$18$lambda$10(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$AABZhV60ngqkoGIqaXR4WHVGekI(PersonalChildFragment r0, ar r1) {
        return renderPendingPersonalInfo$lambda$33(r0, r1);
    }

    public static /* synthetic */ void lambda$Bhca0a4g7fqsEJSrMPucRhouX7s(RecyclerView r0, View r1) {
        setupRecyclerView$lambda$18$lambda$8$lambda$7(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$KXhbwevUx5-7yvPffJF0NxTcT_k, reason: not valid java name */
    public static /* synthetic */ PersonalChildViewModel m900lambda$KXhbwevUx57yvPffJF0NxTcT_k(PersonalChildFragment r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ boolean lambda$LWQ34E0QcOniOIkoTmV4hfdmL80(PersonalChildFragment r0) {
        return isAllTag_delegate$lambda$5(r0);
    }

    /* JADX INFO: renamed from: lambda$MD-_E0VYhuU2vTY8j_lbORYmxT4, reason: not valid java name */
    public static /* synthetic */ int m901lambda$MD_E0VYhuU2vTY8j_lbORYmxT4(PersonalChildFragment r0) {
        return position_delegate$lambda$3(r0);
    }

    public static /* synthetic */ MemoryListShareViewModel lambda$Mrtalr770ZkYWLmGjnMoQzvnjgE(PersonalChildFragment r0) {
        return shareViewModel_delegate$lambda$1(r0);
    }

    public static /* synthetic */ void lambda$MxEmwjMwUsOC75NruFiLi3swWaE(PersonalChildFragment r0, View r1) {
        updateEmptyState$lambda$38(r0, r1);
    }

    public static /* synthetic */ Unit lambda$Sx5WYwXpIbmCAJOvzbiusk6sSSo(PersonalChildFragment r0, ar r1) {
        return setupRecyclerView$lambda$18$lambda$11(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$VZX2cfH17rjknze-8jcRFvz5SG8, reason: not valid java name */
    public static /* synthetic */ PendingPersonalInfoViewModel m902lambda$VZX2cfH17rjknze8jcRFvz5SG8(PersonalChildFragment r0) {
        return pendingPersonalInfoViewModel_delegate$lambda$2(r0);
    }

    public static /* synthetic */ Unit lambda$_q_o7vbXhDTFifBZFb1l4fzCfWs(PersonalChildFragment r0, long r1) {
        return renderPendingPersonalInfo$lambda$36(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$axsFqUP-BmZhem5mhniH0xpDtlM, reason: not valid java name */
    public static /* synthetic */ Unit m903lambda$axsFqUPBmZhem5mhniH0xpDtlM(PersonalChildFragment r0, ar r1) {
        return setupRecyclerView$lambda$18$lambda$14(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$bDpxVhQdf-LGXiTfKdkvp_A7oTk, reason: not valid java name */
    public static /* synthetic */ Unit m904lambda$bDpxVhQdfLGXiTfKdkvp_A7oTk(PersonalChildFragment r0, long r1, Throwable r3) {
        return loadGroupedData$lambda$23(r0, r1, r3);
    }

    /* JADX INFO: renamed from: lambda$ln4sTYHm2nRPLR5-i9CqhTh8B3U, reason: not valid java name */
    public static /* synthetic */ boolean m905lambda$ln4sTYHm2nRPLR5i9CqhTh8B3U(PersonalChildFragment r0) {
        return setupRecyclerView$lambda$18$lambda$12(r0);
    }

    public static /* synthetic */ Unit lambda$o2oL2H9PQ_gCmxb4BYELfgKWQaE(PersonalChildFragment r0, com.obric.memorydata.memory.ui.data.a r1) {
        return onItemDislike$lambda$21(r0, r1);
    }

    public static /* synthetic */ Unit lambda$oNwXgSnzfGWEQTj78mnTAajW1qc(PersonalChildFragment r0, ar r1) {
        return setupRecyclerView$lambda$18$lambda$13(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ob-OJeh_JrjR8u0uuyZkOMTquL4, reason: not valid java name */
    public static /* synthetic */ void m906lambda$obOJeh_JrjR8u0uuyZkOMTquL4(PersonalChildFragment r0, String r1) {
        scheduleVisibleWindowProbe$lambda$40(r0, r1);
    }

    public static /* synthetic */ String lambda$sM_kNv_9QkQrSo9WCVQLRgq89MI(PersonalChildFragment r0) {
        return selectionTabKey_delegate$lambda$6(r0);
    }

    public static /* synthetic */ Unit lambda$ufM2Fz09YLYG6vZFckBNS1P32ao(PersonalChildFragment r0, ViewGroup.MarginLayoutParams r1, int r2) {
        return setupRecyclerView$lambda$18$lambda$17(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$vmh-Rv5ZoTrMt3osFKstDJXeLGU, reason: not valid java name */
    public static /* synthetic */ String m907lambda$vmhRv5ZoTrMt3osFKstDJXeLGU(PersonalChildFragment r0) {
        return tagType_delegate$lambda$4(r0);
    }

    private final void loadGroupedData() {
        final long r10 = this.loadGenerationId + 1;
        this.loadGenerationId = r10;
        String r0 = getTagType();
        if (isAllTag() == false) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        String r3 = iq.a(r0);
    L9:
        SemanticMemoryDao r13 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao();
        InvalidationTracker r4 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getInvalidationTracker();
        if (this.pagingJob == null) goto L18;
        IRunLog r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r1 = new StringBuilder().append("[MEM] ").append(getTagType()).append(" FLOW_CANCEL_PREVIOUS gen=").append(r10).append(" source=");
        WeakReference<SemanticMemoryPagingSource> r2 = this.currentPagingSourceRef;
        if (r2 == null) goto L16;
        SemanticMemoryPagingSource r5 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r2.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L16;
        Long r6 = Long.valueOf(r5.debugId());
    L17:
        IRunLog.a.a(r15, TAG, r1.append(r6).toString(), false, 4, null);
    L16:
        r6 = null;
    L18:
        bx r7 = this.pagingJob;
        if (r7 == null) goto L21;
        bx.a.a(r7, null, 1, null);
    L21:
        this.pagingJob = null;
        WeakReference<SemanticMemoryPagingSource> r8 = this.currentPagingSourceRef;
        if (r8 == null) goto L26;
        SemanticMemoryPagingSource r9 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r8.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L26;
        r9.dispose("loadGroupedData_replace");
    L26:
        this.currentPagingSourceRef = null;
        this.isRefreshLoading = true;
        this.lastLoadStateLogKey = null;
        updateEmptyState();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[MEM] " + getTagType() + " loadGroupedData start gen=" + r10 + " dbType=" + r3, false, 4, null);
        Executor r11 = bo.a(kotlinx.coroutines.ba.c());
        LifecycleOwner r12 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r12, "getViewLifecycleOwner(...)");
        bx r14 = kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r12), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11701(this, r13, r3, r4, r10, r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        this.pagingJob = r14;
        if (r14 == null) goto L29;
        r14.a(new $$Lambda$PersonalChildFragment$bDpxVhQdfLGXiTfKdkvp_A7oTk(this, r10));
    L29:
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, r13, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L8:
        r3 = null;
        goto L9
    }

    private static final Unit loadGroupedData$lambda$23(PersonalChildFragment r9, long r10, Throwable r12) {
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r11 = new StringBuilder().append("[MEM] ").append(r9.getTagType()).append(" PAGING_JOB_DONE gen=").append(r10).append(" source=");
        WeakReference<SemanticMemoryPagingSource> r13 = r9.currentPagingSourceRef;
        String r14 = null;
        if (r13 == null) goto L7;
        SemanticMemoryPagingSource r15 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r13.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L7;
        Long r16 = Long.valueOf(r15.debugId());
    L8:
        StringBuilder r17 = r11.append(r16).append(" cause=");
        if (r12 == null) goto L13;
        Class<?> r18 = r12.getClass();
        if (r18 == null) goto L13;
        String r19 = r18.getSimpleName();
    L14:
        StringBuilder r20 = r17.append(r19).append(':');
        if (r12 == null) goto L17;
        r14 = r12.getMessage();
    L17:
        IRunLog.a.a(r3, TAG, r20.append(r14).toString(), false, 4, null);
        return Unit.INSTANCE;
    L13:
        r19 = null;
    L7:
        r16 = null;
        goto L8
    }

    private final String loadStateName(LoadState r4) {
        if (ZeusTransformUtils.instanceOf(r4, LoadState.Loading.class) == false) goto L6;
        return "Loading";
    L6:
        if (ZeusTransformUtils.instanceOf(r4, LoadState.NotLoading.class) == false) goto L10;
        StringBuilder r3 = new StringBuilder().append("NotLoading(end=").append(r4.getEndOfPaginationReached());
    L15:
        return r3.append(')').toString();
    L10:
        if (ZeusTransformUtils.instanceOf(r4, LoadState.Error.class) == false) goto L14;
        r3 = new StringBuilder().append("Error(").append(((LoadState.Error) ZeusTransformUtils.preCheckCast(r4, LoadState.Error.class, "com.obric.memorydata.plugin")).getError().getClass().getSimpleName()).append(':').append(((LoadState.Error) ZeusTransformUtils.preCheckCast(r4, LoadState.Error.class, "com.obric.memorydata.plugin")).getError().getMessage());
        goto L15
    L14:
        throw new NoWhenBranchMatchedException();
    }

    private final void logLoadStateIfNeeded(CombinedLoadStates r10) {
        String r11 = "refresh=" + loadStateName(r10.getRefresh()) + "|prepend=" + loadStateName(r10.getPrepend()) + "|append=" + loadStateName(r10.getAppend()) + '|' + buildAdapterSnapshot();
        if (Intrinsics.areEqual(this.lastLoadStateLogKey, r11) == false) goto L5;
        return;
    L5:
        this.lastLoadStateLogKey = r11;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("[MEM] ").append(getTagType()).append(" LOAD_STATE source=");
        WeakReference<SemanticMemoryPagingSource> r9 = this.currentPagingSourceRef;
        if (r9 == null) goto L10;
        SemanticMemoryPagingSource r12 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r9.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L10;
        Long r13 = Long.valueOf(r12.debugId());
    L11:
        IRunLog.a.a(r3, TAG, r0.append(r13).append(' ').append(r11).toString(), false, 4, null);
        return;
    L10:
        r13 = null;
        goto L11
    }

    private final void logVisibleWindow(String r14) {
        FragmentMemoryPersonalChildBinding r0 = this.binding;
        Long r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        RecyclerView.h r1 = r0.rvMemoryList.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r1, LinearLayoutManager.class) == false) goto L8;
        LinearLayoutManager r3 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r1, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L10:
        if (r3 == null) goto L12;
        int r5 = r3.o();
    L13:
        if (r3 == null) goto L15;
        int r4 = r3.p();
    L16:
        PersonalGroupListAdapter r6 = this.groupListAdapter;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
        r6 = null;
    L19:
        int r7 = r6.d();
        av r8 = this.pendingPreviewAdapter;
        int r9 = 0;
        if (r8 == null) goto L22;
        int r10 = r8.d();
    L23:
        if (r7 <= 0) goto L53;
        if (r5 == (-1)) goto L53;
        if (r4 == (-1)) goto L53;
        if (r4 < r5) goto L53;
        int r11 = RangesKt.coerceAtLeast(r5 - r10, 0);
        int r12 = RangesKt.coerceAtMost(r4 - r10, r7 - 1);
        if (r12 < r11) goto L53;
        if (r11 > r12) goto L53;
        int r13 = 0;
        int r15 = 0;
    L67:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L36
        PersonalGroupListAdapter r17 = ((PersonalChildFragment) ZeusTransformUtils.preCheckCast(this, PersonalChildFragment.class, "com.obric.memorydata.plugin")).groupListAdapter;     // Catch: Throwable -> L36
        if (r17 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");     // Catch: Throwable -> L36
        r17 = null;
    L34:
        Object r18 = Result.m1421constructorimpl((bc) ZeusTransformUtils.preCheckCast(r17.d(r11), bc.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L36
    L39:
        if (Result.m1427isFailureimpl(r18) == false) goto L41;
        r18 = null;
    L41:
        bc r19 = (bc) ZeusTransformUtils.preCheckCast(r18, bc.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r19, bc.a.class) == false) goto L45;
        r9 = r9 + 1;
    L49:
        if (r11 == r12) goto L54;
        r11 = r11 + 1;
    L54:
        StringBuilder r20 = new StringBuilder().append(r14).append("|first=").append(r5).append("|last=").append(r4).append("|visibleContent=").append(r9).append("|visibleHeader=").append(r13).append("|visiblePlaceholder=").append(r15).append("|childCount=");
        FragmentMemoryPersonalChildBinding r21 = this.binding;
        if (r21 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L57:
        String r22 = r20.append(r21.rvMemoryList.getChildCount()).append('|').append(buildAdapterSnapshot()).append('|').append(buildOwnerSnapshot()).toString();
        if (Intrinsics.areEqual(this.lastVisibleWindowLogKey, r22) == false) goto L60;
        return;
    L60:
        this.lastVisibleWindowLogKey = r22;
        RunLog r23 = RunLog.INSTANCE;
        StringBuilder r110 = new StringBuilder().append("[MEM] ").append(getTagType()).append(" VISIBLE_WINDOW reason=").append(r14).append(" source=");
        WeakReference<SemanticMemoryPagingSource> r111 = this.currentPagingSourceRef;
        if (r111 == null) goto L65;
        SemanticMemoryPagingSource r112 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r111.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
        if (r112 == null) goto L65;
        r2 = Long.valueOf(r112.debugId());
    L65:
        r23.debug(TAG, r110.append(r2).append(' ').append(r22).toString());
        return;
    L45:
        if (ZeusTransformUtils.instanceOf(r19, bc.b.class) == false) goto L47;
        r13 = r13 + 1;
        goto L49
    L47:
        if (r19 != null) goto L52;
        r15 = r15 + 1;
        goto L49
    L52:
        throw new NoWhenBranchMatchedException();
    L36:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L53:
        r13 = 0;
        r15 = 0;
        goto L54
    L22:
        r10 = 0;
        goto L23
    L15:
        r4 = -1;
        goto L16
    L12:
        r5 = -1;
        goto L13
    L8:
        r3 = null;
        goto L10
    }

    private final LocalDate memoryDay(long r1) {
        LocalDate r0 = Instant.ofEpochMilli(r1).atZone(ZoneId.systemDefault()).toLocalDate();
        Intrinsics.checkNotNullExpressionValue(r0, "toLocalDate(...)");
        return r0;
    }

    private final void observeData() {
        if (isAllTag() == false) goto L5;
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11711(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L5:
        LifecycleOwner r1 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r1, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r1), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11723(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        loadGroupedData();
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass7(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass8(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass9(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass10(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final Unit onItemDislike$lambda$21(PersonalChildFragment r4, com.obric.memorydata.memory.ui.data.a r5) {
        Intrinsics.checkNotNullParameter(r5, "memoryItem");
        if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L6;
        String r6 = ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).e();
    L9:
        if (r6 != null) goto L11;
        r6 = "19700101000000";
    L11:
        String r0 = r4.getString(ZeusTransformUtils.mapRes(R.string.memory_copy_to_clipboard_text, TypedValues.Custom.S_STRING, "memory_copy_to_clipboard_text"));
        Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");
        com.obric.memorydata.utils.ba.a(r6, "memory_common_logId", r0, (Activity) ZeusTransformUtils.preCheckCast((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L8;
        r6 = ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getLogId();
        goto L9
    L8:
        r6 = null;
        goto L9
    }

    private static final PendingPersonalInfoViewModel pendingPersonalInfoViewModel_delegate$lambda$2(PersonalChildFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (PendingPersonalInfoViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(PendingPersonalInfoViewModel.class), PendingPersonalInfoViewModel.class, "com.obric.memorydata.plugin");
    }

    private static final int position_delegate$lambda$3(PersonalChildFragment r1) {
        Bundle r2 = r1.getArguments();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.getInt(ARG_POSITION);
    }

    private final void renderPendingPersonalInfo(az r11) {
        av r0 = this.pendingPreviewAdapter;
        if (r0 == null) goto L6;
        r0.a(r11.h(), r11.d(), r11.i().size());
    L6:
        if (r11.f() == false) goto L14;
        ap r1 = this.pendingConfirmationSheet;
        if (r1 != null) goto L11;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "requireContext(...)");
        LifecycleOwner r4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r4, "getViewLifecycleOwner(...)");
        r1 = new ap(r3, r4, new $$Lambda$PersonalChildFragment$AABZhV60ngqkoGIqaXR4WHVGekI(this), new $$Lambda$PersonalChildFragment$5hYwO0CuOEJRcMJiBMztj2Tnqo(this), new $$Lambda$PersonalChildFragment$3P_kojA9hr2rDeTo51CeehI8noo(this), (Function0) ZeusTransformUtils.preCheckCast(new PersonalChildFragment$renderPendingPersonalInfo$sheet$4(getPendingPersonalInfoViewModel()), Function0.class, "com.obric.memorydata.plugin"), new $$Lambda$PersonalChildFragment$_q_o7vbXhDTFifBZFb1l4fzCfWs(this));
        this.pendingConfirmationSheet = r1;
    L11:
        if (r1.b() == false) goto L13;
        r1.update(r11.i(), r11.d());
    L17:
        updateEmptyState();
        return;
    L13:
        r1.a(r11.i(), r11.d());
        goto L17
    L14:
        ap r12 = this.pendingConfirmationSheet;
        if (r12 == null) goto L17;
        r12.a();
        goto L17
    }

    private static final Unit renderPendingPersonalInfo$lambda$33(PersonalChildFragment r1, ar r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.getPendingPersonalInfoViewModel().onCardShown$memory_obricRelease(r2, PendingPersonalInfoTracker.Surface.CONSUME_DIALOG);
        return Unit.INSTANCE;
    }

    private static final Unit renderPendingPersonalInfo$lambda$34(PersonalChildFragment r2, ar r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r2.getPendingPersonalInfoViewModel().onCardClicked$memory_obricRelease(r3, PendingPersonalInfoTracker.Surface.CONSUME_DIALOG, true);
        return Unit.INSTANCE;
    }

    private static final Unit renderPendingPersonalInfo$lambda$35(PersonalChildFragment r2, ar r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r2.getPendingPersonalInfoViewModel().onCardClicked$memory_obricRelease(r3, PendingPersonalInfoTracker.Surface.CONSUME_DIALOG, false);
        return Unit.INSTANCE;
    }

    private static final Unit renderPendingPersonalInfo$lambda$36(PersonalChildFragment r3, long r4) {
        if (r3.isResumed() == false) goto L13;
        View r0 = r3.getView();
        boolean r1 = true;
        if (r0 != null) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == false) goto L13;
        r3.getPendingPersonalInfoViewModel().markSeen(r4);
        goto L13
    L7:
        if (r0.isShown() != true) goto L9;
    L13:
        return Unit.INSTANCE;
    }

    private final String resolveDisplayText(MemoryEntity r5) {
        if (ZeusTransformUtils.instanceOf(r5, InfoCommonMemoryEntity.class) == false) goto L21;
        String r4 = ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r5, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getInfoValue();
        String r2 = null;
        if (r4 != null) goto L7;
    L11:
        String r6 = ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r5, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getObservation();
        if (r6 != null) goto L14;
    L16:
        if (r2 != null) goto L26;
        r4 = r5.getDetail();
        if (r4 != null) goto L25;
        return "";
    L25:
        return r4;
    L26:
        return r2;
    L14:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L16;
        r2 = r6;
        goto L16
    L7:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        r4 = null;
    L10:
        if (r4 != null) goto L25;
    L21:
        r4 = r5.getDetail();
        if (r4 != null) goto L25;
        return "";
    }

    private final void scheduleVisibleWindowProbe(final String r3) {
        if (AppContext.INSTANCE.isDebug() == false) goto L13;
        FragmentMemoryPersonalChildBinding r0 = this.binding;
        if (r0 != null) goto L7;
        return;
    L7:
        if (this.isViewDestroyed == true) goto L15;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L11:
        r0.rvMemoryList.post(new $$Lambda$PersonalChildFragment$obOJeh_JrjR8u0uuyZkOMTquL4(this, r3));
        return;
    L15:
        return;
    }

    private static final void scheduleVisibleWindowProbe$lambda$40(PersonalChildFragment r1, String r2) {
        if (r1.binding != null) goto L5;
        return;
    L5:
        if (r1.isViewDestroyed == true) goto L10;
        r1.logVisibleWindow(r2);
        return;
    }

    private final void scrollToItemIfNeeded(AppEntity r10) {
        PersonalGroupListAdapter r0 = this.groupListAdapter;
        FragmentMemoryPersonalChildBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
        r0 = null;
    L5:
        int r1 = r0.d();
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L34;
        PersonalGroupListAdapter r5 = this.groupListAdapter;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
        r5 = null;
    L10:
        bc r6 = (bc) ZeusTransformUtils.preCheckCast(r5.d(r4), bc.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L33;
        if (ZeusTransformUtils.instanceOf(r6, bc.a.class) == false) goto L33;
        if (Intrinsics.areEqual(r10.getId(), ((bc.a) ZeusTransformUtils.preCheckCast(r6, bc.a.class, "com.obric.memorydata.plugin")).a()) == false) goto L33;
        if (r4 <= 0) goto L24;
        PersonalGroupListAdapter r11 = this.groupListAdapter;
        if (r11 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
        r11 = null;
    L21:
        int r7 = r4 - 1;
        if (ZeusTransformUtils.instanceOf(r11.d(r7), bc.b.class) == false) goto L24;
        r4 = r7;
    L24:
        this.jumpTargetEntity = null;
        RunLog r12 = RunLog.INSTANCE;
        StringBuilder r8 = new StringBuilder().append("scrollToItemIfNeeded, scrollToTargetPosition ").append(r4).append(", paddingTop=");
        FragmentMemoryPersonalChildBinding r9 = this.binding;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L28:
        r12.debug(TAG, r8.append(r2.rvMemoryList.getPaddingTop()).append(", isAllTag=").append(isAllTag()).toString());
        av r13 = this.pendingPreviewAdapter;
        if (r13 == null) goto L31;
        r3 = r13.d();
    L31:
        scrollToTargetPosition(r4 + r3);
        return;
    L27:
        r2 = r9;
    L33:
        r4 = r4 + 1;
        goto L6
    }

    private final void scrollToTargetPosition(final int r3) {
        FragmentMemoryPersonalChildBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.rvMemoryList.post(new $$Lambda$PersonalChildFragment$2ZNh4Vv4hL_kTp1AL8tKHJ0Ynzc(this, r3));
    }

    private static final void scrollToTargetPosition$lambda$20(PersonalChildFragment r5, int r6) {
        FragmentMemoryPersonalChildBinding r0 = r5.binding;
        FragmentMemoryPersonalChildBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        RecyclerView.h r1 = r0.rvMemoryList.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r1, LinearLayoutManager.class) == false) goto L8;
        LinearLayoutManager r3 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r1, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L9:
        if (r3 == null) goto L11;
        r3.b(r6, 0);
        return;
    L11:
        FragmentMemoryPersonalChildBinding r7 = r5.binding;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r2.rvMemoryList.scrollToPosition(r6);
        return;
    L14:
        r2 = r7;
        goto L15
    L8:
        r3 = null;
        goto L9
    }

    private static final String selectionTabKey_delegate$lambda$6(PersonalChildFragment r1) {
        return r1.generateKey(r1.getTagType());
    }

    private final void setupRecyclerView() {
        FragmentMemoryPersonalChildBinding r0 = this.binding;
        PersonalGroupListAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        final RecyclerView r2 = r0.rvMemoryList;
        r2.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        r2.setItemAnimator(null);
        r2.setClipToPadding(false);
        Fragment r3 = getParentFragment();
        if (ZeusTransformUtils.instanceOf(r3, PersonalTabFragment.class) == false) goto L8;
        PersonalTabFragment r4 = (PersonalTabFragment) ZeusTransformUtils.preCheckCast(r3, PersonalTabFragment.class, "com.obric.memorydata.plugin");
    L9:
        if (r4 == null) goto L13;
        final View r5 = r4.getTitleBarContainerView();
        if (r5 == null) goto L13;
        r5.post(new $$Lambda$PersonalChildFragment$Bhca0a4g7fqsEJSrMPucRhouX7s(r2, r5));
    L13:
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "requireContext(...)");
        this.groupListAdapter = new PersonalGroupListAdapter(r7, getShareViewModel().getSelectionManager(), isAllTag(), new $$Lambda$PersonalChildFragment$5fh9EW0AdSfJWxZ0ohg0wQCzlo(this), new $$Lambda$PersonalChildFragment$7pTfj7YMfFwkqovVgZaq3NUDpuY(this));
        if (isAllTag() == false) goto L19;
        LifecycleOwner r8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r8, "getViewLifecycleOwner(...)");
        av r6 = new av(r8, new $$Lambda$PersonalChildFragment$Sx5WYwXpIbmCAJOvzbiusk6sSSo(this), new $$Lambda$PersonalChildFragment$ln4sTYHm2nRPLR5i9CqhTh8B3U(this), (Function1) ZeusTransformUtils.preCheckCast(new PersonalChildFragment$setupRecyclerView$1$6(this), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new PersonalChildFragment$setupRecyclerView$1$7(getPendingPersonalInfoViewModel()), Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new PersonalChildFragment$setupRecyclerView$1$8(getPendingPersonalInfoViewModel()), Function0.class, "com.obric.memorydata.plugin"), new $$Lambda$PersonalChildFragment$oNwXgSnzfGWEQTj78mnTAajW1qc(this), new $$Lambda$PersonalChildFragment$axsFqUPBmZhem5mhniH0xpDtlM(this));
        this.pendingPreviewAdapter = r6;
        RecyclerView.Adapter[] r9 = new RecyclerView.Adapter[2];
        r9[0] = r6;
        PersonalGroupListAdapter r10 = this.groupListAdapter;
        if (r10 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
        r10 = null;
    L18:
        r9[1] = r10;
        Object r11 = ZeusTransformUtils.preCheckCast(new ConcatAdapter(r9), RecyclerView.Adapter.class, "com.obric.memorydata.plugin");
    L23:
        r2.setAdapter((RecyclerView.Adapter) r11);
        PersonalGroupListAdapter r12 = this.groupListAdapter;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
        r12 = null;
    L26:
        r12.a(new $$Lambda$PersonalChildFragment$ufM2Fz09YLYG6vZFckBNS1P32ao(this));
        Intrinsics.checkNotNull(r2);
        this.recyclerViewInterceptor = new com.obric.memorydata.memory.ui.a(r2, this.viewPager, false, false);
        PersonalGroupListAdapter r13 = this.groupListAdapter;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
    L30:
        r1.a(new $$Lambda$PersonalChildFragment$1wNn7QEDccIEP9qwMsmPZ0Mae4(this));
        updateEmptyState();
        return;
    L29:
        r1 = r13;
        goto L30
    L19:
        PersonalGroupListAdapter r14 = this.groupListAdapter;
        if (r14 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
        r14 = null;
    L22:
        r11 = ZeusTransformUtils.preCheckCast(r14, RecyclerView.Adapter.class, "com.obric.memorydata.plugin");
        goto L23
    L8:
        r4 = null;
        goto L9
    }

    private static final boolean setupRecyclerView$lambda$18$lambda$10(PersonalChildFragment r2, View r3, bc.a r4, Function0 r5) {
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "anchor");
        Intrinsics.checkNotNullParameter(r4, "item");
        if (r4.h() == false) goto L5;
        return false;
    L5:
        r2.showPopupMenu(r3, r4, r6);
        return true;
    }

    private static final Unit setupRecyclerView$lambda$18$lambda$11(PersonalChildFragment r1, ar r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.getPendingPersonalInfoViewModel().onCardShown$memory_obricRelease(r2, PendingPersonalInfoTracker.Surface.PENDING_AREA);
        return Unit.INSTANCE;
    }

    private static final boolean setupRecyclerView$lambda$18$lambda$12(PersonalChildFragment r2) {
        az r3 = (az) ZeusTransformUtils.preCheckCast(r2.getPendingPersonalInfoViewModel().getUiState().c(), az.class, "com.obric.memorydata.plugin");
        if (r3.b() == true) goto L5;
    L7:
        return false;
    L5:
        if (r3.f() == true) goto L7;
        return true;
    }

    private static final Unit setupRecyclerView$lambda$18$lambda$13(PersonalChildFragment r2, ar r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r2.getPendingPersonalInfoViewModel().onCardClicked$memory_obricRelease(r3, PendingPersonalInfoTracker.Surface.PENDING_AREA, true);
        return Unit.INSTANCE;
    }

    private static final Unit setupRecyclerView$lambda$18$lambda$14(PersonalChildFragment r2, ar r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r2.getPendingPersonalInfoViewModel().onCardClicked$memory_obricRelease(r3, PendingPersonalInfoTracker.Surface.PENDING_AREA, false);
        return Unit.INSTANCE;
    }

    private static final Unit setupRecyclerView$lambda$18$lambda$17(PersonalChildFragment r4, ViewGroup.MarginLayoutParams r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "layoutParams");
        PersonalGroupListAdapter r0 = r4.groupListAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
        r0 = null;
    L5:
        int r1 = r0.a(r6);
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L20;
        if (r4.isAllTag() == false) goto L13;
        if (r6 != 0) goto L13;
        float r7 = 16;
    L17:
        int r8 = MathKt.roundToInt(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics()));
    L18:
        r5.setMargins(0, r8, 0, 0);
    L13:
        r8 = 0;
    L20:
        return Unit.INSTANCE;
    L14:
        if (r6 != 0) goto L16;
        r7 = 4;
        goto L17
    L16:
        r7 = 16;
        goto L17
    }

    private static final void setupRecyclerView$lambda$18$lambda$8$lambda$7(RecyclerView r4, View r5) {
        r4.setPadding(r4.getPaddingLeft(), r5.getHeight() - MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())), r4.getPaddingRight(), r4.getPaddingBottom());
    }

    private static final Unit setupRecyclerView$lambda$18$lambda$9(PersonalChildFragment r6, bc.a r7) {
        Intrinsics.checkNotNullParameter(r7, "item");
        if (r7.h() == true) goto L6;
        MemoryEventTracker.f10515a.a((AppEntity) ZeusTransformUtils.preCheckCast(r7.c(), AppEntity.class, "com.obric.memorydata.plugin"), MemoryEventTracker.ReactionType.DETAIL.getValue(), (String) ZeusTransformUtils.preCheckCast(r6.getShareViewModel().getEnterFrom().c(), String.class, "com.obric.memorydata.plugin"));
        MemoryDetailActivity.a r0 = MemoryDetailActivity.Companion;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r8, "requireContext(...)");
        r0.b(r8, r7.c(), MemoryEventTracker.SourceType.MEMORY_LIST.getValue(), false);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit setupRecyclerView$lambda$19(PersonalChildFragment r8) {
        PersonalGroupListAdapter r0 = r8.groupListAdapter;
        Long r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
        PersonalGroupListAdapter r2 = null;
    L6:
        FragmentMemoryPersonalChildBinding r3 = r8.binding;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L9:
        RecyclerView r4 = r3.rvMemoryList;
        Intrinsics.checkNotNullExpressionValue(r4, "rvMemoryList");
        av r5 = r8.pendingPreviewAdapter;
        if (r5 == null) goto L12;
        int r6 = r5.d();
    L13:
        PersonalGroupListAdapter.a(r2, r4, r6, 0, 4, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L21;
        RunLog r7 = RunLog.INSTANCE;
        StringBuilder r9 = new StringBuilder().append("[MEM] ").append(r8.getTagType()).append(" PAGES_UPDATED source=");
        WeakReference<SemanticMemoryPagingSource> r10 = r8.currentPagingSourceRef;
        if (r10 == null) goto L20;
        SemanticMemoryPagingSource r11 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r10.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L20;
        r1 = Long.valueOf(r11.debugId());
    L20:
        r7.debug(TAG, r9.append(r1).append(' ').append(r8.buildOwnerSnapshot()).append(' ').append(r8.buildAdapterSnapshot()).toString());
    L21:
        r8.updateEmptyState();
        r8.scheduleVisibleWindowProbe("pagesUpdated");
        return Unit.INSTANCE;
    L12:
        r6 = 0;
        goto L13
    L5:
        r2 = r0;
        goto L6
    }

    private static final MemoryListShareViewModel shareViewModel_delegate$lambda$1(PersonalChildFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(MemoryListShareViewModel.class), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void showPopupMenu(View r18, bc.a r19, Function0<Unit> r20) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r20, Function0.class, "com.obric.memorydata.plugin");
        RecyclerView r1 = null;
        PersonalGroupListAdapter r2 = null;
        if (((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L12;
        getShareViewModel().getSelectionManager().a(getSelectionTabKey());
        getShareViewModel().getSelectionManager().a(new cu(r19.a(), NetError.ERR_CACHE_READ_FAILURE, "", null, 8, null), getSelectionTabKey());
        PersonalGroupListAdapter r0 = this.groupListAdapter;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
    L8:
        r2.a();
        if (r4 == null) goto L17;
        r4.invoke();
        return;
    L17:
        return;
    L7:
        r2 = r0;
        goto L8
    L12:
        ViewParent r3 = r18.getParent();
        if (ZeusTransformUtils.instanceOf(r3, RecyclerView.class) == false) goto L15;
        r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(r3, RecyclerView.class, "com.obric.memorydata.plugin");
    L15:
        boolean r5 = com.obric.memorydata.utils.bb.a(r18, r1);
        com.obric.memorydata.memory.ui.data.a.h r6 = new com.obric.memorydata.memory.ui.data.a.h(r19.c(), false, false, null, r19.f(), 8, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11731(r18, r6, this, r4, r5, r19, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    static /* synthetic */ void showPopupMenu$default(PersonalChildFragment r1, View r2, bc.a r3, Function0 r4, int r5, Object r6) {
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r7 = null;
    L5:
        r1.showPopupMenu(r2, r3, r7);
    }

    private static final String tagType_delegate$lambda$4(PersonalChildFragment r2) {
        return (String) ZeusTransformUtils.preCheckCast(ba.f11222a.a().get(r2.getPosition()), String.class, "com.obric.memorydata.plugin");
    }

    private final void updateEmptyState() {
        az r1 = (az) ZeusTransformUtils.preCheckCast(getPendingPersonalInfoViewModel().getUiState().c(), az.class, "com.obric.memorydata.plugin");
        FragmentMemoryPersonalChildBinding r8 = null;
        if (isAllTag() == true) goto L5;
    L26:
        FragmentMemoryPersonalChildBinding r2 = this.binding;
        if (r2 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L29:
        r2.layoutEmpty.setOnClickListener(null);
        av r3 = this.pendingPreviewAdapter;
        if (r3 == null) goto L32;
        int r4 = r3.d();
    L34:
        if (r4 <= 0) goto L36;
        boolean r5 = true;
    L37:
        if (r5 == true) goto L63;
        PersonalGroupListAdapter r6 = this.groupListAdapter;
        if (r6 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
        r6 = null;
    L42:
        if (r6.d() <= 0) goto L62;
        PersonalGroupListAdapter r7 = this.groupListAdapter;
        if (r7 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
        r7 = null;
    L46:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r7.d()), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L49;
    L51:
        Iterator r10 = r9.iterator();
    L53:
        if (r10.hasNext() == false) goto L50;
        int r11 = ((IntIterator) ZeusTransformUtils.preCheckCast(r10, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        PersonalGroupListAdapter r12 = this.groupListAdapter;
        if (r12 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
        r12 = null;
    L58:
        if (ZeusTransformUtils.instanceOf(r12.d(r11), bc.a.class) == false) goto L53;
        boolean r13 = true;
    L60:
        if (r13 == false) goto L62;
    L50:
        r13 = false;
        goto L60
    L49:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L51;
    L62:
        boolean r14 = false;
    L64:
        if (r14 == false) goto L66;
    L72:
        boolean r15 = false;
    L73:
        PersonalEmptyStatePolicy.State r16 = PersonalEmptyStatePolicy.f11094a.a(this.isMigrating, r15, r14);
        StringBuilder r17 = new StringBuilder().append(r16).append("|refreshLoading=").append(this.isRefreshLoading).append('|').append(buildAdapterSnapshot()).append("|empty=");
        FragmentMemoryPersonalChildBinding r18 = this.binding;
        if (r18 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L76:
        StringBuilder r19 = r17.append(r18.layoutEmpty.getVisibility()).append("|rv=");
        FragmentMemoryPersonalChildBinding r110 = this.binding;
        if (r110 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L79:
        String r111 = r19.append(r110.rvMemoryList.getVisibility()).toString();
        if (Intrinsics.areEqual(this.lastEmptyStateLogKey, r111) == true) goto L88;
        this.lastEmptyStateLogKey = r111;
        IRunLog r112 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r20 = new StringBuilder().append("[MEM] ").append(getTagType()).append(" EMPTY_STATE state=").append(r16).append(" showUpdating=").append(r15).append(" source=");
        WeakReference<SemanticMemoryPagingSource> r113 = this.currentPagingSourceRef;
        if (r113 == null) goto L86;
        SemanticMemoryPagingSource r114 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r113.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
        if (r114 == null) goto L86;
        Long r115 = Long.valueOf(r114.debugId());
    L87:
        IRunLog.a.a(r112, TAG, r20.append(r115).append(' ').append(r111).toString(), false, 4, null);
    L86:
        r115 = null;
    L88:
        int r21 = b.f11072a[r16.ordinal()];
        if (r21 != 1) goto L91;
        FragmentMemoryPersonalChildBinding r22 = this.binding;
        if (r22 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r22 = null;
    L133:
        r22.layoutEmpty.setVisibility(0);
        FragmentMemoryPersonalChildBinding r23 = this.binding;
        if (r23 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L136:
        r23.emptyTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.semantic_migration_upgrading, TypedValues.Custom.S_STRING, "semantic_migration_upgrading")), CharSequence.class, "com.obric.memorydata.plugin"));
        FragmentMemoryPersonalChildBinding r24 = this.binding;
        if (r24 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L139:
        r24.emptyDescription.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.semantic_migration_progress, TypedValues.Custom.S_STRING, "semantic_migration_progress"), new Object[]{Integer.valueOf(this.migrationProgress)}), CharSequence.class, "com.obric.memorydata.plugin"));
        FragmentMemoryPersonalChildBinding r0 = this.binding;
        if (r0 != null) goto L142;
    L141:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L143:
        r8.rvMemoryList.setVisibility(8);
        return;
    L142:
        r8 = r0;
        goto L143
    L91:
        if (r21 != 2) goto L93;
        FragmentMemoryPersonalChildBinding r25 = this.binding;
        if (r25 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r25 = null;
    L121:
        r25.layoutEmpty.setVisibility(0);
        FragmentMemoryPersonalChildBinding r26 = this.binding;
        if (r26 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L124:
        r26.emptyTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.update_string, TypedValues.Custom.S_STRING, "update_string")), CharSequence.class, "com.obric.memorydata.plugin"));
        FragmentMemoryPersonalChildBinding r27 = this.binding;
        if (r27 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r27 = null;
    L127:
        r27.emptyDescription.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.smart_memory_no_data_description, TypedValues.Custom.S_STRING, "smart_memory_no_data_description")), CharSequence.class, "com.obric.memorydata.plugin"));
        r0 = this.binding;
        if (r0 != null) goto L142;
    L93:
        if (r21 != 3) goto L95;
        FragmentMemoryPersonalChildBinding r28 = this.binding;
        if (r28 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L113:
        r28.layoutEmpty.setVisibility(8);
        FragmentMemoryPersonalChildBinding r29 = this.binding;
        if (r29 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L117:
        r8.rvMemoryList.setVisibility(0);
        scheduleVisibleWindowProbe("emptyStateContent");
        return;
    L116:
        r8 = r29;
        goto L117
    L95:
        if (r21 != 4) goto L109;
        FragmentMemoryPersonalChildBinding r30 = this.binding;
        if (r30 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r30 = null;
    L99:
        r30.layoutEmpty.setVisibility(0);
        FragmentMemoryPersonalChildBinding r31 = this.binding;
        if (r31 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r31 = null;
    L102:
        r31.emptyTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.smart_memory_no_data_title, TypedValues.Custom.S_STRING, "smart_memory_no_data_title")), CharSequence.class, "com.obric.memorydata.plugin"));
        FragmentMemoryPersonalChildBinding r32 = this.binding;
        if (r32 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r32 = null;
    L105:
        r32.emptyDescription.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.smart_memory_no_data_description, TypedValues.Custom.S_STRING, "smart_memory_no_data_description")), CharSequence.class, "com.obric.memorydata.plugin"));
        r0 = this.binding;
        if (r0 != null) goto L142;
    L109:
        throw new NoWhenBranchMatchedException();
    L66:
        if (this.isRefreshLoading == false) goto L68;
    L71:
        r15 = true;
        goto L73
    L68:
        if (isAllTag() == false) goto L72;
        if (r1.b() == true) goto L72;
    L63:
        r14 = true;
        goto L64
    L36:
        r5 = false;
        goto L37
    L32:
        r4 = 0;
        goto L34
    L5:
        if (r1.b() == true) goto L26;
        if (r1.e() == null) goto L26;
        FragmentMemoryPersonalChildBinding r33 = this.binding;
        if (r33 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r33 = null;
    L11:
        r33.layoutEmpty.setVisibility(0);
        FragmentMemoryPersonalChildBinding r34 = this.binding;
        if (r34 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r34 = null;
    L14:
        r34.rvMemoryList.setVisibility(8);
        FragmentMemoryPersonalChildBinding r35 = this.binding;
        if (r35 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r35 = null;
    L17:
        r35.emptyTitle.setText(ZeusTransformUtils.mapRes(R.string.memory_pending_load_failed, TypedValues.Custom.S_STRING, "memory_pending_load_failed"));
        FragmentMemoryPersonalChildBinding r36 = this.binding;
        if (r36 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r36 = null;
    L20:
        r36.emptyDescription.setText(ZeusTransformUtils.mapRes(R.string.memory_pending_tap_retry, TypedValues.Custom.S_STRING, "memory_pending_tap_retry"));
        FragmentMemoryPersonalChildBinding r37 = this.binding;
        if (r37 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L24:
        r8.layoutEmpty.setOnClickListener(new $$Lambda$PersonalChildFragment$MxEmwjMwUsOC75NruFiLi3swWaE(this));
        return;
    L23:
        r8 = r37;
        goto L24
    }

    private static final void updateEmptyState$lambda$38(PersonalChildFragment r0, View r1) {
        r0.getPendingPersonalInfoViewModel().refresh();
    }

    private static final PersonalChildViewModel viewModel_delegate$lambda$0(PersonalChildFragment r3) {
        return (PersonalChildViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r3, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(PersonalChildViewModel.class), PersonalChildViewModel.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, Long> displayedSemanticVersions$memory_obricRelease() {
        if (this.groupListAdapter == null) goto L22;
        if (Intrinsics.areEqual(getTagType(), getShareViewModel().getSelectedTag()) == false) goto L22;
        PersonalGroupListAdapter r6 = this.groupListAdapter;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
        r6 = null;
    L10:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6.c().getItems(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L16;
        Object r2 = r8.next();
        if (ZeusTransformUtils.instanceOf(r2, bc.a.class) == false) goto L12;
        r0.add(r2);
        goto L12
    L16:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map<String, Long> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r9, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L18:
        if (r10.hasNext() == false) goto L20;
        bc.a r3 = (bc.a) ZeusTransformUtils.preCheckCast(r10.next(), bc.a.class, "com.obric.memorydata.plugin");
        Pair r4 = TuplesKt.to(r3.a(), Long.valueOf(r3.d()));
        r1.put(r4.getFirst(), r4.getSecond());
        goto L18
    L20:
        return r1;
    L22:
        return MapsKt.emptyMap();
    }

    public Function1<com.obric.memorydata.memory.ui.data.a, Unit> getOnItemDislike() {
        return this.onItemDislike;
    }

    public final PersonalChildViewModel getViewModel() {
        return (PersonalChildViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), PersonalChildViewModel.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        FragmentMemoryPersonalChildBinding r7 = FragmentMemoryPersonalChildBinding.inflate(r4, r5, false);
        Intrinsics.checkNotNullExpressionValue(r7, "inflate(...)");
        this.binding = r7;
        Fragment r8 = getParentFragment();
        FragmentMemoryPersonalChildBinding r9 = null;
        if (ZeusTransformUtils.instanceOf(r8, PersonalTabFragment.class) == false) goto L5;
        PersonalTabFragment r10 = (PersonalTabFragment) ZeusTransformUtils.preCheckCast(r8, PersonalTabFragment.class, "com.obric.memorydata.plugin");
    L6:
        if (r10 == null) goto L9;
        ViewPager2 r11 = r10.getPersonalViewPager();
        if (r11 == null) goto L9;
    L10:
        this.viewPager = r11;
        FragmentMemoryPersonalChildBinding r3 = this.binding;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L14:
        ConstraintLayout r12 = r9.getRoot();
        Intrinsics.checkNotNullExpressionValue(r12, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin");
    L13:
        r9 = r3;
    L9:
        r11 = (ViewPager2) ZeusTransformUtils.preCheckCast(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.view_pager_memory, OaidModel.KEY_ID, "view_pager_memory")), ViewPager2.class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getShareViewModel().getSelectionManager().j();
        RunLog.INSTANCE.debug(TAG, "[MEM] " + getTagType() + " onDestroyEditMode");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.isViewDestroyed = true;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r1 = new StringBuilder().append("[MEM] ").append(getTagType()).append(" onDestroyView pid=").append(Process.myPid()).append(" source=");
        WeakReference<SemanticMemoryPagingSource> r2 = this.currentPagingSourceRef;
        if (r2 == null) goto L7;
        SemanticMemoryPagingSource r3 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r2.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        Long r5 = Long.valueOf(r3.debugId());
    L8:
        IRunLog.a.a(r4, TAG, r1.append(r5).append(' ').append(buildOwnerSnapshot()).append(' ').append(buildAdapterSnapshot()).toString(), false, 4, null);
        bx r6 = this.pagingJob;
        if (r6 == null) goto L11;
        bx.a.a(r6, null, 1, null);
    L11:
        this.pagingJob = null;
        WeakReference<SemanticMemoryPagingSource> r0 = this.currentPagingSourceRef;
        if (r0 == null) goto L16;
        SemanticMemoryPagingSource r7 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r0.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L16;
        r7.dispose("onDestroyView");
    L16:
        this.currentPagingSourceRef = null;
        ap r8 = this.pendingConfirmationSheet;
        if (r8 == null) goto L19;
        r8.a();
    L19:
        this.pendingConfirmationSheet = null;
        this.pendingPreviewAdapter = null;
        com.obric.memorydata.memory.ui.a r9 = this.recyclerViewInterceptor;
        if (r9 == null) goto L22;
        r9.c();
    L22:
        this.recyclerViewInterceptor = null;
        return;
    L7:
        r5 = null;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (AppContext.INSTANCE.isDebug() == false) goto L6;
        RunLog.INSTANCE.debug(TAG, "[MEM] " + getTagType() + " onStart needRefreshOnStart=" + this.needRefreshOnStart);
    L6:
        if (this.needRefreshOnStart == false) goto L9;
        this.needRefreshOnStart = false;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.needRefreshOnStart = true;
        RunLog.INSTANCE.debug(TAG, "[MEM] " + getTagType() + " onStop markNeedRefresh");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        this.isViewDestroyed = false;
        this.viewGenerationId++;
        this.lastVisibleWindowLogKey = null;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[MEM] " + getTagType() + " onViewCreated pid=" + Process.myPid() + " position=" + getPosition() + ' ' + buildOwnerSnapshot(), false, 4, null);
        setupRecyclerView();
        observeData();
    }

    public final void refreshFormalItems$memory_obricRelease() {
        WeakReference<SemanticMemoryPagingSource> r2 = this.currentPagingSourceRef;
        if (r2 == null) goto L8;
        SemanticMemoryPagingSource r3 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(r2.get(), SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.externalInvalidate("formalDeleteResult");
        return;
    L9:
        return;
    }

    public void setOnItemDislike(Function1<? super com.obric.memorydata.memory.ui.data.a, Unit> r3) {
        this.onItemDislike = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
    }
}
