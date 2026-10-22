package ru1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.exception.SimpleExpressException;
import java.util.ArrayList;
import java.util.List;
import su1.d;
import su1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(tu1.b r2, List r3) {
        tu1.b r0 = r2.c;
        if (r0 == null) goto L5;
        a(r0, r3);
    L5:
        tu1.b r1 = r2.d;
        if (r1 == null) goto L9;
        a(r1, r3);
    L9:
        switch(a.a[r2.getType().ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L12;
            default: goto L11;
        };
    L12:
        Object r4 = r2.b;
        if (r4 == null) goto L16;
        Object r5 = new su1.b((String) r4);
    L23:
        ((ArrayList) r3).add(r5);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L17:
        r5 = new f();
        goto L23
    L18:
        r5 = new su1.a();
        goto L23
    L19:
        r5 = new su1.c(r2.b);
        goto L23
    L20:
        Object r6 = r2.b;
        if (r6 == null) goto L26;
        r5 = new d((String) r6);
        goto L23
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L11:
        throw new SimpleExpressException("create operation failed, unknown type " + r2.getType(), null, 2, null);
    }
}
