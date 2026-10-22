package n61;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements c {
    public static final /* synthetic */ int d = 0;
    public Integer a;
    public boolean b;
    public final b c;

    /* JADX INFO: renamed from: n61.a$a, reason: collision with other inner class name */
    public static final class C0276a {
        public static a a(b r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "category");
            a r0 = new a(r1);
            r0.a = Integer.valueOf(r2);
            return r0;
        }
    }

    static {
    }

    public final String toString() {
        return "BasicPerfSource(perfType=" + this.c + ", level=" + this.a + ')';
    }

    public a(b r1) {
        this.c = r1;
    }
}
