package com.lynx.devtool;

import com.lynx.react.bridge.Callback;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ConsoleDelegateManager {
    private static AtomicInteger nextCallbackId;
    private com.lynx.devtoolwrapper.LynxInspectorConsoleDelegate mConsoleDelegate;
    private HashMap<Integer, Callback> mConsoleObjectCallback;

    static {
        nextCallbackId = new AtomicInteger(0);
    }

    public ConsoleDelegateManager() {
        this.mConsoleDelegate = null;
        this.mConsoleObjectCallback = null;
    }

    public void onConsoleMessage(String r2) {
        com.lynx.devtoolwrapper.LynxInspectorConsoleDelegate r0 = this.mConsoleDelegate;
        if (r0 == null) goto L6;
        r0.onConsoleMessage(r2);
        return;
    }

    public void onConsoleObject(String r4, int r5) {
        HashMap<Integer, Callback> r0 = this.mConsoleObjectCallback;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.containsKey(Integer.valueOf(r5)) == false) goto L12;
        Callback r1 = this.mConsoleObjectCallback.get(Integer.valueOf(r5));
        if (r1 == null) goto L9;
        r1.invoke(new Object[]{r4});
    L9:
        this.mConsoleObjectCallback.remove(Integer.valueOf(r5));
        return;
    }

    public void setLynxInspectorConsoleDelegate(Object r3, DevToolPlatformAndroidDelegate r4, long r5) {
        if ((r3 instanceof com.lynx.devtoolwrapper.LynxInspectorConsoleDelegate) == false) goto L10;
        this.mConsoleDelegate = (com.lynx.devtoolwrapper.LynxInspectorConsoleDelegate) r3;
        if (r4 != null) goto L7;
        return;
    L7:
        if (r5 == 0) goto L12;
        r4.nativeFlushConsoleMessages(r5);
        return;
    L12:
        return;
    }

    public void getConsoleObject(String r8, boolean r9, Callback r10, DevToolPlatformAndroidDelegate r11, long r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r12 != 0) goto L6;
        return;
    L6:
        if (this.mConsoleObjectCallback != null) goto L8;
        this.mConsoleObjectCallback = new HashMap();
    L8:
        int r6 = nextCallbackId.decrementAndGet();
        this.mConsoleObjectCallback.put(Integer.valueOf(r6), r10);
        r11.nativeGetConsoleObject(r12, r8, r9, r6);
    }
}
