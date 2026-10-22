package com.obric.miniapp.request;

import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/obric/miniapp/request/QueryAllIcsEntityRequest$executeFunction$2", "Landroidx/core/util/Consumer;", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "accept", "", "error", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QueryAllIcsEntityRequest$executeFunction$2 implements Consumer<AIBridgeMethod.Error> {
    public QueryAllIcsEntityRequest$executeFunction$2() {
        throw null;
    }

    public final void accept(Object r4) {
        AIBridgeMethod.Error r5 = (AIBridgeMethod.Error) r4;
        Intrinsics.checkNotNullParameter(r5, "error");
        FLogger.a.e("QueryAllIcsEntityRequest", "handle request error: " + r5.getMessage());
        if (a.a(r5) == true) goto L5;
        throw null;
    L5:
        int r6 = e.a;
        throw null;
    }
}
