package com.obric.assistant.interaction.api.lifecycle;

import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class ILifecycleService$DefaultImpls {
    public static /* synthetic */ void init$default(ILifecycleService r0, Context r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        r0.init(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
    }
}
