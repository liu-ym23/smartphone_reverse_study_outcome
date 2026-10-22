package com.ss.android.lark.gadget.util;

import android.os.SystemClock;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class TimeMeter {
    private static final long INIT_LEFT_VAL = -1;
    private static final String TAG = "TimeMeter";
    private AtomicLong mLeftPoint;
    private AtomicLong mLength;
    private volatile long mStartPoint;

    public long getMillisAfterStart() {
        if (this.mStartPoint != INIT_LEFT_VAL) goto L7;
        return 0;
    L7:
        return currentMillis() - this.mStartPoint;
    }

    public boolean isRunning() {
        if (INIT_LEFT_VAL != this.mLeftPoint.addAndGet(0)) goto L5;
    L7:
        return false;
    L5:
        if (0 != this.mLength.addAndGet(0)) goto L7;
        return true;
    }

    public long stop() {
        long r0 = this.mLeftPoint.get();
        if (INIT_LEFT_VAL == r0) goto L5;
        long r6 = currentMillis() - r0;
    L7:
        if (this.mLength.compareAndSet(0, r6) == false) goto L9;
        this.mLeftPoint.set(INIT_LEFT_VAL);
        AppBrandLogger.d(TAG, new Object[]{"stop: success " + this.mLength});
    L11:
        return this.mLength.get();
    L9:
        AppBrandLogger.d(TAG, new Object[]{"stop: fail " + this.mLength});
        goto L11
    L5:
        r6 = 0;
        goto L7
    }

    public TimeMeter() {
        this.mLength = new AtomicLong(0);
        AtomicLong r0 = new AtomicLong(INIT_LEFT_VAL);
        this.mLeftPoint = r0;
        this.mStartPoint = r0.get();
    }

    public static long currentMillis() {
        return SystemClock.uptimeMillis();
    }

    public static TimeMeter newAndStart() {
        return newAndStart(currentMillis());
    }

    public long start() {
        return start(currentMillis());
    }

    public static TimeMeter newAndStart(long r1) {
        TimeMeter r0 = new TimeMeter();
        r0.start(r1);
        return r0;
    }

    public static long nowAfterStart(TimeMeter r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.getMillisAfterStart();
    }

    public static long nowDiff(long r2) {
        return currentMillis() - r2;
    }

    private long start(long r5) {
        if (this.mLeftPoint.compareAndSet(INIT_LEFT_VAL, r5) == false) goto L5;
        this.mLength.set(0);
        this.mStartPoint = this.mLeftPoint.get();
        AppBrandLogger.d(TAG, new Object[]{"start: success " + this.mLeftPoint});
    L7:
        return this.mLeftPoint.get();
    L5:
        AppBrandLogger.d(TAG, new Object[]{"start: fail " + this.mLeftPoint});
        goto L7
    }

    public static long stop(TimeMeter r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.stop();
    }
}
