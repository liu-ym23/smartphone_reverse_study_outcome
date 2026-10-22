package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface EarlyTraceEvent$Natives {
    void recordEarlyAsyncBeginEvent(String r1, long r2, long r4);

    void recordEarlyAsyncEndEvent(String r1, long r2, long r4);

    void recordEarlyBeginEvent(String r1, long r2, int r4, long r5);

    void recordEarlyEndEvent(String r1, long r2, int r4, long r5);

    void recordEarlyToplevelBeginEvent(String r1, long r2, int r4, long r5);

    void recordEarlyToplevelEndEvent(String r1, long r2, int r4, long r5);
}
