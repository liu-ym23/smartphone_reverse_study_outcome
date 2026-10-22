package ou1;

import java.util.Map;
import ju1.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements nu1.d {
    public final nu1.b a;

    public static final class a {
    }

    static {
    }

    public c() {
        nu1.a r0 = nu1.a.a;
        Intrinsics.checkNotNullParameter(r0, "expressionExecutor");
        this.a = r0;
    }

    @Override // nu1.d
    public final boolean b(l r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return r2 instanceof ju1.b;
    }

    @Override // nu1.d
    public final boolean a(l r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "stateMap");
        if ((r2 instanceof ju1.b) == true) goto L7;
        return r2.a();
    L7:
        return Intrinsics.areEqual(this.a.a(((ju1.b) r2).d(), r3), Boolean.TRUE);
    }
}
