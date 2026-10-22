package com.bytedance.android.live.liveinteract.plantform.multiroom;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(DataCenter r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        if (MultiLinkLoadWidgetUtils.b() == true) goto L5;
        return;
    L5:
        MultiLinkLoadWidgetUtils.n(r2, "LogFallBackHelper#clearFlag", "source:" + r3);
        if (r2 == null) goto L9;
        r2.put("data_multi_link_log_last_function", null);
        return;
    }

    public static boolean a(DataCenter r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        if (MultiLinkLoadWidgetUtils.b() == true) goto L6;
        return false;
    L6:
        Object r0 = null;
        if (r5 == null) goto L9;
        r0 = (Void) r5.get("data_multi_link_log_last_function", null);
    L9:
        String r1 = (String) r0;
        boolean r2 = !Intrinsics.areEqual(r1, r6);
        MultiLinkLoadWidgetUtils.n(r5, "FallBackLogHelper#checkShouldLogFallBack", "shouldLog:" + r2 + ", lastFunction:" + r1 + ", functionType2:" + r6 + ", source:" + r7);
        if (r2 == false) goto L12;
        LiveTracingMonitor.a("FallBackLogHelper", new Throwable("FallBackLogHelper"), "FallBackLogHelper#lastFunction:" + r1 + ", functionType2:" + r6);
    L12:
        return r2;
    }

    public static void c(DataCenter r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        if (MultiLinkLoadWidgetUtils.b() == true) goto L5;
        return;
    L5:
        MultiLinkLoadWidgetUtils.n(r2, "FallBackLogHelper#recordVoiceRoomShow", "functionType2:" + r3 + ", source:" + r4);
        if (r2 == null) goto L9;
        r2.put("data_multi_link_log_last_function", r3);
        return;
    }
}
