package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
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
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.common.oea.foundation.blur.BlurUtils;
import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.memory.databinding.FragmentMemoryPersonalListBinding;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.button.OButtonFloating;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okhttp3.HttpUrl;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002(+\u0018\u0000 \u0080\u00012\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004:\u0004\u0080\u0001\u0081\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J$\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000206H\u0002J\b\u00108\u001a\u000206H\u0002J\u0012\u00109\u001a\u0002062\b\b\u0002\u0010:\u001a\u00020\u0017H\u0002J\u0010\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020.H\u0002J\b\u0010=\u001a\u000206H\u0002J\b\u0010>\u001a\u000206H\u0002J\b\u0010?\u001a\u000206H\u0014J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020 0AH\u0002J(\u0010B\u001a\b\u0012\u0004\u0012\u00020C0A2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020F0EH\u0082@¢\u0006\u0002\u0010GJ\u0016\u0010H\u001a\u0002062\f\u0010I\u001a\b\u0012\u0004\u0012\u00020C0AH\u0002J\u0016\u0010J\u001a\u0002062\f\u0010I\u001a\b\u0012\u0004\u0012\u00020C0AH\u0002J\u0017\u0010K\u001a\u0002062\b\u0010L\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u000206H\u0002J\u0010\u0010O\u001a\u0002062\u0006\u0010P\u001a\u00020\u0017H\u0002J\u001a\u0010Q\u001a\u0002062\u0006\u0010<\u001a\u00020.2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u0010R\u001a\u0002062\u0006\u0010S\u001a\u00020 H\u0007J\b\u0010T\u001a\u000206H\u0002J\u0010\u0010U\u001a\u0002062\u0006\u0010V\u001a\u00020\u0015H\u0002J\b\u0010W\u001a\u000206H\u0002J\u000e\u0010X\u001a\u0002062\u0006\u0010Y\u001a\u00020\u0015J\u000e\u0010Z\u001a\u0002062\u0006\u0010[\u001a\u00020\\J\u0010\u0010]\u001a\u0002062\u0006\u0010^\u001a\u00020\u0017H\u0002J\b\u0010_\u001a\u000206H\u0002J\u0010\u0010`\u001a\u0002062\u0006\u0010a\u001a\u00020 H\u0002J\u0018\u0010b\u001a\u0002062\u0006\u0010c\u001a\u00020\u00172\u0006\u0010d\u001a\u00020\u0017H\u0002J\b\u0010e\u001a\u000206H\u0002J\b\u0010f\u001a\u000206H\u0002J\u0010\u0010g\u001a\u0002062\u0006\u0010c\u001a\u00020\u0017H\u0002J\u0010\u0010h\u001a\u0002062\u0006\u0010c\u001a\u00020\u0017H\u0002J\u0012\u0010i\u001a\u0004\u0018\u00010j2\u0006\u0010<\u001a\u00020.H\u0002J\u0010\u0010k\u001a\u0002062\u0006\u0010l\u001a\u00020 H\u0002J\u0012\u0010m\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u00010.H\u0002J\u0010\u0010n\u001a\u00020 2\u0006\u0010<\u001a\u000202H\u0002J\u0010\u0010o\u001a\u00020 2\u0006\u0010<\u001a\u00020.H\u0002J\u0010\u0010p\u001a\u0002062\u0006\u0010q\u001a\u00020 H\u0002J\u0010\u0010r\u001a\u0002062\u0006\u0010V\u001a\u00020\u0015H\u0002J\u0010\u0010s\u001a\u0002062\u0006\u0010t\u001a\u000204H\u0016J\b\u0010u\u001a\u000206H\u0016J\b\u0010v\u001a\u000206H\u0016J\u0010\u0010w\u001a\u0002062\u0006\u0010x\u001a\u00020\u0017H\u0016J\u0010\u0010y\u001a\u0002062\u0006\u0010z\u001a\u00020\u0017H\u0016J\b\u0010{\u001a\u0004\u0018\u00010.J\b\u0010|\u001a\u0004\u0018\u00010}J\b\u0010~\u001a\u000206H\u0016J\u0010\u0010\u007f\u001a\u0002062\u0006\u0010V\u001a\u00020\u0015H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,¨\u0006\u0082\u0001"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalTabFragment;", "Lcom/obric/memorydata/memory/ui/list/AbstractMemoryTabFragment;", "Lcom/obric/memorydata/memory/ui/list/MemoryNestedViewPagerHost;", "Lcom/obric/memorydata/ui/FloatingTitleBarOwner;", "Lcom/obric/memorydata/memory/ui/MemoryFloatingTitleBarOwner;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/FragmentMemoryPersonalListBinding;", "viewModel", "Lcom/obric/memorydata/memory/ui/list/MemoryListViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/list/MemoryListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "pendingPersonalInfoViewModel", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoViewModel;", "getPendingPersonalInfoViewModel", "()Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoViewModel;", "pendingPersonalInfoViewModel$delegate", "currentPosition", "", "initialized", "", "adapter", "Lcom/obric/memorydata/memory/ui/list/PersonalFragmentAdapter;", "jumpFromOutside", "recyclerViewPaddingUpdateToken", "pageChangeCallback", "Lcom/obric/oui/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "suppressTabCallback", "titleBarSubtitle", "", "editSelectedCount", "editSelectAllText", "formalDeleteBusy", "getCurrentFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "isExpanded", "tagsScrollableTabListener", "com/obric/memorydata/memory/ui/list/PersonalTabFragment$tagsScrollableTabListener$1", "Lcom/obric/memorydata/memory/ui/list/PersonalTabFragment$tagsScrollableTabListener$1;", "tagsFixedTabListener", "com/obric/memorydata/memory/ui/list/PersonalTabFragment$tagsFixedTabListener$1", "Lcom/obric/memorydata/memory/ui/list/PersonalTabFragment$tagsFixedTabListener$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupViewPager", "", "setupCutOffColor", "setupCutOffLayoutRefresh", "refreshCutOffHeight", "isEditMode", "bottomInRoot", "view", "updateTargetMemoryEntity", "setupNavigationBar", "showDeleteDialog", "formalDeleteSelectionKey", "", "prepareFormalDeleteItems", "Lcom/obric/memorydata/memory/ui/list/PersonalTabFragment$FormalDeleteItem;", "versions", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showFormalDeleteDialog", "items", "deleteFormalSnapshot", "refreshFormalDeleteResult", "errorMessage", "(Ljava/lang/Integer;)V", "observeState", "updateTagsEnabledState", "enabled", "onViewCreated", "initViews", LocationMonitorConst.TAG, "setupTabLayout", "onPersonalPageSelected", "position", "observeMemoryCount", "updateEditModeUI", "selectedCount", "updateSelectAllText", "state", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager$SelectAllState;", "toggleEnabled", "isEnabled", "setupTitleBar", "toggleSelectText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "applyTitleBarState", "editMode", "animate", "toggleExpand", "collapseToScrollable", "updateRecyclerViewTopPadding", "scheduleRecyclerViewTopPaddingUpdate", "findRecyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "dumpHeaderDiag", InfoRequestQPSOptTraceLogger.REASON, "viewDiag", "childDiag", "clipChain", "printStatus", "prefix", "showFragment", "onSaveInstanceState", "outState", "onDestroy", "onDestroyView", "onHiddenChanged", "hidden", "setMenuVisibility", "menuVisible", "getTitleBarContainerView", "getPersonalViewPager", "Lcom/obric/oui/viewpager2/widget/ViewPager2;", "resetNestedViewPagerScroll", "selectPersonalTabSilently", "Companion", "FormalDeleteItem", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonalTabFragment extends AbstractMemoryTabFragment implements ac, com.obric.memorydata.ui.b {
    public static final a Companion = null;
    private static final String DIAG_PREFIX = "[OTabDiag][Personal]";
    private static final String KEY_CURRENT_POSITION = "current_fragment_position";
    private static final String TAG = "PersonalTabFragment";
    private static final List<String> displayTags = null;
    private ba adapter;
    private FragmentMemoryPersonalListBinding binding;
    private int currentPosition;
    private String editSelectAllText;
    private int editSelectedCount;
    private boolean formalDeleteBusy;
    private boolean initialized;
    private boolean isExpanded;
    private boolean jumpFromOutside;
    private ViewPager2.e pageChangeCallback;
    private final Lazy pendingPersonalInfoViewModel$delegate;
    private int recyclerViewPaddingUpdateToken;
    private boolean suppressTabCallback;
    private final e tagsFixedTabListener;
    private final f tagsScrollableTabListener;
    private String titleBarSubtitle;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalTabFragment$Companion;", "", "<init>", "()V", "TAG", "", "DIAG_PREFIX", "KEY_CURRENT_POSITION", "displayTags", "", "getDisplayTags", "()Ljava/util/List;", "newInstance", "Lcom/obric/memorydata/memory/ui/list/PersonalTabFragment;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final List<String> a() {
            return PersonalTabFragment.access$getDisplayTags$cp();
        }

        public final PersonalTabFragment b() {
            return new PersonalTabFragment();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PersonalTabFragment$FormalDeleteItem;", "", "entityId", "", "changeSeq", "", "<init>", "(Ljava/lang/String;J)V", "getEntityId", "()Ljava/lang/String;", "getChangeSeq", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f11103b;

        public b(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "entityId");
            this.f11102a = r2;
            this.f11103b = r3;
        }

        public final String a() {
            return this.f11102a;
        }

        public final long b() {
            return this.f11103b;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
            return false;
        L8:
            b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11102a, r8.f11102a) == true) goto L12;
            return false;
        L12:
            if (this.f11103b == r8.f11103b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f11102a.hashCode() * 31) + Long.hashCode(this.f11103b);
        }

        public String toString() {
            return "FormalDeleteItem(entityId=" + this.f11102a + ", changeSeq=" + this.f11103b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f11104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PersonalTabFragment f11105b;
        final /* synthetic */ View c;
        final /* synthetic */ boolean d;

        public c(int r1, PersonalTabFragment r2, View r3, boolean r4) {
            this.f11104a = r1;
            this.f11105b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
            if (this.f11104a == PersonalTabFragment.access$getRecyclerViewPaddingUpdateToken$p(this.f11105b)) goto L5;
            return;
        L5:
            if (PersonalTabFragment.access$isCurrentFragmentView(this.f11105b, this.c) == false) goto L9;
            PersonalTabFragment.access$updateRecyclerViewTopPadding(this.f11105b, this.d);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/PersonalTabFragment$setupViewPager$2", "Lcom/obric/oui/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrollStateChanged", "", "state", "", "onPageSelected", "position", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends ViewPager2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PersonalTabFragment f11106a;

        d(PersonalTabFragment r1) {
            this.f11106a = r1;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
        public void a(int r1) {
            if (r1 != 1) goto L6;
            com.obric.memorydata.memory.ui.g.f10964a.a();
            return;
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
        public void b(int r2) {
            com.obric.memorydata.memory.ui.g.f10964a.a();
            PersonalTabFragment.access$onPersonalPageSelected(this.f11106a, r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalTabFragment$deleteFormalSnapshot$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalTabFragment$deleteFormalSnapshot$1", f = "PersonalTabFragment.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<b> $items;
        int label;
        final /* synthetic */ PersonalTabFragment this$0;

        AnonymousClass1(PersonalTabFragment r3, List<b> r4, Continuation<? super AnonymousClass1> r5) {
            List<b> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$items = r6;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$items, r5), Continuation.class, "com.obric.memorydata.plugin");
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
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L7
        L15:
            Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            this.this$0.getShareViewModel().getSelectionManager().j();     // Catch: Throwable -> L7
            PersonalTabFragment.access$refreshFormalDeleteResult(this.this$0, r9);     // Catch: Throwable -> L7
            PersonalTabFragment.access$setFormalDeleteBusy$p(this.this$0, false);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r8);
            CoroutineContext r10 = (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new PersonalTabFragment$deleteFormalSnapshot$1$errorMessage$1(this.$items, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            r8 = kotlinx.coroutines.i.a(r10, r2, r5);     // Catch: Throwable -> L7
            if (r8 != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            PersonalTabFragment.access$setFormalDeleteBusy$p(this.this$0, false);
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/PersonalTabFragment$tagsFixedTabListener$1", "Lcom/obric/oui/tab/OTabLayoutBase$OnTabSelectedListener;", "onTabSelected", "", "tab", "Lcom/obric/oui/tab/OTabLayoutBase$Tab;", "onTabUnselected", "onTabReselected", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements OTabLayoutBase.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PersonalTabFragment f11107a;

        e(PersonalTabFragment r1) {
            this.f11107a = r1;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void a(OTabLayoutBase.g r4) {
            if (r4 == null) goto L7;
            int r5 = r4.c();
            PersonalTabFragment.access$selectPersonalTabSilently(this.f11107a, r5);
            PersonalTabFragment.access$printStatus(this.f11107a, "tagsFixedTabListener selected: " + r5);
            PersonalTabFragment.access$showFragment(this.f11107a, r5);
            if (PersonalTabFragment.access$isExpanded$p(this.f11107a) == false) goto L8;
            PersonalTabFragment.access$collapseToScrollable(this.f11107a);
            return;
        L8:
            return;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void b(OTabLayoutBase.g r1) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void c(OTabLayoutBase.g r1) {
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/PersonalTabFragment$tagsScrollableTabListener$1", "Lcom/obric/oui/tab/OTabLayoutBase$OnTabSelectedListener;", "onTabSelected", "", "tab", "Lcom/obric/oui/tab/OTabLayoutBase$Tab;", "onTabUnselected", "onTabReselected", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements OTabLayoutBase.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PersonalTabFragment f11108a;

        f(PersonalTabFragment r1) {
            this.f11108a = r1;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void a(OTabLayoutBase.g r4) {
            if (PersonalTabFragment.access$getSuppressTabCallback$p(this.f11108a) == false) goto L5;
            return;
        L5:
            if (r4 == null) goto L12;
            int r5 = r4.c();
            if (((Boolean) ZeusTransformUtils.preCheckCast(this.f11108a.getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L10;
            PersonalTabFragment r3 = this.f11108a;
            PersonalTabFragment.access$selectPersonalTabSilently(r3, PersonalTabFragment.access$getCurrentPosition$p(r3));
            return;
        L10:
            PersonalTabFragment.access$printStatus(this.f11108a, "tagsScrollableTabListener selected: " + r5);
            PersonalTabFragment.access$showFragment(this.f11108a, r5);
            return;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void b(OTabLayoutBase.g r1) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void c(OTabLayoutBase.g r1) {
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeMemoryCount$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeMemoryCount$1", f = "PersonalTabFragment.kt", i = {}, l = {TypedValues.PositionType.TYPE_SIZE_PERCENT}, m = "invokeSuspend", n = {}, s = {})
    static final class C11741 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonalTabFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeMemoryCount$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n"}, d2 = {"<anonymous>", "", CommonConsts.COUNT_TYPE, TypedValues.CycleType.S_WAVE_PHASE, ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeMemoryCount$1$1", f = "PersonalTabFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C05841 extends SuspendLambda implements Function3<Integer, String, Continuation<? super Integer>, Object> {
            /* synthetic */ int I$0;
            /* synthetic */ Object L$0;
            int label;

            C05841(Continuation<? super C05841> r3) {
                super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
            }

            public final Object invoke(int r2, String r3, Continuation<? super Integer> r4) {
                C05841 r5 = new C05841((Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
                r5.I$0 = r2;
                r5.L$0 = r3;
                return r5.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* synthetic */ Object invoke(Integer r3, String r4, Continuation<? super Integer> r5) {
                return invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue(), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L16;
                ResultKt.throwOnFailure(r3);
                int r4 = this.I$0;
                String r2 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
                Integer r5 = Boxing.boxInt(r4);
                if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue() != 0) goto L7;
            L10:
                boolean r6 = true;
            L11:
                if (r6 == false) goto L17;
                return null;
            L17:
                return r5;
            L7:
                if (com.obric.memorydata.database.manager.q.f9592a.a(r2) == true) goto L10;
                r6 = false;
                goto L11
            L16:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C11741(PersonalTabFragment r3, Continuation<? super C11741> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11741(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11741) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11741.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            PersonalMemoryFrameDb r8 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
            kotlinx.coroutines.flow.i r9 = kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.b(r8.getSemanticMemoryDao().getInfoTypeMemoryCount(), r8.getSemanticStateDao().observeText("migration_phase"), (Function3) ZeusTransformUtils.preCheckCast(new C05841(null), Function3.class, "com.obric.memorydata.plugin")));
            final PersonalTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r9.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$1", f = "PersonalTabFragment.kt", i = {}, l = {359}, m = "invokeSuspend", n = {}, s = {})
    static final class C11751 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonalTabFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$1$1", f = "PersonalTabFragment.kt", i = {}, l = {368}, m = "invokeSuspend", n = {}, s = {})
        static final class C05851 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ PersonalTabFragment this$0;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "tab", "", "state", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoUiState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$1$1$1", f = "PersonalTabFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            static final class C05861 extends SuspendLambda implements Function3<String, az, Continuation<? super Long>, Object> {
                /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                C05861(Continuation<? super C05861> r3) {
                    super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
                }

                @Override // kotlin.jvm.functions.Function3
                public /* synthetic */ Object invoke(String r3, az r4, Continuation<? super Long> r5) {
                    return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (az) ZeusTransformUtils.preCheckCast(r4, az.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(String r2, az r3, Continuation<? super Long> r4) {
                    C05861 r5 = new C05861((Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
                    r5.L$0 = r2;
                    r5.L$1 = r3;
                    return r5.invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r5) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L15;
                    ResultKt.throwOnFailure(r5);
                    String r6 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
                    az r4 = (az) ZeusTransformUtils.preCheckCast(this.L$1, az.class, "com.obric.memorydata.plugin");
                    Long r0 = Boxing.boxLong(r4.d());
                    ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue();
                    if (Intrinsics.areEqual(r6, MemoryContainerTab.PERSONAL_MEMORY.getText()) == true) goto L7;
                L9:
                    boolean r7 = false;
                L10:
                    if (r7 == true) goto L16;
                    return null;
                L16:
                    return r0;
                L7:
                    if (r4.b() == false) goto L9;
                    r7 = true;
                    goto L10
                L15:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            C05851(PersonalTabFragment r3, Continuation<? super C05851> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C05851(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
                return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
                return ((C05851) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05851.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
                kotlinx.coroutines.flow.i r8 = kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.this$0.getShareViewModel().getSelectBottomTab(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(PersonalTabFragment.access$getPendingPersonalInfoViewModel(this.this$0).getUiState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new C05861(null), Function3.class, "com.obric.memorydata.plugin")));
                final PersonalTabFragment r4 = this.this$0;
                kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                if (r8.collect(r2, r3) != r0) goto L12;
                return r0;
            }
        }

        C11751(PersonalTabFragment r3, Continuation<? super C11751> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11751(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11751) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11751.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new C05851(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$2", f = "PersonalTabFragment.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonalTabFragment this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$2$a */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements kotlinx.coroutines.flow.i<Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i f11112a;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$2$a$1, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
            public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.j f11113a;

                public AnonymousClass1(kotlinx.coroutines.flow.j r3) {
                    this.f11113a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                }

                @Override // kotlinx.coroutines.flow.j
                public final Object emit(Object r6, Continuation r7) {
                    Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, PersonalTabFragment$observeState$2$invokeSuspend$$inlined$map$1$2$1.class) == false) goto L7;
                    PersonalTabFragment$observeState$2$invokeSuspend$$inlined$map$1$2$1 r0 = (PersonalTabFragment$observeState$2$invokeSuspend$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r8, PersonalTabFragment$observeState$2$invokeSuspend$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                    if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                    r0.label -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.result;
                    Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r3 = r0.label;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    ResultKt.throwOnFailure(r9);
                L18:
                    return Unit.INSTANCE;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    ResultKt.throwOnFailure(r9);
                    kotlinx.coroutines.flow.j r5 = this.f11113a;
                    Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                    Boolean r11 = Boxing.boxBoolean(((az) ZeusTransformUtils.preCheckCast(r6, az.class, "com.obric.memorydata.plugin")).f());
                    r0.label = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new PersonalTabFragment$observeState$2$invokeSuspend$$inlined$map$1$2$1(this, r8);
                    goto L8
                }
            }

            public a(kotlinx.coroutines.flow.i r3) {
                this.f11112a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.i
            public Object collect(kotlinx.coroutines.flow.j<? super Boolean> r3, Continuation r4) {
                kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                Object r2 = this.f11112a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
                if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r2;
            L6:
                return Unit.INSTANCE;
            }
        }

        AnonymousClass2(PersonalTabFragment r3, Continuation<? super AnonymousClass2> r4) {
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i r7 = kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(PersonalTabFragment.access$getPendingPersonalInfoViewModel(this.this$0).getUiState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"));
            final PersonalTabFragment r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$4", f = "PersonalTabFragment.kt", i = {}, l = {405}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonalTabFragment this$0;

        AnonymousClass4(PersonalTabFragment r3, Continuation<? super AnonymousClass4> r4) {
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
            kotlinx.coroutines.flow.ar<Boolean> r7 = this.this$0.getShareViewModel().getSelectionManager().b();
            final PersonalTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalTabFragment$observeState$5", f = "PersonalTabFragment.kt", i = {}, l = {423}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonalTabFragment this$0;

        AnonymousClass5(PersonalTabFragment r3, Continuation<? super AnonymousClass5> r4) {
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
            kotlinx.coroutines.flow.ar<Pair<MemoryTab, Pair<LocalDate, AppEntity>>> r7 = this.this$0.getShareViewModel().getTargetEntityFlow();
            final PersonalTabFragment r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Pair<MemoryTab, Pair<LocalDate, AppEntity>>> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalTabFragment$prepareFormalDeleteItems$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalTabFragment", f = "PersonalTabFragment.kt", i = {0}, l = {305}, m = "prepareFormalDeleteItems", n = {"versions"}, s = {"L$0"})
    static final class C11761 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PersonalTabFragment this$0;

        C11761(PersonalTabFragment r3, Continuation<? super C11761> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return PersonalTabFragment.access$prepareFormalDeleteItems(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PersonalTabFragment$showDeleteDialog$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalTabFragment$showDeleteDialog$1", f = "PersonalTabFragment.kt", i = {}, l = {284}, m = "invokeSuspend", n = {}, s = {})
    static final class C11771 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $expectedCount;
        final /* synthetic */ List<String> $selectionKey;
        final /* synthetic */ Map<String, Long> $versions;
        int label;
        final /* synthetic */ PersonalTabFragment this$0;

        C11771(List<String> r3, PersonalTabFragment r4, int r5, Map<String, Long> r6, Continuation<? super C11771> r7) {
            List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Map<String, Long> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.$selectionKey = r8;
            this.this$0 = r4;
            this.$expectedCount = r5;
            this.$versions = r9;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11771(this.$selectionKey, this.this$0, this.$expectedCount, this.$versions, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11771) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11771.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L7 SQLiteException -> L26
        L15:
            List r11 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 SQLiteException -> L26
            if (Intrinsics.areEqual(this.$selectionKey, PersonalTabFragment.access$formalDeleteSelectionKey(this.this$0)) == true) goto L18;
        L23:
            PersonalTabFragment.access$refreshFormalDeleteResult(this.this$0, Boxing.boxInt(ZeusTransformUtils.mapRes(R.string.memory_pending_changed_retry, TypedValues.Custom.S_STRING, "memory_pending_changed_retry")));     // Catch: Throwable -> L7 SQLiteException -> L26
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L7 SQLiteException -> L26
            PersonalTabFragment.access$setFormalDeleteBusy$p(this.this$0, false);
            return r12;
        L18:
            if (r11.size() != this.$expectedCount) goto L23;
            if (r11.isEmpty() == true) goto L23;
            PersonalTabFragment.access$showFormalDeleteDialog(this.this$0, r11);     // Catch: Throwable -> L7 SQLiteException -> L26
        L27:
            PersonalTabFragment.access$setFormalDeleteBusy$p(this.this$0, false);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r10);
            CoroutineContext r13 = (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 SQLiteException -> L26
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new PersonalTabFragment$showDeleteDialog$1$items$1(this.this$0, this.$versions, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 SQLiteException -> L26
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7 SQLiteException -> L26
            this.label = 1;     // Catch: Throwable -> L7 SQLiteException -> L26
            r10 = kotlinx.coroutines.i.a(r13, r2, r6);     // Catch: Throwable -> L7 SQLiteException -> L26
            if (r10 != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            PersonalTabFragment.access$setFormalDeleteBusy$p(this.this$0, false);
            throw th;
        L26:
            PersonalTabFragment.access$refreshFormalDeleteResult(this.this$0, Boxing.boxInt(ZeusTransformUtils.mapRes(R.string.memory_pending_operation_failed, TypedValues.Custom.S_STRING, "memory_pending_operation_failed")));     // Catch: Throwable -> L7
            goto L27
        }
    }

    static {
        Companion = new a(null);
        displayTags = ba.f11222a.a();
    }

    public PersonalTabFragment() {
        this.viewModel$delegate = LazyKt.lazy(new $$Lambda$PersonalTabFragment$CkMHZFDJbw8b4zMpo2zzjQAzxCs(this));
        this.pendingPersonalInfoViewModel$delegate = LazyKt.lazy(new $$Lambda$PersonalTabFragment$YvmzxTShpKpsHcwYRo3GVKppxI4(this));
        this.editSelectAllText = "";
        this.tagsScrollableTabListener = new f(this);
        this.tagsFixedTabListener = new e(this);
    }

    public static final /* synthetic */ void access$applyTitleBarState(PersonalTabFragment r0, boolean r1, boolean r2) {
        r0.applyTitleBarState(r1, r2);
    }

    public static final /* synthetic */ void access$collapseToScrollable(PersonalTabFragment r0) {
        r0.collapseToScrollable();
    }

    public static final /* synthetic */ List access$formalDeleteSelectionKey(PersonalTabFragment r0) {
        return r0.formalDeleteSelectionKey();
    }

    public static final /* synthetic */ FragmentMemoryPersonalListBinding access$getBinding$p(PersonalTabFragment r0) {
        return r0.binding;
    }

    public static final /* synthetic */ int access$getCurrentPosition$p(PersonalTabFragment r0) {
        return r0.currentPosition;
    }

    public static final /* synthetic */ List access$getDisplayTags$cp() {
        return displayTags;
    }

    public static final /* synthetic */ PendingPersonalInfoViewModel access$getPendingPersonalInfoViewModel(PersonalTabFragment r0) {
        return r0.getPendingPersonalInfoViewModel();
    }

    public static final /* synthetic */ int access$getRecyclerViewPaddingUpdateToken$p(PersonalTabFragment r0) {
        return r0.recyclerViewPaddingUpdateToken;
    }

    public static final /* synthetic */ boolean access$getSuppressTabCallback$p(PersonalTabFragment r0) {
        return r0.suppressTabCallback;
    }

    public static final /* synthetic */ boolean access$isCurrentFragmentView(PersonalTabFragment r0, View r1) {
        return r0.isCurrentFragmentView(r1);
    }

    public static final /* synthetic */ boolean access$isExpanded$p(PersonalTabFragment r0) {
        return r0.isExpanded;
    }

    public static final /* synthetic */ void access$onPersonalPageSelected(PersonalTabFragment r0, int r1) {
        r0.onPersonalPageSelected(r1);
    }

    public static final /* synthetic */ Object access$prepareFormalDeleteItems(PersonalTabFragment r2, Map r3, Continuation r4) {
        return r2.prepareFormalDeleteItems((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$printStatus(PersonalTabFragment r0, String r1) {
        r0.printStatus(r1);
    }

    public static final /* synthetic */ void access$refreshCutOffHeight(PersonalTabFragment r0, boolean r1) {
        r0.refreshCutOffHeight(r1);
    }

    public static final /* synthetic */ void access$refreshFormalDeleteResult(PersonalTabFragment r0, Integer r1) {
        r0.refreshFormalDeleteResult(r1);
    }

    public static final /* synthetic */ void access$scheduleRecyclerViewTopPaddingUpdate(PersonalTabFragment r0, boolean r1) {
        r0.scheduleRecyclerViewTopPaddingUpdate(r1);
    }

    public static final /* synthetic */ void access$selectPersonalTabSilently(PersonalTabFragment r0, int r1) {
        r0.selectPersonalTabSilently(r1);
    }

    public static final /* synthetic */ void access$setFormalDeleteBusy$p(PersonalTabFragment r0, boolean r1) {
        r0.formalDeleteBusy = r1;
    }

    public static final /* synthetic */ void access$setJumpFromOutside$p(PersonalTabFragment r0, boolean r1) {
        r0.jumpFromOutside = r1;
    }

    public static final /* synthetic */ void access$setTitleBarSubtitle$p(PersonalTabFragment r0, String r1) {
        r0.titleBarSubtitle = r1;
    }

    public static final /* synthetic */ void access$showFormalDeleteDialog(PersonalTabFragment r2, List r3) {
        r2.showFormalDeleteDialog((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$showFragment(PersonalTabFragment r0, int r1) {
        r0.showFragment(r1);
    }

    public static final /* synthetic */ void access$toggleEnabled(PersonalTabFragment r0, boolean r1) {
        r0.toggleEnabled(r1);
    }

    public static final /* synthetic */ void access$updateRecyclerViewTopPadding(PersonalTabFragment r0, boolean r1) {
        r0.updateRecyclerViewTopPadding(r1);
    }

    public static final /* synthetic */ void access$updateTagsEnabledState(PersonalTabFragment r0, boolean r1) {
        r0.updateTagsEnabledState(r1);
    }

    private final void applyTitleBarState(final boolean r10, boolean r11) {
        final Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "requireContext(...)");
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        FragmentMemoryPersonalListBinding r4 = null;
        if (ZeusTransformUtils.instanceOf(r2, MemoryListActivity.class) == false) goto L5;
        MemoryListActivity r1 = (MemoryListActivity) ZeusTransformUtils.preCheckCast(r2, MemoryListActivity.class, "com.obric.memorydata.plugin");
    L6:
        FragmentMemoryPersonalListBinding r3 = this.binding;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L9:
        OFloatingTitleBar r5 = r3.viewTitleNormal;
        boolean r6 = true;
        if (r11 == false) goto L21;
        if (r1 == null) goto L18;
        FragmentMemoryPersonalListBinding r8 = this.binding;
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
        r5.a(r6, new $$Lambda$PersonalTabFragment$CcW7Lt65tMY14i3Gh2xJUY72_E(r10, this, r0));
        FragmentMemoryPersonalListBinding r13 = this.binding;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L25:
        OFloatingTitleBar r14 = r13.viewTitleNormal;
        Intrinsics.checkNotNullExpressionValue(r14, "viewTitleNormal");
        com.obric.memorydata.ui.custom.a.a(r14);
        if (r1 == null) goto L33;
        FragmentMemoryPersonalListBinding r15 = this.binding;
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

    private static final Unit applyTitleBarState$lambda$29(boolean r8, final PersonalTabFragment r9, Context r10, OFloatingTitleBar r11) {
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
        OFloatingTitleBar.a(r11, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_close, "drawable", "o_floating_title_bar_icon_close"), 0, new $$Lambda$PersonalTabFragment$zuCmT0SilD1vzI5KEo4Q7lRsZA(r9), 2, null);
        OFloatingTitleBar.a(r11, r9.editSelectAllText, 0, new $$Lambda$PersonalTabFragment$vJ6_ARY1epna17X6KJyO9Uo6p1Y(r9), 2, null);
    L23:
        return Unit.INSTANCE;
    L21:
        OFloatingTitleBar.b(r11, ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_search, "drawable", "ic_memory_list_search"), 0, new $$Lambda$PersonalTabFragment$4EMBiTVCmSzvRA4HffQ54QXpLMA(r1), 2, null);
        OFloatingTitleBar.b(r11, ZeusTransformUtils.mapRes(R.drawable.ic_memory_detail_operation, "drawable", "ic_memory_detail_operation"), 0, new $$Lambda$PersonalTabFragment$XAccfHp3buxjfeHReqcOXHSAck(r9), 2, null);
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
        r4 = r9.getString(ZeusTransformUtils.mapRes(R.string.memory_list_personal_tab_text, TypedValues.Custom.S_STRING, "memory_list_personal_tab_text"));
        goto L6
    }

    private static final void applyTitleBarState$lambda$29$lambda$25(PersonalTabFragment r0, View r1) {
        r0.getShareViewModel().getSelectionManager().j();
    }

    private static final void applyTitleBarState$lambda$29$lambda$26(PersonalTabFragment r6, View r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "selectAllClick: selectedTag=" + r6.getShareViewModel().getSelectedTag() + ", currentTab=" + r6.getShareViewModel().getSelectionManager().g() + ", totalCount=" + r6.getShareViewModel().getSelectionManager().h(), false, 4, null);
        r6.getShareViewModel().getSelectionManager().l();
    }

    private static final void applyTitleBarState$lambda$29$lambda$27(Context r1, View r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        MemorySearchActivity.Companion.a(r3);
    }

    private static final void applyTitleBarState$lambda$29$lambda$28(PersonalTabFragment r0, View r1) {
        Intrinsics.checkNotNull(r1);
        r0.showPopupMenu(r1);
    }

    private final int bottomInRoot(View r3) {
        if (r3.getHeight() > 0) goto L6;
        return 0;
    L6:
        int[] r1 = new int[2];
        int[] r0 = new int[2];
        FragmentMemoryPersonalListBinding r2 = this.binding;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L9:
        r2.getRoot().getLocationInWindow(r1);
        r3.getLocationInWindow(r0);
        return (r0[1] - r1[1]) + r3.getHeight();
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

    private final void collapseToScrollable() {
        if (this.isExpanded == true) goto L5;
        return;
    L5:
        this.isExpanded = false;
        scheduleRecyclerViewTopPaddingUpdate(((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        printStatus("collapseToScrollable");
    }

    private final void deleteFormalSnapshot(List<b> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (this.formalDeleteBusy == false) goto L5;
        return;
    L5:
        this.formalDeleteBusy = true;
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void dumpHeaderDiag(String r13) {
        if (this.binding != null) goto L6;
        return;
    L6:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == true) goto L8;
        return;
    L8:
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder();
        StringBuilder r14 = r1.append("[OTabDiag][Personal] [HeaderCoordDiag] dump[").append(r13).append("] root=");
        FragmentMemoryPersonalListBinding r2 = this.binding;
        FragmentMemoryPersonalListBinding r3 = null;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L11:
        StringBuilder r15 = r14.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r2.getRoot(), View.class, "com.obric.memorydata.plugin"))).append(" titleContainer=");
        FragmentMemoryPersonalListBinding r4 = this.binding;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L14:
        StringBuilder r16 = r15.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r4.titleBarContainer, View.class, "com.obric.memorydata.plugin"))).append(" title=");
        FragmentMemoryPersonalListBinding r5 = this.binding;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L17:
        StringBuilder r17 = r16.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r5.titleBarLayout, View.class, "com.obric.memorydata.plugin"))).append(" titleNormal=");
        FragmentMemoryPersonalListBinding r6 = this.binding;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L20:
        StringBuilder r18 = r17.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r6.viewTitleNormal, View.class, "com.obric.memorydata.plugin"))).append(" titleNormalInner=");
        FragmentMemoryPersonalListBinding r7 = this.binding;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L23:
        StringBuilder r19 = r18.append(viewDiag(r7.viewTitleNormal.findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, OaidModel.KEY_ID, "title_bar_container")))).append(" titleNormalStart=");
        FragmentMemoryPersonalListBinding r8 = this.binding;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L26:
        StringBuilder r110 = r19.append(viewDiag(r8.viewTitleNormal.findViewById(ZeusTransformUtils.mapRes(R.id.start_title_container, OaidModel.KEY_ID, "start_title_container")))).append(" group=");
        FragmentMemoryPersonalListBinding r9 = this.binding;
        if (r9 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L29:
        StringBuilder r111 = r110.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r9.tagsContainerCollapse, View.class, "com.obric.memorydata.plugin"))).append(" tabs=");
        FragmentMemoryPersonalListBinding r10 = this.binding;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L32:
        StringBuilder r112 = r111.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r10.memoryPersonalTagsScrollable, View.class, "com.obric.memorydata.plugin"))).append(" cutOff=");
        FragmentMemoryPersonalListBinding r11 = this.binding;
        if (r11 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L35:
        StringBuilder r113 = r112.append(viewDiag(r11.cutOff)).append(" pager=");
        FragmentMemoryPersonalListBinding r12 = this.binding;
        if (r12 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L38:
        r113.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r12.personalFragmentContainer, View.class, "com.obric.memorydata.plugin"))).append(" operation=");
        FragmentMemoryPersonalListBinding r114 = this.binding;
        if (r114 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L41:
        StringBuilder r115 = r1.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r114.memoryOperationContainer, View.class, "com.obric.memorydata.plugin"))).append(" contentBottom=");
        Integer[] r20 = new Integer[4];
        FragmentMemoryPersonalListBinding r21 = this.binding;
        if (r21 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L44:
        int r22 = 0;
        r20[0] = Integer.valueOf(r21.titleBarContainer.getHeight());
        FragmentMemoryPersonalListBinding r23 = this.binding;
        if (r23 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L47:
        LinearLayout r24 = r23.titleBarLayout;
        Intrinsics.checkNotNullExpressionValue(r24, "titleBarLayout");
        r20[1] = Integer.valueOf(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r24, View.class, "com.obric.memorydata.plugin")));
        FragmentMemoryPersonalListBinding r25 = this.binding;
        if (r25 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r25 = null;
    L50:
        OUILinearLayout r26 = r25.tagsContainerCollapse;
        Intrinsics.checkNotNullExpressionValue(r26, "tagsContainerCollapse");
        r20[2] = Integer.valueOf(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r26, View.class, "com.obric.memorydata.plugin")));
        FragmentMemoryPersonalListBinding r27 = this.binding;
        if (r27 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r27 = null;
    L53:
        OTabLayout r28 = r27.memoryPersonalTagsScrollable;
        Intrinsics.checkNotNullExpressionValue(r28, "memoryPersonalTagsScrollable");
        r20[3] = Integer.valueOf(bottomInRoot((View) ZeusTransformUtils.preCheckCast(r28, View.class, "com.obric.memorydata.plugin")));
        Iterable r29 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r20), Iterable.class, "com.obric.memorydata.plugin");
        Collection r30 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r31 = r29.iterator();
    L55:
        if (r31.hasNext() == false) goto L62;
        Object r32 = r31.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r32, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L59;
        boolean r116 = true;
    L60:
        if (r116 == false) goto L55;
        r30.add(r32);
        goto L55
    L59:
        r116 = false;
        goto L60
    L62:
        Integer r33 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.maxOrNull((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r30, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin");
        if (r33 == null) goto L65;
        r22 = r33.intValue();
    L65:
        StringBuilder r117 = r115.append(r22).append(" tabChildren=");
        FragmentMemoryPersonalListBinding r34 = this.binding;
        if (r34 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r34 = null;
    L68:
        OTabLayout r35 = r34.memoryPersonalTagsScrollable;
        Intrinsics.checkNotNullExpressionValue(r35, "memoryPersonalTagsScrollable");
        StringBuilder r118 = r117.append(childDiag((ViewGroup) ZeusTransformUtils.preCheckCast(r35, ViewGroup.class, "com.obric.memorydata.plugin"))).append(" clipChain=");
        FragmentMemoryPersonalListBinding r36 = this.binding;
        if (r36 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L72:
        OTabLayout r37 = r3.memoryPersonalTagsScrollable;
        Intrinsics.checkNotNullExpressionValue(r37, "memoryPersonalTagsScrollable");
        r118.append(clipChain((View) ZeusTransformUtils.preCheckCast(r37, View.class, "com.obric.memorydata.plugin")));
        r0.debug(TAG, r1.toString());
        return;
    L71:
        r3 = r36;
        goto L72
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

    private final List<String> formalDeleteSelectionKey() {
        SelectionStateManager r0 = getShareViewModel().getSelectionManager();
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{getShareViewModel().getSelectedTag(), ((SelectionStateManager.SelectAllState) ZeusTransformUtils.preCheckCast(r0.c().c(), SelectionStateManager.SelectAllState.class, "com.obric.memorydata.plugin")).name(), String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r0.f().c(), Number.class, "com.obric.memorydata.plugin")).intValue())}), Collection.class, "com.obric.memorydata.plugin");
        Set<String> r1 = r0.d().keySet();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-keys>(...)");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r4.add("selected:" + ((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.plus(r9, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin");
        Set<String> r5 = r0.e().keySet();
        Intrinsics.checkNotNullExpressionValue(r5, "<get-keys>(...)");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L8:
        if (r8.hasNext() == false) goto L11;
        r7.add("deselected:" + ((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin")));
        goto L8
    L11:
        return CollectionsKt.plus(r10, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final PendingPersonalInfoViewModel getPendingPersonalInfoViewModel() {
        return (PendingPersonalInfoViewModel) ZeusTransformUtils.preCheckCast(this.pendingPersonalInfoViewModel$delegate.getValue(), PendingPersonalInfoViewModel.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void lambda$3VZwUvaobGTV0z4EPuAdBXPPp4o(PersonalTabFragment r0) {
        showFragment$lambda$41(r0);
    }

    public static /* synthetic */ void lambda$4EMBiTVCmSzvRA4HffQ54QXpLMA(Context r0, View r1) {
        applyTitleBarState$lambda$29$lambda$27(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ANOdnVIbCjPOk-u97b_Dv39aGL8, reason: not valid java name */
    public static /* synthetic */ Unit m913lambda$ANOdnVIbCjPOku97b_Dv39aGL8(int r0, PersonalTabFragment r1, View r2, boolean r3) {
        return scheduleRecyclerViewTopPaddingUpdate$lambda$35(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$CcW7Lt65tMY14i-3Gh2xJUY72_E, reason: not valid java name */
    public static /* synthetic */ Unit m914lambda$CcW7Lt65tMY14i3Gh2xJUY72_E(boolean r0, PersonalTabFragment r1, Context r2, OFloatingTitleBar r3) {
        return applyTitleBarState$lambda$29(r0, r1, r2, r3);
    }

    public static /* synthetic */ MemoryListViewModel lambda$CkMHZFDJbw8b4zMpo2zzjQAzxCs(PersonalTabFragment r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$JSg98_jN2P2qsJubiXDrThGf4OI(PersonalTabFragment r0, View r1) {
        setupNavigationBar$lambda$10(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$QR945kzZotD8QP8yFxR6Ibrjv-8, reason: not valid java name */
    public static /* synthetic */ void m915lambda$QR945kzZotD8QP8yFxR6Ibrjv8(PersonalTabFragment r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        setupCutOffLayoutRefresh$lambda$5(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: lambda$VLCsV7uxZO0ha3J-dH4Ndr9goZQ, reason: not valid java name */
    public static /* synthetic */ Unit m916lambda$VLCsV7uxZO0ha3JdH4Ndr9goZQ(DialogInterface r0, int r1) {
        return showFormalDeleteDialog$lambda$20(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$X-AccfHp3buxjfeHReqcOXHSAck, reason: not valid java name */
    public static /* synthetic */ void m917lambda$XAccfHp3buxjfeHReqcOXHSAck(PersonalTabFragment r0, View r1) {
        applyTitleBarState$lambda$29$lambda$28(r0, r1);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$XDxatATGJZzyT288cekWlZ4hBV4(View r0, WindowInsetsCompat r1) {
        return onCreateView$lambda$2(r0, r1);
    }

    public static /* synthetic */ PendingPersonalInfoViewModel lambda$YvmzxTShpKpsHcwYRo3GVKppxI4(PersonalTabFragment r0) {
        return pendingPersonalInfoViewModel_delegate$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$_0aK_bBv4LEIIK-ZI3zgxrM0AOo, reason: not valid java name */
    public static /* synthetic */ Unit m918lambda$_0aK_bBv4LEIIKZI3zgxrM0AOo(PersonalTabFragment r0, View r1, boolean r2, int r3) {
        return updateRecyclerViewTopPadding$lambda$33(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$dkP8K_SYDDVnaR3a5SNxQvNz3cQ(PersonalTabFragment r0, List r1, DialogInterface r2, int r3) {
        return showFormalDeleteDialog$lambda$21(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$lGI7XGgBU6oV1-rX-mBy7x3A6Ck, reason: not valid java name */
    public static /* synthetic */ void m919lambda$lGI7XGgBU6oV1rXmBy7x3A6Ck(PersonalTabFragment r0) {
        setupCutOffLayoutRefresh$lambda$6(r0);
    }

    public static /* synthetic */ void lambda$vJ6_ARY1epna17X6KJyO9Uo6p1Y(PersonalTabFragment r0, View r1) {
        applyTitleBarState$lambda$29$lambda$26(r0, r1);
    }

    public static /* synthetic */ void lambda$w8GL5jWAzqQ20wGgoX7XoZ8Qxhw(PersonalTabFragment r0, boolean r1) {
        refreshCutOffHeight$lambda$9(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$zuCmT0SilD1vzI5-KEo4Q7lRsZA, reason: not valid java name */
    public static /* synthetic */ void m920lambda$zuCmT0SilD1vzI5KEo4Q7lRsZA(PersonalTabFragment r0, View r1) {
        applyTitleBarState$lambda$29$lambda$25(r0, r1);
    }

    private final void observeMemoryCount() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11741(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void observeState() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11751(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        LifecycleOwner r1 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r1, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r1), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        observeMemoryCount();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(displayTags, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new PersonalTabFragment$observeState$3$1(this, r3, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        goto L4
    L6:
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final WindowInsetsCompat onCreateView$lambda$2(View r1, WindowInsetsCompat r2) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        Intrinsics.checkNotNullParameter(r2, "insets");
        return r2;
    }

    private final void onPersonalPageSelected(int r6) {
        boolean r1 = false;
        if (r6 >= 0) goto L5;
    L7:
        if (r1 == true) goto L9;
        return;
    L9:
        this.currentPosition = r6;
        getShareViewModel().setSelectedTag((String) ZeusTransformUtils.preCheckCast(displayTags.get(r6), String.class, "com.obric.memorydata.plugin"));
        selectPersonalTabSilently(r6);
        this.initialized = true;
        scheduleRecyclerViewTopPaddingUpdate(((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        FragmentActivity r7 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, MemoryListActivity.class) == false) goto L12;
        MemoryListActivity r8 = (MemoryListActivity) ZeusTransformUtils.preCheckCast(r7, MemoryListActivity.class, "com.obric.memorydata.plugin");
    L13:
        if (r8 == null) goto L16;
        r8.trackContainerPageShow(MemoryContainerTab.PERSONAL_MEMORY, isResumed());
        return;
    L16:
        return;
    L12:
        r8 = null;
        goto L13
    L5:
        if (r6 >= ((Collection) ZeusTransformUtils.preCheckCast(displayTags, Collection.class, "com.obric.memorydata.plugin")).size()) goto L7;
        r1 = true;
        goto L7
    }

    private static final PendingPersonalInfoViewModel pendingPersonalInfoViewModel_delegate$lambda$1(PersonalTabFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (PendingPersonalInfoViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(PendingPersonalInfoViewModel.class), PendingPersonalInfoViewModel.class, "com.obric.memorydata.plugin");
    }

    private final Object prepareFormalDeleteItems(Map<String, Long> r7, Continuation<? super List<b>> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, C11761.class) == false) goto L7;
        C11761 r0 = (C11761) ZeusTransformUtils.preCheckCast(r10, C11761.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = (Map) ZeusTransformUtils.preCheckCast(r0.L$0, Map.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L17:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r6.iterator();
    L19:
        if (r13.hasNext() == false) goto L21;
        r12.add(((cu) ZeusTransformUtils.preCheckCast(r13.next(), cu.class, "com.obric.memorydata.plugin")).a());
        goto L19
    L21:
        List r14 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        SemanticMemoryDao r15 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao();
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), 400), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r16.iterator();
    L23:
        if (r17.hasNext() == false) goto L25;
        CollectionsKt.addAll(r4, (Iterable) ZeusTransformUtils.preCheckCast(r15.queryByEntityIds((List) ZeusTransformUtils.preCheckCast(r17.next(), List.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        goto L23
    L25:
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r18.iterator();
    L27:
        if (r20.hasNext() == false) goto L34;
        Object r5 = r20.next();
        if (((ip) ZeusTransformUtils.preCheckCast(r5, ip.class, "com.obric.memorydata.plugin")).l() != 4.0f) goto L31;
        boolean r21 = true;
    L32:
        if (r21 == false) goto L27;
        r19.add(r5);
        goto L27
    L31:
        r21 = false;
        goto L32
    L34:
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r24 = r22.iterator();
    L36:
        if (r24.hasNext() == false) goto L43;
        ip r1 = (ip) ZeusTransformUtils.preCheckCast(r24.next(), ip.class, "com.obric.memorydata.plugin");
        String r25 = r1.getEntityId();
        Long r26 = (Long) ZeusTransformUtils.preCheckCast(r9.get(r1.getEntityId()), Long.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L40;
        long r27 = r26.longValue();
    L41:
        r23.add(new b(r25, r27));
        goto L36
    L40:
        r27 = r1.r();
        goto L41
    L43:
        return (List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r0.L$0 = r9;
        r0.label = 1;
        r11 = getEntityMetaInfo(r0);
        if (r11 != r2) goto L17;
        return r2;
    L7:
        r0 = new C11761(this, r10);
        goto L8
    }

    private final void printStatus(String r8) {
        RunLog.INSTANCE.debug(TAG, r8 + " isExpanded: " + this.isExpanded);
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r9 = new StringBuilder().append(r8).append(" Scrollable - visible: ");
        FragmentMemoryPersonalListBinding r1 = this.binding;
        FragmentMemoryPersonalListBinding r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        OTabLayout r2 = r1.memoryPersonalTagsScrollable;
        Intrinsics.checkNotNullExpressionValue(r2, "memoryPersonalTagsScrollable");
        if (((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L8;
        boolean r4 = true;
    L9:
        StringBuilder r10 = r9.append(r4).append(", selected: ");
        FragmentMemoryPersonalListBinding r7 = this.binding;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        r0.debug(TAG, r10.append(r3.memoryPersonalTagsScrollable.getSelectedTabPosition()).toString());
        return;
    L12:
        r3 = r7;
        goto L13
    L8:
        r4 = false;
        goto L9
    }

    private final void refreshCutOffHeight(final boolean r3) {
        FragmentMemoryPersonalListBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.getRoot().post(new $$Lambda$PersonalTabFragment$w8GL5jWAzqQ20wGgoX7XoZ8Qxhw(this, r3));
    }

    static /* synthetic */ void refreshCutOffHeight$default(PersonalTabFragment r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = ((Boolean) ZeusTransformUtils.preCheckCast(r0.getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        r0.refreshCutOffHeight(r1);
    }

    private static final void refreshCutOffHeight$lambda$9(PersonalTabFragment r10, boolean r11) {
        int r0 = (int) TypedValue.applyDimension(1, -8, Resources.getSystem().getDisplayMetrics());
        Integer[] r1 = new Integer[4];
        FragmentMemoryPersonalListBinding r3 = r10.binding;
        FragmentMemoryPersonalListBinding r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L5:
        r1[0] = Integer.valueOf(r3.titleBarContainer.getHeight());
        FragmentMemoryPersonalListBinding r5 = r10.binding;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L8:
        LinearLayout r6 = r5.titleBarLayout;
        Intrinsics.checkNotNullExpressionValue(r6, "titleBarLayout");
        r1[1] = Integer.valueOf(r10.bottomInRoot((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin")));
        FragmentMemoryPersonalListBinding r7 = r10.binding;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L11:
        OUILinearLayout r8 = r7.tagsContainerCollapse;
        Intrinsics.checkNotNullExpressionValue(r8, "tagsContainerCollapse");
        r1[2] = Integer.valueOf(r10.bottomInRoot((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin")));
        FragmentMemoryPersonalListBinding r9 = r10.binding;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L14:
        OTabLayout r12 = r9.memoryPersonalTagsScrollable;
        Intrinsics.checkNotNullExpressionValue(r12, "memoryPersonalTagsScrollable");
        r1[3] = Integer.valueOf(r10.bottomInRoot((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin")));
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r1), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r2.iterator();
    L16:
        if (r14.hasNext() == false) goto L23;
        Object r15 = r14.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L20;
        boolean r16 = true;
    L21:
        if (r16 == false) goto L16;
        r13.add(r15);
        goto L16
    L20:
        r16 = false;
        goto L21
    L23:
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.maxOrNull((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L49;
        int r18 = r17.intValue();
        int r19 = r18 + r0;
        if (r19 > 0) goto L29;
        return;
    L29:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L31;
        RunLog.INSTANCE.debug(TAG, "[OTabDiag][Personal] refreshCutOffHeight isEditMode=" + r11 + " contentBottom=" + r18 + " offset=" + r0 + " height=" + r19 + "px");
    L31:
        r10.dumpHeaderDiag("refreshCutOffHeight");
        FragmentMemoryPersonalListBinding r110 = r10.binding;
        if (r110 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L34:
        ViewGroup.LayoutParams r111 = r110.cutOff.getLayoutParams();
        if (r111 != null) goto L37;
        return;
    L37:
        if (r111.height == r19) goto L51;
        r111.height = r19;
        FragmentMemoryPersonalListBinding r112 = r10.binding;
        if (r112 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L42:
        r4.cutOff.setLayoutParams(r111);
        return;
    L41:
        r4 = r112;
        goto L42
    L51:
        return;
    }

    private final void refreshFormalDeleteResult(Integer r8) {
        List<Fragment> r0 = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(r0, "getFragments(...)");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if (ZeusTransformUtils.instanceOf(r4, PersonalChildFragment.class) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        ((PersonalChildFragment) ZeusTransformUtils.preCheckCast(r5.next(), PersonalChildFragment.class, "com.obric.memorydata.plugin")).refreshFormalItems$memory_obricRelease();
        goto L10
    L12:
        if (r8 == null) goto L23;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L24;
        com.obric.oui.toast.a.C0786a r7 = com.obric.oui.toast.a.f14807a;
        String r9 = getString(r8.intValue());
        Intrinsics.checkNotNullExpressionValue(r9, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r7, r6, r9, 0, 4, null);
        return;
    L24:
        return;
    }

    private final void scheduleRecyclerViewTopPaddingUpdate(final boolean r6) {
        final View r0 = getView();
        if (r0 != null) goto L5;
        return;
    L5:
        final int r1 = this.recyclerViewPaddingUpdateToken + 1;
        this.recyclerViewPaddingUpdateToken = r1;
        FragmentMemoryPersonalListBinding r2 = this.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        LinearLayout r3 = r2.titleBarLayout;
        Intrinsics.checkNotNullExpressionValue(r3, "titleBarLayout");
        safeViewPost((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"), new $$Lambda$PersonalTabFragment$ANOdnVIbCjPOku97b_Dv39aGL8(r1, this, r0, r6));
    }

    private static final Unit scheduleRecyclerViewTopPaddingUpdate$lambda$35(int r3, PersonalTabFragment r4, View r5, boolean r6) {
        if (r3 != r4.recyclerViewPaddingUpdateToken) goto L5;
        FragmentMemoryPersonalListBinding r0 = r4.binding;
        FragmentMemoryPersonalListBinding r1 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L9:
        r0.titleBarLayout.requestLayout();
        FragmentMemoryPersonalListBinding r2 = r4.binding;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        LinearLayout r7 = r1.titleBarLayout;
        Intrinsics.checkNotNullExpressionValue(r7, "titleBarLayout");
        View r8 = (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin");
        if (ViewCompat.isLaidOut(r8) == true) goto L16;
    L22:
        r8.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new c(r3, r4, r5, r6), View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
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

    private final void selectPersonalTabSilently(int r6) {
        if (r6 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return;
    L10:
        this.suppressTabCallback = true;
        FragmentMemoryPersonalListBinding r0 = this.binding;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L13:
        r0.memoryPersonalTagsScrollable.e(r6);
        this.suppressTabCallback = false;
        return;
    L5:
        if (r6 >= ((Collection) ZeusTransformUtils.preCheckCast(displayTags, Collection.class, "com.obric.memorydata.plugin")).size()) goto L7;
        r2 = true;
        goto L8
    }

    private final void setupCutOffColor() {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        FragmentMemoryPersonalListBinding r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, BaseActivity.class) == false) goto L5;
        BaseActivity r1 = (BaseActivity) ZeusTransformUtils.preCheckCast(r0, BaseActivity.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        Integer r2 = com.obric.memorydata.ui.custom.a.c((Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.OFloatingTitleBarCutoffAreaColor, "attr", "OFloatingTitleBarCutoffAreaColor"));
        if (r2 == null) goto L16;
        FragmentMemoryPersonalListBinding r5 = this.binding;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L14:
        r3.cutOff.setBackgroundColor(r2.intValue());
        return;
    L13:
        r3 = r5;
        goto L14
    L16:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void setupCutOffLayoutRefresh() {
        View.OnLayoutChangeListener r0 = new $$Lambda$PersonalTabFragment$QR945kzZotD8QP8yFxR6Ibrjv8(this);
        FragmentMemoryPersonalListBinding r1 = this.binding;
        FragmentMemoryPersonalListBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        r1.titleBarContainer.addOnLayoutChangeListener(r0);
        FragmentMemoryPersonalListBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        r3.titleBarLayout.addOnLayoutChangeListener(r0);
        FragmentMemoryPersonalListBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        r4.tagsContainerCollapse.addOnLayoutChangeListener(r0);
        FragmentMemoryPersonalListBinding r5 = this.binding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L14:
        r5.memoryPersonalTagsScrollable.addOnLayoutChangeListener(r0);
        FragmentMemoryPersonalListBinding r6 = this.binding;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L18:
        r2.getRoot().post(new $$Lambda$PersonalTabFragment$lGI7XGgBU6oV1rXmBy7x3A6Ck(this));
        return;
    L17:
        r2 = r6;
        goto L18
    }

    private static final void setupCutOffLayoutRefresh$lambda$5(PersonalTabFragment r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r0.dumpHeaderDiag("onHeaderLayout");
        refreshCutOffHeight$default(r0, false, 1, null);
    }

    private static final void setupCutOffLayoutRefresh$lambda$6(PersonalTabFragment r3) {
        refreshCutOffHeight$default(r3, false, 1, null);
    }

    private final void setupNavigationBar() {
        FragmentMemoryPersonalListBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.memoryDelete.setOnClickListener(new $$Lambda$PersonalTabFragment$JSg98_jN2P2qsJubiXDrThGf4OI(this));
    }

    private static final void setupNavigationBar$lambda$10(PersonalTabFragment r2, View r3) {
        RunLog.INSTANCE.debug(TAG, "删除");
        r2.showDeleteDialog();
    }

    private final void setupTabLayout() {
        FragmentMemoryPersonalListBinding r0 = this.binding;
        FragmentMemoryPersonalListBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.memoryPersonalTagsScrollable.c();
        FragmentMemoryPersonalListBinding r2 = this.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        r1.memoryPersonalTagsScrollable.a((OTabLayoutBase.c) ZeusTransformUtils.preCheckCast(this.tagsScrollableTabListener, OTabLayoutBase.c.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private final void setupTitleBar() {
        String r0 = getString(ZeusTransformUtils.mapRes(R.string.memory_list_all_selected_text, TypedValues.Custom.S_STRING, "memory_list_all_selected_text"));
        Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");
        this.editSelectAllText = r0;
        applyTitleBarState(((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), false);
        FragmentMemoryPersonalListBinding r1 = this.binding;
        FragmentMemoryPersonalListBinding r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        BlurUtils.a((View) ZeusTransformUtils.preCheckCast(r1.memoryOperationContainer, View.class, "com.obric.memorydata.plugin"), BlurUtils.BlurType.PROGRESS_BLUR_UP_DOWN, TypedValue.applyDimension(1, 1, Resources.getSystem().getDisplayMetrics()), new int[0]);
        FragmentMemoryPersonalListBinding r9 = this.binding;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        OBottomActionBarFloating r10 = r3.memoryOperationContainer;
        Intrinsics.checkNotNullExpressionValue(r10, "memoryOperationContainer");
        an.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        r3 = r9;
        goto L9
    }

    private final void setupViewPager() {
        FragmentMemoryPersonalListBinding r0 = this.binding;
        FragmentMemoryPersonalListBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        ViewPager2 r1 = r0.personalFragmentContainer;
        ba r3 = this.adapter;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r3 = null;
    L8:
        r1.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r3, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        r1.setOffscreenPageLimit(displayTags.size() - 1);
        r1.setUserInputEnabled(true);
        ViewPager2.e r4 = (ViewPager2.e) ZeusTransformUtils.preCheckCast(new d(this), ViewPager2.e.class, "com.obric.memorydata.plugin");
        this.pageChangeCallback = r4;
        if (r4 == null) goto L16;
        FragmentMemoryPersonalListBinding r6 = this.binding;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L14:
        r2.personalFragmentContainer.a(r4);
        return;
    L13:
        r2 = r6;
        goto L14
    }

    private final void showFormalDeleteDialog(List<b> r9) {
        final List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "requireActivity(...)");
        com.obric.oui.dialog.v2.alert.b r0 = new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin")).b(false);
        if (r10.size() <= 1) goto L5;
        String r3 = getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_title_multiple, TypedValues.Custom.S_STRING, "memory_card_delete_notice_title_multiple"), new Object[]{Integer.valueOf(r10.size())});
    L6:
        com.obric.oui.dialog.v2.alert.b r1 = com.obric.oui.dialog.v2.alert.b.a(r0, (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a(null).a(true);
        String r4 = getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_cancel, TypedValues.Custom.S_STRING, "memory_card_delete_notice_cancel"));
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        com.obric.oui.dialog.v2.alert.b r5 = r1.b((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$PersonalTabFragment$VLCsV7uxZO0ha3JdH4Ndr9goZQ.INSTANCE);
        String r6 = getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_confirm, TypedValues.Custom.S_STRING, "memory_card_delete_notice_confirm"));
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
        ((com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(r5.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$PersonalTabFragment$dkP8K_SYDDVnaR3a5SNxQvNz3cQ(this, r10)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin")).show();
        return;
    L5:
        r3 = getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_title_single, TypedValues.Custom.S_STRING, "memory_card_delete_notice_title_single"));
        goto L6
    }

    private static final Unit showFormalDeleteDialog$lambda$20(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        r3.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit showFormalDeleteDialog$lambda$21(PersonalTabFragment r1, List r2, DialogInterface r3, int r4) {
        List<b> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "dialog");
        r6.dismiss();
        r1.deleteFormalSnapshot(r5);
        return Unit.INSTANCE;
    }

    private final void showFragment(int r9) {
        if (r9 >= 0) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L10;
        return;
    L10:
        FragmentMemoryPersonalListBinding r5 = null;
        if (this.initialized == true) goto L13;
    L20:
        this.currentPosition = r9;
        getShareViewModel().setSelectedTag((String) ZeusTransformUtils.preCheckCast(displayTags.get(this.currentPosition), String.class, "com.obric.memorydata.plugin"));
        if (((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L23;
        getShareViewModel().getSelectionManager().j();
    L23:
        selectPersonalTabSilently(this.currentPosition);
        FragmentMemoryPersonalListBinding r4 = this.binding;
        if (r4 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L27:
        if (r4.personalFragmentContainer.getCurrentItem() == r9) goto L32;
        FragmentMemoryPersonalListBinding r6 = this.binding;
        if (r6 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L31:
        r6.personalFragmentContainer.a(r9, false);
    L32:
        this.initialized = true;
        FragmentActivity r10 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, MemoryListActivity.class) == false) goto L35;
        MemoryListActivity r11 = (MemoryListActivity) ZeusTransformUtils.preCheckCast(r10, MemoryListActivity.class, "com.obric.memorydata.plugin");
    L36:
        if (r11 == null) goto L38;
        r11.trackContainerPageShow(MemoryContainerTab.PERSONAL_MEMORY, isResumed());
    L38:
        FragmentMemoryPersonalListBinding r12 = this.binding;
        if (r12 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L42:
        r5.personalFragmentContainer.post(new $$Lambda$PersonalTabFragment$3VZwUvaobGTV0z4EPuAdBXPPp4o(this));
        return;
    L41:
        r5 = r12;
        goto L42
    L35:
        r11 = null;
        goto L36
    L13:
        if (r9 != this.currentPosition) goto L20;
        FragmentMemoryPersonalListBinding r7 = this.binding;
        if (r7 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L18:
        if (r7.personalFragmentContainer.getCurrentItem() != r9) goto L20;
        return;
    L5:
        if (r9 >= ((Collection) ZeusTransformUtils.preCheckCast(displayTags, Collection.class, "com.obric.memorydata.plugin")).size()) goto L7;
        r3 = true;
        goto L8
    }

    private static final void showFragment$lambda$41(PersonalTabFragment r3) {
        r3.scheduleRecyclerViewTopPaddingUpdate(((Boolean) ZeusTransformUtils.preCheckCast(r3.getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    }

    private final void toggleEnabled(boolean r1) {
        if (this.isExpanded == false) goto L6;
        toggleExpand();
        return;
    }

    private final void toggleExpand() {
        this.isExpanded = !this.isExpanded;
        scheduleRecyclerViewTopPaddingUpdate(((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        printStatus("toggleExpand");
    }

    private final void toggleSelectText(String r3) {
        this.editSelectAllText = r3;
        if (((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        applyTitleBarState(true, true);
        return;
    }

    private final void updateRecyclerViewTopPadding(final boolean r6) {
        final View r0 = getView();
        if (r0 != null) goto L5;
        return;
    L5:
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        FragmentMemoryPersonalListBinding r4 = null;
        if (ZeusTransformUtils.instanceOf(r1, BaseActivity.class) == false) goto L8;
        BaseActivity r2 = (BaseActivity) ZeusTransformUtils.preCheckCast(r1, BaseActivity.class, "com.obric.memorydata.plugin");
    L9:
        if (r2 == null) goto L16;
        FragmentMemoryPersonalListBinding r3 = this.binding;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L14:
        r2.getTitleBarTotalHeightAsync((View) ZeusTransformUtils.preCheckCast(r4.titleBarLayout, View.class, "com.obric.memorydata.plugin"), new $$Lambda$PersonalTabFragment$_0aK_bBv4LEIIKZI3zgxrM0AOo(this, r0, r6));
        return;
    L13:
        r4 = r3;
        goto L14
    L16:
        return;
    L8:
        r2 = null;
        goto L9
    }

    private static final Unit updateRecyclerViewTopPadding$lambda$33(PersonalTabFragment r6, View r7, boolean r8, int r9) {
        if (r6.isCurrentFragmentView(r7) == false) goto L5;
        int r10 = ((int) TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())) + r9;
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L9;
        RunLog.INSTANCE.debug(TAG, "[OTabDiag][Personal] updateRecyclerViewTopPadding editMode=" + r8 + " totalHeight=" + r9 + " topPadding=" + r10);
    L9:
        r6.dumpHeaderDiag("updateRecyclerViewTopPadding");
        Iterator<Fragment> r11 = r6.getChildFragmentManager().getFragments().iterator();
    L11:
        if (r11.hasNext() == false) goto L21;
        View r12 = ((Fragment) ZeusTransformUtils.preCheckCast(r11.next(), Fragment.class, "com.obric.memorydata.plugin")).getView();
        if (r12 == null) goto L11;
        RecyclerView r0 = r6.findRecyclerView(r12);
        if (r0 == null) goto L18;
        r0.setPadding(r0.getPaddingLeft(), r10, r0.getPaddingRight(), r0.getPaddingBottom());
        r0.setClipToPadding(false);
    L18:
        if (ZeusTransformUtils.instanceOf(r12, ViewGroup.class) == false) goto L11;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r12, ViewGroup.class, "com.obric.memorydata.plugin")).setClipChildren(false);
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r12, ViewGroup.class, "com.obric.memorydata.plugin")).setClipToPadding(false);
        goto L11
    L21:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private final void updateTagsEnabledState(boolean r2) {
        FragmentMemoryPersonalListBinding r1 = this.binding;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        OTabLayout r3 = r1.memoryPersonalTagsScrollable;
        Intrinsics.checkNotNullExpressionValue(r3, "memoryPersonalTagsScrollable");
        r3.setEnabled(r2);
    }

    private final void updateTargetMemoryEntity() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        AppEntity r1 = (AppEntity) ZeusTransformUtils.preCheckCast(r0.getParcelable("entity"), AppEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        MemoryTab r2 = com.obric.memorydata.memory.utils.f.f11537a.a(r1);
        if (r2 != MemoryTab.PROFILE) goto L12;
        getShareViewModel().setTargetEntity(r2, r1, null);
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
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

    private static final MemoryListViewModel viewModel_delegate$lambda$0(PersonalTabFragment r3) {
        return (MemoryListViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r3, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(MemoryListViewModel.class), MemoryListViewModel.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ui.b
    public OFloatingTitleBar getCurrentFloatingTitleBar() {
        FragmentMemoryPersonalListBinding r1 = this.binding;
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

    public final ViewPager2 getPersonalViewPager() {
        FragmentMemoryPersonalListBinding r1 = this.binding;
        if (r1 == null) goto L8;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L7:
        return r1.personalFragmentContainer;
    L8:
        return null;
    }

    public final View getTitleBarContainerView() {
        FragmentMemoryPersonalListBinding r2 = this.binding;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L6:
        return (View) ZeusTransformUtils.preCheckCast(r2.titleBarContainer, View.class, "com.obric.memorydata.plugin");
    }

    public final MemoryListViewModel getViewModel() {
        return (MemoryListViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), MemoryListViewModel.class, "com.obric.memorydata.plugin");
    }

    public final void initViews(String r11) {
        Intrinsics.checkNotNullParameter(r11, LocationMonitorConst.TAG);
        List<String> r0 = displayTags;
        int r1 = r0.indexOf(r11);
        this.currentPosition = r1;
        if (r1 != (-1)) goto L5;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "invalid tag: " + r11, null, 4, null);
        this.currentPosition = 0;
    L5:
        getShareViewModel().setSelectedTag((String) ZeusTransformUtils.preCheckCast(r0.get(this.currentPosition), String.class, "com.obric.memorydata.plugin"));
        this.isExpanded = false;
        selectPersonalTabSilently(this.currentPosition);
        showFragment(this.currentPosition);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        FragmentMemoryPersonalListBinding r10 = FragmentMemoryPersonalListBinding.inflate(r7, r8, false);
        Intrinsics.checkNotNullExpressionValue(r10, "inflate(...)");
        this.binding = r10;
        FragmentMemoryPersonalListBinding r0 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L5:
        r10.viewTitleNormal.setFloatingTransitionEnabled(true);
        int r11 = com.obric.memorydata.memory.ui.b.f10769a.a();
        if (r11 <= 0) goto L20;
        FragmentMemoryPersonalListBinding r1 = this.binding;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L10:
        OBlurMaskView r2 = r1.titleBarContainer;
        FragmentMemoryPersonalListBinding r3 = this.binding;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L13:
        int r4 = r3.titleBarContainer.getPaddingLeft();
        FragmentMemoryPersonalListBinding r5 = this.binding;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L16:
        int r6 = r5.titleBarContainer.getPaddingRight();
        FragmentMemoryPersonalListBinding r12 = this.binding;
        if (r12 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L19:
        r2.setPadding(r4, r11, r6, r12.titleBarContainer.getPaddingBottom());
    L20:
        FragmentMemoryPersonalListBinding r13 = this.binding;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L23:
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(r13.getRoot(), View.class, "com.obric.memorydata.plugin"), $$Lambda$PersonalTabFragment$XDxatATGJZzyT288cekWlZ4hBV4.INSTANCE);
        this.adapter = new ba((Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.memorydata.plugin"));
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(displayTags, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L25:
        if (r14.hasNext() == false) goto L33;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        FragmentMemoryPersonalListBinding r16 = this.binding;
        if (r16 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L29:
        OTabLayout r17 = r16.memoryPersonalTagsScrollable;
        FragmentMemoryPersonalListBinding r18 = this.binding;
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L32:
        r17.a(r18.memoryPersonalTagsScrollable.a(0).a((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")));
        goto L25
    L33:
        setupTabLayout();
        setupViewPager();
        this.titleBarSubtitle = null;
        setupTitleBar();
        observeState();
        setupNavigationBar();
        setupCutOffColor();
        setupCutOffLayoutRefresh();
        updateTargetMemoryEntity();
        FragmentMemoryPersonalListBinding r19 = this.binding;
        if (r19 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L37:
        ConstraintLayout r20 = r0.getRoot();
        Intrinsics.checkNotNullExpressionValue(r20, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r20, View.class, "com.obric.memorydata.plugin");
    L36:
        r0 = r19;
        goto L37
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getShareViewModel().getSelectionManager().j();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ViewPager2.e r0 = this.pageChangeCallback;
        if (r0 == null) goto L8;
        FragmentMemoryPersonalListBinding r2 = this.binding;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L7:
        r2.personalFragmentContainer.b(r0);
    L8:
        this.pageChangeCallback = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r2) {
        super.onHiddenChanged(r2);
        if (r2 == false) goto L6;
        getShareViewModel().getSelectionManager().j();
        RunLog.INSTANCE.debug(TAG, "onHiddenChanged: exitEditMode");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super.onSaveInstanceState(r2);
        r2.putInt(KEY_CURRENT_POSITION, this.currentPosition);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        FragmentMemoryPersonalListBinding r5 = this.binding;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L5:
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(r5.getRoot(), View.class, "com.obric.memorydata.plugin"));
        scheduleRecyclerViewTopPaddingUpdate(((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        if (this.jumpFromOutside == true) goto L12;
        int r6 = 0;
        if (r4 == null) goto L10;
        r6 = r4.getInt(KEY_CURRENT_POSITION, 0);
    L10:
        this.currentPosition = r6;
        RunLog.INSTANCE.debug(TAG, "currentPosition: " + this.currentPosition);
        initViews((String) ZeusTransformUtils.preCheckCast(displayTags.get(this.currentPosition), String.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // com.obric.memorydata.memory.ui.list.ac
    public void resetNestedViewPagerScroll() {
        FragmentMemoryPersonalListBinding r1 = this.binding;
        if (r1 == null) goto L8;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L6:
        ViewPager2 r2 = r1.personalFragmentContainer;
        Intrinsics.checkNotNullExpressionValue(r2, "personalFragmentContainer");
        com.obric.memorydata.memory.ui.m.a(r2);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void setMenuVisibility(boolean r3) {
        super.setMenuVisibility(r3);
        if (r3 == false) goto L5;
        return;
    L5:
        if (isAdded() == false) goto L9;
        getShareViewModel().getSelectionManager().j();
        RunLog.INSTANCE.debug(TAG, "shareViewModel: " + getShareViewModel() + ", selectionManager: " + getShareViewModel().getSelectionManager());
        RunLog.INSTANCE.debug(TAG, "setMenuVisibility: exitEditMode");
        return;
    }

    @Override // com.obric.memorydata.memory.ui.list.AbstractMemoryTabFragment
    public void showDeleteDialog() {
        if (this.formalDeleteBusy == false) goto L5;
        return;
    L5:
        List<String> r2 = formalDeleteSelectionKey();
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().f().c(), Number.class, "com.obric.memorydata.plugin")).intValue();
        List<Fragment> r0 = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(r0, "getFragments(...)");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r1.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        Object r6 = r5.next();
        if (ZeusTransformUtils.instanceOf(r6, PersonalChildFragment.class) == false) goto L7;
        r3.add(r6);
        goto L7
    L11:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        CollectionsKt.addAll(r8, (Iterable) ZeusTransformUtils.preCheckCast(((PersonalChildFragment) ZeusTransformUtils.preCheckCast(r9.next(), PersonalChildFragment.class, "com.obric.memorydata.plugin")).displayedSemanticVersions$memory_obricRelease().entrySet(), Iterable.class, "com.obric.memorydata.plugin"));
        goto L13
    L15:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r10, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L17:
        if (r12.hasNext() == false) goto L19;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Pair r14 = TuplesKt.to(r13.getKey(), r13.getValue());
        r11.put(r14.getFirst(), r14.getSecond());
        goto L17
    L19:
        this.formalDeleteBusy = true;
        LifecycleOwner r15 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r15, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r15), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11771(r2, this, r4, r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void updateEditModeUI(int r11) {
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("updateEditModeUI: selectedTag=").append(getShareViewModel().getSelectedTag()).append(", selectedCount=").append(r11).append(", deleteEnabled=");
        boolean r1 = false;
        if (r11 <= 0) goto L5;
        boolean r4 = true;
    L6:
        IRunLog.a.a(r3, TAG, r0.append(r4).toString(), false, 4, null);
        this.editSelectedCount = r11;
        if (((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L9;
        applyTitleBarState(true, true);
    L9:
        FragmentMemoryPersonalListBinding r2 = this.binding;
        FragmentMemoryPersonalListBinding r5 = null;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L12:
        OButtonFloating r6 = r2.memoryDelete;
        if (r11 <= 0) goto L15;
        boolean r7 = true;
    L16:
        r6.setEnabled(r7);
        FragmentMemoryPersonalListBinding r10 = this.binding;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L20:
        OButtonFloating r12 = r5.memoryDelete;
        if (r11 <= 0) goto L23;
        r1 = true;
    L23:
        r12.setFocusable(r1);
        return;
    L19:
        r5 = r10;
        goto L20
    L15:
        r7 = false;
        goto L16
    L5:
        r4 = false;
        goto L6
    }

    public final void updateSelectAllText(SelectionStateManager.SelectAllState r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if (r3 != SelectionStateManager.SelectAllState.ALL_SELECTED) goto L5;
        int r4 = R.string.memory_list_all_unselected_text;
        String r0 = "memory_list_all_unselected_text";
    L6:
        String r5 = getString(ZeusTransformUtils.mapRes(r4, TypedValues.Custom.S_STRING, r0));
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        toggleSelectText(r5);
        return;
    L5:
        r4 = R.string.memory_list_all_selected_text;
        r0 = "memory_list_all_selected_text";
        goto L6
    }
}
