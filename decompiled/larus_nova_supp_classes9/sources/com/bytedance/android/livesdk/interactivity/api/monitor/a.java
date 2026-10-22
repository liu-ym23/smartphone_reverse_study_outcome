package com.bytedance.android.livesdk.interactivity.api.monitor;

import android.util.Log;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final InteractivityMonitor.Event a = null;
    public static final InteractivityMonitor.Event b = null;
    public static final LiveTracingMonitor.EventModule c = null;

    static {
        a = InteractivityMonitor.Event.CommentUserSend;
        b = InteractivityMonitor.Event.CommentIntercept;
        c = LiveTracingMonitor.EventModule.common;
    }

    @JvmStatic
    public static final String a(t r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        String r3 = r2.getMessageMethod();
        if (r3 != null) goto L6;
    L25:
        return "unknow";
    L6:
        switch(r3.hashCode()) {
            case -1142270555: goto L23;
            case 41447196: goto L20;
            case 1163169388: goto L15;
            case 1906410492: goto L12;
            case 2129329488: goto L9;
            default: goto L25;
        };
    L9:
        if (r3.equals("WebcastScreenChatMessage") == false) goto L25;
        return "admin";
    L12:
        if (r3.equals("WebcastEmojiChatMessage") == false) goto L25;
        return "subscribe";
    L15:
        if (r3.equals("WebcastAudioChatMessage") == false) goto L17;
    L18:
        return "audio";
    L17:
        if (r3.equals("WebcastAudioChatMessage") == false) goto L25;
    L20:
        if (r3.equals("WebcastChatMessage") == false) goto L25;
        return "admin";
    L23:
        if (r3.equals("WebcastPrivilegeScreenChatMessage") == false) goto L25;
        return "privilege";
    }

    @JvmStatic
    public static final void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "sendType");
        JSONObject r0 = new JSONObject();
        r0.put("send_type", r4);
        r0.put("send_status", "start_send");
        InteractivityMonitor.Event r5 = a;
        LiveTracingMonitor.f(r5.getEventName(), r5.getEventModule(), r0, new JSONObject(), new JSONObject());
    }

    @JvmStatic
    public static final void e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "sendType");
        JSONObject r0 = new JSONObject();
        r0.put("send_type", r4);
        r0.put("send_status", "send_success");
        InteractivityMonitor.Event r5 = a;
        LiveTracingMonitor.f(r5.getEventName(), r5.getEventModule(), r0, new JSONObject(), new JSONObject());
    }

    @JvmStatic
    public static final void b(Throwable r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "t");
        Intrinsics.checkNotNullParameter("send comment message", "msg");
        JSONObject r2 = new JSONObject();
        r2.put("msg", "send comment message");
        r2.put("cause", r5.getCause());
        r2.put("throwable_msg", r5.getMessage());
        r2.put("stack", Log.getStackTraceString(r5));
        LiveTracingMonitor.EventModule r7 = c;
        JSONObject r0 = new JSONObject();
        r0.put("status_code", r6);     // Catch: JSONException -> L8
    L10:
        r0.put("category_1", "live");     // Catch: JSONException -> L9
    L6:
        LiveMonitor r8 = new LiveMonitor();
        r8.mCategory = r0;
        r8.mEventModule = r7;
        r8.mServiceName = "ttlive_comment_monitor";
        r8.mExtraLog = r2;
        r8.mMetrics = null;
        LiveMonitor.access$002(r8, false);
        LiveMonitor.access$102(r8, false);
        LiveMonitor.access$202(r8, true);
        LiveMonitor.access$302(r8, false);
        LiveMonitor.access$402(r8, false);
        r8.report();
    }

    @JvmStatic
    public static final void d(String r6, String r7, Throwable r8) {
        Intrinsics.checkNotNullParameter(r6, "sendType");
        JSONObject r0 = new JSONObject();
        r0.put("send_type", r6);
        r0.put("send_status", "send_fail");
        if ((r8 instanceof CustomApiServerException) == false) goto L9;
        String r2 = ((CustomApiServerException) r8).getErrorMsg();
        if (r2 != null) goto L7;
        r2 = "unknown api exception";
    L7:
        r0.put("reason", r2);
    L15:
        if (r8 == null) goto L24;
        JSONObject r3 = new JSONObject();
        r3.put("send_type", r6);
        if (r7 != null) goto L19;
        r7 = CardLockInfo.sUNKNOWN;
    L19:
        r3.put("reason", r7);
        Throwable r9 = r8.getCause();
        if (r9 == null) goto L22;
        String r10 = r9.getMessage();
    L23:
        r3.put("cause", r10);
        r3.put("throwable_msg", r8.getMessage());
        r3.put("stack", Log.getStackTraceString(r8));
    L25:
        InteractivityMonitor.Event r11 = a;
        LiveTracingMonitor.f(r11.getEventName(), r11.getEventModule(), r0, new JSONObject(), r3);
        return;
    L22:
        r10 = null;
        goto L23
    L24:
        r3 = new JSONObject();
        goto L25
    L9:
        if ((r8 instanceof NetworkErrorException) == false) goto L11;
        r0.put("reason", "network_error: " + ((NetworkErrorException) r8).statusCode);
        goto L15
    L11:
        if (r7 != null) goto L13;
        String r4 = CardLockInfo.sUNKNOWN;
    L14:
        r0.put("reason", r4);
        goto L15
    L13:
        r4 = r7;
        goto L14
    }
}
