package com.bytedance.android.live.openplatform.impl.miniappanchor.eventlisteners;

import android.os.Bundle;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends vq0.a {
    public b(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r3) {
        if (((AnchorShelfContextService) this.a.getService(AnchorShelfContextService.class)).interceptAddPage() == false) goto L5;
        f2.b(2131921102, 0);
        return null;
    L5:
        if (r3 == null) goto L10;
        ((AnchorShelfContextService) this.a.getService(AnchorShelfContextService.class)).onMountPage(r3);
        return null;
    L10:
        return null;
    }
}
