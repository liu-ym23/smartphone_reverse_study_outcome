package hv8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class c {

    public static final class a extends c {
        public final String a;
        public final String b;

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "endpoint");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends c {
        public final String a;
        public final String b;
        public final String c;

        public b(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "deviceId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public c() {
    }
}
