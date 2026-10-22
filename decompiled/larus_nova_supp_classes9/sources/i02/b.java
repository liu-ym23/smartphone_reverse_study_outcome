package i02;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ int e = 0;
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final int d;

    public static final class a {
        public a() {
        }

        public static b a(int r2) {
            return new b(false, false, false, r2);
        }
    }

    static {
        new a();
    }

    public final String toString() {
        return "hasTriggerPlay:" + this.a + ", isEffectPaused:" + this.b;
    }

    public /* synthetic */ b(boolean r4) {
        this(r4, false, true, -1);
    }

    public b(boolean r1, boolean r2, boolean r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
