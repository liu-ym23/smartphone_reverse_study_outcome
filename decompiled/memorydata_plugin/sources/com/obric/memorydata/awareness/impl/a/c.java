package com.obric.memorydata.awareness.impl.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u001a,\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001*\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001H\u0000¨\u0006\u0004"}, d2 = {"withoutPolicyControl", "", "", "", "awareness_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class c {
    public static final Map<String, Object> a(Map<String, ? extends Object> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L19;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r8 = r7.entrySet().iterator();
    L6:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if ((!Intrinsics.areEqual((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin"), "feature_event_mode")) == false) goto L6;
        r2.put(r3.getKey(), r3.getValue());
        goto L6
    L10:
        Map<String, Object> r9 = (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin");
        if ((!r9.isEmpty()) == true) goto L13;
        return null;
    L13:
        return r9;
    L19:
        return null;
    }
}
