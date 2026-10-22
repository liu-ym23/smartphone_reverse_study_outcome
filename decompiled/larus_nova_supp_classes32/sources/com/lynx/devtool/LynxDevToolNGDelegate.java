package com.lynx.devtool;

import com.lynx.devtoolwrapper.CDPEventListener;
import com.lynx.devtoolwrapper.CDPResultCallback;
import com.lynx.devtoolwrapper.MessageHandler;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxDevToolNGDelegate {
    private final Object mDevToolLock;
    private final AtomicBoolean mHasDestroy;
    private long mLynxDevToolNGPtr;
    private int mSessionId;

    private native void nativeAddCDPEventListener(long r1, String r3, CDPEventListenerWrapper r4);

    private native int nativeAttachToDebug(long r1, String r3);

    private native long nativeCreateLynxDevToolNG(boolean r1);

    private native void nativeDestroy(long r1);

    private native void nativeDetachToDebug(long r1);

    private native void nativeInvokeCDPFromSDK(long r1, String r3, CDPResultCallbackWrapper r4);

    private native long nativeOnBackgroundRuntimeCreated(long r1, String r3);

    private native void nativeOnMTSRuntimeCreated(long r1, long r3);

    private native void nativeOnTasmCreated(long r1, long r3);

    private native void nativeRemoveCDPEventListener(long r1, String r3);

    private native void nativeSendMessageToDebugPlatform(long r1, String r3, String r4);

    private native void nativeSetDevToolPlatformAbility(long r1, long r3);

    private native void nativeSetTag(long r1, String r3);

    private native void nativeSubscribeMessage(long r1, String r3, DevToolMessageHandlerDelegate r4);

    private native void nativeUnSubscribeMessage(long r1, String r3);

    private native void nativeUpdateDevice(int r1, int r2, float r3);

    public void destroy() {
        if (this.mHasDestroy.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Object r0 = this.mDevToolLock;
        monitor-enter(r0);
        long r1 = this.mLynxDevToolNGPtr;     // Catch: Throwable -> L12
        if (r1 == 0) goto L10;
        nativeDestroy(r1);     // Catch: Throwable -> L12
        this.mLynxDevToolNGPtr = 0;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void detachToDebug() {
        long r0 = this.mLynxDevToolNGPtr;
        if (r0 == 0) goto L6;
        nativeDetachToDebug(r0);
        this.mSessionId = 0;
        return;
    }

    public boolean isAttachToDebugRouter() {
        if (this.mSessionId == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getSessionId() {
        return this.mSessionId;
    }

    public LynxDevToolNGDelegate(boolean r3) {
        this.mLynxDevToolNGPtr = 0;
        this.mSessionId = 0;
        this.mHasDestroy = new AtomicBoolean(false);
        this.mDevToolLock = new Object();
        this.mLynxDevToolNGPtr = nativeCreateLynxDevToolNG(r3);
    }

    public int attachToDebug(String r6) {
        long r0 = this.mLynxDevToolNGPtr;
        if (r0 == 0) goto L6;
        int r7 = nativeAttachToDebug(r0, r6);
        this.mSessionId = r7;
        return r7;
    L6:
        return 0;
    }

    public long onBackgroundRuntimeCreated(String r6) {
        long r0 = this.mLynxDevToolNGPtr;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        return nativeOnBackgroundRuntimeCreated(r0, r6);
    }

    public void onMTSRuntimeCreated(long r6) {
        long r0 = this.mLynxDevToolNGPtr;
        if (r0 == 0) goto L6;
        nativeOnMTSRuntimeCreated(r0, r6);
        return;
    }

    public void onTASMCreated(long r6) {
        long r0 = this.mLynxDevToolNGPtr;
        if (r0 == 0) goto L6;
        nativeOnTasmCreated(r0, r6);
        return;
    }

    public void removeCDPEventListener(String r3) {
        nativeRemoveCDPEventListener(this.mLynxDevToolNGPtr, r3);
    }

    public void setDevToolPlatformAbility(long r6) {
        long r0 = this.mLynxDevToolNGPtr;
        if (r0 == 0) goto L6;
        nativeSetDevToolPlatformAbility(r0, r6);
        return;
    }

    public void setTag(String r6) {
        long r0 = this.mLynxDevToolNGPtr;
        if (r0 == 0) goto L6;
        nativeSetTag(r0, r6);
        return;
    }

    public void unSubscribeMessage(String r3) {
        nativeUnSubscribeMessage(this.mLynxDevToolNGPtr, r3);
    }

    public void addCDPEventListener(String r4, CDPEventListener r5) {
        nativeAddCDPEventListener(this.mLynxDevToolNGPtr, r4, new CDPEventListenerWrapper(r5));
    }

    public void invokeCDPFromSDK(String r4, CDPResultCallback r5) {
        nativeInvokeCDPFromSDK(this.mLynxDevToolNGPtr, r4, new CDPResultCallbackWrapper(r5));
    }

    public void sendMessageToDebugPlatform(String r7, String r8) {
        if (this.mHasDestroy.get() == false) goto L5;
        return;
    L5:
        Object r0 = this.mDevToolLock;
        monitor-enter(r0);
        long r1 = this.mLynxDevToolNGPtr;     // Catch: Throwable -> L12
        if (r1 == 0) goto L10;
        nativeSendMessageToDebugPlatform(r1, r7, r8);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void subscribeMessage(String r4, MessageHandler r5) {
        nativeSubscribeMessage(this.mLynxDevToolNGPtr, r4, new DevToolMessageHandlerDelegate(r5));
    }

    public void updateScreenMetrics(int r1, int r2, float r3) {
        nativeUpdateDevice(r1, r2, r3);
    }
}
