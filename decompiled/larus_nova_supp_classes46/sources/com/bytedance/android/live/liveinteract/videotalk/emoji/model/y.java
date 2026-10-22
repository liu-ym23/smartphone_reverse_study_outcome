package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y implements am3.c<TalkRoomInteractEmoji> {
    public y() {
    }

    public static TalkRoomInteractEmoji a(am3.g r6) throws Exception {
        TalkRoomInteractEmoji r0 = new TalkRoomInteractEmoji();
        r0.setThreadSafe(false);
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L15;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r6);
        if (r3 != 1) goto L8;
        r0.senderEmoji = (InteractEmojiAnim) vh7.f.a(r6, InteractEmojiAnim.class);
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.pathEmoji = (InteractEmojiAnim) vh7.f.a(r6, InteractEmojiAnim.class);
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.receiverEmoji = (InteractEmojiAnim) vh7.f.a(r6, InteractEmojiAnim.class);
        goto L3
    L11:
        am3.h.d(r4, r6);
        goto L3
    L15:
        r6.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
