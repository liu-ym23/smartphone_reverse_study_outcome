package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.r;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.textmessage.model.AudioChatTextMessage;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import gd0.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(kc2.a r3, com.bytedance.android.livesdk.interactivity.api.entity.f r4) {
        if (r3 == null) goto L18;
        if (r4 != null) goto L7;
        return false;
    L7:
        if (r4.b != 0) goto L10;
        return false;
    L10:
        if ((r4 instanceof AudioChatTextMessage) == true) goto L12;
        return false;
    L12:
        AudioChatTextMessage r5 = (AudioChatTextMessage) r4;
        if (TextUtils.equals(r3.updatePath, r5.b.getAudioPath()) == false) goto L15;
    L16:
        return true;
    L15:
        if (TextUtils.equals(r3.updatePath, r5.b.getAudioUrl()) == true) goto L16;
        return false;
    L18:
        return false;
    }

    public static void b(kc2.a r4, com.bytedance.android.livesdk.interactivity.api.entity.f r5) {
        if (r4 == null) goto L48;
        if (r5 != null) goto L6;
        return;
    L6:
        if ((r5 instanceof AudioChatTextMessage) == true) goto L8;
        return;
    L8:
        r r0 = r5.b;
        if ((r0 instanceof r) == true) goto L11;
        r0 = null;
    L11:
        r r1 = r0;
        if (r1 != null) goto L15;
    L17:
        r r6 = ((AudioChatTextMessage) r5).b;
        if (r6 != null) goto L21;
        return;
    L21:
        if (v.a(r4.updateField, 2) == false) goto L24;
        r6.setReadStatus(r4.readStatus);
    L24:
        if (v.a(r4.updateField, 1) == false) goto L27;
        r6.setSendStatus(r4.sendStatus);
    L27:
        if (v.a(r4.updateField, 4) == false) goto L39;
        r6.setMsgId(r4.msgId);
        m0 r2 = r6.getBaseMessage();     // Catch: NumberFormatException -> L37
        if (r2 == null) goto L39;
        String r3 = r4.msgId;     // Catch: NumberFormatException -> L37
        if (r3 == null) goto L34;
        long r7 = CastLongProtector.parseLong(r3);     // Catch: NumberFormatException -> L37
    L35:
        r2.setMessageId(r7);     // Catch: NumberFormatException -> L37
        goto L39
    L34:
        r7 = 0;
    L37:
        boolean r8 = TextMessageTracer.a;
        TextMessageTracer.A("updateAudioMessage number format error");
    L39:
        if (v.a(r4.updateField, 8) == false) goto L42;
        r6.setRtfContent(r4.getRtfContent());
        r6.setContent(r4.content);
    L42:
        if (v.a(r4.updateField, 16) == false) goto L44;
        r6.setUserInfo(r4.userInfo);
    L44:
        r6.setMessageIdentity(r4.getMessageIdentity());
        return;
    L15:
        if (v.a(r4.updateField, 16) == false) goto L17;
        r5.F = null;
        r1.setUserInfo(r4.userInfo);
        goto L17
    }
}
