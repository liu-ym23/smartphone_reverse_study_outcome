package com.bytedance.applog.sampling;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public class i extends a {
    i(int r3, Set<String> r4, Map<String, List<Set<String>>> r5, Map<String, List<Map<String, Object>>> r6) {
        super(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.applog.sampling.a
    boolean a(b r7) {
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.memorydata.plugin");
        int r0 = a();
        if (r0 >= 0) goto L6;
        return true;
    L6:
        if (r0 <= 0) goto L8;
        return false;
    L8:
        if (r8 != null) goto L10;
        return false;
    L10:
        String r1 = r8.a();
        if (TextUtils.isEmpty(r1) == false) goto L13;
        return false;
    L13:
        String r3 = r8.c();
        if (TextUtils.isEmpty(r3) == false) goto L16;
        return false;
    L16:
        String r9 = r8.d();
        if (TextUtils.isEmpty(r9) == false) goto L20;
        return false;
    L20:
        return !com.bytedance.applog.sampling.a.c.a(r1 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r9 + "_" + r3, 10000, this.f1864a);
    }
}
