package com.lynx.jsbridge;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.CallStackUtil;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class RuntimeLifecycleListenerDelegate implements s {
    private static final String TAG = "RuntimeListenerDelegate";
    private s mListener;
    private final WeakReference<LynxContext> mLynxContextWeak;

    public RuntimeLifecycleListenerDelegate(@NonNull WeakReference<LynxContext> r5, @NonNull s r10) {
        this.mLynxContextWeak = r5;
        this.mListener = r10;
    }

    private void onError(Exception r10) {
        LynxLog.b(4, TAG, r10.toString());
        LynxContext r5 = this.mLynxContextWeak.get();
        if (r5 == null) goto L6;
        String r11 = CallStackUtil.a(r10);
        LynxError r12 = new LynxError(20301, r10.getMessage(), "", "error");
        r12.g = null;
        r12.f9999n = r11;
        r5.b(r12);
        return;
    }

    @Override // com.lynx.jsbridge.s
    @CalledByNative
    public void onRuntimeAttach(long r5) {
        s r10 = this.mListener;
        if (r10 == null) goto L11;
        r10.onRuntimeAttach(r5);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        onError(e);
        return;
    }

    @Override // com.lynx.jsbridge.s
    @CalledByNative
    public void onRuntimeDetach() {
        s r5 = this.mListener;
        if (r5 == null) goto L11;
        r5.onRuntimeDetach();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        onError(e);
        return;
    }
}
