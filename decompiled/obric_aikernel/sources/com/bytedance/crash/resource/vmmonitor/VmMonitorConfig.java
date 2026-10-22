package com.bytedance.crash.resource.vmmonitor;

import androidx.annotation.Nullable;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.NpthBus;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.resource.ResourceMonitorConfig;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
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

    public VmMonitorConfig(int r10, JSONArray r11, JSONArray r12, JSONArray r13, JSONArray r14) {
        super(23, 35, 3);
        this.mWaterLineMB = 350;
        this.mDumpSizeMB = 650;
        this.mSleepTime = 3000;
        this.mMprotectProts = 0;
        this.mDebug = false;
        this.mEnablePhyMode = false;
        this.mMemType = "test";
        this.mMemSize = NetConst.NOT_ENCRYPT_VERISON_CODE;
        this.mBacktraceRule = NetConst.NOT_ENCRYPT_VERISON_CODE;
        this.mMonitorRules = NetConst.NOT_ENCRYPT_VERISON_CODE;
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
        this.mMonitorType = r10;
        if (r11 != null) goto L8;
    L10:
        parseMmapMonitorParams(r12);
        parseMprotectMonitorParams(r13);
        parseMmapPhyConfigs(r14);
        return;
    L8:
        if (r11.length() != 2) goto L10;
        this.mWaterLineMB = r11.optInt(0);
        this.mDumpSizeMB = r11.optInt(1);
        goto L10
    }

    @Nullable
    private static String getMonitorMmapSize(String r10) {
        if (r10 == null) goto L21;
        if (r10.endsWith("M") == false) goto L8;
        Long r11 = Long.valueOf((Long.parseLong(r10.substring(0, r10.indexOf("M"))) * 1024) * 1024);     // Catch: Throwable -> L18
    L14:
        if (r11 == null) goto L22;
        return r11.toString();
    L22:
        return null;
    L8:
        if (r10.endsWith(NpthBus.UUID_SUFIX_3_1_3) == false) goto L11;
        r11 = Long.valueOf(((Long.parseLong(r10.substring(0, r10.indexOf(NpthBus.UUID_SUFIX_3_1_3))) * 1024) * 1024) * 1024);     // Catch: Throwable -> L18
        goto L14
    L11:
        if (r10.endsWith("K") == false) goto L13;
        r11 = Long.valueOf(Long.parseLong(r10.substring(0, r10.indexOf("K"))) * 1024);     // Catch: Throwable -> L18
        goto L14
    L13:
        r11 = null;
    L23:
        return null;
    L21:
        return null;
    }

    private void parseMmapMonitorParams(JSONArray r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() != 5) goto L35;
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= r10.length()) goto L26;
        String r13 = r10.optString(r11);
        if (r11 != 0) goto L11;
        this.mMemType = r13;
    L25:
        r11 = r11 + 1;
        goto L7
    L11:
        if (r11 != 1) goto L13;
        this.mMemSize = getMonitorMmapSize(r13);
        goto L25
    L13:
        if (r11 != 2) goto L15;
        int r14 = Integer.parseInt(r13) << 0;
    L22:
        r12 = r12 | r14;
        goto L25
    L15:
        if (r11 != 3) goto L17;
        r14 = Integer.parseInt(r13) << 1;
        goto L22
    L17:
        if (r11 != 4) goto L25;
        this.mMonitorRules = r13;
        goto L25
    L26:
        this.mBacktraceRule = String.valueOf(r12);
        return;
    }

    private void parseMmapPhyConfigs(JSONArray r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() != 2) goto L24;
        int r11 = 0;
    L7:
        if (r11 >= r10.length()) goto L25;
        String r12 = r10.optString(r11);
        if (r11 != 0) goto L11;
        this.mEnablePhyMode = NetConst.ENCRYPT_VERISON_CODE.equals(r12);
    L17:
        r11 = r11 + 1;
        goto L7
    L11:
        if (r11 != 1) goto L17;
        if (this.mEnablePhyMode == false) goto L17;
        this.mMemType = r12;
        goto L17
    L25:
        return;
    }

    private void parseMprotectMonitorParams(JSONArray r10) {
        if (r10 == null) goto L7;
        int r11 = 0;
        this.mMprotectProts = 0;
    L5:
        if (r11 >= r10.length()) goto L9;
        this.mMprotectProts |= 1 << r10.optInt(r11);
        r11 = r11 + 1;
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
