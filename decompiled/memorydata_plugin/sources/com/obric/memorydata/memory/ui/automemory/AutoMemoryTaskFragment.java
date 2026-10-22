package com.obric.memorydata.memory.ui.automemory;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.memorydata.memory.databinding.FragmentAutoMemoryTaskBinding;
import com.obric.memorydata.memory.ui.automemory.create.CreateMemoryTaskActivity;
import com.obric.memorydata.memory.ui.list.MemoryContainerTab;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.memory.ui.list.MemoryListShareViewModel;
import com.obric.memorydata.memory.ui.list.MemorySearchActivity;
import com.obric.memorydata.memory.ui.list.MemoryTabContainerAdapter;
import com.obric.memorydata.memory.ui.list.ac;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.BaseFragment;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OFloatingActionButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.tab.OTabLayoutBase;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBarActionHost;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ai;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 }2\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004:\u0002|}B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J$\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00101\u001a\u00020/H\u0016J\b\u00102\u001a\u00020/H\u0016J\b\u00103\u001a\u00020/H\u0016J\b\u00104\u001a\u00020/H\u0002J\b\u00105\u001a\u00020/H\u0002J\u0010\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\u001eH\u0002J\u0006\u00108\u001a\u00020\u001eJ\b\u00109\u001a\u0004\u0018\u00010:J\b\u0010;\u001a\u00020/H\u0016J\b\u0010<\u001a\u00020/H\u0002J\b\u0010=\u001a\u00020/H\u0002J\b\u0010>\u001a\u00020/H\u0002J\b\u0010?\u001a\u00020\u001eH\u0002J\b\u0010@\u001a\u00020/H\u0002J\b\u0010A\u001a\u00020/H\u0002J0\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020HH\u0002J\u001c\u0010J\u001a\u00020/*\u00020D2\u0006\u0010E\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020HH\u0002J\b\u0010L\u001a\u00020/H\u0002J\u0014\u0010M\u001a\u00020/*\u00020'2\u0006\u0010N\u001a\u00020\u001eH\u0002J\b\u0010O\u001a\u00020PH\u0002J\b\u0010Q\u001a\u00020\u001eH\u0002J\u0010\u0010R\u001a\u00020\u001e2\u0006\u0010S\u001a\u00020\u001eH\u0002J\u0018\u0010T\u001a\u00020/2\u0006\u00100\u001a\u00020'2\u0006\u0010U\u001a\u00020PH\u0002J\b\u0010V\u001a\u00020/H\u0002J\b\u0010W\u001a\u00020/H\u0002J\b\u0010X\u001a\u00020/H\u0002J\b\u0010Y\u001a\u00020/H\u0002J\b\u0010Z\u001a\u00020/H\u0002J\b\u0010[\u001a\u00020\u001eH\u0002J\b\u0010\\\u001a\u00020/H\u0002J\b\u0010]\u001a\u00020/H\u0002J\b\u0010^\u001a\u00020/H\u0002J\b\u0010_\u001a\u00020/H\u0002J\b\u0010`\u001a\u00020/H\u0002J\u0010\u0010a\u001a\u00020\"2\u0006\u0010b\u001a\u00020cH\u0002J\u0010\u0010d\u001a\u00020/2\u0006\u0010b\u001a\u00020cH\u0002J\b\u0010e\u001a\u00020/H\u0002J\b\u0010f\u001a\u00020/H\u0002J\b\u0010g\u001a\u00020/H\u0002J\u0010\u0010h\u001a\u00020H2\u0006\u0010b\u001a\u00020iH\u0002J\u0010\u0010j\u001a\u00020/2\u0006\u0010k\u001a\u00020 H\u0002J\b\u0010l\u001a\u00020/H\u0002J\u0010\u0010m\u001a\u00020/2\u0006\u0010k\u001a\u00020nH\u0002J\u0010\u0010o\u001a\u00020/2\u0006\u0010p\u001a\u00020\"H\u0002J\b\u0010q\u001a\u00020HH\u0002J\u0010\u0010r\u001a\u00020/2\u0006\u0010s\u001a\u00020HH\u0002J\u0010\u0010t\u001a\u00020/2\u0006\u0010s\u001a\u00020HH\u0002J\u0010\u0010u\u001a\u00020H2\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010v\u001a\u00020/2\u0006\u0010s\u001a\u00020HH\u0002J\u0012\u0010w\u001a\u00020H2\b\u00100\u001a\u0004\u0018\u00010'H\u0002J\u0010\u0010x\u001a\u00020H2\u0006\u0010y\u001a\u00020\u001eH\u0002J\u0010\u0010z\u001a\u00020/2\u0006\u0010{\u001a\u00020\"H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#¨\u0006~"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTaskFragment;", "Lcom/obric/memorydata/ui/BaseFragment;", "Lcom/obric/memorydata/memory/ui/list/MemoryNestedViewPagerHost;", "Lcom/obric/memorydata/ui/FloatingTitleBarOwner;", "Lcom/obric/memorydata/memory/ui/MemoryFloatingTitleBarOwner;", "<init>", "()V", "_binding", "Lcom/obric/memorydata/memory/databinding/FragmentAutoMemoryTaskBinding;", "binding", "getBinding", "()Lcom/obric/memorydata/memory/databinding/FragmentAutoMemoryTaskBinding;", "viewModel", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "shareViewModel", "Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "getShareViewModel", "()Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "shareViewModel$delegate", "bottomTabLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "pageChangeCallback", "Lcom/obric/oui/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "loadingBackCallback", "Landroidx/activity/OnBackPressedCallback;", "titleBarTotalHeight", "", "pageState", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTaskFragment$PageState;", "titleBarActionsForGuide", "", "Ljava/lang/Boolean;", "getCurrentFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onStop", "onDestroyView", "setupTitleBar", "setupStatusBarInset", "applyStatusBarTop", "top", "getCollectionListTopPadding", "getCollectionViewPager", "Lcom/obric/oui/viewpager2/widget/ViewPager2;", "resetNestedViewPagerScroll", "updateTaskHeaderLayout", "updateCollectionListTopPadding", "dismissCollectionOperationMenus", "getTaskTabTopMarginInMask", "setupGuide", "setupGuideFeatureItems", "configureGuideFeatureItem", "item", "Lcom/obric/oui/lisitem/OCardListItem;", "position", "icon", "title", "", "subtitle", "applyGuideCardListItemMetrics", "caller", "applyGuideBaselineLayout", "updateTopMargin", "topMargin", "getDefaultDensity", "", "getGuideBaselineDensityDpi", "guideDefaultDp", "dp", "normalizeGuideTextSize", "fontScale", "setupGuideBottomSpacing", "clearGuideBottomSpacingListener", "updateGuideBottomSpacing", "updateBottomAnchoredControls", "updateFloatingAddButtonBottomMargin", "getBottomTabVisibleHeight", "setupTaskTabs", "setupFloatingAddButton", "setupLoadingStatus", "setupLoadingBackHandler", "closeLoadingAndReturnToPreviousBottomTab", "isBottomTabAvailable", "tab", "Lcom/obric/memorydata/memory/ui/list/MemoryContainerTab;", "switchBottomTab", "handleCreateCollectionClick", "setupViewPager", "observeState", "getTabTitle", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTab;", "switchPage", "state", "checkUpdatingIfCurrentMemoryTaskTab", "updateTaskContentVisibility", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryUiState;", "updateParentBottomControlsForLoading", "showLoading", "parentBottomControlsDiag", "dumpGuideDiag", InfoRequestQPSOptTraceLogger.REASON, "dumpGuideCardDiag", "guideItemDiag", "dumpHeaderDiag", "viewDiag", "visibilityName", "visibility", "configureTitleBarEndActions", "showGuide", "PageState", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryTaskFragment extends BaseFragment implements ac, com.obric.memorydata.ui.b {
    private static final int COLLECTION_LIST_TOP_PADDING_DP = 8;
    public static final a Companion = null;
    private static final int DEFAULT_TITLE_BAR_TOTAL_HEIGHT_DP = 96;
    private static final int FLOATING_ADD_BUTTON_BOTTOM_GAP_DP = 4;
    private static final int GUIDE_ACTION_BOTTOM_GAP_DP = 42;
    private static final int GUIDE_ACTION_MARGIN_TOP_DP = 38;
    private static final int GUIDE_ACTION_PADDING_HORIZONTAL_DP = 20;
    private static final int GUIDE_ACTION_PADDING_VERTICAL_DP = 8;
    private static final int GUIDE_BASELINE_DENSITY_DPI = 560;
    private static final int GUIDE_BASELINE_SHORT_SIDE_PX = 1260;
    private static final int GUIDE_BUTTON_HEIGHT_DP = 48;
    private static final int GUIDE_BUTTON_WIDTH_DP = 184;
    private static final int GUIDE_CARD_MARGIN_HORIZONTAL_DP = 12;
    private static final int GUIDE_CONTENT_HEIGHT_DP = 720;
    private static final int GUIDE_CONTENT_PADDING_BOTTOM_DP = 16;
    private static final int GUIDE_CONTENT_PADDING_TOP_DP = 139;
    private static final int GUIDE_DENSITY_ROUND_STEP_DPI = 10;
    private static final int GUIDE_FEATURE_LIST_MARGIN_TOP_DP = 48;
    private static final int GUIDE_IMAGE_SIZE_DP = 72;
    private static final int GUIDE_SUBTITLE_MARGIN_TOP_DP = 6;
    private static final int GUIDE_TITLE_MARGIN_TOP_DP = 24;
    private static final String TAG = "AutoMemoryTaskFragment";
    private static final int TASK_TAB_BOTTOM_MARGIN_DP = 8;
    private static final int TASK_TAB_HEIGHT_DP = 40;
    private static final int TASK_TAB_HORIZONTAL_INSET_DP = 4;
    private static final int TASK_TAB_TOP_MARGIN_DP = 8;
    private FragmentAutoMemoryTaskBinding _binding;
    private View.OnLayoutChangeListener bottomTabLayoutListener;
    private OnBackPressedCallback loadingBackCallback;
    private ViewPager2.e pageChangeCallback;
    private PageState pageState;
    private final Lazy shareViewModel$delegate;
    private Boolean titleBarActionsForGuide;
    private int titleBarTotalHeight;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTaskFragment$PageState;", "", "<init>", "(Ljava/lang/String;I)V", "GUIDE", "CONTENT", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum PageState extends Enum<PageState> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ PageState[] $VALUES = null;
        public static final PageState CONTENT = null;
        public static final PageState GUIDE = null;

        private static final /* synthetic */ PageState[] $values() {
            return new PageState[]{GUIDE, CONTENT};
        }

        static {
            GUIDE = new PageState("GUIDE", 0);
            CONTENT = new PageState("CONTENT", 1);
            PageState[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private PageState(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<PageState> getEntries() {
            return $ENTRIES;
        }

        public static PageState valueOf(String r2) {
            return (PageState) ZeusTransformUtils.preCheckCast(Enum.valueOf(PageState.class, r2), PageState.class, "com.obric.memorydata.plugin");
        }

        public static PageState[] values() {
            return (PageState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PageState[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTaskFragment$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_TITLE_BAR_TOTAL_HEIGHT_DP", "", "TASK_TAB_TOP_MARGIN_DP", "TASK_TAB_HEIGHT_DP", "TASK_TAB_BOTTOM_MARGIN_DP", "TASK_TAB_HORIZONTAL_INSET_DP", "COLLECTION_LIST_TOP_PADDING_DP", "GUIDE_ACTION_BOTTOM_GAP_DP", "FLOATING_ADD_BUTTON_BOTTOM_GAP_DP", "GUIDE_CONTENT_HEIGHT_DP", "GUIDE_CONTENT_PADDING_TOP_DP", "GUIDE_CONTENT_PADDING_BOTTOM_DP", "GUIDE_IMAGE_SIZE_DP", "GUIDE_TITLE_MARGIN_TOP_DP", "GUIDE_SUBTITLE_MARGIN_TOP_DP", "GUIDE_FEATURE_LIST_MARGIN_TOP_DP", "GUIDE_ACTION_MARGIN_TOP_DP", "GUIDE_ACTION_PADDING_HORIZONTAL_DP", "GUIDE_ACTION_PADDING_VERTICAL_DP", "GUIDE_BUTTON_WIDTH_DP", "GUIDE_BUTTON_HEIGHT_DP", "GUIDE_CARD_MARGIN_HORIZONTAL_DP", "GUIDE_BASELINE_SHORT_SIDE_PX", "GUIDE_BASELINE_DENSITY_DPI", "GUIDE_DENSITY_ROUND_STEP_DPI", "newInstance", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTaskFragment;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final AutoMemoryTaskFragment a() {
            return new AutoMemoryTaskFragment();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10599a = null;

        static {
            int[] r0 = new int[AutoMemoryTab.values().length];
            r0[AutoMemoryTab.AUTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AutoMemoryTab.DISCOVER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10599a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/automemory/AutoMemoryTaskFragment$setupTaskTabs$1$2", "Lcom/obric/oui/tab/OTabLayoutBase$OnTabSelectedListener;", "onTabSelected", "", "tab", "Lcom/obric/oui/tab/OTabLayoutBase$Tab;", "onTabUnselected", "onTabReselected", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements OTabLayoutBase.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AutoMemoryTaskFragment f10600a;

        c(AutoMemoryTaskFragment r1) {
            this.f10600a = r1;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void a(OTabLayoutBase.g r2) {
            AutoMemoryTab.a r0 = AutoMemoryTab.Companion;
            if (r2 == null) goto L8;
            AutoMemoryTab r3 = r0.a(r2.c());
            if (r3 == null) goto L9;
            AutoMemoryTaskFragment.access$getViewModel(this.f10600a).selectTab(r3);
            return;
        L9:
            return;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void b(OTabLayoutBase.g r1) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void c(OTabLayoutBase.g r1) {
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/automemory/AutoMemoryTaskFragment$setupViewPager$1", "Lcom/obric/oui/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrollStateChanged", "", "state", "", "onPageSelected", "position", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends ViewPager2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AutoMemoryTaskFragment f10601a;

        d(AutoMemoryTaskFragment r1) {
            this.f10601a = r1;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
        public void a(int r2) {
            if (r2 != 1) goto L6;
            AutoMemoryTaskFragment.access$dismissCollectionOperationMenus(this.f10601a);
            return;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
        public void b(int r3) {
            AutoMemoryTaskFragment.access$dismissCollectionOperationMenus(this.f10601a);
            AutoMemoryTab r4 = AutoMemoryTab.Companion.a(r3);
            if (r4 == null) goto L5;
            AutoMemoryTaskFragment.access$getViewModel(this.f10601a).selectTab(r4);
        L5:
            FragmentActivity r5 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f10601a.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r5, MemoryListActivity.class) == false) goto L8;
            MemoryListActivity r6 = (MemoryListActivity) ZeusTransformUtils.preCheckCast(r5, MemoryListActivity.class, "com.obric.memorydata.plugin");
        L9:
            if (r6 == null) goto L12;
            r6.trackContainerPageShow(MemoryContainerTab.AUTO_MEMORY_TASK, this.f10601a.isResumed());
            return;
        L12:
            return;
        L8:
            r6 = null;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskFragment$handleCreateCollectionClick$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskFragment$handleCreateCollectionClick$1", f = "AutoMemoryTaskFragment.kt", i = {}, l = {576}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AutoMemoryTaskFragment this$0;

        AnonymousClass1(AutoMemoryTaskFragment r3, Continuation<? super AnonymousClass1> r4) {
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
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L12:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L16;
            FragmentActivity r10 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
            if (r10 == null) goto L21;
            com.obric.oui.toast.a.C0786a r4 = com.obric.oui.toast.a.f14807a;
            Context r5 = (Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.memorydata.plugin");
            String r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_create_add_up_limit, TypedValues.Custom.S_STRING, "memory_create_add_up_limit"));
            Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
            com.obric.oui.toast.a.C0786a.a(r4, r5, r6, 0, 4, null);
        L21:
            return Unit.INSTANCE;
        L16:
            CreateMemoryTaskActivity.a r12 = CreateMemoryTaskActivity.Companion;
            Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            if (r13 != null) goto L19;
            r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        L19:
            r12.a(r13);
            goto L21
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            AutoMemoryViewModel r14 = AutoMemoryTaskFragment.access$getViewModel(this.this$0);
            Continuation<? super Boolean> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r11 = r14.hasReachedManualCollectionLimit(r2);
            if (r11 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskFragment$observeState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskFragment$observeState$1", f = "AutoMemoryTaskFragment.kt", i = {}, l = {614}, m = "invokeSuspend", n = {}, s = {})
    static final class C11221 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AutoMemoryTaskFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskFragment$observeState$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskFragment$observeState$1$1", f = "AutoMemoryTaskFragment.kt", i = {}, l = {615}, m = "invokeSuspend", n = {}, s = {})
        static final class C05281 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AutoMemoryTaskFragment this$0;

            C05281(AutoMemoryTaskFragment r3, Continuation<? super C05281> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C05281(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((C05281) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05281.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
                ar<u> r7 = AutoMemoryTaskFragment.access$getViewModel(this.this$0).getState();
                final AutoMemoryTaskFragment r3 = this.this$0;
                kotlinx.coroutines.flow.j<? super u> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05291(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                if (r7.collect(r2, r4) != r0) goto L12;
                return r0;
            }
        }

        C11221(AutoMemoryTaskFragment r3, Continuation<? super C11221> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11221(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11221) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11221.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            Lifecycle.State r2 = Lifecycle.State.RESUMED;
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new C05281(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskFragment$observeState$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskFragment$observeState$2", f = "AutoMemoryTaskFragment.kt", i = {}, l = {629}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AutoMemoryTaskFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskFragment$observeState$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskFragment$observeState$2$1", f = "AutoMemoryTaskFragment.kt", i = {}, l = {630}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AutoMemoryTaskFragment this$0;

            AnonymousClass1(AutoMemoryTaskFragment r3, Continuation<? super AnonymousClass1> r4) {
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
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
                ae<String> r7 = AutoMemoryTaskFragment.access$getShareViewModel(this.this$0).getSelectBottomTab();
                final AutoMemoryTaskFragment r3 = this.this$0;
                kotlinx.coroutines.flow.j<? super String> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05301(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                if (r7.collect(r2, r4) != r0) goto L12;
                return r0;
            }
        }

        AnonymousClass2(AutoMemoryTaskFragment r3, Continuation<? super AnonymousClass2> r4) {
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
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            Lifecycle.State r2 = Lifecycle.State.RESUMED;
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskFragment$observeState$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskFragment$observeState$3", f = "AutoMemoryTaskFragment.kt", i = {}, l = {641}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AutoMemoryTaskFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskFragment$observeState$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskFragment$observeState$3$1", f = "AutoMemoryTaskFragment.kt", i = {}, l = {642}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AutoMemoryTaskFragment this$0;

            AnonymousClass1(AutoMemoryTaskFragment r3, Continuation<? super AnonymousClass1> r4) {
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
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
                ai<t> r7 = AutoMemoryTaskFragment.access$getViewModel(this.this$0).getEvents();
                kotlinx.coroutines.flow.j<? super t> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(C05311.f10604a, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                if (r7.collect(r2, r3) != r0) goto L12;
                return r0;
            }
        }

        AnonymousClass3(AutoMemoryTaskFragment r3, Continuation<? super AnonymousClass3> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public AutoMemoryTaskFragment() {
        this.viewModel$delegate = LazyKt.lazy(new $$Lambda$AutoMemoryTaskFragment$HtbOCGxTZdUEEEO3XWMNXTUhbc(this));
        this.shareViewModel$delegate = LazyKt.lazy(new $$Lambda$AutoMemoryTaskFragment$6YFTrdJa7yWqk2EIEIGLYHkQdG8(this));
        this.titleBarTotalHeight = MathKt.roundToInt(TypedValue.applyDimension(1, DEFAULT_TITLE_BAR_TOTAL_HEIGHT_DP, Resources.getSystem().getDisplayMetrics()));
        this.pageState = PageState.GUIDE;
    }

    public static final /* synthetic */ void access$checkUpdatingIfCurrentMemoryTaskTab(AutoMemoryTaskFragment r0) {
        r0.checkUpdatingIfCurrentMemoryTaskTab();
    }

    public static final /* synthetic */ void access$closeLoadingAndReturnToPreviousBottomTab(AutoMemoryTaskFragment r0) {
        r0.closeLoadingAndReturnToPreviousBottomTab();
    }

    public static final /* synthetic */ void access$dismissCollectionOperationMenus(AutoMemoryTaskFragment r0) {
        r0.dismissCollectionOperationMenus();
    }

    public static final /* synthetic */ MemoryListShareViewModel access$getShareViewModel(AutoMemoryTaskFragment r0) {
        return r0.getShareViewModel();
    }

    public static final /* synthetic */ AutoMemoryViewModel access$getViewModel(AutoMemoryTaskFragment r0) {
        return r0.getViewModel();
    }

    public static final /* synthetic */ FragmentAutoMemoryTaskBinding access$get_binding$p(AutoMemoryTaskFragment r0) {
        return r0._binding;
    }

    public static final /* synthetic */ void access$updateTaskContentVisibility(AutoMemoryTaskFragment r0, u r1) {
        r0.updateTaskContentVisibility(r1);
    }

    private final void applyGuideBaselineLayout() {
        final float r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        final float r2 = getDefaultDensity();
        final float r3 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().fontScale;
        LinearLayout r4 = getBinding().guideContent;
        r4.setScaleX(1.0f);
        r4.setScaleY(1.0f);
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        r5.height = guideDefaultDp(GUIDE_CONTENT_HEIGHT_DP);
        r4.setLayoutParams(r5);
        boolean r7 = false;
        r4.setPadding(0, guideDefaultDp(GUIDE_CONTENT_PADDING_TOP_DP), 0, guideDefaultDp(16));
        ImageView r6 = getBinding().guideImage;
        ViewGroup.LayoutParams r8 = getBinding().guideImage.getLayoutParams();
        r8.width = guideDefaultDp(GUIDE_IMAGE_SIZE_DP);
        r8.height = guideDefaultDp(GUIDE_IMAGE_SIZE_DP);
        r6.setLayoutParams(r8);
        OTextView r9 = getBinding().guideTitle;
        Intrinsics.checkNotNullExpressionValue(r9, "guideTitle");
        updateTopMargin((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), guideDefaultDp(24));
        OTextView r10 = getBinding().guideSubtitle;
        Intrinsics.checkNotNullExpressionValue(r10, "guideSubtitle");
        updateTopMargin((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), guideDefaultDp(6));
        LinearLayout r11 = getBinding().guideFeatureList;
        Intrinsics.checkNotNullExpressionValue(r11, "guideFeatureList");
        updateTopMargin((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"), guideDefaultDp(48));
        FrameLayout r12 = getBinding().guideActionBar;
        Intrinsics.checkNotNullExpressionValue(r12, "guideActionBar");
        updateTopMargin((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"), guideDefaultDp(38));
        getBinding().guideActionBar.setPadding(guideDefaultDp(20), guideDefaultDp(8), guideDefaultDp(20), guideDefaultDp(8));
        OButton r13 = getBinding().guideStartButton;
        ViewGroup.LayoutParams r14 = getBinding().guideStartButton.getLayoutParams();
        r14.width = guideDefaultDp(GUIDE_BUTTON_WIDTH_DP);
        r14.height = guideDefaultDp(48);
        r13.setLayoutParams(r14);
        if (r3 != 0.0f) goto L5;
        r7 = true;
    L5:
        if (r7 == true) goto L7;
        LinearLayout r15 = getBinding().guideContent;
        Intrinsics.checkNotNullExpressionValue(r15, "guideContent");
        normalizeGuideTextSize((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin"), r3);
    L7:
        getBinding().guideContent.post(new $$Lambda$AutoMemoryTaskFragment$YktM_LU2HVB0siVgfW4ovNRUg(this, r1, r2, r3));
    }

    private static final void applyGuideBaselineLayout$lambda$31(AutoMemoryTaskFragment r4, float r5, float r6, float r7) {
        FragmentAutoMemoryTaskBinding r0 = r4._binding;
        if (r0 != null) goto L6;
        return;
    L6:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L8;
        RunLog.INSTANCE.debug(TAG, "[AutoTaskDiag] applyGuideBaselineLayout density=" + r5 + " defaultDensity=" + r6 + " defaultDensityDpi=" + r4.getGuideBaselineDensityDpi() + " resolution=" + ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels + 'x' + ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDisplayMetrics().heightPixels + " fontScale=" + r7 + " guideContent=" + r4.viewDiag((View) ZeusTransformUtils.preCheckCast(r0.guideContent, View.class, "com.obric.memorydata.plugin")));
    L8:
        r4.dumpGuideCardDiag("applyGuideBaselineLayout.post");
    }

    private final void applyGuideCardListItemMetrics(OCardListItem r7, int r8, String r9) {
        OTextView r0 = r7.getTitleView();
        r0.setMaxLines(1);
        r0.setEllipsize(TextUtils.TruncateAt.END);
        OTextView r1 = r7.getSubTitleView();
        r1.setMaxLines(2);
        r1.setEllipsize(TextUtils.TruncateAt.END);
        FrameLayout r2 = r7.getCardContainer();
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L7:
        if (r4 == null) goto L14;
        int r5 = guideDefaultDp(12);
        if (r4.getMarginStart() == r5) goto L11;
    L12:
        r4.setMarginStart(r5);
        r4.setMarginEnd(r5);
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        goto L14
    L11:
        if (r4.getMarginEnd() != r5) goto L12;
    L14:
        if (Intrinsics.areEqual(r9, "layout") == false) goto L16;
        return;
    L16:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L20;
        RunLog.INSTANCE.debug(TAG, "[AutoTaskDiag] applyGuideCardListItemMetrics caller=" + r9 + " position=" + r8 + " expectedMargin=" + guideDefaultDp(12) + "px density=" + ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDisplayMetrics().density + " defaultDensity=" + getDefaultDensity() + " fontScale=" + ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getConfiguration().fontScale + " item=" + guideItemDiag(r7));
        return;
    L20:
        return;
    L5:
        r4 = null;
        goto L7
    }

    private final void applyStatusBarTop(int r3) {
        getBinding().titleBar.a(RangesKt.coerceAtLeast(r3, 0));
        dumpHeaderDiag("applyStatusBarTop(" + r3 + ").beforeHeaderUpdate");
        updateTaskHeaderLayout();
    }

    private final void checkUpdatingIfCurrentMemoryTaskTab() {
        if (this.pageState != PageState.GUIDE) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(getShareViewModel().getSelectBottomTab().c(), MemoryContainerTab.AUTO_MEMORY_TASK.getText()) == true) goto L8;
        return;
    L8:
        getViewModel().checkUpdatingOnceAndShowLoading();
    }

    private final void clearGuideBottomSpacingListener() {
        View.OnLayoutChangeListener r0 = this.bottomTabLayoutListener;
        if (r0 != null) goto L5;
        return;
    L5:
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L10;
        View r2 = r1.findViewById(ZeusTransformUtils.mapRes(R.id.memory_container_tab_view, OaidModel.KEY_ID, "memory_container_tab_view"));
        if (r2 == null) goto L10;
        r2.removeOnLayoutChangeListener(r0);
    L10:
        this.bottomTabLayoutListener = null;
    }

    private final void closeLoadingAndReturnToPreviousBottomTab() {
        getViewModel().cancelRuleUpdatingLoading();
        MemoryContainerTab r0 = getShareViewModel().getPreviousBottomTabBeforeAutoMemory();
        if (r0 != null) goto L5;
    L10:
        r0 = MemoryContainerTab.GLOBAL_MEMORY;
    L11:
        switchBottomTab(r0);
        return;
    L5:
        if (isBottomTabAvailable(r0) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        goto L10
    }

    private final void configureGuideFeatureItem(final OCardListItem r5, final int r6, int r7, String r8, String r9) {
        r5.setCardType(1);
        r5.setShowCardBg(true);
        OCardListItem.a(r5, r6, false, 2, null);
        r5.setIcon(r7);
        r5.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"));
        r5.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"));
        r5.b(true);
        r5.c(true);
        r5.d(true);
        r5.e(false);
        r5.f(false);
        applyGuideCardListItemMetrics(r5, r6, CommonConsts.APM_INNER_EVENT_COST_INIT);
        r5.addOnLayoutChangeListener(new $$Lambda$AutoMemoryTaskFragment$Obettk3h1m6Ra5THFU8VWNbg84(this, r5, r6));
        r5.post(new $$Lambda$AutoMemoryTaskFragment$uZiUQWbFLgaV6Y6kFy21r51Mgoc(this, r5, r6));
    }

    private static final void configureGuideFeatureItem$lambda$20(AutoMemoryTaskFragment r0, OCardListItem r1, int r2, View r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        r0.applyGuideCardListItemMetrics(r1, r2, "layout");
    }

    private static final void configureGuideFeatureItem$lambda$21(AutoMemoryTaskFragment r1, OCardListItem r2, int r3) {
        r1.applyGuideCardListItemMetrics(r2, r3, CozeCloudExt.API_KEY_HTTP_POST_METHOD);
    }

    private final void configureTitleBarEndActions(final boolean r8) {
        if (Intrinsics.areEqual(this.titleBarActionsForGuide, Boolean.valueOf(r8)) == false) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (this.titleBarActionsForGuide == null) goto L8;
        boolean r0 = true;
    L9:
        this.titleBarActionsForGuide = Boolean.valueOf(r8);
        FragmentActivity r3 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, MemoryListActivity.class) == false) goto L12;
        MemoryListActivity r4 = (MemoryListActivity) ZeusTransformUtils.preCheckCast(r3, MemoryListActivity.class, "com.obric.memorydata.plugin");
    L13:
        OFloatingTitleBar r5 = getBinding().titleBar;
        if (r0 == false) goto L22;
        if (r4 == null) goto L19;
        OFloatingTitleBar r6 = getBinding().titleBar;
        Intrinsics.checkNotNullExpressionValue(r6, "titleBar");
        if (r4.handles(r6) != true) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == true) goto L22;
    L23:
        r5.a(r1, new $$Lambda$AutoMemoryTaskFragment$RDU6QNpS9VFMWDkq5ZwosFHmRHY(r8, this));
        if (r4 == null) goto L26;
        OFloatingTitleBar r2 = getBinding().titleBar;
        Intrinsics.checkNotNullExpressionValue(r2, "titleBar");
        r4.syncCurrentFloatingTitleBar(r2, r0);
    L26:
        getBinding().titleBar.post(new $$Lambda$AutoMemoryTaskFragment$jdC8MMRHXev1vgh4araTrUs2a4M(this, r8));
        return;
    L19:
        r7 = false;
    L22:
        r1 = false;
        goto L23
    L12:
        r4 = null;
        goto L13
    L8:
        r0 = false;
        goto L9
    }

    private static final Unit configureTitleBarEndActions$lambda$54(boolean r8, final AutoMemoryTaskFragment r9, OFloatingTitleBar r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$batchSet");
        OFloatingTitleBar.c(r10, false, 1, null);
        if (r8 == true) goto L5;
        OFloatingTitleBar.b(r10, ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_search, "drawable", "ic_memory_list_search"), 0, new $$Lambda$AutoMemoryTaskFragment$fe7O8mCWYADxHsB9gEFvCj3ibEs(r9), 2, null);
    L5:
        OFloatingTitleBar.b(r10, ZeusTransformUtils.mapRes(R.drawable.ic_memory_detail_operation, "drawable", "ic_memory_detail_operation"), 0, new $$Lambda$AutoMemoryTaskFragment$tZfDGoK0NcIN24G2UaocJ8OY(r9), 2, null);
        return Unit.INSTANCE;
    }

    private static final void configureTitleBarEndActions$lambda$54$lambda$52(AutoMemoryTaskFragment r2, View r3) {
        MemorySearchActivity.a r4 = MemorySearchActivity.Companion;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "requireContext(...)");
        r4.a(r5);
    }

    private static final void configureTitleBarEndActions$lambda$54$lambda$53(AutoMemoryTaskFragment r2, View r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        Activity r5 = (Activity) ZeusTransformUtils.preCheckCast(r4, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r3);
        r.a(r5, r3);
    }

    private static final void configureTitleBarEndActions$lambda$55(AutoMemoryTaskFragment r2, boolean r3) {
        r2.dumpHeaderDiag("configureTitleBarEndActions(showGuide=" + r3 + ')');
    }

    private final void dismissCollectionOperationMenus() {
        List<Fragment> r4 = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(r4, "getFragments(...)");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r2 = r6.next();
        if (ZeusTransformUtils.instanceOf(r2, AutoMemoryCollectionsFragment.class) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        ((AutoMemoryCollectionsFragment) ZeusTransformUtils.preCheckCast(r7.next(), AutoMemoryCollectionsFragment.class, "com.obric.memorydata.plugin")).dismissOperationMenu();
        goto L10
    }

    private final void dumpGuideCardDiag(String r7) {
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == true) goto L5;
        return;
    L5:
        FragmentAutoMemoryTaskBinding r0 = this._binding;
        if (r0 != null) goto L8;
        return;
    L8:
        RunLog r1 = RunLog.INSTANCE;
        StringBuilder r2 = new StringBuilder();
        StringBuilder r8 = r2.append("[AutoTaskDiag][GuideCardSpacing] reason=").append(r7).append(" density=").append(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density).append(" stableDensity=").append(getDefaultDensity()).append(" fontScale=").append(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().fontScale).append(" expectedCardMargin=").append(guideDefaultDp(12)).append("px guideContentScale=").append(r0.guideContent.getScaleX()).append(',').append(r0.guideContent.getScaleY()).append(" visualExpectedMargin=").append(guideDefaultDp(12) * r0.guideContent.getScaleX()).append("px featureList=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.guideFeatureList, View.class, "com.obric.memorydata.plugin"))).append(" custom=");
        OCardListItem r3 = r0.guideFeatureCustom;
        Intrinsics.checkNotNullExpressionValue(r3, "guideFeatureCustom");
        StringBuilder r9 = r8.append(guideItemDiag(r3)).append(" auto=");
        OCardListItem r4 = r0.guideFeatureAuto;
        Intrinsics.checkNotNullExpressionValue(r4, "guideFeatureAuto");
        r9.append(guideItemDiag(r4)).append(" qa=");
        OCardListItem r10 = r0.guideFeatureQa;
        Intrinsics.checkNotNullExpressionValue(r10, "guideFeatureQa");
        r2.append(guideItemDiag(r10));
        r1.debug(TAG, r2.toString());
    }

    private final void dumpGuideDiag(String r7) {
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == true) goto L5;
        return;
    L5:
        FragmentAutoMemoryTaskBinding r0 = this._binding;
        if (r0 != null) goto L8;
        return;
    L8:
        RunLog r1 = RunLog.INSTANCE;
        StringBuilder r2 = new StringBuilder();
        r2.append("[AutoTaskDiag] guideDump[").append(r7).append("] pageState=").append(this.pageState).append(" selectedBottom=").append((String) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectBottomTab().c(), String.class, "com.obric.memorydata.plugin")).append(" root=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.getRoot(), View.class, "com.obric.memorydata.plugin"))).append(" content=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.contentContainer, View.class, "com.obric.memorydata.plugin"))).append(" guideBg=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.guideBackground, View.class, "com.obric.memorydata.plugin"))).append(" guide=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.guideContainer, View.class, "com.obric.memorydata.plugin"))).append(" guideScroll=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.guideScroll, View.class, "com.obric.memorydata.plugin"))).append(" guideContent=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.guideContent, View.class, "com.obric.memorydata.plugin"))).append(" guideImage=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.guideImage, View.class, "com.obric.memorydata.plugin"))).append(" guideTitle=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.guideTitle, View.class, "com.obric.memorydata.plugin"))).append(" guideSubtitle=");
        StringBuilder r8 = r2.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.guideSubtitle, View.class, "com.obric.memorydata.plugin"))).append(" guideFeatureList=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.guideFeatureList, View.class, "com.obric.memorydata.plugin"))).append(" guideFeatureCustom=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.guideFeatureCustom, View.class, "com.obric.memorydata.plugin"))).append(" guideFeatureAuto=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.guideFeatureAuto, View.class, "com.obric.memorydata.plugin"))).append(" guideFeatureQa=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.guideFeatureQa, View.class, "com.obric.memorydata.plugin"))).append(" guideFeatureCustomDetail=");
        OCardListItem r3 = r0.guideFeatureCustom;
        Intrinsics.checkNotNullExpressionValue(r3, "guideFeatureCustom");
        StringBuilder r9 = r8.append(guideItemDiag(r3)).append(" guideFeatureAutoDetail=");
        OCardListItem r4 = r0.guideFeatureAuto;
        Intrinsics.checkNotNullExpressionValue(r4, "guideFeatureAuto");
        StringBuilder r10 = r9.append(guideItemDiag(r4)).append(" guideFeatureQaDetail=");
        OCardListItem r5 = r0.guideFeatureQa;
        Intrinsics.checkNotNullExpressionValue(r5, "guideFeatureQa");
        r10.append(guideItemDiag(r5)).append(" guideAction=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.guideActionBar, View.class, "com.obric.memorydata.plugin"))).append(" guideButton=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.guideStartButton, View.class, "com.obric.memorydata.plugin"))).append(" taskMask=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.taskTitleTabMask, View.class, "com.obric.memorydata.plugin"))).append(" taskTabs=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.taskTabContainer, View.class, "com.obric.memorydata.plugin")));
        r2.append(" pager=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.memoryTabContainer, View.class, "com.obric.memorydata.plugin"))).append(" overlay=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.taskLoadingOverlay, View.class, "com.obric.memorydata.plugin"))).append(' ').append(parentBottomControlsDiag());
        r1.debug(TAG, r2.toString());
    }

    private final void dumpHeaderDiag(String r9) {
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == true) goto L5;
        return;
    L5:
        FragmentAutoMemoryTaskBinding r0 = this._binding;
        if (r0 != null) goto L8;
        return;
    L8:
        RunLog r1 = RunLog.INSTANCE;
        StringBuilder r2 = new StringBuilder();
        r2.append("[AutoTaskDiag][HeaderCoordDiag][Task] headerDump[").append(r9).append("] pageState=").append(this.pageState).append(" statusTop=").append(com.obric.memorydata.memory.ui.b.f10769a.a()).append(" titleBarTotalHeight=").append(this.titleBarTotalHeight).append(" taskTabTopMargin=").append(getTaskTabTopMarginInMask()).append(" collectionTopPadding=").append(getCollectionListTopPadding()).append(" root=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.getRoot(), View.class, "com.obric.memorydata.plugin"))).append(" titleBarMask=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.taskTitleBarMask, View.class, "com.obric.memorydata.plugin"))).append(" titleBar=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.titleBar, View.class, "com.obric.memorydata.plugin"))).append(" titleBarInner=").append(viewDiag(r0.titleBar.findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, OaidModel.KEY_ID, "title_bar_container")))).append(" titleStart=").append(viewDiag(r0.titleBar.findViewById(ZeusTransformUtils.mapRes(R.id.start_title_container, OaidModel.KEY_ID, "start_title_container")))).append(" taskMask=");
        r2.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.taskTitleTabMask, View.class, "com.obric.memorydata.plugin"))).append(" taskTabs=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.taskTabContainer, View.class, "com.obric.memorydata.plugin"))).append(" pager=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.memoryTabContainer, View.class, "com.obric.memorydata.plugin"))).append(" content=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(r0.contentContainer, View.class, "com.obric.memorydata.plugin"))).append(" parent=").append(parentBottomControlsDiag());
        r1.debug(TAG, r2.toString());
    }

    private final FragmentAutoMemoryTaskBinding getBinding() {
        FragmentAutoMemoryTaskBinding r1 = this._binding;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final int getBottomTabVisibleHeight() {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L21;
        View r5 = r4.findViewById(ZeusTransformUtils.mapRes(R.id.memory_container_tab_view, OaidModel.KEY_ID, "memory_container_tab_view"));
        if (r5 == null) goto L22;
        boolean r2 = true;
        if (r5.getVisibility() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
    L14:
        r2 = false;
    L15:
        if (r2 == true) goto L18;
        r5 = null;
    L18:
        if (r5 != null) goto L20;
        return 0;
    L20:
        return r5.getHeight();
    L12:
        if (r5.getHeight() <= 0) goto L14;
    L9:
        r1 = false;
        goto L10
    L22:
        return 0;
    L21:
        return 0;
    }

    private final float getDefaultDensity() {
        return getGuideBaselineDensityDpi() / 160.0f;
    }

    private final int getGuideBaselineDensityDpi() {
        return MathKt.roundToInt(((Math.min(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels, ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().heightPixels) * 560.0f) / GUIDE_BASELINE_SHORT_SIDE_PX) / 10) * 10;
    }

    private final MemoryListShareViewModel getShareViewModel() {
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(this.shareViewModel$delegate.getValue(), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    private final String getTabTitle(AutoMemoryTab r4) {
        int r5 = b.f10599a[r4.ordinal()];
        if (r5 != 1) goto L5;
        int r6 = R.string.memory_task_my_tasks;
        String r0 = "memory_task_my_tasks";
    L10:
        String r3 = getString(ZeusTransformUtils.mapRes(r6, TypedValues.Custom.S_STRING, r0));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        return r3;
    L5:
        if (r5 != 2) goto L8;
        r6 = R.string.memory_discover;
        r0 = "memory_discover";
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private final int getTaskTabTopMarginInMask() {
        return this.titleBarTotalHeight + MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
    }

    private final AutoMemoryViewModel getViewModel() {
        return (AutoMemoryViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), AutoMemoryViewModel.class, "com.obric.memorydata.plugin");
    }

    private final int guideDefaultDp(int r1) {
        return MathKt.roundToInt(r1 * getDefaultDensity());
    }

    private final String guideItemDiag(OCardListItem r10) {
        FrameLayout r0 = r10.getCardContainer();
        OUICardConstraintLayout r1 = r10.getContentContainer();
        OTextView r2 = r10.getTitleView();
        OTextView r3 = r10.getSubTitleView();
        CharSequence r4 = r2.getText();
        String r5 = null;
        if (r4 == null) goto L5;
        String r6 = r4.toString();
    L6:
        String r7 = "";
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        CharSequence r8 = r3.getText();
        if (r8 == null) goto L12;
        r5 = r8.toString();
    L12:
        if (r5 == null) goto L16;
        r7 = r5;
    L16:
        return "item=" + viewDiag((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin")) + " card=" + viewDiag((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin")) + " content=" + viewDiag((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin")) + " title=" + viewDiag((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin")) + " titleVisible=" + visibilityName(r2.getVisibility()) + " titleText='" + StringsKt.take(r6, 16) + "' titleTextSizePx=" + r2.getTextSize() + " subtitle=" + viewDiag((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")) + " subtitleVisible=" + visibilityName(r3.getVisibility()) + " subtitleText='" + StringsKt.take(r7, 20) + "' subtitleTextSizePx=" + r3.getTextSize();
    L5:
        r6 = null;
        goto L6
    }

    private final void handleCreateCollectionClick() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final boolean isBottomTabAvailable(MemoryContainerTab r6) {
        FragmentActivity r5 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        MemoryTabContainerAdapter r1 = null;
        if (r5 == null) goto L7;
        androidx.viewpager2.widget.ViewPager2 r7 = (androidx.viewpager2.widget.ViewPager2) ZeusTransformUtils.preCheckCast(r5.findViewById(ZeusTransformUtils.mapRes(R.id.memory_tab_container, OaidModel.KEY_ID, "memory_tab_container")), androidx.viewpager2.widget.ViewPager2.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L7;
        RecyclerView.Adapter r8 = r7.getAdapter();
    L9:
        if (ZeusTransformUtils.instanceOf(r8, MemoryTabContainerAdapter.class) == false) goto L11;
        r1 = (MemoryTabContainerAdapter) ZeusTransformUtils.preCheckCast(r8, MemoryTabContainerAdapter.class, "com.obric.memorydata.plugin");
    L11:
        if (r1 == null) goto L14;
        return r1.hasFragment(r6);
    L14:
        if (r6 != MemoryContainerTab.GLOBAL_MEMORY) goto L16;
        return true;
    L16:
        return false;
    L7:
        r8 = null;
        goto L9
    }

    /* JADX INFO: renamed from: lambda$-tZfDGoK0NcIN-24G2UaocJ8-OY, reason: not valid java name */
    public static /* synthetic */ void m780lambda$tZfDGoK0NcIN24G2UaocJ8OY(AutoMemoryTaskFragment r0, View r1) {
        configureTitleBarEndActions$lambda$54$lambda$53(r0, r1);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$09ykil2SbF_boRcjSx1O8cCvGls(AutoMemoryTaskFragment r0, View r1, WindowInsetsCompat r2) {
        return setupStatusBarInset$lambda$11(r0, r1, r2);
    }

    public static /* synthetic */ MemoryListShareViewModel lambda$6YFTrdJa7yWqk2EIEIGLYHkQdG8(AutoMemoryTaskFragment r0) {
        return shareViewModel_delegate$lambda$1(r0);
    }

    public static /* synthetic */ void lambda$8zAXyFF8SyYu7fEHD3P8V4Ya4Vc(AutoMemoryTaskFragment r0) {
        setupGuideBottomSpacing$lambda$34(r0);
    }

    public static /* synthetic */ void lambda$Cuu1dBHfEdZPS7sRuVftyiNrm7M(AutoMemoryTaskFragment r0) {
        updateTaskContentVisibility$lambda$47(r0);
    }

    public static /* synthetic */ Unit lambda$E1agnfPWmdibGb8GCo46g6TryME(AutoMemoryTaskFragment r0) {
        return updateTaskHeaderLayout$lambda$14(r0);
    }

    public static /* synthetic */ void lambda$GCBTYZFKPeFqPcJTdS5qERz910c(AutoMemoryTaskFragment r0) {
        switchPage$lambda$45(r0);
    }

    /* JADX INFO: renamed from: lambda$GdY9plrLkiAJy_-VR13o_Gde9VU, reason: not valid java name */
    public static /* synthetic */ void m781lambda$GdY9plrLkiAJy_VR13o_Gde9VU(AutoMemoryTaskFragment r0, View r1) {
        setupFloatingAddButton$lambda$38(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$HtbOCGxTZdUEEEO3XWMNXTU-hbc, reason: not valid java name */
    public static /* synthetic */ AutoMemoryViewModel m782lambda$HtbOCGxTZdUEEEO3XWMNXTUhbc(AutoMemoryTaskFragment r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$Iz_LKbngRMnPHCniM_3ZFRa7WJc(AutoMemoryTaskFragment r0) {
        onStart$lambda$5(r0);
    }

    /* JADX INFO: renamed from: lambda$Obettk3h1m6Ra5-THFU8VWNbg84, reason: not valid java name */
    public static /* synthetic */ void m783lambda$Obettk3h1m6Ra5THFU8VWNbg84(AutoMemoryTaskFragment r0, OCardListItem r1, int r2, View r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        configureGuideFeatureItem$lambda$20(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ void lambda$R6UBlSThqlm7cENQTfFjpLJ7qQE(ONestedScrollView r0) {
        setupGuide$lambda$17(r0);
    }

    public static /* synthetic */ Unit lambda$RDU6QNpS9VFMWDkq5ZwosFHmRHY(boolean r0, AutoMemoryTaskFragment r1, OFloatingTitleBar r2) {
        return configureTitleBarEndActions$lambda$54(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$T3vYb-tAAYm9PH7_Qybnui3h9To, reason: not valid java name */
    public static /* synthetic */ void m784lambda$T3vYbtAAYm9PH7_Qybnui3h9To(AutoMemoryTaskFragment r0) {
        updateTaskContentVisibility$lambda$49(r0);
    }

    /* JADX INFO: renamed from: lambda$YktM_L-U-2HVB0siVgfW4ovNRUg, reason: not valid java name */
    public static /* synthetic */ void m785lambda$YktM_LU2HVB0siVgfW4ovNRUg(AutoMemoryTaskFragment r0, float r1, float r2, float r3) {
        applyGuideBaselineLayout$lambda$31(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$aweMK7emXHAorhS5gZxSj_iGZxg(AutoMemoryTaskFragment r0, View r1) {
        setupGuide$lambda$18(r0, r1);
    }

    public static /* synthetic */ void lambda$brDuIsg0eRT0ZIweJDDoSwZ7bx4(AutoMemoryTaskFragment r0) {
        onViewCreated$lambda$3(r0);
    }

    public static /* synthetic */ Unit lambda$eC_UZXP4qkNCDd9pyu7lmREUrCg(AutoMemoryTaskFragment r0, int r1) {
        return setupTitleBar$lambda$8(r0, r1);
    }

    public static /* synthetic */ void lambda$fe7O8mCWYADxHsB9gEFvCj3ibEs(AutoMemoryTaskFragment r0, View r1) {
        configureTitleBarEndActions$lambda$54$lambda$52(r0, r1);
    }

    public static /* synthetic */ void lambda$jdC8MMRHXev1vgh4araTrUs2a4M(AutoMemoryTaskFragment r0, boolean r1) {
        configureTitleBarEndActions$lambda$55(r0, r1);
    }

    public static /* synthetic */ void lambda$uZiUQWbFLgaV6Y6kFy21r51Mgoc(AutoMemoryTaskFragment r0, OCardListItem r1, int r2) {
        configureGuideFeatureItem$lambda$21(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$ybRnUlG43DJM_qrS5GnssBd5lMI(AutoMemoryTaskFragment r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        setupGuideBottomSpacing$lambda$33(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: lambda$z-mUqP4HkV8o4LEZi0Z7rTJ2zzQ, reason: not valid java name */
    public static /* synthetic */ void m786lambda$zmUqP4HkV8o4LEZi0Z7rTJ2zzQ(AutoMemoryTaskFragment r0) {
        onViewCreated$lambda$4(r0);
    }

    private final void normalizeGuideTextSize(View r6, float r7) {
        int r1 = 0;
        if (ZeusTransformUtils.instanceOf(r6, TextView.class) == false) goto L6;
        ((TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.memorydata.plugin")).setTextSize(0, ((TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.memorydata.plugin")).getTextSize() / r7);
    L6:
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L10;
        int r0 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
    L8:
        if (r1 >= r0) goto L12;
        View r3 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(r1);
        Intrinsics.checkNotNullExpressionValue(r3, "getChildAt(...)");
        normalizeGuideTextSize(r3, r7);
        r1 = r1 + 1;
        goto L8
    L12:
        return;
    }

    private final void observeState() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11221(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        LifecycleOwner r1 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r1, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r1), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        LifecycleOwner r2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r2, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r2), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final void onStart$lambda$5(AutoMemoryTaskFragment r0) {
        r0.checkUpdatingIfCurrentMemoryTaskTab();
    }

    private static final void onViewCreated$lambda$3(AutoMemoryTaskFragment r1) {
        r1.dumpGuideDiag("onViewCreated.post");
    }

    private static final void onViewCreated$lambda$4(AutoMemoryTaskFragment r0) {
        r0.checkUpdatingIfCurrentMemoryTaskTab();
    }

    private final String parentBottomControlsDiag() {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        View r3 = null;
        if (r0 == null) goto L5;
        View r1 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.memory_container_tab_view, OaidModel.KEY_ID, "memory_container_tab_view"));
    L6:
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L10;
        r3 = r2.findViewById(ZeusTransformUtils.mapRes(R.id.cut_off_bottom, OaidModel.KEY_ID, "cut_off_bottom"));
    L10:
        return "bottomTab=" + viewDiag(r1) + " cutOff=" + viewDiag(r3);
    L5:
        r1 = null;
        goto L6
    }

    private final void setupFloatingAddButton() {
        getBinding().taskAddButton.setOnClickListener(new $$Lambda$AutoMemoryTaskFragment$GdY9plrLkiAJy_VR13o_Gde9VU(this));
    }

    private static final void setupFloatingAddButton$lambda$38(AutoMemoryTaskFragment r0, View r1) {
        r0.handleCreateCollectionClick();
    }

    private final void setupGuide() {
        setupGuideFeatureItems();
        applyGuideBaselineLayout();
        final ONestedScrollView r0 = getBinding().guideScroll;
        Intrinsics.checkNotNullExpressionValue(r0, "guideScroll");
        r0.post(new $$Lambda$AutoMemoryTaskFragment$R6UBlSThqlm7cENQTfFjpLJ7qQE(r0));
        getBinding().guideStartButton.setOnClickListener(new $$Lambda$AutoMemoryTaskFragment$aweMK7emXHAorhS5gZxSj_iGZxg(this));
    }

    private static final void setupGuide$lambda$17(ONestedScrollView r1) {
        r1.scrollTo(0, 0);
    }

    private static final void setupGuide$lambda$18(AutoMemoryTaskFragment r0, View r1) {
        s.f10718a.b();
        r0.switchPage(PageState.CONTENT);
        r0.checkUpdatingIfCurrentMemoryTaskTab();
    }

    private final void setupGuideBottomSpacing() {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        View r1 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.memory_container_tab_view, OaidModel.KEY_ID, "memory_container_tab_view"));
    L6:
        View.OnLayoutChangeListener r2 = new $$Lambda$AutoMemoryTaskFragment$ybRnUlG43DJM_qrS5GnssBd5lMI(this);
        this.bottomTabLayoutListener = r2;
        if (r1 == null) goto L9;
        r1.addOnLayoutChangeListener(r2);
    L9:
        getBinding().getRoot().post(new $$Lambda$AutoMemoryTaskFragment$8zAXyFF8SyYu7fEHD3P8V4Ya4Vc(this));
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final void setupGuideBottomSpacing$lambda$33(AutoMemoryTaskFragment r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r0.updateBottomAnchoredControls();
    }

    private static final void setupGuideBottomSpacing$lambda$34(AutoMemoryTaskFragment r0) {
        r0.updateBottomAnchoredControls();
    }

    private final void setupGuideFeatureItems() {
        OCardListItem r2 = getBinding().guideFeatureCustom;
        Intrinsics.checkNotNullExpressionValue(r2, "guideFeatureCustom");
        int r4 = ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_guide_custom, "drawable", "ic_auto_memory_task_guide_custom");
        String r5 = getString(ZeusTransformUtils.mapRes(R.string.memory_task_guide_custom_title, TypedValues.Custom.S_STRING, "memory_task_guide_custom_title"));
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        String r6 = getString(ZeusTransformUtils.mapRes(R.string.memory_task_guide_custom_subtitle, TypedValues.Custom.S_STRING, "memory_task_guide_custom_subtitle"));
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
        configureGuideFeatureItem(r2, 1, r4, r5, r6);
        OCardListItem r10 = getBinding().guideFeatureAuto;
        Intrinsics.checkNotNullExpressionValue(r10, "guideFeatureAuto");
        int r12 = ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_guide_auto, "drawable", "ic_auto_memory_task_guide_auto");
        String r13 = getString(ZeusTransformUtils.mapRes(R.string.memory_task_guide_auto_title, TypedValues.Custom.S_STRING, "memory_task_guide_auto_title"));
        Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");
        String r14 = getString(ZeusTransformUtils.mapRes(R.string.memory_task_guide_auto_subtitle, TypedValues.Custom.S_STRING, "memory_task_guide_auto_subtitle"));
        Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");
        configureGuideFeatureItem(r10, 2, r12, r13, r14);
        OCardListItem r11 = getBinding().guideFeatureQa;
        Intrinsics.checkNotNullExpressionValue(r11, "guideFeatureQa");
        int r15 = ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_guide_qa, "drawable", "ic_auto_memory_task_guide_qa");
        String r16 = getString(ZeusTransformUtils.mapRes(R.string.memory_task_guide_qa_title, TypedValues.Custom.S_STRING, "memory_task_guide_qa_title"));
        Intrinsics.checkNotNullExpressionValue(r16, "getString(...)");
        String r17 = getString(ZeusTransformUtils.mapRes(R.string.memory_task_guide_qa_subtitle, TypedValues.Custom.S_STRING, "memory_task_guide_qa_subtitle"));
        Intrinsics.checkNotNullExpressionValue(r17, "getString(...)");
        configureGuideFeatureItem(r11, 3, r15, r16, r17);
    }

    private final void setupLoadingBackHandler() {
        OnBackPressedCallback r0 = new AutoMemoryTaskFragment$setupLoadingBackHandler$callback$1(this);
        this.loadingBackCallback = (OnBackPressedCallback) ZeusTransformUtils.preCheckCast(r0, OnBackPressedCallback.class, "com.obric.memorydata.plugin");
        ((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")).getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), (OnBackPressedCallback) ZeusTransformUtils.preCheckCast(r0, OnBackPressedCallback.class, "com.obric.memorydata.plugin"));
    }

    private final void setupLoadingStatus() {
        int r0 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1"));
        int r1 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_line_2, TypedValues.Custom.S_COLOR, "oui_basic_line_2"));
        ODownloadProgressView r5 = getBinding().taskLoadingProgress;
        r5.setProgressColor(r0);
        r5.setProgressBackgroundColor(r1);
        r5.setProcessingColor(r0);
        r5.setActionColor(r0);
        r5.setCurrentState(0);
    }

    private final void setupStatusBarInset() {
        int r0 = com.obric.memorydata.memory.ui.b.f10769a.a();
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L5;
        RunLog.INSTANCE.debug(TAG, "[AutoTaskDiag] setupStatusBarInset cachedTop=" + r0);
    L5:
        if (r0 <= 0) goto L7;
        applyStatusBarTop(r0);
    L7:
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(getBinding().getRoot(), View.class, "com.obric.memorydata.plugin"), new $$Lambda$AutoMemoryTaskFragment$09ykil2SbF_boRcjSx1O8cCvGls(this));
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(getBinding().getRoot(), View.class, "com.obric.memorydata.plugin"));
    }

    private static final WindowInsetsCompat setupStatusBarInset$lambda$11(AutoMemoryTaskFragment r3, View r4, WindowInsetsCompat r5) {
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        Intrinsics.checkNotNullParameter(r5, "insets");
        int r6 = r5.getInsets(WindowInsetsCompat.Type.statusBars()).top;
        com.obric.memorydata.memory.ui.b.f10769a.a(r6);
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L5;
        RunLog.INSTANCE.debug(TAG, "[AutoTaskDiag] onApplyWindowInsets statusTop=" + r6);
    L5:
        r3.applyStatusBarTop(r6);
        return r5;
    }

    private final void setupTaskTabs() {
        AutoMemoryTaskTabLayout r0 = getBinding().taskTabContainer;
        float r1 = 4;
        r0.a(MathKt.roundToInt(TypedValue.applyDimension(1, r1, Resources.getSystem().getDisplayMetrics())), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r1, Resources.getSystem().getDisplayMetrics())), 0);
        r0.c();
        r0.d();
        AutoMemoryTab[] r2 = AutoMemoryTab.values();
        int r3 = r2.length;
        int r5 = 0;
    L4:
        if (r5 >= r3) goto L10;
        AutoMemoryTab r7 = r2[r5];
        OTabLayoutBase.g r8 = r0.a(0).a((CharSequence) ZeusTransformUtils.preCheckCast(getTabTitle(r7), CharSequence.class, "com.obric.memorydata.plugin"));
        if (r7 != ((u) ZeusTransformUtils.preCheckCast(getViewModel().getState().c(), u.class, "com.obric.memorydata.plugin")).a()) goto L8;
        boolean r6 = true;
    L9:
        r0.a(r8, r6);
        r5 = r5 + 1;
        goto L4
    L8:
        r6 = false;
        goto L9
    L10:
        r0.a((OTabLayoutBase.c) ZeusTransformUtils.preCheckCast(new c(this), OTabLayoutBase.c.class, "com.obric.memorydata.plugin"));
    }

    private final void setupTitleBar() {
        OFloatingTitleBar r0 = getBinding().titleBar;
        r0.setStartTitle(getString(ZeusTransformUtils.mapRes(R.string.memory_task, TypedValues.Custom.S_STRING, "memory_task")));
        Intrinsics.checkNotNull(r0);
        com.obric.memorydata.ui.custom.a.a(r0);
        r0.setMaskBlurRadius(0.0f);
        configureTitleBarEndActions(true);
        dumpHeaderDiag("setupTitleBar.afterApply");
        if (com.obric.memorydata.memory.ui.b.f10769a.a() <= 0) goto L5;
        getBinding().titleBar.a(com.obric.memorydata.memory.ui.b.f10769a.a());
        dumpHeaderDiag("setupTitleBar.afterCachedInset");
    L5:
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, BaseActivity.class) == false) goto L8;
        BaseActivity r2 = (BaseActivity) ZeusTransformUtils.preCheckCast(r1, BaseActivity.class, "com.obric.memorydata.plugin");
    L9:
        if (r2 == null) goto L11;
        r2.getTitleBarTotalHeightAsync((View) ZeusTransformUtils.preCheckCast(getBinding().titleBar, View.class, "com.obric.memorydata.plugin"), new $$Lambda$AutoMemoryTaskFragment$eC_UZXP4qkNCDd9pyu7lmREUrCg(this));
    L11:
        updateTaskHeaderLayout();
        return;
    L8:
        r2 = null;
        goto L9
    }

    private static final Unit setupTitleBar$lambda$8(AutoMemoryTaskFragment r1, int r2) {
        if (r1._binding == null) goto L5;
        r1.titleBarTotalHeight = r2;
        r1.dumpHeaderDiag("setupTitleBar.asyncHeight");
        r1.updateTaskHeaderLayout();
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private final void setupViewPager() {
        getBinding().memoryTabContainer.setAdapter((com.obric.oui.orecyclerview.widget.RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(new p((Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.memorydata.plugin")), com.obric.oui.orecyclerview.widget.RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        getBinding().memoryTabContainer.setOffscreenPageLimit(1);
        getBinding().memoryTabContainer.setUserInputEnabled(true);
        ViewPager2.e r0 = (ViewPager2.e) ZeusTransformUtils.preCheckCast(new d(this), ViewPager2.e.class, "com.obric.memorydata.plugin");
        this.pageChangeCallback = r0;
        if (r0 == null) goto L5;
        getBinding().memoryTabContainer.a(r0);
    L5:
        getBinding().memoryTabContainer.a(((u) ZeusTransformUtils.preCheckCast(getViewModel().getState().c(), u.class, "com.obric.memorydata.plugin")).a().ordinal(), false);
    }

    private static final MemoryListShareViewModel shareViewModel_delegate$lambda$1(AutoMemoryTaskFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(MemoryListShareViewModel.class), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void switchBottomTab(MemoryContainerTab r7) {
        FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L39;
        androidx.viewpager2.widget.ViewPager2 r8 = (androidx.viewpager2.widget.ViewPager2) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.memory_tab_container, OaidModel.KEY_ID, "memory_tab_container")), androidx.viewpager2.widget.ViewPager2.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L40;
        RecyclerView.Adapter r1 = r8.getAdapter();
        Integer r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, MemoryTabContainerAdapter.class) == false) goto L10;
        MemoryTabContainerAdapter r2 = (MemoryTabContainerAdapter) ZeusTransformUtils.preCheckCast(r1, MemoryTabContainerAdapter.class, "com.obric.memorydata.plugin");
    L11:
        boolean r4 = true;
        if (r2 != null) goto L14;
    L27:
        if (r2 == null) goto L34;
        Integer r9 = Integer.valueOf(r2.getTabPosition(MemoryContainerTab.GLOBAL_MEMORY));
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue() >= 0) goto L32;
        r4 = false;
    L32:
        if (r4 == false) goto L34;
        r3 = r9;
    L34:
        if (r3 == null) goto L36;
        int r10 = r3.intValue();
    L37:
        r8.setCurrentItem(r10, false);
        return;
    L36:
        r10 = 0;
        goto L37
    L14:
        if (r2.hasFragment(r7) == false) goto L16;
        MemoryTabContainerAdapter r5 = r2;
    L17:
        if (r5 == null) goto L27;
        Integer r11 = Integer.valueOf(r5.getTabPosition(r7));
        if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L21;
        boolean r12 = true;
    L22:
        if (r12 == true) goto L25;
        r11 = null;
    L25:
        if (r11 == null) goto L27;
        r10 = r11.intValue();
        goto L37
    L21:
        r12 = false;
        goto L22
    L16:
        r5 = null;
        goto L17
    L10:
        r2 = null;
        goto L11
    L40:
        return;
    }

    private final void switchPage(PageState r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "switchPage: " + r10, false, 4, null);
        this.pageState = r10;
        int r1 = 0;
        if (r10 != PageState.GUIDE) goto L5;
        boolean r11 = true;
    L6:
        configureTitleBarEndActions(r11);
        dumpGuideDiag("switchPage.before");
        ImageView r0 = getBinding().guideBackground;
        Intrinsics.checkNotNullExpressionValue(r0, "guideBackground");
        View r2 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
        if (r11 == false) goto L9;
        int r4 = 0;
    L10:
        r2.setVisibility(r4);
        ConstraintLayout r3 = getBinding().guideContainer;
        Intrinsics.checkNotNullExpressionValue(r3, "guideContainer");
        View r5 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");
        if (r11 == true) goto L14;
        r1 = 8;
    L14:
        r5.setVisibility(r1);
        updateTaskContentVisibility((u) ZeusTransformUtils.preCheckCast(getViewModel().getState().c(), u.class, "com.obric.memorydata.plugin"));
        dumpGuideDiag("switchPage.after");
        getBinding().getRoot().post(new $$Lambda$AutoMemoryTaskFragment$GCBTYZFKPeFqPcJTdS5qERz910c(this));
        return;
    L9:
        r4 = 8;
        goto L10
    L5:
        r11 = false;
        goto L6
    }

    private static final void switchPage$lambda$45(AutoMemoryTaskFragment r1) {
        r1.dumpGuideDiag("switchPage.post");
    }

    private final void updateBottomAnchoredControls() {
        updateGuideBottomSpacing();
        updateFloatingAddButtonBottomMargin();
    }

    private final void updateCollectionListTopPadding() {
        List<Fragment> r4 = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(r4, "getFragments(...)");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r2 = r6.next();
        if (ZeusTransformUtils.instanceOf(r2, AutoMemoryCollectionsFragment.class) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        ((AutoMemoryCollectionsFragment) ZeusTransformUtils.preCheckCast(r7.next(), AutoMemoryCollectionsFragment.class, "com.obric.memorydata.plugin")).updateContentTopPadding();
        goto L10
    }

    private final void updateFloatingAddButtonBottomMargin() {
        FragmentAutoMemoryTaskBinding r0 = this._binding;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r1 = r0.taskAddButton.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r1, FrameLayout.LayoutParams.class) == false) goto L8;
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        int r6 = getBottomTabVisibleHeight();
        if (r6 > 0) goto L15;
        r6 = BaseActivity.Companion.b();
    L15:
        int r7 = r6 + MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
        if (r2.bottomMargin == r7) goto L19;
        r2.bottomMargin = r7;
        r0.taskAddButton.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L19:
        return;
    L8:
        r2 = null;
        goto L9
    }

    private final void updateGuideBottomSpacing() {
        FragmentAutoMemoryTaskBinding r0 = this._binding;
        if (r0 != null) goto L5;
        return;
    L5:
        int r4 = getBottomTabVisibleHeight();
        if (r4 <= 0) goto L8;
        int r5 = r4 + MathKt.roundToInt(TypedValue.applyDimension(1, 42, Resources.getSystem().getDisplayMetrics()));
    L10:
        if (r0.guideScroll.getPaddingBottom() == r5) goto L13;
        r0.guideScroll.setPadding(r0.guideScroll.getPaddingLeft(), r0.guideScroll.getPaddingTop(), r0.guideScroll.getPaddingRight(), r5);
        return;
    L13:
        return;
    L8:
        r5 = BaseActivity.Companion.b();
        goto L10
    }

    private final void updateParentBottomControlsForLoading(boolean r6) {
        if (Intrinsics.areEqual(getShareViewModel().getSelectBottomTab().c(), MemoryContainerTab.AUTO_MEMORY_TASK.getText()) == true) goto L6;
        return;
    L6:
        if (r6 == false) goto L8;
    L10:
        boolean r1 = false;
    L11:
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, MemoryListActivity.class) == false) goto L14;
        MemoryListActivity r3 = (MemoryListActivity) ZeusTransformUtils.preCheckCast(r2, MemoryListActivity.class, "com.obric.memorydata.plugin");
    L15:
        if (r3 == null) goto L18;
        r3.setBottomControlsVisibleFromChild("AutoMemoryTask.loading=" + r6, r1);
    L18:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L21;
        RunLog.INSTANCE.debug(TAG, "[CutOffDiag][AutoTask] updateParentBottomControls showLoading=" + r6 + " selectedBottom=" + ((String) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectBottomTab().c(), String.class, "com.obric.memorydata.plugin")) + " isEdit=" + ((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() + ' ' + parentBottomControlsDiag());
        return;
    L21:
        return;
    L14:
        r3 = null;
        goto L15
    L8:
        if (((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L10;
        r1 = true;
        goto L11
    }

    private final void updateTaskContentVisibility(u r12) {
        boolean r2 = true;
        int r3 = 0;
        if (this.pageState != PageState.GUIDE) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L12:
        boolean r1 = false;
    L14:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L16;
        RunLog r4 = RunLog.INSTANCE;
        StringBuilder r7 = new StringBuilder();
        r7.append("[AutoTaskDiag] updateTaskContentVisibility pageState=").append(this.pageState).append(" selectedBottom=").append((String) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectBottomTab().c(), String.class, "com.obric.memorydata.plugin")).append(" selectedTaskTab=").append(r12.a()).append(" stateLoading=").append(r12.b()).append(" showGuide=").append(r0).append(" showLoading=").append(r1).append(" guideBgBefore=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().guideBackground, View.class, "com.obric.memorydata.plugin"))).append(" guideBefore=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().guideContainer, View.class, "com.obric.memorydata.plugin"))).append(" taskTabsBefore=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().taskTabContainer, View.class, "com.obric.memorydata.plugin"))).append(" taskMaskBefore=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().taskTitleTabMask, View.class, "com.obric.memorydata.plugin"))).append(" pagerBefore=").append(viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().memoryTabContainer, View.class, "com.obric.memorydata.plugin"))).append(" overlayBefore=");
        r7.append(viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().taskLoadingOverlay, View.class, "com.obric.memorydata.plugin")));
        r4.debug(TAG, r7.toString());
    L16:
        AutoMemoryTaskTabLayout r5 = getBinding().taskTabContainer;
        Intrinsics.checkNotNullExpressionValue(r5, "taskTabContainer");
        View r6 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin");
        if ((!r0) == false) goto L19;
        int r8 = 0;
    L20:
        r6.setVisibility(r8);
        OBlurMaskView r9 = getBinding().taskTitleTabMask;
        Intrinsics.checkNotNullExpressionValue(r9, "taskTitleTabMask");
        View r10 = (View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin");
        if ((!r0) == false) goto L23;
        int r11 = 0;
    L24:
        r10.setVisibility(r11);
        ViewPager2 r13 = getBinding().memoryTabContainer;
        Intrinsics.checkNotNullExpressionValue(r13, "memoryTabContainer");
        View r14 = (View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin");
        if (r0 == true) goto L28;
        if (r1 == true) goto L28;
        boolean r15 = true;
    L29:
        if (r15 == false) goto L31;
        int r16 = 0;
    L32:
        r14.setVisibility(r16);
        getBinding().memoryTabContainer.setUserInputEnabled(!r1);
        FrameLayout r17 = getBinding().taskLoadingOverlay;
        Intrinsics.checkNotNullExpressionValue(r17, "taskLoadingOverlay");
        View r18 = (View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin");
        if (r1 == false) goto L35;
        int r19 = 0;
    L36:
        r18.setVisibility(r19);
        OnBackPressedCallback r20 = this.loadingBackCallback;
        if (r20 == null) goto L39;
        r20.setEnabled(r1);
    L39:
        if (r1 == false) goto L41;
        getBinding().taskLoadingProgress.setCurrentState(0);
    L41:
        updateParentBottomControlsForLoading(r1);
        OFloatingActionButton r21 = getBinding().taskAddButton;
        Intrinsics.checkNotNullExpressionValue(r21, "taskAddButton");
        View r22 = (View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.memorydata.plugin");
        if (r0 == true) goto L47;
        if (r1 == true) goto L47;
        if (r12.a() != AutoMemoryTab.AUTO) goto L47;
    L48:
        if (r2 == true) goto L51;
        r3 = 8;
    L51:
        r22.setVisibility(r3);
        if (r1 == true) goto L55;
        getBinding().getRoot().post(new $$Lambda$AutoMemoryTaskFragment$Cuu1dBHfEdZPS7sRuVftyiNrm7M(this));
    L55:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L57;
        RunLog.INSTANCE.debug(TAG, "[AutoTaskDiag] updateTaskContentVisibility.after guideBg=" + viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().guideBackground, View.class, "com.obric.memorydata.plugin")) + " guide=" + viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().guideContainer, View.class, "com.obric.memorydata.plugin")) + " taskTabs=" + viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().taskTabContainer, View.class, "com.obric.memorydata.plugin")) + " taskMask=" + viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().taskTitleTabMask, View.class, "com.obric.memorydata.plugin")) + " pager=" + viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().memoryTabContainer, View.class, "com.obric.memorydata.plugin")) + " overlay=" + viewDiag((View) ZeusTransformUtils.preCheckCast(getBinding().taskLoadingOverlay, View.class, "com.obric.memorydata.plugin")));
    L57:
        getBinding().getRoot().post(new $$Lambda$AutoMemoryTaskFragment$T3vYbtAAYm9PH7_Qybnui3h9To(this));
        return;
    L47:
        r2 = false;
        goto L48
    L35:
        r19 = 8;
        goto L36
    L31:
        r16 = 8;
    L28:
        r15 = false;
        goto L29
    L23:
        r11 = 8;
        goto L24
    L19:
        r8 = 8;
        goto L20
    L8:
        if (r12.b() == false) goto L12;
        if (Intrinsics.areEqual(getShareViewModel().getSelectBottomTab().c(), MemoryContainerTab.AUTO_MEMORY_TASK.getText()) == false) goto L12;
        r1 = true;
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    private static final void updateTaskContentVisibility$lambda$47(AutoMemoryTaskFragment r0) {
        r0.updateBottomAnchoredControls();
    }

    private static final void updateTaskContentVisibility$lambda$49(AutoMemoryTaskFragment r1) {
        r1.dumpGuideDiag("updateTaskContentVisibility.post");
    }

    private final void updateTaskHeaderLayout() {
        float r1 = 8;
        int r0 = ((this.titleBarTotalHeight + MathKt.roundToInt(TypedValue.applyDimension(1, r1, Resources.getSystem().getDisplayMetrics()))) + MathKt.roundToInt(TypedValue.applyDimension(1, 40, Resources.getSystem().getDisplayMetrics()))) + MathKt.roundToInt(TypedValue.applyDimension(1, r1, Resources.getSystem().getDisplayMetrics()));
        ViewGroup.LayoutParams r2 = getBinding().taskTitleTabMask.getLayoutParams();
        ViewGroup.MarginLayoutParams r3 = null;
        if (ZeusTransformUtils.instanceOf(r2, FrameLayout.LayoutParams.class) == false) goto L5;
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 == null) goto L8;
        r4.height = r0;
        getBinding().taskTitleTabMask.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L8:
        ViewGroup.LayoutParams r5 = getBinding().taskTabContainer.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.MarginLayoutParams.class) == false) goto L11;
        r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L11:
        int r6 = getTaskTabTopMarginInMask();
        if (r3 == null) goto L15;
        r3.topMargin = r6;
        getBinding().taskTabContainer.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L15:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L17;
        RunLog.INSTANCE.debug(TAG, "[AutoTaskDiag] updateTaskHeaderLayout statusTop=" + com.obric.memorydata.memory.ui.b.f10769a.a() + " titleBarTotalHeight=" + this.titleBarTotalHeight + " maskTargetH=" + r0 + " tabTopMargin=" + r6);
    L17:
        dumpHeaderDiag("updateTaskHeaderLayout");
        updateCollectionListTopPadding();
        OBlurMaskView r7 = getBinding().taskTitleTabMask;
        Intrinsics.checkNotNullExpressionValue(r7, "taskTitleTabMask");
        safeViewPost((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), new $$Lambda$AutoMemoryTaskFragment$E1agnfPWmdibGb8GCo46g6TryME(this));
        return;
    L5:
        r4 = null;
        goto L6
    }

    private static final Unit updateTaskHeaderLayout$lambda$14(AutoMemoryTaskFragment r1) {
        r1.updateCollectionListTopPadding();
        r1.dumpHeaderDiag("updateTaskHeaderLayout.post");
        return Unit.INSTANCE;
    }

    private final void updateTopMargin(View r3, int r4) {
        ViewGroup.LayoutParams r2 = r3.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.topMargin == r4) goto L12;
        r5.topMargin = r4;
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L12:
        return;
    L5:
        r5 = null;
        goto L6
    }

    private final String viewDiag(View r10) {
        if (r10 != null) goto L5;
        return "null";
    L5:
        int[] r1 = new int[2];
        int[] r0 = new int[2];
        r10.getLocationInWindow(r1);
        r10.getLocationOnScreen(r0);
        ViewGroup.LayoutParams r2 = r10.getLayoutParams();
        String r5 = null;
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.MarginLayoutParams.class) == false) goto L8;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L10:
        if (r3 == null) goto L12;
        String r4 = " margin=" + r3.leftMargin + ',' + r3.topMargin + ',' + r3.rightMargin + ',' + r3.bottomMargin;
    L13:
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        ViewParent r6 = r10.getParent();
        if (ZeusTransformUtils.instanceOf(r6, View.class) == false) goto L18;
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin");
    L19:
        if (r7 == null) goto L26;
        Class<?> r8 = r7.getClass();
        if (r8 == null) goto L26;
        String r9 = r8.getSimpleName();
        if (r9 == null) goto L26;
        r5 = r9;
    L31:
        StringBuilder r11 = new StringBuilder();
        r11.append(r10.getClass().getSimpleName()).append("@win=").append(r1[0]).append(',').append(r1[1]).append(" screen=").append(r0[0]).append(',').append(r0[1]).append(" size=").append(r10.getWidth()).append('x').append(r10.getHeight()).append(" top=").append(r10.getTop()).append(" bottom=").append(r10.getBottom()).append(" scroll=").append(r10.getScrollX()).append(',').append(r10.getScrollY()).append(" padding=").append(r10.getPaddingLeft());
        r11.append(',').append(r10.getPaddingTop()).append(',').append(r10.getPaddingRight()).append(',').append(r10.getPaddingBottom()).append(r4).append(" visible=").append(visibilityName(r10.getVisibility())).append(" alpha=").append(r10.getAlpha()).append(" tx=").append(r10.getTranslationX()).append(" ty=").append(r10.getTranslationY()).append(" parent=").append(r5);
        return r11.toString();
    L26:
        ViewParent r12 = r10.getParent();
        if (r12 == null) goto L31;
        Class<?> r13 = r12.getClass();
        if (r13 == null) goto L31;
        r5 = r13.getSimpleName();
        goto L31
    L18:
        r7 = null;
        goto L19
    L12:
        r4 = null;
        goto L13
    L8:
        r3 = null;
        goto L10
    }

    private static final AutoMemoryViewModel viewModel_delegate$lambda$0(AutoMemoryTaskFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (AutoMemoryViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(AutoMemoryViewModel.class), AutoMemoryViewModel.class, "com.obric.memorydata.plugin");
    }

    private final String visibilityName(int r1) {
        if (r1 != 0) goto L4;
        return "VISIBLE";
    L4:
        if (r1 != 4) goto L6;
        return "INVISIBLE";
    L6:
        if (r1 != 8) goto L12;
        return "GONE";
    L12:
        return String.valueOf(r1);
    }

    public final int getCollectionListTopPadding() {
        Integer r0 = Integer.valueOf(getBinding().taskTitleTabMask.getHeight());
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        int r5 = r0.intValue();
    L14:
        return r5 + MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
    L12:
        r5 = ((this.titleBarTotalHeight + MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()))) + MathKt.roundToInt(TypedValue.applyDimension(1, 40, Resources.getSystem().getDisplayMetrics()))) + MathKt.roundToInt(TypedValue.applyDimension(1, ((Number) ZeusTransformUtils.preCheckCast(8, Number.class, "com.obric.memorydata.plugin")).floatValue(), Resources.getSystem().getDisplayMetrics()));
        goto L14
    L5:
        r1 = false;
        goto L6
    }

    public final ViewPager2 getCollectionViewPager() {
        FragmentAutoMemoryTaskBinding r0 = this._binding;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.memoryTabContainer;
    }

    @Override // com.obric.memorydata.ui.b
    public OFloatingTitleBar getCurrentFloatingTitleBar() {
        FragmentAutoMemoryTaskBinding r0 = this._binding;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.titleBar;
    }

    @Override // com.obric.memorydata.ui.b
    public OFloatingTitleBarActionHost getCurrentFloatingTitleBarActionHost() {
        return com.obric.memorydata.ui.b.a.a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        this._binding = FragmentAutoMemoryTaskBinding.inflate(r1, r2, false);
        getBinding().titleBar.setFloatingTransitionEnabled(true);
        AutoMemoryTaskRootLayout r0 = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(getBinding().getRoot(), View.class, "com.obric.memorydata.plugin"), null);
        ViewPager2.e r0 = this.pageChangeCallback;
        if (r0 == null) goto L5;
        getBinding().memoryTabContainer.b(r0);
    L5:
        this.pageChangeCallback = null;
        OnBackPressedCallback r1 = this.loadingBackCallback;
        if (r1 == null) goto L8;
        r1.setEnabled(false);
    L8:
        this.loadingBackCallback = null;
        clearGuideBottomSpacingListener();
        updateParentBottomControlsForLoading(false);
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L11;
        RunLog.INSTANCE.debug(TAG, "[CutOffDiag][AutoTask] onDestroyView parent=" + parentBottomControlsDiag());
    L11:
        this.titleBarActionsForGuide = null;
        this._binding = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getBinding().getRoot().post(new $$Lambda$AutoMemoryTaskFragment$Iz_LKbngRMnPHCniM_3ZFRa7WJc(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        getViewModel().cancelRuleUpdatingLoading();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        setupTitleBar();
        setupStatusBarInset();
        setupGuide();
        setupGuideBottomSpacing();
        setupTaskTabs();
        setupFloatingAddButton();
        setupLoadingStatus();
        setupLoadingBackHandler();
        setupViewPager();
        observeState();
        boolean r5 = s.f10718a.a();
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L5;
        RunLog.INSTANCE.debug(TAG, "[AutoTaskDiag] onViewCreated guideShown=" + r5);
    L5:
        if (r5 == false) goto L7;
        PageState r6 = PageState.CONTENT;
    L8:
        switchPage(r6);
        getBinding().getRoot().post(new $$Lambda$AutoMemoryTaskFragment$brDuIsg0eRT0ZIweJDDoSwZ7bx4(this));
        getBinding().getRoot().post(new $$Lambda$AutoMemoryTaskFragment$zmUqP4HkV8o4LEZi0Z7rTJ2zzQ(this));
        return;
    L7:
        r6 = PageState.GUIDE;
        goto L8
    }

    @Override // com.obric.memorydata.memory.ui.list.ac
    public void resetNestedViewPagerScroll() {
        FragmentAutoMemoryTaskBinding r0 = this._binding;
        if (r0 == null) goto L8;
        ViewPager2 r1 = r0.memoryTabContainer;
        if (r1 == null) goto L9;
        com.obric.memorydata.memory.ui.m.a(r1);
        return;
    L9:
        return;
    }
}
