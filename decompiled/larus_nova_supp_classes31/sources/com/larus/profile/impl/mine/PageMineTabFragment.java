package com.larus.profile.impl.mine;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.router.SmartRouter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.ixigua.lib.track.TrackParams;
import com.larus.account.base.api.ILoginService;
import com.larus.avlink.api.AlbumServiceDelegate;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.chat.api.AiChatTraceDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.INotifyService;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.bmhome.view.CreateBotButton;
import com.larus.bot.api.IBotCreateService;
import com.larus.collection.impl.view.MineCollectFragment;
import com.larus.collection.impl.view.RevisitListTab;
import com.larus.commercecredit.api.ICommerceCreditService;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.IHomeApi;
import com.larus.home.impl.sdk.l1;
import com.larus.im.IInstantMessenger;
import com.larus.im.bean.IMCmd;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IFlowCreationThemeConfigProvider;
import com.larus.platform.api.IFlowProfileThemeConfigProvider;
import com.larus.platform.api.x0;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.larus.platform.service.z2;
import com.larus.profile.api.bean.LandingTab;
import com.larus.profile.impl.ProfileBotListFragment;
import com.larus.profile.impl.ProfileRequestSource;
import com.larus.profile.impl.databinding.LarusFragmentMineTabPageBinding;
import com.larus.profile.impl.databinding.LarusPageProfileInfoErrorBinding;
import com.larus.profile.impl.databinding.LarusPageProfileTabInfoLoadingBinding;
import com.larus.profile.impl.databinding.LarusPageProfileUserInfoSkeletonBinding;
import com.larus.profile.impl.databinding.LarusWidgetMineTabTitleBarBinding;
import com.larus.profile.impl.e2;
import com.larus.profile.impl.view.MineTabTitleBar;
import com.larus.profile.impl.view.ProfileHeaderUserInfoView;
import com.larus.settings.value.e10;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.AppBarLayoutStateListener;
import com.larus.voice_setting.voice.base.MainTabFragmentAction;
import com.larus.voice_setting.voice.base.ProfileInfoBaseFragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tx9.i2;
import tx9.s2;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Ë\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001E\u0018\u0000 £\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002£\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010J\u001a\u0002062\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0012\u0010M\u001a\u0002062\b\u0010N\u001a\u0004\u0018\u00010LH\u0016J&\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010T2\b\u0010N\u001a\u0004\u0018\u00010LH\u0016J\u0012\u0010U\u001a\u0002062\b\u0010V\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010W\u001a\u0002062\u0006\u0010X\u001a\u00020P2\b\u0010N\u001a\u0004\u0018\u00010LH\u0016J\n\u0010[\u001a\u0004\u0018\u00010\nH\u0002J\f\u0010\\\u001a\u000206*\u00020\nH\u0002J\u0012\u0010]\u001a\u0002062\b\u0010^\u001a\u0004\u0018\u00010PH\u0002J\f\u0010_\u001a\u000206*\u00020\nH\u0002J\u0013\u0010`\u001a\u0004\u0018\u00010\u001e*\u00020\nH\u0002¢\u0006\u0002\u0010aJ\u0013\u0010b\u001a\u0004\u0018\u00010\u001e*\u00020\nH\u0002¢\u0006\u0002\u0010aJ\f\u0010c\u001a\u00020\u001e*\u00020\nH\u0002J\u001c\u0010d\u001a\u000206*\u00020\n2\u0006\u0010e\u001a\u00020\u001e2\u0006\u0010f\u001a\u00020gH\u0002J\u001b\u0010h\u001a\u000206*\u00020\n2\b\u0010i\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010jJ\b\u0010k\u001a\u000206H\u0002J\u0006\u0010l\u001a\u000206J\u0006\u0010m\u001a\u000206J\n\u0010n\u001a\u0004\u0018\u00010oH\u0002J\b\u0010p\u001a\u000206H\u0002J\b\u0010q\u001a\u000206H\u0002J\n\u0010r\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010s\u001a\u0002062\u0006\u0010t\u001a\u00020\u00122\b\b\u0002\u0010u\u001a\u00020\u0012J\u0010\u0010v\u001a\u0002062\u0006\u0010t\u001a\u00020\u0012H\u0002J\u0010\u0010w\u001a\u0002062\u0006\u0010x\u001a\u00020\bH\u0016J\b\u0010y\u001a\u000206H\u0016J\b\u0010z\u001a\u000206H\u0016J\b\u0010{\u001a\u00020\u0012H\u0016J\u0010\u0010|\u001a\u0002062\u0006\u0010}\u001a\u00020\u0012H\u0016J\u0018\u0010~\u001a\u0002062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u007f\u001a\u00020\u0012H\u0016J\u0011\u0010\u0080\u0001\u001a\u0002062\b\u0010K\u001a\u0004\u0018\u00010LJ\t\u0010\u0081\u0001\u001a\u000206H\u0016J\t\u0010\u0082\u0001\u001a\u000206H\u0016J\t\u0010\u0083\u0001\u001a\u000206H\u0002J\t\u0010\u0084\u0001\u001a\u000206H\u0002J\t\u0010\u0085\u0001\u001a\u000206H\u0016J\t\u0010\u0086\u0001\u001a\u000206H\u0016J\t\u0010\u0087\u0001\u001a\u000206H\u0016J\t\u0010\u0088\u0001\u001a\u00020\bH\u0016J\t\u0010\u0089\u0001\u001a\u00020\u001eH\u0016J\f\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0016J\t\u0010\u008c\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u008d\u0001\u001a\u00020\bH\u0016J\t\u0010\u008e\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u008f\u0001\u001a\u000206H\u0016J\u001a\u0010\u0090\u0001\u001a\u0002062\u0006\u0010t\u001a\u00020\u00122\u0007\u0010\u0091\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u0092\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u0093\u0001\u001a\u00020\u0012H\u0016J\u0011\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u00030\u0096\u00010\u0095\u0001H\u0016J\u0012\u0010\u0097\u0001\u001a\u0002062\u0007\u0010\u0098\u0001\u001a\u00020\bH\u0016J\u001a\u0010\u0099\u0001\u001a\u0002062\u0007\u0010\u009a\u0001\u001a\u00020\b2\u0006\u0010y\u001a\u00020\u0012H\u0016J\u000b\u0010\u009b\u0001\u001a\u0004\u0018\u00010\bH\u0016J\t\u0010\u009d\u0001\u001a\u00020\u001eH\u0016J\u0014\u0010\u009e\u0001\u001a\u0002062\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bH\u0016J\t\u0010\u009f\u0001\u001a\u000206H\u0016J#\u0010 \u0001\u001a\u0002062\u0007\u0010¡\u0001\u001a\u00020\u00122\u000f\u0010¢\u0001\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b%\u0010&R\u0016\u0010(\u001a\n **\u0004\u0018\u00010)0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b-\u0010.R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R\u0010\u0010>\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010FR\u001b\u0010G\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u0010\u001a\u0004\bG\u0010HR\u0014\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001e0ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010x\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¤\u0001"}, d2 = {"Lcom/larus/profile/impl/mine/PageMineTabFragment;", "Lcom/larus/bmhome/BaseHomeTabFragment;", "Lcom/larus/profile/api/model/IPageMineTabFragment;", "Lcom/larus/voice_setting/voice/base/IMultiTabProfile;", "Lcom/larus/bmhome/ISideBarChildFragment;", "<init>", "()V", "tag", "", "binding", "Lcom/larus/profile/impl/databinding/LarusFragmentMineTabPageBinding;", "viewModel", "Lcom/larus/profile/impl/mine/MineTabViewModel;", "getViewModel", "()Lcom/larus/profile/impl/mine/MineTabViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "firstLoadUserInfo", "", "refreshUserInfoWhenFailed", "needLoading", "userInfo", "Lcom/larus/account/base/model/profile/UserInfo;", "appBarLayoutState", "Lcom/larus/voice_setting/voice/base/AppBarLayoutStateListener$State;", "scroll", "scrollStatusChangedWhenReset", "fromBotSetting", "isTabClicked", "privateCreationIndex", "", "creationIndex", "galleryIndex", "defaultTabSelector", "Lcom/larus/profile/impl/ProfileDefaultTabSelector;", "outerInputController", "Lcom/larus/bmhome/chat/outerinput/IOuterChatInputController;", "getOuterInputController", "()Lcom/larus/bmhome/chat/outerinput/IOuterChatInputController;", "outerInputController$delegate", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "im", "Lcom/larus/im/IInstantMessenger;", "getIm", "()Lcom/larus/im/IInstantMessenger;", "im$delegate", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isResumeable", "landingHasCreation", "showCreationCallback", "Lkotlin/Function0;", "", "getShowCreationCallback", "()Lkotlin/jvm/functions/Function0;", "setShowCreationCallback", "(Lkotlin/jvm/functions/Function0;)V", "dismissCallback", "getDismissCallback", "setDismissCallback", "defaultLandingTab", "defaultLandingIndex", "alwaysScroll", "appJustForeground", "wentBackgroundFromThisFragment", "isInTabForeground", "appBackgroundListener", "com/larus/profile/impl/mine/PageMineTabFragment$appBackgroundListener$1", "Lcom/larus/profile/impl/mine/PageMineTabFragment$appBackgroundListener$1;", "isSideBar", "()Z", "isSideBar$delegate", "onNewIntent", "bundle", "Landroid/os/Bundle;", "onCreate", "savedInstanceState", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "markRevisitListLanding", "landingTabName", "onViewCreated", "view", "titleBarUnReadCountObserver", "Landroidx/lifecycle/Observer;", "initView", "initTabLayout", "updateCommerceCreditProfileView", "commerceCreditProfileView", "updateTabLayoutDisplayMode", "updateScrollableTabItemWidth", "(Lcom/larus/profile/impl/databinding/LarusFragmentMineTabPageBinding;)Ljava/lang/Integer;", "getFixedTabItemWidth", "getTabLayoutWidth", "updateTabItemLayoutParams", "width", "weight", "", "updateTabTextSizeByTabWidth", "fallbackTabWidth", "(Lcom/larus/profile/impl/databinding/LarusFragmentMineTabPageBinding;Ljava/lang/Integer;)V", "refreshTabLayout", "forceSelectPrivateTab", "forceSelectCreationTab", "getCurrentFragment", "Landroidx/fragment/app/Fragment;", "initViewModel", "registerObservations", "updateBotCreateVisible", "enableAppBarLayoutScroll", "enable", "isReset", "setupChildScrollFlags", "startCreateBot", "enterMethod", "scrollToTop", "scrollToNormal", "isAppBarExpand", "setTabPagerSwipeEnabled", "enabled", "updateChildTabListState", "isEmpty", "onResult", "onStart", "onResume", "checkReusedNumber", "selectDefaultTab", "onPause", "onDestroyView", "onDestroy", "getPageName", "getContainerHeight", "parentTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "autoLogEnterPage", "getCurrentPageName", "scrollStatusChanged", "resetScrollStatusChanged", "enableScroll", "reset", "getScrollStatus", "needRefreshBotList", "getTabActionData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/voice_setting/voice/base/MainTabFragmentAction;", "selectTag", "selectedTag", "selectTab", "tab", "getSelectedTab", "previousPage", "tabIndex", "onEnterTab", "onLeaveTab", "onTabClick", "doubleClick", "callback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PageMineTabFragment extends BaseHomeTabFragment implements gs9.h, com.larus.voice_setting.voice.base.a, com.larus.bmhome.z {
    public static final /* synthetic */ int R = 0;
    public final Lazy A;
    public final CoroutineScope B;
    public boolean C;
    public boolean D;
    public Function0<Unit> E;
    public Function0<Unit> F;
    public String G;
    public int H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public final b M;
    public final Lazy N;
    public final e0 O;
    public String P;
    public String Q;
    public final String j;
    public LarusFragmentMineTabPageBinding k;
    public final Lazy l;
    public boolean m;
    public boolean n;
    public boolean o;
    public r38.b p;
    public AppBarLayoutStateListener.State q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public final com.larus.profile.impl.w x;
    public final Lazy y;
    public final Keva z;

    public static final class a {
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ PageMineTabFragment a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            PageMineTabFragment r0 = this.a;
            r0.K = r0.L;
        }

        public final void onAppForeground() {
            if (Intrinsics.areEqual(AppHost.a.a().getCurrentActivity(), this.a.getActivity()) == false) goto L5;
            this.a.J = true;
        L5:
            PageMineTabFragment r0 = this.a;
            if (r0.J == true) goto L8;
            return;
        L8:
            if (r0.K == false) goto L17;
            ProfileInfoBaseFragment r1 = r0.getCurrentFragment();
            if ((r1 instanceof ProfileInfoBaseFragment) == false) goto L12;
            ProfileInfoBaseFragment r2 = r1;
        L13:
            if (r2 == null) goto L18;
            r2.i = true;
            return;
        L18:
            return;
        L12:
            r2 = null;
            goto L13
        }

        public b(PageMineTabFragment r1) {
            this.a = r1;
        }
    }

    public static final class c implements TabLayout.OnTabSelectedListener {
        public final /* synthetic */ LarusFragmentMineTabPageBinding a;
        public final /* synthetic */ PageMineTabFragment b;

        public final void onTabReselected(TabLayout.Tab r1) {
        }

        public final void onTabSelected(TabLayout.Tab r5) {
            if (r5 != null) goto L5;
            return;
        L5:
            if (this.a.n.getCurrentItem() == r5.getPosition()) goto L11;
            this.b.u = true;
            this.a.n.setCurrentItem(r5.getPosition());
            if (r5.getPosition() != 0) goto L9;
            String r0 = "ai_bot";
        L10:
            i2.a("click", r0);
            goto L11
        L9:
            r0 = "own_voice";
        L11:
            View r1 = r5.getCustomView();
            if (r1 == null) goto L16;
            ImageView r2 = (ImageView) r1.findViewById(2131368250);
            if (r2 == null) goto L16;
            r2.setVisibility(0);
        L16:
            View r6 = r5.getCustomView();
            if (r6 == null) goto L21;
            ImageView r7 = (ImageView) r6.findViewById(2131375088);
            if (r7 == null) goto L21;
            e1.x(r7);
        L21:
            String r8 = this.b.CL();
            if (r8 == null) goto L27;
            com.larus.bmhome.a0 r3 = com.larus.bmhome.b0.a(this.b);
            if (r3 == null) goto L28;
            r3.J90(5, r8, null, "unknown");
            return;
        L28:
            return;
        }

        public final void onTabUnselected(TabLayout.Tab r3) {
            if (r3 == null) goto L9;
            View r0 = r3.getCustomView();
            if (r0 == null) goto L9;
            ImageView r1 = (ImageView) r0.findViewById(2131368250);
            if (r1 == null) goto L9;
            r1.setVisibility(8);
        L9:
            if (com.larus.bmhome.utils.u.i() == false) goto L17;
            if (r3 == null) goto L18;
            View r4 = r3.getCustomView();
            if (r4 == null) goto L19;
            View r5 = r4.findViewById(2131375088);
            if (r5 == null) goto L20;
            e1.o(r5);
            return;
        L20:
            return;
        L19:
            return;
        L18:
            return;
        }

        public c(LarusFragmentMineTabPageBinding r1, PageMineTabFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public d(Function1 r2) {
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

    public static final class e implements com.larus.profile.impl.w.b {
        public e() {
        }

        @Override // com.larus.profile.impl.w.b
        public final void a(e2 r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "tabData");
            FLogger r0 = FLogger.a;
            int r1 = BaseHomeTabFragment.i;
            r0.i("BaseHomeTabFragment", "setOnTabSelectedCallback PageMineTabFragment position: " + r5);
            if (Intrinsics.areEqual(r4.b.name(), "ALBUM") == false) goto L8;
            x0 r6 = AlbumServiceDelegate.b.b();
            if (r6 == null) goto L9;
            r6.k00();
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.mine.PageMineTabFragment$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.mine.PageMineTabFragment$onCreate$1", f = "PageMineTabFragment.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PageMineTabFragment this$0;

        /* JADX INFO: renamed from: com.larus.profile.impl.mine.PageMineTabFragment$onCreate$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00151<T> implements FlowCollector {
            public final /* synthetic */ PageMineTabFragment a;

            /* JADX INFO: renamed from: com.larus.profile.impl.mine.PageMineTabFragment$onCreate$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
            @DebugMetadata(c = "com.larus.profile.impl.mine.PageMineTabFragment$onCreate$1$1$1", f = "PageMineTabFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C00161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ PageMineTabFragment this$0;

                public C00161(PageMineTabFragment r1, Continuation<? super C00161> r2) {
                    this.this$0 = r1;
                    super(2, r2);
                }

                public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                    return new C00161(this.this$0, r3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object r2) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L14;
                    ResultKt.throwOnFailure(r2);
                    PageMineTabFragment r3 = this.this$0;
                    LarusFragmentMineTabPageBinding r0 = r3.k;
                    if (r0 == null) goto L12;
                    TabLayout r1 = r0.l;
                    if (r1 == null) goto L12;
                    TabLayout.Tab r4 = r1.getTabAt(r3.v);
                    if (r4 == null) goto L12;
                    r4.select();
                L12:
                    return Unit.INSTANCE;
                L14:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.larus.profile.impl.mine.PageMineTabFragment$onCreate$1$1$2, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
            @DebugMetadata(c = "com.larus.profile.impl.mine.PageMineTabFragment$onCreate$1$1$2", f = "PageMineTabFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ PageMineTabFragment this$0;

                public AnonymousClass2(PageMineTabFragment r1, Continuation<? super AnonymousClass2> r2) {
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

                public final Object invokeSuspend(Object r2) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L14;
                    ResultKt.throwOnFailure(r2);
                    PageMineTabFragment r3 = this.this$0;
                    LarusFragmentMineTabPageBinding r0 = r3.k;
                    if (r0 == null) goto L12;
                    TabLayout r1 = r0.l;
                    if (r1 == null) goto L12;
                    TabLayout.Tab r4 = r1.getTabAt(r3.w);
                    if (r4 == null) goto L12;
                    r4.select();
                L12:
                    return Unit.INSTANCE;
                L14:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.larus.profile.impl.mine.PageMineTabFragment$onCreate$1$1$3, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
            @DebugMetadata(c = "com.larus.profile.impl.mine.PageMineTabFragment$onCreate$1$1$3", f = "PageMineTabFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ PageMineTabFragment this$0;

                public AnonymousClass3(PageMineTabFragment r1, Continuation<? super AnonymousClass3> r2) {
                    this.this$0 = r1;
                    super(2, r2);
                }

                public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                    return new AnonymousClass3(this.this$0, r3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object r2) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L10;
                    ResultKt.throwOnFailure(r2);
                    Function0<Unit> r3 = this.this$0.E;
                    if (r3 == null) goto L8;
                    r3.invoke();
                L8:
                    return Unit.INSTANCE;
                L10:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            public C00151(PageMineTabFragment r1) {
                this.a = r1;
            }

            public final Object a(IMCmd r8, Continuation<? super Unit> r9) {
                if ((r9 instanceof PageMineTabFragment$onCreate$1$1$emit$1) == false) goto L7;
                PageMineTabFragment$onCreate$1$1$emit$1 r0 = (PageMineTabFragment$onCreate$1$1$emit$1) r9;
                int r1 = r0.label;
                if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
                r0.label = r1 - Integer.MIN_VALUE;
            L8:
                Object r10 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L17;
                if (r3 == 1) goto L16;
                if (r3 == 2) goto L16;
                if (r3 != 3) goto L15;
                ResultKt.throwOnFailure(r10);
            L42:
                return Unit.INSTANCE;
            L15:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L16:
                ResultKt.throwOnFailure(r10);
            L37:
                if (com.larus.bmhome.utils.u.d() == false) goto L44;
                MainCoroutineDispatcher r11 = Dispatchers.getMain();
                AnonymousClass3 r12 = new AnonymousClass3(this.a, null);
                r0.label = 3;
                if (BuildersKt.withContext(r11, r12, r0) != r2) goto L42;
                return r2;
            L44:
                return Unit.INSTANCE;
            L17:
                ResultKt.throwOnFailure(r10);
                Integer r13 = r8.getCmdType();
                if (r13 == null) goto L44;
                if (r13.intValue() != 10001) goto L44;
                PageMineTabFragment r14 = this.a;
                if (r14.C == true) goto L44;
                r14.z.storeBoolean("has_unread_creation", true);
                if (com.larus.bmhome.utils.u.i() == false) goto L32;
                if (com.larus.bmhome.utils.u.a() == false) goto L32;
                MainCoroutineDispatcher r15 = Dispatchers.getMain();
                C00161 r16 = new C00161(this.a, null);
                r0.label = 1;
                if (BuildersKt.withContext(r15, r16, r0) != r2) goto L37;
                return r2;
            L32:
                if (com.larus.bmhome.utils.u.a() == false) goto L37;
                MainCoroutineDispatcher r17 = Dispatchers.getMain();
                AnonymousClass2 r18 = new AnonymousClass2(this.a, null);
                r0.label = 2;
                if (BuildersKt.withContext(r17, r18, r0) != r2) goto L37;
                return r2;
            L7:
                r0 = new PageMineTabFragment$onCreate$1$1$emit$1(this, r9);
                goto L8
            }

            public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
                return a((IMCmd) r1, r2);
            }
        }

        public AnonymousClass1(PageMineTabFragment r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IInstantMessenger r6 = (IInstantMessenger) this.this$0.A.getValue();
            if (r6 == null) goto L16;
            MutableSharedFlow r7 = r6.e();
            if (r7 == null) goto L16;
            C00151 r2 = new C00151(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.mine.PageMineTabFragment$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.mine.PageMineTabFragment$onResume$1", f = "PageMineTabFragment.kt", i = {}, l = {1041}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C01031(Continuation<? super C01031> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C01031(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L13:
            String r5 = (String) r4;
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ICreationPageService r6 = (ICreationPageService) ServiceManager.get().getService(ICreationPageService.class);
            if (r6 == null) goto L15;
            this.label = 1;
            r4 = r6.c(this);
            if (r4 != r0) goto L13;
            return r0;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.larus.profile.impl.mine.e0] */
    public PageMineTabFragment() {
        super(false);
        this.j = "PageMineTabFragment" + hashCode();
        final Function0<Fragment> r1 = new PageMineTabFragment$special$$inlined$viewModels$default$1(this);
        this.l = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MineTabViewModel.class), new PageMineTabFragment$special$$inlined$viewModels$default$2(r1), new PageMineTabFragment$special$$inlined$viewModels$default$3(r1, this));
        this.m = true;
        this.o = true;
        this.q = AppBarLayoutStateListener.State.EXPANDED;
        this.v = 1;
        this.x = new com.larus.profile.impl.w();
        this.y = LazyKt.lazy(new b0(this));
        this.z = Keva.getRepo("creation_landing", 0);
        this.A = LazyKt.lazy(new c0());
        this.B = CoroutineScopeKt.CoroutineScope(CoroutineScopeKt.MainScope().getCoroutineContext().plus(Dispatchers.getIO()));
        this.H = -1;
        this.M = new b(this);
        this.N = LazyKt.lazy(new d0(this));
        this.O = new e0(this);
    }

    public final void KC(boolean r1, Function0<Unit> r2) {
    }

    public final boolean S90() {
        return false;
    }

    public final void UM() {
        this.s = false;
    }

    public final void a2(Bundle r1) {
    }

    public final String getPageName() {
        return "personal_homepage";
    }

    public final String k() {
        return "bot_list_profile";
    }

    public final void pp(String r1) {
    }

    public final void t1() {
        this.L = false;
        LarusFragmentMineTabPageBinding r0 = this.k;
        MyInfoAdapter r1 = null;
        if (r0 == null) goto L7;
        ViewPager2 r2 = r0.n;
        if (r2 == null) goto L7;
        RecyclerView.Adapter r3 = r2.getAdapter();
    L9:
        if ((r3 instanceof MyInfoAdapter) == false) goto L11;
        r1 = (MyInfoAdapter) r3;
    L11:
        if (r1 == null) goto L16;
        Iterator<ProfileInfoBaseFragment> r4 = r1.b.iterator();
    L14:
        if (r4.hasNext() == false) goto L18;
        r4.next().T90();
        goto L14
    L18:
        return;
    L16:
        return;
    L7:
        r3 = null;
        goto L9
    }

    @Override // gs9.h
    public final String CL() {
        CopyOnWriteArrayList<e2> r0 = this.x.c;
        LarusFragmentMineTabPageBinding r1 = this.k;
        if (r1 == null) goto L7;
        ViewPager2 r2 = r1.n;
        if (r2 == null) goto L7;
        int r3 = r2.getCurrentItem();
    L8:
        e2 r4 = (e2) CollectionsKt.getOrNull(r0, r3);
        if (r4 == null) goto L15;
        LandingTab r5 = r4.b;
        if (r5 == null) goto L15;
        String r6 = r5.name();
        if (r6 == null) goto L15;
        return r6.toLowerCase();
    L15:
        return null;
    L7:
        r3 = 0;
        goto L8
    }

    public final MineTabViewModel aa0() {
        return (MineTabViewModel) this.l.getValue();
    }

    public final boolean ca0() {
        return ((Boolean) this.N.getValue()).booleanValue();
    }

    public final void da0() {
        com.larus.profile.impl.w r0 = this.x;
        e r1 = new e();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "callback");
        r0.a = r1;
        LarusFragmentMineTabPageBinding r2 = this.k;
        if (r2 == null) goto L47;
        TabLayout r3 = r2.l;
        if (r3 != null) goto L7;
        return;
    L7:
        if (this.D == true) goto L9;
    L11:
        boolean r4 = false;
    L13:
        if (ca0() == false) goto L23;
        String r5 = this.G;
        if (r5 != null) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == false) goto L23;
        boolean r7 = true;
    L24:
        Iterator<e2> r8 = this.x.c.iterator();
        int r9 = 0;
    L26:
        if (r8.hasNext() == false) goto L34;
        e2 r10 = r8.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        if (StringsKt.equals(r10.b.name(), this.G, true) == false) goto L33;
        this.H = r9;
        this.x.e(r9);
        r4 = false;
        r7 = false;
    L33:
        r9 = r11;
        goto L26
    L34:
        FLogger r12 = FLogger.a;
        r12.i("BaseHomeTabFragment", "selectDefaultTab, isLandingCreation: " + r4 + ", isLandingFirst: " + r7 + ", defaultLandingTab: " + this.G);
        boolean r13 = this.x.d(r3, r4, r7, this.v);
        StringBuilder r14 = new StringBuilder("selectDefaultTab, result: ");
        r14.append(r13);
        r12.i("BaseHomeTabFragment", r14.toString());
        if (r13 == false) goto L49;
        LarusFragmentMineTabPageBinding r15 = this.k;
        if (r15 == null) goto L50;
        LarusPageProfileTabInfoLoadingBinding r16 = r15.j;
        if (r16 == null) goto L51;
        ConstraintLayout r17 = r16.a;
        if (r17 == null) goto L52;
        r17.setVisibility(8);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L17:
        if (r5.length() == 0) goto L20;
        r6 = false;
    L23:
        r7 = false;
        goto L24
    L9:
        if (com.larus.bmhome.utils.u.a() == false) goto L11;
        r4 = true;
        goto L13
    }

    public final LarusFragmentMineTabPageBinding fa0() {
        final LarusFragmentMineTabPageBinding r0 = this.k;
        if (r0 == null) goto L7;
        IFlowCreationThemeConfigProvider r1 = (IFlowCreationThemeConfigProvider) ServiceManager.get().getService(IFlowCreationThemeConfigProvider.class);
        if (r1 == null) goto L9;
        r1.b(r0.c, new l0(this, r0), AdaptThemeFeatureKey.CREATION_PAGE_MINE_TAB_BOT_CREATE);
        return r0;
    L9:
        return r0;
    L7:
        return null;
    }

    public final Fragment getCurrentFragment() {
        LarusFragmentMineTabPageBinding r2 = this.k;     // Catch: Exception -> L19
        if (r2 == null) goto L24;
        ViewPager2 r3 = r2.n;     // Catch: Exception -> L19
        if (r3 == null) goto L25;
        int r4 = r3.getCurrentItem();     // Catch: Exception -> L19
        FragmentManager r5 = getChildFragmentManager();     // Catch: Exception -> L19
        if (r5 == null) goto L26;
        StringBuilder r6 = new StringBuilder("f");     // Catch: Exception -> L19
        LarusFragmentMineTabPageBinding r0 = this.k;     // Catch: Exception -> L19
        if (r0 == null) goto L16;
        ViewPager2 r1 = r0.n;     // Catch: Exception -> L19
        if (r1 == null) goto L16;
        RecyclerView.Adapter r7 = r1.getAdapter();     // Catch: Exception -> L19
        if (r7 == null) goto L16;
        Long r8 = Long.valueOf(r7.getItemId(r4));     // Catch: Exception -> L19
    L17:
        r6.append(r8);     // Catch: Exception -> L19
        return r5.findFragmentByTag(r6.toString());
    L16:
        r8 = null;
        goto L17
    L26:
        return null;
    L25:
        return null;
    L24:
        return null;
    L19:
        e = move-exception;
        FLogger.a.e(this.j, "getCurrentFragment error e=" + e.getMessage());
        return null;
    }

    public final MutableLiveData<MainTabFragmentAction> kI() {
        MutableLiveData r0 = hb9.b.a;
        return hb9.b.a;
    }

    public final int l() {
        LarusFragmentMineTabPageBinding r0 = this.k;
        if (r0 == null) goto L7;
        ConstraintLayout r1 = r0.d;
        if (r1 == null) goto L7;
        int r2 = r1.getHeight();
    L8:
        LarusFragmentMineTabPageBinding r3 = this.k;
        if (r3 == null) goto L13;
        FrameLayout r4 = r3.h;
        if (r4 == null) goto L13;
        int r5 = r4.getHeight();
    L14:
        LarusFragmentMineTabPageBinding r6 = this.k;
        if (r6 == null) goto L21;
        FrameLayout r7 = r6.h;
        if (r7 == null) goto L21;
        if (r7.getVisibility() != 0) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == true) goto L24;
        return 0;
    L24:
        return r2 - r5;
    L21:
        r8 = false;
    L13:
        r5 = 0;
    L7:
        r2 = 0;
        goto L8
    }

    public final void onDestroy() {
        FLogger.a.i(this.j, "[onDestroy]");
        AppHost.a.a().c(this.M);
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void onDestroyView() {
        FLogger.a.i(this.j, "[onDestroyView]");
        INotifyService.a.e().a().removeObserver(this.O);
        this.k = null;
        this.q = AppBarLayoutStateListener.State.EXPANDED;
        this.s = false;
        this.r = false;
        this.u = false;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final void onPause() {
        FLogger.a.i(this.j, "[onPause]");
        MutableLiveData r0 = hb9.b.a;
        hb9.b.a.postValue(MainTabFragmentAction.NONE);
        this.C = false;
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    public final int sb() {
        return BaseHomeTabFragment.MainTab.MINE.getIndex();
    }

    public final void onResume() {
        super.onResume();
        boolean r0 = true;
        this.C = true;
        this.z.storeBoolean("has_unread_creation", false);
        if (this.J == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        FLogger r2 = FLogger.a;
        r2.i(this.j, "[onResume] hotLaunchByThisFragment = " + r1);
        Function0<Unit> r4 = this.F;
        if (r4 == null) goto L12;
        r4.invoke();
    L12:
        if (this.m == true) goto L18;
        MineTabViewModel r5 = aa0();
        if (r1 == false) goto L16;
        ProfileRequestSource r3 = ProfileRequestSource.HOT_LAUNCH;
    L17:
        r5.queryUserInfo(r3);
    L19:
        Boolean r6 = aa0().getHasBoundDoraVision();
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L24;
        com.larus.home.impl.sdk.s r8 = r7.s0();
        if (r8 == null) goto L24;
        boolean r9 = Intrinsics.areEqual(r8.E(), Boolean.TRUE);
    L26:
        if (Intrinsics.areEqual(r6, Boolean.valueOf(r9)) == false) goto L28;
    L43:
        this.J = false;
        this.K = false;
        da0();
        aa0().checkReusedNumber();
        ICommerceCreditService.a.getClass();
        ICommerceCreditService r10 = ICommerceCreditService.a.a();
        final TextView r11 = null;
        if (r10 == null) goto L46;
        r10.i(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), new u(r11));
    L46:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new PageMineTabFragment$updateCommerceCreditProfileView$2(null, this, null, null, null), 3, null);
        IFlowSdkDepend r12 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r12 == null) goto L53;
        r12.H();
        VideoPortraitConfig r13 = l1.a.a();
        if (r13 == null) goto L53;
        if (r13.getEnableAvatarCreation() != true) goto L53;
    L54:
        if (r0 == false) goto L57;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C01031(null), 3, null);
        return;
    L57:
        return;
    L53:
        r0 = false;
        goto L54
    L28:
        if (isAdded() == false) goto L43;
        if (isHidden() == true) goto L43;
        if (getUserVisibleHint() == false) goto L43;
        MineTabViewModel r14 = aa0();
        IFlowSdkDepend r15 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r15 == null) goto L38;
        com.larus.home.impl.sdk.s r16 = r15.s0();
        if (r16 == null) goto L38;
        boolean r17 = Intrinsics.areEqual(r16.E(), Boolean.TRUE);
    L39:
        r14.setHasBoundDoraVision(Boolean.valueOf(r17));
        LarusFragmentMineTabPageBinding r18 = this.k;
        if (r18 == null) goto L42;
        ba0(r18);
    L42:
        r2.i("BaseHomeTabFragment", "refreshTabLayout");
    L38:
        r17 = false;
    L24:
        r9 = false;
        goto L26
    L16:
        r3 = ProfileRequestSource.REFRESH;
        goto L17
    L18:
        this.n = true;
        goto L19
    L5:
        if (this.K == false) goto L7;
        r1 = true;
        goto L8
    }

    public final void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
        if (z2.a.optRequestMyUgcVoiceList() == true) goto L5;
        p2a.i r0 = p2a.i.b;
        p2a.f.a.a();
    L5:
        FLogger.a.i(this.j, "[onStart]");
    }

    public final by7.e parentTrackNode() {
        by7.e r0 = getParentFragment();
        if ((r0 instanceof by7.e) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final boolean qv() {
        return aa0().needRefreshBotList();
    }

    public final boolean kt() {
        return this.s;
    }

    public final boolean tz() {
        return this.r;
    }

    public final void X3(String r8) {
        Intrinsics.checkNotNullParameter(r8, "enterMethod");
        if (((com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue()) == null) goto L12;
        IBotCreateService.Companion r0 = IBotCreateService.a;
        nq9.c r2 = r0.i("bot_list_profile", r8);
        String r3 = null;
        if (r2 == null) goto L7;
        String r4 = r2.b;
    L8:
        if (r2 == null) goto L10;
        r3 = r2.a;
    L10:
        com.bytedance.router.i r1 = SmartRouter.buildRoute(getContext(), r0.k());
        Bundle r5 = BundleKt.bundleOf(new Pair[]{TuplesKt.to("enter_from", "personal_homepage"), TuplesKt.to("enter_method", r8), TuplesKt.to("create_way", r4), TuplesKt.to("creation_id", r3), TuplesKt.to("previous_page", "bot_list_profile")});
        by7.h.k(r5, this);
        r1.c.putExtras(r5);
        r1.d = 2130772400;
        r1.e = 2130772399;
        r1.d();
        AiChatTraceDelegate.b.a(r8, r4, r3);
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final int Z90(LarusFragmentMineTabPageBinding r2) {
        Integer r3 = Integer.valueOf(r2.l.getWidth());
        if (r3.intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r3 = null;
    L9:
        if (r3 != null) goto L13;
        int r4 = com.larus.utils.m0.a;
        return com.larus.utils.m0.b(getContext());
    L13:
        return r3.intValue();
    L5:
        r0 = false;
        goto L6
    }

    public final void ba0(final LarusFragmentMineTabPageBinding r10) {
        FragmentActivity r1 = null;
        r10.n.setAdapter(null);
        r10.l.removeAllTabs();
        FLogger.a.i(this.j, "initView, viewPager2 bind adapter");
        r10.n.setAdapter(new MyInfoAdapter(getChildFragmentManager(), getLifecycle(), this.x));
        IFlowProfileThemeConfigProvider r0 = (IFlowProfileThemeConfigProvider) ServiceManager.get().getService(IFlowProfileThemeConfigProvider.class);
        if (r0 == null) goto L5;
        r0.a(new f0(this, r10), AdaptThemeFeatureKey.PROFILE_PAGE_TAB);
    L5:
        Iterator r2 = com.larus.collection.impl.view.t.a().iterator();
    L7:
        if (r2.hasNext() == false) goto L22;
        RevisitListTab r3 = (RevisitListTab) r2.next();
        FLogger.a.i(this.j, "initView, add revisit tab, scene=" + r3.getScene() + ", landingTab=" + r3.getLandingTab());
        if (r3.isLikeTab() == false) goto L11;
        int r4 = 2131563155;
    L12:
        TabLayout.Tab r5 = r10.l.newTab().setCustomView(r4);
        if (r3.isLikeTab() == true) goto L21;
        if (com.larus.bmhome.utils.u.i() == false) goto L21;
        View r6 = r5.getCustomView();
        if (r6 == null) goto L21;
        View r7 = r6.findViewById(2131375088);
        if (r7 == null) goto L21;
        e1.o(r7);
    L21:
        r10.l.addTab(r5);
        goto L7
    L11:
        r4 = 2131563153;
        goto L12
    L22:
        r10.n.setOffscreenPageLimit(r10.l.getTabCount());
        ha0(r10);
        r10.l.addOnTabSelectedListener(new c(r10, this));
        r10.n.registerOnPageChangeCallback(new PageMineTabFragment$initTabLayout$4(r10, this));
        if (ca0() == false) goto L37;
        ConstraintLayout r8 = r10.m;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 == null) goto L36;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r9;
        com.larus.utils.i0.a.getClass();
        r11.topMargin = com.larus.utils.i0.g();
        r8.setLayoutParams(r11);
        MineTabTitleBar r12 = r10.m;
        View.OnClickListener r13 = new j0(this);
        LarusWidgetMineTabTitleBarBinding r14 = r12.getBinding();
        boolean r15 = false;
        r14.d.setVisibility(0);
        r14.d.setImageResource(2131242079);
        e1.c(r14.d, r13);
        ConstraintLayout r16 = r10.a;
        Context r17 = getContext();
        if ((r17 instanceof FragmentActivity) == false) goto L29;
        r1 = (FragmentActivity) r17;
    L29:
        int r18 = com.larus.utils.u.b(r1);
        int r19 = r16.getPaddingStart();
        int r20 = r16.getPaddingTop();
        int r21 = r16.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r16.getClass().getSimpleName() + ",source:,start:" + r19 + ",top:" + r20 + ",end:" + r21 + ",bottom:" + r18);
        r16.setPaddingRelative(r19, r20, r21, r18);
        if (this.G == null) goto L32;
        r15 = true;
    L32:
        this.I = r15;
        if (r15 == false) goto L44;
        ea0(true);
        r10.a.post(new k0(this));
        return;
    L44:
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // gs9.h
    public final void bf(String r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedTag");
        if (Intrinsics.areEqual(r2, "creation") == true) goto L5;
        return;
    L5:
        if (com.larus.bmhome.utils.u.f() == false) goto L12;
        e10 r3 = e10.a;
        if (e10.u0().a() == false) goto L9;
        this.x.e(0);
        return;
    L9:
        this.x.e(1);
        return;
    }

    public final void ea0(boolean r5) {
        LarusFragmentMineTabPageBinding r0 = this.k;
        if (r0 == null) goto L20;
        AppBarLayout r1 = r0.b;
        if (r1 == null) goto L21;
        View r2 = r1.getChildAt(0);
        if (r2 == null) goto L22;
        AppBarLayout.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof AppBarLayout.LayoutParams) == false) goto L12;
        AppBarLayout.LayoutParams r4 = r3;
    L13:
        if (r4 != null) goto L15;
        return;
    L15:
        if (r5 == false) goto L17;
        r4.setScrollFlags(3);
    L18:
        r2.setLayoutParams(r4);
        return;
    L17:
        r4.setScrollFlags(0);
        goto L18
    L12:
        r4 = null;
        goto L13
    L22:
        return;
    L21:
        return;
    }

    public final void ha0(final LarusFragmentMineTabPageBinding r9) {
        Integer r3 = null;
        ViewGroup.MarginLayoutParams r4 = null;
        Integer r5 = null;
        if (r9.l.getTabCount() > 1) goto L15;
        r9.l.setTabMode(1);
        r9.l.setTabGravity(0);
        ga0(r9, -2, 0.0f);
        ia0(r9, null);
        TabLayout r1 = r9.l;
        ViewGroup.LayoutParams r6 = r1.getLayoutParams();
        if (r6 == null) goto L14;
        r6.width = -2;
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r4 = (ViewGroup.MarginLayoutParams) r6;
    L9:
        if (r4 == null) goto L11;
        r4.setMarginStart(i5.Y());
        r4.setMarginEnd(i5.Y());
    L11:
        r1.setLayoutParams(r6);
        r9.l.setSelectedTabIndicatorHeight(0);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L15:
        TabLayout r0 = r9.l;
        ViewGroup.LayoutParams r7 = r0.getLayoutParams();
        if (r7 == null) goto L37;
        r7.width = -1;
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
    L21:
        if (r8 == null) goto L23;
        r8.setMarginStart(0);
        r8.setMarginEnd(0);
    L23:
        r0.setLayoutParams(r7);
        r9.l.setSelectedTabIndicatorHeight(i5.z());
        if (r9.l.getTabCount() < 5) goto L30;
        r9.l.setTabMode(0);
        int r2 = ((Z90(r9) + 4) - 1) / 4;
        if (r2 <= 0) goto L29;
        ga0(r9, r2, 0.0f);
        r5 = Integer.valueOf(r2);
    L29:
        ia0(r9, r5);
        r9.l.post(new h0(this, r9));
        return;
    L30:
        r9.l.setTabMode(1);
        r9.l.setTabGravity(0);
        ga0(r9, 0, 1.0f);
        int r10 = r9.l.getTabCount();
        if (r10 <= 0) goto L34;
        r3 = Integer.valueOf(Z90(r9) / r10);
    L34:
        ia0(r9, r3);
        r9.l.post(new i0(this, r9));
        return;
    L20:
        r8 = null;
        goto L21
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void n40(boolean r2) {
        LarusFragmentMineTabPageBinding r0 = this.k;
        if (r0 == null) goto L8;
        ViewPager2 r1 = r0.n;
        if (r1 == null) goto L9;
        r1.setUserInputEnabled(r2);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r7) {
        super/*com.larus.trace.tracknode.TraceFragment*/.onCreate(r7);
        FLogger.a.i(this.j, "[onCreate]");
        AppHost.a.a().j(this.M);
        boolean r1 = false;
        boolean r8 = this.z.getBoolean("has_unread_creation", false);
        this.D = r8;
        if (r8 == true) goto L5;
    L9:
        aa0().setUserId(ILoginService.a.getAccountInfo().c);
        aa0().queryUserInfo(ProfileRequestSource.MINE_INIT);
        MineTabViewModel r9 = aa0();
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L14;
        com.larus.home.impl.sdk.s r2 = r0.s0();
        if (r2 == null) goto L14;
        r1 = Intrinsics.areEqual(r2.E(), Boolean.TRUE);
    L14:
        r9.setHasBoundDoraVision(Boolean.valueOf(r1));
        if (z2.a.optRequestMyUgcVoiceList() == true) goto L17;
        p2a.i r10 = p2a.i.b;
        p2a.f.a.a();
    L17:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L5:
        if (com.larus.bmhome.utils.u.d() == false) goto L9;
        Function0<Unit> r11 = this.E;
        if (r11 == null) goto L9;
        r11.invoke();
        goto L9
    }

    public final void y2(final String r5) {
        FLogger.a.i(this.j, "onEnterTab, previousPage:" + r5);
        this.L = true;
        if (r5 != null) goto L5;
        String r0 = "";
    L6:
        this.P = r0;
        LarusFragmentMineTabPageBinding r1 = this.k;
        MyInfoAdapter r2 = null;
        if (r1 == null) goto L11;
        ViewPager2 r3 = r1.n;
        if (r3 == null) goto L11;
        RecyclerView.Adapter r4 = r3.getAdapter();
    L13:
        if ((r4 instanceof MyInfoAdapter) == false) goto L15;
        r2 = (MyInfoAdapter) r4;
    L15:
        if (r2 == null) goto L29;
        LarusFragmentMineTabPageBinding r6 = this.k;
        if (r6 == null) goto L21;
        ViewPager2 r7 = r6.n;
        if (r7 == null) goto L21;
        int r8 = r7.getCurrentItem();
    L23:
        if (r8 >= r2.b.size()) goto L29;
        ((ProfileInfoBaseFragment) ListProtector.get(r2.b, r8)).S90(r5);
        Iterator<ProfileInfoBaseFragment> r9 = r2.b.iterator();
    L27:
        if (r9.hasNext() == false) goto L29;
        r9.next().Y90(r5);
    L21:
        r8 = 0;
    L29:
        getViewLifecycleOwnerLiveData().observeForever(new d(new a0(this, r5)));
        return;
    L11:
        r4 = null;
        goto L13
    L5:
        r0 = r5;
        goto L6
    }

    public static void ia0(LarusFragmentMineTabPageBinding r10, Integer r11) {
        int r0 = i5.t();
        int r1 = ((Number) i5.F0.getValue()).intValue();
        View r2 = r10.l.getChildAt(0);
        if ((r2 instanceof ViewGroup) == false) goto L5;
        ViewGroup r3 = (ViewGroup) r2;
    L6:
        int r4 = r10.l.getTabCount();
        int r6 = 0;
    L7:
        if (r6 >= r4) goto L34;
        if (r3 == null) goto L20;
        View r8 = r3.getChildAt(r6);
        if (r8 == null) goto L20;
        Integer r9 = Integer.valueOf(r8.getWidth());
        if (r9.intValue() <= 0) goto L15;
        boolean r12 = true;
    L16:
        if (r12 == true) goto L19;
        r9 = null;
    L19:
        if (r9 == null) goto L20;
    L21:
        if (r9 != null) goto L23;
    L25:
        int r7 = r0;
    L26:
        TabLayout.Tab r13 = r10.l.getTabAt(r6);
        if (r13 == null) goto L33;
        View r14 = r13.getCustomView();
        if (r14 == null) goto L33;
        TextView r15 = (TextView) r14.findViewById(2131388514);
        if (r15 == null) goto L33;
        r15.setTextSize(0, r7);
    L33:
        r6 = r6 + 1;
        goto L7
    L23:
        if (RangesKt.until(1, r1).contains(r9.intValue()) == false) goto L25;
        r7 = (r9.intValue() * r0) / r1;
        goto L26
    L15:
        r12 = false;
    L20:
        r9 = r11;
        goto L21
    L34:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void Ol(boolean r1, boolean r2) {
        Y90(r1, r2);
    }

    public final void Y90(boolean r4, boolean r5) {
        if (this.I == false) goto L6;
        return;
    L6:
        if (this.q == AppBarLayoutStateListener.State.EXPANDED) goto L8;
        return;
    L8:
        if (r5 == false) goto L16;
        if (r4 == false) goto L11;
    L13:
        boolean r6 = false;
    L14:
        this.s = r6;
        goto L16
    L11:
        if (this.r == false) goto L13;
        r6 = true;
    L16:
        if (this.r != r4) goto L18;
        return;
    L18:
        FLogger.a.i(this.j, "[enableAppBarLayoutScroll] enable: " + r4 + ", current: " + this.r);
        this.r = r4;
        ea0(r4);
    }

    public final void Ym(String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "tag");
        this.x.f(r7, r8);
        da0();
        e10 r0 = e10.a;
        if (e10.B0() == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r7, ProfileBotListFragment.class.getName()) == false) goto L46;
        if (r8 == false) goto L47;
        LarusFragmentMineTabPageBinding r9 = this.k;
        if (r9 == null) goto L48;
        TabLayout r10 = r9.l;
        if (r10 == null) goto L49;
        int r11 = r10.getTabCount();
        final int r1 = 0;
    L12:
        if (r1 >= r11) goto L50;
        TabLayout.Tab r2 = r10.getTabAt(r1);
        final MyInfoAdapter r3 = null;
        if (r2 == null) goto L16;
        Object r4 = r2.getTag();
    L18:
        if (Intrinsics.areEqual(r4, "bot") == false) goto L40;
        LarusFragmentMineTabPageBinding r5 = this.k;
        if (r5 == null) goto L24;
        ViewPager2 r6 = r5.n;
        if (r6 == null) goto L24;
        RecyclerView.Adapter r12 = r6.getAdapter();
    L26:
        if ((r12 instanceof MyInfoAdapter) == false) goto L28;
        r3 = (MyInfoAdapter) r12;
    L28:
        if (r3 == null) goto L37;
        FLogger.a.i("MyInfoAdapter", "removeFragment,position:" + r1);
        if (r1 >= 0) goto L32;
    L34:
        boolean r13 = false;
    L35:
        if (r13 == false) goto L37;
        new Handler(Looper.getMainLooper()).post(new s(r3, r1));
        goto L37
    L32:
        if (r1 >= r3.getItemCount()) goto L34;
        r13 = true;
    L37:
        r10.removeTabAt(r1);
        LarusFragmentMineTabPageBinding r14 = this.k;
        if (r14 == null) goto L40;
        ha0(r14);
    L24:
        r12 = null;
    L40:
        r1 = r1 + 1;
        goto L12
    L16:
        r4 = null;
        goto L18
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        FLogger r7 = FLogger.a;
        r7.i(this.j, "[onViewCreated]");
        final LarusFragmentMineTabPageBinding r8 = this.k;
        if (r8 == null) goto L40;
        r8.m.bringToFront();
        boolean r1 = false;
        if ((getContext() instanceof PageMineTabActivity) == false) goto L7;
        r7.i(this.j, "initView, current page is PageMineTabActivity");
        MineTabTitleBar r9 = r8.m;
        View.OnClickListener r0 = new m0(this);
        LarusWidgetMineTabTitleBarBinding r10 = r9.getBinding();
        r10.d.setVisibility(0);
        r10.d.setImageResource(2131241477);
        e1.c(r10.d, r0);
        r8.c.setVisibility(8);
    L39:
        e1.d(r8.i.b, new q0(this));
        r8.g.setAvatarClick(new v(this));
        r8.g.setEditClick(new w(this));
        r8.g.setQrCodeClick(new x(this));
        r8.b.addOnOffsetChangedListener(new s0(this, r8));
        ba0(r8);
        goto L40
    L7:
        r7.i(this.j, "initView, current page is not PageMineTabActivity");
        r8.m.U5(getString(2131898833), new n0(this));
        com.larus.bmhome.chat.outerinput.c r11 = (com.larus.bmhome.chat.outerinput.c) this.y.getValue();
        if (r11 != null) goto L10;
    L12:
        boolean r12 = false;
    L13:
        if (r12 == false) goto L15;
    L27:
        r8.c.setVisibility(8);
    L28:
        IHomeApi r13 = (IHomeApi) ServiceManager.get().getService(IHomeApi.class);
        if (r13 == null) goto L35;
        hb9.a r14 = r13.d0();
        if (r14 == null) goto L35;
        if (true != r14.a()) goto L35;
        r1 = true;
    L35:
        if (r1 == false) goto L39;
        IFlowProfileThemeConfigProvider r15 = (IFlowProfileThemeConfigProvider) ServiceManager.get().getService(IFlowProfileThemeConfigProvider.class);
        if (r15 == null) goto L39;
        r15.a(new p0(this, r8), AdaptThemeFeatureKey.PROFILE_NAV_NOTICE);
        goto L39
    L15:
        if (z2.a.botCreateEnable() == false) goto L27;
        IHomeApi r16 = (IHomeApi) ServiceManager.get().getService(IHomeApi.class);
        if (r16 == null) goto L23;
        hb9.a r17 = r16.d0();
        if (r17 == null) goto L23;
        if (true != r17.b()) goto L23;
        boolean r18 = true;
    L24:
        if (r18 == true) goto L27;
        r8.c.setButtonText(getString(2131901108));
        e1.d(r8.c, new o0(this));
    L23:
        r18 = false;
        goto L24
    L10:
        if (r11.a() != true) goto L12;
        r12 = true;
    L40:
        aa0().getUserInfoState().observe(getViewLifecycleOwner(), new d(new y(this)));
        aa0().getShowBindPhoneEvent().observe(getViewLifecycleOwner(), new d(new z(this)));
    }

    @Override // gs9.h
    public final void sF(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "tab");
        LarusFragmentMineTabPageBinding r0 = this.k;
        if (r0 == null) goto L5;
        AppBarLayout r1 = r0.b;
    L7:
        if (this.q == AppBarLayoutStateListener.State.COLLAPSED) goto L10;
        if (r1 == null) goto L10;
        r1.setExpanded(false, false);
    L10:
        com.larus.profile.impl.w r2 = this.x;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "tab");
        Iterator<e2> r8 = r2.c.iterator();
        int r3 = 0;
    L12:
        if (r8.hasNext() == false) goto L17;
        if (StringsKt.equals(r6, r8.next().b.name(), true) == true) goto L18;
        r3 = r3 + 1;
    L18:
        if (r3 == (-1)) goto L27;
        LarusFragmentMineTabPageBinding r9 = this.k;
        if (r9 == null) goto L28;
        ViewPager2 r10 = r9.n;
        if (r10 == null) goto L29;
        r10.setCurrentItem(r3, false);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L17:
        r3 = -1;
        goto L18
    L5:
        r1 = null;
        goto L7
    }

    public static void ga0(LarusFragmentMineTabPageBinding r7, int r8, float r9) {
        int r1 = 0;
        View r0 = r7.l.getChildAt(0);
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r2 = (ViewGroup) r0;
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        int r3 = r2.getChildCount();
    L9:
        if (r1 >= r3) goto L21;
        View r4 = r2.getChildAt(r1);
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L20;
        r5.width = r8;
        if ((r5 instanceof LinearLayout.LayoutParams) == false) goto L16;
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5;
    L17:
        if (r6 == null) goto L19;
        r6.weight = r9;
    L19:
        r4.setLayoutParams(r5);
        goto L20
    L16:
        r6 = null;
    L20:
        r1 = r1 + 1;
        goto L9
    L21:
        r7.l.requestLayout();
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r21, ViewGroup r22, Bundle r23) {
        Intrinsics.checkNotNullParameter(r21, "inflater");
        FLogger.a.i(this.j, "[onCreateView]");
        boolean r3 = false;
        ConstraintLayout r0 = getLayoutInflater().inflate(2131562408, r22, false);
        int r2 = 2131363083;
        AppBarLayout r7 = ViewBindings.findChildViewById(r0, 2131363083);
        if (r7 == null) goto L77;
        r2 = 2131364358;
        CreateBotButton r8 = ViewBindings.findChildViewById(r0, 2131364358);
        if (r8 == null) goto L77;
        ConstraintLayout r9 = r0;
        r2 = 2131367812;
        CoordinatorLayout r10 = ViewBindings.findChildViewById(r0, 2131367812);
        if (r10 == null) goto L77;
        r2 = 2131369242;
        View r11 = ViewBindings.findChildViewById(r0, 2131369242);
        if (r11 == null) goto L77;
        r2 = 2131374317;
        ProfileHeaderUserInfoView r12 = (ProfileHeaderUserInfoView) ViewBindings.findChildViewById(r0, 2131374317);
        if (r12 == null) goto L77;
        r2 = 2131381753;
        FrameLayout r13 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381753);
        if (r13 == null) goto L77;
        r2 = 2131383231;
        View r4 = ViewBindings.findChildViewById(r0, 2131383231);
        if (r4 == null) goto L77;
        LarusPageProfileInfoErrorBinding r14 = LarusPageProfileInfoErrorBinding.a(r4);
        r2 = 2131383263;
        View r5 = ViewBindings.findChildViewById(r0, 2131383263);
        if (r5 == null) goto L77;
        LarusPageProfileTabInfoLoadingBinding r15 = LarusPageProfileTabInfoLoadingBinding.a(r5);
        r2 = 2131383276;
        View r6 = ViewBindings.findChildViewById(r0, 2131383276);
        if (r6 == null) goto L77;
        LarusPageProfileUserInfoSkeletonBinding r16 = LarusPageProfileUserInfoSkeletonBinding.a(r6);
        r2 = 2131388072;
        TabLayout r17 = ViewBindings.findChildViewById(r0, 2131388072);
        if (r17 == null) goto L77;
        r2 = 2131388807;
        MineTabTitleBar r18 = (MineTabTitleBar) ViewBindings.findChildViewById(r0, 2131388807);
        if (r18 == null) goto L77;
        r2 = 2131392623;
        ViewPager2 r19 = ViewBindings.findChildViewById(r0, 2131392623);
        if (r19 == null) goto L77;
        this.k = new LarusFragmentMineTabPageBinding(r9, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
        Bundle r20 = getArguments();
        String r24 = "";
        if (r20 == null) goto L57;
        this.t = r20.getBoolean("from_bot_setting", false);
        this.P = r20.getString("previous_page", "");
        String r1 = r20.getString("landing_tab", null);
        this.G = r1;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L34
        if (r1 != null) goto L32;
        r1 = "";
    L32:
        Object r26 = Result.constructor-impl(LandingTab.valueOf(r1));     // Catch: Throwable -> L34
    L37:
        if (Result.isFailure-impl(r26) == false) goto L39;
        r26 = null;
    L39:
        LandingTab r27 = (LandingTab) r26;
        if (r27 == null) goto L56;
        Iterator r28 = com.larus.collection.impl.view.t.a().iterator();
    L44:
        if (r28.hasNext() == false) goto L51;
        Object r29 = r28.next();
        if (((RevisitListTab) r29).getLandingTab() != r27) goto L48;
        boolean r110 = true;
    L49:
        if (r110 == false) goto L44;
    L52:
        RevisitListTab r30 = (RevisitListTab) r29;
        if (r30 == null) goto L56;
        Integer r31 = MineCollectFragment.x;
        MineCollectFragment.x = Integer.valueOf(r30.getScene());
        MineCollectFragment.y = Integer.valueOf(r30.getScene());
        goto L56
    L48:
        r110 = false;
        goto L49
    L51:
        r29 = null;
    L56:
        this.Q = r20.getString("enter_method", "");
    L34:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
    L57:
        String r33 = this.P;
        if (r33 != null) goto L60;
    L61:
        r3 = true;
    L62:
        if (r3 == false) goto L68;
        String r34 = TrackParams.optString$default(by7.h.a(this), "previous_page", null, 2, null);
        if (r34 == null) goto L66;
        r24 = r34;
    L66:
        this.P = r24;
    L68:
        if (this.t == false) goto L70;
        s2.a(null, this, 3);
    L70:
        LarusFragmentMineTabPageBinding r35 = this.k;
        if (r35 == null) goto L85;
        ConstraintLayout r36 = r35.a;
        if (r36 == null) goto L86;
        r36.setTag(2131377847, this);
        return r36;
    L86:
        return null;
    L85:
        return null;
    L60:
        if (r33.length() != 0) goto L62;
    L77:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r2)));
    }
}
