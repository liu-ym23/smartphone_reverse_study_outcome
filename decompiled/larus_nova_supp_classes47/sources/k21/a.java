package k21;

import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.global.c;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;
import y50.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends e {
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: k21.a$a, reason: collision with other inner class name */
    public static final class C0260a {
    }

    static {
    }

    public final void m() {
        LinkedHashMap r0 = new LinkedHashMap();
        c r1 = this.d;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r2 = null;
        if (r1 == null) goto L5;
        MultiPkMatchContext r3 = r1.gf();
    L6:
        if (r3 == null) goto L8;
        r2 = com.bytedance.android.live.revlink.impl.multianchor.match.e.a(r3);
    L8:
        r0.put("match_status", String.valueOf(r2));
        b(r0);
        f(r0);
        int r4 = v.a;
        v.h("ttlive_anchor_link_match", "intercept_invite_when_multi_matching: " + r0);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void n(String r9, Map<String, ? extends Object> r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L20
        JSONObject r3 = new JSONObject(r10);     // Catch: Throwable -> L20
        LinkedHashMap r12 = (LinkedHashMap) r10;     // Catch: Throwable -> L20
        Object r1 = r12.get("error_code");     // Catch: Throwable -> L20
        Unit r2 = null;
        if ((r1 instanceof Integer) == true) goto L5;
        r1 = null;
    L5:
        Integer r4 = (Integer) r1;     // Catch: Throwable -> L20
        if (r4 == null) goto L8;
        int r5 = r4.intValue();     // Catch: Throwable -> L20
    L9:
        Object r13 = r12.get("error_msg");     // Catch: Throwable -> L20
        if ((r13 instanceof String) == true) goto L12;
        r13 = null;
    L12:
        String r6 = (String) r13;     // Catch: Throwable -> L20
        c r14 = this.d;     // Catch: Throwable -> L20
        if (r14 == null) goto L15;
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r7 = r14.getMultiLinkMonitor();     // Catch: Throwable -> L20
    L16:
        if (r7 == null) goto L18;
        com.bytedance.android.live.revlink.impl.multianchor.utils.v.x(r7, r9, r3, r5, r6, null, 48);     // Catch: Throwable -> L20
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        Result.constructor-impl(r2);     // Catch: Throwable -> L20
        return;
    L15:
        r7 = null;
        goto L16
    L8:
        r5 = 0;
    L20:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void o(int r4, Throwable r5) {
        JSONObject r0 = new JSONObject();
        b.a.b(r0, "match_type", r4);
        e.l(r5, r0);
        c r6 = this.d;
        if (r6 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r7 = r6.getMultiLinkMonitor();
    L6:
        if (r7 == null) goto L9;
        int r2 = com.bytedance.android.live.revlink.impl.multianchor.utils.v.i;
        r7.G("multi_random_match_error", r5, r0, null);
        return;
    L9:
        return;
    L5:
        r7 = null;
        goto L6
    }

    public a(ld.a r1, com.bytedance.android.livesdk.revenue.service.room.c r2, LinkFakeGlobalService r3) {
        super(r1, r2, r3);
    }
}
