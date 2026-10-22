package com.bytedance.applog.sampling;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class f extends a {
    f(int r3, Set<String> r4, Map<String, List<Set<String>>> r5, Map<String, List<Map<String, Object>>> r6) {
        super(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.applog.sampling.a
    boolean a(b r8) {
        b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r8, b.class, "com.obric.memorydata.plugin");
        int r0 = a();
        if (r0 >= 0) goto L6;
        return true;
    L6:
        if (r0 <= 0) goto L8;
        return false;
    L8:
        if (r9 != null) goto L10;
    L18:
        return false;
    L10:
        if (TextUtils.isEmpty(r9.b()) == true) goto L18;
        if ((Long.parseLong(r9.b()) % 10000) < this.f1864a) goto L17;
        return true;
    L17:
        return false;
    }
}
