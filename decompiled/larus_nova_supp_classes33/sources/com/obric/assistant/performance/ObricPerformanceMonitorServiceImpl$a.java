package com.obric.assistant.performance;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class ObricPerformanceMonitorServiceImpl$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[DozeMode.values().length];
        r0[DozeMode.DOZE_DEEP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[DozeMode.DOZE_LIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        a = r0;
    }
}
