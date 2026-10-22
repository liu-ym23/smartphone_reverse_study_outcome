package rp0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.miniappanchor.cast.AnchorCastContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends vq0.a {
    public c(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r4) {
        if (((AnchorShelfContextService) this.a.getService(AnchorShelfContextService.class)).isMounted() == false) goto L7;
        qo0.a.c("OnLiveBizErrorEventListener", "ON_LIVE_BIZ_ERROR");
        AnchorCastContextService r5 = (AnchorCastContextService) this.a.getService(AnchorCastContextService.class);
        r5.getClass();
        Intrinsics.checkNotNullParameter("", "errMsg");
        dp0.a r6 = r5.g();
        qo0.a.c("AnchorCastContextService", "sendLiveCastError by Strategy:" + r6);
        r6.g();
        AnchorCastContextService r7 = (AnchorCastContextService) this.a.getService(AnchorCastContextService.class);
        r7.a = null;
        Disposable r8 = r7.b;
        if (r8 == null) goto L7;
        r8.dispose();
    L7:
        return null;
    }
}
