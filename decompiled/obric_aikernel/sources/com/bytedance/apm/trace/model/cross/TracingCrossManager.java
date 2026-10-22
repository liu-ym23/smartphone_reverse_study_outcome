package com.bytedance.apm.trace.model.cross;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import s0.d;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class TracingCrossManager {
    private static Map<Long, d> sCrossTracingContext;

    static {
        sCrossTracingContext = new ConcurrentHashMap();
    }

    public TracingCrossManager() {
    }

    public static void onPassBackAsChild(String r10, String r11, ArrayList<NativeSpan> r12) {
        d r13 = sCrossTracingContext.get(Long.valueOf(Long.parseLong(r10)));
        if (r13 == null) goto L6;
        sCrossTracingContext.remove(Long.valueOf(Long.parseLong(r10)));
        r13.a(r11, r12);
        return;
    }

    @Keep
    public static void onPassBackAsReference(String r10, String r11, ArrayList<NativeSpan> r12) {
        d r13 = sCrossTracingContext.get(Long.valueOf(Long.parseLong(r10)));
        if (r13 == null) goto L6;
        sCrossTracingContext.remove(Long.valueOf(Long.parseLong(r10)));
        r13.b(r11, r12);
        return;
    }

    public static void registerCross(long r10, d r11) {
        sCrossTracingContext.put(Long.valueOf(r10), r11);
    }

    public static void unRegisterCross(long r10) {
        sCrossTracingContext.remove(Long.valueOf(r10));
    }
}
