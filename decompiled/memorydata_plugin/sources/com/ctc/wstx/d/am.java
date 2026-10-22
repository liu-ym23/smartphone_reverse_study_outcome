package com.ctc.wstx.d;

/* JADX INFO: loaded from: classes2.dex */
public class am extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final am f3478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final com.ctc.wstx.util.h f3479b;

    static final class a extends al {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final char f3480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.ctc.wstx.util.h f3481b;
        int c;

        public a(char r2, com.ctc.wstx.util.h r3) {
            this.c = 0;
            this.f3480a = r2;
            this.f3481b = r3;
        }

        @Override // com.ctc.wstx.d.al
        public al a() {
            if (this.f3480a != '*') goto L6;
            return this;
        L6:
            return new a(this.f3480a, this.f3481b);
        }

        @Override // com.ctc.wstx.d.al
        public String a(com.ctc.wstx.util.h r3) {
            if (r3.equals(this.f3481b) == true) goto L7;
            StringBuilder r4 = new StringBuilder();
            String r1 = "Expected element <";
        L6:
            return r4.append(r1).append(this.f3481b).append(">").toString();
        L7:
            int r5 = this.c + 1;
            this.c = r5;
            if (r5 <= 1) goto L14;
            char r6 = this.f3480a;
            if (r6 != '?') goto L12;
        L13:
            r4 = new StringBuilder();
            r1 = "More than one instance of element <";
            goto L6
        L12:
            if (r6 == ' ') goto L13;
            return null;
        L14:
            return null;
        }

        @Override // com.ctc.wstx.d.al
        public String b() {
            char r0 = this.f3480a;
            if (r0 == ' ') goto L14;
            if (r0 != '?') goto L7;
        L12:
            return null;
        L7:
            if (r0 == '*') goto L12;
            if (r0 == '+') goto L14;
            throw new IllegalStateException(com.ctc.wstx.b.a.m);
        L14:
            if (this.c <= 0) goto L16;
            return null;
        L16:
            StringBuilder r1 = new StringBuilder().append("Expected ");
            if (this.f3480a != '+') goto L19;
            String r2 = "at least one";
        L21:
            return r1.append(r2).append(" element <").append(this.f3481b).append(">").toString();
        L19:
            r2 = "";
            goto L21
        }
    }

    static {
        f3478a = new am(' ', new com.ctc.wstx.util.h("*", "*"));
    }

    public am(char r1, com.ctc.wstx.util.h r2) {
        super(r1);
        this.f3479b = r2;
    }

    public static am a(char r1, com.ctc.wstx.util.h r2) {
        return new am(r1, r2);
    }

    public static am e() {
        return f3478a;
    }

    @Override // com.ctc.wstx.d.d
    public al a() {
        return new a(this.d, this.f3479b);
    }

    @Override // com.ctc.wstx.d.d
    public af b() {
        an r0 = new an(this.f3479b);
        if (this.d != '*') goto L7;
        return new ak(r0);
    L7:
        if (this.d != '?') goto L11;
        return new ag(r0);
    L11:
        if (this.d == '+') goto L13;
        return r0;
    L13:
        return new c(r0, new ak(new an(this.f3479b)));
    }

    @Override // com.ctc.wstx.d.d
    public boolean d() {
        if (this.d != ' ') goto L5;
        return true;
    L5:
        return false;
    }

    public com.ctc.wstx.util.h f() {
        return this.f3479b;
    }

    public String toString() {
        if (this.d != ' ') goto L6;
        return this.f3479b.toString();
    L6:
        return this.f3479b.toString() + this.d;
    }
}
