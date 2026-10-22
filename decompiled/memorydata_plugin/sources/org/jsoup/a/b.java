package org.jsoup.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String[] f18233a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f18234b = null;
    private static final Pattern c = null;
    private static final Pattern d = null;
    private static final ThreadLocal<Stack<StringBuilder>> e = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        StringBuilder f18235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f18236b;
        boolean c;

        public a(String r2) {
            this.f18235a = b.a();
            this.c = true;
            this.f18236b = r2;
        }

        public String a() {
            String r0 = b.a(this.f18235a);
            this.f18235a = null;
            return r0;
        }

        public a a(Object r3) {
            org.jsoup.helper.b.a(this.f18235a);
            if (this.c == true) goto L5;
            this.f18235a.append(this.f18236b);
        L5:
            this.f18235a.append(r3);
            this.c = false;
            return this;
        }
    }

    static {
        f18233a = new String[]{"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    "};
        f18234b = Pattern.compile("^/((\\.{1,2}/)+)");
        c = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+-.]*:");
        d = Pattern.compile("[\\x00-\\x1f]*");
        e = new AnonymousClass1();
    }

    public static String a(int r4, int r5) {
        boolean r0 = true;
        int r1 = 0;
        if (r4 < 0) goto L5;
        boolean r2 = true;
    L6:
        org.jsoup.helper.b.a(r2, "width must be >= 0");
        if (r5 >= (-1)) goto L10;
        r0 = false;
    L10:
        org.jsoup.helper.b.a(r0);
        if (r5 == (-1)) goto L13;
        r4 = Math.min(r4, r5);
    L13:
        String[] r6 = f18233a;
        if (r4 < r6.length) goto L16;
        char[] r7 = new char[r4];
    L18:
        if (r1 >= r4) goto L21;
        r7[r1] = ' ';
        r1 = r1 + 1;
        goto L18
    L21:
        return String.valueOf(r7);
    L16:
        return r6[r4];
    L5:
        r2 = false;
        goto L6
    }

    public static String a(String r1, String r2) {
        String r3 = d(r1);
        String r4 = d(r2);
    L5:
        return a(new URL(r3), r4).toExternalForm();
    L7:
        return new URL(r4).toExternalForm();
    L9:
        if (c.matcher(r4).find() == true) goto L15;
        return "";
    L15:
        return r4;
    }

    public static String a(StringBuilder r4) {
        org.jsoup.helper.b.a(r4);
        String r0 = r4.toString();
        if (r4.length() <= 8192) goto L5;
        r4 = new StringBuilder(8192);
    L6:
        Stack r1 = (Stack) ZeusTransformUtils.preCheckCast(e.get(), Stack.class, "com.obric.memorydata.plugin");
        r1.push(r4);
    L8:
        if (r1.size() <= 8) goto L10;
        r1.pop();
        goto L8
    L10:
        return r0;
    L5:
        r4.delete(0, r4.length());
        goto L6
    }

    public static String a(Collection<?> r2, String r3) {
        return a(((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin")).iterator(), r3);
    }

    public static String a(Iterator<?> r2, String r3) {
        Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        if (r4.hasNext() == true) goto L6;
        return "";
    L6:
        String r0 = r4.next().toString();
        if (r4.hasNext() == true) goto L9;
        return r0;
    L9:
        a r1 = new a(r3);
        r1.a(r0);
    L11:
        if (r4.hasNext() == false) goto L14;
        r1.a(r4.next());
        goto L11
    L14:
        return r1.a();
    }

    public static StringBuilder a() {
        Stack r0 = (Stack) ZeusTransformUtils.preCheckCast(e.get(), Stack.class, "com.obric.memorydata.plugin");
        if (r0.empty() == false) goto L6;
        return new StringBuilder(8192);
    L6:
        return (StringBuilder) ZeusTransformUtils.preCheckCast(r0.pop(), StringBuilder.class, "com.obric.memorydata.plugin");
    }

    public static URL a(URL r3, String r4) {
        String r5 = d(r4);
        if (r5.startsWith("?") == false) goto L5;
        r5 = r3.getPath() + r5;
    L5:
        URL r0 = new URL(r3, r5);
        String r6 = f18234b.matcher(r0.getFile()).replaceFirst("/");
        if (r0.getRef() == null) goto L9;
        r6 = r6 + "#" + r0.getRef();
    L9:
        return new URL(r0.getProtocol(), r0.getHost(), r0.getPort(), r6);
    }

    public static void a(StringBuilder r8, String r9, boolean r10) {
        int r0 = r9.length();
        int r2 = 0;
        boolean r3 = false;
        boolean r4 = false;
    L3:
        if (r2 >= r0) goto L15;
        int r5 = r9.codePointAt(r2);
        if (b(r5) == false) goto L12;
        if (r10 == false) goto L8;
        if (r3 == true) goto L8;
    L14:
        r2 = r2 + Character.charCount(r5);
    L8:
        if (r4 == true) goto L14;
        r8.append(' ');
        r4 = true;
        goto L14
    L12:
        if (c(r5) == true) goto L14;
        r8.appendCodePoint(r5);
        r4 = false;
        r3 = true;
        goto L14
    }

    public static boolean a(int r1) {
        if (r1 != 32) goto L5;
    L14:
        return true;
    L5:
        if (r1 == 9) goto L14;
        if (r1 == 10) goto L14;
        if (r1 == 12) goto L14;
        if (r1 == 13) goto L14;
        return false;
    }

    public static boolean a(String r5) {
        if (r5 != null) goto L5;
    L13:
        return true;
    L5:
        if (r5.length() == 0) goto L13;
        int r1 = r5.length();
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L13;
        if (a(r5.codePointAt(r3)) == false) goto L11;
        r3 = r3 + 1;
        goto L8
    L11:
        return false;
    }

    public static boolean a(String r4, String... r5) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r5[r2].equals(r4) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean b(int r1) {
        if (r1 != 32) goto L5;
    L16:
        return true;
    L5:
        if (r1 == 9) goto L16;
        if (r1 == 10) goto L16;
        if (r1 == 12) goto L16;
        if (r1 == 13) goto L16;
        if (r1 == 160) goto L16;
        return false;
    }

    public static boolean b(String r4) {
        if (r4 != null) goto L5;
    L15:
        return false;
    L5:
        if (r4.length() == 0) goto L15;
        int r1 = r4.length();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L13;
        if (Character.isDigit(r4.codePointAt(r2)) == false) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    }

    public static boolean b(String r0, String[] r1) {
        if (Arrays.binarySearch(r1, r0) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static String c(String r2) {
        StringBuilder r0 = a();
        a(r0, r2, false);
        return a(r0);
    }

    public static boolean c(int r1) {
        if (r1 != 8203) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 173) goto L8;
        return false;
    }

    private static String d(String r1) {
        return d.matcher(r1).replaceAll("");
    }
}
