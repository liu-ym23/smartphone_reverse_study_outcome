package com.obric.assistant.component.clicktalk;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.IdleQuiteServiceDelegate;
import com.obric.assistant.voice.ContentScene;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ ChatClickTalkComponent a;
    public final /* synthetic */ String b;

    public /* synthetic */ n(ChatClickTalkComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatClickTalkComponent r0 = this.a;
        String r1 = this.b;
        int r2 = ChatClickTalkComponent.L0;
        FLogger.a.i("ChatClickTalkComponent", "startIdleQuiteService timer " + r0.P + " -- " + r0.Q);
        IdleQuiteServiceDelegate r3 = IdleQuiteServiceDelegate.b;
        Pair[] r4 = new Pair[2];
        r4[0] = TuplesKt.to("wakeupFrom", Integer.valueOf(r0.P));
        Map r5 = r0.Q;
        String r6 = null;
        if (r5 == null) goto L5;
        Object r7 = r5.get("scene");
    L7:
        if ((r7 instanceof String) == false) goto L9;
        r6 = (String) r7;
    L9:
        if (r6 != null) goto L11;
        r6 = ContentScene.UNKNOWN.getStr();
    L11:
        r4[1] = TuplesKt.to("scene", r6);
        r3.d(r1, MapsKt.mutableMapOf(r4));
        r3.b(r0.H0);
        return;
    L5:
        r7 = null;
        goto L7
    }
}
