package ew0;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.s;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final void a(com.bytedance.android.live.recharge.model.d r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r7, "$this$provideEventProperties");
        Intrinsics.checkNotNullParameter(r8, "map");
        r8.put("request_page", r7.c);
        r8.put("charge_scene", r7.h);
        r8.put("charge_reason", r7.b);
        String r0 = r7.l;
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r8.put("promotion_source", r0);
        r8.put("recharge_show_type", r7.i);
        String r2 = r7.n;
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r8.put("session_id", r2);
        String r3 = r7.n;
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        r8.put("recharge_session_id", r3);
        com.bytedance.android.live.recharge.model.b r4 = r7.j;
        String r5 = null;
        if (r4 == null) goto L19;
        com.bytedance.android.live.recharge.model.a r6 = r4.g;
        if (r6 == null) goto L19;
        s r9 = r6.b;
        KProperty r10 = com.bytedance.android.live.recharge.model.a.d[2];
        r9.getClass();
        Intrinsics.checkNotNullParameter(r6, "thisRef");
        Intrinsics.checkNotNullParameter(r10, "property");
        Object r12 = r6.get(r9.a);
        if (r12 != null) goto L18;
        r12 = r9.b.invoke();
    L18:
        String r13 = (String) r12;
    L20:
        if (r13 != null) goto L22;
        r13 = "";
    L22:
        r8.put("gift_panel_session_id", r13);
        com.bytedance.android.live.recharge.model.f r14 = r7.k;
        if (r14 != null) goto L25;
    L29:
        String r15 = DataType.FALSE;
    L30:
        r8.put("is_vipopen_package", r15);
        r8.put("money_diff", String.valueOf(r7.d));
        r8.put("rd_recharge_scene", "live_room_recharge");
        com.bytedance.android.live.recharge.model.b r16 = r7.j;
        if (r16 == null) goto L33;
        Long r17 = Long.valueOf(r16.e);
    L34:
        r8.put("previous_gift_id", String.valueOf(r17));
        com.bytedance.android.live.recharge.model.b r18 = r7.j;
        if (r18 == null) goto L37;
        Long r19 = Long.valueOf(r18.d);
    L38:
        r8.put("previous_gift_money", String.valueOf(r19));
        com.bytedance.android.live.recharge.model.b r20 = r7.j;
        if (r20 == null) goto L41;
        Long r22 = Long.valueOf(r20.c);
    L42:
        r8.put("previous_pay_money", String.valueOf(r22));
        com.bytedance.android.live.recharge.model.b r23 = r7.j;
        if (r23 == null) goto L45;
        r5 = r23.b;
    L45:
        r8.put("previous_gift_type", String.valueOf(r5));
        com.bytedance.android.live.recharge.model.b r24 = r7.j;
        if (r24 == null) goto L51;
        String r25 = r24.a;
        if (r25 == null) goto L51;
        r1 = r25;
    L51:
        r8.put("gift_dialog_request_id", r1);
        return;
    L41:
        r22 = null;
        goto L42
    L37:
        r19 = null;
        goto L38
    L33:
        r17 = null;
        goto L34
    L25:
        if (r14.c != 1) goto L29;
        if (r7.d == 0) goto L29;
        r15 = DataType.TRUE;
    L19:
        r13 = null;
        goto L20
    }
}
