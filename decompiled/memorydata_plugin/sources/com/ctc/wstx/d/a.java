package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f3454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f3455b;
    final d[] c;

    /* JADX INFO: renamed from: com.ctc.wstx.d.a$a, reason: collision with other inner class name */
    static final class C0174a extends al {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final char f3456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ah f3457b;
        int c;

        public C0174a(char r2, ah r3) {
            this.c = 0;
            this.f3456a = r2;
            this.f3457b = r3;
        }

        @Override // com.ctc.wstx.d.al
        public al a() {
            if (this.f3456a != '*') goto L6;
            return this;
        L6:
            return new C0174a(this.f3456a, this.f3457b);
        }

        @Override // com.ctc.wstx.d.al
        public String a(com.ctc.wstx.util.h r4) {
            if (this.f3457b.a(r4) == false) goto L5;
            int r5 = this.c + 1;
            this.c = r5;
            if (r5 <= 1) goto L20;
            char r6 = this.f3456a;
            if (r6 == '?') goto L17;
            if (r6 == ' ') goto L17;
            return null;
        L17:
            if (this.f3457b.a() == false) goto L19;
            StringBuilder r3 = new StringBuilder().append("Expected $END (already had one of [").append(this.f3457b.a(" | "));
            String r7 = "]";
        L8:
            return r3.append(r7).toString();
        L19:
            r3 = new StringBuilder().append("Expected $END (already had one <").append(this.f3457b.a(""));
            r7 = ">]";
            goto L8
        L20:
            return null;
        L5:
            if (this.f3457b.a() == false) goto L9;
            r3 = new StringBuilder().append("Expected one of (").append(this.f3457b.a(" | "));
            r7 = ")";
            goto L8
        L9:
            r3 = new StringBuilder().append("Expected <").append(this.f3457b.a(""));
            r7 = ">";
            goto L8
        }

        @Override // com.ctc.wstx.d.al
        public String b() {
            char r0 = this.f3456a;
            if (r0 == ' ') goto L12;
            if (r0 != '?') goto L7;
        L10:
            return null;
        L7:
            if (r0 == '*') goto L10;
            if (r0 == '+') goto L12;
            com.ctc.wstx.util.g.a();
        L12:
            if (this.c <= 0) goto L14;
            return null;
        L14:
            StringBuilder r1 = new StringBuilder().append("Expected ");
            if (this.f3456a != '+') goto L17;
            String r2 = "at least";
        L19:
            return r1.append(r2).append(" one of elements (").append(this.f3457b).append(")").toString();
        L17:
            r2 = "";
            goto L19
        }
    }

    private a(boolean r3, char r4, boolean r5, Collection<d> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        super(r4);
        this.f3454a = r3;
        this.f3455b = r5;
        d[] r8 = new d[r7.size()];
        this.c = r8;
        r7.toArray(r8);
    }

    public static a a(boolean r2, char r3, Collection<d> r4) {
        return new a(r2, r3, false, (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin"));
    }

    public static a a(boolean r3, Collection<d> r4) {
        return new a(r3, '*', true, (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin"));
    }

    public static ah a(boolean r6, d[] r7) {
        int r0 = r7.length;
        com.ctc.wstx.util.h[] r1 = new com.ctc.wstx.util.h[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r1[r2] = ((am) ZeusTransformUtils.preCheckCast(r7[r2], am.class, "com.obric.memorydata.plugin")).f();
        r2 = r2 + 1;
        goto L3
    L6:
        if (r0 >= 5) goto L10;
        return new aj(r6, r1);
    L10:
        return new ad(r6, r1);
    }

    @Override // com.ctc.wstx.d.d
    public al a() {
        d[] r0 = this.c;
        int r1 = r0.length;
        if (this.f3455b == false) goto L5;
        int r2 = r1;
    L11:
        if (r2 != r1) goto L14;
        ah r3 = a(this.f3454a, r0);
        return new C0174a(this.d, r3);
    L14:
        return null;
    L5:
        r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        if (r0[r2].d() == false) goto L11;
        r2 = r2 + 1;
        goto L6
    }

    @Override // com.ctc.wstx.d.d
    public af b() {
        d[] r0 = this.c;
        int r1 = r0.length;
        af[] r2 = new af[r1];
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r2[r3] = r0[r3].b();
        r3 = r3 + 1;
        goto L3
    L5:
        b r4 = new b(r2);
        if (this.d != '*') goto L10;
        return new ak(r4);
    L10:
        if (this.d != '?') goto L14;
        return new ag(r4);
    L14:
        if (this.d == '+') goto L16;
        return r4;
    L16:
        return new c(r4, new ak(r4.a()));
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f3455b == false) goto L5;
        r0.append("(#PCDATA | ");
    L6:
        int r1 = 0;
    L8:
        if (r1 >= this.c.length) goto L12;
        if (r1 <= 0) goto L11;
        r0.append(" | ");
    L11:
        r0.append(this.c[r1].toString());
        r1 = r1 + 1;
        goto L8
    L12:
        r0.append(')');
        if (this.d == ' ') goto L16;
        r0.append(this.d);
    L16:
        return r0.toString();
    L5:
        r0.append('(');
        goto L6
    }
}
