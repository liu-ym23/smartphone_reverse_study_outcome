package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class ai extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f3471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final d[] f3472b;

    static final class a extends al {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final char f3473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.ctc.wstx.util.h[] f3474b;
        int c;
        int d;

        public a(char r2, com.ctc.wstx.util.h[] r3) {
            this.c = 0;
            this.d = 0;
            this.f3473a = r2;
            this.f3474b = r3;
        }

        private String a(int r3) {
            return "expected element <" + this.f3474b[r3] + "> in sequence (" + a(this.f3474b) + ")";
        }

        static final String a(com.ctc.wstx.util.h[] r4) {
            StringBuilder r0 = new StringBuilder();
            int r1 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            if (r2 <= 0) goto L6;
            r0.append(", ");
        L6:
            r0.append(r4[r2].toString());
            r2 = r2 + 1;
            goto L3
        L8:
            return r0.toString();
        }

        @Override // com.ctc.wstx.d.al
        public al a() {
            return new a(this.f3473a, this.f3474b);
        }

        @Override // com.ctc.wstx.d.al
        public String a(com.ctc.wstx.util.h r5) {
            int r0 = this.d;
            if (r0 != 0) goto L13;
            if (this.c != 1) goto L13;
            char r2 = this.f3473a;
            if (r2 == '?') goto L11;
            if (r2 != ' ') goto L13;
        L11:
            return "was not expecting any more elements in the sequence (" + a(this.f3474b) + ")";
        L13:
            if (r5.equals(this.f3474b[r0]) == false) goto L15;
            int r6 = this.d + 1;
            this.d = r6;
            if (r6 != this.f3474b.length) goto L21;
            this.c++;
            this.d = 0;
            return null;
        L21:
            return null;
        L15:
            return a(this.d);
        }

        @Override // com.ctc.wstx.d.al
        public String b() {
            if (this.d == 0) goto L7;
            StringBuilder r3 = new StringBuilder().append(a(this.d));
            String r0 = "; got end element";
        L6:
            return r3.append(r0).toString();
        L7:
            char r1 = this.f3473a;
            if (r1 == ' ') goto L20;
            if (r1 != '?') goto L12;
        L18:
            return null;
        L12:
            if (r1 == '*') goto L18;
            if (r1 == '+') goto L20;
            throw new IllegalStateException("Internal error");
        L20:
            if (this.c <= 0) goto L22;
            return null;
        L22:
            r3 = new StringBuilder().append("Expected sequence (").append(a(this.f3474b));
            r0 = "); got end element";
            goto L6
        }
    }

    public ai(boolean r1, char r2, d[] r3) {
        super(r2);
        this.f3471a = r1;
        this.f3472b = r3;
    }

    private af a(d[] r4, int r5, int r6) {
        int r0 = r6 - r5;
        if (r0 <= 3) goto L6;
        int r1 = ((r6 + r5) + 1) >> 1;
        return new c(a(r4, r5, r1), a(r4, r1, r6));
    L6:
        c r3 = new c(r4[r5].b(), r4[r5 + 1].b());
        if (r0 == 3) goto L9;
        return r3;
    L9:
        return new c(r3, r4[r5 + 2].b());
    }

    public static ai a(boolean r2, char r3, Collection<d> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        d[] r0 = new d[r5.size()];
        r5.toArray(r0);
        return new ai(r2, r3, r0);
    }

    @Override // com.ctc.wstx.d.d
    public al a() {
        d[] r0 = this.f3472b;
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        if (r0[r3].d() == false) goto L8;
        r3 = r3 + 1;
    L8:
        if (r3 != r1) goto L14;
        com.ctc.wstx.util.h[] r4 = new com.ctc.wstx.util.h[r1];
    L10:
        if (r2 >= r1) goto L13;
        r4[r2] = ((am) ZeusTransformUtils.preCheckCast(r0[r2], am.class, "com.obric.memorydata.plugin")).f();
        r2 = r2 + 1;
        goto L10
    L13:
        return new a(this.d, r4);
    L14:
        return null;
    }

    @Override // com.ctc.wstx.d.d
    public af b() {
        d[] r0 = this.f3472b;
        af r1 = a(r0, 0, r0.length);
        if (this.d != '*') goto L7;
        return new ak(r1);
    L7:
        if (this.d != '?') goto L11;
        return new ag(r1);
    L11:
        if (this.d == '+') goto L13;
        return r1;
    L13:
        return new c(r1, new ak(r1.a()));
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append('(');
        int r1 = 0;
    L4:
        if (r1 >= this.f3472b.length) goto L8;
        if (r1 <= 0) goto L7;
        r0.append(", ");
    L7:
        r0.append(this.f3472b[r1].toString());
        r1 = r1 + 1;
        goto L4
    L8:
        r0.append(')');
        if (this.d == ' ') goto L12;
        r0.append(this.d);
    L12:
        return r0.toString();
    }
}
