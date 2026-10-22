package com.ss.android.lark.monitor.abtest;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import iua.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class PerfMonitorExperiment extends iua.a<PerfMonitorConfig> {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/monitor/abtest/PerfMonitorExperiment$PerfMonitorConfig;", "", "cpuIdleFrequencyThreshold", "", "cpuIdleTimesThreshold", "", "bootMonitorIntervalInMills", "", "<init>", "(DIJ)V", "getCpuIdleFrequencyThreshold", "()D", "getCpuIdleTimesThreshold", "()I", "getBootMonitorIntervalInMills", "()J", "component1", "component2", "component3", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "toString", "", "monitor_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class PerfMonitorConfig {

        @SerializedName("boot_monitor_interval_in_mills")
        private final long bootMonitorIntervalInMills;

        @SerializedName("cpu_idle_frequency_threshold")
        private final double cpuIdleFrequencyThreshold;

        @SerializedName("cpu_idle_times_threshold")
        private final int cpuIdleTimesThreshold;

        public PerfMonitorConfig() {
            this(0.0d, 0, 0, 7, null);
        }

        public static /* synthetic */ PerfMonitorConfig copy$default(PerfMonitorConfig r6, double r7, int r9, long r10, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L5;
            r7 = r6.cpuIdleFrequencyThreshold;
        L5:
            double r1 = r7;
            if ((r12 & 2) == 0) goto L8;
            r9 = r6.cpuIdleTimesThreshold;
        L8:
            int r3 = r9;
            if ((r12 & 4) == 0) goto L12;
            r10 = r6.bootMonitorIntervalInMills;
        L12:
            return r6.copy(r1, r3, r10);
        }

        public final double component1() {
            return this.cpuIdleFrequencyThreshold;
        }

        public final int component2() {
            return this.cpuIdleTimesThreshold;
        }

        public final long component3() {
            return this.bootMonitorIntervalInMills;
        }

        public final PerfMonitorConfig copy(double r8, int r10, long r11) {
            return new PerfMonitorConfig(r8, r10, r11);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof PerfMonitorConfig) == true) goto L8;
            return false;
        L8:
            PerfMonitorConfig r9 = (PerfMonitorConfig) r8;
            if (Double.compare(this.cpuIdleFrequencyThreshold, r9.cpuIdleFrequencyThreshold) == 0) goto L12;
            return false;
        L12:
            if (this.cpuIdleTimesThreshold == r9.cpuIdleTimesThreshold) goto L15;
            return false;
        L15:
            if (this.bootMonitorIntervalInMills == r9.bootMonitorIntervalInMills) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            long r0 = Double.doubleToLongBits(this.cpuIdleFrequencyThreshold);
            int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.cpuIdleTimesThreshold) * 31;
            long r3 = this.bootMonitorIntervalInMills;
            return r1 + ((int) (r3 ^ (r3 >>> 32)));
        }

        public String toString() {
            return "PerfMonitorConfig(cpuIdleFrequencyThreshold=" + this.cpuIdleFrequencyThreshold + ", cpuIdleTimesThreshold=" + this.cpuIdleTimesThreshold + ", bootMonitorIntervalInMills=" + this.bootMonitorIntervalInMills + ')';
        }

        public final long getBootMonitorIntervalInMills() {
            return this.bootMonitorIntervalInMills;
        }

        public final double getCpuIdleFrequencyThreshold() {
            return this.cpuIdleFrequencyThreshold;
        }

        public final int getCpuIdleTimesThreshold() {
            return this.cpuIdleTimesThreshold;
        }

        public PerfMonitorConfig(double r1, int r3, long r4) {
            this.cpuIdleFrequencyThreshold = r1;
            this.cpuIdleTimesThreshold = r3;
            this.bootMonitorIntervalInMills = r4;
        }

        public /* synthetic */ PerfMonitorConfig(double r7, int r9, long r10, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 1) == 0) goto L5;
            r7 = 30.0d;
        L5:
            double r1 = r7;
            if ((r12 & 2) == 0) goto L8;
            int r3 = 1;
        L10:
            if ((r12 & 4) == 0) goto L12;
            r10 = 30000;
        L12:
            this(r1, r3, r10);
            return;
        L8:
            r3 = r9;
            goto L10
        }
    }

    public static final class a {
    }

    static {
    }

    public final boolean isSticky() {
        return true;
    }

    public final Object getDefault() {
        return new PerfMonitorConfig(0.0d, 0, 0, 7, null);
    }

    public final b getLarkExperimentInfo() {
        return new b("performance_monitor_config", "performance monitor configure experiment A/B test");
    }

    public PerfMonitorExperiment() {
    }
}
