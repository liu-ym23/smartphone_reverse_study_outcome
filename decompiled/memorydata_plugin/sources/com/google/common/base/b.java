package com.google.common.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements o<Character> {

    private static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f4288a = null;

        static {
            f4288a = new a();
        }

        a() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.b
        public boolean c(char r1) {
            if (r1 > 127) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.b$b, reason: collision with other inner class name */
    static abstract class AbstractC0191b extends b {
        AbstractC0191b() {
        }

        @Override // com.google.common.base.b, com.google.common.base.o
        @Deprecated
        public /* synthetic */ boolean apply(Character r3) {
            return super.a((Character) ZeusTransformUtils.preCheckCast(r3, Character.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.base.b
        public b b() {
            return new h(this);
        }

        @Override // com.google.common.base.b, java.util.function.Predicate
        public /* synthetic */ Predicate negate() {
            return b();
        }
    }

    private static final class c extends AbstractC0191b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f4289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char f4290b;

        c(char r2, char r3) {
            if (r3 < r2) goto L5;
            boolean r0 = true;
        L6:
            n.a(r0);
            this.f4289a = r2;
            this.f4290b = r3;
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.google.common.base.b
        public boolean c(char r2) {
            if (this.f4289a <= r2) goto L5;
        L7:
            return false;
        L5:
            if (r2 > this.f4290b) goto L7;
            return true;
        }

        @Override // com.google.common.base.b
        public String toString() {
            return "CharMatcher.inRange('" + b.d(this.f4289a) + "', '" + b.d(this.f4290b) + "')";
        }
    }

    private static final class d extends AbstractC0191b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f4291a;

        d(char r1) {
            this.f4291a = r1;
        }

        @Override // com.google.common.base.b.AbstractC0191b, com.google.common.base.b
        public b b() {
            return b(this.f4291a);
        }

        @Override // com.google.common.base.b
        public boolean c(char r1) {
            if (r1 != this.f4291a) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.base.b.AbstractC0191b, com.google.common.base.b, java.util.function.Predicate
        public /* synthetic */ Predicate negate() {
            return b();
        }

        @Override // com.google.common.base.b
        public String toString() {
            return "CharMatcher.is('" + b.d(this.f4291a) + "')";
        }
    }

    private static final class e extends AbstractC0191b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f4292a;

        e(char r1) {
            this.f4292a = r1;
        }

        @Override // com.google.common.base.b.AbstractC0191b, com.google.common.base.b
        public b b() {
            return a(this.f4292a);
        }

        @Override // com.google.common.base.b
        public boolean c(char r1) {
            if (r1 == this.f4292a) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.base.b.AbstractC0191b, com.google.common.base.b, java.util.function.Predicate
        public /* synthetic */ Predicate negate() {
            return b();
        }

        @Override // com.google.common.base.b
        public String toString() {
            return "CharMatcher.isNot('" + b.d(this.f4292a) + "')";
        }
    }

    static abstract class f extends AbstractC0191b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4293a;

        f(String r3) {
            this.f4293a = (String) ZeusTransformUtils.preCheckCast(n.a(r3), String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.b
        public final String toString() {
            return this.f4293a;
        }
    }

    private static class g extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f4294a;

        g(b r3) {
            this.f4294a = (b) ZeusTransformUtils.preCheckCast(n.a(r3), b.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.b
        public boolean a(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this.f4294a.b(r4);
        }

        @Override // com.google.common.base.b, com.google.common.base.o
        @Deprecated
        public /* synthetic */ boolean apply(Character r3) {
            return super.a((Character) ZeusTransformUtils.preCheckCast(r3, Character.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.base.b
        public b b() {
            return this.f4294a;
        }

        @Override // com.google.common.base.b
        public boolean b(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this.f4294a.a(r4);
        }

        @Override // com.google.common.base.b
        public boolean c(char r1) {
            return !this.f4294a.c(r1);
        }

        @Override // com.google.common.base.b, java.util.function.Predicate
        public /* synthetic */ Predicate negate() {
            return b();
        }

        @Override // com.google.common.base.b
        public String toString() {
            return this.f4294a + ".negate()";
        }
    }

    static class h extends g {
        h(b r1) {
            super(r1);
        }
    }

    public b() {
    }

    public static b a() {
        return a.f4288a;
    }

    public static b a(char r1) {
        return new d(r1);
    }

    public static b a(char r1, char r2) {
        return new c(r1, r2);
    }

    public static b b(char r1) {
        return new e(r1);
    }

    static /* synthetic */ String d(char r0) {
        return e(r0);
    }

    private static String e(char r6) {
        char[] r0 = {'\\', 'u', 0, 0, 0, 0};
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L7;
        r0[5 - r1] = "0123456789ABCDEF".charAt(r6 & 15);
        r6 = (char) (r6 >> 4);
        r1 = r1 + 1;
        goto L4
    L7:
        return String.copyValueOf(r0);
    }

    public int a(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r5.length();
        n.b(r4, r0);
    L3:
        if (r4 >= r0) goto L8;
        if (c(r5.charAt(r4)) == true) goto L6;
        r4 = r4 + 1;
        goto L3
    L6:
        return r4;
    L8:
        return -1;
    }

    public boolean a(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r5.length() - 1;
    L3:
        if (r0 < 0) goto L9;
        if (c(r5.charAt(r0)) == false) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    @Deprecated
    public boolean a(Character r1) {
        return c(r1.charValue());
    }

    @Override // com.google.common.base.o
    @Deprecated
    public /* synthetic */ boolean apply(Character r3) {
        return a((Character) ZeusTransformUtils.preCheckCast(r3, Character.class, "com.obric.memorydata.plugin"));
    }

    public b b() {
        return new g(this);
    }

    public boolean b(CharSequence r3) {
        if (c((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin")) != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public int c(CharSequence r3) {
        return a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), 0);
    }

    public abstract boolean c(char r1);

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate negate() {
        return b();
    }

    public String toString() {
        return super.toString();
    }
}
