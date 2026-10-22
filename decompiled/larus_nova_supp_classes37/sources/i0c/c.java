package i0c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c<S, E, C, R> extends a<S, E, C, R> {
    public S c;

    public c(h0c.e<S, E, C, R> r2) {
        Intrinsics.checkNotNullParameter(r2, "stateMap");
        super(r2);
    }

    public final void a(com.ss.android.lark.passportc.impl.v2.action.d r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        S r1 = this.c;
        if (r1 == null) goto L14;
        S r3 = this.b;
        if (r3 == null) goto L12;
        e r0 = new e(r1, r3, r5);
        h0c.e<S, E, C, R> r6 = this.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "transition");
        HashMap<S, List<d<S, C, R>>> r7 = r6.a;
        S r2 = r0.a;
        List<d<S, C, R>> r4 = r7.get(r2);
        if (r4 != null) goto L9;
        r4 = new ArrayList();
        r7.put(r2, r4);
    L9:
        TypeIntrinsics.asMutableList(r4).add(r0);
        return;
    L12:
        throw new IllegalArgumentException("Required value was null.".toString());
    L14:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
