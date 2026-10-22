package rp0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.miniappanchor.cast.AnchorCastContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends vq0.a {
    public g(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r5) {
        if (r5 == null) goto L15;
        AnchorCastContextService r0 = (AnchorCastContextService) this.a.getService(AnchorCastContextService.class);
        MiniAppInstance r1 = this.a.getMiniAppInstance();
        String r2 = "";
        if (r1 == null) goto L7;
        String r3 = r1.getAppId();
        if (r3 == null) goto L7;
    L8:
        String r4 = r5.getString("app_name");
        if (r4 == null) goto L12;
        r2 = r4;
    L12:
        boolean r6 = r5.getBoolean("cancel");
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "appId");
        Intrinsics.checkNotNullParameter(r2, "appName");
        r0.g().c(r3, r2, r6);
        return null;
    L7:
        r3 = "";
        goto L8
    L15:
        return null;
    }
}
