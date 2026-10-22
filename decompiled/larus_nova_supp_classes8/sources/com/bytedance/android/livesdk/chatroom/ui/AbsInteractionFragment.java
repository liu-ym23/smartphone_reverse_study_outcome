package com.bytedance.android.livesdk.chatroom.ui;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.anchormodelink.BaseAnchorModeDynamicWidget;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.tetris.ComponentManagerFactory;
import com.bytedance.android.live.core.tetris.componentx.ComponentManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.ComponentSchedulingManager;
import com.bytedance.android.live.core.tetris.layer.core.delegate.ViewLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.core.element.ElementBuilderMap;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.LayerManager;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.core.utils.AnchorMainPostOptUtils;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.widgt.AudioSceneBasicBusinessContentWidget;
import com.bytedance.android.live.liveinteract.radio.api.IRadioService;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.livepullstream.api.IPullStreamService;
import com.bytedance.android.live.media.api.IMediaService;
import com.bytedance.android.live.network.response.EnterRoomInfoResult;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.room.IExternalFunctionInjector;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.live.room.enterprocess.IEnterProcessorService;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.live.user.api.UserSetting;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.IHostLiveAd;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.ability.AbilityCenter;
import com.bytedance.android.livesdk.admin.prompt.PrompterDataContext;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.banner.InRoomBannerManager;
import com.bytedance.android.livesdk.castscreen.bytecast.LiveByteCastManager;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIManager;
import com.bytedance.android.livesdk.ceremony.view.CeremonyBorderWidget;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;
import com.bytedance.android.livesdk.chatroom.broadcast.interact.AnchorPortraitInteractionFragment;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import com.bytedance.android.livesdk.chatroom.event.ToolbarClearScreenEvent;
import com.bytedance.android.livesdk.chatroom.game.GameAbsInteractionDelegate;
import com.bytedance.android.livesdk.chatroom.helper.RoomContextInitHelper;
import com.bytedance.android.livesdk.chatroom.interact.AudienceLandscapeInteractionFragment;
import com.bytedance.android.livesdk.chatroom.interact.AudiencePortraitInteractionFragment;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.model.ShareReportResult;
import com.bytedance.android.livesdk.chatroom.tetris.filter.RoomModeElementFilter;
import com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.LiveVrContext;
import com.bytedance.android.livesdk.chatroom.utils.HeadsetBroadcastReceiver;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.AnchorStickerWrapperWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.AudienceStickerWrapperWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.CommonGuideWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.CommonShortTouchWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.CommonToastWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.EndWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.FirstScreenEndWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.FollowGuideWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.GameSuggestionWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.LiveCommerceTipsWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.LiveShareWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.P0EndWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.P1EndWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.P2EndWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.UserPermissionCheckWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.VerifyCodeWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.LiveRecordWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.stats.ToolbarLoadTimeStatsVM;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAnchorBacktrackBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAnchorRecordBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAudienceRecordBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper.ManageRoomButtonHelper;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.widget.BroadcastPauseStateLandscapeWidget;
import com.bytedance.android.livesdk.chatroom.widget.BroadcastPauseStateWidget;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.clearscreen.gesture.ClickPS2ClearScreenGestureBehavior;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenLogUtils;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.common.ViewModuleManager;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.a11;
import com.bytedance.android.livesdk.config.a71;
import com.bytedance.android.livesdk.config.ai;
import com.bytedance.android.livesdk.config.b41;
import com.bytedance.android.livesdk.config.bl;
import com.bytedance.android.livesdk.config.c41;
import com.bytedance.android.livesdk.config.cd0;
import com.bytedance.android.livesdk.config.cy;
import com.bytedance.android.livesdk.config.d90;
import com.bytedance.android.livesdk.config.dl0;
import com.bytedance.android.livesdk.config.ey;
import com.bytedance.android.livesdk.config.fi1;
import com.bytedance.android.livesdk.config.fy;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdk.config.hx;
import com.bytedance.android.livesdk.config.i91;
import com.bytedance.android.livesdk.config.j80;
import com.bytedance.android.livesdk.config.kw0;
import com.bytedance.android.livesdk.config.l21;
import com.bytedance.android.livesdk.config.n41;
import com.bytedance.android.livesdk.config.n61;
import com.bytedance.android.livesdk.config.o91;
import com.bytedance.android.livesdk.config.os;
import com.bytedance.android.livesdk.config.qy;
import com.bytedance.android.livesdk.config.setting.NewBroadcastSharedConfig;
import com.bytedance.android.livesdk.config.u80;
import com.bytedance.android.livesdk.config.uf0;
import com.bytedance.android.livesdk.config.ur0;
import com.bytedance.android.livesdk.config.vc1;
import com.bytedance.android.livesdk.config.vx0;
import com.bytedance.android.livesdk.config.yl;
import com.bytedance.android.livesdk.config.yy;
import com.bytedance.android.livesdk.config.z60;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.feedback.room.RoomFeedbackContext;
import com.bytedance.android.livesdk.interactivity.api.ITextAudioService;
import com.bytedance.android.livesdk.interactivity.api.comment.data.KeyboardViewModel;
import com.bytedance.android.livesdk.interactivity.api.comment.datacontext.CommentContext;
import com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService;
import com.bytedance.android.livesdk.interactivity.api.exitroom.ICloseInterceptorService;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.PageUIContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.ktvapi.AbsKtvControlWidget;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.lifecycle.ILifeCycleAware;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.message.model.ControlMessage;
import com.bytedance.android.livesdk.message.model.ik;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdk.message.model.ri;
import com.bytedance.android.livesdk.message.model.wd;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.player.listen.ListenLiveOnlyView;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindowManager;
import com.bytedance.android.livesdk.record.admin.AdminRecordManager;
import com.bytedance.android.livesdk.room.handler.SimpleLiveRoomViewHandler;
import com.bytedance.android.livesdk.room.service.ExternalFunctionInjectorService;
import com.bytedance.android.livesdk.room.util.ConvertorKt;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdk.viewmodel.DrawCleanScreenViewModel;
import com.bytedance.android.livesdk.vipim.VipIMWidget;
import com.bytedance.android.livesdk.vscore_api.IEpisodeInteractiveService;
import com.bytedance.android.livesdk.vscore_api.multicamera.IMultiCameraView;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdk.widget.GestureDetectLayout;
import com.bytedance.android.livesdk.widget.schedule.LiveWidgetLoadTaskScheduler;
import com.bytedance.android.livesdk.widget.schedule.WidgetLoadState;
import com.bytedance.android.livesdk.widgetdescriptor.InteractionDelegateConfig;
import com.bytedance.android.livesdk.widgetdescriptor.delegate.Portrait5thDelegate;
import com.bytedance.android.livesdk.widgetdescriptor.showstrategy.LiveComponentShowDelegate;
import com.bytedance.android.livesdk.widgetdescriptor.template.LiveTemplateContext;
import com.bytedance.android.livesdk.widgetdescriptor.template.delegate.TemplateDelegateHolder;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.chat.OnBackPressedListener;
import com.bytedance.android.livesdkapi.depend.event.NetworkChangeEvent;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.live.IRoomEventListener;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.RoomLifeGrouponInfo;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.model.ListenLiveStatus;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenManagerAbility;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.chatroom.clearscreen.IClearScreenManagerFactory;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMockStrategyDescriptorLoadConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.UnLoginFeatureUtils;
import com.bytedance.android.livesdkapi.model.streamcontrol.StreamControlInfo;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.ILayoutConstraint;
import com.bytedance.android.livesdkapi.room.state.RoomState;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.sti.framework.IShortTermIconFramework;
import com.bytedance.android.livesdkapi.util.LiveEnterRoomControllerUtilKt;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class AbsInteractionFragment extends MiddleAbsInteractionFragment implements com.bytedance.android.live.room.h, com.bytedance.android.livesdk.chatroom.view.b, com.bytedance.android.livesdk.chatroom.view.d, WeakHandler.IHandler, PlatformMessageHelper.c, q46.a, OnBackPressedListener, ga0.c, Observer<KVData>, StickerWrapperWidget.a, tw2.b, rv2.b, com.bytedance.android.livesdk.widget.schedule.v2.b, com.bytedance.android.livesdk.interactivity.api.base.a, IMultiCameraView {
    public static final List<String> u4 = null;
    public static boolean v4;
    public View A;
    public ga0.a A3;
    public long B;
    public boolean B3;
    public AnchorPauseTipsView C;
    public boolean C3;
    public gl0.d D;
    public Boolean D3;
    public View E;
    public ViewLayerDelegate<com.bytedance.android.livesdk.widgetdescriptor.e0> E2;
    public boolean E3;
    public BaseWebDialogFragment F;
    public ViewLayerDelegate<com.bytedance.android.livesdk.widgetdescriptor.e0> F2;
    public View F3;
    public HybridDialog G;
    public CommonToastWidget G1;
    public ViewLayerDelegate<d90.a> G2;
    public int G3;
    public boolean H;
    public IShortTermIconFramework H0;
    public FollowGuideWidget H1;
    public ViewLayerDelegate<d90.a> H2;
    public final List<hh1.w0> H3;
    public GestureDetectLayout I;
    public TemplateDelegateHolder I2;
    public w4 I3;
    public FrameLayout J;
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.e5 J2;
    public Bundle J3;
    public HSImageView K;
    public LivePopupWindowManager K2;
    public long K3;
    public final CompositeDisposable L;
    public ow0.a L0;
    public EndWidget L1;
    public boolean L2;
    public BaseAnchorModeDynamicWidget L3;
    public final WeakHandler M;
    public CommonGuideWidget M1;
    public boolean M2;
    public boolean M3;
    public com.bytedance.android.livesdk.chatroom.presenter.g N;
    public boolean N2;
    public boolean N3;
    public com.bytedance.android.livesdk.chatroom.presenter.l O;
    public List<LinkPlayerInfo> O2;
    public m32.b O3;
    public com.bytedance.android.livesdk.chatroom.presenter.m P;
    public ViewModuleManager P0;
    public VipIMWidget P1;
    public int P2;
    public final List<View.OnTouchListener> P3;
    public GestureDetector Q;
    public com.bytedance.android.livesdk.user.f Q1;
    public boolean Q2;
    public final List<DialogInterface.OnKeyListener> Q3;
    public g7 R;
    public boolean R2;
    public Runnable R3;
    public User S;
    public boolean S1;
    public boolean S2;
    public final i S3;
    public LiveMode T;
    public com.bytedance.android.livesdk.chatroom.model.z3 T1;
    public final HeadsetBroadcastReceiver T2;
    public com.bytedance.android.livesdk.chatroom.widget.unionlive.c T3;
    public final CopyOnWriteArrayList<kf1.a> U;
    public EnterRoomAuthCompactManager U2;
    public final z0 U3;
    public com.bytedance.android.live.room.l V;
    public IExternalConfigJudger V0;
    public m00.f V1;
    public jm1.a V2;
    public final boolean V3;
    public DataCenter W;
    public com.bytedance.android.livesdk.widget.monitor.l W2;
    public float W3;
    public RoomContext X;
    public com.bytedance.android.livesdk.widget.schedule.v2.a X2;
    public float X3;
    public InteractionContext Y;
    public FrameLayout Y2;
    public float Y3;
    public CommentContext Z;
    public FrameLayout Z2;
    public float Z3;
    public FrameLayout a3;
    public float a4;
    public LiveProfileSettingDialog b1;
    public int b2;
    public LiveTemplateContext b3;
    public Disposable b4;
    public final com.bytedance.android.livesdk.interactivity.api.barrage.data.g c3;
    public com.bytedance.android.livesdk.chatroom.record.i c4;
    public final com.bytedance.android.livesdk.interactivity.api.settings.config.a d3;
    public com.bytedance.android.livesdk.clearscreen.gesture.b d4;
    public com.bytedance.android.livesdk.chatroom.utils.i e3;
    public ClickPS2ClearScreenGestureBehavior e4;
    public com.bytedance.android.livesdk.widgetdescriptor.e0 f3;
    public com.bytedance.android.livesdk.clearscreen.gesture.a f4;
    public r8 g1;
    public Configuration g2;
    public com.bytedance.android.live.core.tetris.layer.view.a g3;
    public Disposable g4;
    public com.bytedance.android.livesdk.room.b h;
    public BaseWebDialogFragment h1;
    public int h2;
    public a71 h3;
    public Disposable h4;
    public boolean i;
    public final ah1.b i3;
    public Disposable i4;
    public boolean j;
    public final ah1.c j3;
    public final u j4;
    public SimpleLiveRoomViewHandler k;
    public Pair<InteractionWidgetsPosContext, Disposable> k0;
    public StickerWrapperWidget k1;
    public final ah1.a k3;
    public ko1.d k4;
    public com.bytedance.android.livesdk.room.handler.d l;
    public final List<is2.f> l3;
    public boolean l4;
    public boolean m;
    public final Boolean m3;
    public final j m4;
    public final int n;
    public final Boolean n3;
    public com.bytedance.android.live.room.h.b n4;
    public boolean o;
    public ViewLayerDelegate<com.bytedance.android.livesdk.widgetdescriptor.e0> o3;
    public Disposable o4;
    public Disposable p;
    public InRoomBannerManager p0;
    public yh0.b p1;
    public GameAbsInteractionDelegate p2;
    public ViewLayerDelegate<com.bytedance.android.livesdk.widgetdescriptor.e0> p3;
    public Integer p4;
    public Room q;
    public final e q3;
    public boolean q4;
    public String r;
    public final lo1.a r3;
    public boolean r4;
    public EnterRoomExtra s;
    public t s3;
    public nz.r s4;
    public boolean t;
    public final WidgetLoadState t3;
    public AbsKtvControlWidget t4;
    public boolean u;
    public rv2.a u3;
    public boolean v;
    public com.bytedance.android.live.liveinteract.c v1;
    public boolean v2;
    public com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.d v3;
    public boolean w;
    public final f w3;
    public boolean x;
    public LiveShareWidget x1;
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.v3 x2;
    public final h x3;
    public int y;
    public Widget y1;
    public float y2;
    public Dialog y3;
    public int z;
    public lm3.d z3;

    public class a implements h80.d<Pair<Fragment, FragmentManager>> {
        public final /* synthetic */ AbsInteractionFragment a;

        public final Object get() {
            if (this.a.getActivity() == null) goto L5;
            FragmentManager r0 = this.a.getActivity().getSupportFragmentManager();
        L7:
            return new Pair(this.a, r0);
        L5:
            r0 = null;
            goto L7
        }

        public a(AbsInteractionFragment r1) {
            this.a = r1;
        }
    }

    public class b implements h80.d<com.bytedance.android.live.core.tetris.layer.view.a> {
        public final /* synthetic */ AbsInteractionFragment a;

        public final Object get() {
            return this.a.Wb0();
        }

        public b(AbsInteractionFragment r1) {
            this.a = r1;
        }
    }

    public class c implements h80.d<GestureDetector.SimpleOnGestureListener> {
        public final /* synthetic */ AbsInteractionFragment a;

        public final Object get() {
            return this.a.j4;
        }

        public c(AbsInteractionFragment r1) {
            this.a = r1;
        }
    }

    public class d implements h80.d<Function1<MotionEvent, Unit>> {
        public final /* synthetic */ AbsInteractionFragment a;

        public final Object get() {
            return new u3(this);
        }

        public d(AbsInteractionFragment r1) {
            this.a = r1;
        }
    }

    public class e implements DialogInterface.OnKeyListener {
        public boolean a;
        public final /* synthetic */ AbsInteractionFragment b;

        public e(AbsInteractionFragment r1) {
            this.b = r1;
            this.a = false;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r4, int r5, KeyEvent r6) {
            Logger.d("AbsInteractionFragment", "onKey called " + r5 + " event " + r6.toString());
            Iterator r0 = ((ArrayList) this.b.Q3).iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            DialogInterface.OnKeyListener r1 = (DialogInterface.OnKeyListener) r0.next();
            if (r1 == null) goto L4;
            r1.onKey(r4, r5, r6);
            goto L4
        L8:
            this.b.j3.a(new ah1.d(r4, r5, r6));
            if (r5 != 25) goto L11;
        L14:
            boolean r7 = true;
        L16:
            if (tb1.c.a == false) goto L31;
            if (r7 == false) goto L31;
            this.b.getClass();
            if (jc1.k.f(IInteractGameService.class).isPlayingGame(InteractID.EffectGame) == false) goto L21;
        L26:
            boolean r8 = true;
        L27:
            if (r8 == true) goto L31;
            xs2.b.a().post(new com.bytedance.android.livesdk.event.a(0, r5, r6));
            return false;
        L21:
            if (jc1.k.f(IKtvService.class).isInKtvState(1) == true) goto L23;
        L25:
            r8 = false;
            goto L27
        L23:
            if (com.bytedance.android.livesdk.config.k2.a.getValue().booleanValue() == false) goto L25;
        L31:
            if (r6.getAction() != 0) goto L35;
            this.a = true;
            return false;
        L35:
            if (4 == r5) goto L37;
        L40:
            return false;
        L37:
            if (this.a == false) goto L40;
            this.b.onBackPressed();
            this.a = false;
            return true;
        L11:
            if (r5 == 24) goto L14;
            r7 = false;
            goto L16
        }
    }

    public class f implements SingleObserver<IBaseUser> {
        public final /* synthetic */ AbsInteractionFragment a;

        public f(AbsInteractionFragment r1) {
            this.a = r1;
        }

        public final void onError(Throwable r2) {
            AbsInteractionFragment.X90(this.a, r2);
        }

        public final void onSubscribe(Disposable r2) {
            this.a.L.add(r2);
        }

        public final void onSuccess(Object r4) {
            User r5 = (IBaseUser) r4;
            if (this.a.u == false) goto L23;
            if (r5 != null) goto L7;
            return;
        L7:
            if (r5.getUserAttr() == null) goto L13;
            User r0 = this.a.S;
            if (r0 != null) goto L11;
        L12:
            PrompterDataContext.Companion.getClass();
            PrompterDataContext.a.a(r5);
            goto L13
        L11:
            if (r0.getUserAttr() == null) goto L12;
        L13:
            User r6 = r5;
            this.a.S = r6;
            UserAttr r7 = r6.getUserAttr();
            jc1.k.f(IUserService.class).user().b().setUserAttr(r7);
            jc1.k.f(IUserService.class).user().f(this.a.S.getUserAttr());
            this.a.X.getUser().setValue(jm2.a.e(this.a.S));
            AbsInteractionFragment r1 = this.a;
            r1.W.put("data_user_in_room", r1.S);
            com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.b.L;
            Boolean r3 = Boolean.valueOf(this.a.S.getRoomAutoGiftThanks());
            r2.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r2, r3);
            if (r7 != null) goto L16;
        L19:
            AbsInteractionFragment r8 = this.a;
            ow0.a r9 = r8.L0;
            if (r9 == null) goto L24;
            r8.S.setNeverRecharge(r9.h());
            return;
        L24:
            return;
        L16:
            if (this.a.Z.getCommentService().getValue() == null) goto L18;
            ((t22.b) this.a.Z.getCommentService().getValue()).Xp(r7.isMuted());
        L18:
            com.bytedance.android.livesdk.log.b0 r10 = com.bytedance.android.livesdk.log.b0.o();
            String r11 = "Query self user info success, is admin: " + r7.isAdmin();
            r10.getClass();
            com.bytedance.android.live.core.log.g.i("ttlive_room", r11);
            goto L19
        }
    }

    public class g implements kf1.a {
        public final /* synthetic */ AbsInteractionFragment a;

        public final String tag() {
            return "AbsInteractionFragment_Follow";
        }

        public final CloseRoomInterceptList config() {
            return CloseRoomInterceptList.DEFAULT;
        }

        public g(AbsInteractionFragment r1) {
            this.a = r1;
        }

        public final boolean qa(Runnable r12, boolean r13) {
            if (r13 == false) goto L5;
            return false;
        L5:
            boolean r14 = tb1.c.a;
            final AbsInteractionFragment r15 = this.a;
            if (r15.O3 != null) goto L10;
            ICloseInterceptorService r1 = jc1.k.f(ICloseInterceptorService.class);
            if (r1 == null) goto L10;
            r15.O3 = r1.createQuitRoomGuideController();
        L10:
            m32.b r2 = r15.O3;
            if (r2 != null) goto L14;
            return false;
        L14:
            return r2.a(r12, r15.W, r15.getContext(), r15.q, r15.getArguments(), com.bytedance.android.livesdk.slideuptip.k.e(), r15.V, new com.bytedance.android.livesdk.chatroom.ui.c(r15));
        }
    }

    public class h implements Observer<RevPkState> {
        public final /* synthetic */ AbsInteractionFragment a;

        public h(AbsInteractionFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            AbsInteractionFragment r0 = this.a;
            r0.oc0((RevPkState) r2);
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ AbsInteractionFragment a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.Ac0();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public i(AbsInteractionFragment r1) {
            this.a = r1;
        }
    }

    public class j implements View.OnTouchListener {
        public final /* synthetic */ AbsInteractionFragment a;

        public j(AbsInteractionFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r9, MotionEvent r10) {
            AbsInteractionFragment r0 = this.a;
            if (r0.W3 == 0.0f) goto L5;
            float r1 = r10.getX();
            float r2 = r10.getY();
            AbsInteractionFragment r3 = this.a;
            r0.bc0(r1, r2, r3.W3, r3.Z3, r3.a4);
        L6:
            AbsInteractionFragment r4 = this.a;
            r4.W3 = r10.getX();
            AbsInteractionFragment r5 = this.a;
            r10.getY();
            r5.getClass();
            if (r10.getAction() != 1) goto L9;
        L10:
            ut1.j.d(this.a.getActivity());
            AbsInteractionFragment r6 = this.a;
            r6.W3 = 0.0f;
            r6.getClass();
            r6.Z3 = 0.0f;
            r6.a4 = 0.0f;
        L11:
            int r7 = r10.getAction();
            if (r7 == 0) goto L21;
            if (r7 == 1) goto L15;
            this.a.getClass();
        L23:
            if (this.a.D3.booleanValue() == true) goto L25;
        L27:
            AbsInteractionFragment r8 = this.a;
            if (r10.getAction() == 0) goto L30;
            boolean r11 = true;
        L32:
            if (r8.wb0(r11) == false) goto L34;
        L52:
            com.bytedance.android.livesdk.chatroom.record.i r12 = this.a.c4;
            if (r12 == null) goto L55;
            r12.a(r10);
        L55:
            Iterator r13 = ((ArrayList) this.a.P3).iterator();
        L57:
            if (r13.hasNext() == false) goto L62;
            View.OnTouchListener r14 = (View.OnTouchListener) r13.next();
            if (r14 == null) goto L57;
            r14.onTouch(r9, r10);
            goto L57
        L62:
            if (this.a.i3.a(new ah1.e(r9, r10)) == false) goto L64;
            return false;
        L64:
            Iterator r15 = ((List) this.a.X.getLiveTouchListenerList().getValue()).iterator();
        L66:
            if (r15.hasNext() == false) goto L71;
            View.OnTouchListener r16 = (View.OnTouchListener) r15.next();
            if (r16 == null) goto L66;
            return r16.onTouch(r9, r10);
        L71:
            return false;
        L34:
            if (this.a.qb0(r10) == true) goto L52;
            AbsInteractionFragment r17 = this.a;
            if (r17.Q == null) goto L52;
            g7 r18 = r17.R;
            if (r18 == null) goto L43;
            r18.onTouchEvent(r10);
            if (this.a.R.isInProgress() == false) goto L43;
            this.a.l4 = true;
        L43:
            if (this.a.l4 == false) goto L46;
            ALogger.i("AbsInteractionFragment", "mScaleGestureDetector intercept event");
            r10.setAction(3);
        L46:
            if (this.a.Q.onTouchEvent(r10) == true) goto L52;
            if (r10.getAction() != 1) goto L50;
        L51:
            this.a.cc0();
            goto L52
        L50:
            if (r10.getAction() != 3) goto L52;
        L30:
            r11 = false;
            goto L32
        L25:
            if (com.bytedance.android.livesdk.utils.p.a() == false) goto L27;
            this.a.Za0(r10);
            goto L27
        L15:
            AbsInteractionFragment r19 = this.a;
            r19.W3 = 0.0f;
            if (Math.abs(r19.X3 - r10.getX()) <= 30.0f) goto L18;
        L19:
            this.a.getClass();
        L20:
            this.a.getClass();
            goto L23
        L18:
            if (Math.abs(this.a.Y3 - r10.getY()) <= 30.0f) goto L20;
        L21:
            AbsInteractionFragment r20 = this.a;
            r20.X3 = r10.getX();
            AbsInteractionFragment r21 = this.a;
            r21.Y3 = r10.getY();
            this.a.l4 = false;
            goto L23
        L9:
            if (r10.getAction() != 3) goto L11;
        L5:
            r0.a4 = r10.getY();
            AbsInteractionFragment r22 = this.a;
            r22.Z3 = r10.getX();
            goto L6
        }
    }

    public class k extends com.bytedance.android.livesdk.user.h<FollowPair> {
        public final /* synthetic */ Room a;
        public final /* synthetic */ AbsInteractionFragment b;

        public final void onComplete() {
            AbsInteractionFragment.ba0(this.b);
        }

        public final void onError(Throwable r2) {
            AbsInteractionFragment.aa0(this.b, r2);
        }

        public final void onNext(Object r8) {
            FollowPair r9 = (FollowPair) r8;
            if (this.a.getOwner() == null) goto L38;
            if (r9 != null) goto L6;
            return;
        L6:
            if (this.b.W == null) goto L43;
            this.a.getOwner().setFollowStatus(r9.getFollowStatus());
            DataCenter r0 = this.b.W;
            if (r9.getFollowStatus() == 0) goto L11;
            boolean r1 = true;
        L12:
            r0.put("data_is_followed", Boolean.valueOf(r1));
            if (r9.getFollowStatus() == 0) goto L40;
            JSONObject r2 = new JSONObject();
            r2.put("anchor_id", this.b.q.getOwner().getIdStr());     // Catch: JSONException -> L17
            r2.put("room_id", String.valueOf(this.b.q.getId()));     // Catch: JSONException -> L17
            r2.put("follow_status", r9.getFollowStatus());     // Catch: JSONException -> L17
        L19:
            com.bytedance.android.livesdk.utils.g4.h(r2);
            if (com.bytedance.android.livesdk.utils.c1.b(this.b.W) == false) goto L29;
            ILiveDouPlusService r10 = jc1.k.f(ILiveDouPlusService.class);
            HashMap r5 = new HashMap();
            r5.put("ad_extra_data", r2.toString());
            Map r3 = com.bytedance.android.livesdk.utils.c1.e(this.b.W);
            if (r3 != null) goto L24;
        L27:
            r10.logEvent(true, "live_ad", "follow_success", r5);
            return;
        L24:
            if (r3.isEmpty() == true) goto L27;
            r5.putAll(r3);
            goto L27
        L29:
            if (com.bytedance.android.livesdk.utils.c1.c(this.b.W) == false) goto L42;
            ILiveDouPlusService r11 = jc1.k.f(ILiveDouPlusService.class);
            HashMap r6 = new HashMap();
            r6.put("ad_extra_data", r2.toString());
            Map r4 = com.bytedance.android.livesdk.utils.c1.f(this.b.W);
            if (r4.isEmpty() == true) goto L34;
            r6.putAll(r4);
        L34:
            r11.logEvent(true, "live_ad", "follow_success", r6);
            com.bytedance.android.livesdk.utils.b3.a(this.b.W, r2);
            return;
        L42:
            return;
        L17:
            e = move-exception;
            e.printStackTrace();
            goto L19
        L40:
            return;
        L11:
            r1 = false;
            goto L12
        L43:
            return;
        }

        public final void onSubscribe(Disposable r2) {
            this.b.L.add(r2);
        }

        public k(AbsInteractionFragment r1, Room r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class l implements IClearScreenManagerFactory {
        public l() {
        }

        public final jg1.b create(String r2) {
            return new com.bytedance.android.livesdk.clearscreen.h("ClearScreenManagerAbility_SSS_111");
        }
    }

    public class m extends com.bytedance.android.livesdk.user.h<FollowPair> {
        public final /* synthetic */ mt1.a a;
        public final /* synthetic */ Room b;
        public final /* synthetic */ AbsInteractionFragment c;

        public final void onNext(Object r6) {
            FollowPair r7 = (FollowPair) r6;
            boolean r1 = true;
            if (com.bytedance.android.livesdk.utils.c1.c(this.c.W) == false) goto L15;
            JSONObject r0 = new JSONObject();
            r0.put("anchor_id", this.c.q.getOwner().getIdStr());     // Catch: JSONException -> L7
            r0.put("room_id", String.valueOf(this.c.q.getId()));     // Catch: JSONException -> L7
        L9:
            ILiveDouPlusService r2 = jc1.k.f(ILiveDouPlusService.class);
            HashMap r3 = new HashMap();
            r3.put("ad_extra_data", r0.toString());
            Map r4 = com.bytedance.android.livesdk.utils.c1.f(this.c.W);
            if (r4.isEmpty() == true) goto L13;
            r3.putAll(r4);
        L13:
            r2.logEvent(true, "live_ad", "follow_cancel", r3);
        L7:
            e = move-exception;
            e.printStackTrace();
        L15:
            if (AbsInteractionFragment.u4.contains(this.a.d) == false) goto L18;
            xs2.b.a().post(new zg1.h1(38, this.a.c));
        L18:
            if (this.b.getOwner() == null) goto L31;
            if (r7 != null) goto L21;
            return;
        L21:
            if (this.c.W == null) goto L33;
            this.b.getOwner().setFollowStatus(r7.getFollowStatus());
            DataCenter r5 = this.c.W;
            if (r7.getFollowStatus() != 0) goto L27;
            r1 = false;
        L27:
            r5.put("data_is_followed", Boolean.valueOf(r1));
            return;
        L33:
            return;
        }

        public final void onSubscribe(Disposable r2) {
            this.c.L.add(r2);
        }

        public m(AbsInteractionFragment r1, mt1.a r2, Room r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class n extends AnimatorListenerAdapter {
        public final /* synthetic */ AbsInteractionFragment a;

        public n(AbsInteractionFragment r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            if (this.a.Ta0() == null) goto L10;
            ViewLayerDelegate<com.bytedance.android.livesdk.widgetdescriptor.e0> r4 = this.a.Ta0();
            ((d90.d) this.a.f3).f.getClass();
            com.bytedance.android.livesdk.chatroom.tetris.portrait.a r5 = (com.bytedance.android.livesdk.chatroom.tetris.portrait.a) r4.g(d90.d.a.H0, com.bytedance.android.livesdk.chatroom.tetris.portrait.a.class);
            if (r5 == null) goto L10;
            if (wt2.a.e(this.a.D3) == true) goto L9;
            r5.t(0);
            goto L10
        L9:
            r5.i();
        L10:
            xs2.b.a().post(new zg1.s(true));
            if (jc1.k.f(IPerformanceManager.class) == null) goto L14;
            jc1.k.f(IPerformanceManager.class).onEnterFullScreenClean();
            return;
        }
    }

    public class o extends AnimatorListenerAdapter {
        public final /* synthetic */ AbsInteractionFragment a;

        public o(AbsInteractionFragment r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            this.a.Xc0(0);
            xs2.b.a().post(new zg1.s(false));
        }
    }

    public class p implements jm1.a.a {
        public final /* synthetic */ AbsInteractionFragment a;

        public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> a() {
            com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.d r0 = this.a.v3;
            if (r0 == null) goto L7;
            return r0.b.a();
        L7:
            return new TreeMap();
        }

        public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> b() {
            com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.d r0 = this.a.v3;
            if (r0 == null) goto L7;
            return r0.b.b();
        L7:
            return new TreeMap();
        }

        public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> c() {
            com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.d r0 = this.a.v3;
            if (r0 == null) goto L7;
            return r0.b.c();
        L7:
            return new TreeMap();
        }

        public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> d() {
            com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.d r0 = this.a.v3;
            if (r0 == null) goto L7;
            return r0.b.d();
        L7:
            return new TreeMap();
        }

        public final com.bytedance.android.livesdk.chatroom.model.z3 e() {
            return this.a.T1;
        }

        public p(AbsInteractionFragment r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ class q {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageType.values().length];
            a = r0;
            r0[MessageType.GAME_CP_USER_DOWNLOAD_MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L74:
            a[MessageType.MEMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L90:
            a[MessageType.COMMON_TOAST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L96:
            a[MessageType.GUIDE_MESSAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
        L100:
            a[MessageType.COMMON_GUIDE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L35
        L62:
            a[MessageType.FOLLOW_GUIDE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L36
        L66:
            a[MessageType.REMIND.ordinal()] = 7;     // Catch: NoSuchFieldError -> L37
        L82:
            a[MessageType.DOU_PLUS_MESSAGE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L38
        L86:
            a[MessageType.FRATERNITY_MESSAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L39
        L104:
            a[MessageType.RECOMMEND_USER_MESSAGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L40
        L108:
            a[MessageType.CEREMONY_MESSAGE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L41
        L68:
            a[MessageType.ROOM_AUTH_MESSAGE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L42
        L72:
            a[MessageType.ROOM_CHALLENGE_MESSAGE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L43
        L88:
            a[MessageType.COVER_MESSAGE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L44
        L92:
            a[MessageType.ROOM.ordinal()] = 15;     // Catch: NoSuchFieldError -> L45
        L110:
            a[MessageType.STREAM_CONTROL_MESSAGE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L46
        L58:
            a[MessageType.SKY_EYE_ANCHOR_SET_MESSAGE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L47
        L76:
            a[MessageType.PULL_STREAM_UPDATE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L48
        L78:
            a[MessageType.PULL_STREAM_CHANGE.ordinal()] = 19;     // Catch: NoSuchFieldError -> L49
        L94:
            a[MessageType.TOOLBAR_CONTROL_MESSAGE.ordinal()] = 20;     // Catch: NoSuchFieldError -> L50
        L98:
            a[MessageType.ADMIN_RECORD_MESSAGE.ordinal()] = 21;     // Catch: NoSuchFieldError -> L51
        L60:
            a[MessageType.ADMIN_RECORD_HANDLE_RESULT_MESSAGE.ordinal()] = 22;     // Catch: NoSuchFieldError -> L52
        L64:
            a[MessageType.ROOM_UNION_LIVE_MESSAGE.ordinal()] = 23;     // Catch: NoSuchFieldError -> L53
        L80:
            a[MessageType.UNION_LIVE_NOTICE_MESSAGE.ordinal()] = 24;     // Catch: NoSuchFieldError -> L54
        L84:
            a[MessageType.LIVE_PLAY_BACK_SIGNAL.ordinal()] = 25;     // Catch: NoSuchFieldError -> L55
        L102:
            a[MessageType.VS_SCHEDULE_MESSAGE.ordinal()] = 26;     // Catch: NoSuchFieldError -> L56
        L106:
            a[MessageType.ANCHOR_COMMON_DIALOG_MESSAGE.ordinal()] = 27;     // Catch: NoSuchFieldError -> L57
            return;
        }
    }

    public class r implements en1.a {
        public final /* synthetic */ AbsInteractionFragment a;

        public final void Kf() {
            AbsInteractionFragment r0 = this.a;
            View r1 = r0.F3;
            if (r1 == null) goto L5;
            r1.setAlpha(1.0f);
        L5:
            FrameLayout r2 = r0.a3;
            if (r2 == null) goto L8;
            r2.setVisibility(8);
        L8:
            ALogger.i("AbsInteractionFragment", "hideInteractionAlpha");
        }

        public r(AbsInteractionFragment r1) {
            this.a = r1;
        }

        public final void nk(float r2) {
            AbsInteractionFragment.Y90(this.a, r2);
        }
    }

    public class s implements ToolbarComponentCheckInterface {
        public final /* synthetic */ AbsInteractionFragment a;

        public s(AbsInteractionFragment r1) {
            this.a = r1;
        }

        public final boolean checkThenLoad(ToolbarMatchInterface r2, Function0<Unit> r3, Function1<? super String, Unit> r4) {
            if (tb1.c.a == true) goto L5;
        L11:
            r2.setExtraDataAfterCheck(this.a.J2);
            r3.invoke();
            return true;
        L5:
            if (this.a.isScreenPortrait() == true) goto L11;
            if (this.a.nb0() == true) goto L10;
            r4.invoke("share room auth disable");
            return true;
        L10:
            r4.invoke("share in landscape");
            return true;
        }
    }

    public class t implements Runnable {
        public final /* synthetic */ Room a;
        public final /* synthetic */ EnterRoomExtra b;
        public final /* synthetic */ Runnable c;
        public final /* synthetic */ AbsInteractionFragment d;

        public final void a() {
            RoomContext r0 = this.d.X;
            boolean r1 = false;
            int r2 = 0;
            if (r0 != null) goto L5;
        L35:
            RoomContext r3 = this.d.X;
            if (r3 == null) goto L38;
            int r4 = r3.hashCode();
        L39:
            StringBuilder r5 = new StringBuilder("RoomContext is null: ");
            if (this.d.X != null) goto L42;
            boolean r6 = true;
        L43:
            r5.append(r6);
            com.bytedance.android.live.core.tetris.widgets.d.g(r5.toString());
            com.bytedance.android.live.core.tetris.widgets.d.g("RoomContext is not valid, this=" + hashCode() + " context=" + r4);
            com.bytedance.android.live.core.tetris.widgets.d.g("Current RoomContext is cleared, return continueShow");
            HashMap r7 = new HashMap();
            StringBuilder r8 = new StringBuilder();
            if (this.d.X != null) goto L46;
            r1 = true;
        L46:
            r8.append(r1);
            r8.append("");
            r7.put("data_context_is_null", r8.toString());
            r7.put("method", "continueShow");
            com.bytedance.android.live.core.tetris.widgets.d.e("ttlive_interaction_opt_data_context_invalid_error", r7);
            return;
        L42:
            r6 = false;
            goto L43
        L38:
            r4 = 0;
            goto L39
        L5:
            if (r0.isCleared() == true) goto L35;
            AbsInteractionFragment r9 = this.d;
            if (r9.E3 == true) goto L11;
            com.bytedance.android.live.core.tetris.widgets.d.g("RoomContext has not init");
            HashMap r10 = new HashMap();
            r10.put("method", "prepareWidget");
            com.bytedance.android.live.core.tetris.widgets.d.e("ttlive_interaction_opt_data_context_not_init_error", r10);
            return;
        L11:
            r9.q = this.a;
            r9.C3 = true;
            r9.s = this.b;
            com.bytedance.android.live.core.tetris.widgets.d.g("update some global data on continue room enter");
            AbsInteractionFragment r11 = this.d;
            InRoomBannerManager r12 = r11.p0;
            if (r12 == null) goto L17;
            Integer r13 = Integer.valueOf(com.bytedance.android.livesdk.utils.c1.i(r11.W));
            if (r13 == null) goto L16;
            r2 = r13.intValue();
        L16:
            r12.e = r2;
        L17:
            this.d.Gc0(AbsInteractionFragment.da0(this.d));
            AbsInteractionFragment r14 = this.d;
            r14.getClass();
            ALogger.i("AbsInteractionFragment", "AfterRoomEnterLoad");
            r14.N3 = true;
            if (r14.Ha0().booleanValue() == true) goto L20;
        L28:
            rv2.a r15 = this.d.u3;
            if (r15 == null) goto L31;
            r15.K();
        L31:
            this.d.ed0("continueShowRunnable");
            AbsInteractionFragment r16 = this.d;
            r16.hc0(r16.s);
            this.d.xa0();
            Runnable r17 = this.c;
            if (r17 == null) goto L48;
            MainThreadPostUtils.b(r17);
            return;
        L48:
            return;
        L20:
            if (r14.Fa0() == false) goto L28;
            r14.pr(r14.q);
            if (r14.N3 == true) goto L24;
        L27:
            r14.M.post(new t3(r14));
            goto L28
        L24:
            if (r14.M3 == false) goto L27;
            r14.XZ(r14.q);
            r14.CM(r14.q);
            goto L27
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public t(AbsInteractionFragment r1, Room r2, EnterRoomExtra r3, vh1.c0 r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public final class u extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ AbsInteractionFragment a;

        public u(AbsInteractionFragment r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r6) {
            Disposable r0 = this.a.o4;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            ko1.d r1 = this.a.k4;
            if (r1 == null) goto L14;
            r1.a = true;
            ko1.d.a r2 = r1.d;
            if (r2 == null) goto L10;
            r2.removeCallbacks(r1.e);
        L10:
            ko1.d.a r3 = r1.d;
            if (r3 == null) goto L14;
            r3.postDelayed(r1.e, r1.b.c());
        L14:
            if (this.a.pX() == true) goto L21;
            boolean r7 = this.a.gc0(r6);
            if (r7 == true) goto L24;
        L20:
            return r7;
        L24:
            IEnterProcessorService r4 = jc1.k.f(IEnterProcessorService.class);     // Catch: Exception -> L23
            if (r4 == null) goto L20;
            r4.interactionBizInterceptor().doDiggActionWithToken(this.a.getContext());     // Catch: Exception -> L23
            goto L20
        L21:
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r3) {
            AbsInteractionFragment r4 = this.a;
            if (r4.u == false) goto L14;
            InputMethodManager r0 = (InputMethodManager) r4.getActivity().getSystemService("input_method");
            r0.hideSoftInputFromWindow(r4.A.getWindowToken(), 0);     // Catch: Exception -> L8
            return true;
        L8:
            e = move-exception;
            e.printStackTrace();
            return true;
        L14:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r4) {
            super.onLongPress(r4);
            if (this.a.q != null) goto L5;
            return;
        L5:
            xs2.b.a().post(new zg1.h1(26, this.a.q));
            int r5 = com.bytedance.android.livesdk.utils.i1.a;
            com.bytedance.android.livesdk.utils.i1.a(null, "press", this.a.q);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r4) {
            AbsInteractionFragment r0 = this.a;
            if (r4.getActionIndex() != this.a.p4.intValue()) goto L5;
            boolean r1 = true;
        L7:
            return r0.sc0(r4, Boolean.valueOf(r1));
        L5:
            r1 = false;
            goto L7
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r2) {
            this.a.tc0();
            return AbsInteractionFragment.Z90(this.a, r2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r2, MotionEvent r3, float r4, float r5) {
            return this.a.jc0(r2, r3, r4, r5);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r4, MotionEvent r5, float r6, float r7) {
            if (r4 == null) goto L8;
            if (r5 == null) goto L8;
            Logger.d("AbsInteractionFragment", String.format("onScroll, Event1={%f, %f}, Event2={%f, %f}, distanceX=%f, distanceY=%f", new Object[]{Float.valueOf(r4.getX()), Float.valueOf(r4.getY()), Float.valueOf(r5.getX()), Float.valueOf(r5.getY()), Float.valueOf(r6), Float.valueOf(r7)}));
            return this.a.rc0(r4, r5, r6, r7);
        L8:
            return false;
        }
    }

    public void Ac0() {
    }

    public abstract GameAbsInteractionDelegate Ba0();

    public void Da0() {
    }

    public void Ec0(Room r1) {
    }

    public final /* synthetic */ void F30(Room r1, EnterRoomExtra r2, com.bytedance.android.live.room.w r3) {
    }

    public void Ib0() {
    }

    public void Ic0() {
    }

    public abstract void Jc0(View r1);

    public void Ma0(float r1) {
    }

    public final /* synthetic */ void P7(Room r1, com.bytedance.android.live.room.w r2) {
    }

    public void Pc0() {
    }

    public void Qc0(String r1) {
    }

    public void Rc0(String r1, String r2) {
    }

    public int Sa0() {
        return 0;
    }

    public final /* synthetic */ void T4(Room r1, com.bytedance.android.live.room.w r2) {
    }

    public abstract boolean Ub0(String r1);

    public boolean V9() {
        return this instanceof AudiencePortraitInteractionFragment;
    }

    public abstract boolean Vb0();

    public hh1.v0 Wa0() {
        return null;
    }

    public abstract String Xa0();

    public void Xb0() {
    }

    public void Xc0(int r1) {
    }

    public void Za0(MotionEvent r1) {
    }

    public void ab0(kj r1) {
    }

    public void b0(String r1) {
    }

    public void bb0(boolean r1) {
    }

    public void bc0(float r1, float r2, float r3, float r4, float r5) {
    }

    public void cU(com.bytedance.android.live.room.h.a r1) {
    }

    public void cc0() {
    }

    public void ea0(boolean r1) {
    }

    public void eb0(ri r1) {
    }

    public void ec0(ControlMessage r1) {
    }

    public void fc0(ControlMessage r1) {
    }

    public View ff() {
        return null;
    }

    public boolean g1() {
        return this instanceof AnchorPortraitInteractionFragment;
    }

    public void ga0() {
    }

    public void gd0() {
    }

    public final Map<String, Object> getEnvData() {
        return null;
    }

    public final String getSpm() {
        return "a100.a100";
    }

    public void ha0(Room r1) {
    }

    public final boolean isIgnored() {
        return false;
    }

    public abstract boolean isScreenPortrait();

    public void ja0() {
    }

    public void jb0() {
    }

    public abstract boolean jc0(MotionEvent r1, MotionEvent r2, float r3, float r4);

    public void ka0(Room r1) {
    }

    public void kc0(boolean r1) {
    }

    public void lc0(boolean r1) {
    }

    public final /* synthetic */ void n9(Room r1, com.bytedance.android.live.room.w r2) {
    }

    public void nc0(int r1) {
    }

    public void ns() {
    }

    public boolean o5() {
        return this instanceof AudienceLandscapeInteractionFragment;
    }

    public boolean ob0() {
        return this instanceof AudiencePortraitInteractionFragment;
    }

    public void oc0(RevPkState r1) {
    }

    public final boolean onBackPressed() {
        if (wb0(true) == false) goto L5;
        return true;
    L5:
        IEnterGuideService r1 = jc1.k.f(IEnterGuideService.class);
        if (r1 != null) goto L8;
    L11:
        RoomContext r2 = this.X;
        if (r2 != null) goto L14;
    L17:
        zg1.h1 r3 = new zg1.h1(8);
        Bundle r4 = new Bundle();
        r4.putLong("time", System.currentTimeMillis());
        r4.putString("action_type", "draw");
        r3.d = r4;
        xs2.b.a().post(r3);
        Qc0("back_press_to_finish_live");
        f7.b = true;
        d7.b = true;
        e7.b = true;
        return true;
    L14:
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.b) r2.getCommonPopupModel().getValue()).a == false) goto L17;
        xs2.b.a().post(new com.bytedance.android.livesdk.commonpop.a());
        return true;
    L8:
        if (r1.isBottomGuideShowing(this) == false) goto L11;
        r1.closeBottomGuide(this);
        return true;
    }

    public void onEvent(b30.t r1) {
    }

    public void onOuterPageScrollStateChanged(int r1) {
    }

    public void onPageScrollStateChanged(int r1) {
    }

    public void onSei(String r1) {
    }

    public void pc0() {
    }

    public boolean qb0(MotionEvent r1) {
        return false;
    }

    public boolean rc0(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        return true;
    }

    public boolean sc0(MotionEvent r1, Boolean r2) {
        return false;
    }

    public final Fragment self() {
        return this;
    }

    public void setNestedOutside(boolean r1) {
    }

    public void ta0() {
    }

    public abstract boolean tb0();

    public void tc0() {
    }

    public boolean ub0(boolean r1) {
        return r1;
    }

    public void uc0(boolean r1, boolean r2) {
    }

    public void vc0() {
    }

    public void xc0(zg1.l3 r1) {
    }

    public final void yv() {
    }

    public void zA(EnterRoomInfoResult r1) {
    }

    public void zc0(String r1, StreamControlInfo.ControlParams r2) {
    }

    static {
        u4 = Arrays.asList(new String[]{"homepage_follow", "homepage_follow_ecom", "homepage_ecom_follow"});
        v4 = false;
    }

    private String Ra0() {
        ((Integer) this.W.get("data_xt_broadcast_type", -1)).intValue();
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_room", "prepare load widget");
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.u.l().c(com.bytedance.android.livesdk.log.filter.n0.class);
        if (r0 == null) goto L9;
        Map r1 = r0.getMap();
        if (r1 == null) goto L9;
        if (r1.containsKey("source") == false) goto L9;
        return (String) r1.get("source");
    L9:
        return "";
    }

    private InteractionWidgetsPosContext Ya0() {
        if (this.k0 != null) goto L19;
        if (com.bytedance.android.livesdk.summer.i.a == true) goto L7;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == false) goto L12;
        this.k0 = (Pair) com.bytedance.android.livesdk.summer.a.b.lookup(com.bytedance.android.livesdk.summer.i.d, Pair.class, new com.bytedance.android.livesdk.chatroom.ui.m());
    L13:
        Pair<InteractionWidgetsPosContext, Disposable> r1 = this.k0;
        if (r1 == null) goto L19;
        if (r1.getFirst() == null) goto L19;
        ALogger.i("AbsInteractionFragment", "CreateRoomContext this=" + hashCode() + " context=" + ((InteractionWidgetsPosContext) this.k0.getFirst()).hashCode());
        goto L19
    L12:
        this.k0 = com.bytedance.live.datacontext.d.a(new com.bytedance.android.livesdk.chatroom.ui.n());
        goto L13
    L7:
        if (com.bytedance.android.livesdk.summer.i.c == false) goto L9;
        r0 = true;
    L19:
        return (InteractionWidgetsPosContext) this.k0.getFirst();
    }

    public void Ab0() {
        HashMap r0 = new HashMap();
        r0.put("anchor_id", String.valueOf(this.q.author().getUserId()));
        r0.put("room_id", String.valueOf(this.q.getId()));
        r0.put("duration", String.valueOf(this.V.getDuration()));
        com.bytedance.android.livesdk.log.d.c(this.W, "live_ad", "live_watch_onemin", r0);
        com.bytedance.android.livesdk.log.d.c(this.W, "live_ad", "livesdk_watch_onemin", r0);
        if (com.bytedance.android.live.core.feed.a.a().c(Long.valueOf(this.q.getId())) == false) goto L5;
    L6:
        com.bytedance.android.livesdk.log.d.c(this.W, "draw_ad", "click", r0);
        return;
    L5:
        if (com.bytedance.android.live.core.feed.a.a().b(Long.valueOf(this.q.getId())) == true) goto L6;
    }

    public final void C60() {
        RecyclableWidgetManager r0 = this.e;
        if (r0 == null) goto L6;
        r0.C60();
        return;
    }

    public Map<ILayoutConstraint, com.bytedance.android.livesdk.room.placeholder.widget.d> Ca0() {
        return new HashMap();
    }

    public void DS() {
        rv2.a r0 = this.u3;
        if (r0 == null) goto L5;
        r0.onDestroy();
    L5:
        com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.d r1 = this.v3;
        if (r1 == null) goto L9;
        r1.a.onDestroy();
        return;
    }

    public final boolean EX() {
        RoomContext r0 = this.X;
        if (r0 != null) goto L7;
        com.bytedance.android.live.core.tetris.widgets.d.g("data context is null");
        return false;
    L7:
        if (r0.isCleared() == false) goto L11;
        com.bytedance.android.live.core.tetris.widgets.d.g("data context cleared");
        return false;
    L11:
        if (this.E3 == true) goto L14;
        com.bytedance.android.live.core.tetris.widgets.d.g("room context has not init");
        return false;
    L14:
        return true;
    }

    public void Ea0() {
        if (u80.a.getValue().intValue() != 0) goto L6;
        com.bytedance.android.livesdk.utils.d4.n(com.bytedance.android.livesdk.chatroom.utils.n3.e(this.W));
        return;
    }

    public final boolean Fa0() {
        ComponentManagerABHelper r0 = ComponentManagerABHelper.INSTANCE;
        if (r0.enableRoomSceneScheduler() == true) goto L5;
    L9:
        return false;
    L5:
        if (r0.enableRoomSceneMerge() == false) goto L9;
        if (this.f.h() == false) goto L9;
        return true;
    }

    public void Fc0() {
        RoomContext r0 = this.X;
        if (r0 == null) goto L12;
        if (r0.getExternalConfigJudger() == null) goto L12;
        if (this.X.getExternalConfigJudger().getValue() == null) goto L12;
        if (((IExternalConfigJudger) this.X.getExternalConfigJudger().getValue()).disable(EXTERNAL_CONFIG_TYPE.Guide, "leaveRetainGuide") == false) goto L12;
        return;
    L12:
        if (com.bytedance.android.livesdk.chatroom.utils.o4.a == true) goto L15;
        com.bytedance.android.livesdk.chatroom.utils.o4.a = true;
        this.U.add(new k4(this));
    L15:
        ICloseInterceptorService r1 = jc1.k.f(ICloseInterceptorService.class);
        if (r1 == null) goto L18;
        this.U.addAll(r1.provideCloseRoomInterceptors(getContext(), this.q, this.J3));
    L18:
        this.U.add(new g(this));
        this.U.add(new l4(this));
        if (tb1.c.c == true) goto L21;
    L24:
        this.U.add(new m4(this));
        this.U.add(new p4(this));
        return;
    L21:
        if (l8.a() == false) goto L24;
        this.U.add(new a4(this));
        goto L24
    }

    public final boolean Ga0() {
        Room r0 = this.q;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getMRoomAuthStatus() != null) goto L7;
        return false;
    L7:
        if (this.q.getMRoomAuthStatus().getCastScreen() != 1) goto L12;
        return true;
    L12:
        return false;
    }

    public void Hc0() {
        InRoomBannerManager r0 = new InRoomBannerManager(this);
        this.p0 = r0;
        Integer r1 = Integer.valueOf(com.bytedance.android.livesdk.utils.c1.i(this.W));
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        r0.e = r2;
        ((ObservableSubscribeProxy) this.p0.d(Long.valueOf(this.q.getId()), 0).as(AutoDispose.bind(this))).subscribe(new com.bytedance.android.livesdk.chatroom.ui.f(this));
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public void I5() {
        CommentContext r0 = this.Z;
        if (r0 == null) goto L8;
        if (r0.getCommentService().getValue() == null) goto L8;
        ((t22.b) this.Z.getCommentService().getValue()).dismissInputDialog();
    L8:
        if (SettingKeyUtils.a() == true) goto L17;
        BaseWebDialogFragment r1 = this.F;
        if (r1 != null) goto L32;
    L25:
        m00.f r2 = this.V1;
        if (r2 == null) goto L29;
        r2.destroy();
    L29:
        if (getActivity() == null) goto L36;
        jc1.k.f(IBrowserService.class).dismissAllWebDialogs(getActivity());
        return;
    L36:
        return;
    L32:
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L25;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L25
    L17:
        HybridDialog r4 = this.G;
        if (r4 == null) goto L25;
        r4.dismissAllowingStateLoss();     // Catch: Exception -> L21
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L25;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L25
    }

    public final View IP() {
        if (this.q != null) goto L5;
        return null;
    L5:
        if (this.t == false) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r0 = ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.W)).t(ToolbarButton.CLOSE_ROOM);
        if ((r0 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.r2) == true) goto L9;
        return null;
    L9:
        return ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.r2) r0).a;
    L12:
        return null;
    }

    public void Ia0() {
        ALogger.i("COMPONENTX_END", "endOtherLoad AbsInteractionFragment");
        mg2.d r0 = this.f;
        f70.b r1 = mg2.e.e;
        ViewLayerDelegate<d90.a> r2 = r0.o4(r1, LayerIndex.INDEX_5);
        this.G2 = r2;
        if ((r2 instanceof Portrait5thDelegate) == true) goto L5;
    L7:
        this.H2 = this.f.o4(r1, LayerIndex.INDEX_6);
        this.F2 = this.f.o4(r1, LayerIndex.INDEX_3);
        if (this.v2 == false) goto L12;
        GameAbsInteractionDelegate r3 = this.p2;
        if (r3 == null) goto L12;
        r3.d(this.F3);
    L12:
        Rb0();
        boolean r4 = k60.b.a();
        if (tb1.c.a == false) goto L15;
        this.e.ea0(VerifyCodeWidget.class, r4, r4);
    L15:
        this.e.ea0(GameSuggestionWidget.class, r4, r4);
        Ic0();
        Jb0();
        Aa0(new l3(this));
        if (pm1.f.o() == null) goto L28;
        pm1.f.o().a();
        if (MultiTabManagerImpl.e.h(this.W) == false) goto L28;
        if (isScreenPortrait() == false) goto L27;
        DataCenter r5 = this.W;
        if (r5 == null) goto L27;
        if (((Boolean) r5.get("match_tab_all_loaded", Boolean.FALSE)).booleanValue() == true) goto L27;
        this.W.observe("match_tab_all_loaded", this);
    L29:
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load other widget end all");
        return;
    L27:
        Mb0();
    L28:
        Mb0();
        goto L29
    L5:
        if (getContext() == null) goto L7;
        Portrait5thDelegate r6 = this.G2;
        Context r7 = getContext();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "context");
        r6.t = r7;
        goto L7
    }

    public final void Jb0() {
        int r0 = a5.a;
        Room r1 = this.q;
        RecyclableWidgetManager r2 = this.e;
        Intrinsics.checkNotNullParameter(r1, "room");
        Intrinsics.checkNotNullParameter(r2, "widgetManager");
        if (r1.isSofaRoom() == true) goto L15;
        RoomAuthStatus r3 = r1.getMRoomAuthStatus();
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.enableShortTouch() == false) goto L10;
    L12:
        r2.load(new CommonShortTouchWidget());
        return;
    L10:
        if (r3.enableEnhancedTouch() == true) goto L12;
        return;
    }

    public void Ka0() {
        ALogger.i("COMPONENTX_END", "endP1Load AbsInteractionFragment");
        this.e.load(2131371661, new P1EndWidget());
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load p1 widget end all");
    }

    public void La0() {
        ALogger.i("COMPONENTX_END", "endP2Load AbsInteractionFragment");
        this.e.load(2131371661, new P2EndWidget());
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load p2 widget end all");
    }

    public final void Lb0() {
        int r0 = com.bytedance.android.live.liveinteract.utils.w0.a;
        if (com.bytedance.android.live.liveinteract.utils.w0.c(this.q) == false) goto L8;
        IInteractService r1 = jc1.k.f(IInteractService.class);
        if (r1 == null) goto L9;
        ALogger.i("AbsInteractionFragment", "直播间加载动态化框架");
        r1.preloadDynamicWidget(this.W, this.e, null);
        return;
    L9:
        return;
    }

    public final void Mb0() {
        this.L1 = new EndWidget();
        if (k60.b.e() == false) goto L5;
        RecyclableWidgetManager r0 = this.e;
        r0.g.b = new j0(this);
        return;
    L5:
        this.e.load(2131371661, this.L1);
    }

    public RoomState Na0() {
        Bundle r15 = new Bundle();
        Room r14 = this.q;
        if (tb1.c.a == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        r15.putBoolean("EXTRA_IS_D_ROOM", r0);
        r15.putBoolean("EXTRA_BOOL_ROOM_HAS_COMMERCE", r14.isHasCommerceGoods());
        if (this.D3.booleanValue() == false) goto L11;
    L29:
        User r1 = r14.getOwner();
        if (r1 != null) goto L32;
    L34:
        boolean r2 = false;
    L35:
        r15.putBoolean("EXTRA_BOOL_ANCHOR_HAS_COMMERCE_PERMISSION", r2);
        if (getArguments() == null) goto L39;
        r15.putBoolean("EXTRA_BOOL_SLIDED_IN_VIEW_PAGER", getArguments().getBoolean("is_slide_to_next_room", false));
    L39:
        if (r14.getRoomCart() == null) goto L41;
        r15.putBoolean("EXTRA_BOOL_ROOM_HAS_CART_INFO", true);
        r15.putBoolean("EXTRA_BOOL_ROOM_HAS_INIT_GOOD", r14.getRoomCart().getContainCart());
        r15.putInt("EXTRA_INT_TOTAL_SHOPPING_GOOD", r14.getRoomCart().getTotal());
        r15.putInt("EXTRA_INT_FLASH_SHOPPING_GOOD", r14.getRoomCart().getFlashTotal());
        r15.putString("EXTRA_STRING_CART_ICON", r14.getRoomCart().getCartIcon());
        r15.putInt("EXTRA_INT_SHOW_CART", r14.getRoomCart().getShowCartExt());
        r15.putSerializable("EXTRA_MAP_CART_VERTICAL", r14.getRoomCart().getVerticalMap());
        r15.putSerializable("EXTRA_MAP_CART_HORIZONTAL", r14.getRoomCart().getHorizontalMap());
        r15.putSerializable("EXTRA_MAP_CART_STYLE", r14.getRoomCart().getCartStyleMap());
    L41:
        r15.putString("EXTRA_ROOM_ENTER_LOG_ID", r14.getEnterLogId());
        if (r14.getToolbarData() != null) goto L44;
    L52:
        int r3 = 0;
    L54:
        if (r14.getRoomCart() != null) goto L56;
    L60:
        r15.putBoolean("EXTRA_BOOL_IS_HORIZONTAL_STREAM", xb0(r14));
        r15.putBoolean("EXTRA_BOOL_IS_LANDSCAPE_NEW_STYLE", com.bytedance.android.livesdk.utils.landscape.d.c(this.W));
        r15.putBoolean("EXTRA_BOOL_FROM_AD", com.bytedance.android.livesdk.commerce.b.b(this.W));
        m90.c r4 = m90.b.B;
        LiveEffectContextFactoryDelegate.Type r10 = LiveEffectContextFactoryDelegate.Type.DEFAULT;
        r15.putBoolean("EXTRA_BOOL_COMMODITY_NO_FILTER", ((Boolean) r4.c(r10)).booleanValue());
        r15.putBoolean("EXTRA_BOOL_COMMODITY_NO_FILTER_DEFAULT_OPEN", ((Boolean) m90.b.C.c(r10)).booleanValue());
        IHostCommerceServiceLive r5 = jc1.k.f(IHostCommerceServiceLive.class);
        if (r5 == null) goto L63;
        r15.putBoolean("EXTRA_BOOL_FULL_FEATURED_LIVE_COMMERCE", r5.enableFullLiveCommerce());
    L63:
        DataCenter r6 = this.W;
        if (r6 == null) goto L66;
        r15.putString("EXTRA_JSON_STR_ACTIVITY_TRANSMISSION", com.bytedance.android.livesdk.utils.t5.b(r6));
        r15.putInt("EXTRA_ROOM_DRAW_INDEX", ((Integer) this.W.get("data_room_draw_index", -1)).intValue());
    L66:
        com.bytedance.android.livesdk.commerce.a r13 = new com.bytedance.android.livesdk.commerce.a(r14);
        r13.d(com.bytedance.android.livesdk.utils.g4.d());
        r13.e(com.bytedance.android.livesdk.utils.g4.e());
        if (((Boolean) this.W.get("IS_MERGE_WIDGET_ENTER", Boolean.FALSE)).booleanValue() == true) goto L69;
    L77:
        r13.a(com.bytedance.android.livesdk.utils.g4.c());
        r13.i(com.bytedance.android.livesdk.utils.g4.a());
        r13.g(com.bytedance.android.livesdk.utils.g4.b());
        r13.f(com.bytedance.android.livesdk.log.l0.a("IESLiveEffectAdTrackExtraServiceKey", com.bytedance.android.livesdk.log.j0.l().c(am2.n.class)));
        r13.h(com.bytedance.android.livesdk.utils.g4.g(r14.getId()));
        Bundle r7 = getArguments();
        if (r7 == null) goto L91;
        Bundle r8 = com.bytedance.android.livesdk.chatroom.m0.a(r7);
        if (r8 == null) goto L85;
        String r9 = r8.getString("live_recommend_info");
        if (TextUtils.isEmpty(r9) == true) goto L85;
        r13.a.put("live_recommend_info", r9);
    L85:
        String r11 = r7.getString("live_ads_params");
        r15.putString("live_ads_params", r11);
        if (TextUtils.isEmpty(r11) == true) goto L93;
        r15.putBoolean("auto_open_live_ad_landing_page", new JSONObject(r11).optBoolean("auto_open_windmill_page"));     // Catch: JSONException -> L89
    L89:
        e = move-exception;
        ALogger.e("NewLiveAdsSchemaHandle", e.getMessage().toString());
    L93:
        if (com.bytedance.android.livesdk.utils.c1.b(this.W) == false) goto L96;
        r13.b(com.bytedance.android.livesdk.utils.c1.e(this.W));
    L96:
        if (com.bytedance.android.livesdk.utils.c1.c(this.W) == false) goto L98;
        r13.c(com.bytedance.android.livesdk.utils.c1.f(this.W));
    L98:
        int r12 = com.bytedance.android.livesdk.utils.x1.a;
        HashMap r16 = new HashMap();
        DataCenter r17 = this.W;
        if (r17 == null) goto L119;
        r16.put("pop_type", (String) r17.get("data_enter_room_pop_type", ""));
        String r18 = (String) this.W.get("data_enter_ecom_live_params", "");     // Catch: JSONException -> L117
        if (TextUtils.isEmpty(r18) == false) goto L104;
        JSONObject r19 = new JSONObject();     // Catch: JSONException -> L117
    L105:
        long r110 = ((Long) this.W.get("data_preview_coupon_id", 0L)).longValue();     // Catch: JSONException -> L117
        if (r110 <= 0) goto L108;
        r19.put("preview_coupon_id", String.valueOf(r110));     // Catch: JSONException -> L117
    L108:
        Iterator<String> r111 = r19.keys();     // Catch: JSONException -> L117
    L110:
        if (r111.hasNext() == false) goto L112;
        String r112 = r111.next();     // Catch: JSONException -> L117
        r16.put(r112, r19.optString(r112));     // Catch: JSONException -> L117
        goto L110
    L112:
        JSONObject r20 = new JSONObject();     // Catch: JSONException -> L117
        if (getArguments() == null) goto L115;
        r20.put("live_ad_coupon_token", getArguments().getString("live_ad_coupon_token"));     // Catch: JSONException -> L117
        r20.put("live_apply_qcpx_params", getArguments().getString("live_apply_qcpx_params"));     // Catch: JSONException -> L117
        r20.put("live_ad_national_task_schema", getArguments().getString("live_ad_national_task_schema"));     // Catch: JSONException -> L117
        r20.put("qpon_token", getArguments().getString("qpon_token"));     // Catch: JSONException -> L117
        r20.put("qpon_biz_tag", getArguments().getString("qpon_biz_tag"));     // Catch: JSONException -> L117
    L115:
        r20.put("creative_id", r13.a.get("creative_id"));     // Catch: JSONException -> L117
        r20.put("request_id", r13.a.get("request_id"));     // Catch: JSONException -> L117
        r20.put("anchor_id", r13.a.get("anchor_id"));     // Catch: JSONException -> L117
        r16.put("live_ad_business_extra_params", r20.toString());     // Catch: JSONException -> L117
        goto L119
    L104:
        r19 = new JSONObject(r18);     // Catch: JSONException -> L117
    L117:
        e = move-exception;
        ALogger.e("[build_room_state]", e);
    L119:
        if (r7 == null) goto L126;
        Bundle r21 = r7.getBundle("game_promote_enter_room");
        if (r21 == null) goto L123;
        r15.putBundle("game_promote_enter_room", r21);
    L123:
        String r22 = r7.getString("live.intent.extra.LIVE_JUMP_EXTRA");
        if (r22 == null) goto L126;
        r15.putString("live.intent.extra.LIVE_JUMP_EXTRA", r22);
    L126:
        HashMap r23 = new HashMap();
        IEnterProcessorService r24 = jc1.k.f(IEnterProcessorService.class);
        if (r24 == null) goto L129;
        Boolean[] r25 = new Boolean[1];
        Room r113 = r14;
        com.bytedance.android.livesdk.commerce.a r26 = r13;
        r24.interactionBizInterceptor().processFetchRoomState(r113, r15, this.W, r16, r23, r26, r25);
        boolean r27 = Boolean.TRUE.equals(r25[0]);
    L130:
        Room r28 = r14;
        return na0(r15, r28, r26.a, r16, r23, r27);
    L129:
        r26 = r13;
        r27 = false;
        goto L130
    L91:
        r14 = r14;
        goto L93
    L69:
        if (getArguments() == null) goto L77;
        if (getArguments().getBundle("MERGE_WIDGET_ENTER_BUNDLE") == null) goto L77;
        if (getArguments().getBundle("MERGE_WIDGET_ENTER_BUNDLE").containsKey("click_method") == false) goto L77;
        String r29 = getArguments().getBundle("MERGE_WIDGET_ENTER_BUNDLE").getString("click_method");
        if (TextUtils.isEmpty(r29) == true) goto L77;
        r13.a.put("click_method", r29);
        goto L77
    L56:
        if (r3 != r14.getRoomCart().getShowCartExt()) goto L58;
        boolean r30 = true;
    L59:
        r15.putBoolean("EXTRA_BOOL_IS_TOOLBAR_EQUAL_CART", r30);
        goto L60
    L58:
        r30 = false;
        goto L59
    L44:
        if (r14.getToolbarData().getToolbarDataList() == null) goto L52;
        Iterator r31 = r14.getToolbarData().getToolbarDataList().iterator();
    L47:
        if (r31.hasNext() == false) goto L52;
        if (((IToolbarComponentData) r31.next()).getId() != 1) goto L47;
        r3 = 1;
        goto L54
    L32:
        if (r1.isWithCommercePermission() == false) goto L34;
        r2 = true;
        goto L35
    L11:
        if (r14.getBusinessLive() == 1) goto L13;
    L17:
        boolean r32 = false;
    L18:
        r15.putBoolean("EXTRA_BOOL_IS_BUSINESS_ROOM", r32);
        if (r14.getShortTouchAuth() == null) goto L21;
        boolean r33 = r14.getShortTouchAuth().hasCommerceLottery();
    L22:
        r15.putBoolean("EXTRA_BOOL_ROOM_HAS_COMMERCE_LOTTERY", r33);
        if (r14.getMRoomAuthStatus() != null) goto L25;
    L27:
        boolean r34 = false;
    L28:
        r15.putBoolean("EXTRA_BOOL_ROOM_FORBID_COMMERCE_CARD", r34);
        r15.putBoolean("auto_open_live_ad_landing_page", ((Boolean) this.W.get("auto_open_live_ad_landing_page", Boolean.FALSE)).booleanValue());
        r15.putBoolean("EXTRA_BOOL_ROOM_HAS_GROUP_PURCHASE_PERMISSION", com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.d.c(r14));
        r15.putString("data_enter_locallife_live_params", (String) this.W.get("data_enter_locallife_live_params", ""));
        r15.putString("data_enter_locallife_live_env_params", (String) this.W.get("data_enter_locallife_live_env_params", ""));
        goto L29
    L25:
        if (r14.getMRoomAuthStatus().getCommerceCard() != 2) goto L27;
        r34 = true;
        goto L28
    L21:
        r33 = false;
        goto L22
    L13:
        if (r14.getMRoomAuthStatus().getCommerceCard() != 0) goto L15;
    L16:
        r32 = true;
        goto L18
    L15:
        if (r14.getMRoomAuthStatus().getCommerceCard() != 1) goto L17;
    L5:
        if (r14.isD3Room() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final void Nb0() {
        if (this.f == null) goto L15;
        int r0 = fh1.c.a;
        DataCenter r1 = this.W;
        Room r2 = this.q;
        if (r2 == null) goto L7;
        long r4 = r2.getId();
    L9:
        if (fh1.c.a(r1, Long.valueOf(r4)) == false) goto L16;
        long r3 = System.currentTimeMillis();
        ka0(this.q);
        boolean r5 = fh1.e.a;
        ALogger.w("FirstScreen_TAG", "多人组件加载耗时::  " + (System.currentTimeMillis() - r3));
        if (this.K3 <= 0) goto L13;
        fh1.e.d(this.q.getRoomId(), (System.currentTimeMillis() - this.K3) + "");
    L13:
        com.bytedance.android.livesdk.widgetdescriptor.m r6 = new com.bytedance.android.livesdk.widgetdescriptor.m();
        LayerDescriptorList r7 = new LayerDescriptorList();
        r7.addAll(r6.e());
        r7.addAll(r6.c());
        this.f.c(mg2.e.c, r7, true);
        LayerDescriptorList r8 = new LayerDescriptorList();
        r8.addAll(r6.k());
        r8.addAll(r6.b());
        this.f.c(mg2.e.e, r8, true);
        this.e.load(new FirstScreenEndWidget(this.q.getRoomId(), this.K3, null));
        ed0("loadFSComponent");
        return;
    L16:
        return;
    L7:
        r4 = 0;
        goto L9
    }

    public void Nc0() {
        L7(HorizontalPlayEvent.class, new k1(this));
        L7(zg1.i1.class, new w1(this));
        L7(zg1.k1.class, new e2(this));
        L7(NetworkChangeEvent.class, new f2(this));
        L7(zg1.g2.class, new g2(this));
        L7(zg1.i2.class, new h2(this));
        if (UserSetting.a() == false) goto L5;
        L7(com.bytedance.android.livesdk.event.v.class, new i2(this));
    L5:
        L7(u22.j.class, new j2(this));
        L7(b30.m.class, new k2(this));
        L7(b30.e.class, new m2(this));
        L7(zg1.l0.class, new l1(this));
        L7(zg1.o0.class, new m1(this));
        L7(b30.d0.class, new n1(this));
        L7(mt1.a.class, new o1(this));
        L7(zg1.o2.class, new q1(this));
        L7(c42.a.class, new r1(this));
        Consumer r1 = new s1(this);
        ((ObservableSubscribeProxy) xs2.b.a().c(ToolbarClearScreenEvent.class).as(AutoDispose.bind(this))).subscribe(r1);
        L7(zg1.p3.class, new t1(this));
        L7(a61.a.class, new u1(this));
        if (wt2.a.g() == false) goto L8;
        Consumer r2 = new v1(this);
        ((ObservableSubscribeProxy) xs2.b.a().c(zg1.p0.class).as(AutoDispose.bind(this))).subscribe(r2);
    L9:
        L7(zg1.c0.class, new x1(this));
        L7(com.bytedance.android.livesdk.event.i.class, new y1(this));
        L7(com.bytedance.android.livesdk.event.d.class, new z1(this));
        L7(zg1.r1.class, new b2(this));
        L7(zg1.m1.class, new c2(this));
        L7(mt1.b.class, new d2(this));
        return;
    L8:
        L7(zg1.p0.class, new v1(this));
        goto L9
    }

    public final boolean Nt() {
        if (this.T != LiveMode.AUDIO) goto L5;
        return true;
    L5:
        return false;
    }

    public final jm1.a Oa0() {
        if (this.V2 != null) goto L10;
        if (pm1.f.r() != null) goto L8;
        return null;
    L8:
        p r0 = new p(this);
        this.V2 = pm1.f.r().h(this.f3, this.f, r0);
    L10:
        return this.V2;
    }

    public final void Ob0() {
        jc1.k.f(IKtvService.class).loadKtvControlWidget(this);
    }

    public final void Pb0() {
        if (this.x2 == null) goto L6;
        return;
    L6:
        if (Vb0() == true) goto L8;
        return;
    L8:
        if (this.D3.booleanValue() == false) goto L16;
        kh1.a r0 = kh1.a.a;
        if (kh1.a.d(this.q) == true) goto L14;
        this.x2 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.v3(getContext(), this.d, this.q);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3 r1 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.W);
        ToolbarButton r2 = ToolbarButton.RECORD;
        r1.k(r2, this.x2);
        if (isScreenPortrait() == true) goto L34;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.W).k(r2, this.x2);
        return;
    L34:
        return;
    L14:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.W).k(ToolbarButton.RECORD_COMBINE, new ToolbarAnchorRecordBehavior(getActivity(), this.d));
        return;
    L16:
        if (kh1.a.a.e(isScreenPortrait(), this.q) == true) goto L20;
        this.x2 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.v3(getContext(), this.d, this.q);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3 r3 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.W);
        ToolbarButton r4 = ToolbarButton.RECORD;
        r3.k(r4, this.x2);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.i(this.W).k(ToolbarButton.RECORD_LANDSCAPE, this.x2);
        if (isScreenPortrait() == true) goto L37;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.W).k(r4, this.x2);
        return;
    L37:
        return;
    L20:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3 r5 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.W);
        ToolbarButton r6 = ToolbarButton.RECORD_COMBINE;
        FragmentActivity r7 = getActivity();
        boolean r8 = g1();
        com.bytedance.android.live.pushstream.d r9 = this.d;
        if (r9 != null) goto L23;
        boolean r10 = true;
    L24:
        r5.k(r6, new ToolbarAudienceRecordBehavior(r7, r8, r9, r10));
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r11 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.i(this.W);
        FragmentActivity r12 = getActivity();
        boolean r13 = g1();
        com.bytedance.android.live.pushstream.d r14 = this.d;
        if (r14 != null) goto L27;
        boolean r15 = true;
    L28:
        r11.k(r6, new ToolbarAudienceRecordBehavior(r12, r13, r14, r15));
        HashMap r16 = new HashMap();
        Room r17 = this.q;
        if (r17 == null) goto L31;
        int r18 = com.bytedance.android.live.core.utils.h1.a;
        r16.put("live_type", com.bytedance.android.live.core.utils.i1.a(r17.getStreamType()));
    L31:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_audience_live_record_get", r16, new Object[]{Room.class, am2.x.class});
        return;
    L27:
        r15 = false;
        goto L28
    L23:
        r10 = false;
        goto L24
    }

    public final m00.f Qa0() {
        if (this.V1 != null) goto L11;
        if (NewBroadcastSharedConfig.a().booleanValue() == false) goto L9;
        com.bytedance.android.scope.m r0 = com.bytedance.android.scope.m.e;
        f00.a.a r1 = f00.a.b;
        if (r0.d(r1, g00.c.class) == null) goto L11;
        this.V1 = ((g00.c) r0.d(r1, g00.c.class)).a(this, this.q);
        goto L11
    L9:
        this.V1 = ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).createCoverController(this, this.q);
    L11:
        return this.V1;
    }

    public final void R5() {
        Disposable r0 = this.b4;
        if (r0 != null) goto L5;
    L7:
        LiveVisibilityControlContext.Companion.getClass();
        if (LiveVisibilityControlContext.a.a() == false) goto L12;
        com.bytedance.android.livesdk.chatroom.utils.h1.a r1 = com.bytedance.android.livesdk.chatroom.utils.h1.b;
        DataCenter r2 = this.W;
        r1.getClass();
        IVisibilityControlService r3 = com.bytedance.android.livesdk.chatroom.utils.h1.a.g(r2);
        if (r3 == null) goto L18;
        r3.stopVisibilityTimer();
        return;
    L18:
        return;
    L12:
        RoomContext r4 = this.X;
        if (r4 != null) goto L15;
        return;
    L15:
        if (r4.getCastScreenEntryDismissTimer() == null) goto L21;
        ((ig1.b) this.X.getCastScreenEntryDismissTimer().getValue()).release();
        return;
    L21:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.b4.dispose();
        goto L7
    }

    public void Rb0() {
        R40(this.p1);
    }

    public final boolean S8() {
        RoomContext r0 = this.X;
        if (r0 != null) goto L7;
        com.bytedance.android.live.core.tetris.widgets.d.g("data context is null");
        return false;
    L7:
        if (r0.isCleared() == false) goto L11;
        com.bytedance.android.live.core.tetris.widgets.d.g("data context cleared");
        return false;
    L11:
        if (this.E3 == true) goto L14;
        com.bytedance.android.live.core.tetris.widgets.d.g("room context has not init");
        return false;
    L14:
        return true;
    }

    public final ViewLayerDelegate<com.bytedance.android.livesdk.widgetdescriptor.e0> Ta0() {
        if (this.o3 != null) goto L8;
        mg2.d r0 = this.f;
        if (r0 == null) goto L8;
        this.o3 = r0.o4(mg2.e.e, LayerIndex.INDEX_5);
    L8:
        return this.o3;
    }

    public final void Tb0() {
        Room r0 = this.q;
        if (r0 != null) goto L5;
    L7:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.e5 r1 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.e5(getContext(), getActivity(), this.Q1, this.X, this.W);
        this.J2 = r1;
        r1.p = this.P1;
        SettingKey<Boolean> r2 = h21.a;
        if (((Boolean) r2.getValue()).booleanValue() == false) goto L14;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L12;
        Lazy r3 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(this.W, NewToolbarButtonConstants.ToolbarShare.INSTANCE, new s(this));
        goto L14
    L12:
        xa0();
    L14:
        if (nb0() == false) goto L28;
        if (tb1.c.a == false) goto L20;
        if (isScreenPortrait() == false) goto L28;
    L20:
        if (((Boolean) r2.getValue()).booleanValue() == true) goto L22;
    L23:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.b(this.W).k(ToolbarButton.SHARE, this.J2);
    L24:
        DataCenter r4 = this.W;
        Boolean r5 = Boolean.FALSE;
        if (((Boolean) r4.get("data_pending_show_share_dialog", r5)).booleanValue() == false) goto L28;
        this.J2.onClick(null);
        this.W.put("data_pending_show_share_dialog", r5);
        goto L28
    L22:
        if (this.D3.booleanValue() == false) goto L24;
    L28:
        if (com.bytedance.android.livesdk.utils.j.c() == false) goto L33;
        kh1.a r6 = kh1.a.a;
        if (kh1.a.d(this.q) == true) goto L34;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.W).k(ToolbarButton.ANCHOR_BACKTRACK, new ToolbarAnchorBacktrackBehavior());
        return;
    L34:
        return;
    L33:
        return;
    L5:
        if (VrUtils.p(r0) == false) goto L7;
        RoomAuthStatus.Style r7 = new RoomAuthStatus.Style();
        r7.setUnableStyle(0);
        DataCenter r8 = this.W;
        int r9 = lk1.b.a;
        lk1.c.i2.getClass();
        lk1.c.a.a(r8).updateComponentRule("room_auth_cast_screen", new g6(VrUtils.k(this.W, this.q), r7));
        goto L7
    }

    public com.bytedance.android.live.core.tetris.layer.view.a Va0() {
        com.bytedance.android.live.core.tetris.layer.view.a r0 = this.g3;
        if (r0 == null) goto L5;
        return r0;
    L5:
        this.g3 = Wb0();
        if (pm1.f.o() == null) goto L11;
        pm1.f.o().a();
        if (MultiTabManagerImpl.e.i(this.W) == false) goto L11;
        com.bytedance.android.live.core.tetris.layer.view.a r1 = this.g3;
        com.bytedance.android.livesdk.vscore_impl.component.tabs.s r2 = com.bytedance.android.livesdk.vscore_impl.component.tabs.t.b.a(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(ru2.a.class, "pendingClass");
        Intrinsics.checkNotNullParameter(r2, "handler");
        r1.h.put(ru2.a.class, r2);
    L11:
        return this.g3;
    }

    public final com.bytedance.android.live.core.tetris.layer.view.a Wb0() {
        HashSet r0 = new HashSet();
        r0.add(this.i3);
        r0.add(this.j3);
        r0.add(this.k3);
        ElementBuilderMap r1 = new ElementBuilderMap();
        r1.put(j70.o.class, new com.bytedance.android.live.core.tetris.layer.core.element.widget.a(this.e));
        if (this.f3 != null) goto L12;
        Context r4 = getContext();
        DataCenter r5 = this.W;
        com.bytedance.android.livesdk.room.b r6 = this.h;
        if (r6 == null) goto L7;
        AbilityCenter r7 = ((ls2.c) r6).b;
    L8:
        if (r7 != null) goto L10;
        r7 = new AbilityCenter();
    L10:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r2 = new com.bytedance.android.livesdk.widgetdescriptor.e0(r4, r5, r7);
        this.f3 = r2;
        ((d90.d) r2).e = this.X;
        ((d90.d) r2).g = jc1.k.f(IRoomContextService.class);
        this.f3.k = this.Y;
        goto L12
    L7:
        r7 = null;
    L12:
        if (this.b3 == null) goto L14;
    L27:
        com.bytedance.android.live.core.tetris.layer.view.a r3 = new com.bytedance.android.live.core.tetris.layer.view.a();
        com.bytedance.android.livesdk.widgetdescriptor.e0 r8 = this.f3;
        Intrinsics.checkNotNullParameter(r8, "layerContext");
        r3.c = r8;
        InteractionDelegateConfig r9 = new InteractionDelegateConfig();
        Intrinsics.checkNotNullParameter(r9, "config");
        r3.a = r9;
        LayerEventDispatcher r10 = o70.c.a(Integer.valueOf(this.W.hashCode()));
        Intrinsics.checkNotNullParameter(r10, "layerEventDispatcher");
        r3.d = r10;
        Intrinsics.checkNotNullParameter(r0, "chains");
        r3.l.a = r0;
        ViewModelProvider r11 = ViewModelProviders.of(this);
        Intrinsics.checkNotNullParameter(r11, "viewModelProvider");
        r3.j = r11;
        Intrinsics.checkNotNullParameter(r1, "map");
        r3.b = r1;
        r3.i = r3.i;
        com.bytedance.android.livesdk.chatroom.tetris.filter.a r12 = new com.bytedance.android.livesdk.chatroom.tetris.filter.a();
        Intrinsics.checkNotNullParameter(r12, "blockElementFilter");
        r3.f = r12;
        RoomModeElementFilter r13 = new RoomModeElementFilter(this.W, this.f3);
        Intrinsics.checkNotNullParameter(r13, "roomModeElementFilter");
        r3.g = r13;
        return r3;
    L14:
        if (RoomContext.getShared(this.W) == null) goto L27;
        if (RoomContext.getShared(this.W).getTemplateContext() == null) goto L27;
        if (com.bytedance.android.livesdk.widgetdescriptor.template.utils.a.b(this.q) == false) goto L26;
        this.b3 = new LiveTemplateContext(this.W, this.q, this.f3);
        RoomContext.getShared(this.W).getTemplateContext().setValue(this.b3);
        com.bytedance.android.livesdk.widgetdescriptor.e0 r14 = this.f3;
        if (r14 == null) goto L23;
        ((h70.b) r14).a = this.b3;
    L23:
        if (this.I2 != null) goto L25;
        TemplateDelegateHolder r15 = new TemplateDelegateHolder();
        this.I2 = r15;
        r15.b = ViewModelProviders.of(this);
        this.I2.a = this.f3;
    L25:
        z70.c.a("use template and init template context success");
        goto L27
    L26:
        RoomContext.getShared(this.W).getTemplateContext().setValue(null);
        goto L27
    }

    public final void ad0() {
        this.X.getFragmentInfoGetter().setValue(new a(this));
        if (pm1.f.o() == null) goto L7;
        pm1.f.o().a();
        if (MultiTabManagerImpl.e.i(this.W) == false) goto L7;
        this.X.getLayerConfigGetter().setValue(new b(this));
        this.X.getInteractionFragmentDoubleTap().setValue(new c(this));
        this.X.getInteractionFragmentSwipeListener().setValue(new d(this));
    L7:
        this.X.getWidgetManager().setValue(this.e);
    }

    public final Observable<Unit> fd0() {
        LiveVisibilityControlContext.Companion.getClass();
        if (LiveVisibilityControlContext.a.a() == false) goto L10;
        ALogger.d("timerTag", "AbsInteractionFragment.java # startTimer # get common timer");
        com.bytedance.android.livesdk.chatroom.utils.h1.a r0 = com.bytedance.android.livesdk.chatroom.utils.h1.b;
        DataCenter r1 = this.W;
        r0.getClass();
        IVisibilityControlService r2 = com.bytedance.android.livesdk.chatroom.utils.h1.a.g(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.startVisibilityTimer();
    L10:
        ALogger.d("timerTag", "AbsInteractionFragment.java # startTimer # get dataContext timer");
        return ((ig1.b) this.X.getCastScreenEntryDismissTimer().getValue()).a();
    }

    public final Map<String, Object> getPropertyParams() {
        HashMap r0 = new HashMap();
        Room r1 = this.q;
        if (r1 == null) goto L5;
        r0.put("room_id", Long.valueOf(r1.getId()));
    L5:
        Boolean r2 = this.D3;
        if (r2 == null) goto L8;
        r0.put("is_Anchor", r2.toString());
    L8:
        return r0;
    }

    public final void jd0() {
        if (ur0.a.getValue().booleanValue() == false) goto L25;
        Room r0 = this.q;
        if (r0 != null) goto L7;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == true) goto L26;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a r1 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.f;
        Room r3 = this.q;
        r1.getClass();
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a.g(r3) == false) goto L22;
        return;
    L22:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a.e(this.q) == true) goto L28;
        ALogger.d("NewToolbarLog", "try mock mock share in more");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a.a(this.q);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.W).k(ToolbarButton.SHARE, this.J2);
        return;
    L28:
        return;
    L26:
        return;
    L7:
        if (r0.getOwner() == null) goto L17;
        r2 = true;
        if (r0.getOwner().getSecret() == 1) goto L18;
        if (r0.getRoomAuthStatus() == null) goto L17;
        if (r0.getRoomAuthStatus().getShowShare() != 2) goto L17;
    }

    public final SimpleLiveRoomViewHandler mb0() {
        SimpleLiveRoomViewHandler r0 = this.k;
        if (r0 != null) goto L13;
        SimpleLiveRoomViewHandler r1 = new SimpleLiveRoomViewHandler(Ca0(), (IShortTermIconFramework) this.X.getShortTermIconFramework().getValue(), this.W);
        this.k = r1;
        if (r1.d != null) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L12;
        Widget r3 = this.y1;
        if (r3 == null) goto L12;
        r1.d = r3;
    L12:
        this.X.getLiveRoomViewHandler().setValue(this.k);
    L24:
        return this.k;
    L7:
        r2 = false;
        goto L8
    L13:
        Map r4 = r0.e;
        InteractionContext r5 = this.Y;
        if (r5 == null) goto L24;
        Map r6 = (Map) r5.getRoomPlaceHolders().getValue();
        if (r6 == null) goto L24;
        Iterator r7 = r6.keySet().iterator();
    L19:
        if (r7.hasNext() == false) goto L24;
        ILayoutConstraint r8 = (ILayoutConstraint) r7.next();
        if (r4.containsKey(r8) == true) goto L19;
        r4.put(r8, (com.bytedance.android.livesdk.room.placeholder.widget.d) r6.get(r8));
        goto L19
    }

    public final boolean nb0() {
        Room r0 = this.q;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.getMRoomAuthStatus() == null) goto L8;
        return !this.q.getMRoomAuthStatus().isDisableShare();
    }

    public final boolean oa0() {
        if (((Integer) this.W.get("data_screen_orientation", 1)).intValue() == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.X == null) goto L7;
        return true;
    }

    public final void om() {
        Dialog r0 = this.y3;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L28;
        Dialog r1 = this.y3;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r1);
    L21:
        this.y3 = null;
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r3 == null) goto L20;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L9:
        if (Looper.myLooper() == r2.getLooper()) goto L11;
        r2.post(DialogLancet.createDismissRunnable(r1));
        goto L21
    }

    public void onDestroy() {
        SimpleLiveRoomViewHandler r0 = this.k;
        if (r0 == null) goto L8;
        Disposable r2 = r0.a;
        if (r2 == null) goto L7;
        r2.dispose();
    L7:
        r0.d = null;
    L8:
        com.bytedance.android.live.core.tetris.widgets.d.g("onDestroy#" + hashCode());
        boolean r1 = com.bytedance.android.livesdk.floatview.p.a;
        this.E3 = false;
        gd0();
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.a() == false) goto L16;
        rv2.a r3 = this.u3;
        if (r3 == null) goto L13;
        r3.onDestroy();
    L13:
        com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.d r4 = this.v3;
        if (r4 == null) goto L16;
        r4.a.onDestroy();
    L16:
        LivePopupWindowManager r5 = this.K2;
        if (r5 == null) goto L19;
        r5.c();
    L19:
        jm1.a r6 = this.V2;
        if (r6 == null) goto L22;
        r6.onDestroy();
    L22:
        Aa0(new f1());
        WidgetService.getInstance().creatorMap.clear();
        ILifeCycleAware r7 = jc1.k.f(ILifeCycleAware.class);
        if (r7 == null) goto L31;
        Room r8 = this.q;
        if (r8 != null) goto L27;
    L29:
        String r9 = "unknown";
    L30:
        r7.onInteractionFragmentDestroy(r9);
        goto L31
    L27:
        if (r8.getIdStr() == null) goto L29;
        r9 = this.q.getIdStr();
    L31:
        Disposable r10 = this.o4;
        if (r10 == null) goto L34;
        r10.dispose();
    L34:
        this.o4 = null;
        Disposable r11 = this.g4;
        if (r11 == null) goto L37;
        r11.dispose();
        this.g4 = null;
    L37:
        Disposable r12 = this.h4;
        if (r12 == null) goto L40;
        r12.dispose();
        this.h4 = null;
    L40:
        Disposable r13 = this.i4;
        if (r13 == null) goto L43;
        r13.dispose();
        this.i4 = null;
    L43:
        this.n4 = null;
        com.bytedance.android.livesdk.chatroom.presenter.l r14 = this.O;
        if (r14 == null) goto L51;
        vlc.d r15 = r14.b;
        if (r15 == null) goto L50;
        r15.removeMessageListener(r14);
        com.bytedance.android.livesdk.utils.b4 r16 = r14.c;
        if (r16 == null) goto L50;
        r14.b.removeMessageListener(r16);
    L50:
        r14.a = null;
    L51:
        this.U2 = null;
        GameAbsInteractionDelegate r17 = this.p2;
        if (r17 == null) goto L54;
        r17.c();
        this.p2 = null;
    L54:
        LiveProfileSettingDialog r18 = this.b1;
        if (r18 != null) goto L57;
    L65:
        id0(false);
        com.bytedance.android.livesdk.chatroom.presenter.g r19 = this.N;
        if (r19 == null) goto L71;
        vlc.d r20 = r19.c;
        if (r20 == null) goto L70;
        r20.removeMessageListener(r19);
    L70:
        r19.a = null;
    L71:
        com.bytedance.android.livesdk.chatroom.presenter.m r21 = this.P;
        if (r21 == null) goto L74;
        r21.detachView();
    L74:
        this.M.removeCallbacksAndMessages(null);
        ((ArrayList) this.P3).clear();
        ((ArrayList) this.Q3).clear();
        ((ArrayList) this.H3).clear();
        this.I3 = null;
        DataCenter r22 = this.W;
        if (r22 == null) goto L83;
        IAnchorBacktrackService r23 = (IAnchorBacktrackService) r22.get("data_backtrack_service", null);
        if (r23 == null) goto L79;
        r23.release();
        this.W.put("data_backtrack_service", null);
    L79:
        com.bytedance.android.livesdk.chatroom.utils.h1.a r24 = com.bytedance.android.livesdk.chatroom.utils.h1.b;
        DataCenter r25 = this.W;
        r24.getClass();
        IVisibilityControlService r26 = com.bytedance.android.livesdk.chatroom.utils.h1.a.g(r25);
        if (r26 == null) goto L83;
        r26.onUnload();
    L83:
        if (pX() == true) goto L85;
    L87:
        RxBusAbility.INSTANCE.getRxBus(this.W).post(new zg1.z2(true));
        com.bytedance.android.livesdk.utils.t3.c(false, "AbsInteractionFragment_onDestroy");
        if (this.k0 == null) goto L90;
        ALogger.i("AbsInteractionFragment", "DisposeRoomContext this=" + hashCode() + " context=" + ((InteractionWidgetsPosContext) this.k0.getFirst()).hashCode());
        ((Disposable) this.k0.getSecond()).dispose();
        this.k0 = null;
    L90:
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        if (pm1.f.o() == null) goto L93;
        pm1.f.o().a();
        Map r27 = MultiTabManagerImpl.a;
        com.bytedance.android.livesdk.vscore_impl.component.tabs.t.b.b(this);
    L93:
        PublicScreenStyleHelper.n = false;
        PublicScreenStyleHelper.k = 0;
        com.bytedance.android.livesdk.chatroom.utils.i r28 = this.e3;
        if (r28 == null) goto L96;
        r28.b();
        this.e3 = null;
    L96:
        ((ArrayList) this.l3).clear();
        com.bytedance.android.live.core.tetris.widgets.d.g("onDestroy end");
        return;
    L85:
        if (wt2.a.e(this.D3) == true) goto L87;
        com.bytedance.android.livesdk.chatroom.utils.p.b.getClass();
        com.bytedance.android.livesdk.chatroom.utils.p.a.a("exit_room");
        goto L87
    L57:
        if (r18.isShowing() == false) goto L65;
        this.b1.dismiss();     // Catch: Exception -> L61
    L61:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r29 = DialogFragmentLancet.sLastShowStack;
        if (r29 == null) goto L65;
        com.bytedance.crash.d.d(r29, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L65
    }

    public void onDestroyView() {
        com.bytedance.android.live.core.tetris.widgets.d.g("onDestroyView#" + hashCode());
        PlatformMessageHelper.INSTANCE.stop();
        this.L.clear();
        Object r0 = Ua0().a;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.widget.landscape.r r1 = (com.bytedance.android.livesdk.chatroom.widget.landscape.r) r0;
        com.bytedance.android.livesdk.chatroom.widget.landscape.r.a();
    L5:
        Disposable r2 = this.p;
        if (r2 != null) goto L8;
    L10:
        DataCenter r3 = this.W;
        if (r3 == null) goto L14;
        r3.put("cmd_all_widget_loaded", Boolean.FALSE);
        this.W.removeObserver(this);
    L14:
        if (jc1.k.f(ILinkServiceExternal.class).getPkServiceExternal() == null) goto L16;
        jc1.k.f(ILinkServiceExternal.class).getPkServiceExternal().c(this.x3);
    L16:
        this.u = false;
        ga0.a r4 = this.A3;
        if (r4 == null) goto L19;
        r4.detachView();
    L19:
        this.M.removeMessages(100);
        Aa0(new l0());
        super.onDestroyView();
        this.R3 = null;
        GestureDetectLayout r5 = this.I;
        if (r5 == null) goto L22;
        r5.setSlideAction(null);
    L22:
        com.bytedance.android.live.core.tetris.widgets.d.g("onDestroyView end");
        R5();
        this.q4 = false;
        return;
    L8:
        if (r2.isDisposed() == true) goto L10;
        this.p.dispose();
        goto L10
    }

    public final boolean pX() {
        DataCenter r0 = this.W;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) r0.get("DATA_IS_HIDE_INTERACTION", Boolean.FALSE)).booleanValue() == false) goto L7;
        return true;
    }

    public final boolean pa0() {
        com.bytedance.android.livesdk.chatroom.utils.h1.a r0 = com.bytedance.android.livesdk.chatroom.utils.h1.b;
        DataCenter r1 = this.W;
        r0.getClass();
        LiveVisibilityControlContext r2 = com.bytedance.android.livesdk.chatroom.utils.h1.a.f(r1);
        if (r2 != null) goto L5;
    L29:
        return false;
    L5:
        if (r2.enablePlayBackAbility() == false) goto L29;
        DataCenter r3 = this.W;
        if (r3 != null) goto L10;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L29;
        if (PadConfigUtils.a() == false) goto L21;
    L24:
        boolean r5 = true;
    L25:
        if (r5 == true) goto L29;
        if (com.bytedance.android.livesdk.chatroom.utils.h1.a.a() == false) goto L29;
        return true;
    L21:
        if (FoldScreenUtils.e() == true) goto L24;
        r5 = false;
        goto L25
    L10:
        if (com.bytedance.android.livesdk.chatroom.utils.h1.a.c() == false) goto L16;
        if (com.bytedance.android.live.core.utils.z.m(r3, true) == false) goto L16;
        if (com.bytedance.android.live.core.utils.z.e(r3, false) == true) goto L16;
        r4 = true;
        goto L17
    }

    public final boolean pb0() {
        if (tb1.c.a == true) goto L5;
    L11:
        return false;
    L5:
        if (cy.a.getValue().a() != 1) goto L7;
        return true;
    L7:
        if (ey.a.getValue().a() != 1) goto L9;
        return true;
    L9:
        if (fy.a.getValue().a() != 1) goto L11;
        return true;
    }

    public final boolean qa0() {
        if (this.f3 == null) goto L10;
        LiveTemplateContext r0 = this.b3;
        if (r0 == null) goto L10;
        if (r0.e() == false) goto L10;
        LiveTemplateContext r1 = this.b3;
        ((d90.d) this.f3).f.getClass();
        return !r1.d(d90.d.a.L2);
    L10:
        return true;
    }

    public final void sa0() {
        boolean r0 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.W).isPaidLive();
        boolean r1 = Ga0();
        boolean r2 = VrUtils.c(this.W);
        if (r1 == true) goto L6;
        if (r0 == true) goto L6;
        return;
    L6:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.W).n(ToolbarButton.CAST_SCREEN) == true) goto L18;
        if (r2 == true) goto L19;
        int r3 = com.bytedance.android.livesdk.castscreen.api.b.a;
        Intrinsics.checkNotNullParameter(this.q, "room");
        String r4 = LiveByteCastUIManager.a;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r5 = null;
        if (LiveByteCastUIManager.r() == false) goto L14;
        if (LiveByteCastManager.a() == false) goto L14;
        r5 = new com.bytedance.android.livesdk.castscreen.views.bytecast.k(null);
    L14:
        if ((r5 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) == false) goto L20;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.W).k(ToolbarButton.CAST_SCREEN, r5);
        return;
    L20:
        return;
    L19:
        return;
    }

    public final boolean sb0() {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 != null) goto L6;
        return false;
    L6:
        if (jc1.k.f(IUserService.class) != null) goto L8;
    L10:
        User r2 = null;
    L11:
        if (r2 != null) goto L14;
        return false;
    L14:
        if (r0.getVideoTalkService() == null) goto L16;
        boolean r3 = r0.getVideoTalkService().C(this.D3.booleanValue(), r2.getIdString());
    L18:
        if (r0.getAudioTalkService() == null) goto L20;
        boolean r4 = r0.getAudioTalkService().q(this.D3.booleanValue(), r2.getIdString());
    L22:
        if (r0.getInteractAudienceService() == null) goto L24;
        com.bytedance.android.live.liveinteract.service.f r5 = r0.getInteractAudienceService();
        com.bytedance.android.live.liveinteract.service.f r6 = r5;
        boolean r7 = r6.S(this.D3.booleanValue(), r2);
    L25:
        iy.g r1 = r0.getDynamicCenterService(this.W);
        if (r1 == null) goto L28;
        boolean r8 = r1.Rp();
    L29:
        if (r3 == true) goto L33;
        if (r4 == true) goto L33;
        if (r7 == true) goto L33;
        if (r8 == true) goto L33;
        return false;
    L33:
        return true;
    L28:
        r8 = false;
        goto L29
    L24:
        r7 = false;
        goto L25
    L20:
        r4 = false;
        goto L22
    L16:
        r3 = false;
        goto L18
    L8:
        if (jc1.k.f(IUserService.class).user() == null) goto L10;
        r2 = jc1.k.f(IUserService.class).user().b();
        goto L11
    }

    public void stopInteractionLoad() {
        rv2.a r0 = this.u3;
        if (r0 == null) goto L5;
        r0.onDestroy();
    L5:
        com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.d r1 = this.v3;
        if (r1 == null) goto L9;
        r1.a.onDestroy();
        return;
    }

    public final void ua0() {
        Aa0(new m3(this));
        Aa0(new n3(this));
        if (this.m == true) goto L6;
        Aa0(new o3(this));
        this.m = true;
    L6:
        if (this.o == false) goto L8;
    L18:
        Aa0(new q3(this));
        return;
    L8:
        if (this.q != null) goto L10;
        this.q = (Room) this.W.get("data_room");
    L10:
        Room r0 = this.q;
        final IRoomEventHub r2 = null;
        if (r0 == null) goto L13;
        ILivePlayerClient r1 = LivePlatformPlayerManager.a(r0.getId(), false);
    L14:
        if (r1 == null) goto L16;
        r2 = r1.getEventHub();
    L16:
        if (r2 == null) goto L18;
        Aa0(new p3(r2));
        this.o = true;
        goto L18
    L13:
        r1 = null;
        goto L14
    }

    public final boolean vb0() {
        if (this.v2 == true) goto L5;
        return false;
    L5:
        if (this.D3.booleanValue() == true) goto L18;
        int r0 = com.bytedance.android.livesdk.utils.t1.a;
        if (com.bytedance.android.livesdk.utils.t1.a(this.q) == true) goto L9;
        return false;
    L9:
        if (yb0() == true) goto L20;
        RoomContext r1 = this.X;
        if (r1 != null) goto L13;
        boolean r2 = false;
    L14:
        if (r2 == true) goto L21;
        return true;
    L21:
        return false;
    L13:
        r2 = r1.isMediaRoom();
        goto L14
    L20:
        return false;
    L18:
        return false;
    }

    public final boolean xa() {
        ViewLayerDelegate<com.bytedance.android.livesdk.widgetdescriptor.e0> r0 = this.E2;
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.widgetdescriptor.e0 r1 = this.f3;
        if (r1 == null) goto L11;
        ((d90.d) r1).f.getClass();
        com.bytedance.android.livesdk.chatroom.tetris.portrait.v r2 = (com.bytedance.android.livesdk.chatroom.tetris.portrait.v) r0.g(d90.d.a.p0, com.bytedance.android.livesdk.chatroom.tetris.portrait.v.class);
        if (r2 == null) goto L11;
        return r2.m();
    L11:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L15;
        ALogger.e("AbsInteractionFragment", "mPortrait2ndDelegate not init!");
        return false;
    L15:
        return false;
    }

    public final void xa0() {
        if (((Boolean) h21.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        Boolean r0 = this.D3;
        if (r0 != null) goto L8;
    L10:
        ALogger.d("NewToolbarLog", "compactLoadShareEnterRoom");
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L14;
        return;
    L14:
        if (nb0() == true) goto L16;
        return;
    L16:
        if (tb1.c.a == true) goto L18;
    L19:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a r1 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.f;
        Room r2 = this.q;
        r1.getClass();
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a.g(r2) == false) goto L23;
        ALogger.d("NewToolbarLog", "enter load share in toolbar");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.W).k(ToolbarButton.SHARE, this.J2);
        return;
    L23:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a.e(this.q) == false) goto L25;
        ALogger.d("NewToolbarLog", "enter load share in more");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.W).k(ToolbarButton.SHARE, this.J2);
        return;
    L25:
        Room r3 = this.q;
        if (r3 != null) goto L28;
    L29:
        ALogger.d("NewToolbarLog", "enter room with null toolbar data");
        return;
    L28:
        if (r3.getToolbarData() == null) goto L29;
        return;
    L18:
        if (isScreenPortrait() == true) goto L19;
        return;
    L8:
        if (r0.booleanValue() != true) goto L10;
    }

    public final void ya0() {
        boolean r1 = true;
        if (this.Q == null) goto L13;
        b41 r0 = c41.a;
        if (r0.b() == false) goto L13;
        Field r2 = this.Q.getClass().getDeclaredField("mMinimumFlingVelocity");     // Catch: Throwable -> L9
        r2.setAccessible(true);     // Catch: Throwable -> L9
        GestureDetector r3 = this.Q;     // Catch: Throwable -> L9
        if (r0.b() == false) goto L10;
        int r4 = r0.e();     // Catch: Throwable -> L9
    L11:
        r2.setInt(r3, r4);     // Catch: Throwable -> L9
        goto L13
    L10:
        r4 = 150;
    L13:
        if (this.Q == null) goto L18;
        if (qy.a.getValue().b() == false) goto L18;
        this.k4 = new ko1.d(this.Q);
    L18:
        if (g1() == true) goto L20;
        return;
    L20:
        if (ClearScreenHelper.d(this.W) == false) goto L43;
        Boolean r5 = this.D3;
        if (r5 == null) goto L27;
        if (r5.booleanValue() == false) goto L27;
        return;
    L27:
        if (this.d4 != null) goto L30;
        View r6 = this.F3;
        Context r7 = getContext();
        DataCenter r8 = this.W;
        int r9 = com.bytedance.android.livesdk.clearscreen.gesture.b.t;
        Intrinsics.checkNotNullParameter(r6, "rootView");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        final com.bytedance.android.livesdk.clearscreen.gesture.b r10 = new com.bytedance.android.livesdk.clearscreen.gesture.b(r6, r7);
        int r11 = gh1.a.c;
        gh1.a.a.a(r8, r10);
        this.d4 = r10;
        this.g4 = Disposables.fromAction(new n2(this, r10));
    L30:
        if (this.e4 == null) goto L32;
        return;
    L32:
        if (ClearScreenHelper.l(this.W) == true) goto L34;
    L36:
        r1 = false;
    L37:
        if (r1 == false) goto L45;
        View r12 = this.F3;
        Context r13 = getContext();
        DataCenter r14 = this.W;
        int r15 = ClickPS2ClearScreenGestureBehavior.q;
        Intrinsics.checkNotNullParameter(r12, "rootView");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "dataCenter");
        final ClickPS2ClearScreenGestureBehavior r16 = new ClickPS2ClearScreenGestureBehavior(r12, r13, r14);
        int r17 = gh1.a.c;
        gh1.a.a.a(r14, r16);
        this.e4 = r16;
        r16.b = new o2(this);
        this.h4 = Disposables.fromAction(new p2(this, r16));
        return;
    L45:
        return;
    L34:
        if (ClearScreenHelper.j().j() == false) goto L36;
    }

    public final boolean yb0() {
        RoomContext r0 = this.X;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isVSRoom();
    }

    public void za0() {
        Runnable r0 = this.R3;
        if (r0 == null) goto L5;
        this.J.post(r0);
        this.R3 = null;
    L5:
        Fc0();
        a71 r1 = this.h3;
        boolean r2 = false;
        if (r1 != null) goto L8;
    L80:
        Room r3 = this.q;
        DataCenter r4 = this.W;
        if (r4 != null) goto L83;
    L85:
        if (r2 == false) goto L88;
        if (r3 == null) goto L88;
        com.bytedance.android.livesdk.log.d.b(this.W, "detail_ad", "show", r3.getAnchorId(), String.valueOf(r3.getId()));
    L88:
        ed0("continueAfterWidgetLoaded");
        if (this.q.getOwner() == null) goto L94;
        if (this.H == true) goto L94;
        this.H = true;
    L94:
        if (this.Q2 == true) goto L97;
        this.Q = new GestureDetector(getContext(), this.j4);
        ya0();
        this.c4 = new com.bytedance.android.livesdk.chatroom.record.i(getContext(), this.W);
        this.I.b(this.m4);
        this.Q2 = true;
    L97:
        if (this.R2 == true) goto L99;
        com.bytedance.android.livesdk.chatroom.presenter.g r5 = new com.bytedance.android.livesdk.chatroom.presenter.g(this.W);
        this.N = r5;
        r5.a(this);
        this.R2 = true;
    L99:
        Vc0();
        Mc0();
        if (this.O != null) goto L103;
        com.bytedance.android.livesdk.chatroom.presenter.l r6 = new com.bytedance.android.livesdk.chatroom.presenter.l();
        this.O = r6;
        this.X.getMessageManager().c(new com.bytedance.android.livesdk.chatroom.presenter.k(r6, this));
    L103:
        if (UserSetting.a() == false) goto L105;
        com.bytedance.android.livesdk.chatroom.presenter.m r7 = new com.bytedance.android.livesdk.chatroom.presenter.m(this.W);
        this.P = r7;
        r7.a0(this);
    L105:
        ga0.a r8 = jc1.k.f(IGiftServiceExternal.class).getGiftGuidePresenter(this.W);
        this.A3 = r8;
        r8.a0(this);
        PlatformMessageHelper.INSTANCE.start(this);
        if (this.v2 == false) goto L110;
        GameAbsInteractionDelegate r9 = this.p2;
        if (r9 == null) goto L110;
        r9.a();
    L110:
        Room r10 = this.q;
        if (r10 == null) goto L119;
        if (r10.getOwner() == null) goto L119;
        if (this.H == true) goto L119;
        this.H = true;
    L119:
        if (UserSetting.a() == true) goto L121;
    L123:
        DataCenter r11 = this.W;
        int r12 = com.bytedance.android.livesdk.chatroom.paidlive.b.b;
        if (r11 == null) goto L131;
        com.bytedance.android.live.profit.lottery.i r13 = yt0.c.f();
        if (r13 == null) goto L131;
        com.bytedance.android.live.profit.lottery.o r14 = r13.getLotteryPluginStore();
        if (r14 == null) goto L131;
        r14.a(new com.bytedance.android.livesdk.chatroom.paidlive.b(r11));
    L131:
        TimeCostUtil.Tag r15 = TimeCostUtil.Tag.ShowBInteractionFirstWidget;
        int r16 = TimeCostUtil.a;
        com.bytedance.android.live.core.performance.a r17 = com.bytedance.android.live.core.performance.a.a;
        r15.name();
        r17.getClass();
        TimeCostUtil.Tag.ShowCInteractionFirstWidget.name();
        Tc0(((long) ((Integer) n61.b.getValue()).intValue()) * 1000);
        ua0();
        Aa0(new k3());
        if (RoomContext.getShared() == null) goto L134;
        RoomContext.getShared().getEnableToolbarLog().setValue(Boolean.TRUE);
    L134:
        IEnterProcessorService r18 = jc1.k.f(IEnterProcessorService.class);
        if (r18 == null) goto L137;
        r18.interactionBizInterceptor().processContinueAfterWidgetLoaded();
    L137:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3 r19 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.W);
        if (isScreenPortrait() == false) goto L172;
        int r20 = com.bytedance.android.livesdk.utils.r6.a;
        if (com.bytedance.android.livesdk.utils.r6.a.a() == false) goto L145;
        ToolbarButton r21 = ToolbarButton.FAST_GIFT;
        if (r19.n(r21) == false) goto L145;
        r19.i(r21.extended());
    L145:
        if (com.bytedance.android.livesdk.utils.r6.a.b() == false) goto L152;
        if (r19.z() == true) goto L152;
        ToolbarButton r22 = ToolbarButton.FAST_GIFT;
        if (r19.n(r22) == false) goto L152;
        r19.i(r22.extended());
    L152:
        if (com.bytedance.android.livesdk.utils.r6.a.b() == false) goto L159;
        if (r19.z() == false) goto L159;
        ToolbarButton r23 = ToolbarButton.FAST_GIFT;
        if (r19.n(r23) == true) goto L159;
        r19.c(r23.extended());
    L159:
        if (com.bytedance.android.livesdk.utils.r6.a.c() == false) goto L166;
        if (r19.z() == false) goto L166;
        ToolbarButton r24 = ToolbarButton.FAST_GIFT;
        if (r19.n(r24) == false) goto L166;
        r19.i(r24.extended());
    L166:
        if (com.bytedance.android.livesdk.utils.r6.a.c() == false) goto L172;
        if (r19.z() == true) goto L172;
        ToolbarButton r25 = ToolbarButton.FAST_GIFT;
        if (r19.n(r25) == true) goto L172;
        r19.c(r25.extended());
    L172:
        r19.B();
        com.bytedance.android.livesdk.chatroom.utils.p1.a(this.W);
        return;
    L121:
        if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L123;
        Lc0();
        goto L123
    L83:
        if (((Boolean) r4.get("live_special_ad", Boolean.FALSE)).booleanValue() == false) goto L85;
        r2 = true;
        goto L85
    L8:
        if (r1.mEnable == false) goto L80;
        if (LiveEnterRoomControllerUtilKt.getHasEcommerceInjected() == false) goto L12;
    L24:
        boolean r26 = false;
    L26:
        if (LiveEnterRoomControllerUtilKt.getHasLocalLifeInjected() == true) goto L35;
        if (this.h3.mLocalLiftOpt == false) goto L35;
        if (tb1.c.a == false) goto L35;
        if (jc1.k.f(IHostLiveLocalLife.class) == null) goto L35;
        jc1.k.f(IHostLiveLocalLife.class).initRoomController();
        LiveEnterRoomControllerUtilKt.setHasLocalLifeInjected(true);
        r26 = true;
    L35:
        if (LiveEnterRoomControllerUtilKt.getHasAdWindmillInjected() == false) goto L37;
    L39:
        boolean r27 = false;
    L41:
        if (LiveEnterRoomControllerUtilKt.getHasAdCouponInjected() == false) goto L43;
    L45:
        boolean r28 = false;
    L46:
        if (r27 == true) goto L49;
        if (r28 == true) goto L49;
    L58:
        if (LiveEnterRoomControllerUtilKt.getHasGameCpInjected() == false) goto L60;
    L62:
        boolean r29 = false;
    L63:
        if (r29 == true) goto L65;
    L73:
        if (r26 == false) goto L80;
        Aa0(new d3(this));
        Aa0(new c0());
        Aa0(new s0());
        Aa0(new a1());
        Aa0(new e3(this));
        Aa0(new f3(this));
        final IRoomEventHub r30 = LivePlatformPlayerManager.a(this.q.getId(), false).getEventHub();     // Catch: NullPointerException -> L77
        Aa0(new g3(r30));     // Catch: NullPointerException -> L77
    L79:
        Aa0(new i3(this));
        Aa0(new j3(this));
    L77:
        e = move-exception;
        ALogger.e("AbsInteractionFragment", "npe when get IRoomEventHub : " + e.getStackTrace().toString());
        goto L79
    L65:
        if (pb0() == false) goto L73;
        if (jc1.k.f(IHostGameCP.class).getGameCpLiveService() == null) goto L73;
        if (jc1.k.f(IHostGameCP.class).getGameCpLiveService().getGameCpRoomControllerProvider() == null) goto L73;
        if ((jc1.k.f(IHostGameCP.class).getGameCpLiveService().getGameCpRoomControllerProvider() instanceof ILiveRoomControllerProvider) == false) goto L73;
        jc1.k.f(ExternalFunctionInjectorService.class).injectRoomControllerProvider((ILiveRoomControllerProvider) jc1.k.f(IHostGameCP.class).getGameCpLiveService().getGameCpRoomControllerProvider());
        LiveEnterRoomControllerUtilKt.setHasGameCpInjected(true);
        r26 = true;
        goto L73
    L60:
        if (this.h3.mGameCpOpt == false) goto L62;
        r29 = true;
    L49:
        if (tb1.c.a == false) goto L58;
        if (jc1.k.f(IHostLiveAd.class) == null) goto L58;
        IHostLiveAd r31 = jc1.k.f(IHostLiveAd.class);
        if (r28 == false) goto L55;
        r31.callInjectAdController();
        LiveEnterRoomControllerUtilKt.setHasAdCouponInjected(true);
        r26 = true;
    L55:
        if (r27 == false) goto L58;
        r31.callInjectWindmillController();
        LiveEnterRoomControllerUtilKt.setHasAdWindmillInjected(true);
        r26 = true;
        goto L58
    L43:
        if (this.h3.mAdCouponOpt == false) goto L45;
        r28 = true;
        goto L46
    L37:
        if (this.h3.mAdWindmillOpt == false) goto L39;
        r27 = true;
        goto L41
    L12:
        if (this.h3.mEcommerceOpt == false) goto L24;
        if (jc1.k.f(IHostCommerceServiceLive.class) == null) goto L22;
        boolean r32 = jc1.k.f(IHostCommerceServiceLive.class).enableFullLiveCommerce();
        if (tb1.c.c == false) goto L20;
        if (r32 == true) goto L20;
        jc1.k.f(IHostCommerceServiceLive.class).injectMessage();
        LiveEnterRoomControllerUtilKt.setHasEcommerceInjected(true);
    L21:
        r26 = true;
    L23:
        ExternalFunctionInjectorService.checkCommerceServiceState("AbsInteractionFragment");
    L20:
        jc1.k.f(IHostCommerceServiceLive.class).callInjection();
        LiveEnterRoomControllerUtilKt.setHasEcommerceInjected(true);
        goto L21
    L22:
        r26 = false;
        goto L23
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.bytedance.android.livesdk.chatroom.ui.z0] */
    public AbsInteractionFragment() {
        this.i = false;
        this.j = false;
        this.m = false;
        this.n = 200;
        this.o = false;
        this.p = null;
        this.w = false;
        this.z = 0;
        this.B = 0;
        this.L = new CompositeDisposable();
        this.M = new WeakHandler(this);
        this.U = new CopyOnWriteArrayList();
        this.y1 = null;
        this.g2 = null;
        this.h2 = -1;
        this.v2 = false;
        new ArrayList();
        this.P2 = 0;
        this.Q2 = false;
        this.R2 = false;
        this.S2 = false;
        this.T2 = new HeadsetBroadcastReceiver();
        this.c3 = new com.bytedance.android.livesdk.interactivity.api.barrage.data.g();
        this.d3 = (com.bytedance.android.livesdk.interactivity.api.settings.config.a) r52.s.a.getValue();
        this.g3 = null;
        this.h3 = new a71();
        this.i3 = new ah1.b();
        this.j3 = new ah1.c();
        this.k3 = new ah1.a();
        this.l3 = new ArrayList();
        ComponentManagerABHelper r3 = ComponentManagerABHelper.INSTANCE;
        this.m3 = Boolean.valueOf(r3.enableComponentXFragmentTaskFix());
        this.n3 = Boolean.valueOf(r3.enableFragmentReset());
        this.q3 = new e(this);
        this.r3 = new lo1.a(new WeakReference(this.q3));
        this.s3 = null;
        this.t3 = new WidgetLoadState(this);
        this.w3 = new f(this);
        this.x3 = new h(this);
        this.y3 = null;
        this.z3 = null;
        this.B3 = false;
        this.C3 = false;
        this.E3 = false;
        this.G3 = 0;
        this.H3 = new ArrayList();
        this.J3 = null;
        this.K3 = -1;
        this.M3 = false;
        this.N3 = false;
        this.O3 = null;
        this.P3 = new ArrayList();
        this.Q3 = new ArrayList();
        this.S3 = new i(this);
        this.U3 = new z0(this);
        this.V3 = true;
        this.W3 = 0.0f;
        this.X3 = 0.0f;
        this.Y3 = 0.0f;
        this.Z3 = 0.0f;
        this.a4 = 0.0f;
        this.j4 = new u(this);
        this.l4 = false;
        this.m4 = new j(this);
        this.p4 = -1;
        this.q4 = false;
        this.r4 = false;
    }

    private void Lc0() {
        if (UserSetting.b() == false) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        r0.put("target_uid", String.valueOf(TTLiveSDKContext.getHostService().h().n()));
        r0.put("user_open_id", TTLiveSDKContext.getHostService().h().n());
        r0.put("anchor_open_id", this.q.getOwner().getIdStr());
        r0.put("sec_target_uid", TTLiveSDKContext.getHostService().h().a.getCastSecUid());
        r0.put("packed_level", String.valueOf(2));
        r0.put("request_from", "admin");
        r0.put("source", "1");
        r0.put("current_room_id", String.valueOf(this.q.getId()));
        r0.put("anchor_id", this.q.getOwner().getIdStr());
        com.bytedance.android.livesdk.user.f0 r1 = TTLiveSDKContext.getHostService().h();
        com.bytedance.android.livesdk.user.f0 r2 = r1;
        r0.put("sec_anchor_id", r2.a(this.q.getOwner().getIdStr()));
        TTLiveSDKContext.getHostService().h().d(r0).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(new x2()).subscribe(this.w3);
    }

    public final Boolean Ha0() {
        if (com.bytedance.android.live.core.tetris.widgets.d.b() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Boolean r1 = Boolean.valueOf(r0);
        ALogger.i("ComponentX_Batch_Condition", "enablePreload = " + r1);
        return r1;
    L5:
        if (((Boolean) this.W.get("cmd_interact_is_part_show", Boolean.FALSE)).booleanValue() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final void Mc0() {
        if (g1() == true) goto L5;
        return;
    L5:
        if (ClearScreenHelper.d(this.W) == false) goto L23;
        Boolean r0 = this.D3;
        if (r0 == null) goto L12;
        if (r0.booleanValue() == false) goto L12;
        return;
    L12:
        if (this.f4 == null) goto L14;
        return;
    L14:
        if (ClearScreenHelper.l(this.W) == true) goto L16;
    L18:
        boolean r1 = false;
    L19:
        if (r1 == false) goto L25;
        Context r2 = getContext();
        DataCenter r3 = this.W;
        int r4 = com.bytedance.android.livesdk.clearscreen.gesture.a.d;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        final com.bytedance.android.livesdk.clearscreen.gesture.a r5 = new com.bytedance.android.livesdk.clearscreen.gesture.a(r2);
        int r6 = gh1.a.c;
        gh1.a.a.a(r3, r5);
        this.f4 = r5;
        r5.b = new y2(this);
        this.i4 = Disposables.fromAction(new z2(this, r5));
        return;
    L25:
        return;
    L16:
        if (ClearScreenHelper.j().f() == false) goto L18;
        r1 = true;
        goto L19
    }

    public final void Qb0() {
        ILiveRoomPlayFragment r0 = getParentFragment();
        if ((r0 instanceof ILiveRoomPlayFragment) == false) goto L10;
        ILiveRoomPageFragment r1 = r0.parentPage();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.getRealAction().getCurrentPosition() != 0) goto L12;
        r1.getRealAction().notifyDataSetChange();
        return;
    L12:
        return;
    }

    public final Lifecycle Qy() {
        return getLifecycle();
    }

    public final void Vc0() {
        if (g1() == false) goto L24;
        Boolean r0 = this.D3;
        if (r0 != null) goto L7;
    L9:
        RoomContext r1 = this.X;
        if (r1 != null) goto L12;
    L16:
        boolean r2 = false;
    L17:
        boolean r3 = gs1.b.a;
        if (gs1.b.a == true) goto L20;
        return;
    L20:
        if (this.q4 == true) goto L26;
        if (r2 == true) goto L27;
        this.q4 = true;
        ClearScreenHelper.m(true);
        return;
    L27:
        return;
    L26:
        return;
    L12:
        if (r1.isCleanMode() == null) goto L16;
        if (((Boolean) this.X.isCleanMode().getValue()).booleanValue() == false) goto L16;
        r2 = true;
        goto L17
    L7:
        if (r0.booleanValue() == false) goto L9;
        return;
    }

    public final boolean bd0() {
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r0 = LiveVrContext.get();
        if (r0 == null) goto L8;
        if (r0.isInVrMode() == false) goto L8;
        return true;
    L8:
        if (ClearScreenHelper.a() == false) goto L10;
        return false;
    L10:
        com.bytedance.android.livesdk.feedback.room.a r1 = RoomFeedbackContext.get();
        if (r1 == null) goto L16;
        if (((Boolean) r1.isHideViewsOnClearScreen().getValue()).booleanValue() == false) goto L16;
        return true;
    L16:
        if (RoomContext.getShared() != null) goto L18;
    L20:
        return false;
    L18:
        if (((Boolean) RoomContext.getShared().isInZoom().getValue()).booleanValue() == false) goto L20;
        return true;
    }

    public final boolean gb0() {
        if (pa0() == false) goto L6;
        return true;
    L6:
        if (oa0() == false) goto L8;
        return true;
    L8:
        return false;
    }

    public final void ia0() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return;
    L5:
        Bundle r1 = com.bytedance.android.livesdk.chatroom.m0.a(r0);
        this.J3 = r1;
        if (r1 == null) goto L8;
        r1.getLong("live.intent.extra.ENTER_LIVE_TIME", 0);
    L8:
        this.r = r0.getString("live.intent.extra.ENTER_LIVE_SOURCE", "");
        r0.getBoolean("live.intent.extra.is_multi_tab_container", false);
        this.L2 = r0.getBoolean("extra_longer_video_with_live", false);
        com.bytedance.android.livesdk.log.filter.i r2 = com.bytedance.android.livesdk.log.u.l().c(am2.f.class);     // Catch: Throwable -> L15
        if (r2 != null) goto L12;
        return;
    L12:
        if ((r2 instanceof com.bytedance.android.livesdk.log.filter.i) == false) goto L19;
        r2.J(getArguments());     // Catch: Throwable -> L15
        return;
    L19:
        return;
    }

    public void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        com.bytedance.android.live.core.tetris.widgets.d.g("onPause#" + hashCode());
        this.x = false;
        Aa0(new g0());
        if (getContext() == null) goto L18;
        Context r1 = getContext();
        HeadsetBroadcastReceiver r2 = this.T2;
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L16;
        r1.unregisterReceiver(r2);
        return;
    L16:
    L10:
        e = move-exception;
        if (r2 == null) goto L13;
        Npth.addTag("unregisterReceiver", r2.toString());
    L13:
        e.printStackTrace();
        return;
    L7:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L19;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L10
        return;
    L19:
        return;
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        com.bytedance.android.live.core.tetris.widgets.d.g("onResume#" + hashCode());
        this.x = true;
        Aa0(new k0());
        if (getContext() == null) goto L12;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.HEADSET_PLUG");
        r0.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        r0.addAction("android.bluetooth.a2dp.profile.action.ACTIVE_DEVICE_CHANGED");
        r0.addAction("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
    L10:
        e = move-exception;
        e.printStackTrace();
        ALogger.e("AbsInteractionFragment", "registerReceiver " + e.getMessage());
        goto L12
    L6:
        if (Build.VERSION.SDK_INT < 34) goto L8;
        V90(getContext(), this.T2, r0);     // Catch: IllegalArgumentException -> L10
    L16:
        goto L12
    L8:
        W90(getContext(), this.T2, r0);     // Catch: IllegalArgumentException -> L10
    L12:
        com.bytedance.android.livesdk.chatroom.utils.b0.g();
        Pc0();
        if (this.s3 == null) goto L19;
        com.bytedance.android.live.core.tetris.widgets.d.g("continue room enter on resume");
        this.s3.run();
        this.s3 = null;
        return;
    }

    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Aa0(new a1());
    }

    public void onStop() {
        super.onStop();
        Aa0(new h3());
        com.bytedance.android.live.core.tetris.widgets.d.g("onStop#" + hashCode());
        xs2.b.a().post(new u22.e());
    }

    public final int pT() {
        View r0 = getView();
        if (r0 == null) goto L5;
        int r1 = r0.getHeight();
    L6:
        int r2 = this.b2;
        if (r2 <= 0) goto L9;
        int r3 = r2;
    L11:
        if (this.V3 == false) goto L16;
        if (r2 == r1) goto L16;
        if (r1 <= com.bytedance.android.live.core.utils.s1.f(200.0f)) goto L16;
        this.b2 = r1;
    L17:
        if (r1 > 0) goto L20;
        int r4 = UIUtils.getScreenHeight(getContext());
        ALogger.w("AbsInteractionFragment.adjustTextMessage", "failed to obtain iaHeight");
        boolean r5 = TextMessageTracer.a;
        TextMessageTracer.A("failed to obtain iaHeigh");
        return r4;
    L20:
        return r1;
    L16:
        r1 = r3;
        goto L17
    L9:
        r3 = r1;
        goto L11
    L5:
        r1 = 0;
        goto L6
    }

    public final boolean ra0() {
        if (ClearScreenHelper.g() == false) goto L5;
    L12:
        return true;
    L5:
        if (ClearScreenHelper.d(this.W) == true) goto L7;
    L11:
        return false;
    L7:
        if (((Boolean) this.X.isCleanMode().getValue()).booleanValue() == true) goto L12;
        if (((Integer) this.X.getCleanMode().getValue()).intValue() != ClearScreenConst.InteractType.INTERACT_SHOW.getId()) goto L11;
        goto L11
    }

    public boolean rb0() {
        return !g1();
    }

    public void Oc0() {
        Tb0();
    }

    public h80.c<com.bytedance.android.livesdk.chatroom.widget.landscape.r> Ua0() {
        return h80.c.b;
    }

    private void Kc0(Throwable r4) {
        if ((r4 instanceof ApiServerException) == false) goto L25;
        int r5 = ((ApiServerException) r4).getErrorCode();
        if (30003 != r5) goto L8;
        Qc0("query_user_room_finish");
        zg1.h1 r6 = new zg1.h1(7, this.q);
        xs2.b.a().post(r6);
        return;
    L8:
        if (50001 != r5) goto L13;
        if (this.Z.getCommentService().getValue() == null) goto L27;
        ((t22.b) this.Z.getCommentService().getValue()).Xp(true);
        return;
    L27:
        return;
    L13:
        if (50002 != r5) goto L16;
        Bc0(10);
        return;
    L16:
        if (30005 != r5) goto L22;
        if (this.u == false) goto L32;
        com.bytedance.android.livesdk.widget.x0.b r7 = new com.bytedance.android.livesdk.widget.x0.b(getActivity(), 0);
        r7.m(2131920017);
        r7.l(2131918912);
        r7.i(0, 2131919195, new x0());
        r7.a.i = new y0(this);
        r7.n();
        return;
    L32:
        return;
    L22:
        if (30006 != r5) goto L31;
        bb0(false);
        return;
    L31:
        return;
    }

    private void Zc0(float r3) {
        View r0 = this.F3;
        if (r0 == null) goto L8;
        r0.setAlpha(r3);
        ALogger.i("AbsInteractionFragment", "setInteractionAlpha alpha=" + r3);
        FrameLayout r4 = this.a3;
        if (r4 == null) goto L9;
        r4.setVisibility(0);
        this.a3.setOnClickListener(new h1(this));
        return;
    L9:
        return;
    }

    public static void ba0(AbsInteractionFragment r9) {
        r9.getClass();
        JSONObject r0 = new JSONObject();
        r0.put("anchor_id", r9.q.getOwner().getIdStr());     // Catch: JSONException -> L5
        r0.put("room_id", String.valueOf(r9.q.getId()));     // Catch: JSONException -> L5
    L7:
        com.bytedance.android.livesdk.utils.g4.h(r0);
        if (com.bytedance.android.livesdk.utils.c1.c(r9.W) == false) goto L15;
        ILiveDouPlusService r1 = jc1.k.f(ILiveDouPlusService.class);
        HashMap r6 = new HashMap();
        r6.put("ad_extra_data", r0.toString());
        Map r7 = com.bytedance.android.livesdk.utils.c1.f(r9.W);
        if (r7.isEmpty() == true) goto L13;
        r6.putAll(r7);
    L13:
        r1.logEvent(true, "live_ad", "follow", r6);
        com.bytedance.android.livesdk.utils.b3.a(r9.W, r0);
    L15:
        if (com.bytedance.android.livesdk.utils.c1.b(r9.W) == false) goto L23;
        ILiveDouPlusService r2 = jc1.k.f(ILiveDouPlusService.class);
        HashMap r8 = new HashMap();
        r8.put("ad_extra_data", r0.toString());
        Map r10 = com.bytedance.android.livesdk.utils.c1.e(r9.W);
        if (r10 != null) goto L19;
    L22:
        r2.logEvent(true, "live_ad", "follow", r8);
        goto L23
    L19:
        if (r10.isEmpty() == true) goto L22;
        r8.putAll(r10);
    L23:
        com.bytedance.android.live.core.utils.f2.b(2131919118, 0);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static /* synthetic */ String da0(AbsInteractionFragment r0) {
        return r0.Ra0();
    }

    private boolean db0(final MotionEvent r5) {
        if (pX() == true) goto L23;
        Room r0 = this.q;
        if (r0 != null) goto L7;
    L12:
        boolean r1 = gc0(r5);
        if (r1 == true) goto L18;
        Disposable r2 = this.o4;
        if (r2 == null) goto L17;
        r2.dispose();
    L17:
        this.o4 = Observable.timer(((Number) ClearScreenHelper.d.getValue()).longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b3(this, r5));
        this.p4 = Integer.valueOf(r5.getActionIndex());
    L22:
        return r1;
    L18:
        Disposable r6 = this.o4;
        if (r6 == null) goto L21;
        r6.dispose();
    L21:
        this.p4 = -1;
        goto L22
    L7:
        if (r0.getRoomAuthStatus() == null) goto L12;
        if (this.q.getRoomAuthStatus().getEnableDigg() == true) goto L12;
        hd0(r5);
        return false;
    L23:
        hd0(r5);
        return false;
    }

    public void AR(Room r1) {
        ta0();
    }

    public final void AS(BaseMessage r6) {
        if (r6 != null) goto L6;
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    L6:
        if (yl.a.getValue().booleanValue() == true) goto L13;
        if ((r6 instanceof com.bytedance.android.livesdk.message.model.n3) == false) goto L13;
        CommonToastWidget r0 = this.G1;
        if (r0 == null) goto L13;
        r0.M9((com.bytedance.android.livesdk.message.model.n3) r6);
    L13:
        if ((r6 instanceof com.bytedance.android.livesdk.message.model.p4) == false) goto L25;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.b) this.X.getCommonPopupModel().getValue()).a == false) goto L18;
        return;
    L18:
        if (this.X.isVSRoom() == false) goto L21;
        return;
    L21:
        if (this.H1 != null) goto L23;
        FollowGuideWidget r1 = new FollowGuideWidget(isScreenPortrait());
        this.H1 = r1;
        this.e.load(r1);
    L23:
        this.H1.Kd(this.q, (com.bytedance.android.livesdk.message.model.p4) r6, this.W);
        return;
    L25:
        if ((r6 instanceof com.bytedance.android.livesdk.message.model.z5) == false) goto L61;
        com.bytedance.android.livesdk.message.model.z5 r7 = (com.bytedance.android.livesdk.message.model.z5) r6;
        if (this.q != null) goto L29;
    L31:
        int r2 = fi1.a;
        if (fi1.a.a() == false) goto L34;
        return;
    L34:
        if (fi1.a.c() == false) goto L37;
        return;
    L37:
        if (com.bytedance.android.livesdk.slideuptip.k.e() == false) goto L40;
        return;
    L40:
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.b) this.X.getCommonPopupModel().getValue()).a == true) goto L76;
        Room r3 = this.q;
        if (r3 == null) goto L50;
        if (r3.getRoomAuthStatus() == null) goto L50;
        if (this.q.getRoomAuthStatus().getEnableGift() == true) goto L50;
        ALogger.e("AbsInteractionFragment", "handleGuideMessage roomAuthStatus enableGift is true");
        return;
    L50:
        if (r7.getGuideType() == 1) goto L58;
        if (r7.getGuideType() == 3) goto L58;
        if (r7.getGuideType() != 2) goto L68;
        this.M.post(this.S3);
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    L68:
        return;
    L58:
        if (this.A3.c0(r7) == true) goto L70;
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    L70:
        return;
    L76:
        return;
    L29:
        if (this.t == false) goto L31;
        return;
    L61:
        if ((r6 instanceof com.bytedance.android.livesdk.message.model.k3) == false) goto L63;
        this.M1.Qf((com.bytedance.android.livesdk.message.model.k3) r6);
        return;
    L63:
        PlatformMessageHelper.INSTANCE.onMessageFinish();
    }

    public final void Aa0(com.bytedance.android.livesdk.room.util.i r5) {
        IExternalFunctionInjector r0 = jc1.k.f(IExternalFunctionInjector.class);
        if (this.q == null) goto L10;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.G3 != 0) goto L8;
        this.G3 = ((Integer) this.W.get("room_controller_unique_key", 0)).intValue();
        boolean r1 = com.bytedance.android.livesdk.room.util.j.a;
        com.bytedance.android.livesdk.room.util.j.b("controllerCall mParentFragmentCode = " + this.G3 + ", cur = " + hashCode());
    L8:
        r5.call(r0.getLiveRoomController(this.q.getId(), this.G3));
        return;
    }

    public final void Bb0(boolean r4) {
        if (Nt() == false) goto L6;
        MiddlewareRoomWidget r0 = jc1.k.f(IInteractService.class).createAIMVWidget();
        this.e.load(2131362409, r0, r4);
        return;
    }

    public void Bc0(int r2) {
        zg1.h1 r0 = new zg1.h1(r2);
        xs2.b.a().post(r0);
    }

    public final void CM(IRoom r3) {
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load immediately p1 widget start");
        ALogger.i("ComponentX_Batch_Condition", "loadImmediatelyP1Widget");
        Db0((Room) r3);
        this.e.ea0(jc1.k.f(IBrowserService.class).provideBridgeSupportWidgetClass(), false, false);
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load immediately p1 widget end all");
    }

    public final void Cz(nz.r r1) {
        this.s4 = r1;
    }

    public final void D2(boolean r3) {
        if (r3 == false) goto L5;
        Pb0();
        return;
    L5:
        if (this.x2 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.W).d(ToolbarButton.RECORD, this.x2);
        this.x2 = null;
        return;
    }

    public void Db0(Room r1) {
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load child immediately p1 widget start");
    }

    public void Dc0(Room r2) {
        ToolbarLoadTimeStatsVM.getInstance(RoomContext.getShared(this.W)).recordTime(ToolbarLoadTimeStatsVM.ROOM_P1_LOAD_START);
    }

    @Override // com.bytedance.android.livesdk.chatroom.view.b
    public final void Ft(ControlMessage r7) {
        if (this.u == true) goto L5;
        return;
    L5:
        long r0 = r7.getAction();
        if (3 != r0) goto L9;
        Qc0("control_message_action_end");
        pd0(r7);
        zg1.h1 r1 = new zg1.h1(7);
        r1.c = this.q;
        xs2.b.a().post(r1);
    L29:
        boolean r2 = TextMessageTracer.a;
        TextMessageTracer.A("WebcastControlMessage: " + r7.getMessageId());
        return;
    L9:
        if (4 != r0) goto L24;
        zg1.h1 r3 = new zg1.h1(7);
        r3.c = this.q;
        xs2.b.a().post(r3);
        Room r4 = this.q;
        if (r4 != null) goto L13;
    L17:
        boolean r5 = false;
    L19:
        if (StringUtils.isEmpty(r7.getTips()) == true) goto L22;
        if (r5 == true) goto L22;
        com.bytedance.android.live.core.utils.f2.c(r7.getTips(), 1);
    L22:
        Rc0("control_message_room_banned", r7.getTips());
        goto L29
    L13:
        if (r4.isMediaRoom() == false) goto L17;
        if (this.D3.booleanValue() == true) goto L17;
        r5 = true;
        goto L19
    L24:
        if (1 != r0) goto L27;
        ec0(r7);
        pd0(r7);
        goto L29
    L27:
        if (2 != r0) goto L29;
        fc0(r7);
        pd0(r7);
        goto L29
    }

    public void Gc0(String r4) {
        this.W.put("data_room", this.q).put("data_room_id", Long.valueOf(this.q.getId())).put("data_is_portrait", Boolean.valueOf(isScreenPortrait())).put("data_live_mode", this.T).put("data_user_center", this.Q1).put("data_in_room_banner_manager", this.p0).put("data_enter_source", r4);
        this.X.getRoom().setValue(this.q);
        jc1.k.f(ILinkServiceExternal.class).updateLiveMode(this.T);
        jc1.k.f(ILinkServiceExternal.class).updatePortrait(isScreenPortrait());
    }

    public final void H3(ByteBuffer r3) {
        if (n22.a.a() == false) goto L31;
        com.bytedance.android.livesdk.interactivity.api.settings.config.a r0 = this.d3;
        if (r0 != null) goto L7;
    L30:
        com.bytedance.android.livesdk.interactivity.api.settings.config.a r1 = this.d3;     // Catch: Exception -> L28
        if (r1 != null) goto L16;
    L21:
        if (r3 != null) goto L23;
        return;
    L23:
        if (com.bytedance.android.livesdk.interactivity.api.q.b() != null) goto L25;
        return;
    L25:
        if (((Boolean) com.bytedance.android.livesdk.interactivity.api.q.b().isInCarnival().getValue()).booleanValue() == false) goto L35;
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Exception -> L28
        ILiveWrappedLivePusher.a.b().getZlibCompressUtils();     // Catch: Exception -> L28
        return;
    L35:
        return;
    L16:
        if (r1.enableAsyncHandleSei == false) goto L21;
        if (this.e3 != null) goto L20;
        this.e3 = new com.bytedance.android.livesdk.chatroom.utils.i(this.c3);     // Catch: Exception -> L28
    L20:
        this.e3.a(r3);     // Catch: Exception -> L28
        return;
    L28:
        ALogger.e("CARNIVAL_MESSAGE", "parse binary data error");
        return;
    L7:
        if (r0.enableDropFrame.booleanValue() == false) goto L30;
        int r2 = this.P2;
        if (r2 >= this.d3.dropInterval) goto L11;
        this.P2 = r2 + 1;
        goto L30
    L11:
        this.P2 = 0;
        return;
    }

    public void Ja0(Room r3) {
        ALogger.i("COMPONENTX_END", "endP0Load AbsInteractionFragment");
        this.e.load(2131371661, new P0EndWidget());
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load p0 widget end all");
        this.B3 = true;
        y50.c.d.a("fragment_load_p0");
    }

    public final void Kb0(View r2) {
        if (this.q != null) goto L5;
    L7:
        Ib0();
        ta0();
        return;
    L5:
        if (this.t == true) goto L7;
        IMicRoomService r3 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
        lb0(getView(), r3);
        goto L7
    }

    public final int Pa0(kf1.a r4) {
        Map<String, Integer> r0 = ((com.bytedance.android.livesdk.config.t1) LiveConfigSettingKeys.CLOSE_REMAIN_RULE_CONFIG.getValue()).remainPriorityMap;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.isEmpty() == true) goto L13;
        Integer r5 = r0.get(r4.config().name());
        if (r5 != null) goto L11;
        return 0;
    L11:
        return r5.intValue();
    L13:
        return 0;
    }

    public final void R40(hh1.w0 r2) {
        if (((ArrayList) this.H3).contains(r2) == true) goto L6;
        ((ArrayList) this.H3).add(r2);
        return;
    }

    public final void RJ(Runnable r2) {
        if (this.P0 == null) goto L5;
        this.R3 = null;
        r2.run();
        return;
    L5:
        this.R3 = r2;
    }

    public final void Sb(View.OnTouchListener r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (((ArrayList) this.P3).contains(r2) == true) goto L9;
        ((ArrayList) this.P3).add(r2);
        return;
    }

    public final void Sb0(boolean r4) {
        if (Nt() == true) goto L5;
        return;
    L5:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L7;
        Widget r0 = jc1.k.f(IInteractService.class).createAudioSceneBasicWidget();
        this.v1 = r0;
        this.e.load(r0, r4);
        return;
    L7:
        Widget r1 = jc1.k.f(IRadioService.class).createRadioWidget();
        this.p1 = r1;
        this.e.load(2131383618, r1, r4);
    }

    public final void Sc0(String r5) {
        ALogger.d("AbsInteractionFragment", "requestStreamControl mRoom : " + this.q + ", controlParams: " + r5 + ", mIsViewValid: " + this.u);
        if (this.u == true) goto L5;
        return;
    L5:
        if (this.q != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r5) == true) goto L13;
        com.bytedance.android.livesdk.service.l.d().getClass();
        ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).requestStreamControl(Long.valueOf(this.q.getId()), Long.valueOf(this.q.getStreamId()), r5).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.chatroom.ui.u(this), RxUtil.getNoOpThrowable());
        return;
    }

    public final void Tc0(long r5) {
        xs2.b.a().post(new u22.j(false, 2));
        if (this.M.hasMessages(200) == false) goto L5;
        this.M.removeMessages(200);
    L5:
        this.M.sendEmptyMessageDelayed(200, r5);
    }

    public final void UO(Room r5) {
        if (jc1.k.f(IRoomModuleService.class) == null) goto L9;
        q81.c r0 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        if (r5 == null) goto L7;
        long r1 = r5.getId();
    L8:
        r0.n(r1, getArguments());
        goto L9
    L7:
        r1 = 0;
    L9:
        this.T1.c.a = true;
        InRoomBannerManager r2 = this.p0;
        if (r2 == null) goto L12;
        InRoomBannerManager.c(r2, this.q.getId(), this.D3.booleanValue());
    L12:
        Ec0(r5);
        this.e.load(2131371661, new P2EndWidget());
    }

    public final void WG(Room r7) {
        if (jc1.k.f(IRoomModuleService.class) == null) goto L9;
        q81.c r0 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        if (r7 == null) goto L7;
        long r1 = r7.getId();
    L8:
        r0.b(r1, getArguments());
        goto L9
    L7:
        r1 = 0;
    L9:
        boolean r2 = true;
        this.T1.d.a = true;
        View r8 = this.F3;
        RoomContext r3 = this.X;
        if (r3 != null) goto L12;
    L79:
        RoomContext r9 = this.X;
        if (r9 == null) goto L82;
        int r10 = r9.hashCode();
    L83:
        StringBuilder r4 = new StringBuilder("RoomContext is null: ");
        if (this.X != null) goto L86;
        boolean r5 = true;
    L87:
        r4.append(r5);
        com.bytedance.android.live.core.tetris.widgets.d.g(r4.toString());
        com.bytedance.android.live.core.tetris.widgets.d.g("RoomContext is not valid, this=" + hashCode() + " context=" + r10);
        com.bytedance.android.live.core.tetris.widgets.d.g("Current RoomContext is cleared, return prepareWidget");
        HashMap r11 = new HashMap();
        StringBuilder r6 = new StringBuilder();
        if (this.X == null) goto L91;
        r2 = false;
    L91:
        r6.append(r2);
        r6.append("");
        r11.put("data_context_is_null", r6.toString());
        r11.put("method", "prepareWidget");
        com.bytedance.android.live.core.tetris.widgets.d.e("ttlive_interaction_opt_data_context_invalid_error", r11);
    L93:
        if (pm1.f.o() == null) goto L105;
        pm1.f.o().a();
        if (MultiTabManagerImpl.e.h(this.W) == false) goto L105;
        if (isScreenPortrait() == false) goto L104;
        DataCenter r12 = this.W;
        if (r12 == null) goto L104;
        if (((Boolean) r12.get("match_tab_all_loaded", Boolean.FALSE)).booleanValue() == true) goto L104;
        this.W.observe("match_tab_all_loaded", this);
        return;
    L104:
        Mb0();
        return;
    L105:
        Mb0();
        return;
    L86:
        r5 = false;
        goto L87
    L82:
        r10 = 0;
        goto L83
    L12:
        if (r3.isCleared() == true) goto L79;
        if (this.E3 == true) goto L17;
        com.bytedance.android.live.core.tetris.widgets.d.g("RoomContext has not init");
        HashMap r13 = new HashMap();
        r13.put("method", "prepareWidget");
        com.bytedance.android.live.core.tetris.widgets.d.e("ttlive_interaction_opt_data_context_not_init_error", r13);
        goto L93
    L17:
        long r14 = System.currentTimeMillis();
        if (this.X.getEnterRoomTime().d(Long.valueOf(r14)) == false) goto L20;
        jc1.k.f(ILinkServiceExternal.class).setEnterRoomTime(r14);
    L20:
        this.H0 = (IShortTermIconFramework) this.X.getShortTermIconFramework().getValue();
        Boolean r15 = Boolean.valueOf(com.bytedance.android.live.core.utils.z.e(this.W, false));
        boolean r16 = r15.booleanValue();
        int r17 = StickerWrapperWidget.j;
        if (r16 == false) goto L23;
        StickerWrapperWidget r18 = new AnchorStickerWrapperWidget();
    L24:
        this.k1 = r18;
        r18.a = this;
        Function0<Void> r19 = new i0(this);
        Intrinsics.checkNotNullParameter(r19, "degradeCallback");
        r18.b = r19;
        VipIMWidget r20 = new VipIMWidget();
        this.P1 = r20;
        this.e.load(r20);
        if (com.bytedance.android.livesdk.config.setting.i.a.d() == false) goto L31;
        if (jc1.k.f(ILiveExpOptService.class).getSceneState(this.W, l61.d.a.g.e).a() != true) goto L31;
    L32:
        if (r2 == true) goto L35;
        this.e.load(2131365431, new CeremonyBorderWidget());
    L35:
        if (this.B3 == true) goto L37;
        Kb0(r8);
    L37:
        boolean r21 = k60.b.a();
        com.bytedance.android.livesdk.config.w0 r22 = (com.bytedance.android.livesdk.config.w0) h21.c.getValue();
        if (r22 == null) goto L46;
        if (r22.a() == false) goto L46;
        if (this.D3.booleanValue() == true) goto L46;
        BroadcastPauseStateWidget r23 = null;
    L49:
        LiveMode r24 = this.T;
        if (r24 == null) goto L53;
        if (r23 == null) goto L53;
        r23.eR(r24);
    L53:
        UserPermissionCheckWidget r25 = (UserPermissionCheckWidget) this.e.ea0(UserPermissionCheckWidget.class, r21, r21);
        this.x1 = new LiveShareWidget();
        this.e.ea0(jc1.k.f(IBrowserService.class).provideBridgeSupportWidgetClass(), false, false);
        this.M1 = new CommonGuideWidget();
        int r26 = StickerWrapperWidget.j;
        if (StickerWrapperWidget.b.a(r15.booleanValue()) == false) goto L57;
        this.e.load(2131378275, this.k1);
    L57:
        if (yl.a.getValue().booleanValue() == true) goto L59;
        CommonToastWidget r27 = new CommonToastWidget();
        this.G1 = r27;
        this.e.load(r27, r21, r21);
    L59:
        this.e.load(this.x1, r21, r21);
        this.e.load(this.M1, r21, r21);
        Jc0(r8);
        mg2.d r28 = this.f;
        f70.b r29 = mg2.e.e;
        Portrait5thDelegate r30 = (ViewLayerDelegate) r28.o4(r29, LayerIndex.INDEX_5);
        this.G2 = r30;
        if ((r30 instanceof Portrait5thDelegate) == false) goto L62;
        Portrait5thDelegate r31 = r30;
        Context r32 = getContext();
        r31.getClass();
        Intrinsics.checkNotNullParameter(r32, "context");
        r31.t = r32;
    L62:
        this.H2 = this.f.o4(r29, LayerIndex.INDEX_6);
        this.F2 = this.f.o4(r29, LayerIndex.INDEX_3);
        if (this.v2 == false) goto L67;
        GameAbsInteractionDelegate r33 = this.p2;
        if (r33 == null) goto L67;
        r33.d(r8);
    L67:
        R40(this.p1);
        if (tb1.c.a == false) goto L70;
        this.e.ea0(VerifyCodeWidget.class, r21, r21);
    L70:
        this.e.ea0(GameSuggestionWidget.class, r21, r21);
        Ic0();
        Jb0();
        IEnterProcessorService r34 = jc1.k.f(IEnterProcessorService.class);
        if (r34 == null) goto L73;
        r34.interactionBizInterceptor().processPrepareWidget(getContext(), this.e, this.X);
    L73:
        Aa0(new t0(this));
        if (this.D3.booleanValue() == false) goto L76;
    L77:
        Ob0();
    L78:
        this.e.load(2131371661, this.L1);
        goto L93
    L76:
        if (com.bytedance.android.live.core.tetris.widgets.d.d() == true) goto L78;
    L46:
        if (isScreenPortrait() == false) goto L48;
        r23 = (BroadcastPauseStateWidget) this.e.aa0(BroadcastPauseStateWidget.class, r21, r21);
        goto L49
    L48:
        r23 = (BroadcastPauseStateWidget) this.e.X90(2131364575, BroadcastPauseStateLandscapeWidget.class);
    L31:
        r2 = false;
        goto L32
    L23:
        r18 = new AudienceStickerWrapperWidget();
        goto L24
    }

    public void XZ(IRoom r2) {
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("update p0 Wigdet");
        ALogger.i("ComponentX_Batch_Condition", "updateP0Widget");
        ta0();
    }

    public final void Xa(Room r4) {
        RoomContext r0 = this.X;
        if (r0 != null) goto L5;
    L10:
        jc1.k.f(ILiveUxTracer.class).recordSingleTimeStamp("interaction_enter_room");
        kd0(r4);
        if (r4 != null) goto L13;
    L17:
        ALogger.d("NewToolbarLog", "tryMockFallbackShare");
        jd0();
        if (this.X != null) goto L20;
    L24:
        ua0();
        Aa0(new c1());
        return;
    L20:
        if (this.W == null) goto L24;
        int r5 = qu2.a.a;
        if (jc1.k.f(lu2.f.class) == null) goto L24;
        this.X.getPaidLiveTicketSaleManager().e(new d1(this));
        goto L24
    L13:
        if (r4.isMergeVSRoom() == false) goto L17;
        if (pm1.f.o() == null) goto L17;
        pm1.f.o().a();
        MultiTabManagerImpl.e.e();
        goto L17
    L5:
        if (r0.getTextAudioManager().getValue() != null) goto L10;
        if (jc1.k.f(ITextAudioService.class) == null) goto L9;
        this.X.getTextAudioManager().d(jc1.k.f(ITextAudioService.class).getTextAudioManager(this.W));
        goto L10
    L9:
        ALogger.e("AbsInteractionFragment", "init TextAudioManager error, TextAudioService is null");
        goto L10
    }

    public final void Yc0(boolean r4) {
        DataCenter r0 = this.W;
        if (r0 == null) goto L6;
        r0.put("DATA_IS_HIDE_INTERACTION", Boolean.valueOf(r4));
        jc1.k.f(ILinkServiceExternal.class).updateInteractLayoutShow(r4);
        com.bytedance.android.livesdk.utils.t3.c(r4, "setHideInteractLayout");
        return;
    }

    public final void ac0(boolean r5) {
        User r0 = this.S;
        if (r0 != null) goto L6;
        Lc0();
        return;
    L6:
        PrompterDataContext.Companion.getClass();
        Map r1 = PrompterDataContext.a.b(r0);
        if (r5 == false) goto L9;
        String r2 = "add";
    L10:
        r1.put("action_type", r2);
        com.bytedance.android.livesdk.log.u.l().f("livesdk_prompter_privilege_message_show", r1, new Object[0]);
        if (this.S.getUserAttr() != null) goto L13;
        this.S.setUserAttr(new UserAttr());
    L13:
        List r3 = this.S.getUserAttr().getAdminPrivileges();
        if (r3 != null) goto L16;
        r3 = new ArrayList();
        this.S.getUserAttr().setAdminPrivileges(r3);
    L16:
        td1.d.b(r3, r5);
        DataCenter r6 = this.W;
        if (r6 == null) goto L19;
        r6.put("data_user_in_room", this.S);
    L19:
        this.X.getUser().setValue(this.S);
        jc1.k.f(IUserService.class).user().f(this.S.getUserAttr());
        return;
    L9:
        r2 = "delete";
        goto L10
    }

    public final void bL(IRoom r21) {
        String r10 = "ttlive_interaction_opt_data_context_invalid_error";
        if (this.n3.booleanValue() == true) goto L5;
        String r8 = "ttlive_interaction_opt_data_context_invalid_error";
        ALogger.i("COMPONENTX_BEFORE", "beforeOtherLoad AbsInteractionFragment");
        if (jc1.k.f(IRoomModuleService.class) == null) goto L87;
        q81.c r1 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        if (r21 == null) goto L85;
        long r9 = r21.getId();
    L86:
        r1.b(r9, getArguments());
    L88:
        this.T1.d.a = true;
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load other widget start");
        RoomContext r2 = this.X;
        if (r2 != null) goto L91;
    L140:
        RoomContext r3 = this.X;
        if (r3 == null) goto L143;
        int r4 = r3.hashCode();
    L144:
        StringBuilder r6 = new StringBuilder("RoomContext is null: ");
        if (this.X != null) goto L147;
        boolean r5 = true;
    L148:
        r6.append(r5);
        com.bytedance.android.live.core.tetris.widgets.d.g(r6.toString());
        com.bytedance.android.live.core.tetris.widgets.d.g("RoomContext is not valid, this=" + hashCode() + " context=" + r4);
        com.bytedance.android.live.core.tetris.widgets.d.g("Current RoomContext is cleared, return prepareWidget");
        HashMap r7 = new HashMap();
        StringBuilder r11 = new StringBuilder();
        if (this.X != null) goto L151;
        boolean r12 = true;
    L152:
        r11.append(r12);
        r11.append("");
        r7.put("data_context_is_null", r11.toString());
        r7.put("method", "prepareWidget");
        com.bytedance.android.live.core.tetris.widgets.d.e(r8, r7);
    L153:
        boolean r13 = true;
    L154:
        if (r13 == false) goto L156;
        return;
    L156:
        Eb0((Room) r21, new f0(this));
        return;
    L151:
        r12 = false;
        goto L152
    L147:
        r5 = false;
        goto L148
    L143:
        r4 = 0;
        goto L144
    L91:
        if (r2.isCleared() == true) goto L140;
        if (this.E3 == true) goto L96;
        com.bytedance.android.live.core.tetris.widgets.d.g("RoomContext has not init");
        HashMap r14 = new HashMap();
        r14.put("method", "prepareWidget");
        com.bytedance.android.live.core.tetris.widgets.d.e("ttlive_interaction_opt_data_context_not_init_error", r14);
        goto L153
    L96:
        long r15 = System.currentTimeMillis();
        if (this.X.getEnterRoomTime().d(Long.valueOf(r15)) == false) goto L99;
        jc1.k.f(ILinkServiceExternal.class).setEnterRoomTime(r15);
    L99:
        this.H0 = (IShortTermIconFramework) this.X.getShortTermIconFramework().getValue();
        this.L0 = RechargeServices.a(RechargeServices.b());
        r13 = false;
        Boolean r16 = Boolean.valueOf(com.bytedance.android.live.core.utils.z.e(this.W, false));
        boolean r17 = r16.booleanValue();
        int r18 = StickerWrapperWidget.j;
        if (r17 == false) goto L102;
        StickerWrapperWidget r19 = new AnchorStickerWrapperWidget();
    L103:
        this.k1 = r19;
        r19.a = this;
        Function0<Void> r20 = new j1(this);
        Intrinsics.checkNotNullParameter(r20, "degradeCallback");
        r19.b = r20;
        VipIMWidget r22 = new VipIMWidget();
        this.P1 = r22;
        this.e.load(r22);
        if (com.bytedance.android.livesdk.config.setting.i.a.d() == false) goto L111;
        boolean r23 = true;
        if (jc1.k.f(ILiveExpOptService.class).getSceneState(this.W, l61.d.a.g.e).a() != true) goto L111;
    L112:
        if (r23 == true) goto L115;
        this.e.load(2131365431, new CeremonyBorderWidget());
    L115:
        if (this.B3 == true) goto L117;
        Kb0(this.F3);
    L117:
        boolean r24 = k60.b.a();
        com.bytedance.android.livesdk.config.w0 r25 = (com.bytedance.android.livesdk.config.w0) h21.c.getValue();
        if (r25 == null) goto L126;
        if (r25.a() == false) goto L126;
        if (this.D3.booleanValue() == true) goto L126;
        BroadcastPauseStateWidget r26 = null;
    L129:
        LiveMode r27 = this.T;
        if (r27 == null) goto L133;
        if (r26 == null) goto L133;
        r26.eR(r27);
    L133:
        UserPermissionCheckWidget r28 = (UserPermissionCheckWidget) this.e.ea0(UserPermissionCheckWidget.class, r24, r24);
        this.x1 = new LiveShareWidget();
        this.M1 = new CommonGuideWidget();
        int r29 = StickerWrapperWidget.j;
        if (StickerWrapperWidget.b.a(r16.booleanValue()) == false) goto L137;
        this.e.load(2131378275, this.k1);
    L137:
        if (yl.a.getValue().booleanValue() == true) goto L139;
        CommonToastWidget r30 = new CommonToastWidget();
        this.G1 = r30;
        this.e.load(r30, r24, r24);
    L139:
        this.e.load(this.x1, r24, r24);
        this.e.load(this.M1, r24, r24);
    L126:
        if (isScreenPortrait() == false) goto L128;
        r26 = (BroadcastPauseStateWidget) this.e.aa0(BroadcastPauseStateWidget.class, r24, r24);
        goto L129
    L128:
        r26 = (BroadcastPauseStateWidget) this.e.X90(2131364575, BroadcastPauseStateLandscapeWidget.class);
    L111:
        r23 = false;
        goto L112
    L102:
        r19 = new AudienceStickerWrapperWidget();
        goto L103
    L85:
        r9 = 0;
        goto L86
    L87:
        r8 = r8;
        goto L88
    L5:
        if (jc1.k.f(IRoomModuleService.class) == null) goto L11;
        q81.c r31 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        if (r21 == null) goto L9;
        long r32 = r21.getId();
    L10:
        r31.b(r32, getArguments());
    L12:
        this.T1.d.a = true;
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load other widget start");
        RoomContext r33 = this.X;
        if (r33 != null) goto L15;
    L66:
        RoomContext r34 = this.X;
        if (r34 == null) goto L69;
        int r35 = r34.hashCode();
    L70:
        StringBuilder r36 = new StringBuilder("RoomContext is null: ");
        if (this.X != null) goto L73;
        boolean r37 = true;
    L74:
        r36.append(r37);
        com.bytedance.android.live.core.tetris.widgets.d.g(r36.toString());
        com.bytedance.android.live.core.tetris.widgets.d.g("RoomContext is not valid, this=" + hashCode() + " context=" + r35);
        com.bytedance.android.live.core.tetris.widgets.d.g("Current RoomContext is cleared, return prepareWidget");
        HashMap r38 = new HashMap();
        StringBuilder r39 = new StringBuilder();
        if (this.X != null) goto L77;
        boolean r40 = true;
    L78:
        r39.append(r40);
        r39.append("");
        r38.put("data_context_is_null", r39.toString());
        r38.put("method", "prepareWidget");
        com.bytedance.android.live.core.tetris.widgets.d.e(r10, r38);
        return;
    L77:
        r40 = false;
        goto L78
    L73:
        r37 = false;
        goto L74
    L69:
        r35 = 0;
        goto L70
    L15:
        if (r33.isCleared() == true) goto L66;
        if (this.E3 == true) goto L21;
        com.bytedance.android.live.core.tetris.widgets.d.g("RoomContext has not init");
        HashMap r41 = new HashMap();
        r41.put("method", "prepareWidget");
        com.bytedance.android.live.core.tetris.widgets.d.e("ttlive_interaction_opt_data_context_not_init_error", r41);
        return;
    L21:
        long r42 = System.currentTimeMillis();
        if (this.X.getEnterRoomTime().d(Long.valueOf(r42)) == false) goto L24;
        jc1.k.f(ILinkServiceExternal.class).setEnterRoomTime(r42);
    L24:
        this.H0 = (IShortTermIconFramework) this.X.getShortTermIconFramework().getValue();
        this.L0 = RechargeServices.a(RechargeServices.b());
        Boolean r43 = Boolean.valueOf(com.bytedance.android.live.core.utils.z.e(this.W, false));
        boolean r44 = r43.booleanValue();
        int r45 = StickerWrapperWidget.j;
        if (r44 == false) goto L27;
        StickerWrapperWidget r46 = new AnchorStickerWrapperWidget();
    L28:
        this.k1 = r46;
        r46.a = this;
        Function0<Void> r47 = new d0(this);
        Intrinsics.checkNotNullParameter(r47, "degradeCallback");
        r46.b = r47;
        VipIMWidget r48 = new VipIMWidget();
        this.P1 = r48;
        this.e.load(r48);
    L37:
        boolean r49 = false;
    L38:
        if (r49 == true) goto L41;
        this.e.load(2131365431, new CeremonyBorderWidget());
    L41:
        if (this.B3 == true) goto L43;
        Kb0(this.F3);
    L43:
        final boolean r50 = k60.b.a();
        com.bytedance.android.livesdk.config.w0 r51 = (com.bytedance.android.livesdk.config.w0) h21.c.getValue();
        if (r51 == null) goto L52;
        if (r51.a() == false) goto L52;
        if (this.D3.booleanValue() == true) goto L52;
        BroadcastPauseStateWidget r52 = null;
    L55:
        LiveMode r53 = this.T;
        if (r53 == null) goto L59;
        if (r52 == null) goto L59;
        r52.eR(r53);
    L59:
        UserPermissionCheckWidget r54 = (UserPermissionCheckWidget) this.e.ea0(UserPermissionCheckWidget.class, r50, r50);
        this.x1 = new LiveShareWidget();
        this.M1 = new CommonGuideWidget();
        int r55 = StickerWrapperWidget.j;
        if (StickerWrapperWidget.b.a(r43.booleanValue()) == false) goto L63;
        this.e.load(2131378275, this.k1);
    L63:
        if (yl.a.getValue().booleanValue() == true) goto L65;
        CommonToastWidget r56 = new CommonToastWidget();
        this.G1 = r56;
        this.e.load(r56, r50, r50);
    L65:
        this.e.load(this.x1, r50, r50);
        this.e.load(this.M1, r50, r50);
        Eb0((Room) r21, new e0(this, r50));
        return;
    L52:
        if (isScreenPortrait() == false) goto L54;
        r52 = (BroadcastPauseStateWidget) this.e.aa0(BroadcastPauseStateWidget.class, r50, r50);
        goto L55
    L54:
        r52 = (BroadcastPauseStateWidget) this.e.X90(2131364575, BroadcastPauseStateLandscapeWidget.class);
        goto L55
    L30:
        if (com.bytedance.android.livesdk.config.setting.i.a.d() == false) goto L35;
        if (jc1.k.f(ILiveExpOptService.class).getSceneState(this.W, l61.d.a.g.e).a() != true) goto L35;
        boolean r57 = true;
    L36:
        r49 = r57;
    L35:
        r57 = false;
        goto L36
    L27:
        r46 = new AudienceStickerWrapperWidget();
        goto L28
    L9:
        r32 = 0;
        goto L10
    L11:
        r10 = "ttlive_interaction_opt_data_context_invalid_error";
        goto L12
    }

    public final void cb0(ShareReportResult r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.getDeltaIntimacy() > 0) goto L6;
        return;
    L6:
        if (this.q == null) goto L13;
        vlc.d r0 = (vlc.d) this.W.get("data_message_manager");
        if (r0 == null) goto L14;
        r0.j(ag1.c.e(this.q.getId(), r6.getDisplayText(), this.S), true);
        return;
    L14:
        return;
    }

    public final void cd0(zg1.c0 r5) {
        LiveProfileSettingDialog r0 = this.b1;
        Fragment r1 = null;
        if (r0 != null) goto L5;
        User r2 = this.S;
        boolean r3 = isScreenPortrait();
        DataCenter r4 = this.W;
        r5.getClass();
        LiveProfileSettingDialog r6 = new LiveProfileSettingDialog();
        r6.f = r2;
        r6.n = r3;
        r6.h = null;
        r6.i = null;
        r6.g = r4;
        this.b1 = r6;
    L6:
        Fragment r7 = this.b1;
        FragmentManager r8 = getChildFragmentManager();
        int r9 = LiveProfileSettingDialog.o;
        if ((r7 instanceof Fragment) == false) goto L9;
        r1 = r7;
    L9:
        LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "LiveProfileSettingDialog", r10);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r1, r10) == true) goto L18;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        r7.show(r8, "LiveProfileSettingDialog");
        return;
    L18:
        return;
    L5:
        r5.getClass();
        r0.h = null;
        r0.i = null;
        goto L6
    }

    public final void cx(DialogInterface.OnKeyListener r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (((ArrayList) this.Q3).contains(r2) == true) goto L9;
        ((ArrayList) this.Q3).add(r2);
        return;
    }

    public final void dW(Room r5) {
        if (jc1.k.f(IRoomModuleService.class) == null) goto L9;
        q81.c r0 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        if (r5 == null) goto L7;
        long r1 = r5.getId();
    L8:
        r0.a(r1, getArguments());
        goto L9
    L7:
        r1 = 0;
    L9:
        this.T1.b.a = true;
        Dc0(r5);
        this.e.load(2131371661, new P1EndWidget());
    }

    public void dc0(KVData r19) {
        if (this.u == false) goto L623;
        if (r19 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r19.getKey()) == false) goto L8;
        return;
    L8:
        if (r19.getData() == null) goto L719;
        String r2 = r19.getKey();
        com.bytedance.android.livesdk.chatroom.room.p0 r3 = (com.bytedance.android.livesdk.chatroom.room.p0) this.W.get("zygote_event_hub", null);
        r2.getClass();
        boolean r9 = true;
        switch(r2.hashCode()) {
            case -1911031524: goto L230;
            case -1882223254: goto L226;
            case -1836833765: goto L222;
            case -1575056762: goto L218;
            case -1540323875: goto L214;
            case -1477684366: goto L210;
            case -1470664839: goto L206;
            case -1446414526: goto L202;
            case -1381247050: goto L198;
            case -1131769173: goto L194;
            case -1130046128: goto L190;
            case -1093702240: goto L186;
            case -1091008631: goto L182;
            case -1073136005: goto L178;
            case -1060623801: goto L174;
            case -995050167: goto L170;
            case -970251873: goto L166;
            case -797556114: goto L162;
            case -500046878: goto L158;
            case -435307162: goto L154;
            case -424351287: goto L150;
            case -271145422: goto L146;
            case -261927283: goto L142;
            case -81738768: goto L138;
            case -67504953: goto L134;
            case 128742663: goto L130;
            case 139872040: goto L126;
            case 297505362: goto L122;
            case 373304631: goto L118;
            case 428857016: goto L114;
            case 473861234: goto L110;
            case 506917167: goto L106;
            case 638304156: goto L102;
            case 694542470: goto L98;
            case 791939802: goto L94;
            case 949872409: goto L90;
            case 985679695: goto L86;
            case 1008814090: goto L82;
            case 1186479618: goto L78;
            case 1267773627: goto L74;
            case 1324558617: goto L70;
            case 1420969527: goto L66;
            case 1440046856: goto L62;
            case 1446063636: goto L58;
            case 1457041107: goto L54;
            case 1555668198: goto L50;
            case 1631824572: goto L46;
            case 1922181771: goto L42;
            case 1939188655: goto L38;
            case 1995521258: goto L34;
            case 2002249609: goto L30;
            case 2016519596: goto L26;
            case 2049358204: goto L22;
            case 2085465782: goto L18;
            case 2125823940: goto L14;
            default: goto L233;
        };
    L233:
        byte r4 = -1;
    L234:
        long r16 = 0;
        switch(r4) {
            case 0: goto L613;
            case 1: goto L601;
            case 2: goto L539;
            case 3: goto L515;
            case 4: goto L494;
            case 5: goto L489;
            case 6: goto L608;
            case 7: goto L484;
            case 8: goto L483;
            case 9: goto L482;
            case 10: goto L479;
            case 11: goto L477;
            case 12: goto L474;
            case 13: goto L473;
            case 14: goto L472;
            case 15: goto L471;
            case 16: goto L470;
            case 17: goto L453;
            case 18: goto L445;
            case 19: goto L444;
            case 20: goto L443;
            case 21: goto L442;
            case 22: goto L439;
            case 23: goto L412;
            case 24: goto L392;
            case 25: goto L389;
            case 26: goto L384;
            case 27: goto L381;
            case 28: goto L379;
            case 29: goto L378;
            case 30: goto L377;
            case 31: goto L360;
            case 32: goto L356;
            case 33: goto L355;
            case 34: goto L353;
            case 35: goto L351;
            case 36: goto L350;
            case 37: goto L348;
            case 38: goto L344;
            case 39: goto L343;
            case 40: goto L338;
            case 41: goto L336;
            case 42: goto L309;
            case 43: goto L302;
            case 44: goto L298;
            case 45: goto L296;
            case 46: goto L291;
            case 47: goto L288;
            case 48: goto L285;
            case 49: goto L284;
            case 50: goto L280;
            case 51: goto L279;
            case 52: goto L275;
            case 53: goto L241;
            case 54: goto L237;
            default: goto L720;
        };
    L237:
        int r0 = ((Integer) r19.getData()).intValue();
        if (com.bytedance.android.live.core.tetris.widgets.d.d() == false) goto L626;
        Wc0(r0, SystemClock.elapsedRealtime() - ((Long) this.W.get("widget_load_start_time", 0L)).longValue(), "livesdk_framework_loading_duration");
        return;
    L626:
        return;
    L279:
        ((Boolean) r19.getData(Boolean.FALSE)).booleanValue();
        getView();
        return;
    L280:
        com.bytedance.android.live.broadcast.api.model.r0 r1 = (com.bytedance.android.live.broadcast.api.model.r0) r19.getData();
        if (this.u == false) goto L721;
        this.M.removeMessages(100);
        r1.getClass();
        return;
    L721:
        return;
    L284:
        ua0();
        Aa0(new o0(this));
        return;
    L285:
        Boolean r5 = (Boolean) r19.getData();
        if (this.u == false) goto L636;
        Boolean r6 = (Boolean) this.W.get("data_keyboard_status");
        return;
    L636:
        return;
    L288:
        boolean r7 = ((Boolean) this.W.get("interaction_on_first_frame")).booleanValue();
        ALogger.i("DeviceDegrade", "AbsInteractionFragment setHasFirstFrame = " + r7);
        if (r7 == false) goto L638;
        int r8 = com.bytedance.android.livesdk.performance.degrade.f.a;
        return;
    L638:
        return;
    L291:
        zg1.k3 r10 = (zg1.k3) r19.getData();
        if (r10 != null) goto L294;
        return;
    L294:
        od0(r10.a, r10.b);
        return;
    L298:
        Room r11 = this.q;
        if (r11 == null) goto L643;
        ha0(r11);
        return;
    L643:
        return;
    L336:
        lc0(((Boolean) r19.getData()).booleanValue());
        return;
    L343:
        Da0();
        return;
    L344:
        ALogger.i("NewToolbarLog", "CMD_NEW_TOOLBAR_DOUBLE_CHECK");
        if (((String) this.W.get("cmd_new_toolbar_double_check", "")).equals("commerce") == false) goto L654;
        ua0();
        return;
    L654:
        return;
    L350:
        nd0("DATA_BOTTOM_RIGHT_MINI_APP_STATE");
        return;
    L351:
        Xb0();
        return;
    L355:
        ld0("CMD_LINK_EQUAL_TALK_ROOM_STATE_CHANGE");
        return;
    L356:
        if (r3 != null) goto L358;
        return;
    L358:
        if (z60.a.getValue().booleanValue() == false) goto L664;
        r3.getHideLoading().setValue(Boolean.TRUE);
        return;
    L664:
        return;
    L360:
        zg1.k1 r12 = (zg1.k1) r19.getData();
        if (UserSetting.a() == true) goto L363;
    L365:
        if (r12 != null) goto L367;
        return;
    L367:
        if (r12.b == null) goto L667;
        StringBuilder r13 = new StringBuilder("loginInRoom, ");
        String r14 = "succ: ";
        if (r12.a == false) goto L371;
        String r15 = "succ: ";
    L372:
        r13.append(r15);
        r13.append(r12.b.getIdString());
        ALogger.d("AbsInteractionFragment", r13.toString());
        xs2.b r17 = xs2.b.a();
        if (r12.a == true) goto L376;
        r14 = "fail: " + r12.b.getIdString();
    L376:
        r17.post(new zg1.h("login", r14));
        return;
    L371:
        r15 = "fail: ";
        goto L372
    L667:
        return;
    L363:
        if (r12.a == false) goto L365;
        Lc0();
        goto L365
    L377:
        Pb0();
        return;
    L378:
        ua0();
        Aa0(new m0(this));
        return;
    L379:
        ua0();
        Aa0(new n0(this));
        return;
    L412:
        Pair r18 = (Pair) r19.getData();
        HSImageView r20 = this.K;
        if (r20 == null) goto L680;
        FrameLayout.LayoutParams r21 = (FrameLayout.LayoutParams) r20.getLayoutParams();
        r21.topMargin = ((Integer) r18.getFirst()).intValue();
        int r22 = com.bytedance.android.live.core.utils.s1.y();
        if (FoldScreenUtils.f() == true) goto L417;
    L438:
        r21.width = r22;
        r21.gravity |= 1;
        this.K.setLayoutParams(r21);
        return;
    L417:
        if (FoldScreenUtils.c(this.g2) != 0) goto L438;
        if (((Integer) r18.getSecond()).intValue() < 0) goto L421;
        r22 = ((Integer) r18.getSecond()).intValue();
        goto L438
    L421:
        float r23 = com.bytedance.android.live.core.utils.s1.w();
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L433;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L433;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L433;
        if (this.D3.booleanValue() == true) goto L433;
        if ("SAMSUNG".equals(FoldScreenUtils.d()) == false) goto L437;
        r23 = r23 + com.bytedance.android.live.core.utils.s1.A();
    L437:
        r22 = (int) (r23 * 0.5625f);
    L433:
        if ("HUAWEI".equals(FoldScreenUtils.d()) == false) goto L435;
    L436:
        r23 = r23 - com.bytedance.android.live.core.utils.s1.A();
        goto L437
    L435:
        if ("HONOR".equals(FoldScreenUtils.d()) == false) goto L437;
    L680:
        return;
    L439:
        md0("CMD_LINK_MULTI_ROOM_STATE_CHANGE");
        xc0((zg1.l3) r19.getData());
        if ((r19.getData() instanceof zg1.l3) == false) goto L682;
        xs2.b.a().post(new zg1.h("VideoTalkRoom", String.valueOf(((zg1.l3) r19.getData()).a)));
        return;
    L682:
        return;
    L442:
        boolean r24 = ((jd0.g) r19.getData()).a;
        ld0("ForVoiceChat");
        ea0(r24);
        return;
    L443:
        cd0((zg1.c0) r19.getData());
        return;
    L444:
        ua0();
        Aa0(new p0(this));
        return;
    L445:
        DataCenter r25 = this.W;
        if (r25 == null) goto L687;
        i32.a r26 = (i32.a) r25.get("cmd_data_interact_public_screen_height_change", null);
        if (r26 == null) goto L688;
        Object r27 = r19.getData();
        if ((r27 instanceof Integer) == false) goto L689;
        fa0(r26.a - r26.c, r26.b, ((Integer) r27).intValue());
        return;
    L689:
        return;
    L688:
        return;
    L687:
        return;
    L470:
        ((Integer) r19.getData()).intValue();
        return;
    L471:
        I5();
        return;
    L472:
        pc0();
        return;
    L473:
        uc0(((Boolean) r19.getData()).booleanValue(), false);
        return;
    L474:
        md0("CMD_LINK_MULTI_ROOM_STATE_CHANGE");
        mc0((zg1.u1) r19.getData());
        if ((r19.getData() instanceof zg1.u1) == false) goto L701;
        xs2.b.a().post(new zg1.h("MultiAnchor", String.valueOf(((zg1.u1) r19.getData()).f)));
        return;
    L701:
        return;
    L477:
        this.O2 = (List) this.W.get("data_online_changed_list", new ArrayList());
        return;
    L482:
        ld0("DATA_BOTTOM_CARD_CONTAINER_SHOW");
        return;
    L483:
        nd0("DATA_PROMOTION_RIGHT_CARD_CONTAINER_SHOW");
        return;
    L484:
        vlc.d r28 = com.bytedance.android.livesdk.chatroom.utils.n3.e(this.W);
        if (r28 == null) goto L487;
        r28.r(false);
    L487:
        ed0("data_restart_message");
        return;
    L608:
        Object r29 = r19.getData();
        if (this.u == true) goto L611;
        return;
    L611:
        if ((r29 instanceof Integer) == false) goto L715;
        nc0(((Integer) r29).intValue());
        return;
    L715:
        return;
    L613:
        d90 r30 = d90.a;
        if (r30.getValue() != null) goto L616;
        return;
    L616:
        if (((vc1) r30.getValue()).d() == false) goto L718;
        mb0();
        return;
    L718:
        return;
    L720:
        return;
    L241:
        if (getView() == null) goto L628;
        Room r31 = this.q;
        if (r31 != null) goto L245;
    L249:
        boolean r32 = false;
    L251:
        if (r32 == false) goto L261;
        View r33 = getView().findViewById(2131362177);
        if (ub0(true) == false) goto L255;
        int r34 = 0;
    L256:
        UIUtils.setViewVisibility(r33, r34);
        View r35 = getView().findViewById(2131377137);
        if (ub0(true) == false) goto L259;
        int r110 = 0;
    L260:
        UIUtils.setViewVisibility(r35, r110);
        this.W.put("cmd_refresh_bottom_right_banner_content", "");
    L270:
        DataCenter r36 = this.W;
        if (r36 == null) goto L273;
        HashMap r37 = o70.c.a;
        o70.c.a(Integer.valueOf(r36.hashCode())).b(new yn1.a(r32));
    L273:
        md0("DATA_ROOM_BANNER_STATUS");
        return;
    L259:
        r110 = 4;
        goto L260
    L255:
        r34 = 4;
        goto L256
    L261:
        View r38 = getView().findViewById(2131362177);
        if (ub0(false) == false) goto L264;
        int r39 = 0;
    L265:
        UIUtils.setViewVisibility(r38, r39);
        View r40 = getView().findViewById(2131377137);
        if (ub0(false) == false) goto L268;
        int r111 = 0;
    L269:
        UIUtils.setViewVisibility(r40, r111);
        goto L270
    L268:
        r111 = 4;
        goto L269
    L264:
        r39 = 4;
        goto L265
    L245:
        if (r31.getMRoomAuthStatus() == null) goto L249;
        if (this.q.getMRoomAuthStatus().enableBanner() == false) goto L249;
        r32 = true;
        goto L251
    L628:
        return;
    L275:
        if ((r19.getData() instanceof zg1.k3) == true) goto L277;
        return;
    L277:
        if (((zg1.k3) r19.getData()).b > 0) goto L631;
        ld0("CMD_VIDEO_BOTTOM_READY");
        ga0();
        return;
    L631:
        return;
    L296:
        if ((r19.getData() instanceof Boolean) == false) goto L641;
        hb0(((Boolean) r19.getData()).booleanValue());
        return;
    L641:
        return;
    L302:
        if (os.a.getValue().intValue() == 0) goto L304;
        return;
    L304:
        if ((r19.getData() instanceof zg1.m3) == true) goto L306;
        return;
    L306:
        if (((zg1.m3) r19.getData()).b != 0) goto L647;
        nd0("DATA_RIGHT_BOTTOM_BANNER_SHOW");
        return;
    L647:
        return;
    L309:
        if (jc1.k.f(IRoomModuleService.class) == null) goto L314;
        q81.c r41 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        Room r42 = this.q;
        if (r42 == null) goto L313;
        r16 = r42.getId();
    L313:
        r41.e(r16, getArguments());
    L314:
        WidgetService.getInstance().onWidgetLoadEnd(2);
        if (this.u3 != null) goto L317;
    L319:
        if (r3 == null) goto L321;
        r3.getP2WidgetLoaded().setValue(Boolean.TRUE);
    L321:
        this.T1.c.b.a(Boolean.TRUE);
        if (com.bytedance.android.livesdk.model.a0.d() == false) goto L325;
        com.bytedance.android.livesdk.model.a0.e("CMD_P2_WIDGET_LOADED");
        Qb0();
    L325:
        if (RoomContext.getShared(this.W) != null) goto L327;
    L331:
        Room r43 = this.q;
        if (r43 == null) goto L334;
        String r44 = r43.getIdStr();
    L335:
        Yb0(r44, "p2");
        return;
    L334:
        r44 = null;
        goto L335
    L327:
        if (RoomContext.getShared(this.W).getDrawCleanScreenViewModel() == null) goto L331;
        if (RoomContext.getShared(this.W).getDrawCleanScreenViewModel().getValue() == null) goto L331;
        ((DrawCleanScreenViewModel) RoomContext.getShared(this.W).getDrawCleanScreenViewModel().getValue()).changeRoomClear("cmd_p2_widget_loaded");
        goto L331
    L317:
        if (EX() == false) goto L319;
        this.u3.E();
        goto L319
    L338:
        if (jc1.k.f(IRoomModuleService.class) == null) goto L651;
        q81.c r45 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        String r46 = (String) r19.getData();
        Room r47 = this.q;
        if (r47 == null) goto L342;
        r16 = r47.getId();
    L342:
        r45.k(r46, r16, getArguments());
        return;
    L651:
        return;
    L348:
        if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L656;
        Lc0();
        return;
    L656:
        return;
    L353:
        if ((r19.getData() instanceof Boolean) == false) goto L660;
        uc0(!((Boolean) r19.getData()).booleanValue(), true);
        return;
    L660:
        return;
    L381:
        if (os.a.getValue().intValue() != 1) goto L672;
        md0("DATA_RIGHT_BOTTOM_BANNER_CONTAINER_SHOW");
        return;
    L672:
        return;
    L384:
        if ((r19.getData() instanceof Boolean) == true) goto L386;
        return;
    L386:
        if (((Boolean) r19.getData()).booleanValue() == false) goto L675;
        uc0(false, false);
        return;
    L675:
        return;
    L389:
        if (((Boolean) r19.getData()).booleanValue() == false) goto L677;
        Mb0();
        this.W.removeObserver("match_tab_all_loaded", this);
        return;
    L677:
        return;
    L392:
        if (jc1.k.f(IRoomModuleService.class) == null) goto L397;
        q81.c r48 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        Room r49 = this.q;
        if (r49 == null) goto L396;
        r16 = r49.getId();
    L396:
        r48.g(r16, getArguments());
    L397:
        WidgetService.getInstance().onWidgetLoadEnd(1);
        if (this.u3 != null) goto L400;
    L402:
        if (r3 == null) goto L404;
        r3.getP1WidgetLoaded().setValue(Boolean.TRUE);
    L404:
        this.T1.b.b.a(Boolean.TRUE);
        if (com.bytedance.android.livesdk.model.a0.c() == false) goto L407;
        com.bytedance.android.livesdk.model.a0.e("CMD_P1_WIDGET_LOADED");
        Qb0();
    L407:
        Room r50 = this.q;
        if (r50 == null) goto L410;
        String r51 = r50.getIdStr();
    L411:
        Yb0(r51, "p1");
        return;
    L410:
        r51 = null;
        goto L411
    L400:
        if (EX() == false) goto L402;
        this.u3.G();
        goto L402
    L453:
        if (SettingKeyUtils.a() == true) goto L462;
        BaseWebDialogFragment r52 = this.F;
        if (r52 == null) goto L691;
        r52.dismissAllowingStateLoss();     // Catch: Exception -> L458
        return;
    L458:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r53 = DialogFragmentLancet.sLastShowStack;
        if (r53 == null) goto L692;
        com.bytedance.crash.d.d(r53, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L692:
        return;
    L691:
        return;
    L462:
        HybridDialog r54 = this.G;
        if (r54 == null) goto L694;
        r54.dismissAllowingStateLoss();     // Catch: Exception -> L466
        return;
    L466:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r55 = DialogFragmentLancet.sLastShowStack;
        if (r55 == null) goto L695;
        com.bytedance.crash.d.d(r55, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L695:
        return;
    L694:
        return;
    L479:
        if (g1() == false) goto L724;
        nd0("CMD_INTERACT_PLAYER_VIEW_CHANGE");
        return;
    L724:
        return;
    L489:
        if ((r19.getData() instanceof i32.a) == false) goto L708;
        i32.a r56 = (i32.a) r19.getData();
        fa0(r56.a - r56.c, r56.b, 0);
        if (this.D3.booleanValue() == false) goto L709;
        this.W.put("cmd_update_sticker_position", new zg1.c3(r56.a + r56.b));
        return;
    L709:
        return;
    L708:
        return;
    L494:
        if ((r19.getData() instanceof zg1.z0) == true) goto L497;
        return;
    L497:
        if (g1() == false) goto L513;
        zg1.z0 r57 = (zg1.z0) r19.getData();
        if (getView() == null) goto L513;
        if (this.u == false) goto L513;
        if (getContext() == null) goto L513;
        if (this.q.getLinkMap() != null) goto L508;
    L510:
        r9 = false;
    L511:
        if (r9 == true) goto L513;
        float r58 = com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.b.a;
        DataCenter r59 = this.W;
        int r60 = pT();
        tb0();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.b.a(r59, r57, r60);
        goto L513
    L508:
        if (this.q.getLinkMap().containsKey(String.valueOf(1)) == false) goto L510;
    L513:
        qc0((zg1.z0) r19.getData());
        md0("CMD_LINK_CROSS_ROOM_STATE_CHANGE");
        xs2.b.a().post(new zg1.h("LinkCrossRoom", String.valueOf(((zg1.z0) r19.getData()).a)));
        return;
    L515:
        if (jc1.k.f(IRoomModuleService.class) == null) goto L521;
        q81.c r61 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        Room r62 = this.q;
        if (r62 == null) goto L519;
        r16 = r62.getId();
    L519:
        r61.i(r16, getArguments());
    L521:
        if (this.D3.booleanValue() == false) goto L523;
        ed0("cmd_p0_widget_loaded");
    L523:
        WidgetService.getInstance().onWidgetLoadEnd(0);
        if (this.u3 != null) goto L526;
    L528:
        if (r3 == null) goto L530;
        r3.getP0WidgetLoaded().postValue(Boolean.TRUE);
    L530:
        this.T1.a.b.a(Boolean.TRUE);
        Aa0(new q0());
        if (ai.a.getValue().booleanValue() == false) goto L533;
        xs2.b.a().post(new tz.a());
    L533:
        Room r63 = this.q;
        if (r63 == null) goto L536;
        String r64 = r63.getIdStr();
    L537:
        Yb0(r64, "p0");
        return;
    L536:
        r64 = null;
        goto L537
    L526:
        if (EX() == false) goto L528;
        this.u3.x();
        goto L528
    L539:
        if ((r19.getData() instanceof com.bytedance.android.livesdk.chatroom.model.y3) == false) goto L544;
        if (((com.bytedance.android.livesdk.chatroom.model.y3) r19.getData()).a == false) goto L544;
        return;
    L544:
        if (jc1.k.f(IRoomModuleService.class) == null) goto L558;
        q81.c r65 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        Room r66 = this.q;
        if (r66 == null) goto L548;
        long r67 = r66.getId();
    L549:
        r65.h(r67, getArguments());
        if (this.D3.booleanValue() == false) goto L558;
        if (com.bytedance.android.livesdk.config.setting.a.a() == false) goto L558;
        y50.c r68 = y50.c.d;
        y50.c.d();
        q81.c r69 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        Room r70 = this.q;
        if (r70 == null) goto L556;
        long r71 = r70.getId();
    L557:
        r69.m(r71);
        r68.a("inter_load_total");
        y50.c.e();
        goto L558
    L556:
        r71 = 0;
        goto L557
    L548:
        r67 = 0;
    L558:
        fh1.d.a();
        WidgetService.getInstance().onWidgetLoadEnd(3);
        if (this.u3 != null) goto L561;
    L563:
        int r72 = k60.b.g();
        if (r72 != 1) goto L566;
    L571:
        k60.b.i();
    L573:
        if (jc1.k.f(IPerformanceManager.class) == null) goto L579;
        IPerformanceManager r73 = jc1.k.f(IPerformanceManager.class);
        Room r75 = this.q;
        if (r75 == null) goto L577;
        long r76 = r75.getId();
    L578:
        r73.forceStopLoadStallMonitor(r76, false);
        jc1.k.f(IPerformanceManager.class).onModuleStop("live_enter_room");
        goto L579
    L577:
        r76 = 0;
    L579:
        if (r3 == null) goto L582;
        MutableLiveData r77 = r3.getAllWidgetLoaded();
        Boolean r78 = Boolean.TRUE;
        r77.postValue(r78);
        r3.getAllWidgetLoadedV2().setValue(r78);
    L582:
        if (this.D3.booleanValue() == false) goto L584;
    L592:
        ALogger.i("WidgetLoadProperty", "all widget loaded");
        this.T1.d.b.a(Boolean.TRUE);
        Wc0(-1, SystemClock.elapsedRealtime() - ((Long) this.W.get("widget_load_start_time", 0L)).longValue(), "livesdk_all_components_loading_duration");
        za0();
        if (com.bytedance.android.livesdk.model.a0.a() == false) goto L595;
        com.bytedance.android.livesdk.model.a0.e("CMD_WIDGET_LOADED");
        Qb0();
    L595:
        Da0();
        Room r79 = this.q;
        if (r79 == null) goto L598;
        String r80 = r79.getIdStr();
    L599:
        Yb0(r80, "all");
        return;
    L598:
        r80 = null;
        goto L599
    L584:
        if (((Boolean) this.W.get("data_current_is_preview", Boolean.FALSE)).booleanValue() == false) goto L586;
        String r81 = ILiveRoomControllerProvider.ProviderSource.PREVIEW.name();
        int r82 = ((Integer) this.W.get("data_current_unique_id_preview", 0)).intValue();
    L588:
        if (jc1.k.f(IHostGameCP.class) == null) goto L592;
        if (getContext() == null) goto L592;
        jc1.k.f(IHostGameCP.class).onWidgetLoaded(getContext(), this.q, r82, r81);
        goto L592
    L586:
        r81 = ILiveRoomControllerProvider.ProviderSource.DEFAULT.name();
        r82 = ((Integer) this.W.get("room_controller_unique_key", 0)).intValue();
        goto L588
    L566:
        if (r72 == 3) goto L571;
        if (r72 != 2) goto L573;
        int r83 = cu2.a.a;
        cu2.a.a.b();
        goto L573
    L561:
        if (EX() == false) goto L563;
        this.u3.F();
        goto L563
    L601:
        if (g1() == true) goto L604;
        return;
    L604:
        if (this.D == null) goto L608;
        if ((r19.getData() instanceof VideoViewParams) == false) goto L608;
        VideoViewParams r84 = (VideoViewParams) r19.getData();
        this.D.n1(r84.a, r84.b, r84.c);
        goto L608
    L14:
        if (r2.equals("cmd_send_priority_widget_load_track") == false) goto L233;
        r4 = 54;
        goto L234
    L18:
        if (r2.equals("data_room_banner_status") == false) goto L233;
        r4 = 53;
        goto L234
    L22:
        if (r2.equals("cmd_video_video_bottom_ready") == false) goto L233;
        r4 = 52;
        goto L234
    L26:
        if (r2.equals("mic_room_widget_show") == false) goto L233;
        r4 = 51;
        goto L234
    L30:
        if (r2.equals("cmd_sticker_is_selected") == false) goto L233;
        r4 = 50;
        goto L234
    L34:
        if (r2.equals("cmd_specific_behavior_loaded") == false) goto L233;
        r4 = 49;
        goto L234
    L38:
        if (r2.equals("data_screen_record_is_open") == false) goto L233;
        r4 = 48;
        goto L234
    L42:
        if (r2.equals("interaction_on_first_frame") == false) goto L233;
        r4 = 47;
        goto L234
    L46:
        if (r2.equals("cmd_video_orientation_changed") == false) goto L233;
        r4 = 46;
        goto L234
    L50:
        if (r2.equals("cmd_media_room_hide_share") == false) goto L233;
        r4 = 45;
        goto L234
    L54:
        if (r2.equals("cmd_fs_widget_loaded") == false) goto L233;
        r4 = 44;
        goto L234
    L58:
        if (r2.equals("data_right_bottom_banner_show") == false) goto L233;
        r4 = 43;
        goto L234
    L62:
        if (r2.equals("cmd_p2_widget_loaded") == false) goto L233;
        r4 = 42;
        goto L234
    L66:
        if (r2.equals("data_is_score_open") == false) goto L233;
        r4 = 41;
        goto L234
    L70:
        if (r2.equals("data_toolbar_visible") == false) goto L233;
        r4 = 40;
        goto L234
    L74:
        if (r2.equals("cmd_text_message_widget_loaded") == false) goto L233;
        r4 = 39;
        goto L234
    L78:
        if (r2.equals("cmd_new_toolbar_double_check") == false) goto L233;
        r4 = 38;
        goto L234
    L82:
        if (r2.equals("cmd_refresh_user_in_room") == false) goto L233;
        r4 = 37;
        goto L234
    L86:
        if (r2.equals("data_bottom_right_state") == false) goto L233;
        r4 = 36;
        goto L234
    L90:
        if (r2.equals("cmd_effect_start") == false) goto L233;
        r4 = 35;
        goto L234
    L94:
        if (r2.equals("data_self_is_silenced") == false) goto L233;
        r4 = 34;
        goto L234
    L98:
        if (r2.equals("cmd_equal_talkroom_state_change") == false) goto L233;
        r4 = 33;
        goto L234
    L102:
        if (r2.equals("cmd_widget_is_show") == false) goto L233;
        r4 = 32;
        goto L234
    L106:
        if (r2.equals("data_login_event") == false) goto L233;
        r4 = 31;
        goto L234
    L110:
        if (r2.equals("cmd_update_admin_record") == false) goto L233;
        r4 = 30;
        goto L234
    L114:
        if (r2.equals("cmd_specific_widget_loaded") == false) goto L233;
        r4 = 29;
        goto L234
    L118:
        if (r2.equals("cmd_specific_view_loaded") == false) goto L233;
        r4 = 28;
        goto L234
    L122:
        if (r2.equals("data_right_bottom_banner_container_show") == false) goto L233;
        r4 = 27;
        goto L234
    L126:
        if (r2.equals("DATA_DISCONNECT_LINK") == false) goto L233;
        r4 = 26;
        goto L234
    L130:
        if (r2.equals("match_tab_all_loaded") == false) goto L233;
        r4 = 25;
        goto L234
    L134:
        if (r2.equals("cmd_p1_widget_loaded") == false) goto L233;
        r4 = 24;
        goto L234
    L138:
        if (r2.equals("cmd_adjust_video_interact_stream_bottom") == false) goto L233;
        r4 = 23;
        goto L234
    L142:
        if (r2.equals("cmd_video_talkroom_state_change") == false) goto L233;
        r4 = 22;
        goto L234
    L146:
        if (r2.equals("cmd_interact_audio") == false) goto L233;
        r4 = 21;
        goto L234
    L150:
        if (r2.equals("cmd_show_fans_club_setting") == false) goto L233;
        r4 = 20;
        goto L234
    L154:
        if (r2.equals("cmd_specific_behavior_un_loaded") == false) goto L233;
        r4 = 19;
        goto L234
    L158:
        if (r2.equals("data_special_enter_anim_extra_height") == false) goto L233;
        r4 = 18;
        goto L234
    L162:
        if (r2.equals("cmd_close_h5_dialog") == false) goto L233;
        r4 = 17;
        goto L234
    L166:
        if (r2.equals("data_member_count") == false) goto L233;
        r4 = 16;
        goto L234
    L170:
        if (r2.equals("cmd_hide_all_float_fragment") == false) goto L233;
        r4 = 15;
        goto L234
    L174:
        if (r2.equals("paid_live_paid_info_update") == false) goto L233;
        r4 = 14;
        goto L234
    L178:
        if (r2.equals("data_talk_room_capture_audio_notification_show_state") == false) goto L233;
        r4 = 13;
        goto L234
    L182:
        if (r2.equals("cmd_multi_state_change") == false) goto L233;
        r4 = 12;
        goto L234
    L186:
        if (r2.equals("data_online_changed_list") == false) goto L233;
        r4 = 11;
        goto L234
    L190:
        if (r2.equals("cmd_interact_player_view_change") == false) goto L233;
        r4 = 10;
        goto L234
    L194:
        if (r2.equals("data_bottom_card_container_show") == false) goto L233;
        r4 = 9;
        goto L234
    L198:
        if (r2.equals("data_promotion_right_card_container_show") == false) goto L233;
        r4 = 8;
        goto L234
    L202:
        if (r2.equals("data_restart_message") == false) goto L233;
        r4 = 7;
        goto L234
    L206:
        if (r2.equals("cmd_enter_room_multil_link_room_mode_sysnc") == false) goto L233;
        r4 = 6;
        goto L234
    L210:
        if (r2.equals("cmd_data_interact_public_screen_height_change") == false) goto L233;
        r4 = 5;
        goto L234
    L214:
        if (r2.equals("cmd_pk_state_change") == false) goto L233;
        r4 = 4;
        goto L234
    L218:
        if (r2.equals("cmd_p0_widget_loaded") == false) goto L233;
        r4 = 3;
        goto L234
    L222:
        if (r2.equals("cmd_widget_loaded") == false) goto L233;
        r4 = 2;
        goto L234
    L226:
        if (r2.equals("live_render_view_params") == false) goto L233;
        r4 = 1;
        goto L234
    L230:
        if (r2.equals("data_right_card_loaded") == false) goto L233;
        r4 = 0;
        goto L234
    L719:
        return;
    }

    public final void eR(LiveMode r4) {
        this.T = r4;
        this.X.getLiveMode().d(r4);
        LiveMode r0 = LiveMode.MEDIA;
        if (r4 != r0) goto L8;
        com.bytedance.android.livesdk.log.filter.o r5 = com.bytedance.android.livesdk.log.u.l().c(am2.w.class);
        if (r5 == null) goto L8;
        r5.setData(new am2.w(r0, "1"));
    L8:
        ILinkServiceExternal r6 = jc1.k.f(ILinkServiceExternal.class);
        if (r6 == null) goto L12;
        r6.updateLiveMode(this.T);
        return;
    }

    public final void ed0(String r12) {
        vlc.d r4 = com.bytedance.android.livesdk.chatroom.utils.n3.e(this.W);
        RoomContext r5 = com.bytedance.live.datacontext.d.e(RoomContext.class, RoomContext.class);
    L64:
        e = move-exception;
        PublicScreenTraceMonitor.l(r12 + ":startMessage error," + e, System.currentTimeMillis());
        if (jc1.k.f(IHostContext.class).isLocalTest() == false) goto L70;
        throw e;
    L70:
        return;
    L4:
        if (this.q == null) goto L51;
        if (r5 == null) goto L51;
        if (r5.getInteractivityContext().getValue() == null) goto L51;
        if (r4 == null) goto L51;
        if (this.q != null) goto L12;
    L46:
        r4.startMessage();     // Catch: Exception -> L64
        PublicScreenTraceMonitor.l(r12.concat(":startMessage"), System.currentTimeMillis());     // Catch: Exception -> L64
        Ea0();     // Catch: Exception -> L64
        if (Looper.myLooper() != Looper.getMainLooper()) goto L49;
        boolean r0 = true;
    L50:
        String r1 = ThreadMethodProxy.currentThread().getName();     // Catch: Exception -> L64
        com.bytedance.android.livesdk.log.b0.o().getClass();     // Catch: Exception -> L64
        com.bytedance.android.live.core.log.g.a("ttlive_msg", "start query message, isMain=" + r0 + ", name=" + r1);     // Catch: Exception -> L64
        return;
    L49:
        r0 = false;
        goto L50
    L12:
        if (pm1.f.r() == null) goto L16;
        pm1.f.r().g();     // Catch: Exception -> L64
        vp1.e.a.a(r4, this.W);     // Catch: Exception -> L64
    L16:
        HashMap r6 = new HashMap();     // Catch: Exception -> L64
        if (((Boolean) dl0.a.getValue()).booleanValue() == true) goto L21;
        if (PublicScreenABHelper.P == true) goto L21;
    L30:
        if (j80.a.getValue().booleanValue() == false) goto L45;
        com.bytedance.android.livesdk.log.filter.n0 r7 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);     // Catch: Exception -> L64
        if (r7 != null) goto L34;
    L38:
        com.bytedance.android.livesdk.log.filter.z r2 = com.bytedance.android.livesdk.log.u.l().c(am2.n.class);     // Catch: Exception -> L64
        if (r2 == null) goto L45;
        if ((r2 instanceof com.bytedance.android.livesdk.log.filter.z) == false) goto L45;
        com.bytedance.android.livesdk.log.filter.z r3 = r2;     // Catch: Exception -> L64
        if (((com.bytedance.android.livesdk.log.filter.a) r3).b.containsKey("is_other_channel") == false) goto L45;
        r6.put("is_other_channel", (String) ((com.bytedance.android.livesdk.log.filter.a) r3).b.get("is_other_channel"));     // Catch: Exception -> L64
        goto L45
    L34:
        if ((r7 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L38;
        com.bytedance.android.livesdk.log.filter.n0 r8 = r7;     // Catch: Exception -> L64
        if (((com.bytedance.android.livesdk.log.filter.a) r8).b.containsKey("enter_from_merge") == false) goto L38;
        r6.put("enter_from_merge", (String) ((com.bytedance.android.livesdk.log.filter.a) r8).b.get("enter_from_merge"));     // Catch: Exception -> L64
    L45:
        com.bytedance.android.livesdk.utils.d4.j(r4, r6);     // Catch: Exception -> L64
    L21:
        if (this.q.isMediaRoom() == true) goto L30;
        if (this.q.isMergeVSRoom() == true) goto L30;
        if (this.D3.booleanValue() == true) goto L30;
        if (this.q.getRoomLayout() == 2) goto L30;
        r6.put("skip_first_fetch", "1");     // Catch: Exception -> L64
    L51:
        StringBuilder r9 = new StringBuilder();     // Catch: Exception -> L64
        if (this.q != null) goto L54;
        r9.append("room is null|");     // Catch: Exception -> L64
    L54:
        if (r5 != null) goto L56;
        r9.append("roomContext is null|");     // Catch: Exception -> L64
    L56:
        if (r5 != null) goto L58;
    L60:
        if (r4 != null) goto L62;
        r9.append("messageManager is null");     // Catch: Exception -> L64
    L62:
        PublicScreenTraceMonitor.l(r12 + ":startMessage fail," + r9, System.currentTimeMillis());     // Catch: Exception -> L64
        return;
    L58:
        if (r5.getInteractivityContext().getValue() != null) goto L60;
        r9.append("interactivityContext is null|");     // Catch: Exception -> L64
        goto L60
    }

    public void fb0(final String r7) {
        ALogger.d("AbsInteractionFragment", "handleStreamControlMessage controlMessage: " + r7 + ", mRoom: " + this.q + ", mIsViewValid: " + this.u);
        if (this.u == true) goto L5;
        return;
    L5:
        if (this.q != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r7) == true) goto L32;
        StreamControlInfo.ControlParams r2 = (StreamControlInfo.ControlParams) GsonHelper.get().fromJson(r7, StreamControlInfo.ControlParams.class);     // Catch: Exception -> L23
        if (r2 != null) goto L12;
    L21:
        ALogger.e("AbsInteractionFragment", "handleStreamControlMessage no need handle controlParams: " + r2);     // Catch: Exception -> L23
        return;
    L12:
        if (Ub0(r2.type) == false) goto L21;
        ALogger.d("AbsInteractionFragment", "handleStreamControlMessage filterRequired: " + r2.filterRequired + ", random: " + r2.random);     // Catch: Exception -> L23
        if (r2.filterRequired == false) goto L20;
        long r0 = r2.random;     // Catch: Exception -> L23
        if (r0 <= 0) goto L19;
        ((SingleSubscribeProxy) Single.timer(r0, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new com.bytedance.android.livesdk.chatroom.ui.j(this, r7), new com.bytedance.android.livesdk.chatroom.ui.k());     // Catch: Exception -> L23
        return;
    L19:
        Sc0(r7);     // Catch: Exception -> L23
        return;
    L20:
        zc0(r7, r2);     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        ALogger.e("AbsInteractionFragment", "handleStreamControlMessage e: " + e);
        return;
    }

    public boolean gc0(MotionEvent r3) {
        DiggContext.a r0 = DiggContext.Companion;
        DataCenter r1 = this.W;
        r0.getClass();
        DiggContext r2 = DiggContext.a.a(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.getDiggWidget().getValue() != null) goto L7;
        return false;
    L7:
        return ((u32.k) r2.getDiggWidget().getValue()).D8(r3);
    }

    public final void handleMsg(Message r4) {
        if (this.u == true) goto L5;
        return;
    L5:
        Object r0 = r4.obj;
        if ((r0 instanceof ApiServerException) == false) goto L10;
        Kc0((Exception) r0);
        return;
    L10:
        if ((r0 instanceof Exception) == false) goto L13;
        Logger.d("AbsInteractionFragment", "unknown exception " + ((Exception) r0).toString());
        return;
    L13:
        int r5 = r4.what;
        if (r5 != 100) goto L17;
        this.W.put("data_has_sticker_effective", Boolean.TRUE);
        return;
    L17:
        if (r5 != 200) goto L21;
        xs2.b.a().post(new u22.j(true, 2));
        return;
    }

    public void hb0(boolean r4) {
        Room r0 = this.q;
        if (r0 == null) goto L12;
        if (r0.getMRoomAuthStatus() == null) goto L12;
        RoomAuthStatus r1 = this.q.getMRoomAuthStatus();
        if (r4 == false) goto L9;
        long r2 = 2;
    L10:
        r1.setShowShare(r2);
        goto L12
    L9:
        r2 = 1;
    L12:
        if (this.D3.booleanValue() == false) goto L14;
        return;
    L14:
        if (this.J2 != null) goto L17;
        return;
    L17:
        if (((Boolean) h21.a.getValue()).booleanValue() == false) goto L19;
        return;
    L19:
        if (r4 == false) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r5 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.b(this.W);
        ToolbarButton r3 = ToolbarButton.SHARE;
        r5.i(r3.extended());
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.b(this.W).d(r3, this.J2);
        return;
    L21:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r6 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.b(this.W);
        ToolbarButton r7 = ToolbarButton.SHARE;
        r6.k(r7, this.J2);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.b(this.W).c(r7.extended());
    }

    public final void hc0(final EnterRoomExtra r4) {
        RoomContext r0 = this.X;
        if (r0 != null) goto L5;
    L7:
        final vlc.d r1 = (vlc.d) this.W.get("data_message_manager");
        if (r4 != null) goto L10;
    L16:
        if (r4 != null) goto L18;
        return;
    L18:
        if (r4.memberMessage == null) goto L25;
        if (r1 == null) goto L26;
        WeakHandler r2 = this.M;
        if (r2 == null) goto L27;
        r2.post(new com.bytedance.android.livesdk.chatroom.ui.i(this, r1, r4));
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L10:
        if (r4.cityName == null) goto L16;
        RoomContext r3 = this.X;
        if (r3 == null) goto L16;
        if (r3.isCleared() == true) goto L16;
        this.X.getUserCityName().setValue(r4.cityName);
        goto L16
    L5:
        if (r0.isCleared() == false) goto L7;
        ALogger.e("SlideTaskDelay", "AbsInteractionFragment onEnterRoomUpdate dataContext isCleared");
        goto L7
    }

    public final void hd0(MotionEvent r7) {
        boolean r0 = pX();
        boolean r2 = false;
        if (xb0((Room) this.X.getRoom().getValue()) == true) goto L5;
        DataCenter r1 = this.W;
        Lazy r4 = ClearScreenHelper.a;
        if (com.bytedance.android.livesdk.config.m1.a.getValue().booleanValue() == false) goto L54;
        if (r1 == null) goto L54;
        if (com.bytedance.android.live.core.utils.z.l(r1) != true) goto L54;
        r2 = true;
    L54:
        if (r2 == true) goto L65;
        dd0(!r0, r7);
        return;
    L65:
        return;
    L5:
        if (ra0() == false) goto L39;
        if (gb0() == false) goto L39;
        Rect r3 = new Rect();
        ILivePlayerClient r5 = LivePlatformPlayerManager.a(((Room) this.X.getRoom().getValue()).getRoomId(), false);
        if (r5 != null) goto L11;
    L15:
        if (r2 == true) goto L17;
        wa0(!r0, r7);
        return;
    L17:
        if (r7.getRawX() >= r3.left) goto L19;
    L36:
        dd0(!r0, r7);
        return;
    L19:
        if (r7.getRawX() > r3.right) goto L36;
        if (r7.getRawY() < r3.top) goto L36;
        if (r7.getRawY() > r3.bottom) goto L36;
        if (((Boolean) ClearScreenHelper.e.getValue()).booleanValue() == false) goto L35;
        RoomContext r6 = this.X;
        if (r6 == null) goto L35;
        if (((Boolean) r6.isCleanMode().getValue()).booleanValue() == false) goto L35;
        Boolean r8 = this.D3;
        if (r8 == null) goto L35;
        if (r8.booleanValue() == true) goto L35;
        dd0(!r0, r7);
        return;
    L35:
        wa0(!r0, r7);
        return;
    L11:
        if (r5.getRenderView() == null) goto L15;
        if (r5.getRenderView().getSelfView() == null) goto L15;
        r5.getRenderView().getSelfView().getGlobalVisibleRect(r3);
        r2 = true;
    L39:
        if (gb0() == true) goto L44;
        if (ra0() == false) goto L44;
        dd0(!r0, r7);
        return;
    L44:
        if (gb0() == true) goto L46;
        return;
    L46:
        if (ra0() == true) goto L63;
        wa0(!r0, r7);
        return;
    }

    public void ic0(ToolbarClearScreenEvent r6) {
        ALogger.d("ClearScreenManager", "接收到ToolbarClearScreenEvent，此时clear值为" + r6.b);
        if (isScreenPortrait() == true) goto L8;
        if (VrUtils.t(this.W, false) == true) goto L8;
        return;
    L8:
        if (ClearScreenHelper.i(this.W) == false) goto L17;
        DataCenter r0 = this.W;
        if (r0 != null) goto L12;
    L16:
        gs1.b.b(false);
        goto L17
    L12:
        if (((Boolean) r0.get("cmd_all_widget_loaded", Boolean.FALSE)).booleanValue() == true) goto L16;
        if (r6.a == ToolbarClearScreenEvent.Source.SlideRoom) goto L16;
        gs1.b.b(r6.b);
    L17:
        boolean r1 = RTLUtil.isAppRTL(getContext());
        int r2 = this.A.getWidth();
        if (r1 == false) goto L21;
        r2 = -r2;
    L21:
        if (r6.b == false) goto L35;
        ViewPropertyAnimator r3 = this.A.animate();
        if (r6.c == false) goto L25;
        r3.alpha(0.0f);
    L34:
        r3.setDuration(this.n).setInterpolator(new om3.c()).setListener(new n(this)).start();
        Yc0(true);
        ja0();
        Xc0(8);
    L50:
        this.W.put("data_hide_screen", Boolean.valueOf(pX()));
        com.bytedance.android.livesdk.sharedpref.e r7 = com.bytedance.android.livesdk.sharedpref.b.V;
        Boolean r4 = Boolean.valueOf(pX());
        r7.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r7, r4);
        return;
    L25:
        r3.x(r2);
        if (VrUtils.u(this.W, false) == false) goto L34;
        if (com.bytedance.android.livesdk.utils.landscape.e.b(false, this.q) == false) goto L34;
        Object r8 = Ua0().a;
        if (r8 == null) goto L34;
        View r9 = ((com.bytedance.android.livesdk.chatroom.widget.landscape.r) r8).a;
        if (r9 == null) goto L34;
        r3.x(r9.getWidth());
        goto L34
    L35:
        ViewPropertyAnimator r5 = this.A.animate();
        if (r6.c == false) goto L38;
        r5.alpha(1.0f);
    L39:
        r5.setDuration(this.n).setInterpolator(new om3.c()).setListener(new o(this)).start();
        if (jc1.k.f(IPerformanceManager.class) == null) goto L42;
        jc1.k.f(IPerformanceManager.class).onLeaveFullScreenClean();
    L42:
        Yc0(false);
        ja0();
        if (Ta0() == null) goto L50;
        ViewLayerDelegate<com.bytedance.android.livesdk.widgetdescriptor.e0> r10 = Ta0();
        ((d90.d) this.f3).f.getClass();
        com.bytedance.android.livesdk.chatroom.tetris.portrait.a r11 = (com.bytedance.android.livesdk.chatroom.tetris.portrait.a) r10.g(d90.d.a.H0, com.bytedance.android.livesdk.chatroom.tetris.portrait.a.class);
        if (r11 == null) goto L50;
        if (wt2.a.e(this.D3) == true) goto L49;
        r11.t(8);
        goto L50
    L49:
        r11.i();
        goto L50
    L38:
        r5.x(0.0f);
        goto L39
    }

    public final void id0(boolean r4) {
        if (r4 == false) goto L37;
        DiggContext.a r5 = DiggContext.Companion;
        DataCenter r0 = this.W;
        r5.getClass();
        DiggContext r6 = DiggContext.a.a(r0);
        if (this.u == false) goto L36;
        r8 r1 = this.g1;
        if (r1 != null) goto L8;
    L9:
        if (r6 != null) goto L11;
    L14:
        com.bytedance.android.livesdk.chatroom.utils.p.b.getClass();
        RoomContext r7 = this.X;
        if (r7 == null) goto L21;
        if (((Boolean) r7.getHasShownLinkFollowGuide().getValue()).booleanValue() == false) goto L21;
        ALogger.i("follow_guide", "intercept remind follow since hasShownLinkFollowGuide");
        return;
    L21:
        if (this.g1 != null) goto L23;
        this.g1 = new r8(getActivity(), isScreenPortrait(), this.q);
    L23:
        r8 r8 = this.g1;
        r8.g = this.W;
        if (r8.getWindow() != null) goto L26;
    L28:
        int r9 = fi1.a;
        if (fi1.a.b() == true) goto L69;
        r8 r10 = this.g1;
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L65;
        DialogLancet.handleBlockedDialogShow(r10);
    L35:
        com.bytedance.android.livesdk.log.u.l().d("livesdk_follow_popup_show", new Object[]{am2.x.class, Room.class});
        return;
    L65:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L61
    L34:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        goto L35
    L69:
        return;
    L26:
        if (tb1.c.a == false) goto L28;
        this.g1.getWindow().setDimAmount(0.0f);
        goto L28
    L11:
        if (r6.getDiggWidget().getValue() == null) goto L14;
        if (((u32.k) r6.getDiggWidget().getValue()).Eg() == false) goto L14;
        return;
    L8:
        if (r1.isShowing() == false) goto L9;
        return;
    L36:
        return;
    L37:
        r8 r11 = this.g1;
        if (r11 != null) goto L40;
    L59:
        this.g1 = null;
        return;
    L40:
        if (r11.isShowing() == false) goto L59;
        r8 r12 = this.g1;
        Handler r2 = DialogLancet.resolveDialogHandler(r12);
        if (r2 != null) goto L44;
    L46:
        DialogLancet.beforeDialogDismiss(r12);
        r12.dismiss();     // Catch: Throwable -> L49 Exception -> L51
    L55:
        DialogLancet.afterDialogDismiss(r12);
    L56:
        this.W.put("cmd_start_count_authorization", Boolean.TRUE);
        goto L59
    L51:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L49
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L49
        if (r3 == null) goto L55;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r12);
        throw th;
    L44:
        if (Looper.myLooper() == r2.getLooper()) goto L46;
        r2.post(DialogLancet.createDismissRunnable(r12));
        goto L56
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [android.view.ViewGroup, com.bytedance.android.livesdk.common.AnchorPauseTipsView] */
    public void initViews(View r6) {
        this.Y2 = (FrameLayout) r6.findViewById(2131378328);
        this.Z2 = (FrameLayout) r6.findViewById(2131373130);
        this.a3 = (FrameLayout) r6.findViewById(2131373341);
        GestureDetectLayout r1 = r6.findViewById(2131381934);
        this.I = r1;
        r1.setEnableSlide(ob0());
        this.I.setSlideAction(new v2(this));
        this.A = r6.findViewById(2131375551);
        this.K = r6.findViewById(2131364116);
        ?? r2 = (AnchorPauseTipsView) r6.findViewById(2131362592);
        this.C = r2;
        int r3 = (int) UIUtils.dip2Px(r2.getContext(), 96.0f);
        UIUtils.updateLayout(r2.b, r3, r3);
        r2.T5(2131251822, 0.0f, false);
        FrameLayout r4 = (FrameLayout) this.F3.findViewById(2131364575);
        gl0.d r5 = jc1.k.f(IPullStreamService.class).getLiveStatusErrorView(getContext(), LivePlayerScene.INSTANCE.getINNER_DRAW());
        this.D = r5;
        if (r5 == null) goto L5;
        this.E = r5.getView();
    L5:
        ViewGroup.LayoutParams r7 = new ViewGroup.LayoutParams(-1, -1);
        r4.addView(this.E, r7);
        if (g1() == true) goto L8;
    L14:
        UIUtils.setViewVisibility(this.E, 8);
        this.J = (FrameLayout) r6.findViewById(2131381934);
        Room r8 = this.q;
        if (r8 == null) goto L20;
        if (r8.hasMicRoomField() == false) goto L20;
        getView();
    L20:
        if (((a11) com.bytedance.android.livesdk.a4.a.getValue()).b() == false) goto L28;
        DataCenter r9 = this.W;
        if (r9 == null) goto L29;
        ListenLiveStatus r10 = (ListenLiveStatus) r9.get("cmd_change_listen_live_status", new ListenLiveStatus());
        ListenLiveOnlyView r0 = r10.getListenLiveView();
        if (r0 != null) goto L26;
        r0 = new ListenLiveOnlyView(getContext(), this.W);
        r10.setListenLiveView(r0);
        r10.setEventHandler(r0);
        this.W.put("cmd_change_listen_live_status", r10);
    L26:
        r0.d((ViewGroup) this.F3.findViewById(2131378191), g1());
        return;
    L29:
        return;
    L28:
        return;
    L8:
        if (this.D == null) goto L14;
        DataCenter r11 = this.W;
        if (r11 == null) goto L14;
        if ((r11.get("live_render_view_params", null) instanceof VideoViewParams) == false) goto L14;
        VideoViewParams r12 = (VideoViewParams) this.W.get("live_render_view_params", null);
        this.D.n1(r12.a, r12.b, r12.c);
        goto L14
    }

    public final void kb0(boolean r5) {
        DataCenter r0 = this.W;
        if (r0 == null) goto L8;
        HashMap r1 = o70.c.a;
        if (o70.c.a(Integer.valueOf(r0.hashCode())) == null) goto L9;
        o70.c.a(Integer.valueOf(this.W.hashCode())).b(new bh1.a(r5, com.bytedance.android.live.core.utils.z.e(this.W, false)));
        return;
    L9:
        return;
    }

    public final void kd0(Room r3) {
        if (cd0.a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (this.U2 != null) goto L7;
        this.U2 = new EnterRoomAuthCompactManager(this.W);
    L7:
        this.U2.a(r3);
    }

    public void la0(IRoom r5) {
        ALogger.i("COMPONENTX_BEFORE", "beforeLoadP0Task AbsInteractionFragment");
        y50.c.d.b("fragment_load_p0");
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load p0 widget start");
        if (PadConfigUtils.c() == false) goto L10;
        if (com.bytedance.android.livesdk.utils.e5.n() == false) goto L7;
        PadOrientation r0 = PadOrientation.LANDSCAPE;
    L8:
        this.X.getPadOrientation().setValue(r0);
        goto L10
    L7:
        r0 = PadOrientation.PORTRAIT;
    L10:
        if (yl.a.getValue().booleanValue() == false) goto L13;
        boolean r1 = k60.b.a();
        CommonToastWidget r2 = new CommonToastWidget();
        this.G1 = r2;
        this.e.load(r2, r1, r1);
    L13:
        if (jc1.k.f(IRoomModuleService.class) == null) goto L19;
        q81.c r3 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        if (r5 == null) goto L17;
        long r4 = r5.getId();
    L18:
        r3.c(r4, getArguments());
        goto L19
    L17:
        r4 = 0;
    L19:
        this.T1.a.a = true;
        Kb0(this.F3);
        Vc0();
        Mc0();
        if (this.X2 == null) goto L27;
        if (this.Q2 == true) goto L27;
        if (g1() == true) goto L27;
        this.Q = new GestureDetector(getContext(), this.j4);
        ya0();
        this.c4 = new com.bytedance.android.livesdk.chatroom.record.i(getContext(), this.W);
        this.I.b(this.m4);
        this.Q2 = true;
    L27:
        if (yb0() == false) goto L42;
        boolean r6 = com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.e;
        if (r6 == true) goto L31;
    L35:
        if (r6 == false) goto L42;
        if (g1() == false) goto L42;
        if (vx0.a.getValue().booleanValue() == false) goto L42;
        jc1.k.f(IGiftServiceExternal.class).initGiftModule(getContext(), this, this.W);
        goto L42
    L31:
        if (this.Q2 == true) goto L35;
        if (g1() == false) goto L35;
        this.Q = new GestureDetector(getContext(), this.j4);
        ya0();
        this.c4 = new com.bytedance.android.livesdk.chatroom.record.i(getContext(), this.W);
        this.I.b(this.m4);
        this.Q2 = true;
    L42:
        if (Fa0() == true) goto L45;
        ad0();
        return;
    }

    public final void ld0(String r5) {
        DataCenter r0 = this.W;
        if (r0 != null) goto L5;
        return;
    L5:
        LayerEventDispatcher r1 = o70.c.a(Integer.valueOf(r0.hashCode()));
        if (r1 == null) goto L8;
        r1.b(new o42.c(false, true, r5));
        return;
    L8:
        boolean r6 = TextMessageTracer.a;
        TextMessageTracer.A("try, adjust h, but dispatcher is null");
    }

    public void ma0(IRoom r4) {
        ALogger.i("COMPONENTX_BEFORE", "beforeP1Load AbsInteractionFragment");
        if (jc1.k.f(IRoomModuleService.class) == null) goto L9;
        q81.c r0 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        if (r4 == null) goto L7;
        long r1 = r4.getId();
    L8:
        r0.a(r1, getArguments());
        goto L9
    L7:
        r1 = 0;
    L9:
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load p1 widget start");
        this.T1.b.a = true;
    }

    public void mc0(zg1.u1 r5) {
        if (this.u == true) goto L5;
        return;
    L5:
        int r0 = r5.f;
        if (r0 != 1) goto L17;
        if (this.q.isLiveTypeAudio() == false) goto L13;
        yh0.b r1 = this.p1;
        if (r1 == null) goto L12;
        r1.F4(false);
    L12:
        getView().findViewById(2131383618).setVisibility(8);
    L13:
        GestureDetectLayout r2 = this.I;
        if (r2 == null) goto L28;
        r2.setIsInMultiAnchorLink(true);
        this.I.setMultiAnchorTopY(r5.h);
        this.I.setMultiAnchorBottomY(r5.g);
        this.I.setIsAnchor(this.D3);
        return;
    L28:
        return;
    L17:
        if (r0 == 2) goto L19;
        return;
    L19:
        if (this.q.isLiveTypeAudio() == false) goto L24;
        yh0.b r6 = this.p1;
        if (r6 == null) goto L23;
        r6.F4(true);
    L23:
        getView().findViewById(2131383618).setVisibility(0);
    L24:
        GestureDetectLayout r7 = this.I;
        if (r7 == null) goto L31;
        r7.setIsInMultiAnchorLink(false);
        return;
    }

    public final void md0(String r4) {
        DataCenter r0 = this.W;
        if (r0 != null) goto L5;
        return;
    L5:
        LayerEventDispatcher r1 = o70.c.a(Integer.valueOf(r0.hashCode()));
        if (r1 == null) goto L8;
        r1.b(new o42.c(true, true, r4));
        return;
    L8:
        boolean r5 = TextMessageTracer.a;
        TextMessageTracer.A("try, adjust wh, but dispatcher is null");
    }

    public final void mf(IRoom r7) {
        long r1 = 0;
        if (this.n3.booleanValue() == true) goto L5;
        ALogger.i("COMPONENTX_BEFORE", "beforeP2Load AbsInteractionFragment");
        if (jc1.k.f(IRoomModuleService.class) == null) goto L20;
        q81.c r0 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        if (r7 == null) goto L19;
        r1 = r7.getId();
    L19:
        r0.n(r1, getArguments());
    L20:
        this.T1.c.a = true;
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load p2 widget start");
        InRoomBannerManager r2 = this.p0;
        if (r2 == null) goto L23;
        InRoomBannerManager.c(r2, this.q.getId(), this.D3.booleanValue());
    L23:
        Hb0((Room) r7, new v0(this));
        return;
    L5:
        if (jc1.k.f(IRoomModuleService.class) == null) goto L10;
        q81.c r3 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        if (r7 == null) goto L9;
        r1 = r7.getId();
    L9:
        r3.n(r1, getArguments());
    L10:
        this.T1.c.a = true;
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load p2 widget start");
        InRoomBannerManager r4 = this.p0;
        if (r4 == null) goto L13;
        InRoomBannerManager.c(r4, this.q.getId(), this.D3.booleanValue());
    L13:
        Hb0((Room) r7, new u0(this));
    }

    public final void nd0(String r5) {
        DataCenter r0 = this.W;
        if (r0 != null) goto L5;
        return;
    L5:
        LayerEventDispatcher r1 = o70.c.a(Integer.valueOf(r0.hashCode()));
        if (r1 == null) goto L8;
        r1.b(new o42.c(true, false, r5));
        return;
    L8:
        boolean r6 = TextMessageTracer.a;
        TextMessageTracer.A("try, adjust w, but dispatcher is null");
    }

    public void onActivityCreated(Bundle r17) {
        super.onActivityCreated(r17);
        com.bytedance.android.live.core.tetris.widgets.d.g("onActivityCreated#" + hashCode());
        RoomContext r1 = this.X;
        int r2 = 0;
        boolean r3 = false;
        r3 = false;
        if (r1 != null) goto L5;
    L72:
        RoomContext r4 = this.X;
        if (r4 == null) goto L75;
        r2 = r4.hashCode();
    L75:
        ALogger.w("AbsInteractionFragment", "RoomContext is not valid, this=" + hashCode() + " context=" + r2);
        return;
    L5:
        if (r1.isCleared() == true) goto L72;
        if (getArguments() == null) goto L13;
        if (getArguments().getLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME") < 0) goto L13;
        this.K3 = getArguments().getLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME");
    L13:
        if (kw0.a.getValue().booleanValue() == true) goto L77;
    L25:
        Aa0(new s3(this));
        if (this.q != null) goto L29;
        this.q = (Room) this.W.get("data_room");
    L29:
        if (this.K3 <= 0) goto L33;
        Room r5 = this.q;
        if (r5 == null) goto L33;
        boolean r6 = fh1.e.a;
        fh1.e.b(r5.getRoomId(), (System.currentTimeMillis() - this.K3) + "");
    L33:
        Room r7 = this.q;
        if (r7 == null) goto L36;
        ILivePlayerClient r8 = LivePlatformPlayerManager.a(r7.getId(), false);
    L37:
        if (r8 == null) goto L45;
        final IRoomEventHub r9 = r8.getEventHub();
        if (this.o == true) goto L42;
        if (r9 == null) goto L42;
        Aa0(new com.bytedance.android.livesdk.chatroom.ui.l(r9));
        this.o = true;
    L42:
        RoomContext r10 = this.X;
        if (r10 == null) goto L45;
        r10.isStreamHorizontal().setValue(new w());
        this.X.getLiveFrameBitmap().setValue(new a0(this));
        this.X.getStreamSize().setValue(new b0());
    L45:
        Room r11 = this.q;
        com.bytedance.android.live.core.tetris.widgets.d.g("oldOnViewCreated started");
        y50.c.d.b("inter_fragment_view_created");
        View r12 = getView();
        if (r12 != null) goto L48;
        com.bytedance.android.live.core.tetris.widgets.d.g("oldOnViewCreated return due to getView is null");
    L60:
        ja0();
        if (this.T == LiveMode.AUDIO) goto L70;
        com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.b.L0;
        Room r14 = this.q;
        if (r14 != null) goto L65;
    L69:
        Boolean r15 = Boolean.valueOf(r3);
        r13.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r13, r15);
        goto L70
    L65:
        if (r14.getReplay() == false) goto L67;
    L68:
        r3 = true;
        goto L69
    L67:
        if (this.q.highlight == false) goto L69;
    L70:
        Aa0(new c0());
        return;
    L48:
        ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.W != null) goto L52;
        com.bytedance.android.live.core.tetris.widgets.d.g("oldOnViewCreated return due to dataCenter is null");
        goto L60
    L52:
        if (this.X != null) goto L54;
        com.bytedance.android.live.core.tetris.widgets.d.g("oldOnViewCreated return due to dataContext is null");
        goto L60
    L54:
        ILiveRoomPlayFragment r16 = getParentFragment();
        if ((r16 instanceof ILiveRoomPlayFragment) == false) goto L59;
        ILiveRoomPageFragment r18 = r16.parentPage();
        if (r18 == null) goto L59;
        this.W.put("data_room_action", r18.getRealAction().roomAction());
    L59:
        this.W.observeForever("data_user_in_room", this).observeForever("data_screen_record_is_open", this).observeForever("data_is_followed", this).observe("cmd_interact_audio", this).observeForever("cmd_widget_loaded", this).observeForever("cmd_fs_widget_loaded", this).observeForever("cmd_widget_is_show", this).observeForever("cmd_p0_widget_loaded", this).observeForever("cmd_p1_widget_loaded", this).observeForever("cmd_p2_widget_loaded", this).observeForever("data_toolbar_visible", this).observeForever("cmd_specific_widget_loaded", this).observeForever("cmd_specific_behavior_loaded", this).observeForever("cmd_specific_behavior_un_loaded", this).observeForever("cmd_new_toolbar_double_check", this).observeForever("cmd_specific_view_loaded", this).observeForever("cmd_send_priority_widget_load_track", this).observe("cmd_video_orientation_changed", this, true).observeForever("cmd_pk_state_change", this).observeForever("cmd_multi_state_change", this).observeForever("cmd_equal_talkroom_state_change", this).observeForever("cmd_video_talkroom_state_change", this).observe("cmd_normal_gift_widget_layout_change", this, true).observeForever("cmd_refresh_user_in_room", this).observe("cmd_sticker_is_selected", this).observeForever("data_login_event", this).observe("cmd_interact_player_view_change", this).observe("cmd_show_fans_club_setting", this).observe("cmd_adjust_video_interact_stream_bottom", this).observe("cmd_close_h5_dialog", this).observe("data_room_banner_status", this).observe("data_media_introduction_showing", this).observe("data_room_comment_status", this).observe("data_activity_top_right_banner_show", this).observe("data_member_count", this).observe("data_member_count_str", this).observe("data_is_score_open", this).observe("data_right_bottom_banner_container_show", this).observe("data_right_bottom_banner_show", this).observe("data_promotion_right_card_container_show", this).observe("data_bottom_card_container_show", this).observe("data_live_scene_shown", this).observe("data_bottom_right_state", this).observe("cmd_update_live_hotspot_show", this).observe("cmd_update_live_challenge", this).observe("mic_room_widget_entry_show", this).observe("cmd_update_admin_record", this).observe("mic_room_widget_show", this).observe("data_online_changed_list", this).observe("data_link_state", this).observe("cmd_data_interact_public_screen_height_change", this).observe("data_special_enter_anim_extra_height", this).observe("data_audience_interact_game", this).observe("cmd_live_text_visible", this).observe("data_restart_message", this).observe("cmd_live_update_media_count", this).observe("cmd_live_text_update", this).observe("cmd_video_video_bottom_ready", this).observeForever("data_talk_room_capture_audio_notification_show_state", this).observeForever("data_self_is_silenced", this).observeForever("DATA_DISCONNECT_LINK", this).observe("cmd_hide_all_float_fragment", this).observe("cmd_effect_start", this).observe("cmd_media_room_hide_share", this).observe("paid_live_paid_info_update", this).observeForever("cmd_text_message_widget_loaded", this).observe("live_render_view_params", this).observe("cmd_change_listen_live_status", this).observe("cmd_enter_room_multil_link_room_mode_sysnc", this).observe("interaction_on_first_frame", this).observeForever("data_right_card_loaded", this);
        this.W.put("interaction_on_view_created", Boolean.FALSE);
        zb0(r12, r17, r11);
        goto L60
    L36:
        r8 = null;
        goto L37
    L77:
        Reflect r19 = Reflect.on(ValueAnimator.class);     // Catch: Throwable -> L21
        JSONObject r20 = new JSONObject();     // Catch: Throwable -> L21
        if (getContext() != null) goto L19;
    L22:
        float r21 = ((Float) r19.get("sDurationScale", new Class[0])).floatValue();     // Catch: Throwable -> L21 Throwable -> L21
        com.bytedance.android.livesdk.log.b0.o().getClass();     // Catch: Throwable -> L21 Throwable -> L21
        com.bytedance.android.live.core.log.g.i("LiveAnimator", "sDurationScale: " + r21);     // Catch: Throwable -> L21 Throwable -> L21
        if (r21 > 0.0f) goto L25;
        r20.put("sDurationScale", r21);     // Catch: Throwable -> L21 Throwable -> L21
        LiveTracingMonitor.f("ttlive_value_animator_duration_scale_error", LiveTracingMonitor.EventModule.common, r20, new JSONObject(), new JSONObject());     // Catch: Throwable -> L21 Throwable -> L21
        r19.call("setDurationScale", new Class[]{Float.TYPE}, new Object[]{Float.valueOf(1.0f)});     // Catch: Throwable -> L21 Throwable -> L21
        goto L25
    L19:
        if (getContext().getContentResolver() == null) goto L22;
        float r110 = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);     // Catch: Throwable -> L21 Throwable -> L21
        r20.put("globalAnimatorDurationScale", r110);     // Catch: Throwable -> L21 Throwable -> L21
        com.bytedance.android.livesdk.log.b0.o().getClass();     // Catch: Throwable -> L21 Throwable -> L21
        com.bytedance.android.live.core.log.g.i("LiveAnimator", "globalAnimatorDurationScale: " + r110);     // Catch: Throwable -> L21 Throwable -> L21
        goto L22
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        dc0((KVData) r1);
    }

    public void onConfigurationChanged(Configuration r3) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r3);
        this.g2 = r3;
        this.h2 = r3.orientation;
        if (PadConfigUtils.c() == false) goto L6;
        this.b2 = 0;
    L6:
        if (hx.a.getValue().booleanValue() == false) goto L11;
        DataCenter r4 = this.W;
        if (r4 == null) goto L12;
        r4.put("cmd_anchor_audio_fold_screen", Boolean.TRUE);
        return;
    L12:
        return;
    }

    public void onCreate(Bundle r7) {
        super.onCreate(null);
        com.bytedance.android.live.core.tetris.widgets.d.g("onCreate#" + hashCode());
        setStyle(1, 2131954674);
        setCancelable(false);
        Nc0();
        hd0.c.f().k(0);
        if (this.T != null) goto L5;
        this.T = LiveMode.VIDEO;
    L5:
        boolean r2 = com.bytedance.android.livesdk.chatroom.game.e.a(this.q, this.X);
        this.v2 = r2;
        if (r2 == false) goto L9;
        this.p2 = Ba0();
    L9:
        if (TTLiveSDKContext.getHostService() == null) goto L11;
        this.Q1 = TTLiveSDKContext.getHostService().h();
    L11:
        ia0();
        DataCenter r3 = this.W;
        if (r3 == null) goto L20;
        r3.put("log_enter_live_source", this.r);
        if (getActivity().getSharedPreferences("feed_live_span", 0).getInt("span_count", 0) <= 1) goto L16;
        String r4 = "live_small_picture";
    L17:
        this.W.put("log_live_feed_layout", r4);
        this.W.put("log_streaming_type", this.T.getLogStreamingType());
        this.W.put("data_text_message_widget_slide", Boolean.valueOf(ob0()));
        if (this.W.get("data_backtrack_service", null) != null) goto L20;
        DataCenter r5 = this.W;
        r5.put("data_backtrack_service", new zf1.b0(r5, zf1.c.b(getContext())));
        goto L20
    L16:
        r4 = "live_big_picture";
    L20:
        RoomContext r6 = this.X;
        if (r6 != null) goto L23;
    L27:
        com.bytedance.android.livesdk.utils.ntp.e.b(getContext());
        DataCenter r8 = this.W;
        if (r8 == null) goto L34;
        com.bytedance.android.livesdk.chatroom.room.p0 r9 = (com.bytedance.android.livesdk.chatroom.room.p0) r8.get("zygote_event_hub", null);
        if (r9 == null) goto L34;
        r9.getUpdateInteraction().observe(this, new r2(this));
        r9.getMediaGeneratingViewShowing().observe(this, new s2(this));
        r9.getMediaStartRender().observe(this, new t2(this));
    L34:
        Room r10 = this.q;
        if (r10 != null) goto L37;
    L39:
        final IHostCommerceServiceLive r11 = jc1.k.f(IHostCommerceServiceLive.class);
        if (r11 == null) goto L46;
        StringBuilder r12 = new StringBuilder("shopping-plugin is not init, room_id = ");
        Room r13 = this.q;
        if (r13 == null) goto L44;
        Object r14 = Long.valueOf(r13.getId());
    L45:
        r12.append(r14);
        ALogger.w("AbsInteractionFragment", r12.toString());
        ((ObservableSubscribeProxy) xs2.b.a().b(com.bytedance.android.livesdk.event.z.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new r0(r11));
        goto L46
    L44:
        r14 = "0";
    L46:
        a71 r15 = uf0.a.getValue();
        this.h3 = r15;
        if (r15 != null) goto L49;
    L53:
        boolean r16 = false;
    L54:
        if (r16 == false) goto L56;
    L66:
        IEnterGuideService r17 = jc1.k.f(IEnterGuideService.class);
        if (r17 == null) goto L71;
        l32.c r18 = r17.getKeyRoomInfoBizController();
        if (r18 == null) goto L71;
        r18.a();
    L71:
        Aa0(new s0());
        ClearScreenManagerAbility.INSTANCE.setFactory(new l());
        Boolean r19 = this.D3;
        if (r19 == null) goto L76;
        if (r19.booleanValue() == false) goto L76;
    L77:
        gs1.b.b(false);
        return;
    L76:
        if (g1() == false) goto L77;
        return;
    L56:
        if (pb0() == false) goto L66;
        if (jc1.k.f(IHostGameCP.class) == null) goto L66;
        if (jc1.k.f(IHostGameCP.class).getGameCpLiveService() == null) goto L66;
        if (jc1.k.f(IHostGameCP.class).getGameCpLiveService().getGameCpRoomControllerProvider() == null) goto L66;
        if ((jc1.k.f(IHostGameCP.class).getGameCpLiveService().getGameCpRoomControllerProvider() instanceof ILiveRoomControllerProvider) == false) goto L66;
        jc1.k.f(ExternalFunctionInjectorService.class).injectRoomControllerProvider((ILiveRoomControllerProvider) jc1.k.f(IHostGameCP.class).getGameCpLiveService().getGameCpRoomControllerProvider());
        LiveEnterRoomControllerUtilKt.setHasGameCpInjected(true);
        goto L66
    L49:
        if (r15.mEnable == false) goto L53;
        if (r15.mGameCpOpt == false) goto L53;
        r16 = true;
        goto L54
    L37:
        if (r10.getId() == 0) goto L39;
        xs2.b.a().post(new zg1.t0(this.q));
        goto L39
    L23:
        if (r6.getExternalConfigJudger() == null) goto L27;
        if (this.X.getExternalConfigJudger().getValue() == null) goto L27;
        this.V0 = (IExternalConfigJudger) this.X.getExternalConfigJudger().getValue();
        goto L27
    }

    public void onEvent(zg1.i2 r18) {
        if (r18 == null) goto L71;
        if (TextUtils.isEmpty(r18.a) == true) goto L71;
        int r2 = r18.d;
        if (r2 <= 0) goto L10;
    L13:
        int r3 = r18.e;
        if (r3 <= 0) goto L16;
    L19:
        com.bytedance.android.livesdk.log.filter.n0 r4 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r4 != null) goto L22;
    L35:
        String r5 = "";
        String r8 = r5;
        String r9 = r8;
    L36:
        com.bytedance.android.livesdk.log.filter.s0 r10 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        if (r10 != null) goto L39;
    L52:
        String r7 = "";
        String r11 = r7;
        String r15 = r11;
    L53:
        UrlBuilder r14 = new UrlBuilder(r18.a);
        r14.addParam("language", Locale.CHINA.getLanguage());
        r14.addParam("enter_from", r8);
        r14.addParam("source_v3", r9);
        r14.addParam("anchor_id", r7);
        r14.addParam("log_pb", r15);
        r14.addParam("request_id", r11);
        r14.addParam("event_page", r5);
        r14.addParam("event_belong", "live_interact");
        if (SettingKeyUtils.a() == true) goto L56;
        com.bytedance.android.live.browser.webview.fragment.o r0 = jc1.k.f(IBrowserService.class).buildWebDialog(r14.build()).setWidth(r2);
        r0.b = r3;
        r0.d(r18.f);
        r0.c = r18.g;
        r0.i = r18.c;
        r0.a(r18.i);
        r0.f(r18.b);
        r0.p = r18.j;
        r0.q = true;
        r0.l = r18.h;
        this.F = r0.build();
        LiveDialogFragment.show(getActivity(), this.F);
        return;
    L56:
        String r1 = r14.build();
        IBrowserService r6 = jc1.k.f(IBrowserService.class);
        FragmentActivity r12 = getActivity();
        Uri.Builder r13 = x6.a.a(r1).appendQueryParameter("type", "popup").appendQueryParameter("width", String.valueOf(r2)).appendQueryParameter("height", String.valueOf(r3)).appendQueryParameter("radius", String.valueOf(r18.f)).appendQueryParameter("margin", String.valueOf(r18.g));
        if (r18.c != 80) goto L59;
        String r16 = "bottom";
    L60:
        Uri.Builder r17 = r13.appendQueryParameter("gravity", r16);
        String r19 = "1";
        if (r18.j == false) goto L63;
        String r20 = "1";
    L64:
        Uri.Builder r21 = r17.appendQueryParameter("show_dim", r20);
        if (r18.h == true) goto L68;
        r19 = "0";
    L68:
        this.G = r6.showHybridDialog(r12, r21.appendQueryParameter("use_bottom_close", r19).build(), null);
        return;
    L63:
        r20 = "0";
        goto L64
    L59:
        r16 = "other";
        goto L60
    L39:
        if ((r10 instanceof com.bytedance.android.livesdk.log.filter.s0) == false) goto L52;
        com.bytedance.android.livesdk.log.filter.s0 r110 = r10;
        if (((com.bytedance.android.livesdk.log.filter.a) r110).b.containsKey("anchor_id") == false) goto L43;
        String r111 = (String) ((com.bytedance.android.livesdk.log.filter.a) r110).b.get("anchor_id");
    L45:
        if (((com.bytedance.android.livesdk.log.filter.a) r110).b.containsKey("log_pb") == false) goto L47;
        r15 = (String) ((com.bytedance.android.livesdk.log.filter.a) r110).b.get("log_pb");
        String r112 = "";
    L49:
        if (((com.bytedance.android.livesdk.log.filter.a) r110).b.containsKey("request_id") == false) goto L51;
        r11 = (String) ((com.bytedance.android.livesdk.log.filter.a) r110).b.get("request_id");
        r7 = r111;
        goto L53
    L51:
        r7 = r111;
        r11 = r112;
        goto L53
    L47:
        r15 = "";
        r112 = r15;
        goto L49
    L43:
        r111 = "";
        goto L45
    L22:
        if ((r4 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L35;
        com.bytedance.android.livesdk.log.filter.n0 r22 = r4;
        if (((com.bytedance.android.livesdk.log.filter.a) r22).b.containsKey("enter_from") == false) goto L26;
        r8 = (String) ((com.bytedance.android.livesdk.log.filter.a) r22).b.get("enter_from");
    L28:
        if (((com.bytedance.android.livesdk.log.filter.a) r22).b.containsKey("source") == false) goto L30;
        r9 = (String) ((com.bytedance.android.livesdk.log.filter.a) r22).b.get("source");
    L32:
        if (((com.bytedance.android.livesdk.log.filter.a) r22).b.containsKey("event_page") == false) goto L34;
        r5 = (String) ((com.bytedance.android.livesdk.log.filter.a) r22).b.get("event_page");
        goto L36
    L34:
        r5 = "";
        goto L36
    L30:
        r9 = "";
        goto L32
    L26:
        r8 = "";
        goto L28
    L16:
        if (isScreenPortrait() == false) goto L18;
        r3 = 400;
        goto L19
    L18:
        r3 = 320;
        goto L19
    L10:
        if (isScreenPortrait() == false) goto L12;
        r2 = 300;
        goto L13
    L12:
        r2 = 240;
    }

    public final void pd0(ControlMessage r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        xs2.b.a().post(new zg1.h("roomStatus", "msg's action is " + r6.getAction() + ", time is " + System.currentTimeMillis() + ", id is " + r6.getMessageId()));
    }

    public final void pr(IRoom r4) {
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("onRoomEnterSuccess");
        ALogger.i("ComponentX_Batch_Condition", "onRoomEnterSuccess");
        RoomContext r0 = this.X;
        if (r0 != null) goto L5;
    L10:
        jc1.k.f(ILiveUxTracer.class).recordSingleTimeStamp("interaction_enter_room");
        kd0((Room) r4);
        if (r4 != null) goto L13;
    L17:
        ALogger.d("NewToolbarLog", "tryMockFallbackShare");
        jd0();
        if (this.X != null) goto L20;
    L24:
        ua0();
        Aa0(new c1());
        if (this.X2 == null) goto L32;
        if (this.R2 == true) goto L32;
        if (g1() == true) goto L32;
        com.bytedance.android.livesdk.chatroom.presenter.g r5 = new com.bytedance.android.livesdk.chatroom.presenter.g(this.W);
        this.N = r5;
        r5.a(this);
        this.R2 = true;
    L32:
        if (this.O != null) goto L35;
        com.bytedance.android.livesdk.chatroom.presenter.l r6 = new com.bytedance.android.livesdk.chatroom.presenter.l();
        this.O = r6;
        this.X.getMessageManager().c(new com.bytedance.android.livesdk.chatroom.presenter.k(r6, this));
        return;
    L35:
        return;
    L20:
        if (this.W == null) goto L24;
        int r7 = qu2.a.a;
        if (jc1.k.f(lu2.f.class) == null) goto L24;
        this.X.getPaidLiveTicketSaleManager().e(new b1(this));
        goto L24
    L13:
        if (r4.isMergeVSRoom() == false) goto L17;
        if (pm1.f.o() == null) goto L17;
        pm1.f.o().a();
        MultiTabManagerImpl.e.e();
        goto L17
    L5:
        if (r0.getTextAudioManager().getValue() != null) goto L10;
        if (jc1.k.f(ITextAudioService.class) == null) goto L9;
        this.X.getTextAudioManager().d(jc1.k.f(ITextAudioService.class).getTextAudioManager(this.W));
        goto L10
    L9:
        ALogger.e("AbsInteractionFragment", "init TextAudioManager error, TextAudioService is null");
        goto L10
    }

    public void qc0(zg1.z0 r5) {
        if (this.u == true) goto L5;
        return;
    L5:
        int r0 = r5.a;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L29;
        Object r6 = r5.b;
        if ((r6 instanceof Boolean) == false) goto L21;
        if (((Boolean) r6).booleanValue() != true) goto L21;
        return;
    L21:
        if (this.q.isLiveTypeAudio() == false) goto L26;
        yh0.b r7 = this.p1;
        if (r7 == null) goto L25;
        r7.F4(true);
    L25:
        getView().findViewById(2131383618).setVisibility(0);
    L26:
        this.I.setIsInPk(false);
        return;
    L29:
        return;
    L8:
        if (this.q.isLiveTypeAudio() == false) goto L13;
        yh0.b r8 = this.p1;
        if (r8 == null) goto L12;
        r8.F4(false);
    L12:
        getView().findViewById(2131383618).setVisibility(8);
    L13:
        this.I.setIsInPk(true);
        int r9 = jc1.k.f(ILinkServiceExternal.class).getPkServiceExternal().G().a;
        int r1 = jc1.k.f(ILinkServiceExternal.class).getPkServiceExternal().G().c + r9;
        this.I.setPkTopY(r9);
        this.I.setPkBottomY(r1);
        this.I.setIsAnchor(this.D3);
    }

    public final void uF(IRoom r5) {
        if (this.n3.booleanValue() == true) goto L5;
        ma0(r5);
        Gb0((Room) r5, new w2(this));
        return;
    L5:
        if (jc1.k.f(IRoomModuleService.class) == null) goto L11;
        q81.c r0 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        if (r5 == null) goto L9;
        long r1 = r5.getId();
    L10:
        r0.a(r1, getArguments());
        goto L11
    L9:
        r1 = 0;
    L11:
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load p1 widget start");
        this.T1.b.a = true;
        Gb0((Room) r5, new l2(this));
    }

    public void va0(boolean r4) {
        ViewPropertyAnimator r0 = this.A.animate();
        if (r4 == false) goto L5;
        r0.alpha(1.0f);
    L6:
        r0.setDuration(this.n).setInterpolator(new om3.c()).setListener(new x4()).start();
        Yc0(false);
        ja0();
        Xc0(0);
        this.W.put("data_hide_screen", Boolean.valueOf(pX()));
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.b.V;
        Boolean r1 = Boolean.valueOf(pX());
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r1);
        return;
    L5:
        r0.x(0.0f);
        goto L6
    }

    public final boolean wb0(boolean r3) {
        com.bytedance.android.live.room.t r0 = (com.bytedance.android.live.room.t) com.bytedance.android.livesdk.service.l.d().b().a(com.bytedance.android.live.room.t.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isShowStickerView() == false) goto L13;
        if (r3 == false) goto L12;
        r0.hideStickerView();
        return true;
    L12:
        return true;
    L13:
        return false;
    }

    public final void wc0(boolean r3) {
        if (UserSetting.b() == false) goto L5;
        return;
    L5:
        IUser r0 = jc1.k.f(IUserService.class).user().b();
        if (r0.getUserAttr() == null) goto L8;
        r0.getUserAttr().setMuted(r3);
    L8:
        User r1 = this.S;
        if (r1 != null) goto L13;
        Lc0();
        return;
    L13:
        if (r1.getUserAttr() != null) goto L15;
        this.S.setUserAttr(new UserAttr());
    L15:
        this.S.getUserAttr().setMuted(r3);
        if (r3 == false) goto L18;
        int r4 = 2131919929;
    L19:
        com.bytedance.android.live.core.utils.f2.b(r4, 0);
        return;
    L18:
        r4 = 2131919930;
        goto L19
    }

    public final boolean xb0(Room r5) {
        Pair r0 = (Pair) this.W.get("data_video_size_pair");
        boolean r1 = true;
        if (r0 == null) goto L12;
        if (r0.getFirst() == null) goto L12;
        if (r0.getSecond() == null) goto L12;
        if (((Integer) r0.getFirst()).intValue() > ((Integer) r0.getSecond()).intValue()) goto L18;
    L16:
        r1 = false;
    L18:
        return r1;
    L12:
        if (r5.getStreamUrlExtra() != null) goto L14;
        return false;
    L14:
        if (r5.getStreamUrlExtra().getWidth() <= r5.getStreamUrlExtra().getHeight()) goto L16;
        goto L16
    }

    public void onEvent(final zg1.i1 r9) {
        if (getView() != null) goto L5;
        return;
    L5:
        this.M.post(new a2(this, r9));
        int r1 = 0;
        if (r9.b == false) goto L10;
        Object r0 = Ua0().a;
        if (r0 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.widget.landscape.r r2 = (com.bytedance.android.livesdk.chatroom.widget.landscape.r) r0;
        r2.f.setVisibility(0);
        r2.f.setOnTouchListener(this.U3);
    L13:
        KeyboardViewModel r3 = ViewModelProviders.of(this).get(KeyboardViewModel.class);
        int r4 = r9.a;
        if (r9.b == true) goto L17;
    L34:
        r3.getKeyboardData().setValue(new KeyboardViewModel.a(r1));
        DataCenter r5 = this.W;
        if (r5 != null) goto L37;
        return;
    L37:
        if (o70.c.a(Integer.valueOf(r5.hashCode())) == null) goto L43;
        bh1.b r6 = new bh1.b(r1, r9);
        PublicScreenTraceMonitor.m("AbsInteractionFragment.transfer@" + r6.hashCode());
        o70.c.a(Integer.valueOf(this.W.hashCode())).b(r6);
        return;
    L43:
        return;
    L17:
        if (isScreenPortrait() == false) goto L30;
        int r7 = (-r4) - com.bytedance.android.live.core.utils.s1.f(4.0f);
        View r8 = ((Activity) getContext()).getWindow().getDecorView();     // Catch: Exception -> L26
        if (com.larus.home.impl.utils.c.e == false) goto L24;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L26
        Thread r10 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L26
        if (r10 == com.larus.home.impl.utils.c.a) goto L24;
        com.larus.home.impl.utils.c.a(r10, "getDecorView");     // Catch: Exception -> L26
    L24:
        View r11 = r8.findViewById(R.id.content);     // Catch: Exception -> L26
        Rect r12 = new Rect();     // Catch: Exception -> L26
        r11.getGlobalVisibleRect(r12);     // Catch: Exception -> L26
        int r13 = r12.bottom;     // Catch: Exception -> L26
        Rect r14 = new Rect();     // Catch: Exception -> L26
        this.I.getGlobalVisibleRect(r14);     // Catch: Exception -> L26
        r1 = Math.max(r13 - r14.bottom, 0);     // Catch: Exception -> L26
    L28:
        if (r1 <= 0) goto L33;
        ALogger.i("AbsInteractionFragment", "getExtraLiveBottomHeight:" + r1);
        r7 = r7 + r1;
    L33:
        r1 = r7;
    L26:
        e = move-exception;
        ALogger.e("AbsInteractionFragment", "getExtraLiveBottomHeight error: " + e);
        goto L28
    L30:
        r7 = -(r4 + com.bytedance.android.live.core.utils.s1.f(48.0f));
        if (Ua0().b() == false) goto L33;
    L10:
        Object r15 = Ua0().a;
        if (r15 == null) goto L13;
        ((com.bytedance.android.livesdk.chatroom.widget.landscape.r) r15).f.setVisibility(8);
        goto L13
    }

    public void onEvent(zg1.g2 r4) {
        r4.getClass();
        if (TextUtils.isEmpty(null) == true) goto L17;
        int r0 = (int) com.bytedance.android.live.core.utils.s1.G((int) (com.bytedance.android.live.core.utils.s1.y() * 0.8f));
        int r1 = (r0 * 4) / 3;
        if (SettingKeyUtils.a() == true) goto L15;
        com.bytedance.android.live.browser.webview.fragment.o r5 = jc1.k.f(IBrowserService.class).buildWebDialog(null).setWidth(r0);
        r5.b = r1;
        r5.d(5);
        r5.i = 17;
        r5.l = true;
        this.h1 = r5.build();
        if (getFragmentManager() == null) goto L21;
        BaseWebDialogFragment r6 = this.h1;
        if (r6 == null) goto L22;
        FragmentManager r2 = getFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, "PackagePurchase", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r6, r3) == true) goto L24;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L14:
        r6.show(r2, "PackagePurchase");
        return;
    L24:
        return;
    L22:
        return;
    L21:
        return;
    L15:
        IBrowserService r7 = jc1.k.f(IBrowserService.class);
        getContext();
        x6.a.a(null);
        throw null;
    }

    public void onEvent(b30.m r9) {
        r9.getClass();
        if (TextUtils.isEmpty(null) == false) goto L5;
        return;
    L5:
        Resources r10 = getContext().getResources();
        DisplayMetrics r11 = WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics());
        float r0 = r11.widthPixels;
        float r1 = r11.density;
        int r2 = (int) (r0 / r1);
        int r12 = (int) (r11.heightPixels / r1);
        if (isScreenPortrait() == false) goto L8;
        int r6 = r12 / 2;
        int r5 = r2;
    L10:
        if (isScreenPortrait() == false) goto L12;
        int r4 = 80;
    L13:
        onEvent(new zg1.i2(null, "", r4, r5, r6, 0));
        return;
    L12:
        r4 = 8388613;
        goto L13
    L8:
        r5 = r12;
        r6 = r5;
        goto L10
    }

    public void onEvent(zg1.k1 r5) {
        if (r5.a == true) goto L5;
    L12:
        this.W.put("data_login_event", r5);
        return;
    L5:
        if (this.w == true) goto L12;
        if (UnLoginFeatureUtils.INSTANCE.restartWhenLogin(this.q) == false) goto L12;
        Bundle r6 = getArguments();
        if (r6 == null) goto L14;
        r6.putBoolean("live_reenter_room", true);
        r6.putBoolean("finish_current_activity", true);
        TTLiveSDK.hostService().action().startLive(getContext(), this.q.getId(), r6);
        return;
    }

    public void onEvent(zg1.p0 r6) {
        FrameLayout r0 = this.J;
        if (r0 == null) goto L16;
        if (r6 == null) goto L17;
        float r1 = 1.0f - r6.a;
        if (r1 >= 0.0f) goto L9;
        r1 = 0.0f;
    L9:
        if (r1 <= 1.0f) goto L11;
        r1 = 1.0f;
    L11:
        r0.setAlpha(r1);
        if (Math.abs(r6.a - 1.0f) >= 1.0E-5f) goto L14;
        this.J.setVisibility(8);
        return;
    L14:
        this.J.setVisibility(0);
        return;
    L17:
        return;
    }

    public void onEvent(com.bytedance.android.livesdk.event.d r4) {
        ib0(r4.a, false, true);
        if (this.W == null) goto L6;
        ALogger.i("AbsInteractionFragment", "onEvent BarrageCleanScreenEvent, isClear: " + r4.a);
        o70.c.a(Integer.valueOf(this.W.hashCode())).b(r4);
        return;
    }

    public void onEvent(HorizontalPlayEvent r3) {
        if (this.u == true) goto L5;
        return;
    L5:
        if (isScreenPortrait() == true) goto L14;
        int r4 = r3.what;
        if (r4 != 3) goto L10;
        this.W.put("cmd_clear_gift_message", new com.bytedance.android.livesdk.chatroom.model.q());
        return;
    L10:
        if (r4 != 4) goto L16;
        this.W.put("cmd_resume_gift_message", new com.bytedance.android.livesdk.chatroom.model.q());
        return;
    L16:
        return;
    }

    public void onEvent(com.bytedance.android.livesdk.event.v r7) {
        int r8 = r7.a;
        User r0 = (User) this.W.get("data_user_in_room");
        if (r0 == null) goto L5;
        r0.setPayScores(r0.getPayScores() + ((long) r8));
        r0.setNeverRecharge(false);
        this.X.getUser().setValue(r0);
    L5:
        this.W.put("data_user_in_room", r0);
    }

    public void onEvent(zg1.r1 r3) {
        if (this.A == null) goto L10;
        IMediaService r0 = jc1.k.f(IMediaService.class);
        if (r0 == null) goto L11;
        View r1 = this.A.findViewById(r0.getMediaMoveDownCloseResId());
        if (r1 == null) goto L12;
        r3.getClass();
        r1.setVisibility(0);
        r1.setClickable(true);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void onEvent(b30.d0 r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.H1 != null) goto L7;
        FollowGuideWidget r0 = new FollowGuideWidget(isScreenPortrait());
        this.H1 = r0;
        this.e.load(r0);
    L7:
        PlatformMessageHelper.INSTANCE.addFollowGuideMessage(this.q, r3.a);
    }

    public void onEvent(NetworkChangeEvent r4) {
        if (this.u == false) goto L5;
        return;
    L5:
        int r5 = r4.networkType;
        boolean r0 = false;
        if (1 != r5) goto L8;
        boolean r2 = true;
    L9:
        if (r5 != 0) goto L11;
        r0 = true;
    L11:
        if (r2 == true) goto L17;
        if (r0 == false) goto L16;
        IESUIUtils.displayToast(getActivity(), 2131919565);
        return;
    L16:
        return;
    L17:
        return;
    L8:
        r2 = false;
        goto L9
    }

    public void onEvent(u22.j r2) {
        if (this.V != null) goto L5;
        return;
    L5:
        if (r2.getType() == 2) goto L9;
        SystemClock.elapsedRealtime();
        this.V.a();
        ((Integer) n61.b.getValue()).intValue();
        return;
    }

    public void onEvent(zg1.o0 r3) {
        DataCenter r0 = this.W;
        if (r0 == null) goto L6;
        HashMap r1 = o70.c.a;
        LayerEventDispatcher r2 = o70.c.a(Integer.valueOf(r0.hashCode()));
        r3.getClass();
        r2.b(new yn1.c());
        return;
    }

    public void onEvent(com.bytedance.android.livesdk.event.i r4) {
        ib0(r4.a, false, true);
        DataCenter r0 = this.W;
        if (r0 == null) goto L6;
        o70.c.a(Integer.valueOf(r0.hashCode())).b(r4);
        return;
    }

    public void onEvent(c42.a r3) {
        LiveCommerceTipsWidget.a r0 = LiveCommerceTipsWidget.c;
        ik r4 = r3.a;
        DataCenter r1 = this.W;
        r0.getClass();
        LiveCommerceTipsWidget.a.d(r4, r1);
    }

    public void onEvent(zg1.o2 r3) {
        if (this.u == false) goto L6;
        ib0(r3.a, true, false);
        return;
    }

    public void onEvent(b30.e r1) {
        if (r1 == null) goto L7;
        ShareReportResult r2 = r1.a;
        if (r2 == null) goto L8;
        cb0(r2);
        return;
    L8:
        return;
    }

    public void onEvent(zg1.l0 r1) {
        r1.getClass();
        ib0(false, false, false);
    }

    public static void S90(AbsInteractionFragment r2, cc1.a r3) {
        r2.getClass();
        boolean r0 = r3.b;
        if (r0 == true) goto L5;
    L19:
        if (r0 == false) goto L21;
        return;
    L21:
        if ((r3 instanceof cc1.b) == false) goto L27;
        r2.Kc0(((cc1.b) r3).d);
        return;
    L27:
        return;
    L5:
        if ((r3 instanceof cc1.c) == false) goto L19;
        User r4 = ((cc1.c) r3).d;
        if (r4.getUserAttr() == null) goto L13;
        User r1 = r2.S;
        if (r1 != null) goto L11;
    L12:
        PrompterDataContext.Companion.getClass();
        PrompterDataContext.a.a(r4);
        goto L13
    L11:
        if (r1.getUserAttr() == null) goto L12;
    L13:
        r2.S = r4;
        UserAttr r5 = r4.getUserAttr();
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.b.L;
        Boolean r7 = Boolean.valueOf(r2.S.getRoomAutoGiftThanks());
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, r7);
        if (r5 != null) goto L16;
        return;
    L16:
        if (r2.Z.getCommentService().getValue() == null) goto L18;
        ((t22.b) r2.Z.getCommentService().getValue()).Xp(r5.isMuted());
    L18:
        com.bytedance.android.livesdk.log.b0 r8 = com.bytedance.android.livesdk.log.b0.o();
        String r9 = "Query self user info success, is admin: " + r5.isAdmin();
        r8.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room", r9);
    }

    public static /* synthetic */ void T90(AbsInteractionFragment r0, MotionEvent r1) {
        r0.db0(r1);
    }

    public static /* synthetic */ boolean U90(AbsInteractionFragment r1, MotionEvent r2) {
        if (r1.Q == null) goto L9;
        Disposable r3 = r1.i4;
        if (r3 == null) goto L7;
        r3.dispose();
    L7:
        return false;
    L9:
        return r1.db0(r2);
    }

    public static /* synthetic */ void X90(AbsInteractionFragment r0, Throwable r1) {
        r0.Kc0(r1);
    }

    public static /* synthetic */ void Y90(AbsInteractionFragment r0, float r1) {
        r0.Zc0(r1);
    }

    public static /* synthetic */ boolean Z90(AbsInteractionFragment r0, MotionEvent r1) {
        return r0.db0(r1);
    }

    public static void aa0(AbsInteractionFragment r0, Throwable r1) {
        r0.getClass();
        if ((r1 instanceof ApiServerException) == true) goto L5;
    L7:
        com.bytedance.android.live.core.utils.f2.b(2131919116, 0);
        return;
    L5:
        if (com.bytedance.android.live.core.utils.s1.getContext() == null) goto L7;
        IESUIUtils.displayToast(com.bytedance.android.live.core.utils.s1.getContext(), ((ApiServerException) r1).getPrompt());
    }

    public final void Cb0(boolean r3, ViewGroup r4) {
        BaseAnchorModeDynamicWidget r5 = jc1.k.f(IInteractService.class).createAnchorModeDynamicWidget(r4, new z4(this));
        this.L3 = r5;
        this.e.load(2131380885, r5, r3);
    }

    public void Cc0(Room r2, boolean r3) {
        if (yl.a.getValue().booleanValue() == false) goto L6;
        this.G1 = new CommonToastWidget();
        boolean r4 = k60.b.a();
        this.e.load(this.G1, r4, r4);
        return;
    }

    public final void DB(Room r5, boolean r6) {
        in1.b.c("prepareP0 start ");
        if (PadConfigUtils.c() == false) goto L10;
        if (com.bytedance.android.livesdk.utils.e5.n() == false) goto L7;
        PadOrientation r0 = PadOrientation.LANDSCAPE;
    L8:
        this.X.getPadOrientation().setValue(r0);
        goto L10
    L7:
        r0 = PadOrientation.PORTRAIT;
    L10:
        if (jc1.k.f(IRoomModuleService.class) == null) goto L16;
        q81.c r1 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        if (r5 == null) goto L14;
        long r2 = r5.getId();
    L15:
        r1.c(r2, getArguments());
        goto L16
    L14:
        r2 = 0;
    L16:
        this.T1.a.a = true;
        Kb0(this.F3);
        ad0();
        Cc0(r5, r6);
        this.e.load(2131371661, new P0EndWidget());
        this.B3 = true;
        in1.b.c("prepareP0 end ");
    }

    public void Eb0(Room r1, Function0<Unit> r2) {
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load child other widget start");
    }

    public void Gb0(Room r1, Function0<Unit> r2) {
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load child p1 widget start");
        ToolbarLoadTimeStatsVM.getInstance(RoomContext.getShared(this.W)).recordTime(ToolbarLoadTimeStatsVM.ROOM_P1_LOAD_START);
    }

    public void Hb0(Room r1, Function0<Unit> r2) {
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load child p2 widget start");
    }

    public final <T> void L7(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }

    public final void Uc0(boolean r4, String r5) {
        HashMap r0 = new HashMap();
        r0.put("event_name", "anchor_pause_tips_status");
        if (r4 == false) goto L5;
        String r6 = "show";
    L6:
        r0.put("view_status", r6);
        r0.put("reason", r5);
        com.bytedance.android.livesdk.log.b0.o().b("ttlive_room", r0);
        return;
    L5:
        r6 = "hide";
        goto L6
    }

    public final void Yb0(String r3, String r4) {
        ILiveRoomPlayFragment r0 = getParentFragment();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof ILiveRoomPlayFragment) == false) goto L13;
        ILiveRoomPageFragment r1 = r0.parentPage();
        if (r1 == null) goto L14;
        IRoomEventListener r2 = r1.getRealAction().roomEventListener();
        if (r2 == null) goto L15;
        r2.onWidgetLoaded(r3, r4);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void Zb0(boolean r5, String r6) {
        if (UserSetting.b() == false) goto L5;
        return;
    L5:
        TTLiveSDKContext.getHostService().h().setRoomAttrsAdminFlag(r5 ? 1 : 0);
        if (this.S != null) goto L9;
        Lc0();
        return;
    L9:
        RoomPermissionContext.a r0 = RoomPermissionContext.Companion;
        DataCenter r1 = this.W;
        r0.getClass();
        if (RoomPermissionContext.a.b(r1) == false) goto L17;
        if (TextUtils.isEmpty(r6) == true) goto L14;
        com.bytedance.android.live.core.utils.f2.c(r6, 0);
    L14:
        Lc0();
        ManageRoomButtonHelper.b.getClass();
        ManageRoomButtonHelper.b();
        return;
    L17:
        if (this.S.getUserAttr() != null) goto L19;
        this.S.setUserAttr(new UserAttr());
    L19:
        this.S.getUserAttr().setAdmin(r5);
        DataCenter r2 = this.W;
        if (r2 == null) goto L22;
        r2.put("data_user_in_room", this.S);
    L22:
        this.X.getUser().setValue(this.S);
        jc1.k.f(IUserService.class).user().f(this.S.getUserAttr());
        if (TextUtils.isEmpty(r6) == true) goto L25;
        com.bytedance.android.live.core.utils.f2.c(r6, 0);
    L25:
        if (r5 == false) goto L28;
        AdminRecordManager.l();
        return;
    }

    public final void dd0(boolean r5, MotionEvent r6) {
        if (this.X != null) goto L6;
        return;
    L6:
        if (ClearScreenHelper.d(this.W) == false) goto L13;
        Boolean r0 = this.D3;
        if (r0 == null) goto L13;
        if (r0.booleanValue() == false) goto L13;
        return;
    L13:
        if (ClearScreenHelper.g() == true) goto L21;
        if (ClearScreenHelper.d(this.W) == true) goto L17;
        return;
    L17:
        if (((Boolean) this.X.isCleanMode().getValue()).booleanValue() == true) goto L21;
        if (((Integer) this.X.getCleanMode().getValue()).intValue() == ClearScreenConst.InteractType.INTERACT_SHOW.getId()) goto L21;
        return;
    L21:
        if (sb0() == false) goto L27;
        if (wt2.a.d(this.D3) == false) goto L27;
        com.bytedance.android.live.core.utils.f2.b(2131917260, 0);
        ALogger.e("AbsInteractionFragment", "rejected screen clean for pure clean mode");
        return;
    L27:
        if (com.bytedance.android.livesdk.service.l.d().e().isRecording() == false) goto L29;
        return;
    L29:
        GestureDetectLayout r1 = this.I;
        int r2 = com.bytedance.android.livesdk.clearscreen.o.j0;
        com.bytedance.android.livesdk.clearscreen.o r3 = com.bytedance.android.livesdk.clearscreen.o.a.a(r1);
        if (r3 == null) goto L38;
        boolean r7 = r3.C(r6);
        MotionEvent r4 = r3.i0;
        if (r4 == null) goto L34;
        r4.recycle();
    L34:
        r3.i0 = null;
        if (r7 == false) goto L38;
        ALogger.e("AbsInteractionFragment", "刚退出pinch放大模式，这里不消费了");
        return;
    L38:
        ALogger.d("clearscreen_tag", "time is " + System.currentTimeMillis());
        ic0(new ToolbarClearScreenEvent(r5, true));
        if (r5 == false) goto L41;
        DataCenter r8 = this.W;
        ClearScreenLogUtils.a.getClass();
        ClearScreenLogUtils.Companion.d(r8, "click_button", null);
        return;
    L41:
        DataCenter r9 = this.W;
        ClearScreenLogUtils.a.getClass();
        ClearScreenLogUtils.Companion.f(r9, "click_button", null);
    }

    public final boolean interceptCloseRoom(Runnable r3, boolean r4) {
        if (((com.bytedance.android.livesdk.config.t1) LiveConfigSettingKeys.CLOSE_REMAIN_RULE_CONFIG.getValue()).enablePriority == false) goto L5;
        Collections.sort(this.U, new a3(this));
    L5:
        Iterator<kf1.a> r0 = this.U.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        if (r0.next().qa(r3, r4) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public void lb0(View r2, IMicRoomService r3) {
        if (qa0() == false) goto L14;
        if (r2 == null) goto L18;
        IMicRoomService r4 = jc1.k.f(IMicRoomService.class);
        if (rb0() == false) goto L15;
        if (r4 != null) goto L10;
        return;
    L10:
        if (r4.isMicRoom(this.q) == false) goto L12;
        this.e.X90(2131377127, r4.getMicRoomAnchorWidget());
        return;
    L12:
        this.e.ea0(r4.getMicRoomEnterOfficialWidget(), false, false);
        return;
    L15:
        return;
    L18:
        return;
    }

    public void od0(boolean r1, int r2) {
        this.y = r2;
        PageUIContext r3 = PageUIContext.getContext(this.W);
        if (r3 == null) goto L6;
        r3.getVideoBottom().setValue(Integer.valueOf(this.y));
    L6:
        if (this.v2 == false) goto L11;
        GameAbsInteractionDelegate r4 = this.p2;
        if (r4 == null) goto L12;
        r4.getClass();
        return;
    L12:
        return;
    }

    public void onViewCreated(final View r9, Bundle r10) {
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        com.bytedance.android.live.core.tetris.widgets.d.g("onViewCreated#" + hashCode());
        this.u = true;
        this.F3 = r9;
        DataCenter r0 = this.W;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L15;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L15;
        if (r2 == true) goto L15;
        r9.setFitsSystemWindows(false);
    L19:
        r9.post(new h0(this, r9));
        this.T1 = new com.bytedance.android.livesdk.chatroom.model.z3();
        RoomContext r11 = this.X;
        if (r11 != null) goto L22;
    L26:
        initViews(r9);
        if (this.q == null) goto L55;
        DataCenter r12 = this.W;
        if (r12 == null) goto L56;
        Boolean r13 = (Boolean) r12.get("IS_MERGE_WIDGET_ENTER", Boolean.FALSE);
        if (r13.booleanValue() == true) goto L33;
    L39:
        boolean r14 = false;
    L41:
        if (r13.booleanValue() == false) goto L57;
        en1.b r3 = en1.b.j;
        Boolean r15 = en1.b.g;
        if (r15 == null) goto L45;
        r1 = r15.booleanValue();
    L45:
        if (r1 == true) goto L58;
        if (r14 == true) goto L59;
        String r4 = getArguments().getString("click_method", "");
        String r5 = String.valueOf(this.q.getRoomId());
        com.bytedance.android.livesdk.user.f r16 = this.Q1;
        if (r16 != null) goto L50;
    L52:
        String r17 = null;
    L53:
        Zc0(0.0f);
        r3.c(r4, r5, this.q.getAnchorId(), r17, new r(this));
        return;
    L50:
        if (r16.b() == null) goto L52;
        r17 = this.Q1.b().getIdString();
        goto L53
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L33:
        if (getArguments() == null) goto L39;
        if (getArguments().getBundle("MERGE_WIDGET_ENTER_BUNDLE") == null) goto L39;
        if (getArguments().getBundle("MERGE_WIDGET_ENTER_BUNDLE").containsKey("MERGE_ENTER_DONT_HIDE_INTERACT") == false) goto L39;
        r14 = getArguments().getBundle("MERGE_WIDGET_ENTER_BUNDLE").getBoolean("MERGE_ENTER_DONT_HIDE_INTERACT", false);
        goto L41
    L56:
        return;
    L55:
        return;
    L22:
        if (r11.isCleared() == true) goto L26;
        if (this.X.getWidgetLoadedProperty() == null) goto L26;
        this.X.getWidgetLoadedProperty().setValue(this.T1);
    L15:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L18;
        if (r2 == true) goto L18;
        r9.setFitsSystemWindows(false);
    L18:
        r9.setFitsSystemWindows(true);
        goto L19
    L5:
        if (((Boolean) r0.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L7;
        r2 = true;
        goto L9
    }

    public final void qx(IRoom r8, boolean r9) {
        if (this.n3.booleanValue() == false) goto L44;
        y50.c r0 = y50.c.d;
        r0.b("fragment_load_p0");
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load p0 widget start");
        if (PadConfigUtils.c() == false) goto L12;
        if (com.bytedance.android.livesdk.utils.e5.n() == false) goto L9;
        PadOrientation r3 = PadOrientation.LANDSCAPE;
    L10:
        this.X.getPadOrientation().setValue(r3);
        goto L12
    L9:
        r3 = PadOrientation.PORTRAIT;
    L12:
        if (yl.a.getValue().booleanValue() == false) goto L15;
        boolean r4 = k60.b.a();
        CommonToastWidget r5 = new CommonToastWidget();
        this.G1 = r5;
        this.e.load(r5, r4, r4);
    L15:
        if (jc1.k.f(IRoomModuleService.class) == null) goto L21;
        q81.c r6 = jc1.k.f(IRoomModuleService.class).getLiveMkMetricHelper();
        if (r8 == null) goto L19;
        long r7 = r8.getId();
    L20:
        r6.c(r7, getArguments());
        goto L21
    L19:
        r7 = 0;
    L21:
        this.T1.a.a = true;
        Kb0(this.F3);
        Vc0();
        Mc0();
        if (this.X2 == null) goto L29;
        if (this.Q2 == true) goto L29;
        if (g1() == true) goto L29;
        this.Q = new GestureDetector(getContext(), this.j4);
        ya0();
        this.c4 = new com.bytedance.android.livesdk.chatroom.record.i(getContext(), this.W);
        this.I.b(this.m4);
        this.Q2 = true;
    L29:
        if (yb0() == false) goto L43;
        boolean r10 = com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.e;
        if (r10 == true) goto L33;
    L37:
        if (r10 == false) goto L43;
        if (g1() == false) goto L43;
        if (vx0.a.getValue().booleanValue() == false) goto L43;
        jc1.k.f(IGiftServiceExternal.class).initGiftModule(getContext(), this, this.W);
        goto L43
    L33:
        if (this.Q2 == true) goto L37;
        if (g1() == false) goto L37;
        this.Q = new GestureDetector(getContext(), this.j4);
        ya0();
        this.c4 = new com.bytedance.android.livesdk.chatroom.record.i(getContext(), this.W);
        this.I.b(this.m4);
        this.Q2 = true;
    L43:
        ad0();
        Fb0((Room) r8, r9, new e1(this));
        this.B3 = true;
        r0.a("fragment_load_p0");
    L45:
        IEnterGuideService r11 = jc1.k.f(IEnterGuideService.class);
        if (r11 == null) goto L53;
        Widget r12 = r11.createSlideTaskWidget(this.U);
        Widget r13 = r11.createUgCouponWidget(this.V);
        if (r12 == null) goto L50;
        this.e.load(r12);
    L50:
        if (r13 == null) goto L54;
        this.e.load(r13);
        return;
    L54:
        return;
    L53:
        return;
    L44:
        la0(r8);
        Fb0((Room) r8, r9, new p1(this));
        this.B3 = true;
        y50.c.d.a("fragment_load_p0");
        goto L45
    }

    public final void wa0(boolean r4, MotionEvent r5) {
        if (ClearScreenHelper.f(RoomContext.getShared(this.W), this.W) == false) goto L16;
        dd0(r4, r5);
        if (oa0() == false) goto L64;
        if (r4 == true) goto L65;
        RoomContext r6 = this.X;
        if (r6 != null) goto L10;
        return;
    L10:
        if (r6.isShowCastScreenUIByClickScreen() != null) goto L12;
        return;
    L12:
        if (((Boolean) this.X.isShowCastScreenUIByClickScreen().getValue()).booleanValue() == true) goto L68;
        this.X.isShowCastScreenUIByClickScreen().setValue(Boolean.TRUE);
        return;
    L68:
        return;
    L65:
        return;
    L64:
        return;
    L16:
        if (pa0() == false) goto L20;
        ALogger.d("visibilityControlTag", "AbsInteractionFragment #onSingleTapConfirmed, clickInteraction");
        com.bytedance.android.livesdk.chatroom.utils.h1.a r7 = com.bytedance.android.livesdk.chatroom.utils.h1.b;
        DataCenter r8 = this.W;
        r7.getClass();
        IVisibilityControlService r9 = com.bytedance.android.livesdk.chatroom.utils.h1.a.g(r8);
        if (r9 == null) goto L20;
        r9.changeTetrisVisible();
        boolean r10 = true;
    L22:
        if (oa0() == false) goto L69;
        String r11 = "已隐藏播放控制栏";
        if (r10 == false) goto L44;
        com.bytedance.android.livesdk.chatroom.utils.h1.a r12 = com.bytedance.android.livesdk.chatroom.utils.h1.b;
        DataCenter r1 = this.W;
        r12.getClass();
        IVisibilityControlService r13 = com.bytedance.android.livesdk.chatroom.utils.h1.a.g(r1);
        if (r13 == null) goto L70;
        boolean r14 = r13.provideContext().getPlaybackVisibleValue();
        if (com.bytedance.android.livesdk.r3.l(getContext()) == false) goto L33;
        Context r2 = getContext();
        if (r14 == false) goto L32;
        r11 = "已显示播放控制栏";
    L32:
        com.bytedance.android.livesdk.r3.q(r2, r11);
    L33:
        if (r14 == true) goto L39;
        com.bytedance.live.datacontext.m r15 = this.X.isShowCastScreenUIByClickScreen();
        Boolean r16 = Boolean.FALSE;
        r15.setValue(r16);
        if (vb0() == false) goto L37;
        this.X.isShowTitleUIByClickScreen().setValue(r16);
    L37:
        R5();
        return;
    L39:
        if (vb0() == false) goto L41;
        this.X.isShowTitleUIByClickScreen().setValue(Boolean.TRUE);
    L41:
        this.X.isShowCastScreenUIByClickScreen().setValue(Boolean.TRUE);
        R5();
        Observable<Unit> r17 = fd0();
        if (r17 == null) goto L72;
        this.b4 = r17.observeOn(AndroidSchedulers.mainThread()).subscribe(new g1(this));
        return;
    L72:
        return;
    L70:
        return;
    L44:
        Boolean r18 = (Boolean) this.X.isShowCastScreenUIByClickScreen().getValue();
        if (com.bytedance.android.livesdk.r3.l(getContext()) == false) goto L52;
        Context r3 = getContext();
        if (r18.booleanValue() == true) goto L50;
        r11 = "已显示播放控制栏";
    L50:
        com.bytedance.android.livesdk.r3.q(r3, r11);
    L52:
        if (r18.booleanValue() == false) goto L58;
        com.bytedance.live.datacontext.m r19 = this.X.isShowCastScreenUIByClickScreen();
        Boolean r20 = Boolean.FALSE;
        r19.setValue(r20);
        if (vb0() == false) goto L56;
        this.X.isShowTitleUIByClickScreen().setValue(r20);
    L56:
        R5();
        return;
    L58:
        if (vb0() == false) goto L60;
        this.X.isShowTitleUIByClickScreen().setValue(Boolean.TRUE);
    L60:
        this.X.isShowCastScreenUIByClickScreen().setValue(Boolean.TRUE);
        R5();
        Observable<Unit> r21 = fd0();
        if (r21 == null) goto L75;
        this.b4 = r21.observeOn(AndroidSchedulers.mainThread()).subscribe(new i1(this));
        return;
    L75:
        return;
    L69:
        return;
    L20:
        r10 = false;
        goto L22
    }

    public final void yc0(mt1.a r11, boolean r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        Room r0 = r11.c;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r12 == false) goto L13;
        com.bytedance.android.livesdk.user.f0 r13 = TTLiveSDKContext.getHostService().h();
        com.bytedance.android.livesdk.user.b.a r14 = new com.bytedance.android.livesdk.user.d.b().c(r0.getOwnerUserIdString());
        r0.getRequestId();
        com.bytedance.android.livesdk.user.d.b r15 = r14.e();
        r15.getClass();
        com.bytedance.android.livesdk.user.d.b r16 = r15.g("live").h(r0.getId());
        r0.getLabels();
        r16.getClass();
        getActivity();
        com.bytedance.android.livesdk.user.d.b r17 = r16.f(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.LONG_PRESS));
        r17.getClass();
        String r3 = ((com.bytedance.android.livesdk.user.a.a) r17).a;
        String r6 = ((com.bytedance.android.livesdk.user.a.a) r17).b;
        long r4 = ((com.bytedance.android.livesdk.user.b.a) r17).e;
        HashMap r7 = ((com.bytedance.android.livesdk.user.b.a) r17).f;
        boolean r8 = ((com.bytedance.android.livesdk.user.b.a) r17).g;
        com.bytedance.android.livesdk.user.f0 r1 = r13;
        r1.getClass();
        r1.Q(1, r3, r4, r6, r7, r8).subscribe(new k(this, r0));
        com.bytedance.android.livesdk.log.d.b(this.W, "live_ad", "follow", this.q.getAnchorId(), String.valueOf(this.q.getId()));
        if (com.bytedance.android.live.core.feed.a.a().c(Long.valueOf(this.q.getId())) == false) goto L11;
    L12:
        com.bytedance.android.livesdk.log.d.b(this.W, "draw_ad", "click", this.q.getAnchorId(), String.valueOf(this.q.getId()));
        return;
    L11:
        if (com.bytedance.android.live.core.feed.a.a().b(Long.valueOf(this.q.getId())) == true) goto L12;
        return;
    L13:
        com.bytedance.android.livesdk.user.f0 r18 = TTLiveSDKContext.getHostService().h();
        com.bytedance.android.livesdk.user.n.b r2 = new com.bytedance.android.livesdk.user.n.b().c(r0.getOwnerUserIdString());
        r2.getClass();
        r0.getOwner().getFollowInfo().getFollowStatus();
        com.bytedance.android.livesdk.user.n.b r5 = r2.f(r0.getId());
        r5.getClass();
        com.bytedance.android.livesdk.user.n.b r9 = r5.e(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.LONG_PRESS));
        getActivity();
        r9.getClass();
        String r10 = ((com.bytedance.android.livesdk.user.a.a) r9).a;
        String r19 = ((com.bytedance.android.livesdk.user.a.a) r9).b;
        HashMap r20 = ((com.bytedance.android.livesdk.user.a.a) r9).c;
        long r21 = ((com.bytedance.android.livesdk.user.m.a) r9).d;
        boolean r22 = ((com.bytedance.android.livesdk.user.m.a) r9).e;
        com.bytedance.android.livesdk.user.f0 r23 = r18;
        r23.getClass();
        r23.Q(0, r10, r21, r19, r20, r22).subscribe(new m(this, r11, r0));
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void V90(Context r9, HeadsetBroadcastReceiver r10, IntentFilter r11) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r10, r11, 2);
        return;
    L38:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r11) == false) goto L22;
        int r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r10, r11, 2, null, null, 3, r9).result;     // Catch: Exception -> L33
        if (r1 == 1) goto L19;
        if (r1 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r1 == 3) goto L40;
        r9.registerReceiver(r10, r11, 2);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L19:
        r9.registerReceiver(r10, r11, 2);     // Catch: Exception -> L33
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r9.registerReceiver(r10, r11, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r9.registerReceiver(r10, r11, 2);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r11) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r9, r10, r11, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void W90(Context r8, HeadsetBroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    public static void ca0(final AbsInteractionFragment r3, long r4, String r6) {
        r3.getClass();
        HashMap r0 = new HashMap();
        com.bytedance.android.livesdk.share.e.a.getClass();
        String r1 = String.valueOf(com.bytedance.android.livesdk.share.e.a.b("chat_merge"));
        if (TextUtils.isEmpty(r1) == true) goto L5;
        r0.put("target_id", r1);
    L5:
        String r2 = String.valueOf(1);
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r0.put("share_type", r2);
    L8:
        String r7 = String.valueOf(r6);
        if (TextUtils.isEmpty(r7) == true) goto L11;
        r0.put("common_label_list", r7);
    L11:
        com.bytedance.android.livesdk.service.l.d().getClass();
        Disposable r5 = ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).sendShare(r4, r0).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.chatroom.ui.t(r3), RxUtil.getNoOpThrowable());
        r3.L.add(r5);
    }

    public void Fb0(Room r1, boolean r2, Function0<Unit> r3) {
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("load child p0 widget start");
    }

    public final void Ma(boolean r7, boolean r8, IMultiCameraView.Source r9) {
        if (r8 == true) goto L17;
        RoomContext r0 = this.X;
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L13;
        DataCenter r2 = this.W;
        if (r2 == null) goto L13;
        r2.put("data_room_text_message_presenter", null);
    L13:
        vlc.d r3 = com.bytedance.android.livesdk.chatroom.utils.n3.e(this.W);
        if (r3 == null) goto L17;
        r3.r(false);
        goto L17
    L6:
        if (((Boolean) r0.getCameraMessageShared().getValue()).booleanValue() == false) goto L8;
        r1 = true;
    L17:
        if (Oa0() != null) goto L19;
    L24:
        if (r8 == true) goto L27;
        jb0();
    L27:
        if (Oa0() == null) goto L30;
        Oa0().c(new com.bytedance.android.livesdk.chatroom.ui.a(this));
        return;
    L30:
        return;
    L19:
        if (Fa0() == true) goto L21;
    L23:
        Oa0().b(g1(), r7, r8, r9, null);
        goto L24
    L21:
        if (((Boolean) this.T1.d.b.a).booleanValue() == true) goto L23;
        Oa0().b(g1(), r7, r8, r9, this.f);
        goto L24
    }

    public void VX(DataCenter r3, com.bytedance.android.live.room.h.b r4, EnterRoomExtra r5) {
        this.W = r3;
        this.D3 = Boolean.FALSE;
        this.q = (Room) r3.get("data_room");
        ALogger.d("enterRoomInPlayback", "mRoom " + this.q.toString());
        this.s = r5;
        ia0();
        if (this.r != null) goto L5;
        this.r = "";
    L5:
        Room r6 = this.q;
        if (r6 != null) goto L8;
    L12:
        boolean r7 = false;
    L13:
        this.t = r7;
        Room r8 = this.q;
        if (r8 != null) goto L16;
    L18:
        this.w = TTLiveSDKContext.getHostService().h().isLogin();
        this.t3.a = r3;
        rv2.a r9 = this.u3;
        if (r9 == null) goto L21;
        r9.N(r3);
    L21:
        this.n4 = r4;
        boolean r10 = com.bytedance.android.livesdk.floatview.p.a;
        this.G3 = ((Integer) r3.get("room_controller_unique_key", 0)).intValue();
        ALogger.i("RoomControllerTracer", "mParentFragmentCode = " + this.G3 + ", abs = " + hashCode());
        return;
    L16:
        if (r8.isMediaRoom() == false) goto L18;
        this.D3.booleanValue();
        goto L18
    L8:
        if (r6.isMediaRoom() == false) goto L12;
        if (this.D3.booleanValue() == true) goto L12;
        r7 = true;
        goto L13
    }

    public final void Wc0(int r8, long r9, String r11) {
        HashMap r0 = new HashMap();
        com.bytedance.android.livesdk.log.filter.n0 r1 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r1 != null) goto L5;
    L14:
        String r2 = "";
        String r5 = r2;
    L15:
        r0.put("enter_from_merge", r5);
        r0.put("enter_method", r2);
        Room r3 = this.q;
        if (r3 != null) goto L18;
    L21:
        r0.put("duration", String.valueOf(r9));
        r0.put("action_type", (String) this.W.get("log_action_type", ""));
        if (r8 == (-1)) goto L25;
        r0.put("level", String.valueOf(r8));
    L25:
        if (this.D3.booleanValue() == false) goto L27;
        String r10 = "1";
    L28:
        r0.put("is_anchor", r10);
        com.bytedance.android.livesdk.log.u.l().sendLog(r11, r0, new Object[0]);
        return;
    L27:
        r10 = "0";
        goto L28
    L18:
        if (r3.getOwner() == null) goto L20;
        r0.put("anchor_id", this.q.getOwner().getIdStr());
    L20:
        String r4 = String.valueOf(this.q.getId());
        int r6 = com.bytedance.android.live.core.utils.h1.a;
        String r7 = com.bytedance.android.live.core.utils.i1.a(this.q.getStreamType());
        r0.put("room_id", r4);
        r0.put("live_type", r7);
        goto L21
    L5:
        if ((r1 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L14;
        com.bytedance.android.livesdk.log.filter.n0 r12 = r1;
        if (((com.bytedance.android.livesdk.log.filter.a) r12).b.containsKey("enter_from_merge") == false) goto L9;
        r5 = (String) ((com.bytedance.android.livesdk.log.filter.a) r12).b.get("enter_from_merge");
    L11:
        if (((com.bytedance.android.livesdk.log.filter.a) r12).b.containsKey("enter_method") == false) goto L13;
        r2 = (String) ((com.bytedance.android.livesdk.log.filter.a) r12).b.get("enter_method");
        goto L15
    L13:
        r2 = "";
        goto L15
    L9:
        r5 = "";
        goto L11
    }

    public final void X5(boolean r3, boolean r4, IMultiCameraView.Source r5) {
        if (Oa0() == null) goto L5;
        Oa0().a(g1(), r3, r4, r5);
    L5:
        if (r4 == true) goto L7;
        ed0("reloadWidget");
    L7:
        Oc0();
        sa0();
        if (Oa0() == null) goto L11;
        Oa0().c(new w0(this));
        return;
    }

    public final void bW(Room r4, EnterRoomExtra r5, Runnable r6) {
        if (jc1.k.f(IRoomModuleService.class) == null) goto L8;
        if (jc1.k.f(IRoomModuleService.class).getLiveSplitEnterRoomUtils().a() == false) goto L8;
        this.q = r4;
        Gc0(Ra0());
    L8:
        if (this.W == null) goto L10;
        jc1.k.f(IEpisodeInteractiveService.class).setUpForTemplate(this.f3, this.W);
    L10:
        t r0 = new t(this, r4, r5, (vh1.c0) r6);
        if (this.x == false) goto L13;
        com.bytedance.android.live.core.tetris.widgets.d.g("continue room enter due to fragment is resumed");
        r0.run();
        return;
    L13:
        com.bytedance.android.live.core.tetris.widgets.d.g("wait continue room enter util fragment is resumed");
        this.s3 = r0;
    }

    public final void fa0(int r5, int r6, int r7) {
        boolean r1 = false;
        if (Nt() == true) goto L10;
        if (jc1.k.f(IInteractService.class) == null) goto L7;
        boolean r0 = jc1.k.f(IInteractService.class).currentUILayoutNeedAdjustCommentHeight(this.W);
    L8:
        if (r0 == true) goto L10;
    L16:
        wd r2 = new wd();
        int r8 = r5 + r6;
        if (yb0() == true) goto L19;
        r8 = r8 + com.bytedance.android.live.core.utils.s1.j(2131168680);
    L19:
        r2.a = (r8 + Sa0()) + r7;
        this.W.put("cmd_normal_gift_layout_bottom_margin_update", r2);
        return;
    L7:
        r0 = false;
    L10:
        if (this.q.getLinkMap() != null) goto L12;
    L14:
        if (r1 == true) goto L16;
        return;
    L12:
        if (this.q.getLinkMap().containsKey(String.valueOf(1)) == false) goto L14;
        r1 = true;
        goto L14
    }

    public void ib0(boolean r4, boolean r5, boolean r6) {
        if (isScreenPortrait() == true) goto L6;
        if (r5 == true) goto L6;
        return;
    L6:
        Yc0(r4);
        boolean r7 = RTLUtil.isAppRTL(getContext());
        int r0 = this.A.getWidth();
        if (r7 == false) goto L9;
        r0 = -r0;
    L9:
        this.A.setVisibility(8);
        if (r4 == false) goto L18;
        if (r5 == true) goto L13;
    L14:
        this.A.setX(r0);
    L15:
        this.W.put("cmd_show_screen", Boolean.FALSE);
        zg1.s r8 = new zg1.s(true);
        xs2.b.a().post(r8);
        DataCenter r1 = this.W;
        if (r1 == null) goto L26;
        o70.c.a(Integer.valueOf(r1.hashCode())).b(r8);
    L26:
        if (bl.a.getValue().booleanValue() == false) goto L34;
        if (r5 == true) goto L29;
    L30:
        if (r5 == true) goto L35;
        if (r4 == true) goto L36;
    L32:
        xs2.b.a().post(new ToolbarClearScreenEvent(((Boolean) com.bytedance.android.livesdk.sharedpref.b.V.getValue()).booleanValue(), false));
        return;
    L36:
        return;
    L35:
        return;
    L29:
        if (LiveRecordWidget.L == false) goto L32;
    L34:
        return;
    L13:
        if (isScreenPortrait() == false) goto L15;
    L18:
        if (r5 == true) goto L20;
    L21:
        this.A.setX(0.0f);
    L22:
        this.A.setVisibility(0);
        this.W.put("cmd_show_screen", Boolean.TRUE);
        zg1.s r9 = new zg1.s(false);
        xs2.b.a().post(r9);
        DataCenter r2 = this.W;
        if (r2 == null) goto L26;
        o70.c.a(Integer.valueOf(r2.hashCode())).b(r9);
        goto L26
    L20:
        if (isScreenPortrait() == false) goto L22;
        goto L21
    }

    public void onActivityResult(int r3, int r4, Intent r5) {
        if (MultiLinkLoadWidgetUtils.g() == false) goto L10;
        AudioSceneBasicBusinessContentWidget r0 = this.v1;
        if (r0 != null) goto L7;
    L16:
        m00.f r1 = this.V1;
        if (r1 == null) goto L20;
        r1.onActivityResult(r3, r4, r5);
        return;
    L20:
        return;
    L7:
        if (r0.l == false) goto L16;
        r0.onActivityResult(r3, r4, r5);
        return;
    L10:
        yh0.b r2 = this.p1;
        if (r2 == null) goto L16;
        if (r2.isPickingImage() == false) goto L16;
        this.p1.onActivityResult(r3, r4, r5);
    }

    public final void zb0(View r28, Bundle r29, Room r30) {
        int r0 = com.bytedance.android.livesdk.performance.degrade.f.a;
        ALogger.i("DeviceDegrade", "LivePlayFragment observePlayerEventHub reSetHasFirstFrame false");
        this.W.put("interaction_on_view_created", Boolean.TRUE);
        int r1 = com.bytedance.live.datacontext.d.a;
        Intrinsics.checkNotNullParameter(this, "owner");
        this.Y = (InteractionContext) com.bytedance.live.datacontext.d.b(this, null).a(InteractionContext.class);
        ALogger.i("interactionContext", "abs create hashcode=" + this.Y.hashCode());
        Intrinsics.checkNotNullParameter(this, "owner");
        CommentContext r2 = com.bytedance.live.datacontext.d.b(this, null).a(CommentContext.class);
        this.Z = r2;
        r2.getInteractionRootView().setValue(this.J);
        com.bytedance.live.datacontext.d.c(this.Y, InteractionContext.TAG);
        com.bytedance.live.datacontext.d.c(this.Z, "CommentContext" + this.W.hashCode());
        this.Y.getInterceptViewTouchListener().setValue(this.U3);
        InteractionWidgetsPosContext r3 = Ya0();
        DataCenter r4 = this.W;
        if (r30 == null) goto L5;
        long r5 = r30.getId();
    L6:
        r3.share(r4, r5);
        Ya0().share();
        if (((Boolean) vm2.h.e3.getValue(null, vm2.h.a[211(0xd3, float:2.96E-43)])).booleanValue() == false) goto L12;
        Observable r6 = jc1.k.f(IKtvService.class).getKtvAllStateObservable();
        if (r6 == null) goto L12;
        ((ObservableSubscribeProxy) r6.as(AutoDispose.bind(this))).subscribe(new u2(this));
    L12:
        if (jc1.k.f(ILinkServiceExternal.class).getPkServiceExternal() == null) goto L15;
        jc1.k.f(ILinkServiceExternal.class).getPkServiceExternal().a(this.x3);
    L15:
        if (getContext() != null) goto L17;
    L24:
        IRoomContextService r7 = jc1.k.f(IRoomContextService.class);
        if (r7 == null) goto L27;
        PageUIContext r8 = PageUIContext.getContext(r7.getRoomDataContext(this.W, 0));
    L28:
        if (r8 == null) goto L30;
        r8.getInteractUIInfo().setValue(this);
    L30:
        PublicScreenStyleHelper.d(this.D3.booleanValue(), this.T);
        this.X.getCloseRoomInterceptors().d(this.U);
        String r9 = Ra0();
        String r10 = ViewModuleManager.g;
        FragmentManager r11 = getChildFragmentManager();
        getContext();
        ViewModuleManager r12 = new ViewModuleManager();
        r12.d = r28;
        FragmentTransaction r13 = r11.beginTransaction();
        LandscapeRestrictionOperation r14 = LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD;
        String r15 = ViewModuleManager.g;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r13, r12, r14, r15, 0) == true) goto L34;
        r13 = r13.add(r12, r15);
    L34:
        r13.commitNowAllowingStateLoss();
        this.P0 = r12;
        this.e = RecyclableWidgetManager.ga0(this, r28);
        DataCenter r16 = this.W;
        if (r16 == null) goto L37;
        r16.put("enable_rxjava_async", Boolean.valueOf(((n41) com.bytedance.android.livesdk.x5.a.getValue()).d()));
    L37:
        this.e.d = com.bytedance.android.live.core.tetris.widgets.h.c();
        this.e.setDataCenter(this.W);
        this.e.setWidgetConfigHandler(new com.bytedance.android.livesdk.chatroom.widget.i2(this.X, this.W));
        if (this.v2 == false) goto L43;
        GameAbsInteractionDelegate r17 = this.p2;
        if (r17 == null) goto L43;
        r17.b = this.e;
    L43:
        if (this.D3.booleanValue() == true) goto L49;
        IVSPlayerService r18 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r18 == null) goto L49;
        if (r18.provideVSPlayerViewControlService(this.W) == null) goto L49;
        r18.provideVSPlayerViewControlService(this.W).i(this.e);
    L49:
        Hc0();
        Gc0(r9);
        if (this.D3.booleanValue() == true) goto L69;
        LiveVisibilityControlContext.Companion.getClass();
        if (LiveVisibilityControlContext.a.a() == false) goto L69;
        com.bytedance.android.livesdk.chatroom.utils.h1.a r19 = com.bytedance.android.livesdk.chatroom.utils.h1.b;
        DataCenter r20 = this.W;
        r19.getClass();
        IVisibilityControlService r21 = com.bytedance.android.livesdk.chatroom.utils.h1.a.g(r20);
        if (r21 == null) goto L69;
        r21.injectWidgetManager(this.e);
        Disposable r22 = this.p;
        if (r22 != null) goto L58;
    L60:
        RoomContext r23 = this.X;
        DataCenter r24 = this.W;
        Room r25 = this.q;
        if (r23 == null) goto L64;
        if (r24 == null) goto L64;
        if (r25 == null) goto L67;
        ALogger.d(com.bytedance.android.livesdk.chatroom.utils.h1.a, "room != null. id is " + r25.getId());
        com.bytedance.android.livesdk.chatroom.utils.h1.a.e(r25, r24, r23);
    L67:
        Disposable r26 = r23.getInteractionDataPrepared().a().subscribe(new com.bytedance.android.livesdk.chatroom.utils.g1(r24, r23));
    L68:
        this.p = r26;
    L64:
        r26 = null;
        goto L68
    L58:
        if (r22.isDisposed() == true) goto L60;
        this.p.dispose();
    L69:
        com.bytedance.android.live.core.tetris.layer.view.a r27 = Va0();
        mg2.d.a r31 = mg2.d.a;
        FrameLayout r110 = this.Z2;
        FrameLayout r32 = this.Y2;
        DataCenter r111 = this.W;
        r31.getClass();
        Intrinsics.checkNotNullParameter(r110, "fontLayerMasterView");
        Intrinsics.checkNotNullParameter(r32, "layerMasterView");
        Intrinsics.checkNotNullParameter(this, "lifecycle");
        Intrinsics.checkNotNullParameter(r27, "config");
        ComponentManagerABHelper r112 = ComponentManagerABHelper.INSTANCE;
        boolean r33 = r112.enableRoomScene();
        boolean r34 = r112.enableRoomSceneMerge();
        if (r33 == false) goto L73;
        if (r34 == false) goto L73;
        ComponentManagerFactory.config.1 r35 = com.bytedance.android.live.core.tetris.a.b(com.bytedance.android.live.core.tetris.a.a, r32.getContext(), new mg2.c(r110, r32), this, r27, r111, "Live");
        Intrinsics.checkNotNullParameter(r35, "config");
        mg2.a r36 = new mg2.a(new ComponentManager(r35));
    L77:
        this.f = r36;
        HashMap r37 = new HashMap();     // Catch: Exception -> L105
        String r38 = String.valueOf(this.q.getId());     // Catch: Exception -> L105
        int r39 = com.bytedance.android.live.core.utils.h1.a;     // Catch: Exception -> L105
        String r40 = com.bytedance.android.live.core.utils.i1.a(this.q.getStreamType());     // Catch: Exception -> L105
        r37.put("room_id", r38);     // Catch: Exception -> L105
        r37.put("live_type", r40);     // Catch: Exception -> L105
        String r41 = "1";
        if (this.D3.booleanValue() == false) goto L82;
        Object r42 = "1";
    L83:
        r37.put("is_anchor", r42);     // Catch: Exception -> L105
        if (r112.enable() == false) goto L86;
        Object r43 = "1";
    L87:
        r37.put("enable", r43);     // Catch: Exception -> L105
        if (r112.enableRoomSceneScheduler() == false) goto L90;
        Object r44 = "1";
    L91:
        r37.put("enable_scheduler", r44);     // Catch: Exception -> L105
        if (r112.enableRoomSceneMerge() == false) goto L94;
        Object r45 = "1";
    L95:
        r37.put("enable_scene_merge", r45);     // Catch: Exception -> L105
        if (r112.enableFragmentReset() == false) goto L98;
        Object r46 = "1";
    L99:
        r37.put("enable_fragment_reset", r46);     // Catch: Exception -> L105
        if (r112.enableFullLog() == true) goto L103;
        r41 = "0";
    L103:
        r37.put("full_log", r41);     // Catch: Exception -> L105
        r37.put("uid", String.valueOf(TTLiveSDKContext.getHostService().h().n()));     // Catch: Exception -> L105
        com.bytedance.android.livesdk.log.u.l().sendLog("ttlive_componentx_log", r37, new Object[0]);     // Catch: Exception -> L105
    L108:
        if (com.bytedance.android.live.core.tetris.widgets.g.a() == false) goto L115;
        i91 r47 = com.bytedance.android.live.core.tetris.widgets.g.c();
        if (r47 == null) goto L112;
        boolean r48 = r47.h();
    L113:
        if (r48 == false) goto L115;
        boolean r49 = true;
    L116:
        if (r49 == false) goto L123;
        com.bytedance.android.livesdk.widget.monitor.l r50 = new com.bytedance.android.livesdk.widget.monitor.l(this.W);
        this.W2 = r50;
        this.e.ia0(r50);
        ArrayList r51 = new ArrayList();
        com.bytedance.android.livesdk.widget.monitor.l r52 = this.W2;
        if (r52 == null) goto L120;
        r51.add(r52);
    L120:
        DataCenter r53 = this.W;
        if (r53 == null) goto L123;
        r53.put("data_live_widget_lifecycle_observers", r51);
    L123:
        final View r54 = getView();
        if (r54 != null) goto L127;
        return;
    L127:
        if (Fa0() == false) goto L193;
        if (((Boolean) this.X.isFirstLoadFS().getValue()).booleanValue() == false) goto L131;
        Nb0();
    L131:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r55 = this.f3;
        if (RoomContext.getShared(this.W) != null) goto L134;
    L138:
        int r56 = 0;
    L139:
        com.bytedance.android.live.core.tetris.componentx.schedule.j r57 = new com.bytedance.android.live.core.tetris.componentx.schedule.j();
        LinkedHashMap r58 = new LinkedHashMap();
        com.bytedance.android.live.core.setting.h0 r59 = com.bytedance.android.live.core.setting.h0.a;
        if (r59.getValue() == null) goto L161;
        com.bytedance.android.live.core.setting.p2 r60 = com.bytedance.android.live.core.setting.p2.a;
        if (((LiveMockStrategyDescriptorLoadConfig) r60.getValue()).getEnable() == true) goto L144;
    L153:
        com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.g r61 = (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.g) ((Map) r59.getValue()).get(String.valueOf(r56));
        if (r61 == null) goto L161;
        if (r61.b() == null) goto L161;
        o91 r62 = r61.b();
        if (r62 == null) goto L160;
        r58.put(0, Long.valueOf(r62.b()));
        r58.put(1, Long.valueOf(r62.c()));
        r58.put(2, Long.valueOf(r62.d()));
        r58.put(3, Long.valueOf(r62.a()));
    L160:
        r57.b = r58;
        r57.c = r61.a();
        r57.a = r56;
        goto L161
    L144:
        if (g1() == false) goto L149;
        if (((LiveMockStrategyDescriptorLoadConfig) r60.getValue()).getMockPortrait() == 0) goto L149;
        r56 = ((LiveMockStrategyDescriptorLoadConfig) r60.getValue()).getMockPortrait();
    L149:
        if (g1() == true) goto L153;
        if (((LiveMockStrategyDescriptorLoadConfig) r60.getValue()).getMockLandscape() == 0) goto L153;
        r56 = ((LiveMockStrategyDescriptorLoadConfig) r60.getValue()).getMockLandscape();
    L161:
        com.bytedance.android.livesdk.widgetdescriptor.m r63 = new com.bytedance.android.livesdk.widgetdescriptor.m();
        LayerDescriptorList r64 = new LayerDescriptorList();
        int r65 = fh1.c.a;
        DataCenter r66 = this.W;
        Room r67 = this.q;
        if (r67 == null) goto L164;
        long r68 = r67.getId();
    L166:
        if (fh1.c.a(r66, Long.valueOf(r68)) == true) goto L168;
        r64.addAll(r63.e());
        r64.addAll(r63.c());
    L168:
        r64.addAll(r63.g());
        r64.addAll(r63.i());
        r64.addAll(r63.j());
        r64.addAll(r63.d());
        LayerDescriptorList r69 = new LayerDescriptorList();
        DataCenter r70 = this.W;
        Room r71 = this.q;
        if (r71 == null) goto L171;
        long r113 = r71.getId();
    L173:
        if (fh1.c.a(r70, Long.valueOf(r113)) == true) goto L175;
        r69.addAll(r63.k());
        r69.addAll(r63.b());
    L175:
        r69.addAll(r63.h());
        r69.addAll(r63.f());
        LinkedHashMap r72 = new LinkedHashMap();
        r72.put(mg2.e.c, r64);
        r72.put(mg2.e.e, r69);
        if (Fa0() == false) goto L178;
        ad0();
    L178:
        ComponentSchedulingManager.ScenInfo r73 = ComponentSchedulingManager.ScenInfo.AUDIENCE_PORTRAIT;
        RoomContext r75 = this.X;
        if (r75 == null) goto L186;
        if (r75.isAnchor().getValue() == null) goto L186;
        if (((Boolean) this.X.isAnchor().getValue()).booleanValue() == false) goto L186;
        r73 = ComponentSchedulingManager.ScenInfo.ANCHOR;
    L188:
        ComponentSchedulingManager.ScenInfo r210 = r73;
        this.f.g(new com.bytedance.android.live.core.tetris.componentx.schedule.c(Ha0().booleanValue(), false), r210, r72, r55, r57, new z3(this));
        if (((Boolean) this.X.isFirstLoadFS().getValue()).booleanValue() == true) goto L191;
        Nb0();
    L191:
        this.X.isFirstLoadFS().setValue(Boolean.FALSE);
    L335:
        if (this.W == null) goto L338;
        jc1.k.f(IEpisodeInteractiveService.class).setUpForTemplate(this.f3, this.W);
    L338:
        if (UserSetting.b() == false) goto L343;
        RoomContext r76 = this.X;
        if (r76 == null) goto L343;
        r76.getUserContext().c(new com.bytedance.android.livesdk.chatroom.ui.d(this));
    L343:
        if (this.D3.booleanValue() == true) goto L345;
        AnchorMainPostOptUtils.b("onLoadWidgets", new com.bytedance.android.livesdk.chatroom.ui.o(this));
    L345:
        mg2.d r77 = this.f;
        f70.b r78 = mg2.e.e;
        WeakReference r79 = new WeakReference(r77.f(r78));
        HashMap r80 = new HashMap();
        r80.put("AnimationLayerWidget", "com.bytedance.android.livesdk.widgetdescriptor.AnimationLayerWidgetDescriptor");
        r80.put("ShadowPlayerWidget", "com.bytedance.android.livesdk.widgetdescriptor.ShadowPlayerTetrisDescriptor");
        r80.put("FansRankListAnimationWidget", "com.bytedance.android.livesdk.widgetdescriptor.FansRankListAnimationDescriptor");
        r80.put("CommentWidget", "com.bytedance.android.livesdk.widgetdescriptor.comment.CommentWidgetDescriptor");
        r80.put("LiveToolbarWidget", "com.bytedance.android.livesdk.widgetdescriptor.toolbar.ToolbarDescriptor");
        r80.put("RightCardPlaceHolder", "com.bytedance.android.livesdk.room.placeholder.descriptor.RightCardPlaceHolderWidgetDescriptor");
        r80.put("NewLiveDrawerEntranceWidget", "com.bytedance.android.live.room.discovery.drawer.NewLiveDrawerEntranceDescriptor");
        r80.put("GiftWidgetKt", "com.bytedance.android.livesdk.widgetdescriptor.gift.GiftWidgetDescriptor");
        r80.put("PortraitCommonCardServiceWidget", "com.bytedance.android.live.messagewindow.business.widget.desc.PortraitCommonCardServiceWidgetDescriptor");
        r80.put("PortraitCastScreenServiceWidgetForByteCast", "com.bytedance.android.livesdk.castscreen.descriptor.PortraitCastScreenServiceDescriptor");
        r80.put("ShadowPlayerBottomWidget", "com.bytedance.android.livesdk.castscreen.descriptor.GameCastPlayerBackgroundWidgetBottomDescriptor");
        r80.put("MultiPlayerWidget", "com.bytedance.android.livesdk.widgetdescriptor.MultiPlayerTetrisDescriptor");
        r80.put("DragPlayerWidget", "com.bytedance.android.livesdk.widgetdescriptor.DragPlayerWidgetDescriptor");
        r80.put("RoomcatWidget", "com.bytedance.android.livesdk.widgetdescriptor.RoomcatWidgetDescriptor");
        r80.put("SingleViewPlaceHolder", "com.bytedance.android.livesdk.room.placeholder.descriptor.PlayerBottomPlaceHolderWidgetDescriptor");
        r80.put("InteractivityResourceServiceWidget", "com.bytedance.android.livesdk.widgetdescriptor.comment.InteractivityResourceServiceWidgetDescriptor");
        r80.put("WelfareAudienceWelfareServiceWidget", "com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right.WelfareAudienceServiceDescriptor");
        r80.put("ProfileServiceWidget", "com.bytedance.android.livesdk.chatroom.profile.servicewidget.ProfileServiceWidgetDescriptor");
        r80.put("ClearMonitorServiceWidget", "com.bytedance.android.livesdk.chatroom.widget.ClearMonitorServiceWidgetDescriptor");
        r80.put("XBridgeServiceWidget", "com.bytedance.android.livesdk.chatroom.widget.XBridgeServiceWidgetDescriptor");
        r80.put("ShareFansWidget", "com.bytedance.android.livesdk.dislike.sharefans.widget.ShareFansWidgetDescriptor");
        r80.put("VideoOrLinkShellCardWidget", "com.bytedance.android.live.messagewindow.business.tetris.desc.VideoOrLinkShellCardTetrisDesc");
        r80.put("PortraitZDanmakuWidget", "com.bytedance.android.livesdk.widgetdescriptor.barrage.PortraitBarrageDescriptor");
        r80.put("CarnivalDanmakuWidget", "com.bytedance.android.livesdk.widgetdescriptor.barrage.PortraitChatCarnivalBarrageDescriptor");
        r80.put("RoomPushWidget", "com.bytedance.android.livesdk.widgetdescriptor.RoomPushDescriptor");
        r80.put("EnterAnimWidget", "com.bytedance.android.livesdk.widgetdescriptor.EnterAnimDescriptor");
        r80.put("DiggWidget", "com.bytedance.android.livesdk.widgetdescriptor.DiggWidgetDescriptor");
        r80.put("LiveRoomNotifyWidget", "com.bytedance.android.livesdk.widgetdescriptor.RoomNotifyWidgetDescriptor");
        r80.put("CeremonyPrizeNoticeWidget", "com.bytedance.android.livesdk.widgetdescriptor.CeremonyPrizeNoticeWidgetDescriptor");
        r80.put("LiveRecordWidget", "com.bytedance.android.livesdk.widgetdescriptor.LiveRecordWidgetDescriptor");
        r80.put("LiveBacktrackWidget", "com.bytedance.android.livesdk.widgetdescriptor.LiveBacktrackWidgetDescriptor");
        r80.put("CommonLottieAnimationWidget", "com.bytedance.android.livesdk.widgetdescriptor.common.CommonLottieAnimationDescriptor");
        r80.put("CommonPopupMessageWidget", "com.bytedance.android.livesdk.widgetdescriptor.CommonPopupWidgetDescriptor");
        r80.put("PaidLiveTicketSaleCardWidget", "com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.saleticket.PaidLiveTicketSaleCardWidgetDescriptor");
        r80.put("IllegalLoadingWidget", "com.bytedance.android.livesdk.widgetdescriptor.IllegalLoadingWidgetDescriptor");
        r80.put("AudienceGameWidget", "com.bytedance.android.livesdk.widgetdescriptor.AudienceGameWidgetDescriptor");
        r80.put("AudienceMiniAppWidget", "com.bytedance.android.live.openplatform.impl.miniappaudience.widget.AudienceMiniAppWidgetDescriptor");
        r80.put("VSLiveDetailWidget", "com.bytedance.android.livesdk.widgetdescriptor.VSLiveDetailWidgetDescriptor");
        WidgetService.getInstance().registerWidgetLoader(r80.keySet(), new lv2.a(r80, r79));
        mg2.d r81 = this.f;
        if (r81 == null) goto L349;
        r81.b(r78, new com.bytedance.android.livesdk.widgetdescriptor.m().a());
    L349:
        if (Ha0().booleanValue() == false) goto L353;
        this.C3 = false;
        in1.b.c("part show start");
        rv2.a r82 = this.u3;
        if (r82 == null) goto L367;
        r82.I();
    L367:
        if (getDialog() == null) goto L372;
        Window r83 = getDialog().getWindow();
        if (r83 == null) goto L371;
        r83.setBackgroundDrawable(new ColorDrawable(0));
        r83.setSoftInputMode(50);
    L371:
        getDialog().setOnKeyListener(this.r3);
    L372:
        Runnable r84 = this.R3;
        if (r84 == null) goto L375;
        r54.post(r84);
        this.R3 = null;
    L375:
        Fc0();
        Tb0();
        if (tb1.c.a == false) goto L378;
        ((ObservableSubscribeProxy) Observable.just(this).delay(60000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(this))).subscribe(new com.bytedance.android.livesdk.chatroom.ui.r(), RxUtil.getNoOpThrowable());
    L378:
        RoomContext r85 = com.bytedance.live.datacontext.d.e(RoomContext.class, RoomContext.class);
        if (r85 != null) goto L381;
    L385:
        com.bytedance.android.live.core.tetris.widgets.d.g("oldOnViewCreated end");
        RoomContext r86 = this.X;
        if (r86 != null) goto L388;
    L390:
        LivePopupWindowManager r87 = (LivePopupWindowManager) LivePopupWindowManager.d.getValue();
        this.K2 = r87;
        if (r87 == null) goto L396;
        if (getContext() == null) goto L396;
        this.K2.b(getContext());
    L396:
        if (this.D3.booleanValue() == false) goto L399;
        AnchorMainPostOptUtils.b("onLoadWidgets", new com.bytedance.android.livesdk.chatroom.ui.o(this));
    L399:
        if (this.m == true) goto L401;
        Aa0(new com.bytedance.android.livesdk.chatroom.ui.e(this));
        this.m = true;
    L401:
        Iterator r88 = ((ArrayList) this.l3).iterator();
    L403:
        if (r88.hasNext() == false) goto L405;
        ((is2.f) r88.next()).LJ(this.q);
        goto L403
    L405:
        y50.c.d.a("inter_fragment_view_created");
        return;
    L388:
        if (((Integer) r86.getMediaReviewStatus().getValue()).intValue() != 4) goto L390;
        this.X.getMediaReviewStatus().setValue(5);
        goto L390
    L381:
        if (r85.getVoiceTalkRoomSubScene().getValue() == null) goto L385;
        if (this.W == null) goto L385;
        ((ObservableSubscribeProxy) ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r85.getVoiceTalkRoomSubScene().getValue()).a().as(AutoDispose.bind(this))).subscribe(new com.bytedance.android.livesdk.chatroom.ui.s(this, r54));
        goto L385
    L353:
        this.C3 = true;
        in1.b.c("direct complete show start");
        if (this.D3.booleanValue() == false) goto L356;
    L364:
        AnchorMainPostOptUtils.b("onDirectCompleteShow", new com.bytedance.android.livesdk.chatroom.ui.q(this));
    L365:
        ed0("interactionWidgetLoad");
        hc0(this.s);
        in1.b.c("direct complete show end");
        goto L367
    L356:
        if (in1.b.a.getEnableRoomWidgetOpt() == false) goto L364;
        rv2.a r89 = this.u3;
        if (r89 == null) goto L360;
        r89.I();
    L360:
        com.bytedance.android.livesdk.chatroom.room.p0 r90 = (com.bytedance.android.livesdk.chatroom.room.p0) this.W.get("zygote_event_hub", null);
        if (r90 == null) goto L396;
        r90.getP0WidgetLoaded().observe(this, new com.bytedance.android.livesdk.chatroom.ui.p(this));
    L186:
        if (g1() == true) goto L188;
        r73 = ComponentSchedulingManager.ScenInfo.AUDIENCE_LANDSCAPE;
        goto L188
    L171:
        r113 = 0;
        goto L173
    L164:
        r68 = 0;
        goto L166
    L134:
        if (RoomContext.getShared(this.W).getDynamicStrategy() == null) goto L138;
        if (RoomContext.getShared(this.W).getDynamicStrategy().getValue() == null) goto L138;
        r56 = ((ju1.n) ((IDynamicStrategyContext) RoomContext.getShared(this.W).getDynamicStrategy().getValue()).getStrategy("live_component_strategy").a).b(0);
        goto L139
    L193:
        if (((Boolean) this.X.isFirstLoadFS().getValue()).booleanValue() == false) goto L195;
        Nb0();
    L195:
        boolean r91 = g1();
        boolean r92 = this.D3.booleanValue();
        RoomContext r93 = this.X;
        if (r93 != null) goto L198;
        boolean r94 = false;
    L199:
        boolean r95 = yb0();
        boolean r96 = com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.a;
        if (r95 == false) goto L205;
        if (r91 == true) goto L203;
    L231:
        boolean r97 = false;
    L232:
        if (r97 == true) goto L234;
    L244:
        boolean r98 = g1();
        boolean r99 = this.D3.booleanValue();
        RoomContext r100 = this.X;
        if (r100 != null) goto L247;
        boolean r101 = false;
    L248:
        boolean r102 = yb0();
        if (PadConfigUtils.a() == false) goto L251;
    L254:
        boolean r103 = true;
    L255:
        if (r98 == false) goto L263;
        if (r99 == true) goto L263;
        if (r101 == true) goto L263;
        if (r102 == true) goto L263;
        if (r103 == true) goto L263;
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.d == false) goto L263;
        boolean r104 = true;
    L264:
        if (r104 == false) goto L320;
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("use new load task");
        l21 r105 = (l21) com.bytedance.android.live.core.setting.j0.a.getValue();
        Room r106 = this.q;
        int r107 = com.bytedance.android.livesdk.utils.h4.a;
        if (r106 != null) goto L268;
    L270:
        if (r106 == null) goto L276;
        Map r108 = r106.getLinkMap();
        if (r108 == null) goto L276;
        if (r108.containsKey(String.valueOf(9)) != true) goto L276;
        String r109 = "ktv";
    L291:
        o91 r114 = r105.c(r109);
        Map<String, Double> r115 = r105.b(r109);
        com.bytedance.android.livesdk.widgetdescriptor.m r116 = new com.bytedance.android.livesdk.widgetdescriptor.m();
        LayerDescriptorList r117 = new LayerDescriptorList();
        int r118 = fh1.c.a;
        DataCenter r119 = this.W;
        Room r120 = this.q;
        if (r120 == null) goto L294;
        long r121 = r120.getId();
    L296:
        if (fh1.c.a(r119, Long.valueOf(r121)) == true) goto L298;
        r117.addAll(r116.e());
        r117.addAll(r116.c());
    L298:
        r117.addAll(r116.g());
        r117.addAll(r116.i());
        r117.addAll(r116.j());
        r117.addAll(r116.d());
        LayerDescriptorList r122 = new LayerDescriptorList();
        DataCenter r123 = this.W;
        Room r124 = this.q;
        if (r124 == null) goto L301;
        long r125 = r124.getId();
    L303:
        if (fh1.c.a(r123, Long.valueOf(r125)) == true) goto L305;
        r122.addAll(r116.k());
        r122.addAll(r116.b());
    L305:
        r122.addAll(r116.h());
        r122.addAll(r116.f());
        com.bytedance.android.livesdk.widgetdescriptor.priority.b r126 = new com.bytedance.android.livesdk.widgetdescriptor.priority.b(r115, new com.bytedance.android.livesdk.widgetdescriptor.priority.e(r117, r122), this.W, this.f3);
        r126.a.e();
        this.v3 = new com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.d(r114, r126, this.f);
        w3 r127 = new w3(this);
        Intrinsics.checkNotNullParameter(this, "widgetLoadStep");
        Intrinsics.checkNotNullParameter(r127, "interactionRoomSupplier");
        if (r114 == null) goto L308;
        String r128 = r114.e();
    L309:
        int r129 = l21.a;
        if (Intrinsics.areEqual(r128, "inOrder") == false) goto L313;
        com.bytedance.android.livesdk.widget.schedule.v2.e r130 = new com.bytedance.android.livesdk.widget.schedule.v2.e(this, r127, r114);
    L319:
        this.u3 = r130;
    L321:
        this.X.getWidgetLoadTaskScheduler().c(new y3(this));
        if (this.D3.booleanValue() == true) goto L331;
        if (this.q.getRoomCart() == null) goto L331;
        if (this.q.getRoomCart().getContainCart() == false) goto L331;
        IEnterGuideService r131 = jc1.k.f(IEnterGuideService.class);
        if (r131 == null) goto L331;
        Widget r132 = r131.createCouponDialogWidget(getContext());
        this.y1 = r132;
        this.e.load(r132);
    L331:
        if (((Boolean) this.X.isFirstLoadFS().getValue()).booleanValue() == true) goto L333;
        Nb0();
    L333:
        this.X.isFirstLoadFS().setValue(Boolean.FALSE);
        goto L335
    L313:
        if (Intrinsics.areEqual(r128, "together") == false) goto L316;
        r130 = new com.bytedance.android.livesdk.widget.schedule.v2.g(this, r127, r114);
        goto L319
    L316:
        if (Intrinsics.areEqual(r128, "trigger") == false) goto L318;
        r130 = new com.bytedance.android.livesdk.widget.schedule.v2.d(this, r127);
        goto L319
    L318:
        r130 = new com.bytedance.android.livesdk.widget.schedule.v2.g(this, r127, r114);
        goto L319
    L308:
        r128 = null;
        goto L309
    L301:
        r125 = 0;
        goto L303
    L294:
        r121 = 0;
    L276:
        if (r106 == null) goto L280;
        RoomLifeGrouponInfo r133 = r106.lifeGrouponInfo;
        if (r133 == null) goto L280;
        Long r134 = r133.getPermissionStatus();
    L281:
        if (r134 != null) goto L284;
    L286:
        if (r106 != null) goto L288;
    L290:
        r109 = "default";
        goto L291
    L288:
        if (r106.isGameCPRoom() != true) goto L290;
        r109 = "game_promote";
        goto L291
    L284:
        if (r134.longValue() != 1) goto L286;
        r109 = "life_group";
    L280:
        r134 = null;
        goto L281
    L268:
        if (r106.isHasCommerceGoods() != true) goto L270;
        r109 = "ec";
        goto L291
    L320:
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("use old load task");
        this.u3 = new LiveWidgetLoadTaskScheduler(this.t3, new x3(this));
    L263:
        r104 = false;
        goto L264
    L251:
        if (FoldScreenUtils.e() == true) goto L254;
        r103 = false;
        goto L255
    L247:
        r101 = r100.isMediaRoom();
        goto L248
    L234:
        if (this.f3 == null) goto L244;
        if (this.f == null) goto L244;
        com.bytedance.android.livesdk.widget.schedule.v2.f.b("use strategy load task");
        com.bytedance.android.livesdk.widgetdescriptor.m r135 = new com.bytedance.android.livesdk.widgetdescriptor.m();
        DataCenter r136 = this.W;
        com.bytedance.android.livesdk.widgetdescriptor.e0 r137 = this.f3;
        boolean r138 = MultiRoomConfig.INSTANCE.enableRoomPreload();
        int r139 = fh1.c.a;
        DataCenter r140 = this.W;
        Room r141 = this.q;
        if (r141 == null) goto L240;
        long r142 = r141.getId();
    L241:
        lw2.a r143 = new lw2.a(r135, r136, r137, r138, fh1.c.a(r140, Long.valueOf(r142)));
        this.u3 = r143.a(this, new v3(this));
        this.X2 = r143.f;
        mg2.d r144 = this.f;
        Intrinsics.checkNotNullParameter(r144, "componentManager");
        this.v3 = new com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.d(r143.b, r143.e, r144);
        com.bytedance.android.livesdk.widgetdescriptor.e0 r145 = this.f3;
        DataCenter r146 = this.W;
        Intrinsics.checkNotNullParameter(r145, "layerContext");
        LiveComponentShowDelegate r147 = new LiveComponentShowDelegate(r143.d, r145, r146);
        Lifecycle r148 = getLifecycle();
        if (r148 == null) goto L321;
        r148.addObserver(r147);
        goto L321
    L240:
        r142 = 0;
        goto L241
    L203:
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.e == false) goto L231;
    L230:
        r97 = true;
        goto L232
    L205:
        if (r94 == true) goto L208;
        if (r95 == true) goto L208;
        boolean r149 = true;
    L209:
        if (r92 == true) goto L214;
        if (r91 == false) goto L214;
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.a == false) goto L214;
        boolean r150 = true;
    L215:
        if (r92 == true) goto L220;
        if (r91 == true) goto L220;
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.b == false) goto L220;
        boolean r151 = true;
    L221:
        if (r92 == true) goto L223;
    L225:
        boolean r152 = false;
    L226:
        if (r149 == false) goto L231;
        if (r150 == true) goto L230;
        if (r151 == true) goto L230;
        if (r152 == false) goto L231;
    L223:
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.c == false) goto L225;
        r152 = true;
    L220:
        r151 = false;
    L214:
        r150 = false;
    L208:
        r149 = false;
        goto L209
    L198:
        r94 = r93.isMediaRoom();
        goto L199
    L112:
        r48 = false;
    L115:
        r49 = false;
        goto L116
    L98:
        r46 = "0";
        goto L99
    L94:
        r45 = "0";
        goto L95
    L90:
        r44 = "0";
        goto L91
    L86:
        r43 = "0";
        goto L87
    L82:
        r42 = "0";
    L105:
        e = move-exception;
        e.printStackTrace();
    L73:
        if (r33 == false) goto L75;
        Context r153 = r32.getContext();
        com.bytedance.android.live.core.tetris.a r154 = com.bytedance.android.live.core.tetris.a.a;
        ComponentManagerFactory.config.1 r155 = com.bytedance.android.live.core.tetris.a.b(r154, r153, new com.bytedance.android.live.core.tetris.b(r32), this, r27, r111, "Live");
        Intrinsics.checkNotNullParameter(r155, "config");
        ComponentManager r156 = new ComponentManager(r155);
        ComponentManagerFactory.config.1 r157 = com.bytedance.android.live.core.tetris.a.b(r154, r153, new com.bytedance.android.live.core.tetris.b(r110), this, r27, r111, "Live");
        Intrinsics.checkNotNullParameter(r157, "config");
        mg2.a r158 = new mg2.f(r156, new ComponentManager(r157));
    L76:
        r36 = r158;
        goto L77
    L75:
        com.bytedance.android.live.core.tetris.a r159 = com.bytedance.android.live.core.tetris.a.a;
        Intrinsics.checkNotNullParameter(r32, "masterView");
        Intrinsics.checkNotNullParameter(this, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r27, "config");
        LayerManager r160 = new LayerManager(r32, this);
        r160.b(r27, r111);
        Intrinsics.checkNotNullParameter(r110, "masterView");
        Intrinsics.checkNotNullParameter(this, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r27, "config");
        LayerManager r161 = new LayerManager(r110, this);
        r161.b(r27, r111);
        r158 = new mg2.f(r160, r161);
        goto L76
    L27:
        r8 = null;
        goto L28
    L17:
        if (this.W == null) goto L24;
        y50.c r162 = y50.c.d;
        r162.b("room_context_init");
        RoomContextInitHelper.b(this.X, getContext(), this.W, this.D3.booleanValue());
        r162.a("room_context_init");
        this.E3 = true;
        if (this.K3 <= 0) goto L21;
        boolean r163 = fh1.e.a;
        fh1.e.g(r30.getRoomId(), (System.currentTimeMillis() - this.K3) + "");
    L21:
        com.bytedance.android.live.core.tetris.widgets.d.g("RoomContextInitHelper init");
        PageUIContext r164 = PageUIContext.getContext(this.W);
        if (r164 == null) goto L24;
        r164.getVideoBottom().setValue(Integer.valueOf(this.y));
        goto L24
    L5:
        r5 = 0;
        goto L6
    }

    public final boolean G20(xy1.p r17, long r18, String r20, long r21) {
        DiggContext.a r0 = DiggContext.Companion;
        DataCenter r2 = this.W;
        r0.getClass();
        DiggContext r1 = DiggContext.a.a(r2);
        if (r1 == null) goto L10;
        if (r1.getDiggWidget().getValue() == null) goto L10;
        if (((u32.k) r1.getDiggWidget().getValue()).Eg() == false) goto L10;
        return false;
    L10:
        if (yy.a.getValue().intValue() == 1) goto L18;
        Map r3 = this.q.anchorAbMap;
        if (r3 != null) goto L14;
    L33:
        com.bytedance.android.livesdk.chatroom.utils.p.b.getClass();
        Room r4 = this.q;
        if (r4 == null) goto L72;
        RoomContext.a r5 = RoomContext.Companion;
        DataCenter r6 = this.W;
        long r7 = r4.getId();
        r5.getClass();
        RoomContext r8 = RoomContext.a.a(r6, r7);
        if (r8 == null) goto L72;
        if (r8.isVSRoom() == false) goto L72;
        return false;
    L72:
    L66:
        th = move-exception;
        Logger.e(th.getMessage());
    L68:
        return false;
    L41:
        if (getParentFragment() != null) goto L43;
    L65:
        return false;
    L43:
        if (getParentFragment().getActivity() == null) goto L65;
        if (jc1.k.f(IGiftServiceExternal.class).findLiteGiftById(r18) != null) goto L49;
        return false;
    L49:
        if (this.y3 != null) goto L51;
        this.y3 = jc1.k.f(IGiftServiceExternal.class).getGiftGuideDialog(getParentFragment().getActivity(), this.q, TTLiveSDKContext.getHostService().h().a, r17, r18, r20, r21, this.r, this.W);     // Catch: Throwable -> L66
    L51:
        Dialog r9 = this.y3;     // Catch: Throwable -> L66
        if (r9 == null) goto L68;
        if (r9.isShowing() == true) goto L68;
        if (com.bytedance.android.livesdk.slideuptip.k.e() == true) goto L68;
        Dialog r10 = this.y3;     // Catch: Throwable -> L66
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L70;
        DialogLancet.handleBlockedDialogShow(r10);     // Catch: Throwable -> L66
    L63:
        com.bytedance.android.livesdk.f.d().a();     // Catch: Throwable -> L66
        this.y3.setOnDismissListener(new q4(this));     // Catch: Throwable -> L66
        return true;
    L70:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L69 Throwable -> L66
    L62:
        DialogLancet.beforeDialogShow(r10);     // Catch: Throwable -> L66
        r10.show();     // Catch: Throwable -> L66
        DialogLancet.afterDialogShow(r10);     // Catch: Throwable -> L66
        goto L63
    L14:
        if (r3.get("gift_hide_tip") == null) goto L33;
        if (((String) this.q.anchorAbMap.get("gift_hide_tip")).equals("2") == false) goto L33;
    L18:
        if (VSDataContext.getInteractionContext(this.W) == null) goto L28;
        if (VSDataContext.getInteractionContext(this.W).isVSVideo() == null) goto L28;
        if (((Boolean) VSDataContext.getInteractionContext(this.W).isVSVideo().getValue()).booleanValue() == false) goto L25;
    L30:
        boolean r11 = true;
    L31:
        if (r11 == true) goto L33;
        return false;
    L25:
        if (this.q.getMRoomAuthStatus() == null) goto L30;
        r11 = this.q.getMRoomAuthStatus().getEnableGift();
    L28:
        if (this.q.getMRoomAuthStatus() == null) goto L30;
        r11 = this.q.getMRoomAuthStatus().getEnableGift();
        goto L31
    }

    public RoomState na0(Bundle r9, Room r10, Map<String, String> r11, Map<String, String> r12, Map<String, String> r13, boolean r14) {
        return ConvertorKt.d(false, isScreenPortrait(), r9, r10, r11, r12, r13, r14);
    }
}
