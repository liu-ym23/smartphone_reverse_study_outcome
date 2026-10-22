package x81;

import am2.x;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r3, DataCenter r4, String r5, HashMap r6) {
        Intrinsics.checkNotNullParameter(r3, "event");
        HashMap r0 = new HashMap();
        r0.putAll(r6);
        if (r4 == null) goto L31;
        String r1 = a0.n(r4).getAnchorId();
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        r0.put("anchor_id", r1);
        if (gb2.a.a(r4, false) == false) goto L10;
        String r7 = DataType.TRUE;
    L11:
        r0.put("is_anchor", r7);
        IMiddlewareUserService r8 = k.f(IMiddlewareUserService.class);
        if (r8 == null) goto L17;
        e r9 = r8.user();
        if (r9 == null) goto L17;
        String r10 = r9.n();
        if (r10 == null) goto L17;
    L18:
        r0.put("user_id", r10);
    L17:
        r10 = "-1";
        goto L18
    L10:
        r7 = DataType.FALSE;
    L31:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L27
        if (r5 == null) goto L24;
        Map r13 = JsonUtil.jsonObjectToMap(new JSONObject(r5));     // Catch: Throwable -> L27
        if (r13 == null) goto L24;
        r0.putAll(r13);     // Catch: Throwable -> L27
    L25:
        Result.constructor-impl(r13);     // Catch: Throwable -> L27
    L29:
        j0.l().sendLog(r3, r0, new Object[]{IRoom.class, new x()});
        return;
    L24:
        r13 = null;
    L27:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }
}
