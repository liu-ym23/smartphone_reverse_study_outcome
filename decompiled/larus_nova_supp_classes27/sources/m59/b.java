package m59;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.DoraResourceState;
import com.larus.dora.api.IDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Context r3, String r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "targetRoute");
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        r0.i1();
        DoraResourceState r1 = r0.S0(DoraEnableScope.G_SERIES);
        if (r1 != DoraResourceState.PENDING) goto L8;
    L10:
        i r6 = SmartRouter.buildRoute(r3, "//flow/dora/resource_loading");
        Bundle r2 = new Bundle();
        r2.putString("dora_resource_loading_target_route", r4);
        if (r5 == null) goto L13;
        Bundle r7 = new Bundle(r5);
    L14:
        r2.putBundle("dora_resource_loading_target_extras", r7);
        r6.c.putExtras(r2);
        r6.d();
        return true;
    L13:
        r7 = null;
        goto L14
    L8:
        if (r1 == DoraResourceState.FAILED) goto L10;
        return false;
    }
}
