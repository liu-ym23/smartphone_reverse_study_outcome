package com.bytedance.android.live.profit.livepet.container;

import android.graphics.RectF;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.p;
import com.bytedance.android.live.revenue.common.t0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.scope.o;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zg1.x2;
import zg1.y2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LivePetGiftInterceptor implements o {
    public u0 a;
    public final yz0.k b;
    public final e c;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final boolean a(long r18) {
        String r4 = "";
        qu0.b r0 = qu0.b.c;
        JsonObject r5 = r0.a().V().get("default");
        String r6 = null;
        if (r5 == null) goto L5;
        qu0.a.b r7 = new qu0.a.b(r5);
    L6:
        JsonObject r1 = r0.a().V().get(String.valueOf(r18));
        if (r1 == null) goto L9;
        qu0.a.b r8 = new qu0.a.b(r1);
    L10:
        if (r8 == null) goto L15;
        if (r7 != null) goto L14;
        r7 = r8;
        goto L15
    L14:
        r7 = new qu0.a.b(qu0.b.c(r7, r8));
    L15:
        StringBuilder r2 = new StringBuilder("gift config for <id: ");
        r2.append(r18);
        r2.append(">: ");
        if (r7 == null) goto L18;
        JsonObject r9 = r7.a;
    L19:
        r2.append(r9);
        jy0.b.a("LivePet/GiftInterceptor", r2.toString());
        if (r7 == null) goto L23;
        r6 = (String) r7.b.a(r7, qu0.a.b.d[0]);
    L23:
        if (r6 != null) goto L25;
    L30:
        boolean r10 = false;
    L31:
        jy0.b.d("LivePet/GiftInterceptor", "sendGift: giftId = " + r18 + ", intercept = " + r10 + ", scheme = " + r6);
        if (r6 != null) goto L34;
        return false;
    L34:
        if (r10 == true) goto L36;
    L75:
        return r10;
    L36:
        if (t0.a(new LivePetGiftInterceptor$interceptSendGift$1(this), new u0(1000)) == false) goto L75;
        if ((!Intrinsics.areEqual((Boolean) r7.c.a(r7, qu0.a.b.d[1]), Boolean.TRUE)) == false) goto L78;
        h1 r12 = com.bytedance.android.live.revenue.core.util.f.a(ca0.j.class).findGiftById(r18);
        if (r12 == null) goto L42;
        int r13 = r12.getDiamondCount();
    L43:
        IRechargeService r14 = (IRechargeService) jc1.k.f(IRechargeService.class);
        if (r14 == null) goto L48;
        zv0.f r15 = r14.rechargeCenter();
        if (r15 == null) goto L48;
        long r16 = r15.getAvailableDiamonds();
    L49:
        long r3 = r13;
        if (r16 < r3) goto L52;
        long r17 = 0;
    L54:
        if (r17 <= 0) goto L78;
        ToastUtil.a(2131922445, 0);
        x2.a r19 = new x2.a();
        ((y2) r19).a = 1;
        Intrinsics.checkNotNullParameter("live_detail", "<set-?>");
        ((y2) r19).b = "live_detail";
        ((y2) r19).e = r17;
        Intrinsics.checkNotNullParameter("gift", "<set-?>");
        ((y2) r19).c = "gift";
        Intrinsics.checkNotNullParameter("gift_no_balance", "<set-?>");
        ((y2) r19).d = "gift_no_balance";
        xs2.b.a().post(r19.a());
        return true;
    L52:
        jy0.b.d("LivePet/GiftInterceptor", "diamond balance is not enough: price = " + r13 + ", balance = " + r16);
        r17 = r3 - r16;
    L48:
        r16 = 0;
        goto L49
    L42:
        r13 = 0;
    L78:
        x0 r20 = new x0(r6);     // Catch: Throwable -> L67
        c(r18, r20, r7);     // Catch: Throwable -> L65
        boolean r22 = ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).Y(this.b.getContext(), r20.c());     // Catch: Throwable -> L65
        if (r22 == false) goto L62;
        String r23 = "";
    L63:
        com.bytedance.android.live.profit.livepet.utils.e.b(r18, r6, r22, r23);     // Catch: Throwable -> L65
        goto L75
    L62:
        r23 = "scheme not handled";
    L65:
        th = th;
    L69:
        jy0.b.b("LivePet/GiftInterceptor", "fail to open send gift scheme: ".concat(r6), th);
        String r24 = th.getMessage();
        if (r24 == null) goto L73;
        r4 = r24;
    L73:
        com.bytedance.android.live.profit.livepet.utils.e.b(r18, r6, false, r4);
        return false;
    L67:
        th = th;
        goto L69
    L25:
        if (r6.length() <= 0) goto L27;
        boolean r25 = true;
    L28:
        if (r25 == false) goto L30;
        r10 = true;
        goto L31
    L27:
        r25 = false;
        goto L28
    L18:
        r9 = null;
        goto L19
    L9:
        r8 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }

    public LivePetGiftInterceptor(yz0.k r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "layoutManager");
        this.b = r2;
        this.c = r3;
        this.a = u0.f;
    }

    public final void c(long r5, x0 r7, qu0.a.b r8) {
        x0 r9 = r7.d("url");
        LivePetGiftInterceptor$processSendGiftScheme$1 r0 = LivePetGiftInterceptor$processSendGiftScheme$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "factory");
        qu0.a.b r10 = (qu0.a.b) ((p) r0.invoke(r8.a.deepCopy()));
        r10.b.b(r10, qu0.a.b.d[0], null);
        Iterator r12 = r10.a.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) r12.next();
        String r2 = (String) r1.getKey();
        JsonElement r3 = (JsonElement) r1.getValue();
        Intrinsics.checkNotNullParameter(r3, "$this$convertToString");
        if ((r3 instanceof JsonNull) == false) goto L9;
        String r4 = null;
    L12:
        r9.b(r2, r4);
        goto L4
    L9:
        if ((r3 instanceof JsonPrimitive) == false) goto L11;
        r4 = r3.getAsString();
        goto L12
    L11:
        r4 = r3.toString();
        goto L12
    L13:
        r9.b("gift_id", String.valueOf(r5));
        RectF r6 = m.b(this.c.d);
        r9.b("content_x", String.valueOf(j80.a.a(r6.left, 6)));
        r9.b("content_y", String.valueOf(j80.a.a(r6.top, 6)));
        r9.b("content_width", String.valueOf(j80.a.a(r6.width(), 6)));
        r9.b("content_height", String.valueOf(j80.a.a(r6.height(), 6)));
    }
}
