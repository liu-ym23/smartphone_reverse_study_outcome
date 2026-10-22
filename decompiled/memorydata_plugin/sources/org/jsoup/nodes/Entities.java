package org.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes7.dex */
public class Entities {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f18253a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<String, String> f18254b = null;
    private static final Document.OutputSettings c = null;

    /* JADX INFO: renamed from: org.jsoup.nodes.Entities$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f18255a = null;

        static {
            int[] r0 = new int[CoreCharset.values().length];
            f18255a = r0;
            r0[CoreCharset.ascii.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f18255a[CoreCharset.utf.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static final enum CoreCharset extends Enum<CoreCharset> {
        private static final /* synthetic */ CoreCharset[] $VALUES = null;
        public static final CoreCharset ascii = null;
        public static final CoreCharset fallback = null;
        public static final CoreCharset utf = null;

        private static /* synthetic */ CoreCharset[] $values() {
            return new CoreCharset[]{ascii, utf, fallback};
        }

        static {
            ascii = new CoreCharset("ascii", 0);
            utf = new CoreCharset("utf", 1);
            fallback = new CoreCharset("fallback", 2);
            $VALUES = $values();
        }

        private CoreCharset(String r1, int r2) {
            super(r1, r2);
        }

        static CoreCharset byName(String r1) {
            if (r1.equals("US-ASCII") == false) goto L7;
            return ascii;
        L7:
            if (r1.startsWith("UTF-") == false) goto L11;
            return utf;
        L11:
            return fallback;
        }

        public static CoreCharset valueOf(String r2) {
            return (CoreCharset) ZeusTransformUtils.preCheckCast(Enum.valueOf(CoreCharset.class, r2), CoreCharset.class, "com.obric.memorydata.plugin");
        }

        public static CoreCharset[] values() {
            return (CoreCharset[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CoreCharset[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum EscapeMode extends Enum<EscapeMode> {
        private static final /* synthetic */ EscapeMode[] $VALUES = null;
        public static final EscapeMode base = null;
        public static final EscapeMode extended = null;
        public static final EscapeMode xhtml = null;
        private int[] codeKeys;
        private int[] codeVals;
        private String[] nameKeys;
        private String[] nameVals;

        private static /* synthetic */ EscapeMode[] $values() {
            return new EscapeMode[]{xhtml, base, extended};
        }

        static {
            xhtml = new EscapeMode("xhtml", 0, g.f18262a, 4);
            base = new EscapeMode("base", 1, g.f18263b, 106);
            extended = new EscapeMode("extended", 2, g.c, 2125);
            $VALUES = $values();
        }

        private EscapeMode(String r1, int r2, String r3, int r4) {
            super(r1, r2);
            Entities.a(this, r3, r4);
        }

        static /* synthetic */ String[] access$100(EscapeMode r0) {
            return r0.nameKeys;
        }

        static /* synthetic */ String[] access$102(EscapeMode r0, String[] r1) {
            r0.nameKeys = r1;
            return r1;
        }

        static /* synthetic */ int[] access$200(EscapeMode r0) {
            return r0.codeVals;
        }

        static /* synthetic */ int[] access$202(EscapeMode r0, int[] r1) {
            r0.codeVals = r1;
            return r1;
        }

        static /* synthetic */ int[] access$300(EscapeMode r0) {
            return r0.codeKeys;
        }

        static /* synthetic */ int[] access$302(EscapeMode r0, int[] r1) {
            r0.codeKeys = r1;
            return r1;
        }

        static /* synthetic */ String[] access$400(EscapeMode r0) {
            return r0.nameVals;
        }

        static /* synthetic */ String[] access$402(EscapeMode r0, String[] r1) {
            r0.nameVals = r1;
            return r1;
        }

        private int size() {
            return this.nameKeys.length;
        }

        public static EscapeMode valueOf(String r2) {
            return (EscapeMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(EscapeMode.class, r2), EscapeMode.class, "com.obric.memorydata.plugin");
        }

        public static EscapeMode[] values() {
            return (EscapeMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EscapeMode[].class, "com.obric.memorydata.plugin");
        }

        int codepointForName(String r2) {
            int r3 = Arrays.binarySearch(this.nameKeys, r2);
            if (r3 >= 0) goto L7;
            return -1;
        L7:
            return this.codeVals[r3];
        }

        String nameForCodepoint(int r4) {
            int r0 = Arrays.binarySearch(this.codeKeys, r4);
            if (r0 < 0) goto L11;
            String[] r1 = this.nameVals;
            if (r0 >= (r1.length - 1)) goto L10;
            int r2 = r0 + 1;
            if (this.codeKeys[r2] != r4) goto L10;
            return r1[r2];
        L10:
            return r1[r0];
        L11:
            return "";
        }
    }

    static {
        f18253a = new char[]{',', ';'};
        f18254b = new HashMap();
        c = new Document.OutputSettings();
    }

    public static int a(String r3, int[] r4) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(f18254b.get(r3), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r4[0] = r0.codePointAt(0);
        r4[1] = r0.codePointAt(1);
        return 2;
    L6:
        int r5 = EscapeMode.extended.codepointForName(r3);
        if (r5 == (-1)) goto L10;
        r4[0] = r5;
        return 1;
    L10:
        return 0;
    }

    static void a(Appendable r16, String r17, Document.OutputSettings r18, boolean r19, boolean r20, boolean r21, boolean r22) {
        Appendable r0 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r16, Appendable.class, "com.obric.memorydata.plugin");
        EscapeMode r1 = r18.a();
        CharsetEncoder r2 = r18.c();
        CoreCharset r4 = r18.f18247a;
        int r5 = r17.length();
        int r7 = 0;
        boolean r8 = false;
        boolean r9 = false;
        boolean r10 = false;
    L3:
        if (r7 >= r5) goto L63;
        int r12 = r17.codePointAt(r7);
        if (r20 == false) goto L21;
        if (org.jsoup.a.b.a(r12) == false) goto L16;
        if (r21 == false) goto L11;
        if (r9 == true) goto L11;
    L62:
        r7 = r7 + Character.charCount(r12);
    L11:
        if (r10 == true) goto L62;
        if (r22 == false) goto L15;
        r8 = true;
        goto L62
    L15:
        r0.append(' ');
        r10 = true;
        goto L62
    L16:
        if (r8 == false) goto L18;
        r0.append(' ');
        r8 = false;
        r10 = false;
    L19:
        r9 = true;
        goto L21
    L18:
        r10 = false;
    L21:
        if (r12 >= 65536) goto L59;
        char r14 = (char) r12;
        if (r14 != '\t') goto L25;
    L58:
        r0.append(r14);
        goto L62
    L25:
        if (r14 == '\n') goto L58;
        if (r14 == '\r') goto L58;
        if (r14 != '\"') goto L31;
        if (r19 == false) goto L58;
        String r13 = "&quot;";
    L55:
        r0.append(r13);
        goto L62
    L31:
        if (r14 != '&') goto L33;
        r13 = "&amp;";
        goto L55
    L33:
        if (r14 != '<') goto L35;
        if (r19 == true) goto L50;
    L53:
        r13 = "&lt;";
        goto L55
    L50:
        if (r1 == EscapeMode.xhtml) goto L53;
        if (r18.d() != Document.OutputSettings.Syntax.xml) goto L58;
    L35:
        if (r14 != '>') goto L37;
        if (r19 == true) goto L58;
        r13 = "&gt;";
        goto L55
    L37:
        if (r14 == 160) goto L43;
        if (r14 >= ' ') goto L40;
    L41:
        a(r0, r1, r12);
        goto L62
    L40:
        if (a(r4, r14, r2) == true) goto L58;
    L43:
        if (r1 == EscapeMode.xhtml) goto L45;
        r13 = "&nbsp;";
        goto L55
    L45:
        r13 = "&#xa0;";
        goto L55
    L59:
        r13 = new String(Character.toChars(r12));
        if (r2.canEncode(r13) == false) goto L41;
    }

    private static void a(Appendable r2, EscapeMode r3, int r4) {
        Appendable r5 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r2, Appendable.class, "com.obric.memorydata.plugin");
        String r6 = r3.nameForCodepoint(r4);
        if ("".equals(r6) == true) goto L5;
        Appendable r7 = r5.append(Typography.amp);
    L6:
        r7.append(r6).append(';');
        return;
    L5:
        r7 = r5.append("&#x");
        r6 = Integer.toHexString(r4);
        goto L6
    }

    static /* synthetic */ void a(EscapeMode r0, String r1, int r2) {
        b(r0, r1, r2);
    }

    public static boolean a(String r1) {
        if (EscapeMode.extended.codepointForName(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean a(CoreCharset r2, char r3, CharsetEncoder r4) {
        int r5 = AnonymousClass1.f18255a[r2.ordinal()];
        if (r5 == 1) goto L10;
        if (r5 != 2) goto L7;
        return true;
    L7:
        return r4.canEncode(r3);
    L10:
        if (r3 < 128) goto L14;
        return false;
    L14:
        return true;
    }

    private static void b(EscapeMode r10, String r11, int r12) {
        EscapeMode.access$102(r10, new String[r12]);
        EscapeMode.access$202(r10, new int[r12]);
        EscapeMode.access$302(r10, new int[r12]);
        EscapeMode.access$402(r10, new String[r12]);
        org.jsoup.parser.a r0 = new org.jsoup.parser.a(r11);
        boolean r13 = false;
        int r1 = 0;
    L21:
    L18:
        th = move-exception;
        r0.a();
        throw th;
    L4:
        if (r0.g() == true) goto L13;
        String r2 = r0.b('=');     // Catch: Throwable -> L18
        r0.k();     // Catch: Throwable -> L18
        int r4 = Integer.parseInt(r0.a(f18253a), 36);     // Catch: Throwable -> L18
        char r6 = r0.h();     // Catch: Throwable -> L18
        r0.k();     // Catch: Throwable -> L18
        if (r6 != ',') goto L8;
        int r7 = Integer.parseInt(r0.b(';'), 36);     // Catch: Throwable -> L18
        r0.k();     // Catch: Throwable -> L18
    L9:
        int r5 = Integer.parseInt(r0.b(Typography.amp), 36);     // Catch: Throwable -> L18
        r0.k();     // Catch: Throwable -> L18
        EscapeMode.access$100(r10)[r1] = r2;     // Catch: Throwable -> L18
        EscapeMode.access$200(r10)[r1] = r4;     // Catch: Throwable -> L18
        EscapeMode.access$300(r10)[r5] = r4;     // Catch: Throwable -> L18
        EscapeMode.access$400(r10)[r5] = r2;     // Catch: Throwable -> L18
        if (r7 == (-1)) goto L12;
        f18254b.put(r2, new String(new int[]{r4, r7}, 0, 2));     // Catch: Throwable -> L18
    L12:
        r1 = r1 + 1;     // Catch: Throwable -> L18
        goto L21
    L8:
        r7 = -1;
        goto L9
    L13:
        if (r1 != r12) goto L15;
        r13 = true;
    L15:
        org.jsoup.helper.b.a(r13, "Unexpected count of entities loaded");     // Catch: Throwable -> L18
        r0.a();
    }

    public static boolean b(String r1) {
        if (EscapeMode.base.codepointForName(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }
}
