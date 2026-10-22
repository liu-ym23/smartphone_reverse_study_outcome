package com.bytedance.android.live.broadcast.rts;

import com.bytedance.rts.foundation.m;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AnchorStatusReporter {
    public final Function2<? super String, ? super Map<String, String>, Unit> a;

    public AnchorStatusReporter(Function2<? super String, ? super Map<String, String>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "trackEvent");
        this.a = r2;
    }

    public final void a(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "tabKey");
        Intrinsics.checkNotNullParameter(r5, "enterFromType");
        LinkedHashMap r0 = new LinkedHashMap();
        m.e(r0, "tab_key", r3);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        m.e(r0, "tab_type", r4);
        m.e(r0, "enter_from_type", r5);
        Function2<? super String, ? super Map<String, String>, Unit> r6 = this.a;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("trackEvent");
    L8:
        r6.invoke("livesdk_anchor_status_panel_tab_show", r0);
    }

    public final void b(long r6, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "curShownTabKey");
        Intrinsics.checkNotNullParameter(r9, "enterFromType");
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = com.bytedance.rts.foundation.c.a;
        int r2 = com.bytedance.rts.foundation.h.a;
        int r3 = com.bytedance.rts.foundation.b.a;
        m.e(r0, "duration", String.valueOf(((long) Math.floor(System.currentTimeMillis() / ((double) 1000))) - r6));
        m.e(r0, "tab_key", r8);
        m.e(r0, "enter_from_type", r9);
        Function2<? super String, ? super Map<String, String>, Unit> r7 = this.a;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trackEvent");
    L5:
        r7.invoke("livesdk_anchor_status_panel_tab_show_duration", r0);
    }

    public final void c(String r4, String r5, Map<String, String> r6) {
        final LinkedHashMap r0 = new LinkedHashMap();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        m.e(r0, "suggest_id", r4);
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        m.e(r0, "tab_key", r5);
        if (r6 == null) goto L11;
        m.d(r6, new AnchorStatusReporter$reportSuggestLayoutShow$1(r0));
    L11:
        Function2<? super String, ? super Map<String, String>, Unit> r7 = this.a;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("trackEvent");
    L14:
        r7.invoke("livesdk_anchor_status_panel_suggest_show", r0);
    }
}
