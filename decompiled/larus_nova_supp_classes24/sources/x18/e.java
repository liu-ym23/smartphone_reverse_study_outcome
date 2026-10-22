package x18;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public final d a;

    public static final class a {
        public static final e a = null;

        static {
            a = new e();
        }
    }

    public e() {
        b.a r0 = new b.a();
        TimeUnit r1 = TimeUnit.MILLISECONDS;
        r0.d = 15000;
        r0.e = r1;
        r0.f = 10000;
        r0.g = r1;
        TimeUnit r2 = TimeUnit.MICROSECONDS;
        r0.h = 30000;
        r0.i = r2;
        this.a = new d(r0);
    }
}
