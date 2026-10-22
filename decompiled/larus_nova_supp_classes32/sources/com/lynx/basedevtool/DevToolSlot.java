package com.lynx.basedevtool;

import com.lynx.debugrouter.DebugRouterSlot;
import com.lynx.debugrouter.DebugRouterSlotDelegate;
import com.obric.aivoice.core.data.NameKeys;
import z4a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class DevToolSlot implements DebugRouterSlotDelegate {
    private static final int STATUS_UNINITIALIZED = -1;
    private DebugRouterSlot mDebugRouterSlot;
    private long mNativeHandler;
    private final Object mNativeHandlerLock;
    private String mTemplateUrl;

    private native void nativeOnSlotMessage(long r1, String r3, String r4);

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

    public void onNativeDestroyed() {
        Object r0 = this.mNativeHandlerLock;
        monitor-enter(r0);
        this.mNativeHandler = -1;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        DebugRouterSlot r1 = this.mDebugRouterSlot;
        if (r1 == null) goto L16;
        r1.pull();
        this.mDebugRouterSlot = null;
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void pull() {
        this.mDebugRouterSlot.pull();
    }

    @Override // com.lynx.debugrouter.DebugRouterSlotDelegate
    public String getTemplateUrl() {
        return this.mTemplateUrl;
    }

    private DevToolSlot(long r2) {
        this.mDebugRouterSlot = null;
        this.mTemplateUrl = NameKeys.UnloadStrategy_No_Strategy;
        this.mNativeHandlerLock = new Object();
        this.mNativeHandler = r2;
        this.mDebugRouterSlot = new DebugRouterSlot(this);
    }

    public static DevToolSlot createInstance(long r1) {
        return new DevToolSlot(r1);
    }

    public int plug(String r1) {
        this.mTemplateUrl = r1;
        return this.mDebugRouterSlot.plug();
    }

    @Override // com.lynx.debugrouter.DebugRouterSlotDelegate
    public void onMessage(String r7, String r8) {
        Object r0 = this.mNativeHandlerLock;
        monitor-enter(r0);
        long r1 = this.mNativeHandler;     // Catch: Throwable -> L11
        if (r1 != (-1)) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        nativeOnSlotMessage(r1, r7, r8);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void sendMessage(String r2, String r3) {
        this.mDebugRouterSlot.sendDataAsync(r2, r3);
    }
}
