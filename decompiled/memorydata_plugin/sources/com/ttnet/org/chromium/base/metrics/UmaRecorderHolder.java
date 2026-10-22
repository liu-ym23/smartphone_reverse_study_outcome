package com.ttnet.org.chromium.base.metrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class UmaRecorderHolder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static boolean sNativeInitialized;
    private static CachingUmaRecorder sRecorder;
    private static boolean sSetUpNativeUmaRecorder;

    static {
        sRecorder = new CachingUmaRecorder();
        sSetUpNativeUmaRecorder = true;
    }

    private UmaRecorderHolder() {
    }

    public static UmaRecorder get() {
        return sRecorder;
    }

    public static void onLibraryLoaded() {
        if (sSetUpNativeUmaRecorder == true) goto L5;
        return;
    L5:
        sNativeInitialized = true;
        sRecorder.setDelegate(new NativeUmaRecorder());
    }

    public static void resetForTesting() {
        if (sNativeInitialized == true) goto L6;
        sRecorder = new CachingUmaRecorder();
        return;
    }

    public static void setNonNativeDelegate(UmaRecorder r2) {
        UmaRecorder r3 = (UmaRecorder) ZeusTransformUtils.wrapperContextForParams(r2, UmaRecorder.class, "com.obric.memorydata.plugin");
        sRecorder.setDelegate(r3);
    }

    public static void setUpNativeUmaRecorder(boolean r0) {
        sSetUpNativeUmaRecorder = r0;
    }
}
