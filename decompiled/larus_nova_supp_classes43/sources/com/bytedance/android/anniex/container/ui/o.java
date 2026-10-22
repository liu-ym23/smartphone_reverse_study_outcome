package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import android.view.View;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ ia.c a;
    public final /* synthetic */ String b;
    public final /* synthetic */ l c;

    public o(ia.c r1, String r10, l r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        s26.d r0 = s26.d.c;
        if (s26.d.c.d(this.a.getBid(), com.bytedance.android.anniex.base.service.d.class) == null) goto L5;
        com.bytedance.android.anniex.base.service.d.H0(this.a);
    L5:
        List<Object> r1 = CollectionsKt.emptyList();
        if (s26.d.c.d(this.a.getBid(), com.bytedance.android.anniex.base.service.a.class) == null) goto L9;
        Context r11 = r10.getContext();
        la.b r12 = new la.b(null);
        String r13 = this.a.getCurrentUrl();
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);
        r12.a = r13;
        Intrinsics.checkNotNullParameter("annie_x_title_bar", "enterFrom");
        r12.b = "annie_x_title_bar";
        String r14 = this.b;
        Intrinsics.checkNotNullParameter(r14, "sessionId");
        r12.c = r14;
        Intrinsics.checkNotNullParameter(r1, "panelButtons");
        r12.d = r1;
        com.bytedance.android.anniex.base.service.a.H0(r11, r12);
    L9:
        if (this.c.a == false) goto L12;
        MonitorCenter.c.a(this.b, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_source", "event_source_title_bar"), TuplesKt.to("event_type", "event_type_click"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_NAME, com.bytedance.android.ec.core.event.a.VALUE_MORE)}), null);
        return;
    }
}
