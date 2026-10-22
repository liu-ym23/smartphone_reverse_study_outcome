package com.bytedance.android.live.livelink.guestlink.media;

import fr2.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements u {
    public final /* synthetic */ GuestLinkMediaManager a;

    public final void X1(int r1, int r2, Exception r3) {
    }

    public b(GuestLinkMediaManager r1) {
        this.a = r1;
    }

    public final void q2(int r1, int r2, int r3) {
        if (r1 != 8) goto L5;
        jy0.b.d("GuestLinkMediaManager", "MSG_INFO_AUDIO_STARTED_CAPTURE");
        ob6.a.a r4 = this.a.k;
        if (r4 == null) goto L23;
        r4.s();
        return;
    L23:
        return;
    L5:
        if (r1 != 9) goto L7;
        jy0.b.d("GuestLinkMediaManager", "MSG_INFO_AUDIO_STOPED_CAPTURE");
        ob6.a.a r5 = this.a.k;
        if (r5 == null) goto L21;
        r5.s();
        return;
    L21:
        return;
    L7:
        if (r1 != 30) goto L24;
        jy0.b.d("GuestLinkMediaManager", "MSG_INFO_CAPTURE_FIRST_FRAME");
        ob6.a.a r6 = this.a.k;
        if (r6 == null) goto L19;
        r6.t();
        return;
    L19:
        return;
    }
}
