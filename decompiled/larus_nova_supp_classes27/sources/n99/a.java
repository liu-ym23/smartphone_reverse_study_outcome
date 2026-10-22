package n99;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import q99.c;
import q99.j;
import q99.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface a {

    /* JADX INFO: renamed from: n99.a$a, reason: collision with other inner class name */
    public static final class C0132a implements a {
        public C0132a() {
        }

        @Override // n99.a
        public final void a(c r2, p99.a r3) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r3, "callback");
        }

        @Override // n99.a
        public final void b(k r1, Function1<? super dm9.a<Unit>, Unit> r2) {
            Intrinsics.checkNotNullParameter(r1, "request");
        }

        @Override // n99.a
        public final void c(j r2) {
            Intrinsics.checkNotNullParameter(r2, "request");
        }
    }

    void a(c r1, p99.a r2);

    void b(k r1, Function1<? super dm9.a<Unit>, Unit> r2);

    void c(j r1);
}
