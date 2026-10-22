package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import android.os.SystemClock;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.v;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.spatial.SpatialAudioStrategyManager;
import com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget;
import com.bytedance.android.live.liveinteract.spatial.SpatialAudioContext;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.bizlink.api.business.anchor2guest.base.BizLinkServiceType;
import hh1.u0;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/widgt/voicelink/MultiLinkVoiceBaseAnchorLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/MultiLinkBaseAnchorLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/voicelink/a;", "Lhe0/b$a;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class MultiLinkVoiceBaseAnchorLinkWidget extends MultiLinkBaseAnchorLinkWidget<ILinkPlayerInfoBridge> implements com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.a, he0.b.a {
    public he0.b p;
    public final Map<String, Integer> q;
    public u0 r;
    public IRoom s;
    public com.bytedance.android.live.liveinteract.plantform.core.h t;
    public com.bytedance.android.live.liveinteract.api.utils.p u;
    public uf0.d v;
    public uf0.c w;
    public boolean x;
    public v y;
    public final com.bytedance.android.live.pushstream.d z;

    public static final class a {
    }

    public static final class b extends vb6.a {
        public final /* synthetic */ MultiLinkVoiceBaseAnchorLinkWidget a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            public final void accept(Object r1) {
                Boolean r2 = (Boolean) r1;
                hg6.g r3 = this.a.a.Lq();
                if (r3 == null) goto L6;
                r3.f();
                return;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseAnchorLinkWidget$b$b, reason: collision with other inner class name */
        public static final class C0063b<T> implements Consumer {
            public static final C0063b a = null;

            static {
                a = new C0063b();
            }

            public C0063b() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Throwable r2 = (Throwable) r1;
            }
        }

        public static final class c<T> implements Consumer {
            public final /* synthetic */ b a;

            public c(b r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                int r4 = ((Number) r3).intValue();
                ALogger.d("SpatialAudio_audio_talk_context", "CurrentStrategyId onValueChanged " + r4 + "isEnable : " + com.bytedance.android.live.liveinteract.spatial.a.e(r4));
                hg6.g r0 = this.a.a.Lq();
                if (r0 == null) goto L6;
                r0.i(com.bytedance.android.live.liveinteract.spatial.a.e(r4));
            L6:
                if (com.bytedance.android.live.liveinteract.spatial.a.e(r4) == false) goto L11;
                tf0.o r5 = this.a.a.Mq();
                if (r5 == null) goto L12;
                r5.u(Boolean.TRUE);
                return;
            L12:
                return;
            }
        }

        public b(MultiLinkVoiceBaseAnchorLinkWidget r1) {
            this.a = r1;
        }

        public final void Zk(long r1, ei6.a r3) {
            Intrinsics.checkNotNullParameter(r3, "client");
            hg6.g r2 = this.a.Lq();
            if (r2 == null) goto L5;
            r2.i(com.bytedance.android.live.liveinteract.spatial.a.e(this.a.C0()));
        L5:
            SpatialAudioStrategyManager.c.a();
            SpatialAudioContext r4 = SpatialAudioContext.Companion.getContext();
            Intrinsics.checkNotNull(r4);
            Disposable r5 = r4.getCurrentStrategyId().a().subscribe(new c(this));
            this.a.m.add(r5);
            u r6 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a);
            if (r6 == null) goto L17;
            com.bytedance.live.datacontext.m r7 = r6.I1();
            if (r7 == null) goto L18;
            Observable r8 = r7.a();
            if (r8 == null) goto L19;
            Observable r9 = r8.observeOn(AndroidSchedulers.mainThread());
            if (r9 == null) goto L20;
            ObservableSubscribeProxy r10 = (ObservableSubscribeProxy) r9.as(this.a.autoDispose());
            if (r10 == null) goto L21;
            r10.subscribe(new a(this), C0063b.a);
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        L18:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final int Aq() {
        return 8;
    }

    public abstract BizLinkServiceType Gq();

    @Override // he0.b.a
    public boolean J8() {
        return false;
    }

    public final String Kq(int r2) {
        if (r2 != 9) goto L7;
        return "multi_ktv";
    L7:
        if (r2 != 10) goto L9;
        return "share_video";
    L9:
        return "fm";
    }

    public abstract tf0.o Mq();

    public yf6.a Nq() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public int getScene() {
        return 8;
    }

    @Override // he0.b.a
    public void o9(List<ti6.f> r1) {
    }

    public final u0 Jq() {
        u0 r0 = this.r;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAnchorVideoClient");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void M1() {
        he0.b r0 = this.p;
        if (r0 == null) goto L9;
        j1 r1 = r0.g;
        if (r1 == null) goto L9;
        dn0.c r2 = (dn0.c) r1.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r2 == null) goto L9;
        r2.H4("MultiLinkVoiceBaseAnchorLinkWidget onEndSuccess");
    L9:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L12;
        r3.put("cmd_interact_state_change", new a1(11));
    L12:
        hg6.g r4 = Lq();
        if (r4 == null) goto L15;
        r4.Z(this);
    L15:
        this.x = false;
        if (this.z == null) goto L22;
        jg6.a r5 = zq().e5();
        if (r5 == null) goto L22;
        kg6.e r6 = r5.b();
        if (r6 == null) goto L22;
        r6.z(new kg6.d(true, true, "anchor_finish_link", 8));
    L22:
        tf0.o r7 = Mq();
        if (r7 == null) goto L25;
        r7.O();
    L25:
        yf6.a r8 = Nq();
        if (r8 == null) goto L29;
        r8.f();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final IRoom getMRoom() {
        IRoom r0 = this.s;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final void onStart() {
        if (this.y == null) goto L5;
        md().n0(this.y);
    L5:
        super.onStart();
    }

    @Override // he0.b.a
    public int C0() {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).I1();
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (((Boolean) r0.getValue()).booleanValue() != true) goto L7;
    L8:
        if (r2 == false) goto L10;
        return 9;
    L10:
        tf0.o r1 = Mq();
        if (r1 != null) goto L13;
        return 0;
    L13:
        return r1.C0();
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public void H1() {
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (this.t == null) goto L22;
        hg6.g r0 = Lq();
        if (r0 == null) goto L22;
        ei6.a r1 = r0.V0();
        if (r1 == null) goto L22;
        com.bytedance.android.live.liveinteract.plantform.core.h r2 = this.t;
        if (r2 == null) goto L22;
        WeakReference<ei6.a> r3 = new WeakReference(r1);
        hg6.g r4 = Lq();
        if (r4 == null) goto L20;
        ec6.b r5 = r4.R();
        if (r5 == null) goto L20;
        com.bytedance.android.live.pushstream.d r6 = gc6.b.a(r5);
        if (r6 == null) goto L20;
        d0 r7 = r6.getLiveCore();
    L21:
        r2.d(r3, new WeakReference(r7));
    L20:
        r7 = null;
    L22:
        com.bytedance.android.live.liveinteract.api.utils.p r8 = this.u;
        if (r8 == null) goto L25;
        r8.b();
    L25:
        tf0.o r9 = Mq();
        if (r9 == null) goto L28;
        r9.L();
    L28:
        com.bytedance.android.live.liveinteract.plantform.base.f.a().o6(Kq(je0.d.f()), true);
        a1 r10 = new a1(10);
        u0 r11 = this.r;
        if (r11 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mAnchorVideoClient");
    L31:
        r10.b = r11;
        ((Widget) this).dataCenter.put("cmd_interact_state_change", r10);
        yf6.a r12 = Nq();
        if (r12 == null) goto L35;
        r12.e(new MultiLinkVoiceBaseAnchorLinkWidget$onLinkSuccess$2(this));
        return;
    }

    public final vb6.g Iq() {
        return zq().O5();
    }

    public final hg6.g Lq() {
        return zq().getRtcManager();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onCreate() {
        multiLinkRoomScopeFallback();
        super.onCreate();
        rf6.a r0 = wq();
        if (r0 == null) goto L5;
        r0.b(Gq(), ((Widget) this).context);
    L5:
        v0 r1 = ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).createLinkInRoomView(this.z, ((Widget) this).context, 0);
        Intrinsics.checkNotNull(r1);
        this.r = r1;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mAnchorVideoClient");
    L8:
        if (r1 == null) goto L42;
        ti6.j r2 = null;
        ec6.a r3 = gc6.b.c(r1, null);
        vb6.g r4 = Iq();
        if (r4 == null) goto L14;
        yb6.e r5 = r4.j();
        if (r5 == null) goto L14;
        r5.s0(r3, getClass().getSimpleName().concat(" create set"));
    L14:
        hg6.g r6 = Lq();
        if (r6 == null) goto L17;
        r6.p(this);
    L17:
        hg6.g r7 = Lq();
        if (r7 == null) goto L23;
        xi0.b r8 = r7.O();
        if (r8 == null) goto L23;
        r8.p(this);
    L23:
        if (((Boolean) vm2.d.P3.getValue(null, vm2.d.a[247(0xf7, float:3.46E-43)])).booleanValue() == false) goto L43;
        hg6.g r9 = Lq();
        if (r9 == null) goto L31;
        ei6.a r10 = r9.V0();
        if (r10 == null) goto L31;
        fi6.a r11 = r10.g();
        if (r11 == null) goto L31;
        ti6.j r12 = r11.f;
    L33:
        if ((r12 instanceof he0.b) == false) goto L36;
        r2 = r12;
    L36:
        he0.b r13 = (he0.b) r2;
        if (r13 == null) goto L39;
        r13.a = this;
    L39:
        jy0.b.d("MultiLinkVoiceAnchorBaseLinkWidget updateQuerier", "streamMixer=" + r13 + ", mQuerier=" + this);
        return;
    L31:
        r12 = null;
        goto L33
    L43:
        return;
    L42:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.interact.LiveVideoClientFactory");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onDestroy() {
        super.onDestroy();
        sg6.b r0 = wq();
        if (r0 == null) goto L6;
        r0.j(null);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.a
    public final v s0() {
        return md().s0();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final y xq() {
        return yq();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final void Fq(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.s = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final void bd(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        tf0.o r3 = Mq();
        if (r3 == null) goto L6;
        r3.G();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final void be(ExtraResponse<? extends IJoinChannelResult, Extra> r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        super.be(r3);
        if (isViewValid() == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.liveinteract.plantform.utils.k.a(((Widget) this).context, 5);
        hd0.c r4 = hd0.c.f();
        r4.e = SystemClock.currentThreadTimeMillis();
        vb6.g r5 = Iq();
        if (r5 == null) goto L9;
        r5.X0(new b(this), false);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.a
    public final void n0(v r1) {
        this.y = r1;
    }

    public ti6.j x(fi6.a r3) {
        he0.b r0 = new he0.b(this, this.q, this);
        this.p = r0;
        r0.b = r3;
        m00.e r4 = this.r;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAnchorVideoClient");
    L5:
        if (r4 == null) goto L9;
        r4.d();
        return this.p;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.api.widget.ILinkInRoomView");
    }

    public MultiLinkVoiceBaseAnchorLinkWidget(com.bytedance.android.live.pushstream.d r2, tc0.c r3) {
        Intrinsics.checkNotNullParameter(r2, "mLiveStream");
        Intrinsics.checkNotNullParameter(r3, "dataHolder");
        super(r3);
        this.z = r2;
        this.q = new HashMap();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void G9(long r1, Exception r3) {
        he0.b r2 = this.p;
        if (r2 == null) goto L10;
        j1 r4 = r2.g;
        if (r4 == null) goto L11;
        dn0.c r5 = (dn0.c) r4.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r5 == null) goto L12;
        r5.H4("MultiLinkVoiceBaseAnchorLinkWidget onEndFailed");
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // he0.b.a
    public int q0(List<ti6.f> r2, Map<String, Integer> r3) {
        if (r2 != null) goto L4;
    L11:
        return 0;
    L4:
        if (r2.size() == 0) goto L11;
        if (Mq() == null) goto L11;
        tf0.o r0 = Mq();
        if (r0 == null) goto L11;
        return r0.q0(r2, r3);
    }
}
