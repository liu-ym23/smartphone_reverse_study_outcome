package com.lynx.debugrouter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface DebugRouterSessionHandler {
    void onMessage(String r1, String r2, int r3);

    void onSessionCreate(int r1, String r2);

    void onSessionDestroy(int r1);
}
