package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface TraceEvent$Natives {
    void addViewDump(int r1, int r2, boolean r3, boolean r4, String r5, String r6, long r7);

    void begin(String r1, String r2);

    void beginToplevel(String r1);

    void end(String r1, String r2);

    void endToplevel(String r1);

    void finishAsync(String r1, long r2);

    void initViewHierarchyDump();

    void instant(String r1, String r2);

    void instantAndroidIPC(String r1, long r2);

    void registerEnabledObserver();

    void setupATraceStartupTrace(String r1);

    void startATrace(String r1);

    long startActivityDump(String r1, long r2);

    void startAsync(String r1, long r2);

    void stopATrace();

    boolean viewHierarchyDumpEnabled();
}
