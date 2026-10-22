package com.obric.memorydata.memory.ui.list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.activity.ComponentActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.memory.databinding.ActivityMemoryListBinding;
import com.obric.memorydata.memory.lab.AILabPermissionRepository;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel;
import com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessLaunchTargetState;
import com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineSource;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.app.UserStateManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.oui.segmentedtab.OBottomNavActionBar;
import com.obric.oui.segmentedtab.OBottomNavigationBar;
import com.obric.oui.segmentedtab.UnReadMsgView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBarActionHost;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000½\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u001d*\u0001$\b\u0016\u0018\u0000 \u008f\u00012\u00020\u0001:\u0002\u008f\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010&\u001a\u0004\u0018\u00010 H\u0016J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u00100\u001a\u00020\u001eH\u0014J\u0006\u00101\u001a\u000202J\b\u00103\u001a\u00020\u001eH\u0014J\u0012\u00104\u001a\u0002022\b\u00105\u001a\u0004\u0018\u000106H\u0014J\u0012\u00107\u001a\u0002022\b\u00108\u001a\u0004\u0018\u000109H\u0014J\u0010\u0010:\u001a\u0002022\u0006\u0010;\u001a\u000206H\u0014J\b\u0010<\u001a\u000202H\u0002J\b\u0010=\u001a\u000202H\u0002J\b\u0010>\u001a\u000202H\u0002J\u0018\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CH\u0002J\b\u0010E\u001a\u000202H\u0016J\b\u0010F\u001a\u00020\u001aH\u0016J\b\u0010G\u001a\u000202H\u0014J\b\u0010H\u001a\u000202H\u0014J&\u0010I\u001a\u0002022\u0006\u0010J\u001a\u0002092\u0014\u0010K\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010M\u0012\u0004\u0012\u0002020LH\u0002J\u0014\u0010N\u001a\u0004\u0018\u00010O2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0018\u0010P\u001a\u0002022\u0006\u0010;\u001a\u0002062\u0006\u0010Q\u001a\u00020OH\u0002J\b\u0010R\u001a\u00020OH\u0002J\u001c\u0010S\u001a\u0004\u0018\u00010\u001a2\u0006\u0010T\u001a\u00020\u001a2\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J\u0012\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010VH\u0002J\b\u0010Z\u001a\u000202H\u0002J\b\u0010[\u001a\u000202H\u0002J\b\u0010\\\u001a\u000202H\u0002J\u0016\u0010]\u001a\u0002022\u0006\u0010^\u001a\u00020\u001a2\u0006\u0010_\u001a\u00020\u001eJ\b\u0010`\u001a\u000202H\u0002J\b\u0010a\u001a\u00020*H\u0002J\u0010\u0010b\u001a\u0002022\u0006\u0010c\u001a\u00020\"H\u0002J\u0012\u0010d\u001a\u0002022\b\u0010e\u001a\u0004\u0018\u00010XH\u0002J\u0018\u0010f\u001a\u0002022\u0006\u0010e\u001a\u00020X2\b\b\u0002\u0010g\u001a\u00020\u001eJ\u0010\u0010h\u001a\u00020\u001c2\u0006\u0010e\u001a\u00020XH\u0002J\u0010\u0010i\u001a\u0002022\u0006\u0010e\u001a\u00020XH\u0002J\u0010\u0010j\u001a\u0002022\u0006\u0010^\u001a\u00020\u001aH\u0002J\u0018\u0010k\u001a\u0002022\u0006\u0010^\u001a\u00020\u001a2\u0006\u0010_\u001a\u00020\u001eH\u0002J\u0018\u0010l\u001a\u0002022\u0006\u0010^\u001a\u00020\u001a2\u0006\u0010_\u001a\u00020\u001eH\u0002J\u0012\u0010m\u001a\u00020\u001a2\b\u0010n\u001a\u0004\u0018\u00010CH\u0002J\u0010\u0010o\u001a\u00020\u001a2\u0006\u0010p\u001a\u00020\"H\u0002J\u0012\u0010q\u001a\u00020\u001a2\b\u0010r\u001a\u0004\u0018\u00010sH\u0002J\u0010\u0010t\u001a\u0002022\u0006\u0010u\u001a\u00020\"H\u0002J\u0018\u0010v\u001a\u0002022\u0006\u0010w\u001a\u00020 2\b\b\u0002\u0010x\u001a\u00020\u001eJ\u000e\u0010y\u001a\u00020\u001e2\u0006\u0010w\u001a\u00020 J\n\u0010z\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010{\u001a\u0002022\u0006\u0010u\u001a\u00020\"H\u0002J \u0010|\u001a\u0002022\u0006\u0010u\u001a\u00020\"2\u0006\u0010}\u001a\u00020\"2\u0006\u0010~\u001a\u00020\"H\u0002J\u0010\u0010\u007f\u001a\u00020\u001e2\u0006\u0010u\u001a\u00020\"H\u0002J!\u0010\u0080\u0001\u001a\u0002022\u0006\u0010u\u001a\u00020\"2\u0006\u0010}\u001a\u00020\"2\u0006\u0010~\u001a\u00020\"H\u0002J\u0012\u0010\u0081\u0001\u001a\u0002022\u0007\u0010\u0082\u0001\u001a\u00020\"H\u0002J\u0011\u0010\u0083\u0001\u001a\u0002022\u0006\u0010u\u001a\u00020\"H\u0002J\u0011\u0010\u0084\u0001\u001a\u0002022\u0006\u0010e\u001a\u00020XH\u0002J\t\u0010\u0085\u0001\u001a\u000202H\u0002J\u0012\u0010\u0086\u0001\u001a\u0002022\u0007\u0010\u0087\u0001\u001a\u00020\u001eH\u0002J\u0011\u0010\u0088\u0001\u001a\u0002022\u0006\u0010J\u001a\u000209H\u0002J\u0014\u0010\u0089\u0001\u001a\u0002022\t\b\u0002\u0010\u008a\u0001\u001a\u00020\u001eH\u0002J\t\u0010\u008b\u0001\u001a\u00020\u001eH\u0002J\t\u0010\u008c\u0001\u001a\u00020\u001eH\u0002J\u0011\u0010\u008d\u0001\u001a\u0002022\u0006\u0010_\u001a\u00020\u001eH\u0002J\t\u0010\u008e\u0001\u001a\u000202H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0090\u0001"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/ActivityMemoryListBinding;", "tabContainerPagerAdapter", "Lcom/obric/memorydata/memory/ui/list/MemoryTabContainerAdapter;", "shareViewModel", "Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "getShareViewModel", "()Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "shareViewModel$delegate", "Lkotlin/Lazy;", "autoMemoryViewModel", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryViewModel;", "getAutoMemoryViewModel", "()Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryViewModel;", "autoMemoryViewModel$delegate", "pendingPersonalInfoViewModel", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoViewModel;", "getPendingPersonalInfoViewModel", "()Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoViewModel;", "pendingPersonalInfoViewModel$delegate", "currentTabTitles", "", "", "lastPageSelection", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$PageShowParams;", "shouldShowCutOffBottom", "", "pendingSourceTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "floatingTransitionGeneration", "", "floatingTitleBarLifecycleCallbacks", "com/obric/memorydata/memory/ui/list/MemoryListActivity$floatingTitleBarLifecycleCallbacks$1", "Lcom/obric/memorydata/memory/ui/list/MemoryListActivity$floatingTitleBarLifecycleCallbacks$1;", "getCurrentFloatingTitleBar", "getCurrentFloatingTitleBarActionHost", "Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost;", "containerPageChangeCallback", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "bottomTabSelectListener", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectListener;", "globalMemoryObserverRegistered", "contextAwarenessTabVisible", "autoMemoryTaskAvailable", "skipOnCreateCustomLogic", "initStatusBar", "", "needLoginCheckOnCreate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "newIntent", "Landroid/content/Intent;", "onSaveInstanceState", "outState", "consumeGlassesLandingIntent", "setupCutOffBottomColor", "refreshCutOffBottomHeight", "cutOffBottomLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "updateCutOffBottomFromNavBar", "navBar", "Landroid/view/View;", "bgView", "onBackPressed", "getEnterFrom", "onResumeChecked", "onDestroy", "updateTargetMemoryEntity", "sourceIntent", "updateContextTarget", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineTarget;", "restoreContextAwarenessTargetSnapshot", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessLaunchTargetSnapshot;", "saveContextAwarenessTargetSnapshot", "snapshot", "consumedContextAwarenessTargetSnapshot", "getPageShowTagName", "tabName", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "getContainerTab", "Lcom/obric/memorydata/memory/ui/list/MemoryContainerTab;", "inputAppEntity", "observeState", "observeContextAwarenessTabVisibility", "changeTabVisibility", "setBottomControlsVisibleFromChild", InfoRequestQPSOptTraceLogger.REASON, "visible", "setupContainerViewPager", "createContainerPageChangeCallback", "selectBottomNavigationTab", "navigationIndex", "syncBottomNavigationSelection", "tab", "trackContainerPageShow", "reportChange", "createTabPageShowParams", "addTabFragment", "dumpActivityClipDiag", "setCutOffBottomVisibility", "setBottomTabVisibility", "viewDiag", "view", "visibilityName", "visibility", "childDiag", "viewGroup", "Landroid/view/ViewGroup;", "resetNestedViewPagerScroll", "position", "syncCurrentFloatingTitleBar", "titleBar", "animate", "handles", "currentPageTitleBar", "scheduleFloatingTitleBarTransition", "completeFloatingTitleBarTransition", PendingPersonalInfoNotificationTask.KEY_GENERATION, "attempt", "isInitialGlobalTitleBarBind", "retryFloatingTitleBarTransition", "updateContainerPagerCache", "fragmentCount", "selectContainerTab", "removeTabFragment", "refreshTabView", "renderPendingPersonalInfoBadge", "showBadge", "consumePendingPersonalInfoIntent", "refreshAutoMemoryTaskTab", "available", "isAutoMemoryTaskAvailable", "currentContextAwarenessTabVisibility", "refreshContextAwarenessTab", "selectTargetContainerTabIfNeeded", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class MemoryListActivity extends BaseMemoryActivity {
    public static final String ARG_ENTITY = "entity";
    public static final String ARG_FORCE_COLLECT_ALL = "force_collect_all";
    public static final String ARG_FROM = "from";
    public static final String ARG_OPEN_PENDING_PERSONAL_INFO = "open_pending_personal_info";
    public static final String ARG_TARGET_CONTAINER_TAB = "target_container_tab";
    public static final String ARG_TARGET_GLASSES = "target_glasses";
    public static final String ARG_TARGET_PERSONAL_TAG = "target_personal_tag";
    public static final a Companion = null;
    public static final String JUMP_FROM_DETAIL = "detail";
    private static final String JUMP_SOURCE = "jump_source";
    private static final int MAX_FLOATING_TITLE_BAR_READY_ATTEMPTS = 8;
    private static final String STATE_CONTEXT_TARGET_ENTITY_ID = "context_target_entity_id";
    private static final String STATE_CONTEXT_TARGET_REQUEST_ID = "context_target_request_id";
    private static final String STATE_CONTEXT_TARGET_SOURCE = "context_target_source";
    private static final String STATE_CONTEXT_TARGET_STATUS = "context_target_status";
    private static final String STATE_GLASSES_LANDING_PENDING = "glasses_landing_pending";
    private static final String STATE_KEEP_GLASSES = "keep_glasses_tab";
    private static final String TAG = "MemoryListActivity";
    private boolean autoMemoryTaskAvailable;
    private final Lazy autoMemoryViewModel$delegate;
    private ActivityMemoryListBinding binding;
    private OBottomNavActionBar.c bottomTabSelectListener;
    private ViewPager2.OnPageChangeCallback containerPageChangeCallback;
    private boolean contextAwarenessTabVisible;
    private final List<String> currentTabTitles;
    private final View.OnLayoutChangeListener cutOffBottomLayoutListener;
    private final MemoryListActivity$floatingTitleBarLifecycleCallbacks$1 floatingTitleBarLifecycleCallbacks;
    private int floatingTransitionGeneration;
    private boolean globalMemoryObserverRegistered;
    private MemoryEventTracker.PageShowParams lastPageSelection;
    private final Lazy pendingPersonalInfoViewModel$delegate;
    private OFloatingTitleBar pendingSourceTitleBar;
    private final Lazy shareViewModel$delegate;
    private boolean shouldShowCutOffBottom;
    private MemoryTabContainerAdapter tabContainerPagerAdapter;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005J\\\u0010$\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010%\u001a\u00020\"H\u0003JP\u0010&\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020\"H\u0003J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u0005J\u0018\u0010(\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListActivity$Companion;", "", "<init>", "()V", "ARG_FROM", "", "ARG_TARGET_GLASSES", "STATE_KEEP_GLASSES", "STATE_GLASSES_LANDING_PENDING", "ARG_ENTITY", "ARG_TARGET_CONTAINER_TAB", "ARG_FORCE_COLLECT_ALL", "ARG_TARGET_PERSONAL_TAG", "STATE_CONTEXT_TARGET_STATUS", "STATE_CONTEXT_TARGET_REQUEST_ID", "STATE_CONTEXT_TARGET_SOURCE", "STATE_CONTEXT_TARGET_ENTITY_ID", "ARG_OPEN_PENDING_PERSONAL_INFO", "TAG", "JUMP_SOURCE", "MAX_FLOATING_TITLE_BAR_READY_ATTEMPTS", "", "JUMP_FROM_DETAIL", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "entity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "enterFrom", "jumpSource", "targetTab", "Lcom/obric/memorydata/memory/ui/list/MemoryContainerTab;", "forceCollectAll", "", "targetPersonalTag", "startInternal", "openPendingPersonalInfo", "launchMemoryListActivity", "startAutoMemoryTask", "startPendingPersonalInfo", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private static final Unit a(Context r11, AppEntity r12, String r13, String r14, MemoryContainerTab r15, boolean r16, String r17, boolean r18, boolean r19) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
            if (r19 == false) goto L5;
            MemoryListActivity.Companion.a(r3, r12, r13, r14, r15, r16, r17, r18);
        L7:
            return Unit.INSTANCE;
        L5:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryListActivity.TAG, "start: privacy/login declined", false, 4, null);
            goto L7
        }

        private final void a(Context r17, final AppEntity r18, final String r19, final String r20, final MemoryContainerTab r21, final boolean r22, final String r23, final boolean r24) {
            final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryListActivity.TAG, "start, enterFrom: " + r19 + ", jumpSource: " + r20, false, 4, null);
            Integer r2 = null;
            if (ZeusTransformUtils.instanceOf(r9, Activity.class) == false) goto L5;
            Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(r9, Activity.class, "com.obric.memorydata.plugin");
        L6:
            if (r0 == null) goto L8;
            r2 = Integer.valueOf(r0.getTaskId());
        L8:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryListActivity.TAG, "start from=" + r9.getClass().getSimpleName() + ", taskId=" + r2 + ", enterFrom=" + r19 + ", jumpSource=" + r20, false, 4, null);
            if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L12;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryListActivity.TAG, "start: not agreed, request privacy and login", false, 4, null);
            UserStateManager.INSTANCE.requestAgreePrivacyAndLogin(r9, new $$Lambda$MemoryListActivity$a$6NaQ3ETtuEHIgyTz0WjUvaE4Y(r9, r18, r19, r20, r21, r22, r23, r24));
            return;
        L12:
            b(r9, r18, r19, r20, r21, r22, r23, r24);
            return;
        L5:
            r0 = null;
            goto L6
        }

        public static /* synthetic */ void a(a r9, Context r10, AppEntity r11, String r12, String r13, MemoryContainerTab r14, boolean r15, String r16, int r17, Object r18) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
            if ((r17 & 2) == 0) goto L5;
            AppEntity r3 = null;
        L7:
            if ((r17 & 8) == 0) goto L9;
            String r5 = null;
        L11:
            if ((r17 & 16) == 0) goto L13;
            MemoryContainerTab r6 = null;
        L15:
            if ((r17 & 32) == 0) goto L17;
            boolean r7 = false;
        L19:
            if ((r17 & 64) == 0) goto L21;
            String r8 = null;
        L22:
            r9.a(r2, r3, r12, r5, r6, r7, r8);
            return;
        L21:
            r8 = r16;
            goto L22
        L17:
            r7 = r15;
            goto L19
        L13:
            r6 = r14;
            goto L15
        L9:
            r5 = r13;
            goto L11
        L5:
            r3 = r11;
            goto L7
        }

        static /* synthetic */ void a(a r11, Context r12, AppEntity r13, String r14, String r15, MemoryContainerTab r16, boolean r17, String r18, boolean r19, int r20, Object r21) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
            if ((r20 & 2) == 0) goto L5;
            AppEntity r4 = null;
        L7:
            if ((r20 & 8) == 0) goto L9;
            String r6 = null;
        L11:
            if ((r20 & 16) == 0) goto L13;
            MemoryContainerTab r7 = null;
        L15:
            if ((r20 & 32) == 0) goto L17;
            boolean r8 = false;
        L19:
            if ((r20 & 64) == 0) goto L21;
            String r9 = null;
        L23:
            if ((r20 & 128) == 0) goto L25;
            boolean r10 = false;
        L26:
            r11.a(r3, r4, r14, r6, r7, r8, r9, r10);
            return;
        L25:
            r10 = r19;
            goto L26
        L21:
            r9 = r18;
            goto L23
        L17:
            r8 = r17;
            goto L19
        L13:
            r7 = r16;
            goto L15
        L9:
            r6 = r15;
            goto L11
        L5:
            r4 = r13;
            goto L7
        }

        public static /* synthetic */ void a(a r1, Context r2, String r3, int r4, Object r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            if ((r4 & 2) == 0) goto L5;
            r3 = MemoryEventTracker.SourceType.DESKTOP_ICON.getValue();
        L5:
            r1.a(r6, r3);
        }

        private final void b(Context r3, AppEntity r4, String r5, String r6, MemoryContainerTab r7, boolean r8, String r9, boolean r10) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intent r11 = new Intent(r2, MemoryListActivity.class);
            r11.addFlags(268468224);
            if (r4 == null) goto L5;
            r11.putExtra("entity", (Parcelable) ZeusTransformUtils.preCheckCast(r4, Parcelable.class, "com.obric.memorydata.plugin"));
        L5:
            r11.putExtra("from", r5);
            if (com.obric.memorydata.utils.at.a(r6) == false) goto L8;
            r11.putExtra(MemoryListActivity.JUMP_SOURCE, r6);
        L8:
            if (r7 == null) goto L10;
            r11.putExtra(MemoryListActivity.ARG_TARGET_CONTAINER_TAB, r7.name());
        L10:
            r11.putExtra(MemoryListActivity.ARG_FORCE_COLLECT_ALL, r8);
            if (r9 == null) goto L13;
            r11.putExtra(MemoryListActivity.ARG_TARGET_PERSONAL_TAG, r9);
        L13:
            r11.putExtra(MemoryListActivity.ARG_OPEN_PENDING_PERSONAL_INFO, r10);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryListActivity.TAG, "start, start Intent " + r11, false, 4, null);
            ZeusTransformUtils.startActivity(r2, r11, "com.obric.memorydata.plugin");
        }

        /* JADX INFO: renamed from: lambda$6NaQ3-ETtuEHIgyTz0WjUv-aE4Y, reason: not valid java name */
        public static /* synthetic */ Unit m887lambda$6NaQ3ETtuEHIgyTz0WjUvaE4Y(Context r0, AppEntity r1, String r2, String r3, MemoryContainerTab r4, boolean r5, String r6, boolean r7, boolean r8) {
            return a(r0, r1, r2, r3, r4, r5, r6, r7, r8);
        }

        public final void a(Context r13, AppEntity r14, String r15, String r16, MemoryContainerTab r17, boolean r18, String r19) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r15, "enterFrom");
            a(this, r2, r14, r15, r16, r17, r18, r19, false, 128, null);
        }

        public final void a(Context r11, String r12) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r12, "enterFrom");
            a(this, r1, null, r12, null, MemoryContainerTab.AUTO_MEMORY_TASK, false, null, 106, null);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11034a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f11035b = null;

        static {
            int[] r0 = new int[MemoryContainerTab.values().length];
            r0[MemoryContainerTab.CONTEXT_AWARENESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[MemoryContainerTab.AUTO_MEMORY_TASK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            r0[MemoryContainerTab.PERSONAL_MEMORY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L28:
            r0[MemoryContainerTab.GLOBAL_MEMORY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L9:
            f11034a = r0;
            int[] r1 = new int[MemoryTab.values().length];
            r1[MemoryTab.PROFILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L30:
            r1[MemoryTab.AUDIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L22:
            r1[MemoryTab.OBSERVATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L13:
            f11035b = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/memory/ui/list/MemoryListActivity$setupContainerViewPager$3", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectListener;", "onReselect", "", "position", "", "onSelect", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements OBottomNavActionBar.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemoryListActivity f11036a;

        c(MemoryListActivity r3) {
            this.f11036a = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryListActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.oui.segmentedtab.OBottomNavActionBar.c
        public void a(int r1) {
            MemoryListActivity.access$selectBottomNavigationTab(this.f11036a, r1);
        }

        @Override // com.obric.oui.segmentedtab.OBottomNavActionBar.c
        public void b(int r1) {
            MemoryListActivity.access$selectBottomNavigationTab(this.f11036a, r1);
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListActivity$observeContextAwarenessTabVisibility$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListActivity$observeContextAwarenessTabVisibility$1", f = "MemoryListActivity.kt", i = {}, l = {539}, m = "invokeSuspend", n = {}, s = {})
    static final class C11601 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryListActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListActivity$observeContextAwarenessTabVisibility$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* synthetic */ class C05701 implements FunctionAdapter, kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MemoryListActivity f11037a;

            C05701(MemoryListActivity r3) {
                this.f11037a = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryListActivity.class, "com.obric.memorydata.plugin");
            }

            public final Object a(boolean r3, Continuation<? super Unit> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                Object r2 = C11601.access$invokeSuspend$refreshContextAwarenessTab(this.f11037a, r3, r5);
                if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r2;
            L6:
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), r5);
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
                return (Function) ZeusTransformUtils.preCheckCast(new AdaptedFunctionReference(2, this.f11037a, MemoryListActivity.class, "refreshContextAwarenessTab", "refreshContextAwarenessTab(Z)V", 4), Function.class, "com.obric.memorydata.plugin");
            }

            public final int hashCode() {
                return ((FunctionAdapter) ZeusTransformUtils.preCheckCast(this, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate().hashCode();
            }
        }

        C11601(MemoryListActivity r3, Continuation<? super C11601> r4) {
            MemoryListActivity r5 = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryListActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        public static final /* synthetic */ Object access$invokeSuspend$refreshContextAwarenessTab(MemoryListActivity r2, boolean r3, Continuation r4) {
            return invokeSuspend$refreshContextAwarenessTab((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin"), r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        private static final /* synthetic */ Object invokeSuspend$refreshContextAwarenessTab(MemoryListActivity r2, boolean r3, Continuation r4) {
            MemoryListActivity r5 = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            MemoryListActivity.access$refreshContextAwarenessTab(r5, r3);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11601(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11601) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11601.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.ar<Boolean> r7 = com.obric.memorydata.memory.ui.settings.l.f11479a.a().o();
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05701(this.this$0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListActivity$observeState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListActivity$observeState$1", f = "MemoryListActivity.kt", i = {}, l = {InputDeviceCompat.SOURCE_DPAD}, m = "invokeSuspend", n = {}, s = {})
    static final class C11611 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryListActivity this$0;

        C11611(MemoryListActivity r3, Continuation<? super C11611> r4) {
            MemoryListActivity r5 = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryListActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11611(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11611) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11611.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.i<String> r7 = MemoryListActivity.access$getPendingPersonalInfoViewModel(this.this$0).getErrors();
            final MemoryListActivity r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super String> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05711(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListActivity$observeState$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListActivity$observeState$2", f = "MemoryListActivity.kt", i = {}, l = {523}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryListActivity this$0;

        AnonymousClass2(MemoryListActivity r3, Continuation<? super AnonymousClass2> r4) {
            MemoryListActivity r5 = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryListActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
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
            kotlinx.coroutines.flow.ar<Boolean> r7 = MemoryListActivity.access$getShareViewModel(this.this$0).getSelectionManager().b();
            final MemoryListActivity r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListActivity$observeState$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListActivity$observeState$3", f = "MemoryListActivity.kt", i = {}, l = {531}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryListActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListActivity$observeState$3$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* synthetic */ class AnonymousClass1 implements FunctionAdapter, kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MemoryListActivity f11040a;

            AnonymousClass1(MemoryListActivity r3) {
                this.f11040a = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryListActivity.class, "com.obric.memorydata.plugin");
            }

            public final Object a(boolean r3, Continuation<? super Unit> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                Object r2 = AnonymousClass3.access$invokeSuspend$renderPendingPersonalInfoBadge(this.f11040a, r3, r5);
                if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r2;
            L6:
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), r5);
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
                return (Function) ZeusTransformUtils.preCheckCast(new AdaptedFunctionReference(2, this.f11040a, MemoryListActivity.class, "renderPendingPersonalInfoBadge", "renderPendingPersonalInfoBadge(Z)V", 4), Function.class, "com.obric.memorydata.plugin");
            }

            public final int hashCode() {
                return ((FunctionAdapter) ZeusTransformUtils.preCheckCast(this, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate().hashCode();
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListActivity$observeState$3$a */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements kotlinx.coroutines.flow.i<Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i f11041a;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListActivity$observeState$3$a$1, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
            public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.j f11042a;

                public AnonymousClass1(kotlinx.coroutines.flow.j r3) {
                    this.f11042a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                }

                @Override // kotlinx.coroutines.flow.j
                public final Object emit(Object r6, Continuation r7) {
                    Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, MemoryListActivity$observeState$3$invokeSuspend$$inlined$map$1$2$1.class) == false) goto L7;
                    MemoryListActivity$observeState$3$invokeSuspend$$inlined$map$1$2$1 r0 = (MemoryListActivity$observeState$3$invokeSuspend$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r8, MemoryListActivity$observeState$3$invokeSuspend$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
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
                    kotlinx.coroutines.flow.j r5 = this.f11042a;
                    Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                    Boolean r11 = Boxing.boxBoolean(((az) ZeusTransformUtils.preCheckCast(r6, az.class, "com.obric.memorydata.plugin")).g());
                    r0.label = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new MemoryListActivity$observeState$3$invokeSuspend$$inlined$map$1$2$1(this, r8);
                    goto L8
                }
            }

            public a(kotlinx.coroutines.flow.i r3) {
                this.f11041a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.i
            public Object collect(kotlinx.coroutines.flow.j<? super Boolean> r3, Continuation r4) {
                kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                Object r2 = this.f11041a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
                if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r2;
            L6:
                return Unit.INSTANCE;
            }
        }

        AnonymousClass3(MemoryListActivity r3, Continuation<? super AnonymousClass3> r4) {
            MemoryListActivity r5 = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryListActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        public static final /* synthetic */ Object access$invokeSuspend$renderPendingPersonalInfoBadge(MemoryListActivity r2, boolean r3, Continuation r4) {
            return invokeSuspend$renderPendingPersonalInfoBadge((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin"), r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        private static final /* synthetic */ Object invokeSuspend$renderPendingPersonalInfoBadge(MemoryListActivity r2, boolean r3, Continuation r4) {
            MemoryListActivity r5 = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            MemoryListActivity.access$renderPendingPersonalInfoBadge(r5, r3);
            return Unit.INSTANCE;
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i r7 = kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(MemoryListActivity.access$getPendingPersonalInfoViewModel(this.this$0).getUiState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"));
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListActivity$onCreate$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListActivity$onCreate$3", f = "MemoryListActivity.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
    static final class C11623 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryListActivity this$0;

        C11623(MemoryListActivity r3, Continuation<? super C11623> r4) {
            MemoryListActivity r5 = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryListActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        private static final boolean invokeSuspend$lambda$0(com.obric.memorydata.memory.lab.d r9) {
            return AILabPermissionRepository.a(AILabPermissionRepository.f10236a, r9, null, null, null, null, null, 62, null);
        }

        public static /* synthetic */ boolean lambda$NuCWeGTeS7dVV3QrHnsPpUv88bI(com.obric.memorydata.memory.lab.d r0) {
            return invokeSuspend$lambda$0(r0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11623(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11623) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11623.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.i r7 = kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(AILabPermissionRepository.f10236a.a(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), $$Lambda$MemoryListActivity$onCreate$3$NuCWeGTeS7dVV3QrHnsPpUv88bI.INSTANCE);
            final MemoryListActivity r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListActivity$onNewIntent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class C11631 extends FunctionReferenceImpl implements Function1<com.obric.memorydata.memory.ui.list.contextawareness.v, Unit> {
        C11631(Object r8) {
            super(1, r8, MemoryListShareViewModel.class, "replaceContextAwarenessTargetFromNewIntent", "replaceContextAwarenessTargetFromNewIntent$memory_obricRelease(Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineTarget;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.memorydata.memory.ui.list.contextawareness.v r3) {
            invoke2((com.obric.memorydata.memory.ui.list.contextawareness.v) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.list.contextawareness.v.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.obric.memorydata.memory.ui.list.contextawareness.v r3) {
            ((MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(this.receiver, MemoryListShareViewModel.class, "com.obric.memorydata.plugin")).replaceContextAwarenessTargetFromNewIntent$memory_obricRelease(r3);
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX WARN: Type inference failed for: r0v30, types: [com.obric.memorydata.memory.ui.list.MemoryListActivity$floatingTitleBarLifecycleCallbacks$1] */
    public MemoryListActivity() {
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(new MemoryListActivity$special$$inlined$viewModels$default$1(r0), Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = null;
        this.shareViewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(MemoryListShareViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new MemoryListActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new MemoryListActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
        final ComponentActivity r1 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r3 = (Function0) ZeusTransformUtils.preCheckCast(new MemoryListActivity$special$$inlined$viewModels$default$4(r1), Function0.class, "com.obric.memorydata.plugin");
        this.autoMemoryViewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(AutoMemoryViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new MemoryListActivity$special$$inlined$viewModels$default$5(r1), Function0.class, "com.obric.memorydata.plugin"), r3, (Function0) ZeusTransformUtils.preCheckCast(new MemoryListActivity$special$$inlined$viewModels$default$6(r7, r1), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
        final ComponentActivity r4 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r5 = (Function0) ZeusTransformUtils.preCheckCast(new MemoryListActivity$special$$inlined$viewModels$default$7(r4), Function0.class, "com.obric.memorydata.plugin");
        this.pendingPersonalInfoViewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(PendingPersonalInfoViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new MemoryListActivity$special$$inlined$viewModels$default$8(r4), Function0.class, "com.obric.memorydata.plugin"), r5, (Function0) ZeusTransformUtils.preCheckCast(new MemoryListActivity$special$$inlined$viewModels$default$9(r7, r4), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
        this.currentTabTitles = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.floatingTitleBarLifecycleCallbacks = new MemoryListActivity$floatingTitleBarLifecycleCallbacks$1(this);
        this.cutOffBottomLayoutListener = new $$Lambda$MemoryListActivity$i8A4OXpPvbMacA8py_dMAPuocLk(this);
    }

    public static final /* synthetic */ void access$changeTabVisibility(MemoryListActivity r2) {
        ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).changeTabVisibility();
    }

    public static final /* synthetic */ ActivityMemoryListBinding access$getBinding$p(MemoryListActivity r2) {
        return ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).binding;
    }

    public static final /* synthetic */ PendingPersonalInfoViewModel access$getPendingPersonalInfoViewModel(MemoryListActivity r2) {
        return ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).getPendingPersonalInfoViewModel();
    }

    public static final /* synthetic */ OFloatingTitleBar access$getPendingSourceTitleBar$p(MemoryListActivity r2) {
        return ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).pendingSourceTitleBar;
    }

    public static final /* synthetic */ MemoryListShareViewModel access$getShareViewModel(MemoryListActivity r2) {
        return ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).getShareViewModel();
    }

    public static final /* synthetic */ MemoryTabContainerAdapter access$getTabContainerPagerAdapter$p(MemoryListActivity r2) {
        return ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).tabContainerPagerAdapter;
    }

    public static final /* synthetic */ void access$refreshAutoMemoryTaskTab(MemoryListActivity r2, boolean r3) {
        ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).refreshAutoMemoryTaskTab(r3);
    }

    public static final /* synthetic */ void access$refreshContextAwarenessTab(MemoryListActivity r2, boolean r3) {
        ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).refreshContextAwarenessTab(r3);
    }

    public static final /* synthetic */ void access$renderPendingPersonalInfoBadge(MemoryListActivity r2, boolean r3) {
        ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).renderPendingPersonalInfoBadge(r3);
    }

    public static final /* synthetic */ void access$resetNestedViewPagerScroll(MemoryListActivity r2, int r3) {
        ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).resetNestedViewPagerScroll(r3);
    }

    public static final /* synthetic */ void access$scheduleFloatingTitleBarTransition(MemoryListActivity r2, int r3) {
        ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).scheduleFloatingTitleBarTransition(r3);
    }

    public static final /* synthetic */ void access$selectBottomNavigationTab(MemoryListActivity r2, int r3) {
        ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).selectBottomNavigationTab(r3);
    }

    public static final /* synthetic */ void access$setPendingSourceTitleBar$p(MemoryListActivity r2, OFloatingTitleBar r3) {
        ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).pendingSourceTitleBar = r3;
    }

    public static final /* synthetic */ void access$syncBottomNavigationSelection(MemoryListActivity r2, MemoryContainerTab r3) {
        ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).syncBottomNavigationSelection(r3);
    }

    public static final /* synthetic */ String access$viewDiag(MemoryListActivity r2, View r3) {
        return ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).viewDiag(r3);
    }

    private final void addTabFragment(MemoryContainerTab r1) {
        MemoryTabContainerAdapter r0 = this.tabContainerPagerAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r0 = null;
    L5:
        r0.addFragment(r1);
    }

    private final void changeTabVisibility() {
        MemoryTabContainerAdapter r0 = this.tabContainerPagerAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r0 = null;
    L5:
        int r1 = r0.getItemCount();
        boolean r2 = ((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r1 <= 1) goto L9;
        if (r2 == true) goto L9;
        setBottomTabVisibility("changeTabVisibility.show", true);
        getShareViewModel().setIsLayoutBottomTabState(true);
        refreshCutOffBottomHeight();
    L10:
        dumpActivityClipDiag("changeTabVisibility fragmentCount=" + r1 + " isEditMode=" + r2);
        return;
    L9:
        setBottomTabVisibility("changeTabVisibility.hide fragmentCount=" + r1 + " isEditMode=" + r2, false);
        setCutOffBottomVisibility("changeTabVisibility.hide fragmentCount=" + r1 + " isEditMode=" + r2, false);
        getShareViewModel().setIsLayoutBottomTabState(false);
        goto L10
    }

    private final String childDiag(ViewGroup r6) {
        if (r6 != null) goto L4;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L4:
        if (r6.getChildCount() == 0) goto L18;
        StringBuilder r0 = new StringBuilder();
        r0.append("[");
        int r1 = 0;
        int r2 = r6.getChildCount();
    L7:
        if (r1 >= r2) goto L11;
        if (r1 <= 0) goto L10;
        r0.append(";");
    L10:
        r0.append(r1).append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append(viewDiag(r6.getChildAt(r1)));
        r1 = r1 + 1;
        goto L7
    L11:
        r0.append("]");
        String r5 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        return r5;
    L18:
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    private final void completeFloatingTitleBarTransition(int r11, int r12, int r13) {
        if (r12 != this.floatingTransitionGeneration) goto L67;
        ActivityMemoryListBinding r0 = this.binding;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L8:
        if (r0.memoryTabContainer.getCurrentItem() != r11) goto L68;
        OFloatingTitleBar r1 = currentPageTitleBar();
        if (r1 != null) goto L13;
    L65:
        retryFloatingTitleBarTransition(r11, r12, r13);
        return;
    L13:
        if (r1.isAttachedToWindow() == false) goto L65;
        if (r1.getWidth() == 0) goto L65;
        int[] r4 = new int[2];
        int[] r3 = new int[2];
        ActivityMemoryListBinding r5 = this.binding;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L20:
        r5.getRoot().getLocationInWindow(r4);
        r1.getLocationInWindow(r3);
        boolean r6 = false;
        if (r3[0] == r4[0]) goto L25;
        retryFloatingTitleBarTransition(r11, r12, r13);
        return;
    L25:
        if (isInitialGlobalTitleBarBind(r11) == false) goto L40;
        ActivityMemoryListBinding r7 = this.binding;
        if (r7 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L29:
        WindowInsetsCompat r8 = ViewCompat.getRootWindowInsets((View) ZeusTransformUtils.preCheckCast(r7.getRoot(), View.class, "com.obric.memorydata.plugin"));
        if (r8 == null) goto L34;
        Insets r9 = r8.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r9 == null) goto L34;
        Integer r10 = Integer.valueOf(r9.top);
    L35:
        if (r10 != null) goto L37;
    L38:
        retryFloatingTitleBarTransition(r11, r12, r13);
        return;
    L37:
        if (r3[1] == (r4[1] + r10.intValue())) goto L40;
    L34:
        r10 = null;
    L40:
        ActivityMemoryListBinding r14 = this.binding;
        if (r14 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L43:
        OFloatingTitleBarActionHost r15 = r14.floatingTitleBarActionHost;
        Intrinsics.checkNotNullExpressionValue(r15, "floatingTitleBarActionHost");
        OFloatingTitleBar r16 = this.pendingSourceTitleBar;
        if (r16 != null) goto L46;
        r16 = r15.getBoundTitleBar();
    L46:
        if (r16 == r1) goto L48;
    L51:
        if (r16 == null) goto L53;
        boolean r17 = true;
    L54:
        r15.a(r1, r17);
        r15.b();
        if (r16 == null) goto L63;
        if (r16 == r1) goto L58;
        r6 = true;
    L58:
        if (r6 == true) goto L61;
        r16 = null;
    L61:
        if (r16 == null) goto L63;
        r15.a(r16);
    L63:
        r15.c();
        this.pendingSourceTitleBar = null;
        return;
    L53:
        r17 = false;
        goto L54
    L48:
        if (r15.getBoundTitleBar() != r1) goto L51;
        this.pendingSourceTitleBar = null;
        return;
    L68:
        return;
    }

    private final void consumeGlassesLandingIntent() {
        if (getIntent().getBooleanExtra(ARG_TARGET_GLASSES, false) == true) goto L5;
        return;
    L5:
        getShareViewModel().requestGlassesLanding();
        getIntent().putExtra(ARG_TARGET_CONTAINER_TAB, "GLOBAL_MEMORY");
        getIntent().removeExtra(ARG_TARGET_GLASSES);
    }

    private final void consumePendingPersonalInfoIntent(Intent r4) {
        if (r4.getBooleanExtra(ARG_OPEN_PENDING_PERSONAL_INFO, false) == true) goto L5;
        return;
    L5:
        MemoryTabContainerAdapter r2 = null;
        getShareViewModel().setTargetPersonalTag(null);
        MemoryTabContainerAdapter r1 = this.tabContainerPagerAdapter;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
    L9:
        int r3 = r2.getTabPosition(MemoryContainerTab.PERSONAL_MEMORY);
        if (r3 < 0) goto L12;
        selectContainerTab(r3);
    L12:
        getPendingPersonalInfoViewModel().openSheet();
        r4.removeExtra(ARG_OPEN_PENDING_PERSONAL_INFO);
        return;
    L8:
        r2 = r1;
        goto L9
    }

    private final com.obric.memorydata.memory.ui.list.contextawareness.e consumedContextAwarenessTargetSnapshot() {
        return new com.obric.memorydata.memory.ui.list.contextawareness.e(ContextAwarenessLaunchTargetState.CONSUMED, null);
    }

    private final ViewPager2.OnPageChangeCallback createContainerPageChangeCallback() {
        return (ViewPager2.OnPageChangeCallback) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), ViewPager2.OnPageChangeCallback.class, "com.obric.memorydata.plugin");
    }

    private final MemoryEventTracker.PageShowParams createTabPageShowParams(MemoryContainerTab r18) {
        String r0 = getShareViewModel().getSelectedTag();
        if (r18 != MemoryContainerTab.PERSONAL_MEMORY) goto L5;
        boolean r1 = true;
    L6:
        String r5 = null;
        if (r1 == false) goto L9;
        String r9 = r0;
    L10:
        if (r9 == null) goto L12;
        Integer r8 = Integer.valueOf(EntityType.MEMORY_INFO_COMMON);
    L13:
        String r14 = (String) ZeusTransformUtils.preCheckCast(getShareViewModel().getEnterFrom().c(), String.class, "com.obric.memorydata.plugin");
        String r12 = MemoryEventTracker.MemoryPage.MEMORY_LIST.getValue();
        String r10 = r18.getText();
        int r2 = b.f11034a[r18.ordinal()];
        if (r2 != 2) goto L16;
        r5 = ((com.obric.memorydata.memory.ui.automemory.u) ZeusTransformUtils.preCheckCast(getAutoMemoryViewModel().getState().c(), com.obric.memorydata.memory.ui.automemory.u.class, "com.obric.memorydata.plugin")).a().getText();
    L26:
        String r11 = r5;
    L28:
        return new MemoryEventTracker.PageShowParams(null, r8, r9, r10, r11, r12, null, r14, 65, null);
    L16:
        if (r2 != 3) goto L18;
        r11 = r9;
        goto L28
    L18:
        if (r2 != 4) goto L26;
        String r3 = getShareViewModel().getSelectedCollectSourceName();
        if (r3 != null) goto L23;
        r5 = MemorySourceFilter.a.a(MemorySourceFilter.Companion, 0, 1, null).getSourceAppName();
        goto L26
    L23:
        r11 = r3;
        goto L28
    L12:
        r8 = null;
        goto L13
    L9:
        r9 = null;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    private final boolean currentContextAwarenessTabVisibility() {
        return com.obric.memorydata.memory.ui.settings.l.f11479a.a().y();
    }

    private final OFloatingTitleBar currentPageTitleBar() {
        if (this.tabContainerPagerAdapter != null) goto L5;
        return null;
    L5:
        ActivityMemoryListBinding r0 = this.binding;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L8:
        int r1 = r0.memoryTabContainer.getCurrentItem();
        MemoryTabContainerAdapter r3 = this.tabContainerPagerAdapter;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r3 = null;
    L11:
        Fragment r4 = r3.getFragment(r1);
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.ui.b.class) == false) goto L14;
        com.obric.memorydata.ui.b r5 = (com.obric.memorydata.ui.b) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.ui.b.class, "com.obric.memorydata.plugin");
    L15:
        if (r5 != null) goto L17;
        return null;
    L17:
        return r5.getCurrentFloatingTitleBar();
    L14:
        r5 = null;
        goto L15
    }

    private static final void cutOffBottomLayoutListener$lambda$6(MemoryListActivity r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        MemoryListActivity r10 = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r0, MemoryListActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r1);
        ActivityMemoryListBinding r11 = r10.binding;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L5:
        View r12 = r11.cutOffBottom;
        Intrinsics.checkNotNullExpressionValue(r12, "cutOffBottom");
        r10.updateCutOffBottomFromNavBar(r1, r12);
    }

    private final void dumpActivityClipDiag(String r13) {
        if (this.binding != null) goto L6;
        return;
    L6:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == true) goto L8;
        return;
    L8:
        ActivityMemoryListBinding r0 = this.binding;
        MemoryTabContainerAdapter r2 = null;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L11:
        View r1 = r0.memoryTabContainer.getChildAt(0);
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L41;
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r14 = new StringBuilder().append("[OTabDiag][Activity] ").append(r13).append(" root=");
        ActivityMemoryListBinding r3 = this.binding;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L16:
        StringBuilder r15 = r14.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r3.getRoot(), View.class, "com.obric.memorydata.plugin"))).append(" vp=");
        ActivityMemoryListBinding r4 = this.binding;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L19:
        StringBuilder r16 = r15.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r4.memoryTabContainer, View.class, "com.obric.memorydata.plugin"))).append(" vpChild=").append(viewDiag(r1)).append(" vpChildChildren=");
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L22;
        ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.memorydata.plugin");
    L23:
        StringBuilder r17 = r16.append(childDiag(r5)).append(" bottomTab=");
        ActivityMemoryListBinding r7 = this.binding;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L26:
        StringBuilder r18 = r17.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r7.memoryContainerTabView, View.class, "com.obric.memorydata.plugin"))).append(" cutOffBottom=");
        ActivityMemoryListBinding r8 = this.binding;
        if (r8 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L29:
        StringBuilder r19 = r18.append(viewDiag(r8.cutOffBottom)).append(" currentItem=");
        ActivityMemoryListBinding r9 = this.binding;
        if (r9 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L32:
        StringBuilder r110 = r19.append(r9.memoryTabContainer.getCurrentItem()).append(" adapterCount=");
        MemoryTabContainerAdapter r12 = this.tabContainerPagerAdapter;
        if (r12 == null) goto L38;
        if (r12 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
    L37:
        int r111 = r2.getItemCount();
    L39:
        IRunLog.a.a(r6, TAG, r110.append(r111).toString(), false, 4, null);
        return;
    L36:
        r2 = r12;
        goto L37
    L38:
        r111 = -1;
        goto L39
    L22:
        r5 = null;
        goto L23
    }

    private final AutoMemoryViewModel getAutoMemoryViewModel() {
        return (AutoMemoryViewModel) ZeusTransformUtils.preCheckCast(this.autoMemoryViewModel$delegate.getValue(), AutoMemoryViewModel.class, "com.obric.memorydata.plugin");
    }

    private final MemoryContainerTab getContainerTab(AppEntity r1) {
        MemoryTab r0 = com.obric.memorydata.memory.utils.f.f11537a.a(r1);
        int r2 = b.f11035b[r0.ordinal()];
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L13;
        if (r2 == 3) goto L13;
        return MemoryContainerTab.GLOBAL_MEMORY;
    L13:
        return MemoryContainerTab.CONTEXT_AWARENESS;
    L11:
        return MemoryContainerTab.PERSONAL_MEMORY;
    }

    private final String getPageShowTagName(String r5, AppEntity r6) {
        if (Intrinsics.areEqual(r5, MemoryTab.PROFILE.getText()) == false) goto L6;
        String r4 = getShareViewModel().getSelectedTag();
    L22:
        if (r4 != null) goto L24;
        return null;
    L24:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L26;
        return null;
    L26:
        return r4;
    L6:
        if (Intrinsics.areEqual(r5, MemoryContainerTab.AUTO_MEMORY_TASK.getText()) == false) goto L9;
        r4 = ((com.obric.memorydata.memory.ui.automemory.u) ZeusTransformUtils.preCheckCast(getAutoMemoryViewModel().getState().c(), com.obric.memorydata.memory.ui.automemory.u.class, "com.obric.memorydata.plugin")).a().getText();
        goto L22
    L9:
        if (Intrinsics.areEqual(r5, MemoryTab.COLLECT.getText()) == false) goto L21;
        r4 = getShareViewModel().getSelectedCollectSourceName();
        if (r4 != null) goto L22;
        if (ZeusTransformUtils.instanceOf(r6, MemoryEntity.class) == false) goto L15;
        MemoryEntity r7 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r6, MemoryEntity.class, "com.obric.memorydata.plugin");
    L16:
        if (r7 == null) goto L18;
        r4 = r7.getSourceAppName();
    L19:
        if (r4 != null) goto L22;
        r4 = MemorySourceFilter.a.a(MemorySourceFilter.Companion, 0, 1, null).getSourceAppName();
        goto L22
    L18:
        r4 = null;
        goto L19
    L15:
        r7 = null;
        goto L16
    L21:
        r4 = null;
        goto L22
    }

    private final PendingPersonalInfoViewModel getPendingPersonalInfoViewModel() {
        return (PendingPersonalInfoViewModel) ZeusTransformUtils.preCheckCast(this.pendingPersonalInfoViewModel$delegate.getValue(), PendingPersonalInfoViewModel.class, "com.obric.memorydata.plugin");
    }

    private final MemoryListShareViewModel getShareViewModel() {
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(this.shareViewModel$delegate.getValue(), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    private static final WindowInsetsCompat initStatusBar$lambda$1(View r1, WindowInsetsCompat r2) {
        Intrinsics.checkNotNullParameter(r1, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r2, "insets");
        int r3 = r2.getInsets(WindowInsetsCompat.Type.statusBars()).top;
        com.obric.memorydata.memory.ui.b.f10769a.a(r3);
        return r2;
    }

    private final boolean isAutoMemoryTaskAvailable() {
        return AILabPermissionRepository.a(AILabPermissionRepository.f10236a, null, null, null, null, null, null, 63, null);
    }

    private final boolean isInitialGlobalTitleBarBind(int r3) {
        if (this.pendingSourceTitleBar != null) goto L16;
        ActivityMemoryListBinding r0 = this.binding;
        MemoryTabContainerAdapter r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L8:
        if (r0.floatingTitleBarActionHost.getBoundTitleBar() != null) goto L16;
        MemoryTabContainerAdapter r2 = this.tabContainerPagerAdapter;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
    L14:
        if (r3 != r1.getTabPosition(MemoryContainerTab.GLOBAL_MEMORY)) goto L16;
        return true;
    L12:
        r1 = r2;
    L16:
        return false;
    }

    /* JADX INFO: renamed from: lambda$8z7Ik6OdD9ube8HL7syp-NW1RrU, reason: not valid java name */
    public static /* synthetic */ WindowInsetsCompat m885lambda$8z7Ik6OdD9ube8HL7sypNW1RrU(View r0, WindowInsetsCompat r1) {
        return initStatusBar$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit lambda$JCsVWOoEy9ZVl2gzbvy0r2elqi8(MemoryListActivity r0, com.obric.memorydata.memory.ui.list.contextawareness.e r1, com.obric.memorydata.memory.ui.list.contextawareness.v r2) {
        return onCreate$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$JUlA0VhU8PQPGdhlMjJR9vL5sMA(MemoryListActivity r0, OFloatingTitleBarActionHost r1, OFloatingTitleBar r2) {
        onResumeChecked$lambda$9(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$NLHzNfMMulMLPZIJb80PAGhza4s(MemoryListActivity r0, int r1, int r2) {
        scheduleFloatingTitleBarTransition$lambda$32(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$UDvdd3g_ljMKqvRmYLgpJnV2wCo(MemoryListActivity r0) {
        updateCutOffBottomFromNavBar$lambda$8(r0);
    }

    /* JADX INFO: renamed from: lambda$er5h-9TUaeo-DGyWDrk1R-DKLy8, reason: not valid java name */
    public static /* synthetic */ void m886lambda$er5h9TUaeoDGyWDrk1RDKLy8(MemoryListActivity r0) {
        onCreate$lambda$2(r0);
    }

    public static /* synthetic */ void lambda$i8A4OXpPvbMacA8py_dMAPuocLk(MemoryListActivity r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        cutOffBottomLayoutListener$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit lambda$oxdKiFqOXjsUcl6WYdI5RFut474(MemoryListActivity r0, int r1) {
        return setupContainerViewPager$lambda$23(r0, r1);
    }

    public static /* synthetic */ void lambda$pgBatU4movFCIdR8Gf68y1HNo1I(MemoryListActivity r0, int r1, int r2, int r3) {
        retryFloatingTitleBarTransition$lambda$35(r0, r1, r2, r3);
    }

    private final void observeContextAwarenessTabVisibility() {
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11601(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void observeState() {
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11611(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final void onCreate$lambda$2(MemoryListActivity r2) {
        ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).dumpActivityClipDiag("onCreate.firstFrame");
    }

    private static final Unit onCreate$lambda$3(MemoryListActivity r2, com.obric.memorydata.memory.ui.list.contextawareness.e r3, com.obric.memorydata.memory.ui.list.contextawareness.v r4) {
        ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).getShareViewModel().initializeContextAwarenessTarget$memory_obricRelease(r4, r3);
        return Unit.INSTANCE;
    }

    private static final void onResumeChecked$lambda$9(MemoryListActivity r2, OFloatingTitleBarActionHost r3, OFloatingTitleBar r4) {
        MemoryListActivity r5 = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "targetTitleBar");
        if (r5.isFinishing() == false) goto L5;
        return;
    L5:
        if (r5.isDestroyed() == false) goto L7;
        return;
    L7:
        if (r5.currentPageTitleBar() == r4) goto L9;
        return;
    L9:
        if (r3.getBoundTitleBar() == r4) goto L11;
        return;
    L11:
        if (r4.g() == false) goto L18;
        r3.a(r4, false);
        return;
    }

    private final void refreshAutoMemoryTaskTab(boolean r8) {
        this.autoMemoryTaskAvailable = r8;
        MemoryTabContainerAdapter r0 = this.tabContainerPagerAdapter;
        if (r0 != null) goto L5;
        return;
    L5:
        ActivityMemoryListBinding r3 = null;
        if (r8 == false) goto L12;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r0 = null;
    L10:
        if (r0.containsFragment(MemoryContainerTab.AUTO_MEMORY_TASK) == true) goto L52;
        addTabFragment(MemoryContainerTab.AUTO_MEMORY_TASK);
    L52:
        refreshTabView();
        MemoryTabContainerAdapter r9 = this.tabContainerPagerAdapter;
        if (r9 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r9 = null;
    L55:
        ActivityMemoryListBinding r1 = this.binding;
        if (r1 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L59:
        syncBottomNavigationSelection(r9.getTab(r3.memoryTabContainer.getCurrentItem()));
        selectTargetContainerTabIfNeeded();
        return;
    L58:
        r3 = r1;
        goto L59
    L12:
        if (r0 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r0 = null;
    L15:
        if (r0.containsFragment(MemoryContainerTab.AUTO_MEMORY_TASK) == false) goto L52;
        MemoryTabContainerAdapter r10 = this.tabContainerPagerAdapter;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r10 = null;
    L19:
        ActivityMemoryListBinding r2 = this.binding;
        if (r2 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L22:
        boolean r4 = true;
        if (r10.getTab(r2.memoryTabContainer.getCurrentItem()) != MemoryContainerTab.AUTO_MEMORY_TASK) goto L25;
        boolean r11 = true;
    L26:
        MemoryContainerTab r5 = getShareViewModel().getPreviousBottomTabBeforeAutoMemory();
        if (r5 == null) goto L37;
        MemoryTabContainerAdapter r6 = this.tabContainerPagerAdapter;
        if (r6 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r6 = null;
    L32:
        if (r6.containsFragment(r5) == true) goto L35;
        r5 = null;
    L35:
        if (r5 == null) goto L37;
    L38:
        removeTabFragment(MemoryContainerTab.AUTO_MEMORY_TASK);
        if (r11 == false) goto L52;
        MemoryTabContainerAdapter r12 = this.tabContainerPagerAdapter;
        if (r12 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r12 = null;
    L43:
        Integer r13 = Integer.valueOf(r12.getTabPosition(r5));
        if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).intValue() >= 0) goto L47;
        r4 = false;
    L47:
        if (r4 == true) goto L50;
        r13 = null;
    L50:
        if (r13 == null) goto L52;
        selectContainerTab(((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).intValue());
    L37:
        r5 = MemoryContainerTab.GLOBAL_MEMORY;
        goto L38
    L25:
        r11 = false;
        goto L26
    }

    static /* synthetic */ void refreshAutoMemoryTaskTab$default(MemoryListActivity r2, boolean r3, int r4, Object r5) {
        MemoryListActivity r6 = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L10;
        if ((r4 & 1) == 0) goto L7;
        r3 = r6.isAutoMemoryTaskAvailable();
    L7:
        r6.refreshAutoMemoryTaskTab(r3);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshAutoMemoryTaskTab");
    }

    private final void refreshContextAwarenessTab(boolean r12) {
        MemoryTabContainerAdapter r0 = this.tabContainerPagerAdapter;
        if (r0 != null) goto L5;
        return;
    L5:
        Integer r3 = null;
        if (this.contextAwarenessTabVisible != r12) goto L12;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r0 = null;
    L10:
        if (r0.containsFragment(MemoryContainerTab.CONTEXT_AWARENESS) != r12) goto L12;
        return;
    L12:
        MemoryTabContainerAdapter r1 = this.tabContainerPagerAdapter;
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r1 = null;
    L15:
        ActivityMemoryListBinding r2 = this.binding;
        if (r2 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L18:
        MemoryContainerTab r4 = r1.getTab(r2.memoryTabContainer.getCurrentItem());
        boolean r5 = true;
        if (r4 != MemoryContainerTab.AUTO_MEMORY_TASK) goto L21;
        boolean r6 = true;
    L22:
        MemoryContainerTab r7 = getShareViewModel().getPreviousBottomTabBeforeAutoMemory();
        if (r7 != null) goto L25;
    L38:
        r7 = MemoryContainerTab.GLOBAL_MEMORY;
    L39:
        this.contextAwarenessTabVisible = r12;
        MemoryTabContainerAdapter r9 = this.tabContainerPagerAdapter;
        if (r12 == false) goto L46;
        if (r9 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r9 = null;
    L44:
        if (r9.containsFragment(MemoryContainerTab.CONTEXT_AWARENESS) == true) goto L74;
        addTabFragment(MemoryContainerTab.CONTEXT_AWARENESS);
    L74:
        refreshTabView();
        if (r12 == true) goto L78;
        if (r6 == false) goto L78;
        getShareViewModel().updateAutoMemoryFallbackTab(r7);
    L78:
        if (r12 == false) goto L80;
    L82:
        if (r4 == null) goto L89;
        MemoryTabContainerAdapter r13 = this.tabContainerPagerAdapter;
        if (r13 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r13 = null;
    L87:
        if (r13.containsFragment(r4) != true) goto L89;
        boolean r14 = true;
    L90:
        if (r14 == true) goto L99;
        MemoryTabContainerAdapter r15 = this.tabContainerPagerAdapter;
        if (r15 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r15 = null;
    L95:
        ActivityMemoryListBinding r8 = this.binding;
        if (r8 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L98:
        r4 = r15.getTab(r8.memoryTabContainer.getCurrentItem());
    L99:
        if (r4 == null) goto L111;
        MemoryTabContainerAdapter r16 = this.tabContainerPagerAdapter;
        if (r16 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r16 = null;
    L103:
        Integer r17 = Integer.valueOf(r16.getTabPosition(r4));
        if (((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).intValue() >= 0) goto L107;
        r5 = false;
    L107:
        if (r5 == false) goto L109;
        r3 = r17;
    L109:
        if (r3 == null) goto L111;
        selectContainerTab(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue());
    L111:
        syncBottomNavigationSelection(r4);
        selectTargetContainerTabIfNeeded();
        return;
    L89:
        r14 = false;
        goto L90
    L80:
        if (r4 != MemoryContainerTab.CONTEXT_AWARENESS) goto L82;
        r4 = MemoryContainerTab.GLOBAL_MEMORY;
        goto L99
    L46:
        if (r9 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r9 = null;
    L49:
        if (r9.containsFragment(MemoryContainerTab.CONTEXT_AWARENESS) == false) goto L74;
        MemoryTabContainerAdapter r10 = this.tabContainerPagerAdapter;
        if (r10 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r10 = null;
    L53:
        ActivityMemoryListBinding r11 = this.binding;
        if (r11 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L57:
        if (r10.getTab(r11.memoryTabContainer.getCurrentItem()) != MemoryContainerTab.CONTEXT_AWARENESS) goto L59;
        boolean r18 = true;
    L60:
        if (r18 == false) goto L73;
        MemoryTabContainerAdapter r19 = this.tabContainerPagerAdapter;
        if (r19 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r19 = null;
    L64:
        Integer r20 = Integer.valueOf(r19.getTabPosition(MemoryContainerTab.GLOBAL_MEMORY));
        if (((Number) ZeusTransformUtils.preCheckCast(r20, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L67;
        boolean r110 = true;
    L68:
        if (r110 == true) goto L71;
        r20 = null;
    L71:
        if (r20 == null) goto L73;
        selectContainerTab(((Number) ZeusTransformUtils.preCheckCast(r20, Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L73
    L67:
        r110 = false;
    L73:
        removeTabFragment(MemoryContainerTab.CONTEXT_AWARENESS);
        goto L74
    L59:
        r18 = false;
        goto L60
    L25:
        if (r7 == MemoryContainerTab.CONTEXT_AWARENESS) goto L32;
        MemoryTabContainerAdapter r21 = this.tabContainerPagerAdapter;
        if (r21 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r21 = null;
    L30:
        if (r21.containsFragment(r7) == false) goto L32;
        boolean r22 = true;
    L33:
        if (r22 == true) goto L36;
        r7 = null;
    L36:
        if (r7 == null) goto L38;
    L32:
        r22 = false;
        goto L33
    L21:
        r6 = false;
        goto L22
    }

    private final void refreshCutOffBottomHeight() {
        ActivityMemoryListBinding r0 = this.binding;
        ActivityMemoryListBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OBottomNavigationBar r2 = r0.memoryContainerTabView;
        Intrinsics.checkNotNullExpressionValue(r2, "memoryContainerTabView");
        ActivityMemoryListBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        View r4 = r1.cutOffBottom;
        Intrinsics.checkNotNullExpressionValue(r4, "cutOffBottom");
        if (this.shouldShowCutOffBottom == true) goto L12;
    L16:
        setCutOffBottomVisibility("refreshCutOffBottomHeight.skip shouldShow=" + this.shouldShowCutOffBottom + " tabVisible=" + visibilityName(r2.getVisibility()), false);
        r2.getNavigationBar().removeOnLayoutChangeListener(this.cutOffBottomLayoutListener);
        return;
    L12:
        if (r2.getVisibility() != 0) goto L16;
        setCutOffBottomVisibility("refreshCutOffBottomHeight.show", true);
        OBottomNavActionBar r5 = r2.getNavigationBar();
        r5.removeOnLayoutChangeListener(this.cutOffBottomLayoutListener);
        r5.addOnLayoutChangeListener(this.cutOffBottomLayoutListener);
        updateCutOffBottomFromNavBar((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), r4);
        return;
    L8:
        r1 = r3;
        goto L9
    }

    private final void refreshTabView() {
        List<MemoryContainerTab> r0 = r.f11329a.a(this.contextAwarenessTabVisible, this.autoMemoryTaskAvailable);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r3.add(((MemoryContainerTab) ZeusTransformUtils.preCheckCast(r2.next(), MemoryContainerTab.class, "com.obric.memorydata.plugin")).getText());
        goto L4
    L6:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.currentTabTitles, r4) == false) goto L9;
        return;
    L9:
        this.currentTabTitles.clear();
        this.currentTabTitles.addAll((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin"));
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L10:
        ActivityMemoryListBinding r8 = null;
        if (r7.hasNext() == false) goto L21;
        Integer r9 = ((MemoryContainerTab) ZeusTransformUtils.preCheckCast(r7.next(), MemoryContainerTab.class, "com.obric.memorydata.plugin")).getSelectIconImageId();
        if (r9 == null) goto L20;
        int r10 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue();
        Drawable r11 = ResourcesCompat.getDrawable(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), r10, null);
        if (r11 == null) goto L18;
        r6.add(r11);
        goto L10
    L18:
        throw new IllegalArgumentException("Required value was null.".toString());
    L20:
        throw new IllegalArgumentException("Required value was null.".toString());
    L21:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        ActivityMemoryListBinding r13 = this.binding;
        if (r13 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L25:
        r8.memoryContainerTabView.getNavigationBar().a((String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"), (Drawable[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).toArray(new Drawable[0]), Drawable[].class, "com.obric.memorydata.plugin"));
        renderPendingPersonalInfoBadge(((az) ZeusTransformUtils.preCheckCast(getPendingPersonalInfoViewModel().getUiState().c(), az.class, "com.obric.memorydata.plugin")).g());
        return;
    L24:
        r8 = r13;
        goto L25
    }

    private final void removeTabFragment(MemoryContainerTab r1) {
        MemoryTabContainerAdapter r0 = this.tabContainerPagerAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r0 = null;
    L5:
        r0.removeFragment(r1);
    }

    private final void renderPendingPersonalInfoBadge(boolean r8) {
        MemoryTabContainerAdapter r0 = this.tabContainerPagerAdapter;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.binding == null) goto L37;
        RelativeLayout.LayoutParams r1 = null;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r0 = null;
    L10:
        int r2 = r0.getTabPosition(MemoryContainerTab.PERSONAL_MEMORY);
        if (r2 >= 0) goto L13;
        return;
    L13:
        ActivityMemoryListBinding r3 = this.binding;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L16:
        OBottomNavActionBar r4 = r3.memoryContainerTabView.getNavigationBar();
        if (r8 == false) goto L33;
        r4.a(r2);
        UnReadMsgView r9 = r4.d(r2);
        ViewParent r5 = r9.getParent();
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L21;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin");
    L22:
        if (r6 != null) goto L24;
        return;
    L24:
        View r7 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.tv_tab_icon, OaidModel.KEY_ID, "tv_tab_icon"));
        if (r7 != null) goto L27;
        return;
    L27:
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r10, RelativeLayout.LayoutParams.class) == false) goto L30;
        r1 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r10, RelativeLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L30:
        if (r1 != null) goto L32;
        return;
    L32:
        r1.removeRule(1);
        r1.addRule(14);
        r1.addRule(6, ZeusTransformUtils.mapRes(R.id.ll_tap, OaidModel.KEY_ID, "ll_tap"));
        r1.setMargins(0, 0, 0, 0);
        r9.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r9.setTranslationX(((r7.getLayoutParams().width + r1.width) / 2.0f) + (2 * ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density));
        return;
    L21:
        r6 = null;
        goto L22
    L33:
        r4.c(r2);
        return;
    }

    private final void resetNestedViewPagerScroll(int r2) {
        MemoryTabContainerAdapter r1 = this.tabContainerPagerAdapter;
        ac r0 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r1 = null;
    L5:
        Fragment r3 = r1.getFragment(r2);
        if (ZeusTransformUtils.instanceOf(r3, ac.class) == false) goto L8;
        r0 = (ac) ZeusTransformUtils.preCheckCast(r3, ac.class, "com.obric.memorydata.plugin");
    L8:
        if (r0 == null) goto L11;
        r0.resetNestedViewPagerScroll();
        return;
    }

    private final com.obric.memorydata.memory.ui.list.contextawareness.e restoreContextAwarenessTargetSnapshot(Bundle r12) {
        ContextAwarenessTimelineSource r0 = null;
        if (r12 != null) goto L5;
        return null;
    L5:
        String r1 = r12.getString(STATE_CONTEXT_TARGET_STATUS);
        int r2 = 0;
        if (r1 == null) goto L13;
        ContextAwarenessLaunchTargetState[] r3 = ContextAwarenessLaunchTargetState.values();
        int r4 = r3.length;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L13;
        ContextAwarenessLaunchTargetState r6 = r3[r5];
        if (Intrinsics.areEqual(r6.name(), r1) == true) goto L15;
        r5 = r5 + 1;
    L15:
        if (r6 != ContextAwarenessLaunchTargetState.PENDING) goto L17;
        long r7 = r12.getLong(STATE_CONTEXT_TARGET_REQUEST_ID, 0);
        String r8 = r12.getString(STATE_CONTEXT_TARGET_SOURCE);
        if (r8 == null) goto L26;
        ContextAwarenessTimelineSource[] r9 = ContextAwarenessTimelineSource.values();
        int r10 = r9.length;
    L21:
        if (r2 >= r10) goto L26;
        ContextAwarenessTimelineSource r11 = r9[r2];
        if (Intrinsics.areEqual(r11.name(), r8) == true) goto L24;
        r2 = r2 + 1;
        goto L21
    L24:
        r0 = r11;
    L26:
        String r13 = r12.getString(STATE_CONTEXT_TARGET_ENTITY_ID);
        if (r13 != null) goto L30;
        r13 = "";
    L30:
        if (r7 <= 0) goto L38;
        if (r0 == null) goto L38;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L38;
        return new com.obric.memorydata.memory.ui.list.contextawareness.e(ContextAwarenessLaunchTargetState.PENDING, new com.obric.memorydata.memory.ui.list.contextawareness.l(r7, new com.obric.memorydata.memory.ui.list.contextawareness.v(r0, r13)));
    L38:
        return consumedContextAwarenessTargetSnapshot();
    L17:
        return consumedContextAwarenessTargetSnapshot();
    L13:
        r6 = null;
        goto L15
    }

    private final void retryFloatingTitleBarTransition(final int r4, final int r5, final int r6) {
        ActivityMemoryListBinding r1 = null;
        if (r6 < 8) goto L9;
        ActivityMemoryListBinding r7 = this.binding;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L7:
        r7.floatingTitleBarActionHost.a(this.pendingSourceTitleBar);
        this.pendingSourceTitleBar = null;
        return;
    L9:
        ActivityMemoryListBinding r2 = this.binding;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        r1.memoryTabContainer.postOnAnimation(new $$Lambda$MemoryListActivity$pgBatU4movFCIdR8Gf68y1HNo1I(this, r4, r5, r6));
        return;
    L12:
        r1 = r2;
        goto L13
    }

    private static final void retryFloatingTitleBarTransition$lambda$35(MemoryListActivity r2, int r3, int r4, int r5) {
        ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).completeFloatingTitleBarTransition(r3, r4, r5 + 1);
    }

    private final void saveContextAwarenessTargetSnapshot(Bundle r3, com.obric.memorydata.memory.ui.list.contextawareness.e r4) {
        r3.putString(STATE_CONTEXT_TARGET_STATUS, r4.a().name());
        com.obric.memorydata.memory.ui.list.contextawareness.l r2 = r4.b();
        if (r2 != null) goto L5;
        return;
    L5:
        if (r4.a() != ContextAwarenessLaunchTargetState.PENDING) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L15;
        r3.putLong(STATE_CONTEXT_TARGET_REQUEST_ID, r2.a());
        r3.putString(STATE_CONTEXT_TARGET_SOURCE, r2.b().a().name());
        r3.putString(STATE_CONTEXT_TARGET_ENTITY_ID, r2.b().b());
        return;
    L15:
        return;
    L7:
        r5 = false;
        goto L8
    }

    private final void scheduleFloatingTitleBarTransition(final int r4) {
        final int r0 = this.floatingTransitionGeneration + 1;
        this.floatingTransitionGeneration = r0;
        ActivityMemoryListBinding r1 = this.binding;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        r1.memoryTabContainer.postOnAnimation(new $$Lambda$MemoryListActivity$NLHzNfMMulMLPZIJb80PAGhza4s(this, r4, r0));
    }

    private static final void scheduleFloatingTitleBarTransition$lambda$32(MemoryListActivity r2, int r3, int r4) {
        ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).completeFloatingTitleBarTransition(r3, r4, 0);
    }

    private final void selectBottomNavigationTab(int r4) {
        MemoryContainerTab r5 = r.f11329a.a(r4, this.contextAwarenessTabVisible, this.autoMemoryTaskAvailable);
        if (r5 != null) goto L5;
        return;
    L5:
        MemoryTabContainerAdapter r0 = this.tabContainerPagerAdapter;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r0 = null;
    L8:
        int r6 = r0.getTabPosition(r5);
        if (r6 < 0) goto L12;
        selectContainerTab(r6);
        return;
    }

    private final void selectContainerTab(int r18) {
        ActivityMemoryListBinding r2 = this.binding;
        ActivityMemoryListBinding r4 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L5:
        int r3 = r2.memoryTabContainer.getCurrentItem();
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L17;
        IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r5 = new StringBuilder().append("[AutoTaskDiag][Activity] selectContainerTab position=").append(r18).append(" current=").append(r3).append(" adapterCount=");
        MemoryTabContainerAdapter r12 = this.tabContainerPagerAdapter;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r12 = null;
    L10:
        StringBuilder r6 = r5.append(r12.getItemCount()).append(" selected=").append((String) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectBottomTab().c(), String.class, "com.obric.memorydata.plugin")).append(" bottomTab=");
        ActivityMemoryListBinding r13 = this.binding;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L13:
        StringBuilder r7 = r6.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r13.memoryContainerTabView, View.class, "com.obric.memorydata.plugin"))).append(" cutOff=");
        ActivityMemoryListBinding r14 = this.binding;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L16:
        IRunLog.a.a(r11, TAG, r7.append(viewDiag(r14.cutOffBottom)).toString(), false, 4, null);
    L17:
        resetNestedViewPagerScroll(r3);
        if (r3 == r18) goto L23;
        this.pendingSourceTitleBar = getCurrentFloatingTitleBar();
        ActivityMemoryListBinding r8 = this.binding;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L22:
        r8.memoryTabContainer.setCurrentItem(r18, false);
    L23:
        resetNestedViewPagerScroll(r18);
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L37;
        IRunLog r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r1 = new StringBuilder().append("[AutoTaskDiag][Activity] selectContainerTab.after position=").append(r18).append(" current=");
        ActivityMemoryListBinding r9 = this.binding;
        if (r9 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L28:
        StringBuilder r10 = r1.append(r9.memoryTabContainer.getCurrentItem()).append(" selected=").append((String) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectBottomTab().c(), String.class, "com.obric.memorydata.plugin")).append(" bottomTab=");
        ActivityMemoryListBinding r16 = this.binding;
        if (r16 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L31:
        StringBuilder r17 = r10.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r16.memoryContainerTabView, View.class, "com.obric.memorydata.plugin"))).append(" cutOff=");
        ActivityMemoryListBinding r19 = this.binding;
        if (r19 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L35:
        IRunLog.a.a(r15, TAG, r17.append(viewDiag(r4.cutOffBottom)).toString(), false, 4, null);
        return;
    L34:
        r4 = r19;
        goto L35
    }

    private final void selectTargetContainerTabIfNeeded() {
        if (this.tabContainerPagerAdapter != null) goto L5;
        return;
    L5:
        String r0 = getIntent().getStringExtra(ARG_TARGET_CONTAINER_TAB);
        if (r0 != null) goto L8;
        return;
    L8:
        MemoryContainerTab r1 = r.f11329a.a(r0);
        if (r1 != null) goto L11;
        return;
    L11:
        MemoryTabContainerAdapter r2 = this.tabContainerPagerAdapter;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r2 = null;
    L14:
        int r3 = r2.getTabPosition(r1);
        if (r3 < 0) goto L18;
        selectContainerTab(r3);
        getIntent().removeExtra(ARG_TARGET_CONTAINER_TAB);
        return;
    }

    private final void setBottomTabVisibility(String r13, boolean r14) {
        if (r14 == false) goto L4;
        int r15 = 0;
    L5:
        ActivityMemoryListBinding r0 = this.binding;
        ActivityMemoryListBinding r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L8:
        int r2 = r0.memoryContainerTabView.getVisibility();
        ActivityMemoryListBinding r3 = this.binding;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L11:
        r3.memoryContainerTabView.setVisibility(r15);
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L19;
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r16 = new StringBuilder().append("[CutOffDiag][Activity] setBottomTabVisibility reason=").append(r13).append(" before=").append(visibilityName(r2)).append(" after=").append(visibilityName(r15)).append(" bottomTab=");
        ActivityMemoryListBinding r17 = this.binding;
        if (r17 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L17:
        IRunLog.a.a(r6, TAG, r16.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r1.memoryContainerTabView, View.class, "com.obric.memorydata.plugin"))).toString(), false, 4, null);
        return;
    L16:
        r1 = r17;
        goto L17
    L19:
        return;
    L4:
        r15 = 8;
        goto L5
    }

    private final void setCutOffBottomVisibility(String r14, boolean r15) {
        if (r15 == true) goto L4;
    L6:
        int r0 = 8;
    L7:
        ActivityMemoryListBinding r1 = this.binding;
        ActivityMemoryListBinding r2 = null;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L10:
        int r3 = r1.cutOffBottom.getVisibility();
        ActivityMemoryListBinding r4 = this.binding;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L13:
        r4.cutOffBottom.setVisibility(r0);
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L27;
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r16 = new StringBuilder().append("[CutOffDiag][Activity] setCutOffBottomVisibility reason=").append(r14).append(" requestVisible=").append(r15).append(" before=").append(visibilityName(r3)).append(" after=").append(visibilityName(r0)).append(" shouldShow=").append(this.shouldShowCutOffBottom).append(" currentTab=");
        ActivityMemoryListBinding r17 = this.binding;
        if (r17 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L18:
        StringBuilder r18 = r16.append(r17.memoryTabContainer.getCurrentItem()).append(" bottomTab=");
        ActivityMemoryListBinding r19 = this.binding;
        if (r19 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L21:
        StringBuilder r110 = r18.append(viewDiag((View) ZeusTransformUtils.preCheckCast(r19.memoryContainerTabView, View.class, "com.obric.memorydata.plugin"))).append(" cutOff=");
        ActivityMemoryListBinding r111 = this.binding;
        if (r111 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L25:
        IRunLog.a.a(r7, TAG, r110.append(viewDiag(r2.cutOffBottom)).toString(), false, 4, null);
        return;
    L24:
        r2 = r111;
        goto L25
    L27:
        return;
    L4:
        if (this.shouldShowCutOffBottom == false) goto L6;
        r0 = 0;
        goto L7
    }

    private final void setupContainerViewPager() {
        this.contextAwarenessTabVisible = currentContextAwarenessTabVisibility();
        this.autoMemoryTaskAvailable = isAutoMemoryTaskAvailable();
        this.tabContainerPagerAdapter = new MemoryTabContainerAdapter(this, new $$Lambda$MemoryListActivity$oxdKiFqOXjsUcl6WYdI5RFut474(this));
        refreshTabView();
        addTabFragment(MemoryContainerTab.GLOBAL_MEMORY);
        addTabFragment(MemoryContainerTab.PERSONAL_MEMORY);
        if (this.contextAwarenessTabVisible == false) goto L6;
        addTabFragment(MemoryContainerTab.CONTEXT_AWARENESS);
    L6:
        if (this.autoMemoryTaskAvailable == false) goto L8;
        addTabFragment(MemoryContainerTab.AUTO_MEMORY_TASK);
    L8:
        ActivityMemoryListBinding r0 = this.binding;
        ActivityMemoryListBinding r2 = null;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L11:
        ViewPager2 r1 = r0.memoryTabContainer;
        MemoryTabContainerAdapter r3 = this.tabContainerPagerAdapter;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r3 = null;
    L14:
        r1.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r3, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        MemoryTabContainerAdapter r4 = this.tabContainerPagerAdapter;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r4 = null;
    L17:
        updateContainerPagerCache(r4.getItemCount());
        ActivityMemoryListBinding r5 = this.binding;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L20:
        r5.memoryTabContainer.setUserInputEnabled(false);
        ViewPager2.OnPageChangeCallback r6 = createContainerPageChangeCallback();
        this.containerPageChangeCallback = r6;
        if (r6 == null) goto L26;
        ActivityMemoryListBinding r7 = this.binding;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L25:
        r7.memoryTabContainer.registerOnPageChangeCallback(r6);
    L26:
        ActivityMemoryListBinding r8 = this.binding;
        if (r8 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L29:
        ViewPager2 r9 = r8.memoryTabContainer;
        MemoryTabContainerAdapter r10 = this.tabContainerPagerAdapter;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r10 = null;
    L32:
        r9.setCurrentItem(r10.getTabPosition(MemoryContainerTab.GLOBAL_MEMORY), false);
        ActivityMemoryListBinding r11 = this.binding;
        if (r11 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L35:
        r11.memoryContainerTabView.getNavigationBar().requestLayout();
        OBottomNavActionBar.c r12 = (OBottomNavActionBar.c) ZeusTransformUtils.preCheckCast(new c(this), OBottomNavActionBar.c.class, "com.obric.memorydata.plugin");
        this.bottomTabSelectListener = r12;
        if (r12 == null) goto L42;
        ActivityMemoryListBinding r13 = this.binding;
        if (r13 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L41:
        r2.memoryContainerTabView.getNavigationBar().setOnTabSelectListener(r12);
        goto L42
    L40:
        r2 = r13;
    L42:
        selectTargetContainerTabIfNeeded();
    }

    private static final Unit setupContainerViewPager$lambda$23(MemoryListActivity r7, int r8) {
        MemoryListActivity r9 = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r7, MemoryListActivity.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onFragmentCountChange: " + r8, false, 4, null);
        r9.changeTabVisibility();
        r9.updateContainerPagerCache(r8);
        return Unit.INSTANCE;
    }

    private final void setupCutOffBottomColor() {
        Integer r0 = com.obric.memorydata.ui.custom.a.c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.OFloatingTitleBarCutoffAreaColor, "attr", "OFloatingTitleBarCutoffAreaColor"));
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.shouldShowCutOffBottom = r3;
        ActivityMemoryListBinding r5 = null;
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L19;
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = new StringBuilder().append("[CutOffDiag][Activity] setupCutOffBottomColor color=").append(r0).append(" alpha=");
        if (r0 == null) goto L13;
        Integer r1 = Integer.valueOf(Color.alpha(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue()));
    L14:
        StringBuilder r2 = r4.append(r1).append(" shouldShow=").append(this.shouldShowCutOffBottom).append(" view=");
        ActivityMemoryListBinding r7 = this.binding;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L17:
        IRunLog.a.a(r6, TAG, r2.append(viewDiag(r7.cutOffBottom)).toString(), false, 4, null);
        goto L19
    L13:
        r1 = null;
    L19:
        if (this.shouldShowCutOffBottom == false) goto L26;
        if (r0 == null) goto L26;
        ActivityMemoryListBinding r12 = this.binding;
        if (r12 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L25:
        r5.cutOffBottom.setBackgroundColor(r0.intValue());
        return;
    L24:
        r5 = r12;
    L26:
        setCutOffBottomVisibility("setupCutOffBottomColor.transparent", false);
        return;
    L5:
        if (Color.alpha(r0.intValue()) == 0) goto L7;
        r3 = true;
        goto L8
    }

    private final void syncBottomNavigationSelection(MemoryContainerTab r4) {
        if (r4 == null) goto L10;
        Integer r5 = r.f11329a.a(r4, this.contextAwarenessTabVisible, this.autoMemoryTaskAvailable);
        if (r5 == null) goto L11;
        int r6 = r5.intValue();
        ActivityMemoryListBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        r3.memoryContainerTabView.getNavigationBar().setCurrentTab(r6);
        return;
    L11:
        return;
    }

    public static /* synthetic */ void syncCurrentFloatingTitleBar$default(MemoryListActivity r2, OFloatingTitleBar r3, boolean r4, int r5, Object r6) {
        MemoryListActivity r7 = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r4 = true;
    L7:
        r7.syncCurrentFloatingTitleBar(r3, r4);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncCurrentFloatingTitleBar");
    }

    public static /* synthetic */ void trackContainerPageShow$default(MemoryListActivity r2, MemoryContainerTab r3, boolean r4, int r5, Object r6) {
        MemoryListActivity r7 = (MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r4 = true;
    L7:
        r7.trackContainerPageShow(r3, r4);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackContainerPageShow");
    }

    private final void updateContainerPagerCache(int r7) {
        ActivityMemoryListBinding r0 = this.binding;
        ActivityMemoryListBinding r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        if (r0.memoryTabContainer.getAdapter() != null) goto L8;
        return;
    L8:
        int r2 = RangesKt.coerceAtLeast(r7 - 1, 1);
        ActivityMemoryListBinding r3 = this.binding;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L12:
        if (r3.memoryTabContainer.getOffscreenPageLimit() == r2) goto L18;
        ActivityMemoryListBinding r4 = this.binding;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L16:
        r4.memoryTabContainer.setOffscreenPageLimit(r2);
    L18:
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L25;
        RunLog r5 = RunLog.INSTANCE;
        StringBuilder r8 = new StringBuilder().append("[TabSwitchDiag] fragmentCount=").append(r7).append(" offscreenPageLimit=").append(r2).append(" current=");
        ActivityMemoryListBinding r6 = this.binding;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L23:
        r5.debug(TAG, r8.append(r1.memoryTabContainer.getCurrentItem()).toString());
        return;
    L22:
        r1 = r6;
        goto L23
    }

    private final void updateCutOffBottomFromNavBar(View r11, View r12) {
        if (r11.getHeight() > 0) goto L5;
        return;
    L5:
        int[] r0 = new int[2];
        r11.getLocationInWindow(r0);
        int r1 = r0[1];
        int r2 = getWindow().getDecorView().getHeight();
        if (r2 > 0) goto L8;
        return;
    L8:
        int r3 = RangesKt.coerceAtLeast(r2 - r1, 0);
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "updateCutOffBottomFromNavBar: navBarTopInWindow=" + r1 + ", windowHeight=" + r2 + ", targetHeight=" + r3 + ", navBarHeight=" + r11.getHeight() + ", shouldShow=" + this.shouldShowCutOffBottom + ", bg=" + viewDiag(r12), false, 4, null);
    L11:
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if (r13 != null) goto L14;
    L16:
        ActivityMemoryListBinding r14 = this.binding;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L19:
        r14.getRoot().post(new $$Lambda$MemoryListActivity$UDvdd3g_ljMKqvRmYLgpJnV2wCo(this));
        return;
    L14:
        if (r13.height == r3) goto L16;
        r13.height = r3;
        r12.setLayoutParams(r13);
        goto L16
    }

    private static final void updateCutOffBottomFromNavBar$lambda$8(MemoryListActivity r2) {
        ((MemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryListActivity.class, "com.obric.memorydata.plugin")).dumpActivityClipDiag("updateCutOffBottomFromNavBar.afterLayout");
    }

    private final void updateTargetMemoryEntity(Intent r19, Function1<? super com.obric.memorydata.memory.ui.list.contextawareness.v, Unit> r20) {
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r20, Function1.class, "com.obric.memorydata.plugin");
        MemoryEventTracker.PageShowParams r4 = null;
        this.lastPageSelection = null;
        getShareViewModel().resetTargetEntityConsumeStatus();
        getShareViewModel().setTargetPersonalTag(r19.getStringExtra(ARG_TARGET_PERSONAL_TAG));
        boolean r7 = false;
        getShareViewModel().setForceCollectAllForTarget(r19.getBooleanExtra(ARG_FORCE_COLLECT_ALL, false));
        String r5 = r19.getStringExtra("from");
        if (r5 != null) goto L5;
        r5 = MemoryEventTracker.SourceType.DESKTOP_ICON.getValue();
    L5:
        String r10 = r5;
        getShareViewModel().setEnterFrom(r10);
        AppEntity r9 = (AppEntity) ZeusTransformUtils.preCheckCast(r19.getParcelableExtra("entity"), AppEntity.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        MemoryTab r1 = com.obric.memorydata.memory.utils.f.f11537a.a(r9);
    L9:
        if (r9 == null) goto L11;
        com.obric.memorydata.memory.ui.list.contextawareness.v r6 = com.obric.memorydata.memory.ui.list.contextawareness.s.f11287a.a(com.obric.memorydata.memory.utils.f.f11537a.a(r9), r9.getId());
    L12:
        r2.invoke(r6);
        if (r9 == null) goto L30;
        getShareViewModel().getSelectionManager().j();
        MemoryContainerTab r8 = getContainerTab(r9);
        MemoryTabContainerAdapter r11 = this.tabContainerPagerAdapter;
        if (r11 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r11 = null;
    L18:
        if (r11.hasFragment(r8) == false) goto L30;
        MemoryTabContainerAdapter r12 = this.tabContainerPagerAdapter;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r12 = null;
    L22:
        Integer r13 = Integer.valueOf(r12.getTabPosition(r8));
        if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L25;
        r7 = true;
    L25:
        if (r7 == true) goto L28;
        r13 = null;
    L28:
        if (r13 == null) goto L30;
        selectContainerTab(((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).intValue());
    L30:
        selectTargetContainerTabIfNeeded();
        MemoryTabContainerAdapter r3 = this.tabContainerPagerAdapter;
        if (r3 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r3 = null;
    L33:
        ActivityMemoryListBinding r14 = this.binding;
        if (r14 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L36:
        MemoryContainerTab r15 = r3.getTab(r14.memoryTabContainer.getCurrentItem());
        if (r15 != null) goto L39;
        int r16 = -1;
    L40:
        if (r16 != 1) goto L42;
    L44:
        String r17 = r15.getText();
    L45:
        String r18 = r17;
        MemoryEventTracker r21 = MemoryEventTracker.f10515a;
        String r110 = MemoryEventTracker.MemoryPage.MEMORY_LIST.getValue();
        String r111 = getPageShowTagName(r18, r9);
        String r22 = getShareViewModel().getSelectedTag();
        if (Intrinsics.areEqual(r18, MemoryTab.PROFILE.getText()) == false) goto L48;
        String r112 = r22;
    L49:
        MemoryEventTracker.a(r21, r9, r10, r110, null, r18, r111, r112, 8, null);
        if (r15 == null) goto L52;
        r4 = createTabPageShowParams(r15);
    L52:
        this.lastPageSelection = r4;
        return;
    L48:
        r112 = null;
        goto L49
    L42:
        if (r16 == 2) goto L44;
        r17 = getShareViewModel().getMixTab(r1);
        goto L45
    L39:
        r16 = b.f11034a[r15.ordinal()];
        goto L40
    L11:
        r6 = null;
        goto L12
    L8:
        r1 = null;
        goto L9
    }

    private final String viewDiag(View r6) {
        if (r6 != null) goto L5;
        return "null";
    L5:
        int[] r5 = new int[2];
        r6.getLocationInWindow(r5);
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L8;
        String r0 = ",clipChildren=" + ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getClipChildren() + ",clipToPadding=" + ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getClipToPadding() + ",childCount=" + ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
    L9:
        StringBuilder r1 = new StringBuilder();
        r1.append(r6.getClass().getSimpleName()).append('@').append(r5[0]).append(',').append(r5[1]).append(" size=").append(r6.getWidth()).append('x').append(r6.getHeight()).append(" top=").append(r6.getTop()).append(" bottom=").append(r6.getBottom()).append(" padding=").append(r6.getPaddingLeft()).append(',').append(r6.getPaddingTop()).append(',').append(r6.getPaddingRight()).append(',').append(r6.getPaddingBottom()).append(" visible=").append(r6.getVisibility());
        r1.append(" alpha=").append(r6.getAlpha()).append(" tx=").append(r6.getTranslationX()).append(" ty=").append(r6.getTranslationY()).append(r0);
        return r1.toString();
    L8:
        r0 = "";
        goto L9
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

    @Override // com.obric.memorydata.ui.BaseActivity, com.obric.memorydata.ui.b
    public OFloatingTitleBar getCurrentFloatingTitleBar() {
        ActivityMemoryListBinding r0 = this.binding;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L7:
        OFloatingTitleBar r1 = r0.floatingTitleBarActionHost.getBoundTitleBar();
        if (r1 == null) goto L10;
        return r1;
    L10:
        return currentPageTitleBar();
    }

    @Override // com.obric.memorydata.ui.BaseActivity, com.obric.memorydata.ui.b
    public OFloatingTitleBarActionHost getCurrentFloatingTitleBarActionHost() {
        ActivityMemoryListBinding r0 = this.binding;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L7:
        OFloatingTitleBarActionHost r1 = r0.floatingTitleBarActionHost;
        Intrinsics.checkNotNullExpressionValue(r1, "floatingTitleBarActionHost");
        if (r1.getBoundTitleBar() != getCurrentFloatingTitleBar()) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L13;
        return null;
    L13:
        return r1;
    L10:
        r3 = false;
        goto L11
    }

    @Override // com.obric.memorydata.memory.ui.BaseMemoryActivity
    public String getEnterFrom() {
        return (String) ZeusTransformUtils.preCheckCast(getShareViewModel().getEnterFrom().c(), String.class, "com.obric.memorydata.plugin");
    }

    public final boolean handles(OFloatingTitleBar r2) {
        Intrinsics.checkNotNullParameter(r2, "titleBar");
        ActivityMemoryListBinding r1 = this.binding;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L6:
        if (r1.floatingTitleBarActionHost.getBoundTitleBar() != r2) goto L8;
        return true;
    L8:
        return false;
    }

    public final void initStatusBar() {
        setupInset();
        Window r0 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r0, "getWindow(...)");
        com.obric.memorydata.ui.g.a(r0, NavigationBarScheme.A);
        WindowInsetsControllerCompat r1 = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        Intrinsics.checkNotNullExpressionValue(r1, "getInsetsController(...)");
        if ((ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r2 = true;
    L6:
        Window r5 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r5, "getWindow(...)");
        com.obric.memorydata.ui.g.a(r5, !r2);
        if (r2 == false) goto L9;
        r1.setAppearanceLightStatusBars(false);
    L10:
        ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), $$Lambda$MemoryListActivity$8z7Ik6OdD9ube8HL7sypNW1RrU.INSTANCE);
        ViewCompat.requestApplyInsets(getWindow().getDecorView());
        return;
    L9:
        r1.setAppearanceLightStatusBars(true);
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.obric.memorydata.memory.ui.BaseMemoryActivity, com.obric.memorydata.ui.BaseActivity
    public boolean needLoginCheckOnCreate() {
        return false;
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L5;
        getShareViewModel().getSelectionManager().j();
        return;
    L5:
        super.onBackPressed();
    }

    @Override // com.obric.memorydata.ui.BaseAuthActivity, com.obric.memorydata.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r12) {
        initStatusBar();
        super.onCreate(r12);
        if (checkAdditionalPageAccess() == true) goto L5;
        return;
    L5:
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("onCreate taskId=").append(getTaskId()).append(", isTaskRoot=").append(isTaskRoot()).append(", jumpSource=");
        Intent r1 = getIntent();
        if (r1 == null) goto L8;
        String r2 = r1.getStringExtra(JUMP_SOURCE);
    L9:
        IRunLog.a.a(r3, TAG, r0.append(r2).toString(), false, 4, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "no animation", false, 4, null);
        if (Intrinsics.areEqual(getIntent().getStringExtra(JUMP_SOURCE), JUMP_FROM_DETAIL) == false) goto L13;
        overridePendingTransition(ZeusTransformUtils.mapRes(R.anim.host_oui_activity_close_enter, "anim", "host_oui_activity_close_enter"), ZeusTransformUtils.mapRes(R.anim.host_oui_activity_close_exit, "anim", "host_oui_activity_close_exit"));
    L13:
        if (checkAgreePrivacyAndLogin() == true) goto L15;
        return;
    L15:
        MemoryListShareViewModel r4 = getShareViewModel();
        if (r12 != null) goto L18;
    L20:
        boolean r5 = false;
    L21:
        r4.restoreGlassesVisibility$memory_obricRelease(r5);
        if (r12 != null) goto L24;
    L26:
        boolean r6 = false;
    L27:
        if (r6 == false) goto L29;
        getShareViewModel().requestGlassesLanding();
    L29:
        consumeGlassesLandingIntent();
        com.obric.memorydata.memory.migration.a.f10330a.a();
        ActivityMemoryListBinding r7 = ActivityMemoryListBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r7, "inflate(...)");
        this.binding = r7;
        if (r7 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L32:
        setContentView((View) ZeusTransformUtils.preCheckCast(r7.getRoot(), View.class, "com.obric.memorydata.plugin"));
        getSupportFragmentManager().registerFragmentLifecycleCallbacks((FragmentManager.FragmentLifecycleCallbacks) ZeusTransformUtils.preCheckCast(this.floatingTitleBarLifecycleCallbacks, FragmentManager.FragmentLifecycleCallbacks.class, "com.obric.memorydata.plugin"), false);
        this.currentTabTitles.clear();
        ActivityMemoryListBinding r8 = this.binding;
        if (r8 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L35:
        OBottomNavigationBar r9 = r8.memoryContainerTabView;
        Intrinsics.checkNotNullExpressionValue(r9, "memoryContainerTabView");
        com.obric.memorydata.ui.custom.a.a(r9);
        ActivityMemoryListBinding r10 = this.binding;
        if (r10 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L38:
        r10.getRoot().post(new $$Lambda$MemoryListActivity$er5h9TUaeoDGyWDrk1RDKLy8(this));
        setupCutOffBottomColor();
        setupContainerViewPager();
        observeState();
        observeContextAwarenessTabVisibility();
        getShareViewModel().registerGlobalMemoryObserver();
        this.globalMemoryObserverRegistered = true;
        final com.obric.memorydata.memory.ui.list.contextawareness.e r13 = restoreContextAwarenessTargetSnapshot(r12);
        Intent r11 = getIntent();
        Intrinsics.checkNotNullExpressionValue(r11, "getIntent(...)");
        updateTargetMemoryEntity(r11, new $$Lambda$MemoryListActivity$JCsVWOoEy9ZVl2gzbvy0r2elqi8(this, r13));
        Intent r14 = getIntent();
        Intrinsics.checkNotNullExpressionValue(r14, "getIntent(...)");
        consumePendingPersonalInfoIntent(r14);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11623(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L24:
        if (r12.getBoolean(STATE_GLASSES_LANDING_PENDING) != true) goto L26;
        r6 = true;
        goto L27
    L18:
        if (r12.getBoolean(STATE_KEEP_GLASSES) != true) goto L20;
        r5 = true;
        goto L21
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.obric.memorydata.ui.BaseAuthActivity, com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        getSupportFragmentManager().unregisterFragmentLifecycleCallbacks((FragmentManager.FragmentLifecycleCallbacks) ZeusTransformUtils.preCheckCast(this.floatingTitleBarLifecycleCallbacks, FragmentManager.FragmentLifecycleCallbacks.class, "com.obric.memorydata.plugin"));
        ActivityMemoryListBinding r0 = this.binding;
        if (r0 != null) goto L5;
    L20:
        this.bottomTabSelectListener = null;
        this.containerPageChangeCallback = null;
        if (this.binding == null) goto L24;
        getShareViewModel().getSelectionManager().j();
    L24:
        if (this.globalMemoryObserverRegistered == false) goto L26;
        this.globalMemoryObserverRegistered = false;
        getShareViewModel().unregisterGlobalMemoryObserver();
    L26:
        com.obric.memorydata.utils.icon.b.f13229a.b();
        super.onDestroy();
        return;
    L5:
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L7:
        r0.memoryContainerTabView.getNavigationBar().setOnTabSelectListener(null);
        ViewPager2.OnPageChangeCallback r1 = this.containerPageChangeCallback;
        if (r1 == null) goto L13;
        ActivityMemoryListBinding r3 = this.binding;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L12:
        r3.memoryTabContainer.unregisterOnPageChangeCallback(r1);
    L13:
        ActivityMemoryListBinding r2 = this.binding;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L16:
        r2.memoryContainerTabView.getNavigationBar().removeOnLayoutChangeListener(this.cutOffBottomLayoutListener);
        ActivityMemoryListBinding r4 = this.binding;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L19:
        r4.memoryTabContainer.setAdapter(null);
        goto L20
    }

    @Override // androidx.activity.ComponentActivity
    public void onNewIntent(Intent r9) {
        super.onNewIntent(r9);
        if (r9 != null) goto L6;
        getShareViewModel().replaceContextAwarenessTargetFromNewIntent$memory_obricRelease(null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onNewIntent with null intent", null, 4, null);
        return;
    L6:
        setIntent(r9);
        if (checkAdditionalPageAccess() == true) goto L10;
        getShareViewModel().replaceContextAwarenessTargetFromNewIntent$memory_obricRelease(null);
        return;
    L10:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onNewIntent taskId=" + getTaskId() + ", hasJumpSource=" + r9.hasExtra(JUMP_SOURCE), false, 4, null);
        consumeGlassesLandingIntent();
        updateTargetMemoryEntity(r9, (Function1) ZeusTransformUtils.preCheckCast(new C11631(getShareViewModel()), Function1.class, "com.obric.memorydata.plugin"));
        Intent r10 = getIntent();
        Intrinsics.checkNotNullExpressionValue(r10, "getIntent(...)");
        consumePendingPersonalInfoIntent(r10);
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onResumeChecked() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onResumeChecked", false, 4, null);
        ActivityMemoryListBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        final OFloatingTitleBarActionHost r1 = r0.floatingTitleBarActionHost;
        Intrinsics.checkNotNullExpressionValue(r1, "floatingTitleBarActionHost");
        OFloatingTitleBar r2 = r1.getBoundTitleBar();
        if (r2 != null) goto L8;
    L10:
        com.obric.memorydata.memory.ui.settings.l.f11479a.a().z();
        return;
    L8:
        if (currentPageTitleBar() != r2) goto L10;
        r2.setFloatingTransitionEndListener(new $$Lambda$MemoryListActivity$JUlA0VhU8PQPGdhlMjJR9vL5sMA(this, r1));
        r1.a(r2, false);
        goto L10
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onSaveInstanceState(Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "outState");
        super.onSaveInstanceState(r4);
        r4.putBoolean(STATE_KEEP_GLASSES, getShareViewModel().getKeepGlassesForVisit$memory_obricRelease());
        r4.putBoolean(STATE_GLASSES_LANDING_PENDING, ((Boolean) ZeusTransformUtils.preCheckCast(getShareViewModel().getGlassesLandingPending().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        saveContextAwarenessTargetSnapshot(r4, getShareViewModel().contextAwarenessLaunchTargetSnapshot$memory_obricRelease());
    }

    public final void setBottomControlsVisibleFromChild(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, InfoRequestQPSOptTraceLogger.REASON);
        setBottomTabVisibility(r3, r4);
        if (r4 == false) goto L5;
        refreshCutOffBottomHeight();
        MemoryListShareViewModel r0 = getShareViewModel();
        boolean r1 = true;
    L6:
        r0.setIsLayoutBottomTabState(r1);
        dumpActivityClipDiag("setBottomControlsVisibleFromChild reason=" + r3 + " visible=" + r4);
        return;
    L5:
        r1 = false;
        setCutOffBottomVisibility(r3 + ".cutOff", false);
        r0 = getShareViewModel();
        goto L6
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean skipOnCreateCustomLogic() {
        return true;
    }

    public final void syncCurrentFloatingTitleBar(OFloatingTitleBar r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "titleBar");
        if (currentPageTitleBar() == r5) goto L5;
        return;
    L5:
        ActivityMemoryListBinding r0 = this.binding;
        ActivityMemoryListBinding r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L8:
        int r2 = r0.memoryTabContainer.getCurrentItem();
        if (isInitialGlobalTitleBarBind(r2) == false) goto L12;
        scheduleFloatingTitleBarTransition(r2);
        return;
    L12:
        ActivityMemoryListBinding r4 = this.binding;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L16:
        r1.floatingTitleBarActionHost.a(r5, r6);
        return;
    L15:
        r1 = r4;
        goto L16
    }

    public final void trackContainerPageShow(MemoryContainerTab r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "tab");
        MemoryTabContainerAdapter r0 = this.tabContainerPagerAdapter;
        ActivityMemoryListBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabContainerPagerAdapter");
        r0 = null;
    L5:
        ActivityMemoryListBinding r2 = this.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L10:
        if (r0.getTab(r1.memoryTabContainer.getCurrentItem()) == r4) goto L12;
        return;
    L12:
        MemoryEventTracker.PageShowParams r3 = this.lastPageSelection;
        if (r3 != null) goto L15;
        return;
    L15:
        MemoryEventTracker.PageShowParams r6 = createTabPageShowParams(r4);
        if (r5 == false) goto L18;
    L20:
        this.lastPageSelection = r6;
        if (r5 == true) goto L23;
        return;
    L23:
        if (Intrinsics.areEqual(r3.getTabName(), r6.getTabName()) == true) goto L25;
    L30:
        MemoryEventTracker.f10515a.a((MemoryEventTracker.Params) ZeusTransformUtils.preCheckCast(r6, MemoryEventTracker.Params.class, "com.obric.memorydata.plugin"));
        return;
    L25:
        if (Intrinsics.areEqual(r3.getTagName(), r6.getTagName()) == false) goto L30;
        if (Intrinsics.areEqual(r3.getType(), r6.getType()) == false) goto L30;
        if (Intrinsics.areEqual(r3.getTag(), r6.getTag()) == false) goto L30;
        return;
    L18:
        if (Intrinsics.areEqual(r3.getTabName(), r6.getTabName()) == true) goto L20;
        return;
    L8:
        r1 = r2;
        goto L10
    }
}
