package com.obric.assistant.spi.notification;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/assistant/spi/notification/DefaultObricNotificationIslandServiceImpl;", "Lcom/obric/assistant/spi/notification/IObricNotificationIslandService;", "<init>", "()V", "getKeepAlarmList", "", "", "onVoiceWakeupSessionGenerated", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricNotificationIslandServiceImpl implements IObricNotificationIslandService {
    public DefaultObricNotificationIslandServiceImpl() {
    }

    @Override // com.obric.assistant.spi.notification.IObricNotificationIslandService
    public final void b() {
    }

    @Override // com.obric.assistant.spi.notification.IObricNotificationIslandService
    public final List<String> a() {
        return CollectionsKt.emptyList();
    }
}
