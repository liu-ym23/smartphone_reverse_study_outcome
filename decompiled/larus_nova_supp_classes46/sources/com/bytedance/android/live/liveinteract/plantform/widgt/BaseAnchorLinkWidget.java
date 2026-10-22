package com.bytedance.android.live.liveinteract.plantform.widgt;

import android.os.Build;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.AnchorRtcLinkerContext;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.base.h;
import com.bytedance.android.live.liveinteract.plantform.core.RtcManager;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.AnchorParamChangeListener;
import com.bytedance.android.live.liveinteract.plantform.utils.n0;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.d1;
import com.bytedance.android.livesdk.chatroom.model.h1;
import com.bytedance.android.livesdk.chatroom.model.i1;
import com.bytedance.android.livesdk.chatroom.model.j2;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.bridge.i0;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import uf2.z;
import zf2.s0;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Deprecated(message = "双人聊待下线")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/widgt/BaseAnchorLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/base/h;", "T", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "", "Lcom/bytedance/android/live/liveinteract/plantform/base/a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseAnchorLinkWidget<T extends com.bytedance.android.live.liveinteract.plantform.base.h> extends PlatformMultiLinkWidget implements com.bytedance.android.live.liveinteract.plantform.core.k, uf0.a, com.bytedance.android.live.liveinteract.plantform.base.a {
    public IRoom a;
    public com.bytedance.android.live.liveinteract.plantform.core.f b;
    public RtcManager c;
    public int d;
    public String e;
    public final ArrayList<IBaseUser> f;
    public AnchorParamChangeListener g;
    public final HashMap<String, Long> h;
    public final HashMap<String, Long> i;
    public String j;
    public final CompositeDisposable k;
    public boolean l;
    public final tf0.i m;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r5) {
            h1 r6 = (h1) ((com.bytedance.android.live.network.response.e) r5).data;
            if (r6 == null) goto L34;
            List r7 = r6.getSettings();
            if (r7 == null) goto L46;
            Iterator<T> r8 = r7.iterator();
        L8:
            if (r8.hasNext() == false) goto L47;
            ILinkmicAudienceSetting r0 = (ILinkmicAudienceSetting) r8.next();
            Integer r1 = r0.getKey();
            int r2 = ILinkmicAudienceSetting.LinkmicAudienceSettingKey.ENABLE_MIC_DRESS_BUTTON.getValue();
            if (r1 == null) goto L8;
            if (r1.intValue() != r2) goto L8;
            Gson r3 = GsonHelper.get();
            i1 r4 = r0.getValue();
            if (r4 == null) goto L17;
            String r9 = r4.getExtra();
        L18:
            j2 r10 = (j2) GsonProtectorUtils.fromJson(r3, r9, j2.class);
            com.bytedance.android.livesdk.sharedpref.e r11 = com.bytedance.android.livesdk.sharedpref.c.N0;
            if (r10 == null) goto L23;
            Integer r12 = r10.a;
            if (r12 == null) goto L23;
            int r13 = r12.intValue();
        L24:
            Integer r14 = Integer.valueOf(r13);
            r11.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r11, r14);
            com.bytedance.android.livesdk.sharedpref.e r15 = com.bytedance.android.livesdk.sharedpref.c.P0;
            if (r10 == null) goto L28;
            Object r16 = r10.b;
            if (r16 == null) goto L28;
        L29:
            r15.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r15, r16);
            if (r15.getValue() == null) goto L8;
            if (((List) r15.getValue()).isEmpty() == false) goto L8;
            com.bytedance.android.livesdk.sharedpref.f.d(r11, 0);
        L28:
            r16 = new ArrayList();
        L23:
            r13 = 0;
            goto L24
        L17:
            r9 = null;
            goto L18
        L47:
            return;
        L46:
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
        public final /* synthetic */ BaseAnchorLinkWidget a;

        public c(BaseAnchorLinkWidget r1) {
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

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void D1(String r1, ByteBuffer r2, int r3) {
    }

    @Override // uf0.a
    public final void If() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J(String[] r1, boolean[] r2, int[] r3) {
    }

    public void L2(String r1, Throwable r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void Lb() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.a
    public final hg6.g R1() {
        return null;
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

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Xi(int r1, int r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void al(String r1, int r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void ci() {
    }

    public void e6(String r1, IBaseUser r2, com.bytedance.android.livesdk.chatroom.interact.model.v r3) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    public void eo(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
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

    @Override // uf0.a
    public final void k5(String r1, Throwable r2) {
    }

    public void l(String r1, Throwable r2) {
    }

    @Override // uf0.b
    public final void m0(Throwable r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o0(long r1) {
    }

    public void onPermitSuccess(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void onUserJoined(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
    }

    @Override // uf0.a
    public final void vf(ILinkMicGuideMessageBridge r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wf(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wk(String r1) {
    }

    public abstract v0 wq();

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void y0(String r1, SurfaceView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void z7() {
    }

    public abstract int zq();

    public final IRoom getRoom() {
        IRoom r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L5:
        return r0;
    }

    public void o() {
        com.bytedance.android.live.liveinteract.plantform.utils.r.a("start engine success");
        Iterator<IBaseUser> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        IBaseUser r1 = r0.next();
        com.bytedance.android.live.liveinteract.plantform.core.f r2 = this.b;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L8:
        String r3 = r1.getIdString();
        Intrinsics.checkNotNullParameter(r1, "$this$secUidExt");
        r2.f(r3, r1.getCastSecUid());
        goto L4
    L9:
        this.f.clear();
    }

    public final RtcManager yq() {
        RtcManager r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rtcManager");
    L5:
        return r0;
    }

    public void M1() {
        hd0.c.f().k(0);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.put("cmd_interact_state_change", new a1(8));
    L5:
        xs2.b.a().post(new com.bytedance.android.live.liveinteract.d(1));
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onCreate() {
        super.onCreate();
        this.a = (IRoom) ((Widget) this).dataCenter.get("data_room", vh7.f.c(IRoom.class));
        com.bytedance.android.live.liveinteract.plantform.core.f r0 = new com.bytedance.android.live.liveinteract.plantform.core.f(((Widget) this).dataCenter, this.m);
        this.b = r0;
        vlc.d r1 = r0.a;
        if (r1 == null) goto L5;
        r1.addMessageListener(MessageType.LINK_MIC.getKey(), r0);
    L5:
        IRoom r2 = this.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L8:
        this.c = new RtcManager(r2, this.m, null, true);
        if (vm2.d.a() == true) goto L17;
        pc0.e r3 = jc1.k.n(IMultiLinkServiceExternal.class).createRevRtcData();
        if (r3 == null) goto L17;
        RtcManager r4 = this.c;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("rtcManager");
    L15:
        if (r4 == null) goto L17;
        r4.d0(r3.b);
    L17:
        this.d = zq();
        if (vm2.d.q0().isUserInfoCenterForwardInit() == true) goto L20;
        getLinkUserCenter().i();
    L20:
        com.bytedance.android.live.liveinteract.plantform.core.f r5 = this.b;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L23:
        r5.a(this);
        AnchorParamChangeListener r6 = new AnchorParamChangeListener(null);
        this.g = r6;
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L26;
        r7.observeForever("data_interact_anchor_param_change", r6);
    L26:
        Pair r8 = com.bytedance.live.datacontext.d.a(BaseAnchorLinkWidget$onCreate$pair$1.INSTANCE);
        ((AnchorRtcLinkerContext) r8.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r8.getFirst(), "rtc_anchor_linker_service");
        this.k.add((Disposable) r8.getSecond());
        getLinkUserCenter();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onDestroy() {
        super.onDestroy();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.removeObserver(this.g);
    L6:
        if (vm2.d.q0().isUserInfoCenterForwardInit() == false) goto L8;
        getLinkUserCenter().m();
    L9:
        com.bytedance.android.live.liveinteract.plantform.core.f r1 = this.b;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L12:
        r1.g(this);
        com.bytedance.android.live.liveinteract.plantform.core.f r2 = this.b;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L15:
        r2.b();
        RtcManager r3 = this.c;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("rtcManager");
    L18:
        if (r3 != null) goto L20;
    L27:
        this.k.dispose();
        RtcManager r4 = this.c;
        if (r4 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("rtcManager");
    L30:
        r4.j.removeCallbacksAndMessages(null);
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
        throw null;
    L20:
        if (r3.l != true) goto L27;
        if (jc1.k.n(IMultiLinkServiceExternal.class).getControlServiceExternal().c() == true) goto L27;
        RtcManager r5 = this.c;
        if (r5 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("rtcManager");
    L26:
        r5.M0();
        goto L27
    L8:
        getLinkUserCenter().l();
        goto L9
    }

    public final void onStart() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStart();
        if (this.l == false) goto L5;
        return;
    L5:
        this.l = true;
        Intrinsics.throwUninitializedPropertyAccessException("linkUserDataMergeCenter");
        throw null;
    }

    @Override // uf0.b
    public final void u0() {
        if (je0.d.O() == true) goto L5;
    L12:
        RtcManager r0 = this.c;
        if (r0 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("rtcManager");
    L15:
        if (r0 != null) goto L17;
    L22:
        M1();
        return;
    L17:
        if (r0.l != true) goto L22;
        RtcManager r1 = this.c;
        if (r1 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("rtcManager");
    L21:
        r1.M0();
        return;
    L5:
        if (je0.d.D() == false) goto L12;
        if (je0.d.F() == false) goto L12;
        RtcManager r2 = this.c;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rtcManager");
    L11:
        r2.N0(true, "force open video talk anchor mic");
        goto L12
    }

    public BaseAnchorLinkWidget(tc0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "dataHolder");
        this.m = r2;
        this.e = "";
        this.f = new ArrayList();
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = "";
        this.k = new CompositeDisposable();
    }

    private final void Aq(String r9) {
        IBaseUser r10 = getLinkUserCenter().U4(r9);
        if (r10 == null) goto L14;
        String r11 = r10.getIdString();
        if (r11 == null) goto L15;
        long r0 = System.currentTimeMillis();
        Long r2 = this.h.get(r11);
        if (r2 != null) goto L9;
    L12:
        this.e = r11;
        Long r12 = (Long) tc0.c.h().t.remove(this.e);
        return;
    L9:
        if (r2.longValue() <= 0) goto L11;
        long r1 = r0 - r2.longValue();
        x.B(getScene(), r1);
    L11:
        Long r3 = this.h.remove(r11);
        goto L12
    L15:
        return;
    }

    @Override // uf0.a
    public final void Ba(z0 r5) {
        Intrinsics.checkNotNullParameter(r5, MultiLinkOpenSource.MESSAGE);
        RtcManager r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rtcManager");
    L5:
        if (r0 == null) goto L9;
        boolean r1 = true;
        if (r0.l != true) goto L9;
    L10:
        if (r1 == true) goto L16;
        com.bytedance.android.live.liveinteract.plantform.core.f r2 = this.b;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L14:
        r2.d();
    L16:
        if (this.i.containsKey(r5.getFromUserIdStr()) == false) goto L18;
        this.i.put(r5.getFromUserIdStr(), Long.valueOf(System.currentTimeMillis()));
    L18:
        long r3 = r5.getMessageId2();
        int r4 = x.a;
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("msg_id", Long.valueOf(r3));
        x.t0("anchor_receive_admin_agree_msg", r6);
        com.bytedance.android.live.liveinteract.api.utils.n.o(r5.getMessageId2());
        return;
    L9:
        r1 = false;
        goto L10
    }

    public final void Bq(com.bytedance.android.live.network.response.e<i0> r9) {
        ((Widget) this).dataCenter.put("cmd_interact_state_change", new a1(7));
        com.bytedance.android.live.liveinteract.plantform.utils.k.a(((Widget) this).context, this.m.getScene());
        RtcManager r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rtcManager");
    L5:
        RtcManager.L0(r0, wq(), this, 12);
        JSONArray r1 = new JSONArray();
        r1.put(7);
        LinkAudienceApi r2 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        String r3 = r1.toString();
        IRoom r4 = this.a;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L8:
        ((SingleSubscribeProxy) r2.getAudienceSettings(r3, r4.getId()).compose(RxUtil.rxSchedulerHelper()).as(autoDispose())).subscribe(a.a, b.a);
        LinkAudienceApi r5 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        IRoom r6 = this.a;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L11:
        ((ObservableSubscribeProxy) r5.fetchInteractEntrances(r6.getId()).compose(RxUtil.rxSchedulerHelper()).as(autoDispose())).subscribe(new c(this), d.a);
        i0 r7 = r9.data;
        if (r7 == null) goto L19;
        List r8 = r7.getLinkedUsers();
        if (r8 != null) goto L16;
        return;
    L16:
        if (vm2.d.m().useJoinChannelList == false) goto L21;
        getLinkUserCenter().S4(KotlinTypeUtilsKt.castElementType(r8), r9.data.getClientUIInfo(), r9.data.getVersion(), "joinChannel");
        return;
    L21:
        return;
    }

    public void Ff(z0 r4) {
        Intrinsics.checkNotNullParameter(r4, MultiLinkOpenSource.MESSAGE);
        boolean r1 = false;
        if (((com.bytedance.android.live.liveinteract.multianchor.model.b) r4.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class)).getReplyType() != 1) goto L17;
        RtcManager r5 = this.c;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rtcManager");
    L7:
        if (r5 != null) goto L9;
    L11:
        if (r1 == true) goto L21;
        com.bytedance.android.live.liveinteract.plantform.core.f r6 = this.b;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L15:
        r6.d();
        return;
    L21:
        return;
    L9:
        if (r5.l != true) goto L11;
        r1 = true;
        goto L11
    L17:
        if (TextUtils.isEmpty(((com.bytedance.android.live.liveinteract.multianchor.model.b) r4.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class)).getReplyPrompts()) == true) goto L19;
        f2.c(((com.bytedance.android.live.liveinteract.multianchor.model.b) r4.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class)).getReplyPrompts(), 0);
        return;
    L19:
        f2.b(2131919242, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L(String r9) {
        IBaseUser r10 = getLinkUserCenter().U4(r9);
        if (r10 == null) goto L13;
        String r11 = r10.getIdString();
        if (r11 == null) goto L14;
        long r0 = System.currentTimeMillis();
        Long r2 = this.i.get(r11);
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.longValue() <= 0) goto L11;
        long r1 = r0 - r2.longValue();
        com.bytedance.android.live.liveinteract.api.utils.n.u(getScene(), r1, this.j);
    L11:
        this.i.remove(r11);
        this.j = "";
        return;
    L14:
        return;
    }

    @Override // uf0.b
    public final void b2(com.bytedance.android.live.network.response.e<i0> r4) {
        Intrinsics.checkNotNullParameter(r4, "response");
        if (vm2.e.o() == true) goto L5;
    L7:
        Bq(r4);
        return;
    L5:
        if (Build.VERSION.SDK_INT < 31) goto L7;
        ALogger.d("ttlive_link", "check anchor bluetooth permission");
        ArrayList r0 = new ArrayList();
        r0.add(new qh0.f.a(((Widget) this).context));
        qh0.f.a(r0).a(new p(this, r4));
    }

    @Override // uf0.b
    public final void l0(Throwable r2) {
        ExceptionUtils.handleException(((Widget) this).context, r2);
    }

    public void G9(long r1, Exception r3) {
        hd0.c.f().k(0);
        ((Widget) this).dataCenter.put("cmd_interact_state_change", new a1(8));
        xs2.b.a().post(new com.bytedance.android.live.liveinteract.d(1));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J3(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        com.bytedance.android.live.liveinteract.plantform.core.g.a(r2, r3);
    }

    public void R(long r1, Exception r3) {
        ALogger.e("ttlive_link", r3);
        this.f.clear();
        com.bytedance.android.live.liveinteract.plantform.core.f r2 = this.b;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L5:
        r2.f.clear();
        r2.g.clear();
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L9;
        r4.put("cmd_interact_state_change", new a1(8));
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

    public void e1(String r4, long r5) {
        if (r5 == 1) goto L5;
    L22:
        getLinkUserCenter().getClass();
        return;
    L5:
        if (vm2.e.b() == false) goto L22;
        String r6 = "";
        ILinkPlayerInfoBridge r7 = getLinkUserCenter().o("", r4);
        if (r7 == null) goto L14;
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L14;
        com.bytedance.android.live.liveinteract.plantform.core.f r0 = this.b;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L13:
        String r1 = r8.getIdString();
        Intrinsics.checkNotNullParameter(r8, "$this$secUidExt");
        r0.e(r1, r8.getCastSecUid(), "rtc_user_lost");
    L14:
        if (r7 == null) goto L21;
        IBaseUser r9 = r7.getUser();
        if (r9 == null) goto L21;
        String r10 = r9.getIdString();
        if (r10 == null) goto L21;
        r6 = r10;
    L21:
        x.w(r6);
        goto L22
    }

    public void f0(long r1, Exception r3) {
        xq(this.d, "stop_on_rtc_error");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void n2(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.b(r2, r3);
    }

    public final void xq(int r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "requestFrom");
        wf0.b.h();
        com.bytedance.android.live.liveinteract.plantform.core.f r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "requestFrom");
        if (r1.i == true) goto L9;
        r1.i = true;
        long r2 = System.currentTimeMillis();
        Disposable r9 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).finishV1(r1.c.getId(), r7, r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.plantform.core.a(r1, r2, r8), new com.bytedance.android.live.liveinteract.plantform.core.b(r1, r2, r8));
        r1.b.add(r9);
    L9:
        this.f.clear();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Hf(int r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "deviceId");
        Intrinsics.checkNotNullParameter(r2, "deviceId");
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

    public void L0(String r1, TextureView r2, int r3, int r4) {
        Aq(r1);
    }

    public void b4(String r1, z.a r2, int r3, int r4) {
        Aq(r1);
    }

    public void h1(String r1, SurfaceView r2, int r3, int r4) {
        Aq(r1);
    }
}
