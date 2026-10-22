package com.bytedance.android.live.multilink.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.cloudgrouplive.model.CloudGroupLivePipelineStatus;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.setting.g3;
import com.bytedance.android.live.core.setting.r6;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.bgComponent.platform.MultiLinkThemeBgUIWidget;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ToolbarVideoInteractBehavior;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.LinkDialog;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.PlayModeService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.vm.MicRoomHostViewModel;
import com.bytedance.android.live.liveinteract.floatwindow.applywindow.LinkmicApplyFloatWindowManager;
import com.bytedance.android.live.liveinteract.interact.audience.InteractAudienceAnchorWidget;
import com.bytedance.android.live.liveinteract.interact.audience.InteractAudienceGuestWidget;
import com.bytedance.android.live.liveinteract.interact.audience.InteractAudienceVideoWindowManager;
import com.bytedance.android.live.liveinteract.interact.audience.fragment.InteractAudienceContainerFragment;
import com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.InteractAudienceContainerFragmentV2;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.base.LinkInternalServiceContext;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.multiroom.MultiLinkMicSeatDataWidget;
import com.bytedance.android.live.liveinteract.plantform.multiroom.MultiLinkUIWidget;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.liveinteract.plantform.utils.r;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.revenue.paid.profilecard.PaidProfileCardContext;
import com.bytedance.android.live.liveinteract.revenue.paid.profilecard.PaidProfileCardControlWidget;
import com.bytedance.android.live.liveinteract.revenue.paid.profilecard.PaidProfileCardWidget;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.review.LinkmicReviewWidget;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.videotalk.prepareapply.VideoTalkLinkIntegrationWidget;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.voicechat.dialog.VoiceChatRoomConfirmDialog;
import com.bytedance.android.live.liveinteract.voicechat.dialog.VoiceInteractSceneDialog;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.voicechat.radio.context.RadioStageContext;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessContext;
import com.bytedance.android.live.liveinteract.voicechat.toolbar.ToolbarAudioInteractBehavior;
import com.bytedance.android.live.liveinteract.voicechat.toolbar.ToolbarInteractSceneBehavior;
import com.bytedance.android.live.liveinteract.voicechat.toolbar.ToolbarMultiSceneGamePlayBehavior;
import com.bytedance.android.live.liveinteract.voicechat.toolbar.ToolbarRoomBattleBehavior;
import com.bytedance.android.live.liveinteract.voicechat.util.VoiceInteractSceneUtil;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.multilink.impl.control.setting.FetchSettingType;
import com.bytedance.android.live.multilink.impl.debug.BackupSeiDebugInfoAnchorWidget;
import com.bytedance.android.live.multilink.impl.debug.BackupSeiDebugInfoGuestWidget;
import com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.IMiddlewareMicRoomService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.NewPluginType;
import com.bytedance.android.livesdk.chatroom.model.FastStartKtvVideoModel;
import com.bytedance.android.livesdk.chatroom.ui.framework.LoadState;
import com.bytedance.android.livesdk.chatroom.viewmodel.LinkRequestMonitor;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdk.config.bc0;
import com.bytedance.android.livesdk.config.dn0;
import com.bytedance.android.livesdk.config.ff0;
import com.bytedance.android.livesdk.config.ib0;
import com.bytedance.android.livesdk.config.lf;
import com.bytedance.android.livesdk.config.m91;
import com.bytedance.android.livesdk.config.o30;
import com.bytedance.android.livesdk.config.qa0;
import com.bytedance.android.livesdk.config.rj1;
import com.bytedance.android.livesdk.config.vb1;
import com.bytedance.android.livesdk.config.xe;
import com.bytedance.android.livesdk.config.z40;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.wrds.MultiPreviewSyncDataType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfoKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.android.livesdkapi.depend.player.ILivePlatformPlayerProxy;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.live.ILiveExternalCameraServiceForOther;
import com.bytedance.android.livesdkapi.liveprocast.ILiveProDualDeviceServiceForOther;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.AudioRadioChatPanelConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.backupsei.LiveBackupSeiExperimentUtils;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.backupsei.MultiLinkBizBackupSeiExperimentUtils;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.util.WeakReferenceWrapper;
import com.bytedance.common.jato.views.JatoOptDrawableCache;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.DataContext;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LinkMultiControlWidget extends BaseLinkMultiControlWidget implements LinkMultiControlPresenter.IView, Observer<KVData>, com.bytedance.android.live.liveinteract.plantform.base.g {
    public final ToolbarMultiSceneGamePlayBehavior A;
    public Disposable B;
    public Disposable C;
    public CompositeDisposable D;
    public Disposable E;
    public Disposable F;
    public MicRoomHostViewModel G;
    public String H;
    public boolean I;
    public boolean J;
    public boolean K;
    public com.bytedance.android.live.liveinteract.chatroom.chatroom.model.c L;
    public final CompositeDisposable M;
    public final MultiLinkSeiIndicator N;
    public final BehaviorSubject<Boolean> O;
    public final a P;
    public final k1 Q;
    public Disposable R;
    public com.bytedance.android.live.liveinteract.widget.widget.v S;
    public boolean T;
    public final d U;
    public com.bytedance.android.live.liveinteract.plantform.core.y a;
    public InteractAudienceAnchorWidget b;
    public InteractAudienceGuestWidget c;
    public kn0.a d;
    public kn0.b e;
    public rj0.n f;
    public rj0.o g;
    public VideoTalkLinkIntegrationWidget h;
    public Widget i;
    public MultiLinkUIWidget j;
    public LinkMultiControlPresenter k;
    public IRoom l;
    public LiveMode m;
    public boolean n;
    public BaseLinkMultiControlWidget.a o;
    public int p;
    public final boolean q;
    public final ViewGroup r;
    public LinkInternalServiceContext s;
    public BackupSeiDebugInfoGuestWidget t;
    public LinkDialog u;
    public VoiceInteractSceneDialog v;
    public final ToolbarAudioInteractBehavior w;
    public final ToolbarVideoInteractBehavior x;
    public final ToolbarInteractSceneBehavior y;
    public final com.bytedance.android.live.liveinteract.voicechat.toolbar.e z;

    public class a implements gd0.u {
        public a() {
        }
    }

    public class b extends BaseJsBridgeMethodFactory {
        public final /* synthetic */ LinkMultiControlWidget a;

        public b(LinkMultiControlWidget r1) {
            this.a = r1;
        }

        public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideStatefulMethods(final IJsBridgeManager r4) {
            HashMap r0 = new HashMap();
            r0.put("tryApplyLink", new q1());
            r0.put("tryOpenInvitePanel", new s1());
            r0.put("startGuestBattle", new d2());
            r0.put("finishGuestBattle", new e2());
            r0.put("pauseGuestBattle", new f2());
            r0.put("resumeGuestBattle", new g2());
            r0.put("getFansClubStatus", new h2());
            r0.put("paidLinkMicApply", new i2());
            r0.put("openPlayModePanel", new j2(this));
            r0.put("sendQuickInteract", new k2());
            r0.put("multiAudioAudienceApply", new b2());
            r0.put("endInteractItem", new l2());
            r0.put("startInteractItem", new m2(this));
            r0.put("giftMessageBoardLinkmic", new n2());
            r0.put("getGiftMessageBoardPanelParam", new o2(this));
            r0.put("searchFriend", new p2());
            r0.put("sendJoinMatrixInvitation", new q2());
            r0.put("oneButtonOpenSceneAndPlayMode", new r2());
            r0.put("linkminkToolsCommon", new s2());
            r0.put("updateLinkmicStatus", new r1(this, r4));
            r0.put("getLinkmicStatus", new t1(this));
            r0.put("reportLinkmicStatus", new u1());
            r0.put("openMvSelectPanel", new v1());
            r0.put("openChooseGuestPanel", new w1(this));
            r0.put("sendGiftPlayerEvent", new x1());
            r0.put("sendInteractEffectEvent", new y1());
            r0.put("live.updateViewInLiveBg", new z1());
            r0.put("live.closeLink", new a2(this));
            r0.put("reportAggregateALog", new c2());
            return r0;
        }

        public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> provideStatelessMethods(IJsBridgeManager r3) {
            HashMap r4 = new HashMap();
            r4.put("interactInvite", new com.bytedance.android.live.liveinteract.jsbridge.method.x(((Widget) this.a).dataCenter));
            r4.put("interactAudienceInvite", new com.bytedance.android.live.liveinteract.jsbridge.method.v(((Widget) this.a).dataCenter));
            r4.put("interactAudioInvite", new com.bytedance.android.live.liveinteract.jsbridge.method.w(((Widget) this.a).dataCenter));
            r4.put("updateLinkmicSettingsSucceed", new com.bytedance.android.live.liveinteract.jsbridge.method.k1());
            r4.put("linkmicAudienceApply", new com.bytedance.android.live.liveinteract.jsbridge.method.u());
            r4.put("bigPartyAudienceApply", new com.bytedance.android.live.liveinteract.jsbridge.method.l1());
            return r4;
        }
    }

    public class c implements com.bytedance.android.live.liveinteract.widget.widget.v.a {
        public final /* synthetic */ LinkMultiControlWidget a;

        @Override // com.bytedance.android.live.liveinteract.widget.widget.v.a
        public final View c() {
            return this.a.o.c();
        }

        public c(LinkMultiControlWidget r1) {
            this.a = r1;
        }
    }

    public class d implements IHostPlugin.Callback {
        public final void onCancel(String r1) {
        }

        public final void onSuccess(String r1) {
        }

        public d() {
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ LinkMultiControlWidget a;

        public final void a() {
            StringBuilder r0 = new StringBuilder("preApply successCallback, handler is null: ");
            jc1.k.n(IBaseLiveActionHandler.class);
            r0.append(false);
            ALogger.d("LinkControlWidget", r0.toString());
            this.a.getClass();
            HashMap r1 = new HashMap();
            r1.put("live_type", "voice_live");
            r1.put("source", "pre_apply");
            r1.put("voice_mode", "head");
            r1.put("function_type", "audio_audience");
            r1.put("function_type2", "audio_audience");
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_apply", r1, new Object[]{IRoom.class, am2.x.class});
            tc0.c.h().I = Boolean.TRUE;
            Uri r2 = new u6(((AudioRadioChatPanelConfig) lf.a.getValue()).getPreapplyPanelSchema()).c();
            jc1.k.n(IBaseLiveActionHandler.class);
            jc1.k.n(IBaseLiveActionHandler.class).handle(((Widget) this.a).context, r2);
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

        public e(LinkMultiControlWidget r1) {
            this.a = r1;
        }
    }

    public class f implements jk0.a {
        public final /* synthetic */ int a;
        public final /* synthetic */ LinkMultiControlWidget b;

        public f(LinkMultiControlWidget r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final int getLayoutId() {
        return 2131567724;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final String getSpm() {
        return "a100.a100.a151";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void handleInteractClick() {
        Ik(false);
    }

    @Override // com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget, gd0.k
    public final void pi() {
        this.I = true;
        LinkMultiControlPresenter r0 = this.k;
        if (r0 == null) goto L6;
        r0.B0(this.l.getRoomId());
        this.I = false;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget
    public final String tag() {
        return "LinkMultiControlWidget";
    }

    @Override // com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget
    public final void wq() {
        this.T = true;
    }

    public static void Qq() {
        HashMap r0 = new HashMap();
        r0.put("action_type", "show");
        r0.put("live_type", "video_live");
        r0.put("function_type", "live");
        r0.put("source", "bottom");
        TalkRoomLogUtils.H0(r0);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_function_icon", r0, new Object[]{IRoom.class, am2.x.class});
    }

    public final boolean Aq() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L5;
        int r2 = r0.getCurrentScene();
    L7:
        if (gd0.v.a(this.p, 2) == false) goto L9;
        return false;
    L9:
        if (r2 == 4) goto L30;
        boolean r3 = us1.e.a;
        if (us1.e.a(this.l) == true) goto L14;
        return false;
    L14:
        if (r0 == null) goto L26;
        LiveMode r1 = this.m;
        if (r1 == LiveMode.VIDEO) goto L20;
        if (r1 == LiveMode.THIRD_PARTY) goto L20;
        return false;
    L20:
        if (nd() == false) goto L22;
        return false;
    L22:
        if (us1.e.c(((Widget) this).dataCenter, this.l, this.n) == false) goto L29;
        return true;
    L29:
        return false;
    L26:
        return false;
    L30:
        return false;
    L5:
        r2 = 0;
        goto L7
    }

    public final void Cq() {
        Pair r0 = com.bytedance.live.datacontext.d.a(new j1());
        MultiRevenueDataContext r1 = (MultiRevenueDataContext) r0.getFirst();
        com.bytedance.live.datacontext.b.a(r1, MultiRevenueDataContext.TAG);
        this.C = (Disposable) r0.getSecond();
        enableSubWidgetManager();
        PlayModeService r2 = new PlayModeService(((Widget) this).subWidgetManager);
        r1.getPlayModeManager().d(r2);
    }

    public final void Mq() {
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r0 = MultiRevenueDataContext.a.d();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.r == null) goto L13;
        Lazy r1 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "LinkMultiControlWidget", "loadDynamicWidget");
        if (this.l.isLiveTypeAudio() == false) goto L9;
        SceneType r2 = SceneType.SCENE_AUDIO_TALKROOM;
    L10:
        r0.o(((Widget) this).dataCenter, this, r2, this.r);
        return;
    L9:
        r2 = SceneType.SCENE_VIDEO_TALKROOM;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void Nf() {
        LinkMultiControlPresenter r0 = this.k;
        if (r0 == null) goto L6;
        r0.h.j.c(FetchSettingType.refreshAudienceSettings);
        return;
    }

    public final void Nq() {
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.PK.extended());
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.TEAM_FIGHT.extended());
        ALogger.i("CrossLink.loadMultiSceneGamePlayToolbar", "mMultiSceneGamePlayBehavior load");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r0 = y3.m(((Widget) this).dataCenter);
        ToolbarButton r1 = ToolbarButton.MULTI_SCENE_GAME_PLAY;
        r0.p(r1.extended(), this.A);
        y3.m(((Widget) this).dataCenter).c(r1.extended());
        this.A.dv(new pp1.m(0));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void Sc() {
        jc1.k.f(IPerformanceManager.class).onModuleStop("link_mic");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final boolean Sd() {
        if (this.d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void Tq() {
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        String r2 = "";
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "LinkMultiControlWidget#realOnCreate#" + hashCode(), "");
        ((ObservableSubscribeProxy) jc1.k.f(IBaseBrowserService.class).registerExternalMethodFactory(new b(this)).as(autoDispose())).subscribe();
        ((Widget) this).dataCenter.put("data_audio_chat_continue_linkmic_update_send_gift_status", Boolean.valueOf(this.q));
        this.l = (IRoom) ((Widget) this).dataCenter.get("data_room");
        this.n = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor")).booleanValue();
        this.m = (LiveMode) ((Widget) this).dataCenter.get("data_live_mode");
        ((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        MicRoomHostViewModel r1 = ViewModelProviders.of(((Widget) this).context).get(MicRoomHostViewModel.class);
        this.G = r1;
        r1.initViewModel(((Widget) this).dataCenter);
        if (this.l != null) goto L5;
    L18:
        Pair r3 = com.bytedance.live.datacontext.d.a(new t0());
        ((LinkInternalServiceContext) r3.getFirst()).getMultiService().d(this);
        ALogger.e("dzy-toolbar", "LinkMultiControlWidget init MultiService");
        com.bytedance.live.datacontext.b.a((LinkInternalServiceContext) r3.getFirst(), "ILinkMultiInternalService");
        this.s = (LinkInternalServiceContext) r3.getFirst();
        this.B = (Disposable) r3.getSecond();
        if (((Boolean) dn0.a.getValue()).booleanValue() == false) goto L26;
        if (jc1.k.f(IInteractService.class) == null) goto L26;
        if (((rj1) bc0.a.getValue()).a() == true) goto L26;
        ((IInteractService) jc1.k.f(IInteractService.class)).setDynamicFromAudience(false);
    L26:
        if (jc1.k.f(IMultiLinkServiceExternal.class).getPkServiceExternal() == null) goto L29;
        jc1.k.f(IMultiLinkServiceExternal.class).getPkServiceExternal().a(this.Q);
    L29:
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == true) goto L31;
        Cq();
    L31:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r4 = y3.m(((Widget) this).dataCenter);
        if (this.n == false) goto L42;
        IRoom r5 = this.l;
        if (r5 != null) goto L36;
    L40:
        r4.k(ToolbarButton.INTERACTION, this.x);
    L45:
        if (this.n == false) goto L50;
        if (this.m != LiveMode.VIDEO) goto L50;
        Qq();
    L50:
        if (this.n == true) goto L57;
        if (this.m != LiveMode.AUDIO) goto L57;
        if (vm2.d.y() == true) goto L57;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r6 = y3.m(((Widget) this).dataCenter);
        ToolbarButton r7 = ToolbarButton.INTERACTION_AUDIENCE;
        r6.k(r7, this.w);
        y3.m(((Widget) this).dataCenter).i(r7.extended());
    L57:
        if (this.n == true) goto L62;
        if (vm2.d.y() == true) goto L62;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION.extended());
    L62:
        if (gr() == false) goto L64;
        r4.k(ToolbarButton.INTERACTION_SCENE, this.y);
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION.extended());
    L64:
        boolean r8 = true;
        if (this.n == true) goto L70;
        if (Aq() == false) goto L70;
        br(true, "unload widget");
    L70:
        if (this.l != null) goto L72;
    L74:
        LinkMultiControlPresenter r9 = new LinkMultiControlPresenter(this.l, this.n, this.q, this.m, com.bytedance.android.live.liveinteract.api.utils.m.d(), com.bytedance.android.live.liveinteract.api.utils.m.i(), this.P, this);
        this.k = r9;
        r9.m0(this);
        if (vm2.d.q0().isUserInfoCenterForwardInit() == true) goto L77;
    L80:
        ((Widget) this).dataCenter.observeForever("data_interact_debug_info", this).observeForever("data_interact_update_room", this).observeForever("cmd_mic_room_anchor_status", this).observe("cmd_interact_audience_invite", this).observeForever("data_room_video_talk_integration_accept_audience_prepare_apply", this).observe("data_room_video_talk_integration_anchor_enable_link", this).observe("data_audience_recover_linkmic_online", this).observe("cmd_init_video_talk_room_with_pending_play_mode", this).observe("cmd_init_video_talk_room_with_pending_schema_config", this).observe("cmd_init_video_ktv", this).observe("cmd_ktv_component_init_link", this).observe("cmd_show_hide_scene_btn", this).observe("cmd_init_voice_chat_room_with_pending_play_mode", this).observe("cmd_interact_audio", this, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.c).observe("cmd_interact_real_time_chorus", this).observe("cmd_ktv_luanch", this).observe("data_cloud_group_live_pipeline_status", this);
        enableSubWidgetManager();
        if (this.n == false) goto L84;
        ((Widget) this).subWidgetManager.load(new LinkmicReviewWidget());
    L84:
        if (vm2.d.p0() == false) goto L86;
    L90:
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.e() == false) goto L93;
        ((Widget) this).subWidgetManager.load(new PaidProfileCardControlWidget());
    L93:
        int r10 = us1.g.a;
        if (this.h != null) goto L103;
        enableSubWidgetManager();
        VideoTalkLinkIntegrationWidget r11 = new VideoTalkLinkIntegrationWidget(this.l);
        this.h = r11;
        ((Widget) this).subWidgetManager.load(r11);
        if (this.n == true) goto L103;
        if (this.m != LiveMode.VIDEO) goto L103;
        if (this.p != 0) goto L102;
        this.h.wq();
        goto L103
    L102:
        this.h.xq();
    L103:
        Yq(jd0.i.class);
        Yq(jd0.h.class);
        Yq(jd0.c.class);
        this.D.add(xs2.b.a().b(u22.b.class).subscribe(new m1(this)));
        if (this.I == false) goto L109;
        LinkMultiControlPresenter r12 = this.k;
        if (r12 == null) goto L109;
        r12.B0(this.l.getRoomId());
        this.I = false;
    L109:
        if (Gq() == null) goto L111;
        Gq().a();
    L111:
        int r13 = u2.a;
        MultiPreviewSyncDataType[] r14 = MultiPreviewSyncDataType.values();
        int r15 = r14.length;
        int r16 = 0;
    L112:
        if (r16 >= r15) goto L114;
        MultiPreviewSyncDataType r17 = r14[r16];
        dc2.a.a(r17.getSyncKey(), r17.getDataClass());
        r16 = r16 + 1;
        goto L112
    L114:
        this.J = true;
        LinkMicRoomDataSyncModel r18 = LinkWRDSHelper.b();
        if (r18 == null) goto L120;
        if (r18.getTalkRoomSettingPb() == null) goto L120;
        ((ObservableSubscribeProxy) r18.getTalkRoomSettingPb().d.as(autoDisposeWithTransformer())).subscribe(new n1(this), new o1());
    L120:
        if (this.n == true) goto L127;
        IRoom r19 = this.l;
        if (r19 == null) goto L127;
        if (r19.getLinkerDetail() == null) goto L127;
        this.k.L0(this.l.getLinkerDetail().getAnchorAcceptAudiencePreApply());
    L127:
        if (this.n == false) goto L134;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r20 = TalkRoomLogUtils.a;
        HashMap r21 = new HashMap();
        r21.put("live_type", "video_live");
        if (Intrinsics.areEqual((Boolean) b6.d.getValue(), Boolean.TRUE) == false) goto L131;
        String r22 = "1";
    L132:
        r21.put("is_on", r22);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_preapply_status", r21, new Object[]{IRoom.class});
        goto L134
    L131:
        r22 = "0";
    L134:
        if (((m91) LiveInfraSettingKeys.LIVE_XML_AND_DRAWABLE_CACHE_CONFIG.getValue()).a() == true) goto L224;
    L139:
        com.bytedance.android.live.liveinteract.plantform.base.g.m0.onNext(this);
        com.bytedance.android.livesdk.log.filter.t r23 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r23 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L159;
        com.bytedance.android.livesdk.log.filter.t r24 = r23;
        String r25 = r24.l();
        String r26 = r24.e();
        String r110 = r24.m();
        if (TextUtils.equals(r25, "true") == false) goto L159;
        if (TextUtils.equals(r26, "prepare_reply") == false) goto L159;
        IRoom r27 = this.l;
        if (r27 == null) goto L148;
        long r28 = r27.getId();
    L149:
        IRoom r29 = this.l;
        if (r29 == null) goto L152;
        String r111 = r29.getOwnerUserIdString();
    L154:
        if (r28 == 0) goto L159;
        if (TextUtils.isEmpty(r111) == true) goto L159;
        this.k.o0(r28, r111, 1, r110);
        goto L159
    L152:
        r111 = "";
        goto L154
    L148:
        r28 = 0;
    L159:
        if (LiveBackupSeiExperimentUtils.INSTANCE.isEnableTestDebugInfo(this.l, this.n) == false) goto L165;
        ((Widget) this).containerView.setVisibility(0);
        enableSubWidgetManager();
        if (this.n == false) goto L164;
        ((Widget) this).subWidgetManager.load(2131363828, new BackupSeiDebugInfoAnchorWidget(), false);
        goto L165
    L164:
        BackupSeiDebugInfoGuestWidget r30 = new BackupSeiDebugInfoGuestWidget();
        this.t = r30;
        ((Widget) this).subWidgetManager.load(2131363828, r30, false);
    L165:
        LinkmicApplyFloatWindowManager.d r31 = LinkmicApplyFloatWindowManager.y;
        if (LinkmicApplyFloatWindowManager.e.a().i(this.l.getRoomId()) != null) goto L168;
    L170:
        this.S = new com.bytedance.android.live.liveinteract.widget.widget.v(((Widget) this).context, ((Widget) this).dataCenter, new c(this));
        boolean r32 = MultiLinkLoadWidgetUtils.g();
        IRoom r33 = this.l;
        if (r33 != null) goto L173;
    L175:
        boolean r34 = false;
    L176:
        if (r32 == false) goto L187;
        if (r34 == false) goto L187;
        com.bytedance.android.livesdk.chatroom.u r35 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r35 == null) goto L187;
        if (r35.s() == null) goto L187;
        if (r35.s().getValue() == null) goto L187;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) r35.s().getValue()).a() == null) goto L187;
        this.E = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r35.s().getValue()).a().subscribe(new t2(this));
    L187:
        if (r34 == true) goto L197;
        com.bytedance.android.livesdk.chatroom.u r36 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r36 == null) goto L197;
        if (r36.getVideoTalkRoomSubScene() == null) goto L197;
        if (r36.getVideoTalkRoomSubScene().getValue() == null) goto L197;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.e) r36.getVideoTalkRoomSubScene().getValue()).a() == null) goto L197;
        this.F = ((ObservableSubscribeProxy) ((com.bytedance.android.livesdk.chatroom.viewmodel.e) r36.getVideoTalkRoomSubScene().getValue()).a().as(AutoDispose.bind(this))).subscribe(new l1(this));
    L197:
        int r37 = this.l.getVisibilityRange();
        if (r37 == 0) goto L205;
        if (r37 == 1) goto L205;
        if (r37 == 2) goto L205;
        if (r37 == 4) goto L205;
    L207:
        if (this.l.getRoomOthers() == null) goto L210;
        r2 = this.l.getRoomOthers().getParticipantActivity();
    L210:
        if (this.l.isPaidRoom() == false) goto L215;
        if (Objects.equals(r2, "party_spring_festival") == false) goto L215;
        com.bytedance.android.live.core.utils.f2.b(2131919616, 0);
        return;
    L215:
        if (this.l.isPaidSubscribeRoom() == true) goto L217;
    L219:
        if (r8 == true) goto L221;
        return;
    L221:
        if (Objects.equals(r2, "party_spring_festival") == false) goto L230;
        com.bytedance.android.live.core.utils.f2.b(2131919716, 0);
        return;
    L230:
        return;
    L217:
        if (Objects.equals(r2, "party_spring_festival") == false) goto L219;
        com.bytedance.android.live.core.utils.f2.b(2131920076, 0);
        return;
    L205:
        r8 = false;
        goto L207
    L173:
        if (r33.isLiveTypeAudio() == false) goto L175;
        r34 = true;
        goto L176
    L168:
        if (this.l.getLinkMap().containsKey(String.valueOf(1)) == false) goto L170;
        hd0.c.f().k(1);
        LinkmicApplyFloatWindowManager.e.a().s = null;
        goto L170
    L224:
        JatoOptDrawableCache.preloadDrawableCache(((Widget) this).context.getResources(), new int[]{2131250849, 2131250847, 2131251889});     // Catch: Exception -> L138
        goto L139
    L86:
        if (this.l == null) goto L90;
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.f(((Widget) this).dataCenter) == false) goto L90;
        this.x.setAlpha(0.34f);
        goto L90
    L77:
        if (this.a != null) goto L79;
        this.a = new com.bytedance.android.live.liveinteract.plantform.core.y(this.l, ((Widget) this).dataCenter);
    L79:
        this.a.i();
        goto L80
    L72:
        if (com.bytedance.android.live.liveinteract.plantform.utils.s0.e(((Widget) this).dataCenter) == false) goto L74;
        ToolbarMultiSceneGamePlayBehavior r38 = this.A;
        long r39 = this.l.getId();
        r38.getClass();
        r38.f.add(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).getLatestInteract(r39).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.voicechat.toolbar.c(r38), com.bytedance.android.live.liveinteract.voicechat.toolbar.d.a));
        goto L74
    L36:
        if (r5.getSceneTypeInfo() == null) goto L40;
        if (IRoomSpecificSceneTypeInfoKt.isLandscapeVertical(this.l.getSceneTypeInfo()) == false) goto L40;
        ALogger.i("LinkMultiControlWidget", "room is new landscape,not load link widget");
        goto L45
    L42:
        if (vm2.d.y() == true) goto L45;
        r4.k(ToolbarButton.INTERACTION, this.x);
        goto L45
    L5:
        if (getRoomContext().isCleared() == false) goto L14;
        if (((Boolean) vm2.d.O3.getValue(null, vm2.d.a[246(0xf6, float:3.45E-43)])).booleanValue() == false) goto L14;
        DataContext r40 = ((MiddlewareRoomWidget) this).dataContext;
        if (r40 == null) goto L11;
        int r41 = r40.hashCode();
    L12:
        ALogger.w("ttlive_link", "RoomContext is not valid, this = " + hashCode() + " context = " + r41);
        goto L18
    L11:
        r41 = 0;
    L14:
        if (com.bytedance.android.live.liveinteract.api.utils.m.d() == null) goto L18;
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().H() == null) goto L18;
        com.bytedance.android.live.liveinteract.api.utils.m.d().H().d(new LinkRequestMonitor(this.l, ((Widget) this).dataCenter));
        goto L18
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final boolean W1() {
        MicRoomHostViewModel r0 = this.G;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getHostStats() != null) goto L7;
        return false;
    L7:
        if (jc1.k.f(IMiddlewareMicRoomService.class).isMicRoom(this.l) == true) goto L9;
        return false;
    L9:
        if (((Boolean) this.G.getHostStats().getValue()).booleanValue() == true) goto L11;
        return false;
    L11:
        if (this.n == true) goto L18;
        return true;
    L18:
        return false;
    }

    public final void Zq() {
        if (this.n == false) goto L5;
        return;
    L5:
        boolean r0 = us1.e.a;
        if (us1.e.a(this.l) == true) goto L9;
        return;
    L9:
        if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() != 2) goto L12;
        ((Widget) this).dataCenter.put("data_audience_pre_linkmic_waiting", Boolean.FALSE);
        return;
    L12:
        if (((Boolean) ((Widget) this).dataCenter.get("data_audience_pre_linkmic_waiting", Boolean.FALSE)).booleanValue() == false) goto L18;
        hd0.c.f().k(1);
        ToolbarVideoInteractBehavior r1 = this.x;
        if (r1 == null) goto L19;
        r1.k();
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final Widget em() {
        return this.o.z4(9, MultiLinkOpenSource.DEFAULT);
    }

    public final void er() {
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.PK.extended());
        ALogger.i("CrossLink.unLoadMultiSceneGamePlayToolbar", "mMultiSceneGamePlayBehavior unload");
        y3.m(((Widget) this).dataCenter).f(ToolbarButton.MULTI_SCENE_GAME_PLAY.extended(), this.A);
    }

    public final boolean fr() {
        if (this.n == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) vm2.d.Q3.getValue(null, vm2.d.a[248(0xf8, float:3.48E-43)])).booleanValue() == false) goto L7;
        return true;
    }

    public final boolean gr() {
        if (this.n == true) goto L5;
    L7:
        return false;
    L5:
        if (this.l.isLiveTypeAudio() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void initAndTurnOnChorusKTV() {
        LinkMultiControlPresenter r0 = this.k;
        if (r0 == null) goto L6;
        r0.g0(true, 5, true, "", false);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void initAndTurnOnKTV() {
        LinkMultiControlPresenter r0 = this.k;
        if (r0 == null) goto L6;
        r0.g0(true, 1, false, "", false);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void initAndTurnOnVoiceChatRoom() {
        LinkMultiControlPresenter r0 = this.k;
        if (r0 == null) goto L6;
        r0.t0();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final View j() {
        return this.o.j();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final boolean j7() {
        if (this.p != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void multiAnchorLoadVideoTalk() {
        ALogger.i("ttlive_link", "multiAnchorLoadVideoTalk " + this.p);
        if (gd0.v.a(this.p, 32) == true) goto L6;
        ((Widget) this).dataCenter.put("pk_invite_fail_load_video_talk_widget", Boolean.TRUE);
        this.k.B0(this.l.getRoomId());
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void multiAnchorUnloadVideoTalk() {
        ALogger.i("ttlive_link", "multiAnchorUnloadVideoTalk " + this.p);
        if (gd0.v.a(this.p, 32) == false) goto L6;
        K4(32);
        return;
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView
    public final void nC() {
        if (this.p != 2) goto L24;
        ToolbarVideoInteractBehavior r0 = this.x;
        r0.getClass();
        if (hd0.c.f().g() == false) goto L25;
        String r1 = (String) vm2.d.x7.getValue(null, vm2.d.a[436(0x1b4, float:6.11E-43)]);
        if (StringUtils.isEmpty(r1) == true) goto L26;
        LottieAnimationView r2 = r0.k;
        if (r2 == null) goto L13;
        r2.setVisibility(8);
    L13:
        HSImageView r3 = r0.l;
        if (r3 == null) goto L16;
        r3.setVisibility(0);
    L16:
        AbstractDraweeController r4 = Fresco.newDraweeControllerBuilder().setUri(r1).setAutoPlayAnimations(r0.c()).build();
        HSImageView r5 = r0.l;
        if (r5 == null) goto L19;
        r5.setController(r4);
    L19:
        ImageView r6 = r0.m;
        if (r6 == null) goto L22;
        r6.setBackgroundResource(2131250014);
    L22:
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("function_type", "audience");
        r7.put("live_type", "video_live");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_call_up_show", r7, new Object[]{am2.x.class});
        return;
    L26:
        return;
    L25:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final boolean nd() {
        return gd0.v.a(this.p, 32);
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "LinkMultiControlWidget#onCreate#" + hashCode(), "");
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        MultiLinkSeiIndicator r1 = this.N;
        r1.getClass();
        Intrinsics.checkNotNullParameter(this, "lifecycleOwner");
        if (r1.a.b() == false) goto L15;
        ILivePlatformPlayerProxy r2 = hs0.a.b.curRoomPlayer();
        if (r2 == null) goto L8;
        ILivePlayerClient r3 = r2.player();
    L9:
        if (r3 == null) goto L15;
        IRoomEventHub r4 = r3.getEventHub();
        if (r4 == null) goto L15;
        MutableLiveData r5 = r4.getSwitchResolutionResult();
        if (r5 == null) goto L15;
        r5.observe(this, new y2(r1));
        goto L15
    L8:
        r3 = null;
    L15:
        ln0.a r6 = yg0.h.a;
        if (((MultiLinkFrequencyOptConfig) com.bytedance.android.live.core.setting.v2.a.getValue()).getTryPrefetchGeckoResOpt() == false) goto L18;
        Schedulers.io().scheduleDirect(yg0.g.a);
    L22:
        int r7 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        DataCenter r8 = ((Widget) this).dataCenter;
        int r9 = MultiSceneEnterRoomStatisticsUtils.u;
        long r10 = 0;
        MultiSceneEnterRoomStatisticsUtils r11 = MultiSceneEnterRoomStatisticsUtils.a.a(r8, 0L);
        if (r11 == null) goto L25;
        r10 = r11.c();
    L25:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a = r10;
        ALogger.i("MultiLinkDynamicWidget-Time", "multi control widget start: " + (System.currentTimeMillis() - com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a));
        if (MultiLinkLoadWidgetUtils.f() == true) goto L29;
        Tq();
    L29:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.b(getComponentContext()) == false) goto L45;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.c(getComponentContext(), gd0.k.class, this);
        if (this.T == false) goto L46;
        h0((IRoom) ((Widget) this).dataCenter.get("data_room", null));
        ILivePlayerClient r12 = LivePlatformPlayerManager.f();
        if (r12 == null) goto L38;
        String r13 = (String) r12.getEventHub().getLastKeyFrameSei().getValue();
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "SEI", "call handleLastKeyFrameSei with lastKeyFrameSei = " + r13);
        if (r13 == null) goto L38;
        onSei(r13);
    L38:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r14 = com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.a(getComponentContext());
        if (r14 != null) goto L41;
        return;
    L41:
        if (((LoadState) r14.getLoadState().a).getValue() < LoadState.P1_BEGIN.getValue()) goto L43;
        MainThreadPostUtils.b(new e1(this));
        return;
    L43:
        this.R = com.bytedance.android.livesdk.chatroom.ui.framework.b.c(r14.getLoadState(), new i1(this));
        return;
    L46:
        return;
    L45:
        return;
    L18:
        ln0.a r15 = yg0.h.a;
        if (r15 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("newLayoutConfigManager");
    L21:
        r15.b();
        goto L22
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "LinkMultiControlWidget#onDestroy#" + hashCode(), "");
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.d(getComponentContext(), gd0.k.class);
        this.T = false;
        if (vm2.d.q0().isUserInfoCenterForwardInit() == false) goto L5;
        this.a.l();
    L5:
        MultiRevenueDataContext.Companion.getClass();
        if (MultiRevenueDataContext.a.d() == null) goto L8;
        MultiRevenueDataContext.a.d().g(((Widget) this).dataCenter, this.o);
    L8:
        int r1 = com.bytedance.android.live.liveinteract.videotalk.ui.b.a;
        com.bytedance.android.live.liveinteract.videotalk.ui.b.a(((Widget) this).dataCenter);
        if (this.n == false) goto L15;
        HashMap r2 = new HashMap();
        if (gd0.v.a(this.p, 2) == false) goto L13;
        r2.put("anchor_action_type", "open");
    L14:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_button_anchor", r2, new Object[]{IRoom.class});
        goto L15
    L13:
        r2.put("anchor_action_type", "close");
    L15:
        Sc();
        ((Widget) this).dataCenter.removeObserver(this);
        if (jc1.k.f(IMultiLinkServiceExternal.class).getPkServiceExternal() == null) goto L19;
        jc1.k.f(IMultiLinkServiceExternal.class).getPkServiceExternal().c(this.Q);
    L19:
        if (this.n == false) goto L21;
    L25:
        this.o = null;
        LinkMultiControlPresenter r3 = this.k;
        if (r3 == null) goto L28;
        r3.detachView();
    L28:
        Disposable r4 = this.B;
        if (r4 != null) goto L31;
    L33:
        Disposable r5 = this.C;
        if (r5 != null) goto L36;
    L38:
        this.s = null;
        CompositeDisposable r6 = this.D;
        if (r6 != null) goto L41;
    L43:
        Disposable r7 = this.R;
        if (r7 != null) goto L46;
    L48:
        Disposable r8 = this.F;
        if (r8 != null) goto L51;
    L53:
        this.M.dispose();
        CommonBottomDialog r9 = this.v;
        if (r9 != null) goto L56;
    L58:
        com.bytedance.android.livesdk.sharedpref.e r10 = b6.a0;
        r10.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r10, 0L);
        this.z.d.dispose();
        if (Gq() == null) goto L61;
        Gq().b();
    L61:
        com.bytedance.android.livesdk.utils.g0.a.clear();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r11 = MultiRevenueDataContext.a.d();
        if (r11 == null) goto L65;
        r11.clear();
    L65:
        if (this.n == true) goto L76;
        MultiLinkSeiIndicator r12 = this.N;
        int r13 = this.p;
        if (r12.a.b() == false) goto L76;
        if (r12.g <= 0) goto L72;
        r12.b(r13, MultiLinkSeiIndicator.Source.LEAVE_ROOM);
    L72:
        Disposable r14 = r12.b;
        if (r14 == null) goto L75;
        r14.dispose();
    L75:
        r12.c = -1;
        r12.d = -1;
        r12.e = 0;
        r12.f = 0;
    L76:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r15 = TalkRoomLogUtils.a;
        ((LinkedHashMap) TalkRoomLogUtils.f).clear();
        if (((Boolean) qa0.a.getValue()).booleanValue() == false) goto L85;
        CountingMemoryCache r16 = com.bytedance.android.live.core.utils.fresco.e.a;
        if (r16 == null) goto L85;
        r16.removeAll(new com.bytedance.android.live.core.utils.fresco.d());
        if (((Boolean) r6.a.getValue()).booleanValue() == false) goto L85;
        com.bytedance.android.live.core.utils.fresco.e.a = null;
    L85:
        if (((Boolean) z40.a.getValue()).booleanValue() == false) goto L96;
        WidgetManager r17 = ((Widget) this).subWidgetManager;
        if (r17 == null) goto L96;
        List r18 = r17.widgets;
        if (r18 == null) goto L96;
        if (r18.isEmpty() == true) goto L96;
        Iterator r19 = ((Widget) this).subWidgetManager.widgets.iterator();
    L94:
        if (r19.hasNext() == false) goto L96;
        ((Widget) this).subWidgetManager.unload((Widget) r19.next());
    L96:
        super.onDestroy();
        return;
    L56:
        if (r9.isShowing() == false) goto L58;
        return;
    L51:
        if (r8.isDisposed() == true) goto L53;
        this.F.dispose();
        this.F = null;
        goto L53
    L46:
        if (r7.isDisposed() == true) goto L48;
        this.R.dispose();
        this.R = null;
        goto L48
    L41:
        if (r6.isDisposed() == true) goto L43;
        this.D.dispose();
        this.D = null;
        goto L43
    L36:
        if (r5.isDisposed() == true) goto L38;
        this.C.dispose();
        goto L38
    L31:
        if (r4.isDisposed() == true) goto L33;
        this.B.dispose();
        goto L33
    L21:
        if (this.m != LiveMode.AUDIO) goto L25;
        if (vm2.d.y() == true) goto L25;
        y3.b(((Widget) this).dataCenter).d(ToolbarButton.INTERACTION_AUDIENCE, this.w);
        goto L25
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void pkInviteFailLoadWidget() {
        if (this.K == false) goto L6;
        this.K = false;
        this.p = gd0.v.b(this.p, 32);
        ((Widget) this).dataCenter.put("pk_invite_fail_load_video_talk_widget", Boolean.TRUE);
        this.k.B0(this.l.getRoomId());
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void pkInviteUnloadWidget() {
        if (gd0.v.a(this.p, 32) == false) goto L6;
        this.K = true;
        Hm("pkInviteUnloadWidget");
        this.o.k(this.f.getWidget());
        this.f = null;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void s4() {
        if (gd0.v.a(this.p, 2) == false) goto L5;
        this.x.f(2131251092, 2131251092, 1.0f);
        return;
    L5:
        this.x.f(2131250849, 2131250849, 1.0f);
        if (gr() == false) goto L10;
        this.y.setAlpha(1.0f);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final boolean s8() {
        return gd0.v.a(this.p, 8);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final com.bytedance.android.live.ui.c y4() {
        return this.o.y4();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void ye() {
        if (((Widget) this).isViewValid == true) goto L6;
        return;
    L6:
        if (com.bytedance.android.live.liveinteract.api.utils.m.c() == false) goto L17;
        VoiceInteractSceneUtil r0 = VoiceInteractSceneUtil.a;
        Context r1 = ((Widget) this).context;
        Intrinsics.checkNotNullParameter(r1, "context");
        int r2 = je0.d.f();
        Integer r3 = je0.d.h();
        int r4 = 0;
        if (r3 == null) goto L10;
        int r5 = r3.intValue();
    L12:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.d.e0.getValue(null, com.bytedance.android.livesdk.sharedpref.d.a[55])).booleanValue() == true) goto L14;
    L16:
        lf r6 = lf.a;
        u6 r7 = new u6(((AudioRadioChatPanelConfig) r6.getValue()).getSelectModePanelSchema());
        r7.b("url", ((AudioRadioChatPanelConfig) r6.getValue()).getSelectModePanelUrl());
        u6 r8 = r7.d("url");
        r8.b("show_radio_linkmic_yellow_dot", String.valueOf(r4));
        r8.b("scene", String.valueOf(r2));
        r8.b("ui_layout", String.valueOf(r5));
        jc1.k.n(IBaseLiveActionHandler.class).handle(r1, r7.c());
        return;
    L14:
        if (com.bytedance.android.live.liveinteract.api.utils.m.c() == false) goto L16;
        r4 = 1;
        goto L16
    L10:
        r5 = 0;
        goto L12
    L17:
        CommonBottomDialog r9 = this.v;
        if (r9 != null) goto L20;
    L22:
        VoiceInteractSceneDialog r10 = new VoiceInteractSceneDialog(this.p, ((Widget) this).context, getRoomContext(), this.M);
        this.v = r10;
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L29;
        DialogLancet.handleBlockedDialogShow(r10);
        return;
    L29:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L26:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        return;
    L20:
        if (r9.isShowing() == false) goto L22;
    }

    public final void yq() {
        if (this.i != null) goto L6;
        this.i = this.o.z4(14, MultiLinkOpenSource.DEFAULT);
        return;
    }

    public final LinkRequestMonitor Gq() {
        if (getRoomContext() != null) goto L5;
        return null;
    L5:
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().H() != null) goto L7;
        return null;
    L7:
        return (LinkRequestMonitor) com.bytedance.android.live.liveinteract.api.utils.m.d().H().getValue();
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView
    public final void I80() {
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (gd0.v.a(this.p, 32) == true) goto L8;
        return;
    L8:
        if (this.n == true) goto L12;
        K4(32);
        return;
    }

    public final int Iq() {
        if (com.bytedance.android.live.liveinteract.api.utils.m.d() != null) goto L5;
    L9:
        return 0;
    L5:
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().s() == null) goto L9;
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().s().getValue() == null) goto L9;
        return ((com.bytedance.android.livesdk.chatroom.viewmodel.f) com.bytedance.android.live.liveinteract.api.utils.m.d().s().getValue()).t().a;
    }

    public final boolean Kq() {
        com.bytedance.android.livesdk.chatroom.u r0 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r0.s() != null) goto L5;
        return false;
    L5:
        if (r0.s().getValue() != null) goto L7;
        return false;
    L7:
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.s().getValue()).t().b != 29) goto L12;
        return true;
    L12:
        return false;
    }

    public final void Pq() {
        if (je0.d.L() == false) goto L6;
        er();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r0 = y3.m(((Widget) this).dataCenter);
        ToolbarButton r1 = ToolbarButton.PK;
        r0.c(r1.extended());
        y3.m(((Widget) this).dataCenter).h(r1.extended());
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.TEAM_FIGHT.extended());
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.MULTI_SCENE_GAME_PLAY.extended());
        return;
    L6:
        if (((IInteractService) jc1.k.f(IInteractService.class)).dynamicFromAudience() == true) goto L10;
        if (com.bytedance.android.live.liveinteract.plantform.utils.s0.h(((Widget) this).dataCenter) == true) goto L10;
    L13:
        if (com.bytedance.android.live.liveinteract.plantform.utils.s0.f(((Widget) this).dataCenter) == false) goto L16;
        Nq();
        return;
    L16:
        if (fr() == false) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r2 = y3.m(((Widget) this).dataCenter);
        ToolbarButton r3 = ToolbarButton.TEAM_FIGHT;
        r2.p(r3.extended(), this.z);
        y3.m(((Widget) this).dataCenter).c(r3.extended());
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.PK.extended());
        this.f.H9(this.z);
        return;
    L22:
        return;
    L10:
        if (com.bytedance.android.live.liveinteract.plantform.utils.s0.d(((Widget) this).dataCenter) == true) goto L13;
        er();
        Wq(Boolean.valueOf(com.bytedance.android.livesdk.chatroom.paidlive.e.f(((Widget) this).dataCenter)).booleanValue());
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView
    public final void Wj() {
        tc0.c.h().j(Boolean.FALSE);
        if (gd0.v.a(this.p, 2) == false) goto L6;
        K4(2);
    L6:
        if (gd0.v.a(this.p, 8) == false) goto L9;
        K4(8);
        y3.m(((Widget) this).dataCenter).p(ToolbarButton.INTERACTION_SCENE.extended(), this.y);
    L9:
        if (gd0.v.a(this.p, 32) == false) goto L12;
        K4(32);
    L12:
        if (this.n == false) goto L14;
        return;
    L14:
        if (vm2.d.y() == true) goto L18;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION.extended());
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return je0.d.f();
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        this.N.i = true;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        this.N.i = false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void uo() {
        if (com.bytedance.android.live.liveinteract.component.b.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.component.b.a().close();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final BehaviorSubject<Boolean> U4() {
        return this.O;
    }

    @Override // com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget
    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.LINKING_REMAIN;
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView, com.bytedance.android.live.liveinteract.plantform.base.g
    public final int getCurrentMode() {
        return this.p;
    }

    public final Lifecycle getLifecycleCompat() {
        return ((Widget) this).lifecycleRegistry;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final com.bytedance.android.live.liveinteract.plantform.base.i getLinkUserInfoCenter() {
        return this.a;
    }

    public final void Bq(int r3) {
        if (this.n == false) goto L5;
        return;
    L5:
        if (vm2.d.y() == true) goto L22;
        LiveMode r0 = this.m;
        if (r0 != LiveMode.AUDIO) goto L14;
        if (gd0.v.a(r3, 8) == false) goto L11;
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.INTERACTION_AUDIENCE.extended());
        return;
    L11:
        if (r3 != 0) goto L24;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION_AUDIENCE.extended());
        return;
    L24:
        return;
    L14:
        if (r0 == LiveMode.VIDEO) goto L16;
        return;
    L16:
        if (this.n == false) goto L18;
        return;
    L18:
        if (Aq() == false) goto L28;
        br(true, "config tool bar view");
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void Cj(String r5) {
        if (MultiLinkLoadWidgetUtils.g() == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.chatroom.u r0 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r0 != null) goto L8;
    L14:
        int r1 = 0;
    L15:
        MultiLinkLoadWidgetUtils.p(((Widget) this).dataCenter, "MultiControlWidget#loadPreloadWidgetIfNeed", "scene=" + r1 + ", source=" + r5);
        if (this.l.isLiveTypeAudio() == true) goto L18;
    L19:
        int r2 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        if (com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter) != null) goto L25;
        if (this.o == null) goto L25;
        MultiLinkLoadWidgetUtils.p(((Widget) this).dataCenter, "MultiControlWidget#loadMicSeatDataWidgetIfNeed", "source=".concat(r5));
        MultiLinkMicSeatDataWidget r3 = this.o.z4(16, r5);
    L25:
        if (com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(((Widget) this).dataCenter) == null) goto L27;
    L29:
        Lq(r5);
        return;
    L27:
        if (this.o == null) goto L29;
        MultiLinkLoadWidgetUtils.p(((Widget) this).dataCenter, "MultiControlWidget#loadUIWidgetIfNeed", "source=".concat(r5));
        this.j = this.o.z4(15, r5);
        goto L29
    L18:
        if (r1 == 9) goto L29;
    L8:
        if (r0.s() == null) goto L14;
        if (r0.s().getValue() == null) goto L14;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.s().getValue()).t() == null) goto L14;
        r1 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.s().getValue()).t().a;
        goto L15
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView
    public final void E1(ILinkerClientUIInfoChangeContent r2) {
        if (this.n == false) goto L7;
        kn0.a r0 = this.d;
        if (r0 == null) goto L11;
        r0.E1(r2);
        return;
    L11:
        return;
    L7:
        kn0.b r1 = this.e;
        if (r1 == null) goto L13;
        r1.E1(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void Hm(String r3) {
        if (MultiLinkLoadWidgetUtils.g() == true) goto L5;
        return;
    L5:
        ALogger.i("LinkControlWidget", "unloadUIWidgetIfNeed source=" + r3 + "mMultiLinkUIWidget=" + this.j);
        Widget r4 = this.j;
        if (r4 == null) goto L8;
        this.o.k(r4);
        this.j = null;
        return;
    L8:
        int r5 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        if (com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(((Widget) this).dataCenter) != null) goto L11;
        return;
    L11:
        if (this.j != null) goto L16;
        this.o.A4();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void Ik(boolean r17) {
        ILiveExternalCameraServiceForOther r1 = jc1.k.f(ILiveExternalCameraServiceForOther.class);
        if (r1 != null) goto L5;
    L8:
        ILiveProDualDeviceServiceForOther r2 = jc1.k.f(ILiveProDualDeviceServiceForOther.class);
        if (r2 == null) goto L15;
        if (r2.isUsingLiveProPhoneCameraInBroadCast() == false) goto L15;
        com.bytedance.android.live.core.utils.f2.c("正在使用外接手机摄像头，暂不支持该功能", 0);
        return;
    L15:
        if (((Boolean) ((Widget) this).dataCenter.get("data_live_picture_presentation_show", Boolean.FALSE)).booleanValue() != true) goto L18;
        com.bytedance.android.live.core.utils.f2.c("该功能暂不支持与图片演示同时使用，请关闭图片演示后使用", 0);
        return;
    L18:
        zg1.m r3 = (zg1.m) ((Widget) this).dataCenter.get("data_broadcast_pause_state");
        if (r3 == null) goto L24;
        int r4 = r3.a;
        if (r4 == 1) goto L23;
        if (r4 != 2) goto L24;
    L23:
        boolean r5 = true;
    L25:
        if (r5 == false) goto L29;
        com.bytedance.android.live.core.utils.f2.b(2131917825, 0);
        return;
    L29:
        if (vm2.d.p0() == false) goto L31;
    L36:
        yr0.a r6 = jc1.k.f(IMultiLinkServiceExternal.class).getControlServiceExternal();
        if (r6.p() == true) goto L40;
        return;
    L40:
        if (this.m == LiveMode.VIDEO) goto L42;
    L45:
        IRoom r7 = this.l;
        if (r7 == null) goto L52;
        if (r7.getMosaicStatusFlex() != 1) goto L52;
        com.bytedance.android.live.core.utils.f2.b(2131919663, 0);
        return;
    L52:
        if (jc1.k.f(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getChannelId() == 0) goto L61;
        if (r17 == false) goto L57;
        com.bytedance.android.live.core.utils.f2.b(2131917998, 0);
        return;
    L57:
        if (us1.b.a() == true) goto L61;
        com.bytedance.android.live.core.utils.f2.c(us1.b.b(), 0);
        return;
    L61:
        if (W1() == false) goto L67;
        if (jc1.k.f(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getChannelId() == 0) goto L67;
        com.bytedance.android.live.core.utils.f2.b(2131917775, 0);
        return;
    L67:
        if (this.m != LiveMode.AUDIO) goto L97;
        yr0.a r8 = jc1.k.f(IMultiLinkServiceExternal.class).getControlServiceExternal();
        if (this.p == 0) goto L71;
        if (r8 != null) goto L94;
        return;
    L94:
        if (gd0.v.a(r8.getCurrentMode(), 4) == false) goto L208;
        com.bytedance.android.live.core.utils.f2.b(2131919255, 0);
        return;
    L208:
        return;
    L71:
        if (jc1.k.f(IMultiLinkServiceExternal.class).getPkServiceExternal().isMatching() == false) goto L77;
        if (r17 == false) goto L74;
        com.bytedance.android.live.core.utils.f2.b(2131917998, 0);
        return;
    L74:
        com.bytedance.android.live.core.utils.f2.b(2131919256, 0);
        return;
    L77:
        if (gr() == false) goto L79;
        ye();
        CommonBottomDialog r9 = this.v;
    L84:
        final IMiddlewareBroadcastService r10 = (IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class);
        if (r9 == null) goto L204;
        if (r10 != null) goto L89;
        return;
    L89:
        if (r10.shouldShowGuidePromptBubble(19) == false) goto L91;
        r9.setOnDismissListener(new x0(this, r10));
        return;
    L91:
        r9.setOnDismissListener(null);
        return;
    L204:
        return;
    L79:
        r9 = new VoiceChatRoomConfirmDialog(((Widget) this).context);
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L201;
        DialogLancet.handleBlockedDialogShow(r9);
        goto L84
    L201:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L200
    L83:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        goto L84
    L97:
        ((IMultiPkAudienceLinkOutService) jc1.k.f(IMultiPkAudienceLinkOutService.class)).handleInteractClick();
        if (Aq() == false) goto L111;
        if (gd0.v.a(r6.getCurrentMode(), 4) == true) goto L111;
        if (this.n == true) goto L111;
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.f(((Widget) this).dataCenter) == true) goto L106;
    L109:
        this.x.h(getRoomContext(), "");
        goto L111
    L106:
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.b(this.l) == true) goto L109;
        com.bytedance.android.live.core.utils.f2.b(2131921181, 0);
        TalkRoomBusinessFullLinkMonitor r11 = TalkRoomBusinessFullLinkMonitor.a;
        boolean r12 = com.bytedance.android.livesdk.chatroom.paidlive.e.f(((Widget) this).dataCenter);
        boolean r13 = com.bytedance.android.livesdk.chatroom.paidlive.e.b(this.l);
        r11.getClass();
        TalkRoomBusinessFullLinkMonitor.e0(r12, r13);
        return;
    L111:
        if (((Integer) ((Widget) this).dataCenter.get("data_link_state", 0)).intValue() != 0) goto L128;
        if (jc1.k.f(IMultiLinkServiceExternal.class).getPkServiceExternal().isMatching() == false) goto L116;
        com.bytedance.android.live.core.utils.f2.b(2131919256, 0);
        return;
    L116:
        if (this.n == false) goto L213;
        int r14 = us1.g.a;
        if (Aq() == false) goto L123;
        if (this.p != 0) goto L123;
        this.k.E0();
    L126:
        HashMap r15 = new HashMap();
        r15.put("action_type", "click");
        r15.put("live_type", "video_live");
        r15.put("function_type", "live");
        r15.put("source", "bottom");
        TalkRoomLogUtils.H0(r15);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_function_icon", r15, new Object[]{IRoom.class, am2.x.class});
        return;
    L123:
        if (((rj1) bc0.a.getValue()).a() == false) goto L125;
        int r16 = com.bytedance.android.live.liveinteract.e.a;
        com.bytedance.android.live.liveinteract.e.c(((Widget) this).context);
        goto L126
    L125:
        DataCenter r18 = ((Widget) this).dataCenter;
        int r19 = LinkDialog.v;
        LinkDialog r20 = new LinkDialog.a(r18, this).b(9);
        this.u = r20;
        xq(r20, ((Widget) this).context.getSupportFragmentManager());
        goto L126
    L213:
        return;
    L128:
        if (gd0.v.a(r6.getCurrentMode(), 64) == false) goto L135;
        if (this.n == false) goto L132;
        com.bytedance.android.live.core.utils.f2.b(2131919312, 0);
        return;
    L132:
        com.bytedance.android.live.core.utils.f2.b(2131919313, 0);
        return;
    L135:
        if (gd0.v.a(this.p, 16) == false) goto L138;
        com.bytedance.android.live.core.utils.f2.b(2131919257, 0);
        return;
    L138:
        if (gd0.v.a(r6.getCurrentMode(), 4) == false) goto L147;
        if (((Boolean) vm2.h.d5.getValue(null, vm2.h.a[314(0x13a, float:4.4E-43)])).booleanValue() == true) goto L142;
        return;
    L142:
        if (this.n == false) goto L144;
        com.bytedance.android.live.core.utils.f2.b(2131919312, 0);
        return;
    L144:
        com.bytedance.android.live.core.utils.f2.b(2131919313, 0);
        return;
    L147:
        if (gd0.v.a(this.p, 2) == false) goto L181;
        if (this.n == false) goto L167;
        if (jc1.k.f(IMultiLinkServiceExternal.class).getPkServiceExternal().isMatching() == false) goto L154;
        com.bytedance.android.live.core.utils.f2.b(2131919256, 0);
        return;
    L154:
        if (TextUtils.isEmpty((String) ((Widget) this).dataCenter.get("data_interact_number_dot_show")) == false) goto L160;
        int r21 = us1.g.a;
        if (((rj1) bc0.a.getValue()).a() == false) goto L158;
        int r22 = com.bytedance.android.live.liveinteract.e.a;
        com.bytedance.android.live.liveinteract.e.c(((Widget) this).context);
        this.u = null;
    L163:
        LinkDialog r23 = this.u;
        if (r23 == null) goto L218;
        xq(r23, ((Widget) this).context.getSupportFragmentManager());
        return;
    L218:
        return;
    L158:
        DataCenter r24 = ((Widget) this).dataCenter;
        int r25 = LinkDialog.v;
        this.u = new LinkDialog.a(r24, this).b(9);
        goto L163
    L160:
        if (vm2.d.S() == false) goto L162;
        DataCenter r26 = ((Widget) this).dataCenter;
        int r27 = LinkDialog.v;
        this.u = new LinkDialog.a(r26, this).b(15);
        goto L163
    L162:
        DataCenter r28 = ((Widget) this).dataCenter;
        int r29 = LinkDialog.v;
        this.u = new LinkDialog.a(r28, this).b(8);
        goto L163
    L167:
        if (jc1.k.f(IMiddlewareUserService.class).user().c() == true) goto L169;
        HashMap r30 = new HashMap();
        r30.put("action_type", "click");
        r30.put("request_page", tc0.c.h().z);
        if (W1() == false) goto L176;
        String r31 = "1";
    L177:
        r30.put("is_carousel_room_host", r31);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection", r30, new Object[]{IRoom.class, am2.x.class});
        InteractAudienceGuestWidget r32 = this.c;
        if (r32 == null) goto L221;
        r32.Mq(true);
        return;
    L221:
        return;
    L176:
        r31 = "0";
        goto L177
    L169:
        if (vm2.d.S() == false) goto L171;
        DataCenter r33 = ((Widget) this).dataCenter;
        int r34 = LinkDialog.v;
        this.u = new LinkDialog.a(r33, this).b(15);
    L172:
        xq(this.u, ((Widget) this).context.getSupportFragmentManager());
        return;
    L171:
        DataCenter r35 = ((Widget) this).dataCenter;
        int r36 = LinkDialog.v;
        this.u = new LinkDialog.a(r35, this).b(8);
        goto L172
    L181:
        if (gd0.v.a(this.p, 32) == true) goto L183;
        return;
    L183:
        if (je0.d.L() == false) goto L187;
        this.k.E0();
        return;
    L187:
        if (this.n == false) goto L192;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L224;
        rj0.k.a.a().v0(0, "bottom", -1, "");
        return;
    L224:
        return;
    L192:
        if (jc1.k.f(IMiddlewareUserService.class).user().c() == false) goto L196;
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.k.a.a() == null) goto L226;
        com.bytedance.android.live.liveinteract.plantform.base.k.a.a().v0(0, "bottom", -1, "");
        return;
    L226:
        return;
    L196:
        rj0.o r37 = this.g;
        if (r37 == null) goto L228;
        r37.sg();
        return;
    L228:
        return;
    L42:
        if (((Boolean) vm2.d.t5.getValue(null, vm2.d.a[329(0x149, float:4.61E-43)])).booleanValue() == true) goto L45;
        com.bytedance.android.live.core.utils.f2.c(((Widget) this).context.getString(2131919343), 0);
        return;
    L31:
        if (this.l == null) goto L36;
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.f(((Widget) this).dataCenter) == false) goto L36;
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.B(2131921190), 0);
        return;
    L24:
        r5 = false;
        goto L25
    L5:
        if (r1.isDisableAbility() != true) goto L8;
        com.bytedance.android.live.core.utils.f2.c("相机连接过程中暂不支持该功能", 0);
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView
    public final void JT(com.bytedance.android.livesdk.message.linker.h r3) {
        rj0.n r0 = this.f;
        if (r0 == null) goto L5;
        r0.Qo();
    L5:
        kn0.a r1 = this.d;
        if (r1 == null) goto L9;
        r1.continueAnchorLinkMic(r3.getScene(), r3);
        return;
    }

    public final void K4(int r18) {
        int r2 = ((IInteractService) jc1.k.f(IInteractService.class)).getLinkMode();
        Lazy r3 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "ControlWidget#unLoadWidget", "currentMode = " + this.p + ", mode = " + r18 + ", currControlWidget = " + this);
        if (gd0.v.a(this.p, r18) == true) goto L5;
        return;
    L5:
        ArrayList r4 = new ArrayList((List) ((Widget) this).dataCenter.get("data_online_changed_list", new ArrayList()));
        r4.clear();
        ((Widget) this).dataCenter.put("data_online_changed_list", r4);
        this.p = gd0.v.b(this.p, r18);
        if (((Widget) this).dataCenter == null) goto L9;
        ((Widget) this).dataCenter.put("data_link_state", Integer.valueOf(jc1.k.f(IMultiLinkServiceExternal.class).getControlServiceExternal().getCurrentMode() | this.p));
    L9:
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == false) goto L13;
        BaseLinkMultiControlWidget.a r5 = this.o;
        MultiRevenueDataContext.Companion.getClass();
        if (MultiRevenueDataContext.a.d() == null) goto L13;
        MultiRevenueDataContext.a.d().g(((Widget) this).dataCenter, r5);
    L13:
        MultiRevenueDataContext.Companion.getClass();
        if (MultiRevenueDataContext.a.d() == null) goto L23;
        if (r18 == 0) goto L17;
    L21:
        MultiRevenueDataContext.a.d().f(((Widget) this).dataCenter);
        goto L23
    L17:
        if (this.p != 0) goto L21;
        if (vm2.h.W().installFix2() == false) goto L21;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "ControlWidget#unLoadWidget", "skip resetDynamicWidget by installFix2! currentMode = " + this.p + "mode = " + r18);
    L23:
        if (r18 != 2) goto L31;
        this.o.k(this.b);
        this.b = null;
        this.o.k(this.c);
        this.c = null;
        xs2.b.a().post(new zg1.j(2));
        if (this.n == false) goto L27;
    L29:
        y3.m(((Widget) this).dataCenter).h(ToolbarButton.PK.extended());
        Sc();
    L92:
        if (this.x == null) goto L132;
        float r7 = 1.0f;
        if (gd0.v.a(this.p, 2) == false) goto L101;
        if (this.n == false) goto L98;
    L99:
        ToolbarVideoInteractBehavior r6 = this.x;
        int r8 = ToolbarVideoInteractBehavior.F;
        r6.f(ToolbarVideoInteractBehavior.a.a(), ToolbarVideoInteractBehavior.a.a(), 1.0f);
        goto L132
    L98:
        if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() != 0) goto L132;
    L101:
        if (gd0.v.a(this.p, 32) == false) goto L107;
        if (this.n == false) goto L105;
        this.x.f(2131253282, 2131253282, 1.0f);
        goto L132
    L105:
        ToolbarVideoInteractBehavior r9 = this.x;
        int r10 = ToolbarVideoInteractBehavior.F;
        r9.f(ToolbarVideoInteractBehavior.a.a(), ToolbarVideoInteractBehavior.a.a(), 1.0f);
        goto L132
    L107:
        if (this.n == false) goto L131;
        LiveMode r11 = this.m;
        LiveMode r12 = LiveMode.VIDEO;
        if (r11 != r12) goto L111;
        Qq();
    L111:
        IInteractService r13 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r13 != null) goto L114;
    L122:
        boolean r14 = false;
    L123:
        float r15 = 0.34f;
        if (r14 == false) goto L127;
        r7 = 0.34f;
    L127:
        if (gd0.v.a(r2, 64) == true) goto L130;
        r15 = r7;
    L130:
        this.x.f(2131250849, 2131250849, r15);
        goto L132
    L114:
        if (this.n == false) goto L122;
        if (this.m != r12) goto L122;
        if (r13.getCurrentScene() != 0) goto L122;
        int r16 = us1.g.a;
        if (((Boolean) b6.k.getValue()).booleanValue() == true) goto L122;
        r14 = true;
        goto L123
    L131:
        ToolbarVideoInteractBehavior r17 = this.x;
        int r19 = ToolbarVideoInteractBehavior.F;
        r17.f(ToolbarVideoInteractBehavior.a.a(), ToolbarVideoInteractBehavior.a.a(), 1.0f);
    L132:
        if (r18 == 32) goto L141;
        if (this.n == false) goto L141;
        if (jc1.k.f(IMiddlewareMicRoomService.class).isMicRoom(this.l) == false) goto L141;
        if (this.l.isLiveTypeAudio() == true) goto L141;
        tc0.c.h().g = true;
        this.k.h0(false, true, 3, false, "auto", true, 7, 8, 0);
    L141:
        if (this.p != 0) goto L150;
        if (this.n == true) goto L150;
        if (this.m != LiveMode.VIDEO) goto L150;
        VideoTalkLinkIntegrationWidget r20 = this.h;
        if (r20 == null) goto L150;
        r20.wq();
    L150:
        if (gd0.v.a(this.p, 0) == true) goto L152;
    L156:
        jc1.k.f(IMultiLinkServiceExternal.class).getControlServiceExternal().unLoadOtherWidget(r18);
        ((IMultiPkAudienceLinkOutService) jc1.k.f(IMultiPkAudienceLinkOutService.class)).unLoadOtherWidget(r18);
        if (r18 != 32) goto L160;
        Zq();
    L160:
        if (this.n == true) goto L169;
        MultiLinkSeiIndicator r21 = this.N;
        if (r21.a.b() == false) goto L170;
        Disposable r22 = r21.b;
        if (r22 == null) goto L167;
        r22.dispose();
    L167:
        r21.b(r18, MultiLinkSeiIndicator.Source.LINK_END);
        r21.g = 0;
        r21.k = 0;
        r21.c = -1;
        r21.d = -1;
        r21.e = 0;
        r21.f = 0;
        return;
    L170:
        return;
    L169:
        return;
    L152:
        if (this.n == true) goto L156;
        if (Aq() == false) goto L156;
        br(true, "unload widget");
        goto L156
    L27:
        if (vm2.d.y() == true) goto L29;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION.extended());
        goto L29
    L31:
        if (r18 != 32) goto L64;
        Hm("unloadWidget");
        boolean r23 = us1.e.a;
        DataCenter r24 = ((Widget) this).dataCenter;
        if (r24 == null) goto L35;
        r24.put("data_audience_talk_room_match_screen", Boolean.TRUE);
    L35:
        rj0.n r25 = this.f;
        if (r25 != null) goto L38;
    L40:
        rj0.o r26 = this.g;
        if (r26 != null) goto L43;
    L45:
        this.f = null;
        this.g = null;
        if (this.n == false) goto L48;
    L51:
        er();
        if (fr() == false) goto L54;
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.PK.extended());
        y3.m(((Widget) this).dataCenter).f(ToolbarButton.TEAM_FIGHT.extended(), this.z);
    L54:
        Sc();
        if (this.n == false) goto L92;
        if (vm2.d.S() == false) goto L92;
        DataCenter r27 = ((Widget) this).dataCenter;
        if (r27 == null) goto L92;
        Boolean r28 = Boolean.FALSE;
        if (((Boolean) r27.get("data_need_restore_video_interact", r28)).booleanValue() == false) goto L92;
        ((Widget) this).dataCenter.put("data_need_restore_video_interact", r28);
        int r29 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("restore_video_interact", new LinkedHashMap());
        K7("auto");
        goto L92
    L48:
        if (vm2.d.y() == true) goto L50;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION.extended());
    L50:
        ((Widget) this).dataCenter.put("data_audience_pre_linkmic_waiting", Boolean.FALSE);
        ((Widget) this).dataCenter.put("data_video_talk_dot_with_number_show", "");
        Intrinsics.checkNotNullParameter("", "<set-?>");
        us1.e.e = "";
        goto L51
    L43:
        if (r26.getWidget() == null) goto L45;
        this.o.k(this.g.getWidget());
        goto L45
    L38:
        if (r25.getWidget() == null) goto L40;
        this.o.k(this.f.getWidget());
        goto L40
    L64:
        if (r18 != 8) goto L92;
        ALogger.i("ttlive_link", "unload mVoiceChatRoomGuestWidget");
        Hm("unloadWidget");
        BaseLinkMultiControlWidget.a r30 = this.o;
        if (r30 == null) goto L73;
        kn0.a r31 = this.d;
        if ((r31 instanceof Widget) == false) goto L70;
        r30.k((Widget) r31);
    L70:
        Widget r32 = this.e;
        if ((r32 instanceof Widget) == false) goto L73;
        this.o.k(r32);
    L73:
        this.d = null;
        this.e = null;
        if (this.n == true) goto L80;
        if (vm2.d.y() == true) goto L78;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION.extended());
    L78:
        Bq(0);
    L90:
        Sc();
        goto L92
    L80:
        if (gr() == false) goto L89;
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.PK.extended());
        if (this.n == true) goto L84;
    L86:
        boolean r33 = false;
    L87:
        if (r33 == false) goto L90;
        y3.m(((Widget) this).dataCenter).p(ToolbarButton.INTERACTION_SCENE.extended(), this.y);
        y3.m(((Widget) this).dataCenter).f(ToolbarButton.TEAM_FIGHT.extended(), this.z);
        goto L90
    L84:
        if (vm2.d.D() == false) goto L86;
        r33 = true;
        goto L87
    L89:
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.INTERACTION.extended());
        goto L90
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void K7(String r2) {
        this.k.u0(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void Lp(boolean r2) {
        ToolbarAudioInteractBehavior r0 = this.w;
        if (r0 == null) goto L10;
        if (r2 == true) goto L6;
        r0.d(2131250851);
        return;
    L6:
        if (hd0.c.f().h() == false) goto L11;
        r0.f();
        return;
    L11:
        return;
    }

    public final void Lq(String r4) {
        int r0 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r1 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.c(((Widget) this).dataCenter);
        if (r1 == null) goto L5;
    L7:
        if (r1 == null) goto L11;
        r1.oq();
        return;
    L11:
        return;
    L5:
        if (this.o == null) goto L7;
        Lazy r2 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.p(((Widget) this).dataCenter, "MultiControlWidget#loadBgThemeUIWidgetIfNeed", "source=".concat(r4));
        MultiLinkThemeBgUIWidget r5 = this.o.z4(13, r4);
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView
    public final void MV(com.bytedance.android.live.liveinteract.api.data.a r2) {
        this.s.getPaidVideoTalkConfig().setValue(r2);
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView
    public final void Q10(Throwable r4) {
        if ((r4 instanceof ApiServerException) == false) goto L8;
        wf0.b.a();
        if (((ApiServerException) r4).getErrorCode() != 31011) goto L8;
        final WeakReference r5 = new WeakReference(getContext());
        ((SingleSubscribeProxy) ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).getLatestBanRecord(13).as(autoDisposeWithTransformer())).subscribe(new w0(this, r5), new o1());
        return;
    L8:
        ExceptionUtils.handleException(((Widget) this).context, r4, 2131919444);
    }

    public final void Rq(int r6) {
        boolean r0 = j7();
        if (this.n == false) goto L15;
        InteractAudienceAnchorWidget r1 = this.b;
        if (r1 == null) goto L26;
        r1.p = r0;
        InteractAudienceVideoWindowManager r4 = r1.o;
        if (r4 == null) goto L9;
        r4.a = r0;
        r4.i(true);
    L9:
        if (r0 == true) goto L26;
        if (PaidLinkMicContext.Companion.a() == null) goto L26;
        DataCenter r2 = ((Widget) r1).dataCenter;
        if (r2 == null) goto L26;
        r2.put("data_paid_link_profile_show", Boolean.FALSE);
    L26:
        com.bytedance.android.live.liveinteract.plantform.base.j r3 = PaidProfileCardContext.Companion.a();
        if (r3 == null) goto L30;
        r3.Ld();
    L30:
        if (r6 != 4) goto L32;
        Zq();
    L32:
        if (r6 != 4) goto L37;
        boolean r7 = us1.e.a;
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L38;
        r8.put("data_audience_talk_room_match_screen", Boolean.TRUE);
        return;
    L38:
        return;
    L37:
        return;
    L15:
        InteractAudienceGuestWidget r5 = this.c;
        if (r5 == null) goto L26;
        r5.A = r0;
        InteractAudienceVideoWindowManager r9 = r5.z;
        if (r9 == null) goto L20;
        r9.a = r0;
        r9.i(true);
    L20:
        if (r0 == true) goto L26;
        if (PaidLinkMicContext.Companion.a() == null) goto L26;
        DataCenter r10 = ((Widget) r5).dataCenter;
        if (r10 == null) goto L26;
        r10.put("data_paid_link_profile_show", Boolean.FALSE);
        goto L26
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView
    public final void WO(boolean r3) {
        if (((rj1) bc0.a.getValue()).a() == false) goto L5;
        int r4 = com.bytedance.android.live.liveinteract.e.a;
        com.bytedance.android.live.liveinteract.e.c(((Widget) this).context);
    L16:
        ((Widget) this).dataCenter.put("data_video_talk_dot_with_number_show", "");
        boolean r5 = us1.e.a;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        us1.e.e = "";
        return;
    L5:
        com.bytedance.android.live.liveinteract.plantform.model.b1 r0 = us1.e.d;
        if (r0 == null) goto L10;
        List<com.bytedance.android.live.liveinteract.plantform.model.c1> r1 = r0.a();
        if (r1 == null) goto L10;
        int r2 = r1.size();
    L11:
        if (r2 > 0) goto L15;
        if (r3 == true) goto L15;
        DataCenter r6 = ((Widget) this).dataCenter;
        int r7 = LinkDialog.v;
        LinkDialog r8 = new LinkDialog.a(r6, this).b(9);
        this.u = r8;
        xq(r8, ((Widget) this).context.getSupportFragmentManager());
    L15:
        DataCenter r9 = ((Widget) this).dataCenter;
        int r10 = LinkDialog.v;
        LinkDialog r11 = new LinkDialog.a(r9, this).b(23);
        this.u = r11;
        xq(r11, ((Widget) this).context.getSupportFragmentManager());
    L10:
        r2 = 0;
        goto L11
    }

    public final void Wq(boolean r4) {
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r0 = y3.m(((Widget) this).dataCenter);
        ToolbarButton r1 = ToolbarButton.PK;
        r0.c(r1.extended());
        if (r4 == false) goto L5;
        String r5 = com.bytedance.android.live.core.utils.s1.B(2131921190);
        y3.m(((Widget) this).dataCenter).l(r1.extended(), r5);
    L6:
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.TEAM_FIGHT.extended());
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.MULTI_SCENE_GAME_PLAY.extended());
        return;
    L5:
        y3.m(((Widget) this).dataCenter).h(r1.extended());
        goto L6
    }

    public final <T> void Yq(Class<T> r3) {
        this.D.add(xs2.b.a().b(r3).subscribe(new p1(this)));
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView
    public final void Zi(int r4) {
        com.bytedance.android.live.liveinteract.chatroom.chatroom.model.c r0 = this.L;
        if (r0 == null) goto L6;
        this.L = new com.bytedance.android.live.liveinteract.chatroom.chatroom.model.c(r0.a, r4, r0.c);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void Zl(int r4) {
        StringBuilder r0 = new StringBuilder("showAudiencePreApplyDialog, mVoiceGuestWidget is null: ");
        if (this.e != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        ALogger.d("LinkControlWidget", r0.toString());
        kn0.b r2 = this.e;
        if (r2 == null) goto L9;
        r2.Vl(r4);
        return;
    L9:
        e r5 = new e(this);
        ALogger.d("LinkControlWidget", "showAudiencePreApplyDialog, LinkPlayerState: " + ((ge1.a) hd0.c.f()).b);
        if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() != 0) goto L12;
        this.k.n0(((Widget) this).context, this.l, r5);
        return;
    L12:
        r5.run();
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void ar(final IBanUser r4) {
        ((SingleSubscribeProxy) ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).getLatestBanRecord(13).as(autoDisposeWithTransformer())).subscribe(new a1(this, r4), new o1());
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView
    public final void d1(com.bytedance.android.livesdk.link.model.bridge.z0 r2) {
        if (this.n == false) goto L7;
        kn0.a r0 = this.d;
        if (r0 == null) goto L11;
        r0.d1(r2);
        return;
    L11:
        return;
    L7:
        kn0.b r1 = this.e;
        if (r1 == null) goto L13;
        r1.d1(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void d9(int r13) {
        ToolbarAudioInteractBehavior r0 = this.w;
        DataContext r1 = getRoomContext();
        r0.getClass();
        Intrinsics.checkNotNullParameter("", "requestPage");
        StringBuilder r2 = new StringBuilder("showAudiencePreApplyDialog, isFollowing: ");
        IRoom r3 = r0.r;
        boolean r4 = false;
        if (r3 == null) goto L9;
        IBaseUser r5 = r3.getBaseOwner();
        if (r5 == null) goto L9;
        if (r5.isFollowing() == true) goto L9;
        boolean r6 = true;
    L10:
        r2.append(r6);
        r2.append(" mIsAnchor: ");
        r2.append(r0.h);
        ALogger.d("ToolbarAudioInteractBehavior", r2.toString());
        if (r0.h == false) goto L14;
        return;
    L14:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.M0.getValue()).booleanValue() == false) goto L39;
        IRoom r7 = r0.r;
        if (r7 == null) goto L39;
        IBaseUser r8 = r7.getBaseOwner();
        if (r8 == null) goto L39;
        if (r8.isFollowing() == true) goto L39;
        if (com.bytedance.android.live.liveinteract.api.utils.m.m(r1) == null) goto L50;
        StringBuilder r9 = new StringBuilder("showFollowGuideDialog, isShowing follow guide dialog: ");
        com.bytedance.android.livesdk.common.b r10 = r0.n;
        if (r10 != null) goto L27;
    L29:
        r9.append(r4);
        ALogger.d("ToolbarAudioInteractBehavior", r9.toString());
        com.bytedance.android.livesdk.common.b r11 = r0.n;
        if (r11 != null) goto L32;
    L34:
        com.bytedance.android.live.liveinteract.widget.widget.q r12 = new com.bytedance.android.live.liveinteract.widget.widget.q(r0.p, com.bytedance.android.live.liveinteract.api.utils.m.i(), this, false, new com.bytedance.android.live.liveinteract.voicechat.toolbar.b(r0, r13));
        r0.n = r12;
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L44;
        DialogLancet.handleBlockedDialogShow(r12);
        return;
    L44:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L43
    L38:
        DialogLancet.beforeDialogShow(r12);
        r12.show();
        DialogLancet.afterDialogShow(r12);
        return;
    L32:
        if (r11.isShowing() != true) goto L34;
        return;
    L27:
        if (r10.isShowing() != true) goto L29;
        r4 = true;
        goto L29
    L50:
        return;
    L39:
        com.bytedance.android.live.liveinteract.plantform.base.g r14 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r14 == null) goto L48;
        r14.Zl(r13);
        return;
    L48:
        return;
    L9:
        r6 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView
    public final void eU(com.bytedance.android.live.liveinteract.api.data.a r2) {
        this.s.getPaidInteractAudienceConfig().setValue(r2);
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView
    public final void fV(com.bytedance.android.livesdk.link.model.bridge.z0 r19) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (r19 != null) goto L7;
        return;
    L7:
        if (this.n == false) goto L9;
    L11:
        IBanUser r2 = r19.getBanAnchorInfo();
        if (r2 != null) goto L14;
    L16:
        boolean r3 = false;
    L17:
        IBanUser r5 = r19.getBanAnchorInfo();
        if (r5 != null) goto L20;
    L22:
        boolean r6 = false;
    L23:
        int r7 = ((IInteractService) jc1.k.f(IInteractService.class)).getLinkMode();
        if (gd0.v.a(r7, 4) == true) goto L28;
        r7 = this.p;
    L28:
        if (je0.e.c(r19, this.l) == false) goto L106;
        if (gd0.v.a(r7, 8) == false) goto L65;
        if (this.n == true) goto L65;
        String r4 = TalkRoomLogUtils.g();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        TalkRoomLogUtils.j = r4;
        if (com.bytedance.android.live.liveinteract.api.utils.m.d() != null) goto L36;
    L40:
        int r8 = 5;
    L42:
        if (com.bytedance.android.live.liveinteract.api.utils.m.d() != null) goto L44;
    L48:
        int r9 = 0;
    L50:
        if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() != 2) goto L52;
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.C(2131915132, new Object[]{com.bytedance.android.live.liveinteract.voicechat.util.n.a(((Widget) this).context, r8, r9)}), 0);
    L53:
        LinkMultiControlPresenter r10 = this.k;
        if (r10 == null) goto L57;
        r10.I0();
    L57:
        if (com.bytedance.android.live.liveinteract.api.utils.m.d() != null) goto L59;
    L63:
        K4(8);
        goto L65
    L59:
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().s() == null) goto L63;
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().s().getValue() == null) goto L63;
        ((com.bytedance.android.livesdk.chatroom.viewmodel.f) com.bytedance.android.live.liveinteract.api.utils.m.d().s().getValue()).d(new com.bytedance.android.livesdk.chatroom.viewmodel.i(0, 0, new ArrayList(), false, false, null));
        goto L63
    L52:
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.C(2131915133, new Object[]{com.bytedance.android.live.liveinteract.voicechat.util.n.a(((Widget) this).context, r8, r9)}), 0);
        goto L53
    L44:
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().s() == null) goto L48;
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().s().getValue() == null) goto L48;
        r9 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) com.bytedance.android.live.liveinteract.api.utils.m.d().s().getValue()).t().b;
        goto L50
    L36:
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().s() == null) goto L40;
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().s().getValue() == null) goto L40;
        r8 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) com.bytedance.android.live.liveinteract.api.utils.m.d().s().getValue()).t().a;
    L65:
        if (this.n == false) goto L68;
        if (r6 == false) goto L68;
        ar(r19.getBanAnchorInfo());
        K4(8);
    L68:
        com.bytedance.android.livesdk.chatroom.o r1 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r1 == null) goto L216;
        com.bytedance.live.datacontext.m r11 = r1.getRoom();
        if (r11 == null) goto L217;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 == null) goto L218;
        z5 r13 = r12.getLinkerDetail();
        if (r13 == null) goto L219;
        List r14 = r13.getPlayModes();
        if (r14 == null) goto L220;
        long r15 = 32;
        if (r14.contains(Long.valueOf(r15)) != true) goto L221;
        ArrayList r16 = new ArrayList();
        com.bytedance.android.livesdk.chatroom.o r17 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r17 == null) goto L96;
        com.bytedance.live.datacontext.m r18 = r17.getRoom();
        if (r18 == null) goto L96;
        IRoom r20 = (IRoom) r18.getValue();
        if (r20 == null) goto L96;
        z5 r21 = r20.getLinkerDetail();
        if (r21 == null) goto L96;
        List r22 = r21.getPlayModes();
        if (r22 == null) goto L96;
        Iterator r23 = r22.iterator();
    L92:
        if (r23.hasNext() == false) goto L96;
        long r24 = ((Number) r23.next()).longValue();
        if (r24 == r15) goto L92;
        r16.add(Long.valueOf(r24));
    L96:
        com.bytedance.android.livesdk.chatroom.o r25 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r25 == null) goto L222;
        com.bytedance.live.datacontext.m r26 = r25.getRoom();
        if (r26 == null) goto L223;
        IRoom r27 = (IRoom) r26.getValue();
        if (r27 == null) goto L224;
        z5 r28 = r27.getLinkerDetail();
        if (r28 == null) goto L225;
        r28.setPlayModes(r16);
        return;
    L225:
        return;
    L224:
        return;
    L223:
        return;
    L222:
        return;
    L221:
        return;
    L220:
        return;
    L219:
        return;
    L218:
        return;
    L217:
        return;
    L216:
        return;
    L106:
        if (je0.e.a(r19) == false) goto L131;
        if (gd0.v.a(r7, 2) == false) goto L227;
        if (r3 == false) goto L116;
        if (this.n == false) goto L113;
    L114:
        IBanUser r29 = r19.getBanAnchorInfo();
        int r30 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        LinkedHashMap r31 = new LinkedHashMap();
        r31.put("ban_user_info", String.valueOf(r29));
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("link_banned_finish", r31);
        SimpleDateFormat r32 = com.bytedance.android.live.liveinteract.utils.e0.a;
        com.bytedance.android.live.liveinteract.utils.e0.d(((Widget) this).context, r19.getBanAnchorInfo(), this.n);
        goto L116
    L113:
        if (hd0.c.f().h() == true) goto L114;
    L116:
        if (this.n == false) goto L120;
        if (r6 == false) goto L120;
        ar(r19.getBanAnchorInfo());
    L120:
        if (this.n == false) goto L123;
        if (r3 == true) goto L123;
        if (r6 == true) goto L123;
    L125:
        if (this.n == false) goto L127;
        return;
    L127:
        if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() != 2) goto L129;
        com.bytedance.android.live.core.utils.f2.b(2131919234, 0);
        return;
    L129:
        com.bytedance.android.live.core.utils.f2.b(2131919233, 0);
        return;
    L123:
        K4(2);
        goto L125
    L227:
        return;
    L131:
        if (je0.e.b(r19, this.l) == true) goto L133;
        return;
    L133:
        if (gd0.v.a(r7, 32) == true) goto L135;
        return;
    L135:
        if (com.bytedance.android.live.liveinteract.api.utils.m.d() != null) goto L137;
    L141:
        int r33 = 8;
    L142:
        Integer r110 = null;
        if (com.bytedance.android.live.liveinteract.api.utils.m.d() != null) goto L145;
    L149:
        List r34 = null;
    L151:
        if (com.bytedance.android.live.liveinteract.api.utils.m.d() == null) goto L158;
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene() == null) goto L158;
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene().getValue() == null) goto L158;
        r110 = Integer.valueOf(((com.bytedance.android.livesdk.chatroom.viewmodel.e) com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene().getValue()).t().c);
    L158:
        if (this.n == true) goto L172;
        if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() != 2) goto L172;
        if (jc1.k.f(IInteractService.class) != null) goto L164;
    L166:
        if (r110 != null) goto L168;
    L170:
        com.bytedance.android.live.core.utils.f2.b(2131919286, 0);
    L187:
        if (r3 == false) goto L194;
        if (this.n == false) goto L191;
    L192:
        IBanUser r35 = r19.getBanAnchorInfo();
        int r36 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        LinkedHashMap r37 = new LinkedHashMap();
        r37.put("ban_user_info", String.valueOf(r35));
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("link_banned_finish", r37);
        SimpleDateFormat r38 = com.bytedance.android.live.liveinteract.utils.e0.a;
        com.bytedance.android.live.liveinteract.utils.e0.d(((Widget) this).context, r19.getBanAnchorInfo(), this.n);
        goto L194
    L191:
        if (hd0.c.f().h() == true) goto L192;
    L194:
        if (this.n == false) goto L197;
        if (r3 == true) goto L197;
        if (r6 == true) goto L197;
    L199:
        if (this.n == false) goto L233;
        if (r6 == false) goto L202;
        ar(r19.getBanAnchorInfo());
    L202:
        if (r33 != 8) goto L207;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r34) == false) goto L207;
        K4(32);
        return;
    L207:
        if (gd0.v.a(this.p, 32) == false) goto L235;
        K4(32);
        return;
    L235:
        return;
    L233:
        return;
    L197:
        K4(32);
        goto L199
    L168:
        if (r110.intValue() != 63) goto L170;
        com.bytedance.android.live.core.utils.f2.b(2131920064, 0);
        goto L187
    L164:
        if (((IInteractService) jc1.k.f(IInteractService.class)).dynamicFromAudience() == false) goto L166;
        com.bytedance.android.live.core.utils.f2.b(2131919285, 0);
    L172:
        if (this.n == true) goto L187;
        if (jc1.k.f(IInteractService.class) != null) goto L176;
    L178:
        if (r110 != null) goto L180;
    L182:
        if (r34 != null) goto L184;
    L186:
        com.bytedance.android.live.core.utils.f2.b(2131919429, 0);
        goto L187
    L184:
        if (r34.contains(39) == false) goto L186;
        com.bytedance.android.live.core.utils.f2.b(2131918932, 0);
        goto L187
    L180:
        if (r110.intValue() != 63) goto L182;
        com.bytedance.android.live.core.utils.f2.b(2131918935, 0);
        goto L187
    L176:
        if (((IInteractService) jc1.k.f(IInteractService.class)).dynamicFromAudience() == false) goto L178;
        com.bytedance.android.live.core.utils.f2.b(2131919232, 0);
        goto L187
    L145:
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene() == null) goto L149;
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene().getValue() == null) goto L149;
        r34 = ((com.bytedance.android.livesdk.chatroom.viewmodel.e) com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene().getValue()).t().b;
        goto L151
    L137:
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene() == null) goto L141;
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene().getValue() == null) goto L141;
        r33 = ((com.bytedance.android.livesdk.chatroom.viewmodel.e) com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene().getValue()).t().a;
        goto L142
    L20:
        if (r5.isAnchorLinkBan() == false) goto L22;
        r6 = true;
        goto L23
    L14:
        if (r2.isValidAudienceLinkBan(this.n) == false) goto L16;
        r3 = true;
        goto L17
    L9:
        if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() != 1) goto L11;
        ((Widget) this).dataCenter.put("data_audience_pre_linkmic_waiting", Boolean.FALSE);
        hd0.c.f().k(0);
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget
    public final void h0(IRoom r33) {
        Lazy r2 = MultiLinkLoadWidgetUtils.a;
        String r4 = "";
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "LinkMultiControlWidget#initFastMode#" + hashCode(), "");
        Sq(r33, "initFastMode");
        this.l = r33;
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == false) goto L5;
    L10:
        Cq();
    L12:
        if (MultiLinkLoadWidgetUtils.l() == true) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == true) goto L20;
    L32:
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "LinkMultiControlWidget", "fastSwitchMode");
        com.bytedance.android.livesdk.chatroom.u r1 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r1 != null) goto L36;
        return;
    L36:
        if (this.l.getLinkerDetail() == null) goto L39;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r5 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.t1(this.l.getLinkerDetail());
        com.bytedance.android.live.liveinteract.plantform.utils.i.f(this.l.getLinkerDetail());
    L39:
        if (vm2.h.W().isPlayModesInterceptEnable() == false) goto L54;
        if (this.l.getLinkerDetail() == null) goto L54;
        if (Lists.notEmpty(this.l.getLinkerDetail().getPlayModes()) == false) goto L54;
        List r6 = this.l.getLinkerDetail().getPlayModes();
        List r7 = vm2.h.W().getPlayModeInterceptList();
        Intrinsics.checkNotNullParameter(r6, "originList");
        Intrinsics.checkNotNullParameter(r7, "targetList");
        ArrayList r8 = new ArrayList();
        Iterator r9 = r6.iterator();
    L46:
        if (r9.hasNext() == false) goto L50;
        long r10 = ((Number) r9.next()).longValue();
        if (r7.contains(Long.valueOf(r10)) == false) goto L46;
        r8.add(Long.valueOf(r10));
        goto L46
    L50:
        Lazy r11 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.m(((Widget) this).dataCenter, "LinkMultiControlWidget", "fastSwitchMode intercept playMode, linkerDetailPlayModeList = " + r6 + ", playModeInterceptList = " + r7 + ", retainList = " + r8);
        if (Lists.notEmpty(r8) == false) goto L54;
        return;
    L54:
        if (this.l.getLinkMap() == null) goto L231;
        Map r12 = this.l.getLinkMap();
        int r13 = MultiSceneEnterRoomStatisticsUtils.u;
        if (MultiSceneEnterRoomStatisticsUtils.a.a(((Widget) this).dataCenter, Long.valueOf(this.l.getId())) == null) goto L61;
        MultiSceneEnterRoomStatisticsUtils.a.a(((Widget) this).dataCenter, Long.valueOf(this.l.getId())).n(com.bytedance.android.live.liveinteract.videotalk.utils.a0.b(this.l));
        MultiSceneEnterRoomStatisticsUtils r14 = MultiSceneEnterRoomStatisticsUtils.a.a(((Widget) this).dataCenter, Long.valueOf(this.l.getId()));
        if (r14.g() == false) goto L61;
        r14.startObserveBaseElementLoadEnd("link_mic");
    L61:
        int r15 = 8;
        if (this.l.isLiveTypeAudio() == true) goto L132;
        if (r12.containsKey(String.valueOf(8)) == true) goto L74;
        if (r12.containsKey(String.valueOf(12)) == false) goto L70;
        int r16 = com.bytedance.android.live.liveinteract.videotalk.utils.a0.a(12, this.l);
        if (((ArrayList) com.bytedance.android.livesdk.chatroom.interact.model.f0.a).contains(Integer.valueOf(r16)) == true) goto L74;
    L70:
        if (r12.containsKey(String.valueOf(16)) == true) goto L74;
        ln0.a r17 = yg0.h.a;
        if (yg0.h.i(com.bytedance.android.live.liveinteract.videotalk.utils.a0.b(this.l)) == false) goto L132;
    L74:
        if (r1.getVideoTalkRoomSubScene() != null) goto L76;
    L130:
        wu(32, MultiLinkOpenSource.FAST_INIT_MODE);
    L196:
        int r18 = com.bytedance.android.live.liveinteract.videotalk.utils.a0.b(this.l);
        ArrayList r19 = new ArrayList();
        if (this.l.getLinkerDetail() == null) goto L205;
        if (this.l.getLinkerDetail().getPlayModes() == null) goto L205;
        Iterator r20 = this.l.getLinkerDetail().getPlayModes().iterator();
    L202:
        if (r20.hasNext() == false) goto L205;
        r19.add(Integer.valueOf((int) ((Long) r20.next()).longValue()));
    L205:
        if (this.l.isLiveTypeAudio() == true) goto L218;
        ln0.a r21 = yg0.h.a;
        if (yg0.h.i(r18) == true) goto L218;
        if (r18 < 109) goto L218;
        if (r18 > 112) goto L218;
        if (this.l.getLinkerDetail() == null) goto L215;
        List<Integer> r22 = r19;
        int r23 = 12;
    L216:
        Gl(r23, r22, r18);
        goto L218
    L215:
        r23 = 12;
        r22 = null;
    L218:
        if (r12.containsKey(String.valueOf(5)) == true) goto L220;
        return;
    L220:
        if (this.l.getLinkerDetail() != null) goto L222;
        return;
    L222:
        if (this.l.getLinkerDetail().getPlayModes() == null) goto L253;
        Iterator r24 = this.l.getLinkerDetail().getPlayModes().iterator();
    L225:
        if (r24.hasNext() == false) goto L256;
        long r25 = ((Long) r24.next()).longValue();
        if (r1.J() == null) goto L225;
        LivePlayModeLogContext r26 = (LivePlayModeLogContext) r1.J().getValue();
        if (r26 == null) goto L225;
        r26.addPlayMode((int) r25);
        goto L225
    L256:
        return;
    L253:
        return;
    L76:
        if (r1.getVideoTalkRoomSubScene().getValue() == null) goto L130;
        ArrayList r27 = new ArrayList();
        if (this.l.getLinkerDetail() == null) goto L86;
        if (this.l.getLinkerDetail().getPlayModes() == null) goto L86;
        Iterator r28 = this.l.getLinkerDetail().getPlayModes().iterator();
    L83:
        if (r28.hasNext() == false) goto L86;
        r27.add(Integer.valueOf((int) ((Long) r28.next()).longValue()));
    L86:
        if (this.l.getLinkerDetail() == null) goto L88;
        ClientUIInfo r110 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.a.a(this.l.getLinkerDetail().getClientUiInfo());
    L89:
        StringBuilder r29 = new StringBuilder("fastSwitchMode, get room clientUIInfo#ui_feature_list data: ");
        if (r110 == null) goto L92;
        List r30 = r110.getUiFeatureList();
    L93:
        r29.append(r30);
        ALogger.d("LinkControlWidget", r29.toString());
        if (r12.containsKey(String.valueOf(16)) == false) goto L105;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r31 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getVideoTalkRoomSubScene().getValue();
        if (this.l.getLinkerDetail() == null) goto L98;
        ArrayList r111 = r27;
    L99:
        r31.e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(16, r111, com.bytedance.android.live.liveinteract.videotalk.utils.a0.a(16, this.l), false, r110));
        if (this.l.getLinkerDetail() != null) goto L103;
        r27 = null;
    L103:
        Gl(16, r27, com.bytedance.android.live.liveinteract.videotalk.utils.a0.a(16, this.l));
        r15 = 16;
    L125:
        if (((IInteractService) jc1.k.f(IInteractService.class)).dynamicService(((Widget) this).dataCenter) != null) goto L127;
    L129:
        ALogger.w("ttlive_link", "initFastMode#syncRoomStats " + ((com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getVideoTalkRoomSubScene().getValue()).t());
        goto L130
    L127:
        if (((IInteractService) jc1.k.f(IInteractService.class)).dynamicService(((Widget) this).dataCenter).tb() == null) goto L129;
        HashMap r32 = new HashMap();
        r32.put("scene", Integer.valueOf(r15));
        ((IInteractService) jc1.k.f(IInteractService.class)).dynamicService(((Widget) this).dataCenter).tb().updateData(r32);
        goto L129
    L98:
        r111 = null;
        goto L99
    L105:
        if (r12.containsKey(String.valueOf(12)) == false) goto L115;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r34 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getVideoTalkRoomSubScene().getValue();
        if (this.l.getLinkerDetail() == null) goto L109;
        ArrayList r112 = r27;
    L110:
        r34.e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(12, r112, com.bytedance.android.live.liveinteract.videotalk.utils.a0.a(12, this.l), false, r110));
        if (this.l.getLinkerDetail() != null) goto L114;
        r27 = null;
    L114:
        Gl(12, r27, com.bytedance.android.live.liveinteract.videotalk.utils.a0.a(12, this.l));
        r15 = 12;
        goto L125
    L109:
        r112 = null;
        goto L110
    L115:
        com.bytedance.android.livesdk.chatroom.viewmodel.e r35 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getVideoTalkRoomSubScene().getValue();
        if (this.l.getLinkerDetail() == null) goto L118;
        ArrayList r113 = r27;
    L119:
        r35.e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(8, r113, com.bytedance.android.live.liveinteract.videotalk.utils.a0.a(8, this.l), false, r110));
        if (this.l.getLinkerDetail() != null) goto L123;
        r27 = null;
    L123:
        Gl(8, r27, com.bytedance.android.live.liveinteract.videotalk.utils.a0.a(8, this.l));
        goto L125
    L118:
        r113 = null;
        goto L119
    L92:
        r30 = null;
        goto L93
    L88:
        r110 = null;
    L132:
        if (this.l.isLiveTypeAudio() == false) goto L196;
        boolean r36 = this.l.getLinkMap().containsKey(String.valueOf(5));
        com.bytedance.android.livesdk.chatroom.viewmodel.f.a.getClass();
        Iterator r114 = com.bytedance.android.livesdk.chatroom.viewmodel.f.a.a.iterator();
        int r115 = 0;
    L135:
        if (r114.hasNext() == false) goto L142;
        int r37 = ((Integer) r114.next()).intValue();
        if (r37 == 5) goto L135;
        if (this.l.getLinkMap().containsKey(String.valueOf(r37)) == false) goto L135;
        r115 = r37;
        goto L135
    L142:
        if (r115 != 0) goto L146;
        if (r36 == false) goto L146;
        r115 = 5;
    L146:
        if (r1.getVideoTalkRoomSubScene() == null) goto L190;
        if (r1.s().getValue() == null) goto L190;
        if (this.l.getLinkerDetail() == null) goto L152;
        int r38 = this.l.getLinkerDetail().getUiLayout();
    L153:
        if (r115 != 5) goto L156;
        if (r38 != 0) goto L156;
        r38 = je0.d.o();
    L156:
        int r210 = r38;
        ArrayList r39 = new ArrayList();
        if (this.l.getLinkerDetail() == null) goto L165;
        if (this.l.getLinkerDetail().getPlayModes() == null) goto L165;
        Iterator r40 = this.l.getLinkerDetail().getPlayModes().iterator();
    L162:
        if (r40.hasNext() == false) goto L165;
        r39.add(Integer.valueOf(((Long) r40.next()).intValue()));
    L165:
        if (this.l.getLinkerDetail() == null) goto L171;
        ClientUIInfo r41 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.a.a(this.l.getLinkerDetail().getClientUiInfo());
        StringBuilder r42 = new StringBuilder("attachView, get room clientUIInfo#ui_feature_list data: ");
        if (r41 == null) goto L169;
        List r43 = r41.getUiFeatureList();
    L170:
        r42.append(r43);
        ALogger.d("LinkControlWidget", r42.toString());
        ClientUIInfo r211 = r41;
    L172:
        ArrayList r44 = new ArrayList();
        if (r1.getVideoTalkRoomSubScene() != null) goto L175;
    L184:
        ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.s().getValue()).d(new com.bytedance.android.livesdk.chatroom.viewmodel.i(r115, r210, r39, false, false, r211));
        if (((IInteractService) jc1.k.f(IInteractService.class)).dynamicService(((Widget) this).dataCenter) == null) goto L190;
        if (((IInteractService) jc1.k.f(IInteractService.class)).dynamicService(((Widget) this).dataCenter).tb() == null) goto L190;
        HashMap r45 = new HashMap();
        r45.put("scene", Integer.valueOf(r115));
        ((IInteractService) jc1.k.f(IInteractService.class)).dynamicService(((Widget) this).dataCenter).tb().updateData(r45);
        goto L190
    L175:
        if (r1.s().getValue() == null) goto L184;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r46 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.s().getValue()).t();
        if (r46 == null) goto L182;
        int r47 = r46.a;
        int r116 = r46.b;
        List r117 = r46.c;
        if (r117 == null) goto L181;
        r44.addAll(r117);
    L181:
        ClientUIInfo r310 = r46.a();
        int r212 = r47;
        int r213 = r116;
    L183:
        ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.s().getValue()).c(new com.bytedance.android.livesdk.chatroom.viewmodel.i(r212, r213, r44, false, false, r310));
        goto L184
    L182:
        r212 = 0;
        r213 = 0;
        r310 = null;
        goto L183
    L169:
        r43 = null;
        goto L170
    L171:
        r211 = null;
        goto L172
    L152:
        r38 = 0;
    L190:
        if (r12.containsKey(String.valueOf(5)) == false) goto L192;
    L195:
        wu(8, MultiLinkOpenSource.FAST_INIT_MODE);
        goto L196
    L192:
        if (r12.containsKey(String.valueOf(16)) == true) goto L195;
        if (r12.containsKey(String.valueOf(9)) == false) goto L196;
    L231:
        return;
    L20:
        if (TextUtils.equals(r33.getAnchorId(), je0.d.b0()) == true) goto L32;
        if (r33.getLinkerDetail() == null) goto L24;
        r4 = r33.getLinkerDetail().getFunctionType2();
        String r48 = r33.getLinkerDetail().getInitSource();
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "ControlWidget", "openSource = " + r33.getLinkerDetail().getFunctionType2() + ", initSource = " + r33.getLinkerDetail().getInitSource());
    L26:
        if (jc1.k.f(IInteractService.class) == null) goto L29;
        ((IInteractService) jc1.k.f(IInteractService.class)).updateVideoTalkRoomOpenSource(r4);
    L29:
        if ("pre_apply_chat_room".equals(r48) == false) goto L31;
        us1.e.a = true;
        goto L32
    L31:
        us1.e.a = false;
        goto L32
    L24:
        r48 = "";
        goto L26
    L14:
        if (vm2.h.W().enableOptAudienceRoomOpenStatusUpdateTime() == false) goto L16;
        r3 = true;
        goto L17
    L5:
        if (((Boolean) vm2.h.I4.getValue(null, vm2.h.a[293(0x125, float:4.1E-43)])).booleanValue() == false) goto L12;
        if (MultiLinkLoadWidgetUtils.f() == false) goto L12;
        if (r33.getLinkMap().containsKey(String.valueOf(9)) == false) goto L12;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final boolean isMicRoomHost(String r4) {
        if (this.G != null) goto L5;
        return false;
    L5:
        if (jc1.k.f(IMiddlewareMicRoomService.class).isMicRoom(this.l) == true) goto L7;
        return false;
    L7:
        if (this.G.isMicRoomHost(r4) == false) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final boolean k0(int r2) {
        return gd0.v.a(this.p, r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void mq(Disposable r2) {
        CompositeDisposable r0 = this.D;
        if (r0 == null) goto L6;
        r0.add(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void nb(int r3) {
        com.bytedance.android.live.liveinteract.voicechat.toolbar.e r0 = this.z;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 != 5) goto L8;
        r0.setAlpha(1.0f);
        return;
    L8:
        if (r3 != 9) goto L13;
        r0.setAlpha(0.34f);
        return;
    }

    public final void onChanged(Object r21) {
        KVData r1 = (KVData) r21;
        if (isViewValid() == false) goto L334;
        if (r1 != null) goto L6;
        return;
    L6:
        if (r1.getData() == null) goto L388;
        boolean r2 = MultiLinkLoadWidgetUtils.g();
        String r3 = r1.getKey();
        r3.getClass();
        boolean r10 = true;
        switch(r3.hashCode()) {
            case -2002744417: goto L68;
            case -1469246359: goto L64;
            case -1263874350: goto L60;
            case -1087489445: goto L56;
            case -1047355252: goto L52;
            case -793150208: goto L48;
            case -776079610: goto L44;
            case -274879138: goto L40;
            case -271145422: goto L36;
            case 494516720: goto L32;
            case 757444085: goto L28;
            case 761234139: goto L24;
            case 1062955873: goto L20;
            case 1292690301: goto L16;
            case 1932269607: goto L12;
            default: goto L71;
        };
    L71:
        byte r4 = -1;
    L73:
        switch(r4) {
            case 0: goto L327;
            case 1: goto L321;
            case 2: goto L292;
            case 3: goto L257;
            case 4: goto L252;
            case 5: goto L230;
            case 6: goto L227;
            case 7: goto L205;
            case 8: goto L170;
            case 9: goto L148;
            case 10: goto L133;
            case 11: goto L123;
            case 12: goto L117;
            case 13: goto L102;
            case 14: goto L76;
            default: goto L389;
        };
    L102:
        IRoom r5 = (IRoom) r1.getData();
        if (r5 == null) goto L340;
        LinkMultiControlPresenter r6 = this.k;
        if (r6.j == true) goto L390;
        int r7 = r6.J0(r5, false);
        if (gd0.v.a(r7, 2) == false) goto L110;
    L113:
        r6.h.j.c(FetchSettingType.syncRoomStatsWhenUpdate);
    L114:
        DataCenter r8 = ((com.bytedance.android.livesdk.chatroom.presenter.n) r6).c;
        if (r8 == null) goto L341;
        r8.put("data_interact_update_room_done", r5);
        return;
    L341:
        return;
    L110:
        if (gd0.v.a(r7, 8) == true) goto L113;
        if (gd0.v.a(r7, 32) == false) goto L114;
    L390:
        return;
    L340:
        return;
    L117:
        Object r9 = r1.getData();
        if ((r9 instanceof Integer) == true) goto L120;
        return;
    L120:
        if (((Integer) r9).intValue() <= 0) goto L344;
        this.k.t0();
        return;
    L344:
        return;
    L133:
        int r11 = ((Integer) r1.getData(0)).intValue();
        if (r11 != 1) goto L136;
        this.x.setAlpha(0.5f);
        this.y.setAlpha(0.5f);
    L138:
        if (r11 == 3) goto L140;
    L146:
        if (r11 != 2) goto L348;
        this.k.h.j.c(FetchSettingType.AnchorStatusStart);
        return;
    L348:
        return;
    L140:
        if (gd0.v.a(this.p, 32) == false) goto L146;
        if (tc0.c.h().g == false) goto L146;
        tc0.c.h().g = false;
        rj0.k.m2.getClass();
        rj0.k r12 = rj0.k.a.a();
        if (r12 == null) goto L146;
        r12.finishVideoTalk("mic_room_end");
        hd0.c.f().k(0);
        goto L146
    L136:
        this.x.setAlpha(1.0f);
        this.y.setAlpha(1.0f);
        goto L138
    L148:
        Object r13 = r1.getData();
        if ((r13 instanceof com.bytedance.android.livesdk.chatroom.model.c2) == false) goto L350;
        com.bytedance.android.livesdk.chatroom.model.c2 r14 = (com.bytedance.android.livesdk.chatroom.model.c2) r13;
        if (jc1.k.f(IKtvService.class) != null) goto L153;
    L155:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r15 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.o1("music");
    L157:
        if (this.m != LiveMode.VIDEO) goto L167;
        if (r14.a == 8) goto L161;
    L165:
        this.k.u0("music");
        return;
    L161:
        if (r14.b != 63) goto L165;
        if (r14.c != 36) goto L165;
        this.k.g0(false, 6, true, "video_chorus", false);
        return;
    L167:
        if (com.bytedance.android.live.liveinteract.api.utils.m.c() == false) goto L169;
        this.k.s0(null, null);
        return;
    L169:
        this.k.t0();
        return;
    L153:
        if (jc1.k.f(IKtvService.class).isMultiChorusEnable() == false) goto L155;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r16 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.o1("user_chorus");
        goto L157
    L350:
        return;
    L170:
        if (r2 == false) goto L355;
        IRoom r17 = this.l;
        if (r17 != null) goto L174;
        return;
    L174:
        if (r17.isLiveTypeAudio() == false) goto L391;
        DataCenter r18 = ((Widget) this).dataCenter;
        if (r18 != null) goto L179;
    L181:
        boolean r19 = false;
    L182:
        DataCenter r20 = ((Widget) this).dataCenter;
        if (r20 != null) goto L185;
    L187:
        boolean r22 = false;
    L188:
        jd0.g r23 = (jd0.g) r1.getData();
        if (r23 == null) goto L193;
        if (r23.a == false) goto L193;
    L196:
        ALogger.i("LinkControlWidget", "handleInteractAudio, isInteractState :" + r10 + " , isInRealTimeChorus : , " + r22 + "isKtvOpened : " + r19);
        if (r10 == true) goto L202;
        if (r22 == true) goto L202;
        if (r19 == true) goto L202;
        yq();
        return;
    L202:
        Widget r24 = this.i;
        if (r24 == null) goto L358;
        this.o.k(r24);
        this.i = null;
        return;
    L358:
        return;
    L193:
        if (Iq() != 0) goto L196;
        r10 = false;
        goto L196
    L185:
        if (((jd0.k) r20.get("cmd_interact_real_time_chorus", new jd0.k(false))).a == false) goto L187;
        r22 = true;
        goto L188
    L179:
        if (((Boolean) r18.get("cmd_ktv_luanch", Boolean.FALSE)).booleanValue() == false) goto L181;
        r19 = true;
        goto L182
    L391:
        return;
    L355:
        return;
    L205:
        Object r25 = r1.getData();
        if ((r25 instanceof FastStartKtvVideoModel) == false) goto L360;
        FastStartKtvVideoModel r26 = (FastStartKtvVideoModel) r25;
        LinkMultiControlPresenter r110 = this.k;
        int r27 = us1.g.a;
        Boolean r28 = Boolean.TRUE;
        if (r26 != null) goto L210;
        r110.getClass();
        return;
    L210:
        r110.q = r26;
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() != null) goto L213;
    L215:
        FastStartKtvVideoModel r29 = r110.q;
        if (r29 != null) goto L218;
        int r111 = -1;
        int r112 = -1;
    L226:
        r110.h0(false, false, 3, true, "", false, r111, r112, 0);
        return;
    L218:
        if (r29.getScene() == null) goto L220;
        int r30 = r110.q.getScene().intValue();
    L222:
        if (r110.q.getUiLayout() == null) goto L224;
        r112 = r30;
        r111 = r110.q.getUiLayout().intValue();
        goto L226
    L224:
        r112 = r30;
        r111 = -1;
        goto L226
    L220:
        r30 = -1;
        goto L222
    L213:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a().k0(2) == false) goto L215;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) r110).c.put("cmd_force_close_linkin_before_videotalk", r28);
        hd0.c.f().c(r110.y);
        return;
    L360:
        return;
    L227:
        hd0.c.f().k(2);
        ToolbarVideoInteractBehavior r31 = this.x;
        if (r31 == null) goto L364;
        r31.j();
        return;
    L364:
        return;
    L230:
        HashMap r32 = new HashMap();
        r32.put("page", "card");
        if (this.n == false) goto L233;
        String r33 = "anchor";
    L234:
        r32.put("invite_type", r33);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_anchor_invite", r32, new Object[]{IRoom.class});
        IBaseUser r34 = (IBaseUser) r1.getData();
        if (r34 == null) goto L392;
        int r35 = jf0.b.a;
        jf0.b.d(r34.getIdString(), "card", this.n);
        if (this.n == false) goto L243;
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a() == null) goto L366;
        com.bytedance.android.live.liveinteract.plantform.base.d.a.a().invite(this.l.getId(), "", r34.getCastSecUid(), 1, 0);
        return;
    L366:
        return;
    L243:
        if (jc1.k.f(IMiddlewareUserService.class).user().c() == false) goto L248;
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.c.a.a() == null) goto L368;
        com.bytedance.android.live.liveinteract.plantform.base.c.a.a().t2(this.l.getId(), "", r34.getCastSecUid());
        return;
    L368:
        return;
    L248:
        if (jc1.k.f(IMiddlewareUserService.class).user().isAdmin() == false) goto L250;
        com.bytedance.android.live.core.utils.f2.b(2131914522, 0);
    L251:
        com.bytedance.android.live.liveinteract.plantform.utils.x.C0(TalkRoomOperate.INVITE);
        return;
    L250:
        com.bytedance.android.live.core.utils.f2.b(2131917298, 0);
        goto L251
    L392:
        return;
    L233:
        r33 = "administrator";
        goto L234
    L252:
        Object r36 = r1.getData();
        if ((r36 instanceof Integer) == true) goto L255;
        return;
    L255:
        if (((Integer) r36).intValue() <= 0) goto L372;
        LinkMultiControlPresenter r37 = this.k;
        int r38 = us1.g.a;
        r37.v0(true);
        return;
    L372:
        return;
    L257:
        if (r2 == false) goto L374;
        IRoom r39 = this.l;
        if (r39 != null) goto L261;
        return;
    L261:
        if (r39.isLiveTypeAudio() == false) goto L393;
        DataCenter r40 = ((Widget) this).dataCenter;
        if (r40 != null) goto L266;
    L268:
        boolean r41 = false;
    L269:
        DataCenter r42 = ((Widget) this).dataCenter;
        if (r42 == null) goto L274;
        if (((jd0.g) r42.get("cmd_interact_audio", new jd0.g(false))).a == false) goto L274;
    L275:
        boolean r43 = true;
    L277:
        jd0.k r44 = (jd0.k) r1.getData();
        if (r44 != null) goto L280;
    L282:
        r10 = false;
    L283:
        ALogger.i("LinkControlWidget", "handleInteractRealTimeChorus, isInteractState :" + r43 + " , isInRealTimeChorus : , " + r10 + "isKtvOpened : " + r41);
        if (r43 == true) goto L289;
        if (r10 == true) goto L289;
        if (r41 == true) goto L289;
        yq();
        return;
    L289:
        Widget r45 = this.i;
        if (r45 == null) goto L377;
        this.o.k(r45);
        this.i = null;
        return;
    L377:
        return;
    L280:
        if (r44.a == false) goto L282;
    L274:
        if (Iq() != 0) goto L275;
        r43 = false;
        goto L277
    L266:
        if (((Boolean) r40.get("cmd_ktv_luanch", Boolean.FALSE)).booleanValue() == false) goto L268;
        r41 = true;
        goto L269
    L393:
        return;
    L374:
        return;
    L292:
        if (r2 == false) goto L379;
        IRoom r46 = this.l;
        if (r46 != null) goto L296;
        return;
    L296:
        if (r46.isLiveTypeAudio() == false) goto L394;
        boolean r47 = ((Boolean) r1.getData()).booleanValue();
        DataCenter r48 = ((Widget) this).dataCenter;
        if (r48 != null) goto L301;
    L303:
        boolean r49 = false;
    L304:
        DataCenter r50 = ((Widget) this).dataCenter;
        if (r50 == null) goto L309;
        if (((jd0.g) r50.get("cmd_interact_audio", new jd0.g(false))).a == false) goto L309;
    L312:
        ALogger.i("LinkControlWidget", "handleKtvLaunch, isInteractState :" + r10 + " , isInRealTimeChorus : , " + r49 + "isKtvOpened : " + r47);
        if (r10 == true) goto L318;
        if (r49 == true) goto L318;
        if (r47 == true) goto L318;
        yq();
        return;
    L318:
        Widget r51 = this.i;
        if (r51 == null) goto L382;
        this.o.k(r51);
        this.i = null;
        return;
    L382:
        return;
    L309:
        if (Iq() != 0) goto L312;
        r10 = false;
        goto L312
    L301:
        if (((jd0.k) r48.get("cmd_interact_real_time_chorus", new jd0.k(false))).a == false) goto L303;
        r49 = true;
        goto L304
    L394:
        return;
    L379:
        return;
    L321:
        Object r52 = r1.getData();
        if ((r52 instanceof Boolean) == true) goto L324;
        return;
    L324:
        if (((Boolean) r52).booleanValue() == false) goto L326;
        y3.m(((Widget) this).dataCenter).p(ToolbarButton.INTERACTION_SCENE.extended(), this.y);
        return;
    L326:
        y3.m(((Widget) this).dataCenter).f(ToolbarButton.INTERACTION_SCENE.extended(), this.y);
        return;
    L327:
        LinkMultiControlPresenter r53 = this.k;
        r53.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() != null) goto L330;
    L332:
        r53.g0(false, 4, false, "", false);
        return;
    L330:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a().k0(2) == false) goto L332;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) r53).c.put("cmd_force_close_linkin_before_videotalk", Boolean.TRUE);
        hd0.c.f().c(r53.z);
        return;
    L389:
        return;
    L76:
        if (this.n == false) goto L78;
        return;
    L78:
        if (Aq() == false) goto L80;
        br(true, "anchor enable pre linkmic");
        return;
    L80:
        IInteractService r54 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r54 == null) goto L83;
        int r55 = r54.getCurrentScene();
    L85:
        if (gd0.v.a(this.p, 2) == true) goto L99;
        if (r55 == 4) goto L99;
        boolean r56 = us1.e.a;
        if (us1.e.a(this.l) == false) goto L99;
        if (r54 == null) goto L99;
        if (this.m != LiveMode.VIDEO) goto L99;
        if (nd() == true) goto L99;
        DataCenter r57 = ((Widget) this).dataCenter;
        IRoom r58 = this.l;
        boolean r59 = this.n;
        Intrinsics.checkNotNullParameter(r57, "dataCenter");
        if ((!us1.e.c(r57, r58, r59)) == false) goto L99;
    L100:
        if (r10 == false) goto L338;
        br(false, "anchor enable pre linkmic");
        return;
    L338:
        return;
    L99:
        r10 = false;
        goto L100
    L83:
        r55 = 0;
        goto L85
    L123:
        if ((r1.getData() instanceof CloudGroupLivePipelineStatus) == false) goto L125;
        CloudGroupLivePipelineStatus r60 = (CloudGroupLivePipelineStatus) r1.getData();
    L127:
        if (r60 != CloudGroupLivePipelineStatus.INVITING) goto L129;
    L132:
        String r61 = com.bytedance.android.live.core.utils.s1.B(2131915857);
        y3.m(((Widget) this).dataCenter).l(ToolbarButton.PK.extended(), r61);
        y3.m(((Widget) this).dataCenter).l(ToolbarButton.INTERACTION.extended(), r61);
        return;
    L129:
        if (r60 == CloudGroupLivePipelineStatus.START) goto L132;
        y3.m(((Widget) this).dataCenter).h(ToolbarButton.PK.extended());
        y3.m(((Widget) this).dataCenter).h(ToolbarButton.INTERACTION.extended());
        return;
    L125:
        r60 = CloudGroupLivePipelineStatus.END;
        goto L127
    L12:
        if (r3.equals("data_room_video_talk_integration_accept_audience_prepare_apply") == false) goto L71;
        r4 = 14;
        goto L73
    L16:
        if (r3.equals("data_interact_update_room") == false) goto L71;
        r4 = 13;
        goto L73
    L20:
        if (r3.equals("cmd_init_voice_chat_room_with_pending_play_mode") == false) goto L71;
        r4 = 12;
        goto L73
    L24:
        if (r3.equals("data_cloud_group_live_pipeline_status") == false) goto L71;
        r4 = 11;
        goto L73
    L28:
        if (r3.equals("cmd_mic_room_anchor_status") == false) goto L71;
        r4 = 10;
        goto L73
    L32:
        if (r3.equals("cmd_ktv_component_init_link") == false) goto L71;
        r4 = 9;
        goto L73
    L36:
        if (r3.equals("cmd_interact_audio") == false) goto L71;
        r4 = 8;
        goto L73
    L40:
        if (r3.equals("cmd_init_video_talk_room_with_pending_schema_config") == false) goto L71;
        r4 = 7;
        goto L73
    L44:
        if (r3.equals("data_audience_recover_linkmic_online") == false) goto L71;
        r4 = 6;
        goto L73
    L48:
        if (r3.equals("cmd_interact_audience_invite") == false) goto L71;
        r4 = 5;
        goto L73
    L52:
        if (r3.equals("cmd_init_video_talk_room_with_pending_play_mode") == false) goto L71;
        r4 = 4;
        goto L73
    L56:
        if (r3.equals("cmd_interact_real_time_chorus") == false) goto L71;
        r4 = 3;
        goto L73
    L60:
        if (r3.equals("cmd_ktv_luanch") == false) goto L71;
        r4 = 2;
        goto L73
    L64:
        if (r3.equals("cmd_show_hide_scene_btn") == false) goto L71;
        r4 = 1;
        goto L73
    L68:
        if (r3.equals("cmd_init_video_ktv") == false) goto L71;
        r4 = 0;
        goto L73
    L388:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.ILinkControlWidget, com.bytedance.android.live.pkaudience.api.c
    public final void onSei(String r12) {
        if (this.n == false) goto L5;
        return;
    L5:
        this.N.c(r12);
        if (TextUtils.equals(r12, this.H) == true) goto L8;
    L10:
        ye1.a r0 = new ye1.a(false, "", 0, 0, 0, this.l);
        Eq(r12, r0);
        Fq(r12, r0);
        if (gd0.v.a(this.p, 32) == false) goto L16;
        rj0.o r1 = this.g;
        if (r1 == null) goto L17;
        r1.onSei(r12, r0);
        this.H = r12;
        return;
    L17:
        return;
    L16:
        return;
    L8:
        if (((Boolean) vm2.d.R3.getValue(null, vm2.d.a[249(0xf9, float:3.49E-43)])).booleanValue() == false) goto L10;
    }

    @Override // com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget
    public final void p3(IRoom r9) {
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "LinkMultiControlWidget", "call updateRoomAfterEnter");
        this.l = r9;
        Sq(r9, "updateFullMode");
        if (MultiLinkLoadWidgetUtils.f() == false) goto L64;
        rj0.o r1 = this.g;
        long r2 = 0;
        if (r1 == null) goto L7;
        long r3 = r1.hashCode();
    L8:
        kn0.b r4 = this.e;
        if (r4 == null) goto L11;
        r2 = r4.hashCode();
    L11:
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "LinkMultiControlWidget#updateFullMode", "videoTalkGuestWidgetHashCode = " + r3 + ", voiceGuestWidgetHashCode = " + r2);
        Tq();
        boolean r5 = true;
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == false) goto L28;
        IRoom r6 = this.l;
        if (r6 == null) goto L28;
        if (r6.getLinkerDetail() == null) goto L28;
        if (this.l.getLinkerDetail().getUiLayout() == 0) goto L28;
        MultiRevenueDataContext.Companion.getClass();
        if (MultiRevenueDataContext.a.d() == null) goto L28;
        if (MultiRevenueDataContext.a.d().l(((Widget) this).dataCenter) == true) goto L28;
        if (this.l.getLinkMap() != null) goto L26;
    L27:
        Mq();
        goto L28
    L26:
        if (this.l.getLinkMap().containsKey(String.valueOf(20)) != true) goto L27;
    L28:
        rj0.o r7 = this.g;
        if (r7 != null) goto L31;
    L33:
        kn0.b r8 = this.e;
        if (r8 != null) goto L36;
    L40:
        IRoom r10 = this.l;
        Intrinsics.checkNotNullParameter("LinkControlWidget", "logTag");
        String r11 = null;
        if (((vb1) vm2.h.f6.getValue(null, vm2.h.a[368(0x170, float:5.16E-43)])).a() == true) goto L43;
        return;
    L43:
        if (je0.d.D() == true) goto L69;
        if (r10 == null) goto L49;
        z5 r12 = r10.getLinkerDetail();
        if (r12 == null) goto L49;
        r11 = r12.getClientUiInfo();
    L49:
        if (r11 != null) goto L62;
    L54:
        if (r5 == true) goto L66;
        JSONObject r13 = new JSONObject(r11);     // Catch: Exception -> L61
        if (r13.has("ui_translation") == false) goto L67;
        r13.remove("ui_translation");     // Catch: Exception -> L61
        String r14 = r13.toString();     // Catch: Exception -> L61
        z5 r15 = r10.getLinkerDetail();     // Catch: Exception -> L61
        if (r15 == null) goto L68;
        r15.setClientUiInfo(r14);     // Catch: Exception -> L61
        return;
    L70:
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L62:
        if (r11.length() == 0) goto L54;
        r5 = false;
        goto L54
    L69:
        return;
    L36:
        if ((r8 instanceof qd0.d) == false) goto L40;
        if (r8.hashCode() != r2) goto L40;
        ((qd0.d) this.e).U0(r9);
        goto L40
    L31:
        if (r7.hashCode() != r3) goto L33;
        this.g.U0(r9);
        goto L33
    L7:
        r3 = 0;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void prepareApply(String r3) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.put("data_linkmic_close_invite_apply_source", r3);
    L5:
        this.x.h(getRoomContext(), r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void xh(PaidProfileCardWidget r2) {
        this.o.k(r2);
    }

    public final void zq(boolean r6) {
        if (this.n == true) goto L11;
        if (r6 == false) goto L6;
        return;
    L6:
        if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() == 1) goto L8;
        return;
    L8:
        if (this.l == null) goto L14;
        final long r0 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.v("exit_room_when_in_waiting_list");
        ((SingleSubscribeProxy) ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).leave(this.l.getId(), "exit_room_when_in_waiting_list").as(autoDisposeWithTransformer())).subscribe(new u0(r0), new v0(this, r0));
        return;
    L14:
        return;
    }

    public static void xq(LinkDialog r3, FragmentManager r4) {
        if ((r3 instanceof Fragment) == false) goto L5;
        LinkDialog r0 = r3;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "LinkDialog", r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r3.show(r4, "LinkDialog");
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void Eq(String r5, ye1.a r6) {
        if (this.p != 2) goto L15;
        InteractAudienceGuestWidget r0 = this.c;
        if (r0 == null) goto L16;
        Intrinsics.checkNotNullParameter(r5, "sei");
        Intrinsics.checkNotNullParameter(r6, "info");
        InteractAudienceVideoWindowManager r1 = r0.z;
        if (r1 == null) goto L13;
        LocalTestManager.a(new Class[]{wy.a.class});
        if (r1.D == false) goto L13;
        if (r1.A == false) goto L13;
        r1.y.e(r5, r6);
    L13:
        this.H = r5;
        return;
    L16:
        return;
    }

    public final void Fq(String r3, ye1.a r4) {
        if (gd0.v.a(this.p, 8) == false) goto L13;
        kn0.b r0 = this.e;
        if (r0 == null) goto L7;
        r0.onSei(r3, r4);
        this.H = r3;
    L7:
        LinkmicSubtitleBusinessContext.a r5 = LinkmicSubtitleBusinessContext.Companion;
        if (r5.b() != null) goto L10;
        return;
    L10:
        if (r3.contains("audio_subtitle") == false) goto L15;
        r5.b().sd(r3);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void I1(int r6, boolean r7) {
        StringBuilder r0 = new StringBuilder("unLoadOtherWidget, mode=");
        r0.append(r6);
        r0.append(" currentMode=");
        r0.append(this.p);
        if (r7 == false) goto L5;
        String r1 = " pkSwitchLink=true";
    L6:
        r0.append(r1);
        ALogger.w("ttlive_link", r0.toString());
        if (jc1.k.f(IMultiLinkServiceExternal.class) != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L72;
        if (r7 == false) goto L16;
        return;
    L16:
        if (r6 != 4) goto L58;
        Lazy r3 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "LinkMultiControlWidget", "call unLoadOtherWidget mode = " + r6 + ", mCurrentMode = " + this.p);
        if (gd0.v.a(this.p, 2) == false) goto L25;
        if (this.n == false) goto L22;
        this.b = this.o.z4(0, MultiLinkOpenSource.PK_SWITCH);
    L23:
        tc0.c.h().j(Boolean.TRUE);
    L56:
        Zq();
        return;
    L22:
        this.c = this.o.z4(1, MultiLinkOpenSource.PK_SWITCH);
        goto L23
    L25:
        if (gd0.v.a(this.p, 32) == false) goto L56;
        ArrayList r8 = new ArrayList();
        r8.add(4);
        com.bytedance.android.livesdk.chatroom.viewmodel.j r9 = new com.bytedance.android.livesdk.chatroom.viewmodel.j(8, r8, 7);
        if (com.bytedance.android.live.liveinteract.api.utils.m.d() != null) goto L29;
    L33:
        Cj("unloadOtherWidget");
        if (this.n == false) goto L50;
        us1.e.c = true;
        rj0.n r10 = this.o.z4(5, MultiLinkOpenSource.PK_SWITCH);
        if ((r10 instanceof rj0.n) == false) goto L38;
        this.f = r10;
    L38:
        rj0.n r11 = this.f;
        if (r11 == null) goto L41;
        r11.setSource(MultiLinkOpenSource.PK_SWITCH);
    L41:
        this.x.f(2131253282, 2131253282, 1.0f);
        if (((IInteractService) jc1.k.f(IInteractService.class)).dynamicFromAudience() == false) goto L45;
        er();
        Wq(Boolean.valueOf(com.bytedance.android.livesdk.chatroom.paidlive.e.f(((Widget) this).dataCenter)).booleanValue());
        goto L56
    L45:
        if (com.bytedance.android.live.liveinteract.plantform.utils.s0.f(((Widget) this).dataCenter) == false) goto L48;
        Nq();
        goto L56
    L48:
        if (fr() == false) goto L56;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r12 = y3.m(((Widget) this).dataCenter);
        ToolbarButton r13 = ToolbarButton.TEAM_FIGHT;
        r12.p(r13.extended(), this.z);
        y3.m(((Widget) this).dataCenter).c(r13.extended());
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.PK.extended());
        this.f.H9(this.z);
        goto L56
    L50:
        ToolbarVideoInteractBehavior r14 = this.x;
        int r4 = ToolbarVideoInteractBehavior.F;
        r14.f(ToolbarVideoInteractBehavior.a.a(), ToolbarVideoInteractBehavior.a.a(), 1.0f);
        rj0.o r15 = this.o.z4(5, MultiLinkOpenSource.PK_SWITCH);
        if ((r15 instanceof rj0.o) == false) goto L53;
        this.g = r15;
    L53:
        rj0.o r16 = this.g;
        if (r16 == null) goto L56;
        r16.setSource(MultiLinkOpenSource.PK_SWITCH);
        this.g.Li(this.x);
        goto L56
    L29:
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene() == null) goto L33;
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene().getValue() == null) goto L33;
        ((com.bytedance.android.livesdk.chatroom.viewmodel.e) com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene().getValue()).e(r9);
        goto L33
    L58:
        if (r6 == 64) goto L60;
        return;
    L60:
        if (this.n == true) goto L65;
        if (Aq() == false) goto L65;
        br(true, "anchor linkmic finish");
        Zq();
    L65:
        if (this.n == false) goto L75;
        String r17 = us1.e.e;
        if (TextUtils.isEmpty(r17) == true) goto L76;
        DataCenter r18 = ((Widget) this).dataCenter;
        if (r18 == null) goto L77;
        r18.put("data_video_talk_dot_with_number_show", r17);
        return;
    L77:
        return;
    L76:
        return;
    L75:
        return;
    L72:
        return;
    L9:
        if (jc1.k.f(IMultiLinkServiceExternal.class).getControlServiceExternal() == null) goto L11;
        r2 = jc1.k.f(IMultiLinkServiceExternal.class).getControlServiceExternal().a();
        goto L12
    L5:
        r1 = "";
        goto L6
    }

    public final boolean Jq(int r5, boolean r6) {
        if (r6 == false) goto L8;
        if (r5 != 64) goto L8;
        if (this.p != 32) goto L8;
        return false;
    L8:
        int r7 = this.p;
        if (r7 == 2) goto L12;
        if (r7 == 32) goto L12;
    L15:
        return false;
    L12:
        if (r5 == 4) goto L16;
        if (r5 != 64) goto L15;
        return true;
    L16:
        return true;
    }

    public final void Sq(IRoom r5, String r6) {
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "LinkMultiControlWidget#" + hashCode(), "call printLinkInfoFromRoom from " + r6 + ", linkerMap = " + r5.getLinkMap() + ", linkerDetail = " + r5.getLinkerDetail());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void Zc(int r11, String r12) {
        this.k.h0(false, false, 3, false, r12, true, r11, 8, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget, gd0.k
    public final void a(View r2, MotionEvent r3) {
        rj0.o r0 = this.g;
        if (r0 == null) goto L5;
        r0.a(r2, r3);
    L5:
        rj0.n r1 = this.f;
        if (r1 == null) goto L9;
        r1.a(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void a5(int r7, boolean r8) {
        ALogger.w("ttlive_link", "switchOtherMode targetMode=" + r7 + " mCurrentMode=" + this.p + " isInclusive=" + Jq(r7, r8));
        if (Jq(r7, r8) == true) goto L6;
        K4(this.p);
    L6:
        if (this.n == false) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r9 = y3.m(((Widget) this).dataCenter);
        ToolbarButton r3 = ToolbarButton.INTERACTION;
        r9.c(r3.extended());
        if (((Boolean) g3.a.getValue()).booleanValue() == true) goto L10;
    L12:
        this.x.f(2131250849, 2131250849, 1.0f);
    L30:
        DataCenter r10 = ((Widget) this).dataCenter;
        Boolean r4 = Boolean.TRUE;
        r10.put("live_common_input_dialog_dismiss", r4);
        ((Widget) this).dataCenter.put("cmd_dismiss_digit_avatar_recogntion_mode_dialog", r4);
        if (r7 != 4) goto L68;
        if (this.n == false) goto L50;
        InteractAudienceAnchorWidget r11 = this.b;
        if (r11 == null) goto L43;
        this.p = 2 | this.p;
        if (r11.isEngineOn() == true) goto L39;
    L41:
        this.o.k(this.b);
        this.b = null;
        goto L43
    L39:
        if (((com.bytedance.android.live.liveinteract.service.f) ((IInteractService) jc1.k.f(IInteractService.class)).getInteractAudienceService()).P() == true) goto L41;
        InteractAudienceAnchorWidget r12 = this.b;
        r12.v = true;
        r12.yq().M0();
    L43:
        if (this.f == null) goto L49;
        ((IInteractService) jc1.k.f(IInteractService.class)).getVideoTalkService().t();
        this.p |= 32;
        boolean r13 = ((IMultiPkAudienceLinkOutService) jc1.k.f(IMultiPkAudienceLinkOutService.class)).isRealHasAudienceBeforePk();
        if (this.f.isEngineOn() == false) goto L48;
        if (r13 == true) goto L48;
        this.f.Q();
    L48:
        Hm("switchOtherMode");
        this.o.k(this.f.getWidget());
        this.f = null;
    L49:
        this.x.f(2131251167, 2131251168, 1.0f);
    L88:
        Rq(r7);
        return;
    L50:
        Widget r14 = this.c;
        if (r14 == null) goto L53;
    L61:
        if (r14 == null) goto L63;
        this.p |= 2;
        this.o.k(r14);
        this.c = null;
    L65:
        if (vm2.d.y() == true) goto L88;
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.INTERACTION.extended());
        goto L88
    L63:
        this.p |= 32;
        Hm("switchOtherMode");
        this.o.k(this.g.getWidget());
        this.g = null;
        goto L65
    L53:
        if (this.g != null) goto L61;
        if (Aq() == false) goto L59;
        br(true, "pk widget load");
        goto L88
    L59:
        if (vm2.d.y() == true) goto L88;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION.extended());
        goto L88
    L68:
        if (r7 != 64) goto L88;
        InteractAudienceAnchorWidget r15 = this.b;
        if (r15 != null) goto L72;
    L74:
        rj0.n r16 = this.f;
        if (r16 == null) goto L83;
        if (r16.isEngineOn() == false) goto L79;
        this.f.Q();
    L79:
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L83;
        rj0.k.a.a().finishVideoTalk("switchMultiAnchorMode");
    L83:
        if (this.n == false) goto L87;
        ((Widget) this).dataCenter.put("data_video_talk_dot_with_number_show", "");
        this.x.f(2131250849, 2131250849, 0.34f);
        if (gr() == false) goto L88;
        this.y.setAlpha(0.34f);
        goto L88
    L87:
        this.x.f(2131250846, 2131250846, 0.34f);
        goto L88
    L72:
        if (r15.isEngineOn() == false) goto L74;
        InteractAudienceAnchorWidget r17 = this.b;
        r17.v = true;
        r17.yq().M0();
        goto L74
    L10:
        if (gr() == false) goto L12;
        y3.m(((Widget) this).dataCenter).i(r3.extended());
        goto L12
    L14:
        if (gd0.v.a(this.p, 2) == true) goto L20;
        if (vm2.d.y() == true) goto L18;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION.extended());
    L18:
        Bq(0);
    L24:
        if (vm2.i.f().getOpen() == false) goto L30;
        cg6.a r18 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r18 == null) goto L30;
        hg6.g r19 = r18.getRtcManager();
        if (r19 == null) goto L30;
        r19.E(false, vm2.i.f().t0());
        goto L30
    L20:
        if (vm2.d.y() == true) goto L22;
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.INTERACTION.extended());
    L22:
        ToolbarVideoInteractBehavior r20 = this.x;
        int r5 = ToolbarVideoInteractBehavior.F;
        r20.f(ToolbarVideoInteractBehavior.a.a(), ToolbarVideoInteractBehavior.a.a(), 1.0f);
        goto L24
    }

    public final void br(boolean r6, String r7) {
        if (this.n == true) goto L18;
        if (vm2.d.y() == false) goto L18;
        if (vm2.d.x() == false) goto L34;
        if (r6 == false) goto L35;
        com.bytedance.android.livesdk.chatroom.o r8 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r8 != null) goto L12;
        return;
    L12:
        if (r8.getCompactTbLoader() != null) goto L14;
        return;
    L14:
        if ((r8.getCompactTbLoader().getValue() instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) == false) goto L38;
        ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) r8.getCompactTbLoader().getValue()).refreshExistComponent(26);
        ALogger.i("LinkControlWidget", "[LinkmicIconDoubleCheck] pre linkmic refresh icon");
        return;
    L38:
        return;
    L35:
        return;
    L34:
        return;
    L18:
        if (gd0.v.a(this.p, 64) == false) goto L21;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION.extended());
        return;
    L21:
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 != null) goto L24;
    L29:
        if (r6 == false) goto L31;
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.INTERACTION.extended());
        ToolbarVideoInteractBehavior r1 = this.x;
        int r2 = ToolbarVideoInteractBehavior.F;
        r1.f(ToolbarVideoInteractBehavior.a.a(), ToolbarVideoInteractBehavior.a.a(), 1.0f);
    L32:
        ALogger.d("LinkControlWidget", "showAndienceLinkmicIcon show = " + r6 + ", from = " + r7);
        return;
    L31:
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION.extended());
        goto L32
    L24:
        if (r0.getCurrentScene() != 7) goto L26;
    L27:
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION.extended());
        return;
    L26:
        if (r0.getCurrentScene() != 2) goto L29;
        goto L27
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView
    public final void cj(String r3, boolean r4) {
        ((Widget) this).dataCenter.put(r3, Boolean.valueOf(r4));
        if (gd0.v.a(this.p, 32) == false) goto L11;
        if (TextUtils.equals(r3, "data_big_party_support_send_gift_to_linker") == false) goto L8;
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).setAllowSendToGuest(r4);
    L8:
        if (TextUtils.equals(r3, "data_video_talk_apply_need_verify") == false) goto L24;
        xs2.b.a().post(new jd0.m(r4));
        return;
    L24:
        return;
    L11:
        if (gd0.v.a(this.p, 2) == false) goto L16;
        if (TextUtils.equals(r3, "data_intimate_chat_support_send_gift_to_linker") == false) goto L26;
        boolean r5 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).setAllowSendToGuest(r4);
        return;
    L26:
        return;
    L16:
        if (gd0.v.a(this.p, 8) == true) goto L18;
        return;
    L18:
        if (TextUtils.equals(r3, "data_audio_chat_support_send_gift_to_linker") == false) goto L21;
        boolean r1 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).setAllowSendToGuest(r4);
    L21:
        if (TextUtils.equals(r3, "data_voice_talk_apply_need_verify") == false) goto L29;
        xs2.b.a().post(new jd0.n(r4));
        return;
    }

    public final void cr(DialogInterface.OnClickListener r5, DialogInterface.OnClickListener r6) {
        com.bytedance.android.livesdk.widget.x0.b r0 = new com.bytedance.android.livesdk.widget.x0.b(((Widget) this).context, 0);
        r0.a.a = 4;
        r0.l(2131917664);
        r0.setCornerRadius(2.0f);
        r0.i(0, 2131917665, r5);
        r0.i(1, 2131917663, r6);
        r0.a.k = false;
        r0.n();
    }

    public final void dr(final int r5, final com.bytedance.android.livesdk.chatroom.u r6) {
        com.bytedance.android.livesdk.widget.x0.b r0 = new com.bytedance.android.livesdk.widget.x0.b(((Widget) this).context, 0);
        r0.a.a = 4;
        r0.m(2131922655);
        r0.l(2131922654);
        r0.i(0, 2131915920, new b1(this, r5));
        r0.i(1, 2131915455, new c1(r6));
        com.bytedance.android.livesdk.widget.x0 r7 = r0.h();
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r7);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void id(int r13, String r14) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        ALogger.e("ttlive_link", "switchMode " + r13 + " " + gd0.v.a(this.p, r13) + " source=" + r14);
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "LinkMultiControlWidget#switchMode", "currentMode = " + this.p + ", targetMode = " + r13 + " " + gd0.v.a(this.p, r13) + " source=" + r14 + ", currControlWidget = " + this);
        if (gd0.v.a(this.p, r13) == false) goto L9;
        ALogger.i("ktv", "duplicate switchMode " + this.p + " target=" + r13);
        return;
    L9:
        boolean r1 = true;
        if (vm2.d.d() != 1) goto L20;
        if (r13 == 2) goto L15;
        if (r13 == 8) goto L15;
        if (r13 != 32) goto L20;
    L15:
        NewPluginType r2 = NewPluginType.LiveResource;
        if (r2.isInstalled() == true) goto L20;
        r2.checkInstall(com.bytedance.android.live.core.utils.s1.getContext(), "interact", (IHostPlugin.Callback) WeakReferenceWrapper.wrap(this.U), false);
    L20:
        if (this.n == false) goto L23;
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.INTERACTION.extended());
        this.x.f(2131250849, 2131250849, 1.0f);
    L33:
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == false) goto L36;
        Mq();
    L36:
        if (((Boolean) ib0.a.getValue()).booleanValue() == true) goto L38;
    L48:
        this.p |= r13;
        if (((Widget) this).dataCenter == null) goto L51;
        ((Widget) this).dataCenter.put("data_link_state", Integer.valueOf(jc1.k.f(IMultiLinkServiceExternal.class).getControlServiceExternal().getCurrentMode() | this.p));
    L51:
        r.b("switch", "target: " + r13 + " ,current:" + this.p);
        int r3 = jc1.k.f(IMultiLinkServiceExternal.class).getControlServiceExternal().getCurrentMode();
        if (gd0.v.a(r3, 4) == true) goto L54;
        jc1.k.f(IMultiLinkServiceExternal.class).getControlServiceExternal().b(r13);
    L54:
        if (r13 != 2) goto L74;
        if (this.n == false) goto L61;
        if (gd0.v.a(r3, 4) == true) goto L68;
        xs2.b.a().post(new zg1.j(1));
        this.b = this.o.z4(0, r14);
    L68:
        if (this.n == false) goto L71;
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.INTERACTION.extended());
    L208:
        Rq(r13);
        if (this.n == true) goto L220;
        MultiLinkSeiIndicator r15 = this.N;
        if (r15.a.b() == false) goto L221;
        r15.g = r13;
        r15.k = System.currentTimeMillis();
        Disposable r4 = r15.b;
        if (r4 == null) goto L216;
        r4.dispose();
    L216:
        r15.b = Observable.just(0).delay(r15.a.a(), TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new z2(r15, r13));
        return;
    L221:
        return;
    L220:
        return;
    L71:
        if (vm2.d.y() == true) goto L208;
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.INTERACTION.extended());
        goto L208
    L61:
        if (gd0.v.a(r3, 4) == true) goto L64;
        xs2.b.a().post(new zg1.j(1));
        this.c = this.o.z4(1, r14);
    L64:
        if (W1() == false) goto L66;
        this.x.f(2131251092, 2131251092, 1.0f);
        goto L68
    L66:
        ToolbarVideoInteractBehavior r16 = this.x;
        int r5 = ToolbarVideoInteractBehavior.F;
        r16.f(ToolbarVideoInteractBehavior.a.a(), ToolbarVideoInteractBehavior.a.a(), 1.0f);
        goto L68
    L74:
        if (r13 != 8) goto L137;
        Cj(r14);
        if (this.n == false) goto L94;
        kn0.a r6 = this.o.z4(3, r14);
        ALogger.e("ttlive_link", "anchor, targetMode == MODE_IN_ROOM_AUDIO_INTERACT, widget = " + r6);
        if ((r6 instanceof kn0.a) == false) goto L80;
        this.d = r6;
    L80:
        kn0.a r7 = this.d;
        if (r7 == null) goto L84;
        r7.i2(r14);
    L84:
        if (Kq() == false) goto L87;
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.PK.extended());
        y3.m(((Widget) this).dataCenter).f(ToolbarButton.INTERACTION_SCENE.extended(), this.y);
    L87:
        if (this.n == true) goto L89;
    L91:
        r1 = false;
    L92:
        if (r1 == false) goto L126;
        y3.m(((Widget) this).dataCenter).p(ToolbarButton.TEAM_FIGHT.extended(), this.z);
        y3.m(((Widget) this).dataCenter).f(ToolbarButton.INTERACTION_SCENE.extended(), this.y);
    L126:
        ALogger.i("ttlive_link", "load voice chat widget");
        Bq(this.p);
        if (this.n == false) goto L130;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION.extended());
    L133:
        if (gr() == false) goto L208;
        if (Kq() == true) goto L208;
        y3.m(((Widget) this).dataCenter).p(ToolbarButton.INTERACTION_SCENE.extended(), this.y);
        goto L208
    L130:
        if (vm2.d.y() == true) goto L133;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION.extended());
        goto L133
    L89:
        if (vm2.d.D() == false) goto L91;
    L94:
        kn0.b r8 = this.o.z4(3, r14);
        ALogger.e("ttlive_link", "guest, targetMode == MODE_IN_ROOM_AUDIO_INTERACT, widget = " + r8);
        if ((r8 instanceof kn0.b) == false) goto L97;
        this.e = r8;
    L97:
        kn0.b r9 = this.e;
        if (r9 == null) goto L100;
        r9.i2(r14);
    L100:
        LinkMultiControlPresenter r17 = this.k;
        if (r17 == null) goto L126;
        if (r17.l == false) goto L126;
        com.bytedance.android.livesdk.chatroom.u r18 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r18 != null) goto L107;
    L125:
        this.k.l = false;
        goto L126
    L107:
        if (r18.s() == null) goto L125;
        if (r18.s().getValue() == null) goto L125;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) r18.s().getValue()).t() == null) goto L125;
        int r10 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r18.s().getValue()).t().a;
        int r19 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r18.s().getValue()).t().b;
        if (r10 != 5) goto L119;
        if (Kq() == false) goto L117;
        com.bytedance.android.live.core.utils.f2.b(2131919301, 0);
        goto L125
    L117:
        com.bytedance.android.live.core.utils.f2.b(2131919303, 0);
        goto L125
    L119:
        if (r10 != 9) goto L125;
        if (r19 != 61) goto L123;
        com.bytedance.android.live.core.utils.f2.b(2131919302, 0);
        goto L125
    L123:
        if (r19 != 0) goto L125;
        com.bytedance.android.live.core.utils.f2.b(2131919304, 0);
        goto L125
    L137:
        if (r13 != 32) goto L202;
        if (com.bytedance.android.live.liveinteract.api.utils.m.i() == null) goto L153;
        if (com.bytedance.android.live.liveinteract.api.utils.m.i().isVSRoom() == null) goto L153;
        if (com.bytedance.android.live.liveinteract.api.utils.m.i().isVSRoom().booleanValue() == false) goto L153;
        if (com.bytedance.android.live.liveinteract.api.utils.m.i().isVSVerticalStream() == null) goto L153;
        if (com.bytedance.android.live.liveinteract.api.utils.m.i().isVSVerticalStream().booleanValue() == true) goto L153;
        if (((Boolean) vm2.d.x5.getValue(null, vm2.d.a[333(0x14d, float:4.67E-43)])).booleanValue() == true) goto L153;
        this.x.dv(new pp1.m(8));
        return;
    L153:
        if (r14.equals(MultiLinkOpenSource.FAST_INIT_MODE) == true) goto L157;
        if (r14.equals(MultiLinkOpenSource.SYNC_ROOM) == true) goto L157;
    L163:
        r1 = false;
    L164:
        boolean r11 = gd0.v.a(r3, 4);
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "LinkMultiControlWidget", "switchMode targetMode == MODE_VIDEO_TALK, source = " + r14 + ", revCurrentMode = " + r3 + ", mCurrentMode = " + this.p + ", linkMap = " + this.l.getLinkMap() + ", containPKWhenAttach = " + r1 + ", revCurrentModeContainPK = " + r11);
        if (r11 == true) goto L191;
        if (r1 == true) goto L191;
        o6("big_party", this.n);
        Cj(r14);
        if (this.n == false) goto L177;
        rj0.n r12 = this.o.z4(5, r14);
        if ((r12 instanceof rj0.n) == false) goto L173;
        this.f = r12;
    L173:
        rj0.n r20 = this.f;
        if (r20 == null) goto L176;
        r20.setSource(r14);
    L176:
        this.x.f(2131253282, 2131253282, 1.0f);
        Pq();
    L187:
        if (vm2.d.y() == true) goto L189;
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.INTERACTION.extended());
    L189:
        Zq();
        goto L208
    L177:
        ToolbarVideoInteractBehavior r21 = this.x;
        int r22 = ToolbarVideoInteractBehavior.F;
        r21.f(ToolbarVideoInteractBehavior.a.a(), ToolbarVideoInteractBehavior.a.a(), 1.0f);
        rj0.o r23 = this.o.z4(5, r14);
        if ((r23 instanceof rj0.o) == false) goto L180;
        this.g = r23;
    L180:
        rj0.o r24 = this.g;
        if (r24 == null) goto L183;
        r24.setSource(r14);
        this.g.Li(this.x);
    L183:
        VideoTalkLinkIntegrationWidget r110 = this.h;
        if (r110 == null) goto L187;
        r110.xq();
    L191:
        if (this.n == false) goto L196;
        if (jc1.k.f(IMultiPkAudienceLinkOutService.class) == null) goto L196;
        ((IMultiPkAudienceLinkOutService) jc1.k.f(IMultiPkAudienceLinkOutService.class)).showInviteAndPermitDialog();
    L196:
        if (this.n == false) goto L198;
        return;
    L198:
        if (vm2.d.y() == true) goto L219;
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.INTERACTION.extended());
        return;
    L219:
        return;
    L157:
        if (MultiLinkLoadWidgetUtils.f() == false) goto L163;
        if (this.l.getLinkMap() == null) goto L163;
        if (this.l.getLinkMap().containsKey(String.valueOf(1)) == false) goto L163;
    L202:
        if (this.n == false) goto L205;
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.INTERACTION.extended());
        this.x.f(2131250849, 2131250849, 1.0f);
        goto L208
    L205:
        if (vm2.d.y() == true) goto L207;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION.extended());
    L207:
        Bq(0);
        goto L208
    L38:
        if (((Widget) this).dataCenter == null) goto L48;
        IRoom r25 = this.l;
        if (r25 == null) goto L48;
        if (r25.getLinkerDetail() == null) goto L48;
        if (this.l.getLinkerDetail().getPlayModes() == null) goto L48;
        if (this.l.getLinkerDetail().getPlayModes().size() <= 0) goto L48;
        ((Widget) this).dataCenter.put("key_order_song_first_load", Boolean.valueOf(this.l.getLinkerDetail().getPlayModes().contains(19L)));
        goto L48
    L23:
        if (gd0.v.a(this.p, 2) == true) goto L29;
        if (vm2.d.y() == true) goto L27;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.INTERACTION.extended());
    L27:
        Bq(0);
        goto L33
    L29:
        if (vm2.d.y() == true) goto L31;
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.INTERACTION.extended());
    L31:
        ToolbarVideoInteractBehavior r26 = this.x;
        int r27 = ToolbarVideoInteractBehavior.F;
        r26.f(ToolbarVideoInteractBehavior.a.a(), ToolbarVideoInteractBehavior.a.a(), 1.0f);
        goto L33
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void initAndTurnOnRadioLinkmicRoom(Runnable r2, Runnable r3) {
        LinkMultiControlPresenter r0 = this.k;
        if (r0 == null) goto L6;
        r0.s0(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget, gd0.k
    public final void k(String r4, ye1.a r5) {
        if (this.n == false) goto L5;
        return;
    L5:
        this.N.c(r4);
        if (TextUtils.equals(r4, this.H) == true) goto L8;
    L10:
        Eq(r4, r5);
        if (r5.a == true) goto L13;
    L14:
        Fq(r4, r5);
    L16:
        if (r5.a == false) goto L20;
        if (MultiLinkBizBackupSeiExperimentUtils.INSTANCE.isVideoTalkRoomEnable(this.l, this.n) == true) goto L20;
    L24:
        BackupSeiDebugInfoGuestWidget r0 = this.t;
        if (r0 == null) goto L30;
        Intrinsics.checkNotNullParameter(r4, "sei");
        Intrinsics.checkNotNullParameter(r5, "info");
        TextView r6 = r0.h;
        if (r6 == null) goto L31;
        r6.setText("cdn-backup ptsDiff: " + r5.f + ", \nisFromBackup = " + r5.a + ", seiSource = " + r5.b);
        return;
    L31:
        return;
    L30:
        return;
    L20:
        if (gd0.v.a(this.p, 32) == false) goto L24;
        rj0.o r1 = this.g;
        if (r1 == null) goto L24;
        r1.onSei(r4, r5);
        this.H = r4;
        goto L24
    L13:
        if (MultiLinkBizBackupSeiExperimentUtils.INSTANCE.isVoiceTalkRoomEnable(this.l, this.n) == false) goto L16;
    L8:
        if (((Boolean) vm2.d.R3.getValue(null, vm2.d.a[249(0xf9, float:3.49E-43)])).booleanValue() == false) goto L10;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void o6(String r3, boolean r4) {
        HashMap r0 = new HashMap();
        r0.put("mode", r3);
        String r1 = "0";
        r0.put("stream_mix_on_client", "0");
        if (r4 == false) goto L5;
    L6:
        r1 = "1";
    L7:
        r0.put("is_in", r1);
        jc1.k.f(IPerformanceManager.class).onModuleStart("link_mic", r0);
        return;
    L5:
        if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() != 2) goto L7;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void permitPrepareApply(long r11, final String r13) {
        final LinkMultiControlPresenter r0 = this.k;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.s == true) goto L10;
        r0.s = true;
        final long r1 = System.currentTimeMillis();
        ((ObservableSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).permitPreApply(r11, d5.c(r13), r13).as(r0.e0())).subscribe(new o0(r0, r13, r1), new p0(r0, r13, r1));
        return;
    }

    public final boolean qa(Runnable r6, boolean r7) {
        boolean r0 = this.n;
        if (r0 == true) goto L8;
        rj0.o r1 = this.g;
        if (r1 == null) goto L8;
        boolean r8 = r1.interceptCloseRoom(r6, r7);
        zq(r8);
        return r8;
    L8:
        boolean r2 = false;
        if (r0 == true) goto L28;
        InteractAudienceGuestWidget r3 = this.c;
        if (r3 == null) goto L28;
        Intrinsics.checkNotNullParameter(r6, "runnable");
        Integer r9 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r9 != null) goto L16;
    L35:
        zq(r2);
        return r2;
    L16:
        if (2 != r9.intValue()) goto L35;
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() != null) goto L20;
    L22:
        DataCenter r10 = ((Widget) r3).dataCenter;
        if (r10 != null) goto L25;
    L27:
        com.bytedance.android.livesdk.widget.x0.b r11 = new com.bytedance.android.livesdk.widget.x0.b(r3.getContext(), 4);
        r11.l(2131919394);
        r11.i(0, 2131920806, new com.bytedance.android.live.liveinteract.interact.audience.c(r3, r6));
        r11.i(1, 2131915442, com.bytedance.android.live.liveinteract.interact.audience.d.a);
        r11.n();
        r2 = true;
        goto L35
    L25:
        if (((Boolean) r10.get("cmd_mic_room_jump", Boolean.FALSE)).booleanValue() == false) goto L27;
        r3.Q = true;
        goto L35
    L20:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a().W1() == false) goto L22;
        r3.Q = true;
    L28:
        if (r0 == true) goto L32;
        kn0.b r4 = this.e;
        if (r4 == null) goto L32;
        r2 = r4.interceptCloseRoom(r6, r7);
    L32:
        rj0.o r5 = this.g;
        if (r5 == null) goto L35;
        r2 = r5.interceptCloseRoom(r6, r7);
        goto L35
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView
    public final void wu(int r3, String r4) {
        tc0.c.h().j(Boolean.TRUE);
        id(r3, r4);
        if (this.n == true) goto L5;
        return;
    L5:
        if (r3 == 2) goto L7;
        return;
    L7:
        if (((Boolean) vm2.d.u5.getValue(null, vm2.d.a[330(0x14a, float:4.62E-43)])).booleanValue() == false) goto L9;
        return;
    L9:
        if (MultiLinkOpenSource.INIT_V2.equals(r4) == false) goto L15;
        xs2.b.a().post(new zg1.a1(19));
        DataCenter r5 = ((Widget) this).dataCenter;
        int r6 = LinkDialog.v;
        xq(new LinkDialog.a(r5, this).b(15), ((Widget) this).context.getSupportFragmentManager());
        return;
    }

    /* JADX WARN: Type inference failed for: r2v23, types: [com.bytedance.android.live.multilink.impl.k1] */
    public LinkMultiControlWidget(BaseLinkMultiControlWidget.a r4, ViewGroup r5, Boolean r6) {
        this.p = 0;
        this.q = false;
        this.r = null;
        this.t = null;
        this.w = ((com.bytedance.android.live.liveinteract.service.r) ((IInteractService) jc1.k.f(IInteractService.class)).getMultiLinkToolbarService()).a;
        this.x = ((com.bytedance.android.live.liveinteract.service.r) ((IInteractService) jc1.k.f(IInteractService.class)).getMultiLinkToolbarService()).b;
        this.y = new ToolbarInteractSceneBehavior(this);
        this.z = new com.bytedance.android.live.liveinteract.voicechat.toolbar.e();
        this.A = new ToolbarMultiSceneGamePlayBehavior();
        new ToolbarRoomBattleBehavior();
        this.D = new CompositeDisposable();
        this.I = false;
        this.J = true;
        this.K = false;
        this.L = null;
        this.M = new CompositeDisposable();
        this.N = new MultiLinkSeiIndicator();
        this.O = BehaviorSubject.createDefault(Boolean.FALSE);
        this.P = new a();
        this.Q = new k1(this);
        this.S = null;
        this.T = false;
        this.U = new d();
        this.o = r4;
        this.r = r5;
        this.q = r6.booleanValue();
    }

    @Override // com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter.IView
    public final void Gl(int r2, List<Integer> r3, int r4) {
        this.L = new com.bytedance.android.live.liveinteract.chatroom.chatroom.model.c(r2, r4, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void fastMatchJump(long r11, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "requestId");
        Intrinsics.checkNotNullParameter(r14, "matchType");
        Bundle r0 = new Bundle();
        String r1 = ChatMatchWidget.o;
        ChatMatchViewModel r2 = (ChatMatchViewModel) com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class);
        com.bytedance.android.livesdk.log.filter.o r3 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        Integer r4 = null;
        if (r3 == null) goto L7;
        Map r5 = r3.getMap();
        if (r5 == null) goto L7;
        String r6 = (String) r5.get("enter_from_merge");
    L9:
        if (((Boolean) b6.k0.getValue()).booleanValue() == false) goto L11;
        ChatMatchWidget.p = true;
    L32:
        if (r2 == null) goto L36;
        MutableLiveData<Integer> r7 = r2.getMatchType();
        if (r7 == null) goto L36;
        r4 = (Integer) r7.getValue();
    L36:
        if (r4 != null) goto L39;
    L41:
        String r8 = ChatMatchViewModel.ENTER_METHOD_MATCH;
    L42:
        r0.putString("match_type", r14);
        r0.putString("enter_from_merge", "live_detail");
        r0.putString("enter_method", r8);
        r0.putString("request_id", r13);
        if (je0.d.r() == false) goto L46;
        r6 = "live_take_end";
    L46:
        r0.putString("previous_page", r6);
        JumpToOtherRoomEvent r15 = new JumpToOtherRoomEvent(r11, "live_detail", r0);
        r15.source = "sourceJumpToOtherChatMatchVm";
        xs2.b.a().post(r15);
        IKtvService r16 = jc1.k.f(IKtvService.class);
        if (r16 == null) goto L56;
        r16.moveOrderedSongToOtherRoom(r11);
        return;
    L56:
        return;
    L39:
        if (r4.intValue() != 1) goto L41;
        r8 = ChatMatchViewModel.ENTER_METHOD_SHAKE;
        goto L42
    L11:
        String r9 = jc1.k.n(IMiddlewareUserService.class).user().n();
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r10 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r10 == null) goto L14;
        Iterable r12 = r10.getOnlineUserList();
    L15:
        if (r12 == null) goto L28;
        Iterator r17 = r12.iterator();
    L18:
        if (r17.hasNext() == false) goto L28;
        ILinkPlayerInfoBridge r18 = (ILinkPlayerInfoBridge) r17.next();
        if (r18.getUser() == null) goto L18;
        IBaseUser r19 = r18.getUser();
        if (r19 == null) goto L24;
        String r20 = r19.getIdString();
    L26:
        if (Intrinsics.areEqual(r20, r9) == false) goto L18;
        boolean r21 = true;
    L29:
        if (r21 == false) goto L31;
        String r22 = ChatMatchWidget.o;
        ChatMatchWidget.p = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter().b5(jc1.k.n(IMiddlewareUserService.class).user().n());
        goto L32
    L31:
        ChatMatchWidget.p = true;
        goto L32
    L24:
        r20 = null;
    L28:
        r21 = false;
        goto L29
    L14:
        r12 = null;
    L7:
        r6 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void getUserWaitingInfo(final String r13, final int r14, final com.bytedance.android.live.liveinteract.plantform.base.i.c r15) {
        final LinkMultiControlPresenter r1 = this.k;
        if (r1 == null) goto L6;
        final long r8 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).getUserWaitingInfo(r1.i.getId(), r13, r14).as(r1.e0())).subscribe(new s(r13, r14, r8, r15), new d0(r1, r13, r14, r8, r15));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void prepareInvite(long r4, IBaseUser r6, String r7) {
        if (this.k == null) goto L7;
        if (r6 == null) goto L8;
        TalkRoomLogUtils.C("anchor", r6.getIdString(), r7, -1);
        this.k.F0(r4, r6, r7);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void updateLinkMicStatus(ih0.f r26, ih0.h r27, IJsBridgeManager r28) {
        if (r26 != null) goto L5;
        return;
    L5:
        if (r26.d == null) goto L180;
        String r4 = null;
        if (r26.getType() != DynamicUpdateType.SELECT_MULTI_LINK_MODE) goto L19;
        int r0 = r26.d.get("mode").getAsInt();
        ALogger.d("LinkControlWidget", "updateLinkMicStatus: mode: " + r0);
        if (r0 == 5) goto L18;
        if (r0 == 1) goto L18;
        RadioStageContext.a r1 = RadioStageContext.Companion;
        if (r1.a() == null) goto L18;
        if (r1.a().Oj() == false) goto L18;
        r1.a().Xn(new f(this, r0));
        return;
    L18:
        VoiceInteractSceneUtil.a.i(r0, ((Widget) this).context.getSupportFragmentManager(), ((Widget) this).context, null);
    L172:
        RadioStageContext.a r2 = RadioStageContext.Companion;
        if (r2.a() == null) goto L179;
        r2.a().updateLinkMicStatus(r26, r27, r28);
        return;
    L179:
        return;
    L19:
        int r10 = 0;
        if (r26.getType() != DynamicUpdateType.PREPARE_APPLY) goto L71;
        if (this.l.isLiveTypeAudio() == false) goto L34;
        String r3 = r26.d.get("action_type").getAsString();
        ALogger.d("LinkControlWidget", "updateLinkMicStatus: actionType: " + r3);
        if ("accept_success".equals(r3) == false) goto L27;
        initAndTurnOnRadioLinkmicRoom(null, null);
        VoiceInteractSceneUtil r5 = VoiceInteractSceneUtil.a;
        JSONObject r6 = new JSONObject();
        r6.put("eventName", "select_mode_panel_close_event");
        jc1.k.n(IBaseBrowserService.class).sendEventToAllJsBridges("H5_webcastNotification", r6);
        VoiceInteractSceneUtil.e("audio_audience");
        goto L172
    L27:
        if ("prepare_apply".equals(r3) == false) goto L30;
        this.k.n0(((Widget) this).context, this.l, null);
        goto L172
    L30:
        if ("cancel_prepare_apply".equals(r3) == false) goto L172;
        final LinkMultiControlPresenter r7 = this.k;
        IRoom r8 = this.l;
        r7.getClass();
        if (r8 == null) goto L172;
        r7.g.add(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).prepareApplyCancel(r8.getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new k0(r7), new l0()));
        goto L172
    L34:
        int r9 = com.bytedance.android.live.liveinteract.videotalk.utils.u.a;
        JsonObject r11 = r26.d;
        if (r11 == null) goto L172;
        JsonElement r12 = r11.get("action_type");
        if (r12 == null) goto L40;
        r4 = r12.getAsString();
    L40:
        long r13 = 0;
        if (Intrinsics.areEqual(r4, "accept_success") == false) goto L52;
        JsonElement r14 = r11.get("start_time");
        if (r14 == null) goto L45;
        r13 = r14.getAsLong();
    L45:
        JsonElement r15 = r11.get("user_id");
        if (r15 == null) goto L49;
        String r16 = r15.getAsString();
        if (r16 == null) goto L49;
    L50:
        ALogger.i("VideoRoomPreApplyUtil", "dynamicHandlePrepareApply suc duration: " + (System.currentTimeMillis() - r13) + ", userId:" + r16);
        HashMap r17 = new HashMap();
        r17.put("live_type", "video_live");
        r17.put("applicant_id", r16);
        r17.put("source", "pre_apply");
        r17.put("function_type", "new_audience");
        r17.put("function_type2", "new_audience");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_pass", r17, new Object[]{IRoom.class});
        xs2.b.a().post(new com.bytedance.android.live.liveinteract.d(4));
        com.bytedance.android.live.liveinteract.api.utils.n.m(r16, System.currentTimeMillis() - r13);
    L49:
        r16 = "";
        goto L50
    L52:
        if (Intrinsics.areEqual(r4, "accept_failure") == false) goto L172;
        JsonElement r18 = r11.get("start_time");
        if (r18 == null) goto L56;
        r13 = r18.getAsLong();
    L56:
        JsonElement r19 = r11.get("user_id");
        if (r19 == null) goto L60;
        String r20 = r19.getAsString();
        if (r20 == null) goto L60;
    L61:
        JsonElement r21 = r11.get("err_code");
        if (r21 == null) goto L64;
        r10 = r21.getAsInt();
    L64:
        JsonElement r22 = r11.get("err_msg");
        if (r22 == null) goto L68;
        String r23 = r22.getAsString();
        if (r23 == null) goto L68;
    L69:
        ALogger.i("VideoRoomPreApplyUtil", "dynamicHandlePrepareApply fail userId: " + r20 + ", errCode:" + r10);
        ApiServerException r24 = new ApiServerException(r10);
        r24.setErrorMsg(r23);
        com.bytedance.android.live.liveinteract.api.utils.n.n(r20, r24, System.currentTimeMillis() - r13);
    L68:
        r23 = "";
    L60:
        r20 = "";
        goto L61
    L71:
        if (r26.getType() != DynamicUpdateType.SELECT_MULTI_LINK_MODE_VIDEO) goto L142;
        JsonElement r25 = r26.d.get("scene");
        JsonElement r29 = r26.d.get("ui_layout");
        JsonElement r30 = r26.d.get("source");
        int r31 = r25.getAsInt();
        int r32 = r29.getAsInt();
        String r33 = r30.getAsString();
        ALogger.d("LinkControlWidget", "updateLinkMicStatus: scene: " + r31 + ";uiLayout:" + r32 + ";source:" + r33);
        com.bytedance.android.live.liveinteract.videotalk.utils.o r34 = new com.bytedance.android.live.liveinteract.videotalk.utils.o(((Widget) this).dataCenter, ((Widget) this).context, this.l, r31, r32, this);
        Intrinsics.checkNotNullParameter(r33, "source");
        if (je0.d.L() == false) goto L77;
        IKtvService r35 = jc1.k.f(IKtvService.class);
        if (r35 == null) goto L172;
        r35.enableVideoChorus(new jd2.g(false, false, r34.g, r34.h, r33, new com.bytedance.android.live.liveinteract.videotalk.utils.t(r34), null, 134));
        goto L172
    L77:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r36 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.o1(r33);
        if (r34.g != 8) goto L116;
        if (r34.a == true) goto L172;
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_double_click", new HashMap(), new Object[]{am2.x.class, IRoom.class});
        IMultiLinkServiceExternal r37 = jc1.k.f(IMultiLinkServiceExternal.class);
        Intrinsics.checkNotNull(r37);
        if (r37.getPkServiceExternal().isMatching() == true) goto L85;
    L87:
        String r38 = "live_room";
        if (((Boolean) ((ge1.a) tc0.c.h()).b).booleanValue() == true) goto L107;
        boolean r39 = us1.e.a;
        if (us1.e.a(r34.f) == false) goto L96;
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L94;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().Zc(r34.h, "right_away");
    L94:
        int r40 = jf0.b.a;
        jf0.b.e("live_room", true);
        goto L172
    L96:
        if (((Boolean) o30.a.getValue()).booleanValue() == false) goto L104;
        boolean r41 = tb1.d.a;
        if (((Boolean) xe.a.getValue()).booleanValue() == false) goto L100;
    L102:
        r38 = "right_away";
    L114:
        int r42 = jf0.b.a;
        jf0.b.e(r38, false);
        goto L172
    L100:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L102;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().Zc(r34.h, "right_away");
        goto L102
    L104:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L114;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().Zc(r34.h, "live_room");
        r34.a = true;
        goto L114
    L107:
        if (((Boolean) o30.a.getValue()).booleanValue() == false) goto L111;
        boolean r43 = tb1.d.a;
        DataCenter r44 = r34.d;
        LifecycleOwner r45 = r34.i;
        int r46 = LinkDialog.v;
        LinkDialog r47 = new LinkDialog.a(r44, r45).a();
        r47.e = InteractAudienceContainerFragmentV2.aa0(r47, r34.d);
        FragmentActivity r48 = r34.e;
        if ((r48 instanceof FragmentActivity) == false) goto L114;
        com.bytedance.android.live.liveinteract.videotalk.utils.o.a(r47, r48.getSupportFragmentManager());
        goto L114
    L111:
        DataCenter r49 = r34.d;
        LifecycleOwner r50 = r34.i;
        int r51 = LinkDialog.v;
        LinkDialog r52 = new LinkDialog.a(r49, r50).a();
        r52.e = InteractAudienceContainerFragment.aa0(r52, r34.d);
        FragmentActivity r53 = r34.e;
        if ((r53 instanceof FragmentActivity) == false) goto L114;
        com.bytedance.android.live.liveinteract.videotalk.utils.o.a(r52, r53.getSupportFragmentManager());
        goto L114
    L85:
        if (us1.b.a() == true) goto L87;
        com.bytedance.android.live.core.utils.f2.c(us1.b.b(), 0);
        goto L172
    L116:
        if (((Boolean) ff0.a.getValue()).booleanValue() == true) goto L121;
        int r54 = com.bytedance.android.live.liveinteract.plantform.utils.v0.a;
        if (com.bytedance.android.live.liveinteract.plantform.utils.v0.a(r34.d) == true) goto L172;
    L121:
        if (r34.a == true) goto L172;
        HashMap r55 = new HashMap();
        r55.put("live_type", "video_live");
        r55.put("function_type", "radio");
        com.bytedance.android.livesdk.log.j0 r56 = com.bytedance.android.livesdk.log.j0.l();
        am2.x r57 = new am2.x();
        r57.b = "live_detail";
        r57.a = "live";
        r57.e = "click";
        boolean r58 = true;
        r56.sendLog("anchor_audience_connection_open", r55, new Object[]{r57, IRoom.class});
        DataCenter r59 = r34.d;
        if (r59 == null) goto L126;
        int r60 = ((Number) r59.get("data_link_state", 0)).intValue();
    L127:
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a() == null) goto L132;
        com.bytedance.android.live.liveinteract.plantform.base.d r61 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        Intrinsics.checkNotNull(r61);
        if (r61.getLinkUserCenter() == null) goto L132;
        com.bytedance.android.live.liveinteract.plantform.base.d r62 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        Intrinsics.checkNotNull(r62);
        int r63 = r62.getLinkUserCenter().b();
    L134:
        if (gd0.v.a(r60, 2) == false) goto L137;
        if (r63 <= 0) goto L137;
        com.bytedance.android.livesdk.widget.j0.a r65 = new com.bytedance.android.livesdk.widget.j0.a(r34.e);
        r65.a = r34.e.getResources().getString(2131917551);
        r65.a(r34.e.getResources().getString(2131917550), com.bytedance.android.live.liveinteract.videotalk.utils.m.a);
        r65.b(r34.e.getResources().getString(2131917552), new com.bytedance.android.live.liveinteract.videotalk.utils.n(r34));
        r65.c();
    L138:
        if (r58 == true) goto L172;
        r34.b();
    L137:
        r58 = false;
    L132:
        r63 = 0;
        goto L134
    L126:
        r60 = 0;
        goto L127
    L142:
        if (r26.getType() != DynamicUpdateType.SWITCH_SCENE) goto L172;
        int r66 = r26.d.get("scene").getAsInt();
        int r67 = r26.d.get("ui_layout").getAsInt();
        String r68 = r26.d.get("source").getAsString();
        boolean r69 = r26.d.get("disable_auto_show_dialog").getAsBoolean();     // Catch: Exception -> L146
    L147:
        ALogger.d("LinkControlWidget", "updateLinkMicStatus, scene: " + r66 + " uiLayout: " + r67 + " source: " + r68 + " disableAutoShowDialog: " + r69);
        int r70 = com.bytedance.android.live.liveinteract.voicechat.util.j.a;
        Intrinsics.checkNotNullParameter(r68, "source");
        IInteractService r71 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r71 == null) goto L150;
        int r72 = r71.getCurrentScene();
    L151:
        IInteractService r73 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r73 == null) goto L154;
        int r110 = r73.getCurrentUiLayout();
    L155:
        if (r72 != r66) goto L158;
        if (r110 != r67) goto L158;
        com.bytedance.android.live.liveinteract.voicechat.util.j.b(r72, r110);
    L158:
        if (r72 != 0) goto L171;
        if (r66 == 5) goto L161;
    L165:
        if (r66 != 8) goto L167;
    L168:
        IInteractService r111 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r111 == null) goto L172;
        r111.initAndTurnOnVideoLinkmicRoom(new com.bytedance.android.live.liveinteract.voicechat.util.h(r66, r67, r69), new com.bytedance.android.live.liveinteract.voicechat.util.i(r72, r110), r66, r67, r68);
        goto L172
    L167:
        if (r66 != 12) goto L172;
    L161:
        if (r67 != 29) goto L165;
        IInteractService r74 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r74 == null) goto L165;
        r74.initAndTurnOnRadioLinkmicRoom(new com.bytedance.android.live.liveinteract.voicechat.util.f(r66, r67), new com.bytedance.android.live.liveinteract.voicechat.util.g(r72, r110));
        goto L165
    L171:
        com.bytedance.android.live.liveinteract.voicechat.util.j.a(r72, r110);
        goto L172
    L154:
        r110 = 0;
        goto L155
    L150:
        r72 = 0;
    L146:
        r69 = false;
        goto L147
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void updateViewInLiveBg(String r2, JsonObject r3, ih0.h r4) {
        this.S.b(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void yg(int r8, int r9, List<Integer> r10) {
        boolean r1 = false;
        if (this.n == false) goto L20;
        com.bytedance.android.livesdk.chatroom.u r0 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = null;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j r2 = r0.getVideoTalkRoomSubScene();
    L8:
        if (r2 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r2.getValue();
    L11:
        if (r4 == null) goto L13;
        r3 = r4.b();
    L13:
        if (r3 != null) goto L15;
    L17:
        boolean r5 = false;
    L18:
        if (r5 == false) goto L20;
        Pq();
        goto L20
    L15:
        if (r3.c != 63) goto L17;
        r5 = true;
        goto L18
    L10:
        r4 = null;
        goto L11
    L7:
        r2 = null;
    L20:
        int r6 = us1.f.a;
        Intrinsics.checkNotNullParameter(r10, "playModes");
        if (r8 != 8) goto L24;
        if (r9 != 7) goto L24;
    L39:
        boolean r11 = false;
    L40:
        if (r11 == false) goto L54;
        if (this.n == false) goto L54;
        if (((IInteractService) jc1.k.f(IInteractService.class)).dynamicFromAudience() == false) goto L46;
    L47:
        er();
        ((IInteractService) jc1.k.f(IInteractService.class)).setDynamicFromAudience(false);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r12 = y3.m(((Widget) this).dataCenter);
        ToolbarButton r7 = ToolbarButton.PK;
        r12.i(r7.extended());
        if (com.bytedance.android.live.liveinteract.plantform.utils.s0.f(((Widget) this).dataCenter) == false) goto L51;
        Nq();
        goto L54
    L51:
        if (fr() == false) goto L54;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r13 = y3.m(((Widget) this).dataCenter);
        ToolbarButton r14 = ToolbarButton.TEAM_FIGHT;
        r13.p(r14.extended(), this.z);
        y3.m(((Widget) this).dataCenter).c(r14.extended());
        y3.m(((Widget) this).dataCenter).i(r7.extended());
        this.f.H9(this.z);
        goto L54
    L46:
        if (com.bytedance.android.live.liveinteract.plantform.utils.s0.h(((Widget) this).dataCenter) == true) goto L47;
    L54:
        if (this.n == true) goto L56;
        return;
    L56:
        if (((IInteractService) jc1.k.f(IInteractService.class)).dynamicFromAudience() == true) goto L58;
        return;
    L58:
        if (com.bytedance.android.live.liveinteract.plantform.utils.s0.d(((Widget) this).dataCenter) == true) goto L75;
        er();
        if (r8 == 12) goto L62;
    L64:
        if (r1 == false) goto L71;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r15 = y3.m(((Widget) this).dataCenter);
        ToolbarButton r16 = ToolbarButton.PK;
        r15.i(r16.extended());
        if (com.bytedance.android.live.liveinteract.plantform.utils.s0.e(((Widget) this).dataCenter) == false) goto L69;
        Nq();
        return;
    L69:
        if (fr() == false) goto L77;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r17 = y3.m(((Widget) this).dataCenter);
        ToolbarButton r18 = ToolbarButton.TEAM_FIGHT;
        r17.p(r18.extended(), this.z);
        y3.m(((Widget) this).dataCenter).c(r18.extended());
        y3.m(((Widget) this).dataCenter).i(r16.extended());
        this.f.H9(this.z);
        return;
    L77:
        return;
    L71:
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.PK.extended());
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.TEAM_FIGHT.extended());
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.MULTI_SCENE_GAME_PLAY.extended());
        return;
    L62:
        if (r9 != 4) goto L64;
        r1 = true;
        goto L64
    L75:
        return;
    L24:
        if (r8 == 12) goto L26;
        if (r8 != 8) goto L39;
        if (r9 == 1) goto L38;
        if (r9 == 7) goto L38;
        if (r9 == 8) goto L38;
        if (r9 == 102) goto L38;
        if (r9 != 103) goto L39;
    L38:
        r11 = true;
        goto L40
    L26:
        if (r9 == 5) goto L38;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r10) == false) goto L39;
        goto L39
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void ld(int r2, int r3, int r4, String r5) {
        kn0.a r0 = this.d;
        if (r0 == null) goto L6;
        r0.vh(r2, r3, r4, r5);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void oa(String r10, int r11, int r12, DialogInterface.OnDismissListener r13) {
        if (((Widget) this).isViewValid == true) goto L6;
        return;
    L6:
        if (com.bytedance.android.live.liveinteract.component.b.a() == null) goto L11;
        com.bytedance.android.live.liveinteract.component.b.a().C70(((Widget) this).context, ((Widget) this).dataCenter, r12, r10, r11, this.l, this);
        if (r13 == null) goto L12;
        com.bytedance.android.live.liveinteract.component.b.a().setOnDismissListener(r13);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void ua(long r7, String r9, int r10, String r11) {
        LinkMultiControlPresenter r0 = this.k;
        if (r0 == null) goto L6;
        r0.o0(r7, r9, r10, r11);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void v7(boolean r14, int r15, int r16, String r17) {
        if (r14 == false) goto L7;
        LinkMultiControlPresenter r1 = this.k;
        if (r1 == null) goto L48;
        r1.i0(false, false, 0, false, "", false, r16, r15, 0, null, null);
        return;
    L48:
        return;
    L7:
        int r2 = a3.a;
        boolean r3 = true;
        if (ThemedCompetitionContext.Companion.g() == false) goto L11;
        com.bytedance.android.live.core.utils.f2.b(2131922725, 0);
    L39:
        if (r3 == false) goto L41;
        return;
    L41:
        rj0.n r4 = this.f;
        if (r4 == null) goto L44;
        r4.T1(r15, Integer.valueOf(r16), r17);
        return;
    L44:
        rj0.o r5 = this.g;
        if (r5 == null) goto L51;
        r5.j1(r15, Integer.valueOf(r16), r17, Boolean.FALSE);
        return;
    L51:
        return;
    L11:
        rj0.k.m2.getClass();
        rj0.k r6 = rj0.k.a.a();
        if (r6 != null) goto L14;
    L16:
        com.bytedance.live.datacontext.j r7 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r7 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r8 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r7.getValue();
        if (r8 == null) goto L22;
        r8.t();
    L22:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.d() == false) goto L24;
        com.bytedance.android.live.core.utils.f2.b(2131922722, 0);
        goto L39
    L24:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r9 = MultiRevenueDataContext.a.d();
        if (r9 != null) goto L27;
    L29:
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == false) goto L33;
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.B(2131914600), 0);
        goto L39
    L33:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.B() == false) goto L36;
        com.bytedance.android.live.core.utils.f2.b(2131922795, 0);
        goto L39
    L36:
        if (LinkRoomFightContext.Companion.c() == false) goto L38;
        com.bytedance.android.live.core.utils.f2.b(2131918756, 0);
        goto L39
    L38:
        r3 = false;
        goto L39
    L27:
        if (r9.n(r16) == true) goto L29;
    L14:
        if (r6.isLinkCasting() != true) goto L16;
        com.bytedance.android.live.core.utils.f2.b(2131922724, 0);
        goto L39
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void initAndTurnOnVideoLinkmicRoom(Runnable r14, Runnable r15, int r16, int r17, String r18) {
        LinkMultiControlPresenter r1 = this.k;
        if (r1 == null) goto L6;
        r1.i0(false, false, 0, false, "", false, r17, r16, 0, r14, r15);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.g
    public final void y6(boolean r14, int r15, int r16, int r17, String r18, int r19) {
        if (r14 == false) goto L8;
        LinkMultiControlPresenter r3 = this.k;
        if (r3 == null) goto L11;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) r3).c.put("data_voice_chat_room_shoot_way", "switch_layout");
        r3.h0(true, false, 0, false, "", false, r17, 5, r19);
        return;
    L11:
        return;
    L8:
        if (this.d == null) goto L13;
        ((Widget) this).dataCenter.put("data_voice_chat_room_shoot_way", "switch_layout");
        this.d.vh(r15, r16, r17, r18);
        return;
    }
}
