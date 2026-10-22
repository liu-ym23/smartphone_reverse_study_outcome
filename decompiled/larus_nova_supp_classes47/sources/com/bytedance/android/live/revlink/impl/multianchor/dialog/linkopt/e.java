package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public String a;
    public String b;
    public String c;
    public String d;
    public final com.bytedance.android.live.revlink.impl.global.c e;

    public final String a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.e;
        f r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.service.internal.a r2 = r0.Do();
    L6:
        if (r2 == null) goto L8;
        int r3 = r2.getCurrentMode();
    L10:
        if (com.bytedance.android.live.utils.c.a(r3, 4) == false) goto L12;
    L24:
        return "pk";
    L12:
        if (com.bytedance.android.live.utils.c.a(r3, 64) == false) goto L21;
        com.bytedance.android.live.revlink.impl.global.c r4 = this.e;
        if (r4 == null) goto L16;
        r1 = r4.getLinkPlayHelper();
    L16:
        if (r1 == null) goto L21;
        if (r1.g() == true) goto L24;
    L21:
        if (com.bytedance.android.live.utils.c.a(r3, 64) == false) goto L23;
        return "connection";
    L23:
        return "live";
    L8:
        r3 = 0;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public e(LinkFakeGlobalService r1) {
        this.e = r1;
        this.a = "link_participate";
        this.b = "live_pk_icon";
        this.c = "";
        this.d = "";
    }

    public final void b(String r4) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        this.c = r4;
    L12:
        if (this.c.length() <= 0) goto L14;
        r0 = true;
    L14:
        if (r0 == false) goto L16;
        return;
    L16:
        com.bytedance.android.live.revlink.impl.global.c r5 = this.e;
        f r1 = null;
        if (r5 == null) goto L19;
        f r6 = r5.getLinkPlayHelper();
    L20:
        if (r6 != null) goto L22;
    L24:
        com.bytedance.android.live.revlink.impl.global.c r7 = this.e;
        if (r7 == null) goto L27;
        r1 = r7.getLinkPlayHelper();
    L27:
        if (r1 != null) goto L29;
    L31:
        String r8 = "link_participate";
    L32:
        this.c = r8;
        return;
    L29:
        if (r1.c() != true) goto L31;
        r8 = "pk_participate";
        goto L32
    L22:
        if (r6.d() != true) goto L24;
        r8 = "pve_participate";
        goto L32
    L19:
        r6 = null;
        goto L20
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void c(int r2) {
        if (r2 != 20) goto L6;
        this.a = "relink_team";
        this.c = "relink_team";
    L6:
        if (r2 != 21) goto L9;
        this.a = "relink_tab";
        this.c = "relink_tab";
        return;
    }
}
