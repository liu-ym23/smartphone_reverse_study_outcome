package x02;

import android.app.Activity;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.exchange.IAutoExchangeService;
import com.bytedance.android.live.recharge.model.ExchangeType;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.sendGift.sendStrategy.ExchangeDiamondPluginCustomResultCode;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends d0 {

    public static final class a implements zv0.e {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.model.t b;
        public final /* synthetic */ y c;

        /* JADX INFO: renamed from: x02.c$a$a, reason: collision with other inner class name */
        public static final class C0294a implements com.bytedance.android.livesdk.gift.platform.core.model.r {
            public final /* synthetic */ zv0.d a;

            @Override // com.bytedance.android.livesdk.gift.platform.core.model.r
            public final Map<String, String> a() {
                return MapsKt.emptyMap();
            }

            public C0294a(zv0.d r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.livesdk.gift.platform.core.model.r
            public final void b(com.bytedance.android.livesdk.gift.platform.core.model.t r3, y r4) {
                Intrinsics.checkNotNullParameter(r3, "info");
                Intrinsics.checkNotNullParameter(r4, "curResponse");
                if ((r4 instanceof y.d) == false) goto L8;
                ALogger.i("GiftTransaction", "ExchangeDiamondPlugin: send gift success");
                zv0.d r5 = this.a;
                if (r5 == null) goto L9;
                r5.a(r3.i().b);
                return;
            L9:
                return;
            }
        }

        public final void b() {
            ALogger.i("GiftTransaction", "ExchangeDiamondPlugin: onExchangeCancel");
            this.b.g(new d(ExchangeDiamondPluginCustomResultCode.ExchangeCancel));
            this.a.invoke(this.c);
        }

        public final void a(Throwable r3) {
            ALogger.i("GiftTransaction", "ExchangeDiamondPlugin: onExchangeError");
            if (r3 == null) goto L20;
            Intrinsics.checkNotNullParameter(r3, "throwable");
            if ((r3 instanceof ApiServerException) == false) goto L16;
            int r4 = ((ApiServerException) r3).getErrorCode();
            if (r4 != IAutoExchangeService.ExchangeRiskCode.ExchangeCodeNameCard.getValue()) goto L11;
        L15:
            boolean r5 = true;
        L17:
            if (r5 == true) goto L21;
            this.b.g(new d(ExchangeDiamondPluginCustomResultCode.ExchangeFailed));
            this.a.invoke(this.c);
            return;
        L21:
            return;
        L11:
            if (r4 == IAutoExchangeService.ExchangeRiskCode.ExchangeCodeRealName.getValue()) goto L15;
            if (r4 == IAutoExchangeService.ExchangeRiskCode.HotsoonExchangeExceeding.getValue()) goto L15;
        L16:
            r5 = false;
            goto L17
        }

        public final void c(zv0.d r3) {
            this.a.invoke(y.c.b.d);
            ALogger.i("GiftTransaction", "ExchangeDiamondPlugin: exchange success");
            this.b.h(new C0294a(r3));
            this.b.d(1);
            this.b.finish();
        }

        public a(Function1 r1, com.bytedance.android.livesdk.gift.platform.core.model.t r2, y r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public c() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final y a(com.bytedance.android.livesdk.gift.platform.core.model.t r21, y r23, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r24, Function1<? super y, Unit> r25) {
        Intrinsics.checkNotNullParameter(r21, "info");
        Intrinsics.checkNotNullParameter(r23, "response");
        Intrinsics.checkNotNullParameter(r24, "listener");
        Intrinsics.checkNotNullParameter(r25, "nextPlugin");
        if ((r23 instanceof y.c.a.g) == false) goto L26;
        h2 r3 = r21.a().a;
        if (r3 == null) goto L7;
        i12.e r4 = i12.o.b();
        if (r4 == null) goto L11;
        Object r5 = com.bytedance.android.scope.m.e.d(r4, GiftExtraRepo.class);
    L12:
        GiftExtraRepo r6 = (GiftExtraRepo) r5;
        if (r6 == null) goto L17;
        l1 r7 = r6.o(r21.i().l, r3.getId());
        if (r7 == null) goto L17;
        long r8 = r7.getBuffDiamondCount();
    L18:
        long r9 = ((long) r3.getDiamondCount()) + r8;
        int r10 = ((y.c.a.g) r23).f;
        long r11 = jc1.k.n(IRechargeService.class).rechargeCenter().getAvailableDiamonds();
        long r14 = r9 - r11;
        ALogger.i("ExchangeDiamondPlugin", "lackDiamond = " + r3.getDiamondCount() + " + " + r8 + " - " + r11 + " = " + r14);
        LinkedHashMap r13 = new LinkedHashMap();
        int r15 = com.bytedance.android.livesdk.gift.platform.business.sendGift.e.a;
        JSONObject r16 = com.bytedance.android.livesdk.gift.platform.business.sendGift.e.a(r21.i().H, r21.a().c, r21, r10);
        r13.put("gift_show_from", r16.optString("gift_show_from"));
        r13.put("gift_source", r16.optString("gift_source"));
        StringBuilder r17 = new StringBuilder("exchange diamond for send gift, params: ");
        r17.append(r16);
        ALogger.i("ExchangeDiamondPlugin", r17.toString());
        com.bytedance.android.live.incentive.exchange.c r18 = qa0.c.b.getService(com.bytedance.android.live.incentive.exchange.c.class);
        Intrinsics.checkNotNull(r18);
        com.bytedance.android.live.incentive.exchange.c r19 = r18;
        if (r19.d(r14) != true) goto L26;
        a r20 = new a(r25, r21, r23);
        Activity r110 = vh6.c.b(wh6.a.class).getTopActivity();
        if (r110 == null) goto L23;
        r19.g(new com.bytedance.android.live.incentive.exchange.l(r110, ExchangeType.EXCHANGE_TYPE_GIFT, r14, r20, r3.getImage(), r13, Long.valueOf(r3.getId())));
    L25:
        return y.b.c;
    L23:
        r20.b();
    L17:
        r8 = 0;
        goto L18
    L11:
        r5 = null;
        goto L12
    L7:
        return y.d.c;
    L26:
        return r23;
    }
}
