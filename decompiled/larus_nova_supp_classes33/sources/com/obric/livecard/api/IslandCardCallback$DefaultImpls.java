package com.obric.livecard.api;

import com.obric.livecard.api.entity.IslandSession;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class IslandCardCallback$DefaultImpls {
    public static /* synthetic */ void onSessionDestroy$default(IslandCardCallback r0, IslandSession r1, Integer r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.onSessionDestroy(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSessionDestroy");
    }
}
