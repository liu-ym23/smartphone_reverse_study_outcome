package com.bytedance.ai.applet.app.foundation.performance;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends e {
    public final String p;
    public final String q;
    public final String r;
    public final Long s;
    public final Long t;
    public final String u;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.performance.e
    public final String b() {
        return this.u;
    }

    @Override // com.bytedance.ai.applet.app.foundation.performance.e
    public final void a(Map<String, Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        r10.put("path", this.p);
        String r0 = this.q;
        if (r0 == null) goto L5;
        r10.put("navigation_type", r0);
    L5:
        String r1 = this.r;
        if (r1 == null) goto L8;
        r10.put("referrer_path", r1);
    L8:
        Long r11 = this.s;
        if (r11 == null) goto L11;
        r10.put("route_duration", Long.valueOf(r11.longValue()));
    L11:
        Long r12 = this.t;
        if (r12 == null) goto L15;
        r10.put("app_launch_duration", Long.valueOf(r12.longValue()));
        return;
    }

    public b(String r21, String r22, long r23, long r25, long r27, AppletPerformanceErrorCode r29, String r30, Long r31, Long r32, Long r33, Long r34, boolean r35, Long r36, String r37, String r38, String r39, Long r40, Long r41) {
        Intrinsics.checkNotNullParameter(r21, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r22, BdpAwemeConstant.KEY_APP_NAME);
        Intrinsics.checkNotNullParameter(r29, "errorCode");
        Intrinsics.checkNotNullParameter(r37, "path");
        super(r21, r22, r23, r25, r27, r29, r30, null, null, r31, r32, r33, r34, r35, r36);
        this.p = r37;
        this.q = r38;
        this.r = r39;
        this.s = r40;
        this.t = r41;
        this.u = "applet_page_performance";
    }
}
