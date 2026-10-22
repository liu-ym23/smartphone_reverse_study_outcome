package com.larus.api.provider;

import qr9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class SdkVideoFeedProvider$a implements b {
    public final /* synthetic */ p54.b a;

    public final boolean a() {
        p54.b r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    public final void pausePlayer() {
        p54.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.pausePlayer();
        return;
    }

    public final void playPlayer() {
        p54.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.playPlayer();
        return;
    }

    public SdkVideoFeedProvider$a(p54.b r1) {
        this.a = r1;
    }
}
