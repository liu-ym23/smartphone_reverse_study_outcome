package com.google.common.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: com.google.common.base.i$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f4301b;
        private b c;
        private boolean d;
        private boolean e;

        /* JADX INFO: renamed from: com.google.common.base.i$a$a, reason: collision with other inner class name */
        private static final class C0192a extends b {
            private C0192a() {
                super(null);
            }

            /* synthetic */ C0192a(AnonymousClass1 r1) {
                this();
            }
        }

        private static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            String f4302a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f4303b;
            b c;

            private b() {
            }

            /* synthetic */ b(AnonymousClass1 r1) {
                this();
            }
        }

        private a(String r3) {
            b r0 = new b(null);
            this.f4301b = r0;
            this.c = r0;
            this.d = false;
            this.e = false;
            this.f4300a = (String) ZeusTransformUtils.preCheckCast(n.a(r3), String.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ a(String r1, AnonymousClass1 r2) {
            this(r1);
        }

        private b a() {
            b r0 = new b(null);
            this.c.c = r0;
            this.c = r0;
            return r0;
        }

        private C0192a b() {
            C0192a r0 = new C0192a(null);
            this.c.c = r0;
            this.c = r0;
            return r0;
        }

        private a b(String r3, Object r4) {
            b r0 = a();
            r0.f4303b = r4;
            r0.f4302a = (String) ZeusTransformUtils.preCheckCast(n.a(r3), String.class, "com.obric.memorydata.plugin");
            return this;
        }

        private static boolean b(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, CharSequence.class) == false) goto L9;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L7;
            return false;
        L7:
            return true;
        L9:
            if (ZeusTransformUtils.instanceOf(r4, Collection.class) == false) goto L13;
            return ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
        L13:
            if (ZeusTransformUtils.instanceOf(r4, Map.class) == false) goto L17;
            return ((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin")).isEmpty();
        L17:
            if (ZeusTransformUtils.instanceOf(r4, java.util.Optional.class) == false) goto L21;
            return !((java.util.Optional) ZeusTransformUtils.preCheckCast(r4, java.util.Optional.class, "com.obric.memorydata.plugin")).isPresent();
        L21:
            if (ZeusTransformUtils.instanceOf(r4, OptionalInt.class) == false) goto L25;
            return !((OptionalInt) ZeusTransformUtils.preCheckCast(r4, OptionalInt.class, "com.obric.memorydata.plugin")).isPresent();
        L25:
            if (ZeusTransformUtils.instanceOf(r4, OptionalLong.class) == false) goto L29;
            return !((OptionalLong) ZeusTransformUtils.preCheckCast(r4, OptionalLong.class, "com.obric.memorydata.plugin")).isPresent();
        L29:
            if (ZeusTransformUtils.instanceOf(r4, OptionalDouble.class) == false) goto L33;
            return !((OptionalDouble) ZeusTransformUtils.preCheckCast(r4, OptionalDouble.class, "com.obric.memorydata.plugin")).isPresent();
        L33:
            if (ZeusTransformUtils.instanceOf(r4, Optional.class) == false) goto L37;
            return !((Optional) ZeusTransformUtils.preCheckCast(r4, Optional.class, "com.obric.memorydata.plugin")).isPresent();
        L37:
            if (r4.getClass().isArray() == true) goto L39;
            return false;
        L39:
            if (Array.getLength(r4) == 0) goto L41;
            return false;
        L41:
            return true;
        }

        private a c(Object r2) {
            a().f4303b = r2;
            return this;
        }

        private a c(String r3, Object r4) {
            C0192a r0 = b();
            r0.f4303b = r4;
            r0.f4302a = (String) ZeusTransformUtils.preCheckCast(n.a(r3), String.class, "com.obric.memorydata.plugin");
            return this;
        }

        public a a(Object r1) {
            return c(r1);
        }

        public a a(String r1, double r2) {
            return c(r1, String.valueOf(r2));
        }

        public a a(String r1, int r2) {
            return c(r1, String.valueOf(r2));
        }

        public a a(String r1, long r2) {
            return c(r1, String.valueOf(r2));
        }

        public a a(String r1, Object r2) {
            return b(r1, r2);
        }

        public String toString() {
            boolean r0 = this.d;
            boolean r1 = this.e;
            StringBuilder r2 = new StringBuilder(32).append(this.f4300a).append('{');
            b r7 = this.f4301b.c;
            String r3 = "";
        L3:
            if (r7 == null) goto L23;
            Object r4 = r7.f4303b;
            if (ZeusTransformUtils.instanceOf(r7, C0192a.class) == true) goto L12;
            if (r4 != null) goto L9;
            if (r0 == false) goto L12;
        L21:
            r7 = r7.c;
            goto L3
        L9:
            if (r1 == false) goto L12;
            if (b(r4) == true) goto L21;
        L12:
            r2.append(r3);
            if (r7.f4302a == null) goto L15;
            r2.append(r7.f4302a).append('=');
        L15:
            if (r4 != null) goto L17;
        L19:
            r2.append(r4);
        L20:
            r3 = ", ";
            goto L21
        L17:
            if (r4.getClass().isArray() == false) goto L19;
            String r5 = Arrays.deepToString(new Object[]{r4});
            r2.append(r5, 1, r5.length() - 1);
            goto L20
        L23:
            return r2.append('}').toString();
        }
    }

    public static a a(Class<?> r2) {
        return new a(r2.getSimpleName(), null);
    }

    public static a a(Object r2) {
        return new a(r2.getClass().getSimpleName(), null);
    }

    public static <T> T a(T r0, T r1) {
        if (r0 == null) goto L4;
        return r0;
    L4:
        Objects.requireNonNull(r1, "Both parameters are null");
        return r1;
    }
}
