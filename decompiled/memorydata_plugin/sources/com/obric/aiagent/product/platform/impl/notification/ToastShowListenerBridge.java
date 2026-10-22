package com.obric.aiagent.product.platform.impl.notification;

import android.app.AssistantNotificationManager;
import android.app.ObricNotificationManager;
import com.obric.aiagent.product.platform.api.notification.ObricToastShowListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J.\u0010\u000b\u001a\u00020\u00052\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/notification/ToastShowListenerBridge;", "", "<init>", "()V", "register", "", "listener", "Lcom/obric/aiagent/product/platform/api/notification/ObricToastShowListener;", "unregister", "registerAssistant", "unregisterAssistant", "invoke", "managerClass", "Ljava/lang/Class;", "listenerClassName", "", "methodName", "listenerStub", "OBRIC_TOAST_LISTENER_CLASS", "ASSISTANT_TOAST_LISTENER_CLASS", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ToastShowListenerBridge {
    private static final String ASSISTANT_TOAST_LISTENER_CLASS = "android.app.AssistantNotificationManager$OnToastShowListener";
    public static final ToastShowListenerBridge INSTANCE = null;
    private static final String OBRIC_TOAST_LISTENER_CLASS = "android.app.ObricNotificationManager$OnToastShowListener";

    static {
        INSTANCE = new ToastShowListenerBridge();
    }

    private ToastShowListenerBridge() {
    }

    private final boolean invoke(Class<?> r3, String r4, String r5, Object r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        r3.getMethod(r5, new Class[]{ZeusTransformUtils.forName(r4, "com.obric.memorydata.plugin")}).invoke(null, new Object[]{r6});
        return true;
    }

    public final boolean register(ObricToastShowListener r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        return invoke(ObricNotificationManager.class, OBRIC_TOAST_LISTENER_CLASS, "registerToastShowListener", r4.getObricStub());
    }

    public final boolean registerAssistant(ObricToastShowListener r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        return invoke(AssistantNotificationManager.class, ASSISTANT_TOAST_LISTENER_CLASS, "registerToastShowListener", r4.getAssistantStub());
    }

    public final boolean unregister(ObricToastShowListener r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        return invoke(ObricNotificationManager.class, OBRIC_TOAST_LISTENER_CLASS, "unregisterToastShowListener", r4.getObricStub());
    }

    public final boolean unregisterAssistant(ObricToastShowListener r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        return invoke(AssistantNotificationManager.class, ASSISTANT_TOAST_LISTENER_CLASS, "unregisterToastShowListener", r4.getAssistantStub());
    }
}
