package bv;

import ai.j0;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements DatabaseMetaData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public dv.a f1000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PreparedStatement f1001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PreparedStatement f1002c;
    public PreparedStatement d;
    public PreparedStatement e;
    public PreparedStatement f;
    public PreparedStatement g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PreparedStatement f1003h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PreparedStatement f1004i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PreparedStatement f1005j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PreparedStatement f1006k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PreparedStatement f1007l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PreparedStatement f1008m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PreparedStatement f1009n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PreparedStatement f1010o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PreparedStatement f1011p;

    static {
        Pattern.compile(".*\\sPRIMARY\\s+KEY\\s+\\((.*?,+.*?)\\).*", 34);
        Pattern.compile(".*\\sCONSTRAINT\\s+(.*?)\\s+PRIMARY\\s+KEY\\s+\\((.*?)\\).*", 34);
    }

    public static String a(String r5) {
        int r10 = r5.length();
        StringBuilder r11 = new StringBuilder(r10);
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L9;
        if (r5.charAt(r12) != '\'') goto L7;
        r11.append('\'');
    L7:
        r11.append(r5.charAt(r12));
        r12 = r12 + 1;
        goto L3
    L9:
        return r11.toString();
    }

    public static String b(String r5) {
        if (r5 != null) goto L6;
        return "null";
    L6:
        return j0.k("'", r5, "'");
    }

    public final synchronized void close() {
        monitor-enter(this);
    L59:
        th = move-exception;
        throw th;
    L4:
        if (this.f1000a != null) goto L65;
        monitor-exit(this);
        return;
    L65:
        PreparedStatement r5 = this.f1001b;     // Catch: Throwable -> L11
        if (r5 == null) goto L13;
        r5.close();     // Catch: Throwable -> L11
    L13:
        PreparedStatement r10 = this.f1002c;     // Catch: Throwable -> L11
        if (r10 == null) goto L16;
        r10.close();     // Catch: Throwable -> L11
    L16:
        PreparedStatement r11 = this.d;     // Catch: Throwable -> L11
        if (r11 == null) goto L19;
        r11.close();     // Catch: Throwable -> L11
    L19:
        PreparedStatement r12 = this.e;     // Catch: Throwable -> L11
        if (r12 == null) goto L22;
        r12.close();     // Catch: Throwable -> L11
    L22:
        PreparedStatement r13 = this.f;     // Catch: Throwable -> L11
        if (r13 == null) goto L25;
        r13.close();     // Catch: Throwable -> L11
    L25:
        PreparedStatement r14 = this.g;     // Catch: Throwable -> L11
        if (r14 == null) goto L28;
        r14.close();     // Catch: Throwable -> L11
    L28:
        PreparedStatement r15 = this.f1003h;     // Catch: Throwable -> L11
        if (r15 == null) goto L31;
        r15.close();     // Catch: Throwable -> L11
    L31:
        PreparedStatement r16 = this.f1004i;     // Catch: Throwable -> L11
        if (r16 == null) goto L34;
        r16.close();     // Catch: Throwable -> L11
    L34:
        PreparedStatement r17 = this.f1005j;     // Catch: Throwable -> L11
        if (r17 == null) goto L37;
        r17.close();     // Catch: Throwable -> L11
    L37:
        PreparedStatement r18 = this.f1006k;     // Catch: Throwable -> L11
        if (r18 == null) goto L40;
        r18.close();     // Catch: Throwable -> L11
    L40:
        PreparedStatement r19 = this.f1007l;     // Catch: Throwable -> L11
        if (r19 == null) goto L43;
        r19.close();     // Catch: Throwable -> L11
    L43:
        PreparedStatement r20 = this.f1008m;     // Catch: Throwable -> L11
        if (r20 == null) goto L46;
        r20.close();     // Catch: Throwable -> L11
    L46:
        PreparedStatement r21 = this.f1009n;     // Catch: Throwable -> L11
        if (r21 == null) goto L49;
        r21.close();     // Catch: Throwable -> L11
    L49:
        PreparedStatement r22 = this.f1010o;     // Catch: Throwable -> L11
        if (r22 == null) goto L52;
        r22.close();     // Catch: Throwable -> L11
    L52:
        PreparedStatement r23 = this.f1011p;     // Catch: Throwable -> L11
        if (r23 == null) goto L55;
        r23.close();     // Catch: Throwable -> L11
    L55:
        this.f1001b = null;     // Catch: Throwable -> L11
        this.f1002c = null;     // Catch: Throwable -> L11
        this.d = null;     // Catch: Throwable -> L11
        this.e = null;     // Catch: Throwable -> L11
        this.f = null;     // Catch: Throwable -> L11
        this.g = null;     // Catch: Throwable -> L11
        this.f1003h = null;     // Catch: Throwable -> L11
        this.f1004i = null;     // Catch: Throwable -> L11
        this.f1005j = null;     // Catch: Throwable -> L11
        this.f1006k = null;     // Catch: Throwable -> L11
        this.f1007l = null;     // Catch: Throwable -> L11
        this.f1008m = null;     // Catch: Throwable -> L11
        this.f1009n = null;     // Catch: Throwable -> L11
        this.f1010o = null;     // Catch: Throwable -> L11
        this.f1011p = null;     // Catch: Throwable -> L11
        this.f1000a = null;     // Catch: Throwable -> L59
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        this.f1000a = null;     // Catch: Throwable -> L59
        throw th;     // Catch: Throwable -> L59
    }
}
