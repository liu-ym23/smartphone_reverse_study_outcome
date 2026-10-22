package com.bytedance.android.anniex.web;

import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.kit.web.WebEngineGlobalConfig;
import com.bytedance.ies.bullet.secure.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements i {
    public final /* synthetic */ AnnieXWebModel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ AnnieXWebKit c;
    public final /* synthetic */ m16.b d;
    public final /* synthetic */ boolean e;

    public final com.bytedance.ies.bullet.kit.web.d a() {
        WebEngineGlobalConfig r0 = this.c.B;
        if (r0 == null) goto L7;
        e26.b r1 = r0.e;
        if (r1 == null) goto L7;
        return r1.N(this.d);
    L7:
        return null;
    }

    public final Boolean b() {
        return Boolean.valueOf(this.e);
    }

    public BulletContext getContext() {
        AnnieXWebModel r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    public final String c() {
        return this.b;
    }

    public c(AnnieXWebModel r1, String r10, AnnieXWebKit r11, m16.b r12, boolean r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }
}
