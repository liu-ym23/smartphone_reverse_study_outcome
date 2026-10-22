package com.bytedance.android.ec.core.abtest;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/core/abtest/ECSettingsConfig;", "Ljava/io/Serializable;", "preloadEnable", "", "cacheEnable", "delayInitDuration", "", "batchSize", "", "sleepTime", "(ZZJIJ)V", "getBatchSize", "()I", "getCacheEnable", "()Z", "getDelayInitDuration", "()J", "getPreloadEnable", "getSleepTime", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSettingsConfig implements Serializable {

    @SerializedName("batch_size")
    private final int batchSize;

    @SerializedName("cache_enable")
    private final boolean cacheEnable;

    @SerializedName("delay_init_duration")
    private final long delayInitDuration;

    @SerializedName("preload_enable")
    private final boolean preloadEnable;

    @SerializedName("sleep_time")
    private final long sleepTime;

    public ECSettingsConfig() {
        this(false, false, 0, 0, 0, 31, null);
    }

    public final int getBatchSize() {
        return this.batchSize;
    }

    public final boolean getCacheEnable() {
        return this.cacheEnable;
    }

    public final long getDelayInitDuration() {
        return this.delayInitDuration;
    }

    public final boolean getPreloadEnable() {
        return this.preloadEnable;
    }

    public final long getSleepTime() {
        return this.sleepTime;
    }

    public ECSettingsConfig(boolean r1, boolean r10, long r11, int r12, long r13) {
        this.preloadEnable = r1;
        this.cacheEnable = r10;
        this.delayInitDuration = r11;
        this.batchSize = r12;
        this.sleepTime = r13;
    }

    public /* synthetic */ ECSettingsConfig(boolean r10, boolean r11, long r12, int r13, long r14, int r15, DefaultConstructorMarker r16) {
        int r0 = 0;
        if ((r15 & 1) == 0) goto L5;
        boolean r17 = false;
    L7:
        if ((r15 & 2) == 0) goto L9;
        boolean r1 = false;
    L11:
        if ((r15 & 4) == 0) goto L13;
        r12 = 0;
    L13:
        long r18 = r12;
        if ((r15 & 8) != 0) goto L18;
        r0 = r13;
    L18:
        if ((r15 & 16) == 0) goto L20;
        r14 = 200;
    L20:
        long r19 = r14;
        this(r17, r1, r18, r0, r19);
        return;
    L9:
        r1 = r11;
        goto L11
    L5:
        r17 = r10;
        goto L7
    }
}
