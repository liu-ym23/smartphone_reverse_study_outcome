package com.bytedance.vmsdk.jsbridge;

import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.CalledByNative;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;
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

    @Override // com.bytedance.vmsdk.jsbridge.utils.Callback
    @Keep
    public void invoke(Object... r10) {
        if (this.mInvoked == false) goto L6;
        Log.d("VmsdkModule", "Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");
        return;
    L6:
        long r5 = this.mNativePtr;
        if (r5 != 0) goto L10;
        Log.e("VmsdkModule", "callback invoke failed: mNativePtr is NULL");
        return;
    L10:
        if (r10 != null) goto L12;
        JavaOnlyArray r11 = new JavaOnlyArray();
    L13:
        nativeInvoke(r5, r11);
        this.mInvoked = true;
        return;
    L12:
        r11 = new JavaOnlyArray(Arrays.asList(r10));
        goto L13
    }

    @Keep
    public void invokeCallback(Object... r10) {
        if (this.mInvoked == false) goto L6;
        Log.d("VmsdkModule", "Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");
        return;
    L6:
        long r5 = this.mNativePtr;
        if (r5 != 0) goto L10;
        Log.e("VmsdkModule", "callback invoke failed: mNativePtr is NULL");
        return;
    L10:
        if (r10 != null) goto L12;
        JavaOnlyArray r11 = new JavaOnlyArray();
    L13:
        nativeInvoke(r5, r11);
        this.mInvoked = true;
        return;
    L12:
        r11 = new JavaOnlyArray(Arrays.asList(r10));
        goto L13
    }

    @CalledByNative
    @Keep
    public void resetNativePtr() {
        this.mNativePtr = 0;
    }
}
