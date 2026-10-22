package dz7;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public final b a;
    public final String b;
    public final a c;
    public final String d;
    public final Map<String, Long> e;
    public final Map<String, Long> f;

    public static final class a {
        public String a;
        public String b;

        public a() {
        }
    }

    public static final class b {
        public int a;
        public Integer b;
        public String c;

        public b() {
            this.b = 0;
        }
    }

    public /* synthetic */ c(b r8, String r9, a r10, String r11, int r12) {
        if ((r12 & 8) == 0) goto L5;
        r11 = "";
    L5:
        this(r8, r9, r10, r11, null, null);
    }

    public c(b r2, String r3, a r4, String r5, Map<String, Long> r6, Map<String, Long> r7) {
        Intrinsics.checkNotNullParameter(r5, "resultMsg");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
