package com.larus.bmhome.share.panel;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l {
    public static final MutableSharedFlow<k> a = null;
    public static final a1 b = null;

    static {
        MutableSharedFlow<k> r0 = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        a = r0;
        b = kotlinx.coroutines.flow.e.a(r0);
    }

    public static void a(k.b r5) {
        Intrinsics.checkNotNullParameter(r5, "insert");
        MutableSharedFlow<k> r0 = a;
        boolean r1 = r0.tryEmit(r5);
        FLogger.a.i("SharePanelPublishInsertEvent", "emit: insert=" + r5 + ", accepted=" + r1 + ", subscribers=" + ((Number) r0.getSubscriptionCount().getValue()).intValue());
    }
}
