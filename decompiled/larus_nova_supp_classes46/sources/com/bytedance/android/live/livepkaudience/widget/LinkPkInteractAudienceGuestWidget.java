package com.bytedance.android.live.livepkaudience.widget;

import am2.x;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationContext;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import com.bytedance.android.live.liveinteract.plantform.model.f0;
import com.bytedance.android.live.liveinteract.plantform.model.r0;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor;
import com.bytedance.android.live.liveinteract.utils.k0;
import com.bytedance.android.live.liveinteract.videotalk.dialog.InteractBeautyPreviewDialog;
import com.bytedance.android.live.livepkaudience.base.BasePkInteractAdminLinkWidget;
import com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget;
import com.bytedance.android.live.livepkaudience.base.q;
import com.bytedance.android.live.livepkaudience.base.r;
import com.bytedance.android.live.livepkaudience.base.s;
import com.bytedance.android.live.livepkaudience.base.y;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractAdminContext;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestContext;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.android.live.livepkaudience.dialog.PkAudienceGuestInviteDialog;
import com.bytedance.android.live.livepkaudience.dialog.PkAudiencePreApplyDialog;
import com.bytedance.android.live.livepkaudience.dialog.PkGuestApplyDialog;
import com.bytedance.android.live.livepkaudience.dialog.RevLinkDialog;
import com.bytedance.android.live.livepkaudience.emoji.LinkPKAudienceInteractDynamicEmojiDialog;
import com.bytedance.android.live.livepkaudience.linksecurity.LinkSecurityApi;
import com.bytedance.android.live.livepkaudience.linksecurity.LinkSecurityManager;
import com.bytedance.android.live.livepkaudience.vm.LinkPkSwitchCameraManager;
import com.bytedance.android.live.livepkaudience.vm.PkGuestApplyViewModel;
import com.bytedance.android.live.livepkaudience.window.LinkPkInteractAudienceWindowManagerV2;
import com.bytedance.android.live.multilink.impl.InteractService;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.live.utils.HostEnv;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.c1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.ApplyResult;
import com.bytedance.android.livesdk.chatroom.model.JoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.interact.AudienceLinkReplyResult;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiAnchorLinkmicLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiAnchorLinkmicRtcInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiRtcInfo;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.ah0;
import com.bytedance.android.livesdk.config.eh0;
import com.bytedance.android.livesdk.config.fh0;
import com.bytedance.android.livesdk.config.gh0;
import com.bytedance.android.livesdk.config.k60;
import com.bytedance.android.livesdk.config.n60;
import com.bytedance.android.livesdk.config.nd1;
import com.bytedance.android.livesdk.config.rh0;
import com.bytedance.android.livesdk.config.sj1;
import com.bytedance.android.livesdk.config.th0;
import com.bytedance.android.livesdk.config.zg0;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.LinkMicGuideMessage;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdk.message.model.gf;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdk.message.model.ue;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.CircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.BlockTouchUpdateEvent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLinkedListChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightUpdateContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerBattleConnectContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerEnterContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerResumeAudienceContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkmicMediaParam;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfigKt;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import com.bytedance.live.livelink.kmp.impl.extend.spatialaudio.SpatialAudioManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import uf2.d0;
import uf2.m1;
import uf2.z;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/widget/LinkPkInteractAudienceGuestWidget;", "Lcom/bytedance/android/live/livepkaudience/base/BasePkInteractAdminLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkPlayerInfo;", "Lcom/bytedance/android/live/livepkaudience/service/a;", "Lcom/bytedance/android/live/livepkaudience/vm/b;", "Lvlc/l;", "Lcom/bytedance/android/live/livepkaudience/presenter/a$a;", "Lm00/g$a;", "Lxk0/b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPkInteractAudienceGuestWidget extends BasePkInteractAdminLinkWidget<LinkPlayerInfo> implements com.bytedance.android.live.livepkaudience.service.a, com.bytedance.android.live.livepkaudience.vm.b, vlc.l, com.bytedance.android.live.livepkaudience.presenter.a.InterfaceC0115a, m00.g.a, xk0.b, Observer<KVData> {
    public String A;
    public Runnable B;
    public final int C;
    public long D;
    public long E;
    public long F;
    public Long G;
    public final long H;
    public final Lazy H0;
    public final String I;
    public Disposable J;
    public long K;
    public boolean L;
    public final lc0.c L0;
    public long M;
    public boolean N;
    public boolean O;
    public PkGuestApplyDialog P;
    public final l P0;
    public PkAudiencePreApplyDialog Q;
    public LinkPkSwitchCameraManager R;
    public com.bytedance.android.live.liveinteract.utils.d S;
    public vlc.d T;
    public boolean U;
    public boolean V;
    public final f V0;
    public final k0 W;
    public al0.a X;
    public LiveDialogFragment Y;
    public com.bytedance.android.live.livepkaudience.presenter.a Z;
    public final m b1;
    public final p g1;
    public final LinkPkInteractGuestDataContext h1;
    public LinkerBattleConnectContent k0;
    public final String p;
    public long p0;
    public boolean q;
    public boolean r;
    public com.bytedance.android.live.livepkaudience.base.i s;
    public LinkPkInteractAudienceWindowManagerV2 t;
    public Room u;
    public PkAudienceGuestInviteDialog v;
    public final CompositeDisposable w;
    public v0 x;
    public m00.g y;
    public final gd0.h z;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;

        public a(LinkPkInteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r6, int r7) {
            r6.dismiss();
            q r8 = this.a.b;
            if (r8 == null) goto L9;
            Intrinsics.checkNotNullParameter("cancel_application", "reqFrom");
            if (r8.g == true) goto L10;
            r8.g = true;
            long r0 = System.currentTimeMillis();
            Disposable r9 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).leave(r8.d().id, "cancel_application").compose(RxUtil.rxSchedulerHelper()).subscribe(new r(r8, r0), new s(r8, r0));
            r8.b.add(r9);
            return;
        L10:
            return;
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;

        public c(LinkPkInteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            this.a.F3("leave_normally");
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public static final class e implements Consumer<Long> {
        public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;

        public e(LinkPkInteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.F3("leave_background_time_out");
        }
    }

    public static final class f extends y {
        public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;

        public f(LinkPkInteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
        public final void onOnlineListChanged(List<? extends LinkPlayerInfo> r3) {
            Intrinsics.checkNotNull(r3);
            ArrayList r0 = new ArrayList(r3);
            DataCenter r4 = ((Widget) this.a).dataCenter;
            if (r4 == null) goto L5;
            r4.put("data_online_changed_list", r0);
        L5:
            this.a.Wq();
        }

        @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
        public final void e(List r4, WaitingListUser r5) {
            DataCenter r6 = ((Widget) this.a).dataCenter;
            int r0 = 0;
            if (r6 == null) goto L8;
            Integer r7 = (Integer) r6.get("data_link_state", 0);
            if (r7 == null) goto L8;
            r0 = r7.intValue();
        L8:
            if (v.a(r0, 2) == false) goto L19;
            String r8 = jc1.k.n(IUserService.class).user().n();
            if (r5 == null) goto L14;
            IBaseUser r9 = r5.getUserFlex();
            if (r9 == null) goto L14;
            String r10 = r9.getIdString();
        L16:
            if (Intrinsics.areEqual(r10, r8) == false) goto L20;
            hd0.c.f().k(1);
            return;
        L20:
            return;
        L14:
            r10 = null;
            goto L16
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;

        public g(LinkPkInteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            LinkPkInteractAudienceGuestWidget r8 = this.a;
            int r0 = bh0.a.a;
            r8.getClass();
            if (us1.b.a() == true) goto L6;
            f2.c(us1.b.b(), 0);
            return;
        L6:
            if (dl0.k.a() == false) goto L8;
            f2.c(s1.B(2131917793), 0);
            return;
        L8:
            IInteractService r1 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r1 == null) goto L11;
            int r2 = r1.getLinkMode();
        L13:
            if (v.a(r2, 2) == false) goto L15;
            f2.c(s1.B(2131915438), 0);
            return;
        L15:
            Integer r3 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r3 == null) goto L22;
            if (r3.intValue() != 0) goto L22;
            com.bytedance.android.live.livepkaudience.service.d.b.a(r8, 2, 101, "interact_audience_guest_widget_empty_window");
            return;
        L22:
            if (r3 != null) goto L25;
        L27:
            if (r3 != null) goto L30;
            return;
        L30:
            if (r3.intValue() == 2) goto L32;
            return;
        L32:
            if (jc1.k.n(IUserService.class).user().isAdmin() == false) goto L43;
            r8.v0(0, PbRequest.SwitchType.PK, -1, null);
            return;
        L43:
            return;
        L25:
            if (r3.intValue() != 1) goto L27;
            r8.Zq(null);
            return;
        L11:
            r2 = 0;
            goto L13
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;

        public h(LinkPkInteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.getClass();
            boolean r3 = ((BlockTouchUpdateEvent) r2) instanceof BlockTouchUpdateEvent;
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
            if (r1 == null) goto L5;
            r1.dismiss();
            return;
        }
    }

    public static final class j implements DialogInterface.OnClickListener {
        public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;

        public j(LinkPkInteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            if (r1 == null) goto L4;
            r1.dismiss();
        L4:
            LinkPkInteractAudienceGuestWidget r3 = this.a;
            if (((Widget) r3).context == null) goto L8;
            r3.Yq(false);
            return;
        }
    }

    public static final class k implements Consumer<Long> {
        public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;

        public k(LinkPkInteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.F3("leave_background_time_out");
        }
    }

    public static final class l implements InteractLiveCorePermissionGuarantor.a {
        public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;

        @Override // com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor.a
        public final void b(boolean r1) {
        }

        public l(LinkPkInteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor.a
        public final void a(boolean r3) {
            if (r3 == false) goto L4;
            this.a.Qq("on particular page show", true);
            return;
        L4:
            this.a.Rq("on particular page close");
        }
    }

    public static final class m<T> implements Observer {
        public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;

        public m(LinkPkInteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            RevPkState r9 = (RevPkState) r8;
            if (r9 != RevPkState.PK) goto L6;
            LinkPkInteractAudienceGuestWidget r10 = this.a;
            r10.V = false;
            r10.h1.resetLogData();
            return;
        L6:
            if (r9 != RevPkState.PENAL) goto L9;
            this.a.V = true;
            return;
        L9:
            if (r9 != RevPkState.FINISHED) goto L16;
            LinkPkInteractAudienceGuestWidget r11 = this.a;
            if (r11.p0 == 0) goto L17;
            r11.Tq(!r11.V, false);
            return;
        L17:
            return;
        }
    }

    public static final class n implements js0.b {
        public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;
        public final /* synthetic */ rj0.a b;

        @Override // js0.b
        public final void onSuccess(String r4) {
            Intrinsics.checkNotNullParameter(r4, "track");
            IInteractService r5 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.getInteractAudienceService() == null) goto L19;
            rj0.a r6 = this.b;
            int r0 = InteractBeautyPreviewDialog.A;
            InteractBeautyPreviewDialog r7 = InteractBeautyPreviewDialog.a.a(r6, "", null);
            LinkPkInteractAudienceGuestWidget r1 = this.a;
            r1.Y = r7;
            FragmentActivity r2 = ((Widget) r1).context;
            if (r2 == null) goto L14;
            FragmentManager r3 = r2.getSupportFragmentManager();
            LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, "InteractBeautyPreviewDialog", r8);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r7, r8) == true) goto L21;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
        L12:
            r7.show(r3, "InteractBeautyPreviewDialog");
            return;
        L21:
            return;
        L14:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }

        public n(LinkPkInteractAudienceGuestWidget r1, rj0.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class o implements LinkSecurityManager.a {
        public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;

        @Override // com.bytedance.android.live.livepkaudience.linksecurity.LinkSecurityManager.a
        public final void b() {
        }

        @Override // com.bytedance.android.live.livepkaudience.linksecurity.LinkSecurityManager.a
        public final int a() {
            com.bytedance.android.live.livepkaudience.rtc.a r0 = this.a.e;
            if (r0 == null) goto L10;
            d0 r1 = r0.b;
            if (r1 == null) goto L11;
            d0.a r2 = r1.getBuilder();
            if (r2 != null) goto L9;
            return 0;
        L9:
            return r2.g();
        L11:
            return 0;
        L10:
            return 0;
        }

        @Override // com.bytedance.android.live.livepkaudience.linksecurity.LinkSecurityManager.a
        public final boolean c() {
            com.bytedance.android.live.livepkaudience.rtc.a r0 = this.a.e;
            if (r0 == null) goto L8;
            d0 r1 = r0.b;
            if (r1 != null) goto L7;
            return false;
        L7:
            return r1.t0();
        L8:
            return false;
        }

        @Override // com.bytedance.android.live.livepkaudience.linksecurity.LinkSecurityManager.a
        public final String getRtcExtInfo() {
            com.bytedance.android.live.livepkaudience.rtc.a r0 = this.a.e;
            if (r0 == null) goto L6;
            String r1 = r0.v;
            if (r1 == null) goto L6;
            return r1;
        L6:
            return "";
        }

        public o(LinkPkInteractAudienceGuestWidget r1) {
            this.a = r1;
        }
    }

    public static final class p<T> implements Observer {
        public final /* synthetic */ LinkPkInteractAudienceGuestWidget a;

        public p(LinkPkInteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Long r7 = (Long) r6;
            if (r7 == null) goto L14;
            long r0 = r7.longValue();
            this.a.p0 = r0;
            RevPkState r8 = jc1.k.n(ILinkServiceExternal.class).getPkServiceExternal().d();
            if (r0 != 0) goto L15;
            int r9 = com.bytedance.android.live.livepkaudience.widget.b.a[r8.ordinal()];
            if (r9 != 1) goto L9;
            this.a.Tq(true, false);
            return;
        L9:
            if (r9 != 2) goto L17;
            this.a.Tq(false, false);
            return;
        L17:
            return;
        L15:
            return;
        }
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAdminLinkWidget, com.bytedance.android.live.livepkaudience.base.h
    public final void Hl(if r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    public final m00.g Lq() {
        this.y = null;
        IBroadcastService r1 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        Context r2 = ((Widget) this).context;
        String r0 = this.A;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        m00.g r3 = r1.createVideoTalkView(r2, r0, true, false, false, this);
        this.y = r3;
        return r3;
    }

    public final InteractLiveCorePermissionGuarantor Pq() {
        return (InteractLiveCorePermissionGuarantor) this.H0.getValue();
    }

    public final int getLayoutId() {
        return 2131567753;
    }

    public final int getScene() {
        return 1;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget
    public final int xq() {
        return 1;
    }

    public static void cr() {
        if (ILiveLinkCameraBackUpConfigKt.supportAudienceCheckLinker((ILiveLinkCameraBackUpConfig) k60.a.getValue()) == true) goto L5;
        return;
    L5:
        LinkSecurityManager.c = null;
        LinkSecurityManager.d = LinkSecurityApi.VideoCaptureType.VIDEO_CAPTURE_DEVICE_UNKNOWN;
        LinkSecurityManager.b.clear();
    }

    @Override // com.bytedance.android.live.livepkaudience.service.a
    public final com.bytedance.android.live.livepkaudience.base.o A0() {
        com.bytedance.android.live.livepkaudience.base.o r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAdminManager");
    L5:
        return r0;
    }

    public final boolean Kq() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L5;
        int r1 = r0.getLinkMode();
    L7:
        if (v.a(r1, 2) == false) goto L9;
        return false;
    L9:
        boolean r2 = us1.e.a;
        if (us1.e.a(this.u) == true) goto L12;
        return false;
    L12:
        Room r3 = this.u;
        if (r3 == null) goto L15;
        LiveMode r4 = r3.getStreamType();
    L17:
        if (r4 == LiveMode.VIDEO) goto L19;
        return false;
    L19:
        if (v.a(r1, 32) == false) goto L21;
        return false;
    L21:
        if (us1.e.c(((Widget) this).dataCenter, this.u, false) == false) goto L26;
        return true;
    L26:
        return false;
    L15:
        r4 = null;
        goto L17
    L5:
        r1 = 0;
        goto L7
    }

    public final int Nq() {
        com.bytedance.android.live.livepkaudience.base.i r0 = this.s;
        if (r0 == null) goto L11;
        String r1 = dl0.n.d();
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r2 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r2 == null) goto L7;
        String r3 = r2.getAudienceSelfLinkMicId();
    L8:
        LinkPlayerInfo r4 = r0.o(r1, r3);
        if (r4 == null) goto L11;
        return r4.silenceStatus;
    L7:
        r3 = null;
    L11:
        return 0;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.liveinteract.plantform.core.u
    public final void Qc() {
        if (this.q == false) goto L8;
        com.bytedance.android.live.livepkaudience.rtc.a r0 = this.e;
        if (r0 == null) goto L9;
        r0.h(false, "mIsInBackground beforeStartEngine");
        return;
    L9:
        return;
    }

    public final void Sq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        Integer r1 = (Integer) r0.get("data_link_state", 0);
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L9:
        if (v.a(r2, 2) == false) goto L11;
    L12:
        this.K = System.currentTimeMillis();
        int r3 = al0.c.b;
        HashMap r4 = new HashMap();
        r4.put("live_type", "video_live");
        r4.put("function_type", al0.c.e());
        r4.put("function_type2", al0.c.e());
        r4.put("request_page", tc0.c.h().z);
        al0.c.b(r4);
        u.l().sendLog("livesdk_audience_voice_room_show", r4, new Object[]{Room.class, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        this.L = true;
        return;
    L11:
        if (v.a(r2, 32) == true) goto L12;
        return;
    L7:
        r2 = 0;
        goto L9
    }

    @Override // com.bytedance.android.live.livepkaudience.service.d
    public final boolean T2() {
        v0 r0 = this.x;
        if (r0 == null) goto L11;
        d0 r1 = r0.A();
        if (r1 == null) goto L11;
        d0.a r2 = r1.getBuilder();
        if (r2 == null) goto L11;
        if (r2.g() != 1) goto L11;
        return true;
    L11:
        return false;
    }

    public final void br() {
        if (ILiveLinkCameraBackUpConfigKt.supportAudienceCheckLinker((ILiveLinkCameraBackUpConfig) k60.a.getValue()) == true) goto L5;
        return;
    L5:
        CompositeDisposable r0 = LinkSecurityManager.b;
        o r1 = new o(this);
        Intrinsics.checkNotNullParameter(r1, "getter");
        LinkSecurityManager.c = r1;
        LinkSecurityManager.e();
    }

    @Override // com.bytedance.android.live.livepkaudience.service.d
    public final void cancelApply() {
        j0.a r0 = new j0.a(((Widget) this).context);
        r0.a = s1.B(2131917525);
        r0.b(s1.B(2131915913), new a(this));
        r0.a(s1.B(2131915442), b.a);
        r0.c();
    }

    public final void dr() {
        com.bytedance.android.live.livepkaudience.base.i r0 = this.s;
        String r1 = null;
        if (r0 == null) goto L9;
        LinkerBattleConnectContent r2 = this.k0;
        if (r2 == null) goto L7;
        Map r3 = r2.linkerContentMap;
    L8:
        r0.K(KotlinTypeUtilsKt.castElementType(r3));
        goto L9
    L7:
        r3 = null;
    L9:
        LinkerBattleConnectContent r4 = this.k0;
        if (r4 == null) goto L24;
        MultiChannelInfo r5 = r4.multiChannelInfo;
        if (r5 == null) goto L24;
        if (r5.getUseMultiChannel() == false) goto L24;
        q r6 = this.b;
        if (r6 == null) goto L18;
        r6.d = r4.rtcExtInfo;
    L18:
        com.bytedance.android.live.livepkaudience.rtc.a r7 = this.e;
        if (r7 == null) goto L21;
        com.bytedance.android.live.livepkaudience.rtc.a.j(r7, r4.rtcExtInfo);
    L21:
        com.bytedance.android.live.livepkaudience.rtc.a r8 = this.e;
        if (r8 == null) goto L24;
        com.bytedance.android.live.livepkaudience.rtc.a.i(r8, r4.liveCoreExtInfo);
    L24:
        com.bytedance.android.live.livepkaudience.base.i r9 = this.s;
        if (r9 == null) goto L33;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r10 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r10 == null) goto L29;
        String r11 = r10.getAudienceSelfLinkMicId();
    L30:
        LinkPlayerInfo r12 = r9.o("0", r11);
        if (r12 == null) goto L33;
        int r13 = r12.getLinkType();
    L35:
        if (r13 != 3) goto L37;
        Mo(false, false, false, false, false, null);
    L37:
        if (r13 == 2) goto L39;
        if (r13 == 3) goto L39;
    L45:
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r14 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r14 == null) goto L48;
        String r15 = r14.getAudienceSelfLinkMicId();
    L50:
        if (TextUtils.isEmpty(r15) == true) goto L68;
        com.bytedance.android.live.livepkaudience.rtc.a r16 = this.e;
        if (r16 == null) goto L67;
        LinkerBattleConnectContent r17 = this.k0;
        if (r17 == null) goto L56;
        String r18 = r17.rtcExtInfo;
    L57:
        if (r18 == null) goto L67;
        if (r18.length() <= 0) goto L61;
        boolean r19 = true;
    L62:
        if (r19 == false) goto L64;
        String r20 = r18;
    L65:
        if (r20 == null) goto L67;
        r16.v = r18;
        goto L67
    L64:
        r20 = null;
        goto L65
    L61:
        r19 = false;
        goto L62
    L56:
        r18 = null;
    L67:
        LinkSecurityManager.f("switch_resolution");
    L68:
        com.bytedance.android.live.livepkaudience.rtc.a r21 = this.e;
        if (r21 == null) goto L72;
        Map<String, Object> r22 = r21.s;
        if (r22 == null) goto L72;
    L73:
        String r23 = this.p;
        StringBuilder r24 = new StringBuilder("updateFirstVideoFrame linkerContentMap = ");
        LinkerBattleConnectContent r25 = this.k0;
        if (r25 == null) goto L76;
        Map r26 = r25.linkerContentMap;
    L77:
        r24.append(r26);
        r24.append(", remoteView = ");
        r24.append(r22.size());
        r24.append(", audienceSelfLinkMicId = ");
        LinkPkInteractGuestDataContext r27 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r27 == null) goto L80;
        String r28 = r27.getAudienceSelfLinkMicId();
    L81:
        r24.append(r28);
        ALogger.i(r23, r24.toString());
        Iterator<Map.Entry<String, Object>> r29 = r22.entrySet().iterator();
        String r30 = "";
    L83:
        if (r29.hasNext() == false) goto L101;
        Map.Entry<String, Object> r31 = r29.next();
        String r32 = r31.getKey();
        Object r33 = r31.getValue();
        ALogger.i(this.p, "updateFirstVideoFrame key1 = " + r32 + ", value = " + r33);
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r34 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r34 == null) goto L87;
        String r35 = r34.getAudienceSelfLinkMicId();
    L89:
        if (TextUtils.equals(r32, r35) == true) goto L83;
        r30 = r30 + ' ' + r32 + ", ";
        if ((r33 instanceof SurfaceView) == true) goto L92;
        if ((r33 instanceof TextureView) == true) goto L95;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r36 = ILiveWrappedLivePusher.a.b();
        if (r36 == null) goto L99;
        z.a r37 = r36.buildLayerControlLayer(r33);
    L100:
        b4(r32, r37, 0, 0);
        goto L83
    L99:
        r37 = null;
        goto L100
    L95:
        super.L0(r32, (TextureView) r33, 0, 0);
        goto L83
    L92:
        h1(r32, (SurfaceView) r33, 0, 0);
        goto L83
    L87:
        r35 = null;
        goto L89
    L101:
        dl0.m r38 = dl0.m.a;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r39 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r39 == null) goto L104;
        r1 = r39.getAudienceSelfLinkMicId();
    L104:
        int r40 = r22.size();
        r38.getClass();
        dl0.m.D(r1, r40, r30, false);
        return;
    L80:
        r28 = null;
        goto L81
    L76:
        r26 = null;
    L72:
        r22 = MapsKt.emptyMap();
        goto L73
    L48:
        r15 = null;
    L39:
        v0 r41 = this.x;
        if ((r41 instanceof m00.g) == true) goto L42;
        r41 = null;
    L42:
        m00.g r42 = (m00.g) r41;
        if (r42 == null) goto L45;
        r42.n();
        goto L45
    L29:
        r11 = null;
    L33:
        r13 = 2;
        goto L35
    }

    @Override // com.bytedance.android.live.livepkaudience.service.d
    public final m00.g getGuestLinkViewNew() {
        v0 r0 = this.x;
        if ((r0 instanceof m00.g) == true) goto L6;
        r0 = null;
    L6:
        return (m00.g) r0;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.service.d
    public final com.bytedance.android.live.livepkaudience.base.i getLinkUserCenter() {
        if (this.s != null) goto L5;
        this.s = new com.bytedance.android.live.livepkaudience.base.i(((Widget) this).dataCenter);
    L5:
        com.bytedance.android.live.livepkaudience.base.i r0 = this.s;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.d
    public final boolean isEngineOn() {
        com.bytedance.android.live.livepkaudience.rtc.a r0 = this.e;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.j;
    }

    @Override // com.bytedance.android.live.livepkaudience.vm.b
    public final boolean l5() {
        v0 r0 = this.x;
        if ((r0 instanceof m00.g) == true) goto L5;
        r0 = null;
    L5:
        m00.g r1 = (m00.g) r0;
        if (r1 != null) goto L10;
        return false;
    L10:
        return r1.isCameraOpen();
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAdminLinkWidget, com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget
    public final void onDestroy() {
        IPkAudienceLinkOutService r0 = (IPkAudienceLinkOutService) jc1.k.f(IPkAudienceLinkOutService.class);
        if (r0 == null) goto L6;
        r0.onPKInteractBizEnd();
    L6:
        if (((Boolean) rh0.a.getValue()).booleanValue() == false) goto L13;
        if (hd0.c.f().h() == false) goto L13;
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.c.Y0;
        Integer r2 = Integer.valueOf(hd0.c.f().g);
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r2);
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L13;
        r3.put("data_pk_to_video_talk_update_video_show_mode", Boolean.TRUE);
    L13:
        if (((Boolean) LiveInfraSettingKeys.LIVE_PK_AUDIO_EFFECT_OPT.getValue()).booleanValue() == false) goto L19;
        v0 r4 = this.x;
        if (r4 == null) goto L19;
        com.bytedance.android.live.pushstream.d r5 = r4.getLiveStream();
        if (r5 == null) goto L19;
        r5.k0(true, new Pair(1, 0), Boolean.TRUE);
    L19:
        IUserService r6 = jc1.k.f(IUserService.class);
        m00.g r7 = null;
        if (r6 == null) goto L24;
        com.bytedance.android.livesdk.user.f r8 = r6.user();
        if (r8 == null) goto L24;
        String r9 = r8.n();
    L25:
        Boolean r10 = (Boolean) ((Map) com.bytedance.android.livesdk.sharedpref.b.g.getValue()).get(this.I + r9);
        if (r10 == null) goto L28;
        boolean r11 = r10.booleanValue();
    L29:
        if (r11 == false) goto L39;
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 == null) goto L33;
        Boolean r13 = (Boolean) r12.get("data_link_pk_interact_show_red_dot", Boolean.TRUE);
    L35:
        if (Intrinsics.areEqual(r13, Boolean.FALSE) == false) goto L39;
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L39;
        r14.put("data_link_pk_interact_show_red_dot", Boolean.TRUE);
        goto L39
    L33:
        r13 = null;
    L39:
        PkGuestApplyDialog r15 = this.P;
        if (r15 != null) goto L42;
    L51:
        PkAudienceGuestInviteDialog r16 = this.v;
        if (r16 != null) goto L54;
    L58:
        PkAudiencePreApplyDialog r17 = this.Q;
        if (r17 != null) goto L61;
    L70:
        cr();
        lc0.d r18 = jc1.k.n(ILinkServiceExternal.class).getPkServiceExternal();
        r18.c(this.b1);
        r18.f(this.g1);
        if (((Boolean) fh0.a.getValue()).booleanValue() == false) goto L74;
        Pq().e();
    L74:
        if (this.z == null) goto L78;
        InteractAnimationContext.a r19 = InteractAnimationContext.Companion;
        if (r19.a() == null) goto L78;
        r19.a().l();
    L78:
        int r20 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        if (v.a(r20, 2) == true) goto L83;
        if (v.a(r20, 32) == true) goto L83;
    L85:
        boolean r21 = false;
    L86:
        StringBuilder r22 = new StringBuilder("isEngineOn = ");
        com.bytedance.android.live.livepkaudience.rtc.a r23 = this.e;
        if (r23 == null) goto L89;
        Boolean r24 = Boolean.valueOf(r23.j);
    L90:
        r22.append(r24);
        r22.append(", isOnline = ");
        r22.append(hd0.c.f().h());
        r22.append(", shouldSkip = ");
        r22.append(r21);
        String r25 = r22.toString();
        ALogger.i(this.p, "onDestroy " + r25);
        dl0.m r26 = dl0.m.a;
        String r27 = this.p + "_onDestroy";
        r26.getClass();
        dl0.m.C(r27, r25);
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r28 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r28 == null) goto L93;
        r28.setGuestAnchorLinkMicId("", "onDestroy");
    L93:
        com.bytedance.android.live.livepkaudience.rtc.a r29 = this.e;
        if (r29 == null) goto L98;
        if (r29.j != true) goto L98;
    L99:
        ILinkServiceExternal r30 = jc1.k.f(ILinkServiceExternal.class);
        if (r30 != null) goto L102;
    L116:
        DataCenter r31 = ((Widget) this).dataCenter;
        if (r31 == null) goto L119;
        r31.put("data_link_mic_is_quick_invite", Boolean.FALSE);
    L119:
        this.S.i = this.W.b;
        q r32 = this.b;
        long r33 = 0;
        if (r32 != null) goto L122;
    L124:
        RoomContext r34 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r34 == null) goto L131;
        com.bytedance.live.datacontext.m r35 = r34.getAnchorFinishLive();
        if (r35 == null) goto L131;
        if (((Boolean) r35.getValue()).booleanValue() != true) goto L131;
    L130:
        String r36 = "live_end";
    L132:
        String r110 = r36;
        int r37 = al0.c.b;
        Room r38 = this.u;
        com.bytedance.android.live.liveinteract.utils.d r111 = this.S;
        long r112 = this.E;
        m00.g r39 = this.x;
        if ((r39 instanceof m00.g) == false) goto L136;
        r7 = r39;
    L136:
        m00.g r40 = r7;
        if (r40 == null) goto L139;
        r33 = r40.b();
    L139:
        al0.c.g(r38, r110, r111, r112, r33, l5(), Long.valueOf((this.E - this.D) / ((long) 1000)));
        com.bytedance.android.live.liveinteract.utils.k r41 = ((IInteractService) jc1.k.n(IInteractService.class)).getInteractLogUtils();
        com.bytedance.android.live.liveinteract.utils.d r42 = this.S;
        ((jf0.c) r41).getClass();
        Intrinsics.checkNotNullParameter(r42, "params");
        jf0.c.a = r42;
    L140:
        com.bytedance.android.live.livepkaudience.rtc.a r43 = this.e;
        if (r43 == null) goto L143;
        r43.g("onDestroy");
    L143:
        com.bytedance.android.live.livepkaudience.presenter.a r44 = this.Z;
        if (r44 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("mAudioManagerPresenter");
    L146:
        if (r44 == null) goto L148;
        r44.detachView();
    L148:
        al0.a r45 = this.X;
        if (r45 != null) goto L151;
    L157:
        LinkPkSwitchCameraManager r46 = this.R;
        if (r46 == null) goto L162;
        r46.a.dispose();
        vlc.d r47 = r46.b;
        if (r47 == null) goto L162;
        r47.removeMessageListener(r46);
    L162:
        vlc.d r48 = this.T;
        if (r48 == null) goto L165;
        r48.removeMessageListener(this);
    L165:
        LiveDialogFragment r49 = this.Y;
        if (r49 != null) goto L168;
    L171:
        super.onDestroy();
        if (this.L == false) goto L184;
        int r50 = al0.c.b;
        long r51 = this.K;
        Room r52 = this.u;
        if (r52 == null) goto L176;
        ICircleInfo r53 = r52.getCircleInfo();
    L178:
        if ((r53 instanceof CircleInfo) == true) goto L180;
        r53 = null;
    L180:
        CircleInfo r54 = (CircleInfo) r53;
        if (r54 != null) goto L183;
        r54 = null;
    L183:
        al0.c.f(r51, r54);
        goto L184
    L176:
        r53 = null;
    L184:
        this.f = false;
        CompositeDisposable r55 = this.w;
        if (r55 == null) goto L187;
        r55.dispose();
    L187:
        if (r21 == true) goto L197;
        v0 r56 = this.x;
        if (r56 == null) goto L191;
        r56.release();
    L191:
        Integer r57 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r57 != null) goto L195;
    L196:
        Aq();
        goto L197
    L195:
        if (r57.intValue() != 0) goto L196;
    L197:
        v0 r58 = this.x;
        if ((r58 instanceof m00.g) == true) goto L200;
        r58 = null;
    L200:
        m00.g r59 = (m00.g) r58;
        if (r59 == null) goto L203;
        r59.l();
    L203:
        DataCenter r60 = ((Widget) this).dataCenter;
        if (r60 == null) goto L206;
        r60.put("data_interact_audience_video_translation", Boolean.FALSE);
    L206:
        DataCenter r61 = ((Widget) this).dataCenter;
        if (r61 == null) goto L209;
        r61.put("data_pk_anchor_silence_status_change", Boolean.FALSE);
    L209:
        ILinkServiceExternal r62 = jc1.k.f(ILinkServiceExternal.class);
        if (r62 == null) goto L212;
        r62.notifyPkAnchorSilenceStatus(false);
    L212:
        tc0.c r63 = tc0.c.h();
        Boolean r65 = Boolean.FALSE;
        r63.j(r65);
        LinkPkInteractAudienceWindowManagerV2 r66 = this.t;
        if (r66 == null) goto L249;
        int r67 = LinkPkInteractAudienceWindowManagerV2.T;
        Intrinsics.checkNotNullParameter(MultiLinkOpenSource.DEFAULT, "reason");
        r66.p = false;
        r66.j = false;
        r66.b.removeOnLayoutChangeListener(r66.I);
        com.bytedance.android.live.livepkaudience.base.i r68 = r66.h;
        if (r68 == null) goto L217;
        r68.J(r66);
    L217:
        el0.f r69 = r66.n;
        if (r69 == null) goto L220;
        r69.a.J(r69);
    L220:
        Iterator r70 = ((ArrayList) r66.d).iterator();
    L222:
        if (r70.hasNext() == false) goto L224;
        r66.b.removeView((el0.a) r70.next());
        goto L222
    L224:
        r66.m();
        if (Intrinsics.areEqual(MultiLinkOpenSource.DEFAULT, MultiLinkOpenSource.DEFAULT) == false) goto L238;
        DataCenter r71 = r66.u;
        if (r71 == null) goto L229;
        r71.put("cmd_what_audience_join_self_link", r65);
    L229:
        ILinkServiceExternal r72 = jc1.k.f(ILinkServiceExternal.class);
        if (r72 == null) goto L232;
        r72.onAudienceJoinSelfLink(false);
    L232:
        DataCenter r73 = r66.u;
        if (r73 == null) goto L235;
        r73.put("cmd_what_audience_join_guest_link", r65);
    L235:
        ILinkServiceExternal r74 = jc1.k.f(ILinkServiceExternal.class);
        if (r74 == null) goto L238;
        r74.onAudienceJoinGuestLink(false);
    L238:
        DataCenter r75 = r66.u;
        if (r75 == null) goto L241;
        r75.removeObserver(r66);
    L241:
        DataCenter r76 = r66.u;
        if (r76 == null) goto L244;
        r76.removeObserver("data_audio_chat_support_send_gift_to_linker", r66.J);
    L244:
        com.bytedance.android.live.livepkaudience.seat.f r77 = r66.F;
        if (r77 == null) goto L247;
        ((LinkedHashMap) r77.a).clear();
    L247:
        r66.B();
        r66.G.c(r66.K);
        r66.G.f(r66.L);
        ((ArrayList) r66.d).clear();
        ((LinkedHashMap) r66.m).clear();
    L249:
        if (((Boolean) c1.a.getValue()).booleanValue() == false) goto L251;
        this.t = null;
    L251:
        this.W.b();
        Disposable r78 = this.J;
        if (r78 == null) goto L254;
        r78.dispose();
    L254:
        DataCenter r79 = ((Widget) this).dataCenter;
        if (r79 == null) goto L263;
        r79.removeObserver(this);
        return;
    L263:
        return;
    L168:
        if (r49.isShowing() == false) goto L170;
        Iq(r49);
    L170:
        this.Y = null;
        goto L171
    L151:
        if (r45.c == true) goto L157;
        ALogger.i("LinkInfoReportHelper", "release: linkCount=" + r45.b);
        r45.e.J(r45.a);
        r45.c = true;
        if (r45.b <= 0) goto L156;
        r45.a();
    L156:
        r45.b = 0;
    L131:
        r36 = "leave_normally";
        goto L132
    L122:
        if (r32.k != true) goto L124;
    L102:
        if (r30.isSpatialAudioEnable(4) != true) goto L116;
        com.bytedance.android.live.livepkaudience.rtc.a r80 = this.e;
        if (r80 == null) goto L116;
        ei6.a r81 = r80.a;
        if (r81 == null) goto L116;
        SpatialAudioManager r82 = r81.m();
        if (r82 == null) goto L116;
        com.bytedance.android.live.livepkaudience.rtc.a r83 = this.e;
        if (r83 == null) goto L114;
        Room r84 = r83.w;
        if (r84 == null) goto L114;
        Long r85 = Long.valueOf(r84.getRoomId());
    L115:
        r82.b(String.valueOf(r85), false);
    L114:
        r85 = null;
    L98:
        if (hd0.c.f().h() == false) goto L140;
    L89:
        r24 = null;
    L83:
        if (this.f == true) goto L85;
        r21 = true;
        goto L86
    L61:
        if (r17.isShowing() != true) goto L70;
        PkAudiencePreApplyDialog r86 = this.Q;
        if (r86 == null) goto L70;
        r86.dismiss();     // Catch: Exception -> L66
    L66:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r87 = DialogFragmentLancet.sLastShowStack;
        if (r87 == null) goto L70;
        com.bytedance.crash.d.d(r87, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L70
    L54:
        if (r16.isShowing() != true) goto L58;
        PkAudienceGuestInviteDialog r88 = this.v;
        if (r88 == null) goto L58;
        Iq(r88);
        goto L58
    L42:
        if (r15.isShowing() != true) goto L51;
        PkGuestApplyDialog r89 = this.P;
        if (r89 == null) goto L51;
        r89.dismiss();     // Catch: Exception -> L47
    L47:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r90 = DialogFragmentLancet.sLastShowStack;
        if (r90 == null) goto L51;
        com.bytedance.crash.d.d(r90, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L51
    L28:
        r11 = false;
    L24:
        r9 = null;
        goto L25
    }

    @Override // com.bytedance.android.live.livepkaudience.service.d
    public final void onFirstRemoteVideoSend() {
        if (((Boolean) zg0.a.getValue()).booleanValue() == false) goto L6;
        dr();
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget
    public final void Aq() {
        super.Aq();
        LinkPkInteractAudienceWindowManagerV2 r0 = this.t;
        if (r0 == null) goto L5;
        r0.z(true);
    L5:
        this.U = true;
        Runnable r1 = this.B;
        if (r1 == null) goto L8;
        r1.run();
    L8:
        this.B = null;
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L11;
        r2.put("cmd_what_audience_self_join", Boolean.FALSE);
    L11:
        ILinkServiceExternal r3 = jc1.k.f(ILinkServiceExternal.class);
        if (r3 == null) goto L15;
        r3.notifyAudienceSelfJoin(false);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.base.h
    public final void I3() {
        Aq();
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r0 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r0 == null) goto L5;
        r0.setAudienceSelfLinkMicId("");
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L8;
        r1.put("DATA_DISCONNECT_LINK", Boolean.TRUE);
    L8:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L11;
        r2.put("cmd_what_audience_self_leave", Unit.INSTANCE);
    L11:
        ILinkServiceExternal r3 = jc1.k.f(ILinkServiceExternal.class);
        if (r3 == null) goto L15;
        r3.notifyAudienceSelfLeave();
    L15:
        if (Intrinsics.areEqual(this.h, "kick_out") == false) goto L17;
        f2.b(2131923150, 0);
    L21:
        tc0.c.h().F = "";
        this.W.b();
        v0 r4 = this.x;
        if ((r4 instanceof m00.g) == true) goto L24;
        r4 = null;
    L24:
        m00.g r5 = (m00.g) r4;
        if (r5 == null) goto L27;
        r5.l();
    L27:
        LiveDialogFragment r6 = this.Y;
        if (r6 == null) goto L31;
        Iq(r6);
        return;
    L31:
        return;
    L17:
        f2.b(2131919287, 0);
        if (Intrinsics.areEqual(this.h, "live_end") == false) goto L20;
        cl0.a.f(cl0.a.d);
        goto L21
    L20:
        cl0.a r7 = cl0.a.d;
        LinkedHashMap r8 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r9 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r10 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, "config");
        r7.c("sense_disconnect_by_self", r8, r9, r10);
        goto L21
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.base.h
    public final void Ke() {
        hd0.c.f().k(0);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void M1() {
        super.M1();
        v0 r0 = this.x;
        if ((r0 instanceof m00.g) == true) goto L5;
        r0 = null;
    L5:
        m00.g r1 = (m00.g) r0;
        if (r1 == null) goto L8;
        r1.l();
    L8:
        this.x = null;
        q r2 = this.b;
        if (r2 == null) goto L11;
        r2.l = false;
    L11:
        cr();
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == true) goto L14;
    L16:
        int r3 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        if (v.a(r3, 32) == false) goto L19;
        return;
    L19:
        if (v.a(r3, 2) == true) goto L24;
        I3();
        return;
    L24:
        return;
    L14:
        if (((Boolean) gh0.a.getValue()).booleanValue() == false) goto L16;
        Aq();
        goto L16
    }

    public final void Wq() {
        Pair<List<LinkPlayerInfo>, List<LinkPlayerInfo>> r0 = getLinkUserCenter().i();
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        String r2 = "";
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.m r3 = r1.getRoom();
        if (r3 == null) goto L10;
        Room r4 = (Room) r3.getValue();
        if (r4 == null) goto L10;
        String r5 = r4.getOwnerUserIdString();
        if (r5 == null) goto L10;
    L11:
        ILinkServiceExternal r6 = jc1.k.f(ILinkServiceExternal.class);
        if (r6 == null) goto L18;
        lc0.c r7 = r6.getMultiDataHolder();
        if (r7 == null) goto L18;
        String r8 = r7.a();
        if (r8 == null) goto L18;
        r2 = r8;
    L18:
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r9 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r9 == null) goto L24;
        MutableLiveData<String> r10 = r9.getGuestLynxListData();
        if (r10 == null) goto L25;
        r10.setValue(dl0.f.a((List) r0.getFirst(), (List) r0.getSecond(), r5, r2));
        return;
    L25:
        return;
    L24:
        return;
    L10:
        r5 = "";
        goto L11
    }

    @Override // com.bytedance.android.live.livepkaudience.service.d
    public final m00.g go() {
        Lq();
        m00.g r0 = this.y;
        if ((r0 instanceof m00.g) == true) goto L6;
        return null;
    L6:
        return r0;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o() {
        super.o();
        lc0.d r0 = jc1.k.n(ILinkServiceExternal.class).getPkServiceExternal();
        r0.a(this.b1);
        r0.E(this.g1);
        String r1 = this.p;
        StringBuilder r2 = new StringBuilder("onStartSuccess multiChannelInfo = ");
        q r3 = this.b;
        String r4 = null;
        if (r3 == null) goto L5;
        MultiChannelInfo r5 = r3.e;
    L6:
        r2.append(r5);
        ALogger.i(r1, r2.toString());
        LinkPkInteractAudienceWindowManagerV2 r6 = this.t;
        if (r6 == null) goto L10;
        r6.A();
    L10:
        if (this.q == false) goto L23;
        com.bytedance.android.live.livepkaudience.rtc.a r7 = this.e;
        if (r7 == null) goto L23;
        if (r7.j != true) goto L23;
        if (Nq() != 0) goto L31;
        com.bytedance.android.live.livepkaudience.rtc.a r8 = this.e;
        if (r8 == null) goto L31;
        if (r8.j == false) goto L31;
        r8.h(false, "GuestRtcManager onPause");
    L31:
        if (dl0.n.b() == false) goto L46;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r9 = ILiveWrappedLivePusher.a.b();
        if (r9 == null) goto L37;
        m1.b r10 = r9.newVideoMixerDescription(null);
        if (r10 == null) goto L37;
        r10.e();
        r10.b();
        r10.c();
        r10.f();
        r10.i();
    L37:
        v0 r11 = this.c;
        if (r11 == null) goto L46;
        d0 r12 = r11.A();
        if (r12 == null) goto L46;
        z r13 = r12.C();
        if (r13 == null) goto L46;
        z.a r14 = r13.K0();
        if (r14 == null) goto L46;
        r14.b();
    L46:
        this.E = System.currentTimeMillis();
        this.F = System.currentTimeMillis();
        com.bytedance.android.live.liveinteract.utils.d r15 = this.S;
        r15.l = (this.E - this.D) / ((long) 1000);
        DataCenter r16 = ((Widget) this).dataCenter;
        if (r16 == null) goto L51;
        Boolean r17 = (Boolean) r16.get("data_link_mic_is_quick_invite", Boolean.FALSE);
        if (r17 == null) goto L51;
        boolean r18 = r17.booleanValue();
    L52:
        r15.h = r18;
        int r19 = al0.c.b;
        al0.c.h(this.u, this.S, false);
        LinkPkInteractAudienceWindowManagerV2 r20 = this.t;
        if (r20 == null) goto L55;
        r20.z(false);
    L55:
        this.U = false;
        if (hd0.c.f().g == 2) goto L60;
        com.bytedance.android.livesdk.sharedpref.e r21 = com.bytedance.android.livesdk.sharedpref.b.O;
        if (((Boolean) r21.getValue()).booleanValue() == false) goto L60;
        com.bytedance.android.livesdk.sharedpref.f.d(r21, Boolean.FALSE);
        f2.b(2131917575, 0);
    L61:
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r22 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r22 == null) goto L64;
        r4 = r22.getAudienceSelfLinkMicId();
    L64:
        if (r4 != null) goto L66;
    L69:
        boolean r23 = true;
    L70:
        if (r23 == true) goto L72;
        this.W.c(r4, false);
    L73:
        q r24 = this.b;
        if (r24 == null) goto L76;
        r24.l = true;
        r24.k = false;
    L76:
        br();
        LinkSecurityManager.f("join_channel");
        return;
    L72:
        this.W.b();
        goto L73
    L66:
        if (r4.length() == 0) goto L69;
        r23 = false;
    L60:
        f2.b(2131917511, 0);
    L51:
        r18 = false;
    L23:
        if (tc0.c.h().C == false) goto L27;
        com.bytedance.android.live.livepkaudience.rtc.a r25 = this.e;
        if (r25 == null) goto L31;
        r25.h(false, "isSilenceWhenStart");
        goto L31
    L27:
        com.bytedance.android.live.livepkaudience.rtc.a r26 = this.e;
        if (r26 == null) goto L31;
        r26.h(true, "onStartSuccess");
        goto L31
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAdminLinkWidget, com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget
    public final void onCreate() {
        super.onCreate();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        Room r1 = (Room) r0.get("data_room", new Room());
        if (r1 == null) goto L6;
    L7:
        this.u = r1;
        this.L = v.a(((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode(), 32);
        if (v.a(((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode(), 32) == false) goto L10;
        this.K = System.currentTimeMillis();
    L10:
        getLinkUserCenter().c(this.V0);
        Wq();
        Disposable r2 = ((InteractService.a) this.z).a(((Widget) this).dataCenter);
        if (r2 == null) goto L13;
        this.w.add(r2);
    L13:
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L341;
        FrameLayout r4 = (FrameLayout) r3;
        com.bytedance.android.live.livepkaudience.base.i r5 = this.s;
        FragmentActivity r6 = ((Widget) this).context;
        if (r6 == null) goto L339;
        FragmentActivity r7 = r6;
        View r8 = r3.findViewById(2131392689);
        if (((Boolean) c1.a.getValue()).booleanValue() == false) goto L20;
        xk0.b r9 = new xk0.a(new WeakReference(this));
    L21:
        LinkPkInteractAudienceWindowManagerV2 r10 = new LinkPkInteractAudienceWindowManagerV2(r4, r5, r7, this, r8, r9, this.b, this.h1);
        this.t = r10;
        if (this.z == null) goto L26;
        InteractAnimationContext.a r11 = InteractAnimationContext.Companion;
        if (r11.a() == null) goto L26;
        r11.a().g(r10);
    L26:
        LinkPkInteractAudienceWindowManagerV2 r12 = this.t;
        if (r12 == null) goto L30;
        r12.k = new g(this);
    L30:
        if (r12 == null) goto L44;
        DataCenter r13 = ((Widget) this).dataCenter;
        r12.u = r13;
        if (r13 == null) goto L36;
        Boolean r14 = (Boolean) r13.get("data_is_portrait", Boolean.TRUE);
        if (r14 == null) goto L36;
        boolean r15 = r14.booleanValue();
    L37:
        r12.q = r15;
        DataCenter r16 = r12.u;
        if (r16 == null) goto L40;
        r16.observe("data_intimate_chat_support_send_gift_to_linker", r12.J);
    L40:
        DataCenter r17 = r12.u;
        if (r17 == null) goto L43;
        r17.observe("data_big_party_support_send_gift_to_linker", r12.J);
    L43:
        r12.r = !e5.n();
    L36:
        r15 = true;
    L44:
        ((jf0.c) ((IInteractService) jc1.k.n(IInteractService.class)).getInteractLogUtils()).getClass();
        com.bytedance.android.live.liveinteract.utils.d r18 = jf0.c.a;
        if (r18 == null) goto L47;
        this.S = r18;
    L47:
        LinkPkInteractAudienceWindowManagerV2 r19 = this.t;
        String r20 = null;
        if (r19 == null) goto L70;
        DataCenter r21 = r19.u;
        if (r21 == null) goto L52;
        Room r22 = (Room) r21.get("data_room");
    L53:
        r19.i = r22;
        if (r22 != null) goto L56;
    L58:
        com.bytedance.android.live.livepkaudience.base.i r23 = r19.h;
        if (r23 == null) goto L61;
        r23.c(r19);
    L61:
        r19.s = true;
        r19.p = true;
        el0.f r24 = r19.n;
        if (r24 == null) goto L64;
        r24.a.c(r24);
    L64:
        r19.b.addOnLayoutChangeListener(r19.I);
        DataCenter r25 = r19.u;
        if (r25 == null) goto L67;
        r25.observeForever("cmd_what_adjust_guest_window_by_sei", r19);
    L67:
        FragmentActivity r26 = r19.a;
        if (r26 == null) goto L70;
        ((ArrayList) r19.d).add(new el0.a(r26, null, r19, r19.u, null));
        ((ArrayList) r19.d).add(new el0.a(r26, null, r19, r19.u, null));
        goto L70
    L56:
        if (r19.n != null) goto L58;
        r19.n = new el0.f(r22, r19.N, r19);
        goto L58
    L52:
        r22 = null;
    L70:
        com.bytedance.android.live.liveinteract.utils.d r27 = this.S;
        Room r28 = this.u;
        if (r28 == null) goto L74;
        String r29 = r28.getOwnerUserIdString();
        if (r29 == null) goto L74;
    L75:
        r27.getClass();
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        r27.f = r29;
        LinkPkSwitchCameraManager r30 = new LinkPkSwitchCameraManager(((Widget) this).context, ((Widget) this).dataCenter, getLinkUserCenter(), this);
        this.R = r30;
        r30.j();
        com.bytedance.android.live.liveinteract.utils.d r31 = this.S;
        Room r32 = this.u;
        if (r32 == null) goto L78;
        long r33 = r32.id;
    L79:
        r31.e = r33;
        LinkPkInteractAudienceWindowManagerV2 r34 = this.t;
        if (r34 == null) goto L82;
        r34.A = this.e;
    L82:
        Pair r35 = com.bytedance.live.datacontext.d.a(LinkPkInteractAudienceGuestWidget$onCreate$dataPair$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r35.getFirst(), "linkpk_interact_guest_service");
        ((LinkPkInteractGuestContext) r35.getFirst()).getService().d(this);
        this.w.add((Disposable) r35.getSecond());
        Pair r36 = com.bytedance.live.datacontext.d.a(LinkPkInteractAudienceGuestWidget$onCreate$dataPair2$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r36.getFirst(), "linkpk_interact_admin_service");
        ((LinkPkInteractAdminContext) r36.getFirst()).getService().d(this);
        this.w.add((Disposable) r36.getSecond());
        Pair r37 = com.bytedance.live.datacontext.d.a(AnonymousClass4.INSTANCE);
        PkGuestApplyViewModel r38 = (PkGuestApplyViewModel) r37.component1();
        Disposable r39 = (Disposable) r37.component2();
        com.bytedance.live.datacontext.b.a(r38, PkGuestApplyViewModel.TAG);
        this.w.add(r39);
        DataCenter r40 = ((Widget) this).dataCenter;
        if (r40 == null) goto L85;
        vlc.d r41 = (vlc.d) r40.get("data_message_manager");
    L86:
        this.T = r41;
        if (r41 == null) goto L89;
        r41.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getIntType(), this);
    L89:
        vlc.d r42 = this.T;
        if (r42 == null) goto L92;
        r42.addMessageListener(MessageType.LINK_MIC_SIGNAL.getIntType(), this);
    L92:
        vlc.d r43 = this.T;
        if (r43 == null) goto L95;
        r43.addMessageListener(MessageType.LINKER.getIntType(), this);
    L95:
        vlc.d r44 = this.T;
        if (r44 == null) goto L98;
        r44.addMessageListener(MessageType.LINK_MIC_DYNAMIC_EMOJI_MESSAGE.getIntType(), this);
    L98:
        DataCenter r45 = ((Widget) this).dataCenter;
        if (r45 == null) goto L101;
        r45.observeForever("data_link_state", this);
    L101:
        DataCenter r46 = ((Widget) this).dataCenter;
        if (r46 == null) goto L104;
        r46.observeForever("data_observe_pk_id_start", this);
    L104:
        com.bytedance.android.live.livepkaudience.presenter.a r47 = new com.bytedance.android.live.livepkaudience.presenter.a(false, ((Widget) this).dataCenter);
        this.Z = r47;
        r47.c0(this);
        IPkAudienceLinkOutService r48 = (IPkAudienceLinkOutService) jc1.k.f(IPkAudienceLinkOutService.class);
        if (r48 == null) goto L108;
        r48.onPKInteractBizStart();
    L108:
        if (hd0.c.f().j() == true) goto L110;
        hd0.c.f().k(0);
    L110:
        com.bytedance.android.livesdk.sharedpref.e r49 = com.bytedance.android.livesdk.sharedpref.b.H0;
        if (((Boolean) r49.getValue()).booleanValue() == false) goto L113;
    L115:
        IUserService r50 = jc1.k.f(IUserService.class);
        if (r50 == null) goto L120;
        com.bytedance.android.livesdk.user.f r51 = r50.user();
        if (r51 == null) goto L120;
        String r52 = r51.n();
    L121:
        String r53 = this.I + r52;
        com.bytedance.android.livesdk.sharedpref.e r54 = com.bytedance.android.livesdk.sharedpref.b.g;
        Boolean r55 = (Boolean) ((Map) r54.getValue()).get(r53);
        if (r55 == null) goto L124;
        boolean r56 = r55.booleanValue();
    L125:
        if (r56 == true) goto L130;
        DataCenter r57 = ((Widget) this).dataCenter;
        if (r57 == null) goto L129;
        r57.put("data_link_pk_interact_show_red_dot", Boolean.FALSE);
    L129:
        ((Map) r54.getValue()).put(r53, Boolean.TRUE);
    L130:
        LinkPkInteractAudienceWindowManagerV2 r58 = this.t;
        if (r58 == null) goto L140;
        com.bytedance.android.live.livepkaudience.rtc.a r59 = this.e;
        if (r59 != null) goto L135;
    L138:
        boolean r60 = true;
    L139:
        r58.z(r60);
        goto L140
    L135:
        if (r59.j == false) goto L138;
        r60 = false;
    L140:
        com.bytedance.android.live.livepkaudience.rtc.a r61 = this.e;
        if (r61 != null) goto L143;
    L151:
        com.bytedance.android.live.livepkaudience.rtc.a r62 = this.e;
        if (r62 != null) goto L154;
    L297:
        LinkerBattleConnectContent r63 = this.k0;
        if (r63 == null) goto L300;
        Map r65 = r63.linkerContentMap;
    L301:
        if (r65 == null) goto L303;
        dr();
    L303:
        com.bytedance.android.live.livepkaudience.rtc.a r66 = this.e;
        if (r66 != null) goto L306;
    L307:
        DataCenter r67 = ((Widget) this).dataCenter;
        if (r67 == null) goto L311;
        r20 = (String) r67.get("is_auto_link_mic", null);
    L311:
        if (TextUtils.equals(r20, "true") == true) goto L313;
    L316:
        this.X = new al0.a(getLinkUserCenter());
        if (((Boolean) fh0.a.getValue()).booleanValue() == true) goto L319;
    L325:
        com.bytedance.live.datacontext.m r68 = jc1.k.n(IKtvService.class).getKtvComponentStatusChangedObservable();
        if (r68 == null) goto L333;
        Observable r69 = r68.a();
        if (r69 == null) goto L333;
        Disposable r70 = r69.subscribe(new com.bytedance.android.live.livepkaudience.widget.f(this));
        if (r70 == null) goto L333;
        RxUtilKt.c(r70, this.w);
    L333:
        if (((Boolean) ah0.a.getValue()).booleanValue() == false) goto L371;
        Disposable r71 = xs2.b.a().b(BlockTouchUpdateEvent.class).subscribe(new h(this));
        if (r71 == null) goto L372;
        RxUtilKt.c(r71, this.w);
        return;
    L372:
        return;
    L371:
        return;
    L319:
        if ((getContext() instanceof FragmentActivity) == false) goto L325;
        InteractLiveCorePermissionGuarantor r72 = Pq();
        Context r73 = getContext();
        if (r73 == null) goto L324;
        r72.i((FragmentActivity) r73);
        goto L325
    L324:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L313:
        if (us1.b.c() == false) goto L315;
        f2.c(s1.B(2131917648), 0);
        goto L316
    L315:
        com.bytedance.android.live.liveinteract.utils.d r74 = this.S;
        r74.d = 107;
        Intrinsics.checkNotNullParameter("invite_mutual", "<set-?>");
        r74.b = "invite_mutual";
        LinkApplyType r75 = LinkApplyType.STRONG_REACH;
        Intrinsics.checkNotNullParameter(r75, "applyType");
        Intrinsics.checkNotNullParameter("auto_apply_remind", "fromSource");
        wq(OperateType.APPLY, 2, new com.bytedance.android.live.livepkaudience.base.b(this, 2, 16, r75, "auto_apply_remind"));
        goto L316
    L306:
        if (r66.j == true) goto L316;
    L300:
        r65 = null;
        goto L301
    L154:
        if (r62.j != true) goto L297;
        IInteractService r76 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r76 == null) goto L158;
        int r77 = r76.getLinkMode();
    L160:
        if (v.a(r77, 2) == false) goto L162;
        f2.c(s1.B(2131915216), 0);
        this.U = false;
        F3("leave_channel_old_version");
        goto L297
    L162:
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r78 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r78 == null) goto L165;
        r78.setAudienceSelfLinkMicId(tc0.c.h().f);
    L165:
        com.bytedance.android.live.livepkaudience.rtc.c.t0.getClass();
        com.bytedance.android.live.livepkaudience.rtc.c r79 = com.bytedance.android.live.livepkaudience.rtc.c.a.a();
        if (r79 == null) goto L223;
        LinkerBattleConnectContent r80 = r79.getLinkerContentMap();
        if (r80 == null) goto L223;
        this.k0 = r80;
        MultiChannelInfo r81 = r80.multiChannelInfo;
        if (r81 != null) goto L172;
    L178:
        LinkPkInteractGuestDataContext r82 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r82 == null) goto L181;
        String r83 = r82.getAudienceSelfLinkMicId();
    L183:
        if (TextUtils.isEmpty(r83) == false) goto L223;
        LinkerBattleConnectContent r84 = this.k0;
        if (r84 == null) goto L223;
        Map r85 = r84.linkerContentMap;
        if (r85 == null) goto L223;
        LinkedHashMap r86 = new LinkedHashMap(MapsKt.mapCapacity(r85.size()));
        Iterator r87 = r85.entrySet().iterator();
    L190:
        if (r87.hasNext() == false) goto L223;
        Map.Entry r88 = (Map.Entry) r87.next();
        long r110 = ((Number) r88.getKey()).longValue();
        Room r89 = this.u;
        if (r89 == null) goto L222;
        if (r110 != r89.id) goto L222;
        LinkerBattleConnectContent r90 = this.k0;
        if (r90 == null) goto L222;
        Map r91 = r90.linkerContentMap;
        if (r91 == null) goto L222;
        g2 r92 = (g2) r91.get(r88.getKey());
        if (r92 == null) goto L222;
        List r93 = r92.getLinkedUsers();
        if (r93 == null) goto L222;
        Iterator r94 = r93.iterator();
    L205:
        if (r94.hasNext() == false) goto L222;
        com.bytedance.android.livesdk.link.model.bridge.k r111 = (com.bytedance.android.livesdk.link.model.bridge.k) r94.next();
        if (r111 == null) goto L211;
        IBaseUser r112 = r111.getUser();
        if (r112 == null) goto L211;
        String r113 = r112.getIdString();
    L213:
        if (Intrinsics.areEqual(r113, dl0.n.d()) == false) goto L205;
        if (TextUtils.isEmpty(r111.getLinkMicIdStr()) == true) goto L216;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r114 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r114 == null) goto L205;
        r114.setAudienceSelfLinkMicId(r111.getLinkMicIdStr());
        goto L205
    L216:
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r115 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r115 == null) goto L205;
        r115.setAudienceSelfLinkMicId(String.valueOf(r111.getLinkMicIdStr()));
    L211:
        r113 = null;
    L222:
        r86.put(Unit.INSTANCE, r88.getValue());
        goto L190
    L181:
        r83 = null;
        goto L183
    L172:
        if (r81.getUseMultiChannel() == false) goto L178;
        Map<Long, String> r95 = r81.getChannelMap();
        if (r95 == null) goto L178;
        com.bytedance.android.live.livepkaudience.rtc.a r96 = this.e;
        if (r96 == null) goto L178;
        r96.e(r95, "onCreate", String.valueOf(this.L0.getChannelId()));
    L223:
        String r97 = this.p;
        StringBuilder r98 = new StringBuilder("onCreate isEngineon getGuestLinkMicId = ");
        r98.append(this.L0.y());
        r98.append(", mRoom?.id = ");
        Room r99 = this.u;
        if (r99 == null) goto L226;
        Long r100 = Long.valueOf(r99.id);
    L227:
        r98.append(r100);
        ALogger.e(r97, r98.toString());
        if (TextUtils.isEmpty(this.L0.y()) == false) goto L265;
        LinkerBattleConnectContent r101 = this.k0;
        if (r101 == null) goto L265;
        List r102 = r101.anchorUserList;
        if (r102 == null) goto L265;
        Iterator r103 = r102.iterator();
    L235:
        if (r103.hasNext() == false) goto L265;
        AnchorLinkUser r104 = (AnchorLinkUser) r103.next();
        String r105 = this.p;
        StringBuilder r106 = new StringBuilder("onCreate isEngineon liveRoomId = ");
        User r116 = r104.getMUser();
        if (r116 == null) goto L239;
        Long r117 = Long.valueOf(r116.getLiveRoomId());
    L240:
        r106.append(r117);
        r106.append(", linkmicIdStr = ");
        r106.append(r104.getMLinkmicIdStr());
        ALogger.e(r105, r106.toString());
        User r107 = r104.getMUser();
        if (r107 == null) goto L243;
        String r108 = r107.getIdString();
    L244:
        LinkPkInteractAudienceWindowManagerV2 r109 = this.t;
        if (r109 == null) goto L247;
        String r118 = r109.p();
    L249:
        if (Intrinsics.areEqual(r108, r118) == true) goto L262;
        Room r119 = this.u;
        if (r119 == null) goto L253;
        Long r120 = Long.valueOf(r119.id);
    L254:
        User r121 = r104.getMUser();
        if (r121 == null) goto L257;
        Long r122 = Long.valueOf(r121.getLiveRoomId());
    L259:
        if ((!Intrinsics.areEqual(r120, r122)) == false) goto L235;
        if (((Boolean) eh0.a.getValue()).booleanValue() == false) goto L235;
    L257:
        r122 = null;
        goto L259
    L253:
        r120 = null;
    L262:
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r123 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r123 == null) goto L235;
        r123.setGuestAnchorLinkMicId(r104.getMLinkmicIdStr(), "onCreate");
        goto L235
    L247:
        r118 = null;
        goto L249
    L243:
        r108 = null;
        goto L244
    L239:
        r117 = null;
    L265:
        com.bytedance.android.live.livepkaudience.rtc.a r124 = this.e;
        if (r124 == null) goto L279;
        Map<String, Object> r125 = r124.s;
        if (r125 == null) goto L279;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r126 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r126 == null) goto L273;
        String r127 = r126.getAudienceSelfLinkMicId();
        if (r127 == null) goto L273;
    L274:
        SurfaceView r128 = this.x;
        if (r128 == null) goto L278;
        r125.put(r127, r128);
        goto L279
    L278:
        throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
    L273:
        r127 = "";
    L279:
        DataCenter r129 = ((Widget) this).dataCenter;
        if (r129 == null) goto L282;
        r129.put("cmd_what_audience_self_join", Boolean.TRUE);
    L282:
        ILinkServiceExternal r130 = jc1.k.f(ILinkServiceExternal.class);
        if (r130 == null) goto L285;
        r130.notifyAudienceSelfJoin(true);
    L285:
        hd0.c.f().k(2);
        LinkPkInteractAudienceWindowManagerV2 r131 = this.t;
        if (r131 == null) goto L288;
        r131.A();
    L288:
        this.U = false;
        this.E = System.currentTimeMillis();
        this.F = System.currentTimeMillis();
        br();
        if (l5() == true) goto L297;
        if (((Boolean) LiveInfraSettingKeys.LIVE_PK_AUDIO_EFFECT_OPT.getValue()).booleanValue() == false) goto L297;
        v0 r132 = this.x;
        if (r132 == null) goto L297;
        com.bytedance.android.live.pushstream.d r133 = r132.getLiveStream();
        if (r133 == null) goto L297;
        r133.f0(false);
        goto L297
    L226:
        r100 = null;
        goto L227
    L158:
        r77 = 0;
        goto L160
    L143:
        if (r61.j != true) goto L151;
        v0 r134 = r61.q;
        this.x = r134;
        if (r134 != null) goto L151;
        if (((Boolean) th0.a.getValue()).booleanValue() == false) goto L151;
        ALogger.e(this.p, "onCreate mInteractVideoView = null");
        com.bytedance.android.live.livepkaudience.rtc.a r135 = this.e;
        if (r135 == null) goto L151;
        r135.j = false;
        goto L151
    L124:
        r56 = false;
    L120:
        r52 = null;
        goto L121
    L113:
        if (HostEnv.a() == true) goto L115;
        com.bytedance.android.livesdk.sharedpref.f.d(r49, Boolean.TRUE);
        goto L115
    L85:
        r41 = null;
        goto L86
    L78:
        r33 = 0;
    L74:
        r29 = "0";
        goto L75
    L20:
        r9 = this;
        goto L21
    L339:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L341:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L6:
        r1 = new Room();
        goto L7
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        Integer r1 = (Integer) r0.get("data_link_state", 0);
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L9:
        if (jc1.k.n(ILinkServiceExternal.class).getPkService().getPkState() != 1) goto L11;
        boolean r3 = true;
    L13:
        if (v.a(r2, 4) == false) goto L30;
        if (r3 == false) goto L33;
        this.q = true;
        com.bytedance.android.live.livepkaudience.rtc.a r4 = this.e;
        if (r4 != null) goto L19;
        return;
    L19:
        if (r4.j != true) goto L32;
        fh0 r5 = fh0.a;
        if (((Boolean) r5.getValue()).booleanValue() == false) goto L24;
        Pq().f();
    L24:
        if (((Boolean) r5.getValue()).booleanValue() == true) goto L26;
    L27:
        Qq("pause", false);
    L28:
        this.J = Observable.timer(this.H, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(this));
        return;
    L26:
        if (Pq().p == true) goto L28;
    L32:
        return;
    L33:
        return;
    L30:
        return;
    L11:
        r3 = false;
    L7:
        r2 = 0;
        goto L9
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        this.q = false;
        Disposable r0 = this.J;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        com.bytedance.android.live.livepkaudience.rtc.a r1 = this.e;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.j != true) goto L24;
        fh0 r2 = fh0.a;
        if (((Boolean) r2.getValue()).booleanValue() == false) goto L13;
        Pq().g();
    L13:
        if (((Boolean) r2.getValue()).booleanValue() == true) goto L15;
    L18:
        Rq("resume");
    L19:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L25;
        r3.put("cmd_interact_state_change", new a1(3));
        return;
    L25:
        return;
    L15:
        if (Pq().p == true) goto L19;
        if (Pq().i == true) goto L19;
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        if (((Boolean) fh0.a.getValue()).booleanValue() == false) goto L6;
        Pq().h();
        return;
    }

    @Override // xk0.b
    public final SurfaceView q1() {
        return yq();
    }

    public static void Iq(LiveDialogFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final void Jq(LinkPkInteractAudienceGuestWidget r1) {
        r1.getClass();
        if (((Boolean) nd1.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (r1.Nq() == 0) goto L22;
        v0 r0 = r1.x;
        if (r0 == null) goto L13;
        com.bytedance.android.live.pushstream.d r2 = r0.getLiveStream();
        if (r2 == null) goto L13;
        d0 r3 = r2.A();
        if (r3 == null) goto L13;
        r3.h();
    L13:
        v0 r4 = r1.x;
        if (r4 == null) goto L23;
        com.bytedance.android.live.pushstream.d r5 = r4.getLiveStream();
        if (r5 == null) goto L24;
        d0 r6 = r5.A();
        if (r6 == null) goto L25;
        r6.h();
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.base.h
    public final void Bg(xe r5) {
        Intrinsics.checkNotNullParameter(r5, MultiLinkOpenSource.MESSAGE);
        super.Bg(r5);
        cl0.a r6 = cl0.a.d;
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r1 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r2 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r1, "callback");
        Intrinsics.checkNotNullParameter(r2, "config");
        r6.c("sense_disconnect_by_other", r0, r1, r2);
    }

    @Override // com.bytedance.android.live.livepkaudience.presenter.a.InterfaceC0115a
    public final void D(String r3) {
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        o0.a r0 = o0.a;
        String r1 = jc1.k.n(IUserService.class).user().b().getIdString();
        r0.getClass();
        if (o0.a.a(r3, r1) == false) goto L11;
        com.bytedance.android.live.livepkaudience.rtc.a r4 = this.e;
        if (r4 == null) goto L8;
        r4.h(false, "onSilenceSuccess");
    L8:
        if (this.r == true) goto L12;
        f2.c(s1.B(2131923166), 0);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.base.h
    public final void Ee(ApplyResult r10) {
        Intrinsics.checkNotNullParameter(r10, "applyResult");
        Intrinsics.checkNotNullParameter(r10, "applyResult");
        this.D = System.currentTimeMillis();
        this.S.a = r10.getAutoJoin();
        com.bytedance.android.live.liveinteract.utils.d r1 = this.S;
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L7;
        Boolean r3 = (Boolean) r2.get("data_link_mic_is_quick_invite", Boolean.FALSE);
        if (r3 == null) goto L7;
        boolean r4 = r3.booleanValue();
    L8:
        r1.h = r4;
        com.bytedance.android.live.livepkaudience.base.i r5 = getLinkUserCenter();
        ICircleInfo r6 = null;
        if (r5 == null) goto L11;
        Integer r7 = Integer.valueOf(com.bytedance.android.live.livepkaudience.emoji.c.a(r5));
    L12:
        String r8 = String.valueOf(r7.intValue());
        if (r8 != null) goto L15;
        r8 = "0";
    L15:
        tc0.c r9 = tc0.c.h();
        if (r10.getSilenceStatus() != 1) goto L18;
        boolean r11 = true;
    L19:
        r9.C = r11;
        int r12 = al0.c.b;
        com.bytedance.android.live.liveinteract.utils.d r13 = this.S;
        Room r14 = this.a;
        if (r14 == null) goto L22;
        ICircleInfo r15 = r14.getCircleInfo();
    L24:
        if ((r15 instanceof CircleInfo) == false) goto L27;
        r6 = r15;
    L27:
        CircleInfo r16 = (CircleInfo) r6;
        Intrinsics.checkNotNullParameter(r10, "applyResult");
        Intrinsics.checkNotNullParameter(r13, "logParams");
        Intrinsics.checkNotNullParameter(r8, "linkCnt");
        HashMap r0 = new HashMap();
        al0.c.a(r0, r13);
        if (r10.getAutoJoin() == false) goto L30;
        String r17 = "0";
    L31:
        r0.put("is_approve_needed", r17);
        if (hd0.c.f().g != 1) goto L34;
        boolean r18 = true;
    L35:
        if (r18 == false) goto L37;
        String r19 = "video";
    L38:
        r0.put("guest_connection_type", r19);
        r0.put("is_full", "0");
        r0.put("connect_type", r13.b);
        r0.put("is_rechargeble", "0");
        String r20 = tc0.c.h().F;
        if (r20 != null) goto L41;
        r20 = "";
    L41:
        r0.put("apply_reason", r20);
        if (r16 == null) goto L46;
        String r21 = r16.getCircleName();
        if (r21 == null) goto L46;
        r0.put("circle_name", r21);
    L46:
        r0.put("link_cnt", r8);
        r0.put("seat_fit_status", "off");
        r0.put("is_pre_link", "0");
        al0.c.b(r0);
        u.l().sendLog("livesdk_guest_connection_apply", r0, new Object[]{Room.class, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        boolean r22 = jc1.k.n(IUserService.class).user().c();
        if (r10.getAutoJoin() == true) goto L54;
        if (r22 == true) goto L55;
        a5 r110 = r10.getDisplayText();
        if (r110 == null) goto L53;
        Zq((Text) r110);
        return;
    L53:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.message.Text");
    L55:
        return;
    L54:
        return;
    L37:
        r19 = "voice";
        goto L38
    L34:
        r18 = false;
        goto L35
    L30:
        r17 = "1";
        goto L31
    L22:
        r15 = null;
        goto L24
    L18:
        r11 = false;
        goto L19
    L11:
        r7 = null;
    L7:
        r4 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget
    public final void F3(String r17) {
        Intrinsics.checkNotNullParameter(r17, "reqFrom");
        if (this.U == true) goto L5;
    L7:
        lc0.d r12 = jc1.k.n(ILinkServiceExternal.class).getPkServiceExternal();
        r12.c(this.b1);
        r12.f(this.g1);
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L10;
        r1.put("data_link_mic_is_quick_invite", Boolean.FALSE);
    L10:
        com.bytedance.android.live.liveinteract.utils.d r3 = this.S;
        r3.i = this.W.b;
        int r2 = al0.c.b;
        Room r4 = this.u;
        long r5 = this.E;
        v0 r6 = this.x;
        if ((r6 instanceof m00.g) == true) goto L13;
        r6 = null;
    L13:
        m00.g r7 = (m00.g) r6;
        if (r7 == null) goto L16;
        long r8 = r7.b();
    L17:
        al0.c.g(r4, r17, r3, r5, r8, l5(), Long.valueOf((this.E - this.D) / ((long) 1000)));
        if (r12.d() != RevPkState.PK) goto L20;
        boolean r9 = true;
    L21:
        Tq(r9, true);
        super.F3(r17);
        LinkPkInteractAudienceWindowManagerV2 r10 = this.t;
        if (r10 == null) goto L25;
        r10.B();
        return;
    L25:
        return;
    L20:
        r9 = false;
        goto L21
    L16:
        r8 = 0;
        goto L17
    L5:
        if ((!Intrinsics.areEqual(r17, "force")) == false) goto L7;
    }

    @Override // com.bytedance.android.live.livepkaudience.presenter.a.InterfaceC0115a
    public final void G(String r3) {
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        o0.a r0 = o0.a;
        String r1 = jc1.k.n(IUserService.class).user().b().getIdString();
        r0.getClass();
        if (o0.a.a(r3, r1) == false) goto L12;
        com.bytedance.android.live.livepkaudience.rtc.a r4 = this.e;
        if (r4 == null) goto L8;
        r4.h(true, "onUnSilenceSuccess");
    L8:
        if (this.r == true) goto L10;
        f2.c(s1.B(2131923173), 0);
    L10:
        this.r = false;
        return;
    }

    public final void Mq(String r9) {
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r0 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getSelfAnchorLinkMicId();
    L6:
        String r3 = "";
        if (TextUtils.isEmpty(r2) == false) goto L24;
        com.bytedance.android.live.livepkaudience.base.i r4 = getLinkUserCenter();
        if ((r4 instanceof com.bytedance.android.live.livepkaudience.base.i) == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L20;
        Room r5 = this.u;
        if (r5 == null) goto L18;
        User r6 = r5.getOwner();
        if (r6 == null) goto L18;
        String r7 = r6.getIdStr();
        if (r7 == null) goto L18;
    L19:
        r2 = r4.m(r7);
    L21:
        LinkPkInteractGuestDataContext r8 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r8 == null) goto L24;
        r8.setSelfAnchorLinkMicId(r2);
    L18:
        r7 = "0";
        goto L19
    L20:
        r2 = "";
    L24:
        long r10 = hd0.c.f().e;
        if (TextUtils.equals(r9, r2) == true) goto L27;
    L29:
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L34;
        Boolean r12 = (Boolean) r11.get("data_pk_anchor_silence_status_change", Boolean.FALSE);
        if (r12 == null) goto L34;
        boolean r13 = r12.booleanValue();
    L35:
        com.bytedance.android.live.livepkaudience.base.i r14 = getLinkUserCenter();
        if ((r14 instanceof com.bytedance.android.live.livepkaudience.base.i) == true) goto L39;
        r14 = null;
    L39:
        if (r14 == null) goto L43;
        if (r14.v(r9) != true) goto L43;
    L44:
        com.bytedance.android.live.livepkaudience.rtc.a r15 = this.e;
        if (r15 == null) goto L50;
        if (r9 != null) goto L48;
        String r16 = "";
    L49:
        r15.c(r16, r13);
        goto L50
    L48:
        r16 = r9;
    L50:
        StringBuilder r17 = new StringBuilder("doMuteOperation audienceLinkMicId = ");
        LinkPkInteractGuestDataContext r18 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r18 == null) goto L53;
        r1 = r18.getAudienceSelfLinkMicId();
    L53:
        r17.append(r1);
        r17.append(", linkId = ");
        r17.append(r9);
        r17.append(", anchorInteractId = ");
        r17.append(r2);
        r17.append(", isMute = ");
        r17.append(r13);
        r17.append(", guestLinkMicId = ");
        LinkPkInteractGuestDataContext r19 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r19 == null) goto L59;
        String r20 = r19.getGuestAnchorLinkMicId();
        if (r20 == null) goto L59;
        r3 = r20;
    L59:
        r17.append(r3);
        String r21 = r17.toString();
        ALogger.i(this.p, r21);
        dl0.m r22 = dl0.m.a;
        String r23 = this.p + "_doMuteOperation";
        r22.getClass();
        dl0.m.C(r23, r21);
        if (this.q == false) goto L82;
        com.bytedance.android.live.livepkaudience.rtc.a r24 = this.e;
        if (r24 != null) goto L64;
        return;
    L64:
        if (r24.j == true) goto L66;
        return;
    L66:
        if (Nq() != 0) goto L73;
        com.bytedance.android.live.livepkaudience.rtc.a r25 = this.e;
        if (r25 == null) goto L73;
        if (r25.j == false) goto L73;
        r25.h(false, "GuestRtcManager onPause");
    L73:
        if (this.f == true) goto L75;
        getLinkUserCenter().B();
    L75:
        v0 r26 = this.x;
        if (r26 == null) goto L80;
        d0 r27 = r26.A();
        if (r27 == null) goto L80;
        r27.d();
    L80:
        this.J = Observable.timer(this.H, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this));
        return;
    L82:
        return;
    L43:
        if (TextUtils.equals(r9, this.L0.y()) == false) goto L50;
    L34:
        r13 = false;
        goto L35
    L27:
        if (r10 <= 0) goto L29;
        hd0.c.f().e = 0;
        goto L29
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.base.h
    public final void Pb(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        hd0.c.f().k(0);
        tc0.c.h().F = "";
        if (Intrinsics.areEqual(r4, "paid_change") == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r4, "low_balance_for_paid_link") == true) goto L10;
        f2.b(2131918112, 0);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.base.h
    public final void Q2(Throwable r10) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.put("data_link_mic_is_quick_invite", Boolean.FALSE);
    L6:
        if ((r10 instanceof ApiServerException) == false) goto L51;
        ApiServerException r11 = (ApiServerException) r10;
        if (r11.getErrorCode() != 4004090) goto L16;
        IInteractService r1 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r1 == null) goto L16;
        if (r1.getLinkMultiOutService() == null) goto L16;
        com.bytedance.android.live.liveinteract.plantform.base.g r2 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r2 == null) goto L16;
        r2.Nf();
    L16:
        com.bytedance.android.live.livepkaudience.base.i r3 = getLinkUserCenter();
        ICircleInfo r4 = null;
        if (r3 == null) goto L19;
        Integer r5 = Integer.valueOf(com.bytedance.android.live.livepkaudience.emoji.c.a(r3));
    L20:
        String r6 = String.valueOf(r5.intValue());
        if (r6 != null) goto L23;
        r6 = "0";
    L23:
        int r7 = al0.c.b;
        com.bytedance.android.live.liveinteract.utils.d r8 = this.S;
        Room r9 = this.a;
        if (r9 == null) goto L26;
        ICircleInfo r12 = r9.getCircleInfo();
    L28:
        if ((r12 instanceof CircleInfo) == false) goto L31;
        r4 = r12;
    L31:
        CircleInfo r13 = (CircleInfo) r4;
        Intrinsics.checkNotNullParameter(r11, "throwable");
        Intrinsics.checkNotNullParameter(r8, "logParams");
        Intrinsics.checkNotNullParameter(r6, "linkCnt");
        HashMap r14 = new HashMap();
        al0.c.a(r14, r8);
        if (hd0.c.f().g != 1) goto L34;
        boolean r15 = true;
    L35:
        if (r15 == false) goto L37;
        String r16 = "video";
    L38:
        r14.put("guest_connection_type", r16);
        if (r11.getErrorCode() != 31101) goto L41;
        r14.put("is_full", "1");
    L42:
        r14.put("connect_type", r8.b);
        r14.put("is_rechargeble", "0");
        String r17 = tc0.c.h().F;
        if (r17 != null) goto L45;
        r17 = "";
    L45:
        r14.put("apply_reason", r17);
        if (r13 == null) goto L50;
        String r18 = r13.getCircleName();
        if (r18 == null) goto L50;
        r14.put("circle_name", r18);
    L50:
        r14.put("link_cnt", r6);
        r14.put("seat_fit_status", "off");
        r14.put("is_pre_link", "0");
        al0.c.b(r14);
        u.l().sendLog("livesdk_guest_connection_apply", r14, new Object[]{Room.class, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L41:
        r14.put("is_full", "0");
        goto L42
    L37:
        r16 = "voice";
        goto L38
    L34:
        r15 = false;
        goto L35
    L26:
        r12 = null;
        goto L28
    L19:
        r5 = null;
        goto L20
    L51:
        f2.b(2131919229, 0);
    }

    public final void Rq(String r3) {
        getLinkUserCenter().C();
        if (Nq() != 3) goto L17;
        com.bytedance.android.live.livepkaudience.rtc.a r4 = this.e;
        if (r4 != null) goto L7;
    L9:
        FragmentActivity r5 = ((Widget) this).context;
        if (r5 == null) goto L17;
        if (r5.isFinishing() == true) goto L17;
        this.r = false;
        com.bytedance.android.live.livepkaudience.presenter.a r6 = this.Z;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mAudioManagerPresenter");
    L16:
        r6.e0(jc1.k.n(IUserService.class).user().b().getIdString());
        goto L17
    L7:
        if (r4.j == false) goto L9;
        r4.h(true, "GuestRtcManager onResume");
    L17:
        v0 r7 = this.x;
        if (r7 == null) goto L23;
        d0 r8 = r7.A();
        if (r8 == null) goto L24;
        r8.e();
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.base.h
    public final void Yn(xe r3) {
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        hd0.c r0 = hd0.c.f();
        r0.g = r3.getLinkType();
        super.Yn(r3);
    }

    public final void Yq(boolean r14) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (((Widget) this).context == null) goto L123;
        boolean r1 = false;
        if (dl0.k.a() == false) goto L11;
        f2.c(s1.B(2131917793), 0);
        return;
    L11:
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L14;
        int r2 = r0.getLinkMode();
    L16:
        if (v.a(r2, 2) == false) goto L20;
        f2.c(s1.B(2131915438), 0);
        return;
    L20:
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L27;
        com.bytedance.android.livesdk.user.f r15 = jc1.k.n(IUserService.class).user();
        Context r3 = ((Widget) this).context;
        com.bytedance.android.livesdk.user.l.a r4 = new com.bytedance.android.livesdk.user.l.a();
        r4.a = s1.B(2131919339);
        r4.d = "interact";
        r4.c = 0;
        Observable r16 = r15.login(r3, new com.bytedance.android.livesdk.user.l(r4));
        if (r16 == null) goto L113;
        Observable r17 = r16.compose(getAutoUnbindTransformer());
        if (r17 == null) goto L114;
        r17.subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L114:
        return;
    L113:
        return;
    L27:
        Integer r5 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r14 == false) goto L41;
        Room r18 = this.u;
        if (r18 == null) goto L32;
        LiveMode r19 = r18.getStreamType();
    L34:
        if (r19 != LiveMode.THIRD_PARTY) goto L41;
        if (r5 == null) goto L41;
        if (r5.intValue() != 0) goto L41;
        qj0.b.a r110 = new qj0.b.a(getContext());
        r110.a = s1.B(2131917799);
        r110.b = s1.B(2131917796);
        String r6 = s1.B(2131917797);
        r110.c = i.a;
        r110.d = r6;
        String r7 = s1.B(2131917798);
        r110.e = new j(this);
        r110.f = r7;
        r110.a();
        return;
    L32:
        r19 = null;
    L41:
        int r111 = al0.c.b;
        Intrinsics.checkNotNullParameter("livesdk_audience_interaction_icon_click", "eventName");
        RoomContext.a r8 = RoomContext.Companion;
        RoomContext r9 = RoomContext.a.c(r8, null, 0, 3);
        if (r9 == null) goto L46;
        com.bytedance.live.datacontext.m r10 = r9.getRoom();
        if (r10 == null) goto L46;
        Room r11 = (Room) r10.getValue();
    L47:
        HashMap r12 = new HashMap();
        r12.put("channel_id", String.valueOf(dl0.p.a().getChannelId()));
        al0.c.b(r12);
        String r13 = "0";
        if (r11 == null) goto L51;
        String r112 = r11.getOwnerUserIdString();
        if (r112 == null) goto L51;
    L52:
        r12.put("anchor_id", r112);
        if (r11 == null) goto L58;
        String r20 = String.valueOf(r11.id);
        if (r20 == null) goto L58;
        r13 = r20;
    L58:
        r12.put("room_id", r13);
        RoomContext r21 = RoomContext.a.c(r8, null, 0, 3);
        if (r21 == null) goto L63;
        com.bytedance.live.datacontext.m r22 = r21.getRoom();
        if (r22 == null) goto L63;
        Room r23 = (Room) r22.getValue();
    L64:
        r12.put("user_id", jc1.k.n(IUserService.class).user().n());
        if (r23 == null) goto L68;
        String r24 = r23.getRequestId();
        if (r24 == null) goto L68;
    L69:
        r12.put("request_id", r24);
        u.l().sendLog("livesdk_audience_interaction_icon_click", r12, new Object[]{Room.class, x.class});
        DataCenter r113 = ((Widget) this).dataCenter;
        if (r113 == null) goto L72;
        r113.put("data_link_pk_interact_show_red_dot", Boolean.TRUE);
    L72:
        tc0.c.h().G = "bottom";
        if (HostEnv.b() == false) goto L75;
    L78:
        r1 = true;
    L79:
        int r114 = sj1.d(1, r1);
        if (r5 != null) goto L83;
    L88:
        if (r5 != null) goto L91;
    L95:
        if (r5 != null) goto L98;
    L100:
        Context r115 = getContext();
        if (r115 == null) goto L120;
        DataCenter r25 = ((Widget) this).dataCenter;
        if (r25 == null) goto L121;
        int r26 = LinkPKAudienceInteractDynamicEmojiDialog.D;
        LinkPKAudienceInteractDynamicEmojiDialog r116 = LinkPKAudienceInteractDynamicEmojiDialog.a.a(r115, r25);
        if (DialogLancet.shouldBlockDialogShow(r116) == false) goto L111;
        DialogLancet.handleBlockedDialogShow(r116);
        return;
    L111:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L110
    L108:
        DialogLancet.beforeDialogShow(r116);
        r116.show();
        DialogLancet.afterDialogShow(r116);
        return;
    L121:
        return;
    L120:
        return;
    L98:
        if (1 != r5.intValue()) goto L100;
        Zq(null);
        return;
    L91:
        if (1 != r5.intValue()) goto L95;
        if (Kq() == false) goto L95;
        ar(null);
        return;
    L83:
        if (r5.intValue() != 0) goto L88;
        hd0.c.f().g = r114;
        if (Kq() == false) goto L87;
        wq(OperateType.PRE_APPLY, 1, new com.bytedance.android.live.livepkaudience.base.c(this));
        return;
    L87:
        int r27 = bh0.a.a;
        com.bytedance.android.live.livepkaudience.service.d.b.a(this, r114, 102, "interact_icon_click");
        return;
    L75:
        if (HostEnv.c() == true) goto L78;
        if (HostEnv.a() == false) goto L79;
    L68:
        r24 = "";
    L63:
        r23 = null;
    L51:
        r112 = "0";
    L46:
        r11 = null;
        goto L47
    L14:
        r2 = 0;
        goto L16
    }

    public final void Zq(Text r4) {
        if (r4 == null) goto L6;
        PkGuestApplyDialog r0 = this.P;
        if (r0 == null) goto L6;
        r0.T90(r4);
    L6:
        PkGuestApplyDialog r5 = this.P;
        if (r5 != null) goto L9;
    L11:
        int r6 = PkGuestApplyDialog.t;
        Room r7 = this.a;
        PkGuestApplyDialog r1 = new PkGuestApplyDialog();
        r1.d = r7;
        this.P = r1;
        Context r8 = ((Widget) this).context;
        int r2 = el0.j.b;
        int r3 = bh0.a.a;
        Intrinsics.checkNotNullParameter(r8, "context");
        if (r1.isShowing() == false) goto L14;
        return;
    L14:
        if (r1.o == true) goto L29;
        r1.o = true;
        r1.p = "bottom";
        FragmentActivity r9 = ContextUtil.contextToFragmentActivity(r8);
        if (r9 == null) goto L30;
        FragmentManager r10 = r9.getSupportFragmentManager();
        if (r10 == null) goto L31;
        LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "PkGuestApplyDialog", r11);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, r1, r11) == true) goto L32;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L23:
        r1.show(r10, "PkGuestApplyDialog");
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L9:
        if (r5.isShowing() != true) goto L11;
    }

    public final void ar(Text r7) {
        if (r7 == null) goto L6;
        PkAudiencePreApplyDialog r0 = this.Q;
        if (r0 == null) goto L6;
        r0.S90(r7);
    L6:
        PkAudiencePreApplyDialog r8 = this.Q;
        if (r8 != null) goto L9;
    L11:
        int r9 = PkAudiencePreApplyDialog.t;
        Room r10 = this.a;
        DataCenter r1 = ((Widget) this).dataCenter;
        PkAudiencePreApplyDialog r2 = new PkAudiencePreApplyDialog();
        r2.d = r10;
        r2.e = r1;
        RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        this.Q = r2;
        Context r11 = ((Widget) this).context;
        Intrinsics.checkNotNullParameter(r11, "context");
        if (r2.isShowing() == false) goto L14;
        return;
    L14:
        if (r2.r == true) goto L29;
        r2.r = true;
        FragmentActivity r12 = ContextUtil.contextToFragmentActivity(r11);
        if (r12 == null) goto L30;
        FragmentManager r13 = r12.getSupportFragmentManager();
        if (r13 == null) goto L31;
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "PkAudiencePreApplyDialog", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r2, r3) == true) goto L32;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L23:
        r2.show(r13, "PkAudiencePreApplyDialog");
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L9:
        if (r8.isShowing() != true) goto L11;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.base.h
    public final void b1(Throwable r2) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if ((r2 instanceof ApiServerException) == true) goto L9;
        ExceptionUtils.handleException(((Widget) this).context, r2);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.base.h
    public final void b2(com.bytedance.android.live.network.response.e<JoinChannelResult> r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        super.b2(r5);
        LinkPkSwitchCameraManager r6 = this.R;
        if (r6 == null) goto L5;
        r6.f = false;
    L5:
        q r7 = this.b;
        if (r7 == null) goto L16;
        MultiLiveCoreInfo r8 = r7.m;
        if (r8 == null) goto L16;
        MultiAnchorLinkmicLiveCoreInfo r9 = r8.multiAnchorLiveCoreInfo;
        if (r9 == null) goto L16;
        Map r10 = r9.liveCoreExtInfoMap;
        if (r10 == null) goto L16;
        com.bytedance.android.live.livepkaudience.rtc.a r2 = this.e;
        if (r2 == null) goto L16;
        com.bytedance.android.live.livepkaudience.rtc.a.i(r2, (String) r10.get(3L));
    L16:
        q r11 = this.b;
        if (r11 == null) goto L28;
        MultiRtcInfo r12 = r11.n;
        if (r12 == null) goto L29;
        MultiAnchorLinkmicRtcInfo r13 = r12.mMultiAnchorLinkmicRtcInfo;
        if (r13 == null) goto L30;
        Map r14 = r13.rtcInfoMap;
        if (r14 == null) goto L31;
        com.bytedance.android.live.livepkaudience.rtc.a r3 = this.e;
        if (r3 == null) goto L32;
        com.bytedance.android.live.livepkaudience.rtc.a.j(r3, (String) r14.get(3L));
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.a
    public final void b5(String r3) {
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        com.bytedance.android.live.livepkaudience.presenter.a r0 = this.Z;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAudioManagerPresenter");
    L5:
        if (r0 == null) goto L8;
        r0.e0(r3);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.base.h
    public final void bn(xe r7) {
        Intrinsics.checkNotNullParameter(r7, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r7, MultiLinkOpenSource.MESSAGE);
        this.D = System.currentTimeMillis();
        if (rf2.a.a() == false) goto L5;
        return;
    L5:
        LiveDialogFragment r0 = this.Y;
        if (r0 == null) goto L11;
        if (r0.isShowing() != true) goto L11;
        return;
    L11:
        if (r7.getMessageBoardInfo() == null) goto L13;
        com.bytedance.android.live.liveinteract.utils.d r1 = this.S;
        r1.getClass();
        Intrinsics.checkNotNullParameter("gift_message_invite", "<set-?>");
        r1.b = "gift_message_invite";
        this.S.k = r7.getMessageBoardInfo();
    L14:
        com.bytedance.android.live.liveinteract.utils.d r2 = this.S;
        String r3 = r7.getFromUserIdStr();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.c = r3;
        PkAudienceGuestInviteDialog r4 = this.v;
        if (r4 != null) goto L17;
    L19:
        int r5 = al0.c.b;
        MessageBoardInfo r6 = r7.getMessageBoardInfo();
        if ((r6 instanceof MessageBoardInfo) == true) goto L22;
        r6 = null;
    L22:
        HashMap r8 = new HashMap();
        r8.put("function_type", al0.c.e());
        if (hd0.c.f().g != 1) goto L25;
        String r9 = "video";
    L26:
        r8.put("guest_connection_type", r9);
        if (r6 == null) goto L29;
        r8.put("request_page", "gift_message_panel");
        r8.put("message_text", f0.a(r6));
    L29:
        al0.c.b(r8);
        u.l().sendLog("livesdk_guest_connection_invited", r8, new Object[]{Room.class, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        int r10 = PkAudienceGuestInviteDialog.m;
        Room r11 = this.a;
        Intrinsics.checkNotNullParameter(r7, "msg");
        PkAudienceGuestInviteDialog r12 = new PkAudienceGuestInviteDialog();
        r12.i = r11;
        r12.j = r7;
        this.v = r12;
        FragmentActivity r13 = ContextUtil.contextToFragmentActivity(getContext());
        if (r13 == null) goto L44;
        FragmentManager r14 = r13.getSupportFragmentManager();
        if (r14 == null) goto L45;
        PkAudienceGuestInviteDialog r15 = this.v;
        if (r15 == null) goto L46;
        LandscapeRestrictionOperation r16 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r15, "InteractAudienceInvitedDialog", r16);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r14, r15, r16) == true) goto L47;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41
    L39:
        r15.show(r14, "InteractAudienceInvitedDialog");
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L25:
        r9 = "audio";
        goto L26
    L17:
        if (r4.isShowing() == false) goto L19;
        Iq(r4);
        goto L19
    L13:
        com.bytedance.android.live.liveinteract.utils.d r17 = this.S;
        r17.getClass();
        Intrinsics.checkNotNullParameter("invite", "<set-?>");
        r17.b = "invite";
        goto L14
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.base.h
    public final void c0(Throwable r3) {
        Aq();
        if (Intrinsics.areEqual(this.h, "live_end") == false) goto L5;
        cl0.a.f(cl0.a.d);
    L5:
        ExceptionUtils.handleException(getContext(), r3, 2131919396);
    }

    @Override // com.bytedance.android.live.livepkaudience.service.d
    public final void disconnect(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        if (Intrinsics.areEqual(r4, "force") == false) goto L6;
        F3(r4);
        return;
    L6:
        Room r5 = this.u;
        if (r5 == null) goto L9;
        User r6 = r5.getOwner();
    L10:
        j0.a r0 = new j0.a(((Widget) this).context);
        Object[] r1 = new Object[1];
        if (r6 == null) goto L13;
        String r7 = r6.getNickName();
    L14:
        r1[0] = r7;
        r0.a = s1.C(2131917528, r1);
        r0.b(s1.B(2131916227), new c(this));
        r0.a(s1.B(2131915442), d.a);
        r0.c();
        return;
    L13:
        r7 = "";
        goto L14
    L9:
        r6 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.base.h
    public final void m0(Throwable r2) {
        super.m0(r2);
        ExceptionUtils.handleException(((Widget) this).context, r2);
    }

    public final void onChanged(Object r8) {
        KVData r9 = (KVData) r8;
        if (r9 == null) goto L56;
        String r0 = r9.getKey();
        int r1 = r0.hashCode();
        if (r1 == 725404490) goto L42;
        if (r1 == 872172481) goto L10;
        return;
    L10:
        if (r0.equals("data_link_state") == false) goto L57;
        Integer r10 = (Integer) r9.getData();
        if (r10 != null) goto L14;
        r10 = 0;
    L14:
        int r11 = r10.intValue();
        boolean r2 = this.L;
        if (r2 == false) goto L17;
    L19:
        if (r2 == true) goto L21;
        return;
    L21:
        if (v.a(r11, 2) == false) goto L23;
        return;
    L23:
        if (v.a(r11, 32) == true) goto L61;
        int r12 = al0.c.b;
        long r3 = this.K;
        Room r13 = this.u;
        CircleInfo r4 = null;
        if (r13 == null) goto L27;
        ICircleInfo r14 = r13.getCircleInfo();
    L29:
        if ((r14 instanceof CircleInfo) == true) goto L31;
        r14 = null;
    L31:
        CircleInfo r15 = (CircleInfo) r14;
        if (r15 == null) goto L35;
        r4 = r15;
    L35:
        al0.c.f(r3, r4);
        this.L = false;
        al0.a r16 = this.X;
        if (r16 != null) goto L38;
        return;
    L38:
        if (r16.b <= 0) goto L40;
        r16.a();
    L40:
        r16.b = 0;
        return;
    L27:
        r14 = null;
        goto L29
    L61:
        return;
    L17:
        if (this.M == 0) goto L19;
        Sq();
        this.X = new al0.a(getLinkUserCenter());
        return;
    L57:
        return;
    L42:
        if (r0.equals("data_observe_pk_id_start") == false) goto L64;
        long r5 = this.L0.getPkId();
        this.M = r5;
        el0.j.a = r5;
        al0.c.a = r5;
        if (this.N == true) goto L49;
        if (r5 == 0) goto L49;
        Sq();
        this.N = true;
    L49:
        if (this.O == false) goto L51;
        return;
    L51:
        if (this.M != 0) goto L53;
        return;
    L53:
        if (hd0.c.f().h() == false) goto L67;
        al0.c.h(this.u, this.S, true);
        this.O = true;
        return;
    L67:
        return;
    L64:
        return;
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r3);
        LinkPkInteractAudienceWindowManagerV2 r0 = this.t;
        if (r0 == null) goto L15;
        Intrinsics.checkNotNullParameter(r3, "config");
        int r4 = r3.orientation;
        if (r4 != (-1)) goto L10;
        if (e5.n() == false) goto L11;
    L12:
        boolean r5 = false;
    L13:
        r0.r = r5;
        return;
    L11:
        r5 = true;
        goto L13
    L10:
        if (e5.o(r4) == true) goto L12;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onMessage(tlc.d r23) {
        if (r23 != null) goto L5;
        return;
    L5:
        boolean r3 = false;
        int r4 = 0;
        boolean r5 = false;
        r5 = false;
        boolean r6 = false;
        r6 = false;
        r3 = false;
        long r7 = 0;
        LinkerBattleConnectContent r8 = null;
        if ((r23 instanceof LinkMicGuideMessage) == false) goto L32;
        LinkMicGuideMessage r1 = (LinkMicGuideMessage) r23;
        if (r1.guidelineType != 12) goto L406;
        LinkMicGuideMessage.d r2 = r1.pkLinkBubbleContent;
        if (r2 == null) goto L12;
        String r9 = r2.toast;
    L13:
        IUserService r10 = jc1.k.f(IUserService.class);
        if (r10 == null) goto L18;
        com.bytedance.android.livesdk.user.f r11 = r10.user();
        if (r11 == null) goto L18;
        r8 = r11.n();
    L18:
        String r12 = this.I + r8;
        long r20 = System.currentTimeMillis();
        com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.b.f;
        Long r14 = (Long) ((Map) r13.getValue()).get(r12);
        if (r14 == null) goto L21;
        r7 = r14.longValue();
    L21:
        com.bytedance.android.livesdk.sharedpref.e r15 = com.bytedance.android.livesdk.sharedpref.b.d;
        Integer r16 = (Integer) ((Map) r15.getValue()).get(r12);
        if (r16 == null) goto L24;
        r4 = r16.intValue();
    L24:
        long r17 = 86400000;
        if (((r20 / r17) - (r7 / r17)) >= 1) goto L27;
        return;
    L27:
        if (r4 > 2) goto L443;
        if (r9 == null) goto L408;
        pp1.c r18 = new pp1.c(r9, null, null, 0, null, null, 0, 0, null, 0, 8190);
        ((Map) r13.getValue()).put(r12, Long.valueOf(r20));
        ((Map) r15.getValue()).put(r12, Integer.valueOf(r4 + 1));
        y3.m(((Widget) this).dataCenter).b(ToolbarButton.INTERACTION, r18);
        return;
    L408:
        return;
    L443:
        return;
    L12:
        r9 = null;
        goto L13
    L406:
        return;
    L32:
        if ((r23 instanceof if) == false) goto L331;
        if r19 = (if) r23;
        if (r19.getMType() != 6) goto L129;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r21 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r21 == null) goto L38;
        String r22 = r21.getAudienceSelfLinkMicId();
    L40:
        if (TextUtils.isEmpty(r22) == false) goto L42;
        return;
    L42:
        String r24 = this.p;
        StringBuilder r25 = new StringBuilder("onMessage LINKER_ENTER content = ");
        LinkerEnterContent r110 = r19.mEnter;
        if (r110 == null) goto L45;
        String r111 = r110.toString();
    L46:
        r25.append(r111);
        ALogger.i(r24, r25.toString());
        LinkerEnterContent r26 = r19.mEnter;
        if (r26 == null) goto L410;
        Map r27 = r26.getMLinkerContentMap();
        if (r27 == null) goto L411;
        User r28 = jc1.k.n(ILinkServiceExternal.class).getPkService().C();
        if (r28 == null) goto L55;
        py.o r29 = r28.getOwnRoom();
        if (r29 == null) goto L55;
        List r30 = r29.getRoomIdList();
    L57:
        if (Lists.isEmpty(r30) == false) goto L59;
        r8 = 0L;
    L65:
        if (r8 != null) goto L68;
    L69:
        if (r8 != null) goto L76;
    L71:
        if (r27.keySet() == null) goto L76;
        if (r27.keySet().isEmpty() == true) goto L76;
        r8 = (Long) CollectionsKt.first(r27.keySet());
    L76:
        if ((!r27.isEmpty()) == false) goto L412;
        RoomLinkerContent r31 = (RoomLinkerContent) r27.get(r8);
        if (r31 != null) goto L80;
    L82:
        boolean r32 = false;
    L83:
        DataCenter r33 = ((Widget) this).dataCenter;
        if (r33 == null) goto L86;
        r33.put("data_pk_anchor_silence_status_change", Boolean.valueOf(r32));
    L86:
        ILinkServiceExternal r34 = jc1.k.f(ILinkServiceExternal.class);
        if (r34 == null) goto L89;
        r34.notifyPkAnchorSilenceStatus(r32);
    L89:
        DataCenter r35 = ((Widget) this).dataCenter;
        if (r35 == null) goto L98;
        RoomLinkerContent r36 = (RoomLinkerContent) r27.get(r8);
        if (r36 != null) goto L94;
    L96:
        boolean r37 = false;
    L97:
        r35.put("data_pk_anchor_leave_status_change", Boolean.valueOf(r37));
        goto L98
    L94:
        if (r36.mIsGuestAnchorBackground != 0) goto L96;
        r37 = true;
    L98:
        ILinkServiceExternal r38 = jc1.k.f(ILinkServiceExternal.class);
        if (r38 == null) goto L108;
        lc0.d r39 = r38.getPkService();
        if (r39 == null) goto L108;
        RoomLinkerContent r40 = (RoomLinkerContent) r27.get(r8);
        if (r40 != null) goto L105;
    L107:
        r39.B(r5);
        goto L108
    L105:
        if (r40.mIsGuestAnchorBackground != 0) goto L107;
        r5 = true;
    L108:
        String r41 = this.L0.y();
        if (TextUtils.isEmpty(r41) == true) goto L113;
        com.bytedance.android.live.livepkaudience.rtc.a r42 = this.e;
        if (r42 == null) goto L113;
        Intrinsics.checkNotNull(r41);
        r42.c(r41, r32);
    L113:
        RoomLinkerContent r43 = (RoomLinkerContent) r27.get(r8);
        if (r43 == null) goto L413;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r44 = r43.linkedUsers;
        if (r44 == null) goto L414;
        Iterator<T> r45 = r44.iterator();
    L119:
        if (r45.hasNext() == false) goto L444;
        com.bytedance.android.livesdk.link.model.bridge.k r46 = (com.bytedance.android.livesdk.link.model.bridge.k) r45.next();
        if ((!Intrinsics.areEqual(r46.getInteractId(), r41)) == false) goto L119;
        com.bytedance.android.live.livepkaudience.rtc.a r47 = this.e;
        if (r47 == null) goto L119;
        String r48 = r46.getInteractId();
        if (r48 != null) goto L127;
        r48 = "";
    L127:
        r47.c(r48, r32);
        goto L119
    L444:
        return;
    L414:
        return;
    L413:
        return;
    L80:
        if (r31.getRoomLinkSilenceStatus() != 1) goto L82;
        r32 = true;
        goto L83
    L412:
        return;
    L68:
        if (r8.longValue() == 0) goto L71;
    L59:
        if (r28 == null) goto L65;
        py.o r49 = r28.getOwnRoom();
        if (r49 == null) goto L65;
        List r50 = r49.getRoomIdList();
        if (r50 == null) goto L65;
        r8 = (Long) ListProtector.get(r50, 0);
    L55:
        r30 = null;
        goto L57
    L411:
        return;
    L410:
        return;
    L45:
        r111 = null;
        goto L46
    L38:
        r22 = null;
        goto L40
    L129:
        if (r19.getMType() != 11) goto L202;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r51 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r51 == null) goto L133;
        String r52 = r51.getAudienceSelfLinkMicId();
    L135:
        if (TextUtils.isEmpty(r52) == false) goto L137;
        return;
    L137:
        String r53 = this.p;
        StringBuilder r54 = new StringBuilder("onMessage LINKER_LINKED_CHANGE content = ");
        ILinkerLinkedListChangeContent r55 = r19.getMLinkedListChange();
        if (r55 == null) goto L140;
        String r56 = r55.toString();
    L141:
        r54.append(r56);
        ALogger.i(r53, r54.toString());
        ILinkerLinkedListChangeContent r57 = r19.getMLinkedListChange();
        if (r57 == null) goto L415;
        Map r58 = r57.getLinkerContentMap();
        if (r58 == null) goto L416;
        User r59 = jc1.k.n(ILinkServiceExternal.class).getPkService().C();
        if (r59 == null) goto L150;
        py.o r60 = r59.getOwnRoom();
        if (r60 == null) goto L150;
        List r61 = r60.getRoomIdList();
    L152:
        if (Lists.isEmpty(r61) == false) goto L154;
        r8 = 0L;
    L160:
        if (r8 != null) goto L163;
    L164:
        if (r8 == null) goto L166;
    L170:
        g2 r62 = (g2) r58.get(r8);
        if (r62 != null) goto L173;
    L175:
        DataCenter r63 = ((Widget) this).dataCenter;
        if (r63 == null) goto L178;
        r63.put("data_pk_anchor_silence_status_change", Boolean.valueOf(r6));
    L178:
        ILinkServiceExternal r65 = jc1.k.f(ILinkServiceExternal.class);
        if (r65 == null) goto L181;
        r65.notifyPkAnchorSilenceStatus(r6);
    L181:
        String r66 = this.L0.y();
        if (TextUtils.isEmpty(r66) == true) goto L186;
        com.bytedance.android.live.livepkaudience.rtc.a r67 = this.e;
        if (r67 == null) goto L186;
        Intrinsics.checkNotNull(r66);
        r67.c(r66, r6);
    L186:
        g2 r68 = (g2) r58.get(r8);
        if (r68 == null) goto L417;
        List r69 = r68.getLinkedUsers();
        if (r69 == null) goto L418;
        Iterator r70 = r69.iterator();
    L192:
        if (r70.hasNext() == false) goto L445;
        com.bytedance.android.livesdk.link.model.bridge.k r71 = (com.bytedance.android.livesdk.link.model.bridge.k) r70.next();
        if ((!Intrinsics.areEqual(r71.getInteractId(), r66)) == false) goto L192;
        com.bytedance.android.live.livepkaudience.rtc.a r72 = this.e;
        if (r72 == null) goto L192;
        String r73 = r71.getInteractId();
        if (r73 != null) goto L200;
        r73 = "";
    L200:
        r72.c(r73, r6);
        goto L192
    L445:
        return;
    L418:
        return;
    L417:
        return;
    L173:
        if (r62.getRoomLinkSilenceStatus() != 1) goto L175;
        r6 = true;
    L166:
        if (r58.keySet() == null) goto L170;
        if (r58.keySet().isEmpty() == true) goto L170;
        r8 = (Long) CollectionsKt.first(r58.keySet());
        goto L170
    L163:
        if (r8.longValue() == 0) goto L166;
    L154:
        if (r59 == null) goto L160;
        py.o r74 = r59.getOwnRoom();
        if (r74 == null) goto L160;
        List r75 = r74.getRoomIdList();
        if (r75 == null) goto L160;
        r8 = (Long) ListProtector.get(r75, 0);
    L150:
        r61 = null;
        goto L152
    L416:
        return;
    L415:
        return;
    L140:
        r56 = null;
        goto L141
    L133:
        r52 = null;
        goto L135
    L202:
        if (r19.getMType() != 41) goto L280;
        LinkRoomFightUpdateContent r76 = r19.linkerCrossRoomUpdateContent;
        if (r76 == null) goto L419;
        Map r77 = r76.getLinkerContentMap();
        if (r77 == null) goto L420;
        User r78 = jc1.k.n(ILinkServiceExternal.class).getPkService().C();
        if (r78 == null) goto L212;
        py.o r79 = r78.getOwnRoom();
        if (r79 == null) goto L212;
        List r80 = r79.getRoomIdList();
    L214:
        if (Lists.isEmpty(r80) == false) goto L216;
        Long r81 = 0L;
    L223:
        if (r81 != null) goto L226;
    L227:
        if (r81 == null) goto L229;
    L233:
        RoomLinkerContent r82 = (RoomLinkerContent) r77.get(r81);
        if (r82 != null) goto L236;
    L238:
        LinkPkInteractAudienceWindowManagerV2 r83 = this.t;
        if (r83 == null) goto L252;
        Iterator r84 = ((ArrayList) r83.c).iterator();
    L242:
        if (r84.hasNext() == false) goto L252;
        el0.a r85 = (el0.a) r84.next();
        if (r85.getPresenter() == null) goto L242;
        com.bytedance.android.live.livepkaudience.base.i r86 = r83.h;
        if ((r86 instanceof com.bytedance.android.live.livepkaudience.base.i) == true) goto L248;
        r86 = null;
    L248:
        if (r86 == null) goto L242;
        if (r86.v(r85.getPresenter().c()) != true) goto L242;
        r85.e(r3);
    L252:
        DataCenter r87 = ((Widget) this).dataCenter;
        if (r87 == null) goto L255;
        r87.put("data_pk_anchor_silence_status_change", Boolean.valueOf(r3));
    L255:
        ILinkServiceExternal r88 = jc1.k.f(ILinkServiceExternal.class);
        if (r88 == null) goto L258;
        r88.notifyPkAnchorSilenceStatus(r3);
    L258:
        String r89 = this.L0.y();
        ALogger.i(this.p, "onMessage TYPE_LINKER_CROSS_ROOM_UPDATE key = " + r81 + ", isMute = " + r3 + ", mIsNormalAudience = " + this.U + ", guestLinkMicId = " + r89);
        if (this.U == false) goto L262;
        return;
    L262:
        if (TextUtils.isEmpty(r89) == true) goto L266;
        com.bytedance.android.live.livepkaudience.rtc.a r90 = this.e;
        if (r90 == null) goto L266;
        Intrinsics.checkNotNull(r89);
        r90.c(r89, r3);
    L266:
        RoomLinkerContent r91 = (RoomLinkerContent) r77.get(r81);
        if (r91 == null) goto L421;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r92 = r91.linkedUsers;
        if (r92 == null) goto L422;
        Iterator<T> r93 = r92.iterator();
    L272:
        if (r93.hasNext() == false) goto L446;
        com.bytedance.android.livesdk.link.model.bridge.k r94 = (com.bytedance.android.livesdk.link.model.bridge.k) r93.next();
        com.bytedance.android.live.livepkaudience.rtc.a r95 = this.e;
        if (r95 == null) goto L272;
        String r96 = r94.getInteractId();
        if (r96 != null) goto L278;
        r96 = "";
    L278:
        r95.c(r96, r3);
        goto L272
    L446:
        return;
    L422:
        return;
    L421:
        return;
    L236:
        if (r82.mRoomLinkSilenceStatus != 1) goto L238;
        r3 = true;
    L229:
        if (r77.keySet() == null) goto L233;
        if (r77.keySet().isEmpty() == true) goto L233;
        r81 = (Long) CollectionsKt.first(r77.keySet());
        goto L233
    L226:
        if (r81.longValue() == 0) goto L229;
    L216:
        if (r78 == null) goto L222;
        py.o r97 = r78.getOwnRoom();
        if (r97 == null) goto L222;
        List r98 = r97.getRoomIdList();
        if (r98 == null) goto L222;
        r81 = (Long) ListProtector.get(r98, 0);
    L222:
        r81 = null;
    L212:
        r80 = null;
        goto L214
    L420:
        return;
    L419:
        return;
    L280:
        if (r19.getMType() != 46) goto L290;
        String r99 = this.p;
        StringBuilder r100 = new StringBuilder("onMessage TYPE_LINK_RESUME_AUDIENCE content = ");
        LinkerResumeAudienceContent r101 = r19.getLinkerResumeAudienceContent();
        if (r101 == null) goto L284;
        String r102 = r101.toString();
    L285:
        r100.append(r102);
        ALogger.i(r99, r100.toString());
        DataCenter r103 = ((Widget) this).dataCenter;
        if (r103 == null) goto L288;
        r8 = (String) r103.get("data_room_unique_id", "");
    L288:
        tc0.c.i(r8).O = r19.getLinkerResumeAudienceContent();
        return;
    L284:
        r102 = null;
        goto L285
    L290:
        if (r19.getMType() != 47) goto L311;
        String r104 = this.p;
        StringBuilder r105 = new StringBuilder("onMessage TYPE_LINK_BATTLE_CONNECT content = ");
        LinkerBattleConnectContent r106 = r19.getLinkerBattleConnectContent();
        if (r106 == null) goto L294;
        String r107 = r106.toString();
    L295:
        r105.append(r107);
        ALogger.i(r104, r105.toString());
        LinkerBattleConnectContent r108 = r19.getLinkerBattleConnectContent();
        if ((r108 instanceof LinkerBattleConnectContent) == false) goto L299;
        r8 = r108;
    L299:
        if (r8 == null) goto L424;
        this.k0 = r8;
        MultiChannelInfo r109 = r8.multiChannelInfo;
        if (r109 != null) goto L303;
    L309:
        dr();
        return;
    L303:
        if (r109.getUseMultiChannel() == false) goto L309;
        Map<Long, String> r112 = r109.getChannelMap();
        if (r112 == null) goto L309;
        com.bytedance.android.live.livepkaudience.rtc.a r113 = this.e;
        if (r113 == null) goto L309;
        r113.e(r112, "onMessage47", String.valueOf(this.L0.getChannelId()));
        goto L309
    L424:
        return;
    L294:
        r107 = null;
        goto L295
    L311:
        if (r19.getMType() != 53) goto L426;
        LinkerChangeMediaInfoContent r114 = r19.getLinkerChangeMediaInfoContent();
        if ((r114 instanceof LinkerChangeMediaInfoContent) == true) goto L315;
        r114 = null;
    L315:
        if (r114 != null) goto L317;
        return;
    L317:
        IKtvService r115 = jc1.k.f(IKtvService.class);
        if (r115 != null) goto L320;
        return;
    L320:
        if (r115.isInKtvState(1) != true) goto L428;
        LinkmicMediaParam r116 = r114.getLinkmicMediaParam();
        if (r116 == null) goto L326;
        r0 r117 = r116.getKtvComponentMediaInfo();
        if (r117 == null) goto L326;
        r8 = r117.getLiveCoreExtInfo();
    L326:
        if (r8 == null) goto L429;
        com.bytedance.android.live.livepkaudience.rtc.a r118 = this.e;
        if (r118 == null) goto L430;
        com.bytedance.android.live.livepkaudience.rtc.a.i(r118, r8);
        return;
    L430:
        return;
    L429:
        return;
    L428:
        return;
    L426:
        return;
    L331:
        if ((r23 instanceof gf) == false) goto L360;
        if (this.U == true) goto L432;
        gf r119 = (gf) r23;
        if (r119.getLinkMicSignal() != null) goto L337;
        return;
    L337:
        gm2.i r120 = r119.getLinkMicSignal();
        if (Intrinsics.areEqual(r120.senderUserId, this.L0.a()) == false) goto L433;
        int r121 = r120.type;
        if (r121 != 100102) goto L350;
        DataCenter r122 = ((Widget) this).dataCenter;
        if (r122 == null) goto L344;
        r122.put("data_pk_anchor_leave_status_change", Boolean.TRUE);
    L344:
        ILinkServiceExternal r123 = jc1.k.f(ILinkServiceExternal.class);
        if (r123 == null) goto L434;
        lc0.d r124 = r123.getPkService();
        if (r124 == null) goto L435;
        r124.B(true);
        return;
    L435:
        return;
    L434:
        return;
    L350:
        if (r121 != 100101) goto L437;
        DataCenter r125 = ((Widget) this).dataCenter;
        if (r125 == null) goto L354;
        r125.put("data_pk_anchor_leave_status_change", Boolean.FALSE);
    L354:
        ILinkServiceExternal r126 = jc1.k.f(ILinkServiceExternal.class);
        if (r126 == null) goto L438;
        lc0.d r127 = r126.getPkService();
        if (r127 == null) goto L439;
        r127.B(false);
        return;
    L439:
        return;
    L438:
        return;
    L437:
        return;
    L433:
        return;
    L432:
        return;
    L360:
        if ((r23 instanceof ue) == false) goto L441;
        LinkPkInteractAudienceWindowManagerV2 r128 = this.t;
        if (r128 == null) goto L442;
        ue r129 = (ue) r23;
        Intrinsics.checkNotNullParameter(r129, "emojiMessage");
        if (r129.isThanksInteractEmoji() == false) goto L369;
        if (((IInteractService) jc1.k.n(IInteractService.class)).isQuickInteractEnable() == true) goto L369;
    L376:
        Unit r130 = Unit.INSTANCE;
        return;
    L369:
        if (r129.isInteractEmoji() == false) goto L373;
        DataCenter r131 = r128.u;
        if (r131 == null) goto L376;
        r131.put("cmd_show_dynamic_emoji_in_comment", r129);
        goto L376
    L373:
        com.bytedance.android.live.livepkaudience.seat.f r132 = r128.F;
        if (r132 == null) goto L376;
        int r133 = com.bytedance.android.live.livepkaudience.seat.e.a;
        wj0.b r134 = new wj0.b(r129.getFromUser(), r129.getDynamicEmoji(), r129.getRandomEmojiImage(), r129.getBaseMessage());
        Intrinsics.checkNotNullParameter(r134, "info");
        r132.a(new com.bytedance.android.live.livepkaudience.seat.c(r134));
        goto L376
    L442:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void onUserJoined(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        Intrinsics.checkNotNullParameter(r2, "interactId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.t
    public final void p2(fi6.a r6) {
        hd0.c r0 = hd0.c.f();
        r0.e = SystemClock.currentThreadTimeMillis();
        int r1 = this.C;
        qi6.g r2 = new qi6.g(240, 240, 15, 360);
        if (r6 == null) goto L6;
        r6.o(r2);
        r6.i(InteractMode.NORMAL);
        r6.g(Character.GUEST);
        r6.N = r1;
        r6.n(StreamType.VIDEO);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.presenter.a.InterfaceC0115a
    public final void q(int r5) {
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (r5 == 0) goto L31;
        if (r5 != 1) goto L9;
    L23:
        com.bytedance.android.live.livepkaudience.rtc.a r0 = this.e;
        if (r0 == null) goto L26;
        r0.h(false, "onAudioStatusChange silenceStatus = " + r5);
    L26:
        f2.b(2131919412, 0);
        if (this.q == false) goto L38;
        dl0.m r1 = dl0.m.a;
        JSONObject r2 = new JSONObject();
        BaseMonitor.add(r2, "silence_status", r5);
        dl0.m.a.getClass();
        dl0.m.A("silence_by_anchor_on_background", r2);
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L39;
        r6.put("data_talk_room_capture_audio_notification_show_state", Boolean.FALSE);
        return;
    L39:
        return;
    L38:
        return;
    L9:
        if (r5 == 2) goto L23;
        if (r5 != 3) goto L41;
        com.bytedance.android.live.livepkaudience.rtc.a r7 = this.e;
        if (r7 == null) goto L16;
        r7.h(false, "onAudioStatusChange SILENCE_PASSIVE");
    L16:
        com.bytedance.android.live.livepkaudience.base.i r8 = this.s;
        if (r8 == null) goto L36;
        String r3 = jc1.k.n(IUserService.class).user().b().getIdString();
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r4 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r4 == null) goto L21;
        String r9 = r4.getAudienceSelfLinkMicId();
    L22:
        r8.O(r3, r9, 3);
        return;
    L21:
        r9 = null;
        goto L22
    L36:
        return;
    L41:
        return;
    L31:
        com.bytedance.android.live.livepkaudience.rtc.a r10 = this.e;
        if (r10 == null) goto L34;
        r10.h(true, "onAudioStatusChange UNSILENCE");
    L34:
        f2.b(2131919449, 0);
    }

    @Override // com.bytedance.android.live.livepkaudience.service.a
    public final void u3(String r4) {
        Intrinsics.checkNotNullParameter(r4, "toUserId");
        com.bytedance.android.live.livepkaudience.presenter.a r1 = this.Z;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAudioManagerPresenter");
    L5:
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r4, "toUserId");
        r1.d0(r4, 0);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.a
    public final void wi(LinkPlayerInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "linkPlayerInfo");
        vh7.c r3 = r2.getUser();
        if (r3 == null) goto L8;
        User r4 = (User) jm2.a.e(r3);
        if (r4 == null) goto L9;
        Gq(r4);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.base.h
    public final void xn(Text r3) {
        tc0.c r0 = tc0.c.h();
        r0.K = LinkApplyType.PREPARE_APPLY.getValue();
        hd0.c.f().k(1);
        ar(r3);
    }

    public LinkPkInteractAudienceGuestWidget(LinkPkInteractGuestDataContext r1, BasePkInteractAnchorWidget.a r2) {
        Intrinsics.checkNotNullParameter(r1, "linkPkInteractDataContext");
        this.h1 = r1;
        this.p = "LinkPkInteractAudienceGuestWidget";
        this.w = new CompositeDisposable();
        this.z = ((IInteractService) jc1.k.n(IInteractService.class)).getAnimationController();
        this.C = 300;
        this.G = 0L;
        this.H = 180000;
        this.I = "show_bubble_tag_guest";
        this.S = new com.bytedance.android.live.liveinteract.utils.d(null);
        this.U = true;
        this.W = new k0();
        this.H0 = LazyKt.lazy(new LinkPkInteractAudienceGuestWidget$mInteractLiveCorePermissionGuarantor$2(this));
        this.L0 = jc1.k.n(ILinkServiceExternal.class).getMultiDataHolder();
        this.P0 = new l(this);
        this.V0 = new f(this);
        this.b1 = new m(this);
        this.g1 = new p(this);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget
    public final void Cq(int r4, rj0.a r5) {
        if (((Widget) this).context != null) goto L6;
        return;
    L6:
        if (r4 == 1) goto L8;
    L29:
        r5.onConfirm();
        return;
    L8:
        if (sj1.c() == true) goto L12;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.G2.getValue()).booleanValue() == true) goto L29;
    L12:
        if (hd0.c.f().j() == true) goto L21;
        q r1 = this.b;
        if (r1 != null) goto L16;
    L17:
        if (r1 != null) goto L19;
    L20:
        boolean r2 = true;
    L22:
        if (r2 == false) goto L29;
        hd0.c.f().g = r4;
        LiveDialogFragment r6 = this.Y;
        if (r6 != null) goto L26;
    L28:
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new n(this, r5)).callbackOnMainThread().syncCallbackIfReady(true).justPrepare();
        return;
    L26:
        if (r6.isShowing() != true) goto L28;
        return;
    L19:
        if (r1.j == true) goto L21;
    L16:
        if (r1.i != true) goto L17;
    L21:
        r2 = false;
        goto L22
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.base.h
    public final void D0(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "reqFrom");
        if (Intrinsics.areEqual(r2, "paid_change") == false) goto L5;
        return;
    L5:
        ExceptionUtils.handleException(getContext(), r3, 2131919391);
    }

    @Override // com.bytedance.android.live.livepkaudience.presenter.a.InterfaceC0115a
    public final void F(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        ExceptionUtils.handleException(((Widget) this).context, r3, 2131919335);
    }

    public final void Qq(String r4, boolean r5) {
        com.bytedance.android.live.livepkaudience.rtc.a r6 = this.e;
        if (r6 == null) goto L7;
        if (r6.j != true) goto L7;
    L10:
        if (Nq() != 0) goto L28;
        com.bytedance.android.live.livepkaudience.rtc.a r7 = this.e;
        if (r7 != null) goto L14;
    L16:
        FragmentActivity r8 = ((Widget) this).context;
        if (r8 == null) goto L28;
        if (r8.isFinishing() == true) goto L28;
        this.r = true;
        com.bytedance.android.live.livepkaudience.base.i r9 = this.s;
        if (r9 == null) goto L23;
        r9.O(jc1.k.n(IUserService.class).user().b().getIdString(), tc0.c.h().f, 3);
    L23:
        com.bytedance.android.live.livepkaudience.presenter.a r10 = this.Z;
        if (r10 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mAudioManagerPresenter");
    L26:
        r10.d0(jc1.k.n(IUserService.class).user().b().getIdString(), 1);
        goto L28
    L14:
        if (r7.j == false) goto L16;
        r7.h(false, "GuestRtcManager onPause");
    L28:
        if (this.f == true) goto L30;
        getLinkUserCenter().B();
    L30:
        v0 r11 = this.x;
        if (r11 == null) goto L36;
        d0 r12 = r11.A();
        if (r12 == null) goto L37;
        r12.d();
        return;
    L37:
        return;
    L36:
        return;
    L7:
        if (((Boolean) LiveInfraSettingKeys.LIVE_AUDIENCE_LINK_API_ERROR_FiX.getValue()).booleanValue() == false) goto L10;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void R(long r1, Exception r3) {
        super.R(r1, r3);
        f2.b(2131919445, 0);
    }

    public final void Tq(boolean r16, boolean r17) {
        this.S.i = this.W.b;
        v0 r1 = this.x;
        String r3 = null;
        if ((r1 instanceof m00.g) == true) goto L5;
        r1 = null;
    L5:
        m00.g r2 = (m00.g) r1;
        if (r2 == null) goto L8;
        long r4 = r2.b();
    L9:
        int r6 = al0.c.b;
        Room r7 = this.u;
        com.bytedance.android.live.liveinteract.utils.d r8 = this.S;
        long r9 = this.F;
        Long r10 = this.G;
        if (r10 == null) goto L12;
        long r11 = r10.longValue();
    L13:
        Intrinsics.checkNotNullParameter(r8, "logParams");
        HashMap r12 = new HashMap();
        long r13 = System.currentTimeMillis() - r9;
        long r14 = 1000;
        r12.put("audience_time", String.valueOf(r13 / r14));
        r12.put("audience_camera_on_duration", String.valueOf((r4 - r11) / r14));
        r12.put("audience_talk_duration", String.valueOf(r8.i / r14));
        String r15 = String.valueOf(dl0.p.a().getChannelId());
        if (r15 != null) goto L16;
        r15 = "0";
    L16:
        r12.put("channel_id", r15);
        al0.c.a(r12, r8);
        al0.c.b(r12);
        if (r16 == false) goto L19;
        u.l().sendLog("livesdk_audience_with_pk_end", r12, new Object[]{r7, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
    L20:
        if (r17 == true) goto L33;
        this.W.b();
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r5 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r5 == null) goto L25;
        r3 = r5.getAudienceSelfLinkMicId();
    L25:
        if (TextUtils.isEmpty(r3) == true) goto L32;
        k0 r18 = this.W;
        LinkPkInteractGuestDataContext r19 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r19 == null) goto L30;
        String r20 = r19.getAudienceSelfLinkMicId();
        if (r20 == null) goto L30;
    L31:
        r18.c(r20, false);
    L30:
        r20 = "";
    L32:
        this.G = Long.valueOf(r4);
        this.F = System.currentTimeMillis();
        return;
    L33:
        this.G = 0L;
        return;
    L19:
        u.l().sendLog("livesdk_audience_with_punish_end", r12, new Object[]{r7, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        goto L20
    L12:
        r11 = 0;
        goto L13
    L8:
        r4 = 0;
        goto L9
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.livepkaudience.base.h
    /* JADX INFO: renamed from: do */
    public final void mo464do(AudienceLinkReplyResult r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "result");
        hd0.c.f().g = 2;
        super.mo464do(r3, r4);
        if (r4 != ReplyType.Agree.ordinal()) goto L6;
        f2.b(2131918015, 0);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void e1(String r3, long r4) {
        super.e1(r3, r4);
        if (TextUtils.equals(r3, this.L0.y()) == false) goto L5;
    L8:
        com.bytedance.android.live.livepkaudience.rtc.a r5 = this.e;
        if (r5 == null) goto L11;
        r5.g("onUserLeaved");
    L11:
        LinkPkInteractAudienceWindowManagerV2 r6 = this.t;
        if (r6 == null) goto L15;
        r6.a("0", r3);
        return;
    L15:
        return;
    L5:
        if (StringsKt.startsWith$default(r3, "1_", false, 2, null) != true) goto L11;
        if (((Boolean) eh0.a.getValue()).booleanValue() == false) goto L11;
        goto L8
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f0(long r1, Exception r3) {
        F3("leave_on_rtc_error");
        f2.b(2131919447, 0);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget
    public final v0 ga(String r10, boolean r11) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        this.A = r10;
    L6:
        if (this.x != null) goto L12;
        com.bytedance.android.live.liveinteract.utils.d r0 = this.S;
        r0.g = hd0.c.f().g;
        if (hd0.c.f().g != 1) goto L10;
        boolean r5 = true;
    L11:
        this.x = ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).createVideoTalkView(((Widget) this).context, r10, r5, r11, true, this);
        goto L12
    L10:
        r5 = false;
    L12:
        v0 r12 = this.x;
        if (r12 == null) goto L16;
        return r12;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.interact.LiveVideoClientFactory");
    }

    @Override // com.bytedance.android.live.livepkaudience.presenter.a.InterfaceC0115a
    public final void r(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        if ((r3 instanceof ApiServerException) == false) goto L6;
        f2.c(((ApiServerException) r3).getPrompt(), 0);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J(String[] r1, boolean[] r2, int[] r3) {
        super.J(r1, r2, r3);
        this.W.a(r1, r3);
    }

    @Override // com.bytedance.android.live.livepkaudience.service.d
    public final void Rc(long r9, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "secToUserId");
        Intrinsics.checkNotNullParameter(r11, "secToUserId");
        if (r12 != ReplyType.Reject.ordinal()) goto L7;
        q r1 = this.b;
        if (r1 == null) goto L9;
        r1.g(r9, r11, r12, 2, 1);
        return;
    L9:
        return;
    L7:
        wq(OperateType.REPLY, 2, new com.bytedance.android.live.livepkaudience.base.e(this, r9, r11, r12));
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAdminLinkWidget, com.bytedance.android.live.livepkaudience.service.a
    public final void kickOut(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r4 = "admin_stop_normal";
    L8:
        super.kickOut(r2, r3, r4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.livepkaudience.service.a
    public final void t2(long r2, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        Fq(r2, r4, r5);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L0(String r1, TextureView r2, int r3, int r4) {
        super.L0(r1, r2, r3, r4);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void b4(String r4, z.a r5, int r6, int r7) {
        super.b4(r4, r5, r6, r7);
        Mq(r4);
        v0 r8 = this.x;
        if (r8 == null) goto L9;
        d0 r9 = r8.A();
        if (r9 == null) goto L9;
        z r10 = r9.C();
        if (r10 == null) goto L9;
        z.a r11 = r10.K0();
    L10:
        ALogger.i(this.p, "onFirstRemoteVideoFrame linkId = " + r4);
        LinkPkInteractAudienceWindowManagerV2 r0 = this.t;
        String r2 = "";
        if (r0 == null) goto L15;
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        LinkPkInteractAudienceWindowManagerV2.w(r0, r4, null, r5, 2);
    L15:
        LinkPkInteractAudienceWindowManagerV2 r12 = this.t;
        if (r12 == null) goto L22;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r13 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r13 == null) goto L20;
        String r14 = r13.getAudienceSelfLinkMicId();
    L21:
        el0.a r15 = r12.o("0", r14);
    L23:
        if (r15 != null) goto L35;
        if (r11 == null) goto L36;
        LinkPkInteractAudienceWindowManagerV2 r16 = this.t;
        if (r16 == null) goto L37;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r17 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r17 == null) goto L33;
        String r18 = r17.getAudienceSelfLinkMicId();
        if (r18 == null) goto L33;
        r2 = r18;
    L33:
        LinkPkInteractAudienceWindowManagerV2.w(r16, r2, null, r11, 2);
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L20:
        r14 = null;
        goto L21
    L22:
        r15 = null;
    L9:
        r11 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.livepkaudience.service.d
    public final void c2(int r11, int r12, String r13, LinkApplyType r14) {
        Intrinsics.checkNotNullParameter(r13, "fromSource");
        Intrinsics.checkNotNullParameter(r14, "applyType");
        com.bytedance.android.live.liveinteract.utils.d r2 = this.S;
        r2.d = r12;
        Intrinsics.checkNotNullParameter("apply", "<set-?>");
        r2.b = "apply";
        Intrinsics.checkNotNullParameter(r14, "applyType");
        Intrinsics.checkNotNullParameter(r13, "fromSource");
        wq(OperateType.APPLY, r11, new com.bytedance.android.live.livepkaudience.base.b(this, r11, 1, r14, r13));
        if (TextUtils.equals(r13, "video_apply_container_click") == true) goto L5;
        return;
    L5:
        if (((Boolean) n60.a.getValue()).booleanValue() == false) goto L30;
        int r15 = al0.c.b;
        RoomContext r16 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r16 == null) goto L13;
        com.bytedance.live.datacontext.m r17 = r16.getCleanMode();
        if (r17 == null) goto L13;
        Integer r18 = (Integer) r17.getValue();
        if (r18 == null) goto L13;
        int r19 = r18.intValue();
    L14:
        if (r19 <= 0) goto L31;
        HashMap r110 = new HashMap();
        if (r19 == 1) goto L26;
        if (r19 == 2) goto L25;
        if (r19 != 3) goto L21;
        String r111 = "simple_mode";
    L27:
        r110.put("mode_type", r111);
        r110.put("action_type", "click");
        r110.put("connection_type", "video");
        u.l().sendLog("livesdk_connection_click_under_screen_clear", r110, new Object[]{x.class, Room.class});
        return;
    L21:
        if (r19 == 13) goto L23;
        r111 = "unknown_mode";
        goto L27
    L23:
        r111 = "focus_mode";
        goto L27
    L25:
        r111 = "pure_mode";
        goto L27
    L26:
        r111 = "origin_mode";
        goto L27
    L31:
        return;
    L13:
        r19 = 0;
        goto L14
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractGuestWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h1(String r3, SurfaceView r4, int r5, int r6) {
        super.h1(r3, r4, r5, r6);
        Mq(r3);
        LinkPkInteractAudienceWindowManagerV2 r7 = this.t;
        String r1 = "";
        if (r7 == null) goto L7;
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        LinkPkInteractAudienceWindowManagerV2.w(r7, r3, r4, null, 4);
    L7:
        LinkPkInteractAudienceWindowManagerV2 r8 = this.t;
        if (r8 == null) goto L14;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r9 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r9 == null) goto L12;
        String r10 = r9.getAudienceSelfLinkMicId();
    L13:
        el0.a r11 = r8.o("0", r10);
    L15:
        if (r11 == null) goto L17;
        return;
    L17:
        if (this.x == null) goto L32;
        LinkPkInteractAudienceWindowManagerV2 r12 = this.t;
        if (r12 == null) goto L33;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r13 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r13 == null) goto L26;
        String r14 = r13.getAudienceSelfLinkMicId();
        if (r14 == null) goto L26;
        r1 = r14;
    L26:
        SurfaceView r15 = this.x;
        if (r15 == null) goto L30;
        LinkPkInteractAudienceWindowManagerV2.w(r12, r1, r15, null, 4);
        return;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
    L33:
        return;
    L32:
        return;
    L12:
        r10 = null;
        goto L13
    L14:
        r11 = null;
        goto L15
    }

    @Override // com.bytedance.android.live.livepkaudience.service.d
    public final void switchAudioByClient(boolean r10, List<AnchorLinkUser> r11, long r12, Map<Long, ? extends RoomLinkerContent> r14) {
        Intrinsics.checkNotNullParameter(r11, "linkedUsers");
        com.bytedance.android.live.livepkaudience.rtc.a r0 = this.e;
        if (r0 != null) goto L5;
    L16:
        f2.b(2131919299, 0);
        return;
    L5:
        if (r0.j != true) goto L16;
        this.r = false;
        if (r0 == null) goto L10;
        r0.h(!r10, "switchAudioByClient");
    L10:
        com.bytedance.android.live.livepkaudience.base.i r3 = getLinkUserCenter();
        if (r10 == false) goto L13;
        String r13 = "silence";
    L14:
        r3.I(r11, r12, r13, r14);
        return;
    L13:
        r13 = "unSilence";
        goto L14
    }

    @Override // com.bytedance.android.live.livepkaudience.service.a
    public final void v0(int r2, String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "requestPage");
        DataCenter r6 = ((Widget) this).dataCenter;
        int r7 = RevLinkDialog.u;
        RevLinkDialog r8 = new RevLinkDialog.a(r6, this).a(r3, r4, this.a, false);
        FragmentActivity r9 = ((Widget) this).context;
        if ((r9 instanceof FragmentActivity) == false) goto L12;
        if (r9 == null) goto L11;
        FragmentManager r10 = r9.getSupportFragmentManager();
        LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, "RevLinkDialog", r11);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, r8, r11) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L9:
        r8.show(r10, "RevLinkDialog");
        return;
    L17:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    @Override // com.bytedance.android.live.livepkaudience.vm.b
    public final void Mo(boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, com.bytedance.android.live.livepkaudience.vm.a r26) {
        if (r21 == false) goto L30;
        if (r22 == false) goto L30;
        v0 r0 = this.x;
        if (r0 == null) goto L14;
        d0 r1 = r0.A();
        if (r1 == null) goto L14;
        d0.a r2 = r1.getBuilder();
        if (r2 == null) goto L14;
        if (r2.g() != 1) goto L14;
    L21:
        if (r26 == null) goto L23;
        r26.onSuccess();
    L23:
        v0 r3 = this.x;
        if ((r3 instanceof m00.g) == true) goto L26;
        r3 = null;
    L26:
        m00.g r4 = (m00.g) r3;
        if (r4 == null) goto L54;
        r4.r();
        return;
    L54:
        return;
    L14:
        v0 r5 = this.x;
        if (r5 == null) goto L21;
        d0 r6 = r5.A();
        if (r6 == null) goto L21;
        d0.a r7 = r6.getBuilder();
        if (r7 == null) goto L21;
        r7.g();
    L30:
        if (r24 == true) goto L40;
        int r8 = al0.c.b;
        com.bytedance.android.live.liveinteract.utils.d r9 = this.S;
        boolean r10 = l5();
        Intrinsics.checkNotNullParameter(r9, "logParams");
        HashMap r11 = new HashMap();
        r11.put("live_type", "video_live");
        r11.put("function_type", al0.c.e());
        r11.put("user_type", "guest");
        if (r10 == false) goto L34;
        String r12 = "off";
    L35:
        r11.put("button_type", r12);
        if (r9.g != 1) goto L38;
        String r13 = "video";
    L39:
        r11.put("guest_connection_type", r13);
        al0.c.a(r11, r9);
        al0.c.b(r11);
        u.l().sendLog("livesdk_audience_connection_user_camera_open_click", r11, new Object[]{x.class, Room.class});
        goto L40
    L38:
        r13 = "voice";
        goto L39
    L34:
        r12 = "on";
    L40:
        if (r21 == false) goto L42;
        int r14 = 1;
    L43:
        ArrayList r15 = new ArrayList();
        Context r16 = ((Widget) this).context;
        if (r16 != null) goto L46;
        r16 = s1.getContext();
    L46:
        OperateType r17 = OperateType.APPLY;
        r15.add(new qh0.f.b(r16, r17, r14));
        if (r23 == true) goto L52;
        Context r18 = ((Widget) this).context;
        if (r18 != null) goto L51;
        r18 = s1.getContext();
    L51:
        r15.add(new qh0.f.h(r18, r17, r14, 1, this.a, jc1.k.n(IUserService.class).user().n(), null, null, LinkPkInteractAudienceGuestWidget$switchCamera$1.INSTANCE, 960));
    L52:
        qh0.f.a(r15).a(new com.bytedance.android.live.livepkaudience.widget.h(this, r26, r14, r25, r21, r22, r24));
        return;
    L42:
        r14 = 2;
        goto L43
    }
}
