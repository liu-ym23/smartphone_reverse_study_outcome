package x02;

import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.util.GiftToRechargeParamsKey;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.utils.r2;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zg1.x2;
import zg1.y2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s extends d0 {
    public s() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final y a(com.bytedance.android.livesdk.gift.platform.core.model.t r27, y r28, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r29, Function1<? super y, Unit> r30) {
        Intrinsics.checkNotNullParameter(r27, "info");
        Intrinsics.checkNotNullParameter(r28, "response");
        Intrinsics.checkNotNullParameter(r29, "listener");
        Intrinsics.checkNotNullParameter(r30, "nextPlugin");
        if ((r28 instanceof y.c.a.g) == false) goto L88;
        h2 r1 = r27.a().a;
        if (r1 == null) goto L7;
        b0 r3 = r27.i();
        int r4 = r3.l;
        i12.e r5 = i12.o.b();
        if (r5 == null) goto L11;
        Object r6 = com.bytedance.android.scope.m.e.d(r5, GiftExtraRepo.class);
    L12:
        GiftExtraRepo r7 = (GiftExtraRepo) r6;
        if (r7 == null) goto L17;
        l1 r8 = r7.o(r4, r3.b);
        if (r8 == null) goto L17;
        long r9 = r8.getBuffDiamondCount();
    L18:
        h2 r10 = r27.a().a;
        if (r10 == null) goto L21;
        long r11 = r10.getDiamondCount();
    L22:
        i12.e r13 = i12.o.b();
        if (r13 == null) goto L25;
        Object r14 = com.bytedance.android.scope.m.e.d(r13, GiftExtraRepo.class);
    L26:
        GiftExtraRepo r15 = (GiftExtraRepo) r14;
        if (r15 == null) goto L29;
        long r16 = r15.y(r3.b, r11, r3.n);
    L31:
        if (r16 > 0) goto L35;
        r16 = r11 + r9;
    L35:
        if (r27.i().c != SendGiftSource.GiftDialog) goto L37;
        boolean r17 = true;
    L39:
        if (l0.d(r1) == true) goto L41;
    L43:
        int r18 = r27.i().q;
    L44:
        b0 r2 = r27.i();
        int r19 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f();
        long r20 = r1.getId();
        int r21 = r2.f;
        Map<String, String> r110 = r2.Y;
        if (r21 != 3) goto L47;
        String r23 = "continuity_no_balance";
    L48:
        String r111 = r23;
        long r24 = jc1.k.n(IRechargeService.class).rechargeCenter().getAvailableDiamonds();
        if (r18 <= 1) goto L51;
        long r112 = (((long) r18) * r16) - r24;
    L52:
        if (r110 == null) goto L54;
        String r25 = r110.get(GiftToRechargeParamsKey.KEY_SEND_GIFT_CHARGE_REASON.getKeyName());
    L56:
        if (r2.a(r25) == false) goto L59;
        Intrinsics.checkNotNull(r25);
        String r0 = r25;
    L68:
        ToastUtil.a(2131922445, 0);
        long r26 = ((long) r18) * r16;
        if (r18 <= 1) goto L71;
        String r31 = "bunching_gift";
    L73:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L85;
        boolean r210 = r17;
        i12.e r33 = i12.o.b();
        if (r33 == null) goto L77;
        Object r34 = com.bytedance.android.scope.m.e.d(r33, OpenDialogService.class);
    L78:
        OpenDialogService r35 = (OpenDialogService) r34;
        if (r35 == null) goto L86;
        x2.a r36 = new x2.a();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        ((y2) r36).c = r0;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        ((y2) r36).d = r111;
        ((y2) r36).f = r20;
        ((y2) r36).g = r16;
        ((y2) r36).h = r18;
        ((y2) r36).i = r26;
        ((y2) r36).e = r112;
        Intrinsics.checkNotNullParameter(r31, "<set-?>");
        ((y2) r36).j = r31;
        ((y2) r36).k = r24;
        ((y2) r36).l = false;
        if (r110 != 0) goto L83;
        Map<String, String> r113 = MapsKt.emptyMap();
    L84:
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        ((y2) r36).m = r113;
        Unit r37 = Unit.INSTANCE;
        r35.i(r36.a(), r210, false, r2);
        goto L86
    L83:
        r113 = r110;
    L86:
        y.c.a.g r38 = (y.c.a.g) r28;
        r38.getClass();
        return new y.c.a.C0067a(r38.d, true, r38.c);
    L77:
        r34 = null;
        goto L78
    L85:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.m(new x2(r0, r111, r20, r16, r26, r112, r31), r17));
        goto L86
    L71:
        r31 = "single_gift";
        goto L73
    L59:
        if (r19 != 1) goto L61;
        r0 = "gift";
        goto L68
    L61:
        if (r19 != 2) goto L63;
        r0 = "fans_club_gift";
        goto L68
    L63:
        if (r19 == 3) goto L65;
        r0 = "gift_page_" + r19;
        goto L68
    L65:
        r0 = "honor_level_gift";
        goto L68
    L54:
        r25 = null;
        goto L56
    L51:
        r112 = r16 - r24;
        goto L52
    L47:
        r23 = "gift_no_balance";
        goto L48
    L41:
        if (r27.i().q != 1) goto L43;
        r18 = ((y.c.a.g) r28).f;
        goto L44
    L37:
        r17 = false;
        goto L39
    L29:
        r16 = 0;
        goto L31
    L25:
        r14 = null;
        goto L26
    L21:
        r11 = 0;
    L17:
        r9 = 0;
        goto L18
    L11:
        r6 = null;
        goto L12
    L7:
        return y.d.c;
    L88:
        return r28;
    }
}
