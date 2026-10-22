package soc;

import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements a {
    public final Set<dxa.c> a;

    @Override // soc.a
    public final List<dxa.c> getInterceptors() {
        Set<dxa.c> r0 = this.a;
        if (r0 == null) goto L7;
        List<dxa.c> r1 = CollectionsKt.toList(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    @Inject
    public c(Set<dxa.c> r1) {
        this.a = r1;
    }
}
