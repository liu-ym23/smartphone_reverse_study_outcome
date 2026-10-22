package com.bytedance.applog.util;

import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(Map<String, String> r2, boolean r3) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put(BDNetworkTagManager.KEY_BD_NETWORK_REQUEST_TAG, "t=0;n=" + (r3 ? 1 : 0));
    }
}
