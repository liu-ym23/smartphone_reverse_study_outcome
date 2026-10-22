package com.lynx.jsbridge;

import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.CallStackUtil;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class RuntimeLifecycleListenerDelegate implements g {
    private static final String TAG = "RuntimeListenerDelegate";
    private g mListener;
    private final WeakReference<LynxContext> mLynxContextWeak;

    @Override // com.lynx.jsbridge.g
    public void onRuntimeDetach() {
        g r0 = this.mListener;
        if (r0 == null) goto L11;
        r0.onRuntimeDetach();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        onError(e);
        return;
    }

    private void onError(Exception r5) {
        LLog.e(TAG, r5.toString());
        LynxContext r0 = this.mLynxContextWeak.get();
        if (r0 == null) goto L6;
        String r1 = CallStackUtil.a(r5);
        LynxError r2 = new LynxError(20301, r5.getMessage());
        r2.setCallStack(r1);
        r0.handleLynxError(r2);
        return;
    }

    public RuntimeLifecycleListenerDelegate(WeakReference<LynxContext> r1, g r2) {
        this.mLynxContextWeak = r1;
        this.mListener = r2;
    }

    @Override // com.lynx.jsbridge.g
    public void onRuntimeAttach(long r2, String r4) {
        g r0 = this.mListener;
        if (r0 == null) goto L11;
        r0.onRuntimeAttach(r2, r4);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        onError(e);
        return;
    }
}
