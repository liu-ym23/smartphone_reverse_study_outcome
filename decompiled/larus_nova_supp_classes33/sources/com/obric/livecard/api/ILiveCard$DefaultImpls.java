package com.obric.livecard.api;

import android.app.Application;
import com.obric.livecard.api.island.IslandHideApi;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ILiveCard$DefaultImpls {
    public static /* synthetic */ IslandHideApi getIslandHideApi$default(ILiveCard r0, Application r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = null;
    L7:
        return r0.getIslandHideApi(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getIslandHideApi");
    }
}
