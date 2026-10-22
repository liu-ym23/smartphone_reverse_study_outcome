package rp0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.miniappanchor.cast.AnchorCastContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends vq0.a {
    public h(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r6) {
        if (r6 == null) goto L15;
        String r0 = r6.getString("app_name");
        String r1 = "";
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        String r2 = r6.getString("dialog_action", "");
        r6.getBoolean("never_ask", false);
        AnchorCastContextService r7 = (AnchorCastContextService) this.a.getService(AnchorCastContextService.class);
        MiniAppInstance r3 = this.a.getMiniAppInstance();
        if (r3 == null) goto L12;
        String r4 = r3.getAppId();
        if (r4 == null) goto L12;
        r1 = r4;
    L12:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "appId");
        Intrinsics.checkNotNullParameter(r0, "appName");
        Intrinsics.checkNotNullParameter(r2, "action");
        r7.g().d(r1, r0, r2);
        return null;
    L15:
        return null;
    }
}
