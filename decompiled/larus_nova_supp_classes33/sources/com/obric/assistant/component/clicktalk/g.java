package com.obric.assistant.component.clicktalk;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.IObricAssistant;
import com.obric.assistant.voice.ContentScene;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class g implements Function1 {
    public final /* synthetic */ com.obric.assistant.voice.a a;
    public final /* synthetic */ ChatClickTalkComponent b;

    public /* synthetic */ g(com.obric.assistant.voice.a r1, ChatClickTalkComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r6) {
        com.obric.assistant.voice.a r0 = this.a;
        ChatClickTalkComponent r1 = this.b;
        int r2 = ChatClickTalkComponent.L0;
        FLogger.a.i("ChatClickTalkComponent", "onAsrResult.. quitGUI caused by FAILED [reason: " + ((String) r6) + "] ，THEN QUIT GUI");
        if (r0.a != ContentScene.PRIORITY_NOTIFICATION) goto L8;
        r1.getClass();
        IObricAssistant r7 = (IObricAssistant) ServiceManager.get().getService(IObricAssistant.class);
        if (r7 == null) goto L8;
        r7.finishChatPage();
    L8:
        return Unit.INSTANCE;
    }
}
