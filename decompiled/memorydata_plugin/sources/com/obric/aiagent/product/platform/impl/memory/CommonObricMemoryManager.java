package com.obric.aiagent.product.platform.impl.memory;

import android.content.Context;
import android.os.Bundle;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.platform.api.memory.IObricMemoryManager;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryActionCallback;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aiagent.product.platform.api.memory.ObricScenePerceptionCallback;
import com.obric.aiagent.product.platform.api.memory.ObricSystemEventCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.memorydata.MemoryManagerProxy;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J \u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010#\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u000fH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006("}, d2 = {"Lcom/obric/aiagent/product/platform/impl/memory/CommonObricMemoryManager;", "Lcom/obric/aiagent/product/platform/api/memory/IObricMemoryManager;", "<init>", "()V", "KEY_TEXT", "", "getKEY_TEXT", "()Ljava/lang/String;", "KEY_IMAGE_URI", "getKEY_IMAGE_URI", "KEY_PACKAGE", "getKEY_PACKAGE", "KEY_TIMESTAMP", "getKEY_TIMESTAMP", "doMemoryActionIfEnabled", "", "from", "", "extras", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "doMemoryAction", "registerMemoryActionCallback", "callback", "Lcom/obric/aiagent/product/platform/api/memory/ObricMemoryActionCallback;", "unregisterMemoryActionCallback", "reportSystemEvent", "event", "state", "registerSystemEventCallback", "Lcom/obric/aiagent/product/platform/api/memory/ObricSystemEventCallback;", "unregisterSystemEventCallback", "doScenePerceptionAction", "type", "reportScenePerceptionEvent", "registerScenePerceptionCallback", "Lcom/obric/aiagent/product/platform/api/memory/ObricScenePerceptionCallback;", "unregisterScenePerceptionCallback", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CommonObricMemoryManager implements IObricMemoryManager {
    public static final Companion Companion = null;
    public static final String TAG = "CommonObricMemoryManager";
    private final String KEY_IMAGE_URI;
    private final String KEY_PACKAGE;
    private final String KEY_TEXT;
    private final String KEY_TIMESTAMP;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/memory/CommonObricMemoryManager$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public CommonObricMemoryManager() {
        this.KEY_TEXT = ObricMemoryConstants.KEY_TEXT;
        this.KEY_IMAGE_URI = ObricMemoryConstants.KEY_IMAGE_URI;
        this.KEY_PACKAGE = ObricMemoryConstants.KEY_PACKAGE;
        this.KEY_TIMESTAMP = ObricMemoryConstants.KEY_TIMESTAMP;
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void doMemoryAction(int r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "extras");
        MemoryManagerProxy.doMemoryAction(r1, r2);
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void doMemoryActionIfEnabled(int r2, Bundle r3, Context r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "extras");
        Intrinsics.checkNotNullParameter(r1, "context");
        MemoryManagerProxy.doMemoryActionIfEnabled(r2, r3, r1);
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void doScenePerceptionAction(int r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "extras");
        MemoryManagerProxy.doScenePerceptionAction(r1, r2);
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public String getKEY_IMAGE_URI() {
        return this.KEY_IMAGE_URI;
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public String getKEY_PACKAGE() {
        return this.KEY_PACKAGE;
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public String getKEY_TEXT() {
        return this.KEY_TEXT;
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public String getKEY_TIMESTAMP() {
        return this.KEY_TIMESTAMP;
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void registerMemoryActionCallback(ObricMemoryActionCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        d.f5954a.a(TAG, "registerMemoryActionCallback: " + r3);
        Object r2 = r3.getObricStub();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type obric.memorydata.MemoryManagerProxy.MemoryActionCallbackWrapper");
        MemoryManagerProxy.registerMemoryActionCallback((MemoryManagerProxy.MemoryActionCallbackWrapper) ZeusTransformUtils.preCheckCast(r2, MemoryManagerProxy.MemoryActionCallbackWrapper.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void registerScenePerceptionCallback(ObricScenePerceptionCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type obric.memorydata.MemoryManagerProxy.ScenePerceptionCallbackWrapper");
        MemoryManagerProxy.registerScenePerceptionCallback((MemoryManagerProxy.ScenePerceptionCallbackWrapper) ZeusTransformUtils.preCheckCast(r1, MemoryManagerProxy.ScenePerceptionCallbackWrapper.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void registerSystemEventCallback(ObricSystemEventCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Object r1 = r2.getObricStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type obric.memorydata.MemoryManagerProxy.SystemEventCallbackWrapper");
        MemoryManagerProxy.registerSystemEventCallback((MemoryManagerProxy.SystemEventCallbackWrapper) ZeusTransformUtils.preCheckCast(r1, MemoryManagerProxy.SystemEventCallbackWrapper.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void reportScenePerceptionEvent(int r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "extras");
        MemoryManagerProxy.reportScenePerceptionEvent(r1, r2);
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void reportSystemEvent(int r1, int r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "extras");
        MemoryManagerProxy.reportSystemEvent(r1, r2, r3);
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void unregisterMemoryActionCallback() {
        MemoryManagerProxy.unregisterMemoryActionCallback();
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void unregisterScenePerceptionCallback() {
        MemoryManagerProxy.unregisterScenePerceptionCallback();
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void unregisterSystemEventCallback() {
        MemoryManagerProxy.unregisterSystemEventCallback();
    }
}
