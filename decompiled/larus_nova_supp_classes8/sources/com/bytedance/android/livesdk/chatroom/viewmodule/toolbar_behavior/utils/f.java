package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.h4;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ DataCenter a;

    public f(DataCenter r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        SubscriberJsEvent r11 = (SubscriberJsEvent) r10;
        if (TextUtils.equals(r11.getEventName(), "onLiveIntroduceTicketChosen") == false) goto L66;
        Map r0 = r11.getParams();
        String r1 = null;
        if (r0 == null) goto L9;
        Object r2 = r0.get("ticket_id");
        if (r2 == null) goto L9;
        String r3 = r2.toString();
    L10:
        Map r4 = r11.getParams();
        if (r4 == null) goto L15;
        Object r5 = r4.get("action");
        if (r5 == null) goto L15;
        String r6 = r5.toString();
    L16:
        ALogger.i("PaidLiveTicketSaleHelper", "receive event onLiveIntroduceTicketChosen,ticket_id=" + r3 + ", action=" + r6);
        DataCenter r7 = this.a;
        if (r7 == null) goto L25;
        Map r12 = r11.getParams();
        if (r12 == null) goto L23;
        Object r13 = r12.get("owner_id");
        if (r13 == null) goto L23;
        String r14 = r13.toString();
    L24:
        r7.put("data_paid_live_sell_ticket_owner_id", r14);
    L23:
        r14 = null;
    L25:
        long r8 = 0;
        if (TextUtils.equals(r6, "add") == false) goto L48;
        if (TextUtils.isEmpty(r3) == true) goto L48;
        DataCenter r15 = this.a;
        if (r15 == null) goto L32;
        String r16 = (String) r15.get("data_paid_live_sell_ticket_id", "");
    L34:
        if (TextUtils.isEmpty(r16) == true) goto L41;
        DataCenter r17 = this.a;
        if (r17 == null) goto L38;
        String r18 = (String) r17.get("data_paid_live_sell_ticket_id", "");
    L40:
        if (TextUtils.equals(r3, r18) == true) goto L48;
    L38:
        r18 = null;
    L41:
        e.a r19 = e.b;
        if (r19 == null) goto L48;
        if (r3 == null) goto L45;
        long r9 = CastLongProtector.parseLong(r3);
    L46:
        Long r20 = Long.valueOf(r9);
        int r21 = h4.j;
        r19.a(r20, 1);
        goto L48
    L45:
        r9 = 0;
        goto L46
    L32:
        r16 = null;
    L48:
        if (TextUtils.equals(r6, "remove") == false) goto L67;
        DataCenter r110 = this.a;
        if (r110 == null) goto L52;
        String r111 = (String) r110.get("data_paid_live_sell_ticket_id", "");
    L54:
        if (TextUtils.isEmpty(r111) == true) goto L68;
        DataCenter r112 = this.a;
        if (r112 == null) goto L59;
        r1 = (String) r112.get("data_paid_live_sell_ticket_id", "");
    L59:
        if (TextUtils.equals(r3, r1) == false) goto L69;
        e.a r113 = e.b;
        if (r113 == null) goto L70;
        if (r3 == null) goto L64;
        r8 = CastLongProtector.parseLong(r3);
    L64:
        Long r22 = Long.valueOf(r8);
        int r23 = h4.j;
        r113.a(r22, 0);
        return;
    L70:
        return;
    L69:
        return;
    L68:
        return;
    L52:
        r111 = null;
        goto L54
    L67:
        return;
    L15:
        r6 = null;
    L9:
        r3 = null;
        goto L10
    }
}
