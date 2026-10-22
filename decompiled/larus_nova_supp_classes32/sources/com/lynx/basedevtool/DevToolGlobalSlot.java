package com.lynx.basedevtool;

import com.lynx.debugrouter.DebugRouter;
import com.lynx.debugrouter.DebugRouterGlobalHandler;
import z4a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class DevToolGlobalSlot implements DebugRouterGlobalHandler {
    private static final int GLOBAL_MESSAGE_SESSION_ID = -1;
    private static final int STATUS_UNINITIALIZED = -1;
    private long mNativeHandler;

    private native void nativeOnGlobalSlotMessage(long r1, String r3, String r4);

    @Override // com.lynx.debugrouter.DebugRouterGlobalHandler
    public void openCard(String r1) {
    }

    static {
        if (a.a == true) goto L12;
        a.a();     // Catch: UnsatisfiedLinkError -> L7
        a.a = true;     // Catch: UnsatisfiedLinkError -> L7
        return;
    L7:
        e = move-exception;
        e.getMessage();
        return;
    }

    private DevToolGlobalSlot(long r1) {
        this.mNativeHandler = r1;
        DebugRouter.getInstance().addGlobalHandler(this);
    }

    public static DevToolGlobalSlot createInstance(long r1) {
        return new DevToolGlobalSlot(r1);
    }

    public void sendMessage(String r3, String r4) {
        DebugRouter.getInstance().sendDataAsync(r3, -1, r4);
    }

    @Override // com.lynx.debugrouter.DebugRouterGlobalHandler
    public void onMessage(String r3, int r4, String r5) {
        nativeOnGlobalSlotMessage(this.mNativeHandler, r3, r5);
    }
}
