package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.LongSparseArray;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.core.util.i;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.r0;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftInRoomService;
import com.bytedance.android.livesdk.gift.platform.core.utils.e0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomEx;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.android.scope.q;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
public final class FormatGiftPanelDialogViewModel extends com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a implements o {
    public static final /* synthetic */ int h = 0;
    public final Function1<StateMachine.c<? extends GiftStateMachineConfig.a, ? extends GiftStateMachineConfig.Event, ? extends GiftStateMachineConfig.f>, Unit> e;
    public final StateMachine<GiftStateMachineConfig.a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> f;
    public final DataCenter g;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    private final Context getContext() {
        LifecycleOwner r0 = this.d;
        if ((r0 instanceof Context) == true) goto L6;
        r0 = null;
    L6:
        return (Context) r0;
    }

    public final void onStop() {
        a();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a
    public final void d(GiftStateMachineConfig.Event r37) {
        Intrinsics.checkNotNullParameter(r37, "event");
        if ((r37 instanceof GiftStateMachineConfig.Event.p) == false) goto L72;
        GiftStateMachineConfig.Event.p r2 = (GiftStateMachineConfig.Event.p) r37;
        AbsPanel<?> r7 = r2.b;
        AbsPanel.GiftPanelSelectType r8 = r2.c;
        if (r8 != AbsPanel.GiftPanelSelectType.DEFAULT_SELECTED) goto L7;
    L10:
        boolean r4 = true;
    L11:
        FormatGiftListViewModel r9 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.h();
        if (r9 == null) goto L14;
        Map r10 = r9.e;
    L15:
        T r11 = r7.h;
        if ((r11 instanceof h1) == false) goto L46;
        if (r11 == 0) goto L44;
        h1 r13 = (h1) r11;
        if ((r13.getReqExtraType() & 2) != 2) goto L27;
        i12.e r14 = i12.o.a();
        if (r14 == null) goto L23;
        Object r15 = m.e.d(r14, GiftExtraRepo.class);
    L24:
        GiftExtraRepo r16 = (GiftExtraRepo) r15;
        if (r16 == null) goto L27;
        r0.a.a(r16, CollectionsKt.listOf(Long.valueOf(r13.getId())), "handleSelectedGift", null, 12);
        goto L27
    L23:
        r15 = null;
    L27:
        Iterator r17 = r10.keySet().iterator();
    L29:
        if (r17.hasNext() == false) goto L33;
        w1 r18 = (w1) r17.next();
        if (r18.getPageType() != com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c()) goto L29;
        LongSparseArray r19 = (LongSparseArray) r10.get(r18);
    L34:
        if (r4 == true) goto L36;
    L39:
        if (r19 == null) goto L58;
        if (r19.get(r13.getId()) == null) goto L58;
        ((Number) r19.get(r13.getId())).intValue();
    L58:
        if ((r7 instanceof pz1.a) == false) goto L76;
        pz1.a r3 = (pz1.a) r7;
        if (r3.p() == false) goto L66;
        Context r5 = getContext();
        if (r5 == null) goto L64;
        cs2.b r6 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.ui.d.class).yn(r5, 1);
        r6.a.b(r3.l());
        r6.a.a(2, 2131920806, e.a);
        r6.h();
    L64:
        com.bytedance.tools.kcp.spongepreference.runtime.a r20 = ay1.b.m;
        KProperty[] r21 = ay1.b.a;
        HashSet r23 = (HashSet) r20.getValue(null, r21[15]);
        r23.add(Long.valueOf(r7.c()));
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r20.setValue(null, r21[15], r23);
        goto L76
    L66:
        if (r3.o() == false) goto L76;
        r3.k();
        UrlBuilder r24 = new UrlBuilder(BuildConfig.FLAVOR);
        Context r25 = getContext();
        if (r25 == null) goto L70;
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(r25, r24.build());
    L70:
        com.bytedance.tools.kcp.spongepreference.runtime.a r26 = ay1.b.n;
        KProperty[] r27 = ay1.b.a;
        HashSet r28 = (HashSet) r26.getValue(null, r27[16]);
        r28.add(String.valueOf(r7.c()));
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        r26.setValue(null, r27[16], r28);
    L76:
        FormatGiftPanelDialogViewModel r29 = this;
        GiftStateMachineConfig.Event r0 = r37;
    L181:
        StateMachine<GiftStateMachineConfig.a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r1 = r29.f;
        StateMachine.a r30 = StateMachine.c;
        r1.d(r0, null);
        return;
    L36:
        if (r2.e == false) goto L39;
        if (r18 == null) goto L39;
        f(r18.getPageType(), r13.getId());
        goto L39
    L33:
        r19 = null;
        r18 = null;
        goto L34
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L46:
        if ((r11 instanceof l2) == false) goto L58;
        if (r2.e == false) goto L58;
        if (r11 == 0) goto L56;
        h1 r31 = ((l2) r11).getGift();
        if (r31 == null) goto L53;
        Long r33 = Long.valueOf(r31.getId());
    L54:
        f(5, r33.longValue());
        goto L58
    L53:
        r33 = null;
        goto L54
    L56:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L14:
        r10 = new HashMap();
        goto L15
    L7:
        if (r8 == AbsPanel.GiftPanelSelectType.LOCATED) goto L10;
        r4 = false;
        goto L11
    L72:
        if ((r37 instanceof GiftStateMachineConfig.Event.k) == false) goto L78;
        final int r34 = ((GiftStateMachineConfig.Event.k) r37).b;
        com.bytedance.android.livesdk.gift.util.b.f(GiftStateMachineConfig.Event.o.b);
        Context r35 = getContext();
        if (r35 == null) goto L76;
        this.c.add(com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).z4(r35, new FormatGiftPanelDialogViewModel$login$$inlined$let$lambda$1(this, r34)).subscribe(new f(this), g.a));
        goto L76
    L78:
        if ((r37 instanceof GiftStateMachineConfig.Event.q) == true) goto L184;
        if ((r37 instanceof GiftStateMachineConfig.Event.r) == true) goto L184;
        if ((r37 instanceof GiftStateMachineConfig.Event.m) == false) goto L143;
        GiftStateMachineConfig.Event.m r36 = (GiftStateMachineConfig.Event.m) r37;
        x2 r38 = r36.b;
        String r39 = "click";
        if (r38 != null) goto L87;
        r38 = new x2("click", "gift_recharge");
    L87:
        boolean r40 = r36.c;
        if (TextUtils.isEmpty(r38.d) == false) goto L90;
    L141:
        r29 = this;
    L142:
        r0 = r37;
        goto L181
    L90:
        if (TextUtils.isEmpty(r38.e) == true) goto L141;
        if (com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin() == true) goto L103;
        i12.e r41 = i12.o.a();
        if (r41 == null) goto L97;
        Object r43 = m.e.d(r41, GiftInRoomService.class);
    L98:
        GiftInRoomService r44 = (GiftInRoomService) r43;
        if (r44 == null) goto L101;
        r44.a(1002);
        goto L141
    L101:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.k(1002));
        goto L141
    L97:
        r43 = null;
        goto L98
    L103:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).interceptOperation("recharge") == true) goto L141;
        if (com.bytedance.android.livesdk.gift.platform.core.g.a() != com.bytedance.android.livesdk.gift.platform.core.g.e) goto L135;
        String r110 = r38.d;
        String r111 = r38.e;
        long r112 = r38.h;
        int r113 = r38.j;
        long r45 = r38.i;
        long r46 = r38.k;
        String r114 = BuildConfig.FLAVOR;
        long r47 = r38.g;
        String r48 = r38.l;
        FragmentActivity r49 = getContext();
        if (r49 != null) goto L111;
    L115:
        r29 = this;
        goto L142
    L111:
        if ((r49 instanceof FragmentActivity) == false) goto L113;
        FragmentActivity r50 = r49;
    L114:
        if (r50 == null) goto L115;
        if (TextUtils.equals("gift_recharge", r111) == true) goto L121;
        r39 = "call";
    L121:
        if (r47 <= 0) goto L123;
        boolean r310 = true;
    L124:
        GiftContext r115 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r115 == null) goto L132;
        com.bytedance.live.datacontext.m<String> r116 = r115.getGiftListResultLogId();
        if (r116 == null) goto L132;
        String r117 = (String) r116.getValue();
        if (r117 == null) goto L132;
        r114 = r117;
    L132:
        com.bytedance.android.live.recharge.model.d r118 = new com.bytedance.android.live.recharge.model.d(true, r110, null, r47, r310, 0, 0, r111, r39, new com.bytedance.android.live.recharge.model.b(r114, r48, r46, r45, r112, r113, null, 192), null, null, null, 31844);
        IRechargeService r51 = k.f(IRechargeService.class);
        Intrinsics.checkNotNull(r51);
        r29 = this;
        r51.showRechargeDialogFragment(r50, r118, new h(r29, r40));
        if (r40 == false) goto L142;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        goto L142
    L123:
        r310 = false;
        goto L124
    L113:
        r50 = null;
        goto L114
    L135:
        r29 = this;
        Context r53 = getContext();
        if (r53 == null) goto L142;
        if ((r53 instanceof Activity) == false) goto L142;
        vh6.c.b(wh6.a.class).openWallet((Activity) r53);
        goto L142
    L143:
        r29 = this;
        r0 = r37;
        if ((r0 instanceof GiftStateMachineConfig.Event.h) == false) goto L166;
        GiftContext r54 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r54 == null) goto L150;
        com.bytedance.live.datacontext.k<Unit> r55 = r54.getHideDialog();
        if (r55 == null) goto L150;
        r55.post(Unit.INSTANCE);
    L150:
        GiftContext r56 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r56 == null) goto L155;
        n<Boolean> r57 = r56.isContinuous();
        if (r57 == null) goto L155;
        r57.setValue(Boolean.FALSE);
    L155:
        DataCenter r58 = r29.g;
        if (r58 == null) goto L158;
        r58.put("data_gift_send_extra", null);
    L158:
        i12.e r59 = i12.o.a();
        if (r59 == null) goto L161;
        Object r60 = m.e.d(r59, com.bytedance.android.livesdk.gift.platform.format.service.m.class);
    L162:
        com.bytedance.android.livesdk.gift.platform.format.service.m r61 = (com.bytedance.android.livesdk.gift.platform.format.service.m) r60;
        if (r61 == null) goto L181;
        r61.c();
        goto L181
    L161:
        r60 = null;
        goto L162
    L166:
        if ((r0 instanceof GiftStateMachineConfig.Event.d) == false) goto L171;
        if (((GiftStateMachineConfig.Event.d) r0).d == false) goto L181;
        StateMachine<GiftStateMachineConfig.a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r63 = r29.f;
        GiftStateMachineConfig.Event.o r64 = GiftStateMachineConfig.Event.o.b;
        StateMachine.a r65 = StateMachine.c;
        r63.d(r64, null);
        goto L181
    L171:
        if ((r0 instanceof GiftStateMachineConfig.Event.c) == false) goto L174;
        com.bytedance.android.livesdk.gift.util.b.f(GiftStateMachineConfig.Event.o.b);
        goto L181
    L174:
        if ((r0 instanceof GiftStateMachineConfig.Event.b) == false) goto L177;
        com.bytedance.android.livesdk.gift.util.b.f(GiftStateMachineConfig.Event.o.b);
        goto L181
    L177:
        if ((r0 instanceof GiftStateMachineConfig.Event.n) == false) goto L181;
        ((GiftStateMachineConfig.Event.n) r0).getClass();
        Context r66 = getContext();
        if (r66 == null) goto L181;
        e0.a(r66);
    }

    public FormatGiftPanelDialogViewModel(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super((LifecycleOwner) r3);
        this.g = r2;
        Function1<StateMachine.c<? extends GiftStateMachineConfig.a, ? extends GiftStateMachineConfig.Event, ? extends GiftStateMachineConfig.f>, Unit> r4 = new FormatGiftPanelDialogViewModel$listener$1(this);
        this.e = r4;
        int r5 = GiftStateMachineConfig.a;
        this.f = GiftStateMachineConfig.a(r4);
    }

    public final void f(int r13, long r14) {
        Context r0 = getContext();
        DataCenter r1 = this.g;
        String r2 = null;
        if (r1 == null) goto L5;
        IRoomEx r3 = (IRoom) r1.get("data_room", null);
    L6:
        JSONObject r4 = new JSONObject();
        int r5 = i.a;     // Catch: Exception -> L24
        q r6 = m.b;     // Catch: Exception -> L24
        r4.put("source", null);     // Catch: Exception -> L24
        DataCenter r7 = this.g;     // Catch: Exception -> L24
        if (r7 == null) goto L10;
        String r8 = (String) r7.get("log_live_feed_layout", null);     // Catch: Exception -> L24
    L11:
        r4.put("live_source", r8);     // Catch: Exception -> L24
        if (r3 == null) goto L14;
        String r9 = r3.getRequestId();     // Catch: Exception -> L24
    L15:
        r4.put("request_id", r9);     // Catch: Exception -> L24
        if (r3 == null) goto L18;
        String r10 = r3.getLog_pb();     // Catch: Exception -> L24
    L19:
        r4.put("log_pb", r10);     // Catch: Exception -> L24
        DataCenter r11 = this.g;     // Catch: Exception -> L24
        if (r11 == null) goto L22;
        r2 = (String) r11.get("log_enter_live_source", null);     // Catch: Exception -> L24
    L22:
        r4.put("enter_from", r2);     // Catch: Exception -> L24
    L26:
        String r15 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.m().getIdString();
        if (r0 != null) goto L29;
        return;
    L29:
        if (com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c() != 5) goto L37;
        FormatGiftListViewModel r16 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.h();
        if (r16 == null) goto L33;
        List<AbsPanel<?>> r17 = r16.g(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c());
    L35:
        if ((!r17.isEmpty()) == false) goto L37;
        boolean r18 = true;
    L38:
        DataCenter r19 = this.g;
        Integer r110 = Integer.valueOf(r13);
        GiftContext r20 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r20 == null) goto L44;
        com.bytedance.live.datacontext.m<String> r21 = r20.getGiftListResultLogId();
        if (r21 == null) goto L44;
        String r23 = (String) r21.getValue();
        if (r23 == null) goto L44;
    L45:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.w(r0, r19, r3, r4, r15, r110, r23, r18, r14, com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.m());
        return;
    L44:
        r23 = BuildConfig.FLAVOR;
        goto L45
    L33:
        r17 = new ArrayList();
    L37:
        r18 = false;
        goto L38
    L18:
        r10 = null;
        goto L19
    L14:
        r9 = null;
        goto L15
    L10:
        r8 = null;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    L5:
        r3 = null;
        goto L6
    }
}
