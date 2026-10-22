package com.obric.aiagent.product.platform.api.memory;

import android.os.Bundle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import obric.memorydata.MemoryManagerProxy;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u001b\u0010\u0004\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/obric/aiagent/product/platform/api/memory/ObricScenePerceptionCallback;", "", "<init>", "()V", "obricStub", "getObricStub", "()Ljava/lang/Object;", "obricStub$delegate", "Lkotlin/Lazy;", "assistantStub", "getAssistantStub", "assistantStub$delegate", "onAction", "", "type", "", "extras", "Landroid/os/Bundle;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ObricScenePerceptionCallback {
    private final Lazy assistantStub$delegate;
    private final Lazy obricStub$delegate;

    public ObricScenePerceptionCallback() {
        this.obricStub$delegate = LazyKt.lazy(new $$Lambda$ObricScenePerceptionCallback$SErhfFnmrghb2yofBcLkkcMTaig(this));
        this.assistantStub$delegate = LazyKt.lazy(new $$Lambda$ObricScenePerceptionCallback$jtb7apQR_DeydLbjehA856YSxsw(this));
    }

    private static final Object assistantStub_delegate$lambda$3(final ObricScenePerceptionCallback r1) {
        return ObricScenePerceptionCallbackKt.access$newScenePerceptionCallbackWrapperProxy("aiassistant.memorydata.MemoryManagerProxy$ScenePerceptionCallbackWrapper", new $$Lambda$ObricScenePerceptionCallback$u2UMZrfCVLMRrcxtXBzE87udd2w(r1));
    }

    private static final Unit assistantStub_delegate$lambda$3$lambda$2(ObricScenePerceptionCallback r1, int r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        r1.onAction(r2, r3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ MemoryManagerProxy.ScenePerceptionCallbackWrapper lambda$SErhfFnmrghb2yofBcLkkcMTaig(ObricScenePerceptionCallback r0) {
        return obricStub_delegate$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$SuanS2EzGzbu2tAvUF6jbDL-2mU, reason: not valid java name */
    public static /* synthetic */ void m161lambda$SuanS2EzGzbu2tAvUF6jbDL2mU(ObricScenePerceptionCallback r0, int r1, Bundle r2) {
        obricStub_delegate$lambda$1$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Object lambda$jtb7apQR_DeydLbjehA856YSxsw(ObricScenePerceptionCallback r0) {
        return assistantStub_delegate$lambda$3(r0);
    }

    public static /* synthetic */ Unit lambda$u2UMZrfCVLMRrcxtXBzE87udd2w(ObricScenePerceptionCallback r0, int r1, Bundle r2) {
        return assistantStub_delegate$lambda$3$lambda$2(r0, r1, r2);
    }

    private static final MemoryManagerProxy.ScenePerceptionCallbackWrapper obricStub_delegate$lambda$1(final ObricScenePerceptionCallback r1) {
        return new $$Lambda$ObricScenePerceptionCallback$SuanS2EzGzbu2tAvUF6jbDL2mU(r1);
    }

    private static final void obricStub_delegate$lambda$1$lambda$0(ObricScenePerceptionCallback r0, int r1, Bundle r2) {
        Intrinsics.checkNotNull(r2);
        r0.onAction(r1, r2);
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.getValue();
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.getValue();
    }

    public abstract void onAction(int r1, Bundle r2);
}
