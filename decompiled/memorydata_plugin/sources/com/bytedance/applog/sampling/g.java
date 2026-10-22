package com.bytedance.applog.sampling;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class g extends a {
    g(int r3, Set<String> r4, Map<String, List<Set<String>>> r5, Map<String, List<Map<String, Object>>> r6) {
        super(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.applog.sampling.a
    boolean a(b r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        int r6 = a();
        if (r6 >= 0) goto L6;
        return true;
    L6:
        if (r6 <= 0) goto L9;
        return false;
    L9:
        if (new Random().nextInt(10000) < this.f1864a) goto L12;
        return true;
    L12:
        return false;
    }
}
