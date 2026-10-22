package d68;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new b());
    }

    public static void a(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        int r0 = c68.b.a;
        c68.b.d("FlowTtsMobHelper", "FlowTtsMobHelper addTtsToAudioPlayStepStart msgId=".concat(r2));
        ((List) a.getValue()).add(r2);
    }
}
