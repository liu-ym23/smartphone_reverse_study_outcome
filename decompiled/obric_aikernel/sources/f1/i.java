package f1;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f8797i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f8802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f8804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Throwable f8805h;

    static class a extends ThreadLocal<SimpleDateFormat> {
        a() {
        }

        @SuppressLint({"SimpleDateFormat"})
        protected SimpleDateFormat a() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

        @Override // java.lang.ThreadLocal
        @SuppressLint({"SimpleDateFormat"})
        protected /* bridge */ /* synthetic */ SimpleDateFormat initialValue() {
            return a();
        }
    }

    static {
        f8797i = new a();
    }

    public i() {
        this.f8800c = 1;
        this.f8801d = 0;
        this.f8804g = System.currentTimeMillis();
    }

    private void a(StringBuilder r10, Throwable r11) {
        r10.append(r11.toString());
        StackTraceElement[] r12 = r11.getStackTrace();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        StackTraceElement r15 = r12[r14];
        r10.append("\n\tat ");
        r10.append(r15);
        r14 = r14 + 1;
        goto L3
    }

    public static j b() {
        return new j();
    }

    private String d(Throwable r10) {
        StringBuilder r11 = new StringBuilder();
    L3:
        if (r10 == null) goto L6;
        a(r11, r10);
        r10 = r10.getCause();
        goto L3
    L6:
        return r11.toString();
    }

    private String t(Object r10) {
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10.toString();
    }

    public String c() {
        switch(this.f8801d) {
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
        return "EVENT";
    L30:
        return "ALINK";
    L32:
        return "ABTEST";
    L34:
        return "DEVICE_REGISTER";
    }

    public int e() {
        return this.f8800c;
    }

    public String f() {
        int r10 = this.f8800c;
        if (r10 != 0) goto L5;
        return "VERBOSE";
    L5:
        if (r10 != 1) goto L7;
        return "DEBUG";
    L7:
        if (r10 != 2) goto L9;
        return "INFO";
    L9:
        if (r10 != 3) goto L11;
        return "WARN";
    L11:
        if (r10 != 4) goto L13;
        return "ERROR";
    L13:
        if (r10 == 5) goto L16;
        return "";
    L16:
        return "ASSERT";
    }

    public String g() {
        List<String> r10 = this.f8802e;
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r10.size() <= 0) goto L20;
        StringBuilder r11 = new StringBuilder();
        int r12 = 0;
    L8:
        if (r12 >= this.f8802e.size()) goto L14;
        r11.append(this.f8802e.get(r12));
        if (r12 >= (this.f8802e.size() - 1)) goto L12;
        r11.append(",");
    L12:
        r12 = r12 + 1;
        goto L8
    L14:
        return r11.toString();
    L20:
        return "";
    }

    public Throwable h() {
        return this.f8805h;
    }

    public String i() {
        if (this.f8804g > 0) goto L5;
        return "--";
    L5:
        return f8797i.get().format(new Date(this.f8804g));
    }

    public void j(String r10) {
        this.f8798a = r10;
    }

    public void k(int r10) {
        this.f8801d = r10;
    }

    public void l(int r10) {
        this.f8800c = r10;
    }

    public void m(String r10) {
        this.f8803f = r10;
    }

    public void n(List<String> r10) {
        this.f8802e = r10;
    }

    public void o(String r10) {
        this.f8799b = r10;
    }

    public void p(Throwable r10) {
        this.f8805h = r10;
    }

    public void q(long r10) {
        this.f8804g = r10;
    }

    public String r() {
        return "[" + f() + "][" + t(this.f8798a) + "] " + t(this.f8803f);
    }

    public String s() {
        return t(this.f8803f);
    }

    public String toString() {
        String r10 = "[" + i() + "][" + f() + "][" + t(this.f8798a) + "][" + t(this.f8799b) + "][" + c() + "][" + g() + "] " + t(this.f8803f);
        if (h() != null) goto L5;
        return r10;
    L5:
        return r10 + "\nstacktrace: " + d(h());
    }
}
