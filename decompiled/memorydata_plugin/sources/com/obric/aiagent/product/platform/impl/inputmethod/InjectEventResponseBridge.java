package com.obric.aiagent.product.platform.impl.inputmethod;

import android.app.a;
import android.view.input.AssistantInputManager;
import android.view.input.ObricInputManager;
import com.obric.framework.inputmethod.api.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000b"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/inputmethod/InjectEventResponseBridge;", "", "<init>", "()V", "registerObric", "", "listener", "Lcom/obric/framework/inputmethod/api/ObricInjectEventCallback;", "unregisterObric", "registerAssistant", "unregisterAssistant", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InjectEventResponseBridge {
    public static final InjectEventResponseBridge INSTANCE = null;

    static {
        INSTANCE = new InjectEventResponseBridge();
    }

    private InjectEventResponseBridge() {
    }

    public final boolean registerAssistant(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.a();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.ITopActivityAssistDataReceiver");
        AssistantInputManager.registerInjectEventResponseListener((a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin"));
        return true;
    }

    public final boolean registerObric(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.a();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.ITopActivityAssistDataReceiver");
        ObricInputManager.registerInjectEventResponseListener((a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin"));
        return true;
    }

    public final boolean unregisterAssistant(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.a();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.ITopActivityAssistDataReceiver");
        AssistantInputManager.unregisterInjectEventResponseListener((a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin"));
        return true;
    }

    public final boolean unregisterObric(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r1 = r2.a();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.ITopActivityAssistDataReceiver");
        ObricInputManager.unregisterInjectEventResponseListener((a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin"));
        return true;
    }
}
