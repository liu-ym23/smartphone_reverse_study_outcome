package com.obric.aikernel.res.update;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aikernel/res/update/ApiTimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", ObricMemoryConstants.KEY_SESSION_ID, "", "timeoutMs", "", "(Ljava/lang/String;J)V", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ApiTimeoutCancellationException extends CancellationException {
    public ApiTimeoutCancellationException(String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_SESSION_ID);
        super("session cancel " + r3 + " by api. timeout:" + r4);
    }
}
