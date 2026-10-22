package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import android.view.View;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p implements View.OnClickListener {
    public final /* synthetic */ ia.c a;
    public final /* synthetic */ l b;
    public final /* synthetic */ String c;

    public p(ia.c r1, l r10, String r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        s26.d r0 = s26.d.c;
        if (s26.d.c.d(this.a.getBid(), com.bytedance.android.anniex.base.service.a.class) == null) goto L6;
        Context r11 = r10.getContext();
        la.d r1 = new la.d(0);
        r1.c = "annie_x_title_bar";
        r1.d = "search_amplifier";
        com.bytedance.android.anniex.base.service.a.L0(r11, r1);
    L6:
        if (this.b.a == false) goto L9;
        MonitorCenter.c.a(this.c, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_source", "event_source_title_bar"), TuplesKt.to("event_type", "event_type_click"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_NAME, "search_amplifier")}), null);
        return;
    }
}
