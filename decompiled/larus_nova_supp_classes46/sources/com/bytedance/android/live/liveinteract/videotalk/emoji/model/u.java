package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u implements am3.c<InteractEmojiAnim> {
    public u() {
    }

    public final Object decode(am3.g r6) throws Exception {
        InteractEmojiAnim r0 = new InteractEmojiAnim();
        r0.getDelegate().setThreadSafe(false);
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L18;
        am3.g.a r4 = r0.getDelegate().decodeExtensionFields(r3, r6);
        switch(r3) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        r0.reshapeStart = Long.valueOf(r6.j());
        goto L3
    L9:
        r0.soundUrl = am3.h.c(r6);
        goto L3
    L10:
        r0.reshape = am3.h.a(r6);
        goto L3
    L11:
        r0.sizeScale = r6.j();
        goto L3
    L12:
        r0.offset = r6.j();
        goto L3
    L13:
        r0.extraDuration = r6.j();
        goto L3
    L14:
        r0.extraDynamicImage = (py.k) vh7.f.a(r6, py.k.class);
        goto L3
    L15:
        r0.start = r6.j();
        goto L3
    L16:
        r0.duration = r6.j();
        goto L3
    L17:
        r0.dynamicImage = (py.k) vh7.f.a(r6, py.k.class);
        goto L3
    L7:
        am3.h.d(r4, r6);
        goto L3
    L18:
        r6.d(r1);
        r0.getDelegate().setThreadSafe(true);
        return r0;
    }
}
