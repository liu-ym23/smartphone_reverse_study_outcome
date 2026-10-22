package jw0;

import am2.x;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Throwable r5) {
        HashMap r0 = new HashMap();
        k r1 = (k) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), k.class);
        String r2 = "";
        if (r1 == null) goto L7;
        IRoom r3 = r1.getRoom();
        if (r3 == null) goto L7;
        Object r4 = Long.valueOf(r3.getRoomId());
    L8:
        r0.put("room_id", r4);
        if (r1 == null) goto L16;
        IRoom r6 = r1.getRoom();
        if (r6 == null) goto L16;
        String r7 = r6.getOwnerUserIdString();
        if (r7 == null) goto L16;
        r2 = r7;
    L16:
        r0.put("anchor_id", r2);
        if (r5 != null) goto L19;
    L21:
        LiveSlardarMonitor.monitorStatus("ttlive_income_exchange_error", 12, r0);
        int r8 = v.a;
        JSONObject r9 = new JSONObject();
        Iterator r10 = r0.entrySet().iterator();
    L23:
        if (r10.hasNext() == false) goto L28;
        Map.Entry r12 = (Map.Entry) r10.next();     // Catch: Exception -> L26
        r9.put((String) r12.getKey(), r12.getValue());     // Catch: Exception -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L28:
        v.b("ttlive_exchange", String.valueOf(r9), null);
        return;
    L19:
        if ((r5 instanceof ApiException) == false) goto L21;
        r0.put("error_code", String.valueOf(((ApiException) r5).getErrorCode()));
        r0.put("error_message", String.valueOf(r5.getMessage()));
    L7:
        r4 = "";
        goto L8
    }

    public static void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "clickType");
        HashMap r0 = new HashMap();
        r0.put("click_type", r3);
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r4 = com.bytedance.android.live.recharge.utils.f.a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_auto_exchange_click", r0, new Class[]{IRoom.class, x.class});
    }

    public static void e(String r2, Long r3) {
        HashMap r0 = new HashMap();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.put("request_page", r2);
        r0.put("charge_reason", "exchange_diamond");
        r0.put("money", String.valueOf(r3));
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r4 = com.bytedance.android.live.recharge.utils.f.a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_recharge_success", r0, new Class[]{IRoom.class, x.class});
    }

    public static void c(long r2, long r4, int r6, int r7, Boolean r8) {
        HashMap r0 = new HashMap();
        r0.put("exchange_reason", String.valueOf(r6));
        r0.put("exchange_gift_confirm", String.valueOf(r7));
        r0.put("money_paid", String.valueOf(r2));
        r0.put("money_exchanged", String.valueOf(r4));
        r0.put("remind", String.valueOf(r8));
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r3 = com.bytedance.android.live.recharge.utils.f.a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_exchange_paypopup_click", r0, new Class[]{IRoom.class, x.class});
    }

    public static void d(long r2, long r4, int r6, Boolean r7, Integer r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "clickArea");
        HashMap r0 = new HashMap();
        r0.put("exchange_gift_confirm", String.valueOf(r6));
        r0.put("money_paid", String.valueOf(r2));
        r0.put("money_exchanged", String.valueOf(r4));
        r0.put("given_coins", String.valueOf(r8));
        r0.put("click_area", r9);
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L5;
        String r3 = DataType.TRUE;
    L7:
        if (com.bytedance.android.live.recharge.utils.e.c() == false) goto L9;
        r0.put("is_close_notice", r3);
    L10:
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r5 = com.bytedance.android.live.recharge.utils.f.a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_exchange_paypopup_click", r0, new Class[]{IRoom.class, x.class, hx0.b.class});
        return;
    L9:
        r0.put("is_auto_exchange", r3);
        goto L10
    L5:
        r3 = DataType.FALSE;
        goto L7
    }
}
