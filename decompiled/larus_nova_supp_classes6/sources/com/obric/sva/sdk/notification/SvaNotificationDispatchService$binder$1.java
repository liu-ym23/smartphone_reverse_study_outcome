package com.obric.sva.sdk.notification;

import com.obric.assistant.spi.notification.IObricInteractorNotificationCallback;
import com.obric.assistant.spi.notification.IObricInteractorNotificationService;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/sva/sdk/notification/SvaNotificationDispatchService$binder$1", "Lcom/obric/assistant/spi/notification/IObricInteractorNotificationService$Stub;", "registerCallback", "", "callback", "Lcom/obric/assistant/spi/notification/IObricInteractorNotificationCallback;", "unregisterCallback", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SvaNotificationDispatchService$binder$1 extends IObricInteractorNotificationService.Stub {
    public SvaNotificationDispatchService$binder$1() {
    }

    public void registerCallback(IObricInteractorNotificationCallback r2) {
        SvaNotificationDispatchService$Dispatcher.INSTANCE.registerCallback(r2);
    }

    public void unregisterCallback(IObricInteractorNotificationCallback r2) {
        SvaNotificationDispatchService$Dispatcher.INSTANCE.unregisterCallback(r2);
    }
}
