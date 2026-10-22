package com.bytedance.android.annie.lynx.resource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements k7a.a.a {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;
    public final /* synthetic */ k7a.a.a c;

    public e(d r1, String r10, k7a.a.a r11) {
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
        this.a.b(this.b, this.c);
    }
}
