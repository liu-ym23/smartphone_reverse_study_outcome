package e19;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface i {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(i r1, Function0 r2, int r3) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            r1.a(null, r2);
        }
    }

    void a(String r1, Function0<Unit> r2);
}
