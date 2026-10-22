package com.bytedance.android.live.core.monitor.trace;

import com.google.gson.annotations.SerializedName;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static volatile C0144a a;
    public static final ConcurrentHashMap<String, Integer> b = null;
    public static final ConcurrentHashMap<String, Boolean> c = null;
    public static volatile long d;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.monitor.trace.a$a, reason: collision with other inner class name */
    public static class C0144a {

        @SerializedName("enable")
        boolean enable;

        @SerializedName("frequencyThreshold")
        int frequencyThreshold;

        @SerializedName("intervals")
        private long intervals;

        public C0144a() {
        }

        public final long a() {
            long r0 = this.intervals;
            if (r0 >= 60000) goto L5;
            return 60000;
        L5:
            return r0;
        }
    }

    static {
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }
}
