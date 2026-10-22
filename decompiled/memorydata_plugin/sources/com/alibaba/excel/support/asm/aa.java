package com.alibaba.excel.support.asm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aa f300a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final aa f301b = null;
    public static final aa c = null;
    public static final aa d = null;
    public static final aa e = null;
    public static final aa f = null;
    public static final aa g = null;
    public static final aa h = null;
    public static final aa i = null;
    private final int j;
    private final String k;
    private final int l;
    private final int m;

    static {
        f300a = new aa(0, "VZCBSIFJD", 0, 1);
        f301b = new aa(1, "VZCBSIFJD", 1, 2);
        c = new aa(2, "VZCBSIFJD", 2, 3);
        d = new aa(3, "VZCBSIFJD", 3, 4);
        e = new aa(4, "VZCBSIFJD", 4, 5);
        f = new aa(5, "VZCBSIFJD", 5, 6);
        g = new aa(6, "VZCBSIFJD", 6, 7);
        h = new aa(7, "VZCBSIFJD", 7, 8);
        i = new aa(8, "VZCBSIFJD", 8, 9);
    }

    private aa(int r1, String r2, int r3, int r4) {
        this.j = r1;
        this.k = r2;
        this.l = r3;
        this.m = r4;
    }

    public static aa a(String r4) {
        if (r4.charAt(0) != '[') goto L5;
        int r2 = 9;
    L7:
        return new aa(r2, r4, 0, r4.length());
    L5:
        r2 = 12;
        goto L7
    }

    private static aa a(String r2, int r3, int r4) {
        char r0 = r2.charAt(r3);
        if (r0 == '(') goto L46;
        if (r0 == 'F') goto L44;
        if (r0 == 'L') goto L42;
        if (r0 == 'S') goto L40;
        if (r0 == 'V') goto L38;
        if (r0 == 'I') goto L36;
        if (r0 == 'J') goto L34;
        if (r0 == 'Z') goto L32;
        if (r0 == '[') goto L30;
        switch(r0) {
            case 66: goto L28;
            case 67: goto L26;
            case 68: goto L24;
            default: goto L22;
        };
    L22:
        throw new IllegalArgumentException("Invalid descriptor: " + r2);
    L24:
        return i;
    L26:
        return c;
    L28:
        return d;
    L30:
        return new aa(9, r2, r3, r4);
    L32:
        return f301b;
    L34:
        return h;
    L36:
        return f;
    L38:
        return f300a;
    L40:
        return e;
    L42:
        return new aa(10, r2, r3 + 1, r4 - 1);
    L44:
        return g;
    L46:
        return new aa(11, r2, r3, r4);
    }

    public static String a(aa r4, aa... r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append('(');
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r5[r2].a(r0);
        r2 = r2 + 1;
        goto L3
    L5:
        r0.append(')');
        r4.a(r0);
        return r0.toString();
    }

    public static String a(Class<?> r2) {
        return r2.getName().replace('.', '/');
    }

    public static String a(Constructor<?> r4) {
        StringBuilder r0 = new StringBuilder();
        r0.append('(');
        Class<?>[] r5 = r4.getParameterTypes();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        a(r5[r2], r0);
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.append(")V").toString();
    }

    public static String a(Method r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append('(');
        Class<?>[] r1 = r5.getParameterTypes();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        a(r1[r3], r0);
        r3 = r3 + 1;
        goto L3
    L5:
        r0.append(')');
        a(r5.getReturnType(), r0);
        return r0.toString();
    }

    private static void a(Class<?> r1, StringBuilder r2) {
    L3:
        if (r1.isArray() == false) goto L6;
        r2.append('[');
        r1 = r1.getComponentType();
        goto L3
    L6:
        if (r1.isPrimitive() == true) goto L8;
        r2.append('L').append(a(r1)).append(';');
        return;
    L8:
        if (r1 != Integer.TYPE) goto L11;
        char r3 = 'I';
    L34:
        r2.append(r3);
        return;
    L11:
        if (r1 != Void.TYPE) goto L14;
        r3 = 'V';
        goto L34
    L14:
        if (r1 != Boolean.TYPE) goto L17;
        r3 = 'Z';
        goto L34
    L17:
        if (r1 != Byte.TYPE) goto L20;
        r3 = 'B';
        goto L34
    L20:
        if (r1 != Character.TYPE) goto L23;
        r3 = 'C';
        goto L34
    L23:
        if (r1 != Short.TYPE) goto L26;
        r3 = 'S';
        goto L34
    L26:
        if (r1 != Double.TYPE) goto L29;
        r3 = 'D';
        goto L34
    L29:
        if (r1 != Float.TYPE) goto L32;
        r3 = 'F';
        goto L34
    L32:
        if (r1 != Long.TYPE) goto L36;
        r3 = 'J';
        goto L34
    L36:
        throw new AssertionError();
    }

    private void a(StringBuilder r3) {
        int r0 = this.j;
        if (r0 != 10) goto L7;
        String r1 = this.k;
        int r2 = this.l - 1;
        int r4 = this.m + 1;
    L5:
        r3.append(r1, r2, r4);
        return;
    L7:
        if (r0 != 12) goto L9;
        r3.append('L').append(this.k, this.l, this.m).append(';');
        return;
    L9:
        r1 = this.k;
        r2 = this.l;
        r4 = this.m;
        goto L5
    }

    public static aa b(String r4) {
        return new aa(11, r4, 0, r4.length());
    }

    public static String b(Class<?> r1) {
        StringBuilder r0 = new StringBuilder();
        a(r1, r0);
        return r0.toString();
    }

    public static aa[] c(String r10) {
        int r0 = 0;
        int r3 = 0;
        int r2 = 1;
    L4:
        if (r10.charAt(r2) == ')') goto L13;
    L6:
        if (r10.charAt(r2) != '[') goto L8;
        r2 = r2 + 1;
        goto L6
    L8:
        int r4 = r2 + 1;
        if (r10.charAt(r2) != 'L') goto L11;
        r2 = Math.max(r4, r10.indexOf(59, r4) + 1);
    L12:
        r3 = r3 + 1;
        goto L4
    L11:
        r2 = r4;
        goto L12
    L13:
        aa[] r5 = new aa[r3];
        int r6 = 1;
    L15:
        if (r10.charAt(r6) == ')') goto L24;
        int r7 = r6;
    L18:
        if (r10.charAt(r7) != '[') goto L20;
        r7 = r7 + 1;
        goto L18
    L20:
        int r9 = r7 + 1;
        if (r10.charAt(r7) != 'L') goto L23;
        r9 = Math.max(r9, r10.indexOf(59, r9) + 1);
    L23:
        r5[r0] = a(r10, r6, r9);
        r0 = r0 + 1;
        r6 = r9;
        goto L15
    L24:
        return r5;
    }

    public static aa d(String r2) {
        return a(r2, e(r2), r2.length());
    }

    static int e(String r4) {
        int r1 = 1;
    L4:
        if (r4.charAt(r1) == ')') goto L13;
    L6:
        if (r4.charAt(r1) != '[') goto L8;
        r1 = r1 + 1;
        goto L6
    L8:
        int r2 = r1 + 1;
        if (r4.charAt(r1) == 'L') goto L10;
        r1 = r2;
        goto L4
    L10:
        r1 = Math.max(r2, r4.indexOf(59, r2) + 1);
        goto L4
    L13:
        return r1 + 1;
    }

    public static int f(String r7) {
        int r0 = 1;
        char r1 = r7.charAt(1);
        int r2 = 1;
        int r3 = 1;
    L4:
        if (r1 == ')') goto L17;
        if (r1 == 'J') goto L15;
        if (r1 == 'D') goto L15;
    L9:
        if (r7.charAt(r2) != '[') goto L11;
        r2 = r2 + 1;
        goto L9
    L11:
        int r4 = r2 + 1;
        if (r7.charAt(r2) != 'L') goto L14;
        r4 = Math.max(r4, r7.indexOf(59, r4) + 1);
    L14:
        r3 = r3 + 1;
        r2 = r4;
    L16:
        r1 = r7.charAt(r2);
    L15:
        r2 = r2 + 1;
        r3 = r3 + 2;
        goto L16
    L17:
        char r8 = r7.charAt(r2 + 1);
        if (r8 == 'V') goto L20;
        if (r8 == 'J') goto L23;
        if (r8 == 'D') goto L23;
    L25:
        return (r3 << 2) | r0;
    L23:
        r0 = 2;
        goto L25
    L20:
        return r3 << 2;
    }

    public static aa getType(Class<?> r1) {
        if (r1.isPrimitive() == false) goto L43;
        if (r1 != Integer.TYPE) goto L9;
        return f;
    L9:
        if (r1 != Void.TYPE) goto L13;
        return f300a;
    L13:
        if (r1 != Boolean.TYPE) goto L17;
        return f301b;
    L17:
        if (r1 != Byte.TYPE) goto L21;
        return d;
    L21:
        if (r1 != Character.TYPE) goto L25;
        return c;
    L25:
        if (r1 != Short.TYPE) goto L29;
        return e;
    L29:
        if (r1 != Double.TYPE) goto L33;
        return i;
    L33:
        if (r1 != Float.TYPE) goto L37;
        return g;
    L37:
        if (r1 != Long.TYPE) goto L41;
        return h;
    L41:
        throw new AssertionError();
    L43:
        return getType(b(r1));
    }

    public static aa getType(String r2) {
        return a(r2, 0, r2.length());
    }

    public static aa getType(Constructor<?> r0) {
        return getType(a(r0));
    }

    public static aa getType(Method r0) {
        return getType(a(r0));
    }

    public int a(int r2) {
        if (r2 == 46) goto L35;
        if (r2 == 79) goto L35;
        switch(this.j) {
            case 0: goto L29;
            case 1: goto L54;
            case 2: goto L54;
            case 3: goto L54;
            case 4: goto L54;
            case 5: goto L54;
            case 6: goto L28;
            case 7: goto L26;
            case 8: goto L24;
            case 9: goto L14;
            case 10: goto L14;
            case 11: goto L12;
            case 12: goto L14;
            default: goto L10;
        };
    L29:
        if (r2 != 172) goto L33;
        return 177;
    L33:
        throw new UnsupportedOperationException();
    L54:
        return r2;
    L10:
        throw new AssertionError();
    L12:
        throw new UnsupportedOperationException();
    L14:
        if (r2 == 21) goto L22;
        if (r2 == 54) goto L22;
        if (r2 == 172) goto L22;
        throw new UnsupportedOperationException();
    L22:
        return r2 + 4;
    L24:
        return r2 + 3;
    L26:
        return r2 + 1;
    L28:
        return r2 + 2;
    L35:
        switch(this.j) {
            case 0: goto L53;
            case 1: goto L51;
            case 2: goto L49;
            case 3: goto L51;
            case 4: goto L47;
            case 5: goto L55;
            case 6: goto L45;
            case 7: goto L43;
            case 8: goto L41;
            case 9: goto L39;
            case 10: goto L39;
            case 11: goto L53;
            case 12: goto L39;
            default: goto L37;
        };
    L55:
        return r2;
    L37:
        throw new AssertionError();
    L39:
        return r2 + 4;
    L41:
        return r2 + 3;
    L43:
        return r2 + 1;
    L45:
        return r2 + 2;
    L47:
        return r2 + 7;
    L49:
        return r2 + 6;
    L51:
        return r2 + 5;
    L53:
        throw new UnsupportedOperationException();
    }

    public aa a() {
        int r0 = f();
        return a(this.k, this.l + r0, this.m);
    }

    public String b() {
        switch(this.j) {
            case 0: goto L29;
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L5;
            case 12: goto L7;
            default: goto L5;
        };
    L8:
        StringBuilder r0 = new StringBuilder(a().b());
        int r2 = f();
    L9:
        if (r2 <= 0) goto L12;
        r0.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        r2 = r2 - 1;
        goto L9
    L12:
        return r0.toString();
    L13:
        return "double";
    L15:
        return "long";
    L17:
        return TypedValues.Custom.S_FLOAT;
    L19:
        return "int";
    L21:
        return "short";
    L23:
        return "byte";
    L25:
        return "char";
    L27:
        return TypedValues.Custom.S_BOOLEAN;
    L29:
        return "void";
    L5:
        throw new AssertionError();
    L7:
        return this.k.substring(this.l, this.m).replace('/', '.');
    }

    public String c() {
        return this.k.substring(this.l, this.m);
    }

    public String d() {
        int r0 = this.j;
        if (r0 != 10) goto L7;
        return this.k.substring(this.l - 1, this.m + 1);
    L7:
        if (r0 != 12) goto L11;
        return 'L' + this.k.substring(this.l, this.m) + ';';
    L11:
        return this.k.substring(this.l, this.m);
    }

    public int e() {
        int r1 = this.j;
        if (r1 != 12) goto L6;
        return 10;
    L6:
        return r1;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, aa.class) == true) goto L8;
        return false;
    L8:
        aa r9 = (aa) ZeusTransformUtils.preCheckCast(r8, aa.class, "com.obric.memorydata.plugin");
        int r0 = this.j;
        int r2 = 10;
        if (r0 != 12) goto L11;
        r0 = 10;
    L11:
        int r5 = r9.j;
        if (r5 == 12) goto L15;
        r2 = r5;
    L15:
        if (r0 == r2) goto L17;
        return false;
    L17:
        int r1 = this.l;
        int r3 = this.m;
        int r4 = r9.l;
        if ((r3 - r1) == (r9.m - r4)) goto L20;
        return false;
    L20:
        if (r1 >= r3) goto L25;
        if (this.k.charAt(r1) != r9.k.charAt(r4)) goto L23;
        r1 = r1 + 1;
        r4 = r4 + 1;
        goto L20
    L23:
        return false;
    L25:
        return true;
    }

    public int f() {
        int r0 = 1;
    L4:
        if (this.k.charAt(this.l + r0) != '[') goto L6;
        r0 = r0 + 1;
        goto L4
    L6:
        return r0;
    }

    public int g() {
        switch(this.j) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L5;
            case 12: goto L8;
            default: goto L5;
        };
    L6:
        return 2;
    L8:
        return 1;
    L10:
        return 0;
    L5:
        throw new AssertionError();
    }

    public int hashCode() {
        int r0 = this.j;
        if (r0 != 12) goto L5;
        int r1 = 10;
    L6:
        int r2 = r1 * 13;
        if (r0 < 9) goto L11;
        int r3 = this.l;
        int r4 = this.m;
    L9:
        if (r3 >= r4) goto L11;
        r2 = (r2 + this.k.charAt(r3)) * 17;
        r3 = r3 + 1;
    L11:
        return r2;
    L5:
        r1 = r0;
        goto L6
    }

    public String toString() {
        return d();
    }
}
