package com.lynx.devtool.tracing;

import com.lynx.tasm.base.TraceEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FrameTraceService {
    private long mNativePtr;

    /* JADX INFO: renamed from: com.lynx.devtool.tracing.FrameTraceService$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class FrameTraceServiceLoader {
        private static final FrameTraceService INSTANCE = null;

        private FrameTraceServiceLoader() {
        }

        static {
            INSTANCE = new FrameTraceService(null);
        }

        public static /* synthetic */ FrameTraceService access$100() {
            return INSTANCE;
        }
    }

    private native long nativeCreateFrameTraceService();

    private native void nativeFPSTrace(long r1, long r3, long r5);

    private native void nativeInitialize(long r1);

    private native void nativeScreenshot(long r1, String r3);

    public void initializeService() {
        nativeInitialize(this.mNativePtr);
    }

    private FrameTraceService() {
        this.mNativePtr = 0;
        this.mNativePtr = nativeCreateFrameTraceService();
    }

    public static FrameTraceService getInstance() {
        return FrameTraceServiceLoader.access$100();
    }

    public /* synthetic */ FrameTraceService(AnonymousClass1 r1) {
        this();
    }

    public void screenshot(String r3) {
        if (TraceEvent.enablePerfettoTrace() == true) goto L5;
        return;
    L5:
        if (TraceEvent.categoryEnabled(2) == false) goto L9;
        nativeScreenshot(this.mNativePtr, r3);
        return;
    }

    public void FPSTrace(long r9, long r11) {
        if (TraceEvent.enablePerfettoTrace() == false) goto L6;
        nativeFPSTrace(this.mNativePtr, r9, r11);
        return;
    }
}
