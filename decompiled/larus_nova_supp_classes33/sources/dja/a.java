package dja;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: dja.a$a, reason: collision with other inner class name */
    public static final class C0052a<T> extends a<T> {
        public final String a;
        public final T b;
        public final T c;
        public final KClass<T> d;
        public final gja.a<T> e;
        public final Float f;

        @Override // dja.a
        public final bja.a<T> a() {
            return new bja.a(this.a, this.b, this.c, this.e, this.f, this.d);
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            T r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            T r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            KClass<T> r10 = this.d;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            gja.a<T> r13 = this.e;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            Float r16 = this.f;
            if (r16 == null) goto L26;
            r1 = r16.hashCode();
        L26:
            return r15 + r1;
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "SpringAnimationCommand(property=" + this.a + ", initialValue=" + this.b + ", targetValue=" + this.c + ", valueClass=" + this.d + ", spec=" + this.e + ", initialVelocity=" + this.f + ")";
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0052a) == false) goto L18;
            C0052a r4 = (C0052a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public C0052a(String r2, T r3, T r4, KClass<T> r5, gja.a<T> r6, Float r7) {
            Intrinsics.checkNotNullParameter(r2, "property");
            Intrinsics.checkNotNullParameter(r3, "initialValue");
            Intrinsics.checkNotNullParameter(r4, "targetValue");
            Intrinsics.checkNotNullParameter(r5, "valueClass");
            Intrinsics.checkNotNullParameter(r6, "spec");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class b<T> extends a<T> {
        public final String a;
        public final T b;
        public final T c;
        public final KClass<T> d;
        public final gja.a<T> e;
        public final Float f;

        @Override // dja.a
        public final bja.a<T> a() {
            return new bja.a(this.a, this.b, this.c, this.e, this.f, this.d);
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            T r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            T r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            KClass<T> r10 = this.d;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            gja.a<T> r13 = this.e;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            Float r16 = this.f;
            if (r16 == null) goto L26;
            r1 = r16.hashCode();
        L26:
            return r15 + r1;
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "TweenAnimationCommand(property=" + this.a + ", initialValue=" + this.b + ", targetValue=" + this.c + ", valueClass=" + this.d + ", spec=" + this.e + ", initialVelocity=" + this.f + ")";
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L18;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public b(String r2, T r3, T r4, KClass<T> r5, gja.a<T> r6, Float r7) {
            Intrinsics.checkNotNullParameter(r2, "property");
            Intrinsics.checkNotNullParameter(r3, "initialValue");
            Intrinsics.checkNotNullParameter(r4, "targetValue");
            Intrinsics.checkNotNullParameter(r5, "valueClass");
            Intrinsics.checkNotNullParameter(r6, "spec");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public a() {
    }

    public abstract bja.a<T> a();
}
