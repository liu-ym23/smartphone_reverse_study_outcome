package com.obric.aiagent.product.platform.impl.memory;

import aiassistant.memorydata.MemoryManagerProxy;
import android.content.Context;
import android.os.Bundle;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.platform.api.memory.IObricMemoryManager;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryActionCallback;
import com.obric.aiagent.product.platform.api.memory.ObricScenePerceptionCallback;
import com.obric.aiagent.product.platform.api.memory.ObricSystemEventCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J \u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010#\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u000fH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006("}, d2 = {"Lcom/obric/aiagent/product/platform/impl/memory/AssistantMemoryManagerImpl;", "Lcom/obric/aiagent/product/platform/api/memory/IObricMemoryManager;", "<init>", "()V", "KEY_TEXT", "", "getKEY_TEXT", "()Ljava/lang/String;", "KEY_IMAGE_URI", "getKEY_IMAGE_URI", "KEY_PACKAGE", "getKEY_PACKAGE", "KEY_TIMESTAMP", "getKEY_TIMESTAMP", "doMemoryActionIfEnabled", "", "from", "", "extras", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "doMemoryAction", "registerMemoryActionCallback", "callback", "Lcom/obric/aiagent/product/platform/api/memory/ObricMemoryActionCallback;", "unregisterMemoryActionCallback", "reportSystemEvent", "event", "state", "registerSystemEventCallback", "Lcom/obric/aiagent/product/platform/api/memory/ObricSystemEventCallback;", "unregisterSystemEventCallback", "doScenePerceptionAction", "type", "reportScenePerceptionEvent", "registerScenePerceptionCallback", "Lcom/obric/aiagent/product/platform/api/memory/ObricScenePerceptionCallback;", "unregisterScenePerceptionCallback", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AssistantMemoryManagerImpl implements IObricMemoryManager {
    public static final Companion Companion = null;
    public static final String TAG = "AssistantMemoryManagerImpl";
    private final String KEY_IMAGE_URI;
    private final String KEY_PACKAGE;
    private final String KEY_TEXT;
    private final String KEY_TIMESTAMP;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/memory/AssistantMemoryManagerImpl$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public AssistantMemoryManagerImpl() {
        this.KEY_TEXT = "com.aiassistant.memorydata.EXTRA_TEXT";
        this.KEY_IMAGE_URI = "com.aiassistant.memorydata.EXTRA_IMAGE_URI";
        this.KEY_PACKAGE = "com.aiassistant.memorydata.EXTRA_PACKAGE";
        this.KEY_TIMESTAMP = "com.aiassistant.memorydata.EXTRA_TIMESTAMP";
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
    public void doScenePerceptionAction(int r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r8, "extras");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        AssistantMemoryManagerImpl r6 = (AssistantMemoryManagerImpl) ZeusTransformUtils.preCheckCast(this, AssistantMemoryManagerImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r9 = Result.m1421constructorimpl(MemoryManagerProxy.class.getMethod("doScenePerceptionAction", new Class[]{Integer.TYPE, Bundle.class}).invoke(null, new Object[]{Integer.valueOf(r7), r8}));     // Catch: Throwable -> L5
    L7:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
        if (r10 == null) goto L13;
        d.f5954a.b(TAG, "doScenePerceptionAction failed", r10);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
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
        Object r2 = r3.getAssistantStub();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type aiassistant.memorydata.MemoryManagerProxy.MemoryActionCallbackWrapper");
        MemoryManagerProxy.registerMemoryActionCallback((MemoryManagerProxy.MemoryActionCallbackWrapper) ZeusTransformUtils.preCheckCast(r2, MemoryManagerProxy.MemoryActionCallbackWrapper.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void registerScenePerceptionCallback(ObricScenePerceptionCallback r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        AssistantMemoryManagerImpl r8 = (AssistantMemoryManagerImpl) ZeusTransformUtils.preCheckCast(this, AssistantMemoryManagerImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Object r10 = r9.getAssistantStub();     // Catch: Throwable -> L18
        Method[] r11 = MemoryManagerProxy.class.getMethods();     // Catch: Throwable -> L18
        Intrinsics.checkNotNullExpressionValue(r11, "getMethods(...)");     // Catch: Throwable -> L18
        Object[] r12 = (Object[]) ZeusTransformUtils.preCheckCast(r11, Object[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        int r2 = r12.length;     // Catch: Throwable -> L18
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L17;
        Object r4 = r12[r3];     // Catch: Throwable -> L18
        Method r5 = (Method) ZeusTransformUtils.preCheckCast(r4, Method.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(r5.getName(), "registerScenePerceptionCallback") == true) goto L8;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == true) goto L14;
        r3 = r3 + 1;     // Catch: Throwable -> L18
        goto L4
    L14:
        Object r13 = Result.m1421constructorimpl(((Method) ZeusTransformUtils.preCheckCast(r4, Method.class, "com.obric.memorydata.plugin")).invoke(null, new Object[]{r10}));     // Catch: Throwable -> L18
    L20:
        Throwable r14 = Result.m1424exceptionOrNullimpl(r13);
        if (r14 == null) goto L27;
        d.f5954a.b(TAG, "registerScenePerceptionCallback failed", r14);
        return;
    L27:
        return;
    L8:
        if (r5.getParameterTypes().length != 1) goto L12;
        if (ZeusTransformUtils.instanceOf(r5.getParameterTypes()[0], r10) == false) goto L12;
        r6 = true;
        goto L13
    L17:
        throw new NoSuchElementException("Array contains no element matching the predicate.");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void registerSystemEventCallback(ObricSystemEventCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Object r1 = r2.getAssistantStub();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type aiassistant.memorydata.MemoryManagerProxy.SystemEventCallbackWrapper");
        MemoryManagerProxy.registerSystemEventCallback((MemoryManagerProxy.SystemEventCallbackWrapper) ZeusTransformUtils.preCheckCast(r1, MemoryManagerProxy.SystemEventCallbackWrapper.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void reportScenePerceptionEvent(int r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r8, "extras");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        AssistantMemoryManagerImpl r6 = (AssistantMemoryManagerImpl) ZeusTransformUtils.preCheckCast(this, AssistantMemoryManagerImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r9 = Result.m1421constructorimpl(MemoryManagerProxy.class.getMethod("reportScenePerceptionEvent", new Class[]{Integer.TYPE, Bundle.class}).invoke(null, new Object[]{Integer.valueOf(r7), r8}));     // Catch: Throwable -> L5
    L7:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
        if (r10 == null) goto L13;
        d.f5954a.b(TAG, "reportScenePerceptionEvent failed", r10);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
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
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        AssistantMemoryManagerImpl r3 = (AssistantMemoryManagerImpl) ZeusTransformUtils.preCheckCast(this, AssistantMemoryManagerImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L4
        Object r4 = Result.m1421constructorimpl(MemoryManagerProxy.class.getMethod("unregisterScenePerceptionCallback", new Class[0]).invoke(null, new Object[0]));     // Catch: Throwable -> L4
    L6:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 == null) goto L12;
        d.f5954a.b(TAG, "unregisterScenePerceptionCallback failed", r5);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
    public void unregisterSystemEventCallback() {
        MemoryManagerProxy.unregisterSystemEventCallback();
    }
}
