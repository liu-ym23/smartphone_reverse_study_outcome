package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/s;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "a", "()Z", "setEnable", "(Z)V", BuildConfig.FLAVOR, "minDuration", "J", "d", "()J", "setMinDuration", "(J)V", "loopDuration", "c", "setLoopDuration", "enableAlarm", "b", "setEnableAlarm", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_alarm")
    private boolean enableAlarm;

    @SerializedName("loop_duration")
    private long loopDuration;

    @SerializedName("min_duration")
    private long minDuration;

    public s() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof s) == false) goto L14;
        s r7 = (s) r6;
        if (this.enable == r7.enable) goto L8;
        return false;
    L8:
        if (this.minDuration == r7.minDuration) goto L10;
        return false;
    L10:
        if (this.loopDuration == r7.loopDuration) goto L12;
        return false;
    L12:
        if (this.enableAlarm == r7.enableAlarm) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        long r3 = this.minDuration;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.loopDuration;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        boolean r7 = this.enableAlarm;
        if (r7 == true) goto L10;
        r1 = r7;
    L10:
        return r6 + r1;
    }

    public final String toString() {
        return "LiveInteractivityMonitorConfig(enable=" + this.enable + ", minDuration=" + this.minDuration + ", loopDuration=" + this.loopDuration + ", enableAlarm=" + this.enableAlarm + ")";
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.enableAlarm;
    }

    public final long c() {
        return this.loopDuration;
    }

    public final long d() {
        return this.minDuration;
    }

    public s(int r3) {
        this.enable = false;
        this.minDuration = 6000;
        this.loopDuration = 60000;
        this.enableAlarm = true;
    }
}
