package com.obric.aiagent.product.platform.impl.notification;

import android.app.IObricNotificationListener;
import android.app.ObricNotificationManager;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.platform.api.notification.IObricNotificationManager;
import com.obric.aiagent.product.platform.api.notification.ObricNotificationListener;
import com.obric.aiagent.product.platform.api.notification.ObricToastShowListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/notification/CommonObricNotificationManager;", "Lcom/obric/aiagent/product/platform/api/notification/IObricNotificationManager;", "<init>", "()V", "registerNotificationListener", "", "listener", "Lcom/obric/aiagent/product/platform/api/notification/ObricNotificationListener;", "unregisterNotificationListener", "registerToastShowListener", "Lcom/obric/aiagent/product/platform/api/notification/ObricToastShowListener;", "unregisterToastShowListener", "isPanelShown", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CommonObricNotificationManager implements IObricNotificationManager {
    public static final Companion Companion = null;
    public static final String TAG = "CommonObricNotificationManager";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/notification/CommonObricNotificationManager$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CommonObricNotificationManager() {
    }

    @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
    public boolean isPanelShown() {
        return ObricNotificationManager.isPanelShown();
    }

    @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
    public boolean registerNotificationListener(ObricNotificationListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.IObricNotificationListener");
        return ObricNotificationManager.registerNotificationListener((IObricNotificationListener) ZeusTransformUtils.preCheckCast(r1, IObricNotificationListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
    public boolean registerToastShowListener(ObricToastShowListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        return ToastShowListenerBridge.INSTANCE.register(r3);
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "registerToastShowListener failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
    public boolean unregisterNotificationListener(ObricNotificationListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.IObricNotificationListener");
        return ObricNotificationManager.unregisterNotificationListener((IObricNotificationListener) ZeusTransformUtils.preCheckCast(r1, IObricNotificationListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
    public boolean unregisterToastShowListener(ObricToastShowListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        return ToastShowListenerBridge.INSTANCE.unregister(r3);
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "unregisterToastShowListener failed", th);
        return false;
    }
}
