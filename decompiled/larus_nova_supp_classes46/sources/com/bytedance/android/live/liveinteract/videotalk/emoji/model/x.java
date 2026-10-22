package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x implements am3.c<TalkRoomEmojiPermission> {
    public x() {
    }

    public static TalkRoomEmojiPermission a(am3.g r5) throws Exception {
        TalkRoomEmojiPermission r0 = new TalkRoomEmojiPermission();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L18;
        if (r3 != 1) goto L8;
        r0.hasPermission = am3.h.a(r5);
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.toastWithoutPermission = am3.h.c(r5);
        goto L3
    L10:
        if (r3 != 3) goto L12;
        r0.bottomText = am3.h.c(r5);
        goto L3
    L12:
        if (r3 != 4) goto L13;
        r0.schemaJumpUrl = am3.h.c(r5);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
