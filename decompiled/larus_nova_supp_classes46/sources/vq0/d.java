package vq0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.miniappcommon.applog.MiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends a {
    public d(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r2) {
        ((MiniAppAppLogContextService) this.a.getService(MiniAppAppLogContextService.class)).clickMiniAppMoreButton();
        ((MiniAppAppLogContextService) this.a.getService(MiniAppAppLogContextService.class)).miniAppMoreDialogShow();
        return null;
    }
}
