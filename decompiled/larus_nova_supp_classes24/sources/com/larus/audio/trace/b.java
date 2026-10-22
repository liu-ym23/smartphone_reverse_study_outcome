package com.larus.audio.trace;

import com.larus.audio.u0;
import hq9.v;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import m58.h;
import m58.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements u0 {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // com.larus.audio.u0
    public final void a(v r7) {
        c r0 = c.a;
        String r1 = r7.d;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.e(r1);
        if (Intrinsics.areEqual(r7.g, "speak") == true) goto L36;
        String r3 = r7.d;
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        JSONObject r4 = new JSONObject();
        String r5 = r7.a;
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        r4.put("bot_id", r5);
        String r6 = r7.b;
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        r4.put("chat_type", r6);
        String r8 = r7.c;
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        r4.put("conversation_id", r8);
        String r9 = r7.d;
        if (r9 != null) goto L22;
        r9 = "";
    L22:
        r4.put("local_msg_id", r9);
        String r10 = r7.d;
        if (r10 != null) goto L25;
        r10 = "";
    L25:
        r4.put("asr_task_id", r10);
        String r11 = r7.g;
        if (r11 != null) goto L28;
        r11 = "";
    L28:
        r4.put("scene", r11);
        Unit r12 = Unit.INSTANCE;
        r0.a(r3, r4);
        u r13 = h.l;
        if (r13 == null) goto L37;
        String r14 = r7.d;
        if (r14 == null) goto L34;
        r2 = r14;
    L34:
        r13.f(r2, "tts_touch_up_to_chat_first_pkg", null);
        return;
    L37:
        return;
    }
}
