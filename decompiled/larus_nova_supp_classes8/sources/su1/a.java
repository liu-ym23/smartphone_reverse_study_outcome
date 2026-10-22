package su1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.exception.SimpleExpressException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements e {
    public a() {
    }

    public final boolean b(qu1.a r6) {
        if (r6.a.isEmpty() == true) goto L11;
        Object r7 = ((LinkedList) r6.a).pop();
        if ((r7 instanceof Boolean) == false) goto L9;
        return ((Boolean) r7).booleanValue();
    L9:
        throw new SimpleExpressException("express execute failed, and operation value is " + r7, null, 2, null);
    L11:
        throw new SimpleExpressException("express execute failed, and operation value is null", null, 2, null);
    }

    @Override // su1.e
    public final void a(qu1.a r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "environment");
        Intrinsics.checkNotNullParameter(r3, "context");
        boolean r4 = b(r2);
        boolean r0 = b(r2);
        Deque<Object> r5 = r2.a;
        if (r0 == false) goto L6;
        if (r4 == false) goto L6;
        boolean r6 = true;
    L7:
        LinkedList r7 = (LinkedList) r5;
        r7.push(Boolean.valueOf(r6));
        return;
    L6:
        r6 = false;
        goto L7
    }
}
