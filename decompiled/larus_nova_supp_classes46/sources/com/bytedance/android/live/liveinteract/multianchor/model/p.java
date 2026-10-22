package com.bytedance.android.live.liveinteract.multianchor.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p implements am3.c<MicDress> {
    public p() {
    }

    public final Object decode(am3.g r7) throws Exception {
        MicDress r0 = new MicDress();
        r0.setThreadSafe(false);
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L15;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r7);
        if (r3 != 2) goto L8;
        r0.voiceWave = (MicDress.VoiceWave) vh7.f.a(r7, MicDress.VoiceWave.class);
        goto L3
    L8:
        if (r3 != 3) goto L10;
        r0.badge = (MicDress.LinkmicBadge) vh7.f.a(r7, MicDress.LinkmicBadge.class);
        goto L3
    L10:
        if (r3 != 4) goto L11;
        r0.linkmicCustomizedRandomEmoji = o.a(r7);
        goto L3
    L11:
        am3.h.d(r4, r7);
        goto L3
    L15:
        r7.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }
}
