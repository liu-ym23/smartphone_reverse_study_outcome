package com.obric.assistant.util;

import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.audio.audiov3.task.asr.AsrResultValue;
import com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k2 implements com.larus.bmhome.chat.component.bottom.core.speaker.b {
    public boolean a;

    public k2() {
        this.a = true;
    }

    public final void a(y58.b r2) {
        Intrinsics.checkNotNullParameter(r2, WindowEvent.Params.RESULT);
    }

    public final void q(AsrLifeState r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r3, "lifeState");
        if (r3 == AsrLifeState.ASR_RESULT) goto L5;
        this.a = true;
        return;
    L5:
        if (r5 == null) goto L7;
        String r6 = r5.get("res_text");
    L8:
        if (r5 == null) goto L10;
        String r7 = r5.get("res_type");
    L12:
        if (Intrinsics.areEqual(r7, AsrResultValue.FINAL_ASR.getValue()) == false) goto L20;
        if (com.larus.utils.o0.d(r6) == false) goto L20;
        IAgentVoiceInteractionIDL r8 = com.obric.aiagent.assistant.idl.u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r8 == null) goto L18;
        r8.onAsrEnd();
    L18:
        this.a = true;
        return;
    L20:
        if (this.a == true) goto L22;
        return;
    L22:
        if (com.larus.utils.o0.d(r6) == false) goto L30;
        this.a = false;
        IAgentVoiceInteractionIDL r9 = com.obric.aiagent.assistant.idl.u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r9 == null) goto L31;
        r9.onAsrStart(null);
        return;
    L31:
        return;
    L30:
        return;
    L10:
        r7 = null;
        goto L12
    L7:
        r6 = null;
        goto L8
    }
}
