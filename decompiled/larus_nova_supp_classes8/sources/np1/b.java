package np1;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface b {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static b a(Function0 r1, Function1 r2) {
            Intrinsics.checkNotNullParameter(r1, "provider");
            b r3 = (b) r1.invoke();
            if (r2 == null) goto L5;
            Unit r4 = (Unit) r2.invoke(r3);
        L5:
            return r3;
        }
    }

    static {
        a = a.a;
    }

    int getType();
}
