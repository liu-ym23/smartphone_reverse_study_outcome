package qt9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/larus/settings/provider/MemoryTestConfig;", "", "memoryAutomateDumpThreholdPercent", "", "memoryPresureReminderThreholdPercent", "memoryUsageMonitorUpdateInterval", "memoryUsageInfoUpdateInterval", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMemoryAutomateDumpThreholdPercent", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMemoryPresureReminderThreholdPercent", "getMemoryUsageMonitorUpdateInterval", "getMemoryUsageInfoUpdateInterval", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/settings/provider/MemoryTestConfig;", "equals", "", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class a3 {

    @SerializedName("memory_automate_dump_threhold_percent")
    private final Integer memoryAutomateDumpThreholdPercent;

    @SerializedName("memory_presure_reminder_threhold_percent")
    private final Integer memoryPresureReminderThreholdPercent;

    @SerializedName("memory_usage_info_update_interval")
    private final Integer memoryUsageInfoUpdateInterval;

    @SerializedName("memory_usage_monitor_update_interval")
    private final Integer memoryUsageMonitorUpdateInterval;

    public a3() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a3) == true) goto L8;
        return false;
    L8:
        a3 r6 = (a3) r5;
        if (Intrinsics.areEqual(this.memoryAutomateDumpThreholdPercent, r6.memoryAutomateDumpThreholdPercent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.memoryPresureReminderThreholdPercent, r6.memoryPresureReminderThreholdPercent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.memoryUsageMonitorUpdateInterval, r6.memoryUsageMonitorUpdateInterval) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.memoryUsageInfoUpdateInterval, r6.memoryUsageInfoUpdateInterval) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.memoryAutomateDumpThreholdPercent;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.memoryPresureReminderThreholdPercent;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.memoryUsageMonitorUpdateInterval;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.memoryUsageInfoUpdateInterval;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryTestConfig(memoryAutomateDumpThreholdPercent=" + this.memoryAutomateDumpThreholdPercent + ", memoryPresureReminderThreholdPercent=" + this.memoryPresureReminderThreholdPercent + ", memoryUsageMonitorUpdateInterval=" + this.memoryUsageMonitorUpdateInterval + ", memoryUsageInfoUpdateInterval=" + this.memoryUsageInfoUpdateInterval + ')';
    }

    public a3(int r4) {
        this.memoryAutomateDumpThreholdPercent = 90;
        this.memoryPresureReminderThreholdPercent = 60;
        this.memoryUsageMonitorUpdateInterval = 5000;
        this.memoryUsageInfoUpdateInterval = 5000;
    }
}
