package ou1;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements nu1.c<com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.e> {
    public b() {
    }

    @Override // nu1.c
    public final void a(com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g r2, String r3, Map r4) {
        com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.e r5 = (com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.e) r2;
        Intrinsics.checkNotNullParameter(r5, "nfa");
        Intrinsics.checkNotNullParameter(r3, "eventKey");
        Intrinsics.checkNotNullParameter(r4, "eventParams");
        r5.j(r3, r4);
    }
}
