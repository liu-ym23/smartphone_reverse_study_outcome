package d9;

import android.util.Log;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.proto.Response;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8514a = null;

    static {
        f8514a = new a();
    }

    private a() {
    }

    public final void a(Boolean r10) {
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L8
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L5;
        String r12 = NetConst.ENCRYPT_VERISON_CODE;
    L6:
        r11.put("result", r12);     // Catch: Exception -> L8
        c.f8516a.m("event_bind_result", r11);     // Catch: Exception -> L8
        return;
    L5:
        r12 = NetConst.NOT_ENCRYPT_VERISON_CODE;
    L8:
        e = move-exception;
        e9.b.b("ReportMonitorHelper", "report exception " + Log.getStackTraceString(e), null, 4, null);
    }

    public final void b(int r10, int r11, String r12, Response r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r13, "response");
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L22
        r15.put("status", "status_receiver_result");     // Catch: Exception -> L22
        r15.put("cmd", r10);     // Catch: Exception -> L22
        r15.put("way", r11);     // Catch: Exception -> L22
        r15.put("package_name", r12);     // Catch: Exception -> L22
        Integer r16 = r13.statusCode;     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r16, "response.statusCode");     // Catch: Exception -> L22
        r15.put(WsConstants.ERROR_CODE, r16.intValue());     // Catch: Exception -> L22
        r15.put("error_message", r13.errorMsg);     // Catch: Exception -> L22
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L22
        if (r14 == null) goto L20;
        String r18 = r14.optString("start_callback_time");     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r18, "startCallbackTime");     // Catch: Exception -> L22
        boolean r19 = true;
        if (r18.length() <= 0) goto L8;
        boolean r110 = true;
    L9:
        long r20 = 0;
        if (r110 == false) goto L12;
        long r21 = System.currentTimeMillis() - Long.parseLong(r18);     // Catch: Exception -> L22
    L13:
        String r111 = r14.optString("start_intent_use_time");     // Catch: Exception -> L22
        String r112 = r14.optString("start_time");     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r112, "realStartTime");     // Catch: Exception -> L22
        if (r112.length() > 0) goto L17;
        r19 = false;
    L17:
        if (r19 == false) goto L19;
        r20 = System.currentTimeMillis() - Long.parseLong(r112);     // Catch: Exception -> L22
    L19:
        String r113 = r14.optString("process_time");     // Catch: Exception -> L22
        r17.put("cost_time", r20);     // Catch: Exception -> L22
        r17.put("start_intent_use_time", r111);     // Catch: Exception -> L22
        r17.put("process_time", r113);     // Catch: Exception -> L22
        r17.put("callback_use_time", r21);     // Catch: Exception -> L22
        goto L20
    L12:
        r21 = 0;
        goto L13
    L8:
        r110 = false;
    L20:
        c.f8516a.n("event_send_cmd_result", r15, r17, new JSONObject());     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        e9.b.b("ReportMonitorHelper", "report exception " + Log.getStackTraceString(e), null, 4, null);
    }
}
