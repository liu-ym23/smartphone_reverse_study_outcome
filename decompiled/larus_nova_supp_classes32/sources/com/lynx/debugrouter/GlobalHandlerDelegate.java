package com.lynx.debugrouter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class GlobalHandlerDelegate implements DebugRouterGlobalHandler {
    private DebugRouterGlobalHandler handler;

    public GlobalHandlerDelegate(DebugRouterGlobalHandler r1) {
        this.handler = r1;
    }

    @Override // com.lynx.debugrouter.DebugRouterGlobalHandler
    public void openCard(String r2) {
        DebugRouterGlobalHandler r0 = this.handler;
        if (r0 == null) goto L6;
        r0.openCard(r2);
        return;
    }

    @Override // com.lynx.debugrouter.DebugRouterGlobalHandler
    public void onMessage(String r2, int r3, String r4) {
        DebugRouterGlobalHandler r0 = this.handler;
        if (r0 == null) goto L6;
        r0.onMessage(r2, r3, r4);
        return;
    }
}
