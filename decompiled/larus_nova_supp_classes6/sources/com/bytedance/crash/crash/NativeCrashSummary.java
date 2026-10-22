package com.bytedance.crash.crash;

import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.i;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.a;
import com.bytedance.crash.util.g;
import com.bytedance.crash.util.j;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class NativeCrashSummary extends CrashSummary {
    public static final String FILE_NAME = null;
    private final String mSigLine;
    private final int mStartPid;

    static {
        FILE_NAME = CrashType.NATIVE + ".summary";
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public String loadStackTrace() {
        return this.mSigLine + NativeBridge.J(this.mDirectory.getAbsolutePath());
    }

    public static NativeCrashSummary load(File r2) {
        if (r2.getName().equals(FILE_NAME) == true) goto L5;
        return null;
    L5:
        return NativeBridge.K(r2.getAbsolutePath());
    }

    private static String parseSignalType(String r3) {
        Matcher r4 = PatternProtector.compile("\\(([A-Z_]+)\\)").matcher(r3);     // Catch: Throwable -> L15
        ArrayList r0 = new ArrayList(2);     // Catch: Throwable -> L15
    L4:
        if (r4.find() == false) goto L8;
        if (r0.size() >= 2) goto L8;
        r0.add(r4.group(1));     // Catch: Throwable -> L15
    L8:
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L15
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L15
        if (r2.hasNext() == false) goto L13;
    L10:
        r1.append((CharSequence) r2.next());     // Catch: Throwable -> L15
        if (r2.hasNext() == false) goto L13;
        r1.append("_");     // Catch: Throwable -> L15
    L13:
        return r1.toString();
    L15:
        return "SIG_PARSE_ERR";
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void appendSpecialFilter(JSONObject r6) {
        JSONObject r0 = j.e(r6, "filters");
        PolarisFileWrapper r1 = new PolarisFileWrapper(i.d(), "configs");
        StringBuilder r3 = new StringBuilder();
        a r4 = com.bytedance.crash.monitor.j.a;
        if (r4 == null) goto L5;
        String r5 = r4.a();
    L6:
        r3.append(r5);
        r3.append(".config");
        j.b(r0, "coredump_send_cfg_valid", Boolean.valueOf(new PolarisFileWrapper(r1, r3.toString()).exists()));
        boolean r2 = false;
        if (r6.opt("java_data") == null) goto L9;
        boolean r7 = true;
    L10:
        j.c(r0, "has_java_stack", String.valueOf(r7));
        j.c(r0, "malloc_type", NativeBridge.v());
        String r8 = this.mSigLine;
        if (r8 == null) goto L14;
        j.c(r0, "native_reason", parseSignalType(r8));
    L14:
        if (this.mStartPid == this.mPid) goto L16;
        r2 = true;
    L16:
        j.h(r0, "fork_crash", String.valueOf(r2));
        return;
    L9:
        r7 = false;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void assemblySpecialCrashBody(eh4.a r5, Header r6) {
        JSONObject r7 = r5.a.optJSONObject("filters");
        if (r7 != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        r5.a("is_root", Boolean.valueOf(r8));
        r5.a("start_pid", Integer.valueOf(this.mStartPid));
        com.bytedance.crash.dumper.b.c(r5.a, this.mDirectory, true);
        r5.a("is_native_crash", 1);
        if (ah4.b.a == null) goto L11;
        r5.a("coredump_ver", Integer.valueOf(ah4.b.d() ? 1 : 0));
        r5.a("core_dump_uuid", ah4.b.a);
    L11:
        JSONObject r9 = r5.a;
        File r0 = this.mDirectory;
        PolarisFileWrapper r1 = new PolarisFileWrapper(r0, "jstack.txt");
        PolarisFileWrapper r2 = new PolarisFileWrapper(r0, "abort.txt");
        if (r1.exists() == false) goto L14;
        String r3 = g.f(r1);
    L16:
        if (r2.exists() == false) goto L25;
        String r4 = g.f(r2);
        if (r4 == null) goto L25;
        if (r4.startsWith("[FATAL:") == false) goto L25;
        if (r4.contains("Please include Java exception stack in crash report ttwebview:") == false) goto L25;
        StringBuilder r10 = new StringBuilder();
        r10.append(r3);
        int r11 = r4.indexOf(" ttwebview:");
        r10.append("Caused by: Please include Java exception stack in crash report\n");
        r10.append(r4.substring(r11 + 11));
        r3 = r10.toString();
    L25:
        if (TextUtils.isEmpty(r3) == true) goto L27;
        j.h(r9, "java_data", r3);
    L27:
        JSONObject r12 = r5.a;
        PolarisFileWrapper r13 = new PolarisFileWrapper(this.mDirectory, "game_script_stack.txt");
        if (r13.exists() == false) goto L33;
        String r14 = g.f(r13);
        if (TextUtils.isEmpty(r14) == true) goto L34;
        j.h(r12, "game_script_stack", r14);
        return;
    L34:
        return;
    L33:
        return;
    L14:
        r3 = null;
        goto L16
    L5:
        if (r7.optBoolean("is_root") == false) goto L7;
        r8 = true;
        goto L8
    }

    public NativeCrashSummary(String r15, long r16, long r18, long r20, String r22, String r23, int r24, int r25, int r26, String r27) {
        super(new PolarisFileWrapper(r15).getParentFile(), CrashType.NATIVE, r16, r18, r20, r22, r23, r24, r25);
        this.mStartPid = r26;
        this.mSigLine = r27;
        this.mStackTrace = loadStackTrace();
    }
}
