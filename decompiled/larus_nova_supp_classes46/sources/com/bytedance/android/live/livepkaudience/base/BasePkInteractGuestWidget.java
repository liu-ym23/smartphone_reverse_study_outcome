package com.bytedance.android.live.livepkaudience.base;

import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.anchorlink.BaseRevLinkWidget;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.base.h;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.livepkaudience.PkGuestRtcLinkerContext;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.android.livesdk.chatroom.model.ApplyResult;
import com.bytedance.android.livesdk.chatroom.model.JoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.interact.AudienceLinkReplyResult;
import com.bytedance.android.livesdk.config.k9;
import com.bytedance.android.livesdk.config.lv0;
import com.bytedance.android.livesdk.config.pp0;
import com.bytedance.android.livesdk.config.z01;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LinkerGame;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.CityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerEnterContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.livelink.kmp.impl.extend.spatialaudio.SpatialAudioManager;
import hh1.u0;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uf2.d0;
import zf2.s0;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/base/BasePkInteractGuestWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/base/h;", "T", "Lcom/bytedance/android/live/anchorlink/BaseRevLinkWidget;", "Lcom/bytedance/android/live/livepkaudience/base/h;", "", "Lcom/bytedance/android/live/livepkaudience/service/f;", "<init>", "()V", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BasePkInteractGuestWidget<T extends com.bytedance.android.live.liveinteract.plantform.base.h> extends BaseRevLinkWidget implements h, com.bytedance.android.live.liveinteract.plantform.core.k, com.bytedance.android.live.liveinteract.plantform.core.u, com.bytedance.android.live.livepkaudience.service.f {
    public Room a;
    public q b;
    public v0 c;
    public final lc0.c d;
    public com.bytedance.android.live.livepkaudience.rtc.a e;
    public boolean f;
    public String g;
    public String h;
    public long i;
    public long j;
    public String k;
    public final CompositeDisposable l;
    public final Lazy m;

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void A(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public void D0(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "reqFrom");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void D1(String r1, ByteBuffer r2, int r3) {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public void Ee(ApplyResult r2) {
        Intrinsics.checkNotNullParameter(r2, "applyResult");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public void Ke() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void Lb() {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public void Pb(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reqFrom");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public void Q2(Throwable r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.u
    public void Qc() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void S(String r1, int r2, int r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void T6(String r1, s0 r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void V4(String r1, uf2.z.a r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Xi(int r1, int r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void al(String r1, int r2) {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public void b1(Throwable r1) {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public void bn(xe r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void ci() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f1(long r1, long r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f4() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void g(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    public abstract v0 ga(String r1, boolean r2);

    public abstract i getLinkUserCenter();

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h6(int r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void ip(Object r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void j0(String r1, TextureView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void k1() {
    }

    public final void l0(Throwable r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.u
    public final void l8() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o0(long r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void onUserJoined(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
    }

    public final void u0() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wf(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wk(String r1) {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public void xn(Text r1) {
    }

    public abstract int xq();

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void y0(String r1, SurfaceView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void z7() {
    }

    public void Aq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.put("cmd_interact_state_change", new a1(4));
    L5:
        hd0.c.f().k(0);
    }

    public final boolean Bq() {
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        if (gd0.v.a(r0, 2) == true) goto L7;
        if (gd0.v.a(r0, 32) == true) goto L7;
        return false;
    L7:
        if (hd0.c.f().h() == false) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void M1() {
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        if (gd0.v.a(r0, 2) == false) goto L5;
    L6:
        q r1 = this.b;
        if (r1 == null) goto L9;
        r1.f(this.h);
    L9:
        this.c = null;
        return;
    L5:
        if (gd0.v.a(r0, 32) == false) goto L9;
        goto L6
    }

    public final SurfaceView yq() {
        return (SurfaceView) this.m.getValue();
    }

    public final void zq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L8;
        a1 r1 = (a1) r0.get("cmd_interact_state_change", new a1(-1));
        if (r1 == null) goto L8;
        if (r1.a != 3) goto L8;
        return;
    L8:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L11;
        r2.put("cmd_interact_state_change", new a1(3));
    L11:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L14;
        r3.put("cmd_what_audience_self_join", Boolean.TRUE);
    L14:
        ILinkServiceExternal r4 = jc1.k.f(ILinkServiceExternal.class);
        if (r4 == null) goto L19;
        r4.notifyAudienceSelfJoin(true);
        return;
    }

    public BasePkInteractGuestWidget() {
        this.d = jc1.k.n(ILinkServiceExternal.class).getMultiDataHolder();
        this.g = "";
        this.h = "leave_normally";
        this.k = "";
        this.l = new CompositeDisposable();
        this.m = LazyKt.lazy(new BasePkInteractGuestWidget$surfaceViewByLazy$2(this));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void o() {
        hd0.c.f().k(2);
        q r0 = this.b;
        if (r0 == null) goto L6;
        String r1 = this.g;
        Intrinsics.checkNotNullParameter(r1, "token");
        long r2 = System.currentTimeMillis();
        int r4 = eg0.b.a;
        Disposable r3 = eg0.b.b(r0.d().id, r1).compose(RxUtil.rxSchedulerHelper()).subscribe(new t(r1, r2), new u(r2, r1));
        r0.b.add(r3);
        return;
    }

    public void onCreate() {
        super.onCreate();
        this.a = (Room) ((Widget) this).dataCenter.get("data_room", new Room());
        this.b = new q(((Widget) this).dataCenter);
        com.bytedance.android.live.livepkaudience.rtc.c.t0.getClass();
        com.bytedance.android.live.livepkaudience.rtc.c r0 = com.bytedance.android.live.livepkaudience.rtc.c.a.a();
        v0 r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.livepkaudience.rtc.a r2 = r0.getRtcManager();
    L6:
        this.e = r2;
        if (r2 == null) goto L9;
        Boolean r3 = Boolean.valueOf(r2.j);
    L11:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L27;
        com.bytedance.android.live.livepkaudience.rtc.a r4 = this.e;
        if (r4 == null) goto L15;
        r1 = r4.q;
    L15:
        this.c = r1;
        if (dl0.n.b() == false) goto L22;
        v0 r5 = this.c;
        if (r5 == null) goto L22;
        d0 r6 = r5.A();
        if (r6 == null) goto L22;
        SurfaceView r7 = (SurfaceView) this.m.getValue();
        r6.x();
    L22:
        com.bytedance.android.live.livepkaudience.rtc.a r8 = this.e;
        if (r8 == null) goto L25;
        Intrinsics.checkNotNullParameter(this, "rtcListener");
        r8.d = this;
    L25:
        hd0.c.f().k(2);
    L29:
        getLinkUserCenter().e();
        q r9 = this.b;
        if (r9 == null) goto L47;
        vlc.d r10 = r9.a;
        if (r10 == null) goto L34;
        r10.addMessageListener(MessageType.LINK_MIC.getIntType(), r9);
    L34:
        vlc.d r11 = r9.a;
        if (r11 == null) goto L37;
        r11.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getIntType(), r9);
    L37:
        vlc.d r12 = r9.a;
        if (r12 == null) goto L40;
        r12.addMessageListener(MessageType.LINKER.getIntType(), r9);
    L40:
        vlc.d r13 = r9.a;
        if (r13 == null) goto L43;
        r13.addMessageListener(MessageType.LINK_SETTING_NOTIFY_MESSAGE.getIntType(), r9);
    L43:
        vlc.d r14 = r9.a;
        if (r14 == null) goto L46;
        r14.addMessageListener(MessageType.CONTROL.getIntType(), r9);
    L46:
        Lazy r15 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(r9.o, "PkGuestLinkManager#attach", String.valueOf(r9.a));
    L47:
        q r16 = this.b;
        if (r16 == null) goto L50;
        Intrinsics.checkNotNullParameter(this, "listener");
        r16.c.add(this);
    L50:
        Pair r17 = com.bytedance.live.datacontext.d.a(BasePkInteractGuestWidget$onCreate$pair$1.INSTANCE);
        ((PkGuestRtcLinkerContext) r17.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r17.getFirst(), "pk_guest_rtc_linker_service");
        this.l.add((Disposable) r17.getSecond());
        return;
    L27:
        if (hd0.c.f().j() == true) goto L29;
        hd0.c.f().k(0);
        goto L29
    L9:
        r3 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public void onDestroy() {
        getLinkUserCenter().g();
        if (Bq() == true) goto L8;
        com.bytedance.android.live.livepkaudience.rtc.a r0 = this.e;
        if (r0 == null) goto L7;
        int r1 = com.bytedance.android.live.livepkaudience.rtc.a.x;
        r0.d(false);
    L7:
        this.l.dispose();
    L8:
        q r2 = this.b;
        if (r2 == null) goto L24;
        boolean r3 = Bq();
        Lazy r4 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(r2.o, "PkGuestLinkManager#detach", String.valueOf(r2.a));
        vlc.d r5 = r2.a;
        if (r5 == null) goto L14;
        r5.removeMessageListener(r2);
    L14:
        if (r2.b.isDisposed() == true) goto L16;
        r2.b.dispose();
    L16:
        Integer r6 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r6 != null) goto L20;
    L23:
        r2.c.clear();
        goto L24
    L20:
        if (2 != r6.intValue()) goto L23;
        if (r3 == true) goto L23;
        Disposable r7 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).leave(r2.d().id, "live_end").compose(RxUtil.rxSchedulerHelper()).subscribe(Functions.emptyConsumer(), new com.bytedance.android.live.liveinteract.api.utils.l());
        r2.b.add(r7);
    L24:
        super.onDestroy();
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public void I3() {
        Aq();
    }

    @Override // com.bytedance.android.live.livepkaudience.service.f
    public final com.bytedance.android.live.livepkaudience.rtc.a P2() {
        return this.e;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public void Bg(xe r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        this.h = "kick_out";
        F3("kick_out");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public final void Ea(if r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        this.h = "sys_kick_out";
        F3("sys_kick_out");
    }

    public void F3(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        com.bytedance.android.live.livepkaudience.rtc.a r0 = this.e;
        if (r0 != null) goto L5;
    L9:
        q r1 = this.b;
        if (r1 == null) goto L12;
        r1.f(r4);
    L12:
        v0 r5 = this.c;
        if ((r5 instanceof u0) == true) goto L15;
        r5 = null;
    L15:
        u0 r6 = (u0) r5;
        if (r6 == null) goto L19;
        r6.release();
        return;
    L19:
        return;
    L5:
        if (r0.j != true) goto L9;
        this.h = r4;
        if (r0 == null) goto L12;
        r0.f("leaveChannel reqFrom = " + r4);
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L(String r5) {
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r0 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r0 == null) goto L5;
        String r1 = r0.getSelfAnchorLinkMicId();
    L7:
        if (TextUtils.equals(r5, r1) == true) goto L9;
        return;
    L9:
        if (this.j <= 0) goto L13;
        this.j = 0;
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public final void Of(if r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public void Yn(xe r3) {
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        this.i = System.currentTimeMillis();
        this.j = System.currentTimeMillis();
        this.k = "apply";
        q r0 = this.b;
        if (r0 == null) goto L5;
        r0.e();
    L5:
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r1 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r1 == null) goto L14;
        LinkerGame r4 = r3.getGameInfo();
        if (r4 == null) goto L11;
        String r5 = r4.getGame_extra();
        if (r5 == null) goto L11;
    L12:
        r1.setGameData(r5);
        return;
    L11:
        r5 = "";
        goto L12
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public void b2(com.bytedance.android.live.network.response.e<JoinChannelResult> r15) {
        Intrinsics.checkNotNullParameter(r15, "response");
        if (((Boolean) pp0.a.getValue()).booleanValue() == false) goto L12;
        JoinChannelResult r0 = r15.data;
        if (r0 == null) goto L7;
        String r1 = r0.getLiveCoreSettings();
    L9:
        if (this.c != null) goto L11;
        this.c = ga(r1, true);
    L11:
        this.c = this.c;
    L18:
        if (dl0.n.b() == false) goto L24;
        v0 r2 = this.c;
        if (r2 == null) goto L24;
        d0 r3 = r2.A();
        if (r3 == null) goto L24;
        SurfaceView r4 = (SurfaceView) this.m.getValue();
        r3.x();
    L24:
        com.bytedance.android.live.livepkaudience.rtc.a r5 = this.e;
        boolean r6 = false;
        String r7 = "";
        if (r5 == null) goto L126;
        v0 r8 = this.c;
        q r9 = this.b;
        if (r9 == null) goto L30;
        String r10 = r9.d;
        if (r10 == null) goto L30;
    L32:
        if (r9 == null) goto L34;
        MultiChannelInfo r11 = r9.e;
    L35:
        com.bytedance.android.live.livepkaudience.rtc.a.b r12 = new com.bytedance.android.live.livepkaudience.rtc.a.b(r11, String.valueOf(this.d.getChannelId()), 3);
        Intrinsics.checkNotNullParameter(this, "rtcListener");
        Intrinsics.checkNotNullParameter(r10, "rtcExtInfo");
        Intrinsics.checkNotNullParameter(r12, "params");
        if (r5.j == false) goto L39;
        ALogger.e("ttlive_pk", "GuestRtcManager rtc already start.");
        goto L126
    L39:
        if (TextUtils.isEmpty(r10) == false) goto L46;
        gy.a r13 = r5.r;
        if (r13 == null) goto L43;
        r13.f.n(LiveTracingMonitor.b(0), "start_error", "", r13.a(), (int) (-20), "rtc_ext_info is empty");
    L43:
        com.bytedance.android.live.liveinteract.plantform.core.v r14 = r5.d;
        if (r14 == null) goto L126;
        r14.R(-1, new IllegalStateException("rtc_ext_info is empty"));
        goto L126
    L46:
        r5.i = this;
        r5.m.clear();
        r5.s.clear();
        gy.a r16 = r5.r;
        boolean r17 = r12.a;
        r16.getClass();
        r16.c = System.currentTimeMillis();
        r16.e = 0;
        r16.b = 0;
        r16.d = 0;
        HashMap r18 = r16.a();
        r18.put("rtc_ext_info", r10);
        if (r17 == false) goto L49;
        gy.h r19 = r16.f;
        LiveTracingMonitor.EventModule r20 = LiveTracingMonitor.b(0);
        int r110 = gy.h.d;
        r19.m(r20, "start_interact_streaming", r18, false);
    L50:
        r5.v = r10;
        Disposable r21 = r5.f;
        if (r21 == null) goto L54;
        r21.dispose();
    L54:
        if (((Boolean) lv0.a.getValue()).booleanValue() == false) goto L56;
        r5.f = Observable.timer(15, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.livepkaudience.rtc.b(r5));
    L56:
        r5.l = System.currentTimeMillis();
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Exception -> L116
        ILiveWrappedLivePusher r22 = ILiveWrappedLivePusher.a.b();     // Catch: Exception -> L116
        if (r22 == null) goto L60;
        r22.getAVLog();     // Catch: Exception -> L116
    L60:
        r5.d = this;     // Catch: Exception -> L116
        r5.a = r5.b(r8, r10);     // Catch: Exception -> L116
        ILinkServiceExternal r23 = jc1.k.f(ILinkServiceExternal.class);     // Catch: Exception -> L116
        if (r23 != null) goto L63;
    L74:
        r5.c = r8;     // Catch: Exception -> L116
        if (r8 == null) goto L77;
        d0 r24 = r8.A();     // Catch: Exception -> L116
    L78:
        r5.b = r24;     // Catch: Exception -> L116
        if (dl0.n.b() == false) goto L83;
        d0 r25 = r5.b;     // Catch: Exception -> L116
        if (r25 == null) goto L83;
        r25.o0();     // Catch: Exception -> L116
    L83:
        ei6.a r26 = r5.a;     // Catch: Exception -> L116
        if (r26 == null) goto L88;
        gi6.e r27 = r26.getEventManager();     // Catch: Exception -> L116
        if (r27 == null) goto L88;
        r27.b(r5.p);     // Catch: Exception -> L116
    L88:
        Qc();     // Catch: Exception -> L116
        if (r12.b == true) goto L97;
        ei6.a r28 = r5.a;     // Catch: Exception -> L116
        if (r28 == null) goto L97;
        xi6.c r29 = r28.t();     // Catch: Exception -> L116
        if (r29 == null) goto L97;
        com.bytedance.live.livelink.kmp.impl.core.video.c r30 = r29.d();     // Catch: Exception -> L116
        if (r30 == null) goto L97;
        r30.e(r12.b);     // Catch: Exception -> L116
    L97:
        ei6.a r31 = r5.a;     // Catch: Exception -> L116
        if (r31 == null) goto L102;
        si6.b r32 = r31.b();     // Catch: Exception -> L116
        if (r32 == null) goto L102;
        si6.a.a(r32, r5.a(), r12.a, 12);     // Catch: Exception -> L116
    L102:
        MultiChannelInfo r33 = r12.c;     // Catch: Exception -> L116
        if (r33 != null) goto L105;
    L179:
        ei6.a r34 = r5.a;     // Catch: Exception -> L176
        if (r34 == null) goto L114;
        ri6.b r35 = r34.r();     // Catch: Exception -> L176
        if (r35 == null) goto L114;
        r35.t1();     // Catch: Exception -> L176
    L114:
        r5.j = true;     // Catch: Exception -> L116
        goto L126
    L105:
        if (r33.getUseMultiChannel() == false) goto L179;
        Map<Long, String> r36 = r33.getChannelMap();     // Catch: Exception -> L116
        if (r36 == null) goto L179;
        r5.e(r36, "startEngine", r12.d);     // Catch: Exception -> L116
        goto L179
    L77:
        r24 = null;
        goto L78
    L63:
        if (r23.isSpatialAudioEnable(4) != true) goto L74;
        ei6.a r37 = r5.a;     // Catch: Exception -> L116
        if (r37 == null) goto L69;
        SpatialAudioManager r38 = r37.m();     // Catch: Exception -> L116
        if (r38 == null) goto L69;
        r38.b(r5.a(), true);     // Catch: Exception -> L116
    L69:
        ei6.a r39 = r5.a;     // Catch: Exception -> L116
        if (r39 == null) goto L74;
        SpatialAudioManager r40 = r39.m();     // Catch: Exception -> L116
        if (r40 == null) goto L74;
        r40.a(r5.a());     // Catch: Exception -> L116
    L116:
        e = move-exception;
        if (r5.r == null) goto L120;
        Intrinsics.checkNotNullParameter(e, "e");
        JSONObject r41 = new JSONObject();
        r41.put(MultiLinkOpenSource.MESSAGE, e.getMessage());
        e.printStackTrace(new PrintWriter(new StringWriter()));
        r41.put("trace", e.toString());
        dy.b.a.f("start_error", LiveTracingMonitor.b(0), r41);
    L120:
        Disposable r42 = r5.f;
        if (r42 == null) goto L123;
        r42.dispose();
    L123:
        com.bytedance.android.live.liveinteract.plantform.core.v r43 = r5.d;
        if (r43 == null) goto L126;
        r43.R(10002, e);
        goto L126
    L49:
        gy.h r44 = r16.f;
        LiveTracingMonitor.EventModule r45 = LiveTracingMonitor.b(0);
        int r111 = gy.h.d;
        r44.m(r45, "join_channel_in_advance", r18, false);
        goto L50
    L34:
        r11 = null;
    L30:
        r10 = "";
    L126:
        JoinChannelResult r46 = r15.data;
        if (r46 == null) goto L132;
        String r47 = r46.getToken();
        if (r47 == null) goto L132;
        r7 = r47;
    L132:
        this.g = r7;
        JoinChannelResult r48 = r15.data;
        if (r48 == null) goto L175;
        List r49 = r48.getLinkedUsers();
        if (r49 != null) goto L137;
        return;
    L137:
        if (((z01) k9.a.getValue()).useJoinChannelList == false) goto L163;
        i r50 = getLinkUserCenter();
        if ((r50 instanceof i) == true) goto L141;
        r50 = null;
    L141:
        if (r50 == null) goto L163;
        JoinChannelResult r112 = r15.data;
        Intrinsics.checkNotNullParameter(r112, "result");
        Intrinsics.checkNotNullParameter(r112, "$this$toEnterContent");
        LinkerEnterContent r51 = new LinkerEnterContent();
        r51.setMApplyType(r112.getApplyType());
        ICityEffect r52 = r112.getCityEffect();
        if ((r52 instanceof CityEffect) == true) goto L145;
        r52 = null;
    L145:
        r51.setMCityEffect((CityEffect) r52);
        r51.setMMatchEffect(r112.getMatchEffect());
        r51.setMLinkUsers(KotlinTypeUtilsKt.castToMutableElementType(r112.getLinkedUsers()));
        r51.setUserIdString(dl0.n.d());
        r51.setMVersion(r112.getVersion());
        List r53 = r112.getLinkedUsers();
        if ((r53 instanceof List) == true) goto L148;
        List r54 = null;
    L149:
        List r55 = r54;
        if (r55 != null) goto L152;
    L153:
        r6 = true;
    L154:
        if (r6 == true) goto L162;
        i.L(r51, r54);
        if (i.N(r50, r54, r112.getVersion(), "joinChannel", r51.getMLinkerContentMap()) == false) goto L161;
        r50.s = new i.a(System.currentTimeMillis(), "joinChannel", "", null);
        ALogger.w(r50.a, "refreshList from=joinChannel version=" + r112.getVersion() + " onOnlineListChanged callback");
        Iterator r113 = ((ArrayList) r50.n).iterator();
    L159:
        if (r113.hasNext() == false) goto L163;
        ((z) r113.next()).onOnlineListChanged(r50.c);
        goto L159
    L161:
        ALogger.e(r50.a, "list not updated, from=joinChannel version=" + r112.getVersion() + " current=" + r50.t);
        goto L163
    L162:
        ALogger.e(r50.a, "onSelfJoinChannel user list is empty! " + r51);
        goto L163
    L152:
        if (r55.isEmpty() == false) goto L154;
    L148:
        r54 = r53;
    L163:
        Iterator r114 = r49.iterator();
    L165:
        if (r114.hasNext() == false) goto L190;
        com.bytedance.android.livesdk.link.model.bridge.k r56 = (com.bytedance.android.livesdk.link.model.bridge.k) r114.next();
        IBaseUser r57 = r56.getUser();
        if (r57 == null) goto L169;
        String r58 = r57.getIdString();
    L171:
        if (Intrinsics.areEqual(r58, dl0.n.d()) == false) goto L165;
        if (r56.getSilenceStatus() != 1) goto L165;
        tc0.c.h().C = true;
        goto L165
    L169:
        r58 = null;
        goto L171
    L190:
        return;
    L175:
        return;
    L7:
        r1 = null;
        goto L9
    L12:
        JoinChannelResult r59 = r15.data;
        if (r59 == null) goto L15;
        String r60 = r59.getLiveCoreSettings();
    L16:
        this.c = ga(r60, true);
        goto L18
    L15:
        r60 = null;
        goto L16
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public void c0(Throwable r1) {
        Aq();
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    public void m0(Throwable r1) {
        if ((r1 instanceof ApiServerException) == false) goto L5;
        return;
    L5:
        if (((Boolean) lv0.a.getValue()).booleanValue() == false) goto L9;
        this.h = "join_channel_fail";
        F3("join_channel_fail");
        return;
    }

    public void Cq(int r1, rj0.a r2) {
        r2.onConfirm();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void G9(long r1, Exception r3) {
        q r2 = this.b;
        if (r2 == null) goto L6;
        r2.f("leave_on_rtc_error");
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J3(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        com.bytedance.android.live.liveinteract.plantform.core.g.a(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void R(long r1, Exception r3) {
        q r2 = this.b;
        if (r2 == null) goto L6;
        r2.f("leave_on_rtc_error");
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void S1(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.c(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Z4(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void d5(dg2.e r2, dg2.e[] r3) {
        Intrinsics.checkNotNullParameter(r2, "localQuality");
        Intrinsics.checkNotNullParameter(r3, "remoteQualities");
        com.bytedance.android.live.liveinteract.plantform.core.g.d(r2, r3);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.h
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public void mo464do(AudienceLinkReplyResult r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        if (r3 != ReplyType.Agree.ordinal()) goto L8;
        this.j = System.currentTimeMillis();
        q r4 = this.b;
        if (r4 == null) goto L9;
        r4.e();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void e1(String r1, long r2) {
        getLinkUserCenter().E(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void f0(long r3, Exception r5) {
        com.bytedance.android.live.livepkaudience.rtc.a r6 = this.e;
        if (r6 == null) goto L6;
        r6.f("onError code = " + r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void n2(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.b(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Hf(int r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "deviceId");
        Intrinsics.checkNotNullParameter(r2, "deviceId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void J(String[] r5, boolean[] r6, int[] r7) {
        if (r5 == null) goto L33;
        if (r6 == null) goto L41;
        int r8 = r5.length;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r0 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        u0 r1 = null;
        if (r0 == null) goto L8;
        String r2 = r0.getAudienceSelfLinkMicId();
    L9:
        int r3 = 0;
    L10:
        if (r3 >= r8) goto L42;
        if (TextUtils.equals(r5[r3], r2) == false) goto L32;
        if (r6[r3] == false) goto L32;
        i r9 = getLinkUserCenter();
        if ((r9 instanceof i) == true) goto L18;
        r9 = null;
    L18:
        if (r9 == null) goto L20;
        LinkPlayerInfo r10 = r9.k("0", r2);
    L21:
        if (r10 != null) goto L23;
        return;
    L23:
        if (r10.silenceStatus != 0) goto L39;
        u0 r11 = this.c;
        if ((r11 instanceof u0) == false) goto L28;
        r1 = r11;
    L28:
        u0 r4 = r1;
        if (r4 == null) goto L40;
        r4.x0();
        return;
    L40:
        return;
    L39:
        return;
    L20:
        r10 = null;
    L32:
        r3 = r3 + 1;
        goto L10
    L42:
        return;
    L8:
        r2 = null;
        goto L9
    L41:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Rj(int r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }

    public final void wq(OperateType r5, int r6, qh0.d<rh0.a> r7) {
        Intrinsics.checkNotNullParameter(r5, "operateType");
        Intrinsics.checkNotNullParameter(r7, "consumer");
        ArrayList r0 = new ArrayList();
        r0.add(qh0.g.a(r5, r6));
        r0.add(new qh0.f.g(((Widget) this).context, r5, r6));
        r0.add(new qh0.f.c(((Widget) this).context, r5, r6));
        r0.add(new qh0.f.a(((Widget) this).context));
        r0.add(new qh0.f.d(((Widget) this).context, r5, r6, true));
        r0.add(new qh0.f.C0257f(((Widget) this).context, r5, r6, true));
        r0.add(new qh0.f.e(((Widget) this).context, r5));
        qh0.f.a(r0).a(r7);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void x1(LiveWrappedNetworkDetectionLinkType r1, int r2, double r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r1, "type");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void L0(String r6, TextureView r7, int r8, int r9) {
        zq();
        long r10 = hd0.c.f().e;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r11 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r11 == null) goto L5;
        String r12 = r11.getSelfAnchorLinkMicId();
    L7:
        if (TextUtils.equals(r6, r12) == false) goto L12;
        if (r10 <= 0) goto L12;
        hd0.c.f().e = 0;
    L12:
        if (TextUtils.equals(r6, r12) == true) goto L14;
        return;
    L14:
        if (this.i <= 0) goto L18;
        long r13 = System.currentTimeMillis() - this.i;
        dl0.m.w(getScene(), r13, this.k, r6);
        this.i = 0;
        this.k = "";
        return;
    L18:
        return;
    L5:
        r12 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void b4(String r6, uf2.z.a r7, int r8, int r9) {
        zq();
        long r10 = hd0.c.f().e;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r11 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r11 == null) goto L5;
        String r12 = r11.getSelfAnchorLinkMicId();
    L7:
        if (TextUtils.equals(r6, r12) == false) goto L12;
        if (r10 <= 0) goto L12;
        hd0.c.f().e = 0;
    L12:
        if (TextUtils.equals(r6, r12) == true) goto L14;
        return;
    L14:
        if (this.i <= 0) goto L18;
        long r13 = System.currentTimeMillis() - this.i;
        dl0.m.w(getScene(), r13, this.k, r6);
        this.i = 0;
        this.k = "";
        return;
    L18:
        return;
    L5:
        r12 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public void h1(String r6, SurfaceView r7, int r8, int r9) {
        zq();
        long r10 = hd0.c.f().e;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r11 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r11 == null) goto L5;
        String r12 = r11.getSelfAnchorLinkMicId();
    L7:
        if (TextUtils.equals(r6, r12) == false) goto L12;
        if (r10 <= 0) goto L12;
        hd0.c.f().e = 0;
    L12:
        if (TextUtils.equals(r6, r12) == true) goto L14;
        return;
    L14:
        if (this.i <= 0) goto L18;
        long r13 = System.currentTimeMillis() - this.i;
        dl0.m.w(getScene(), r13, this.k, r6);
        this.i = 0;
        this.k = "";
        return;
    L18:
        return;
    L5:
        r12 = null;
        goto L7
    }
}
