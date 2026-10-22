package org.jsoup.parser;

import androidx.core.app.FrameMetricsAggregator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import kotlin.jvm.internal.CharCompanionObject;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.jsoup.UncheckedIOException;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private char[] f18282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Reader f18283b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private String[] h;
    private ArrayList<Integer> i;
    private int j;
    private boolean k;
    private String l;
    private int m;

    public a(Reader r2) {
        this(r2, 32768);
    }

    public a(Reader r2, int r3) {
        this.g = -1;
        this.h = new String[512];
        this.i = null;
        this.j = 1;
        org.jsoup.helper.b.a(r2);
        org.jsoup.helper.b.a(r2.markSupported());
        this.f18283b = r2;
        this.f18282a = new char[Math.min(r3, 32768)];
        z();
    }

    public a(String r2) {
        this(new StringReader(r2), r2.length());
    }

    private void A() {
        if (c() == true) goto L6;
        return;
    L6:
        if (this.i.size() <= 0) goto L11;
        int r0 = c(this.f);
        if (r0 != (-1)) goto L10;
        r0 = 0;
    L10:
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(this.i.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue();
        this.j += r0;
        this.i.clear();
        this.i.add(Integer.valueOf(r1));
    L11:
        int r2 = this.e;
    L13:
        if (r2 >= this.c) goto L18;
        if (this.f18282a[r2] != '\n') goto L17;
        this.i.add(Integer.valueOf((this.f + 1) + r2));
    L17:
        r2 = r2 + 1;
        goto L13
    }

    private boolean B() {
        if (this.e < this.c) goto L5;
        return true;
    L5:
        return false;
    }

    private static String a(char[] r3, String[] r4, int r5, int r6) {
        if (r6 <= 12) goto L7;
        return new String(r3, r5, r6);
    L7:
        if (r6 >= 1) goto L10;
        return "";
    L10:
        int r0 = 0;
        int r1 = 0;
    L11:
        if (r0 >= r6) goto L13;
        r1 = (r1 * 31) + r3[r5 + r0];
        r0 = r0 + 1;
        goto L11
    L13:
        int r2 = r1 & FrameMetricsAggregator.EVERY_DURATION;
        String r7 = r4[r2];
        if (r7 != null) goto L16;
    L18:
        String r8 = new String(r3, r5, r6);
        r4[r2] = r8;
        return r8;
    L16:
        if (a(r3, r5, r6, r7) == false) goto L18;
        return r7;
    }

    static boolean a(char[] r4, int r5, int r6, String r7) {
        if (r6 != r7.length()) goto L13;
        int r0 = 0;
    L5:
        int r2 = r6 - 1;
        if (r6 == 0) goto L11;
        int r8 = r5 + 1;
        int r3 = r0 + 1;
        if (r4[r5] != r7.charAt(r0)) goto L9;
        r5 = r8;
        r6 = r2;
        r0 = r3;
        goto L5
    L9:
        return false;
    L11:
        return true;
    L13:
        return false;
    }

    private int c(int r2) {
        if (c() == true) goto L6;
        return 0;
    L6:
        int r1 = Collections.binarySearch(this.i, Integer.valueOf(r2));
        if (r1 < (-1)) goto L9;
        return r1;
    L9:
        return Math.abs(r1) - 2;
    }

    private void z() {
        if (this.k == true) goto L35;
        int r0 = this.e;
        if (r0 < this.d) goto L40;
        int r1 = this.g;
        if (r1 == (-1)) goto L10;
        int r2 = r0 - r1;
        r0 = r1;
    L36:
        long r5 = r0;
        long r7 = this.f18283b.skip(r5);     // Catch: IOException -> L32
        this.f18283b.mark(32768);     // Catch: IOException -> L32
        int r4 = 0;
    L12:
        boolean r10 = true;
        if (r4 > 1024) goto L20;
        Reader r9 = this.f18283b;     // Catch: IOException -> L32
        char[] r11 = this.f18282a;     // Catch: IOException -> L32
        int r12 = r9.read(r11, r4, r11.length - r4);     // Catch: IOException -> L32
        if (r12 != (-1)) goto L17;
        this.k = true;     // Catch: IOException -> L32
    L17:
        if (r12 <= 0) goto L20;
        r4 = r4 + r12;     // Catch: IOException -> L32
    L20:
        this.f18283b.reset();     // Catch: IOException -> L32
        if (r4 > 0) goto L23;
    L30:
        A();
        this.l = null;
        return;
    L23:
        if (r7 == r5) goto L26;
        r10 = false;
    L26:
        org.jsoup.helper.b.a(r10);     // Catch: IOException -> L32
        this.c = r4;     // Catch: IOException -> L32
        this.f += r0;     // Catch: IOException -> L32
        this.e = r2;     // Catch: IOException -> L32
        if (this.g == (-1)) goto L29;
        this.g = 0;     // Catch: IOException -> L32
    L29:
        this.d = Math.min(r4, 24576);     // Catch: IOException -> L32
    L32:
        e = move-exception;
        throw new UncheckedIOException(e);
    L10:
        r2 = 0;
        goto L36
    L40:
        return;
    }

    int a(char r3) {
        z();
        int r0 = this.e;
    L4:
        if (r0 >= this.c) goto L10;
        if (r3 == this.f18282a[r0]) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return r0 - this.e;
    L10:
        return -1;
    }

    int a(int r3) {
        if (c() == true) goto L5;
        return 1;
    L5:
        int r4 = c(r3);
        int r2 = this.j;
        if (r4 != (-1)) goto L9;
        return r2;
    L9:
        return (r4 + r2) + 1;
    }

    int a(CharSequence r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        z();
        char r0 = r10.charAt(0);
        int r1 = this.e;
    L4:
        if (r1 >= this.c) goto L24;
        int r3 = 1;
        if (r0 == this.f18282a[r1]) goto L12;
    L7:
        r1 = r1 + 1;
        if (r1 >= this.c) goto L12;
        if (r0 != this.f18282a[r1]) goto L7;
    L12:
        int r2 = r1 + 1;
        int r4 = (r10.length() + r2) - 1;
        int r5 = this.c;
        if (r1 >= r5) goto L23;
        if (r4 > r5) goto L23;
        int r6 = r2;
    L16:
        if (r6 >= r4) goto L20;
        if (r10.charAt(r3) != this.f18282a[r6]) goto L20;
        r6 = r6 + 1;
        r3 = r3 + 1;
    L20:
        if (r6 != r4) goto L23;
        return r1 - this.e;
    L23:
        r1 = r2;
        goto L4
    L24:
        return -1;
    }

    String a(String r5) {
        int r0 = a(r5);
        if (r0 == (-1)) goto L7;
        String r6 = a(this.f18282a, this.h, this.e, r0);
        this.e += r0;
        return r6;
    L7:
        if ((this.c - this.e) < r5.length()) goto L9;
        int r1 = (this.c - r5.length()) + 1;
        char[] r7 = this.f18282a;
        String[] r2 = this.h;
        int r3 = this.e;
        String r8 = a(r7, r2, r3, r1 - r3);
        this.e = r1;
        return r8;
    L9:
        return r();
    }

    public String a(char... r9) {
        z();
        int r0 = this.e;
        int r1 = this.c;
        char[] r2 = this.f18282a;
        int r3 = r9.length;
        int r4 = r0;
    L3:
        if (r4 >= r1) goto L11;
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L10;
        if (r2[r4] == r9[r5]) goto L11;
        r5 = r5 + 1;
        goto L5
    L10:
        r4 = r4 + 1;
    L11:
        this.e = r4;
        if (r4 > r0) goto L19;
        return "";
    L19:
        return a(this.f18282a, this.h, r0, r4 - r0);
    }

    public void a() {
        Reader r0 = this.f18283b;
        if (r0 != null) goto L14;
        return;
    L14:
        r0.close();     // Catch: Throwable -> L8 IOException -> L13
    L8:
        th = move-exception;
        this.f18283b = null;
        this.f18282a = null;
        this.h = null;
        throw th;
    L11:
        this.f18283b = null;
        this.f18282a = null;
        this.h = null;
    }

    public void a(boolean r2) {
        if (r2 == true) goto L4;
    L6:
        if (r2 == true) goto L10;
        this.i = null;
        return;
    L10:
        return;
    L4:
        if (this.i != null) goto L6;
        this.i = new ArrayList(409);
        A();
    }

    public int b() {
        return this.f + this.e;
    }

    int b(int r3) {
        if (c() == false) goto L5;
        int r0 = c(r3);
        if (r0 != (-1)) goto L11;
        return r3 + 1;
    L11:
        return (r3 - ((Integer) ZeusTransformUtils.preCheckCast(this.i.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue()) + 1;
    L5:
        return r3 + 1;
    }

    public String b(char r4) {
        int r5 = a(r4);
        if (r5 == (-1)) goto L7;
        String r0 = a(this.f18282a, this.h, this.e, r5);
        this.e += r5;
        return r0;
    L7:
        return r();
    }

    String b(boolean r7) {
        int r0 = this.e;
        int r1 = this.c;
        char[] r2 = this.f18282a;
        int r3 = r0;
    L3:
        if (r3 >= r1) goto L18;
        char r4 = r2[r3];
        if (r4 == 0) goto L18;
        if (r4 != '\"') goto L9;
    L15:
        if (r7 == false) goto L18;
    L17:
        r3 = r3 + 1;
        goto L3
    L9:
        if (r4 == '&') goto L18;
        if (r4 != '\'') goto L17;
        if (r7 == false) goto L15;
    L18:
        this.e = r3;
        if (r3 > r0) goto L30;
        return "";
    L30:
        return a(this.f18282a, this.h, r0, r3 - r0);
    }

    String b(char... r6) {
        z();
        int r0 = this.e;
        int r1 = this.c;
        char[] r2 = this.f18282a;
        int r3 = r0;
    L3:
        if (r3 >= r1) goto L8;
        if (Arrays.binarySearch(r6, r2[r3]) >= 0) goto L8;
        r3 = r3 + 1;
    L8:
        this.e = r3;
        if (r3 > r0) goto L15;
        return "";
    L15:
        return a(this.f18282a, this.h, r0, r3 - r0);
    }

    boolean b(String r7) {
        z();
        int r0 = r7.length();
        if (r0 <= (this.c - this.e)) goto L5;
        return false;
    L5:
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        if (r7.charAt(r1) != this.f18282a[this.e + r1]) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public boolean c() {
        if (this.i == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean c(char r2) {
        if (g() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f18282a[this.e] != r2) goto L7;
        return true;
    }

    boolean c(String r7) {
        z();
        int r0 = r7.length();
        if (r0 <= (this.c - this.e)) goto L5;
        return false;
    L5:
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        if (Character.toUpperCase(r7.charAt(r1)) != Character.toUpperCase(this.f18282a[this.e + r1])) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    boolean c(char... r5) {
        if (g() == false) goto L5;
        return false;
    L5:
        z();
        char r4 = this.f18282a[this.e];
        int r0 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        if (r5[r2] == r4) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public int d() {
        return a(b());
    }

    boolean d(String r2) {
        z();
        if (b(r2) == false) goto L6;
        this.e += r2.length();
        return true;
    L6:
        return false;
    }

    boolean d(char[] r2) {
        z();
        if (g() == false) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.binarySearch(r2, this.f18282a[this.e]) < 0) goto L7;
        return true;
    }

    public int e() {
        return b(b());
    }

    boolean e(String r2) {
        if (c(r2) == false) goto L6;
        this.e += r2.length();
        return true;
    L6:
        return false;
    }

    String f() {
        return d() + ParameterizedMessage.ERROR_MSG_SEPARATOR + e();
    }

    boolean f(String r6) {
        boolean r1 = false;
        int r3 = -1;
        if (r6.equals(this.l) == false) goto L10;
        int r0 = this.m;
        if (r0 != (-1)) goto L8;
        return false;
    L8:
        if (r0 < this.e) goto L10;
        return true;
    L10:
        this.l = r6;
        int r2 = a(r6.toLowerCase(Locale.ENGLISH));
        if (r2 <= (-1)) goto L14;
        this.m = this.e + r2;
        return true;
    L14:
        int r7 = a(r6.toUpperCase(Locale.ENGLISH));
        if (r7 <= (-1)) goto L17;
        r1 = true;
    L17:
        if (r1 == false) goto L19;
        r3 = this.e + r7;
    L19:
        this.m = r3;
        return r1;
    }

    public boolean g() {
        z();
        if (this.e < this.c) goto L5;
        return true;
    L5:
        return false;
    }

    public char h() {
        z();
        if (B() == false) goto L6;
        return CharCompanionObject.MAX_VALUE;
    L6:
        return this.f18282a[this.e];
    }

    char i() {
        z();
        if (B() == false) goto L5;
        char r0 = CharCompanionObject.MAX_VALUE;
    L6:
        this.e++;
        return r0;
    L5:
        r0 = this.f18282a[this.e];
        goto L6
    }

    void j() {
        int r0 = this.e;
        if (r0 < 1) goto L7;
        this.e = r0 - 1;
        return;
    L7:
        throw new UncheckedIOException(new IOException("WTF: No buffer left to unconsume."));
    }

    public void k() {
        this.e++;
    }

    void l() {
        if ((this.c - this.e) >= 1024) goto L5;
        this.d = 0;
    L5:
        z();
        this.g = this.e;
    }

    void m() {
        this.g = -1;
    }

    void n() {
        int r0 = this.g;
        if (r0 == (-1)) goto L7;
        this.e = r0;
        m();
        return;
    L7:
        throw new UncheckedIOException(new IOException("Mark invalid"));
    }

    String o() {
        int r0 = this.e;
        int r1 = this.c;
        char[] r2 = this.f18282a;
        int r3 = r0;
    L3:
        if (r3 >= r1) goto L11;
        char r4 = r2[r3];
        if (r4 == 0) goto L11;
        if (r4 == '&') goto L11;
        if (r4 == '<') goto L11;
        r3 = r3 + 1;
    L11:
        this.e = r3;
        if (r3 > r0) goto L20;
        return "";
    L20:
        return a(this.f18282a, this.h, r0, r3 - r0);
    }

    String p() {
        int r0 = this.e;
        int r1 = this.c;
        char[] r2 = this.f18282a;
        int r3 = r0;
    L3:
        if (r3 >= r1) goto L9;
        char r4 = r2[r3];
        if (r4 == 0) goto L9;
        if (r4 == '<') goto L9;
        r3 = r3 + 1;
    L9:
        this.e = r3;
        if (r3 > r0) goto L17;
        return "";
    L17:
        return a(this.f18282a, this.h, r0, r3 - r0);
    }

    String q() {
        z();
        int r0 = this.e;
        int r1 = this.c;
        char[] r2 = this.f18282a;
        int r3 = r0;
    L3:
        if (r3 >= r1) goto L21;
        char r4 = r2[r3];
        if (r4 == '\t') goto L21;
        if (r4 == '\n') goto L21;
        if (r4 == '\f') goto L21;
        if (r4 == '\r') goto L21;
        if (r4 == ' ') goto L21;
        if (r4 == '/') goto L21;
        if (r4 == '<') goto L21;
        if (r4 == '>') goto L21;
        r3 = r3 + 1;
    L21:
        this.e = r3;
        if (r3 > r0) goto L35;
        return "";
    L35:
        return a(this.f18282a, this.h, r0, r3 - r0);
    }

    String r() {
        z();
        char[] r0 = this.f18282a;
        String[] r1 = this.h;
        int r2 = this.e;
        String r3 = a(r0, r1, r2, this.c - r2);
        this.e = this.c;
        return r3;
    }

    String s() {
        z();
        int r0 = this.e;
    L3:
        int r1 = this.e;
        if (r1 >= this.c) goto L17;
        char r2 = this.f18282a[r1];
        if (r2 < 'A') goto L10;
        if (r2 > 'Z') goto L10;
    L15:
        this.e++;
    L10:
        if (r2 < 'a') goto L14;
        if (r2 <= 'z') goto L15;
    L14:
        if (Character.isLetter(r2) == true) goto L15;
    L17:
        return a(this.f18282a, this.h, r0, this.e - r0);
    }

    String t() {
        z();
        int r0 = this.e;
    L3:
        int r1 = this.e;
        if (r1 >= this.c) goto L17;
        char r2 = this.f18282a[r1];
        if (r2 < 'A') goto L10;
        if (r2 > 'Z') goto L10;
    L15:
        this.e++;
    L10:
        if (r2 < 'a') goto L14;
        if (r2 <= 'z') goto L15;
    L14:
        if (Character.isLetter(r2) == true) goto L15;
    L17:
        if (B() == true) goto L24;
        char[] r3 = this.f18282a;
        int r4 = this.e;
        char r5 = r3[r4];
        if (r5 < '0') goto L24;
        if (r5 > '9') goto L24;
        this.e = r4 + 1;
    L24:
        return a(this.f18282a, this.h, r0, this.e - r0);
    }

    public String toString() {
        if ((this.c - this.e) >= 0) goto L6;
        return "";
    L6:
        char[] r1 = this.f18282a;
        int r2 = this.e;
        return new String(r1, r2, this.c - r2);
    }

    String u() {
        z();
        int r0 = this.e;
    L3:
        int r1 = this.e;
        if (r1 >= this.c) goto L19;
        char r2 = this.f18282a[r1];
        if (r2 < '0') goto L10;
        if (r2 > '9') goto L10;
    L17:
        this.e = r1 + 1;
    L10:
        if (r2 < 'A') goto L14;
        if (r2 <= 'F') goto L17;
    L14:
        if (r2 < 'a') goto L19;
        if (r2 <= 'f') goto L17;
    L19:
        return a(this.f18282a, this.h, r0, r1 - r0);
    }

    String v() {
        z();
        int r0 = this.e;
    L3:
        int r1 = this.e;
        if (r1 >= this.c) goto L11;
        char r2 = this.f18282a[r1];
        if (r2 < '0') goto L11;
        if (r2 > '9') goto L11;
        this.e = r1 + 1;
    L11:
        return a(this.f18282a, this.h, r0, r1 - r0);
    }

    boolean w() {
        if (g() == false) goto L5;
        return false;
    L5:
        char r2 = this.f18282a[this.e];
        if (r2 < 'A') goto L10;
        if (r2 > 'Z') goto L10;
    L15:
        return true;
    L10:
        if (r2 < 'a') goto L14;
        if (r2 <= 'z') goto L15;
    L14:
        if (Character.isLetter(r2) == true) goto L15;
        return false;
    }

    boolean x() {
        if (g() == false) goto L5;
        return false;
    L5:
        char r2 = this.f18282a[this.e];
        if (r2 < 'A') goto L10;
        if (r2 > 'Z') goto L10;
    L13:
        return true;
    L10:
        if (r2 >= 'a') goto L12;
        return false;
    L12:
        if (r2 <= 'z') goto L13;
        return false;
    }

    boolean y() {
        if (g() == false) goto L5;
        return false;
    L5:
        char r2 = this.f18282a[this.e];
        if (r2 >= '0') goto L8;
        return false;
    L8:
        if (r2 > '9') goto L12;
        return true;
    L12:
        return false;
    }
}
