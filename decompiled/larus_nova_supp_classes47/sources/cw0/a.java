package cw0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.deal.m;
import com.bytedance.android.live.recharge.model.d;
import com.bytedance.android.live.recharge.utils.k;
import com.bytedance.android.live.recharge.utils.n;
import com.bytedance.android.live.revenue.common.s;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import yz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final void a(m r17, d r18) {
        m r0 = r17;
        Intrinsics.checkNotNullParameter(r0, "$this$appendFromEntranceParams");
        Intrinsics.checkNotNullParameter(r18, "entranceParams");
        ((HashMap) r0.a).put("coupon_v2_id", r18.o);
        JSONObject r3 = new JSONObject();
        g r5 = (g) f.d(j.C0.a(), g.class);     // Catch: Throwable -> L51
        if (r5 != null) goto L71;
        IRoomBase r6 = null;
    L10:
        if ((r6 instanceof IRoom) == true) goto L12;
        r6 = null;
    L12:
        IRoom r7 = (IRoom) r6;     // Catch: Throwable -> L51
        com.bytedance.android.live.recharge.model.b r8 = r18.j;     // Catch: Throwable -> L51
        long r9 = 0;
        if (r8 == null) goto L16;
        long r10 = r8.e;     // Catch: Throwable -> L7
    L17:
        if (r8 == null) goto L19;
        long r12 = r8.d;     // Catch: Throwable -> L7
    L20:
        if (r8 == null) goto L23;
        String r13 = r8.b;     // Catch: Throwable -> L7
        if (r13 == null) goto L23;
    L24:
        if (r8 == null) goto L28;
        r9 = r8.c;     // Catch: Throwable -> L7
    L27:
        String r16 = "";
    L53:
        ((HashMap) r0.a).put("marketing_rank_ctx", r3.toString());
        ((HashMap) r0.b).put("biz_scene", String.valueOf(com.bytedance.android.live.recharge.panel.b.a(r18).getScene()));
        Map<String, Object> r1 = r0.b;
        String r4 = r18.n;
        if (r4 != null) goto L56;
        r4 = r16;
    L56:
        ((HashMap) r1).put("recharge_session_id", r4);
        Map<String, Object> r2 = r0.b;
        com.bytedance.android.live.recharge.model.b r14 = r18.j;
        if (r14 == null) goto L64;
        com.bytedance.android.live.recharge.model.a r15 = r14.g;
        if (r15 == null) goto L64;
        s r19 = r15.b;
        KProperty r20 = com.bytedance.android.live.recharge.model.a.d[2];
        r19.getClass();
        Intrinsics.checkNotNullParameter(r15, "thisRef");
        Intrinsics.checkNotNullParameter(r20, "property");
        Object r22 = r15.get(r19.a);
        if (r22 != null) goto L63;
        r22 = r19.b.invoke();
    L63:
        String r23 = (String) r22;
    L65:
        if (r23 != null) goto L67;
        String r24 = r16;
    L68:
        ((HashMap) r2).put("gift_panel_session_id", r24);
        return;
    L67:
        r24 = r23;
    L64:
        r23 = null;
    L28:
        long r110 = r18.d;     // Catch: Throwable -> L51
        String r25 = r18.b;     // Catch: Throwable -> L51
        String r26 = r18.h;     // Catch: Throwable -> L51
        r16 = "";
        if (r7 != null) goto L73;
    L37:
        String r27 = DataType.FALSE;
    L38:
        r3.put("is_fans", r27);     // Catch: Throwable -> L70
        if (r7 == null) goto L43;
        IBaseUser r28 = r7.getOwnerKt();     // Catch: Throwable -> L70
        if (r28 == null) goto L43;
        String r29 = r28.getIdString();     // Catch: Throwable -> L70
    L44:
        r3.put("anchor_id", String.valueOf(r29));     // Catch: Throwable -> L70
        if (r7 == null) goto L47;
        String r30 = r7.getIdStr();     // Catch: Throwable -> L70
    L48:
        r3.put("room_id", r30);     // Catch: Throwable -> L70
        r3.put("previous_gift_id", String.valueOf(r10));     // Catch: Throwable -> L70
        r3.put("previous_gift_money", String.valueOf(r12));     // Catch: Throwable -> L70
        r3.put("previous_gift_type", r13);     // Catch: Throwable -> L70
        r3.put("previous_pay_money", String.valueOf(r9));     // Catch: Throwable -> L70
        r3.put("money_diff", String.valueOf(r110));     // Catch: Throwable -> L70
        r3.put("charge_reason", r25);     // Catch: Throwable -> L70
        r3.put("charge_scene", r26);     // Catch: Throwable -> L70
        int r32 = k.a;     // Catch: Throwable -> L70
        r3.put("live_type", n.a());     // Catch: Throwable -> L70
    L52:
        r0 = r17;
        goto L53
    L47:
        r30 = null;
    L43:
        r29 = null;
        goto L44
    L73:
        IBaseUser r33 = r7.getOwnerKt();     // Catch: Throwable -> L70
        if (r33 == null) goto L37;
        Intrinsics.checkNotNullParameter(r33, "$this$isFollowingExt");     // Catch: Throwable -> L70
        if (r33.isFollowing() != true) goto L37;
        r27 = DataType.TRUE;
    L23:
        r13 = "";
        goto L24
    L19:
        r12 = 0;
        goto L20
    L16:
        r10 = 0;
        goto L17
    L71:
        r6 = r5.mo444getRoom();     // Catch: Throwable -> L7
    L51:
        r16 = "";
        goto L52
    }
}
