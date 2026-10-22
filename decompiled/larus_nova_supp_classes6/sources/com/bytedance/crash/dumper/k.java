package com.bytedance.crash.dumper;

import android.text.TextUtils;
import ch4.c;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.j;
import com.bytedance.crash.util.p;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.sva.sdk.logger.InteractorReportInitializer;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class k {

    public static class a {
        public long a;
        public long b;
        public int c;
        public long d;
        public long e;
        public String f;
        public String g;
        public String h;

        public final JSONObject a() {
            if (this.a == 0) goto L13;
            int r0 = this.c;
            if (r0 == 2) goto L8;
            if (r0 == 4) goto L8;
            return null;
        L8:
            JSONObject r1 = new JSONObject();
            r1.put("cost", this.a);     // Catch: JSONException -> L15
            r1.put("longMsgEnd", this.b);     // Catch: JSONException -> L15
            if (this.c != 4) goto L12;
            r1.put("when", this.d);     // Catch: JSONException -> L15
            r1.put("what", this.e);     // Catch: JSONException -> L15
            r1.put("target", this.f);     // Catch: JSONException -> L15
            j.h(r1, this.g, this.h);     // Catch: JSONException -> L15
        L12:
            return r1;
        L13:
            return null;
        }

        public a() {
            this.a = 0;
            this.b = 0;
            this.c = 0;
        }
    }

    public static String a(long r4) {
        com.bytedance.crash.util.q r0 = new com.bytedance.crash.util.q("ms");
        r0.c(new Long[]{0L, 1000L, 2000L, Long.valueOf(InteractorReportInitializer.REPORT_EVENT_DELAY_MS), 5000L, 7000L, 10000L});
        return r0.a(r4);
    }

    public static String b(int r4) {
        com.bytedance.crash.util.q r0 = new com.bytedance.crash.util.q("");
        r0.c(new Long[]{0L, 1L, 5L, 10L, 20L});
        return r0.a(r4);
    }

    public static float f(String r9) {
        if (r9 != null) goto L5;
    L53:
        return 0.0f;
    L5:
        if (r9.length() < 2) goto L53;
        byte r1 = 0;
        int r3 = 0;
    L9:
        if (r3 >= r9.length()) goto L16;
        if (Character.isDigit(r9.charAt(r3)) == true) goto L15;
        if (r9.charAt(r3) == '.') goto L15;
    L17:
        if (r3 != (-1)) goto L55;
        return 0.0f;
    L55:
        String r4 = r9.substring(0, r3);     // Catch: Throwable -> L54
        String r10 = r9.substring(r3);     // Catch: Throwable -> L54
        float r5 = CastFloatProtector.parseFloat(r4);     // Catch: Throwable -> L54
        int r6 = r10.hashCode();     // Catch: Throwable -> L54
        if (r6 == 115) goto L38;
        if (r6 == 3494) goto L35;
        if (r6 == 3525) goto L32;
        if (r6 == 3742) goto L29;
    L40:
        r1 = -1;
    L41:
        if (r1 == 0) goto L52;
        if (r1 == 1) goto L50;
        if (r1 == 2) goto L60;
        if (r1 == 3) goto L48;
        return 0.0f;
    L48:
        return r5 * 1000.0f;
    L60:
        return r5;
    L50:
        return r5 / 1000.0f;
    L52:
        return r5 / 1000000.0f;
    L29:
        if (r10.equals("us") == false) goto L40;
        r1 = 1;
        goto L41
    L32:
        if (r10.equals("ns") == false) goto L40;
    L35:
        if (r10.equals("ms") == false) goto L40;
        r1 = 2;
        goto L41
    L38:
        if (r10.equals("s") == false) goto L40;
        r1 = 3;
    L15:
        r3 = r3 + 1;
        goto L9
    L16:
        r3 = -1;
        goto L17
    }

    public static long g(String r10) {
        if (r10 != null) goto L4;
        return -1;
    L4:
        if (r10.isEmpty() == true) goto L59;
        boolean r0 = r10.startsWith("-");
        if (r0 == false) goto L9;
    L10:
        r10 = r10.substring(1);
    L11:
        Matcher r11 = PatternProtector.compile("(\\d+)([dhms]+)").matcher(r10);
        long r2 = 0;
    L13:
        if (r11.find() == false) goto L44;
        long r4 = CastLongProtector.parseLong(r11.group(1));
        byte r6 = 2;
        String r7 = r11.group(2);
        r7.getClass();
        switch(r7.hashCode()) {
            case 100: goto L33;
            case 104: goto L29;
            case 109: goto L26;
            case 115: goto L22;
            case 3494: goto L18;
            default: goto L16;
        };
    L16:
        r6 = -1;
    L36:
        switch(r6) {
            case 0: goto L41;
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L43;
            default: goto L13;
        };
    L38:
        long r8 = 1000;
    L42:
        r4 = r4 * r8;
        goto L43
    L39:
        r8 = 60000;
        goto L42
    L40:
        r8 = 3600000;
        goto L42
    L41:
        r8 = 86400000;
    L43:
        r2 = r2 + r4;
        goto L13
    L18:
        if (r7.equals("ms") == false) goto L16;
        r6 = 4;
        goto L36
    L22:
        if (r7.equals("s") == false) goto L16;
        r6 = 3;
        goto L36
    L26:
        if (r7.equals("m") == true) goto L36;
    L29:
        if (r7.equals("h") == false) goto L16;
        r6 = 1;
        goto L36
    L33:
        if (r7.equals("d") == false) goto L16;
        r6 = 0;
        goto L36
    L44:
        if (r0 == true) goto L46;
        return r2;
    L46:
        return -r2;
    L9:
        if (r10.startsWith("+") == false) goto L11;
    L59:
        return -1;
    }

    public static void i(JSONObject r25) {
        JSONArray r2 = r25.optJSONArray("logcat");
        JSONObject r3 = r25.optJSONObject("filters");
        long r14 = r25.optLong("crash_time");
        int r12 = r25.optInt("pid");
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.length() == 0) goto L96;
        if (r3 == null) goto L97;
        b r13 = new b();
        a r10 = new a();
        int r11 = 1;
        int r9 = r2.length() - 1;
    L10:
        if (r9 <= 0) goto L59;
        String r7 = JSONArrayProtectorUtils.getString(r2, r9);     // Catch: Exception -> L54
        if (TextUtils.isEmpty(r7) == false) goto L15;
    L13:
        int r24 = r9;
    L14:
        a r17 = r10;
        int r22 = r12;
        b r23 = r13;
        long r19 = r14;
    L58:
        r9 = r24 - 1;
        r10 = r17;
        r2 = r2;
        r14 = r19;
        r12 = r22;
        r13 = r23;
        r11 = 1;
        goto L10
    L15:
        long r18 = c(r14, r7);     // Catch: Exception -> L54
        String r8 = r7.substring(19);     // Catch: Exception -> L54
        if (r8.contains("ANR_LOG") == false) goto L19;
        int r15 = 0;
    L25:
        if (r15 == (-1)) goto L13;
        Matcher r4 = PatternProtector.compile("(\\d+)\\s+(\\d+) \\S\\s+[\\s\\S]*:([\\s\\S]*)").matcher(r8);     // Catch: Exception -> L54
        if (r4.find() == false) goto L13;
        String r5 = r4.group(r11);     // Catch: Exception -> L54
        String r0 = r4.group(2);     // Catch: Exception -> L54
        String r21 = r4.group(3);     // Catch: Exception -> L54
        if (r5 == null) goto L32;
        long r26 = CastLongProtector.parseLong(r5);     // Catch: Exception -> L54
    L33:
        if (r0 != null) goto L35;
        long r6 = 0;
        long r110 = 0;
    L38:
        if (r26 == r6) goto L13;
        if (r12 != r26) goto L13;
        if (r21 == null) goto L13;
        if (r15 != 0) goto L49;
        r24 = r9;
        d(r10, r14, r18, r21);     // Catch: Exception -> L47
    L47:
        e = e;
    L56:
        r17 = r10;
        r22 = r12;
        r23 = r13;
        r19 = r14;
    L57:
        new RuntimeException(e);
        goto L58
    L49:
        r24 = r9;
        r2 = r2;
        r17 = r10;
        long r16 = r26;
        r22 = r12;
        r23 = r13;
        long r111 = r110;
        r19 = r14;
        e(r13, r14, r15, r18, r16, r111, r21);     // Catch: Exception -> L52
    L52:
        e = e;
        goto L57
    L35:
        r110 = CastLongProtector.parseLong(r0);     // Catch: Exception -> L54
        r6 = 0;
        goto L38
    L32:
        r26 = 0;
        goto L33
    L19:
        if (r8.contains("GC freed") == false) goto L22;
        r15 = 1;
        goto L25
    L22:
        if (r8.contains("WaitForGcToComplete blocked") == false) goto L24;
        r15 = 2;
        goto L25
    L24:
        r15 = -1;
    L54:
        e = e;
        r24 = r9;
        goto L56
    L59:
        a r112 = r10;
        b r27 = r13;
        long r20 = 0;
        j.h(r25, "logcat_gc_info", r27.c());     // Catch: Throwable -> L82
        String r28 = r27.h;     // Catch: Throwable -> L82
        if (r28 == null) goto L67;
        r3.put("logcat_gc_cause", r28);     // Catch: Throwable -> L82
        r3.put("logcat_gc_cause_cost", a(r27.i));     // Catch: Throwable -> L82
        r3.put("logcat_gc_count_range", b(r27.e));     // Catch: Throwable -> L82
        r3.put("logcat_gc_total_cost_range", a(r27.a));     // Catch: Throwable -> L82
        int r29 = r27.e;     // Catch: Throwable -> L82
        if (r29 == 0) goto L66;
        r20 = r27.a / ((long) r29);     // Catch: Throwable -> L82
    L66:
        r3.put("logcat_gc_avg_cost_range", a(r20));     // Catch: Throwable -> L82
    L67:
        j.h(r25, "logcat_anr_info", r112.a());     // Catch: Throwable -> L82
        int r30 = r112.c;     // Catch: Throwable -> L82
        if (r30 == 0) goto L79;
        if (r30 == 1) goto L78;
        if (r30 == 2) goto L77;
        if (r30 != 3) goto L73;
        String r1 = "dropped";
    L80:
        j.h(r3, "anr_log_tag", r1);     // Catch: Throwable -> L82
        return;
    L73:
        if (r30 == 4) goto L75;
        r1 = "wrong";
        goto L80
    L75:
        r1 = "parsed_msg";
        goto L80
    L77:
        r1 = "parsed_log";
        goto L80
    L78:
        r1 = "found";
        goto L80
    L79:
        r1 = "none";
    L98:
        return;
    L97:
        return;
    }

    public static long c(long r2, String r4) {
        String r5 = r4.substring(0, 18);     // Catch: Throwable -> L5
        Date r3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(String.format("%tY", new Object[]{new Date(r2)}) + "-" + r5);     // Catch: Throwable -> L5
    L6:
        if (r3 != null) goto L12;
        return -1;
    L12:
        return r3.getTime();
    L5:
        r3 = null;
        goto L6
    }

    public static void h(JSONObject r7, File r8) {
        File r0 = new PolarisFileWrapper(r8, "logcat.txt");
        if (r0.exists() == true) goto L5;
    L48:
        NativeBridge.l(r8.getAbsolutePath(), false);     // Catch: Throwable -> L43
    L9:
        r0 = new PolarisFileWrapper(r8, "logcat.txt");
        if (r0.exists() == true) goto L12;
        return;
    L12:
        if (r0.isDirectory() == true) goto L60;
    L14:
        int r9 = (int) r0.length();
        JSONArray r1 = new JSONArray();
        BufferedReader r2 = new BufferedReader(new PolarisFileReaderWrapper(r0));     // Catch: Throwable -> L25
    L44:
        String r3 = r2.readLine();     // Catch: Throwable -> L23
        if (r3 != null) goto L19;
    L56:
        r2.close();     // Catch: IOException -> L31
    L33:
        if (r1.length() == 0) goto L58;
        r7.put("logcat", r1);     // Catch: JSONException -> L41
        return;
    L59:
        return;
    L58:
        return;
    L19:
        if (r9 >= 524288) goto L22;
        r1.put(r3);     // Catch: Throwable -> L23
    L22:
        r9 = r9 - (r3.length() + 1);
    L23:
        th = th;
    L52:
        p.d(th);     // Catch: Throwable -> L36
        if (r2 == null) goto L33;
    L36:
        th = move-exception;
        if (r2 != null) goto L54;
    L39:
        throw th;
    L54:
        r2.close();     // Catch: IOException -> L42
    L25:
        th = th;
        r2 = null;
        goto L52
    L60:
        return;
    L5:
        if (r0.isDirectory() == true) goto L48;
        if (r0.length() >= 50) goto L14;
        goto L14
    }

    public static void d(a r9, long r10, long r12, String r14) {
        if (r14.contains("Blocked msg") == true) goto L6;
        return;
    L6:
        if (1 <= r9.c) goto L47;
        r9.c = 1;
    L47:
        Matcher r15 = PatternProtector.compile(".*?Blocked msg = (\\{.*?\\}) , cost\\s+=\\s+(\\d+)\\s+ms").matcher(r14);     // Catch: Throwable -> L44
        if (r15.find() == true) goto L11;
        return;
    L11:
        if (2 <= r9.c) goto L13;
        r9.c = 2;     // Catch: Throwable -> L44
    L13:
        String r0 = r15.group(1);     // Catch: Throwable -> L44
        long r3 = CastIntegerProtector.parseInt(r15.group(2));     // Catch: Throwable -> L44
        long r5 = r10 - 20000;     // Catch: Throwable -> L44
        long r11 = r10 - 10000;     // Catch: Throwable -> L44
        if (r12 < r5) goto L27;
        long r6 = r9.a;     // Catch: Throwable -> L44
        if (r6 > 0) goto L22;
        if (r3 < 2000) goto L27;
    L26:
        boolean r13 = false;
    L29:
        if (r13 == true) goto L31;
        r9.b = r12;     // Catch: Throwable -> L44
        r9.a = r3;     // Catch: Throwable -> L44
        long r16 = -1;
        r9.d = -1;     // Catch: Throwable -> L44
        r9.e = -1;     // Catch: Throwable -> L44
        r9.f = null;     // Catch: Throwable -> L44
        r9.g = null;     // Catch: Throwable -> L44
        r9.h = null;     // Catch: Throwable -> L44
        if (r0 == null) goto L41;
        Matcher r17 = PatternProtector.compile(".*?when=(\\S+)\\s+what=(\\d+)\\s+target=(\\S+)\\s+(.*?)=(.*?)\\}$").matcher(r0);     // Catch: Throwable -> L44
        if (r17.find() == false) goto L41;
        r16 = g(r17.group(1));     // Catch: Throwable -> L44
        int r18 = CastIntegerProtector.parseInt(r17.group(2));     // Catch: Throwable -> L44
        String r19 = r17.group(3);     // Catch: Throwable -> L44
        String r1 = r17.group(4);     // Catch: Throwable -> L44
        String r110 = r17.group(5);     // Catch: Throwable -> L44
        if (4 <= r9.c) goto L42;
        r9.c = 4;     // Catch: Throwable -> L44
    L42:
        r9.d = r16;     // Catch: Throwable -> L44
        r9.e = r18;     // Catch: Throwable -> L44
        r9.f = r19;     // Catch: Throwable -> L44
        r9.g = r1;     // Catch: Throwable -> L44
        r9.h = r110;     // Catch: Throwable -> L44
        return;
    L41:
        r19 = null;
        r110 = null;
        r1 = null;
        r18 = -1;
        goto L42
    L31:
        if (3 <= r9.c) goto L48;
        r9.c = 3;     // Catch: Throwable -> L44
        return;
    L48:
        return;
    L22:
        if (r3 <= r6) goto L27;
        if (r12 >= r11) goto L26;
    L27:
        r13 = true;
    L44:
        th = move-exception;
        c.b("parseAnrLogException", th);
    }

    public static void e(b r3, long r4, int r6, long r7, long r9, long r11, String r13) {
        if (r7 <= (5000 + r4)) goto L5;
        return;
    L5:
        if (r7 >= (r4 - 30000)) goto L8;
        return;
    L8:
        if (r6 != 1) goto L17;
        r3.f++;
        Matcher r8 = PatternProtector.compile("(\\S+)\\s+.*?GC freed.*?paused \\S+ total (\\S+)").matcher(r13);
        if (r8.find() == false) goto L29;
        String r10 = r8.group(1);
        float r5 = f(r8.group(2));
        r3.b = (long) (r3.b + r5);
        if ("Background".equals(r10) == true) goto L15;
        r3.a = (long) (r3.a + r5);
        r3.e++;
    L15:
        if (r9 != r11) goto L30;
        r3.d = (long) (r3.d + r5);
        return;
    L30:
        return;
    L29:
        return;
    L17:
        if (r6 != 2) goto L32;
        Matcher r12 = PatternProtector.compile("WaitForGcToComplete blocked \\S+ on (\\S+) for (\\S+)").matcher(r13);
        if (r12.find() == false) goto L33;
        String r14 = r12.group(1);
        long r15 = (long) f(r12.group(2));
        Long r16 = (Long) ((HashMap) r3.j).get(r14);
        if (r16 != null) goto L23;
        ((HashMap) r3.j).put(r14, Long.valueOf(r15));
    L25:
        if (r9 != r11) goto L34;
        r3.c = (r3.c + 1) + r15;
        return;
    L34:
        return;
    L23:
        ((HashMap) r3.j).put(r14, Long.valueOf(r16.longValue() + r15));
        goto L25
    L33:
        return;
    }
}
