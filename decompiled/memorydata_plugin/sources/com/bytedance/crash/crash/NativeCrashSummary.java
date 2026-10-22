package com.bytedance.crash.crash;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.ConfigManager;
import com.bytedance.crash.coredump.CoredumpAdapter;
import com.bytedance.crash.dumper.BuildId;
import com.bytedance.crash.dumper.JavaStack;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.game.GameScriptStack;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NativeCrashSummary extends CrashSummary {
    public static final String FILE_NAME = null;
    private final String mSigLine;
    private final int mStartPid;

    static {
        FILE_NAME = CrashType.NATIVE + ".summary";
    }

    NativeCrashSummary(String r15, long r16, long r18, long r20, String r22, String r23, int r24, int r25, int r26, String r27) {
        super(new File(r15).getParentFile(), CrashType.NATIVE, r16, r18, r20, r22, r23, r24, r25);
        this.mStartPid = r26;
        this.mSigLine = r27;
        this.mStackTrace = loadStackTrace();
    }

    public static NativeCrashSummary load(File r2) {
        if (r2.getName().equals(FILE_NAME) == true) goto L5;
        return null;
    L5:
        return NativeBridge.loadNativeCrashSummary(r2.getAbsolutePath());
    }

    private static String parseSignalType(String r3) {
        Matcher r4 = Pattern.compile("\\(([A-Z_]+)\\)").matcher(r3);     // Catch: Throwable -> L10
        ArrayList r0 = new ArrayList(2);     // Catch: Throwable -> L10
    L4:
        if (r4.find() == false) goto L8;
        if (r0.size() >= 2) goto L8;
        r0.add(r4.group(1));     // Catch: Throwable -> L10
    L8:
        return String.join("_", r0);
    L10:
        return "SIG_PARSE_ERR";
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void appendSpecialFilter(JSONObject r6) {
        JSONObject r0 = JSONUtils.get(r6, "filters");
        JSONUtils.append(r0, "coredump_send_cfg_valid", Boolean.valueOf(new File(new File(Global.getRootDirectory(), "configs"), MonitorManager.getAppMonitorAid() + ConfigManager.CONFIG_SUFFIX).exists()));
        boolean r1 = true;
        if (r6.opt("java_data") == null) goto L5;
        boolean r7 = true;
    L6:
        JSONUtils.append(r0, "has_java_stack", String.valueOf(r7));
        JSONUtils.append(r0, "malloc_type", NativeBridge.getMallocType());
        String r8 = this.mSigLine;
        if (r8 == null) goto L10;
        JSONUtils.append(r0, "native_reason", parseSignalType(r8));
    L10:
        if (this.mStartPid != this.mPid) goto L13;
        r1 = false;
    L13:
        JSONUtils.put(r0, "fork_crash", String.valueOf(r1));
        return;
    L5:
        r7 = false;
        goto L6
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void assemblySpecialCrashBody(CrashBody r3, Header r4) {
        JSONObject r5 = r3.getJson().optJSONObject("filters");
        if (r5 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        r3.put("is_root", Boolean.valueOf(r6));
        r3.put(CrashBody.START_PID, Integer.valueOf(this.mStartPid));
        BuildId.putCrashBuildIdToJson(r3.getJson(), this.mDirectory, true);
        r3.put(CrashBody.IS_NATIVE_CRASH, 1);
        if (CoredumpAdapter.getCoredumpUUID() == null) goto L11;
        r3.put("coredump_ver", Integer.valueOf(CoredumpAdapter.isCoredumpExists() ? 1 : 0));
        r3.put("core_dump_uuid", CoredumpAdapter.getCoredumpUUID());
    L11:
        JavaStack.pushStackCapturedAtNative(r3.getJson(), this.mDirectory);
        GameScriptStack.putTo(r3.getJson(), this.mDirectory);
        return;
    L5:
        if (r5.optBoolean("is_root") == false) goto L7;
        r6 = true;
        goto L8
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public String loadStackTrace() {
        return this.mSigLine + NativeBridge.loadNativeCrashBacktrace(this.mDirectory.getAbsolutePath());
    }
}
