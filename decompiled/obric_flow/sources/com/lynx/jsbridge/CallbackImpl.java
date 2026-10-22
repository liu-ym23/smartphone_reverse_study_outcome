package com.lynx.jsbridge;

import androidx.annotation.Keep;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.WritableArray;
import com.lynx.tasm.base.CalledByNative;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class CallbackImpl implements Callback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean mInvoked;
    private long mNativePtr;

    @Keep
    public CallbackImpl(long r5) {
        this.mNativePtr = r5;
        this.mInvoked = false;
    }

    @Keep
    private native void nativeInvoke(long r5, WritableArray r10);

    @Keep
    private native void nativeReleaseNativePtr(long r5);

    public void finalize() {
        super.finalize();
        nativeReleaseNativePtr(this.mNativePtr);
    }

    @Override // com.lynx.react.bridge.Callback
    @Keep
    public void invoke(Object... r10) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mInvoked == false) goto L10;
        LynxLog.b(4, "LynxModule", "Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        this.mInvoked = true;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        long r5 = this.mNativePtr;
        if (r5 != 0) goto L16;
        LynxLog.b(4, "LynxModule", "callback invoke failed: mNativePtr is NULL");
        return;
    L16:
        nativeInvoke(r5, new JavaOnlyArray(Arrays.asList(r10)));
    }

    @Keep
    public void invokeCallback(Object... r10) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mInvoked == false) goto L10;
        LynxLog.b(4, "LynxModule", "Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        this.mInvoked = true;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        long r5 = this.mNativePtr;
        if (r5 != 0) goto L16;
        LynxLog.b(4, "LynxModule", "callback invoke failed: mNativePtr is NULL");
        return;
    L16:
        nativeInvoke(r5, new JavaOnlyArray(Arrays.asList(r10)));
    }

    @Keep
    @CalledByNative
    public void resetNativePtr() {
        this.mNativePtr = 0;
    }
}
