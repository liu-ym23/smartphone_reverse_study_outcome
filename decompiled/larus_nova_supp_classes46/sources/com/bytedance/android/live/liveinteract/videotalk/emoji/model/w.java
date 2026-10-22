package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w implements am3.c<r> {
    public w() {
    }

    public static r a(am3.g r5) throws Exception {
        r r0 = new r();
        r0.getDelegate().setThreadSafe(false);
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L27;
        am3.g.a r4 = r0.getDelegate().decodeExtensionFields(r3, r5);
        switch(r3) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L13;
            case 15: goto L12;
            case 16: goto L11;
            case 17: goto L7;
            case 18: goto L10;
            case 19: goto L9;
            case 20: goto L8;
            default: goto L7;
        };
    L8:
        r0.customizedRandomResource = (a) vh7.f.a(r5, a.class);
        goto L3
    L9:
        r0.disable = am3.h.a(r5);
        goto L3
    L10:
        r0.emojiLabel = am3.h.c(r5);
        goto L3
    L11:
        r0.emojiStatus = r5.i();
        goto L3
    L12:
        r0.emojiTag = t.a(r5);
        goto L3
    L13:
        r0.needReverse = am3.h.a(r5);
        goto L3
    L14:
        r0.digitAvatarEmojiData = v.a(r5);
        goto L3
    L15:
        r0.emojiCategory = r5.i();
        goto L3
    L16:
        r0.interactEmoji = (TalkRoomInteractEmoji) vh7.f.a(r5, TalkRoomInteractEmoji.class);
        goto L3
    L17:
        r0.emojiSoundUrl = am3.h.c(r5);
        goto L3
    L18:
        r0.emojiPermission = x.a(r5);
        goto L3
    L19:
        r0.emojiType = r5.i();
        goto L3
    L20:
        r0.emojiResultShowDuration = r5.j();
        goto L3
    L21:
        r0.animationDuration = r5.j();
        goto L3
    L22:
        r0.emojiName = am3.h.c(r5);
        goto L3
    L23:
        r0.emojiDynamicImage = (py.k) vh7.f.a(r5, py.k.class);
        goto L3
    L24:
        r0.emojiImage = (py.k) vh7.f.a(r5, py.k.class);
        goto L3
    L25:
        r0.isRandomEmoji = am3.h.a(r5);
        goto L3
    L26:
        r0.emojiId = r5.j();
        goto L3
    L7:
        am3.h.d(r4, r5);
        goto L3
    L27:
        r5.d(r1);
        r0.getDelegate().setThreadSafe(true);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
