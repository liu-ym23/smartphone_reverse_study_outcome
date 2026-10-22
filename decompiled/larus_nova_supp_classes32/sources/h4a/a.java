package h4a;

import com.larus.e_commerce.api.IECommerceService;
import com.larus.platform.service.o;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements hx7.a {
    public a() {
    }

    public final void putCommonParams(Map r3) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        if (TypeIntrinsics.isMutableMap(r3) == false) goto L6;
        r3.put("iid", o.a.getInstallId());
        return;
    }

    public final void onEventV3Map(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        if (r4 == null) goto L5;
        JSONObject r0 = new JSONObject(r4);
    L6:
        IECommerceService r5 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r5 == null) goto L9;
        r5.t(r3, r0);
    L9:
        o.a.reportEvent(r3, r0);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
