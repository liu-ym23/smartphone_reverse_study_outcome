package com.bytedance.android.live.multilink.voicechat.impl.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.opengl.GLSurfaceView;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.t2;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationContext;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.OpenPanelType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.CPositionInviteType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.CPositionReplyType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.CPositionToEnlargePosition;
import com.bytedance.android.live.liveinteract.customizestream.CustomizeStreamContext;
import com.bytedance.android.live.liveinteract.customizestream.CustomizeStreamWidget;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarWidget;
import com.bytedance.android.live.liveinteract.hamlet.HamletInterceptTouchFrameLayout;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongWidget;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.linkpanel.vm.AdminInviteAndApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.VoiceCommonLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm.VoiceCommonMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.context.MultiLinkDynamicContext;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSVoiceWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.e0;
import com.bytedance.android.live.liveinteract.plantform.model.r0;
import com.bytedance.android.live.liveinteract.plantform.utils.PublicStreamClientMixStrategy;
import com.bytedance.android.live.liveinteract.plantform.utils.PublicStreamPlayState;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseAnchorLinkWidget;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.MultiLinkLinkRoomFightWindowManager;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.s0;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionWidget;
import com.bytedance.android.live.liveinteract.videotalk.dialog.CPositionBeInvitedDialog;
import com.bytedance.android.live.liveinteract.videotalk.dialog.CPositionBeSetDialog;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractWidget;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatAnchorDataContext;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatGlobalDataContext;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.live.liveinteract.voicechat.dialog.InteractSceneViewModel;
import com.bytedance.android.live.liveinteract.voicechat.emoji.VoiceChatInteractEmojiPanel;
import com.bytedance.android.live.liveinteract.voicechat.interactacting.InteractActingWidget;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.voicechat.stage.AudioChatStageWidget;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessContext;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget;
import com.bytedance.android.live.liveinteract.voicechat.toolbar.KtToolbarInteractRoomBehavior;
import com.bytedance.android.live.liveinteract.voicechat.toolbar.ToolbarRoomBattleBehavior;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.chatroom.model.d1;
import com.bytedance.android.livesdk.chatroom.model.h1;
import com.bytedance.android.livesdk.chatroom.model.i1;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.q2;
import com.bytedance.android.livesdk.chatroom.model.interact.v1;
import com.bytedance.android.livesdk.chatroom.model.j2;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.config.ib0;
import com.bytedance.android.livesdk.config.nm;
import com.bytedance.android.livesdk.config.wz;
import com.bytedance.android.livesdk.config.xz;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.message.model.f6;
import com.bytedance.android.livesdk.message.model.nd;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerEnlargeUpdateContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerEnlargeUpdateContentKt;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfigKt;
import com.bytedance.android.livesdkapi.model.LiveAudioSubtitleSetting;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.bizlink.api.business.anchor2guest.base.BizLinkServiceType;
import com.bytedance.live.bizlink.api.platform.rtc.rtcinfo.MultiLinkInfoType;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import hh1.u0;
import hh1.w0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
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
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import sh0.f0;
import sh0.i0;
import sh0.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f:\u0001\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/multilink/voicechat/impl/widget/MultiLinkVoiceChatRoomAnchorWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/voicelink/MultiLinkVoiceBaseAnchorLinkWidget;", "Lcom/bytedance/android/live/multilink/voicechat/impl/widget/MultiLinkVoiceChatAnchorPresenter$IView;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Lhe0/b$a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/live/liveinteract/voicechat/d;", "Lcom/bytedance/android/live/liveinteract/voicechat/a;", "Lkk0/f;", "Lwn0/a$c;", "Lkk0/h;", "Lcom/bytedance/android/live/liveinteract/voicechat/c;", "a", "multilink-voicechat-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkVoiceChatRoomAnchorWidget extends MultiLinkVoiceBaseAnchorLinkWidget implements MultiLinkVoiceChatAnchorPresenter.IView, WeakHandler.IHandler, Observer<KVData>, com.bytedance.android.live.liveinteract.voicechat.d, com.bytedance.android.live.liveinteract.voicechat.a, kk0.f, wn0.a.c, kk0.h, com.bytedance.android.live.liveinteract.voicechat.c {
    public static final /* synthetic */ int E2 = 0;
    public i0 A;
    public MultiLinkVoiceChatAnchorPresenter B;
    public VoiceChatMuteManager C;
    public hg6.g D;
    public wn0.a E;
    public tf0.o F;
    public WeakHandler G;
    public final ArrayList<ILinkPlayerInfoBridge> G1;
    public final w0 H;
    public AudioChatStageWidget H0;
    public final InteractSceneViewModel H1;
    public long I;
    public final cj0.e J;
    public Disposable K;
    public com.bytedance.android.live.liveinteract.plantform.utils.u L;
    public CustomizeStreamWidget L0;
    public int L1;
    public int M;
    public CPositionBeSetDialog M1;
    public boolean N;
    public boolean O;
    public InteractAnimationController P;
    public Widget P0;
    public ClientUIInfo P1;
    public final KtToolbarInteractRoomBehavior Q;
    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u Q1;
    public com.bytedance.android.live.liveinteract.voicechat.util.k R;
    public MuteStateChecker S;
    public final com.bytedance.android.live.multilink.voicechat.impl.widget.j S1;
    public int T;
    public boolean T1;
    public Disposable U;
    public final Map<String, Integer> V;
    public final boolean V0;
    public final com.bytedance.android.live.multilink.voicechat.impl.widget.n V1;
    public InteractLiveCorePermissionGuarantor W;
    public ChatMatchWidget X;
    public QuickInteractWidget Y;
    public CPositionWidget Z;
    public InteractiveSongWidget b1;
    public String b2;
    public HamletAvatarWidget g1;
    public j50.a g2;
    public RTSVoiceWidget h1;
    public k50.c h2;
    public LinkmicSubtitleBusinessWidget k0;
    public MiddlewareRoomWidget k1;
    public InteractActingWidget p0;
    public CPositionBeInvitedDialog p1;
    public final Lazy p2;
    public com.bytedance.android.live.liveinteract.videotalk.utils.a v1;
    public final com.bytedance.android.live.pushstream.d v2;
    public final com.bytedance.android.live.liveinteract.plantform.utils.s x1;
    public final int x2;
    public final ArrayList<ILinkPlayerInfoBridge> y1;
    public final int y2;

    public static final class a {
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

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ long c;

        public c(MultiLinkVoiceChatRoomAnchorWidget r1, Ref.ObjectRef r2, long r3) {
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

    public static final class d<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

        public d(MultiLinkVoiceChatRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            if (((Boolean) r4).booleanValue() == false) goto L8;
            WeakHandler r5 = this.a.G;
            if (r5 == null) goto L9;
            r5.postDelayed(new com.bytedance.android.live.multilink.voicechat.impl.widget.f(this), vm2.h.g0().b());
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

        public e(MultiLinkVoiceChatRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Intrinsics.checkNotNullParameter((fd2.z) r3, "event");
            MultiLinkVoiceChatRoomAnchorWidget r4 = this.a;
            int r0 = MultiLinkVoiceChatRoomAnchorWidget.E2;
            if (com.bytedance.android.live.liveinteract.spatial.a.e(r4.C0()) == false) goto L7;
            jy0.b.a("SpatialAudio_MultiLinkVoiceChatRoomAnchorWidgetByCopy", "singerChanged updateSpatialAudioPosition------");
            tf0.o r1 = r4.F;
            if (r1 == null) goto L7;
            r1.u(Boolean.valueOf(r4.isEngineOn()));
        L7:
            hg6.g r5 = r4.D;
            if (r5 == null) goto L11;
            r5.f();
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

        public f(MultiLinkVoiceChatRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            hg6.g r0 = this.a.D;
            if (r0 == null) goto L6;
            Intrinsics.checkNotNull(r3);
            r0.w(r3.booleanValue());
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r7) {
            List r8 = ((h1) ((com.bytedance.android.live.network.response.e) r7).data).getSettings();
            if (r8 == null) goto L29;
            int r0 = r8.size();
            int r2 = 0;
        L5:
            if (r2 >= r0) goto L39;
            if (ListProtector.get(r8, r2) == null) goto L28;
            Object r3 = ListProtector.get(r8, r2);
            Intrinsics.checkNotNull(r3);
            if (((ILinkmicAudienceSetting) r3).getKey() == null) goto L28;
            Object r4 = ListProtector.get(r8, r2);
            Intrinsics.checkNotNull(r4);
            Integer r5 = ((ILinkmicAudienceSetting) r4).getKey();
            int r6 = ILinkmicAudienceSetting.LinkmicAudienceSettingKey.ENABLE_MIC_DRESS_BUTTON.getValue();
            if (r5 == null) goto L28;
            if (r5.intValue() != r6) goto L28;
            Object r9 = ListProtector.get(r8, r2);
            Intrinsics.checkNotNull(r9);
            if (((ILinkmicAudienceSetting) r9).getValue() == null) goto L28;
            Gson r10 = GsonHelper.get();
            Object r11 = ListProtector.get(r8, r2);
            Intrinsics.checkNotNull(r11);
            i1 r12 = ((ILinkmicAudienceSetting) r11).getValue();
            Intrinsics.checkNotNull(r12);
            j2 r13 = (j2) GsonProtectorUtils.fromJson(r10, r12.getExtra(), j2.class);
            if (r13 == null) goto L28;
            List r14 = r13.b;
            if (r14 != null) goto L22;
        L24:
            if (r14 != null) goto L26;
        L27:
            com.bytedance.android.livesdk.sharedpref.e r15 = com.bytedance.android.livesdk.sharedpref.c.N0;
            r15.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r15, 0);
            goto L28
        L26:
            if (r14.isEmpty() == false) goto L28;
        L22:
            if (r14.isEmpty() == true) goto L24;
            com.bytedance.android.livesdk.sharedpref.e r16 = com.bytedance.android.livesdk.sharedpref.c.N0;
            Integer r17 = r13.a;
            r16.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r16, r17);
            com.bytedance.android.livesdk.sharedpref.e r18 = com.bytedance.android.livesdk.sharedpref.c.P0;
            r18.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r18, r14);
        L28:
            r2 = r2 + 1;
            goto L5
        L39:
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

        public i(MultiLinkVoiceChatRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = ((d1) ((com.bytedance.android.live.network.response.e) r3).data).getEntranceList();
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.isEmpty() == true) goto L11;
            MultiLinkVoiceChatRoomAnchorWidget r0 = this.a;
            int r1 = MultiLinkVoiceChatRoomAnchorWidget.E2;
            if (r0.yq().D == null) goto L12;
            ((ArrayList) this.a.yq().D).clear();
            ArrayList r2 = (ArrayList) this.a.yq().D;
            r2.addAll(r4);
            return;
        L12:
            return;
        }
    }

    public static final class j<T> implements Consumer {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

        public k(MultiLinkVoiceChatRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            IRoomLinkMicSyncData r5 = (IRoomLinkMicSyncData) r4;
            if (r5.getLinkerBaseInfo() == null) goto L17;
            MultiLinkVoiceChatRoomAnchorWidget r0 = this.a;
            com.bytedance.android.live.liveinteract.plantform.model.q r6 = r5.getLinkerBaseInfo();
            if (r6 == null) goto L8;
            int r7 = r6.getAnchorManualOpenUiLayout();
        L9:
            r0.M = r7;
            MultiLinkVoiceChatRoomAnchorWidget r8 = this.a;
            DataCenter r1 = ((Widget) r8).dataCenter;
            if (r1 == null) goto L12;
            r1.put("data_room_audio_chat_ui_layout", Integer.valueOf(r8.M));
        L12:
            com.bytedance.android.live.liveinteract.plantform.utils.i0 r9 = TalkRoomLogUtils.a;
            com.bytedance.android.live.liveinteract.plantform.utils.h r10 = TalkRoomLogUtils.b;
            int r2 = r10.a;
            int r3 = this.a.M;
            if (r2 == r3) goto L16;
            TalkRoomLogUtils.s1(r3, false);
            jy0.b.d("AnchorManualUiLayout", "wrds change currentManualUiLayout=" + this.a.M + ", lastManualUiLayout=" + r10.b);
            return;
        L16:
            return;
        L8:
            r7 = 0;
            goto L9
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

        public l(MultiLinkVoiceChatRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            jd0.a r3 = (jd0.a) r2;
            MultiLinkVoiceChatRoomAnchorWidget r4 = this.a;
            int r0 = MultiLinkVoiceChatRoomAnchorWidget.E2;
            r4.Yq();
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

        public m(MultiLinkVoiceChatRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            zg1.h1 r6 = (zg1.h1) r5;
            Intrinsics.checkNotNullParameter(r6, "event");
            MultiLinkVoiceChatRoomAnchorWidget r0 = this.a;
            int r1 = MultiLinkVoiceChatRoomAnchorWidget.E2;
            r0.getClass();
            if (r6.a != 3) goto L7;
            r0.m.add(Observable.timer(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.multilink.voicechat.impl.widget.m(r0)));
            return;
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

        public n(MultiLinkVoiceChatRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            zg1.i1 r4 = (zg1.i1) r3;
            Intrinsics.checkNotNullParameter(r4, "event");
            tf0.o r0 = this.a.F;
            if ((r0 instanceof VoiceCommonMultiLinkWindowManager) == true) goto L5;
            r0 = null;
        L5:
            VoiceCommonMultiLinkWindowManager r1 = (VoiceCommonMultiLinkWindowManager) r0;
            if (r1 == null) goto L9;
            r1.z1(r4.b);
            return;
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

        public o(MultiLinkVoiceChatRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            o42.g r4 = (o42.g) r3;
            MultiLinkVoiceChatRoomAnchorWidget r0 = this.a;
            int r1 = MultiLinkVoiceChatRoomAnchorWidget.E2;
            r0.getClass();
            if (r4 == null) goto L9;
            IBaseUser r2 = r4.a;
            if (r2 == null) goto L10;
            r0.b2 = r4.b;
            ((Widget) r0).dataCenter.put("cmd_audio_talk_invite", r2);
            return;
        L10:
            return;
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

        public p(MultiLinkVoiceChatRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((o42.l) r2, "event");
            MultiLinkVoiceChatRoomAnchorWidget r3 = this.a;
            int r0 = MultiLinkVoiceChatRoomAnchorWidget.E2;
            r3.getClass();
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

        public q(MultiLinkVoiceChatRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            MultiLinkVoiceChatRoomAnchorWidget r4 = this.a;
            if (((Widget) r4).isViewValid == false) goto L8;
            Disposable r5 = r4.U;
            Intrinsics.checkNotNull(r5);
            if (r5.isDisposed() == true) goto L9;
            com.bytedance.android.live.liveinteract.voicechat.util.k r6 = this.a.R;
            Intrinsics.checkNotNull(r6);
            int r0 = this.a.yq().b();
            r6.getClass();
            com.bytedance.android.live.liveinteract.voicechat.util.k.z(r0);
            return;
        L9:
            return;
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

        public r(MultiLinkVoiceChatRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            MultiLinkVoiceChatRoomAnchorWidget r0 = this.a;
            boolean r7 = ((Boolean) r6).booleanValue();
            int r1 = MultiLinkVoiceChatRoomAnchorWidget.E2;
            r0.getClass();
            StringBuilder r2 = new StringBuilder("onIsSingerChanged ");
            r2.append(r7);
            r2.append(" mute=");
            VoiceChatMuteManager r3 = r0.C;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
        L5:
            r2.append(r3.isMute());
            r2.append(" shouldRestore=");
            r2.append(r0.x);
            r2.append(" isResumed=");
            r2.append(r0.O);
            jy0.b.d("voice_chat", r2.toString());
            if (r7 == false) goto L41;
            IKtvService r8 = jc1.k.f(IKtvService.class);
            if (r8 == null) goto L10;
            boolean r4 = r8.isInKtvState(8);
            boolean r9 = r8.isAudienceSingEnableSwitchOn();
        L11:
            if (r4 == false) goto L24;
            VoiceChatMuteManager r10 = r0.C;
            if (r10 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
        L16:
            if (r10.isMute() == true) goto L18;
        L23:
            r0.x = false;
        L53:
            if (com.bytedance.android.live.liveinteract.spatial.a.e(r0.C0()) == false) goto L57;
            jy0.b.a("SpatialAudio_MultiLinkVoiceChatRoomAnchorWidgetByCopy", "onKtvSingerStateChanged updateSpatialAudioPosition------");
            tf0.o r11 = r0.F;
            if (r11 == null) goto L57;
            r11.u(Boolean.valueOf(r0.isEngineOn()));
        L57:
            hg6.g r12 = r0.D;
            if (r12 == null) goto L61;
            r12.f();
            return;
        L61:
            return;
        L18:
            if (r0.O == false) goto L23;
            VoiceChatMuteManager r13 = r0.C;
            if (r13 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
        L22:
            com.bytedance.android.live.liveinteract.voicechat.b.a.a(r13, "force UnSilence", true, null, 8);
            r0.x = true;
            goto L53
        L24:
            VoiceChatMuteManager r5 = r0.C;
            if (r5 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
        L28:
            if (r5.isMute() == false) goto L34;
            if (r0.O == false) goto L34;
            if (r9 == false) goto L34;
            f2.b(2131918609, 0);
        L34:
            if (r0.V0 == true) goto L53;
            jg6.a r14 = r0.Bq();
            if (r14 == null) goto L53;
            kg6.e r15 = r14.b();
            if (r15 == null) goto L53;
            r15.u(false, "");
            goto L53
        L10:
            r9 = false;
            r4 = false;
            goto L11
        L41:
            if (r0.x == false) goto L49;
            VoiceChatMuteManager r16 = r0.C;
            if (r16 != null) goto L45;
            Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
        L45:
            r16.s();
            if (r0.O == true) goto L48;
            ((Widget) r0).dataCenter.put("data_talk_room_capture_audio_notification_show_state", Boolean.FALSE);
        L48:
            r0.x = false;
        L49:
            hg6.g r17 = r0.D;
            if (r17 == null) goto L53;
            r17.e0("songEnd");
            goto L53
        }
    }

    public static final class s<T> implements Consumer {
        public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;
        public final /* synthetic */ int b;

        public s(MultiLinkVoiceChatRoomAnchorWidget r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            Long r7 = (Long) r6;
            if (r7 != null) goto L6;
            return;
        L6:
            if (r7.longValue() != 10) goto L35;
            int r8 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
            DataCenter r9 = ((Widget) this.a).dataCenter;
            boolean r0 = false;
            if (r9 == null) goto L12;
            Boolean r1 = (Boolean) r9.get("data_multi_link_setting_dialog_show", Boolean.FALSE);
            if (r1 == null) goto L12;
            boolean r2 = r1.booleanValue();
        L13:
            if (r9 == null) goto L17;
            Boolean r3 = (Boolean) r9.get("data_multi_link_interaction_dialog_show", Boolean.FALSE);
            if (r3 == null) goto L17;
            boolean r4 = r3.booleanValue();
        L18:
            if (r9 == null) goto L22;
            Boolean r10 = (Boolean) r9.get("data_anchor_more_dialog_show", Boolean.FALSE);
            if (r10 == null) goto L22;
            boolean r11 = r10.booleanValue();
        L23:
            ALogger.i("AudioChatStage", "stageEnlargeGuideDialogExclusion settingDialogShow=" + r2 + ", interactionDialogShow=" + r4 + ", moreDialogShow=" + r11);
            if (r2 == true) goto L27;
            if (r4 == true) goto L27;
            if (r11 == true) goto L27;
        L28:
            if (r0 == true) goto L33;
            Context r12 = ((Widget) this.a).context;
            Intrinsics.checkNotNullParameter(r12, "context");
            String r5 = y0.b(((LiveAudioSubtitleSetting) com.bytedance.android.live.core.setting.x.a.getValue()).getEnlargeStageGuideDialogSchema(), new LinkedHashMap());
            IBaseLiveActionHandler r13 = jc1.k.f(IBaseLiveActionHandler.class);
            if (r13 == null) goto L32;
            r13.handle(r12, r5);
        L32:
            com.bytedance.android.livesdk.sharedpref.e r14 = com.bytedance.android.livesdk.sharedpref.c.G0;
            Boolean r15 = Boolean.TRUE;
            r14.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r14, r15);
            return;
        L33:
            MultiLinkVoiceChatRoomAnchorWidget r16 = this.a;
            int r17 = this.b;
            int r18 = MultiLinkVoiceChatRoomAnchorWidget.E2;
            r16.gr(r17);
            return;
        L27:
            r0 = true;
        L22:
            r11 = false;
        L17:
            r4 = false;
        L12:
            r2 = false;
            goto L13
        }
    }

    public static final class t<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;

        public t(String r1, boolean r2, long r3) {
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
        }
    }

    public static final class u<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;

        public u(String r1, boolean r2, long r3, long r5) {
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
            ALogger.e("ttlive_link_video", "主咖邀请回复失败。accept=" + this.b + "  roomId=" + this.d + "  toUid=" + this.a, r7);
            return;
        L7:
            f2.b(2131922756, 0);
            goto L8
        }
    }

    public static final class v<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;

        public v(String r1, boolean r2, long r3, long r5) {
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
            if (TextUtils.isEmpty(((com.bytedance.android.livesdk.chatroom.model.y0) r4).getPrompts()) == true) goto L9;
            DATA r11 = r10.data;
            Intrinsics.checkNotNull(r11);
            f2.c(((com.bytedance.android.livesdk.chatroom.model.y0) r11).getPrompts(), 0);
            return;
        L9:
            return;
        }
    }

    public static final class w<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;

        public w(String r1, boolean r2, long r3, long r5) {
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
            ALogger.e("ttlive_link_video", r6, r9);
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

    public static final class x implements DialogInterface.OnDismissListener {
        public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

        public x(MultiLinkVoiceChatRoomAnchorWidget r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            this.a.N = false;
        }
    }

    public static final class y<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public y(String r1, long r2, long r4, String r6) {
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
            com.bytedance.android.livesdk.chatroom.model.y0 r2 = (com.bytedance.android.livesdk.chatroom.model.y0) r10.data;
            if (r2 == null) goto L14;
            String r4 = r2.getPrompts();
            if (r4 == null) goto L14;
            if (r2.a(r4) != true) goto L14;
            com.bytedance.android.livesdk.chatroom.model.y0 r11 = (com.bytedance.android.livesdk.chatroom.model.y0) r10.data;
            if (r11 == null) goto L11;
            String r12 = r11.getPrompts();
        L12:
            f2.c(r12, 0);
            return;
        L11:
            r12 = null;
        L14:
            if ((!Intrinsics.areEqual(this.a, je0.d.b0())) == true) goto L16;
            return;
        L16:
            if (TextUtils.equals(this.d, "add") == false) goto L18;
            f2.b(2131922754, 0);
            return;
        L18:
            f2.b(2131922715, 0);
        }
    }

    public static final class z<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        public z(String r1, long r2, long r4) {
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

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void D1(String r1, ByteBuffer r2, int r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final void Gn() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void S(String r1, int r2, int r3) {
    }

    @Override // tf0.o.a
    public final j1 Zb() {
        return this;
    }

    @Override // tf0.o.a
    public final /* synthetic */ uf2.z.a c3(String r1) {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final boolean canSilenceSelf() {
        return true;
    }

    @Override // tf0.o.a
    public final /* synthetic */ void f() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
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

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final boolean isAnchor() {
        return true;
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
        tf0.o r1 = this.F;
        if (r1 != null) goto L11;
        return false;
    L11:
        if (r1.isDynamicAnimating() != true) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
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

    public final void onPause() {
        this.O = false;
        hg6.g r0 = this.D;
        if (r0 == null) goto L6;
        r0.onPause();
    L6:
        if (vm2.e.a() == false) goto L8;
        Tq().f();
    L8:
        ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).broadcastFloatWindowManager();
        if (((Boolean) vm2.h.o0.getValue(null, vm2.h.a[65])).booleanValue() == false) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L14;
    L30:
        yq().v();
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        return;
    L14:
        if (this.z == null) goto L30;
        if (((IInteractService) jc1.k.n(IInteractService.class)).enableCaptureAudioOnBackground(true) == true) goto L29;
        G4(true, "onPause");
        VoiceChatMuteManager r2 = this.C;
        if (r2 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L21:
        if (r2.o() != 0) goto L27;
        yq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
        VoiceChatMuteManager r3 = this.C;
        if (r3 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L25:
        r3.k("onPause");
    L27:
        if (Jq() == null) goto L30;
        u0 r4 = Jq();
        Intrinsics.checkNotNull(r4);
        r4.pause();
        goto L30
    L29:
        com.bytedance.android.live.liveinteract.plantform.utils.x.J();
        goto L30
    L11:
        r1 = isEngineOn();
        goto L12
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

    @Override // tf0.o.a
    public final /* synthetic */ void v4(String r1, boolean r2) {
    }

    @Override // wn0.a.c
    public final Pair<Integer, Integer> D3() {
        return new Pair(0, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseAnchorLinkWidget, he0.b.a
    public final boolean J8() {
        int r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c.i;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c.a.a(Rq()) == true) goto L39;
        HamletAvatarContext r1 = HamletAvatarContext.Companion.getContext();
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r2 = r1.isStreamRending();
        if (r2 == null) goto L11;
        Boolean r3 = (Boolean) r2.getValue();
        if (r3 == null) goto L11;
        boolean r4 = r3.booleanValue();
    L12:
        if (r4 == false) goto L14;
        return true;
    L14:
        if (Rq() != 16) goto L23;
        com.bytedance.android.live.liveinteract.revenue.game.servermixer.a r5 = com.bytedance.android.live.liveinteract.revenue.game.servermixer.b.a;
        if (r5 != null) goto L18;
    L20:
        boolean r6 = false;
    L21:
        if (r6 == false) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L26;
        return true;
    L26:
        if (je0.d.f() == 16) goto L42;
        CustomizeStreamContext r8 = CustomizeStreamContext.Companion.getContext();
        if (r8 == null) goto L34;
        com.bytedance.live.datacontext.m<Boolean> r9 = r8.getCustomizeStreamStarted();
        if (r9 == null) goto L34;
        Boolean r10 = (Boolean) r9.getValue();
        if (r10 == null) goto L34;
        boolean r11 = r10.booleanValue();
    L35:
        if (r11 == true) goto L43;
        return false;
    L43:
        return true;
    L34:
        r11 = false;
        goto L35
    L42:
        return true;
    L18:
        if (r5.b() != true) goto L20;
        r6 = true;
    L23:
        r7 = false;
    L11:
        r4 = false;
        goto L12
    L39:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.a
    public final boolean O5() {
        hg6.g r0 = this.D;
        Intrinsics.checkNotNull(r0);
        return r0.A();
    }

    public final int Qq() {
        wn0.a r0 = this.E;
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

    public final int Rq() {
        wn0.a r0 = this.E;
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

    @Override // wn0.a.b
    public final int Ta() {
        return this.y1.size();
    }

    public final InteractLiveCorePermissionGuarantor Tq() {
        if (this.W != null) goto L5;
        this.W = new InteractLiveCorePermissionGuarantor();
        InteractLiveCorePermissionGuarantor r0 = this.W;
        Intrinsics.checkNotNull(r0);
        r0.j(this.V1);
    L5:
        InteractLiveCorePermissionGuarantor r1 = this.W;
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    public final void Yq() {
        CustomizeStreamContext r0 = CustomizeStreamContext.Companion.getContext();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.getCustomizeStreamStarted();
        if (r1 == null) goto L11;
        Observable r2 = r1.a();
        if (r2 == null) goto L12;
        r2.subscribe(new d(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void cr() {
        DataCenter r0 = ((Widget) this).dataCenter;
        Boolean r1 = Boolean.FALSE;
        if (((Boolean) r0.get("data_talk_room_admin_allowed_flag", r1)).booleanValue() == false) goto L6;
        TalkRoomLogUtils.q1("live_chat", ((Boolean) com.bytedance.android.livesdk.sharedpref.c.v1.getValue()).booleanValue());
        ((Widget) this).dataCenter.put("data_talk_room_admin_allowed_flag", r1);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final String currentCPositionChangeTrackData() {
        MultiLinkVoiceChatAnchorPresenter r0 = this.B;
        if (r0 == null) goto L6;
        String r1 = r0.f;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final int currentCPositionOpenSource() {
        MultiLinkVoiceChatAnchorPresenter r0 = this.B;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.e;
    }

    @Override // tf0.o.a
    public final int dn() {
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.L;
        if (r0 == null) goto L8;
        Integer r1 = r0.d();
        if (r1 == null) goto L8;
        return r1.intValue();
    L8:
        return PublicStreamClientMixStrategy.None.ordinal();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final List<ILinkPlayerInfoBridge> getCrossRoomFightLinkUserInfoList() {
        tf0.o r0 = this.F;
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

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final JsonObject getLinkmicAreaFrameInfo() {
        tf0.o r0 = this.F;
        if (r0 == null) goto L5;
        sf0.b r1 = r0.getLinkmicAreaFrameInfo();
    L6:
        if (r1 == null) goto L9;
        int r2 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        return com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.f(r1);
    L9:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final JsonObject getLinkmicSeatListInfo() {
        String r1 = "seat";
        nh0.e r2 = null;
        tf0.o r0 = this.F;
        if (r0 == null) goto L5;
        List<tf0.e> r3 = r0.e();
    L7:
        return new nh0.f(r1, r2, r3, null, null, null, false, 246).b();
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final com.bytedance.android.live.liveinteract.voicechat.util.k getLogger() {
        com.bytedance.android.live.liveinteract.voicechat.util.k r0 = this.R;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final MixStreamType getMixStreamType() {
        hg6.g r0 = this.D;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMixStreamType();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final qj0.a getMultiLinkAudioLayoutService() {
        return (qj0.a) this.p2.getValue();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final JsonObject getTopLeftSeatFrameInfo() {
        tf0.o r0 = this.F;
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

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final boolean isEngineOn() {
        hg6.g r0 = this.D;
        Intrinsics.checkNotNull(r0);
        return r0.isEngineOn();
    }

    @Override // tf0.o.a
    public final int mc() {
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.L;
        if (r0 == null) goto L8;
        Integer r1 = r0.e();
        if (r1 == null) goto L8;
        return r1.intValue();
    L8:
        return PublicStreamPlayState.None.ordinal();
    }

    @Override // he0.b.a
    public final int me() {
        CustomizeStreamContext r0 = CustomizeStreamContext.Companion.getContext();
        boolean r1 = false;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r2 = r0.getCustomizeStreamStarted();
        if (r2 == null) goto L9;
        Boolean r3 = (Boolean) r2.getValue();
        if (r3 == null) goto L9;
        boolean r4 = r3.booleanValue();
    L10:
        if (r4 == true) goto L22;
        HamletAvatarContext r5 = HamletAvatarContext.Companion.getContext();
        if (r5 == null) goto L18;
        com.bytedance.live.datacontext.m<Boolean> r6 = r5.isStreamRending();
        if (r6 == null) goto L18;
        Boolean r7 = (Boolean) r6.getValue();
        if (r7 == null) goto L18;
        r1 = r7.booleanValue();
    L18:
        if (r1 == true) goto L24;
        return 1;
    L24:
        return 2;
    L22:
        return 2;
    L9:
        r4 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final MuteStateChecker muteChecker() {
        MuteStateChecker r0 = this.S;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final com.bytedance.android.live.liveinteract.voicechat.b muteManager() {
        VoiceChatMuteManager r0 = this.C;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        f2.g();
        int r9 = 0;
        uf2.d0 r10 = null;
        if (MultiLinkLoadWidgetUtils.g() == false) goto L13;
        int r0 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r1 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(((Widget) this).dataCenter);
        if (r1 == null) goto L7;
        BaseLinkSeatWindowView r2 = r1.getLinkSeatWindowView();
    L8:
        if (r2 == null) goto L13;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r3 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(((Widget) this).dataCenter);
        if (r3 == null) goto L12;
        ConstraintLayout r4 = r3.getLinkSeatWindowView();
    L14:
        ALogger.i("MultiLinkVoiceChatRoomAnchorWidgetByCopy", "updateWindowViewParent windowView=" + r4 + ", containerView=" + ((Widget) this).containerView);
        if (r4 == null) goto L27;
        ViewParent r5 = r4.getParent();
        if ((r5 instanceof ViewGroup) == true) goto L20;
        r5 = null;
    L20:
        ViewGroup r6 = (ViewGroup) r5;
        if (r6 == null) goto L23;
        r6.removeView(r4);
    L23:
        ViewGroup r7 = (ViewGroup) ((Widget) this).containerView.findViewById(2131378012);
        if (r7 == null) goto L26;
        r7.removeAllViews();
    L26:
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-1, -1);
        r8.gravity = 49;
        r7.addView(r4, r8);
    L27:
        this.D = zq().getRtcManager();
        this.x1.c();
        i0 r11 = j0.a;
        this.A = j0.c(((Widget) this).dataCenter, this);
        tc0.c.h().B = 5;
        ConstraintLayout r12 = ((Widget) this).contentView.findViewById(2131363980);
        if (r12 == null) goto L291;
        ConstraintLayout r13 = r12;
        Context r14 = ((Widget) this).context;
        DataCenter r15 = ((Widget) this).dataCenter;
        IRoom r16 = getMRoom();
        eh0.b r17 = this.e;
        if (r17 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L32:
        com.bytedance.android.live.liveinteract.plantform.utils.u r18 = new com.bytedance.android.live.liveinteract.plantform.utils.u(r14, r15, r13, r16, this, r17, this);
        this.L = r18;
        r18.j();
        this.P = new InteractAnimationController(((Widget) this).dataCenter);
        InteractAnimationContext r19 = (InteractAnimationContext) com.bytedance.live.datacontext.d.a(C03141.INSTANCE).component1();
        r19.getController().d(this.P);
        com.bytedance.live.datacontext.b.a(r19, InteractAnimationContext.class);
        Pair r20 = com.bytedance.live.datacontext.d.a(AnonymousClass2.INSTANCE);
        VoiceChatAnchorDataContext r21 = (VoiceChatAnchorDataContext) r20.component1();
        Disposable r22 = (Disposable) r20.component2();
        r21.getService().d(this);
        com.bytedance.live.datacontext.b.a(r21, "audio_talk_context");
        this.m.add(r22);
        Pair r23 = com.bytedance.live.datacontext.d.a(AnonymousClass3.INSTANCE);
        VoiceChatGlobalDataContext r24 = (VoiceChatGlobalDataContext) r23.component1();
        Disposable r25 = (Disposable) r23.component2();
        r24.getVoiceChatAdminService().d(this);
        com.bytedance.live.datacontext.b.a(r24, IVoiceChatAdminService.TAG);
        this.m.add(r25);
        Pair r26 = com.bytedance.live.datacontext.d.a(MultiLinkVoiceChatRoomAnchorWidget$initAdminInviteAndApplyViewModel$1.INSTANCE);
        AdminInviteAndApplyViewModel r27 = (AdminInviteAndApplyViewModel) r26.component1();
        Disposable r28 = (Disposable) r26.component2();
        com.bytedance.live.datacontext.b.a(r27, AdminInviteAndApplyViewModel.TAG);
        this.m.add(r28);
        wn0.a r29 = new wn0.a(((Widget) this).dataCenter, this, this.P);
        this.E = r29;
        zj0.f.b r30 = new zj0.f.b(0, 0, 0, null, 31);
        MultiLinkVoiceChatRoomAnchorWidget$registerWindowMangers$1 r31 = new MultiLinkVoiceChatRoomAnchorWidget$registerWindowMangers$1(this);
        Intrinsics.checkNotNullParameter(r30, "layoutConfig");
        Intrinsics.checkNotNullParameter(r31, "provider");
        r29.a.add(r30);
        r29.b.put(r30.f, r31);
        i0 r32 = this.A;
        if (r32 == null) goto L35;
        r32.d(f0.b, new com.bytedance.android.live.multilink.voicechat.impl.widget.g(this));
    L35:
        long r33 = SystemClock.elapsedRealtime();
        this.I = r33;
        ((Widget) this).dataCenter.put("data_room_audio_chat_anchor_uilayout_start_time", Long.valueOf(r33));
        com.bytedance.android.live.liveinteract.plantform.core.y r34 = yq();
        Intrinsics.checkNotNull(r34);
        boolean r110 = true;
        this.v1 = new com.bytedance.android.live.liveinteract.videotalk.utils.a(r34, true, ((Widget) this).dataCenter);
        r24.getUserInfoCenter().d(yq());
        enableSubWidgetManager();
        r24.getSubWidgetManager().d(((Widget) this).subWidgetManager);
        getMRoom();
        com.bytedance.android.livesdk.chatroom.u r35 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        zq();
        this.B = new MultiLinkVoiceChatAnchorPresenter(r35);
        this.G = new WeakHandler(this);
        this.R = new com.bytedance.android.live.liveinteract.voicechat.util.k(((Widget) this).dataCenter, com.bytedance.android.live.liveinteract.api.utils.m.j(this));
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r36 = MultiRevenueDataContext.a.d();
        if (r36 != null) goto L38;
    L41:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r37 = MultiRevenueDataContext.a.d();
        if (r37 == null) goto L45;
        r37.p(this, SceneType.SCENE_AUDIO_TALKROOM, this.A, false);
    L45:
        if (this.Y != null) goto L48;
        enableSubWidgetManager();
        QuickInteractWidget r38 = new QuickInteractWidget();
        this.Y = r38;
        ((Widget) this).subWidgetManager.load(r38);
    L48:
        if (this.L0 != null) goto L51;
        enableSubWidgetManager();
        CustomizeStreamWidget r39 = new CustomizeStreamWidget();
        this.L0 = r39;
        ((Widget) this).subWidgetManager.load(r39);
    L51:
        if (this.P0 != null) goto L58;
        enableSubWidgetManager();
        IKtvService r40 = jc1.k.f(IKtvService.class);
        if (r40 == null) goto L55;
        Widget r41 = r40.createPcAudioWidget();
    L56:
        this.P0 = r41;
        ((Widget) this).subWidgetManager.load(r41);
        goto L58
    L55:
        r41 = null;
    L58:
        if (((Boolean) ib0.a.getValue()).booleanValue() == false) goto L67;
        View r42 = ((Widget) this).contentView;
        if (r42 == null) goto L76;
        HSImageView r43 = r42.findViewById(2131384400);
        if (r43 == null) goto L76;
        of0.b r44 = InteractiveSongContext.Companion.c();
        if (r44 == null) goto L76;
        r44.e7(r43);
    L76:
        InteractiveSongContext.a r45 = InteractiveSongContext.Companion;
        if (r45.getContext() == null) goto L80;
        InteractiveSongContext r46 = r45.getContext();
        Intrinsics.checkNotNull(r46);
        this.m.add(r46.getSingingGuestId().a().subscribe(new com.bytedance.android.live.multilink.voicechat.impl.widget.i(this)));
    L80:
        if (this.h1 != null) goto L83;
        enableSubWidgetManager();
        RTSVoiceWidget r47 = new RTSVoiceWidget(this.D, yq(), r10, 12);
        this.h1 = r47;
        ((Widget) this).subWidgetManager.load(r47);
    L83:
        if (this.H0 != null) goto L86;
        enableSubWidgetManager();
        AudioChatStageWidget r48 = new AudioChatStageWidget();
        this.H0 = r48;
        ((Widget) this).subWidgetManager.load(r48);
    L86:
        if (this.k0 != null) goto L99;
        enableSubWidgetManager();
        this.k0 = new LinkmicSubtitleBusinessWidget();
        vb6.g r49 = Iq();
        if (r49 == null) goto L94;
        yb6.e r50 = r49.j();
        if (r50 == null) goto L94;
        LinkmicSubtitleBusinessWidget r51 = this.k0;
        if (r51 == null) goto L94;
        Intrinsics.checkNotNullParameter(r50, "mediaManager");
        r51.c = r50;
    L94:
        LinkmicSubtitleBusinessWidget r52 = this.k0;
        if (r52 == null) goto L97;
        com.bytedance.android.live.pushstream.d r53 = this.z;
        Intrinsics.checkNotNullParameter(r53, "liveStream");
        r52.d = r53;
    L97:
        ((Widget) this).subWidgetManager.load(this.k0);
    L99:
        if (this.p0 != null) goto L102;
        enableSubWidgetManager();
        InteractActingWidget r54 = new InteractActingWidget();
        this.p0 = r54;
        ((Widget) this).subWidgetManager.load(r54);
    L102:
        if (this.Z != null) goto L105;
        enableSubWidgetManager();
        CPositionWidget r55 = new CPositionWidget();
        this.Z = r55;
        ((Widget) this).subWidgetManager.load(r55);
    L105:
        if (this.g1 != null) goto L113;
        enableSubWidgetManager();
        if (MultiLinkLoadWidgetUtils.g() == true) goto L109;
        HamletInterceptTouchFrameLayout r56 = (HamletInterceptTouchFrameLayout) findViewById(2131374185);
    L110:
        if (r56 == null) goto L112;
        r56.setDataCenter(((Widget) this).dataCenter);
    L112:
        HamletAvatarWidget r57 = new HamletAvatarWidget(r56, new MultiLinkVoiceChatRoomAnchorWidget$loadHamletAvatarWidget$1(this), new MultiLinkVoiceChatRoomAnchorWidget$loadHamletAvatarWidget$2(this));
        this.g1 = r57;
        ((Widget) this).subWidgetManager.load(r57);
        goto L113
    L109:
        r56 = new HamletInterceptTouchFrameLayout(((Widget) this).context, null);
        zd0.c r58 = new zd0.c(r56);
        int r59 = vd0.a.g;
        vd0.a.C0284a.a(((Widget) this).dataCenter).b(3000, 3002, r58);
    L113:
        com.bytedance.live.datacontext.j r60 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        StringBuilder r61 = new StringBuilder("MultiVoiceAnchorWidget onCreate, scene = ");
        if (r60 == null) goto L120;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r62 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r60.getValue();
        if (r62 == null) goto L120;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r63 = r62.t();
        if (r63 == null) goto L120;
        Integer r65 = Integer.valueOf(r63.a);
    L121:
        r61.append(r65);
        r61.append(", uiLayout = ");
        if (r60 == null) goto L128;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r66 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r60.getValue();
        if (r66 == null) goto L128;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r67 = r66.t();
        if (r67 == null) goto L128;
        Integer r68 = Integer.valueOf(r67.b);
    L129:
        r61.append(r68);
        jy0.b.c("ttlive_link", r61.toString(), null, 4);
        if (r60 == null) goto L143;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r69 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r60.getValue();
        if (r69 == null) goto L143;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r70 = r69.t();
        if (r70 == null) goto L143;
        wn0.a r71 = this.E;
        if (r71 == null) goto L138;
        wn0.a.d(r71, new zj0.c.b(r70.a, r70.b), r70.c, r70.a(), false, null, 24);
    L138:
        hg6.g r72 = R1();
        if (r72 == null) goto L143;
        fg6.b r73 = r72.F();
        if (r73 == null) goto L143;
        r73.b(pg6.a.b(r70));
    L143:
        IRoom r74 = getMRoom();
        Intrinsics.checkNotNull(r74);
        VoiceChatMuteManager r111 = new VoiceChatMuteManager(r74, true, yq(), ((Widget) this).dataCenter, this, this, this);
        this.C = r111;
        r111.j();
        DataCenter r75 = ((Widget) this).dataCenter;
        com.bytedance.android.live.liveinteract.plantform.core.y r76 = yq();
        VoiceChatMuteManager r77 = this.C;
        if (r77 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L146:
        this.S = new MuteStateChecker(r75, r76, r77);
        MultiLinkVoiceChatAnchorPresenter r78 = this.B;
        if (r78 == null) goto L149;
        r78.g0(this);
    L149:
        y3.m(((Widget) this).dataCenter).k(ToolbarButton.INTERACTION_ROOM, this.Q);
        this.Q.b(0);
        this.J.g();
        if (vm2.e.a() == true) goto L152;
    L158:
        com.bytedance.android.livesdk.chatroom.u r79 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        com.bytedance.live.datacontext.j r80 = r79.s();
        if (r80 == null) goto L161;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r81 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r80.getValue();
    L162:
        if (r81 == null) goto L185;
        com.bytedance.live.datacontext.j r82 = r79.s();
        if (r82 == null) goto L166;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r83 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r82.getValue();
    L167:
        Intrinsics.checkNotNull(r83);
        if (r83.t().a == 9) goto L180;
        if (ar() == false) goto L172;
        kr("radio");
        goto L185
    L172:
        if (getUILayout() != 29) goto L174;
        boolean r84 = true;
    L175:
        if (r84 == false) goto L177;
        f2.b(2131919224, 0);
        goto L185
    L177:
        f2.b(2131919222, 0);
        goto L185
    L174:
        r84 = false;
        goto L175
    L180:
        if (ar() == true) goto L183;
        f2.b(2131919328, 0);
        goto L185
    L183:
        if (kr("ktv") == true) goto L185;
        f2.b(2131919328, 0);
        goto L185
    L166:
        r83 = null;
    L185:
        ((Widget) this).dataCenter.observe("cmd_open_interact_manage_dialog_by_anchor", this);
        ((Widget) this).dataCenter.observe("cmd_audio_talk_invite", this);
        ((Widget) this).dataCenter.observe("data_member_count", this);
        ((Widget) this).dataCenter.observeForever("data_interact_anchor_param_change", this);
        ((Widget) this).dataCenter.observe("data_room_audio_chat_anchor_uilayout_switch_time", this);
        ((Widget) this).dataCenter.observe("cmd_auto_join_channel", this);
        ((Widget) this).dataCenter.observe("cmd_video_talk_guest_battle_open_panel", this);
        ((Widget) this).dataCenter.observe("cmd_operate_interact_media", this);
        ((Widget) this).dataCenter.observe("cmd_audio_chat_stage_position_update", this);
        ((Widget) this).dataCenter.observe("cmd_trans_interact_to_scene_btn", this);
        yq().Q4(this.S1);
        hr(zg1.h1.class, new m(this));
        hr(zg1.i1.class, new n(this));
        hr(o42.g.class, new o(this));
        hr(o42.l.class, new p(this));
        com.bytedance.android.live.core.utils.rxutils.j.a r85 = com.bytedance.android.live.core.utils.rxutils.j.a;
        this.U = com.bytedance.android.live.core.utils.rxutils.j.a(1, 1, TimeUnit.MINUTES).subscribe(new q(this));
        Disposable r86 = IKtvService.b.b(jc1.k.n(IKtvService.class), this, new r(this), 2);
        if (r86 == null) goto L188;
        RxUtilKt.c(r86, this.m);
    L188:
        com.bytedance.live.datacontext.k r87 = jc1.k.n(IKtvService.class).ktvComponentSingerChangedEvent();
        if (r87 == null) goto L192;
        this.m.add(r87.onEvent().subscribe(new e(this)));
    L192:
        if (vm2.d.w() == true) goto L195;
    L197:
        tf0.o r88 = this.F;
        if (r88 == null) goto L200;
        r88.f();
    L200:
        com.bytedance.live.datacontext.m r89 = jc1.k.n(IKtvService.class).getHasBgm();
        if (r89 == null) goto L203;
        this.m.add(r89.a().subscribe(new f(this)));
    L203:
        JSONArray r90 = new JSONArray();
        r90.put(7);
        LinkAudienceApi r91 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        String r92 = r90.toString();
        IRoom r93 = getMRoom();
        Intrinsics.checkNotNull(r93);
        ((SingleSubscribeProxy) r91.getAudienceSettings(r92, r93.getId()).compose(RxUtil.rxSchedulerHelper()).as(autoDispose())).subscribe(g.a, h.a);
        LinkAudienceApi r94 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        IRoom r95 = getMRoom();
        Intrinsics.checkNotNull(r95);
        ((ObservableSubscribeProxy) r94.fetchInteractEntrances(r95.getRoomId()).compose(RxUtil.rxSchedulerHelper()).as(autoDispose())).subscribe(new i(this), j.a);
        if (vm2.d.U0() == false) goto L208;
        com.bytedance.live.datacontext.k r96 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).L();
        if (r96 == null) goto L208;
        this.m.add(RxUtilKt.p(r96.onEvent(), "MultiLinkVoiceChatRoomAnchorWidgetByCopy", new MultiLinkVoiceChatRoomAnchorWidget$onCreate$$inlined$let$lambda$1(this)));
    L208:
        DataCenter r97 = ((Widget) this).dataCenter;
        Boolean r98 = Boolean.FALSE;
        if (((Boolean) r97.get("cmd_ready_starting_live", r98)).booleanValue() == false) goto L211;
        jr();
    L211:
        DataCenter r99 = ((Widget) this).dataCenter;
        if (r99 == null) goto L219;
        jd0.c r100 = (jd0.c) r99.get("data_gift_message_board_linkmic_event", new jd0.c(0));
        if (r100.a.length() > 0) goto L217;
        r110 = false;
    L217:
        if (r110 == false) goto L219;
        xs2.b.a().post(r100);
        ((Widget) this).dataCenter.put("data_gift_message_board_linkmic_event", null);
    L219:
        com.bytedance.android.live.liveinteract.linksecurity.c r101 = com.bytedance.android.live.liveinteract.linksecurity.c.g;
        r101.j();
        r101.k(((Widget) this).dataCenter);
        IKtvService r102 = jc1.k.f(IKtvService.class);
        if (r102 == null) goto L227;
        com.bytedance.live.datacontext.m r103 = r102.getKtvComponentStatusChangedObservable();
        if (r103 == null) goto L225;
        this.m.add(r103.a().subscribe(new com.bytedance.android.live.multilink.voicechat.impl.widget.k(this)));
    L225:
        if (vm2.d.k0() == false) goto L227;
        IKtvService.b.b(r102, this, new com.bytedance.android.live.multilink.voicechat.impl.widget.l(this), 2);
    L227:
        int r104 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.b(getMRoom()) == true) goto L230;
    L236:
        com.bytedance.android.live.liveinteract.api.utils.p r105 = this.u;
        if (r105 == null) goto L240;
        IRoom r106 = getMRoom();
        Intrinsics.checkNotNull(r106);
        r105.a(r106.getRoomId());
    L240:
        if (((Boolean) ((Widget) this).dataCenter.get("data_audio_chat_continue_linkmic_update_send_gift_status", r98)).booleanValue() == false) goto L242;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().Nf();
        ((Widget) this).dataCenter.put("data_audio_chat_continue_linkmic_update_send_gift_status", r98);
    L242:
        com.bytedance.android.live.liveinteract.plantform.core.h r107 = new com.bytedance.android.live.liveinteract.plantform.core.h(getMRoom(), ((Widget) this).dataCenter, yq());
        this.t = r107;
        r107.a();
        hg6.g r108 = this.D;
        if (r108 == null) goto L245;
        ei6.a r109 = r108.V0();
    L246:
        hg6.g r112 = this.D;
        if (r112 == null) goto L253;
        ec6.b r113 = r112.R();
        if (r113 == null) goto L253;
        com.bytedance.android.live.pushstream.d r114 = gc6.b.a(r113);
        if (r114 == null) goto L253;
        r10 = r114.getLiveCore();
    L253:
        if (r109 == null) goto L259;
        if (r10 == null) goto L259;
        com.bytedance.android.live.liveinteract.plantform.core.h r115 = this.t;
        if (r115 == null) goto L259;
        r115.d(new WeakReference(r109), new WeakReference(r10));
    L259:
        if (vm2.d.K0() == true) goto L261;
    L263:
        br();
        xs2.b.a().post(new pe0.a());
        LinkMicRoomDataSyncModel r116 = LinkWRDSHelper.b();
        if (r116 == null) goto L272;
        dc2.c r117 = r116.getTalkRoomListUserInfoPb();
        if (r117 == null) goto L272;
        Observable r118 = r117.d;
        if (r118 == null) goto L272;
        Disposable r119 = r118.subscribe(new k(this));
        if (r119 == null) goto L272;
        RxUtilKt.c(r119, this.m);
    L272:
        com.bytedance.android.live.liveinteract.plantform.base.g r120 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r120 == null) goto L278;
        com.bytedance.android.live.ui.c r121 = r120.y4();
        if (r121 == null) goto L278;
        com.bytedance.android.live.multilink.voicechat.impl.widget.h r122 = new com.bytedance.android.live.multilink.voicechat.impl.widget.h(this);
        Intrinsics.checkNotNullParameter(r122, "intercept");
        r121.i = r122;
    L278:
        if (((Boolean) nm.a.getValue()).booleanValue() == true) goto L280;
    L286:
        Yq();
        Disposable r123 = xs2.b.a().b(jd0.a.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(this));
        if (r123 == null) goto L292;
        RxUtilKt.c(r123, this.m);
        return;
    L292:
        return;
    L280:
        if (Zq() == false) goto L286;
        com.bytedance.android.live.liveinteract.plantform.base.g r124 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r124 == null) goto L286;
        com.bytedance.android.live.ui.c r125 = r124.y4();
        if (r125 == null) goto L286;
        r125.k();
        goto L286
    L261:
        if (vm2.d.h() == false) goto L263;
        GLSurfaceView r126 = (GLSurfaceView) ((Widget) this).containerView.findViewById(2131375529);
        j50.a r127 = new j50.a();
        this.g2 = r127;
        Intrinsics.checkNotNull(r127);
        r127.e = new j50.b(r126);
        r126.setVisibility(0);
        Context r128 = ((Widget) this).context;
        j50.a r129 = this.g2;
        Intrinsics.checkNotNull(r129);
        v50.a.a(r126, r128, r129, new com.bytedance.android.live.core.gl.primitive.a());
        k50.c r130 = new k50.c(r126);
        this.h2 = r130;
        Intrinsics.checkNotNull(r130);
        r130.a();
        j50.a r131 = this.g2;
        Intrinsics.checkNotNull(r131);
        k50.e.c(r126, r131);
        k50.c r132 = this.h2;
        Intrinsics.checkNotNull(r132);
        k50.e.b(r126, r132);
        goto L263
    L245:
        r109 = null;
        goto L246
    L230:
        if (((Boolean) com.bytedance.android.live.core.setting.t.a.getValue()).booleanValue() == false) goto L236;
        if (isEngineOn() == true) goto L240;
        com.bytedance.live.bizlink.impl.platform.manager.a r133 = zq().A0();
        if (r133 == null) goto L240;
        r133.g();
        goto L240
    L195:
        if (this.X != null) goto L197;
        enableSubWidgetManager();
        ChatMatchWidget r134 = new ChatMatchWidget(true, this);
        this.X = r134;
        ((Widget) this).subWidgetManager.load(r134);
        goto L197
    L161:
        r81 = null;
        goto L162
    L152:
        if ((getContext() instanceof FragmentActivity) == false) goto L158;
        InteractLiveCorePermissionGuarantor r135 = Tq();
        Context r136 = getContext();
        if (r136 == null) goto L157;
        r135.i((FragmentActivity) r136);
        goto L158
    L157:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L128:
        r68 = null;
    L120:
        r65 = null;
        goto L121
    L67:
        if (this.b1 != null) goto L76;
        enableSubWidgetManager();
        InteractiveSongWidget r137 = qf0.b.a();
        this.b1 = r137;
        if (r137 == null) goto L75;
        View r138 = ((Widget) this).contentView;
        if (r138 == null) goto L75;
        if ((r138.findViewById(2131384400) instanceof HSImageView) == false) goto L75;
        InteractiveSongWidget r139 = this.b1;
        Intrinsics.checkNotNull(r139);
        r139.e7((HSImageView) ((Widget) this).contentView.findViewById(2131384400));
    L75:
        ((Widget) this).subWidgetManager.load(this.b1);
        goto L76
    L38:
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == true) goto L40;
        r36.o(((Widget) this).dataCenter, this, SceneType.SCENE_AUDIO_TALKROOM, (ViewGroup) ((Widget) this).contentView.findViewById(2131388184));
    L40:
        r36.d(((Widget) this).dataCenter);
        goto L41
    L291:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L12:
        r4 = null;
        goto L14
    L7:
        r2 = null;
    L13:
        r4 = new VoiceCommonLinkSeatWindowView(((Widget) this).context, r10, 6, r9);
        r4.setId(2131378011);
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        multiLinkRoomScopeFallback();
        Disposable r1 = this.K;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        this.x1.b();
        yf6.a r2 = Nq();
        if (r2 == null) goto L8;
        r2.f();
    L8:
        com.bytedance.android.live.liveinteract.plantform.core.h r3 = this.t;
        if (r3 == null) goto L11;
        Intrinsics.checkNotNull(r3);
        r3.b();
    L11:
        he0.b r4 = this.p;
        if (r4 == null) goto L19;
        j1 r5 = r4.g;
        if (r5 == null) goto L19;
        dn0.c r6 = (dn0.c) r5.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r6 == null) goto L18;
        r6.H4("RadioStreamMixer onDestroy");
    L18:
        r4.g = null;
    L19:
        InteractAnimationController r7 = this.P;
        if (r7 == null) goto L22;
        Intrinsics.checkNotNull(r7);
        r7.l();
    L22:
        this.J.i();
        jy0.b.a("InteractAnimationController", "before unloadAnimRenderWidget");
        MiddlewareRoomWidget r8 = this.k1;
        if (r8 == null) goto L28;
        WidgetManager r9 = ((Widget) this).subWidgetManager;
        if (r9 == null) goto L27;
        r9.unload(r8);
    L27:
        this.k1 = null;
    L28:
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r10 = com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.a;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.d("talkroom destroy");
        if (vm2.e.a() == false) goto L31;
        Tq().e();
    L31:
        DataCenter r11 = ((Widget) this).dataCenter;
        Boolean r12 = Boolean.FALSE;
        r11.put("data_self_is_silenced", r12);
        ((Widget) this).dataCenter.removeObserver(this);
        IRoom r13 = getMRoom();
        Intrinsics.checkNotNull(r13);
        if (r13.getLinkInitResult() == null) goto L34;
        boolean r14 = true;
    L36:
        if (isKtvOn() == false) goto L39;
        com.bytedance.android.live.liveinteract.voicechat.util.k r15 = this.R;
        Intrinsics.checkNotNull(r15);
        r15.e(this.I, r14);
    L39:
        if (this.R == null) goto L52;
        String r16 = com.bytedance.android.live.liveinteract.plantform.utils.i.a(Qq(), Rq(), true);
        if (Rq() != 0) goto L43;
    L45:
        int r17 = TalkRoomLogUtils.b.a;
    L46:
        String r18 = com.bytedance.android.live.liveinteract.plantform.utils.u0.i(Integer.valueOf(Rq()), je0.d.d(), Integer.valueOf(r17));
        String r19 = com.bytedance.android.live.liveinteract.plantform.utils.u0.f(Integer.valueOf(Rq()), Integer.valueOf(Qq()), je0.d.d(), Integer.valueOf(r17), null, null, 48);
        com.bytedance.android.live.liveinteract.voicechat.util.k r20 = this.R;
        if (r20 == null) goto L49;
        com.bytedance.android.live.liveinteract.voicechat.util.k.i(r20, r16, r18, r19, 48);
    L49:
        com.bytedance.android.live.liveinteract.voicechat.util.k r21 = this.R;
        if (r21 == null) goto L52;
        r21.j(this.I, Qq(), Integer.valueOf(Rq()), r14, getMRoom().getCircleInfo(), r16, r18);
        goto L52
    L43:
        if (TalkRoomLogUtils.b.a != 0) goto L45;
        r17 = Rq();
    L52:
        mz0.f r22 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if ((r22 instanceof mz0.f) == true) goto L55;
    L57:
        tc0.c.h().j(r12);
        MultiLinkVoiceChatAnchorPresenter r23 = this.B;
        if (r23 == null) goto L60;
        r23.detachView();
    L60:
        tf0.o r24 = this.F;
        if (r24 == null) goto L63;
        r24.end();
    L63:
        VoiceChatMuteManager r25 = this.C;
        if (r25 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L66:
        r25.n();
        com.bytedance.android.live.liveinteract.videotalk.utils.a r26 = this.v1;
        Intrinsics.checkNotNull(r26);
        r26.c();
        this.Q.b(8);
        y3.m(((Widget) this).dataCenter).d(ToolbarButton.INTERACTION_ROOM, this.Q);
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L70;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().uo();
    L70:
        if (this.m.isDisposed() == true) goto L72;
        this.m.dispose();
    L72:
        com.bytedance.android.live.liveinteract.api.utils.p r27 = this.u;
        if (r27 == null) goto L75;
        r27.b();
    L75:
        Disposable r28 = this.U;
        if (r28 == null) goto L80;
        Intrinsics.checkNotNull(r28);
        if (r28.isDisposed() == true) goto L80;
        Disposable r29 = this.U;
        Intrinsics.checkNotNull(r29);
        r29.dispose();
    L80:
        cr();
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L84;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().Sc();
    L84:
        if (vm2.d.j0() == false) goto L95;
        WidgetManager r30 = ((Widget) this).subWidgetManager;
        if (r30 == null) goto L95;
        List r31 = r30.widgets;
        if (r31 == null) goto L95;
        if (r31.size() <= 0) goto L95;
        Iterator r32 = ((Widget) this).subWidgetManager.widgets.iterator();
    L93:
        if (r32.hasNext() == false) goto L95;
        Widget r33 = (Widget) r32.next();
        ((Widget) this).subWidgetManager.unload(r33);
    L95:
        super.onDestroy();
        com.bytedance.live.datacontext.j r34 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r34 == null) goto L100;
        LivePlayModeLogContext r35 = (LivePlayModeLogContext) r34.getValue();
        if (r35 == null) goto L100;
        r35.clearPlayModesOnlySupportMultiPeople();
    L100:
        com.bytedance.android.live.liveinteract.linksecurity.c.g.l();
        d0(sh0.d0.b, null);
        i0 r36 = j0.a;
        j0.b(((Widget) this).dataCenter);
        hg6.g r37 = this.D;
        if (r37 == null) goto L104;
        r37.i(false);
    L104:
        if (vm2.d.K0() == true) goto L106;
    L110:
        com.bytedance.android.live.liveinteract.plantform.utils.u r38 = this.L;
        if (r38 == null) goto L115;
        r38.k();
        return;
    L115:
        return;
    L106:
        if (vm2.d.h() == false) goto L110;
        this.g2 = null;
        k50.c r39 = this.h2;
        if (r39 == null) goto L110;
        Intrinsics.checkNotNull(r39);
        r39.b = true;
        this.h2 = null;
        goto L110
    L55:
        if (r22.o() == false) goto L57;
        jc1.k.n(IMiddlewareHostAction.class).dismissInvitePanel();
        goto L57
    L34:
        r14 = false;
        goto L36
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final void onVoiceAnchorAvatarClicked() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.put("cmd_open_interact_manage_dialog_by_anchor", Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.a
    public final Boolean t0() {
        return Boolean.valueOf(this.z.t0());
    }

    @Override // wn0.a.c
    public final Pair<Integer, Integer> x3() {
        return new Pair(0, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseAnchorLinkWidget
    public final yf6.a Nq() {
        rf6.a r0 = wq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g();
    }

    @Override // he0.b.a
    public final List<Integer> R4() {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.getValue();
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r2 = r1.t();
        if (r2 == null) goto L11;
        ClientUIInfo r3 = r2.a();
        if (r3 == null) goto L11;
        return r3.getUiFeatureList();
    L11:
        return null;
    }

    public final int Sq() {
        com.bytedance.android.live.liveinteract.plantform.core.y r0 = yq();
        Intrinsics.checkNotNull(r0);
        ILinkPlayerInfoBridge r1 = (ILinkPlayerInfoBridge) r0.a5(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f);
        if (r1 != null) goto L7;
        return -1;
    L7:
        return r1.getSilenceStatus();
    }

    public final boolean Zq() {
        tc0.c r0 = tc0.c.h();
        if (r0 == null) goto L11;
        Map r1 = r0.o;
        if (r1 == null) goto L11;
        Map.Entry r2 = z0.a(r1);
        if (r2 == null) goto L11;
        g2 r3 = (g2) r2.getValue();
        if (r3 == null) goto L11;
        Long r4 = Long.valueOf(r3.getLiveRoomMode());
    L13:
        if (aj0.a.c(Qq()) == false) goto L19;
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

    public final boolean ar() {
        IRoom r0 = getMRoom();
        Intrinsics.checkNotNull(r0);
        if (r0.getLinkInitResult() == null) goto L9;
        IRoom r1 = getMRoom();
        Intrinsics.checkNotNull(r1);
        if (r1.getLinkMicScene() == 5) goto L8;
        IRoom r2 = getMRoom();
        Intrinsics.checkNotNull(r2);
        if (r2.getLinkMicScene() != 9) goto L9;
    L8:
        return true;
    L9:
        return false;
    }

    public final void br() {
        if (Qq() != 9) goto L6;
        return;
    L6:
        if (this.k1 != null) goto L11;
        jy0.b.b("InteractAnimationController", "before loadAnimRenderWidget", new Throwable());
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r0 = MultiRevenueDataContext.a.d();
        if (r0 == null) goto L12;
        jy0.b.a("InteractAnimationController", "loadAnimRenderWidget");
        this.k1 = r0.e(this, SceneType.SCENE_AUDIO_TALKROOM, (ViewGroup) ((Widget) this).contentView.findViewById(2131388184));
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final ILinkPlayerInfoBridge currentCPositionUser() {
        if (yq().c.isEmpty() == true) goto L12;
        Iterator<ILinkPlayerInfoBridge> r0 = yq().c.iterator();
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

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final String currentCPositionUserType() {
        if (yq().c.isEmpty() == true) goto L19;
        Iterator<ILinkPlayerInfoBridge> r0 = yq().c.iterator();
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
        return Bq();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final int getCurrentScene() {
        return Qq();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter() {
        return yq();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final List<ILinkPlayerInfoBridge> getLinkWaitingList() {
        return yq().f;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final List<ILinkPlayerInfoBridge> getOnlineUserList() {
        return yq().c;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return Qq();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final int getSelfSilenceType() {
        if (isEngineOn() == true) goto L7;
        return 0;
    L7:
        return Sq();
    }

    @Override // he0.b.a
    public final int getUILayout() {
        Integer r0 = je0.d.h();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final boolean isKtvOn() {
        if (Qq() != 9) goto L5;
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

    public final void jr() {
        com.bytedance.android.livesdk.chatroom.u r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        com.bytedance.live.datacontext.m r1 = r0.c();
        if (r1 != null) goto L5;
        return;
    L5:
        if (((Number) r1.getValue()).intValue() != OpenPanelType.PAID_LINK_SETTING_PANEL.getValue()) goto L21;
        IInteractService r2 = (IInteractService) jc1.k.n(IInteractService.class);
        if (r2.paidLinkMicService() != null) goto L9;
    L16:
        com.bytedance.live.datacontext.m r3 = r0.c();
        if (r3 == null) goto L22;
        r3.setValue(Integer.valueOf(OpenPanelType.NONE.getValue()));
        return;
    L22:
        return;
    L9:
        if (r2.paidLinkMicService().needIntercepted() == true) goto L16;
        qd0.a r4 = r2.getAudioTalkService();
        Context r5 = ((Widget) this).context;
        com.bytedance.live.datacontext.m r6 = r0.p();
        if (r6 == null) goto L14;
        String r7 = (String) r6.getValue();
        if (r7 == null) goto L14;
    L15:
        r4.c(r5, r7);
    L14:
        r7 = "";
        goto L15
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final void onResume() {
        super.onResume();
        boolean r0 = true;
        this.O = true;
        hg6.g r1 = this.D;
        if (r1 == null) goto L5;
        r1.onResume();
    L5:
        WeakHandler r2 = this.G;
        Intrinsics.checkNotNull(r2);
        r2.removeCallbacksAndMessages(null);
        if (vm2.e.a() == false) goto L9;
        Tq().g();
    L9:
        if (((Boolean) vm2.h.o0.getValue(null, vm2.h.a[65])).booleanValue() == true) goto L12;
        r0 = isEngineOn();
    L12:
        if (r0 == true) goto L14;
    L42:
        hg6.g r3 = this.D;
        if (r3 == null) goto L45;
        r3.i(com.bytedance.android.live.liveinteract.spatial.a.e(C0()));
    L45:
        yq().r0();
        return;
    L14:
        if (this.z == null) goto L42;
        if (Jq() == null) goto L19;
        u0 r4 = Jq();
        Intrinsics.checkNotNull(r4);
        r4.resume();
    L19:
        if (vm2.e.a() == false) goto L23;
        if (Tq().p == false) goto L23;
    L29:
        if (((Boolean) vm2.d.i0.getValue(null, vm2.d.a[58])).booleanValue() == true) goto L31;
    L37:
        jg6.a r5 = Bq();
        if (r5 == null) goto L42;
        kg6.e r6 = r5.b();
        if (r6 == null) goto L42;
        r6.y(false, "onResume");
        goto L42
    L31:
        if (this.z.t0() == true) goto L37;
        jg6.a r7 = zq().e5();
        if (r7 == null) goto L37;
        kg6.e r8 = r7.b();
        if (r8 == null) goto L37;
        r8.f("live resume");
    L23:
        if (Sq() != 3) goto L29;
        VoiceChatMuteManager r9 = this.C;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L27:
        r9.l("onResume");
        goto L29
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        if (vm2.e.a() == false) goto L6;
        Tq().h();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseAnchorLinkWidget
    public final BizLinkServiceType Gq() {
        return BizLinkServiceType.VoiceAnchor;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final void H1() {
        super.H1();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseAnchorLinkWidget
    public final tf0.o Mq() {
        return this.F;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final com.bytedance.android.live.pushstream.d Ri() {
        return this.z;
    }

    @Override // tf0.o.a
    public final HashMap Y7() {
        return kk0.h.f2;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final tf0.o commonWindowManager() {
        return this.F;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final int getAnchorManualUiLayout() {
        return this.M;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final tf0.h getInteractAnimationService() {
        return this.P;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final tf0.m getSwitchLayoutStatisticsUtils() {
        return this.Q1;
    }

    @Override // he0.b.a
    public final int he() {
        return this.L1;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final boolean ktvWillAutoSilenceSelf() {
        return this.x;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final hg6.g rtcManger() {
        return this.D;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final rj0.h videoStylePaidLinkManager() {
        return this.J;
    }

    @Override // tf0.o.a
    public final int Aa(SurfaceView r6) {
        e0 r0 = tc0.c.h().s;
        Boolean r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getRivalsStreamId();
    L6:
        StringBuilder r3 = new StringBuilder("setPublicStreamVideoCanvas isEngineOn: ");
        hg6.g r4 = R1();
        if (r4 == null) goto L9;
        r1 = Boolean.valueOf(r4.isEngineOn());
    L9:
        r3.append(r1);
        r3.append(" id ");
        r3.append(r2);
        r3.append(" view ");
        r3.append(r6);
        ALogger.d(LinkRoomFightContext.TAG, r3.toString());
        int r5 = 0;
        if (r2 != null) goto L12;
    L19:
        hg6.g r7 = R1();
        if (r7 == null) goto L24;
        xi0.b r8 = r7.O();
        if (r8 == null) goto L24;
        r5 = r8.b0(String.valueOf(r2), r6);
    L24:
        ALogger.d(LinkRoomFightContext.TAG, "setPublicStreamVideoCanvas result " + r5);
        return r5;
    L12:
        if (r2.length() != 0) goto L14;
        boolean r9 = true;
    L15:
        if (r9 != true) goto L19;
        return -1;
    L14:
        r9 = false;
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L(String r2) {
        super.L(r2);
        jy0.b.a(LinkRoomFightContext.TAG, "onFirstRemoteAudioFrame linkId ".concat(r2));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final void Mi(int r2) {
        if (this.L1 == r2) goto L12;
        this.L1 = r2;
        hg6.g r3 = R1();
        if (r3 == null) goto L13;
        ei6.a r4 = r3.V0();
        if (r4 == null) goto L14;
        vi6.a r5 = r4.v();
        if (r5 == null) goto L15;
        r5.f();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // he0.b.a
    public final String N4(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        return yq().N4(r2);
    }

    @Override // tf0.o.a
    public final int Po(String r4) {
        ALogger.d(LinkRoomFightContext.TAG, "livecore version " + ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).getLiveCoreVersion());
        jy0.b.a(LinkRoomFightContext.TAG, "startPlayPublicStream id " + r4);
        if (r4 != null) goto L6;
        return -1;
    L6:
        hg6.g r0 = this.D;
        Intrinsics.checkNotNull(r0);
        xi0.b r1 = r0.O();
        if (r1 == null) goto L9;
        Integer r5 = Integer.valueOf(r1.l(r4));
    L10:
        jy0.b.a(LinkRoomFightContext.TAG, "startPlayPublicStream result " + r5);
        if (r5 != null) goto L15;
        return 0;
    L15:
        return r5.intValue();
    L9:
        r5 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.c
    public final int S0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        tf0.o r0 = this.F;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.h(r2);
    }

    @Override // kk0.f
    public final void Vj(ILinkPlayerInfoBridge r7) {
        Intrinsics.checkNotNullParameter(r7, "info");
        ILiveLinkCameraBackUpConfig r0 = vm2.g.c();
        if (ILiveLinkCameraBackUpConfigKt.supportMsgUpdateForAnchor(r0) == true) goto L6;
        return;
    L6:
        if (r7.getBaseUser() == null) goto L36;
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
        if (this.O == false) goto L45;
        uf2.d0 r3 = this.z.A();
        if (r3 == null) goto L22;
        boolean r4 = r3.t0();
    L24:
        if (r7.getSilenceStatus() == 0) goto L34;
        if (r4 == true) goto L33;
        int r5 = this.T + 1;
        this.T = r5;
        Set<Long> r6 = InteractLinkFullLinkMonitor.a;
        InteractLinkFullLinkMonitor.y(r5, null, Boolean.valueOf(r4), r7.getSilenceStatus(), r7.getLinkType());
        if (this.T < ILiveLinkCameraBackUpConfigKt.getSafeMaxDiffCount(r0)) goto L38;
        jg6.a r8 = Bq();
        if (r8 == null) goto L39;
        kg6.e r9 = r8.b();
        if (r9 == null) goto L40;
        r9.t(new kg6.b(false, false, "link security", 8));
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L33:
        this.T = 0;
        return;
    L34:
        this.T = 0;
        return;
    L22:
        r4 = false;
        goto L24
    L45:
        return;
    L10:
        r2 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void accept(IBaseUser r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        yf6.a r0 = Nq();
        if (r0 == null) goto L6;
        r0.b(r3, this.v);
        return;
    }

    @Override // com.bytedance.android.live.multilink.voicechat.impl.widget.MultiLinkVoiceChatAnchorPresenter.IView
    public final void f3(com.bytedance.android.livesdk.link.model.bridge.h1 r5) {
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

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final void finishAudioTalk(String r3) {
        Intrinsics.checkNotNullParameter(r3, "from");
        com.bytedance.android.live.liveinteract.voicechat.util.k r4 = this.R;
        Intrinsics.checkNotNull(r4);
        int r0 = Qq();
        int r1 = com.bytedance.android.live.liveinteract.voicechat.util.k.g;
        r4.getClass();
        com.bytedance.android.live.liveinteract.voicechat.util.k.n(r0, "");
        ((Widget) this).dataCenter.put("data_audio_talk_dot_with_number_show", "");
        yf6.a r5 = Nq();
        if (r5 == null) goto L5;
        r5.finish("stop_normally");
    L5:
        cr();
    }

    @Override // com.bytedance.android.live.multilink.voicechat.impl.widget.MultiLinkVoiceChatAnchorPresenter.IView
    public final void g9(com.bytedance.android.livesdk.link.model.bridge.h1 r5) {
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
        CPositionBeSetDialog r10 = this.M1;
        if (r10 != null) goto L32;
    L39:
        int r11 = CPositionBeSetDialog.j;
        getMRoom().getRoomId();
        CPositionBeSetDialog r12 = CPositionBeSetDialog.a.a(CPositionBeSetDialog.RoomType.Audio, r5);
        this.M1 = r12;
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

    public final void gr(int r6) {
        int r0 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        if (((Boolean) t2.a.getValue()).booleanValue() == true) goto L5;
    L17:
        boolean r1 = false;
    L18:
        if (r1 == true) goto L21;
        return;
    L21:
        if (r6 == 27) goto L26;
        Disposable r7 = this.K;
        if (r7 == null) goto L31;
        r7.dispose();
        return;
    L31:
        return;
    L26:
        Disposable r2 = this.K;
        if (r2 == null) goto L29;
        r2.dispose();
    L29:
        this.K = Observable.interval(0, 1, TimeUnit.SECONDS).take(11).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new s(this, r6));
        return;
    L5:
        if (gh0.a.d() == false) goto L17;
        com.bytedance.android.livesdk.chatroom.o r3 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r3 == null) goto L11;
        com.bytedance.live.datacontext.m r4 = r3.getRoom();
        if (r4 == null) goto L11;
        IRoom r5 = (IRoom) r4.getValue();
    L13:
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.b(r5) == false) goto L17;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.G0.getValue()).booleanValue() == true) goto L17;
        r1 = true;
    L11:
        r5 = null;
        goto L13
    }

    @Override // wn0.a.c
    public final void h4(tf0.o r2) {
        Intrinsics.checkNotNullParameter(r2, "windowManager");
        this.F = r2;
    }

    public final void handleMsg(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        isViewValid();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void invite(com.bytedance.android.live.liveinteract.videolink.a r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        yf6.a r0 = Nq();
        if (r0 == null) goto L6;
        r0.a(r3, this.w);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.c
    public final void j4(com.bytedance.android.live.liveinteract.videolink.a r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        int r0 = com.bytedance.android.live.liveinteract.utils.h1.a;
        com.bytedance.android.live.liveinteract.utils.h1.e(this.A, ((Widget) this).context, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void kickOut(IBaseUser r3) {
        Intrinsics.checkNotNullParameter(r3, "targetUser");
        yf6.a r0 = Nq();
        if (r0 == null) goto L6;
        r0.d(r3, "anchor_stop_normal");
        return;
    }

    public final boolean kr(String r8) {
        if (TextUtils.equals(r8, "ktv") == false) goto L5;
        int r0 = 2131918157;
    L6:
        String r4 = s1.B(r0);
        mz0.f r1 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if ((r1 instanceof mz0.f) == true) goto L9;
        return false;
    L9:
        if (r1.o() == false) goto L14;
        jc1.k.n(IMiddlewareHostAction.class).showInvitePanel(((Widget) this).context, getMRoom(), r4, "homepage_familiar", r8);
        return true;
    L14:
        return false;
    L5:
        r0 = 2131918158;
        goto L6
    }

    @Override // tf0.o.a
    public final void n1(boolean r1) {
        hg6.g r2 = this.D;
        Intrinsics.checkNotNull(r2);
        xi0.b r3 = r2.O();
        if (r3 == null) goto L6;
        r3.N();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseAnchorLinkWidget, he0.b.a
    public final void o9(List<ti6.f> r9) {
        HamletAvatarContext r0 = HamletAvatarContext.Companion.getContext();
        boolean r2 = false;
        String r3 = null;
        if (r0 == null) goto L20;
        gd0.g r4 = (gd0.g) r0.getHamletAvatarService().getValue();
        if (r4 == null) goto L7;
        r3 = r4.Ac();
    L7:
        if (r3 == null) goto L20;
        if (r4 == null) goto L20;
        if (r4.wp() == false) goto L20;
        com.bytedance.live.datacontext.m<Boolean> r5 = r0.isMultiAvatarMode();
        if (r5 == null) goto L20;
        if (((Boolean) r5.getValue()).booleanValue() != true) goto L20;
        if (r0.isMainStreamPublicStreamReady() != true) goto L20;
        if (r0.isMainStreamServerMixedStart() != true) goto L20;
        r2 = true;
    L20:
        if (r2 == false) goto L35;
        boolean r1 = ff0.c.b;
        if (r1 == false) goto L28;
        if (r9 == null) goto L28;
        Iterator<T> r6 = r9.iterator();
    L26:
        if (r6.hasNext() == false) goto L28;
        ((ti6.f) r6.next()).m = true;
    L28:
        ti6.f r7 = new ti6.f();
        boolean r8 = ff0.c.a;
        boolean r10 = ((Boolean) xz.a.getValue()).booleanValue();
        boolean r11 = ((Boolean) wz.a.getValue()).booleanValue();
        r7.a = 1;
        r7.f = 1.0d;
        r7.g = 1.0d;
        r7.y = r3;
        r7.d = 0.0d;
        r7.e = 0.0d;
        r7.o = 1;
        r7.A = r11;
        r7.z = r10;
        if (r1 == true) goto L31;
        r7.m = true;
    L31:
        if (r9 == null) goto L36;
        r9.add(r7);
        return;
    L36:
        return;
    }

    public final void onChanged(Object r5) {
        final KVData r6 = (KVData) r5;
        if (isViewValid() == false) goto L68;
        if (r6 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r6.getKey()) == false) goto L8;
        return;
    L8:
        if (r6.getData() == null) goto L84;
        String r0 = r6.getKey();
        if (Intrinsics.areEqual(r0, "cmd_open_interact_manage_dialog_by_anchor") == false) goto L31;
        if (((IInteractService) jc1.k.n(IInteractService.class)).isEnableTalkRoomEmoji() == false) goto L22;
        ILinkPlayerInfoBridge r7 = yq().p(je0.d.b0(), tc0.c.h().f);
        if (r7 == null) goto L21;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r7.getSilenceStatus() == 0) goto L19;
        boolean r8 = true;
    L20:
        r1.put("data_self_is_silenced", Boolean.valueOf(r8));
        goto L21
    L19:
        r8 = false;
    L21:
        com.bytedance.android.live.liveinteract.videotalk.emoji.t r9 = new com.bytedance.android.live.liveinteract.videotalk.emoji.t();
        r9.e(((Widget) this).context);
        r9.f(((Widget) this).dataCenter);
        r9.g(true);
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r9.d = "seat";
        r9.c().a();
        return;
    L22:
        Context r2 = ((Widget) this).context;
        VoiceChatMuteManager r3 = this.C;
        if (r3 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L25:
        com.bytedance.android.live.liveinteract.voicechat.dialog.q r10 = new com.bytedance.android.live.liveinteract.voicechat.dialog.q(r2, r3);
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L66;
        DialogLancet.handleBlockedDialogShow(r10);
        return;
    L66:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L65
    L29:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        return;
    L31:
        if (Intrinsics.areEqual(r0, "cmd_audio_talk_invite") == false) goto L34;
        s0.a(((Widget) this).context, new AnonymousClass1(this, r6));
        return;
    L34:
        if (Intrinsics.areEqual(r0, "data_member_count") == false) goto L36;
        return;
    L36:
        if (Intrinsics.areEqual(r0, "data_interact_anchor_param_change") == false) goto L39;
        hg6.g r4 = this.D;
        Intrinsics.checkNotNull(r4);
        Object r11 = r6.getData("");
        Intrinsics.checkNotNull(r11);
        r4.Q((String) r11);
        return;
    L39:
        if (Intrinsics.areEqual(r0, "data_room_audio_chat_anchor_uilayout_switch_time") == false) goto L44;
        Object r12 = r6.getData(0L);
        Intrinsics.checkNotNull(r12);
        long r13 = ((Number) r12).longValue();
        if (r13 <= this.I) goto L77;
        jy0.b.a("MultiLinkVoiceChatRoomAnchorWidgetByCopy", "update starttime : " + this.I + "->" + r13);
        this.I = r13;
        return;
    L77:
        return;
    L44:
        if (Intrinsics.areEqual(r0, "cmd_auto_join_channel") == false) goto L49;
        if (vm2.d.C() == false) goto L79;
        com.bytedance.live.bizlink.impl.platform.manager.a r14 = zq().A0();
        Intrinsics.checkNotNull(r14);
        r14.g();
        return;
    L79:
        return;
    L49:
        if (Intrinsics.areEqual(r0, "cmd_video_talk_guest_battle_open_panel") == false) goto L52;
        d0(sh0.g.b, (String) r6.getData());
        return;
    L52:
        if (Intrinsics.areEqual(r0, "cmd_operate_interact_media") == false) goto L61;
        MediaOperation r15 = (MediaOperation) r6.getData();
        if (r15 != null) goto L56;
        return;
    L56:
        if (r15.getType() != MediaOperation.Type.MIC) goto L85;
        int r16 = com.bytedance.android.live.multilink.voicechat.impl.widget.e.a;
        throw null;
    L85:
        return;
    L61:
        if (Intrinsics.areEqual(r0, "cmd_audio_chat_stage_position_update") == false) goto L63;
        int r17 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        com.bytedance.android.live.liveinteract.voicechat.stage.a.f(((Widget) this).dataCenter);
        return;
    L63:
        Intrinsics.areEqual(r0, "cmd_trans_interact_to_scene_btn");
        return;
    L84:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void onClientUIInfoChangeMessage(ILinkerClientUIInfoChangeContent r11) {
        if (r11 == null) goto L6;
        Long r0 = r11.getUiLayout();
        if (r0 == null) goto L6;
        int r1 = (int) r0.longValue();
    L7:
        ClientUIInfo r2 = null;
        if (r11 == null) goto L10;
        ClientUIInfo r3 = r11.getClientUIInfo();
    L11:
        this.P1 = r3;
        com.bytedance.live.datacontext.j r4 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r4 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r9 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r4.getValue();
        if (r9 == null) goto L25;
        if (r1 == r9.t().b) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r12 = new com.bytedance.android.livesdk.chatroom.viewmodel.i(Qq(), r1, je0.d.d(), false, false, this.P1);
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L20;
        r5.put("data_room_audio_chat_ui_layout_before", Integer.valueOf(r1));
    L20:
        r9.c(r9.t());
        r9.d(r12);
        goto L25
    L21:
        com.bytedance.android.livesdk.chatroom.viewmodel.i r6 = r9.t();
        if (r11 == null) goto L24;
        r2 = r11.getClientUIInfo();
    L24:
        r6.b(r2);
    L25:
        i0 r13 = j0.e(((Widget) this).dataCenter);
        if (r13 == null) goto L29;
        r13.d0(sh0.d.b, new sh0.h(Integer.valueOf(r1), this.P1));
        return;
    L29:
        return;
    L10:
        r3 = null;
    L6:
        r1 = 0;
        goto L7
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r2);
        if (FoldScreenUtils.f() == false) goto L5;
    L6:
        tf0.o r3 = this.F;
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

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void onSwitchSceneMessage(com.bytedance.android.livesdk.link.model.bridge.z0 r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        ALogger.i(LinkRoomFightContext.TAG, "onSwitchSceneMessage: msgScene = " + r6.getScene() + ", msgUILayout = " + r6.getUiLayout() + ", msgId = " + r6.getMessageId2());
        v1 r0 = (v1) vh7.f.c(v1.class);
        r0.setScene(r6.getValidScene());
        r0.setPlayModes(r6.getPlayModes());
        r0.setUiLayout(r6.getUiLayout());
        r0.setLinkedUsers(r6.getLinkedListUsers());
        r0.setVersion(r6.getVersion());
        r0.setMultiLiveCoreInfo(r6.getMultiLiveCoreInfo());
        r0.setMultiRtcInfo(r6.getMultiRtcInfo());
        r0.setLiveCoreExtInfo(r6.getLiveCoreExtInfo());
        r0.setRtcExtInfo(r6.getRtcExtInfo());
        r0.setLinkerContentMap(r6.getLinkerContentMap());
        r0.setClientUiInfo(r6.getClientUIInfo());
        MultiLinkVoiceChatAnchorPresenter r1 = this.B;
        if (r1 == null) goto L8;
        r1.f = r6.getTrackingData();
    L8:
        if (vm2.d.v0() == false) goto L11;
        com.bytedance.android.live.liveinteract.plantform.utils.i.g(r6);
    L11:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L13;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().yg((int) r6.getScene(), r6.getUiLayout(), r6.getPlayModes());
    L13:
        Yi(r0, "switchSceneMsg", "receive switch_scene msg");
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
        tf0.o r1 = this.F;
        if (r1 == null) goto L13;
        r1.setDynamicAnimatorListener(r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void setInviteCallback(uf0.c r1) {
        this.w = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void setPermitCallback(uf0.d r1) {
        this.v = r1;
    }

    @Override // com.bytedance.android.live.multilink.voicechat.impl.widget.MultiLinkVoiceChatAnchorPresenter.IView
    public final void t6(com.bytedance.android.livesdk.link.model.bridge.h1 r11) {
        Intrinsics.checkNotNullParameter(r11, "linkerMessage");
        if (isEngineOn() == true) goto L6;
        return;
    L6:
        if (r11.getLinkerEnlargeGuestInviteContent() != null) goto L8;
        return;
    L8:
        CPositionBeInvitedDialog r0 = this.p1;
        if (r0 == null) goto L19;
        Intrinsics.checkNotNull(r0);
        if (r0.isShowing() == false) goto L19;
        CPositionBeInvitedDialog r1 = this.p1;
        Intrinsics.checkNotNull(r1);
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L19;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L19:
        FragmentActivity r3 = ContextUtil.contextToFragmentActivity(getContext());
        if (r3 == null) goto L29;
        int r4 = CPositionBeInvitedDialog.o;
        CPositionBeInvitedDialog.ShowType r5 = CPositionBeInvitedDialog.ShowType.Invite;
        IRoom r6 = getMRoom();
        Intrinsics.checkNotNull(r6);
        long r7 = r6.getRoomId();
        CPositionBeInvitedDialog.RoomType r8 = CPositionBeInvitedDialog.RoomType.Audio;
        com.bytedance.android.livesdk.message.linker.k r9 = r11.getLinkerEnlargeGuestInviteContent();
        if (r9 == null) goto L24;
        String r10 = com.bytedance.android.livesdk.message.linker.l.a(r9);
    L25:
        CPositionBeInvitedDialog r12 = CPositionBeInvitedDialog.a.a(r5, r7, r8, true, r10, r11, ((Widget) this).dataCenter);
        this.p1 = r12;
        Intrinsics.checkNotNull(r12);
        Pq(r12, r3.getSupportFragmentManager());
        return;
    L24:
        r10 = "";
        goto L25
    }

    @Override // com.bytedance.android.live.multilink.voicechat.impl.widget.MultiLinkVoiceChatAnchorPresenter.IView
    public final void ug(com.bytedance.android.livesdk.link.model.bridge.h1 r11) {
        Intrinsics.checkNotNullParameter(r11, "linkerMessage");
        if (isEngineOn() == true) goto L6;
        return;
    L6:
        if (r11.getLinkerEnlargeGuestApplyContent() != null) goto L8;
        return;
    L8:
        CPositionBeInvitedDialog r0 = this.p1;
        if (r0 == null) goto L19;
        Intrinsics.checkNotNull(r0);
        if (r0.isShowing() == false) goto L19;
        CPositionBeInvitedDialog r1 = this.p1;
        Intrinsics.checkNotNull(r1);
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L19;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L19:
        FragmentActivity r3 = ContextUtil.contextToFragmentActivity(getContext());
        if (r3 == null) goto L30;
        int r4 = CPositionBeInvitedDialog.o;
        CPositionBeInvitedDialog.ShowType r5 = CPositionBeInvitedDialog.ShowType.Apply;
        IRoom r6 = getMRoom();
        Intrinsics.checkNotNull(r6);
        long r7 = r6.getRoomId();
        CPositionBeInvitedDialog.RoomType r8 = CPositionBeInvitedDialog.RoomType.Audio;
        com.bytedance.android.livesdk.message.linker.f r9 = r11.getLinkerEnlargeGuestApplyContent();
        if (r9 == null) goto L25;
        String r10 = r9.getFromUidStr();
        if (r10 == null) goto L25;
    L26:
        CPositionBeInvitedDialog r12 = CPositionBeInvitedDialog.a.a(r5, r7, r8, true, r10, r11, ((Widget) this).dataCenter);
        this.p1 = r12;
        Intrinsics.checkNotNull(r12);
        Pq(r12, r3.getSupportFragmentManager());
        return;
    L25:
        r10 = "0";
        goto L26
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final void updateFullScreenDialogShowStatus(boolean r3) {
        ALogger.i("MultiLinkVoiceChatRoomAnchorWidgetByCopy", "updateFullScreenDialogShowStatus isShow=" + r3 + ", isViewResumed=" + this.O);
        if (r3 == true) goto L5;
    L7:
        if (r3 == false) goto L9;
        return;
    L9:
        if (this.O == true) goto L14;
        onResume();
        return;
    L14:
        return;
    L5:
        if (this.O == false) goto L7;
        onPause();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final boolean userIsCPosition(String r4) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        if (yq().c.isEmpty() == true) goto L17;
        Iterator<ILinkPlayerInfoBridge> r0 = yq().c.iterator();
    L6:
        if (r0.hasNext() == false) goto L25;
        ILinkPlayerInfoBridge r1 = r0.next();
        if (r1.isEnlarged() == false) goto L6;
        IBaseUser r2 = r1.getBaseUser();
        if (r2 == null) goto L12;
        String r3 = r2.getIdString();
    L14:
        if (Intrinsics.areEqual(r3, r4) == false) goto L6;
        return true;
    L12:
        r3 = null;
        goto L14
    L25:
        return false;
    L17:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wf(String r2) {
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.L;
        if (r0 == null) goto L6;
        r0.l(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.voicechat.c
    public final ti6.j x(fi6.a r1) {
        return super.x(r1);
    }

    public static void Pq(CPositionBeInvitedDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "VideoTalkCPositionBeInvitedDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "VideoTalkCPositionBeInvitedDialog");
    }

    @Override // com.bytedance.android.live.multilink.voicechat.impl.widget.MultiLinkVoiceChatAnchorPresenter.IView
    public final boolean D4(int r5, f6 r6) {
        Intrinsics.checkNotNullParameter(r6, "guideInfo");
        if (yq().b() < r5) goto L7;
        jy0.b.a("ttlive_link", "intercept guide since online count hits limit");
        return false;
    L7:
        if (((Integer) ((Widget) this).dataCenter.get("data_member_count", 0)).intValue() > 0) goto L9;
    L12:
        return false;
    L9:
        if (this.F == null) goto L12;
        com.bytedance.android.live.liveinteract.voicechat.util.k r7 = this.R;
        Intrinsics.checkNotNull(r7);
        r7.getClass();
        Intrinsics.checkNotNullParameter("anchor", "userType");
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("request_page", "seat");
        r8.put("user_type", "anchor");
        com.bytedance.android.livesdk.log.j0.l().sendLog("anchor_invite_guide_show", r8, new Object[]{IRoom.class});
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.a
    public final void G4(boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        if (this.z != null) goto L5;
    L26:
        String r8 = je0.d.b0();
        w0 r0 = this.H;
        if (r0 == null) goto L30;
        r0.f9(r8, r6);
        return;
    L30:
        return;
    L5:
        if (r6 == false) goto L17;
        jg6.a r2 = zq().e5();
        if (r2 == null) goto L22;
        kg6.e r3 = r2.b();
        if (r3 == null) goto L22;
        if (je0.d.G() == false) goto L13;
    L15:
        boolean r4 = false;
    L16:
        r3.t(new kg6.b(true, r4, r7, 8));
        goto L22
    L13:
        if (je0.d.p() == true) goto L15;
        r4 = true;
    L22:
        VoiceChatMuteManager r9 = this.C;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L25:
        r9.i = System.currentTimeMillis();
        goto L26
    L17:
        jg6.a r5 = zq().e5();
        if (r5 == null) goto L22;
        kg6.e r10 = r5.b();
        if (r10 == null) goto L22;
        r10.z(new kg6.d(true, true, r7, 8));
        goto L22
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void T6(String r1, zf2.s0 r2) {
        com.bytedance.android.live.liveinteract.plantform.utils.u r3 = this.L;
        if (r3 == null) goto L6;
        r3.m(r1);
        return;
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

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void al(String r2, int r3) {
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.L;
        if (r0 == null) goto L6;
        r0.n(r2, r3);
        return;
    }

    @Override // tf0.o.a
    public final void ca(String r4, String r5) {
        gh0.b.a("RtcParamsUpdate", "updateLiveCoreAndRtcInfo: \nrtcExtInfo = " + r4 + ", \nliveCoreExtInfo = " + r5, false);
        if (r5 == null) goto L7;
        hg6.g r0 = R1();
        if (r0 == null) goto L7;
        r0.J(r5);
    L7:
        if (r4 == null) goto L12;
        hg6.g r6 = R1();
        if (r6 == null) goto L13;
        r6.c(r4);
        return;
    L13:
        return;
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
        TalkRoomLogUtils.W(true, "all_cancel");
        TalkRoomBusinessFullLinkMonitor r5 = TalkRoomBusinessFullLinkMonitor.a;
        String r7 = (String) r10.element;
        r5.getClass();
        TalkRoomBusinessFullLinkMonitor.p(r7);
        long r11 = System.currentTimeMillis();
        LinkAudienceApi r12 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        String r13 = (String) r10.element;
        this.m.add(r12.closeCPosition(r6, r13, r13).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r10, r11), new c(this, r10, r11)));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final void continueAnchorLinkMic(int r12, com.bytedance.android.livesdk.message.linker.h r13) {
        if (r13 == null) goto L13;
        hg6.g r0 = this.D;
        if (r0 == null) goto L13;
        fg6.b r1 = r0.F();
        if (r1 == null) goto L13;
        int r3 = r13.getUiLayout();
        List r4 = r13.getPlayModes();
        com.bytedance.android.livesdk.message.linker.b r2 = r13.getMainAnchorLinkmicInfo();
        if (r2 == null) goto L11;
        String r5 = r2.getRtcExtInfo();
        if (r5 == null) goto L11;
    L12:
        r1.b(pg6.a.b(new com.bytedance.android.livesdk.chatroom.viewmodel.h(r12, r3, r4, true, r5, r13.getLiveCoreExtInfo(), null, r13.getClientUIInfo())));
    L11:
        r5 = "";
    L13:
        com.bytedance.live.bizlink.impl.platform.manager.a r14 = zq().A0();
        Intrinsics.checkNotNull(r14);
        r14.g();
    }

    @Override // tf0.o.a
    public final void d0(tf0.p r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        i0 r0 = this.A;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        r0.d0(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void e1(String r1, long r2) {
        yq().getClass();
    }

    public final void er(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "interactId");
        Intrinsics.checkNotNullParameter("room battle mcu", "reason");
        jg6.a r5 = Bq();
        if (r5 == null) goto L7;
        kg6.e r6 = r5.b();
        if (r6 == null) goto L7;
        r6.h(r3, true, "room battle mcu");
    L7:
        hg6.g r7 = this.D;
        if (r7 == null) goto L11;
        r7.f();
        return;
    }

    public final void fr(zj0.f r12, zj0.f.b r13) {
        int r1 = r13.a;
        int r2 = r13.b;
        List<Integer> r3 = com.bytedance.android.live.liveinteract.plantform.utils.u0.d();
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
        ((Widget) this).dataCenter.put("data_multi_lick_dynamic_event_change", r16);
        return;
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

    public final <T> void hr(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }

    @Override // tf0.o.a
    public final void kd(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        ALogger.d(LinkRoomFightContext.TAG, "livecore version " + ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).getLiveCoreVersion());
        StringBuilder r0 = new StringBuilder("stopPlayPublicStream isEngineOn: ");
        hg6.g r2 = this.D;
        Intrinsics.checkNotNull(r2);
        r0.append(r2.isEngineOn());
        r0.append(" id ");
        r0.append(r4);
        ALogger.d(LinkRoomFightContext.TAG, r0.toString());
        if (r4 != null) goto L5;
        return;
    L5:
        hg6.g r1 = this.D;
        Intrinsics.checkNotNull(r1);
        xi0.b r3 = r1.O();
        if (r3 == null) goto L8;
        Integer r6 = Integer.valueOf(r3.k(r4));
    L9:
        zi0.b.f(r4, r6, r5);
        jy0.b.a(LinkRoomFightContext.TAG, "stopPlayPublicStream result " + r6);
        return;
    L8:
        r6 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void logKtvCameraOperation(String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "clickType");
        com.bytedance.android.live.liveinteract.voicechat.util.k r1 = this.R;
        Intrinsics.checkNotNull(r1);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "clickType");
        r1.D(r9, r10, "0", false, "", null);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void onChangeMediaInfo(ILinkerChangeMediaInfoContent r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "info");
        ILinkmicMediaParam r0 = r7.getLinkmicMediaParam();
        if (r0 != null) goto L5;
        return;
    L5:
        List r9 = r7.getPlayModeList();
        int r1 = r0.getLinkmicMediaType();
        List r2 = r9;
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        String r4 = null;
        if (r3 == true) goto L25;
        if (r9.contains(21) == false) goto L25;
        r0 r10 = r0.getKtvComponentMediaInfo();
        if (r10 == null) goto L19;
        String r5 = r10.getLiveCoreExtInfo();
    L20:
        if (r5 == null) goto L25;
        if (r8 <= 0) goto L23;
        hg6.g r6 = this.D;
        Intrinsics.checkNotNull(r6);
        r6.I(r8);
    L23:
        hg6.g r11 = this.D;
        Intrinsics.checkNotNull(r11);
        r11.J(r10.getLiveCoreExtInfo());
        hg6.g r12 = this.D;
        Intrinsics.checkNotNull(r12);
        ig6.a r13 = r12.x();
        Intrinsics.checkNotNull(r13);
        r13.a(MultiLinkInfoType.KTV_COMPONENT, new ig6.b(r10.getLiveCoreExtInfo(), null));
        goto L25
    L19:
        r5 = null;
    L25:
        if (r1 != ILinkmicMediaParam.Companion.getTYPE_LINKMIC_STREAM_INFO()) goto L34;
        com.bytedance.android.live.liveinteract.plantform.model.r r14 = r0.getLinkmicStreamInfo();
        if (r14 == null) goto L29;
        r4 = r14.getLiveCoreExtInfo();
    L29:
        if (r4 == null) goto L35;
        if (r8 <= 0) goto L32;
        hg6.g r15 = this.D;
        Intrinsics.checkNotNull(r15);
        r15.I(r8);
    L32:
        tc0.c.h().m = r14.getLiveCoreExtInfo();
        hg6.g r16 = this.D;
        Intrinsics.checkNotNull(r16);
        r16.J(r14.getLiveCoreExtInfo());
        return;
    L35:
        return;
    L34:
        return;
    L8:
        if (r2.isEmpty() == true) goto L11;
        r3 = false;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void openEmojiDialog(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "toUserId");
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        ILinkPlayerInfoBridge r8 = yq().o(r6, "");
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

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final void switchVoiceSceneWithCheck(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "toScene");
        this.H1.switchVoiceSceneWithCheck(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J(String[] r8, boolean[] r9, int[] r10) {
        tf0.o r0 = this.F;
        if (r0 == null) goto L5;
        r0.onTalkStateUpdated(r8, r9);
    L5:
        Intrinsics.checkNotNull(r8);
        int r1 = r8.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L10;
        Map<String, Integer> r4 = this.V;
        String r5 = r8[r2];
        Intrinsics.checkNotNull(r10);
        ((HashMap) r4).put(r5, Integer.valueOf(j22.c.c(r10[r2], true)));
        r2 = r2 + 1;
        goto L7
    L10:
        if (r8.length != 0) goto L12;
        boolean r11 = true;
    L14:
        if ((!r11) == false) goto L38;
        Intrinsics.checkNotNull(r9);
        if (r9.length != 0) goto L18;
        boolean r12 = true;
    L20:
        if ((!r12) == false) goto L39;
        String r13 = r8[0];
        boolean r14 = r9[0];
        IInteractService r15 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r15 == null) goto L26;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r16 = r15.getLinkUserInfoCenter();
        if (r16 == null) goto L26;
        IBaseUser r17 = r16.U4(r13);
    L27:
        if (r17 != null) goto L29;
        return;
    L29:
        if (Intrinsics.areEqual(r17.getIdString(), getMRoom().getOwnerUserIdString()) == false) goto L33;
        w0 r18 = this.H;
        if (r18 == null) goto L41;
        r18.Wk(r13, r14);
        return;
    L41:
        return;
    L33:
        w0 r19 = this.H;
        if (r19 == null) goto L43;
        r19.Mc(r17, r14);
        return;
    L43:
        return;
    L26:
        r17 = null;
        goto L27
    L39:
        return;
    L18:
        r12 = false;
        goto L20
    L38:
        return;
    L12:
        r11 = false;
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final void Yi(v1 r22, String r23, String r24) {
        Intrinsics.checkNotNullParameter(r22, "resp");
        Intrinsics.checkNotNullParameter(r23, "switchFrom");
        int r15 = r22.getScene();
        int r14 = r22.getUiLayout();
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.getValue();
        if (r2 == null) goto L11;
        if (r2.f(r15, r14) != true) goto L11;
        jy0.b.d("ttlive_link_audio", "onSwitchSceneMessage already same layout, current scene = " + r15 + " layout = " + r14);
        return;
    L11:
        if (Intrinsics.areEqual(r23, "switchSceneApi") == false) goto L15;
        MultiLinkVoiceChatAnchorPresenter r3 = this.B;
        if (r3 == null) goto L15;
        r3.f = "";
    L15:
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r4 = IVoiceChatAdminService.a.a();
        com.bytedance.android.livesdk.chatroom.viewmodel.i r19 = null;
        if (r4 == null) goto L18;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r5 = r4.getLinkUserInfoCenter();
    L19:
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r6 = r22.getLinkedUsers();
        if (r5 == null) goto L23;
        if (r6 == null) goto L23;
        r5.Y4(r6, r22.getClientUiInfo(), r22.getVersion(), r23, r22.getLinkerContentMap());
    L23:
        u1 r7 = r22.getMultiLiveCoreInfo();
        com.bytedance.android.livesdk.link.model.bridge.v1 r8 = r22.getMultiRtcInfo();
        String r9 = r22.getLiveCoreExtInfo();
        String r10 = r22.getRtcExtInfo();
        tc0.c r11 = tc0.c.h();
        r11.r = r7;
        r11.n = r8;
        r11.k = r10;
        r11.m = r9;
        yf6.a r12 = Nq();
        if (r12 == null) goto L26;
        r12.u8(r23);
    L26:
        com.bytedance.live.datacontext.j r13 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r13 == null) goto L58;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r16 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r13.getValue();
        if (r16 == null) goto L58;
        int r17 = r22.getUiLayout();
        List r18 = r22.getPlayModes();
        String r20 = r22.getRtcExtInfo();
        if (r20 != null) goto L33;
        r20 = "";
    L33:
        String r110 = r22.getLiveCoreExtInfo();
        if (r110 != null) goto L36;
        String r111 = "";
    L37:
        com.bytedance.android.livesdk.chatroom.viewmodel.h r21 = new com.bytedance.android.livesdk.chatroom.viewmodel.h(r15, r17, r18, false, r20, r111, r22.getMultiLiveCoreInfo(), r22.getClientUiInfo());
        DataCenter r25 = ((Widget) this).dataCenter;
        if (r25 == null) goto L40;
        r25.put("data_room_audio_chat_ui_layout_before", Integer.valueOf(((com.bytedance.android.livesdk.chatroom.viewmodel.i) r21).b));
    L40:
        com.bytedance.android.livesdk.chatroom.u r26 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        ArrayList r112 = new ArrayList();
        com.bytedance.live.datacontext.j r113 = r26.s();
        if (r113 == null) goto L45;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r114 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r113.getValue();
        if (r114 == null) goto L45;
        r19 = r114.t();
    L45:
        com.bytedance.android.livesdk.chatroom.viewmodel.i r115 = r19;
        if (r115 == null) goto L50;
        int r116 = r115.a;
        int r117 = r115.b;
        List r118 = r115.c;
        if (r118 == null) goto L51;
        r112.addAll(r118);
    L51:
        com.bytedance.live.datacontext.j r27 = r26.s();
        if (r27 == null) goto L56;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r28 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r27.getValue();
        if (r28 == null) goto L56;
        r28.c(new com.bytedance.android.livesdk.chatroom.viewmodel.i(r116, r117, r112, false, false, null, 32));
    L56:
        r16.d(r21);
        goto L58
    L50:
        r116 = 0;
        r117 = 0;
        goto L51
    L36:
        r111 = r110;
    L58:
        com.bytedance.android.livesdk.chatroom.u r29 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        com.bytedance.live.datacontext.m r30 = r29.I1();
        if (r30 != null) goto L61;
    L67:
        com.bytedance.live.datacontext.m r31 = r29.q();
        if (r31 == null) goto L70;
        r31.setValue(new nd.a(0, r22.getMaxMcNum()));
    L70:
        com.bytedance.live.datacontext.m r32 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).w2();
        if (r32 == null) goto L74;
        r32.setValue(Boolean.TRUE);
    L74:
        if (Intrinsics.areEqual(r23, "switchSceneApi") == false) goto L78;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r33 = TalkRoomLogUtils.a;
        com.bytedance.android.live.liveinteract.plantform.utils.h r34 = TalkRoomLogUtils.b;
        if (r34.a == r14) goto L78;
        TalkRoomLogUtils.s1(r14, false);
        jy0.b.d("AnchorManualUiLayout", "switchSceneApi currentManualUiLayout=" + r14 + ", lastManualUiLayout=" + r34.b);
    L78:
        this.P1 = r22.getClientUiInfo();
        wn0.a r35 = this.E;
        if (r35 == null) goto L82;
        wn0.a.d(r35, new zj0.c.a(r15, r14, r23, r24), r22.getPlayModes(), r22.getClientUiInfo(), false, null, 24);
        return;
    L82:
        return;
    L61:
        if (r15 == 9) goto L63;
    L65:
        boolean r119 = false;
    L66:
        r30.setValue(Boolean.valueOf(r119));
        goto L67
    L63:
        if (r14 == 61) goto L65;
        r119 = true;
        goto L66
    L18:
        r5 = null;
        goto L19
    }

    public final void dr(zj0.f r6, zj0.f.b r7, boolean r8) {
        if (r6 != null) goto L4;
    L5:
        if (r8 == true) goto L7;
        return;
    L7:
        HashMap r9 = new HashMap();
        int r0 = r7.a;
        if (r0 == 5) goto L18;
        if (r0 != 9) goto L23;
        r9.put("function_type", "ktv");
        com.bytedance.android.livesdk.log.j0.l().sendLog("anchor_ktv_open_success", MapsKt.emptyMap(), new Object[]{IRoom.class, am2.x.class});
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.R0.getValue()).booleanValue() == false) goto L15;
        String r1 = "on";
    L16:
        r9.put("is_camera_allow", r1);
        goto L23
    L15:
        r1 = "off";
    L23:
        if (getMRoom() == null) goto L29;
        IRoom r2 = getMRoom();
        Intrinsics.checkNotNull(r2);
        if (r2.getCircleInfo() == null) goto L29;
        IRoom r3 = getMRoom();
        Intrinsics.checkNotNull(r3);
        ICircleInfo r4 = r3.getCircleInfo();
        Intrinsics.checkNotNull(r4);
        if (TextUtils.isEmpty(r4.getCircleName()) == true) goto L29;
        IRoom r5 = getMRoom();
        Intrinsics.checkNotNull(r5);
        ICircleInfo r10 = r5.getCircleInfo();
        Intrinsics.checkNotNull(r10);
        r9.put("circle_name", String.valueOf(r10.getCircleName()));
    L29:
        String r11 = TalkRoomLogUtils.d;
        if (r11 == null) goto L33;
        r9.put("source", r11);
    L33:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L35;
        r9.put("is_invite_only", "1");
    L36:
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r12 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if (r12 == null) goto L46;
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r13 = r12;
        if (r13.getMap().containsKey("enter_from") == false) goto L46;
        if (TextUtils.equals((CharSequence) r13.getMap().get("enter_from"), "chat_match") == false) goto L44;
        r9.put("source", "chat_match");
        goto L46
    L44:
        if (TextUtils.equals((CharSequence) r13.getMap().get("solo_ktv"), "solo_ktv") == false) goto L46;
        r9.put("source", "solo_ktv");
    L46:
        r9.put("shoot_way", "switch_layout");
        com.bytedance.android.livesdk.chatroom.u r14 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        Integer r15 = null;
        if (r14 == null) goto L55;
        com.bytedance.live.datacontext.j r16 = r14.s();
        if (r16 == null) goto L55;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r17 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r16.getValue();
        if (r17 == null) goto L55;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r18 = r17.g();
        if (r18 == null) goto L55;
        Integer r19 = Integer.valueOf(r18.a);
    L56:
        com.bytedance.android.livesdk.chatroom.u r20 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r20 == null) goto L65;
        com.bytedance.live.datacontext.j r21 = r20.s();
        if (r21 == null) goto L65;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r22 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r21.getValue();
        if (r22 == null) goto L65;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r23 = r22.g();
        if (r23 == null) goto L65;
        r15 = Integer.valueOf(r23.b);
    L65:
        com.bytedance.android.livesdk.chatroom.u r24 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r24 == null) goto L83;
        com.bytedance.live.datacontext.j r25 = r24.s();
        if (r25 == null) goto L83;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r26 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r25.getValue();
        if (r26 == null) goto L83;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r27 = r26.g();
        if (r27 == null) goto L83;
        if (r27.a != 0) goto L83;
        if (r6 == null) goto L77;
        int r28 = r6.a;
    L78:
        r19 = Integer.valueOf(r28);
        if (r6 == null) goto L81;
        int r29 = r6.b;
    L82:
        r15 = Integer.valueOf(r29);
        goto L83
    L81:
        r29 = this.y2;
        goto L82
    L77:
        r28 = this.x2;
    L83:
        r9.put("before_function", com.bytedance.android.live.liveinteract.plantform.utils.u0.a(r19, r15));
        if (r2.a(TalkRoomLogUtils.n) == false) goto L87;
        r9.put("source", TalkRoomLogUtils.n);
        r9.put("game_id", TalkRoomLogUtils.o);
        r9.put("game_name", TalkRoomLogUtils.p);
    L87:
        if (this.R == null) goto L90;
        com.bytedance.android.live.liveinteract.voicechat.util.k.c(r7.a, r7.b, r9);
        return;
    L90:
        return;
    L55:
        r19 = null;
        goto L56
    L35:
        r9.put("is_invite_only", "0");
        goto L36
    L18:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(getMRoom()) == false) goto L20;
        String r30 = "party";
    L21:
        r9.put("function_type", r30);
        goto L23
    L20:
        r30 = "radio";
        goto L21
    L4:
        if (r6.a != 0) goto L7;
        goto L5
    }

    @Override // tf0.o.a
    public final void h(String r1, boolean r2, String r3) {
        er(r1, true);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final void replyCPosition(long r15, String r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r17, "toUid");
        long r9 = System.currentTimeMillis();
        LinkAudienceApi r0 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        long r3 = d5.c(r17);
        if (r18 == false) goto L5;
        CPositionReplyType r1 = CPositionReplyType.Accept;
    L6:
        Disposable r2 = r0.replyCPosition(r15, r3, r17, r1.getValue()).compose(RxUtil.rxSchedulerHelper()).subscribe(new t(r17, r18, r9), new u(r17, r18, r9, r15));
        this.m.add(r2);
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

    @Override // com.bytedance.android.live.liveinteract.voicechat.d
    public final void updateSelfMuteStatus(boolean r3, boolean r4, MediaOperation.a r5) {
        if (r3 == false) goto L5;
        ((VoiceChatMuteManager) muteManager()).b("self_panel", r5);
        return;
    L5:
        com.bytedance.android.live.liveinteract.voicechat.b.a.a(muteManager(), "self_panel", false, r5, 8);
    }

    public MultiLinkVoiceChatRoomAnchorWidget(com.bytedance.android.live.pushstream.d r2, w0 r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "liveStream");
        super(r2, tc0.c.h());
        this.v2 = r2;
        this.x2 = r4;
        this.y2 = r5;
        new LinkedHashMap();
        this.J = new cj0.e(true);
        this.Q = new KtToolbarInteractRoomBehavior();
        new ToolbarRoomBattleBehavior();
        this.V = new HashMap();
        this.V0 = true;
        this.x1 = new com.bytedance.android.live.liveinteract.plantform.utils.s();
        this.y1 = new ArrayList();
        this.G1 = new ArrayList();
        this.H1 = new InteractSceneViewModel();
        this.L1 = -1;
        this.Q1 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u();
        this.u = new com.bytedance.android.live.liveinteract.api.utils.p(this.z);
        this.H = r3;
        this.S1 = new com.bytedance.android.live.multilink.voicechat.impl.widget.j(this);
        this.V1 = new com.bytedance.android.live.multilink.voicechat.impl.widget.n(this);
        this.p2 = LazyKt.lazy(new MultiLinkVoiceChatRoomAnchorWidget$multiLinkLayoutService$2(this));
    }

    public final void Wq(zj0.f r20, zj0.f.b r21, List r22, List r23) {
        boolean r3 = false;
        if (r20 == null) goto L5;
        int r4 = r20.a;
    L6:
        if (r20 == null) goto L8;
        int r1 = r20.b;
    L9:
        int r5 = r21.a;
        int r2 = r21.b;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r6 = TalkRoomLogUtils.a;
        if (TalkRoomLogUtils.i(Integer.valueOf(r4), Integer.valueOf(r1), Integer.valueOf(r5), Integer.valueOf(r2), null, null) == false) goto L12;
        return;
    L12:
        Integer r7 = Integer.valueOf(r4);
        Integer r8 = Integer.valueOf(r1);
        com.bytedance.android.live.liveinteract.plantform.utils.h r9 = TalkRoomLogUtils.b;
        int r10 = r9.b;
        if (r1 == r10) goto L16;
        r10 = r9.a;
    L16:
        String r11 = TalkRoomLogUtils.p(r7, r8, Integer.valueOf(r10));
        String r12 = TalkRoomLogUtils.p(Integer.valueOf(r5), Integer.valueOf(r2), Integer.valueOf(r9.a));
        String r13 = com.bytedance.android.live.liveinteract.plantform.utils.u0.i(Integer.valueOf(r1), r22, Integer.valueOf(r9.b));
        String r14 = com.bytedance.android.live.liveinteract.plantform.utils.u0.i(Integer.valueOf(r2), r23, Integer.valueOf(r9.a));
        String r15 = com.bytedance.android.live.liveinteract.plantform.utils.u0.f(Integer.valueOf(r1), Integer.valueOf(r4), r22, Integer.valueOf(r9.b), null, null, 48);
        String r16 = com.bytedance.android.live.liveinteract.plantform.utils.u0.f(Integer.valueOf(r2), Integer.valueOf(r5), r23, Integer.valueOf(r9.a), null, null, 48);
        ILiveWrappedLivePusher.Companion.getClass();
        if (ILiveWrappedLivePusher.a.a(r11, r12) == false) goto L26;
        if (r4 == 0) goto L26;
        if (ILiveWrappedLivePusher.a.a(r13, r14) == true) goto L24;
        com.bytedance.android.live.liveinteract.voicechat.util.k r17 = this.R;
        Intrinsics.checkNotNull(r17);
        com.bytedance.android.live.liveinteract.voicechat.util.k.g(r17, null, r14, null, r16, 4);
    L57:
        if (r1 == 0) goto L82;
        if (r1 != r2) goto L60;
        return;
    L60:
        if (r1 == 26) goto L62;
        if (r2 == 26) goto L62;
        return;
    L62:
        LinkmicSubtitleBusinessContext.a r18 = LinkmicSubtitleBusinessContext.Companion;
        if (r18.d() == false) goto L85;
        com.bytedance.android.live.liveinteract.voicechat.subtitle.s r19 = com.bytedance.android.live.liveinteract.voicechat.subtitle.t.a;
        LinkmicSubtitleBusinessContext r24 = r18.getContext();
        if (r24 == null) goto L71;
        com.bytedance.live.datacontext.m<q2> r25 = r24.getLinkmicSubtitleSettingStatus();
        if (r25 == null) goto L71;
        q2 r26 = (q2) r25.getValue();
        if (r26 == null) goto L71;
        Integer r27 = Integer.valueOf(r26.getSubtitleType());
    L72:
        com.bytedance.android.live.liveinteract.voicechat.subtitle.t.h(r16, com.bytedance.android.live.liveinteract.voicechat.subtitle.t.b(r27));
        LinkmicSubtitleBusinessContext r28 = r18.getContext();
        if (r28 == null) goto L79;
        com.bytedance.live.datacontext.m<q2> r29 = r28.getLinkmicSubtitleSettingStatus();
        if (r29 == null) goto L79;
        q2 r30 = (q2) r29.getValue();
        if (r30 == null) goto L79;
        Integer r31 = Integer.valueOf(r30.getSubtitleType());
    L80:
        com.bytedance.android.live.liveinteract.voicechat.subtitle.t.e(null, r15, com.bytedance.android.live.liveinteract.voicechat.subtitle.t.b(r31));
        com.bytedance.android.live.liveinteract.voicechat.subtitle.t.a.b = System.currentTimeMillis();
        return;
    L79:
        r31 = null;
    L71:
        r27 = null;
        goto L72
    L85:
        return;
    L82:
        return;
    L24:
        if (ILiveWrappedLivePusher.a.a(r15, r16) == true) goto L57;
        com.bytedance.android.live.liveinteract.voicechat.util.k r110 = this.R;
        Intrinsics.checkNotNull(r110);
        com.bytedance.android.live.liveinteract.voicechat.util.k.g(r110, null, r14, null, r16, 4);
    L26:
        if (r4 != 0) goto L28;
        r3 = true;
    L28:
        com.bytedance.android.live.liveinteract.voicechat.util.k r32 = this.R;
        Intrinsics.checkNotNull(r32);
        if (r3 == true) goto L34;
        if (r13 == null) goto L34;
        if (Intrinsics.areEqual(r13, r14) == false) goto L34;
        String r33 = "function_switch";
    L35:
        r32.f(r12, r14, r33, r16);
        if (r4 == 0) goto L57;
        if (r1 == 0) goto L57;
        LinkmicSubtitleBusinessContext.a r34 = LinkmicSubtitleBusinessContext.Companion;
        if (r34.d() == false) goto L57;
        com.bytedance.android.live.liveinteract.voicechat.subtitle.s r35 = com.bytedance.android.live.liveinteract.voicechat.subtitle.t.a;
        LinkmicSubtitleBusinessContext r36 = r34.getContext();
        if (r36 == null) goto L47;
        com.bytedance.live.datacontext.m<q2> r37 = r36.getLinkmicSubtitleSettingStatus();
        if (r37 == null) goto L47;
        q2 r38 = (q2) r37.getValue();
        if (r38 == null) goto L47;
        Integer r39 = Integer.valueOf(r38.getSubtitleType());
    L48:
        com.bytedance.android.live.liveinteract.voicechat.subtitle.t.h(r16, com.bytedance.android.live.liveinteract.voicechat.subtitle.t.b(r39));
        LinkmicSubtitleBusinessContext r40 = r34.getContext();
        if (r40 == null) goto L55;
        com.bytedance.live.datacontext.m<q2> r41 = r40.getLinkmicSubtitleSettingStatus();
        if (r41 == null) goto L55;
        q2 r42 = (q2) r41.getValue();
        if (r42 == null) goto L55;
        Integer r43 = Integer.valueOf(r42.getSubtitleType());
    L56:
        com.bytedance.android.live.liveinteract.voicechat.subtitle.t.e(null, r15, com.bytedance.android.live.liveinteract.voicechat.subtitle.t.b(r43));
        com.bytedance.android.live.liveinteract.voicechat.subtitle.t.a.b = System.currentTimeMillis();
    L55:
        r43 = null;
    L47:
        r39 = null;
    L34:
        r33 = null;
        goto L35
    L8:
        r1 = 0;
        goto L9
    L5:
        r4 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void setCPosition(long r17, String r19, boolean r20, String r21) {
        Intrinsics.checkNotNullParameter(r19, "toUid");
        Intrinsics.checkNotNullParameter(r21, "enlargeTypeForLog");
        if (r20 == false) goto L5;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r3 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.X(true, r19, r21);
    L10:
        if (r20 == true) goto L12;
    L46:
        long r12 = System.currentTimeMillis();
        if (Rq() != 28) goto L49;
        long r4 = oe0.d.b();
    L50:
        long r14 = r4;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.s(r19, r20, r14);
        LinkAudienceApi r1 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        long r5 = d5.c(r19);
        if (r20 == false) goto L53;
        int r7 = 1;
    L54:
        Disposable r2 = r1.setCPosition(r17, r5, r19, r7, r14).compose(RxUtil.rxSchedulerHelper()).subscribe(new v(r19, r20, r14, r12), new w(r19, r20, r14, r12));
        if (r2 == null) goto L63;
        this.m.add(r2);
        return;
    L63:
        return;
    L53:
        r7 = 2;
        goto L54
    L49:
        r4 = CPositionToEnlargePosition.Default.getValue();
        goto L50
    L12:
        if (Intrinsics.areEqual(r19, je0.d.b0()) == false) goto L46;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r6 = yq().c;
        Boolean r8 = null;
        if (r6 == null) goto L40;
        boolean r9 = false;
        if (r6.isEmpty() == true) goto L39;
        Iterator<ILinkPlayerInfoBridge> r10 = r6.iterator();
    L20:
        if (r10.hasNext() == false) goto L39;
        ILinkPlayerInfoBridge r11 = r10.next();
        if (r11.isEnlarged() == false) goto L36;
        IBaseUser r13 = r11.getUser();
        if (r13 == null) goto L26;
        String r15 = r13.getIdString();
    L27:
        com.bytedance.live.datacontext.m r16 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r16 == null) goto L32;
        IRoom r18 = (IRoom) r16.getValue();
        if (r18 == null) goto L32;
        String r22 = r18.getOwnerUserIdString();
    L34:
        if (Intrinsics.areEqual(r15, r22) == false) goto L36;
        boolean r23 = true;
    L37:
        if (r23 == false) goto L20;
        r9 = true;
    L32:
        r22 = null;
        goto L34
    L26:
        r15 = null;
    L36:
        r23 = false;
    L39:
        r8 = Boolean.valueOf(r9);
    L40:
        r8.booleanValue();
        je0.d.j(yq());
        TalkRoomLogUtils r24 = TalkRoomLogUtils.B;
        CPositionContext r25 = CPositionContext.Companion.getContext();
        if (r25 == null) goto L45;
        com.bytedance.live.datacontext.m<Boolean> r26 = r25.isCPositionOpen();
        if (r26 == null) goto L45;
        ((Boolean) r26.getValue()).booleanValue();
    L45:
        r24.d0(true, false, je0.d.b0(), CPositionBeInvitedDialog.ShowType.Invite, false, ((Widget) this).dataCenter);
        goto L46
    L5:
        boolean r27 = Intrinsics.areEqual(r19, je0.d.a());
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r28 = TalkRoomLogUtils.a;
        if (r27 == false) goto L8;
        String r29 = "anchor";
    L9:
        TalkRoomLogUtils.W(true, r29);
        goto L10
    L8:
        r29 = "guest";
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void showInviteAndPermitDialog(boolean r3, String r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        Intrinsics.checkNotNullParameter(r6, "taskName");
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (this.N == true) goto L8;
        ((Widget) this).dataCenter.put("data_task_name_when_open_invite_panel", r6);
        com.bytedance.android.live.liveinteract.plantform.base.f.a().oa(r4, r5, 0, new x(this));
        this.N = true;
    L8:
        if (r3 == false) goto L11;
        com.bytedance.android.live.liveinteract.voicechat.util.k r7 = this.R;
        Intrinsics.checkNotNull(r7);
        r7.getClass();
        com.bytedance.android.live.liveinteract.voicechat.util.k.d("anchor");
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void updateMultiEnlargePosition(long r17, String r19, long r20, String r22) {
        Intrinsics.checkNotNullParameter(r19, "targetUserId");
        Intrinsics.checkNotNullParameter(r22, "enlargeTypeForLog");
        if (Intrinsics.areEqual(r19, je0.d.b0()) == true) goto L5;
    L18:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r1 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.X(true, r19, r22);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.s(r19, true, r20);
        long r14 = System.currentTimeMillis();
        Disposable r2 = ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).setCPosition(r17, d5.c(r19), r19, CPositionInviteType.Enlarge.getValue(), r20).compose(RxUtil.rxSchedulerHelper()).subscribe(new y(r19, r20, r14, r22), new z(r19, r20, r14));
        this.m.add(r2);
        return;
    L5:
        if (r20 != CPositionToEnlargePosition.Left.getValue()) goto L7;
        int r3 = CPositionContext.Companion.d();
    L9:
        if (r3 != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal()) goto L11;
        boolean r8 = true;
    L12:
        je0.d.j(yq());
        TalkRoomLogUtils r4 = TalkRoomLogUtils.B;
        CPositionContext r5 = CPositionContext.Companion.getContext();
        if (r5 == null) goto L17;
        com.bytedance.live.datacontext.m<Boolean> r6 = r5.isCPositionOpen();
        if (r6 == null) goto L17;
        ((Boolean) r6.getValue()).booleanValue();
    L17:
        r4.d0(true, false, je0.d.b0(), CPositionBeInvitedDialog.ShowType.Invite, r8, ((Widget) this).dataCenter);
        goto L18
    L11:
        r8 = false;
        goto L12
    L7:
        r3 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal();
        goto L9
    }

    @Override // wn0.a.b
    public final void Ef(zj0.f r22, zj0.f.b r23, List r24, List r25, zj0.c r26) {
        Intrinsics.checkNotNullParameter(r23, "to");
        Intrinsics.checkNotNullParameter(r26, "switchType");
        if (r22 != null) goto L5;
        return;
    L5:
        int r3 = r22.a;
        int r4 = r22.b;
        int r5 = r23.a;
        int r6 = r23.b;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r7 = TalkRoomLogUtils.a;
        if (TalkRoomLogUtils.i(Integer.valueOf(r3), Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6), null, null) == true) goto L35;
        Integer r8 = Integer.valueOf(r3);
        Integer r9 = Integer.valueOf(r4);
        com.bytedance.android.live.liveinteract.plantform.utils.h r10 = TalkRoomLogUtils.b;
        int r11 = r10.b;
        if (r4 == r11) goto L12;
        r11 = r10.a;
    L12:
        String r12 = TalkRoomLogUtils.p(r8, r9, Integer.valueOf(r11));
        String r13 = TalkRoomLogUtils.p(Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r10.a));
        String r14 = com.bytedance.android.live.liveinteract.plantform.utils.u0.i(Integer.valueOf(r4), r24, Integer.valueOf(r10.b));
        String r15 = com.bytedance.android.live.liveinteract.plantform.utils.u0.i(Integer.valueOf(r6), r25, Integer.valueOf(r10.a));
        String r16 = com.bytedance.android.live.liveinteract.plantform.utils.u0.f(Integer.valueOf(r4), Integer.valueOf(r3), r24, Integer.valueOf(r10.b), null, null, 48);
        String r17 = com.bytedance.android.live.liveinteract.plantform.utils.u0.f(Integer.valueOf(r6), Integer.valueOf(r5), r25, Integer.valueOf(r10.a), null, null, 48);
        ILiveWrappedLivePusher.Companion.getClass();
        if (ILiveWrappedLivePusher.a.a(r12, r13) == false) goto L25;
        if (r3 == 0) goto L25;
        if (ILiveWrappedLivePusher.a.a(r14, r15) == true) goto L21;
        if (r14 == null) goto L35;
        com.bytedance.android.live.liveinteract.voicechat.util.k r18 = this.R;
        Intrinsics.checkNotNull(r18);
        r18.h(null, r14, "layout_type_close", r16, Integer.valueOf(r3), Integer.valueOf(r4));
        goto L35
    L21:
        if (ILiveWrappedLivePusher.a.a(r16, r17) == true) goto L35;
        if (r16 == null) goto L35;
        com.bytedance.android.live.liveinteract.voicechat.util.k r19 = this.R;
        Intrinsics.checkNotNull(r19);
        r19.h(null, r14, "layout_type_close", r16, Integer.valueOf(r3), Integer.valueOf(r4));
    L25:
        if (r12 == null) goto L35;
        if (r3 == 0) goto L35;
        com.bytedance.android.live.liveinteract.voicechat.util.k r110 = this.R;
        Intrinsics.checkNotNull(r110);
        if (r14 != null) goto L30;
    L32:
        String r20 = "layout_type_close";
    L33:
        r110.h(r12, r14, r20, r16, Integer.valueOf(r3), Integer.valueOf(r4));
        goto L35
    L30:
        if (Intrinsics.areEqual(r14, r15) == false) goto L32;
        r20 = "function_switch";
    L35:
        if (r23.a != 16) goto L37;
        zi0.e r21 = zi0.b.d;
        com.bytedance.android.livesdk.utils.ntp.e.a();
        r21.getClass();
    L37:
        int r27 = r22.a;
        if (r27 == 0) goto L57;
        if (r27 != 16) goto L42;
    L45:
        boolean r2 = true;
    L46:
        if (r2 == true) goto L57;
        if (getMRoom() == null) goto L52;
        IRoom r28 = getMRoom();
        Intrinsics.checkNotNull(r28);
        if (r28.getLinkInitResult() == null) goto L52;
        boolean r111 = true;
    L53:
        String r112 = com.bytedance.android.live.liveinteract.plantform.utils.u0.i(Integer.valueOf(r22.b), r22.h, Integer.valueOf(TalkRoomLogUtils.b.b));
        com.bytedance.android.live.liveinteract.voicechat.util.k r29 = this.R;
        if (r29 == null) goto L57;
        long r30 = this.I;
        int r113 = r22.a;
        Integer r114 = Integer.valueOf(r22.b);
        IRoom r31 = getMRoom();
        Intrinsics.checkNotNull(r31);
        r29.j(r30, r113, r114, r111, r31.getCircleInfo(), TalkRoomLogUtils.j, r112);
    L52:
        r111 = false;
        goto L53
    L42:
        if (r23.a == 16) goto L45;
        r2 = false;
    L57:
        if (r22.a != 0) goto L59;
        return;
    L59:
        if (vm2.d.D() == false) goto L61;
        ((Widget) this).dataCenter.put("data_voice_chat_room_shoot_way", "interact_panel");
        return;
    L61:
        ((Widget) this).dataCenter.put("data_voice_chat_room_shoot_way", "null");
    }

    @Override // wn0.a.b
    public final void Lk(zj0.f r9, zj0.f.b r10, List r11, List r12, zj0.c r13) {
        Intrinsics.checkNotNullParameter(r10, "to");
        Intrinsics.checkNotNullParameter(r13, "switchType");
        tf0.o r0 = this.F;
        if (r0 == null) goto L5;
        tf0.j r1 = r0.getLinkWindowLayoutConfig();
    L7:
        if ((r1 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.m) == true) goto L9;
        r1 = null;
    L9:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.m) r1;
        if (r2 == null) goto L14;
        com.bytedance.android.live.liveinteract.plantform.utils.u r3 = this.L;
        if (r3 == null) goto L14;
        r3.u(r2);
    L14:
        boolean r4 = true;
        if (r9 == null) goto L17;
        com.bytedance.android.live.liveinteract.plantform.base.g r5 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r5 == null) goto L30;
        r5.nb(r10.a);
    L30:
        long r6 = SystemClock.elapsedRealtime();
        this.I = r6;
        ((Widget) this).dataCenter.put("data_room_audio_chat_anchor_uilayout_start_time", Long.valueOf(r6));
        mz0.e r7 = mz0.d.b(LogCommon.LINKMIC_SCENE_DATA);
        if ((r7 instanceof mz0.e) == true) goto L33;
        r7 = null;
    L33:
        if (r7 == null) goto L35;
        ((com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a) r7).c(new com.bytedance.android.livesdk.log.filter.y(r10.a));
    L35:
        com.bytedance.android.live.liveinteract.plantform.base.f.a().o6(Kq(r10.a), true);
        Wq(r9, r10, r11, r12);
        if (r9.a != 16) goto L38;
    L41:
        if (r4 == true) goto L43;
        dr(r9, r10, false);
    L43:
        int r14 = r9.a;
        if (r14 != 5) goto L59;
        int r8 = r10.a;
        if (r8 == 5) goto L59;
        if (r8 == 9) goto L53;
        if (r8 == 0) goto L53;
        int r15 = r10.b;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r16 = MultiRevenueDataContext.a.d();
        if (r16 == null) goto L70;
        r16.d4(r8, r15);
    L70:
        if (((Boolean) ((Widget) this).dataCenter.get("cmd_ready_starting_live", Boolean.FALSE)).booleanValue() == false) goto L72;
        jr();
    L72:
        fr(r9, r10);
        yf6.a r17 = Nq();
        if (r17 == null) goto L75;
        r17.u8(r13.toString());
    L75:
        gr(r10.b);
        return;
    L53:
        jy0.b.a("InteractAnimationController", "before unloadAnimRenderWidget");
        MiddlewareRoomWidget r18 = this.k1;
        if (r18 == null) goto L70;
        WidgetManager r19 = ((Widget) this).subWidgetManager;
        if (r19 == null) goto L58;
        r19.unload(r18);
    L58:
        this.k1 = null;
    L59:
        int r20 = r10.a;
        if (r20 != 5) goto L70;
        if (r14 == 5) goto L70;
        if (r14 == 9) goto L68;
        if (r14 == 0) goto L68;
        int r110 = r10.b;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r111 = MultiRevenueDataContext.a.d();
        if (r111 == null) goto L70;
        r111.d4(r20, r110);
    L68:
        br();
        goto L70
    L38:
        if (r10.a == 16) goto L41;
        r4 = false;
        goto L41
    L17:
        if (this.x2 == 9) goto L20;
        r4 = false;
    L20:
        dr(null, r10, r4);
        int r112 = r10.b;
        if (r112 != 26) goto L23;
    L24:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r113 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.q = je0.d.a();
    L25:
        Wq(r9, r10, r11, r12);
        fr(r9, r10);
        gr(r10.b);
        return;
    L23:
        if (r112 != 30) goto L25;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService
    public final void switchAudioByClient(boolean r9, List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r10, ClientUIInfo r11, long r12, Map<Long, ? extends g2> r14, String r15) {
        Intrinsics.checkNotNullParameter(r15, "reason");
        G4(r9, r15);
        VoiceChatMuteManager r16 = this.C;
        if (r16 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L5:
        r16.t(r9);
        com.bytedance.android.live.liveinteract.plantform.core.y r1 = yq();
        if (r9 == false) goto L8;
        String r13 = "silence";
    L9:
        r1.Y4(r10, r11, r12, r13, r14);
        return;
    L8:
        r13 = "unsilence";
        goto L9
    }
}
