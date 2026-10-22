package com.lynx.devtoolwrapper;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxDevToolPool {
    private static final String TAG = "LynxDevToolPool";
    private static int nextContextId;
    private boolean mDebuggable;
    private List<LynxDevtool> mDevtools;
    private long mNativePtr;
    private String mUrl;

    private native long nativeCreateDevToolPool();

    private native void nativeDestroyDevToolPool(long r1);

    public void destroy() {
        if (this.mDevtools.isEmpty() == true) goto L5;
        this.mDevtools.forEach(new b());
        this.mDevtools.clear();
    L5:
        long r0 = this.mNativePtr;
        if (r0 == 0) goto L9;
        nativeDestroyDevToolPool(r0);
        this.mNativePtr = 0;
        return;
    }

    public void popDevTool() {
        if (this.mDevtools.isEmpty() == false) goto L5;
        return;
    L5:
        List<LynxDevtool> r0 = this.mDevtools;
        ((LynxDevtool) ListProtector.get(r0, r0.size() - 1)).destroy();
        List<LynxDevtool> r1 = this.mDevtools;
        ListProtector.remove(r1, r1.size() - 1);
    }

    public void createDevTool() {
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L6;
        this.mDevtools.add(new LynxDevtool(null, this.mDebuggable));
        return;
    }

    public long getNativePtr() {
        return this.mNativePtr;
    }

    public void onMTSRuntimeCreated(long r4) {
        if (this.mDevtools.isEmpty() == false) goto L5;
        return;
    L5:
        List<LynxDevtool> r0 = this.mDevtools;
        LynxDevtool r1 = (LynxDevtool) ListProtector.get(r0, r0.size() - 1);
        r1.onMTSRuntimeCreated(r4);
        int r5 = nextContextId;
        nextContextId = r5 + 1;
        r1.attachToDebugBridge(String.format("%s - context%d", new Object[]{this.mUrl, Integer.valueOf(r5)}));
    }

    public LynxDevToolPool(String r3, boolean r4) {
        this.mDebuggable = false;
        this.mNativePtr = 0;
        LLog.i(TAG, "create LynxDevToolPool, url: " + r3 + ", debuggable: " + r4);
        this.mDevtools = new ArrayList();
        this.mDebuggable = r4;
        this.mUrl = r3;
        if (TextUtils.isEmpty(r3) == false) goto L5;
        this.mUrl = "anonymous bundle";
    L5:
        this.mNativePtr = nativeCreateDevToolPool();
    }
}
