package su1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.exception.SimpleExpressException;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements e {
    public final String a;

    public d(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        this.a = r2;
    }

    @Override // su1.e
    public final void a(qu1.a r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "environment");
        Intrinsics.checkNotNullParameter(r4, "context");
        Object r5 = r4.get(this.a);
        if (r5 == null) goto L7;
        ((LinkedList) r3.a).push(r5);
        return;
    L7:
        throw new SimpleExpressException("express execute failed, param[" + this.a + "] is null", null, 2, null);
    }
}
