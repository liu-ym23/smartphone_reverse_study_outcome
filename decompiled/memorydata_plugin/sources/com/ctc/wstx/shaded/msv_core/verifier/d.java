package com.ctc.wstx.shaded.msv_core.verifier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    public static class a extends AbstractC0176d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3679b;
        public final String c;
        public final String d;

        public a(com.ctc.wstx.shaded.msv_core.util.c r1, String r2, String r3, String r4, String r5) {
            super(r1);
            this.f3678a = r2;
            this.f3679b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static class b extends AbstractC0176d {
        public b(com.ctc.wstx.shaded.msv_core.util.c r1) {
            super(r1);
        }
    }

    public static class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3680a;

        public c(String r1) {
            this.f3680a = r1;
        }

        public c(StringBuffer r1) {
            this.f3680a = r1.toString();
        }
    }

    /* JADX INFO: renamed from: com.ctc.wstx.shaded.msv_core.verifier.d$d, reason: collision with other inner class name */
    public static abstract class AbstractC0176d extends d {
        public final String e;
        public final String f;
        public final String g;

        public AbstractC0176d(com.ctc.wstx.shaded.msv_core.util.c r3) {
            this(r3.c, r3.f3641a, r3.f3642b);
        }

        public AbstractC0176d(String r1, String r2, String r3) {
            this.e = r1;
            this.f = r2;
            this.g = r3;
        }
    }

    public static class e extends AbstractC0176d {
        public e(String r1, String r2, String r3) {
            super(r1, r2, r3);
        }
    }

    public static class f extends AbstractC0176d {
        public f(com.ctc.wstx.shaded.msv_core.util.c r1) {
            super(r1);
        }
    }

    public d() {
    }
}
