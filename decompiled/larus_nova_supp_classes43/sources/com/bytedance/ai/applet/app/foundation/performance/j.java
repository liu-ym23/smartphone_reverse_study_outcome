package com.bytedance.ai.applet.app.foundation.performance;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j extends e {
    public final String p;
    public final String q;
    public final boolean r;
    public final String s;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.performance.e
    public final String b() {
        return this.s;
    }

    @Override // com.bytedance.ai.applet.app.foundation.performance.e
    public final void a(Map<String, Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        r10.put("widget_id", this.p);
        r10.put("widget_instance_id", this.q);
        r10.put("is_app_cold_launch", Integer.valueOf(this.r ? 1 : 0));
    }

    public j(String r10, String r11, long r12, long r13, long r14, AppletPerformanceErrorCode r16, String r17, Long r18, Long r19, Long r20, Long r21, Long r22, Long r23, boolean r24, Long r25, String r26, String r27, boolean r28) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_NAME);
        Intrinsics.checkNotNullParameter(r16, "errorCode");
        Intrinsics.checkNotNullParameter(r26, "widgetId");
        Intrinsics.checkNotNullParameter(r27, "widgetInstanceId");
        super(r10, r11, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        this.p = r26;
        this.q = r27;
        this.r = r28;
        this.s = "applet_widget_performance";
    }
}
