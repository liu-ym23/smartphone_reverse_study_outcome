package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements o {
    public final String a;
    public final String b;
    public final int c;
    public final yz0.k d;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public n(yz0.k r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.d = r2;
        this.a = "livesdk_gift_transaction_param_error";
        this.b = "ttlive_gift_transaction_param_error";
        this.c = 1;
    }

    public final void a(String r24, long r25, SendGiftSource r27, Object r28) {
        Intrinsics.checkNotNullParameter(r24, "errorParam");
        Intrinsics.checkNotNullParameter(r27, "sendGiftFrom");
        Intrinsics.checkNotNullParameter(r28, "problemInfo");
        long r5 = this.d.getRoom().getId();
        String r2 = this.d.getUser().getIdString();
        if (v.a() == false) goto L5;
        f2.c("GiftTransaction param error: ".concat(r24), 0);
    L5:
        String r7 = this.a;
        mz0.n r8 = new mz0.n();
        mz0.o r9 = new mz0.o(r8.a);
        r9.a("error_param", r24);
        r9.a("room_id", String.valueOf(r5));
        r9.a("user_id", r2);
        r9.a("gift_id", String.valueOf(r25));
        r9.a("send_gift_source", r27.getSourceName());
        r9.a(r24, r28.toString());
        cy0.e.a.getClass();
        cy0.j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r3 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r3);
        ((f80.a) r3).w3(r7, r8.a, r8.b);
        String r4 = this.b;
        JSONObject r11 = new JSONObject();
        JSONObject r13 = new JSONObject();
        JSONObject r14 = new JSONObject();
        Intrinsics.checkNotNullParameter(r14, "extra");
        Intrinsics.checkNotNullParameter(r13, "metric");
        EventModule r6 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r6, "eventModule");
        String r18 = r6.getValue();
        r13.put("status", String.valueOf(this.c));
        Intrinsics.checkNotNullParameter(r11, "map");
        Intrinsics.checkNotNullParameter("error_param", "key");
        Intrinsics.checkNotNullParameter(r24, "value");
        r11.put("error_param", r24);
        Intrinsics.checkNotNullParameter(r14, "map");
        Long r15 = Long.valueOf(r5);
        Intrinsics.checkNotNullParameter("room_id", "key");
        Intrinsics.checkNotNullParameter(r15, "value");
        r14.put("room_id", r15);
        Intrinsics.checkNotNullParameter("user_id", "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        r14.put("user_id", r2);
        String r16 = String.valueOf(r25);
        Intrinsics.checkNotNullParameter("gift_id", "key");
        Intrinsics.checkNotNullParameter(r16, "value");
        r14.put("gift_id", r16);
        String r17 = r27.getSourceName();
        Intrinsics.checkNotNullParameter("send_gift_source", "key");
        Intrinsics.checkNotNullParameter(r17, "value");
        r14.put("send_gift_source", r17);
        String r19 = r28.toString();
        Intrinsics.checkNotNullParameter(r24, "key");
        Intrinsics.checkNotNullParameter(r19, "value");
        r14.put(r24, r19);
        Object r0 = com.bytedance.android.scope.m.b(r10).b(n97.a.class);
        Intrinsics.checkNotNull(r0);
        ((com.bytedance.live.kmp.core.c) r0).g(r4, r18, "bussiness_api_call", r11, r13, r14);
    }
}
