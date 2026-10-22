package com.larus.bmhome.music.player;

import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.l4;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b0 implements l4 {
    public final /* synthetic */ StreamingMusicPlayer a;

    public b0(StreamingMusicPlayer r1) {
        this.a = r1;
    }

    public final void a(String r14, com.larus.video.impl.sdk.a r15) {
        if (r15 == null) goto L26;
        StreamingMusicPlayer r16 = this.a;
        Lazy r0 = q3.a;
        z3 r1 = q3.a();
        k r2 = null;
        if (r1 == null) goto L6;
        Integer r17 = Integer.valueOf(r1.e(r15));
    L7:
        FLogger.a.i("StreamingMusicPlayer", "try refresh total refreshed " + r17);
        if (r17 == null) goto L27;
        k r4 = r16.e;
        float r3 = r17.intValue();
        float r5 = GuidePriority.COMMERCE_CREDIT_PRIORITY;
        k r6 = k.a(r4, null, null, r3 * r5, 0.0f, false, false, 0, 251);
        r16.e = r6;
        String r7 = r6.b;
        k r8 = StreamingMusicPlayer.p;
        if (r8 == null) goto L12;
        String r9 = r8.b;
    L13:
        j r18 = r16.c;
        if (r18 == null) goto L18;
        Message r19 = r18.j;
        if (r19 == null) goto L18;
        Boolean r110 = Boolean.valueOf(r19.isNewBlockType());
    L20:
        if (c0.a(r7, r9, r110) == false) goto L28;
        k r10 = StreamingMusicPlayer.p;
        if (r10 == null) goto L24;
        r2 = k.a(r10, null, null, r17.intValue() * r5, 0.0f, false, false, 0, 251);
    L24:
        StreamingMusicPlayer.p = r2;
        return;
    L28:
        return;
    L18:
        r110 = null;
        goto L20
    L12:
        r9 = null;
        goto L13
    L27:
        return;
    L6:
        r17 = null;
        goto L7
    }
}
