package com.bytedance.common.utility;

import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class c extends f {
    c() {
    }

    @Override // com.bytedance.common.utility.f
    public String a(String r1, List<Pair<String, String>> r2, Map<String, String> r3, f.a r4) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        throw new CommonHttpException(0, "not implemented");
    }

    @Override // com.bytedance.common.utility.f
    public String a(String r1, Map<String, String> r2, f.a r3) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        throw new IOException("not implemented");
    }

    @Override // com.bytedance.common.utility.f
    public String a(String r1, byte[] r2, Map<String, String> r3, f.a r4) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        throw new CommonHttpException(0, "not implemented");
    }
}
