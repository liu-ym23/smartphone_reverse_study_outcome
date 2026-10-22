package com.bytedance.crash.crash;

import android.text.TextUtils;
import ch4.c;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.g;
import com.bytedance.crash.util.j;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import eh4.a;
import java.io.File;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e extends CrashSummary {
    public static final String c = null;
    public static final Pattern d = null;
    public final String a;
    public final boolean b;

    static {
        c = CrashType.JAVA + ".summary";
        d = PatternProtector.compile("^start_time=(\\d+)\\nstart_up_time=(\\d+)\\ncrash_time=(\\d+)\\nprocess_name=(.*)\\nthread_name=(.*)\\npid=(\\d+)\\ntid=(\\d+)\\noom=(\\d+)\\nlaunch=(\\d+)\\nthrowable=(.*)");
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public final String loadStackTrace() {
        String r0 = g.f(new PolarisFileWrapper(this.mDirectory, "throwable.txt"));
        if (TextUtils.isEmpty(r0) == false) goto L10;
        StringBuilder r1 = new StringBuilder();
        r1.append(this.a);
        r1.append("\n\tat InvalidStack.NoStackAvailable: ");
        if (this.b == false) goto L7;
        String r2 = "Is OOM";
    L8:
        r1.append(r2);
        r1.append(" (SourceFile.java:-1).\n");
        return r1.toString();
    L7:
        r2 = "Not OOM";
        goto L8
    L10:
        return r0;
    }

    public static e a(File r19) {
        if (r19.getName().equals(c) == true) goto L5;
        return null;
    L5:
        String r0 = g.f(r19);
        if (r0 != null) goto L27;
        return null;
    L27:
        Matcher r1 = d.matcher(r0);     // Catch: Throwable -> L24
        if (r1.find() == true) goto L11;
    L26:
        return null;
    L11:
        if (r1.groupCount() != 10) goto L26;
        String r17 = r1.group(10);     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r17) == true) goto L26;
        long r6 = CastLongProtector.parseLong(r1.group(1));     // Catch: Throwable -> L24
        long r8 = CastLongProtector.parseLong(r1.group(2));     // Catch: Throwable -> L24
        long r10 = CastLongProtector.parseLong(r1.group(3));     // Catch: Throwable -> L24
        String r12 = r1.group(4);     // Catch: Throwable -> L24
        String r13 = r1.group(5);     // Catch: Throwable -> L24
        int r14 = CastIntegerProtector.parseInt(r1.group(6));     // Catch: Throwable -> L24
        int r15 = CastIntegerProtector.parseInt(r1.group(7));     // Catch: Throwable -> L24
        if (CastIntegerProtector.parseInt(r1.group(8)) == 0) goto L17;
        boolean r16 = true;
    L19:
        if (CastIntegerProtector.parseInt(r1.group(9)) == 0) goto L21;
        boolean r18 = true;
    L22:
        return new e(r19.getParentFile(), r6, r8, r10, r12, r13, r14, r15, r16, r17, r18);
    L21:
        r18 = false;
        goto L22
    L17:
        r16 = false;
    L24:
        th = move-exception;
        c.b("NPTH_JAVA_SUMMARY", th);
        goto L26
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public final void appendSpecialFilter(JSONObject r7) {
        CrashType r0 = this.mCrashType;
        CrashType r1 = CrashType.LAUNCH;
        if (r0 != r1) goto L5;
        r7 = getOriginalBody(r7);
    L5:
        JSONObject r8 = j.e(r7, "filters");
        if (new PolarisFileWrapper(this.mDirectory, "ignore").exists() == false) goto L8;
        j.h(r8, "has_ignore", String.valueOf(true));
    L8:
        CrashType r2 = this.mCrashType;
        if (r2 != r1) goto L11;
    L12:
        String r3 = this.mStackTrace;
        String r4 = null;
        if (r3 != null) goto L32;
    L27:
        if (r4 == null) goto L29;
        j.h(r8, "java_reason", r4);
    L29:
        j.h(r8, "malloc_type", NativeBridge.v());
        j.h(r8, "from_custom", Boolean.FALSE);
        return;
    L32:
        if (r3.isEmpty() == true) goto L27;
        String[] r5 = r3.split("\n", 2);     // Catch: Throwable -> L31
        if (r5.length == 0) goto L27;
        int r6 = r5[0].indexOf(58);     // Catch: Throwable -> L31
        if (r6 != (-1)) goto L23;
        r6 = r5[0].indexOf(65306);     // Catch: Throwable -> L31
    L23:
        if (r6 == (-1)) goto L25;
        String r9 = r5[0].substring(0, r6).trim();     // Catch: Throwable -> L31
    L26:
        r4 = r9;
        goto L27
    L25:
        r9 = r5[0].trim();     // Catch: Throwable -> L31
        goto L26
    L11:
        if (r2 != CrashType.JAVA) goto L29;
        goto L12
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public final JSONObject getOriginalBody(JSONObject r3) {
        if (this.mCrashType != CrashType.LAUNCH) goto L10;
        JSONArray r0 = r3.optJSONArray("data");
        if (r0 != null) goto L7;
        return r3;
    L7:
        if (r0.length() > 0) goto L9;
        return r3;
    L9:
        return r0.optJSONObject(0);
    L10:
        return r3;
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public final void assemblySpecialCrashBody(a r4, Header r5) {
        com.bytedance.crash.dumper.b.c(r4.a, this.mDirectory, false);
        r4.a("isOOM", Boolean.valueOf(this.b));
        com.bytedance.crash.general.a r0 = com.bytedance.crash.general.a.a();
        if (r0 != null) goto L5;
        String r1 = UUID.randomUUID().toString();     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r1) == true) goto L19;
    L20:
        r4.a("launch_did", r1);
        if (this.mCrashType != CrashType.LAUNCH) goto L25;
        r4.a("crash_type", "java");
        r4.a("event_type", "start_crash");
        r4.a("stack", String.valueOf(r4.a.remove("data")));
        JSONObject r6 = new JSONObject();
        r6.put("data", new JSONArray().put(r4.a));     // Catch: JSONException -> L27
        r4.a = r6;     // Catch: JSONException -> L27
        return;
    L36:
        return;
    L25:
        r4.a("isJava", 1);
        return;
    L19:
        r1 = "0000-1111-2222-3333-4444";
        goto L20
    L5:
        if (r0.d != null) goto L15;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (r0.d != null) goto L10;
        r0.d = RomInfo.get(r0.a);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    L15:
        r1 = r0.d.getRandomDeviceId();
        goto L20
    }

    public e(File r15, long r16, long r18, long r20, String r22, String r23, int r24, int r25, boolean r26, String r27, boolean r28) {
        if (r28 == false) goto L5;
        CrashType r0 = CrashType.LAUNCH;
    L6:
        super(r15, r0, r16, r18, r20, r22, r23, r24, r25);
        this.a = r27;
        this.b = r26;
        this.mStackTrace = loadStackTrace();
        return;
    L5:
        r0 = CrashType.JAVA;
        goto L6
    }
}
