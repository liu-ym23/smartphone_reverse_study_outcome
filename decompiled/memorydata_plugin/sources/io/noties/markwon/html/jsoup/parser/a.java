package io.noties.markwon.html.jsoup.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.html.jsoup.UncheckedIOException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.CharCompanionObject;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char[] f16588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Reader f16589b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private final String[] h;

    public a(Reader r1, int r2) {
        this.h = new String[128];
        io.noties.markwon.html.jsoup.a.b.a(r1);
        io.noties.markwon.html.jsoup.a.b.a(r1.markSupported());
        this.f16589b = r1;
        this.f16588a = new char[4096];
        r();
    }

    public a(String r2) {
        this(new StringReader(r2), r2.length());
    }

    private static String a(char[] r5, String[] r6, int r7, int r8) {
        if (r8 <= 12) goto L7;
        return new String(r5, r7, r8);
    L7:
        if (r8 >= 1) goto L10;
        return "";
    L10:
        int r1 = 0;
        int r3 = r7;
        int r2 = 0;
    L11:
        if (r1 >= r8) goto L13;
        r2 = (r2 * 31) + r5[r3];
        r1 = r1 + 1;
        r3 = r3 + 1;
        goto L11
    L13:
        int r0 = r2 & (r6.length - 1);
        String r4 = r6[r0];
        if (r4 != null) goto L17;
        String r9 = new String(r5, r7, r8);
        r6[r0] = r9;
        return r9;
    L17:
        if (a(r5, r7, r8, r4) == false) goto L19;
        return r4;
    L19:
        String r10 = new String(r5, r7, r8);
        r6[r0] = r10;
        return r10;
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

    private void r() {
        int r0 = this.e;
        if (r0 >= this.d) goto L15;
        return;
    L15:
        this.f16589b.skip(r0);     // Catch: IOException -> L12
        this.f16589b.mark(4096);     // Catch: IOException -> L12
        int r1 = this.f16589b.read(this.f16588a);     // Catch: IOException -> L12
        this.f16589b.reset();     // Catch: IOException -> L12
        if (r1 == (-1)) goto L17;
        this.c = r1;     // Catch: IOException -> L12
        this.f += this.e;     // Catch: IOException -> L12
        this.e = 0;     // Catch: IOException -> L12
        this.g = 0;     // Catch: IOException -> L12
        if (r1 <= 3072) goto L10;
        r1 = 3072;
    L10:
        this.d = r1;     // Catch: IOException -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        throw new UncheckedIOException(e);
    }

    private boolean s() {
        if (this.e < this.c) goto L5;
        return true;
    L5:
        return false;
    }

    public int a() {
        return this.f + this.e;
    }

    int a(char r3) {
        r();
        int r0 = this.e;
    L4:
        if (r0 >= this.c) goto L10;
        if (r3 == this.f16588a[r0]) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return r0 - this.e;
    L10:
        return -1;
    }

    int a(CharSequence r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        r();
        char r0 = r10.charAt(0);
        int r1 = this.e;
    L4:
        if (r1 >= this.c) goto L24;
        int r3 = 1;
        if (r0 == this.f16588a[r1]) goto L12;
    L7:
        r1 = r1 + 1;
        if (r1 >= this.c) goto L12;
        if (r0 != this.f16588a[r1]) goto L7;
    L12:
        int r2 = r1 + 1;
        int r4 = (r10.length() + r2) - 1;
        int r5 = this.c;
        if (r1 >= r5) goto L23;
        if (r4 > r5) goto L23;
        int r6 = r2;
    L16:
        if (r6 >= r4) goto L20;
        if (r10.charAt(r3) != this.f16588a[r6]) goto L20;
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

    String a(String r4) {
        int r5 = a(r4);
        if (r5 == (-1)) goto L7;
        String r0 = a(this.f16588a, this.h, this.e, r5);
        this.e += r5;
        return r0;
    L7:
        return k();
    }

    public String a(char... r8) {
        r();
        int r0 = this.e;
        int r1 = this.c;
        char[] r2 = this.f16588a;
    L4:
        if (this.e >= r1) goto L12;
        int r3 = r8.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L11;
        if (r2[this.e] == r8[r4]) goto L12;
        r4 = r4 + 1;
        goto L6
    L11:
        this.e++;
    L12:
        int r9 = this.e;
        if (r9 > r0) goto L20;
        return "";
    L20:
        return a(this.f16588a, this.h, r0, r9 - r0);
    }

    public String b(char r4) {
        int r5 = a(r4);
        if (r5 == (-1)) goto L7;
        String r0 = a(this.f16588a, this.h, this.e, r5);
        this.e += r5;
        return r0;
    L7:
        return k();
    }

    String b(char... r5) {
        r();
        int r0 = this.e;
        int r1 = this.c;
        char[] r2 = this.f16588a;
    L3:
        int r3 = this.e;
        if (r3 >= r1) goto L9;
        if (Arrays.binarySearch(r5, r2[r3]) >= 0) goto L9;
        this.e++;
    L9:
        int r6 = this.e;
        if (r6 > r0) goto L16;
        return "";
    L16:
        return a(this.f16588a, this.h, r0, r6 - r0);
    }

    public boolean b() {
        r();
        if (this.e < this.c) goto L5;
        return true;
    L5:
        return false;
    }

    boolean b(String r7) {
        r();
        int r0 = r7.length();
        if (r0 <= (this.c - this.e)) goto L5;
        return false;
    L5:
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        if (r7.charAt(r1) != this.f16588a[this.e + r1]) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public char c() {
        r();
        if (s() == false) goto L6;
        return CharCompanionObject.MAX_VALUE;
    L6:
        return this.f16588a[this.e];
    }

    boolean c(char r2) {
        if (b() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f16588a[this.e] != r2) goto L7;
        return true;
    }

    boolean c(String r7) {
        r();
        int r0 = r7.length();
        if (r0 <= (this.c - this.e)) goto L5;
        return false;
    L5:
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        if (Character.toUpperCase(r7.charAt(r1)) != Character.toUpperCase(this.f16588a[this.e + r1])) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    boolean c(char... r5) {
        if (b() == false) goto L5;
        return false;
    L5:
        r();
        char r4 = this.f16588a[this.e];
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

    char d() {
        r();
        if (s() == false) goto L5;
        char r0 = CharCompanionObject.MAX_VALUE;
    L6:
        this.e++;
        return r0;
    L5:
        r0 = this.f16588a[this.e];
        goto L6
    }

    boolean d(String r2) {
        r();
        if (b(r2) == false) goto L6;
        this.e += r2.length();
        return true;
    L6:
        return false;
    }

    boolean d(char[] r2) {
        r();
        if (b() == false) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.binarySearch(r2, this.f16588a[this.e]) < 0) goto L7;
        return true;
    }

    void e() {
        this.e--;
    }

    boolean e(String r2) {
        if (c(r2) == false) goto L6;
        this.e += r2.length();
        return true;
    L6:
        return false;
    }

    public void f() {
        this.e++;
    }

    boolean f(String r3) {
        String r0 = r3.toLowerCase(Locale.ENGLISH);
        String r4 = r3.toUpperCase(Locale.ENGLISH);
        if (a(r0) <= (-1)) goto L5;
    L8:
        return true;
    L5:
        if (a(r4) > (-1)) goto L8;
        return false;
    }

    void g() {
        this.g = this.e;
    }

    void h() {
        this.e = this.g;
    }

    String i() {
        r();
        int r0 = this.e;
        int r1 = this.c;
        char[] r2 = this.f16588a;
    L3:
        int r3 = this.e;
        if (r3 >= r1) goto L12;
        char r4 = r2[r3];
        if (r4 == '&') goto L12;
        if (r4 == '<') goto L12;
        if (r4 == 0) goto L12;
        this.e = r3 + 1;
    L12:
        if (r3 > r0) goto L20;
        return "";
    L20:
        return a(this.f16588a, this.h, r0, r3 - r0);
    }

    String j() {
        r();
        int r0 = this.e;
        int r1 = this.c;
        char[] r2 = this.f16588a;
    L3:
        int r3 = this.e;
        if (r3 >= r1) goto L22;
        char r4 = r2[r3];
        if (r4 == '\t') goto L22;
        if (r4 == '\n') goto L22;
        if (r4 == '\r') goto L22;
        if (r4 == '\f') goto L22;
        if (r4 == ' ') goto L22;
        if (r4 == '/') goto L22;
        if (r4 == '>') goto L22;
        if (r4 == 0) goto L22;
        this.e = r3 + 1;
    L22:
        if (r3 > r0) goto L35;
        return "";
    L35:
        return a(this.f16588a, this.h, r0, r3 - r0);
    }

    String k() {
        r();
        char[] r0 = this.f16588a;
        String[] r1 = this.h;
        int r2 = this.e;
        String r3 = a(r0, r1, r2, this.c - r2);
        this.e = this.c;
        return r3;
    }

    String l() {
        r();
        int r0 = this.e;
    L3:
        int r1 = this.e;
        if (r1 >= this.c) goto L17;
        char r2 = this.f16588a[r1];
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
        return a(this.f16588a, this.h, r0, this.e - r0);
    }

    String m() {
        r();
        int r0 = this.e;
    L3:
        int r1 = this.e;
        if (r1 >= this.c) goto L17;
        char r2 = this.f16588a[r1];
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
        if (s() == true) goto L24;
        char[] r3 = this.f16588a;
        int r4 = this.e;
        char r5 = r3[r4];
        if (r5 < '0') goto L24;
        if (r5 > '9') goto L24;
        this.e = r4 + 1;
    L24:
        return a(this.f16588a, this.h, r0, this.e - r0);
    }

    String n() {
        r();
        int r0 = this.e;
    L3:
        int r1 = this.e;
        if (r1 >= this.c) goto L19;
        char r2 = this.f16588a[r1];
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
        return a(this.f16588a, this.h, r0, r1 - r0);
    }

    String o() {
        r();
        int r0 = this.e;
    L3:
        int r1 = this.e;
        if (r1 >= this.c) goto L11;
        char r2 = this.f16588a[r1];
        if (r2 < '0') goto L11;
        if (r2 > '9') goto L11;
        this.e = r1 + 1;
    L11:
        return a(this.f16588a, this.h, r0, r1 - r0);
    }

    boolean p() {
        if (b() == false) goto L5;
        return false;
    L5:
        char r2 = this.f16588a[this.e];
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

    boolean q() {
        if (b() == false) goto L5;
        return false;
    L5:
        char r2 = this.f16588a[this.e];
        if (r2 >= '0') goto L8;
        return false;
    L8:
        if (r2 > '9') goto L12;
        return true;
    L12:
        return false;
    }

    public String toString() {
        char[] r1 = this.f16588a;
        int r2 = this.e;
        return new String(r1, r2, this.c - r2);
    }
}
