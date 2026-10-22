package com.obric.aiagent.product.platform.impl.app;

import com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ!\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/AssistantAutoVirtualDisplayRecordSetFramework;", "", "<init>", "()V", "delegate", "Lcom/obric/aiagent/product/platform/impl/app/AutoVirtualDisplayRecordSetFramework;", "isSupported", "", "begin", "", "displayId", "", "userId", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAutoVirtualDisplayRecordSetListener;", "add", ObricMemoryConstants.KEY_SESSION_ID, "packageNames", "", "", "(J[Ljava/lang/String;)Z", "end", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AssistantAutoVirtualDisplayRecordSetFramework {
    public static final AssistantAutoVirtualDisplayRecordSetFramework INSTANCE = null;
    private static final AutoVirtualDisplayRecordSetFramework delegate = null;

    static {
        INSTANCE = new AssistantAutoVirtualDisplayRecordSetFramework();
        delegate = new AutoVirtualDisplayRecordSetFramework(ObricAutoVirtualDisplayRecordSetFrameworkKt.getASSISTANT_AUTO_VIRTUAL_DISPLAY_RECORD_SET_API());
    }

    private AssistantAutoVirtualDisplayRecordSetFramework() {
    }

    public final boolean add(long r1, String[] r3) {
        Intrinsics.checkNotNullParameter(r3, "packageNames");
        return delegate.add(r1, r3);
    }

    public final long begin(int r1, int r2, ObricAutoVirtualDisplayRecordSetListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        return delegate.begin(r1, r2, r3);
    }

    public final void end(long r1) {
        delegate.end(r1);
    }

    public final boolean isSupported() {
        return delegate.isSupported();
    }
}
