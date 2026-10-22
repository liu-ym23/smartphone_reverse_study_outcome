package com.bytedance.android.livesdk.interactivity.api.monitor;

import android.util.Log;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.livesdk.interactivity.api.settings.config.n;
import com.bytedance.bdlocation.BuildConfig;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final n a = null;

    static {
        a = (n) v0.a.getValue();
    }

    @JvmStatic
    public static final void a(boolean r8) {
        if (a.monitorCostClick == true) goto L5;
        return;
    L5:
        LinkedHashMap r6 = new LinkedHashMap();
        if (r8 == false) goto L8;
        String r9 = "yes";
    L9:
        r6.put("button", r9);
        Unit r10 = Unit.INSTANCE;
        c r11 = new c(0, null, 0, r6, 7);
        r11.a(InteractivityMonitor.Event.CostConfirmWindowClick);
        r11.b(InteractivityTraceMonitor.Event.CostConfirmWindowClick);
        return;
    L8:
        r9 = "no";
        goto L9
    }

    public static void d(String r8, String r9) {
        if (a.monitorJsbEvent == true) goto L5;
        return;
    L5:
        LinkedHashMap r6 = new LinkedHashMap();
        if (r8 != null) goto L8;
        r8 = BuildConfig.FLAVOR;
    L8:
        r6.put("request_source", r8);
        if (r9 != null) goto L11;
        r9 = BuildConfig.FLAVOR;
    L11:
        r6.put("content", r9);
        Unit r10 = Unit.INSTANCE;
        c r11 = new c(0, null, 0, r6, 7);
        r11.a(InteractivityMonitor.Event.ReceiveOpenCommentPanelEvent);
        r11.b(InteractivityTraceMonitor.Event.ReceiveOpenCommentPanelEvent);
    }

    @JvmStatic
    public static final void f(String r8, String r9) {
        if (a.monitorAiParam == true) goto L5;
        return;
    L5:
        if (r9 != null) goto L7;
        int r2 = 0;
    L8:
        if (r9 != null) goto L10;
        String r3 = BuildConfig.FLAVOR;
    L11:
        LinkedHashMap r6 = new LinkedHashMap();
        if (r8 == null) goto L14;
        String r10 = (String) r6.put("params", r8);
    L14:
        if (r9 == null) goto L16;
        r6.put("error", r9);
    L16:
        Unit r11 = Unit.INSTANCE;
        new c(r2, r3, 0, r6, 4).b(InteractivityTraceMonitor.Event.InputAIParamLog);
        return;
    L10:
        r3 = r9;
        goto L11
    L7:
        r2 = -1;
        goto L8
    }

    @JvmStatic
    public static final void b(boolean r8, String r9, Integer r10) {
        if (a.monitorDanmakuClick == true) goto L5;
        return;
    L5:
        LinkedHashMap r6 = new LinkedHashMap();
        if (r8 == false) goto L8;
        String r11 = "on";
    L9:
        r6.put("beforeClick", r11);
        if (r9 != null) goto L12;
        r9 = BuildConfig.FLAVOR;
    L12:
        r6.put("scene", r9);
        r6.put("tab", String.valueOf(r10));
        Unit r13 = Unit.INSTANCE;
        c r14 = new c(0, null, 0, r6, 7);
        r14.a(InteractivityMonitor.Event.DanmakuSwitchClick);
        r14.b(InteractivityTraceMonitor.Event.DanmakuSwitchClick);
        return;
    L8:
        r11 = "off";
        goto L9
    }

    @JvmStatic
    public static final void e(String r8, String r9, Throwable r10) {
        Intrinsics.checkNotNullParameter(r8, "sendType");
        if (a.monitorSendFailed == true) goto L6;
        return;
    L6:
        if ((r10 instanceof CustomApiServerException) == false) goto L11;
        String r0 = ((CustomApiServerException) r10).getErrorMsg();
        if (r0 != null) goto L14;
        r0 = "unknown api exception";
    L14:
        String r1 = BuildConfig.FLAVOR;
        if (r9 != null) goto L17;
        String r3 = BuildConfig.FLAVOR;
    L18:
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("send_type", r8);
        if (r0 != null) goto L21;
        r0 = BuildConfig.FLAVOR;
    L21:
        r6.put("fail_reason", r0);
        if (r10 == null) goto L27;
        Throwable r11 = r10.getCause();
        if (r11 == null) goto L27;
        String r13 = r11.getMessage();
        if (r13 == null) goto L27;
    L28:
        r6.put("cause", r13);
        if (r10 == null) goto L34;
        String r14 = r10.getMessage();
        if (r14 == null) goto L34;
        r1 = r14;
    L34:
        r6.put("throwable_msg", r1);
        if (r10 == null) goto L37;
        r6.put("stack", Log.getStackTraceString(r10));
    L37:
        Unit r15 = Unit.INSTANCE;
        new c(-1, r3, 0, r6, 4).b(InteractivityTraceMonitor.Event.SendIntercept);
        return;
    L27:
        r13 = BuildConfig.FLAVOR;
        goto L28
    L17:
        r3 = r9;
        goto L18
    L11:
        if ((r10 instanceof NetworkErrorException) == false) goto L13;
        r0 = "network_error: " + ((NetworkErrorException) r10).statusCode;
        goto L14
    L13:
        r0 = r9;
        goto L14
    }

    @JvmStatic
    public static final void c(String r9, boolean r10, String r11, String r13, Integer r14, String r15) {
        Intrinsics.checkNotNullParameter(r9, "source");
        if (a.monitorShow == true) goto L5;
        return;
    L5:
        if (r10 == false) goto L7;
        int r3 = 0;
    L9:
        if (r10 == false) goto L11;
        r11 = "success";
    L13:
        String r4 = r11;
    L14:
        LinkedHashMap r7 = new LinkedHashMap();
        if (r15 != null) goto L17;
        r15 = BuildConfig.FLAVOR;
    L17:
        r7.put("scene", r15);
        r7.put("source", r9);
        if (r13 != null) goto L20;
        r13 = BuildConfig.FLAVOR;
    L20:
        r7.put("danmakuSwitchStatus", r13);
        r7.put("tab", String.valueOf(r14));
        Unit r16 = Unit.INSTANCE;
        c r17 = new c(r3, r4, 0, r7, 4);
        r17.a(InteractivityMonitor.Event.InputPanelShow);
        r17.b(InteractivityTraceMonitor.Event.InputPanelShow);
        return;
    L11:
        if (r11 != null) goto L13;
        r4 = BuildConfig.FLAVOR;
        goto L14
    L7:
        r3 = -1;
        goto L9
    }
}
