package com.lynx.tasm;

import androidx.annotation.RestrictTo;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.CalledByNative;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TasmPlatformInvoker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f10050a;

    @CalledByNative
    private void getI18nResourceByNative(String r5, String r10) {
        NativeFacade r11 = (NativeFacade) this.f10050a.get();
        if (r11 != null) goto L6;
        LynxLog.b(2, "TasmPlatformInvoker", "getI18nResourceByNative failed, NativeFacade has been released.");
        return;
    L6:
        r11.getI18nResourceByNative(r5, r10);
    }

    @CalledByNative
    private void onPageConfigDecoded(ReadableMap r5) {
        NativeFacade r10 = (NativeFacade) this.f10050a.get();
        if (r10 != null) goto L6;
        LynxLog.b(2, "TasmPlatformInvoker", "onPageConfigDecoded failed, NativeFacade has been released.");
        return;
    L6:
        r10.onPageConfigDecoded(r5);
    }

    @CalledByNative
    private void onRunPipelineFinished() {
        NativeFacade r5 = (NativeFacade) this.f10050a.get();
        if (r5 != null) goto L6;
        LynxLog.b(2, "TasmPlatformInvoker", "OnRunPipelineFinished failed, NativeFacade has been released.");
        return;
    L6:
        r5.onRunPipelineFinished();
    }

    @CalledByNative
    private String translateResourceForTheme(String r5, String r10) {
        NativeFacade r11 = (NativeFacade) this.f10050a.get();
        if (r11 != null) goto L7;
        LynxLog.b(2, "TasmPlatformInvoker", "translateResourceForTheme failed, NativeFacade has been released.");
        return null;
    L7:
        return r11.translateResourceForTheme(r5, r10);
    }

    @CalledByNative
    private ByteBuffer triggerLepusBridge(String r5, Object r10) {
        NativeFacade r11 = (NativeFacade) this.f10050a.get();
        if (r11 != null) goto L7;
        LynxLog.b(2, "TasmPlatformInvoker", "triggerLepusBridge failed, NativeFacade has been released.");
        return null;
    L7:
        return r11.triggerLepusBridge(r5, r10);
    }

    @CalledByNative
    private void triggerLepusBridgeAsync(String r5, Object r10) {
        NativeFacade r11 = (NativeFacade) this.f10050a.get();
        if (r11 != null) goto L6;
        LynxLog.b(2, "TasmPlatformInvoker", "triggerLepusBridgeAsync failed, NativeFacade has been released.");
        return;
    L6:
        r11.triggerLepusBridgeAsync(r5, r10);
    }
}
