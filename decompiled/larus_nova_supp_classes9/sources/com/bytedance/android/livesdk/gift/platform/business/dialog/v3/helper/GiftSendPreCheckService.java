package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.GiftPluginType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftInRoomService;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftSendPreCheckService implements com.bytedance.android.scope.o {
    public final GiftReceiverRepoService a;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a b;
    public final AssetsService c;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f d;
    public final GiftExtraRepo e;
    public final com.bytedance.android.livesdk.gift.platform.business.sendGift.n f;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.i0 g;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final int d(IBaseUser r13, ReceiverType r14, List<? extends IBaseUser> r15) {
        Intrinsics.checkNotNullParameter(r13, "receiver");
        AbsPanel<?> r0 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.d();
        h1 r2 = null;
        if ((r0 instanceof pz1.a) == false) goto L16;
        T r1 = r0.h;
        if ((r1 instanceof h1) == false) goto L11;
        if (r1 == 0) goto L9;
        l2 r6 = null;
        r2 = (h1) r1;
    L17:
        h1 r5 = r2;
        if (r14 != null) goto L21;
        r14 = this.g.a();
    L21:
        return a(r13, r5, r6, r14, r15, SendGiftSource.GiftDialog, null, null);
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L11:
        if ((r1 instanceof l2) == false) goto L16;
        if (r1 == 0) goto L15;
        r6 = (l2) r1;
        goto L17
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L16:
        r6 = null;
        goto L17
    }

    public final int g(Boolean r5, IBaseUser r6, ReceiverType r7) {
        if (this.a.h(2) == true) goto L7;
        if (r7 == ReceiverType.Guest) goto L7;
    L28:
        return 0;
    L7:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).isMicRoomHost(r6.getIdString()) == true) goto L9;
    L11:
        boolean r8 = false;
    L12:
        if (r8 == false) goto L15;
        return 0;
    L15:
        if (this.a.q(1) == true) goto L19;
        ToastUtil.a(2131922461, 0);
        return 521;
    L19:
        if (this.a.K(r6, 2) == true) goto L23;
        ToastUtil.a(2131922460, 0);
        return 522;
    L23:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L28;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.Y.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[49])).booleanValue() == true) goto L28;
        ToastUtil.a(2131919081, 0);
        return 523;
    L9:
        if (this.a.q(5) == false) goto L11;
        r8 = true;
        goto L12
    }

    public final int c(h2 r18, SendGiftSource r19, l1 r20, com.bytedance.android.livesdk.gift.model.n r21) {
        Intrinsics.checkNotNullParameter(r19, "sendGiftFrom");
        if (r19 != SendGiftSource.GiftDialog) goto L50;
        if (r18 == null) goto L50;
        com.bytedance.android.livesdk.gift.model.p r1 = null;
        if (r20 != null) goto L8;
    L31:
        if (r21 == null) goto L50;
        if (nz1.a.s() == false) goto L50;
        com.bytedance.android.livesdk.gift.model.g0 r3 = this.e.q(r18.getId());
        if (r3 == null) goto L38;
        r1 = r3.getDiyGiftToolbarInfo();
    L38:
        if (r1 != null) goto L40;
        return 601;
    L40:
        List<com.bytedance.android.livesdk.gift.model.n> r2 = this.d.d(r18.getId(), r1);
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r2.iterator();
    L42:
        if (r5.hasNext() == false) goto L47;
        Object r6 = r5.next();
        if (gz1.c.h(gz1.c.g((com.bytedance.android.livesdk.gift.model.n) r6), gz1.c.g(r21)) == false) goto L42;
        r4.add(r6);
        goto L42
    L47:
        if (r4.isEmpty() == false) goto L50;
        this.f.a("diy_card", r18.getId(), r19, CollectionsKt.joinToString$default(gz1.c.g(r21), null, null, null, 0, null, GiftSendPreCheckService$preCheckBuffAndDiyCard$3.INSTANCE, 31, null));
        return 601;
    L8:
        if (nz1.a.r() == false) goto L31;
        com.bytedance.android.livesdk.gift.model.g0 r7 = this.e.q(r18.getId());
        boolean r8 = true;
        if (r7 == null) goto L22;
        List<l1> r9 = r7.getGiftBuffInfos();
        if (r9 == null) goto L22;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r9.iterator();
    L15:
        if (r11.hasNext() == false) goto L23;
        Object r13 = r11.next();
        if (((l1) r13).getBuffGiftId() != r20.getBuffGiftId()) goto L19;
        boolean r14 = true;
    L20:
        if (r14 == false) goto L15;
        r10.add(r13);
        goto L15
    L19:
        r14 = false;
    L23:
        if (r10 != null) goto L25;
    L28:
        if (r8 == false) goto L31;
        this.f.a("buff_card", r18.getId(), r19, String.valueOf(r20.getBuffGiftId()));
        return 600;
    L25:
        if (r10.isEmpty() == true) goto L28;
        r8 = false;
    L22:
        r10 = null;
    L50:
        return 0;
    }

    public GiftSendPreCheckService(GiftReceiverRepoService r2, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r3, AssetsService r4, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f r5, GiftExtraRepo r6, com.bytedance.android.livesdk.gift.platform.business.sendGift.n r7, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.i0 r8) {
        Intrinsics.checkNotNullParameter(r2, "receiverRepoService");
        Intrinsics.checkNotNullParameter(r3, "allMicService");
        Intrinsics.checkNotNullParameter(r4, "assetService");
        Intrinsics.checkNotNullParameter(r5, "diyDataStore");
        Intrinsics.checkNotNullParameter(r6, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r7, "giftTransactionMonitor");
        Intrinsics.checkNotNullParameter(r8, "receiverService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public final int a(IBaseUser r37, h2 r38, l2 r39, ReceiverType r40, List<? extends IBaseUser> r41, SendGiftSource r43, l1 r44, com.bytedance.android.livesdk.gift.model.n r45) {
        boolean r11 = true;
        if (r38 != null) goto L5;
    L16:
        Object r14 = null;
        if (r38 == null) goto L23;
        com.bytedance.android.livesdk.gift.model.k0 r15 = r38.getGiftPreviewInfo();
        if (r15 == null) goto L23;
        if (r15.getLockStatus() != com.bytedance.android.livesdk.gift.model.k0.UNLOCKED) goto L23;
    L54:
        int r5 = c(r38, r43, r44, r45);
        if (r5 == 0) goto L58;
        return r5;
    L58:
        if (this.b.j() == false) goto L85;
        if (r38 == null) goto L61;
        Boolean r6 = Boolean.valueOf(r38.isForFansClub());
    L63:
        if (this.a.h(2) == false) goto L81;
        List<IBaseUser> r16 = this.b.i();
        if (r16 != null) goto L67;
    L70:
        boolean r17 = true;
    L71:
        if (r17 == false) goto L74;
        ToastUtil.a(2131922460, 0);
        int r7 = 541;
    L82:
        if (r7 == 0) goto L85;
        return r7;
    L74:
        if (this.a.q(1) == true) goto L77;
        ToastUtil.a(2131922461, 0);
        r7 = 542;
        goto L82
    L77:
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L81;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.Y.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[49])).booleanValue() == true) goto L81;
        ToastUtil.a(2131919081, 0);
        r7 = 543;
        goto L82
    L67:
        if (r16.isEmpty() == true) goto L70;
        r17 = false;
    L81:
        r7 = 0;
        goto L82
    L61:
        r6 = null;
    L85:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.l(r37) == false) goto L87;
    L182:
        List<? extends IBaseUser> r1 = r41;
        if (r1 != null) goto L185;
    L188:
        boolean r2 = true;
    L189:
        if (r2 == true) goto L212;
        yz0.k r3 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r3 == null) goto L195;
        IRoom r4 = r3.getRoom();
        if (r4 == null) goto L195;
        String r8 = r4.getAnchorId();
    L196:
        ArrayList r9 = new ArrayList();
        Iterator<T> r10 = r41.iterator();
    L198:
        if (r10.hasNext() == false) goto L202;
        Object r13 = r10.next();
        if (TextUtils.equals(((IBaseUser) r13).getIdString(), r8) == true) goto L198;
        r9.add(r13);
        goto L198
    L202:
        Iterator r18 = r9.iterator();
    L204:
        if (r18.hasNext() == false) goto L212;
        IBaseUser r19 = (IBaseUser) r18.next();
        if (r38 == null) goto L208;
        Boolean r20 = Boolean.valueOf(r38.isForFansClub());
    L209:
        int r21 = g(r20, r19, ReceiverType.Guest);
        if (r21 == 0) goto L204;
        return r21;
    L208:
        r20 = null;
    L195:
        r8 = null;
    L212:
        if (r39 != null) goto L214;
        return 0;
    L214:
        if (((Boolean) nz1.a.r.getValue(null, nz1.a.a[16])).booleanValue() == false) goto L271;
        int r23 = com.bytedance.android.livesdk.gift.platform.core.utils.q.a(r39);
        if (r23 == 0) goto L272;
        ToastUtil.a(2131919791, 0);
        if (r23 == 1) goto L223;
        if (r23 == 2) goto L223;
        if (r23 == 3) goto L222;
        String r24 = "others(impossible)";
    L224:
        if (r23 == 3) goto L228;
        if (r23 == 2) goto L227;
    L229:
        String r25 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        long r110 = r39.getGift().getId();
        long r111 = r39.getId();
        Intrinsics.checkNotNullParameter(r24, "interruptionType");
        Map r26 = com.bytedance.revenue.platform.api.core.d.a(new Pair[]{TuplesKt.to("user_id", com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId()), TuplesKt.to("gift_id", String.valueOf(r110)), TuplesKt.to("prop_id", String.valueOf(r111)), TuplesKt.to("interruption_type", r24)});
        mz0.n r27 = new mz0.n();
        Map r28 = r27.a;
        Intrinsics.checkNotNullParameter(r28, "map");
        Intrinsics.checkNotNullParameter(r26, "map");
        r28.putAll(r26);
        mz0.m r29 = new mz0.m();
        r29.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r30 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r30, "pageSourceLog");
        ((ArrayList) r29.a).add(r30.a);
        ((ArrayList) r27.b).addAll(r29.a);
        cy0.e.a.getClass();
        cy0.j r31 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r33 = com.bytedance.android.scope.m.b(r31).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r33);
        ((f80.a) r33).w3("livesdk_prop_interruption_toast_show", r27.a, r27.b);
        Integer r34 = Integer.valueOf(r23);
        Intrinsics.checkNotNullParameter(r39, "prop");
        h1 r35 = r39.getGift();
        long r36 = r35.getId();
        long r112 = r39.getPropType();
        long r113 = r39.getId();
        long r114 = r35.getPrimaryEffectId();
        if (r34 == null) goto L232;
        int r46 = r34.intValue();
    L233:
        if (r46 == 0) goto L253;
        yz0.k r47 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r47 == null) goto L239;
        IRoom r48 = r47.getRoom();
        if (r48 == null) goto L239;
        long r49 = r48.getRoomId();
    L240:
        tz0.b r210 = tz0.b.a;
        uz0.e r115 = new uz0.e();
        r210.getClass();
        Intrinsics.checkNotNullParameter(r115, "$this$beforeConfigureRequest");
        uz0.b r116 = new uz0.b(r115.e);
        r116.a("alarm_type", Integer.valueOf(r46).toString());
        r116.a("gift_id", Long.valueOf(r36).toString());
        r116.a("prop_id", Long.valueOf(r113).toString());
        r116.a("asset_id", Long.valueOf(r114).toString());
        Integer r211 = 2;
        r116.a("source", r211.toString());
        r116.a("prop_type", Long.valueOf(r112).toString());
        r116.a("room_id", Long.valueOf(r49).toString());
        Intrinsics.checkNotNullParameter(r115, "$this$afterConfigureRequest");
        Observable r0 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.Revenue, "/webcast/props/binding_alarm/", TypesJVMKt.getJavaType(Reflection.typeOf(Unit.class)), Extra.class, ((uz0.a) r115).d, ((uz0.a) r115).a, ((uz0.a) r115).b, ((uz0.a) r115).c, r115.e, r115.f, r115.g).compose(RxUtil.rxSchedulerHelper());
        if (r0 != null) goto L243;
    L244:
        Disposables.disposed();
    L245:
        boolean r50 = com.bytedance.android.livesdk.gift.platform.core.d0.a;
        if (r46 == 0) goto L270;
        LinkedHashMap r51 = new LinkedHashMap();
        r51.put("asset_id", String.valueOf(r114));
        r51.put("gift_id", String.valueOf(r36));
        r51.put("prop_id", String.valueOf(r113));
        r51.put("error_code", String.valueOf(r46));
        r51.put("is_in_beta_testing", String.valueOf(false));
        r51.put("source", 2);
        JSONObject r53 = new JSONObject();
        JSONObject r54 = new JSONObject();
        JSONObject r55 = new JSONObject();
        Intrinsics.checkNotNullParameter(r55, "extra");
        Intrinsics.checkNotNullParameter(r54, "metric");
        EventModule r56 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r56, "eventModule");
        String r57 = r56.getValue();
        Intrinsics.checkNotNullParameter(r53, "map");
        Intrinsics.checkNotNullParameter(r51, "value");
        Iterator r58 = r51.entrySet().iterator();
    L250:
        if (r58.hasNext() == false) goto L252;
        Map.Entry r59 = (Map.Entry) r58.next();
        r53.put((String) r59.getKey(), r59.getValue());
        goto L250
    L252:
        cy0.e.a.getClass();
        cy0.j r60 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r61 = com.bytedance.android.scope.m.b(r60).b(n97.a.class);
        Intrinsics.checkNotNull(r61);
        ((com.bytedance.live.kmp.core.c) r61).g("ttlive_prop_online_status_error", r57, "bussiness_api_call", r53, r54, r55);
        return 504;
    L270:
        return 504;
    L243:
        if (r0.subscribe(com.bytedance.android.livesdk.gift.platform.core.utils.o.a, com.bytedance.android.livesdk.gift.platform.core.utils.p.a) != null) goto L245;
    L239:
        r49 = 0;
        goto L240
    L253:
        Disposables.disposed();
        return 504;
    L232:
        r46 = com.bytedance.android.livesdk.gift.platform.core.utils.q.a(r39);
        goto L233
    L227:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.c0.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[53])).booleanValue() == false) goto L229;
    L228:
        this.c.j4(r39.getGift().getPrimaryEffectId(), null, IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        goto L229
    L222:
        r24 = "loading";
    L223:
        r24 = "offline";
        goto L224
    L272:
        return 0;
    L271:
        return 0;
    L185:
        if (r1.isEmpty() == true) goto L188;
        r2 = false;
        goto L189
    L87:
        if (this.b.j() == true) goto L182;
        List<? extends IBaseUser> r63 = r41;
        if (r63 != null) goto L91;
    L94:
        boolean r64 = true;
    L95:
        if (r64 == false) goto L182;
        ReceiverType r65 = ReceiverType.OtherAnchor;
        if (r40 != r65) goto L117;
        if (r38 == null) goto L100;
        Boolean r117 = Boolean.valueOf(r38.isForFansClub());
    L102:
        if (this.a.h(4) == true) goto L105;
        if (r40 == r65) goto L105;
    L113:
        int r66 = 0;
    L114:
        if (r66 == 0) goto L117;
        return r66;
    L105:
        if (this.a.K(r37, 4) == true) goto L111;
        if (this.a.q(2) == true) goto L109;
        ToastUtil.a(2131919156, 0);
        r66 = 516;
        goto L114
    L109:
        ToastUtil.a(2131922457, 0);
        r66 = 511;
        goto L114
    L111:
        if (Intrinsics.areEqual(r117, Boolean.TRUE) == false) goto L113;
        ToastUtil.a(2131919081, 0);
        r66 = 512;
        goto L114
    L100:
        r117 = null;
    L117:
        if (r40 != ReceiverType.Guest) goto L125;
        if (r38 == null) goto L120;
        Boolean r67 = Boolean.valueOf(r38.isForFansClub());
    L121:
        int r68 = g(r67, r37, r40);
        if (r68 == 0) goto L125;
        return r68;
    L120:
        r67 = null;
    L125:
        if (r40 != ReceiverType.GroupLive) goto L148;
        if (r38 == null) goto L128;
        Boolean r69 = Boolean.valueOf(r38.isForFansClub());
    L129:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j r118 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j) ((LinkedHashMap) this.a.b).get(7);
        if (r118 == null) goto L133;
        List<IBaseUser> r119 = r118.a;
        if (r119 == null) goto L133;
    L135:
        if ((!r119.isEmpty()) == true) goto L137;
    L145:
        int r70 = 0;
    L146:
        if (r70 == 0) goto L148;
        return r70;
    L137:
        if (Intrinsics.areEqual(r69, Boolean.TRUE) == true) goto L139;
    L141:
        if (r39 == null) goto L145;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.W.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[47])).booleanValue() == true) goto L145;
        ToastUtil.a(2131917224, 0);
        r70 = 581;
        goto L146
    L139:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.X.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[48])).booleanValue() == true) goto L141;
        ToastUtil.a(2131917223, 0);
        r70 = 580;
    L133:
        r119 = CollectionsKt.emptyList();
        goto L135
    L128:
        r69 = null;
    L148:
        ReceiverType r71 = ReceiverType.Audience;
        if (r40 != r71) goto L177;
        if (r38 == null) goto L152;
        Boolean r120 = Boolean.valueOf(r38.isForFansClub());
    L153:
        if (r40 != r71) goto L173;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j r73 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j) ((LinkedHashMap) this.a.b).get(1);
        if (r73 == null) goto L158;
        List<IBaseUser> r74 = r73.a;
        if (r74 == null) goto L158;
    L159:
        List<IBaseUser> r75 = r74;
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r75, 10));
        Iterator<T> r76 = r75.iterator();
    L161:
        if (r76.hasNext() == false) goto L164;
        r121.add(((IBaseUser) r76.next()).getIdString());
        goto L161
    L164:
        if (r121.contains(r37.getIdString()) == false) goto L169;
        if (this.a.q(1) == false) goto L169;
        ToastUtil.a(2131922461, 0);
        int r77 = 560;
    L174:
        if (r77 == 0) goto L177;
        return r77;
    L169:
        if (Intrinsics.areEqual(r120, Boolean.TRUE) == false) goto L171;
        ToastUtil.a(2131919080, 0);
        r77 = 561;
        goto L174
    L171:
        if (r39 == null) goto L173;
        ToastUtil.a(2131919794, 0);
        r77 = 562;
    L158:
        r74 = CollectionsKt.emptyList();
    L173:
        r77 = 0;
        goto L174
    L152:
        r120 = null;
    L177:
        if (r40 != ReceiverType.Anchor) goto L182;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.x.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[22])).booleanValue() == false) goto L182;
        ToastUtil.a(2131922460, 0);
        return 503;
    L91:
        if (r63.isEmpty() == true) goto L94;
        r64 = false;
    L23:
        if (((Boolean) nz1.a.F.getValue(null, nz1.a.a[30])).booleanValue() == false) goto L54;
        if (r43 == SendGiftSource.JsbPage) goto L54;
        if (r38 == null) goto L54;
        com.bytedance.android.livesdk.gift.model.k0 r122 = r38.getGiftPreviewInfo();
        if (r122 == null) goto L54;
        if (r122.getClientBlockUseSchemeUrl() == false) goto L54;
        if (com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin() == true) goto L43;
        i12.e r78 = i12.o.b();
        if (r78 == null) goto L36;
        r14 = com.bytedance.android.scope.m.e.d(r78, GiftInRoomService.class);
    L36:
        GiftInRoomService r123 = (GiftInRoomService) r14;
        if (r123 == null) goto L39;
        r123.a(1001);
        return 505;
    L39:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.k(1001));
        return 505;
    L43:
        if (r122.getBlockToast().length() <= 0) goto L45;
        boolean r79 = true;
    L46:
        if (r79 == false) goto L52;
        String r80 = UriProtector.parse(r122.getBlockSchemeUrl()).getHost();
        if (r80 != null) goto L50;
    L51:
        int r81 = ToastUtil.a;
        ToastUtil.b(r122.getBlockToast(), 0);
        goto L52
    L50:
        if (StringsKt.startsWith$default(r80, "webcast_inroom_toast", false, 2, null) != true) goto L51;
    L52:
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(s1.getContext(), r122.getBlockSchemeUrl());
        return 501;
    L45:
        r79 = false;
        goto L46
    L5:
        if (r38.getId() != 8888) goto L16;
        com.bytedance.android.livesdk.gift.platform.business.g r83 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r83 == null) goto L13;
        Map<GiftPluginType, com.bytedance.android.livesdk.gift.platform.business.h> r84 = r83.h();
        if (r84 == null) goto L13;
        if (r84.containsKey(GiftPluginType.TYPE_RED_PACKET) != true) goto L13;
    L14:
        int r85 = r38.getType();
        boolean r86 = com.bytedance.android.livesdk.gift.platform.core.d0.a;
        String r87 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_fast_gift_show_status");
        JSONObject r88 = new JSONObject();
        JSONObject r89 = new JSONObject();
        JSONObject r90 = new JSONObject();
        Intrinsics.checkNotNullParameter(r90, "extra");
        Intrinsics.checkNotNullParameter(r89, "metric");
        EventModule r91 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r91, "eventModule");
        String r93 = r91.getValue();
        Intrinsics.checkNotNullParameter(r88, "map");
        Intrinsics.checkNotNullParameter("status_code", "key");
        Intrinsics.checkNotNullParameter(507, "value");
        r88.put("status_code", 507);
        Intrinsics.checkNotNullParameter("status", "key");
        Intrinsics.checkNotNullParameter(507, "value");
        r88.put("status", 507);
        Integer r94 = Integer.valueOf(r85);
        Intrinsics.checkNotNullParameter("realGiftType", "key");
        Intrinsics.checkNotNullParameter(r94, "value");
        r88.put("realGiftType", r94);
        Boolean r95 = Boolean.valueOf(r11);
        Intrinsics.checkNotNullParameter("hasRPCheckPlugin", "key");
        Intrinsics.checkNotNullParameter(r95, "value");
        r88.put("hasRPCheckPlugin", r95);
        cy0.e.a.getClass();
        cy0.j r96 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r97 = com.bytedance.android.scope.m.b(r96).b(n97.a.class);
        Intrinsics.checkNotNull(r97);
        ((com.bytedance.live.kmp.core.c) r97).g(r87, r93, "bussiness_api_call", r88, r89, r90);
        return 507;
    L13:
        r11 = false;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int f(GiftSendPreCheckService r13, IBaseUser r14, h2 r15, l2 r16, ReceiverType r17, List r18, SendGiftSource r19, l1 r110, com.bytedance.android.livesdk.gift.model.n r20, int r21) {
        if ((r21 & 16) == 0) goto L5;
        List r8 = null;
    L7:
        if ((r21 & 32) == 0) goto L9;
        SendGiftSource r9 = SendGiftSource.GiftDialog;
    L11:
        if ((r21 & 64) == 0) goto L13;
        l1 r10 = null;
    L15:
        if ((r21 & 128) == 0) goto L17;
        com.bytedance.android.livesdk.gift.model.n r11 = null;
    L18:
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "receiver");
        Intrinsics.checkNotNullParameter(r17, "receiverType");
        Intrinsics.checkNotNullParameter(r9, "sendGiftFrom");
        return r13.a(r14, r15, r16, r17, r8, r9, r10, r11);
    L17:
        r11 = r20;
        goto L18
    L13:
        r10 = r110;
        goto L15
    L9:
        r9 = r19;
        goto L11
    L5:
        r8 = r18;
        goto L7
    }
}
