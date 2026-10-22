package com.larus.asr.session.component;

import com.larus.audio.AudioServiceDelegate;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class u0 extends h {
    @Override // com.larus.asr.session.component.h
    public final void g() {
        this.a.onAsrStart(this.b);
    }

    @Override // com.larus.asr.session.component.h
    public final void h() {
        this.c.e(com.larus.bmhome.chat.component.bottom.core.speaker.g.c.a);
        this.a.vb();
    }

    @Override // com.larus.asr.session.component.h
    public final void e(b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        r2.d.invoke();
    }

    public u0(com.larus.asr.session.p r2, String r3, f0 r4, e r5) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "sessionTaskId");
        Intrinsics.checkNotNullParameter(r4, "asrContext");
        Intrinsics.checkNotNullParameter(r5, "config");
        super(r2, r3, r4, r5);
    }

    @Override // com.larus.asr.session.component.h
    public final void f(String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "engineTaskId");
        Intrinsics.checkNotNullParameter(r5, "botId");
        Intrinsics.checkNotNullParameter(r6, "chatType");
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        com.larus.audio.v0 r0 = AudioServiceDelegate.a.N();
        JSONObject r1 = new JSONObject();
        r1.put("bot_id", r5);
        r1.put("chat_type", r6);
        r1.put("conversation_id", r7);
        r1.put("local_message_id", r4);
        r1.put("asr_task_id", r4);
        r1.put("scene", "speak");
        Unit r8 = Unit.INSTANCE;
        r0.a(r4, r1);
    }
}
