package com.obric.aivoice.core.data;

import android.os.Bundle;
import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020%H\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/aivoice/core/data/TimeLog;", NameKeys.UnloadStrategy_No_Strategy, "exeTime", NameKeys.UnloadStrategy_No_Strategy, "encodeImageTime", "inferenceTime", "loadModelTime", "(JJJJ)V", "getEncodeImageTime", "()J", "setEncodeImageTime", "(J)V", "getExeTime", "setExeTime", "getInferenceTime", "setInferenceTime", "initialTickTime", "lastTickTime", "getLoadModelTime", "setLoadModelTime", "tickTime", "component1", "component2", "component3", "component4", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "getLastTickSpan", "getTotalTickSpan", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "tick", "toBundle", "Landroid/os/Bundle;", "toString", NameKeys.UnloadStrategy_No_Strategy, "Companion", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimeLog {
    public static final Companion Companion = null;
    private static final String KEY_ENCODE_IMAGE_TIME = "encodeImage";
    private static final String KEY_EXE_TIME = "exe";
    private static final String KEY_INFERENCE_TIME = "inference";
    private static final String KEY_LOAD_MODEL_TIME = "loadModel";
    private long encodeImageTime;
    private long exeTime;
    private long inferenceTime;
    private final long initialTickTime;
    private volatile long lastTickTime;
    private long loadModelTime;
    private volatile long tickTime;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/aivoice/core/data/TimeLog$Companion;", NameKeys.UnloadStrategy_No_Strategy, "()V", "KEY_ENCODE_IMAGE_TIME", NameKeys.UnloadStrategy_No_Strategy, "KEY_EXE_TIME", "KEY_INFERENCE_TIME", "KEY_LOAD_MODEL_TIME", "fromBundle", "Lcom/obric/aivoice/core/data/TimeLog;", "timeCostBundle", "Landroid/os/Bundle;", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final TimeLog fromBundle(Bundle r14) {
            Intrinsics.checkNotNullParameter(r14, "timeCostBundle");
            long r2 = 0;
            if (r14.containsKey(TimeLog.KEY_EXE_TIME) == false) goto L5;
            long r5 = r14.getLong(TimeLog.KEY_EXE_TIME, 0);
        L7:
            if (r14.containsKey(TimeLog.KEY_ENCODE_IMAGE_TIME) == false) goto L9;
            long r7 = r14.getLong(TimeLog.KEY_ENCODE_IMAGE_TIME, 0);
        L11:
            if (r14.containsKey(TimeLog.KEY_INFERENCE_TIME) == false) goto L13;
            long r9 = r14.getLong(TimeLog.KEY_INFERENCE_TIME, 0);
        L15:
            if (r14.containsKey(TimeLog.KEY_LOAD_MODEL_TIME) == false) goto L18;
            r2 = r14.getLong(TimeLog.KEY_LOAD_MODEL_TIME, 0);
        L18:
            return new TimeLog(r5, r7, r9, r2);
        L13:
            r9 = 0;
            goto L15
        L9:
            r7 = 0;
            goto L11
        L5:
            r5 = 0;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TimeLog() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ TimeLog copy$default(TimeLog r9, long r10, long r12, long r14, long r16, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        long r1 = r9.exeTime;
    L7:
        if ((r18 & 2) == 0) goto L9;
        long r3 = r9.encodeImageTime;
    L11:
        if ((r18 & 4) == 0) goto L13;
        long r5 = r9.inferenceTime;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r7 = r9.loadModelTime;
    L19:
        return r9.copy(r1, r3, r5, r7);
    L17:
        r7 = r16;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final long component1() {
        return this.exeTime;
    }

    public final long component2() {
        return this.encodeImageTime;
    }

    public final long component3() {
        return this.inferenceTime;
    }

    public final long component4() {
        return this.loadModelTime;
    }

    public final TimeLog copy(long r11, long r13, long r15, long r17) {
        return new TimeLog(r11, r13, r15, r17);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof TimeLog) == true) goto L8;
        return false;
    L8:
        TimeLog r9 = (TimeLog) r8;
        if (this.exeTime == r9.exeTime) goto L12;
        return false;
    L12:
        if (this.encodeImageTime == r9.encodeImageTime) goto L15;
        return false;
    L15:
        if (this.inferenceTime == r9.inferenceTime) goto L18;
        return false;
    L18:
        if (this.loadModelTime == r9.loadModelTime) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r0 = this.exeTime;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.encodeImageTime;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.inferenceTime;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.loadModelTime;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    }

    public final long getLastTickSpan() {
        return this.tickTime - this.lastTickTime;
    }

    public final long getTotalTickSpan() {
        return this.tickTime - this.initialTickTime;
    }

    public final long tick() {
        this.lastTickTime = this.tickTime;
        this.tickTime = SystemClock.elapsedRealtime();
        return getLastTickSpan();
    }

    public final Bundle toBundle() {
        Bundle r0 = new Bundle();
        long r1 = this.exeTime;
        if (r1 <= 0) goto L5;
        r0.putLong(KEY_EXE_TIME, r1);
    L5:
        long r2 = this.encodeImageTime;
        if (r2 <= 0) goto L8;
        r0.putLong(KEY_ENCODE_IMAGE_TIME, r2);
    L8:
        long r3 = this.inferenceTime;
        if (r3 <= 0) goto L11;
        r0.putLong(KEY_INFERENCE_TIME, r3);
    L11:
        long r4 = this.loadModelTime;
        if (r4 <= 0) goto L14;
        r0.putLong(KEY_LOAD_MODEL_TIME, r4);
    L14:
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("exe: " + this.exeTime);
        if (this.encodeImageTime <= 0) goto L6;
        r0.append(", img: " + this.encodeImageTime);
    L6:
        if (this.loadModelTime <= 0) goto L9;
        r0.append(", load: " + this.loadModelTime);
    L9:
        if (this.inferenceTime <= 0) goto L12;
        r0.append(", infer: " + this.inferenceTime);
    L12:
        return r0.toString();
    }

    public final long getEncodeImageTime() {
        return this.encodeImageTime;
    }

    public final long getExeTime() {
        return this.exeTime;
    }

    public final long getInferenceTime() {
        return this.inferenceTime;
    }

    public final long getLoadModelTime() {
        return this.loadModelTime;
    }

    public final void setEncodeImageTime(long r1) {
        this.encodeImageTime = r1;
    }

    public final void setExeTime(long r1) {
        this.exeTime = r1;
    }

    public final void setInferenceTime(long r1) {
        this.inferenceTime = r1;
    }

    public final void setLoadModelTime(long r1) {
        this.loadModelTime = r1;
    }

    public TimeLog(long r1, long r3, long r5, long r7) {
        this.exeTime = r1;
        this.encodeImageTime = r3;
        this.inferenceTime = r5;
        this.loadModelTime = r7;
        long r2 = SystemClock.elapsedRealtime();
        this.initialTickTime = r2;
        this.tickTime = r2;
        this.lastTickTime = r2;
    }

    public /* synthetic */ TimeLog(long r10, long r12, long r14, long r16, int r18, DefaultConstructorMarker r19) {
        long r1 = 0;
        if ((r18 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r18 & 2) == 0) goto L9;
        long r5 = 0;
    L11:
        if ((r18 & 4) == 0) goto L13;
        long r7 = 0;
    L15:
        if ((r18 & 8) != 0) goto L18;
        r1 = r16;
    L18:
        this(r3, r5, r7, r1);
        return;
    L13:
        r7 = r14;
        goto L15
    L9:
        r5 = r12;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }
}
