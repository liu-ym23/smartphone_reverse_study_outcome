package com.bytedance.apm.trace.model.cross;

import com.bytedance.apm.trace.api.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class TracingCrossManager {
    private static Map<Long, d> sCrossTracingContext;

    static {
        sCrossTracingContext = new ConcurrentHashMap();
    }

    public TracingCrossManager() {
    }

    public static void onPassBackAsChild(String r4, String r5, ArrayList<NativeSpan> r6) {
        d r0 = (d) ZeusTransformUtils.preCheckCast(sCrossTracingContext.get(Long.valueOf(Long.parseLong(r4))), d.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        sCrossTracingContext.remove(Long.valueOf(Long.parseLong(r4)));
        r0.a(r5, r6);
        return;
    }

    public static void onPassBackAsReference(String r4, String r5, ArrayList<NativeSpan> r6) {
        d r0 = (d) ZeusTransformUtils.preCheckCast(sCrossTracingContext.get(Long.valueOf(Long.parseLong(r4))), d.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        sCrossTracingContext.remove(Long.valueOf(Long.parseLong(r4)));
        r0.b(r5, r6);
        return;
    }

    public static void registerCross(long r1, d r3) {
        sCrossTracingContext.put(Long.valueOf(r1), r3);
    }

    public static void unRegisterCross(long r1) {
        sCrossTracingContext.remove(Long.valueOf(r1));
    }
}
