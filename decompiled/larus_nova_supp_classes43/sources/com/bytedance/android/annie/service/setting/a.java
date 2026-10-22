package com.bytedance.android.annie.service.setting;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/annie/service/setting/a;", "", "", "enable", "Z", "b", "()Z", "", "maxReportTimes", "I", "c", "()I", "sample", "e", "", "cycleInterval", "J", "a", "()J", "reportDeadLoop", "d", "f", "(I)V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class a {
    public static final a b = null;
    public static final a c = null;
    public final long a;

    @SerializedName("cycle_interval")
    private final long cycleInterval;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("max_report_times")
    private final int maxReportTimes;

    @SerializedName("report_dead_loop")
    private int reportDeadLoop;

    @SerializedName("sample")
    private final int sample;

    /* JADX INFO: renamed from: com.bytedance.android.annie.service.setting.a$a, reason: collision with other inner class name */
    public static final class C0085a {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.enable == r11.enable) goto L12;
        return false;
    L12:
        if (this.maxReportTimes == r11.maxReportTimes) goto L15;
        return false;
    L15:
        if (this.sample == r11.sample) goto L18;
        return false;
    L18:
        if (this.cycleInterval == r11.cycleInterval) goto L21;
        return false;
    L21:
        if (this.a == r11.a) goto L24;
        return false;
    L24:
        if (this.reportDeadLoop == r11.reportDeadLoop) goto L26;
        return false;
    L26:
        return true;
    }

    public final void f() {
        this.reportDeadLoop = 0;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((((r0 * 31) + this.maxReportTimes) * 31) + this.sample) * 31;
        long r10 = this.cycleInterval;
        int r11 = (r1 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r12 = this.a;
        return ((r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31) + this.reportDeadLoop;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "PerformanceConfig(enable=" + this.enable + ", maxReportTimes=" + this.maxReportTimes + ", sample=" + this.sample + ", cycleInterval=" + this.cycleInterval + ", duration=" + this.a + ", reportDeadLoop=" + this.reportDeadLoop + ')';
    }

    static {
        b = new a(true, 3, 0, 10000, 3000, 10);
        c = new a(0);
    }

    public final long a() {
        return this.cycleInterval;
    }

    public final boolean b() {
        return this.enable;
    }

    public final int c() {
        return this.maxReportTimes;
    }

    public final int d() {
        return this.reportDeadLoop;
    }

    public final int e() {
        return this.sample;
    }

    public /* synthetic */ a(int r10) {
        this(false, 0, 0, 10000, 2000, 0);
    }

    public a(boolean r1, int r10, int r11, long r12, long r13, int r14) {
        this.enable = r1;
        this.maxReportTimes = r10;
        this.sample = r11;
        this.cycleInterval = r12;
        this.a = r13;
        this.reportDeadLoop = r14;
    }
}
