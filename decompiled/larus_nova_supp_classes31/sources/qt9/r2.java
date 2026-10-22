package qt9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/larus/settings/provider/LifeguardConfig;", "", "enableLifeguard", "", "enableXTraceLog", "enable32BitDevice", "guardReportType", "", "updateVersionCode", "", "configs", "", "Lcom/larus/settings/provider/MethodConfig;", "<init>", "(ZZZILjava/lang/String;Ljava/util/List;)V", "getEnableLifeguard", "()Z", "getEnableXTraceLog", "getEnable32BitDevice", "getGuardReportType", "()I", "getUpdateVersionCode", "()Ljava/lang/String;", "getConfigs", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class r2 {

    @SerializedName("configs")
    private final List<h3> configs;

    @SerializedName("enable_32bit_device")
    private final boolean enable32BitDevice;

    @SerializedName("enable_lifeguard")
    private final boolean enableLifeguard;

    @SerializedName("enable_xtrace_log")
    private final boolean enableXTraceLog;

    @SerializedName("guard_report_type")
    private final int guardReportType;

    @SerializedName("update_version_code")
    private final String updateVersionCode;

    public r2() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r2) == true) goto L8;
        return false;
    L8:
        r2 r6 = (r2) r5;
        if (this.enableLifeguard == r6.enableLifeguard) goto L12;
        return false;
    L12:
        if (this.enableXTraceLog == r6.enableXTraceLog) goto L15;
        return false;
    L15:
        if (this.enable32BitDevice == r6.enable32BitDevice) goto L18;
        return false;
    L18:
        if (this.guardReportType == r6.guardReportType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.updateVersionCode, r6.updateVersionCode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.configs, r6.configs) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enableLifeguard == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableXTraceLog == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.enable32BitDevice == true) goto L14;
        r1 = 1237;
    L14:
        int r5 = (((r4 + r1) * 31) + this.guardReportType) * 31;
        String r6 = this.updateVersionCode;
        int r7 = 0;
        if (r6 != null) goto L17;
        int r8 = 0;
    L18:
        int r9 = (r5 + r8) * 31;
        List<h3> r10 = this.configs;
        if (r10 == null) goto L23;
        r7 = r10.hashCode();
    L23:
        return r9 + r7;
    L17:
        r8 = r6.hashCode();
        goto L18
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "LifeguardConfig(enableLifeguard=" + this.enableLifeguard + ", enableXTraceLog=" + this.enableXTraceLog + ", enable32BitDevice=" + this.enable32BitDevice + ", guardReportType=" + this.guardReportType + ", updateVersionCode=" + this.updateVersionCode + ", configs=" + this.configs + ')';
    }

    public r2(Object r3) {
        List<h3> r4 = CollectionsKt.emptyList();
        this.enableLifeguard = false;
        this.enableXTraceLog = false;
        this.enable32BitDevice = true;
        this.guardReportType = 0;
        this.updateVersionCode = "";
        this.configs = r4;
    }
}
