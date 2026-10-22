package com.lynx.tasm;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class TasmPlatformInvoker {
    public WeakReference<NativeFacade> a;

    private void onRunPipelineFinished() {
        NativeFacade r0 = this.a.get();
        if (r0 != null) goto L6;
        LLog.i("TasmPlatformInvoker", "OnRunPipelineFinished failed, NativeFacade has been released.");
        return;
    L6:
        r0.onRunPipelineFinished();
    }

    public TasmPlatformInvoker(NativeFacade r2) {
        this.a = new WeakReference(r2);
    }

    private void onPageConfigDecoded(ReadableMap r2) {
        NativeFacade r0 = this.a.get();
        if (r0 != null) goto L6;
        LLog.i("TasmPlatformInvoker", "onPageConfigDecoded failed, NativeFacade has been released.");
        return;
    L6:
        r0.onPageConfigDecoded(r2);
    }

    private void getI18nResourceByNative(String r2, String r3) {
        NativeFacade r0 = this.a.get();
        if (r0 != null) goto L6;
        LLog.i("TasmPlatformInvoker", "getI18nResourceByNative failed, NativeFacade has been released.");
        return;
    L6:
        r0.getI18nResourceByNative(r2, r3);
    }

    private String translateResourceForTheme(String r2, String r3) {
        NativeFacade r0 = this.a.get();
        if (r0 != null) goto L7;
        LLog.i("TasmPlatformInvoker", "translateResourceForTheme failed, NativeFacade has been released.");
        return null;
    L7:
        return r0.translateResourceForTheme(r2, r3);
    }

    private ByteBuffer triggerLepusBridge(String r2, Object r3) {
        NativeFacade r0 = this.a.get();
        if (r0 != null) goto L7;
        LLog.i("TasmPlatformInvoker", "triggerLepusBridge failed, NativeFacade has been released.");
        return null;
    L7:
        return r0.triggerLepusBridge(r2, r3);
    }

    private void triggerLepusBridgeAsync(String r2, Object r3) {
        NativeFacade r0 = this.a.get();
        if (r0 != null) goto L6;
        LLog.i("TasmPlatformInvoker", "triggerLepusBridgeAsync failed, NativeFacade has been released.");
        return;
    L6:
        r0.triggerLepusBridgeAsync(r2, r3);
    }
}
