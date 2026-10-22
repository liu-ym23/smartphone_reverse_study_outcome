package com.bytedance.android.live.liveinteract.plantform.widgt.videolink;

import am2.x;
import android.app.Dialog;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkResultDialogFragmentV2;
import com.bytedance.android.live.liveinteract.component.MultiComponentManager;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog;
import com.bytedance.android.live.liveinteract.plantform.api.LinkPaidLinkApi;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSVideoWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.plantform.utils.w0;
import com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget;
import com.bytedance.android.live.liveinteract.videotalk.MultiLinkVideoTalkRoomGuestWidget;
import com.bytedance.android.live.liveinteract.videotalk.dialog.InteractBeautyPreviewDialog;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.widget.widget.ChatRoomGuestAppliedDialog;
import com.bytedance.android.live.liveinteract.widget.widget.q;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.interact.b1;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdk.chatroom.model.interact.j1;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.config.sj1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerBattleConnectContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.bizlink.api.business.anchor2guest.base.BizLinkServiceType;
import com.bytedance.live.bizlink.impl.platform.manager.MultiLinkGuestManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import hh1.v0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tf0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/widgt/videolink/MultiLinkVideoBaseGuestLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/MultiLinkBaseGuestLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "", "Lm00/g$a;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class MultiLinkVideoBaseGuestLinkWidget extends MultiLinkBaseGuestLinkWidget<ILinkPlayerInfoBridge> implements m00.g.a {
    public LinkApplyType A;
    public boolean B;
    public boolean C;
    public String D;
    public GuestTalkBeInvitedDialog E;
    public final CompositeDisposable F;
    public ne0.c G;
    public Runnable H;
    public uf0.d I;
    public uf0.c J;
    public Pair<Boolean, String> K;
    public boolean L;
    public LinkResultDialogFragmentV2 M;
    public long s;
    public ChatMatchWidget t;
    public ChatRoomGuestAppliedDialog u;
    public q v;
    public InteractBeautyPreviewDialog w;
    public final w0 x;
    public int y;
    public com.bytedance.android.live.liveinteract.plantform.model.f z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ long a;

        public b(long r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            f2.b(2131919287, 0);
            InteractLinkFullLinkMonitor.x("video_guest_widget_destroy", System.currentTimeMillis() - this.a, ((ExtraResponse) r5).logId);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ long a;

        public c(long r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            long r0 = System.currentTimeMillis() - this.a;
            InteractLinkFullLinkMonitor.w("video_guest_widget_destroy", r0, (Throwable) r5);
        }
    }

    public static final class d implements xb6.b {
        public final /* synthetic */ MultiLinkVideoBaseGuestLinkWidget a;

        public final Pair<Boolean, String> h() {
            if (this.a.Gq() == false) goto L11;
            hg6.g r0 = this.a.P2();
            if (r0 == null) goto L11;
            if (r0.A() != true) goto L11;
            return new Pair(Boolean.TRUE, "is pk mode");
        L11:
            if (this.a.Fq() == false) goto L14;
            return new Pair(Boolean.TRUE, "linkmic online float window");
        L14:
            return new Pair(Boolean.FALSE, "check whether in float window");
        }

        public final Pair<Boolean, String> a() {
            return xb6.b.a.k();
        }

        public final Pair<Boolean, String> b() {
            return xb6.b.a.a();
        }

        public final Pair<Boolean, String> c() {
            return xb6.b.a.b();
        }

        public final Pair<Boolean, String> e() {
            return xb6.b.a.e();
        }

        public final Pair<Boolean, String> g() {
            return xb6.b.a.l();
        }

        public final Pair<Boolean, String> k() {
            return xb6.b.a.i();
        }

        public final Pair<Boolean, String> m() {
            return xb6.b.a.c();
        }

        public d(MultiLinkVideoBaseGuestLinkWidget r1) {
            this.a = r1;
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

    public static final class e implements js0.b {
        public e() {
        }

        @Override // js0.b
        public final void onSuccess(String r2) {
            Intrinsics.checkNotNullParameter(r2, "track");
            ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).linkEffectHelper();
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoBaseGuestLinkWidget a;

        public f(MultiLinkVideoTalkRoomGuestWidget r1) {
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
            com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.c.u;
            Integer r3 = Integer.valueOf((int) r0.longValue());
            r2.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r2, r3);
            com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.v;
            Integer r5 = Integer.valueOf((int) r1.longValue());
            r4.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r4, r5);
            ArrayList r6 = new ArrayList();
            List r10 = r9.getPaidTags();
            if (r10 == null) goto L24;
            Iterator<T> r11 = r10.iterator();
        L15:
            if (r11.hasNext() == false) goto L24;
            String r12 = ((j1) r11.next()).getName();
            if (r12 == null) goto L15;
            if (r12.length() <= 0) goto L21;
            boolean r13 = true;
        L22:
            if (r13 == false) goto L15;
            r6.add(r12);
            goto L15
        L21:
            r13 = false;
        L24:
            b1 r14 = (b1) com.bytedance.android.livesdk.sharedpref.c.g1.getValue();
            r14.setSavedTagInfos(r9.getPaidTags());
            r14.setSavedDesc(String.valueOf(r9.getPaidDesc()));
            MultiLinkVideoBaseGuestLinkWidget.Kq(this.a, (int) r0.longValue(), (int) r1.longValue(), r6, r9.getPaidDesc());
            return;
        L36:
            return;
        L34:
            return;
        L35:
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

        public final void accept(Object r4) {
            jy0.b.c("ttlive_link_paid", "getPaidInfoBeforeApply failed " + ((Throwable) r4), null, 4);
            f2.b(2131917082, 0);
        }
    }

    public static final class h implements js0.b {
        public final /* synthetic */ MultiLinkVideoBaseGuestLinkWidget a;
        public final /* synthetic */ rj0.a b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;

        @Override // js0.b
        public final void onSuccess(String r4) {
            Intrinsics.checkNotNullParameter(r4, "track");
            int r5 = InteractBeautyPreviewDialog.A;
            InteractBeautyPreviewDialog r6 = InteractBeautyPreviewDialog.a.a(this.b, this.c, null);
            this.a.w = r6;
            if (this.d == false) goto L8;
            Dialog r0 = r6.getDialog();
            if (r0 == null) goto L7;
            r0.setCancelable(false);
        L7:
            r6.w = true;
        L8:
            FragmentActivity r1 = ((Widget) this.a).context;
            if (r1 == null) goto L17;
            FragmentManager r2 = r1.getSupportFragmentManager();
            LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, "InteractBeautyPreviewDialog", r3);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r6, r3) == true) goto L21;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
        L14:
            r6.show(r2, "InteractBeautyPreviewDialog");
            return;
        L21:
            return;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }

        public h(MultiLinkVideoBaseGuestLinkWidget r1, rj0.a r2, String r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public int Cq() {
        return 16;
    }

    public int Lq() {
        return 0;
    }

    public abstract o Nq();

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return 16;
    }

    public final int Mq() {
        int r0 = this.y;
        int r1 = bh0.a.a;
        if (r0 != 100) goto L14;
        com.bytedance.android.live.liveinteract.plantform.model.f r2 = this.z;
        if (r2 == null) goto L7;
        Integer r3 = r2.getInviteSource();
    L8:
        if (r3 == null) goto L14;
        if (r3.intValue() != 3) goto L14;
        return 116;
    L7:
        r3 = null;
    L14:
        return this.y;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onCreate() {
        Iq("onCreate");
        Lazy r0 = MultiComponentManager.e;
        MultiComponentManager.a.a().a(this, ((Widget) this).context, ((Widget) this).dataCenter);
        cg6.a r1 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r1 == null) goto L5;
        r1.init(((Widget) this).context);
    L5:
        sg6.b r2 = xq();
        if (r2 == null) goto L8;
        sg6.b r3 = r2;
        r3.b(BizLinkServiceType.VideoGuest, ((Widget) this).context);
    L8:
        super.onCreate();
        hg6.g r4 = P2();
        if (r4 == null) goto L14;
        xi0.b r5 = r4.O();
        if (r5 == null) goto L15;
        r5.p(this);
        return;
    L15:
        return;
    }

    public final boolean Pq() {
        xf6.b r0 = Tq();
        if (r0 == null) goto L7;
        vf6.a r1 = r0.a9();
        if (r1 == null) goto L7;
        return r1.a;
    L7:
        return false;
    }

    public final void Qq() {
        if (vm2.d.i0() == false) goto L36;
        String r0 = vm2.d.l().applyLinkSchema;
        if (TextUtils.isEmpty(r0) == true) goto L34;
        HashMap r1 = new HashMap();
        String r2 = u0.j(je0.d.h());
        if (r2 == null) goto L9;
        r1.put("layout_type", r2);
    L9:
        r1.put("function_type2", TalkRoomLogUtils.h);
        r1.put("live_type", "video_live");
        int r3 = this.y;
        int r4 = bh0.a.a;
        if (r3 != 101) goto L13;
        r1.put("request_page", "seat");
    L33:
        String r5 = y0.b(r0, r1);
        jy0.b.d("ttlive_link_paid", "applySchema = " + r5);
        k.n(IBaseLiveActionHandler.class).handle(((Widget) this).context, r5);
        goto L34
    L13:
        if (r3 != 102) goto L16;
        r1.put("request_page", "bottom");
        goto L33
    L16:
        if (r3 != 113) goto L18;
        r1.put("request_page", "card");
        goto L33
    L18:
        String r6 = "live_chorus";
        if (r3 != 114) goto L26;
        if (this.A == LinkApplyType.KTV_MULTI_CHORUS) goto L24;
        r6 = "live_song";
    L24:
        r1.put("request_page", r6);
        goto L33
    L26:
        if (tc0.c.h().J == 114) goto L29;
        r1.put("request_page", "");
        goto L33
    L29:
        if (this.A == LinkApplyType.KTV_MULTI_CHORUS) goto L32;
        r6 = "live_song";
    L32:
        r1.put("request_page", r6);
    L34:
        MultiLinkEventModule r7 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.c(String.valueOf(this.y));
        return;
    L36:
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.e() == false) goto L39;
        RxUtilKt.c(((LinkPaidLinkApi) com.bytedance.android.live.network.c.b().e(LinkPaidLinkApi.class)).getPaidInfoBeforeApply(getMRoom().getId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new f((MultiLinkVideoTalkRoomGuestWidget) this), g.a), this.F);
        return;
    L39:
        Rq(com.bytedance.android.live.liveinteract.api.data.a.C0017a.g(), com.bytedance.android.live.liveinteract.api.data.a.C0017a.f(), null, null);
    }

    public final xf6.b Tq() {
        rf6.a r0 = xq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onDestroy() {
        sg6.b r0 = xq();
        if (r0 == null) goto L6;
        r0.j(null);
    L6:
        if (Gq() == false) goto L23;
        hg6.g r1 = P2();
        if (r1 == null) goto L23;
        if (r1.A() != true) goto L23;
        hg6.g r2 = P2();
        if (r2 == null) goto L18;
        dg6.a r3 = r2.r();
        if (r3 == null) goto L18;
        IPkAudienceLinkOutService r4 = (IPkAudienceLinkOutService) k.f(IPkAudienceLinkOutService.class);
        if (r4 == null) goto L18;
        r4.setRevGuestManagerData(pg6.a.c(r3), this.c);
    L18:
        ILinkerBattleConnectContent r5 = this.o;
        if (r5 == null) goto L23;
        IPkAudienceLinkOutService r6 = (IPkAudienceLinkOutService) k.f(IPkAudienceLinkOutService.class);
        if (r6 == null) goto L23;
        r6.setLinkerContentMap(r5);
    L23:
        t r7 = j0.l().c(x.class);
        if ((r7 instanceof t) == false) goto L27;
        r7.E("is_link_reserve", "0");
    L27:
        if (Fq() == false) goto L85;
        hg6.g r8 = P2();
        if (r8 == null) goto L85;
        if (r8.A() != true) goto L85;
        String r9 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager.c.a().w = Eq();
        LinkmicOnlineFloatWindowManager r10 = LinkmicOnlineFloatWindowManager.c.a();
        hg6.g r11 = P2();
        dn0.c r12 = (dn0.c) getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        r10.s = r11;
        r10.t = r12;
        if (v.a() == true) goto L35;
    L37:
        hg6.g r13 = r10.s;
        if (r13 != null) goto L41;
    L46:
        hg6.g r14 = P2();
        if (r14 == null) goto L51;
        dg6.a r15 = r14.r();
        if (r15 == null) goto L51;
        LinkmicOnlineFloatWindowManager.c.a().v(pg6.a.c(r15));
    L51:
        LinkmicOnlineFloatWindowManager r16 = LinkmicOnlineFloatWindowManager.c.a();
        v0 r17 = this.c;
        r16.q = r17;
        if ((r17 instanceof m00.g) == true) goto L54;
        r17 = null;
    L54:
        m00.g r18 = (m00.g) r17;
        if (r18 == null) goto L57;
        r18.r();
    L57:
        LinkmicOnlineFloatWindowManager r19 = LinkmicOnlineFloatWindowManager.c.a();
        LinkUserDataMergeContext.a r20 = LinkUserDataMergeContext.Companion;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r21 = LinkUserDataMergeContext.a.b(r20, ((Widget) this).dataCenter);
        if (r21 == null) goto L66;
        BehaviorSubject<ch0.d> r22 = r21.b1();
        if (r22 == null) goto L66;
        ch0.d r23 = (ch0.d) r22.getValue();
        if (r23 == null) goto L66;
        ch0.g r24 = r23.d;
        if (r24 == null) goto L66;
        ch0.g r25 = ch0.g.a(r24);
    L67:
        r19.E = r25;
        ((ArrayList) LinkmicOnlineFloatWindowManager.c.a().D).clear();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r26 = LinkUserDataMergeContext.a.b(r20, ((Widget) this).dataCenter);
        if (r26 == null) goto L85;
        BehaviorSubject<List<ch0.e>> r27 = r26.f();
        if (r27 == null) goto L85;
        List r28 = (List) r27.getValue();
        if (r28 == null) goto L85;
        List r29 = r28;
        ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10));
        Iterator r31 = r29.iterator();
    L75:
        if (r31.hasNext() == false) goto L77;
        r30.add(((ch0.e) r31.next()).b);
        goto L75
    L77:
        Iterator r32 = r30.iterator();
    L79:
        if (r32.hasNext() == false) goto L85;
        ch0.h r33 = (ch0.h) r32.next();
        String r34 = LinkmicOnlineFloatWindowManager.Y;
        List<ch0.h> r35 = LinkmicOnlineFloatWindowManager.c.a().D;
        if (r33 == null) goto L83;
        ch0.h r36 = ch0.h.a(r33, null, false, false, false, 0, 127);
    L84:
        ((ArrayList) r35).add(r36);
        goto L79
    L83:
        r36 = null;
    L66:
        r25 = null;
        goto L67
    L41:
        if (r10.B != null) goto L43;
        r10.B = new RTSVideoWidget(r13, r10.t, null, r10);
    L43:
        RTSVideoWidget r37 = r10.B;
        if (r37 == null) goto L46;
        r37.onCreate();
        goto L46
    L35:
        if (vm2.c.h().d() == false) goto L37;
    L85:
        Integer r38 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r38 != null) goto L89;
    L101:
        cg6.a r39 = Bq();
        if (r39 == null) goto L107;
        vb6.g r40 = r39.O5();
        if (r40 == null) goto L107;
        r40.h(new d(this));
    L107:
        if (Gq() == false) goto L109;
    L114:
        super.onDestroy();
        return;
    L109:
        if (Fq() == true) goto L114;
        v0 r41 = this.c;
        if (r41 == null) goto L113;
        r41.release();
    L113:
        Jq();
        goto L114
    L89:
        if (2 != r38.intValue()) goto L101;
        if (Gq() == true) goto L101;
        if (Fq() == true) goto L101;
        InteractLinkFullLinkMonitor.v("video_guest_widget_destroy");
        long r42 = System.currentTimeMillis();
        int r43 = eg0.a.a;
        IRoom r44 = je0.d.e(null);
        if (r44 == null) goto L97;
        long r45 = r44.getId();
    L98:
        eg0.a.b(r45, "video_guest_widget_destroy").compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r42), new c(r42));
        hg6.g r46 = P2();
        if (r46 == null) goto L101;
        r46.onDestroy();
        goto L101
    L97:
        r45 = 0;
        goto L98
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final y zq() {
        return Aq();
    }

    public MultiLinkVideoBaseGuestLinkWidget(tc0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "dataHolder");
        super(r2);
        this.x = new w0();
        int r3 = bh0.a.a;
        this.y = 100;
        this.A = LinkApplyType.NORMAL;
        this.D = "";
        LinkMatchType r4 = LinkMatchType.NONE;
        this.F = new CompositeDisposable();
    }

    public final void Wq(IBaseUser r3) {
        Intrinsics.checkNotNullParameter(r3, "targetUser");
        xf6.b r0 = Tq();
        if (r0 == null) goto L6;
        r0.b(r3, this.I);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public void l1(g1 r6) {
        Runnable r7 = this.H;
        if (r7 == null) goto L5;
        r7.run();
    L5:
        this.H = null;
        ((Widget) this).dataCenter.put("DATA_DISCONNECT_LINK", Boolean.TRUE);
        o r8 = Nq();
        if (r8 == null) goto L8;
        r8.N();
    L8:
        xf6.b r9 = Tq();
        if (r9 == null) goto L13;
        vf6.a r10 = r9.a9();
        if (r10 == null) goto L13;
        boolean r11 = r10.d;
    L14:
        if (r11 == false) goto L16;
        com.bytedance.android.live.liveinteract.linksecurity.b r0 = com.bytedance.android.live.liveinteract.linksecurity.b.g;
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r2 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r3 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r2, "callback");
        Intrinsics.checkNotNullParameter(r3, "config");
        r0.c("sense_disconnect_by_self", r1, r2, r3);
    L16:
        ((Widget) this).dataCenter.put("DATA_DISCONNECT_LINK_BYSELF", Boolean.valueOf(r11));
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new e()).callbackOnMainThread().syncCallbackIfReady(true).requireByUser("MultiLinkVideoBaseGuestLinkWidget");
        InteractBeautyPreviewDialog r12 = this.w;
        if (r12 == null) goto L27;
        r12.dismiss();     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r13 = DialogFragmentLancet.sLastShowStack;
        if (r13 == null) goto L28;
        com.bytedance.crash.d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L28:
        return;
    L27:
        return;
    L13:
        r11 = false;
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void x2(z0 r6) {
        Intrinsics.checkNotNullParameter(r6, MultiLinkOpenSource.MESSAGE);
        com.bytedance.android.live.liveinteract.linksecurity.b r0 = com.bytedance.android.live.liveinteract.linksecurity.b.g;
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r2 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r3 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r2, "callback");
        Intrinsics.checkNotNullParameter(r3, "config");
        r0.c("sense_disconnect_by_other", r1, r2, r3);
        if (isViewValid() == true) goto L5;
    L7:
        super.x2(r6);
        return;
    L5:
        if (this.l == false) goto L7;
        Sq(false, "kickout");
        ((Widget) this).dataCenter.put("data_talk_room_capture_audio_notification_show_state", Boolean.FALSE);
        goto L7
    }

    public final void Sq(boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "reason");
        this.K = new Pair(Boolean.valueOf(r7), r8);
        if (r7 == false) goto L9;
        jg6.a r3 = Eq();
        if (r3 == null) goto L14;
        kg6.e r4 = r3.b();
        if (r4 == null) goto L14;
        r4.z(new kg6.d(false, true, r8, 8));
    L14:
        DataCenter r9 = ((Widget) this).dataCenter;
        if (r9 == null) goto L18;
        r9.put("data_self_is_silenced", Boolean.valueOf(!r7));
        return;
    L18:
        return;
    L9:
        jg6.a r5 = Eq();
        if (r5 == null) goto L14;
        kg6.e r6 = r5.b();
        if (r6 == null) goto L14;
        r6.t(new kg6.b(false, !je0.d.G(), r8, 8));
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void v5(IBaseUser r3, List<? extends e1> r4) {
        Intrinsics.checkNotNullParameter(r3, "user");
        y r5 = Aq();
        if (r5 == null) goto L9;
        String r6 = r3.getIdString();
        Intrinsics.checkNotNullParameter(r6, "uid");
        if (r2.a(r6) == true) goto L10;
        Map<String, Long> r7 = r5.p;
        HashMap r8 = (HashMap) r7;
        r8.put(r6, Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    L10:
        return;
    }

    private final void Rq(int r12, int r13, List<String> r14, String r15) {
        String r0 = vm2.d.l().applyLinkSchema;
        if (TextUtils.isEmpty(r0) == true) goto L32;
        HashMap r1 = new HashMap();
        r1.put("live_type", "video_live");
        r1.put("paid_count", String.valueOf(r12));
        r1.put("limit_time", String.valueOf(r13));
        r1.put("reason_required", String.valueOf(((Number) com.bytedance.android.livesdk.sharedpref.c.r.getValue()).intValue()));
        String r16 = (String) com.bytedance.android.livesdk.sharedpref.c.s.getValue();
        String r17 = "";
        if (r16 != null) goto L7;
        r16 = "";
    L7:
        r1.put("reason_template_manual", r16);
        String r18 = (String) com.bytedance.android.livesdk.sharedpref.c.t.getValue();
        if (r18 == null) goto L11;
        r17 = r18;
    L11:
        r1.put("reason_template_default", r17);
        if (r14 == null) goto L14;
        String r19 = CollectionsKt.joinToString$default(r14, "|", null, null, 0, null, null, 62, null);
    L15:
        boolean r110 = false;
        if (String.valueOf(r19).length() <= 0) goto L18;
        boolean r111 = true;
    L19:
        if (r111 == false) goto L21;
        r1.put("linkmic_tag", String.valueOf(r19));
    L21:
        if (r15 == null) goto L28;
        if (r15.length() <= 0) goto L25;
        r110 = true;
    L25:
        if (r110 != true) goto L28;
        r1.put("paid_desc", r15);
    L28:
        if (fj0.e.e() == false) goto L30;
        r1.put("live_anonymous_paid_link_mic", "1");
    L30:
        String r112 = y0.b(r0, r1);
        jy0.b.d("ttlive_link_paid", "applySchema = " + r112);
        k.n(IBaseLiveActionHandler.class).handle(((Widget) this).context, r112);
        return;
    L18:
        r111 = false;
        goto L19
    L14:
        r19 = null;
        goto L15
    }

    public final void Yq(int r3, rj0.a r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "eventPage");
        int r0 = Lq();
        if (r0 == 12) goto L9;
        if (r0 == 8) goto L9;
        if (r0 == 16) goto L9;
    L37:
        r4.onConfirm();
        return;
    L9:
        if (r3 != 1) goto L37;
        if (sj1.c() == true) goto L15;
        if (((Boolean) b6.I.getValue()).booleanValue() == true) goto L37;
    L15:
        if (hd0.c.f().j() == true) goto L29;
        cg6.a r1 = Bq();
        if (r1 == null) goto L22;
        MultiLinkGuestManager r2 = r1.W4();
        if (r2 == null) goto L22;
        if (r2.b == true) goto L29;
    L22:
        cg6.a r7 = Bq();
        if (r7 == null) goto L28;
        MultiLinkGuestManager r8 = r7.W4();
        if (r8 == null) goto L28;
        if (r8.a == true) goto L29;
    L28:
        boolean r9 = true;
    L30:
        if (r9 == false) goto L37;
        hd0.c.f().g = r3;
        InteractBeautyPreviewDialog r10 = this.w;
        if (r10 != null) goto L34;
    L36:
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new h(this, r4, r5, r6)).callbackOnMainThread().syncCallbackIfReady(true).justPrepare();
        return;
    L34:
        if (r10.isShowing() != true) goto L36;
        return;
    L29:
        r9 = false;
        goto L30
    }

    public static final /* synthetic */ void Kq(MultiLinkVideoBaseGuestLinkWidget r0, int r1, int r2, List r3, String r4) {
        r0.Rq(r1, r2, r3, r4);
    }
}
