package com.lynx.debugrouter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SessionHandlerDelegate implements DebugRouterSessionHandler {
    private DebugRouterSessionHandler handler;

    public SessionHandlerDelegate(DebugRouterSessionHandler r1) {
        this.handler = r1;
    }

    @Override // com.lynx.debugrouter.DebugRouterSessionHandler
    public void onSessionDestroy(int r2) {
        DebugRouterSessionHandler r0 = this.handler;
        if (r0 == null) goto L6;
        r0.onSessionDestroy(r2);
        return;
    }

    @Override // com.lynx.debugrouter.DebugRouterSessionHandler
    public void onSessionCreate(int r2, String r3) {
        DebugRouterSessionHandler r0 = this.handler;
        if (r0 == null) goto L6;
        r0.onSessionCreate(r2, r3);
        return;
    }

    @Override // com.lynx.debugrouter.DebugRouterSessionHandler
    public void onMessage(String r2, String r3, int r4) {
        DebugRouterSessionHandler r0 = this.handler;
        if (r0 == null) goto L6;
        r0.onMessage(r2, r3, r4);
        return;
    }
}
