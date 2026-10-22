package com.bytedance.android.live.openplatform.impl.miniappanchor.eventlisteners;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends vq0.a {
    public c(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r4) {
        if (r4 == null) goto L8;
        String r5 = r4.getString("current_page");
        if (r5 != null) goto L7;
        r5 = "";
    L7:
        AnchorShelfContextService.takeCardOffFromShelf$default((AnchorShelfContextService) this.a.getService(AnchorShelfContextService.class), r5, null, 2, null);
    L8:
        return null;
    }
}
