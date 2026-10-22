package ae;

import ge.p;
import he.i;
import he.j;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements f, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f.b f349b;

    public static final class a extends j implements p<String, f.b, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f350a = null;

        static {
            f350a = new a();
        }

        public a() {
            super(2);
        }

        @Override // ge.p
        public final String invoke(String r8, f.b r10) {
            String r11 = r8;
            f.b r12 = r10;
            i.f(r11, "acc");
            i.f(r12, "element");
            if (r11.length() != 0) goto L5;
            boolean r13 = true;
        L6:
            if (r13 == false) goto L9;
            return r12.toString();
        L9:
            return r11 + ", " + r12;
        L5:
            r13 = false;
            goto L6
        }
    }

    public c(f.b r8, f r10) {
        i.f(r10, "left");
        i.f(r8, "element");
        this.f348a = r10;
        this.f349b = r8;
    }

    @Override // ae.f
    public final <R> R B(R r8, p<? super R, ? super f.b, ? extends R> r10) {
        i.f(r10, "operation");
        return r10.invoke((Object) this.f348a.B(r8, r10), this.f349b);
    }

    @Override // ae.f
    public final f C(f r8) {
        return f.a.a(this, r8);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L4;
    L29:
        return true;
    L4:
        if ((r8 instanceof c) == false) goto L35;
        c r10 = (c) r8;
        r10.getClass();
        int r11 = 2;
        c r12 = r10;
        int r13 = 2;
    L6:
        f r14 = r12.f348a;
        if ((r14 instanceof c) == false) goto L9;
        r12 = (c) r14;
    L10:
        if (r12 == null) goto L11;
        r13 = r13 + 1;
        goto L6
    L11:
        c r15 = this;
    L12:
        f r16 = r15.f348a;
        if ((r16 instanceof c) == false) goto L15;
        r15 = (c) r16;
    L16:
        if (r15 == null) goto L17;
        r11 = r11 + 1;
        goto L12
    L17:
        if (r13 != r11) goto L36;
    L18:
        f.b r17 = this.f349b;
        if (i.a(r10.q0(r17.getKey()), r17) == false) goto L20;
        f r18 = this.f348a;
        if ((r18 instanceof c) == false) goto L24;
        c this = (c) r18;
        goto L18
    L24:
        i.d(r18, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        f.b r19 = (f.b) r18;
        boolean r20 = i.a(r10.q0(r19.getKey()), r19);
    L25:
        if (r20 == true) goto L29;
        return false;
    L20:
        r20 = false;
        goto L25
    L36:
        return false;
    L15:
        r15 = null;
        goto L16
    L9:
        r12 = null;
        goto L10
    L35:
        return false;
    }

    @Override // ae.f
    public final f h0(f.c<?> r8) {
        i.f(r8, "key");
        f.b r10 = this.f349b;
        f.b r11 = r10.q0(r8);
        f r12 = this.f348a;
        if (r11 == null) goto L5;
        return r12;
    L5:
        f r13 = r12.h0(r8);
        if (r13 != r12) goto L9;
        return this;
    L9:
        if (r13 != g.f354a) goto L12;
        return r10;
    L12:
        return new c(r10, r13);
    }

    public final int hashCode() {
        int r8 = this.f348a.hashCode();
        return this.f349b.hashCode() + r8;
    }

    @Override // ae.f
    public final <E extends f.b> E q0(f.c<E> r8) {
        i.f(r8, "key");
    L3:
        E r10 = (E) this.f349b.q0(r8);
        if (r10 != null) goto L5;
        f r11 = this.f348a;
        if ((r11 instanceof c) == false) goto L10;
        c this = (c) r11;
        goto L3
    L10:
        return (E) r11.q0(r8);
    L5:
        return r10;
    }

    public final String toString() {
        return "[" + ((String) B("", a.f350a)) + ']';
    }
}
