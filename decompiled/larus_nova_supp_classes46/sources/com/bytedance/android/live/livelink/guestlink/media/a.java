package com.bytedance.android.live.livelink.guestlink.media;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements sq2.a {
    public final /* synthetic */ GuestLinkMediaManager a;

    public a(GuestLinkMediaManager r1) {
        this.a = r1;
    }

    public final void a(boolean r3) {
        jy0.b.d("GuestLinkMediaManager", "appEnterBackground, background: " + r3);
        if (r3 == false) goto L12;
        GuestLinkMediaManager r4 = this.a;
        r4.m = true;
        jy0.b.d("GuestLinkMediaManager", "pause");
        if (r4.f == false) goto L21;
        jy0.b.d("GuestLinkMediaManager", "pause start");
        ei6.a r0 = r4.c;
        if (r0 == null) goto L9;
        r0.pause();
    L9:
        ob6.a.a r5 = r4.k;
        if (r5 == null) goto L22;
        r5.c();
        return;
    L22:
        return;
    L21:
        return;
    L12:
        GuestLinkMediaManager r6 = this.a;
        r6.m = false;
        jy0.b.d("GuestLinkMediaManager", "resume");
        if (r6.f == false) goto L24;
        jy0.b.d("GuestLinkMediaManager", "resume start");
        ei6.a r1 = r6.c;
        if (r1 == null) goto L17;
        r1.resume();
    L17:
        ob6.a.a r7 = r6.k;
        if (r7 == null) goto L25;
        r7.c();
        return;
    L25:
        return;
    }
}
