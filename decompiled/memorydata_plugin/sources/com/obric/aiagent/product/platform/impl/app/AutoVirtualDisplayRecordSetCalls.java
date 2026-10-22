package com.obric.aiagent.product.platform.impl.app;

import com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J#\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0003H&¨\u0006\u0012"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/AutoVirtualDisplayRecordSetCalls;", "", "begin", "", "displayId", "", "userId", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAutoVirtualDisplayRecordSetListener;", "add", "", ObricMemoryConstants.KEY_SESSION_ID, "packageNames", "", "", "(J[Ljava/lang/String;)Z", "end", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AutoVirtualDisplayRecordSetCalls {
    boolean add(long r1, String[] r3);

    long begin(int r1, int r2, ObricAutoVirtualDisplayRecordSetListener r3);

    void end(long r1);
}
