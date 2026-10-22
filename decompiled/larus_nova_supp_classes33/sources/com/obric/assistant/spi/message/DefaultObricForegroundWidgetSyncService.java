package com.obric.assistant.spi.message;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/spi/message/DefaultObricForegroundWidgetSyncService;", "Lcom/obric/assistant/spi/message/IObricForegroundWidgetSyncService;", "<init>", "()V", "awaitWidgetUpdatesBeforeConversationPull", "", "conversationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricForegroundWidgetSyncService implements IObricForegroundWidgetSyncService {
    public DefaultObricForegroundWidgetSyncService() {
    }

    @Override // com.obric.assistant.spi.message.IObricForegroundWidgetSyncService
    public final Object a(String r1, Continuation<? super Unit> r2) {
        return Unit.INSTANCE;
    }
}
