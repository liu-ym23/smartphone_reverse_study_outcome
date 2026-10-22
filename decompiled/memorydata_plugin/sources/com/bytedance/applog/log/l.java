package com.bytedance.applog.log;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f1635a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1636b;
    private String c;
    private int d;
    private int e;
    private List<String> f;
    private String g;
    private r h;
    private long i;
    private Throwable j;

    static {
        f1635a = new AnonymousClass1();
    }

    public l() {
        this.d = 1;
        this.e = 0;
        this.i = System.currentTimeMillis();
    }

    public static m a() {
        return new m();
    }

    private String a(Object r1) {
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1.toString();
    }

    private void a(StringBuilder r4, Throwable r5) {
        r4.append(r5.toString());
        StackTraceElement[] r3 = r5.getStackTrace();
        int r6 = r3.length;
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        StackTraceElement r1 = r3[r0];
        r4.append("\n\tat ").append(r1);
        r0 = r0 + 1;
        goto L3
    }

    private String b(Throwable r2) {
        StringBuilder r0 = new StringBuilder();
    L3:
        if (r2 == null) goto L6;
        a(r0, r2);
        r2 = r2.getCause();
        goto L3
    L6:
        return r0.toString();
    }

    public void a(int r1) {
        this.d = r1;
    }

    public void a(long r1) {
        this.i = r1;
    }

    public void a(String r1) {
        this.f1636b = r1;
    }

    public void a(Throwable r1) {
        this.j = r1;
    }

    public void a(List<String> r3) {
        this.f = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public int b() {
        return this.d;
    }

    public void b(int r1) {
        this.e = r1;
    }

    public void b(String r1) {
        this.c = r1;
    }

    public Throwable c() {
        return this.j;
    }

    public void c(String r1) {
        this.g = r1;
    }

    public String d() {
        int r1 = this.d;
        if (r1 != 0) goto L5;
        return "VERBOSE";
    L5:
        if (r1 != 1) goto L7;
        return CipherConst.LEVEL_DEBUG;
    L7:
        if (r1 != 2) goto L9;
        return CipherConst.LEVEL_INFO;
    L9:
        if (r1 != 3) goto L11;
        return CipherConst.LEVEL_WARN;
    L11:
        if (r1 != 4) goto L13;
        return CipherConst.LEVEL_ERROR;
    L13:
        if (r1 == 5) goto L16;
        return "";
    L16:
        return "ASSERT";
    }

    public String e() {
        switch(this.e) {
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L30;
            case 4: goto L28;
            case 5: goto L26;
            case 6: goto L24;
            case 7: goto L22;
            case 8: goto L20;
            case 9: goto L18;
            case 10: goto L16;
            case 11: goto L14;
            case 12: goto L12;
            case 13: goto L10;
            case 14: goto L8;
            case 15: goto L6;
            default: goto L4;
        };
    L4:
        return "DEFAULT";
    L6:
        return "ONE_ID";
    L8:
        return "COMPRESS";
    L10:
        return "EVENT_PRIORITY";
    L12:
        return "EVENT_SAMPLING";
    L14:
        return "REQUEST";
    L16:
        return "PICKER";
    L18:
        return "USER_PROFILE";
    L20:
        return "MONITOR";
    L22:
        return "VIEW_EXPOSURE";
    L24:
        return "EVENT_VERIFY";
    L26:
        return "DATABASE";
    L28:
        return PendingMemoryCalendar.TYPE_EVENT;
    L30:
        return "ALINK";
    L32:
        return "ABTEST";
    L34:
        return "DEVICE_REGISTER";
    }

    public String f() {
        List<String> r0 = this.f;
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.size() <= 0) goto L20;
        StringBuilder r1 = new StringBuilder();
        int r2 = 0;
    L8:
        if (r2 >= this.f.size()) goto L14;
        r1.append((String) ZeusTransformUtils.preCheckCast(this.f.get(r2), String.class, "com.obric.memorydata.plugin"));
        if (r2 >= (this.f.size() - 1)) goto L12;
        r1.append(",");
    L12:
        r2 = r2 + 1;
        goto L8
    L14:
        return r1.toString();
    L20:
        return "";
    }

    public String g() {
        if (this.i > 0) goto L5;
        return "--";
    L5:
        return ((SimpleDateFormat) ZeusTransformUtils.preCheckCast(f1635a.get(), SimpleDateFormat.class, "com.obric.memorydata.plugin")).format(new Date(this.i));
    }

    public String h() {
        return "[" + d() + "][" + a(this.f1636b) + "] " + i();
    }

    public String i() {
        String r0 = this.g;
        if (r0 != null) goto L5;
    L8:
        r r1 = this.h;
        if (r1 == null) goto L12;
        this.g = r1.a();
    L12:
        return a(this.g);
    L5:
        if (r0.isEmpty() == true) goto L8;
        return this.g;
    }

    public String toString() {
        String r0 = "[" + g() + "][" + d() + "][" + a(this.f1636b) + "][" + a(this.c) + "][" + e() + "][" + f() + "] " + i();
        if (c() != null) goto L5;
        return r0;
    L5:
        return r0 + "\nstacktrace: " + b(c());
    }
}
