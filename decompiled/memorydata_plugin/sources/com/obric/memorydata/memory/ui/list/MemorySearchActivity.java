package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.paging.CombinedLoadStates;
import androidx.paging.PagingData;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.EventBody;
import com.obric.common.oea.foundation.blur.BlurUtils;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.memory.databinding.ActivityMemorySearchBinding;
import com.obric.memorydata.memory.memoryentity.search.MemorySearchResultCategory;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.app.UserStateManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import okhttp3.HttpUrl;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 j2\u00020\u0001:\u0003hijB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010'\u001a\u00020\u0015H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020 H\u0002J\b\u0010/\u001a\u00020-H\u0002J\u0012\u00100\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020-H\u0002J\u000e\u00104\u001a\u00020-2\u0006\u00105\u001a\u000206J\b\u00107\u001a\u00020-H\u0014J\b\u00108\u001a\u00020-H\u0002J\b\u00109\u001a\u00020-H\u0002J\u0016\u0010:\u001a\u00020-2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0010\u0010<\u001a\u00020-2\u0006\u0010=\u001a\u00020\u001dH\u0002J\b\u0010>\u001a\u00020-H\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0018H\u0002J\b\u0010B\u001a\u00020-H\u0002J\u0018\u0010C\u001a\u00020-2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\u001bJ\b\u0010G\u001a\u00020-H\u0002J\b\u0010H\u001a\u00020\"H\u0002J\b\u0010I\u001a\u00020\"H\u0002J\u0010\u0010J\u001a\u00020\"2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010K\u001a\u00020\"2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010L\u001a\u00020-H\u0002J\b\u0010M\u001a\u00020-H\u0002J\b\u0010N\u001a\u00020-H\u0002J\b\u0010O\u001a\u00020\"H\u0002J\u0010\u0010P\u001a\u00020-2\u0006\u0010Q\u001a\u00020\u0015H\u0002J\u0019\u0010R\u001a\u00020\u00152\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010TJ\u0010\u0010U\u001a\u00020\u00152\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010V\u001a\u00020\u00152\u0006\u0010W\u001a\u00020\"H\u0002J\u0012\u0010X\u001a\u00020\u00152\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0010\u0010Y\u001a\u00020\u00152\u0006\u0010D\u001a\u00020ZH\u0002J\u0010\u0010[\u001a\u00020\u00152\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010\\\u001a\u00020-H\u0002J\u0012\u0010]\u001a\u00020-2\b\b\u0002\u0010^\u001a\u00020\u001bH\u0002J\u0010\u0010_\u001a\u00020-2\u0006\u0010`\u001a\u00020\"H\u0002J\b\u0010a\u001a\u00020-H\u0002J\u001c\u0010b\u001a\u00020-2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020e0dH\u0082@¢\u0006\u0002\u0010fJ\b\u0010g\u001a\u00020-H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemorySearchActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/ActivityMemorySearchBinding;", "shareViewModel", "Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "getShareViewModel", "()Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "shareViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/obric/memorydata/memory/ui/list/SearchViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/list/SearchViewModel;", "viewModel$delegate", "memoryListAdapter", "Lcom/obric/memorydata/memory/ui/list/MemoryListAdapter;", "realQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "currentSearchTabs", "", "Lcom/obric/memorydata/memory/ui/list/SearchTab;", "selectedSearchTab", "suppressSearchTabCallback", "", "pendingSearchTabScrollCategory", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;", "pendingSearchTabScrollToTop", "currentViewState", "Lcom/obric/memorydata/memory/ui/list/MemorySearchActivity$ViewState;", "navigationBarBottom", "", "navigationBarScheme", "Lcom/obric/memorydata/ui/NavigationBarScheme;", "getNavigationBarScheme", "()Lcom/obric/memorydata/ui/NavigationBarScheme;", "getEnterFrom", "searchVersion", "", "loadingType", "Lcom/obric/memorydata/memory/ui/list/MemorySearchActivity$LoadingType;", "showViewState", "", "state", "updateSearchTabsVisibility", "onCreateChecked", "savedInstanceState", "Landroid/os/Bundle;", "initViews", "removeSingleMemoryItem", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "onResumeChecked", "manualRefresh", "setupListeners", "setupSearchTabs", "tabs", "requestSearchTabScrollToTop", EventBody.KEY_CATEGORY, "consumePendingSearchTabScrollToTop", "createSearchTabView", "Lcom/obric/memorydata/memory/ui/list/PersonalTag;", "tab", "setupNavigationBar", "controlSoftKeyboard", "view", "Landroid/view/View;", "isShow", "updateMemoryListPadding", "getMemoryListTopPadding", "getMemoryListBottomPadding", "bottomInRoot", "topInRoot", "setupSearchHeaderLayoutRefresh", "refreshSearchHeaderLayout", "setupCutOffColor", "getSearchHeaderContentBottom", "dumpSearchHeaderDiag", InfoRequestQPSOptTraceLogger.REASON, "visualBlockDiag", "listTopOverride", "(Ljava/lang/Integer;)Ljava/lang/String;", "rectDp", "pxToDp", "px", "viewDiag", "childDiag", "Landroid/view/ViewGroup;", "clipChain", "observeState", "updateSearchTabsEditState", "isEditMode", "selectSearchTabSilently", "position", "showDeleteDialog", "deleteItems", "entityMetaInfoList", "", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBackPressed", "LoadingType", "ViewState", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemorySearchActivity extends BaseMemoryActivity {
    public static final a Companion = null;
    private static final String DIAG_PREFIX = "[OTabDiag][Search]";
    private static final long MAX_LOADING_TIME = 500;
    private static final int MAX_SEARCH_LENGTH = 200;
    private static final int MEMORY_LIST_DEFAULT_BOTTOM_PADDING_DP = 40;
    private static final int MEMORY_LIST_EDIT_BOTTOM_PADDING_DP = 80;
    private static final int MEMORY_LIST_HEADER_GAP_DP = 8;
    private static final int MEMORY_LIST_SEARCH_CUT_OFF_OFFSET_DP = -8;
    private static final int MEMORY_LIST_SEARCH_TAB_HEADER_GAP_DP = 0;
    private static final int MEMORY_SEARCH_VISUAL_FILTER_AREA_DP = 52;
    private static final int MEMORY_SEARCH_VISUAL_SEARCH_AREA_DP = 56;
    private static final String TAG = "MemorySearchActivity";
    private ActivityMemorySearchBinding binding;
    private List<? extends SearchTab> currentSearchTabs;
    private ViewState currentViewState;
    private final kotlinx.coroutines.flow.ae<LoadingType> loadingType;
    private MemoryListAdapter memoryListAdapter;
    private int navigationBarBottom;
    private MemorySearchResultCategory pendingSearchTabScrollCategory;
    private boolean pendingSearchTabScrollToTop;
    private final kotlinx.coroutines.flow.ae<String> realQuery;
    private final kotlinx.coroutines.flow.ae<Long> searchVersion;
    private SearchTab selectedSearchTab;
    private final Lazy shareViewModel$delegate;
    private boolean suppressSearchTabCallback;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemorySearchActivity$LoadingType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "MINIMUM_TIME", "REAL_DATA", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum LoadingType extends Enum<LoadingType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ LoadingType[] $VALUES = null;
        public static final LoadingType MINIMUM_TIME = null;
        public static final LoadingType NONE = null;
        public static final LoadingType REAL_DATA = null;

        private static final /* synthetic */ LoadingType[] $values() {
            return new LoadingType[]{NONE, MINIMUM_TIME, REAL_DATA};
        }

        static {
            NONE = new LoadingType("NONE", 0);
            MINIMUM_TIME = new LoadingType("MINIMUM_TIME", 1);
            REAL_DATA = new LoadingType("REAL_DATA", 2);
            LoadingType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private LoadingType(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<LoadingType> getEntries() {
            return $ENTRIES;
        }

        public static LoadingType valueOf(String r2) {
            return (LoadingType) ZeusTransformUtils.preCheckCast(Enum.valueOf(LoadingType.class, r2), LoadingType.class, "com.obric.memorydata.plugin");
        }

        public static LoadingType[] values() {
            return (LoadingType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LoadingType[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemorySearchActivity$ViewState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "EMPTY", "LOADING", "LIST", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum ViewState extends Enum<ViewState> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ViewState[] $VALUES = null;
        public static final ViewState EMPTY = null;
        public static final ViewState IDLE = null;
        public static final ViewState LIST = null;
        public static final ViewState LOADING = null;

        private static final /* synthetic */ ViewState[] $values() {
            return new ViewState[]{IDLE, EMPTY, LOADING, LIST};
        }

        static {
            IDLE = new ViewState("IDLE", 0);
            EMPTY = new ViewState("EMPTY", 1);
            LOADING = new ViewState("LOADING", 2);
            LIST = new ViewState("LIST", 3);
            ViewState[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private ViewState(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<ViewState> getEntries() {
            return $ENTRIES;
        }

        public static ViewState valueOf(String r2) {
            return (ViewState) ZeusTransformUtils.preCheckCast(Enum.valueOf(ViewState.class, r2), ViewState.class, "com.obric.memorydata.plugin");
        }

        public static ViewState[] values() {
            return (ViewState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ViewState[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemorySearchActivity$Companion;", "", "<init>", "()V", "TAG", "", "DIAG_PREFIX", "MAX_SEARCH_LENGTH", "", "MAX_LOADING_TIME", "", "MEMORY_LIST_HEADER_GAP_DP", "MEMORY_LIST_SEARCH_TAB_HEADER_GAP_DP", "MEMORY_SEARCH_VISUAL_SEARCH_AREA_DP", "MEMORY_SEARCH_VISUAL_FILTER_AREA_DP", "MEMORY_LIST_SEARCH_CUT_OFF_OFFSET_DP", "MEMORY_LIST_DEFAULT_BOTTOM_PADDING_DP", "MEMORY_LIST_EDIT_BOTTOM_PADDING_DP", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private static final Unit a(Context r2, boolean r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            if (r3 == false) goto L6;
            MemorySearchActivity.Companion.a(r4);
        L6:
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$rJzwS0bxr5cwkBGCsOR2CN70mHs(Context r0, boolean r1) {
            return a(r0, r1);
        }

        public final void a(Context r3) {
            final Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L6;
            UserStateManager.INSTANCE.requestAgreePrivacyAndLogin(r2, new $$Lambda$MemorySearchActivity$a$rJzwS0bxr5cwkBGCsOR2CN70mHs(r2));
            return;
        L6:
            ZeusTransformUtils.startActivity(r2, new Intent(r2, MemorySearchActivity.class), "com.obric.memorydata.plugin");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11060a = null;

        static {
            int[] r0 = new int[SearchTabVisibility.values().length];
            r0[SearchTabVisibility.GONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SearchTabVisibility.INVISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SearchTabVisibility.VISIBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f11060a = r0;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/memorydata/memory/ui/list/MemorySearchActivity$setupListeners$2", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemorySearchActivity f11061a;

        c(MemorySearchActivity r3) {
            this.f11061a = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySearchActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r2) {
            Editable r1 = (Editable) ZeusTransformUtils.wrapperContextForParams(r2, Editable.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r7, int r8, int r9, int r10) {
            CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
            RunLog.INSTANCE.debug(MemorySearchActivity.TAG, "text: " + r11);
            if (r11 == null) goto L6;
            String r12 = r11.toString();
            if (r12 == null) goto L6;
        L7:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemorySearchActivity.TAG, "onTextChanged: query is " + com.obric.memorydata.utils.q.f13259a.b(r12), false, 4, null);
            ActivityMemorySearchBinding r13 = MemorySearchActivity.access$getBinding$p(this.f11061a);
            if (r13 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r13 = null;
        L10:
            r13.rvMemoryList.setItemAnimator(null);
            MemorySearchActivity.access$setPendingSearchTabScrollCategory$p(this.f11061a, null);
            boolean r0 = false;
            MemorySearchActivity.access$setPendingSearchTabScrollToTop$p(this.f11061a, false);
            long r1 = System.currentTimeMillis();
            MemorySearchActivity.access$getSearchVersion$p(this.f11061a).b(Long.valueOf(r1));
            MemorySearchActivity.access$getRealQuery$p(this.f11061a).b(r12);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L13;
            r0 = true;
        L13:
            if (r0 == false) goto L15;
            MemorySearchActivity.access$getLoadingType$p(this.f11061a).b(LoadingType.NONE);
            MemorySearchActivity.access$setSelectedSearchTab$p(this.f11061a, null);
            MemorySearchActivity.access$setupSearchTabs(this.f11061a, CollectionsKt.emptyList());
            this.f11061a.getViewModel().selectCategory(MemorySearchResultCategory.ALL);
            MemorySearchActivity.access$showViewState(this.f11061a, ViewState.IDLE);
            kotlinx.coroutines.i.a(kotlinx.coroutines.am.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemorySearchActivity$setupListeners$2$onTextChanged$1(this.f11061a, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return;
        L15:
            MemorySearchActivity.access$getLoadingType$p(this.f11061a).b(LoadingType.MINIMUM_TIME);
            MemorySearchActivity.access$showViewState(this.f11061a, ViewState.LOADING);
            this.f11061a.getViewModel().updateQuery(r12, r1);
            return;
        L6:
            r12 = "";
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/MemorySearchActivity$setupListeners$5", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "newState", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemorySearchActivity f11062a;

        d(MemorySearchActivity r3) {
            this.f11062a = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySearchActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            super.a(r2, r3);
            if (r3 != 1) goto L5;
        L7:
            MemorySearchActivity r1 = this.f11062a;
            ActivityMemorySearchBinding r4 = MemorySearchActivity.access$getBinding$p(r1);
            if (r4 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r4 = null;
        L10:
            r1.controlSoftKeyboard((View) ZeusTransformUtils.preCheckCast(r4.memorySearchBar, View.class, "com.obric.memorydata.plugin"), false);
            return;
        L5:
            if (r3 == 2) goto L7;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySearchActivity$deleteItems$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemorySearchActivity$deleteItems$2", f = "MemorySearchActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<cu> $validEntityMetaInfoList;
        int label;
        final /* synthetic */ MemorySearchActivity this$0;

        AnonymousClass2(List<cu> r3, MemorySearchActivity r4, Continuation<? super AnonymousClass2> r5) {
            List<cu> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            MemorySearchActivity r7 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r4, MemorySearchActivity.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$validEntityMetaInfoList = r6;
            this.this$0 = r7;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$validEntityMetaInfoList, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r18) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L20;
            ResultKt.throwOnFailure(r18);
            if ((!((Collection) ZeusTransformUtils.preCheckCast(this.$validEntityMetaInfoList, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L18;
            List<cu> r1 = this.$validEntityMetaInfoList;
            MemorySearchActivity r0 = this.this$0;
            long r4 = System.currentTimeMillis();
            List<String> r2 = com.obric.memorydata.memory.utils.d.f11534a.a((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"), MemoryEventTracker.DeleteMethod.GUI_DELETE.getValue());
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemorySearchActivity.TAG, "delete successful ids size: " + r2.size(), false, 4, null);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemorySearchActivity.TAG, "delete successful ids: " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null), false, 4, null);
            ActivityMemorySearchBinding r3 = MemorySearchActivity.access$getBinding$p(r0);
            ActivityMemorySearchBinding r6 = null;
            if (r3 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r3 = null;
        L10:
            if (r3.rvMemoryList.getItemAnimator() != null) goto L16;
            ActivityMemorySearchBinding r5 = MemorySearchActivity.access$getBinding$p(r0);
            if (r5 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L15:
            r6.rvMemoryList.setItemAnimator((RecyclerView.e) ZeusTransformUtils.preCheckCast(new com.obric.oui.orecyclerview.widget.h(), RecyclerView.e.class, "com.obric.memorydata.plugin"));
            goto L16
        L14:
            r6 = r5;
        L16:
            r0.getViewModel().removeByMetaInfo(r1);
            RunLog.INSTANCE.debug(MemorySearchActivity.TAG, "delete cost time: " + (System.currentTimeMillis() - r4) + " ms");
        L18:
            return Unit.INSTANCE;
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/MemorySearchActivity$setupSearchTabs$2$4", "Lcom/obric/oui/tab/OTabLayoutBase$OnTabSelectedListener;", "onTabSelected", "", "tab", "Lcom/obric/oui/tab/OTabLayoutBase$Tab;", "onTabUnselected", "onTabReselected", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements OTabLayoutBase.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemorySearchActivity f11063a;

        e(MemorySearchActivity r3) {
            this.f11063a = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySearchActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void a(OTabLayoutBase.g r4) {
            if (MemorySearchActivity.access$getSuppressSearchTabCallback$p(this.f11063a) == false) goto L6;
            return;
        L6:
            if (((Boolean) ZeusTransformUtils.preCheckCast(MemorySearchActivity.access$getShareViewModel(this.f11063a).getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L11;
            SearchTab r5 = MemorySearchActivity.access$getSelectedSearchTab$p(this.f11063a);
            if (r5 == null) goto L17;
            MemorySearchActivity r3 = this.f11063a;
            MemorySearchActivity.access$selectSearchTabSilently(r3, MemorySearchActivity.access$getCurrentSearchTabs$p(r3).indexOf(r5));
            return;
        L17:
            return;
        L11:
            if (r4 == null) goto L18;
            int r6 = r4.c();
            SearchTab r7 = (SearchTab) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(MemorySearchActivity.access$getCurrentSearchTabs$p(this.f11063a), r6), SearchTab.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L15;
            return;
        L15:
            MemorySearchActivity.access$requestSearchTabScrollToTop(this.f11063a, r7.getCategory());
            MemorySearchActivity.access$setSelectedSearchTab$p(this.f11063a, r7);
            this.f11063a.getViewModel().selectCategory(r7.getCategory());
            return;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void b(OTabLayoutBase.g r1) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void c(OTabLayoutBase.g r1) {
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$1", f = "MemorySearchActivity.kt", i = {}, l = {725}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySearchActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class C05741<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MemorySearchActivity f11064a;

            C05741(MemorySearchActivity r3) {
                this.f11064a = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySearchActivity.class, "com.obric.memorydata.plugin");
            }

            private static final void a(MemorySearchActivity r4, boolean r5) {
                MemorySearchActivity r6 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r4, MemorySearchActivity.class, "com.obric.memorydata.plugin");
                MemorySearchActivity.access$updateMemoryListPadding(r6);
                MemoryListAdapter r0 = MemorySearchActivity.access$getMemoryListAdapter$p(r6);
                MemoryListAdapter r1 = null;
                if (r0 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r0 = null;
            L5:
                MemoryListAdapter r7 = MemorySearchActivity.access$getMemoryListAdapter$p(r6);
                if (r7 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
            L9:
                r0.a(0, r1.d(), new MemoryListAdapter.Companion.a("edit_mode", Boolean.valueOf(r5)));
                return;
            L8:
                r1 = r7;
                goto L9
            }

            /* JADX INFO: renamed from: lambda$xFYPDgIbzqfn0h-bZfOaK8bWoSg, reason: not valid java name */
            public static /* synthetic */ void m896lambda$xFYPDgIbzqfn0hbZfOaK8bWoSg(MemorySearchActivity r0, boolean r1) {
                a(r0, r1);
            }

            public final Object a(final boolean r7, Continuation<? super Unit> r8) {
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                ActivityMemorySearchBinding r10 = MemorySearchActivity.access$getBinding$p(this.f11064a);
                ActivityMemorySearchBinding r0 = null;
                if (r10 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r10 = null;
            L5:
                LinearLayout r11 = r10.memorySearchBarContainer;
                if (r7 == false) goto L8;
                int r4 = 4;
            L9:
                r11.setVisibility(r4);
                ActivityMemorySearchBinding r12 = MemorySearchActivity.access$getBinding$p(this.f11064a);
                if (r12 != null) goto L12;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r12 = null;
            L12:
                OBottomActionBarFloating r13 = r12.memoryOperationContainer;
                Intrinsics.checkNotNullExpressionValue(r13, "memoryOperationContainer");
                View r14 = (View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin");
                int r5 = 8;
                if (r7 == false) goto L15;
                int r6 = 0;
            L16:
                r14.setVisibility(r6);
                ActivityMemorySearchBinding r15 = MemorySearchActivity.access$getBinding$p(this.f11064a);
                if (r15 != null) goto L19;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r15 = null;
            L19:
                OFloatingTitleBar r16 = r15.viewTitleEdit;
                Intrinsics.checkNotNullExpressionValue(r16, "viewTitleEdit");
                View r17 = (View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin");
                if (r7 == false) goto L22;
                r5 = 0;
            L22:
                r17.setVisibility(r5);
                MemorySearchActivity.access$refreshNavigationBarScheme(this.f11064a);
                MemorySearchActivity.access$refreshSearchHeaderLayout(this.f11064a);
                MemorySearchActivity.access$updateSearchTabsEditState(this.f11064a, r7);
                ActivityMemorySearchBinding r18 = MemorySearchActivity.access$getBinding$p(this.f11064a);
                if (r18 != null) goto L25;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r18 = null;
            L25:
                RecyclerView r19 = r18.rvMemoryList;
                final MemorySearchActivity r20 = this.f11064a;
                r19.post(new $$Lambda$MemorySearchActivity$observeState$1$1$xFYPDgIbzqfn0hbZfOaK8bWoSg(r20, r7));
                if (r7 == false) goto L33;
                MemorySearchActivity r21 = this.f11064a;
                ActivityMemorySearchBinding r22 = MemorySearchActivity.access$getBinding$p(r21);
                if (r22 != null) goto L30;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            L31:
                r21.controlSoftKeyboard((View) ZeusTransformUtils.preCheckCast(r0.memorySearchBar, View.class, "com.obric.memorydata.plugin"), false);
                goto L33
            L30:
                r0 = r22;
            L33:
                return Unit.INSTANCE;
            L15:
                r6 = 8;
                goto L16
            L8:
                r4 = 0;
                goto L9
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), r5);
            }
        }

        AnonymousClass1(MemorySearchActivity r3, Continuation<? super AnonymousClass1> r4) {
            MemorySearchActivity r5 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySearchActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
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
            kotlinx.coroutines.flow.ar<Boolean> r7 = MemorySearchActivity.access$getShareViewModel(this.this$0).getSelectionManager().b();
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05741(this.this$0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$2", f = "MemorySearchActivity.kt", i = {}, l = {747}, m = "invokeSuspend", n = {}, s = {})
    static final class C11662 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySearchActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MemorySearchActivity f11065a;

            AnonymousClass1(MemorySearchActivity r3) {
                this.f11065a = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySearchActivity.class, "com.obric.memorydata.plugin");
            }

            private static final void a(MemorySearchActivity r5) {
                MemorySearchActivity r6 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r5, MemorySearchActivity.class, "com.obric.memorydata.plugin");
                MemoryListAdapter r0 = MemorySearchActivity.access$getMemoryListAdapter$p(r6);
                if (r0 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r0 = null;
            L5:
                MemoryListAdapter r7 = MemorySearchActivity.access$getMemoryListAdapter$p(r6);
                if (r7 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
                r7 = null;
            L8:
                r0.a(0, r7.d(), new MemoryListAdapter.Companion.a("selection", null));
            }

            public static /* synthetic */ void lambda$QJydnwHNK26GZYios83im4VjBXU(MemorySearchActivity r0) {
                a(r0);
            }

            public final Object a(SelectionStateManager.SelectAllState r2, Continuation<? super Unit> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                ActivityMemorySearchBinding r5 = MemorySearchActivity.access$getBinding$p(this.f11065a);
                if (r5 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r5 = null;
            L5:
                RecyclerView r6 = r5.rvMemoryList;
                final MemorySearchActivity r1 = this.f11065a;
                r6.post(new $$Lambda$MemorySearchActivity$observeState$2$1$QJydnwHNK26GZYios83im4VjBXU(r1));
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return a((SelectionStateManager.SelectAllState) ZeusTransformUtils.preCheckCast(r3, SelectionStateManager.SelectAllState.class, "com.obric.memorydata.plugin"), r5);
            }
        }

        C11662(MemorySearchActivity r3, Continuation<? super C11662> r4) {
            MemorySearchActivity r5 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySearchActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11662(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11662) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11662.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.ar<SelectionStateManager.SelectAllState> r7 = MemorySearchActivity.access$getShareViewModel(this.this$0).getSelectionManager().c();
            kotlinx.coroutines.flow.j<? super SelectionStateManager.SelectAllState> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$3", f = "MemorySearchActivity.kt", i = {}, l = {759}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySearchActivity this$0;

        AnonymousClass3(MemorySearchActivity r3, Continuation<? super AnonymousClass3> r4) {
            MemorySearchActivity r5 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySearchActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
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
            kotlinx.coroutines.flow.ar<List<MemorySearchResultCategory>> r7 = this.this$0.getViewModel().getAvailableCategories();
            final MemorySearchActivity r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super List<MemorySearchResultCategory>> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$4", f = "MemorySearchActivity.kt", i = {}, l = {779}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySearchActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$4$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$4$1", f = "MemorySearchActivity.kt", i = {0}, l = {802}, m = "invokeSuspend", n = {"version"}, s = {"J$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Pair<? extends Long, ? extends Long>, Continuation<? super Unit>, Object> {
            long J$0;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MemorySearchActivity this$0;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$4$1$a */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f11067a = null;

                static {
                    int[] r0 = new int[LoadingType.values().length];
                    r0[LoadingType.MINIMUM_TIME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
                L11:
                    r0[LoadingType.REAL_DATA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
                L15:
                    r0[LoadingType.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
                L6:
                    f11067a = r0;
                }
            }

            AnonymousClass1(MemorySearchActivity r3, Continuation<? super AnonymousClass1> r4) {
                MemorySearchActivity r5 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySearchActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(Pair<? extends Long, ? extends Long> r3, Continuation<? super Unit> r4) {
                return invoke2((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Pair<Long, Long> r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r20) {
                Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r2 = this.label;
                if (r2 == 0) goto L8;
                if (r2 != 1) goto L7;
                long r3 = this.J$0;
                ResultKt.throwOnFailure(r20);
            L29:
                long r5 = r3;
            L31:
                if (r5 != ((Number) ZeusTransformUtils.preCheckCast(MemorySearchActivity.access$getSearchVersion$p(this.this$0).c(), Number.class, "com.obric.memorydata.plugin")).longValue()) goto L36;
                if (MemorySearchActivity.access$getLoadingType$p(this.this$0).c() != LoadingType.MINIMUM_TIME) goto L36;
                MemorySearchActivity.access$getLoadingType$p(this.this$0).b(LoadingType.REAL_DATA);
                IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
                boolean r6 = false;
                int r7 = 4;
                Object r8 = null;
                String r9 = MemorySearchActivity.TAG;
                String r10 = "Convert to REAL_DATA, waiting for actual data";
            L22:
                IRunLog.a.a(r4, r9, r10, r6, r7, r8);
            L36:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r20);
                Pair r11 = (Pair) ZeusTransformUtils.preCheckCast(this.L$0, Pair.class, "com.obric.memorydata.plugin");
                r5 = ((Number) ZeusTransformUtils.preCheckCast(r11.component1(), Number.class, "com.obric.memorydata.plugin")).longValue();
                long r12 = ((Number) ZeusTransformUtils.preCheckCast(r11.component2(), Number.class, "com.obric.memorydata.plugin")).longValue();
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemorySearchActivity.TAG, "Received loadingFlow: version=" + r5 + ", current=" + ((Number) ZeusTransformUtils.preCheckCast(MemorySearchActivity.access$getSearchVersion$p(this.this$0).c(), Number.class, "com.obric.memorydata.plugin")).longValue() + ", type=" + MemorySearchActivity.access$getLoadingType$p(this.this$0).c(), false, 4, null);
                if (r5 == ((Number) ZeusTransformUtils.preCheckCast(MemorySearchActivity.access$getSearchVersion$p(this.this$0).c(), Number.class, "com.obric.memorydata.plugin")).longValue()) goto L12;
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemorySearchActivity.TAG, "Ignore outdated loading: version=" + r5, false, 4, null);
                return Unit.INSTANCE;
            L12:
                int r13 = a.f11067a[((LoadingType) ZeusTransformUtils.preCheckCast(MemorySearchActivity.access$getLoadingType$p(this.this$0).c(), LoadingType.class, "com.obric.memorydata.plugin")).ordinal()];
                if (r13 != 1) goto L15;
                long r14 = System.currentTimeMillis() - r12;
                long r15 = RangesKt.coerceAtLeast(MemorySearchActivity.MAX_LOADING_TIME - r14, 0);
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemorySearchActivity.TAG, "MINIMUM_TIME: elapsed " + r14 + "ms, remaining " + r15 + "ms", false, 4, null);
                if (r15 <= 0) goto L31;
                Continuation r16 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.J$0 = r5;
                this.label = 1;
                if (kotlinx.coroutines.au.a(r15, r16) != r1) goto L28;
                return r1;
            L28:
                r3 = r5;
                goto L29
            L15:
                if (r13 != 2) goto L17;
                r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
                r6 = false;
                r7 = 4;
                r8 = null;
                r9 = MemorySearchActivity.TAG;
                r10 = "REAL_DATA: waiting for actual data loading";
                goto L22
            L17:
                if (r13 == 3) goto L36;
                throw new NoWhenBranchMatchedException();
            }
        }

        AnonymousClass4(MemorySearchActivity r3, Continuation<? super AnonymousClass4> r4) {
            MemorySearchActivity r5 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySearchActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.this$0.getViewModel().getLoadingFlow(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$5", f = "MemorySearchActivity.kt", i = {}, l = {822}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySearchActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$5$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "resultWithVersion", "Lcom/obric/memorydata/memory/ui/list/SearchResultWithVersion;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$5$1", f = "MemorySearchActivity.kt", i = {}, l = {829}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<bj, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MemorySearchActivity this$0;

            AnonymousClass1(MemorySearchActivity r3, Continuation<? super AnonymousClass1> r4) {
                MemorySearchActivity r5 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySearchActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(bj r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(bj r3, Continuation<? super Unit> r4) {
                return invoke2((bj) ZeusTransformUtils.preCheckCast(r3, bj.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r11) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r11);
            L22:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r11);
                bj r12 = (bj) ZeusTransformUtils.preCheckCast(this.L$0, bj.class, "com.obric.memorydata.plugin");
                if (r12.a() != ((Number) ZeusTransformUtils.preCheckCast(MemorySearchActivity.access$getSearchVersion$p(this.this$0).c(), Number.class, "com.obric.memorydata.plugin")).longValue()) goto L20;
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemorySearchActivity.TAG, "Submit search results: version=" + r12.a(), false, 4, null);
                MemoryListAdapter r5 = null;
                if (MemorySearchActivity.access$getPendingSearchTabScrollCategory$p(this.this$0) != r12.b()) goto L13;
                MemorySearchActivity.access$setPendingSearchTabScrollCategory$p(this.this$0, null);
                MemorySearchActivity.access$setPendingSearchTabScrollToTop$p(this.this$0, true);
            L13:
                MemoryListAdapter r2 = MemorySearchActivity.access$getMemoryListAdapter$p(this.this$0);
                if (r2 != null) goto L16;
                Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
            L17:
                PagingData<com.obric.memorydata.memory.ui.data.a> r13 = r12.c();
                Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                if (r5.a(r13, r3) != r0) goto L22;
                return r0;
            L16:
                r5 = r2;
                goto L17
            L20:
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemorySearchActivity.TAG, "Ignore outdated results: version=" + r12.a(), false, 4, null);
                goto L22
            }
        }

        AnonymousClass5(MemorySearchActivity r3, Continuation<? super AnonymousClass5> r4) {
            MemorySearchActivity r5 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySearchActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i<bj> r7 = this.this$0.getViewModel().getSearchResults();
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r7, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$6", f = "MemorySearchActivity.kt", i = {}, l = {846}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySearchActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$6$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "Landroidx/paging/CombinedLoadStates;", "Lcom/obric/memorydata/memory/ui/list/MemorySearchActivity$LoadingType;", "", "loadStates", "currentLoadingType", "currentVersion"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$6$1", f = "MemorySearchActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function4<CombinedLoadStates, LoadingType, Long, Continuation<? super Triple<? extends CombinedLoadStates, ? extends LoadingType, ? extends Long>>, Object> {
            /* synthetic */ long J$0;
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
                super(4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
            }

            public final Object invoke(CombinedLoadStates r2, LoadingType r3, long r4, Continuation<? super Triple<CombinedLoadStates, ? extends LoadingType, Long>> r6) {
                AnonymousClass1 r7 = new AnonymousClass1((Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
                r7.L$0 = r2;
                r7.L$1 = r3;
                r7.J$0 = r4;
                return r7.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* synthetic */ Object invoke(CombinedLoadStates r9, LoadingType r10, Long r11, Continuation<? super Triple<? extends CombinedLoadStates, ? extends LoadingType, ? extends Long>> r12) {
                return invoke((CombinedLoadStates) ZeusTransformUtils.preCheckCast(r9, CombinedLoadStates.class, "com.obric.memorydata.plugin"), (LoadingType) ZeusTransformUtils.preCheckCast(r10, LoadingType.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).longValue(), (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r4);
                return new Triple((CombinedLoadStates) ZeusTransformUtils.preCheckCast(this.L$0, CombinedLoadStates.class, "com.obric.memorydata.plugin"), (LoadingType) ZeusTransformUtils.preCheckCast(this.L$1, LoadingType.class, "com.obric.memorydata.plugin"), Boxing.boxLong(this.J$0));
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass6(MemorySearchActivity r3, Continuation<? super AnonymousClass6> r4) {
            MemorySearchActivity r5 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySearchActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
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
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            MemoryListAdapter r9 = MemorySearchActivity.access$getMemoryListAdapter$p(this.this$0);
            if (r9 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
            r9 = null;
        L11:
            kotlinx.coroutines.flow.i r10 = kotlinx.coroutines.flow.k.a(r9.e(), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(MemorySearchActivity.access$getLoadingType$p(this.this$0), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(MemorySearchActivity.access$getSearchVersion$p(this.this$0), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function4) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), Function4.class, "com.obric.memorydata.plugin"));
            final MemorySearchActivity r3 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r10.collect(r2, r4) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemorySearchActivity$observeState$7", f = "MemorySearchActivity.kt", i = {}, l = {895}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass7 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySearchActivity this$0;

        AnonymousClass7(MemorySearchActivity r3, Continuation<? super AnonymousClass7> r4) {
            MemorySearchActivity r5 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySearchActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
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
            kotlinx.coroutines.flow.ar<Integer> r7 = MemorySearchActivity.access$getShareViewModel(this.this$0).getSelectionManager().f();
            final MemorySearchActivity r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Integer> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemorySearchActivity$onResumeChecked$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemorySearchActivity$onResumeChecked$1", f = "MemorySearchActivity.kt", i = {}, l = {Constants.UPLOAD_DISASTER_DROP}, m = "invokeSuspend", n = {}, s = {})
    static final class C11671 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySearchActivity this$0;

        C11671(MemorySearchActivity r3, Continuation<? super C11671> r4) {
            MemorySearchActivity r5 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemorySearchActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11671(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11671) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11671.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L26:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            kotlinx.coroutines.flow.ae<cu> r15 = MemorySearchActivity.access$getShareViewModel(this.this$0).getSelectionManager().a();
            MemorySearchActivity r2 = this.this$0;
            IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r3 = new StringBuilder().append("refresh type: ");
            cu r4 = (cu) ZeusTransformUtils.preCheckCast(r15.c(), cu.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L11;
            Integer r5 = Boxing.boxInt(r4.getType());
        L12:
            StringBuilder r7 = r3.append(r5).append(", packageName: ");
            cu r8 = (cu) ZeusTransformUtils.preCheckCast(r15.c(), cu.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L15;
            String r9 = r8.b();
        L16:
            IRunLog.a.a(r6, MemorySearchActivity.TAG, r7.append(r9).toString(), false, 4, null);
            RunLog.INSTANCE.debug(MemorySearchActivity.TAG, "detailMetaInfo: " + r15.c());
            if (r15.c() == null) goto L22;
            ActivityMemorySearchBinding r10 = MemorySearchActivity.access$getBinding$p(r2);
            if (r10 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r10 = null;
        L21:
            r2.controlSoftKeyboard((View) ZeusTransformUtils.preCheckCast(r10.memorySearchBar, View.class, "com.obric.memorydata.plugin"), false);
        L22:
            CoroutineContext r11 = (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r16 = (Function2) ZeusTransformUtils.preCheckCast(new MemorySearchActivity$onResumeChecked$1$1$1(r15, r2, null), Function2.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.i.a(r11, r16, this) != r0) goto L26;
            return r0;
        L15:
            r9 = null;
            goto L16
        L11:
            r5 = null;
            goto L12
        }
    }

    static {
        Companion = new a(null);
    }

    public MemorySearchActivity() {
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(new MemorySearchActivity$special$$inlined$viewModels$default$1(r0), Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = null;
        this.shareViewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(MemoryListShareViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new MemorySearchActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new MemorySearchActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
        final ComponentActivity r1 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r3 = (Function0) ZeusTransformUtils.preCheckCast(new MemorySearchActivity$special$$inlined$viewModels$default$4(r1), Function0.class, "com.obric.memorydata.plugin");
        this.viewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(SearchViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new MemorySearchActivity$special$$inlined$viewModels$default$5(r1), Function0.class, "com.obric.memorydata.plugin"), r3, (Function0) ZeusTransformUtils.preCheckCast(new MemorySearchActivity$special$$inlined$viewModels$default$6(r7, r1), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
        this.realQuery = kotlinx.coroutines.flow.at.a("");
        this.currentSearchTabs = CollectionsKt.emptyList();
        this.currentViewState = ViewState.IDLE;
        this.searchVersion = kotlinx.coroutines.flow.at.a(0L);
        this.loadingType = kotlinx.coroutines.flow.at.a(LoadingType.NONE);
    }

    public static final /* synthetic */ Object access$deleteItems(MemorySearchActivity r2, Collection r3, Continuation r4) {
        return ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).deleteItems((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ ActivityMemorySearchBinding access$getBinding$p(MemorySearchActivity r2) {
        return ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).binding;
    }

    public static final /* synthetic */ List access$getCurrentSearchTabs$p(MemorySearchActivity r2) {
        return ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).currentSearchTabs;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae access$getLoadingType$p(MemorySearchActivity r2) {
        return ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).loadingType;
    }

    public static final /* synthetic */ MemoryListAdapter access$getMemoryListAdapter$p(MemorySearchActivity r2) {
        return ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).memoryListAdapter;
    }

    public static final /* synthetic */ MemorySearchResultCategory access$getPendingSearchTabScrollCategory$p(MemorySearchActivity r2) {
        return ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).pendingSearchTabScrollCategory;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae access$getRealQuery$p(MemorySearchActivity r2) {
        return ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).realQuery;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae access$getSearchVersion$p(MemorySearchActivity r2) {
        return ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).searchVersion;
    }

    public static final /* synthetic */ SearchTab access$getSelectedSearchTab$p(MemorySearchActivity r2) {
        return ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).selectedSearchTab;
    }

    public static final /* synthetic */ MemoryListShareViewModel access$getShareViewModel(MemorySearchActivity r2) {
        return ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).getShareViewModel();
    }

    public static final /* synthetic */ boolean access$getSuppressSearchTabCallback$p(MemorySearchActivity r2) {
        return ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).suppressSearchTabCallback;
    }

    public static final /* synthetic */ void access$refreshNavigationBarScheme(MemorySearchActivity r2) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).refreshNavigationBarScheme();
    }

    public static final /* synthetic */ void access$refreshSearchHeaderLayout(MemorySearchActivity r2) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).refreshSearchHeaderLayout();
    }

    public static final /* synthetic */ void access$requestSearchTabScrollToTop(MemorySearchActivity r2, MemorySearchResultCategory r3) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).requestSearchTabScrollToTop(r3);
    }

    public static final /* synthetic */ void access$selectSearchTabSilently(MemorySearchActivity r2, int r3) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).selectSearchTabSilently(r3);
    }

    public static final /* synthetic */ void access$setPendingSearchTabScrollCategory$p(MemorySearchActivity r2, MemorySearchResultCategory r3) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).pendingSearchTabScrollCategory = r3;
    }

    public static final /* synthetic */ void access$setPendingSearchTabScrollToTop$p(MemorySearchActivity r2, boolean r3) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).pendingSearchTabScrollToTop = r3;
    }

    public static final /* synthetic */ void access$setSelectedSearchTab$p(MemorySearchActivity r2, SearchTab r3) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).selectedSearchTab = r3;
    }

    public static final /* synthetic */ void access$setupSearchTabs(MemorySearchActivity r2, List r3) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).setupSearchTabs((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$showViewState(MemorySearchActivity r2, ViewState r3) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).showViewState(r3);
    }

    public static final /* synthetic */ void access$updateMemoryListPadding(MemorySearchActivity r2) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).updateMemoryListPadding();
    }

    public static final /* synthetic */ void access$updateSearchTabsEditState(MemorySearchActivity r2, boolean r3) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).updateSearchTabsEditState(r3);
    }

    private final int bottomInRoot(View r3) {
        if (r3.getHeight() > 0) goto L5;
        return 0;
    L5:
        if (r3.isShown() == false) goto L14;
        int[] r1 = new int[2];
        int[] r0 = new int[2];
        ActivityMemorySearchBinding r2 = this.binding;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L10:
        r2.getRoot().getLocationInWindow(r1);
        r3.getLocationInWindow(r0);
        return (r0[1] - r1[1]) + r3.getHeight();
    L14:
        return 0;
    }

    private final String childDiag(ViewGroup r6) {
        if (r6.getChildCount() != 0) goto L6;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L6:
        StringBuilder r5 = new StringBuilder();
        r5.append("[");
        int r0 = Math.min(r6.getChildCount(), 6);
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L12;
        if (r1 <= 0) goto L10;
        r5.append(";");
    L10:
        View r2 = r6.getChildAt(r1);
        r5.append(r1).append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append(r2.getClass().getSimpleName()).append(" l=").append(r2.getLeft()).append(" t=").append(r2.getTop()).append(" r=").append(r2.getRight()).append(" b=").append(r2.getBottom()).append(" size=").append(r2.getWidth()).append("x").append(r2.getHeight());
        r1 = r1 + 1;
        goto L7
    L12:
        if (r6.getChildCount() <= r0) goto L14;
        r5.append(";...").append(r6.getChildCount());
    L14:
        r5.append("]");
        String r7 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        return r7;
    }

    private final String clipChain(View r5) {
        StringBuilder r4 = new StringBuilder();
        int r0 = 0;
    L3:
        if (r5 == null) goto L16;
        if (r0 >= 8) goto L16;
        if (r0 <= 0) goto L8;
        r4.append(" <- ");
    L8:
        r4.append(r5.getClass().getSimpleName());
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L11;
        r4.append("(clipChildren=").append(((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin")).getClipChildren()).append(",clipToPadding=").append(((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin")).getClipToPadding()).append(")");
    L11:
        ViewParent r6 = r5.getParent();
        if (ZeusTransformUtils.instanceOf(r6, View.class) == false) goto L14;
        r5 = (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin");
    L15:
        r0 = r0 + 1;
        goto L3
    L14:
        r5 = null;
    L16:
        String r7 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        return r7;
    }

    private final void consumePendingSearchTabScrollToTop() {
        if (this.pendingSearchTabScrollToTop == true) goto L5;
        return;
    L5:
        this.pendingSearchTabScrollToTop = false;
        ActivityMemorySearchBinding r0 = this.binding;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L8:
        r0.rvMemoryList.post(new $$Lambda$MemorySearchActivity$vrrQdsbsfrNkL2O6DhGsVzFKuwk(this));
    }

    private static final void consumePendingSearchTabScrollToTop$lambda$14(MemorySearchActivity r2) {
        MemorySearchActivity r3 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin");
        r3.updateMemoryListPadding();
        ActivityMemorySearchBinding r4 = r3.binding;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L5:
        r4.rvMemoryList.scrollToPosition(0);
    }

    private static final void controlSoftKeyboard$lambda$19(View r4, InputMethodManager r5) {
        RunLog.INSTANCE.debug(TAG, "onWindowFocusChanged postDelayed: focusResult=" + r4.requestFocus() + ", showResult=" + r5.showSoftInput(r4, 1) + ", hasFocus=" + r4.hasFocus() + ", windowHasFocus=" + r4.hasWindowFocus() + ", isAttached=" + r4.isAttachedToWindow());
    }

    private final PersonalTag createSearchTabView(SearchTab r9) {
        PersonalTag r6 = new PersonalTag((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), null, 0, 6, null);
        String r8 = getString(r9.getTitleRes());
        Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");
        r6.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"));
        r6.setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 300, Resources.getSystem().getDisplayMetrics())));
        return r6;
    }

    private final Object deleteItems(Collection<cu> r14, Continuation<? super Unit> r15) {
        Collection r16 = (Collection) ZeusTransformUtils.wrapperContextForParams(r14, Collection.class, "com.obric.memorydata.plugin");
        Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r18.iterator();
    L4:
        if (r19.hasNext() == false) goto L8;
        Object r2 = r19.next();
        if (com.obric.memorydata.utils.at.a(((cu) ZeusTransformUtils.preCheckCast(r2, cu.class, "com.obric.memorydata.plugin")).b()) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        List r110 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "delete validEntityMetaInfoList: " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null), false, 4, null);
        Object r13 = kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r110, this, null), Function2.class, "com.obric.memorydata.plugin"), r17);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r13;
    L12:
        return Unit.INSTANCE;
    }

    private final void dumpSearchHeaderDiag(String r9) {
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == true) goto L5;
        return;
    L5:
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder();
        ActivityMemorySearchBinding r3 = null;
        StringBuilder r10 = r1.append("[OTabDiag][Search] dump[").append(r9).append("] visual=").append(visualBlockDiag$default(this, null, 1, null)).append(" root=");
        ActivityMemorySearchBinding r2 = this.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        StringBuilder r11 = r10.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r2.getRoot(), View.class, "com.obric.memorydata.plugin"))).append(" header=");
        ActivityMemorySearchBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        StringBuilder r12 = r11.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r4.searchHeaderContainer, View.class, "com.obric.memorydata.plugin"))).append(" searchBarContainer=");
        ActivityMemorySearchBinding r5 = this.binding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L14:
        StringBuilder r13 = r12.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r5.memorySearchBarContainer, View.class, "com.obric.memorydata.plugin"))).append(" searchBar=");
        ActivityMemorySearchBinding r6 = this.binding;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L17:
        StringBuilder r14 = r13.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r6.memorySearchBar, View.class, "com.obric.memorydata.plugin"))).append(" cancel=");
        ActivityMemorySearchBinding r7 = this.binding;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L20:
        StringBuilder r15 = r14.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r7.memorySearchCancel, View.class, "com.obric.memorydata.plugin"))).append(" group=");
        ActivityMemorySearchBinding r8 = this.binding;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L23:
        StringBuilder r16 = r15.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r8.searchTabGroup, View.class, "com.obric.memorydata.plugin"))).append(" tabs=");
        ActivityMemorySearchBinding r17 = this.binding;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L26:
        StringBuilder r18 = r16.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r17.searchTabContainer, View.class, "com.obric.memorydata.plugin"))).append(" cutOff=");
        ActivityMemorySearchBinding r19 = this.binding;
        if (r19 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L29:
        StringBuilder r20 = r18.append(viewDiag(r19.cutOff)).append(" rv=");
        ActivityMemorySearchBinding r21 = this.binding;
        if (r21 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L32:
        r20.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r21.rvMemoryList, View.class, "com.obric.memorydata.plugin"))).append(" contentBottom=");
        StringBuilder r22 = r1.append(getSearchHeaderContentBottom()).append(" tabChildren=");
        ActivityMemorySearchBinding r23 = this.binding;
        if (r23 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L35:
        OTabLayout r24 = r23.searchTabContainer;
        Intrinsics.checkNotNullExpressionValue(r24, "searchTabContainer");
        StringBuilder r25 = r22.append(childDiag((ViewGroup) ZeusTransformUtils.preCheckCast(r24, ViewGroup.class, "com.obric.memorydata.plugin"))).append(" clipChain=");
        ActivityMemorySearchBinding r26 = this.binding;
        if (r26 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L39:
        OTabLayout r27 = r3.searchTabContainer;
        Intrinsics.checkNotNullExpressionValue(r27, "searchTabContainer");
        r25.append(clipChain((View) ZeusTransformUtils.preCheckCast(r27, View.class, "com.obric.memorydata.plugin")));
        r0.debug(TAG, r1.toString());
        return;
    L38:
        r3 = r26;
        goto L39
    }

    private final int getMemoryListBottomPadding() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L5;
        int r0 = 80;
    L7:
        return (MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())) + this.navigationBarBottom) + MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
    L5:
        r0 = 40;
        goto L7
    }

    private final int getMemoryListTopPadding() {
        int r0 = getSearchHeaderContentBottom();
        ActivityMemorySearchBinding r1 = this.binding;
        ActivityMemorySearchBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        OUILinearLayout r3 = r1.searchTabGroup;
        Intrinsics.checkNotNullExpressionValue(r3, "searchTabGroup");
        boolean r5 = false;
        if (((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        float r6 = 0;
    L12:
        int r7 = MathKt.roundToInt(TypedValue.applyDimension(1, r6, Resources.getSystem().getDisplayMetrics()));
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L24;
        RunLog r8 = RunLog.INSTANCE;
        StringBuilder r9 = new StringBuilder().append("[OTabDiag][Search] getMemoryListTopPadding headerBottom=").append(r0).append(" headerGap=").append(r7).append(" fallbackTitleBarHeight=");
        ActivityMemorySearchBinding r10 = this.binding;
        if (r10 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L17:
        StringBuilder r11 = r9.append(getTitleBarTotalHeight((View) ZeusTransformUtils.preCheckCast(r10.searchHeaderContainer, View.class, "com.obric.memorydata.plugin"))).append(" groupVisible=");
        ActivityMemorySearchBinding r12 = this.binding;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L20:
        OUILinearLayout r13 = r12.searchTabGroup;
        Intrinsics.checkNotNullExpressionValue(r13, "searchTabGroup");
        if (((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L23;
        r5 = true;
    L23:
        r8.debug(TAG, r11.append(r5).toString());
    L24:
        dumpSearchHeaderDiag("getMemoryListTopPadding");
        if (r0 > 0) goto L33;
        ActivityMemorySearchBinding r14 = this.binding;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L31:
        return getTitleBarTotalHeight((View) ZeusTransformUtils.preCheckCast(r2.searchHeaderContainer, View.class, "com.obric.memorydata.plugin")) + r7;
    L29:
        r2 = r14;
        goto L31
    L33:
        return r0 + r7;
    L11:
        r6 = 8;
        goto L12
    L8:
        r4 = false;
        goto L9
    }

    private final int getSearchHeaderContentBottom() {
        Integer[] r0 = new Integer[3];
        ActivityMemorySearchBinding r1 = this.binding;
        ActivityMemorySearchBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        LinearLayout r3 = r1.searchHeaderContainer;
        Intrinsics.checkNotNullExpressionValue(r3, "searchHeaderContainer");
        r0[0] = Integer.valueOf(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")));
        ActivityMemorySearchBinding r4 = this.binding;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L8:
        OUILinearLayout r5 = r4.searchTabGroup;
        Intrinsics.checkNotNullExpressionValue(r5, "searchTabGroup");
        r0[1] = Integer.valueOf(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin")));
        ActivityMemorySearchBinding r7 = this.binding;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        OTabLayout r6 = r2.searchTabContainer;
        Intrinsics.checkNotNullExpressionValue(r6, "searchTabContainer");
        r0[2] = Integer.valueOf(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin")));
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r0), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L14:
        if (r10.hasNext() == false) goto L21;
        Object r11 = r10.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L18;
        boolean r12 = true;
    L19:
        if (r12 == false) goto L14;
        r9.add(r11);
        goto L14
    L18:
        r12 = false;
        goto L19
    L21:
        Integer r13 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.maxOrNull((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L24;
        return 0;
    L24:
        return r13.intValue();
    L11:
        r2 = r7;
        goto L12
    }

    private final MemoryListShareViewModel getShareViewModel() {
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(this.shareViewModel$delegate.getValue(), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void initViews() {
        ActivityMemorySearchBinding r0 = this.binding;
        ActivityMemorySearchBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        RecyclerView r1 = r0.rvMemoryList;
        r1.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        MemoryListAdapter r3 = new MemoryListAdapter(getShareViewModel().getSelectionManager(), MemoryListItemViewHolder.Companion.ItemRelatedPage.SEARCH_PAGE, false, 4, null);
        this.memoryListAdapter = r3;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
        r3 = null;
    L8:
        r1.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r3.a((com.obric.memorydata.ui.recyclerview.a) ZeusTransformUtils.preCheckCast(new i(), com.obric.memorydata.ui.recyclerview.a.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.ui.recyclerview.a) ZeusTransformUtils.preCheckCast(new i(), com.obric.memorydata.ui.recyclerview.a.class, "com.obric.memorydata.plugin")), RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        MemoryListAdapter r4 = this.memoryListAdapter;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("memoryListAdapter");
        r4 = null;
    L11:
        r4.a(new $$Lambda$MemorySearchActivity$PyWQUCUadmSBVikWHgVUHXE0C_g(this));
        showViewState(ViewState.IDLE);
        ActivityMemorySearchBinding r5 = this.binding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L14:
        r5.memorySearchBar.getInputView().setFilters((InputFilter[]) ZeusTransformUtils.preCheckCast(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(200)}, InputFilter[].class, "com.obric.memorydata.plugin"));
        ActivityMemorySearchBinding r6 = this.binding;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L17:
        r6.memorySearchBar.getInputView().setHint((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.memory_search_bar_hint, TypedValues.Custom.S_STRING, "memory_search_bar_hint")), CharSequence.class, "com.obric.memorydata.plugin"));
        setupCutOffColor();
        setupSearchHeaderLayoutRefresh();
        ActivityMemorySearchBinding r7 = this.binding;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L20:
        controlSoftKeyboard((View) ZeusTransformUtils.preCheckCast(r7.memorySearchBar.getInputView(), View.class, "com.obric.memorydata.plugin"), true);
        ActivityMemorySearchBinding r8 = this.binding;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L23:
        r8.searchTabGroup.setChangeAlphaWhenDisable(false);
        setupSearchTabs(this.currentSearchTabs);
        ActivityMemorySearchBinding r9 = this.binding;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L26:
        r9.rvMemoryList.post(new $$Lambda$MemorySearchActivity$cDRvlCgItA_TuP6wahZgb62AI(this));
        ActivityMemorySearchBinding r10 = this.binding;
        if (r10 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L30:
        OFloatingTitleBar r11 = r2.viewTitleEdit;
        OFloatingTitleBar.b(r11, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_close, "drawable", "o_floating_title_bar_icon_close"), 0, new $$Lambda$MemorySearchActivity$oVk7pDaZfn7K4mt9dNUcJ1Wbd4(this), 2, null);
        Intrinsics.checkNotNull(r11);
        ((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin")).setVisibility(8);
        r11.setCenterTitle(getString(ZeusTransformUtils.mapRes(R.string.memory_multi_select_selected_count, TypedValues.Custom.S_STRING, "memory_multi_select_selected_count"), new Object[]{1}));
        setupNavigationBar();
        setupListeners();
        return;
    L29:
        r2 = r10;
        goto L30
    }

    private static final Unit initViews$lambda$1(MemorySearchActivity r2) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).consumePendingSearchTabScrollToTop();
        return Unit.INSTANCE;
    }

    private static final void initViews$lambda$2(MemorySearchActivity r2) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).updateMemoryListPadding();
    }

    private static final void initViews$lambda$4$lambda$3(MemorySearchActivity r1, View r2) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemorySearchActivity.class, "com.obric.memorydata.plugin")).getShareViewModel().getSelectionManager().j();
    }

    public static /* synthetic */ void lambda$I4xu0Ymwbc8TFPrJriV25MVQGfA(MemorySearchActivity r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        setupSearchHeaderLayoutRefresh$lambda$23(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void lambda$JBIxfVNUqNuyetMsIRZEp3h8D4o(View r0, InputMethodManager r1) {
        controlSoftKeyboard$lambda$19(r0, r1);
    }

    public static /* synthetic */ void lambda$JBkYqIQ_RbBFFHMyGfX_WfPF37Q(MemorySearchActivity r0) {
        setupSearchHeaderLayoutRefresh$lambda$24(r0);
    }

    public static /* synthetic */ void lambda$KfRjvPI2ICEfjgVwe_UK3neZQS8(MemorySearchActivity r0) {
        setupSearchTabs$lambda$13$lambda$12(r0);
    }

    /* JADX INFO: renamed from: lambda$PJxMK2qx_7w9daXxcSfJgEK-BLY, reason: not valid java name */
    public static /* synthetic */ WindowInsetsCompat m891lambda$PJxMK2qx_7w9daXxcSfJgEKBLY(MemorySearchActivity r0, View r1, WindowInsetsCompat r2) {
        return setupListeners$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$PyWQUCUadmSBVikWHgVUHXE0C_g(MemorySearchActivity r0) {
        return initViews$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$QiSxJ1-yyCMItclPIxuMVAcVgHg, reason: not valid java name */
    public static /* synthetic */ Unit m892lambda$QiSxJ1yyCMItclPIxuMVAcVgHg(MemorySearchActivity r0, DialogInterface r1, int r2) {
        return showDeleteDialog$lambda$36(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$ZNJF6XQ9wxfWTFsrzcs4BsACFIs(MemorySearchActivity r0, View r1) {
        setupNavigationBar$lambda$17$lambda$16(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$cDRvl-Cg-ItA_TuP6wahZgb62AI, reason: not valid java name */
    public static /* synthetic */ void m893lambda$cDRvlCgItA_TuP6wahZgb62AI(MemorySearchActivity r0) {
        initViews$lambda$2(r0);
    }

    public static /* synthetic */ void lambda$cLBw9qa_CdI3SJPTimwGMECy4dY(MemorySearchActivity r0, View r1) {
        setupListeners$lambda$7(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$eT3jNf9df_GcLx-ivnlT1qCt1os, reason: not valid java name */
    public static /* synthetic */ void m894lambda$eT3jNf9df_GcLxivnlT1qCt1os(MemorySearchActivity r0, View r1, boolean r2) {
        setupListeners$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$jvkryh28S8bPcfNC7z7sLlqnqUE(MemorySearchActivity r0) {
        refreshSearchHeaderLayout$lambda$28(r0);
    }

    public static /* synthetic */ Unit lambda$m02QhINTpYQ06weuzCyNIll16xA(DialogInterface r0, int r1) {
        return showDeleteDialog$lambda$35(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$oVk7pDaZf-n7K4mt9dNUcJ1Wbd4, reason: not valid java name */
    public static /* synthetic */ void m895lambda$oVk7pDaZfn7K4mt9dNUcJ1Wbd4(MemorySearchActivity r0, View r1) {
        initViews$lambda$4$lambda$3(r0, r1);
    }

    public static /* synthetic */ void lambda$vrrQdsbsfrNkL2O6DhGsVzFKuwk(MemorySearchActivity r0) {
        consumePendingSearchTabScrollToTop$lambda$14(r0);
    }

    private final void manualRefresh() {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.realQuery.c(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onResume: trigger refresh for query: " + com.obric.memorydata.utils.q.f13259a.b((String) ZeusTransformUtils.preCheckCast(this.realQuery.c(), String.class, "com.obric.memorydata.plugin")), false, 4, null);
        long r1 = System.currentTimeMillis();
        this.searchVersion.b(Long.valueOf(r1));
        this.loadingType.b(LoadingType.REAL_DATA);
        showViewState(ViewState.LOADING);
        getViewModel().updateQuery((String) ZeusTransformUtils.preCheckCast(this.realQuery.c(), String.class, "com.obric.memorydata.plugin"), r1);
        getViewModel().triggerRefreshStart();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void observeState() {
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11662(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass7(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final String pxToDp(int r3) {
        return (r3 / ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density) + "dp";
    }

    private final String rectDp(View r3) {
        if (r3.getHeight() > 0) goto L5;
        return "empty";
    L5:
        if (r3.isShown() == true) goto L8;
        return "empty";
    L8:
        return pxToDp(topInRoot(r3)) + ".." + pxToDp(bottomInRoot(r3)) + " h=" + pxToDp(r3.getHeight());
    }

    private final void refreshSearchHeaderLayout() {
        ActivityMemorySearchBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.getRoot().post(new $$Lambda$MemorySearchActivity$jvkryh28S8bPcfNC7z7sLlqnqUE(this));
    }

    private static final void refreshSearchHeaderLayout$lambda$28(MemorySearchActivity r8) {
        MemorySearchActivity r9 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r8, MemorySearchActivity.class, "com.obric.memorydata.plugin");
        int r0 = r9.getSearchHeaderContentBottom();
        ActivityMemorySearchBinding r4 = null;
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L17;
        RunLog r2 = RunLog.INSTANCE;
        StringBuilder r6 = new StringBuilder().append("[OTabDiag][Search] refreshSearchHeaderLayout headerBottom=").append(r0).append(" headerH=");
        ActivityMemorySearchBinding r7 = r9.binding;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L7:
        StringBuilder r10 = r6.append(r7.searchHeaderContainer.getHeight()).append(" groupH=");
        ActivityMemorySearchBinding r11 = r9.binding;
        if (r11 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L10:
        StringBuilder r12 = r10.append(r11.searchTabGroup.getHeight()).append(" tabH=");
        ActivityMemorySearchBinding r13 = r9.binding;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L13:
        StringBuilder r14 = r12.append(r13.searchTabContainer.getHeight()).append(" cutOffH=");
        ActivityMemorySearchBinding r15 = r9.binding;
        if (r15 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L16:
        r2.debug(TAG, r14.append(r15.cutOff.getHeight()).toString());
    L17:
        r9.dumpSearchHeaderDiag("refreshSearchHeaderLayout");
        if (r0 <= 0) goto L35;
        int r1 = r0 + MathKt.roundToInt(TypedValue.applyDimension(1, -8, Resources.getSystem().getDisplayMetrics()));
        ActivityMemorySearchBinding r3 = r9.binding;
        if (r3 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L22:
        ViewGroup.LayoutParams r5 = r3.cutOff.getLayoutParams();
        if (r5 == null) goto L43;
        if (r1 <= 0) goto L43;
        if (r5.height == r1) goto L43;
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L30;
        RunLog.INSTANCE.debug(TAG, "[OTabDiag][Search] refreshSearchHeaderLayout.setCutOff old=" + r5.height + " new=" + r1);
    L30:
        r5.height = r1;
        ActivityMemorySearchBinding r16 = r9.binding;
        if (r16 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L34:
        r4.cutOff.setLayoutParams(r5);
        goto L43
    L33:
        r4 = r16;
    L43:
        r9.updateMemoryListPadding();
        return;
    L35:
        ActivityMemorySearchBinding r17 = r9.binding;
        if (r17 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L38:
        View r18 = (View) ZeusTransformUtils.preCheckCast(r17.searchHeaderContainer, View.class, "com.obric.memorydata.plugin");
        ActivityMemorySearchBinding r19 = r9.binding;
        if (r19 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L42:
        r9.setupCutOffArea(r18, r4.cutOff);
        goto L43
    L41:
        r4 = r19;
        goto L42
    }

    private final void requestSearchTabScrollToTop(MemorySearchResultCategory r3) {
        this.pendingSearchTabScrollCategory = r3;
        ActivityMemorySearchBinding r4 = this.binding;
        ActivityMemorySearchBinding r1 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L5:
        r4.rvMemoryList.stopScroll();
        ActivityMemorySearchBinding r5 = this.binding;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L8:
        r5.rvMemoryList.setItemAnimator(null);
        ActivityMemorySearchBinding r2 = this.binding;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        r1.rvMemoryList.scrollToPosition(0);
        return;
    L11:
        r1 = r2;
        goto L12
    }

    private final void selectSearchTabSilently(int r6) {
        if (r6 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return;
    L10:
        this.suppressSearchTabCallback = true;
        ActivityMemorySearchBinding r0 = this.binding;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L13:
        r0.searchTabContainer.e(r6);
        this.suppressSearchTabCallback = false;
        return;
    L5:
        if (r6 >= ((Collection) ZeusTransformUtils.preCheckCast(this.currentSearchTabs, Collection.class, "com.obric.memorydata.plugin")).size()) goto L7;
        r2 = true;
        goto L8
    }

    private final void setupCutOffColor() {
        Integer r0 = com.obric.memorydata.ui.custom.a.c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.OFloatingTitleBarCutoffAreaColor, "attr", "OFloatingTitleBarCutoffAreaColor"));
        ActivityMemorySearchBinding r4 = null;
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L12;
        RunLog r2 = RunLog.INSTANCE;
        StringBuilder r5 = new StringBuilder().append("[CutOffDiag][Search] setupCutOffColor color=").append(r0).append(" alpha=");
        if (r0 == null) goto L7;
        Integer r1 = Integer.valueOf(Color.alpha(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue()));
    L8:
        StringBuilder r3 = r5.append(r1).append(" cutOff=");
        ActivityMemorySearchBinding r6 = this.binding;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L11:
        r2.debug(TAG, r3.append(viewDiag(r6.cutOff)).toString());
        goto L12
    L7:
        r1 = null;
    L12:
        if (r0 == null) goto L19;
        ActivityMemorySearchBinding r7 = this.binding;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L17:
        r4.cutOff.setBackgroundColor(r0.intValue());
        return;
    L16:
        r4 = r7;
        goto L17
    }

    private final void setupListeners() {
        ActivityMemorySearchBinding r0 = this.binding;
        ActivityMemorySearchBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(r0.getRoot(), View.class, "com.obric.memorydata.plugin"), new $$Lambda$MemorySearchActivity$PJxMK2qx_7w9daXxcSfJgEKBLY(this));
        ActivityMemorySearchBinding r2 = this.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        r2.memorySearchBar.getInputView().addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new c(this), TextWatcher.class, "com.obric.memorydata.plugin"));
        ActivityMemorySearchBinding r3 = this.binding;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L11:
        r3.memorySearchBar.getInputView().setOnFocusChangeListener(new $$Lambda$MemorySearchActivity$eT3jNf9df_GcLxivnlT1qCt1os(this));
        ActivityMemorySearchBinding r4 = this.binding;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L14:
        r4.memorySearchCancel.setOnClickListener(new $$Lambda$MemorySearchActivity$cLBw9qa_CdI3SJPTimwGMECy4dY(this));
        ActivityMemorySearchBinding r5 = this.binding;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L18:
        r1.rvMemoryList.addOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(new d(this), RecyclerView.m.class, "com.obric.memorydata.plugin"));
        return;
    L17:
        r1 = r5;
        goto L18
    }

    private static final WindowInsetsCompat setupListeners$lambda$5(MemorySearchActivity r7, View r8, WindowInsetsCompat r9) {
        MemorySearchActivity r10 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r7, MemorySearchActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<unused var>");
        Intrinsics.checkNotNullParameter(r9, "insets");
        boolean r11 = r9.isVisible(WindowInsetsCompat.Type.ime());
        int r0 = r9.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        r10.navigationBarBottom = r9.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        ActivityMemorySearchBinding r2 = null;
        if (r11 == false) goto L12;
        RunLog.INSTANCE.debug(TAG, "IME expand, imeHeight: " + r0);
        ActivityMemorySearchBinding r12 = r10.binding;
        if (r12 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L7:
        float r1 = (-r0) / 2.0f;
        float r3 = 25;
        r12.layoutLoading.setTranslationY(MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())) + r1);
        ActivityMemorySearchBinding r13 = r10.binding;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L11:
        LinearLayout r14 = r2.layoutEmpty;
        float r4 = r1 + MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics()));
    L20:
        r14.setTranslationY(r4);
        r10.updateMemoryListPadding();
        return r9;
    L10:
        r2 = r13;
        goto L11
    L12:
        RunLog.INSTANCE.debug(TAG, "IME collapse, imeHeight: " + r0);
        ActivityMemorySearchBinding r15 = r10.binding;
        if (r15 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L15:
        float r5 = -25;
        r15.layoutLoading.setTranslationY(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics()));
        ActivityMemorySearchBinding r16 = r10.binding;
        if (r16 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L19:
        r14 = r2.layoutEmpty;
        r4 = TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics());
        goto L20
    L18:
        r2 = r16;
        goto L19
    }

    private static final void setupListeners$lambda$6(MemorySearchActivity r2, View r3, boolean r4) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).controlSoftKeyboard(r3, r4);
    }

    private static final void setupListeners$lambda$7(MemorySearchActivity r1, View r2) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemorySearchActivity.class, "com.obric.memorydata.plugin")).onBackPressed();
    }

    private final void setupNavigationBar() {
        ActivityMemorySearchBinding r0 = this.binding;
        ActivityMemorySearchBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OButtonFloating r2 = r0.memoryDelete;
        ActivityMemorySearchBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        BlurUtils.a((View) ZeusTransformUtils.preCheckCast(r1.memoryOperationContainer, View.class, "com.obric.memorydata.plugin"), BlurUtils.BlurType.PROGRESS_BLUR_UP_DOWN, TypedValue.applyDimension(1, 1, Resources.getSystem().getDisplayMetrics()), new int[0]);
        r2.setOnClickListener(new $$Lambda$MemorySearchActivity$ZNJF6XQ9wxfWTFsrzcs4BsACFIs(this));
        return;
    L8:
        r1 = r3;
        goto L9
    }

    private static final void setupNavigationBar$lambda$17$lambda$16(MemorySearchActivity r2, View r3) {
        MemorySearchActivity r4 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug(TAG, "delete");
        r4.showDeleteDialog();
    }

    private final void setupSearchHeaderLayoutRefresh() {
        View.OnLayoutChangeListener r0 = new $$Lambda$MemorySearchActivity$I4xu0Ymwbc8TFPrJriV25MVQGfA(this);
        ActivityMemorySearchBinding r1 = this.binding;
        ActivityMemorySearchBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        r1.searchHeaderContainer.addOnLayoutChangeListener(r0);
        ActivityMemorySearchBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        r3.searchTabGroup.addOnLayoutChangeListener(r0);
        ActivityMemorySearchBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        r4.searchTabContainer.addOnLayoutChangeListener(r0);
        ActivityMemorySearchBinding r5 = this.binding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r2.getRoot().post(new $$Lambda$MemorySearchActivity$JBkYqIQ_RbBFFHMyGfX_WfPF37Q(this));
        return;
    L14:
        r2 = r5;
        goto L15
    }

    private static final void setupSearchHeaderLayoutRefresh$lambda$23(MemorySearchActivity r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        MemorySearchActivity r10 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r0, MemorySearchActivity.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L18;
        RunLog r11 = RunLog.INSTANCE;
        StringBuilder r12 = new StringBuilder().append("[OTabDiag][Search] onHeaderLayout headerBottom=");
        ActivityMemorySearchBinding r13 = r10.binding;
        ActivityMemorySearchBinding r14 = null;
        if (r13 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L7:
        LinearLayout r15 = r13.searchHeaderContainer;
        Intrinsics.checkNotNullExpressionValue(r15, "searchHeaderContainer");
        StringBuilder r16 = r12.append(r10.bottomInRoot((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin"))).append(" groupBottom=");
        ActivityMemorySearchBinding r17 = r10.binding;
        if (r17 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L10:
        OUILinearLayout r18 = r17.searchTabGroup;
        Intrinsics.checkNotNullExpressionValue(r18, "searchTabGroup");
        StringBuilder r19 = r16.append(r10.bottomInRoot((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.memorydata.plugin"))).append(" tabBottom=");
        ActivityMemorySearchBinding r20 = r10.binding;
        if (r20 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L13:
        OTabLayout r21 = r20.searchTabContainer;
        Intrinsics.checkNotNullExpressionValue(r21, "searchTabContainer");
        StringBuilder r22 = r19.append(r10.bottomInRoot((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.memorydata.plugin"))).append(" cutOffH=");
        ActivityMemorySearchBinding r23 = r10.binding;
        if (r23 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L17:
        r11.debug(TAG, r22.append(r14.cutOff.getHeight()).toString());
        goto L18
    L16:
        r14 = r23;
    L18:
        r10.refreshSearchHeaderLayout();
    }

    private static final void setupSearchHeaderLayoutRefresh$lambda$24(MemorySearchActivity r2) {
        ((MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemorySearchActivity.class, "com.obric.memorydata.plugin")).refreshSearchHeaderLayout();
    }

    private final void setupSearchTabs(List<? extends SearchTab> r12) {
        List<? extends SearchTab> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        this.currentSearchTabs = r13;
        SearchTab r0 = this.selectedSearchTab;
        if (r0 != null) goto L5;
    L9:
        r0 = (SearchTab) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(this.currentSearchTabs), SearchTab.class, "com.obric.memorydata.plugin");
    L10:
        this.selectedSearchTab = r0;
        ActivityMemorySearchBinding r1 = this.binding;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L13:
        OTabLayout r2 = r1.searchTabContainer;
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L19;
        RunLog r4 = RunLog.INSTANCE;
        StringBuilder r14 = new StringBuilder().append("[OTabDiag][Search] setupSearchTabs count=").append(r13.size()).append(" selected=").append(this.selectedSearchTab).append(" groupH=");
        ActivityMemorySearchBinding r5 = this.binding;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L18:
        r4.debug(TAG, r14.append(r5.searchTabGroup.getHeight()).append(" tabLayoutH=").append(r2.getHeight()).toString());
    L19:
        r2.c();
        r2.d();
        updateSearchTabsVisibility();
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(this.currentSearchTabs, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r6 = 0;
    L20:
        boolean r7 = true;
        if (r15.hasNext() == false) goto L32;
        Object r8 = r15.next();
        int r9 = r6 + 1;
        if (r6 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        SearchTab r10 = (SearchTab) ZeusTransformUtils.preCheckCast(r8, SearchTab.class, "com.obric.memorydata.plugin");
        OTabLayoutBase.g r11 = r2.a(0).a((CharSequence) ZeusTransformUtils.preCheckCast(getString(r10.getTitleRes()), CharSequence.class, "com.obric.memorydata.plugin"));
        SearchTab r16 = this.selectedSearchTab;
        if (r10 == r16) goto L31;
        if (r16 != null) goto L30;
        if (r6 == 0) goto L31;
    L30:
        r7 = false;
    L31:
        r2.a(r11, r7);
        r6 = r9;
        goto L20
    L32:
        SearchTab r17 = this.selectedSearchTab;
        if (r17 == null) goto L37;
        int r18 = this.currentSearchTabs.indexOf(r17);
        if (r18 < 0) goto L37;
        r2.e(r18);
    L37:
        r2.a((OTabLayoutBase.c) ZeusTransformUtils.preCheckCast(new e(this), OTabLayoutBase.c.class, "com.obric.memorydata.plugin"));
        updateSearchTabsEditState$default(this, false, 1, null);
        r2.post(new $$Lambda$MemorySearchActivity$KfRjvPI2ICEfjgVwe_UK3neZQS8(this));
        return;
    L5:
        if (r13.contains(r0) == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        goto L9
    }

    private static final void setupSearchTabs$lambda$13$lambda$12(MemorySearchActivity r7) {
        MemorySearchActivity r8 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r7, MemorySearchActivity.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L15;
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r2 = new StringBuilder().append("[OTabDiag][Search] setupSearchTabs.post groupBottom=");
        ActivityMemorySearchBinding r3 = r8.binding;
        ActivityMemorySearchBinding r4 = null;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L7:
        OUILinearLayout r5 = r3.searchTabGroup;
        Intrinsics.checkNotNullExpressionValue(r5, "searchTabGroup");
        StringBuilder r6 = r2.append(r8.bottomInRoot((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"))).append(" tabBottom=");
        ActivityMemorySearchBinding r9 = r8.binding;
        if (r9 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L10:
        OTabLayout r10 = r9.searchTabContainer;
        Intrinsics.checkNotNullExpressionValue(r10, "searchTabContainer");
        StringBuilder r1 = r6.append(r8.bottomInRoot((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"))).append(" tabH=");
        ActivityMemorySearchBinding r11 = r8.binding;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L14:
        r0.debug(TAG, r1.append(r4.searchTabContainer.getHeight()).toString());
        goto L15
    L13:
        r4 = r11;
    L15:
        r8.refreshSearchHeaderLayout();
    }

    private final void showDeleteDialog() {
        com.obric.oui.dialog.v2.alert.b r0 = new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).b(false);
        if (((Number) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().f().c(), Number.class, "com.obric.memorydata.plugin")).intValue() <= 1) goto L5;
        String r3 = getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_title_multiple, TypedValues.Custom.S_STRING, "memory_card_delete_notice_title_multiple"), new Object[]{getShareViewModel().getSelectionManager().f().c()});
    L6:
        com.obric.oui.dialog.v2.alert.a r8 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(com.obric.oui.dialog.v2.alert.b.a(r0, (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a(null).a(true).b((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_cancel, TypedValues.Custom.S_STRING, "memory_card_delete_notice_cancel")), CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$MemorySearchActivity$m02QhINTpYQ06weuzCyNIll16xA.INSTANCE).a((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_confirm, TypedValues.Custom.S_STRING, "memory_card_delete_notice_confirm")), CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$MemorySearchActivity$QiSxJ1yyCMItclPIxuMVAcVgHg(this)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        r8.setCanceledOnTouchOutside(true);
        r8.setCancelable(true);
        r8.show();
        return;
    L5:
        r3 = getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_title_single, TypedValues.Custom.S_STRING, "memory_card_delete_notice_title_single"));
        goto L6
    }

    private static final Unit showDeleteDialog$lambda$35(DialogInterface r2, int r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "dialog");
        RunLog.INSTANCE.debug(TAG, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL);
        r4.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit showDeleteDialog$lambda$36(MemorySearchActivity r7, DialogInterface r8, int r9) {
        MemorySearchActivity r10 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r7, MemorySearchActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r11 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r8, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "dialog");
        RunLog.INSTANCE.debug(TAG, "confirm delete");
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(r10, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemorySearchActivity$showDeleteDialog$2$1(r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        r11.dismiss();
        r10.getShareViewModel().getSelectionManager().j();
        return Unit.INSTANCE;
    }

    private final void showViewState(ViewState r7) {
        this.currentViewState = r7;
        ActivityMemorySearchBinding r0 = this.binding;
        ActivityMemorySearchBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        LinearLayout r2 = r0.layoutEmpty;
        int r4 = 8;
        if (r7 != ViewState.EMPTY) goto L8;
        int r3 = 0;
    L9:
        r2.setVisibility(r3);
        ActivityMemorySearchBinding r5 = this.binding;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L12:
        LinearLayout r6 = r5.layoutLoading;
        if (r7 != ViewState.LOADING) goto L15;
        int r8 = 0;
    L16:
        r6.setVisibility(r8);
        ActivityMemorySearchBinding r9 = this.binding;
        if (r9 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L19:
        RecyclerView r10 = r9.rvMemoryList;
        if (r7 != ViewState.LIST) goto L22;
        r4 = 0;
    L27:
        r10.setVisibility(r4);
        updateSearchTabsVisibility();
        if (r7 != ViewState.LIST) goto L31;
        updateMemoryListPadding();
        return;
    L31:
        return;
    L22:
        ActivityMemorySearchBinding r11 = this.binding;
        if (r11 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L26:
        r1.rvMemoryList.scrollToPosition(0);
        goto L27
    L25:
        r1 = r11;
        goto L26
    L15:
        r8 = 8;
        goto L16
    L8:
        r3 = 8;
        goto L9
    }

    private final int topInRoot(View r3) {
        if (r3.getHeight() > 0) goto L5;
        return 0;
    L5:
        if (r3.isShown() == false) goto L14;
        int[] r1 = new int[2];
        int[] r0 = new int[2];
        ActivityMemorySearchBinding r2 = this.binding;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L10:
        r2.getRoot().getLocationInWindow(r1);
        r3.getLocationInWindow(r0);
        return r0[1] - r1[1];
    L14:
        return 0;
    }

    private final void updateMemoryListPadding() {
        int r0 = getMemoryListTopPadding();
        int r1 = getMemoryListBottomPadding();
        ActivityMemorySearchBinding r3 = null;
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L36;
        RunLog r2 = RunLog.INSTANCE;
        StringBuilder r5 = new StringBuilder().append("[OTabDiag][Search] updateMemoryListPadding top=").append(r0).append(" bottom=").append(r1).append(" rvOldTop=");
        ActivityMemorySearchBinding r6 = this.binding;
        if (r6 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L7:
        StringBuilder r7 = r5.append(r6.rvMemoryList.getPaddingTop()).append(" headerBottom=");
        ActivityMemorySearchBinding r8 = this.binding;
        if (r8 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L10:
        LinearLayout r9 = r8.searchHeaderContainer;
        Intrinsics.checkNotNullExpressionValue(r9, "searchHeaderContainer");
        StringBuilder r10 = r7.append(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"))).append(" groupBottom=");
        ActivityMemorySearchBinding r11 = this.binding;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L13:
        OUILinearLayout r12 = r11.searchTabGroup;
        Intrinsics.checkNotNullExpressionValue(r12, "searchTabGroup");
        StringBuilder r13 = r10.append(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"))).append(" tabBottom=");
        ActivityMemorySearchBinding r14 = this.binding;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L16:
        OTabLayout r15 = r14.searchTabContainer;
        Intrinsics.checkNotNullExpressionValue(r15, "searchTabContainer");
        StringBuilder r16 = r13.append(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin"))).append(" searchToTabsGap=");
        ActivityMemorySearchBinding r17 = this.binding;
        if (r17 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L19:
        OUILinearLayout r18 = r17.searchTabGroup;
        Intrinsics.checkNotNullExpressionValue(r18, "searchTabGroup");
        int r19 = topInRoot((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.memorydata.plugin"));
        ActivityMemorySearchBinding r20 = this.binding;
        if (r20 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L22:
        LinearLayout r21 = r20.memorySearchBarContainer;
        Intrinsics.checkNotNullExpressionValue(r21, "memorySearchBarContainer");
        StringBuilder r22 = r16.append(r19 - bottomInRoot((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.memorydata.plugin"))).append(" tabsToListGap=");
        ActivityMemorySearchBinding r23 = this.binding;
        if (r23 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L25:
        OTabLayout r24 = r23.searchTabContainer;
        Intrinsics.checkNotNullExpressionValue(r24, "searchTabContainer");
        StringBuilder r25 = r22.append(r0 - bottomInRoot((View) ZeusTransformUtils.preCheckCast(r24, View.class, "com.obric.memorydata.plugin"))).append(" firstChildTop=");
        ActivityMemorySearchBinding r26 = this.binding;
        if (r26 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L28:
        View r27 = r26.rvMemoryList.getChildAt(0);
        if (r27 == null) goto L31;
        int r28 = r27.getTop();
    L32:
        StringBuilder r29 = r25.append(r28).append(" visual=").append(visualBlockDiag(Integer.valueOf(r0))).append(" cutOffH=");
        ActivityMemorySearchBinding r30 = this.binding;
        if (r30 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r30 = null;
    L35:
        r2.debug(TAG, r29.append(r30.cutOff.getHeight()).toString());
        goto L36
    L31:
        r28 = -1;
    L36:
        ActivityMemorySearchBinding r110 = this.binding;
        if (r110 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L40:
        float r4 = 12;
        r3.rvMemoryList.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics())), r0, MathKt.roundToInt(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics())), r1);
        return;
    L39:
        r3 = r110;
        goto L40
    }

    private final void updateSearchTabsEditState(boolean r1) {
        ActivityMemorySearchBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.searchTabContainer.setEnabled(!r1);
    }

    static /* synthetic */ void updateSearchTabsEditState$default(MemorySearchActivity r1, boolean r2, int r3, Object r4) {
        MemorySearchActivity r5 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemorySearchActivity.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = ((Boolean) ZeusTransformUtils.preCheckCast(r5.getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        r5.updateSearchTabsEditState(r2);
    }

    private final void updateSearchTabsVisibility() {
        ActivityMemorySearchBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OUILinearLayout r1 = r0.searchTabGroup;
        bi r2 = bi.f11242a;
        int r4 = 0;
        if (this.currentViewState != ViewState.LOADING) goto L8;
        boolean r3 = true;
    L10:
        if (this.currentViewState != ViewState.LIST) goto L12;
        boolean r5 = true;
    L13:
        int r8 = b.f11060a[r2.a(r3, r5, !((Collection) ZeusTransformUtils.preCheckCast(this.currentSearchTabs, Collection.class, "com.obric.memorydata.plugin")).isEmpty()).ordinal()];
        if (r8 != 1) goto L16;
        r4 = 8;
    L24:
        r1.setVisibility(r4);
        return;
    L16:
        if (r8 != 2) goto L18;
        r4 = 4;
        goto L24
    L18:
        if (r8 == 3) goto L24;
        throw new NoWhenBranchMatchedException();
    L12:
        r5 = false;
        goto L13
    L8:
        r3 = false;
        goto L10
    }

    private final String viewDiag(View r7) {
        if (r7 != null) goto L5;
        return "null";
    L5:
        int[] r6 = new int[2];
        r7.getLocationInWindow(r6);
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.class) == false) goto L8;
        String r0 = ",clipChildren=" + ((ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.memorydata.plugin")).getClipChildren() + ",clipToPadding=" + ((ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.memorydata.plugin")).getClipToPadding() + ",childCount=" + ((ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
    L9:
        ViewGroup.LayoutParams r2 = r7.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.MarginLayoutParams.class) == false) goto L12;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L14:
        if (r1 == null) goto L17;
        String r3 = new StringBuilder().append(r1.leftMargin).append(',').append(r1.topMargin).append(',').append(r1.rightMargin).append(',').append(r1.bottomMargin).toString();
        if (r3 == null) goto L17;
    L18:
        StringBuilder r4 = new StringBuilder();
        r4.append(r7.getClass().getSimpleName()).append('@').append(r6[0]).append(',').append(r6[1]).append(" size=").append(r7.getWidth()).append('x').append(r7.getHeight()).append(" top=").append(r7.getTop()).append(" bottom=").append(r7.getBottom()).append(" padding=").append(r7.getPaddingLeft()).append(',').append(r7.getPaddingTop()).append(',').append(r7.getPaddingRight()).append(',').append(r7.getPaddingBottom()).append(" margin=").append(r3);
        r4.append(" visible=").append(r7.getVisibility()).append(" tx=").append(r7.getTranslationX()).append(" ty=").append(r7.getTranslationY()).append(r0);
        return r4.toString();
    L17:
        r3 = "n/a";
        goto L18
    L12:
        r1 = null;
        goto L14
    L8:
        r0 = "";
        goto L9
    }

    private final String visualBlockDiag(Integer r10) {
        ActivityMemorySearchBinding r0 = this.binding;
        ActivityMemorySearchBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        LinearLayout r2 = r0.searchHeaderContainer;
        Intrinsics.checkNotNullExpressionValue(r2, "searchHeaderContainer");
        int r3 = topInRoot((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        int r4 = MathKt.roundToInt(TypedValue.applyDimension(1, 56, Resources.getSystem().getDisplayMetrics())) + r3;
        int r6 = MathKt.roundToInt(TypedValue.applyDimension(1, 52, Resources.getSystem().getDisplayMetrics())) + r4;
        if (r10 == null) goto L8;
        int r11 = r10.intValue();
    L12:
        StringBuilder r5 = new StringBuilder().append("status=0..").append(pxToDp(r3)).append(" searchBlock=").append(pxToDp(r3)).append("..").append(pxToDp(r4)).append(" filterBlock=").append(pxToDp(r4)).append("..").append(pxToDp(r6)).append(" header=");
        ActivityMemorySearchBinding r7 = this.binding;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L15:
        LinearLayout r8 = r7.searchHeaderContainer;
        Intrinsics.checkNotNullExpressionValue(r8, "searchHeaderContainer");
        StringBuilder r9 = r5.append(rectDp((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"))).append(" searchBar=");
        ActivityMemorySearchBinding r12 = this.binding;
        if (r12 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L18:
        OSearchBar r13 = r12.memorySearchBar;
        Intrinsics.checkNotNullExpressionValue(r13, "memorySearchBar");
        StringBuilder r14 = r9.append(rectDp((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin"))).append(" tabs=");
        ActivityMemorySearchBinding r15 = this.binding;
        if (r15 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L22:
        OTabLayout r16 = r1.searchTabContainer;
        Intrinsics.checkNotNullExpressionValue(r16, "searchTabContainer");
        return r14.append(rectDp((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin"))).append(" listTop=").append(pxToDp(r11)).toString();
    L21:
        r1 = r15;
        goto L22
    L8:
        ActivityMemorySearchBinding r17 = this.binding;
        if (r17 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L11:
        r11 = r17.rvMemoryList.getPaddingTop();
        goto L12
    }

    static /* synthetic */ String visualBlockDiag$default(MemorySearchActivity r1, Integer r2, int r3, Object r4) {
        MemorySearchActivity r5 = (MemorySearchActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemorySearchActivity.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = null;
    L6:
        return r5.visualBlockDiag(r2);
    }

    public final void controlSoftKeyboard(final View r7, boolean r8) {
        if (r7 != null) goto L6;
        MemorySearchActivity r6 = (MemorySearchActivity) ZeusTransformUtils.preCheckCast(this, MemorySearchActivity.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "控制软键盘失败：View为空", null, 4, null);
        return;
    L6:
        final InputMethodManager r9 = (InputMethodManager) ZeusTransformUtils.preCheckCast(getSystemService(InputMethodManager.class), InputMethodManager.class, "com.obric.memorydata.plugin");
        if (r8 == false) goto L9;
        r7.postDelayed(new $$Lambda$MemorySearchActivity$JBIxfVNUqNuyetMsIRZEp3h8D4o(r7, r9), 200);
        return;
    L9:
        r9.hideSoftInputFromWindow(r7.getWindowToken(), 0);
        r7.clearFocus();
    }

    @Override // com.obric.memorydata.memory.ui.BaseMemoryActivity
    public String getEnterFrom() {
        return MemoryEventTracker.SourceType.MEMORY_SEARCH.getValue();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public NavigationBarScheme getNavigationBarScheme() {
        if (this.binding == null) goto L8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L8;
        return NavigationBarScheme.A;
    L8:
        return NavigationBarScheme.B1;
    }

    public final SearchViewModel getViewModel() {
        return (SearchViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), SearchViewModel.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L5;
        getShareViewModel().getSelectionManager().j();
        return;
    L5:
        super.onBackPressed();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onCreateChecked", false, 4, null);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        prepareSystemBar();
        ActivityMemorySearchBinding r10 = ActivityMemorySearchBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r10, "inflate(...)");
        this.binding = r10;
        getShareViewModel().getSelectionManager().a(Integer.MAX_VALUE);
        ActivityMemorySearchBinding r11 = this.binding;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r11.getRoot(), View.class, "com.obric.memorydata.plugin"));
        initViews();
        observeState();
        getShareViewModel().registerGlobalMemoryObserver();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onResumeChecked() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onResumeChecked", false, 4, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11671(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void removeSingleMemoryItem(com.obric.memorydata.memory.ui.data.a r10) {
        Intrinsics.checkNotNullParameter(r10, "memoryItem");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "removeSingleMemoryItem type: " + r10.getType(), false, 4, null);
        ActivityMemorySearchBinding r0 = this.binding;
        ActivityMemorySearchBinding r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        if (r0.rvMemoryList.getItemAnimator() != null) goto L12;
        ActivityMemorySearchBinding r2 = this.binding;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L11:
        r1.rvMemoryList.setItemAnimator((RecyclerView.e) ZeusTransformUtils.preCheckCast(new com.obric.oui.orecyclerview.widget.h(), RecyclerView.e.class, "com.obric.memorydata.plugin"));
        goto L12
    L10:
        r1 = r2;
    L12:
        getViewModel().removeMemoryItems(CollectionsKt.listOf(r10));
    }
}
