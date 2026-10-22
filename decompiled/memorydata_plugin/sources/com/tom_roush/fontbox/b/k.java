package com.tom_roush.fontbox.b;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f15915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f15916b;
    private String c;

    /* JADX INFO: renamed from: com.tom_roush.fontbox.b.k$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface a {
    }

    static abstract class b extends com.tom_roush.fontbox.b.d {
        private int c;
        private a[] d;

        static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f15917a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f15918b;
            private String c;

            a() {
            }

            static /* synthetic */ int a(a r0) {
                return r0.f15918b;
            }

            static /* synthetic */ int a(a r0, int r1) {
                r0.f15917a = r1;
                return r1;
            }

            static /* synthetic */ String a(a r0, String r1) {
                r0.c = r1;
                return r1;
            }

            static /* synthetic */ int b(a r0) {
                return r0.f15917a;
            }

            static /* synthetic */ int b(a r0, int r1) {
                r0.f15918b = r1;
                return r1;
            }

            public String toString() {
                return getClass().getName() + "[code=" + this.f15917a + ", sid=" + this.f15918b + "]";
            }
        }

        b() {
        }

        static /* synthetic */ int a(b r0) {
            return r0.c;
        }

        static /* synthetic */ int a(b r0, int r1) {
            r0.c = r1;
            return r1;
        }

        static /* synthetic */ a[] a(b r0, a[] r1) {
            r0.d = r1;
            return r1;
        }

        static /* synthetic */ a[] b(b r0) {
            return r0.d;
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, a> f15919a;

        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private List<Number> f15920a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private com.tom_roush.fontbox.b.j f15921b;

            private a() {
                this.f15920a = new ArrayList();
                this.f15921b = null;
            }

            /* synthetic */ a(AnonymousClass1 r1) {
                this();
            }

            static /* synthetic */ com.tom_roush.fontbox.b.j a(a r0, com.tom_roush.fontbox.b.j r1) {
                r0.f15921b = r1;
                return r1;
            }

            static /* synthetic */ List a(a r0) {
                return r0.f15920a;
            }

            static /* synthetic */ com.tom_roush.fontbox.b.j b(a r0) {
                return r0.f15921b;
            }

            public int a() {
                return this.f15920a.size();
            }

            public Boolean a(int r2, Boolean r3) {
                Number r1 = (Number) ZeusTransformUtils.preCheckCast(this.f15920a.get(r2), Number.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r1, Integer.class) == false) goto L13;
                int r4 = r1.intValue();
                if (r4 == 0) goto L12;
                if (r4 != 1) goto L13;
                return Boolean.TRUE;
            L12:
                return Boolean.FALSE;
            L13:
                Log.w("PdfBox-Android", "Expected boolean, got " + r1 + ", returning default " + r3);
                return r3;
            }

            public Number a(int r2) {
                return (Number) ZeusTransformUtils.preCheckCast(this.f15920a.get(r2), Number.class, "com.obric.memorydata.plugin");
            }

            public boolean b() {
                return !this.f15920a.isEmpty();
            }

            public List<Number> c() {
                return this.f15920a;
            }

            public List<Number> d() {
                ArrayList r0 = new ArrayList(this.f15920a);
                int r5 = 1;
            L4:
                if (r5 >= r0.size()) goto L6;
                r0.set(r5, Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r0.get(r5 - 1), Number.class, "com.obric.memorydata.plugin")).intValue() + ((Number) ZeusTransformUtils.preCheckCast(r0.get(r5), Number.class, "com.obric.memorydata.plugin")).intValue()));
                r5 = r5 + 1;
                goto L4
            L6:
                return r0;
            }

            public String toString() {
                return getClass().getName() + "[operands=" + this.f15920a + ", operator=" + this.f15921b + "]";
            }
        }

        private c() {
            this.f15919a = new HashMap();
        }

        /* synthetic */ c(AnonymousClass1 r1) {
            this();
        }

        public a a(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(this.f15919a.get(r2), a.class, "com.obric.memorydata.plugin");
        }

        public Boolean a(String r1, boolean r2) {
            a r0 = a(r1);
            if (r0 == null) goto L8;
            if (r0.c().isEmpty() == true) goto L8;
            r2 = r0.a(0, Boolean.valueOf(r2)).booleanValue();
        L8:
            return Boolean.valueOf(r2);
        }

        public Number a(String r1, Number r2) {
            a r0 = a(r1);
            if (r0 != null) goto L5;
            return r2;
        L5:
            if (r0.c().isEmpty() == false) goto L7;
            return r2;
        L7:
            return r0.a(0);
        }

        public List<Number> a(String r3, List<Number> r4) {
            List<Number> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            a r2 = a(r3);
            if (r2 != null) goto L5;
            return r5;
        L5:
            if (r2.c().isEmpty() == false) goto L7;
            return r5;
        L7:
            return r2.c();
        }

        public void a(a r2) {
            if (a.b(r2) == null) goto L6;
            this.f15919a.put(a.b(r2).b(), r2);
            return;
        }

        public List<Number> b(String r3, List<Number> r4) {
            List<Number> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            a r2 = a(r3);
            if (r2 != null) goto L5;
            return r5;
        L5:
            if (r2.c().isEmpty() == false) goto L7;
            return r5;
        L7:
            return r2.d();
        }

        public String toString() {
            return getClass().getName() + "[entries=" + this.f15919a + "]";
        }
    }

    static abstract class d extends com.tom_roush.fontbox.b.b {
        public d(boolean r1) {
            super(r1);
        }
    }

    private static class e extends d {
        public e(int r3) {
            int r0 = 1;
            super(true);
            a(0, 0);
        L3:
            if (r0 > r3) goto L5;
            a(r0, r0);
            r0 = r0 + 1;
            goto L3
        }

        public String toString() {
            return getClass().getName();
        }
    }

    private static class f extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f15922a;

        public f(boolean r1) {
            super(r1);
        }

        static /* synthetic */ int a(f r0, int r1) {
            r0.f15922a = r1;
            return r1;
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.f15922a + "]";
        }
    }

    private static class g extends b {
        private int c;
        private int d;

        private g() {
        }

        /* synthetic */ g(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ int a(g r0) {
            return r0.d;
        }

        static /* synthetic */ int a(g r0, int r1) {
            r0.c = r1;
            return r1;
        }

        static /* synthetic */ int b(g r0, int r1) {
            r0.d = r1;
            return r1;
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.c + ", nCodes=" + this.d + ", supplement=" + Arrays.toString(b.b(this)) + "]";
        }
    }

    private static class h extends s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f15923b;
        private int[] c;

        private h(com.tom_roush.fontbox.b.a r1) {
            super(r1);
        }

        /* synthetic */ h(com.tom_roush.fontbox.b.a r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int a(h r0, int r1) {
            r0.f15923b = r1;
            return r1;
        }

        static /* synthetic */ int[] a(h r0) {
            return r0.c;
        }

        static /* synthetic */ int[] a(h r0, int[] r1) {
            r0.c = r1;
            return r1;
        }

        @Override // com.tom_roush.fontbox.b.s
        public int a(int r2) {
            int[] r1 = this.c;
            if (r2 < r1.length) goto L5;
            return 0;
        L5:
            return r1[r2];
        }

        public String toString() {
            return getClass().getName() + "[fds=" + Arrays.toString(this.c) + "]";
        }
    }

    private static class i extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f15924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<o> f15925b;

        public i(boolean r1) {
            super(r1);
        }

        static /* synthetic */ int a(i r0, int r1) {
            r0.f15924a = r1;
            return r1;
        }

        static /* synthetic */ List a(i r0) {
            return r0.f15925b;
        }

        static /* synthetic */ List a(i r2, List r3) {
            List<o> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            r2.f15925b = r4;
            return r4;
        }

        @Override // com.tom_roush.fontbox.b.b
        public int c(int r5) {
            if (a() == false) goto L12;
            Iterator<o> r0 = this.f15925b.iterator();
        L6:
            if (r0.hasNext() == false) goto L12;
            o r1 = (o) ZeusTransformUtils.preCheckCast(r0.next(), o.class, "com.obric.memorydata.plugin");
            if (r1.a(r5) == false) goto L6;
            return r1.b(r5);
        L12:
            return super.c(r5);
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.f15924a + "]";
        }
    }

    private static class j extends b {
        private int c;
        private int d;

        private j() {
        }

        /* synthetic */ j(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ int a(j r0) {
            return r0.d;
        }

        static /* synthetic */ int a(j r0, int r1) {
            r0.c = r1;
            return r1;
        }

        static /* synthetic */ int b(j r0, int r1) {
            r0.d = r1;
            return r1;
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.c + ", nRanges=" + this.d + ", supplement=" + Arrays.toString(b.b(this)) + "]";
        }
    }

    /* JADX INFO: renamed from: com.tom_roush.fontbox.b.k$k, reason: collision with other inner class name */
    private static class C0848k extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f15926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<o> f15927b;

        public C0848k(boolean r1) {
            super(r1);
        }

        static /* synthetic */ int a(C0848k r0, int r1) {
            r0.f15926a = r1;
            return r1;
        }

        static /* synthetic */ List a(C0848k r0) {
            return r0.f15927b;
        }

        static /* synthetic */ List a(C0848k r2, List r3) {
            List<o> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            r2.f15927b = r4;
            return r4;
        }

        @Override // com.tom_roush.fontbox.b.b
        public int c(int r5) {
            Iterator<o> r0 = this.f15927b.iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            o r1 = (o) ZeusTransformUtils.preCheckCast(r0.next(), o.class, "com.obric.memorydata.plugin");
            if (r1.a(r5) == false) goto L4;
            return r1.b(r5);
        L10:
            return super.c(r5);
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.f15926a + "]";
        }
    }

    private static final class l extends s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f15928b;
        private int c;
        private n[] d;
        private int e;

        private l(com.tom_roush.fontbox.b.a r1) {
            super(r1);
        }

        /* synthetic */ l(com.tom_roush.fontbox.b.a r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ int a(l r0) {
            return r0.c;
        }

        static /* synthetic */ int a(l r0, int r1) {
            r0.f15928b = r1;
            return r1;
        }

        static /* synthetic */ n[] a(l r0, n[] r1) {
            r0.d = r1;
            return r1;
        }

        static /* synthetic */ int b(l r0, int r1) {
            r0.c = r1;
            return r1;
        }

        static /* synthetic */ n[] b(l r0) {
            return r0.d;
        }

        static /* synthetic */ int c(l r0, int r1) {
            r0.e = r1;
            return r1;
        }

        @Override // com.tom_roush.fontbox.b.s
        public int a(int r5) {
            int r1 = 0;
        L4:
            if (r1 >= this.c) goto L20;
            if (n.a(this.d[r1]) > r5) goto L19;
            int r2 = r1 + 1;
            if (r2 >= this.c) goto L15;
            if (n.a(this.d[r2]) <= r5) goto L19;
            n r4 = this.d[r1];
        L13:
            return n.b(r4);
        L15:
            if (this.e <= r5) goto L17;
            r4 = this.d[r1];
            goto L13
        L17:
            return -1;
        L19:
            r1 = r1 + 1;
            goto L4
        L20:
            return 0;
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.f15928b + " nbRanges=" + this.c + ", range3=" + Arrays.toString(this.d) + " sentinel=" + this.e + "]";
        }
    }

    private static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f15929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f15930b;
        private int c;
        private int d;

        private m() {
        }

        /* synthetic */ m(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ int a(m r0, int r1) {
            r0.f15929a = r1;
            return r1;
        }

        static /* synthetic */ int b(m r0, int r1) {
            r0.f15930b = r1;
            return r1;
        }

        static /* synthetic */ int c(m r0, int r1) {
            r0.c = r1;
            return r1;
        }

        static /* synthetic */ int d(m r0, int r1) {
            r0.d = r1;
            return r1;
        }

        public String toString() {
            return getClass().getName() + "[major=" + this.f15929a + ", minor=" + this.f15930b + ", hdrSize=" + this.c + ", offSize=" + this.d + "]";
        }
    }

    private static final class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f15931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f15932b;

        private n() {
        }

        /* synthetic */ n(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ int a(n r0) {
            return r0.f15931a;
        }

        static /* synthetic */ int a(n r0, int r1) {
            r0.f15931a = r1;
            return r1;
        }

        static /* synthetic */ int b(n r0) {
            return r0.f15932b;
        }

        static /* synthetic */ int b(n r0, int r1) {
            r0.f15932b = r1;
            return r1;
        }

        public String toString() {
            return getClass().getName() + "[first=" + this.f15931a + ", fd=" + this.f15932b + "]";
        }
    }

    private static final class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f15933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f15934b;
        private final int c;
        private final int d;

        private o(int r1, int r2, int r3) {
            this.f15933a = r1;
            this.f15934b = r1 + r3;
            this.c = r2;
            this.d = r2 + r3;
        }

        /* synthetic */ o(int r1, int r2, int r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        boolean a(int r2) {
            if (r2 >= this.c) goto L5;
        L7:
            return false;
        L5:
            if (r2 > this.d) goto L7;
            return true;
        }

        int b(int r2) {
            if (a(r2) == true) goto L5;
            return 0;
        L5:
            return this.f15933a + (r2 - this.c);
        }

        public String toString() {
            return getClass().getName() + "[start value=" + this.f15933a + ", end value=" + this.f15934b + ", start mapped-value=" + this.c + ", end mapped-value=" + this.d + "]";
        }
    }

    public k() {
        this.f15915a = null;
    }

    private com.tom_roush.fontbox.b.b a(com.tom_roush.fontbox.b.c r3, int r4, boolean r5) {
        int r0 = r3.a();
        if (r0 == 0) goto L15;
        if (r0 == 1) goto L13;
        if (r0 != 2) goto L11;
        return c(r3, r0, r4, r5);
    L11:
        throw new IOException("Incorrect charset format " + r0);
    L13:
        return b(r3, r0, r4, r5);
    L15:
        return a(r3, r0, r4, r5);
    }

    private com.tom_roush.fontbox.b.c a(com.tom_roush.fontbox.b.c r8, byte[] r9) {
        short r7 = r8.i();
        r8.i();
        r8.i();
        r8.i();
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L10;
        String r1 = a(r8);
        b(r8);
        long r2 = b(r8);
        long r4 = b(r8);
        if ("CFF ".equals(r1) == true) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return new com.tom_roush.fontbox.b.c(Arrays.copyOfRange(r9, (int) r2, (int) (r2 + r4)));
    L10:
        throw new IOException("CFF tag not found in this OpenType font.");
    }

    private com.tom_roush.fontbox.b.d a(com.tom_roush.fontbox.b.c r4, com.tom_roush.fontbox.b.b r5) {
        int r0 = r4.a();
        int r1 = r0 & 127;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L9;
        return b(r4, r5, r0);
    L9:
        throw new IOException("Invalid encoding base format " + r1);
    L11:
        return a(r4, r5, r0);
    }

    private com.tom_roush.fontbox.b.h a(com.tom_roush.fontbox.b.c r18, String r19, byte[] r20) {
        c r3 = g(new com.tom_roush.fontbox.b.c(r20));
        if (r3.a("SyntheticBase") != null) goto L64;
        if (r3.a("ROS") == null) goto L7;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L17;
        com.tom_roush.fontbox.b.a r10 = new com.tom_roush.fontbox.b.a();
        c.a r4 = r3.a("ROS");
        if (r4 == null) goto L16;
        if (r4.a() < 3) goto L16;
        r10.c(a(r4.a(0).intValue()));
        r10.d(a(r4.a(1).intValue()));
        r10.a(r4.a(2).intValue());
        com.tom_roush.fontbox.b.h r11 = r10;
    L18:
        this.c = r19;
        r11.e(r19);
        r11.a("version", a(r3, "version"));
        r11.a("Notice", a(r3, "Notice"));
        r11.a(ExifInterface.TAG_COPYRIGHT, a(r3, ExifInterface.TAG_COPYRIGHT));
        r11.a("FullName", a(r3, "FullName"));
        r11.a("FamilyName", a(r3, "FamilyName"));
        r11.a("Weight", a(r3, "Weight"));
        r11.a("isFixedPitch", r3.a("isFixedPitch", false));
        r11.a("ItalicAngle", r3.a("ItalicAngle", 0));
        r11.a("UnderlinePosition", r3.a("UnderlinePosition", -100));
        r11.a("UnderlineThickness", r3.a("UnderlineThickness", 50));
        r11.a("PaintType", r3.a("PaintType", 0));
        r11.a("CharstringType", r3.a("CharstringType", 2));
        r11.a("FontMatrix", r3.a("FontMatrix", Arrays.asList(new Number[]{Double.valueOf(0.001d), Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(0.001d), Double.valueOf(0.0d), Double.valueOf(0.0d)})));
        r11.a("UniqueID", r3.a("UniqueID", null));
        r11.a("FontBBox", r3.a("FontBBox", Arrays.asList(new Number[]{0, 0, 0, 0})));
        r11.a("StrokeWidth", r3.a("StrokeWidth", 0));
        r11.a("XUID", r3.a("XUID", null));
        c.a r2 = r3.a("CharStrings");
        if (r2 == null) goto L62;
        if (r2.b() == false) goto L62;
        r18.b(r2.a(0).intValue());
        byte[][] r6 = e(r18);
        if (r6 == null) goto L60;
        c.a r14 = r3.a("charset");
        if (r14 != null) goto L27;
    L39:
        if (r5 == false) goto L41;
        com.tom_roush.fontbox.b.b r15 = new e(r6.length);
    L42:
        r11.a(r15);
        r11.d = r6;
        if (r5 == false) goto L57;
        a(r18, r3, (com.tom_roush.fontbox.b.a) ZeusTransformUtils.preCheckCast(r11, com.tom_roush.fontbox.b.a.class, "com.obric.memorydata.plugin"), r6.length);
        List<Map<String, Object>> r1 = ((com.tom_roush.fontbox.b.a) ZeusTransformUtils.preCheckCast(r11, com.tom_roush.fontbox.b.a.class, "com.obric.memorydata.plugin")).g();
        if (r1.isEmpty() == false) goto L47;
    L49:
        List<Number> r7 = null;
    L50:
        List<Number> r8 = r3.a("FontMatrix", null);
        if (r8 != null) goto L55;
        if (r7 == null) goto L54;
        r11.a("FontMatrix", r7);
    L58:
        return r11;
    L54:
        r11.a("FontMatrix", r3.a("FontMatrix", Arrays.asList(new Number[]{Double.valueOf(0.001d), Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(0.001d), Double.valueOf(0.0d), Double.valueOf(0.0d)})));
        goto L58
    L55:
        if (r7 == null) goto L58;
        a(r8, r7);
        goto L58
    L47:
        if (((Map) ZeusTransformUtils.preCheckCast(r1.get(0), Map.class, "com.obric.memorydata.plugin")).containsKey("FontMatrix") == false) goto L49;
        r7 = (List) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r1.get(0), Map.class, "com.obric.memorydata.plugin")).get("FontMatrix"), List.class, "com.obric.memorydata.plugin");
        goto L50
    L57:
        a(r18, r3, (com.tom_roush.fontbox.b.n) ZeusTransformUtils.preCheckCast(r11, com.tom_roush.fontbox.b.n.class, "com.obric.memorydata.plugin"), r15);
    L41:
        r15 = com.tom_roush.fontbox.b.i.b();
        goto L42
    L27:
        if (r14.b() == false) goto L39;
        int r16 = r14.a(0).intValue();
        if (r5 == true) goto L32;
        if (r16 == 0) goto L41;
    L32:
        if (r5 == true) goto L35;
        if (r16 != 1) goto L35;
        r15 = com.tom_roush.fontbox.b.e.b();
    L35:
        if (r5 == true) goto L38;
        if (r16 != 2) goto L38;
        r15 = com.tom_roush.fontbox.b.g.b();
    L38:
        r18.b(r16);
        r15 = a(r18, r6.length, r5);
        goto L42
    L60:
        throw new IOException("CharStringsIndex is missing");
    L62:
        throw new IOException("CharStrings is missing or empty");
    L16:
        throw new IOException("ROS entry must have 3 elements");
    L17:
        r11 = new com.tom_roush.fontbox.b.n();
        goto L18
    L7:
        r5 = false;
        goto L9
    L64:
        throw new IOException("Synthetic Fonts are not supported");
    }

    private static c a(com.tom_roush.fontbox.b.c r2, int r3) {
        c r0 = new c(null);
        int r1 = r2.f() + r3;
    L4:
        if (r2.f() >= r1) goto L6;
        r0.a(h(r2));
        goto L4
    L6:
        return r0;
    }

    private f a(com.tom_roush.fontbox.b.c r4, int r5, int r6, boolean r7) {
        f r0 = new f(r7);
        f.a(r0, r5);
        if (r7 == false) goto L5;
        r0.a(0, 0);
    L6:
        int r8 = 1;
    L7:
        if (r8 >= r6) goto L13;
        int r1 = r4.d();
        if (r7 == false) goto L11;
        r0.a(r8, r1);
    L12:
        r8 = r8 + 1;
        goto L7
    L11:
        r0.a(r8, r1, a(r1));
        goto L12
    L13:
        return r0;
    L5:
        r0.a(0, 0, ".notdef");
        goto L6
    }

    private g a(com.tom_roush.fontbox.b.c r6, com.tom_roush.fontbox.b.b r7, int r8) {
        g r0 = new g(null);
        g.a(r0, r8);
        g.b(r0, r6.a());
        r0.a(0, 0, ".notdef");
        int r1 = 1;
    L4:
        if (r1 > g.a(r0)) goto L7;
        int r2 = r6.a();
        int r3 = r7.a(r1);
        r0.a(r2, r3, a(r3));
        r1 = r1 + 1;
        goto L4
    L7:
        if ((r8 & 128) == 0) goto L9;
        a(r6, r0);
    L9:
        return r0;
    }

    private static h a(com.tom_roush.fontbox.b.c r2, int r3, int r4, com.tom_roush.fontbox.b.a r5) {
        h r0 = new h(r5, null);
        h.a(r0, r3);
        h.a(r0, new int[r4]);
        int r6 = 0;
    L4:
        if (r6 >= h.a(r0).length) goto L6;
        h.a(r0)[r6] = r2.a();
        r6 = r6 + 1;
        goto L4
    L6:
        return r0;
    }

    private static s a(com.tom_roush.fontbox.b.c r2, int r3, com.tom_roush.fontbox.b.a r4) {
        int r0 = r2.a();
        if (r0 == 0) goto L11;
        if (r0 != 3) goto L9;
        return b(r2, r0, r3, r4);
    L9:
        throw new IllegalArgumentException();
    L11:
        return a(r2, r0, r3, r4);
    }

    private String a(int r3) {
        if (r3 < 0) goto L16;
        if (r3 <= 390) goto L6;
        String[] r2 = this.f15915a;
        if (r2 == null) goto L14;
        int r0 = r3 - 391;
        if (r0 >= r2.length) goto L14;
        return r2[r0];
    L14:
        return "SID" + r3;
    L6:
        return com.tom_roush.fontbox.b.m.a(r3);
    L16:
        throw new IOException("Invalid negative index when reading a string");
    }

    private static String a(com.tom_roush.fontbox.b.c r2) {
        return new String(r2.d(4), com.tom_roush.fontbox.g.b.f16026a);
    }

    private String a(c r1, String r2) {
        c.a r3 = r1.a(r2);
        if (r3 != null) goto L5;
    L7:
        return null;
    L5:
        if (r3.b() == false) goto L7;
        return a(r3.a(0).intValue());
    }

    private Map<String, Object> a(c r5) {
        LinkedHashMap r4 = new LinkedHashMap(17);
        r4.put("BlueValues", r5.b("BlueValues", null));
        r4.put("OtherBlues", r5.b("OtherBlues", null));
        r4.put("FamilyBlues", r5.b("FamilyBlues", null));
        r4.put("FamilyOtherBlues", r5.b("FamilyOtherBlues", null));
        r4.put("BlueScale", r5.a("BlueScale", Double.valueOf(0.039625d)));
        r4.put("BlueShift", r5.a("BlueShift", 7));
        r4.put("BlueFuzz", r5.a("BlueFuzz", 1));
        r4.put("StdHW", r5.a("StdHW", null));
        r4.put("StdVW", r5.a("StdVW", null));
        r4.put("StemSnapH", r5.b("StemSnapH", null));
        r4.put("StemSnapV", r5.b("StemSnapV", null));
        r4.put("ForceBold", r5.a("ForceBold", false));
        r4.put("LanguageGroup", r5.a("LanguageGroup", 0));
        r4.put("ExpansionFactor", r5.a("ExpansionFactor", Double.valueOf(0.06d)));
        r4.put("initialRandomSeed", r5.a("initialRandomSeed", 0));
        r4.put("defaultWidthX", r5.a("defaultWidthX", 0));
        r4.put("nominalWidthX", r5.a("nominalWidthX", 0));
        return r4;
    }

    private void a(com.tom_roush.fontbox.b.c r5, b r6) {
        b.a(r6, r5.a());
        b.a(r6, new b.a[b.a(r6)]);
        int r0 = 0;
    L4:
        if (r0 >= b.b(r6).length) goto L6;
        b.a r1 = new b.a();
        b.a.a(r1, r5.a());
        b.a.b(r1, r5.d());
        b.a.a(r1, a(b.a.a(r1)));
        b.b(r6)[r0] = r1;
        r6.a(b.a.b(r1), b.a.a(r1), a(b.a.a(r1)));
        r0 = r0 + 1;
        goto L4
    }

    private void a(com.tom_roush.fontbox.b.c r17, c r18, com.tom_roush.fontbox.b.a r19, int r20) {
        c.a r4 = r18.a("FDArray");
        if (r4 == null) goto L33;
        if (r4.b() == false) goto L33;
        r17.b(r4.a(0).intValue());
        byte[][] r5 = e(r17);
        if (r5 == null) goto L31;
        LinkedList r6 = new LinkedList();
        LinkedList r7 = new LinkedList();
        int r8 = r5.length;
        int r9 = 0;
    L9:
        if (r9 >= r8) goto L22;
        c r10 = g(new com.tom_roush.fontbox.b.c(r5[r9]));
        c.a r11 = r10.a(com.tom_roush.pdfbox.pdmodel.a.d.i.l);
        if (r11 == null) goto L21;
        if (r11.a() < 2) goto L21;
        LinkedHashMap r12 = new LinkedHashMap(4);
        r12.put("FontName", a(r10, "FontName"));
        r12.put("FontType", r10.a("FontType", 0));
        r12.put("FontBBox", r10.a("FontBBox", null));
        r12.put("FontMatrix", r10.a("FontMatrix", null));
        r7.add(r12);
        int r13 = r11.a(1).intValue();
        r17.b(r13);
        c r14 = a(r17, r11.a(0).intValue());
        Map<String, Object> r15 = a(r14);
        r6.add(r15);
        Number r16 = r14.a("Subrs", 0);
        if (ZeusTransformUtils.instanceOf(r16, Integer.class) == false) goto L19;
        if (((Integer) ZeusTransformUtils.preCheckCast(r16, Integer.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L19;
        r17.b(r13 + ((Integer) ZeusTransformUtils.preCheckCast(r16, Integer.class, "com.obric.memorydata.plugin")).intValue());
        r15.put("Subrs", e(r17));
    L19:
        r9 = r9 + 1;
    L21:
        throw new IOException("Font DICT invalid without \"Private\" entry");
    L22:
        c.a r0 = r18.a("FDSelect");
        if (r0 == null) goto L29;
        if (r0.b() == false) goto L29;
        r17.b(r0.a(0).intValue());
        s r1 = a(r17, r20, r19);
        r19.a(r7);
        r19.b(r6);
        r19.a(r1);
        return;
    L29:
        throw new IOException("FDSelect is missing or empty");
    L31:
        throw new IOException("Font dict index is missing for a CIDKeyed Font");
    L33:
        throw new IOException("FDArray is missing for a CIDKeyed Font.");
    }

    private void a(com.tom_roush.fontbox.b.c r6, c r7, com.tom_roush.fontbox.b.n r8, com.tom_roush.fontbox.b.b r9) {
        c.a r0 = r7.a("Encoding");
        if (r0 != null) goto L5;
    L7:
        int r1 = 0;
    L9:
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L12;
        r6.b(r1);
        com.tom_roush.fontbox.b.d r10 = a(r6, r9);
    L14:
        r8.a(r10);
        c.a r11 = r7.a(com.tom_roush.pdfbox.pdmodel.a.d.i.l);
        if (r11 == null) goto L29;
        if (r11.a() < 2) goto L29;
        int r12 = r11.a(1).intValue();
        r6.b(r12);
        c r13 = a(r6, r11.a(0).intValue());
        Iterator<Map.Entry<String, Object>> r5 = a(r13).entrySet().iterator();
    L20:
        if (r5.hasNext() == false) goto L22;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r8.b((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), r2.getValue());
        goto L20
    L22:
        Number r14 = r13.a("Subrs", 0);
        if (ZeusTransformUtils.instanceOf(r14, Integer.class) == true) goto L25;
        return;
    L25:
        if (((Integer) ZeusTransformUtils.preCheckCast(r14, Integer.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L32;
        r6.b(r12 + ((Integer) ZeusTransformUtils.preCheckCast(r14, Integer.class, "com.obric.memorydata.plugin")).intValue());
        r8.b("Subrs", e(r6));
        return;
    L32:
        return;
    L29:
        throw new IOException("Private dictionary entry missing for font " + r8.f15908a);
    L12:
        r10 = com.tom_roush.fontbox.b.f.a();
        goto L14
    L13:
        r10 = com.tom_roush.fontbox.b.l.a();
        goto L14
    L5:
        if (r0.b() == false) goto L7;
        r1 = r0.a(0).intValue();
        goto L9
    }

    private void a(List<Number> r34, List<Number> r35) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.memorydata.plugin");
        double r4 = ((Number) ZeusTransformUtils.preCheckCast(r0.get(0), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        double r7 = ((Number) ZeusTransformUtils.preCheckCast(r0.get(1), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        double r10 = ((Number) ZeusTransformUtils.preCheckCast(r0.get(2), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        double r13 = ((Number) ZeusTransformUtils.preCheckCast(r0.get(3), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        double r15 = ((Number) ZeusTransformUtils.preCheckCast(r0.get(4), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        double r17 = ((Number) ZeusTransformUtils.preCheckCast(r0.get(5), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        double r19 = ((Number) ZeusTransformUtils.preCheckCast(r2.get(0), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        double r21 = ((Number) ZeusTransformUtils.preCheckCast(r2.get(1), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        double r23 = ((Number) ZeusTransformUtils.preCheckCast(r2.get(2), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        double r25 = ((Number) ZeusTransformUtils.preCheckCast(r2.get(3), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        double r27 = ((Number) ZeusTransformUtils.preCheckCast(r2.get(4), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        double r1 = ((Number) ZeusTransformUtils.preCheckCast(r2.get(5), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        r0.set(0, Double.valueOf((r4 * r19) + (r7 * r23)));
        r0.set(1, Double.valueOf((r4 * r21) + (r7 * r13)));
        r0.set(2, Double.valueOf((r10 * r19) + (r13 * r23)));
        r0.set(3, Double.valueOf((r10 * r21) + (r13 * r25)));
        r0.set(4, Double.valueOf(((r19 * r15) + (r23 * r17)) + r27));
        r0.set(5, Double.valueOf(((r15 * r21) + (r17 * r25)) + r1));
    }

    private static long b(com.tom_roush.fontbox.b.c r2) {
        return r2.b() | (r2.b() << 16);
    }

    private static com.tom_roush.fontbox.b.j b(com.tom_roush.fontbox.b.c r0, int r1) {
        return com.tom_roush.fontbox.b.j.a(c(r0, r1));
    }

    private i b(com.tom_roush.fontbox.b.c r10, int r11, int r12, boolean r13) {
        i r0 = new i(r13);
        i.a(r0, r11);
        if (r13 == false) goto L5;
        r0.a(0, 0);
        i.a(r0, new ArrayList());
    L6:
        int r2 = 1;
    L7:
        if (r2 >= r12) goto L16;
        int r3 = r10.d();
        int r4 = r10.a();
        if (r13 == true) goto L14;
        int r5 = 0;
    L12:
        if (r5 >= (r4 + 1)) goto L15;
        int r6 = r3 + r5;
        r0.a(r2 + r5, r6, a(r6));
        r5 = r5 + 1;
    L15:
        r2 = (r2 + r4) + 1;
        goto L7
    L14:
        i.a(r0).add(new o(r2, r3, r4, null));
        goto L15
    L16:
        return r0;
    L5:
        r0.a(0, 0, ".notdef");
        goto L6
    }

    private j b(com.tom_roush.fontbox.b.c r11, com.tom_roush.fontbox.b.b r12, int r13) {
        j r0 = new j(null);
        j.a(r0, r13);
        j.b(r0, r11.a());
        r0.a(0, 0, ".notdef");
        int r2 = 1;
        int r3 = 0;
    L4:
        if (r3 >= j.a(r0)) goto L10;
        int r4 = r11.a();
        int r5 = r11.a();
        int r6 = 0;
    L6:
        if (r6 > r5) goto L8;
        int r7 = r12.a(r2);
        r0.a(r4 + r6, r7, a(r7));
        r2 = r2 + 1;
        r6 = r6 + 1;
        goto L6
    L8:
        r3 = r3 + 1;
        goto L4
    L10:
        if ((r13 & 128) == 0) goto L12;
        a(r11, r0);
    L12:
        return r0;
    }

    private static l b(com.tom_roush.fontbox.b.c r2, int r3, int r4, com.tom_roush.fontbox.b.a r5) {
        AnonymousClass1 r0 = null;
        l r6 = new l(r5, r0);
        l.a(r6, r3);
        l.b(r6, r2.b());
        l.a(r6, new n[l.a(r6)]);
        int r7 = 0;
    L4:
        if (r7 >= l.a(r6)) goto L6;
        n r8 = new n(r0);
        n.a(r8, r2.b());
        n.b(r8, r2.a());
        l.b(r6)[r7] = r8;
        r7 = r7 + 1;
        goto L4
    L6:
        l.c(r6, r2.b());
        return r6;
    }

    private static com.tom_roush.fontbox.b.j.a c(com.tom_roush.fontbox.b.c r1, int r2) {
        if (r2 != 12) goto L7;
        return new com.tom_roush.fontbox.b.j.a(r2, r1.h());
    L7:
        return new com.tom_roush.fontbox.b.j.a(r2);
    }

    private C0848k c(com.tom_roush.fontbox.b.c r10, int r11, int r12, boolean r13) {
        C0848k r0 = new C0848k(r13);
        C0848k.a(r0, r11);
        if (r13 == false) goto L5;
        r0.a(0, 0);
        C0848k.a(r0, new ArrayList());
    L6:
        int r2 = 1;
    L7:
        if (r2 >= r12) goto L16;
        int r3 = r10.d();
        int r4 = r10.b();
        if (r13 == true) goto L14;
        int r5 = 0;
    L12:
        if (r5 >= (r4 + 1)) goto L15;
        int r6 = r3 + r5;
        r0.a(r2 + r5, r6, a(r6));
        r5 = r5 + 1;
    L15:
        r2 = (r2 + r4) + 1;
        goto L7
    L14:
        C0848k.a(r0).add(new o(r2, r3, r4, null));
        goto L15
    L16:
        return r0;
    L5:
        r0.a(0, 0, ".notdef");
        goto L6
    }

    private static m c(com.tom_roush.fontbox.b.c r2) {
        m r0 = new m(null);
        m.a(r0, r2.a());
        m.b(r0, r2.a());
        m.c(r0, r2.a());
        m.d(r0, r2.c());
        return r0;
    }

    private static Integer d(com.tom_roush.fontbox.b.c r2, int r3) {
        if (r3 != 28) goto L7;
        return Integer.valueOf(r2.i());
    L7:
        if (r3 != 29) goto L11;
        return Integer.valueOf(r2.k());
    L11:
        if (r3 < 32) goto L17;
        if (r3 > 246) goto L17;
        return Integer.valueOf(r3 + NetError.ERR_TEMPORARILY_THROTTLED);
    L17:
        if (r3 < 247) goto L23;
        if (r3 > 250) goto L23;
        int r4 = (r3 - 247) * 256;
        return Integer.valueOf((r4 + r2.h()) + 108);
    L23:
        if (r3 < 251) goto L29;
        if (r3 > 254) goto L29;
        int r5 = (-(r3 - 251)) * 256;
        return Integer.valueOf((r5 - r2.h()) + NetError.ERR_ADDRESS_INVALID);
    L29:
        throw new IllegalArgumentException();
    }

    private static int[] d(com.tom_roush.fontbox.b.c r6) {
        int r0 = r6.b();
        if (r0 != 0) goto L6;
        return null;
    L6:
        int r1 = r6.c();
        int[] r2 = new int[r0 + 1];
        int r3 = 0;
    L7:
        if (r3 > r0) goto L13;
        int r4 = r6.a(r1);
        if (r4 > r6.l()) goto L12;
        r2[r3] = r4;
        r3 = r3 + 1;
        goto L7
    L12:
        throw new IOException("illegal offset value " + r4 + " in CFF font");
    L13:
        return r2;
    }

    private static byte[][] e(com.tom_roush.fontbox.b.c r7) {
        int[] r0 = d(r7);
        if (r0 != null) goto L6;
        return null;
    L6:
        int r1 = r0.length - 1;
        byte[][] r2 = new byte[r1][];
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        int r4 = r3 + 1;
        r2[r3] = r7.d(r0[r4] - r0[r3]);
        r3 = r4;
        goto L7
    L9:
        return r2;
    }

    private static String[] f(com.tom_roush.fontbox.b.c r8) {
        int[] r0 = d(r8);
        if (r0 != null) goto L6;
        return null;
    L6:
        int r1 = r0.length - 1;
        String[] r2 = new String[r1];
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L13;
        int r4 = r3 + 1;
        int r5 = r0[r4] - r0[r3];
        if (r5 < 0) goto L12;
        r2[r3] = new String(r8.d(r5), com.tom_roush.fontbox.g.b.f16026a);
        r3 = r4;
        goto L7
    L12:
        throw new IOException("Negative index data length + " + r5 + " at " + r3 + ": offsets[" + r4 + "]=" + r0[r4] + ", offsets[" + r3 + "]=" + r0[r3]);
    L13:
        return r2;
    }

    private static c g(com.tom_roush.fontbox.b.c r2) {
        c r0 = new c(null);
    L4:
        if (r2.e() == false) goto L6;
        r0.a(h(r2));
        goto L4
    L6:
        return r0;
    }

    private static c.a h(com.tom_roush.fontbox.b.c r3) {
        c.a r0 = new c.a(null);
    L3:
        int r1 = r3.h();
        if (r1 < 0) goto L10;
        if (r1 > 21) goto L10;
        c.a.a(r0, b(r3, r1));
        return r0;
    L10:
        if (r1 == 28) goto L24;
        if (r1 == 29) goto L24;
        if (r1 == 30) goto L16;
        if (r1 < 32) goto L23;
        if (r1 <= 254) goto L24;
    L23:
        throw new IOException("invalid DICT data b0 byte: " + r1);
    L16:
        c.a.a(r0).add(i(r3));
    L24:
        c.a.a(r0).add(d(r3, r1));
        goto L3
    }

    private static Double i(com.tom_roush.fontbox.b.c r12) {
        StringBuilder r0 = new StringBuilder();
        int[] r2 = new int[2];
        boolean r4 = false;
        boolean r5 = false;
        boolean r6 = false;
    L3:
        if (r4 == true) goto L24;
        int r7 = r12.h();
        r2[0] = r7 / 16;
        r2[1] = r7 % 16;
        int r8 = 0;
    L5:
        if (r8 >= 2) goto L3;
        int r9 = r2[r8];
        switch(r9) {
            case 0: goto L22;
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            case 4: goto L22;
            case 5: goto L22;
            case 6: goto L22;
            case 7: goto L22;
            case 8: goto L22;
            case 9: goto L22;
            case 10: goto L20;
            case 11: goto L15;
            case 12: goto L12;
            case 13: goto L23;
            case 14: goto L11;
            case 15: goto L10;
            default: goto L9;
        };
    L10:
        r4 = true;
        goto L23
    L11:
        String r10 = "-";
    L21:
        r0.append(r10);
        goto L23
    L12:
        if (r6 == false) goto L14;
        StringBuilder r11 = new StringBuilder();
        String r13 = "duplicate 'E-' ignored after ";
    L17:
        Log.w("PdfBox-Android", r11.append(r13).append(r0).toString());
        goto L23
    L14:
        String r14 = "E-";
    L19:
        r0.append(r14);
        r5 = true;
        r6 = true;
        goto L23
    L15:
        if (r6 == false) goto L18;
        r11 = new StringBuilder();
        r13 = "duplicate 'E' ignored after ";
        goto L17
    L18:
        r14 = ExifInterface.LONGITUDE_EAST;
        goto L19
    L20:
        r10 = ".";
        goto L21
    L22:
        r0.append(r9);
        r5 = false;
    L23:
        r8 = r8 + 1;
        goto L5
    L9:
        throw new IllegalArgumentException("illegal nibble " + r9);
    L24:
        if (r5 == false) goto L27;
        r0.append("0");
    L27:
        if (r0.length() == 0) goto L29;
        return Double.valueOf(r0.toString());
    L32:
        e = move-exception;
        throw new IOException(e);
    L29:
        return Double.valueOf(0.0d);
    }

    public List<com.tom_roush.fontbox.b.h> a(byte[] r8) {
        com.tom_roush.fontbox.b.c r0 = new com.tom_roush.fontbox.b.c(r8);
        String r1 = a(r0);
        int r3 = 0;
        if ("OTTO".equals(r1) == false) goto L6;
        r0 = a(r0, r8);
    L10:
        c(r0);
        String[] r9 = f(r0);
        if (r9 == null) goto L18;
        byte[][] r2 = e(r0);
        this.f15915a = f(r0);
        byte[][] r4 = e(r0);
        ArrayList r5 = new ArrayList(r9.length);
    L14:
        if (r3 >= r9.length) goto L16;
        com.tom_roush.fontbox.b.h r6 = a(r0, r9[r3], r2[r3]);
        r6.a(r4);
        r6.a(this.f15916b);
        r5.add(r6);
        r3 = r3 + 1;
        goto L14
    L16:
        return r5;
    L18:
        throw new IOException("Name index missing in CFF font");
    L6:
        if ("ttcf".equals(r1) == true) goto L22;
        if ("\u0000\u0001\u0000\u0000".equals(r1) == true) goto L20;
        r0.b(0);
        goto L10
    L20:
        throw new IOException("OpenType fonts containing a true type font are not supported.");
    L22:
        throw new IOException("True Type Collection fonts are not supported.");
    }

    public List<com.tom_roush.fontbox.b.h> a(byte[] r3, a r4) {
        this.f15916b = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        return a(r3);
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + this.c + "]";
    }
}
