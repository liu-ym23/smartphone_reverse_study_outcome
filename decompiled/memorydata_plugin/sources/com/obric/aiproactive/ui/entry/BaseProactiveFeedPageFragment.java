package com.obric.aiproactive.ui.entry;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.obric.aiproactive.api.PageType;
import com.obric.aiproactive.api.ProactiveInspirationDto;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.ui.databinding.FragmentProactiveFeedPageBinding;
import com.obric.aiproactive.ui.databinding.SheetEditInstructionBinding;
import com.obric.aiproactive.ui.detail.RecommendationDetailActivity;
import com.obric.aiproactive.ui.feedback.ProactiveVoteStore;
import com.obric.aiproactive.ui.list.ProactiveListAdapter;
import com.obric.cae.userAware.WifiScanSceneType;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u008e\u00012\u00020\u0001:\u0002\u008e\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH$J\u0010\u0010E\u001a\u00020B2\u0006\u0010F\u001a\u00020GH\u0014J\b\u0010H\u001a\u00020BH\u0014J\u0010\u0010I\u001a\u00020B2\u0006\u0010F\u001a\u00020JH\u0014J\b\u0010K\u001a\u00020BH\u0014J\b\u0010L\u001a\u00020BH\u0014J\b\u0010M\u001a\u00020\nH\u0014J \u0010N\u001a\u00020B2\u0006\u0010O\u001a\u00020\u00152\u0006\u0010C\u001a\u00020D2\u0006\u0010P\u001a\u00020QH\u0014J\b\u0010R\u001a\u00020\nH\u0014J\u0018\u0010S\u001a\u00020\u00152\u0006\u0010T\u001a\u00020\u00152\u0006\u0010U\u001a\u00020\u0015H\u0014J\u0018\u0010V\u001a\u00020\u00152\u0006\u0010W\u001a\u00020\u00152\u0006\u0010X\u001a\u00020\u0015H\u0014J$\u0010Y\u001a\u0002032\u0006\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u001a\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u0002032\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\b\u0010b\u001a\u00020BH\u0004J\b\u0010c\u001a\u00020BH\u0004J\b\u0010d\u001a\u00020BH\u0016J\b\u0010e\u001a\u00020BH\u0016J\u0018\u0010f\u001a\u00020B2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u000209H\u0002J\u0010\u0010j\u001a\u00020B2\u0006\u0010g\u001a\u00020hH\u0002J\u0010\u0010k\u001a\u00020\n2\u0006\u0010g\u001a\u00020hH\u0002J\u0010\u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u000209H\u0002J!\u0010n\u001a\u00020B2\u0006\u0010o\u001a\u0002092\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u0015H\u0004¢\u0006\u0002\u0010qJ!\u0010r\u001a\u00020B2\u0006\u0010s\u001a\u00020h2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010tJ)\u0010r\u001a\u00020B2\u0006\u0010o\u001a\u0002092\b\u0010s\u001a\u0004\u0018\u00010h2\b\u0010p\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010uJ\b\u0010v\u001a\u000209H\u0004J\u0010\u0010w\u001a\u00020B2\u0006\u0010x\u001a\u00020yH\u0004J\b\u0010z\u001a\u00020BH\u0002J\u001c\u0010{\u001a\b\u0012\u0004\u0012\u00020h0|2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020~0|H\u0004J\u0011\u0010\u007f\u001a\u00020B2\u0007\u0010\u0080\u0001\u001a\u000209H\u0004J\t\u0010\u0081\u0001\u001a\u00020BH\u0004J\u001c\u0010\u0082\u0001\u001a\u00020B2\u0006\u0010o\u001a\u0002092\t\u0010\u0083\u0001\u001a\u0004\u0018\u000109H\u0002J(\u0010\u0084\u0001\u001a\u00020B2\u0007\u0010\u0085\u0001\u001a\u00020\n2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020~0|2\u0006\u0010C\u001a\u00020DH\u0014J\u0011\u0010\u0086\u0001\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002J#\u0010\u0087\u0001\u001a\u00020B2\u0006\u0010F\u001a\u00020G2\u0007\u0010\u0088\u0001\u001a\u00020\u00152\u0007\u0010i\u001a\u00030\u0089\u0001H\u0002J\u0011\u0010\u008a\u0001\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u0011X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001dX¤\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001b\u0010&\u001a\u00020'8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b/\u0010%\u001a\u0004\b-\u0010.R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00107\u001a\u0012\u0012\u0004\u0012\u00020908j\b\u0012\u0004\u0012\u000209`:X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010;\u001a\u0012\u0012\u0004\u0012\u00020908j\b\u0012\u0004\u0012\u000209`:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u0002090=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u008b\u0001\u001a\u0002098DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001¨\u0006\u008f\u0001"}, d2 = {"Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedPageFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/obric/aiproactive/ui/databinding/FragmentProactiveFeedPageBinding;", "binding", "getBinding", "()Lcom/obric/aiproactive/ui/databinding/FragmentProactiveFeedPageBinding;", "isBindingAvailable", "", "()Z", "executor", "Lcom/obric/aiproactive/ui/task/ProactiveTaskExecutor;", "voteStore", "Lcom/obric/aiproactive/ui/feedback/ProactiveVoteStore;", "pageType", "Lcom/obric/aiproactive/api/PageType;", "getPageType", "()Lcom/obric/aiproactive/api/PageType;", "backgroundResId", "", "getBackgroundResId", "()I", "adapterMode", "Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Mode;", "getAdapterMode", "()Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Mode;", "baseViewModel", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel;", "getBaseViewModel", "()Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel;", "repository", "Lcom/obric/aiproactive/ui/data/ProactiveRepository;", "getRepository", "()Lcom/obric/aiproactive/ui/data/ProactiveRepository;", "repository$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Lcom/obric/aiproactive/ui/entry/ProactiveFeedPageViewModelFactory;", "getViewModelFactory", "()Lcom/obric/aiproactive/ui/entry/ProactiveFeedPageViewModelFactory;", "viewModelFactory$delegate", "startupCoordinatorViewModel", "Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorViewModel;", "getStartupCoordinatorViewModel", "()Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorViewModel;", "startupCoordinatorViewModel$delegate", "editInstructionSheet", "Lcom/obric/oui/sheet/v2/OSheet;", "overlayTitleContainer", "Landroid/view/View;", "overlayBottomHandle", "overlayLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "handledExternalAdoptedIds", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "handledExternalDismissedIds", "continueSubmissionsInFlight", "", "pageScrollGate", "Lcom/obric/aiproactive/ui/util/UserScrollReportGate;", "pageDataStarted", "observePageState", "", "adapter", "Lcom/obric/aiproactive/ui/list/ProactiveListAdapter;", "onRecommendationAdopted", "item", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "onBeforeOpenRecommendationDetail", "onDayHeaderClick", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$DayHeader;", "onTipKnown", "onPageEntered", "canStartPageData", "onRecyclerScrolled", "dy", "layoutManager", "Lcom/obric/oui/orecyclerview/widget/LinearLayoutManager;", "useDefaultEmptyState", "resolveBottomPadding", "bottomHandleHeight", "extraBottom", "resolveTopPadding", "titleContainerBottom", "extraTop", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onNestedPageScrolled", "ensurePageDataStarted", "onResume", "onDestroyView", "reportAction", "dto", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "action", "updateRecommendStatusToAdopted", "isAiProactiveRecommendation", "isKnownActionText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "openInspirationDetail", "inspirationId", "rank", "(Ljava/lang/String;Ljava/lang/Integer;)V", "openRecommendationDetail", NotificationCompat.CATEGORY_RECOMMENDATION, "(Lcom/obric/aiproactive/api/ProactiveRecommendationDto;Ljava/lang/Integer;)V", "(Ljava/lang/String;Lcom/obric/aiproactive/api/ProactiveRecommendationDto;Ljava/lang/Integer;)V", "currentSessionEnterFrom", "handleStartupDecision", "decision", "Lcom/obric/aiproactive/ui/entry/StartupInspirationDecision;", "reportVisibleCardsOnForeground", "extractRecommendations", "", "items", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", "copyDebugLogId", "debugLogId", "adjustListPaddingForOverlays", "showEditInstructionSheet", "currentText", "renderPageState", "loading", "applyExternalAdoptedState", "submitContinueAction", "actionIndex", "Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;", "applyExternalDismissedState", "logTag", "getLogTag", "()Ljava/lang/String;", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BaseProactiveFeedPageFragment extends Fragment {
    private static final a Companion = null;
    private static final String TAG = "ProactiveUI";
    private FragmentProactiveFeedPageBinding _binding;
    private Set<String> continueSubmissionsInFlight;
    private OSheet editInstructionSheet;
    private final com.obric.aiproactive.ui.task.a executor;
    private final LinkedHashSet<String> handledExternalAdoptedIds;
    private final LinkedHashSet<String> handledExternalDismissedIds;
    private View overlayBottomHandle;
    private View.OnLayoutChangeListener overlayLayoutListener;
    private View overlayTitleContainer;
    private boolean pageDataStarted;
    private com.obric.aiproactive.ui.util.q pageScrollGate;
    private final Lazy repository$delegate;
    private final Lazy startupCoordinatorViewModel$delegate;
    private final Lazy viewModelFactory$delegate;
    private final ProactiveVoteStore voteStore;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedPageFragment$Companion;", "", "<init>", "()V", "TAG", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseProactiveFeedPageFragment f6567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f6568b;
        final /* synthetic */ int c;
        final /* synthetic */ View d;
        final /* synthetic */ int e;

        public b(BaseProactiveFeedPageFragment r1, View r2, int r3, View r4, int r5) {
            this.f6567a = r1;
            this.f6568b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
            BaseProactiveFeedPageFragment.access$adjustListPaddingForOverlays$updatePadding(this.f6567a, this.f6568b, this.c, this.d, this.e);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseProactiveFeedPageFragment f6569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f6570b;
        final /* synthetic */ int c;
        final /* synthetic */ View d;
        final /* synthetic */ int e;

        public c(BaseProactiveFeedPageFragment r1, View r2, int r3, View r4, int r5) {
            this.f6569a = r1;
            this.f6570b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
            BaseProactiveFeedPageFragment.access$adjustListPaddingForOverlays$updatePadding(this.f6569a, this.f6570b, this.c, this.d, this.e);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"com/obric/aiproactive/ui/entry/BaseProactiveFeedPageFragment$onViewCreated$2", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseProactiveFeedPageFragment f6571a;

        d(BaseProactiveFeedPageFragment r1) {
            this.f6571a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public void a(boolean r1) {
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public boolean a(RecyclerView r2, MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r2, "rv");
            Intrinsics.checkNotNullParameter(r3, "event");
            int r4 = r3.getActionMasked();
            if (r4 != 0) goto L5;
            BaseProactiveFeedPageFragment.access$getPageScrollGate$p(this.f6571a).a();
            return false;
        L5:
            if (r4 != 1) goto L7;
        L9:
            BaseProactiveFeedPageFragment.access$getPageScrollGate$p(this.f6571a).c();
            return false;
        L7:
            if (r4 == 3) goto L9;
            return false;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public void b(RecyclerView r1, MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r1, "rv");
            Intrinsics.checkNotNullParameter(r2, "event");
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/obric/aiproactive/ui/entry/BaseProactiveFeedPageFragment$onViewCreated$3", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseProactiveFeedPageFragment f6572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ProactiveListAdapter f6573b;
        final /* synthetic */ LinearLayoutManager c;

        e(BaseProactiveFeedPageFragment r1, ProactiveListAdapter r2, LinearLayoutManager r3) {
            this.f6572a = r1;
            this.f6573b = r2;
            this.c = r3;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            if (r3 == 0) goto L5;
            return;
        L5:
            if (BaseProactiveFeedPageFragment.access$getPageScrollGate$p(this.f6572a).d() == false) goto L12;
            com.obric.aiproactive.ui.util.h r4 = com.obric.aiproactive.ui.util.h.f6884a;
            if (this.f6572a.getPageType() != PageType.NOW) goto L9;
            String r5 = "home";
        L10:
            r4.b(r5);
            goto L12
        L9:
            r5 = "proactive_all";
        L12:
            if (this.f6572a.isResumed() == false) goto L16;
            this.f6573b.a(this.c);
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "recyclerView");
            if (r4 != 0) goto L5;
            if (r5 != 0) goto L5;
        L6:
            float r6 = RangesKt.coerceIn(r3.computeVerticalScrollOffset() / 120.0f, 0.0f, 1.0f);
            FragmentActivity r7 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6572a.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r7, ProactiveV2Activity.class) == false) goto L9;
            ProactiveV2Activity r8 = (ProactiveV2Activity) ZeusTransformUtils.preCheckCast(r7, ProactiveV2Activity.class, "com.obric.memorydata.plugin");
        L10:
            if (r8 == null) goto L12;
            r8.setTitleBlurAlpha(r6);
        L12:
            this.f6572a.onRecyclerScrolled(r5, this.f6573b, this.c);
            return;
        L9:
            r8 = null;
        L5:
            BaseProactiveFeedPageFragment.access$getPageScrollGate$p(this.f6572a).b();
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001f\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\bH\u0016J/\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000bJ\u001f\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000bJ\u001f\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\u0015"}, d2 = {"com/obric/aiproactive/ui/entry/BaseProactiveFeedPageFragment$onViewCreated$adapter$1", "Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Listener;", "onTipKnown", "", "onDayHeaderClick", "item", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$DayHeader;", "onRecommendationClick", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "rank", "", "(Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;Ljava/lang/Integer;)V", "onRecommendationLongClick", "onSummaryActionClick", "actionIndex", "action", "Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;", "(Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;Ljava/lang/Integer;ILcom/obric/aiproactive/api/AiProactiveActionExecuteItem;)V", "onPrimaryActionClick", "onIgnoreClick", "onCardShow", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements ProactiveListAdapter.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseProactiveFeedPageFragment f6574a;

        f(BaseProactiveFeedPageFragment r1) {
            this.f6574a = r1;
        }

        @Override // com.obric.aiproactive.ui.list.ProactiveListAdapter.f
        public void a() {
            this.f6574a.onTipKnown();
        }

        @Override // com.obric.aiproactive.ui.list.ProactiveListAdapter.f
        public void a(com.obric.aiproactive.ui.model.j.a r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.f6574a.onDayHeaderClick(r2);
        }

        @Override // com.obric.aiproactive.ui.list.ProactiveListAdapter.f
        public void a(com.obric.aiproactive.ui.model.j.f r8) {
            Intrinsics.checkNotNullParameter(r8, "item");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f6574a.getLogTag(), "[Fragment] onRecommendationLongClick id=" + r8.b().getRecommendId(), false, 4, null);
            this.f6574a.getBaseViewModel().requestCopyDebugLogId(r8.b().getRecommendId());
        }

        @Override // com.obric.aiproactive.ui.list.ProactiveListAdapter.f
        public void a(com.obric.aiproactive.ui.model.j.f r14, Integer r15) {
            Intrinsics.checkNotNullParameter(r14, "item");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f6574a.getLogTag(), "[Fragment] onRecommendationClick id=" + r14.b().getRecommendId() + " status=" + r14.b().getRecommendStatus() + " from=" + this.f6574a.getPageType(), false, 4, null);
            com.obric.aiproactive.ui.util.h r7 = com.obric.aiproactive.ui.util.h.f6884a;
            if (this.f6574a.getPageType() != PageType.NOW) goto L5;
            String r0 = "home";
        L6:
            r7.a(r0, "unlock_screen", MemoryListActivity.JUMP_FROM_DETAIL, r14.b().getRecommendId(), r15);
            BaseProactiveFeedPageFragment.access$openRecommendationDetail(this.f6574a, r14.b(), r15);
            return;
        L5:
            r0 = "proactive_all";
            goto L6
        }

        @Override // com.obric.aiproactive.ui.list.ProactiveListAdapter.f
        public void a(com.obric.aiproactive.ui.model.j.f r20, Integer r21, int r22, com.obric.aiproactive.api.b r23) {
            Intrinsics.checkNotNullParameter(r20, "item");
            Intrinsics.checkNotNullParameter(r23, "action");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f6574a.getLogTag(), "[Fragment] onSummaryActionClick id=" + r20.b().getRecommendId() + " status=" + r20.b().getRecommendStatus() + " actionIndex=" + r22 + " format=" + r23.d() + " from=" + this.f6574a.getPageType(), false, 4, null);
            com.obric.aiproactive.ui.util.h r13 = com.obric.aiproactive.ui.util.h.f6884a;
            if (this.f6574a.getPageType() != PageType.NOW) goto L5;
            String r2 = "home";
        L6:
            r13.a(r2, "unlock_screen", "click_button", r20.b().getRecommendId(), r21);
            if (com.obric.aiproactive.ui.detail.d.c(r20.b()) == false) goto L10;
            return;
        L10:
            if (BaseProactiveFeedPageFragment.access$isAiProactiveRecommendation(this.f6574a, r20.b()) == false) goto L25;
            if (StringsKt.toLongOrNull(r20.b().getRecommendId()) != null) goto L15;
            return;
        L15:
            if (r23.i() == false) goto L19;
            BaseProactiveFeedPageFragment.access$submitContinueAction(this.f6574a, r20, r22, r23);
            return;
        L19:
            if (r23.j() == true) goto L22;
            this.f6574a.onRecommendationAdopted(r20);
            BaseProactiveFeedViewModel.markAiRecommendationActionExecuted$default(this.f6574a.getBaseViewModel(), r20.b(), r22, AiProactiveCardStatus.ACKNOWLEDGED, null, 8, null);
            return;
        L22:
            kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this.f6574a, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new BaseProactiveFeedPageFragment$onViewCreated$adapter$1$onSummaryActionClick$1(r23, this.f6574a, r20, r22, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return;
        L25:
            if (r23.j() == false) goto L27;
            kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this.f6574a, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new BaseProactiveFeedPageFragment$onViewCreated$adapter$1$onSummaryActionClick$2(r23, this.f6574a, r20, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return;
        L27:
            this.f6574a.onRecommendationAdopted(r20);
            BaseProactiveFeedViewModel.optimisticallyUpdateRecommendStatus$default(this.f6574a.getBaseViewModel(), r20.b().getInspirationId(), 2, false, 4, null);
            BaseProactiveFeedPageFragment.access$updateRecommendStatusToAdopted(this.f6574a, r20.b());
            return;
        L5:
            r2 = "proactive_all";
            goto L6
        }

        @Override // com.obric.aiproactive.ui.list.ProactiveListAdapter.f
        public void b() {
            ProactiveListAdapter.f.a.a(this);
        }

        @Override // com.obric.aiproactive.ui.list.ProactiveListAdapter.f
        public void b(com.obric.aiproactive.ui.model.j.f r18, Integer r19) {
            Intrinsics.checkNotNullParameter(r18, "item");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f6574a.getLogTag(), "[Fragment] onIgnoreClick id=" + r18.b().getRecommendId() + " from=" + this.f6574a.getPageType(), false, 4, null);
            com.obric.aiproactive.ui.util.h r11 = com.obric.aiproactive.ui.util.h.f6884a;
            if (this.f6574a.getPageType() != PageType.NOW) goto L5;
            String r2 = "home";
        L6:
            r11.a(r2, "unlock_screen", "ignore", r18.b().getRecommendId(), r19);
            if (com.obric.aiproactive.ui.detail.d.c(r18.b()) == false) goto L10;
            return;
        L10:
            if (BaseProactiveFeedPageFragment.access$isAiProactiveRecommendation(this.f6574a, r18.b()) == false) goto L15;
            this.f6574a.onRecommendationAdopted(r18);
            BaseProactiveFeedViewModel r0 = this.f6574a.getBaseViewModel();
            Long r1 = StringsKt.toLongOrNull(r18.b().getRecommendId());
            if (r1 == null) goto L19;
            r0.updateAiRecommendationCardStatus(r1.longValue(), AiProactiveCardStatus.DISMISSED);
            return;
        L19:
            return;
        L15:
            this.f6574a.onRecommendationAdopted(r18);
            this.f6574a.getBaseViewModel().optimisticallyUpdateRecommendStatus(r18.b().getInspirationId(), 2, true);
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r18.b().getInspirationId(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L20;
            this.f6574a.getBaseViewModel().updateInspiration(new ProactiveInspirationDto(r18.b().getInspirationId(), r18.b().getTaskId(), r18.b().getRecommendId(), 2, "ignore", r18.b().getInspirationUserFeedback(), r18.b().getCreated()));
            return;
        L20:
            return;
        L5:
            r2 = "proactive_all";
            goto L6
        }

        @Override // com.obric.aiproactive.ui.list.ProactiveListAdapter.f
        public void c(com.obric.aiproactive.ui.model.j.f r3, Integer r4) {
            Intrinsics.checkNotNullParameter(r3, "item");
            com.obric.aiproactive.ui.util.h r0 = com.obric.aiproactive.ui.util.h.f6884a;
            if (this.f6574a.getPageType() != PageType.NOW) goto L5;
            String r2 = "home";
        L6:
            r0.a(r2, "unlock_screen", r3.b().getRecommendId(), r4);
            return;
        L5:
            r2 = "proactive_all";
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/aiproactive/ui/entry/BaseProactiveFeedPageFragment$showEditInstructionSheet$1", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SheetEditInstructionBinding f6575a;

        g(SheetEditInstructionBinding r1) {
            this.f6575a = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r3) {
            Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.memorydata.plugin");
            BaseProactiveFeedPageFragment.access$showEditInstructionSheet$updateCounter(this.f6575a);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$4", f = "BaseProactiveFeedPageFragment.kt", i = {}, l = {480}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProactiveListAdapter $adapter;
        int label;
        final /* synthetic */ BaseProactiveFeedPageFragment this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$4$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$4$1", f = "BaseProactiveFeedPageFragment.kt", i = {}, l = {481}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProactiveListAdapter $adapter;
            int label;
            final /* synthetic */ BaseProactiveFeedPageFragment this$0;

            /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$4$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/aiproactive/ui/ipc/ProactiveUiSyncStore$AdoptedEvent;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$4$1$1", f = "BaseProactiveFeedPageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            static final class C02961 extends SuspendLambda implements Function2<com.obric.aiproactive.ui.ipc.a.C0305a, Continuation<? super Unit>, Object> {
                final /* synthetic */ ProactiveListAdapter $adapter;
                int label;
                final /* synthetic */ BaseProactiveFeedPageFragment this$0;

                C02961(BaseProactiveFeedPageFragment r3, ProactiveListAdapter r4, Continuation<? super C02961> r5) {
                    Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                    this.this$0 = r3;
                    this.$adapter = r4;
                    super(2, r6);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                    Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    return (Continuation) ZeusTransformUtils.preCheckCast(new C02961(this.this$0, this.$adapter, r5), Continuation.class, "com.obric.memorydata.plugin");
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(com.obric.aiproactive.ui.ipc.a.C0305a r3, Continuation<? super Unit> r4) {
                    return ((C02961) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C02961.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Object invoke(com.obric.aiproactive.ui.ipc.a.C0305a r3, Continuation<? super Unit> r4) {
                    return invoke2((com.obric.aiproactive.ui.ipc.a.C0305a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.ui.ipc.a.C0305a.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r2) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r2);
                    BaseProactiveFeedPageFragment.access$applyExternalAdoptedState(this.this$0, this.$adapter);
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            AnonymousClass1(BaseProactiveFeedPageFragment r3, ProactiveListAdapter r4, Continuation<? super AnonymousClass1> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                this.$adapter = r4;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$adapter, r5), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r8) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r8);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r8);
                kotlinx.coroutines.flow.i r9 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(com.obric.aiproactive.ui.ipc.a.f6677a.a(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
                Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C02961(this.this$0, this.$adapter, null), Function2.class, "com.obric.memorydata.plugin");
                Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                if (kotlinx.coroutines.flow.k.a(r9, r2, r3) != r0) goto L12;
                return r0;
            }
        }

        AnonymousClass4(BaseProactiveFeedPageFragment r3, ProactiveListAdapter r4, Continuation<? super AnonymousClass4> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$adapter = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.this$0, this.$adapter, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            LifecycleOwner r9 = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(r9, "getViewLifecycleOwner(...)");
            Lifecycle.State r2 = Lifecycle.State.STARTED;
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$adapter, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r9, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$5", f = "BaseProactiveFeedPageFragment.kt", i = {}, l = {488}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProactiveListAdapter $adapter;
        int label;
        final /* synthetic */ BaseProactiveFeedPageFragment this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$5$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$5$1", f = "BaseProactiveFeedPageFragment.kt", i = {}, l = {489}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProactiveListAdapter $adapter;
            int label;
            final /* synthetic */ BaseProactiveFeedPageFragment this$0;

            /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$5$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/aiproactive/ui/ipc/ProactiveUiSyncStore$DismissedEvent;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$5$1$1", f = "BaseProactiveFeedPageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            static final class C02971 extends SuspendLambda implements Function2<com.obric.aiproactive.ui.ipc.a.b, Continuation<? super Unit>, Object> {
                final /* synthetic */ ProactiveListAdapter $adapter;
                int label;
                final /* synthetic */ BaseProactiveFeedPageFragment this$0;

                C02971(BaseProactiveFeedPageFragment r3, ProactiveListAdapter r4, Continuation<? super C02971> r5) {
                    Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                    this.this$0 = r3;
                    this.$adapter = r4;
                    super(2, r6);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                    Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    return (Continuation) ZeusTransformUtils.preCheckCast(new C02971(this.this$0, this.$adapter, r5), Continuation.class, "com.obric.memorydata.plugin");
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(com.obric.aiproactive.ui.ipc.a.b r3, Continuation<? super Unit> r4) {
                    return ((C02971) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C02971.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Object invoke(com.obric.aiproactive.ui.ipc.a.b r3, Continuation<? super Unit> r4) {
                    return invoke2((com.obric.aiproactive.ui.ipc.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.ui.ipc.a.b.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r2) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r2);
                    BaseProactiveFeedPageFragment.access$applyExternalDismissedState(this.this$0, this.$adapter);
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            AnonymousClass1(BaseProactiveFeedPageFragment r3, ProactiveListAdapter r4, Continuation<? super AnonymousClass1> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                this.$adapter = r4;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$adapter, r5), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r8) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r8);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r8);
                kotlinx.coroutines.flow.i r9 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(com.obric.aiproactive.ui.ipc.a.f6677a.b(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
                Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C02971(this.this$0, this.$adapter, null), Function2.class, "com.obric.memorydata.plugin");
                Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                if (kotlinx.coroutines.flow.k.a(r9, r2, r3) != r0) goto L12;
                return r0;
            }
        }

        AnonymousClass5(BaseProactiveFeedPageFragment r3, ProactiveListAdapter r4, Continuation<? super AnonymousClass5> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$adapter = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this.this$0, this.$adapter, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass5) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass5.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            LifecycleOwner r9 = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(r9, "getViewLifecycleOwner(...)");
            Lifecycle.State r2 = Lifecycle.State.STARTED;
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$adapter, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r9, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$6", f = "BaseProactiveFeedPageFragment.kt", i = {}, l = {498}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProactiveListAdapter $adapter;
        int label;
        final /* synthetic */ BaseProactiveFeedPageFragment this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$6$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$6$1", f = "BaseProactiveFeedPageFragment.kt", i = {}, l = {WifiScanSceneType.GEO_END}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProactiveListAdapter $adapter;
            int label;
            final /* synthetic */ BaseProactiveFeedPageFragment this$0;

            /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$6$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel$UiEvent;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$onViewCreated$6$1$1", f = "BaseProactiveFeedPageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            static final class C02981 extends SuspendLambda implements Function2<BaseProactiveFeedViewModel.b, Continuation<? super Unit>, Object> {
                final /* synthetic */ ProactiveListAdapter $adapter;
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ BaseProactiveFeedPageFragment this$0;

                C02981(BaseProactiveFeedPageFragment r3, ProactiveListAdapter r4, Continuation<? super C02981> r5) {
                    Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                    this.this$0 = r3;
                    this.$adapter = r4;
                    super(2, r6);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                    Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                    C02981 r0 = new C02981(this.this$0, this.$adapter, r6);
                    r0.L$0 = r4;
                    return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(BaseProactiveFeedViewModel.b r3, Continuation<? super Unit> r4) {
                    return ((C02981) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C02981.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Object invoke(BaseProactiveFeedViewModel.b r3, Continuation<? super Unit> r4) {
                    return invoke2((BaseProactiveFeedViewModel.b) ZeusTransformUtils.preCheckCast(r3, BaseProactiveFeedViewModel.b.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r9) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L22;
                    ResultKt.throwOnFailure(r9);
                    BaseProactiveFeedViewModel.b r10 = (BaseProactiveFeedViewModel.b) ZeusTransformUtils.preCheckCast(this.L$0, BaseProactiveFeedViewModel.b.class, "com.obric.memorydata.plugin");
                    IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.this$0.getLogTag(), "[Fragment] uiEvent type=" + r10.getClass().getSimpleName(), false, 4, null);
                    if (ZeusTransformUtils.instanceOf(r10, BaseProactiveFeedViewModel.b.d.class) == false) goto L8;
                    this.$adapter.h();
                L18:
                    return Unit.INSTANCE;
                L8:
                    if (ZeusTransformUtils.instanceOf(r10, BaseProactiveFeedViewModel.b.C0299b.class) == false) goto L11;
                    BaseProactiveFeedPageFragment.access$showEditInstructionSheet(this.this$0, ((BaseProactiveFeedViewModel.b.C0299b) ZeusTransformUtils.preCheckCast(r10, BaseProactiveFeedViewModel.b.C0299b.class, "com.obric.memorydata.plugin")).a(), ((BaseProactiveFeedViewModel.b.C0299b) ZeusTransformUtils.preCheckCast(r10, BaseProactiveFeedViewModel.b.C0299b.class, "com.obric.memorydata.plugin")).b());
                    goto L18
                L11:
                    if (ZeusTransformUtils.instanceOf(r10, BaseProactiveFeedViewModel.b.a.class) == false) goto L15;
                    this.this$0.copyDebugLogId(((BaseProactiveFeedViewModel.b.a) ZeusTransformUtils.preCheckCast(r10, BaseProactiveFeedViewModel.b.a.class, "com.obric.memorydata.plugin")).a());
                    Toast r8 = Toast.makeText((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(this.this$0.getString(ZeusTransformUtils.mapRes(R.string.proactive_debug_log_copied, TypedValues.Custom.S_STRING, "proactive_debug_log_copied")), CharSequence.class, "com.obric.memorydata.plugin"), 0);
                L13:
                    r8.show();
                    goto L18
                L15:
                    if (ZeusTransformUtils.instanceOf(r10, BaseProactiveFeedViewModel.b.c.class) == false) goto L20;
                    r8 = Toast.makeText((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(((BaseProactiveFeedViewModel.b.c) ZeusTransformUtils.preCheckCast(r10, BaseProactiveFeedViewModel.b.c.class, "com.obric.memorydata.plugin")).a(), CharSequence.class, "com.obric.memorydata.plugin"), 0);
                    goto L13
                L20:
                    throw new NoWhenBranchMatchedException();
                L22:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            AnonymousClass1(BaseProactiveFeedPageFragment r3, ProactiveListAdapter r4, Continuation<? super AnonymousClass1> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                this.$adapter = r4;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$adapter, r5), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r8) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r8);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r8);
                kotlinx.coroutines.flow.i r9 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.this$0.getBaseViewModel().getUiEvent(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
                Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C02981(this.this$0, this.$adapter, null), Function2.class, "com.obric.memorydata.plugin");
                Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                if (kotlinx.coroutines.flow.k.a(r9, r2, r3) != r0) goto L12;
                return r0;
            }
        }

        AnonymousClass6(BaseProactiveFeedPageFragment r3, ProactiveListAdapter r4, Continuation<? super AnonymousClass6> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$adapter = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this.this$0, this.$adapter, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass6) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass6.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            LifecycleOwner r9 = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(r9, "getViewLifecycleOwner(...)");
            Lifecycle.State r2 = Lifecycle.State.RESUMED;
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$adapter, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r9, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$submitContinueAction$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment$submitContinueAction$1", f = "BaseProactiveFeedPageFragment.kt", i = {0, 1, 1, 1, 2}, l = {880, 889, 893}, m = "invokeSuspend", n = {"accepted", Ext.KEY_REQUEST, "recommendationId", "accepted", "accepted"}, s = {"I$0", "L$0", "L$1", "I$0", "I$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.obric.aiproactive.api.b $action;
        final /* synthetic */ int $actionIndex;
        final /* synthetic */ com.obric.aiproactive.ui.model.j.f $item;
        final /* synthetic */ Set<String> $pageGate;
        final /* synthetic */ String $recommendationKey;
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ BaseProactiveFeedPageFragment this$0;

        AnonymousClass1(Set<String> r3, String r4, BaseProactiveFeedPageFragment r5, com.obric.aiproactive.api.b r6, int r7, com.obric.aiproactive.ui.model.j.f r8, Continuation<? super AnonymousClass1> r9) {
            Set<String> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            this.$pageGate = r10;
            this.$recommendationKey = r4;
            this.this$0 = r5;
            this.$action = r6;
            this.$actionIndex = r7;
            this.$item = r8;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$pageGate, this.$recommendationKey, this.this$0, this.$action, this.$actionIndex, this.$item, r8), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            int r2 = 0;
            int r5 = 1;
            if (r1 == 0) goto L28;
            if (r1 == 1) goto L21;
            if (r1 == 2) goto L18;
            if (r1 != 3) goto L17;
            r5 = this.I$0;
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
        L89:
        L54:
            r1 = r5;
        L60:
            if (r1 != 0) goto L68;
        L61:
            this.$pageGate.remove(this.$recommendationKey);
        L68:
            if (this.this$0.isBindingAvailable() == false) goto L70;
            if (r1 != 0) goto L93;
            Toast.makeText((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(this.this$0.getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_user_requirement_failure, TypedValues.Custom.S_STRING, "ai_proactive_user_requirement_failure")), CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
        L80:
            return Unit.INSTANCE;
        L93:
            this.this$0.onRecommendationAdopted(this.$item);     // Catch: RuntimeException -> L74 CancellationException -> L76
            this.this$0.getBaseViewModel().refresh();     // Catch: RuntimeException -> L74 CancellationException -> L76
        L76:
            e = move-exception;
            throw e;
        L74:
            e = move-exception;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.this$0.getLogTag(), "[Fragment] continueAction localProjectionFailed type=" + e.getClass().getSimpleName(), null, 4, null);
            goto L80
        L70:
            return Unit.INSTANCE;
        L58:
            e = move-exception;
            throw e;     // Catch: Throwable -> L62
        L57:
            r1 = r5;
            goto L65
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            r1 = this.I$0;
            Long r4 = (Long) ZeusTransformUtils.preCheckCast(this.L$1, Long.class, "com.obric.memorydata.plugin");
            com.obric.aiproactive.api.x r7 = (com.obric.aiproactive.api.x) ZeusTransformUtils.preCheckCast(this.L$0, com.obric.aiproactive.api.x.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L86
        L46:
            com.obric.aiproactive.api.z r16 = (com.obric.aiproactive.api.z) ZeusTransformUtils.preCheckCast(r15, com.obric.aiproactive.api.z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L86
            if (r16.a() == false) goto L60;
            goto L65
        L50:
            if (r16.c() != r7.b()) goto L60;
            com.obric.aiproactive.ui.data.b r8 = this.this$0.getRepository();     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            long r9 = r4.longValue();     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            int r10 = this.$actionIndex;     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            AiProactiveCardStatus r11 = AiProactiveCardStatus.ACKNOWLEDGED;     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            Continuation<? super Unit> r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            this.L$0 = null;     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            this.L$1 = null;     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            this.I$0 = 1;     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            this.label = 3;     // Catch: Throwable -> L10 RuntimeException -> L12 CancellationException -> L14
            if (r8.a(r9, r10, r11, r12) != r0) goto L89;
            return r0;
        L21:
            r1 = this.I$0;
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L86
        L37:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L60;
            r7 = com.obric.aiproactive.api.y.a(this.$action, com.obric.aiproactive.api.y.a(), System.currentTimeMillis());     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L86
            Long r17 = StringsKt.toLongOrNull(this.$recommendationKey);     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L86
            if (r7 == null) goto L60;
            if (r17 == null) goto L60;
            com.obric.aiproactive.ui.data.b r13 = this.this$0.getRepository();     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L86
            Continuation<? super com.obric.aiproactive.api.z> r14 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L86
            this.L$0 = r7;     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L86
            this.L$1 = r17;     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L86
            this.I$0 = r1;     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L86
            this.label = 2;     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L86
            Object r6 = r13.a(r7, r14);     // Catch: Throwable -> L24 CancellationException -> L26 RuntimeException -> L86
            if (r6 != r0) goto L45;
            return r0;
        L45:
            r4 = r17;
            r15 = r6;
            goto L46
        L28:
            ResultKt.throwOnFailure(r15);
            if (this.$pageGate.add(this.$recommendationKey) == false) goto L31;
            com.obric.aiproactive.ui.data.b r18 = this.this$0.getRepository();     // Catch: Throwable -> L62 RuntimeException -> L64 CancellationException -> L81
            Continuation<? super Boolean> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L62 RuntimeException -> L64 CancellationException -> L81
            this.I$0 = 0;     // Catch: Throwable -> L62 RuntimeException -> L64 CancellationException -> L81
            this.label = 1;     // Catch: Throwable -> L62 RuntimeException -> L64 CancellationException -> L81
            r15 = r18.a(r3);     // Catch: Throwable -> L62 RuntimeException -> L64 CancellationException -> L81
            if (r15 != r0) goto L35;
            return r0;
        L35:
            r1 = 0;
            goto L37
        L81:
            e = move-exception;
            throw e;     // Catch: Throwable -> L62
        L64:
            r1 = 0;
            goto L65
        L31:
            return Unit.INSTANCE;
        L10:
            th = th;
            r2 = 1;
        L83:
            if (r2 != 0) goto L85;
            this.$pageGate.remove(this.$recommendationKey);
        L85:
            throw th;
        L62:
            th = th;
        L14:
            e = move-exception;
            throw e;     // Catch: Throwable -> L10 RuntimeException -> L57 CancellationException -> L58
        L12:
            e = move-exception;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.this$0.getLogTag(), "[Fragment] continueAction localMarkFailed type=" + e.getClass().getSimpleName(), null, 4, null);     // Catch: Throwable -> L10 RuntimeException -> L57 CancellationException -> L58
        L26:
            e = move-exception;
            throw e;     // Catch: Throwable -> L62
        L24:
            th = th;
            r2 = r1;
        L65:
            if (r1 != 0) goto L68;
            goto L61
        }
    }

    static {
        Companion = new a(null);
    }

    public BaseProactiveFeedPageFragment() {
        this.executor = new com.obric.aiproactive.ui.task.a(null, 1, null);
        this.voteStore = new ProactiveVoteStore();
        this.repository$delegate = LazyKt.lazy($$Lambda$BaseProactiveFeedPageFragment$KbyCTE1gXvuOvAnJJz3izz8tA.INSTANCE);
        this.viewModelFactory$delegate = LazyKt.lazy(new $$Lambda$BaseProactiveFeedPageFragment$GLEGXz3n91Eu7DTPQtutzdm_Ts(this));
        this.startupCoordinatorViewModel$delegate = LazyKt.lazy(new $$Lambda$BaseProactiveFeedPageFragment$JPHcfmGccrGSmZaaRS4464EAno(this));
        this.handledExternalAdoptedIds = new LinkedHashSet();
        this.handledExternalDismissedIds = new LinkedHashSet();
        this.continueSubmissionsInFlight = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.pageScrollGate = new com.obric.aiproactive.ui.util.q();
    }

    public static final /* synthetic */ void access$adjustListPaddingForOverlays$updatePadding(BaseProactiveFeedPageFragment r0, View r1, int r2, View r3, int r4) {
        adjustListPaddingForOverlays$updatePadding(r0, r1, r2, r3, r4);
    }

    public static final /* synthetic */ void access$applyExternalAdoptedState(BaseProactiveFeedPageFragment r0, ProactiveListAdapter r1) {
        r0.applyExternalAdoptedState(r1);
    }

    public static final /* synthetic */ void access$applyExternalDismissedState(BaseProactiveFeedPageFragment r0, ProactiveListAdapter r1) {
        r0.applyExternalDismissedState(r1);
    }

    public static final /* synthetic */ com.obric.aiproactive.ui.task.a access$getExecutor$p(BaseProactiveFeedPageFragment r0) {
        return r0.executor;
    }

    public static final /* synthetic */ com.obric.aiproactive.ui.util.q access$getPageScrollGate$p(BaseProactiveFeedPageFragment r0) {
        return r0.pageScrollGate;
    }

    public static final /* synthetic */ boolean access$isAiProactiveRecommendation(BaseProactiveFeedPageFragment r0, ProactiveRecommendationDto r1) {
        return r0.isAiProactiveRecommendation(r1);
    }

    public static final /* synthetic */ boolean access$isKnownActionText(BaseProactiveFeedPageFragment r0, String r1) {
        return r0.isKnownActionText(r1);
    }

    public static final /* synthetic */ void access$openRecommendationDetail(BaseProactiveFeedPageFragment r0, ProactiveRecommendationDto r1, Integer r2) {
        r0.openRecommendationDetail(r1, r2);
    }

    public static final /* synthetic */ void access$showEditInstructionSheet(BaseProactiveFeedPageFragment r0, String r1, String r2) {
        r0.showEditInstructionSheet(r1, r2);
    }

    public static final /* synthetic */ void access$showEditInstructionSheet$updateCounter(SheetEditInstructionBinding r0) {
        showEditInstructionSheet$updateCounter(r0);
    }

    public static final /* synthetic */ void access$submitContinueAction(BaseProactiveFeedPageFragment r0, com.obric.aiproactive.ui.model.j.f r1, int r2, com.obric.aiproactive.api.b r3) {
        r0.submitContinueAction(r1, r2, r3);
    }

    public static final /* synthetic */ void access$updateRecommendStatusToAdopted(BaseProactiveFeedPageFragment r0, ProactiveRecommendationDto r1) {
        r0.updateRecommendStatusToAdopted(r1);
    }

    private static final void adjustListPaddingForOverlays$lambda$9(BaseProactiveFeedPageFragment r0, View r1, int r2, View r3, int r4, View r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13) {
        adjustListPaddingForOverlays$updatePadding(r0, r1, r2, r3, r4);
    }

    private static final void adjustListPaddingForOverlays$updatePadding(BaseProactiveFeedPageFragment r0, View r1, int r2, View r3, int r4) {
        int r5 = r0.resolveTopPadding(r1.getBottom(), r2);
        int r6 = r0.resolveBottomPadding(r3.getHeight(), r4);
        r0.getBinding().recyclerView.setPadding(r0.getBinding().recyclerView.getPaddingLeft(), r5, r0.getBinding().recyclerView.getPaddingRight(), r6);
    }

    private final void applyExternalAdoptedState(ProactiveListAdapter r13) {
        com.obric.aiproactive.ui.ipc.a r0 = com.obric.aiproactive.ui.ipc.a.f6677a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "requireContext(...)");
        Map<String, com.obric.aiproactive.ui.ipc.a.C0305a> r2 = r0.a(r1);
        if (r2.isEmpty() == false) goto L5;
        return;
    L5:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13.a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L7:
        if (r15.hasNext() == false) goto L11;
        Object r4 = r15.next();
        if (ZeusTransformUtils.instanceOf(r4, com.obric.aiproactive.ui.model.j.f.class) == false) goto L7;
        r3.add(r4);
        goto L7
    L11:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r16.hasNext() == false) goto L23;
        com.obric.aiproactive.ui.model.j.f r5 = (com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin");
        String r6 = r5.b().getRecommendId();
        com.obric.aiproactive.ui.ipc.a.C0305a r7 = (com.obric.aiproactive.ui.ipc.a.C0305a) ZeusTransformUtils.preCheckCast(r2.get(r6), com.obric.aiproactive.ui.ipc.a.C0305a.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        if (this.handledExternalAdoptedIds.add(r6) == false) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[Fragment] applyExternalAdoptedState id=" + r6 + " pageType=" + getPageType() + " oldStatus=" + r5.b().getRecommendStatus() + " action=" + r7.a(), false, 4, null);
        onRecommendationAdopted(r5);
        if (r5.b().getRecommendStatus() == 2) goto L22;
        getBaseViewModel().optimisticallyUpdateRecommendStatus(r5.b().getInspirationId(), 2, Intrinsics.areEqual(r7.a(), "ignore"));
    L22:
        getBaseViewModel().optimisticallyUpdateFeedbackAction(r5.b().getInspirationId(), r7.a());
        goto L13
    }

    private final void applyExternalDismissedState(ProactiveListAdapter r12) {
        if (getPageType() == PageType.NOW) goto L5;
        return;
    L5:
        com.obric.aiproactive.ui.ipc.a r0 = com.obric.aiproactive.ui.ipc.a.f6677a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "requireContext(...)");
        Map<String, com.obric.aiproactive.ui.ipc.a.b> r2 = r0.b(r1);
        if (r2.isEmpty() == false) goto L8;
        return;
    L8:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12.a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L14;
        Object r4 = r14.next();
        if (ZeusTransformUtils.instanceOf(r4, com.obric.aiproactive.ui.model.j.f.class) == false) goto L10;
        r3.add(r4);
        goto L10
    L14:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r15.hasNext() == false) goto L23;
        String r5 = ((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getRecommendId();
        com.obric.aiproactive.ui.ipc.a.b r6 = (com.obric.aiproactive.ui.ipc.a.b) ZeusTransformUtils.preCheckCast(r2.get(r5), com.obric.aiproactive.ui.ipc.a.b.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L16;
        if (this.handledExternalDismissedIds.add(r5) == false) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[Fragment] applyExternalDismissedState id=" + r5 + " pageType=" + getPageType() + " reason=" + r6.a(), false, 4, null);
        getBaseViewModel().onRecommendationDismissedFromSync(r5);
        goto L16
    }

    private final boolean isAiProactiveRecommendation(ProactiveRecommendationDto r1) {
        return Intrinsics.areEqual(r1.getType(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE);
    }

    private final boolean isKnownActionText(String r4) {
        if (Intrinsics.areEqual(r4, getString(ZeusTransformUtils.mapRes(R.string.proactive_known, TypedValues.Custom.S_STRING, "proactive_known"))) == false) goto L5;
    L12:
        return true;
    L5:
        if (Intrinsics.areEqual(r4, "知道了") == true) goto L12;
        if (Intrinsics.areEqual(r4, "我知道了") == true) goto L12;
        if (Intrinsics.areEqual(r4, "已知晓") == true) goto L12;
        return false;
    }

    /* JADX INFO: renamed from: lambda$0q95YL3NPxrIqalRY2bb-hw7rRI, reason: not valid java name */
    public static /* synthetic */ void m262lambda$0q95YL3NPxrIqalRY2bbhw7rRI(BaseProactiveFeedPageFragment r0, View r1, int r2, View r3, int r4, View r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13) {
        adjustListPaddingForOverlays$lambda$9(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ void lambda$7SalQYNix5T3rq5FgjcnfxsIkz4(BaseProactiveFeedPageFragment r0, View r1) {
        onViewCreated$lambda$5(r0, r1);
    }

    public static /* synthetic */ void lambda$BbYS7gjsglmq8CUvF4RI7EmIgnk(BaseProactiveFeedPageFragment r0, String r1, OSheet r2, View r3) {
        showEditInstructionSheet$lambda$14$lambda$12(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$CSFVR9OCNrnB5cxGE1wUQSS8NGk(SheetEditInstructionBinding r0, BaseProactiveFeedPageFragment r1, String r2, OSheet r3, View r4) {
        showEditInstructionSheet$lambda$14$lambda$13(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$FvZdAdvRdDFCkRAxd27E5dJTzJA(SheetEditInstructionBinding r0, BaseProactiveFeedPageFragment r1) {
        showEditInstructionSheet$lambda$15(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$GLEGXz3n91Eu7D-TPQtutzdm_Ts, reason: not valid java name */
    public static /* synthetic */ ProactiveFeedPageViewModelFactory m263lambda$GLEGXz3n91Eu7DTPQtutzdm_Ts(BaseProactiveFeedPageFragment r0) {
        return viewModelFactory_delegate$lambda$2(r0);
    }

    /* JADX INFO: renamed from: lambda$JPHcfmGccrGSmZaaRS4464-EAno, reason: not valid java name */
    public static /* synthetic */ StartupInspirationCoordinatorViewModel m264lambda$JPHcfmGccrGSmZaaRS4464EAno(BaseProactiveFeedPageFragment r0) {
        return startupCoordinatorViewModel_delegate$lambda$3(r0);
    }

    public static /* synthetic */ void lambda$Jtj5he4UhP2OPY6oVmh2dqYaNRI(BaseProactiveFeedPageFragment r0, FragmentProactiveFeedPageBinding r1, RecyclerView r2, ProactiveListAdapter r3) {
        renderPageState$lambda$17(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$KbyC-TE1gXvuOvAn-JJz3izz8tA, reason: not valid java name */
    public static /* synthetic */ com.obric.aiproactive.ui.data.a m265lambda$KbyCTE1gXvuOvAnJJz3izz8tA() {
        return repository_delegate$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$wTOIZZS7WdrKADKfowrx-QgSHV4, reason: not valid java name */
    public static /* synthetic */ long m266lambda$wTOIZZS7WdrKADKfowrxQgSHV4() {
        return viewModelFactory_delegate$lambda$2$lambda$1();
    }

    private static final void onViewCreated$lambda$5(BaseProactiveFeedPageFragment r8, View r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r8.getLogTag(), "[Fragment] clickEmptyHistory pageType=" + r8.getPageType(), false, 4, null);
        Intent r10 = new Intent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), com.obric.aiproactive.ui.entry.b.a());
        r10.putExtra("enter_from", r8.currentSessionEnterFrom());
        ZeusTransformUtils.startActivity(r8, r10, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void openInspirationDetail$default(BaseProactiveFeedPageFragment r0, String r1, Integer r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.openInspirationDetail(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openInspirationDetail");
    }

    private final void openRecommendationDetail(ProactiveRecommendationDto r2, Integer r3) {
        openRecommendationDetail(r2.getInspirationId(), r2, r3);
    }

    private final void openRecommendationDetail(String r10, ProactiveRecommendationDto r11, Integer r12) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        onBeforeOpenRecommendationDetail();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[StartupFlow] openInspirationDetail inspirationId=" + r10 + " pageType=" + getPageType(), false, 4, null);
        getBaseViewModel().selectInspiration(r10);
        String r6 = currentSessionEnterFrom();
        if (getPageType() != PageType.NOW) goto L8;
        String r0 = "home";
    L9:
        RecommendationDetailActivity.a r2 = RecommendationDetailActivity.Companion;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "requireContext(...)");
        ZeusTransformUtils.startActivity(this, r2.a(r3, r10, r11, r6, r0, r12), "com.obric.memorydata.plugin");
        FragmentActivity r9 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, i.class) == false) goto L12;
        i r13 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, "com.obric.memorydata.plugin");
    L13:
        if (r13 == null) goto L16;
        r13.onHomeChildPageOpened("proactive_card_detail");
        return;
    L16:
        return;
    L12:
        r13 = null;
        goto L13
    L8:
        r0 = "proactive_all";
        goto L9
    }

    static /* synthetic */ void openRecommendationDetail$default(BaseProactiveFeedPageFragment r0, ProactiveRecommendationDto r1, Integer r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.openRecommendationDetail(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openRecommendationDetail");
    }

    private static final void renderPageState$lambda$17(BaseProactiveFeedPageFragment r1, FragmentProactiveFeedPageBinding r2, RecyclerView r3, ProactiveListAdapter r4) {
        if (r1._binding == r2) goto L5;
        return;
    L5:
        RecyclerView.h r5 = r3.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r5, LinearLayoutManager.class) == false) goto L8;
        LinearLayoutManager r6 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r5, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L9:
        if (r6 != null) goto L11;
        return;
    L11:
        if (r1.isResumed() == false) goto L15;
        r4.a(r6);
        return;
    L15:
        return;
    L8:
        r6 = null;
        goto L9
    }

    private final void reportAction(ProactiveRecommendationDto r11, String r12) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11.getInspirationId(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[Fragment] reportAction id=" + r11.getRecommendId() + " inspirationId=" + r11.getInspirationId() + " action=" + r12, false, 4, null);
        getBaseViewModel().updateInspiration(new ProactiveInspirationDto(r11.getInspirationId(), r11.getTaskId(), r11.getRecommendId(), r11.getRecommendStatus(), r12, null, r11.getCreated()));
    }

    private final void reportVisibleCardsOnForeground() {
        RecyclerView.h r0 = getBinding().recyclerView.getLayoutManager();
        ProactiveListAdapter r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, LinearLayoutManager.class) == false) goto L5;
        LinearLayoutManager r1 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r0, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L6:
        RecyclerView.Adapter r2 = getBinding().recyclerView.getAdapter();
        if (ZeusTransformUtils.instanceOf(r2, ProactiveListAdapter.class) == false) goto L9;
        r3 = (ProactiveListAdapter) ZeusTransformUtils.preCheckCast(r2, ProactiveListAdapter.class, "com.obric.memorydata.plugin");
    L9:
        if (r1 == null) goto L13;
        if (r3 == null) goto L14;
        applyExternalAdoptedState(r3);
        applyExternalDismissedState(r3);
        r3.c();
        r3.a(r1);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final com.obric.aiproactive.ui.data.a repository_delegate$lambda$0() {
        return new com.obric.aiproactive.ui.data.a();
    }

    private final void showEditInstructionSheet(final String r24, String r25) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        OSheet r2 = this.editInstructionSheet;
        if (r2 == null) goto L8;
        r2.dismiss();
    L8:
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r6 = getLogTag();
        StringBuilder r3 = new StringBuilder().append("[Fragment] showEditInstructionSheet inspirationId=").append(r24).append(" currentLen=");
        if (r25 == null) goto L11;
        int r7 = r25.length();
    L12:
        IRunLog.a.a(r5, r6, r3.append(r7).toString(), false, 4, null);
        final SheetEditInstructionBinding r4 = SheetEditInstructionBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        EditText r8 = r4.etContent;
        if (r25 != null) goto L15;
        String r9 = "";
    L16:
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"));
        EditText r10 = r4.etContent;
        Editable r11 = r4.etContent.getText();
        if (r11 == null) goto L19;
        int r12 = r11.length();
    L20:
        r10.setSelection(r12);
        showEditInstructionSheet$updateCounter(r4);
        r4.etContent.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new g(r4), TextWatcher.class, "com.obric.memorydata.plugin"));
        FragmentActivity r13 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r13, "requireActivity(...)");
        final OSheet r14 = new OSheet((Context) ZeusTransformUtils.preCheckCast(r13, Context.class, "com.obric.memorydata.plugin"), 0, 0, false, false, 30, null);
        r14.a(OSheet.HeightMode.WRAP_HEIGHT);
        r14.e(false);
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(r14, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), OSheet.Header.ACTION, Integer.valueOf(ZeusTransformUtils.mapRes(R.string.proactive_executor_title, TypedValues.Custom.S_STRING, "proactive_executor_title")), null, null, null, true, new $$Lambda$BaseProactiveFeedPageFragment$BbYS7gjsglmq8CUvF4RI7EmIgnk(this, r24, r14), new $$Lambda$BaseProactiveFeedPageFragment$CSFVR9OCNrnB5cxGE1wUQSS8NGk(r4, this, r24, r14), null, null, null, null, null, null, 16156, null);
        r14.c((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
        this.editInstructionSheet = r14;
        r14.show();     // Catch: Exception -> L23
        r4.etContent.postDelayed(new $$Lambda$BaseProactiveFeedPageFragment$FvZdAdvRdDFCkRAxd27E5dJTzJA(r4, this), 300);     // Catch: Exception -> L23
        return;
    L26:
        return;
    L19:
        r12 = 0;
        goto L20
    L15:
        r9 = r25;
        goto L16
    L11:
        r7 = 0;
        goto L12
    }

    private static final void showEditInstructionSheet$lambda$14$lambda$12(BaseProactiveFeedPageFragment r6, String r7, OSheet r8, View r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r6.getLogTag(), "[Fragment] dismissEditInstructionSheet inspirationId=" + r7, false, 4, null);
        r8.dismiss();
    }

    private static final void showEditInstructionSheet$lambda$14$lambda$13(SheetEditInstructionBinding r6, BaseProactiveFeedPageFragment r7, String r8, OSheet r9, View r10) {
        Editable r11 = r6.etContent.getText();
        if (r11 == null) goto L5;
        String r12 = r11.toString();
    L6:
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r1 = r7.getLogTag();
        StringBuilder r13 = new StringBuilder().append("[Fragment] confirmEditInstruction inspirationId=").append(r8).append(" newLen=");
        if (r12 == null) goto L9;
        int r2 = r12.length();
    L10:
        IRunLog.a.a(r0, r1, r13.append(r2).toString(), false, 4, null);
        r7.getBaseViewModel().updateActionExecuteInstruction(r8, r12);
        r9.dismiss();
        return;
    L9:
        r2 = 0;
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    private static final void showEditInstructionSheet$lambda$15(SheetEditInstructionBinding r2, BaseProactiveFeedPageFragment r3) {
        r2.etContent.requestFocus();
        Object r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r4, InputMethodManager.class) == false) goto L5;
        InputMethodManager r5 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r4, InputMethodManager.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 == null) goto L9;
        r5.showSoftInput((View) ZeusTransformUtils.preCheckCast(r2.etContent, View.class, "com.obric.memorydata.plugin"), 1);
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    private static final void showEditInstructionSheet$updateCounter(SheetEditInstructionBinding r3) {
        Editable r0 = r3.etContent.getText();
        if (r0 == null) goto L5;
        int r1 = r0.length();
    L6:
        r3.tvCounter.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1 + "/500", CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r1 = 0;
        goto L6
    }

    private static final StartupInspirationCoordinatorViewModel startupCoordinatorViewModel_delegate$lambda$3(BaseProactiveFeedPageFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (StartupInspirationCoordinatorViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(StartupInspirationCoordinatorViewModel.class), StartupInspirationCoordinatorViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void submitContinueAction(com.obric.aiproactive.ui.model.j.f r17, int r18, com.obric.aiproactive.api.b r19) {
        if (r19.i() == true) goto L5;
        return;
    L5:
        String r3 = r17.b().getRecommendId();
        Set<String> r2 = this.continueSubmissionsInFlight;
        LifecycleOwner r1 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r1, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r1), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2, r3, this, r19, r18, r17, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void updateRecommendStatusToAdopted(ProactiveRecommendationDto r11) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11.getInspirationId(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[Fragment] updateRecommendStatusToAdopted id=" + r11.getRecommendId() + " inspirationId=" + r11.getInspirationId(), false, 4, null);
        BaseProactiveFeedViewModel r10 = getBaseViewModel();
        String r1 = r11.getInspirationId();
        String r2 = r11.getTaskId();
        String r3 = r11.getRecommendId();
        String r0 = r11.getInspirationFeedbackAction();
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        r10.updateInspiration(new ProactiveInspirationDto(r1, r2, r3, 2, r0, r11.getInspirationUserFeedback(), r11.getCreated()));
    }

    private static final ProactiveFeedPageViewModelFactory viewModelFactory_delegate$lambda$2(BaseProactiveFeedPageFragment r4) {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "getApplicationContext(...)");
        return new ProactiveFeedPageViewModelFactory(r1, r4.getRepository(), $$Lambda$BaseProactiveFeedPageFragment$wTOIZZS7WdrKADKfowrxQgSHV4.INSTANCE);
    }

    private static final long viewModelFactory_delegate$lambda$2$lambda$1() {
        return System.currentTimeMillis();
    }

    public final void adjustListPaddingForOverlays() {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L33;
        final View r1 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.title_container, OaidModel.KEY_ID, "title_container"));
        if (r1 == null) goto L36;
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L34;
        final View r3 = r2.findViewById(ZeusTransformUtils.mapRes(R.id.bottom_more_handle, OaidModel.KEY_ID, "bottom_more_handle"));
        if (r3 == null) goto L37;
        final int r4 = (int) (12 * ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density);
        View.OnLayoutChangeListener r5 = this.overlayLayoutListener;
        if (r5 == null) goto L20;
        View r6 = this.overlayTitleContainer;
        if (r6 == null) goto L17;
        r6.removeOnLayoutChangeListener(r5);
    L17:
        View r7 = this.overlayBottomHandle;
        if (r7 == null) goto L20;
        r7.removeOnLayoutChangeListener(r5);
    L20:
        this.overlayTitleContainer = r1;
        this.overlayBottomHandle = r3;
        View.OnLayoutChangeListener r10 = new $$Lambda$BaseProactiveFeedPageFragment$0q95YL3NPxrIqalRY2bbhw7rRI(this, r1, r4, r3, r4);
        this.overlayLayoutListener = r10;
        r1.addOnLayoutChangeListener(r10);
        r3.addOnLayoutChangeListener(r10);
        if (ViewCompat.isLaidOut(r1) == true) goto L23;
    L25:
        r1.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new b(this, r1, r4, r3, r4), View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
    L27:
        if (ViewCompat.isLaidOut(r3) == true) goto L29;
    L31:
        r3.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new c(this, r1, r4, r3, r4), View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
        return;
    L29:
        if (r3.isLayoutRequested() == true) goto L31;
        access$adjustListPaddingForOverlays$updatePadding(this, r1, r4, r3, r4);
        return;
    L23:
        if (r1.isLayoutRequested() == true) goto L25;
        access$adjustListPaddingForOverlays$updatePadding(this, r1, r4, r3, r4);
        goto L27
    L37:
        return;
    L34:
        return;
    L36:
        return;
    }

    public boolean canStartPageData() {
        return true;
    }

    public final void copyDebugLogId(String r11) {
        Intrinsics.checkNotNullParameter(r11, "debugLogId");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[Fragment] copyDebugLogId debugLogId=" + r11, false, 4, null);
        Object r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("clipboard");
        if (ZeusTransformUtils.instanceOf(r10, ClipboardManager.class) == false) goto L5;
        ClipboardManager r12 = (ClipboardManager) ZeusTransformUtils.preCheckCast(r10, ClipboardManager.class, "com.obric.memorydata.plugin");
    L6:
        if (r12 != null) goto L8;
        return;
    L8:
        r12.setPrimaryClip(ClipData.newPlainText((CharSequence) ZeusTransformUtils.preCheckCast("debugLogId", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")));
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final String currentSessionEnterFrom() {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, ProactiveV2Activity.class) == false) goto L5;
        ProactiveV2Activity r1 = (ProactiveV2Activity) ZeusTransformUtils.preCheckCast(r0, ProactiveV2Activity.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L9;
        String r2 = r1.currentEnterFrom();
        if (r2 == null) goto L9;
        return r2;
    L9:
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, i.class) == false) goto L12;
        i r5 = (i) ZeusTransformUtils.preCheckCast(r4, i.class, "com.obric.memorydata.plugin");
    L13:
        if (r5 != null) goto L29;
        FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L20;
        Intent r7 = r6.getIntent();
        if (r7 == null) goto L20;
        String r8 = r7.getStringExtra("enter_from");
    L21:
        FragmentActivity r9 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L27;
        Intent r10 = r9.getIntent();
        if (r10 == null) goto L27;
        r3 = r10.getStringExtra("inspirationId");
    L27:
        return com.obric.aiproactive.ui.util.n.a(r8, r3);
    L20:
        r8 = null;
        goto L21
    L29:
        return r5.currentHomeEnterFrom();
    L12:
        r5 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void ensurePageDataStarted() {
        if (this.pageDataStarted == false) goto L5;
        return;
    L5:
        this.pageDataStarted = true;
        getBaseViewModel().startIfNeeded();
    }

    public final List<ProactiveRecommendationDto> extractRecommendations(List<? extends com.obric.aiproactive.ui.model.j> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "items");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r1 = r7.next();
        if (ZeusTransformUtils.instanceOf(r1, com.obric.aiproactive.ui.model.j.f.class) == false) goto L4;
        r6.add(r1);
        goto L4
    L8:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L10:
        if (r10.hasNext() == false) goto L13;
        r9.add(((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b());
        goto L10
    L13:
        return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
    }

    public abstract ProactiveListAdapter.Mode getAdapterMode();

    public abstract int getBackgroundResId();

    public abstract BaseProactiveFeedViewModel getBaseViewModel();

    public final FragmentProactiveFeedPageBinding getBinding() {
        FragmentProactiveFeedPageBinding r0 = this._binding;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final String getLogTag() {
        return TAG;
    }

    public abstract PageType getPageType();

    public final com.obric.aiproactive.ui.data.b getRepository() {
        return (com.obric.aiproactive.ui.data.b) ZeusTransformUtils.preCheckCast(this.repository$delegate.getValue(), com.obric.aiproactive.ui.data.b.class, "com.obric.memorydata.plugin");
    }

    public final StartupInspirationCoordinatorViewModel getStartupCoordinatorViewModel() {
        return (StartupInspirationCoordinatorViewModel) ZeusTransformUtils.preCheckCast(this.startupCoordinatorViewModel$delegate.getValue(), StartupInspirationCoordinatorViewModel.class, "com.obric.memorydata.plugin");
    }

    public final ProactiveFeedPageViewModelFactory getViewModelFactory() {
        return (ProactiveFeedPageViewModelFactory) ZeusTransformUtils.preCheckCast(this.viewModelFactory$delegate.getValue(), ProactiveFeedPageViewModelFactory.class, "com.obric.memorydata.plugin");
    }

    public final void handleStartupDecision(ae r10) {
        ae r11 = (ae) ZeusTransformUtils.wrapperContextForParams(r10, ae.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "decision");
        ProactiveV2Activity r2 = null;
        if (ZeusTransformUtils.instanceOf(r11, ae.b.class) == false) goto L10;
        openInspirationDetail$default(this, ((ae.b) ZeusTransformUtils.preCheckCast(r11, ae.b.class, "com.obric.memorydata.plugin")).a(), null, 2, null);
        FragmentActivity r9 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, ProactiveV2Activity.class) == false) goto L7;
        r2 = (ProactiveV2Activity) ZeusTransformUtils.preCheckCast(r9, ProactiveV2Activity.class, "com.obric.memorydata.plugin");
    L7:
        if (r2 == null) goto L23;
    L8:
        r2.onStartupDetailHandled();
        return;
    L23:
        return;
    L10:
        if (Intrinsics.areEqual(r11, ae.c.f6606a) == false) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[StartupFlow] handleStartupDecision fallbackToAll pageType=" + getPageType(), false, 4, null);
        FragmentActivity r12 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, ProactiveV2Activity.class) == false) goto L14;
        r2 = (ProactiveV2Activity) ZeusTransformUtils.preCheckCast(r12, ProactiveV2Activity.class, "com.obric.memorydata.plugin");
    L14:
        if (r2 == null) goto L27;
        r2.showAllPageForStartupFallback();
        return;
    L27:
        return;
    L17:
        if (Intrinsics.areEqual(r11, ae.a.f6604a) == false) goto L25;
        RunLog.INSTANCE.debug(getLogTag(), "[StartupFlow] handleStartupDecision none pageType=" + getPageType());
        FragmentActivity r13 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ProactiveV2Activity.class) == false) goto L21;
        r2 = (ProactiveV2Activity) ZeusTransformUtils.preCheckCast(r13, ProactiveV2Activity.class, "com.obric.memorydata.plugin");
    L21:
        if (r2 != null) goto L8;
        return;
    L25:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isBindingAvailable() {
        if (this._binding != null) goto L5;
    L7:
        return false;
    L5:
        if (getView() == null) goto L7;
        return true;
    }

    public abstract void observePageState(ProactiveListAdapter r1);

    public void onBeforeOpenRecommendationDetail() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        this._binding = FragmentProactiveFeedPageBinding.inflate(r1, r2, false);
        ConstraintLayout r0 = getBinding().root;
        Intrinsics.checkNotNullExpressionValue(r0, "root");
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    }

    public void onDayHeaderClick(com.obric.aiproactive.ui.model.j.a r1) {
        Intrinsics.checkNotNullParameter(r1, "item");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[Fragment] onDestroyView pageType=" + getPageType(), false, 4, null);
        this.handledExternalAdoptedIds.clear();
        this.handledExternalDismissedIds.clear();
        View.OnLayoutChangeListener r0 = this.overlayLayoutListener;
        if (r0 == null) goto L10;
        View r1 = this.overlayTitleContainer;
        if (r1 == null) goto L7;
        r1.removeOnLayoutChangeListener(r0);
    L7:
        View r2 = this.overlayBottomHandle;
        if (r2 == null) goto L10;
        r2.removeOnLayoutChangeListener(r0);
    L10:
        this.overlayLayoutListener = null;
        this.overlayTitleContainer = null;
        this.overlayBottomHandle = null;
        OSheet r3 = this.editInstructionSheet;
        if (r3 == null) goto L13;
        r3.dismiss();
    L13:
        this.editInstructionSheet = null;
        getBaseViewModel().selectInspiration(null);
        this.continueSubmissionsInFlight = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this._binding = null;
        super.onDestroyView();
    }

    public final void onNestedPageScrolled() {
        this.pageScrollGate.b();
    }

    public void onPageEntered() {
    }

    public void onRecommendationAdopted(com.obric.aiproactive.ui.model.j.f r1) {
        Intrinsics.checkNotNullParameter(r1, "item");
    }

    public void onRecyclerScrolled(int r1, ProactiveListAdapter r2, LinearLayoutManager r3) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        Intrinsics.checkNotNullParameter(r3, "layoutManager");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[Fragment] onResume pageType=" + getPageType(), false, 4, null);
        if (canStartPageData() == false) goto L5;
        ensurePageDataStarted();
    L5:
        reportVisibleCardsOnForeground();
    }

    public void onTipKnown() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[Fragment] onViewCreated pageType=" + getPageType(), false, 4, null);
        if (canStartPageData() == false) goto L5;
        ensurePageDataStarted();
    L5:
        getBinding().btnEmptyHistory.setOnClickListener(new $$Lambda$BaseProactiveFeedPageFragment$7SalQYNix5T3rq5FgjcnfxsIkz4(this));
        getBinding().root.setBackgroundResource(getBackgroundResId());
        ProactiveListAdapter r12 = new ProactiveListAdapter(getAdapterMode(), (ProactiveListAdapter.f) ZeusTransformUtils.preCheckCast(new f(this), ProactiveListAdapter.f.class, "com.obric.memorydata.plugin"), this.voteStore);
        LinearLayoutManager r13 = new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        getBinding().recyclerView.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(r13, RecyclerView.h.class, "com.obric.memorydata.plugin"));
        getBinding().recyclerView.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r12, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        getBinding().recyclerView.setClipToPadding(false);
        adjustListPaddingForOverlays();
        this.pageScrollGate = new com.obric.aiproactive.ui.util.q();
        getBinding().recyclerView.addOnItemTouchListener((RecyclerView.l) ZeusTransformUtils.preCheckCast(new d(this), RecyclerView.l.class, "com.obric.memorydata.plugin"));
        getBinding().recyclerView.addOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(new e(this, r12, r13), RecyclerView.m.class, "com.obric.memorydata.plugin"));
        LifecycleOwner r14 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r14, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r14), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this, r12, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        LifecycleOwner r15 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r15, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r15), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this, r12, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        observePageState(r12);
        LifecycleOwner r16 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r16, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r16), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this, r12, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        onPageEntered();
    }

    public final void openInspirationDetail(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "inspirationId");
        openRecommendationDetail(r2, null, r3);
    }

    public void renderPageState(boolean r8, List<? extends com.obric.aiproactive.ui.model.j> r9, final ProactiveListAdapter r10) {
        List<? extends com.obric.aiproactive.ui.model.j> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "items");
        Intrinsics.checkNotNullParameter(r10, "adapter");
        final FragmentProactiveFeedPageBinding r0 = this._binding;
        if (r0 != null) goto L5;
        return;
    L5:
        RunLog.INSTANCE.debug(getLogTag(), "[Fragment] uiState pageType=" + getPageType() + " loading=" + r8 + " items=" + r11.size());
        r10.a(r11);
        applyExternalAdoptedState(r10);
        applyExternalDismissedState(r10);
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        boolean r4 = true;
        int r5 = 0;
        if (ZeusTransformUtils.instanceOf(r2, Collection.class) == true) goto L8;
    L10:
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L9;
        com.obric.aiproactive.ui.model.j r6 = (com.obric.aiproactive.ui.model.j) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.aiproactive.ui.model.j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiproactive.ui.model.j.g.class) == false) goto L16;
    L18:
        boolean r7 = false;
    L19:
        if (r7 == false) goto L12;
        boolean r1 = true;
    L21:
        if (r8 == true) goto L23;
    L25:
        boolean r12 = false;
    L27:
        if (useDefaultEmptyState() == false) goto L31;
        if (r8 == true) goto L31;
        if (r1 == true) goto L31;
    L32:
        TextView r13 = r0.tvLoading;
        if (r12 == false) goto L35;
        int r14 = 0;
    L36:
        r13.setVisibility(r14);
        ConstraintLayout r15 = r0.emptyContainer;
        if (r4 == false) goto L39;
        int r16 = 0;
    L40:
        r15.setVisibility(r16);
        final RecyclerView r17 = r0.recyclerView;
        Intrinsics.checkNotNullExpressionValue(r17, "recyclerView");
        if (r12 == true) goto L43;
        if (r4 == true) goto L43;
    L44:
        r17.setVisibility(r5);
        if (r8 == true) goto L53;
        r17.post(new $$Lambda$BaseProactiveFeedPageFragment$Jtj5he4UhP2OPY6oVmh2dqYaNRI(this, r0, r17, r10));
        return;
    L53:
        return;
    L43:
        r5 = 8;
        goto L44
    L39:
        r16 = 8;
        goto L40
    L35:
        r14 = 8;
    L31:
        r4 = false;
        goto L32
    L23:
        if (r11.isEmpty() == false) goto L25;
        r12 = true;
        goto L27
    L16:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiproactive.ui.model.j.b.class) == true) goto L18;
        r7 = true;
    L9:
        r1 = false;
        goto L21
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
        goto L9
    }

    public int resolveBottomPadding(int r1, int r2) {
        return 0;
    }

    public int resolveTopPadding(int r1, int r2) {
        return r1 + r2;
    }

    public boolean useDefaultEmptyState() {
        return true;
    }
}
