package np1;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface a {
    public static final C0403a a = null;

    /* JADX INFO: renamed from: np1.a$a, reason: collision with other inner class name */
    public static final class C0403a {
        public static final /* synthetic */ C0403a a = null;

        public C0403a() {
        }

        static {
            a = new C0403a();
        }

        public static a a(Function0 r1, Function1 r2) {
            Intrinsics.checkNotNullParameter(r1, "provider");
            a r3 = (a) r1.invoke();
            if (r2 == null) goto L5;
            Unit r4 = (Unit) r2.invoke(r3);
        L5:
            return r3;
        }
    }

    static {
        a = C0403a.a;
    }

    d<? extends a> a();

    c c();

    int getType();
}
