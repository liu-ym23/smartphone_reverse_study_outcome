package com.bytedance.apm.trace.model.cross;

import androidx.annotation.Keep;
import d3.b;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class TracingCrossManager {
    private static Map<Long, b> sCrossTracingContext;

    static {
        sCrossTracingContext = new ConcurrentHashMap();
    }

    public TracingCrossManager() {
    }

    public static void onPassBackAsChild(String r8, String r10, ArrayList<NativeSpan> r11) {
        b r12 = sCrossTracingContext.get(Long.valueOf(Long.parseLong(r8)));
        if (r12 == null) goto L6;
        sCrossTracingContext.remove(Long.valueOf(Long.parseLong(r8)));
        r12.a();
        return;
    }

    @Keep
    public static void onPassBackAsReference(String r8, String r10, ArrayList<NativeSpan> r11) {
        b r12 = sCrossTracingContext.get(Long.valueOf(Long.parseLong(r8)));
        if (r12 == null) goto L6;
        sCrossTracingContext.remove(Long.valueOf(Long.parseLong(r8)));
        r12.b();
        return;
    }

    public static void registerCross(long r8, b r10) {
        sCrossTracingContext.put(Long.valueOf(r8), r10);
    }

    public static void unRegisterCross(long r8) {
        sCrossTracingContext.remove(Long.valueOf(r8));
    }
}
