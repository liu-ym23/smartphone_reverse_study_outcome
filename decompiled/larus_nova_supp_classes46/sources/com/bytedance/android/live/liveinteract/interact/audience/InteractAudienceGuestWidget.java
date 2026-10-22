package com.bytedance.android.live.liveinteract.interact.audience;

import am2.x;
import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.LinkDialog;
import com.bytedance.android.live.liveinteract.component.MultiComponentManager;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.interact.audience.context.InteractAdminContext;
import com.bytedance.android.live.liveinteract.interact.audience.context.InteractGuestContext;
import com.bytedance.android.live.liveinteract.interact.audience.dialog.InteractAudienceGuestAppliedDialogV2;
import com.bytedance.android.live.liveinteract.interact.audience.dialog.InteractAudienceGuestApplyDialog;
import com.bytedance.android.live.liveinteract.interact.audience.dialog.InteractAudienceGuestInviteDialog;
import com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.InteractAudienceListFragmentV2;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.api.LinkPaidLinkApi;
import com.bytedance.android.live.liveinteract.plantform.camera.SwitchCameraManager;
import com.bytedance.android.live.liveinteract.plantform.core.RtcManager;
import com.bytedance.android.live.liveinteract.plantform.core.g0;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.plantform.widgt.BaseAdminLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor;
import com.bytedance.android.live.liveinteract.utils.f0;
import com.bytedance.android.live.liveinteract.utils.k0;
import com.bytedance.android.live.liveinteract.utils.r;
import com.bytedance.android.live.liveinteract.voicechat.dialog.ChatRoomDistributeTipsDialog;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService;
import com.bytedance.android.live.recharge.IMultiRechargeServiceExternal;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.a0;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.interact.b1;
import com.bytedance.android.livesdk.chatroom.model.interact.j1;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.l6;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.message.model.ab;
import com.bytedance.android.livesdk.message.model.d9;
import com.bytedance.android.livesdk.multilink.base.model.ReplyType;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerBattleConnectContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerKickOutContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import gd0.v;
import hh1.u0;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import uf2.z;
import w20.xc;
import zg1.a1;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/InteractAudienceGuestWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/BaseAdminLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "Lcom/bytedance/android/live/liveinteract/plantform/base/c;", "Lng6/a;", "Lvlc/l;", "Lcom/bytedance/android/live/liveinteract/plantform/core/g0;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAudienceGuestWidget extends BaseAdminLinkWidget<ILinkPlayerInfoBridge> implements com.bytedance.android.live.liveinteract.plantform.base.c, ng6.a, vlc.l, g0 {
    public boolean A;
    public IRoom B;
    public InteractAudienceGuestInviteDialog C;
    public final CompositeDisposable D;
    public m00.d E;
    public Runnable F;
    public vlc.d G;
    public String H;
    public String I;
    public final int J;
    public long K;
    public long L;
    public long M;
    public final long N;
    public Disposable O;
    public int P;
    public boolean Q;
    public long R;
    public InteractAudienceGuestAppliedDialogV2 S;
    public SwitchCameraManager T;
    public com.bytedance.android.live.liveinteract.utils.d U;
    public final k0 V;
    public com.bytedance.android.live.liveinteract.utils.g0 W;
    public final Lazy X;
    public final l Y;
    public final e Z;
    public LinkApplyType k0;
    public boolean x;
    public y y;
    public InteractAudienceVideoWindowManager z;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestWidget a;
        public final /* synthetic */ h80.a b;
        public final /* synthetic */ boolean c;

        public a(InteractAudienceGuestWidget r1, h80.a r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            r3.dismiss();
            com.bytedance.android.live.liveinteract.plantform.core.n r5 = this.a.b;
            if (r5 == null) goto L6;
            r5.b("cancel_application", this.b, this.c);
            return;
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ h80.a a;

        public b(h80.a r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            h80.a r3 = this.a;
            if (r3 == null) goto L6;
            r3.accept(Boolean.FALSE);
            return;
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestWidget a;

        public c(InteractAudienceGuestWidget r1) {
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

    public static final class e extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
        public final /* synthetic */ InteractAudienceGuestWidget a;

        public e(InteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r5) {
            Intrinsics.checkNotNullParameter(r5, "list");
            ArrayList r0 = new ArrayList(r5);
            ((Widget) this.a).dataCenter.put("data_online_changed_list", r0);
            com.bytedance.android.livesdk.chatroom.utils.g0.e(r0.size());
            ArrayList r6 = new ArrayList();
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            Object r2 = r1.next();
            if (je0.d.C((ILinkPlayerInfoBridge) r2) == false) goto L4;
            r6.add(r2);
            goto L4
        L8:
            ILinkPlayerInfoBridge r7 = (ILinkPlayerInfoBridge) CollectionsKt.firstOrNull(r6);
            if (r7 == null) goto L54;
            InteractAudienceGuestWidget r3 = this.a;
            String r4 = r3.w.getInteractId();
            if (r4 != null) goto L15;
            r4 = "0";
        L15:
            if (Intrinsics.areEqual(r7.getInteractId(), r4) == false) goto L55;
            ILinkPlayerInfoBridge r8 = r3.getLinkUserCenter().o("", r4);
            u0 r9 = null;
            if (r8 != null) goto L19;
        L41:
            u0 r10 = r3.c;
            if ((r10 instanceof u0) == false) goto L45;
            r9 = r10;
        L45:
            u0 r11 = r9;
            if (r11 == null) goto L58;
            r11.b();
            return;
        L58:
            return;
        L19:
            if (com.bytedance.android.live.liveinteract.plantform.model.n.f(r8) != true) goto L41;
            u0 r12 = r3.c;
            if ((r12 instanceof u0) == false) goto L24;
            r9 = r12;
        L24:
            u0 r13 = r9;
            if (r13 == null) goto L56;
            kd1.b r14 = r8.getMicDress();
            if (r14 == null) goto L35;
            kd1.c r15 = r14.getVoiceWave();
            if (r15 == null) goto L35;
            py.k r16 = r15.getMediumImg();
            if (r16 == null) goto L35;
            List r17 = r16.getUrls();
            if (r17 == null) goto L35;
            String r18 = (String) CollectionsKt.getOrNull(r17, 0);
        L35:
            kd1.b r19 = r8.getMicDress();
            if (r19 == null) goto L40;
            kd1.c r20 = r19.getVoiceWave();
            if (r20 == null) goto L40;
            r20.getDressId();
        L40:
            r13.b();
            return;
        L56:
            return;
        L55:
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void n(List<ILinkPlayerInfoBridge> r3, long r4, n0 r6) {
            Intrinsics.checkNotNullParameter(r3, "list");
            if (v.a(((Integer) ((Widget) this.a).dataCenter.get("data_link_state", 0)).intValue(), 2) == false) goto L27;
            String r5 = jc1.k.n(IMiddlewareUserService.class).user().n();
            String r1 = null;
            if (vm2.d.k() == false) goto L13;
            if (r6 == null) goto L11;
            IBaseUser r7 = r6.getUserFlex();
            if (r7 == null) goto L11;
            r1 = r7.getIdString();
        L11:
            if (Intrinsics.areEqual(r1, r5) == false) goto L28;
            hd0.c.f().k(1);
            return;
        L28:
            return;
        L13:
            Iterator r8 = ((CopyOnWriteArrayList) r3).iterator();
        L15:
            if (r8.hasNext() == false) goto L30;
            IBaseUser r9 = ((ILinkPlayerInfoBridge) r8.next()).getUser();
            if (r9 == null) goto L19;
            String r10 = r9.getIdString();
        L21:
            if (Intrinsics.areEqual(r10, r5) == false) goto L15;
            hd0.c.f().k(1);
            return;
        L19:
            r10 = null;
            goto L21
        L30:
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestWidget a;

        public f(InteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            InteractAudienceGuestWidget r7 = this.a;
            int r0 = bh0.a.a;
            r7.getClass();
            Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r1 != null) goto L6;
        L15:
            if (r1 != null) goto L18;
        L27:
            if (r1 != null) goto L30;
            return;
        L30:
            if (r1.intValue() == 2) goto L32;
            return;
        L32:
            if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == true) goto L34;
            f2.b(2131917547, 0);
            return;
        L34:
            DataCenter r2 = ((Widget) r7).dataCenter;
            int r3 = LinkDialog.v;
            LinkDialog r4 = new LinkDialog.a(r2, r7).a();
            int r5 = InteractAudienceListFragmentV2.n;
            r4.e = InteractAudienceListFragmentV2.a.a(r4, ((Widget) r7).dataCenter);
            FragmentActivity r8 = ((Widget) r7).context;
            if ((r8 instanceof FragmentActivity) == false) goto L54;
            if (r8 == null) goto L43;
            FragmentManager r9 = r8.getSupportFragmentManager();
            LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "LinkDialog", r10);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r4, r10) == true) goto L57;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
        L41:
            r4.show(r9, "LinkDialog");
            return;
        L57:
            return;
        L43:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        L54:
            return;
        L18:
            if (r1.intValue() != 1) goto L27;
            int r11 = r.a;
            if (r.b(r7.getRoom()) == true) goto L24;
            if (r7.Gq() == true) goto L24;
            return;
        L24:
            if (s0.a(r7.getRoom()) == false) goto L26;
            r7.Pq();
            return;
        L26:
            r7.B();
            return;
        L6:
            if (r1.intValue() != 0) goto L15;
            if (vm2.d.p0() == true) goto L10;
        L14:
            r7.c2(2, 101, "interact_audience_guest_widget_empty_window", null);
            return;
        L10:
            if (com.bytedance.android.livesdk.chatroom.paidlive.e.e(r7.getRoom(), null) == false) goto L14;
            if (com.bytedance.android.livesdk.chatroom.paidlive.e.b(r7.getRoom()) == true) goto L14;
            f2.b(2131921181, 0);
            TalkRoomBusinessFullLinkMonitor r12 = TalkRoomBusinessFullLinkMonitor.a;
            boolean r13 = com.bytedance.android.livesdk.chatroom.paidlive.e.e(r7.getRoom(), null);
            boolean r14 = com.bytedance.android.livesdk.chatroom.paidlive.e.b(r7.getRoom());
            r12.getClass();
            TalkRoomBusinessFullLinkMonitor.e0(r13, r14);
        }
    }

    public static final class g implements Consumer<h1> {
        public final /* synthetic */ InteractAudienceGuestWidget a;

        public g(InteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            h1 r3 = (h1) r2;
            if (r3 == null) goto L20;
            int r4 = r3.a;
            if (r4 != 30) goto L7;
            InteractAudienceVideoWindowManager r5 = this.a.z;
            if (r5 == null) goto L24;
            View r6 = r5.d;
            if (r6 == null) goto L25;
            r6.setVisibility(0);
            return;
        L25:
            return;
        L24:
            return;
        L7:
            if (r4 != 31) goto L26;
            InteractAudienceVideoWindowManager r7 = this.a.z;
            if (r7 == null) goto L21;
            View r8 = r7.d;
            if (r8 == null) goto L22;
            r8.setVisibility(8);
            return;
        L22:
            return;
        L21:
            return;
        L26:
            return;
        }
    }

    public static final class h implements Consumer<Long> {
        public final /* synthetic */ InteractAudienceGuestWidget a;

        public h(InteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.F3("leave_background_time_out");
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
        public final /* synthetic */ InteractAudienceGuestWidget a;

        public j(InteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            if (r1 == null) goto L4;
            r1.dismiss();
        L4:
            InteractAudienceGuestWidget r3 = this.a;
            if (((Widget) r3).context == null) goto L8;
            r3.Mq(false);
            return;
        }
    }

    public static final class k implements Consumer<Long> {
        public final /* synthetic */ InteractAudienceGuestWidget a;

        public k(InteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.F3("leave_background_time_out");
        }
    }

    public static final class l implements InteractLiveCorePermissionGuarantor.a {
        public final /* synthetic */ InteractAudienceGuestWidget a;

        @Override // com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor.a
        public final void b(boolean r1) {
        }

        public l(InteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor.a
        public final void a(boolean r3) {
            if (r3 == false) goto L4;
            this.a.Kq("on particular page show", true);
            return;
        L4:
            this.a.Lq("on particular page close");
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ InteractAudienceGuestWidget a;

        public m(InteractAudienceGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            if (r8 == null) goto L33;
            com.bytedance.android.livesdk.chatroom.model.interact.h1 r9 = (com.bytedance.android.livesdk.chatroom.model.interact.h1) r8.data;
            if (r9 == null) goto L35;
            Long r0 = r9.getPaidCount();
            Long r1 = r9.getLimitedTime();
            if (r0 == null) goto L34;
            if (r1 == null) goto L36;
            com.bytedance.android.livesdk.sharedpref.d.k((int) r0.longValue());
            com.bytedance.android.livesdk.sharedpref.d.g((int) r1.longValue());
            ArrayList r2 = new ArrayList();
            List r3 = r9.getPaidTags();
            if (r3 == null) goto L24;
            Iterator<T> r4 = r3.iterator();
        L15:
            if (r4.hasNext() == false) goto L24;
            String r5 = ((j1) r4.next()).getName();
            if (r5 == null) goto L15;
            if (r5.length() <= 0) goto L21;
            boolean r6 = true;
        L22:
            if (r6 == false) goto L15;
            r2.add(r5);
            goto L15
        L21:
            r6 = false;
        L24:
            this.a.Rq((int) r0.longValue(), (int) r1.longValue(), r2, r9.getPaidDesc());
            return;
        L36:
            return;
        L34:
            return;
        L35:
            return;
        }
    }

    public static final class n<T> implements Consumer {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final void accept(Object r3) {
            ALogger.e("ttlive_link_paid", "getPaidInfoBeforeApply failed " + ((Throwable) r3));
            f2.b(2131917082, 0);
        }
    }

    public final InteractLiveCorePermissionGuarantor Iq() {
        return (InteractLiveCorePermissionGuarantor) this.X.getValue();
    }

    public final int getLayoutId() {
        return 2131567747;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return 4;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final void w4() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget
    public final int zq() {
        return 1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.c
    public final com.bytedance.android.live.liveinteract.plantform.core.e A0() {
        com.bytedance.android.live.liveinteract.plantform.core.e r0 = this.u;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAdminManager");
    L5:
        return r0;
    }

    public final void B() {
        Observer r0 = this.S;
        if (r0 != null) goto L5;
    L7:
        InteractAudienceGuestAppliedDialogV2 r1 = new InteractAudienceGuestAppliedDialogV2(((Widget) this).context, ((Widget) this).dataCenter);
        this.S = r1;
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
        return;
    L5:
        if (r0.isShowing() != true) goto L7;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final void Dn() {
        Intrinsics.checkNotNullParameter("interact_audience_guest_widget_profile_confirm", "fromSource");
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L20:
        if (r0 != null) goto L23;
        return;
    L23:
        if (r0.intValue() != 2) goto L30;
        f2.b(2131917547, 0);
        return;
    L30:
        return;
    L11:
        if (r0.intValue() != 1) goto L20;
        int r1 = r.a;
        if (r.b(getRoom()) == true) goto L17;
        if (Gq() == true) goto L17;
        return;
    L17:
        if (s0.a(getRoom()) == false) goto L19;
        Pq();
        return;
    L19:
        B();
        return;
    L6:
        if (r0.intValue() != 0) goto L8;
        c2(2, 113, "interact_audience_guest_widget_profile_confirm", null);
    }

    public final boolean Gq() {
        String r2 = null;
        boolean r0 = ((Boolean) vm2.d.p3.getValue(null, vm2.d.a[221(0xdd, float:3.1E-43)])).booleanValue();
        Map r1 = getRoom().getAnchorABMap();
        if (r1 == null) goto L5;
        r2 = (String) r1.get("opt_audience_linkmic");
    L5:
        if (r0 == true) goto L7;
    L11:
        return false;
    L7:
        if (Intrinsics.areEqual(r2, String.valueOf(1)) == false) goto L9;
        return true;
    L9:
        if (Intrinsics.areEqual(r2, String.valueOf(3)) == false) goto L11;
        return true;
    }

    public final long Jq() {
        if (this.L >= 0) goto L6;
        this.L = (this.K - this.R) / ((long) 1000);
    L6:
        return this.L;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.u
    public final void Qc() {
        if (this.x == false) goto L8;
        RtcManager r0 = this.d;
        if (r0 == null) goto L9;
        r0.N0(false, "audience background before start engine");
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final SurfaceView R0() {
        InteractAudienceVideoWindowManager r0 = this.z;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final void disconnect() {
        IRoom r0 = this.B;
        if (r0 == null) goto L5;
        IBaseUser r1 = r0.getBaseOwner();
    L6:
        j0.a r2 = new j0.a(((Widget) this).context);
        Object[] r3 = new Object[1];
        if (r1 == null) goto L9;
        String r4 = r1.getNickName();
    L10:
        r3[0] = r4;
        r2.a = s1.C(2131917528, r3);
        r2.b(s1.B(2131916227), new c(this));
        r2.a(s1.B(2131915442), d.a);
        r2.c();
        return;
    L9:
        r4 = "";
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.base.e
    public final y getLinkUserCenter() {
        if (this.y == null) goto L5;
    L14:
        y r0 = this.y;
        if (r0 == null) goto L18;
        return r0;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.base.ILinkUserInfoCenter<com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge>");
    L5:
        if (vm2.d.q0().isUserInfoCenterForwardInit() == false) goto L13;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if ((r1 instanceof y) == true) goto L9;
        r1 = null;
    L9:
        y r2 = (y) r1;
        if (r2 != null) goto L12;
        r2 = new y(getRoom(), ((Widget) this).dataCenter);
    L12:
        this.y = r2;
        goto L14
    L13:
        this.y = new y(getRoom(), ((Widget) this).dataCenter);
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final com.bytedance.android.live.pushstream.d getLiveStream() {
        m00.d r0 = this.E;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveStream();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final boolean isEngineOn() {
        RtcManager r0 = this.d;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.l;
    }

    public final boolean l5() {
        m00.d r0 = this.E;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isCameraOpen();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAdminLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        ILinkPanelService r1 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r1 == null) goto L6;
        r1.close();
    L6:
        if (vm2.d.f() == false) goto L8;
        Iq().e();
    L8:
        boolean r2 = jc1.k.n(IMultiLinkServiceExternal.class).getControlServiceExternal().c();
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L11;
        String r4 = (String) r3.get("data_room_unique_id", "");
    L12:
        tc0.c.i(r4).O = null;
        RtcManager r5 = this.d;
        if (r5 != null) goto L15;
    L54:
        String r6 = "params";
    L55:
        com.bytedance.android.live.liveinteract.utils.g0 r7 = this.W;
        if (r7 == null) goto L58;
        int r8 = com.bytedance.android.live.liveinteract.utils.g0.g;
        r7.c(0);
    L58:
        SwitchCameraManager r9 = this.T;
        if (r9 == null) goto L63;
        r9.a.dispose();
        vlc.d r10 = r9.b;
        if (r10 == null) goto L63;
        r10.removeMessageListener(r9);
    L63:
        jg6.a r11 = getScopeServiceInMultiLinkRoom(cg6.a.class).e5();
        if (r11 == null) goto L68;
        lh6.b r12 = r11.a();
        if (r12 == null) goto L68;
        r12.o(null, "interact audience guest widget end");
    L68:
        vlc.d r13 = this.G;
        if (r13 == null) goto L71;
        r13.removeMessageListener(this);
    L71:
        com.bytedance.android.live.liveinteract.linksecurity.a r14 = com.bytedance.android.live.liveinteract.linksecurity.a.g;
        LinkedHashMap r15 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r16 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r17 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, r6);
        Intrinsics.checkNotNullParameter(r16, "callback");
        Intrinsics.checkNotNullParameter(r17, "config");
        r14.c("on_link_destroyed", r15, r16, r17);
        super.onDestroy();
        if (Eq() == false) goto L83;
        RtcManager r18 = this.d;
        if (r18 == null) goto L83;
        if (r18.l != true) goto L83;
        dg6.a r19 = r18.r();
        RtcManager r20 = this.d;
        if (r20 == null) goto L80;
        r20.f = this;
    L80:
        ((IMultiPkAudienceLinkOutService) jc1.k.n(IMultiPkAudienceLinkOutService.class)).setRevGuestManagerData(pg6.a.c(r19), this.E);
        ILinkerBattleConnectContent r21 = this.q;
        if (r21 == null) goto L83;
        ((IMultiPkAudienceLinkOutService) jc1.k.n(IMultiPkAudienceLinkOutService.class)).setLinkerContentMap(r21);
    L83:
        com.bytedance.android.live.liveinteract.utils.d r22 = jf0.c.a;
        TalkRoomLogUtils.Q(null, null, 7);
        long r23 = this.R;
        IRoom r24 = this.B;
        if (r24 == null) goto L87;
        ICircleInfo r25 = r24.getCircleInfo();
        if (r25 == null) goto L87;
    L88:
        HashMap r26 = new HashMap();
        r26.put("live_type", "video_live");
        r26.put("function_type", "audience");
        r26.put("function_type2", "audience");
        r26.put("duration", String.valueOf((System.currentTimeMillis() - r23) / ((long) 1000)));
        if (r25 == null) goto L93;
        String r27 = r25.getCircleName();
        if (r27 == null) goto L93;
        r26.put("circle_name", r27);
    L93:
        y r28 = (y) ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r28 == null) goto L96;
        int r29 = r28.n();
    L98:
        if (r29 <= 0) goto L100;
        Object r30 = "1";
    L101:
        r26.put("is_set_seat_name", r30);
        if (r28 == null) goto L104;
        Integer r31 = Integer.valueOf(r28.n());
    L105:
        r26.put("seat_num", String.valueOf(r31));
        String r32 = "on";
        if (jf0.c.g() == false) goto L108;
        Object r33 = "on";
    L109:
        r26.put("seat_fit_status", r33);
        if (hd0.c.f().g != 1) goto L112;
        boolean r34 = true;
    L114:
        if (com.bytedance.android.live.liveinteract.voicechat.util.e.a(r34) == false) goto L116;
        r26.put("is_pre_link", "1");
    L117:
        TalkRoomLogUtils.O0(r26);
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L120;
        r26.put("function_type", "new_audience");
        r26.put("function_type2", "new_audience");
    L121:
        com.bytedance.live.datacontext.m r35 = com.bytedance.android.live.liveinteract.api.utils.m.i().X1();
        if (r35 != null) goto L124;
    L125:
        com.bytedance.live.datacontext.m r36 = com.bytedance.android.live.liveinteract.api.utils.m.i().n2();
        if (r36 != null) goto L128;
    L130:
        r32 = "off";
    L131:
        r26.put("earphone_status", r32);
        r26.put("play_mode", com.bytedance.android.live.liveinteract.plantform.utils.u0.b());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_voice_room_watch_duration", r26, new Object[]{IRoom.class, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        this.Q = false;
        this.D.dispose();
        if (r2 == true) goto L142;
        m00.d r37 = this.E;
        if (r37 == null) goto L136;
        r37.release();
    L136:
        Integer r38 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r38 != null) goto L140;
    L141:
        Cq();
        goto L142
    L140:
        if (r38.intValue() != 0) goto L141;
    L142:
        DataCenter r39 = ((Widget) this).dataCenter;
        if (r39 == null) goto L145;
        r39.put("data_interact_audience_video_translation", Boolean.FALSE);
    L145:
        tc0.c.h().j(Boolean.FALSE);
        InteractAudienceVideoWindowManager r40 = this.z;
        if (r40 == null) goto L148;
        r40.p();
    L148:
        if (r2 == true) goto L150;
        xs2.b.a().post(new a1(15));
    L150:
        this.V.b();
        Disposable r41 = this.O;
        if (r41 == null) goto L153;
        r41.dispose();
    L153:
        PaidLinkMicContext r42 = PaidLinkMicContext.Companion.getContext();
        if (r42 == null) goto L158;
        com.bytedance.live.datacontext.n<py.k> r43 = r42.getAnonymousGuestImageModel();
        if (r43 == null) goto L158;
        r43.setValue(null);
    L158:
        r14.l();
        com.bytedance.android.livesdk.chatroom.utils.g0.a();
        com.bytedance.live.datacontext.j r44 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r44 == null) goto L164;
        LivePlayModeLogContext r45 = (LivePlayModeLogContext) r44.getValue();
        if (r45 == null) goto L165;
        r45.clearPlayModesOnlySupportMultiPeople();
        return;
    L165:
        return;
    L164:
        return;
    L128:
        if (((Boolean) r36.getValue()).booleanValue() != true) goto L130;
    L124:
        if (((Boolean) r35.getValue()).booleanValue() == true) goto L131;
    L120:
        r26.put("function_type", "audience");
        r26.put("function_type2", "audience");
        goto L121
    L116:
        r26.put("is_pre_link", "0");
        goto L117
    L112:
        r34 = false;
        goto L114
    L108:
        r33 = "off";
        goto L109
    L104:
        r31 = null;
        goto L105
    L100:
        r30 = "0";
        goto L101
    L96:
        r29 = 0;
    L87:
        r25 = null;
        goto L88
    L15:
        if (r5.l != true) goto L54;
        DataCenter r46 = ((Widget) this).dataCenter;
        if (r46 == null) goto L19;
        r46.put("data_link_mic_is_quick_invite", Boolean.FALSE);
    L19:
        this.U.i = this.V.b;
        com.bytedance.android.live.liveinteract.plantform.core.n r47 = this.b;
        if (r47 != null) goto L22;
    L24:
        com.bytedance.live.datacontext.m r48 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).y();
        if (r48 != null) goto L27;
    L30:
        String r49 = "leave_normally";
    L29:
        String r50 = r49;
        fj0.a r51 = fj0.b.a;
        fj0.a r52 = fj0.b.a;
        if (r52.b == true) goto L34;
    L36:
        long r110 = 0;
        if (fj0.e.i() == false) goto L50;
        Map<String, String> r53 = this.U.j;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r53.put("recharge_price", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.d()));
        if (fj0.e.g(getRoom()) == false) goto L49;
        n0 r54 = tc0.c.h().P;
        if (r54 == null) goto L43;
        long r111 = r54.getPaidAmount();
    L44:
        long r112 = r111 - ((long) com.bytedance.android.live.liveinteract.api.data.a.C0017a.d());
        Map<String, String> r55 = this.U.j;
        if (r112 >= 0) goto L48;
        r112 = r52.f;
    L48:
        r55.put("add_price", String.valueOf(r112));
        goto L49
    L43:
        r111 = 0;
    L49:
        this.U.j.put("time", String.valueOf(fj0.a.b()));
        b1 r56 = (b1) com.bytedance.android.livesdk.sharedpref.c.g1.getValue();
        this.U.j.put("rechargeable_label", fj0.b.i(r56.getSavedTagInfos()));
        this.U.j.put("rechargeable_intro", r56.getSavedDesc());
    L50:
        com.bytedance.android.live.liveinteract.utils.d r57 = jf0.c.a;
        IRoom r58 = this.B;
        com.bytedance.android.live.liveinteract.utils.d r113 = this.U;
        long r114 = this.M;
        m00.d r115 = this.E;
        if (r115 == null) goto L53;
        r110 = r115.b();
    L53:
        jf0.c.h(r58, r50, r113, r114, r110, Long.valueOf((this.M - this.K) / ((long) 1000)), Long.valueOf(Jq()));
        fj0.e.n(false);
        r52.b = false;
        com.bytedance.android.live.liveinteract.utils.k r59 = ((IInteractService) jc1.k.n(IInteractService.class)).getInteractLogUtils();
        com.bytedance.android.live.liveinteract.utils.d r60 = this.U;
        ((jf0.c) r59).getClass();
        r6 = "params";
        Intrinsics.checkNotNullParameter(r60, r6);
        jf0.c.a = r60;
        goto L55
    L34:
        if (fj0.e.i() == false) goto L36;
        this.U.j.put("recharge_mode", "normal");
        goto L36
    L27:
        if (((Boolean) r48.getValue()).booleanValue() != true) goto L30;
    L28:
        r49 = "live_end";
        goto L29
    L22:
        if (r47.f != true) goto L24;
    L11:
        r4 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.g0
    public final void onFirstRemoteVideoSend() {
        IMultiPkAudienceLinkOutService r0 = (IMultiPkAudienceLinkOutService) jc1.k.f(IMultiPkAudienceLinkOutService.class);
        if (r0 == null) goto L5;
        r0.onFirstRemoteVideoSend();
    L5:
        RtcManager r1 = this.d;
        if (r1 == null) goto L9;
        r1.f = null;
        return;
    }

    public InteractAudienceGuestWidget() {
        super(tc0.c.h());
        this.D = new CompositeDisposable();
        this.H = "";
        this.I = "";
        this.J = 300;
        this.L = -1;
        this.N = 180000;
        this.U = new com.bytedance.android.live.liveinteract.utils.d(null);
        this.V = new k0();
        this.X = LazyKt.lazy(new InteractAudienceGuestWidget$mInteractLiveCorePermissionGuarantor$2(this));
        this.Y = new l(this);
        this.Z = new e(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget
    public final void Cq() {
        super.Cq();
        InteractAudienceVideoWindowManager r0 = this.z;
        if (r0 == null) goto L5;
        r0.A(true);
    L5:
        Runnable r1 = this.F;
        if (r1 == null) goto L8;
        r1.run();
    L8:
        this.F = null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final int H() {
        return getLinkUserCenter().b();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void M1() {
        super.M1();
        com.bytedance.android.live.liveinteract.plantform.base.g r0 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r0 == null) goto L5;
        r0.Sc();
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L8;
        r1.put("data_interact_debug_info", new jd0.e());
    L8:
        this.E = null;
        com.bytedance.android.live.liveinteract.plantform.core.n r2 = this.b;
        if (r2 == null) goto L12;
        r2.g = false;
        return;
    }

    public final void Nq() {
        if (getContext() != null) goto L5;
        return;
    L5:
        if (((Widget) this).dataCenter == null) goto L16;
        InteractAudienceGuestApplyDialog r0 = new InteractAudienceGuestApplyDialog(getContext(), ((Widget) this).dataCenter);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        return;
    }

    public final void Pq() {
        ILinkPanelService r0 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r0 == null) goto L6;
        Context r1 = ((Widget) this).context;
        IRoom r2 = getRoom();
        i0 r3 = TalkRoomLogUtils.a;
        ILinkPanelService.a.a(r0, r1, r2, null, TalkRoomLogUtils.w(this.U.d, LinkApplyType.NORMAL));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o() {
        super.o();
        com.bytedance.android.livesdk.sharedpref.e r0 = b6.D;
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, 1);
        if (this.x == false) goto L11;
        RtcManager r1 = this.d;
        if (r1 == null) goto L11;
        if (r1.l != true) goto L11;
        if (this.P != 0) goto L14;
        r1.onPause();
        this.P = 3;
    L14:
        this.M = System.currentTimeMillis();
        fj0.a r2 = fj0.b.a;
        fj0.a r3 = fj0.b.a;
        if (r3.b == false) goto L20;
        if (fj0.e.i() == false) goto L20;
        this.U.j.put("recharge_mode", "normal");
    L20:
        if (fj0.e.i() == false) goto L36;
        Map<String, String> r4 = this.U.j;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r4.put("recharge_price", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.d()));
        if (fj0.e.g(this.B) == false) goto L32;
        n0 r5 = tc0.c.h().P;
        if (r5 == null) goto L26;
        long r6 = r5.getPaidAmount();
    L27:
        long r7 = r6 - ((long) com.bytedance.android.live.liveinteract.api.data.a.C0017a.d());
        Map<String, String> r8 = this.U.j;
        if (r7 < 0) goto L30;
        String r9 = String.valueOf(r7);
    L31:
        r8.put("add_price", r9);
        goto L32
    L30:
        r9 = String.valueOf(r3.f);
        goto L31
    L26:
        r6 = 0;
    L32:
        this.U.j.put("time", String.valueOf(fj0.a.b()));
        b1 r10 = (b1) com.bytedance.android.livesdk.sharedpref.c.g1.getValue();
        this.U.j.put("rechargeable_label", fj0.b.i(r10.getSavedTagInfos()));
        this.U.j.put("rechargeable_intro", r10.getSavedDesc());
        if (fj0.e.d() == false) goto L35;
        this.U.j.put("anonymous_switch", "on");
        goto L36
    L35:
        this.U.j.put("anonymous_switch", "off");
    L36:
        com.bytedance.android.live.liveinteract.utils.d r11 = this.U;
        r11.l = (this.M - this.K) / ((long) 1000);
        r11.m = Jq();
        com.bytedance.android.live.liveinteract.utils.d r12 = jf0.c.a;
        jf0.c.j(this.B, this.U);
        InteractAudienceVideoWindowManager r13 = this.z;
        if (r13 == null) goto L39;
        r13.A(false);
    L39:
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L42;
        r14.put("data_interact_debug_info", new jd0.e());
    L42:
        com.bytedance.android.live.liveinteract.plantform.base.g r15 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r15 == null) goto L52;
        DataCenter r16 = ((Widget) this).dataCenter;
        if (r16 == null) goto L49;
        Boolean r17 = (Boolean) r16.get("data_is_anchor", Boolean.FALSE);
        if (r17 == null) goto L49;
        boolean r18 = r17.booleanValue();
    L50:
        r15.o6("normal", r18);
    L49:
        r18 = false;
    L52:
        if (hd0.c.f().g == 2) goto L56;
        com.bytedance.android.livesdk.sharedpref.e r19 = b6.E;
        if (((Boolean) r19.getValue()).booleanValue() == false) goto L56;
        com.bytedance.android.livesdk.sharedpref.f.d(r19, Boolean.FALSE);
        f2.b(2131917575, 0);
    L58:
        if (fj0.e.i() == false) goto L60;
        jc1.k.n(IMultiRechargeServiceExternal.class).rechargeCenter().sync("paid_link");
    L60:
        String r20 = tc0.c.h().f;
        if (r20 != null) goto L63;
    L66:
        boolean r21 = true;
    L67:
        if (r21 == true) goto L69;
        this.V.c(r20, false);
    L70:
        com.bytedance.android.live.liveinteract.plantform.core.n r22 = this.b;
        if (r22 == null) goto L74;
        r22.g = true;
        r22.f = false;
        return;
    L74:
        return;
    L69:
        this.V.b();
        goto L70
    L63:
        if (r20.length() == 0) goto L66;
        r21 = false;
    L56:
        f2.b(2131917511, 0);
    L11:
        RtcManager r23 = this.d;
        if (r23 == null) goto L14;
        r23.N0(true, "interact audience start rtc");
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseAdminLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        Lazy r0 = MultiComponentManager.e;
        MultiComponentManager.a.a().a(this, ((Widget) this).context, ((Widget) this).dataCenter);
        getScopeServiceInMultiLinkRoom(cg6.a.class).init(((Widget) this).context);
        this.R = System.currentTimeMillis();
        this.w.setScene(4);
        tc0.c.h();
        this.B = (IRoom) ((Widget) this).dataCenter.get("data_room");
        com.bytedance.android.live.liveinteract.utils.d r1 = jf0.c.a;
        jf0.c.i();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r12 = null;
        TalkRoomLogUtils.S(null, null, 7);
        getLinkUserCenter().Q4(this.Z);
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r2 = MultiRevenueDataContext.a.d();
        if (r2 == null) goto L5;
        r2.m(this, SceneType.SCENE_INTERACT_AUDIENCE);
    L5:
        IRoom r3 = this.B;
        View r4 = ((Widget) this).contentView;
        if (r4 == null) goto L168;
        FrameLayout r5 = (FrameLayout) r4;
        y r6 = this.y;
        FragmentActivity r7 = ((Widget) this).context;
        if (r7 == null) goto L166;
        InteractAudienceVideoWindowManager r8 = new InteractAudienceVideoWindowManager(r3, false, r5, r6, r7, this);
        this.z = r8;
        r8.y(((Widget) this).dataCenter);
        InteractAudienceVideoWindowManager r9 = this.z;
        if (r9 == null) goto L12;
        r9.l = new f(this);
    L12:
        ((jf0.c) ((IInteractService) jc1.k.n(IInteractService.class)).getInteractLogUtils()).getClass();
        com.bytedance.android.live.liveinteract.utils.d r10 = jf0.c.a;
        if (r10 == null) goto L15;
        this.U = r10;
    L15:
        InteractAudienceVideoWindowManager r11 = this.z;
        if (r11 == null) goto L18;
        r11.a = this.A;
        r11.i(true);
    L18:
        InteractAudienceVideoWindowManager r13 = this.z;
        if (r13 == null) goto L21;
        r13.z(true);
    L21:
        com.bytedance.android.live.liveinteract.utils.d r14 = this.U;
        IRoom r15 = this.B;
        if (r15 == null) goto L25;
        String r16 = r15.getAnchorId();
        if (r16 == null) goto L25;
    L26:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r14.f = r16;
        jg6.a r17 = getScopeServiceInMultiLinkRoom(cg6.a.class).e5();
        if (r17 == null) goto L31;
        lh6.b r18 = r17.a();
        if (r18 == null) goto L31;
        r18.o(this, "interact audience guest widget create");
    L31:
        SwitchCameraManager r19 = new SwitchCameraManager(((Widget) this).context, ((Widget) this).dataCenter, getLinkUserCenter(), this);
        this.T = r19;
        r19.k();
        com.bytedance.android.live.liveinteract.utils.d r20 = this.U;
        IRoom r21 = this.B;
        if (r21 == null) goto L34;
        long r22 = r21.getId();
    L35:
        r20.e = r22;
        Pair r23 = com.bytedance.live.datacontext.d.a(InteractAudienceGuestWidget$onCreate$dataPair$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r23.getFirst(), "interact_guest_service");
        ((InteractGuestContext) r23.getFirst()).getService().d(this);
        this.D.add((Disposable) r23.getSecond());
        Pair r24 = com.bytedance.live.datacontext.d.a(InteractAudienceGuestWidget$onCreate$dataPair2$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r24.getFirst(), "interact_admin_service");
        ((InteractAdminContext) r24.getFirst()).getService().d(this);
        this.D.add((Disposable) r24.getSecond());
        Pair r25 = com.bytedance.live.datacontext.d.a(AnonymousClass3.INSTANCE);
        GuestApplyViewModel r26 = (GuestApplyViewModel) r25.component1();
        Disposable r27 = (Disposable) r25.component2();
        com.bytedance.live.datacontext.b.a(r26, GuestApplyViewModel.TAG);
        this.D.add(r27);
        DataCenter r28 = ((Widget) this).dataCenter;
        if (r28 == null) goto L38;
        vlc.d r29 = (vlc.d) r28.get("data_message_manager");
    L39:
        this.G = r29;
        if (r29 == null) goto L42;
        r29.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getKey(), this);
    L42:
        vlc.d r30 = this.G;
        if (r30 == null) goto L46;
        r30.addMessageListener(MessageType.LINKER.getKey(), this);
    L46:
        if (this.G == null) goto L48;
        this.D.add((Disposable) com.bytedance.live.datacontext.d.a(new AnonymousClass4(this)).getSecond());
    L48:
        InteractAudienceVideoWindowManager r31 = this.z;
        if (r31 == null) goto L58;
        RtcManager r32 = this.d;
        if (r32 != null) goto L53;
    L56:
        boolean r33 = true;
    L57:
        r31.A(r33);
        goto L58
    L53:
        if (r32.l == false) goto L56;
        r33 = false;
    L58:
        RtcManager r34 = this.d;
        if (r34 == null) goto L70;
        if (r34.l != true) goto L70;
        v0 r35 = this.c;
        if ((r35 instanceof m00.d) == true) goto L65;
        r35 = null;
    L65:
        this.E = (m00.d) r35;
        hd0.c.f().k(2);
        RtcManager r36 = this.d;
        if (r36 == null) goto L68;
        r36.N0(true, "interact audience create");
    L68:
        jf0.c.j(getRoom(), this.U);
    L73:
        RtcManager r37 = this.d;
        if (r37 != null) goto L76;
    L94:
        com.bytedance.android.livesdk.sharedpref.e r38 = b6.C;
        if (((Boolean) r38.getValue()).booleanValue() == true) goto L100;
        if (tb1.c.c == true) goto L100;
        com.bytedance.android.livesdk.sharedpref.f.d(r38, Boolean.TRUE);
    L100:
        if (vm2.d.f() == true) goto L102;
    L108:
        this.D.add(xs2.b.a().b(h1.class).subscribe(new g(this)));
        com.bytedance.android.live.liveinteract.plantform.base.g r39 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r39 == null) goto L111;
        boolean r40 = r39.W1();
    L112:
        HashMap<String, Integer> r41 = IInteractService.micRoomHostStateMap;
        if (r41 != null) goto L115;
    L118:
        Integer r42 = 0;
    L119:
        if (r42 == null) goto L135;
        int r43 = r42.intValue();
        RtcManager r44 = this.d;
        if (r44 != null) goto L123;
    L125:
        fj0.b.a.b = false;
        if (r43 <= 0) goto L128;
        int r45 = bh0.a.a;
        c2(r43, 100, "host_auto_apply", null);
        goto L135
    L128:
        t r46 = com.bytedance.android.livesdk.log.j0.l().c(x.class);
        if ((r46 instanceof t) == false) goto L135;
        if (TextUtils.equals(r46.l(), "true") == false) goto L135;
        if (((Boolean) ((Widget) this).dataCenter.get("data_strong_reach_auto_apply_already", Boolean.FALSE)).booleanValue() == true) goto L135;
        ((Widget) this).dataCenter.put("data_strong_reach_auto_apply_already", Boolean.TRUE);
        com.bytedance.android.live.liveinteract.utils.d r47 = this.U;
        r47.d = 107;
        Intrinsics.checkNotNullParameter("invite_mutual", "<set-?>");
        r47.b = "invite_mutual";
        BaseGuestLinkWidget.wq(this, 2, 16, LinkApplyType.STRONG_REACH, "auto_apply_remind", null, null, false, false, 0, null, 8160);
        goto L135
    L123:
        if (r44.l != true) goto L125;
        return;
    L135:
        this.W = new com.bytedance.android.live.liveinteract.utils.g0(this.B, getLinkUserCenter());
        if (this.A == true) goto L143;
        if (PaidLinkMicContext.Companion.a() == null) goto L143;
        DataCenter r48 = ((Widget) this).dataCenter;
        if (r48 == null) goto L143;
        r48.put("data_paid_link_profile_show", Boolean.FALSE);
    L143:
        if (vm2.d.U0() == false) goto L149;
        com.bytedance.live.datacontext.k r49 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).L();
        if (r49 == null) goto L149;
        PublishSubject r50 = r49.onEvent();
        if (r50 == null) goto L149;
        RxUtilKt.p(r50, "interact_admin_service", new AnonymousClass9(this));
    L149:
        com.bytedance.android.live.liveinteract.linksecurity.a.g.k(((Widget) this).dataCenter);
        TalkRoomLogUtils.x = null;
        if (vm2.d.y() == true) goto L152;
        return;
    L152:
        if (vm2.d.x() == false) goto L170;
        com.bytedance.live.datacontext.j r51 = com.bytedance.android.live.liveinteract.api.utils.m.k(this, ((Widget) this).dataCenter).getCompactTbLoader();
        if (r51 == null) goto L156;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r52 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) r51.getValue();
    L158:
        if ((r52 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) == false) goto L161;
        r12 = r52;
    L161:
        if (r12 == null) goto L163;
        r12.refreshExistComponent(26);
    L163:
        ALogger.i("guest_video_talk", "[LinkmicIconDoubleCheck] interactAudienceGuestWidget load refresh icon");
        return;
    L156:
        r52 = null;
        goto L158
    L170:
        return;
    L115:
        if (r41.containsKey("is_host_auto_apply") == false) goto L118;
        if (r40 == false) goto L118;
        r42 = r41.get("is_host_auto_apply");
        r41.remove("is_host_auto_apply");
        goto L119
    L111:
        r40 = false;
        goto L112
    L102:
        if ((getContext() instanceof FragmentActivity) == false) goto L108;
        InteractLiveCorePermissionGuarantor r53 = Iq();
        Context r54 = getContext();
        if (r54 == null) goto L107;
        r53.i((FragmentActivity) r54);
        goto L108
    L107:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L76:
        if (r37.l != true) goto L94;
        DataCenter r55 = ((Widget) this).dataCenter;
        if (r55 == null) goto L80;
        String r56 = (String) r55.get("data_room_unique_id", "");
    L82:
        if (tc0.c.i(r56).O == null) goto L94;
        DataCenter r57 = ((Widget) this).dataCenter;
        if (r57 == null) goto L86;
        String r58 = (String) r57.get("data_room_unique_id", "");
    L87:
        l6 r59 = tc0.c.i(r58).O;
        if (r59 == null) goto L92;
        List r60 = r59.getMLinkUsers();
        if (r60 == null) goto L92;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r61 = jm2.a.a(r60);
    L93:
        Tq(r61);
    L92:
        r61 = null;
        goto L93
    L86:
        r58 = null;
        goto L87
    L80:
        r56 = null;
    L70:
        if (hd0.c.f().j() == true) goto L72;
        hd0.c.f().k(0);
    L72:
        Cq();
        goto L73
    L38:
        r29 = null;
        goto L39
    L34:
        r22 = 0;
    L25:
        r16 = "0";
        goto L26
    L166:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L168:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget
    public final void onPause() {
        super.onPause();
        if (jc1.k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().getPkState() != 1) goto L5;
        boolean r0 = true;
    L7:
        if (jc1.k.n(IMultiLinkServiceExternal.class).getControlServiceExternal().c() == true) goto L24;
        if (r0 == true) goto L27;
        this.x = true;
        RtcManager r1 = this.d;
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.l == true) goto L15;
        return;
    L15:
        if (vm2.d.f() == false) goto L18;
        Iq().f();
    L18:
        if (vm2.d.f() == true) goto L20;
    L21:
        Kq("pause", false);
    L22:
        this.O = Observable.timer(this.N, TimeUnit.MILLISECONDS).subscribe(new k(this));
        return;
    L20:
        if (Iq().p == true) goto L22;
    L27:
        return;
    L24:
        return;
    L5:
        r0 = false;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget
    public final void onResume() {
        super.onResume();
        cg6.a r0 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 == null) goto L5;
        r0.onResume();
    L5:
        this.x = false;
        Disposable r1 = this.O;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        RtcManager r2 = this.d;
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.l == true) goto L13;
        return;
    L13:
        if (vm2.d.f() == false) goto L16;
        Iq().g();
    L16:
        if (vm2.d.f() == true) goto L18;
    L21:
        Lq("resume");
    L22:
        com.bytedance.android.livesdk.chatroom.utils.g0.c(4);
        com.bytedance.android.livesdk.chatroom.utils.g0.b();
        ((Widget) this).dataCenter.put("cmd_interact_state_change", new a1(3));
        return;
    L18:
        if (Iq().p == true) goto L22;
        if (Iq().i == true) goto L22;
        goto L21
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        if (vm2.d.f() == false) goto L6;
        Iq().h();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final com.bytedance.android.live.liveinteract.plantform.core.n W4() {
        return this.b;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final boolean isCurrentLinkPaid() {
        return this.i;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final InteractAudienceVideoWindowManager windowManager() {
        return this.z;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.base.e
    public final void F3(String r14) {
        Intrinsics.checkNotNullParameter(r14, "reqFrom");
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.put("data_link_mic_is_quick_invite", Boolean.FALSE);
    L5:
        this.U.i = this.V.b;
        fj0.a r1 = fj0.b.a;
        fj0.a r2 = fj0.b.a;
        if (r2.b == true) goto L8;
    L10:
        long r3 = 0;
        if (fj0.e.i() == false) goto L24;
        Map<String, String> r4 = this.U.j;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r4.put("recharge_price", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.d()));
        if (fj0.e.g(getRoom()) == false) goto L23;
        n0 r5 = tc0.c.h().P;
        if (r5 == null) goto L17;
        long r6 = r5.getPaidAmount();
    L18:
        long r7 = r6 - ((long) com.bytedance.android.live.liveinteract.api.data.a.C0017a.d());
        Map<String, String> r8 = this.U.j;
        if (r7 >= 0) goto L22;
        r7 = r2.f;
    L22:
        r8.put("add_price", String.valueOf(r7));
        r2.f = 0;
        goto L23
    L17:
        r6 = 0;
    L23:
        this.U.j.put("time", String.valueOf(fj0.a.b()));
        b1 r9 = (b1) com.bytedance.android.livesdk.sharedpref.c.g1.getValue();
        this.U.j.put("rechargeable_label", fj0.b.i(r9.getSavedTagInfos()));
        this.U.j.put("rechargeable_intro", r9.getSavedDesc());
    L24:
        com.bytedance.android.live.liveinteract.utils.d r10 = jf0.c.a;
        IRoom r11 = this.B;
        com.bytedance.android.live.liveinteract.utils.d r12 = this.U;
        long r13 = this.M;
        m00.d r15 = this.E;
        if (r15 == null) goto L27;
        r3 = r15.b();
    L27:
        jf0.c.h(r11, r14, r12, r13, r3, Long.valueOf((this.M - this.K) / ((long) 1000)), Long.valueOf(Jq()));
        super.F3(r14);
        return;
    L8:
        if (fj0.e.i() == false) goto L10;
        this.U.j.put("recharge_mode", "normal");
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.s
    public final void Fc(z0 r3) {
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        hd0.c r0 = hd0.c.f();
        r0.g = r3.getLinkType();
        super.Fc(r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.s
    public final void G2(d9 r3) {
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        ALogger.i("ttlive_link_paid", "onPaidLinkConfigChanged " + r3);
        ab r4 = r3.getPaidOrTimeLimitChangeContent();
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.isNeedLeave() == true) goto L8;
        return;
    L8:
        if (hd0.c.f().j() == false) goto L23;
        com.bytedance.android.live.liveinteract.plantform.core.n r0 = this.b;
        if (r0 == null) goto L12;
        tf0.g.a(r0, "paid_change");
    L12:
        String r1 = r4.getToast();
        if (r1 != null) goto L15;
    L18:
        boolean r2 = true;
    L19:
        if (r2 == true) goto L24;
        f2.c(r4.getToast(), 0);
        return;
    L24:
        return;
    L15:
        if (r1.length() == 0) goto L18;
        r2 = false;
        goto L19
    }

    public final void Lq(String r2) {
        getLinkUserCenter().r0();
        if (this.P != 3) goto L8;
        RtcManager r3 = this.d;
        if (r3 == null) goto L7;
        r3.onResume();
    L7:
        this.P = 0;
    L8:
        m00.d r4 = this.E;
        if (r4 == null) goto L14;
        d0 r5 = r4.getLiveCore();
        if (r5 == null) goto L15;
        r5.e();
        return;
    L15:
        return;
    }

    public final void Mq(boolean r6) {
        if (jc1.k.n(IMiddlewareUserService.class).user().isLogin() == true) goto L7;
        com.bytedance.android.livesdk.user.e r7 = jc1.k.n(IMiddlewareUserService.class).user();
        Context r0 = ((Widget) this).context;
        com.bytedance.android.livesdk.user.l.a r2 = new com.bytedance.android.livesdk.user.l.a();
        r2.a = s1.B(2131919339);
        r2.d = "interact";
        r2.c = 0;
        r7.login(r0, new com.bytedance.android.livesdk.user.l(r2)).compose(getAutoUnbindTransformer()).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L7:
        if (vm2.d.p0() == true) goto L9;
    L19:
        Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r6 == false) goto L33;
        IRoom r8 = this.B;
        if (r8 == null) goto L24;
        LiveMode r9 = r8.getStreamType();
    L26:
        if (r9 != LiveMode.THIRD_PARTY) goto L33;
        if (r1 == null) goto L33;
        if (r1.intValue() != 0) goto L33;
        qj0.b.a r10 = new qj0.b.a(getContext());
        r10.a = s1.B(2131917799);
        r10.b = s1.B(2131917796);
        String r3 = s1.B(2131917797);
        r10.c = i.a;
        r10.d = r3;
        String r4 = s1.B(2131917798);
        r10.e = new j(this);
        r10.f = r4;
        r10.a();
        return;
    L24:
        r9 = null;
    L33:
        com.bytedance.android.live.liveinteract.utils.d r11 = jf0.c.a;
        jf0.c.e("livesdk_audience_interaction_icon_click");
        tc0.c.h().G = "bottom";
        if (r1 != null) goto L37;
    L55:
        int r12 = r.a;
        if (r.b(getRoom()) == false) goto L58;
    L59:
        if (r1 != null) goto L62;
    L67:
        Nq();
        return;
    L62:
        if (1 != r1.intValue()) goto L67;
        if (s0.a(getRoom()) == false) goto L66;
        Pq();
        return;
    L66:
        B();
        return;
    L58:
        if (Gq() == false) goto L67;
    L37:
        if (r1.intValue() != 0) goto L55;
        if (fj0.e.i() == false) goto L42;
        com.bytedance.android.live.liveinteract.utils.d r13 = this.U;
        int r5 = bh0.a.a;
        r13.d = 102;
        Intrinsics.checkNotNullParameter("apply", "<set-?>");
        r13.b = "apply";
        Qq(102);
        return;
    L42:
        Integer r14 = (Integer) b6.D.getValue();
        if (r14 != null) goto L46;
    L48:
        int r15 = r.a;
        com.bytedance.android.livesdk.sharedpref.e r16 = b6.c;
        if (((Number) r16.getValue()).intValue() > 0) goto L51;
    L53:
        int r17 = 2;
    L54:
        int r18 = bh0.a.a;
        c2(r17, 102, "interact_icon_click", null);
        return;
    L51:
        if (((Boolean) vm2.d.K2.getValue(null, vm2.d.a[190(0xbe, float:2.66E-43)])).booleanValue() == false) goto L53;
        r17 = ((Number) r16.getValue()).intValue();
        goto L54
    L46:
        if (r14.intValue() != 0) goto L48;
        Nq();
        return;
    L9:
        if (this.a == null) goto L11;
        boolean r19 = true;
    L12:
        if (r19 == false) goto L19;
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.e(getRoom(), null) == false) goto L19;
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.b(getRoom()) == true) goto L19;
        f2.b(2131921181, 0);
        TalkRoomBusinessFullLinkMonitor r20 = TalkRoomBusinessFullLinkMonitor.a;
        boolean r21 = com.bytedance.android.livesdk.chatroom.paidlive.e.e(getRoom(), null);
        boolean r22 = com.bytedance.android.livesdk.chatroom.paidlive.e.b(getRoom());
        r20.getClass();
        TalkRoomBusinessFullLinkMonitor.e0(r21, r22);
        return;
    L11:
        r19 = false;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.s
    public final void Q2(Throwable r14) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.put("data_link_mic_is_quick_invite", Boolean.FALSE);
    L6:
        if ((r14 instanceof ApiServerException) == false) goto L74;
        ApiServerException r15 = (ApiServerException) r14;
        if (r15.getErrorCode() != 4004091) goto L16;
        if (fj0.e.j(getRoom()) == false) goto L12;
    L13:
        Qq(0);
        return;
    L12:
        if (fj0.e.i() == true) goto L13;
    L16:
        if (r15.getErrorCode() != 4004090) goto L20;
        com.bytedance.android.live.liveinteract.plantform.base.g r1 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r1 == null) goto L20;
        r1.Nf();
    L20:
        String r2 = String.valueOf(Integer.valueOf(je0.d.j(getLinkUserCenter())).intValue());
        if (r2 != null) goto L23;
        r2 = "0";
    L23:
        com.bytedance.android.live.liveinteract.utils.d r3 = jf0.c.a;
        com.bytedance.android.live.liveinteract.utils.d r4 = this.U;
        ICircleInfo r5 = getRoom().getCircleInfo();
        Intrinsics.checkNotNullParameter(r15, "throwable");
        Intrinsics.checkNotNullParameter(r4, "logParams");
        Intrinsics.checkNotNullParameter(r2, "linkCnt");
        HashMap r6 = new HashMap();
        jf0.c.a(r6, r4);
        if (hd0.c.f().g != 1) goto L26;
        boolean r7 = true;
    L27:
        if (r7 == false) goto L29;
        String r8 = "video";
    L30:
        r6.put("guest_connection_type", r8);
        if (r15.getErrorCode() != 31101) goto L33;
        r6.put("is_full", "1");
    L34:
        r6.put("connect_type", r4.b);
        gk0.a.b.getClass();
        r6.put("previous_page", gk0.a.C0214a.c());
        if (fj0.e.i() == true) goto L37;
    L39:
        Object r16 = "0";
    L40:
        r6.put("is_rechargeble", r16);
        String r17 = tc0.c.h().F;
        if (r17 != null) goto L43;
        r17 = "";
    L43:
        r6.put("apply_reason", r17);
        String r9 = "on";
        if (fj0.e.i() == false) goto L60;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r6.put("time", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.c()));
        int r18 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.d();
        r6.put("money", String.valueOf(r18));
        if (fj0.e.d() == false) goto L48;
        r6.put("anonymous_switch", "on");
    L49:
        b1 r10 = (b1) com.bytedance.android.livesdk.sharedpref.c.g1.getValue();
        fj0.a r11 = fj0.b.a;
        r6.put("rechargeable_label", fj0.b.i(r10.getSavedTagInfos()));
        r6.put("rechargeable_intro", r10.getSavedDesc());
        PaidLinkMicContext r12 = PaidLinkMicContext.Companion.getContext();
        if (r12 == null) goto L56;
        com.bytedance.live.datacontext.m<Integer> r13 = r12.getDiscountMode();
        if (r13 == null) goto L56;
        Integer r19 = (Integer) r13.getValue();
        if (r19 == null) goto L56;
        int r20 = r19.intValue();
    L57:
        jf0.c.l(r6, r18, r20);
        if (fj0.b.a.g == false) goto L60;
        r6.put("is_vip_recharge_privilege", "1");
    L56:
        r20 = 0;
        goto L57
    L48:
        r6.put("anonymous_switch", "off");
    L60:
        TalkRoomLogUtils.L0(r6);
        if (r5 == null) goto L65;
        String r110 = r5.getCircleName();
        if (r110 == null) goto L65;
        r6.put("circle_name", r110);
    L65:
        r6.put("link_cnt", r2);
        if (jf0.c.g() == true) goto L69;
        r9 = "off";
    L69:
        r6.put("seat_fit_status", r9);
        if (com.bytedance.android.live.liveinteract.voicechat.util.e.a(r7) == false) goto L72;
        r6.put("is_pre_link", "1");
    L73:
        TalkRoomLogUtils.O0(r6);
        f0.b(r6);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_apply", r6, new Object[]{IRoom.class, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L72:
        r6.put("is_pre_link", "0");
        goto L73
    L37:
        if (fj0.b.a.b == false) goto L39;
        r16 = "1";
        goto L40
    L33:
        r6.put("is_full", "0");
        goto L34
    L29:
        r8 = "voice";
        goto L30
    L26:
        r7 = false;
        goto L27
    L74:
        f2.b(2131919229, 0);
    }

    public final void Qq(int r7) {
        if (vm2.d.i0() == false) goto L25;
        String r0 = vm2.d.l().applyLinkSchema;
        if (TextUtils.isEmpty(r0) == true) goto L23;
        HashMap r1 = new HashMap();
        r1.put("live_type", "video_live");
        r1.put("function_type2", "audience");
        int r2 = bh0.a.a;
        if (r7 != 101) goto L10;
        r1.put("request_page", "seat");
    L22:
        String r3 = y0.b(r0, r1);
        ALogger.i("ttlive_link_paid", "applySchema: " + r3);
        jc1.k.n(IBaseLiveActionHandler.class).handle(((Widget) this).context, r3);
        goto L23
    L10:
        if (r7 != 102) goto L13;
        r1.put("request_page", "bottom");
        goto L22
    L13:
        if (r7 != 113) goto L16;
        r1.put("request_page", "card");
        goto L22
    L16:
        if (r7 != 114) goto L19;
        r1.put("request_page", "live_song");
        goto L22
    L19:
        if (tc0.c.h().J == 114) goto L21;
        r1.put("request_page", "");
        goto L22
    L21:
        r1.put("request_page", "live_song");
    L23:
        MultiLinkEventModule r4 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.c(String.valueOf(r7));
        return;
    L25:
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.e() == false) goto L28;
        this.D.add(((LinkPaidLinkApi) com.bytedance.android.live.network.c.b().e(LinkPaidLinkApi.class)).getPaidInfoBeforeApply(getRoom().getId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new m(this), n.a));
        return;
    L28:
        Rq(com.bytedance.android.live.liveinteract.api.data.a.C0017a.d(), com.bytedance.android.live.liveinteract.api.data.a.C0017a.c(), null, null);
    }

    public final void Sq(String r11) {
        String r0 = vm2.d.l().commentSchema;
        com.bytedance.android.livesdk.log.filter.o r1 = com.bytedance.android.livesdk.log.j0.l().c(x.class);
        String r2 = (String) r1.getMap().get("enter_from_merge");
        String r4 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r5 = (String) r1.getMap().get("enter_method");
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        String r3 = (String) r1.getMap().get("action_type");
        if (r3 == null) goto L12;
        r4 = r3;
    L12:
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        String r6 = y0.b(r0, MapsKt.plus(MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("service_provider_id", getRoom().getOwnerUserIdString()), TuplesKt.to("service_order_id", this.h), TuplesKt.to("room_id", String.valueOf(getRoom().getId())), TuplesKt.to("anchor_id", getRoom().getOwnerUserIdString()), TuplesKt.to("live_type", "video_live"), TuplesKt.to("enter_from_merge", r2), TuplesKt.to("enter_method", r5), TuplesKt.to("action_type", r4), TuplesKt.to("function_type", "audience"), TuplesKt.to("limited_time", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.k().b))}), TuplesKt.to("connection_time", String.valueOf(this.H))), TuplesKt.to("connection_cost", String.valueOf(this.I))));
        ALogger.i("ttlive_link_paid", "showPaidLinkCommentDialog from=" + r11 + " handle=" + jc1.k.n(IBaseLiveActionHandler.class).handle(((Widget) this).context, r6) + ' ' + r6);
    }

    public final void Tq(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r8) {
        if (r8 == null) goto L10;
        Iterator<? extends com.bytedance.android.livesdk.link.model.bridge.k> r0 = r8.iterator();
    L5:
        if (r0.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.link.model.bridge.k r1 = r0.next();
        if (TextUtils.equals(r1.getLinkMicIdStr(), tc0.c.h().f) == true) goto L5;
        String r2 = r1.getLinkMicIdStr();
        if (r2 == null) goto L10;
    L11:
        RtcManager r3 = this.d;
        if (r3 == null) goto L15;
        Map<String, yb6.j> r4 = r3.z;
        if (r4 == null) goto L15;
    L16:
        StringBuilder r5 = new StringBuilder("InteractAudienceGuest updateFirstvideoFrame anchorLinkid = ");
        r5.append(r2);
        r5.append(", remoteViews = ");
        r5.append(r4);
        r5.append(", size = ");
        r5.append(r4.size());
        r5.append(",linkUsers = ");
        if (r8 == null) goto L19;
        Integer r6 = Integer.valueOf(r8.size());
    L20:
        r5.append(r6);
        ALogger.i("ttlive_pk", r5.toString());
        Iterator<Map.Entry<String, yb6.j>> r7 = r4.entrySet().iterator();
    L22:
        if (r7.hasNext() == false) goto L47;
        Map.Entry<String, yb6.j> r9 = r7.next();
        String r10 = r9.getKey();
        yb6.j r11 = r9.getValue();
        if (TextUtils.equals(r10, tc0.c.h().f) == true) goto L22;
        Intrinsics.checkNotNullParameter(r10, "linkId");
        if (r8 == null) goto L34;
        Iterator<? extends com.bytedance.android.livesdk.link.model.bridge.k> r12 = r8.iterator();
    L30:
        if (r12.hasNext() == false) goto L34;
        if (TextUtils.equals(r10, r12.next().getLinkMicIdStr()) == false) goto L30;
        boolean r13 = true;
    L35:
        if (r13 == false) goto L22;
        if ((r11 instanceof SurfaceView) == true) goto L38;
        if ((r11 instanceof TextureView) == true) goto L41;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r14 = ILiveWrappedLivePusher.a.b();
        if (r14 == null) goto L45;
        z.a r15 = r14.buildLayerControlLayer(r11);
    L46:
        super.b4(r10, r15, 0, 0);
        goto L22
    L45:
        r15 = null;
        goto L46
    L41:
        super.L0(r10, (TextureView) r11, 0, 0);
        goto L22
    L38:
        h1(r10, (SurfaceView) r11, 0, 0);
    L34:
        r13 = false;
        goto L35
    L47:
        return;
    L19:
        r6 = null;
    L15:
        r4 = MapsKt.emptyMap();
    L10:
        r2 = "";
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.s
    public final void X5(ILinkMicGuideMessageBridge r5) {
        Intrinsics.checkNotNullParameter(r5, MultiLinkOpenSource.MESSAGE);
        if (r5.getGuidelineType() == 1) goto L5;
        return;
    L5:
        if (v.a(((Integer) ((Widget) this).dataCenter.get("data_link_state", 0)).intValue(), 2) == false) goto L7;
        getLinkUserCenter().b();
    L7:
        System.currentTimeMillis();
        ((Number) b6.u.getValue()).longValue();
        ((Boolean) ((Widget) this).dataCenter.get("data_promotion_right_card_container_show", Boolean.FALSE)).booleanValue();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.s
    public final void Y(com.bytedance.android.livesdk.link.model.bridge.h1 r4) {
        Intrinsics.checkNotNullParameter(r4, MultiLinkOpenSource.MESSAGE);
        ILinkerKickOutContent r1 = r4.getMKickOut();
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = String.valueOf(r1.getLink_duration());
    L6:
        this.H = r3;
        ILinkerKickOutContent r5 = r4.getMKickOut();
        if (r5 == null) goto L9;
        r2 = String.valueOf(r5.getPaid_count());
    L9:
        this.I = r2;
        Intrinsics.checkNotNullParameter(r4, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r4, MultiLinkOpenSource.MESSAGE);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.s
    public final void b1(Throwable r2) {
        Bq();
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if ((r2 instanceof ApiServerException) == true) goto L9;
        ExceptionUtils.handleException(((Widget) this).context, r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, uf0.b
    public final void b2(com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.link.model.bridge.i0> r4) {
        Intrinsics.checkNotNullParameter(r4, "response");
        super.b2(r4);
        ChatRoomDistributeTipsDialog.a r0 = ChatRoomDistributeTipsDialog.f;
        Context r1 = ((Widget) this).context;
        a0 r5 = r4.data.castTo(IJoinChannelResult.class).getDelegateSetting();
        r0.getClass();
        ChatRoomDistributeTipsDialog.a.a(r1, r5);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, uf0.b
    public final void c0(Throwable r3) {
        Cq();
        ExceptionUtils.handleException(getContext(), r3, 2131919396);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.s
    public final void f5(com.bytedance.android.livesdk.link.model.bridge.h1 r3) {
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        ILinkerKickOutContent r0 = r3.getMKickOut();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = String.valueOf(r0.getLink_duration());
    L6:
        this.H = r2;
        ILinkerKickOutContent r4 = r3.getMKickOut();
        if (r4 == null) goto L9;
        r1 = String.valueOf(r4.getPaid_count());
    L9:
        this.I = r1;
        super.f5(r3);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.s
    public final void g7(IApplyResult r17) {
        Intrinsics.checkNotNullParameter(r17, "applyResult");
        Intrinsics.checkNotNullParameter(r17, "applyResult");
        this.K = System.currentTimeMillis();
        String r4 = "";
        if (fj0.e.i() == true) goto L5;
        tc0.c.h().F = "";
    L5:
        this.U.a = r17.getAutoJoin();
        this.U.h = ((Boolean) ((Widget) this).dataCenter.get("data_link_mic_is_quick_invite", Boolean.FALSE)).booleanValue();
        String r3 = String.valueOf(Integer.valueOf(je0.d.j(getLinkUserCenter())).intValue());
        if (r3 != null) goto L8;
        r3 = "0";
    L8:
        fj0.a r6 = fj0.b.a;
        fj0.a r7 = fj0.b.a;
        if (r7.b == false) goto L14;
        if (fj0.e.i() == false) goto L14;
        this.U.j.put("recharge_mode", "normal");
    L14:
        if (fj0.e.i() == false) goto L16;
        Map<String, String> r8 = this.U.j;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r8.put("recharge_price", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.d()));
    L16:
        com.bytedance.android.live.liveinteract.utils.d r9 = jf0.c.a;
        com.bytedance.android.live.liveinteract.utils.d r10 = this.U;
        ICircleInfo r11 = getRoom().getCircleInfo();
        Intrinsics.checkNotNullParameter(r17, "applyResult");
        Intrinsics.checkNotNullParameter(r10, "logParams");
        Intrinsics.checkNotNullParameter(r3, "linkCnt");
        HashMap r2 = new HashMap();
        jf0.c.a(r2, r10);
        if (r17.getAutoJoin() == false) goto L19;
        Object r12 = "0";
    L20:
        r2.put("is_approve_needed", r12);
        if (hd0.c.f().g != 1) goto L23;
        boolean r13 = true;
    L24:
        if (r13 == false) goto L26;
        String r14 = "video";
    L27:
        r2.put("guest_connection_type", r14);
        r2.put("is_full", "0");
        r2.put("connect_type", r10.b);
        gk0.a.b.getClass();
        r2.put("previous_page", gk0.a.C0214a.c());
        if (fj0.e.i() == true) goto L30;
    L32:
        Object r15 = "0";
    L33:
        r2.put("is_rechargeble", r15);
        String r16 = tc0.c.h().F;
        if (r16 != null) goto L36;
        r16 = "";
    L36:
        r2.put("apply_reason", r16);
        String r18 = "on";
        if (fj0.e.i() == false) goto L63;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r2.put("time", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.c()));
        int r19 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.d();
        r2.put("money", String.valueOf(r19));
        if (fj0.e.d() == false) goto L41;
        r2.put("anonymous_switch", "on");
    L42:
        PaidLinkMicContext r110 = PaidLinkMicContext.Companion.getContext();
        if (r110 == null) goto L49;
        com.bytedance.live.datacontext.m<Integer> r111 = r110.getDiscountMode();
        if (r111 == null) goto L49;
        Integer r112 = (Integer) r111.getValue();
        if (r112 == null) goto L49;
        int r113 = r112.intValue();
    L50:
        if (r113 != 1) goto L52;
        r4 = "vip";
    L59:
        r2.put("discount_type", r4);
        jf0.c.l(r2, r19, r113);
        if (r7.g == false) goto L62;
        r2.put("is_vip_recharge_privilege", "1");
    L62:
        b1 r5 = (b1) com.bytedance.android.livesdk.sharedpref.c.g1.getValue();
        r2.put("rechargeable_label", fj0.b.i(r5.getSavedTagInfos()));
        r2.put("rechargeable_intro", r5.getSavedDesc());
        goto L63
    L52:
        if (r113 != 2) goto L54;
        r4 = "activity";
        goto L59
    L54:
        if (r113 != 3) goto L59;
        r4 = "strategy";
    L49:
        r113 = 0;
        goto L50
    L41:
        r2.put("anonymous_switch", "off");
    L63:
        TalkRoomLogUtils.L0(r2);
        if (r11 == null) goto L68;
        String r20 = r11.getCircleName();
        if (r20 == null) goto L68;
        r2.put("circle_name", r20);
    L68:
        r2.put("link_cnt", r3);
        if (jf0.c.g() == true) goto L72;
        r18 = "off";
    L72:
        r2.put("seat_fit_status", r18);
        if (com.bytedance.android.live.liveinteract.voicechat.util.e.a(r13) == false) goto L75;
        r2.put("is_pre_link", "1");
    L76:
        TalkRoomLogUtils.O0(r2);
        f0.b(r2);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_apply", r2, new Object[]{IRoom.class, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        int r21 = r.a;
        if (r.b(getRoom()) == true) goto L81;
        if (Gq() == true) goto L81;
        return;
    L81:
        if (r17.getAutoJoin() == false) goto L83;
        return;
    L83:
        if (s0.a(getRoom()) == false) goto L85;
        Pq();
        return;
    L85:
        B();
        return;
    L75:
        r2.put("is_pre_link", "0");
        goto L76
    L30:
        if (r7.b == false) goto L32;
        r15 = "1";
        goto L33
    L26:
        r14 = "voice";
        goto L27
    L23:
        r13 = false;
        goto L24
    L19:
        r12 = "1";
        goto L20
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, uf0.b
    public final void l1(g1 r9) {
        Cq();
        StringBuilder r0 = new StringBuilder("");
        if (r9 == null) goto L5;
        Object r2 = Long.valueOf(r9.getLink_duration());
    L6:
        r0.append(r2);
        this.H = r0.toString();
        StringBuilder r1 = new StringBuilder("");
        if (r9 == null) goto L9;
        Object r3 = Long.valueOf(r9.getPaid_count());
    L10:
        r1.append(r3);
        this.I = r1.toString();
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L14;
        r4.put("DATA_DISCONNECT_LINK", Boolean.TRUE);
    L14:
        if ((!Intrinsics.areEqual(this.j, "kick_out")) == false) goto L17;
        com.bytedance.android.live.liveinteract.linksecurity.a r5 = com.bytedance.android.live.liveinteract.linksecurity.a.g;
        LinkedHashMap r6 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r7 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r8 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "callback");
        Intrinsics.checkNotNullParameter(r8, "config");
        r5.c("sense_disconnect_by_self", r6, r7, r8);
    L17:
        if (Intrinsics.areEqual(this.j, "limit_time_up") == false) goto L20;
        f2.b(2131919288, 0);
    L26:
        if (r9 != null) goto L28;
    L30:
        tc0.c.h().F = "";
        this.V.b();
        return;
    L28:
        if (r9.getControlType() != 1) goto L30;
        Sq("leave");
        goto L30
    L20:
        if (Intrinsics.areEqual(this.j, "kick_out") == true) goto L22;
        f2.b(2131919287, 0);
        goto L26
    L22:
        if (fj0.e.d() == false) goto L24;
        f2.c(s1.B(2131919226), 0);
        goto L26
    L24:
        f2.b(2131923150, 0);
        goto L26
    L9:
        r3 = "";
        goto L10
    L5:
        r2 = "";
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, uf0.b
    public final void m0(Throwable r2) {
        super.m0(r2);
        ExceptionUtils.handleException(((Widget) this).context, r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final void n4(SurfaceView r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        InteractAudienceVideoWindowManager r0 = this.z;
        if (r0 == null) goto L6;
        r0.w(tc0.c.h().e, r5, r0.s, r0.t);
        return;
    }

    public final void onMessage(tlc.d r5) {
        if ((r5 instanceof com.bytedance.android.livesdk.link.model.bridge.h1) == false) goto L46;
        com.bytedance.android.livesdk.link.model.bridge.h1 r6 = (com.bytedance.android.livesdk.link.model.bridge.h1) r5;
        if (r6.getMType() != 47) goto L19;
        ILinkerBattleConnectContent r7 = r6.getLinkerBattleConnectContent();
        if (r7 == null) goto L47;
        this.q = r7;
        com.bytedance.android.livesdk.link.model.bridge.s1 r0 = r7.getMultiChannelInfo();
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.getUseMultiChannel() == false) goto L49;
        RtcManager r1 = this.d;
        if (r1 == null) goto L15;
        r1.c(r7.getRtcExtInfo());
    L15:
        RtcManager r2 = this.d;
        if (r2 == null) goto L50;
        r2.J(r7.getLiveCoreExtInfo());
        return;
    L50:
        return;
    L49:
        return;
    L47:
        return;
    L19:
        if (r6.getMType() != 46) goto L52;
        DataCenter r3 = ((Widget) this).dataCenter;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r4 = null;
        if (r3 == null) goto L23;
        String r8 = (String) r3.get("data_room_unique_id", "");
    L24:
        tc0.c.i(r8).O = r6.getLinkerResumeAudienceContent();
        RtcManager r9 = this.d;
        if (r9 != null) goto L27;
        return;
    L27:
        if (r9.l != true) goto L54;
        if (r9 == null) goto L34;
        l6 r10 = r6.getLinkerResumeAudienceContent();
        if (r10 == null) goto L32;
        String r11 = r10.getRtcExtInfo();
    L33:
        r9.c(r11);
        goto L34
    L32:
        r11 = null;
    L34:
        RtcManager r12 = this.d;
        if (r12 == null) goto L41;
        l6 r13 = r6.getLinkerResumeAudienceContent();
        if (r13 == null) goto L39;
        String r14 = r13.getLiveCoreExtInfo();
    L40:
        r12.J(r14);
        goto L41
    L39:
        r14 = null;
    L41:
        l6 r15 = r6.getLinkerResumeAudienceContent();
        if (r15 == null) goto L44;
        r4 = r15.getMLinkUsers();
    L44:
        Tq(r4);
        return;
    L54:
        return;
    L23:
        r8 = null;
        goto L24
    L52:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.t
    public final void p2(fi6.a r6) {
        hd0.c r0 = hd0.c.f();
        r0.e = SystemClock.currentThreadTimeMillis();
        int r1 = this.J;
        qi6.g r2 = new qi6.g(240, 240, 15, 360);
        if (r6 == null) goto L6;
        r6.o(r2);
        r6.i(InteractMode.NORMAL);
        r6.g(Character.GUEST);
        r6.N = r1;
        r6.n(StreamType.VIDEO);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.c
    public final void permit(ILinkPlayerInfoBridge r4) {
        Intrinsics.checkNotNullParameter(r4, "linkPlayerInfo");
        IBaseUser r5 = r4.getUser();
        if (r5 == null) goto L11;
        Intrinsics.checkNotNullParameter(r5, "targetUser");
        if (Fq() == false) goto L12;
        com.bytedance.android.live.liveinteract.plantform.core.e r0 = this.u;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mAdminManager");
    L9:
        String r1 = r5.getIdString();
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        r0.f(r1, r5.getCastSecUid());
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.s
    public final void x2(z0 r6) {
        Intrinsics.checkNotNullParameter(r6, MultiLinkOpenSource.MESSAGE);
        com.bytedance.android.live.liveinteract.linksecurity.a r0 = com.bytedance.android.live.liveinteract.linksecurity.a.g;
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r2 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r3 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r2, "callback");
        Intrinsics.checkNotNullParameter(r3, "config");
        r0.c("sense_disconnect_by_other", r1, r2, r3);
        if (r6.getControlType() != 1) goto L5;
        Sq("kickout");
    L5:
        super.x2(r6);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.s
    public final void xf(z0 r7) {
        Intrinsics.checkNotNullParameter(r7, MultiLinkOpenSource.MESSAGE);
        super.xf(r7);
        this.K = System.currentTimeMillis();
        if (rf2.a.a() == false) goto L6;
        return;
    L6:
        if (r7.getMessageBoardInfo() == null) goto L8;
        com.bytedance.android.live.liveinteract.utils.d r0 = this.U;
        r0.getClass();
        Intrinsics.checkNotNullParameter("gift_message_invite", "<set-?>");
        r0.b = "gift_message_invite";
        this.U.k = r7.getMessageBoardInfo();
    L9:
        com.bytedance.android.live.liveinteract.utils.d r1 = this.U;
        String r2 = r7.getGetFromUserId();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.c = r2;
        InteractAudienceGuestInviteDialog r3 = this.C;
        if (r3 != null) goto L12;
    L19:
        fj0.b.a.b = false;
        com.bytedance.android.live.liveinteract.utils.d r4 = jf0.c.a;
        IMessageBoardInfo r5 = r7.getMessageBoardInfo();
        HashMap r6 = new HashMap();
        r6.put("function_type", "audience");
        if (hd0.c.f().g != 1) goto L22;
        String r8 = "video";
    L23:
        r6.put("guest_connection_type", r8);
        if (r5 == null) goto L26;
        r6.put("request_page", "gift_message_panel");
        r6.put("message_text", com.bytedance.android.live.liveinteract.plantform.model.f0.a(r5));
    L26:
        TalkRoomLogUtils.O0(r6);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_invited", r6, new Object[]{IRoom.class, x.class, com.bytedance.android.live.broadcastgame.api.c.class});
        int r9 = InteractAudienceGuestInviteDialog.m;
        IRoom r10 = getRoom();
        Intrinsics.checkNotNullParameter(r10, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r7, "msg");
        InteractAudienceGuestInviteDialog r11 = new InteractAudienceGuestInviteDialog();
        r11.i = r10;
        r11.j = r7;
        this.C = r11;
        FragmentActivity r12 = ContextUtil.contextToFragmentActivity(getContext());
        if (r12 == null) goto L43;
        FragmentManager r13 = r12.getSupportFragmentManager();
        if (r13 == null) goto L44;
        InteractAudienceGuestInviteDialog r14 = this.C;
        if (r14 == null) goto L45;
        LandscapeRestrictionOperation r15 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r14, "InteractAudienceInvitedDialog", r15);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r14, r15) == true) goto L46;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
    L36:
        r14.show(r13, "InteractAudienceInvitedDialog");
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L43:
        return;
    L22:
        r8 = "audio";
        goto L23
    L12:
        if (r3.isShowing() == false) goto L19;
        r3.dismiss();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r16 = DialogFragmentLancet.sLastShowStack;
        if (r16 == null) goto L19;
        com.bytedance.crash.d.d(r16, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L19
    L8:
        com.bytedance.android.live.liveinteract.utils.d r17 = this.U;
        r17.getClass();
        Intrinsics.checkNotNullParameter("invite", "<set-?>");
        r17.b = "invite";
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.s
    public final void D0(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "reqFrom");
        if (Intrinsics.areEqual(r2, "paid_change") == false) goto L5;
        return;
    L5:
        ExceptionUtils.handleException(getContext(), r3, 2131919391);
    }

    public final void Kq(String r1, boolean r2) {
        if (this.P != 0) goto L9;
        RtcManager r3 = this.d;
        if (r3 == null) goto L7;
        r3.onPause();
    L7:
        this.P = 3;
    L9:
        if (this.Q == true) goto L11;
        getLinkUserCenter().v();
    L11:
        m00.d r4 = this.E;
        if (r4 == null) goto L17;
        d0 r5 = r4.getLiveCore();
        if (r5 == null) goto L18;
        r5.d();
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void R(long r1, Exception r3) {
        super.R(r1, r3);
        f2.b(2131919445, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.s
    public final void R3(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        hd0.c.f().k(0);
        tc0.c.h().F = "";
        if (Intrinsics.areEqual(r4, "paid_change") == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r4, "low_balance_for_paid_link") == true) goto L12;
        if (r5 == false) goto L11;
        f2.b(2131918112, 0);
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.s
    public final void T3(com.bytedance.android.livesdk.chatroom.model.interact.m r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "result");
        hd0.c.f().g = 2;
        super.T3(r3, r4);
        if (r4 != ReplyType.Agree.ordinal()) goto L6;
        f2.b(2131918015, 0);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void e1(String r1, long r2) {
        super.e1(r1, r2);
        InteractAudienceVideoWindowManager r3 = this.z;
        if (r3 == null) goto L6;
        r3.a("", r1);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f0(long r1, Exception r3) {
        F3("leave_on_rtc_error");
        f2.b(2131919447, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget
    public final v0 ga(String r4, boolean r5) {
        if (this.E != null) goto L5;
        com.bytedance.android.live.liveinteract.utils.d r0 = this.U;
        r0.g = hd0.c.f().g;
        m00.d.a r1 = new m00.d.a();
        int r2 = hd0.c.f().g;
        this.E = ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).createLinkVideoView(((Widget) this).context, r1, r4, r5);
    L5:
        m00.d r6 = this.E;
        if (r6 == null) goto L9;
        return r6;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.interact.LiveVideoClientFactory");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J(String[] r1, boolean[] r2, int[] r3) {
        super.J(r1, r2, r3);
        this.V.a(r1, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final void Q6(h80.a<Boolean> r3, boolean r4, boolean r5) {
        if (r4 == false) goto L4;
        j0.a r6 = new j0.a(((Widget) this).context);
        r6.a = s1.B(2131917525);
        r6.b(s1.B(2131915913), new a(this, r3, r5));
        r6.a(s1.B(2131915442), new b(r3));
        r6.c();
        return;
    L4:
        com.bytedance.android.live.liveinteract.plantform.core.n r7 = this.b;
        if (r7 == null) goto L9;
        r7.b("cancel_application", r3, r5);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.c
    public final void kickOut(String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        Intrinsics.checkNotNullParameter(r7, "secUid");
        Intrinsics.checkNotNullParameter(r8, "reqFrom");
        if (r8.length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        r8 = "admin_stop_normal";
    L8:
        Intrinsics.checkNotNullParameter(r6, "userId");
        Intrinsics.checkNotNullParameter(r7, "secUid");
        Intrinsics.checkNotNullParameter(r8, "reqFrom");
        if (Fq() == true) goto L12;
        return;
    L12:
        if (this.v == true) goto L20;
        this.v = true;
        com.bytedance.android.live.liveinteract.plantform.core.e r0 = this.u;
        if (r0 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mAdminManager");
    L17:
        r0.e(r6, r7, r8);
        return;
    L20:
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final void r0(Context r2, IRoom r3, rj0.b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r4, "listener");
        xq(OperateType.APPLY, 2, new com.bytedance.android.live.liveinteract.interact.audience.b(r4));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.c
    public final void t2(long r10, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "uid");
        Intrinsics.checkNotNullParameter(r13, "secUid");
        Intrinsics.checkNotNullParameter(r12, "uid");
        Intrinsics.checkNotNullParameter(r13, "secUid");
        if (Fq() == false) goto L9;
        com.bytedance.android.live.liveinteract.plantform.core.e r1 = this.u;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mAdminManager");
    L7:
        com.bytedance.android.live.liveinteract.plantform.core.e.c(r1, r10, r12, r13, 0, 448);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L0(String r1, TextureView r2, int r3, int r4) {
        super.L0(r1, r2, r3, r4);
    }

    public final void Rq(int r12, int r13, List<String> r14, String r15) {
        String r0 = vm2.d.l().applyLinkSchema;
        if (TextUtils.isEmpty(r0) == true) goto L25;
        HashMap r1 = new HashMap();
        r1.put("live_type", "video_live");
        r1.put("paid_count", String.valueOf(r12));
        r1.put("limit_time", String.valueOf(r13));
        r1.put("reason_required", String.valueOf(((Number) com.bytedance.android.livesdk.sharedpref.c.r.getValue()).intValue()));
        r1.put("reason_template_manual", com.bytedance.android.livesdk.sharedpref.c.s.getValue());
        r1.put("reason_template_default", com.bytedance.android.livesdk.sharedpref.c.t.getValue());
        if (r14 == null) goto L7;
        String r16 = CollectionsKt.joinToString$default(r14, "|", null, null, 0, null, null, 62, null);
    L8:
        boolean r17 = false;
        if (String.valueOf(r16).length() <= 0) goto L11;
        boolean r18 = true;
    L12:
        if (r18 == false) goto L14;
        r1.put("linkmic_tag", String.valueOf(r16));
    L14:
        if (r15 == null) goto L21;
        if (r15.length() <= 0) goto L18;
        r17 = true;
    L18:
        if (r17 != true) goto L21;
        r1.put("paid_desc", r15);
    L21:
        if (fj0.e.e() == false) goto L23;
        r1.put("live_anonymous_paid_link_mic", "1");
    L23:
        String r19 = y0.b(r0, r1);
        ALogger.i("ttlive_link_paid", "applySchema: " + r19);
        jc1.k.n(IBaseLiveActionHandler.class).handle(((Widget) this).context, r19);
        return;
    L11:
        r18 = false;
        goto L12
    L7:
        r16 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final void X3(long r10, String r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "secToUserId");
        Intrinsics.checkNotNullParameter(r13, "toUserIdString");
        Intrinsics.checkNotNullParameter(r12, "secToUserId");
        Intrinsics.checkNotNullParameter(r13, "toUserIdString");
        if (r14 != com.bytedance.android.livesdk.message.model.ReplyType.Reject.ordinal()) goto L7;
        com.bytedance.android.live.liveinteract.plantform.core.n r1 = this.b;
        if (r1 == null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.core.n.g(r1, r10, r12, r13, r14, 2, 1);
        return;
    L9:
        return;
    L7:
        xq(OperateType.REPLY, 2, new com.bytedance.android.live.liveinteract.plantform.widgt.r(this, r10, r12, r13, r14));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void b4(String r1, z.a r2, int r3, int r4) {
        super.b4(r1, r2, r3, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final void c2(int r17, int r18, String r19, LinkApplyType r20) {
        Intrinsics.checkNotNullParameter(r19, "fromSource");
        if (vm2.d.p0() == true) goto L5;
    L15:
        com.bytedance.android.live.liveinteract.utils.d r1 = this.U;
        r1.d = r18;
        Intrinsics.checkNotNullParameter("apply", "<set-?>");
        r1.b = "apply";
        if (fj0.e.i() == false) goto L19;
        Qq(r18);
        return;
    L19:
        if (r20 != null) goto L21;
        LinkApplyType r3 = LinkApplyType.NORMAL;
    L22:
        this.k0 = r3;
        BaseGuestLinkWidget.wq(this, r17, 1, r3, r19, null, null, false, false, 0, null, 8160);
        if (TextUtils.equals(r19, "video_apply_container_click") == true) goto L25;
        return;
    L25:
        if (vm2.e.h() == false) goto L51;
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        int r2 = com.bytedance.android.live.liveinteract.plantform.utils.r.a;
        if (r0 == null) goto L33;
        com.bytedance.live.datacontext.m r4 = r0.getCleanMode();
        if (r4 == null) goto L33;
        Integer r5 = (Integer) r4.getValue();
        if (r5 == null) goto L33;
        int r6 = r5.intValue();
    L34:
        if (r6 <= 0) goto L52;
        HashMap r7 = new HashMap();
        if (r6 == 1) goto L47;
        if (r6 != 2) goto L40;
        String r8 = "pure_mode";
    L48:
        r7.put("mode_type", r8);
        r7.put("action_type", "click");
        r7.put("connection_type", "video");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_connection_click_under_screen_clear", r7, new Object[]{new x(), IRoom.class});
        return;
    L40:
        if (r6 != 3) goto L42;
        r8 = "simple_mode";
        goto L48
    L42:
        if (r6 == 13) goto L44;
        r8 = "unknown_mode";
        goto L48
    L44:
        r8 = "focus_mode";
        goto L48
    L47:
        r8 = "origin_mode";
        goto L48
    L52:
        return;
    L33:
        r6 = 0;
        goto L34
    L51:
        return;
    L21:
        r3 = r20;
        goto L22
    L5:
        if (this.a == null) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == false) goto L15;
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.e(getRoom(), null) == false) goto L15;
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.b(getRoom()) == true) goto L15;
        f2.b(2131921181, 0);
        TalkRoomBusinessFullLinkMonitor r10 = TalkRoomBusinessFullLinkMonitor.a;
        boolean r11 = com.bytedance.android.livesdk.chatroom.paidlive.e.e(getRoom(), null);
        boolean r12 = com.bytedance.android.livesdk.chatroom.paidlive.e.b(getRoom());
        r10.getClass();
        TalkRoomBusinessFullLinkMonitor.e0(r11, r12);
        return;
    L7:
        r9 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.BaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h1(String r7, SurfaceView r8, int r9, int r10) {
        super.h1(r7, r8, r9, r10);
        String r0 = tc0.c.h().f;
        long r1 = hd0.c.f().e;
        if (TextUtils.equals(r7, tc0.c.h().e) == true) goto L5;
    L7:
        InteractAudienceVideoWindowManager r2 = this.z;
        if (r2 == null) goto L10;
        r2.w(r7, r8, r9, r10);
    L10:
        InteractAudienceVideoWindowManager r11 = this.z;
        if (r11 == null) goto L13;
        com.bytedance.android.live.liveinteract.interact.audience.f r12 = r11.q("", r0);
    L14:
        if (r12 != null) goto L21;
        SurfaceView r13 = this.E;
        if (r13 == null) goto L21;
        InteractAudienceVideoWindowManager r14 = this.z;
        if (r14 == null) goto L21;
        r14.w(r0, r13, 0, 0);
    L21:
        if (this.x == false) goto L39;
        RtcManager r15 = this.d;
        if (r15 != null) goto L25;
        return;
    L25:
        if (r15.l == true) goto L27;
        return;
    L27:
        if (this.P != 0) goto L30;
        r15.onPause();
        this.P = 3;
    L30:
        if (this.Q == true) goto L32;
        getLinkUserCenter().v();
    L32:
        m00.d r16 = this.E;
        if (r16 == null) goto L37;
        d0 r17 = r16.getLiveCore();
        if (r17 == null) goto L37;
        r17.d();
    L37:
        this.O = Observable.timer(this.N, TimeUnit.MILLISECONDS).subscribe(new h(this));
        return;
    L39:
        return;
    L13:
        r12 = null;
        goto L14
    L5:
        if (r1 <= 0) goto L7;
        hd0.c.f().e = 0;
        goto L7
    }

    public final void yf(boolean r17, boolean r18, boolean r19, boolean r20, lh6.c r21) {
        if (r17 == false) goto L10;
        if (r18 == false) goto L10;
        r21.a(Unit.INSTANCE);
        m00.d r0 = this.E;
        if (r0 == null) goto L34;
        r0.switchCamera();
        return;
    L34:
        return;
    L10:
        if (r20 == true) goto L20;
        com.bytedance.android.live.liveinteract.utils.d r2 = jf0.c.a;
        com.bytedance.android.live.liveinteract.utils.d r3 = this.U;
        boolean r4 = l5();
        Intrinsics.checkNotNullParameter(r3, "logParams");
        HashMap r5 = new HashMap();
        r5.put("live_type", "video_live");
        r5.put("function_type", "audience");
        r5.put("user_type", "guest");
        if (r4 == false) goto L14;
        String r6 = "off";
    L15:
        r5.put("button_type", r6);
        if (r3.g != 1) goto L18;
        String r7 = "video";
    L19:
        r5.put("guest_connection_type", r7);
        jf0.c.a(r5, r3);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_connection_user_camera_open_click", r5, new Object[]{x.class, IRoom.class});
        goto L20
    L18:
        r7 = "voice";
        goto L19
    L14:
        r6 = "on";
    L20:
        if (r17 == false) goto L22;
        int r8 = 1;
    L23:
        ArrayList r14 = new ArrayList();
        Context r1 = ((Widget) this).context;
        if (r1 != null) goto L26;
        r1 = s1.getContext();
    L26:
        OperateType r9 = OperateType.APPLY;
        r14.add(new qh0.f.b(r1, r9, r8));
        if (r19 == true) goto L32;
        Context r10 = ((Widget) this).context;
        if (r10 != null) goto L31;
        r10 = s1.getContext();
    L31:
        r14.add(new qh0.f.h(r10, r9, r8, 1, getRoom(), jc1.k.n(IMiddlewareUserService.class).user().n(), null, this, null, 1472));
    L32:
        qh0.f.a(r14).a(new com.bytedance.android.live.liveinteract.interact.audience.e(this, r21, r17));
        return;
    L22:
        r8 = 2;
        goto L23
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.e
    public final void D5(int r16, int r17, boolean r18, boolean r19, int r20, xc.a r21) {
        fj0.a r0 = fj0.b.a;
        int r1 = 0;
        if (r16 <= 0) goto L5;
        boolean r2 = true;
    L6:
        r0.b = r2;
        r0.g = r19;
        r0.h = r20;
        if (r21 == null) goto L11;
        Integer r3 = r21.a();
        if (r3 == null) goto L11;
        r1 = r3.intValue();
    L11:
        r0.i = r1;
        LinkApplyType r4 = this.k0;
        if (r4 != null) goto L14;
        r4 = LinkApplyType.NORMAL;
    L14:
        BaseGuestLinkWidget.wq(this, 2, 1, r4, "paid_link", Integer.valueOf(r16), Integer.valueOf(r17), r18, r19, r20, r21, 2176);
        return;
    L5:
        r2 = false;
        goto L6
    }
}
