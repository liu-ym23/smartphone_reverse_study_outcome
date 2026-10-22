package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import java.util.Map;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements Function2<Boolean, Map<String, ? extends String>, Boolean> {
    public final /* synthetic */ AiAgentPSSelectedMsgView a;

    public g(AiAgentPSSelectedMsgView r1) {
        this.a = r1;
    }

    public final Object invoke(Object r1, Object r2) {
        Map<String, String> r3 = (Map) r2;
        if (((Boolean) r1).booleanValue() == true) goto L6;
        this.a.n(r3);
    L6:
        return Boolean.TRUE;
    }
}
