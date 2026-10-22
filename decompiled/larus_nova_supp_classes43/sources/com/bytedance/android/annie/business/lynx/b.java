package com.bytedance.android.annie.business.lynx;

import com.bytedance.ies.bullet.lynx.resource.DefaultDynamicComponentFetcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements k7a.a.a {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ k7a.a.a c;

    public b(a r1, String r10, k7a.a.a r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final void a(byte[] r10, Throwable r11) {
        if (r11 != null) goto L14;
        if (r10 == null) goto L14;
        if (r10.length != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L14;
        k7a.a.a r1 = this.c;
        if (r1 == null) goto L16;
        r1.a(r10, r11);
        return;
    L16:
        return;
    L7:
        r0 = false;
    L14:
        ((DefaultDynamicComponentFetcher) this.a).c.loadDynamicComponent(this.b, this.c);
    }
}
