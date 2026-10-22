package c4;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f3338i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f3343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f3344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f3345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Throwable f3346h;

    public static class a extends ThreadLocal<SimpleDateFormat> {
        @Override // java.lang.ThreadLocal
        @SuppressLint({"SimpleDateFormat"})
        public final SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    }

    static {
        f3338i = new a();
    }

    public i() {
        this.f3341c = 1;
        this.f3342d = 0;
        this.f3345g = System.currentTimeMillis();
    }

    public final String a() {
        int r8 = this.f3341c;
        if (r8 != 0) goto L5;
        return "VERBOSE";
    L5:
        if (r8 != 1) goto L7;
        return "DEBUG";
    L7:
        if (r8 != 2) goto L9;
        return "INFO";
    L9:
        if (r8 != 3) goto L11;
        return "WARN";
    L11:
        if (r8 != 4) goto L13;
        return "ERROR";
    L13:
        if (r8 == 5) goto L16;
        return "";
    L16:
        return "ASSERT";
    }

    public final String b() {
        StringBuilder r8 = new StringBuilder("[");
        r8.append(a());
        r8.append("][");
        String r10 = this.f3339a;
        if (r10 == null) goto L5;
        String r11 = r10.toString();
    L6:
        r8.append(r11);
        r8.append("] ");
        r8.append(c());
        return r8.toString();
    L5:
        r11 = "";
        goto L6
    }

    public final String c() {
        String r8 = this.f3344f;
        if (r8 != null) goto L5;
    L8:
        String r10 = this.f3344f;
        if (r10 != null) goto L13;
        return "";
    L13:
        return r10.toString();
    L5:
        if (r8.isEmpty() == true) goto L8;
        return this.f3344f;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("[");
        if (this.f3345g <= 0) goto L5;
        String r10 = f3338i.get().format(new Date(this.f3345g));
    L6:
        r8.append(r10);
        r8.append("][");
        r8.append(a());
        r8.append("][");
        String r11 = this.f3339a;
        String r12 = "";
        if (r11 == null) goto L9;
        String r13 = r11.toString();
    L10:
        r8.append(r13);
        r8.append("][");
        String r14 = this.f3340b;
        if (r14 == null) goto L13;
        String r15 = r14.toString();
    L14:
        r8.append(r15);
        r8.append("][");
        switch(this.f3342d) {
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
        String r16 = "DEFAULT";
    L32:
        r8.append(r16);
        r8.append("][");
        List<String> r17 = this.f3343e;
        if (r17 != null) goto L35;
    L44:
        r8.append(r12);
        r8.append("] ");
        r8.append(c());
        String r18 = r8.toString();
        if (this.f3346h == null) goto L59;
        StringBuilder r19 = android.aimedia.a.k(r18, "\nstacktrace: ");
        Throwable r20 = this.f3346h;
        StringBuilder r21 = new StringBuilder();
    L47:
        if (r20 == null) goto L52;
        r21.append(r20.toString());
        StackTraceElement[] r22 = r20.getStackTrace();
        int r23 = r22.length;
        int r24 = 0;
    L49:
        if (r24 >= r23) goto L51;
        StackTraceElement r25 = r22[r24];
        r21.append("\n\tat ");
        r21.append(r25);
        r24 = r24 + 1;
        goto L49
    L51:
        r20 = r20.getCause();
        goto L47
    L52:
        r19.append(r21.toString());
        return r19.toString();
    L59:
        return r18;
    L35:
        if (r17.size() <= 0) goto L44;
        StringBuilder r26 = new StringBuilder();
        int r27 = 0;
    L38:
        if (r27 >= this.f3343e.size()) goto L43;
        r26.append(this.f3343e.get(r27));
        if (r27 >= (this.f3343e.size() - 1)) goto L42;
        r26.append(",");
    L42:
        r27 = r27 + 1;
        goto L38
    L43:
        r12 = r26.toString();
        goto L44
    L17:
        r16 = "ONE_ID";
        goto L32
    L18:
        r16 = "COMPRESS";
        goto L32
    L19:
        r16 = "EVENT_PRIORITY";
        goto L32
    L20:
        r16 = "EVENT_SAMPLING";
        goto L32
    L21:
        r16 = "REQUEST";
        goto L32
    L22:
        r16 = "PICKER";
        goto L32
    L23:
        r16 = "USER_PROFILE";
        goto L32
    L24:
        r16 = "MONITOR";
        goto L32
    L25:
        r16 = "VIEW_EXPOSURE";
        goto L32
    L26:
        r16 = "EVENT_VERIFY";
        goto L32
    L27:
        r16 = "DATABASE";
        goto L32
    L28:
        r16 = "EVENT";
        goto L32
    L29:
        r16 = "ALINK";
        goto L32
    L30:
        r16 = "ABTEST";
        goto L32
    L31:
        r16 = "DEVICE_REGISTER";
        goto L32
    L13:
        r15 = "";
        goto L14
    L9:
        r13 = "";
        goto L10
    L5:
        r10 = "--";
        goto L6
    }
}
