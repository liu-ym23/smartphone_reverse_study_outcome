package com.obric.aiagent.product.platform.impl.app;

import android.app.AssistantActivityManager;
import android.app.IAssistantAutoVirtualDisplayRecordSetListener;
import com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0016J#\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/AssistantAutoVirtualDisplayRecordSetOfficialApi;", "Lcom/obric/aiagent/product/platform/impl/app/AutoVirtualDisplayRecordSetCalls;", "<init>", "()V", "retainedListener", "Lcom/obric/aiagent/product/platform/api/app/ObricAutoVirtualDisplayRecordSetListener;", "retainedAdapter", "Landroid/app/IAssistantAutoVirtualDisplayRecordSetListener;", "begin", "", "displayId", "", "userId", "listener", "add", "", ObricMemoryConstants.KEY_SESSION_ID, "packageNames", "", "", "(J[Ljava/lang/String;)Z", "end", "", "getOrCreateAdapter", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AssistantAutoVirtualDisplayRecordSetOfficialApi implements AutoVirtualDisplayRecordSetCalls {
    public static final AssistantAutoVirtualDisplayRecordSetOfficialApi INSTANCE = null;
    private static volatile IAssistantAutoVirtualDisplayRecordSetListener retainedAdapter;
    private static volatile ObricAutoVirtualDisplayRecordSetListener retainedListener;

    static {
        INSTANCE = new AssistantAutoVirtualDisplayRecordSetOfficialApi();
    }

    private AssistantAutoVirtualDisplayRecordSetOfficialApi() {
    }

    private final IAssistantAutoVirtualDisplayRecordSetListener getOrCreateAdapter(final ObricAutoVirtualDisplayRecordSetListener r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (retainedListener != r3) goto L8;
        IAssistantAutoVirtualDisplayRecordSetListener r0 = retainedAdapter;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
    L9:
        monitor-exit(this);
        return r0;
    L8:
        IAssistantAutoVirtualDisplayRecordSetListener.Stub r1 = new AssistantAutoVirtualDisplayRecordSetOfficialApi$getOrCreateAdapter$1$2(r3);     // Catch: Throwable -> L11
        retainedListener = r3;     // Catch: Throwable -> L11
        retainedAdapter = (IAssistantAutoVirtualDisplayRecordSetListener) ZeusTransformUtils.preCheckCast(r1, IAssistantAutoVirtualDisplayRecordSetListener.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        r0 = (IAssistantAutoVirtualDisplayRecordSetListener) ZeusTransformUtils.preCheckCast(r1, IAssistantAutoVirtualDisplayRecordSetListener.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        goto L9
    }

    @Override // com.obric.aiagent.product.platform.impl.app.AutoVirtualDisplayRecordSetCalls
    public boolean add(long r1, String[] r3) {
        Intrinsics.checkNotNullParameter(r3, "packageNames");
        return AssistantActivityManager.addAutoVirtualDisplayRecordPackages(r1, r3);
    }

    @Override // com.obric.aiagent.product.platform.impl.app.AutoVirtualDisplayRecordSetCalls
    public long begin(int r2, int r3, ObricAutoVirtualDisplayRecordSetListener r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        return AssistantActivityManager.beginAutoVirtualDisplayRecordSet(r2, r3, getOrCreateAdapter(r4));
    }

    @Override // com.obric.aiagent.product.platform.impl.app.AutoVirtualDisplayRecordSetCalls
    public void end(long r1) {
        AssistantActivityManager.endAutoVirtualDisplayRecordSet(r1);
    }
}
