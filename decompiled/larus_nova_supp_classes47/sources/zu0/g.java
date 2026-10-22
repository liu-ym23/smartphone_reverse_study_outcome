package zu0;

import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.profit.profitCheck.jsbridge.ReportProfitCheckTaskDataResultModel;
import com.bytedance.android.live.revenue.common.q;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends b<h, ReportProfitCheckTaskDataResultModel> {
    public g() {
    }

    public final Map<String, Object> j(String r2) {
        Map<String, Object> r3 = MapsKt.toMutableMap(q.a(new JSONObject(r2)));     // Catch: Exception -> L4
        r3.remove("room_id");     // Catch: Exception -> L4
        r3.remove("roomId");     // Catch: Exception -> L4
        r3.remove("user_id");     // Catch: Exception -> L4
        r3.remove("userId");     // Catch: Exception -> L4
        return r3;
    L4:
        finishWithFailure();
        return null;
    }

    public final void invoke(Object r6, CallContext r7) {
        h r8 = (h) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        h.a r9 = r8.a();
        if (r9 == null) goto L9;
        String r10 = r9.b();
        if (r10 == null) goto L9;
        Map<String, ? extends Object> r12 = j(r10);
        if (r12 == null) goto L9;
        boolean r1 = com.bytedance.android.live.revenue.core.util.h.a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.EXHIBITION_INFO, r12, null);
    L9:
        h.a r13 = r8.a();
        if (r13 == null) goto L16;
        String r14 = r13.f();
        if (r14 == null) goto L16;
        Map<String, ? extends Object> r15 = j(r14);
        if (r15 == null) goto L16;
        boolean r2 = com.bytedance.android.live.revenue.core.util.h.a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.GRADE_LEVEL, r15, null);
    L16:
        h.a r16 = r8.a();
        if (r16 == null) goto L23;
        String r17 = r16.g();
        if (r17 == null) goto L23;
        Map<String, ? extends Object> r18 = j(r17);
        if (r18 == null) goto L23;
        boolean r3 = com.bytedance.android.live.revenue.core.util.h.a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.WISH_LIST, r18, null);
    L23:
        h.a r19 = r8.a();
        if (r19 == null) goto L30;
        String r20 = r19.c();
        if (r20 == null) goto L30;
        Map<String, ? extends Object> r22 = j(r20);
        if (r22 == null) goto L30;
        boolean r4 = com.bytedance.android.live.revenue.core.util.h.a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.FANS_CLUB_PAGE, r22, null);
    L30:
        h.a r23 = r8.a();
        if (r23 == null) goto L37;
        String r24 = r23.a();
        if (r24 == null) goto L37;
        Map<String, ? extends Object> r25 = j(r24);
        if (r25 == null) goto L37;
        boolean r5 = com.bytedance.android.live.revenue.core.util.h.a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.AUDIENCE_RANK_LIST, r25, null);
    L37:
        h.a r26 = r8.a();
        if (r26 == null) goto L44;
        String r27 = r26.e();
        if (r27 == null) goto L44;
        Map<String, ? extends Object> r28 = j(r27);
        if (r28 == null) goto L44;
        boolean r29 = com.bytedance.android.live.revenue.core.util.h.a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.LINK_MIC_CONTRIBUTE_RANK_LIST, r28, null);
    L44:
        h.a r30 = r8.a();
        if (r30 == null) goto L58;
        String r32 = r30.d();
        if (r32 == null) goto L58;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L56
        Map<String, Object> r34 = j(r32);     // Catch: Throwable -> L56
        if (r34 == null) goto L54;
        Map<String, ? extends Object> r35 = MapsKt.toMutableMap(r34);     // Catch: Throwable -> L56
        if (r35 == null) goto L54;
        String r36 = String.valueOf(r35.remove("EventName"));     // Catch: Throwable -> L56
        long r37 = CastLongProtector.parseLong(String.valueOf(r35.remove("OriginType")));     // Catch: Throwable -> L56
        boolean r38 = com.bytedance.android.live.revenue.core.util.h.a;     // Catch: Throwable -> L56
        com.bytedance.android.live.profit.privilege.c r39 = (com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class);     // Catch: Throwable -> L56
        ProfitCheckType r40 = ProfitCheckType.GENERAL_TASK;     // Catch: Throwable -> L56
        r40.setTypeName(r36);     // Catch: Throwable -> L56
        r40.setIndex(r37);     // Catch: Throwable -> L56
        Unit r42 = Unit.INSTANCE;     // Catch: Throwable -> L56
        r39.B1(r40, r35, null);     // Catch: Throwable -> L56
    L54:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L58:
        finishWithSuccess();
    }
}
