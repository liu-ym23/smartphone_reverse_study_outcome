package com.bytedance.apm.trace.model.cross;

import ai.j0;
import androidx.annotation.Keep;
import b7.b;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class TracingCrossManager {
    private static Map<Long, b> sCrossTracingContext;

    static {
        sCrossTracingContext = new ConcurrentHashMap();
    }

    public TracingCrossManager() {
    }

    public static void onPassBackAsChild(String r5, String r10, ArrayList<NativeSpan> r11) {
        j0.A(sCrossTracingContext.get(Long.valueOf(Long.parseLong(r5))));
    }

    @Keep
    public static void onPassBackAsReference(String r5, String r10, ArrayList<NativeSpan> r11) {
        j0.A(sCrossTracingContext.get(Long.valueOf(Long.parseLong(r5))));
    }

    public static void registerCross(long r5, b r10) {
        sCrossTracingContext.put(Long.valueOf(r5), r10);
    }

    public static void unRegisterCross(long r5) {
        sCrossTracingContext.remove(Long.valueOf(r5));
    }
}
