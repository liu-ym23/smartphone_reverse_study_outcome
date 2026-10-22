package ud0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class c {

    public static final class a extends c {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends c {
        public final sd0.a a;
        public final int b;
        public final boolean c;

        public final int getType() {
            return this.b;
        }

        public b(sd0.a r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "selectVideo");
            this.a = r2;
            this.b = r3;
            this.c = false;
        }
    }

    public c() {
    }
}
