package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.obric.assistant.audio.service.IObricIntentStatusService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FlowUIIDLStub$c implements IIMCallback<Message> {
    public final /* synthetic */ String a;

    public final boolean mustInMain() {
        return true;
    }

    public FlowUIIDLStub$c(String r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final void onSuccess(Object r4) {
        Message r5 = (Message) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        String r6 = r5.getConversationId();
        if (r6 == null) goto L8;
        String r0 = this.a;
        IObricIntentStatusService r1 = (IObricIntentStatusService) ServiceManager.get().getService(IObricIntentStatusService.class);
        if (r1 == null) goto L9;
        r1.a(r6, r0);
        return;
    L9:
        return;
    }
}
