package com.bytedance.android.anniex.container.ui;

import android.view.View;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ ia.c a;
    public final /* synthetic */ l b;
    public final /* synthetic */ String c;

    public m(ia.c r1, l r10, String r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        this.a.goBack();
        if (this.b.a == false) goto L6;
        MonitorCenter.c.a(this.c, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_source", "event_source_title_bar"), TuplesKt.to("event_type", "event_type_click"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_NAME, "back")}), null);
        return;
    }
}
