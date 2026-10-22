package com.bytedance.ai.applet.page;

import com.bytedance.ai.monitor.AppletErrorCode;
import com.ivy.ivykit.api.plugin.IIvyPageService;
import java.util.Map;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements IIvyPageService.a {
    public final /* synthetic */ AppletPageTimelineTracker a;

    public final void onDestroy() {
        AppletPageTimelineTracker r0 = this.a;
        if (r0.c == true) goto L7;
        i1 r1 = y0.a;
        y0.p(r0.a, "applet_page_timeline_full", false);
        y0.o(r0.a, "applet_page_timeline_full");
        r0.c = true;
        return;
    }

    public final void onLoadSuccess() {
        AppletPageTimelineTracker r0 = this.a;
        if (r0.b == true) goto L7;
        i1 r1 = y0.a;
        y0.f(r0.a, "applet_page_timeline_full");
        r0.b = true;
        return;
    }

    public a(AppletPageTimelineTracker r1) {
        this.a = r1;
    }

    public final void onTimingSetup(Map<String, Object> r10) {
        AppletPageTimelineTracker r0 = this.a;
        r0.getClass();
        i1 r1 = y0.a;
        y0.n(r0.a, r10, "applet_page_timeline_full");
    }

    public final void a(Integer r10, String r11) {
        AppletPageTimelineTracker r0 = this.a;
        if (r10 == null) goto L5;
        int r12 = r10.intValue();
    L6:
        r0.a(r11, r12);
        return;
    L5:
        r12 = AppletErrorCode.WEB_VIEW_LOAD_ERROR.getType();
        goto L6
    }
}
