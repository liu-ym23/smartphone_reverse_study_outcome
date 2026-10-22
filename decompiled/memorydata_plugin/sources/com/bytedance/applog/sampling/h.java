package com.bytedance.applog.sampling;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public class h extends a {
    h(int r3, Set<String> r4, Map<String, List<Set<String>>> r5, Map<String, List<Map<String, Object>>> r6) {
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
    L16:
        return false;
    L10:
        if (TextUtils.isEmpty(r8.a()) == true) goto L16;
        if (TextUtils.isEmpty(r8.b()) == true) goto L16;
        return !com.bytedance.applog.sampling.a.c.a(r8.a() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r8.b(), 10000, this.f1864a);
    }
}
