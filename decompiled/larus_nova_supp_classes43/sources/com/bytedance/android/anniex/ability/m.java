package com.bytedance.android.anniex.ability;

import com.bytedance.android.anniex.web.model.AnnieXWebModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m implements ue7.b {
    public final /* synthetic */ AnnieXWebModel a;

    public final String a() {
        t36.j r0 = this.a.h;
        if (r0 == null) goto L11;
        t36.d r1 = r0.a;
        if (r1 == null) goto L12;
        String r10 = (String) ((y36.i) new y36.p(r1, com.bytedance.android.ec.core.event.a.KEY_APP_ID, "")).b;
        if (r10 != null) goto L10;
        return "";
    L10:
        return r10;
    L12:
        return "";
    L11:
        return "";
    }

    public m(AnnieXWebModel r1) {
        this.a = r1;
    }
}
