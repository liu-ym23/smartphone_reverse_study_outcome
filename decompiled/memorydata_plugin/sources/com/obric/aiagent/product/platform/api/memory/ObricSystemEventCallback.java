package com.obric.aiagent.product.platform.api.memory;

import aiassistant.memorydata.MemoryManagerProxy;
import android.os.Bundle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&R\u001b\u0010\u0004\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/obric/aiagent/product/platform/api/memory/ObricSystemEventCallback;", "", "<init>", "()V", "obricStub", "getObricStub", "()Ljava/lang/Object;", "obricStub$delegate", "Lkotlin/Lazy;", "assistantStub", "getAssistantStub", "assistantStub$delegate", "onEvent", "", "event", "", "state", "extras", "Landroid/os/Bundle;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ObricSystemEventCallback {
    private final Lazy assistantStub$delegate;
    private final Lazy obricStub$delegate;

    public ObricSystemEventCallback() {
        this.obricStub$delegate = LazyKt.lazy(new $$Lambda$ObricSystemEventCallback$JRJcDniZZMX_VnxtJ1ZVA1rUHYI(this));
        this.assistantStub$delegate = LazyKt.lazy(new $$Lambda$ObricSystemEventCallback$2eG3OIM3Syih1QiValdPwKjIg(this));
    }

    private static final MemoryManagerProxy.SystemEventCallbackWrapper assistantStub_delegate$lambda$3(final ObricSystemEventCallback r1) {
        return new $$Lambda$ObricSystemEventCallback$bUrXWi1MCpQpds3MjIwgl2v_K5Y(r1);
    }

    private static final void assistantStub_delegate$lambda$3$lambda$2(ObricSystemEventCallback r0, int r1, int r2, Bundle r3) {
        r0.onEvent(r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$2eG3-OI-M3Syih1QiValdPwKjIg, reason: not valid java name */
    public static /* synthetic */ MemoryManagerProxy.SystemEventCallbackWrapper m162lambda$2eG3OIM3Syih1QiValdPwKjIg(ObricSystemEventCallback r0) {
        return assistantStub_delegate$lambda$3(r0);
    }

    public static /* synthetic */ void lambda$B3Hd88zS21CQdWumPYDPEhltI_Y(ObricSystemEventCallback r0, int r1, int r2, Bundle r3) {
        obricStub_delegate$lambda$1$lambda$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ obric.memorydata.MemoryManagerProxy.SystemEventCallbackWrapper lambda$JRJcDniZZMX_VnxtJ1ZVA1rUHYI(ObricSystemEventCallback r0) {
        return obricStub_delegate$lambda$1(r0);
    }

    public static /* synthetic */ void lambda$bUrXWi1MCpQpds3MjIwgl2v_K5Y(ObricSystemEventCallback r0, int r1, int r2, Bundle r3) {
        assistantStub_delegate$lambda$3$lambda$2(r0, r1, r2, r3);
    }

    private static final obric.memorydata.MemoryManagerProxy.SystemEventCallbackWrapper obricStub_delegate$lambda$1(final ObricSystemEventCallback r1) {
        return new $$Lambda$ObricSystemEventCallback$B3Hd88zS21CQdWumPYDPEhltI_Y(r1);
    }

    private static final void obricStub_delegate$lambda$1$lambda$0(ObricSystemEventCallback r0, int r1, int r2, Bundle r3) {
        r0.onEvent(r1, r2, r3);
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.getValue();
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.getValue();
    }

    public abstract void onEvent(int r1, int r2, Bundle r3);
}
