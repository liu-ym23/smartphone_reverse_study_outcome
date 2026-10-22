package com.bytedance.android.annie.business.ability.schema.model;

import kotlin.jvm.internal.Intrinsics;
import t36.d;
import y36.i;
import y36.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class b extends AnnieXLiveCardModel {
    public y36.a f;
    public y36.a g;
    public p h;

    public final boolean d() {
        y36.a r0 = this.g;
        if (r0 == null) goto L7;
        Boolean r1 = (Boolean) ((i) r0).b;
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    public b() {
    }

    @Override // com.bytedance.android.annie.business.ability.schema.model.AnnieXLiveCardModel
    public void a(d r10) {
        Intrinsics.checkNotNullParameter(r10, "schemaData");
        super.a(r10);
        Boolean r1 = Boolean.FALSE;
        new y36.a(r10, "forbid_right_back", r1);
        this.f = new y36.a(r10, "enable_share", r1);
        this.g = new y36.a(r10, "show_float_live", r1);
        new y36.a(r10, "enable_card_cache", r1);
        new y36.a(r10, "close_position_right", Boolean.TRUE);
        this.h = new p(r10, "title", null);
    }
}
