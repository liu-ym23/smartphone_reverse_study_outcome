package com.obric.assistant.impl;

import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.spi.chat.IObricChatExtensionService;
import com.obric.assistant.util.e2;
import hca.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J8\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/impl/ObricChatExtensionServiceImpl;", "Lcom/obric/assistant/spi/chat/IObricChatExtensionService;", "<init>", "()V", "getIObricStateExtensionCallback", "Lcom/obric/assistant/callback/IObricStateExtensionCallback;", "getObricPromptContent", "", "message", "Lcom/larus/im/bean/message/Message;", "suggestItems", "", "isNoDisappear", "", "suggestActionCardCnt", "", "onboardingDisplayStyle", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatExtensionServiceImpl implements IObricChatExtensionService {
    public ObricChatExtensionServiceImpl() {
    }

    @Override // com.obric.assistant.spi.chat.IObricChatExtensionService
    public final c a() {
        if (ObricFeatureServiceDelegate.b.c() == true) goto L7;
        return null;
    L7:
        return new e2();
    }
}
