package x02;

import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.k3;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.l3;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.DIYCardSelectType;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.g1;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l extends d0 {
    public l() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final void c(com.bytedance.android.livesdk.gift.platform.core.model.t r39, p2 r40, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r41, Function1<? super y, Unit> r43) {
        Intrinsics.checkNotNullParameter(r39, "info");
        Intrinsics.checkNotNullParameter(r41, "listener");
        Intrinsics.checkNotNullParameter(r43, "nextPlugin");
        if (r39.a().b > 0) goto L5;
        return;
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r0 = ((ArrayList) r41).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r1.putAll(((com.bytedance.android.livesdk.gift.platform.core.model.r) r0.next()).a());
        goto L7
    L9:
        boolean r3 = false;
        long r4 = 0;
        if (r39.b() == false) goto L51;
        i12.e r2 = i12.o.b();
        if (r2 == null) goto L14;
        Object r5 = com.bytedance.android.scope.m.e.d(r2, GiftDataStorageService.class);
    L15:
        GiftDataStorageService r6 = (GiftDataStorageService) r5;
        if (r6 == null) goto L18;
        r6.b += r39.a().b;
        Unit r7 = Unit.INSTANCE;
    L18:
        i12.e r8 = i12.o.b();
        if (r8 == null) goto L21;
        Object r9 = com.bytedance.android.scope.m.e.d(r8, GiftDataStorageService.class);
    L22:
        GiftDataStorageService r10 = (GiftDataStorageService) r9;
        if (r10 == null) goto L51;
        if (r39.i().l <= 0) goto L45;
        int r11 = r39.a().b;
        h2 r13 = r39.a().a;
        if (r13 == null) goto L29;
        int r14 = r13.getDiamondCount();
    L30:
        int r15 = r11 * r14;
        int r16 = r39.a().b;
        i12.e r17 = i12.o.b();
        if (r17 == null) goto L33;
        Object r18 = com.bytedance.android.scope.m.e.d(r17, GiftExtraRepo.class);
    L34:
        GiftExtraRepo r19 = (GiftExtraRepo) r18;
        if (r19 == null) goto L39;
        l1 r20 = r19.o(r39.i().l, r39.i().b);
        if (r20 == null) goto L39;
        long r21 = r20.getBuffGiftId();
    L40:
        h2 r23 = GiftManagerKt.l(r21);
        if (r23 == null) goto L43;
        int r24 = r23.getDiamondCount();
    L44:
        int r25 = r15 + (r16 * r24);
    L50:
        r10.a += r25;
        Unit r26 = Unit.INSTANCE;
        goto L51
    L43:
        r24 = 0;
    L39:
        r21 = 0;
        goto L40
    L33:
        r18 = null;
        goto L34
    L29:
        r14 = 0;
        goto L30
    L45:
        int r27 = r39.a().b;
        h2 r28 = r39.a().a;
        if (r28 == null) goto L48;
        int r29 = r28.getDiamondCount();
    L49:
        r25 = r27 * r29;
        goto L50
    L48:
        r29 = 0;
        goto L49
    L21:
        r9 = null;
        goto L22
    L14:
        r5 = null;
    L51:
        h2 r30 = GiftManagerKt.l(r39.i().b);
        if (r30 == null) goto L54;
        int r31 = r30.getDiamondCount();
    L55:
        if (r40 != null) goto L57;
        return;
    L57:
        if (r39.i().v == false) goto L59;
        int r33 = r40.getMultiSendSuccessCount();
    L60:
        ArrayList<e3> r110 = r39.i().n;
        i12.e r34 = i12.o.b();
        if (r34 == null) goto L63;
        Object r35 = com.bytedance.android.scope.m.e.d(r34, GiftExtraRepo.class);
    L64:
        GiftExtraRepo r36 = (GiftExtraRepo) r35;
        if (r36 == null) goto L69;
        g0 r37 = r36.q(r40.getGiftId());
        if (r37 == null) goto L69;
        com.bytedance.android.livesdk.gift.model.p r38 = r37.getDiyGiftToolbarInfo();
    L71:
        if (r38 == null) goto L144;
        if (r110 == null) goto L144;
        if ((!r110.isEmpty()) == false) goto L144;
        ArrayList r44 = new ArrayList();
        Iterator<e3> r45 = r110.iterator();
    L77:
        if (r45.hasNext() == false) goto L79;
        r44.add(Integer.valueOf((int) r45.next().getPluginId()));
        goto L77
    L79:
        i12.e r46 = i12.o.b();
        if (r46 == null) goto L82;
        Object r47 = com.bytedance.android.scope.m.e.d(r46, GiftExtraRepo.class);
    L83:
        GiftExtraRepo r48 = (GiftExtraRepo) r47;
        if (r48 == null) goto L86;
        long r49 = r48.y(r39.i().b, r31, r110);
    L87:
        long r50 = r49 - ((long) r31);
        if (r50 < 0) goto L91;
        r4 = r50;
    L91:
        String r51 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        long r53 = r39.i().b;
        int r111 = r39.a().b / (r39.i().q * r33);
        int r112 = r39.i().q;
        if (r39.i().c != SendGiftSource.JsbPage) goto L94;
        r3 = true;
    L94:
        Intrinsics.checkNotNullParameter(r44, "customizeItem");
        LinkedHashMap r113 = new LinkedHashMap();
        yz0.k r114 = com.bytedance.android.livesdk.gift.platform.core.utils.h.g();
        if (r114 == null) goto L97;
        IRoom r115 = r114.getRoom();
    L98:
        if (r115 == null) goto L103;
        String r116 = r115.getAnchorId();
        if (r116 != null) goto L102;
        r116 = BuildConfig.FLAVOR;
    L102:
        r113.put("anchor_id", r116);
        r113.put("room_id", String.valueOf(r115.getRoomId()));
    L103:
        r113.put("user_id", com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId());
        r113.put("gift_id", String.valueOf(r53));
        r113.put("customize_item", r44.toString());
        r113.put("customize_price", String.valueOf(r4));
        r113.put("combo_cnt", String.valueOf(r111));
        r113.put("group_cnt", String.valueOf(r112));
        r113.put("count", String.valueOf(r111 * r112));
        r113.put("money", String.valueOf((((long) r111) * r4) * ((long) r112)));
        if (r3 == false) goto L106;
        String r54 = "customize_page";
    L107:
        r113.put("click_entrance", r54);
        String r55 = "null";
        if (r3 == false) goto L110;
        r113.put("chosen_type", "null");
    L143:
        mz0.n r56 = new mz0.n();
        Map r57 = r56.a;
        Intrinsics.checkNotNullParameter(r57, "map");
        Intrinsics.checkNotNullParameter(r113, "map");
        r57.putAll(r113);
        mz0.m r58 = new mz0.m();
        r58.b(LogCommon.ROOM);
        r58.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r56.b).addAll(r58.a);
        cy0.e.a.getClass();
        cy0.j r59 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r60 = com.bytedance.android.scope.m.b(r59).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r60);
        ((f80.a) r60).w3("send_customize_item", r56.a, r56.b);
        goto L144
    L110:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L112;
        GiftContext r61 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r61 == null) goto L140;
        com.bytedance.live.datacontext.m<DIYCardSelectType> r63 = r61.getCustomizeBuffSelectType();
        if (r63 == null) goto L140;
        DIYCardSelectType r64 = (DIYCardSelectType) r63.getValue();
        if (r64 == null) goto L140;
        Integer r65 = Integer.valueOf(r64.ordinal());
    L141:
        r113.put("chosen_type", String.valueOf(r65));
    L140:
        r65 = null;
        goto L141
    L112:
        if (nz1.a.h().d() == false) goto L122;
        i12.e r66 = i12.o.b();
        if (r66 == null) goto L116;
        Object r67 = com.bytedance.android.scope.m.e.d(r66, g1.class);
    L117:
        g1 r68 = (g1) r67;
        if (r68 == null) goto L143;
        Map<String, String> r69 = r68.b;
        if (r69 == null) goto L143;
        r113.putAll(r69);
        goto L143
    L116:
        r67 = null;
        goto L117
    L122:
        i12.e r70 = i12.o.b();
        if (r70 == null) goto L125;
        Object r71 = com.bytedance.android.scope.m.e.d(r70, g1.class);
    L126:
        g1 r73 = (g1) r71;
        if (r73 == null) goto L143;
        Intrinsics.checkNotNullParameter(r113, "$this$addDIYCardSelectType");
        String r74 = (String) ((LinkedHashMap) r73.a).get("diy_card_chosen_type");
        if (r74 == null) goto L132;
        r55 = r74;
    L132:
        r113.put("chosen_type", r55);
        goto L143
    L125:
        r71 = null;
        goto L126
    L106:
        r54 = "gift_tab";
        goto L107
    L97:
        r115 = null;
        goto L98
    L86:
        r49 = 0;
        goto L87
    L82:
        r47 = null;
    L144:
        long r310 = r4;
        List<k3> r75 = r39.i().z;
        String r76 = r39.i().B;
        if (r76 != null) goto L158;
        i12.e r77 = i12.o.b();
        if (r77 == null) goto L149;
        Object r78 = com.bytedance.android.scope.m.e.d(r77, GiftExtraRepo.class);
    L150:
        GiftExtraRepo r79 = (GiftExtraRepo) r78;
        if (r79 == null) goto L157;
        g0 r80 = r79.q(r40.getGiftId());
        if (r80 == null) goto L157;
        l3 r81 = r80.getSeriesGift();
        if (r81 == null) goto L157;
        r76 = r81.getName();
    L157:
        String r311 = null;
    L159:
        if (r75 != null) goto L161;
    L175:
        String r83 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        int r117 = r31;
        String r210 = r311;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.P(r39.i(), r39.i().g(), r39.i().H, r39.a().b / (r39.i().q * r33), r39.i().q, r40, r39.i().m, r1, r39.a().c, 0, r39.i().o, r117, r310, r39.e(), null, r39.i().A, r210, r39.i().R, r39.b(), r39.i().T, r39.i().U, r39.i().Z, r39.i().F, r39.i().a0, 33792);
    L176:
        i12.e r84 = i12.o.b();
        if (r84 == null) goto L179;
        Object r85 = com.bytedance.android.scope.m.e.d(r84, GiftExtraRepo.class);
    L180:
        GiftExtraRepo r86 = (GiftExtraRepo) r85;
        if (r86 == null) goto L185;
        l1 r87 = r86.o(r39.i().l, r39.i().b);
        if (r87 == null) goto L185;
        Long r88 = Long.valueOf(r87.getBuffGiftId());
    L187:
        if (r39.i().l <= 0) goto L197;
        if (r88 == null) goto L197;
        h2 r89 = GiftManagerKt.l(r88.longValue());
        if (r89 == null) goto L195;
        String r90 = r89.getSortExtra();
        if (r90 == null) goto L195;
        String r211 = r90;
    L196:
        String r91 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.P(b0.b(r39.i(), r88.longValue(), null, 0, null, null, null, null, null, null, 0, 0, null, null, -1026, 8388607), r39.i().g(), r39.i().H, r39.a().b / r39.i().q, r39.i().q, r40, com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL, r1, r39.a().c, r39.i().l, false, 0, 0, r39.e(), null, null, null, r39.i().R, r39.b(), r211, r39.i().U, r39.i().Z, r39.i().F, r39.i().a0, 243712);
    L195:
        r211 = BuildConfig.FLAVOR;
    L197:
        i12.e r93 = i12.o.b();
        if (r93 == null) goto L200;
        Object r94 = com.bytedance.android.scope.m.e.d(r93, GiftExtraRepo.class);
    L201:
        GiftExtraRepo r95 = (GiftExtraRepo) r94;
        if (r95 == null) goto L204;
        Long r96 = r95.s(r39.i().b);
    L205:
        if (r96 == null) goto L211;
        String r97 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        b0 r98 = b0.b(r39.i(), r96.longValue(), null, 0, null, null, null, null, null, null, 0, 0, null, null, -1026, 8388607);
        String r99 = r39.i().g();
        IRoom r100 = r39.i().H;
        long r101 = r39.a().b / (r39.i().q * r33);
        long r102 = r39.i().q;
        String r118 = r39.i().m;
        DataCenter r119 = r39.a().c;
        boolean r120 = r39.e();
        boolean r212 = r39.b();
        String r121 = r39.i().R;
        h2 r103 = GiftManagerKt.l(r96.longValue());
        if (r103 == null) goto L209;
        String r213 = r103.getSortExtra();
    L210:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.P(r98, r99, r100, r101, r102, r40, r118, r1, r119, 0, false, 0, 0, r120, null, null, null, r121, r212, r213, r39.i().U, r39.i().Z, r39.i().F, r39.i().a0, 244736);
        goto L211
    L209:
        r213 = null;
    L211:
        Unit r104 = Unit.INSTANCE;
        return;
    L204:
        r96 = null;
        goto L205
    L200:
        r94 = null;
    L185:
        r88 = null;
        goto L187
    L179:
        r85 = null;
        goto L180
    L161:
        if ((!r75.isEmpty()) != true) goto L175;
        Iterator<k3> r312 = r75.iterator();
    L164:
        if (r312.hasNext() == false) goto L176;
        k3 r214 = r312.next();
        if (r214.getGiftId() != r39.i().b) goto L169;
        String r105 = r39.i().T;
    L168:
        String r215 = r105;
    L174:
        String r106 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        int r122 = r31;
        String r216 = r311;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.P(r39.i(), r39.i().g(), r39.i().H, r39.a().b / (r39.i().q * r33), r39.i().q, r40, r39.i().m, r1, r39.a().c, 0, r39.i().o, r122, r310, r39.e(), r214, r39.i().A, r216, r39.i().R, r39.b(), r215, r39.i().U, r39.i().Z, r39.i().F, r39.i().a0, 1024);
        goto L164
    L169:
        h2 r107 = GiftManagerKt.l(r214.getGiftId());
        if (r107 == null) goto L173;
        r105 = r107.getSortExtra();
        if (r105 != null) goto L168;
    L173:
        r215 = BuildConfig.FLAVOR;
        goto L174
    L149:
        r78 = null;
    L158:
        r311 = r76;
    L69:
        r38 = null;
        goto L71
    L63:
        r35 = null;
        goto L64
    L59:
        r33 = 1;
        goto L60
    L54:
        r31 = 0;
        goto L55
    }
}
