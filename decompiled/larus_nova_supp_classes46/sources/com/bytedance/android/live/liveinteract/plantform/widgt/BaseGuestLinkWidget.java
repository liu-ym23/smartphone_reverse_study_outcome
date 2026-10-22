package com.bytedance.android.live.liveinteract.plantform.widgt;

import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.GuestRtcLinkerContext;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.base.h;
import com.bytedance.android.live.liveinteract.plantform.core.RtcManager;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h0;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.revenue.PaidLinkMicPlayModeHandler;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.m0;
import com.bytedance.android.live.liveinteract.plantform.utils.n0;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkContext;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.d1;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.h1;
import com.bytedance.android.livesdk.chatroom.model.i1;
import com.bytedance.android.livesdk.chatroom.model.j2;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.bridge.i0;
import com.bytedance.android.livesdk.link.model.bridge.j1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerBattleConnectContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLowBalanceForPaidLinkmicContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import gd0.x;
import hh1.u0;
import hh1.v0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import uf2.d0;
import uf2.z;
import w20.xc;
import zf2.s0;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Deprecated(message = "双人聊待下线")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00052\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/widgt/BaseGuestLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/base/h;", "T", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/core/s;", "", "Lcom/bytedance/android/live/liveinteract/plantform/base/b;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseGuestLinkWidget<T extends com.bytedance.android.live.liveinteract.plantform.base.h> extends PlatformMultiLinkWidget implements com.bytedance.android.live.liveinteract.plantform.core.s, com.bytedance.android.live.liveinteract.plantform.core.k, com.bytedance.android.live.liveinteract.plantform.core.u, com.bytedance.android.live.liveinteract.plantform.base.b {
    public IRoom a;
    public com.bytedance.android.live.liveinteract.plantform.core.n b;
    public v0 c;
    public RtcManager d;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.j e;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.h f;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.e g;
    public String h;
    public boolean i;
    public String j;
    public long k;
    public long l;
    public String m;
    public m0 n;
    public boolean o;
    public final CompositeDisposable p;
    public ILinkerBattleConnectContent q;
    public final Lazy r;
    public boolean s;
    public final tf0.i t;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r6) {
            h1 r7 = (h1) ((com.bytedance.android.live.network.response.e) r6).data;
            if (r7 == null) goto L46;
            List r8 = r7.getSettings();
            if (r8 == null) goto L47;
            Iterator<T> r9 = r8.iterator();
        L7:
            String r2 = null;
            if (r9.hasNext() == false) goto L18;
            T r0 = r9.next();
            Integer r3 = ((ILinkmicAudienceSetting) r0).getKey();
            int r4 = ILinkmicAudienceSetting.LinkmicAudienceSettingKey.ENABLE_MIC_DRESS_BUTTON.getValue();
            if (r3 != null) goto L13;
        L15:
            boolean r5 = false;
        L16:
            if (r5 == false) goto L7;
        L19:
            ILinkmicAudienceSetting r1 = (ILinkmicAudienceSetting) r0;
            if (r1 == null) goto L48;
            Gson r10 = GsonHelper.get();
            i1 r11 = r1.getValue();
            if (r11 == null) goto L24;
            r2 = r11.getExtra();
        L24:
            j2 r12 = (j2) GsonProtectorUtils.fromJson(r10, r2, j2.class);
            com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.c.N0;
            if (r12 == null) goto L29;
            Integer r14 = r12.a;
            if (r14 == null) goto L29;
            int r15 = r14.intValue();
        L30:
            Integer r16 = Integer.valueOf(r15);
            r13.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r13, r16);
            com.bytedance.android.livesdk.sharedpref.e r17 = com.bytedance.android.livesdk.sharedpref.c.P0;
            if (r12 == null) goto L34;
            Object r18 = r12.b;
            if (r18 == null) goto L34;
        L35:
            r17.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r17, r18);
            if (r17.getValue() != null) goto L38;
            return;
        L38:
            if (((List) r17.getValue()).isEmpty() == false) goto L50;
            com.bytedance.android.livesdk.sharedpref.f.d(r13, 0);
            return;
        L50:
            return;
        L34:
            r18 = new ArrayList();
        L29:
            r15 = 0;
            goto L30
        L48:
            return;
        L13:
            if (r3.intValue() != r4) goto L15;
            r5 = true;
            goto L16
        L18:
            r0 = null;
            goto L19
        L47:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "throwable");
            r3.printStackTrace();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ BaseGuestLinkWidget a;

        public c(BaseGuestLinkWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            d1 r5 = (d1) ((com.bytedance.android.live.network.response.e) r4).data;
            if (r5 == null) goto L22;
            List r6 = r5.getEntranceList();
            if (r6 == null) goto L23;
            y r0 = this.a.getLinkUserCenter();
            y r2 = null;
            if ((r0 instanceof y) == true) goto L9;
            r0 = null;
        L9:
            if (r0 == null) goto L13;
            List<ILinkmicInteractEntrance> r1 = r0.D;
            if (r1 == null) goto L13;
            ((ArrayList) r1).clear();
        L13:
            y r3 = this.a.getLinkUserCenter();
            if ((r3 instanceof y) == false) goto L17;
            r2 = r3;
        L17:
            if (r2 == null) goto L24;
            List<ILinkmicInteractEntrance> r7 = r2.D;
            if (r7 == null) goto L25;
            ((ArrayList) r7).addAll(r6);
            return;
        L25:
            return;
        L24:
            return;
        L23:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "throwable");
            r3.printStackTrace();
        }
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void A(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    public void D0(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "reqFrom");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void D1(String r1, ByteBuffer r2, int r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void Lb() {
    }

    public void Q2(Throwable r1) {
    }

    public void Qc() {
    }

    public void R3(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "reqFrom");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void S(String r1, int r2, int r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void T6(String r1, s0 r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void V4(String r1, z.a r2) {
    }

    public void X5(ILinkMicGuideMessageBridge r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Xi(int r1, int r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void al(String r1, int r2) {
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

    public void g7(IApplyResult r2) {
        Intrinsics.checkNotNullParameter(r2, "applyResult");
    }

    public abstract v0 ga(String r1, boolean r2);

    public abstract y getLinkUserCenter();

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

    @Override // uf0.b
    public final void l0(Throwable r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.u
    public final void l8() {
    }

    public void o() {
        com.bytedance.android.live.liveinteract.videotalk.a.a = false;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.put("cmd_interact_state_change", new a1(3));
    L5:
        hd0.c.f().k(2);
        com.bytedance.android.live.liveinteract.plantform.core.n r1 = this.b;
        if (r1 == null) goto L9;
        String r2 = this.h;
        Intrinsics.checkNotNullParameter(r2, "token");
        int r3 = eg0.b.a;
        Disposable r4 = eg0.b.b(r1.c().getId(), r2).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.plantform.core.q(r2), com.bytedance.android.live.liveinteract.plantform.core.r.a);
        r1.b.add(r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o0(long r1) {
    }

    @Override // uf0.b
    public final void u0() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wf(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wk(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void y0(String r1, SurfaceView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void z7() {
    }

    public abstract int zq();

    public void Cq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.put("cmd_interact_state_change", new a1(4));
    L5:
        hd0.c.f().k(0);
    }

    public final boolean Eq() {
        return jc1.k.n(IMultiLinkServiceExternal.class).getControlServiceExternal().c();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.b
    public final ei6.a V0() {
        RtcManager r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public final IRoom getRoom() {
        IRoom r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L5:
        return r0;
    }

    public final void Bq() {
        if (vm2.i.c() == false) goto L19;
        RtcManager r0 = this.d;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.k != true) goto L21;
        ALogger.d("ttlive_multi_advance_link", "reset advance link");
        Set<Long> r1 = InteractLinkFullLinkMonitor.a;
        JSONObject r3 = new JSONObject();
        r3.put("reset_trace", ExceptionsKt.stackTraceToString(new Throwable()));
        nd0.c.o(nd0.c.a, LinkMonitorData.ResetAdvanceLink, r3, 0, null, false, 28);
        RtcManager r2 = this.d;
        if (r2 == null) goto L11;
        r2.K0(false);
    L11:
        RtcManager r4 = this.d;
        if (r4 == null) goto L14;
        r4.M0();
    L14:
        v0 r5 = this.c;
        if (r5 == null) goto L17;
        r5.release();
    L17:
        this.c = null;
        return;
    L21:
        return;
    }

    public void M1() {
        if (Eq() == true) goto L16;
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L11;
        gd0.i r1 = r0.getInteractFloatWindowService();
        if (r1 == null) goto L11;
        boolean r2 = true;
        if (((com.bytedance.android.live.liveinteract.service.g) r1).b() != true) goto L11;
    L12:
        if (r2 == true) goto L16;
        com.bytedance.android.live.liveinteract.plantform.core.n r3 = this.b;
        if (r3 == null) goto L16;
        r3.e(this.j);
    L11:
        r2 = false;
    L16:
        this.c = null;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onCreate() {
        super.onCreate();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        IRoom r1 = (IRoom) r0.get("data_room", vh7.f.c(IRoom.class));
    L6:
        if (r1 == null) goto L8;
        IRoom r2 = (IRoom) ((Widget) this).dataCenter.get("data_room", vh7.f.c(IRoom.class));
    L13:
        this.a = r2;
        this.b = new com.bytedance.android.live.liveinteract.plantform.core.n(((Widget) this).dataCenter, yq());
        IMultiPkAudienceLinkOutService r3 = (IMultiPkAudienceLinkOutService) jc1.k.n(IMultiPkAudienceLinkOutService.class);
        boolean r4 = r3.isRtcEngineOn();
        IRoom r5 = this.a;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L16:
        this.d = new RtcManager(r5, yq(), this, false);
        if (r4 == false) goto L43;
        Object r6 = r3.getLiveVideoClientFactory();
        if ((r6 instanceof v0) == true) goto L21;
        r6 = null;
    L21:
        this.c = (v0) r6;
        x r7 = r3.createRtcData();
        if (r7 == null) goto L27;
        r7.f = this.c;
        RtcManager r8 = this.d;
        if (r8 == null) goto L27;
        r8.a0(pg6.a.a(r7), null);
    L27:
        if (je0.d.U() == false) goto L33;
        v0 r9 = this.c;
        if (r9 == null) goto L33;
        d0 r10 = r9.getLiveCore();
        if (r10 == null) goto L33;
        SurfaceView r11 = (SurfaceView) this.r.getValue();
        r10.x();
    L33:
        RtcManager r12 = this.d;
        if (r12 == null) goto L36;
        tf0.i r13 = yq();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r12.J = r13;
    L36:
        RtcManager r14 = this.d;
        if (r14 == null) goto L39;
        Intrinsics.checkNotNullParameter(this, "rtcListener");
        r14.c = this;
    L39:
        RtcManager r15 = this.d;
        if (r15 == null) goto L42;
        r15.J0(this.c);
    L42:
        hd0.c.f().k(2);
    L81:
        if (vm2.d.q0().isUserInfoCenterForwardInit() == true) goto L83;
        getLinkUserCenter().i();
    L83:
        com.bytedance.android.live.liveinteract.plantform.core.n r16 = this.b;
        if (r16 == null) goto L100;
        vlc.d r17 = r16.a;
        if (r17 == null) goto L88;
        r17.addMessageListener(MessageType.LINK_MIC.getKey(), r16);
    L88:
        vlc.d r18 = r16.a;
        if (r18 == null) goto L91;
        r18.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getKey(), r16);
    L91:
        vlc.d r19 = r16.a;
        if (r19 == null) goto L94;
        r19.addMessageListener(MessageType.LINKER.getKey(), r16);
    L94:
        vlc.d r20 = r16.a;
        if (r20 == null) goto L97;
        r20.addMessageListener(MessageType.LINK_SETTING_NOTIFY_MESSAGE.getKey(), r16);
    L97:
        vlc.d r21 = r16.a;
        if (r21 == null) goto L100;
        r21.addMessageListener(MessageType.CONTROL.getKey(), r16);
    L100:
        com.bytedance.android.live.liveinteract.plantform.core.n r22 = this.b;
        if (r22 == null) goto L103;
        Intrinsics.checkNotNullParameter(this, "listener");
        r22.c.add(this);
    L103:
        this.n = new m0(((Widget) this).context, com.bytedance.android.live.liveinteract.api.utils.m.j(this), this.d, this);
        Pair r23 = com.bytedance.live.datacontext.d.a(BaseGuestLinkWidget$onCreate$pair$1.INSTANCE);
        ((GuestRtcLinkerContext) r23.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r23.getFirst(), "guest_rtc_linker_service");
        this.p.add((Disposable) r23.getSecond());
        y r24 = getLinkUserCenter();
        RtcManager r25 = this.d;
        Intrinsics.checkNotNull(r25);
        this.e = new com.bytedance.android.live.liveinteract.plantform.datamerge.j(this, r24, new we0.a(), r25, this, ((Widget) this).dataCenter);
        this.f = new com.bytedance.android.live.liveinteract.plantform.datamerge.h(this, r24, r25, ((Widget) this).dataCenter);
        this.g = new com.bytedance.android.live.liveinteract.plantform.datamerge.e(this, r24, r25, ((Widget) this).dataCenter);
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d r26 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d();
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r27 = this.e;
        if (r27 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L106:
        r27.g1(r26);
        Pair r28 = com.bytedance.live.datacontext.d.a(BaseGuestLinkWidget$initLinkUserDataMergeCenter$pair$1.INSTANCE);
        LinkUserDataMergeContext r29 = (LinkUserDataMergeContext) r28.getFirst();
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.d> r30 = r29.getDataMergeCenter();
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r31 = this.e;
        if (r31 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L109:
        r30.d(r31);
        r29.getDynamicHandler().d(r26);
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.b> r32 = r29.getLinkRoomFightDataMergeCenter();
        com.bytedance.android.live.liveinteract.plantform.datamerge.h r33 = this.f;
        if (r33 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L112:
        r32.d(r33);
        r29.share(((Widget) this).dataCenter);
        this.p.add((Disposable) r28.getSecond());
        return;
    L43:
        String r34 = LinkmicOnlineFloatWindowManager.Y;
        if (LinkmicOnlineFloatWindowManager.c.a().q == null) goto L78;
        this.c = LinkmicOnlineFloatWindowManager.c.a().q;
        x r35 = LinkmicOnlineFloatWindowManager.c.a().r;
        if (r35 == null) goto L52;
        r35.f = this.c;
        RtcManager r36 = this.d;
        if (r36 == null) goto L50;
        r36.a0(pg6.a.a(r35), null);
    L50:
        LinkmicOnlineFloatWindowManager.c.a().v(null);
    L52:
        if (je0.d.U() == false) goto L58;
        v0 r37 = this.c;
        if (r37 == null) goto L58;
        d0 r38 = r37.getLiveCore();
        if (r38 == null) goto L58;
        SurfaceView r39 = (SurfaceView) this.r.getValue();
        r38.x();
    L58:
        com.bytedance.live.datacontext.m r40 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).m();
        if (r40 == null) goto L61;
        r40.setValue(Boolean.TRUE);
    L61:
        LinkmicOnlineFloatWindowManager.c.a().q = null;
        tc0.c r41 = LinkmicOnlineFloatWindowManager.c.a().n;
        if (r41 == null) goto L66;
        RtcManager r42 = this.d;
        if (r42 == null) goto L66;
        Intrinsics.checkNotNullParameter(r41, "<set-?>");
        r42.J = r41;
    L66:
        RtcManager r43 = this.d;
        if (r43 == null) goto L69;
        Intrinsics.checkNotNullParameter(this, "rtcListener");
        r43.c = this;
    L69:
        RtcManager r44 = this.d;
        if (r44 == null) goto L72;
        r44.J0(this.c);
    L72:
        hd0.c.f().k(2);
        jg6.a r45 = LinkmicOnlineFloatWindowManager.c.a().w;
        if (r45 == null) goto L81;
        kg6.e r46 = r45.b();
        if (r46 == null) goto L81;
        ((Widget) this).dataCenter.put("data_self_is_silenced", Boolean.valueOf(r46.q()));
        goto L81
    L78:
        if (hd0.c.f().j() == true) goto L81;
        hd0.c.f().k(0);
        goto L81
    L8:
        com.bytedance.live.datacontext.m r47 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r47 == null) goto L12;
        r2 = (IRoom) r47.getValue();
        if (r2 != null) goto L13;
    L12:
        r2 = vh7.f.c(IRoom.class);
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onDestroy() {
        if (vm2.d.q0().isUserInfoCenterForwardInit() == false) goto L5;
        getLinkUserCenter().m();
    L6:
        boolean r1 = true;
        if (Eq() == true) goto L21;
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L15;
        gd0.i r2 = r0.getInteractFloatWindowService();
        if (r2 == null) goto L15;
        if (((com.bytedance.android.live.liveinteract.service.g) r2).b() != true) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == true) goto L21;
        RtcManager r4 = this.d;
        if (r4 == null) goto L20;
        r4.onDestroy();
    L20:
        this.d = null;
        this.p.dispose();
    L15:
        r3 = false;
    L21:
        com.bytedance.android.live.liveinteract.plantform.core.n r5 = this.b;
        if (r5 == null) goto L47;
        vlc.d r6 = r5.a;
        if (r6 == null) goto L27;
        r6.removeMessageListener(r5);
    L27:
        if (r5.b.isDisposed() == true) goto L29;
        r5.b.dispose();
    L29:
        Integer r7 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r7 != null) goto L33;
    L46:
        r5.c.clear();
        goto L47
    L33:
        if (2 != r7.intValue()) goto L46;
        if (jc1.k.n(IMultiLinkServiceExternal.class).getControlServiceExternal().c() == true) goto L46;
        IInteractService r8 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r8 == null) goto L43;
        gd0.i r9 = r8.getInteractFloatWindowService();
        if (r9 == null) goto L43;
        if (((com.bytedance.android.live.liveinteract.service.g) r9).b() != true) goto L43;
    L44:
        if (r1 == true) goto L46;
        long r10 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.v("live_end");
        ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).leave(r5.c().getId(), "live_end").compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.plantform.core.o(r10), new com.bytedance.android.live.liveinteract.plantform.core.p(r10));
    L43:
        r1 = false;
    L47:
        super.onDestroy();
        m0 r11 = this.n;
        if (r11 == null) goto L50;
        r11.c();
    L50:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r12 = this.e;
        if (r12 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L53:
        r12.detach();
        com.bytedance.android.live.liveinteract.plantform.datamerge.h r13 = this.f;
        if (r13 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L56:
        r13.detach();
        com.bytedance.android.live.liveinteract.plantform.datamerge.e r14 = this.g;
        if (r14 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("linkCrossRoomGameDataMergeCenter");
    L59:
        r14.detach();
        return;
    L5:
        getLinkUserCenter().l();
        goto L6
    }

    public void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        this.o = true;
    }

    public void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        this.o = false;
    }

    public final void onStart() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStart();
        if (this.s == true) goto L43;
        this.s = true;
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r0 = this.e;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L8:
        r0.O1();
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r1 = this.e;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L11:
        r1.g1(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.f());
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r2 = this.e;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L14:
        r2.g1(new h0(false, ((Widget) this).dataCenter));
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r3 = this.e;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L17:
        r3.g1(new fh0.e(((Widget) this).dataCenter, 16));
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r4 = this.e;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L20:
        r4.M0(new fh0.b(((Widget) this).dataCenter));
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r5 = this.e;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L23:
        r5.M0(new fh0.a(getLinkUserCenter(), ((Widget) this).dataCenter));
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r6 = this.e;
        if (r6 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L26:
        r6.M0(new fh0.f(((Widget) this).dataCenter));
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r7 = this.e;
        if (r7 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L29:
        r7.M0(new fh0.d(((Widget) this).dataCenter));
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r8 = this.e;
        if (r8 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L32:
        r8.M0(new PaidLinkMicPlayModeHandler(this, getLinkUserCenter(), ((Widget) this).dataCenter));
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r9 = this.e;
        if (r9 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
    L35:
        RtcManager r10 = this.d;
        Intrinsics.checkNotNull(r10);
        r9.M0(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.l(r10, false));
        com.bytedance.android.live.liveinteract.plantform.datamerge.h r11 = this.f;
        if (r11 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L38:
        r11.O1();
        com.bytedance.android.live.liveinteract.plantform.datamerge.e r12 = this.g;
        if (r12 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("linkCrossRoomGameDataMergeCenter");
    L41:
        r12.O1();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.b
    public final hg6.g P2() {
        return this.d;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.b
    public final v0 getLiveVideoClientFactory() {
        return this.c;
    }

    public tf0.i yq() {
        return this.t;
    }

    public BaseGuestLinkWidget(tc0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "dataHolder");
        this.t = r2;
        this.h = "";
        this.j = "leave_normally";
        this.m = "";
        this.p = new CompositeDisposable();
        this.r = LazyKt.lazy(new BaseGuestLinkWidget$surfaceViewByLazy$2(this));
    }

    public void F3(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        RtcManager r0 = this.d;
        if (r0 != null) goto L5;
    L12:
        com.bytedance.android.live.liveinteract.plantform.core.n r1 = this.b;
        if (r1 == null) goto L15;
        r1.e(r4);
    L15:
        v0 r5 = this.c;
        if ((r5 instanceof u0) == true) goto L18;
        r5 = null;
    L18:
        u0 r6 = (u0) r5;
        if (r6 == null) goto L22;
        r6.release();
        return;
    L22:
        return;
    L5:
        if (r0.l != true) goto L12;
        this.j = r4;
        if (r0 == null) goto L9;
        r0.M0();
    L9:
        m0 r7 = this.n;
        if (r7 == null) goto L15;
        r7.c();
        goto L15
    }

    public void Fc(z0 r12) {
        Intrinsics.checkNotNullParameter(r12, MultiLinkOpenSource.MESSAGE);
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L11;
        ai0.e r1 = r0.getAdventureService();
        if (r1 == null) goto L11;
        if (ai0.e.a.a(r1) != true) goto L11;
        ALogger.i("ttlive_multi_advance_link", "onReceivePermit return, cause: AdventureLinkService.interceptMultiLink");
        return;
    L11:
        if (GuestLinkContext.Companion.b(true) == false) goto L13;
        ALogger.i("ttlive_multi_advance_link", "onReceivePermit return, cause: GuestLinkContext.interceptMultiLink");
    L13:
        this.k = r12.getBaseMessage2().getCreateTime();
        this.l = r12.getBaseMessage2().getCreateTime();
        this.m = "apply";
        com.bytedance.android.live.liveinteract.plantform.core.n r2 = this.b;
        if (r2 == null) goto L17;
        r2.d();
    L17:
        if (vm2.i.c() == true) goto L19;
        return;
    L19:
        if (je0.d.f() == 4) goto L37;
        ALogger.i("ttlive_multi_advance_link", "received permit msg");
        j1 r3 = r12.getGuestLinkMicInfo();
        String r4 = null;
        if (r3 == null) goto L23;
        String r5 = r3.getRtcExtInfo();
    L24:
        j1 r6 = r12.getGuestLinkMicInfo();
        if (r6 == null) goto L27;
        r4 = r6.getLiveCoreExtInfo();
    L27:
        if (r5 != null) goto L29;
    L34:
        ALogger.e("ttlive_multi_advance_link", "invalid link mic info " + r12.getGuestLinkMicInfo());
        return;
    L29:
        if ((!StringsKt.isBlank(r5)) != true) goto L34;
        if (r4 == null) goto L34;
        if ((!StringsKt.isBlank(r4)) != true) goto L34;
        tc0.c.h().k = r5;
        tc0.c.h().m = r4;
        ALogger.i("ttlive_multi_advance_link", "advance link on apply");
        Set<Long> r13 = InteractLinkFullLinkMonitor.a;
        nd0.c.o(nd0.c.a, LinkMonitorData.AdvanceStartOnApply, new JSONObject(), 0, null, false, 28);
        Aq(r4, true, true);
        return;
    L23:
        r5 = null;
        goto L24
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.s
    public final void Ja(com.bytedance.android.livesdk.link.model.bridge.h1 r5) {
        Intrinsics.checkNotNullParameter(r5, MultiLinkOpenSource.MESSAGE);
        if (r5.getMLowBalanceForPaidLinkContent() == null) goto L13;
        int r0 = fj0.d.a;
        long r1 = r5.getMessageId3();
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("msg_id", Long.valueOf(r1));
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("low_balance_for_paid_link", r2);
        com.bytedance.android.live.liveinteract.plantform.core.n r3 = this.b;
        if (r3 == null) goto L7;
        tf0.g.a(r3, "low_balance_for_paid_link");
    L7:
        ILinkerLowBalanceForPaidLinkmicContent r6 = r5.getMLowBalanceForPaidLinkContent();
        if (r6 == null) goto L10;
        String r7 = r6.getToast();
    L11:
        f2.c(r7, 0);
        return;
    L10:
        r7 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L(String r7) {
        m0 r0 = this.n;
        if (r0 == null) goto L6;
        r0.b();
    L6:
        if (TextUtils.equals(r7, yq().u()) == true) goto L8;
        return;
    L8:
        if (this.l <= 0) goto L12;
        long r1 = System.currentTimeMillis() - this.l;
        com.bytedance.android.live.liveinteract.api.utils.n.v(getScene(), r1, this.m);
        this.l = 0;
        this.m = "";
        return;
    }

    public void Y(com.bytedance.android.livesdk.link.model.bridge.h1 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    public void b1(Throwable r1) {
        Bq();
    }

    public void b2(com.bytedance.android.live.network.response.e<i0> r7) {
        Intrinsics.checkNotNullParameter(r7, "response");
        m0 r0 = this.n;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        String r2 = null;
        if (((Boolean) vm2.e.n.getValue(null, vm2.e.a[12])).booleanValue() == true) goto L8;
        hd0.c.f().k(2);
    L8:
        i0 r1 = r7.data;
        if (r1 == null) goto L24;
        List r3 = r1.getLinkedUsers();
        if (r3 == null) goto L24;
        Iterator r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L24;
        com.bytedance.android.livesdk.link.model.bridge.k r5 = (com.bytedance.android.livesdk.link.model.bridge.k) r4.next();
        IBaseUser r6 = r5.getUser();
        if (r6 == null) goto L18;
        String r8 = r6.getIdString();
    L20:
        if (Intrinsics.areEqual(r8, je0.d.b0().toString()) == false) goto L14;
        if (r5.getSilenceStatus() != 1) goto L14;
        tc0.c.h().C = true;
        goto L14
    L18:
        r8 = null;
    L24:
        tc0.c.h().D = this.o;
        com.bytedance.android.live.liveinteract.plantform.utils.k.a(((Widget) this).context, yq().getScene());
        i0 r9 = r7.data;
        if (r9 != null) goto L27;
    L39:
        boolean r10 = false;
        if (vm2.i.c() == false) goto L55;
        ALogger.i("ttlive_multi_advance_link", "server join channel success");
        RtcManager r11 = this.d;
        if (r11 != null) goto L44;
    L51:
        ALogger.e("ttlive_multi_advance_link", "fallback to normal start");
        IJoinChannelResult r12 = r7.data.castToOrNull(IJoinChannelResult.class);
        if (r12 == null) goto L54;
        r2 = r12.getLiveCoreSettings();
    L54:
        Aq(r2, false, true);
    L59:
        i0 r13 = r7.data;
        if (r13 == null) goto L63;
        String r14 = r13.getToken();
        if (r14 == null) goto L63;
    L64:
        this.h = r14;
        IJoinChannelResult r15 = r7.data.castToOrNull(IJoinChannelResult.class);
        if (r15 == null) goto L67;
        r15.getPayCount();
    L67:
        IJoinChannelResult r16 = r7.data.castToOrNull(IJoinChannelResult.class);
        if (r16 == null) goto L70;
        r10 = r16.getPaidLinkmic();
    L70:
        this.i = r10;
        JSONArray r17 = new JSONArray();
        r17.put(7);
        LinkAudienceApi r18 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        String r19 = r17.toString();
        IRoom r20 = this.a;
        if (r20 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L73:
        ((SingleSubscribeProxy) r18.getAudienceSettings(r19, r20.getId()).compose(RxUtil.rxSchedulerHelper()).as(autoDispose())).subscribe(a.a, b.a);
        LinkAudienceApi r21 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        IRoom r22 = this.a;
        if (r22 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L76:
        ((ObservableSubscribeProxy) r21.fetchInteractEntrances(r22.getId()).compose(RxUtil.rxSchedulerHelper()).as(autoDispose())).subscribe(new c(this), d.a);
        return;
    L63:
        r14 = "";
        goto L64
    L44:
        if (r11.k != true) goto L51;
        InteractLinkFullLinkMonitor.A();
        RtcManager r23 = this.d;
        if (r23 != null) goto L48;
    L50:
        ALogger.w("ttlive_multi_advance_link", "wait rtc to finish join");
        goto L59
    L48:
        if (r23.l != true) goto L50;
        r23.H0();
        goto L59
    L55:
        ALogger.i("ttlive_multi_advance_link", "normal start");
        IJoinChannelResult r24 = r7.data.castToOrNull(IJoinChannelResult.class);
        if (r24 == null) goto L58;
        r2 = r24.getLiveCoreSettings();
    L58:
        Aq(r2, false, true);
        goto L59
    L27:
        if (r9.getLinkedUsers() == null) goto L39;
        if (vm2.d.m().useJoinChannelList == false) goto L39;
        y r25 = getLinkUserCenter();
        if ((r25 instanceof y) == true) goto L33;
        r25 = null;
    L33:
        if (r25 == null) goto L39;
        i0 r26 = r7.data;
        if (r26 == null) goto L38;
        r25.E(r26);
        goto L39
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.bridge.IJoinChannelResultBridge");
    }

    public void c0(Throwable r1) {
        Cq();
    }

    public void f5(com.bytedance.android.livesdk.link.model.bridge.h1 r4) {
        Intrinsics.checkNotNullParameter(r4, MultiLinkOpenSource.MESSAGE);
        com.bytedance.android.live.liveinteract.api.utils.g.n("server_sys_kickout", new HashMap(), yq(), true);
        this.j = "sys_kick_out";
        F3("sys_kick_out");
    }

    public void l1(g1 r1) {
        Cq();
    }

    public void m0(Throwable r3) {
        if ((r3 instanceof ApiServerException) == false) goto L5;
    L7:
        Bq();
        if (r3 == null) goto L10;
        String r0 = r3.getMessage();
    L11:
        com.bytedance.android.live.liveinteract.plantform.utils.r.b("join channel failed", r0);
        com.bytedance.android.live.liveinteract.api.utils.g.r("join_fail", r3);
        return;
    L10:
        r0 = null;
        goto L11
    L5:
        if (vm2.i.j() == false) goto L7;
        this.j = "join_channel_fail";
        F3("join_channel_fail");
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void onUserJoined(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        com.bytedance.android.live.liveinteract.plantform.utils.r.a("onUserJoined");
    }

    public void x2(z0 r3) {
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        if (((int) r3.getType2()) == 3) goto L5;
    L7:
        this.j = "kick_out";
        F3("kick_out");
        return;
    L5:
        if (TextUtils.isEmpty(r3.getPrompts()) == true) goto L7;
        r3.getPrompts();
        goto L7
    }

    public void xf(z0 r6) {
        Intrinsics.checkNotNullParameter(r6, MultiLinkOpenSource.MESSAGE);
        if (vm2.i.c() == false) goto L20;
        ALogger.i("ttlive_multi_advance_link", "received invite msg");
        j1 r0 = r6.getGuestLinkMicInfo();
        String r2 = null;
        if (r0 == null) goto L7;
        String r1 = r0.getRtcExtInfo();
    L8:
        j1 r3 = r6.getGuestLinkMicInfo();
        if (r3 == null) goto L11;
        r2 = r3.getLiveCoreExtInfo();
    L11:
        if (r1 != null) goto L13;
    L18:
        ALogger.e("ttlive_multi_advance_link", "invalid link mic info " + r6.getGuestLinkMicInfo());
        return;
    L13:
        if ((!StringsKt.isBlank(r1)) != true) goto L18;
        if (r2 == null) goto L18;
        if ((!StringsKt.isBlank(r2)) != true) goto L18;
        tc0.c.h().k = r1;
        tc0.c.h().m = r2;
        return;
    L7:
        r1 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.s
    public final void Eh(String r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, "secToUserId");
        IInteractService r16 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r16 == null) goto L11;
        ai0.e r17 = r16.getAdventureService();
        if (r17 == null) goto L11;
        if (ai0.e.a.a(r17) != true) goto L11;
        ALogger.i("ttlive_multi_advance_link", "onStartReply return, cause: AdventureLinkService.interceptMultiLink");
        return;
    L11:
        if (GuestLinkContext.Companion.b(true) == false) goto L15;
        ALogger.i("ttlive_multi_advance_link", "onStartReply return, cause: GuestLinkContext.interceptMultiLink");
        return;
    L15:
        if (vm2.i.c() == true) goto L17;
        return;
    L17:
        if (r15 == ReplyType.Agree.ordinal()) goto L19;
        return;
    L19:
        if (je0.d.f() == 4) goto L33;
        String r18 = tc0.c.h().m;
        if (r18 != null) goto L23;
    L29:
        ALogger.e("ttlive_multi_advance_link", "invalid advance reply link mic info");
        return;
    L23:
        if ((!StringsKt.isBlank(r18)) != true) goto L29;
        String r19 = tc0.c.h().k;
        if (r19 == null) goto L29;
        if ((!StringsKt.isBlank(r19)) != true) goto L29;
        ALogger.i("ttlive_multi_advance_link", "advance start on reply");
        Set<Long> r110 = InteractLinkFullLinkMonitor.a;
        nd0.c.o(nd0.c.a, LinkMonitorData.AdvanceStartOnReply, new JSONObject(), 0, null, false, 28);
        UtilityKotlinExtentionsKt.s(0, false, true, new BaseGuestLinkWidget$onStartReply$1(this), 3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void G9(long r1, Exception r3) {
        com.bytedance.android.live.liveinteract.plantform.core.n r2 = this.b;
        if (r2 == null) goto L6;
        r2.e("leave_on_rtc_error");
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J3(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        com.bytedance.android.live.liveinteract.plantform.core.g.a(r2, r3);
    }

    public void R(long r1, Exception r3) {
        boolean r2 = com.bytedance.android.live.liveinteract.videotalk.a.a;
        com.bytedance.android.live.liveinteract.videotalk.a.a = false;
        com.bytedance.android.live.liveinteract.plantform.core.n r4 = this.b;
        if (r4 == null) goto L6;
        r4.e("leave_on_rtc_error");
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void S1(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.c(r2, r3);
    }

    public void T3(com.bytedance.android.livesdk.chatroom.model.interact.m r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "result");
        IInteractService r5 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r5 == null) goto L11;
        ai0.e r6 = r5.getAdventureService();
        if (r6 == null) goto L11;
        if (ai0.e.a.a(r6) != true) goto L11;
        ALogger.i("ttlive_multi_advance_link", "onReplySuccess return, cause: AdventureLinkService.interceptMultiLink");
        return;
    L11:
        if (GuestLinkContext.Companion.b(true) == false) goto L15;
        ALogger.i("ttlive_multi_advance_link", "onReplySuccess return, cause: GuestLinkContext.interceptMultiLink");
        return;
    L15:
        if (r4 != ReplyType.Agree.ordinal()) goto L20;
        com.bytedance.android.live.liveinteract.plantform.core.n r7 = this.b;
        if (r7 == null) goto L21;
        r7.d();
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Z4(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void d5(dg2.e r4, dg2.e[] r5) {
        Intrinsics.checkNotNullParameter(r4, "localQuality");
        Intrinsics.checkNotNullParameter(r5, "remoteQualities");
        com.bytedance.android.live.liveinteract.plantform.core.g.d(r4, r5);
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L5;
        Boolean r7 = (Boolean) r6.get("data_rtc_network_status_report", Boolean.FALSE);
    L7:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L14;
        IInteractService r8 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r8 == null) goto L15;
        ih0.b r9 = r8.dynamicService(((Widget) this).dataCenter);
        if (r9 == null) goto L16;
        r9.Dk("logic_widget", "rtc_network_quality", n0.a(r4), false);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r7 = null;
        goto L7
    }

    public void e1(String r1, long r2) {
        getLinkUserCenter().getClass();
    }

    public void f0(long r1, Exception r3) {
        RtcManager r2 = this.d;
        if (r2 == null) goto L5;
        r2.M0();
    L5:
        m0 r4 = this.n;
        if (r4 == null) goto L9;
        r4.c();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void n2(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.b(r2, r3);
    }

    public final void Aq(String r4, boolean r5, boolean r6) {
        ALogger.i("ttlive_multi_advance_link", "initAndStartEngine isAdvanceStart " + r5);
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L11;
        ai0.e r1 = r0.getAdventureService();
        if (r1 == null) goto L11;
        if (ai0.e.a.a(r1) != true) goto L11;
        ALogger.i("ttlive_multi_advance_link", "initAndStartEngine return, cause: AdventureLinkService.interceptMultiLink");
        return;
    L11:
        if (GuestLinkContext.Companion.b(true) == false) goto L14;
        ALogger.i("ttlive_multi_advance_link", "initAndStartEngine return, cause: GuestLinkContext.interceptMultiLink");
        return;
    L14:
        RtcManager r2 = this.d;
        if (r2 == null) goto L18;
        r2.K0(r5);
    L18:
        if (((Boolean) vm2.d.x6.getValue(null, vm2.d.a[385(0x181, float:5.4E-43)])).booleanValue() == true) goto L20;
        this.c = ga(r4, r6);
    L25:
        if (je0.d.U() == false) goto L31;
        v0 r7 = this.c;
        if (r7 == null) goto L31;
        d0 r8 = r7.getLiveCore();
        if (r8 == null) goto L31;
        SurfaceView r9 = (SurfaceView) this.r.getValue();
        r8.x();
    L31:
        v0 r10 = this.c;
        if (r10 == null) goto L36;
        com.bytedance.android.live.pushstream.d r11 = r10.getLiveStream();
        if (r11 == null) goto L36;
        r11.M0("start multi link", new uv0.a(LiveRequestSourceRole.Business, "BaseGuestLinkWidget.initAndStartEngine", null));
    L36:
        RtcManager r12 = this.d;
        if (r12 != null) goto L39;
    L41:
        if (r12 == null) goto L45;
        RtcManager.L0(r12, this.c, this, 12);
        return;
    L45:
        return;
    L39:
        if (r12.k != true) goto L41;
        RtcManager.L0(r12, this.c, this, 8);
        return;
    L20:
        if (this.c != null) goto L22;
        this.c = ga(r4, r6);
    L22:
        this.c = this.c;
        goto L25
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Hf(int r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "deviceId");
        Intrinsics.checkNotNullParameter(r2, "deviceId");
    }

    public void J(String[] r5, boolean[] r6, int[] r7) {
        if (r5 == null) goto L54;
        if (r6 == null) goto L62;
        int r8 = r5.length;
        String r0 = yq().getInteractId();
        if (r0 != null) goto L9;
        r0 = "0";
    L9:
        int r2 = 0;
    L10:
        if (r2 >= r8) goto L63;
        if (TextUtils.equals(r5[r2], r0) == false) goto L53;
        if (r6[r2] == false) goto L53;
        y r9 = getLinkUserCenter();
        u0 r10 = null;
        if ((r9 instanceof y) == true) goto L18;
        r9 = null;
    L18:
        if (r9 == null) goto L20;
        ILinkPlayerInfoBridge r11 = r9.o("", r0);
    L21:
        if (r11 != null) goto L23;
    L45:
        u0 r12 = this.c;
        if ((r12 instanceof u0) == false) goto L49;
        r10 = r12;
    L49:
        u0 r13 = r10;
        if (r13 == null) goto L61;
        r13.x0();
        return;
    L61:
        return;
    L23:
        if (com.bytedance.android.live.liveinteract.plantform.model.n.f(r11) != true) goto L45;
        u0 r14 = this.c;
        if ((r14 instanceof u0) == false) goto L28;
        r10 = r14;
    L28:
        u0 r15 = r10;
        if (r15 == null) goto L59;
        kd1.b r16 = r11.getMicDress();
        if (r16 == null) goto L39;
        kd1.c r17 = r16.getVoiceWave();
        if (r17 == null) goto L39;
        py.k r18 = r17.getMediumImg();
        if (r18 == null) goto L39;
        List r19 = r18.getUrls();
        if (r19 == null) goto L39;
        String r20 = (String) CollectionsKt.getOrNull(r19, 0);
    L39:
        kd1.b r21 = r11.getMicDress();
        if (r21 == null) goto L44;
        kd1.c r22 = r21.getVoiceWave();
        if (r22 == null) goto L44;
        r22.getDressId();
    L44:
        r15.a();
        return;
    L59:
        return;
    L20:
        r11 = null;
    L53:
        r2 = r2 + 1;
        goto L10
    L63:
        return;
    L62:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Rj(int r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void x1(LiveWrappedNetworkDetectionLinkType r1, int r2, double r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r1, "type");
    }

    public final void xq(OperateType r5, int r6, qh0.d<rh0.a> r7) {
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

    public void L0(String r3, TextureView r4, int r5, int r6) {
        long r7 = hd0.c.f().e;
        if (TextUtils.equals(r3, yq().u()) == false) goto L8;
        if (r7 <= 0) goto L8;
        hd0.c.f().e = 0;
    L8:
        if (TextUtils.equals(r3, yq().u()) == true) goto L10;
        return;
    L10:
        if (this.k <= 0) goto L14;
        long r8 = System.currentTimeMillis() - this.k;
        com.bytedance.android.live.liveinteract.plantform.utils.x.I(getScene(), r8);
        this.k = 0;
        return;
    }

    public void b4(String r3, z.a r4, int r5, int r6) {
        long r7 = hd0.c.f().e;
        if (TextUtils.equals(r3, yq().u()) == false) goto L8;
        if (r7 <= 0) goto L8;
        hd0.c.f().e = 0;
    L8:
        if (TextUtils.equals(r3, yq().u()) == true) goto L10;
        return;
    L10:
        if (this.k <= 0) goto L14;
        long r8 = System.currentTimeMillis() - this.k;
        com.bytedance.android.live.liveinteract.plantform.utils.x.I(getScene(), r8);
        this.k = 0;
        return;
    }

    public void h1(String r3, SurfaceView r4, int r5, int r6) {
        long r7 = hd0.c.f().e;
        if (TextUtils.equals(r3, yq().u()) == false) goto L8;
        if (r7 <= 0) goto L8;
        hd0.c.f().e = 0;
    L8:
        if (TextUtils.equals(r3, yq().u()) == true) goto L10;
        return;
    L10:
        if (this.k <= 0) goto L14;
        long r8 = System.currentTimeMillis() - this.k;
        com.bytedance.android.live.liveinteract.plantform.utils.x.I(getScene(), r8);
        this.k = 0;
        return;
    }

    public static void wq(BaseGuestLinkWidget r15, int r16, int r17, LinkApplyType r18, String r19, Integer r20, Integer r21, boolean r22, boolean r23, int r24, xc.a r25, int r26) {
        if ((r26 & 8) == 0) goto L5;
        LinkApplyType r4 = LinkApplyType.NORMAL;
    L7:
        if ((r26 & 32) == 0) goto L9;
        Integer r6 = null;
    L11:
        if ((r26 & 64) == 0) goto L13;
        Integer r7 = null;
    L15:
        if ((r26 & 256) == 0) goto L17;
        boolean r8 = false;
    L19:
        if ((r26 & 512) == 0) goto L21;
        boolean r9 = false;
    L23:
        if ((r26 & 1024) == 0) goto L25;
        int r10 = 0;
    L27:
        if ((r26 & 4096) == 0) goto L29;
        xc.a r11 = null;
    L30:
        r15.getClass();
        Intrinsics.checkNotNullParameter(r4, "applyType");
        Intrinsics.checkNotNullParameter(r19, "fromSource");
        if (vm2.d.p0() == false) goto L54;
        IRoom r0 = r15.a;
        if (r0 == null) goto L35;
        boolean r1 = true;
    L36:
        if (r1 == false) goto L54;
        if (r0 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L41:
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.e(r0, null) == false) goto L54;
        IRoom r2 = r15.a;
        if (r2 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L46:
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.b(r2) == true) goto L54;
        f2.b(2131921181, 0);
        TalkRoomBusinessFullLinkMonitor r3 = TalkRoomBusinessFullLinkMonitor.a;
        IRoom r5 = r15.a;
        if (r5 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L50:
        boolean r12 = com.bytedance.android.livesdk.chatroom.paidlive.e.e(r5, null);
        IRoom r13 = r15.a;
        if (r13 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L53:
        boolean r14 = com.bytedance.android.livesdk.chatroom.paidlive.e.b(r13);
        r3.getClass();
        TalkRoomBusinessFullLinkMonitor.e0(r12, r14);
        return;
    L35:
        r1 = false;
    L54:
        r15.xq(OperateType.APPLY, r16, new q(r15, r16, r17, r4, r19, r6, r7, r8, r9, r10, r11));
        return;
    L29:
        r11 = r25;
        goto L30
    L25:
        r10 = r24;
        goto L27
    L21:
        r9 = r23;
        goto L23
    L17:
        r8 = r22;
        goto L19
    L13:
        r7 = r21;
        goto L15
    L9:
        r6 = r20;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }
}
