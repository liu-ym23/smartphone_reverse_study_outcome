package com.bytedance.applog.log;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class k {
    public static final a i = null;
    public String a;
    public String b;
    public int c;
    public int d;
    public List<String> e;
    public String f;
    public long g;
    public Throwable h;

    static {
        i = new a();
    }

    public final String a() {
        int r0 = this.c;
        if (r0 != 0) goto L5;
        return "VERBOSE";
    L5:
        if (r0 != 1) goto L7;
        return "DEBUG";
    L7:
        if (r0 != 2) goto L9;
        return "INFO";
    L9:
        if (r0 != 3) goto L11;
        return "WARN";
    L11:
        if (r0 != 4) goto L13;
        return "ERROR";
    L13:
        if (r0 == 5) goto L16;
        return "";
    L16:
        return "ASSERT";
    }

    public final String b() {
        String r0 = this.f;
        if (r0 != null) goto L5;
    L8:
        String r1 = this.f;
        if (r1 != null) goto L13;
        return "";
    L13:
        return r1.toString();
    L5:
        if (r0.isEmpty() == true) goto L8;
        return this.f;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("[");
        if (this.g <= 0) goto L5;
        String r1 = ((SimpleDateFormat) i.get()).format(new Date(this.g));
    L6:
        r0.append(r1);
        r0.append("][");
        r0.append(a());
        r0.append("][");
        String r2 = this.a;
        String r3 = "";
        if (r2 == null) goto L9;
        String r4 = r2.toString();
    L10:
        r0.append(r4);
        r0.append("][");
        String r5 = this.b;
        if (r5 == null) goto L13;
        String r6 = r5.toString();
    L14:
        r0.append(r6);
        r0.append("][");
        switch(this.d) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            default: goto L16;
        };
    L16:
        String r7 = "DEFAULT";
    L32:
        r0.append(r7);
        r0.append("][");
        List<String> r8 = this.e;
        if (r8 != null) goto L35;
    L44:
        r0.append(r3);
        r0.append("] ");
        r0.append(b());
        String r9 = r0.toString();
        if (this.h == null) goto L59;
        StringBuilder r10 = new StringBuilder();
        r10.append(r9);
        r10.append("\nstacktrace: ");
        Throwable r11 = this.h;
        StringBuilder r12 = new StringBuilder();
    L47:
        if (r11 == null) goto L52;
        r12.append(r11.toString());
        StackTraceElement[] r13 = r11.getStackTrace();
        int r14 = r13.length;
        int r15 = 0;
    L49:
        if (r15 >= r14) goto L51;
        StackTraceElement r16 = r13[r15];
        r12.append("\n\tat ");
        r12.append(r16);
        r15 = r15 + 1;
        goto L49
    L51:
        r11 = r11.getCause();
        goto L47
    L52:
        r10.append(r12.toString());
        return r10.toString();
    L59:
        return r9;
    L35:
        if (r8.size() <= 0) goto L44;
        StringBuilder r17 = new StringBuilder();
        int r18 = 0;
    L38:
        if (r18 >= this.e.size()) goto L43;
        r17.append((String) ListProtector.get(this.e, r18));
        if (r18 >= (this.e.size() - 1)) goto L42;
        r17.append(",");
    L42:
        r18 = r18 + 1;
        goto L38
    L43:
        r3 = r17.toString();
        goto L44
    L17:
        r7 = "ONE_ID";
        goto L32
    L18:
        r7 = "COMPRESS";
        goto L32
    L19:
        r7 = "EVENT_PRIORITY";
        goto L32
    L20:
        r7 = "EVENT_SAMPLING";
        goto L32
    L21:
        r7 = "REQUEST";
        goto L32
    L22:
        r7 = "PICKER";
        goto L32
    L23:
        r7 = "USER_PROFILE";
        goto L32
    L24:
        r7 = "MONITOR";
        goto L32
    L25:
        r7 = "VIEW_EXPOSURE";
        goto L32
    L26:
        r7 = "EVENT_VERIFY";
        goto L32
    L27:
        r7 = "DATABASE";
        goto L32
    L28:
        r7 = "EVENT";
        goto L32
    L29:
        r7 = "ALINK";
        goto L32
    L30:
        r7 = "ABTEST";
        goto L32
    L31:
        r7 = "DEVICE_REGISTER";
        goto L32
    L13:
        r6 = "";
        goto L14
    L9:
        r4 = "";
        goto L10
    L5:
        r1 = "--";
        goto L6
    }

    public k() {
        this.c = 1;
        this.d = 0;
        this.g = System.currentTimeMillis();
    }
}
