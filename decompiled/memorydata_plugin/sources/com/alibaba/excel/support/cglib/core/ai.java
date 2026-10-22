package com.alibaba.excel.support.cglib.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f376a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f377b = null;

    static {
        HashMap r0 = new HashMap();
        f376a = r0;
        HashMap r1 = new HashMap();
        f377b = r1;
        r0.put("void", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        r0.put("byte", "B");
        r0.put("char", "C");
        r0.put("double", com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b);
        r0.put(TypedValues.Custom.S_FLOAT, "F");
        r0.put("int", "I");
        r0.put("long", "J");
        r0.put("short", "S");
        r0.put(TypedValues.Custom.S_BOOLEAN, "Z");
        h.a(r0, r1);
    }

    public static int a(double r2) {
        if (r2 != 0.0d) goto L7;
        return 14;
    L7:
        if (r2 != 1.0d) goto L10;
        return 15;
    L10:
        return -1;
    }

    public static int a(float r1) {
        if (r1 != 0.0f) goto L7;
        return 11;
    L7:
        if (r1 != 1.0f) goto L11;
        return 12;
    L11:
        if (r1 != 2.0f) goto L14;
        return 13;
    L14:
        return -1;
    }

    public static int a(long r2) {
        if (r2 != 0) goto L7;
        return 9;
    L7:
        if (r2 != 1) goto L10;
        return 10;
    L10:
        return -1;
    }

    public static String a(com.alibaba.excel.support.asm.aa r0) {
        return a(b(r0));
    }

    public static String a(String r2) {
        int r0 = r2.lastIndexOf(46);
        if (r0 >= 0) goto L6;
        return "";
    L6:
        return r2.substring(0, r0);
    }

    private static List a(String r2, int r3, int r4) {
        ArrayList r0 = new ArrayList(5);
    L3:
        int r1 = r2.indexOf(44, r3);
        if (r1 < 0) goto L5;
        r0.add(g(r2.substring(r3, r1).trim()));
        r3 = r1 + 1;
        goto L3
    L5:
        r0.add(g(r2.substring(r3, r4).trim()));
        return r0;
    }

    public static boolean a(int r0) {
        if ((r0 & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static com.alibaba.excel.support.asm.aa[] a(com.alibaba.excel.support.asm.aa[] r3, com.alibaba.excel.support.asm.aa r4) {
        if (r3 != null) goto L7;
        return new com.alibaba.excel.support.asm.aa[]{r4};
    L7:
        if (Arrays.asList(r3).contains(r4) == false) goto L9;
        return r3;
    L9:
        com.alibaba.excel.support.asm.aa[] r0 = new com.alibaba.excel.support.asm.aa[r3.length + 1];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        r0[r3.length] = r4;
        return r0;
    }

    public static com.alibaba.excel.support.asm.aa[] a(Class[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        com.alibaba.excel.support.asm.aa[] r0 = new com.alibaba.excel.support.asm.aa[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L9;
        r0[r1] = com.alibaba.excel.support.asm.aa.getType(r3[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    public static com.alibaba.excel.support.asm.aa[] a(String[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        com.alibaba.excel.support.asm.aa[] r0 = new com.alibaba.excel.support.asm.aa[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L9;
        r0[r1] = b(r3[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    public static String[] a(com.alibaba.excel.support.asm.aa[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        String[] r0 = new String[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L9;
        r0[r1] = r3[r1].c();
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    public static com.alibaba.excel.support.asm.aa b(String r2) {
        return com.alibaba.excel.support.asm.aa.getType(com.tom_roush.pdfbox.pdmodel.a.d.i.u + r2 + ";");
    }

    public static ag b(com.alibaba.excel.support.asm.aa[] r3) {
        StringBuffer r0 = new StringBuffer();
        r0.append("(");
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L6;
        r0.append(r3[r1].d());
        r1 = r1 + 1;
        goto L4
    L6:
        r0.append(")");
        r0.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        return new ag("<init>", r0.toString());
    }

    public static String b(com.alibaba.excel.support.asm.aa r2) {
        if (f(r2) == false) goto L7;
        return (String) ZeusTransformUtils.preCheckCast(f377b.get(r2.d()), String.class, "com.obric.memorydata.plugin");
    L7:
        if (d(r2) == false) goto L11;
        return b(e(r2)) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L11:
        return r2.b();
    }

    public static boolean b(int r0) {
        if ((r0 & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static com.alibaba.excel.support.asm.aa c(com.alibaba.excel.support.asm.aa r1) {
        switch(r1.e()) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        return r1;
    L6:
        return i.t;
    L8:
        return i.v;
    L10:
        return i.u;
    L12:
        return i.w;
    L14:
        return i.x;
    L16:
        return i.y;
    L18:
        return i.r;
    L20:
        return i.s;
    }

    public static ag c(String r7) {
        int r0 = r7.indexOf(32);
        int r2 = r7.indexOf(40, r0);
        int r4 = r7.indexOf(41, r2);
        String r5 = r7.substring(0, r0);
        String r1 = r7.substring(r0 + 1, r2);
        StringBuffer r6 = new StringBuffer();
        r6.append('(');
        Iterator r8 = a(r7, r2 + 1, r4).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r6.append(r8.next());
        goto L4
    L6:
        r6.append(')');
        r6.append(g(r5));
        return new ag(r1, r6.toString());
    }

    public static boolean c(int r0) {
        if ((r0 & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static com.alibaba.excel.support.asm.aa d(String r0) {
        return com.alibaba.excel.support.asm.aa.getType(g(r0));
    }

    public static boolean d(int r1) {
        if ((r1 & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean d(com.alibaba.excel.support.asm.aa r1) {
        if (r1.e() != 9) goto L5;
        return true;
    L5:
        return false;
    }

    public static com.alibaba.excel.support.asm.aa e(com.alibaba.excel.support.asm.aa r3) {
        if (d(r3) == false) goto L7;
        return com.alibaba.excel.support.asm.aa.getType(r3.d().substring(1));
    L7:
        throw new IllegalArgumentException("Type " + r3 + " is not an array");
    }

    public static ag e(String r2) {
        return c("void <init>(" + r2 + ")");
    }

    public static boolean e(int r0) {
        if ((r0 & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static String f(String r5) {
        StringBuffer r0 = new StringBuffer();
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L29;
        char r3 = r5.charAt(r2);
        if (r3 != '$') goto L7;
        String r4 = "$24";
    L26:
        r0.append(r4);
    L27:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r3 != ';') goto L9;
        r4 = "$3B";
        goto L26
    L9:
        if (r3 != '[') goto L11;
        r4 = "$5B";
        goto L26
    L11:
        if (r3 != '(') goto L13;
        r4 = "$28";
        goto L26
    L13:
        if (r3 != ')') goto L15;
        r4 = "$29";
        goto L26
    L15:
        if (r3 != '.') goto L17;
        r4 = "$2E";
        goto L26
    L17:
        if (r3 == '/') goto L19;
        r0.append(r3);
        goto L27
    L19:
        r4 = "$2F";
        goto L26
    L29:
        return r0.toString();
    }

    public static boolean f(int r0) {
        if ((r0 & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean f(com.alibaba.excel.support.asm.aa r1) {
        int r2 = r1.e();
        if (r2 != 9) goto L5;
        return false;
    L5:
        if (r2 == 10) goto L10;
        return true;
    L10:
        return false;
    }

    public static String g(com.alibaba.excel.support.asm.aa r2) {
        if (d(r2) == false) goto L7;
        return r2.d().replace('/', '.');
    L7:
        return b(r2);
    }

    private static String g(String r5) {
        if (r5.equals("") == false) goto L5;
        return r5;
    L5:
        String r0 = (String) ZeusTransformUtils.preCheckCast(f376a.get(r5), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        return r0;
    L9:
        if (r5.indexOf(46) < 0) goto L11;
        StringBuffer r1 = new StringBuffer();
        int r3 = 0;
    L13:
        r3 = r5.indexOf(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, r3) + 1;
        if (r3 <= 0) goto L16;
        r1.append('[');
        goto L13
    L16:
        r1.append('L').append(r5.substring(0, r5.length() - (r1.length() * 2)).replace('.', '/')).append(';');
        return r1.toString();
    L11:
        return g("java.lang." + r5);
    }

    public static boolean g(int r0) {
        if ((r0 & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static com.alibaba.excel.support.asm.aa getType(String r3) {
        return com.alibaba.excel.support.asm.aa.getType(com.tom_roush.pdfbox.pdmodel.a.d.i.u + r3.replace('.', '/') + ";");
    }

    public static int h(int r0) {
        switch(r0) {
            case -1: goto L17;
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L3;
        };
    L3:
        return -1;
    L5:
        return 8;
    L7:
        return 7;
    L9:
        return 6;
    L11:
        return 5;
    L13:
        return 4;
    L15:
        return 3;
    L17:
        return 2;
    }

    public static int h(com.alibaba.excel.support.asm.aa r0) {
        switch(r0.e()) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        return -1;
    L6:
        return 7;
    L8:
        return 11;
    L10:
        return 6;
    L12:
        return 10;
    L14:
        return 9;
    L16:
        return 8;
    L18:
        return 5;
    L20:
        return 4;
    }
}
