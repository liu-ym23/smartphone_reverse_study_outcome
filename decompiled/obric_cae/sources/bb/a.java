package bb;

import he.d;
import he.i;
import le.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: bb.a$a, reason: collision with other inner class name */
    public static final class C0034a<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f3145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T f3146c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b<T> f3147d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final fb.a<T> f3148e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Float f3149f;

        /* JADX WARN: Multi-variable type inference failed */
        public C0034a(String r8, Float r10, Float r11, d r12, gb.b r13, Float r14) {
            i.f(r8, "property");
            i.f(r10, "initialValue");
            i.f(r11, "targetValue");
            this.f3144a = r8;
            this.f3145b = r10;
            this.f3146c = r11;
            this.f3147d = r12;
            this.f3148e = r13;
            this.f3149f = r14;
        }

        @Override // bb.a
        public final ya.a<T> a() {
            return new ya.a(this.f3144a, this.f3145b, this.f3146c, this.f3148e, this.f3149f, this.f3147d);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L4;
            return true;
        L4:
            if ((r8 instanceof C0034a) == false) goto L18;
            C0034a r10 = (C0034a) r8;
            String r11 = r10.f3144a;
            if (i.a(this.f3144a, r11) == true) goto L8;
            return false;
        L8:
            if (i.a(this.f3145b, r10.f3145b) == true) goto L10;
            return false;
        L10:
            if (i.a(this.f3146c, r10.f3146c) == true) goto L12;
            return false;
        L12:
            if (i.a(this.f3147d, r10.f3147d) == true) goto L14;
            return false;
        L14:
            if (i.a(this.f3148e, r10.f3148e) == true) goto L16;
            return false;
        L16:
            if (i.a(this.f3149f, r10.f3149f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            int r8 = 0;
            String r10 = this.f3144a;
            if (r10 == null) goto L5;
            int r11 = r10.hashCode();
        L6:
            int r12 = r11 * 31;
            T r13 = this.f3145b;
            if (r13 == null) goto L9;
            int r14 = r13.hashCode();
        L10:
            int r15 = (r12 + r14) * 31;
            T r16 = this.f3146c;
            if (r16 == null) goto L13;
            int r17 = r16.hashCode();
        L14:
            int r18 = (r15 + r17) * 31;
            b<T> r19 = this.f3147d;
            if (r19 == null) goto L17;
            int r20 = r19.hashCode();
        L18:
            int r21 = (r18 + r20) * 31;
            fb.a<T> r22 = this.f3148e;
            if (r22 == null) goto L21;
            int r23 = r22.hashCode();
        L22:
            int r24 = (r21 + r23) * 31;
            Float r25 = this.f3149f;
            if (r25 == null) goto L26;
            r8 = r25.hashCode();
        L26:
            return r24 + r8;
        L21:
            r23 = 0;
            goto L22
        L17:
            r20 = 0;
            goto L18
        L13:
            r17 = 0;
            goto L14
        L9:
            r14 = 0;
            goto L10
        L5:
            r11 = 0;
            goto L6
        }

        public final String toString() {
            return "SpringAnimationCommand(property=" + this.f3144a + ", initialValue=" + this.f3145b + ", targetValue=" + this.f3146c + ", valueClass=" + this.f3147d + ", spec=" + this.f3148e + ", initialVelocity=" + this.f3149f + ")";
        }
    }

    public a() {
    }

    public abstract ya.a<T> a();
}
