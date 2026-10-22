package com.ss.android.account;

import android.text.TextUtils;
import com.bytedance.sdk.account.impl.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements sgc.a, ta7.c {
    public static volatile b c;
    public boolean a;
    public String b;

    public static b z0() {
        if (c != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public b() {
        this.a = false;
        this.b = "";
        j.m(k.d().getApplicationContext()).d(this);
        String r0 = getSecUid();
        this.b = r0;
        this.a = !TextUtils.isEmpty(r0);
    }

    @Override // sgc.a
    public final String getSecUid() {
        return j.m(k.d().getApplicationContext()).getSecUserId();
    }

    public final void M(ta7.b r3) {
        int r4 = r3.a;
        if (r4 != 1) goto L5;
    L17:
        this.a = false;
        this.b = "";
        rgc.c.a(new tgc.b());
        return;
    L5:
        if (r4 == 2) goto L17;
        if (this.a == true) goto L13;
        String r5 = getSecUid();
        if (this.a == true) goto L21;
        rgc.c.a(new tgc.a(r5));
        this.b = r5;
        this.a = true;
        return;
    L21:
        return;
    L13:
        String r6 = getSecUid();
        if (this.b.equals(r6) == true) goto L22;
        this.b = r6;
        rgc.c.a(new tgc.c(r6));
        return;
    }

    @Override // sgc.a
    public final void r0(sgc.a.a r2) {
        new gc7.c(new a(this, r2)).b();
    }
}
