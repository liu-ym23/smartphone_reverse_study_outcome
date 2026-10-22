package com.obric.aiagent.product.platform.api.notification;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/obric/aiagent/product/platform/api/notification/IObricNotificationManager;", "", "registerNotificationListener", "", "listener", "Lcom/obric/aiagent/product/platform/api/notification/ObricNotificationListener;", "unregisterNotificationListener", "registerToastShowListener", "Lcom/obric/aiagent/product/platform/api/notification/ObricToastShowListener;", "unregisterToastShowListener", "isPanelShown", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IObricNotificationManager {
    boolean isPanelShown();

    boolean registerNotificationListener(ObricNotificationListener r1);

    boolean registerToastShowListener(ObricToastShowListener r1);

    boolean unregisterNotificationListener(ObricNotificationListener r1);

    boolean unregisterToastShowListener(ObricToastShowListener r1);
}
