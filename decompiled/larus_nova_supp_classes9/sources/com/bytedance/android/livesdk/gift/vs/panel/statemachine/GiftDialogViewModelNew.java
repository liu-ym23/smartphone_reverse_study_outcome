package com.bytedance.android.livesdk.gift.vs.panel.statemachine;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.LongSparseArray;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.r0;
import com.bytedance.android.livesdk.gift.platform.business.g;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftInRoomService;
import com.bytedance.android.livesdk.gift.platform.core.utils.e0;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import i12.o;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftDialogViewModelNew extends com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a {
    public static final /* synthetic */ int h = 0;
    public final Function1<StateMachine.c<? extends GiftStateMachineConfig.a, ? extends GiftStateMachineConfig.Event, ? extends GiftStateMachineConfig.f>, Unit> e;
    public final StateMachine<GiftStateMachineConfig.a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> f;
    public final DataCenter g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a
    public final void d(GiftStateMachineConfig.Event r36) {
        Intrinsics.checkNotNullParameter(r36, "event");
        if ((r36 instanceof GiftStateMachineConfig.Event.p) == false) goto L76;
        GiftStateMachineConfig.Event.p r2 = (GiftStateMachineConfig.Event.p) r36;
        AbsPanel<?> r7 = r2.b;
        AbsPanel.GiftPanelSelectType r8 = r2.c;
        if (r8 != AbsPanel.GiftPanelSelectType.DEFAULT_SELECTED) goto L7;
    L10:
        boolean r9 = true;
    L11:
        GiftListViewModelNew r10 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.l();
        if (r10 == null) goto L14;
        Map r11 = r10.e;
    L15:
        T r13 = r7.h;
        if ((r13 instanceof h1) == false) goto L46;
        if (r13 == 0) goto L44;
        h1 r14 = (h1) r13;
        if ((r14.getReqExtraType() & 2) != 2) goto L27;
        i12.e r15 = o.b();
        if (r15 == null) goto L23;
        Object r16 = m.e.d(r15, GiftExtraRepo.class);
    L24:
        GiftExtraRepo r17 = (GiftExtraRepo) r16;
        if (r17 == null) goto L27;
        r0.a.a(r17, CollectionsKt.listOf(Long.valueOf(r14.getId())), "handleSelectedGift", null, 12);
        goto L27
    L23:
        r16 = null;
    L27:
        Iterator r18 = r11.keySet().iterator();
    L29:
        if (r18.hasNext() == false) goto L33;
        w1 r19 = (w1) r18.next();
        if (r19.getPageType() != com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()) goto L29;
        LongSparseArray r20 = (LongSparseArray) r11.get(r19);
    L34:
        if (r9 == true) goto L36;
    L39:
        if (r20 == null) goto L58;
        if (r20.get(r14.getId()) == null) goto L58;
        ((Number) r20.get(r14.getId())).intValue();
    L58:
        if ((r7 instanceof pz1.a) == false) goto L82;
        pz1.a r3 = (pz1.a) r7;
        if (r3.p() == false) goto L68;
        g r4 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r4 == null) goto L66;
        Context r5 = r4.getContext();
        if (r5 == null) goto L66;
        cs2.b r6 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.ui.d.class).yn(r5, 1);
        r6.a.b(r3.l());
        r6.a.a(2, 2131920806, b.a);
        r6.h();
    L66:
        com.bytedance.tools.kcp.spongepreference.runtime.a r21 = ay1.b.m;
        KProperty[] r23 = ay1.b.a;
        HashSet r24 = (HashSet) r21.getValue(null, r23[15]);
        r24.add(Long.valueOf(r7.c()));
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r21.setValue(null, r23[15], r24);
        goto L82
    L68:
        if (r3.o() == false) goto L82;
        r3.k();
        UrlBuilder r25 = new UrlBuilder(BuildConfig.FLAVOR);
        g r26 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r26 == null) goto L74;
        Context r27 = r26.getContext();
        if (r27 == null) goto L74;
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(r27, r25.build());
    L74:
        com.bytedance.tools.kcp.spongepreference.runtime.a r28 = ay1.b.n;
        KProperty[] r29 = ay1.b.a;
        HashSet r30 = (HashSet) r28.getValue(null, r29[16]);
        r30.add(String.valueOf(r7.c()));
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        r28.setValue(null, r29[16], r30);
    L82:
        GiftDialogViewModelNew r31 = this;
        GiftStateMachineConfig.Event r0 = r36;
    L187:
        StateMachine<GiftStateMachineConfig.a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r1 = r31.f;
        StateMachine.a r33 = StateMachine.c;
        r1.d(r0, null);
        return;
    L36:
        if (r2.e == false) goto L39;
        if (r19 == null) goto L39;
        f(r19.getPageType(), r14.getId());
        goto L39
    L33:
        r20 = null;
        r19 = null;
        goto L34
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L46:
        if ((r13 instanceof l2) == false) goto L58;
        if (r2.e == false) goto L58;
        if (r13 == 0) goto L56;
        h1 r34 = ((l2) r13).getGift();
        if (r34 == null) goto L53;
        Long r35 = Long.valueOf(r34.getId());
    L54:
        f(5, r35.longValue());
        goto L58
    L53:
        r35 = null;
        goto L54
    L56:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L14:
        r11 = new HashMap();
        goto L15
    L7:
        if (r8 == AbsPanel.GiftPanelSelectType.LOCATED) goto L10;
        r9 = false;
        goto L11
    L76:
        if ((r36 instanceof GiftStateMachineConfig.Event.k) == false) goto L84;
        final int r37 = ((GiftStateMachineConfig.Event.k) r36).b;
        com.bytedance.android.livesdk.gift.util.b.f(GiftStateMachineConfig.Event.o.b);
        g r38 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r38 == null) goto L82;
        Context r39 = r38.getContext();
        if (r39 == null) goto L82;
        this.c.add(com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).z4(r39, new GiftDialogViewModelNew$login$$inlined$let$lambda$1(this, r37)).subscribe(new c(this), d.a));
        goto L82
    L84:
        if ((r36 instanceof GiftStateMachineConfig.Event.q) == true) goto L190;
        if ((r36 instanceof GiftStateMachineConfig.Event.r) == true) goto L190;
        if ((r36 instanceof GiftStateMachineConfig.Event.m) == false) goto L153;
        GiftStateMachineConfig.Event.m r40 = (GiftStateMachineConfig.Event.m) r36;
        x2 r41 = r40.b;
        String r43 = "click";
        if (r41 != null) goto L93;
        r41 = new x2("click", "gift_recharge");
    L93:
        boolean r44 = r40.c;
        if (TextUtils.isEmpty(r41.d) == false) goto L96;
    L151:
        r31 = this;
    L152:
        r0 = r36;
        goto L187
    L96:
        if (TextUtils.isEmpty(r41.e) == true) goto L151;
        if (com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin() == true) goto L109;
        i12.e r45 = o.b();
        if (r45 == null) goto L103;
        Object r46 = m.e.d(r45, GiftInRoomService.class);
    L104:
        GiftInRoomService r47 = (GiftInRoomService) r46;
        if (r47 == null) goto L107;
        r47.a(1002);
        goto L151
    L107:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.k(1002));
        goto L151
    L103:
        r46 = null;
        goto L104
    L109:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).interceptOperation("recharge") == true) goto L151;
        if (com.bytedance.android.livesdk.gift.platform.core.g.a() != com.bytedance.android.livesdk.gift.platform.core.g.e) goto L143;
        String r110 = r41.d;
        String r111 = r41.e;
        long r112 = r41.h;
        int r113 = r41.j;
        long r48 = r41.i;
        long r49 = r41.k;
        long r50 = r41.g;
        String r51 = r41.l;
        g r114 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r114 == null) goto L142;
        FragmentActivity r53 = r114.getContext();
        if (r53 == null) goto L142;
        if ((r53 instanceof FragmentActivity) == false) goto L121;
        FragmentActivity r54 = r53;
    L122:
        if (r54 == null) goto L142;
        if (TextUtils.equals("gift_recharge", r111) == true) goto L129;
        r43 = "call";
    L129:
        if (r50 <= 0) goto L131;
        boolean r310 = true;
    L132:
        GiftContext r115 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r115 == null) goto L138;
        com.bytedance.live.datacontext.m<String> r116 = r115.getGiftListResultLogId();
        if (r116 == null) goto L138;
        String r117 = (String) r116.getValue();
        if (r117 == null) goto L138;
    L139:
        com.bytedance.android.live.recharge.model.d r118 = new com.bytedance.android.live.recharge.model.d(true, r110, null, r50, r310, 0, 0, r111, r43, new com.bytedance.android.live.recharge.model.b(r117, r51, r49, r48, r112, r113, null, 192), null, null, null, 31844);
        IRechargeService r55 = k.f(IRechargeService.class);
        Intrinsics.checkNotNull(r55);
        r31 = this;
        r55.showRechargeDialogFragment(r54, r118, new e(r31, r44));
        if (r44 == false) goto L152;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
    L138:
        r117 = BuildConfig.FLAVOR;
        goto L139
    L131:
        r310 = false;
        goto L132
    L121:
        r54 = null;
    L142:
        r31 = this;
        goto L152
    L143:
        r31 = this;
        g r56 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r56 == null) goto L152;
        Context r57 = r56.getContext();
        if (r57 == null) goto L152;
        if ((r57 instanceof Activity) == false) goto L152;
        vh6.c.b(wh6.a.class).openWallet((Activity) r57);
        goto L152
    L153:
        r31 = this;
        r0 = r36;
        if ((r0 instanceof GiftStateMachineConfig.Event.h) == false) goto L169;
        GiftContext r58 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r58 == null) goto L160;
        com.bytedance.live.datacontext.k<Unit> r59 = r58.getHideDialog();
        if (r59 == null) goto L160;
        r59.post(Unit.INSTANCE);
    L160:
        GiftContext r60 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r60 == null) goto L165;
        n<Boolean> r61 = r60.isContinuous();
        if (r61 == null) goto L165;
        r61.setValue(Boolean.FALSE);
    L165:
        DataCenter r63 = r31.g;
        if (r63 == null) goto L187;
        r63.put("data_gift_send_extra", null);
        goto L187
    L169:
        if ((r0 instanceof GiftStateMachineConfig.Event.d) == false) goto L174;
        if (((GiftStateMachineConfig.Event.d) r0).d == false) goto L187;
        StateMachine<GiftStateMachineConfig.a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r64 = r31.f;
        GiftStateMachineConfig.Event.o r65 = GiftStateMachineConfig.Event.o.b;
        StateMachine.a r66 = StateMachine.c;
        r64.d(r65, null);
        goto L187
    L174:
        if ((r0 instanceof GiftStateMachineConfig.Event.c) == false) goto L177;
        com.bytedance.android.livesdk.gift.util.b.f(GiftStateMachineConfig.Event.o.b);
        goto L187
    L177:
        if ((r0 instanceof GiftStateMachineConfig.Event.b) == false) goto L180;
        com.bytedance.android.livesdk.gift.util.b.f(GiftStateMachineConfig.Event.o.b);
        goto L187
    L180:
        if ((r0 instanceof GiftStateMachineConfig.Event.n) == false) goto L187;
        ((GiftStateMachineConfig.Event.n) r0).getClass();
        g r67 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r67 == null) goto L184;
        Context r68 = r67.getContext();
    L185:
        if (r68 == null) goto L187;
        e0.a(r68);
        goto L187
    L184:
        r68 = null;
    }

    public final void f(int r16, long r17) {
        g r0 = com.bytedance.android.livesdk.gift.util.b.c(false);
        String r3 = null;
        if (r0 == null) goto L5;
        Context r4 = r0.getContext();
    L6:
        DataCenter r1 = this.g;
        if (r1 == null) goto L9;
        IRoom r6 = (IRoom) r1.get("data_room", null);
    L10:
        JSONObject r7 = new JSONObject();
        yz0.k r5 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), yz0.k.class);     // Catch: Exception -> L32
        if (r5 == null) goto L14;
        Long r8 = Long.valueOf(r5.getUserFrom());     // Catch: Exception -> L32
    L15:
        r7.put("source", r8);     // Catch: Exception -> L32
        DataCenter r9 = this.g;     // Catch: Exception -> L32
        if (r9 == null) goto L18;
        String r10 = (String) r9.get("log_live_feed_layout", null);     // Catch: Exception -> L32
    L19:
        r7.put("live_source", r10);     // Catch: Exception -> L32
        if (r6 == null) goto L22;
        String r11 = r6.getRequestId();     // Catch: Exception -> L32
    L23:
        r7.put("request_id", r11);     // Catch: Exception -> L32
        if (r6 == null) goto L26;
        String r13 = r6.getLog_pb();     // Catch: Exception -> L32
    L27:
        r7.put("log_pb", r13);     // Catch: Exception -> L32
        DataCenter r14 = this.g;     // Catch: Exception -> L32
        if (r14 == null) goto L30;
        r3 = (String) r14.get("log_enter_live_source", null);     // Catch: Exception -> L32
    L30:
        r7.put("enter_from", r3);     // Catch: Exception -> L32
    L34:
        String r15 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r().getIdString();
        if (r4 != null) goto L37;
        return;
    L37:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f() == 5) goto L39;
    L41:
        boolean r18 = false;
    L42:
        DataCenter r19 = this.g;
        Integer r20 = Integer.valueOf(r16);
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L48;
        com.bytedance.live.datacontext.m<String> r21 = r2.getGiftListResultLogId();
        if (r21 == null) goto L48;
        String r23 = (String) r21.getValue();
        if (r23 == null) goto L48;
    L49:
        h.w(r4, r19, r6, r7, r15, r20, r23, r18, r17, com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r());
        return;
    L48:
        r23 = BuildConfig.FLAVOR;
        goto L49
    L39:
        if ((!com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.c().isEmpty()) == false) goto L41;
        r18 = true;
        goto L42
    L26:
        r13 = null;
        goto L27
    L22:
        r11 = null;
        goto L23
    L18:
        r10 = null;
        goto L19
    L14:
        r8 = null;
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L34
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public GiftDialogViewModelNew(DataCenter r2, GiftViewModelManager r3, LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r3, "giftViewModelManager");
        Intrinsics.checkNotNullParameter(r4, "owner");
        super(r4);
        this.g = r2;
        Function1<StateMachine.c<? extends GiftStateMachineConfig.a, ? extends GiftStateMachineConfig.Event, ? extends GiftStateMachineConfig.f>, Unit> r5 = new GiftDialogViewModelNew$listener$1(this);
        this.e = r5;
        int r6 = GiftStateMachineConfig.a;
        this.f = GiftStateMachineConfig.a(r5);
    }
}
