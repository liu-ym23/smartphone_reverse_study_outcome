package com.bytedance.android.live.openplatform.impl.miniappanchor.eventlisteners;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.bridge.BridgeContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import zo0.f;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class OnLiveShelfSaveEventListener extends vq0.a {
    public OnLiveShelfSaveEventListener(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    public final Bundle onEvent(final Bundle r4) {
        if (((uc1) ee0.a.getValue()).g() == false) goto L6;
        ((AnchorShelfContextService) this.a.getService(AnchorShelfContextService.class)).saveShelf(new AnonymousClass1(this, r4));
    L9:
        return null;
    L6:
        if (this.a.isInLive() == false) goto L8;
        ((AnchorShelfContextService) this.a.getService(AnchorShelfContextService.class)).saveShelf(new AnonymousClass2(this, r4));
        goto L9
    L8:
        HashMap<String, f> r5 = g.a;
        f r6 = h.b(PerformanceScene.SHELF_MANAGEMENT_PAGE);
        r6.o();
        h.a(r6, "finish");
        AnchorShelfContextService.openShelfManagementPage$default((AnchorShelfContextService) this.a.getService(AnchorShelfContextService.class), null, null, 3, null);
        BridgeContextService.g((BridgeContextService) this.a.getService(BridgeContextService.class), "kill_miniapp");
        goto L9
    }
}
