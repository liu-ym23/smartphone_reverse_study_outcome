package com.bytedance.crash.crash;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

/* JADX INFO: loaded from: classes.dex */
@Keep
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

    @Nullable
    public static NativeCrashSummary load(File r10) {
        if (r10.getName().equals(FILE_NAME) == true) goto L5;
        return null;
    L5:
        return NativeBridge.loadNativeCrashSummary(r10.getAbsolutePath());
    }

    private static String parseSignalType(String r10) {
        Matcher r11 = Pattern.compile("\\(([A-Z_]+)\\)").matcher(r10);     // Catch: Throwable -> L10
        ArrayList r12 = new ArrayList(2);     // Catch: Throwable -> L10
    L4:
        if (r11.find() == false) goto L8;
        if (r12.size() >= 2) goto L8;
        r12.add(r11.group(1));     // Catch: Throwable -> L10
    L8:
        return String.join("_", r12);
    L10:
        return "SIG_PARSE_ERR";
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected void appendSpecialFilter(JSONObject r10) {
        JSONObject r11 = JSONUtils.get(r10, "filters");
        JSONUtils.append(r11, "coredump_send_cfg_valid", Boolean.valueOf(new File(new File(Global.getRootDirectory(), "configs"), MonitorManager.getAppMonitorAid() + ConfigManager.CONFIG_SUFFIX).exists()));
        boolean r12 = true;
        if (r10.opt("java_data") == null) goto L5;
        boolean r13 = true;
    L6:
        JSONUtils.append(r11, "has_java_stack", String.valueOf(r13));
        JSONUtils.append(r11, "malloc_type", NativeBridge.getMallocType());
        String r14 = this.mSigLine;
        if (r14 == null) goto L10;
        JSONUtils.append(r11, "native_reason", parseSignalType(r14));
    L10:
        if (this.mStartPid != this.mPid) goto L13;
        r12 = false;
    L13:
        JSONUtils.put(r11, "fork_crash", String.valueOf(r12));
        return;
    L5:
        r13 = false;
        goto L6
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected void assemblySpecialCrashBody(CrashBody r10, Header r11) {
        JSONObject r12 = r10.getJson().optJSONObject("filters");
        if (r12 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        r10.put("is_root", Boolean.valueOf(r13));
        r10.put(CrashBody.START_PID, Integer.valueOf(this.mStartPid));
        BuildId.putCrashBuildIdToJson(r10.getJson(), this.mDirectory, true);
        r10.put(CrashBody.IS_NATIVE_CRASH, 1);
        if (CoredumpAdapter.getCoredumpUUID() == null) goto L11;
        r10.put("coredump_ver", Integer.valueOf(CoredumpAdapter.isCoredumpExists() ? 1 : 0));
        r10.put("core_dump_uuid", CoredumpAdapter.getCoredumpUUID());
    L11:
        JavaStack.pushStackCapturedAtNative(r10.getJson(), this.mDirectory);
        GameScriptStack.putTo(r10.getJson(), this.mDirectory);
        return;
    L5:
        if (r12.optBoolean("is_root") == false) goto L7;
        r13 = true;
        goto L8
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    @NonNull
    protected String loadStackTrace() {
        return this.mSigLine + NativeBridge.loadNativeCrashBacktrace(this.mDirectory.getAbsolutePath());
    }
}
