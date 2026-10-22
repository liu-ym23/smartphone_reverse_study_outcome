package com.larus.bmhome.chat.component.bottom.core.speaker;

import com.larus.asr.VoiceInputType;
import com.larus.audio.asr.c0;
import com.obric.assistant.component.clicktalk.x;
import com.obric.assistant.component.m2;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l$a {
    public static /* synthetic */ void b(l r3, Function1 r4) {
        r3.la(new i(), new j(), new k(), r4);
    }

    public static /* synthetic */ String a(l r13, boolean r14, boolean r15, VoiceInputType r16, boolean r17, c0 r18, Integer r19, Long r20, x r21, Map r22, m2 r23, int r24) {
        if ((r24 & 4) == 0) goto L5;
        VoiceInputType r5 = VoiceInputType.TouchSpeaker;
    L7:
        if ((r24 & 8) == 0) goto L9;
        boolean r6 = true;
    L11:
        if ((r24 & 16) == 0) goto L13;
        c0 r7 = new c0(null, null, 0, 255);
    L15:
        if ((r24 & 32) == 0) goto L17;
        Integer r8 = null;
    L19:
        if ((r24 & 64) == 0) goto L21;
        Long r9 = null;
    L23:
        if ((r24 & 128) == 0) goto L25;
        x r10 = null;
    L27:
        if ((r24 & 256) == 0) goto L29;
        Map r11 = null;
    L31:
        if ((r24 & 512) == 0) goto L33;
        m2 r12 = null;
    L35:
        return r13.LT(r14, r15, r5, r6, r7, r8, r9, r10, r11, r12);
    L33:
        r12 = r23;
        goto L35
    L29:
        r11 = r22;
        goto L31
    L25:
        r10 = r21;
        goto L27
    L21:
        r9 = r20;
        goto L23
    L17:
        r8 = r19;
        goto L19
    L13:
        r7 = r18;
        goto L15
    L9:
        r6 = r17;
        goto L11
    L5:
        r5 = r16;
        goto L7
    }
}
