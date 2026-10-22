package ip0;

import java.util.Iterator;
import java.util.List;
import kotlin.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c a(Object r5, long r6) {
        Object r1 = null;
        if (Result.isFailure-impl(r5) == false) goto L5;
        r5 = null;
    L5:
        b r7 = (b) r5;
        if (r7 == null) goto L25;
        List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c> r8 = r7.c;
        if (r8 == null) goto L26;
        Iterator<T> r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L19;
        Object r0 = r9.next();
        if (((com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c) r0).groupId != r6) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L11;
        r1 = r0;
        goto L19
    L15:
        r2 = false;
    L19:
        return (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c) r1;
    L26:
        return null;
    L25:
        return null;
    }
}
