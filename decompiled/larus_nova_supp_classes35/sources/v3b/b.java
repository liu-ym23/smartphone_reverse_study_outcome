package v3b;

import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements d<w3b.a, i7b.a> {
    @Inject
    public b() {
    }

    @Override // v3b.d
    public final String a(w3b.d r3) {
        w3b.a r4 = (w3b.a) r3;
        Intrinsics.checkNotNullParameter(r4, "task");
        r4.getClass();
        return "ChatDataPreLoadTask_uniqueId:" + r4.b;
    }
}
