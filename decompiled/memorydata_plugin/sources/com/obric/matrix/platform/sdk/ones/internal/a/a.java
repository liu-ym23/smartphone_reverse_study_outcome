package com.obric.matrix.platform.sdk.ones.internal.a;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.matrix.proto.Response;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004J2\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/monitor/ReportMonitorHelper;", "", "()V", "TAG", "", "monitorBinderResult", "", "bindResult", "", "(Ljava/lang/Boolean;)V", "monitorSendCmdException", "cmd", "", "code", NotificationCompat.CATEGORY_MESSAGE, "monitorSendCmdResult", "way", ObricMemoryConstants.KEY_PACKAGE_NAME, ChatMessage.TYPE_RESPONSE, "Lcom/obric/matrix/proto/Response;", "extraData", "Lorg/json/JSONObject;", "monitorStartSendCmd", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8105a = null;

    static {
        f8105a = new a();
    }

    private a() {
    }

    public final void a(int r10, int r11, String r12, Response r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r13, ChatMessage.TYPE_RESPONSE);
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L22
        r2.put("status", "status_receiver_result");     // Catch: Exception -> L22
        r2.put("cmd", r10);     // Catch: Exception -> L22
        r2.put("way", r11);     // Catch: Exception -> L22
        r2.put("package_name", r12);     // Catch: Exception -> L22
        Integer r15 = r13.statusCode;     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r15, "response.statusCode");     // Catch: Exception -> L22
        r2.put("error_code", ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Exception -> L22
        r2.put(InfoRequestQPSOptTraceLogger.ERROR_MESSAGE, r13.errorMsg);     // Catch: Exception -> L22
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L22
        if (r14 == null) goto L20;
        String r17 = r14.optString("start_callback_time");     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r17, "startCallbackTime");     // Catch: Exception -> L22
        boolean r18 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r19 = true;
    L9:
        long r4 = 0;
        if (r19 == false) goto L12;
        long r6 = System.currentTimeMillis() - Long.parseLong(r17);     // Catch: Exception -> L22
    L13:
        String r110 = r14.optString("start_intent_use_time");     // Catch: Exception -> L22
        String r111 = r14.optString("start_time");     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r111, "realStartTime");     // Catch: Exception -> L22
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L17;
        r18 = false;
    L17:
        if (r18 == false) goto L19;
        r4 = System.currentTimeMillis() - Long.parseLong(r111);     // Catch: Exception -> L22
    L19:
        String r112 = r14.optString("process_time");     // Catch: Exception -> L22
        r16.put("cost_time", r4);     // Catch: Exception -> L22
        r16.put("start_intent_use_time", r110);     // Catch: Exception -> L22
        r16.put("process_time", r112);     // Catch: Exception -> L22
        r16.put("callback_use_time", r6);     // Catch: Exception -> L22
        goto L20
    L12:
        r6 = 0;
        goto L13
    L8:
        r19 = false;
    L20:
        b.f8106a.a("event_send_cmd_result", r2, r16, new JSONObject());     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("ReportMonitorHelper", "report exception " + Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);
    }
}
