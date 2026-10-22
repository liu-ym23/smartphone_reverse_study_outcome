package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v implements am3.c<TalkRoomDigitAvatarEmoji> {
    public v() {
    }

    public static TalkRoomDigitAvatarEmoji a(am3.g r5) throws Exception {
        TalkRoomDigitAvatarEmoji r0 = new TalkRoomDigitAvatarEmoji();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.actionID = (int) r5.j();
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
