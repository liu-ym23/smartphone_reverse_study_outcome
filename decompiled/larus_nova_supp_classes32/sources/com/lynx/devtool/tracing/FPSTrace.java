package com.lynx.devtool.tracing;

import android.os.Looper;
import android.util.Printer;
import com.lynx.devtool.framecapture.FrameTraceUtil;
import com.lynx.tasm.base.TraceEvent;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FPSTrace {
    private static final int CALLBACK_INPUT = 0;
    private boolean isVsyncFrame;
    private Runnable mCallback;
    private ExecutorService mExecutorService;
    private long mNativeFPSTrace;
    private LooperPrinter mPrinter;
    private long mStartTimestamp;

    public static class FPSTraceLoader {
        private static final FPSTrace INSTANCE = null;

        private FPSTraceLoader() {
        }

        static {
            INSTANCE = new FPSTrace(null);
        }

        public static /* synthetic */ FPSTrace access$200() {
            return INSTANCE;
        }
    }

    public class LooperPrinter implements Printer {
        private Printer mOrigin;
        final /* synthetic */ FPSTrace this$0;

        public Printer getOrigin() {
            return this.mOrigin;
        }

        @Override // android.util.Printer
        public void println(String r4) {
            Printer r0 = this.mOrigin;
            if (r0 == null) goto L5;
            r0.println(r4);
        L5:
            if (r4 != null) goto L8;
            return;
        L8:
            if (r4.charAt(0) != '>') goto L11;
            FPSTrace.access$300(this.this$0);
            return;
        L11:
            if (r4.charAt(0) != '<') goto L15;
            FPSTrace.access$400(this.this$0);
            return;
        }

        public LooperPrinter(FPSTrace r1, Printer r2) {
            this.this$0 = r1;
            this.mOrigin = r2;
        }
    }

    private void dispatchBegin() {
        this.isVsyncFrame = false;
        this.mStartTimestamp = FrameTraceUtil.getSystemBootTimeNs();
    }

    private native long nativeCreateFPSTrace();

    private void addFPSCallback() {
        if (TraceEvent.categoryEnabled(3) == false) goto L6;
        FrameTraceUtil.addFrameCallback(this.mCallback);
        return;
    }

    private void dispatchEnd() {
        if (this.isVsyncFrame == false) goto L6;
        this.isVsyncFrame = false;
        addFPSCallback();
        long r0 = FrameTraceUtil.getSystemBootTimeNs();
        record(this.mStartTimestamp, r0);
        return;
    }

    public void startFPSTrace() {
        if (TraceEvent.categoryEnabled(3) == false) goto L13;
        FrameTraceService.getInstance().initializeService();
        this.mExecutorService = PThreadExecutorsUtils.newCachedThreadPool(new AnonymousClass2(this));
        Looper r0 = Looper.getMainLooper();     // Catch: Throwable -> L7
        Field r1 = Looper.class.getDeclaredField("mLogging");     // Catch: Throwable -> L7
        r1.setAccessible(true);     // Catch: Throwable -> L7
        LooperPrinter r2 = new LooperPrinter(this, (Printer) r1.get(r0));     // Catch: Throwable -> L7
        this.mPrinter = r2;     // Catch: Throwable -> L7
        r0.setMessageLogging(r2);     // Catch: Throwable -> L7
    L9:
        addFPSCallback();
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    public void stopFPSTrace() {
        if (this.mPrinter == null) goto L5;
        Looper.getMainLooper().setMessageLogging(this.mPrinter.getOrigin());
        this.mPrinter = null;
    L5:
        ExecutorService r0 = this.mExecutorService;
        if (r0 == null) goto L9;
        r0.shutdown();
        this.mExecutorService = null;
        return;
    }

    private FPSTrace() {
        this.isVsyncFrame = false;
        this.mNativeFPSTrace = 0;
        this.mNativeFPSTrace = nativeCreateFPSTrace();
        this.mCallback = new AnonymousClass1(this);
    }

    public static FPSTrace getInstance() {
        return FPSTraceLoader.access$200();
    }

    public long getNativeFPSTrace() {
        return this.mNativeFPSTrace;
    }

    public /* synthetic */ FPSTrace(AnonymousClass1 r1) {
        this();
    }

    public static /* synthetic */ void access$300(FPSTrace r0) {
        r0.dispatchBegin();
    }

    public static /* synthetic */ void access$400(FPSTrace r0) {
        r0.dispatchEnd();
    }

    public static /* synthetic */ boolean access$002(FPSTrace r0, boolean r1) {
        r0.isVsyncFrame = r1;
        return r1;
    }

    private void record(final long r9, final long r11) {
        if ((r11 - r9) < FrameTraceUtil.getFrameIntervalNanos()) goto L8;
        ExecutorService r0 = this.mExecutorService;
        if (r0 == null) goto L9;
        r0.submit(new AnonymousClass3(this, r9, r11));
        return;
    L9:
        return;
    }
}
