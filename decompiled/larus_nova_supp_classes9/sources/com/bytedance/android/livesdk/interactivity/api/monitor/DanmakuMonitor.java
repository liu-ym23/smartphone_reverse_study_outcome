package com.bytedance.android.livesdk.interactivity.api.monitor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.settings.config.f;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class DanmakuMonitor {
    public static final f a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    static {
        a = (f) d0.a.getValue();
        b = LazyKt.lazy(DanmakuMonitor$receiveList$2.INSTANCE);
        c = LazyKt.lazy(DanmakuMonitor$showList$2.INSTANCE);
        d = LazyKt.lazy(DanmakuMonitor$dropList$2.INSTANCE);
    }

    public static void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "status");
        if (a.monitorCarnivalModel == true) goto L5;
        return;
    L5:
        c r0 = new c(0, r8, 0, null, 13);
        r0.b(InteractivityTraceMonitor.Event.CarnivalModelDownload);
        ALogger.i("ttlive_danmaku_carnival_model_download", r0.toString());
    }

    @JvmStatic
    public static final void c(boolean r9) {
        if (a.monitorPrivilegeShow == true) goto L5;
        return;
    L5:
        Lazy r0 = b;
        if (((List) r0.getValue()).isEmpty() == false) goto L9;
        return;
    L9:
        if (r9 == false) goto L11;
        String r10 = "portrait";
    L12:
        String r4 = r10;
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("receive", ((List) r0.getValue()).toString());
        r7.put("show", ((List) c.getValue()).toString());
        r7.put("drop", ((List) d.getValue()).toString());
        Unit r11 = Unit.INSTANCE;
        c r13 = new c(0, r4, 0, r7, 5);
        r13.b(InteractivityTraceMonitor.Event.PrivilegeDanmakuShow);
        d(10086, null);
        ALogger.i("ttlive_danmaku_privilege_message_summary", r13.toString());
        return;
    L11:
        r10 = "landscape";
        goto L12
    }

    public static void b(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "status");
        if (a.monitorOpenContour == true) goto L5;
        return;
    L5:
        LinkedHashMap r6 = new LinkedHashMap();
        if (r9 == null) goto L8;
        r6.put("extraInfo", r9);
    L8:
        Unit r10 = Unit.INSTANCE;
        c r11 = new c(0, r8, 0, r6, 5);
        r11.b(InteractivityTraceMonitor.Event.CarnivalOpenContour);
        ALogger.i("ttlive_danmaku_carnival_open_contour", r11.toString());
    }

    @JvmStatic
    public static final void d(int r1, Long r2) {
        if (a.monitorPrivilegeShow == true) goto L6;
        return;
    L6:
        if (r1 != 1) goto L8;
        if (r2 == null) goto L27;
        long r3 = r2.longValue();
        ((List) b.getValue()).add(Long.valueOf(r3));
        return;
    L27:
        return;
    L8:
        if (r1 != 2) goto L10;
        if (r2 == null) goto L25;
        long r4 = r2.longValue();
        ((List) c.getValue()).add(Long.valueOf(r4));
        return;
    L25:
        return;
    L10:
        if (r1 != 3) goto L12;
        if (r2 == null) goto L23;
        long r5 = r2.longValue();
        ((List) d.getValue()).add(Long.valueOf(r5));
        return;
    L23:
        return;
    L12:
        if (r1 != 10086) goto L28;
        ((List) b.getValue()).clear();
        ((List) c.getValue()).clear();
        ((List) d.getValue()).clear();
        return;
    }
}
