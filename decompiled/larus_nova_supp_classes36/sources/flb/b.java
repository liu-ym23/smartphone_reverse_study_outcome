package flb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final int a;
    public final int b;

    public static final class a {
        public int a;

        public a() {
            this.a = -1;
        }

        public final void a(int r3) {
            boolean r0 = true;
            if (1 <= r3) goto L5;
        L7:
            r0 = false;
        L8:
            if (r0 == false) goto L11;
            this.a = r3;
            return;
        L11:
            return;
        L5:
            if (r3 >= 101) goto L7;
            goto L7
        }
    }

    public b(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
