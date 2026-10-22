package com.bytedance.android.live.multilink.voicechat.impl.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.f3;
import com.bytedance.android.live.core.setting.k6;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationContext;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.CPositionInviteType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.CPositionReplyType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.CPositionToEnlargePosition;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.customizestream.CustomizeStreamWidget;
import com.bytedance.android.live.liveinteract.floatwindow.applywindow.LinkmicApplyFloatWindowManager;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarWidget;
import com.bytedance.android.live.liveinteract.hamlet.HamletInterceptTouchFrameLayout;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongWidget;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog;
import com.bytedance.android.live.liveinteract.linkpanel.vm.AdminInviteAndApplyViewModel;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.VoiceCommonLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm.VoiceCommonMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.context.MultiLinkDynamicContext;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSVoiceWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.LinkerBaseInfo;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.model.p0;
import com.bytedance.android.live.liveinteract.plantform.model.r0;
import com.bytedance.android.live.liveinteract.plantform.spatial.SpatialAudioStrategyManager;
import com.bytedance.android.live.liveinteract.plantform.utils.PublicStreamClientMixStrategy;
import com.bytedance.android.live.liveinteract.plantform.utils.PublicStreamPlayState;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.liveinteract.plantform.utils.m0;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.MultiLinkLinkRoomFightWindowManager;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.spatial.SpatialAudioContext;
import com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.utils.t0;
import com.bytedance.android.live.liveinteract.utils.v0;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionWidget;
import com.bytedance.android.live.liveinteract.videotalk.dialog.CPositionBeInvitedDialog;
import com.bytedance.android.live.liveinteract.videotalk.dialog.CPositionBeSetDialog;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractWidget;
import com.bytedance.android.live.liveinteract.view.RadioTextBoardView;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatGlobalDataContext;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatGuestDataContext;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.live.liveinteract.voicechat.emoji.VoiceChatInteractEmojiPanel;
import com.bytedance.android.live.liveinteract.voicechat.interactacting.InteractActingWidget;
import com.bytedance.android.live.liveinteract.voicechat.match.view.ChatMatchDialog;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.voicechat.stage.AudioChatStageWidget;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessContext;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget;
import com.bytedance.android.live.liveinteract.widget.widget.ChatRoomGuestAppliedDialog;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.liveinteract.wrdspreload.MultiLinkWRDSPreloadManager;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.b1;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.q2;
import com.bytedance.android.livesdk.chatroom.model.y0;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdk.config.ib0;
import com.bytedance.android.livesdk.config.nm;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.d9;
import com.bytedance.android.livesdk.message.model.f6;
import com.bytedance.android.livesdk.message.model.g6;
import com.bytedance.android.livesdk.multilink.base.model.ReplyType;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerEnlargeUpdateContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerEnlargeUpdateContentKt;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfigKt;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.backupsei.MultiLinkBizBackupSeiExperimentUtils;
import com.bytedance.android.livesdkapi.multilink.IMultiLinkWRDSPreloadService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.bizlink.api.business.anchor2guest.base.BizLinkServiceType;
import com.bytedance.live.bizlink.api.platform.rtc.rtcinfo.MultiLinkInfoType;
import com.bytedance.live.bizlink.impl.platform.manager.MultiLinkGuestManager;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import hh1.w0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import w20.xc;
import zg1.a1;
import zg1.i1;
import zg1.p2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u00020\u00072\u00020\b2\u00020\u00072\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e:\u0001\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/multilink/voicechat/impl/widget/MultiLinkVoiceChatRoomGuestWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/voicelink/MultiLinkVoiceBaseGuestLinkWidget;", "Lcom/bytedance/android/live/multilink/voicechat/impl/widget/MultiLinkVoiceChatGuestPresenter$IView;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Lcom/bytedance/android/live/liveinteract/voicechat/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "", "Lcom/bytedance/android/live/liveinteract/voicechat/IVoiceChatGuestService;", "Lkk0/f;", "Lwn0/a$c;", "Lkk0/h;", "Lmd0/a$a;", "Lmd0/a$c;", "Lcom/bytedance/android/live/liveinteract/voicechat/e;", "a", "multilink-voicechat-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkVoiceChatRoomGuestWidget extends MultiLinkVoiceBaseGuestLinkWidget implements MultiLinkVoiceChatGuestPresenter.IView, WeakHandler.IHandler, com.bytedance.android.live.liveinteract.voicechat.a, Observer<KVData>, IVoiceChatGuestService, kk0.f, wn0.a.c, kk0.h, md0.a.InterfaceC0236a, md0.a.c, com.bytedance.android.live.liveinteract.voicechat.e {
    public static final /* synthetic */ int e3 = 0;
    public List<Integer> E2;
    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u F2;
    public int G1;
    public final k G2;
    public WeakHandler H0;
    public com.bytedance.android.livesdk.chatroom.viewmodel.i H1;
    public CPositionWidget H2;
    public QuickInteractWidget I2;
    public InteractiveSongWidget J2;
    public CustomizeStreamWidget K2;
    public Runnable L0;
    public boolean L1;
    public Widget L2;
    public InteractLiveCorePermissionGuarantor M1;
    public HamletAvatarWidget M2;
    public RTSVoiceWidget N2;
    public LinkmicSubtitleBusinessWidget O2;
    public boolean P0;
    public MuteStateChecker P1;
    public InteractActingWidget P2;
    public InteractAnimationController Q1;
    public AudioChatStageWidget Q2;
    public MiddlewareRoomWidget R2;
    public com.bytedance.android.live.liveinteract.utils.g0 S1;
    public final com.bytedance.android.live.liveinteract.utils.k0 S2;
    public final cj0.l T1;
    public final ArrayList<ILinkPlayerInfoBridge> T2;
    public final ArrayList<ILinkPlayerInfoBridge> U2;
    public boolean V;
    public long V0;
    public final cj0.e V1;
    public View V2;
    public boolean W;
    public final j W2;
    public MultiLinkVoiceChatGuestPresenter X;
    public boolean X2;
    public wn0.a Y;
    public final o Y2;
    public tf0.o Z;
    public j50.a Z2;
    public k50.c a3;
    public long b1;
    public int b2;
    public final Lazy b3;
    public final w0 c3;
    public final gd0.p d3;
    public long g1;
    public CPositionBeInvitedDialog g2;
    public long h1;
    public com.bytedance.android.live.liveinteract.videotalk.utils.a h2;
    public final com.bytedance.android.live.liveinteract.api.utils.j k0;
    public long k1;
    public com.bytedance.android.live.liveinteract.plantform.core.h p0;
    public long p1;
    public oe0.b p2;
    public SeiAppData v1;
    public String v2;
    public List<Integer> x1;
    public com.bytedance.android.live.liveinteract.plantform.utils.u x2;
    public ClientUIInfo y1;
    public CPositionBeSetDialog y2;

    public static final class a {
    }

    public static final class a0<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public a0(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            o42.g r4 = (o42.g) r3;
            MultiLinkVoiceChatRoomGuestWidget r0 = this.a;
            int r1 = MultiLinkVoiceChatRoomGuestWidget.e3;
            r0.getClass();
            if (r4 == null) goto L5;
            IBaseUser r2 = r4.a;
        L6:
            if (r2 == null) goto L10;
            r0.v2 = r4.b;
            ((Widget) r0).dataCenter.put("cmd_audio_talk_invite", r4.a);
            return;
        L10:
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Ref.ObjectRef a;
        public final /* synthetic */ long b;

        public b(Ref.ObjectRef r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = (String) this.a.element;
            long r2 = this.b;
            String r6 = ((com.bytedance.android.live.network.response.e) r5).logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.q(r1, r2, r6);
        }
    }

    public static final class b0<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public b0(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            pv0.c r7 = (pv0.c) r6;
            MultiLinkVoiceChatRoomGuestWidget r0 = this.a;
            int r1 = MultiLinkVoiceChatRoomGuestWidget.e3;
            r0.getClass();
            if (r7 == null) goto L6;
            String r8 = r7.a;
            if (r8 == null) goto L6;
        L8:
            if (r2.a(r8) == false) goto L23;
            LiveSeiUtil.i.getClass();
            if (LiveSeiUtil.e(r8) == false) goto L24;
            int r2 = v0.a;
            Intrinsics.checkNotNullParameter(r8, "json");
            boolean r3 = false;
            if (StringsKt.contains$default(r8, "audio_live_text_data", false, 2, null) == true) goto L14;
        L20:
            if (r3 == false) goto L25;
            r0.onRadioTextSeiUpdate(LiveSeiUtil.c(r8));
            return;
        L25:
            return;
        L14:
            if (StringsKt.contains$default(r8, "row", false, 2, null) == false) goto L20;
            if (StringsKt.contains$default(r8, "type", false, 2, null) == false) goto L20;
            if (StringsKt.contains$default(r8, "show_id", false, 2, null) == false) goto L20;
            r3 = true;
            goto L20
        L24:
            return;
        L23:
            return;
        L6:
            r8 = "";
            goto L8
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ long c;

        public c(MultiLinkVoiceChatRoomGuestWidget r1, Ref.ObjectRef r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            ApiServerException r6 = (Throwable) r5;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = (String) this.b.element;
            long r2 = this.c;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.o(r1, r2, r6);
            if ((r6 instanceof ApiServerException) == false) goto L13;
            ApiServerException r3 = r6;
            String r4 = r3.getPrompt();
            if (r4 != null) goto L7;
        L10:
            boolean r7 = true;
        L11:
            if (r7 == true) goto L13;
            f2.c(r3.getPrompt(), 0);
            return;
        L7:
            if (r4.length() == 0) goto L10;
            r7 = false;
        L13:
            ExceptionUtils.handleException(((Widget) this.a).context, r6);
        }
    }

    public static final class c0<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;

        public c0(String r1, boolean r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            boolean r2 = this.b;
            long r3 = this.c;
            String r7 = ((com.bytedance.android.live.network.response.e) r6).logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.w(r1, r2, r3, r7);
            int r8 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            com.bytedance.android.live.liveinteract.plantform.utils.x.E(this.a, this.b, null);
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ rj0.c c;

        public d(MultiLinkVoiceChatRoomGuestWidget r1, int r2, rj0.c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "dialog");
            yf6.b r11 = this.a.Yq();
            if (r11 == null) goto L5;
            r11.k(new wf6.b("leave_normally", this.b, false, false, this.c, 44));
        L5:
            r9.dismiss();
        }
    }

    public static final class d0<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;

        public d0(String r1, boolean r2, long r3, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r6) {
            ApiServerException r7 = (Throwable) r6;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            boolean r2 = this.b;
            long r3 = this.c;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.u(r1, r2, r3, r7);
            if ((r7 instanceof ApiServerException) == false) goto L7;
            ApiServerException r4 = r7;
            if (TextUtils.isEmpty(r4.getPrompt()) == true) goto L7;
            f2.c(r4.getPrompt(), 0);
        L8:
            jy0.b.b("ttlive_link_video", "主咖邀请回复失败。accept=" + this.b + "  roomId=" + this.d + "  toUid=" + this.a, r7);
            return;
        L7:
            f2.b(2131922756, 0);
            goto L8
        }
    }

    public static final class e implements DialogInterface.OnClickListener {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public static final class e0<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;

        public e0(String r1, boolean r2, long r3, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r9) {
            com.bytedance.android.live.network.response.e r10 = (com.bytedance.android.live.network.response.e) r9;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            boolean r2 = this.b;
            long r3 = this.c;
            long r5 = this.d;
            String r7 = r10.logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.t(r1, r2, r3, r5, r7);
            DATA r4 = r10.data;
            if (r4 == 0) goto L8;
            Intrinsics.checkNotNull(r4);
            if (TextUtils.isEmpty(((y0) r4).getPrompts()) == true) goto L9;
            DATA r11 = r10.data;
            Intrinsics.checkNotNull(r11);
            f2.c(((y0) r11).getPrompts(), 0);
            return;
        L9:
            return;
        }
    }

    public static final class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ rj0.c c;

        public f(MultiLinkVoiceChatRoomGuestWidget r1, int r2, rj0.c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r8, int r9) {
            Intrinsics.checkNotNullParameter(r8, "dialog");
            r8.dismiss();
            yf6.b r10 = this.a.Yq();
            if (r10 == null) goto L6;
            boolean r4 = this.a.J;
            r10.k(new wf6.b("leave_normally", this.b, false, r4, this.c, 36));
            return;
        }
    }

    public static final class f0<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;

        public f0(String r1, boolean r2, long r3, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r8) {
            ApiServerException r9 = (Throwable) r8;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            boolean r2 = this.b;
            long r3 = this.c;
            long r5 = this.d;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.r(r1, r2, r3, r5, r9);
            if ((r9 instanceof ApiServerException) == false) goto L8;
            ApiServerException r4 = r9;
            if (TextUtils.isEmpty(r4.getPrompt()) == true) goto L8;
            f2.c(r4.getPrompt(), 0);
        L13:
            if (this.b == false) goto L15;
            String r6 = "设为主咖";
        L16:
            jy0.b.b("ttlive_link_video", r6, r9);
            return;
        L15:
            r6 = "取消主咖失败。 roomId = $roomId, toUid = $toUid ";
        L8:
            if (this.b == false) goto L10;
            int r7 = 2131922759;
        L11:
            f2.b(r7, 0);
            goto L13
        L10:
            r7 = 2131922761;
            goto L11
        }
    }

    public static final class g implements DialogInterface.OnClickListener {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public static final class g0 implements DialogInterface.OnClickListener {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public g0(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "dialog");
            r3.dismiss();
            yf6.b r5 = this.a.Yq();
            if (r5 == null) goto L6;
            r5.e(new wf6.a(null, 3));
            return;
        }
    }

    public static final class h implements DialogInterface.OnClickListener {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;
        public final /* synthetic */ Runnable b;

        public h(MultiLinkVoiceChatRoomGuestWidget r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "dialog");
            jy0.b.d("voice_chat", "interceptCloseRoom");
            r2.dismiss();
            MultiLinkVoiceChatRoomGuestWidget r4 = this.a;
            r4.L0 = this.b;
            cg6.a r5 = r4.Bq();
            if (r5 == null) goto L7;
            MultiLinkGuestManager r6 = r5.W4();
            if (r6 == null) goto L7;
            r6.f("leave_normally", true);
        L7:
            hd0.c.f().h.removeObservers(this.a);
        }
    }

    public static final class h0 implements DialogInterface.OnClickListener {
        public static final h0 a = null;

        static {
            a = new h0();
        }

        public h0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public static final class i implements DialogInterface.OnClickListener {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public static final class i0 implements DialogInterface.OnDismissListener {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public i0(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            this.a.L1 = false;
        }
    }

    public static final class j implements View.OnLayoutChangeListener {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public j(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            if (this.a.isViewValid() == true) goto L5;
            return;
        L5:
            tf0.o r10 = this.a.Z;
            if (r10 == null) goto L9;
            r10.y(r1.getWidth(), r1.getHeight());
            return;
        }
    }

    public static final class j0 implements DialogInterface.OnDismissListener {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public j0(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            this.a.L1 = false;
        }
    }

    public static final class k extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public k(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void onOnlineListChanged(List<? extends ILinkPlayerInfoBridge> r4) {
            Intrinsics.checkNotNullParameter(r4, "list");
            this.a.T2.clear();
            this.a.T2.addAll(r4);
            com.bytedance.android.live.liveinteract.plantform.utils.t.a(r4);
            ArrayList r0 = new ArrayList(r4);
            ((Widget) this.a).dataCenter.put("data_online_changed_list", r0);
            bn0.b r1 = this.a.getMultiLinkRoomScope();
            if (r1 == null) goto L10;
            jn0.b r2 = jn0.c.a(r1);
            if (r2 == null) goto L10;
            BehaviorSubject<List<ILinkPlayerInfoBridge>> r3 = r2.Xh();
            if (r3 == null) goto L10;
            r3.onNext(r0);
        L10:
            if (this.a.br() == 16) goto L13;
            com.bytedance.android.livesdk.chatroom.utils.g0.e(r4.size());
        L13:
            if (r4.size() <= tc0.c.h().d) goto L15;
            tc0.c r5 = tc0.c.h();
            r5.d = r4.size();
        L15:
            this.a.V1.k(r4);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void d(List<? extends ILinkPlayerInfoBridge> r3, List<? extends ILinkPlayerInfoBridge> r4) {
            Intrinsics.checkNotNullParameter(r3, "list");
            Intrinsics.checkNotNullParameter(r4, "peerList");
            this.a.U2.clear();
            this.a.U2.addAll(r4);
            com.bytedance.android.livesdk.chatroom.utils.g0.e(r3.size() + r4.size());
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void n(List<ILinkPlayerInfoBridge> r2, long r3, n0 r5) {
            if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L18;
            String r4 = "";
            if (Lists.isEmpty(r2) == false) goto L7;
            ((Widget) this.a).dataCenter.put("data_audio_talk_dot_with_number_show", "");
            return;
        L7:
            MultiLinkVoiceChatRoomGuestWidget r6 = this.a;
            int r7 = MultiLinkVoiceChatRoomGuestWidget.e3;
            int r8 = ((ArrayList) r6.Aq().V4()).size();
            if (r8 > 99) goto L10;
            r8 = r8 + fj0.e.a();
        L10:
            String r0 = String.valueOf(r8);
            if (r8 <= 99) goto L13;
            r0 = "99+";
        L13:
            if (r8 <= 0) goto L16;
            r4 = r0;
        L16:
            ((Widget) this.a).dataCenter.put("data_audio_talk_dot_with_number_show", r4);
            return;
        }
    }

    public static final class k0<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public k0(String r1, long r2, long r4, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r6;
        }

        public final void accept(Object r9) {
            com.bytedance.android.live.network.response.e r10 = (com.bytedance.android.live.network.response.e) r9;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            long r3 = this.b;
            long r5 = this.c;
            String r7 = r10.logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.t(r1, true, r3, r5, r7);
            DATA r2 = r10.data;
            if (r2 == 0) goto L8;
            Intrinsics.checkNotNull(r2);
            if (TextUtils.isEmpty(((y0) r2).getPrompts()) == true) goto L8;
            DATA r11 = r10.data;
            Intrinsics.checkNotNull(r11);
            f2.c(((y0) r11).getPrompts(), 0);
            return;
        L8:
            if ((!Intrinsics.areEqual(this.a, je0.d.b0())) == true) goto L10;
            return;
        L10:
            if (TextUtils.equals(this.d, "add") == false) goto L12;
            f2.b(2131922754, 0);
            return;
        L12:
            f2.b(2131922715, 0);
        }
    }

    public static final class l implements com.bytedance.android.live.liveinteract.widget.widget.a {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        @Override // com.bytedance.android.live.liveinteract.widget.widget.a
        public final void show() {
            MultiLinkVoiceChatRoomGuestWidget r0 = this.a;
            tf0.o r1 = r0.Z;
            if ((r1 instanceof VoiceCommonMultiLinkWindowManager) == true) goto L5;
            r1 = null;
        L5:
            VoiceCommonMultiLinkWindowManager r2 = (VoiceCommonMultiLinkWindowManager) r1;
            if (r2 == null) goto L9;
            r2.q1(true, r0.getMRoom());
            return;
        }

        public l(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }
    }

    public static final class l0<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        public l0(String r1, long r2, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r8) {
            ApiServerException r9 = (Throwable) r8;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            long r3 = this.b;
            long r5 = this.c;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.r(r1, true, r3, r5, r9);
            if ((r9 instanceof ApiServerException) == false) goto L13;
            ApiServerException r10 = r9;
            String r2 = r10.getPrompt();
            if (r2 != null) goto L7;
        L10:
            boolean r4 = true;
        L11:
            if (r4 == true) goto L13;
            f2.c(r10.getPrompt(), 0);
            return;
        L7:
            if (r2.length() == 0) goto L10;
            r4 = false;
        L13:
            f2.b(2131922759, 0);
        }
    }

    public static final class m<T> implements Comparator<T> {
        public m() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((Number) r1).intValue()), Integer.valueOf(((Number) r2).intValue()));
        }
    }

    public static final class n implements Runnable {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;
        public final /* synthetic */ SeiAppData b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ClientUIInfo d;
        public final /* synthetic */ Ref.ObjectRef e;

        public n(MultiLinkVoiceChatRoomGuestWidget r1, SeiAppData r2, int r3, ClientUIInfo r4, Ref.ObjectRef r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            wn0.a r1 = this.a.Y;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            wn0.a.d(r1, new zj0.c.e(this.b, this.c), this.a.x1, this.d, false, (List) this.e.element, 8);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class o implements InteractLiveCorePermissionGuarantor.a {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        @Override // com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor.a
        public final void b(boolean r1) {
        }

        public o(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor.a
        public final void a(boolean r8) {
            boolean r0 = false;
            if (r8 == false) goto L31;
            jy0.b.d("MultiLinkVoiceChatRoomGuestWidget", "onTargetPageShow");
            if (this.a.isEngineOn() == false) goto L60;
            this.a.G4(true, "on particular page show");
            int r9 = this.a.Pq().o();
            if (r9 != 0) goto L9;
        L12:
            jy0.b.d("MultiLinkVoiceChatRoomGuestWidget", "onTargetPageShow, muteSelf");
            this.a.Aq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
            this.a.Pq().k("onPause");
        L14:
            if (vm2.d.F0() == false) goto L20;
            Activity r10 = ContextUtil.contextToActivity(this.a.getContext());
            if (r10 == null) goto L20;
            if (r10.isFinishing() == true) goto L20;
            jy0.b.d("MultiLinkVoiceChatRoomGuestWidget", "onTargetPageShow, onEnterBackground");
            this.a.Aq().v();
        L20:
            this.a.getClass();
            sb6.a r11 = GuestLinkContext.Companion.a();
            if (r11 != null) goto L23;
        L25:
            if (r0 == false) goto L61;
            jy0.b.d("MultiLinkVoiceChatRoomGuestWidget", "onTargetPageShow, muteAllRemoteAudioStreams");
            MultiLinkVoiceChatRoomGuestWidget r12 = this.a;
            r12.X2 = true;
            jg6.a r13 = r12.Eq();
            if (r13 == null) goto L62;
            kg6.e r14 = r13.b();
            if (r14 == null) goto L63;
            r14.y(true, "on particular page show");
            return;
        L63:
            return;
        L62:
            return;
        L61:
            return;
        L23:
            if (r11.c != true) goto L25;
            r0 = true;
            goto L25
        L9:
            if (vm2.d.F0() == false) goto L14;
            if (r9 != 2) goto L14;
        L60:
            return;
        L31:
            jy0.b.d("MultiLinkVoiceChatRoomGuestWidget", "onTargetPageHide");
            if (this.a.isEngineOn() == false) goto L58;
            MultiLinkVoiceChatRoomGuestWidget r15 = this.a;
            if (r15.s == null) goto L58;
            WeakReference r3 = com.bytedance.android.live.core.utils.a.a;
            if (com.bytedance.android.live.core.utils.a.e(r15.getContext()) == false) goto L58;
            if (this.a.Pq().o() != 3) goto L45;
            if (vm2.d.g() == true) goto L42;
        L43:
            jy0.b.d("MultiLinkVoiceChatRoomGuestWidget", "onTargetPageHide, unMuteSelf");
            this.a.Pq().l("on particular page close");
            goto L45
        L42:
            if (com.bytedance.android.live.core.utils.a.e(this.a.getContext()) == true) goto L43;
        L45:
            if (vm2.d.F0() == false) goto L52;
            Activity r16 = ContextUtil.contextToActivity(this.a.getContext());
            if (r16 == null) goto L52;
            if (r16.isFinishing() == true) goto L52;
            jy0.b.d("MultiLinkVoiceChatRoomGuestWidget", "onTargetPageHide, onEnterForeground");
            this.a.Aq().r0();
        L52:
            if (this.a.X2 == false) goto L58;
            jy0.b.d("MultiLinkVoiceChatRoomGuestWidget", "onTargetPageHide, unMuteAllRemoteAudioStreams");
            jg6.a r17 = this.a.Eq();
            if (r17 == null) goto L58;
            kg6.e r18 = r17.b();
            if (r18 == null) goto L58;
            r18.y(false, "on particular page close");
        L58:
            this.a.X2 = false;
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public p(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            MultiLinkVoiceChatRoomGuestWidget r0 = this.a;
            boolean r4 = ((Boolean) r3).booleanValue();
            int r1 = MultiLinkVoiceChatRoomGuestWidget.e3;
            r0.tr(r4);
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public q(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Intrinsics.checkNotNullParameter((fd2.z) r3, "event");
            MultiLinkVoiceChatRoomGuestWidget r4 = this.a;
            int r0 = MultiLinkVoiceChatRoomGuestWidget.e3;
            if (com.bytedance.android.live.liveinteract.spatial.a.e(r4.C0()) == false) goto L8;
            jy0.b.a("SpatialAudio_MultiLinkVoiceChatRoomGuestWidget", "singerChanged updateSpatialAudioPosition------");
            tf0.o r1 = r4.Z;
            if (r1 == null) goto L9;
            r1.u(Boolean.valueOf(r4.isEngineOn()));
            return;
        L9:
            return;
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public r(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            hg6.g r0 = this.a.P2();
            if (r0 == null) goto L6;
            Intrinsics.checkNotNull(r3);
            r0.w(r3.booleanValue());
            return;
        }
    }

    public static final class s<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public s(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Integer r4 = (Integer) r3;
            jy0.b.a("SpatialAudio_MultiLinkVoiceChatRoomGuestWidget", "CurrentStrategyId onValueChanged " + r4);
            hg6.g r0 = this.a.P2();
            if (r0 == null) goto L6;
            r0.i(com.bytedance.android.live.liveinteract.spatial.a.e(r4.intValue()));
        L6:
            if (com.bytedance.android.live.liveinteract.spatial.a.e(r4.intValue()) == false) goto L11;
            MultiLinkVoiceChatRoomGuestWidget r5 = this.a;
            tf0.o r1 = r5.Z;
            if (r1 == null) goto L12;
            r1.u(Boolean.valueOf(r5.isEngineOn()));
            return;
        L12:
            return;
        }
    }

    public static final class t implements xb6.b {
        public t() {
        }

        public final Pair<Boolean, String> c() {
            ai0.e r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getAdventureService();
            Intrinsics.checkNotNull(r0);
            if (((ai0.c) r0).b(false) == false) goto L7;
            return new Pair(Boolean.TRUE, "adventureCall");
        L7:
            if (GuestLinkContext.Companion.b(false) == false) goto L11;
            return new Pair(Boolean.TRUE, "GuestLinkCall");
        L11:
            return new Pair(Boolean.FALSE, "");
        }

        public final Pair<Boolean, String> e() {
            ai0.e r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getAdventureService();
            Intrinsics.checkNotNull(r0);
            if (((ai0.c) r0).b(true) == false) goto L7;
            return new Pair(Boolean.TRUE, "adventureCall");
        L7:
            if (GuestLinkContext.Companion.b(true) == false) goto L11;
            return new Pair(Boolean.TRUE, "GuestLinkCall");
        L11:
            return new Pair(Boolean.FALSE, "");
        }

        public final Pair<Boolean, String> a() {
            return xb6.b.a.k();
        }

        public final Pair<Boolean, String> b() {
            return xb6.b.a.a();
        }

        public final Pair<Boolean, String> g() {
            return xb6.b.a.l();
        }

        public final Pair<Boolean, String> h() {
            return xb6.b.a.g();
        }

        public final Pair<Boolean, String> k() {
            return xb6.b.a.i();
        }

        public final Pair<Boolean, String> m() {
            return xb6.b.a.c();
        }

        public final Pair<Boolean, String> d(z0 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.f(r2);
        }

        public final Pair f(com.bytedance.android.live.liveinteract.multianchor.model.b r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.d(r2);
        }

        public final Pair<Boolean, String> j(z0 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.h(r2);
        }

        public final Pair<Boolean, String> l(h1 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.m(r2);
        }

        public final Pair<Boolean, String> i(long r1, String r3, String r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r3, "secToUserId");
            Intrinsics.checkNotNullParameter(r4, "toUserIdString");
            return xb6.b.a.j(r3, r4);
        }
    }

    public static final class u<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public u(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            IRoomLinkMicSyncData r5 = (IRoomLinkMicSyncData) r4;
            if (r5.getLinkerBaseInfo() == null) goto L14;
            MultiLinkVoiceChatRoomGuestWidget r0 = this.a;
            com.bytedance.android.live.liveinteract.plantform.model.q r6 = r5.getLinkerBaseInfo();
            if (r6 == null) goto L8;
            int r7 = r6.getAnchorManualOpenUiLayout();
        L9:
            r0.G1 = r7;
            com.bytedance.android.live.liveinteract.plantform.utils.i0 r8 = TalkRoomLogUtils.a;
            com.bytedance.android.live.liveinteract.plantform.utils.h r9 = TalkRoomLogUtils.b;
            int r1 = r9.a;
            int r2 = this.a.G1;
            if (r1 == r2) goto L13;
            TalkRoomLogUtils.s1(r2, false);
            jy0.b.d("AnchorManualUiLayout", "wrds change currentManualUiLayout=" + this.a.G1 + ", lastManualUiLayout=" + r9.b);
            return;
        L13:
            return;
        L8:
            r7 = 0;
            goto L9
        }
    }

    public static final class v<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public v(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.livesdk.chatroom.viewmodel.i r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r2;
            if (r3.a == 0) goto L6;
            this.a.H1 = r3;
            return;
        }
    }

    public static final class w<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public w(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((jd0.f) r2, "event");
            MultiLinkVoiceChatRoomGuestWidget r3 = this.a;
            if (r3.Z != null) goto L5;
            return;
        L5:
            if (r3.R == false) goto L15;
            MultiLinkVoiceChatGuestPresenter r4 = r3.X;
            if (r4 == null) goto L16;
            MultiLinkVoiceChatGuestPresenter.IView r0 = ((q46.b) r4).a;
            if (r0 != null) goto L11;
            return;
        L11:
            if (r0.s2() == null) goto L18;
            ((q46.b) r4).a.s2().Ig();
            return;
        L18:
            return;
        L16:
            return;
        }
    }

    public static final class x<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public x(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((zg1.h1) r2, "event");
            MultiLinkVoiceChatRoomGuestWidget r3 = this.a;
            int r0 = MultiLinkVoiceChatRoomGuestWidget.e3;
            r3.getClass();
        }
    }

    public static final class y<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public y(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            i1 r4 = (i1) r3;
            Intrinsics.checkNotNullParameter(r4, "event");
            tf0.o r0 = this.a.Z;
            if ((r0 instanceof VoiceCommonMultiLinkWindowManager) == true) goto L5;
            r0 = null;
        L5:
            VoiceCommonMultiLinkWindowManager r1 = (VoiceCommonMultiLinkWindowManager) r0;
            if (r1 == null) goto L9;
            r1.z1(r4.b);
            return;
        }
    }

    public static final class z<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

        public z(MultiLinkVoiceChatRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            u22.b r6 = (u22.b) r5;
            Intrinsics.checkNotNullParameter(r6, "event");
            MultiLinkVoiceChatRoomGuestWidget r0 = this.a;
            int r1 = MultiLinkVoiceChatRoomGuestWidget.e3;
            r0.getClass();
            Iterator r2 = r6.a.iterator();
        L4:
            if (r2.hasNext() == false) goto L15;
            String r3 = (String) r2.next();
            int r4 = u22.b.c;
            if (Intrinsics.areEqual("30000001", r3) == false) goto L4;
            if (r0.I == null) goto L14;
            com.bytedance.android.live.liveinteract.voicechat.util.k.F(String.valueOf(r0.getMRoom().getAnchorId()), r6.b);
            return;
        L14:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void D1(String r1, ByteBuffer r2, int r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void G2(d9 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // tf0.o.a
    public final j1 Zb() {
        return this;
    }

    @Override // tf0.o.a
    public final /* synthetic */ uf2.z.a c3(String r1) {
        return null;
    }

    @Override // tf0.o.a
    public final /* synthetic */ void ca(String r1, String r2) {
    }

    @Override // tf0.o.a
    public final /* synthetic */ void f() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f1(long r1, long r3) {
    }

    public final int getLayoutId() {
        return 2131567766;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final kk0.g getLinkMicSeatCallback() {
        return null;
    }

    @Override // tf0.o.a
    public final /* synthetic */ uf2.d0 getLiveCore() {
        return null;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    @Override // wn0.a.c
    public final void h5() {
    }

    public final void handleMsg(Message r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final boolean isAnchor() {
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final boolean isDynamicAnimating() {
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(null, 0, 7) == false) goto L8;
        ih0.b r0 = MultiLinkDynamicContext.Companion.a(((Widget) this).dataCenter, null);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isDynamicAnimating();
    L8:
        tf0.o r1 = this.Z;
        if (r1 != null) goto L11;
        return false;
    L11:
        if (r1.isDynamicAnimating() != true) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final boolean isNewWidget() {
        return true;
    }

    @Override // tf0.o.a
    public final /* synthetic */ String l6() {
        return null;
    }

    @Override // tf0.o.a
    public final void mk(String r1) {
    }

    @Override // tf0.o.a
    public final void n1(boolean r1) {
    }

    @Override // md0.a.c
    public final void onAudioMvControllerUpdate(String r1) {
    }

    @Override // md0.a.c
    public final void onAudioSubtitleUpdate(String r1) {
    }

    @Override // md0.a.InterfaceC0236a
    public final /* synthetic */ void onBusinessAppSeiUpdate(JSONObject r1) {
    }

    @Override // md0.a.c
    public final void onRadioSeiUpdate(JSONObject r1) {
    }

    @Override // md0.a.c
    public final void onVideoStateSeiUpdate(ld0.a r1) {
    }

    @Override // tf0.o.a
    public final /* synthetic */ SurfaceView q1() {
        return null;
    }

    @Override // tf0.o.a
    public final void r1(String r1, boolean r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void removePermitCallback() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.e
    public final void v1() {
        Tq(false);
    }

    @Override // tf0.o.a
    public final /* synthetic */ void v4(String r1, boolean r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void yi() {
        this.c = null;
        yf6.b r1 = Yq();
        if (r1 == null) goto L5;
        r1.f("MultiLinkVoiceChatRoomGuestWidget onEngineEndSuccess");
    L5:
        or(TalkRoomLogUtils.h);
        if (this.s == null) goto L8;
        ((Widget) this).dataCenter.put("cmd_linker_live_core_release", Boolean.TRUE);
        com.bytedance.android.live.pushstream.d r2 = this.s;
        Intrinsics.checkNotNull(r2);
        r2.release();
        this.s = null;
    L8:
        MultiLinkVoiceChatGuestPresenter r3 = this.X;
        if (r3 == null) goto L14;
        MultiLinkVoiceChatGuestPresenter.IView r4 = ((q46.b) r3).a;
        if (r4 == null) goto L14;
        r4.V1();
    L14:
        hg6.g r5 = P2();
        if (r5 == null) goto L17;
        r5.Z(this);
    L17:
        m00.h r6 = this.t;
        if (r6 == null) goto L20;
        Intrinsics.checkNotNull(r6);
        r6.release();
    L20:
        ne0.c r7 = this.v;
        if (r7 == null) goto L23;
        r7.d0(sh0.e.b, Boolean.FALSE);
    L23:
        this.t = null;
        MuteStateChecker r0 = this.P1;
        Intrinsics.checkNotNull(r0);
        r0.c = 0;
        r0.d = 0;
        this.S2.b();
        tf0.o r8 = this.Z;
        if (r8 == null) goto L26;
        r8.O();
    L26:
        com.bytedance.android.live.liveinteract.plantform.utils.u r9 = this.x2;
        if (r9 == null) goto L29;
        r9.p();
    L29:
        QuickInteractWidget r10 = this.I2;
        if (r10 == null) goto L32;
        Intrinsics.checkNotNull(r10);
        r10.xq();
    L32:
        com.bytedance.android.live.liveinteract.plantform.base.g r11 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r11 == null) goto L43;
        int r12 = br();
        if (r12 != 9) goto L38;
        String r13 = "multi_ktv";
    L41:
        r11.o6(r13, false);
        return;
    L38:
        if (r12 != 10) goto L40;
        r13 = "share_video";
        goto L41
    L40:
        r13 = "fm";
        goto L41
    }

    public static List wr() {
        return jc1.k.n(IKtvService.class).getKtvRoomCurSelfOrderList(je0.d.b0());
    }

    @Override // wn0.a.c
    public final Pair<Integer, Integer> D3() {
        ILivePlayerClient r0 = hs0.a.b.getCurrentClient();
        if (r0 == null) goto L13;
        IRoomEventHub r1 = r0.getEventHub();
        if (r1 == null) goto L13;
        MutableLiveData r2 = r1.getVideoSizeChanged();
        if (r2 == null) goto L13;
        Pair r3 = (Pair) r2.getValue();
        if (r3 == null) goto L13;
        return new Pair(r3.getFirst(), r3.getSecond());
    L13:
        return new Pair(0, 0);
    }

    @Override // wn0.a.b
    public final int Ta() {
        return this.T2.size();
    }

    @Override // com.bytedance.android.live.multilink.voicechat.impl.widget.MultiLinkVoiceChatGuestPresenter.IView
    public final void V1() {
        Runnable r0 = this.L0;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.run();
        this.L0 = null;
    L5:
        tf0.o r1 = this.Z;
        if (r1 == null) goto L9;
        r1.N();
        return;
    }

    public final long ar() {
        if (this.p1 >= 0) goto L6;
        this.p1 = (this.y - this.V0) / ((long) 1000);
    L6:
        return this.p1;
    }

    public final int br() {
        wn0.a r0 = this.Y;
        if (r0 == null) goto L7;
        zj0.f r1 = r0.c;
        if (r1 == null) goto L7;
        Integer r2 = Integer.valueOf(r1.a);
    L15:
        if (r2 != null) goto L19;
        return 0;
    L19:
        return r2.intValue();
    L7:
        com.bytedance.live.datacontext.j r3 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r3 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r3.getValue();
        if (r4 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r5 = r4.t();
        if (r5 == null) goto L14;
        r2 = Integer.valueOf(r5.a);
    L14:
        r2 = null;
        goto L15
    }

    public final int cr() {
        wn0.a r0 = this.Y;
        if (r0 == null) goto L7;
        zj0.f r1 = r0.c;
        if (r1 == null) goto L7;
        Integer r2 = Integer.valueOf(r1.b);
    L15:
        if (r2 != null) goto L19;
        return 0;
    L19:
        return r2.intValue();
    L7:
        com.bytedance.live.datacontext.j r3 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r3 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r3.getValue();
        if (r4 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r5 = r4.t();
        if (r5 == null) goto L14;
        r2 = Integer.valueOf(r5.b);
    L14:
        r2 = null;
        goto L15
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final String currentCPositionChangeTrackData() {
        MultiLinkVoiceChatGuestPresenter r0 = this.X;
        if (r0 == null) goto L6;
        String r1 = r0.g;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final int currentCPositionOpenSource() {
        MultiLinkVoiceChatGuestPresenter r0 = this.X;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.f;
    }

    @Override // tf0.o.a
    public final int dn() {
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.x2;
        if (r0 == null) goto L8;
        Integer r1 = r0.d();
        if (r1 == null) goto L8;
        return r1.intValue();
    L8:
        return PublicStreamClientMixStrategy.None.ordinal();
    }

    public final InteractLiveCorePermissionGuarantor dr() {
        if (this.M1 != null) goto L5;
        this.M1 = new InteractLiveCorePermissionGuarantor();
        InteractLiveCorePermissionGuarantor r0 = this.M1;
        Intrinsics.checkNotNull(r0);
        r0.j(this.Y2);
    L5:
        InteractLiveCorePermissionGuarantor r1 = this.M1;
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    public final String er() {
        com.bytedance.android.live.liveinteract.plantform.model.f r0 = this.H;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        Integer r1 = r0.getInviteSource();
        Intrinsics.checkNotNull(r1);
        if (r1.intValue() <= 0) goto L7;
        com.bytedance.android.live.liveinteract.plantform.model.f r2 = this.H;
        Intrinsics.checkNotNull(r2);
        Integer r3 = r2.getInviteSource();
        Intrinsics.checkNotNull(r3);
        int r4 = r3.intValue();
    L9:
        if (Intrinsics.areEqual("invite", this.E) == false) goto L12;
        if (r4 <= 0) goto L12;
        int r5 = p0.a;
        return p0.a.a(r4);
    L12:
        return null;
    L7:
        r4 = -1;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void exitRoom() {
        t0.a("MultiLinkVoiceChatRoomGuestWidget", "exitRoom");
        tf0.o r0 = this.Z;
        if (r0 == null) goto L6;
        r0.exitRoom();
        return;
    }

    public final long fr() {
        long r0 = Math.max(this.h1, this.V0);
        if (r0 != 0) goto L6;
        return 0;
    L6:
        return (System.currentTimeMillis() - r0) / ((long) 1000);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final List<ILinkPlayerInfoBridge> getCrossRoomFightLinkUserInfoList() {
        tf0.o r0 = this.Z;
        ArrayList r2 = null;
        if ((r0 instanceof MultiLinkLinkRoomFightWindowManager) == true) goto L5;
        r0 = null;
    L5:
        MultiLinkLinkRoomFightWindowManager r1 = (MultiLinkLinkRoomFightWindowManager) r0;
        if (r1 == null) goto L15;
        eh0.b r3 = r1.X;
        if (r3 == null) goto L15;
        List<ch0.e> r4 = r3.d();
        if (r4 == null) goto L15;
        List<ch0.e> r5 = r4;
        r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        r2.add(((ch0.e) r6.next()).a);
    L15:
        return r2;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final JsonObject getLinkmicAreaFrameInfo() {
        tf0.o r0 = this.Z;
        if (r0 == null) goto L8;
        sf0.b r1 = r0.getLinkmicAreaFrameInfo();
        if (r1 == null) goto L10;
        int r2 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        return com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.f(r1);
    L10:
        return null;
    L8:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final JsonObject getLinkmicSeatListInfo() {
        tf0.o r0 = this.Z;
        List<tf0.e> r1 = null;
        if (r0 == null) goto L14;
        List<tf0.e> r2 = r0.e();
        if (r2 == null) goto L14;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        if ((!(((tf0.e) r4) instanceof MultiLinkNormalEmptyViewBinder.a)) == false) goto L8;
    L13:
        tf0.e r5 = (tf0.e) r4;
    L15:
        if (r5 == null) goto L21;
        String r6 = "seat";
        nh0.e r7 = null;
        tf0.o r8 = this.Z;
        if (r8 == null) goto L20;
        r1 = r8.e();
    L20:
        return new nh0.f(r6, r7, r1, null, null, null, false, 246).b();
    L21:
        return null;
    L12:
        r4 = null;
    L14:
        r5 = null;
        goto L15
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final com.bytedance.android.live.liveinteract.voicechat.util.k getLogger() {
        com.bytedance.android.live.liveinteract.voicechat.util.k r0 = this.I;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final qj0.a getMultiLinkAudioLayoutService() {
        return (qj0.a) this.b3.getValue();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final JsonObject getTopLeftSeatFrameInfo() {
        tf0.o r0 = this.Z;
        if (r0 == null) goto L5;
        sf0.c r1 = r0.getTopLeftSeatFrameInfo();
    L6:
        if (r1 == null) goto L9;
        int r2 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        return com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.g(r1);
    L9:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public final Long gr() {
        Long r2 = null;
        com.bytedance.android.live.liveinteract.plantform.model.g0 r0 = (com.bytedance.android.live.liveinteract.plantform.model.g0) ((Widget) this).dataCenter.get("data_link_mic_pos_tag_info", null);
        if (r0 == null) goto L5;
        r2 = Long.valueOf(r0.getTagType());
    L5:
        if (r2 != null) goto L7;
    L8:
        com.bytedance.android.live.liveinteract.plantform.model.g0 r1 = this.F;
        if (r1 == null) goto L13;
        Intrinsics.checkNotNull(r1);
        return Long.valueOf(r1.getTagType());
    L13:
        return r2;
    L7:
        if (r2.longValue() == 0) goto L8;
        return r2;
    }

    public final void hr() {
        if (this.V0 == 0) goto L6;
        return;
    L6:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L14;
        int r0 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r1 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(((Widget) this).dataCenter);
        if (r1 == null) goto L12;
        Long r2 = r1.getEnterRoomTime();
        if (r2 == null) goto L12;
        long r3 = r2.longValue();
    L13:
        this.V0 = r3;
    L15:
        long r4 = this.V0;
        long r5 = TalkRoomLogUtils.y;
        long r6 = r4 - r5;
        if (r6 >= 0) goto L18;
    L20:
        r5 = r4;
    L21:
        this.b1 = r5;
        TalkRoomLogUtils.y = 0;
        long r7 = TalkRoomLogUtils.A;
        long r8 = r4 - r7;
        if (r8 >= 0) goto L24;
    L26:
        this.g1 = r4;
        TalkRoomLogUtils.A = 0;
        return;
    L24:
        if (r8 > 15000) goto L26;
        r4 = r7;
        goto L26
    L18:
        if (r6 > 15000) goto L20;
    L12:
        r3 = System.currentTimeMillis();
        goto L13
    L14:
        this.V0 = System.currentTimeMillis();
        goto L15
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final boolean isInvited() {
        return Intrinsics.areEqual("invite", this.E);
    }

    @Override // tf0.o.a
    public final int mc() {
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.x2;
        if (r0 == null) goto L8;
        Integer r1 = r0.e();
        if (r1 == null) goto L8;
        return r1.intValue();
    L8:
        return PublicStreamPlayState.None.ordinal();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final MuteStateChecker muteChecker() {
        MuteStateChecker r0 = this.P1;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.liveinteract.plantform.core.h r1 = this.p0;
        if (r1 == null) goto L16;
        hg6.g r4 = P2();
        if (r4 == null) goto L10;
        ei6.a r5 = r4.V0();
    L11:
        WeakReference<ei6.a> r3 = new WeakReference(r5);
        hh1.v0 r6 = this.c;
        if (r6 == null) goto L14;
        uf2.d0 r7 = r6.getLiveCore();
    L15:
        r1.d(r3, new WeakReference(r7));
        goto L16
    L14:
        r7 = null;
        goto L15
    L10:
        r5 = null;
    L16:
        tf0.o r2 = this.Z;
        if (r2 == null) goto L19;
        r2.L();
    L19:
        com.bytedance.android.live.liveinteract.plantform.utils.u r8 = this.x2;
        if (r8 == null) goto L23;
        r8.o();
    L23:
        if (tc0.c.h().C == true) goto L25;
    L27:
        com.bytedance.android.live.liveinteract.plantform.base.g r9 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r9 == null) goto L37;
        int r10 = br();
        if (r10 != 9) goto L33;
        String r11 = "multi_ktv";
    L36:
        r9.o6(r11, false);
        goto L37
    L33:
        if (r10 != 10) goto L35;
        r11 = "share_video";
        goto L36
    L35:
        r11 = "fm";
    L37:
        this.k1 = System.currentTimeMillis();
        String r24 = er();
        com.bytedance.android.live.liveinteract.voicechat.util.k r12 = this.I;
        if (r12 == null) goto L47;
        String r13 = this.w;
        boolean r14 = Nq();
        String r15 = this.E;
        int r16 = je0.d.j(Aq());
        isKtvOn();
        List r17 = wr();
        String r18 = this.D;
        boolean r19 = this.z;
        boolean r110 = this.A;
        ICircleInfo r111 = getMRoom().getCircleInfo();
        Long r112 = Long.valueOf((this.k1 - this.y) / ((long) 1000));
        Long r113 = Long.valueOf(ar());
        Long r114 = gr();
        LinkApplyType r20 = this.x;
        IMessageBoardInfo r21 = this.G;
        bg6.a r22 = s2();
        if (r22 == null) goto L45;
        vf6.a r23 = r22.a9();
        if (r23 == null) goto L45;
        String r25 = r23.b;
        if (r25 == null) goto L45;
    L46:
        r12.A(r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, null, null, r20, r21, r25, r24);
    L45:
        r25 = "";
    L47:
        this.A = false;
        this.C = null;
        bg6.a r26 = s2();
        if (r26 == null) goto L53;
        vf6.a r27 = r26.a9();
        if (r27 == null) goto L53;
        Intrinsics.checkNotNullParameter("0", "<set-?>");
        r27.b = "0";
    L53:
        if (this.R == true) goto L58;
        int r28 = Pq().o();
        jy0.b.d("voice_chat", "start link when background, try mute self silenceState=" + r28);
        if (r28 > 0) goto L57;
        Aq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
        Pq().k("start on background");
        G4(true, "start on background");
    L57:
        Aq().v();
    L58:
        MuteStateChecker r29 = this.P1;
        Intrinsics.checkNotNull(r29);
        r29.b();
        ne0.c r30 = this.v;
        if (r30 == null) goto L61;
        r30.d0(sh0.f.b, Boolean.FALSE);
    L61:
        String r31 = tc0.c.h().f;
        if (TextUtils.isEmpty(r31) == true) goto L64;
        this.S2.c(r31, true);
    L66:
        if (isKtvOn() == true) goto L68;
    L72:
        yf6.b r32 = Yq();
        if (r32 == null) goto L76;
        sf6.d.a.a(r32, new MultiLinkVoiceChatRoomGuestWidget$onStartSuccess$1(this));
        return;
    L76:
        return;
    L68:
        if ((!Intrinsics.areEqual(je0.d.g(), je0.d.b0())) == false) goto L72;
        if (this.s == null) goto L72;
        jy0.b.f("ttlive_link", "stopVideoCapture since not singer! false", null, 4);
        com.bytedance.android.live.liveinteract.plantform.utils.x.x(false, je0.d.g());
        goto L72
    L64:
        this.S2.b();
        goto L66
    L25:
        if (this.s == null) goto L27;
        Pq().v();
        tc0.c.h().C = false;
        goto L27
    }

    /* JADX WARN: Type inference failed for: r1v21, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.widget.widget.q, java.lang.Object] */
    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        multiLinkRoomScopeFallback();
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVoiceChatRoomGuestWidget#" + hashCode(), "call onDestroy");
        StringBuilder r1 = new StringBuilder("unregisterLivePlayerVideoSizeEvent removeListener, GuestWidget=");
        r1.append(hashCode());
        r1.append(", livePlayerParent=");
        View r2 = this.V2;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L6:
        r1.append(r3);
        jy0.b.d("MultiLinkVoiceChatRoomGuestWidget", r1.toString());
        View r4 = this.V2;
        if (r4 == null) goto L9;
        r4.removeOnLayoutChangeListener(this.W2);
    L9:
        this.V2 = null;
        if (((Boolean) vm2.d.b8.getValue(null, vm2.d.a[466(0x1d2, float:6.53E-43)])).booleanValue() == false) goto L12;
        int r5 = com.bytedance.android.live.liveinteract.videotalk.ui.b.a;
        com.bytedance.android.live.liveinteract.videotalk.ui.b.a(((Widget) this).dataCenter);
    L12:
        com.bytedance.android.live.liveinteract.plantform.core.h r6 = this.p0;
        if (r6 == null) goto L15;
        r6.b();
    L15:
        yf6.b r7 = Yq();
        if (r7 == null) goto L19;
        r7.f("MultiLinkVoiceChatRoomGuestWidget onDestroy");
    L19:
        if (vm2.e.a() == false) goto L21;
        dr().e();
    L21:
        this.V1.i();
        com.bytedance.android.live.liveinteract.linksecurity.c.n(com.bytedance.android.live.liveinteract.linksecurity.c.g);
        InteractAnimationController r8 = this.Q1;
        if (r8 == null) goto L24;
        r8.l();
    L24:
        jy0.b.a("InteractAnimationController", "before unloadAnimRenderWidget");
        MiddlewareRoomWidget r9 = this.R2;
        if (r9 == null) goto L31;
        WidgetManager r10 = ((Widget) this).subWidgetManager;
        if (r10 == null) goto L29;
        r10.unload(r9);
    L29:
        this.R2 = null;
    L31:
        if (isEngineOn() == false) goto L42;
        if (r2.a(TalkRoomLogUtils.h) == true) goto L35;
    L39:
        String r11 = TalkRoomLogUtils.j;
    L40:
        or(r11);
        fj0.e.n(false);
        fj0.b.a.b = false;
        com.bytedance.android.live.liveinteract.plantform.utils.x.j0();
        goto L42
    L35:
        if ((!Intrinsics.areEqual(TalkRoomLogUtils.h, "ktv")) == false) goto L39;
        if ((!Intrinsics.areEqual(TalkRoomLogUtils.h, "chorus")) == false) goto L39;
        r11 = TalkRoomLogUtils.h;
    L42:
        if (isKtvOn() == false) goto L47;
        if (this.I == null) goto L47;
        com.bytedance.android.live.liveinteract.voicechat.util.k.s(fr());
    L47:
        if (((Boolean) f3.a.getValue()).booleanValue() == true) goto L49;
    L80:
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r12 = com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.a;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.d("talkroom destroy");
        com.bytedance.android.livesdk.chatroom.viewmodel.i r13 = this.H1;
        if (r13 == null) goto L83;
        Integer r14 = Integer.valueOf(r13.b);
    L84:
        com.bytedance.android.livesdk.chatroom.viewmodel.i r15 = this.H1;
        if (r15 == null) goto L87;
        List r16 = r15.c;
    L88:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r17 = TalkRoomLogUtils.a;
        com.bytedance.android.live.liveinteract.plantform.utils.h r18 = TalkRoomLogUtils.b;
        String r19 = u0.i(r14, r16, Integer.valueOf(r18.a));
        com.bytedance.android.livesdk.chatroom.viewmodel.i r20 = this.H1;
        if (r20 == null) goto L91;
        Integer r110 = Integer.valueOf(r20.b);
    L92:
        com.bytedance.android.livesdk.chatroom.viewmodel.i r21 = this.H1;
        if (r21 == null) goto L95;
        Integer r111 = Integer.valueOf(r21.a);
    L96:
        com.bytedance.android.livesdk.chatroom.viewmodel.i r22 = this.H1;
        if (r22 == null) goto L99;
        List r112 = r22.c;
    L100:
        String r23 = u0.f(r110, r111, r112, Integer.valueOf(r18.a), null, null, 48);
        com.bytedance.android.livesdk.chatroom.viewmodel.i r24 = this.H1;
        if (r24 != null) goto L103;
    L105:
        String r25 = "classic";
    L106:
        com.bytedance.android.live.liveinteract.voicechat.util.k r26 = this.I;
        if (r26 == null) goto L110;
        com.bytedance.android.live.liveinteract.voicechat.util.k.w(r26, r19, r23, r25, 1);
    L110:
        if (br() == 0) goto L142;
        HashMap<String, String> r27 = new HashMap();
        if (r2.a(TalkRoomLogUtils.h) == true) goto L114;
    L118:
        String r28 = TalkRoomLogUtils.j;
    L119:
        String r113 = r28;
        if (vm2.h.R() == false) goto L122;
        r27.put("room_id", String.valueOf(getMRoom().getId()));
        r27.put("anchor_id", String.valueOf(getMRoom().getAnchorId()));
        LiveMode r29 = getMRoom().getStreamType();
        int r30 = com.bytedance.android.live.core.utils.h1.a;
        r27.put("live_type", com.bytedance.android.live.core.utils.i1.a(r29));
    L122:
        com.bytedance.android.live.liveinteract.voicechat.util.k r114 = this.I;
        if (r114 == null) goto L133;
        long r115 = fr();
        int r116 = br();
        Integer r117 = Integer.valueOf(cr());
        ICircleInfo r118 = getMRoom().getCircleInfo();
        tf0.o r31 = this.Z;
        if (r31 == null) goto L127;
        boolean r210 = r31.J();
    L128:
        int r32 = com.bytedance.android.live.liveinteract.utils.h1.a;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.d r33 = MultiRevenueDataContext.a.f();
        if (r33 == null) goto L131;
        li0.b.a r211 = r33.g4();
    L132:
        r114.q(r27, r115, r116, r117, r113, r118, r210, r211);
        goto L133
    L131:
        r211 = null;
        goto L132
    L127:
        r210 = false;
    L133:
        long r34 = Math.max(this.h1, this.b1);
        if (r34 != 0) goto L136;
        long r35 = 0;
    L137:
        TalkRoomLogUtils.p0(r27, Long.valueOf(r35));
        long r36 = Math.max(this.h1, this.g1);
        if (r36 != 0) goto L140;
        long r37 = 0;
    L141:
        TalkRoomLogUtils.q0(r27, Long.valueOf(r37));
        ((Widget) this).dataCenter.put("data_enter_room_is_quick_invite", Boolean.FALSE);
        goto L142
    L140:
        r37 = (System.currentTimeMillis() - r36) / ((long) 1000);
        goto L141
    L136:
        r35 = (System.currentTimeMillis() - r34) / ((long) 1000);
        goto L137
    L114:
        if ((!Intrinsics.areEqual(TalkRoomLogUtils.h, "ktv")) == false) goto L118;
        if ((!Intrinsics.areEqual(TalkRoomLogUtils.h, "chorus")) == false) goto L118;
        r28 = TalkRoomLogUtils.h;
    L142:
        DataCenter r38 = ((Widget) this).dataCenter;
        Boolean r39 = Boolean.FALSE;
        r38.put("data_self_is_silenced", r39);
        ((Widget) this).dataCenter.removeObserver(this);
        tc0.c.h().j(r39);
        if (this.O == null) goto L145;
        boolean r40 = true;
    L146:
        if (r40 == false) goto L148;
        Pq().n();
    L148:
        tf0.o r41 = this.Z;
        if (r41 == null) goto L151;
        r41.end();
    L151:
        cg6.a r42 = Bq();
        if (r42 == null) goto L156;
        hg6.g r43 = r42.getRtcManager();
        if (r43 == null) goto L156;
        r43.Z(this);
    L156:
        cj0.l r44 = this.T1;
        r44.getClass();
        List<com.bytedance.android.live.liveinteract.voicechat.util.b> r45 = com.bytedance.android.live.liveinteract.voicechat.util.c.a;
        com.bytedance.android.live.liveinteract.voicechat.util.c.c(r44);
        r44.c = false;
        r44.a = 0;
        r44.b = 0;
        ((ArrayList) r44.d).clear();
        MultiLinkVoiceChatGuestPresenter r46 = this.X;
        if (r46 == null) goto L159;
        r46.detachView();
    L159:
        this.S2.b();
        com.bytedance.android.live.liveinteract.utils.g0 r47 = this.S1;
        if (r47 == null) goto L162;
        Intrinsics.checkNotNull(r47);
        r47.c(br());
    L162:
        com.bytedance.android.live.liveinteract.videotalk.utils.a r48 = this.h2;
        if (r48 == null) goto L165;
        r48.c();
    L165:
        ILinkPanelService r49 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r49 == null) goto L168;
        r49.close();
    L168:
        com.bytedance.android.livesdk.common.b r50 = this.M;
        if (r50 != null) goto L171;
    L190:
        com.bytedance.android.live.liveinteract.plantform.base.g r51 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r51 == null) goto L193;
        r51.Sc();
    L193:
        tc0.c.h().F = "";
        if (vm2.d.l0() == false) goto L202;
        Widget.WidgetCallback r52 = ((Widget) this).widgetCallback;
        if (r52 == null) goto L202;
        if (r52.getWidgetManager() == null) goto L202;
        if (((Widget) this).widgetCallback.getWidgetManager().getContext() != null) goto L202;
        ((Widget) this).subWidgetManager = null;
    L202:
        super.onDestroy();
        if (br() != 16) goto L205;
        nr(br(), cr(), 0, 0, je0.d.d(), CollectionsKt.emptyList());
    L205:
        com.bytedance.live.datacontext.j r53 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r53 == null) goto L210;
        LivePlayModeLogContext r54 = (LivePlayModeLogContext) r53.getValue();
        if (r54 == null) goto L210;
        r54.clearPlayModesOnlySupportMultiPeople();
    L210:
        com.bytedance.android.livesdk.chatroom.utils.g0.a();
        com.bytedance.android.live.liveinteract.linksecurity.c.g.l();
        if (vm2.d.j0() == false) goto L222;
        WidgetManager r55 = ((Widget) this).subWidgetManager;
        if (r55 == null) goto L222;
        List r56 = r55.widgets;
        if (r56 == null) goto L222;
        if (r56.size() <= 0) goto L222;
        Iterator r57 = ((Widget) this).subWidgetManager.widgets.iterator();
    L220:
        if (r57.hasNext() == false) goto L222;
        ((Widget) this).subWidgetManager.unload((Widget) r57.next());
    L222:
        d0(sh0.d0.b, null);
        sh0.i0 r58 = sh0.j0.a;
        sh0.j0.b(((Widget) this).dataCenter);
        hg6.g r59 = P2();
        if (r59 == null) goto L226;
        r59.i(false);
    L226:
        if (vm2.d.K0() == true) goto L228;
    L232:
        com.bytedance.live.datacontext.m r60 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r60 == null) goto L239;
        IRoom r61 = (IRoom) r60.getValue();
        if (r61 == null) goto L239;
        z5 r62 = r61.getLinkerDetail();
        if (r62 == null) goto L239;
        r62.setAnchorManualUiLayout(0);
    L239:
        com.bytedance.android.live.liveinteract.plantform.utils.u r63 = this.x2;
        if (r63 == null) goto L243;
        r63.k();
    L243:
        if (((Boolean) k6.a.getValue()).booleanValue() == false) goto L254;
        ((Widget) this).widgetCallback = null;
        return;
    L254:
        return;
    L228:
        if (vm2.d.h() == false) goto L232;
        this.Z2 = null;
        k50.c r65 = this.a3;
        if (r65 == null) goto L232;
        Intrinsics.checkNotNull(r65);
        r65.b = true;
        this.a3 = null;
        goto L232
    L171:
        if (r50.isShowing() != true) goto L190;
        ?? r66 = this.M;
        Intrinsics.checkNotNull(r66);
        Handler r67 = DialogLancet.resolveDialogHandler(r66);
        if (r67 != null) goto L175;
    L177:
        DialogLancet.beforeDialogDismiss(r66);
        r66.dismiss();     // Catch: Throwable -> L180 Exception -> L182
    L187:
        DialogLancet.afterDialogDismiss(r66);
        goto L190
    L180:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r66);
        throw th;
    L182:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L180
        Throwable r68 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L180
        if (r68 == null) goto L187;
        com.bytedance.crash.d.d(r68, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L180
        goto L187
    L175:
        if (Looper.myLooper() == r67.getLooper()) goto L177;
        r67.post(DialogLancet.createDismissRunnable(r66));
        goto L190
    L145:
        r40 = false;
        goto L146
    L103:
        if (r24.b != 28) goto L105;
        r25 = "avatar";
        goto L106
    L99:
        r112 = null;
        goto L100
    L95:
        r111 = null;
        goto L96
    L91:
        r110 = null;
        goto L92
    L87:
        r16 = null;
        goto L88
    L83:
        r14 = null;
        goto L84
    L49:
        if (Fq() == false) goto L80;
        if (isEngineOn() == false) goto L80;
        String r69 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager r70 = LinkmicOnlineFloatWindowManager.c.a();
        LinkUserDataMergeContext.a r71 = LinkUserDataMergeContext.Companion;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r72 = LinkUserDataMergeContext.a.b(r71, ((Widget) this).dataCenter);
        if (r72 == null) goto L61;
        BehaviorSubject<ch0.d> r73 = r72.b1();
        if (r73 == null) goto L61;
        ch0.d r74 = (ch0.d) r73.getValue();
        if (r74 == null) goto L61;
        ch0.g r75 = r74.d;
        if (r75 == null) goto L61;
        ch0.g r76 = ch0.g.a(r75);
    L62:
        r70.E = r76;
        ((ArrayList) LinkmicOnlineFloatWindowManager.c.a().D).clear();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r77 = LinkUserDataMergeContext.a.b(r71, ((Widget) this).dataCenter);
        if (r77 == null) goto L80;
        BehaviorSubject<List<ch0.e>> r78 = r77.f();
        if (r78 == null) goto L80;
        List r79 = (List) r78.getValue();
        if (r79 == null) goto L80;
        List r80 = r79;
        ArrayList r81 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r80, 10));
        Iterator r82 = r80.iterator();
    L70:
        if (r82.hasNext() == false) goto L72;
        r81.add(((ch0.e) r82.next()).b);
        goto L70
    L72:
        Iterator r83 = r81.iterator();
    L74:
        if (r83.hasNext() == false) goto L80;
        ch0.h r119 = (ch0.h) r83.next();
        String r84 = LinkmicOnlineFloatWindowManager.Y;
        List<ch0.h> r85 = LinkmicOnlineFloatWindowManager.c.a().D;
        if (r119 == null) goto L78;
        ch0.h r86 = ch0.h.a(r119, null, false, false, false, 0, 127);
    L79:
        ((ArrayList) r85).add(r86);
        goto L74
    L78:
        r86 = null;
    L61:
        r76 = null;
        goto L62
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void onResume() {
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVoiceChatRoomGuestWidget#" + hashCode(), "call onResume");
        super.onResume();
        WeakHandler r1 = this.H0;
        Intrinsics.checkNotNull(r1);
        r1.removeCallbacksAndMessages(null);
        boolean r2 = true;
        this.R = true;
        hg6.g r3 = P2();
        if (r3 == null) goto L5;
        r3.onResume();
    L5:
        IKtvService r4 = jc1.k.f(IKtvService.class);
        if (r4 == null) goto L13;
        if (r4.isKtvComponentOpen() != true) goto L13;
        if (this.P0 == false) goto L13;
        tr(jc1.k.n(IKtvService.class).isCurrentUserIsSinger());
        this.P0 = false;
    L13:
        if (((Boolean) vm2.h.k5.getValue(null, vm2.h.a[321(0x141, float:4.5E-43)])).booleanValue() == false) goto L20;
        hg6.g r5 = P2();
        if (r5 != null) goto L17;
    L24:
        boolean r6 = false;
    L25:
        if (r6 == true) goto L27;
    L49:
        hg6.g r7 = P2();
        if (r7 == null) goto L53;
        r7.i(com.bytedance.android.live.liveinteract.spatial.a.e(C0()));
        return;
    L53:
        return;
    L27:
        if (vm2.e.a() == false) goto L29;
        dr().g();
    L29:
        Aq().r0();
        if (vm2.e.a() == false) goto L34;
        if (dr().p == false) goto L34;
    L36:
        sb6.a r8 = GuestLinkContext.Companion.a();
        if (r8 != null) goto L39;
    L41:
        r2 = false;
    L42:
        if (r2 == true) goto L48;
        jg6.a r9 = Eq();
        if (r9 == null) goto L48;
        kg6.e r10 = r9.b();
        if (r10 == null) goto L48;
        r10.y(false, "onResume");
    L48:
        ((Widget) this).dataCenter.put("cmd_interact_state_change", new a1(3));
        goto L49
    L39:
        if (r8.c != true) goto L41;
    L34:
        if (Pq().o() != 3) goto L36;
        Pq().l("onResume");
        goto L36
    L17:
        if (r5.A() != true) goto L24;
    L23:
        r6 = true;
        goto L25
    L20:
        if (isEngineOn() == false) goto L24;
        if (this.s == null) goto L24;
        goto L23
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void onVoiceAnchorAvatarClicked() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.put("cmd_open_interact_manage_dialog_by_anchor", Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void showCancelApplyDialog() {
        com.bytedance.android.livesdk.widget.j0.a r0 = new com.bytedance.android.livesdk.widget.j0.a(getContext());
        r0.a = s1.B(2131919819);
        r0.a(s1.B(2131915913), new g0(this));
        r0.b(s1.B(2131915442), h0.a);
        r0.c();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.a
    public final Boolean t0() {
        com.bytedance.android.live.pushstream.d r0 = this.s;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        return Boolean.valueOf(r0.t0());
    L5:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void tryAutoFastMatch() {
        String r0 = ChatMatchWidget.o;
        Intrinsics.checkNotNullParameter("apply_panel", "requestPage");
        ChatMatchWidget.o = "apply_panel";
        ChatMatchWidget r1 = this.N;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNull(r1);
        r1.zq(null, true, "apply_panel", Boolean.FALSE);
        return;
    }

    public final void ur() {
        Lazy r1 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVoiceChatRoomGuestWidget#" + hashCode(), "call realOnCreate, hasRealOnCreate = " + this.W);
        com.bytedance.android.livesdk.chatroom.u r2 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r2 == null) goto L11;
        com.bytedance.live.datacontext.j r3 = r2.s();
        if (r3 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r3.getValue();
        if (r4 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r5 = r4.t();
        if (r5 == null) goto L11;
        List<Integer> r6 = r5.c;
    L12:
        this.x1 = r6;
        if (this.W == false) goto L16;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.h0();
        return;
    L16:
        this.W = true;
        tf0.o r7 = this.Z;
        if (r7 == null) goto L19;
        tf0.j r8 = r7.getLinkWindowLayoutConfig();
    L21:
        if ((r8 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.m) == true) goto L23;
        r8 = null;
    L23:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r9 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.m) r8;
        if (r9 == null) goto L28;
        com.bytedance.android.live.liveinteract.plantform.utils.u r10 = this.x2;
        if (r10 == null) goto L28;
        r10.u(r9);
    L28:
        com.bytedance.live.datacontext.m r11 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).y();
        if (r11 == null) goto L31;
        r11.setValue(Boolean.FALSE);
    L31:
        getRoomContext();
        com.bytedance.live.datacontext.j r12 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r12 == null) goto L34;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r13 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r12.getValue();
    L35:
        if (r13 == null) goto L48;
        com.bytedance.live.datacontext.j r14 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r14 == null) goto L41;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r15 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r14.getValue();
        if (r15 == null) goto L41;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r16 = r15.t();
    L42:
        if (r16 == null) goto L48;
        hg6.g r17 = P2();
        if (r17 == null) goto L48;
        fg6.b r18 = r17.F();
        if (r18 == null) goto L48;
        r18.b(pg6.a.b(r16));
    L41:
        r16 = null;
    L48:
        tc0.c.h().B = 5;
        Pair r19 = com.bytedance.live.datacontext.d.a(MultiLinkVoiceChatRoomGuestWidget$initGuestApplyViewModel$1.INSTANCE);
        GuestApplyViewModel r20 = (GuestApplyViewModel) r19.component1();
        Disposable r21 = (Disposable) r19.component2();
        com.bytedance.live.datacontext.b.a(r20, GuestApplyViewModel.TAG);
        this.S.add(r21);
        Pair r22 = com.bytedance.live.datacontext.d.a(MultiLinkVoiceChatRoomGuestWidget$initAdminInviteAndApplyViewModel$1.INSTANCE);
        AdminInviteAndApplyViewModel r23 = (AdminInviteAndApplyViewModel) r22.component1();
        Disposable r24 = (Disposable) r22.component2();
        com.bytedance.live.datacontext.b.a(r23, AdminInviteAndApplyViewModel.TAG);
        this.S.add(r24);
        hr();
        this.X = new MultiLinkVoiceChatGuestPresenter(getMRoom(), ((Widget) this).dataCenter, com.bytedance.android.live.liveinteract.api.utils.m.e(this));
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r25 = MultiRevenueDataContext.a.d();
        if (r25 != null) goto L51;
    L54:
        int r26 = com.bytedance.android.live.liveinteract.utils.h1.a;
        com.bytedance.android.live.liveinteract.utils.h1.b(getMRoom());
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r27 = MultiRevenueDataContext.a.d();
        if (r27 == null) goto L58;
        r27.p(this, SceneType.SCENE_AUDIO_TALKROOM, this.v, false);
    L58:
        if (this.I2 != null) goto L61;
        enableSubWidgetManager();
        QuickInteractWidget r28 = new QuickInteractWidget();
        this.I2 = r28;
        ((Widget) this).subWidgetManager.load(r28);
    L61:
        if (this.K2 != null) goto L68;
        enableSubWidgetManager();
        CustomizeStreamWidget r29 = new CustomizeStreamWidget();
        this.K2 = r29;
        ((Widget) this).subWidgetManager.load(r29);
        SeiAppData r30 = this.v1;
        if (r30 == null) goto L68;
        CustomizeStreamWidget r31 = this.K2;
        if (r31 == null) goto L68;
        r31.xq(r30);
    L68:
        if (this.L2 != null) goto L75;
        enableSubWidgetManager();
        IKtvService r32 = jc1.k.f(IKtvService.class);
        if (r32 == null) goto L72;
        Widget r33 = r32.createPcAudioWidget();
    L73:
        this.L2 = r33;
        ((Widget) this).subWidgetManager.load(r33);
        goto L75
    L72:
        r33 = null;
    L75:
        if (((Boolean) ib0.a.getValue()).booleanValue() == false) goto L85;
        View r34 = ((Widget) this).contentView.findViewById(2131384400);
        if ((r34 instanceof HSImageView) == true) goto L79;
        r34 = null;
    L79:
        HSImageView r35 = (HSImageView) r34;
        if (r35 == null) goto L94;
        of0.b r36 = InteractiveSongContext.Companion.c();
        if (r36 == null) goto L94;
        r36.e7(r35);
    L94:
        InteractiveSongContext.a r37 = InteractiveSongContext.Companion;
        if (r37.getContext() == null) goto L98;
        InteractiveSongContext r38 = r37.getContext();
        Intrinsics.checkNotNull(r38);
        Disposable r39 = r38.getSingingGuestId().a().subscribe(new com.bytedance.android.live.multilink.voicechat.impl.widget.w(this));
        InteractiveSongContext r40 = r37.getContext();
        Intrinsics.checkNotNull(r40);
        Disposable r41 = r40.getShowOrderSingStage().a().subscribe(new com.bytedance.android.live.multilink.voicechat.impl.widget.x(this));
        this.S.add(r39);
        this.S.add(r41);
    L98:
        if (this.H2 != null) goto L101;
        enableSubWidgetManager();
        CPositionWidget r42 = new CPositionWidget();
        this.H2 = r42;
        ((Widget) this).subWidgetManager.load(r42);
    L101:
        if (this.Q2 != null) goto L104;
        enableSubWidgetManager();
        AudioChatStageWidget r43 = new AudioChatStageWidget();
        this.Q2 = r43;
        ((Widget) this).subWidgetManager.load(r43);
    L104:
        if (this.O2 != null) goto L112;
        enableSubWidgetManager();
        this.O2 = new LinkmicSubtitleBusinessWidget();
        vb6.g r44 = yq();
        if (r44 == null) goto L110;
        yb6.e r45 = r44.j();
        if (r45 == null) goto L110;
        LinkmicSubtitleBusinessWidget r46 = this.O2;
        Intrinsics.checkNotNull(r46);
        r46.getClass();
        Intrinsics.checkNotNullParameter(r45, "mediaManager");
        r46.c = r45;
    L110:
        ((Widget) this).subWidgetManager.load(this.O2);
    L112:
        if (this.P2 != null) goto L115;
        enableSubWidgetManager();
        InteractActingWidget r47 = new InteractActingWidget();
        this.P2 = r47;
        ((Widget) this).subWidgetManager.load(r47);
    L115:
        if (this.M2 != null) goto L123;
        enableSubWidgetManager();
        if (MultiLinkLoadWidgetUtils.g() == true) goto L119;
        HamletInterceptTouchFrameLayout r48 = (HamletInterceptTouchFrameLayout) findViewById(2131374185);
    L120:
        if (r48 == null) goto L122;
        r48.setDataCenter(((Widget) this).dataCenter);
    L122:
        HamletAvatarWidget r49 = new HamletAvatarWidget(r48, new MultiLinkVoiceChatRoomGuestWidget$loadHamletAvatarWidget$1(this), null);
        this.M2 = r49;
        ((Widget) this).subWidgetManager.load(r49);
        goto L123
    L119:
        r48 = new HamletInterceptTouchFrameLayout(((Widget) this).context, null);
        zd0.c r50 = new zd0.c(r48);
        int r51 = vd0.a.g;
        vd0.a.C0284a.a(((Widget) this).dataCenter).b(3000, 3002, r50);
    L123:
        this.h2 = new com.bytedance.android.live.liveinteract.videotalk.utils.a(Aq(), false, ((Widget) this).dataCenter);
        this.p2 = new oe0.b(Aq());
        com.bytedance.live.datacontext.j r52 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r52 == null) goto L147;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r53 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r52.getValue();
        if (r53 == null) goto L147;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r54 = r53.t();
        if (r54 == null) goto L147;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVoiceChatRoomGuestWidget#" + hashCode(), "onCreate#trySwitchLayout, scene = " + r54.a + ", uiLayout = " + r54.b);
        com.bytedance.live.datacontext.m r55 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r55 == null) goto L136;
        IRoom r56 = (IRoom) r55.getValue();
        if (r56 == null) goto L136;
        z5 r57 = r56.getLinkerDetail();
        if (r57 == null) goto L136;
        Integer r58 = Integer.valueOf(r57.getAnchorManualUiLayout());
    L137:
        if (r58 != null) goto L139;
    L141:
        wn0.a r59 = this.Y;
        if (r59 == null) goto L144;
        wn0.a.d(r59, new zj0.c.b(r54.a, r54.b), r54.c, r54.a(), false, null, 24);
    L144:
        rr(r54.a, r54.b);
        if (r54.a == 0) goto L147;
        this.H1 = r54;
        goto L147
    L139:
        if (r58.intValue() == 0) goto L141;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r60 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.s1(r58.intValue(), true);
        jy0.b.d("AnchorManualUiLayout", "MultiLinkVoiceChatRoomGuestWidget#init currentManualUiLayout=" + r58 + ", lastManualUiLayout=null");
    L136:
        r58 = null;
    L147:
        com.bytedance.live.datacontext.j r61 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r61 == null) goto L155;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r62 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r61.getValue();
        if (r62 == null) goto L155;
        BehaviorSubject r63 = r62.a();
        if (r63 == null) goto L155;
        r63.subscribe(new v(this));
    L155:
        if (vm2.d.q0().isUserInfoCenterForwardInit() == true) goto L157;
        Aq().I = false;
        Aq().i();
    L157:
        MultiLinkVoiceChatGuestPresenter r65 = this.X;
        if (r65 == null) goto L160;
        r65.g0(this);
    L160:
        ((Widget) this).dataCenter.observe("cmd_video_talk_guest_battle_open_panel", this);
        ((Widget) this).dataCenter.observe("cmd_open_interact_manage_dialog_by_anchor", this);
        ((Widget) this).dataCenter.observe("cmd_audio_talk_invite", this);
        ((Widget) this).dataCenter.observe("cmd_show_guest_apply_dialog", this);
        ((Widget) this).dataCenter.observe("cmd_operate_interact_media", this);
        ((Widget) this).dataCenter.observe("cmd_audio_chat_stage_position_update", this);
        ((Widget) this).dataCenter.observe("data_show_player", this);
        Aq().Q4(this.G2);
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r66 = Aq().c;
        if (r66.size() <= 0) goto L163;
        this.G2.onOnlineListChanged(r66);
    L163:
        cj0.l r67 = this.T1;
        com.bytedance.android.live.liveinteract.plantform.core.y r68 = Aq();
        r67.getClass();
        Intrinsics.checkNotNullParameter(r68, "linkUserInfoCenterV2");
        r68.Q4(r67);
        vr(jd0.f.class, new w(this));
        vr(zg1.h1.class, new x(this));
        vr(i1.class, new y(this));
        vr(u22.b.class, new z(this));
        vr(o42.g.class, new a0(this));
        vr(pv0.c.class, new b0(this));
        hd0.c.f().h.observe(this, new MultiLinkVoiceChatRoomGuestWidget$realOnCreate$10());
        if (vm2.e.a() == false) goto L173;
        if ((getContext() instanceof FragmentActivity) == false) goto L173;
        InteractLiveCorePermissionGuarantor r69 = dr();
        Context r70 = getContext();
        if (r70 == null) goto L171;
        r69.i((FragmentActivity) r70);
        goto L173
    L171:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L173:
        if (com.bytedance.android.live.liveinteract.api.utils.m.j(this) == null) goto L178;
        IKtvService.b.b(jc1.k.n(IKtvService.class), this, new p(this), 2);
        com.bytedance.live.datacontext.k r71 = jc1.k.n(IKtvService.class).ktvComponentSingerChangedEvent();
        if (r71 == null) goto L178;
        this.S.add(r71.onEvent().subscribe(new q(this)));
    L178:
        if (isKtvOn() == false) goto L183;
        if (this.I == null) goto L183;
        com.bytedance.android.live.liveinteract.voicechat.util.k.r();
    L183:
        if (isKtvOn() == false) goto L189;
        if (isKtvOn() == true) goto L187;
    L203:
        fj0.b.a.b = false;
        mz0.f r72 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if ((r72 instanceof mz0.f) == false) goto L268;
        mz0.f r73 = r72;
        String r74 = r73.m();
        if (TextUtils.isEmpty(r74) == true) goto L209;
        this.w = r74;
    L209:
        if (TextUtils.isEmpty(this.w) == false) goto L211;
        int r75 = bh0.a.a;
        String r76 = String.valueOf(com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_CANCELED_BY_SERVER);
    L212:
        String r77 = r73.d();
        int r110 = r73.getApplyType();
        sf0.a r111 = new sf0.a(-1, d5.b(r76), r110, 0, null, null, null, 0, 0, 0, false, false, 0, null, null, 0, 524280);
        if (r77 != null) goto L215;
    L227:
        String r78 = r73.l();
        String r112 = r73.e();
        if (r112 != null) goto L230;
        r112 = "";
    L230:
        String r113 = r73.k();
        String r79 = r73.f();
        if (r79 != null) goto L233;
        String r210 = "";
    L235:
        if (TextUtils.equals(r112, "") == true) goto L239;
        if (TextUtils.equals(r112, "apply") == true) goto L239;
    L254:
        if (TextUtils.equals(r112, "reply") == false) goto L268;
        if (TextUtils.equals(r78, "true") == false) goto L268;
        if (((Boolean) ((Widget) this).dataCenter.get("data_strong_reach_auto_apply_already", Boolean.FALSE)).booleanValue() == true) goto L268;
        ((Widget) this).dataCenter.put("data_strong_reach_auto_apply_already", Boolean.TRUE);
        jy0.b.f("ttlive_link", "voice_auto_linkmic from " + this.w + ' ' + r110, null, 4);
        cg6.a r80 = Bq();
        if (r80 == null) goto L268;
        MultiLinkGuestManager r81 = r80.W4();
        if (r81 == null) goto L268;
        long r114 = getMRoom().getRoomId();
        if (r113 != null) goto L266;
        String r115 = "";
    L267:
        r81.j(new sf0.e(r114, r115, r210, ReplyType.Agree.ordinal(), 0, 48, 0));
        goto L268
    L266:
        r115 = r113;
    L239:
        if (TextUtils.equals(r78, "true") == false) goto L254;
        if (((Boolean) ((Widget) this).dataCenter.get("data_strong_reach_auto_apply_already", Boolean.FALSE)).booleanValue() == true) goto L254;
        ((Widget) this).dataCenter.put("data_strong_reach_auto_apply_already", Boolean.TRUE);
        jy0.b.f("ttlive_link", "voice_auto_linkmic from " + this.w + ' ' + r110, null, 4);
        Intrinsics.checkNotNullParameter("voice_auto_linkmic", "<set-?>");
        r111.h = "voice_auto_linkmic";
        if (isKtvOn() == false) goto L248;
        if (r110 <= 0) goto L246;
        int r116 = r110;
    L247:
        r111.c = r116;
    L252:
        Intrinsics.checkNotNullParameter(r111, "applyParams");
        Wq(r111);
        goto L268
    L246:
        r116 = LinkApplyType.NORMAL.getValue();
        goto L247
    L248:
        if (r110 <= 0) goto L250;
        int r117 = r110;
    L251:
        r111.c = r117;
        goto L252
    L250:
        r117 = LinkApplyType.STRONG_REACH.getValue();
        goto L251
    L233:
        r210 = r79;
        goto L235
    L215:
        if (TextUtils.equals(r77, "true") == false) goto L227;
        jy0.b.f("ttlive_link", "voice_auto_apply from " + this.w + ' ' + r110, null, 4);
        Intrinsics.checkNotNullParameter("voice_auto_apply", "<set-?>");
        r111.h = "voice_auto_apply";
        if (isKtvOn() == false) goto L222;
        if (r110 <= 0) goto L220;
        int r118 = r110;
    L221:
        r111.c = r118;
    L226:
        Intrinsics.checkNotNullParameter(r111, "applyParams");
        Wq(r111);
        goto L227
    L220:
        r118 = LinkApplyType.CITYSONG.getValue();
        goto L221
    L222:
        if (r110 <= 0) goto L224;
        int r119 = r110;
    L225:
        r111.c = r119;
        goto L226
    L224:
        r119 = LinkApplyType.CITY.getValue();
        goto L225
    L211:
        r76 = this.w;
        Intrinsics.checkNotNull(r76);
    L268:
        String r82 = LinkmicOnlineFloatWindowManager.Y;
        if (LinkmicOnlineFloatWindowManager.c.a().x == null) goto L333;
        Zq(new com.bytedance.android.live.multilink.voicechat.impl.widget.c0(), LinkApi.ApplyStashType.ONLINE_WINDOW.ordinal());
        Iterator r83 = ((ArrayList) LinkmicOnlineFloatWindowManager.c.a().o).iterator();
    L272:
        if (r83.hasNext() == false) goto L280;
        ILinkPlayerInfoBridge r84 = (ILinkPlayerInfoBridge) r83.next();
        IBaseUser r85 = r84.getBaseUser();
        if (r85 == null) goto L276;
        String r86 = r85.getIdString();
    L278:
        if (Intrinsics.areEqual(r86, jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L272;
        ILinkPlayerInfoBridge r87 = com.bytedance.android.live.liveinteract.plantform.model.n.a(r84);
    L281:
        if (r87 == null) goto L333;
        VoiceChatMuteManager r88 = Pq();
        if (r87.getSilenceStatus() == 0) goto L286;
        boolean r89 = true;
    L287:
        r88.t(r89);
        hg6.g r90 = P2();
        if (r90 == null) goto L290;
        r90.p(this);
    L290:
        String r91 = LinkmicOnlineFloatWindowManager.Y;
        tc0.c r92 = LinkmicOnlineFloatWindowManager.c.a().n;
        if (r92 == null) goto L293;
        String r93 = r92.k;
    L294:
        hg6.g r94 = P2();
        if (r94 == null) goto L297;
        r94.c0(r93);
    L297:
        this.s = LinkmicOnlineFloatWindowManager.c.a().z;
        this.t = LinkmicOnlineFloatWindowManager.c.a().y;
        hg6.g r95 = LinkmicOnlineFloatWindowManager.c.a().x;
        if (yq() == null) goto L323;
        if (r95 == null) goto L323;
        if (r95.V0() == null) goto L323;
        if (this.t == null) goto L323;
        vb6.g r96 = yq();
        if (r96 == null) goto L313;
        yb6.e r97 = r96.j();
        if (r97 == null) goto L313;
        hh1.v0 r98 = this.t;
        if (r98 == null) goto L312;
        r97.s0(gc6.b.c(r98, null), "MultiLinkVoiceChatRoomGuestWidget restoreLinkmicState");
        goto L313
    L312:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.interact.LiveVideoClientFactory");
    L313:
        vb6.g r99 = yq();
        if (r99 == null) goto L318;
        yb6.e r100 = r99.j();
        if (r100 == null) goto L318;
        ei6.a r101 = r95.V0();
        Intrinsics.checkNotNull(r101);
        r100.Q(r101, "MultiLinkVoiceChatRoomGuestWidget restoreLinkmicState");
    L318:
        vb6.g r102 = yq();
        if (r102 == null) goto L323;
        yb6.e r103 = r102.j();
        if (r103 == null) goto L323;
        r103.o0(LinkmicOnlineFloatWindowManager.c.a().A);
    L323:
        hd0.c.f().k(2);
        LinkmicOnlineFloatWindowManager.c.a().i();
        com.bytedance.live.datacontext.m r104 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).m();
        if (r104 == null) goto L326;
        r104.setValue(Boolean.TRUE);
    L326:
        jg6.a r105 = LinkmicOnlineFloatWindowManager.c.a().w;
        if (r105 == null) goto L331;
        kg6.e r106 = r105.b();
        if (r106 == null) goto L331;
        ((Widget) this).dataCenter.put("data_self_is_silenced", Boolean.valueOf(r106.q()));
    L331:
        ((Widget) this).dataCenter.put("data_recover_from_online_float_window_start_subtitle", Boolean.TRUE);
        goto L333
    L293:
        r93 = null;
        goto L294
    L286:
        r89 = false;
        goto L287
    L276:
        r86 = null;
        goto L278
    L280:
        r87 = null;
    L333:
        if (this.N2 != null) goto L347;
        Widget.WidgetCallback r107 = ((Widget) this).widgetCallback;
        if (r107 == null) goto L337;
        WidgetManager r108 = r107.getWidgetManager();
    L338:
        if (r108 == null) goto L347;
        enableSubWidgetManager();
        hg6.g r109 = P2();
        com.bytedance.android.live.liveinteract.plantform.core.y r120 = Aq();
        cg6.a r121 = Bq();
        if (r121 == null) goto L342;
        MultiLinkGuestManager r122 = r121.W4();
    L344:
        if ((r122 instanceof com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b) == true) goto L346;
        r122 = null;
    L346:
        RTSVoiceWidget r123 = new RTSVoiceWidget(r109, r120, (com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b) r122, 8);
        this.N2 = r123;
        ((Widget) this).subWidgetManager.load(r123);
        goto L347
    L342:
        r122 = null;
        goto L344
    L337:
        r108 = null;
    L347:
        int r124 = xe0.j.a;
        getMRoom();
        if (xe0.j.a() == false) goto L365;
        LinkmicApplyFloatWindowManager.d r125 = LinkmicApplyFloatWindowManager.y;
        we0.b r126 = LinkmicApplyFloatWindowManager.e.a().i(getMRoom().getRoomId());
        if (r126 == null) goto L365;
        Zq(new com.bytedance.android.live.multilink.voicechat.impl.widget.s(), LinkApi.ApplyStashType.APPLY_WINDOW.ordinal());
        tc0.c r127 = tc0.c.h();
        resetLinkmicReturnRoomParams(r126);
        hd0.c.f().k(1);
        z0 r128 = r126.B;
        if (r128 == null) goto L364;
        Intrinsics.checkNotNull(r128);
        r127.k = r128.getRtcExtInfo();
        r127.n = r128.getMultiRtcInfo();
        r127.s = r128.getMcuContent();
        r127.e = r128.getAnchorLinkMicIdStr();
        cg6.a r129 = Bq();
        if (r129 == null) goto L359;
        MultiLinkGuestManager r130 = r129.W4();
        if (r130 == null) goto L359;
        r130.g();
    L359:
        Long r131 = r126.C;
        if (r131 == null) goto L362;
        Intrinsics.checkNotNull(r131);
        long r132 = r131.longValue();
    L363:
        TalkRoomBusinessFullLinkMonitor r133 = TalkRoomBusinessFullLinkMonitor.a;
        String r134 = r127.f;
        r133.getClass();
        TalkRoomBusinessFullLinkMonitor.f(r134, r132);
        goto L364
    L362:
        r132 = 0;
    L364:
        LinkmicApplyFloatWindowManager.e.a().s = null;
    L365:
        com.bytedance.live.datacontext.m r135 = jc1.k.n(IKtvService.class).getHasBgm();
        if (r135 == null) goto L369;
        this.S.add(r135.a().subscribe(new r(this)));
    L369:
        if (vm2.d.U0() == false) goto L373;
        com.bytedance.live.datacontext.k r136 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).L();
        if (r136 == null) goto L373;
        this.S.add(RxUtilKt.p(r136.onEvent(), "MultiLinkVoiceChatRoomGuestWidget", new MultiLinkVoiceChatRoomGuestWidget$realOnCreate$$inlined$let$lambda$1(this)));
    L373:
        IKtvService r137 = jc1.k.f(IKtvService.class);
        if (r137 == null) goto L381;
        com.bytedance.live.datacontext.m r138 = r137.getKtvComponentStatusChangedObservable();
        if (r138 == null) goto L379;
        this.S.add(r138.a().subscribe(new com.bytedance.android.live.multilink.voicechat.impl.widget.y(this)));
    L379:
        if (vm2.d.k0() == false) goto L381;
        IKtvService.b.b(r137, this, new com.bytedance.android.live.multilink.voicechat.impl.widget.z(this), 2);
    L381:
        SpatialAudioContext.a r139 = SpatialAudioContext.Companion;
        if (r139.getContext() != null) goto L384;
        SpatialAudioStrategyManager.c.a();
    L384:
        SpatialAudioContext r140 = r139.getContext();
        if (r140 == null) goto L393;
        com.bytedance.live.datacontext.m<Integer> r141 = r140.getCurrentStrategyId();
        if (r141 == null) goto L393;
        Observable r142 = r141.a();
        if (r142 == null) goto L393;
        Disposable r143 = r142.subscribe(new s(this));
        if (r143 == null) goto L393;
        this.S.add(r143);
    L393:
        com.bytedance.android.live.liveinteract.linksecurity.c.g.k(((Widget) this).dataCenter);
        TalkRoomLogUtils.x = null;
        com.bytedance.android.live.liveinteract.plantform.core.h r144 = new com.bytedance.android.live.liveinteract.plantform.core.h(getMRoom(), ((Widget) this).dataCenter, Aq());
        this.p0 = r144;
        Intrinsics.checkNotNull(r144);
        r144.a();
        if (vm2.d.y() == true) goto L396;
    L406:
        vb6.g r145 = yq();
        if (r145 == null) goto L409;
        r145.e1(new t(), true);
    L409:
        mz0.f r146 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if (r146 == null) goto L417;
        if ((r146 instanceof mz0.f) == false) goto L417;
        if (TextUtils.equals(r146.g(), "1") == false) goto L417;
        f2.c(s1.B(2131917753), 0);
    L417:
        if (vm2.d.K0() == true) goto L419;
    L421:
        kr();
        if (MultiLinkLoadWidgetUtils.f() == false) goto L426;
        tf0.o r147 = this.Z;
        if (r147 == null) goto L426;
        r147.w();
    L426:
        LinkMicRoomDataSyncModel r148 = LinkWRDSHelper.b();
        if (r148 == null) goto L435;
        dc2.c r149 = r148.getTalkRoomListUserInfoPb();
        if (r149 == null) goto L435;
        Observable r150 = r149.d;
        if (r150 == null) goto L435;
        Disposable r151 = r150.subscribe(new u(this));
        if (r151 == null) goto L435;
        RxUtilKt.c(r151, this.S);
    L435:
        com.bytedance.android.live.liveinteract.plantform.base.g r152 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r152 == null) goto L441;
        com.bytedance.android.live.ui.c r153 = r152.y4();
        if (r153 == null) goto L441;
        com.bytedance.android.live.multilink.voicechat.impl.widget.v r154 = new com.bytedance.android.live.multilink.voicechat.impl.widget.v(this);
        Intrinsics.checkNotNullParameter(r154, "intercept");
        r153.i = r154;
    L441:
        if (((Boolean) nm.a.getValue()).booleanValue() == true) goto L443;
        return;
    L443:
        if (jr() == false) goto L454;
        com.bytedance.android.live.liveinteract.plantform.base.g r155 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r155 == null) goto L455;
        com.bytedance.android.live.ui.c r156 = r155.y4();
        if (r156 == null) goto L456;
        r156.k();
        return;
    L456:
        return;
    L455:
        return;
    L454:
        return;
    L419:
        if (vm2.d.h() == false) goto L421;
        GLSurfaceView r157 = (GLSurfaceView) ((Widget) this).containerView.findViewById(2131375529);
        j50.a r158 = new j50.a();
        this.Z2 = r158;
        Intrinsics.checkNotNull(r158);
        r158.e = new j50.b(r157);
        r157.setVisibility(0);
        Context r159 = ((Widget) this).context;
        j50.a r160 = this.Z2;
        Intrinsics.checkNotNull(r160);
        v50.a.a(r157, r159, r160, new com.bytedance.android.live.core.gl.primitive.a());
        k50.c r161 = new k50.c(r157);
        this.a3 = r161;
        Intrinsics.checkNotNull(r161);
        r161.a();
        j50.a r162 = this.Z2;
        Intrinsics.checkNotNull(r162);
        k50.e.c(r157, r162);
        k50.c r163 = this.a3;
        Intrinsics.checkNotNull(r163);
        k50.e.b(r157, r163);
        goto L421
    L396:
        if (vm2.d.x() == false) goto L406;
        com.bytedance.live.datacontext.j r164 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getCompactTbLoader();
        if (r164 == null) goto L400;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r165 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) r164.getValue();
    L402:
        if ((r165 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) == true) goto L404;
        r165 = null;
    L404:
        if (r165 == null) goto L406;
        r165.refreshExistComponent(26);
        jy0.b.d("MultiLinkVoiceChatRoomGuestWidget", "[LinkmicIconDoubleCheck] voiceChatRoomGuestWidget load refresh icon");
        goto L406
    L400:
        r165 = null;
        goto L402
    L187:
        if (vm2.d.e().a() == false) goto L203;
    L189:
        if (br() != 5) goto L191;
    L197:
        boolean r166 = vm2.d.X0();
    L198:
        if (r166 == false) goto L203;
        if (this.N != null) goto L203;
        jy0.b.a("voice_chat", "loadMatchWidget");
        enableSubWidgetManager();
        ChatMatchWidget r167 = new ChatMatchWidget(true, this);
        this.N = r167;
        ((Widget) this).subWidgetManager.load(r167);
        goto L203
    L191:
        if (je0.d.s() == true) goto L197;
        if (br() != 9) goto L196;
        r166 = vm2.d.e().a();
        goto L198
    L196:
        r166 = false;
        goto L198
    L85:
        if (this.J2 != null) goto L94;
        enableSubWidgetManager();
        InteractiveSongWidget r168 = qf0.b.a();
        this.J2 = r168;
        if (r168 == null) goto L93;
        View r169 = ((Widget) this).contentView;
        if (r169 == null) goto L93;
        if ((r169.findViewById(2131384400) instanceof HSImageView) == false) goto L93;
        InteractiveSongWidget r170 = this.J2;
        Intrinsics.checkNotNull(r170);
        r170.e7((HSImageView) ((Widget) this).contentView.findViewById(2131384400));
    L93:
        ((Widget) this).subWidgetManager.load(this.J2);
        goto L94
    L51:
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == true) goto L53;
        r25.o(((Widget) this).dataCenter, this, SceneType.SCENE_AUDIO_TALKROOM, (ViewGroup) ((Widget) this).contentView.findViewById(2131388184));
    L53:
        r25.d(((Widget) this).dataCenter);
        goto L54
    L34:
        r13 = null;
        goto L35
    L19:
        r8 = null;
    L11:
        r6 = null;
        goto L12
    }

    @Override // wn0.a.c
    public final Pair<Integer, Integer> x3() {
        View r0 = hs0.a.b.getCurrentLivePlayerParent();
        if (r0 == null) goto L7;
        return new Pair(Integer.valueOf(r0.getWidth()), Integer.valueOf(r0.getHeight()));
    L7:
        return new Pair(0, 0);
    }

    public final boolean xr() {
        if (jc1.k.f(IInteractService.class) != null) goto L5;
    L9:
        return false;
    L5:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getInteractFloatWindowService() == null) goto L9;
        if (((com.bytedance.android.live.liveinteract.service.g) ((IInteractService) jc1.k.n(IInteractService.class)).getInteractFloatWindowService()).b() == false) goto L9;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget
    public final int Mq() {
        bg6.a r0 = s2();
        if (r0 == null) goto L7;
        vf6.a r1 = r0.a9();
        if (r1 == null) goto L7;
        return r1.c;
    L7:
        return 200;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.a
    public final boolean O5() {
        hg6.g r0 = P2();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isEngineOn();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget
    public final yf6.b Yq() {
        rf6.a r0 = xq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.s2();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final boolean canSilenceSelf() {
        return isEngineOn();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final ILinkPlayerInfoBridge currentCPositionUser() {
        if (Aq().c.isEmpty() == true) goto L12;
        Iterator<ILinkPlayerInfoBridge> r0 = Aq().c.iterator();
    L6:
        if (r0.hasNext() == false) goto L20;
        ILinkPlayerInfoBridge r1 = r0.next();
        if (r1.isEnlarged() == false) goto L6;
        if (r1.getBaseUser() == null) goto L6;
        return r1;
    L20:
        return null;
    L12:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final String currentCPositionUserType() {
        if (Aq().c.isEmpty() == true) goto L19;
        Iterator<ILinkPlayerInfoBridge> r0 = Aq().c.iterator();
    L6:
        if (r0.hasNext() == false) goto L19;
        ILinkPlayerInfoBridge r1 = r0.next();
        if (r1.isEnlarged() == false) goto L6;
        if (r1.getBaseUser() == null) goto L6;
        IBaseUser r2 = r1.getBaseUser();
        if (r2 == null) goto L14;
        String r3 = r2.getIdString();
    L16:
        if (Intrinsics.areEqual(r3, getMRoom().getAnchorId()) == false) goto L18;
        return "anchor";
    L18:
        return "guest";
    L14:
        r3 = null;
    L19:
        return "normal";
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final jg6.a getAdminStatusCenter() {
        return Eq();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final int getCurrentScene() {
        return br();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter() {
        return Aq();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final List<ILinkPlayerInfoBridge> getLinkWaitingList() {
        return Aq().f;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final we0.b getLinkmicReturnRoomParams() {
        tc0.c r0 = tc0.c.h();
        DataCenter r1 = ((Widget) this).dataCenter;
        com.bytedance.android.live.liveinteract.plantform.model.g0 r2 = null;
        if (r1 == null) goto L5;
        r2 = (com.bytedance.android.live.liveinteract.plantform.model.g0) r1.get("data_link_mic_pos_tag_info", null);
        boolean r3 = ((Boolean) ((Widget) this).dataCenter.get("data_link_mic_is_quick_invite", Boolean.FALSE)).booleanValue();
    L6:
        int r4 = com.bytedance.android.live.liveinteract.utils.h1.c();
        we0.b.a r5 = new we0.b.a();
        r5.a = r0.M;
        r5.b = fj0.b.a.d();
        r5.d = this.x;
        r5.e = Integer.valueOf(r0.K);
        r5.g = this.w;
        r5.h = Boolean.valueOf(Nq());
        r5.i = Boolean.valueOf(this.z);
        r5.j = Boolean.valueOf(this.A);
        r5.k = r2;
        r5.l = Boolean.valueOf(r3);
        r5.m = Long.valueOf(this.V0);
        r5.n = Long.valueOf(this.b1);
        r5.o = Long.valueOf(this.g1);
        r5.p = Long.valueOf(this.h1);
        r5.q = Long.valueOf(this.y);
        r5.r = Long.valueOf(this.k1);
        r5.s = Long.valueOf(this.p1);
        r5.t = r0.f;
        r5.u = Integer.valueOf(r0.j);
        r5.v = Integer.valueOf(hd0.c.f().g);
        r5.w = Boolean.valueOf(r0.C);
        r5.x = Boolean.valueOf(fj0.e.d());
        r5.y = Integer.valueOf(r4);
        r5.z = this.E;
        r5.A = r0.F;
        return r5.a();
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final List<ILinkPlayerInfoBridge> getOnlineUserList() {
        return Aq().c;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return br();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final int getSelfSilenceType() {
        if (isEngineOn() == false) goto L5;
        VoiceChatMuteManager r0 = Pq();
        Intrinsics.checkNotNull(r0);
        return r0.o();
    L5:
        return -1;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void hideFastMatchDialog() {
        if (s0.a(getMRoom()) == false) goto L7;
        ILinkPanelService r0 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r0 == null) goto L15;
        r0.close();
        return;
    L15:
        return;
    L7:
        ChatMatchWidget r1 = this.N;
        if (r1 == null) goto L17;
        Intrinsics.checkNotNull(r1);
        ChatMatchDialog r2 = r1.b;
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.isShowing() == false) goto L19;
        ChatMatchWidget.wq(r2);
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final boolean isEngineOn() {
        hg6.g r0 = P2();
        if (r0 != null) goto L12;
        String r1 = LinkmicOnlineFloatWindowManager.Y;
        hg6.g r2 = LinkmicOnlineFloatWindowManager.c.a().x;
        if (r2 != null) goto L8;
    L10:
        return false;
    L8:
        if (r2.A() != true) goto L10;
        return true;
    L12:
        return r0.A();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final boolean isKtvOn() {
        if (br() != 9) goto L5;
        return true;
    L5:
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).I1();
        if (r0 != null) goto L8;
    L10:
        return false;
    L8:
        if (((Boolean) r0.getValue()).booleanValue() != true) goto L10;
        return true;
    }

    public final boolean jr() {
        tc0.c r0 = tc0.c.h();
        if (r0 == null) goto L11;
        Map r1 = r0.o;
        if (r1 == null) goto L11;
        Map.Entry r2 = com.bytedance.android.live.core.utils.z0.a(r1);
        if (r2 == null) goto L11;
        g2 r3 = (g2) r2.getValue();
        if (r3 == null) goto L11;
        Long r4 = Long.valueOf(r3.getLiveRoomMode());
    L13:
        if (aj0.a.c(br()) == false) goto L19;
        if (r4 != null) goto L17;
    L18:
        return true;
    L17:
        if (r4.longValue() != 3) goto L18;
    L19:
        return false;
    L11:
        r4 = null;
        goto L13
    }

    public final void kr() {
        if (br() != 9) goto L6;
        return;
    L6:
        if (this.R2 != null) goto L11;
        jy0.b.b("InteractAnimationController", "before loadAnimRenderWidget", new Throwable());
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r0 = MultiRevenueDataContext.a.d();
        if (r0 == null) goto L12;
        jy0.b.a("InteractAnimationController", "loadAnimRenderWidget");
        this.R2 = r0.e(this, SceneType.SCENE_AUDIO_TALKROOM, (ViewGroup) ((Widget) this).contentView.findViewById(2131388184));
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final com.bytedance.android.live.liveinteract.voicechat.b muteManager() {
        return Pq();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVoiceChatRoomGuestWidget#" + hashCode(), "call onCreate");
        int r1 = 0;
        AttributeSet r2 = null;
        if (MultiLinkLoadWidgetUtils.g() == false) goto L13;
        int r3 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r4 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(((Widget) this).dataCenter);
        if (r4 == null) goto L7;
        BaseLinkSeatWindowView r5 = r4.getLinkSeatWindowView();
    L8:
        if (r5 == null) goto L13;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r6 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(((Widget) this).dataCenter);
        if (r6 == null) goto L12;
        ConstraintLayout r7 = r6.getLinkSeatWindowView();
    L14:
        ALogger.i("MultiLinkVoiceChatRoomGuestWidget", "updateWindowViewParent windowView=" + r7 + ", containerView=" + ((Widget) this).containerView);
        if (r7 == null) goto L32;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof FrameLayout.LayoutParams) == true) goto L20;
        r8 = null;
    L20:
        FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) r8;
        ViewParent r10 = r7.getParent();
        if ((r10 instanceof ViewGroup) == true) goto L23;
        r10 = null;
    L23:
        ViewGroup r11 = (ViewGroup) r10;
        if (r11 == null) goto L26;
        r11.removeView(r7);
    L26:
        ViewGroup r12 = (ViewGroup) ((Widget) this).containerView.findViewById(2131378012);
        if (r12 == null) goto L29;
        r12.removeAllViews();
    L29:
        if (r9 != null) goto L31;
        r9 = new FrameLayout.LayoutParams(-1, -1);
        r9.gravity = 49;
    L31:
        r12.addView(r7, r9);
    L32:
        int r13 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r14 = ((Widget) this).dataCenter;
        IRoom r15 = getMRoom();
        if (r15 == null) goto L35;
        Long r16 = Long.valueOf(r15.getId());
    L36:
        MultiSceneEnterRoomStatisticsUtils r17 = MultiSceneEnterRoomStatisticsUtils.a.a(r14, Long.valueOf(r16.longValue()));
        if (r17 == null) goto L40;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r17, "widget_load", 0, 2, null);
    L40:
        if (vm2.d.P0() == false) goto L49;
        ILivePlayerClient r18 = hs0.a.b.getCurrentClient();
        if (r18 == null) goto L49;
        IRoomEventHub r19 = r18.getEventHub();
        if (r19 == null) goto L49;
        MutableLiveData r20 = r19.getVideoSizeChanged();
        if (r20 == null) goto L49;
        r20.observe(this, new com.bytedance.android.live.multilink.voicechat.impl.widget.b0(this));
    L49:
        if (vm2.d.O0() == false) goto L58;
        View r21 = hs0.a.b.getCurrentLivePlayerParent();
        this.V2 = r21;
        if (r21 == null) goto L53;
        r21.addOnLayoutChangeListener(this.W2);
    L53:
        StringBuilder r22 = new StringBuilder("registerLivePlayerSizeUpdateEvent addListener, GuestWidget=");
        r22.append(hashCode());
        r22.append(", livePlayerParent=");
        View r23 = this.V2;
        if (r23 == null) goto L56;
        Integer r24 = Integer.valueOf(r23.hashCode());
    L57:
        r22.append(r24);
        jy0.b.d("MultiLinkVoiceChatRoomGuestWidget", r22.toString());
        goto L58
    L56:
        r24 = null;
    L58:
        ConstraintLayout r25 = ((Widget) this).contentView.findViewById(2131363980);
        if (r25 == null) goto L107;
        com.bytedance.android.live.liveinteract.plantform.utils.u r26 = new com.bytedance.android.live.liveinteract.plantform.utils.u(((Widget) this).context, ((Widget) this).dataCenter, r25, getMRoom(), this, p5(), this);
        this.x2 = r26;
        r26.j();
        hr();
        Pair r27 = com.bytedance.live.datacontext.d.a(MultiLinkVoiceChatRoomGuestWidget$initOnCreate$1.INSTANCE);
        VoiceChatGuestDataContext r28 = (VoiceChatGuestDataContext) r27.component1();
        Disposable r29 = (Disposable) r27.component2();
        r28.getService().d(this);
        com.bytedance.live.datacontext.b.a(r28, IVoiceChatGuestService.TAG);
        this.S.add(r29);
        Pair r30 = com.bytedance.live.datacontext.d.a(MultiLinkVoiceChatRoomGuestWidget$initOnCreate$2.INSTANCE);
        VoiceChatGlobalDataContext r31 = (VoiceChatGlobalDataContext) r30.component1();
        Disposable r32 = (Disposable) r30.component2();
        r31.getVoiceChatAdminService().d(this);
        com.bytedance.live.datacontext.b.a(r31, IVoiceChatAdminService.TAG);
        this.S.add(r32);
        r31.getUserInfoCenter().d(Aq());
        enableSubWidgetManager();
        r31.getSubWidgetManager().d(((Widget) this).subWidgetManager);
        IRoom r33 = getMRoom();
        Intrinsics.checkNotNull(r33);
        VoiceChatMuteManager r34 = new VoiceChatMuteManager(r33, false, Aq(), ((Widget) this).dataCenter, this, this, this);
        Intrinsics.checkNotNullParameter(r34, "<set-?>");
        this.O = r34;
        Pq().j();
        Pq().c(this, com.bytedance.android.live.multilink.voicechat.impl.widget.u.a);
        this.P1 = new MuteStateChecker(((Widget) this).dataCenter, Aq(), Pq());
        this.I = new com.bytedance.android.live.liveinteract.voicechat.util.k(((Widget) this).dataCenter, com.bytedance.android.live.liveinteract.api.utils.m.j(this));
        if (MultiLinkLoadWidgetUtils.g() == true) goto L64;
        mr(null);
    L64:
        if (MultiLinkLoadWidgetUtils.d() == false) goto L92;
        DataCenter r35 = ((Widget) this).dataCenter;
        if (r35 == null) goto L70;
        Boolean r36 = (Boolean) r35.get("data_multi_link_log_enter", Boolean.FALSE);
        if (r36 == null) goto L70;
        boolean r37 = r36.booleanValue();
    L71:
        if (r37 == true) goto L92;
        mr("FallbackLog on Create");
        String r38 = vm2.h.W().fallbackLogType();
        com.bytedance.android.livesdk.chatroom.u r39 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r39 == null) goto L81;
        com.bytedance.live.datacontext.j r40 = r39.s();
        if (r40 == null) goto L81;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r41 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r40.getValue();
        if (r41 == null) goto L81;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r42 = r41.t();
        if (r42 == null) goto L81;
        int r43 = r42.a;
    L82:
        com.bytedance.android.livesdk.chatroom.u r44 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r44 == null) goto L91;
        com.bytedance.live.datacontext.j r45 = r44.s();
        if (r45 == null) goto L91;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r46 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r45.getValue();
        if (r46 == null) goto L91;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r47 = r46.t();
        if (r47 == null) goto L91;
        r1 = r47.b;
    L91:
        String r48 = TalkRoomLogUtils.h;
        LiveTracingMonitor.a(r38, new Throwable("MultiLinkFallbackLog"), "fall back log: rid: " + getMRoom().getIdStr() + ", scene: " + r43 + ", uiLayout: " + r1 + ", function_type2: " + r48);
    L81:
        r43 = 5;
    L70:
        r37 = false;
    L92:
        this.H0 = new WeakHandler(this);
        this.Q1 = new InteractAnimationController(((Widget) this).dataCenter);
        InteractAnimationContext r49 = (InteractAnimationContext) com.bytedance.live.datacontext.d.a(MultiLinkVoiceChatRoomGuestWidget$initOnCreate$4.INSTANCE).component1();
        r49.getController().d(this.Q1);
        com.bytedance.live.datacontext.b.a(r49, InteractAnimationContext.class);
        sh0.i0 r50 = sh0.j0.a;
        this.v = sh0.j0.c(((Widget) this).dataCenter, this);
        InteractAnimationController r51 = this.Q1;
        if (this.Y != null) goto L95;
        this.Y = new wn0.a(((Widget) this).dataCenter, this, r51);
    L95:
        wn0.a r52 = this.Y;
        if (r52 == null) goto L98;
        zj0.f.b r53 = new zj0.f.b(0, 0, 0, null, 31);
        MultiLinkVoiceChatRoomGuestWidget$registerWindowManagers$1 r54 = new MultiLinkVoiceChatRoomGuestWidget$registerWindowManagers$1(this);
        Intrinsics.checkNotNullParameter(r53, "layoutConfig");
        Intrinsics.checkNotNullParameter(r54, "provider");
        r52.a.add(r53);
        r52.b.put(r53.f, r54);
    L98:
        ne0.c r55 = this.v;
        if (r55 == null) goto L101;
        r55.d(sh0.f0.b, new com.bytedance.android.live.multilink.voicechat.impl.widget.t(this));
    L101:
        enableSubWidgetManager();
        this.S1 = new com.bytedance.android.live.liveinteract.utils.g0(getMRoom(), Aq());
        if (MultiLinkLoadWidgetUtils.f() == true) goto L104;
        ur();
    L104:
        this.V1.g();
        this.d3.a(this);
        return;
    L107:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L35:
        r16 = null;
        goto L36
    L12:
        r7 = null;
        goto L14
    L7:
        r5 = null;
    L13:
        r7 = new VoiceCommonLinkSeatWindowView(((Widget) this).context, r2, 6, r1);
        r7.setId(2131378011);
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void onPause() {
        if (xr() == true) goto L8;
        hg6.g r0 = P2();
        if (r0 == null) goto L8;
        r0.onPause();
    L8:
        if (isEngineOn() == true) goto L10;
    L25:
        this.R = false;
        tf0.o r1 = this.Z;
        if (r1 == null) goto L28;
        r1.p();
    L28:
        super.onPause();
        return;
    L10:
        if (this.s == null) goto L25;
        if (vm2.e.a() == false) goto L15;
        dr().f();
    L15:
        if (((IInteractService) jc1.k.n(IInteractService.class)).enableCaptureAudioOnBackground(true) == true) goto L21;
        G4(true, "onPause");
        VoiceChatMuteManager r2 = Pq();
        Intrinsics.checkNotNull(r2);
        int r3 = r2.o();
        if (r3 != 0) goto L19;
        Aq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
        Pq().k("onPause");
    L23:
        if (xr() == true) goto L25;
        Aq().v();
        goto L25
    L19:
        if (r3 != 3) goto L23;
        com.bytedance.android.live.liveinteract.plantform.utils.x.R(r3);
        goto L23
    L21:
        com.bytedance.android.live.liveinteract.plantform.utils.x.J();
        goto L23
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        if (vm2.e.a() == false) goto L6;
        dr().h();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.e
    public final boolean q3() {
        return com.bytedance.android.live.liveinteract.spatial.a.e(C0());
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final hg6.g rtcManger() {
        return P2();
    }

    @Override // com.bytedance.android.live.multilink.voicechat.impl.widget.MultiLinkVoiceChatGuestPresenter.IView
    public final bg6.a s2() {
        rf6.a r0 = xq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.s2();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.voicechat.e
    public final void B() {
        super.B();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget
    public final BizLinkServiceType Kq() {
        return BizLinkServiceType.VoiceGuest;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget
    public final tf0.o Qq() {
        return this.Z;
    }

    @Override // tf0.o.a
    public final HashMap Y7() {
        return kk0.h.f2;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final tf0.o commonWindowManager() {
        return this.Z;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final int getAnchorManualUiLayout() {
        return this.G1;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final tf0.h getInteractAnimationService() {
        return this.Q1;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final m00.h getLinkVideoClient() {
        return this.t;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final tf0.m getSwitchLayoutStatisticsUtils() {
        return this.F2;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final com.bytedance.android.live.pushstream.d guestLiveStream() {
        return this.s;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final boolean isCurrentLinkPaid() {
        return this.i;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final boolean ktvWillAutoSilenceSelf() {
        return this.K;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final cj0.l paidLinkManager() {
        return this.T1;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final rj0.h videoStylePaidLinkManager() {
        return this.V1;
    }

    @Override // tf0.o.a
    public final int Aa(SurfaceView r7) {
        com.bytedance.android.live.liveinteract.plantform.model.e0 r0 = tc0.c.h().s;
        Integer r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getRivalsStreamId();
    L6:
        ALogger.d(LinkRoomFightContext.TAG, "livecore version " + jc1.k.n(IMiddlewareBroadcastService.class).getLiveCoreVersion());
        StringBuilder r3 = new StringBuilder("setPublicStreamVideoCanvas isEngineOn: ");
        hg6.g r4 = P2();
        if (r4 == null) goto L9;
        Boolean r5 = Boolean.valueOf(r4.isEngineOn());
    L10:
        r3.append(r5);
        r3.append(" id ");
        r3.append(r2);
        r3.append(" view ");
        r3.append(r7);
        ALogger.d(LinkRoomFightContext.TAG, r3.toString());
        if (r2 != null) goto L13;
    L19:
        hg6.g r6 = P2();
        if (r6 == null) goto L24;
        xi0.b r8 = r6.O();
        if (r8 == null) goto L24;
        r1 = Integer.valueOf(r8.b0(String.valueOf(r2), r7));
    L24:
        ALogger.d(LinkRoomFightContext.TAG, "setPublicStreamVideoCanvas result " + r1);
        if (r1 != null) goto L27;
        return -1;
    L27:
        return r1.intValue();
    L13:
        if (r2.length() != 0) goto L15;
        boolean r9 = true;
    L16:
        if (r9 != true) goto L19;
        return -1;
    L15:
        r9 = false;
        goto L16
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.voicechat.e
    public final void H0(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        super.H0(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.e
    public final void M0(sf0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        showFollowGuideDialog(false, new com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.j(this, r2));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void M4(cc6.b r10) {
        Intrinsics.checkNotNullParameter(r10, "error");
        Intrinsics.checkNotNullParameter(r10, "error");
        gg6.a.a(r10);
        this.C = null;
        if (this.I == null) goto L13;
        String r1 = this.E;
        String r2 = this.w;
        LinkApplyType r3 = this.x;
        yf6.b r0 = Yq();
        if (r0 == null) goto L10;
        vf6.a r4 = r0.a9();
        if (r4 == null) goto L10;
        String r5 = r4.b;
        if (r5 == null) goto L10;
    L11:
        com.bytedance.android.live.liveinteract.voicechat.util.k.B(r1, r2, r3, r5, er(), r10.a, r10.b);
        return;
    L10:
        r5 = "";
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.voicechat.e
    public final void O(sf0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        super.O(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.voicechat.e
    public final void P(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        super.P(r2);
    }

    @Override // tf0.o.a
    public final int Po(String r4) {
        jy0.b.a(LinkRoomFightContext.TAG, "livecore version " + ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).getLiveCoreVersion());
        jy0.b.a(LinkRoomFightContext.TAG, "startPlayPublicStream id " + r4);
        if (r4 != null) goto L6;
        return -1;
    L6:
        hg6.g r0 = P2();
        if (r0 == null) goto L11;
        xi0.b r1 = r0.O();
        if (r1 == null) goto L11;
        Integer r5 = Integer.valueOf(r1.l(r4));
    L12:
        jy0.b.a(LinkRoomFightContext.TAG, "startPlayPublicStream result " + r5);
        if (r5 != null) goto L17;
        return 0;
    L17:
        return r5.intValue();
    L11:
        r5 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.voicechat.e
    public final hh1.v0 Q0(String r1) {
        return super.Q0(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b
    public final void U0(IRoom r4) {
        Intrinsics.checkNotNullParameter(r4, PbRequest.SwitchType.ROOM);
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVoiceChatRoomGuestWidget#" + hashCode(), "call updateFullMode");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.a = r4;
        ur();
    }

    @Override // kk0.f
    public final void Vj(ILinkPlayerInfoBridge r7) {
        Intrinsics.checkNotNullParameter(r7, "info");
        ILiveLinkCameraBackUpConfig r0 = vm2.g.c();
        if (ILiveLinkCameraBackUpConfigKt.supportMsgUpdateForAudience(r0) == true) goto L6;
        return;
    L6:
        if (r7.getBaseUser() == null) goto L39;
        IBaseUser r1 = r7.getBaseUser();
        if (r1 == null) goto L10;
        String r2 = r1.getIdString();
    L12:
        if ((!Intrinsics.areEqual(r2, je0.d.b0())) == false) goto L15;
        return;
    L15:
        if (r7.isBackground() == false) goto L17;
        return;
    L17:
        if (this.R == false) goto L46;
        com.bytedance.android.live.pushstream.d r3 = this.s;
        if (r3 == null) goto L24;
        uf2.d0 r4 = r3.A();
        if (r4 == null) goto L24;
        boolean r5 = r4.t0();
    L26:
        if (r7.getSilenceStatus() == 0) goto L37;
        if (r5 == true) goto L36;
        int r6 = this.b2 + 1;
        this.b2 = r6;
        Set<Long> r8 = InteractLinkFullLinkMonitor.a;
        InteractLinkFullLinkMonitor.y(r6, null, Boolean.valueOf(r5), r7.getSilenceStatus(), r7.getLinkType());
        if (this.b2 < ILiveLinkCameraBackUpConfigKt.getSafeMaxDiffCount(r0)) goto L41;
        jg6.a r9 = Eq();
        if (r9 == null) goto L35;
        kg6.e r10 = r9.b();
        if (r10 == null) goto L35;
        r10.t(new kg6.b(false, false, "link security", 8));
    L35:
        this.b2 = 0;
        return;
    L41:
        return;
    L36:
        this.b2 = 0;
        return;
    L37:
        this.b2 = 0;
        return;
    L24:
        r5 = false;
        goto L26
    L46:
        return;
    L10:
        r2 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void accept(IBaseUser r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        yf6.b r0 = Yq();
        if (r0 == null) goto L6;
        r0.b(r3, this.P);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void apply(sf0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        Wq(r2);
    }

    @Override // com.bytedance.android.live.multilink.voicechat.impl.widget.MultiLinkVoiceChatGuestPresenter.IView
    public final void f3(h1 r5) {
        Intrinsics.checkNotNullParameter(r5, "linkerMessage");
        if (r5.getLinkerEnlargeGuestReplyContent() == null) goto L11;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r1 = r5.getMessageId3();
        com.bytedance.android.livesdk.message.linker.g r3 = r5.getLinkerEnlargeGuestReplyContent();
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.k0(r1, r3);
        if (r5.getLinkerEnlargeGuestReplyContent().getReplyType() == CPositionReplyType.Reject.getValue()) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r5.getLinkerEnlargeGuestReplyContent().getReplyPrompts()) == true) goto L9;
        f2.c(r5.getLinkerEnlargeGuestReplyContent().getReplyPrompts(), 0);
        return;
    L9:
        f2.b(2131922714, 0);
        return;
    }

    @Override // com.bytedance.android.live.multilink.voicechat.impl.widget.MultiLinkVoiceChatGuestPresenter.IView
    public final void g9(h1 r5) {
        FragmentActivity r0 = ContextUtil.contextToFragmentActivity(getContext());
        Integer r1 = null;
        if (r5 == null) goto L5;
        LinkerEnlargeUpdateContent r2 = r5.getLinkerEnlargeUpdateContent();
    L6:
        if (r2 == null) goto L50;
        if (r0 == null) goto L51;
        String r3 = gh0.a.c();
        if (r5 == null) goto L13;
        LinkerEnlargeUpdateContent r4 = r5.getLinkerEnlargeUpdateContent();
        if (r4 == null) goto L13;
        String r6 = LinkerEnlargeUpdateContentKt.getFromUserId(r4);
    L15:
        if (Intrinsics.areEqual(r3, r6) == false) goto L29;
        if (r5 == null) goto L20;
        LinkerEnlargeUpdateContent r7 = r5.getLinkerEnlargeUpdateContent();
        if (r7 == null) goto L20;
        r1 = r7.getTargetEnlargeGuestType();
    L20:
        int r8 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal();
        if (r1 != null) goto L24;
    L26:
        boolean r9 = false;
    L27:
        TalkRoomLogUtils.B.T(r9, ((Widget) this).dataCenter);
        return;
    L24:
        if (r1.intValue() != r8) goto L26;
        r9 = true;
        goto L27
    L29:
        CPositionBeSetDialog r10 = this.y2;
        if (r10 != null) goto L32;
    L39:
        int r11 = CPositionBeSetDialog.j;
        getMRoom().getRoomId();
        CPositionBeSetDialog r12 = CPositionBeSetDialog.a.a(CPositionBeSetDialog.RoomType.Audio, r5);
        this.y2 = r12;
        FragmentManager r13 = r0.getSupportFragmentManager();
        LandscapeRestrictionOperation r14 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, "VideoTalkCPositionBeSetDialog", r14);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r12, r14) == true) goto L52;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
    L43:
        r12.show(r13, "VideoTalkCPositionBeSetDialog");
        return;
    L52:
        return;
    L32:
        if (r10.isShowing() == false) goto L39;
        r10.dismissAllowingStateLoss();     // Catch: Exception -> L35
    L35:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r15 = DialogFragmentLancet.sLastShowStack;
        if (r15 == null) goto L39;
        com.bytedance.crash.d.d(r15, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L13:
        r6 = null;
        goto L15
    L51:
        return;
    L50:
        return;
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.util.List] */
    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.b
    public final void h0(IRoom r14) {
        Intrinsics.checkNotNullParameter(r14, PbRequest.SwitchType.ROOM);
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVoiceChatRoomGuestWidget#" + hashCode(), "call initFastMode");
        com.bytedance.android.livesdk.chatroom.u r1 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        List r2 = null;
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.j r3 = r1.s();
        if (r3 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r3.getValue();
        if (r4 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r5 = r4.t();
        if (r5 == null) goto L11;
        List<Integer> r6 = r5.c;
    L12:
        this.x1 = r6;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        this.a = r14;
        int r15 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r16 = ((Widget) this).dataCenter;
        IRoom r7 = getMRoom();
        if (r7 == null) goto L15;
        Long r8 = Long.valueOf(r7.getId());
    L16:
        MultiSceneEnterRoomStatisticsUtils r17 = MultiSceneEnterRoomStatisticsUtils.a.a(r16, Long.valueOf(r8.longValue()));
        if (r17 == null) goto L19;
        r17.c();
    L19:
        System.currentTimeMillis();
        boolean r9 = true;
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == false) goto L27;
        jy0.b.a("livesdk_audience_loading_statistics", "start native dynamic widget: ");
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r18 = MultiRevenueDataContext.a.d();
        if (r18 == null) goto L24;
        r18.d(((Widget) this).dataCenter);
    L24:
        enableSubWidgetManager();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r19 = MultiRevenueDataContext.a.d();
        if (r19 == null) goto L27;
        r19.p(this, SceneType.SCENE_AUDIO_TALKROOM, this.v, true);
    L27:
        System.currentTimeMillis();
        com.bytedance.android.livesdk.chatroom.u r110 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r110 == null) goto L91;
        com.bytedance.live.datacontext.j r111 = r110.s();
        if (r111 == null) goto L92;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r112 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r111.getValue();
        if (r112 == null) goto L93;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r113 = r112.t();
        if (r113 == null) goto L94;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVoiceChatRoomGuestWidget#" + hashCode(), "call trySwitchLayout on initFastMode, scene = " + r113.a + ", uiLayout = " + r113.b);
        DataCenter r10 = ((Widget) this).dataCenter;
        IRoom r11 = getMRoom();
        if (r11 == null) goto L38;
        Long r12 = Long.valueOf(r11.getId());
    L39:
        MultiSceneEnterRoomStatisticsUtils r13 = MultiSceneEnterRoomStatisticsUtils.a.a(r10, Long.valueOf(r12.longValue()));
        if (r13 == null) goto L42;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r13, "native_receive_ui_layout", 0, 2, null);
    L42:
        Lazy r20 = MultiLinkWRDSPreloadManager.i;
        RoomLinkMicSyncData r21 = IMultiLinkWRDSPreloadService.DefaultImpls.getRoomLinkMicSyncData$default(MultiLinkWRDSPreloadManager.a.a(), "inner_feed", getMRoom(), false, 4, null);
        if (MultiLinkLoadWidgetUtils.g() == false) goto L81;
        if (r21 == null) goto L81;
        if (MultiLinkLoadWidgetUtils.g() == true) goto L48;
    L50:
        r9 = false;
    L51:
        if (r9 == false) goto L75;
        LinkerBaseInfo r22 = r21.linkerBaseInfo;
        if (r22 == null) goto L55;
        int r23 = r22.getScene();
    L56:
        LinkerBaseInfo r24 = r21.linkerBaseInfo;
        if (r24 == null) goto L59;
        int r25 = r24.getUiLayout();
    L60:
        LinkerBaseInfo r26 = r21.linkerBaseInfo;
        if (r26 == null) goto L68;
        List<Long> r27 = r26.getPlayModes();
        if (r27 == null) goto L68;
        List<Long> r28 = r27;
        ?? r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator r30 = r28.iterator();
    L66:
        if (r30.hasNext() == false) goto L69;
        r29.add(Integer.valueOf((int) ((Number) r30.next()).longValue()));
    L69:
        ?? r31 = r29;
        ClientUIInfo r32 = r21.clientUIInfo;
        if (r32 != null) goto L72;
        r32 = r113.a();
    L72:
        ClientUIInfo r33 = r32;
        wn0.a r34 = this.Y;
        if (r34 == null) goto L75;
        wn0.a.d(r34, new zj0.c.C0300c(r23, r25), r31, r33, false, null, 24);
    L68:
        r29 = r113.c;
        goto L69
    L59:
        r25 = r113.b;
        goto L60
    L55:
        r23 = r113.a;
    L75:
        ConstraintLayout r35 = ((Widget) this).contentView.findViewById(2131363980);
        if (r35 == null) goto L79;
        r35.setVisibility(0);
    L88:
        rr(r113.a, r113.b);
        return;
    L79:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L48:
        if (vm2.h.W().fixSmallWindow() == false) goto L50;
    L81:
        if (vm2.d.S0() == false) goto L85;
        ClientUIInfo r36 = r113.a();
        if (r36 == null) goto L85;
        r2 = r36.getUiFeatureList();
    L85:
        List r37 = r2;
        wn0.a r38 = this.Y;
        if (r38 == null) goto L88;
        wn0.a.d(r38, new zj0.c.C0300c(r113.a, r113.b), r113.c, r113.a(), false, r37, 8);
        goto L88
    L38:
        r12 = null;
        goto L39
    L94:
        return;
    L93:
        return;
    L92:
        return;
    L91:
        return;
    L15:
        r8 = null;
    L11:
        r6 = null;
        goto L12
    }

    @Override // wn0.a.c
    public final void h4(tf0.o r2) {
        Intrinsics.checkNotNullParameter(r2, "windowManager");
        this.Z = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.voicechat.e
    public final void i(IApplyResult r1) {
        super.i(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void invite(com.bytedance.android.live.liveinteract.videolink.a r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (com.bytedance.android.live.liveinteract.utils.h1.d() == false) goto L11;
        if (r3.i > 0) goto L11;
        if (r3.b != 0) goto L11;
        com.bytedance.android.live.liveinteract.utils.h1.e(this.v, ((Widget) this).context, r3);
        return;
    L11:
        if (br() != 9) goto L13;
        int r0 = 64;
    L14:
        r3.a = r0;
        yf6.b r1 = Yq();
        if (r1 == null) goto L18;
        r1.a(r3, this.Q);
        return;
    L18:
        return;
    L13:
        r0 = 8;
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void kickOut(IBaseUser r3) {
        Intrinsics.checkNotNullParameter(r3, "targetUser");
        cg6.a r0 = Bq();
        if (r0 == null) goto L8;
        com.bytedance.live.bizlink.impl.platform.manager.a r1 = r0.A0();
        if (r1 == null) goto L9;
        r1.h(r3, "admin_stop_normal");
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void l1(g1 r1) {
        super.l1(r1);
        m0 r2 = this.k;
        if (r2 == null) goto L6;
        r2.c();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void logChatMatchClick(int r3) {
        new gk0.a(getMRoom()).d(false, r3);
    }

    public final void mr(String r6) {
        HashMap<String, String> r0 = new HashMap();
        if (r6 == null) goto L5;
        r0.put("ui_widget_source", r6);
    L5:
        com.bytedance.android.livesdk.chatroom.u r7 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r7 == null) goto L14;
        com.bytedance.live.datacontext.j r8 = r7.s();
        if (r8 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r9 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r8.getValue();
        if (r9 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r10 = r9.t();
        if (r10 == null) goto L14;
        int r11 = r10.a;
    L15:
        com.bytedance.android.livesdk.chatroom.u r1 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r1 == null) goto L24;
        com.bytedance.live.datacontext.j r2 = r1.s();
        if (r2 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r2.getValue();
        if (r3 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r4 = r3.t();
        if (r4 == null) goto L24;
        int r5 = r4.b;
    L26:
        if (vm2.h.R() == false) goto L28;
        r0.put("room_id", String.valueOf(getMRoom().getId()));
        r0.put("anchor_id", String.valueOf(getMRoom().getAnchorId()));
        LiveMode r12 = getMRoom().getStreamType();
        int r13 = com.bytedance.android.live.core.utils.h1.a;
        r0.put("live_type", com.bytedance.android.live.core.utils.i1.a(r12));
    L28:
        com.bytedance.android.live.liveinteract.voicechat.util.k r14 = this.I;
        if (r14 == null) goto L31;
        r14.o(r0, r11, r5, null);
    L31:
        Lazy r15 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVoiceChatRoomGuestWidget#" + hashCode(), "call logAudienceChatRoomShow, scene = " + r11 + ", uiLayout = " + r5);
        return;
    L24:
        r5 = 0;
    L14:
        r11 = 5;
        goto L15
    }

    public final void onChanged(Object r7) {
        final KVData r8 = (KVData) r7;
        if (isViewValid() == false) goto L84;
        if (r8 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r8.getKey()) == false) goto L8;
        return;
    L8:
        if (r8.getData() == null) goto L102;
        String r0 = r8.getKey();
        if (Intrinsics.areEqual(r0, "cmd_open_interact_manage_dialog_by_anchor") == false) goto L31;
        if (je0.d.c0() == true) goto L15;
    L29:
        xs2.b.a().post(new UserProfileEvent(getMRoom().getOwner()).setReportType("data_card_linked_anchor"));
        return;
    L15:
        if (hd0.c.f().h() == false) goto L29;
        com.bytedance.android.live.liveinteract.plantform.core.y r9 = Aq();
        String r1 = getMRoom().getAnchorId();
        if (r1 != null) goto L19;
        r1 = "";
    L19:
        ILinkPlayerInfoBridge r10 = r9.o(r1, "");
        if (r10 == null) goto L87;
        Context r2 = ((Widget) this).context;
        DataCenter r3 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "userInfo");
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        if (hg6.i.a() == false) goto L24;
        ih0.d r4 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r10, "seat", false);
    L28:
        r4.a();
        return;
    L24:
        VoiceChatInteractEmojiPanel r5 = new VoiceChatInteractEmojiPanel(r2, r3, r10);
        Intrinsics.checkNotNullParameter("seat", "<set-?>");
        r5.k = "seat";
        r5.r = false;
        tb6.c r11 = r5.x;
        if (r11 == null) goto L27;
        r11.a();
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r11.d = "seat";
    L27:
        r4 = r5;
        goto L28
    L87:
        return;
    L31:
        if (Intrinsics.areEqual(r0, "cmd_audio_talk_invite") == false) goto L41;
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L36;
        com.bytedance.android.live.liveinteract.utils.s0.a(((Widget) this).context, new AnonymousClass1(this, r8));
        return;
    L36:
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L38;
        f2.b(2131914522, 0);
    L39:
        com.bytedance.android.live.liveinteract.plantform.utils.x.C0(TalkRoomOperate.INVITE);
        return;
    L38:
        f2.b(2131917298, 0);
        goto L39
    L41:
        if (Intrinsics.areEqual(r0, "cmd_show_guest_apply_dialog") == false) goto L47;
        Object r12 = r8.getData();
        Intrinsics.checkNotNull(r12);
        if (((Boolean) r12).booleanValue() == false) goto L92;
        tf0.o r13 = this.Z;
        if (r13 == null) goto L93;
        r13.P();
        return;
    L93:
        return;
    L92:
        return;
    L47:
        tf0.o r6 = null;
        if (Intrinsics.areEqual(r0, "cmd_operate_interact_media") == false) goto L57;
        MediaOperation r14 = (MediaOperation) r8.getData();
        if (r14 != null) goto L52;
        return;
    L52:
        if (r14.getType() != MediaOperation.Type.MIC) goto L103;
        int r15 = com.bytedance.android.live.multilink.voicechat.impl.widget.p.a;
        throw null;
    L103:
        return;
    L57:
        if (Intrinsics.areEqual(r0, "cmd_video_talk_guest_battle_open_panel") == false) goto L60;
        String r16 = (String) r8.getData();
        d0(sh0.g.b, r16);
        return;
    L60:
        if (Intrinsics.areEqual(r0, "cmd_audio_chat_stage_position_update") == false) goto L63;
        int r17 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        com.bytedance.android.live.liveinteract.voicechat.stage.a.f(((Widget) this).dataCenter);
        return;
    L63:
        if (Intrinsics.areEqual(r0, "data_show_player") == false) goto L98;
        Boolean r18 = (Boolean) r8.getData();
        if (r18 == null) goto L99;
        tf0.o r19 = this.Z;
        if ((r19 instanceof VoiceCommonMultiLinkWindowManager) == false) goto L70;
        r6 = r19;
    L70:
        VoiceCommonMultiLinkWindowManager r20 = (VoiceCommonMultiLinkWindowManager) r6;
        if (r20 == null) goto L100;
        boolean r21 = r18.booleanValue();
        if (r20.X == r21) goto L101;
        r20.X = r21;
        InteractiveSongContext r22 = InteractiveSongContext.Companion.getContext();
        if (r22 == null) goto L79;
        com.bytedance.live.datacontext.m<Boolean> r23 = r22.isShowPlayer();
        if (r23 == null) goto L79;
        r23.setValue(Boolean.valueOf(r21));
    L79:
        DataCenter r24 = r20.C;
        if (r24 == null) goto L82;
        r24.put("data_interactive_song_show_player_status_change", Boolean.valueOf(r21));
    L82:
        r20.i1(false);
        r20.l1(false);
        return;
    L101:
        return;
    L100:
        return;
    L99:
        return;
    L98:
        return;
    L102:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void onClickToolbar(int r1) {
        sr(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void onClientUIInfoChangeMessage(ILinkerClientUIInfoChangeContent r12) {
        ClientUIInfo r0 = null;
        if (r12 == null) goto L5;
        ClientUIInfo r1 = r12.getClientUIInfo();
    L6:
        if (r12 == null) goto L10;
        Long r2 = r12.getUiLayout();
        if (r2 == null) goto L10;
        int r9 = (int) r2.longValue();
    L11:
        com.bytedance.live.datacontext.j r3 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r3 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r10 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r3.getValue();
        if (r10 == null) goto L25;
        if (r9 == r10.t().b) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r13 = new com.bytedance.android.livesdk.chatroom.viewmodel.i(br(), r9, this.x1, false, false, r1);
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L20;
        r4.put("data_room_audio_chat_ui_layout_before", Integer.valueOf(r9));
    L20:
        r10.c(r10.t());
        r10.d(r13);
        goto L25
    L21:
        com.bytedance.android.livesdk.chatroom.viewmodel.i r5 = r10.t();
        if (r12 == null) goto L24;
        r0 = r12.getClientUIInfo();
    L24:
        r5.b(r0);
    L25:
        sh0.i0 r14 = sh0.j0.e(((Widget) this).dataCenter);
        if (r14 == null) goto L29;
        r14.d0(sh0.d.b, new sh0.h(Integer.valueOf(r9), r1));
        return;
    L29:
        return;
    L10:
        r9 = 0;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r2);
        if (FoldScreenUtils.f() == false) goto L5;
    L6:
        tf0.o r3 = this.Z;
        if ((r3 instanceof BaseMultiLinkWindowManager) == true) goto L9;
        r3 = null;
    L9:
        BaseMultiLinkWindowManager r4 = (BaseMultiLinkWindowManager) r3;
        if (r4 == null) goto L14;
        r4.Y0();
        return;
    L14:
        return;
    L5:
        if (PadConfigUtils.a() == true) goto L6;
    }

    @Override // md0.a.c
    public final void onRadioTextSeiUpdate(JSONObject r3) {
        tf0.o r0 = this.Z;
        boolean r1 = r0 instanceof VoiceCommonMultiLinkWindowManager;
        if (r1 == false) goto L16;
        if (r1 == true) goto L6;
        r0 = null;
    L6:
        VoiceCommonMultiLinkWindowManager r2 = (VoiceCommonMultiLinkWindowManager) r0;
        if (r2 == null) goto L17;
        ng0.e r4 = r2.M;
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.a == false) goto L19;
        RadioTextBoardView r5 = r4.c;
        if (r5 == null) goto L20;
        r5.R5(r3);
        return;
    L20:
        return;
    L19:
        return;
    L17:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v18, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v20, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v8 */
    @Override // md0.a.InterfaceC0236a
    public final void onSeiUpdated(SeiAppData r19) {
        if (r19 != null) goto L5;
        return;
    L5:
        boolean r1 = false;
        if (r19.getUiLayout() <= 0) goto L8;
        int r0 = r19.getUiLayout();
    L18:
        ClientUIInfo r2 = this.y1;
        if (r2 != null) goto L28;
        com.bytedance.live.datacontext.j r3 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r3 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r3.getValue();
        if (r4 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r5 = r4.t();
        if (r5 == null) goto L27;
        r2 = r5.a();
    L27:
        ClientUIInfo r6 = null;
    L30:
        if (this.Y == null) goto L34;
        Integer r7 = (Integer) wn0.a.b(this.x1, r6, r0).getSecond();
        if (r7 == null) goto L34;
        r0 = r7.intValue();
    L34:
        int r8 = r0;
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L63;
        wn0.a r9 = this.Y;
        if (r9 == null) goto L61;
        zj0.f r10 = r9.c;
        if (r10 != null) goto L41;
    L43:
        boolean r11 = false;
    L44:
        if (r11 != true) goto L61;
        com.bytedance.live.datacontext.j r12 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r12 == null) goto L54;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r13 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r12.getValue();
        if (r13 == null) goto L54;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r14 = r13.t();
        if (r14 == null) goto L54;
        ClientUIInfo r15 = r14.a();
        if (r15 == null) goto L54;
        List r16 = r15.getUiFeatureList();
    L55:
        if (r6 == null) goto L57;
        List r17 = r6.getUiFeatureList();
    L59:
        if (Intrinsics.areEqual(r16, r17) == false) goto L61;
        boolean r18 = true;
    L62:
        Boolean r20 = Boolean.valueOf(r18);
    L73:
        boolean r21 = yr(br(), r19.getSubScene());
        Ref.ObjectRef r110 = new Ref.ObjectRef();
        r110.element = null;
        if (vm2.d.S0() == true) goto L76;
    L123:
        ReadOnlyProperty r22 = vm2.d.n2;
        KProperty[] r111 = vm2.d.a;
        if (((Boolean) r22.getValue(null, r111[167(0xa7, float:2.34E-43)])).booleanValue() == false) goto L145;
        if (r21 == false) goto L145;
        if (Intrinsics.areEqual(r20, Boolean.FALSE) == true) goto L129;
        if (r1 == false) goto L145;
    L129:
        com.bytedance.live.datacontext.j r23 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r23 == null) goto L138;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r24 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r23.getValue();
        if (r24 == null) goto L138;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r25 = new com.bytedance.android.livesdk.chatroom.viewmodel.i(r19.getSubScene(), r8, this.x1, false, false, r6);
        DataCenter r26 = ((Widget) this).dataCenter;
        if (r26 == null) goto L136;
        r26.put("data_room_audio_chat_ui_layout_before", Integer.valueOf(r8));
    L136:
        r24.c(r24.t());
        r24.d(r25);
    L138:
        StringBuilder r27 = new StringBuilder("needUpdateFeatureList: ");
        r27.append(r1);
        r27.append(", isSameLayout: ");
        r27.append(r20);
        r27.append(", sei: ");
        r27.append(r19.getUiFeatureList());
        r27.append(", clientUIInfo: ");
        if (r6 == null) goto L141;
        List r28 = r6.getUiFeatureList();
    L142:
        r27.append(r28);
        r27.append(", mergeFeatureList: ");
        r27.append(this.E2);
        ALogger.i("MultiLinkVoiceChatRoomGuestWidget", r27.toString());
        WeakHandler r29 = this.H0;
        if (r29 == null) goto L145;
        r29.postDelayed(new n(this, r19, r8, r6, r110), ((Number) vm2.d.o2.getValue(null, r111[168(0xa8, float:2.35E-43)])).longValue());
        goto L145
    L141:
        r28 = null;
    L145:
        md().t0(r19);
        p5().t0(r19);
        tf0.o r30 = this.Z;
        if (r30 == null) goto L148;
        r30.onSeiUpdated(r19);
    L148:
        HamletAvatarWidget r31 = this.M2;
        if (r31 == null) goto L151;
        r31.Zq(Integer.valueOf(r19.getSubUILayout()));
    L151:
        CustomizeStreamWidget r32 = this.K2;
        if (r32 == null) goto L154;
        r32.xq(r19);
    L154:
        this.v1 = r19;
        return;
    L76:
        if (r19.getUiFeatureList() == null) goto L123;
        JSONArray r33 = r19.getUiFeatureList();
        if (r33 == null) goto L82;
        Intrinsics.checkNotNullParameter(r33, "$this$toIntList");
        int r112 = r33.length();
        ?? r113 = new ArrayList(r112);
        int r114 = 0;
    L80:
        if (r114 >= r112) goto L83;
        r113.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r33, r114)));
        r114 = r114 + 1;
    L83:
        r110.element = r113;
        ArrayList r34 = new ArrayList();
        Iterator r115 = ((List) r113).iterator();
    L85:
        if (r115.hasNext() == false) goto L92;
        Object r116 = r115.next();
        if (((Number) r116).intValue() != 8) goto L89;
        boolean r117 = true;
    L90:
        if (r117 == false) goto L85;
        r34.add(r116);
        goto L85
    L89:
        r117 = false;
        goto L90
    L92:
        if (r6 == null) goto L104;
        List r118 = r6.getUiFeatureList();
        if (r118 == null) goto L104;
        ?? r119 = new ArrayList();
        Iterator r120 = r118.iterator();
    L97:
        if (r120.hasNext() == false) goto L105;
        Object r121 = r120.next();
        if (((Number) r121).intValue() == 8) goto L101;
        boolean r122 = true;
    L102:
        if (r122 == false) goto L97;
        r119.add(r121);
        goto L97
    L101:
        r122 = false;
    L105:
        List<Integer> r35 = CollectionsKt.sortedWith(CollectionsKt.plus(r34, (Iterable) r119), new m());
        if (((Boolean) vm2.d.q2.getValue(null, vm2.d.a[170(0xaa, float:2.38E-43)])).booleanValue() == false) goto L116;
        List<Integer> r123 = this.E2;
        if (r35 != null) goto L110;
    L111:
        if (r123 != null) goto L113;
    L115:
        boolean r124 = false;
    L118:
        if ((!Intrinsics.areEqual(r35, this.E2)) == false) goto L121;
        if (r124 == false) goto L121;
        r1 = true;
    L121:
        if (r1 == false) goto L123;
        this.E2 = r35;
        goto L123
    L113:
        if (r123.contains(8) != true) goto L115;
    L110:
        if (r35.contains(8) != true) goto L111;
    L116:
        r124 = true;
    L104:
        r119 = CollectionsKt.emptyList();
        goto L105
    L82:
        r113 = CollectionsKt.emptyList();
        goto L83
    L57:
        r17 = null;
    L54:
        r16 = null;
        goto L55
    L41:
        if (r8 != r10.b) goto L43;
        r11 = true;
    L61:
        r18 = false;
        goto L62
    L63:
        wn0.a r36 = this.Y;
        if (r36 == null) goto L72;
        Intrinsics.checkNotNullParameter(r19, "seiAppData");
        int r37 = r19.getUiLayout();
        zj0.f r38 = r36.c;
        if (r38 != null) goto L68;
    L70:
        boolean r39 = false;
    L71:
        r20 = Boolean.valueOf(r39);
        goto L73
    L68:
        if (r37 != r38.b) goto L70;
        r39 = true;
        goto L71
    L72:
        r20 = null;
    L28:
        r6 = r2;
        goto L30
    L8:
        com.bytedance.android.livesdk.chatroom.u r40 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r40 == null) goto L17;
        com.bytedance.live.datacontext.j r41 = r40.s();
        if (r41 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r42 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r41.getValue();
        if (r42 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r43 = r42.t();
        if (r43 == null) goto L17;
        r0 = r43.b;
    L17:
        r0 = 0;
        goto L18
    }

    @Override // md0.a.c
    public final void onSpeechRecognitionSeiUpdate(String r2) {
        if (r2 == null) goto L11;
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.n<fd2.v> r1 = r0.getLyricsRecognizer();
        if (r1 == null) goto L13;
        fd2.v r3 = (fd2.v) r1.getValue();
        if (r3 == null) goto L14;
        r3.onSei(r2);
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }

    @Override // md0.a.c
    public final void onSpeechRhythm(String r2) {
        if (r2 == null) goto L11;
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.j<of0.b> r1 = r0.getInteractiveSongWidget();
        if (r1 == null) goto L13;
        of0.b r3 = (of0.b) r1.getValue();
        if (r3 == null) goto L14;
        r3.onSei(r2);
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void onSwitchSceneMessage(z0 r18) {
        Intrinsics.checkNotNull(r18);
        tc0.c r1 = tc0.c.h();
        if (vm2.d.v0() == false) goto L5;
        String r2 = TalkRoomLogUtils.g();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        TalkRoomLogUtils.j = r2;
        com.bytedance.android.live.liveinteract.plantform.utils.i.g(r18);
    L5:
        r1.r = r18.getMultiLiveCoreInfo();
        r1.m = r18.getLiveCoreExtInfo();
        r1.n = r18.getMultiRtcInfo();
        r1.k = r18.getRtcExtInfo();
        r1.s = r18.getMcuContent();
        MultiLinkVoiceChatGuestPresenter r3 = this.X;
        if (r3 == null) goto L8;
        r3.g = r18.getTrackingData();
    L8:
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r4 = IVoiceChatAdminService.a.a();
        if (r4 != null) goto L11;
    L18:
        ClientUIInfo r5 = r18.getClientUIInfo();
        if (((Boolean) vm2.d.n2.getValue(null, vm2.d.a[167(0xa7, float:2.34E-43)])).booleanValue() == true) goto L21;
    L25:
        com.bytedance.live.datacontext.j r6 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r6 == null) goto L33;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r6.getValue();
        if (r7 == null) goto L33;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r8 = new com.bytedance.android.livesdk.chatroom.viewmodel.i(r18.getValidScene(), r18.getUiLayout(), r18.getPlayModes(), false, false, r5);
        DataCenter r9 = ((Widget) this).dataCenter;
        if (r9 == null) goto L32;
        r9.put("data_room_audio_chat_ui_layout_before", Integer.valueOf(r18.getUiLayout()));
    L32:
        r7.c(r7.t());
        r7.d(r8);
    L33:
        wn0.a r10 = this.Y;
        if (r10 == null) goto L36;
        wn0.a.d(r10, new zj0.c.a(r18.getValidScene(), r18.getUiLayout(), "switch_from_msg", "receive_switch_scene_msg"), r18.getPlayModes(), r5, false, null, 24);
    L36:
        rr(r18.getValidScene(), r18.getUiLayout());
        return;
    L21:
        if (yr(br(), r18.getValidScene()) == false) goto L25;
        if (isEngineOn() == true) goto L25;
        this.x1 = r18.getPlayModes();
        this.y1 = r5;
        goto L36
    L11:
        if (r18.getLinkedListUsers() == null) goto L18;
        jy0.b.d("ttlive_link_audio", "realSwitchScene ListUser=" + je0.d.g0(r18.getLinkedListUsers()));
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r11 = r4.getLinkUserInfoCenter();
        if ((r11 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L15;
        r11 = null;
    L15:
        com.bytedance.android.live.liveinteract.plantform.core.y r12 = (com.bytedance.android.live.liveinteract.plantform.core.y) r11;
        if (r12 == null) goto L18;
        r12.Y4(r18.getLinkedListUsers(), r18.getClientUIInfo(), r18.getVersion(), "switchSceneMsg", r18.getLinkerContentMap());
        goto L18
    }

    public final void or(String r27) {
        String r24 = er();
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        int r2 = 9;
        String r3 = "anchor";
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.getValue();
        if (r4 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r5 = r4.t();
        if (r5 == null) goto L11;
        if (r5.a != 9) goto L11;
    L10:
        String r7 = r3;
    L35:
        com.bytedance.android.live.liveinteract.voicechat.util.k r6 = this.I;
        if (r6 != null) goto L38;
    L46:
        this.H = null;
        tc0.c.h().F = "";
        return;
    L38:
        if (isKtvOn() == true) goto L41;
        r2 = 5;
    L41:
        String r8 = this.w;
        int r9 = Mq();
        boolean r10 = Nq();
        String r11 = this.E;
        long r12 = 1000;
        long r13 = (System.currentTimeMillis() - Math.max(this.k1, this.h1)) / r12;
        Long r14 = Long.valueOf((this.k1 - this.y) / r12);
        Long r15 = Long.valueOf(ar());
        List r16 = wr();
        long r17 = this.S2.b;
        IRoom r18 = getMRoom();
        if (r18 == null) goto L44;
        ICircleInfo r19 = r18.getCircleInfo();
    L45:
        r6.C(r2, r8, r9, r10, r11, r7, r13, r14, r15, r16, false, r17, r19, gr(), r27, null, this.x, this.G, this.h2, this.p2, r24, this.j);
        goto L46
    L44:
        r19 = null;
    L11:
        cg6.a r20 = Bq();
        if (r20 == null) goto L18;
        MultiLinkGuestManager r21 = r20.W4();
        if (r21 == null) goto L18;
        if (r21.g != true) goto L18;
        String r22 = "anchor";
    L19:
        com.bytedance.live.datacontext.m r23 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).y();
        if (r23 != null) goto L22;
    L24:
        r3 = r22;
    L25:
        cg6.a r25 = Bq();
        if (r25 == null) goto L32;
        MultiLinkGuestManager r26 = r25.W4();
        if (r26 == null) goto L32;
        if (r26.h != true) goto L32;
        r3 = "game";
    L32:
        ai0.e r28 = ((IInteractService) jc1.k.n(IInteractService.class)).getAdventureService();
        Intrinsics.checkNotNull(r28);
        ((ai0.c) r28).getClass();
        if (com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.f == false) goto L10;
        r7 = "meetgame_call";
        goto L35
    L22:
        if (((Boolean) r23.getValue()).booleanValue() != true) goto L24;
    L18:
        r22 = "audience";
        goto L19
    }

    @Override // com.bytedance.android.live.multilink.voicechat.impl.widget.MultiLinkVoiceChatGuestPresenter.IView
    public final void q(int r5) {
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (isEngineOn() == true) goto L8;
        return;
    L8:
        if (this.s == null) goto L31;
        boolean r0 = false;
        if (r5 == 0) goto L24;
        if (r5 != 1) goto L14;
    L21:
        f2.b(2131919412, 0);
        com.bytedance.android.live.liveinteract.linksecurity.c.m(com.bytedance.android.live.liveinteract.linksecurity.c.g);
        if (this.R == true) goto L25;
        com.bytedance.android.live.liveinteract.plantform.utils.x.M();
        ((Widget) this).dataCenter.put("data_talk_room_capture_audio_notification_show_state", Boolean.FALSE);
    L25:
        boolean r6 = !r0;
        Pq().t(r6);
        G4(r6, "silence message");
        com.bytedance.android.live.liveinteract.plantform.base.g r7 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r7 == null) goto L30;
        r7.Lp(r0);
        return;
    L30:
        return;
    L14:
        if (r5 == 2) goto L21;
        if (r5 != 3) goto L18;
        Aq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
        goto L25
    L18:
        if (r5 == 4) goto L21;
    L24:
        f2.b(2131919449, 0);
        r0 = true;
        goto L25
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void resetLinkmicReturnRoomParams(we0.b r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        tc0.c r0 = tc0.c.h();
        String r1 = r5.a;
        if (r1 == null) goto L5;
        r0.M = r1;
    L5:
        tf0.l r2 = r5.b;
        if (r2 == null) goto L8;
        fj0.a r3 = fj0.b.a;
        Intrinsics.checkNotNull(r2);
        r3.c((fj0.a) r2);
    L8:
        LinkApplyType r4 = r5.d;
        if (r4 == null) goto L11;
        this.x = r4;
    L11:
        Integer r6 = r5.e;
        if (r6 == null) goto L14;
        Intrinsics.checkNotNull(r6);
        r0.K = r6.intValue();
    L14:
        String r7 = r5.g;
        if (r7 == null) goto L17;
        this.w = r7;
    L17:
        Boolean r8 = r5.h;
        if (r8 == null) goto L24;
        Intrinsics.checkNotNull(r8);
        boolean r9 = r8.booleanValue();
        yf6.b r10 = Yq();
        if (r10 == null) goto L24;
        vf6.a r11 = r10.a9();
        if (r11 == null) goto L24;
        r11.a = r9;
    L24:
        Boolean r12 = r5.i;
        if (r12 == null) goto L27;
        Intrinsics.checkNotNull(r12);
        this.z = r12.booleanValue();
    L27:
        Boolean r13 = r5.j;
        if (r13 == null) goto L30;
        Intrinsics.checkNotNull(r13);
        this.A = r13.booleanValue();
    L30:
        com.bytedance.android.live.liveinteract.plantform.model.g0 r14 = r5.k;
        if (r14 == null) goto L35;
        DataCenter r15 = ((Widget) this).dataCenter;
        if (r15 == null) goto L35;
        r15.put("data_link_mic_pos_tag_info", r14);
    L35:
        Boolean r16 = r5.l;
        if (r16 == null) goto L40;
        DataCenter r17 = ((Widget) this).dataCenter;
        if (r17 == null) goto L40;
        r17.put("data_link_mic_is_quick_invite", r16);
    L40:
        Long r18 = r5.m;
        if (r18 == null) goto L43;
        Intrinsics.checkNotNull(r18);
        this.V0 = r18.longValue();
    L43:
        Long r19 = r5.n;
        if (r19 == null) goto L46;
        Intrinsics.checkNotNull(r19);
        this.b1 = r19.longValue();
    L46:
        Long r20 = r5.o;
        if (r20 == null) goto L49;
        Intrinsics.checkNotNull(r20);
        this.g1 = r20.longValue();
    L49:
        Long r21 = r5.p;
        if (r21 == null) goto L52;
        Intrinsics.checkNotNull(r21);
        this.h1 = r21.longValue();
    L52:
        Long r22 = r5.q;
        if (r22 == null) goto L55;
        Intrinsics.checkNotNull(r22);
        this.y = r22.longValue();
    L55:
        Long r23 = r5.r;
        if (r23 == null) goto L58;
        Intrinsics.checkNotNull(r23);
        this.k1 = r23.longValue();
    L58:
        Long r24 = r5.s;
        if (r24 == null) goto L61;
        Intrinsics.checkNotNull(r24);
        this.p1 = r24.longValue();
    L61:
        String r25 = r5.t;
        if (r25 == null) goto L64;
        r0.f = r25;
    L64:
        Integer r26 = r5.u;
        if (r26 == null) goto L68;
        Intrinsics.checkNotNull(r26);
        r0.j = r26.intValue();
    L68:
        if (r5.v == null) goto L70;
        hd0.c r27 = hd0.c.f();
        Integer r28 = r5.v;
        Intrinsics.checkNotNull(r28);
        r27.g = r28.intValue();
    L70:
        Boolean r29 = r5.w;
        if (r29 == null) goto L73;
        Intrinsics.checkNotNull(r29);
        r0.C = r29.booleanValue();
    L73:
        Boolean r30 = r5.x;
        if (r30 == null) goto L76;
        int r31 = fj0.e.a;
        Intrinsics.checkNotNull(r30);
        fj0.e.n(r30.booleanValue());
    L76:
        Integer r32 = r5.y;
        if (r32 == null) goto L81;
        int r33 = com.bytedance.android.live.liveinteract.utils.h1.a;
        Intrinsics.checkNotNull(r32);
        int r34 = r32.intValue();
        com.bytedance.android.live.liveinteract.revenue.fight.b r35 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        if (r35 == null) goto L81;
        r35.q5(r34);
    L81:
        String r36 = r5.z;
        if (r36 == null) goto L84;
        this.E = r36;
    L84:
        String r37 = r5.A;
        if (r37 == null) goto L88;
        r0.F = r37;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void setDynamicAnimatorListener(Function0<Unit> r4) {
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(null, 0, 7) == false) goto L8;
        ih0.b r0 = MultiLinkDynamicContext.Companion.a(((Widget) this).dataCenter, null);
        if (r0 == null) goto L12;
        r0.setDynamicAnimatorListener(r4);
        return;
    L12:
        return;
    L8:
        tf0.o r1 = this.Z;
        if (r1 == null) goto L13;
        r1.setDynamicAnimatorListener(r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void setInviteCallback(uf0.c r1) {
        this.Q = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void setPermitCallback(uf0.d r1) {
        this.P = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void showFastMatchDialog(String r5) {
        if (s0.a(getMRoom()) == false) goto L7;
        ILinkPanelService r0 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r0 == null) goto L11;
        ILinkPanelService.a.a(r0, ((Widget) this).context, getMRoom(), null, r5);
        return;
    L11:
        return;
    L7:
        ChatMatchWidget r6 = this.N;
        if (r6 == null) goto L13;
        Intrinsics.checkNotNull(r6);
        r6.zq(null, false, "", Boolean.FALSE);
        return;
    }

    public final void sr(int r22) {
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L6;
        showInviteAndPermitDialog(false, "bottom", -1);
        return;
    L6:
        if (r22 == 0) goto L61;
        tf0.o r6 = null;
        if (r22 == 1) goto L30;
        if (r22 != 2) goto L86;
        ILinkPlayerInfoBridge r1 = Aq().p(je0.d.b0(), tc0.c.h().f);
        if (r1 == null) goto L20;
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r1.getSilenceStatus() == 0) goto L17;
        boolean r7 = true;
    L18:
        r3.put("data_self_is_silenced", Boolean.valueOf(r7));
        goto L20
    L17:
        r7 = false;
    L20:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isEnableTalkRoomEmoji() == false) goto L22;
        com.bytedance.android.live.liveinteract.videotalk.emoji.t r2 = new com.bytedance.android.live.liveinteract.videotalk.emoji.t();
        r2.e(((Widget) this).context);
        r2.f(((Widget) this).dataCenter);
        r2.g(true);
        Intrinsics.checkNotNullParameter("bottom", "requestPage");
        r2.d = "bottom";
        r2.c().a();
        return;
    L22:
        if (r1 == null) goto L28;
        com.bytedance.android.live.liveinteract.voicechat.dialog.p r4 = new com.bytedance.android.live.liveinteract.voicechat.dialog.p(((Widget) this).context, ((Widget) this).dataCenter, r1, false);
        r4.G = "bottom";
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L68;
        DialogLancet.handleBlockedDialogShow(r4);
        return;
    L68:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L63
    L27:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
        return;
    L28:
        jy0.b.c("ttlive_link", "try show dialog when user info is null", null, 4);
        return;
    L86:
        return;
    L30:
        if (com.bytedance.android.live.liveinteract.utils.h1.a() == false) goto L33;
        com.bytedance.android.live.liveinteract.utils.h1.f(this.v, ((Widget) this).context, ((Widget) this).dataCenter);
        return;
    L33:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.a.a(getMRoom()) == false) goto L40;
        ChatRoomGuestAppliedDialog r5 = new ChatRoomGuestAppliedDialog(((Widget) this).context, ((Widget) this).dataCenter, new l(this));
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L66;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L66:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L64
    L38:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        return;
    L40:
        if (s0.a(getMRoom()) == false) goto L48;
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L44;
        showInviteAndPermitDialog(false, "bottom", -1);
        return;
    L44:
        ILinkPanelService r8 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r8 == null) goto L80;
        ILinkPanelService.a.a(r8, ((Widget) this).context, getMRoom(), null, "bottom");
        return;
    L80:
        return;
    L48:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.a.b() == false) goto L56;
        tf0.o r9 = this.Z;
        if ((r9 instanceof VoiceCommonMultiLinkWindowManager) == false) goto L53;
        r6 = r9;
    L53:
        VoiceCommonMultiLinkWindowManager r10 = (VoiceCommonMultiLinkWindowManager) r6;
        if (r10 == null) goto L82;
        r10.q1(false, getMRoom());
        return;
    L82:
        return;
    L56:
        com.bytedance.android.live.liveinteract.voicechat.dialog.g r11 = new com.bytedance.android.live.liveinteract.voicechat.dialog.g(((Widget) this).context, ((Widget) this).dataCenter, getMRoom());
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L70;
        DialogLancet.handleBlockedDialogShow(r11);
        return;
    L70:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L65
    L60:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        return;
    L61:
        int r12 = bh0.a.a;
        sf0.a r13 = new sf0.a(-1, 102, LinkApplyType.NORMAL.getValue(), 0, LinkMatchType.NONE, "", "guest_tool_bar_click", 0, 0, 0, false, false, 0, null, null, 0, 524032);
        Intrinsics.checkNotNullParameter(r13, "applyParams");
        Wq(r13);
    }

    @Override // com.bytedance.android.live.multilink.voicechat.impl.widget.MultiLinkVoiceChatGuestPresenter.IView
    public final void t6(h1 r11) {
        Intrinsics.checkNotNullParameter(r11, "linkerMessage");
        if (isEngineOn() == true) goto L6;
        return;
    L6:
        if (r11.getLinkerEnlargeGuestInviteContent() != null) goto L8;
        return;
    L8:
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r1 = r11.getMessageId3();
        com.bytedance.android.livesdk.message.linker.k r3 = r11.getLinkerEnlargeGuestInviteContent();
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.j0(r1, r3);
        CPositionBeInvitedDialog r2 = this.g2;
        if (r2 == null) goto L19;
        Intrinsics.checkNotNull(r2);
        if (r2.isShowing() == false) goto L19;
        CPositionBeInvitedDialog r4 = this.g2;
        Intrinsics.checkNotNull(r4);
        r4.dismissAllowingStateLoss();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L19;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L19:
        FragmentActivity r6 = ContextUtil.contextToFragmentActivity(getContext());
        if (r6 == null) goto L36;
        int r7 = CPositionBeInvitedDialog.o;
        CPositionBeInvitedDialog.ShowType r8 = CPositionBeInvitedDialog.ShowType.Invite;
        long r9 = getMRoom().getRoomId();
        CPositionBeInvitedDialog.RoomType r10 = CPositionBeInvitedDialog.RoomType.Audio;
        com.bytedance.android.livesdk.message.linker.k r12 = r11.getLinkerEnlargeGuestInviteContent();
        if (r12 == null) goto L24;
        String r13 = com.bytedance.android.livesdk.message.linker.l.a(r12);
    L25:
        CPositionBeInvitedDialog r14 = CPositionBeInvitedDialog.a.a(r8, r9, r10, false, r13, r11, ((Widget) this).dataCenter);
        this.g2 = r14;
        Intrinsics.checkNotNull(r14);
        FragmentManager r15 = r6.getSupportFragmentManager();
        LandscapeRestrictionOperation r16 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r14, "VideoTalkCPositionBeInvitedDialog", r16);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r14, r16) == true) goto L37;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L29:
        r14.show(r15, "VideoTalkCPositionBeInvitedDialog");
        return;
    L37:
        return;
    L24:
        r13 = "0";
        goto L25
    }

    public final void tr(boolean r9) {
        jy0.b.d("voice_chat", "onIsSingerChanged " + r9 + " mute=" + Pq().isMute() + " shouldRestore=" + this.K + " isResumed=" + this.R + " rtcOn=" + isEngineOn());
        if (isEngineOn() == true) goto L6;
        return;
    L6:
        if (r9 == false) goto L54;
        IKtvService r3 = jc1.k.f(IKtvService.class);
        if (r3 == null) goto L10;
        boolean r4 = r3.isKtvComponentOpen();
    L12:
        if (r4 == false) goto L27;
        if (Pq().isMute() == false) goto L19;
        if (this.R == false) goto L19;
        com.bytedance.android.live.liveinteract.voicechat.b.a.a(Pq(), "force UnSilence", true, null, 8);
        this.K = true;
    L22:
        if (this.R == false) goto L24;
    L38:
        jg6.a r1 = Eq();
        if (r1 == null) goto L44;
        lh6.b r2 = r1.a();
        if (r2 == null) goto L44;
        ng6.c.a.a(r2, false);
    L44:
        if (this.s == null) goto L76;
        jy0.b.d("ttlive_link_rtc", "ktv singer startVideoCapture singMode:AUDIO");
        jg6.a r0 = Eq();
        if (r0 == null) goto L50;
        lh6.b r5 = r0.a();
        if (r5 == null) goto L50;
        r5.i("voicechatroom guestwidget ktv singer startVideoCapture");
    L50:
        hg6.g r6 = P2();
        if (r6 == null) goto L76;
        r6.e0("guestBecomeSinger AUDIO");
    L76:
        this.V = r9;
        if (com.bytedance.android.live.liveinteract.spatial.a.e(C0()) == false) goto L82;
        jy0.b.a("SpatialAudio_MultiLinkVoiceChatRoomGuestWidget", "onKtvSingerStateChanged updateSpatialAudioPosition------");
        tf0.o r10 = this.Z;
        if (r10 == null) goto L83;
        r10.u(Boolean.valueOf(isEngineOn()));
        return;
    L83:
        return;
    L82:
        return;
    L24:
        if (Pq().isMute() == false) goto L38;
        this.P0 = true;
    L19:
        if (this.V == true) goto L22;
        this.K = false;
        goto L22
    L27:
        if (Pq().isMute() == true) goto L36;
        if (Lq() != 0) goto L31;
    L33:
        boolean r7 = false;
    L34:
        if (r7 == false) goto L38;
    L31:
        if (Lq() == (-1)) goto L33;
        r7 = true;
    L36:
        if (this.R == false) goto L38;
        com.bytedance.android.live.liveinteract.voicechat.b.a.a(Pq(), "force UnSilence", true, null, 8);
        goto L38
    L10:
        r4 = false;
        goto L12
    L54:
        if (this.K == false) goto L64;
        Integer r8 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r8 != null) goto L59;
    L63:
        this.K = false;
        goto L64
    L59:
        if (r8.intValue() != 2) goto L63;
        Pq().s();
        if (this.R == true) goto L63;
        ((Widget) this).dataCenter.put("data_talk_room_capture_audio_notification_show_state", Boolean.FALSE);
    L64:
        jg6.a r11 = Eq();
        if (r11 == null) goto L70;
        lh6.b r12 = r11.a();
        if (r12 == null) goto L70;
        ng6.c.a.a(r12, true);
    L70:
        if (this.s == null) goto L76;
        jy0.b.d("ttlive_link_rtc", "ktv not singer stopVideoCapture");
        jg6.a r13 = Eq();
        if (r13 == null) goto L76;
        lh6.b r14 = r13.a();
        if (r14 == null) goto L76;
        r14.j("voicechatroom guestwidget ktv not singer stopVideoCapture");
        goto L76
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void tryFastMatch(String r5) {
        ChatMatchWidget r0 = this.N;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNull(r5);
        r0.zq(null, true, r5, Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.e
    public final void u(sf0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        Sq();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void updateFullScreenDialogShowStatus(boolean r3) {
        ALogger.i("MultiLinkVoiceChatRoomGuestWidget", "updateFullScreenDialogShowStatus isShow=" + r3 + ", isViewResumed=" + this.R);
        if (r3 == true) goto L5;
    L7:
        if (r3 == false) goto L9;
        return;
    L9:
        if (this.R == true) goto L14;
        onResume();
        return;
    L14:
        return;
    L5:
        if (this.R == false) goto L7;
        onPause();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void updatePosition(int r4) {
        if (aj0.b.c(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentUiLayout()) == false) goto L9;
        tf0.o r0 = this.Z;
        if (r0 == null) goto L8;
        ((CommonMultiLinkWindowManager) r0).X0(r4);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager");
    L9:
        tf0.o r1 = this.Z;
        if ((r1 instanceof VoiceCommonMultiLinkWindowManager) == true) goto L12;
        r1 = null;
    L12:
        VoiceCommonMultiLinkWindowManager r2 = (VoiceCommonMultiLinkWindowManager) r1;
        if (r2 == null) goto L17;
        r2.x1(r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final boolean userIsCPosition(String r4) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        if (Aq().c.isEmpty() == true) goto L19;
        Iterator<ILinkPlayerInfoBridge> r0 = Aq().c.iterator();
    L6:
        if (r0.hasNext() == false) goto L29;
        ILinkPlayerInfoBridge r1 = r0.next();
        if (r1.isEnlarged() == false) goto L6;
        if (r1.getBaseUser() == null) goto L6;
        IBaseUser r2 = r1.getBaseUser();
        if (r2 == null) goto L14;
        String r3 = r2.getIdString();
    L16:
        if (Intrinsics.areEqual(r3, r4) == false) goto L6;
        return true;
    L14:
        r3 = null;
        goto L16
    L29:
        return false;
    L19:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.voicechat.e
    public final void w(g1 r1) {
        super.w(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wf(String r2) {
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.x2;
        if (r0 == null) goto L6;
        r0.l(r2);
        return;
    }

    public MultiLinkVoiceChatRoomGuestWidget(w0 r2, gd0.p r3) {
        Intrinsics.checkNotNullParameter(r3, "liveCycleCallback");
        super(tc0.c.h());
        this.c3 = r2;
        this.d3 = r3;
        new LinkedHashMap();
        this.k0 = new com.bytedance.android.live.liveinteract.api.utils.j(this, this);
        this.p1 = -1;
        this.x1 = CollectionsKt.emptyList();
        this.T1 = new cj0.l();
        this.V1 = new cj0.e(false);
        this.E2 = CollectionsKt.emptyList();
        this.F2 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u();
        this.G2 = new k(this);
        this.S2 = new com.bytedance.android.live.liveinteract.utils.k0();
        this.T2 = new ArrayList();
        this.U2 = new ArrayList();
        this.W2 = new j(this);
        this.Y2 = new o(this);
        this.b3 = LazyKt.lazy(new MultiLinkVoiceChatRoomGuestWidget$multiLinkLayoutService$2(this));
    }

    public static boolean yr(int r5, int r6) {
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L10;
        if (r5 == 5) goto L6;
        if (r5 == 16) goto L6;
        return false;
    L6:
        if (r6 == 5) goto L8;
        if (r6 == 16) goto L8;
        return false;
    L8:
        return true;
    L10:
        if (r5 != 5) goto L12;
        if (r6 != 16) goto L12;
    L14:
        return true;
    L12:
        if (r5 != 16) goto L18;
        if (r6 == 5) goto L14;
        return false;
    L18:
        return false;
    }

    @Override // com.bytedance.android.live.multilink.voicechat.impl.widget.MultiLinkVoiceChatGuestPresenter.IView
    public final boolean D4(int r5, f6 r6) {
        Intrinsics.checkNotNullParameter(r6, "guideInfo");
        if (Aq().b() < r5) goto L6;
        jy0.b.a("ttlive_link", "intercept guide since online count hits limit");
        return false;
    L6:
        GuestTalkBeInvitedDialog r7 = this.L;
        if (r7 == null) goto L13;
        Intrinsics.checkNotNull(r7);
        if (r7.isShowing() == false) goto L13;
        jy0.b.a("ttlive_link", "intercept guide since guest is being invited");
        return false;
    L13:
        if (isKtvOn() == false) goto L15;
        return false;
    L15:
        Iterator r8 = r6.getInfoItems().iterator();
    L17:
        if (r8.hasNext() == false) goto L23;
        g6 r0 = (g6) r8.next();
        if (r0 == null) goto L17;
        if (TextUtils.isEmpty(r0.getContent()) == true) goto L17;
        boolean r9 = true;
    L24:
        if (r9 == false) goto L26;
    L28:
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L32;
        r10.put("data_audio_talk_show_guide", r6);
    L32:
        if (this.I == null) goto L34;
        LinkedHashMap r11 = new LinkedHashMap();
        com.bytedance.android.livesdk.log.j0.l().sendLog("anchor_head_toast_show", r11, new Object[]{IRoom.class});
    L34:
        return true;
    L26:
        if (this.Z == null) goto L28;
        return true;
    L23:
        r9 = false;
        goto L24
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.a
    public final void G4(boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        if (this.s != null) goto L5;
        return;
    L5:
        if (r6 == false) goto L20;
        jg6.a r8 = Eq();
        if (r8 == null) goto L17;
        kg6.e r9 = r8.b();
        if (r9 == null) goto L17;
        if (je0.d.G() == false) goto L13;
    L15:
        boolean r4 = false;
    L16:
        r9.t(new kg6.b(true, r4, r7, 8));
        goto L17
    L13:
        if (je0.d.p() == true) goto L15;
        r4 = true;
    L17:
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L28;
        r10.put("data_self_is_silenced", Boolean.TRUE);
    L28:
        VoiceChatMuteManager r11 = Pq();
        r11.i = System.currentTimeMillis();
        return;
    L20:
        jg6.a r12 = Eq();
        if (r12 == null) goto L25;
        kg6.e r13 = r12.b();
        if (r13 == null) goto L25;
        r13.z(new kg6.d(true, true, r7, 8));
    L25:
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L28;
        r14.put("data_self_is_silenced", Boolean.FALSE);
        goto L28
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void T6(String r1, zf2.s0 r2) {
        com.bytedance.android.live.liveinteract.plantform.utils.u r3 = this.x2;
        if (r3 == null) goto L6;
        r3.m(r1);
        return;
    }

    public final void Zq(ye0.a r7, int r8) {
        long r0 = System.currentTimeMillis();
        Disposable r9 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).applyStash(getMRoom().getRoomId(), 1, r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.multilink.voicechat.impl.widget.q(r7, r0), new com.bytedance.android.live.multilink.voicechat.impl.widget.r(r7, r0));
        this.S.add(r9);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void accept(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "secUid");
        IBaseUser r0 = (IBaseUser) vh7.f.c(IBaseUser.class);
        r0.setIdString(r2);
        Intrinsics.checkNotNullParameter(r0, "$this$secUidExt");
        r0.setCastSecUid(r3);
        accept(r0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void al(String r2, int r3) {
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.x2;
        if (r0 == null) goto L6;
        r0.n(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void applyVoiceTalk(String r21, LinkApplyType r22) {
        if (r21 != null) goto L5;
        String r18 = "";
    L7:
        if (r22 == null) goto L9;
        int r0 = r22.getValue();
    L10:
        sf0.a r7 = new sf0.a(0, 0, r0, 0, null, null, r18, 0, 0, 0, false, false, 0, null, null, 0, 524155);
        Intrinsics.checkNotNullParameter(r7, "applyParams");
        Wq(r7);
        return;
    L9:
        r0 = LinkApplyType.NORMAL.getValue();
        goto L10
    L5:
        r18 = r21;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void closeMultiEnlargePosition(long r6, List<String> r8) {
        Intrinsics.checkNotNullParameter(r8, "kickOutUserIdList");
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r0.append(r9.next() + ',');
        goto L4
    L6:
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        String r1 = r0.toString();
        r10.element = r1;
        if (StringsKt.endsWith$default(r1, ",", false, 2, null) == false) goto L13;
        String r2 = (String) r10.element;
        int r3 = r2.length() - 1;
        if (r2 == null) goto L12;
        r10.element = r2.substring(0, r3);
        goto L13
    L12:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L13:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r4 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.W(false, "all_cancel");
        TalkRoomBusinessFullLinkMonitor r5 = TalkRoomBusinessFullLinkMonitor.a;
        String r7 = (String) r10.element;
        r5.getClass();
        TalkRoomBusinessFullLinkMonitor.p(r7);
        long r11 = System.currentTimeMillis();
        LinkAudienceApi r12 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        String r13 = (String) r10.element;
        this.S.add(r12.closeCPosition(r6, r13, r13).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r10, r11), new c(this, r10, r11)));
    }

    @Override // tf0.o.a
    public final void d0(tf0.p r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        ne0.c r0 = this.v;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        r0.d0(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void e1(String r1, long r2) {
        Aq().getClass();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final boolean interceptCloseRoomV2(Runnable r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "runnable");
        String r7 = ChatMatchWidget.o;
        ChatMatchViewModel r8 = (ChatMatchViewModel) com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class);
        if (r8 == null) goto L5;
        MutableLiveData<b1> r1 = r8.getMatchData();
    L7:
        if (r1 != null) goto L9;
    L11:
        mz0.f r9 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if ((r9 instanceof mz0.f) == false) goto L23;
        mz0.f r10 = r9;
        String r2 = r10.d();
        if (r2 != null) goto L16;
    L18:
        String r11 = r10.l();
        if (r11 == null) goto L23;
        if (TextUtils.equals(r11, "true") == false) goto L23;
        return false;
    L16:
        if (TextUtils.equals(r2, "true") == false) goto L18;
        return false;
    L23:
        jy0.b.c("MultiLinkVoiceChatRoomGuestWidget", "intercept close room: online state = " + ((Integer) ((ge1.a) hd0.c.f()).b), null, 4);
        Integer r12 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r12 != null) goto L27;
    L28:
        Integer r13 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r13 != null) goto L32;
    L35:
        return false;
    L32:
        if (2 != r13.intValue()) goto L35;
        x0.b r14 = new x0.b(getContext(), 4);
        r14.l(2131919394);
        r14.i(0, 2131920806, new h(this, r5));
        r14.i(1, 2131915442, i.a);
        r14.n();
        return true;
    L27:
        if (r12.intValue() == 0) goto L35;
    L9:
        if (r8.getMatchData().getValue() == null) goto L11;
        return false;
    L5:
        r1 = null;
        goto L7
    }

    @Override // md0.a.InterfaceC0236a
    public final boolean isVersionSupported(int r1, int r2) {
        if (r1 != 3) goto L5;
    L8:
        return true;
    L5:
        if (aj0.b.b(Integer.valueOf(r1)) == true) goto L8;
        return false;
    }

    @Override // tf0.o.a
    public final void kd(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        jy0.b.a(LinkRoomFightContext.TAG, "livecore version " + ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).getLiveCoreVersion());
        StringBuilder r0 = new StringBuilder("stopPlayPublicStream isEngineOn: ");
        hg6.g r2 = P2();
        Integer r3 = null;
        if (r2 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r2.isEngineOn());
    L6:
        r0.append(r4);
        r0.append(" id ");
        r0.append(r5);
        jy0.b.a(LinkRoomFightContext.TAG, r0.toString());
        if (r5 != null) goto L9;
        return;
    L9:
        hg6.g r1 = P2();
        if (r1 == null) goto L14;
        xi0.b r7 = r1.O();
        if (r7 == null) goto L14;
        r3 = Integer.valueOf(r7.k(r5));
    L14:
        zi0.b.f(r5, r3, r6);
        jy0.b.a(LinkRoomFightContext.TAG, "stopPlayPublicStream result " + r3);
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void logChatMatchShow(String r2, boolean r3) {
        String r0 = ChatMatchWidget.o;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        ChatMatchWidget.o = r2;
        if (r3 == false) goto L5;
        LinkMatchType r4 = LinkMatchType.SING_MATCH;
    L6:
        String r5 = r4.getValue();
        new gk0.a(getMRoom()).c(r5);
        return;
    L5:
        r4 = LinkMatchType.MATCH;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void logKtvCameraOperation(String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "clickType");
        com.bytedance.android.live.liveinteract.voicechat.util.k r1 = this.I;
        if (r1 == null) goto L6;
        r1.D(r9, r10, this.w, Nq(), this.E, wr());
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void onChangeMediaInfo(ILinkerChangeMediaInfoContent r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "info");
        ILinkmicMediaParam r0 = r4.getLinkmicMediaParam();
        if (r0 != null) goto L5;
        return;
    L5:
        List r6 = r4.getPlayModeList();
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.isEmpty() == false) goto L10;
        return;
    L10:
        if (r6.contains(21) == false) goto L31;
        r0 r7 = r0.getKtvComponentMediaInfo();
        if (r7 == null) goto L14;
        String r1 = r7.getLiveCoreExtInfo();
    L15:
        if (r1 == null) goto L32;
        if (r5 <= 0) goto L20;
        hg6.g r2 = P2();
        if (r2 == null) goto L20;
        r2.I(r5);
    L20:
        hg6.g r8 = P2();
        if (r8 == null) goto L23;
        r8.J(r7.getLiveCoreExtInfo());
    L23:
        hg6.g r9 = P2();
        if (r9 == null) goto L26;
        ig6.a r10 = r9.x();
    L27:
        Intrinsics.checkNotNull(r10);
        r10.a(MultiLinkInfoType.KTV_COMPONENT, new ig6.b(r7.getLiveCoreExtInfo(), null));
        return;
    L26:
        r10 = null;
        goto L27
    L32:
        return;
    L14:
        r1 = null;
        goto L15
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void onSei(String r10, ye1.a r11) {
        Intrinsics.checkNotNullParameter(r10, "sei");
        Intrinsics.checkNotNullParameter(r11, "info");
        if (((Widget) this).isViewValid == true) goto L6;
        return;
    L6:
        if (isEngineOn() == true) goto L59;
        this.k0.e(r10, r11);
        HamletAvatarWidget r2 = this.M2;
        if (r2 == null) goto L60;
        Intrinsics.checkNotNullParameter(r10, "sei");
        Intrinsics.checkNotNullParameter(r11, "info");
        com.bytedance.android.live.liveinteract.hamlet.model.l r5 = null;
        if (StringsKt.contains$default(r10, "app_data", false, 2, null) == false) goto L57;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L54
        r2.Zq(Integer.valueOf(new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(LiveSeiUtil.c(r10), "app_data"), "")).optInt("sub_ui_layout")));     // Catch: Exception -> L54
    L57:
    L51:
        e = move-exception;
        ALogger.e("HamletAvatar", "onAudienceSei excetion=" + Log.getStackTraceString(e));
        return;
    L14:
        if (StringsKt.contains$default(r10, "hamlet_avatar_sei", false, 2, null) == true) goto L17;
        return;
    L17:
        if (r11.a == true) goto L19;
    L20:
        JSONObject r12 = new JSONObject(r10);     // Catch: Exception -> L51
        if (r12.has("hamlet_avatar_sei") == false) goto L63;
        JSONObject r13 = r12.optJSONObject("hamlet_avatar_sei");     // Catch: Exception -> L51
        Gson r14 = GsonHelper.get();     // Catch: Exception -> L51
        if (r13 == null) goto L25;
        String r15 = r13.toString();     // Catch: Exception -> L51
    L26:
        com.bytedance.android.live.liveinteract.hamlet.model.m r16 = (com.bytedance.android.live.liveinteract.hamlet.model.m) r14.fromJson(r15, com.bytedance.android.live.liveinteract.hamlet.model.m.class);     // Catch: Exception -> L51
        if (r16 == null) goto L42;
        com.bytedance.android.live.liveinteract.hamlet.model.l r17 = r16.b();     // Catch: Exception -> L51
        if (r17 == null) goto L42;
        HamletAvatarContext r0 = r2.f;     // Catch: Exception -> L51
        if (r0 == null) goto L36;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.liveinteract.hamlet.model.l> r1 = r0.getChestPosition();     // Catch: Exception -> L51
        if (r1 == null) goto L36;
        r5 = (com.bytedance.android.live.liveinteract.hamlet.model.l) r1.getValue();     // Catch: Exception -> L51
    L36:
        if (com.bytedance.android.live.liveinteract.hamlet.model.o.a(r17, r5) == true) goto L42;
        HamletAvatarContext r3 = r2.f;     // Catch: Exception -> L51
        if (r3 == null) goto L42;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.liveinteract.hamlet.model.l> r4 = r3.getChestPosition();     // Catch: Exception -> L51
        if (r4 == null) goto L42;
        r4.setValue(r17);     // Catch: Exception -> L51
    L42:
        if (r16 == null) goto L64;
        String r6 = r16.a();     // Catch: Exception -> L51
        if (r6 == null) goto L65;
        List r18 = (List) GsonHelper.get().fromJson(StringsKt.replace$default(r6, "\\", "", false, 4, null), new com.bytedance.android.live.liveinteract.hamlet.z().getType());     // Catch: Exception -> L51
        HamletAvatarContext r19 = r2.f;     // Catch: Exception -> L51
        if (r19 == null) goto L66;
        com.bytedance.live.datacontext.n<List<com.bytedance.android.live.liveinteract.hamlet.model.k>> r110 = r19.getHamletAvatarUserInfos();     // Catch: Exception -> L51
        if (r110 == null) goto L67;
        r110.setValue(r18);     // Catch: Exception -> L51
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L64:
        return;
    L25:
        r15 = null;
        goto L26
    L63:
        return;
    L19:
        if (MultiLinkBizBackupSeiExperimentUtils.INSTANCE.isKtvAllInEnable(r11.g, r2.l) == true) goto L20;
        return;
    L60:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void openEmojiDialog(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "toUserId");
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        ILinkPlayerInfoBridge r8 = Aq().o(r6, "");
        Context r1 = ((Widget) this).context;
        DataCenter r2 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r8, "userInfo");
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        if (hg6.i.a() == false) goto L5;
        ih0.d r0 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r8, r7, false);
    L9:
        r0.a();
        return;
    L5:
        VoiceChatInteractEmojiPanel r3 = new VoiceChatInteractEmojiPanel(r1, r2, r8);
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r3.k = r7;
        r3.r = false;
        tb6.c r9 = r3.x;
        if (r9 == null) goto L8;
        r9.a();
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        r9.d = r7;
    L8:
        r0 = r3;
        goto L9
    }

    public final void pr(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "interactId");
        Intrinsics.checkNotNullParameter("room battle mcu", "reason");
        jg6.a r5 = Eq();
        if (r5 == null) goto L7;
        kg6.e r6 = r5.b();
        if (r6 == null) goto L7;
        r6.h(r3, true, "room battle mcu");
    L7:
        hg6.g r7 = P2();
        if (r7 == null) goto L11;
        r7.f();
        return;
    }

    public final void qr(zj0.f r12, zj0.f.b r13) {
        int r1 = r13.a;
        int r2 = r13.b;
        List<Integer> r3 = u0.d();
        if (r12 == null) goto L5;
        int r4 = r12.a;
    L6:
        if (r12 == null) goto L8;
        int r5 = r12.b;
    L9:
        if (r12 == null) goto L14;
        List<Integer> r14 = r12.h;
        if (r14 == null) goto L14;
        List r15 = CollectionsKt.toList(r14);
        if (r15 == null) goto L14;
    L15:
        List r6 = r15;
        nh0.e r10 = new nh0.e(r1, r2, r3, r4, r5, r6, null, null, 192);
        String r7 = "linkmic";
        List r8 = null;
        sf0.b r9 = null;
        JsonObject r11 = null;
        nh0.f r16 = new nh0.f(r7, r10, r8, r9, r11, null, false, 224);
        int r17 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r18 = ((Widget) this).dataCenter;
        IRoom r0 = getMRoom();
        if (r0 == null) goto L18;
        Long r19 = Long.valueOf(r0.getId());
    L19:
        MultiSceneEnterRoomStatisticsUtils r110 = MultiSceneEnterRoomStatisticsUtils.a.a(r18, Long.valueOf(r19.longValue()));
        if (r110 == null) goto L22;
        r110.c();
    L22:
        System.currentTimeMillis();
        ((Widget) this).dataCenter.put("data_multi_lick_dynamic_event_change", r16);
        return;
    L18:
        r19 = null;
    L14:
        r15 = CollectionsKt.emptyList();
        goto L15
    L8:
        r5 = -1;
        goto L9
    L5:
        r4 = -1;
        goto L6
    }

    public final void rr(int r4, int r5) {
        jy0.b.d("[VoiceTalk]BaseLiveBackground", "widget, observeWindowDraw, targetScene = " + r4 + ", targetUILayout = " + r5);
        if (((Boolean) vm2.d.L0.getValue(null, vm2.d.a[87])).booleanValue() == false) goto L8;
        Disposable r6 = Observable.timer(5, TimeUnit.SECONDS).subscribe(new com.bytedance.android.live.multilink.voicechat.impl.widget.a0(this));
        if (r6 == null) goto L8;
        RxUtilKt.c(r6, this.S);
    L8:
        if (r4 == 5) goto L10;
        return;
    L10:
        if (vm2.d.q0().isOpenSmoothViewMock() == false) goto L16;
        jy0.b.d("[VoiceTalk]BaseLiveBackground", "widget, observeWindowDraw, put observeWindowDraw_immediately");
        boolean r7 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(Integer.valueOf(cr()), 0, 6) == true) goto L17;
        ((Widget) this).dataCenter.put("cmd_voice_chat_room_show_background", new p2("observeWindowDraw_immediately"));
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.voicechat.e
    public final void t(sf0.a r2, IApplyResult r3) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        Intrinsics.checkNotNullParameter(r3, "applyResult");
        super.t(r2, r3);
    }

    public final <T> void vr(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J(String[] r2, boolean[] r3, int[] r4) {
        tf0.o r0 = this.Z;
        if (r0 == null) goto L5;
        r0.onTalkStateUpdated(r2, r3);
    L5:
        this.S2.a(r2, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.e
    public final void M(boolean r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter("bottom", "requestPage");
        Intrinsics.checkNotNullParameter("bottom", "requestPage");
        tf0.o r5 = Qq();
        if (r5 == null) goto L6;
        r5.M(false, "bottom", -1);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void cancelApply(h80.a<Boolean> r2, boolean r3, String r4) {
        yf6.b r5 = Yq();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r5.e(new wf6.a(r4, 1));
    }

    @Override // tf0.o.a
    public final void h(String r1, boolean r2, String r3) {
        pr(r1, true);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void onProfileCardClick(String r22, int r23, String r24) {
        Intrinsics.checkNotNullParameter(r22, "requestPage");
        Intrinsics.checkNotNullParameter(r24, "from");
        Integer r2 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r2 != null) goto L6;
    L8:
        if (r2 != null) goto L11;
    L13:
        if (r2 != null) goto L16;
        return;
    L16:
        if (r2.intValue() != 0) goto L21;
        sf0.a r3 = new sf0.a(-1, r23, LinkApplyType.NORMAL.getValue(), 0, null, null, null, 0, 0, 0, false, false, 0, null, null, 0, 524280);
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r3.h = r24;
        Intrinsics.checkNotNullParameter(r3, "applyParams");
        Wq(r3);
        return;
    L21:
        return;
    L11:
        if (r2.intValue() != 1) goto L13;
        sr(1);
        return;
    L6:
        if (r2.intValue() != 2) goto L8;
        f2.b(2131923214, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void replyCPosition(long r15, String r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r17, "toUid");
        long r9 = System.currentTimeMillis();
        LinkAudienceApi r0 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        long r3 = d5.c(r17);
        if (r18 == false) goto L5;
        CPositionReplyType r1 = CPositionReplyType.Accept;
    L6:
        Disposable r2 = r0.replyCPosition(r15, r3, r17, r1.getValue()).compose(RxUtil.rxSchedulerHelper()).subscribe(new c0(r17, r18, r9), new d0(r17, r18, r9, r15));
        this.S.add(r2);
        return;
    L5:
        r1 = CPositionReplyType.Reject;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void showInviteAndPermitDialog(boolean r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "requestPage");
        showInviteAndPermitDialog(r2, r3, r4, "");
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void showInviteDialog(boolean r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "requestPage");
        showInviteDialog(r2, r3, r4, "");
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void updateSelfMuteStatus(boolean r3, boolean r4, MediaOperation.a r5) {
        if (r3 == false) goto L5;
        Pq().b("self_panel", r5);
        return;
    L5:
        com.bytedance.android.live.liveinteract.voicechat.b.a.a(Pq(), "self_panel", false, r5, 8);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.voicechat.e
    public final void v(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "from");
        super.v(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void checkAndApply(int r20, String r21, int r22, String r23) {
        Intrinsics.checkNotNullParameter(r21, "applySource");
        Intrinsics.checkNotNullParameter(r23, "fromSource");
        sf0.a r14 = new sf0.a(r20, d5.b(r21), r22, 0, null, null, r23, 0, 0, 0, false, false, 0, null, null, 0, 524152);
        Intrinsics.checkNotNullParameter(r14, "applyParams");
        Wq(r14);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void checkAndApplyFromH5(String r20, int r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r20, "applySource");
        Intrinsics.checkNotNullParameter(r22, "taskName");
        Intrinsics.checkNotNullParameter(r23, "fromSource");
        sf0.a r15 = new sf0.a(0, d5.b(r20), r21, 0, null, r22, r23, 0, 0, 0, false, false, 0, null, null, 0, 524089);
        Intrinsics.checkNotNullParameter(r15, "applyParams");
        Wq(r15);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void checkAndReply(long r12, String r14, String r15, int r16) {
        Intrinsics.checkNotNullParameter(r14, "secToUserId");
        Intrinsics.checkNotNullParameter(r15, "toUserIdString");
        cg6.a r0 = Bq();
        if (r0 == null) goto L8;
        MultiLinkGuestManager r1 = r0.W4();
        if (r1 == null) goto L9;
        r1.j(new sf0.e(r12, r14, r15, r16, 0, 48, 0));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h1(String r1, SurfaceView r2, int r3, int r4) {
        tf0.o r5 = this.Z;
        if (r5 == null) goto L6;
        r5.b(r1);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void setCPosition(long r17, String r19, boolean r20, String r21) {
        Intrinsics.checkNotNullParameter(r19, "toUid");
        Intrinsics.checkNotNullParameter(r21, "enlargeTypeForLog");
        if (r20 == false) goto L5;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r2 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.X(false, r19, r21);
    L10:
        long r11 = System.currentTimeMillis();
        if (cr() != 28) goto L13;
        long r0 = oe0.d.b();
    L14:
        long r13 = r0;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.s(r19, r20, r13);
        LinkAudienceApi r1 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        long r3 = d5.c(r19);
        if (r20 == false) goto L17;
        int r6 = 1;
    L18:
        Disposable r4 = r1.setCPosition(r17, r3, r19, r6, r13).compose(RxUtil.rxSchedulerHelper()).subscribe(new e0(r19, r20, r13, r11), new f0(r19, r20, r13, r11));
        this.S.add(r4);
        return;
    L17:
        r6 = 2;
        goto L18
    L13:
        r0 = CPositionToEnlargePosition.Default.getValue();
        goto L14
    L5:
        boolean r5 = Intrinsics.areEqual(r19, je0.d.a());
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r7 = TalkRoomLogUtils.a;
        if (r5 == false) goto L8;
        String r8 = "anchor";
    L9:
        TalkRoomLogUtils.W(false, r8);
        goto L10
    L8:
        r8 = "guest";
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void showInviteAndPermitDialog(boolean r11, String r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "requestPage");
        Intrinsics.checkNotNullParameter(r14, "taskName");
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == true) goto L8;
    L16:
        if (r11 == true) goto L18;
        return;
    L18:
        if (this.I == null) goto L22;
        com.bytedance.android.live.liveinteract.voicechat.util.k.d("administrator");
        return;
    L22:
        return;
    L8:
        if (this.L1 == true) goto L16;
        ((Widget) this).dataCenter.put("data_task_name_when_open_invite_panel", r14);
        ILinkPanelService r2 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r2 == null) goto L12;
        r2.C70(((Widget) this).context, ((Widget) this).dataCenter, 0, r12, r13, getMRoom(), this);
    L12:
        ILinkPanelService r15 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r15 == null) goto L15;
        r15.setOnDismissListener(new i0(this));
    L15:
        this.L1 = true;
        goto L16
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void showInviteDialog(boolean r8, String r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "requestPage");
        Intrinsics.checkNotNullParameter(r11, "taskName");
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (this.L1 == true) goto L9;
        ((Widget) this).dataCenter.put("data_task_name_when_open_invite_panel", r11);
        ILinkPanelService r1 = com.bytedance.android.live.liveinteract.component.b.a();
        Intrinsics.checkNotNull(r1);
        r1.ad(((Widget) this).context, ((Widget) this).dataCenter, r9, r10, this);
        ILinkPanelService r12 = com.bytedance.android.live.liveinteract.component.b.a();
        Intrinsics.checkNotNull(r12);
        r12.setOnDismissListener(new j0(this));
        this.L1 = true;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void updateMultiEnlargePosition(long r16, String r18, long r19, String r21) {
        Intrinsics.checkNotNullParameter(r18, "targetUserId");
        Intrinsics.checkNotNullParameter(r21, "enlargeTypeForLog");
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r0 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.X(false, r18, r21);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.s(r18, true, r19);
        long r13 = System.currentTimeMillis();
        Disposable r1 = ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).setCPosition(r16, d5.c(r18), r18, CPositionInviteType.Enlarge.getValue(), r19).compose(RxUtil.rxSchedulerHelper()).subscribe(new k0(r18, r19, r13, r21), new l0(r18, r19, r13));
        this.S.add(r1);
    }

    @Override // wn0.a.b
    public final void Ef(zj0.f r19, zj0.f.b r20, List r21, List r22, zj0.c r23) {
        Intrinsics.checkNotNullParameter(r20, "to");
        Intrinsics.checkNotNullParameter(r23, "switchType");
        if (r19 != null) goto L5;
        return;
    L5:
        int r12 = r19.a;
        int r8 = r19.b;
        int r9 = r20.a;
        nr(r12, r8, r9, r20.b, r21, r22);
        if (r9 != 16) goto L8;
        zi0.e r1 = zi0.b.d;
        com.bytedance.android.livesdk.utils.ntp.e.a();
        r1.getClass();
    L8:
        boolean r2 = true;
        if (jc1.k.f(IInteractService.class) != null) goto L11;
    L15:
        boolean r3 = false;
    L16:
        if (r12 != 0) goto L18;
        if (r3 == true) goto L18;
        return;
    L18:
        if (r9 == 0) goto L23;
        if (r12 == 16) goto L22;
        if (r9 != 16) goto L23;
    L22:
        r2 = false;
    L23:
        if (r2 == true) goto L25;
    L53:
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L58;
        r0.put("data_enter_room_is_quick_invite", Boolean.FALSE);
        return;
    L58:
        return;
    L25:
        if (this.I == null) goto L53;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r4 = TalkRoomLogUtils.a;
        String r14 = TalkRoomLogUtils.j;
        HashMap<String, String> r5 = new HashMap();
        if (vm2.h.R() == false) goto L29;
        r5.put("room_id", String.valueOf(getMRoom().getId()));
        r5.put("anchor_id", String.valueOf(getMRoom().getAnchorId()));
        LiveMode r6 = getMRoom().getStreamType();
        int r7 = com.bytedance.android.live.core.utils.h1.a;
        r5.put("live_type", com.bytedance.android.live.core.utils.i1.a(r6));
    L29:
        com.bytedance.android.live.liveinteract.voicechat.util.k r10 = this.I;
        if (r10 == null) goto L44;
        long r11 = fr();
        Integer r13 = Integer.valueOf(r8);
        if (getMRoom() == null) goto L34;
        ICircleInfo r15 = getMRoom().getCircleInfo();
    L35:
        tf0.o r16 = this.Z;
        if (r16 == null) goto L38;
        boolean r17 = r16.J();
    L39:
        int r18 = com.bytedance.android.live.liveinteract.utils.h1.a;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.d r24 = MultiRevenueDataContext.a.f();
        if (r24 == null) goto L42;
        li0.b.a r110 = r24.g4();
    L43:
        r10.q(r5, r11, r12, r13, r14, r15, r17, r110);
        goto L44
    L42:
        r110 = null;
        goto L43
    L38:
        r17 = false;
        goto L39
    L34:
        r15 = null;
    L44:
        long r25 = Math.max(this.h1, this.b1);
        long r26 = 0;
        if (r25 != 0) goto L47;
        long r27 = 0;
    L48:
        TalkRoomLogUtils.p0(r5, Long.valueOf(r27));
        long r28 = Math.max(this.h1, this.g1);
        if (r28 == 0) goto L52;
        r26 = (System.currentTimeMillis() - r28) / ((long) 1000);
    L52:
        TalkRoomLogUtils.q0(r5, Long.valueOf(r26));
        goto L53
    L47:
        r27 = (System.currentTimeMillis() - r25) / ((long) 1000);
        goto L48
    L11:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getInteractFloatWindowService() == null) goto L15;
        ((com.bytedance.android.live.liveinteract.service.g) ((IInteractService) jc1.k.n(IInteractService.class)).getInteractFloatWindowService()).getClass();
        if (xe0.j.d() == false) goto L15;
        r3 = true;
        goto L16
    }

    @Override // wn0.a.b
    public final void Lk(zj0.f r17, zj0.f.b r18, List r19, List r20, zj0.c r21) {
        Intrinsics.checkNotNullParameter(r18, "to");
        Intrinsics.checkNotNullParameter(r21, "switchType");
        int r10 = r18.a;
        int r11 = r18.b;
        if (r10 != 0) goto L5;
        if (r11 != 0) goto L5;
    L6:
        tf0.o r0 = this.Z;
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r12 = null;
        if (r0 == null) goto L9;
        tf0.j r1 = r0.getLinkWindowLayoutConfig();
    L11:
        if ((r1 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.m) == true) goto L13;
        r1 = null;
    L13:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.m) r1;
        if (r2 == null) goto L18;
        com.bytedance.android.live.liveinteract.plantform.utils.u r3 = this.x2;
        if (r3 == null) goto L18;
        r3.u(r2);
    L18:
        if (r17 != null) goto L30;
        int r13 = r18.a;
        int r14 = r18.b;
        HashMap<String, String> r15 = new HashMap();
        lr(0, 0, r13, r14, r19, r20);
        com.bytedance.android.live.liveinteract.voicechat.util.k r4 = this.I;
        if (r4 == null) goto L27;
        if (getMRoom() == null) goto L24;
        ICircleInfo r5 = getMRoom().getCircleInfo();
    L25:
        r4.p(r15, r13, r14, r5);
        goto L27
    L24:
        r5 = null;
    L27:
        if (((Boolean) vm2.h.W5.getValue(null, vm2.h.a[359(0x167, float:5.03E-43)])).booleanValue() == false) goto L127;
        qr(r17, r18);
        return;
    L127:
        return;
    L30:
        int r16 = r17.a;
        int r110 = r17.b;
        Integer r6 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r6 != null) goto L34;
    L36:
        lr(r16, r110, r10, r11, r19, r20);
        if (r10 == 0) goto L77;
        int r7 = br();
        if (r16 != 0) goto L42;
    L40:
        boolean r8 = true;
    L45:
        if (r8 == false) goto L77;
        if (this.I == null) goto L77;
        HashMap<String, String> r9 = new HashMap();
        if (vm2.h.R() == false) goto L51;
        r9.put("room_id", String.valueOf(getMRoom().getId()));
        r9.put("anchor_id", String.valueOf(getMRoom().getAnchorId()));
        LiveMode r22 = getMRoom().getStreamType();
        int r23 = com.bytedance.android.live.core.utils.h1.a;
        r9.put("live_type", com.bytedance.android.live.core.utils.i1.a(r22));
    L51:
        com.bytedance.android.live.liveinteract.voicechat.util.k r24 = this.I;
        if (r24 != null) goto L54;
    L58:
        com.bytedance.android.live.liveinteract.voicechat.util.k r25 = this.I;
        if (r25 == null) goto L66;
        if (getMRoom() == null) goto L63;
        ICircleInfo r26 = getMRoom().getCircleInfo();
    L64:
        r25.p(r9, r10, r11, r26);
        goto L66
    L63:
        r26 = null;
    L66:
        if (Intrinsics.areEqual(MultiLinkOpenSource.SYNC_ROOM, getSource()) == false) goto L72;
        if (r16 != 0) goto L72;
        long r27 = this.b1;
        long r28 = this.V0;
        if (r27 >= r28) goto L71;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r29 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.U(Long.valueOf(r28 - r27));
    L74:
        if (Intrinsics.areEqual(MultiLinkOpenSource.SYNC_ROOM, getSource()) == false) goto L76;
        if (r16 == 0) goto L77;
    L76:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r30 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.o0(r9);
        goto L77
    L71:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r31 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.m0(getMRoom(), System.currentTimeMillis(), TalkRoomLogUtils.z);
    L72:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r32 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.n0(r9);
        goto L74
    L54:
        if (getMRoom() == null) goto L56;
        ICircleInfo r33 = getMRoom().getCircleInfo();
    L57:
        r24.o(r9, r10, r11, r33);
        goto L58
    L56:
        r33 = null;
        goto L57
    L42:
        if (r16 == 16) goto L44;
        if (r7 != 16) goto L40;
    L44:
        r8 = false;
    L77:
        jy0.b.a("InteractAnimationController", "afterSceneChange fromScene:" + r16 + ",fromUiLayout:" + r110 + ",toScene:" + r10 + ",toUiLayout:" + r11);
        if (r16 != 5) goto L92;
        if (r10 == 5) goto L92;
        if (r10 == 9) goto L86;
        if (r10 == 0) goto L86;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r34 = MultiRevenueDataContext.a.d();
        if (r34 == null) goto L101;
        r34.d4(r10, r11);
    L101:
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r35 = mz0.d.b(LogCommon.LINKMIC_SCENE_DATA);
        if ((r35 instanceof mz0.e) == false) goto L105;
        r12 = r35;
    L105:
        if (r12 == null) goto L107;
        r12.c(new com.bytedance.android.livesdk.log.filter.y(r10));
    L107:
        if (r16 == r10) goto L112;
        if (r10 != 0) goto L112;
        com.bytedance.android.live.liveinteract.utils.g0 r36 = this.S1;
        if (r36 == null) goto L112;
        r36.c(r16);
    L112:
        if (r10 != 5) goto L117;
        if (r11 == r110) goto L117;
        com.bytedance.android.live.liveinteract.utils.g0 r37 = this.S1;
        if (r37 == null) goto L117;
        r37.b(r10, r110, r11);
    L117:
        SpatialAudioContext.a r38 = SpatialAudioContext.Companion;
        if (r38.getContext() != null) goto L120;
        SpatialAudioStrategyManager.c.a();
    L120:
        SpatialAudioContext r39 = r38.getContext();
        if (r39 == null) goto L125;
        com.bytedance.live.datacontext.m<Integer> r40 = r39.getCurrentStrategyId();
        if (r40 == null) goto L125;
        r40.setValue(Integer.valueOf(C0()));
    L125:
        qr(r17, r18);
        return;
    L86:
        jy0.b.a("InteractAnimationController", "before unloadAnimRenderWidget");
        MiddlewareRoomWidget r41 = this.R2;
        if (r41 == null) goto L101;
        WidgetManager r42 = ((Widget) this).subWidgetManager;
        if (r42 == null) goto L91;
        r42.unload(r41);
    L91:
        this.R2 = null;
    L92:
        if (r10 != 5) goto L101;
        if (r16 == 5) goto L101;
        if (r16 == 9) goto L100;
        if (r16 == 0) goto L100;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r43 = MultiRevenueDataContext.a.d();
        if (r43 == null) goto L101;
        r43.d4(r10, r11);
    L100:
        kr();
        goto L101
    L34:
        if (r6.intValue() != 1) goto L36;
        int r44 = tc0.c.h().K;
        LinkApplyType.PREPARE_APPLY.getValue();
        goto L36
    L9:
        r1 = null;
    L5:
        this.h1 = System.currentTimeMillis();
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void disconnect(int r8, boolean r9, boolean r10, boolean r11, rj0.c r12) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        jy0.b.d("MultiLinkVoiceChatRoomGuestWidget", String.format("disconnect, disconnectSource: %s, needSureAgain: %s, needToastWhenSuccess: %s, needShowLinkResult: %s", Arrays.copyOf(new Object[]{Integer.valueOf(r8), Boolean.valueOf(r9), Boolean.valueOf(r10), Boolean.valueOf(r11)}, 4)));
        this.J = r11;
        yf6.b r13 = Yq();
        if (r13 == null) goto L6;
        r13.ke();
    L6:
        if (this.J == false) goto L12;
        yf6.b r14 = Yq();
        if (r14 == null) goto L30;
        r14.k(new wf6.b("leave_normally", r8, false, this.J, r12, 36));
        return;
    L30:
        return;
    L12:
        if (isKtvOn() == true) goto L14;
    L23:
        if (r9 == true) goto L28;
        yf6.b r15 = Yq();
        if (r15 == null) goto L31;
        r15.k(new wf6.b("leave_normally", r8, false, this.J, r12, 36));
        return;
    L31:
        return;
    L28:
        com.bytedance.android.livesdk.widget.j0.a r16 = new com.bytedance.android.livesdk.widget.j0.a(getContext());
        r16.a = s1.B(2131919817);
        r16.a(s1.B(2131919267), new f(this, r8, r12));
        r16.b(s1.B(2131915442), g.a);
        r16.c();
        return;
    L14:
        if (s0.c(false) == true) goto L23;
        Context r17 = getContext();
        x0.d r18 = new x0.d();
        r18.b = r17;
        r18.a = 0;
        r18.a = 5;
        r18.k = false;
        r18.c = s1.B(2131919817);
        r18.d = s1.B(2131919492);
        String r19 = s1.B(2131919267);
        d r1 = new d(this, r8, r12);
        x0.c[] r20 = r18.g;
        x0.c r110 = r20[0];
        if (r110 != null) goto L18;
        r110 = new x0.c();
        r20[0] = r110;
    L18:
        r110.a = r19;
        r110.b = r1;
        String r21 = s1.B(2131915442);
        e r22 = e.a;
        x0.c[] r111 = r18.g;
        x0.c r112 = r111[1];
        if (r112 != null) goto L21;
        r112 = new x0.c();
        r111[1] = r112;
    L21:
        r112.a = r21;
        r112.b = r22;
        x0.b.g(new x0(r18.b, r18));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void ktvApply(KtvMusic r2, String r3, LinkApplyType r4, int r5, tf0.b r6) {
        Intrinsics.checkNotNullParameter(r2, "music");
        Intrinsics.checkNotNullParameter(r3, "requestType");
        Intrinsics.checkNotNullParameter(r4, "applyType");
        Rq(r2, r3, r4, r5, r6);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void teamFightApply(int r20, int r21, String r22, int r23, String r24) {
        Intrinsics.checkNotNullParameter(r22, "applySource");
        Intrinsics.checkNotNullParameter(r24, "fromSource");
        sf0.a r15 = new sf0.a(r21, d5.b(r22), r23, 0, null, null, r24, r20, 0, 0, false, false, 0, null, null, 0, 523896);
        Intrinsics.checkNotNullParameter(r15, "applyParams");
        Wq(r15);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void checkAndApply(int r20, String r21, int r22, LinkMatchType r23, String r24, String r25) {
        Intrinsics.checkNotNullParameter(r21, "applySource");
        Intrinsics.checkNotNullParameter(r23, "matchType");
        Intrinsics.checkNotNullParameter(r24, "fromSource");
        Intrinsics.checkNotNullParameter(r25, "taskName");
        sf0.a r15 = new sf0.a(r20, d5.b(r21), r22, 0, r23, r25, r24, 0, 0, 0, false, false, 0, null, null, 0, 524072);
        Intrinsics.checkNotNullParameter(r15, "applyParams");
        Wq(r15);
    }

    public final void lr(int r28, int r29, int r30, int r31, List<Integer> r32, List<Integer> r33) {
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r3 = TalkRoomLogUtils.a;
        if (TalkRoomLogUtils.i(Integer.valueOf(r28), Integer.valueOf(r29), Integer.valueOf(r30), Integer.valueOf(r31), null, null) == false) goto L5;
        return;
    L5:
        Integer r4 = Integer.valueOf(r28);
        Integer r5 = Integer.valueOf(r29);
        com.bytedance.android.live.liveinteract.plantform.utils.h r6 = TalkRoomLogUtils.b;
        int r7 = r6.b;
        if (r29 == r7) goto L9;
        r7 = r6.a;
    L9:
        String r8 = TalkRoomLogUtils.p(r4, r5, Integer.valueOf(r7));
        String r9 = TalkRoomLogUtils.p(Integer.valueOf(r30), Integer.valueOf(r31), Integer.valueOf(r6.a));
        String r10 = u0.i(Integer.valueOf(r29), r32, Integer.valueOf(r6.b));
        String r11 = u0.i(Integer.valueOf(r31), r33, Integer.valueOf(r6.a));
        String r12 = u0.f(Integer.valueOf(r29), Integer.valueOf(r28), r32, Integer.valueOf(r6.b), null, null, 48);
        Integer r13 = Integer.valueOf(r31);
        Integer r14 = Integer.valueOf(r30);
        Integer r15 = Integer.valueOf(r6.a);
        com.bytedance.android.livesdk.chatroom.o r16 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r16 == null) goto L18;
        com.bytedance.live.datacontext.m r17 = r16.getRoom();
        if (r17 == null) goto L18;
        IRoom r18 = (IRoom) r17.getValue();
        if (r18 == null) goto L18;
        z5 r19 = r18.getLinkerDetail();
        if (r19 == null) goto L18;
        List r20 = r19.getFeatureList();
    L19:
        String r110 = u0.f(r13, r14, r33, r15, null, r20, 16);
        this.H = null;
        if (r31 != 28) goto L22;
        String r21 = "avatar";
    L23:
        String r111 = r21;
        if (r30 == 0) goto L65;
        ILiveWrappedLivePusher.Companion.getClass();
        if (ILiveWrappedLivePusher.a.a(r8, r9) == false) goto L29;
        if (r28 != 0) goto L65;
    L29:
        if (hd0.c.f().h() == false) goto L39;
        com.bytedance.android.live.liveinteract.voicechat.util.k r22 = this.I;
        if (r22 == null) goto L34;
        String r23 = this.w;
        boolean r112 = Nq();
        String r113 = this.E;
        int r114 = je0.d.j(Aq());
        isKtvOn();
        r22.A(r23, r112, r113, r114, wr(), this.D, this.z, this.A, getMRoom().getCircleInfo(), null, Long.valueOf(ar()), gr(), r9, r11, null, null, null, null);
    L34:
        yf6.b r24 = Yq();
        if (r24 == null) goto L40;
        vf6.a r25 = r24.a9();
        if (r25 == null) goto L40;
        Intrinsics.checkNotNullParameter("0", "<set-?>");
        r25.b = "0";
    L40:
        com.bytedance.android.live.liveinteract.voicechat.util.k r26 = this.I;
        if (r26 == null) goto L43;
        r26.x(r9, r11, r110, r111);
    L43:
        if (r28 == 0) goto L64;
        if (r29 == 0) goto L64;
        LinkmicSubtitleBusinessContext.a r27 = LinkmicSubtitleBusinessContext.Companion;
        if (r27.d() == false) goto L64;
        int r34 = com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.a;
        com.bytedance.android.live.liveinteract.voicechat.subtitle.s r35 = com.bytedance.android.live.liveinteract.voicechat.subtitle.t.a;
        LinkmicSubtitleBusinessContext r36 = r27.getContext();
        if (r36 == null) goto L54;
        com.bytedance.live.datacontext.m<q2> r37 = r36.getLinkmicSubtitleSettingStatus();
        if (r37 == null) goto L54;
        q2 r38 = (q2) r37.getValue();
        if (r38 == null) goto L54;
        Integer r115 = Integer.valueOf(r38.getSubtitleType());
    L55:
        com.bytedance.android.live.liveinteract.voicechat.subtitle.t.h(r110, com.bytedance.android.live.liveinteract.voicechat.subtitle.t.b(r115));
        LinkmicSubtitleBusinessContext r39 = r27.getContext();
        if (r39 == null) goto L62;
        com.bytedance.live.datacontext.m<q2> r40 = r39.getLinkmicSubtitleSettingStatus();
        if (r40 == null) goto L62;
        q2 r41 = (q2) r40.getValue();
        if (r41 == null) goto L62;
        Integer r116 = Integer.valueOf(r41.getSubtitleType());
    L63:
        com.bytedance.android.live.liveinteract.voicechat.subtitle.t.e(null, r12, com.bytedance.android.live.liveinteract.voicechat.subtitle.t.b(r116));
        com.bytedance.android.live.liveinteract.voicechat.subtitle.t.a.b = System.currentTimeMillis();
    L62:
        r116 = null;
    L54:
        r115 = null;
    L64:
        String r42 = r12;
    L75:
        if (r29 == 0) goto L101;
        String r43 = r110;
        if (r29 != r31) goto L79;
        return;
    L79:
        if (r29 == 26) goto L81;
        if (r31 == 26) goto L81;
        return;
    L81:
        LinkmicSubtitleBusinessContext.a r1 = LinkmicSubtitleBusinessContext.Companion;
        if (r1.d() == false) goto L104;
        int r2 = com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.a;
        com.bytedance.android.live.liveinteract.voicechat.subtitle.s r44 = com.bytedance.android.live.liveinteract.voicechat.subtitle.t.a;
        LinkmicSubtitleBusinessContext r45 = r1.getContext();
        if (r45 == null) goto L90;
        com.bytedance.live.datacontext.m<q2> r46 = r45.getLinkmicSubtitleSettingStatus();
        if (r46 == null) goto L90;
        q2 r47 = (q2) r46.getValue();
        if (r47 == null) goto L90;
        Integer r117 = Integer.valueOf(r47.getSubtitleType());
    L91:
        com.bytedance.android.live.liveinteract.voicechat.subtitle.t.h(r43, com.bytedance.android.live.liveinteract.voicechat.subtitle.t.b(r117));
        LinkmicSubtitleBusinessContext r48 = r1.getContext();
        if (r48 == null) goto L98;
        com.bytedance.live.datacontext.m<q2> r49 = r48.getLinkmicSubtitleSettingStatus();
        if (r49 == null) goto L98;
        q2 r50 = (q2) r49.getValue();
        if (r50 == null) goto L98;
        Integer r118 = Integer.valueOf(r50.getSubtitleType());
    L99:
        com.bytedance.android.live.liveinteract.voicechat.subtitle.t.e(null, r42, com.bytedance.android.live.liveinteract.voicechat.subtitle.t.b(r118));
        com.bytedance.android.live.liveinteract.voicechat.subtitle.t.a.b = System.currentTimeMillis();
        return;
    L98:
        r118 = null;
    L90:
        r117 = null;
        goto L91
    L104:
        return;
    L101:
        return;
    L39:
        r12 = r12;
        r111 = r111;
        r110 = r110;
    L65:
        r42 = r12;
        r110 = r110;
        ILiveWrappedLivePusher.Companion.getClass();
        if (ILiveWrappedLivePusher.a.a(r10, r11) == true) goto L71;
        com.bytedance.android.live.liveinteract.voicechat.util.k r51 = this.I;
        if (r51 == null) goto L75;
        r51.x(null, r11, r110, r111);
        goto L75
    L71:
        if (ILiveWrappedLivePusher.a.a(r42, r110) == true) goto L75;
        com.bytedance.android.live.liveinteract.voicechat.util.k r52 = this.I;
        if (r52 == null) goto L75;
        com.bytedance.android.live.liveinteract.voicechat.util.k.y(r52, null, r11, r110, 8);
        goto L75
    L22:
        r21 = "classic";
    L18:
        r20 = null;
        goto L19
    }

    public final void nr(int r33, int r34, int r35, int r36, List<Integer> r37, List<Integer> r38) {
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r1 = TalkRoomLogUtils.a;
        if (TalkRoomLogUtils.i(Integer.valueOf(r33), Integer.valueOf(r34), Integer.valueOf(r35), Integer.valueOf(r36), r37, r38) == false) goto L5;
        return;
    L5:
        Integer r2 = Integer.valueOf(r33);
        Integer r3 = Integer.valueOf(r34);
        com.bytedance.android.live.liveinteract.plantform.utils.h r4 = TalkRoomLogUtils.b;
        int r5 = r4.b;
        if (r34 == r5) goto L9;
        r5 = r4.a;
    L9:
        String r6 = TalkRoomLogUtils.p(r2, r3, Integer.valueOf(r5));
        String r7 = TalkRoomLogUtils.p(Integer.valueOf(r35), Integer.valueOf(r36), Integer.valueOf(r4.a));
        String r8 = u0.i(Integer.valueOf(r34), r37, Integer.valueOf(r4.b));
        String r9 = u0.i(Integer.valueOf(r36), r38, Integer.valueOf(r4.a));
        String r10 = u0.f(Integer.valueOf(r34), Integer.valueOf(r33), r37, Integer.valueOf(r4.b), null, null, 48);
        String r11 = u0.f(Integer.valueOf(r36), Integer.valueOf(r35), r38, Integer.valueOf(r4.a), null, null, 48);
        if (r36 != 28) goto L12;
        String r12 = "avatar";
    L13:
        String r14 = r12;
        if (vm2.d.v0() == true) goto L16;
    L18:
        ILiveWrappedLivePusher.Companion.getClass();
        if (ILiveWrappedLivePusher.a.a(r6, r7) == true) goto L45;
        if (r35 == 0) goto L45;
        if (hd0.c.f().h() == false) goto L39;
        if (r6 == null) goto L39;
        if (r33 == 0) goto L39;
        if (this.k1 <= 0) goto L39;
        String r30 = er();
        com.bytedance.android.live.liveinteract.voicechat.util.k r13 = this.I;
        if (r13 == null) goto L39;
        if (isKtvOn() == false) goto L32;
        int r15 = 9;
    L33:
        String r16 = this.w;
        int r17 = Mq();
        boolean r18 = Nq();
        String r19 = this.E;
        int r39 = r15;
        long r20 = (System.currentTimeMillis() - Math.max(this.k1, this.h1)) / ((long) 1000);
        Long r110 = Long.valueOf(ar());
        List r111 = wr();
        long r21 = this.S2.b;
        IRoom r22 = getMRoom();
        if (r22 == null) goto L36;
        ICircleInfo r23 = r22.getCircleInfo();
    L37:
        Long r24 = gr();
        LinkApplyType r25 = this.x;
        com.bytedance.android.live.liveinteract.videotalk.utils.a r26 = this.h2;
        oe0.b r27 = this.p2;
        int r28 = com.bytedance.android.live.liveinteract.voicechat.util.k.g;
        r13.C(r39, r16, r17, r18, r19, "anchor", r20, null, r110, r111, false, r21, r23, r24, r6, r8, r25, null, r26, r27, r30, null);
        goto L39
    L36:
        r23 = null;
        goto L37
    L32:
        r15 = 5;
    L39:
        if (r6 == null) goto L57;
        if (r33 == 0) goto L58;
        com.bytedance.android.live.liveinteract.voicechat.util.k r29 = this.I;
        if (r29 == null) goto L59;
        r29.v(r6, r8, r10, r14);
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L45:
        if (ILiveWrappedLivePusher.a.a(r8, r9) == true) goto L51;
        if (r8 == null) goto L61;
        com.bytedance.android.live.liveinteract.voicechat.util.k r31 = this.I;
        if (r31 == null) goto L62;
        r31.v(null, r8, r10, r14);
        return;
    L62:
        return;
    L61:
        return;
    L51:
        if (ILiveWrappedLivePusher.a.a(r10, r11) == true) goto L64;
        if (r10 == null) goto L65;
        com.bytedance.android.live.liveinteract.voicechat.util.k r32 = this.I;
        if (r32 == null) goto L66;
        r32.v(null, r8, r10, r14);
        return;
    L66:
        return;
    L65:
        return;
    L64:
        return;
    L16:
        if (TextUtils.isEmpty(TalkRoomLogUtils.j) == true) goto L18;
        r6 = TalkRoomLogUtils.j;
        goto L18
    L12:
        r12 = "classic";
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void switchAudioByClient(boolean r8, List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r9, ClientUIInfo r10, long r11, Map<Long, ? extends g2> r13, String r14) {
        Intrinsics.checkNotNullParameter(r14, "reason");
        G4(r8, r14);
        Pq().t(r8);
        com.bytedance.android.live.liveinteract.plantform.core.y r0 = Aq();
        if (r8 == false) goto L5;
        String r12 = "silence";
    L6:
        r0.Y4(r9, r10, r11, r12, r13);
        return;
    L5:
        r12 = "unsilence";
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService
    public final void checkAndApply(int r20, int r21, String r22, int r23, int r24, boolean r25, boolean r26, int r27, xc.a r28) {
        Intrinsics.checkNotNullParameter(r22, "fromSource");
        Intrinsics.checkNotNullParameter(r28, "linkmicDiscountInfo");
        sf0.a r14 = new sf0.a(r20, 0, r21, 0, null, null, r22, 0, r23, r24, r25, r26, r27, null, r28, 0, 475514);
        Intrinsics.checkNotNullParameter(r14, "applyParams");
        Wq(r14);
    }
}
