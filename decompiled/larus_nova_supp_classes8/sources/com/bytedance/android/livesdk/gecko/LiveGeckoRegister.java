package com.bytedance.android.livesdk.gecko;

import android.content.Context;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.annotation.GeckoRegister;
import com.bytedance.geckox.settings.IGeckoRegister;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@GeckoRegister(boeAccessKey = "68f927652a5370ec9f4ae1dbaf56fd85", prodAccessKey = "5fb33cde3ebff01c8433ddc22aac0816", testAccessKey = "36723dc3e85a23e701d1697d57de07ed")
public class LiveGeckoRegister implements IGeckoRegister {
    public LiveGeckoRegister() {
    }

    public Map<String, OptionCheckUpdateParams.CustomValue> registerCustomParams() {
        Lazy r0 = LiveGeckoConfig.a;
        HashMap r1 = new HashMap();
        if (jc1.k.f(IMiddleWareHostContext.class) == null) goto L5;
        r1.put("business_version", k.a);
    L5:
        r1.put("webcast_sdk_version", l.a);
        return r1;
    }

    public String registerRootDir(Context r1) {
        return LiveGeckoConfig.c();
    }
}
