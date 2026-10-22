package l8;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: l8.a$a, reason: collision with other inner class name */
    public static final class C0233a<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f10911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final T f10912c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final KClass<T> f10913d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final o8.a<T> f10914e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Float f10915f;

        public C0233a(String r10, T r11, T r12, KClass<T> r13, o8.a<T> r14, Float r15) {
            Intrinsics.checkNotNullParameter(r10, "property");
            Intrinsics.checkNotNullParameter(r11, "initialValue");
            Intrinsics.checkNotNullParameter(r12, "targetValue");
            Intrinsics.checkNotNullParameter(r13, "valueClass");
            Intrinsics.checkNotNullParameter(r14, "spec");
            super(null);
            this.f10910a = r10;
            this.f10911b = r11;
            this.f10912c = r12;
            this.f10913d = r13;
            this.f10914e = r14;
            this.f10915f = r15;
        }

        @Override // l8.a
        public j8.a<T> a() {
            return new j8.a(c(), b(), d(), this.f10914e, this.f10915f, e(), 0.0f, 64, null);
        }

        public T b() {
            return this.f10911b;
        }

        public String c() {
            return this.f10910a;
        }

        public T d() {
            return this.f10912c;
        }

        public KClass<T> e() {
            return this.f10913d;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof C0233a) == false) goto L18;
            C0233a r11 = (C0233a) r10;
            if (Intrinsics.areEqual(c(), r11.c()) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(b(), r11.b()) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(d(), r11.d()) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(e(), r11.e()) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f10914e, r11.f10914e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f10915f, r11.f10915f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            String r10 = c();
            int r11 = 0;
            if (r10 == null) goto L5;
            int r12 = r10.hashCode();
        L6:
            int r13 = r12 * 31;
            T r14 = b();
            if (r14 == null) goto L9;
            int r15 = r14.hashCode();
        L10:
            int r16 = (r13 + r15) * 31;
            T r17 = d();
            if (r17 == null) goto L13;
            int r18 = r17.hashCode();
        L14:
            int r19 = (r16 + r18) * 31;
            KClass<T> r20 = e();
            if (r20 == null) goto L17;
            int r21 = r20.hashCode();
        L18:
            int r22 = (r19 + r21) * 31;
            o8.a<T> r23 = this.f10914e;
            if (r23 == null) goto L21;
            int r24 = r23.hashCode();
        L22:
            int r25 = (r22 + r24) * 31;
            Float r26 = this.f10915f;
            if (r26 == null) goto L26;
            r11 = r26.hashCode();
        L26:
            return r25 + r11;
        L21:
            r24 = 0;
            goto L22
        L17:
            r21 = 0;
            goto L18
        L13:
            r18 = 0;
            goto L14
        L9:
            r15 = 0;
            goto L10
        L5:
            r12 = 0;
            goto L6
        }

        public String toString() {
            return "SpringAnimationCommand(property=" + c() + ", initialValue=" + b() + ", targetValue=" + d() + ", valueClass=" + e() + ", spec=" + this.f10914e + ", initialVelocity=" + this.f10915f + ")";
        }
    }

    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker r10) {
        this();
    }

    public abstract j8.a<T> a();
}
