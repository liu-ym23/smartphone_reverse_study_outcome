package com.bytedance.android.ec.core.anchorv3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000bR\u001a\u0010\u001d\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001e\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/core/anchorv3/m;", "", "", "delaySliceDuration", "J", "a", "()J", "", "preloadClasses", "Z", "f", "()Z", "preloadSlice", "g", "", "optSlice", "I", "d", "()I", "jitBatchNumber", "getJitBatchNumber", "sleepTime", "getSleepTime", "asyncRenderTime", "getAsyncRenderTime", "optMainThread", "c", "optWireFrame", "e", "optHalfListHeight", "b", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("async_render_time")
    private final int asyncRenderTime;

    @SerializedName("delay_slice_duration")
    private final long delaySliceDuration;

    @SerializedName("jit_batch_number")
    private final int jitBatchNumber;

    @SerializedName("opt_half_list_height")
    private final boolean optHalfListHeight;

    @SerializedName("opt_main_thread")
    private final boolean optMainThread;

    @SerializedName("opt_slice")
    private final int optSlice;

    @SerializedName("opt_wire_frame")
    private final boolean optWireFrame;

    @SerializedName("preload_classes")
    private final boolean preloadClasses;

    @SerializedName("preload_slice")
    private final boolean preloadSlice;

    @SerializedName("sleep_time")
    private final long sleepTime;

    public m() {
        this(false, false, 0, false, false, 1023);
    }

    public final long a() {
        return this.delaySliceDuration;
    }

    public final boolean b() {
        return this.optHalfListHeight;
    }

    public final boolean c() {
        return this.optMainThread;
    }

    public final int d() {
        return this.optSlice;
    }

    public final boolean e() {
        return this.optWireFrame;
    }

    public final boolean f() {
        return this.preloadClasses;
    }

    public final boolean g() {
        return this.preloadSlice;
    }

    public m(boolean r10, boolean r11, int r12, boolean r13, boolean r14, int r15) {
        long r1 = 0;
        if ((r15 & 1) == 0) goto L5;
        long r16 = 2000;
    L6:
        boolean r17 = false;
        if ((r15 & 2) == 0) goto L10;
        r10 = false;
    L10:
        if ((r15 & 4) == 0) goto L13;
        r11 = false;
    L13:
        if ((r15 & 8) == 0) goto L16;
        r12 = 1;
    L16:
        if ((r15 & 16) == 0) goto L18;
        int r0 = 80;
    L20:
        if ((r15 & 32) == 0) goto L23;
        r1 = 50;
    L23:
        if ((r15 & 64) == 0) goto L25;
        int r18 = 2;
    L27:
        if ((r15 & 128) == 0) goto L30;
        r13 = false;
    L30:
        if ((r15 & 256) == 0) goto L33;
        r14 = false;
    L33:
        if ((r15 & 512) == 0) goto L35;
        r17 = true;
    L35:
        this.delaySliceDuration = r16;
        this.preloadClasses = r10;
        this.preloadSlice = r11;
        this.optSlice = r12;
        this.jitBatchNumber = r0;
        this.sleepTime = r1;
        this.asyncRenderTime = r18;
        this.optMainThread = r13;
        this.optWireFrame = r14;
        this.optHalfListHeight = r17;
        return;
    L25:
        r18 = 0;
        goto L27
    L18:
        r0 = 0;
        goto L20
    L5:
        r16 = 0;
        goto L6
    }
}
