package com.bytedance.android.live.multilink.impl.control.anchor;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.n;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.plantform.utils.i;
import com.bytedance.android.live.liveinteract.plantform.utils.r;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter;
import com.bytedance.android.live.multilink.impl.w2;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profit.dress.config.LinkmicPlayMode;
import com.bytedance.android.livesdk.chatroom.model.interact.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.scope.m;
import com.bytedance.live.kmp.util.KmpToastUtil;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.revenue.platform.api.core.rx.p;
import gd0.j;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiControlAnchorService {
    public boolean a;
    public final Lazy b;
    public final tc0.b c;
    public final j d;
    public final qf6.a e;
    public final hd0.b f;
    public Pair<Integer, Integer> g;
    public final CompositeDisposable h;
    public final com.bytedance.android.live.multilink.impl.control.b i;
    public final bn0.b j;
    public final com.bytedance.android.live.multilink.impl.control.a k;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MultiControlAnchorService a;
        public final /* synthetic */ long b;
        public final /* synthetic */ f c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ w2 e;
        public final /* synthetic */ e f;

        public a(MultiControlAnchorService r1, long r2, f r4, boolean r5, w2 r6, e r7) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public final void accept(Object r23) {
            ExtraResponse r1 = (ExtraResponse) r23;
            int r3 = 0;
            this.a.a = false;
            j0 r2 = (j0) r1.data;
            String r4 = r2.getAccessToken();
            if (r4 != null) goto L5;
        L19:
            boolean r12 = false;
        L20:
            i97.a r5 = i97.a.a;
            long r13 = System.currentTimeMillis() - this.b;
            if (r12 == false) goto L23;
            MultiControlAnchorService r6 = this.a;
            boolean r7 = this.c.a;
            int r8 = r2.getScene();
            String r9 = this.c.e;
            r3 = r6.b(r8);
        L23:
            fn0.a r15 = new fn0.a(r3, r2.getScene(), r2.getUiLayout(), CollectionsKt.toList(r2.getPlayModes()));
            tc0.b r10 = this.a.c;
            if (r10 == null) goto L27;
            r10.v6(r2.isSupportVideo());
        L27:
            if (Intrinsics.areEqual("new_audience", r2.getFunctionType2()) == false) goto L30;
            ((LinkMultiControlPresenter) this.a.i).getClass();
            ((IInteractService) k.f(IInteractService.class)).setDynamicFromAudience(true);
        L30:
            if (r12 == true) goto L32;
            Exception r11 = new Exception("response invalid");
            long r14 = System.currentTimeMillis() - this.b;
            n.K(String.valueOf(this.e.c), this.e.c, r11, r14);
            String r16 = String.valueOf(this.e.c);
            w2 r17 = this.e;
            InteractLinkFullLinkMonitor.j(r16, r17.c, r14, r11, r17.g);
        L47:
            com.bytedance.android.live.multilink.impl.control.a r18 = this.a.k;
            if (r18 == null) goto L50;
            r18.a(r15);
        L50:
            e r19 = this.f;
            if (r19 == null) goto L68;
            f r20 = this.c;
            String r21 = r1.logId;
            LinkMultiControlPresenter.d r22 = (LinkMultiControlPresenter.d) r19;
            Runnable r24 = r22.a;
            if (r24 == null) goto L55;
            r24.run();
        L55:
            LinkMultiControlPresenter r25 = r22.c;
            if (r25.q == null) goto L59;
            r25.q = null;
        L59:
            if (r25.w.getRoom() != null) goto L61;
        L63:
            i.d(r2, r21);
            r.a("init success" + GsonProtectorUtils.toJson(GsonHelper.get(), r2));
            LinkMultiControlPresenter.j0(r22.c);
            if (r12 == false) goto L66;
            LinkMultiControlPresenter.j0(r22.c);
            x.z0(r13);
            LinkMultiControlPresenter.k0(r22.c, r2, r20.a, r2.getScene(), false, false, r20.e, r15.a);
            return;
        L66:
            r22.c.A0();
            ((q46.b) r22.c).a.Q10(new Exception());
            x.y0(new Exception("response invalid"), r13);
            return;
        L61:
            if (r22.c.w.getRoom().getValue() == null) goto L63;
            ((IRoom) r22.c.w.getRoom().getValue()).setLinkInitResult(r2);
            goto L63
        L68:
            return;
        L32:
            if (this.d == false) goto L41;
            if (r2.getScene() != 8) goto L41;
            if (r2.getUiLayout() != 7) goto L38;
        L39:
            ((LinkMultiControlPresenter) this.a.i).getClass();
            ((IInteractService) k.f(IInteractService.class)).setDynamicFromAudience(true);
        L45:
            int r26 = r2.getScene();
            String r27 = String.valueOf(this.e.c);
            int r28 = this.e.c;
            MultiLinkEventModule r29 = n.q(Integer.valueOf(r26));
            Intrinsics.checkNotNullParameter(r27, "supportedScene");
            Intrinsics.checkNotNullParameter(r29, "eventModule");
            JSONObject r30 = new JSONObject();
            n.b.l(r30);
            BaseMonitor.add(r30, "response_scene", r26);
            BaseMonitor.add(r30, "supported_scene", r27);
            BaseMonitor.add(r30, "request_scene", r28);
            n.y(r29, "init/v2", r13, r30);
            this.a.c(r2, this.c.a, r2.getScene(), false, false);
            InteractLinkFullLinkMonitor.l(String.valueOf(this.e.b), this.e.c, r2.getScene(), r2, r13, r1.logId, this.e.g);
            goto L47
        L38:
            if (r2.getUiLayout() == 15) goto L39;
        L41:
            if (r2.getScene() != 8) goto L45;
            if (r2.getUiLayout() != 52) goto L45;
            ((LinkMultiControlPresenter) this.a.i).getClass();
            ((IInteractService) k.f(IInteractService.class)).setDynamicFromAudience(true);
            goto L45
        L5:
            if (r4.length() <= 0) goto L7;
            boolean r31 = true;
        L8:
            if (r31 != true) goto L19;
            if (r2.getLinkMicId() > 0) goto L18;
            String r32 = r2.getLinkMicIdStr();
            if (r32 == null) goto L19;
            if (r32.length() <= 0) goto L16;
            boolean r33 = true;
        L17:
            if (r33 != true) goto L19;
        L16:
            r33 = false;
        L18:
            r12 = true;
            goto L20
        L7:
            r31 = false;
            goto L8
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiControlAnchorService a;
        public final /* synthetic */ w2 b;
        public final /* synthetic */ f c;
        public final /* synthetic */ long d;
        public final /* synthetic */ e e;

        public b(MultiControlAnchorService r1, w2 r2, f r3, long r4, e r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
        }

        public final void accept(Object r7) {
            Throwable r4 = (Throwable) r7;
            int r8 = this.b.e;
            Function0<Unit> r9 = new MultiControlAnchorService$_initV2$2$1(this);
            MultiControlAnchorService$_initV2$2$2 r0 = MultiControlAnchorService$_initV2$2$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r9, "onCheckSuccess");
            Intrinsics.checkNotNullParameter(r0, "onCheckFailed");
            new qh0.h(1, r9, r0).c(r4);
            this.a.a = false;
            i97.a r10 = i97.a.a;
            long r2 = System.currentTimeMillis() - this.d;
            n.K(String.valueOf(this.b.c), this.b.c, r4, r2);
            e r11 = this.e;
            if (r11 == null) goto L7;
            LinkMultiControlPresenter.d r12 = (LinkMultiControlPresenter.d) r11;
            r12.c.f0(r4);
            x.y0(r4, r2);
            ((q46.b) r12.c).a.Q10(r4);
            r12.c.A0();
            Runnable r13 = r12.b;
            if (r13 == null) goto L7;
            r13.run();
        L7:
            String r1 = String.valueOf(this.b.c);
            w2 r14 = this.b;
            InteractLinkFullLinkMonitor.j(r1, r14.c, r2, r4, r14.g);
        }
    }

    public final int b(int r5) {
        IRoom r0 = (IRoom) this.b.getValue();
        int r2 = 8;
        if (r0 != null) goto L5;
    L7:
        if (r5 != 8) goto L9;
    L15:
        com.bytedance.android.livesdk.sharedpref.d.q(r5);
    L16:
        r2 = 32;
    L17:
        hd0.b r6 = this.f;
        if (r6 == null) goto L20;
        r6.V7(2);
    L20:
        return r2;
    L9:
        if (r5 == 12) goto L15;
        if (r5 == 16) goto L16;
        r2 = 2;
        goto L17
    L5:
        if (r0.isLiveTypeAudio() != true) goto L7;
        goto L7
    }

    public final void a(f r28, e r29) {
        Intrinsics.checkNotNullParameter(r28, "initParams");
        if (this.a == false) goto L7;
        if (r29 == null) goto L191;
        ((LinkMultiControlPresenter.d) r29).c.A0();
        return;
    L191:
        return;
    L7:
        int r0 = r28.c;
        int r3 = 1;
        if (vm2.e.j() == true) goto L19;
        lr2.a r1 = com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), lr2.a.class);
        if (r1 == null) goto L19;
        if (r1.isPaidLive() != true) goto L19;
        if (r0 != 3) goto L19;
        KmpToastUtil.a("付费直播间暂不支持开启聊天室", 0);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.g0("during_paid_live");
        if (r29 == null) goto L192;
        ((LinkMultiControlPresenter.d) r29).c.A0();
        return;
    L192:
        return;
    L19:
        if (r28.f == true) goto L38;
        com.bytedance.android.live.multilink.impl.control.b r2 = this.i;
        if (r2 == null) goto L23;
        Integer r4 = Integer.valueOf(com.bytedance.android.live.multilink.impl.control.b.a.a(r2));
    L25:
        if (r4.intValue() == 0) goto L38;
        if (this.i != null) goto L29;
    L34:
        if (r29 == null) goto L36;
        ((LinkMultiControlPresenter.d) r29).c.A0();
    L36:
        jy0.b.c("ttlive_link", "intercept current mode " + com.bytedance.android.live.multilink.impl.control.b.a.a(this.i) + ", targetMode " + r0, null, 4);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.g0("during_intimate_chat_interaction");
        return;
    L29:
        if (us1.b.a() != true) goto L34;
        if (this.i == null) goto L34;
        if (k.f(IMultiLinkServiceExternal.class).getPkServiceExternal().isMatching() == true) goto L38;
    L23:
        r4 = null;
    L38:
        ((LinkMultiControlPresenter) this.i).getClass();
        if (k.f(IMultiLinkServiceExternal.class).getPkServiceExternal().isMatching() == false) goto L46;
        ((LinkMultiControlPresenter) this.i).getClass();
        if (us1.b.a() == true) goto L46;
        if (r29 == null) goto L44;
        ((LinkMultiControlPresenter.d) r29).c.A0();
    L44:
        KmpToastUtil.a("礼物PK中，暂不可发起连线", 0);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.g0("during_pk");
        return;
    L46:
        this.a = true;
        boolean r5 = r28.b;
        int r11 = LinkmicPlayMode.Default.getValue();
        IRoom r12 = (IRoom) this.b.getValue();
        int r13 = 8;
        if (r12 != null) goto L49;
    L51:
        int r14 = 4;
        int r15 = 1;
    L52:
        if (r0 == 5) goto L56;
        if (r0 == 1) goto L56;
        boolean r16 = false;
    L58:
        if (r16 == false) goto L60;
        r13 = 9;
        r15 = 64;
    L65:
        Integer r17 = r28.i;
        if (r17 == null) goto L68;
        int r18 = r17.intValue();
    L70:
        if (r18 == 0) goto L72;
        int r22 = r18;
    L77:
        Pair<Integer, Integer> r6 = this.g;
        if (r6 == null) goto L82;
        Integer r7 = (Integer) r6.getSecond();
        if (r7 == null) goto L86;
        int r8 = r7.intValue();
    L87:
        if (r0 != 6) goto L90;
    L97:
        int r24 = 2;
    L103:
        if (this.g == null) goto L105;
        String r19 = "big_event_platform_remote_control";
    L106:
        String r25 = r19;
        if (r0 != 6) goto L109;
        r11 = LinkmicPlayMode.RealTimeChorus.getValue();
    L109:
        int r26 = r11;
        Integer r9 = r28.g;
        if (r9 == null) goto L112;
        int r10 = r9.intValue();
    L113:
        if (r10 <= 0) goto L121;
        Integer r20 = r28.h;
        if (r20 == null) goto L117;
        int r21 = r20.intValue();
    L118:
        if (r21 <= 0) goto L121;
        if (r0 != 0) goto L121;
        int r110 = 0;
    L122:
        Integer r23 = r28.g;
        if (r23 != null) goto L125;
    L133:
        int r27 = r8;
    L134:
        Integer r30 = r28.h;
        if (r30 != null) goto L137;
    L145:
        int r210 = r13;
        w2 r111 = new w2(r110, r210, r210, r22, r27, r24, r25, r26);
        TalkRoomBusinessFullLinkMonitor r31 = TalkRoomBusinessFullLinkMonitor.a;
        String r32 = r111.g;
        int r33 = r111.b;
        int r112 = r111.e;
        r31.getClass();
        TalkRoomBusinessFullLinkMonitor.c0(r32, r33, r112);
        this.g = null;
        i97.a r34 = i97.a.a;
        long r113 = System.currentTimeMillis();
        if (r111.d == 1) goto L148;
    L150:
        boolean r35 = false;
    L151:
        lr2.a r36 = com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), lr2.a.class);
        if (r36 != null) goto L154;
    L158:
        boolean r37 = false;
    L159:
        if (r29 == null) goto L161;
        ((IInteractService) k.f(IInteractService.class)).setDynamicFromAudience(false);
        wf0.b.i(r111.b);
        int r114 = com.bytedance.android.live.liveinteract.plantform.utils.f.a;
        com.bytedance.android.live.liveinteract.plantform.utils.f.a((LiveMode) ((com.bytedance.android.livesdk.chatroom.presenter.n) ((LinkMultiControlPresenter.d) r29).c).c.get("data_live_mode", LiveMode.UNDEFINED));
    L161:
        ((LinkMultiControlPresenter) this.i).getClass();
        ((IInteractService) k.f(IInteractService.class)).setDynamicFromAudience(false);
        long r115 = 0;
        if (r35 == false) goto L177;
        if (r37 == false) goto L166;
        KmpToastUtil.a("付费直播间暂不支持开启聊天室", 0);
        this.a = false;
        TalkRoomBusinessFullLinkMonitor.g0("during_paid_live");
        return;
    L166:
        String r38 = r28.e;
        int r39 = 7;
        if (Intrinsics.areEqual("pre_apply", r38) == false) goto L170;
        int r211 = 4;
    L173:
        int r40 = eg0.a.a;
        IRoomBase r41 = (IRoom) this.b.getValue();
        if (r41 == null) goto L176;
        r115 = IRoomKtKt.getId(r41);
    L176:
        Observable r42 = eg0.a.a(r115, 1, false, 8, String.valueOf(r111.c), r211, Integer.valueOf(r39), Integer.valueOf(r3));
    L181:
        com.bytedance.android.live.multilink.impl.control.b r43 = this.i;
        int r44 = r111.b;
        ((LinkMultiControlPresenter) r43).getClass();
        wf0.b.i(r44);
        InteractLinkFullLinkMonitor.i(String.valueOf(r111.c), r111.b, r111.g);
        if (r42 == null) goto L193;
        int r45 = p.a;
        Observable r46 = r42.subscribeOn(Schedulers.io());
        if (r46 == null) goto L194;
        Observable r116 = r46.observeOn(AndroidSchedulers.mainThread());
        if (r116 == null) goto L195;
        Disposable r47 = r116.subscribe(new a(this, r113, r28, r35, r111, r29), new b(this, r111, r28, r113, r29));
        if (r47 == null) goto L196;
        com.bytedance.revenue.platform.api.core.rx.f.a(r47, this.h);
        return;
    L196:
        return;
    L195:
        return;
    L194:
        return;
    L193:
        return;
    L170:
        if (PbRequest.SwitchType.PK.equals(r38) == false) goto L172;
        r39 = 52;
        r3 = 2;
    L172:
        r211 = 3;
        goto L173
    L177:
        int r48 = eg0.a.a;
        IRoomBase r49 = (IRoom) this.b.getValue();
        if (r49 == null) goto L180;
        r115 = IRoomKtKt.getId(r49);
    L180:
        r42 = eg0.a.a(r115, r111.a, r28.b, r111.b, String.valueOf(r111.c), r111.d, Integer.valueOf(r111.e), Integer.valueOf(r111.f));
        goto L181
    L154:
        if (r36.isPaidLive() != true) goto L158;
        if (vm2.e.j() == true) goto L158;
        r37 = true;
        goto L159
    L148:
        if (r111.a != 1) goto L150;
        r35 = true;
        goto L151
    L137:
        if (r30.intValue() <= 0) goto L139;
        boolean r50 = true;
    L140:
        if (r50 == true) goto L143;
        r30 = null;
    L143:
        if (r30 == null) goto L145;
        r13 = r30.intValue();
        goto L145
    L139:
        r50 = false;
        goto L140
    L125:
        if (r23.intValue() <= 0) goto L127;
        boolean r51 = true;
    L128:
        if (r51 == true) goto L131;
        r23 = null;
    L131:
        if (r23 == null) goto L133;
        r27 = r23.intValue();
        goto L134
    L127:
        r51 = false;
        goto L128
    L117:
        r21 = 0;
    L121:
        r110 = r15;
        goto L122
    L112:
        r10 = 0;
        goto L113
    L105:
        r19 = "click_bottom_bar_icon";
        goto L106
    L90:
        if (this.g != null) goto L97;
        Integer r117 = r28.g;
        if (r117 == null) goto L95;
        int r118 = r117.intValue();
    L96:
        if (r118 > 0) goto L97;
        if (r28.d == false) goto L101;
        r24 = 1;
        goto L103
    L101:
        r24 = 0;
        goto L103
    L95:
        r118 = 0;
    L86:
        r8 = 0;
        goto L87
    L82:
        if (r0 != 5) goto L84;
        r8 = 61;
        goto L87
    L84:
        if (r0 != 6) goto L86;
        r8 = 63;
        goto L87
    L72:
        if (r15 != 1) goto L76;
        if (r5 == false) goto L75;
        r22 = 2;
        goto L77
    L75:
        r22 = 1;
        goto L77
    L76:
        r22 = 0;
        goto L77
    L68:
        r18 = 0;
        goto L70
    L60:
        if (r0 == 3) goto L64;
        if (r0 == 6) goto L64;
        r13 = r14;
    L64:
        r15 = 16;
    L56:
        r16 = true;
        goto L58
    L49:
        if (r12.isLiveTypeAudio() != true) goto L51;
        r14 = 5;
        r15 = 8;
        goto L52
    }

    public MultiControlAnchorService(com.bytedance.android.live.multilink.impl.control.b r2, bn0.b r3, com.bytedance.android.live.multilink.impl.control.a r4) {
        Intrinsics.checkNotNullParameter(r2, "multiControlHostService");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.b = LazyKt.lazy(MultiControlAnchorService$mRoom$2.INSTANCE);
        hd0.b r5 = null;
        if (r3 == null) goto L5;
        KClass r6 = Reflection.getOrCreateKotlinClass(tc0.b.class);
        m.e.getClass();
        tc0.b r7 = (tc0.b) m.b(r3).a(r6);
    L6:
        this.c = r7;
        if (r3 == null) goto L9;
        m.e.getClass();
        j r8 = (j) m.b(r3).b(j.class);
    L10:
        this.d = r8;
        if (r3 == null) goto L13;
        KClass r9 = Reflection.getOrCreateKotlinClass(qf6.a.class);
        m.e.getClass();
        qf6.a r10 = (qf6.a) m.b(r3).a(r9);
    L14:
        this.e = r10;
        if (r3 == null) goto L17;
        KClass r11 = Reflection.getOrCreateKotlinClass(hd0.b.class);
        m.e.getClass();
        r5 = (hd0.b) m.b(r3).a(r11);
    L17:
        this.f = r5;
        this.h = new CompositeDisposable();
        return;
    L13:
        r10 = null;
        goto L14
    L9:
        r8 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }

    public final void c(j0 r5, boolean r6, int r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r5, "initResult");
        tc0.b r0 = this.c;
        String r1 = r5.getLinkMicIdStr();
        String r2 = "";
        if (r1 != null) goto L5;
    L13:
        if (r0 == null) goto L18;
        String r3 = r5.getLinkMicIdStr();
        if (r3 != null) goto L17;
        r3 = "";
    L17:
        r0.c1(r3);
    L18:
        if (r0 == null) goto L20;
        r0.D6(r5.getLinkMicIdStr());
    L20:
        if (r0 == null) goto L22;
        r0.rg(r5.getVendor());
    L22:
        if (r0 == null) goto L28;
        String r4 = r5.getRtcExtInfo();
        if (r4 == null) goto L27;
        r2 = r4;
    L27:
        r0.setRtcExtInfo(r2);
    L28:
        if (r0 == null) goto L31;
        r0.setLiveCoreExtInfo(r5.getLiveCoreExtInfo());
    L31:
        if (r5.getMultiLiveCoreInfo() == null) goto L35;
        if (r0 == null) goto L35;
        r0.setMultiLiveCoreInfo(r5.getMultiLiveCoreInfo());
    L35:
        if (r5.getMultiRtcInfo() == null) goto L38;
        if (r0 == null) goto L38;
        r0.setMultiRtcInfo(r5.getMultiRtcInfo());
    L38:
        jy0.b.c("ttlive_link", "onInitV2Success " + r6 + ' ' + r7 + ' ' + r8 + ' ' + r9 + ' ' + r5, null, 4);
        if (r0 == null) goto L42;
        r0.v6(r5.isSupportVideo());
        return;
    L42:
        return;
    L5:
        if (r1.length() != 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 != true) goto L13;
        if (r0 == null) goto L11;
        r0.D6(String.valueOf(r5.getLinkMicId()));
    L11:
        if (r0 == null) goto L20;
        r0.c1(String.valueOf(r5.getLinkMicId()));
        goto L20
    L7:
        r10 = false;
        goto L8
    }
}
