package qt9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/settings/provider/BasicExperienceFeatureConfig;", "", "enableEnterpriseColdStartNewTask", "", "mainConversationDowngradeExperimentEnabled", "enableNewWorkTaskButtonThemeColorInversion", "<init>", "(ZZZ)V", "getEnableEnterpriseColdStartNewTask", "()Z", "getMainConversationDowngradeExperimentEnabled", "getEnableNewWorkTaskButtonThemeColorInversion", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class q {

    @SerializedName("enable_enterprise_cold_start_new_task")
    private final boolean enableEnterpriseColdStartNewTask;

    @SerializedName("enable_new_work_task_button_theme_color_inversion")
    private final boolean enableNewWorkTaskButtonThemeColorInversion;

    @SerializedName("main_conversation_downgrade_experiment_enabled")
    private final boolean mainConversationDowngradeExperimentEnabled;

    public q() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (this.enableEnterpriseColdStartNewTask == r6.enableEnterpriseColdStartNewTask) goto L12;
        return false;
    L12:
        if (this.mainConversationDowngradeExperimentEnabled == r6.mainConversationDowngradeExperimentEnabled) goto L15;
        return false;
    L15:
        if (this.enableNewWorkTaskButtonThemeColorInversion == r6.enableNewWorkTaskButtonThemeColorInversion) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enableEnterpriseColdStartNewTask == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.mainConversationDowngradeExperimentEnabled == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.enableNewWorkTaskButtonThemeColorInversion == true) goto L15;
        r1 = 1237;
    L15:
        return r4 + r1;
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "BasicExperienceFeatureConfig(enableEnterpriseColdStartNewTask=" + this.enableEnterpriseColdStartNewTask + ", mainConversationDowngradeExperimentEnabled=" + this.mainConversationDowngradeExperimentEnabled + ", enableNewWorkTaskButtonThemeColorInversion=" + this.enableNewWorkTaskButtonThemeColorInversion + ')';
    }

    public final boolean a() {
        return this.enableEnterpriseColdStartNewTask;
    }

    public final boolean b() {
        return this.enableNewWorkTaskButtonThemeColorInversion;
    }

    public final boolean c() {
        return this.mainConversationDowngradeExperimentEnabled;
    }

    public q(int r1) {
        this.enableEnterpriseColdStartNewTask = true;
        this.mainConversationDowngradeExperimentEnabled = false;
        this.enableNewWorkTaskButtonThemeColorInversion = false;
    }
}
