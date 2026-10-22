package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.cae.userAware.WifiScanSceneType;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.common.oea.foundation.blur.BlurUtils;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.databinding.GlobalMemoryFragmentBinding;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.IdentityController;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBarActionHost;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import okhttp3.HttpUrl;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 h2\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004:\u0001hB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0016J\b\u00100\u001a\u00020,H\u0002J\b\u00101\u001a\u00020,H\u0002J\b\u00102\u001a\u00020,H\u0002J\b\u00103\u001a\u00020,H\u0016J\b\u00104\u001a\u00020,H\u0002J\u0016\u00105\u001a\u00020,2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0010\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u0012H\u0002J\b\u00109\u001a\u00020\fH\u0002J\u0010\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020\u000eH\u0002J\u0010\u0010<\u001a\u00020,2\u0006\u0010;\u001a\u00020\u000eH\u0002J\u0010\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020\u000eH\u0002J\u0010\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020\u0017H\u0002J\u0010\u0010A\u001a\u00020,2\u0006\u0010@\u001a\u00020\u0017H\u0002J\b\u0010B\u001a\u00020,H\u0002J\b\u0010C\u001a\u00020,H\u0002J\u0010\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020*H\u0016J\u0010\u0010F\u001a\u00020,2\u0006\u0010G\u001a\u00020\u0014H\u0002J\b\u0010H\u001a\u00020,H\u0002J\u0016\u0010I\u001a\u00020,2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010J\u001a\u00020,H\u0002J\u0010\u0010K\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u0012H\u0002J\u0010\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020\u000eH\u0002J\b\u0010N\u001a\u00020,H\u0002J\u0018\u0010O\u001a\u00020,2\u0006\u0010G\u001a\u00020\u00142\u0006\u0010P\u001a\u00020\u0014H\u0002J\u0010\u0010Q\u001a\u00020,2\u0006\u0010G\u001a\u00020\u0014H\u0002J\u001c\u0010R\u001a\u00020\u00172\b\b\u0002\u0010S\u001a\u00020\u00172\b\b\u0002\u0010T\u001a\u00020\u0017H\u0002J\u0015\u0010U\u001a\u00020,2\u0006\u0010V\u001a\u00020WH\u0000¢\u0006\u0002\bXJ\u0015\u0010U\u001a\u00020,2\u0006\u0010Y\u001a\u00020ZH\u0000¢\u0006\u0002\bXJ\b\u0010[\u001a\u00020,H\u0002J\u0010\u0010\\\u001a\u00020,2\u0006\u0010G\u001a\u00020\u0014H\u0002J\b\u0010]\u001a\u00020,H\u0002J\b\u0010^\u001a\u00020\u0017H\u0002J\u0010\u0010_\u001a\u00020\u00172\u0006\u0010-\u001a\u00020$H\u0002J\u0010\u0010`\u001a\u00020,2\u0006\u0010a\u001a\u00020\u000eH\u0002J\u0012\u0010b\u001a\u00020\u000e2\b\u0010-\u001a\u0004\u0018\u00010$H\u0002J\u0010\u0010c\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020(H\u0002J\u0010\u0010d\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020$H\u0002J\u0012\u0010e\u001a\u0004\u0018\u00010W2\u0006\u0010-\u001a\u00020$H\u0002J\b\u0010f\u001a\u00020,H\u0002J\b\u0010g\u001a\u00020,H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006i"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/GlobalMemoryTabFragment;", "Lcom/obric/memorydata/memory/ui/list/AbstractMemoryTabFragment;", "Lcom/obric/memorydata/memory/ui/list/MemoryNestedViewPagerHost;", "Lcom/obric/memorydata/ui/FloatingTitleBarOwner;", "Lcom/obric/memorydata/memory/ui/MemoryFloatingTitleBarOwner;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/GlobalMemoryFragmentBinding;", "pagerAdapter", "Lcom/obric/memorydata/memory/ui/list/MemoryFragmentAdapter;", "sourceSheet", "Lcom/obric/memorydata/memory/ui/list/MemorySourceSheet;", "selectedSourceKey", "", "restoredSourceKey", "currentSourceFilters", "", "Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "suppressSourceTabCallback", "", "pendingTargetSourcePackage", "pendingTargetSourceProductType", "", "Ljava/lang/Integer;", "pendingTargetEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "recyclerViewPaddingUpdateToken", "currentRecyclerViewTopPadding", "hasCollectMemory", "titleBarSubtitle", "editSelectedCount", "editSelectAllText", "getCurrentFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStop", "onDestroyView", "observeState", "setupViewPager", "prepareInitialSourceState", "resetNestedViewPagerScroll", "setupSourceFilterBar", "setupSourceTabs", "filters", "getSourceTabTitle", "filter", "createSourceSheet", "dismissSourceSheet", "from", "dismissSourceSheetIfLocked", "selectSource", "sourceKey", "selectSourceTab", "position", "finalizeSourceTabPosition", "stopSourceTabScroll", "updateSourceFilterGroupVisibility", "onSaveInstanceState", "outState", "updateSourceFilterEnabledState", "editMode", "showCollectEmptyImmediately", "selectPendingTargetSourceIfNeeded", "updateCurrentSelectionTab", "sourceSelectionKey", "toggleSelectText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "setupTitleBar", "applyTitleBarState", "animate", "updateRecyclerViewTopPadding", "calculateRecyclerViewTopPadding", "headerBottom", "containerBottom", "applyCurrentRecyclerViewTopPadding", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "applyCurrentRecyclerViewTopPadding$memory_obricRelease", "fragment", "Lcom/obric/memorydata/memory/ui/list/MemoryListFragment;", "applyRecyclerViewTopPaddingToCurrentFragments", "scheduleRecyclerViewTopPaddingUpdate", "setupHeaderLayoutRefresh", "getHeaderVisibleContentBottom", "bottomInRoot", "dumpHeaderDiag", InfoRequestQPSOptTraceLogger.REASON, "viewDiag", "childDiag", "clipChain", "findRecyclerView", "setupNavigationBar", "updateTargetMemoryEntity", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalMemoryTabFragment extends AbstractMemoryTabFragment implements ac, com.obric.memorydata.ui.b {
    public static final a Companion = null;
    private static final String DIAG_PREFIX = "[OTabDiag][Global]";
    private static final int HEADER_LIST_GAP_DP = 12;
    private static final String STATE_SELECTED_SOURCE = "selected_collect_source";
    private static final String TAG = "GlobalMemoryTabFragment";
    private static final int TITLE_CONTAINER_LIST_OVERLAP_DP = 12;
    private GlobalMemoryFragmentBinding binding;
    private int currentRecyclerViewTopPadding;
    private List<MemorySourceFilter> currentSourceFilters;
    private String editSelectAllText;
    private int editSelectedCount;
    private boolean hasCollectMemory;
    private u pagerAdapter;
    private AppEntity pendingTargetEntity;
    private String pendingTargetSourcePackage;
    private Integer pendingTargetSourceProductType;
    private int recyclerViewPaddingUpdateToken;
    private String restoredSourceKey;
    private String selectedSourceKey;
    private ah sourceSheet;
    private boolean suppressSourceTabCallback;
    private String titleBarSubtitle;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/GlobalMemoryTabFragment$Companion;", "", "<init>", "()V", "TAG", "", "DIAG_PREFIX", "HEADER_LIST_GAP_DP", "", "STATE_SELECTED_SOURCE", "TITLE_CONTAINER_LIST_OVERLAP_DP", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f11011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ GlobalMemoryTabFragment f11012b;
        final /* synthetic */ View c;
        final /* synthetic */ boolean d;

        public b(int r1, GlobalMemoryTabFragment r2, View r3, boolean r4) {
            this.f11011a = r1;
            this.f11012b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
            if (this.f11011a == GlobalMemoryTabFragment.access$getRecyclerViewPaddingUpdateToken$p(this.f11012b)) goto L5;
            return;
        L5:
            if (GlobalMemoryTabFragment.access$isCurrentFragmentView(this.f11012b, this.c) == false) goto L9;
            GlobalMemoryTabFragment.access$updateRecyclerViewTopPadding(this.f11012b, this.d);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/GlobalMemoryTabFragment$setupSourceTabs$1$4", "Lcom/obric/oui/tab/OTabLayoutBase$OnTabSelectedListener;", "onTabSelected", "", "tab", "Lcom/obric/oui/tab/OTabLayoutBase$Tab;", "onTabUnselected", "onTabReselected", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements OTabLayoutBase.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ GlobalMemoryTabFragment f11013a;

        c(GlobalMemoryTabFragment r1) {
            this.f11013a = r1;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void a(OTabLayoutBase.g r4) {
            if (GlobalMemoryTabFragment.access$getSuppressSourceTabCallback$p(this.f11013a) == false) goto L6;
            return;
        L6:
            if (((Boolean) ZeusTransformUtils.preCheckCast(this.f11013a.getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L12;
            GlobalMemoryTabFragment r3 = this.f11013a;
            GlobalMemoryFragmentBinding r5 = GlobalMemoryTabFragment.access$getBinding$p(r3);
            if (r5 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r5 = null;
        L10:
            GlobalMemoryTabFragment.access$selectSourceTab(r3, r5.viewPagerMemory.getCurrentItem());
            return;
        L12:
            List r0 = GlobalMemoryTabFragment.access$getCurrentSourceFilters$p(this.f11013a);
            if (r4 == null) goto L19;
            MemorySourceFilter r6 = (MemorySourceFilter) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r0, r4.c()), MemorySourceFilter.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L17;
            return;
        L17:
            GlobalMemoryTabFragment.access$selectSource(this.f11013a, r6.getStableKey());
            return;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void b(OTabLayoutBase.g r1) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void c(OTabLayoutBase.g r4) {
            if (GlobalMemoryTabFragment.access$getSuppressSourceTabCallback$p(this.f11013a) == false) goto L6;
            return;
        L6:
            if (((Boolean) ZeusTransformUtils.preCheckCast(this.f11013a.getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L8;
            return;
        L8:
            List r0 = GlobalMemoryTabFragment.access$getCurrentSourceFilters$p(this.f11013a);
            if (r4 == null) goto L15;
            MemorySourceFilter r5 = (MemorySourceFilter) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r0, r4.c()), MemorySourceFilter.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L13;
            return;
        L13:
            GlobalMemoryTabFragment.access$selectSource(this.f11013a, r5.getStableKey());
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f11014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11015b;
        final /* synthetic */ GlobalMemoryTabFragment c;
        final /* synthetic */ OTabLayout d;
        final /* synthetic */ int e;

        public d(boolean r1, String r2, GlobalMemoryTabFragment r3, OTabLayout r4, int r5) {
            this.f11014a = r1;
            this.f11015b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
            int r10 = 0;
            if (this.f11014a == false) goto L5;
        L16:
            View r11 = this.d.getChildAt(0);
            if (r11 == null) goto L19;
            int r12 = r11.getWidth();
        L20:
            this.d.scrollTo(RangesKt.coerceIn(this.e, 0, RangesKt.coerceAtLeast(r12 - this.d.getWidth(), 0)), 0);
        L22:
            if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L34;
            RunLog r13 = RunLog.INSTANCE;
            StringBuilder r14 = new StringBuilder().append("[OTabDiag][Global] setupSourceTabs.post groupBottom=");
            GlobalMemoryTabFragment r15 = this.c;
            GlobalMemoryFragmentBinding r16 = GlobalMemoryTabFragment.access$getBinding$p(r15);
            GlobalMemoryFragmentBinding r17 = null;
            if (r16 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r16 = null;
        L26:
            OUILinearLayout r18 = r16.sourceFilterGroup;
            Intrinsics.checkNotNullExpressionValue(r18, "sourceFilterGroup");
            StringBuilder r19 = r14.append(GlobalMemoryTabFragment.access$bottomInRoot(r15, (View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.memorydata.plugin"))).append(" tabsBottom=");
            GlobalMemoryTabFragment r20 = this.c;
            GlobalMemoryFragmentBinding r21 = GlobalMemoryTabFragment.access$getBinding$p(r20);
            if (r21 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r21 = null;
        L29:
            OTabLayout r22 = r21.rvSourceFilter;
            Intrinsics.checkNotNullExpressionValue(r22, "rvSourceFilter");
            StringBuilder r23 = r19.append(GlobalMemoryTabFragment.access$bottomInRoot(r20, (View) ZeusTransformUtils.preCheckCast(r22, View.class, "com.obric.memorydata.plugin"))).append(" tabsH=");
            GlobalMemoryFragmentBinding r24 = GlobalMemoryTabFragment.access$getBinding$p(this.c);
            if (r24 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L33:
            r13.debug(GlobalMemoryTabFragment.TAG, r23.append(r17.rvSourceFilter.getHeight()).append(" scrollX=").append(this.d.getScrollX()).toString());
            goto L34
        L32:
            r17 = r24;
        L34:
            GlobalMemoryTabFragment.access$dumpHeaderDiag(this.c, "setupSourceTabs.post");
            GlobalMemoryTabFragment r0 = this.c;
            GlobalMemoryTabFragment.access$updateRecyclerViewTopPadding(r0, ((Boolean) ZeusTransformUtils.preCheckCast(r0.getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
            return;
        L19:
            r12 = this.d.getWidth();
            goto L20
        L5:
            if (Intrinsics.areEqual(this.f11015b, GlobalMemoryTabFragment.access$getSelectedSourceKey$p(this.c)) == true) goto L16;
            Iterator r25 = GlobalMemoryTabFragment.access$getCurrentSourceFilters$p(this.c).iterator();
        L8:
            if (r25.hasNext() == false) goto L13;
            if (Intrinsics.areEqual(((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r25.next(), MemorySourceFilter.class, "com.obric.memorydata.plugin")).getStableKey(), GlobalMemoryTabFragment.access$getSelectedSourceKey$p(this.c)) == true) goto L14;
            r10 = r10 + 1;
        L14:
            if (r10 < 0) goto L22;
            this.d.a(r10, 0.0f, true);
            goto L22
        L13:
            r10 = -1;
            goto L14
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/GlobalMemoryTabFragment$setupViewPager$1$1", "Lcom/obric/oui/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrollStateChanged", "", "state", "", "onPageSelected", "position", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends ViewPager2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ GlobalMemoryTabFragment f11016a;

        e(GlobalMemoryTabFragment r1) {
            this.f11016a = r1;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
        public void a(int r2) {
            if (r2 != 1) goto L5;
            GlobalMemoryTabFragment.access$stopSourceTabScroll(this.f11016a);
            com.obric.memorydata.memory.ui.g.f10964a.a();
            GlobalMemoryTabFragment.access$applyRecyclerViewTopPaddingToCurrentFragments(this.f11016a);
        L5:
            if (r2 != 0) goto L11;
            GlobalMemoryTabFragment r1 = this.f11016a;
            GlobalMemoryFragmentBinding r3 = GlobalMemoryTabFragment.access$getBinding$p(r1);
            if (r3 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r3 = null;
        L9:
            GlobalMemoryTabFragment.access$finalizeSourceTabPosition(r1, r3.viewPagerMemory.getCurrentItem());
            return;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
        public void b(int r5) {
            u r0 = GlobalMemoryTabFragment.access$getPagerAdapter$p(this.f11016a);
            ah r1 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            r0 = null;
        L5:
            MemorySourceFilter r2 = r0.d(r5);
            if (r2 != null) goto L8;
            r2 = MemorySourceFilter.a.a(MemorySourceFilter.Companion, 0, 1, null);
        L8:
            GlobalMemoryTabFragment.access$setSelectedSourceKey$p(this.f11016a, r2.getStableKey());
            GlobalMemoryTabFragment.access$selectSourceTab(this.f11016a, r5);
            ah r6 = GlobalMemoryTabFragment.access$getSourceSheet$p(this.f11016a);
            if (r6 != null) goto L11;
        L15:
            GlobalMemoryTabFragment.access$updateCurrentSelectionTab(this.f11016a);
            GlobalMemoryTabFragment r4 = this.f11016a;
            GlobalMemoryTabFragment.access$scheduleRecyclerViewTopPaddingUpdate(r4, ((Boolean) ZeusTransformUtils.preCheckCast(r4.getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
            return;
        L11:
            if (r6.b() == false) goto L13;
            r1 = r6;
        L13:
            if (r1 == null) goto L15;
            r1.update((List) ZeusTransformUtils.preCheckCast(this.f11016a.getShareViewModel().getMemorySourceFilters().c(), List.class, "com.obric.memorydata.plugin"), GlobalMemoryTabFragment.access$getSelectedSourceKey$p(this.f11016a));
            goto L15
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$1", f = "GlobalMemoryTabFragment.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GlobalMemoryTabFragment this$0;

        AnonymousClass1(GlobalMemoryTabFragment r3, Continuation<? super AnonymousClass1> r4) {
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
            kotlinx.coroutines.flow.ar<Boolean> r7 = this.this$0.getShareViewModel().getSelectionManager().b();
            final GlobalMemoryTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05671(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$2", f = "GlobalMemoryTabFragment.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GlobalMemoryTabFragment this$0;

        AnonymousClass2(GlobalMemoryTabFragment r3, Continuation<? super AnonymousClass2> r4) {
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
            kotlinx.coroutines.flow.ar<SelectionStateManager.SelectAllState> r7 = this.this$0.getShareViewModel().getSelectionManager().c();
            final GlobalMemoryTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super SelectionStateManager.SelectAllState> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$3", f = "GlobalMemoryTabFragment.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GlobalMemoryTabFragment this$0;

        AnonymousClass3(GlobalMemoryTabFragment r3, Continuation<? super AnonymousClass3> r4) {
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
            kotlinx.coroutines.flow.ar<Integer> r7 = this.this$0.getShareViewModel().getSelectionManager().f();
            final GlobalMemoryTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Integer> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$4", f = "GlobalMemoryTabFragment.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GlobalMemoryTabFragment this$0;

        AnonymousClass4(GlobalMemoryTabFragment r3, Continuation<? super AnonymousClass4> r4) {
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
            kotlinx.coroutines.flow.ae<String> r7 = this.this$0.getShareViewModel().getSelectBottomTab();
            final GlobalMemoryTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super String> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$5", f = "GlobalMemoryTabFragment.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GlobalMemoryTabFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$5$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0010\u000b\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tH\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lcom/obric/memorydata/database/entity/CollectMemorySourceStat;", "totalCount", "stats", "<unused var>", "", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$5$1", f = "GlobalMemoryTabFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function6<Integer, List<? extends com.obric.memorydata.database.entity.al>, Long, Boolean, Boolean, Continuation<? super Pair<? extends Integer, ? extends List<? extends com.obric.memorydata.database.entity.al>>>, Object> {
            /* synthetic */ int I$0;
            /* synthetic */ Object L$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
                super(6, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
            }

            public final Object invoke(int r1, List<com.obric.memorydata.database.entity.al> r2, long r3, boolean r5, boolean r6, Continuation<? super Pair<Integer, ? extends List<com.obric.memorydata.database.entity.al>>> r7) {
                List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r4 = new AnonymousClass1((Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin"));
                r4.I$0 = r1;
                r4.L$0 = r0;
                return r4.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function6
            public /* synthetic */ Object invoke(Integer r11, List<? extends com.obric.memorydata.database.entity.al> r12, Long r13, Boolean r14, Boolean r15, Continuation<? super Pair<? extends Integer, ? extends List<? extends com.obric.memorydata.database.entity.al>>> r16) {
                return invoke(((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).intValue(), (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue(), ((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), ((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r16, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                int r4 = this.I$0;
                List r2 = (List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin");
                return TuplesKt.to(Boxing.boxInt(r4), r2);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass5(GlobalMemoryTabFragment r3, Continuation<? super AnonymousClass5> r4) {
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
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            final String r12 = AppContext.INSTANCE.getUserId();
            kotlinx.coroutines.flow.i r2 = kotlinx.coroutines.flow.k.a(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().getAllCollectMemoryWithRelevantCount(), MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().getCollectMemorySourceStats(), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(h.f11312a.a(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), h.f11312a.b(), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.this$0.getShareViewModel().getGlassesLandingPending(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function6) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), Function6.class, "com.obric.memorydata.plugin"));
            final GlobalMemoryTabFragment r4 = this.this$0;
            kotlinx.coroutines.flow.j r13 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r12, r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r2.collect(r13, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$6", f = "GlobalMemoryTabFragment.kt", i = {}, l = {WifiScanSceneType.HAR_END}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GlobalMemoryTabFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$6$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "filters", "<unused var>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$6$1", f = "GlobalMemoryTabFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function3<List<? extends MemorySourceFilter>, Boolean, Continuation<? super List<? extends MemorySourceFilter>>, Object> {
            /* synthetic */ Object L$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
                super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.jvm.functions.Function3
            public /* synthetic */ Object invoke(List<? extends MemorySourceFilter> r3, Boolean r4, Continuation<? super List<? extends MemorySourceFilter>> r5) {
                return invoke((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
            }

            public final Object invoke(List<MemorySourceFilter> r1, boolean r2, Continuation<? super List<MemorySourceFilter>> r3) {
                List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r4 = new AnonymousClass1((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
                r4.L$0 = r0;
                return r4.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return (List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin");
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass6(GlobalMemoryTabFragment r3, Continuation<? super AnonymousClass6> r4) {
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
            kotlinx.coroutines.flow.i r8 = kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.this$0.getShareViewModel().getMemorySourceFilters(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.this$0.getShareViewModel().getGlassesLandingPending(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), Function3.class, "com.obric.memorydata.plugin"));
            final GlobalMemoryTabFragment r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r8.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$7", f = "GlobalMemoryTabFragment.kt", i = {}, l = {231}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass7 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GlobalMemoryTabFragment this$0;

        AnonymousClass7(GlobalMemoryTabFragment r3, Continuation<? super AnonymousClass7> r4) {
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
            kotlinx.coroutines.flow.ar<Pair<MemoryTab, Pair<LocalDate, AppEntity>>> r7 = this.this$0.getShareViewModel().getTargetEntityFlow();
            final GlobalMemoryTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Pair<MemoryTab, Pair<LocalDate, AppEntity>>> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.GlobalMemoryTabFragment$observeState$8", f = "GlobalMemoryTabFragment.kt", i = {}, l = {258}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass8 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GlobalMemoryTabFragment this$0;

        AnonymousClass8(GlobalMemoryTabFragment r3, Continuation<? super AnonymousClass8> r4) {
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
            kotlinx.coroutines.flow.ar<Boolean> r7 = this.this$0.getShareViewModel().getSelectionManager().b();
            final GlobalMemoryTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public GlobalMemoryTabFragment() {
        this.selectedSourceKey = MemorySourceFilter.KEY_ALL;
        this.currentSourceFilters = CollectionsKt.listOf(MemorySourceFilter.a.a(MemorySourceFilter.Companion, 0, 1, null));
        this.currentRecyclerViewTopPadding = -1;
        this.editSelectAllText = "";
    }

    public static final /* synthetic */ void access$applyRecyclerViewTopPaddingToCurrentFragments(GlobalMemoryTabFragment r0) {
        r0.applyRecyclerViewTopPaddingToCurrentFragments();
    }

    public static final /* synthetic */ void access$applyTitleBarState(GlobalMemoryTabFragment r0, boolean r1, boolean r2) {
        r0.applyTitleBarState(r1, r2);
    }

    public static final /* synthetic */ int access$bottomInRoot(GlobalMemoryTabFragment r0, View r1) {
        return r0.bottomInRoot(r1);
    }

    public static final /* synthetic */ void access$dismissSourceSheet(GlobalMemoryTabFragment r0, String r1) {
        r0.dismissSourceSheet(r1);
    }

    public static final /* synthetic */ void access$dumpHeaderDiag(GlobalMemoryTabFragment r0, String r1) {
        r0.dumpHeaderDiag(r1);
    }

    public static final /* synthetic */ void access$finalizeSourceTabPosition(GlobalMemoryTabFragment r0, int r1) {
        r0.finalizeSourceTabPosition(r1);
    }

    public static final /* synthetic */ GlobalMemoryFragmentBinding access$getBinding$p(GlobalMemoryTabFragment r0) {
        return r0.binding;
    }

    public static final /* synthetic */ List access$getCurrentSourceFilters$p(GlobalMemoryTabFragment r0) {
        return r0.currentSourceFilters;
    }

    public static final /* synthetic */ boolean access$getHasCollectMemory$p(GlobalMemoryTabFragment r0) {
        return r0.hasCollectMemory;
    }

    public static final /* synthetic */ u access$getPagerAdapter$p(GlobalMemoryTabFragment r0) {
        return r0.pagerAdapter;
    }

    public static final /* synthetic */ String access$getPendingTargetSourcePackage$p(GlobalMemoryTabFragment r0) {
        return r0.pendingTargetSourcePackage;
    }

    public static final /* synthetic */ Integer access$getPendingTargetSourceProductType$p(GlobalMemoryTabFragment r0) {
        return r0.pendingTargetSourceProductType;
    }

    public static final /* synthetic */ int access$getRecyclerViewPaddingUpdateToken$p(GlobalMemoryTabFragment r0) {
        return r0.recyclerViewPaddingUpdateToken;
    }

    public static final /* synthetic */ String access$getRestoredSourceKey$p(GlobalMemoryTabFragment r0) {
        return r0.restoredSourceKey;
    }

    public static final /* synthetic */ String access$getSelectedSourceKey$p(GlobalMemoryTabFragment r0) {
        return r0.selectedSourceKey;
    }

    public static final /* synthetic */ ah access$getSourceSheet$p(GlobalMemoryTabFragment r0) {
        return r0.sourceSheet;
    }

    public static final /* synthetic */ boolean access$getSuppressSourceTabCallback$p(GlobalMemoryTabFragment r0) {
        return r0.suppressSourceTabCallback;
    }

    public static final /* synthetic */ boolean access$isCurrentFragmentView(GlobalMemoryTabFragment r0, View r1) {
        return r0.isCurrentFragmentView(r1);
    }

    public static final /* synthetic */ void access$scheduleRecyclerViewTopPaddingUpdate(GlobalMemoryTabFragment r0, boolean r1) {
        r0.scheduleRecyclerViewTopPaddingUpdate(r1);
    }

    public static final /* synthetic */ void access$selectPendingTargetSourceIfNeeded(GlobalMemoryTabFragment r2, List r3) {
        r2.selectPendingTargetSourceIfNeeded((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$selectSource(GlobalMemoryTabFragment r0, String r1) {
        r0.selectSource(r1);
    }

    public static final /* synthetic */ void access$selectSourceTab(GlobalMemoryTabFragment r0, int r1) {
        r0.selectSourceTab(r1);
    }

    public static final /* synthetic */ void access$setEditSelectedCount$p(GlobalMemoryTabFragment r0, int r1) {
        r0.editSelectedCount = r1;
    }

    public static final /* synthetic */ void access$setHasCollectMemory$p(GlobalMemoryTabFragment r0, boolean r1) {
        r0.hasCollectMemory = r1;
    }

    public static final /* synthetic */ void access$setPendingTargetEntity$p(GlobalMemoryTabFragment r0, AppEntity r1) {
        r0.pendingTargetEntity = r1;
    }

    public static final /* synthetic */ void access$setPendingTargetSourcePackage$p(GlobalMemoryTabFragment r0, String r1) {
        r0.pendingTargetSourcePackage = r1;
    }

    public static final /* synthetic */ void access$setPendingTargetSourceProductType$p(GlobalMemoryTabFragment r0, Integer r1) {
        r0.pendingTargetSourceProductType = r1;
    }

    public static final /* synthetic */ void access$setRestoredSourceKey$p(GlobalMemoryTabFragment r0, String r1) {
        r0.restoredSourceKey = r1;
    }

    public static final /* synthetic */ void access$setSelectedSourceKey$p(GlobalMemoryTabFragment r0, String r1) {
        r0.selectedSourceKey = r1;
    }

    public static final /* synthetic */ void access$setTitleBarSubtitle$p(GlobalMemoryTabFragment r0, String r1) {
        r0.titleBarSubtitle = r1;
    }

    public static final /* synthetic */ void access$setupSourceTabs(GlobalMemoryTabFragment r2, List r3) {
        r2.setupSourceTabs((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$showCollectEmptyImmediately(GlobalMemoryTabFragment r0) {
        r0.showCollectEmptyImmediately();
    }

    public static final /* synthetic */ String access$sourceSelectionKey(GlobalMemoryTabFragment r0, MemorySourceFilter r1) {
        return r0.sourceSelectionKey(r1);
    }

    public static final /* synthetic */ void access$stopSourceTabScroll(GlobalMemoryTabFragment r0) {
        r0.stopSourceTabScroll();
    }

    public static final /* synthetic */ void access$toggleSelectText(GlobalMemoryTabFragment r0, String r1) {
        r0.toggleSelectText(r1);
    }

    public static final /* synthetic */ void access$updateCurrentSelectionTab(GlobalMemoryTabFragment r0) {
        r0.updateCurrentSelectionTab();
    }

    public static final /* synthetic */ void access$updateRecyclerViewTopPadding(GlobalMemoryTabFragment r0, boolean r1) {
        r0.updateRecyclerViewTopPadding(r1);
    }

    public static final /* synthetic */ void access$updateSourceFilterEnabledState(GlobalMemoryTabFragment r0, boolean r1) {
        r0.updateSourceFilterEnabledState(r1);
    }

    public static final /* synthetic */ void access$updateSourceFilterGroupVisibility(GlobalMemoryTabFragment r0) {
        r0.updateSourceFilterGroupVisibility();
    }

    private final void applyRecyclerViewTopPaddingToCurrentFragments() {
        int r0 = this.currentRecyclerViewTopPadding;
        if (r0 > 0) goto L6;
        return;
    L6:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L8;
        RunLog.INSTANCE.debug(TAG, "[OTabDiag][Global] applyToFragments topPadding=" + r0 + " fragments=" + getChildFragmentManager().getFragments().size());
    L8:
        List<Fragment> r1 = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(r1, "getFragments(...)");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r2.hasNext() == false) goto L19;
        Fragment r3 = (Fragment) ZeusTransformUtils.preCheckCast(r2.next(), Fragment.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, MemoryListFragment.class) == true) goto L13;
        View r4 = r3.getView();
        if (r4 == null) goto L10;
        RecyclerView r5 = findRecyclerView(r4);
        if (r5 == null) goto L10;
        applyCurrentRecyclerViewTopPadding$memory_obricRelease(r5);
        goto L10
    L13:
        ((MemoryListFragment) ZeusTransformUtils.preCheckCast(r3, MemoryListFragment.class, "com.obric.memorydata.plugin")).applyRecyclerViewTopPadding$memory_obricRelease(r0);
        goto L10
    }

    private final void applyTitleBarState(final boolean r10, boolean r11) {
        final Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "requireContext(...)");
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        GlobalMemoryFragmentBinding r4 = null;
        if (ZeusTransformUtils.instanceOf(r2, MemoryListActivity.class) == false) goto L5;
        MemoryListActivity r1 = (MemoryListActivity) ZeusTransformUtils.preCheckCast(r2, MemoryListActivity.class, "com.obric.memorydata.plugin");
    L6:
        GlobalMemoryFragmentBinding r3 = this.binding;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L9:
        OFloatingTitleBar r5 = r3.viewTitleNormal;
        boolean r6 = true;
        if (r11 == false) goto L21;
        if (r1 == null) goto L18;
        GlobalMemoryFragmentBinding r8 = this.binding;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L15:
        OFloatingTitleBar r9 = r8.viewTitleNormal;
        Intrinsics.checkNotNullExpressionValue(r9, "viewTitleNormal");
        if (r1.handles(r9) != true) goto L18;
        boolean r12 = true;
    L19:
        if (r12 == true) goto L21;
    L22:
        r5.a(r6, new $$Lambda$GlobalMemoryTabFragment$qdmklwbGgVFmmfMrAJ1_jnYtchI(r10, this, r0));
        GlobalMemoryFragmentBinding r13 = this.binding;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L25:
        OFloatingTitleBar r14 = r13.viewTitleNormal;
        Intrinsics.checkNotNullExpressionValue(r14, "viewTitleNormal");
        com.obric.memorydata.ui.custom.a.a(r14);
        if (r1 == null) goto L33;
        GlobalMemoryFragmentBinding r15 = this.binding;
        if (r15 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L31:
        OFloatingTitleBar r16 = r4.viewTitleNormal;
        Intrinsics.checkNotNullExpressionValue(r16, "viewTitleNormal");
        r1.syncCurrentFloatingTitleBar(r16, r11);
        return;
    L30:
        r4 = r15;
        goto L31
    L33:
        return;
    L18:
        r12 = false;
    L21:
        r6 = false;
        goto L22
    L5:
        r1 = null;
        goto L6
    }

    private static final Unit applyTitleBarState$lambda$30(boolean r8, final GlobalMemoryTabFragment r9, Context r10, OFloatingTitleBar r11) {
        final Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "$this$batchSet");
        if (r8 == false) goto L5;
        String r4 = null;
    L6:
        r11.setStartTitle(r4);
        if (r8 == false) goto L9;
        String r5 = null;
    L10:
        r11.setStartSubtitle(r5);
        if (r8 == false) goto L13;
        String r2 = r9.getString(ZeusTransformUtils.mapRes(R.string.memory_multi_select_selected_count, TypedValues.Custom.S_STRING, "memory_multi_select_selected_count"), new Object[]{Integer.valueOf(r9.editSelectedCount)});
    L14:
        r11.setCenterTitle(r2);
        r11.setCenterSubtitle(null);
        if (r8 == false) goto L17;
        int r6 = R.style.OFloatingTitleBar_Action_PrimaryLight_Text;
        String r7 = "OFloatingTitleBar_Action_PrimaryLight_Text";
    L18:
        r11.setEndButtonGroupStyle(ZeusTransformUtils.mapRes(r6, "style", r7));
        OFloatingTitleBar.a(r11, false, 1, null);
        OFloatingTitleBar.b(r11, false, 1, null);
        OFloatingTitleBar.d(r11, false, 1, null);
        OFloatingTitleBar.c(r11, false, 1, null);
        if (r8 == false) goto L21;
        OFloatingTitleBar.a(r11, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_close, "drawable", "o_floating_title_bar_icon_close"), 0, new $$Lambda$GlobalMemoryTabFragment$mg6eI7F_YoUjwTvF1Nz7hjyIRvs(r9), 2, null);
        OFloatingTitleBar.a(r11, r9.editSelectAllText, 0, new $$Lambda$GlobalMemoryTabFragment$VO15KEBchTSCV34wo8aAPhTdY0(r9), 2, null);
    L23:
        return Unit.INSTANCE;
    L21:
        OFloatingTitleBar.b(r11, ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_search, "drawable", "ic_memory_list_search"), 0, new $$Lambda$GlobalMemoryTabFragment$pjcZU8LT8QR9wRehFpTDiZYjI3E(r1), 2, null);
        OFloatingTitleBar.b(r11, ZeusTransformUtils.mapRes(R.drawable.ic_memory_detail_operation, "drawable", "ic_memory_detail_operation"), 0, new $$Lambda$GlobalMemoryTabFragment$4bwWgaMuqAn8xcgVl6_H0eQvNMQ(r9), 2, null);
        goto L23
    L17:
        r6 = R.style.OFloatingTitleBar_Action_Standard;
        r7 = "OFloatingTitleBar_Action_Standard";
        goto L18
    L13:
        r2 = null;
        goto L14
    L9:
        r5 = r9.titleBarSubtitle;
        goto L10
    L5:
        r4 = r9.getString(ZeusTransformUtils.mapRes(R.string.memory_settings_data_title, TypedValues.Custom.S_STRING, "memory_settings_data_title"));
        goto L6
    }

    private static final void applyTitleBarState$lambda$30$lambda$26(GlobalMemoryTabFragment r0, View r1) {
        r0.getShareViewModel().getSelectionManager().j();
    }

    private static final void applyTitleBarState$lambda$30$lambda$27(GlobalMemoryTabFragment r0, View r1) {
        r0.getShareViewModel().getSelectionManager().l();
    }

    private static final void applyTitleBarState$lambda$30$lambda$28(Context r1, View r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        MemorySearchActivity.Companion.a(r3);
    }

    private static final void applyTitleBarState$lambda$30$lambda$29(GlobalMemoryTabFragment r0, View r1) {
        Intrinsics.checkNotNull(r1);
        r0.showPopupMenu(r1);
    }

    private final int bottomInRoot(View r3) {
        if (r3.getHeight() > 0) goto L5;
        return 0;
    L5:
        if (r3.isShown() == false) goto L14;
        int[] r1 = new int[2];
        int[] r0 = new int[2];
        GlobalMemoryFragmentBinding r2 = this.binding;
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

    private final int calculateRecyclerViewTopPadding(int r5, int r6) {
        int r1 = 0;
        if (r5 <= 0) goto L5;
        int r7 = r5 + MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()));
    L6:
        if (r6 <= 0) goto L9;
        r1 = r6 - MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()));
    L9:
        return Math.max(r7, r1);
    L5:
        r7 = 0;
        goto L6
    }

    static /* synthetic */ int calculateRecyclerViewTopPadding$default(GlobalMemoryTabFragment r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.getHeaderVisibleContentBottom();
    L6:
        if ((r3 & 2) == 0) goto L12;
        GlobalMemoryFragmentBinding r5 = r0.binding;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L10:
        OBlurMaskView r6 = r5.titleBarContainer;
        Intrinsics.checkNotNullExpressionValue(r6, "titleBarContainer");
        r2 = r0.bottomInRoot((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"));
    L12:
        return r0.calculateRecyclerViewTopPadding(r1, r2);
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

    private final ah createSourceSheet() {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "requireContext(...)");
        return new ah(r1, new $$Lambda$GlobalMemoryTabFragment$xWx8mJMPDENL3NyjJRSAZzzGQrE(this));
    }

    private static final Unit createSourceSheet$lambda$14(GlobalMemoryTabFragment r1, MemorySourceFilter r2) {
        Intrinsics.checkNotNullParameter(r2, "filter");
        r1.selectSource(r2.getStableKey());
        return Unit.INSTANCE;
    }

    private final void dismissSourceSheet(String r9) {
        ah r0 = this.sourceSheet;
        if (r0 == null) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "dismissSourceSheet(" + r9 + "): showing=" + r0.b(), false, 4, null);
        r0.a();
    L5:
        this.sourceSheet = null;
    }

    private final void dismissSourceSheetIfLocked(String r9) {
        boolean r0 = IdentityController.f12979a.d();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "dismissSourceSheetIfLocked(" + r9 + "): locked=" + r0, false, 4, null);
        if (r0 == false) goto L6;
        dismissSourceSheet(r9);
        return;
    }

    private final void dumpHeaderDiag(String r10) {
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == true) goto L5;
        return;
    L5:
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder();
        StringBuilder r11 = r1.append("[OTabDiag][Global] [HeaderCoordDiag] dump[").append(r10).append("] targetGap=").append(MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()))).append(" root=");
        GlobalMemoryFragmentBinding r2 = this.binding;
        GlobalMemoryFragmentBinding r3 = null;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        StringBuilder r12 = r11.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r2.getRoot(), View.class, "com.obric.memorydata.plugin"))).append(" titleContainer=");
        GlobalMemoryFragmentBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        StringBuilder r13 = r12.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r4.titleBarContainer, View.class, "com.obric.memorydata.plugin"))).append(" title=");
        GlobalMemoryFragmentBinding r5 = this.binding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L14:
        StringBuilder r14 = r13.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r5.titleBarLayout, View.class, "com.obric.memorydata.plugin"))).append(" titleNormal=");
        GlobalMemoryFragmentBinding r6 = this.binding;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L17:
        StringBuilder r15 = r14.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r6.viewTitleNormal, View.class, "com.obric.memorydata.plugin"))).append(" titleNormalInner=");
        GlobalMemoryFragmentBinding r7 = this.binding;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L20:
        StringBuilder r16 = r15.append(viewDiag(r7.viewTitleNormal.findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, OaidModel.KEY_ID, "title_bar_container")))).append(" titleNormalStart=");
        GlobalMemoryFragmentBinding r8 = this.binding;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L23:
        StringBuilder r17 = r16.append(viewDiag(r8.viewTitleNormal.findViewById(ZeusTransformUtils.mapRes(R.id.start_title_container, OaidModel.KEY_ID, "start_title_container")))).append(" group=");
        GlobalMemoryFragmentBinding r9 = this.binding;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L26:
        StringBuilder r18 = r17.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r9.sourceFilterGroup, View.class, "com.obric.memorydata.plugin"))).append(" tabs=");
        GlobalMemoryFragmentBinding r19 = this.binding;
        if (r19 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L29:
        StringBuilder r110 = r18.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r19.rvSourceFilter, View.class, "com.obric.memorydata.plugin"))).append(" pager=");
        GlobalMemoryFragmentBinding r20 = this.binding;
        if (r20 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L32:
        r110.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r20.viewPagerMemory, View.class, "com.obric.memorydata.plugin"))).append(" operation=");
        GlobalMemoryFragmentBinding r111 = this.binding;
        if (r111 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L35:
        StringBuilder r112 = r1.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r111.memoryOperationContainer, View.class, "com.obric.memorydata.plugin"))).append(" topPadding=").append(this.currentRecyclerViewTopPadding).append(" visibleContentBottom=").append(getHeaderVisibleContentBottom()).append(" visualGap=").append(this.currentRecyclerViewTopPadding - getHeaderVisibleContentBottom()).append(" tabChildren=");
        GlobalMemoryFragmentBinding r21 = this.binding;
        if (r21 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L38:
        OTabLayout r22 = r21.rvSourceFilter;
        Intrinsics.checkNotNullExpressionValue(r22, "rvSourceFilter");
        StringBuilder r113 = r112.append(childDiag((ViewGroup) ZeusTransformUtils.preCheckCast(r22, ViewGroup.class, "com.obric.memorydata.plugin"))).append(" clipChain=");
        GlobalMemoryFragmentBinding r23 = this.binding;
        if (r23 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L42:
        OTabLayout r24 = r3.rvSourceFilter;
        Intrinsics.checkNotNullExpressionValue(r24, "rvSourceFilter");
        r113.append(clipChain((View) ZeusTransformUtils.preCheckCast(r24, View.class, "com.obric.memorydata.plugin")));
        r0.debug(TAG, r1.toString());
        return;
    L41:
        r3 = r23;
        goto L42
    }

    private final void finalizeSourceTabPosition(final int r5) {
        MemorySourceFilter r0 = (MemorySourceFilter) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(this.currentSourceFilters, r5), MemorySourceFilter.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L15;
        final String r1 = r0.getStableKey();
        if (r1 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(this.selectedSourceKey, r1) == true) goto L10;
        return;
    L10:
        GlobalMemoryFragmentBinding r2 = this.binding;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L13:
        final OTabLayout r3 = r2.rvSourceFilter;
        r3.a(r5, 0.0f, true);
        r3.postOnAnimation(new $$Lambda$GlobalMemoryTabFragment$hL341r0GR7xtFe_NcxH7rgs4y_c(this, r5, r1, r3));
        return;
    }

    private static final void finalizeSourceTabPosition$lambda$18$lambda$17(GlobalMemoryTabFragment r1, int r2, String r3, OTabLayout r4) {
        GlobalMemoryFragmentBinding r0 = r1.binding;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        if (r0.viewPagerMemory.getCurrentItem() == r2) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r1.selectedSourceKey, r3) == false) goto L12;
        r4.a(r2, 0.0f, true);
        return;
    }

    private final RecyclerView findRecyclerView(View r6) {
        if (ZeusTransformUtils.instanceOf(r6, RecyclerView.class) == false) goto L7;
        return (RecyclerView) ZeusTransformUtils.preCheckCast(r6, RecyclerView.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L14;
        int r0 = 0;
        int r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
    L9:
        if (r0 >= r2) goto L18;
        View r3 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(r0);
        Intrinsics.checkNotNullExpressionValue(r3, "getChildAt(...)");
        RecyclerView r4 = findRecyclerView(r3);
        if (r4 != null) goto L12;
        r0 = r0 + 1;
        goto L9
    L12:
        return r4;
    L18:
        return null;
    L14:
        return null;
    }

    private final int getHeaderVisibleContentBottom() {
        Integer[] r0 = new Integer[3];
        GlobalMemoryFragmentBinding r1 = this.binding;
        GlobalMemoryFragmentBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        LinearLayout r3 = r1.titleBarLayout;
        Intrinsics.checkNotNullExpressionValue(r3, "titleBarLayout");
        r0[0] = Integer.valueOf(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")));
        GlobalMemoryFragmentBinding r4 = this.binding;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L8:
        OUILinearLayout r5 = r4.sourceFilterGroup;
        Intrinsics.checkNotNullExpressionValue(r5, "sourceFilterGroup");
        r0[1] = Integer.valueOf(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin")));
        GlobalMemoryFragmentBinding r7 = this.binding;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        OTabLayout r6 = r2.rvSourceFilter;
        Intrinsics.checkNotNullExpressionValue(r6, "rvSourceFilter");
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

    private final String getSourceTabTitle(MemorySourceFilter r1) {
        return r1.getDisplayTitle();
    }

    /* JADX INFO: renamed from: lambda$-VO15KEBchTSCV34wo8aAPhTdY0, reason: not valid java name */
    public static /* synthetic */ void m874lambda$VO15KEBchTSCV34wo8aAPhTdY0(GlobalMemoryTabFragment r0, View r1) {
        applyTitleBarState$lambda$30$lambda$27(r0, r1);
    }

    public static /* synthetic */ void lambda$4bwWgaMuqAn8xcgVl6_H0eQvNMQ(GlobalMemoryTabFragment r0, View r1) {
        applyTitleBarState$lambda$30$lambda$29(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$AWKFPS-NJoSbRdyBK74WLdcjhJ0, reason: not valid java name */
    public static /* synthetic */ void m875lambda$AWKFPSNJoSbRdyBK74WLdcjhJ0(GlobalMemoryTabFragment r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        setupHeaderLayoutRefresh$lambda$44(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: lambda$CNrvsiw_qn7Yt-Mrr3c3ZxugpyE, reason: not valid java name */
    public static /* synthetic */ void m876lambda$CNrvsiw_qn7YtMrr3c3ZxugpyE(GlobalMemoryTabFragment r0, View r1) {
        setupSourceFilterBar$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$DePwl5ykW6ofSde7D-DTxp41qP8, reason: not valid java name */
    public static /* synthetic */ void m877lambda$DePwl5ykW6ofSde7DDTxp41qP8(GlobalMemoryTabFragment r0) {
        updateSourceFilterGroupVisibility$lambda$21(r0);
    }

    public static /* synthetic */ Unit lambda$HvlYayn8u7piT5eSB7nkDuYKvXY(GlobalMemoryTabFragment r0) {
        return setupHeaderLayoutRefresh$lambda$44$lambda$43(r0);
    }

    /* JADX INFO: renamed from: lambda$YJNkYMI4GCIvjUgv2RNOC-CvZ_4, reason: not valid java name */
    public static /* synthetic */ Unit m878lambda$YJNkYMI4GCIvjUgv2RNOCCvZ_4(int r0, GlobalMemoryTabFragment r1, View r2, boolean r3) {
        return scheduleRecyclerViewTopPaddingUpdate$lambda$41(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$hBSTvDYRLjYKJamAMcv40rhNh1s(GlobalMemoryTabFragment r0, View r1) {
        setupNavigationBar$lambda$50(r0, r1);
    }

    public static /* synthetic */ void lambda$hL341r0GR7xtFe_NcxH7rgs4y_c(GlobalMemoryTabFragment r0, int r1, String r2, OTabLayout r3) {
        finalizeSourceTabPosition$lambda$18$lambda$17(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$mg6eI7F_YoUjwTvF1Nz7hjyIRvs(GlobalMemoryTabFragment r0, View r1) {
        applyTitleBarState$lambda$30$lambda$26(r0, r1);
    }

    public static /* synthetic */ Unit lambda$o9M7qSg6GBwZQu_2LWCpgxCA7kI(GlobalMemoryTabFragment r0) {
        return updateRecyclerViewTopPadding$lambda$33(r0);
    }

    public static /* synthetic */ void lambda$pjcZU8LT8QR9wRehFpTDiZYjI3E(Context r0, View r1) {
        applyTitleBarState$lambda$30$lambda$28(r0, r1);
    }

    public static /* synthetic */ Unit lambda$qdmklwbGgVFmmfMrAJ1_jnYtchI(boolean r0, GlobalMemoryTabFragment r1, Context r2, OFloatingTitleBar r3) {
        return applyTitleBarState$lambda$30(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$xWx8mJMPDENL3NyjJRSAZzzGQrE(GlobalMemoryTabFragment r0, MemorySourceFilter r1) {
        return createSourceSheet$lambda$14(r0, r1);
    }

    private final void observeState() {
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass7(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass8(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void prepareInitialSourceState() {
        boolean r0 = ((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getGlassesLandingPending().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        this.currentSourceFilters = MemorySourceFilter.Companion.b(this.currentSourceFilters, r0);
        this.selectedSourceKey = w.f11337a.a(this.currentSourceFilters, this.restoredSourceKey, r0);
    }

    private final void scheduleRecyclerViewTopPaddingUpdate(final boolean r6) {
        final View r0 = getView();
        if (r0 != null) goto L5;
        return;
    L5:
        final int r1 = this.recyclerViewPaddingUpdateToken + 1;
        this.recyclerViewPaddingUpdateToken = r1;
        GlobalMemoryFragmentBinding r2 = this.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        LinearLayout r3 = r2.titleBarLayout;
        Intrinsics.checkNotNullExpressionValue(r3, "titleBarLayout");
        safeViewPost((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"), new $$Lambda$GlobalMemoryTabFragment$YJNkYMI4GCIvjUgv2RNOCCvZ_4(r1, this, r0, r6));
    }

    private static final Unit scheduleRecyclerViewTopPaddingUpdate$lambda$41(int r3, GlobalMemoryTabFragment r4, View r5, boolean r6) {
        if (r3 != r4.recyclerViewPaddingUpdateToken) goto L5;
        GlobalMemoryFragmentBinding r0 = r4.binding;
        GlobalMemoryFragmentBinding r1 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L9:
        r0.titleBarLayout.requestLayout();
        GlobalMemoryFragmentBinding r2 = r4.binding;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        LinearLayout r7 = r1.titleBarLayout;
        Intrinsics.checkNotNullExpressionValue(r7, "titleBarLayout");
        View r8 = (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin");
        if (ViewCompat.isLaidOut(r8) == true) goto L16;
    L22:
        r8.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new b(r3, r4, r5, r6), View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
    L24:
        return Unit.INSTANCE;
    L16:
        if (r8.isLayoutRequested() == true) goto L22;
        if (r3 != access$getRecyclerViewPaddingUpdateToken$p(r4)) goto L24;
        if (access$isCurrentFragmentView(r4, r5) == false) goto L24;
        access$updateRecyclerViewTopPadding(r4, r6);
        goto L24
    L12:
        r1 = r2;
        goto L13
    L5:
        return Unit.INSTANCE;
    }

    private final void selectPendingTargetSourceIfNeeded(List<MemorySourceFilter> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        String r0 = this.pendingTargetSourcePackage;
        if (r0 != null) goto L5;
        return;
    L5:
        Integer r2 = this.pendingTargetSourceProductType;
        if (r2 == null) goto L8;
        int r3 = r2.intValue();
    L9:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r11.hasNext() == false) goto L23;
        Object r4 = r11.next();
        MemorySourceFilter r6 = (MemorySourceFilter) ZeusTransformUtils.preCheckCast(r4, MemorySourceFilter.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r6.getSourcePackageName(), r0) == false) goto L20;
        Integer r7 = r6.getSourceProductType();
        if (r7 == null) goto L20;
        if (r7.intValue() != r3) goto L20;
        boolean r8 = true;
    L21:
        if (r8 == false) goto L11;
    L24:
        MemorySourceFilter r12 = (MemorySourceFilter) ZeusTransformUtils.preCheckCast(r4, MemorySourceFilter.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L29;
        String r13 = r12.getStableKey();
        if (r13 == null) goto L29;
    L31:
        if (Intrinsics.areEqual(r13, MemorySourceFilter.KEY_ALL) == false) goto L35;
        getShareViewModel().setTargetCollectSourcePackage(null);
        getShareViewModel().setTargetCollectSourceProductType(null);
        AppEntity r1 = this.pendingTargetEntity;
        if (r1 == null) goto L35;
        getShareViewModel().setTargetEntity(MemoryTab.COLLECT, r1, null);
    L35:
        selectSource(r13);
        this.pendingTargetSourcePackage = null;
        this.pendingTargetSourceProductType = null;
        this.pendingTargetEntity = null;
        return;
    L29:
        r13 = MemorySourceFilter.KEY_ALL;
    L20:
        r8 = false;
        goto L21
    L23:
        r4 = null;
        goto L24
    L8:
        r3 = 0;
        goto L9
    }

    private final void selectSource(String r3) {
        u r0 = this.pagerAdapter;
        GlobalMemoryFragmentBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r0 = null;
    L5:
        int r2 = r0.a(r3);
        if (r2 >= 0) goto L8;
        return;
    L8:
        this.selectedSourceKey = r3;
        GlobalMemoryFragmentBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        r1.viewPagerMemory.a(r2, false);
        selectSourceTab(r2);
        updateCurrentSelectionTab();
        return;
    L11:
        r1 = r4;
        goto L12
    }

    private final void selectSourceTab(int r6) {
        if (r6 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return;
    L10:
        this.suppressSourceTabCallback = true;
        GlobalMemoryFragmentBinding r3 = this.binding;     // Catch: Throwable -> L17
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");     // Catch: Throwable -> L17
        r3 = null;
    L14:
        OTabLayout r4 = r3.rvSourceFilter;     // Catch: Throwable -> L17
        r4.e(r6);     // Catch: Throwable -> L17
        r4.a(r6, 0.0f, true);     // Catch: Throwable -> L17
        this.suppressSourceTabCallback = false;
        return;
    L17:
        th = move-exception;
        this.suppressSourceTabCallback = false;
        throw th;
    L5:
        if (r6 >= ((Collection) ZeusTransformUtils.preCheckCast(this.currentSourceFilters, Collection.class, "com.obric.memorydata.plugin")).size()) goto L7;
        r2 = true;
        goto L8
    }

    private final void setupHeaderLayoutRefresh() {
        View.OnLayoutChangeListener r0 = new $$Lambda$GlobalMemoryTabFragment$AWKFPSNJoSbRdyBK74WLdcjhJ0(this);
        GlobalMemoryFragmentBinding r1 = this.binding;
        GlobalMemoryFragmentBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        r1.titleBarContainer.addOnLayoutChangeListener(r0);
        GlobalMemoryFragmentBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        r3.titleBarLayout.addOnLayoutChangeListener(r0);
        GlobalMemoryFragmentBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        r4.sourceFilterGroup.addOnLayoutChangeListener(r0);
        GlobalMemoryFragmentBinding r5 = this.binding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r2.rvSourceFilter.addOnLayoutChangeListener(r0);
        return;
    L14:
        r2 = r5;
        goto L15
    }

    private static final void setupHeaderLayoutRefresh$lambda$44(final GlobalMemoryTabFragment r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        GlobalMemoryFragmentBinding r10 = null;
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L14;
        RunLog r11 = RunLog.INSTANCE;
        StringBuilder r12 = new StringBuilder().append("[OTabDiag][Global] onHeaderLayout titleBottom=");
        GlobalMemoryFragmentBinding r13 = r0.binding;
        if (r13 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L7:
        LinearLayout r14 = r13.titleBarLayout;
        Intrinsics.checkNotNullExpressionValue(r14, "titleBarLayout");
        StringBuilder r15 = r12.append(r0.bottomInRoot((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"))).append(" groupBottom=");
        GlobalMemoryFragmentBinding r16 = r0.binding;
        if (r16 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L10:
        OUILinearLayout r17 = r16.sourceFilterGroup;
        Intrinsics.checkNotNullExpressionValue(r17, "sourceFilterGroup");
        StringBuilder r18 = r15.append(r0.bottomInRoot((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin"))).append(" tabsBottom=");
        GlobalMemoryFragmentBinding r19 = r0.binding;
        if (r19 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L13:
        OTabLayout r20 = r19.rvSourceFilter;
        Intrinsics.checkNotNullExpressionValue(r20, "rvSourceFilter");
        r11.debug(TAG, r18.append(r0.bottomInRoot((View) ZeusTransformUtils.preCheckCast(r20, View.class, "com.obric.memorydata.plugin"))).toString());
    L14:
        r0.dumpHeaderDiag("onHeaderLayout");
        GlobalMemoryFragmentBinding r21 = r0.binding;
        if (r21 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L18:
        ConstraintLayout r22 = r10.getRoot();
        Intrinsics.checkNotNullExpressionValue(r22, "getRoot(...)");
        r0.safeViewPost((View) ZeusTransformUtils.preCheckCast(r22, View.class, "com.obric.memorydata.plugin"), new $$Lambda$GlobalMemoryTabFragment$HvlYayn8u7piT5eSB7nkDuYKvXY(r0));
        return;
    L17:
        r10 = r21;
        goto L18
    }

    private static final Unit setupHeaderLayoutRefresh$lambda$44$lambda$43(GlobalMemoryTabFragment r3) {
        r3.updateRecyclerViewTopPadding(((Boolean) ZeusTransformUtils.preCheckCast(r3.getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return Unit.INSTANCE;
    }

    private final void setupNavigationBar() {
        GlobalMemoryFragmentBinding r0 = this.binding;
        GlobalMemoryFragmentBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OBottomActionBarFloating r2 = r0.memoryOperationContainer;
        Intrinsics.checkNotNullExpressionValue(r2, "memoryOperationContainer");
        an.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        GlobalMemoryFragmentBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        r3.memoryDelete.setOnClickListener(new $$Lambda$GlobalMemoryTabFragment$hBSTvDYRLjYKJamAMcv40rhNh1s(this));
        GlobalMemoryFragmentBinding r5 = this.binding;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        BlurUtils.a((View) ZeusTransformUtils.preCheckCast(r1.memoryOperationContainer, View.class, "com.obric.memorydata.plugin"), BlurUtils.BlurType.PROGRESS_BLUR_UP_DOWN, TypedValue.applyDimension(1, 1, Resources.getSystem().getDisplayMetrics()), new int[0]);
        return;
    L11:
        r1 = r5;
        goto L12
    }

    private static final void setupNavigationBar$lambda$50(GlobalMemoryTabFragment r2, View r3) {
        RunLog.INSTANCE.debug(TAG, "删除");
        r2.showDeleteDialog();
    }

    private final void setupSourceFilterBar() {
        setupSourceTabs(this.currentSourceFilters);
        GlobalMemoryFragmentBinding r0 = this.binding;
        GlobalMemoryFragmentBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.sourceFilterGroup.setChangeAlphaWhenDisable(false);
        GlobalMemoryFragmentBinding r2 = this.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        r1.btnSourceFilter.setOnClickListener(new $$Lambda$GlobalMemoryTabFragment$CNrvsiw_qn7YtMrr3c3ZxugpyE(this));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private static final void setupSourceFilterBar$lambda$5(GlobalMemoryTabFragment r7, View r8) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L5;
        return;
    L5:
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r7.getShareViewModel().getMemorySourceFilters().c(), Collection.class, "com.obric.memorydata.plugin");
        if (r9.isEmpty() == false) goto L8;
        r9 = CollectionsKt.listOf(MemorySourceFilter.a.a(MemorySourceFilter.Companion, 0, 1, null));
    L8:
        List<MemorySourceFilter> r10 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        ah r0 = r7.sourceSheet;
        if (r0 != null) goto L12;
        r0 = r7.createSourceSheet();
        r7.sourceSheet = r0;
    L12:
        if (r0.a(r10, r7.selectedSourceKey) == true) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "source sheet show failed, recreate and retry", null, 4, null);
        ah r1 = r7.createSourceSheet();
        r1.a(r10, r7.selectedSourceKey);
        r7.sourceSheet = r1;
        return;
    }

    private final void setupSourceTabs(List<MemorySourceFilter> r17) {
        List<MemorySourceFilter> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        List<MemorySourceFilter> r1 = this.currentSourceFilters;
        GlobalMemoryFragmentBinding r2 = this.binding;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L5:
        MemorySourceFilter r3 = (MemorySourceFilter) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r1, r2.rvSourceFilter.getSelectedTabPosition()), MemorySourceFilter.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L8;
        String r4 = r3.getStableKey();
    L9:
        GlobalMemoryFragmentBinding r7 = this.binding;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L12:
        int r8 = r7.rvSourceFilter.getScrollX();
        GlobalMemoryFragmentBinding r9 = this.binding;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L15:
        int r11 = 0;
        if (r9.rvSourceFilter.getTabCount() != r0.size()) goto L28;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r5.iterator();
    L19:
        if (r6.hasNext() == false) goto L21;
        r10.add(((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r6.next(), MemorySourceFilter.class, "com.obric.memorydata.plugin")).getStableKey());
        goto L19
    L21:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L23:
        if (r15.hasNext() == false) goto L26;
        r14.add(((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r15.next(), MemorySourceFilter.class, "com.obric.memorydata.plugin")).getStableKey());
        goto L23
    L26:
        if (Intrinsics.areEqual(r12, (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin")) == false) goto L28;
        boolean r16 = true;
    L29:
        this.currentSourceFilters = r0;
        GlobalMemoryFragmentBinding r18 = this.binding;
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L32:
        OTabLayout r19 = r18.rvSourceFilter;
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L38;
        RunLog r20 = RunLog.INSTANCE;
        StringBuilder r21 = new StringBuilder().append("[OTabDiag][Global] setupSourceTabs count=").append(r0.size()).append(" selected=").append(this.selectedSourceKey).append(" groupH=");
        GlobalMemoryFragmentBinding r110 = this.binding;
        if (r110 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L37:
        r20.debug(TAG, r21.append(r110.sourceFilterGroup.getHeight()).append(" tabsH=").append(r19.getHeight()).append(" updateInPlace=").append(r16).append(" scrollX=").append(r8).toString());
    L38:
        if (r16 == false) goto L49;
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r23 = 0;
    L41:
        if (r22.hasNext() == false) goto L54;
        Object r24 = r22.next();
        int r111 = r23 + 1;
        if (r23 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        MemorySourceFilter r25 = (MemorySourceFilter) ZeusTransformUtils.preCheckCast(r24, MemorySourceFilter.class, "com.obric.memorydata.plugin");
        OTabLayoutBase.g r26 = r19.c(r23);
        if (r26 == null) goto L48;
        r26.a((CharSequence) ZeusTransformUtils.preCheckCast(getSourceTabTitle(r25), CharSequence.class, "com.obric.memorydata.plugin"));
    L48:
        r23 = r111;
    L54:
        Intrinsics.checkNotNull(r19);
        View r27 = (View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.memorydata.plugin");
        if (ViewCompat.isLaidOut(r27) == true) goto L57;
    L90:
        r27.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new d(r16, r4, this, r19, r8), View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
        return;
    L57:
        if (r27.isLayoutRequested() == true) goto L90;
        if (r16 == false) goto L60;
    L71:
        View r28 = r19.getChildAt(0);
        if (r28 == null) goto L74;
        int r29 = r28.getWidth();
    L75:
        r19.scrollTo(RangesKt.coerceIn(r8, 0, RangesKt.coerceAtLeast(r29 - r19.getWidth(), 0)), 0);
    L77:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L89;
        RunLog r30 = RunLog.INSTANCE;
        StringBuilder r31 = new StringBuilder().append("[OTabDiag][Global] setupSourceTabs.post groupBottom=");
        GlobalMemoryFragmentBinding r32 = access$getBinding$p(this);
        if (r32 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r32 = null;
    L81:
        OUILinearLayout r33 = r32.sourceFilterGroup;
        Intrinsics.checkNotNullExpressionValue(r33, "sourceFilterGroup");
        StringBuilder r34 = r31.append(access$bottomInRoot(this, (View) ZeusTransformUtils.preCheckCast(r33, View.class, "com.obric.memorydata.plugin"))).append(" tabsBottom=");
        GlobalMemoryFragmentBinding r35 = access$getBinding$p(this);
        if (r35 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r35 = null;
    L84:
        OTabLayout r36 = r35.rvSourceFilter;
        Intrinsics.checkNotNullExpressionValue(r36, "rvSourceFilter");
        StringBuilder r37 = r34.append(access$bottomInRoot(this, (View) ZeusTransformUtils.preCheckCast(r36, View.class, "com.obric.memorydata.plugin"))).append(" tabsH=");
        GlobalMemoryFragmentBinding r38 = access$getBinding$p(this);
        if (r38 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        GlobalMemoryFragmentBinding r39 = null;
    L88:
        r30.debug(TAG, r37.append(r39.rvSourceFilter.getHeight()).append(" scrollX=").append(r19.getScrollX()).toString());
        goto L89
    L87:
        r39 = r38;
    L89:
        access$dumpHeaderDiag(this, "setupSourceTabs.post");
        access$updateRecyclerViewTopPadding(this, ((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    L74:
        r29 = r19.getWidth();
        goto L75
    L60:
        if (Intrinsics.areEqual(r4, access$getSelectedSourceKey$p(this)) == true) goto L71;
        Iterator r40 = access$getCurrentSourceFilters$p(this).iterator();
    L63:
        if (r40.hasNext() == false) goto L68;
        if (Intrinsics.areEqual(((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r40.next(), MemorySourceFilter.class, "com.obric.memorydata.plugin")).getStableKey(), access$getSelectedSourceKey$p(this)) == true) goto L69;
        r11 = r11 + 1;
    L69:
        if (r11 < 0) goto L77;
        r19.a(r11, 0.0f, true);
        goto L77
    L68:
        r11 = -1;
        goto L69
    L49:
        r19.c();
        r19.d();
        Iterator r41 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L51:
        if (r41.hasNext() == false) goto L53;
        MemorySourceFilter r42 = (MemorySourceFilter) ZeusTransformUtils.preCheckCast(r41.next(), MemorySourceFilter.class, "com.obric.memorydata.plugin");
        r19.a(r19.a(0).a((CharSequence) ZeusTransformUtils.preCheckCast(getSourceTabTitle(r42), CharSequence.class, "com.obric.memorydata.plugin")), Intrinsics.areEqual(r42.getStableKey(), this.selectedSourceKey));
        goto L51
    L53:
        r19.a((OTabLayoutBase.c) ZeusTransformUtils.preCheckCast(new c(this), OTabLayoutBase.c.class, "com.obric.memorydata.plugin"));
    L28:
        r16 = false;
        goto L29
    L8:
        r4 = null;
        goto L9
    }

    private final void setupTitleBar() {
        String r0 = getString(ZeusTransformUtils.mapRes(R.string.memory_list_all_selected_text, TypedValues.Custom.S_STRING, "memory_list_all_selected_text"));
        Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");
        this.editSelectAllText = r0;
        applyTitleBarState(((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), false);
    }

    private final void setupViewPager() {
        u r0 = new u(this);
        this.pagerAdapter = r0;
        GlobalMemoryFragmentBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r0 = null;
    L5:
        r0.a(this.currentSourceFilters);
        GlobalMemoryFragmentBinding r1 = this.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        ViewPager2 r3 = r1.viewPagerMemory;
        u r4 = this.pagerAdapter;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r4 = null;
    L11:
        r3.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r4, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        r3.setOffscreenPageLimit(3);
        r3.a((ViewPager2.e) ZeusTransformUtils.preCheckCast(new e(this), ViewPager2.e.class, "com.obric.memorydata.plugin"));
        u r5 = this.pagerAdapter;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r5 = null;
    L14:
        Integer r6 = Integer.valueOf(r5.a(this.selectedSourceKey));
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == true) goto L21;
        r6 = null;
    L21:
        if (r6 == null) goto L23;
        int r8 = r6.intValue();
    L24:
        GlobalMemoryFragmentBinding r9 = this.binding;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L28:
        r2.viewPagerMemory.a(r8, false);
        updateCurrentSelectionTab();
        return;
    L27:
        r2 = r9;
        goto L28
    L23:
        r8 = 0;
        goto L24
    L17:
        r7 = false;
        goto L18
    }

    private final void showCollectEmptyImmediately() {
        List<Fragment> r6 = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(r6, "getFragments(...)");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L17;
        View r0 = ((Fragment) ZeusTransformUtils.preCheckCast(r7.next(), Fragment.class, "com.obric.memorydata.plugin")).getView();
        if (r0 == null) goto L4;
        View r2 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.layout_empty, OaidModel.KEY_ID, "layout_empty"));
        if (r2 == null) goto L4;
        if (w.f11337a.a(r2.isLaidOut()) == false) goto L4;
        View r1 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.rv_memory_list, OaidModel.KEY_ID, "rv_memory_list"));
        if (r1 == null) goto L16;
        r1.setVisibility(8);
    L16:
        r2.setVisibility(0);
        goto L4
    }

    private final String sourceSelectionKey(MemorySourceFilter r4) {
        return SelectionStateManager.f11168a.a(new String[]{MemoryTab.COLLECT.getText(), r4.getStableKey()});
    }

    private final void stopSourceTabScroll() {
        GlobalMemoryFragmentBinding r13 = this.binding;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L5:
        OTabLayout r14 = r13.rvSourceFilter;
        Intrinsics.checkNotNullExpressionValue(r14, "rvSourceFilter");
        long r9 = SystemClock.uptimeMillis();
        float r0 = r14.getWidth() / 2.0f;
        float r11 = r14.getHeight() / 2.0f;
        MotionEvent r12 = MotionEvent.obtain(r9, r9, 0, r0, r11, 0);
        MotionEvent r1 = MotionEvent.obtain(r9, r9 + 1, 3, r0, r11, 0);
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L9
        r14.onTouchEvent(r12);     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L9
        r14.onTouchEvent(r1);     // Catch: Throwable -> L9
        r12.recycle();
        r1.recycle();
        return;
    L9:
        th = move-exception;
        r12.recycle();
        r1.recycle();
        throw th;
    }

    private final void toggleSelectText(String r3) {
        this.editSelectAllText = r3;
        if (((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        applyTitleBarState(true, true);
        return;
    }

    private final void updateCurrentSelectionTab() {
        u r0 = this.pagerAdapter;
        MemoryListActivity r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r0 = null;
    L5:
        GlobalMemoryFragmentBinding r2 = this.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        MemorySourceFilter r3 = r0.d(r2.viewPagerMemory.getCurrentItem());
        if (r3 != null) goto L11;
        r3 = MemorySourceFilter.a.a(MemorySourceFilter.Companion, 0, 1, null);
    L11:
        getShareViewModel().setSelectedCollectSourcePackage(r3.getSourcePackageName());
        getShareViewModel().setSelectedCollectSourceProductType(r3.getSourceProductType());
        getShareViewModel().setSelectedCollectSourceName(r3.getDisplayName());
        getShareViewModel().getSelectionManager().a(sourceSelectionKey(r3));
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, MemoryListActivity.class) == false) goto L14;
        r1 = (MemoryListActivity) ZeusTransformUtils.preCheckCast(r4, MemoryListActivity.class, "com.obric.memorydata.plugin");
    L14:
        if (r1 == null) goto L17;
        r1.trackContainerPageShow(MemoryContainerTab.GLOBAL_MEMORY, isResumed());
        return;
    }

    private final void updateRecyclerViewTopPadding(boolean r11) {
        int r0 = getHeaderVisibleContentBottom();
        GlobalMemoryFragmentBinding r1 = this.binding;
        GlobalMemoryFragmentBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        OBlurMaskView r3 = r1.titleBarContainer;
        Intrinsics.checkNotNullExpressionValue(r3, "titleBarContainer");
        int r4 = bottomInRoot((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        int r5 = calculateRecyclerViewTopPadding(r0, r4);
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L17;
        RunLog r7 = RunLog.INSTANCE;
        StringBuilder r12 = new StringBuilder().append("[OTabDiag][Global] updateRecyclerViewTopPadding.enter editMode=").append(r11).append(" titleBottom=");
        GlobalMemoryFragmentBinding r8 = this.binding;
        if (r8 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L10:
        LinearLayout r9 = r8.titleBarLayout;
        Intrinsics.checkNotNullExpressionValue(r9, "titleBarLayout");
        StringBuilder r13 = r12.append(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"))).append(" groupBottom=");
        GlobalMemoryFragmentBinding r10 = this.binding;
        if (r10 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L13:
        OUILinearLayout r14 = r10.sourceFilterGroup;
        Intrinsics.checkNotNullExpressionValue(r14, "sourceFilterGroup");
        StringBuilder r15 = r13.append(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"))).append(" tabsBottom=");
        GlobalMemoryFragmentBinding r16 = this.binding;
        if (r16 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L16:
        OTabLayout r17 = r16.rvSourceFilter;
        Intrinsics.checkNotNullExpressionValue(r17, "rvSourceFilter");
        r7.debug(TAG, r15.append(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin"))).append(" headerBottom=").append(r0).append(" containerBottom=").append(r4).append(" target=").append(r5).append(" current=").append(this.currentRecyclerViewTopPadding).toString());
    L17:
        GlobalMemoryFragmentBinding r18 = this.binding;
        if (r18 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        OBlurMaskView r19 = r2.titleBarContainer;
        Intrinsics.checkNotNullExpressionValue(r19, "titleBarContainer");
        safeViewPost((View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.memorydata.plugin"), new $$Lambda$GlobalMemoryTabFragment$o9M7qSg6GBwZQu_2LWCpgxCA7kI(this));
        return;
    L20:
        r2 = r18;
        goto L21
    }

    private static final Unit updateRecyclerViewTopPadding$lambda$33(GlobalMemoryTabFragment r7) {
        int r0 = r7.getHeaderVisibleContentBottom();
        GlobalMemoryFragmentBinding r1 = r7.binding;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        OBlurMaskView r2 = r1.titleBarContainer;
        Intrinsics.checkNotNullExpressionValue(r2, "titleBarContainer");
        int r3 = r7.bottomInRoot((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        int r4 = r7.calculateRecyclerViewTopPadding(r0, r3);
        if (r4 <= 0) goto L9;
        r7.currentRecyclerViewTopPadding = r4;
    L9:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L11;
        float r5 = 12;
        RunLog.INSTANCE.debug(TAG, "[OTabDiag][Global] updateRecyclerViewTopPadding.async headerBottom=" + r0 + " containerBottom=" + r3 + " headerGap=" + MathKt.roundToInt(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics())) + " containerOverlap=" + MathKt.roundToInt(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics())) + " topPadding=" + r7.currentRecyclerViewTopPadding + " visualGap=" + (r7.currentRecyclerViewTopPadding - r0) + " containerGap=" + (r7.currentRecyclerViewTopPadding - r3));
    L11:
        r7.applyRecyclerViewTopPaddingToCurrentFragments();
        return Unit.INSTANCE;
    }

    private final void updateSourceFilterEnabledState(boolean r4) {
        boolean r5 = !r4;
        GlobalMemoryFragmentBinding r0 = this.binding;
        GlobalMemoryFragmentBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.sourceFilterGroup.setEnabled(r5);
        GlobalMemoryFragmentBinding r2 = this.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        r2.btnSourceFilter.setEnabled(r5);
        GlobalMemoryFragmentBinding r3 = this.binding;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        r1.rvSourceFilter.setEnabled(r5);
        return;
    L11:
        r1 = r3;
        goto L12
    }

    private final void updateSourceFilterGroupVisibility() {
        GlobalMemoryFragmentBinding r0 = this.binding;
        GlobalMemoryFragmentBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OUILinearLayout r2 = r0.sourceFilterGroup;
        Intrinsics.checkNotNullExpressionValue(r2, "sourceFilterGroup");
        View r3 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin");
        boolean r6 = true;
        if (this.hasCollectMemory == true) goto L27;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.currentSourceFilters, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L10;
    L12:
        Iterator r5 = r4.iterator();
    L14:
        if (r5.hasNext() == false) goto L11;
        Integer r8 = ((MemorySourceFilter) ZeusTransformUtils.preCheckCast(r5.next(), MemorySourceFilter.class, "com.obric.memorydata.plugin")).getSourceProductType();
        if (r8 != null) goto L19;
    L21:
        boolean r9 = false;
    L22:
        if (r9 == false) goto L14;
        boolean r7 = true;
    L24:
        if (r7 == true) goto L27;
        boolean r10 = false;
    L28:
        if (r10 == false) goto L30;
        int r11 = 0;
    L31:
        r3.setVisibility(r11);
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L47;
        RunLog r12 = RunLog.INSTANCE;
        StringBuilder r13 = new StringBuilder().append("[OTabDiag][Global] updateSourceFilterGroupVisibility visible=");
        GlobalMemoryFragmentBinding r14 = this.binding;
        if (r14 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L36:
        OUILinearLayout r15 = r14.sourceFilterGroup;
        Intrinsics.checkNotNullExpressionValue(r15, "sourceFilterGroup");
        if (((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin")).getVisibility() == 0) goto L40;
        r6 = false;
    L40:
        StringBuilder r16 = r13.append(r6).append(" hasCollectMemory=").append(this.hasCollectMemory).append(" editMode=").append(((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue()).append(" groupBottom=");
        GlobalMemoryFragmentBinding r17 = this.binding;
        if (r17 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L43:
        OUILinearLayout r18 = r17.sourceFilterGroup;
        Intrinsics.checkNotNullExpressionValue(r18, "sourceFilterGroup");
        StringBuilder r19 = r16.append(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.memorydata.plugin"))).append(" tabsBottom=");
        GlobalMemoryFragmentBinding r20 = this.binding;
        if (r20 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L46:
        OTabLayout r21 = r20.rvSourceFilter;
        Intrinsics.checkNotNullExpressionValue(r21, "rvSourceFilter");
        r12.debug(TAG, r19.append(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.memorydata.plugin"))).toString());
    L47:
        GlobalMemoryFragmentBinding r22 = this.binding;
        if (r22 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L51:
        r1.sourceFilterGroup.post(new $$Lambda$GlobalMemoryTabFragment$DePwl5ykW6ofSde7DDTxp41qP8(this));
        return;
    L50:
        r1 = r22;
        goto L51
    L30:
        r11 = 8;
        goto L31
    L19:
        if (r8.intValue() != 20) goto L21;
        r9 = true;
    L11:
        r7 = false;
        goto L24
    L10:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L12;
    L27:
        r10 = true;
        goto L28
    }

    private static final void updateSourceFilterGroupVisibility$lambda$21(GlobalMemoryTabFragment r3) {
        r3.dumpHeaderDiag("updateSourceFilterGroupVisibility.post");
        r3.updateRecyclerViewTopPadding(((Boolean) ZeusTransformUtils.preCheckCast(r3.getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    }

    private final void updateTargetMemoryEntity() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L38;
        AppEntity r1 = (AppEntity) ZeusTransformUtils.preCheckCast(r0.getParcelable("entity"), AppEntity.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L41;
        MemoryTab r2 = com.obric.memorydata.memory.utils.f.f11537a.a(r1);
        if (r2 != MemoryTab.COLLECT) goto L39;
        Intent r3 = ((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")).getIntent();
        boolean r4 = true;
        if (r3 != null) goto L12;
    L14:
        r4 = false;
    L15:
        getShareViewModel().setForceCollectAllForTarget(r4);
        if (r4 == false) goto L19;
    L17:
        String r5 = null;
    L24:
        this.pendingTargetSourcePackage = r5;
        if (r4 == false) goto L28;
    L26:
        Integer r6 = null;
    L33:
        this.pendingTargetSourceProductType = r6;
        this.pendingTargetEntity = r1;
        getShareViewModel().setTargetCollectSourcePackage(this.pendingTargetSourcePackage);
        getShareViewModel().setTargetCollectSourceProductType(this.pendingTargetSourceProductType);
        getShareViewModel().setTargetEntity(r2, r1, null);
        if (r4 == false) goto L36;
        selectSource(MemorySourceFilter.KEY_ALL);
        return;
    L36:
        selectPendingTargetSourceIfNeeded((List) ZeusTransformUtils.preCheckCast(getShareViewModel().getMemorySourceFilters().c(), List.class, "com.obric.memorydata.plugin"));
        return;
    L28:
        if (ZeusTransformUtils.instanceOf(r1, MemoryEntity.class) == false) goto L30;
        MemoryEntity r7 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r1, MemoryEntity.class, "com.obric.memorydata.plugin");
    L31:
        if (r7 == null) goto L26;
        r6 = Integer.valueOf(MemorySourceFilter.Companion.c(r7.getProductType()));
        goto L33
    L30:
        r7 = null;
        goto L31
    L19:
        if (ZeusTransformUtils.instanceOf(r1, MemoryEntity.class) == false) goto L21;
        MemoryEntity r8 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r1, MemoryEntity.class, "com.obric.memorydata.plugin");
    L22:
        if (r8 == null) goto L17;
        r5 = r8.getSourcePackageName();
        goto L24
    L21:
        r8 = null;
        goto L22
    L12:
        if (r3.getBooleanExtra(MemoryListActivity.ARG_FORCE_COLLECT_ALL, false) != true) goto L14;
    L39:
        return;
    L41:
        return;
    }

    private final String viewDiag(View r10) {
        if (r10 != null) goto L5;
        return "null";
    L5:
        int[] r0 = new int[2];
        int[] r9 = new int[2];
        r10.getLocationInWindow(r0);
        r10.getLocationOnScreen(r9);
        ViewGroup.LayoutParams r1 = r10.getLayoutParams();
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class) == false) goto L8;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L10:
        if (r2 == null) goto L12;
        String r4 = " margin=" + r2.leftMargin + ',' + r2.topMargin + ',' + r2.rightMargin + ',' + r2.bottomMargin;
    L13:
        String r5 = "";
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        ViewParent r6 = r10.getParent();
        if (ZeusTransformUtils.instanceOf(r6, View.class) == false) goto L19;
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin");
    L20:
        if (r7 == null) goto L27;
        Class<?> r8 = r7.getClass();
        if (r8 == null) goto L27;
        String r11 = r8.getSimpleName();
        if (r11 == null) goto L27;
        r3 = r11;
    L33:
        if (ZeusTransformUtils.instanceOf(r10, ViewGroup.class) == false) goto L35;
        r5 = ",clipChildren=" + ((ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.memorydata.plugin")).getClipChildren() + ",clipToPadding=" + ((ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.memorydata.plugin")).getClipToPadding() + ",childCount=" + ((ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
    L35:
        StringBuilder r12 = new StringBuilder();
        r12.append(r10.getClass().getSimpleName()).append("@win=").append(r0[0]).append(',').append(r0[1]).append(" screen=").append(r9[0]).append(',').append(r9[1]).append(" size=").append(r10.getWidth()).append('x').append(r10.getHeight()).append(" top=").append(r10.getTop()).append(" bottom=").append(r10.getBottom()).append(" padding=").append(r10.getPaddingLeft()).append(',').append(r10.getPaddingTop()).append(',').append(r10.getPaddingRight());
        r12.append(',').append(r10.getPaddingBottom()).append(r4).append(" visible=").append(r10.getVisibility()).append(" alpha=").append(r10.getAlpha()).append(" tx=").append(r10.getTranslationX()).append(" ty=").append(r10.getTranslationY()).append(" parent=").append(r3).append(r5);
        return r12.toString();
    L27:
        ViewParent r13 = r10.getParent();
        if (r13 == null) goto L33;
        Class<?> r14 = r13.getClass();
        if (r14 == null) goto L33;
        r3 = r14.getSimpleName();
        goto L33
    L19:
        r7 = null;
        goto L20
    L12:
        r4 = null;
        goto L13
    L8:
        r2 = null;
        goto L10
    }

    public final void applyCurrentRecyclerViewTopPadding$memory_obricRelease(MemoryListFragment r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        int r3 = this.currentRecyclerViewTopPadding;
        if (r3 > 0) goto L6;
        return;
    L6:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L8;
        RunLog.INSTANCE.debug(TAG, "[OTabDiag][Global] applyCurrentRecyclerViewTopPadding.fragment topPadding=" + r3 + " fragment=" + r4);
    L8:
        r4.applyRecyclerViewTopPadding$memory_obricRelease(r3);
    }

    public final void applyCurrentRecyclerViewTopPadding$memory_obricRelease(RecyclerView r4) {
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        int r3 = this.currentRecyclerViewTopPadding;
        if (r3 > 0) goto L5;
        return;
    L5:
        if (r4.getPaddingTop() != r3) goto L8;
        return;
    L8:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L10;
        RunLog.INSTANCE.debug(TAG, "[OTabDiag][Global] applyCurrentRecyclerViewTopPadding.rv old=" + r4.getPaddingTop() + " new=" + r3 + " rvH=" + r4.getHeight() + " rvTop=" + r4.getTop());
    L10:
        r4.setPadding(r4.getPaddingLeft(), r3, r4.getPaddingRight(), r4.getPaddingBottom());
        r4.setClipToPadding(false);
    }

    @Override // com.obric.memorydata.ui.b
    public OFloatingTitleBar getCurrentFloatingTitleBar() {
        GlobalMemoryFragmentBinding r1 = this.binding;
        if (r1 == null) goto L8;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L7:
        return r1.viewTitleNormal;
    L8:
        return null;
    }

    @Override // com.obric.memorydata.ui.b
    public OFloatingTitleBarActionHost getCurrentFloatingTitleBarActionHost() {
        return com.obric.memorydata.ui.b.a.a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        GlobalMemoryFragmentBinding r5 = null;
        if (r4 == null) goto L5;
        String r6 = r4.getString(STATE_SELECTED_SOURCE);
    L6:
        this.restoredSourceKey = r6;
        GlobalMemoryFragmentBinding r7 = GlobalMemoryFragmentBinding.inflate(r2);
        Intrinsics.checkNotNullExpressionValue(r7, "inflate(...)");
        this.binding = r7;
        prepareInitialSourceState();
        this.currentRecyclerViewTopPadding = MathKt.roundToInt(TypedValue.applyDimension(1, 148, Resources.getSystem().getDisplayMetrics()));
        GlobalMemoryFragmentBinding r8 = this.binding;
        if (r8 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L9:
        r8.viewTitleNormal.setFloatingTransitionEnabled(true);
        setupTitleBar();
        setupSourceFilterBar();
        setupViewPager();
        setupNavigationBar();
        setupHeaderLayoutRefresh();
        observeState();
        updateTargetMemoryEntity();
        GlobalMemoryFragmentBinding r1 = this.binding;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L14:
        return (View) ZeusTransformUtils.preCheckCast(r5.getRoot(), View.class, "com.obric.memorydata.plugin");
    L12:
        r5 = r1;
        goto L14
    L5:
        r6 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        dismissSourceSheet("onDestroyView");
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super.onSaveInstanceState(r2);
        String r0 = this.restoredSourceKey;
        if (r0 != null) goto L5;
        r0 = this.selectedSourceKey;
    L5:
        r2.putString(STATE_SELECTED_SOURCE, r0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        dismissSourceSheetIfLocked("onStop");
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        scheduleRecyclerViewTopPaddingUpdate(false);
    }

    @Override // com.obric.memorydata.memory.ui.list.ac
    public void resetNestedViewPagerScroll() {
        GlobalMemoryFragmentBinding r1 = this.binding;
        if (r1 == null) goto L8;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L6:
        ViewPager2 r2 = r1.viewPagerMemory;
        Intrinsics.checkNotNullExpressionValue(r2, "viewPagerMemory");
        com.obric.memorydata.memory.ui.m.a(r2);
        return;
    }
}
