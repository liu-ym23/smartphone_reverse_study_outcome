package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.tts.TtsScene;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x1$b {
    public static /* synthetic */ Object b(x1 r11, Message r12, SpeakerVoice r13, boolean r14, String r15, String r16, TtsScene r17, Continuation r18, int r19) {
        if ((r19 & 2) == 0) goto L5;
        SpeakerVoice r4 = null;
    L7:
        if ((r19 & 4) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r19 & 8) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r19 & 32) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r19 & 64) == 0) goto L21;
        TtsScene r9 = null;
    L23:
        return r11.j6(r12, r4, r5, r6, null, r8, r9, r18);
    L21:
        r9 = r17;
        goto L23
    L17:
        r8 = r16;
        goto L19
    L13:
        r6 = r15;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    public static /* synthetic */ Object a(x1 r14, Message r15, String r16, String r17, String r18, boolean r19, JSONObject r20, TtsScene r21, String r22, Continuation r23, int r24) {
        if ((r24 & 8) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r24 & 16) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r24 & 32) == 0) goto L13;
        boolean r9 = false;
    L15:
        if ((r24 & 64) == 0) goto L17;
        JSONObject r10 = null;
    L19:
        if ((r24 & 128) == 0) goto L21;
        TtsScene r11 = null;
    L23:
        if ((r24 & 256) == 0) goto L25;
        String r12 = null;
    L27:
        return r14.m6(r15, r16, r17, r7, r8, r9, r10, r11, r12, r23);
    L25:
        r12 = r22;
        goto L27
    L21:
        r11 = r21;
        goto L23
    L17:
        r10 = r20;
        goto L19
    L13:
        r9 = r19;
        goto L15
    L9:
        r8 = r18;
        goto L11
    L5:
        r7 = "long_press_play";
        goto L7
    }
}
