package com.bytedance.android.live.openplatform.impl.miniappanchor.eventlisteners;

import android.os.Bundle;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends vq0.a {
    public a(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r3) {
        if (r3 == null) goto L8;
        String r4 = r3.getString("current_page");
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.c r5 = ((AnchorShelfContextService) this.a.getService(AnchorShelfContextService.class)).getPageConfig(r4);
        Bundle r0 = new Bundle();
        r0.putString("page_config", GsonProtectorUtils.toJson(GsonHelper.get(), r5));
        return r0;
    L8:
        return null;
    }
}
