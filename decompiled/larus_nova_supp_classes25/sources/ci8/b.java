package ci8;

import com.larus.common.apphost.AppHost;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final a a() {
        AppHost.Companion r0 = AppHost.a;
        if ((CollectionsKt.last(r0.a().g()) instanceof a) == false) goto L8;
        Object r1 = CollectionsKt.last(r0.a().g());
        if ((r1 instanceof a) == true) goto L7;
        return null;
    L7:
        return (a) r1;
    L8:
        return null;
    }
}
