package com.bytedance.crash.resource.vmmonitor;

import com.bytedance.crash.NpthBus;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.resource.ResourceMonitorConfig;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class VmMonitorConfig extends ResourceMonitorConfig {
    public static final int DEFAULT_SLEEP_TIME_DURING_MONITOR = 3000;
    private static final int INDEX_JAVA_STACK = 3;
    private static final int INDEX_MEM_SIZE = 1;
    private static final int INDEX_MEM_TYPE = 0;
    private static final int INDEX_MONITOR_RULES = 4;
    private static final int INDEX_NATIVE_STACK = 2;
    private static final int JAVA_STACK_BIT = 1;
    private static final int NATIVE_STACK_BIT = 0;
    public static final long SIZE_K = 1024;
    public static final long SLEEP_TIME_BEFORE_RECOVER = 60000;
    private String mBacktraceRule;
    protected boolean mDebug;
    private int mDumpSizeMB;
    protected boolean mEnablePhyMode;
    private String mMemSize;
    private String mMemType;
    private String mMonitorRules;
    protected final int mMonitorType;
    protected int mMprotectProts;
    protected int mSleepTime;
    private int mWaterLineMB;

    public VmMonitorConfig(int r5, JSONArray r6, JSONArray r7, JSONArray r8, JSONArray r9) {
        super(23, 35, 3);
        this.mWaterLineMB = 350;
        this.mDumpSizeMB = 650;
        this.mSleepTime = 3000;
        this.mMprotectProts = 0;
        this.mDebug = false;
        this.mEnablePhyMode = false;
        this.mMemType = "test";
        this.mMemSize = "0";
        this.mBacktraceRule = "0";
        this.mMonitorRules = "0";
        if (RuntimeConfig.isLocalTest() == false) goto L5;
        this.mMonitorType = 3;
        this.mWaterLineMB = 0;
        this.mDumpSizeMB = 200;
        this.mSleepTime = 1000;
        this.mMemType = "new_test";
        this.mBacktraceRule = "3";
        this.mMonitorRules = "5";
        this.mMprotectProts = 32;
        this.mEnablePhyMode = true;
        this.mDebug = true;
        return;
    L5:
        this.mMonitorType = r5;
        if (r6 != null) goto L8;
    L10:
        parseMmapMonitorParams(r7);
        parseMprotectMonitorParams(r8);
        parseMmapPhyConfigs(r9);
        return;
    L8:
        if (r6.length() != 2) goto L10;
        this.mWaterLineMB = r6.optInt(0);
        this.mDumpSizeMB = r6.optInt(1);
        goto L10
    }

    private static String getMonitorMmapSize(String r8) {
        if (r8 == null) goto L21;
        if (r8.endsWith("M") == false) goto L8;
        Long r9 = Long.valueOf((Long.parseLong(r8.substring(0, r8.indexOf("M"))) * 1024) * 1024);     // Catch: Throwable -> L18
    L14:
        if (r9 == null) goto L22;
        return r9.toString();
    L22:
        return null;
    L8:
        if (r8.endsWith(NpthBus.UUID_SUFIX_3_1_3) == false) goto L11;
        r9 = Long.valueOf(((Long.parseLong(r8.substring(0, r8.indexOf(NpthBus.UUID_SUFIX_3_1_3))) * 1024) * 1024) * 1024);     // Catch: Throwable -> L18
        goto L14
    L11:
        if (r8.endsWith("K") == false) goto L13;
        r9 = Long.valueOf(Long.parseLong(r8.substring(0, r8.indexOf("K"))) * 1024);     // Catch: Throwable -> L18
        goto L14
    L13:
        r9 = null;
    L23:
        return null;
    L21:
        return null;
    }

    private void parseMmapMonitorParams(JSONArray r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.length() != 5) goto L35;
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= r7.length()) goto L26;
        String r3 = r7.optString(r1);
        if (r1 != 0) goto L11;
        this.mMemType = r3;
    L25:
        r1 = r1 + 1;
        goto L7
    L11:
        if (r1 != 1) goto L13;
        this.mMemSize = getMonitorMmapSize(r3);
        goto L25
    L13:
        if (r1 != 2) goto L15;
        int r4 = Integer.parseInt(r3) << 0;
    L22:
        r2 = r2 | r4;
        goto L25
    L15:
        if (r1 != 3) goto L17;
        r4 = Integer.parseInt(r3) << 1;
        goto L22
    L17:
        if (r1 != 4) goto L25;
        this.mMonitorRules = r3;
        goto L25
    L26:
        this.mBacktraceRule = String.valueOf(r2);
        return;
    }

    private void parseMmapPhyConfigs(JSONArray r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.length() != 2) goto L24;
        int r0 = 0;
    L7:
        if (r0 >= r4.length()) goto L25;
        String r1 = r4.optString(r0);
        if (r0 != 0) goto L11;
        this.mEnablePhyMode = "1".equals(r1);
    L17:
        r0 = r0 + 1;
        goto L7
    L11:
        if (r0 != 1) goto L17;
        if (this.mEnablePhyMode == false) goto L17;
        this.mMemType = r1;
        goto L17
    L25:
        return;
    }

    private void parseMprotectMonitorParams(JSONArray r5) {
        if (r5 == null) goto L7;
        int r0 = 0;
        this.mMprotectProts = 0;
    L5:
        if (r0 >= r5.length()) goto L9;
        this.mMprotectProts |= 1 << r5.optInt(r0);
        r0 = r0 + 1;
        goto L5
    L9:
        return;
    }

    public long getDumpSizeKB() {
        return ((long) this.mDumpSizeMB) * 1024;
    }

    public long getWaterLineKB() {
        return ((long) this.mWaterLineMB) * 1024;
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorConfig
    public String toString() {
        return "monitorType=" + this.mMonitorType + "\nwaterLineMB=" + this.mWaterLineMB + "\ndumpSizeMB=" + this.mDumpSizeMB + "\nmprotectProts=" + this.mMprotectProts + "\nmemType=" + this.mMemType + "\nmemSize=" + this.mMemSize + "\nbacktraceRules=" + this.mBacktraceRule + "\nmonitorRules=" + this.mMonitorRules + "\nsleepTime=" + this.mSleepTime + "\ndebug=" + this.mDebug + "\npEnable=" + this.mEnablePhyMode + "\n";
    }
}
