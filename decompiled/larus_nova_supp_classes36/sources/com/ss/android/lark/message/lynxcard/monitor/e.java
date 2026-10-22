package com.ss.android.lark.message.lynxcard.monitor;

import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r11, String r12, boolean r13, boolean r14, boolean r15, boolean r16, String r17, OPTrace r18, OPTrace r19, boolean r20, String r21, String r22, boolean r23, int r24, int r25, CardContent.DataSource r26) {
        Intrinsics.checkNotNullParameter(INotificationHitPoint.NoticeType.MESSAGE, "renderBusinessType");
        Intrinsics.checkNotNullParameter(r12, "scene");
        Intrinsics.checkNotNullParameter(r17, "translateState");
        Intrinsics.checkNotNullParameter(r19, "renderTrace");
        JSONObject r6 = new JSONObject();
        int r8 = 0;
        if (r13 == false) goto L6;
        int r10 = 1;
    L34:
        r6.put("is_ephemeral", r10);     // Catch: JSONException -> L20
        if (r14 == false) goto L10;
        int r110 = 1;
    L11:
        r6.put("is_forward", r110);     // Catch: JSONException -> L20
        if (r15 == false) goto L14;
        int r111 = 1;
    L15:
        r6.put("is_config_card_link", r111);     // Catch: JSONException -> L20
        if (r16 == false) goto L18;
        r8 = 1;
    L18:
        r6.put("is_merge_forward", r8);     // Catch: JSONException -> L20
        r6.put("translate_state", r17);     // Catch: JSONException -> L20
    L22:
        fyb.e r0 = b.a;
        b r1 = b.c.a(ncb.c.h);
        if (r18 == null) goto L25;
        String r7 = r18.getTracingID();
    L26:
        OPMonitor r2 = r1.addCategoryValue("create_traceId", r7).addCategoryValue("render_business_type", INotificationHitPoint.NoticeType.MESSAGE).addCategoryValue("scene", r12).addCategoryValue("scene_attribute", r6.toString()).addCategoryValue("is_universal_card", Boolean.valueOf(r20)).addCategoryValue("is_streaming_mode", Boolean.valueOf(r23)).addCategoryValue("bot_id", r21).addCategoryValue("app_id", r22).addCategoryValue("content_length", Integer.valueOf(r24)).addCategoryValue("content_version", Integer.valueOf(r25)).tracing(r19);
        if (r26 == null) goto L29;
        r2.addCategoryValue("data_source", r26.getValue());
    L29:
        if (r20 == false) goto L31;
        r2.addCategoryValue("card_id", r11);
    L32:
        r2.flush();
        return;
    L31:
        r2.addCategoryValue("message_id", r11);
        goto L32
    L25:
        r7 = null;
        goto L26
    L14:
        r111 = 0;
        goto L15
    L10:
        r110 = 0;
    L20:
        e = move-exception;
        Log.w("LynxCardMonitorUtils", "reportMessageCardBindStart json exception", e);
        goto L22
    L6:
        r10 = 0;
        goto L34
    }
}
